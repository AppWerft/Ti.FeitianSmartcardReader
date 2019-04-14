package kawa.lib.rnrs; import gnu.expr.ModuleMethod;

public class unicode extends gnu.expr.ModuleBody { public static final ModuleMethod char$Mnupcase; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static final ModuleMethod char$Mndowncase;
  public static final ModuleMethod char$Mntitlecase;
  public static final ModuleMethod char$Mnfoldcase;
  public static final ModuleMethod char$Mnalphabetic$Qu;
  public static final ModuleMethod char$Mnnumeric$Qu;
  public static final ModuleMethod char$Mnwhitespace$Qu;
  public static final ModuleMethod char$Mnupper$Mncase$Qu;
  public static final ModuleMethod char$Mnlower$Mncase$Qu;
  public static final ModuleMethod char$Mntitle$Mncase$Qu; public static final ModuleMethod char$Mngeneral$Mncategory; public static final ModuleMethod string$Mnupcase; public static final ModuleMethod string$Mndowncase;
  @kawa.SourceMethodType({"character", "character"})
  public static int charUpcase(int ch) { return Character.toUpperCase(ch); }
  public static final ModuleMethod string$Mntitlecase; public static final ModuleMethod string$Mnfoldcase;
  @kawa.SourceMethodType({"character", "character"})
  public static int charDowncase(int ch) { return Character.toLowerCase(ch); }
  public static final ModuleMethod string$Mnnormalize$Mnnfd; public static final ModuleMethod string$Mnnormalize$Mnnfkd;
  @kawa.SourceMethodType({"character", "character"})
  public static int charTitlecase(int ch) { return Character.toTitleCase(ch); }
  public static final ModuleMethod string$Mnnormalize$Mnnfc; public static final ModuleMethod string$Mnnormalize$Mnnfkc;
  @kawa.SourceMethodType({"", "character"})
  public static boolean isCharAlphabetic(int ch) { return Character.isLetter(ch); }
  public static unicode $instance; static final gnu.mapping.SimpleSymbol Lit0;
  @kawa.SourceMethodType({"", "character"})
  public static boolean isCharNumeric(int ch) { return Character.isDigit(ch); }
  static final gnu.mapping.SimpleSymbol Lit1; static final gnu.mapping.SimpleSymbol Lit2;
  @kawa.SourceMethodType({"", "character"})
  public static boolean isCharWhitespace(int ch) { return gnu.kawa.functions.UnicodeUtils.isWhitespace(ch); }
  
  static final gnu.mapping.SimpleSymbol Lit3; @kawa.SourceMethodType({"", "character"})
  public static boolean isCharUpperCase(int ch) { return Character.isUpperCase(ch); }
  
  @kawa.SourceMethodType({"", "character"})
  public static boolean isCharLowerCase(int ch) { return Character.isLowerCase(ch); }
  
  @kawa.SourceMethodType({"", "character"})
  public static boolean isCharTitleCase(int ch) { return Character.isTitleCase(ch); }
  
  @kawa.SourceMethodType({"character", "character"})
  public static int charFoldcase(int ch) { int val = ch;
    boolean x = val == 304;
    


    return x ? x : val == 305 ? ch : Character.toLowerCase(Character.toUpperCase(val)); }
  
  @kawa.SourceMethodType({"", "character"})
  public static gnu.mapping.Symbol charGeneralCategory(int ch) { return gnu.kawa.functions.UnicodeUtils.generalCategory(ch); }
  
  public static CharSequence stringUpcase(CharSequence str) {
    return new gnu.lists.FString(str.toString().toUpperCase(java.util.Locale.ENGLISH));
  }
  
  public static CharSequence stringDowncase(CharSequence str) { return new gnu.lists.FString(str.toString().toLowerCase(java.util.Locale.ENGLISH)); }
  
  public static CharSequence stringTitlecase(CharSequence str) {
    str;return new gnu.lists.FString(gnu.kawa.functions.UnicodeUtils.capitalize(str == null ? null : tmp5_4.toString()));
  }
  
  public static CharSequence stringFoldcase(CharSequence str) { return new gnu.lists.FString(gnu.kawa.functions.UnicodeUtils.foldCase(str)); }
  
