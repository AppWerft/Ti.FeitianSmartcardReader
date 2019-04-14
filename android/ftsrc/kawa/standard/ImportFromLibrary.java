package kawa.standard;

import gnu.bytecode.ObjectType;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Mangling;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.io.Path;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kawa.lang.Translator;

public class ImportFromLibrary extends kawa.lang.Syntax
{
  public static final ImportFromLibrary instance = new ImportFromLibrary();
  
  public static String[] classPrefixPath = { "", "kawa.lib." };
  
  private static final String BUILTIN = "<builtin>";
  private static final String MISSING = null;
  
  static final String[][] SRFI97Map = { { "1", "lists", "gnu.kawa.slib.srfi1" }, { "2", "and-let*", "gnu.kawa.slib.srfi2" }, { "5", "let", MISSING }, { "6", "basic-string-ports", "<builtin>" }, { "8", "receive", "gnu.kawa.slib.receive" }, { "9", "records", "<builtin>" }, { "11", "let-values", "<builtin>" }, { "13", "strings", "gnu.kawa.slib.srfi13" }, { "14", "char-sets", "gnu.kawa.slib.srfi14" }, { "16", "case-lambda", "<builtin>" }, { "17", "generalized-set!", "<builtin>" }, { "18", "multithreading", MISSING }, { "19", "time", MISSING }, { "21", "real-time-multithreading", MISSING }, { "23", "error", "<builtin>" }, { "25", "multi-dimensional-arrays", "<builtin>" }, { "26", "cut", "gnu.kawa.slib.cut" }, { "27", "random-bits", MISSING }, { "28", "basic-format-strings", "<builtin>" }, { "29", "localization", MISSING }, { "31", "rec", MISSING }, { "35", "conditions", "gnu.kawa.slib.conditions" }, { "37", "args-fold", "gnu.kawa.slib.srfi37" }, { "38", "with-shared-structure", MISSING }, { "39", "parameters", "<builtin>" }, { "41", "streams.primitive", "gnu.kawa.slib.StreamsPrimitive" }, { "41", "streams.derived", "gnu.kawa.slib.StreamsDerived" }, { "41", "streams", "gnu.kawa.slib.Streams" }, { "42", "eager-comprehensions", MISSING }, { "43", "vectors", MISSING }, { "44", "collections", MISSING }, { "45", "lazy", MISSING }, { "46", "syntax-rules", MISSING }, { "47", "arrays", MISSING }, { "48", "intermediate-format-strings", MISSING }, { "51", "rest-values", MISSING }, { "54", "cat", MISSING }, { "57", "records", MISSING }, { "59", "vicinities", MISSING }, { "60", "integer-bits", "gnu.kawa.slib.srfi60" }, { "61", "cond", MISSING }, { "63", "arrays", MISSING }, { "64", "testing", "gnu.kawa.slib.testing" }, { "66", "octet-vectors", MISSING }, { "67", "compare-procedures", MISSING }, { "69", "basic-hash-tables", "gnu.kawa.slib.srfi69" }, { "71", "let", MISSING }, { "74", "blobs", MISSING }, { "78", "lightweight-testing", MISSING }, { "86", "mu-and-nu", MISSING }, { "87", "case", "<builtin>" }, { "95", "sorting-and-merging", "kawa.lib.srfi95" }, { "98", "os-environment-variables", "<builtin>" }, { "101", "random-access-lists", "gnu.kawa.slib.ralists" } };
  




























  public ImportFromLibrary() {}
  



























  public void scanForm(Pair st, ScopeExp defs, Translator tr)
  {
    Object obj = st.getCdr();
    while ((obj instanceof Pair)) {
      Pair pair = (Pair)obj;
      Object save1 = tr.pushPositionOf(pair);
      scanImportSet(pair.getCar(), defs, tr, null);
      tr.popPositionOf(save1);
      obj = pair.getCdr();
    }
    if (obj != LList.Empty) tr.error('e', "improper list");
  }
  
