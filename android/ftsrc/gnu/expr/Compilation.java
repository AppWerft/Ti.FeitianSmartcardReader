package gnu.expr;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Scope;
import gnu.bytecode.SwitchState;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.mapping.Environment;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.Options;
import gnu.text.Options.OptionInfo;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kawa.lang.Translator.FormStack;

public class Compilation implements SourceLocator
{
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
  
  public int getState() { return state; }
  public void setState(int state) { this.state = state; }
  

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
  public java.util.Map<String, ModuleInfo> subModuleMap;
  public boolean isPedantic()
  {
    return pedantic; }
  public void setPedantic(boolean value) { pedantic = value; }
  


















  public void pushPendingImport(ModuleInfo info, ScopeExp defs, Translator.FormStack forms, kawa.standard.require.DeclSetMapper mapper)
  {
    if (pendingImports == null)
      pendingImports = new Stack();
    pendingImports.push(info);
    pendingImports.push(defs);
    Expression posExp = new ReferenceExp((Object)null);
    posExp.setLine(this);
    pendingImports.push(posExp);
    pendingImports.push(forms.lastPair());
    pendingImports.push(mapper);
  }
  





  public static boolean writeImplicitClasses = false;
  

  public static boolean debugPrintExpr = false;
  

  public static boolean debugPrintFinalExpr;
  
  public static boolean debugPrintANF = false;
  public static boolean enableANF = false;
  
  public static Options options = new Options();
  public static Options.OptionInfo fullTailCallsVariable = options.add("full-tailcalls", 1, Boolean.TRUE, "support full tailcalls");
  


  public static Options.OptionInfo mainMethodVariable = options.add("main", 1, Boolean.FALSE, "generate an application, with a main method");
  


  public static Options.OptionInfo warnUnreachable = options.add("warn-unreachable", 1, Boolean.TRUE, "warn if this code can never be executed");
  


  public static Options.OptionInfo warnVoidUsed = options.add("warn-void-used", 1, Boolean.TRUE, "warn if void-valued expression is used");
  


  public static Options.OptionInfo warnUndefinedVariable = options.add("warn-undefined-variable", 1, Boolean.TRUE, "warn if no compiler-visible binding for a variable");
  


  public static Options.OptionInfo warnUnknownMember = options.add("warn-unknown-member", 1, Boolean.TRUE, "warn if referencing an unknown method or field");
  


  public static Options.OptionInfo warnInvokeUnknownMethod = options.add("warn-invoke-unknown-method", 1, warnUnknownMember, "warn if invoke calls an unknown method (subsumed by warn-unknown-member)");
  


  public static Options.OptionInfo warnUnused = options.add("warn-unused", 1, Boolean.TRUE, "warn if a variable is usused or code never executed");
  


  public static Options.OptionInfo warnAsError = options.add("warn-as-error", 1, Boolean.FALSE, "Make all warnings into errors");
  


  public Options currentOptions = new Options(options);
  
  public boolean generateMainMethod()
  {
    return currentOptions.getBoolean(mainMethodVariable);
  }
  
  public boolean warnUnreachable()
  {
    return currentOptions.getBoolean(warnUnreachable);
  }
  
  public boolean warnUndefinedVariable() {
    return currentOptions.getBoolean(warnUndefinedVariable);
  }
  
  public boolean warnUnknownMember() {
    return currentOptions.getBoolean(warnUnknownMember);
  }
  
  public boolean warnInvokeUnknownMethod() {
    return currentOptions.getBoolean(warnInvokeUnknownMethod);
  }
  
  public boolean warnUnused() {
    return currentOptions.getBoolean(warnUnused);
  }
  
  public boolean warnVoidUsed() {
    return (!enableANF) && (currentOptions.getBoolean(warnVoidUsed));
  }
  
  public boolean warnAsError() {
    return currentOptions.getBoolean(warnAsError);
  }
  

  public final boolean getBooleanOption(String key, boolean defaultValue)
  {
    return currentOptions.getBoolean(key, defaultValue);
  }
  

  public final boolean getBooleanOption(String key)
  {
    return currentOptions.getBoolean(key);
  }
  
  public static int defaultClassFileVersion = 3211264;
  


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
  


  public int currentCallConvention()
  {
    Object ft = currentOptions.getLocal("full-tailcalls");
    if ((ft instanceof Boolean)) {
      return ((Boolean)ft).booleanValue() ? 3 : 1;
    }
    
    return defaultCallConvention;
  }
  

  public boolean usingCPStyle() { return currentCallConvention() == 4; }
  
  public boolean usingTailCalls() { return currentCallConvention() >= 3; }
  
  public boolean usingCallContext() { return currentCallConvention() >= 2; }
  












  public static int moduleStatic = 0;
  
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
  
  public final CodeAttr getCode()
  {
    return method.getCode();
  }
  








  public static ClassType typeObject = Type.objectType;
  public static ClassType scmBooleanType = ClassType.make("java.lang.Boolean");
  public static ClassType typeString = ClassType.make("java.lang.String");
  public static ClassType typeCharSequence = ClassType.make("java.lang.CharSequence");
  public static ClassType javaStringType = typeString;
  public static ClassType scmKeywordType = ClassType.make("gnu.expr.Keyword");
  public static ClassType scmSequenceType = ClassType.make("gnu.lists.Sequence");
  public static final ClassType typeList = ClassType.make("java.util.List");
  public static ClassType scmListType = ClassType.make("gnu.lists.LList");
  public static ClassType typePair = ClassType.make("gnu.lists.Pair");
  public static final ArrayType objArrayType = ArrayType.make(typeObject);
  public static ClassType typeRunnable = ClassType.make("java.lang.Runnable");
  public static ClassType typeRunnableModule = ClassType.make("gnu.expr.RunnableModule");
  public static ClassType typeType = ClassType.make("gnu.bytecode.Type");
  public static ClassType typeObjectType = ClassType.make("gnu.bytecode.ObjectType");
  
  public static ClassType typeClass = Type.javalangClassType;
  public static ClassType typeClassType = ClassType.make("gnu.bytecode.ClassType");
  public static ClassType typeProcedure = ClassType.make("gnu.mapping.Procedure");
  
  public static ClassType typeLanguage = ClassType.make("gnu.expr.Language");
  
  public static ClassType typeEnvironment = ClassType.make("gnu.mapping.Environment");
  
  public static ClassType typeLocation = ClassType.make("gnu.mapping.Location");
  
  public static final ClassType typeLocationProc = ClassType.make("gnu.mapping.LocationProc");
  
  public static ClassType typeFieldLocation = ClassType.make("gnu.kawa.reflect.FieldLocation");
  
  public static ClassType typeStaticFieldLocation = ClassType.make("gnu.kawa.reflect.StaticFieldLocation");
  
  public static ClassType typeSymbol = ClassType.make("gnu.mapping.Symbol");
  
  public static final gnu.bytecode.Field trueConstant = scmBooleanType.getDeclaredField("TRUE");
  
  public static final gnu.bytecode.Field falseConstant = scmBooleanType.getDeclaredField("FALSE");
  

  static Method makeListMethod;
  
  public static final Type[] int1Args = { Type.intType };
  public static final Type[] string1Arg = { javaStringType };
  public static final Type[] sym1Arg = string1Arg;
  public static Method getCurrentEnvironmentMethod;
  public static Type[] apply0args; public static Type[] apply1args; public static Type[] apply2args; public static Type[] applyNargs; static Method checkArgCountMethod; public static Method apply0method; public static Method apply1method;
  static { Type[] makeListArgs = { objArrayType, Type.intType };
    makeListMethod = scmListType.addMethod("makeList", makeListArgs, scmListType, 9);
    



    getCurrentEnvironmentMethod = typeEnvironment.addMethod("getCurrent", Type.typeArray0, typeEnvironment, 9);
    


    apply0args = Type.typeArray0;
    apply1args = new Type[] { typeObject };
    apply2args = new Type[] { typeObject, typeObject };
    applyNargs = new Type[] { objArrayType };
    


    apply0method = typeProcedure.addMethod("apply0", apply0args, typeObject, 17);
    









    apply1method = typeProcedure.addMethod("apply1", apply1args, typeObject, 1);
    
    apply2method = typeProcedure.addMethod("apply2", apply2args, typeObject, 1);
    
    Type[] apply3args = { typeObject, typeObject, typeObject };
    apply3method = typeProcedure.addMethod("apply3", apply3args, typeObject, 1);
    
    Type[] apply4args = { typeObject, typeObject, typeObject, typeObject };
    apply4method = typeProcedure.addMethod("apply4", apply4args, typeObject, 1);
    
    applyNmethod = typeProcedure.addMethod("applyN", applyNargs, typeObject, 1);
    
    Type[] args = new Type[2];
    args[0] = typeProcedure;
    args[1] = Type.intType;
    checkArgCountMethod = typeProcedure.addMethod("checkArgCount", args, Type.voidType, 9); }
  
  public static Method apply2method;
  public static Method apply3method;
  public static Method apply4method;
  public static Method applyNmethod; public static Method[] applymethods = { apply0method, apply1method, apply2method, apply3method, apply4method, applyNmethod };
  


  public static ClassType typeProcedure0 = ClassType.make("gnu.mapping.Procedure0");
  
  public static ClassType typeProcedure1 = ClassType.make("gnu.mapping.Procedure1");
  
  public static ClassType typeProcedure2 = ClassType.make("gnu.mapping.Procedure2");
  
  public static ClassType typeProcedure3 = ClassType.make("gnu.mapping.Procedure3");
  
  public static ClassType typeProcedure4 = ClassType.make("gnu.mapping.Procedure4");
  
  public static ClassType typeProcedureN = ClassType.make("gnu.mapping.ProcedureN");
  
