/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.NameLookup;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Environment;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.text.SourceMessages;
import java.util.LinkedHashMap;
import kawa.lang.Syntax;
import kawa.lang.Translator;
import kawa.standard.IfFeature;
import kawa.standard.ImportFromLibrary;
import kawa.standard.Include;
import kawa.standard.SchemeCompilation;
import kawa.standard.begin;
import kawa.standard.export;
import kawa.standard.module_name;

public class define_library
extends Syntax {
    public static final define_library define_library = new define_library();
    public static final define_library define_library_scan = new define_library();
    public static final SimpleSymbol beginSymbol;
    public static final SimpleSymbol condExpandSymbol;
    public static final SimpleSymbol exportSymbol;
    public static final SimpleSymbol importSymbol;
    public static final SimpleSymbol includeSymbol;
    public static final SimpleSymbol includeCiSymbol;
    public static final SimpleSymbol includeLibraryDeclarationsSymbol;

    @Override
    public void scanForm(Pair st, ScopeExp defs2, Translator tr) {
        if (this != define_library_scan) {
            this.createModulePass(st, defs2, tr);
        } else {
            tr.push(defs2);
            this.scanModulePass(st.getCdr(), defs2, tr);
        }
    }

    public void createModulePass(Pair st, ScopeExp defs2, Translator tr) {
        String name;
        ModuleInfo oldinfo;
        Object cdr1 = st.getCdr();
        if (!(cdr1 instanceof Pair)) {
            tr.error('e', "missing library name");
            return;
        }
        if (!(defs2 instanceof ModuleExp)) {
            tr.error('e', "define-library must be a top level");
            return;
        }
        defs2.setFlag(16777216);
        Pair pair2 = (Pair)cdr1;
        Object car2 = pair2.getCar();
        if (LList.listLength(car2, false) <= 0) {
            tr.error('e', "invalid list in library name");
            return;
        }
        Language language = tr.getLanguage();
        ModuleExp module = new ModuleExp();
        module.setFile(defs2.getFileName());
        NameLookup lexical = new NameLookup(language);
        SourceMessages messages = tr.getMessages();
        SchemeCompilation mcomp = new SchemeCompilation(language, messages, lexical, Environment.make());
        mcomp.setPedantic(tr.isPedantic());
        mcomp.explicit = tr.explicit;
        mcomp.immediate = tr.immediate;
        String className = name = module_name.listToModuleName(car2, tr);
        int index = name.lastIndexOf(46);
        if (index >= 0) {
            mcomp.classPrefix = name.substring(0, index + 1);
        } else {
            className = tr.classPrefix + Mangling.mangleClassName(name);
        }
        ClassType moduleClass = new ClassType(className);
        mcomp.mainLambda = module;
        module.setType(tr.mainClass);
        module.setName(name);
        ModuleInfo curinfo = tr.getMinfo();
        ModuleManager manager = ModuleManager.getInstance();
        ModuleInfo info = manager.createWithClassName(className);
        info.setCompilation(mcomp);
        curinfo.addDependency(info);
        mcomp.setState(2);
        mcomp.pendingForm = Translator.makePair(pair2, define_library_scan, pair2.getCdr());
        SchemeCompilation curcomp = (SchemeCompilation)tr;
        LinkedHashMap<String, ModuleInfo> subModuleMap = curcomp.subModuleMap;
        if (subModuleMap == null) {
            curcomp.subModuleMap = subModuleMap = new LinkedHashMap<String, ModuleInfo>();
        }
        if ((oldinfo = (ModuleInfo)subModuleMap.get(name)) != null) {
            tr.error('e', "duplicate library name " + name);
        }
        subModuleMap.put(name, info);
    }

    void scanModulePass(Object form, ScopeExp defs2, Translator tr) {
        while (form instanceof Pair) {
            Pair pform = (Pair)form;
            Object save1 = tr.pushPositionOf(form);
            Object clause = pform.getCar();
            if (clause instanceof Pair) {
                Object forms;
                Pair pclause = (Pair)clause;
                Object clauseHead = pclause.getCar();
                Syntax syntax2 = null;
                if (clauseHead == beginSymbol) {
                    syntax2 = begin.begin;
                } else if (clauseHead == exportSymbol) {
                    syntax2 = export.export;
                } else if (clauseHead == includeSymbol) {
                    syntax2 = Include.include;
                } else if (clauseHead == includeCiSymbol) {
                    syntax2 = Include.includeCi;
                } else if (clauseHead == importSymbol) {
                    syntax2 = ImportFromLibrary.instance;
                }
                if (clauseHead == includeLibraryDeclarationsSymbol) {
                    forms = Include.includeRelative.process(pclause.getCdr(), tr, null, false);
                    this.scanModulePass(forms, defs2, tr);
                } else if (clauseHead == condExpandSymbol) {
                    forms = IfFeature.condExpand.evaluate(pclause.getCdr(), tr);
                    this.scanModulePass(forms, defs2, tr);
                } else if (syntax2 != null) {
                    ((Syntax)syntax2).scanForm(pclause, defs2, tr);
                } else {
                    if (tr.isPedantic()) {
                        tr.error('e', "unknown define-library keyword: " + clauseHead);
                    }
                    tr.scanForm(clause, defs2);
                }
            } else {
                tr.error('e', "define-library clause is not a list");
            }
            form = pform.getCdr();
            tr.popPositionOf(save1);
        }
        tr.errorIfNonEmpty(form);
    }

    static {
        define_library.setName("define-library");
        beginSymbol = Symbol.valueOf("begin");
        condExpandSymbol = Symbol.valueOf("cond-expand");
        exportSymbol = Symbol.valueOf("export");
        importSymbol = Symbol.valueOf("import");
        includeSymbol = Symbol.valueOf("include");
        includeCiSymbol = Symbol.valueOf("include-ci");
        includeLibraryDeclarationsSymbol = Symbol.valueOf("include-library-declarations");
    }
}

