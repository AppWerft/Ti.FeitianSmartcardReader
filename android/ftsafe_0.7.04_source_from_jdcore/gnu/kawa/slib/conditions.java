package gnu.kawa.slib;

import gnu.expr.ModuleMethod;

public class conditions extends gnu.expr.ModuleBody { public static final ModuleMethod make$Mncondition$Mntype;
  public static final ModuleMethod condition$Mntype$Qu;
  public static final ModuleMethod make$Mncondition;
  public static final ModuleMethod condition$Qu;
  public static final ModuleMethod condition$Mnhas$Mntype$Qu;
  public static final ModuleMethod condition$Mnref;
  public static final ModuleMethod message$Mncondition$Qu;
  public static final ModuleMethod serious$Mncondition$Qu;
  public static final ModuleMethod error$Qu;
  public static final ModuleMethod condition$Mnmessage;
  public static final ModuleMethod condition$Mntype$Mnfield$Mnsupertype;
  public static final ModuleMethod check$Mncondition$Mntype$Mnfield$Mnalist;
  public static final ModuleMethod make$Mncompound$Mncondition;
  public static final ModuleMethod extract$Mncondition;
  public static final kawa.lang.Macro define$Mncondition$Mntype;
  public static final kawa.lang.Macro condition;
  public static condition-type $Amcondition;
  public static condition-type $Ammessage;
  public static condition-type $Amserious;
  public static condition-type $Amerror;
  public static final int $Pcprovide$Pcsrfi$Mn35 = 123;
  public static final int $Pcprovide$Pccondition = 123;
  public static final int $Pcprovide$Pcconditions = 123;
  static final Class $Lscondition$Mntype$Gr;
  public static final Class $Prvt$$Lscondition$Gr;
  static final kawa.lang.Macro condition$Mntype$Mnfield$Mnalist;
  public static final ModuleMethod $Prvt$type$Mnfield$Mnalist$Mn$Grcondition;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final gnu.mapping.SimpleSymbol Lit1;
  static final gnu.lists.PairWithPosition Lit2;
  static final gnu.mapping.SimpleSymbol Lit3;
  static final gnu.mapping.SimpleSymbol Lit4; static final gnu.mapping.SimpleSymbol Lit5; public static conditions $instance; static final gnu.mapping.SimpleSymbol Lit6; static final gnu.mapping.SimpleSymbol Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final kawa.lang.SyntaxRules Lit9; static final gnu.mapping.SimpleSymbol Lit10; static final gnu.mapping.SimpleSymbol Lit11; static final gnu.mapping.SimpleSymbol Lit12; static final gnu.mapping.SimpleSymbol Lit13; static final gnu.mapping.SimpleSymbol Lit14; static final kawa.lang.SyntaxRules Lit15; static final gnu.mapping.SimpleSymbol Lit16; static final gnu.mapping.SimpleSymbol Lit17; static final gnu.mapping.SimpleSymbol Lit18; static final gnu.mapping.SimpleSymbol Lit19; static final kawa.lang.SyntaxRules Lit20; static final gnu.mapping.SimpleSymbol Lit21; static final gnu.mapping.SimpleSymbol Lit22;
  static { Lit29 = gnu.lists.PairWithPosition.make(Lit30, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 339996);Lit28 = gnu.mapping.Symbol.valueOf("quote");Lit27 = new Object[0];Lit26 = gnu.mapping.Symbol.valueOf("error?");Lit25 = gnu.mapping.Symbol.valueOf("serious-condition?");Lit24 = gnu.mapping.Symbol.valueOf("condition-message");Lit23 = gnu.mapping.Symbol.valueOf("message-condition?");Lit22 = gnu.mapping.Symbol.valueOf("check-condition-type-field-alist");Lit21 = gnu.mapping.Symbol.valueOf("type-field-alist->condition"); kawa.lang.SyntaxRule[] tmp108_105 = new kawa.lang.SyntaxRule[1]; Object[] tmp141_138 = new Object[4]; Object[] tmp142_141 = tmp141_138;tmp142_141[0] = Lit21; Object[] tmp148_142 = tmp142_141;tmp148_142[1] = gnu.mapping.Symbol.valueOf("list"); Object[] tmp157_148 = tmp148_142;tmp157_148[2] = gnu.mapping.Symbol.valueOf("cons");tmp157_148[3] = Lit28;tmp108_105[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030]\f\007-\f\017\f\027\b\b\020\b\000\030\b", Lit27, 3, "conditions.scm:183"), "\003\005\005", "\021\030\004\b\021\030\f\b\005\021\030\024\t\003\b\021\030\f\b\r\021\030\024)\021\030\034\b\013\b\023", tmp141_138, 2);Lit20 = new kawa.lang.SyntaxRules(Lit27, tmp108_105, 3, conditions.Lit19 = gnu.mapping.Symbol.valueOf("condition"));Lit18 = gnu.mapping.Symbol.valueOf("extract-condition");Lit17 = gnu.mapping.Symbol.valueOf("make-compound-condition");Lit16 = gnu.mapping.Symbol.valueOf("condition-ref"); kawa.lang.SyntaxRule[] tmp231_228 = new kawa.lang.SyntaxRule[1]; Object[] tmp264_261 = new Object[3]; Object[] tmp265_264 = tmp264_261;tmp265_264[0] = gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("$lookup$"), gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("*"), gnu.lists.Pair.make(gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("quasiquote"), gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf(".type-field-alist"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 593927); Object[] tmp319_265 = tmp265_264;tmp319_265[1] = gnu.mapping.Symbol.valueOf("as");tmp319_265[2] = gnu.mapping.Symbol.valueOf("<condition>");tmp231_228[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit27, 1, "conditions.scm:144"), "\001", "\021\030\004\b\021\030\f\021\030\024\b\003", tmp264_261, 0);Lit15 = new kawa.lang.SyntaxRules(Lit27, tmp231_228, 1, conditions.Lit14 = gnu.mapping.Symbol.valueOf("condition-type-field-alist"));Lit13 = gnu.mapping.Symbol.valueOf("condition-has-type?");Lit12 = gnu.mapping.Symbol.valueOf("make-condition");Lit11 = gnu.mapping.Symbol.valueOf("condition?");Lit10 = gnu.mapping.Symbol.valueOf("condition-type-field-supertype"); kawa.lang.SyntaxRule[] tmp405_402 = new kawa.lang.SyntaxRule[1]; Object[] tmp439_436 = new Object[13]; Object[] tmp440_439 = tmp439_436;tmp440_439[0] = gnu.mapping.Symbol.valueOf("begin"); Object[] tmp449_440 = tmp440_439;tmp449_440[1] = gnu.mapping.Symbol.valueOf("define"); Object[] tmp458_449 = tmp449_440; gnu.mapping.SimpleSymbol tmp466_463 = gnu.mapping.Symbol.valueOf("make-condition-type");Lit7 = tmp466_463;tmp458_449[2] = tmp466_463; Object[] tmp471_458 = tmp458_449;tmp471_458[3] = Lit28; Object[] tmp477_471 = tmp471_458;tmp477_471[4] = Lit29; Object[] tmp483_477 = tmp477_471;tmp483_477[5] = gnu.mapping.Symbol.valueOf("and"); Object[] tmp492_483 = tmp483_477;tmp492_483[6] = gnu.lists.PairWithPosition.make(Lit11, Lit29, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 344079); Object[] tmp511_492 = tmp492_483;tmp511_492[7] = Lit13; Object[] tmp518_511 = tmp511_492;tmp518_511[8] = Lit30; Object[] tmp525_518 = tmp518_511;tmp525_518[9] = gnu.lists.PairWithPosition.make(Lit19, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 352284); Object[] tmp544_525 = tmp525_518;tmp544_525[10] = Lit16; Object[] tmp551_544 = tmp544_525;tmp551_544[11] = Lit18;tmp551_544[12] = Lit19;tmp405_402[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\f\027-\f\037\f'\b\030\020\b", Lit27, 5, "conditions.scm:76"), "\001\001\001\003\003", "\021\030\004É\021\030\f\t\003\b\021\030\024)\021\030\034\b\003\t\013\b\021\030\034\b\b\035\033Á\021\030\f!\t\023\030$\b\021\030,\021\0304\b\021\030<\021\030D\b\003\b%\021\030\f!\t#\030L\b\021\030TA\021\030\\\021\030d\b\003\b\021\030\034\b\033", tmp439_436, 1);Lit9 = new kawa.lang.SyntaxRules(Lit27, tmp405_402, 5, conditions.Lit8 = gnu.mapping.Symbol.valueOf("define-condition-type"));Lit6 = gnu.mapping.Symbol.valueOf("condition-type?");Lit5 = gnu.mapping.Symbol.valueOf("&error");Lit4 = gnu.mapping.Symbol.valueOf("&serious");Lit3 = gnu.mapping.Symbol.valueOf("message");Lit2 = gnu.lists.PairWithPosition.make(Lit3, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 937987);Lit1 = gnu.mapping.Symbol.valueOf("&message");Lit0 = gnu.mapping.Symbol.valueOf("&condition");$instance = new conditions();$Lscondition$Mntype$Gr = condition-type.class;conditions localConditions = $instance;condition$Mntype$Qu = new ModuleMethod(localConditions, 2, Lit6, 4097);make$Mncondition$Mntype = new ModuleMethod(localConditions, 3, Lit7, 12291);define$Mncondition$Mntype = kawa.lang.Macro.make(Lit8, Lit9, "gnu.kawa.slib.conditions");condition$Mntype$Mnfield$Mnsupertype = new ModuleMethod(localConditions, 4, Lit10, 8194);$Prvt$$Lscondition$Gr = condition.class;condition$Qu = new ModuleMethod(localConditions, 5, Lit11, 4097);make$Mncondition = new ModuleMethod(localConditions, 6, Lit12, 61441);condition$Mnhas$Mntype$Qu = new ModuleMethod(localConditions, 7, Lit13, 8194);condition$Mntype$Mnfield$Mnalist = kawa.lang.Macro.make(Lit14, Lit15, "gnu.kawa.slib.conditions");condition$Mnref = new ModuleMethod(localConditions, 8, Lit16, 8194);make$Mncompound$Mncondition = new ModuleMethod(localConditions, 9, Lit17, 61441);extract$Mncondition = new ModuleMethod(localConditions, 10, Lit18, 8194);condition = kawa.lang.Macro.make(Lit19, Lit20, "gnu.kawa.slib.conditions");$Prvt$type$Mnfield$Mnalist$Mn$Grcondition = new ModuleMethod(localConditions, 11, Lit21, 4097);check$Mncondition$Mntype$Mnfield$Mnalist = new ModuleMethod(localConditions, 12, Lit22, 4097);message$Mncondition$Qu = new ModuleMethod(localConditions, 13, Lit23, 4097);condition$Mnmessage = new ModuleMethod(localConditions, 14, Lit24, 4097);serious$Mncondition$Qu = new ModuleMethod(localConditions, 15, Lit25, 4097);error$Qu = new ModuleMethod(localConditions, 16, Lit26, 4097);$runBody$(); } static final gnu.mapping.SimpleSymbol Lit23; static final gnu.mapping.SimpleSymbol Lit24; static final gnu.mapping.SimpleSymbol Lit25; static final gnu.mapping.SimpleSymbol Lit26; static final Object[] Lit27; static final gnu.mapping.SimpleSymbol Lit28; static final gnu.lists.PairWithPosition Lit29; static final gnu.mapping.SimpleSymbol Lit30 = gnu.mapping.Symbol.valueOf("thing");
  


































































































































































































  public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 16:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 15: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 14: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 13: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 12: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 11: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 5: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 2: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
  public static boolean isConditionType(Object obj) { return obj instanceof condition-type; }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, gnu.mapping.CallContext paramCallContext) { if (selector == 3) { Object tmp20_17 = gnu.mapping.Promise.force(paramObject1, gnu.mapping.Symbol.class);
      




























































      if (!(tmp20_17 instanceof gnu.mapping.Symbol)) return -786431; value1 = tmp20_17; Object tmp42_39 = gnu.mapping.Promise.force(paramObject2, condition-type.class); if (!(tmp42_39 instanceof condition-type)) return -786430; value2 = tmp42_39;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0; } return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
  }
  
  public static condition-type makeConditionType(gnu.mapping.Symbol name, condition-type supertype, Object fields)
  {
    if (!kawa.lib.lists.isNull(srfi1.lsetIntersection$V(kawa.standard.Scheme.isEq, all$Mnfields, new Object[] { fields })))
    {

      throw gnu.expr.Special.reachedUnexpected;
    }
    return new condition-type(name, supertype, fields, kawa.standard.append.append$V(new Object[] { all$Mnfields, fields }));
  }
  

























































































  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 10:  Object tmp56_53 = gnu.mapping.Promise.force(paramObject1, condition.class);
      




































































































































































      if (!(tmp56_53 instanceof condition)) return -786431; value1 = tmp56_53; Object tmp78_75 = gnu.mapping.Promise.force(paramObject2, condition-type.class); if (!(tmp78_75 instanceof condition-type)) return -786430; value2 = tmp78_75;proc = paramModuleMethod;pc = 2;return 0;
    case 8: 
      Object tmp114_111 = gnu.mapping.Promise.force(paramObject1, condition.class);
      

















































































































































      if (!(tmp114_111 instanceof condition)) return -786431; value1 = tmp114_111;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 7: 
      value1 = paramObject1; Object tmp162_159 = gnu.mapping.Promise.force(paramObject2, condition-type.class); if (!(tmp162_159 instanceof condition-type)) return -786430; value2 = tmp162_159;proc = paramModuleMethod;pc = 2;return 0;
    case 4: 
      Object tmp198_195 = gnu.mapping.Promise.force(paramObject1, condition-type.class);
      
































































































      if (!(tmp198_195 instanceof condition-type)) return -786431; value1 = tmp198_195;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
  }
  












  public static boolean isCondition(Object obj)
  {
    return obj instanceof condition;
  }
  









































  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 9:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 6: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }
  
  public static Object lambda1label(Object plist)
  {
    try {
      return kawa.lib.lists.isNull(plist) ? gnu.lists.LList.Empty : kawa.lib.lists.cons(kawa.lib.lists.cons(kawa.lib.lists.car((gnu.lists.Pair)(localObject = gnu.mapping.Promise.force(plist, gnu.lists.Pair.class))), kawa.lib.lists.cadr(plist)), lambda1label(kawa.lib.lists.cddr(plist)));
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new gnu.mapping.WrongType(
      
        localClassCastException, "car", 1, localObject);
    }
  }
  




















  public static Object conditionRef(condition condition, Object field)
  {
    return typeFieldAlistRef(type$Mnfield$Mnalist, field);
  }
  



  public class frame
    extends gnu.expr.ModuleBody
  {
    condition-type type;
    


    final ModuleMethod lambda$Fn1;
    



    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (selector == 1) return lambda2(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
    
    /* Error */
    boolean lambda2(Object entry)
    {
      // Byte code:
      //   0: aload_1
      //   1: ldc 2
      //   3: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   6: dup
      //   7: astore_2
      //   8: checkcast 2	gnu/lists/Pair
      //   11: invokestatic 23	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   14: ldc 25
      //   16: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   19: dup
      //   20: astore_2
      //   21: checkcast 25	gnu/kawa/slib/condition-type
      //   24: aload_0
      //   25: getfield 33	gnu/kawa/slib/conditions$frame:type	Lgnu/kawa/slib/condition-type;
      //   28: invokestatic 39	gnu/kawa/slib/conditions:isConditionSubtype	(Lgnu/kawa/slib/condition-type;Lgnu/kawa/slib/condition-type;)Z
      //   31: ireturn
      //   32: new 12	gnu/mapping/WrongType
      //   35: dup_x1
      //   36: swap
      //   37: ldc 14
      //   39: iconst_1
      //   40: aload_2
      //   41: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   44: athrow
      //   45: new 12	gnu/mapping/WrongType
      //   48: dup_x1
      //   49: swap
      //   50: ldc 27
      //   52: iconst_0
      //   53: aload_2
      //   54: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   57: athrow
      // Line number table:
      //   Java source line #169	-> byte code offset #0
      //   Java source line #170	-> byte code offset #0
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	32	0	this	frame
      //   0	31	1	entry	Object
      //   7	47	2	localObject	Object
      //   32	1	3	localClassCastException1	ClassCastException
      //   45	1	4	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   8	11	32	java/lang/ClassCastException
      //   21	24	45	java/lang/ClassCastException
    }
    
    public frame()
    {
      void tmp18_15 = new ModuleMethod(this, 1, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm:169");
      lambda$Fn1 = tmp18_15;
    }
  }
  
  public static boolean isMessageCondition(Object thing)
  {
    return isCondition(thing) ? isConditionHasType(thing, $Ammessage) : false; } public static Object conditionMessage(Object condition) { try { return conditionRef(extractCondition((condition)(localObject = gnu.mapping.Promise.force(condition, condition.class)), $Ammessage), Lit3); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "extract-condition", 0, localObject);
    }
  }
  
  public static boolean isSeriousCondition(Object thing) { return isCondition(thing) ? isConditionHasType(thing, $Amserious) : false;
  }
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
    



































































































































































































    $Amcondition = new condition-type(Lit0, Boolean.FALSE, gnu.lists.LList.Empty, gnu.lists.LList.Empty);
    
    $Ammessage = makeConditionType(Lit1, $Amcondition, Lit2);
    


    $Amserious = makeConditionType(Lit4, $Amcondition, gnu.lists.LList.Empty);
    

    $Amerror = makeConditionType(Lit5, $Amserious, gnu.lists.LList.Empty); } public static boolean isError(Object thing) { return isCondition(thing) ? isConditionHasType(thing, $Amerror) : false;
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 2:  return isConditionType(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    




















































    case 5: 
      return isCondition(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    









































































    case 11: 
      return typeFieldAlist$To$Condition(paramObject);
    











    case 12: 
      return checkConditionTypeFieldAlist(paramObject);
    





















    case 13: 
      return isMessageCondition(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    case 14:  return conditionMessage(paramObject);
    
    case 15: 
      return isSeriousCondition(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    
    case 16: 
      return isError(paramObject) ? Boolean.TRUE : Boolean.FALSE; } return super.apply1(paramModuleMethod, paramObject);
  }
  
  /* Error */
  public static Object conditionTypeFieldSupertype(condition-type condition$Mntype, Object field)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore_2
    //   2: aload_2
    //   3: aconst_null
    //   4: if_acmpne +9 -> 13
    //   7: getstatic 67	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   10: goto +36 -> 46
    //   13: aload_1
    //   14: aload_2
    //   15: getfield 70	gnu/kawa/slib/condition-type:fields	Ljava/lang/Object;
    //   18: invokestatic 74	kawa/lib/lists:memq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   21: invokestatic 79	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   24: ifeq +7 -> 31
    //   27: aload_2
    //   28: goto +18 -> 46
    //   31: aload_2
    //   32: getfield 82	gnu/kawa/slib/condition-type:supertype	Ljava/lang/Object;
    //   35: ldc 13
    //   37: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   40: checkcast 13	gnu/kawa/slib/condition-type
    //   43: goto -42 -> 1
    //   46: areturn
    // Line number table:
    //   Java source line #98	-> byte code offset #0
    //   Java source line #100	-> byte code offset #0
    //   Java source line #101	-> byte code offset #2
    //   Java source line #102	-> byte code offset #13
    //   Java source line #103	-> byte code offset #27
    //   Java source line #105	-> byte code offset #31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	condition$Mntype	condition-type
    //   0	46	1	field	Object
    //   2	44	2	condition$Mntype	condition-type
  }
  
  /* Error */
  public static condition makeCondition$V(condition-type type, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 96	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 102	gnu/kawa/slib/conditions:lambda1label	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: astore_3
    //   13: getstatic 19	kawa/standard/Scheme:isEq	Lgnu/kawa/functions/IsEq;
    //   16: iconst_2
    //   17: anewarray 25	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: getfield 23	gnu/kawa/slib/condition-type:all$Mnfields	Ljava/lang/Object;
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: aload_3
    //   30: invokestatic 108	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   33: astore 4
    //   35: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   38: astore 5
    //   40: aconst_null
    //   41: astore 6
    //   43: aload 4
    //   45: invokeinterface 118 1 0
    //   50: ifeq +61 -> 111
    //   53: aload 4
    //   55: invokeinterface 122 1 0
    //   60: astore 7
    //   62: new 124	gnu/lists/Pair
    //   65: dup
    //   66: aload 7
    //   68: ldc 124
    //   70: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   73: dup
    //   74: astore 9
    //   76: checkcast 124	gnu/lists/Pair
    //   79: invokestatic 136	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   82: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   85: invokespecial 139	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   88: aload 6
    //   90: ifnonnull +9 -> 99
    //   93: dup
    //   94: astore 5
    //   96: goto +10 -> 106
    //   99: aload 6
    //   101: swap
    //   102: dup_x1
    //   103: invokevirtual 143	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   106: astore 6
    //   108: goto -65 -> 43
    //   111: aload 5
    //   113: aastore
    //   114: invokestatic 147	gnu/kawa/slib/srfi1:lset$Eq$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   117: invokestatic 79	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   120: ifne +19 -> 139
    //   123: iconst_1
    //   124: anewarray 25	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: ldc -107
    //   131: aastore
    //   132: invokestatic 45	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   135: getstatic 51	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   138: athrow
    //   139: new 90	gnu/kawa/slib/condition
    //   142: dup
    //   143: aload_0
    //   144: aload_3
    //   145: invokestatic 153	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   148: invokestatic 157	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   151: invokespecial 159	gnu/kawa/slib/condition:<init>	(Ljava/lang/Object;)V
    //   154: areturn
    //   155: new 128	gnu/mapping/WrongType
    //   158: dup_x1
    //   159: swap
    //   160: ldc -126
    //   162: iconst_1
    //   163: aload 9
    //   165: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   168: athrow
    // Line number table:
    //   Java source line #117	-> byte code offset #0
    //   Java source line #118	-> byte code offset #8
    //   Java source line #124	-> byte code offset #13
    //   Java source line #126	-> byte code offset #29
    //   Java source line #127	-> byte code offset #123
    //   Java source line #128	-> byte code offset #139
    //   Java source line #124	-> byte code offset #155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	type	condition-type
    //   0	154	1	argsArray	Object[]
    //   0	154	2	field$Mnplist	gnu.lists.LList
    //   13	141	3	alist	Object
    // Exception table:
    //   from	to	target	type
    //   76	79	155	java/lang/ClassCastException
  }
  
  /* Error */
  public static boolean isConditionHasType(Object condition, condition-type type)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 169	gnu/kawa/slib/conditions:conditionTypes	(Ljava/lang/Object;)Lgnu/lists/LList;
    //   4: astore_2
    //   5: aload_2
    //   6: ldc 124
    //   8: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   11: dup
    //   12: astore 4
    //   14: checkcast 124	gnu/lists/Pair
    //   17: invokestatic 136	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   20: ldc 13
    //   22: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   25: dup
    //   26: astore 4
    //   28: checkcast 13	gnu/kawa/slib/condition-type
    //   31: aload_1
    //   32: invokestatic 175	gnu/kawa/slib/conditions:isConditionSubtype	(Lgnu/kawa/slib/condition-type;Lgnu/kawa/slib/condition-type;)Z
    //   35: istore_3
    //   36: iload_3
    //   37: ifeq +7 -> 44
    //   40: iload_3
    //   41: goto +21 -> 62
    //   44: aload_2
    //   45: ldc 124
    //   47: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   50: dup
    //   51: astore 4
    //   53: checkcast 124	gnu/lists/Pair
    //   56: invokestatic 179	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   59: goto -55 -> 4
    //   62: ireturn
    //   63: new 128	gnu/mapping/WrongType
    //   66: dup_x1
    //   67: swap
    //   68: ldc -126
    //   70: iconst_1
    //   71: aload 4
    //   73: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   76: athrow
    //   77: new 128	gnu/mapping/WrongType
    //   80: dup_x1
    //   81: swap
    //   82: ldc -85
    //   84: iconst_0
    //   85: aload 4
    //   87: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   90: athrow
    //   91: new 128	gnu/mapping/WrongType
    //   94: dup_x1
    //   95: swap
    //   96: ldc -79
    //   98: iconst_1
    //   99: aload 4
    //   101: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   104: athrow
    // Line number table:
    //   Java source line #130	-> byte code offset #0
    //   Java source line #131	-> byte code offset #0
    //   Java source line #132	-> byte code offset #5
    //   Java source line #133	-> byte code offset #44
    //   Java source line #132	-> byte code offset #63
    //   Java source line #133	-> byte code offset #91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	condition	Object
    //   0	62	1	type	condition-type
    //   5	57	2	types	Object
    //   36	26	3	x	boolean
    // Exception table:
    //   from	to	target	type
    //   14	17	63	java/lang/ClassCastException
    //   28	31	77	java/lang/ClassCastException
    //   53	56	91	java/lang/ClassCastException
  }
  
  /* Error */
  static gnu.lists.LList conditionTypes(Object condition)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 90
    //   3: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: checkcast 90	gnu/kawa/slib/condition
    //   9: getfield 182	gnu/kawa/slib/condition:type$Mnfield$Mnalist	Ljava/lang/Object;
    //   12: invokestatic 108	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   15: astore_1
    //   16: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   19: astore_2
    //   20: aconst_null
    //   21: astore_3
    //   22: aload_1
    //   23: invokeinterface 118 1 0
    //   28: ifeq +56 -> 84
    //   31: aload_1
    //   32: invokeinterface 122 1 0
    //   37: astore 4
    //   39: new 124	gnu/lists/Pair
    //   42: dup
    //   43: aload 4
    //   45: ldc 124
    //   47: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   50: dup
    //   51: astore 6
    //   53: checkcast 124	gnu/lists/Pair
    //   56: invokestatic 136	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   59: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   62: invokespecial 139	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   65: aload_3
    //   66: ifnonnull +8 -> 74
    //   69: dup
    //   70: astore_2
    //   71: goto +9 -> 80
    //   74: aload_3
    //   75: swap
    //   76: dup_x1
    //   77: invokevirtual 143	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   80: astore_3
    //   81: goto -59 -> 22
    //   84: aload_2
    //   85: areturn
    //   86: new 128	gnu/mapping/WrongType
    //   89: dup_x1
    //   90: swap
    //   91: ldc -126
    //   93: iconst_1
    //   94: aload 6
    //   96: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   99: athrow
    // Line number table:
    //   Java source line #201	-> byte code offset #0
    //   Java source line #202	-> byte code offset #0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	condition	Object
    // Exception table:
    //   from	to	target	type
    //   53	56	86	java/lang/ClassCastException
  }
  
  /* Error */
  static boolean isConditionSubtype(condition-type subtype, condition-type supertype)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore_2
    //   2: aload_2
    //   3: aconst_null
    //   4: if_acmpne +7 -> 11
    //   7: iconst_0
    //   8: goto +27 -> 35
    //   11: aload_2
    //   12: aload_1
    //   13: if_acmpne +7 -> 20
    //   16: iconst_1
    //   17: goto +18 -> 35
    //   20: aload_2
    //   21: getfield 82	gnu/kawa/slib/condition-type:supertype	Ljava/lang/Object;
    //   24: ldc 13
    //   26: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   29: checkcast 13	gnu/kawa/slib/condition-type
    //   32: goto -31 -> 1
    //   35: ireturn
    // Line number table:
    //   Java source line #91	-> byte code offset #0
    //   Java source line #92	-> byte code offset #0
    //   Java source line #93	-> byte code offset #2
    //   Java source line #96	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	subtype	condition-type
    //   0	35	1	supertype	condition-type
    //   2	33	2	subtype	condition-type
  }
  
  /* Error */
  static Object typeFieldAlistRef(Object type$Mnfield$Mnalist, Object field)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore_2
    //   2: aload_2
    //   3: invokestatic 37	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   6: ifeq +28 -> 34
    //   9: iconst_3
    //   10: anewarray 25	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 298
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_2
    //   22: aastore
    //   23: dup
    //   24: iconst_2
    //   25: aload_1
    //   26: aastore
    //   27: invokestatic 45	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   30: getstatic 51	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   33: athrow
    //   34: aload_1
    //   35: aload_2
    //   36: ldc 124
    //   38: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   41: dup
    //   42: astore 4
    //   44: checkcast 124	gnu/lists/Pair
    //   47: invokestatic 136	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   50: ldc 124
    //   52: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   55: dup
    //   56: astore 4
    //   58: checkcast 124	gnu/lists/Pair
    //   61: invokestatic 179	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   64: invokestatic 227	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   67: astore_3
    //   68: aload_3
    //   69: invokestatic 79	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   72: ifeq +21 -> 93
    //   75: aload_3
    //   76: ldc 124
    //   78: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   81: dup
    //   82: astore 4
    //   84: checkcast 124	gnu/lists/Pair
    //   87: invokestatic 179	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   90: goto +21 -> 111
    //   93: aload_2
    //   94: ldc 124
    //   96: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   99: dup
    //   100: astore 4
    //   102: checkcast 124	gnu/lists/Pair
    //   105: invokestatic 179	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   108: goto -107 -> 1
    //   111: areturn
    //   112: new 128	gnu/mapping/WrongType
    //   115: dup_x1
    //   116: swap
    //   117: ldc -126
    //   119: iconst_1
    //   120: aload 4
    //   122: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   125: athrow
    //   126: new 128	gnu/mapping/WrongType
    //   129: dup_x1
    //   130: swap
    //   131: ldc -79
    //   133: iconst_1
    //   134: aload 4
    //   136: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   139: athrow
    //   140: new 128	gnu/mapping/WrongType
    //   143: dup_x1
    //   144: swap
    //   145: ldc -79
    //   147: iconst_1
    //   148: aload 4
    //   150: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   153: athrow
    //   154: new 128	gnu/mapping/WrongType
    //   157: dup_x1
    //   158: swap
    //   159: ldc -79
    //   161: iconst_1
    //   162: aload 4
    //   164: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   167: athrow
    // Line number table:
    //   Java source line #151	-> byte code offset #0
    //   Java source line #152	-> byte code offset #0
    //   Java source line #153	-> byte code offset #2
    //   Java source line #154	-> byte code offset #9
    //   Java source line #156	-> byte code offset #34
    //   Java source line #153	-> byte code offset #68
    //   Java source line #157	-> byte code offset #75
    //   Java source line #10000	-> byte code offset #75
    //   Java source line #159	-> byte code offset #93
    //   Java source line #156	-> byte code offset #112
    //   Java source line #10000	-> byte code offset #140
    //   Java source line #159	-> byte code offset #154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	type$Mnfield$Mnalist	Object
    //   0	111	1	field	Object
    //   1	93	2	type$Mnfield$Mnalist	Object
    //   67	9	3	temp	Object
    //   42	121	4	localObject1	Object
    //   112	1	5	localClassCastException1	ClassCastException
    //   126	1	6	localClassCastException2	ClassCastException
    //   140	1	7	localClassCastException3	ClassCastException
    //   154	1	8	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   44	47	112	java/lang/ClassCastException
    //   58	61	126	java/lang/ClassCastException
    //   84	87	140	java/lang/ClassCastException
    //   102	105	154	java/lang/ClassCastException
  }
  
  /* Error */
  public static condition makeCompoundCondition$V(Object condition$Mn1, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 96	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: getstatic 189	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   11: getstatic 193	kawa/standard/append:append	Lkawa/standard/append;
    //   14: aload_0
    //   15: aload_2
    //   16: invokestatic 153	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   19: invokestatic 108	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   22: astore 4
    //   24: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   27: astore 5
    //   29: aconst_null
    //   30: astore 6
    //   32: aload 4
    //   34: invokeinterface 118 1 0
    //   39: ifeq +56 -> 95
    //   42: aload 4
    //   44: invokeinterface 122 1 0
    //   49: astore 7
    //   51: new 124	gnu/lists/Pair
    //   54: dup
    //   55: getstatic 197	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   58: getstatic 201	gnu/kawa/slib/conditions:condition$Mntype$Mnfield$Mnalist	Lkawa/lang/Macro;
    //   61: aload 7
    //   63: invokevirtual 206	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   69: invokespecial 139	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   72: aload 6
    //   74: ifnonnull +9 -> 83
    //   77: dup
    //   78: astore 5
    //   80: goto +10 -> 90
    //   83: aload 6
    //   85: swap
    //   86: dup_x1
    //   87: invokevirtual 143	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   90: astore 6
    //   92: goto -60 -> 32
    //   95: aload 5
    //   97: invokevirtual 206	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: astore_3
    //   101: new 90	gnu/kawa/slib/condition
    //   104: dup
    //   105: aload_3
    //   106: invokespecial 159	gnu/kawa/slib/condition:<init>	(Ljava/lang/Object;)V
    //   109: areturn
    // Line number table:
    //   Java source line #161	-> byte code offset #0
    //   Java source line #162	-> byte code offset #8
    //   Java source line #163	-> byte code offset #8
    //   Java source line #164	-> byte code offset #14
    //   Java source line #163	-> byte code offset #58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	condition$Mn1	Object
    //   0	109	1	argsArray	Object[]
    //   0	109	2	conditions	gnu.lists.LList
  }
  
  /* Error */
  public static condition extractCondition(condition condition, condition-type type)
  {
    // Byte code:
    //   0: new 208	gnu/kawa/slib/conditions$frame
    //   3: dup
    //   4: invokespecial 211	gnu/kawa/slib/conditions$frame:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: putfield 215	gnu/kawa/slib/conditions$frame:type	Lgnu/kawa/slib/condition-type;
    //   13: aload_2
    //   14: getfield 219	gnu/kawa/slib/conditions$frame:lambda$Fn1	Lgnu/expr/ModuleMethod;
    //   17: aload_0
    //   18: getfield 182	gnu/kawa/slib/condition:type$Mnfield$Mnalist	Ljava/lang/Object;
    //   21: invokestatic 222	gnu/kawa/slib/srfi1:find	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: astore_3
    //   25: aload_3
    //   26: invokestatic 79	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   29: ifne +30 -> 59
    //   32: iconst_3
    //   33: anewarray 25	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc -32
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aload_0
    //   44: aastore
    //   45: dup
    //   46: iconst_2
    //   47: aload_2
    //   48: getfield 215	gnu/kawa/slib/conditions$frame:type	Lgnu/kawa/slib/condition-type;
    //   51: aastore
    //   52: invokestatic 45	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   55: getstatic 51	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   58: athrow
    //   59: aload_2
    //   60: getfield 215	gnu/kawa/slib/conditions$frame:type	Lgnu/kawa/slib/condition-type;
    //   63: aload_2
    //   64: getfield 215	gnu/kawa/slib/conditions$frame:type	Lgnu/kawa/slib/condition-type;
    //   67: getfield 23	gnu/kawa/slib/condition-type:all$Mnfields	Ljava/lang/Object;
    //   70: invokestatic 108	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   73: astore 5
    //   75: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   78: astore 6
    //   80: aconst_null
    //   81: astore 7
    //   83: aload 5
    //   85: invokeinterface 118 1 0
    //   90: ifeq +65 -> 155
    //   93: aload 5
    //   95: invokeinterface 122 1 0
    //   100: astore 8
    //   102: new 124	gnu/lists/Pair
    //   105: dup
    //   106: aload 8
    //   108: aload_3
    //   109: ldc 124
    //   111: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   114: dup
    //   115: astore 10
    //   117: checkcast 124	gnu/lists/Pair
    //   120: invokestatic 179	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   123: invokestatic 227	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   129: invokespecial 139	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   132: aload 7
    //   134: ifnonnull +9 -> 143
    //   137: dup
    //   138: astore 6
    //   140: goto +10 -> 150
    //   143: aload 7
    //   145: swap
    //   146: dup_x1
    //   147: invokevirtual 143	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   150: astore 7
    //   152: goto -69 -> 83
    //   155: aload 6
    //   157: invokestatic 153	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   160: invokestatic 157	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   163: astore 4
    //   165: new 90	gnu/kawa/slib/condition
    //   168: dup
    //   169: aload 4
    //   171: invokespecial 159	gnu/kawa/slib/condition:<init>	(Ljava/lang/Object;)V
    //   174: areturn
    //   175: new 128	gnu/mapping/WrongType
    //   178: dup_x1
    //   179: swap
    //   180: ldc -79
    //   182: iconst_1
    //   183: aload 10
    //   185: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   188: athrow
    // Line number table:
    //   Java source line #166	-> byte code offset #0
    //   Java source line #169	-> byte code offset #13
    //   Java source line #172	-> byte code offset #25
    //   Java source line #173	-> byte code offset #32
    //   Java source line #175	-> byte code offset #59
    //   Java source line #176	-> byte code offset #59
    //   Java source line #177	-> byte code offset #63
    //   Java source line #178	-> byte code offset #106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	condition	condition
    //   0	174	1	type	condition-type
    //   8	166	2	$heapFrame	frame
    //   25	149	3	entry	Object
    // Exception table:
    //   from	to	target	type
    //   117	120	175	java/lang/ClassCastException
  }
  
  /* Error */
  public static condition typeFieldAlist$To$Condition(Object type$Mnfield$Mnalist)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 108	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   4: astore_2
    //   5: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   8: astore_3
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_2
    //   13: invokeinterface 118 1 0
    //   18: ifeq +207 -> 225
    //   21: aload_2
    //   22: invokeinterface 122 1 0
    //   27: astore 5
    //   29: aload 5
    //   31: ldc 124
    //   33: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   36: dup
    //   37: astore 8
    //   39: checkcast 124	gnu/lists/Pair
    //   42: invokestatic 136	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   45: aload 5
    //   47: ldc 124
    //   49: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   52: dup
    //   53: astore 9
    //   55: checkcast 124	gnu/lists/Pair
    //   58: invokestatic 136	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   61: ldc 13
    //   63: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   66: checkcast 13	gnu/kawa/slib/condition-type
    //   69: getfield 23	gnu/kawa/slib/condition-type:all$Mnfields	Ljava/lang/Object;
    //   72: invokestatic 108	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   75: astore 8
    //   77: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   80: astore 9
    //   82: aconst_null
    //   83: astore 10
    //   85: aload 8
    //   87: invokeinterface 118 1 0
    //   92: ifeq +92 -> 184
    //   95: aload 8
    //   97: invokeinterface 122 1 0
    //   102: astore 11
    //   104: new 124	gnu/lists/Pair
    //   107: dup
    //   108: aload 11
    //   110: aload 5
    //   112: ldc 124
    //   114: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   117: dup
    //   118: astore 14
    //   120: checkcast 124	gnu/lists/Pair
    //   123: invokestatic 179	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   126: invokestatic 227	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   129: astore 13
    //   131: aload 13
    //   133: invokestatic 79	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   136: ifeq +8 -> 144
    //   139: aload 13
    //   141: goto +14 -> 155
    //   144: aload 11
    //   146: aload_0
    //   147: aload 11
    //   149: invokestatic 185	gnu/kawa/slib/conditions:typeFieldAlistRef	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: invokestatic 153	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   155: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   158: invokespecial 139	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   161: aload 10
    //   163: ifnonnull +9 -> 172
    //   166: dup
    //   167: astore 9
    //   169: goto +10 -> 179
    //   172: aload 10
    //   174: swap
    //   175: dup_x1
    //   176: invokevirtual 143	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   179: astore 10
    //   181: goto -96 -> 85
    //   184: aload 9
    //   186: invokestatic 153	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   189: astore 7
    //   191: new 124	gnu/lists/Pair
    //   194: dup
    //   195: aload 7
    //   197: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   200: invokespecial 139	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   203: aload 4
    //   205: ifnonnull +8 -> 213
    //   208: dup
    //   209: astore_3
    //   210: goto +10 -> 220
    //   213: aload 4
    //   215: swap
    //   216: dup_x1
    //   217: invokevirtual 143	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   220: astore 4
    //   222: goto -210 -> 12
    //   225: aload_3
    //   226: astore_1
    //   227: new 90	gnu/kawa/slib/condition
    //   230: dup
    //   231: aload_1
    //   232: invokespecial 159	gnu/kawa/slib/condition:<init>	(Ljava/lang/Object;)V
    //   235: areturn
    //   236: new 128	gnu/mapping/WrongType
    //   239: dup_x1
    //   240: swap
    //   241: ldc -126
    //   243: iconst_1
    //   244: aload 8
    //   246: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   249: athrow
    //   250: new 128	gnu/mapping/WrongType
    //   253: dup_x1
    //   254: swap
    //   255: ldc -126
    //   257: iconst_1
    //   258: aload 9
    //   260: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   263: athrow
    //   264: new 128	gnu/mapping/WrongType
    //   267: dup_x1
    //   268: swap
    //   269: ldc -79
    //   271: iconst_1
    //   272: aload 14
    //   274: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   277: athrow
    // Line number table:
    //   Java source line #190	-> byte code offset #0
    //   Java source line #191	-> byte code offset #0
    //   Java source line #192	-> byte code offset #0
    //   Java source line #199	-> byte code offset #0
    //   Java source line #193	-> byte code offset #29
    //   Java source line #194	-> byte code offset #45
    //   Java source line #195	-> byte code offset #108
    //   Java source line #196	-> byte code offset #144
    //   Java source line #197	-> byte code offset #146
    //   Java source line #193	-> byte code offset #236
    //   Java source line #194	-> byte code offset #250
    //   Java source line #195	-> byte code offset #264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	type$Mnfield$Mnalist	Object
    //   131	24	13	x	Object
    // Exception table:
    //   from	to	target	type
    //   39	42	236	java/lang/ClassCastException
    //   55	58	250	java/lang/ClassCastException
    //   120	123	264	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object checkConditionTypeFieldAlist(Object the$Mntype$Mnfield$Mnalist)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore_1
    //   2: aload_1
    //   3: invokestatic 37	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   6: ifne +341 -> 347
    //   9: aload_1
    //   10: ldc 124
    //   12: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   15: dup
    //   16: astore_3
    //   17: checkcast 124	gnu/lists/Pair
    //   20: invokestatic 136	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   23: astore_2
    //   24: aload_2
    //   25: ldc 124
    //   27: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   30: dup
    //   31: astore 4
    //   33: checkcast 124	gnu/lists/Pair
    //   36: invokestatic 136	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   39: ldc 13
    //   41: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   44: dup
    //   45: astore 4
    //   47: checkcast 13	gnu/kawa/slib/condition-type
    //   50: astore_3
    //   51: aload_2
    //   52: ldc 124
    //   54: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   57: dup
    //   58: astore 5
    //   60: checkcast 124	gnu/lists/Pair
    //   63: invokestatic 179	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   66: astore 4
    //   68: aload 4
    //   70: invokestatic 108	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   73: astore 6
    //   75: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   78: astore 7
    //   80: aconst_null
    //   81: astore 8
    //   83: aload 6
    //   85: invokeinterface 118 1 0
    //   90: ifeq +61 -> 151
    //   93: aload 6
    //   95: invokeinterface 122 1 0
    //   100: astore 9
    //   102: new 124	gnu/lists/Pair
    //   105: dup
    //   106: aload 9
    //   108: ldc 124
    //   110: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   113: dup
    //   114: astore 11
    //   116: checkcast 124	gnu/lists/Pair
    //   119: invokestatic 136	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   122: getstatic 112	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   125: invokespecial 139	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   128: aload 8
    //   130: ifnonnull +9 -> 139
    //   133: dup
    //   134: astore 7
    //   136: goto +10 -> 146
    //   139: aload 8
    //   141: swap
    //   142: dup_x1
    //   143: invokevirtual 143	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   146: astore 8
    //   148: goto -65 -> 83
    //   151: aload 7
    //   153: astore 5
    //   155: aload_3
    //   156: getfield 23	gnu/kawa/slib/condition-type:all$Mnfields	Ljava/lang/Object;
    //   159: astore 6
    //   161: getstatic 19	kawa/standard/Scheme:isEq	Lgnu/kawa/functions/IsEq;
    //   164: aload 6
    //   166: iconst_1
    //   167: anewarray 25	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload 5
    //   174: aastore
    //   175: invokestatic 231	gnu/kawa/slib/srfi1:lsetDifference$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   178: invokestatic 108	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   181: astore 7
    //   183: aload 7
    //   185: invokeinterface 118 1 0
    //   190: ifeq +139 -> 329
    //   193: aload 7
    //   195: invokeinterface 122 1 0
    //   200: astore 8
    //   202: aload_3
    //   203: aload 8
    //   205: invokestatic 235	gnu/kawa/slib/conditions:conditionTypeFieldSupertype	(Lgnu/kawa/slib/condition-type;Ljava/lang/Object;)Ljava/lang/Object;
    //   208: astore 9
    //   210: aload_0
    //   211: astore 10
    //   213: aload 10
    //   215: ldc 124
    //   217: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   220: dup
    //   221: astore 12
    //   223: checkcast 124	gnu/lists/Pair
    //   226: invokestatic 136	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   229: ldc 124
    //   231: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   234: dup
    //   235: astore 12
    //   237: checkcast 124	gnu/lists/Pair
    //   240: invokestatic 136	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   243: ldc 13
    //   245: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   248: dup
    //   249: astore 12
    //   251: checkcast 13	gnu/kawa/slib/condition-type
    //   254: aload 9
    //   256: ldc 13
    //   258: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   261: dup
    //   262: astore 12
    //   264: checkcast 13	gnu/kawa/slib/condition-type
    //   267: invokestatic 175	gnu/kawa/slib/conditions:isConditionSubtype	(Lgnu/kawa/slib/condition-type;Lgnu/kawa/slib/condition-type;)Z
    //   270: istore 11
    //   272: iload 11
    //   274: ifeq +11 -> 285
    //   277: iload 11
    //   279: ifne -96 -> 183
    //   282: goto +22 -> 304
    //   285: aload 10
    //   287: ldc 124
    //   289: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   292: dup
    //   293: astore 12
    //   295: checkcast 124	gnu/lists/Pair
    //   298: invokestatic 179	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   301: goto -90 -> 211
    //   304: iconst_3
    //   305: anewarray 25	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: ldc -19
    //   312: aastore
    //   313: dup
    //   314: iconst_1
    //   315: aload_3
    //   316: aastore
    //   317: dup
    //   318: iconst_2
    //   319: aload 8
    //   321: aastore
    //   322: invokestatic 45	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   325: getstatic 51	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   328: athrow
    //   329: aload_1
    //   330: ldc 124
    //   332: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   335: dup
    //   336: astore 7
    //   338: checkcast 124	gnu/lists/Pair
    //   341: invokestatic 179	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   344: goto -343 -> 1
    //   347: getstatic 243	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   350: areturn
    //   351: new 128	gnu/mapping/WrongType
    //   354: dup_x1
    //   355: swap
    //   356: ldc -126
    //   358: iconst_1
    //   359: aload_3
    //   360: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   363: athrow
    //   364: new 128	gnu/mapping/WrongType
    //   367: dup_x1
    //   368: swap
    //   369: ldc -126
    //   371: iconst_1
    //   372: aload 4
    //   374: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   377: athrow
    //   378: new 128	gnu/mapping/WrongType
    //   381: dup_x1
    //   382: swap
    //   383: ldc -28
    //   385: bipush -2
    //   387: aload 4
    //   389: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   392: athrow
    //   393: new 128	gnu/mapping/WrongType
    //   396: dup_x1
    //   397: swap
    //   398: ldc -79
    //   400: iconst_1
    //   401: aload 5
    //   403: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   406: athrow
    //   407: new 128	gnu/mapping/WrongType
    //   410: dup_x1
    //   411: swap
    //   412: ldc -126
    //   414: iconst_1
    //   415: aload 11
    //   417: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   420: athrow
    //   421: new 128	gnu/mapping/WrongType
    //   424: dup_x1
    //   425: swap
    //   426: ldc -126
    //   428: iconst_1
    //   429: aload 12
    //   431: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   434: athrow
    //   435: new 128	gnu/mapping/WrongType
    //   438: dup_x1
    //   439: swap
    //   440: ldc -126
    //   442: iconst_1
    //   443: aload 12
    //   445: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   448: athrow
    //   449: new 128	gnu/mapping/WrongType
    //   452: dup_x1
    //   453: swap
    //   454: ldc -85
    //   456: iconst_0
    //   457: aload 12
    //   459: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   462: athrow
    //   463: new 128	gnu/mapping/WrongType
    //   466: dup_x1
    //   467: swap
    //   468: ldc -85
    //   470: iconst_1
    //   471: aload 12
    //   473: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   476: athrow
    //   477: new 128	gnu/mapping/WrongType
    //   480: dup_x1
    //   481: swap
    //   482: ldc -79
    //   484: iconst_1
    //   485: aload 12
    //   487: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   490: athrow
    //   491: new 128	gnu/mapping/WrongType
    //   494: dup_x1
    //   495: swap
    //   496: ldc -79
    //   498: iconst_1
    //   499: aload 7
    //   501: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   504: athrow
    // Line number table:
    //   Java source line #204	-> byte code offset #0
    //   Java source line #205	-> byte code offset #0
    //   Java source line #206	-> byte code offset #2
    //   Java source line #207	-> byte code offset #9
    //   Java source line #208	-> byte code offset #24
    //   Java source line #207	-> byte code offset #51
    //   Java source line #209	-> byte code offset #51
    //   Java source line #207	-> byte code offset #68
    //   Java source line #210	-> byte code offset #68
    //   Java source line #207	-> byte code offset #155
    //   Java source line #212	-> byte code offset #161
    //   Java source line #222	-> byte code offset #161
    //   Java source line #213	-> byte code offset #202
    //   Java source line #214	-> byte code offset #202
    //   Java source line #215	-> byte code offset #210
    //   Java source line #216	-> byte code offset #210
    //   Java source line #217	-> byte code offset #213
    //   Java source line #218	-> byte code offset #285
    //   Java source line #219	-> byte code offset #304
    //   Java source line #223	-> byte code offset #329
    //   Java source line #207	-> byte code offset #351
    //   Java source line #208	-> byte code offset #364
    //   Java source line #209	-> byte code offset #393
    //   Java source line #210	-> byte code offset #407
    //   Java source line #217	-> byte code offset #421
    //   Java source line #218	-> byte code offset #477
    //   Java source line #223	-> byte code offset #491
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	the$Mntype$Mnfield$Mnalist	Object
    //   2	348	1	type$Mnfield$Mnalist	Object
    //   24	323	2	entry	Object
    //   51	296	3	type	condition-type
    //   68	279	4	field$Mnalist	Object
    //   155	192	5	fields	gnu.lists.LList
    //   161	186	6	all$Mnfields	Object
    //   210	119	9	supertype	Object
    //   213	91	10	alist	Object
    //   272	32	11	x	boolean
    // Exception table:
    //   from	to	target	type
    //   17	20	351	java/lang/ClassCastException
    //   33	36	364	java/lang/ClassCastException
    //   47	50	378	java/lang/ClassCastException
    //   60	63	393	java/lang/ClassCastException
    //   116	119	407	java/lang/ClassCastException
    //   223	226	421	java/lang/ClassCastException
    //   237	240	435	java/lang/ClassCastException
    //   251	254	449	java/lang/ClassCastException
    //   264	267	463	java/lang/ClassCastException
    //   295	298	477	java/lang/ClassCastException
    //   338	341	491	java/lang/ClassCastException
  }
  
  public conditions()
  {
    gnu.expr.ModuleInfo.register(this);
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
    //   1: getfield 453	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+120->124, 4:+44->48, 5:+120->124, 6:+120->124, 7:+58->62, 8:+84->88, 9:+120->124, 10:+98->102
    //   48: aload_2
    //   49: ldc 13
    //   51: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   54: checkcast 13	gnu/kawa/slib/condition-type
    //   57: aload_3
    //   58: invokestatic 235	gnu/kawa/slib/conditions:conditionTypeFieldSupertype	(Lgnu/kawa/slib/condition-type;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: areturn
    //   62: aload_2
    //   63: aload_3
    //   64: ldc 13
    //   66: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   69: checkcast 13	gnu/kawa/slib/condition-type
    //   72: invokestatic 271	gnu/kawa/slib/conditions:isConditionHasType	(Ljava/lang/Object;Lgnu/kawa/slib/condition-type;)Z
    //   75: ifeq +9 -> 84
    //   78: getstatic 502	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   81: goto +6 -> 87
    //   84: getstatic 67	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   87: areturn
    //   88: aload_2
    //   89: ldc 90
    //   91: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   94: checkcast 90	gnu/kawa/slib/condition
    //   97: aload_3
    //   98: invokestatic 284	gnu/kawa/slib/conditions:conditionRef	(Lgnu/kawa/slib/condition;Ljava/lang/Object;)Ljava/lang/Object;
    //   101: areturn
    //   102: aload_2
    //   103: ldc 90
    //   105: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   108: checkcast 90	gnu/kawa/slib/condition
    //   111: aload_3
    //   112: ldc 13
    //   114: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   117: checkcast 13	gnu/kawa/slib/condition-type
    //   120: invokestatic 277	gnu/kawa/slib/conditions:extractCondition	(Lgnu/kawa/slib/condition;Lgnu/kawa/slib/condition-type;)Lgnu/kawa/slib/condition;
    //   123: areturn
    //   124: aload_0
    //   125: aload_1
    //   126: aload_2
    //   127: aload_3
    //   128: invokespecial 534	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: areturn
    //   132: new 128	gnu/mapping/WrongType
    //   135: dup_x1
    //   136: swap
    //   137: ldc_w 527
    //   140: iconst_1
    //   141: aload_2
    //   142: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   145: athrow
    //   146: new 128	gnu/mapping/WrongType
    //   149: dup_x1
    //   150: swap
    //   151: ldc_w 529
    //   154: iconst_2
    //   155: aload_3
    //   156: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   159: athrow
    //   160: new 128	gnu/mapping/WrongType
    //   163: dup_x1
    //   164: swap
    //   165: ldc_w 531
    //   168: iconst_1
    //   169: aload_2
    //   170: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   173: athrow
    //   174: new 128	gnu/mapping/WrongType
    //   177: dup_x1
    //   178: swap
    //   179: ldc_w 273
    //   182: iconst_1
    //   183: aload_2
    //   184: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   187: athrow
    //   188: new 128	gnu/mapping/WrongType
    //   191: dup_x1
    //   192: swap
    //   193: ldc_w 273
    //   196: iconst_2
    //   197: aload_3
    //   198: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   201: athrow
    // Line number table:
    //   Java source line #98	-> byte code offset #48
    //   Java source line #130	-> byte code offset #62
    //   Java source line #147	-> byte code offset #88
    //   Java source line #166	-> byte code offset #102
    //   Java source line #98	-> byte code offset #132
    //   Java source line #130	-> byte code offset #146
    //   Java source line #147	-> byte code offset #160
    //   Java source line #166	-> byte code offset #174
    //   Java source line #167	-> byte code offset #188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	conditions
    //   0	202	1	paramModuleMethod	ModuleMethod
    //   0	202	2	paramObject1	Object
    //   0	202	3	paramObject2	Object
    //   132	1	4	localClassCastException1	ClassCastException
    //   146	1	5	localClassCastException2	ClassCastException
    //   160	1	6	localClassCastException3	ClassCastException
    //   174	1	7	localClassCastException4	ClassCastException
    //   188	1	8	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   54	57	132	java/lang/ClassCastException
    //   69	72	146	java/lang/ClassCastException
    //   94	97	160	java/lang/ClassCastException
    //   108	111	174	java/lang/ClassCastException
    //   117	120	188	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 453	gnu/expr/ModuleMethod:selector	I
    //   4: iconst_3
    //   5: if_icmpne +31 -> 36
    //   8: goto +3 -> 11
    //   11: aload_2
    //   12: ldc_w 478
    //   15: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: checkcast 478	gnu/mapping/Symbol
    //   21: aload_3
    //   22: ldc 13
    //   24: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   27: checkcast 13	gnu/kawa/slib/condition-type
    //   30: aload 4
    //   32: invokestatic 261	gnu/kawa/slib/conditions:makeConditionType	(Lgnu/mapping/Symbol;Lgnu/kawa/slib/condition-type;Ljava/lang/Object;)Lgnu/kawa/slib/condition-type;
    //   35: areturn
    //   36: aload_0
    //   37: aload_1
    //   38: aload_2
    //   39: aload_3
    //   40: aload 4
    //   42: invokespecial 540	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   45: areturn
    //   46: new 128	gnu/mapping/WrongType
    //   49: dup_x1
    //   50: swap
    //   51: ldc_w 536
    //   54: iconst_1
    //   55: aload_2
    //   56: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   59: athrow
    //   60: new 128	gnu/mapping/WrongType
    //   63: dup_x1
    //   64: swap
    //   65: ldc_w 536
    //   68: iconst_2
    //   69: aload_3
    //   70: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    // Line number table:
    //   Java source line #62	-> byte code offset #11
    //   Java source line #63	-> byte code offset #60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	conditions
    //   0	74	1	paramModuleMethod	ModuleMethod
    //   0	74	2	paramObject1	Object
    //   0	74	3	paramObject2	Object
    //   0	74	4	paramObject3	Object
    //   46	1	5	localClassCastException1	ClassCastException
    //   60	1	6	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   18	21	46	java/lang/ClassCastException
    //   27	30	60	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 453	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+110->114, 6:+32->36, 7:+110->114, 8:+110->114, 9:+76->80
    //   36: aload_2
    //   37: iconst_0
    //   38: aaload
    //   39: ldc 13
    //   41: invokestatic 88	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   44: dup
    //   45: astore_3
    //   46: checkcast 13	gnu/kawa/slib/condition-type
    //   49: aload_2
    //   50: arraylength
    //   51: iconst_1
    //   52: isub
    //   53: istore_3
    //   54: iload_3
    //   55: anewarray 25	java/lang/Object
    //   58: goto +11 -> 69
    //   61: dup
    //   62: iload_3
    //   63: aload_2
    //   64: iload_3
    //   65: iconst_1
    //   66: iadd
    //   67: aaload
    //   68: aastore
    //   69: iinc 3 -1
    //   72: iload_3
    //   73: ifge -12 -> 61
    //   76: invokestatic 546	gnu/kawa/slib/conditions:makeCondition$V	(Lgnu/kawa/slib/condition-type;[Ljava/lang/Object;)Lgnu/kawa/slib/condition;
    //   79: areturn
    //   80: aload_2
    //   81: iconst_0
    //   82: aaload
    //   83: aload_2
    //   84: arraylength
    //   85: iconst_1
    //   86: isub
    //   87: istore_3
    //   88: iload_3
    //   89: anewarray 25	java/lang/Object
    //   92: goto +11 -> 103
    //   95: dup
    //   96: iload_3
    //   97: aload_2
    //   98: iload_3
    //   99: iconst_1
    //   100: iadd
    //   101: aaload
    //   102: aastore
    //   103: iinc 3 -1
    //   106: iload_3
    //   107: ifge -12 -> 95
    //   110: invokestatic 550	gnu/kawa/slib/conditions:makeCompoundCondition$V	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/kawa/slib/condition;
    //   113: areturn
    //   114: aload_0
    //   115: aload_1
    //   116: aload_2
    //   117: invokespecial 554	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   120: areturn
    //   121: new 128	gnu/mapping/WrongType
    //   124: dup_x1
    //   125: swap
    //   126: ldc_w 542
    //   129: iconst_1
    //   130: aload_3
    //   131: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   134: athrow
    // Line number table:
    //   Java source line #117	-> byte code offset #36
    //   Java source line #161	-> byte code offset #80
    //   Java source line #117	-> byte code offset #121
    // Exception table:
    //   from	to	target	type
    //   46	49	121	java/lang/ClassCastException
  }
}
