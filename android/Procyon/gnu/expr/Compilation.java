// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.EnvironmentKey;
import gnu.mapping.Symbol;
import gnu.mapping.Environment;
import gnu.kawa.functions.Convert;
import gnu.mapping.WrappedException;
import gnu.kawa.io.Path;
import kawa.Shell;
import gnu.text.SyntaxException;
import gnu.kawa.io.OutPort;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.CRC32;
import java.util.zip.ZipOutputStream;
import java.io.OutputStream;
import java.util.jar.JarOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import gnu.bytecode.Label;
import gnu.bytecode.ObjectType;
import gnu.lists.Sequence;
import gnu.text.Char;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.bytecode.PrimType;
import gnu.kawa.reflect.LazyType;
import gnu.mapping.Values;
import gnu.mapping.Procedure;
import gnu.bytecode.CodeAttr;
import kawa.standard.require;
import kawa.lang.Translator;
import gnu.text.SourceMessages;
import java.util.Comparator;
import gnu.bytecode.Type;
import gnu.bytecode.ArrayType;
import gnu.bytecode.SwitchState;
import gnu.bytecode.Method;
import gnu.bytecode.ArrayClassLoader;
import gnu.text.Options;
import java.util.Map;
import java.util.Stack;
import gnu.bytecode.Field;
import gnu.text.Lexer;
import gnu.bytecode.Variable;
import gnu.bytecode.ClassType;
import gnu.text.SourceLocator;

public class Compilation implements SourceLocator
{
    public boolean mustCompile;
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
    Field moduleInstanceMainField;
    public Stack<Object> pendingImports;
    public Map<String, ModuleInfo> subModuleMap;
    public static boolean writeImplicitClasses;
    public static boolean debugPrintExpr;
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
    public Options currentOptions;
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
    Field fswitchIndex;
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
    public static final Field trueConstant;
    public static final Field falseConstant;
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
    public static Field noArgsField;
    public static Field pcCallContextField;
    public static ClassType typeMethodProc;
    public static ClassType typeModuleMethod;
    public static ClassType typeModuleMethodWithContext;
    public static Field argsCallContextField;
    public static Field procCallContextField;
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
    public String classPrefix;
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
    
    public void setState(final int state) {
        this.state = state;
    }
    
    public boolean isPedantic() {
        return this.pedantic;
    }
    
    public void setPedantic(final boolean value) {
        this.pedantic = value;
    }
    
    public void pushPendingImport(final ModuleInfo info, final ScopeExp defs, final Translator.FormStack forms, final require.DeclSetMapper mapper) {
        if (this.pendingImports == null) {
            this.pendingImports = new Stack<Object>();
        }
        this.pendingImports.push(info);
        this.pendingImports.push(defs);
        final Expression posExp = new ReferenceExp((Object)null);
        posExp.setLine(this);
        this.pendingImports.push(posExp);
        this.pendingImports.push(forms.lastPair());
        this.pendingImports.push(mapper);
    }
    
    public boolean generateMainMethod() {
        return this.currentOptions.getBoolean(Compilation.mainMethodVariable);
    }
    
    public boolean warnUnreachable() {
        return this.currentOptions.getBoolean(Compilation.warnUnreachable);
    }
    
    public boolean warnUndefinedVariable() {
        return this.currentOptions.getBoolean(Compilation.warnUndefinedVariable);
    }
    
    public boolean warnUnknownMember() {
        return this.currentOptions.getBoolean(Compilation.warnUnknownMember);
    }
    
    public boolean warnInvokeUnknownMethod() {
        return this.currentOptions.getBoolean(Compilation.warnInvokeUnknownMethod);
    }
    
    public boolean warnUnused() {
        return this.currentOptions.getBoolean(Compilation.warnUnused);
    }
    
    public boolean warnVoidUsed() {
        return !Compilation.enableANF && this.currentOptions.getBoolean(Compilation.warnVoidUsed);
    }
    
    public boolean warnAsError() {
        return this.currentOptions.getBoolean(Compilation.warnAsError);
    }
    
    public final boolean getBooleanOption(final String key, final boolean defaultValue) {
        return this.currentOptions.getBoolean(key, defaultValue);
    }
    
    public final boolean getBooleanOption(final String key) {
        return this.currentOptions.getBoolean(key);
    }
    
    public int currentCallConvention() {
        final Object ft = this.currentOptions.getLocal("full-tailcalls");
        if (ft instanceof Boolean) {
            return ft ? 3 : 1;
        }
        return Compilation.defaultCallConvention;
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
        return (this.langOptions & 0x10) != 0x0;
    }
    
    public boolean generatingServlet() {
        return (this.langOptions & 0x20) != 0x0;
    }
    
    public boolean sharedModuleDefs() {
        return (this.langOptions & 0x2) != 0x0;
    }
    
    public void setSharedModuleDefs(final boolean shared) {
        if (shared) {
            this.langOptions |= 0x2;
        }
        else {
            this.langOptions &= 0xFFFFFFFD;
        }
    }
    
    public final ClassType getModuleType() {
        return Compilation.typeModuleBody;
    }
    
    public void compileConstant(final Object value) {
        final CodeAttr code = this.getCode();
        if (value == null) {
            code.emitPushNull();
        }
        else if (value instanceof String && !this.immediate) {
            code.emitPushString((String)value);
        }
        else {
            final Literal literal = this.litTable.findLiteral(value);
            if (literal.field == null) {
                literal.assign(this.litTable);
            }
            code.emitGetStatic(literal.field);
        }
    }
    
    public boolean inlineOk(final Expression proc) {
        if (proc instanceof LambdaExp) {
            final LambdaExp lproc = (LambdaExp)proc;
            final Declaration nameDecl = lproc.nameDecl;
            if (nameDecl == null || nameDecl.getSymbol() == null || !(nameDecl.context instanceof ModuleExp)) {
                return true;
            }
            if (this.immediate && nameDecl.isPublic() && !lproc.getFlag(2048) && (this.curLambda == null || lproc.topLevel() != this.curLambda.topLevel())) {
                return false;
            }
        }
        return Compilation.inlineOk;
    }
    
    public boolean inlineOk(final Procedure proc) {
        return (!this.immediate || !(proc instanceof ModuleMethod) || !(((ModuleMethod)proc).module.getClass().getClassLoader() instanceof ArrayClassLoader)) && Compilation.inlineOk;
    }
    
    static boolean avoidInline(final LambdaExp proc) {
        return proc.getOuter() instanceof ModuleExp && proc.nameDecl != null;
    }
    
    public boolean isApplyFunction(final Expression exp) {
        return false;
    }
    
    public boolean isSimpleApplyFunction(final Expression exp) {
        return false;
    }
    