  public static ClassType typeModuleBody = ClassType.make("gnu.expr.ModuleBody");
  
  public static ClassType typeApplet = ClassType.make("java.applet.Applet");
  public static ClassType typeServlet = ClassType.make("gnu.kawa.servlet.KawaServlet");
  

  public static ClassType typeCallContext = ClassType.make("gnu.mapping.CallContext");
  
  public static final ClassType typeConsumer = ClassType.make("gnu.lists.Consumer");
  
  public static Method getCallContextInstanceMethod = typeCallContext.getDeclaredMethod("getInstance", 0);
  
  public static ClassType typeValues = ClassType.make("gnu.mapping.Values");
  
  public static gnu.bytecode.Field noArgsField = typeValues.getDeclaredField("noArgs");
  
  public static gnu.bytecode.Field pcCallContextField = typeCallContext.getDeclaredField("pc");
  
  public static ClassType typeMethodProc = ClassType.make("gnu.mapping.MethodProc");
  
  public static ClassType typeModuleMethod = ClassType.make("gnu.expr.ModuleMethod");
  
  public static ClassType typeModuleMethodWithContext = ClassType.make("gnu.expr.ModuleMethodWithContext");
  

  public static gnu.bytecode.Field argsCallContextField = typeCallContext.getDeclaredField("values");
  
  public static gnu.bytecode.Field procCallContextField = typeCallContext.getDeclaredField("proc");
  
  private static Type[] applyCpsArgs = { typeCallContext };
  public static Method applyCpsMethod = typeProcedure.addMethod("apply", applyCpsArgs, Type.voidType, 1);
  


  public static ClassType[] typeProcedureArray = { typeProcedure0, typeProcedure1, typeProcedure2, typeProcedure3, typeProcedure4 };
  

  Initializer clinitChain;
  

  LitTable litTable;
  

  int langOptions;
  

  public boolean generatingApplet()
  {
    return (langOptions & 0x10) != 0;
  }
  

  public boolean generatingServlet()
  {
    return (langOptions & 0x20) != 0;
  }
  
  public boolean sharedModuleDefs()
  {
    return (langOptions & 0x2) != 0;
  }
  
  public void setSharedModuleDefs(boolean shared)
  {
    if (shared) {
      langOptions |= 0x2;
    } else {
      langOptions &= 0xFFFFFFFD;
    }
  }
  
  public final ClassType getModuleType() {
    return typeModuleBody;
  }
  



  public void compileConstant(Object value)
  {
    CodeAttr code = getCode();
    if (value == null) {
      code.emitPushNull();
    } else if (((value instanceof String)) && (!immediate)) {
      code.emitPushString((String)value);
    } else {
      Literal literal = litTable.findLiteral(value);
      
      if (field == null)
        literal.assign(litTable);
      code.emitGetStatic(field);
    }
  }
  
  public static boolean inlineOk = true;
  boolean dumpingInitializers;
  
  public boolean inlineOk(Expression proc) {
    if ((proc instanceof LambdaExp))
    {
      LambdaExp lproc = (LambdaExp)proc;
      Declaration nameDecl = nameDecl;
      

      if ((nameDecl == null) || (nameDecl.getSymbol() == null) || (!(context instanceof ModuleExp)))
      {
        return true; }
      if ((immediate) && (nameDecl.isPublic()) && (!lproc.getFlag(2048)) && ((curLambda == null) || (lproc.topLevel() != curLambda.topLevel())))
      {


        return false; }
    }
    return inlineOk;
  }
  
  public boolean inlineOk(gnu.mapping.Procedure proc)
  {
    if ((immediate) && ((proc instanceof ModuleMethod)) && ((module.getClass().getClassLoader() instanceof ArrayClassLoader)))
    {
      return false; }
    return inlineOk;
  }
  




  static boolean avoidInline(LambdaExp proc)
  {
    return ((proc.getOuter() instanceof ModuleExp)) && (nameDecl != null);
  }
  
  public boolean isApplyFunction(Expression exp)
  {
    return false;
  }
  



  public boolean isSimpleApplyFunction(Expression exp)
  {
    return false;
  }
  
  public void compileConstant(Object value, Target target)
  {
    if ((target instanceof IgnoreTarget))
      return;
    if (((value instanceof Values)) && ((target instanceof ConsumerTarget)))
    {
      Object[] values = ((Values)value).getValues();
      int len = values.length;
      for (int i = 0; i < len; i++)
      {
        compileConstant(values[i], ((ConsumerTarget)target).getSingleTarget());
      }
      
      return;
    }
    if ((target instanceof ConditionalTarget))
    {
      ConditionalTarget ctarg = (ConditionalTarget)target;
      getCode().emitGoto(getLanguage().isTrue(value) ? ifTrue : ifFalse);
      
      return;
    }
    if ((target instanceof StackTarget))
    {
      Type type = ((StackTarget)target).getType();
      if ((type instanceof gnu.kawa.reflect.LazyType))
        type = ((gnu.kawa.reflect.LazyType)type).getValueType();
      if ((type instanceof gnu.bytecode.PrimType))
      {
        try
        {
          String signature = type.getSignature();
          CodeAttr code = getCode();
          char sig1 = (signature == null) || (signature.length() != 1) ? ' ' : signature.charAt(0);
          
          if ((value instanceof Number))
          {
            Number num = (Number)value;
            switch (sig1)
            {
            case 'C': 
            case 'I': 
              code.emitPushInt(num.intValue());
              return;
            case 'S': 
              code.emitPushInt(num.shortValue());
              return;
            case 'B': 
              code.emitPushInt(num.byteValue());
              return;
            case 'J': 
              code.emitPushLong(num.longValue());
              return;
            case 'F': 
              code.emitPushFloat(num.floatValue());
              return;
            case 'D': 
              code.emitPushDouble(num.doubleValue());
              return;
            }
            
          }
          
          if ((type == LangPrimType.characterType) || (type == LangPrimType.characterOrEofType))
          {

            if ((value instanceof gnu.text.Char))
            {
              code.emitPushInt(((gnu.text.Char)value).intValue());
              return;
            }
            if ((value instanceof Character))
            {
              code.emitPushInt(((Character)value).charValue());
              return;
            }
            if ((value == gnu.lists.Sequence.eofValue) && (type == LangPrimType.characterOrEofType))
            {

              code.emitPushInt(-1);
              return;
            }
          }
          if (sig1 == 'C')
          {
            code.emitPushInt(((gnu.bytecode.PrimType)type).charValue(value));
            return;
          }
          if (sig1 == 'Z')
          {
            boolean val = getLanguage().isTrue(value);
            code.emitPushInt(val ? 1 : 0);
            return;
          }
        }
        catch (ClassCastException ex) {}
      }
      


      if ((type == typeClass) && ((value instanceof ClassType)))
      {
        loadClassRef((ClassType)value);
        return;
      }
      try
      {
        value = type.coerceFromObject(value);
      }
      catch (Exception ex)
      {
        StringBuffer sbuf = new StringBuffer();
        if (value == Values.empty) {
          sbuf.append("cannot convert void to ");
        }
        else {
          sbuf.append("cannot convert literal (of type ");
          if (value == null) {
            sbuf.append("<null>");
          } else
            sbuf.append(value.getClass().getName());
          sbuf.append(") to ");
        }
        sbuf.append(type);
        error('w', sbuf.toString());
      }
    }
    compileConstant(value);
    target.compileFromStack(this, value == null ? target.getType() : Type.make(value.getClass()));
  }
  


  public void emitPushBoolean(boolean value)
  {
    CodeAttr code = getCode();
    Object valObject = language.booleanObject(value);
    if (valObject == Boolean.TRUE) {
      code.emitGetStatic(trueConstant);
    } else if (valObject == Boolean.FALSE)
      code.emitGetStatic(falseConstant); else {
      compileConstant(valObject);
    }
  }
  


  public void emitCoerceToBoolean()
  {
    CodeAttr code = getCode();
    Label trueLabel = new Label(code);
    Label falseLabel = new Label(code);
    ConditionalTarget ctarget = new ConditionalTarget(trueLabel, falseLabel, getLanguage());
    
    ctarget.compileFromStack(this, Type.objectType);
    code.emitIfThen();
    trueLabel.define(code);
    code.emitPushInt(1);
    code.emitElse();
    falseLabel.define(code);
    code.emitPushInt(0);
    code.emitFi();
  }
  




  public Type asBooleanValue(ConditionalTarget target, Type stackType)
  {
    return stackType;
  }
  

  private void dumpInitializers(Initializer inits)
  {
    dumpingInitializers = true;
    for (Initializer init = Initializer.reverse(inits); 
        init != null; init = next)
      init.emit(this);
    dumpingInitializers = false;
  }
  

  static final java.util.Comparator<ClassType> classTypeComparator = new java.util.Comparator() {
    public int compare(ClassType arg0, ClassType arg1) {
      return arg0.getName().compareTo(arg1.getName());
    }
  };
  

  boolean classesArrayIsSorted;
  


  public ClassType findNamedClass(String name)
  {
    if ((classes == null) || (numClasses == 0)) {
      return null;
    }
    if (name.equals(classes[0].getName())) {
      return classes[0];
    }
    if (numClasses == 1) {
      return null;
    }
    if (!classesArrayIsSorted) {
      java.util.Arrays.sort(classes, 1, numClasses, classTypeComparator);
      classesArrayIsSorted = true;
    }
    
    ClassType nameType = new ClassType(name);
    int index = java.util.Arrays.binarySearch(classes, 1, numClasses, nameType, classTypeComparator);
    
    return index > -1 ? classes[index] : null;
  }
  
  public static String classPrefixDefault = "";
  
  public String classPrefix = classPrefixDefault;
  

