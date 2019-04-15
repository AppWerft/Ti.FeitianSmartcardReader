package gnu.kawa.slib; import gnu.expr.ModuleMethod;

public class readtable extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; } public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext); } public Object apply0(ModuleMethod paramModuleMethod) { if (selector == 1) return currentReadtable(); return super.apply0(paramModuleMethod); }
  public static gnu.kawa.lispexpr.ReadTable currentReadtable() { return gnu.kawa.lispexpr.ReadTable.getCurrent(); }
  
  public static boolean isReadtable(Object obj)
  {
    return obj instanceof gnu.kawa.lispexpr.ReadTable;
  }
  

  public static final ModuleMethod current$Mnreadtable;
  
  public static final ModuleMethod readtable$Qu;
  
  public static final ModuleMethod set$Mnmacro$Mncharacter;
  public static final ModuleMethod make$Mndispatch$Mnmacro$Mncharacter;
  public static final ModuleMethod set$Mndispatch$Mnmacro$Mncharacter;
  public static final ModuleMethod get$Mndispatch$Mnmacro$Mntable;
  public static final ModuleMethod define$Mnreader$Mnctor;
  public static readtable $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final gnu.mapping.SimpleSymbol Lit1;
  static final gnu.mapping.SimpleSymbol Lit2;
  static final gnu.mapping.SimpleSymbol Lit3;
  static final gnu.mapping.SimpleSymbol Lit4;
  static final gnu.mapping.SimpleSymbol Lit5;
  static final gnu.mapping.SimpleSymbol Lit6 = gnu.mapping.Symbol.valueOf("define-reader-ctor");
  public static void setMacroCharacter(char char, Object function, boolean non$Mnterminating, gnu.kawa.lispexpr.ReadTable readtable)
  {
    try
    {
      readtable.set(char, new gnu.kawa.lispexpr.ReaderMacro((gnu.mapping.Procedure)(localObject = gnu.mapping.Promise.force(function, gnu.mapping.Procedure.class)), non$Mnterminating));return; } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "gnu.kawa.lispexpr.ReaderMacro.<init>(gnu.mapping.Procedure,boolean)", 1, localObject);
    }
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 2:  return isReadtable(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    }
    
    














































    try
    {
      makeDispatchMacroCharacter(gnu.text.Char.castToChar(gnu.mapping.Promise.force(paramObject)));return gnu.mapping.Values.empty;
    } catch (ClassCastException localClassCastException) { throw new gnu.mapping.WrongType(localClassCastException, "make-dispatch-macro-character", 1, paramObject);
    }
    return super.apply1(paramModuleMethod, paramObject);
  }
  

  public static void makeDispatchMacroCharacter(char char, boolean non$Mnterminating, gnu.kawa.lispexpr.ReadTable readtable)
  {
    readtable.set(char, new gnu.kawa.lispexpr.ReaderDispatch(non$Mnterminating));
  }
  




  public static Object getDispatchMacroTable(char disp$Mnchar, char sub$Mnchar, gnu.kawa.lispexpr.ReadTable readtable)
  {
    try
    {
      gnu.kawa.lispexpr.ReadTableEntry localReadTableEntry1;
      


      gnu.kawa.lispexpr.ReaderDispatch disp$Mnentry = (gnu.kawa.lispexpr.ReaderDispatch)(localReadTableEntry1 = readtable.lookup(disp$Mnchar));
      sub$Mnentry = disp$Mnentry.lookup(sub$Mnchar);
      return sub$Mnentry == null ? Boolean.FALSE : sub$Mnentry;
    }
    catch (ClassCastException localClassCastException)
    {
      gnu.kawa.lispexpr.ReadTableEntry sub$Mnentry;
      throw new gnu.mapping.WrongType(
      
        localClassCastException, "disp-entry", -2, sub$Mnentry);
    }
  }
  
  public static void defineReaderCtor(gnu.mapping.SimpleSymbol key, gnu.mapping.Procedure proc, gnu.kawa.lispexpr.ReadTable readtable) { readtable.putReaderCtor(key.getName(), proc); }
  
  public static void setMacroCharacter(char paramChar, Object paramObject)
  {
    setMacroCharacter(paramChar, paramObject, false);
  }
  
  public static void setMacroCharacter(char paramChar, Object paramObject, boolean paramBoolean)
  {
    setMacroCharacter(paramChar, paramObject, paramBoolean, currentReadtable());
  }
  
  public static void makeDispatchMacroCharacter(char paramChar)
  {
    makeDispatchMacroCharacter(paramChar, false);
  }
  
  public static void makeDispatchMacroCharacter(char paramChar, boolean paramBoolean)
  {
    makeDispatchMacroCharacter(paramChar, paramBoolean, currentReadtable());
  }
  
  public static void setDispatchMacroCharacter(char paramChar1, char paramChar2, Object paramObject)
  {
    setDispatchMacroCharacter(paramChar1, paramChar2, paramObject, currentReadtable());
  }
  
  /* Error */
  public static void setDispatchMacroCharacter(char disp$Mnchar, char sub$Mnchar, Object function, gnu.kawa.lispexpr.ReadTable readtable)
  {
    // Byte code:
    //   0: aload_3
    //   1: iload_0
    //   2: invokevirtual 75	gnu/kawa/lispexpr/ReadTable:lookup	(I)Lgnu/kawa/lispexpr/ReadTableEntry;
    //   5: dup
    //   6: astore 5
    //   8: checkcast 64	gnu/kawa/lispexpr/ReaderDispatch
    //   11: astore 4
    //   13: aload 4
    //   15: iload_1
    //   16: new 79	gnu/kawa/lispexpr/ReaderDispatchMacro
    //   19: dup
    //   20: aload_2
    //   21: ldc 32
    //   23: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   26: dup
    //   27: astore 5
    //   29: checkcast 32	gnu/mapping/Procedure
    //   32: invokespecial 84	gnu/kawa/lispexpr/ReaderDispatchMacro:<init>	(Lgnu/mapping/Procedure;)V
    //   35: invokevirtual 85	gnu/kawa/lispexpr/ReaderDispatch:set	(ILjava/lang/Object;)V
    //   38: return
    //   39: new 42	gnu/mapping/WrongType
    //   42: dup_x1
    //   43: swap
    //   44: ldc 77
    //   46: bipush -2
    //   48: aload 5
    //   50: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   53: athrow
    //   54: new 42	gnu/mapping/WrongType
    //   57: dup_x1
    //   58: swap
    //   59: ldc 81
    //   61: iconst_1
    //   62: aload 5
    //   64: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   67: athrow
    // Line number table:
    //   Java source line #65	-> byte code offset #0
    //   Java source line #69	-> byte code offset #0
    //   Java source line #70	-> byte code offset #0
    //   Java source line #71	-> byte code offset #13
    //   Java source line #72	-> byte code offset #16
    //   Java source line #70	-> byte code offset #39
    //   Java source line #72	-> byte code offset #54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	disp$Mnchar	char
    //   0	38	1	sub$Mnchar	char
    //   0	38	2	function	Object
    //   0	38	3	readtable	gnu.kawa.lispexpr.ReadTable
    //   11	3	4	entry	gnu.kawa.lispexpr.ReaderDispatch
    //   6	57	5	localObject	Object
    //   39	1	6	localClassCastException1	ClassCastException
    //   54	1	7	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   8	11	39	java/lang/ClassCastException
    //   29	32	54	java/lang/ClassCastException
  }
  
  public static Object getDispatchMacroTable(char paramChar1, char paramChar2)
  {
    return getDispatchMacroTable(paramChar1, paramChar2, currentReadtable());
  }
  
  public static void defineReaderCtor(gnu.mapping.SimpleSymbol paramSimpleSymbol, gnu.mapping.Procedure paramProcedure)
  {
    defineReaderCtor(paramSimpleSymbol, paramProcedure, currentReadtable());
  }
  
  static
  {
    Lit5 = gnu.mapping.Symbol.valueOf("get-dispatch-macro-table");
    Lit4 = gnu.mapping.Symbol.valueOf("set-dispatch-macro-character");
    Lit3 = gnu.mapping.Symbol.valueOf("make-dispatch-macro-character");
    Lit2 = gnu.mapping.Symbol.valueOf("set-macro-character");
    Lit1 = gnu.mapping.Symbol.valueOf("readtable?");
    Lit0 = gnu.mapping.Symbol.valueOf("current-readtable");
    $instance = new readtable();
    readtable localReadtable = $instance;
    current$Mnreadtable = new ModuleMethod(localReadtable, 1, Lit0, 0);
    readtable$Qu = new ModuleMethod(localReadtable, 2, Lit1, 4097);
    set$Mnmacro$Mncharacter = new ModuleMethod(localReadtable, 3, Lit2, 16386);
    make$Mndispatch$Mnmacro$Mncharacter = new ModuleMethod(localReadtable, 6, Lit3, 12289);
    set$Mndispatch$Mnmacro$Mncharacter = new ModuleMethod(localReadtable, 9, Lit4, 16387);
    get$Mndispatch$Mnmacro$Mntable = new ModuleMethod(localReadtable, 11, Lit5, 12290);
    define$Mnreader$Mnctor = new ModuleMethod(localReadtable, 13, Lit6, 12290);
    $runBody$();
  }
  
  public readtable()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 184	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+89->93, 2:+72->76, 3:+89->93, 4:+89->93, 5:+89->93, 6:+36->40
    //   40: aload_3
    //   41: aload_2
    //   42: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: dup
    //   46: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   49: bipush 16
    //   51: iushr
    //   52: ifne +6 -> 58
    //   55: goto +6 -> 61
    //   58: ldc -51
    //   60: ireturn
    //   61: putfield 209	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   64: aload_3
    //   65: aload_1
    //   66: putfield 188	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   69: aload_3
    //   70: iconst_1
    //   71: putfield 191	gnu/mapping/CallContext:pc	I
    //   74: iconst_0
    //   75: ireturn
    //   76: aload_3
    //   77: aload_2
    //   78: putfield 209	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   81: aload_3
    //   82: aload_1
    //   83: putfield 188	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   86: aload_3
    //   87: iconst_1
    //   88: putfield 191	gnu/mapping/CallContext:pc	I
    //   91: iconst_0
    //   92: ireturn
    //   93: aload_0
    //   94: aload_1
    //   95: aload_2
    //   96: aload_3
    //   97: invokespecial 213	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   100: ireturn
    // Line number table:
    //   Java source line #57	-> byte code offset #40
    //   Java source line #5	-> byte code offset #76
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 184	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+273->277, 3:+228->232, 6:+167->171, 11:+103->107, 13:+44->48
    //   48: aload 4
    //   50: aload_2
    //   51: ldc -41
    //   53: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   56: dup
    //   57: instanceof 215
    //   60: ifne +6 -> 66
    //   63: ldc -51
    //   65: ireturn
    //   66: putfield 209	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   69: aload 4
    //   71: aload_3
    //   72: ldc 32
    //   74: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   77: dup
    //   78: invokestatic 221	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   81: ifnull +6 -> 87
    //   84: goto +6 -> 90
    //   87: ldc -34
    //   89: ireturn
    //   90: putfield 225	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   93: aload 4
    //   95: aload_1
    //   96: putfield 188	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   99: aload 4
    //   101: iconst_2
    //   102: putfield 191	gnu/mapping/CallContext:pc	I
    //   105: iconst_0
    //   106: ireturn
    //   107: aload 4
    //   109: aload_2
    //   110: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   113: dup
    //   114: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   117: bipush 16
    //   119: iushr
    //   120: ifne +6 -> 126
    //   123: goto +6 -> 129
    //   126: ldc -51
    //   128: ireturn
    //   129: putfield 209	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   132: aload 4
    //   134: aload_3
    //   135: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: dup
    //   139: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   142: bipush 16
    //   144: iushr
    //   145: ifne +6 -> 151
    //   148: goto +6 -> 154
    //   151: ldc -34
    //   153: ireturn
    //   154: putfield 225	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   157: aload 4
    //   159: aload_1
    //   160: putfield 188	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   163: aload 4
    //   165: iconst_2
    //   166: putfield 191	gnu/mapping/CallContext:pc	I
    //   169: iconst_0
    //   170: ireturn
    //   171: aload 4
    //   173: aload_2
    //   174: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   177: dup
    //   178: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   181: bipush 16
    //   183: iushr
    //   184: ifne +6 -> 190
    //   187: goto +6 -> 193
    //   190: ldc -51
    //   192: ireturn
    //   193: putfield 209	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   196: aload 4
    //   198: aload_3
    //   199: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   202: dup
    //   203: instanceof 94
    //   206: ifeq +6 -> 212
    //   209: goto +6 -> 215
    //   212: ldc -34
    //   214: ireturn
    //   215: putfield 225	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   218: aload 4
    //   220: aload_1
    //   221: putfield 188	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   224: aload 4
    //   226: iconst_2
    //   227: putfield 191	gnu/mapping/CallContext:pc	I
    //   230: iconst_0
    //   231: ireturn
    //   232: aload 4
    //   234: aload_2
    //   235: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   238: dup
    //   239: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   242: bipush 16
    //   244: iushr
    //   245: ifne +6 -> 251
    //   248: goto +6 -> 254
    //   251: ldc -51
    //   253: ireturn
    //   254: putfield 209	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   257: aload 4
    //   259: aload_3
    //   260: putfield 225	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   263: aload 4
    //   265: aload_1
    //   266: putfield 188	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   269: aload 4
    //   271: iconst_2
    //   272: putfield 191	gnu/mapping/CallContext:pc	I
    //   275: iconst_0
    //   276: ireturn
    //   277: aload_0
    //   278: aload_1
    //   279: aload_2
    //   280: aload_3
    //   281: aload 4
    //   283: invokespecial 229	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   286: ireturn
    // Line number table:
    //   Java source line #82	-> byte code offset #48
    //   Java source line #74	-> byte code offset #107
    //   Java source line #57	-> byte code offset #171
    //   Java source line #25	-> byte code offset #232
  }
  
  /* Error */
  public int match3(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 184	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+449->453, 3:+381->385, 4:+449->453, 5:+449->453, 6:+298->302, 7:+449->453, 8:+449->453, 9:+227->231, 10:+449->453, 11:+141->145, 12:+449->453, 13:+60->64
    //   64: aload 5
    //   66: aload_2
    //   67: ldc -41
    //   69: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   72: dup
    //   73: instanceof 215
    //   76: ifne +6 -> 82
    //   79: ldc -51
    //   81: ireturn
    //   82: putfield 209	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   85: aload 5
    //   87: aload_3
    //   88: ldc 32
    //   90: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   93: dup
    //   94: invokestatic 221	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   97: ifnull +6 -> 103
    //   100: goto +6 -> 106
    //   103: ldc -34
    //   105: ireturn
    //   106: putfield 225	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   109: aload 5
    //   111: aload 4
    //   113: ldc 12
    //   115: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   118: dup
    //   119: instanceof 12
    //   122: ifne +6 -> 128
    //   125: ldc -26
    //   127: ireturn
    //   128: putfield 233	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   131: aload 5
    //   133: aload_1
    //   134: putfield 188	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   137: aload 5
    //   139: iconst_3
    //   140: putfield 191	gnu/mapping/CallContext:pc	I
    //   143: iconst_0
    //   144: ireturn
    //   145: aload 5
    //   147: aload_2
    //   148: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: dup
    //   152: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   155: bipush 16
    //   157: iushr
    //   158: ifne +6 -> 164
    //   161: goto +6 -> 167
    //   164: ldc -51
    //   166: ireturn
    //   167: putfield 209	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   170: aload 5
    //   172: aload_3
    //   173: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   176: dup
    //   177: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   180: bipush 16
    //   182: iushr
    //   183: ifne +6 -> 189
    //   186: goto +6 -> 192
    //   189: ldc -34
    //   191: ireturn
    //   192: putfield 225	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   195: aload 5
    //   197: aload 4
    //   199: ldc 12
    //   201: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   204: dup
    //   205: instanceof 12
    //   208: ifne +6 -> 214
    //   211: ldc -26
    //   213: ireturn
    //   214: putfield 233	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   217: aload 5
    //   219: aload_1
    //   220: putfield 188	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   223: aload 5
    //   225: iconst_3
    //   226: putfield 191	gnu/mapping/CallContext:pc	I
    //   229: iconst_0
    //   230: ireturn
    //   231: aload 5
    //   233: aload_2
    //   234: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   237: dup
    //   238: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   241: bipush 16
    //   243: iushr
    //   244: ifne +6 -> 250
    //   247: goto +6 -> 253
    //   250: ldc -51
    //   252: ireturn
    //   253: putfield 209	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   256: aload 5
    //   258: aload_3
    //   259: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   262: dup
    //   263: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   266: bipush 16
    //   268: iushr
    //   269: ifne +6 -> 275
    //   272: goto +6 -> 278
    //   275: ldc -34
    //   277: ireturn
    //   278: putfield 225	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   281: aload 5
    //   283: aload 4
    //   285: putfield 233	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   288: aload 5
    //   290: aload_1
    //   291: putfield 188	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   294: aload 5
    //   296: iconst_3
    //   297: putfield 191	gnu/mapping/CallContext:pc	I
    //   300: iconst_0
    //   301: ireturn
    //   302: aload 5
    //   304: aload_2
    //   305: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   308: dup
    //   309: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   312: bipush 16
    //   314: iushr
    //   315: ifne +6 -> 321
    //   318: goto +6 -> 324
    //   321: ldc -51
    //   323: ireturn
    //   324: putfield 209	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   327: aload 5
    //   329: aload_3
    //   330: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   333: dup
    //   334: instanceof 94
    //   337: ifeq +6 -> 343
    //   340: goto +6 -> 346
    //   343: ldc -34
    //   345: ireturn
    //   346: putfield 225	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   349: aload 5
    //   351: aload 4
    //   353: ldc 12
    //   355: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   358: dup
    //   359: instanceof 12
    //   362: ifne +6 -> 368
    //   365: ldc -26
    //   367: ireturn
    //   368: putfield 233	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   371: aload 5
    //   373: aload_1
    //   374: putfield 188	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   377: aload 5
    //   379: iconst_3
    //   380: putfield 191	gnu/mapping/CallContext:pc	I
    //   383: iconst_0
    //   384: ireturn
    //   385: aload 5
    //   387: aload_2
    //   388: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   391: dup
    //   392: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   395: bipush 16
    //   397: iushr
    //   398: ifne +6 -> 404
    //   401: goto +6 -> 407
    //   404: ldc -51
    //   406: ireturn
    //   407: putfield 209	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   410: aload 5
    //   412: aload_3
    //   413: putfield 225	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   416: aload 5
    //   418: aload 4
    //   420: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   423: dup
    //   424: instanceof 94
    //   427: ifeq +6 -> 433
    //   430: goto +6 -> 436
    //   433: ldc -26
    //   435: ireturn
    //   436: putfield 233	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   439: aload 5
    //   441: aload_1
    //   442: putfield 188	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   445: aload 5
    //   447: iconst_3
    //   448: putfield 191	gnu/mapping/CallContext:pc	I
    //   451: iconst_0
    //   452: ireturn
    //   453: aload_0
    //   454: aload_1
    //   455: aload_2
    //   456: aload_3
    //   457: aload 4
    //   459: aload 5
    //   461: invokespecial 237	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   464: ireturn
    // Line number table:
    //   Java source line #82	-> byte code offset #64
    //   Java source line #74	-> byte code offset #145
    //   Java source line #65	-> byte code offset #231
    //   Java source line #57	-> byte code offset #302
    //   Java source line #25	-> byte code offset #385
  }
  
  /* Error */
  public int match4(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, gnu.mapping.CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 184	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+211->215, 3:+121->125, 9:+28->32
    //   32: aload 6
    //   34: aload_2
    //   35: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: dup
    //   39: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   42: bipush 16
    //   44: iushr
    //   45: ifne +6 -> 51
    //   48: goto +6 -> 54
    //   51: ldc -51
    //   53: ireturn
    //   54: putfield 209	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   57: aload 6
    //   59: aload_3
    //   60: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: dup
    //   64: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   67: bipush 16
    //   69: iushr
    //   70: ifne +6 -> 76
    //   73: goto +6 -> 79
    //   76: ldc -34
    //   78: ireturn
    //   79: putfield 225	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   82: aload 6
    //   84: aload 4
    //   86: putfield 233	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   89: aload 6
    //   91: aload 5
    //   93: ldc 12
    //   95: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   98: dup
    //   99: instanceof 12
    //   102: ifne +6 -> 108
    //   105: ldc -18
    //   107: ireturn
    //   108: putfield 241	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   111: aload 6
    //   113: aload_1
    //   114: putfield 188	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   117: aload 6
    //   119: iconst_4
    //   120: putfield 191	gnu/mapping/CallContext:pc	I
    //   123: iconst_0
    //   124: ireturn
    //   125: aload 6
    //   127: aload_2
    //   128: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   131: dup
    //   132: invokestatic 204	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   135: bipush 16
    //   137: iushr
    //   138: ifne +6 -> 144
    //   141: goto +6 -> 147
    //   144: ldc -51
    //   146: ireturn
    //   147: putfield 209	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   150: aload 6
    //   152: aload_3
    //   153: putfield 225	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   156: aload 6
    //   158: aload 4
    //   160: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   163: dup
    //   164: instanceof 94
    //   167: ifeq +6 -> 173
    //   170: goto +6 -> 176
    //   173: ldc -26
    //   175: ireturn
    //   176: putfield 233	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   179: aload 6
    //   181: aload 5
    //   183: ldc 12
    //   185: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   188: dup
    //   189: instanceof 12
    //   192: ifne +6 -> 198
    //   195: ldc -18
    //   197: ireturn
    //   198: putfield 241	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   201: aload 6
    //   203: aload_1
    //   204: putfield 188	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   207: aload 6
    //   209: iconst_4
    //   210: putfield 191	gnu/mapping/CallContext:pc	I
    //   213: iconst_0
    //   214: ireturn
    //   215: aload_0
    //   216: aload_1
    //   217: aload_2
    //   218: aload_3
    //   219: aload 4
    //   221: aload 5
    //   223: aload 6
    //   225: invokespecial 245	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   228: ireturn
    // Line number table:
    //   Java source line #65	-> byte code offset #32
    //   Java source line #25	-> byte code offset #125
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
    //   1: getfield 184	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+131->135, 3:+44->48, 6:+59->63, 11:+88->92, 13:+106->110
    //   48: aload_2
    //   49: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: invokestatic 263	gnu/text/Char:castToChar	(Ljava/lang/Object;)C
    //   55: aload_3
    //   56: invokestatic 283	gnu/kawa/slib/readtable:setMacroCharacter	(CLjava/lang/Object;)V
    //   59: getstatic 274	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   62: areturn
    //   63: aload_2
    //   64: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: invokestatic 263	gnu/text/Char:castToChar	(Ljava/lang/Object;)C
    //   70: aload_3
    //   71: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: invokestatic 288	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   77: ifeq +7 -> 84
    //   80: iconst_1
    //   81: goto +4 -> 85
    //   84: iconst_0
    //   85: invokestatic 59	gnu/kawa/slib/readtable:makeDispatchMacroCharacter	(CZ)V
    //   88: getstatic 274	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   91: areturn
    //   92: aload_2
    //   93: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: invokestatic 263	gnu/text/Char:castToChar	(Ljava/lang/Object;)C
    //   99: aload_3
    //   100: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: invokestatic 263	gnu/text/Char:castToChar	(Ljava/lang/Object;)C
    //   106: invokestatic 293	gnu/kawa/slib/readtable:getDispatchMacroTable	(CC)Ljava/lang/Object;
    //   109: areturn
    //   110: aload_2
    //   111: ldc -41
    //   113: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   116: checkcast 215	gnu/mapping/SimpleSymbol
    //   119: aload_3
    //   120: ldc 32
    //   122: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   125: invokestatic 298	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   128: invokestatic 301	gnu/kawa/slib/readtable:defineReaderCtor	(Lgnu/mapping/SimpleSymbol;Lgnu/mapping/Procedure;)V
    //   131: getstatic 274	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   134: areturn
    //   135: aload_0
    //   136: aload_1
    //   137: aload_2
    //   138: aload_3
    //   139: invokespecial 305	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: areturn
    //   143: new 42	gnu/mapping/WrongType
    //   146: dup_x1
    //   147: swap
    //   148: ldc_w 280
    //   151: iconst_1
    //   152: aload_2
    //   153: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   156: athrow
    //   157: new 42	gnu/mapping/WrongType
    //   160: dup_x1
    //   161: swap
    //   162: ldc_w 265
    //   165: iconst_1
    //   166: aload_2
    //   167: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   170: athrow
    //   171: new 42	gnu/mapping/WrongType
    //   174: dup_x1
    //   175: swap
    //   176: ldc_w 265
    //   179: iconst_2
    //   180: aload_3
    //   181: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   184: athrow
    //   185: new 42	gnu/mapping/WrongType
    //   188: dup_x1
    //   189: swap
    //   190: ldc_w 290
    //   193: iconst_1
    //   194: aload_2
    //   195: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   198: athrow
    //   199: new 42	gnu/mapping/WrongType
    //   202: dup_x1
    //   203: swap
    //   204: ldc_w 290
    //   207: iconst_2
    //   208: aload_3
    //   209: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   212: athrow
    //   213: new 42	gnu/mapping/WrongType
    //   216: dup_x1
    //   217: swap
    //   218: ldc_w 295
    //   221: iconst_1
    //   222: aload_2
    //   223: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   226: athrow
    //   227: new 42	gnu/mapping/WrongType
    //   230: dup_x1
    //   231: swap
    //   232: ldc_w 295
    //   235: iconst_2
    //   236: aload_3
    //   237: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   240: athrow
    // Line number table:
    //   Java source line #25	-> byte code offset #48
    //   Java source line #57	-> byte code offset #63
    //   Java source line #74	-> byte code offset #92
    //   Java source line #82	-> byte code offset #110
    //   Java source line #25	-> byte code offset #143
    //   Java source line #58	-> byte code offset #157
    //   Java source line #60	-> byte code offset #171
    //   Java source line #75	-> byte code offset #185
    //   Java source line #82	-> byte code offset #213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	readtable
    //   0	241	1	paramModuleMethod	ModuleMethod
    //   0	241	2	paramObject1	Object
    //   0	241	3	paramObject2	Object
    //   143	1	4	localClassCastException1	ClassCastException
    //   157	1	5	localClassCastException2	ClassCastException
    //   171	1	6	localClassCastException3	ClassCastException
    //   185	1	7	localClassCastException4	ClassCastException
    //   199	1	8	localClassCastException5	ClassCastException
    //   213	1	9	localClassCastException6	ClassCastException
    //   227	1	10	localClassCastException7	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   52	55	143	java/lang/ClassCastException
    //   67	70	157	java/lang/ClassCastException
    //   74	85	171	java/lang/ClassCastException
    //   96	99	185	java/lang/ClassCastException
    //   103	106	199	java/lang/ClassCastException
    //   116	119	213	java/lang/ClassCastException
    //   125	128	227	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 184	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+216->220, 3:+60->64, 4:+216->220, 5:+216->220, 6:+91->95, 7:+216->220, 8:+216->220, 9:+130->134, 10:+216->220, 11:+153->157, 12:+216->220, 13:+181->185
    //   64: aload_2
    //   65: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: invokestatic 263	gnu/text/Char:castToChar	(Ljava/lang/Object;)C
    //   71: aload_3
    //   72: aload 4
    //   74: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: invokestatic 288	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   80: ifeq +7 -> 87
    //   83: iconst_1
    //   84: goto +4 -> 88
    //   87: iconst_0
    //   88: invokestatic 22	gnu/kawa/slib/readtable:setMacroCharacter	(CLjava/lang/Object;Z)V
    //   91: getstatic 274	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   94: areturn
    //   95: aload_2
    //   96: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   99: invokestatic 263	gnu/text/Char:castToChar	(Ljava/lang/Object;)C
    //   102: aload_3
    //   103: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: invokestatic 288	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   109: ifeq +7 -> 116
    //   112: iconst_1
    //   113: goto +4 -> 117
    //   116: iconst_0
    //   117: aload 4
    //   119: ldc 12
    //   121: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   124: checkcast 12	gnu/kawa/lispexpr/ReadTable
    //   127: invokestatic 62	gnu/kawa/slib/readtable:makeDispatchMacroCharacter	(CZLgnu/kawa/lispexpr/ReadTable;)V
    //   130: getstatic 274	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   133: areturn
    //   134: aload_2
    //   135: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: invokestatic 263	gnu/text/Char:castToChar	(Ljava/lang/Object;)C
    //   141: aload_3
    //   142: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   145: invokestatic 263	gnu/text/Char:castToChar	(Ljava/lang/Object;)C
    //   148: aload 4
    //   150: invokestatic 310	gnu/kawa/slib/readtable:setDispatchMacroCharacter	(CCLjava/lang/Object;)V
    //   153: getstatic 274	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   156: areturn
    //   157: aload_2
    //   158: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   161: invokestatic 263	gnu/text/Char:castToChar	(Ljava/lang/Object;)C
    //   164: aload_3
    //   165: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   168: invokestatic 263	gnu/text/Char:castToChar	(Ljava/lang/Object;)C
    //   171: aload 4
    //   173: ldc 12
    //   175: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   178: checkcast 12	gnu/kawa/lispexpr/ReadTable
    //   181: invokestatic 89	gnu/kawa/slib/readtable:getDispatchMacroTable	(CCLgnu/kawa/lispexpr/ReadTable;)Ljava/lang/Object;
    //   184: areturn
    //   185: aload_2
    //   186: ldc -41
    //   188: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   191: checkcast 215	gnu/mapping/SimpleSymbol
    //   194: aload_3
    //   195: ldc 32
    //   197: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   200: invokestatic 298	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   203: aload 4
    //   205: ldc 12
    //   207: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   210: checkcast 12	gnu/kawa/lispexpr/ReadTable
    //   213: invokestatic 102	gnu/kawa/slib/readtable:defineReaderCtor	(Lgnu/mapping/SimpleSymbol;Lgnu/mapping/Procedure;Lgnu/kawa/lispexpr/ReadTable;)V
    //   216: getstatic 274	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   219: areturn
    //   220: aload_0
    //   221: aload_1
    //   222: aload_2
    //   223: aload_3
    //   224: aload 4
    //   226: invokespecial 314	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   229: areturn
    //   230: new 42	gnu/mapping/WrongType
    //   233: dup_x1
    //   234: swap
    //   235: ldc_w 280
    //   238: iconst_1
    //   239: aload_2
    //   240: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   243: athrow
    //   244: new 42	gnu/mapping/WrongType
    //   247: dup_x1
    //   248: swap
    //   249: ldc_w 280
    //   252: iconst_3
    //   253: aload 4
    //   255: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   258: athrow
    //   259: new 42	gnu/mapping/WrongType
    //   262: dup_x1
    //   263: swap
    //   264: ldc_w 265
    //   267: iconst_1
    //   268: aload_2
    //   269: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   272: athrow
    //   273: new 42	gnu/mapping/WrongType
    //   276: dup_x1
    //   277: swap
    //   278: ldc_w 265
    //   281: iconst_2
    //   282: aload_3
    //   283: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   286: athrow
    //   287: new 42	gnu/mapping/WrongType
    //   290: dup_x1
    //   291: swap
    //   292: ldc_w 265
    //   295: iconst_3
    //   296: aload 4
    //   298: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   301: athrow
    //   302: new 42	gnu/mapping/WrongType
    //   305: dup_x1
    //   306: swap
    //   307: ldc_w 307
    //   310: iconst_1
    //   311: aload_2
    //   312: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   315: athrow
    //   316: new 42	gnu/mapping/WrongType
    //   319: dup_x1
    //   320: swap
    //   321: ldc_w 307
    //   324: iconst_2
    //   325: aload_3
    //   326: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   329: athrow
    //   330: new 42	gnu/mapping/WrongType
    //   333: dup_x1
    //   334: swap
    //   335: ldc_w 290
    //   338: iconst_1
    //   339: aload_2
    //   340: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   343: athrow
    //   344: new 42	gnu/mapping/WrongType
    //   347: dup_x1
    //   348: swap
    //   349: ldc_w 290
    //   352: iconst_2
    //   353: aload_3
    //   354: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   357: athrow
    //   358: new 42	gnu/mapping/WrongType
    //   361: dup_x1
    //   362: swap
    //   363: ldc_w 290
    //   366: iconst_3
    //   367: aload 4
    //   369: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   372: athrow
    //   373: new 42	gnu/mapping/WrongType
    //   376: dup_x1
    //   377: swap
    //   378: ldc_w 295
    //   381: iconst_1
    //   382: aload_2
    //   383: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   386: athrow
    //   387: new 42	gnu/mapping/WrongType
    //   390: dup_x1
    //   391: swap
    //   392: ldc_w 295
    //   395: iconst_2
    //   396: aload_3
    //   397: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   400: athrow
    //   401: new 42	gnu/mapping/WrongType
    //   404: dup_x1
    //   405: swap
    //   406: ldc_w 295
    //   409: iconst_3
    //   410: aload 4
    //   412: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   415: athrow
    // Line number table:
    //   Java source line #25	-> byte code offset #64
    //   Java source line #57	-> byte code offset #95
    //   Java source line #65	-> byte code offset #134
    //   Java source line #74	-> byte code offset #157
    //   Java source line #82	-> byte code offset #185
    //   Java source line #25	-> byte code offset #230
    //   Java source line #28	-> byte code offset #244
    //   Java source line #58	-> byte code offset #259
    //   Java source line #60	-> byte code offset #273
    //   Java source line #61	-> byte code offset #287
    //   Java source line #66	-> byte code offset #302
    //   Java source line #75	-> byte code offset #330
    //   Java source line #76	-> byte code offset #358
    //   Java source line #82	-> byte code offset #373
    //   Java source line #83	-> byte code offset #401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	readtable
    //   0	416	1	paramModuleMethod	ModuleMethod
    //   0	416	2	paramObject1	Object
    //   0	416	3	paramObject2	Object
    //   0	416	4	paramObject3	Object
    //   230	1	5	localClassCastException1	ClassCastException
    //   244	1	6	localClassCastException2	ClassCastException
    //   259	1	7	localClassCastException3	ClassCastException
    //   273	1	8	localClassCastException4	ClassCastException
    //   287	1	9	localClassCastException5	ClassCastException
    //   302	1	10	localClassCastException6	ClassCastException
    //   316	1	11	localClassCastException7	ClassCastException
    //   330	1	12	localClassCastException8	ClassCastException
    //   344	1	13	localClassCastException9	ClassCastException
    //   358	1	14	localClassCastException10	ClassCastException
    //   373	1	15	localClassCastException11	ClassCastException
    //   387	1	16	localClassCastException12	ClassCastException
    //   401	1	17	localClassCastException13	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   68	71	230	java/lang/ClassCastException
    //   77	88	244	java/lang/ClassCastException
    //   99	102	259	java/lang/ClassCastException
    //   106	117	273	java/lang/ClassCastException
    //   124	127	287	java/lang/ClassCastException
    //   138	141	302	java/lang/ClassCastException
    //   145	148	316	java/lang/ClassCastException
    //   161	164	330	java/lang/ClassCastException
    //   168	171	344	java/lang/ClassCastException
    //   178	181	358	java/lang/ClassCastException
    //   191	194	373	java/lang/ClassCastException
    //   200	203	387	java/lang/ClassCastException
    //   210	213	401	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 184	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+102->106, 3:+28->32, 9:+69->73
    //   32: aload_2
    //   33: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: invokestatic 263	gnu/text/Char:castToChar	(Ljava/lang/Object;)C
    //   39: aload_3
    //   40: aload 4
    //   42: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: invokestatic 288	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   48: ifeq +7 -> 55
    //   51: iconst_1
    //   52: goto +4 -> 56
    //   55: iconst_0
    //   56: aload 5
    //   58: ldc 12
    //   60: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   63: checkcast 12	gnu/kawa/lispexpr/ReadTable
    //   66: invokestatic 28	gnu/kawa/slib/readtable:setMacroCharacter	(CLjava/lang/Object;ZLgnu/kawa/lispexpr/ReadTable;)V
    //   69: getstatic 274	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   72: areturn
    //   73: aload_2
    //   74: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: invokestatic 263	gnu/text/Char:castToChar	(Ljava/lang/Object;)C
    //   80: aload_3
    //   81: invokestatic 198	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   84: invokestatic 263	gnu/text/Char:castToChar	(Ljava/lang/Object;)C
    //   87: aload 4
    //   89: aload 5
    //   91: ldc 12
    //   93: invokestatic 38	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   96: checkcast 12	gnu/kawa/lispexpr/ReadTable
    //   99: invokestatic 71	gnu/kawa/slib/readtable:setDispatchMacroCharacter	(CCLjava/lang/Object;Lgnu/kawa/lispexpr/ReadTable;)V
    //   102: getstatic 274	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   105: areturn
    //   106: aload_0
    //   107: aload_1
    //   108: aload_2
    //   109: aload_3
    //   110: aload 4
    //   112: aload 5
    //   114: invokespecial 318	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   117: areturn
    //   118: new 42	gnu/mapping/WrongType
    //   121: dup_x1
    //   122: swap
    //   123: ldc_w 280
    //   126: iconst_1
    //   127: aload_2
    //   128: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   131: athrow
    //   132: new 42	gnu/mapping/WrongType
    //   135: dup_x1
    //   136: swap
    //   137: ldc_w 280
    //   140: iconst_3
    //   141: aload 4
    //   143: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   146: athrow
    //   147: new 42	gnu/mapping/WrongType
    //   150: dup_x1
    //   151: swap
    //   152: ldc_w 280
    //   155: iconst_4
    //   156: aload 5
    //   158: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   161: athrow
    //   162: new 42	gnu/mapping/WrongType
    //   165: dup_x1
    //   166: swap
    //   167: ldc_w 307
    //   170: iconst_1
    //   171: aload_2
    //   172: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   175: athrow
    //   176: new 42	gnu/mapping/WrongType
    //   179: dup_x1
    //   180: swap
    //   181: ldc_w 307
    //   184: iconst_2
    //   185: aload_3
    //   186: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   189: athrow
    //   190: new 42	gnu/mapping/WrongType
    //   193: dup_x1
    //   194: swap
    //   195: ldc_w 307
    //   198: iconst_4
    //   199: aload 5
    //   201: invokespecial 48	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   204: athrow
    // Line number table:
    //   Java source line #25	-> byte code offset #32
    //   Java source line #65	-> byte code offset #73
    //   Java source line #25	-> byte code offset #118
    //   Java source line #28	-> byte code offset #132
    //   Java source line #29	-> byte code offset #147
    //   Java source line #66	-> byte code offset #162
    //   Java source line #68	-> byte code offset #190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	readtable
    //   0	205	1	paramModuleMethod	ModuleMethod
    //   0	205	2	paramObject1	Object
    //   0	205	3	paramObject2	Object
    //   0	205	4	paramObject3	Object
    //   0	205	5	paramObject4	Object
    //   118	1	6	localClassCastException1	ClassCastException
    //   132	1	7	localClassCastException2	ClassCastException
    //   147	1	8	localClassCastException3	ClassCastException
    //   162	1	9	localClassCastException4	ClassCastException
    //   176	1	10	localClassCastException5	ClassCastException
    //   190	1	11	localClassCastException6	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   36	39	118	java/lang/ClassCastException
    //   45	56	132	java/lang/ClassCastException
    //   63	66	147	java/lang/ClassCastException
    //   77	80	162	java/lang/ClassCastException
    //   84	87	176	java/lang/ClassCastException
    //   96	99	190	java/lang/ClassCastException
  }
}