  static final gnu.mapping.SimpleSymbol Lit4;
  static final gnu.mapping.SimpleSymbol Lit5;
  static final gnu.mapping.SimpleSymbol Lit6;
  static final gnu.mapping.SimpleSymbol Lit7;
  static final gnu.mapping.SimpleSymbol Lit8;
  static final gnu.mapping.SimpleSymbol Lit9;
  static final gnu.mapping.SimpleSymbol Lit10;
  
  public static CharSequence stringNormalizeNfd(CharSequence str) { throw gnu.expr.Special.reachedUnexpected; } public static CharSequence stringNormalizeNfkd(CharSequence str) { throw gnu.expr.Special.reachedUnexpected; } public static CharSequence stringNormalizeNfc(CharSequence str) { throw gnu.expr.Special.reachedUnexpected; } public static CharSequence stringNormalizeNfkc(CharSequence str) { throw gnu.expr.Special.reachedUnexpected;
  }
  
  static final gnu.mapping.SimpleSymbol Lit11;
  static final gnu.mapping.SimpleSymbol Lit12;
  static final gnu.mapping.SimpleSymbol Lit13;
  static final gnu.mapping.SimpleSymbol Lit14;
  static final gnu.mapping.SimpleSymbol Lit15;
  static final gnu.mapping.SimpleSymbol Lit16;
  static final gnu.mapping.SimpleSymbol Lit17;
  static final gnu.mapping.SimpleSymbol Lit18 = gnu.mapping.Symbol.valueOf("string-normalize-nfkc");
  static
  {
    Lit17 = gnu.mapping.Symbol.valueOf("string-normalize-nfc");
    Lit16 = gnu.mapping.Symbol.valueOf("string-normalize-nfkd");
    Lit15 = gnu.mapping.Symbol.valueOf("string-normalize-nfd");
    Lit14 = gnu.mapping.Symbol.valueOf("string-foldcase");
    Lit13 = gnu.mapping.Symbol.valueOf("string-titlecase");
    Lit12 = gnu.mapping.Symbol.valueOf("string-downcase");
    Lit11 = gnu.mapping.Symbol.valueOf("string-upcase");
    Lit10 = gnu.mapping.Symbol.valueOf("char-general-category");
    Lit9 = gnu.mapping.Symbol.valueOf("char-foldcase");
    Lit8 = gnu.mapping.Symbol.valueOf("char-title-case?");
    Lit7 = gnu.mapping.Symbol.valueOf("char-lower-case?");
    Lit6 = gnu.mapping.Symbol.valueOf("char-upper-case?");
    Lit5 = gnu.mapping.Symbol.valueOf("char-whitespace?");
    Lit4 = gnu.mapping.Symbol.valueOf("char-numeric?");
    Lit3 = gnu.mapping.Symbol.valueOf("char-alphabetic?");
    Lit2 = gnu.mapping.Symbol.valueOf("char-titlecase");
    Lit1 = gnu.mapping.Symbol.valueOf("char-downcase");
    Lit0 = gnu.mapping.Symbol.valueOf("char-upcase");
    $instance = new unicode();
    unicode localUnicode = $instance;
    char$Mnupcase = new ModuleMethod(localUnicode, 1, Lit0, 4097);
    char$Mndowncase = new ModuleMethod(localUnicode, 2, Lit1, 4097);
    char$Mntitlecase = new ModuleMethod(localUnicode, 3, Lit2, 4097);
    char$Mnalphabetic$Qu = new ModuleMethod(localUnicode, 4, Lit3, 4097);
    char$Mnnumeric$Qu = new ModuleMethod(localUnicode, 5, Lit4, 4097);
    char$Mnwhitespace$Qu = new ModuleMethod(localUnicode, 6, Lit5, 4097);
    char$Mnupper$Mncase$Qu = new ModuleMethod(localUnicode, 7, Lit6, 4097);
    char$Mnlower$Mncase$Qu = new ModuleMethod(localUnicode, 8, Lit7, 4097);
    char$Mntitle$Mncase$Qu = new ModuleMethod(localUnicode, 9, Lit8, 4097);
    char$Mnfoldcase = new ModuleMethod(localUnicode, 10, Lit9, 4097);
    char$Mngeneral$Mncategory = new ModuleMethod(localUnicode, 11, Lit10, 4097);
    string$Mnupcase = new ModuleMethod(localUnicode, 12, Lit11, 4097);
    string$Mndowncase = new ModuleMethod(localUnicode, 13, Lit12, 4097);
    string$Mntitlecase = new ModuleMethod(localUnicode, 14, Lit13, 4097);
    string$Mnfoldcase = new ModuleMethod(localUnicode, 15, Lit14, 4097);
    string$Mnnormalize$Mnnfd = new ModuleMethod(localUnicode, 16, Lit15, 4097);
    string$Mnnormalize$Mnnfkd = new ModuleMethod(localUnicode, 17, Lit16, 4097);
    string$Mnnormalize$Mnnfc = new ModuleMethod(localUnicode, 18, Lit17, 4097);
    string$Mnnormalize$Mnnfkc = new ModuleMethod(localUnicode, 19, Lit18, 4097);
    $runBody$();
  }
  
