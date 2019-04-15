package kawa.lib; import gnu.mapping.Symbol;

public class exceptions extends gnu.expr.ModuleBody { public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$current$Mnhandler; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$ExceptionWithValue; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$or; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$let; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$try$Mnfinally; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$if; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$try$Mncatch; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$begin; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$quasiquote; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$primitive$Mnthrow; public static final gnu.expr.GenericProc with$Mnexception$Mnhandler; public static final gnu.expr.ModuleMethod raise; public static final gnu.expr.ModuleMethod raise$Mncontinuable; public static final kawa.lang.Macro guard; public static final kawa.lang.Macro guard$Mnaux; public static final gnu.expr.ModuleMethod jdField_throw; public static final gnu.expr.ModuleMethod error; public static final gnu.expr.ModuleMethod jdField_catch; public static final gnu.expr.ModuleMethod error$Mnobject$Qu; public static final gnu.expr.ModuleMethod error$Mnobject$Mnmessage; public static final gnu.expr.ModuleMethod error$Mnobject$Mnirritants; public static final gnu.expr.ModuleMethod read$Mnerror$Qu; public static final gnu.expr.ModuleMethod file$Mnerror$Qu; static final gnu.expr.Keyword Lit0; public static exceptions $instance; static final gnu.mapping.SimpleSymbol Lit1; static final gnu.mapping.SimpleSymbol Lit2; static final gnu.mapping.SimpleSymbol Lit3; static final kawa.lang.SyntaxRules Lit4; static final gnu.mapping.SimpleSymbol Lit5; static final kawa.lang.SyntaxRules Lit6; static final gnu.mapping.SimpleSymbol Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final gnu.mapping.SimpleSymbol Lit9; static final gnu.mapping.SimpleSymbol Lit10; static final gnu.mapping.SimpleSymbol Lit11; static final gnu.mapping.SimpleSymbol Lit12; static final gnu.mapping.SimpleSymbol Lit13; static final gnu.mapping.SimpleSymbol Lit14; static final gnu.mapping.SimpleSymbol Lit15; static final gnu.mapping.SimpleSymbol Lit16; static final gnu.mapping.SimpleSymbol Lit17; static final Object[] Lit18; static final gnu.mapping.SimpleSymbol Lit19; static final gnu.mapping.SimpleSymbol Lit20; static final gnu.lists.PairWithPosition Lit21; static final Object[] Lit22; static final gnu.mapping.SimpleSymbol Lit23; static final gnu.mapping.SimpleSymbol Lit24; static final gnu.mapping.SimpleSymbol Lit25; static final gnu.mapping.SimpleSymbol Lit26; static final gnu.mapping.SimpleSymbol Lit27; static final gnu.lists.PairWithPosition Lit28; static final gnu.lists.PairWithPosition Lit29; static final gnu.lists.PairWithPosition Lit30; static final gnu.mapping.SimpleSymbol Lit31 = Symbol.valueOf("save"); private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
    







