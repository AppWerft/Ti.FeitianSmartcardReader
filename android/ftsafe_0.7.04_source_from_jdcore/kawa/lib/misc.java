package kawa.lib;

import gnu.expr.ModuleMethod;

public class misc extends gnu.expr.ModuleBody {
  public static final ModuleMethod boolean$Qu;
  public static final ModuleMethod boolean$Eq$Qu;
  public static final ModuleMethod symbol$Qu;
  public static final ModuleMethod symbol$Mn$Grstring;
  public static final ModuleMethod symbol$Eq$Qu;
  public static final ModuleMethod symbol$Mnlocal$Mnname;
  public static final ModuleMethod symbol$Mnnamespace;
  public static final ModuleMethod symbol$Mnnamespace$Mnuri;
  public static final ModuleMethod symbol$Mnprefix;
  
  public static boolean isBoolean(Object x) {
    boolean x = x == Boolean.TRUE;return x == Boolean.FALSE ? true : x ? x : false;
  }
  


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
  
  public static final gnu.expr.GenericProc procedure$Mnproperty;
  
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
  
  static final gnu.math.IntNum Lit0;
  
  static final gnu.math.IntNum Lit1;
  
  static final gnu.expr.Keyword Lit2;
  
  static final ModuleMethod procedure$Mnproperty$Fn1;
  
  public static misc $instance;
  
  static final gnu.mapping.SimpleSymbol Lit3;
  
  static final gnu.mapping.SimpleSymbol Lit4;
  
  static final gnu.mapping.SimpleSymbol Lit5;
  
  static final gnu.mapping.SimpleSymbol Lit6;
  
  static final gnu.mapping.SimpleSymbol Lit7;
  
  static final gnu.mapping.SimpleSymbol Lit8;
  
  static final gnu.mapping.SimpleSymbol Lit9;
  
  static final gnu.mapping.SimpleSymbol Lit10;
  
  static final gnu.mapping.SimpleSymbol Lit11;
  
  static final gnu.mapping.SimpleSymbol Lit12;
  
  static final gnu.mapping.SimpleSymbol Lit13;
  
  static final gnu.mapping.SimpleSymbol Lit14;
  
  static final gnu.mapping.SimpleSymbol Lit15;
  
  static final gnu.mapping.SimpleSymbol Lit16;
  
  static final gnu.mapping.SimpleSymbol Lit17;
  
  static final gnu.mapping.SimpleSymbol Lit18;
  
  static final gnu.mapping.SimpleSymbol Lit19;
  
  static final gnu.mapping.SimpleSymbol Lit20;
  
  static final gnu.mapping.SimpleSymbol Lit21;
  
  static final gnu.mapping.SimpleSymbol Lit22;
  
  static final gnu.mapping.SimpleSymbol Lit23;
  
  static final gnu.mapping.SimpleSymbol Lit24;
  
  static final gnu.mapping.SimpleSymbol Lit25;
  
  static final gnu.mapping.SimpleSymbol Lit26;
  
  static final gnu.mapping.SimpleSymbol Lit27;
  
  static final gnu.mapping.SimpleSymbol Lit28;
  
  static final gnu.mapping.SimpleSymbol Lit29;
  
  static final gnu.mapping.SimpleSymbol Lit30;
  
  static final gnu.mapping.SimpleSymbol Lit31;
  
  static final gnu.mapping.SimpleSymbol Lit32;
  
  static final gnu.mapping.SimpleSymbol Lit33;
  
  static final gnu.mapping.SimpleSymbol Lit34;
  
  static final gnu.mapping.SimpleSymbol Lit35;
  
