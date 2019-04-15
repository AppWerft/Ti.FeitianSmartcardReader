package kawa.lib; import gnu.expr.ModuleMethod;

public class characters extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static final ModuleMethod char$Qu;
  
  public static boolean isChar(Object x) { boolean x = x instanceof gnu.text.Char;return x ? x : x instanceof Character; }
  
  public static final ModuleMethod char$Mn$Grinteger;
  @kawa.SourceMethodType({"", "character"})
  public static int char$To$Integer(int ch) { return ch; }
  
  public static final ModuleMethod integer$Mn$Grchar;
  @kawa.SourceMethodType({"character"})
  public static int integer$To$Char(int n) { return n;
  }
  
  public static final ModuleMethod digit$Mnvalue;
  public static characters $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final gnu.mapping.SimpleSymbol Lit1;
  static final gnu.mapping.SimpleSymbol Lit2;
  static final gnu.mapping.SimpleSymbol Lit3 = gnu.mapping.Symbol.valueOf("digit-value");
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return isChar(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    }
    try {
      return Integer.valueOf(char$To$Integer(gnu.text.Char.castToCharacter(gnu.mapping.Promise.force(paramObject)))); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      






        localClassCastException1, "char->integer", 1, paramObject);
    }
    try
    {
      return gnu.text.Char.make(integer$To$Char(((Number)gnu.mapping.Promise.force(paramObject)).intValue())); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "integer->char", 1, paramObject);
    }
    try
    {
      return digitValue(gnu.text.Char.castToCharacter(gnu.mapping.Promise.force(paramObject))); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "digit-value", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); } @kawa.SourceMethodType({"", "character"})
  public static Object digitValue(int ch) { int r = Character.digit(char$To$Integer(ch), 10);
    return r < 0 ? Boolean.FALSE : gnu.math.IntNum.make(r);
  }
  
  static
  {
    Lit2 = gnu.mapping.Symbol.valueOf("integer->char");
    Lit1 = gnu.mapping.Symbol.valueOf("char->integer");
    Lit0 = gnu.mapping.Symbol.valueOf("char?");
    $instance = new characters();
    characters localCharacters = $instance;
    char$Qu = new ModuleMethod(localCharacters, 1, Lit0, 4097);
    void tmp79_76 = new ModuleMethod(localCharacters, 2, Lit1, 4097);
    tmp79_76.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:charToIntegerValidateApply");
    char$Mn$Grinteger = tmp79_76;
    void tmp106_103 = new ModuleMethod(localCharacters, 3, Lit2, 4097);
    tmp106_103.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:integerToCharValidateApply");
    integer$Mn$Grchar = tmp106_103;
    digit$Mnvalue = new ModuleMethod(localCharacters, 4, Lit3, 4097);
    $runBody$();
  }
  
  public characters()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 107	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+135->139, 1:+118->122, 2:+85->89, 3:+65->69, 4:+32->36
    //   36: aload_3
    //   37: aload_2
    //   38: invokestatic 113	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: dup
    //   42: invokestatic 117	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   45: iflt +6 -> 51
    //   48: goto +6 -> 54
    //   51: ldc 118
    //   53: ireturn
    //   54: putfield 122	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   57: aload_3
    //   58: aload_1
    //   59: putfield 126	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   62: aload_3
    //   63: iconst_1
    //   64: putfield 129	gnu/mapping/CallContext:pc	I
    //   67: iconst_0
    //   68: ireturn
    //   69: aload_3
    //   70: aload_2
    //   71: invokestatic 113	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: putfield 122	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   77: aload_3
    //   78: aload_1
    //   79: putfield 126	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   82: aload_3
    //   83: iconst_1
    //   84: putfield 129	gnu/mapping/CallContext:pc	I
    //   87: iconst_0
    //   88: ireturn
    //   89: aload_3
    //   90: aload_2
    //   91: invokestatic 113	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   94: dup
    //   95: invokestatic 117	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   98: iflt +6 -> 104
    //   101: goto +6 -> 107
    //   104: ldc 118
    //   106: ireturn
    //   107: putfield 122	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   110: aload_3
    //   111: aload_1
    //   112: putfield 126	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   115: aload_3
    //   116: iconst_1
    //   117: putfield 129	gnu/mapping/CallContext:pc	I
    //   120: iconst_0
    //   121: ireturn
    //   122: aload_3
    //   123: aload_2
    //   124: putfield 122	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   127: aload_3
    //   128: aload_1
    //   129: putfield 126	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   132: aload_3
    //   133: iconst_1
    //   134: putfield 129	gnu/mapping/CallContext:pc	I
    //   137: iconst_0
    //   138: ireturn
    //   139: aload_0
    //   140: aload_1
    //   141: aload_2
    //   142: aload_3
    //   143: invokespecial 133	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   146: ireturn
    // Line number table:
    //   Java source line #15	-> byte code offset #36
    //   Java source line #11	-> byte code offset #69
    //   Java source line #7	-> byte code offset #89
    //   Java source line #4	-> byte code offset #122
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
}
