// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.mapping.Symbol;
import java.util.Map;
import gnu.text.SourceMessages;
import gnu.expr.Language;
import gnu.expr.ModuleInfo;
import java.util.LinkedHashMap;
import gnu.expr.Compilation;
import gnu.expr.ModuleManager;
import gnu.bytecode.ClassType;
import gnu.expr.Mangling;
import gnu.mapping.Environment;
import gnu.expr.NameLookup;
import gnu.lists.LList;
import gnu.expr.ModuleExp;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import kawa.lang.Syntax;

public class define_library extends Syntax
{
    public static final define_library define_library;
    public static final define_library define_library_scan;
    public static final SimpleSymbol beginSymbol;
    public static final SimpleSymbol condExpandSymbol;
    public static final SimpleSymbol exportSymbol;
    public static final SimpleSymbol importSymbol;
    public static final SimpleSymbol includeSymbol;
    public static final SimpleSymbol includeCiSymbol;
    public static final SimpleSymbol includeLibraryDeclarationsSymbol;
    
    @Override
    public void scanForm(final Pair st, final ScopeExp defs, final Translator tr) {
        if (this != kawa.standard.define_library.define_library_scan) {
            this.createModulePass(st, defs, tr);
        }
        else {
            tr.push(defs);
            this.scanModulePass(st.getCdr(), defs, tr);
        }
    }
    
    public void createModulePass(final Pair st, final ScopeExp defs, final Translator tr) {
        final Object cdr1 = st.getCdr();
        if (!(cdr1 instanceof Pair)) {
            tr.error('e', "missing library name");
            return;
        }
        if (!(defs instanceof ModuleExp)) {
            tr.error('e', "define-library must be a top level");
            return;
        }
        defs.setFlag(16777216);
        final Pair pair2 = (Pair)cdr1;
        final Object car2 = pair2.getCar();
        if (LList.listLength(car2, false) <= 0) {
            tr.error('e', "invalid list in library name");
            return;
        }
        final Language language = tr.getLanguage();
        final ModuleExp module = new ModuleExp();
        module.setFile(defs.getFileName());
        final NameLookup lexical = new NameLookup(language);
        final SourceMessages messages = tr.getMessages();
        final SchemeCompilation mcomp = new SchemeCompilation(language, messages, lexical, Environment.make());
        mcomp.setPedantic(tr.isPedantic());
        mcomp.explicit = tr.explicit;
        mcomp.immediate = tr.immediate;
        String className;
        final String name = className = module_name.listToModuleName(car2, tr);
        final int index = name.lastIndexOf(46);
        if (index >= 0) {
            mcomp.classPrefix = name.substring(0, index + 1);
        }
        else {
            className = tr.classPrefix + Mangling.mangleClassName(name);
        }
        final ClassType moduleClass = new ClassType(className);
        (mcomp.mainLambda = module).setType(tr.mainClass);
        module.setName(name);
        final ModuleInfo curinfo = tr.getMinfo();
        final ModuleManager manager = ModuleManager.getInstance();
        final ModuleInfo info = manager.createWithClassName(className);
        info.setCompilation(mcomp);
        curinfo.addDependency(info);
        mcomp.setState(2);
        mcomp.pendingForm = Translator.makePair(pair2, kawa.standard.define_library.define_library_scan, pair2.getCdr());
        final SchemeCompilation curcomp = (SchemeCompilation)tr;
        Map<String, ModuleInfo> subModuleMap = curcomp.subModuleMap;
        if (subModuleMap == null) {
            subModuleMap = new LinkedHashMap<String, ModuleInfo>();
            curcomp.subModuleMap = subModuleMap;
        }
        final ModuleInfo oldinfo = subModuleMap.get(name);
        if (oldinfo != null) {
            tr.error('e', "duplicate library name " + name);
        }
        subModuleMap.put(name, info);
    }
    
    void scanModulePass(Object form, final ScopeExp defs, final Translator tr) {
        while (form instanceof Pair) {
            final Pair pform = (Pair)form;
            final Object save1 = tr.pushPositionOf(form);
            final Object clause = pform.getCar();
            if (clause instanceof Pair) {
                final Pair pclause = (Pair)clause;
                final Object clauseHead = pclause.getCar();
                Syntax syntax = null;
                if (clauseHead == kawa.standard.define_library.beginSymbol) {
                    syntax = begin.begin;
                }
                else if (clauseHead == kawa.standard.define_library.exportSymbol) {
                    syntax = export.export;
                }
                else if (clauseHead == kawa.standard.define_library.includeSymbol) {
                    syntax = Include.include;
                }
                else if (clauseHead == kawa.standard.define_library.includeCiSymbol) {
                    syntax = Include.includeCi;
                }
                else if (clauseHead == kawa.standard.define_library.importSymbol) {
                    syntax = ImportFromLibrary.instance;
                }
                if (clauseHead == kawa.standard.define_library.includeLibraryDeclarationsSymbol) {
                    final Object forms = Include.includeRelative.process(pclause.getCdr(), tr, null, false);
                    this.scanModulePass(forms, defs, tr);
                }
                else if (clauseHead == kawa.standard.define_library.condExpandSymbol) {
                    final Object forms = IfFeature.condExpand.evaluate(pclause.getCdr(), tr);
                    this.scanModulePass(forms, defs, tr);
                }
                else if (syntax != null) {
                    syntax.scanForm(pclause, defs, tr);
                }
                else {
                    if (tr.isPedantic()) {
                        tr.error('e', "unknown define-library keyword: " + clauseHead);
                    }
                    tr.scanForm(clause, defs);
                }
            }
            else {
                tr.error('e', "define-library clause is not a list");
            }
            form = pform.getCdr();
            tr.popPositionOf(save1);
        }
        tr.errorIfNonEmpty(form);
    }
    
    static {
        define_library = new define_library();
        define_library_scan = new define_library();
        kawa.standard.define_library.define_library.setName("define-library");
        beginSymbol = Symbol.valueOf("begin");
        condExpandSymbol = Symbol.valueOf("cond-expand");
        exportSymbol = Symbol.valueOf("export");
        importSymbol = Symbol.valueOf("import");
        includeSymbol = Symbol.valueOf("include");
        includeCiSymbol = Symbol.valueOf("include-ci");
        includeLibraryDeclarationsSymbol = Symbol.valueOf("include-library-declarations");
    }
}
