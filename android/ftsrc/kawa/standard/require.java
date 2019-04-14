package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Map;
import kawa.lang.Translator;
import kawa.lang.Translator.FormStack;

public class require extends kawa.lang.Syntax
{
  public static final require require = new require();
  












  static java.util.Hashtable featureMap;
  












  private static final String SLIB_PREFIX = "gnu.kawa.slib.";
  












  static void map(String featureName, String className)
  {
    featureMap.put(featureName, className);
  }
  
  static
  {
    require.setName("require");
    






































    featureMap = new java.util.Hashtable();
    







    map("generic-write", "gnu.kawa.slib.genwrite");
    map("pretty-print", "gnu.kawa.slib.pp");
    map("pprint-file", "gnu.kawa.slib.ppfile");
    map("printf", "gnu.kawa.slib.printf");
    map("xml", "gnu.kawa.slib.XML");
    map("readtable", "gnu.kawa.slib.readtable");
    map("srfi-10", "gnu.kawa.slib.readtable");
    map("http", "gnu.kawa.servlet.HTTP");
    map("servlets", "gnu.kawa.servlet.servlets");
    map("srfi-1", "gnu.kawa.slib.srfi1");
    map("list-lib", "gnu.kawa.slib.srfi1");
    map("srfi-2", "gnu.kawa.slib.srfi2");
    map("and-let*", "gnu.kawa.slib.srfi2");
    map("srfi-8", "gnu.kawa.slib.receive");
    map("receive", "gnu.kawa.slib.receive");
    map("srfi-13", "gnu.kawa.slib.srfi13");
    map("srfi-14", "gnu.kawa.slib.srfi14");
    map("string-lib", "gnu.kawa.slib.srfi13");
    map("srfi-26", "gnu.kawa.slib.cut");
    map("srfi-34", "gnu.kawa.slib.srfi34");
    map("srfi-35", "gnu.kawa.slib.conditions");
    map("condition", "gnu.kawa.slib.conditions");
    map("conditions", "gnu.kawa.slib.conditions");
    map("srfi-37", "gnu.kawa.slib.srfi37");
    map("args-fold", "gnu.kawa.slib.srfi37");
    map("srfi-41", "gnu.kawa.slib.Streams");
    map("srfi-41-streams", "gnu.kawa.slib.Streams");
    map("srfi-41-streams-type", "gnu.kawa.slib.StreamsType");
    map("srfi-41-streams-primitive", "gnu.kawa.slib.StreamsPrimitive");
    map("srfi-41-streams-derived", "gnu.kawa.slib.StreamsDerived");
    map("srfi-60", "gnu.kawa.slib.srfi60");
    map("srfi-64", "gnu.kawa.slib.testing");
    map("testing", "gnu.kawa.slib.testing");
    map("srfi-69", "gnu.kawa.slib.srfi69");
    map("hash-table", "gnu.kawa.slib.srfi69");
    map("basic-hash-tables", "gnu.kawa.slib.srfi69");
    map("srfi-95", "kawa.lib.srfi95");
    map("sorting-and-merging", "kawa.lib.srfi95");
    map("srfi-101", "gnu.kawa.slib.ralists");
    map("random-access-lists", "gnu.kawa.slib.ralists");
    map("ra-lists", "gnu.kawa.slib.ralists");
    map("regex", "kawa.lib.kawa.regex");
    map("pregexp", "gnu.kawa.slib.pregexp");
    map("gui", "gnu.kawa.slib.gui");
    map("swing-gui", "gnu.kawa.slib.swing");
    map("android-defs", "gnu.kawa.android.defs");
    map("javafx-defs", "gnu.kawa.javafx.defs");
    map("syntax-utils", "gnu.kawa.slib.syntaxutils");
    map("quaternions", "kawa.lib.kawa.quaternions");
  }
  
  public static String mapFeature(String featureName) {
    return (String)featureMap.get(featureName);
  }
  
  public static Object find(String typeName) {
    return ModuleManager.getInstance().findWithClassName(typeName).getInstance();
  }
  

