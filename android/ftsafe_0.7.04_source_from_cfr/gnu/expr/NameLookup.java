/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.Declaration;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.kawa.util.GeneralHashTable;
import gnu.kawa.util.HashNode;
import gnu.kawa.util.WeakIdentityHashMap;
import gnu.mapping.Environment;
import java.util.List;
import java.util.Map;

public class NameLookup
extends GeneralHashTable<Object, Declaration> {
    Language language;
    private static WeakIdentityHashMap<Environment, NameLookup> instanceMap;
    int saveToplevelsRedefsCount = 0;

    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public NameLookup(Language language) {
        this.language = language;
    }

    public static synchronized NameLookup getInstance(Environment env, Language language) {
        NameLookup nl;
        if (instanceMap == null) {
            instanceMap = new WeakIdentityHashMap();
        }
        if ((nl = (NameLookup)instanceMap.get(env)) == null) {
            nl = new NameLookup(language);
            instanceMap.put(env, nl);
        } else {
            nl.setLanguage(language);
        }
        return nl;
    }

    public static synchronized void setInstance(Environment env, NameLookup instance) {
        if (instanceMap == null) {
            instanceMap = new WeakIdentityHashMap();
        }
        if (instance == null) {
            instanceMap.remove(env);
        } else {
            instanceMap.put(env, instance);
        }
    }

    public boolean doSaveTopLevelRedefs() {
        return this.saveToplevelsRedefsCount > 0;
    }

    public void pushSaveTopLevelRedefs() {
        ++this.saveToplevelsRedefsCount;
    }

    public void popSaveTopLevelRedefs() {
        --this.saveToplevelsRedefsCount;
    }

    public void push(Declaration decl) {
        Object symbol = decl.getSymbol();
        if (symbol == null) {
            return;
        }
        if (++this.num_bindings >= ((HashNode[])this.table).length) {
            this.rehash();
        }
        int hash = this.hash(symbol);
        Map.Entry node = this.makeEntry(symbol, hash, decl);
        int index = this.hashToIndex(hash);
        if (decl.getContext() instanceof ModuleExp && !this.doSaveTopLevelRedefs()) {
            int dnamespace = this.language.getNamespaceOf(decl);
            HashNode prevNode = null;
            HashNode oldNode = ((HashNode[])this.table)[index];
            while (oldNode != null) {
                Declaration oldDecl = (Declaration)oldNode.getValue();
                HashNode oldNext = oldNode.next;
                if (oldDecl != null && decl.getSymbol() == oldDecl.getSymbol() && oldDecl.getContext() instanceof ModuleExp && decl.getContext() != oldDecl.getContext() && dnamespace == this.language.getNamespaceOf(oldDecl)) {
                    if (prevNode == null) {
                        ((HashNode[])this.table)[index] = oldNext;
                    } else {
                        prevNode.next = oldNext;
                    }
                    --this.num_bindings;
                    break;
                }
                prevNode = oldNode;
                oldNode = oldNext;
            }
        }
        ((HashNode)node).next = ((HashNode[])this.table)[index];
        ((HashNode[])this.table)[index] = node;
    }

    public boolean pop(Declaration decl) {
        Object symbol = decl.getSymbol();
        if (symbol == null) {
            return false;
        }
        int hash = this.hash(symbol);
        HashNode prev = null;
        int index = this.hashToIndex(hash);
        HashNode node = ((HashNode[])this.table)[index];
        while (node != null) {
            HashNode next = node.next;
            if (node.getValue() == decl) {
                if (prev == null) {
                    ((HashNode[])this.table)[index] = next;
                } else {
                    prev.next = next;
                }
                --this.num_bindings;
                return true;
            }
            prev = node;
            node = next;
        }
        return false;
    }

    public void push(ScopeExp exp) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            this.push(decl);
        }
    }

    public void pop(ScopeExp exp) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            this.pop(decl);
        }
    }

    public void removeSubsumed(Declaration decl) {
        Object symbol = decl.getSymbol();
        int hash = this.hash(symbol);
        int index = this.hashToIndex(hash);
        HashNode prev = null;
        HashNode node = ((HashNode[])this.table)[index];
        while (node != null) {
            HashNode next = node.next;
            Declaration ndecl = (Declaration)node.getValue();
            if (ndecl != decl && this.subsumedBy(decl, ndecl)) {
                if (prev == null) {
                    ((HashNode[])this.table)[index] = next;
                } else {
                    prev.next = next;
                }
            } else {
                prev = node;
            }
            node = next;
        }
    }

    protected boolean subsumedBy(Declaration decl, Declaration other) {
        return decl.getSymbol() == other.getSymbol() && (this.language.getNamespaceOf(decl) & this.language.getNamespaceOf(other)) != 0;
    }

    public Declaration lookup(Object symbol, int namespace) {
        int hash = this.hash(symbol);
        int index = this.hashToIndex(hash);
        HashNode node = ((HashNode[])this.table)[index];
        while (node != null) {
            Declaration decl = (Declaration)node.getValue();
            if (symbol.equals(decl.getSymbol()) && this.language.hasNamespace(decl, namespace)) {
                return decl;
            }
            node = node.next;
        }
        return null;
    }

    public Declaration lookup(Object symbol, boolean function2) {
        return this.lookup(symbol, function2 ? 2 : 1);
    }

    public void getCompletingSymbols(String initialPart, int namespace, List<? super String> candidates) {
        int index = ((HashNode[])this.table).length;
        while (--index >= 0) {
            HashNode node = ((HashNode[])this.table)[index];
            while (node != null) {
                Declaration decl = (Declaration)node.getValue();
                String symbol = decl.getSymbol().toString();
                if (symbol.startsWith(initialPart) && this.language.hasNamespace(decl, namespace)) {
                    candidates.add(symbol);
                }
                node = node.next;
            }
        }
    }
}