  public static String checkSrfi(String lname, Translator tr) {
    if (lname.startsWith("srfi.")) {
      String demangled = Mangling.demangleSymbolic(lname.substring(5));
      int dot = demangled.indexOf('.');
      
      StringBuilder badNameBuffer = null;
      String srfiName;
      if (dot < 0) {
        String srfiName = null;
        dot = demangled.length();
      } else {
        srfiName = demangled.substring(dot + 1); }
      String srfiNumber = null;
      if (dot > 0) {
        int numStart = demangled.charAt(0) == ':' ? 1 : 0;
        for (int i = numStart;; i++) {
          if (i == dot) {
            srfiNumber = demangled.substring(numStart, dot);
          }
          else
            if (Character.digit(demangled.charAt(i), 10) < 0)
              break;
        }
      }
      if (srfiNumber == null) {
        tr.error('e', "SRFI library reference must have the form: (srfi NNN [name]) or (srfi :NNN [name])");
        return lname;
      }
      int srfiIndex = SRFI97Map.length;
      for (;;) {
        srfiIndex--; if (srfiIndex < 0) {
          break;
        }
        if (SRFI97Map[srfiIndex][0].equals(srfiNumber))
        {
          String srfiNameExpected = SRFI97Map[srfiIndex][1];
          String srfiClass = SRFI97Map[srfiIndex][2];
          
          if ((srfiName == null) || (srfiName.equals(srfiNameExpected))) {
            return srfiClass != MISSING ? srfiClass : lname;
          }
          if (badNameBuffer == null) {
            badNameBuffer = new StringBuilder("the name of SRFI ");
            badNameBuffer.append(srfiNumber);
            badNameBuffer.append(" should be '");
          }
          else {
            badNameBuffer.append(" or '"); }
          badNameBuffer.append(srfiNameExpected);
          badNameBuffer.append('\'');
        } }
      if (badNameBuffer != null) {
        tr.error('e', badNameBuffer.toString());
        return "<builtin>";
      }
    }
    return lname;
  }
  