  public boolean scanForDefinitions(Pair st, ScopeExp defs, Translator tr)
  {
    if (tr.getState() == 1) {
      tr.setState(2);
      pendingForm = st;
      

      return true;
    }
    Pair args = (Pair)st.getCdr();
    Object name = args.getCar();
    gnu.bytecode.Type type = null;
    Pair p;
    if (((name instanceof Pair)) && (tr.matches((p = (Pair)name).getCar(), "quote")))
    {
      Object fname = p.getCdr();
      if ((!(fname instanceof Pair)) || ((p = (Pair)fname).getCdr() != gnu.lists.LList.Empty) || (!(p.getCar() instanceof Symbol)))
      {

        tr.error('e', "invalid quoted symbol for 'require'");
        return false;
      }
      fname = mapFeature(p.getCar().toString());
      if (fname == null) {
        tr.error('e', "unknown feature name '" + p.getCar() + "' for 'require'");
        return false;
      }
      type = ClassType.make((String)fname);
    } else {
      if ((name instanceof CharSequence)) {
        String sourceName = name.toString();
        ModuleInfo info = lookupModuleFromSourcePath(sourceName, defs);
        if (info == null) {
          tr.error('e', "malformed URL: " + sourceName);
          return false;
        }
        return importDefinitions(null, info, null, formStack, defs, tr); }
      if (((name instanceof Symbol)) && (!tr.selfEvaluatingSymbol(name))) {
        String requestedClass = name.toString();
        int nlen = requestedClass.length();
        if ((nlen > 2) && (requestedClass.charAt(0) == '<') && (requestedClass.charAt(nlen - 1) == '>'))
        {
          requestedClass = requestedClass.substring(1, nlen - 1); }
        String implicitSource = requestedClass.replace('.', '/');
        requestedClass = gnu.expr.Mangling.mangleQualifiedName(requestedClass);
        String explicitSource = null;
        if ((args.getCdr() instanceof Pair)) {
          Object sname = ((Pair)args.getCdr()).getCar();
          if ((sname instanceof CharSequence)) {
            explicitSource = sname.toString();
          }
        }
        ImportFromLibrary.handleImport(implicitSource, explicitSource, requestedClass, defs, tr, null);
        return true;
      }
    }
    if (!(type instanceof ClassType)) {
      if (type != null) {
        tr.error('e', "specifier for 'require' is not a classname");
      } else if ((name instanceof gnu.mapping.SimpleSymbol)) {
        tr.error('e', "class '" + name + "' for 'require' not found");
      } else
        tr.error('e', "invalid specifier for 'require'");
      return false;
    }
    ModuleInfo minfo;
    try {
      minfo = ModuleInfo.find((ClassType)type);
    } catch (Exception ex) {
      tr.error('e', "unknown class " + type.getName());
      return false;
    }
    importDefinitions(null, minfo, null, formStack, defs, tr);
    
    return true;
  }
  
  public static ModuleInfo lookupModuleFromSourcePath(String sourceName, ScopeExp defs) {
    ModuleManager manager = ModuleManager.getInstance();
    String baseName = defs.getFileName();
    if ((baseName != null) && (baseName != "/dev/stdin") && (baseName != "<string>") && (baseName != "<eval>"))
    {


      sourceName = gnu.kawa.io.Path.valueOf(baseName).resolve(sourceName).toString(); }
    return manager.findWithSourcePath(sourceName);
  }
  






