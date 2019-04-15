/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.KawaConvert;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Symbols;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.io.Path;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.xml.KNode;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Lazy;
import gnu.mapping.MethodProc;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.Version;
import kawa.lang.NamedException;
import kawa.lib.lists;
import kawa.standard.IfFeature;
import kawa.standard.Scheme;

public class misc
extends ModuleBody {
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

    public static /* varargs */ Object values(Object ... args) {
        return Values.make(args);
    }

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        procedure$Mnproperty.setProperty(Lit2, set$Mnprocedure$Mnproperty$Ex);
        ModuleMethod procedure$Mnproperty = procedure$Mnproperty$Fn1;
        ModuleMethod moduleMethod = procedure$Mnproperty$Fn1;
        misc.procedure$Mnproperty.add(moduleMethod);
    }

    public static boolean isBoolean(Object x) {
        boolean x2;
        boolean bl = x2 = x == Boolean.TRUE;
        return x2 ? x2 : x == Boolean.FALSE;
    }

    public static /* varargs */ boolean isBoolean$Eq(Object b1, Object b2, Object ... r) {
        boolean bl;
        block10 : {
            int n = r.length - 1;
            if (KawaConvert.isTrue(b1)) {
                if (KawaConvert.isTrue(b2)) {
                    int i = n;
                    do {
                        boolean x;
                        boolean bl2 = x = i < 0;
                        if (x) {
                            bl = x;
                            break block10;
                        }
                        if (!KawaConvert.isTrue(r[i])) break;
                        --i;
                    } while (true);
                    bl = false;
                } else {
                    bl = false;
                }
            } else if (!KawaConvert.isTrue(b2)) {
                int i = n;
                do {
                    boolean x;
                    boolean bl3 = x = i < 0;
                    if (x) {
                        bl = x;
                        break block10;
                    }
                    if (KawaConvert.isTrue(r[i])) break;
                    --i;
                } while (true);
                bl = false;
            } else {
                bl = false;
            }
        }
        return bl;
    }

    public static boolean isSymbol(Object x) {
        return x instanceof Symbol;
    }

    public static String symbol$To$String(Symbol s) {
        return s.toString();
    }

    public static boolean isSymbol$Eq$V(Symbol s1, Symbol s2, Object[] argsArray) {
        LList lList;
        boolean x;
        LList r = lList = LList.makeList(argsArray, 0);
        return Symbol.equals(s1, s2) ? ((x = lists.isNull(r)) ? x : KawaConvert.isTrue(Promise.force(((Procedure)Scheme.apply).apply3(symbol$Eq$Qu, s2, r)))) : false;
    }

    public static String symbolLocalName(Symbol s) {
        return s.getLocalPart();
    }

    public static Namespace symbolNamespace(Symbol s) {
        return s.getNamespace();
    }

    public static String symbolNamespaceUri(Symbol s) {
        return s.getNamespaceURI();
    }

    public static String symbolPrefix(Symbol s) {
        return s.getPrefix();
    }

    public static CharSequence namespaceUri(Namespace ns) {
        return ns.getName();
    }

    public static CharSequence namespacePrefix(Namespace ns) {
        return ns.getPrefix();
    }

    public static SimpleSymbol string$To$Symbol(CharSequence str) {
        return SimpleSymbol.valueOf(str.toString());
    }

    public static boolean isProcedure(Object x) {
        boolean x2 = x instanceof Procedure;
        return x2 ? x2 : x instanceof LangObjType;
    }

    public static boolean isEnvironmentBound(Environment env, Object sym) {
        return env.isBound(LispLanguage.langSymbolToSymbol(sym));
    }

    public static Environment nullEnvironment() {
        return misc.nullEnvironment(Boolean.FALSE);
    }

    public static Environment nullEnvironment(Object version) {
        return Scheme.nullEnvironment;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Environment schemeReportEnvironment(Object version) {
        switch (version.hashCode()) {
            Environment environment;
            case 4: {
                if (!IsEqv.apply(version, Lit0)) throw NamedException.makeError("scheme-report-environment version must be 4 or 5");
                {
                    environment = Scheme.r4Environment;
                    return environment;
                }
            }
            case 5: {
                if (!IsEqv.apply(version, Lit1)) throw NamedException.makeError("scheme-report-environment version must be 4 or 5");
                {
                    environment = Scheme.r5Environment;
                    return environment;
                }
            }
            default: {
                throw NamedException.makeError("scheme-report-environment version must be 4 or 5");
            }
        }
    }

    public static Environment interactionEnvironment() {
        return Environment.user();
    }

    public static String schemeImplementationVersion() {
        return Version.getVersion();
    }

    public static void setProcedureProperty$Ex(Procedure proc, Object key, Object value) {
        proc.setProperty(key, value);
    }

    public static Object procedureProperty(Procedure procedure, Object object2) {
        return misc.procedureProperty(procedure, object2, Boolean.FALSE);
    }

    public static Object procedureProperty(Procedure proc, Object key, Object object2) {
        return proc.getProperty(key, object2);
    }

    public static Object dynamicWind(Object before, Object thunk, Object after) {
        Object object2;
        ((Procedure)Scheme.applyToArgs).apply1(before);
        try {
            object2 = ((Procedure)Scheme.applyToArgs).apply1(thunk);
            Object var5_4 = null;
        }
        catch (Throwable throwable) {
            Object var5_5 = null;
            ((Procedure)Scheme.applyToArgs).apply1(after);
            throw throwable;
        }
        ((Procedure)Scheme.applyToArgs).apply1(after);
        {
        }
        return object2;
    }

    public static boolean isPromise(Object obj) {
        return obj instanceof Lazy;
    }

    public static Lazy makePromise(Object obj) {
        return obj instanceof Lazy ? (Lazy<Object>)obj : Promise.makeBoundPromise(obj);
    }

    public static void promiseSetValue$Ex(Promise promise, Object value) {
        promise.setValue(value);
    }

    public static void promiseSetAlias$Ex(Promise promise, Lazy aliasee) {
        promise.setAlias(aliasee);
    }

    public static void promiseSetException$Ex(Promise promise, Throwable exception) {
        promise.setException(exception);
    }

    public static void promiseSetThunk$Ex(Promise promise, Procedure thunk) {
        promise.setThunk(thunk);
    }

    public static Object force(Object arg) {
        return Promise.force1(arg);
    }

    public static Object force$St(Object arg) {
        return Promise.force(arg);
    }

    public static Procedure eager(Object value) {
        return eager;
    }

    public static Object baseUri() {
        return misc.baseUri(null);
    }

    public static Object baseUri(Object node) {
        Path uri = node == null ? Path.currentPath() : ((KNode)Promise.force(node, KNode.class)).baseURI();
        return uri == Values.empty ? Boolean.FALSE : uri;
    }

    public static Symbol gentemp() {
        return Symbols.gentemp();
    }

    public static /* varargs */ void addProcedureProperties(GenericProc proc, Object ... args) {
        proc.setProperties(args);
    }

    public static LList features() {
        return IfFeature.featureList();
    }

    public static {
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
        misc misc2 = $instance = new misc();
        boolean$Qu = new ModuleMethod(misc2, 1, Lit3, 4097);
        boolean$Eq$Qu = new ModuleMethod(misc2, 2, Lit4, -4094);
        symbol$Qu = new ModuleMethod(misc2, 3, Lit5, 4097);
        symbol$Mn$Grstring = new ModuleMethod(misc2, 4, Lit6, 4097);
        symbol$Eq$Qu = new ModuleMethod(misc2, 5, Lit7, -4094);
        symbol$Mnlocal$Mnname = new ModuleMethod(misc2, 6, Lit8, 4097);
        symbol$Mnnamespace = new ModuleMethod(misc2, 7, Lit9, 4097);
        symbol$Mnnamespace$Mnuri = new ModuleMethod(misc2, 8, Lit10, 4097);
        symbol$Mnprefix = new ModuleMethod(misc2, 9, Lit11, 4097);
        namespace$Mnuri = new ModuleMethod(misc2, 10, Lit12, 4097);
        namespace$Mnprefix = new ModuleMethod(misc2, 11, Lit13, 4097);
        string$Mn$Grsymbol = new ModuleMethod(misc2, 12, Lit14, 4097);
        procedure$Qu = new ModuleMethod(misc2, 13, Lit15, 4097);
        ModuleMethod moduleMethod = new ModuleMethod(misc2, 14, Lit16, -4096);
        moduleMethod.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:valuesValidateApply");
        moduleMethod.setProperty(Procedure.compilerXKey, "kawa.lib.compile_misc:valuesCompile");
        values = moduleMethod;
        environment$Mnbound$Qu = new ModuleMethod(misc2, 15, Lit17, 8194);
        null$Mnenvironment = new ModuleMethod(misc2, 16, Lit18, 4096);
        scheme$Mnreport$Mnenvironment = new ModuleMethod(misc2, 18, Lit19, 4097);
        interaction$Mnenvironment = new ModuleMethod(misc2, 19, Lit20, 0);
        scheme$Mnimplementation$Mnversion = new ModuleMethod(misc2, 20, Lit21, 0);
        set$Mnprocedure$Mnproperty$Ex = new ModuleMethod(misc2, 21, Lit22, 12291);
        procedure$Mnproperty = new GenericProc("procedure-property");
        procedure$Mnproperty$Fn1 = new ModuleMethod(misc2, 22, Lit23, 12290);
        dynamic$Mnwind = new ModuleMethod(misc2, 24, Lit24, 12291);
        promise$Qu = new ModuleMethod(misc2, 25, Lit25, 4097);
        make$Mnpromise = new ModuleMethod(misc2, 26, Lit26, 4097);
        promise$Mnset$Mnvalue$Ex = new ModuleMethod(misc2, 27, Lit27, 8194);
        promise$Mnset$Mnalias$Ex = new ModuleMethod(misc2, 28, Lit28, 8194);
        promise$Mnset$Mnexception$Ex = new ModuleMethod(misc2, 29, Lit29, 8194);
        promise$Mnset$Mnthunk$Ex = new ModuleMethod(misc2, 30, Lit30, 8194);
        force = new ModuleMethod(misc2, 31, Lit31, 4097);
        force$St = new ModuleMethod(misc2, 32, Lit32, 4097);
        eager = new ModuleMethod(misc2, 33, Lit33, 4097);
        base$Mnuri = new ModuleMethod(misc2, 34, Lit34, 4096);
        gentemp = new ModuleMethod(misc2, 36, Lit35, 0);
        add$Mnprocedure$Mnproperties = new ModuleMethod(misc2, 37, Lit36, -4095);
        features = new ModuleMethod(misc2, 38, Lit37, 0);
        misc.$runBody$();
    }

    public misc() {
        ModuleInfo.register(this);
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 38: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 36: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 34: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 20: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 19: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 16: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 34: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 33: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 32: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 31: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 26: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 25: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 18: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 16: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 13: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 12: {
                Object object3 = Promise.force(object2, CharSequence.class);
                if (!(object3 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 11: {
                Object object4 = Promise.force(object2, Namespace.class);
                if (!(object4 instanceof Namespace)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 10: {
                Object object5 = Promise.force(object2, Namespace.class);
                if (!(object5 instanceof Namespace)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 9: {
                Object object6 = Promise.force(object2, Symbol.class);
                if (!(object6 instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 8: {
                Object object7 = Promise.force(object2, Symbol.class);
                if (!(object7 instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 7: {
                Object object8 = Promise.force(object2, Symbol.class);
                if (!(object8 instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 6: {
                Object object9 = Promise.force(object2, Symbol.class);
                if (!(object9 instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                Object object10 = Promise.force(object2, Symbol.class);
                if (!(object10 instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 30: {
                Object object4 = object2;
                if (!(object4 instanceof Promise)) {
                    return -786431;
                }
                callContext.value1 = object4;
                Object object5 = Promise.force(object3, Procedure.class);
                if (!(object5 instanceof Procedure)) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 29: {
                Object object6 = object2;
                if (!(object6 instanceof Promise)) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3, Throwable.class);
                if (!(object7 instanceof Throwable)) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 28: {
                Object object8 = object2;
                if (!(object8 instanceof Promise)) {
                    return -786431;
                }
                callContext.value1 = object8;
                Object object9 = object3;
                if (!(object9 instanceof Lazy)) {
                    return -786430;
                }
                callContext.value2 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 27: {
                Object object10 = object2;
                if (!(object10 instanceof Promise)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 22: {
                Object object11 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object11) == null) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 15: {
                Object object12 = Promise.force(object2, Environment.class);
                if (!(object12 instanceof Environment)) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 24: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 22: {
                Object object5 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object5) == null) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 21: {
                Object object6 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object6) == null) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 37: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 14: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 5: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 2: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
        }
        return super.matchN(moduleMethod, arrobject, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply0(ModuleMethod moduleMethod) {
        switch (moduleMethod.selector) {
            case 16: {
                return misc.nullEnvironment();
            }
            case 19: {
                return misc.interactionEnvironment();
            }
            case 20: {
                return misc.schemeImplementationVersion();
            }
            case 34: {
                return misc.baseUri();
            }
            case 36: {
                return misc.gentemp();
            }
            case 38: {
                return misc.features();
            }
        }
        return super.apply0(moduleMethod);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                Boolean bl;
                if (misc.isBoolean(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 3: {
                Boolean bl;
                if (misc.isSymbol(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 4: {
                return misc.symbol$To$String((Symbol)Promise.force(object2, Symbol.class));
            }
            case 6: {
                return misc.symbolLocalName((Symbol)Promise.force(object2, Symbol.class));
            }
            case 7: {
                return misc.symbolNamespace((Symbol)Promise.force(object2, Symbol.class));
            }
            case 8: {
                return misc.symbolNamespaceUri((Symbol)Promise.force(object2, Symbol.class));
            }
            case 9: {
                return misc.symbolPrefix((Symbol)Promise.force(object2, Symbol.class));
            }
            case 10: {
                return misc.namespaceUri((Namespace)Promise.force(object2, Namespace.class));
            }
            case 11: {
                return misc.namespacePrefix((Namespace)Promise.force(object2, Namespace.class));
            }
            case 12: {
                return misc.string$To$Symbol((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 13: {
                Boolean bl;
                if (misc.isProcedure(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 16: {
                return misc.nullEnvironment(object2);
            }
            case 18: {
                return misc.schemeReportEnvironment(object2);
            }
            case 25: {
                Boolean bl;
                if (misc.isPromise(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 26: {
                return misc.makePromise(object2);
            }
            case 31: {
                return misc.force(object2);
            }
            case 32: {
                return misc.force$St(object2);
            }
            case 33: {
                return misc.eager(object2);
            }
            case 34: {
                return misc.baseUri(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "symbol->string", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "symbol-local-name", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "symbol-namespace", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "symbol-namespace-uri", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "symbol-prefix", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "namespace-uri", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "namespace-prefix", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string->symbol", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public Object apply2(ModuleMethod var1_1, Object var2_2, Object var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4) {
        switch (moduleMethod.selector) {
            case 21: {
                misc.setProcedureProperty$Ex(LangObjType.coerceToProcedure(Promise.force(object2, Procedure.class)), object3, object4);
                return Values.empty;
            }
            case 22: {
                return misc.procedureProperty(LangObjType.coerceToProcedure(Promise.force(object2, Procedure.class)), object3, object4);
            }
            case 24: {
                return misc.dynamicWind(object2, object3, object4);
            }
        }
        return super.apply3(moduleMethod, object2, object3, object4);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-procedure-property!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "procedure-property", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public Object applyN(ModuleMethod var1_1, Object[] var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }
}