  void scanImportSet(Object imports, ScopeExp defs, Translator tr, require.DeclSetMapper mapper) {
    if ((imports instanceof SimpleSymbol)) {
      String sname = imports.toString();
      handleImport(sname, null, Mangling.mangleQualifiedName(sname), defs, tr, mapper);
      

      return;
    }
    int specLength = Translator.listLength(imports);
    if (specLength <= 0) {
      Object save1 = tr.pushPositionOf(imports);
      tr.error('e', "import specifier is not a proper list");
      tr.popPositionOf(save1);
      return;
    }
    Pair pimport = (Pair)imports;
    Object first = pimport.getCar();
    Object rest = pimport.getCdr();
    Pair cdrPair = specLength >= 2 ? (Pair)rest : null;
    char kind = '\000';
    if (first == onlySymbol) {
      kind = 'O';
    } else if (first == exceptSymbol) {
      kind = 'E';
    } else if (first == renameSymbol) {
      kind = 'R';
    } else if (first == prefixSymbol) {
      kind = 'P';
    } else if ((first == librarySymbol) && (specLength == 2) && ((cdrPair.getCar() instanceof Pair)))
    {
      pimport = (Pair)cdrPair.getCar();
    } else if ((first == classSymbol) && (specLength >= 2) && ((cdrPair.getCar() instanceof SimpleSymbol)))
    {
      Map<Symbol, Expression> decls = new java.util.LinkedHashMap();
      
      SimpleSymbol name1 = (SimpleSymbol)cdrPair.getCar();
      String prefix = name1.getName();
      if (prefix.length() > 0)
        prefix = prefix + '.';
      rest = cdrPair.getCdr();
      if (rest == LList.Empty) {
        tr.error('e', "class-prefix must be followed by class-names");
      }
      while (rest != LList.Empty) {
        cdrPair = (Pair)rest;
        Object part2 = cdrPair.getCar();
        String cname = null;
        SimpleSymbol dname = null;
        if ((part2 instanceof SimpleSymbol)) {
          dname = (SimpleSymbol)part2;
          String str2 = dname.getName();
          cname = prefix + str2;
        } else if (((part2 instanceof Pair)) && (Translator.listLength(part2) == 2))
        {
          Pair rpair1 = (Pair)part2;
          Pair rpair2 = (Pair)rpair1.getCdr();
          Object rname1 = rpair1.getCar();
          Object rname2 = rpair2.getCar();
          if (((rname1 instanceof SimpleSymbol)) && ((rname2 instanceof SimpleSymbol)))
          {
            cname = prefix + ((SimpleSymbol)rname1).getName();
            dname = (SimpleSymbol)rname2;
          }
        }
        if (dname == null) {
          tr.error('e', "imported class-name must be NAME or (NAME NEW-NAME)");
        } else {
          try {
            Class clas = ObjectType.getContextClass(cname);
            decls.put(dname, tr.makeQuoteExp(clas));
          } catch (ClassNotFoundException ex) {
            Object savePos = tr.pushPositionOf(cdrPair);
            tr.error('e', "no class found named " + cname);
            tr.popPositionOf(savePos);
          }
        }
        rest = cdrPair.getCdr();
      }
      if (mapper != null)
        decls = mapper.map(decls, tr);
      for (Map.Entry<Symbol, Expression> entry : decls.entrySet()) {
        Symbol aname = (Symbol)entry.getKey();
        Declaration decl = tr.define(aname, defs);
        decl.setAlias(true);
        decl.setFlag(536887296L);
        SetExp sexp = new SetExp(decl, (Expression)entry.getValue());
        tr.setLineOf(sexp);
        decl.noteValueFromSet(sexp);
        sexp.setDefining(true);
        formStack.push(sexp);
      }
      return;
    }
    if ((specLength >= 2) && (kind != 0)) {
      ImportSetMapper nmapper = new ImportSetMapper(kind, cdrPair.getCdr(), specLength - 2);
      
      chain = mapper;
      scanImportSet(cdrPair.getCar(), defs, tr, nmapper);
      return;
    }
    
    String explicitSource = null;
    Object versionSpec = null;
    StringBuilder cbuf = new StringBuilder();
    StringBuilder sbuf = new StringBuilder();
    Object libref = pimport;
    while ((libref instanceof Pair)) {
      Pair pair = (Pair)libref;
      Object car = pair.getCar();
      Object cdr = pair.getCdr();
      if ((car instanceof Pair)) {
        if (versionSpec != null) {
          tr.error('e', "duplicate version reference - was " + versionSpec);
        }
        versionSpec = car;
      } else if ((car instanceof String)) {
        if ((cdr instanceof Pair))
          tr.error('e', "source specifier must be last element in library reference");
        explicitSource = (String)car;
      } else {
        if (cbuf.length() > 0)
          cbuf.append('.');
        if (sbuf.length() > 0)
          sbuf.append('/');
        String part = car.toString();
        cbuf.append(Mangling.mangleClassName(part));
        sbuf.append(part);
      }
      libref = cdr;
    }
    handleImport(sbuf.toString(), explicitSource, cbuf.toString(), defs, tr, mapper);
  }
  








