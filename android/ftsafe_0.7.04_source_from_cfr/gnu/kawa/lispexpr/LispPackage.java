/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.commonlisp.lang.CommonLisp;
import gnu.kawa.lispexpr.NamespaceUse;
import gnu.lists.AbstractSequence;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.SeqPosition;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.Values;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LispPackage
extends Namespace {
    public Namespace exported = new Namespace();
    LList nicknames = LList.Empty;
    private static final Object masterLock = new Object();
    LList shadowingSymbols = LList.Empty;
    public static final LispPackage CLNamespace = LispPackage.valueOf("COMMON-LISP");
    public static final LispPackage KeywordNamespace = LispPackage.valueOf("KEYWORD");
    public static final LispPackage KawaNamespace = LispPackage.valueOf("KAWA");
    public static final LispPackage ClassNamespace = LispPackage.valueOf("CLASS");
    public static ThreadLocation<LispPackage> currentPackage = new ThreadLocation("*package*");
    NamespaceUse imported;
    NamespaceUse importing;

    public void setExportedNamespace(Namespace exp) {
        this.exported = exp;
    }

    public LList getShadowingSymbols() {
        return this.shadowingSymbols;
    }

    public static LList pkgUsesList(LispPackage lp) {
        LList uses = LList.Empty;
        NamespaceUse it = lp.imported;
        while (it != null) {
            uses = Pair.make(it.imported, uses);
            it = it.nextImported;
        }
        return uses;
    }

    public static LList pkgUsedByList(LispPackage lp) {
        LList usedby = LList.Empty;
        NamespaceUse it = lp.importing;
        while (it != null) {
            usedby = Pair.make(it.importing, usedby);
            it = it.nextImporting;
        }
        return usedby;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void addNickNames(LispPackage name, LList nicks) {
        Hashtable hashtable2 = nsTable;
        synchronized (hashtable2) {
            for (Object nick : nicks) {
                name.nicknames = Pair.make((String)nick, name.nicknames);
                nsTable.put((String)nick, name);
            }
        }
    }

    public static void usePackages(LList importees, LispPackage importer) {
        for (Object usePkg : importees) {
            LispPackage lp = usePkg instanceof Symbol ? (LispPackage)LispPackage.valueOfNoCreate(((Symbol)usePkg).getName()) : (usePkg instanceof LispPackage ? (LispPackage)usePkg : (LispPackage)LispPackage.valueOfNoCreate((String)usePkg));
            if (lp != null) {
                LispPackage.use(importer, lp);
                continue;
            }
            throw new RuntimeException("The name " + usePkg + " does not designate any package");
        }
    }

    public static LispPackage makeLispPackage(Object name, LList nicks, LList used) {
        LispPackage newpack = LispPackage.valueOf((String)name);
        LispPackage.addNickNames(newpack, nicks);
        LispPackage.usePackages(used, newpack);
        return newpack;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static LispPackage valueOf(String name) {
        if (name == null) {
            name = "";
        }
        Hashtable hashtable2 = nsTable;
        synchronized (hashtable2) {
            Namespace ns = (Namespace)nsTable.get(name);
            if (ns != null) {
                return (LispPackage)ns;
            }
            ns = new LispPackage();
            ns.setName(name.intern());
            Namespace.nsTable.put(name, ns);
            return (LispPackage)ns;
        }
    }

    public static Namespace valueOfNoCreate(String name) {
        return (LispPackage)Namespace.valueOfNoCreate(name);
    }

    public Values.Values2 findSymbol(Object name) {
        String sname = name.toString();
        Symbol sym = this.exported.lookup(sname);
        if (sym != null) {
            return Values.values2(sym, CommonLisp.externalKeyword);
        }
        sym = this.lookupInternal(sname, sname.hashCode());
        if (sym != null) {
            return Values.values2(sym, CommonLisp.internalKeyword);
        }
        NamespaceUse U = this.imported;
        while (U != null) {
            sym = U.imported == KawaNamespace ? U.imported.exported.lookup(sname.toLowerCase()) : U.imported.exported.lookup(sname);
            if (sym != null) {
                return Values.values2(sym, CommonLisp.inheritedKeyword);
            }
            U = U.nextImported;
        }
        return Values.values2(CommonLisp.FALSE, CommonLisp.FALSE);
    }

    public static void exportPkg(LList syms, LispPackage pkg) {
        Values.Values2 v;
        Symbol s;
        Stack<Symbol> validSyms = new Stack<Symbol>();
        SeqPosition symiter = syms.getIterator();
        while (symiter.hasNext()) {
            s = (Symbol)symiter.next();
            v = pkg.findSymbol(s.getName());
            if (((AbstractSequence)v).get(1) == CommonLisp.FALSE || validSyms.contains(s)) continue;
            validSyms.push(s);
        }
        NamespaceUse usedBy = pkg.imported;
        symiter = syms.getIterator();
        while (symiter.hasNext()) {
            s = (Symbol)symiter.next();
            String sname = s.getName();
            while (usedBy != null) {
                v = usedBy.imported.findSymbol(sname);
                if (((AbstractSequence)v).get(1) != CommonLisp.FALSE && ((AbstractSequence)v).get(0) != s && !usedBy.imported.shadowingSymbols.contains(((AbstractSequence)v).get(0))) {
                    LispPackage.signal("Name conflict from package " + usedBy.imported + "on symbol" + s);
                }
                usedBy = usedBy.nextImported;
            }
        }
        Stack<Symbol> missing = new Stack<Symbol>();
        Stack<Symbol> imports = new Stack<Symbol>();
        symiter = syms.getIterator();
        while (symiter.hasNext()) {
            s = (Symbol)symiter.next();
            v = pkg.findSymbol(s.getName());
            if (((AbstractSequence)v).get(1) == CommonLisp.FALSE && ((AbstractSequence)v).get(0).hashCode() != s.hashCode()) {
                missing.push(s);
                continue;
            }
            if (((AbstractSequence)v).get(1) != LispPackage.valueOf("inherited")) continue;
            imports.push(s);
        }
        if (!missing.isEmpty()) {
            LispPackage.signal("The following symbols are missing: " + missing.toString());
        }
        while (!imports.isEmpty()) {
            Symbol sym = (Symbol)imports.pop();
            pkg.exported.add(sym, sym.hashCode());
        }
        while (!validSyms.isEmpty()) {
            s = (Symbol)validSyms.pop();
            pkg.remove(s);
            pkg.exported.add(s, s.hashCode());
        }
    }

    public static void importPkg(LList syms, LispPackage pkg) {
        Symbol s;
        Stack<Symbol> validSyms = new Stack<Symbol>();
        SeqPosition symiter = syms.getIterator();
        while (symiter.hasNext()) {
            s = (Symbol)symiter.next();
            Values.Values2 v = pkg.findSymbol(s.getName());
            if (((AbstractSequence)v).get(1) == CommonLisp.FALSE) {
                SeqPosition symiter2 = syms.getIterator();
                boolean found = false;
                while (symiter2.hasNext()) {
                    Symbol s2 = (Symbol)symiter2.next();
                    if (!s.getName().equals(s2.getName()) || s == s2) continue;
                    validSyms.remove(s2);
                    LispPackage.signal("Symbol " + s2 + " conflicts with this package.");
                }
                if (found) continue;
                validSyms.push(s);
                continue;
            }
            if (((AbstractSequence)v).get(0) != s) {
                LispPackage.signal("Symbol " + ((AbstractSequence)v).get(0) + " conflicts in this package");
                continue;
            }
            if (((AbstractSequence)v).get(1) != LispPackage.valueOf("inherited")) continue;
            validSyms.add(s);
        }
        while (!validSyms.isEmpty()) {
            Symbol sym = (Symbol)validSyms.pop();
            pkg.add(sym, sym.hashCode());
        }
        symiter = syms.getIterator();
        while (symiter.hasNext()) {
            s = (Symbol)symiter.next();
            if (s.getNamespace() != null) continue;
            s.setNamespace(pkg);
        }
    }

    public LList allSymbols(Namespace ns) {
        LList res = LList.Empty;
        Iterator symNameIter = ns.entrySet().iterator();
        while (symNameIter.hasNext()) {
            res = Pair.make(symNameIter.next(), res);
        }
        return res;
    }

    public LList allExternalSymbols() {
        return this.allSymbols(this.exported);
    }

    public LList allInternalSymbols() {
        return this.allSymbols(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void use(LispPackage importing, LispPackage imported) {
        Object object2 = masterLock;
        synchronized (object2) {
            NamespaceUse use = new NamespaceUse();
            use.nextImporting = imported.importing;
            use.importing = importing;
            imported.importing = use;
            use.nextImported = importing.imported;
            use.imported = imported;
            importing.imported = use;
        }
    }

    @Override
    public Symbol lookup(String name, int hash, boolean create) {
        Symbol sym = this.exported.lookup(name, hash, false);
        if (sym != null) {
            return sym;
        }
        sym = this.lookupInternal(name, hash);
        if (sym != null) {
            return sym;
        }
        NamespaceUse used = this.imported;
        while (used != null) {
            sym = this.lookup(name, hash, false);
            if (sym != null) {
                return sym;
            }
            used = used.nextImported;
        }
        if (create) {
            return this.add(Symbol.makeUninterned(name, this), hash);
        }
        return null;
    }

    public Symbol lookupPresent(String name, int hash, boolean intern) {
        Symbol sym = this.exported.lookup(name, hash, false);
        if (sym == null) {
            sym = super.lookup(name, hash, intern);
        }
        return sym;
    }

    public boolean isPresent(String name) {
        return this.lookupPresent(name, name.hashCode(), false) != null;
    }

    public boolean unintern(Symbol symbol) {
        int hash;
        String name = symbol.getName();
        if (this.exported.lookup(name, hash = name.hashCode(), false) == symbol) {
            this.exported.remove(symbol);
        } else if (super.lookup(name, hash, false) == symbol) {
            super.remove(symbol);
        } else {
            return false;
        }
        symbol.setNamespace(null);
        if (this.removeFromShadowingSymbols(symbol)) {
            // empty if block
        }
        return true;
    }

    private void addToShadowingSymbols(Symbol sym) {
        Object s = this.shadowingSymbols;
        while (s != LList.Empty) {
            Pair p = (Pair)s;
            if (p.getCar() == sym) {
                return;
            }
            s = p.getCdr();
        }
        this.shadowingSymbols = new Pair(sym, this.shadowingSymbols);
    }

    private boolean removeFromShadowingSymbols(Symbol sym) {
        Pair prev = null;
        Object s = this.shadowingSymbols;
        while (s != LList.Empty) {
            Pair p = (Pair)s;
            s = p.getCdr();
            if (p.getCar() == sym) {
                if (prev == null) {
                    this.shadowingSymbols = (LList)s;
                } else {
                    prev.setCdr(s);
                }
                return true;
            }
            prev = p;
        }
        return false;
    }

    public void shadow(String name) {
        Symbol sym = this.lookupPresent(name, name.hashCode(), true);
        this.addToShadowingSymbols(sym);
    }

    public void shadowingImport(Symbol symbol) {
        String name = symbol.getName();
        int hash = name.hashCode();
        Symbol old = this.lookupPresent(name, name.hashCode(), false);
        if (old != null && old != symbol) {
            this.unintern(old);
        }
        this.addToShadowingSymbols(symbol);
    }

    public static void signal(String msg) {
        throw new RuntimeException(msg);
    }

    static {
        nsTable.put("CL", CLNamespace);
        LispPackage.CLNamespace.nicknames = Pair.make("CL", LispPackage.CLNamespace.nicknames);
        KawaNamespace.setExportedNamespace(EmptyNamespace);
        LispPackage.use(CLNamespace, KawaNamespace);
        LispPackage.use(CLNamespace, ClassNamespace);
        currentPackage.setGlobal(CLNamespace);
    }
}

