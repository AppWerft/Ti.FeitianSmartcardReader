/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.SwitchState;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ANormalize;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.ChainLambdas;
import gnu.expr.CheckedTarget;
import gnu.expr.ClassExp;
import gnu.expr.ConditionalTarget;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.FindCapturedVars;
import gnu.expr.FindTailCalls;
import gnu.expr.IfExp;
import gnu.expr.IgnoreTarget;
import gnu.expr.Initializer;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.LitTable;
import gnu.expr.Literal;
import gnu.expr.Mangling;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.ModuleMethod;
import gnu.expr.NameLookup;
import gnu.expr.PairClassType;
import gnu.expr.PushApply;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.kawa.functions.Convert;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.LazyType;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.Options;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Stack;
import java.util.jar.JarOutputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kawa.Shell;
import kawa.lang.Translator;
import kawa.standard.require;

public class Compilation
implements SourceLocator {
    public boolean mustCompile = ModuleExp.alwaysCompile;
    int maxSelectorValue;
    public ClassType curClass;
    public ClassType mainClass;
    public ClassType moduleClass;
    public LambdaExp curLambda;
    public ModuleExp mainLambda;
    public Variable thisDecl;
    Variable moduleInstanceVar;
    private int state;
    public static final int PROLOG_PARSING = 1;
    public static final int PROLOG_PARSED = 2;
    public static final int BODY_PARSED = 4;
    public static final int RESOLVED = 6;
    public static final int PRE_WALKED = 8;
    public static final int WALKED = 10;
    public static final int COMPILE_SETUP = 12;
    public static final int COMPILED = 14;
    public static final int CLASS_WRITTEN = 16;
    public static final int ERROR_SEEN = 100;
    public Lexer lexer;
    private boolean pedantic;
    gnu.bytecode.Field moduleInstanceMainField;
    public Stack<Object> pendingImports;
    public Map<String, ModuleInfo> subModuleMap;
    public static boolean writeImplicitClasses = false;
    public static boolean debugPrintExpr = false;
    public static boolean debugPrintFinalExpr;
    public static boolean debugPrintANF;
    public static boolean enableANF;
    public static Options options;
    public static Options.OptionInfo fullTailCallsVariable;
    public static Options.OptionInfo mainMethodVariable;
    public static Options.OptionInfo warnUnreachable;
    public static Options.OptionInfo warnVoidUsed;
    public static Options.OptionInfo warnUndefinedVariable;
    public static Options.OptionInfo warnUnknownMember;
    public static Options.OptionInfo warnInvokeUnknownMethod;
    public static Options.OptionInfo warnUnused;
    public static Options.OptionInfo warnAsError;
    public Options currentOptions = new Options(options);
    public static int defaultClassFileVersion;
    public static int defaultCallConvention;
    public static final int CALL_WITH_UNSPECIFIED = 0;
    public static final int CALL_WITH_RETURN = 1;
    public static final int CALL_WITH_CONSUMER = 2;
    public static final int CALL_WITH_TAILCALLS = 3;
    public static final int CALL_WITH_CONTINUATIONS = 4;
    public static final int MODULE_NONSTATIC = -1;
    public static final int MODULE_STATIC_DEFAULT = 0;
    public static final int MODULE_STATIC = 1;
    public static final int MODULE_STATIC_RUN = 2;
    public static int moduleStatic;
    ClassType[] classes;
    int numClasses;
    ArrayClassLoader loader;
    public boolean immediate;
    public boolean explicit;
    public Method method;
    Method clinitMethod;
    int method_counter;
    SwitchState fswitch;
    gnu.bytecode.Field fswitchIndex;
    public static ClassType typeObject;
    public static ClassType scmBooleanType;
    public static ClassType typeString;
    public static ClassType typeCharSequence;
    public static ClassType javaStringType;
    public static ClassType scmKeywordType;
    public static ClassType scmSequenceType;
    public static final ClassType typeList;
    public static ClassType scmListType;
    public static ClassType typePair;
    public static final ArrayType objArrayType;
    public static ClassType typeRunnable;
    public static ClassType typeRunnableModule;
    public static ClassType typeType;
    public static ClassType typeObjectType;
    public static ClassType typeClass;
    public static ClassType typeClassType;
    public static ClassType typeProcedure;
    public static ClassType typeLanguage;
    public static ClassType typeEnvironment;
    public static ClassType typeLocation;
    public static final ClassType typeLocationProc;
    public static ClassType typeFieldLocation;
    public static ClassType typeStaticFieldLocation;
    public static ClassType typeSymbol;
    public static final gnu.bytecode.Field trueConstant;
    public static final gnu.bytecode.Field falseConstant;
    static Method makeListMethod;
    public static final Type[] int1Args;
    public static final Type[] string1Arg;
    public static final Type[] sym1Arg;
    public static Method getCurrentEnvironmentMethod;
    public static Type[] apply0args;
    public static Type[] apply1args;
    public static Type[] apply2args;
    public static Type[] applyNargs;
    static Method checkArgCountMethod;
    public static Method apply0method;
    public static Method apply1method;
    public static Method apply2method;
    public static Method apply3method;
    public static Method apply4method;
    public static Method applyNmethod;
    public static Method[] applymethods;
    public static ClassType typeProcedure0;
    public static ClassType typeProcedure1;
    public static ClassType typeProcedure2;
    public static ClassType typeProcedure3;
    public static ClassType typeProcedure4;
    public static ClassType typeProcedureN;
    public static ClassType typeModuleBody;
    public static ClassType typeApplet;
    public static ClassType typeServlet;
    public static ClassType typeCallContext;
    public static final ClassType typeConsumer;
    public static Method getCallContextInstanceMethod;
    public static ClassType typeValues;
    public static gnu.bytecode.Field noArgsField;
    public static gnu.bytecode.Field pcCallContextField;
    public static ClassType typeMethodProc;
    public static ClassType typeModuleMethod;
    public static ClassType typeModuleMethodWithContext;
    public static gnu.bytecode.Field argsCallContextField;
    public static gnu.bytecode.Field procCallContextField;
    private static Type[] applyCpsArgs;
    public static Method applyCpsMethod;
    public static ClassType[] typeProcedureArray;
    Initializer clinitChain;
    LitTable litTable;
    int langOptions;
    public static boolean inlineOk;
    boolean dumpingInitializers;
    static final Comparator<ClassType> classTypeComparator;
    boolean classesArrayIsSorted;
    public static String classPrefixDefault;
    public String classPrefix = classPrefixDefault;
    public static boolean emitSourceDebugExtAttr;
    int localFieldIndex;
    Variable callContextVar;
    Variable callContextVarForInit;
    protected Language language;
    public Stack<Expression> exprStack;
    Method forNameHelper;
    private int keyUninitialized;
    private static Compilation chainUninitialized;
    private Compilation nextUninitialized;
    public NameLookup lexical;
    protected ScopeExp current_scope;
    protected SourceMessages messages;
    private static final ThreadLocal<Compilation> current;

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isPedantic() {
        return this.pedantic;
    }

    public void setPedantic(boolean value) {
        this.pedantic = value;
    }

    public void pushPendingImport(ModuleInfo info, ScopeExp defs2, Translator.FormStack forms, require.DeclSetMapper mapper) {
        if (this.pendingImports == null) {
            this.pendingImports = new Stack();
        }
        this.pendingImports.push(info);
        this.pendingImports.push(defs2);
        ReferenceExp posExp = new ReferenceExp((Object)null);
        posExp.setLine(this);
        this.pendingImports.push(posExp);
        this.pendingImports.push(forms.lastPair());
        this.pendingImports.push(mapper);
    }

    public boolean generateMainMethod() {
        return this.currentOptions.getBoolean(mainMethodVariable);
    }

    public boolean warnUnreachable() {
        return this.currentOptions.getBoolean(warnUnreachable);
    }

    public boolean warnUndefinedVariable() {
        return this.currentOptions.getBoolean(warnUndefinedVariable);
    }

    public boolean warnUnknownMember() {
        return this.currentOptions.getBoolean(warnUnknownMember);
    }

    public boolean warnInvokeUnknownMethod() {
        return this.currentOptions.getBoolean(warnInvokeUnknownMethod);
    }

    public boolean warnUnused() {
        return this.currentOptions.getBoolean(warnUnused);
    }

    public boolean warnVoidUsed() {
        return !enableANF && this.currentOptions.getBoolean(warnVoidUsed);
    }

    public boolean warnAsError() {
        return this.currentOptions.getBoolean(warnAsError);
    }

    public final boolean getBooleanOption(String key, boolean defaultValue) {
        return this.currentOptions.getBoolean(key, defaultValue);
    }

    public final boolean getBooleanOption(String key) {
        return this.currentOptions.getBoolean(key);
    }

    public int currentCallConvention() {
        Object ft = this.currentOptions.getLocal("full-tailcalls");
        if (ft instanceof Boolean) {
            return (Boolean)ft != false ? 3 : 1;
        }
        return defaultCallConvention;
    }

    public boolean usingCPStyle() {
        return this.currentCallConvention() == 4;
    }

    public boolean usingTailCalls() {
        return this.currentCallConvention() >= 3;
    }

    public boolean usingCallContext() {
        return this.currentCallConvention() >= 2;
    }

    public final CodeAttr getCode() {
        return this.method.getCode();
    }

    public boolean generatingApplet() {
        return (this.langOptions & 16) != 0;
    }

    public boolean generatingServlet() {
        return (this.langOptions & 32) != 0;
    }

    public boolean sharedModuleDefs() {
        return (this.langOptions & 2) != 0;
    }

    public void setSharedModuleDefs(boolean shared) {
        this.langOptions = shared ? (this.langOptions |= 2) : (this.langOptions &= -3);
    }

    public final ClassType getModuleType() {
        return typeModuleBody;
    }

    public void compileConstant(Object value) {
        CodeAttr code = this.getCode();
        if (value == null) {
            code.emitPushNull();
        } else if (value instanceof String && !this.immediate) {
            code.emitPushString((String)value);
        } else {
            Literal literal = this.litTable.findLiteral(value);
            if (literal.field == null) {
                literal.assign(this.litTable);
            }
            code.emitGetStatic(literal.field);
        }
    }

    public boolean inlineOk(Expression proc) {
        if (proc instanceof LambdaExp) {
            LambdaExp lproc = (LambdaExp)proc;
            Declaration nameDecl = lproc.nameDecl;
            if (nameDecl == null || nameDecl.getSymbol() == null || !(nameDecl.context instanceof ModuleExp)) {
                return true;
            }
            if (this.immediate && nameDecl.isPublic() && !lproc.getFlag(2048) && (this.curLambda == null || lproc.topLevel() != this.curLambda.topLevel())) {
                return false;
            }
        }
        return inlineOk;
    }

    public boolean inlineOk(Procedure proc) {
        if (this.immediate && proc instanceof ModuleMethod && ((ModuleMethod)proc).module.getClass().getClassLoader() instanceof ArrayClassLoader) {
            return false;
        }
        return inlineOk;
    }

    static boolean avoidInline(LambdaExp proc) {
        return proc.getOuter() instanceof ModuleExp && proc.nameDecl != null;
    }

    public boolean isApplyFunction(Expression exp) {
        return false;
    }

    public boolean isSimpleApplyFunction(Expression exp) {
        return false;
    }

    public void compileConstant(Object value, Target target) {
        if (target instanceof IgnoreTarget) {
            return;
        }
        if (value instanceof Values && target instanceof ConsumerTarget) {
            Object[] values = ((Values)value).getValues();
            int len = values.length;
            for (int i = 0; i < len; ++i) {
                this.compileConstant(values[i], ((ConsumerTarget)target).getSingleTarget());
            }
            return;
        }
        if (target instanceof ConditionalTarget) {
            ConditionalTarget ctarg = (ConditionalTarget)target;
            this.getCode().emitGoto(this.getLanguage().isTrue(value) ? ctarg.ifTrue : ctarg.ifFalse);
            return;
        }
        if (target instanceof StackTarget) {
            Type type = ((StackTarget)target).getType();
            if (type instanceof LazyType) {
                type = ((LazyType)type).getValueType();
            }
            if (type instanceof PrimType) {
                try {
                    int sig1;
                    String signature = type.getSignature();
                    CodeAttr code = this.getCode();
                    int n = sig1 = signature == null || signature.length() != 1 ? 32 : (int)signature.charAt(0);
                    if (value instanceof Number) {
                        Number num = (Number)value;
                        switch (sig1) {
                            case 67: 
                            case 73: {
                                code.emitPushInt(num.intValue());
                                return;
                            }
                            case 83: {
                                code.emitPushInt(num.shortValue());
                                return;
                            }
                            case 66: {
                                code.emitPushInt(num.byteValue());
                                return;
                            }
                            case 74: {
                                code.emitPushLong(num.longValue());
                                return;
                            }
                            case 70: {
                                code.emitPushFloat(num.floatValue());
                                return;
                            }
                            case 68: {
                                code.emitPushDouble(num.doubleValue());
                                return;
                            }
                        }
                    }
                    if (type == LangPrimType.characterType || type == LangPrimType.characterOrEofType) {
                        if (value instanceof Char) {
                            code.emitPushInt(((Char)value).intValue());
                            return;
                        }
                        if (value instanceof Character) {
                            code.emitPushInt(((Character)value).charValue());
                            return;
                        }
                        if (value == Sequence.eofValue && type == LangPrimType.characterOrEofType) {
                            code.emitPushInt(-1);
                            return;
                        }
                    }
                    if (sig1 == 67) {
                        code.emitPushInt(((PrimType)type).charValue(value));
                        return;
                    }
                    if (sig1 == 90) {
                        boolean val = this.getLanguage().isTrue(value);
                        code.emitPushInt(val ? 1 : 0);
                        return;
                    }
                }
                catch (ClassCastException ex) {
                    // empty catch block
                }
            }
            if (type == typeClass && value instanceof ClassType) {
                this.loadClassRef((ClassType)value);
                return;
            }
            try {
                value = type.coerceFromObject(value);
            }
            catch (Exception ex) {
                StringBuffer sbuf = new StringBuffer();
                if (value == Values.empty) {
                    sbuf.append("cannot convert void to ");
                } else {
                    sbuf.append("cannot convert literal (of type ");
                    if (value == null) {
                        sbuf.append("<null>");
                    } else {
                        sbuf.append(value.getClass().getName());
                    }
                    sbuf.append(") to ");
                }
                sbuf.append(type);
                this.error('w', sbuf.toString());
            }
        }
        this.compileConstant(value);
        target.compileFromStack(this, value == null ? target.getType() : Type.make(value.getClass()));
    }

    public void emitPushBoolean(boolean value) {
        CodeAttr code = this.getCode();
        Object valObject = this.language.booleanObject(value);
        if (valObject == Boolean.TRUE) {
            code.emitGetStatic(trueConstant);
        } else if (valObject == Boolean.FALSE) {
            code.emitGetStatic(falseConstant);
        } else {
            this.compileConstant(valObject);
        }
    }

    public void emitCoerceToBoolean() {
        CodeAttr code = this.getCode();
        Label trueLabel = new Label(code);
        Label falseLabel = new Label(code);
        ConditionalTarget ctarget = new ConditionalTarget(trueLabel, falseLabel, this.getLanguage());
        ctarget.compileFromStack(this, Type.objectType);
        code.emitIfThen();
        trueLabel.define(code);
        code.emitPushInt(1);
        code.emitElse();
        falseLabel.define(code);
        code.emitPushInt(0);
        code.emitFi();
    }

    public Type asBooleanValue(ConditionalTarget target, Type stackType) {
        return stackType;
    }

    private void dumpInitializers(Initializer inits) {
        this.dumpingInitializers = true;
        Initializer init = Initializer.reverse(inits);
        while (init != null) {
            init.emit(this);
            init = init.next;
        }
        this.dumpingInitializers = false;
    }

    public ClassType findNamedClass(String name) {
        int index;
        ClassType nameType;
        if (this.classes == null || this.numClasses == 0) {
            return null;
        }
        if (name.equals(this.classes[0].getName())) {
            return this.classes[0];
        }
        if (this.numClasses == 1) {
            return null;
        }
        if (!this.classesArrayIsSorted) {
            Arrays.sort(this.classes, 1, this.numClasses, classTypeComparator);
            this.classesArrayIsSorted = true;
        }
        return (index = Arrays.binarySearch(this.classes, 1, this.numClasses, nameType = new ClassType(name), classTypeComparator)) > -1 ? this.classes[index] : null;
    }

    private static void putURLWords(String name, StringBuffer sbuf) {
        int dot = name.indexOf(46);
        if (dot > 0) {
            Compilation.putURLWords(name.substring(dot + 1), sbuf);
            sbuf.append('.');
            name = name.substring(0, dot);
        }
        sbuf.append(name);
    }

    public static String mangleURI(String name) {
        boolean hasSlash = name.indexOf(47) >= 0;
        int len = name.length();
        if (len > 6 && name.startsWith("class:")) {
            return name.substring(6);
        }
        if (len > 5 && name.charAt(4) == ':' && name.substring(0, 4).equalsIgnoreCase("http")) {
            name = name.substring(5);
            len -= 5;
            hasSlash = true;
        } else if (len > 4 && name.charAt(3) == ':' && name.substring(0, 3).equalsIgnoreCase("uri")) {
            name = name.substring(4);
            len -= 4;
        }
        int start = 0;
        StringBuffer sbuf = new StringBuffer();
        do {
            int slash;
            boolean first;
            int end = (slash = name.indexOf(47, start)) < 0 ? len : slash;
            boolean bl = first = sbuf.length() == 0;
            if (first && hasSlash) {
                String host = name.substring(start, end);
                if (end - start > 4 && host.startsWith("www.")) {
                    host = host.substring(4);
                }
                Compilation.putURLWords(host, sbuf);
            } else if (start != end) {
                int extLen;
                int dot;
                if (!first) {
                    sbuf.append('.');
                }
                if (end == len && (dot = name.lastIndexOf(46, len)) > start + 1 && !first && ((extLen = len - dot) <= 4 || extLen == 5 && name.endsWith("html"))) {
                    end = len -= extLen;
                    name = name.substring(0, len);
                }
                sbuf.append(name.substring(start, end));
            }
            if (slash < 0) break;
            start = slash + 1;
        } while (true);
        return sbuf.toString();
    }

    public String generateClassName(String hint) {
        hint = Mangling.mangleClassName(hint);
        if (this.mainClass != null) {
            hint = this.mainClass.getName() + '$' + hint;
        } else if (this.classPrefix != null) {
            hint = this.classPrefix + hint;
        }
        if (this.findNamedClass(hint) == null) {
            return hint;
        }
        int i = 0;
        String new_hint;
        while (this.findNamedClass(new_hint = hint + i) != null) {
            ++i;
        }
        return new_hint;
    }

    public Compilation(Language language, SourceMessages messages, NameLookup lexical) {
        this.language = language;
        this.messages = messages;
        this.lexical = lexical;
    }

    public void outputClass(String directory) throws IOException {
        char dirSep = File.separatorChar;
        for (int iClass = 0; iClass < this.numClasses; ++iClass) {
            ClassType clas = this.classes[iClass];
            String out_name = directory + clas.getName().replace('.', dirSep) + ".class";
            String parent = new File(out_name).getParent();
            if (parent != null) {
                new File(parent).mkdirs();
            }
            clas.writeToFile(out_name);
        }
        this.getMinfo().cleanupAfterCompilation();
    }

    public void cleanupAfterCompilation() {
        for (int iClass = 0; iClass < this.numClasses; ++iClass) {
            this.classes[iClass].cleanupAfterCompilation();
        }
        this.classes = null;
        ModuleInfo minfo = this.getMinfo();
        minfo.className = this.mainClass.getName();
        minfo.setCompilation(null);
        if (minfo.exp != null) {
            minfo.exp.body = null;
        }
        this.mainLambda.body = null;
        this.mainLambda = null;
        if (!this.immediate) {
            this.litTable = null;
        }
    }

    public void compileToArchive(ModuleExp mexp, String fname) throws IOException {
        boolean makeJar = false;
        if (fname.endsWith(".zip")) {
            makeJar = false;
        } else if (fname.endsWith(".jar")) {
            makeJar = true;
        } else {
            fname = fname + ".zip";
            makeJar = false;
        }
        this.process(14);
        File zar_file = new File(fname);
        if (zar_file.exists()) {
            zar_file.delete();
        }
        ZipOutputStream zout = makeJar ? new JarOutputStream(new FileOutputStream(zar_file)) : new ZipOutputStream(new FileOutputStream(zar_file));
        byte[][] classBytes = new byte[this.numClasses][];
        CRC32 zcrc = new CRC32();
        for (int iClass = 0; iClass < this.numClasses; ++iClass) {
            ClassType clas = this.classes[iClass];
            classBytes[iClass] = clas.writeToArray();
            ZipEntry zent = new ZipEntry(clas.getName().replace('.', '/') + ".class");
            zent.setSize(classBytes[iClass].length);
            zcrc.reset();
            zcrc.update(classBytes[iClass], 0, classBytes[iClass].length);
            zent.setCrc(zcrc.getValue());
            zout.putNextEntry(zent);
            zout.write(classBytes[iClass]);
        }
        zout.close();
    }

    private void registerClass(ClassType new_class) {
        if (this.classes == null) {
            this.classes = new ClassType[20];
        } else if (this.numClasses >= this.classes.length) {
            ClassType[] new_classes = new ClassType[2 * this.classes.length];
            System.arraycopy(this.classes, 0, new_classes, 0, this.numClasses);
            this.classes = new_classes;
        }
        new_class.addModifiers(new_class.isInterface() ? 1 : 33);
        if (new_class == this.mainClass && this.numClasses > 0) {
            new_class = this.classes[0];
            this.classes[0] = this.mainClass;
        }
        this.classes[this.numClasses++] = new_class;
        this.classesArrayIsSorted = false;
    }

    public void addClass(ClassType new_class) {
        String fname = this.getModule().filename;
        if (fname != null) {
            if (emitSourceDebugExtAttr) {
                new_class.setStratum(this.getLanguage().getName());
            }
            new_class.setSourceFile(fname);
        }
        this.registerClass(new_class);
        new_class.setClassfileVersion(defaultClassFileVersion);
    }

    public boolean makeRunnable() {
        return !this.generatingServlet() && !this.generatingApplet() && !this.getModule().staticInitRun() && !this.getModule().getFlag(8388608);
    }

    public void addMainClass(ModuleExp module) {
        ClassType sup;
        ClassType type = this.mainClass = module.classFor(this);
        ClassType[] interfaces = module.getInterfaces();
        if (interfaces != null) {
            type.setInterfaces(interfaces);
        }
        if ((sup = module.getSuperType()) == null) {
            sup = this.generatingApplet() ? typeApplet : (this.generatingServlet() ? typeServlet : (module.getFlag(8388608) ? Type.objectType : this.getModuleType()));
        }
        if (this.makeRunnable()) {
            type.addInterface(typeRunnable);
        }
        if (!module.staticInitRun()) {
            type.addInterface(typeRunnableModule);
        }
        type.setSuper(sup);
        module.compiledType = type;
        this.addClass(type);
    }

    public final Method getConstructor(LambdaExp lexp) {
        return Compilation.getConstructor(lexp.getHeapFrameType(), lexp);
    }

    public static final Method getConstructor(ClassType clas, LambdaExp lexp) {
        Method meth = clas.getDeclaredMethod("<init>", 0);
        if (meth != null) {
            return meth;
        }
        Type[] args = lexp instanceof ClassExp && lexp.staticLinkField != null ? new Type[]{lexp.staticLinkField.getType()} : apply0args;
        return clas.addMethod("<init>", 1, args, Type.voidType);
    }

    public final void generateConstructor(LambdaExp lexp) {
        this.generateConstructor(lexp.getHeapFrameType(), lexp);
    }

    public final void generateConstructor(ClassType clas, LambdaExp lexp) {
        Method constructor_method;
        Method save_method = this.method;
        Variable callContextSave = this.callContextVar;
        this.callContextVar = null;
        ClassType save_class = this.curClass;
        this.curClass = clas;
        clas.constructor = constructor_method = Compilation.getConstructor(clas, lexp);
        this.method = constructor_method;
        CodeAttr code = constructor_method.startCode();
        if (lexp instanceof ClassExp && lexp.staticLinkField != null) {
            code.emitPushThis();
            code.emitLoad(code.getCurrentScope().getVariable(1));
            code.emitPutField(lexp.staticLinkField);
        }
        ClassType superClass = clas.getSuperclass();
        ClassExp.invokeDefaultSuperConstructor(superClass, this, lexp);
        if (this.curClass == this.mainClass && this.getMinfo() != null && this.getMinfo().sourcePath != null && !this.getModule().getFlag(8388608)) {
            code.emitPushThis();
            code.emitInvokeStatic(ClassType.make("gnu.expr.ModuleInfo").getDeclaredMethod("register", 1));
        }
        if (lexp != null && lexp.initChain != null) {
            Initializer init;
            LambdaExp save = this.curLambda;
            this.curLambda = new LambdaExp();
            this.curLambda.closureEnv = code.getArg(0);
            this.curLambda.setOuter(save);
            while ((init = lexp.initChain) != null) {
                lexp.initChain = null;
                this.dumpInitializers(init);
            }
            this.curLambda = save;
        }
        if (lexp instanceof ClassExp) {
            ClassExp cexp = (ClassExp)lexp;
            this.callInitMethods(cexp.getCompiledClassType(this), new ArrayList<ClassType>(10));
        }
        code.emitReturn();
        this.method = save_method;
        this.curClass = save_class;
        this.callContextVar = callContextSave;
    }

    void callInitMethods(ClassType clas, ArrayList<ClassType> seen) {
        if (clas == null) {
            return;
        }
        String name = clas.getName();
        if ("java.lang.Object".equals(name)) {
            return;
        }
        int i = seen.size();
        while (--i >= 0) {
            if (seen.get(i).getName() != name) continue;
            return;
        }
        seen.add(clas);
        ClassType[] interfaces = clas.getInterfaces();
        if (interfaces != null) {
            int n = interfaces.length;
            for (int i2 = 0; i2 < n; ++i2) {
                this.callInitMethods(interfaces[i2], seen);
            }
        }
        int clEnvArgs = 1;
        if (clas.isInterface()) {
            if (clas instanceof PairClassType) {
                clas = ((PairClassType)clas).instanceType;
            } else {
                try {
                    clas = (ClassType)Type.make(Class.forName(clas.getName() + "$class"));
                }
                catch (Exception ex) {
                    return;
                }
            }
        } else {
            clEnvArgs = 0;
        }
        Method meth = clas.getDeclaredMethod("$finit$", clEnvArgs);
        if (meth != null) {
            CodeAttr code = this.getCode();
            code.emitPushThis();
            code.emitInvoke(meth);
        }
    }

    public void generateMatchMethods(LambdaExp lexp) {
        int numApplyMethods;
        int n = numApplyMethods = lexp.applyMethods == null ? 0 : lexp.applyMethods.size();
        if (numApplyMethods == 0) {
            return;
        }
        Method save_method = this.method;
        ClassType save_class = this.curClass;
        ClassType procType = typeModuleMethod;
        this.curClass = lexp.getHeapFrameType();
        if (!this.curClass.getSuperclass().isSubtype(typeModuleBody)) {
            this.curClass = this.moduleClass;
        }
        CodeAttr code = null;
        for (int i = 0; i <= 5; ++i) {
            boolean needThisMatch = false;
            SwitchState aswitch = null;
            String mname = null;
            Type[] matchArgs = null;
            int j = numApplyMethods;
            while (--j >= 0) {
                int methodIndex;
                boolean varArgs;
                LambdaExp source = lexp.applyMethods.get(j);
                Method[] primMethods = source.primMethods;
                int numMethods = primMethods.length;
                boolean bl = varArgs = source.max_args < 0 || source.max_args >= source.min_args + numMethods;
                if (i < 5) {
                    methodIndex = i - source.min_args;
                    if (methodIndex < 0 || methodIndex >= numMethods || methodIndex == numMethods - 1 && varArgs) continue;
                    numMethods = 1;
                    varArgs = false;
                } else {
                    methodIndex = 5 - source.min_args;
                    if (methodIndex > 0 && numMethods <= methodIndex && !varArgs) continue;
                    methodIndex = numMethods - 1;
                }
                if (!needThisMatch) {
                    if (i < 5) {
                        mname = "match" + i;
                        matchArgs = new Type[i + 2];
                        for (int k = i; k >= 0; --k) {
                            matchArgs[k + 1] = typeObject;
                        }
                        matchArgs[i + 1] = typeCallContext;
                    } else {
                        mname = "matchN";
                        matchArgs = new Type[3];
                        matchArgs[1] = objArrayType;
                        matchArgs[2] = typeCallContext;
                    }
                    matchArgs[0] = procType;
                    this.method = this.curClass.addMethod(mname, matchArgs, Type.intType, 1);
                    code = this.method.startCode();
                    code.emitLoad(code.getArg(1));
                    code.emitGetField(procType.getField("selector"));
                    aswitch = code.startSwitch();
                    needThisMatch = true;
                }
                aswitch.addCase(source.getSelectorValue(this), code);
                int line = source.getLineNumber();
                if (line > 0) {
                    code.putLineNumber(source.getFileName(), line);
                }
                Variable ctxVar = code.getArg(i == 5 ? 3 : i + 2);
                if (i < 5) {
                    Declaration var = source.firstDecl();
                    for (int k = 1; k <= i; ++k) {
                        code.emitLoad(ctxVar);
                        code.emitLoad(code.getArg(k + 1));
                        Type ptype = var.getType();
                        if (ptype != Type.objectType) {
                            StackTarget.forceLazyIfNeeded(this, Type.objectType, ptype);
                            if (ptype instanceof TypeValue) {
                                Label trueLabel = new Label(code);
                                Label falseLabel = new Label(code);
                                ConditionalTarget ctarget = new ConditionalTarget(trueLabel, falseLabel, this.getLanguage());
                                code.emitDup();
                                ((TypeValue)((Object)ptype)).emitIsInstance(null, this, ctarget);
                                falseLabel.define(code);
                                code.emitPushInt(-786432 | k);
                                code.emitReturn();
                                trueLabel.define(code);
                            } else if (ptype instanceof ClassType && ptype != Type.objectType && ptype != Type.toStringType) {
                                code.emitDup();
                                ptype.emitIsInstance(code);
                                code.emitIfIntEqZero();
                                code.emitPushInt(-786432 | k);
                                code.emitReturn();
                                code.emitFi();
                            }
                        }
                        code.emitPutField(typeCallContext.getField("value" + k));
                        var = var.nextDecl();
                    }
                } else {
                    code.emitLoad(ctxVar);
                    code.emitLoad(code.getArg(2));
                    code.emitPutField(typeCallContext.getField("values"));
                }
                code.emitLoad(ctxVar);
                boolean usingCallContext = this.usingCallContext();
                if (usingCallContext) {
                    code.emitLoad(code.getArg(0));
                } else {
                    code.emitLoad(code.getArg(1));
                }
                code.emitPutField(procCallContextField);
                code.emitLoad(ctxVar);
                if (usingCallContext) {
                    code.emitPushInt(source.getSelectorValue(this) + methodIndex);
                } else {
                    code.emitPushInt(i);
                }
                code.emitPutField(pcCallContextField);
                code.emitPushInt(0);
                code.emitReturn();
            }
            if (!needThisMatch) continue;
            aswitch.addDefault(code);
            int nargs = i > 4 ? 2 : i + 1;
            for (int k = 0; k <= ++nargs; ++k) {
                code.emitLoad(code.getArg(k));
            }
            Method defMethod = typeModuleBody.getDeclaredMethod(mname, matchArgs.length);
            code.emitInvokeSpecial(defMethod);
            code.emitReturn();
            aswitch.finish(code);
        }
        this.method = save_method;
        this.curClass = save_class;
    }

    public void generateApplyMethodsWithContext(LambdaExp lexp) {
        int numApplyMethods;
        int n = numApplyMethods = lexp.applyMethods == null ? 0 : lexp.applyMethods.size();
        if (numApplyMethods == 0) {
            return;
        }
        ClassType save_class = this.curClass;
        this.curClass = lexp.getHeapFrameType();
        if (!this.curClass.getSuperclass().isSubtype(typeModuleBody)) {
            this.curClass = this.moduleClass;
        }
        ClassType procType = typeModuleMethod;
        Method save_method = this.method;
        CodeAttr code = null;
        Type[] applyArgs = new Type[]{typeCallContext};
        this.method = this.curClass.addMethod("apply", applyArgs, Type.voidType, 1);
        code = this.method.startCode();
        Variable ctxVar = code.getArg(1);
        code.emitLoad(ctxVar);
        code.emitGetField(pcCallContextField);
        SwitchState aswitch = code.startSwitch();
        for (int j = 0; j < numApplyMethods; ++j) {
            LambdaExp source = lexp.applyMethods.get(j);
            if (!source.usingCallContext()) continue;
            Method[] primMethods = source.primMethods;
            int numMethods = primMethods.length;
            for (int i = 0; i < numMethods; ++i) {
                Declaration var;
                int explicitFrameArg;
                boolean varArgs = i == numMethods - 1 && (source.max_args < 0 || source.max_args >= source.min_args + numMethods);
                int methodIndex = i;
                aswitch.addCase(source.getSelectorValue(this) + i, code);
                SourceLocator saveLoc1 = this.messages.swapSourceLocator(source);
                int line = source.getLineNumber();
                if (line > 0) {
                    code.putLineNumber(source.getFileName(), line);
                }
                Method primMethod = primMethods[methodIndex];
                Type[] primArgTypes = primMethod.getParameterTypes();
                int singleArgs = source.min_args + methodIndex;
                Variable counter = null;
                int pendingIfEnds = 0;
                if (i > 4 && numMethods > 1) {
                    counter = code.addLocal(Type.intType);
                    code.emitLoad(ctxVar);
                    code.emitInvoke(typeCallContext.getDeclaredMethod("getArgCount", 0));
                    if (source.min_args != 0) {
                        code.emitPushInt(source.min_args);
                        code.emitSub(Type.intType);
                    }
                    code.emitStore(counter);
                }
                int needsThis = primMethod.getStaticFlag() ? 0 : 1;
                int n2 = explicitFrameArg = singleArgs + (varArgs ? 2 : 1) < primArgTypes.length ? 1 : 0;
                if (needsThis + explicitFrameArg > 0) {
                    code.emitPushThis();
                    if (this.curClass == this.moduleClass && this.mainClass != this.moduleClass) {
                        code.emitGetField(this.moduleInstanceMainField);
                    }
                }
                if ((var = source.firstDecl()) != null && var.isThisParameter()) {
                    var = var.nextDecl();
                }
                for (int k = 0; k < singleArgs; ++k) {
                    if (counter != null && k >= source.min_args) {
                        code.emitLoad(counter);
                        code.emitIfIntLEqZero();
                        code.emitLoad(ctxVar);
                        code.emitInvoke(primMethods[k - source.min_args]);
                        code.emitElse();
                        ++pendingIfEnds;
                        code.emitInc(counter, (short)-1);
                    }
                    code.emitLoad(ctxVar);
                    if (k <= 4 && !varArgs && source.max_args <= 4) {
                        code.emitGetField(typeCallContext.getDeclaredField("value" + (k + 1)));
                    } else {
                        code.emitGetField(typeCallContext.getDeclaredField("values"));
                        code.emitPushInt(k);
                        code.emitArrayLoad(Type.objectType);
                    }
                    Type ptype = var.getType();
                    if (ptype != Type.objectType) {
                        SourceLocator saveLoc2 = this.messages.swapSourceLocator(var);
                        CheckedTarget.emitCheckedCoerce(this, source, k + 1, Type.objectType, ptype, null);
                        this.messages.swapSourceLocator(saveLoc2);
                    }
                    var = var.nextDecl();
                }
                if (varArgs) {
                    Type lastArgType = primArgTypes[explicitFrameArg + singleArgs];
                    if (lastArgType instanceof ArrayType) {
                        this.varArgsToArray(source, singleArgs, counter, lastArgType, ctxVar);
                    } else if ("gnu.lists.LList".equals(lastArgType.getName())) {
                        code.emitLoad(ctxVar);
                        code.emitPushInt(singleArgs);
                        code.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getRestArgsList", 1));
                    } else if (lastArgType == typeCallContext) {
                        code.emitLoad(ctxVar);
                    } else {
                        throw new RuntimeException("unsupported #!rest type:" + lastArgType);
                    }
                }
                code.emitLoad(ctxVar);
                code.emitInvoke(primMethod);
                while (--pendingIfEnds >= 0) {
                    code.emitFi();
                }
                if (!this.usingCallContext()) {
                    Target.pushObject.compileFromStack(this, source.getReturnType());
                }
                this.messages.swapSourceLocator(saveLoc1);
                code.emitReturn();
            }
        }
        aswitch.addDefault(code);
        Method errMethod = typeModuleMethod.getDeclaredMethod("applyError", 0);
        code.emitInvokeStatic(errMethod);
        code.emitReturn();
        aswitch.finish(code);
        this.method = save_method;
        this.curClass = save_class;
    }

    public void generateApplyMethodsWithoutContext(LambdaExp lexp) {
        int i;
        int numApplyMethods;
        int n = numApplyMethods = lexp.applyMethods == null ? 0 : lexp.applyMethods.size();
        if (numApplyMethods == 0) {
            return;
        }
        ClassType save_class = this.curClass;
        this.curClass = lexp.getHeapFrameType();
        ClassType procType = typeModuleMethod;
        if (!this.curClass.getSuperclass().isSubtype(typeModuleBody)) {
            this.curClass = this.moduleClass;
        }
        Method save_method = this.method;
        CodeAttr code = null;
        int n2 = i = this.usingCallContext() ? 5 : 0;
        while (i < 6) {
            boolean needThisApply = false;
            SwitchState aswitch = null;
            String mname = null;
            Type[] applyArgs = null;
            for (int j = 0; j < numApplyMethods; ++j) {
                Declaration var;
                int methodIndex;
                int explicitFrameArg;
                LambdaExp source = lexp.applyMethods.get(j);
                if (source.usingCallContext()) continue;
                Method[] primMethods = source.primMethods;
                int numMethods = primMethods.length;
                boolean varArgs = source.max_args < 0 || source.max_args >= source.min_args + numMethods;
                boolean skipThisProc = false;
                if (i < 5) {
                    methodIndex = i - source.min_args;
                    if (methodIndex < 0 || methodIndex >= numMethods || methodIndex == numMethods - 1 && varArgs) {
                        skipThisProc = true;
                    }
                    numMethods = 1;
                    varArgs = false;
                } else {
                    methodIndex = 5 - source.min_args;
                    if (methodIndex > 0 && numMethods <= methodIndex && !varArgs) {
                        skipThisProc = true;
                    }
                    methodIndex = numMethods - 1;
                }
                if (skipThisProc) continue;
                if (!needThisApply) {
                    if (i < 5) {
                        mname = "apply" + i;
                        applyArgs = new Type[i + 1];
                        for (int k = i; k > 0; --k) {
                            applyArgs[k] = typeObject;
                        }
                    } else {
                        mname = "applyN";
                        applyArgs = new Type[2];
                        applyArgs[1] = objArrayType;
                    }
                    applyArgs[0] = procType;
                    this.method = this.curClass.addMethod(mname, applyArgs, this.usingCallContext() ? Type.voidType : Type.objectType, 1);
                    code = this.method.startCode();
                    code.emitLoad(code.getArg(1));
                    code.emitGetField(procType.getField("selector"));
                    aswitch = code.startSwitch();
                    needThisApply = true;
                }
                aswitch.addCase(source.getSelectorValue(this), code);
                SourceLocator saveLoc1 = this.messages.swapSourceLocator(source);
                int line = source.getLineNumber();
                if (line > 0) {
                    code.putLineNumber(source.getFileName(), line);
                }
                Method primMethod = primMethods[methodIndex];
                Type[] primArgTypes = primMethod.getParameterTypes();
                int singleArgs = source.min_args + methodIndex;
                Variable counter = null;
                int pendingIfEnds = 0;
                if (i > 4 && numMethods > 1) {
                    counter = code.addLocal(Type.intType);
                    code.emitLoad(code.getArg(2));
                    code.emitArrayLength();
                    if (source.min_args != 0) {
                        code.emitPushInt(source.min_args);
                        code.emitSub(Type.intType);
                    }
                    code.emitStore(counter);
                }
                int needsThis = primMethod.getStaticFlag() ? 0 : 1;
                int n3 = explicitFrameArg = singleArgs + (varArgs ? 1 : 0) < primArgTypes.length ? 1 : 0;
                if (needsThis + explicitFrameArg > 0) {
                    code.emitPushThis();
                    if (this.curClass == this.moduleClass && this.mainClass != this.moduleClass) {
                        code.emitGetField(this.moduleInstanceMainField);
                    }
                }
                if ((var = source.firstDecl()) != null && var.isThisParameter()) {
                    var = var.nextDecl();
                }
                for (int k = 0; k < singleArgs; ++k) {
                    if (counter != null && k >= source.min_args) {
                        code.emitLoad(counter);
                        code.emitIfIntLEqZero();
                        code.emitInvoke(primMethods[k - source.min_args]);
                        code.emitElse();
                        ++pendingIfEnds;
                        code.emitInc(counter, (short)-1);
                    }
                    Variable pvar = null;
                    if (i <= 4) {
                        pvar = code.getArg(k + 2);
                        code.emitLoad(pvar);
                    } else {
                        code.emitLoad(code.getArg(2));
                        code.emitPushInt(k);
                        code.emitArrayLoad(Type.objectType);
                    }
                    Type ptype = var.getType();
                    if (ptype != Type.objectType) {
                        SourceLocator saveLoc2 = this.messages.swapSourceLocator(var);
                        CheckedTarget.emitCheckedCoerce(this, source, k + 1, Type.objectType, ptype, pvar);
                        this.messages.swapSourceLocator(saveLoc2);
                    }
                    var = var.nextDecl();
                }
                if (varArgs) {
                    Type lastArgType = primArgTypes[explicitFrameArg + singleArgs];
                    if (lastArgType instanceof ArrayType) {
                        this.varArgsToArray(source, singleArgs, counter, lastArgType, null);
                    } else if ("gnu.lists.LList".equals(lastArgType.getName())) {
                        code.emitLoad(code.getArg(2));
                        code.emitPushInt(singleArgs);
                        code.emitInvokeStatic(makeListMethod);
                    } else if (lastArgType == typeCallContext) {
                        code.emitLoad(code.getArg(2));
                    } else {
                        throw new RuntimeException("unsupported #!rest type:" + lastArgType);
                    }
                }
                code.emitInvoke(primMethod);
                while (--pendingIfEnds >= 0) {
                    code.emitFi();
                }
                if (!this.usingCallContext()) {
                    Target.pushObject.compileFromStack(this, source.getReturnType());
                }
                this.messages.swapSourceLocator(saveLoc1);
                code.emitReturn();
            }
            if (needThisApply) {
                aswitch.addDefault(code);
                if (this.usingCallContext()) {
                    Method errMethod = typeModuleMethod.getDeclaredMethod("applyError", 0);
                    code.emitInvokeStatic(errMethod);
                } else {
                    int nargs = i > 4 ? 2 : i + 1;
                    for (int k = 0; k < ++nargs; ++k) {
                        code.emitLoad(code.getArg(k));
                    }
                    code.emitInvokeSpecial(typeModuleBody.getDeclaredMethod(mname, applyArgs));
                }
                code.emitReturn();
                aswitch.finish(code);
            }
            ++i;
        }
        this.method = save_method;
        this.curClass = save_class;
    }

    private void varArgsToArray(LambdaExp source, int singleArgs, Variable counter, Type lastArgType, Variable ctxVar) {
        boolean mustConvert;
        CodeAttr code = this.getCode();
        Type elType = ((ArrayType)lastArgType).getComponentType();
        boolean bl = mustConvert = !"java.lang.Object".equals(elType.getName());
        if (ctxVar != null && !mustConvert) {
            code.emitLoad(ctxVar);
            code.emitPushInt(singleArgs);
            code.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getRestArgsArray", 1));
        } else if (singleArgs == 0 && !mustConvert) {
            code.emitLoad(code.getArg(2));
        } else {
            code.pushScope();
            if (counter == null) {
                counter = code.addLocal(Type.intType);
                if (ctxVar != null) {
                    code.emitLoad(ctxVar);
                    code.emitInvoke(typeCallContext.getDeclaredMethod("getArgCount", 0));
                } else {
                    code.emitLoad(code.getArg(2));
                    code.emitArrayLength();
                }
                if (singleArgs != 0) {
                    code.emitPushInt(singleArgs);
                    code.emitSub(Type.intType);
                }
                code.emitStore(counter);
            }
            code.emitLoad(counter);
            code.emitNewArray(elType.getImplementationType());
            Label testLabel = new Label(code);
            Label loopTopLabel = new Label(code);
            loopTopLabel.setTypes(code);
            code.emitGoto(testLabel);
            loopTopLabel.define(code);
            code.emitDup(1);
            code.emitLoad(counter);
            if (ctxVar != null) {
                code.emitLoad(ctxVar);
            } else {
                code.emitLoad(code.getArg(2));
            }
            code.emitLoad(counter);
            if (singleArgs != 0) {
                code.emitPushInt(singleArgs);
                code.emitAdd(Type.intType);
            }
            if (ctxVar != null) {
                code.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getArgAsObject", 1));
            } else {
                code.emitArrayLoad(Type.objectType);
            }
            if (mustConvert) {
                CheckedTarget.emitCheckedCoerce(this, source, source.getName(), 0, elType, null);
            }
            code.emitArrayStore(elType);
            testLabel.define(code);
            code.emitInc(counter, (short)-1);
            code.emitLoad(counter);
            code.emitGotoIfIntGeZero(loopTopLabel);
            code.popScope();
        }
    }

    private Method startClassInit() {
        ClassType languageType;
        Method registerMethod;
        this.method = this.curClass.addMethod("<clinit>", apply0args, Type.voidType, 9);
        CodeAttr code = this.method.startCode();
        if ((this.generateMainMethod() || this.generatingApplet() || this.generatingServlet()) && (registerMethod = (languageType = (ClassType)Type.make(this.getLanguage().getClass())).getDeclaredMethod("registerEnvironment", 0)) != null) {
            code.emitInvokeStatic(registerMethod);
        }
        return this.method;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void process(int wantedState) {
        Compilation saveCompilation = Compilation.setSaveCurrent(this);
        try {
            OutPort dout;
            ModuleExp mexp = this.getModule();
            if (wantedState >= 4 && this.getState() < 3) {
                this.setState(3);
                this.language.parse(this, 0);
                mexp.classFor(this);
                if (this.lexer != null) {
                    this.lexer.close();
                }
                this.lexer = null;
                this.setState(4);
                if (this.pendingImports != null) {
                    return;
                }
            }
            if (wantedState >= 6 && this.getState() < 6) {
                this.language.resolve(this);
                this.addMainClass(mexp);
                if (this.generateMainMethod() && mexp.staticInitRun()) {
                    this.error('e', "a static init-run module cannot have a 'main' method");
                }
                this.setState(6);
            }
            if (!this.explicit && !this.immediate && this.getMinfo().checkCurrent(ModuleManager.getInstance(), System.currentTimeMillis())) {
                this.getMinfo().cleanupAfterCompilation();
                this.setState(16);
            }
            if (wantedState >= 8 && this.getState() < 8) {
                if (debugPrintExpr) {
                    dout = OutPort.errDefault();
                    dout.println("[Module:" + mexp.getName());
                    mexp.print(dout);
                    dout.println(']');
                    dout.flush();
                }
                PushApply.pushApply(mexp, this);
                this.setState(8);
            }
            if (wantedState >= 10 && this.getState() < 10) {
                InlineCalls.inlineCalls(mexp, this);
                if (enableANF) {
                    ANormalize.aNormalize(mexp, this);
                }
                if (debugPrintANF) {
                    options.set("warn-void-used", Boolean.FALSE);
                    dout = OutPort.errDefault();
                    dout.println("[Normalized module: " + mexp.getName() + " to " + this.mainClass.getName() + ":");
                    mexp.print(dout);
                    dout.println(']');
                    dout.flush();
                }
                ChainLambdas.chainLambdas(mexp, this);
                FindTailCalls.findTailCalls(mexp, this);
                this.setState(10);
            }
            if (wantedState >= 12 && this.getState() < 12) {
                this.litTable = new LitTable(this);
                mexp.setCanRead(true);
                FindCapturedVars.findCapturedVars(mexp, this);
                mexp.allocFields(this);
                mexp.allocChildMethods(this);
                this.setState(12);
            }
            if (wantedState >= 14 && this.messages.seenErrors()) {
                this.setState(100);
            }
            if (wantedState >= 14 && this.getState() < 14) {
                if (mexp.subModulesOnly()) {
                    this.setState(wantedState < 16 ? 14 : 16);
                } else {
                    if (this.immediate) {
                        ClassLoader parentLoader = ObjectType.getContextClassLoader();
                        this.loader = new ArrayClassLoader(parentLoader);
                    }
                    this.generateBytecode();
                    this.setState(this.messages.seenErrors() ? 100 : 14);
                }
            }
            if (wantedState >= 16 && this.getState() < 16 && !mexp.subModulesOnly()) {
                this.outputClass(ModuleManager.getInstance().getCompilationDirectory());
                this.setState(16);
            }
        }
        catch (SyntaxException ex) {
            this.setState(100);
            if (ex.getMessages() != this.getMessages()) {
                throw new RuntimeException("confussing syntax error: " + ex);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
            this.error('f', "caught " + ex);
            this.setState(100);
        }
        finally {
            Compilation.restoreCurrent(saveCompilation);
        }
    }

    void generateBytecode() {
        Method apply_method;
        int arg_count;
        int line;
        String uri;
        Type[] arg_types;
        ModuleExp module = this.getModule();
        if (debugPrintFinalExpr) {
            OutPort dout = OutPort.errDefault();
            dout.println("[Compiling final " + module.getName() + " to " + this.mainClass.getName() + ":");
            module.print(dout);
            dout.println(']');
            dout.flush();
        }
        ClassType neededSuper = this.getModuleType();
        if (this.mainClass.getSuperclass().isSubtype(neededSuper) && !module.getFlag(8388608)) {
            this.moduleClass = this.mainClass;
        } else {
            this.moduleClass = new ClassType(this.generateClassName("frame"));
            this.moduleClass.setSuper(neededSuper);
            this.addClass(this.moduleClass);
            this.generateConstructor(this.moduleClass, null);
        }
        this.curClass = module.compiledType;
        LambdaExp saveLambda = this.curLambda;
        this.curLambda = module;
        String runName = "run";
        int runFlags = 17;
        if (module.staticInitRun()) {
            arg_types = Type.typeArray0;
            runName = "$runBody$";
            runFlags = 10;
        } else if (module.isHandlingTailCalls()) {
            arg_count = 1;
            arg_types = new Type[]{typeCallContext};
        } else if (module.min_args != module.max_args || module.min_args > 4) {
            arg_count = 1;
            arg_types = new Type[]{new ArrayType(typeObject)};
        } else {
            arg_count = module.min_args;
            arg_types = new Type[arg_count];
            int i = arg_count;
            while (--i >= 0) {
                arg_types[i] = typeObject;
            }
        }
        Variable heapFrame = module.heapFrame;
        boolean staticModule = module.isStatic();
        this.method = apply_method = this.curClass.addMethod(runName, arg_types, Type.voidType, runFlags);
        this.method.initCode();
        CodeAttr code = this.getCode();
        this.thisDecl = this.method.getStaticFlag() ? null : module.declareThis(module.compiledType);
        module.closureEnv = module.thisVariable;
        module.heapFrame = module.isStatic() ? null : module.thisVariable;
        module.allocChildClasses(this);
        if (!module.staticInitRun() && (module.isHandlingTailCalls() || this.usingCPStyle())) {
            this.callContextVar = new Variable("$ctx", typeCallContext);
            module.getVarScope().addVariableAfter(this.thisDecl, this.callContextVar);
            this.callContextVar.setParameter(true);
        }
        if ((line = module.getLineNumber()) > 0) {
            code.putLineNumber(module.getFileName(), line);
        }
        module.allocParameters(this);
        module.enterFunction(this);
        if (this.usingCPStyle()) {
            this.loadCallContext();
            code.emitGetField(pcCallContextField);
            this.fswitch = code.startSwitch();
            this.fswitch.addCase(0, code);
        }
        module.compileBody(this);
        module.compileEnd(this);
        Label startLiterals = null;
        Label afterLiterals = null;
        Method initMethod = null;
        if (this.curClass == this.mainClass) {
            Initializer init;
            Method save_method = this.method;
            Variable callContextSave = this.callContextVar;
            this.callContextVar = null;
            this.clinitMethod = initMethod = this.startClassInit();
            code = this.getCode();
            startLiterals = new Label(code);
            afterLiterals = new Label(code);
            code.fixupChain(afterLiterals, startLiterals);
            if (staticModule) {
                if (!module.getFlag(8388608)) {
                    this.generateConstructor(module);
                }
                code.emitNew(this.moduleClass);
                code.emitDup(this.moduleClass);
                code.emitInvokeSpecial(this.moduleClass.constructor);
                this.moduleInstanceMainField = this.moduleClass.addField("$instance", this.moduleClass, 9);
                code.emitPutStatic(this.moduleInstanceMainField);
            }
            while ((init = this.clinitChain) != null) {
                this.clinitChain = null;
                this.dumpInitializers(init);
            }
            if (module.staticInitRun()) {
                code.emitInvoke(apply_method);
            }
            code.emitReturn();
            if (this.moduleClass != this.mainClass && !staticModule && this.curClass.getSuperclass().getDeclaredMethod("run", 0) == null) {
                this.method = this.curClass.addMethod("run", 1, Type.typeArray0, Type.voidType);
                code = this.method.startCode();
                Variable ctxVar = code.addLocal(typeCallContext);
                Variable saveVar = code.addLocal(typeConsumer);
                Variable exceptionVar = code.addLocal(Type.javalangThrowableType);
                code.emitInvokeStatic(getCallContextInstanceMethod);
                code.emitStore(ctxVar);
                gnu.bytecode.Field consumerFld = typeCallContext.getDeclaredField("consumer");
                code.emitLoad(ctxVar);
                code.emitGetField(consumerFld);
                code.emitStore(saveVar);
                code.emitLoad(ctxVar);
                code.emitGetStatic(ClassType.make("gnu.lists.VoidConsumer").getDeclaredField("instance"));
                code.emitPutField(consumerFld);
                code.emitTryStart(false, Type.voidType);
                code.emitPushThis();
                code.emitLoad(ctxVar);
                code.emitInvokeVirtual(save_method);
                code.emitPushNull();
                code.emitStore(exceptionVar);
                code.emitCatchStart(exceptionVar);
                code.emitCatchEnd();
                code.emitTryCatchEnd();
                code.emitLoad(ctxVar);
                code.emitLoad(exceptionVar);
                code.emitLoad(saveVar);
                code.emitInvokeStatic(typeModuleBody.getDeclaredMethod("runCleanup", 3));
                code.emitReturn();
            }
            this.method = save_method;
            this.callContextVar = callContextSave;
        }
        module.generateApplyMethods(this);
        this.curLambda = saveLambda;
        module.heapFrame = heapFrame;
        if (this.usingCPStyle()) {
            code = this.getCode();
            this.fswitch.finish(code);
        }
        if (startLiterals != null || this.callContextVar != null) {
            this.method = initMethod;
            code = this.getCode();
            Label endLiterals = new Label(code);
            code.fixupChain(startLiterals, endLiterals);
            if (this.callContextVarForInit != null) {
                code.emitInvokeStatic(getCallContextInstanceMethod);
                code.emitStore(this.callContextVarForInit);
            }
            try {
                if (this.immediate) {
                    code.emitPushInt(Compilation.registerForImmediateLiterals(this));
                    code.emitInvokeStatic(ClassType.make("gnu.expr.Compilation").getDeclaredMethod("setupLiterals", 1));
                } else {
                    this.litTable.emit();
                }
            }
            catch (Exception ex) {
                this.error('e', "Literals: Internal error:" + ex);
            }
            code.fixupChain(endLiterals, afterLiterals);
        }
        if (this.generateMainMethod() && this.curClass == this.mainClass) {
            Type[] args = new Type[]{new ArrayType(javaStringType)};
            this.method = this.curClass.addMethod("main", 9, args, Type.voidType);
            code = this.method.startCode();
            if (Shell.defaultFormatName != null) {
                code.emitPushString(Shell.defaultFormatName);
                code.emitInvokeStatic(ClassType.make("kawa.Shell").getDeclaredMethod("setDefaultFormat", 1));
            }
            code.emitLoad(code.getArg(0));
            code.emitInvokeStatic(ClassType.make("gnu.expr.ApplicationMainSupport").getDeclaredMethod("processArgs", 1));
            if (this.moduleInstanceMainField != null) {
                code.emitGetStatic(this.moduleInstanceMainField);
            } else {
                code.emitNew(this.curClass);
                code.emitDup(this.curClass);
                code.emitInvokeSpecial(this.curClass.constructor);
            }
            Method runAsMainMethod = null;
            ClassType superClass = this.curClass.getSuperclass();
            if (superClass != typeModuleBody) {
                runAsMainMethod = superClass.getDeclaredMethod("runAsMain", 0);
            }
            if (runAsMainMethod == null) {
                runAsMainMethod = typeModuleBody.getDeclaredMethod("runAsMain", 1);
            }
            code.emitInvoke(runAsMainMethod);
            code.emitReturn();
        }
        if (this.getMinfo() != null && (uri = this.getMinfo().getNamespaceUri()) != null) {
            ModuleManager manager = ModuleManager.getInstance();
            String mainPrefix = this.mainClass.getName();
            int dot = mainPrefix.lastIndexOf(46);
            if (dot < 0) {
                mainPrefix = "";
            } else {
                String mainPackage = mainPrefix.substring(0, dot);
                try {
                    manager.loadPackageInfo(mainPackage);
                }
                catch (ClassNotFoundException ex) {
                }
                catch (Exception ex) {
                    this.error('e', "error loading map for " + mainPackage + " - " + ex);
                }
                mainPrefix = mainPrefix.substring(0, dot + 1);
            }
            ClassType mapClass = new ClassType(mainPrefix + "$ModulesMap$");
            ClassType typeModuleSet = ClassType.make("gnu.expr.ModuleSet");
            mapClass.setSuper(typeModuleSet);
            this.registerClass(mapClass);
            this.method = mapClass.addMethod("<init>", 1, apply0args, Type.voidType);
            Method superConstructor = typeModuleSet.addMethod("<init>", 1, apply0args, Type.voidType);
            code = this.method.startCode();
            code.emitPushThis();
            code.emitInvokeSpecial(superConstructor);
            code.emitReturn();
            ClassType typeModuleManager = ClassType.make("gnu.expr.ModuleManager");
            Type[] margs = new Type[]{typeModuleManager};
            this.method = mapClass.addMethod("register", margs, Type.voidType, 1);
            code = this.method.startCode();
            Method reg = typeModuleManager.getDeclaredMethod("register", 3);
            int i = manager.numModules;
            while (--i >= 0) {
                ModuleInfo mi = manager.modules[i];
                String miClassName = mi.getClassName();
                if (miClassName == null || !miClassName.startsWith(mainPrefix)) continue;
                String moduleSource = mi.sourcePath;
                String moduleUri = mi.getNamespaceUri();
                code.emitLoad(code.getArg(1));
                this.compileConstant(miClassName);
                if (!Path.valueOf(moduleSource).isAbsolute()) {
                    try {
                        String path = Path.toURL(manager.getCompilationDirectory()) + mainPrefix.replace('.', '/');
                        int plen = path.length();
                        if (plen > 0 && path.charAt(plen - 1) != '/') {
                            path = path + '/';
                        }
                        String sourcePath = Path.toURL(mi.getSourceAbsPathname()).toString();
                        moduleSource = Path.relativize(sourcePath, path);
                    }
                    catch (Exception ex) {
                        throw new WrappedException("exception while fixing up '" + moduleSource + '\'', ex);
                    }
                }
                this.compileConstant(moduleSource);
                this.compileConstant(moduleUri);
                code.emitInvokeVirtual(reg);
            }
            code.emitReturn();
        }
    }

    public gnu.bytecode.Field allocLocalField(Type type, String name) {
        if (name == null) {
            name = "tmp_" + ++this.localFieldIndex;
        }
        gnu.bytecode.Field field = this.curClass.addField(name, type, 0);
        return field;
    }

    public final void loadCallContext() {
        CodeAttr code = this.getCode();
        if (this.callContextVar != null && !this.callContextVar.dead()) {
            code.emitLoad(this.callContextVar);
        } else if (this.method == this.clinitMethod) {
            this.callContextVar = new Variable("$ctx", typeCallContext);
            this.callContextVar.reserveLocal(code.getMaxLocals(), code);
            code.emitLoad(this.callContextVar);
            this.callContextVarForInit = this.callContextVar;
        } else {
            code.emitInvokeStatic(getCallContextInstanceMethod);
            code.emitDup();
            this.callContextVar = new Variable("$ctx", typeCallContext);
            code.getCurrentScope().addVariable(code, this.callContextVar);
            code.emitStore(this.callContextVar);
        }
    }

    public void freeLocalField(gnu.bytecode.Field field) {
    }

    public Expression parse(Object input) {
        throw new Error("unimeplemented parse");
    }

    public Language getLanguage() {
        return this.language;
    }

    public LambdaExp currentLambda() {
        return this.current_scope.currentLambda();
    }

    public final ModuleExp getModule() {
        return this.mainLambda;
    }

    public void setModule(ModuleExp mexp) {
        this.mainLambda = mexp;
    }

    public boolean isStatic() {
        return this.mainLambda.isStatic();
    }

    public boolean isInteractive() {
        return this.mainLambda != null && this.mainLambda.getFlag(4194304);
    }

    public ModuleExp currentModule() {
        return this.current_scope.currentModule();
    }

    public void mustCompileHere() {
        if (!this.mustCompile && !ModuleExp.compilerAvailable()) {
            this.error('e', "this expression must be compiled, but compiler is unavailable");
        }
        this.mustCompile = true;
    }

    public ScopeExp currentScope() {
        return this.current_scope;
    }

    public void setCurrentScope(ScopeExp scope) {
        int current_nesting;
        int scope_nesting = ScopeExp.nesting(scope);
        for (current_nesting = ScopeExp.nesting((ScopeExp)this.current_scope); current_nesting > scope_nesting; --current_nesting) {
            this.pop(this.current_scope);
        }
        ScopeExp sc = scope;
        while (scope_nesting > current_nesting) {
            sc = sc.getOuter();
            --scope_nesting;
        }
        while (sc != this.current_scope) {
            this.pop(this.current_scope);
            sc = sc.getOuter();
        }
        this.pushChain(scope, sc);
    }

    public ScopeExp setPushCurrentScope(ScopeExp scope) {
        ScopeExp old = this.currentScope();
        this.lexical.pushSaveTopLevelRedefs();
        this.setCurrentScope(scope);
        return old;
    }

    public void setPopCurrentScope(ScopeExp old) {
        this.setCurrentScope(old);
        this.lexical.popSaveTopLevelRedefs();
    }

    void pushChain(ScopeExp scope, ScopeExp limit) {
        if (scope != limit) {
            this.pushChain(scope.getOuter(), limit);
            this.pushScope(scope);
            this.lexical.push(scope);
        }
    }

    public ModuleExp pushNewModule(Lexer lexer) {
        this.lexer = lexer;
        String filename = lexer == null ? null : lexer.getName();
        ModuleExp module = new ModuleExp();
        if (filename != null) {
            module.setFile(filename);
        }
        if (this.generatingApplet() || this.generatingServlet()) {
            module.setFlag(262144);
        }
        this.mainLambda = module;
        if (this.immediate) {
            module.setFlag(2097152);
            ModuleInfo minfo = new ModuleInfo();
            minfo.setCompilation(this);
        }
        this.push(module);
        return module;
    }

    public void push(ScopeExp scope) {
        this.pushScope(scope);
        this.lexical.push(scope);
    }

    public final void pushScope(ScopeExp scope) {
        if (!this.mustCompile && (scope.mustCompile() || ModuleExp.compilerAvailable() && scope instanceof LambdaExp && !(scope instanceof ModuleExp))) {
            this.mustCompileHere();
        }
        scope.setOuter(this.current_scope);
        this.current_scope = scope;
    }

    public void pop(ScopeExp scope) {
        this.lexical.pop(scope);
        this.current_scope = scope.getOuter();
    }

    public final void pop() {
        this.pop(this.current_scope);
    }

    public void push(Declaration decl) {
        this.lexical.push(decl);
    }

    public Declaration lookup(Object name, int namespace) {
        return this.lexical.lookup(name, namespace);
    }

    public void usedClass(Type type) {
        while (type instanceof ArrayType) {
            type = ((ArrayType)type).getComponentType();
        }
        if (this.immediate && type instanceof ClassType) {
            ClassType cl = (ClassType)type;
            do {
                this.loader.addClass(cl);
                ClassType enc = cl.getDeclaringClass();
                if (enc == null) break;
                cl = enc;
            } while (true);
        }
    }

    public void setModuleName(String name) {
        this.getModule().setName(name);
    }

    public void setInteractiveName() {
        this.setModuleName(ModuleManager.getInstance().getNewInteractiveName());
    }

    public void setEvalName() {
        this.setModuleName(ModuleManager.getInstance().getNewEvalName());
    }

    public SourceMessages getMessages() {
        return this.messages;
    }

    public void setMessages(SourceMessages messages) {
        this.messages = messages;
    }

    public void error(char severity, String message, SourceLocator location2) {
        String file2 = location2.getFileName();
        int line = location2.getLineNumber();
        int column = location2.getColumnNumber();
        if (file2 == null || line <= 0) {
            file2 = this.getFileName();
            line = this.getLineNumber();
            column = this.getColumnNumber();
        }
        if (severity == 'w' && this.warnAsError()) {
            severity = (char)101;
        }
        this.messages.error(severity, file2, line, column, message);
    }

    public void error(char severity, String message) {
        if (severity == 'w' && this.warnAsError()) {
            severity = (char)101;
        }
        this.messages.error(severity, this, message);
    }

    public void error(char severity, Declaration decl, String msg1, String msg2) {
        this.error(severity, msg1 + decl.getName() + msg2, null, decl);
    }

    public void error(char severity, String message, String code, SourceLocator decl) {
        if (severity == 'w' && this.warnAsError()) {
            severity = (char)101;
        }
        String filename = this.getFileName();
        int line = this.getLineNumber();
        int column = this.getColumnNumber();
        int decl_line = decl.getLineNumber();
        if (decl_line > 0) {
            filename = decl.getFileName();
            line = decl_line;
            column = decl.getColumnNumber();
        }
        this.messages.error(severity, filename, line, column, message, code);
    }

    public ErrorExp syntaxError(String message) {
        this.error('e', message);
        return new ErrorExp(message);
    }

    @Override
    public final int getLineNumber() {
        return this.messages.getLineNumber();
    }

    @Override
    public final int getColumnNumber() {
        return this.messages.getColumnNumber();
    }

    @Override
    public final String getFileName() {
        return this.messages.getFileName();
    }

    @Override
    public String getPublicId() {
        return this.messages.getPublicId();
    }

    @Override
    public String getSystemId() {
        return this.messages.getSystemId();
    }

    @Override
    public boolean isStableSourceLocation() {
        return false;
    }

    public void setFile(String filename) {
        this.messages.setFile(filename);
    }

    public void setLine(int line) {
        this.messages.setLine(line);
    }

    public void setColumn(int column) {
        this.messages.setColumn(column);
    }

    public final void setLine(Expression position) {
        this.messages.setLocation(position);
    }

    public void setLine(Object location2) {
        if (location2 instanceof SourceLocator) {
            this.messages.setLocation((SourceLocator)location2);
        }
    }

    public final void setLocation(SourceLocator position) {
        this.messages.setLocation(position);
    }

    public void setLine(String filename, int line, int column) {
        this.messages.setLine(filename, line, column);
    }

    public Path getSourceAbsPath() {
        ModuleInfo info;
        String currentFileName = this.getFileName();
        if (currentFileName != null && (info = this.getMinfo()) != null && info.getSourceAbsPath() != null) {
            return Path.valueOf(currentFileName).getAbsolute();
        }
        return null;
    }

    public void letStart() {
        this.pushScope(new LetExp());
    }

    public Declaration letVariable(Object name, Type type, Expression init) {
        Declaration decl = new Declaration(name, type);
        this.letVariable(decl, init);
        return decl;
    }

    public void letVariable(Declaration decl, Expression init) {
        LetExp let2 = (LetExp)this.current_scope;
        let2.add(decl);
        decl.setInitValue(init);
    }

    public void letEnter() {
        LetExp let2 = (LetExp)this.current_scope;
        let2.setFlag(1);
        for (Declaration decl = let2.firstDecl(); decl != null; decl = decl.nextDecl()) {
            Expression init = decl.getInitValue();
            if (init == QuoteExp.undefined_exp) continue;
            decl.noteValueFromLet(let2);
        }
        this.lexical.push(let2);
    }

    public LetExp letDone(Expression body) {
        LetExp let2 = (LetExp)this.current_scope;
        if (!let2.getFlag(1)) {
            this.letEnter();
        }
        let2.setFlag(false, 1);
        let2.body = body;
        this.pop(let2);
        return let2;
    }

    private void checkLoop() {
        if (((LambdaExp)this.current_scope).getName() != "%do%loop") {
            throw new Error("internal error - bad loop state");
        }
    }

    public LambdaExp loopStart() {
        if (this.exprStack == null) {
            this.exprStack = new Stack();
        }
        LambdaExp loopLambda = new LambdaExp();
        LetExp let2 = new LetExp();
        String fname = "%do%loop";
        Declaration fdecl = let2.addDeclaration(fname);
        fdecl.setInitValue(loopLambda);
        fdecl.noteValueFromLet(let2);
        loopLambda.setName(fname);
        let2.setOuter(this.current_scope);
        loopLambda.setOuter(let2);
        this.current_scope = loopLambda;
        return loopLambda;
    }

    public Declaration loopVariable(Object name, Type type, Expression init) {
        this.checkLoop();
        LambdaExp loopLambda = (LambdaExp)this.current_scope;
        Declaration decl = loopLambda.addDeclaration(name, type);
        this.exprStack.push(init);
        ++loopLambda.min_args;
        return decl;
    }

    public void loopEnter() {
        int ninits;
        this.checkLoop();
        LambdaExp loopLambda = (LambdaExp)this.current_scope;
        loopLambda.max_args = ninits = loopLambda.min_args;
        Expression[] inits = new Expression[ninits];
        int i = ninits;
        while (--i >= 0) {
            inits[i] = this.exprStack.pop();
        }
        LetExp let2 = (LetExp)loopLambda.getOuter();
        Declaration fdecl = let2.firstDecl();
        let2.setBody(new ApplyExp(new ReferenceExp(fdecl), inits));
        this.lexical.push(loopLambda);
    }

    @Deprecated
    public void loopCond(Expression cond) {
        this.checkLoop();
        this.exprStack.push(cond);
    }

    @Deprecated
    public void loopBody(Expression body) {
        LambdaExp loopLambda = (LambdaExp)this.current_scope;
        loopLambda.body = body;
    }

    public /* varargs */ Expression loopRepeat(LambdaExp loop, Expression ... exps) {
        ScopeExp let2 = loop.getOuter();
        Declaration fdecl = let2.firstDecl();
        return new ApplyExp(new ReferenceExp(fdecl), exps);
    }

    public Expression loopDone(Expression body) {
        LambdaExp loopLambda = (LambdaExp)this.current_scope;
        ScopeExp let2 = loopLambda.getOuter();
        loopLambda.body = body;
        this.lexical.pop(loopLambda);
        this.current_scope = let2.getOuter();
        return let2;
    }

    public /* varargs */ Expression loopRepeatDone(Expression ... exps) {
        LambdaExp loopLambda = (LambdaExp)this.current_scope;
        ScopeExp let2 = loopLambda.getOuter();
        Expression cond = this.exprStack.pop();
        Expression recurse = this.loopRepeat(loopLambda, exps);
        loopLambda.body = new IfExp(cond, new BeginExp(loopLambda.body, recurse), QuoteExp.voidExp);
        this.lexical.pop(loopLambda);
        this.current_scope = let2.getOuter();
        return let2;
    }

    public Expression applyFunction(Expression func) {
        return null;
    }

    public QuoteExp makeQuoteExp(Object value) {
        return QuoteExp.getInstance(value, this);
    }

    public static ApplyExp makeCoercion(Expression value, Expression type) {
        Expression[] exps = new Expression[]{type, value};
        QuoteExp c = new QuoteExp(Convert.cast);
        return new ApplyExp(c, exps);
    }

    public static ApplyExp makeCoercion(Expression value, Type type) {
        return Compilation.makeCoercion(value, new QuoteExp(type));
    }

    public void loadClassRef(ObjectType clas) {
        CodeAttr code = this.getCode();
        if (this.curClass.getClassfileVersion() >= 3211264) {
            code.emitPushClass(clas);
        } else if (clas == this.mainClass && this.mainLambda.isStatic() && this.moduleInstanceMainField != null) {
            code.emitGetStatic(this.moduleInstanceMainField);
            code.emitInvokeVirtual(Type.objectType.getDeclaredMethod("getClass", 0));
        } else {
            String name = clas instanceof ClassType ? clas.getName() : clas.getInternalName().replace('/', '.');
            code.emitPushString(name);
            code.emitInvokeStatic(this.getForNameHelper());
        }
    }

    public Method getForNameHelper() {
        if (this.forNameHelper == null) {
            Method save_method = this.method;
            this.forNameHelper = this.method = this.curClass.addMethod("class$", 9, string1Arg, typeClass);
            CodeAttr code = this.method.startCode();
            code.emitLoad(code.getArg(0));
            code.emitPushInt(0);
            code.emitPushString(this.mainClass.getName());
            code.emitInvokeStatic(typeClass.getDeclaredMethod("forName", 1));
            code.emitInvokeVirtual(typeClass.getDeclaredMethod("getClassLoader", 0));
            code.emitInvokeStatic(typeClass.getDeclaredMethod("forName", 3));
            code.emitReturn();
            this.method = save_method;
        }
        return this.forNameHelper;
    }

    public Environment getGlobalEnvironment() {
        return Environment.getCurrent();
    }

    public Object resolve(Object name, boolean function2) {
        Environment env = this.getGlobalEnvironment();
        Symbol symbol = name instanceof String ? env.defaultNamespace().lookup((String)name) : (Symbol)name;
        if (symbol == null) {
            return null;
        }
        if (function2 && this.getLanguage().hasSeparateFunctionNamespace()) {
            return env.getFunction(symbol, null);
        }
        return env.get(symbol, null);
    }

    public static void setupLiterals(int key) {
        Compilation comp = Compilation.findForImmediateLiterals(key);
        try {
            Class clas = comp.loader.loadClass(comp.mainClass.getName());
            Literal init = comp.litTable.literalsChain;
            while (init != null) {
                clas.getDeclaredField(init.field.getName()).set(null, init.value);
                init = init.next;
            }
            comp.litTable = null;
        }
        catch (Throwable ex) {
            WrappedException.rethrow(ex);
        }
    }

    public static synchronized int registerForImmediateLiterals(Compilation comp) {
        int i = 0;
        Compilation c = chainUninitialized;
        while (c != null) {
            if (i <= c.keyUninitialized) {
                i = c.keyUninitialized + 1;
            }
            c = c.nextUninitialized;
        }
        comp.keyUninitialized = i;
        comp.nextUninitialized = chainUninitialized;
        chainUninitialized = comp;
        return i;
    }

    public static synchronized Compilation findForImmediateLiterals(int key) {
        Compilation prev = null;
        Compilation comp = chainUninitialized;
        do {
            Compilation next = comp.nextUninitialized;
            if (comp.keyUninitialized == key) {
                if (prev == null) {
                    chainUninitialized = next;
                } else {
                    prev.nextUninitialized = next;
                }
                comp.nextUninitialized = null;
                return comp;
            }
            prev = comp;
            comp = next;
        } while (true);
    }

    public static Compilation getCurrent() {
        return current.get();
    }

    public static void setCurrent(Compilation comp) {
        current.set(comp);
    }

    public static Compilation setSaveCurrent(Compilation comp) {
        Compilation save = current.get();
        current.set(comp);
        return save;
    }

    public static void restoreCurrent(Compilation saved) {
        current.set(saved);
    }

    public String toString() {
        return "<compilation " + this.mainLambda + ">";
    }

    public ModuleInfo getMinfo() {
        return this.mainLambda.info;
    }

    static {
        debugPrintANF = false;
        enableANF = false;
        options = new Options();
        fullTailCallsVariable = options.add("full-tailcalls", 1, Boolean.TRUE, "support full tailcalls");
        mainMethodVariable = options.add("main", 1, Boolean.FALSE, "generate an application, with a main method");
        warnUnreachable = options.add("warn-unreachable", 1, Boolean.TRUE, "warn if this code can never be executed");
        warnVoidUsed = options.add("warn-void-used", 1, Boolean.TRUE, "warn if void-valued expression is used");
        warnUndefinedVariable = options.add("warn-undefined-variable", 1, Boolean.TRUE, "warn if no compiler-visible binding for a variable");
        warnUnknownMember = options.add("warn-unknown-member", 1, Boolean.TRUE, "warn if referencing an unknown method or field");
        warnInvokeUnknownMethod = options.add("warn-invoke-unknown-method", 1, warnUnknownMember, "warn if invoke calls an unknown method (subsumed by warn-unknown-member)");
        warnUnused = options.add("warn-unused", 1, Boolean.TRUE, "warn if a variable is usused or code never executed");
        warnAsError = options.add("warn-as-error", 1, Boolean.FALSE, "Make all warnings into errors");
        defaultClassFileVersion = 3211264;
        moduleStatic = 0;
        typeObject = Type.objectType;
        scmBooleanType = ClassType.make("java.lang.Boolean");
        typeString = ClassType.make("java.lang.String");
        typeCharSequence = ClassType.make("java.lang.CharSequence");
        javaStringType = typeString;
        scmKeywordType = ClassType.make("gnu.expr.Keyword");
        scmSequenceType = ClassType.make("gnu.lists.Sequence");
        typeList = ClassType.make("java.util.List");
        scmListType = ClassType.make("gnu.lists.LList");
        typePair = ClassType.make("gnu.lists.Pair");
        objArrayType = ArrayType.make(typeObject);
        typeRunnable = ClassType.make("java.lang.Runnable");
        typeRunnableModule = ClassType.make("gnu.expr.RunnableModule");
        typeType = ClassType.make("gnu.bytecode.Type");
        typeObjectType = ClassType.make("gnu.bytecode.ObjectType");
        typeClass = Type.javalangClassType;
        typeClassType = ClassType.make("gnu.bytecode.ClassType");
        typeProcedure = ClassType.make("gnu.mapping.Procedure");
        typeLanguage = ClassType.make("gnu.expr.Language");
        typeEnvironment = ClassType.make("gnu.mapping.Environment");
        typeLocation = ClassType.make("gnu.mapping.Location");
        typeLocationProc = ClassType.make("gnu.mapping.LocationProc");
        typeFieldLocation = ClassType.make("gnu.kawa.reflect.FieldLocation");
        typeStaticFieldLocation = ClassType.make("gnu.kawa.reflect.StaticFieldLocation");
        typeSymbol = ClassType.make("gnu.mapping.Symbol");
        trueConstant = scmBooleanType.getDeclaredField("TRUE");
        falseConstant = scmBooleanType.getDeclaredField("FALSE");
        int1Args = new Type[]{Type.intType};
        string1Arg = new Type[]{javaStringType};
        sym1Arg = string1Arg;
        Type[] makeListArgs = new Type[]{objArrayType, Type.intType};
        makeListMethod = scmListType.addMethod("makeList", makeListArgs, scmListType, 9);
        getCurrentEnvironmentMethod = typeEnvironment.addMethod("getCurrent", Type.typeArray0, typeEnvironment, 9);
        apply0args = Type.typeArray0;
        apply1args = new Type[]{typeObject};
        apply2args = new Type[]{typeObject, typeObject};
        applyNargs = new Type[]{objArrayType};
        apply0method = typeProcedure.addMethod("apply0", apply0args, typeObject, 17);
        apply1method = typeProcedure.addMethod("apply1", apply1args, typeObject, 1);
        apply2method = typeProcedure.addMethod("apply2", apply2args, typeObject, 1);
        Type[] apply3args = new Type[]{typeObject, typeObject, typeObject};
        apply3method = typeProcedure.addMethod("apply3", apply3args, typeObject, 1);
        Type[] apply4args = new Type[]{typeObject, typeObject, typeObject, typeObject};
        apply4method = typeProcedure.addMethod("apply4", apply4args, typeObject, 1);
        applyNmethod = typeProcedure.addMethod("applyN", applyNargs, typeObject, 1);
        Type[] args = new Type[]{typeProcedure, Type.intType};
        checkArgCountMethod = typeProcedure.addMethod("checkArgCount", args, Type.voidType, 9);
        applymethods = new Method[]{apply0method, apply1method, apply2method, apply3method, apply4method, applyNmethod};
        typeProcedure0 = ClassType.make("gnu.mapping.Procedure0");
        typeProcedure1 = ClassType.make("gnu.mapping.Procedure1");
        typeProcedure2 = ClassType.make("gnu.mapping.Procedure2");
        typeProcedure3 = ClassType.make("gnu.mapping.Procedure3");
        typeProcedure4 = ClassType.make("gnu.mapping.Procedure4");
        typeProcedureN = ClassType.make("gnu.mapping.ProcedureN");
        typeModuleBody = ClassType.make("gnu.expr.ModuleBody");
        typeApplet = ClassType.make("java.applet.Applet");
        typeServlet = ClassType.make("gnu.kawa.servlet.KawaServlet");
        typeCallContext = ClassType.make("gnu.mapping.CallContext");
        typeConsumer = ClassType.make("gnu.lists.Consumer");
        getCallContextInstanceMethod = typeCallContext.getDeclaredMethod("getInstance", 0);
        typeValues = ClassType.make("gnu.mapping.Values");
        noArgsField = typeValues.getDeclaredField("noArgs");
        pcCallContextField = typeCallContext.getDeclaredField("pc");
        typeMethodProc = ClassType.make("gnu.mapping.MethodProc");
        typeModuleMethod = ClassType.make("gnu.expr.ModuleMethod");
        typeModuleMethodWithContext = ClassType.make("gnu.expr.ModuleMethodWithContext");
        argsCallContextField = typeCallContext.getDeclaredField("values");
        procCallContextField = typeCallContext.getDeclaredField("proc");
        applyCpsArgs = new Type[]{typeCallContext};
        applyCpsMethod = typeProcedure.addMethod("apply", applyCpsArgs, Type.voidType, 1);
        typeProcedureArray = new ClassType[]{typeProcedure0, typeProcedure1, typeProcedure2, typeProcedure3, typeProcedure4};
        inlineOk = true;
        classTypeComparator = new Comparator<ClassType>(){

            @Override
            public int compare(ClassType arg0, ClassType arg1) {
                return arg0.getName().compareTo(arg1.getName());
            }
        };
        classPrefixDefault = "";
        emitSourceDebugExtAttr = true;
        current = new InheritableThreadLocal<Compilation>();
    }

}

