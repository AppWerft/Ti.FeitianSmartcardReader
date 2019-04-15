package kawa.lib.kawa; import gnu.expr.ModuleMethod;

public class string-cursors extends gnu.expr.ModuleBody { public static final ModuleMethod string$Mncursor$Mnstart; public static final ModuleMethod string$Mncursor$Mnend; public static final ModuleMethod string$Mncursor$Mnref; public static final ModuleMethod substring$Mncursor; public static final ModuleMethod string$Mncursor$Mnnext; public static final ModuleMethod string$Mncursor$Mnnext$Mnquick; public static final ModuleMethod string$Mncursor$Mnprev; public static final ModuleMethod string$Mncursor$Ls$Qu; public static final ModuleMethod string$Mncursor$Ls$Eq$Qu; public static final ModuleMethod string$Mncursor$Eq$Qu; public static final ModuleMethod string$Mncursor$Gr$Qu; public static final ModuleMethod string$Mncursor$Gr$Eq$Qu; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static final gnu.kawa.reflect.StaticFieldLocation string$Mncursor;
  public static final ModuleMethod string$Mncursor$Mnfor$Mneach;
  public static string-cursors $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final gnu.mapping.SimpleSymbol Lit1;
  static final gnu.mapping.SimpleSymbol Lit2;
  static final gnu.mapping.SimpleSymbol Lit3;
  static final gnu.mapping.SimpleSymbol Lit4;
  static final gnu.mapping.SimpleSymbol Lit5;
  static final gnu.mapping.SimpleSymbol Lit6; static final gnu.mapping.SimpleSymbol Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final gnu.mapping.SimpleSymbol Lit9;
  static { Lit11 = gnu.mapping.Symbol.valueOf("string-cursor>=?");Lit10 = gnu.mapping.Symbol.valueOf("string-cursor>?");Lit9 = gnu.mapping.Symbol.valueOf("string-cursor=?");Lit8 = gnu.mapping.Symbol.valueOf("string-cursor<=?");Lit7 = gnu.mapping.Symbol.valueOf("string-cursor<?");Lit6 = gnu.mapping.Symbol.valueOf("substring-cursor");Lit5 = gnu.mapping.Symbol.valueOf("string-cursor-prev");Lit4 = gnu.mapping.Symbol.valueOf("string-cursor-next-quick");Lit3 = gnu.mapping.Symbol.valueOf("string-cursor-next");Lit2 = gnu.mapping.Symbol.valueOf("string-cursor-ref");Lit1 = gnu.mapping.Symbol.valueOf("string-cursor-end");Lit0 = gnu.mapping.Symbol.valueOf("string-cursor-start");$instance = new string-cursors();string$Mncursor = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.lispexpr.LangPrimType", "stringCursorType");string-cursors localString-cursors = $instance;string$Mncursor$Mnstart = new ModuleMethod(localString-cursors, 1, Lit0, 4097);string$Mncursor$Mnend = new ModuleMethod(localString-cursors, 2, Lit1, 4097);string$Mncursor$Mnref = new ModuleMethod(localString-cursors, 3, Lit2, 8194);string$Mncursor$Mnnext = new ModuleMethod(localString-cursors, 4, Lit3, 12290);string$Mncursor$Mnnext$Mnquick = new ModuleMethod(localString-cursors, 6, Lit4, 4097);string$Mncursor$Mnprev = new ModuleMethod(localString-cursors, 7, Lit5, 12290);substring$Mncursor = new ModuleMethod(localString-cursors, 9, Lit6, 12290); void tmp286_283 = new ModuleMethod(localString-cursors, 11, Lit7, 8194);tmp286_283.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");string$Mncursor$Ls$Qu = tmp286_283; void tmp314_311 = new ModuleMethod(localString-cursors, 12, Lit8, 8194);tmp314_311.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");string$Mncursor$Ls$Eq$Qu = tmp314_311; void tmp342_339 = new ModuleMethod(localString-cursors, 13, Lit9, 8194);tmp342_339.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");string$Mncursor$Eq$Qu = tmp342_339; void tmp370_367 = new ModuleMethod(localString-cursors, 14, Lit10, 8194);tmp370_367.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");string$Mncursor$Gr$Qu = tmp370_367; void tmp398_395 = new ModuleMethod(localString-cursors, 15, Lit11, 8194);tmp398_395.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");string$Mncursor$Gr$Eq$Qu = tmp398_395; void tmp426_423 = new ModuleMethod(localString-cursors, 16, Lit12, 16386);tmp426_423.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_map:stringCursorForEachValidateApply");string$Mncursor$Mnfor$Mneach = tmp426_423;$runBody$(); } static final gnu.mapping.SimpleSymbol Lit10; static final gnu.mapping.SimpleSymbol Lit11; static final gnu.mapping.SimpleSymbol Lit12 = gnu.mapping.Symbol.valueOf("string-cursor-for-each");
  
  @kawa.SourceMethodType({"string-cursor"})
  public static int stringCursorStart(CharSequence str)
  {
    return 0;
  }
  
  @kawa.SourceMethodType({"string-cursor"})
  public static int stringCursorEnd(CharSequence str) { return str.length(); }
  
  @kawa.SourceMethodType({"character", "", "string-cursor"})
  public static int stringCursorRef(CharSequence str, int cursor)
  {
    int cursor0 = cursor;
    int ch1 = str.charAt(cursor0);
    boolean x = ch1 < 55296;
    


    int ch2 = cursor0 == str.length() ? '\000' : str.charAt(cursor0 + 1);
    boolean x = ch2 < 56320;
    





    int ch0 = cursor0 == 0 ? '\000' : str.charAt(cursor0 - 1);
    

    return (ch0 >= 55296) && (ch0 <= 56319) ? 2097151 : (ch1 >= 55296) && (ch1 <= 56319) ? (ch1 - 55296) * 1024 + (ch2 - 56320) + 65536 : x ? x : ch2 > 57343 ? ch1 : x ? x : ch1 > 57343 ? ch1 : ch1;
  }
  



















  @kawa.SourceMethodType({"string-cursor", "", "string-cursor"})
  public static int stringCursorNext(CharSequence str, int cursor, int count)
  {
    return Character.offsetByCodePoints(str, cursor, count);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {} try { return gnu.text.StringCursor.valueOf(stringCursorStart((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class))); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      




















































        localClassCastException1, "string-cursor-start", 1, paramObject);
    }
    try
    {
      return gnu.text.StringCursor.valueOf(stringCursorEnd((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "string-cursor-end", 1, paramObject);
    }
    













































    try
    {
      return gnu.text.StringCursor.valueOf(stringCursorNextQuick(((gnu.text.StringCursor)gnu.mapping.Promise.force(paramObject)).getValue())); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "string-cursor-next-quick", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  @kawa.SourceMethodType({"string-cursor", "string-cursor"})
  public static int stringCursorNextQuick(int cursor) { return 1 + cursor; }
  

  @kawa.SourceMethodType({"string-cursor", "", "string-cursor"})
  public static int stringCursorPrev(CharSequence str, int cursor, int count)
  {
    return Character.offsetByCodePoints(str, cursor, -count);
  }
  
  @kawa.SourceMethodType({"", "", "string-cursor"})
  public static CharSequence substringCursor(CharSequence paramCharSequence, int paramInt) { return substringCursor(paramCharSequence, paramInt, paramCharSequence.length()); } @kawa.SourceMethodType({"", "", "string-cursor", "string-cursor"})
  public static CharSequence substringCursor(CharSequence str, int cs1, int cs2) { return str.subSequence(cs1, cs2); }
  
  @kawa.SourceMethodType({"", "string-cursor", "string-cursor"})
  public static boolean isStringCursor$Ls(int cs1, int cs2)
  {
    return cs1 < cs2;
  }
  
  @kawa.SourceMethodType({"", "string-cursor", "string-cursor"})
  public static boolean isStringCursor$Ls$Eq(int cs1, int cs2) {
    return cs1 <= cs2;
  }
  
  @kawa.SourceMethodType({"", "string-cursor", "string-cursor"})
  public static boolean isStringCursor$Eq(int cs1, int cs2) {
    return cs1 == cs2;
  }
  
  @kawa.SourceMethodType({"", "string-cursor", "string-cursor"})
  public static boolean isStringCursor$Gr(int cs1, int cs2) {
    return cs1 > cs2;
  }
  
  @kawa.SourceMethodType({"", "string-cursor", "string-cursor"})
  public static boolean isStringCursor$Gr$Eq(int cs1, int cs2) {
    return cs1 >= cs2;
  }
  

  @kawa.SourceMethodType({"", "", "", "string-cursor"})
  public static void stringCursorForEach(Object paramObject, CharSequence paramCharSequence, int paramInt) { stringCursorForEach(paramObject, paramCharSequence, paramInt, stringCursorEnd(paramCharSequence)); }
  
  @kawa.SourceMethodType({"", "", "", "string-cursor", "string-cursor"})
  public static void stringCursorForEach(Object proc, CharSequence str, int start, int end) { int cursor = start;
    

    kawa.standard.Scheme.applyToArgs.apply2(proc, gnu.text.Char.make(stringCursorRef(str, cursor)));
  }
  
  @kawa.SourceMethodType({"string-cursor", "", "string-cursor"})
  public static int stringCursorNext(CharSequence paramCharSequence, int paramInt)
  {
    return stringCursorNext(paramCharSequence, paramInt, 1);
  }
  
  @kawa.SourceMethodType({"string-cursor", "", "string-cursor"})
  public static int stringCursorPrev(CharSequence paramCharSequence, int paramInt)
  {
    return stringCursorPrev(paramCharSequence, paramInt, 1);
  }
  
  public static void stringCursorForEach(Object paramObject, CharSequence paramCharSequence)
  {
    stringCursorForEach(paramObject, paramCharSequence, 0);
  }
  
  public string-cursors()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 223	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+143->147, 1:+108->112, 2:+73->77, 3:+143->147, 4:+143->147, 5:+143->147, 6:+40->44
    //   44: aload_3
    //   45: aload_2
    //   46: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: dup
    //   50: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   53: iflt +6 -> 59
    //   56: goto +6 -> 62
    //   59: ldc -20
    //   61: ireturn
    //   62: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   65: aload_3
    //   66: aload_1
    //   67: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   70: aload_3
    //   71: iconst_1
    //   72: putfield 247	gnu/mapping/CallContext:pc	I
    //   75: iconst_0
    //   76: ireturn
    //   77: aload_3
    //   78: aload_2
    //   79: ldc 12
    //   81: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   84: dup
    //   85: instanceof 12
    //   88: ifeq +6 -> 94
    //   91: goto +6 -> 97
    //   94: ldc -20
    //   96: ireturn
    //   97: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   100: aload_3
    //   101: aload_1
    //   102: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   105: aload_3
    //   106: iconst_1
    //   107: putfield 247	gnu/mapping/CallContext:pc	I
    //   110: iconst_0
    //   111: ireturn
    //   112: aload_3
    //   113: aload_2
    //   114: ldc 12
    //   116: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   119: dup
    //   120: instanceof 12
    //   123: ifeq +6 -> 129
    //   126: goto +6 -> 132
    //   129: ldc -20
    //   131: ireturn
    //   132: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   135: aload_3
    //   136: aload_1
    //   137: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   140: aload_3
    //   141: iconst_1
    //   142: putfield 247	gnu/mapping/CallContext:pc	I
    //   145: iconst_0
    //   146: ireturn
    //   147: aload_0
    //   148: aload_1
    //   149: aload_2
    //   150: aload_3
    //   151: invokespecial 254	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   154: ireturn
    // Line number table:
    //   Java source line #71	-> byte code offset #44
    //   Java source line #21	-> byte code offset #77
    //   Java source line #17	-> byte code offset #112
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 223	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+646->650, 3:+586->590, 4:+526->530, 5:+646->650, 6:+646->650, 7:+466->470, 8:+646->650, 9:+406->410, 10:+646->650, 11:+348->352, 12:+290->294, 13:+232->236, 14:+174->178, 15:+116->120, 16:+72->76
    //   76: aload 4
    //   78: aload_2
    //   79: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   82: aload 4
    //   84: aload_3
    //   85: ldc 12
    //   87: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   90: dup
    //   91: instanceof 12
    //   94: ifeq +6 -> 100
    //   97: goto +6 -> 103
    //   100: ldc -1
    //   102: ireturn
    //   103: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   106: aload 4
    //   108: aload_1
    //   109: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   112: aload 4
    //   114: iconst_2
    //   115: putfield 247	gnu/mapping/CallContext:pc	I
    //   118: iconst_0
    //   119: ireturn
    //   120: aload 4
    //   122: aload_2
    //   123: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: dup
    //   127: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   130: iflt +6 -> 136
    //   133: goto +6 -> 139
    //   136: ldc -20
    //   138: ireturn
    //   139: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   142: aload 4
    //   144: aload_3
    //   145: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   148: dup
    //   149: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   152: iflt +6 -> 158
    //   155: goto +6 -> 161
    //   158: ldc -1
    //   160: ireturn
    //   161: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   164: aload 4
    //   166: aload_1
    //   167: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   170: aload 4
    //   172: iconst_2
    //   173: putfield 247	gnu/mapping/CallContext:pc	I
    //   176: iconst_0
    //   177: ireturn
    //   178: aload 4
    //   180: aload_2
    //   181: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: dup
    //   185: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   188: iflt +6 -> 194
    //   191: goto +6 -> 197
    //   194: ldc -20
    //   196: ireturn
    //   197: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   200: aload 4
    //   202: aload_3
    //   203: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   206: dup
    //   207: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   210: iflt +6 -> 216
    //   213: goto +6 -> 219
    //   216: ldc -1
    //   218: ireturn
    //   219: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   222: aload 4
    //   224: aload_1
    //   225: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   228: aload 4
    //   230: iconst_2
    //   231: putfield 247	gnu/mapping/CallContext:pc	I
    //   234: iconst_0
    //   235: ireturn
    //   236: aload 4
    //   238: aload_2
    //   239: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   242: dup
    //   243: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   246: iflt +6 -> 252
    //   249: goto +6 -> 255
    //   252: ldc -20
    //   254: ireturn
    //   255: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   258: aload 4
    //   260: aload_3
    //   261: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   264: dup
    //   265: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   268: iflt +6 -> 274
    //   271: goto +6 -> 277
    //   274: ldc -1
    //   276: ireturn
    //   277: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   280: aload 4
    //   282: aload_1
    //   283: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   286: aload 4
    //   288: iconst_2
    //   289: putfield 247	gnu/mapping/CallContext:pc	I
    //   292: iconst_0
    //   293: ireturn
    //   294: aload 4
    //   296: aload_2
    //   297: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   300: dup
    //   301: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   304: iflt +6 -> 310
    //   307: goto +6 -> 313
    //   310: ldc -20
    //   312: ireturn
    //   313: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   316: aload 4
    //   318: aload_3
    //   319: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: dup
    //   323: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   326: iflt +6 -> 332
    //   329: goto +6 -> 335
    //   332: ldc -1
    //   334: ireturn
    //   335: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   338: aload 4
    //   340: aload_1
    //   341: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   344: aload 4
    //   346: iconst_2
    //   347: putfield 247	gnu/mapping/CallContext:pc	I
    //   350: iconst_0
    //   351: ireturn
    //   352: aload 4
    //   354: aload_2
    //   355: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   358: dup
    //   359: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   362: iflt +6 -> 368
    //   365: goto +6 -> 371
    //   368: ldc -20
    //   370: ireturn
    //   371: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   374: aload 4
    //   376: aload_3
    //   377: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   380: dup
    //   381: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   384: iflt +6 -> 390
    //   387: goto +6 -> 393
    //   390: ldc -1
    //   392: ireturn
    //   393: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   396: aload 4
    //   398: aload_1
    //   399: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   402: aload 4
    //   404: iconst_2
    //   405: putfield 247	gnu/mapping/CallContext:pc	I
    //   408: iconst_0
    //   409: ireturn
    //   410: aload 4
    //   412: aload_2
    //   413: ldc 12
    //   415: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   418: dup
    //   419: instanceof 12
    //   422: ifeq +6 -> 428
    //   425: goto +6 -> 431
    //   428: ldc -20
    //   430: ireturn
    //   431: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   434: aload 4
    //   436: aload_3
    //   437: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   440: dup
    //   441: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   444: iflt +6 -> 450
    //   447: goto +6 -> 453
    //   450: ldc -1
    //   452: ireturn
    //   453: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   456: aload 4
    //   458: aload_1
    //   459: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   462: aload 4
    //   464: iconst_2
    //   465: putfield 247	gnu/mapping/CallContext:pc	I
    //   468: iconst_0
    //   469: ireturn
    //   470: aload 4
    //   472: aload_2
    //   473: ldc 12
    //   475: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   478: dup
    //   479: instanceof 12
    //   482: ifeq +6 -> 488
    //   485: goto +6 -> 491
    //   488: ldc -20
    //   490: ireturn
    //   491: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   494: aload 4
    //   496: aload_3
    //   497: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   500: dup
    //   501: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   504: iflt +6 -> 510
    //   507: goto +6 -> 513
    //   510: ldc -1
    //   512: ireturn
    //   513: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   516: aload 4
    //   518: aload_1
    //   519: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   522: aload 4
    //   524: iconst_2
    //   525: putfield 247	gnu/mapping/CallContext:pc	I
    //   528: iconst_0
    //   529: ireturn
    //   530: aload 4
    //   532: aload_2
    //   533: ldc 12
    //   535: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   538: dup
    //   539: instanceof 12
    //   542: ifeq +6 -> 548
    //   545: goto +6 -> 551
    //   548: ldc -20
    //   550: ireturn
    //   551: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   554: aload 4
    //   556: aload_3
    //   557: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   560: dup
    //   561: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   564: iflt +6 -> 570
    //   567: goto +6 -> 573
    //   570: ldc -1
    //   572: ireturn
    //   573: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   576: aload 4
    //   578: aload_1
    //   579: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   582: aload 4
    //   584: iconst_2
    //   585: putfield 247	gnu/mapping/CallContext:pc	I
    //   588: iconst_0
    //   589: ireturn
    //   590: aload 4
    //   592: aload_2
    //   593: ldc 12
    //   595: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   598: dup
    //   599: instanceof 12
    //   602: ifeq +6 -> 608
    //   605: goto +6 -> 611
    //   608: ldc -20
    //   610: ireturn
    //   611: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   614: aload 4
    //   616: aload_3
    //   617: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   620: dup
    //   621: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   624: iflt +6 -> 630
    //   627: goto +6 -> 633
    //   630: ldc -1
    //   632: ireturn
    //   633: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   636: aload 4
    //   638: aload_1
    //   639: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   642: aload 4
    //   644: iconst_2
    //   645: putfield 247	gnu/mapping/CallContext:pc	I
    //   648: iconst_0
    //   649: ireturn
    //   650: aload_0
    //   651: aload_1
    //   652: aload_2
    //   653: aload_3
    //   654: aload 4
    //   656: invokespecial 262	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   659: ireturn
    // Line number table:
    //   Java source line #111	-> byte code offset #76
    //   Java source line #107	-> byte code offset #120
    //   Java source line #102	-> byte code offset #178
    //   Java source line #97	-> byte code offset #236
    //   Java source line #92	-> byte code offset #294
    //   Java source line #87	-> byte code offset #352
    //   Java source line #82	-> byte code offset #410
    //   Java source line #76	-> byte code offset #470
    //   Java source line #66	-> byte code offset #530
    //   Java source line #25	-> byte code offset #590
  }
  
  /* Error */
  public int match3(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 223	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+336->340, 4:+266->270, 7:+196->200, 9:+112->116, 16:+44->48
    //   48: aload 5
    //   50: aload_2
    //   51: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   54: aload 5
    //   56: aload_3
    //   57: ldc 12
    //   59: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   62: dup
    //   63: instanceof 12
    //   66: ifeq +6 -> 72
    //   69: goto +6 -> 75
    //   72: ldc -1
    //   74: ireturn
    //   75: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   78: aload 5
    //   80: aload 4
    //   82: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: dup
    //   86: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   89: iflt +6 -> 95
    //   92: goto +7 -> 99
    //   95: ldc_w 263
    //   98: ireturn
    //   99: putfield 266	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   102: aload 5
    //   104: aload_1
    //   105: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   108: aload 5
    //   110: iconst_3
    //   111: putfield 247	gnu/mapping/CallContext:pc	I
    //   114: iconst_0
    //   115: ireturn
    //   116: aload 5
    //   118: aload_2
    //   119: ldc 12
    //   121: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   124: dup
    //   125: instanceof 12
    //   128: ifeq +6 -> 134
    //   131: goto +6 -> 137
    //   134: ldc -20
    //   136: ireturn
    //   137: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   140: aload 5
    //   142: aload_3
    //   143: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   146: dup
    //   147: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   150: iflt +6 -> 156
    //   153: goto +6 -> 159
    //   156: ldc -1
    //   158: ireturn
    //   159: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   162: aload 5
    //   164: aload 4
    //   166: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   169: dup
    //   170: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   173: iflt +6 -> 179
    //   176: goto +7 -> 183
    //   179: ldc_w 263
    //   182: ireturn
    //   183: putfield 266	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   186: aload 5
    //   188: aload_1
    //   189: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   192: aload 5
    //   194: iconst_3
    //   195: putfield 247	gnu/mapping/CallContext:pc	I
    //   198: iconst_0
    //   199: ireturn
    //   200: aload 5
    //   202: aload_2
    //   203: ldc 12
    //   205: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   208: dup
    //   209: instanceof 12
    //   212: ifeq +6 -> 218
    //   215: goto +6 -> 221
    //   218: ldc -20
    //   220: ireturn
    //   221: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   224: aload 5
    //   226: aload_3
    //   227: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   230: dup
    //   231: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   234: iflt +6 -> 240
    //   237: goto +6 -> 243
    //   240: ldc -1
    //   242: ireturn
    //   243: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   246: aload 5
    //   248: aload 4
    //   250: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   253: putfield 266	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   256: aload 5
    //   258: aload_1
    //   259: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   262: aload 5
    //   264: iconst_3
    //   265: putfield 247	gnu/mapping/CallContext:pc	I
    //   268: iconst_0
    //   269: ireturn
    //   270: aload 5
    //   272: aload_2
    //   273: ldc 12
    //   275: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   278: dup
    //   279: instanceof 12
    //   282: ifeq +6 -> 288
    //   285: goto +6 -> 291
    //   288: ldc -20
    //   290: ireturn
    //   291: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   294: aload 5
    //   296: aload_3
    //   297: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   300: dup
    //   301: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   304: iflt +6 -> 310
    //   307: goto +6 -> 313
    //   310: ldc -1
    //   312: ireturn
    //   313: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   316: aload 5
    //   318: aload 4
    //   320: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   323: putfield 266	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   326: aload 5
    //   328: aload_1
    //   329: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   332: aload 5
    //   334: iconst_3
    //   335: putfield 247	gnu/mapping/CallContext:pc	I
    //   338: iconst_0
    //   339: ireturn
    //   340: aload_0
    //   341: aload_1
    //   342: aload_2
    //   343: aload_3
    //   344: aload 4
    //   346: aload 5
    //   348: invokespecial 270	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   351: ireturn
    // Line number table:
    //   Java source line #111	-> byte code offset #48
    //   Java source line #82	-> byte code offset #116
    //   Java source line #76	-> byte code offset #200
    //   Java source line #66	-> byte code offset #270
  }
  
  /* Error */
  public int match4(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, gnu.mapping.CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 223	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 16
    //   6: if_icmpne +98 -> 104
    //   9: goto +3 -> 12
    //   12: aload 6
    //   14: aload_2
    //   15: putfield 240	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   18: aload 6
    //   20: aload_3
    //   21: ldc 12
    //   23: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   26: dup
    //   27: instanceof 12
    //   30: ifeq +6 -> 36
    //   33: goto +6 -> 39
    //   36: ldc -1
    //   38: ireturn
    //   39: putfield 258	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   42: aload 6
    //   44: aload 4
    //   46: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: dup
    //   50: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   53: iflt +6 -> 59
    //   56: goto +7 -> 63
    //   59: ldc_w 263
    //   62: ireturn
    //   63: putfield 266	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   66: aload 6
    //   68: aload 5
    //   70: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: dup
    //   74: invokestatic 235	gnu/text/StringCursor:checkStringCursor	(Ljava/lang/Object;)I
    //   77: iflt +6 -> 83
    //   80: goto +7 -> 87
    //   83: ldc_w 271
    //   86: ireturn
    //   87: putfield 274	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   90: aload 6
    //   92: aload_1
    //   93: putfield 244	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   96: aload 6
    //   98: iconst_4
    //   99: putfield 247	gnu/mapping/CallContext:pc	I
    //   102: iconst_0
    //   103: ireturn
    //   104: aload_0
    //   105: aload_1
    //   106: aload_2
    //   107: aload_3
    //   108: aload 4
    //   110: aload 5
    //   112: aload 6
    //   114: invokespecial 278	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   117: ireturn
    // Line number table:
    //   Java source line #111	-> byte code offset #12
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
    //   1: getfield 223	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+370->374, 3:+72->76, 4:+98->102, 5:+370->374, 6:+370->374, 7:+124->128, 8:+370->374, 9:+150->154, 10:+370->374, 11:+173->177, 12:+209->213, 13:+245->249, 14:+281->285, 15:+317->321, 16:+353->357
    //   76: aload_2
    //   77: ldc 12
    //   79: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   82: checkcast 12	java/lang/CharSequence
    //   85: aload_3
    //   86: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   89: checkcast 231	gnu/text/StringCursor
    //   92: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   95: invokestatic 73	kawa/lib/kawa/string-cursors:stringCursorRef	(Ljava/lang/CharSequence;I)I
    //   98: invokestatic 79	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   101: areturn
    //   102: aload_2
    //   103: ldc 12
    //   105: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   108: checkcast 12	java/lang/CharSequence
    //   111: aload_3
    //   112: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: checkcast 231	gnu/text/StringCursor
    //   118: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   121: invokestatic 87	kawa/lib/kawa/string-cursors:stringCursorNext	(Ljava/lang/CharSequence;I)I
    //   124: invokestatic 297	gnu/text/StringCursor:valueOf	(I)Lgnu/text/StringCursor;
    //   127: areturn
    //   128: aload_2
    //   129: ldc 12
    //   131: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   134: checkcast 12	java/lang/CharSequence
    //   137: aload_3
    //   138: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   141: checkcast 231	gnu/text/StringCursor
    //   144: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   147: invokestatic 320	kawa/lib/kawa/string-cursors:stringCursorPrev	(Ljava/lang/CharSequence;I)I
    //   150: invokestatic 297	gnu/text/StringCursor:valueOf	(I)Lgnu/text/StringCursor;
    //   153: areturn
    //   154: aload_2
    //   155: ldc 12
    //   157: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   160: checkcast 12	java/lang/CharSequence
    //   163: aload_3
    //   164: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   167: checkcast 231	gnu/text/StringCursor
    //   170: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   173: invokestatic 325	kawa/lib/kawa/string-cursors:substringCursor	(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;
    //   176: areturn
    //   177: aload_2
    //   178: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   181: checkcast 231	gnu/text/StringCursor
    //   184: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   187: aload_3
    //   188: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   191: checkcast 231	gnu/text/StringCursor
    //   194: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   197: invokestatic 330	kawa/lib/kawa/string-cursors:isStringCursor$Ls	(II)Z
    //   200: ifeq +9 -> 209
    //   203: getstatic 336	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   206: goto +6 -> 212
    //   209: getstatic 339	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   212: areturn
    //   213: aload_2
    //   214: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   217: checkcast 231	gnu/text/StringCursor
    //   220: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   223: aload_3
    //   224: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   227: checkcast 231	gnu/text/StringCursor
    //   230: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   233: invokestatic 344	kawa/lib/kawa/string-cursors:isStringCursor$Ls$Eq	(II)Z
    //   236: ifeq +9 -> 245
    //   239: getstatic 336	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   242: goto +6 -> 248
    //   245: getstatic 339	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   248: areturn
    //   249: aload_2
    //   250: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   253: checkcast 231	gnu/text/StringCursor
    //   256: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   259: aload_3
    //   260: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   263: checkcast 231	gnu/text/StringCursor
    //   266: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   269: invokestatic 349	kawa/lib/kawa/string-cursors:isStringCursor$Eq	(II)Z
    //   272: ifeq +9 -> 281
    //   275: getstatic 336	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   278: goto +6 -> 284
    //   281: getstatic 339	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   284: areturn
    //   285: aload_2
    //   286: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   289: checkcast 231	gnu/text/StringCursor
    //   292: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   295: aload_3
    //   296: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   299: checkcast 231	gnu/text/StringCursor
    //   302: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   305: invokestatic 354	kawa/lib/kawa/string-cursors:isStringCursor$Gr	(II)Z
    //   308: ifeq +9 -> 317
    //   311: getstatic 336	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   314: goto +6 -> 320
    //   317: getstatic 339	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   320: areturn
    //   321: aload_2
    //   322: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   325: checkcast 231	gnu/text/StringCursor
    //   328: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   331: aload_3
    //   332: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   335: checkcast 231	gnu/text/StringCursor
    //   338: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   341: invokestatic 63	kawa/lib/kawa/string-cursors:isStringCursor$Gr$Eq	(II)Z
    //   344: ifeq +9 -> 353
    //   347: getstatic 336	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   350: goto +6 -> 356
    //   353: getstatic 339	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   356: areturn
    //   357: aload_2
    //   358: aload_3
    //   359: ldc 12
    //   361: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   364: checkcast 12	java/lang/CharSequence
    //   367: invokestatic 361	kawa/lib/kawa/string-cursors:stringCursorForEach	(Ljava/lang/Object;Ljava/lang/CharSequence;)V
    //   370: getstatic 367	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   373: areturn
    //   374: aload_0
    //   375: aload_1
    //   376: aload_2
    //   377: aload_3
    //   378: invokespecial 370	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   381: areturn
    //   382: new 285	gnu/mapping/WrongType
    //   385: dup_x1
    //   386: swap
    //   387: ldc_w 314
    //   390: iconst_1
    //   391: aload_2
    //   392: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   395: athrow
    //   396: new 285	gnu/mapping/WrongType
    //   399: dup_x1
    //   400: swap
    //   401: ldc_w 314
    //   404: iconst_2
    //   405: aload_3
    //   406: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   409: athrow
    //   410: new 285	gnu/mapping/WrongType
    //   413: dup_x1
    //   414: swap
    //   415: ldc_w 316
    //   418: iconst_1
    //   419: aload_2
    //   420: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   423: athrow
    //   424: new 285	gnu/mapping/WrongType
    //   427: dup_x1
    //   428: swap
    //   429: ldc_w 316
    //   432: iconst_2
    //   433: aload_3
    //   434: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   437: athrow
    //   438: new 285	gnu/mapping/WrongType
    //   441: dup_x1
    //   442: swap
    //   443: ldc_w 318
    //   446: iconst_1
    //   447: aload_2
    //   448: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   451: athrow
    //   452: new 285	gnu/mapping/WrongType
    //   455: dup_x1
    //   456: swap
    //   457: ldc_w 318
    //   460: iconst_2
    //   461: aload_3
    //   462: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   465: athrow
    //   466: new 285	gnu/mapping/WrongType
    //   469: dup_x1
    //   470: swap
    //   471: ldc_w 322
    //   474: iconst_1
    //   475: aload_2
    //   476: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   479: athrow
    //   480: new 285	gnu/mapping/WrongType
    //   483: dup_x1
    //   484: swap
    //   485: ldc_w 322
    //   488: iconst_2
    //   489: aload_3
    //   490: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   493: athrow
    //   494: new 285	gnu/mapping/WrongType
    //   497: dup_x1
    //   498: swap
    //   499: ldc_w 327
    //   502: iconst_1
    //   503: aload_2
    //   504: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   507: athrow
    //   508: new 285	gnu/mapping/WrongType
    //   511: dup_x1
    //   512: swap
    //   513: ldc_w 327
    //   516: iconst_2
    //   517: aload_3
    //   518: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   521: athrow
    //   522: new 285	gnu/mapping/WrongType
    //   525: dup_x1
    //   526: swap
    //   527: ldc_w 341
    //   530: iconst_1
    //   531: aload_2
    //   532: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   535: athrow
    //   536: new 285	gnu/mapping/WrongType
    //   539: dup_x1
    //   540: swap
    //   541: ldc_w 341
    //   544: iconst_2
    //   545: aload_3
    //   546: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   549: athrow
    //   550: new 285	gnu/mapping/WrongType
    //   553: dup_x1
    //   554: swap
    //   555: ldc_w 346
    //   558: iconst_1
    //   559: aload_2
    //   560: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   563: athrow
    //   564: new 285	gnu/mapping/WrongType
    //   567: dup_x1
    //   568: swap
    //   569: ldc_w 346
    //   572: iconst_2
    //   573: aload_3
    //   574: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   577: athrow
    //   578: new 285	gnu/mapping/WrongType
    //   581: dup_x1
    //   582: swap
    //   583: ldc_w 351
    //   586: iconst_1
    //   587: aload_2
    //   588: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   591: athrow
    //   592: new 285	gnu/mapping/WrongType
    //   595: dup_x1
    //   596: swap
    //   597: ldc_w 351
    //   600: iconst_2
    //   601: aload_3
    //   602: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   605: athrow
    //   606: new 285	gnu/mapping/WrongType
    //   609: dup_x1
    //   610: swap
    //   611: ldc_w 356
    //   614: iconst_1
    //   615: aload_2
    //   616: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   619: athrow
    //   620: new 285	gnu/mapping/WrongType
    //   623: dup_x1
    //   624: swap
    //   625: ldc_w 356
    //   628: iconst_2
    //   629: aload_3
    //   630: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   633: athrow
    //   634: new 285	gnu/mapping/WrongType
    //   637: dup_x1
    //   638: swap
    //   639: ldc_w 358
    //   642: iconst_2
    //   643: aload_3
    //   644: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   647: athrow
    // Line number table:
    //   Java source line #25	-> byte code offset #76
    //   Java source line #66	-> byte code offset #102
    //   Java source line #76	-> byte code offset #128
    //   Java source line #82	-> byte code offset #154
    //   Java source line #87	-> byte code offset #177
    //   Java source line #92	-> byte code offset #213
    //   Java source line #97	-> byte code offset #249
    //   Java source line #102	-> byte code offset #285
    //   Java source line #107	-> byte code offset #321
    //   Java source line #111	-> byte code offset #357
    //   Java source line #25	-> byte code offset #382
    //   Java source line #66	-> byte code offset #410
    //   Java source line #76	-> byte code offset #438
    //   Java source line #82	-> byte code offset #466
    //   Java source line #87	-> byte code offset #494
    //   Java source line #92	-> byte code offset #522
    //   Java source line #97	-> byte code offset #550
    //   Java source line #102	-> byte code offset #578
    //   Java source line #107	-> byte code offset #606
    //   Java source line #111	-> byte code offset #634
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	string-cursors
    //   0	648	1	paramModuleMethod	ModuleMethod
    //   0	648	2	paramObject1	Object
    //   0	648	3	paramObject2	Object
    //   382	1	4	localClassCastException1	ClassCastException
    //   396	1	5	localClassCastException2	ClassCastException
    //   410	1	6	localClassCastException3	ClassCastException
    //   424	1	7	localClassCastException4	ClassCastException
    //   438	1	8	localClassCastException5	ClassCastException
    //   452	1	9	localClassCastException6	ClassCastException
    //   466	1	10	localClassCastException7	ClassCastException
    //   480	1	11	localClassCastException8	ClassCastException
    //   494	1	12	localClassCastException9	ClassCastException
    //   508	1	13	localClassCastException10	ClassCastException
    //   522	1	14	localClassCastException11	ClassCastException
    //   536	1	15	localClassCastException12	ClassCastException
    //   550	1	16	localClassCastException13	ClassCastException
    //   564	1	17	localClassCastException14	ClassCastException
    //   578	1	18	localClassCastException15	ClassCastException
    //   592	1	19	localClassCastException16	ClassCastException
    //   606	1	20	localClassCastException17	ClassCastException
    //   620	1	21	localClassCastException18	ClassCastException
    //   634	1	22	localClassCastException19	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   82	85	382	java/lang/ClassCastException
    //   89	95	396	java/lang/ClassCastException
    //   108	111	410	java/lang/ClassCastException
    //   115	121	424	java/lang/ClassCastException
    //   134	137	438	java/lang/ClassCastException
    //   141	147	452	java/lang/ClassCastException
    //   160	163	466	java/lang/ClassCastException
    //   167	173	480	java/lang/ClassCastException
    //   181	187	494	java/lang/ClassCastException
    //   191	197	508	java/lang/ClassCastException
    //   217	223	522	java/lang/ClassCastException
    //   227	233	536	java/lang/ClassCastException
    //   253	259	550	java/lang/ClassCastException
    //   263	269	564	java/lang/ClassCastException
    //   289	295	578	java/lang/ClassCastException
    //   299	305	592	java/lang/ClassCastException
    //   325	331	606	java/lang/ClassCastException
    //   335	341	620	java/lang/ClassCastException
    //   364	367	634	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 223	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+180->184, 4:+44->48, 7:+81->85, 9:+118->122, 16:+152->156
    //   48: aload_2
    //   49: ldc 12
    //   51: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   54: checkcast 12	java/lang/CharSequence
    //   57: aload_3
    //   58: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 231	gnu/text/StringCursor
    //   64: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   67: aload 4
    //   69: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 372	java/lang/Number
    //   75: invokevirtual 375	java/lang/Number:intValue	()I
    //   78: invokestatic 32	kawa/lib/kawa/string-cursors:stringCursorNext	(Ljava/lang/CharSequence;II)I
    //   81: invokestatic 297	gnu/text/StringCursor:valueOf	(I)Lgnu/text/StringCursor;
    //   84: areturn
    //   85: aload_2
    //   86: ldc 12
    //   88: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   91: checkcast 12	java/lang/CharSequence
    //   94: aload_3
    //   95: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   98: checkcast 231	gnu/text/StringCursor
    //   101: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   104: aload 4
    //   106: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 372	java/lang/Number
    //   112: invokevirtual 375	java/lang/Number:intValue	()I
    //   115: invokestatic 40	kawa/lib/kawa/string-cursors:stringCursorPrev	(Ljava/lang/CharSequence;II)I
    //   118: invokestatic 297	gnu/text/StringCursor:valueOf	(I)Lgnu/text/StringCursor;
    //   121: areturn
    //   122: aload_2
    //   123: ldc 12
    //   125: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   128: checkcast 12	java/lang/CharSequence
    //   131: aload_3
    //   132: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 231	gnu/text/StringCursor
    //   138: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   141: aload 4
    //   143: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   146: checkcast 231	gnu/text/StringCursor
    //   149: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   152: invokestatic 44	kawa/lib/kawa/string-cursors:substringCursor	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   155: areturn
    //   156: aload_2
    //   157: aload_3
    //   158: ldc 12
    //   160: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   163: checkcast 12	java/lang/CharSequence
    //   166: aload 4
    //   168: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   171: checkcast 231	gnu/text/StringCursor
    //   174: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   177: invokestatic 52	kawa/lib/kawa/string-cursors:stringCursorForEach	(Ljava/lang/Object;Ljava/lang/CharSequence;I)V
    //   180: getstatic 367	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   183: areturn
    //   184: aload_0
    //   185: aload_1
    //   186: aload_2
    //   187: aload_3
    //   188: aload 4
    //   190: invokespecial 379	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   193: areturn
    //   194: new 285	gnu/mapping/WrongType
    //   197: dup_x1
    //   198: swap
    //   199: ldc_w 316
    //   202: iconst_1
    //   203: aload_2
    //   204: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   207: athrow
    //   208: new 285	gnu/mapping/WrongType
    //   211: dup_x1
    //   212: swap
    //   213: ldc_w 316
    //   216: iconst_2
    //   217: aload_3
    //   218: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   221: athrow
    //   222: new 285	gnu/mapping/WrongType
    //   225: dup_x1
    //   226: swap
    //   227: ldc_w 316
    //   230: iconst_3
    //   231: aload 4
    //   233: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   236: athrow
    //   237: new 285	gnu/mapping/WrongType
    //   240: dup_x1
    //   241: swap
    //   242: ldc_w 318
    //   245: iconst_1
    //   246: aload_2
    //   247: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   250: athrow
    //   251: new 285	gnu/mapping/WrongType
    //   254: dup_x1
    //   255: swap
    //   256: ldc_w 318
    //   259: iconst_2
    //   260: aload_3
    //   261: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   264: athrow
    //   265: new 285	gnu/mapping/WrongType
    //   268: dup_x1
    //   269: swap
    //   270: ldc_w 318
    //   273: iconst_3
    //   274: aload 4
    //   276: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: new 285	gnu/mapping/WrongType
    //   283: dup_x1
    //   284: swap
    //   285: ldc_w 322
    //   288: iconst_1
    //   289: aload_2
    //   290: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   293: athrow
    //   294: new 285	gnu/mapping/WrongType
    //   297: dup_x1
    //   298: swap
    //   299: ldc_w 322
    //   302: iconst_2
    //   303: aload_3
    //   304: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   307: athrow
    //   308: new 285	gnu/mapping/WrongType
    //   311: dup_x1
    //   312: swap
    //   313: ldc_w 322
    //   316: iconst_3
    //   317: aload 4
    //   319: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   322: athrow
    //   323: new 285	gnu/mapping/WrongType
    //   326: dup_x1
    //   327: swap
    //   328: ldc_w 358
    //   331: iconst_2
    //   332: aload_3
    //   333: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   336: athrow
    //   337: new 285	gnu/mapping/WrongType
    //   340: dup_x1
    //   341: swap
    //   342: ldc_w 358
    //   345: iconst_3
    //   346: aload 4
    //   348: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   351: athrow
    // Line number table:
    //   Java source line #66	-> byte code offset #48
    //   Java source line #76	-> byte code offset #85
    //   Java source line #82	-> byte code offset #122
    //   Java source line #111	-> byte code offset #156
    //   Java source line #66	-> byte code offset #194
    //   Java source line #67	-> byte code offset #222
    //   Java source line #76	-> byte code offset #237
    //   Java source line #77	-> byte code offset #265
    //   Java source line #82	-> byte code offset #280
    //   Java source line #83	-> byte code offset #308
    //   Java source line #111	-> byte code offset #323
    //   Java source line #113	-> byte code offset #337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	string-cursors
    //   0	352	1	paramModuleMethod	ModuleMethod
    //   0	352	2	paramObject1	Object
    //   0	352	3	paramObject2	Object
    //   0	352	4	paramObject3	Object
    //   194	1	5	localClassCastException1	ClassCastException
    //   208	1	6	localClassCastException2	ClassCastException
    //   222	1	7	localClassCastException3	ClassCastException
    //   237	1	8	localClassCastException4	ClassCastException
    //   251	1	9	localClassCastException5	ClassCastException
    //   265	1	10	localClassCastException6	ClassCastException
    //   280	1	11	localClassCastException7	ClassCastException
    //   294	1	12	localClassCastException8	ClassCastException
    //   308	1	13	localClassCastException9	ClassCastException
    //   323	1	14	localClassCastException10	ClassCastException
    //   337	1	15	localClassCastException11	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   54	57	194	java/lang/ClassCastException
    //   61	67	208	java/lang/ClassCastException
    //   72	78	222	java/lang/ClassCastException
    //   91	94	237	java/lang/ClassCastException
    //   98	104	251	java/lang/ClassCastException
    //   109	115	265	java/lang/ClassCastException
    //   128	131	280	java/lang/ClassCastException
    //   135	141	294	java/lang/ClassCastException
    //   146	152	308	java/lang/ClassCastException
    //   163	166	323	java/lang/ClassCastException
    //   171	177	337	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 223	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 16
    //   6: if_icmpne +45 -> 51
    //   9: goto +3 -> 12
    //   12: aload_2
    //   13: aload_3
    //   14: ldc 12
    //   16: invokestatic 250	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   19: checkcast 12	java/lang/CharSequence
    //   22: aload 4
    //   24: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 231	gnu/text/StringCursor
    //   30: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   33: aload 5
    //   35: invokestatic 229	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 231	gnu/text/StringCursor
    //   41: invokevirtual 302	gnu/text/StringCursor:getValue	()I
    //   44: invokestatic 59	kawa/lib/kawa/string-cursors:stringCursorForEach	(Ljava/lang/Object;Ljava/lang/CharSequence;II)V
    //   47: getstatic 367	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   50: areturn
    //   51: aload_0
    //   52: aload_1
    //   53: aload_2
    //   54: aload_3
    //   55: aload 4
    //   57: aload 5
    //   59: invokespecial 383	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: areturn
    //   63: new 285	gnu/mapping/WrongType
    //   66: dup_x1
    //   67: swap
    //   68: ldc_w 358
    //   71: iconst_2
    //   72: aload_3
    //   73: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   76: athrow
    //   77: new 285	gnu/mapping/WrongType
    //   80: dup_x1
    //   81: swap
    //   82: ldc_w 358
    //   85: iconst_3
    //   86: aload 4
    //   88: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   91: athrow
    //   92: new 285	gnu/mapping/WrongType
    //   95: dup_x1
    //   96: swap
    //   97: ldc_w 358
    //   100: iconst_4
    //   101: aload 5
    //   103: invokespecial 290	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   106: athrow
    // Line number table:
    //   Java source line #111	-> byte code offset #12
    //   Java source line #113	-> byte code offset #77
    //   Java source line #114	-> byte code offset #92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	string-cursors
    //   0	107	1	paramModuleMethod	ModuleMethod
    //   0	107	2	paramObject1	Object
    //   0	107	3	paramObject2	Object
    //   0	107	4	paramObject3	Object
    //   0	107	5	paramObject4	Object
    //   63	1	6	localClassCastException1	ClassCastException
    //   77	1	7	localClassCastException2	ClassCastException
    //   92	1	8	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   19	22	63	java/lang/ClassCastException
    //   27	33	77	java/lang/ClassCastException
    //   38	44	92	java/lang/ClassCastException
  }
}
