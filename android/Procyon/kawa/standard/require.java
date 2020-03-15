// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.text.SourceLocator;
import gnu.bytecode.Method;
import java.util.Iterator;
import gnu.expr.ModuleExp;
import gnu.bytecode.Field;
import gnu.text.SourceMessages;
import gnu.mapping.Procedure;
import gnu.expr.ApplyExp;
import gnu.kawa.reflect.SlotGet;
import gnu.expr.SetExp;
import java.util.Map;
import gnu.expr.ReferenceExp;
import gnu.expr.Declaration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import gnu.kawa.reflect.Invoke;
import gnu.expr.QuoteExp;
import gnu.expr.Expression;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.FileNotFoundException;
import gnu.kawa.io.InPort;
import gnu.expr.Language;
import gnu.kawa.io.Path;
import gnu.bytecode.Type;
import gnu.expr.ModuleInfo;
import gnu.mapping.SimpleSymbol;
import gnu.expr.Mangling;
import gnu.expr.Compilation;
import gnu.bytecode.ClassType;
import gnu.mapping.Symbol;
import gnu.lists.LList;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.expr.ModuleManager;
import java.util.Hashtable;
import kawa.lang.Syntax;

public class require extends Syntax
{
    public static final require require;
    static Hashtable featureMap;
    private static final String SLIB_PREFIX = "gnu.kawa.slib.";
    
    static void map(final String featureName, final String className) {
        kawa.standard.require.featureMap.put(featureName, className);
    }
    
    public static String mapFeature(final String featureName) {
        return kawa.standard.require.featureMap.get(featureName);
    }
    
    public static Object find(final String typeName) {
        return ModuleManager.getInstance().findWithClassName(typeName).getInstance();
    }
    
    @Override
    public boolean scanForDefinitions(final Pair st, final ScopeExp defs, final Translator tr) {
        if (tr.getState() == 1) {
            tr.setState(2);
            tr.pendingForm = st;
            return true;
        }
        final Pair args = (Pair)st.getCdr();
        final Object name = args.getCar();
        Type type = null;
        Pair p;
        if (name instanceof Pair && tr.matches((p = (Pair)name).getCar(), "quote")) {
            Object fname = p.getCdr();
            if (!(fname instanceof Pair) || (p = (Pair)fname).getCdr() != LList.Empty || !(p.getCar() instanceof Symbol)) {
                tr.error('e', "invalid quoted symbol for 'require'");
                return false;
            }
            fname = mapFeature(p.getCar().toString());
            if (fname == null) {
                tr.error('e', "unknown feature name '" + p.getCar() + "' for 'require'");
                return false;
            }
            type = ClassType.make((String)fname);
        }
        else if (name instanceof CharSequence) {
            final String sourceName = name.toString();
            final ModuleInfo info = lookupModuleFromSourcePath(sourceName, defs);
            if (info == null) {
                tr.error('e', "malformed URL: " + sourceName);
                return false;
            }
            return importDefinitions(null, info, null, tr.formStack, defs, tr);
        }
        else if (name instanceof Symbol && !tr.selfEvaluatingSymbol(name)) {
            String requestedClass = name.toString();
            final int nlen = requestedClass.length();
            if (nlen > 2 && requestedClass.charAt(0) == '<' && requestedClass.charAt(nlen - 1) == '>') {
                requestedClass = requestedClass.substring(1, nlen - 1);
            }
            final String implicitSource = requestedClass.replace('.', '/');
            requestedClass = Mangling.mangleQualifiedName(requestedClass);
            String explicitSource = null;
            if (args.getCdr() instanceof Pair) {
                final Object sname = ((Pair)args.getCdr()).getCar();
                if (sname instanceof CharSequence) {
                    explicitSource = sname.toString();
                }
            }
            ImportFromLibrary.handleImport(implicitSource, explicitSource, requestedClass, defs, tr, null);
            return true;
        }
        if (!(type instanceof ClassType)) {
            if (type != null) {
                tr.error('e', "specifier for 'require' is not a classname");
            }
            else if (name instanceof SimpleSymbol) {
                tr.error('e', "class '" + name + "' for 'require' not found");
            }
            else {
                tr.error('e', "invalid specifier for 'require'");
            }
            return false;
        }
        ModuleInfo minfo;
        try {
            minfo = ModuleInfo.find((ClassType)type);
        }
        catch (Exception ex) {
            tr.error('e', "unknown class " + type.getName());
            return false;
        }
        importDefinitions(null, minfo, null, tr.formStack, defs, tr);
        return true;
    }
    
