package gnu.kawa.lispexpr;

import gnu.commonlisp.lang.CommonLisp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.Values;
import gnu.mapping.Values.Values2;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class LispPackage
  extends Namespace
{
  public Namespace exported = new Namespace();
  
  public void setExportedNamespace(Namespace exp)
  {
    exported = exp;
  }
  

  LList nicknames = LList.Empty;
  
  private static final Object masterLock = new Object();
  
  LList shadowingSymbols = LList.Empty;
  
  public LList getShadowingSymbols()
  {
    return shadowingSymbols;
  }
  
  public static final LispPackage CLNamespace = valueOf("COMMON-LISP");
  
  public static final LispPackage KeywordNamespace = valueOf("KEYWORD");
  
  public static final LispPackage KawaNamespace = valueOf("KAWA");
  



  public static final LispPackage ClassNamespace = valueOf("CLASS");
  

  public static ThreadLocation<LispPackage> currentPackage = new ThreadLocation("*package*");
  NamespaceUse imported;
  NamespaceUse importing;
  
  static {
    nsTable.put("CL", CLNamespace);
    CLNamespacenicknames = Pair.make("CL", CLNamespacenicknames);
    

    KawaNamespace.setExportedNamespace(EmptyNamespace);
    use(CLNamespace, KawaNamespace);
    use(CLNamespace, ClassNamespace);
    currentPackage.setGlobal(CLNamespace);
  }
  










  public static LList pkgUsesList(LispPackage lp)
  {
    LList uses = LList.Empty;
    NamespaceUse it = imported;
    while (it != null) {
      uses = Pair.make(imported, uses);
      it = nextImported;
    }
    return uses;
  }
  

  public static LList pkgUsedByList(LispPackage lp)
  {
    LList usedby = LList.Empty;
    NamespaceUse it = importing;
    while (it != null) {
      usedby = Pair.make(importing, usedby);
      it = nextImporting;
    }
    return usedby;
  }
  
  public static void addNickNames(LispPackage name, LList nicks)
  {
    synchronized (nsTable)
    {
      for (Object nick : nicks) {
        nicknames = Pair.make((String)nick, nicknames);
        nsTable.put((String)nick, name);
      }
    }
  }
  
  public static void usePackages(LList importees, LispPackage importer)
  {
    for (Object usePkg : importees)
    {
      LispPackage lp;
      LispPackage lp;
      if ((usePkg instanceof Symbol)) {
        lp = (LispPackage)valueOfNoCreate(((Symbol)usePkg).getName()); } else { LispPackage lp;
        if ((usePkg instanceof LispPackage)) {
          lp = (LispPackage)usePkg;
        } else
          lp = (LispPackage)valueOfNoCreate((String)usePkg);
      }
      if (lp != null)
      {
        use(importer, lp);
      }
      else
      {
        throw new RuntimeException("The name " + usePkg + " does not designate any package");
      }
    }
  }
  

  public static LispPackage makeLispPackage(Object name, LList nicks, LList used)
  {
    LispPackage newpack = valueOf((String)name);
    addNickNames(newpack, nicks);
    usePackages(used, newpack);
    return newpack;
  }
  











  public static LispPackage valueOf(String name)
  {
    if (name == null) {
      name = "";
    }
    synchronized (nsTable) {
      Namespace ns = (Namespace)nsTable.get(name);
      if (ns != null)
        return (LispPackage)ns;
      ns = new LispPackage();
      ns.setName(name.intern());
      Namespace.nsTable.put(name, ns);
      return (LispPackage)ns;
    }
  }
  
  public static Namespace valueOfNoCreate(String name)
  {
    return (LispPackage)Namespace.valueOfNoCreate(name);
  }
  
  public Values.Values2 findSymbol(Object name)
  {
    String sname = name.toString();
    
    Symbol sym = exported.lookup(sname);
    if (sym != null)
    {
      return Values.values2(sym, CommonLisp.externalKeyword);
    }
    
    sym = lookupInternal(sname, sname.hashCode());
    if (sym != null)
    {
      return Values.values2(sym, CommonLisp.internalKeyword);
    }
    


    NamespaceUse U = imported;
    while (U != null)
    {
      if (imported == KawaNamespace) {
        sym = imported.exported.lookup(sname.toLowerCase());
      } else {
        sym = imported.exported.lookup(sname);
      }
      if (sym != null)
      {
        return Values.values2(sym, CommonLisp.inheritedKeyword);
      }
      
      U = nextImported;
    }
    
    return Values.values2(CommonLisp.FALSE, CommonLisp.FALSE);
  }
  






  public static void exportPkg(LList syms, LispPackage pkg)
  {
    Stack<Symbol> validSyms = new Stack();
    Iterator symiter = syms.getIterator();
    


    while (symiter.hasNext())
    {
      Symbol s = (Symbol)symiter.next();
      Values v = pkg.findSymbol(s.getName());
      if ((v.get(1) != CommonLisp.FALSE) && (!validSyms.contains(s)))
      {

        validSyms.push(s);
      }
    }
    
    NamespaceUse usedBy = imported;
    symiter = syms.getIterator();
    
    while (symiter.hasNext())
    {
      Symbol s = (Symbol)symiter.next();
      String sname = s.getName();
      while (usedBy != null)
      {
        Values v = imported.findSymbol(sname);
        if ((v.get(1) != CommonLisp.FALSE) && (v.get(0) != s) && (!imported.shadowingSymbols.contains(v.get(0))))
        {




          signal("Name conflict from package " + imported + "on symbol" + s);
        }
        
        usedBy = nextImported;
      }
    }
    

    Stack<Symbol> missing = new Stack();
    
    Stack<Symbol> imports = new Stack();
    
    symiter = syms.getIterator();
    while (symiter.hasNext())
    {
      Symbol s = (Symbol)symiter.next();
      Values v = pkg.findSymbol(s.getName());
      if ((v.get(1) == CommonLisp.FALSE) && (v.get(0).hashCode() != s.hashCode()))
      {

        missing.push(s);
      }
      else if (v.get(1) == valueOf("inherited"))
      {
        imports.push(s);
      }
    }
    
    if (!missing.isEmpty())
    {


      signal("The following symbols are missing: " + missing.toString());
    }
    
    while (!imports.isEmpty())
    {
      Symbol sym = (Symbol)imports.pop();
      exported.add(sym, sym.hashCode());
    }
    
    while (!validSyms.isEmpty())
    {
      Symbol s = (Symbol)validSyms.pop();
      pkg.remove(s);
      exported.add(s, s.hashCode());
    }
  }
  









  public static void importPkg(LList syms, LispPackage pkg)
  {
    Stack<Symbol> validSyms = new Stack();
    Iterator symiter = syms.getIterator();
    


    while (symiter.hasNext())
    {
      Symbol s = (Symbol)symiter.next();
      Values v = pkg.findSymbol(s.getName());
      
      if (v.get(1) == CommonLisp.FALSE)
      {
        Iterator symiter2 = syms.getIterator();
        boolean found = false;
        while (symiter2.hasNext())
        {
          Symbol s2 = (Symbol)symiter2.next();
          if (s.getName().equals(s2.getName()))
          {
            if (s != s2)
            {
              validSyms.remove(s2);
              
              signal("Symbol " + s2 + " conflicts with this package.");
            }
          }
        }
        
        if (!found)
        {
          validSyms.push(s);
        }
      }
      else if (v.get(0) != s)
      {

        signal("Symbol " + v.get(0) + " conflicts in this package");
      }
      else if (v.get(1) == valueOf("inherited"))
      {
        validSyms.add(s);
      }
    }
    
    while (!validSyms.isEmpty())
    {
      Symbol sym = (Symbol)validSyms.pop();
      pkg.add(sym, sym.hashCode());
    }
    
    symiter = syms.getIterator();
    while (symiter.hasNext())
    {
      Symbol s = (Symbol)symiter.next();
      if (s.getNamespace() == null)
      {
        s.setNamespace(pkg);
      }
    }
  }
  






  public LList allSymbols(Namespace ns)
  {
    LList res = LList.Empty;
    Iterator symNameIter = ns.entrySet().iterator();
    while (symNameIter.hasNext())
    {
      res = Pair.make(symNameIter.next(), res);
    }
    return res;
  }
  






  public LList allExternalSymbols()
  {
    return allSymbols(exported);
  }
  





  public LList allInternalSymbols()
  {
    return allSymbols(this);
  }
  
  public static void use(LispPackage importing, LispPackage imported)
  {
    synchronized (masterLock)
    {

      NamespaceUse use = new NamespaceUse();
      nextImporting = importing;
      importing = importing;
      importing = use;
      nextImported = importing.imported;
      imported = imported;
      importing.imported = use;
    }
  }
  

  public Symbol lookup(String name, int hash, boolean create)
  {
    Symbol sym = exported.lookup(name, hash, false);
    if (sym != null)
      return sym;
    sym = lookupInternal(name, hash);
    if (sym != null) {
      return sym;
    }
    
    for (NamespaceUse used = imported; used != null; 
        used = nextImported)
    {
      sym = lookup(name, hash, false);
      if (sym != null) {
        return sym;
      }
    }
    if (create) {
      return add(Symbol.makeUninterned(name, this), hash);
    }
    return null;
  }
  
  public Symbol lookupPresent(String name, int hash, boolean intern)
  {
    Symbol sym = exported.lookup(name, hash, false);
    if (sym == null)
      sym = super.lookup(name, hash, intern);
    return sym;
  }
  
  public boolean isPresent(String name)
  {
    return lookupPresent(name, name.hashCode(), false) != null;
  }
  
  public boolean unintern(Symbol symbol)
  {
    String name = symbol.getName();
    int hash = name.hashCode();
    if (exported.lookup(name, hash, false) == symbol) {
      exported.remove(symbol);
    } else if (super.lookup(name, hash, false) == symbol) {
      super.remove(symbol);
    } else
      return false;
    symbol.setNamespace(null);
    if (removeFromShadowingSymbols(symbol)) {}
    



    return true;
  }
  
  private void addToShadowingSymbols(Symbol sym)
  {
    for (Object s = shadowingSymbols; s != LList.Empty;)
    {
      Pair p = (Pair)s;
      if (p.getCar() == sym)
        return;
      s = p.getCdr();
    }
    shadowingSymbols = new Pair(sym, shadowingSymbols);
  }
  
  private boolean removeFromShadowingSymbols(Symbol sym)
  {
    Pair prev = null;
    for (Object s = shadowingSymbols; s != LList.Empty;)
    {
      Pair p = (Pair)s;
      s = p.getCdr();
      if (p.getCar() == sym)
      {
        if (prev == null) {
          shadowingSymbols = ((LList)s);
        } else
          prev.setCdr(s);
        return true;
      }
      prev = p;
    }
    return false;
  }
  

  public void shadow(String name)
  {
    Symbol sym = lookupPresent(name, name.hashCode(), true);
    addToShadowingSymbols(sym);
  }
  
  public void shadowingImport(Symbol symbol)
  {
    String name = symbol.getName();
    int hash = name.hashCode();
    Symbol old = lookupPresent(name, name.hashCode(), false);
    if ((old != null) && (old != symbol))
      unintern(old);
    addToShadowingSymbols(symbol);
  }
  



  public static void signal(String msg)
  {
    throw new RuntimeException(msg);
  }
  
  public LispPackage() {}
}