    with$Mnexception$Mnhandler
      .setProperty(Lit0, "gnu.kawa.functions.CompileMisc:validateApplyWithExceptionHandler");
  }
  
  static
  {
    Lit30 = gnu.lists.PairWithPosition.make(exceptions.Lit24 = Symbol.valueOf("$lookup$"), gnu.lists.Pair.make(exceptions.Lit25 = Symbol.valueOf("current-handler"), gnu.lists.Pair.make(gnu.lists.Pair.make(exceptions.Lit26 = Symbol.valueOf("quasiquote"), gnu.lists.Pair.make(Symbol.valueOf("set"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 200717);Lit29 = gnu.lists.PairWithPosition.make(Symbol.valueOf("primitive-throw"), exceptions.Lit28 = gnu.lists.PairWithPosition.make(exceptions.Lit27 = Symbol.valueOf("ex"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 213023), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 213006);Lit23 = Symbol.valueOf("begin");Lit22 = new Object[0];Lit21 = gnu.lists.PairWithPosition.make(exceptions.Lit17 = Symbol.valueOf("temp"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 274452);Lit20 = Symbol.valueOf("if");Lit19 = Symbol.valueOf("let"); gnu.mapping.SimpleSymbol tmp190_187 = Symbol.valueOf("=>");Lit16 = tmp190_187;(exceptions.Lit18 = new Object[1])[0] = tmp190_187;Lit15 = Symbol.valueOf("else");Lit14 = Symbol.valueOf("file-error?");Lit13 = Symbol.valueOf("read-error?");Lit12 = Symbol.valueOf("error-object-irritants");Lit11 = Symbol.valueOf("error-object-message");Lit10 = Symbol.valueOf("error-object?");Lit9 = Symbol.valueOf("catch");Lit8 = Symbol.valueOf("error");Lit7 = Symbol.valueOf("throw"); Object[] tmp284_281 = new Object[2]; Object[] tmp285_284 = tmp284_281;tmp285_284[0] = Lit15;tmp285_284[1] = Lit16; kawa.lang.SyntaxRule[] tmp301_298 = new kawa.lang.SyntaxRule[7]; kawa.lang.SyntaxRule[] tmp302_301 = tmp301_298;tmp302_301[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007L\f\002\f\017\r\027\020\b\b\b", new Object[] { Lit15 }, 3, "exceptions.scm:62"), "\001\001\003", "\021\030\004\t\013\b\025\023", new Object[] { Lit23 }, 1); kawa.lang.SyntaxRule[] tmp353_302 = tmp302_301; Object[] tmp386_383 = new Object[4]; Object[] tmp387_386 = tmp386_383;tmp387_386[0] = Lit19; Object[] tmp393_387 = tmp387_386;tmp393_387[1] = Lit17; Object[] tmp399_393 = tmp393_387;tmp399_393[2] = Lit20;tmp399_393[3] = Lit21;tmp353_302[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007<\f\017\f\002\f\027\b\b", Lit18, 3, "exceptions.scm:64"), "\001\001\001", "\021\030\0041\b\021\030\f\b\013\b\021\030\024\021\030\f!\t\023\030\034\b\003", tmp386_383, 0); kawa.lang.SyntaxRule[] tmp415_353 = tmp353_302; Object[] tmp448_445 = new Object[5]; Object[] tmp449_448 = tmp448_445;tmp449_448[0] = Lit19; Object[] tmp455_449 = tmp449_448;tmp455_449[1] = Lit17; Object[] tmp461_455 = tmp455_449;tmp461_455[2] = Lit20; Object[] tmp467_461 = tmp461_455;tmp467_461[3] = Lit21; gnu.mapping.SimpleSymbol tmp480_477 = Symbol.valueOf("guard-aux");Lit5 = tmp480_477;tmp467_461[4] = tmp480_477;tmp415_353[2] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007<\f\017\f\002\f\027\b\f\037\r' \b\b", Lit18, 5, "exceptions.scm:69"), "\001\001\001\001\003", "\021\030\0041\b\021\030\f\b\013\b\021\030\024\021\030\f!\t\023\030\034\b\021\030$\t\003\t\033\b%#", tmp448_445, 1); kawa.lang.SyntaxRule[] tmp490_415 = tmp415_353;tmp490_415[3] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\034\f\017\b\b", Lit22, 2, "exceptions.scm:75"), "\001\001", "\021\030\004\t\013\b\003", new Object[] { Symbol.valueOf("or") }, 0); kawa.lang.SyntaxRule[] tmp536_490 = tmp490_415; Object[] tmp569_566 = new Object[4]; Object[] tmp570_569 = tmp569_566;tmp570_569[0] = Lit19; Object[] tmp576_570 = tmp570_569;tmp576_570[1] = Lit17; Object[] tmp582_576 = tmp576_570;tmp582_576[2] = Lit20;tmp582_576[3] = Lit5;tmp536_490[4] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\034\f\017\b\f\027\r\037\030\b\b", Lit22, 4, "exceptions.scm:77"), "\001\001\001\003", "\021\030\0041\b\021\030\f\b\013\b\021\030\024\021\030\f\021\030\f\b\021\030\034\t\003\t\023\b\035\033", tmp569_566, 1); kawa.lang.SyntaxRule[] tmp598_536 = tmp536_490; Object[] tmp631_628 = new Object[2]; Object[] tmp632_631 = tmp631_628;tmp632_631[0] = Lit20;tmp632_631[1] = Lit23;tmp598_536[5] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007L\f\017\f\027\r\037\030\b\b\b", Lit22, 4, "exceptions.scm:82"), "\001\001\001\003", "\021\030\004\t\013A\021\030\f\t\023\b\035\033\b\003", tmp631_628, 1); Object[] tmp682_679 = new Object[3]; Object[] tmp683_682 = tmp682_679;tmp683_682[0] = Lit20; Object[] tmp689_683 = tmp683_682;tmp689_683[1] = Lit23;tmp689_683[2] = Lit5;tmp598_536[6] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007L\f\017\f\027\r\037\030\b\b\f'\r/(\b\b", Lit22, 6, "exceptions.scm:86"), "\001\001\001\003\001\003", "\021\030\004\t\013A\021\030\f\t\023\b\035\033\b\021\030\024\t\003\t#\b-+", tmp682_679, 1);Lit6 = new kawa.lang.SyntaxRules(tmp284_281, tmp301_298, 6, Lit5); kawa.lang.SyntaxRule[] tmp727_724 = new kawa.lang.SyntaxRule[1]; Object[] tmp761_758 = new Object[13]; Object[] tmp762_761 = tmp761_758;tmp762_761[0] = Lit19; Object[] tmp768_762 = tmp762_761;tmp768_762[1] = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit31, gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit24, gnu.lists.Pair.make(Lit25, gnu.lists.Pair.make(gnu.lists.Pair.make(Lit26, gnu.lists.Pair.make(Symbol.valueOf("get"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184339), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184338), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184338), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184332), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184331); Object[] tmp861_768 = tmp768_762;tmp861_768[2] = Symbol.valueOf("try-finally"); Object[] tmp870_861 = tmp861_768;tmp870_861[3] = Symbol.valueOf("try-catch"); Object[] tmp879_870 = tmp870_861;tmp879_870[4] = Lit23; Object[] tmp885_879 = tmp879_870;tmp885_879[5] = gnu.lists.PairWithPosition.make(Lit30, gnu.lists.PairWithPosition.make(null, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 200737), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 200716); Object[] tmp913_885 = tmp885_879;tmp913_885[6] = gnu.lists.PairWithPosition.make(Lit27, gnu.lists.PairWithPosition.make(Symbol.valueOf("gnu.kawa.util.ExitCalled"), gnu.lists.PairWithPosition.make(Lit29, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 213006), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 208910), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 208906); Object[] tmp959_913 = tmp913_885;tmp959_913[7] = Lit27; Object[] tmp966_959 = tmp959_913;tmp966_959[8] = Symbol.valueOf("java.lang.Throwable"); Object[] tmp976_966 = tmp966_959;tmp976_966[9] = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit24, gnu.lists.Pair.make(Symbol.valueOf("ExceptionWithValue"), gnu.lists.Pair.make(gnu.lists.Pair.make(Lit26, gnu.lists.Pair.make(Symbol.valueOf("unwrap"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 221210), Lit28, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 221209), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 221209); Object[] tmp1048_976 = tmp976_966;tmp1048_976[10] = Lit5; Object[] tmp1055_1048 = tmp1048_976;tmp1055_1048[11] = Lit29;tmp1055_1048[12] = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit30, gnu.lists.PairWithPosition.make(Lit31, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 237598), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 237577), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 237577);tmp727_724[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030<\f\007\r\017\b\b\b\f\027\r\037\030\b\b", Lit22, 4, "exceptions.scm:44"), "\001\003\001\003", "\021\030\004\021\030\f\b\021\030\024ũ\021\030\034Y\021\030$\021\030,\t\023\b\035\033\021\0304\b\021\030<\021\030D\b\021\030\004)\b\t\003\030L\b\021\030T\021\030\\\b\r\013\030d", tmp761_758, 1);Lit4 = new kawa.lang.SyntaxRules(Lit22, tmp727_724, 4, exceptions.Lit3 = Symbol.valueOf("guard"));Lit2 = Symbol.valueOf("raise-continuable");Lit1 = Symbol.valueOf("raise");Lit0 = gnu.expr.Keyword.make("validate-apply");$instance = new exceptions();$Prvt$current$Mnhandler = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.ExceptionClasses", "current$Mnhandler");$Prvt$ExceptionWithValue = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.ExceptionClasses", "ExceptionWithValue");
    $Prvt$or = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "or");$Prvt$let = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "let");
    $Prvt$try$Mnfinally = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.syntax", "try$Mnfinally");
    $Prvt$if = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.prim_syntax", "if");$Prvt$try$Mncatch = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.prim_syntax", "try$Mncatch");
    $Prvt$begin = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.begin", "begin");$Prvt$quasiquote = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lang.Quote", "quasiQuote");
    $Prvt$primitive$Mnthrow = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.reflect.Throw", "primitiveThrow"); void 
    


      tmp1272_1269 = new gnu.expr.GenericProc("with-exception-handler");
    
    exceptions $instance = $instance; void tmp1291_1288 = new gnu.expr.ModuleMethod($instance, 1, "with-exception-handler", 8194);tmp1291_1288.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm:12");tmp1272_1269.add(tmp1291_1288);with$Mnexception$Mnhandler = tmp1272_1269;exceptions localExceptions1 = $instance; void tmp1326_1323 = new gnu.expr.ModuleMethod(localExceptions1, 2, Lit1, 4097);tmp1326_1323.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:raiseValidateApply");raise = tmp1326_1323;raise$Mncontinuable = new gnu.expr.ModuleMethod(localExceptions1, 3, Lit2, 4097);guard = kawa.lang.Macro.make(Lit3, Lit4, "kawa.lib.exceptions");guard$Mnaux = kawa.lang.Macro.make(Lit5, Lit6, "kawa.lib.exceptions");throw = new gnu.expr.ModuleMethod(localExceptions1, 4, Lit7, 61440);error = new gnu.expr.ModuleMethod(localExceptions1, 5, Lit8, 61440);catch = new gnu.expr.ModuleMethod(localExceptions1, 6, Lit9, 12291);error$Mnobject$Qu = new gnu.expr.ModuleMethod(localExceptions1, 7, Lit10, 4097);error$Mnobject$Mnmessage = new gnu.expr.ModuleMethod(localExceptions1, 8, Lit11, 4097);error$Mnobject$Mnirritants = new gnu.expr.ModuleMethod(localExceptions1, 9, Lit12, 4097);read$Mnerror$Qu = new gnu.expr.ModuleMethod(localExceptions1, 10, Lit13, 4097);file$Mnerror$Qu = new gnu.expr.ModuleMethod(localExceptions1, 11, Lit14, 4097);$runBody$();
  }
  


  public static Object withExceptionHandler(gnu.mapping.Procedure handler, gnu.mapping.Procedure thunk)
  {
    HandlerLink link = HandlerLink.push(handler);
    Throwable localThrowable2;
    try { Object v = thunk.apply0();
      link.pop();
      Throwable ex; localThrowable2 = ex;
    } catch (Throwable localThrowable1) {
      throw link.handle(localThrowable1); } return localThrowable2;
  }
  

































































































  public int match1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 11:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 10: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 9: 
      Object tmp101_98 = gnu.mapping.Promise.force(paramObject, kawa.lang.NamedException.class);
      























































































































      if (!(tmp101_98 instanceof kawa.lang.NamedException)) return -786431; value1 = tmp101_98;proc = paramModuleMethod;pc = 1;return 0;
    case 8: 
      Object tmp134_131 = gnu.mapping.Promise.force(paramObject, kawa.lang.NamedException.class);
      




















































































































      if (!(tmp134_131 instanceof kawa.lang.NamedException)) return -786431; value1 = tmp134_131;proc = paramModuleMethod;pc = 1;return 0;
    case 7: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 3: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 2: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext);
  }
  
  public static gnu.bytecode.Type.NeverReturns raise(Object obj) { throw ExceptionWithValue.wrap(obj); }
  
  public static Object raiseContinuable(Object obj) {
    HandlerLink save = (HandlerLink)ExceptionClasses.current$Mnhandler.get();
    if (save == null) {
      throw gnu.expr.Special.reachedUnexpected;
    }
    
    ;;;;
    try {}finally { jsr 5; }
    ExceptionClasses.current$Mnhandler.set(save);ret;return localObject1;
  }
  






























































  public int matchN(gnu.expr.ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 5:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 4: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); }
  public static gnu.bytecode.Type.NeverReturns jdMethod_throw(Object... args) { int len = args.length;
    Object key; if (len > 0) {
      key = args[0];
      if (!misc.isSymbol(key)) {} }
    try { throw new kawa.lang.NamedException((Symbol)(localObject1 = gnu.mapping.Promise.force(key, Symbol.class)), args); } catch (ClassCastException localClassCastException) { Object localObject1; throw new gnu.mapping.WrongType(
      

        localClassCastException, "kawa.lang.NamedException.<init>(gnu.mapping.Symbol,java.lang.Object[])", 1, localObject1);
    }
    if (((key instanceof Throwable)) && (len == 1))
      gnu.kawa.reflect.Throw.doThrow(key);
    throw new kawa.lang.GenericError("bad arguments to throw");
  }
  
  public Object applyN(gnu.expr.ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (selector) {case 4:  return jdMethod_throw(paramArrayOfObject);
    









    case 5: 
      return error(paramArrayOfObject); } return super.applyN(paramModuleMethod, paramArrayOfObject); }
  public static gnu.bytecode.Type.NeverReturns error(Object... args) { throw kawa.lang.NamedException.makeError(args); }
  
  public static Object jdMethod_catch(Object key, gnu.mapping.Procedure thunk, gnu.mapping.Procedure handler) { Object localObject;
    try { kawa.lang.NamedException ex; localObject = thunk.apply0();
    } catch (kawa.lang.NamedException localNamedException1) {
      localObject = localNamedException1.applyHandler(key, handler); } return localObject;
  }
  
  public static boolean isErrorObject(Object obj) { return obj instanceof kawa.lang.NamedException; }
  
  public static Object errorObjectMessage(kawa.lang.NamedException err) {
    return err.getObjectMessage();
  }
  
  public static gnu.lists.LList errorObjectIrritants(kawa.lang.NamedException err) { return err.getObjectIrritants(); }
  
  public static boolean isReadError(Object obj) {
    return obj instanceof gnu.text.SyntaxException;
  }
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 2:  return raise(paramObject);
    


    case 3: 
      return raiseContinuable(paramObject);
    
















































































    case 7: 
      return isErrorObject(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    }
    try {
      return errorObjectMessage((kawa.lang.NamedException)gnu.mapping.Promise.force(paramObject, kawa.lang.NamedException.class)); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      







        localClassCastException1, "error-object-message", 1, paramObject);
    }
    try
    {
      return errorObjectIrritants((kawa.lang.NamedException)gnu.mapping.Promise.force(paramObject, kawa.lang.NamedException.class)); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "error-object-irritants", 1, paramObject);
    }
    
    return isReadError(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    

    return isFileError(paramObject) ? Boolean.TRUE : Boolean.FALSE;return super.apply1(paramModuleMethod, paramObject); }
  
  public static boolean isFileError(Object obj) { boolean x = obj instanceof java.io.FileNotFoundException;
    







    return (obj instanceof java.io.IOException) ? ((java.io.IOException)gnu.mapping.Promise.force(obj, java.io.IOException.class)).getMessage().startsWith("cannot delete") : x ? x : false;
  }
  
  public exceptions()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match2(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 373	gnu/expr/ModuleMethod:selector	I
    //   4: iconst_1
    //   5: if_icmpne +70 -> 75
    //   8: goto +3 -> 11
    //   11: aload 4
    //   13: aload_2
    //   14: ldc 72
    //   16: invokestatic 92	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   19: dup
    //   20: invokestatic 394	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   23: ifnull +6 -> 29
    //   26: goto +7 -> 33
    //   29: ldc_w 384
    //   32: ireturn
    //   33: putfield 377	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   36: aload 4
    //   38: aload_3
    //   39: ldc 72
    //   41: invokestatic 92	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   44: dup
    //   45: invokestatic 394	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   48: ifnull +6 -> 54
    //   51: goto +7 -> 58
    //   54: ldc_w 395
    //   57: ireturn
    //   58: putfield 398	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   61: aload 4
    //   63: aload_1
    //   64: putfield 380	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   67: aload 4
    //   69: iconst_2
    //   70: putfield 383	gnu/mapping/CallContext:pc	I
    //   73: iconst_0
    //   74: ireturn
    //   75: aload_0
    //   76: aload_1
    //   77: aload_2
    //   78: aload_3
    //   79: aload 4
    //   81: invokespecial 402	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   84: ireturn
    // Line number table:
    //   Java source line #12	-> byte code offset #11
  }
  
  /* Error */
  public int match3(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 373	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 6
    //   6: if_icmpne +77 -> 83
    //   9: goto +3 -> 12
    //   12: aload 5
    //   14: aload_2
    //   15: putfield 377	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   18: aload 5
    //   20: aload_3
    //   21: ldc 72
    //   23: invokestatic 92	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   26: dup
    //   27: invokestatic 394	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   30: ifnull +6 -> 36
    //   33: goto +7 -> 40
    //   36: ldc_w 395
    //   39: ireturn
    //   40: putfield 398	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   43: aload 5
    //   45: aload 4
    //   47: ldc 72
    //   49: invokestatic 92	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   52: dup
    //   53: invokestatic 394	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   56: ifnull +6 -> 62
    //   59: goto +7 -> 66
    //   62: ldc_w 403
    //   65: ireturn
    //   66: putfield 406	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   69: aload 5
    //   71: aload_1
    //   72: putfield 380	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   75: aload 5
    //   77: iconst_3
    //   78: putfield 383	gnu/mapping/CallContext:pc	I
    //   81: iconst_0
    //   82: ireturn
    //   83: aload_0
    //   84: aload_1
    //   85: aload_2
    //   86: aload_3
    //   87: aload 4
    //   89: aload 5
    //   91: invokespecial 410	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   94: ireturn
    // Line number table:
    //   Java source line #110	-> byte code offset #12
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply2(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 373	gnu/expr/ModuleMethod:selector	I
    //   4: iconst_1
    //   5: if_icmpne +28 -> 33
    //   8: goto +3 -> 11
    //   11: aload_2
    //   12: ldc 72
    //   14: invokestatic 92	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   17: invokestatic 460	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   20: aload_3
    //   21: ldc 72
    //   23: invokestatic 92	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   26: invokestatic 460	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   29: invokestatic 464	kawa/lib/exceptions:withExceptionHandler	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   32: areturn
    //   33: aload_0
    //   34: aload_1
    //   35: aload_2
    //   36: aload_3
    //   37: invokespecial 468	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: areturn
    //   41: new 96	gnu/mapping/WrongType
    //   44: dup_x1
    //   45: swap
    //   46: ldc -14
    //   48: iconst_1
    //   49: aload_2
    //   50: invokespecial 102	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   53: athrow
    //   54: new 96	gnu/mapping/WrongType
    //   57: dup_x1
    //   58: swap
    //   59: ldc -14
    //   61: iconst_2
    //   62: aload_3
    //   63: invokespecial 102	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   66: athrow
    // Line number table:
    //   Java source line #12	-> byte code offset #11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	exceptions
    //   0	67	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	67	2	paramObject1	Object
    //   0	67	3	paramObject2	Object
    //   41	1	4	localClassCastException1	ClassCastException
    //   54	1	5	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   17	20	41	java/lang/ClassCastException
    //   26	29	54	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 373	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 6
    //   6: if_icmpne +30 -> 36
    //   9: goto +3 -> 12
    //   12: aload_2
    //   13: aload_3
    //   14: ldc 72
    //   16: invokestatic 92	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   19: invokestatic 460	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   22: aload 4
    //   24: ldc 72
    //   26: invokestatic 92	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   29: invokestatic 460	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   32: invokestatic 472	kawa/lib/exceptions:catch	(Ljava/lang/Object;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   35: areturn
    //   36: aload_0
    //   37: aload_1
    //   38: aload_2
    //   39: aload_3
    //   40: aload 4
    //   42: invokespecial 476	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   45: areturn
    //   46: new 96	gnu/mapping/WrongType
    //   49: dup_x1
    //   50: swap
    //   51: ldc_w 469
    //   54: iconst_2
    //   55: aload_3
    //   56: invokespecial 102	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   59: athrow
    //   60: new 96	gnu/mapping/WrongType
    //   63: dup_x1
    //   64: swap
    //   65: ldc_w 469
    //   68: iconst_3
    //   69: aload 4
    //   71: invokespecial 102	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   74: athrow
    // Line number table:
    //   Java source line #110	-> byte code offset #12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	exceptions
    //   0	75	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	75	2	paramObject1	Object
    //   0	75	3	paramObject2	Object
    //   0	75	4	paramObject3	Object
    //   46	1	5	localClassCastException1	ClassCastException
    //   60	1	6	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   19	22	46	java/lang/ClassCastException
    //   29	32	60	java/lang/ClassCastException
  }
}