  public static boolean importDefinitions(String className, ModuleInfo info, DeclSetMapper mapper, Translator.FormStack forms, ScopeExp defs, Compilation tr)
  {
    ModuleManager manager = ModuleManager.getInstance();
    if (((info.getState() & 0x1) == 0) && (info.getCompilation() == null) && (!info.checkCurrent(manager, System.currentTimeMillis())))
    {

      gnu.text.SourceMessages messages = tr.getMessages();
      gnu.expr.Language language = gnu.expr.Language.getDefaultLanguage();
      Compilation comp;
      try {
        gnu.kawa.io.InPort fstream = gnu.kawa.io.InPort.openFile(info.getSourceAbsPath());
        info.clearClass();
        int options = 8;
        if (immediate)
          options |= 0x1;
        comp = language.parse(fstream, messages, options, info);
        if (tr.getModule().getFlag(4194304))
          comp.getModule().setFlag(4194304);
      } catch (java.io.FileNotFoundException ex) {
        tr.error('e', "not found: " + ex.getMessage());
        return false;
      } catch (java.io.IOException ex) {
        tr.error('e', "caught " + ex);
        return false;
      } catch (gnu.text.SyntaxException ex) {
        if (ex.getMessages() != messages) {
          throw new RuntimeException("confussing syntax error: " + ex);
        }
        return false;
      }
      String compiledClassName = comp.getModule().classFor(comp).getName();
      
      if (className != null) {
        Map<String, ModuleInfo> subModuleMap = subModuleMap;
        ModuleInfo modinfo;
        ModuleInfo modinfo; if (subModuleMap != null) {
          modinfo = (ModuleInfo)subModuleMap.get(className);
        } else
          modinfo = null;
        if (modinfo == null) {
          String[] classPrefixPath = ImportFromLibrary.classPrefixPath;
          
          int classPrefixPathLength = classPrefixPath.length;
          for (int i = 0; i < classPrefixPathLength; i++) {
            String tname = classPrefixPath[i] + className;
            if (tname.equals(compiledClassName)) {
              modinfo = info;
              break;
            }
          }
        }
        if (modinfo == null) {
          tr.error('e', "file '" + info.getSourceAbsPath() + "' does not declare library '" + className + "'");
        }
        else
        {
          info = modinfo;
        }
      }
    }
    ModuleInfo curinfo = tr.getMinfo();
    if ((curinfo != null) && (tr.getState() < 4)) {
      curinfo.addDependency(info);
      
      if ((!info.loadEager(14)) && (info.getState() < 6))
      {

        tr.pushPendingImport(info, defs, forms, mapper);
        return true;
      }
    }
    
    ClassType type = info.getClassType();
    String tname = type.getName();
    boolean sharedModule = tr.sharedModuleDefs();
    boolean isRunnable = info.getState() < 6 ? info.getCompilation().makeRunnable() : type.isSubtype(Compilation.typeRunnable);
    

    Declaration decl = null;
    ClassType thisType = ClassType.make("kawa.standard.require");
    Expression[] args = { new gnu.expr.QuoteExp(tname) };
    Expression dofind = gnu.kawa.reflect.Invoke.makeInvokeStatic(thisType, "find", args);
    gnu.bytecode.Field instanceField = null;
    gnu.expr.Language language = tr.getLanguage();
    dofind.setLine(tr);
    
    gnu.expr.ModuleExp mod = info.setupModuleExp();
    
    Map<Symbol, Expression> dmap = new java.util.LinkedHashMap();
    
    Map<String, Declaration> moduleReferences = null;
    
    for (Declaration fdecl = mod.firstDecl(); 
        fdecl != null; fdecl = fdecl.nextDecl()) {
      if (!fdecl.isPrivate())
      {

        if (field != null) {
          String fname = field.getName();
          if (fname.equals("$instance"))
          {
            instanceField = field;
            continue;
          }
        }
        
        if ((field != null) && (field.getName().endsWith("$instance")))
        {
          if (moduleReferences == null)
            moduleReferences = new java.util.HashMap();
          moduleReferences.put(field.getName(), fdecl);
        } else {
          dmap.put((Symbol)fdecl.getSymbol(), new ReferenceExp(fdecl));
        }
      }
    }
    if (mapper != null) {
      dmap = mapper.map(dmap, tr);
    }
    for (java.util.Map.Entry<Symbol, Expression> entry : dmap.entrySet()) {
      Symbol aname = (Symbol)entry.getKey();
      ReferenceExp fref = (ReferenceExp)entry.getValue();
      Declaration fdecl = fref.getBinding();
      








      Declaration old = defs.lookup(aname, language, language.getNamespaceOf(fdecl));
      if ((old == null) || (old.getFlag(512L)) || (Declaration.followAliases(old) != Declaration.followAliases(fdecl)))
      {




        if ((decl == null) && (!fdecl.getFlag(2048L))) {
          String iname = tname.replace('.', '$') + "$instance";
          decl = new Declaration(gnu.mapping.SimpleSymbol.valueOf(iname), type);
          decl.setPrivate(true);
          decl.setFlag(1073758208L);
          
          defs.addDeclaration(decl);
          
          decl.noteValue(dofind);
          gnu.expr.SetExp sexp = new gnu.expr.SetExp(decl, dofind);
          sexp.setLine(tr);
          sexp.setDefining(true);
          forms.push(sexp);
          decl.setFlag(536870912L);
          

          if (isRunnable) {
            decl.setSimple(false);
          }
          decl.setFlag(8192L); }
        Declaration adecl;
        Declaration adecl;
        if ((old != null) && (old.getFlag(66048L)))
        {
          old.setFlag(false, 66048L);
          adecl = old;
        } else {
          adecl = defs.addDeclaration(aname);
          if (old != null) {
            ScopeExp.duplicateDeclarationError(old, adecl, tr);
          }
        }
        adecl.setAlias(true);
        adecl.setIndirectBinding(true);
        
        fref.setContextDecl(decl);
        fref.setDontDereference(true);
        if (!sharedModule)
          adecl.setPrivate(true);
        linkDecls(adecl, fdecl, fref, forms, tr);
        
        Expression fval = fdecl.getValue();
        if ((fdecl.isIndirectBinding()) && ((fval instanceof ReferenceExp))) {
          ReferenceExp aref = (ReferenceExp)adecl.getValue();
          Declaration xdecl = ((ReferenceExp)fval).getBinding();
          aref.setBinding(xdecl);
          
          if ((xdecl != null) && (xdecl.needsContext())) {
            String iname = field.getDeclaringClass().getName().replace('.', '$') + "$instance";
            

            Declaration cdecl = moduleReferences == null ? null : (Declaration)moduleReferences.get(iname);
            
            if (cdecl != null) {
              if (context != defs) {
                Declaration acdecl = defs.addDeclaration(gnu.mapping.SimpleSymbol.valueOf(iname));
                moduleReferences.put(iname, acdecl);
                acdecl.setFlag(1073766400L);
                

                acdecl.setType(cdecl.getType());
                ReferenceExp cref = new ReferenceExp(cdecl);
                cref.setContextDecl(decl);
                linkDecls(acdecl, cdecl, cref, forms, tr);
                cdecl = acdecl;
              }
              cdecl.setFlag(1024L);
              aref.setContextDecl(cdecl);
            }
          }
        }
      }
    }
    if (isRunnable) {
      gnu.bytecode.Method run = Compilation.typeRunnable.getDeclaredMethod("run", 0);
      if (decl != null) {
        dofind = new ReferenceExp(decl);
      }
      else if (instanceField != null)
      {
        args = new Expression[] { new gnu.expr.QuoteExp(type), new gnu.expr.QuoteExp("$instance") };
        
        dofind = new gnu.expr.ApplyExp(gnu.kawa.reflect.SlotGet.staticField, args);
      }
      
      dofind = new gnu.expr.ApplyExp(run, new Expression[] { dofind });
      dofind.setLine(tr);
      forms.push(dofind);
    }
    return true;
  }
  
  static void linkDecls(Declaration adecl, Declaration fdecl, ReferenceExp fref, Translator.FormStack forms, Compilation tr)
  {
    adecl.setLocation(tr);
    
    adecl.setFlag(16384L);
    if (fdecl.getFlag(32768L))
      adecl.setFlag(32768L);
    if (fdecl.isProcedureDecl())
      adecl.setProcedureDecl(true);
    if (fdecl.getFlag(2048L)) {
      adecl.setFlag(2048L);
    }
    gnu.expr.SetExp sexp = new gnu.expr.SetExp(adecl, fref);
    adecl.setFlag(536870912L);
    sexp.setDefining(true);
    forms.push(sexp);
    adecl.noteValue(fref);
    adecl.setFlag(131072L);
    tr.push(adecl);
  }
  
  public Expression rewriteForm(Pair form, Translator tr) {
    return null;
  }
  
  public require() {}
  
  public static abstract interface DeclSetMapper
  {
    public abstract Map<Symbol, Expression> map(Map<Symbol, Expression> paramMap, Compilation paramCompilation);
  }
}
