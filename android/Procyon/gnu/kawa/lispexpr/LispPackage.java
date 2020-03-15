// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import gnu.kawa.util.AbstractHashTable;
import java.util.Stack;
import gnu.commonlisp.lang.CommonLisp;
import gnu.mapping.Values;
import gnu.mapping.Symbol;
import java.util.Iterator;
import gnu.lists.Pair;
import gnu.mapping.ThreadLocation;
import gnu.lists.LList;
import gnu.mapping.Namespace;

public class LispPackage extends Namespace
{
    public Namespace exported;
    LList nicknames;
    private static final Object masterLock;
    LList shadowingSymbols;
    public static final LispPackage CLNamespace;
    public static final LispPackage KeywordNamespace;
    public static final LispPackage KawaNamespace;
    public static final LispPackage ClassNamespace;
    public static ThreadLocation<LispPackage> currentPackage;
    NamespaceUse imported;
    NamespaceUse importing;
    
    public LispPackage() {
        this.exported = new Namespace();
        this.nicknames = LList.Empty;
        this.shadowingSymbols = LList.Empty;
    }
    
    public void setExportedNamespace(final Namespace exp) {
        this.exported = exp;
    }
    
    public LList getShadowingSymbols() {
        return this.shadowingSymbols;
    }
    
    public static LList pkgUsesList(final LispPackage lp) {
        LList uses = LList.Empty;
        for (NamespaceUse it = lp.imported; it != null; it = it.nextImported) {
            uses = Pair.make(it.imported, uses);
        }
        return uses;
    }
    
    public static LList pkgUsedByList(final LispPackage lp) {
        LList usedby = LList.Empty;
        for (NamespaceUse it = lp.importing; it != null; it = it.nextImporting) {
            usedby = Pair.make(it.importing, usedby);
        }
        return usedby;
    }
    
    public static void addNickNames(final LispPackage name, final LList nicks) {
        synchronized (LispPackage.nsTable) {
            for (final Object nick : nicks) {
                name.nicknames = Pair.make(nick, name.nicknames);
                LispPackage.nsTable.put(nick, name);
            }
        }
    }
    
    public static void usePackages(final LList importees, final LispPackage importer) {
        for (final Object usePkg : importees) {
            LispPackage lp;
            if (usePkg instanceof Symbol) {
                lp = (LispPackage)valueOfNoCreate(((Symbol)usePkg).getName());
            }
            else if (usePkg instanceof LispPackage) {
                lp = (LispPackage)usePkg;
            }
            else {
                lp = (LispPackage)valueOfNoCreate((String)usePkg);
            }
            if (lp == null) {
                throw new RuntimeException("The name " + usePkg + " does not designate any package");
            }
            use(importer, lp);
        }
    }
    
    public static LispPackage makeLispPackage(final Object name, final LList nicks, final LList used) {
        final LispPackage newpack = valueOf((String)name);
        addNickNames(newpack, nicks);
        usePackages(used, newpack);
        return newpack;
    }
    
    public static LispPackage valueOf(String name) {
        if (name == null) {
            name = "";
        }
        synchronized (LispPackage.nsTable) {
            Namespace ns = LispPackage.nsTable.get(name);
            if (ns != null) {
                return (LispPackage)ns;
            }
            ns = new LispPackage();
            ns.setName(name.intern());
            Namespace.nsTable.put(name, ns);
            return (LispPackage)ns;
        }
    }
    
    public static Namespace valueOfNoCreate(final String name) {
        return Namespace.valueOfNoCreate(name);
    }
    
    public Values.Values2 findSymbol(final Object name) {
        final String sname = name.toString();
        Symbol sym = this.exported.lookup(sname);
        if (sym != null) {
            return Values.values2(sym, CommonLisp.externalKeyword);
        }
        sym = this.lookupInternal(sname, sname.hashCode());
        if (sym != null) {
            return Values.values2(sym, CommonLisp.internalKeyword);
        }
        for (NamespaceUse U = this.imported; U != null; U = U.nextImported) {
            if (U.imported == LispPackage.KawaNamespace) {
                sym = U.imported.exported.lookup(sname.toLowerCase());
            }
            else {
                sym = U.imported.exported.lookup(sname);
            }
            if (sym != null) {
                return Values.values2(sym, CommonLisp.inheritedKeyword);
            }
        }
        return Values.values2(CommonLisp.FALSE, CommonLisp.FALSE);
    }
    