    public void compileConstant(Object value, final Target target) {
        if (target instanceof IgnoreTarget) {
            return;
        }
        if (value instanceof Values && target instanceof ConsumerTarget) {
            final Object[] values = ((Values)value).getValues();
            for (int len = values.length, i = 0; i < len; ++i) {
                this.compileConstant(values[i], ((ConsumerTarget)target).getSingleTarget());
            }
            return;
        }
        if (target instanceof ConditionalTarget) {
            final ConditionalTarget ctarg = (ConditionalTarget)target;
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
                    final String signature = type.getSignature();
                    final CodeAttr code = this.getCode();
                    final char sig1 = (signature == null || signature.length() != 1) ? ' ' : signature.charAt(0);
                    if (value instanceof Number) {
                        final Number num = (Number)value;
                        switch (sig1) {
                            case 'C':
                            case 'I': {
                                code.emitPushInt(num.intValue());
                                return;
                            }
                            case 'S': {
                                code.emitPushInt(num.shortValue());
                                return;
                            }
                            case 'B': {
                                code.emitPushInt(num.byteValue());
                                return;
                            }
                            case 'J': {
                                code.emitPushLong(num.longValue());
                                return;
                            }
                            case 'F': {
                                code.emitPushFloat(num.floatValue());
                                return;
                            }
                            case 'D': {
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
                            code.emitPushInt((char)value);
                            return;
                        }
                        if (value == Sequence.eofValue && type == LangPrimType.characterOrEofType) {
                            code.emitPushInt(-1);
                            return;
                        }
                    }
                    if (sig1 == 'C') {
                        code.emitPushInt(((PrimType)type).charValue(value));
                        return;
                    }
                    if (sig1 == 'Z') {
                        final boolean val = this.getLanguage().isTrue(value);
                        code.emitPushInt(val ? 1 : 0);
                        return;
                    }
                }
                catch (ClassCastException ex2) {}
            }
            if (type == Compilation.typeClass && value instanceof ClassType) {
                this.loadClassRef((ObjectType)value);
                return;
            }
            try {
                value = type.coerceFromObject(value);
            }
            catch (Exception ex) {
                final StringBuffer sbuf = new StringBuffer();
                if (value == Values.empty) {
                    sbuf.append("cannot convert void to ");
                }
                else {
                    sbuf.append("cannot convert literal (of type ");
                    if (value == null) {
                        sbuf.append("<null>");
                    }
                    else {
                        sbuf.append(value.getClass().getName());
                    }
                    sbuf.append(") to ");
                }
                sbuf.append(type);
                this.error('w', sbuf.toString());
            }
        }
        this.compileConstant(value);
        target.compileFromStack(this, (value == null) ? target.getType() : Type.make(value.getClass()));
    }
    
    public void emitPushBoolean(final boolean value) {
        final CodeAttr code = this.getCode();
        final Object valObject = this.language.booleanObject(value);
        if (valObject == Boolean.TRUE) {
            code.emitGetStatic(Compilation.trueConstant);
        }
        else if (valObject == Boolean.FALSE) {
            code.emitGetStatic(Compilation.falseConstant);
        }
        else {
            this.compileConstant(valObject);
        }
    }
    
    public void emitCoerceToBoolean() {
        final CodeAttr code = this.getCode();
        final Label trueLabel = new Label(code);
        final Label falseLabel = new Label(code);
        final ConditionalTarget ctarget = new ConditionalTarget(trueLabel, falseLabel, this.getLanguage());
        ctarget.compileFromStack(this, Type.objectType);
        code.emitIfThen();
        trueLabel.define(code);
        code.emitPushInt(1);
        code.emitElse();
        falseLabel.define(code);
        code.emitPushInt(0);
        code.emitFi();
    }
    
    public Type asBooleanValue(final ConditionalTarget target, final Type stackType) {
        return stackType;
    }
    
    private void dumpInitializers(final Initializer inits) {
        this.dumpingInitializers = true;
        for (Initializer init = Initializer.reverse(inits); init != null; init = init.next) {
            init.emit(this);
        }
        this.dumpingInitializers = false;
    }
    
    public ClassType findNamedClass(final String name) {
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
            Arrays.sort(this.classes, 1, this.numClasses, Compilation.classTypeComparator);
            this.classesArrayIsSorted = true;
        }
        final ClassType nameType = new ClassType(name);
        final int index = Arrays.binarySearch(this.classes, 1, this.numClasses, nameType, Compilation.classTypeComparator);
        return (index > -1) ? this.classes[index] : null;
    }
    
    private static void putURLWords(String name, final StringBuffer sbuf) {
        final int dot = name.indexOf(46);
        if (dot > 0) {
            putURLWords(name.substring(dot + 1), sbuf);
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
        }
        else if (len > 4 && name.charAt(3) == ':' && name.substring(0, 3).equalsIgnoreCase("uri")) {
            name = name.substring(4);
            len -= 4;
        }
        int start = 0;
        final StringBuffer sbuf = new StringBuffer();
        while (true) {
            final int slash = name.indexOf(47, start);
            int end = (slash < 0) ? len : slash;
            final boolean first = sbuf.length() == 0;
            if (first && hasSlash) {
                String host = name.substring(start, end);
                if (end - start > 4 && host.startsWith("www.")) {
                    host = host.substring(4);
                }
                putURLWords(host, sbuf);
            }
            else if (start != end) {
                if (!first) {
                    sbuf.append('.');
                }
                if (end == len) {
                    final int dot = name.lastIndexOf(46, len);
                    if (dot > start + 1 && !first) {
                        final int extLen = len - dot;
                        if (extLen <= 4 || (extLen == 5 && name.endsWith("html"))) {
                            len = (end = len - extLen);
                            name = name.substring(0, len);
                        }
                    }
                }
                sbuf.append(name.substring(start, end));
            }
            if (slash < 0) {
                break;
            }
            start = slash + 1;
        }
        return sbuf.toString();
    }
    
    public String generateClassName(String hint) {
        hint = Mangling.mangleClassName(hint);
        if (this.mainClass != null) {
            hint = this.mainClass.getName() + '$' + hint;
        }
        else if (this.classPrefix != null) {
            hint = this.classPrefix + hint;
        }
        if (this.findNamedClass(hint) == null) {
            return hint;
        }
        int i = 0;
        String new_hint;
        while (true) {
            new_hint = hint + i;
            if (this.findNamedClass(new_hint) == null) {
                break;
            }
            ++i;
        }
        return new_hint;
    }
    
    public Compilation(final Language language, final SourceMessages messages, final NameLookup lexical) {
        this.mustCompile = ModuleExp.alwaysCompile;
        this.currentOptions = new Options(Compilation.options);
        this.classPrefix = Compilation.classPrefixDefault;
        this.language = language;
        this.messages = messages;
        this.lexical = lexical;
    }
    
    public void outputClass(final String directory) throws IOException {
        final char dirSep = File.separatorChar;
        for (int iClass = 0; iClass < this.numClasses; ++iClass) {
            final ClassType clas = this.classes[iClass];
            final String out_name = directory + clas.getName().replace('.', dirSep) + ".class";
            final String parent = new File(out_name).getParent();
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
        final ModuleInfo minfo = this.getMinfo();
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
    
    public void compileToArchive(final ModuleExp mexp, String fname) throws IOException {
        boolean makeJar = false;
        if (fname.endsWith(".zip")) {
            makeJar = false;
        }
        else if (fname.endsWith(".jar")) {
            makeJar = true;
        }
        else {
            fname += ".zip";
            makeJar = false;
        }
        this.process(14);
        final File zar_file = new File(fname);
        if (zar_file.exists()) {
            zar_file.delete();
        }
        ZipOutputStream zout;
        if (makeJar) {
            zout = new JarOutputStream(new FileOutputStream(zar_file));
        }
        else {
            zout = new ZipOutputStream(new FileOutputStream(zar_file));
        }
        final byte[][] classBytes = new byte[this.numClasses][];
        final CRC32 zcrc = new CRC32();
        for (int iClass = 0; iClass < this.numClasses; ++iClass) {
            final ClassType clas = this.classes[iClass];
            classBytes[iClass] = clas.writeToArray();
            final ZipEntry zent = new ZipEntry(clas.getName().replace('.', '/') + ".class");
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
        }
        else if (this.numClasses >= this.classes.length) {
            final ClassType[] new_classes = new ClassType[2 * this.classes.length];
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
    
    public void addClass(final ClassType new_class) {
        final String fname = this.getModule().filename;
        if (fname != null) {
            if (Compilation.emitSourceDebugExtAttr) {
                new_class.setStratum(this.getLanguage().getName());
            }
            new_class.setSourceFile(fname);
        }
        this.registerClass(new_class);
        new_class.setClassfileVersion(Compilation.defaultClassFileVersion);
    }
    
    public boolean makeRunnable() {
        return !this.generatingServlet() && !this.generatingApplet() && !this.getModule().staticInitRun() && !this.getModule().getFlag(8388608);
    }
    
    public void addMainClass(final ModuleExp module) {
        this.mainClass = module.classFor(this);
        final ClassType type = this.mainClass;
        final ClassType[] interfaces = module.getInterfaces();
        if (interfaces != null) {
            type.setInterfaces(interfaces);
        }
        ClassType sup = module.getSuperType();
        if (sup == null) {
            if (this.generatingApplet()) {
                sup = Compilation.typeApplet;
            }
            else if (this.generatingServlet()) {
                sup = Compilation.typeServlet;
            }
            else if (module.getFlag(8388608)) {
                sup = Type.objectType;
            }
            else {
                sup = this.getModuleType();
            }
        }
        if (this.makeRunnable()) {
            type.addInterface(Compilation.typeRunnable);
        }
        if (!module.staticInitRun()) {
            type.addInterface(Compilation.typeRunnableModule);
        }
        type.setSuper(sup);
        this.addClass(module.compiledType = type);
    }
    
    public final Method getConstructor(final LambdaExp lexp) {
        return getConstructor(lexp.getHeapFrameType(), lexp);
    }
    
    public static final Method getConstructor(final ClassType clas, final LambdaExp lexp) {
        final Method meth = clas.getDeclaredMethod("<init>", 0);
        if (meth != null) {
            return meth;
        }
        Type[] args;
        if (lexp instanceof ClassExp && lexp.staticLinkField != null) {
            args = new Type[] { lexp.staticLinkField.getType() };
        }
        else {
            args = Compilation.apply0args;
        }
        return clas.addMethod("<init>", 1, args, Type.voidType);
    }
    
    public final void generateConstructor(final LambdaExp lexp) {
        this.generateConstructor(lexp.getHeapFrameType(), lexp);
    }
    
    public final void generateConstructor(final ClassType clas, final LambdaExp lexp) {
        final Method save_method = this.method;
        final Variable callContextSave = this.callContextVar;
        this.callContextVar = null;
        final ClassType save_class = this.curClass;
        this.curClass = clas;
        final Method constructor_method = getConstructor(clas, lexp);
        clas.constructor = constructor_method;
        this.method = constructor_method;
        final CodeAttr code = constructor_method.startCode();
        if (lexp instanceof ClassExp && lexp.staticLinkField != null) {
            code.emitPushThis();
            code.emitLoad(code.getCurrentScope().getVariable(1));
            code.emitPutField(lexp.staticLinkField);
        }
        final ClassType superClass = clas.getSuperclass();
        ClassExp.invokeDefaultSuperConstructor(superClass, this, lexp);
        if (this.curClass == this.mainClass && this.getMinfo() != null && this.getMinfo().sourcePath != null && !this.getModule().getFlag(8388608)) {
            code.emitPushThis();
            code.emitInvokeStatic(ClassType.make("gnu.expr.ModuleInfo").getDeclaredMethod("register", 1));
        }
        if (lexp != null && lexp.initChain != null) {
            final LambdaExp save = this.curLambda;
            this.curLambda = new LambdaExp();
            this.curLambda.closureEnv = code.getArg(0);
            this.curLambda.setOuter(save);
            Initializer init;
            while ((init = lexp.initChain) != null) {
                lexp.initChain = null;
                this.dumpInitializers(init);
            }
            this.curLambda = save;
        }
        if (lexp instanceof ClassExp) {
            final ClassExp cexp = (ClassExp)lexp;
            this.callInitMethods(cexp.getCompiledClassType(this), new ArrayList<ClassType>(10));
        }
        code.emitReturn();
        this.method = save_method;
        this.curClass = save_class;
        this.callContextVar = callContextSave;
    }
    
    void callInitMethods(ClassType clas, final ArrayList<ClassType> seen) {
        if (clas == null) {
            return;
        }
        final String name = clas.getName();
        if ("java.lang.Object".equals(name)) {
            return;
        }
        int i = seen.size();
        while (--i >= 0) {
            if (seen.get(i).getName() == name) {
                return;
            }
        }
        seen.add(clas);
        final ClassType[] interfaces = clas.getInterfaces();
        if (interfaces != null) {
            for (int n = interfaces.length, j = 0; j < n; ++j) {
                this.callInitMethods(interfaces[j], seen);
            }
        }
        int clEnvArgs = 1;
        Label_0170: {
            if (clas.isInterface()) {
                if (clas instanceof PairClassType) {
                    clas = ((PairClassType)clas).instanceType;
                    break Label_0170;
                }
                try {
                    clas = (ClassType)Type.make(Class.forName(clas.getName() + "$class"));
                    break Label_0170;
                }
                catch (Exception ex) {
                    return;
                }
            }
            clEnvArgs = 0;
        }
        final Method meth = clas.getDeclaredMethod("$finit$", clEnvArgs);
        if (meth != null) {
            final CodeAttr code = this.getCode();
            code.emitPushThis();
            code.emitInvoke(meth);
        }
    }
    
    public void generateMatchMethods(final LambdaExp lexp) {
        final int numApplyMethods = (lexp.applyMethods == null) ? 0 : lexp.applyMethods.size();
        if (numApplyMethods == 0) {
            return;
        }
        final Method save_method = this.method;
        final ClassType save_class = this.curClass;
        final ClassType procType = Compilation.typeModuleMethod;
        this.curClass = lexp.getHeapFrameType();
        if (!this.curClass.getSuperclass().isSubtype(Compilation.typeModuleBody)) {
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
                final LambdaExp source = lexp.applyMethods.get(j);
                final Method[] primMethods = source.primMethods;
                int numMethods = primMethods.length;
                boolean varArgs = source.max_args < 0 || source.max_args >= source.min_args + numMethods;
                int methodIndex;
                if (i < 5) {
                    methodIndex = i - source.min_args;
                    if (methodIndex < 0 || methodIndex >= numMethods) {
                        continue;
                    }
                    if (methodIndex == numMethods - 1 && varArgs) {
                        continue;
                    }
                    numMethods = 1;
                    varArgs = false;
                }
                else {
                    methodIndex = 5 - source.min_args;
                    if (methodIndex > 0 && numMethods <= methodIndex && !varArgs) {
                        continue;
                    }
                    methodIndex = numMethods - 1;
                }
                if (!needThisMatch) {
                    if (i < 5) {
                        mname = "match" + i;
                        matchArgs = new Type[i + 2];
                        for (int k = i; k >= 0; --k) {
                            matchArgs[k + 1] = Compilation.typeObject;
                        }
                        matchArgs[i + 1] = Compilation.typeCallContext;
                    }
                    else {
                        mname = "matchN";
                        matchArgs = new Type[] { null, Compilation.objArrayType, Compilation.typeCallContext };
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
                final int line = source.getLineNumber();
                if (line > 0) {
                    code.putLineNumber(source.getFileName(), line);
                }
                final Variable ctxVar = code.getArg((i == 5) ? 3 : (i + 2));
                if (i < 5) {
                    Declaration var = source.firstDecl();
                    for (int l = 1; l <= i; ++l) {
                        code.emitLoad(ctxVar);
                        code.emitLoad(code.getArg(l + 1));
                        final Type ptype = var.getType();
                        if (ptype != Type.objectType) {
                            StackTarget.forceLazyIfNeeded(this, Type.objectType, ptype);
                            if (ptype instanceof TypeValue) {
                                final Label trueLabel = new Label(code);
                                final Label falseLabel = new Label(code);
                                final ConditionalTarget ctarget = new ConditionalTarget(trueLabel, falseLabel, this.getLanguage());
                                code.emitDup();
                                ((TypeValue)ptype).emitIsInstance(null, this, ctarget);
                                falseLabel.define(code);
                                code.emitPushInt(0xFFF40000 | l);
                                code.emitReturn();
                                trueLabel.define(code);
                            }
                            else if (ptype instanceof ClassType && ptype != Type.objectType && ptype != Type.toStringType) {
                                code.emitDup();
                                ptype.emitIsInstance(code);
                                code.emitIfIntEqZero();
                                code.emitPushInt(0xFFF40000 | l);
                                code.emitReturn();
                                code.emitFi();
                            }
                        }
                        code.emitPutField(Compilation.typeCallContext.getField("value" + l));
                        var = var.nextDecl();
                    }
                }
                else {
                    code.emitLoad(ctxVar);
                    code.emitLoad(code.getArg(2));
                    code.emitPutField(Compilation.typeCallContext.getField("values"));
                }
                code.emitLoad(ctxVar);
                final boolean usingCallContext = this.usingCallContext();
                if (usingCallContext) {
                    code.emitLoad(code.getArg(0));
                }
                else {
                    code.emitLoad(code.getArg(1));
                }
                code.emitPutField(Compilation.procCallContextField);
                code.emitLoad(ctxVar);
                if (usingCallContext) {
                    code.emitPushInt(source.getSelectorValue(this) + methodIndex);
                }
                else {
                    code.emitPushInt(i);
                }
                code.emitPutField(Compilation.pcCallContextField);
                code.emitPushInt(0);
                code.emitReturn();
            }
            if (needThisMatch) {
                aswitch.addDefault(code);
                int nargs = (i > 4) ? 2 : (i + 1);
                ++nargs;
                for (int m = 0; m <= nargs; ++m) {
                    code.emitLoad(code.getArg(m));
                }
                final Method defMethod = Compilation.typeModuleBody.getDeclaredMethod(mname, matchArgs.length);
                code.emitInvokeSpecial(defMethod);
                code.emitReturn();
                aswitch.finish(code);
            }
        }
        this.method = save_method;
        this.curClass = save_class;
    }
    
    public void generateApplyMethodsWithContext(final LambdaExp lexp) {
        final int numApplyMethods = (lexp.applyMethods == null) ? 0 : lexp.applyMethods.size();
        if (numApplyMethods == 0) {
            return;
        }
        final ClassType save_class = this.curClass;
        this.curClass = lexp.getHeapFrameType();
        if (!this.curClass.getSuperclass().isSubtype(Compilation.typeModuleBody)) {
            this.curClass = this.moduleClass;
        }
        final ClassType procType = Compilation.typeModuleMethod;
        final Method save_method = this.method;
        CodeAttr code = null;
        final Type[] applyArgs = { Compilation.typeCallContext };
        this.method = this.curClass.addMethod("apply", applyArgs, Type.voidType, 1);
        code = this.method.startCode();
        final Variable ctxVar = code.getArg(1);
        code.emitLoad(ctxVar);
        code.emitGetField(Compilation.pcCallContextField);
        final SwitchState aswitch = code.startSwitch();
        for (int j = 0; j < numApplyMethods; ++j) {
            final LambdaExp source = lexp.applyMethods.get(j);
            if (source.usingCallContext()) {
                final Method[] primMethods = source.primMethods;
                for (int numMethods = primMethods.length, i = 0; i < numMethods; ++i) {
                    final boolean varArgs = i == numMethods - 1 && (source.max_args < 0 || source.max_args >= source.min_args + numMethods);
                    final int methodIndex = i;
                    aswitch.addCase(source.getSelectorValue(this) + i, code);
                    final SourceLocator saveLoc1 = this.messages.swapSourceLocator(source);
                    final int line = source.getLineNumber();
                    if (line > 0) {
                        code.putLineNumber(source.getFileName(), line);
                    }
                    final Method primMethod = primMethods[methodIndex];
                    final Type[] primArgTypes = primMethod.getParameterTypes();
                    final int singleArgs = source.min_args + methodIndex;
                    Variable counter = null;
                    int pendingIfEnds = 0;
                    if (i > 4 && numMethods > 1) {
                        counter = code.addLocal(Type.intType);
                        code.emitLoad(ctxVar);
                        code.emitInvoke(Compilation.typeCallContext.getDeclaredMethod("getArgCount", 0));
                        if (source.min_args != 0) {
                            code.emitPushInt(source.min_args);
                            code.emitSub(Type.intType);
                        }
                        code.emitStore(counter);
                    }
                    final int needsThis = primMethod.getStaticFlag() ? 0 : 1;
                    final int explicitFrameArg = (singleArgs + (varArgs ? 2 : 1) < primArgTypes.length) ? 1 : 0;
                    if (needsThis + explicitFrameArg > 0) {
                        code.emitPushThis();
                        if (this.curClass == this.moduleClass && this.mainClass != this.moduleClass) {
                            code.emitGetField(this.moduleInstanceMainField);
                        }
                    }
                    Declaration var = source.firstDecl();
                    if (var != null && var.isThisParameter()) {
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
                            code.emitInc(counter, (short)(-1));
                        }
                        code.emitLoad(ctxVar);
                        if (k <= 4 && !varArgs && source.max_args <= 4) {
                            code.emitGetField(Compilation.typeCallContext.getDeclaredField("value" + (k + 1)));
                        }
                        else {
                            code.emitGetField(Compilation.typeCallContext.getDeclaredField("values"));
                            code.emitPushInt(k);
                            code.emitArrayLoad(Type.objectType);
                        }
                        final Type ptype = var.getType();
                        if (ptype != Type.objectType) {
                            final SourceLocator saveLoc2 = this.messages.swapSourceLocator(var);
                            CheckedTarget.emitCheckedCoerce(this, source, k + 1, Type.objectType, ptype, null);
                            this.messages.swapSourceLocator(saveLoc2);
                        }
                        var = var.nextDecl();
                    }
                    if (varArgs) {
                        final Type lastArgType = primArgTypes[explicitFrameArg + singleArgs];
                        if (lastArgType instanceof ArrayType) {
                            this.varArgsToArray(source, singleArgs, counter, lastArgType, ctxVar);
                        }
                        else if ("gnu.lists.LList".equals(lastArgType.getName())) {
                            code.emitLoad(ctxVar);
                            code.emitPushInt(singleArgs);
                            code.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("getRestArgsList", 1));
                        }
                        else {
                            if (lastArgType != Compilation.typeCallContext) {
                                throw new RuntimeException("unsupported #!rest type:" + lastArgType);
                            }
                            code.emitLoad(ctxVar);
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
        }
        aswitch.addDefault(code);
        final Method errMethod = Compilation.typeModuleMethod.getDeclaredMethod("applyError", 0);
        code.emitInvokeStatic(errMethod);
        code.emitReturn();
        aswitch.finish(code);
        this.method = save_method;
        this.curClass = save_class;
    }
    
    public void generateApplyMethodsWithoutContext(final LambdaExp lexp) {
        final int numApplyMethods = (lexp.applyMethods == null) ? 0 : lexp.applyMethods.size();
        if (numApplyMethods == 0) {
            return;
        }
        final ClassType save_class = this.curClass;
        this.curClass = lexp.getHeapFrameType();
        final ClassType procType = Compilation.typeModuleMethod;
        if (!this.curClass.getSuperclass().isSubtype(Compilation.typeModuleBody)) {
            this.curClass = this.moduleClass;
        }
        final Method save_method = this.method;
        CodeAttr code = null;
        for (int i = this.usingCallContext() ? 5 : 0; i < 6; ++i) {
            boolean needThisApply = false;
            SwitchState aswitch = null;
            String mname = null;
            Type[] applyArgs = null;
            for (int j = 0; j < numApplyMethods; ++j) {
                final LambdaExp source = lexp.applyMethods.get(j);
                if (!source.usingCallContext()) {
                    final Method[] primMethods = source.primMethods;
                    int numMethods = primMethods.length;
                    boolean varArgs = source.max_args < 0 || source.max_args >= source.min_args + numMethods;
                    boolean skipThisProc = false;
                    int methodIndex;
                    if (i < 5) {
                        methodIndex = i - source.min_args;
                        if (methodIndex < 0 || methodIndex >= numMethods || (methodIndex == numMethods - 1 && varArgs)) {
                            skipThisProc = true;
                        }
                        numMethods = 1;
                        varArgs = false;
                    }
                    else {
                        methodIndex = 5 - source.min_args;
                        if (methodIndex > 0 && numMethods <= methodIndex && !varArgs) {
                            skipThisProc = true;
                        }
                        methodIndex = numMethods - 1;
                    }
                    if (!skipThisProc) {
                        if (!needThisApply) {
                            if (i < 5) {
                                mname = "apply" + i;
                                applyArgs = new Type[i + 1];
                                for (int k = i; k > 0; --k) {
                                    applyArgs[k] = Compilation.typeObject;
                                }
                            }
                            else {
                                mname = "applyN";
                                applyArgs = new Type[] { null, Compilation.objArrayType };
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
                        final SourceLocator saveLoc1 = this.messages.swapSourceLocator(source);
                        final int line = source.getLineNumber();
                        if (line > 0) {
                            code.putLineNumber(source.getFileName(), line);
                        }
                        final Method primMethod = primMethods[methodIndex];
                        final Type[] primArgTypes = primMethod.getParameterTypes();
                        final int singleArgs = source.min_args + methodIndex;
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
                        final int needsThis = primMethod.getStaticFlag() ? 0 : 1;
                        final int explicitFrameArg = (singleArgs + (varArgs ? 1 : 0) < primArgTypes.length) ? 1 : 0;
                        if (needsThis + explicitFrameArg > 0) {
                            code.emitPushThis();
                            if (this.curClass == this.moduleClass && this.mainClass != this.moduleClass) {
                                code.emitGetField(this.moduleInstanceMainField);
                            }
                        }
                        Declaration var = source.firstDecl();
                        if (var != null && var.isThisParameter()) {
                            var = var.nextDecl();
                        }
                        for (int l = 0; l < singleArgs; ++l) {
                            if (counter != null && l >= source.min_args) {
                                code.emitLoad(counter);
                                code.emitIfIntLEqZero();
                                code.emitInvoke(primMethods[l - source.min_args]);
                                code.emitElse();
                                ++pendingIfEnds;
                                code.emitInc(counter, (short)(-1));
                            }
                            Variable pvar = null;
                            if (i <= 4) {
                                pvar = code.getArg(l + 2);
                                code.emitLoad(pvar);
                            }
                            else {
                                code.emitLoad(code.getArg(2));
                                code.emitPushInt(l);
                                code.emitArrayLoad(Type.objectType);
                            }
                            final Type ptype = var.getType();
                            if (ptype != Type.objectType) {
                                final SourceLocator saveLoc2 = this.messages.swapSourceLocator(var);
                                CheckedTarget.emitCheckedCoerce(this, source, l + 1, Type.objectType, ptype, pvar);
                                this.messages.swapSourceLocator(saveLoc2);
                            }
                            var = var.nextDecl();
                        }
                        if (varArgs) {
                            final Type lastArgType = primArgTypes[explicitFrameArg + singleArgs];
                            if (lastArgType instanceof ArrayType) {
                                this.varArgsToArray(source, singleArgs, counter, lastArgType, null);
                            }
                            else if ("gnu.lists.LList".equals(lastArgType.getName())) {
                                code.emitLoad(code.getArg(2));
                                code.emitPushInt(singleArgs);
                                code.emitInvokeStatic(Compilation.makeListMethod);
                            }
                            else {
                                if (lastArgType != Compilation.typeCallContext) {
                                    throw new RuntimeException("unsupported #!rest type:" + lastArgType);
                                }
                                code.emitLoad(code.getArg(2));
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
                }
            }
            if (needThisApply) {
                aswitch.addDefault(code);
                if (this.usingCallContext()) {
                    final Method errMethod = Compilation.typeModuleMethod.getDeclaredMethod("applyError", 0);
                    code.emitInvokeStatic(errMethod);
                }
                else {
                    int nargs = (i > 4) ? 2 : (i + 1);
                    ++nargs;
                    for (int m = 0; m < nargs; ++m) {
                        code.emitLoad(code.getArg(m));
                    }
                    code.emitInvokeSpecial(Compilation.typeModuleBody.getDeclaredMethod(mname, applyArgs));
                }
                code.emitReturn();
                aswitch.finish(code);
            }
        }
        this.method = save_method;
        this.curClass = save_class;
    }
    
    private void varArgsToArray(final LambdaExp source, final int singleArgs, Variable counter, final Type lastArgType, final Variable ctxVar) {
        final CodeAttr code = this.getCode();
        final Type elType = ((ArrayType)lastArgType).getComponentType();
        final boolean mustConvert = !"java.lang.Object".equals(elType.getName());
        if (ctxVar != null && !mustConvert) {
            code.emitLoad(ctxVar);
            code.emitPushInt(singleArgs);
            code.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("getRestArgsArray", 1));
        }
        else if (singleArgs == 0 && !mustConvert) {
            code.emitLoad(code.getArg(2));
        }
        else {
            code.pushScope();
            if (counter == null) {
                counter = code.addLocal(Type.intType);
                if (ctxVar != null) {
                    code.emitLoad(ctxVar);
                    code.emitInvoke(Compilation.typeCallContext.getDeclaredMethod("getArgCount", 0));
                }
                else {
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
            final Label testLabel = new Label(code);
            final Label loopTopLabel = new Label(code);
            loopTopLabel.setTypes(code);
            code.emitGoto(testLabel);
            loopTopLabel.define(code);
            code.emitDup(1);
            code.emitLoad(counter);
            if (ctxVar != null) {
                code.emitLoad(ctxVar);
            }
            else {
                code.emitLoad(code.getArg(2));
            }
            code.emitLoad(counter);
            if (singleArgs != 0) {
                code.emitPushInt(singleArgs);
                code.emitAdd(Type.intType);
            }
            if (ctxVar != null) {
                code.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("getArgAsObject", 1));
            }
            else {
                code.emitArrayLoad(Type.objectType);
            }
            if (mustConvert) {
                CheckedTarget.emitCheckedCoerce(this, source, source.getName(), 0, elType, null);
            }
            code.emitArrayStore(elType);
            testLabel.define(code);
            code.emitInc(counter, (short)(-1));
            code.emitLoad(counter);
            code.emitGotoIfIntGeZero(loopTopLabel);
            code.popScope();
        }
    }
    
    private Method startClassInit() {
        this.method = this.curClass.addMethod("<clinit>", Compilation.apply0args, Type.voidType, 9);
        final CodeAttr code = this.method.startCode();
        if (this.generateMainMethod() || this.generatingApplet() || this.generatingServlet()) {
            final ClassType languageType = (ClassType)Type.make(this.getLanguage().getClass());
            final Method registerMethod = languageType.getDeclaredMethod("registerEnvironment", 0);
            if (registerMethod != null) {
                code.emitInvokeStatic(registerMethod);
            }
        }
        return this.method;
    }
    
    public void process(final int wantedState) {
        final Compilation saveCompilation = setSaveCurrent(this);
        try {
            final ModuleExp mexp = this.getModule();
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
                if (Compilation.debugPrintExpr) {
                    final OutPort dout = OutPort.errDefault();
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
                if (Compilation.enableANF) {
                    ANormalize.aNormalize(mexp, this);
                }
                if (Compilation.debugPrintANF) {
                    Compilation.options.set("warn-void-used", Boolean.FALSE);
                    final OutPort dout = OutPort.errDefault();
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
                    this.setState((wantedState < 16) ? 14 : 16);
                }
                else {
                    if (this.immediate) {
                        final ClassLoader parentLoader = ObjectType.getContextClassLoader();
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
        catch (IOException ex2) {
            ex2.printStackTrace();
            this.error('f', "caught " + ex2);
            this.setState(100);
        }
        finally {
            restoreCurrent(saveCompilation);
        }
    }
    
    void generateBytecode() {
        final ModuleExp module = this.getModule();
        if (Compilation.debugPrintFinalExpr) {
            final OutPort dout = OutPort.errDefault();
            dout.println("[Compiling final " + module.getName() + " to " + this.mainClass.getName() + ":");
            module.print(dout);
            dout.println(']');
            dout.flush();
        }
        final ClassType neededSuper = this.getModuleType();
        if (this.mainClass.getSuperclass().isSubtype(neededSuper) && !module.getFlag(8388608)) {
            this.moduleClass = this.mainClass;
        }
        else {
            (this.moduleClass = new ClassType(this.generateClassName("frame"))).setSuper(neededSuper);
            this.addClass(this.moduleClass);
            this.generateConstructor(this.moduleClass, null);
        }
        this.curClass = module.compiledType;
        final LambdaExp saveLambda = this.curLambda;
        this.curLambda = module;
        String runName = "run";
        int runFlags = 17;
        Type[] arg_types;
        if (module.staticInitRun()) {
            arg_types = Type.typeArray0;
            runName = "$runBody$";
            runFlags = 10;
        }
        else if (module.isHandlingTailCalls()) {
            final int arg_count = 1;
            arg_types = new Type[] { Compilation.typeCallContext };
        }
        else if (module.min_args != module.max_args || module.min_args > 4) {
            final int arg_count = 1;
            arg_types = new Type[] { new ArrayType(Compilation.typeObject) };
        }
        else {
            final int arg_count = module.min_args;
            arg_types = new Type[arg_count];
            int i = arg_count;
            while (--i >= 0) {
                arg_types[i] = Compilation.typeObject;
            }
        }
        final Variable heapFrame = module.heapFrame;
        final boolean staticModule = module.isStatic();
        final Method apply_method = this.curClass.addMethod(runName, arg_types, Type.voidType, runFlags);
        (this.method = apply_method).initCode();
        CodeAttr code = this.getCode();
        this.thisDecl = (this.method.getStaticFlag() ? null : module.declareThis(module.compiledType));
        module.closureEnv = module.thisVariable;
        module.heapFrame = (module.isStatic() ? null : module.thisVariable);
        module.allocChildClasses(this);
        if (!module.staticInitRun() && (module.isHandlingTailCalls() || this.usingCPStyle())) {
            this.callContextVar = new Variable("$ctx", Compilation.typeCallContext);
            module.getVarScope().addVariableAfter(this.thisDecl, this.callContextVar);
            this.callContextVar.setParameter(true);
        }
        final int line = module.getLineNumber();
        if (line > 0) {
            code.putLineNumber(module.getFileName(), line);
        }
        module.allocParameters(this);
        module.enterFunction(this);
        if (this.usingCPStyle()) {
            this.loadCallContext();
            code.emitGetField(Compilation.pcCallContextField);
            (this.fswitch = code.startSwitch()).addCase(0, code);
        }
        module.compileBody(this);
        module.compileEnd(this);
        Label startLiterals = null;
        Label afterLiterals = null;
        Method initMethod = null;
        if (this.curClass == this.mainClass) {
            final Method save_method = this.method;
            final Variable callContextSave = this.callContextVar;
            this.callContextVar = null;
            initMethod = this.startClassInit();
            this.clinitMethod = initMethod;
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
                code.emitPutStatic(this.moduleInstanceMainField = this.moduleClass.addField("$instance", this.moduleClass, 9));
            }
            Initializer init;
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
                final Variable ctxVar = code.addLocal(Compilation.typeCallContext);
                final Variable saveVar = code.addLocal(Compilation.typeConsumer);
                final Variable exceptionVar = code.addLocal(Type.javalangThrowableType);
                code.emitInvokeStatic(Compilation.getCallContextInstanceMethod);
                code.emitStore(ctxVar);
                final Field consumerFld = Compilation.typeCallContext.getDeclaredField("consumer");
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
                code.emitInvokeStatic(Compilation.typeModuleBody.getDeclaredMethod("runCleanup", 3));
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
            final Label endLiterals = new Label(code);
            code.fixupChain(startLiterals, endLiterals);
            if (this.callContextVarForInit != null) {
                code.emitInvokeStatic(Compilation.getCallContextInstanceMethod);
                code.emitStore(this.callContextVarForInit);
            }
            try {
                if (this.immediate) {
                    code.emitPushInt(registerForImmediateLiterals(this));
                    code.emitInvokeStatic(ClassType.make("gnu.expr.Compilation").getDeclaredMethod("setupLiterals", 1));
                }
                else {
                    this.litTable.emit();
                }
            }
            catch (Exception ex) {
                this.error('e', "Literals: Internal error:" + ex);
            }
            code.fixupChain(endLiterals, afterLiterals);
        }
        if (this.generateMainMethod() && this.curClass == this.mainClass) {
            final Type[] args = { new ArrayType(Compilation.javaStringType) };
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
            }
            else {
                code.emitNew(this.curClass);
                code.emitDup(this.curClass);
                code.emitInvokeSpecial(this.curClass.constructor);
            }
            Method runAsMainMethod = null;
            final ClassType superClass = this.curClass.getSuperclass();
            if (superClass != Compilation.typeModuleBody) {
                runAsMainMethod = superClass.getDeclaredMethod("runAsMain", 0);
            }
            if (runAsMainMethod == null) {
                runAsMainMethod = Compilation.typeModuleBody.getDeclaredMethod("runAsMain", 1);
            }
            code.emitInvoke(runAsMainMethod);
            code.emitReturn();
        }
        final String uri;
        if (this.getMinfo() != null && (uri = this.getMinfo().getNamespaceUri()) != null) {
            final ModuleManager manager = ModuleManager.getInstance();
            String mainPrefix = this.mainClass.getName();
            final int dot = mainPrefix.lastIndexOf(46);
            if (dot < 0) {
                mainPrefix = "";
            }
            else {
                final String mainPackage = mainPrefix.substring(0, dot);
                try {
                    manager.loadPackageInfo(mainPackage);
                }
                catch (ClassNotFoundException ex4) {}
                catch (Exception ex2) {
                    this.error('e', "error loading map for " + mainPackage + " - " + ex2);
                }
                mainPrefix = mainPrefix.substring(0, dot + 1);
            }
            final ClassType mapClass = new ClassType(mainPrefix + "$ModulesMap$");
            final ClassType typeModuleSet = ClassType.make("gnu.expr.ModuleSet");
            mapClass.setSuper(typeModuleSet);
            this.registerClass(mapClass);
            this.method = mapClass.addMethod("<init>", 1, Compilation.apply0args, Type.voidType);
            final Method superConstructor = typeModuleSet.addMethod("<init>", 1, Compilation.apply0args, Type.voidType);
            code = this.method.startCode();
            code.emitPushThis();
            code.emitInvokeSpecial(superConstructor);
            code.emitReturn();
            final ClassType typeModuleManager = ClassType.make("gnu.expr.ModuleManager");
            final Type[] margs = { typeModuleManager };
            this.method = mapClass.addMethod("register", margs, Type.voidType, 1);
            code = this.method.startCode();
            final Method reg = typeModuleManager.getDeclaredMethod("register", 3);
            int j = manager.numModules;
            while (--j >= 0) {
                final ModuleInfo mi = manager.modules[j];
                final String miClassName = mi.getClassName();
                if (miClassName != null) {
                    if (!miClassName.startsWith(mainPrefix)) {
                        continue;
                    }
                    String moduleSource = mi.sourcePath;
                    final String moduleUri = mi.getNamespaceUri();
                    code.emitLoad(code.getArg(1));
                    this.compileConstant(miClassName);
                    if (!Path.valueOf(moduleSource).isAbsolute()) {
                        try {
                            String path = Path.toURL(manager.getCompilationDirectory()) + mainPrefix.replace('.', '/');
                            final int plen = path.length();
                            if (plen > 0 && path.charAt(plen - 1) != '/') {
                                path += '/';
                            }
                            final String sourcePath = Path.toURL(mi.getSourceAbsPathname()).toString();
                            moduleSource = Path.relativize(sourcePath, path);
                        }
                        catch (Exception ex3) {
                            throw new WrappedException("exception while fixing up '" + moduleSource + '\'', ex3);
                        }
                    }
                    this.compileConstant(moduleSource);
                    this.compileConstant(moduleUri);
                    code.emitInvokeVirtual(reg);
                }
            }
            code.emitReturn();
        }
    }
    
    public Field allocLocalField(final Type type, String name) {
        if (name == null) {
            name = "tmp_" + ++this.localFieldIndex;
        }
        final Field field = this.curClass.addField(name, type, 0);
        return field;
    }
    
    public final void loadCallContext() {
        final CodeAttr code = this.getCode();
        if (this.callContextVar != null && !this.callContextVar.dead()) {
            code.emitLoad(this.callContextVar);
        }
        else if (this.method == this.clinitMethod) {
            (this.callContextVar = new Variable("$ctx", Compilation.typeCallContext)).reserveLocal(code.getMaxLocals(), code);
            code.emitLoad(this.callContextVar);
            this.callContextVarForInit = this.callContextVar;
        }
        else {
            code.emitInvokeStatic(Compilation.getCallContextInstanceMethod);
            code.emitDup();
            this.callContextVar = new Variable("$ctx", Compilation.typeCallContext);
            code.getCurrentScope().addVariable(code, this.callContextVar);
            code.emitStore(this.callContextVar);
        }
    }
    
    public void freeLocalField(final Field field) {
    }
    
    public Expression parse(final Object input) {
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
    
    public void setModule(final ModuleExp mexp) {
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
    
    public void setCurrentScope(final ScopeExp scope) {
        int scope_nesting;
        int current_nesting;
        for (scope_nesting = ScopeExp.nesting(scope), current_nesting = ScopeExp.nesting(this.current_scope); current_nesting > scope_nesting; --current_nesting) {
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
    
    public ScopeExp setPushCurrentScope(final ScopeExp scope) {
        final ScopeExp old = this.currentScope();
        this.lexical.pushSaveTopLevelRedefs();
        this.setCurrentScope(scope);
        return old;
    }
    
    public void setPopCurrentScope(final ScopeExp old) {
        this.setCurrentScope(old);
        this.lexical.popSaveTopLevelRedefs();
    }
    
    void pushChain(final ScopeExp scope, final ScopeExp limit) {
        if (scope != limit) {
            this.pushChain(scope.getOuter(), limit);
            this.pushScope(scope);
            this.lexical.push(scope);
        }
    }
    
    public ModuleExp pushNewModule(final Lexer lexer) {
        this.lexer = lexer;
        final String filename = (lexer == null) ? null : lexer.getName();
        final ModuleExp module = new ModuleExp();
        if (filename != null) {
            module.setFile(filename);
        }
        if (this.generatingApplet() || this.generatingServlet()) {
            module.setFlag(262144);
        }
        this.mainLambda = module;
        if (this.immediate) {
            module.setFlag(2097152);
            final ModuleInfo minfo = new ModuleInfo();
            minfo.setCompilation(this);
        }
        this.push(module);
        return module;
    }
    
    public void push(final ScopeExp scope) {
        this.pushScope(scope);
        this.lexical.push(scope);
    }
    
    public final void pushScope(final ScopeExp scope) {
        if (!this.mustCompile && (scope.mustCompile() || (ModuleExp.compilerAvailable() && scope instanceof LambdaExp && !(scope instanceof ModuleExp)))) {
            this.mustCompileHere();
        }
        scope.setOuter(this.current_scope);
        this.current_scope = scope;
    }
    
    public void pop(final ScopeExp scope) {
        this.lexical.pop(scope);
        this.current_scope = scope.getOuter();
    }
    
    public final void pop() {
        this.pop(this.current_scope);
    }
    
    public void push(final Declaration decl) {
        this.lexical.push(decl);
    }
    
    public Declaration lookup(final Object name, final int namespace) {
        return this.lexical.lookup(name, namespace);
    }
    
    public void usedClass(Type type) {
        while (type instanceof ArrayType) {
            type = ((ArrayType)type).getComponentType();
        }
        if (this.immediate && type instanceof ClassType) {
            ClassType cl = (ClassType)type;
            while (true) {
                this.loader.addClass(cl);
                final ClassType enc = cl.getDeclaringClass();
                if (enc == null) {
                    break;
                }
                cl = enc;
            }
        }
    }
    
    public void setModuleName(final String name) {
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
    
    public void setMessages(final SourceMessages messages) {
        this.messages = messages;
    }
    
    public void error(char severity, final String message, final SourceLocator location) {
        String file = location.getFileName();
        int line = location.getLineNumber();
        int column = location.getColumnNumber();
        if (file == null || line <= 0) {
            file = this.getFileName();
            line = this.getLineNumber();
            column = this.getColumnNumber();
        }
        if (severity == 'w' && this.warnAsError()) {
            severity = 'e';
        }
        this.messages.error(severity, file, line, column, message);
    }
    
    public void error(char severity, final String message) {
        if (severity == 'w' && this.warnAsError()) {
            severity = 'e';
        }
        this.messages.error(severity, this, message);
    }
    
    public void error(final char severity, final Declaration decl, final String msg1, final String msg2) {
        this.error(severity, msg1 + decl.getName() + msg2, null, decl);
    }
    
    public void error(char severity, final String message, final String code, final SourceLocator decl) {
        if (severity == 'w' && this.warnAsError()) {
            severity = 'e';
        }
        String filename = this.getFileName();
        int line = this.getLineNumber();
        int column = this.getColumnNumber();
        final int decl_line = decl.getLineNumber();
        if (decl_line > 0) {
            filename = decl.getFileName();
            line = decl_line;
            column = decl.getColumnNumber();
        }
        this.messages.error(severity, filename, line, column, message, code);
    }
    
    public ErrorExp syntaxError(final String message) {
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
    
    public void setFile(final String filename) {
        this.messages.setFile(filename);
    }
    
    public void setLine(final int line) {
        this.messages.setLine(line);
    }
    
    public void setColumn(final int column) {
        this.messages.setColumn(column);
    }
    
    public final void setLine(final Expression position) {
        this.messages.setLocation(position);
    }
    
    public void setLine(final Object location) {
        if (location instanceof SourceLocator) {
            this.messages.setLocation((SourceLocator)location);
        }
    }
    
    public final void setLocation(final SourceLocator position) {
        this.messages.setLocation(position);
    }
    
    public void setLine(final String filename, final int line, final int column) {
        this.messages.setLine(filename, line, column);
    }
    
    public Path getSourceAbsPath() {
        final String currentFileName = this.getFileName();
        if (currentFileName != null) {
            final ModuleInfo info = this.getMinfo();
            if (info != null && info.getSourceAbsPath() != null) {
                return Path.valueOf(currentFileName).getAbsolute();
            }
        }
        return null;
    }
    
    public void letStart() {
        this.pushScope(new LetExp());
    }
    
    public Declaration letVariable(final Object name, final Type type, final Expression init) {
        final Declaration decl = new Declaration(name, type);
        this.letVariable(decl, init);
        return decl;
    }
    
    public void letVariable(final Declaration decl, final Expression init) {
        final LetExp let = (LetExp)this.current_scope;
        let.add(decl);
        decl.setInitValue(init);
    }
    
    public void letEnter() {
        final LetExp let = (LetExp)this.current_scope;
        let.setFlag(1);
        for (Declaration decl = let.firstDecl(); decl != null; decl = decl.nextDecl()) {
            final Expression init = decl.getInitValue();
            if (init != QuoteExp.undefined_exp) {
                decl.noteValueFromLet(let);
            }
        }
        this.lexical.push(let);
    }
    
    public LetExp letDone(final Expression body) {
        final LetExp let = (LetExp)this.current_scope;
        if (!let.getFlag(1)) {
            this.letEnter();
        }
        let.setFlag(false, 1);
        let.body = body;
        this.pop(let);
        return let;
    }
    
    private void checkLoop() {
        if (((LambdaExp)this.current_scope).getName() != "%do%loop") {
            throw new Error("internal error - bad loop state");
        }
    }
    
    public LambdaExp loopStart() {
        if (this.exprStack == null) {
            this.exprStack = new Stack<Expression>();
        }
        final LambdaExp loopLambda = new LambdaExp();
        final LetExp let = new LetExp();
        final String fname = "%do%loop";
        final Declaration fdecl = let.addDeclaration(fname);
        fdecl.setInitValue(loopLambda);
        fdecl.noteValueFromLet(let);
        loopLambda.setName(fname);
        let.setOuter(this.current_scope);
        loopLambda.setOuter(let);
        return (LambdaExp)(this.current_scope = loopLambda);
    }
    
    public Declaration loopVariable(final Object name, final Type type, final Expression init) {
        this.checkLoop();
        final LambdaExp loopLambda = (LambdaExp)this.current_scope;
        final Declaration decl = loopLambda.addDeclaration(name, type);
        this.exprStack.push(init);
        final LambdaExp lambdaExp = loopLambda;
        ++lambdaExp.min_args;
        return decl;
    }
    
    public void loopEnter() {
        this.checkLoop();
        final LambdaExp loopLambda = (LambdaExp)this.current_scope;
        final int ninits = loopLambda.min_args;
        loopLambda.max_args = ninits;
        final Expression[] inits = new Expression[ninits];
        int i = ninits;
        while (--i >= 0) {
            inits[i] = this.exprStack.pop();
        }
        final LetExp let = (LetExp)loopLambda.getOuter();
        final Declaration fdecl = let.firstDecl();
        let.setBody(new ApplyExp(new ReferenceExp(fdecl), inits));
        this.lexical.push(loopLambda);
    }
    
    @Deprecated
    public void loopCond(final Expression cond) {
        this.checkLoop();
        this.exprStack.push(cond);
    }
    
    @Deprecated
    public void loopBody(final Expression body) {
        final LambdaExp loopLambda = (LambdaExp)this.current_scope;
        loopLambda.body = body;
    }
    
    public Expression loopRepeat(final LambdaExp loop, final Expression... exps) {
        final ScopeExp let = loop.getOuter();
        final Declaration fdecl = let.firstDecl();
        return new ApplyExp(new ReferenceExp(fdecl), exps);
    }
    
    public Expression loopDone(final Expression body) {
        final LambdaExp loopLambda = (LambdaExp)this.current_scope;
        final ScopeExp let = loopLambda.getOuter();
        loopLambda.body = body;
        this.lexical.pop(loopLambda);
        this.current_scope = let.getOuter();
        return let;
    }
    
    public Expression loopRepeatDone(final Expression... exps) {
        final LambdaExp loopLambda = (LambdaExp)this.current_scope;
        final ScopeExp let = loopLambda.getOuter();
        final Expression cond = this.exprStack.pop();
        final Expression recurse = this.loopRepeat(loopLambda, exps);
        loopLambda.body = new IfExp(cond, new BeginExp(loopLambda.body, recurse), QuoteExp.voidExp);
        this.lexical.pop(loopLambda);
        this.current_scope = let.getOuter();
        return let;
    }
    
    public Expression applyFunction(final Expression func) {
        return null;
    }
    
    public QuoteExp makeQuoteExp(final Object value) {
        return QuoteExp.getInstance(value, this);
    }
    
    public static ApplyExp makeCoercion(final Expression value, final Expression type) {
        final Expression[] exps = { type, value };
        final QuoteExp c = new QuoteExp(Convert.cast);
        return new ApplyExp(c, exps);
    }
    
    public static ApplyExp makeCoercion(final Expression value, final Type type) {
        return makeCoercion(value, new QuoteExp(type));
    }
    
    public void loadClassRef(final ObjectType clas) {
        final CodeAttr code = this.getCode();
        if (this.curClass.getClassfileVersion() >= 3211264) {
            code.emitPushClass(clas);
        }
        else if (clas == this.mainClass && this.mainLambda.isStatic() && this.moduleInstanceMainField != null) {
            code.emitGetStatic(this.moduleInstanceMainField);
            code.emitInvokeVirtual(Type.objectType.getDeclaredMethod("getClass", 0));
        }
        else {
            final String name = (clas instanceof ClassType) ? clas.getName() : clas.getInternalName().replace('/', '.');
            code.emitPushString(name);
            code.emitInvokeStatic(this.getForNameHelper());
        }
    }
    
    public Method getForNameHelper() {
        if (this.forNameHelper == null) {
            final Method save_method = this.method;
            this.method = this.curClass.addMethod("class$", 9, Compilation.string1Arg, Compilation.typeClass);
            this.forNameHelper = this.method;
            final CodeAttr code = this.method.startCode();
            code.emitLoad(code.getArg(0));
            code.emitPushInt(0);
            code.emitPushString(this.mainClass.getName());
            code.emitInvokeStatic(Compilation.typeClass.getDeclaredMethod("forName", 1));
            code.emitInvokeVirtual(Compilation.typeClass.getDeclaredMethod("getClassLoader", 0));
            code.emitInvokeStatic(Compilation.typeClass.getDeclaredMethod("forName", 3));
            code.emitReturn();
            this.method = save_method;
        }
        return this.forNameHelper;
    }
    
    public Environment getGlobalEnvironment() {
        return Environment.getCurrent();
    }
    
    public Object resolve(final Object name, final boolean function) {
        final Environment env = this.getGlobalEnvironment();
        Symbol symbol;
        if (name instanceof String) {
            symbol = env.defaultNamespace().lookup((String)name);
        }
        else {
            symbol = (Symbol)name;
        }
        if (symbol == null) {
            return null;
        }
        if (function && this.getLanguage().hasSeparateFunctionNamespace()) {
            return env.getFunction(symbol, null);
        }
        return env.get(symbol, null);
    }
    
    public static void setupLiterals(final int key) {
        final Compilation comp = findForImmediateLiterals(key);
        try {
            final Class clas = comp.loader.loadClass(comp.mainClass.getName());
            for (Literal init = comp.litTable.literalsChain; init != null; init = init.next) {
                clas.getDeclaredField(init.field.getName()).set(null, init.value);
            }
            comp.litTable = null;
        }
        catch (Throwable ex) {
            WrappedException.rethrow(ex);
        }
    }
    
    public static synchronized int registerForImmediateLiterals(final Compilation comp) {
        int i = 0;
        for (Compilation c = Compilation.chainUninitialized; c != null; c = c.nextUninitialized) {
            if (i <= c.keyUninitialized) {
                i = c.keyUninitialized + 1;
            }
        }
        comp.keyUninitialized = i;
        comp.nextUninitialized = Compilation.chainUninitialized;
        Compilation.chainUninitialized = comp;
        return i;
    }
    
    public static synchronized Compilation findForImmediateLiterals(final int key) {
        Compilation prev = null;
        Compilation comp = Compilation.chainUninitialized;
        Compilation next;
        while (true) {
            next = comp.nextUninitialized;
            if (comp.keyUninitialized == key) {
                break;
            }
            prev = comp;
            comp = next;
        }
        if (prev == null) {
            Compilation.chainUninitialized = next;
        }
        else {
            prev.nextUninitialized = next;
        }
        comp.nextUninitialized = null;
        return comp;
    }
    
    public static Compilation getCurrent() {
        return Compilation.current.get();
    }
    
    public static void setCurrent(final Compilation comp) {
        Compilation.current.set(comp);
    }
    
    public static Compilation setSaveCurrent(final Compilation comp) {
        final Compilation save = Compilation.current.get();
        Compilation.current.set(comp);
        return save;
    }
    
    public static void restoreCurrent(final Compilation saved) {
        Compilation.current.set(saved);
    }
    
    @Override
    public String toString() {
        return "<compilation " + this.mainLambda + ">";
    }
    
    public ModuleInfo getMinfo() {
        return this.mainLambda.info;
    }
    
    static {
        Compilation.writeImplicitClasses = false;
        Compilation.debugPrintExpr = false;
        Compilation.debugPrintANF = false;
        Compilation.enableANF = false;
        Compilation.options = new Options();
        Compilation.fullTailCallsVariable = Compilation.options.add("full-tailcalls", 1, Boolean.TRUE, "support full tailcalls");
        Compilation.mainMethodVariable = Compilation.options.add("main", 1, Boolean.FALSE, "generate an application, with a main method");
        Compilation.warnUnreachable = Compilation.options.add("warn-unreachable", 1, Boolean.TRUE, "warn if this code can never be executed");
        Compilation.warnVoidUsed = Compilation.options.add("warn-void-used", 1, Boolean.TRUE, "warn if void-valued expression is used");
        Compilation.warnUndefinedVariable = Compilation.options.add("warn-undefined-variable", 1, Boolean.TRUE, "warn if no compiler-visible binding for a variable");
        Compilation.warnUnknownMember = Compilation.options.add("warn-unknown-member", 1, Boolean.TRUE, "warn if referencing an unknown method or field");
        Compilation.warnInvokeUnknownMethod = Compilation.options.add("warn-invoke-unknown-method", 1, Compilation.warnUnknownMember, "warn if invoke calls an unknown method (subsumed by warn-unknown-member)");
        Compilation.warnUnused = Compilation.options.add("warn-unused", 1, Boolean.TRUE, "warn if a variable is usused or code never executed");
        Compilation.warnAsError = Compilation.options.add("warn-as-error", 1, Boolean.FALSE, "Make all warnings into errors");
        Compilation.defaultClassFileVersion = 3211264;
        Compilation.moduleStatic = 0;
        Compilation.typeObject = Type.objectType;
        Compilation.scmBooleanType = ClassType.make("java.lang.Boolean");
        Compilation.typeString = ClassType.make("java.lang.String");
        Compilation.typeCharSequence = ClassType.make("java.lang.CharSequence");
        Compilation.javaStringType = Compilation.typeString;
        Compilation.scmKeywordType = ClassType.make("gnu.expr.Keyword");
        Compilation.scmSequenceType = ClassType.make("gnu.lists.Sequence");
        typeList = ClassType.make("java.util.List");
        Compilation.scmListType = ClassType.make("gnu.lists.LList");
        Compilation.typePair = ClassType.make("gnu.lists.Pair");
        objArrayType = ArrayType.make(Compilation.typeObject);
        Compilation.typeRunnable = ClassType.make("java.lang.Runnable");
        Compilation.typeRunnableModule = ClassType.make("gnu.expr.RunnableModule");
        Compilation.typeType = ClassType.make("gnu.bytecode.Type");
        Compilation.typeObjectType = ClassType.make("gnu.bytecode.ObjectType");
        Compilation.typeClass = Type.javalangClassType;
        Compilation.typeClassType = ClassType.make("gnu.bytecode.ClassType");
        Compilation.typeProcedure = ClassType.make("gnu.mapping.Procedure");
        Compilation.typeLanguage = ClassType.make("gnu.expr.Language");
        Compilation.typeEnvironment = ClassType.make("gnu.mapping.Environment");
        Compilation.typeLocation = ClassType.make("gnu.mapping.Location");
        typeLocationProc = ClassType.make("gnu.mapping.LocationProc");
        Compilation.typeFieldLocation = ClassType.make("gnu.kawa.reflect.FieldLocation");
        Compilation.typeStaticFieldLocation = ClassType.make("gnu.kawa.reflect.StaticFieldLocation");
        Compilation.typeSymbol = ClassType.make("gnu.mapping.Symbol");
        trueConstant = Compilation.scmBooleanType.getDeclaredField("TRUE");
        falseConstant = Compilation.scmBooleanType.getDeclaredField("FALSE");
        int1Args = new Type[] { Type.intType };
        string1Arg = new Type[] { Compilation.javaStringType };
        sym1Arg = Compilation.string1Arg;
        final Type[] makeListArgs = { Compilation.objArrayType, Type.intType };
        Compilation.makeListMethod = Compilation.scmListType.addMethod("makeList", makeListArgs, Compilation.scmListType, 9);
        Compilation.getCurrentEnvironmentMethod = Compilation.typeEnvironment.addMethod("getCurrent", Type.typeArray0, Compilation.typeEnvironment, 9);
        Compilation.apply0args = Type.typeArray0;
        Compilation.apply1args = new Type[] { Compilation.typeObject };
        Compilation.apply2args = new Type[] { Compilation.typeObject, Compilation.typeObject };
        Compilation.applyNargs = new Type[] { Compilation.objArrayType };
        Compilation.apply0method = Compilation.typeProcedure.addMethod("apply0", Compilation.apply0args, Compilation.typeObject, 17);
        Compilation.apply1method = Compilation.typeProcedure.addMethod("apply1", Compilation.apply1args, Compilation.typeObject, 1);
        Compilation.apply2method = Compilation.typeProcedure.addMethod("apply2", Compilation.apply2args, Compilation.typeObject, 1);
        final Type[] apply3args = { Compilation.typeObject, Compilation.typeObject, Compilation.typeObject };
        Compilation.apply3method = Compilation.typeProcedure.addMethod("apply3", apply3args, Compilation.typeObject, 1);
        final Type[] apply4args = { Compilation.typeObject, Compilation.typeObject, Compilation.typeObject, Compilation.typeObject };
        Compilation.apply4method = Compilation.typeProcedure.addMethod("apply4", apply4args, Compilation.typeObject, 1);
        Compilation.applyNmethod = Compilation.typeProcedure.addMethod("applyN", Compilation.applyNargs, Compilation.typeObject, 1);
        final Type[] args = { Compilation.typeProcedure, Type.intType };
        Compilation.checkArgCountMethod = Compilation.typeProcedure.addMethod("checkArgCount", args, Type.voidType, 9);
        Compilation.applymethods = new Method[] { Compilation.apply0method, Compilation.apply1method, Compilation.apply2method, Compilation.apply3method, Compilation.apply4method, Compilation.applyNmethod };
        Compilation.typeProcedure0 = ClassType.make("gnu.mapping.Procedure0");
        Compilation.typeProcedure1 = ClassType.make("gnu.mapping.Procedure1");
        Compilation.typeProcedure2 = ClassType.make("gnu.mapping.Procedure2");
        Compilation.typeProcedure3 = ClassType.make("gnu.mapping.Procedure3");
        Compilation.typeProcedure4 = ClassType.make("gnu.mapping.Procedure4");
        Compilation.typeProcedureN = ClassType.make("gnu.mapping.ProcedureN");
        Compilation.typeModuleBody = ClassType.make("gnu.expr.ModuleBody");
        Compilation.typeApplet = ClassType.make("java.applet.Applet");
        Compilation.typeServlet = ClassType.make("gnu.kawa.servlet.KawaServlet");
        Compilation.typeCallContext = ClassType.make("gnu.mapping.CallContext");
        typeConsumer = ClassType.make("gnu.lists.Consumer");
        Compilation.getCallContextInstanceMethod = Compilation.typeCallContext.getDeclaredMethod("getInstance", 0);
        Compilation.typeValues = ClassType.make("gnu.mapping.Values");
        Compilation.noArgsField = Compilation.typeValues.getDeclaredField("noArgs");
        Compilation.pcCallContextField = Compilation.typeCallContext.getDeclaredField("pc");
        Compilation.typeMethodProc = ClassType.make("gnu.mapping.MethodProc");
        Compilation.typeModuleMethod = ClassType.make("gnu.expr.ModuleMethod");
        Compilation.typeModuleMethodWithContext = ClassType.make("gnu.expr.ModuleMethodWithContext");
        Compilation.argsCallContextField = Compilation.typeCallContext.getDeclaredField("values");
        Compilation.procCallContextField = Compilation.typeCallContext.getDeclaredField("proc");
        Compilation.applyCpsArgs = new Type[] { Compilation.typeCallContext };
        Compilation.applyCpsMethod = Compilation.typeProcedure.addMethod("apply", Compilation.applyCpsArgs, Type.voidType, 1);
        Compilation.typeProcedureArray = new ClassType[] { Compilation.typeProcedure0, Compilation.typeProcedure1, Compilation.typeProcedure2, Compilation.typeProcedure3, Compilation.typeProcedure4 };
        Compilation.inlineOk = true;
        classTypeComparator = new Comparator<ClassType>() {
            @Override
            public int compare(final ClassType arg0, final ClassType arg1) {
                return arg0.getName().compareTo(arg1.getName());
            }
        };
        Compilation.classPrefixDefault = "";
        Compilation.emitSourceDebugExtAttr = true;
        current = new InheritableThreadLocal<Compilation>();
    }
}
