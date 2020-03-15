// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.expr.ModuleInfo;
import kawa.standard.IfFeature;
import gnu.expr.Symbols;
import gnu.kawa.xml.KNode;
import gnu.kawa.io.Path;
import gnu.mapping.Lazy;
import kawa.Version;
import kawa.lang.NamedException;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.mapping.Environment;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Namespace;
import gnu.mapping.Promise;
import kawa.standard.Scheme;
import gnu.lists.LList;
import gnu.mapping.Symbol;
import gnu.expr.KawaConvert;
import gnu.mapping.Procedure;
import gnu.lists.Consumer;
import gnu.mapping.MethodProc;
import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.mapping.SimpleSymbol;
import gnu.expr.Keyword;
import gnu.math.IntNum;
import gnu.expr.GenericProc;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class misc extends ModuleBody
{
    public static final ModuleMethod boolean$Qu;
    public static final ModuleMethod boolean$Eq$Qu;
    public static final ModuleMethod symbol$Qu;
    public static final ModuleMethod symbol$Mn$Grstring;
    public static final ModuleMethod symbol$Eq$Qu;
    public static final ModuleMethod symbol$Mnlocal$Mnname;
    public static final ModuleMethod symbol$Mnnamespace;
    public static final ModuleMethod symbol$Mnnamespace$Mnuri;
    public static final ModuleMethod symbol$Mnprefix;
    public static final ModuleMethod namespace$Mnuri;
    public static final ModuleMethod namespace$Mnprefix;
    public static final ModuleMethod string$Mn$Grsymbol;
    public static final ModuleMethod procedure$Qu;
    public static final ModuleMethod values;
    public static final ModuleMethod environment$Mnbound$Qu;
    public static final ModuleMethod null$Mnenvironment;
    public static final ModuleMethod scheme$Mnreport$Mnenvironment;
    public static final ModuleMethod interaction$Mnenvironment;
    public static final ModuleMethod scheme$Mnimplementation$Mnversion;
    public static final ModuleMethod set$Mnprocedure$Mnproperty$Ex;
    public static final GenericProc procedure$Mnproperty;
    public static final ModuleMethod dynamic$Mnwind;
    public static final ModuleMethod promise$Qu;
    public static final ModuleMethod make$Mnpromise;
    public static final ModuleMethod promise$Mnset$Mnvalue$Ex;
    public static final ModuleMethod promise$Mnset$Mnalias$Ex;
    public static final ModuleMethod promise$Mnset$Mnexception$Ex;
    public static final ModuleMethod promise$Mnset$Mnthunk$Ex;
    public static final ModuleMethod force;
    public static final ModuleMethod force$St;
    public static final ModuleMethod eager;
    public static final ModuleMethod base$Mnuri;
    public static final ModuleMethod gentemp;
    public static final ModuleMethod add$Mnprocedure$Mnproperties;
    public static final ModuleMethod features;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final Keyword Lit2;
    static final ModuleMethod procedure$Mnproperty$Fn1;
    public static misc $instance;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    
    public static Object values(final Object... args) {
        return Values.make(args);
    }
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        misc.procedure$Mnproperty.setProperty(misc.Lit2, misc.set$Mnprocedure$Mnproperty$Ex);
        final GenericProc procedure$Mnproperty2 = misc.procedure$Mnproperty;
        final Procedure procedure$Mnproperty = misc.procedure$Mnproperty$Fn1;
        procedure$Mnproperty2.add(misc.procedure$Mnproperty$Fn1);
    }
    
    public static boolean isBoolean(final Object x) {
        final boolean x2 = x == Boolean.TRUE;
        return x2 ? x2 : (x == Boolean.FALSE);
    }
    
    public static boolean isBoolean$Eq(final Object b1, final Object b2, final Object... r) {
        final int n = r.length - 1;
        boolean b3;
        if (KawaConvert.isTrue(b1)) {
            if (KawaConvert.isTrue(b2)) {
                int i = n;
                while (true) {
                    final boolean x = i < 0;
                    if (x) {
                        b3 = x;
                        break;
                    }
                    if (!KawaConvert.isTrue(r[i])) {
                        b3 = false;
                        break;
                    }
                    --i;
                }
            }
            else {
                b3 = false;
            }
        }
        else if (!KawaConvert.isTrue(b2)) {
            int i = n;
            while (true) {
                final boolean x = i < 0;
                if (x) {
                    b3 = x;
                    break;
                }
                if (KawaConvert.isTrue(r[i])) {
                    b3 = false;
                    break;
                }
                --i;
            }
        }
        else {
            b3 = false;
        }
        return b3;
    }
    
    public static boolean isSymbol(final Object x) {
        return x instanceof Symbol;
    }
    
    public static String symbol$To$String(final Symbol s) {
        return s.toString();
    }
    
    public static boolean isSymbol$Eq$V(final Symbol s1, final Symbol s2, final Object[] argsArray) {
        final LList r = LList.makeList(argsArray, 0);
        boolean b;
        if (Symbol.equals(s1, s2)) {
            final boolean x = lists.isNull(r);
            b = (x ? x : KawaConvert.isTrue(Promise.force(Scheme.apply.apply3(misc.symbol$Eq$Qu, s2, r))));
        }
        else {
            b = false;
        }
        return b;
    }
    
    public static String symbolLocalName(final Symbol s) {
        return s.getLocalPart();
    }
    
    public static Namespace symbolNamespace(final Symbol s) {
        return s.getNamespace();
    }
    
    public static String symbolNamespaceUri(final Symbol s) {
        return s.getNamespaceURI();
    }
    
    public static String symbolPrefix(final Symbol s) {
        return s.getPrefix();
    }
    
    public static CharSequence namespaceUri(final Namespace ns) {
        return ns.getName();
    }
    
    public static CharSequence namespacePrefix(final Namespace ns) {
        return ns.getPrefix();
    }
    
    public static SimpleSymbol string$To$Symbol(final CharSequence str) {
        return Symbol.valueOf(str.toString());
    }
    
    public static boolean isProcedure(final Object x) {
        final boolean x2 = x instanceof Procedure;
        return x2 ? x2 : (x instanceof LangObjType);
    }
    
    public static boolean isEnvironmentBound(final Environment env, final Object sym) {
        return env.isBound(LispLanguage.langSymbolToSymbol(sym));
    }
    
    public static Environment nullEnvironment() {
        return nullEnvironment(Boolean.FALSE);
    }
    
    public static Environment nullEnvironment(final Object version) {
        return Scheme.nullEnvironment;
    }
    
    public static Environment schemeReportEnvironment(final Object version) {
        switch (version.hashCode()) {
            case 4: {
                if (IsEqv.apply(version, misc.Lit0)) {
                    return Scheme.r4Environment;
                }
                break;
            }
            case 5: {
                if (IsEqv.apply(version, misc.Lit1)) {
                    return Scheme.r5Environment;
                }
                break;
            }
        }
        throw NamedException.makeError("scheme-report-environment version must be 4 or 5");
    }
    
    public static Environment interactionEnvironment() {
        return Environment.user();
    }
    
    public static String schemeImplementationVersion() {
        return Version.getVersion();
    }
    
    public static void setProcedureProperty$Ex(final Procedure proc, final Object key, final Object value) {
        proc.setProperty(key, value);
    }
    
    public static Object procedureProperty(final Procedure proc, final Object key) {
        return procedureProperty(proc, key, Boolean.FALSE);
    }
    
    public static Object procedureProperty(final Procedure proc, final Object key, final Object default) {
        return proc.getProperty(key, default);
    }
    
    public static Object dynamicWind(final Object before, final Object thunk, final Object after) {
        Scheme.applyToArgs.apply1(before);
        Object apply1;
        try {
            apply1 = Scheme.applyToArgs.apply1(thunk);
        }
        finally {
            Scheme.applyToArgs.apply1(after);
        }
        return apply1;
    }
    
    public static boolean isPromise(final Object obj) {
        return obj instanceof Lazy;
    }
    
    public static Lazy makePromise(final Object obj) {
        return (obj instanceof Lazy) ? ((Lazy)obj) : Promise.makeBoundPromise(obj);
    }
    
    public static void promiseSetValue$Ex(final Promise promise, final Object value) {
        promise.setValue(value);
    }
    
    public static void promiseSetAlias$Ex(final Promise promise, final Lazy aliasee) {
        promise.setAlias(aliasee);
    }
    
    public static void promiseSetException$Ex(final Promise promise, final Throwable exception) {
        promise.setException(exception);
    }
    
    public static void promiseSetThunk$Ex(final Promise promise, final Procedure thunk) {
        promise.setThunk(thunk);
    }
    
    public static Object force(final Object arg) {
        return Promise.force1(arg);
    }
    
    public static Object force$St(final Object arg) {
        return Promise.force(arg);
    }
    
    public static Procedure eager(final Object value) {
        return misc.eager;
    }
    
    public static Object baseUri() {
        return baseUri(null);
    }
    
    public static Object baseUri(final Object node) {
        final Path uri = (node == null) ? Path.currentPath() : ((KNode)Promise.force(node, KNode.class)).baseURI();
        return (uri == Values.empty) ? Boolean.FALSE : uri;
    }
    
    public static Symbol gentemp() {
        return Symbols.gentemp();
    }
    
    public static void addProcedureProperties(final GenericProc proc, final Object... args) {
        proc.setProperties(args);
    }
    
    public static LList features() {
        return IfFeature.featureList();
    }
    
    static {
        Lit37 = Symbol.valueOf("features");
        Lit36 = Symbol.valueOf("add-procedure-properties");
        Lit35 = Symbol.valueOf("gentemp");
        Lit34 = Symbol.valueOf("base-uri");
        Lit33 = Symbol.valueOf("eager");
        Lit32 = Symbol.valueOf("force*");
        Lit31 = Symbol.valueOf("force");
        Lit30 = Symbol.valueOf("promise-set-thunk!");
        Lit29 = Symbol.valueOf("promise-set-exception!");
        Lit28 = Symbol.valueOf("promise-set-alias!");
        Lit27 = Symbol.valueOf("promise-set-value!");
        Lit26 = Symbol.valueOf("make-promise");
        Lit25 = Symbol.valueOf("promise?");
        Lit24 = Symbol.valueOf("dynamic-wind");
        Lit23 = Symbol.valueOf("procedure-property");
        Lit22 = Symbol.valueOf("set-procedure-property!");
        Lit21 = Symbol.valueOf("scheme-implementation-version");
        Lit20 = Symbol.valueOf("interaction-environment");
        Lit19 = Symbol.valueOf("scheme-report-environment");
        Lit18 = Symbol.valueOf("null-environment");
        Lit17 = Symbol.valueOf("environment-bound?");
        Lit16 = Symbol.valueOf("values");
        Lit15 = Symbol.valueOf("procedure?");
        Lit14 = Symbol.valueOf("string->symbol");
        Lit13 = Symbol.valueOf("namespace-prefix");
        Lit12 = Symbol.valueOf("namespace-uri");
        Lit11 = Symbol.valueOf("symbol-prefix");
        Lit10 = Symbol.valueOf("symbol-namespace-uri");
        Lit9 = Symbol.valueOf("symbol-namespace");
        Lit8 = Symbol.valueOf("symbol-local-name");
        Lit7 = Symbol.valueOf("symbol=?");
        Lit6 = Symbol.valueOf("symbol->string");
        Lit5 = Symbol.valueOf("symbol?");
        Lit4 = Symbol.valueOf("boolean=?");
        Lit3 = Symbol.valueOf("boolean?");
        Lit2 = Keyword.make("setter");
        Lit1 = IntNum.valueOf(5);
        Lit0 = IntNum.valueOf(4);
        misc.$instance = new misc();
        final misc $instance = misc.$instance;
        boolean$Qu = new ModuleMethod($instance, 1, misc.Lit3, 4097);
        boolean$Eq$Qu = new ModuleMethod($instance, 2, misc.Lit4, -4094);
        symbol$Qu = new ModuleMethod($instance, 3, misc.Lit5, 4097);
        symbol$Mn$Grstring = new ModuleMethod($instance, 4, misc.Lit6, 4097);
        symbol$Eq$Qu = new ModuleMethod($instance, 5, misc.Lit7, -4094);
        symbol$Mnlocal$Mnname = new ModuleMethod($instance, 6, misc.Lit8, 4097);
        symbol$Mnnamespace = new ModuleMethod($instance, 7, misc.Lit9, 4097);
        symbol$Mnnamespace$Mnuri = new ModuleMethod($instance, 8, misc.Lit10, 4097);
        symbol$Mnprefix = new ModuleMethod($instance, 9, misc.Lit11, 4097);
        namespace$Mnuri = new ModuleMethod($instance, 10, misc.Lit12, 4097);
        namespace$Mnprefix = new ModuleMethod($instance, 11, misc.Lit13, 4097);
        string$Mn$Grsymbol = new ModuleMethod($instance, 12, misc.Lit14, 4097);
        procedure$Qu = new ModuleMethod($instance, 13, misc.Lit15, 4097);
        final ModuleMethod values2 = new ModuleMethod($instance, 14, misc.Lit16, -4096);
        values2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:valuesValidateApply");
        values2.setProperty(Procedure.compilerXKey, "kawa.lib.compile_misc:valuesCompile");
        values = values2;
        environment$Mnbound$Qu = new ModuleMethod($instance, 15, misc.Lit17, 8194);
        null$Mnenvironment = new ModuleMethod($instance, 16, misc.Lit18, 4096);
        scheme$Mnreport$Mnenvironment = new ModuleMethod($instance, 18, misc.Lit19, 4097);
        interaction$Mnenvironment = new ModuleMethod($instance, 19, misc.Lit20, 0);
        scheme$Mnimplementation$Mnversion = new ModuleMethod($instance, 20, misc.Lit21, 0);
        set$Mnprocedure$Mnproperty$Ex = new ModuleMethod($instance, 21, misc.Lit22, 12291);
        procedure$Mnproperty = new GenericProc("procedure-property");
        procedure$Mnproperty$Fn1 = new ModuleMethod($instance, 22, misc.Lit23, 12290);
        dynamic$Mnwind = new ModuleMethod($instance, 24, misc.Lit24, 12291);
        promise$Qu = new ModuleMethod($instance, 25, misc.Lit25, 4097);
        make$Mnpromise = new ModuleMethod($instance, 26, misc.Lit26, 4097);
        promise$Mnset$Mnvalue$Ex = new ModuleMethod($instance, 27, misc.Lit27, 8194);
        promise$Mnset$Mnalias$Ex = new ModuleMethod($instance, 28, misc.Lit28, 8194);
        promise$Mnset$Mnexception$Ex = new ModuleMethod($instance, 29, misc.Lit29, 8194);
        promise$Mnset$Mnthunk$Ex = new ModuleMethod($instance, 30, misc.Lit30, 8194);
        force = new ModuleMethod($instance, 31, misc.Lit31, 4097);
        force$St = new ModuleMethod($instance, 32, misc.Lit32, 4097);
        eager = new ModuleMethod($instance, 33, misc.Lit33, 4097);
        base$Mnuri = new ModuleMethod($instance, 34, misc.Lit34, 4096);
        gentemp = new ModuleMethod($instance, 36, misc.Lit35, 0);
        add$Mnprocedure$Mnproperties = new ModuleMethod($instance, 37, misc.Lit36, -4095);
        features = new ModuleMethod($instance, 38, misc.Lit37, 0);
        $runBody$();
    }
    
    public misc() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match0(final ModuleMethod proc, final CallContext ctx) {
        switch (proc.selector) {
            case 38: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 36: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 34: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 20: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 19: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 16: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            default: {
                return super.match0(proc, ctx);
            }
        }
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 34: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 33: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 32: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 31: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 26: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 25: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 18: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 16: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 13: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 12: {
                final Object force = Promise.force(o, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value1 = force;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 11: {
                final Object force2 = Promise.force(o, Namespace.class);
                if (!(force2 instanceof Namespace)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 10: {
                final Object force3 = Promise.force(o, Namespace.class);
                if (!(force3 instanceof Namespace)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 9: {
                final Object force4 = Promise.force(o, Symbol.class);
                if (!(force4 instanceof Symbol)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 8: {
                final Object force5 = Promise.force(o, Symbol.class);
                if (!(force5 instanceof Symbol)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 7: {
                final Object force6 = Promise.force(o, Symbol.class);
                if (!(force6 instanceof Symbol)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 6: {
                final Object force7 = Promise.force(o, Symbol.class);
                if (!(force7 instanceof Symbol)) {
                    return -786431;
                }
                ctx.value1 = force7;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                final Object force8 = Promise.force(o, Symbol.class);
                if (!(force8 instanceof Symbol)) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 3: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 30: {
                if (!(arg1 instanceof Promise)) {
                    return -786431;
                }
                ctx.value1 = arg1;
                final Object force = Promise.force(arg2, Procedure.class);
                if (!(force instanceof Procedure)) {
                    return -786430;
                }
                ctx.value2 = force;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 29: {
                if (!(arg1 instanceof Promise)) {
                    return -786431;
                }
                ctx.value1 = arg1;
                final Object force2 = Promise.force(arg2, Throwable.class);
                if (!(force2 instanceof Throwable)) {
                    return -786430;
                }
                ctx.value2 = force2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 28: {
                if (!(arg1 instanceof Promise)) {
                    return -786431;
                }
                ctx.value1 = arg1;
                if (!(arg2 instanceof Lazy)) {
                    return -786430;
                }
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 27: {
                if (!(arg1 instanceof Promise)) {
                    return -786431;
                }
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 22: {
                final Object force3 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force3) != null) {
                    ctx.value1 = force3;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 15: {
                final Object force4 = Promise.force(arg1, Environment.class);
                if (!(force4 instanceof Environment)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            default: {
                return super.match2(proc, arg1, arg2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 24: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.value3 = o3;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 22: {
                final Object force = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force) != null) {
                    ctx.value1 = force;
                    ctx.value2 = o2;
                    ctx.value3 = o3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 21: {
                final Object force2 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force2) != null) {
                    ctx.value1 = force2;
                    ctx.value2 = o2;
                    ctx.value3 = o3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            default: {
                return super.match3(moduleMethod, o, o2, o3, ctx);
            }
        }
    }
    
    @Override
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        switch (proc.selector) {
            case 37: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 14: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 5: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 2: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            default: {
                return super.matchN(proc, args, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply0(final ModuleMethod method) {
        switch (method.selector) {
            case 16: {
                return nullEnvironment();
            }
            case 19: {
                return interactionEnvironment();
            }
            case 20: {
                return schemeImplementationVersion();
            }
            case 34: {
                return baseUri();
            }
            case 36: {
                return gentemp();
            }
            case 38: {
                return features();
            }
            default: {
                return super.apply0(method);
            }
        }
    }
    
    @Override
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                2: 156
        //                3: 363
        //                4: 173
        //                5: 190
        //                6: 363
        //                7: 203
        //                8: 216
        //                9: 229
        //               10: 242
        //               11: 255
        //               12: 268
        //               13: 281
        //               14: 294
        //               15: 363
        //               16: 363
        //               17: 311
        //               18: 363
        //               19: 316
        //               20: 363
        //               21: 363
        //               22: 363
        //               23: 363
        //               24: 363
        //               25: 363
        //               26: 321
        //               27: 338
        //               28: 363
        //               29: 363
        //               30: 363
        //               31: 363
        //               32: 343
        //               33: 348
        //               34: 353
        //               35: 358
        //          default: 363
        //        }
        //   156: aload_2        
        //   157: invokestatic    kawa/lib/misc.isBoolean:(Ljava/lang/Object;)Z
        //   160: ifeq            169
        //   163: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   166: goto            172
        //   169: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   172: areturn        
        //   173: aload_2        
        //   174: invokestatic    kawa/lib/misc.isSymbol:(Ljava/lang/Object;)Z
        //   177: ifeq            186
        //   180: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   183: goto            189
        //   186: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   189: areturn        
        //   190: aload_2        
        //   191: ldc             Lgnu/mapping/Symbol;.class
        //   193: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   196: checkcast       Lgnu/mapping/Symbol;
        //   199: invokestatic    kawa/lib/misc.symbol$To$String:(Lgnu/mapping/Symbol;)Ljava/lang/String;
        //   202: areturn        
        //   203: aload_2        
        //   204: ldc             Lgnu/mapping/Symbol;.class
        //   206: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   209: checkcast       Lgnu/mapping/Symbol;
        //   212: invokestatic    kawa/lib/misc.symbolLocalName:(Lgnu/mapping/Symbol;)Ljava/lang/String;
        //   215: areturn        
        //   216: aload_2        
        //   217: ldc             Lgnu/mapping/Symbol;.class
        //   219: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   222: checkcast       Lgnu/mapping/Symbol;
        //   225: invokestatic    kawa/lib/misc.symbolNamespace:(Lgnu/mapping/Symbol;)Lgnu/mapping/Namespace;
        //   228: areturn        
        //   229: aload_2        
        //   230: ldc             Lgnu/mapping/Symbol;.class
        //   232: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   235: checkcast       Lgnu/mapping/Symbol;
        //   238: invokestatic    kawa/lib/misc.symbolNamespaceUri:(Lgnu/mapping/Symbol;)Ljava/lang/String;
        //   241: areturn        
        //   242: aload_2        
        //   243: ldc             Lgnu/mapping/Symbol;.class
        //   245: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   248: checkcast       Lgnu/mapping/Symbol;
        //   251: invokestatic    kawa/lib/misc.symbolPrefix:(Lgnu/mapping/Symbol;)Ljava/lang/String;
        //   254: areturn        
        //   255: aload_2        
        //   256: ldc             Lgnu/mapping/Namespace;.class
        //   258: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   261: checkcast       Lgnu/mapping/Namespace;
        //   264: invokestatic    kawa/lib/misc.namespaceUri:(Lgnu/mapping/Namespace;)Ljava/lang/CharSequence;
        //   267: areturn        
        //   268: aload_2        
        //   269: ldc             Lgnu/mapping/Namespace;.class
        //   271: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   274: checkcast       Lgnu/mapping/Namespace;
        //   277: invokestatic    kawa/lib/misc.namespacePrefix:(Lgnu/mapping/Namespace;)Ljava/lang/CharSequence;
        //   280: areturn        
        //   281: aload_2        
        //   282: ldc             Ljava/lang/CharSequence;.class
        //   284: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   287: checkcast       Ljava/lang/CharSequence;
        //   290: invokestatic    kawa/lib/misc.string$To$Symbol:(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
        //   293: areturn        
        //   294: aload_2        
        //   295: invokestatic    kawa/lib/misc.isProcedure:(Ljava/lang/Object;)Z
        //   298: ifeq            307
        //   301: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   304: goto            310
        //   307: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   310: areturn        
        //   311: aload_2        
        //   312: invokestatic    kawa/lib/misc.nullEnvironment:(Ljava/lang/Object;)Lgnu/mapping/Environment;
        //   315: areturn        
        //   316: aload_2        
        //   317: invokestatic    kawa/lib/misc.schemeReportEnvironment:(Ljava/lang/Object;)Lgnu/mapping/Environment;
        //   320: areturn        
        //   321: aload_2        
        //   322: invokestatic    kawa/lib/misc.isPromise:(Ljava/lang/Object;)Z
        //   325: ifeq            334
        //   328: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   331: goto            337
        //   334: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   337: areturn        
        //   338: aload_2        
        //   339: invokestatic    kawa/lib/misc.makePromise:(Ljava/lang/Object;)Lgnu/mapping/Lazy;
        //   342: areturn        
        //   343: aload_2        
        //   344: invokestatic    kawa/lib/misc.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   347: areturn        
        //   348: aload_2        
        //   349: invokestatic    kawa/lib/misc.force$St:(Ljava/lang/Object;)Ljava/lang/Object;
        //   352: areturn        
        //   353: aload_2        
        //   354: invokestatic    kawa/lib/misc.eager:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   357: areturn        
        //   358: aload_2        
        //   359: invokestatic    kawa/lib/misc.baseUri:(Ljava/lang/Object;)Ljava/lang/Object;
        //   362: areturn        
        //   363: aload_0        
        //   364: aload_1        
        //   365: aload_2        
        //   366: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   369: areturn        
        //   370: new             Lgnu/mapping/WrongType;
        //   373: dup_x1         
        //   374: swap           
        //   375: ldc_w           "symbol->string"
        //   378: iconst_1       
        //   379: aload_2        
        //   380: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   383: athrow         
        //   384: new             Lgnu/mapping/WrongType;
        //   387: dup_x1         
        //   388: swap           
        //   389: ldc_w           "symbol-local-name"
        //   392: iconst_1       
        //   393: aload_2        
        //   394: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   397: athrow         
        //   398: new             Lgnu/mapping/WrongType;
        //   401: dup_x1         
        //   402: swap           
        //   403: ldc_w           "symbol-namespace"
        //   406: iconst_1       
        //   407: aload_2        
        //   408: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   411: athrow         
        //   412: new             Lgnu/mapping/WrongType;
        //   415: dup_x1         
        //   416: swap           
        //   417: ldc_w           "symbol-namespace-uri"
        //   420: iconst_1       
        //   421: aload_2        
        //   422: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   425: athrow         
        //   426: new             Lgnu/mapping/WrongType;
        //   429: dup_x1         
        //   430: swap           
        //   431: ldc_w           "symbol-prefix"
        //   434: iconst_1       
        //   435: aload_2        
        //   436: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   439: athrow         
        //   440: new             Lgnu/mapping/WrongType;
        //   443: dup_x1         
        //   444: swap           
        //   445: ldc_w           "namespace-uri"
        //   448: iconst_1       
        //   449: aload_2        
        //   450: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   453: athrow         
        //   454: new             Lgnu/mapping/WrongType;
        //   457: dup_x1         
        //   458: swap           
        //   459: ldc_w           "namespace-prefix"
        //   462: iconst_1       
        //   463: aload_2        
        //   464: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   467: athrow         
        //   468: new             Lgnu/mapping/WrongType;
        //   471: dup_x1         
        //   472: swap           
        //   473: ldc_w           "string->symbol"
        //   476: iconst_1       
        //   477: aload_2        
        //   478: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   481: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  196    199    370    384    Ljava/lang/ClassCastException;
        //  209    212    384    398    Ljava/lang/ClassCastException;
        //  222    225    398    412    Ljava/lang/ClassCastException;
        //  235    238    412    426    Ljava/lang/ClassCastException;
        //  248    251    426    440    Ljava/lang/ClassCastException;
        //  261    264    440    454    Ljava/lang/ClassCastException;
        //  274    277    454    468    Ljava/lang/ClassCastException;
        //  287    290    468    482    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 169 out of bounds for length 169
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //               15: 64
        //               22: 90
        //               27: 104
        //               28: 116
        //               29: 131
        //               30: 152
        //          default: 172
        //        }
        //    64: aload_2        
        //    65: ldc             Lgnu/mapping/Environment;.class
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    70: checkcast       Lgnu/mapping/Environment;
        //    73: aload_3        
        //    74: invokestatic    kawa/lib/misc.isEnvironmentBound:(Lgnu/mapping/Environment;Ljava/lang/Object;)Z
        //    77: ifeq            86
        //    80: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    83: goto            89
        //    86: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    89: areturn        
        //    90: aload_2        
        //    91: ldc             Lgnu/mapping/Procedure;.class
        //    93: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    96: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    99: aload_3        
        //   100: invokestatic    kawa/lib/misc.procedureProperty:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: areturn        
        //   104: aload_2        
        //   105: checkcast       Lgnu/mapping/Promise;
        //   108: aload_3        
        //   109: invokestatic    kawa/lib/misc.promiseSetValue$Ex:(Lgnu/mapping/Promise;Ljava/lang/Object;)V
        //   112: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   115: areturn        
        //   116: aload_2        
        //   117: checkcast       Lgnu/mapping/Promise;
        //   120: aload_3        
        //   121: checkcast       Lgnu/mapping/Lazy;
        //   124: invokestatic    kawa/lib/misc.promiseSetAlias$Ex:(Lgnu/mapping/Promise;Lgnu/mapping/Lazy;)V
        //   127: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   130: areturn        
        //   131: aload_2        
        //   132: checkcast       Lgnu/mapping/Promise;
        //   135: aload_3        
        //   136: ldc_w           Ljava/lang/Throwable;.class
        //   139: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   142: checkcast       Ljava/lang/Throwable;
        //   145: invokestatic    kawa/lib/misc.promiseSetException$Ex:(Lgnu/mapping/Promise;Ljava/lang/Throwable;)V
        //   148: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   151: areturn        
        //   152: aload_2        
        //   153: checkcast       Lgnu/mapping/Promise;
        //   156: aload_3        
        //   157: ldc             Lgnu/mapping/Procedure;.class
        //   159: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   162: checkcast       Lgnu/mapping/Procedure;
        //   165: invokestatic    kawa/lib/misc.promiseSetThunk$Ex:(Lgnu/mapping/Promise;Lgnu/mapping/Procedure;)V
        //   168: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   171: areturn        
        //   172: aload_0        
        //   173: aload_1        
        //   174: aload_2        
        //   175: aload_3        
        //   176: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   179: areturn        
        //   180: new             Lgnu/mapping/WrongType;
        //   183: dup_x1         
        //   184: swap           
        //   185: ldc_w           "environment-bound?"
        //   188: iconst_1       
        //   189: aload_2        
        //   190: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   193: athrow         
        //   194: new             Lgnu/mapping/WrongType;
        //   197: dup_x1         
        //   198: swap           
        //   199: ldc_w           "procedure-property"
        //   202: iconst_1       
        //   203: aload_2        
        //   204: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   207: athrow         
        //   208: new             Lgnu/mapping/WrongType;
        //   211: dup_x1         
        //   212: swap           
        //   213: ldc_w           "promise-set-value!"
        //   216: iconst_1       
        //   217: aload_2        
        //   218: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   221: athrow         
        //   222: new             Lgnu/mapping/WrongType;
        //   225: dup_x1         
        //   226: swap           
        //   227: ldc_w           "promise-set-alias!"
        //   230: iconst_1       
        //   231: aload_2        
        //   232: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   235: athrow         
        //   236: new             Lgnu/mapping/WrongType;
        //   239: dup_x1         
        //   240: swap           
        //   241: ldc_w           "promise-set-alias!"
        //   244: iconst_2       
        //   245: aload_3        
        //   246: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   249: athrow         
        //   250: new             Lgnu/mapping/WrongType;
        //   253: dup_x1         
        //   254: swap           
        //   255: ldc_w           "promise-set-exception!"
        //   258: iconst_1       
        //   259: aload_2        
        //   260: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   263: athrow         
        //   264: new             Lgnu/mapping/WrongType;
        //   267: dup_x1         
        //   268: swap           
        //   269: ldc_w           "promise-set-exception!"
        //   272: iconst_2       
        //   273: aload_3        
        //   274: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   277: athrow         
        //   278: new             Lgnu/mapping/WrongType;
        //   281: dup_x1         
        //   282: swap           
        //   283: ldc_w           "promise-set-thunk!"
        //   286: iconst_1       
        //   287: aload_2        
        //   288: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   291: athrow         
        //   292: new             Lgnu/mapping/WrongType;
        //   295: dup_x1         
        //   296: swap           
        //   297: ldc_w           "promise-set-thunk!"
        //   300: iconst_2       
        //   301: aload_3        
        //   302: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   305: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  70     73     180    194    Ljava/lang/ClassCastException;
        //  96     99     194    208    Ljava/lang/ClassCastException;
        //  105    108    208    222    Ljava/lang/ClassCastException;
        //  117    120    222    236    Ljava/lang/ClassCastException;
        //  121    124    236    250    Ljava/lang/ClassCastException;
        //  132    135    250    264    Ljava/lang/ClassCastException;
        //  142    145    264    278    Ljava/lang/ClassCastException;
        //  153    156    278    292    Ljava/lang/ClassCastException;
        //  162    165    292    306    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 130 out of bounds for length 130
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply3(final ModuleMethod p0, final Object p1, final Object p2, final Object p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //               42: 36
        //               43: 55
        //               44: 79
        //               45: 71
        //          default: 79
        //        }
        //    36: aload_2        
        //    37: ldc             Lgnu/mapping/Procedure;.class
        //    39: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    42: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    45: aload_3        
        //    46: aload           4
        //    48: invokestatic    kawa/lib/misc.setProcedureProperty$Ex:(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)V
        //    51: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    54: areturn        
        //    55: aload_2        
        //    56: ldc             Lgnu/mapping/Procedure;.class
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    61: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    64: aload_3        
        //    65: aload           4
        //    67: invokestatic    kawa/lib/misc.procedureProperty:(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    70: areturn        
        //    71: aload_2        
        //    72: aload_3        
        //    73: aload           4
        //    75: invokestatic    kawa/lib/misc.dynamicWind:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    78: areturn        
        //    79: aload_0        
        //    80: aload_1        
        //    81: aload_2        
        //    82: aload_3        
        //    83: aload           4
        //    85: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    88: areturn        
        //    89: new             Lgnu/mapping/WrongType;
        //    92: dup_x1         
        //    93: swap           
        //    94: ldc_w           "set-procedure-property!"
        //    97: iconst_1       
        //    98: aload_2        
        //    99: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   102: athrow         
        //   103: new             Lgnu/mapping/WrongType;
        //   106: dup_x1         
        //   107: swap           
        //   108: ldc_w           "procedure-property"
        //   111: iconst_1       
        //   112: aload_2        
        //   113: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   116: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  42     45     89     103    Ljava/lang/ClassCastException;
        //  61     64     103    117    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0071:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object applyN(final ModuleMethod p0, final Object[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                2: 48
        //                5: 97
        //               14: 166
        //               37: 171
        //          default: 218
        //        }
        //    48: aload_2        
        //    49: iconst_0       
        //    50: aaload         
        //    51: aload_2        
        //    52: iconst_1       
        //    53: aaload         
        //    54: aload_2        
        //    55: arraylength    
        //    56: iconst_2       
        //    57: isub           
        //    58: istore_3       
        //    59: iload_3        
        //    60: anewarray       Ljava/lang/Object;
        //    63: goto            74
        //    66: dup            
        //    67: iload_3        
        //    68: aload_2        
        //    69: iload_3        
        //    70: iconst_2       
        //    71: iadd           
        //    72: aaload         
        //    73: aastore        
        //    74: iinc            3, -1
        //    77: iload_3        
        //    78: ifge            66
        //    81: invokestatic    kawa/lib/misc.isBoolean$Eq:(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
        //    84: ifeq            93
        //    87: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    90: goto            96
        //    93: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    96: areturn        
        //    97: aload_2        
        //    98: iconst_0       
        //    99: aaload         
        //   100: ldc             Lgnu/mapping/Symbol;.class
        //   102: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   105: dup            
        //   106: astore_3       
        //   107: checkcast       Lgnu/mapping/Symbol;
        //   110: aload_2        
        //   111: iconst_1       
        //   112: aaload         
        //   113: ldc             Lgnu/mapping/Symbol;.class
        //   115: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   118: dup            
        //   119: astore_3       
        //   120: checkcast       Lgnu/mapping/Symbol;
        //   123: aload_2        
        //   124: arraylength    
        //   125: iconst_2       
        //   126: isub           
        //   127: istore_3       
        //   128: iload_3        
        //   129: anewarray       Ljava/lang/Object;
        //   132: goto            143
        //   135: dup            
        //   136: iload_3        
        //   137: aload_2        
        //   138: iload_3        
        //   139: iconst_2       
        //   140: iadd           
        //   141: aaload         
        //   142: aastore        
        //   143: iinc            3, -1
        //   146: iload_3        
        //   147: ifge            135
        //   150: invokestatic    kawa/lib/misc.isSymbol$Eq$V:(Lgnu/mapping/Symbol;Lgnu/mapping/Symbol;[Ljava/lang/Object;)Z
        //   153: ifeq            162
        //   156: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   159: goto            165
        //   162: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   165: areturn        
        //   166: aload_2        
        //   167: invokestatic    kawa/lib/misc.values:([Ljava/lang/Object;)Ljava/lang/Object;
        //   170: areturn        
        //   171: aload_2        
        //   172: iconst_0       
        //   173: aaload         
        //   174: ldc             Lgnu/expr/GenericProc;.class
        //   176: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   179: dup            
        //   180: astore_3       
        //   181: checkcast       Lgnu/expr/GenericProc;
        //   184: aload_2        
        //   185: arraylength    
        //   186: iconst_1       
        //   187: isub           
        //   188: istore_3       
        //   189: iload_3        
        //   190: anewarray       Ljava/lang/Object;
        //   193: goto            204
        //   196: dup            
        //   197: iload_3        
        //   198: aload_2        
        //   199: iload_3        
        //   200: iconst_1       
        //   201: iadd           
        //   202: aaload         
        //   203: aastore        
        //   204: iinc            3, -1
        //   207: iload_3        
        //   208: ifge            196
        //   211: invokestatic    kawa/lib/misc.addProcedureProperties:(Lgnu/expr/GenericProc;[Ljava/lang/Object;)V
        //   214: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   217: areturn        
        //   218: aload_0        
        //   219: aload_1        
        //   220: aload_2        
        //   221: invokespecial   gnu/expr/ModuleBody.applyN:(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
        //   224: areturn        
        //   225: new             Lgnu/mapping/WrongType;
        //   228: dup_x1         
        //   229: swap           
        //   230: ldc_w           "symbol=?"
        //   233: iconst_1       
        //   234: aload_3        
        //   235: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   238: athrow         
        //   239: new             Lgnu/mapping/WrongType;
        //   242: dup_x1         
        //   243: swap           
        //   244: ldc_w           "symbol=?"
        //   247: iconst_2       
        //   248: aload_3        
        //   249: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   252: athrow         
        //   253: new             Lgnu/mapping/WrongType;
        //   256: dup_x1         
        //   257: swap           
        //   258: ldc_w           "add-procedure-properties"
        //   261: iconst_1       
        //   262: aload_3        
        //   263: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   266: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  107    110    225    239    Ljava/lang/ClassCastException;
        //  120    123    239    253    Ljava/lang/ClassCastException;
        //  181    184    253    267    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 137 out of bounds for length 137
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