    public static void exportPkg(final LList syms, final LispPackage pkg) {
        final Stack<Symbol> validSyms = new Stack<Symbol>();
        Iterator symiter = syms.getIterator();
        while (symiter.hasNext()) {
            final Symbol s = symiter.next();
            final Values v = pkg.findSymbol(s.getName());
            if (v.get(1) != CommonLisp.FALSE && !validSyms.contains(s)) {
                validSyms.push(s);
            }
        }
        NamespaceUse usedBy = pkg.imported;
        symiter = syms.getIterator();
        while (symiter.hasNext()) {
            final Symbol s = symiter.next();
            final String sname = s.getName();
            while (usedBy != null) {
                final Values v = usedBy.imported.findSymbol(sname);
                if (v.get(1) != CommonLisp.FALSE && v.get(0) != s && !usedBy.imported.shadowingSymbols.contains(v.get(0))) {
                    signal("Name conflict from package " + usedBy.imported + "on symbol" + s);
                }
                usedBy = usedBy.nextImported;
            }
        }
        final Stack<Symbol> missing = new Stack<Symbol>();
        final Stack<Symbol> imports = new Stack<Symbol>();
        symiter = syms.getIterator();
        while (symiter.hasNext()) {
            final Symbol s = symiter.next();
            final Values v = pkg.findSymbol(s.getName());
            if (v.get(1) == CommonLisp.FALSE && v.get(0).hashCode() != s.hashCode()) {
                missing.push(s);
            }
            else {
                final Object value = v.get(1);
                final LispPackage keywordNamespace = LispPackage.KeywordNamespace;
                if (value != valueOf("inherited")) {
                    continue;
                }
                imports.push(s);
            }
        }
        if (!missing.isEmpty()) {
            signal("The following symbols are missing: " + missing.toString());
        }
        while (!imports.isEmpty()) {
            final Symbol sym = imports.pop();
            pkg.exported.add(sym, sym.hashCode());
        }
        while (!validSyms.isEmpty()) {
            final Symbol s = validSyms.pop();
            pkg.remove(s);
            pkg.exported.add(s, s.hashCode());
        }
    }
    
    public static void importPkg(final LList syms, final LispPackage pkg) {
        final Stack<Symbol> validSyms = new Stack<Symbol>();
        Iterator symiter = syms.getIterator();
        while (symiter.hasNext()) {
            final Symbol s = symiter.next();
            final Values v = pkg.findSymbol(s.getName());
            if (v.get(1) == CommonLisp.FALSE) {
                final Iterator symiter2 = syms.getIterator();
                final boolean found = false;
                while (symiter2.hasNext()) {
                    final Symbol s2 = symiter2.next();
                    if (s.getName().equals(s2.getName()) && s != s2) {
                        validSyms.remove(s2);
                        signal("Symbol " + s2 + " conflicts with this package.");
                    }
                }
                if (found) {
                    continue;
                }
                validSyms.push(s);
            }
            else if (v.get(0) != s) {
                signal("Symbol " + v.get(0) + " conflicts in this package");
            }
            else {
                final Object value = v.get(1);
                final LispPackage keywordNamespace = LispPackage.KeywordNamespace;
                if (value != valueOf("inherited")) {
                    continue;
                }
                validSyms.add(s);
            }
        }
        while (!validSyms.isEmpty()) {
            final Symbol sym = validSyms.pop();
            pkg.add(sym, sym.hashCode());
        }
        symiter = syms.getIterator();
        while (symiter.hasNext()) {
            final Symbol s = symiter.next();
            if (s.getNamespace() == null) {
                s.setNamespace(pkg);
            }
        }
    }
    