  public static void handleImport(String implicitSource, String explicitSource, String requestedClass, ScopeExp defs, Translator tr, require.DeclSetMapper mapper)
  {
    ModuleManager mmanager = ModuleManager.getInstance();
    ModuleInfo minfo = null;
    String lname = checkSrfi(requestedClass, tr);
    if (lname == "<builtin>")
      return;
    boolean foundSrfi = lname != requestedClass;
    
    int classPrefixPathLength = classPrefixPath.length;
    Class existingClass = null;
    for (int i = 0; i < classPrefixPathLength; i++) {
      String tname = classPrefixPath[i] + lname;
      minfo = mmanager.searchWithClassName(tname);
      if (minfo != null)
        break;
      try {
        existingClass = ObjectType.getContextClass(tname);
      }
      catch (Exception ex) {}catch (NoClassDefFoundError ex) {}
    }
    


    ModuleInfo curinfo = tr.getMinfo();
    Path currentSource = curinfo.getSourceAbsPath();
    String currentExtension = currentSource == null ? null : currentSource.getExtension();
    
    if (currentExtension == null) {
      List<String> langExtensions = tr.getLanguage().getExtensions();
      if (!langExtensions.isEmpty())
        currentExtension = (String)langExtensions.get(0);
    }
    boolean isAbsolute;
    boolean hasDot;
    boolean isAbsolute;
    if (explicitSource != null) {
      boolean hasDot = explicitSource.indexOf("./") >= 0;
      isAbsolute = Path.valueOf(explicitSource).isAbsolute();
    } else {
      hasDot = false;
      isAbsolute = false;
    }
    
    String currentClassName = curinfo.getClassName();
    

    boolean currentIsFile = (currentSource != null) && (currentSource.isPlainFile());
    
    Path currentRoot = currentIsFile ? currentSource.getDirectory() : Path.currentPath();
    
    if ((currentIsFile) && ((explicitSource == null) || ((!hasDot) && (!isAbsolute))))
    {
      int currentDots = 0;
      String prefix = classPrefix != null ? classPrefix : currentClassName != null ? currentClassName : "";
      
      int i = prefix.length(); for (;;) { i--; if (i < 0) break;
        if (prefix.charAt(i) == '.')
          currentDots++; }
      if (currentDots > 0) {
        StringBuilder ups = new StringBuilder("..");
        int i = currentDots; for (;;) { i--; if (i <= 0) break;
          ups.append("/.."); }
        currentRoot = currentRoot.resolve(ups.toString());
      }
    }
    

    boolean skipSourceSearch = (minfo != null) && (explicitSource == null);
    List<CharSequence> srcSearchPath; if ((isAbsolute) || (hasDot) || (skipSourceSearch)) {
      List<CharSequence> srcSearchPath = new java.util.ArrayList();
      if (!skipSourceSearch) {
        srcSearchPath.add(currentRoot.toString());
      }
    } else {
      srcSearchPath = getImportSearchPath(); }
    String pathStr = null;
    for (CharSequence searchElement : srcSearchPath) {
      if (isAbsolute) {
        pathStr = explicitSource;
      } else {
        String pathElement = searchElement.toString();
        

        int prefixLength = 0;
        StringBuilder pbuf = new StringBuilder();
        int selectorEnd; int star; int selectorEnd; if ((pathElement.length() >= 3) && (pathElement.charAt(0) == '<') && ((selectorEnd = pathElement.indexOf('>') + 1) > 0))
        {

          StringBuilder prefixBuf = new StringBuilder();
          boolean slashNeeded = false;
          for (int i = 1; i < selectorEnd - 1; i++) {
            char ch = pathElement.charAt(i);
            if (ch == ' ') {
              if (prefixBuf.length() > 0)
                slashNeeded = true;
            } else {
              if (slashNeeded)
                prefixBuf.append('/');
              prefixBuf.append(ch);
              prefixLength += (slashNeeded ? 2 : 1);
              slashNeeded = false;
            }
          }
          if (!implicitSource.startsWith(prefixBuf.toString()))
            continue;
          if (implicitSource.length() != prefixLength) {
            if (implicitSource.charAt(prefixLength) != '/')
              continue;
            prefixLength++;
          }
          int star = pathElement.indexOf('*', selectorEnd);
          if (star < 0) {
            pathElement = pathElement.substring(selectorEnd);
          }
        } else {
          star = pathElement.indexOf('*');
          selectorEnd = 0;
          if ((foundSrfi) && (explicitSource == null)) {
            continue;
          }
        }
        if (star >= 0) {
          pbuf.append(pathElement.substring(selectorEnd, star));
          pbuf.append(implicitSource.substring(prefixLength));
          pbuf.append(pathElement.substring(star + 1));
        } else {
          if (!".".equals(pathElement)) {
            pbuf.append(pathElement);
            pbuf.append('/');
          }
          if (explicitSource != null) {
            pbuf.append(explicitSource);
          } else {
            pbuf.append(implicitSource);
            if (currentExtension != null) {
              pbuf.append('.');
              pbuf.append(currentExtension);
            }
          }
        }
        pathStr = pbuf.toString();
      }
      Path path = currentRoot.resolve(pathStr).getCanonical();
      

      long lastModifiedTime = path.getLastModified();
      if (lastModifiedTime != 0L) {
        if (minfo != null) {
          String pstring = path.toString();
          Path infoPath = minfo.getSourceAbsPath();
          if ((infoPath == null) || (!pstring.equals(infoPath.toString())))
          {
            tr.error('w', "ignoring source file at " + pstring + " - instead using class " + minfo.getClassName() + (infoPath == null ? "" : new StringBuilder().append(" from ").append(infoPath.toString()).toString()));
          }
          
        }
        else
        {
          minfo = mmanager.findWithSourcePath(path, pathStr);
        }
        if (!foundSrfi) break;
        lname = requestedClass; break;
      }
    }
    

    if (existingClass != null) {
      if (minfo == null) {
        minfo = ModuleManager.findWithClass(existingClass);
      } else
        minfo.setModuleClass(existingClass);
    }
    if (minfo == null) {
      tr.error('e', "unknown library (" + implicitSource.replace('/', ' ') + ")");
    } else {
      require.importDefinitions(lname, minfo, mapper, formStack, defs, tr);
    }
  }
  