  private static void putURLWords(String name, StringBuffer sbuf)
  {
    int dot = name.indexOf('.');
    if (dot > 0)
    {
      putURLWords(name.substring(dot + 1), sbuf);
      sbuf.append('.');
      name = name.substring(0, dot);
    }
    sbuf.append(name);
  }
  



  public static String mangleURI(String name)
  {
    boolean hasSlash = name.indexOf('/') >= 0;
    int len = name.length();
    if ((len > 6) && (name.startsWith("class:"))) {
      return name.substring(6);
    }
    if ((len > 5) && (name.charAt(4) == ':') && (name.substring(0, 4).equalsIgnoreCase("http")))
    {

      name = name.substring(5);
      len -= 5;
      hasSlash = true;
    }
    else if ((len > 4) && (name.charAt(3) == ':') && (name.substring(0, 3).equalsIgnoreCase("uri")))
    {

      name = name.substring(4);
      len -= 4;
    }
    int start = 0;
    StringBuffer sbuf = new StringBuffer();
    for (;;)
    {
      int slash = name.indexOf('/', start);
      int end = slash < 0 ? len : slash;
      boolean first = sbuf.length() == 0;
      if ((first) && (hasSlash))
      {

        String host = name.substring(start, end);
        if ((end - start > 4) && (host.startsWith("www."))) {
          host = host.substring(4);
        }
        putURLWords(host, sbuf);
      }
      else if (start != end)
      {
        if (!first)
          sbuf.append('.');
        if (end == len)
        {
          int dot = name.lastIndexOf('.', len);
          if ((dot > start + 1) && (!first))
          {

            int extLen = len - dot;
            if ((extLen <= 4) || ((extLen == 5) && (name.endsWith("html"))))
            {

              len -= extLen;
              end = len;
              name = name.substring(0, len);
            }
          }
        }
        sbuf.append(name.substring(start, end));
      }
      if (slash < 0)
        break;
      start = slash + 1;
    }
    return sbuf.toString();
  }
  




  public String generateClassName(String hint)
  {
    hint = Mangling.mangleClassName(hint);
    if (mainClass != null) {
      hint = mainClass.getName() + '$' + hint;
    } else if (classPrefix != null)
      hint = classPrefix + hint;
    if (findNamedClass(hint) == null)
      return hint;
    for (int i = 0;; i++)
    {
      String new_hint = hint + i;
      if (findNamedClass(new_hint) == null) {
        return new_hint;
      }
    }
  }
  
  public Compilation(Language language, SourceMessages messages, NameLookup lexical)
  {
    this.language = language;
    this.messages = messages;
    this.lexical = lexical;
  }
  
  public void outputClass(String directory) throws IOException
  {
    char dirSep = File.separatorChar;
    for (int iClass = 0; iClass < numClasses; iClass++)
    {
      ClassType clas = classes[iClass];
      String out_name = directory + clas.getName().replace('.', dirSep) + ".class";
      

      String parent = new File(out_name).getParent();
      if (parent != null)
        new File(parent).mkdirs();
      clas.writeToFile(out_name);
    }
    getMinfo().cleanupAfterCompilation();
  }
  
  public void cleanupAfterCompilation()
  {
    for (int iClass = 0; iClass < numClasses; iClass++)
      classes[iClass].cleanupAfterCompilation();
    classes = null;
    ModuleInfo minfo = getMinfo();
    className = mainClass.getName();
    minfo.setCompilation(null);
    
    if (exp != null)
      exp.body = null;
    mainLambda.body = null;
    mainLambda = null;
    if (!immediate) {
      litTable = null;
    }
  }
  