    public static ModuleInfo lookupModuleFromSourcePath(String sourceName, final ScopeExp defs) {
        final ModuleManager manager = ModuleManager.getInstance();
        final String baseName = defs.getFileName();
        if (baseName != null && baseName != "/dev/stdin" && baseName != "<string>" && baseName != "<eval>") {
            sourceName = Path.valueOf(baseName).resolve(sourceName).toString();
        }
        return manager.findWithSourcePath(sourceName);
    }
    
    public static boolean importDefinitions(final String className, ModuleInfo info, final DeclSetMapper mapper, final Translator.FormStack forms, final ScopeExp defs, final Compilation tr) {
        final ModuleManager manager = ModuleManager.getInstance();
        if ((info.getState() & 0x1) == 0x0 && info.getCompilation() == null && !info.checkCurrent(manager, System.currentTimeMillis())) {
            final SourceMessages messages = tr.getMessages();
            final Language language = Language.getDefaultLanguage();
            Compilation comp;
            try {
                final InPort fstream = InPort.openFile(info.getSourceAbsPath());
                info.clearClass();
                int options = 8;
                if (tr.immediate) {
                    options |= 0x1;
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
            catch (IOException ex2) {
                tr.error('e', "caught " + ex2);
                return false;
            }
            catch (SyntaxException ex3) {
                if (ex3.getMessages() != messages) {
                    throw new RuntimeException("confussing syntax error: " + ex3);
                }
                return false;
            }
            final String compiledClassName = comp.getModule().classFor(comp).getName();
            if (className != null) {
                final Map<String, ModuleInfo> subModuleMap = comp.subModuleMap;
                ModuleInfo modinfo;
                if (subModuleMap != null) {
                    modinfo = subModuleMap.get(className);
                }
                else {
                    modinfo = null;
                }
                if (modinfo == null) {
                    final String[] classPrefixPath = ImportFromLibrary.classPrefixPath;
                    for (int classPrefixPathLength = classPrefixPath.length, i = 0; i < classPrefixPathLength; ++i) {
                        final String tname = classPrefixPath[i] + className;
                        if (tname.equals(compiledClassName)) {
                            modinfo = info;
                            break;
                        }
                    }
                }
                if (modinfo == null) {
                    tr.error('e', "file '" + info.getSourceAbsPath() + "' does not declare library '" + className + "'");
                }
                else {
                    info = modinfo;
                }
            }
        }
        final ModuleInfo curinfo = tr.getMinfo();
        if (curinfo != null && tr.getState() < 4) {
            curinfo.addDependency(info);
            if (!info.loadEager(14) && info.getState() < 6) {
                tr.pushPendingImport(info, defs, forms, mapper);
                return true;
            }
        }
        final ClassType type = info.getClassType();
        final String tname2 = type.getName();
        final boolean sharedModule = tr.sharedModuleDefs();
        final boolean isRunnable = (info.getState() < 6) ? info.getCompilation().makeRunnable() : type.isSubtype(Compilation.typeRunnable);
        Declaration decl = null;
        final ClassType thisType = ClassType.make("kawa.standard.require");
        Expression[] args = { new QuoteExp((Object)tname2) };
        Expression dofind = Invoke.makeInvokeStatic(thisType, "find", args);
        Field instanceField = null;
        final Language language2 = tr.getLanguage();
        dofind.setLine(tr);
        final ModuleExp mod = info.setupModuleExp();
        Map<Symbol, Expression> dmap = new LinkedHashMap<Symbol, Expression>();
        Map<String, Declaration> moduleReferences = null;
        for (Declaration fdecl = mod.firstDecl(); fdecl != null; fdecl = fdecl.nextDecl()) {
            if (!fdecl.isPrivate()) {
                if (fdecl.field != null) {
                    final String fname = fdecl.field.getName();
                    if (fname.equals("$instance")) {
                        instanceField = fdecl.field;
                        continue;
                    }
                }
                if (fdecl.field != null && fdecl.field.getName().endsWith("$instance")) {
                    if (moduleReferences == null) {
                        moduleReferences = new HashMap<String, Declaration>();
                    }
                    moduleReferences.put(fdecl.field.getName(), fdecl);
                }
                else {
                    dmap.put((Symbol)fdecl.getSymbol(), new ReferenceExp(fdecl));
                }
            }
        }
        if (mapper != null) {
            dmap = mapper.map(dmap, tr);
        }
        for (final Map.Entry<Symbol, Expression> entry : dmap.entrySet()) {
            final Symbol aname = entry.getKey();
            final ReferenceExp fref = entry.getValue();
            final Declaration fdecl2 = fref.getBinding();
            final Declaration old = defs.lookup(aname, language2, language2.getNamespaceOf(fdecl2));
            if (old != null && !old.getFlag(512L) && Declaration.followAliases(old) == Declaration.followAliases(fdecl2)) {
                continue;
            }
            if (decl == null && !fdecl2.getFlag(2048L)) {
                final String iname = tname2.replace('.', '$') + "$instance";
                decl = new Declaration(Symbol.valueOf(iname), type);
                decl.setPrivate(true);
                decl.setFlag(1073758208L);
                defs.addDeclaration(decl);
                decl.noteValue(dofind);
                final SetExp sexp = new SetExp(decl, dofind);
                sexp.setLine(tr);
                sexp.setDefining(true);
                forms.push(sexp);
                decl.setFlag(536870912L);
                if (isRunnable) {
                    decl.setSimple(false);
                }
                decl.setFlag(8192L);
            }
            Declaration adecl;
            if (old != null && old.getFlag(66048L)) {
                old.setFlag(false, 66048L);
                adecl = old;
            }
            else {
                adecl = defs.addDeclaration(aname);
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
            linkDecls(adecl, fdecl2, fref, forms, tr);
            final Expression fval = fdecl2.getValue();
            if (!fdecl2.isIndirectBinding() || !(fval instanceof ReferenceExp)) {
                continue;
            }
            final ReferenceExp aref = (ReferenceExp)adecl.getValue();
            final Declaration xdecl = ((ReferenceExp)fval).getBinding();
            aref.setBinding(xdecl);
            if (xdecl == null || !xdecl.needsContext()) {
                continue;
            }
            final String iname2 = xdecl.field.getDeclaringClass().getName().replace('.', '$') + "$instance";
            Declaration cdecl = (moduleReferences == null) ? null : moduleReferences.get(iname2);
            if (cdecl == null) {
                continue;
            }
            if (cdecl.context != defs) {
                final Declaration acdecl = defs.addDeclaration(Symbol.valueOf(iname2));
                moduleReferences.put(iname2, acdecl);
                acdecl.setFlag(1073766400L);
                acdecl.setType(cdecl.getType());
                final ReferenceExp cref = new ReferenceExp(cdecl);
                cref.setContextDecl(decl);
                linkDecls(acdecl, cdecl, cref, forms, tr);
                cdecl = acdecl;
            }
            cdecl.setFlag(1024L);
            aref.setContextDecl(cdecl);
        }
        if (isRunnable) {
            final Method run = Compilation.typeRunnable.getDeclaredMethod("run", 0);
            if (decl != null) {
                dofind = new ReferenceExp(decl);
            }
            else if (instanceField != null) {
                args = new Expression[] { new QuoteExp(type), new QuoteExp((Object)"$instance") };
                dofind = new ApplyExp(SlotGet.staticField, args);
            }
            dofind = new ApplyExp(run, new Expression[] { dofind });
            dofind.setLine(tr);
            forms.push(dofind);
        }
        return true;
    }
    
    static void linkDecls(final Declaration adecl, final Declaration fdecl, final ReferenceExp fref, final Translator.FormStack forms, final Compilation tr) {
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
        final SetExp sexp = new SetExp(adecl, fref);
        adecl.setFlag(536870912L);
        sexp.setDefining(true);
        forms.push(sexp);
        adecl.noteValue(fref);
        adecl.setFlag(131072L);
        tr.push(adecl);
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        return null;
    }
    
    static {
        (require = new require()).setName("require");
        kawa.standard.require.featureMap = new Hashtable();
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
    
    public interface DeclSetMapper
    {
        Map<Symbol, Expression> map(final Map<Symbol, Expression> p0, final Compilation p1);
    }
}
