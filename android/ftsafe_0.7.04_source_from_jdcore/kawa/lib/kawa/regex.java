package kawa.lib.kawa; import java.util.regex.Pattern;

public class regex extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
  }
  
  public static final gnu.expr.ModuleMethod regex$Mnquote;
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject) { if (selector != 2) {} try { return regexQuote((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException) { throw new gnu.mapping.WrongType(localClassCastException, "regex-quote", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  public static String regexQuote(CharSequence str) { str;return Pattern.quote(str == null ? null : tmp1_0.toString());
  }
  
  public static boolean isRegexMatch(Object paramObject, CharSequence paramCharSequence, int paramInt) { return isRegexMatch(paramObject, paramCharSequence, paramInt, paramCharSequence.length()); }
  public static boolean isRegexMatch(Object re, CharSequence str, int start, int end) { if ((re instanceof Pattern)) {} try { Object localObject; tmpTernaryOp = ((Pattern)(localObject = gnu.mapping.Promise.force(re, Pattern.class)));Pattern rex = Pattern.compile(re.toString());
      matcher = rex.matcher(str);
      matcher.region(start, end);
      return matcher.find();
    }
    catch (ClassCastException localClassCastException)
    {
      java.util.regex.Matcher matcher;
      throw new gnu.mapping.WrongType(
      

        localClassCastException, "rex", -2, matcher); } }
  
  public static final gnu.expr.ModuleMethod regex$Mnmatch$Qu;
  public static Object regexMatch(Object paramObject, CharSequence paramCharSequence, int paramInt) { return regexMatch(paramObject, paramCharSequence, paramInt, paramCharSequence.length()); }
  public static Object regexMatch(Object re, CharSequence str, int start, int end) { if ((re instanceof Pattern)) {} try { Object localObject1; tmpTernaryOp = ((Pattern)(localObject1 = gnu.mapping.Promise.force(re, Pattern.class)));Pattern rex = Pattern.compile(re.toString());
      matcher = rex.matcher(str);
      matcher.region(start, end);
      if (matcher.find()) {
        gnu.lists.EmptyList localEmptyList = gnu.lists.LList.Empty;int igroup = matcher.groupCount();
        

        for (;;)
        {
          int start = matcher.start(igroup);
          

          Object r = kawa.lib.lists.cons(start < 0 ? Boolean.FALSE : str.subSequence(start, matcher.end(igroup)), r);igroup--; } } return igroup < 0 ? r : Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException)
    {
      java.util.regex.Matcher matcher;
      throw new gnu.mapping.WrongType(
      










        localClassCastException, "rex", -2, matcher); } }
  
  public static final gnu.expr.ModuleMethod regex$Mnmatch;
  
  public static Object regexMatchPositions(Object paramObject, CharSequence paramCharSequence, int paramInt) { return regexMatchPositions(paramObject, paramCharSequence, paramInt, paramCharSequence.length()); }
  public static Object regexMatchPositions(Object re, CharSequence str, int start, int end) { if ((re instanceof Pattern)) {} try { Object localObject1; tmpTernaryOp = ((Pattern)(localObject1 = gnu.mapping.Promise.force(re, Pattern.class)));Pattern rex = Pattern.compile(re.toString());
      matcher = rex.matcher(str);
      matcher.region(start, end);
      if (matcher.find()) {
        gnu.lists.EmptyList localEmptyList = gnu.lists.LList.Empty;int igroup = matcher.groupCount();
        

        for (;;)
        {
          int start = matcher.start(igroup);
          

          Object r = kawa.lib.lists.cons(start < 0 ? Boolean.FALSE : kawa.lib.lists.cons(Integer.valueOf(start), Integer.valueOf(matcher.end(igroup))), r);igroup--; } } return igroup < 0 ? r : Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException)
    {
      java.util.regex.Matcher matcher;
      throw new gnu.mapping.WrongType(
      










        localClassCastException, "rex", -2, matcher);
    }
  }
  
  public static final gnu.expr.ModuleMethod regex$Mnmatch$Mnpositions;
  public static final gnu.expr.ModuleMethod regex$Mnsplit;
  public static final gnu.expr.ModuleMethod regex$Mnreplace;
  public static final gnu.expr.ModuleMethod regex$Mnreplace$St;
  public Object apply2(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (selector) {} try { return isRegexMatch(paramObject1, (CharSequence)gnu.mapping.Promise.force(paramObject2, CharSequence.class)) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      







































        localClassCastException1, "regex-match?", 2, paramObject2);
    }
    try
    {
      return regexMatch(paramObject1, (CharSequence)gnu.mapping.Promise.force(paramObject2, CharSequence.class)); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "regex-match", 2, paramObject2);
    }
    












    try
    {
      return regexMatchPositions(paramObject1, (CharSequence)gnu.mapping.Promise.force(paramObject2, CharSequence.class)); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "regex-match-positions", 2, paramObject2);
    }
    












    try
    {
      return regexSplit(paramObject1, (CharSequence)gnu.mapping.Promise.force(paramObject2, CharSequence.class)); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "regex-split", 2, paramObject2); } return super.apply2(paramModuleMethod, paramObject1, paramObject2); }
  public static Object regexSplit(Object re, CharSequence str) { if ((re instanceof Pattern)) {} try { Object localObject; tmpTernaryOp = ((Pattern)(localObject = gnu.mapping.Promise.force(re, Pattern.class)));Pattern rex = Pattern.compile(re.toString());
      parts = rex.split(str, -1);
      int plen = parts.length;
      gnu.lists.LList rlist = gnu.lists.LList.makeList(parts, 0);
      
      return (plen > 1) && 
        (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(parts[(plen - 1)], ""))) && 
        (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(parts[0], ""))) && 
        (rex.matcher("").matches()) ? 
        kawa.lib.lists.cons("", rlist) : rlist;
    }
    catch (ClassCastException localClassCastException)
    {
      String[] parts;
      throw new gnu.mapping.WrongType(
      



        localClassCastException, "rex", -2, parts);
    } }
  
  public static regex $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final gnu.mapping.SimpleSymbol Lit1;
  static final gnu.mapping.SimpleSymbol Lit2;
  
  public static CharSequence regexReplace(Object re, CharSequence str, Object repl) { if ((re instanceof Pattern)) {} try { Object localObject; tmpTernaryOp = ((Pattern)(localObject = gnu.mapping.Promise.force(re, Pattern.class)));Pattern rex = Pattern.compile(re.toString());
      matcher = rex.matcher(str);
      
      StringBuffer sbuf = new StringBuffer(); Object 
      

        tmp82_79 = gnu.mapping.Promise.force(kawa.standard.Scheme.applyToArgs.apply2(repl, matcher.group()), String.class);tmp82_79; Object tmp106_103 = gnu.mapping.Promise.force(repl, String.class);tmp106_103;matcher.appendReplacement(sbuf, tmp106_103 == null ? null : kawa.lib.misc.isProcedure(repl) ? java.util.regex.Matcher.quoteReplacement(tmp82_79 == null ? null : tmp82_79.toString()) : tmp106_103.toString());
      
      matcher.appendTail(sbuf);return matcher.find() ? 
        sbuf.toString() : str;
    }
    catch (ClassCastException localClassCastException)
    {
      java.util.regex.Matcher matcher;
      throw new gnu.mapping.WrongType(
      
        localClassCastException, "rex", -2, matcher);
    }
  }
  
  static final gnu.mapping.SimpleSymbol Lit3;
  static final gnu.mapping.SimpleSymbol Lit4;
  static final gnu.mapping.SimpleSymbol Lit5;
  static final gnu.mapping.SimpleSymbol Lit6 = gnu.mapping.Symbol.valueOf("regex-replace*");
  public class frame extends gnu.expr.ModuleBody {
    gnu.mapping.Procedure loop = new gnu.expr.ModuleMethod(this, 1, "loop", 0);
    Object repl;
    StringBuffer sbuf;
    java.util.regex.Matcher matcher;
    
    public frame() {}
    
    public String lambda1loop() { if (matcher.find())
      {

        Object tmp40_37 = gnu.mapping.Promise.force(kawa.standard.Scheme.applyToArgs.apply2(repl, matcher.group()), String.class);tmp40_37;matcher.appendReplacement(sbuf, java.util.regex.Matcher.quoteReplacement(tmp40_37 == null ? null : tmp40_37.toString()));
      }
      
      matcher.appendTail(sbuf);
      return sbuf.toString();
    }
    
    public int match0(gnu.expr.ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext)
    {
      if (selector == 1)
      {
        proc = paramModuleMethod;
        pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public void apply(gnu.mapping.CallContext paramCallContext)
    {
      gnu.expr.ModuleMethod.applyError();
    }
    
    public Object apply0(gnu.expr.ModuleMethod paramModuleMethod)
    {
      if (selector == 1) {
        return lambda1loop();
      }
      return super.apply0(paramModuleMethod);
    }
  }
  
  public static CharSequence regexReplace$St(Object re, CharSequence str, Object repl)
  {
    frame $heapFrame = new frame();repl = repl;
    if ((re instanceof Pattern)) {} try { tmpTernaryOp = ((Pattern)(localObject = gnu.mapping.Promise.force(re, Pattern.class)));Pattern rex = Pattern.compile(re.toString());
      matcher = rex.matcher(str);
      sbuf = new StringBuffer();
      
      loop = loop; Object 
      







        tmp106_103 = gnu.mapping.Promise.force(repl, String.class);tmp106_103;return kawa.lib.misc.isProcedure(repl) ? $heapFrame.lambda1loop() : matcher.replaceAll(tmp106_103 == null ? null : tmp106_103.toString());
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new gnu.mapping.WrongType(
      











        localClassCastException, "rex", -2, localObject);
    }
  }
  
  public static boolean isRegexMatch(Object paramObject, CharSequence paramCharSequence)
  {
    return isRegexMatch(paramObject, paramCharSequence, 0);
  }
  
  public static Object regexMatch(Object paramObject, CharSequence paramCharSequence)
  {
    return regexMatch(paramObject, paramCharSequence, 0);
  }
  
  public static Object regexMatchPositions(Object paramObject, CharSequence paramCharSequence)
  {
    return regexMatchPositions(paramObject, paramCharSequence, 0);
  }
  
  static
  {
    Lit5 = gnu.mapping.Symbol.valueOf("regex-replace");
    Lit4 = gnu.mapping.Symbol.valueOf("regex-split");
    Lit3 = gnu.mapping.Symbol.valueOf("regex-match-positions");
    Lit2 = gnu.mapping.Symbol.valueOf("regex-match");
    Lit1 = gnu.mapping.Symbol.valueOf("regex-match?");
    Lit0 = gnu.mapping.Symbol.valueOf("regex-quote");
    $instance = new regex();
    regex localRegex = $instance;
    regex$Mnquote = new gnu.expr.ModuleMethod(localRegex, 2, Lit0, 4097);
    regex$Mnmatch$Qu = new gnu.expr.ModuleMethod(localRegex, 3, Lit1, 16386);
    regex$Mnmatch = new gnu.expr.ModuleMethod(localRegex, 6, Lit2, 16386);
    regex$Mnmatch$Mnpositions = new gnu.expr.ModuleMethod(localRegex, 9, Lit3, 16386);
    regex$Mnsplit = new gnu.expr.ModuleMethod(localRegex, 12, Lit4, 8194);
    regex$Mnreplace = new gnu.expr.ModuleMethod(localRegex, 13, Lit5, 12291);
    regex$Mnreplace$St = new gnu.expr.ModuleMethod(localRegex, 14, Lit6, 12291);
    $runBody$();
  }
  
  public regex()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(gnu.expr.ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 277	gnu/expr/ModuleMethod:selector	I
    //   4: iconst_2
    //   5: if_icmpne +42 -> 47
    //   8: goto +3 -> 11
    //   11: aload_3
    //   12: aload_2
    //   13: ldc 30
    //   15: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: dup
    //   19: instanceof 30
    //   22: ifeq +6 -> 28
    //   25: goto +7 -> 32
    //   28: ldc_w 278
    //   31: ireturn
    //   32: putfield 281	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   35: aload_3
    //   36: aload_1
    //   37: putfield 284	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   40: aload_3
    //   41: iconst_1
    //   42: putfield 287	gnu/mapping/CallContext:pc	I
    //   45: iconst_0
    //   46: ireturn
    //   47: aload_0
    //   48: aload_1
    //   49: aload_2
    //   50: aload_3
    //   51: invokespecial 291	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   54: ireturn
    // Line number table:
    //   Java source line #6	-> byte code offset #11
  }
  
  /* Error */
  public int match2(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 277	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+224->228, 3:+179->183, 6:+134->138, 9:+89->93, 12:+44->48
    //   48: aload 4
    //   50: aload_2
    //   51: putfield 281	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   54: aload 4
    //   56: aload_3
    //   57: ldc 30
    //   59: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   62: dup
    //   63: instanceof 30
    //   66: ifeq +6 -> 72
    //   69: goto +7 -> 76
    //   72: ldc_w 292
    //   75: ireturn
    //   76: putfield 295	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   79: aload 4
    //   81: aload_1
    //   82: putfield 284	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   85: aload 4
    //   87: iconst_2
    //   88: putfield 287	gnu/mapping/CallContext:pc	I
    //   91: iconst_0
    //   92: ireturn
    //   93: aload 4
    //   95: aload_2
    //   96: putfield 281	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   99: aload 4
    //   101: aload_3
    //   102: ldc 30
    //   104: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   107: dup
    //   108: instanceof 30
    //   111: ifeq +6 -> 117
    //   114: goto +7 -> 121
    //   117: ldc_w 292
    //   120: ireturn
    //   121: putfield 295	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   124: aload 4
    //   126: aload_1
    //   127: putfield 284	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   130: aload 4
    //   132: iconst_2
    //   133: putfield 287	gnu/mapping/CallContext:pc	I
    //   136: iconst_0
    //   137: ireturn
    //   138: aload 4
    //   140: aload_2
    //   141: putfield 281	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   144: aload 4
    //   146: aload_3
    //   147: ldc 30
    //   149: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   152: dup
    //   153: instanceof 30
    //   156: ifeq +6 -> 162
    //   159: goto +7 -> 166
    //   162: ldc_w 292
    //   165: ireturn
    //   166: putfield 295	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   169: aload 4
    //   171: aload_1
    //   172: putfield 284	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   175: aload 4
    //   177: iconst_2
    //   178: putfield 287	gnu/mapping/CallContext:pc	I
    //   181: iconst_0
    //   182: ireturn
    //   183: aload 4
    //   185: aload_2
    //   186: putfield 281	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   189: aload 4
    //   191: aload_3
    //   192: ldc 30
    //   194: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   197: dup
    //   198: instanceof 30
    //   201: ifeq +6 -> 207
    //   204: goto +7 -> 211
    //   207: ldc_w 292
    //   210: ireturn
    //   211: putfield 295	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   214: aload 4
    //   216: aload_1
    //   217: putfield 284	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   220: aload 4
    //   222: iconst_2
    //   223: putfield 287	gnu/mapping/CallContext:pc	I
    //   226: iconst_0
    //   227: ireturn
    //   228: aload_0
    //   229: aload_1
    //   230: aload_2
    //   231: aload_3
    //   232: aload 4
    //   234: invokespecial 299	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   237: ireturn
    // Line number table:
    //   Java source line #50	-> byte code offset #48
    //   Java source line #33	-> byte code offset #93
    //   Java source line #16	-> byte code offset #138
    //   Java source line #9	-> byte code offset #183
  }
  
  /* Error */
  public int match3(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 277	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+321->325, 3:+266->270, 6:+211->215, 9:+156->160, 13:+104->108, 14:+52->56
    //   56: aload 5
    //   58: aload_2
    //   59: putfield 281	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   62: aload 5
    //   64: aload_3
    //   65: ldc 30
    //   67: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   70: dup
    //   71: instanceof 30
    //   74: ifeq +6 -> 80
    //   77: goto +7 -> 84
    //   80: ldc_w 292
    //   83: ireturn
    //   84: putfield 295	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   87: aload 5
    //   89: aload 4
    //   91: putfield 302	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   94: aload 5
    //   96: aload_1
    //   97: putfield 284	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   100: aload 5
    //   102: iconst_3
    //   103: putfield 287	gnu/mapping/CallContext:pc	I
    //   106: iconst_0
    //   107: ireturn
    //   108: aload 5
    //   110: aload_2
    //   111: putfield 281	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   114: aload 5
    //   116: aload_3
    //   117: ldc 30
    //   119: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   122: dup
    //   123: instanceof 30
    //   126: ifeq +6 -> 132
    //   129: goto +7 -> 136
    //   132: ldc_w 292
    //   135: ireturn
    //   136: putfield 295	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   139: aload 5
    //   141: aload 4
    //   143: putfield 302	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   146: aload 5
    //   148: aload_1
    //   149: putfield 284	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   152: aload 5
    //   154: iconst_3
    //   155: putfield 287	gnu/mapping/CallContext:pc	I
    //   158: iconst_0
    //   159: ireturn
    //   160: aload 5
    //   162: aload_2
    //   163: putfield 281	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   166: aload 5
    //   168: aload_3
    //   169: ldc 30
    //   171: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   174: dup
    //   175: instanceof 30
    //   178: ifeq +6 -> 184
    //   181: goto +7 -> 188
    //   184: ldc_w 292
    //   187: ireturn
    //   188: putfield 295	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   191: aload 5
    //   193: aload 4
    //   195: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   198: putfield 302	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   201: aload 5
    //   203: aload_1
    //   204: putfield 284	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   207: aload 5
    //   209: iconst_3
    //   210: putfield 287	gnu/mapping/CallContext:pc	I
    //   213: iconst_0
    //   214: ireturn
    //   215: aload 5
    //   217: aload_2
    //   218: putfield 281	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   221: aload 5
    //   223: aload_3
    //   224: ldc 30
    //   226: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   229: dup
    //   230: instanceof 30
    //   233: ifeq +6 -> 239
    //   236: goto +7 -> 243
    //   239: ldc_w 292
    //   242: ireturn
    //   243: putfield 295	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   246: aload 5
    //   248: aload 4
    //   250: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   253: putfield 302	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   256: aload 5
    //   258: aload_1
    //   259: putfield 284	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   262: aload 5
    //   264: iconst_3
    //   265: putfield 287	gnu/mapping/CallContext:pc	I
    //   268: iconst_0
    //   269: ireturn
    //   270: aload 5
    //   272: aload_2
    //   273: putfield 281	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   276: aload 5
    //   278: aload_3
    //   279: ldc 30
    //   281: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   284: dup
    //   285: instanceof 30
    //   288: ifeq +6 -> 294
    //   291: goto +7 -> 298
    //   294: ldc_w 292
    //   297: ireturn
    //   298: putfield 295	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   301: aload 5
    //   303: aload 4
    //   305: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   308: putfield 302	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   311: aload 5
    //   313: aload_1
    //   314: putfield 284	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   317: aload 5
    //   319: iconst_3
    //   320: putfield 287	gnu/mapping/CallContext:pc	I
    //   323: iconst_0
    //   324: ireturn
    //   325: aload_0
    //   326: aload_1
    //   327: aload_2
    //   328: aload_3
    //   329: aload 4
    //   331: aload 5
    //   333: invokespecial 309	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   336: ireturn
    // Line number table:
    //   Java source line #76	-> byte code offset #56
    //   Java source line #63	-> byte code offset #108
    //   Java source line #33	-> byte code offset #160
    //   Java source line #16	-> byte code offset #215
    //   Java source line #9	-> byte code offset #270
  }
  
  /* Error */
  public int match4(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, gnu.mapping.CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 277	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+239->243, 3:+174->178, 4:+239->243, 5:+239->243, 6:+109->113, 7:+239->243, 8:+239->243, 9:+44->48
    //   48: aload 6
    //   50: aload_2
    //   51: putfield 281	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   54: aload 6
    //   56: aload_3
    //   57: ldc 30
    //   59: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   62: dup
    //   63: instanceof 30
    //   66: ifeq +6 -> 72
    //   69: goto +7 -> 76
    //   72: ldc_w 292
    //   75: ireturn
    //   76: putfield 295	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   79: aload 6
    //   81: aload 4
    //   83: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: putfield 302	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   89: aload 6
    //   91: aload 5
    //   93: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: putfield 312	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   99: aload 6
    //   101: aload_1
    //   102: putfield 284	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   105: aload 6
    //   107: iconst_4
    //   108: putfield 287	gnu/mapping/CallContext:pc	I
    //   111: iconst_0
    //   112: ireturn
    //   113: aload 6
    //   115: aload_2
    //   116: putfield 281	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   119: aload 6
    //   121: aload_3
    //   122: ldc 30
    //   124: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   127: dup
    //   128: instanceof 30
    //   131: ifeq +6 -> 137
    //   134: goto +7 -> 141
    //   137: ldc_w 292
    //   140: ireturn
    //   141: putfield 295	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   144: aload 6
    //   146: aload 4
    //   148: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: putfield 302	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   154: aload 6
    //   156: aload 5
    //   158: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   161: putfield 312	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   164: aload 6
    //   166: aload_1
    //   167: putfield 284	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   170: aload 6
    //   172: iconst_4
    //   173: putfield 287	gnu/mapping/CallContext:pc	I
    //   176: iconst_0
    //   177: ireturn
    //   178: aload 6
    //   180: aload_2
    //   181: putfield 281	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   184: aload 6
    //   186: aload_3
    //   187: ldc 30
    //   189: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   192: dup
    //   193: instanceof 30
    //   196: ifeq +6 -> 202
    //   199: goto +7 -> 206
    //   202: ldc_w 292
    //   205: ireturn
    //   206: putfield 295	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   209: aload 6
    //   211: aload 4
    //   213: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   216: putfield 302	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   219: aload 6
    //   221: aload 5
    //   223: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   226: putfield 312	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   229: aload 6
    //   231: aload_1
    //   232: putfield 284	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   235: aload 6
    //   237: iconst_4
    //   238: putfield 287	gnu/mapping/CallContext:pc	I
    //   241: iconst_0
    //   242: ireturn
    //   243: aload_0
    //   244: aload_1
    //   245: aload_2
    //   246: aload_3
    //   247: aload 4
    //   249: aload 5
    //   251: aload 6
    //   253: invokespecial 316	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   256: ireturn
    // Line number table:
    //   Java source line #33	-> byte code offset #48
    //   Java source line #16	-> byte code offset #113
    //   Java source line #9	-> byte code offset #178
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply3(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 277	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+171->175, 3:+52->56, 6:+89->93, 9:+114->118, 13:+139->143, 14:+155->159
    //   56: aload_2
    //   57: aload_3
    //   58: ldc 30
    //   60: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   63: checkcast 30	java/lang/CharSequence
    //   66: aload 4
    //   68: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 356	java/lang/Number
    //   74: invokevirtual 359	java/lang/Number:intValue	()I
    //   77: invokestatic 28	kawa/lib/kawa/regex:isRegexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;I)Z
    //   80: ifeq +9 -> 89
    //   83: getstatic 337	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   86: goto +6 -> 92
    //   89: getstatic 97	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   92: areturn
    //   93: aload_2
    //   94: aload_3
    //   95: ldc 30
    //   97: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   100: checkcast 30	java/lang/CharSequence
    //   103: aload 4
    //   105: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   108: checkcast 356	java/lang/Number
    //   111: invokevirtual 359	java/lang/Number:intValue	()I
    //   114: invokestatic 75	kawa/lib/kawa/regex:regexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;
    //   117: areturn
    //   118: aload_2
    //   119: aload_3
    //   120: ldc 30
    //   122: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   125: checkcast 30	java/lang/CharSequence
    //   128: aload 4
    //   130: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   133: checkcast 356	java/lang/Number
    //   136: invokevirtual 359	java/lang/Number:intValue	()I
    //   139: invokestatic 113	kawa/lib/kawa/regex:regexMatchPositions	(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;
    //   142: areturn
    //   143: aload_2
    //   144: aload_3
    //   145: ldc 30
    //   147: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   150: checkcast 30	java/lang/CharSequence
    //   153: aload 4
    //   155: invokestatic 365	kawa/lib/kawa/regex:regexReplace	(Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   158: areturn
    //   159: aload_2
    //   160: aload_3
    //   161: ldc 30
    //   163: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   166: checkcast 30	java/lang/CharSequence
    //   169: aload 4
    //   171: invokestatic 370	kawa/lib/kawa/regex:regexReplace$St	(Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   174: areturn
    //   175: aload_0
    //   176: aload_1
    //   177: aload_2
    //   178: aload_3
    //   179: aload 4
    //   181: invokespecial 374	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   184: areturn
    //   185: new 47	gnu/mapping/WrongType
    //   188: dup_x1
    //   189: swap
    //   190: ldc_w 331
    //   193: iconst_2
    //   194: aload_3
    //   195: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   198: athrow
    //   199: new 47	gnu/mapping/WrongType
    //   202: dup_x1
    //   203: swap
    //   204: ldc_w 331
    //   207: iconst_3
    //   208: aload 4
    //   210: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   213: athrow
    //   214: new 47	gnu/mapping/WrongType
    //   217: dup_x1
    //   218: swap
    //   219: ldc_w 339
    //   222: iconst_2
    //   223: aload_3
    //   224: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   227: athrow
    //   228: new 47	gnu/mapping/WrongType
    //   231: dup_x1
    //   232: swap
    //   233: ldc_w 339
    //   236: iconst_3
    //   237: aload 4
    //   239: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   242: athrow
    //   243: new 47	gnu/mapping/WrongType
    //   246: dup_x1
    //   247: swap
    //   248: ldc_w 344
    //   251: iconst_2
    //   252: aload_3
    //   253: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   256: athrow
    //   257: new 47	gnu/mapping/WrongType
    //   260: dup_x1
    //   261: swap
    //   262: ldc_w 344
    //   265: iconst_3
    //   266: aload 4
    //   268: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   271: athrow
    //   272: new 47	gnu/mapping/WrongType
    //   275: dup_x1
    //   276: swap
    //   277: ldc_w 361
    //   280: iconst_2
    //   281: aload_3
    //   282: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   285: athrow
    //   286: new 47	gnu/mapping/WrongType
    //   289: dup_x1
    //   290: swap
    //   291: ldc_w 367
    //   294: iconst_2
    //   295: aload_3
    //   296: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   299: athrow
    // Line number table:
    //   Java source line #9	-> byte code offset #56
    //   Java source line #16	-> byte code offset #93
    //   Java source line #33	-> byte code offset #118
    //   Java source line #63	-> byte code offset #143
    //   Java source line #76	-> byte code offset #159
    //   Java source line #9	-> byte code offset #185
    //   Java source line #10	-> byte code offset #199
    //   Java source line #16	-> byte code offset #214
    //   Java source line #17	-> byte code offset #228
    //   Java source line #33	-> byte code offset #243
    //   Java source line #34	-> byte code offset #257
    //   Java source line #63	-> byte code offset #272
    //   Java source line #76	-> byte code offset #286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	regex
    //   0	300	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	300	2	paramObject1	Object
    //   0	300	3	paramObject2	Object
    //   0	300	4	paramObject3	Object
    //   185	1	5	localClassCastException1	ClassCastException
    //   199	1	6	localClassCastException2	ClassCastException
    //   214	1	7	localClassCastException3	ClassCastException
    //   228	1	8	localClassCastException4	ClassCastException
    //   243	1	9	localClassCastException5	ClassCastException
    //   257	1	10	localClassCastException6	ClassCastException
    //   272	1	11	localClassCastException7	ClassCastException
    //   286	1	12	localClassCastException8	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   63	66	185	java/lang/ClassCastException
    //   71	77	199	java/lang/ClassCastException
    //   100	103	214	java/lang/ClassCastException
    //   108	114	228	java/lang/ClassCastException
    //   125	128	243	java/lang/ClassCastException
    //   133	139	257	java/lang/ClassCastException
    //   150	153	272	java/lang/ClassCastException
    //   166	169	286	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 277	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+164->168, 3:+44->48, 4:+164->168, 5:+164->168, 6:+92->96, 7:+164->168, 8:+164->168, 9:+128->132
    //   48: aload_2
    //   49: aload_3
    //   50: ldc 30
    //   52: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   55: checkcast 30	java/lang/CharSequence
    //   58: aload 4
    //   60: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 356	java/lang/Number
    //   66: invokevirtual 359	java/lang/Number:intValue	()I
    //   69: aload 5
    //   71: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: checkcast 356	java/lang/Number
    //   77: invokevirtual 359	java/lang/Number:intValue	()I
    //   80: invokestatic 37	kawa/lib/kawa/regex:isRegexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;II)Z
    //   83: ifeq +9 -> 92
    //   86: getstatic 337	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   89: goto +6 -> 95
    //   92: getstatic 97	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   95: areturn
    //   96: aload_2
    //   97: aload_3
    //   98: ldc 30
    //   100: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   103: checkcast 30	java/lang/CharSequence
    //   106: aload 4
    //   108: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   111: checkcast 356	java/lang/Number
    //   114: invokevirtual 359	java/lang/Number:intValue	()I
    //   117: aload 5
    //   119: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   122: checkcast 356	java/lang/Number
    //   125: invokevirtual 359	java/lang/Number:intValue	()I
    //   128: invokestatic 78	kawa/lib/kawa/regex:regexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   131: areturn
    //   132: aload_2
    //   133: aload_3
    //   134: ldc 30
    //   136: invokestatic 43	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   139: checkcast 30	java/lang/CharSequence
    //   142: aload 4
    //   144: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   147: checkcast 356	java/lang/Number
    //   150: invokevirtual 359	java/lang/Number:intValue	()I
    //   153: aload 5
    //   155: invokestatic 305	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   158: checkcast 356	java/lang/Number
    //   161: invokevirtual 359	java/lang/Number:intValue	()I
    //   164: invokestatic 115	kawa/lib/kawa/regex:regexMatchPositions	(Ljava/lang/Object;Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   167: areturn
    //   168: aload_0
    //   169: aload_1
    //   170: aload_2
    //   171: aload_3
    //   172: aload 4
    //   174: aload 5
    //   176: invokespecial 378	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: areturn
    //   180: new 47	gnu/mapping/WrongType
    //   183: dup_x1
    //   184: swap
    //   185: ldc_w 331
    //   188: iconst_2
    //   189: aload_3
    //   190: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   193: athrow
    //   194: new 47	gnu/mapping/WrongType
    //   197: dup_x1
    //   198: swap
    //   199: ldc_w 331
    //   202: iconst_3
    //   203: aload 4
    //   205: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   208: athrow
    //   209: new 47	gnu/mapping/WrongType
    //   212: dup_x1
    //   213: swap
    //   214: ldc_w 331
    //   217: iconst_4
    //   218: aload 5
    //   220: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   223: athrow
    //   224: new 47	gnu/mapping/WrongType
    //   227: dup_x1
    //   228: swap
    //   229: ldc_w 339
    //   232: iconst_2
    //   233: aload_3
    //   234: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   237: athrow
    //   238: new 47	gnu/mapping/WrongType
    //   241: dup_x1
    //   242: swap
    //   243: ldc_w 339
    //   246: iconst_3
    //   247: aload 4
    //   249: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   252: athrow
    //   253: new 47	gnu/mapping/WrongType
    //   256: dup_x1
    //   257: swap
    //   258: ldc_w 339
    //   261: iconst_4
    //   262: aload 5
    //   264: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   267: athrow
    //   268: new 47	gnu/mapping/WrongType
    //   271: dup_x1
    //   272: swap
    //   273: ldc_w 344
    //   276: iconst_2
    //   277: aload_3
    //   278: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   281: athrow
    //   282: new 47	gnu/mapping/WrongType
    //   285: dup_x1
    //   286: swap
    //   287: ldc_w 344
    //   290: iconst_3
    //   291: aload 4
    //   293: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: new 47	gnu/mapping/WrongType
    //   300: dup_x1
    //   301: swap
    //   302: ldc_w 344
    //   305: iconst_4
    //   306: aload 5
    //   308: invokespecial 53	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   311: athrow
    // Line number table:
    //   Java source line #9	-> byte code offset #48
    //   Java source line #16	-> byte code offset #96
    //   Java source line #33	-> byte code offset #132
    //   Java source line #9	-> byte code offset #180
    //   Java source line #10	-> byte code offset #194
    //   Java source line #16	-> byte code offset #224
    //   Java source line #17	-> byte code offset #238
    //   Java source line #33	-> byte code offset #268
    //   Java source line #34	-> byte code offset #282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	regex
    //   0	312	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	312	2	paramObject1	Object
    //   0	312	3	paramObject2	Object
    //   0	312	4	paramObject3	Object
    //   0	312	5	paramObject4	Object
    //   180	1	6	localClassCastException1	ClassCastException
    //   194	1	7	localClassCastException2	ClassCastException
    //   209	1	8	localClassCastException3	ClassCastException
    //   224	1	9	localClassCastException4	ClassCastException
    //   238	1	10	localClassCastException5	ClassCastException
    //   253	1	11	localClassCastException6	ClassCastException
    //   268	1	12	localClassCastException7	ClassCastException
    //   282	1	13	localClassCastException8	ClassCastException
    //   297	1	14	localClassCastException9	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   55	58	180	java/lang/ClassCastException
    //   63	69	194	java/lang/ClassCastException
    //   74	80	209	java/lang/ClassCastException
    //   103	106	224	java/lang/ClassCastException
    //   111	117	238	java/lang/ClassCastException
    //   122	128	253	java/lang/ClassCastException
    //   139	142	268	java/lang/ClassCastException
    //   147	153	282	java/lang/ClassCastException
    //   158	164	297	java/lang/ClassCastException
  }
}
