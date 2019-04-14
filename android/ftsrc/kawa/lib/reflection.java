package kawa.lib; import gnu.expr.ModuleMethod;

public class reflection extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
  }
  
  static Object lambda2(Object form) {
    Object localObject1 = form;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(2, null);
    
    Object localObject3 = kawa.lang.TemplateScope.make();Object localObject2 = std_syntax.generateTemporaries(Lit2.execute(arrayOfObject, (kawa.lang.TemplateScope)localObject3));localObject3 = kawa.lang.SyntaxPattern.allocVars(3, arrayOfObject);
    
    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();return Lit1.match(form, arrayOfObject, 0) ? kawa.standard.syntax_case.error("syntax-case", localObject2) : Lit3.match(localObject2, (Object[])localObject3, 0) ? Lit4.execute((Object[])localObject3, localTemplateScope) : kawa.standard.syntax_case.error("syntax-case", form);
  }
  

  public static gnu.bytecode.ClassType makeRecordType(String name, gnu.lists.LList fnames)
  {
    return kawa.lang.Record.makeRecordType(name, fnames);
  }
  
  public static kawa.lang.RecordConstructor recordConstructor(gnu.bytecode.ClassType cl, Object flds) { return new kawa.lang.RecordConstructor(cl, flds); }
  
  public static kawa.lang.GetFieldProc recordAccessor(gnu.bytecode.ClassType class, String fname) {
    return new kawa.lang.GetFieldProc(class, fname);
  }
  
  public static kawa.lang.SetFieldProc recordModifier(gnu.bytecode.ClassType class, String fname) { return new kawa.lang.SetFieldProc(class, fname); }
  

  public static boolean isRecord(Object obj) { return obj instanceof kawa.lang.Record; }
  
  public static gnu.mapping.Procedure recordPredicate(Object rtype) { frame $heapFrame = new frame();rtype = rtype;
    return lambda$Fn1; } public class frame extends gnu.expr.ModuleBody { public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 1) return lambda1(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
    
    boolean lambda1(Object object) { try { return ((gnu.bytecode.Type)(localObject = gnu.mapping.Promise.force(rtype, gnu.bytecode.Type.class))).isInstance(object); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "gnu.bytecode.Type.isInstance(java.lang.Object)", 1, localObject); } }
    
    Object rtype;
    final ModuleMethod lambda$Fn1;
    public frame() { void tmp18_15 = new ModuleMethod(this, 1, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/reflection.scm:30");
      lambda$Fn1 = tmp18_15; } }
  
  public static gnu.bytecode.Type recordTypeDescriptor(Object object) { return gnu.bytecode.Type.make(object.getClass()); }
  
  public static String recordTypeName(gnu.bytecode.ClassType rtd) {
    return gnu.expr.Mangling.demangleName(rtd.getName(), true);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {} try { return recordConstructor(gnu.kawa.lispexpr.LangObjType.coerceToClassType(gnu.mapping.Promise.force(paramObject, gnu.bytecode.ClassType.class))); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      
























        localClassCastException1, "record-constructor", 1, paramObject);
    }
    return isRecord(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    

    return recordPredicate(paramObject);
    



    return recordTypeDescriptor(paramObject);
    


    try
    {
      return recordTypeName(gnu.kawa.lispexpr.LangObjType.coerceToClassType(gnu.mapping.Promise.force(paramObject, gnu.bytecode.ClassType.class))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "record-type-name", 1, paramObject);
    }
    
    return recordTypeFieldNames(paramObject);return lambda2(paramObject);return super.apply1(paramModuleMethod, paramObject);
  }
  
  public static gnu.lists.LList recordTypeFieldNames(Object rtd) { try { return kawa.lang.Record.typeFieldNames(gnu.kawa.lispexpr.LangObjType.coerceToClassType(localObject = gnu.mapping.Promise.force(rtd, gnu.bytecode.ClassType.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "kawa.lang.Record.typeFieldNames(class-type)", 1, localObject);
    }
  }
  

  public static final kawa.lang.Macro primitive$Mnconstructor;
  
  public static final ModuleMethod make$Mnrecord$Mntype;
  
  public static final ModuleMethod record$Mnconstructor;
  
  public static final ModuleMethod record$Mnaccessor;
  
  public static final ModuleMethod record$Mnmodifier;
  
  public static final ModuleMethod record$Qu;
  public static final ModuleMethod record$Mnpredicate;
  public static final ModuleMethod record$Mntype$Mndescriptor;
  public static final ModuleMethod record$Mntype$Mnname;
  public static final ModuleMethod record$Mntype$Mnfield$Mnnames;
  public static final kawa.lang.Macro primitive$Mnarray$Mnnew;
  public static final kawa.lang.Macro primitive$Mnarray$Mnset;
  public static final kawa.lang.Macro primitive$Mnarray$Mnget;
  public static final kawa.lang.Macro primitive$Mnarray$Mnlength;
  public static final kawa.lang.Macro primitive$Mnget$Mnfield;
  public static final kawa.lang.Macro primitive$Mnset$Mnfield;
  public static final kawa.lang.Macro primitive$Mnget$Mnstatic;
  public static final kawa.lang.Macro primitive$Mnset$Mnstatic;
  public static final ModuleMethod subtype$Qu;
  public static reflection $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final kawa.lang.SyntaxPattern Lit1;
  static final kawa.lang.SyntaxTemplate Lit2;
  static final kawa.lang.SyntaxPattern Lit3;
  static final kawa.lang.SyntaxTemplate Lit4;
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
  static final kawa.lang.SyntaxRules Lit15;
  static final gnu.mapping.SimpleSymbol Lit16;
  static final kawa.lang.SyntaxRules Lit17;
  static final gnu.mapping.SimpleSymbol Lit18;
  static final kawa.lang.SyntaxRules Lit19;
  static final gnu.mapping.SimpleSymbol Lit20;
  static final kawa.lang.SyntaxRules Lit21;
  static final gnu.mapping.SimpleSymbol Lit22;
  static final kawa.lang.SyntaxRules Lit23;
  static final gnu.mapping.SimpleSymbol Lit24;
  static final kawa.lang.SyntaxRules Lit25;
  static final gnu.mapping.SimpleSymbol Lit26;
  static final kawa.lang.SyntaxRules Lit27;
  static final gnu.mapping.SimpleSymbol Lit28;
  static final kawa.lang.SyntaxRules Lit29;
  static final gnu.mapping.SimpleSymbol Lit30;
  static final Object[] Lit31;
  static final gnu.mapping.SimpleSymbol Lit32;
  static final gnu.mapping.SimpleSymbol Lit33;
  static final gnu.lists.PairWithPosition Lit34;
  static final gnu.lists.PairWithPosition Lit35 = gnu.lists.PairWithPosition.make(gnu.math.IntNum.valueOf(1), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/reflection.scm", 397335);
  public static boolean isSubtype(gnu.bytecode.Type t1, gnu.bytecode.Type t2)
  {
    return t1.isSubtype(t2);
  }
  
  public static kawa.lang.RecordConstructor recordConstructor(gnu.bytecode.ClassType paramClassType)
  {
    return recordConstructor(paramClassType, null);
  }
  
  static
  {
    Lit34 = gnu.lists.PairWithPosition.make(gnu.math.IntNum.valueOf(9), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/reflection.scm", 450583);
    Lit33 = gnu.mapping.Symbol.valueOf("make");
    Lit32 = gnu.mapping.Symbol.valueOf("constant-fold");
    Lit31 = new Object[0];
    Lit30 = gnu.mapping.Symbol.valueOf("subtype?");
    kawa.lang.SyntaxRule[] tmp84_81 = new kawa.lang.SyntaxRule[1];
    Object[] tmp117_114 = new Object[4];
    Object[] tmp118_117 = tmp117_114;
    tmp118_117[0] = Lit32;
    Object[] tmp124_118 = tmp118_117;
    tmp124_118[1] = Lit33;
    Object[] tmp130_124 = tmp124_118;
    tmp130_124[2] = gnu.mapping.Symbol.valueOf("<gnu.kawa.reflect.StaticSet>");
    tmp130_124[3] = Lit34;
    tmp84_81[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\f\027\b", Lit31, 3, "reflection.scm:107"), "\001\001\001", "\021\030\004\021\030\f\021\030\024\t\003\t\013\t\023\030\034", tmp117_114, 0);
    Lit29 = new kawa.lang.SyntaxRules(Lit31, tmp84_81, 3, reflection.Lit28 = gnu.mapping.Symbol.valueOf("primitive-set-static"));
    kawa.lang.SyntaxRule[] tmp177_174 = new kawa.lang.SyntaxRule[1];
    Object[] tmp210_207 = new Object[4];
    Object[] tmp211_210 = tmp210_207;
    tmp211_210[0] = Lit32;
    Object[] tmp217_211 = tmp211_210;
    tmp217_211[1] = Lit33;
    Object[] tmp223_217 = tmp217_211;
    tmp223_217[2] = gnu.mapping.Symbol.valueOf("<gnu.kawa.reflect.StaticGet>");
    tmp223_217[3] = Lit34;
    tmp177_174[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\f\027\b", Lit31, 3, "reflection.scm:101"), "\001\001\001", "\021\030\004\021\030\f\021\030\024\t\003\t\013\t\023\030\034", tmp210_207, 0);
    Lit27 = new kawa.lang.SyntaxRules(Lit31, tmp177_174, 3, reflection.Lit26 = gnu.mapping.Symbol.valueOf("primitive-get-static"));
    kawa.lang.SyntaxRule[] tmp270_267 = new kawa.lang.SyntaxRule[1];
    Object[] tmp303_300 = new Object[4];
    Object[] tmp304_303 = tmp303_300;
    tmp304_303[0] = Lit32;
    Object[] tmp310_304 = tmp304_303;
    tmp310_304[1] = Lit33;
    Object[] tmp316_310 = tmp310_304;
    tmp316_310[2] = gnu.mapping.Symbol.valueOf("<kawa.lang.SetFieldProc>");
    tmp316_310[3] = Lit35;
    tmp270_267[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\f\027\b", Lit31, 3, "reflection.scm:94"), "\001\001\001", "\021\030\004\021\030\f\021\030\024\t\003\t\013\t\023\030\034", tmp303_300, 0);
    Lit25 = new kawa.lang.SyntaxRules(Lit31, tmp270_267, 3, reflection.Lit24 = gnu.mapping.Symbol.valueOf("primitive-set-field"));
    kawa.lang.SyntaxRule[] tmp363_360 = new kawa.lang.SyntaxRule[1];
    Object[] tmp396_393 = new Object[4];
    Object[] tmp397_396 = tmp396_393;
    tmp397_396[0] = Lit32;
    Object[] tmp403_397 = tmp397_396;
    tmp403_397[1] = Lit33;
    Object[] tmp409_403 = tmp403_397;
    tmp409_403[2] = gnu.mapping.Symbol.valueOf("<kawa.lang.GetFieldProc>");
    tmp409_403[3] = Lit35;
    tmp363_360[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\f\027\b", Lit31, 3, "reflection.scm:88"), "\001\001\001", "\021\030\004\021\030\f\021\030\024\t\003\t\013\t\023\030\034", tmp396_393, 0);
    Lit23 = new kawa.lang.SyntaxRules(Lit31, tmp363_360, 3, reflection.Lit22 = gnu.mapping.Symbol.valueOf("primitive-get-field"));
    kawa.lang.SyntaxRule[] tmp456_453 = new kawa.lang.SyntaxRule[1];
    Object[] tmp489_486 = new Object[3];
    Object[] tmp490_489 = tmp489_486;
    tmp490_489[0] = Lit32;
    Object[] tmp496_490 = tmp490_489;
    tmp496_490[1] = Lit33;
    tmp496_490[2] = gnu.mapping.Symbol.valueOf("<gnu.kawa.reflect.ArrayLength>");
    tmp456_453[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit31, 1, "reflection.scm:83"), "\001", "\021\030\004\021\030\f\021\030\024\b\003", tmp489_486, 0);
    Lit21 = new kawa.lang.SyntaxRules(Lit31, tmp456_453, 1, reflection.Lit20 = gnu.mapping.Symbol.valueOf("primitive-array-length"));
    kawa.lang.SyntaxRule[] tmp543_540 = new kawa.lang.SyntaxRule[1];
    Object[] tmp576_573 = new Object[3];
    Object[] tmp577_576 = tmp576_573;
    tmp577_576[0] = Lit32;
    Object[] tmp583_577 = tmp577_576;
    tmp583_577[1] = Lit33;
    tmp583_577[2] = gnu.mapping.Symbol.valueOf("<gnu.kawa.reflect.ArrayGet>");
    tmp543_540[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit31, 1, "reflection.scm:77"), "\001", "\021\030\004\021\030\f\021\030\024\b\003", tmp576_573, 0);
    Lit19 = new kawa.lang.SyntaxRules(Lit31, tmp543_540, 1, reflection.Lit18 = gnu.mapping.Symbol.valueOf("primitive-array-get"));
    kawa.lang.SyntaxRule[] tmp630_627 = new kawa.lang.SyntaxRule[1];
    Object[] tmp663_660 = new Object[3];
    Object[] tmp664_663 = tmp663_660;
    tmp664_663[0] = Lit32;
    Object[] tmp670_664 = tmp664_663;
    tmp670_664[1] = Lit33;
    tmp670_664[2] = gnu.mapping.Symbol.valueOf("<gnu.kawa.reflect.ArraySet>");
    tmp630_627[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit31, 1, "reflection.scm:71"), "\001", "\021\030\004\021\030\f\021\030\024\b\003", tmp663_660, 0);
    Lit17 = new kawa.lang.SyntaxRules(Lit31, tmp630_627, 1, reflection.Lit16 = gnu.mapping.Symbol.valueOf("primitive-array-set"));
    kawa.lang.SyntaxRule[] tmp717_714 = new kawa.lang.SyntaxRule[1];
    Object[] tmp750_747 = new Object[3];
    Object[] tmp751_750 = tmp750_747;
    tmp751_750[0] = Lit32;
    Object[] tmp757_751 = tmp751_750;
    tmp757_751[1] = Lit33;
    tmp757_751[2] = gnu.mapping.Symbol.valueOf("<gnu.kawa.reflect.ArrayNew>");
    tmp717_714[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit31, 1, "reflection.scm:65"), "\001", "\021\030\004\021\030\f\021\030\024\b\003", tmp750_747, 0);
    Lit15 = new kawa.lang.SyntaxRules(Lit31, tmp717_714, 1, reflection.Lit14 = gnu.mapping.Symbol.valueOf("primitive-array-new"));
    Lit13 = gnu.mapping.Symbol.valueOf("record-type-field-names");
    Lit12 = gnu.mapping.Symbol.valueOf("record-type-name");
    Lit11 = gnu.mapping.Symbol.valueOf("record-type-descriptor");
    Lit10 = gnu.mapping.Symbol.valueOf("record-predicate");
    Lit9 = gnu.mapping.Symbol.valueOf("record?");
    Lit8 = gnu.mapping.Symbol.valueOf("record-modifier");
    Lit7 = gnu.mapping.Symbol.valueOf("record-accessor");
    Lit6 = gnu.mapping.Symbol.valueOf("record-constructor");
    Lit5 = gnu.mapping.Symbol.valueOf("make-record-type");
    Object[] tmp888_885 = new Object[4];
    Object[] tmp889_888 = tmp888_885;
    tmp889_888[0] = gnu.mapping.Symbol.valueOf("lambda");
    Object[] tmp898_889 = tmp889_888;
    tmp898_889[1] = gnu.mapping.Symbol.valueOf("::");
    Object[] tmp907_898 = tmp898_889;
    tmp907_898[2] = Lit33;
    tmp907_898[3] = gnu.mapping.Symbol.valueOf("as");
    Lit4 = new kawa.lang.SyntaxTemplate("\001\003\003", "\021\030\004\031\b\025\023\021\030\f\t\003\b\021\030\024\t\003\b\r\021\030\034\t\013\b\023", tmp888_885, 1);
    Lit3 = new kawa.lang.SyntaxPattern("\r\027\020\b\b", Lit31, 3, "reflection.scm:8");
    Lit2 = new kawa.lang.SyntaxTemplate("\001\003", "\b\r\013", Lit31, 1);
    Lit1 = new kawa.lang.SyntaxPattern("\f\030\f\007,\r\017\b\b\b\b", Lit31, 2, "reflection.scm:6");
    Lit0 = gnu.mapping.Symbol.valueOf("primitive-constructor");
    $instance = new reflection();
    reflection localReflection1 = $instance;
    primitive$Mnconstructor = kawa.lang.Macro.make(Lit0, new ModuleMethod(localReflection1, 2, null, 4097), "kawa.lib.reflection");
    reflection localReflection2 = $instance;
    make$Mnrecord$Mntype = new ModuleMethod(localReflection2, 3, Lit5, 8194);
    record$Mnconstructor = new ModuleMethod(localReflection2, 4, Lit6, 8193);
    record$Mnaccessor = new ModuleMethod(localReflection2, 6, Lit7, 8194);
    record$Mnmodifier = new ModuleMethod(localReflection2, 7, Lit8, 8194);
    record$Qu = new ModuleMethod(localReflection2, 8, Lit9, 4097);
    record$Mnpredicate = new ModuleMethod(localReflection2, 9, Lit10, 4097);
    record$Mntype$Mndescriptor = new ModuleMethod(localReflection2, 10, Lit11, 4097);
    record$Mntype$Mnname = new ModuleMethod(localReflection2, 11, Lit12, 4097);
    record$Mntype$Mnfield$Mnnames = new ModuleMethod(localReflection2, 12, Lit13, 4097);
    primitive$Mnarray$Mnnew = kawa.lang.Macro.make(Lit14, Lit15, "kawa.lib.reflection");
    primitive$Mnarray$Mnset = kawa.lang.Macro.make(Lit16, Lit17, "kawa.lib.reflection");
    primitive$Mnarray$Mnget = kawa.lang.Macro.make(Lit18, Lit19, "kawa.lib.reflection");
    primitive$Mnarray$Mnlength = kawa.lang.Macro.make(Lit20, Lit21, "kawa.lib.reflection");
    primitive$Mnget$Mnfield = kawa.lang.Macro.make(Lit22, Lit23, "kawa.lib.reflection");
    primitive$Mnset$Mnfield = kawa.lang.Macro.make(Lit24, Lit25, "kawa.lib.reflection");
    primitive$Mnget$Mnstatic = kawa.lang.Macro.make(Lit26, Lit27, "kawa.lib.reflection");
    primitive$Mnset$Mnstatic = kawa.lang.Macro.make(Lit28, Lit29, "kawa.lib.reflection");
    subtype$Qu = new ModuleMethod(localReflection2, 13, Lit30, 8194);
    $runBody$();
  }
  
  public reflection()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 327	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+217->221, 2:+60->64, 3:+217->221, 4:+181->185, 5:+217->221, 6:+217->221, 7:+217->221, 8:+164->168, 9:+147->151, 10:+130->134, 11:+94->98, 12:+77->81
    //   64: aload_3
    //   65: aload_2
    //   66: putfield 330	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   69: aload_3
    //   70: aload_1
    //   71: putfield 334	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   74: aload_3
    //   75: iconst_1
    //   76: putfield 337	gnu/mapping/CallContext:pc	I
    //   79: iconst_0
    //   80: ireturn
    //   81: aload_3
    //   82: aload_2
    //   83: putfield 330	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   86: aload_3
    //   87: aload_1
    //   88: putfield 334	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   91: aload_3
    //   92: iconst_1
    //   93: putfield 337	gnu/mapping/CallContext:pc	I
    //   96: iconst_0
    //   97: ireturn
    //   98: aload_3
    //   99: aload_2
    //   100: ldc 63
    //   102: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   105: dup
    //   106: invokestatic 340	gnu/kawa/lispexpr/LangObjType:coerceToClassTypeOrNull	(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
    //   109: ifnull +6 -> 115
    //   112: goto +7 -> 119
    //   115: ldc_w 341
    //   118: ireturn
    //   119: putfield 330	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   122: aload_3
    //   123: aload_1
    //   124: putfield 334	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   127: aload_3
    //   128: iconst_1
    //   129: putfield 337	gnu/mapping/CallContext:pc	I
    //   132: iconst_0
    //   133: ireturn
    //   134: aload_3
    //   135: aload_2
    //   136: putfield 330	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   139: aload_3
    //   140: aload_1
    //   141: putfield 334	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   144: aload_3
    //   145: iconst_1
    //   146: putfield 337	gnu/mapping/CallContext:pc	I
    //   149: iconst_0
    //   150: ireturn
    //   151: aload_3
    //   152: aload_2
    //   153: putfield 330	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   156: aload_3
    //   157: aload_1
    //   158: putfield 334	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   161: aload_3
    //   162: iconst_1
    //   163: putfield 337	gnu/mapping/CallContext:pc	I
    //   166: iconst_0
    //   167: ireturn
    //   168: aload_3
    //   169: aload_2
    //   170: putfield 330	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   173: aload_3
    //   174: aload_1
    //   175: putfield 334	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   178: aload_3
    //   179: iconst_1
    //   180: putfield 337	gnu/mapping/CallContext:pc	I
    //   183: iconst_0
    //   184: ireturn
    //   185: aload_3
    //   186: aload_2
    //   187: ldc 63
    //   189: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   192: dup
    //   193: invokestatic 340	gnu/kawa/lispexpr/LangObjType:coerceToClassTypeOrNull	(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
    //   196: ifnull +6 -> 202
    //   199: goto +7 -> 206
    //   202: ldc_w 341
    //   205: ireturn
    //   206: putfield 330	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   209: aload_3
    //   210: aload_1
    //   211: putfield 334	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   214: aload_3
    //   215: iconst_1
    //   216: putfield 337	gnu/mapping/CallContext:pc	I
    //   219: iconst_0
    //   220: ireturn
    //   221: aload_0
    //   222: aload_1
    //   223: aload_2
    //   224: aload_3
    //   225: invokespecial 345	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   228: ireturn
    // Line number table:
    //   Java source line #43	-> byte code offset #81
    //   Java source line #40	-> byte code offset #98
    //   Java source line #34	-> byte code offset #134
    //   Java source line #29	-> byte code offset #151
    //   Java source line #26	-> byte code offset #168
    //   Java source line #17	-> byte code offset #185
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 327	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+323->327, 3:+271->275, 4:+226->230, 5:+323->327, 6:+175->179, 7:+124->128, 8:+323->327, 9:+323->327, 10:+323->327, 11:+323->327, 12:+323->327, 13:+60->64
    //   64: aload 4
    //   66: aload_2
    //   67: ldc 57
    //   69: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   72: dup
    //   73: invokestatic 349	gnu/kawa/lispexpr/LangObjType:coerceToTypeOrNull	(Ljava/lang/Object;)Lgnu/bytecode/Type;
    //   76: ifnull +6 -> 82
    //   79: goto +7 -> 86
    //   82: ldc_w 341
    //   85: ireturn
    //   86: putfield 330	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   89: aload 4
    //   91: aload_3
    //   92: ldc 57
    //   94: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   97: dup
    //   98: invokestatic 349	gnu/kawa/lispexpr/LangObjType:coerceToTypeOrNull	(Ljava/lang/Object;)Lgnu/bytecode/Type;
    //   101: ifnull +6 -> 107
    //   104: goto +7 -> 111
    //   107: ldc_w 350
    //   110: ireturn
    //   111: putfield 353	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   114: aload 4
    //   116: aload_1
    //   117: putfield 334	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   120: aload 4
    //   122: iconst_2
    //   123: putfield 337	gnu/mapping/CallContext:pc	I
    //   126: iconst_0
    //   127: ireturn
    //   128: aload 4
    //   130: aload_2
    //   131: ldc 63
    //   133: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   136: dup
    //   137: invokestatic 340	gnu/kawa/lispexpr/LangObjType:coerceToClassTypeOrNull	(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
    //   140: ifnull +6 -> 146
    //   143: goto +7 -> 150
    //   146: ldc_w 341
    //   149: ireturn
    //   150: putfield 330	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   153: aload 4
    //   155: aload_3
    //   156: ldc_w 355
    //   159: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   162: putfield 353	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   165: aload 4
    //   167: aload_1
    //   168: putfield 334	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   171: aload 4
    //   173: iconst_2
    //   174: putfield 337	gnu/mapping/CallContext:pc	I
    //   177: iconst_0
    //   178: ireturn
    //   179: aload 4
    //   181: aload_2
    //   182: ldc 63
    //   184: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   187: dup
    //   188: invokestatic 340	gnu/kawa/lispexpr/LangObjType:coerceToClassTypeOrNull	(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
    //   191: ifnull +6 -> 197
    //   194: goto +7 -> 201
    //   197: ldc_w 341
    //   200: ireturn
    //   201: putfield 330	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   204: aload 4
    //   206: aload_3
    //   207: ldc_w 355
    //   210: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   213: putfield 353	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   216: aload 4
    //   218: aload_1
    //   219: putfield 334	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   222: aload 4
    //   224: iconst_2
    //   225: putfield 337	gnu/mapping/CallContext:pc	I
    //   228: iconst_0
    //   229: ireturn
    //   230: aload 4
    //   232: aload_2
    //   233: ldc 63
    //   235: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   238: dup
    //   239: invokestatic 340	gnu/kawa/lispexpr/LangObjType:coerceToClassTypeOrNull	(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
    //   242: ifnull +6 -> 248
    //   245: goto +7 -> 252
    //   248: ldc_w 341
    //   251: ireturn
    //   252: putfield 330	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   255: aload 4
    //   257: aload_3
    //   258: putfield 353	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   261: aload 4
    //   263: aload_1
    //   264: putfield 334	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   267: aload 4
    //   269: iconst_2
    //   270: putfield 337	gnu/mapping/CallContext:pc	I
    //   273: iconst_0
    //   274: ireturn
    //   275: aload 4
    //   277: aload_2
    //   278: ldc_w 355
    //   281: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   284: putfield 330	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   287: aload 4
    //   289: aload_3
    //   290: ldc_w 357
    //   293: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   296: dup
    //   297: instanceof 357
    //   300: ifeq +6 -> 306
    //   303: goto +7 -> 310
    //   306: ldc_w 350
    //   309: ireturn
    //   310: putfield 353	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   313: aload 4
    //   315: aload_1
    //   316: putfield 334	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   319: aload 4
    //   321: iconst_2
    //   322: putfield 337	gnu/mapping/CallContext:pc	I
    //   325: iconst_0
    //   326: ireturn
    //   327: aload_0
    //   328: aload_1
    //   329: aload_2
    //   330: aload_3
    //   331: aload 4
    //   333: invokespecial 361	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   336: ireturn
    // Line number table:
    //   Java source line #112	-> byte code offset #64
    //   Java source line #23	-> byte code offset #128
    //   Java source line #20	-> byte code offset #179
    //   Java source line #17	-> byte code offset #230
    //   Java source line #14	-> byte code offset #275
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
    //   1: getfield 327	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+205->209, 3:+60->64, 4:+93->97, 5:+205->209, 6:+107->111, 7:+139->143, 8:+205->209, 9:+205->209, 10:+205->209, 11:+205->209, 12:+205->209, 13:+171->175
    //   64: aload_2
    //   65: ldc_w 355
    //   68: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   71: dup
    //   72: ifnonnull +8 -> 80
    //   75: pop
    //   76: aconst_null
    //   77: goto +6 -> 83
    //   80: invokevirtual 409	java/lang/Object:toString	()Ljava/lang/String;
    //   83: aload_3
    //   84: ldc_w 357
    //   87: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   90: checkcast 357	gnu/lists/LList
    //   93: invokestatic 412	kawa/lib/reflection:makeRecordType	(Ljava/lang/String;Lgnu/lists/LList;)Lgnu/bytecode/ClassType;
    //   96: areturn
    //   97: aload_2
    //   98: ldc 63
    //   100: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   103: invokestatic 85	gnu/kawa/lispexpr/LangObjType:coerceToClassType	(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
    //   106: aload_3
    //   107: invokestatic 22	kawa/lib/reflection:recordConstructor	(Lgnu/bytecode/ClassType;Ljava/lang/Object;)Lkawa/lang/RecordConstructor;
    //   110: areturn
    //   111: aload_2
    //   112: ldc 63
    //   114: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   117: invokestatic 85	gnu/kawa/lispexpr/LangObjType:coerceToClassType	(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
    //   120: aload_3
    //   121: ldc_w 355
    //   124: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   127: dup
    //   128: ifnonnull +8 -> 136
    //   131: pop
    //   132: aconst_null
    //   133: goto +6 -> 139
    //   136: invokevirtual 409	java/lang/Object:toString	()Ljava/lang/String;
    //   139: invokestatic 418	kawa/lib/reflection:recordAccessor	(Lgnu/bytecode/ClassType;Ljava/lang/String;)Lkawa/lang/GetFieldProc;
    //   142: areturn
    //   143: aload_2
    //   144: ldc 63
    //   146: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   149: invokestatic 85	gnu/kawa/lispexpr/LangObjType:coerceToClassType	(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
    //   152: aload_3
    //   153: ldc_w 355
    //   156: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   159: dup
    //   160: ifnonnull +8 -> 168
    //   163: pop
    //   164: aconst_null
    //   165: goto +6 -> 171
    //   168: invokevirtual 409	java/lang/Object:toString	()Ljava/lang/String;
    //   171: invokestatic 424	kawa/lib/reflection:recordModifier	(Lgnu/bytecode/ClassType;Ljava/lang/String;)Lkawa/lang/SetFieldProc;
    //   174: areturn
    //   175: aload_2
    //   176: ldc 57
    //   178: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   181: invokestatic 427	gnu/kawa/lispexpr/LangObjType:coerceToType	(Ljava/lang/Object;)Lgnu/bytecode/Type;
    //   184: aload_3
    //   185: ldc 57
    //   187: invokestatic 79	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   190: invokestatic 427	gnu/kawa/lispexpr/LangObjType:coerceToType	(Ljava/lang/Object;)Lgnu/bytecode/Type;
    //   193: invokestatic 432	kawa/lib/reflection:isSubtype	(Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Z
    //   196: ifeq +9 -> 205
    //   199: getstatic 379	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   202: goto +6 -> 208
    //   205: getstatic 382	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   208: areturn
    //   209: aload_0
    //   210: aload_1
    //   211: aload_2
    //   212: aload_3
    //   213: invokespecial 436	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   216: areturn
    //   217: new 89	gnu/mapping/WrongType
    //   220: dup_x1
    //   221: swap
    //   222: ldc_w 411
    //   225: iconst_2
    //   226: aload_3
    //   227: invokespecial 94	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   230: athrow
    //   231: new 89	gnu/mapping/WrongType
    //   234: dup_x1
    //   235: swap
    //   236: ldc_w 366
    //   239: iconst_1
    //   240: aload_2
    //   241: invokespecial 94	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   244: athrow
    //   245: new 89	gnu/mapping/WrongType
    //   248: dup_x1
    //   249: swap
    //   250: ldc_w 414
    //   253: iconst_1
    //   254: aload_2
    //   255: invokespecial 94	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   258: athrow
    //   259: new 89	gnu/mapping/WrongType
    //   262: dup_x1
    //   263: swap
    //   264: ldc_w 420
    //   267: iconst_1
    //   268: aload_2
    //   269: invokespecial 94	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   272: athrow
    //   273: new 89	gnu/mapping/WrongType
    //   276: dup_x1
    //   277: swap
    //   278: ldc_w 429
    //   281: iconst_1
    //   282: aload_2
    //   283: invokespecial 94	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   286: athrow
    //   287: new 89	gnu/mapping/WrongType
    //   290: dup_x1
    //   291: swap
    //   292: ldc_w 429
    //   295: iconst_2
    //   296: aload_3
    //   297: invokespecial 94	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   300: athrow
    // Line number table:
    //   Java source line #14	-> byte code offset #64
    //   Java source line #17	-> byte code offset #97
    //   Java source line #20	-> byte code offset #111
    //   Java source line #23	-> byte code offset #143
    //   Java source line #112	-> byte code offset #175
    //   Java source line #14	-> byte code offset #217
    //   Java source line #17	-> byte code offset #231
    //   Java source line #20	-> byte code offset #245
    //   Java source line #23	-> byte code offset #259
    //   Java source line #112	-> byte code offset #273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	reflection
    //   0	301	1	paramModuleMethod	ModuleMethod
    //   0	301	2	paramObject1	Object
    //   0	301	3	paramObject2	Object
    //   217	1	4	localClassCastException1	ClassCastException
    //   231	1	5	localClassCastException2	ClassCastException
    //   245	1	6	localClassCastException3	ClassCastException
    //   259	1	7	localClassCastException4	ClassCastException
    //   273	1	8	localClassCastException5	ClassCastException
    //   287	1	9	localClassCastException6	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   90	93	217	java/lang/ClassCastException
    //   103	106	231	java/lang/ClassCastException
    //   117	120	245	java/lang/ClassCastException
    //   149	152	259	java/lang/ClassCastException
    //   181	184	273	java/lang/ClassCastException
    //   190	193	287	java/lang/ClassCastException
  }
}