  public void compileToArchive(ModuleExp mexp, String fname) throws IOException
  {
    boolean makeJar = false;
    if (fname.endsWith(".zip")) {
      makeJar = false;
    } else if (fname.endsWith(".jar")) {
      makeJar = true;
    }
    else {
      fname = fname + ".zip";
      makeJar = false;
    }
    
    process(14);
    
    File zar_file = new File(fname);
    if (zar_file.exists())
      zar_file.delete();
    ZipOutputStream zout;
    ZipOutputStream zout;
    if (makeJar) {
      zout = new java.util.jar.JarOutputStream(new java.io.FileOutputStream(zar_file));
    }
    else {
      zout = new ZipOutputStream(new java.io.FileOutputStream(zar_file));
    }
    byte[][] classBytes = new byte[numClasses][];
    CRC32 zcrc = new CRC32();
    for (int iClass = 0; iClass < numClasses; iClass++)
    {
      ClassType clas = classes[iClass];
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
  

  public static boolean emitSourceDebugExtAttr = true;
  int localFieldIndex;
  
  private void registerClass(ClassType new_class) {
    if (classes == null) {
      classes = new ClassType[20];
    } else if (numClasses >= classes.length)
    {
      ClassType[] new_classes = new ClassType[2 * classes.length];
      System.arraycopy(classes, 0, new_classes, 0, numClasses);
      classes = new_classes;
    }
    new_class.addModifiers(new_class.isInterface() ? 1 : 33);
    
    if ((new_class == mainClass) && (numClasses > 0))
    {

      new_class = classes[0];
      classes[0] = mainClass;
    }
    classes[(numClasses++)] = new_class;
    classesArrayIsSorted = false;
  }
  
  public void addClass(ClassType new_class)
  {
    String fname = getModulefilename;
    if (fname != null)
    {
      if (emitSourceDebugExtAttr)
        new_class.setStratum(getLanguage().getName());
      new_class.setSourceFile(fname);
    }
    registerClass(new_class);
    new_class.setClassfileVersion(defaultClassFileVersion);
  }
  
  public boolean makeRunnable()
  {
    return (!generatingServlet()) && (!generatingApplet()) && (!getModule().staticInitRun()) && (!getModule().getFlag(8388608));
  }
  


  public void addMainClass(ModuleExp module)
  {
    mainClass = module.classFor(this);
    ClassType type = mainClass;
    ClassType[] interfaces = module.getInterfaces();
    if (interfaces != null)
      type.setInterfaces(interfaces);
    ClassType sup = module.getSuperType();
    if (sup == null)
    {
      if (generatingApplet()) {
        sup = typeApplet;
      } else if (generatingServlet()) {
        sup = typeServlet;
      } else if (module.getFlag(8388608)) {
        sup = Type.objectType;
      } else
        sup = getModuleType();
    }
    if (makeRunnable())
      type.addInterface(typeRunnable);
    if (!module.staticInitRun())
      type.addInterface(typeRunnableModule);
    type.setSuper(sup);
    
    compiledType = type;
    addClass(type);
  }
  
  public final Method getConstructor(LambdaExp lexp)
  {
    return getConstructor(lexp.getHeapFrameType(), lexp);
  }
  
  public static final Method getConstructor(ClassType clas, LambdaExp lexp)
  {
    Method meth = clas.getDeclaredMethod("<init>", 0);
    if (meth != null)
      return meth;
    Type[] args;
    if (((lexp instanceof ClassExp)) && (staticLinkField != null))
    {
      Type[] args = new Type[1];
      args[0] = staticLinkField.getType();
    }
    else {
      args = apply0args; }
    return clas.addMethod("<init>", 1, args, Type.voidType);
  }
  
  public final void generateConstructor(LambdaExp lexp)
  {
    generateConstructor(lexp.getHeapFrameType(), lexp);
  }
  
  public final void generateConstructor(ClassType clas, LambdaExp lexp)
  {
    Method save_method = method;
    Variable callContextSave = callContextVar;
    callContextVar = null;
    ClassType save_class = curClass;
    curClass = clas;
    Method constructor_method = getConstructor(clas, lexp);
    constructor = constructor_method;
    method = constructor_method;
    CodeAttr code = constructor_method.startCode();
    
    if (((lexp instanceof ClassExp)) && (staticLinkField != null))
    {
      code.emitPushThis();
      code.emitLoad(code.getCurrentScope().getVariable(1));
      code.emitPutField(staticLinkField);
    }
    ClassType superClass = clas.getSuperclass();
    ClassExp.invokeDefaultSuperConstructor(superClass, this, lexp);
    
    if ((curClass == mainClass) && (getMinfo() != null) && (getMinfosourcePath != null) && (!getModule().getFlag(8388608)))
    {




      code.emitPushThis();
      code.emitInvokeStatic(ClassType.make("gnu.expr.ModuleInfo").getDeclaredMethod("register", 1));
    }
    

    if ((lexp != null) && (initChain != null))
    {


      LambdaExp save = curLambda;
      curLambda = new LambdaExp();
      curLambda.closureEnv = code.getArg(0);
      curLambda.setOuter(save);
      Initializer init;
      while ((init = initChain) != null)
      {
        initChain = null;
        dumpInitializers(init);
      }
      curLambda = save;
    }
    
    if ((lexp instanceof ClassExp))
    {
      ClassExp cexp = (ClassExp)lexp;
      callInitMethods(cexp.getCompiledClassType(this), new ArrayList(10));
    }
    

    code.emitReturn();
    method = save_method;
    curClass = save_class;
    callContextVar = callContextSave;
  }
  





  void callInitMethods(ClassType clas, ArrayList<ClassType> seen)
  {
    if (clas == null) {
      return;
    }
    String name = clas.getName();
    if ("java.lang.Object".equals(name)) {
      return;
    }
    int i = seen.size(); do { i--; if (i < 0) break;
    } while (((ClassType)seen.get(i)).getName() != name);
    return;
    seen.add(clas);
    



    ClassType[] interfaces = clas.getInterfaces();
    if (interfaces != null)
    {
      int n = interfaces.length;
      for (int i = 0; i < n; i++) {
        callInitMethods(interfaces[i], seen);
      }
    }
    int clEnvArgs = 1;
    if (clas.isInterface())
    {
      if ((clas instanceof PairClassType)) {
        clas = instanceType;
      }
      else {
        try
        {
          clas = (ClassType)Type.make(Class.forName(clas.getName() + "$class"));

        }
        catch (Exception ex)
        {
          return;
        }
      }
    }
    else
      clEnvArgs = 0;
    Method meth = clas.getDeclaredMethod("$finit$", clEnvArgs);
    if (meth != null)
    {
      CodeAttr code = getCode();
      code.emitPushThis();
      code.emitInvoke(meth);
    }
  }
  
  public void generateMatchMethods(LambdaExp lexp)
  {
    int numApplyMethods = applyMethods == null ? 0 : applyMethods.size();
    
    if (numApplyMethods == 0)
      return;
    Method save_method = method;
    ClassType save_class = curClass;
    ClassType procType = typeModuleMethod;
    curClass = lexp.getHeapFrameType();
    if (!curClass.getSuperclass().isSubtype(typeModuleBody))
      curClass = moduleClass;
    CodeAttr code = null;
    for (int i = 0; i <= 5; i++)
    {
      boolean needThisMatch = false;
      SwitchState aswitch = null;
      String mname = null;
      Type[] matchArgs = null;
      int j = numApplyMethods; for (;;) { j--; if (j < 0)
          break;
        LambdaExp source = (LambdaExp)applyMethods.get(j);
        

        Method[] primMethods = primMethods;
        int numMethods = primMethods.length;
        boolean varArgs = (max_args < 0) || (max_args >= min_args + numMethods);
        
        int methodIndex;
        if (i < 5)
        {
          int methodIndex = i - min_args;
          if ((methodIndex < 0) || (methodIndex >= numMethods) || ((methodIndex == numMethods - 1) && (varArgs))) {
            continue;
          }
          numMethods = 1;
          varArgs = false;
        }
        else
        {
          methodIndex = 5 - min_args;
          if ((methodIndex > 0) && (numMethods <= methodIndex) && (!varArgs))
            continue;
          methodIndex = numMethods - 1;
        }
        if (!needThisMatch)
        {

          if (i < 5)
          {
            mname = "match" + i;
            matchArgs = new Type[i + 2];
            for (int k = i; k >= 0; k--)
              matchArgs[(k + 1)] = typeObject;
            matchArgs[(i + 1)] = typeCallContext;
          }
          else
          {
            mname = "matchN";
            matchArgs = new Type[3];
            matchArgs[1] = objArrayType;
            matchArgs[2] = typeCallContext;
          }
          matchArgs[0] = procType;
          method = curClass.addMethod(mname, matchArgs, Type.intType, 1);
          
          code = method.startCode();
          
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
        
        if (i < 5)
        {
          Declaration var = source.firstDecl();
          for (int k = 1; k <= i; k++)
          {
            code.emitLoad(ctxVar);
            code.emitLoad(code.getArg(k + 1));
            Type ptype = var.getType();
            if (ptype != Type.objectType)
            {
              StackTarget.forceLazyIfNeeded(this, Type.objectType, ptype);
              if ((ptype instanceof TypeValue))
              {
                Label trueLabel = new Label(code);
                Label falseLabel = new Label(code);
                ConditionalTarget ctarget = new ConditionalTarget(trueLabel, falseLabel, getLanguage());
                

                code.emitDup();
                ((TypeValue)ptype).emitIsInstance(null, this, ctarget);
                
                falseLabel.define(code);
                code.emitPushInt(0xFFF40000 | k);
                code.emitReturn();
                trueLabel.define(code);
              }
              else if (((ptype instanceof ClassType)) && (ptype != Type.objectType) && (ptype != Type.toStringType))
              {


                code.emitDup();
                ptype.emitIsInstance(code);
                code.emitIfIntEqZero();
                code.emitPushInt(0xFFF40000 | k);
                code.emitReturn();
                code.emitFi();
              }
            }
            code.emitPutField(typeCallContext.getField("value" + k));
            var = var.nextDecl();
          }
          
        }
        else
        {
          code.emitLoad(ctxVar);
          code.emitLoad(code.getArg(2));
          code.emitPutField(typeCallContext.getField("values"));
        }
        code.emitLoad(ctxVar);
        boolean usingCallContext = usingCallContext();
        if (usingCallContext) {
          code.emitLoad(code.getArg(0));
        } else
          code.emitLoad(code.getArg(1));
        code.emitPutField(procCallContextField);
        code.emitLoad(ctxVar);
        if (usingCallContext) {
          code.emitPushInt(source.getSelectorValue(this) + methodIndex);
        } else
          code.emitPushInt(i);
        code.emitPutField(pcCallContextField);
        code.emitPushInt(0);
        code.emitReturn();
      }
      if (needThisMatch)
      {
        aswitch.addDefault(code);
        int nargs = i > 4 ? 2 : i + 1;
        nargs++;
        for (int k = 0; k <= nargs; k++)
          code.emitLoad(code.getArg(k));
        Method defMethod = typeModuleBody.getDeclaredMethod(mname, matchArgs.length);
        
        code.emitInvokeSpecial(defMethod);
        code.emitReturn();
        aswitch.finish(code);
      }
    }
    method = save_method;
    curClass = save_class;
  }
  



  public void generateApplyMethodsWithContext(LambdaExp lexp)
  {
    int numApplyMethods = applyMethods == null ? 0 : applyMethods.size();
    
    if (numApplyMethods == 0)
      return;
    ClassType save_class = curClass;
    curClass = lexp.getHeapFrameType();
    if (!curClass.getSuperclass().isSubtype(typeModuleBody))
      curClass = moduleClass;
    ClassType procType = typeModuleMethod;
    Method save_method = method;
    CodeAttr code = null;
    Type[] applyArgs = { typeCallContext };
    

    method = curClass.addMethod("apply", applyArgs, Type.voidType, 1);
    

    code = method.startCode();
    Variable ctxVar = code.getArg(1);
    
    code.emitLoad(ctxVar);
    code.emitGetField(pcCallContextField);
    SwitchState aswitch = code.startSwitch();
    
    for (int j = 0; j < numApplyMethods; j++)
    {
      LambdaExp source = (LambdaExp)applyMethods.get(j);
      if (source.usingCallContext())
      {
        Method[] primMethods = primMethods;
        int numMethods = primMethods.length;
        
        for (int i = 0; i < numMethods; i++)
        {


          boolean varArgs = (i == numMethods - 1) && ((max_args < 0) || (max_args >= min_args + numMethods));
          


          int methodIndex = i;
          
          aswitch.addCase(source.getSelectorValue(this) + i, code);
          
          SourceLocator saveLoc1 = messages.swapSourceLocator(source);
          int line = source.getLineNumber();
          if (line > 0) {
            code.putLineNumber(source.getFileName(), line);
          }
          Method primMethod = primMethods[methodIndex];
          Type[] primArgTypes = primMethod.getParameterTypes();
          int singleArgs = min_args + methodIndex;
          Variable counter = null;
          int pendingIfEnds = 0;
          
          if ((i > 4) && (numMethods > 1))
          {
            counter = code.addLocal(Type.intType);
            code.emitLoad(ctxVar);
            code.emitInvoke(typeCallContext.getDeclaredMethod("getArgCount", 0));
            if (min_args != 0)
            {
              code.emitPushInt(min_args);
              code.emitSub(Type.intType);
            }
            code.emitStore(counter);
          }
          
          int needsThis = primMethod.getStaticFlag() ? 0 : 1;
          int explicitFrameArg = singleArgs + (varArgs ? 2 : 1) < primArgTypes.length ? 1 : 0;
          
          if (needsThis + explicitFrameArg > 0)
          {
            code.emitPushThis();
            if ((curClass == moduleClass) && (mainClass != moduleClass)) {
              code.emitGetField(moduleInstanceMainField);
            }
          }
          Declaration var = source.firstDecl();
          if ((var != null) && (var.isThisParameter()))
            var = var.nextDecl();
          for (int k = 0; k < singleArgs; k++)
          {
            if ((counter != null) && (k >= min_args))
            {
              code.emitLoad(counter);
              code.emitIfIntLEqZero();
              code.emitLoad(ctxVar);
              code.emitInvoke(primMethods[(k - min_args)]);
              code.emitElse();
              pendingIfEnds++;
              code.emitInc(counter, (short)-1);
            }
            
            code.emitLoad(ctxVar);
            if ((k <= 4) && (!varArgs) && (max_args <= 4)) {
              code.emitGetField(typeCallContext.getDeclaredField("value" + (k + 1)));
            }
            else
            {
              code.emitGetField(typeCallContext.getDeclaredField("values"));
              
              code.emitPushInt(k);
              code.emitArrayLoad(Type.objectType);
            }
            Type ptype = var.getType();
            if (ptype != Type.objectType)
            {
              SourceLocator saveLoc2 = messages.swapSourceLocator(var);
              CheckedTarget.emitCheckedCoerce(this, source, k + 1, Type.objectType, ptype, null);
              

              messages.swapSourceLocator(saveLoc2);
            }
            var = var.nextDecl();
          }
          
          if (varArgs)
          {
            Type lastArgType = primArgTypes[(explicitFrameArg + singleArgs)];
            if ((lastArgType instanceof ArrayType)) {
              varArgsToArray(source, singleArgs, counter, lastArgType, ctxVar);
            } else if ("gnu.lists.LList".equals(lastArgType.getName()))
            {

              code.emitLoad(ctxVar);
              code.emitPushInt(singleArgs);
              code.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getRestArgsList", 1));
            }
            else if (lastArgType == typeCallContext) {
              code.emitLoad(ctxVar);
            } else {
              throw new RuntimeException("unsupported #!rest type:" + lastArgType);
            } }
          code.emitLoad(ctxVar);
          code.emitInvoke(primMethod);
          for (;;) { pendingIfEnds--; if (pendingIfEnds < 0) break;
            code.emitFi(); }
          if (!usingCallContext()) {
            Target.pushObject.compileFromStack(this, source.getReturnType());
          }
          messages.swapSourceLocator(saveLoc1);
          code.emitReturn();
        }
      } }
    aswitch.addDefault(code);
    Method errMethod = typeModuleMethod.getDeclaredMethod("applyError", 0);
    code.emitInvokeStatic(errMethod);
    code.emitReturn();
    aswitch.finish(code);
    method = save_method;
    curClass = save_class;
  }
  




  public void generateApplyMethodsWithoutContext(LambdaExp lexp)
  {
    int numApplyMethods = applyMethods == null ? 0 : applyMethods.size();
    
    if (numApplyMethods == 0)
      return;
    ClassType save_class = curClass;
    curClass = lexp.getHeapFrameType();
    ClassType procType = typeModuleMethod;
    if (!curClass.getSuperclass().isSubtype(typeModuleBody))
      curClass = moduleClass;
    Method save_method = method;
    CodeAttr code = null;
    for (int i = usingCallContext() ? 5 : 0; i < 6; i++)
    {


      boolean needThisApply = false;
      SwitchState aswitch = null;
      String mname = null;
      Type[] applyArgs = null;
      
      for (int j = 0; j < numApplyMethods; j++)
      {
        LambdaExp source = (LambdaExp)applyMethods.get(j);
        if (!source.usingCallContext())
        {


          Method[] primMethods = primMethods;
          int numMethods = primMethods.length;
          boolean varArgs = (max_args < 0) || (max_args >= min_args + numMethods);
          

          boolean skipThisProc = false;
          int methodIndex; if (i < 5)
          {
            int methodIndex = i - min_args;
            if ((methodIndex < 0) || (methodIndex >= numMethods) || ((methodIndex == numMethods - 1) && (varArgs)))
            {
              skipThisProc = true; }
            numMethods = 1;
            varArgs = false;
          }
          else
          {
            methodIndex = 5 - min_args;
            if ((methodIndex > 0) && (numMethods <= methodIndex) && (!varArgs))
              skipThisProc = true;
            methodIndex = numMethods - 1;
          }
          if (!skipThisProc)
          {
            if (!needThisApply)
            {

              if (i < 5)
              {
                mname = "apply" + i;
                applyArgs = new Type[i + 1];
                for (int k = i; k > 0; k--) {
                  applyArgs[k] = typeObject;
                }
              }
              else {
                mname = "applyN";
                applyArgs = new Type[2];
                applyArgs[1] = objArrayType;
              }
              applyArgs[0] = procType;
              method = curClass.addMethod(mname, applyArgs, usingCallContext() ? Type.voidType : Type.objectType, 1);
              

              code = method.startCode();
              
              code.emitLoad(code.getArg(1));
              code.emitGetField(procType.getField("selector"));
              aswitch = code.startSwitch();
              
              needThisApply = true;
            }
            
            aswitch.addCase(source.getSelectorValue(this), code);
            
            SourceLocator saveLoc1 = messages.swapSourceLocator(source);
            int line = source.getLineNumber();
            if (line > 0) {
              code.putLineNumber(source.getFileName(), line);
            }
            Method primMethod = primMethods[methodIndex];
            Type[] primArgTypes = primMethod.getParameterTypes();
            int singleArgs = min_args + methodIndex;
            Variable counter = null;
            int pendingIfEnds = 0;
            
            if ((i > 4) && (numMethods > 1))
            {
              counter = code.addLocal(Type.intType);
              code.emitLoad(code.getArg(2));
              code.emitArrayLength();
              if (min_args != 0)
              {
                code.emitPushInt(min_args);
                code.emitSub(Type.intType);
              }
              code.emitStore(counter);
            }
            
            int needsThis = primMethod.getStaticFlag() ? 0 : 1;
            int explicitFrameArg = singleArgs + (varArgs ? 1 : 0) < primArgTypes.length ? 1 : 0;
            
            if (needsThis + explicitFrameArg > 0)
            {
              code.emitPushThis();
              if ((curClass == moduleClass) && (mainClass != moduleClass)) {
                code.emitGetField(moduleInstanceMainField);
              }
            }
            Declaration var = source.firstDecl();
            if ((var != null) && (var.isThisParameter()))
              var = var.nextDecl();
            for (int k = 0; k < singleArgs; k++)
            {
              if ((counter != null) && (k >= min_args))
              {
                code.emitLoad(counter);
                code.emitIfIntLEqZero();
                code.emitInvoke(primMethods[(k - min_args)]);
                code.emitElse();
                pendingIfEnds++;
                code.emitInc(counter, (short)-1);
              }
              
              Variable pvar = null;
              if (i <= 4)
              {
                pvar = code.getArg(k + 2);
                code.emitLoad(pvar);

              }
              else
              {
                code.emitLoad(code.getArg(2));
                code.emitPushInt(k);
                code.emitArrayLoad(Type.objectType);
              }
              Type ptype = var.getType();
              if (ptype != Type.objectType)
              {
                SourceLocator saveLoc2 = messages.swapSourceLocator(var);
                CheckedTarget.emitCheckedCoerce(this, source, k + 1, Type.objectType, ptype, pvar);
                

                messages.swapSourceLocator(saveLoc2);
              }
              var = var.nextDecl();
            }
            
            if (varArgs)
            {
              Type lastArgType = primArgTypes[(explicitFrameArg + singleArgs)];
              if ((lastArgType instanceof ArrayType)) {
                varArgsToArray(source, singleArgs, counter, lastArgType, null);
              } else if ("gnu.lists.LList".equals(lastArgType.getName()))
              {

                code.emitLoad(code.getArg(2));
                code.emitPushInt(singleArgs);
                code.emitInvokeStatic(makeListMethod);
              }
              else if (lastArgType == typeCallContext) {
                code.emitLoad(code.getArg(2));
              } else {
                throw new RuntimeException("unsupported #!rest type:" + lastArgType);
              } }
            code.emitInvoke(primMethod);
            for (;;) { pendingIfEnds--; if (pendingIfEnds < 0) break;
              code.emitFi(); }
            if (!usingCallContext()) {
              Target.pushObject.compileFromStack(this, source.getReturnType());
            }
            messages.swapSourceLocator(saveLoc1);
            code.emitReturn();
          } } }
      if (needThisApply)
      {
        aswitch.addDefault(code);
        if (usingCallContext())
        {
          Method errMethod = typeModuleMethod.getDeclaredMethod("applyError", 0);
          
          code.emitInvokeStatic(errMethod);
        }
        else
        {
          int nargs = i > 4 ? 2 : i + 1;
          nargs++;
          for (int k = 0; k < nargs; k++)
            code.emitLoad(code.getArg(k));
          code.emitInvokeSpecial(typeModuleBody.getDeclaredMethod(mname, applyArgs));
        }
        code.emitReturn();
        aswitch.finish(code);
      }
    }
    method = save_method;
    curClass = save_class;
  }
  




  private void varArgsToArray(LambdaExp source, int singleArgs, Variable counter, Type lastArgType, Variable ctxVar)
  {
    CodeAttr code = getCode();
    Type elType = ((ArrayType)lastArgType).getComponentType();
    boolean mustConvert = !"java.lang.Object".equals(elType.getName());
    if ((ctxVar != null) && (!mustConvert))
    {
      code.emitLoad(ctxVar);
      code.emitPushInt(singleArgs);
      code.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getRestArgsArray", 1));
    }
    else if ((singleArgs == 0) && (!mustConvert)) {
      code.emitLoad(code.getArg(2));
    }
    else {
      code.pushScope();
      if (counter == null)
      {
        counter = code.addLocal(Type.intType);
        if (ctxVar != null)
        {
          code.emitLoad(ctxVar);
          code.emitInvoke(typeCallContext.getDeclaredMethod("getArgCount", 0));
        }
        else
        {
          code.emitLoad(code.getArg(2));
          code.emitArrayLength();
        }
        if (singleArgs != 0)
        {
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
      } else
        code.emitLoad(code.getArg(2));
      code.emitLoad(counter);
      if (singleArgs != 0)
      {
        code.emitPushInt(singleArgs);
        code.emitAdd(Type.intType);
      }
      if (ctxVar != null) {
        code.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getArgAsObject", 1));
      } else
        code.emitArrayLoad(Type.objectType);
      if (mustConvert)
      {
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
  
  private Method startClassInit()
  {
    method = curClass.addMethod("<clinit>", apply0args, Type.voidType, 9);
    

    CodeAttr code = method.startCode();
    
    if ((generateMainMethod()) || (generatingApplet()) || (generatingServlet()))
    {
      ClassType languageType = (ClassType)Type.make(getLanguage().getClass());
      
      Method registerMethod = languageType.getDeclaredMethod("registerEnvironment", 0);
      
      if (registerMethod != null)
        code.emitInvokeStatic(registerMethod);
    }
    return method;
  }
  





  public void process(int wantedState)
  {
    Compilation saveCompilation = setSaveCurrent(this);
    try
    {
      ModuleExp mexp = getModule();
      if ((wantedState >= 4) && (getState() < 3))
      {
        setState(3);
        language.parse(this, 0);
        mexp.classFor(this);
        if (lexer != null)
          lexer.close();
        lexer = null;
        setState(4);
        if (pendingImports != null)
          return;
      }
      if ((wantedState >= 6) && (getState() < 6))
      {
        language.resolve(this);
        




        addMainClass(mexp);
        if ((generateMainMethod()) && (mexp.staticInitRun())) {
          error('e', "a static init-run module cannot have a 'main' method");
        }
        setState(6);
      }
      

      if ((!explicit) && (!immediate) && (getMinfo().checkCurrent(ModuleManager.getInstance(), System.currentTimeMillis())))
      {

        getMinfo().cleanupAfterCompilation();
        setState(16);
      }
      
      if ((wantedState >= 8) && (getState() < 8))
      {
        if (debugPrintExpr) {
          OutPort dout = OutPort.errDefault();
          dout.println("[Module:" + mexp.getName());
          mexp.print(dout);
          dout.println(']');
          dout.flush();
        }
        PushApply.pushApply(mexp, this);
        setState(8);
      }
      
      if ((wantedState >= 10) && (getState() < 10))
      {
        InlineCalls.inlineCalls(mexp, this);
        if (enableANF)
          ANormalize.aNormalize(mexp, this);
        if (debugPrintANF) {
          options.set("warn-void-used", Boolean.FALSE);
          OutPort dout = OutPort.errDefault();
          dout.println("[Normalized module: " + mexp.getName() + " to " + mainClass.getName() + ":");
          
          mexp.print(dout);
          dout.println(']');
          dout.flush();
        }
        ChainLambdas.chainLambdas(mexp, this);
        FindTailCalls.findTailCalls(mexp, this);
        setState(10);
      }
      
      if ((wantedState >= 12) && (getState() < 12))
      {
        litTable = new LitTable(this);
        mexp.setCanRead(true);
        FindCapturedVars.findCapturedVars(mexp, this);
        mexp.allocFields(this);
        mexp.allocChildMethods(this);
        setState(12);
      }
      if ((wantedState >= 14) && (messages.seenErrors()))
        setState(100);
      if ((wantedState >= 14) && (getState() < 14))
      {
        if (mexp.subModulesOnly())
        {
          setState(wantedState < 16 ? 14 : 16);
        }
        else
        {
          if (immediate)
          {
            ClassLoader parentLoader = ObjectType.getContextClassLoader();
            loader = new ArrayClassLoader(parentLoader);
          }
          generateBytecode();
          setState(messages.seenErrors() ? 100 : 14);
        }
      }
      if ((wantedState >= 16) && (getState() < 16) && (!mexp.subModulesOnly()))
      {

        outputClass(ModuleManager.getInstance().getCompilationDirectory());
        setState(16);
      }
    }
    catch (SyntaxException ex)
    {
      setState(100);
      if (ex.getMessages() != getMessages()) {
        throw new RuntimeException("confussing syntax error: " + ex);
      }
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
      error('f', "caught " + ex);
      setState(100);
    }
    finally
    {
      restoreCurrent(saveCompilation);
    }
  }
  



  void generateBytecode()
  {
    ModuleExp module = getModule();
    if (debugPrintFinalExpr)
    {
      OutPort dout = OutPort.errDefault();
      dout.println("[Compiling final " + module.getName() + " to " + mainClass.getName() + ":");
      
      module.print(dout);
      dout.println(']');
      dout.flush();
    }
    
    ClassType neededSuper = getModuleType();
    if ((mainClass.getSuperclass().isSubtype(neededSuper)) && (!module.getFlag(8388608)))
    {
      moduleClass = mainClass;
    }
    else {
      moduleClass = new ClassType(generateClassName("frame"));
      moduleClass.setSuper(neededSuper);
      addClass(moduleClass);
      generateConstructor(moduleClass, null);
    }
    
    curClass = compiledType;
    
    LambdaExp saveLambda = curLambda;
    curLambda = module;
    
    String runName = "run";
    int runFlags = 17;
    Type[] arg_types; if (module.staticInitRun())
    {
      Type[] arg_types = Type.typeArray0;
      runName = "$runBody$";
      runFlags = 10;
    }
    else if (module.isHandlingTailCalls())
    {
      int arg_count = 1;
      Type[] arg_types = new Type[1];
      arg_types[0] = typeCallContext;
    }
    else if ((min_args != max_args) || (min_args > 4))
    {
      int arg_count = 1;
      Type[] arg_types = new Type[1];
      arg_types[0] = new ArrayType(typeObject);
    }
    else
    {
      int arg_count = min_args;
      arg_types = new Type[arg_count];
      int i = arg_count; for (;;) { i--; if (i < 0) break;
        arg_types[i] = typeObject;
      }
    }
    
    Variable heapFrame = heapFrame;
    boolean staticModule = module.isStatic();
    
    Method apply_method = curClass.addMethod(runName, arg_types, Type.voidType, runFlags);
    
    method = apply_method;
    



    method.initCode();
    CodeAttr code = getCode();
    

    thisDecl = (method.getStaticFlag() ? null : module.declareThis(compiledType));
    closureEnv = thisVariable;
    heapFrame = (module.isStatic() ? null : thisVariable);
    module.allocChildClasses(this);
    
    if ((!module.staticInitRun()) && ((module.isHandlingTailCalls()) || (usingCPStyle())))
    {

      callContextVar = new Variable("$ctx", typeCallContext);
      module.getVarScope().addVariableAfter(thisDecl, callContextVar);
      callContextVar.setParameter(true);
    }
    
    int line = module.getLineNumber();
    if (line > 0) {
      code.putLineNumber(module.getFileName(), line);
    }
    module.allocParameters(this);
    module.enterFunction(this);
    if (usingCPStyle())
    {
      loadCallContext();
      code.emitGetField(pcCallContextField);
      fswitch = code.startSwitch();
      fswitch.addCase(0, code);
    }
    
    module.compileBody(this);
    module.compileEnd(this);
    
    Label startLiterals = null;
    Label afterLiterals = null;
    Method initMethod = null;
    
    if (curClass == mainClass)
    {
      Method save_method = method;
      Variable callContextSave = callContextVar;
      callContextVar = null;
      
      initMethod = startClassInit();
      clinitMethod = initMethod;
      code = getCode();
      
      startLiterals = new Label(code);
      afterLiterals = new Label(code);
      code.fixupChain(afterLiterals, startLiterals);
      
      if (staticModule)
      {
        if (!module.getFlag(8388608)) {
          generateConstructor(module);
        }
        code.emitNew(moduleClass);
        code.emitDup(moduleClass);
        code.emitInvokeSpecial(moduleClass.constructor);
        




        moduleInstanceMainField = moduleClass.addField("$instance", moduleClass, 9);
        

        code.emitPutStatic(moduleInstanceMainField);
      }
      Initializer init;
      while ((init = clinitChain) != null)
      {
        clinitChain = null;
        dumpInitializers(init);
      }
      
      if (module.staticInitRun()) {
        code.emitInvoke(apply_method);
      }
      code.emitReturn();
      
      if ((moduleClass != mainClass) && (!staticModule) && (curClass.getSuperclass().getDeclaredMethod("run", 0) == null))
      {


        method = curClass.addMethod("run", 1, Type.typeArray0, Type.voidType);
        
        code = method.startCode();
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
      
      method = save_method;
      callContextVar = callContextSave;
    }
    
    module.generateApplyMethods(this);
    
    curLambda = saveLambda;
    
    heapFrame = heapFrame;
    if (usingCPStyle())
    {
      code = getCode();
      fswitch.finish(code);
    }
    
    if ((startLiterals != null) || (callContextVar != null))
    {
      method = initMethod;
      code = getCode();
      
      Label endLiterals = new Label(code);
      code.fixupChain(startLiterals, endLiterals);
      
      if (callContextVarForInit != null)
      {
        code.emitInvokeStatic(getCallContextInstanceMethod);
        code.emitStore(callContextVarForInit);
      }
      
      try
      {
        if (immediate)
        {
          code.emitPushInt(registerForImmediateLiterals(this));
          code.emitInvokeStatic(ClassType.make("gnu.expr.Compilation").getDeclaredMethod("setupLiterals", 1));
        }
        else
        {
          litTable.emit();
        }
      }
      catch (Exception ex) {
        error('e', "Literals: Internal error:" + ex);
      }
      code.fixupChain(endLiterals, afterLiterals);
    }
    
    if ((generateMainMethod()) && (curClass == mainClass))
    {
      Type[] args = { new ArrayType(javaStringType) };
      method = curClass.addMethod("main", 9, args, Type.voidType);
      

      code = method.startCode();
      
      if (kawa.Shell.defaultFormatName != null)
      {
        code.emitPushString(kawa.Shell.defaultFormatName);
        code.emitInvokeStatic(ClassType.make("kawa.Shell").getDeclaredMethod("setDefaultFormat", 1));
      }
      
      code.emitLoad(code.getArg(0));
      code.emitInvokeStatic(ClassType.make("gnu.expr.ApplicationMainSupport").getDeclaredMethod("processArgs", 1));
      
      if (moduleInstanceMainField != null) {
        code.emitGetStatic(moduleInstanceMainField);
      }
      else {
        code.emitNew(curClass);
        code.emitDup(curClass);
        code.emitInvokeSpecial(curClass.constructor);
      }
      Method runAsMainMethod = null;
      ClassType superClass = curClass.getSuperclass();
      if (superClass != typeModuleBody)
        runAsMainMethod = superClass.getDeclaredMethod("runAsMain", 0);
      if (runAsMainMethod == null)
        runAsMainMethod = typeModuleBody.getDeclaredMethod("runAsMain", 1);
      code.emitInvoke(runAsMainMethod);
      code.emitReturn();
    }
    
    String uri;
    if ((getMinfo() != null) && ((uri = getMinfo().getNamespaceUri()) != null))
    {


      ModuleManager manager = ModuleManager.getInstance();
      String mainPrefix = mainClass.getName();
      int dot = mainPrefix.lastIndexOf('.');
      if (dot < 0)
      {
        mainPrefix = "";
      }
      else
      {
        String mainPackage = mainPrefix.substring(0, dot);
        try
        {
          manager.loadPackageInfo(mainPackage);


        }
        catch (ClassNotFoundException ex) {}catch (Exception ex)
        {


          error('e', "error loading map for " + mainPackage + " - " + ex);
        }
        mainPrefix = mainPrefix.substring(0, dot + 1);
      }
      ClassType mapClass = new ClassType(mainPrefix + "$ModulesMap$");
      ClassType typeModuleSet = ClassType.make("gnu.expr.ModuleSet");
      mapClass.setSuper(typeModuleSet);
      registerClass(mapClass);
      
      method = mapClass.addMethod("<init>", 1, apply0args, Type.voidType);
      
      Method superConstructor = typeModuleSet.addMethod("<init>", 1, apply0args, Type.voidType);
      

      code = method.startCode();
      code.emitPushThis();
      code.emitInvokeSpecial(superConstructor);
      code.emitReturn();
      
      ClassType typeModuleManager = ClassType.make("gnu.expr.ModuleManager");
      Type[] margs = { typeModuleManager };
      method = mapClass.addMethod("register", margs, Type.voidType, 1);
      
      code = method.startCode();
      Method reg = typeModuleManager.getDeclaredMethod("register", 3);
      
      int i = numModules; for (;;) { i--; if (i < 0)
          break;
        ModuleInfo mi = modules[i];
        String miClassName = mi.getClassName();
        if ((miClassName != null) && (miClassName.startsWith(mainPrefix)))
        {

          String moduleSource = sourcePath;
          String moduleUri = mi.getNamespaceUri();
          code.emitLoad(code.getArg(1));
          compileConstant(miClassName);
          if (!Path.valueOf(moduleSource).isAbsolute())
          {

            try
            {

              String path = Path.toURL(manager.getCompilationDirectory()) + mainPrefix.replace('.', '/');
              
              int plen = path.length();
              if ((plen > 0) && (path.charAt(plen - 1) != '/'))
                path = path + '/';
              String sourcePath = Path.toURL(mi.getSourceAbsPathname()).toString();
              
              moduleSource = Path.relativize(sourcePath, path);
            }
            catch (Exception ex)
            {
              throw new gnu.mapping.WrappedException("exception while fixing up '" + moduleSource + '\'', ex);
            }
          }
          
          compileConstant(moduleSource);
          compileConstant(moduleUri);
          code.emitInvokeVirtual(reg);
        } }
      code.emitReturn();
    }
  }
  

  public gnu.bytecode.Field allocLocalField(Type type, String name)
  {
    if (name == null)
      name = "tmp_" + ++localFieldIndex;
    gnu.bytecode.Field field = curClass.addField(name, type, 0);
    return field;
  }
  





  public final void loadCallContext()
  {
    CodeAttr code = getCode();
    if ((callContextVar != null) && (!callContextVar.dead())) {
      code.emitLoad(callContextVar);





    }
    else if (method == clinitMethod)
    {

      callContextVar = new Variable("$ctx", typeCallContext);
      

      callContextVar.reserveLocal(code.getMaxLocals(), code);
      code.emitLoad(callContextVar);
      callContextVarForInit = callContextVar;
    }
    else
    {
      code.emitInvokeStatic(getCallContextInstanceMethod);
      code.emitDup();
      callContextVar = new Variable("$ctx", typeCallContext);
      code.getCurrentScope().addVariable(code, callContextVar);
      code.emitStore(callContextVar);
    }
  }
  


  Variable callContextVar;
  

  Variable callContextVarForInit;
  
  public Expression parse(Object input)
  {
    throw new Error("unimeplemented parse");
  }
  

  public Language getLanguage() { return language; }
  
  public LambdaExp currentLambda() { return current_scope.currentLambda(); }
  
  public final ModuleExp getModule() { return mainLambda; }
  public void setModule(ModuleExp mexp) { mainLambda = mexp; }
  
  public boolean isStatic() { return mainLambda.isStatic(); }
  
  public boolean isInteractive() {
    return (mainLambda != null) && (mainLambda.getFlag(4194304));
  }
  
  public ModuleExp currentModule() {
    return current_scope.currentModule();
  }
  



  public void mustCompileHere()
  {
    if ((!mustCompile) && (!ModuleExp.compilerAvailable()))
      error('e', "this expression must be compiled, but compiler is unavailable");
    mustCompile = true;
  }
  
  public ScopeExp currentScope() { return current_scope; }
  



  public void setCurrentScope(ScopeExp scope)
  {
    int scope_nesting = ScopeExp.nesting(scope);
    int current_nesting = ScopeExp.nesting(current_scope);
    while (current_nesting > scope_nesting)
    {
      pop(current_scope);
      current_nesting--;
    }
    ScopeExp sc = scope;
    while (scope_nesting > current_nesting)
    {
      sc = sc.getOuter();
      scope_nesting--;
    }
    while (sc != current_scope)
    {
      pop(current_scope);
      sc = sc.getOuter();
    }
    pushChain(scope, sc);
  }
  
  public ScopeExp setPushCurrentScope(ScopeExp scope) {
    ScopeExp old = currentScope();
    lexical.pushSaveTopLevelRedefs();
    setCurrentScope(scope);
    return old;
  }
  
  public void setPopCurrentScope(ScopeExp old) {
    setCurrentScope(old);
    lexical.popSaveTopLevelRedefs();
  }
  
  void pushChain(ScopeExp scope, ScopeExp limit)
  {
    if (scope != limit)
    {
      pushChain(scope.getOuter(), limit);
      pushScope(scope);
      lexical.push(scope);
    }
  }
  
  public ModuleExp pushNewModule(Lexer lexer)
  {
    this.lexer = lexer;
    String filename = lexer == null ? null : lexer.getName();
    ModuleExp module = new ModuleExp();
    if (filename != null)
      module.setFile(filename);
    if ((generatingApplet()) || (generatingServlet()))
      module.setFlag(262144);
    mainLambda = module;
    if (immediate)
    {
      module.setFlag(2097152);
      ModuleInfo minfo = new ModuleInfo();
      minfo.setCompilation(this);
    }
    push(module);
    return module;
  }
  
  public void push(ScopeExp scope)
  {
    pushScope(scope);
    lexical.push(scope);
  }
  
  public final void pushScope(ScopeExp scope)
  {
    if ((!mustCompile) && ((scope.mustCompile()) || ((ModuleExp.compilerAvailable()) && ((scope instanceof LambdaExp)) && (!(scope instanceof ModuleExp)))))
    {





      mustCompileHere(); }
    scope.setOuter(current_scope);
    current_scope = scope;
  }
  
  public void pop(ScopeExp scope)
  {
    lexical.pop(scope);
    current_scope = scope.getOuter();
  }
  
  public final void pop()
  {
    pop(current_scope);
  }
  
  public void push(Declaration decl)
  {
    lexical.push(decl);
  }
  
  public Declaration lookup(Object name, int namespace)
  {
    return lexical.lookup(name, namespace);
  }
  





  public void usedClass(Type type)
  {
    while ((type instanceof ArrayType))
      type = ((ArrayType)type).getComponentType();
    if ((immediate) && ((type instanceof ClassType))) {
      ClassType cl = (ClassType)type;
      for (;;) {
        loader.addClass(cl);
        ClassType enc = cl.getDeclaringClass();
        if (enc == null)
          break;
        cl = enc;
      }
    }
  }
  
  public void setModuleName(String name)
  {
    getModule().setName(name);
  }
  
  public void setInteractiveName()
  {
    setModuleName(ModuleManager.getInstance().getNewInteractiveName());
  }
  
  public void setEvalName()
  {
    setModuleName(ModuleManager.getInstance().getNewEvalName());
  }
  
  public SourceMessages getMessages() { return messages; }
  
  public void setMessages(SourceMessages messages) { this.messages = messages; }
  
  public void error(char severity, String message, SourceLocator location)
  {
    String file = location.getFileName();
    int line = location.getLineNumber();
    int column = location.getColumnNumber();
    if ((file == null) || (line <= 0))
    {
      file = getFileName();
      line = getLineNumber();
      column = getColumnNumber();
    }
    
    if ((severity == 'w') && (warnAsError()))
      severity = 'e';
    messages.error(severity, file, line, column, message);
  }
  
  public void error(char severity, String message)
  {
    if ((severity == 'w') && (warnAsError())) {
      severity = 'e';
    }
    messages.error(severity, this, message);
  }
  
  public void error(char severity, Declaration decl, String msg1, String msg2)
  {
    error(severity, msg1 + decl.getName() + msg2, null, decl);
  }
  

  public void error(char severity, String message, String code, SourceLocator decl)
  {
    if ((severity == 'w') && (warnAsError())) {
      severity = 'e';
    }
    String filename = getFileName();
    int line = getLineNumber();
    int column = getColumnNumber();
    int decl_line = decl.getLineNumber();
    if (decl_line > 0)
    {
      filename = decl.getFileName();
      line = decl_line;
      column = decl.getColumnNumber();
    }
    messages.error(severity, filename, line, column, message, code);
  }
  





  public ErrorExp syntaxError(String message)
  {
    error('e', message);
    return new ErrorExp(message);
  }
  
  public final int getLineNumber() { return messages.getLineNumber(); }
  public final int getColumnNumber() { return messages.getColumnNumber(); }
  public final String getFileName() { return messages.getFileName(); }
  public String getPublicId() { return messages.getPublicId(); }
  public String getSystemId() { return messages.getSystemId(); }
  public boolean isStableSourceLocation() { return false; }
  
  public void setFile(String filename) { messages.setFile(filename); }
  public void setLine(int line) { messages.setLine(line); }
  public void setColumn(int column) { messages.setColumn(column); }
  
  public final void setLine(Expression position) { messages.setLocation(position); }
  
  public void setLine(Object location) {
    if ((location instanceof SourceLocator))
      messages.setLocation((SourceLocator)location);
  }
  
  public final void setLocation(SourceLocator position) { messages.setLocation(position); }
  
  public void setLine(String filename, int line, int column)
  {
    messages.setLine(filename, line, column);
  }
  




  public Path getSourceAbsPath()
  {
    String currentFileName = getFileName();
    if (currentFileName != null) {
      ModuleInfo info = getMinfo();
      

      if ((info != null) && (info.getSourceAbsPath() != null)) {
        return Path.valueOf(currentFileName).getAbsolute();
      }
    }
    return null;
  }
  



  public void letStart()
  {
    pushScope(new LetExp());
  }
  
  public Declaration letVariable(Object name, Type type, Expression init)
  {
    Declaration decl = new Declaration(name, type);
    letVariable(decl, init);
    return decl;
  }
  
  public void letVariable(Declaration decl, Expression init)
  {
    LetExp let = (LetExp)current_scope;
    let.add(decl);
    decl.setInitValue(init);
  }
  
  public void letEnter()
  {
    LetExp let = (LetExp)current_scope;
    
    let.setFlag(1);
    for (Declaration decl = let.firstDecl(); 
        decl != null; decl = decl.nextDecl())
    {
      Expression init = decl.getInitValue();
      if (init != QuoteExp.undefined_exp)
        decl.noteValueFromLet(let);
    }
    lexical.push(let);
  }
  
  public LetExp letDone(Expression body)
  {
    LetExp let = (LetExp)current_scope;
    
    if (!let.getFlag(1))
      letEnter();
    let.setFlag(false, 1);
    body = body;
    pop(let);
    return let;
  }
  
  private void checkLoop() {
    if (((LambdaExp)current_scope).getName() != "%do%loop") {
      throw new Error("internal error - bad loop state");
    }
  }
  

  public LambdaExp loopStart()
  {
    if (exprStack == null)
      exprStack = new Stack();
    LambdaExp loopLambda = new LambdaExp();
    LetExp let = new LetExp();
    String fname = "%do%loop";
    Declaration fdecl = let.addDeclaration(fname);
    fdecl.setInitValue(loopLambda);
    fdecl.noteValueFromLet(let);
    loopLambda.setName(fname);
    let.setOuter(current_scope);
    loopLambda.setOuter(let);
    current_scope = loopLambda;
    return loopLambda;
  }
  
  public Declaration loopVariable(Object name, Type type, Expression init)
  {
    checkLoop();
    LambdaExp loopLambda = (LambdaExp)current_scope;
    Declaration decl = loopLambda.addDeclaration(name, type);
    exprStack.push(init);
    min_args += 1;
    return decl;
  }
  


  public void loopEnter()
  {
    checkLoop();
    LambdaExp loopLambda = (LambdaExp)current_scope;
    int ninits = min_args;
    max_args = ninits;
    Expression[] inits = new Expression[ninits];
    int i = ninits; for (;;) { i--; if (i < 0) break;
      inits[i] = ((Expression)exprStack.pop()); }
    LetExp let = (LetExp)loopLambda.getOuter();
    Declaration fdecl = let.firstDecl();
    let.setBody(new ApplyExp(new ReferenceExp(fdecl), inits));
    lexical.push(loopLambda);
  }
  
  @Deprecated
  public void loopCond(Expression cond) {
    checkLoop();
    exprStack.push(cond);
  }
  
  @Deprecated
  public void loopBody(Expression body) {
    LambdaExp loopLambda = (LambdaExp)current_scope;
    body = body;
  }
  
  public Expression loopRepeat(LambdaExp loop, Expression... exps)
  {
    ScopeExp let = loop.getOuter();
    Declaration fdecl = let.firstDecl();
    return new ApplyExp(new ReferenceExp(fdecl), exps);
  }
  
  public Expression loopDone(Expression body)
  {
    LambdaExp loopLambda = (LambdaExp)current_scope;
    ScopeExp let = loopLambda.getOuter();
    body = body;
    lexical.pop(loopLambda);
    current_scope = let.getOuter();
    return let;
  }
  


  public Expression loopRepeatDone(Expression... exps)
  {
    LambdaExp loopLambda = (LambdaExp)current_scope;
    ScopeExp let = loopLambda.getOuter();
    Expression cond = (Expression)exprStack.pop();
    Expression recurse = loopRepeat(loopLambda, exps);
    body = new IfExp(cond, new BeginExp(body, recurse), QuoteExp.voidExp);
    

    lexical.pop(loopLambda);
    current_scope = let.getOuter();
    return let;
  }
  

  public Expression applyFunction(Expression func)
  {
    return null;
  }
  
  public QuoteExp makeQuoteExp(Object value)
  {
    return QuoteExp.getInstance(value, this);
  }
  






  public static ApplyExp makeCoercion(Expression value, Expression type)
  {
    Expression[] exps = new Expression[2];
    exps[0] = type;
    exps[1] = value;
    QuoteExp c = new QuoteExp(gnu.kawa.functions.Convert.cast);
    return new ApplyExp(c, exps);
  }
  





  public static ApplyExp makeCoercion(Expression value, Type type)
  {
    return makeCoercion(value, new QuoteExp(type));
  }
  





  public void loadClassRef(ObjectType clas)
  {
    CodeAttr code = getCode();
    
    if (curClass.getClassfileVersion() >= 3211264) {
      code.emitPushClass(clas);
    } else if ((clas == mainClass) && (mainLambda.isStatic()) && (moduleInstanceMainField != null))
    {


      code.emitGetStatic(moduleInstanceMainField);
      code.emitInvokeVirtual(Type.objectType.getDeclaredMethod("getClass", 0));
    }
    else
    {
      String name = (clas instanceof ClassType) ? clas.getName() : clas.getInternalName().replace('/', '.');
      
      code.emitPushString(name);
      code.emitInvokeStatic(getForNameHelper());
    }
  }
  


  protected Language language;
  

  public Stack<Expression> exprStack;
  

  Method forNameHelper;
  
  public Method getForNameHelper()
  {
    if (forNameHelper == null)
    {

      Method save_method = method;
      method = curClass.addMethod("class$", 9, string1Arg, typeClass);
      
      forNameHelper = method;
      CodeAttr code = method.startCode();
      code.emitLoad(code.getArg(0));
      code.emitPushInt(0);
      code.emitPushString(mainClass.getName());
      code.emitInvokeStatic(typeClass.getDeclaredMethod("forName", 1));
      code.emitInvokeVirtual(typeClass.getDeclaredMethod("getClassLoader", 0));
      code.emitInvokeStatic(typeClass.getDeclaredMethod("forName", 3));
      code.emitReturn();
      method = save_method;
    }
    


    return forNameHelper;
  }
  
  public Environment getGlobalEnvironment() { return Environment.getCurrent(); }
  
  public Object resolve(Object name, boolean function)
  {
    Environment env = getGlobalEnvironment();
    gnu.mapping.Symbol symbol;
    gnu.mapping.Symbol symbol; if ((name instanceof String)) {
      symbol = env.defaultNamespace().lookup((String)name);
    } else
      symbol = (gnu.mapping.Symbol)name;
    if (symbol == null)
      return null;
    if ((function) && (getLanguage().hasSeparateFunctionNamespace()))
      return env.getFunction(symbol, null);
    return env.get(symbol, null);
  }
  


  private int keyUninitialized;
  

  private static Compilation chainUninitialized;
  

  private Compilation nextUninitialized;
  

  public NameLookup lexical;
  

  protected ScopeExp current_scope;
  
  protected SourceMessages messages;
  
  public static void setupLiterals(int key)
  {
    Compilation comp = findForImmediateLiterals(key);
    try
    {
      Class clas = loader.loadClass(mainClass.getName());
      

      for (Literal init = litTable.literalsChain; init != null; 
          init = next)
      {






        clas.getDeclaredField(field.getName()).set(null, value);
      }
      
      litTable = null;
    }
    catch (Throwable ex)
    {
      gnu.mapping.WrappedException.rethrow(ex);
    }
  }
  

  public static synchronized int registerForImmediateLiterals(Compilation comp)
  {
    int i = 0;
    for (Compilation c = chainUninitialized; c != null; c = nextUninitialized)
    {
      if (i <= keyUninitialized)
        i = keyUninitialized + 1;
    }
    keyUninitialized = i;
    nextUninitialized = chainUninitialized;
    chainUninitialized = comp;
    return i;
  }
  
  public static synchronized Compilation findForImmediateLiterals(int key)
  {
    Compilation prev = null;
    Compilation comp = chainUninitialized;
    for (;;) {
      Compilation next = nextUninitialized;
      if (keyUninitialized == key)
      {
        if (prev == null) {
          chainUninitialized = next;
        } else
          nextUninitialized = next;
        nextUninitialized = null;
        return comp;
      }
      prev = comp;
      comp = next;
    }
  }
  







  private static final ThreadLocal<Compilation> current = new InheritableThreadLocal();
  

  public static Compilation getCurrent()
  {
    return (Compilation)current.get();
  }
  
  public static void setCurrent(Compilation comp)
  {
    current.set(comp);
  }
  
  public static Compilation setSaveCurrent(Compilation comp)
  {
    Compilation save = (Compilation)current.get();
    current.set(comp);
    return save;
  }
  
  public static void restoreCurrent(Compilation saved)
  {
    current.set(saved);
  }
  
  public String toString()
  {
    return "<compilation " + mainLambda + ">";
  }
  
  public ModuleInfo getMinfo() {
    return mainLambda.info;
  }
  
  public void freeLocalField(gnu.bytecode.Field field) {}
}