  public unicode()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 243	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+735->739, 1:+702->706, 2:+669->673, 3:+636->640, 4:+603->607, 5:+570->574, 6:+537->541, 7:+504->508, 8:+471->475, 9:+438->442, 10:+405->409, 11:+372->376, 12:+337->341, 13:+302->306, 14:+267->271, 15:+232->236, 16:+197->201, 17:+162->166, 18:+127->131, 19:+92->96
    //   96: aload_3
    //   97: aload_2
    //   98: ldc 51
    //   100: invokestatic 249	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   103: dup
    //   104: instanceof 51
    //   107: ifeq +6 -> 113
    //   110: goto +6 -> 116
    //   113: ldc -6
    //   115: ireturn
    //   116: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   119: aload_3
    //   120: aload_1
    //   121: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   124: aload_3
    //   125: iconst_1
    //   126: putfield 261	gnu/mapping/CallContext:pc	I
    //   129: iconst_0
    //   130: ireturn
    //   131: aload_3
    //   132: aload_2
    //   133: ldc 51
    //   135: invokestatic 249	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   138: dup
    //   139: instanceof 51
    //   142: ifeq +6 -> 148
    //   145: goto +6 -> 151
    //   148: ldc -6
    //   150: ireturn
    //   151: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   154: aload_3
    //   155: aload_1
    //   156: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   159: aload_3
    //   160: iconst_1
    //   161: putfield 261	gnu/mapping/CallContext:pc	I
    //   164: iconst_0
    //   165: ireturn
    //   166: aload_3
    //   167: aload_2
    //   168: ldc 51
    //   170: invokestatic 249	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   173: dup
    //   174: instanceof 51
    //   177: ifeq +6 -> 183
    //   180: goto +6 -> 186
    //   183: ldc -6
    //   185: ireturn
    //   186: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   189: aload_3
    //   190: aload_1
    //   191: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   194: aload_3
    //   195: iconst_1
    //   196: putfield 261	gnu/mapping/CallContext:pc	I
    //   199: iconst_0
    //   200: ireturn
    //   201: aload_3
    //   202: aload_2
    //   203: ldc 51
    //   205: invokestatic 249	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   208: dup
    //   209: instanceof 51
    //   212: ifeq +6 -> 218
    //   215: goto +6 -> 221
    //   218: ldc -6
    //   220: ireturn
    //   221: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   224: aload_3
    //   225: aload_1
    //   226: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   229: aload_3
    //   230: iconst_1
    //   231: putfield 261	gnu/mapping/CallContext:pc	I
    //   234: iconst_0
    //   235: ireturn
    //   236: aload_3
    //   237: aload_2
    //   238: ldc 51
    //   240: invokestatic 249	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   243: dup
    //   244: instanceof 51
    //   247: ifeq +6 -> 253
    //   250: goto +6 -> 256
    //   253: ldc -6
    //   255: ireturn
    //   256: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   259: aload_3
    //   260: aload_1
    //   261: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   264: aload_3
    //   265: iconst_1
    //   266: putfield 261	gnu/mapping/CallContext:pc	I
    //   269: iconst_0
    //   270: ireturn
    //   271: aload_3
    //   272: aload_2
    //   273: ldc 51
    //   275: invokestatic 249	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   278: dup
    //   279: instanceof 51
    //   282: ifeq +6 -> 288
    //   285: goto +6 -> 291
    //   288: ldc -6
    //   290: ireturn
    //   291: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   294: aload_3
    //   295: aload_1
    //   296: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   299: aload_3
    //   300: iconst_1
    //   301: putfield 261	gnu/mapping/CallContext:pc	I
    //   304: iconst_0
    //   305: ireturn
    //   306: aload_3
    //   307: aload_2
    //   308: ldc 51
    //   310: invokestatic 249	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   313: dup
    //   314: instanceof 51
    //   317: ifeq +6 -> 323
    //   320: goto +6 -> 326
    //   323: ldc -6
    //   325: ireturn
    //   326: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   329: aload_3
    //   330: aload_1
    //   331: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   334: aload_3
    //   335: iconst_1
    //   336: putfield 261	gnu/mapping/CallContext:pc	I
    //   339: iconst_0
    //   340: ireturn
    //   341: aload_3
    //   342: aload_2
    //   343: ldc 51
    //   345: invokestatic 249	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   348: dup
    //   349: instanceof 51
    //   352: ifeq +6 -> 358
    //   355: goto +6 -> 361
    //   358: ldc -6
    //   360: ireturn
    //   361: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   364: aload_3
    //   365: aload_1
    //   366: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   369: aload_3
    //   370: iconst_1
    //   371: putfield 261	gnu/mapping/CallContext:pc	I
    //   374: iconst_0
    //   375: ireturn
    //   376: aload_3
    //   377: aload_2
    //   378: invokestatic 264	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   381: dup
    //   382: invokestatic 270	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   385: iflt +6 -> 391
    //   388: goto +6 -> 394
    //   391: ldc -6
    //   393: ireturn
    //   394: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   397: aload_3
    //   398: aload_1
    //   399: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   402: aload_3
    //   403: iconst_1
    //   404: putfield 261	gnu/mapping/CallContext:pc	I
    //   407: iconst_0
    //   408: ireturn
    //   409: aload_3
    //   410: aload_2
    //   411: invokestatic 264	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   414: dup
    //   415: invokestatic 270	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   418: iflt +6 -> 424
    //   421: goto +6 -> 427
    //   424: ldc -6
    //   426: ireturn
    //   427: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   430: aload_3
    //   431: aload_1
    //   432: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   435: aload_3
    //   436: iconst_1
    //   437: putfield 261	gnu/mapping/CallContext:pc	I
    //   440: iconst_0
    //   441: ireturn
    //   442: aload_3
    //   443: aload_2
    //   444: invokestatic 264	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   447: dup
    //   448: invokestatic 270	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   451: iflt +6 -> 457
    //   454: goto +6 -> 460
    //   457: ldc -6
    //   459: ireturn
    //   460: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   463: aload_3
    //   464: aload_1
    //   465: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   468: aload_3
    //   469: iconst_1
    //   470: putfield 261	gnu/mapping/CallContext:pc	I
    //   473: iconst_0
    //   474: ireturn
    //   475: aload_3
    //   476: aload_2
    //   477: invokestatic 264	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   480: dup
    //   481: invokestatic 270	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   484: iflt +6 -> 490
    //   487: goto +6 -> 493
    //   490: ldc -6
    //   492: ireturn
    //   493: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   496: aload_3
    //   497: aload_1
    //   498: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   501: aload_3
    //   502: iconst_1
    //   503: putfield 261	gnu/mapping/CallContext:pc	I
    //   506: iconst_0
    //   507: ireturn
    //   508: aload_3
    //   509: aload_2
    //   510: invokestatic 264	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   513: dup
    //   514: invokestatic 270	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   517: iflt +6 -> 523
    //   520: goto +6 -> 526
    //   523: ldc -6
    //   525: ireturn
    //   526: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   529: aload_3
    //   530: aload_1
    //   531: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   534: aload_3
    //   535: iconst_1
    //   536: putfield 261	gnu/mapping/CallContext:pc	I
    //   539: iconst_0
    //   540: ireturn
    //   541: aload_3
    //   542: aload_2
    //   543: invokestatic 264	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   546: dup
    //   547: invokestatic 270	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   550: iflt +6 -> 556
    //   553: goto +6 -> 559
    //   556: ldc -6
    //   558: ireturn
    //   559: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   562: aload_3
    //   563: aload_1
    //   564: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   567: aload_3
    //   568: iconst_1
    //   569: putfield 261	gnu/mapping/CallContext:pc	I
    //   572: iconst_0
    //   573: ireturn
    //   574: aload_3
    //   575: aload_2
    //   576: invokestatic 264	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   579: dup
    //   580: invokestatic 270	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   583: iflt +6 -> 589
    //   586: goto +6 -> 592
    //   589: ldc -6
    //   591: ireturn
    //   592: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   595: aload_3
    //   596: aload_1
    //   597: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   600: aload_3
    //   601: iconst_1
    //   602: putfield 261	gnu/mapping/CallContext:pc	I
    //   605: iconst_0
    //   606: ireturn
    //   607: aload_3
    //   608: aload_2
    //   609: invokestatic 264	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   612: dup
    //   613: invokestatic 270	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   616: iflt +6 -> 622
    //   619: goto +6 -> 625
    //   622: ldc -6
    //   624: ireturn
    //   625: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   628: aload_3
    //   629: aload_1
    //   630: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   633: aload_3
    //   634: iconst_1
    //   635: putfield 261	gnu/mapping/CallContext:pc	I
    //   638: iconst_0
    //   639: ireturn
    //   640: aload_3
    //   641: aload_2
    //   642: invokestatic 264	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   645: dup
    //   646: invokestatic 270	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   649: iflt +6 -> 655
    //   652: goto +6 -> 658
    //   655: ldc -6
    //   657: ireturn
    //   658: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   661: aload_3
    //   662: aload_1
    //   663: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   666: aload_3
    //   667: iconst_1
    //   668: putfield 261	gnu/mapping/CallContext:pc	I
    //   671: iconst_0
    //   672: ireturn
    //   673: aload_3
    //   674: aload_2
    //   675: invokestatic 264	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   678: dup
    //   679: invokestatic 270	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   682: iflt +6 -> 688
    //   685: goto +6 -> 691
    //   688: ldc -6
    //   690: ireturn
    //   691: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   694: aload_3
    //   695: aload_1
    //   696: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   699: aload_3
    //   700: iconst_1
    //   701: putfield 261	gnu/mapping/CallContext:pc	I
    //   704: iconst_0
    //   705: ireturn
    //   706: aload_3
    //   707: aload_2
    //   708: invokestatic 264	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   711: dup
    //   712: invokestatic 270	gnu/text/Char:checkCharOrEof	(Ljava/lang/Object;)I
    //   715: iflt +6 -> 721
    //   718: goto +6 -> 724
    //   721: ldc -6
    //   723: ireturn
    //   724: putfield 254	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   727: aload_3
    //   728: aload_1
    //   729: putfield 258	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   732: aload_3
    //   733: iconst_1
    //   734: putfield 261	gnu/mapping/CallContext:pc	I
    //   737: iconst_0
    //   738: ireturn
    //   739: aload_0
    //   740: aload_1
    //   741: aload_2
    //   742: aload_3
    //   743: invokespecial 274	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   746: ireturn
    // Line number table:
    //   Java source line #81	-> byte code offset #96
    //   Java source line #78	-> byte code offset #131
    //   Java source line #75	-> byte code offset #166
    //   Java source line #72	-> byte code offset #201
    //   Java source line #59	-> byte code offset #236
    //   Java source line #56	-> byte code offset #271
    //   Java source line #53	-> byte code offset #306
    //   Java source line #50	-> byte code offset #341
    //   Java source line #47	-> byte code offset #376
    //   Java source line #39	-> byte code offset #409
    //   Java source line #36	-> byte code offset #442
    //   Java source line #33	-> byte code offset #475
    //   Java source line #30	-> byte code offset #508
    //   Java source line #27	-> byte code offset #541
    //   Java source line #24	-> byte code offset #574
    //   Java source line #21	-> byte code offset #607
    //   Java source line #18	-> byte code offset #640
    //   Java source line #15	-> byte code offset #673
    //   Java source line #12	-> byte code offset #706
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {} for (;;) { try { return gnu.text.Char.make(charUpcase(gnu.text.Char.castToCharacter(gnu.mapping.Promise.force(paramObject)))); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
        



































































          localClassCastException1, "char-upcase", 1, paramObject);
      }
      try
      {
        return gnu.text.Char.make(charDowncase(gnu.text.Char.castToCharacter(gnu.mapping.Promise.force(paramObject)))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "char-downcase", 1, paramObject);
      }
      try {
        return gnu.text.Char.make(charTitlecase(gnu.text.Char.castToCharacter(gnu.mapping.Promise.force(paramObject)))); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "char-titlecase", 1, paramObject);
      }
      try {
        return isCharAlphabetic(gnu.text.Char.castToCharacter(gnu.mapping.Promise.force(paramObject))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "char-alphabetic?", 1, paramObject);
      }
      try {
        return isCharNumeric(gnu.text.Char.castToCharacter(gnu.mapping.Promise.force(paramObject))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "char-numeric?", 1, paramObject);
      }
      try {
        return isCharWhitespace(gnu.text.Char.castToCharacter(gnu.mapping.Promise.force(paramObject))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(localClassCastException6, "char-whitespace?", 1, paramObject);
      }
      try {
        return isCharUpperCase(gnu.text.Char.castToCharacter(gnu.mapping.Promise.force(paramObject))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException7) { throw new gnu.mapping.WrongType(localClassCastException7, "char-upper-case?", 1, paramObject);
      }
      try {
        return isCharLowerCase(gnu.text.Char.castToCharacter(gnu.mapping.Promise.force(paramObject))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException8) { throw new gnu.mapping.WrongType(localClassCastException8, "char-lower-case?", 1, paramObject);
      }
      try {
        return isCharTitleCase(gnu.text.Char.castToCharacter(gnu.mapping.Promise.force(paramObject))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException9) { throw new gnu.mapping.WrongType(localClassCastException9, "char-title-case?", 1, paramObject);
      }
    }
    try { return gnu.text.Char.make(charFoldcase(gnu.text.Char.castToCharacter(gnu.mapping.Promise.force(paramObject)))); } catch (ClassCastException localClassCastException10) { throw new gnu.mapping.WrongType(localClassCastException10, "char-foldcase", 1, paramObject);
    }
    



    try
    {
      return charGeneralCategory(gnu.text.Char.castToCharacter(gnu.mapping.Promise.force(paramObject))); } catch (ClassCastException localClassCastException11) { throw new gnu.mapping.WrongType(localClassCastException11, "char-general-category", 1, paramObject);
    }
    try {
      return stringUpcase((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException12) { throw new gnu.mapping.WrongType(localClassCastException12, "string-upcase", 1, paramObject);
    }
    try {
      return stringDowncase((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException13) { throw new gnu.mapping.WrongType(localClassCastException13, "string-downcase", 1, paramObject);
    }
    try {
      return stringTitlecase((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException14) { throw new gnu.mapping.WrongType(localClassCastException14, "string-titlecase", 1, paramObject);
    }
    try {
      return stringFoldcase((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException15) { throw new gnu.mapping.WrongType(localClassCastException15, "string-foldcase", 1, paramObject);
    }
    








    try
    {
      return stringNormalizeNfd((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException16) { throw new gnu.mapping.WrongType(localClassCastException16, "string-normalize-nfd", 1, paramObject);
    }
    try {
      return stringNormalizeNfkd((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException17) { throw new gnu.mapping.WrongType(localClassCastException17, "string-normalize-nfkd", 1, paramObject);
    }
    try {
      return stringNormalizeNfc((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException18) { throw new gnu.mapping.WrongType(localClassCastException18, "string-normalize-nfc", 1, paramObject);
    }
    try {
      return stringNormalizeNfkc((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException19) { throw new gnu.mapping.WrongType(localClassCastException19, "string-normalize-nfkc", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject);
  }
}
