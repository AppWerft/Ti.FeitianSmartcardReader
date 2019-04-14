package kawa.standard;

import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.NameLookup;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.util.Map;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class define_library extends Syntax
{
  public static final define_library define_library = new define_library();
  public static final define_library define_library_scan = new define_library();
  static { define_library.setName("define-library"); }
  
  public void scanForm(Pair st, ScopeExp defs, Translator tr)
  {
    if (this != define_library_scan) {
      createModulePass(st, defs, tr);
    } else {
      tr.push(defs);
      scanModulePass(st.getCdr(), defs, tr);
    }
  }
  
  public void createModulePass(Pair st, ScopeExp defs, Translator tr) { Object cdr1 = st.getCdr();
    if (!(cdr1 instanceof Pair)) {
      tr.error('e', "missing library name");
      return;
    }
    if (!(defs instanceof ModuleExp)) {
      tr.error('e', "define-library must be a top level");
      return;
    }
    defs.setFlag(16777216);
    Pair pair2 = (Pair)cdr1;
    Object car2 = pair2.getCar();
    if (gnu.lists.LList.listLength(car2, false) <= 0) {
      tr.error('e', "invalid list in library name");
      return;
    }
    gnu.expr.Language language = tr.getLanguage();
    ModuleExp module = new ModuleExp();
    module.setFile(defs.getFileName());
    NameLookup lexical = new NameLookup(language);
    gnu.text.SourceMessages messages = tr.getMessages();
    

    SchemeCompilation mcomp = new SchemeCompilation(language, messages, lexical, gnu.mapping.Environment.make());
    mcomp.setPedantic(tr.isPedantic());
    explicit = explicit;
    immediate = immediate;
    
    String name = module_name.listToModuleName(car2, tr);
    String className = name;
    int index = name.lastIndexOf('.');
    if (index >= 0) {
      classPrefix = name.substring(0, index + 1);
    } else
      className = classPrefix + gnu.expr.Mangling.mangleClassName(name);
    gnu.bytecode.ClassType moduleClass = new gnu.bytecode.ClassType(className);
    mainLambda = module;
    module.setType(mainClass);
    module.setName(name);
    ModuleInfo curinfo = tr.getMinfo();
    ModuleManager manager = ModuleManager.getInstance();
    ModuleInfo info = manager.createWithClassName(className);
    info.setCompilation(mcomp);
    curinfo.addDependency(info);
    





    mcomp.setState(2);
    pendingForm = Translator.makePair(pair2, define_library_scan, pair2.getCdr());
    
    SchemeCompilation curcomp = (SchemeCompilation)tr;
    Map<String, ModuleInfo> subModuleMap = subModuleMap;
    if (subModuleMap == null) {
      subModuleMap = new java.util.LinkedHashMap();
      subModuleMap = subModuleMap;
    }
    ModuleInfo oldinfo = (ModuleInfo)subModuleMap.get(name);
    if (oldinfo != null)
      tr.error('e', "duplicate library name " + name);
    subModuleMap.put(name, info);
  }
  
  void scanModulePass(Object form, ScopeExp defs, Translator tr) {
    while ((form instanceof Pair)) {
      Pair pform = (Pair)form;
      Object save1 = tr.pushPositionOf(form);
      Object clause = pform.getCar();
      if ((clause instanceof Pair)) {
        Pair pclause = (Pair)clause;
        Object clauseHead = pclause.getCar();
        Syntax syntax = null;
        if (clauseHead == beginSymbol) {
          syntax = begin.begin;
        } else if (clauseHead == exportSymbol) {
          syntax = export.export;
        } else if (clauseHead == includeSymbol) {
          syntax = Include.include;
        } else if (clauseHead == includeCiSymbol) {
          syntax = Include.includeCi;
        } else if (clauseHead == importSymbol)
          syntax = ImportFromLibrary.instance;
        if (clauseHead == includeLibraryDeclarationsSymbol) {
          Object forms = Include.includeRelative.process(pclause.getCdr(), tr, null, false);
          
          scanModulePass(forms, defs, tr);
        } else if (clauseHead == condExpandSymbol) {
          Object forms = IfFeature.condExpand.evaluate(pclause.getCdr(), tr);
          
          scanModulePass(forms, defs, tr);
        } else if (syntax != null) {
          syntax.scanForm(pclause, defs, tr);
        }
        else {
          if (tr.isPedantic()) {
            tr.error('e', "unknown define-library keyword: " + clauseHead);
          }
          tr.scanForm(clause, defs);
        }
      } else {
        tr.error('e', "define-library clause is not a list");
      }
      form = pform.getCdr();
      tr.popPositionOf(save1);
    }
    tr.errorIfNonEmpty(form);
  }
  
  public static final SimpleSymbol beginSymbol = Symbol.valueOf("begin");
  public static final SimpleSymbol condExpandSymbol = Symbol.valueOf("cond-expand");
  public static final SimpleSymbol exportSymbol = Symbol.valueOf("export");
  public static final SimpleSymbol importSymbol = Symbol.valueOf("import");
  public static final SimpleSymbol includeSymbol = Symbol.valueOf("include");
  public static final SimpleSymbol includeCiSymbol = Symbol.valueOf("include-ci");
  public static final SimpleSymbol includeLibraryDeclarationsSymbol = Symbol.valueOf("include-library-declarations");
  
  public define_library() {}
}