    public LList allSymbols(final Namespace ns) {
        LList res = LList.Empty;
        final Iterator symNameIter = ((AbstractHashTable<Entry, String, Symbol>)ns).entrySet().iterator();
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
    
    public static void use(final LispPackage importing, final LispPackage imported) {
        synchronized (LispPackage.masterLock) {
            final NamespaceUse use = new NamespaceUse();
            use.nextImporting = imported.importing;
            use.importing = importing;
            imported.importing = use;
            use.nextImported = importing.imported;
            use.imported = imported;
            importing.imported = use;
        }
    }
    
    @Override
    public Symbol lookup(final String name, final int hash, final boolean create) {
        Symbol sym = this.exported.lookup(name, hash, false);
        if (sym != null) {
            return sym;
        }
        sym = this.lookupInternal(name, hash);
        if (sym != null) {
            return sym;
        }
        for (NamespaceUse used = this.imported; used != null; used = used.nextImported) {
            sym = this.lookup(name, hash, false);
            if (sym != null) {
                return sym;
            }
        }
        if (create) {
            return this.add(Symbol.makeUninterned(name, this), hash);
        }
        return null;
    }
    
    public Symbol lookupPresent(final String name, final int hash, final boolean intern) {
        Symbol sym = this.exported.lookup(name, hash, false);
        if (sym == null) {
            sym = super.lookup(name, hash, intern);
        }
        return sym;
    }
    
    public boolean isPresent(final String name) {
        return this.lookupPresent(name, name.hashCode(), false) != null;
    }
    
    public boolean unintern(final Symbol symbol) {
        final String name = symbol.getName();
        final int hash = name.hashCode();
        if (this.exported.lookup(name, hash, false) == symbol) {
            this.exported.remove(symbol);
        }
        else {
            if (super.lookup(name, hash, false) != symbol) {
                return false;
            }
            super.remove(symbol);
        }
        symbol.setNamespace(null);
        if (this.removeFromShadowingSymbols(symbol)) {}
        return true;
    }
    
    private void addToShadowingSymbols(final Symbol sym) {
        Pair p;
        for (Object s = this.shadowingSymbols; s != LList.Empty; s = p.getCdr()) {
            p = (Pair)s;
            if (p.getCar() == sym) {
                return;
            }
        }
        this.shadowingSymbols = new Pair(sym, this.shadowingSymbols);
    }
    
    private boolean removeFromShadowingSymbols(final Symbol sym) {
        Pair prev = null;
        Object s = this.shadowingSymbols;
        while (s != LList.Empty) {
            final Pair p = (Pair)s;
            s = p.getCdr();
            if (p.getCar() == sym) {
                if (prev == null) {
                    this.shadowingSymbols = (LList)s;
                }
                else {
                    prev.setCdr(s);
                }
                return true;
            }
            prev = p;
        }
        return false;
    }
    
    public void shadow(final String name) {
        final Symbol sym = this.lookupPresent(name, name.hashCode(), true);
        this.addToShadowingSymbols(sym);
    }
    
    public void shadowingImport(final Symbol symbol) {
        final String name = symbol.getName();
        final int hash = name.hashCode();
        final Symbol old = this.lookupPresent(name, name.hashCode(), false);
        if (old != null && old != symbol) {
            this.unintern(old);
        }
        this.addToShadowingSymbols(symbol);
    }
    
    public static void signal(final String msg) {
        throw new RuntimeException(msg);
    }
    
    static {
        masterLock = new Object();
        CLNamespace = valueOf("COMMON-LISP");
        KeywordNamespace = valueOf("KEYWORD");
        KawaNamespace = valueOf("KAWA");
        ClassNamespace = valueOf("CLASS");
        LispPackage.currentPackage = new ThreadLocation<LispPackage>("*package*");
        LispPackage.nsTable.put("CL", LispPackage.CLNamespace);
        LispPackage.CLNamespace.nicknames = Pair.make("CL", LispPackage.CLNamespace.nicknames);
        LispPackage.KawaNamespace.setExportedNamespace(LispPackage.EmptyNamespace);
        use(LispPackage.CLNamespace, LispPackage.KawaNamespace);
        use(LispPackage.CLNamespace, LispPackage.ClassNamespace);
        LispPackage.currentPackage.setGlobal(LispPackage.CLNamespace);
    }
}