  public Expression rewriteForm(Pair form, Translator tr) {
    return tr.syntaxError(getName() + " is only allowed in a <body>");
  }
  
  static class ImportSetMapper implements require.DeclSetMapper {
    char kind;
    Object list;
    int listLength;
    require.DeclSetMapper chain;
    
    public ImportSetMapper(char kind, Object list, int listLength) {
      this.kind = kind;
      this.list = list;
      this.listLength = listLength;
    }
    
    public Map<Symbol, Expression> map(Map<Symbol, Expression> decls, gnu.expr.Compilation comp) {
      Translator tr = (Translator)comp;
      Object lst = list;
      Map<Symbol, Expression> nmap = decls;
      String prefix;
      switch (kind) {
      case 'E': 
      case 'O': 
        if (kind == 'O')
          nmap = new java.util.LinkedHashMap();
      case 'R': case 'P':  while ((lst instanceof Pair)) {
          Pair pair = (Pair)lst;
          Object save1 = tr.pushPositionOf(pair);
          Object name = Translator.stripSyntax(pair.getCar());
          name = tr.namespaceResolve(name);
          Symbol oldsym = null;
          Symbol newsym = null;
          if ((name instanceof Symbol)) {
            oldsym = (Symbol)name;
            newsym = oldsym;
          } else if ((kind == 'O') && ((name instanceof Pair)) && (Translator.listLength(name) == 2))
          {
            Pair rpair1 = (Pair)name;
            Object rname1 = rpair1.getCar();
            Object rname2 = ((Pair)rpair1.getCdr()).getCar();
            rname1 = tr.namespaceResolve(rname1);
            rname2 = tr.namespaceResolve(rname2);
            if (((rname1 instanceof Symbol)) && ((rname2 instanceof Symbol)))
            {
              oldsym = (Symbol)rname1;
              newsym = (Symbol)rname2;
            }
          }
          if (oldsym == null) {
            tr.error('e', "non-symbol in name list");
          } else {
            Expression old = (Expression)decls.get(oldsym);
            if (old == null) {
              tr.error('e', "unknown symbol in import set: " + oldsym);
            } else if (kind == 'E') {
              nmap.remove(oldsym);
            } else
              nmap.put(newsym, old);
          }
          tr.popPositionOf(save1);
          lst = pair.getCdr();
          continue;
          


          Symbol[] pendingSymbols = new Symbol[listLength];
          Expression[] pendingDecls = new Expression[listLength];
          int npending = 0;
          while ((lst instanceof Pair)) {
            Pair pair = (Pair)lst;
            Object save1 = tr.pushPositionOf(pair);
            Object entry = pair.getCar();
            int entryLen = Translator.listLength(entry);
            if (entryLen == 2) {
              Pair p1 = (Pair)entry;
              Object oldname = p1.getCar();
              Object newname = ((Pair)p1.getCdr()).getCar();
              if (((oldname instanceof Symbol)) && ((newname instanceof Symbol)))
              {
                Symbol oldSymbol = (Symbol)oldname;
                Symbol newSymbol = (Symbol)newname;
                Expression oldValue = (Expression)decls.remove(oldSymbol);
                if (oldValue == null) {
                  tr.error('e', "missing binding " + oldSymbol);
                } else {
                  pendingSymbols[npending] = newSymbol;
                  pendingDecls[npending] = oldValue;
                  npending++;
                }
              }
              else {
                entryLen = -1;
              } }
            if (entryLen != 2)
              tr.error('e', "entry is not a pair of names");
            tr.popPositionOf(save1);
            lst = pair.getCdr();
          }
          for (int i = 0; i < npending; i++) {
            Symbol newSymbol = pendingSymbols[i];
            Expression decl = pendingDecls[i];
            if (decls.put(newSymbol, decl) != null)
              tr.error('e', "duplicate binding for " + newSymbol);
          }
          break;
          

          nmap = new java.util.LinkedHashMap();
          if ((listLength != 1) || (!(((Pair)list).getCar() instanceof SimpleSymbol)))
          {
            tr.error('e', "bad syntax for prefix import specifier");
          } else {
            prefix = ((SimpleSymbol)((Pair)list).getCar()).getName();
            
            for (Map.Entry<Symbol, Expression> entry : decls.entrySet()) {
              Symbol aname = (Symbol)entry.getKey();
              Expression old = (Expression)entry.getValue();
              Symbol nname = Symbol.valueOf(prefix + aname);
              nmap.put(nname, old);
            }
          }
        }
      }
      if (chain != null)
        nmap = chain.map(nmap, tr);
      return nmap;
    }
  }
  



  public String libraryExists(Object list, Translator tr)
  {
    String lname = module_name.listToModuleName(list, tr);
    lname = checkSrfi(lname, tr);
    if (lname == "<builtin>")
      return lname;
    int classPrefixPathLength = classPrefixPath.length;
    for (int i = 0; i < classPrefixPathLength; i++) {
      String className = classPrefixPath[i] + lname;
      try {
        ObjectType.getContextClass(className);
        return className;
      }
      catch (Exception ex) {}
    }
    
    return null;
  }
  
  public static final ThreadLocal<List<CharSequence>> searchPath = new InheritableThreadLocal();
  
  public static List<CharSequence> getImportSearchPath()
  {
    return Include.getSearchPath(searchPath, "kawa.import.path", ".");
  }
  
  public static final SimpleSymbol classSymbol = Symbol.valueOf("class");
  public static final SimpleSymbol exceptSymbol = Symbol.valueOf("except");
  public static final SimpleSymbol librarySymbol = Symbol.valueOf("library");
  public static final SimpleSymbol onlySymbol = Symbol.valueOf("only");
  public static final SimpleSymbol prefixSymbol = Symbol.valueOf("prefix");
  public static final SimpleSymbol renameSymbol = Symbol.valueOf("rename");
}
