/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.io.InPort;
import gnu.kawa.io.Path;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kawa.lang.Syntax;
import kawa.lang.Translator;
import kawa.standard.ImportFromLibrary;

public class require
extends Syntax {
    public static final require require = new require();
    static Hashtable featureMap;
    private static final String SLIB_PREFIX = "gnu.kawa.slib.";

    static void map(String featureName, String className) {
        featureMap.put(featureName, className);
    }

    public static String mapFeature(String featureName) {
        return (String)featureMap.get(featureName);
    }

    public static Object find(String typeName) {
        return ModuleManager.getInstance().findWithClassName(typeName).getInstance();
    }

    @Override
    public boolean scanForDefinitions(Pair st, ScopeExp defs2, Translator tr) {
        Pair p;
        ModuleInfo minfo;
        if (tr.getState() == 1) {
            tr.setState(2);
            tr.pendingForm = st;
            return true;
        }
        Pair args = (Pair)st.getCdr();
        Object name = args.getCar();
        Type type = null;
        if (name instanceof Pair && tr.matches((p = (Pair)name).getCar(), "quote")) {
            Object fname = p.getCdr();
            if (!(fname instanceof Pair) || (p = (Pair)fname).getCdr() != LList.Empty || !(p.getCar() instanceof Symbol)) {
                tr.error('e', "invalid quoted symbol for 'require'");
                return false;
            }
            fname = require.mapFeature(p.getCar().toString());
            if (fname == null) {
                tr.error('e', "unknown feature name '" + p.getCar() + "' for 'require'");
                return false;
            }
            type = ClassType.make((String)fname);
        } else {
            if (name instanceof CharSequence) {
                String sourceName = name.toString();
                ModuleInfo info = require.lookupModuleFromSourcePath(sourceName, defs2);
                if (info == null) {
                    tr.error('e', "malformed URL: " + sourceName);
                    return false;
                }
                return require.importDefinitions(null, info, null, tr.formStack, defs2, tr);
            }
            if (name instanceof Symbol && !tr.selfEvaluatingSymbol(name)) {
                Object sname;
                String requestedClass = name.toString();
                int nlen = requestedClass.length();
                if (nlen > 2 && requestedClass.charAt(0) == '<' && requestedClass.charAt(nlen - 1) == '>') {
                    requestedClass = requestedClass.substring(1, nlen - 1);
                }
                String implicitSource = requestedClass.replace('.', '/');
                requestedClass = Mangling.mangleQualifiedName(requestedClass);
                String explicitSource = null;
                if (args.getCdr() instanceof Pair && (sname = ((Pair)args.getCdr()).getCar()) instanceof CharSequence) {
                    explicitSource = sname.toString();
                }
                ImportFromLibrary.handleImport(implicitSource, explicitSource, requestedClass, defs2, tr, null);
                return true;
            }
        }
        if (!(type instanceof ClassType)) {
            if (type != null) {
                tr.error('e', "specifier for 'require' is not a classname");
            } else if (name instanceof SimpleSymbol) {
                tr.error('e', "class '" + name + "' for 'require' not found");
            } else {
                tr.error('e', "invalid specifier for 'require'");
            }
            return false;
        }
        try {
            minfo = ModuleInfo.find((ClassType)type);
        }
        catch (Exception ex) {
            tr.error('e', "unknown class " + type.getName());
            return false;
        }
        require.importDefinitions(null, minfo, null, tr.formStack, defs2, tr);
        return true;
    }

    public static ModuleInfo lookupModuleFromSourcePath(String sourceName, ScopeExp defs2) {
        ModuleManager manager = ModuleManager.getInstance();
        String baseName = defs2.getFileName();
        if (baseName != null && baseName != "/dev/stdin" && baseName != "<string>" && baseName != "<eval>") {
            sourceName = Path.valueOf(baseName).resolve(sourceName).toString();
        }
        return manager.findWithSourcePath(sourceName);
    }

    public static boolean importDefinitions(String className, ModuleInfo info, DeclSetMapper mapper, Translator.FormStack forms, ScopeExp defs2, Compilation tr) {
        ModuleInfo curinfo;
        ModuleManager manager = ModuleManager.getInstance();
        if ((info.getState() & 1) == 0 && info.getCompilation() == null && !info.checkCurrent(manager, System.currentTimeMillis())) {
            Compilation comp;
            SourceMessages messages = tr.getMessages();
            Language language = Language.getDefaultLanguage();
            try {
                InPort fstream = InPort.openFile(info.getSourceAbsPath());
                info.clearClass();
                int options = 8;
                if (tr.immediate) {
                    options |= 1;
                }
                comp = language.parse(fstream, messages, options, info);
                if (tr.getModule().getFlag(4194304)) {
                    comp.getModule().setFlag(4194304);
                }
            }
            catch (FileNotFoundException ex) {
                tr.error('e', "not found: " + ex.getMessage());
                return false;
            }
            catch (IOException ex) {
                tr.error('e', "caught " + ex);
                return false;
            }
            catch (SyntaxException ex) {
                if (ex.getMessages() != messages) {
                    throw new RuntimeException("confussing syntax error: " + ex);
                }
                return false;
            }
            String compiledClassName = comp.getModule().classFor(comp).getName();
            if (className != null) {
                Map<String, ModuleInfo> subModuleMap = comp.subModuleMap;
                ModuleInfo modinfo = subModuleMap != null ? subModuleMap.get(className) : null;
                if (modinfo == null) {
                    String[] classPrefixPath = ImportFromLibrary.classPrefixPath;
                    int classPrefixPathLength = classPrefixPath.length;
                    for (int i = 0; i < classPrefixPathLength; ++i) {
                        String tname = classPrefixPath[i] + className;
                        if (!tname.equals(compiledClassName)) continue;
                        modinfo = info;
                        break;
                    }
                }
                if (modinfo == null) {
                    tr.error('e', "file '" + info.getSourceAbsPath() + "' does not declare library '" + className + "'");
                } else {
                    info = modinfo;
                }
            }
        }
        if ((curinfo = tr.getMinfo()) != null && tr.getState() < 4) {
            curinfo.addDependency(info);
            if (!info.loadEager(14) && info.getState() < 6) {
                tr.pushPendingImport(info, defs2, forms, mapper);
                return true;
            }
        }
        ClassType type = info.getClassType();
        String tname = type.getName();
        boolean sharedModule = tr.sharedModuleDefs();
        boolean isRunnable = info.getState() < 6 ? info.getCompilation().makeRunnable() : type.isSubtype(Compilation.typeRunnable);
        Declaration decl = null;
        ClassType thisType = ClassType.make("kawa.standard.require");
        Expression[] args = new Expression[]{new QuoteExp(tname)};
        Expression dofind = Invoke.makeInvokeStatic(thisType, "find", args);
        Field instanceField = null;
        Language language = tr.getLanguage();
        dofind.setLine(tr);
        ModuleExp mod = info.setupModuleExp();
        Map<Symbol, Expression> dmap = new LinkedHashMap<Symbol, Expression>();
        HashMap<String, Declaration> moduleReferences = null;
        for (Declaration fdecl = mod.firstDecl(); fdecl != null; fdecl = fdecl.nextDecl()) {
            String fname;
            if (fdecl.isPrivate()) continue;
            if (fdecl.field != null && (fname = fdecl.field.getName()).equals("$instance")) {
                instanceField = fdecl.field;
                continue;
            }
            if (fdecl.field != null && fdecl.field.getName().endsWith("$instance")) {
                if (moduleReferences == null) {
                    moduleReferences = new HashMap<String, Declaration>();
                }
                moduleReferences.put(fdecl.field.getName(), fdecl);
                continue;
            }
            dmap.put((Symbol)fdecl.getSymbol(), new ReferenceExp(fdecl));
        }
        if (mapper != null) {
            dmap = mapper.map(dmap, tr);
        }
        for (Map.Entry entry : dmap.entrySet()) {
            Declaration fdecl;
            ReferenceExp fref;
            Declaration adecl;
            Symbol aname = (Symbol)entry.getKey();
            Declaration old = defs2.lookup(aname, language, language.getNamespaceOf(fdecl = (fref = (ReferenceExp)entry.getValue()).getBinding()));
            if (old != null && !old.getFlag(512L) && Declaration.followAliases(old) == Declaration.followAliases(fdecl)) continue;
            if (decl == null && !fdecl.getFlag(2048L)) {
                String iname = tname.replace('.', '$') + "$instance";
                decl = new Declaration((Object)SimpleSymbol.valueOf(iname), type);
                decl.setPrivate(true);
                decl.setFlag(0x40004000L);
                defs2.addDeclaration(decl);
                decl.noteValue(dofind);
                SetExp sexp = new SetExp(decl, dofind);
                sexp.setLine(tr);
                sexp.setDefining(true);
                forms.push(sexp);
                decl.setFlag(0x20000000L);
                if (isRunnable) {
                    decl.setSimple(false);
                }
                decl.setFlag(8192L);
            }
            if (old != null && old.getFlag(66048L)) {
                old.setFlag(false, 66048L);
                adecl = old;
            } else {
                adecl = defs2.addDeclaration(aname);
                if (old != null) {
                    ScopeExp.duplicateDeclarationError(old, adecl, tr);
                }
            }
            adecl.setAlias(true);
            adecl.setIndirectBinding(true);
            fref.setContextDecl(decl);
            fref.setDontDereference(true);
            if (!sharedModule) {
                adecl.setPrivate(true);
            }
            require.linkDecls(adecl, fdecl, fref, forms, tr);
            Expression fval = fdecl.getValue();
            if (!fdecl.isIndirectBinding() || !(fval instanceof ReferenceExp)) continue;
            ReferenceExp aref = (ReferenceExp)adecl.getValue();
            Declaration xdecl = ((ReferenceExp)fval).getBinding();
            aref.setBinding(xdecl);
            if (xdecl == null || !xdecl.needsContext()) continue;
            String iname = xdecl.field.getDeclaringClass().getName().replace('.', '$') + "$instance";
            Declaration cdecl = moduleReferences == null ? null : (Declaration)moduleReferences.get(iname);
            if (cdecl == null) continue;
            if (cdecl.context != defs2) {
                Declaration acdecl = defs2.addDeclaration(SimpleSymbol.valueOf(iname));
                moduleReferences.put(iname, acdecl);
                acdecl.setFlag(1073766400L);
                acdecl.setType(cdecl.getType());
                ReferenceExp cref = new ReferenceExp(cdecl);
                cref.setContextDecl(decl);
                require.linkDecls(acdecl, cdecl, cref, forms, tr);
                cdecl = acdecl;
            }
            cdecl.setFlag(1024L);
            aref.setContextDecl(cdecl);
        }
        if (isRunnable) {
            Method run = Compilation.typeRunnable.getDeclaredMethod("run", 0);
            if (decl != null) {
                dofind = new ReferenceExp(decl);
            } else if (instanceField != null) {
                args = new Expression[]{new QuoteExp(type), new QuoteExp("$instance")};
                dofind = new ApplyExp(SlotGet.staticField, args);
            }
            dofind = new ApplyExp(run, dofind);
            dofind.setLine(tr);
            forms.push(dofind);
        }
        return true;
    }

    static void linkDecls(Declaration adecl, Declaration fdecl, ReferenceExp fref, Translator.FormStack forms, Compilation tr) {
        adecl.setLocation(tr);
        adecl.setFlag(16384L);
        if (fdecl.getFlag(32768L)) {
            adecl.setFlag(32768L);
        }
        if (fdecl.isProcedureDecl()) {
            adecl.setProcedureDecl(true);
        }
        if (fdecl.getFlag(2048L)) {
            adecl.setFlag(2048L);
        }
        SetExp sexp = new SetExp(adecl, (Expression)fref);
        adecl.setFlag(0x20000000L);
        sexp.setDefining(true);
        forms.push(sexp);
        adecl.noteValue(fref);
        adecl.setFlag(131072L);
        tr.push(adecl);
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        return null;
    }

    static {
        require.setName("require");
        featureMap = new Hashtable();
        require.map("generic-write", "gnu.kawa.slib.genwrite");
        require.map("pretty-print", "gnu.kawa.slib.pp");
        require.map("pprint-file", "gnu.kawa.slib.ppfile");
        require.map("printf", "gnu.kawa.slib.printf");
        require.map("xml", "gnu.kawa.slib.XML");
        require.map("readtable", "gnu.kawa.slib.readtable");
        require.map("srfi-10", "gnu.kawa.slib.readtable");
        require.map("http", "gnu.kawa.servlet.HTTP");
        require.map("servlets", "gnu.kawa.servlet.servlets");
        require.map("srfi-1", "gnu.kawa.slib.srfi1");
        require.map("list-lib", "gnu.kawa.slib.srfi1");
        require.map("srfi-2", "gnu.kawa.slib.srfi2");
        require.map("and-let*", "gnu.kawa.slib.srfi2");
        require.map("srfi-8", "gnu.kawa.slib.receive");
        require.map("receive", "gnu.kawa.slib.receive");
        require.map("srfi-13", "gnu.kawa.slib.srfi13");
        require.map("srfi-14", "gnu.kawa.slib.srfi14");
        require.map("string-lib", "gnu.kawa.slib.srfi13");
        require.map("srfi-26", "gnu.kawa.slib.cut");
        require.map("srfi-34", "gnu.kawa.slib.srfi34");
        require.map("srfi-35", "gnu.kawa.slib.conditions");
        require.map("condition", "gnu.kawa.slib.conditions");
        require.map("conditions", "gnu.kawa.slib.conditions");
        require.map("srfi-37", "gnu.kawa.slib.srfi37");
        require.map("args-fold", "gnu.kawa.slib.srfi37");
        require.map("srfi-41", "gnu.kawa.slib.Streams");
        require.map("srfi-41-streams", "gnu.kawa.slib.Streams");
        require.map("srfi-41-streams-type", "gnu.kawa.slib.StreamsType");
        require.map("srfi-41-streams-primitive", "gnu.kawa.slib.StreamsPrimitive");
        require.map("srfi-41-streams-derived", "gnu.kawa.slib.StreamsDerived");
        require.map("srfi-60", "gnu.kawa.slib.srfi60");
        require.map("srfi-64", "gnu.kawa.slib.testing");
        require.map("testing", "gnu.kawa.slib.testing");
        require.map("srfi-69", "gnu.kawa.slib.srfi69");
        require.map("hash-table", "gnu.kawa.slib.srfi69");
        require.map("basic-hash-tables", "gnu.kawa.slib.srfi69");
        require.map("srfi-95", "kawa.lib.srfi95");
        require.map("sorting-and-merging", "kawa.lib.srfi95");
        require.map("srfi-101", "gnu.kawa.slib.ralists");
        require.map("random-access-lists", "gnu.kawa.slib.ralists");
        require.map("ra-lists", "gnu.kawa.slib.ralists");
        require.map("regex", "kawa.lib.kawa.regex");
        require.map("pregexp", "gnu.kawa.slib.pregexp");
        require.map("gui", "gnu.kawa.slib.gui");
        require.map("swing-gui", "gnu.kawa.slib.swing");
        require.map("android-defs", "gnu.kawa.android.defs");
        require.map("javafx-defs", "gnu.kawa.javafx.defs");
        require.map("syntax-utils", "gnu.kawa.slib.syntaxutils");
        require.map("quaternions", "kawa.lib.kawa.quaternions");
    }

    public static interface DeclSetMapper {
        public Map<Symbol, Expression> map(Map<Symbol, Expression> var1, Compilation var2);
    }

}