  static final gnu.mapping.SimpleSymbol Lit36;
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 37:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 14: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 5: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 2: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); }
  public static boolean isBoolean$Eq(Object b1, Object b2, Object... r) { int n = r.length - 1;
    

    int i = n;
    for (;;) { boolean x = i < 0; if (!gnu.expr.KawaConvert.isTrue(r[i])) break; i--;
    }
    int i = n;
    for (;;) { boolean x = i < 0; if (gnu.expr.KawaConvert.isTrue(r[i])) break; i--; } return !gnu.expr.KawaConvert.isTrue(b2) ? false : x ? x : gnu.expr.KawaConvert.isTrue(b1) ? false : gnu.expr.KawaConvert.isTrue(b2) ? false : x ? x : false;
  }
  
  public static boolean isSymbol(Object x) { return x instanceof gnu.mapping.Symbol; }
  

  public static String symbol$To$String(gnu.mapping.Symbol s) { return s.toString(); }
  
  public static boolean isSymbol$Eq$V(gnu.mapping.Symbol s1, gnu.mapping.Symbol s2, Object[] argsArray) { gnu.lists.LList localLList1; gnu.lists.LList r = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    
    boolean x = lists.isNull(r);return gnu.mapping.Symbol.equals(s1, s2) ? false : gnu.expr.KawaConvert.isTrue(gnu.mapping.Promise.force(kawa.standard.Scheme.apply.apply3(symbol$Eq$Qu, s2, r))) ? true : x ? x : false;
  }
  
  public static String symbolLocalName(gnu.mapping.Symbol s) { return s.getLocalPart(); }
  
  public static gnu.mapping.Namespace symbolNamespace(gnu.mapping.Symbol s) {
    return s.getNamespace();
  }
  
  public static String symbolNamespaceUri(gnu.mapping.Symbol s) { return s.getNamespaceURI(); }
  
  public static String symbolPrefix(gnu.mapping.Symbol s) {
    return s.getPrefix();
  }
  
  public static CharSequence namespaceUri(gnu.mapping.Namespace ns) { return ns.getName(); }
  
  public static CharSequence namespacePrefix(gnu.mapping.Namespace ns) {
    return ns.getPrefix();
  }
  
  public static gnu.mapping.SimpleSymbol string$To$Symbol(CharSequence str) { return gnu.mapping.SimpleSymbol.valueOf(str.toString()); }
  
  public static boolean isProcedure(Object x) {
    boolean x = x instanceof gnu.mapping.Procedure;return x ? x : x instanceof gnu.kawa.lispexpr.LangObjType;
  }
  
  public static Object values(Object... args)
  {
    return gnu.mapping.Values.make(args);
  }
  
  public static boolean isEnvironmentBound(gnu.mapping.Environment env, Object sym)
  {
    return env.isBound(gnu.kawa.lispexpr.LispLanguage.langSymbolToSymbol(sym));
  }
  




















































































  public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 38:  proc = paramModuleMethod;pc = 0;return 0;
    case 36: 
      proc = paramModuleMethod;pc = 0;return 0;
    case 34: 
      proc = paramModuleMethod;pc = 0;return 0;
    case 20: 
      proc = paramModuleMethod;pc = 0;return 0;
    case 19: 
      proc = paramModuleMethod;pc = 0;return 0;
    case 16: 
      proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext); }
  public static gnu.mapping.Environment nullEnvironment(Object version) { return kawa.standard.Scheme.nullEnvironment; }
  







  public static gnu.mapping.Environment interactionEnvironment()
  {
    return gnu.mapping.Environment.user();
  }
  
  public static String schemeImplementationVersion() { return kawa.Version.getVersion(); }
  

  public static void setProcedureProperty$Ex(gnu.mapping.Procedure proc, Object key, Object value) { proc.setProperty(key, value); }
  
  static { Lit36 = gnu.mapping.Symbol.valueOf("add-procedure-properties");Lit35 = gnu.mapping.Symbol.valueOf("gentemp");Lit34 = gnu.mapping.Symbol.valueOf("base-uri");Lit33 = gnu.mapping.Symbol.valueOf("eager");Lit32 = gnu.mapping.Symbol.valueOf("force*");Lit31 = gnu.mapping.Symbol.valueOf("force");Lit30 = gnu.mapping.Symbol.valueOf("promise-set-thunk!");Lit29 = gnu.mapping.Symbol.valueOf("promise-set-exception!");Lit28 = gnu.mapping.Symbol.valueOf("promise-set-alias!");Lit27 = gnu.mapping.Symbol.valueOf("promise-set-value!");Lit26 = gnu.mapping.Symbol.valueOf("make-promise");Lit25 = gnu.mapping.Symbol.valueOf("promise?");Lit24 = gnu.mapping.Symbol.valueOf("dynamic-wind");Lit23 = gnu.mapping.Symbol.valueOf("procedure-property");Lit22 = gnu.mapping.Symbol.valueOf("set-procedure-property!");Lit21 = gnu.mapping.Symbol.valueOf("scheme-implementation-version");Lit20 = gnu.mapping.Symbol.valueOf("interaction-environment");Lit19 = gnu.mapping.Symbol.valueOf("scheme-report-environment");Lit18 = gnu.mapping.Symbol.valueOf("null-environment");Lit17 = gnu.mapping.Symbol.valueOf("environment-bound?");Lit16 = gnu.mapping.Symbol.valueOf("values");Lit15 = gnu.mapping.Symbol.valueOf("procedure?");Lit14 = gnu.mapping.Symbol.valueOf("string->symbol");Lit13 = gnu.mapping.Symbol.valueOf("namespace-prefix");Lit12 = gnu.mapping.Symbol.valueOf("namespace-uri");Lit11 = gnu.mapping.Symbol.valueOf("symbol-prefix");Lit10 = gnu.mapping.Symbol.valueOf("symbol-namespace-uri");Lit9 = gnu.mapping.Symbol.valueOf("symbol-namespace");Lit8 = gnu.mapping.Symbol.valueOf("symbol-local-name");Lit7 = gnu.mapping.Symbol.valueOf("symbol=?");Lit6 = gnu.mapping.Symbol.valueOf("symbol->string");Lit5 = gnu.mapping.Symbol.valueOf("symbol?");Lit4 = gnu.mapping.Symbol.valueOf("boolean=?");Lit3 = gnu.mapping.Symbol.valueOf("boolean?");Lit2 = gnu.expr.Keyword.make("setter");Lit1 = gnu.math.IntNum.valueOf(5);Lit0 = gnu.math.IntNum.valueOf(4);$instance = new misc();misc localMisc = $instance;boolean$Qu = new ModuleMethod(localMisc, 1, Lit3, 4097);boolean$Eq$Qu = new ModuleMethod(localMisc, 2, Lit4, 61442);symbol$Qu = new ModuleMethod(localMisc, 3, Lit5, 4097);symbol$Mn$Grstring = new ModuleMethod(localMisc, 4, Lit6, 4097);symbol$Eq$Qu = new ModuleMethod(localMisc, 5, Lit7, 61442);symbol$Mnlocal$Mnname = new ModuleMethod(localMisc, 6, Lit8, 4097);symbol$Mnnamespace = new ModuleMethod(localMisc, 7, Lit9, 4097);symbol$Mnnamespace$Mnuri = new ModuleMethod(localMisc, 8, Lit10, 4097);symbol$Mnprefix = new ModuleMethod(localMisc, 9, Lit11, 4097);namespace$Mnuri = new ModuleMethod(localMisc, 10, Lit12, 4097);namespace$Mnprefix = new ModuleMethod(localMisc, 11, Lit13, 4097);string$Mn$Grsymbol = new ModuleMethod(localMisc, 12, Lit14, 4097);procedure$Qu = new ModuleMethod(localMisc, 13, Lit15, 4097); void tmp610_607 = new ModuleMethod(localMisc, 14, Lit16, 61440);tmp610_607.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:valuesValidateApply"); void tmp620_610 = tmp610_607;tmp620_610.setProperty(gnu.mapping.Procedure.compilerXKey, "kawa.lib.compile_misc:valuesCompile");values = tmp620_610;environment$Mnbound$Qu = new ModuleMethod(localMisc, 15, Lit17, 8194);null$Mnenvironment = new ModuleMethod(localMisc, 16, Lit18, 4096);scheme$Mnreport$Mnenvironment = new ModuleMethod(localMisc, 18, Lit19, 4097);interaction$Mnenvironment = new ModuleMethod(localMisc, 19, Lit20, 0);scheme$Mnimplementation$Mnversion = new ModuleMethod(localMisc, 20, Lit21, 0);set$Mnprocedure$Mnproperty$Ex = new ModuleMethod(localMisc, 21, Lit22, 12291);procedure$Mnproperty = new gnu.expr.GenericProc("procedure-property");procedure$Mnproperty$Fn1 = new ModuleMethod(localMisc, 22, Lit23, 12290);dynamic$Mnwind = new ModuleMethod(localMisc, 24, Lit24, 12291);promise$Qu = new ModuleMethod(localMisc, 25, Lit25, 4097);make$Mnpromise = new ModuleMethod(localMisc, 26, Lit26, 4097);promise$Mnset$Mnvalue$Ex = new ModuleMethod(localMisc, 27, Lit27, 8194);promise$Mnset$Mnalias$Ex = new ModuleMethod(localMisc, 28, Lit28, 8194);promise$Mnset$Mnexception$Ex = new ModuleMethod(localMisc, 29, Lit29, 8194);promise$Mnset$Mnthunk$Ex = new ModuleMethod(localMisc, 30, Lit30, 8194);force = new ModuleMethod(localMisc, 31, Lit31, 4097);force$St = new ModuleMethod(localMisc, 32, Lit32, 4097);eager = new ModuleMethod(localMisc, 33, Lit33, 4097);base$Mnuri = new ModuleMethod(localMisc, 34, Lit34, 4096);gentemp = new ModuleMethod(localMisc, 36, Lit35, 0);add$Mnprocedure$Mnproperties = new ModuleMethod(localMisc, 37, Lit36, 61441);features = new ModuleMethod(localMisc, 38, Lit37, 0);$runBody$(); } static final gnu.mapping.SimpleSymbol Lit37 = gnu.mapping.Symbol.valueOf("features");
  
  public static Object procedureProperty(gnu.mapping.Procedure proc, Object key, Object default)
  {
    return proc.getProperty(key, default);
  }
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
    





























































































    procedure$Mnproperty
      .setProperty(Lit2, set$Mnprocedure$Mnproperty$Ex);
    
    gnu.mapping.Procedure procedure$Mnproperty = procedure$Mnproperty$Fn1;
    ModuleMethod localModuleMethod;
    procedure$Mnproperty.add(localModuleMethod = procedure$Mnproperty$Fn1);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (selector) {} try { setProcedureProperty$Ex(gnu.kawa.lispexpr.LangObjType.coerceToProcedure(gnu.mapping.Promise.force(paramObject1, gnu.mapping.Procedure.class)), paramObject2, paramObject3);return gnu.mapping.Values.empty; } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      








        localClassCastException1, "set-procedure-property!", 1, paramObject1);
    }
    try
    {
      return procedureProperty(gnu.kawa.lispexpr.LangObjType.coerceToProcedure(gnu.mapping.Promise.force(paramObject1, gnu.mapping.Procedure.class)), paramObject2, paramObject3); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "procedure-property", 1, paramObject1);
    }
    

    return dynamicWind(paramObject1, paramObject2, paramObject3);return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3); }
  public static Object dynamicWind(Object before, Object thunk, Object after) { kawa.standard.Scheme.applyToArgs.apply1(before);
    Object localObject1;
    try { localObject1 = kawa.standard.Scheme.applyToArgs.apply1(thunk);
    } finally { kawa.standard.Scheme.applyToArgs.apply1(after); } return localObject1;
  }
  
  public static boolean isPromise(Object obj) { return obj instanceof gnu.mapping.Lazy; }
  
  public static gnu.mapping.Lazy makePromise(Object obj)
  {
    return (obj instanceof gnu.mapping.Lazy) ? (gnu.mapping.Lazy)obj : gnu.mapping.Promise.makeBoundPromise(obj);
  }
  
  public static void promiseSetValue$Ex(gnu.mapping.Promise promise, Object value) { promise.setValue(value); }
  
  public static void promiseSetAlias$Ex(gnu.mapping.Promise promise, gnu.mapping.Lazy aliasee) {
    promise.setAlias(aliasee);
  }
  
  public static void promiseSetException$Ex(gnu.mapping.Promise promise, Throwable exception) { promise.setException(exception); }
  
  public static void promiseSetThunk$Ex(gnu.mapping.Promise promise, gnu.mapping.Procedure thunk) {
    promise.setThunk(thunk);
  }
  
  public static Object force(Object arg) { return gnu.mapping.Promise.force1(arg); }
  
  public static Object force$St(Object arg) {
    return gnu.mapping.Promise.force(arg);
  }
  
  public static gnu.mapping.Procedure eager(Object value) { return eager;
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return isBoolean(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    










    case 3: 
      return isSymbol(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    }
    try {
      return symbol$To$String((gnu.mapping.Symbol)gnu.mapping.Promise.force(paramObject, gnu.mapping.Symbol.class)); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      







































































































        localClassCastException1, "symbol->string", 1, paramObject);
    }
    try
    {
      return symbolLocalName((gnu.mapping.Symbol)gnu.mapping.Promise.force(paramObject, gnu.mapping.Symbol.class)); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "symbol-local-name", 1, paramObject);
    }
    try {
      return symbolNamespace((gnu.mapping.Symbol)gnu.mapping.Promise.force(paramObject, gnu.mapping.Symbol.class)); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "symbol-namespace", 1, paramObject);
    }
    try {
      return symbolNamespaceUri((gnu.mapping.Symbol)gnu.mapping.Promise.force(paramObject, gnu.mapping.Symbol.class)); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "symbol-namespace-uri", 1, paramObject);
    }
    try {
      return symbolPrefix((gnu.mapping.Symbol)gnu.mapping.Promise.force(paramObject, gnu.mapping.Symbol.class)); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "symbol-prefix", 1, paramObject);
    }
    try {
      return namespaceUri((gnu.mapping.Namespace)gnu.mapping.Promise.force(paramObject, gnu.mapping.Namespace.class)); } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(localClassCastException6, "namespace-uri", 1, paramObject);
    }
    try {
      return namespacePrefix((gnu.mapping.Namespace)gnu.mapping.Promise.force(paramObject, gnu.mapping.Namespace.class)); } catch (ClassCastException localClassCastException7) { throw new gnu.mapping.WrongType(localClassCastException7, "namespace-prefix", 1, paramObject);
    }
    try {
      return string$To$Symbol((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException8) { throw new gnu.mapping.WrongType(localClassCastException8, "string->symbol", 1, paramObject);
    }
    
    return isProcedure(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    














    return nullEnvironment(paramObject);
    

    return schemeReportEnvironment(paramObject);
    




























    return isPromise(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    

    return makePromise(paramObject);
    














    return force(paramObject);
    

    return force$St(paramObject);
    

    return eager(paramObject);
    

    return baseUri(paramObject);return super.apply1(paramModuleMethod, paramObject);
  }
  
  public static Object baseUri(Object node) { gnu.kawa.io.Path uri = node == null ? gnu.kawa.io.Path.currentPath() : ((gnu.kawa.xml.KNode)gnu.mapping.Promise.force(node, gnu.kawa.xml.KNode.class)).baseURI();
    return uri == gnu.mapping.Values.empty ? Boolean.FALSE : uri;
  }
  







  public static gnu.mapping.Symbol gentemp()
  {
    return gnu.expr.Symbols.gentemp();
  }
  
  public static void addProcedureProperties(gnu.expr.GenericProc proc, Object... args)
  {
    proc.setProperties(args);
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (selector) {case 16:  return nullEnvironment();
    








    case 19: 
      return interactionEnvironment();
    
    case 20: 
      return schemeImplementationVersion();
    












































    case 34: 
      return baseUri();
    












    case 36: 
      return gentemp();
    





    case 38: 
      return features(); } return super.apply0(paramModuleMethod); }
  public static gnu.lists.LList features() { return kawa.standard.IfFeature.featureList(); }
  
  public static gnu.mapping.Environment nullEnvironment()
  {
    return nullEnvironment(Boolean.FALSE);
  }
  
  /* Error */
  public static gnu.mapping.Environment schemeReportEnvironment(Object version)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 131	java/lang/Object:hashCode	()I
    //   4: tableswitch	default:+56->60, 4:+24->28, 5:+40->44
    //   28: aload_0
    //   29: getstatic 135	kawa/lib/misc:Lit0	Lgnu/math/IntNum;
    //   32: invokestatic 140	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   35: ifeq +25 -> 60
    //   38: getstatic 143	kawa/standard/Scheme:r4Environment	Lgnu/mapping/Environment;
    //   41: goto +32 -> 73
    //   44: aload_0
    //   45: getstatic 146	kawa/lib/misc:Lit1	Lgnu/math/IntNum;
    //   48: invokestatic 140	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   51: ifeq +9 -> 60
    //   54: getstatic 149	kawa/standard/Scheme:r5Environment	Lgnu/mapping/Environment;
    //   57: goto +16 -> 73
    //   60: iconst_1
    //   61: anewarray 127	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: ldc -105
    //   68: aastore
    //   69: invokestatic 157	kawa/lang/NamedException:makeError	([Ljava/lang/Object;)Lkawa/lang/NamedException;
    //   72: athrow
    //   73: areturn
    // Line number table:
    //   Java source line #79	-> byte code offset #0
    //   Java source line #80	-> byte code offset #0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	version	Object
  }
  
  public static Object procedureProperty(gnu.mapping.Procedure paramProcedure, Object paramObject)
  {
    return procedureProperty(paramProcedure, paramObject, Boolean.FALSE);
  }
  
  public static Object baseUri()
  {
    return baseUri(null);
  }
  
  public misc()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 517	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+606->610, 1:+589->593, 2:+606->610, 3:+572->576, 4:+539->543, 5:+606->610, 6:+506->510, 7:+473->477, 8:+440->444, 9:+407->411, 10:+374->378, 11:+341->345, 12:+305->309, 13:+288->292, 14:+606->610, 15:+606->610, 16:+271->275, 17:+606->610, 18:+254->258, 19:+606->610, 20:+606->610, 21:+606->610, 22:+606->610, 23:+606->610, 24:+606->610, 25:+237->241, 26:+220->224, 27:+606->610, 28:+606->610, 29:+606->610, 30:+606->610, 31:+203->207, 32:+186->190, 33:+169->173, 34:+152->156
    //   156: aload_3
    //   157: aload_2
    //   158: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   161: aload_3
    //   162: aload_1
    //   163: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   166: aload_3
    //   167: iconst_1
    //   168: putfield 524	gnu/mapping/CallContext:pc	I
    //   171: iconst_0
    //   172: ireturn
    //   173: aload_3
    //   174: aload_2
    //   175: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   178: aload_3
    //   179: aload_1
    //   180: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   183: aload_3
    //   184: iconst_1
    //   185: putfield 524	gnu/mapping/CallContext:pc	I
    //   188: iconst_0
    //   189: ireturn
    //   190: aload_3
    //   191: aload_2
    //   192: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   195: aload_3
    //   196: aload_1
    //   197: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   200: aload_3
    //   201: iconst_1
    //   202: putfield 524	gnu/mapping/CallContext:pc	I
    //   205: iconst_0
    //   206: ireturn
    //   207: aload_3
    //   208: aload_2
    //   209: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   212: aload_3
    //   213: aload_1
    //   214: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   217: aload_3
    //   218: iconst_1
    //   219: putfield 524	gnu/mapping/CallContext:pc	I
    //   222: iconst_0
    //   223: ireturn
    //   224: aload_3
    //   225: aload_2
    //   226: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   229: aload_3
    //   230: aload_1
    //   231: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   234: aload_3
    //   235: iconst_1
    //   236: putfield 524	gnu/mapping/CallContext:pc	I
    //   239: iconst_0
    //   240: ireturn
    //   241: aload_3
    //   242: aload_2
    //   243: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   246: aload_3
    //   247: aload_1
    //   248: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   251: aload_3
    //   252: iconst_1
    //   253: putfield 524	gnu/mapping/CallContext:pc	I
    //   256: iconst_0
    //   257: ireturn
    //   258: aload_3
    //   259: aload_2
    //   260: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   263: aload_3
    //   264: aload_1
    //   265: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   268: aload_3
    //   269: iconst_1
    //   270: putfield 524	gnu/mapping/CallContext:pc	I
    //   273: iconst_0
    //   274: ireturn
    //   275: aload_3
    //   276: aload_2
    //   277: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   280: aload_3
    //   281: aload_1
    //   282: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   285: aload_3
    //   286: iconst_1
    //   287: putfield 524	gnu/mapping/CallContext:pc	I
    //   290: iconst_0
    //   291: ireturn
    //   292: aload_3
    //   293: aload_2
    //   294: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   297: aload_3
    //   298: aload_1
    //   299: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   302: aload_3
    //   303: iconst_1
    //   304: putfield 524	gnu/mapping/CallContext:pc	I
    //   307: iconst_0
    //   308: ireturn
    //   309: aload_3
    //   310: aload_2
    //   311: ldc 91
    //   313: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   316: dup
    //   317: instanceof 91
    //   320: ifeq +6 -> 326
    //   323: goto +7 -> 330
    //   326: ldc_w 533
    //   329: ireturn
    //   330: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   333: aload_3
    //   334: aload_1
    //   335: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   338: aload_3
    //   339: iconst_1
    //   340: putfield 524	gnu/mapping/CallContext:pc	I
    //   343: iconst_0
    //   344: ireturn
    //   345: aload_3
    //   346: aload_2
    //   347: ldc 85
    //   349: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   352: dup
    //   353: instanceof 85
    //   356: ifne +7 -> 363
    //   359: ldc_w 533
    //   362: ireturn
    //   363: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   366: aload_3
    //   367: aload_1
    //   368: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   371: aload_3
    //   372: iconst_1
    //   373: putfield 524	gnu/mapping/CallContext:pc	I
    //   376: iconst_0
    //   377: ireturn
    //   378: aload_3
    //   379: aload_2
    //   380: ldc 85
    //   382: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   385: dup
    //   386: instanceof 85
    //   389: ifne +7 -> 396
    //   392: ldc_w 533
    //   395: ireturn
    //   396: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   399: aload_3
    //   400: aload_1
    //   401: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   404: aload_3
    //   405: iconst_1
    //   406: putfield 524	gnu/mapping/CallContext:pc	I
    //   409: iconst_0
    //   410: ireturn
    //   411: aload_3
    //   412: aload_2
    //   413: ldc 27
    //   415: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   418: dup
    //   419: instanceof 27
    //   422: ifne +7 -> 429
    //   425: ldc_w 533
    //   428: ireturn
    //   429: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   432: aload_3
    //   433: aload_1
    //   434: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   437: aload_3
    //   438: iconst_1
    //   439: putfield 524	gnu/mapping/CallContext:pc	I
    //   442: iconst_0
    //   443: ireturn
    //   444: aload_3
    //   445: aload_2
    //   446: ldc 27
    //   448: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   451: dup
    //   452: instanceof 27
    //   455: ifne +7 -> 462
    //   458: ldc_w 533
    //   461: ireturn
    //   462: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   465: aload_3
    //   466: aload_1
    //   467: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   470: aload_3
    //   471: iconst_1
    //   472: putfield 524	gnu/mapping/CallContext:pc	I
    //   475: iconst_0
    //   476: ireturn
    //   477: aload_3
    //   478: aload_2
    //   479: ldc 27
    //   481: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   484: dup
    //   485: instanceof 27
    //   488: ifne +7 -> 495
    //   491: ldc_w 533
    //   494: ireturn
    //   495: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   498: aload_3
    //   499: aload_1
    //   500: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   503: aload_3
    //   504: iconst_1
    //   505: putfield 524	gnu/mapping/CallContext:pc	I
    //   508: iconst_0
    //   509: ireturn
    //   510: aload_3
    //   511: aload_2
    //   512: ldc 27
    //   514: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   517: dup
    //   518: instanceof 27
    //   521: ifne +7 -> 528
    //   524: ldc_w 533
    //   527: ireturn
    //   528: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   531: aload_3
    //   532: aload_1
    //   533: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   536: aload_3
    //   537: iconst_1
    //   538: putfield 524	gnu/mapping/CallContext:pc	I
    //   541: iconst_0
    //   542: ireturn
    //   543: aload_3
    //   544: aload_2
    //   545: ldc 27
    //   547: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   550: dup
    //   551: instanceof 27
    //   554: ifne +7 -> 561
    //   557: ldc_w 533
    //   560: ireturn
    //   561: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   564: aload_3
    //   565: aload_1
    //   566: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   569: aload_3
    //   570: iconst_1
    //   571: putfield 524	gnu/mapping/CallContext:pc	I
    //   574: iconst_0
    //   575: ireturn
    //   576: aload_3
    //   577: aload_2
    //   578: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   581: aload_3
    //   582: aload_1
    //   583: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   586: aload_3
    //   587: iconst_1
    //   588: putfield 524	gnu/mapping/CallContext:pc	I
    //   591: iconst_0
    //   592: ireturn
    //   593: aload_3
    //   594: aload_2
    //   595: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   598: aload_3
    //   599: aload_1
    //   600: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   603: aload_3
    //   604: iconst_1
    //   605: putfield 524	gnu/mapping/CallContext:pc	I
    //   608: iconst_0
    //   609: ireturn
    //   610: aload_0
    //   611: aload_1
    //   612: aload_2
    //   613: aload_3
    //   614: invokespecial 537	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   617: ireturn
    // Line number table:
    //   Java source line #137	-> byte code offset #156
    //   Java source line #134	-> byte code offset #173
    //   Java source line #131	-> byte code offset #190
    //   Java source line #128	-> byte code offset #207
    //   Java source line #112	-> byte code offset #224
    //   Java source line #109	-> byte code offset #241
    //   Java source line #79	-> byte code offset #258
    //   Java source line #76	-> byte code offset #275
    //   Java source line #60	-> byte code offset #292
    //   Java source line #57	-> byte code offset #309
    //   Java source line #54	-> byte code offset #345
    //   Java source line #51	-> byte code offset #378
    //   Java source line #48	-> byte code offset #411
    //   Java source line #45	-> byte code offset #444
    //   Java source line #42	-> byte code offset #477
    //   Java source line #39	-> byte code offset #510
    //   Java source line #32	-> byte code offset #543
    //   Java source line #29	-> byte code offset #576
    //   Java source line #16	-> byte code offset #593
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 517	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+339->343, 15:+297->301, 22:+252->256, 27:+215->219, 28:+167->171, 29:+113->117, 30:+60->64
    //   64: aload 4
    //   66: aload_2
    //   67: dup
    //   68: instanceof 66
    //   71: ifne +7 -> 78
    //   74: ldc_w 533
    //   77: ireturn
    //   78: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   81: aload 4
    //   83: aload_3
    //   84: ldc 60
    //   86: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   89: dup
    //   90: instanceof 60
    //   93: ifne +7 -> 100
    //   96: ldc_w 538
    //   99: ireturn
    //   100: putfield 541	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   103: aload 4
    //   105: aload_1
    //   106: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   109: aload 4
    //   111: iconst_2
    //   112: putfield 524	gnu/mapping/CallContext:pc	I
    //   115: iconst_0
    //   116: ireturn
    //   117: aload 4
    //   119: aload_2
    //   120: dup
    //   121: instanceof 66
    //   124: ifne +7 -> 131
    //   127: ldc_w 533
    //   130: ireturn
    //   131: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   134: aload 4
    //   136: aload_3
    //   137: ldc_w 543
    //   140: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   143: dup
    //   144: instanceof 543
    //   147: ifne +7 -> 154
    //   150: ldc_w 538
    //   153: ireturn
    //   154: putfield 541	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   157: aload 4
    //   159: aload_1
    //   160: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   163: aload 4
    //   165: iconst_2
    //   166: putfield 524	gnu/mapping/CallContext:pc	I
    //   169: iconst_0
    //   170: ireturn
    //   171: aload 4
    //   173: aload_2
    //   174: dup
    //   175: instanceof 66
    //   178: ifne +7 -> 185
    //   181: ldc_w 533
    //   184: ireturn
    //   185: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   188: aload 4
    //   190: aload_3
    //   191: dup
    //   192: instanceof 210
    //   195: ifne +7 -> 202
    //   198: ldc_w 538
    //   201: ireturn
    //   202: putfield 541	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   205: aload 4
    //   207: aload_1
    //   208: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   211: aload 4
    //   213: iconst_2
    //   214: putfield 524	gnu/mapping/CallContext:pc	I
    //   217: iconst_0
    //   218: ireturn
    //   219: aload 4
    //   221: aload_2
    //   222: dup
    //   223: instanceof 66
    //   226: ifne +7 -> 233
    //   229: ldc_w 533
    //   232: ireturn
    //   233: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   236: aload 4
    //   238: aload_3
    //   239: putfield 541	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   242: aload 4
    //   244: aload_1
    //   245: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   248: aload 4
    //   250: iconst_2
    //   251: putfield 524	gnu/mapping/CallContext:pc	I
    //   254: iconst_0
    //   255: ireturn
    //   256: aload 4
    //   258: aload_2
    //   259: ldc 60
    //   261: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   264: dup
    //   265: invokestatic 547	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   268: ifnull +6 -> 274
    //   271: goto +7 -> 278
    //   274: ldc_w 533
    //   277: ireturn
    //   278: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   281: aload 4
    //   283: aload_3
    //   284: putfield 541	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   287: aload 4
    //   289: aload_1
    //   290: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   293: aload 4
    //   295: iconst_2
    //   296: putfield 524	gnu/mapping/CallContext:pc	I
    //   299: iconst_0
    //   300: ireturn
    //   301: aload 4
    //   303: aload_2
    //   304: ldc 114
    //   306: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   309: dup
    //   310: instanceof 114
    //   313: ifne +7 -> 320
    //   316: ldc_w 533
    //   319: ireturn
    //   320: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   323: aload 4
    //   325: aload_3
    //   326: putfield 541	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   329: aload 4
    //   331: aload_1
    //   332: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   335: aload 4
    //   337: iconst_2
    //   338: putfield 524	gnu/mapping/CallContext:pc	I
    //   341: iconst_0
    //   342: ireturn
    //   343: aload_0
    //   344: aload_1
    //   345: aload_2
    //   346: aload_3
    //   347: aload 4
    //   349: invokespecial 551	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   352: ireturn
    // Line number table:
    //   Java source line #125	-> byte code offset #64
    //   Java source line #122	-> byte code offset #117
    //   Java source line #119	-> byte code offset #171
    //   Java source line #116	-> byte code offset #219
    //   Java source line #99	-> byte code offset #256
    //   Java source line #68	-> byte code offset #301
  }
  
  /* Error */
  public int match3(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 517	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+169->173, 21:+117->121, 22:+65->69, 23:+169->173, 24:+32->36
    //   36: aload 5
    //   38: aload_2
    //   39: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   42: aload 5
    //   44: aload_3
    //   45: putfield 541	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   48: aload 5
    //   50: aload 4
    //   52: putfield 554	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   55: aload 5
    //   57: aload_1
    //   58: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   61: aload 5
    //   63: iconst_3
    //   64: putfield 524	gnu/mapping/CallContext:pc	I
    //   67: iconst_0
    //   68: ireturn
    //   69: aload 5
    //   71: aload_2
    //   72: ldc 60
    //   74: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   77: dup
    //   78: invokestatic 547	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   81: ifnull +6 -> 87
    //   84: goto +7 -> 91
    //   87: ldc_w 533
    //   90: ireturn
    //   91: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   94: aload 5
    //   96: aload_3
    //   97: putfield 541	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   100: aload 5
    //   102: aload 4
    //   104: putfield 554	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   107: aload 5
    //   109: aload_1
    //   110: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   113: aload 5
    //   115: iconst_3
    //   116: putfield 524	gnu/mapping/CallContext:pc	I
    //   119: iconst_0
    //   120: ireturn
    //   121: aload 5
    //   123: aload_2
    //   124: ldc 60
    //   126: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   129: dup
    //   130: invokestatic 547	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   133: ifnull +6 -> 139
    //   136: goto +7 -> 143
    //   139: ldc_w 533
    //   142: ireturn
    //   143: putfield 532	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   146: aload 5
    //   148: aload_3
    //   149: putfield 541	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   152: aload 5
    //   154: aload 4
    //   156: putfield 554	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   159: aload 5
    //   161: aload_1
    //   162: putfield 521	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   165: aload 5
    //   167: iconst_3
    //   168: putfield 524	gnu/mapping/CallContext:pc	I
    //   171: iconst_0
    //   172: ireturn
    //   173: aload_0
    //   174: aload_1
    //   175: aload_2
    //   176: aload_3
    //   177: aload 4
    //   179: aload 5
    //   181: invokespecial 558	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   184: ireturn
    // Line number table:
    //   Java source line #103	-> byte code offset #36
    //   Java source line #99	-> byte code offset #69
    //   Java source line #93	-> byte code offset #121
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 517	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+168->172, 15:+60->64, 22:+86->90, 27:+100->104, 28:+112->116, 29:+127->131, 30:+148->152
    //   64: aload_2
    //   65: ldc 114
    //   67: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   70: checkcast 114	gnu/mapping/Environment
    //   73: aload_3
    //   74: invokestatic 671	kawa/lib/misc:isEnvironmentBound	(Lgnu/mapping/Environment;Ljava/lang/Object;)Z
    //   77: ifeq +9 -> 86
    //   80: getstatic 16	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   83: goto +6 -> 89
    //   86: getstatic 19	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   89: areturn
    //   90: aload_2
    //   91: ldc 60
    //   93: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   96: invokestatic 674	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   99: aload_3
    //   100: invokestatic 677	kawa/lib/misc:procedureProperty	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: areturn
    //   104: aload_2
    //   105: checkcast 66	gnu/mapping/Promise
    //   108: aload_3
    //   109: invokestatic 683	kawa/lib/misc:promiseSetValue$Ex	(Lgnu/mapping/Promise;Ljava/lang/Object;)V
    //   112: getstatic 257	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   115: areturn
    //   116: aload_2
    //   117: checkcast 66	gnu/mapping/Promise
    //   120: aload_3
    //   121: checkcast 210	gnu/mapping/Lazy
    //   124: invokestatic 689	kawa/lib/misc:promiseSetAlias$Ex	(Lgnu/mapping/Promise;Lgnu/mapping/Lazy;)V
    //   127: getstatic 257	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   130: areturn
    //   131: aload_2
    //   132: checkcast 66	gnu/mapping/Promise
    //   135: aload_3
    //   136: ldc_w 543
    //   139: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   142: checkcast 543	java/lang/Throwable
    //   145: invokestatic 695	kawa/lib/misc:promiseSetException$Ex	(Lgnu/mapping/Promise;Ljava/lang/Throwable;)V
    //   148: getstatic 257	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   151: areturn
    //   152: aload_2
    //   153: checkcast 66	gnu/mapping/Promise
    //   156: aload_3
    //   157: ldc 60
    //   159: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   162: checkcast 60	gnu/mapping/Procedure
    //   165: invokestatic 701	kawa/lib/misc:promiseSetThunk$Ex	(Lgnu/mapping/Promise;Lgnu/mapping/Procedure;)V
    //   168: getstatic 257	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   171: areturn
    //   172: aload_0
    //   173: aload_1
    //   174: aload_2
    //   175: aload_3
    //   176: invokespecial 705	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: areturn
    //   180: new 598	gnu/mapping/WrongType
    //   183: dup_x1
    //   184: swap
    //   185: ldc_w 667
    //   188: iconst_1
    //   189: aload_2
    //   190: invokespecial 603	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   193: athrow
    //   194: new 598	gnu/mapping/WrongType
    //   197: dup_x1
    //   198: swap
    //   199: ldc_w 425
    //   202: iconst_1
    //   203: aload_2
    //   204: invokespecial 603	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   207: athrow
    //   208: new 598	gnu/mapping/WrongType
    //   211: dup_x1
    //   212: swap
    //   213: ldc_w 679
    //   216: iconst_1
    //   217: aload_2
    //   218: invokespecial 603	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   221: athrow
    //   222: new 598	gnu/mapping/WrongType
    //   225: dup_x1
    //   226: swap
    //   227: ldc_w 685
    //   230: iconst_1
    //   231: aload_2
    //   232: invokespecial 603	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   235: athrow
    //   236: new 598	gnu/mapping/WrongType
    //   239: dup_x1
    //   240: swap
    //   241: ldc_w 685
    //   244: iconst_2
    //   245: aload_3
    //   246: invokespecial 603	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   249: athrow
    //   250: new 598	gnu/mapping/WrongType
    //   253: dup_x1
    //   254: swap
    //   255: ldc_w 691
    //   258: iconst_1
    //   259: aload_2
    //   260: invokespecial 603	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   263: athrow
    //   264: new 598	gnu/mapping/WrongType
    //   267: dup_x1
    //   268: swap
    //   269: ldc_w 691
    //   272: iconst_2
    //   273: aload_3
    //   274: invokespecial 603	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   277: athrow
    //   278: new 598	gnu/mapping/WrongType
    //   281: dup_x1
    //   282: swap
    //   283: ldc_w 697
    //   286: iconst_1
    //   287: aload_2
    //   288: invokespecial 603	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   291: athrow
    //   292: new 598	gnu/mapping/WrongType
    //   295: dup_x1
    //   296: swap
    //   297: ldc_w 697
    //   300: iconst_2
    //   301: aload_3
    //   302: invokespecial 603	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   305: athrow
    // Line number table:
    //   Java source line #68	-> byte code offset #64
    //   Java source line #99	-> byte code offset #90
    //   Java source line #116	-> byte code offset #104
    //   Java source line #119	-> byte code offset #116
    //   Java source line #122	-> byte code offset #131
    //   Java source line #125	-> byte code offset #152
    //   Java source line #68	-> byte code offset #180
    //   Java source line #99	-> byte code offset #194
    //   Java source line #116	-> byte code offset #208
    //   Java source line #119	-> byte code offset #222
    //   Java source line #122	-> byte code offset #250
    //   Java source line #125	-> byte code offset #278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	misc
    //   0	306	1	paramModuleMethod	ModuleMethod
    //   0	306	2	paramObject1	Object
    //   0	306	3	paramObject2	Object
    //   180	1	4	localClassCastException1	ClassCastException
    //   194	1	5	localClassCastException2	ClassCastException
    //   208	1	6	localClassCastException3	ClassCastException
    //   222	1	7	localClassCastException4	ClassCastException
    //   236	1	8	localClassCastException5	ClassCastException
    //   250	1	9	localClassCastException6	ClassCastException
    //   264	1	10	localClassCastException7	ClassCastException
    //   278	1	11	localClassCastException8	ClassCastException
    //   292	1	12	localClassCastException9	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   70	73	180	java/lang/ClassCastException
    //   96	99	194	java/lang/ClassCastException
    //   105	108	208	java/lang/ClassCastException
    //   117	120	222	java/lang/ClassCastException
    //   121	124	236	java/lang/ClassCastException
    //   132	135	250	java/lang/ClassCastException
    //   142	145	264	java/lang/ClassCastException
    //   153	156	278	java/lang/ClassCastException
    //   162	165	292	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 517	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+214->218, 2:+44->48, 5:+93->97, 14:+162->166, 37:+167->171
    //   48: aload_2
    //   49: iconst_0
    //   50: aaload
    //   51: aload_2
    //   52: iconst_1
    //   53: aaload
    //   54: aload_2
    //   55: arraylength
    //   56: iconst_2
    //   57: isub
    //   58: istore_3
    //   59: iload_3
    //   60: anewarray 127	java/lang/Object
    //   63: goto +11 -> 74
    //   66: dup
    //   67: iload_3
    //   68: aload_2
    //   69: iload_3
    //   70: iconst_2
    //   71: iadd
    //   72: aaload
    //   73: aastore
    //   74: iinc 3 -1
    //   77: iload_3
    //   78: ifge -12 -> 66
    //   81: invokestatic 721	kawa/lib/misc:isBoolean$Eq	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   84: ifeq +9 -> 93
    //   87: getstatic 16	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   90: goto +6 -> 96
    //   93: getstatic 19	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   96: areturn
    //   97: aload_2
    //   98: iconst_0
    //   99: aaload
    //   100: ldc 27
    //   102: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   105: dup
    //   106: astore_3
    //   107: checkcast 27	gnu/mapping/Symbol
    //   110: aload_2
    //   111: iconst_1
    //   112: aaload
    //   113: ldc 27
    //   115: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   118: dup
    //   119: astore_3
    //   120: checkcast 27	gnu/mapping/Symbol
    //   123: aload_2
    //   124: arraylength
    //   125: iconst_2
    //   126: isub
    //   127: istore_3
    //   128: iload_3
    //   129: anewarray 127	java/lang/Object
    //   132: goto +11 -> 143
    //   135: dup
    //   136: iload_3
    //   137: aload_2
    //   138: iload_3
    //   139: iconst_2
    //   140: iadd
    //   141: aaload
    //   142: aastore
    //   143: iinc 3 -1
    //   146: iload_3
    //   147: ifge -12 -> 135
    //   150: invokestatic 727	kawa/lib/misc:isSymbol$Eq$V	(Lgnu/mapping/Symbol;Lgnu/mapping/Symbol;[Ljava/lang/Object;)Z
    //   153: ifeq +9 -> 162
    //   156: getstatic 16	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   159: goto +6 -> 165
    //   162: getstatic 19	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   165: areturn
    //   166: aload_2
    //   167: invokestatic 729	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   170: areturn
    //   171: aload_2
    //   172: iconst_0
    //   173: aaload
    //   174: ldc -73
    //   176: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   179: dup
    //   180: astore_3
    //   181: checkcast 183	gnu/expr/GenericProc
    //   184: aload_2
    //   185: arraylength
    //   186: iconst_1
    //   187: isub
    //   188: istore_3
    //   189: iload_3
    //   190: anewarray 127	java/lang/Object
    //   193: goto +11 -> 204
    //   196: dup
    //   197: iload_3
    //   198: aload_2
    //   199: iload_3
    //   200: iconst_1
    //   201: iadd
    //   202: aaload
    //   203: aastore
    //   204: iinc 3 -1
    //   207: iload_3
    //   208: ifge -12 -> 196
    //   211: invokestatic 735	kawa/lib/misc:addProcedureProperties	(Lgnu/expr/GenericProc;[Ljava/lang/Object;)V
    //   214: getstatic 257	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   217: areturn
    //   218: aload_0
    //   219: aload_1
    //   220: aload_2
    //   221: invokespecial 739	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   224: areturn
    //   225: new 598	gnu/mapping/WrongType
    //   228: dup_x1
    //   229: swap
    //   230: ldc_w 723
    //   233: iconst_1
    //   234: aload_3
    //   235: invokespecial 603	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   238: athrow
    //   239: new 598	gnu/mapping/WrongType
    //   242: dup_x1
    //   243: swap
    //   244: ldc_w 723
    //   247: iconst_2
    //   248: aload_3
    //   249: invokespecial 603	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   252: athrow
    //   253: new 598	gnu/mapping/WrongType
    //   256: dup_x1
    //   257: swap
    //   258: ldc_w 731
    //   261: iconst_1
    //   262: aload_3
    //   263: invokespecial 603	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   266: athrow
    // Line number table:
    //   Java source line #19	-> byte code offset #48
    //   Java source line #35	-> byte code offset #97
    //   Java source line #63	-> byte code offset #166
    //   Java source line #155	-> byte code offset #171
    //   Java source line #35	-> byte code offset #225
    //   Java source line #156	-> byte code offset #253
    // Exception table:
    //   from	to	target	type
    //   107	110	225	java/lang/ClassCastException
    //   120	123	239	java/lang/ClassCastException
    //   181	184	253	java/lang/ClassCastException
  }
}
