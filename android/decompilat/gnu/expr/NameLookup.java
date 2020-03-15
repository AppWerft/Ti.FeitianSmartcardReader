// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import java.util.List;
import gnu.kawa.util.HashNode;
import gnu.mapping.Environment;
import gnu.kawa.util.WeakIdentityHashMap;
import gnu.kawa.util.GeneralHashTable;

public class NameLookup extends GeneralHashTable<Object, Declaration>
{
    Language language;
    private static WeakIdentityHashMap<Environment, NameLookup> instanceMap;
    int saveToplevelsRedefsCount;
    
    public Language getLanguage() {
        return this.language;
    }
    
    public void setLanguage(final Language language) {
        this.language = language;
    }
    
    public NameLookup(final Language language) {
        this.saveToplevelsRedefsCount = 0;
        this.language = language;
    }
    
    public static synchronized NameLookup getInstance(final Environment env, final Language language) {
        if (NameLookup.instanceMap == null) {
            NameLookup.instanceMap = new WeakIdentityHashMap<Environment, NameLookup>();
        }
        NameLookup nl = NameLookup.instanceMap.get(env);
        if (nl == null) {
            nl = new NameLookup(language);
            NameLookup.instanceMap.put(env, nl);
        }
        else {
            nl.setLanguage(language);
        }
        return nl;
    }
    
    public static synchronized void setInstance(final Environment env, final NameLookup instance) {
        if (NameLookup.instanceMap == null) {
            NameLookup.instanceMap = new WeakIdentityHashMap<Environment, NameLookup>();
        }
        if (instance == null) {
            NameLookup.instanceMap.remove(env);
        }
        else {
            NameLookup.instanceMap.put(env, instance);
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
    
    public void push(final Declaration decl) {
        final Object symbol = decl.getSymbol();
        if (symbol == null) {
            return;
        }
        if (++this.num_bindings >= ((HashNode[])this.table).length) {
            this.rehash();
        }
        final int hash = this.hash(symbol);
        final HashNode<Object, Declaration> node = this.makeEntry(symbol, hash, decl);
        final int index = this.hashToIndex(hash);
        if (decl.getContext() instanceof ModuleExp && !this.doSaveTopLevelRedefs()) {
            final int dnamespace = this.language.getNamespaceOf(decl);
            HashNode<Object, Declaration> prevNode = null;
            HashNode<Object, Declaration> oldNext;
            for (HashNode<Object, Declaration> oldNode = (HashNode<Object, Declaration>)((HashNode[])this.table)[index]; oldNode != null; oldNode = oldNext) {
                final Declaration oldDecl = oldNode.getValue();
                oldNext = oldNode.next;
                if (oldDecl != null && decl.getSymbol() == oldDecl.getSymbol() && oldDecl.getContext() instanceof ModuleExp && decl.getContext() != oldDecl.getContext() && dnamespace == this.language.getNamespaceOf(oldDecl)) {
                    if (prevNode == null) {
                        ((HashNode[])this.table)[index] = oldNext;
                    }
                    else {
                        prevNode.next = oldNext;
                    }
                    --this.num_bindings;
                    break;
                }
                prevNode = oldNode;
            }
        }
        node.next = (HashNode<Object, Declaration>)((HashNode[])this.table)[index];
        ((HashNode[])this.table)[index] = node;
    }
    
    public boolean pop(final Declaration decl) {
        final Object symbol = decl.getSymbol();
        if (symbol == null) {
            return false;
        }
        final int hash = this.hash(symbol);
        HashNode prev = null;
        final int index = this.hashToIndex(hash);
        HashNode next;
        for (HashNode node = ((HashNode[])this.table)[index]; node != null; node = next) {
            next = node.next;
            if (node.getValue() == decl) {
                if (prev == null) {
                    ((HashNode[])this.table)[index] = next;
                }
                else {
                    prev.next = next;
                }
                --this.num_bindings;
                return true;
            }
            prev = node;
        }
        return false;
    }
    
    public void push(final ScopeExp exp) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            this.push(decl);
        }
    }
    
    public void pop(final ScopeExp exp) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            this.pop(decl);
        }
    }
    
    public void removeSubsumed(final Declaration decl) {
        final Object symbol = decl.getSymbol();
        final int hash = this.hash(symbol);
        final int index = this.hashToIndex(hash);
        HashNode prev = null;
        HashNode next;
        for (HashNode node = ((HashNode[])this.table)[index]; node != null; node = next) {
            next = node.next;
            final Declaration ndecl = node.getValue();
            if (ndecl != decl && this.subsumedBy(decl, ndecl)) {
                if (prev == null) {
                    ((HashNode[])this.table)[index] = next;
                }
                else {
                    prev.next = next;
                }
            }
            else {
                prev = node;
            }
        }
    }
    
    protected boolean subsumedBy(final Declaration decl, final Declaration other) {
        return decl.getSymbol() == other.getSymbol() && (this.language.getNamespaceOf(decl) & this.language.getNamespaceOf(other)) != 0x0;
    }
    
    public Declaration lookup(final Object symbol, final int namespace) {
        final int hash = this.hash(symbol);
        final int index = this.hashToIndex(hash);
        for (HashNode node = ((HashNode[])this.table)[index]; node != null; node = node.next) {
            final Declaration decl = node.getValue();
            if (symbol.equals(decl.getSymbol()) && this.language.hasNamespace(decl, namespace)) {
                return decl;
            }
        }
        return null;
    }
    
    public Declaration lookup(final Object symbol, final boolean function) {
        return this.lookup(symbol, function ? 2 : 1);
    }
    
    public void getCompletingSymbols(final String initialPart, final int namespace, final List<? super String> candidates) {
        int index = ((HashNode[])this.table).length;
        while (--index >= 0) {
            for (HashNode node = ((HashNode[])this.table)[index]; node != null; node = node.next) {
                final Declaration decl = node.getValue();
                final String symbol = decl.getSymbol().toString();
                if (symbol.startsWith(initialPart) && this.language.hasNamespace(decl, namespace)) {
                    candidates.add(symbol);
                }
            }
        }
    }
}
