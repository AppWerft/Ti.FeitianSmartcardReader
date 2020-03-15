// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import gnu.bytecode.Type;
import gnu.mapping.Symbol;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.ApplyWithValues;
import kawa.lib.misc;
import kawa.standard.Scheme;
import gnu.mapping.WrongType;
import kawa.lib.lists;
import gnu.mapping.Promise;
import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.bytecode.ClassType;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class srfi37 extends ModuleBody
{
    public static final ModuleMethod option;
    public static final ModuleMethod option$Mnnames;
    public static final ModuleMethod option$Mnrequired$Mnarg$Qu;
    public static final ModuleMethod option$Mnoptional$Mnarg$Qu;
    public static final ModuleMethod option$Mnprocessor;
    public static final ModuleMethod option$Qu;
    public static final ModuleMethod args$Mnfold;
    static final ClassType option$Mntype;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final IntNum Lit2;
    public static srfi37 $instance;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static boolean isOption(final Object obj) {
        return obj instanceof option-type;
    }
    
    public static option-type option(final Object names, final Object required$Mnarg$Qu, final Object optional$Mnarg$Qu, final Object processor) {
        final option-type tmp = new option-type();
        tmp.names = names;
        tmp.required$Mnarg$Qu = required$Mnarg$Qu;
        tmp.optional$Mnarg$Qu = optional$Mnarg$Qu;
        tmp.processor = processor;
        return tmp;
    }
    
    public static Object optionNames(final option-type obj) {
        return obj.names;
    }
    
    public static Object isOptionRequiredArg(final option-type obj) {
        return obj.required$Mnarg$Qu;
    }
    
    public static Object isOptionOptionalArg(final option-type obj) {
        return obj.optional$Mnarg$Qu;
    }
    
    public static Object optionProcessor(final option-type obj) {
        return obj.processor;
    }
    
    public static Object argsFold$V(final Object args, final Object options, final Object unrecognizedOptionProc, final Object operandProc, final Object[] argsArray) {
        public class srfi37$frame extends ModuleBody
        {
            Object operand$Mnproc;
            Object unrecognized$Mnoption$Mnproc;
            Object options;
            
            public Object lambda1scanArgs(final Object args, final Object seeds) {
                public class srfi37$frame3 extends ModuleBody
                {
                    Object args;
                    srfi37$frame staticLink;
                    final ModuleMethod lambda$Fn7;
                    final ModuleMethod lambda$Fn8;
                    final ModuleMethod lambda$Fn9;
                    final ModuleMethod lambda$Fn10;
                    
                    public srfi37$frame3() {
                        final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 7, null, -4096);
                        lambda$Fn7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi37.scm:171");
                        this.lambda$Fn7 = lambda$Fn7;
                        final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 8, null, -4096);
                        lambda$Fn8.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi37.scm:193");
                        this.lambda$Fn8 = lambda$Fn8;
                        final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 9, null, -4096);
                        lambda$Fn9.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi37.scm:200");
                        this.lambda$Fn9 = lambda$Fn9;
                        final ModuleMethod lambda$Fn10 = new ModuleMethod(this, 10, null, -4096);
                        lambda$Fn10.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi37.scm:213");
                        this.lambda$Fn10 = lambda$Fn10;
                    }
                    
                    Object lambda12$V(final Object[] argsArray) {
                        final LList seeds = LList.makeList(argsArray, 0);
                        return this.staticLink.lambda1scanArgs(this.args, seeds);
                    }
                    
                    Object lambda13$V(final Object[] argsArray) {
                        final LList seeds = LList.makeList(argsArray, 0);
                        final srfi37$frame staticLink = this.staticLink;
                        final Object force = Promise.force(this.args, Pair.class);
                        try {
                            return staticLink.lambda1scanArgs(lists.cdr((Pair)force), seeds);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "cdr", 1, force);
                        }
                    }
                    
                    Object lambda14$V(final Object[] argsArray) {
                        final LList seeds = LList.makeList(argsArray, 0);
                        return this.staticLink.lambda1scanArgs(this.args, seeds);
                    }
                    
                    Object lambda15$V(final Object[] argsArray) {
                        final LList seeds = LList.makeList(argsArray, 0);
                        return this.staticLink.lambda1scanArgs(this.args, seeds);
                    }
                    
                    @Override
                    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
                        switch (proc.selector) {
                            case 10: {
                                ctx.values = args;
                                ctx.proc = proc;
                                ctx.pc = 5;
                                return 0;
                            }
                            case 9: {
                                ctx.values = args;
                                ctx.proc = proc;
                                ctx.pc = 5;
                                return 0;
                            }
                            case 8: {
                                ctx.values = args;
                                ctx.proc = proc;
                                ctx.pc = 5;
                                return 0;
                            }
                            case 7: {
                                ctx.values = args;
                                ctx.proc = proc;
                                ctx.pc = 5;
                                return 0;
                            }
                            default: {
                                return super.matchN(proc, args, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object applyN(final ModuleMethod method, final Object[] args) {
                        switch (method.selector) {
                            case 7: {
                                return this.lambda12$V(args);
                            }
                            case 8: {
                                return this.lambda13$V(args);
                            }
                            case 9: {
                                return this.lambda14$V(args);
                            }
                            case 10: {
                                return this.lambda15$V(args);
                            }
                            default: {
                                return super.applyN(method, args);
                            }
                        }
                    }
                }
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     3: dup            
                //     4: invokespecial   gnu/kawa/slib/srfi37$frame3.<init>:()V
                //     7: dup            
                //     8: aload_0         /* this */
                //     9: putfield        gnu/kawa/slib/srfi37$frame3.staticLink:Lgnu/kawa/slib/srfi37$frame;
                //    12: astore_3        /* $heapFrame */
                //    13: aload_1         /* args */
                //    14: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //    17: ifeq            33
                //    20: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
                //    23: getstatic       kawa/lib/misc.values:Lgnu/expr/ModuleMethod;
                //    26: aload_2         /* seeds */
                //    27: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    30: goto            921
                //    33: aload_1         /* args */
                //    34: ldc             Lgnu/lists/Pair;.class
                //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    39: dup            
                //    40: astore          5
                //    42: checkcast       Lgnu/lists/Pair;
                //    45: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    48: astore          4
                //    50: aload_1         /* args */
                //    51: ldc             Lgnu/lists/Pair;.class
                //    53: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    56: dup            
                //    57: astore          5
                //    59: checkcast       Lgnu/lists/Pair;
                //    62: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    65: aload_3         /* $heapFrame */
                //    66: swap           
                //    67: putfield        gnu/kawa/slib/srfi37$frame3.args:Ljava/lang/Object;
                //    70: ldc             "--"
                //    72: aload           arg
                //    74: ldc             Ljava/lang/CharSequence;.class
                //    76: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    79: dup            
                //    80: astore          5
                //    82: checkcast       Ljava/lang/CharSequence;
                //    85: iconst_0       
                //    86: anewarray       Ljava/lang/CharSequence;
                //    89: invokestatic    kawa/lib/strings.isString$Eq:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
                //    92: ifeq            107
                //    95: aload_0         /* this */
                //    96: aload_3         /* $heapFrame */
                //    97: getfield        gnu/kawa/slib/srfi37$frame3.args:Ljava/lang/Object;
                //   100: aload_2         /* seeds */
                //   101: invokevirtual   gnu/kawa/slib/srfi37$frame.lambda10scanOperands:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   104: goto            921
                //   107: aload           arg
                //   109: ldc             Ljava/lang/CharSequence;.class
                //   111: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   114: dup            
                //   115: astore          6
                //   117: checkcast       Ljava/lang/CharSequence;
                //   120: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   123: iconst_4       
                //   124: if_icmple       290
                //   127: bipush          45
                //   129: aload           arg
                //   131: ldc             Ljava/lang/CharSequence;.class
                //   133: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   136: dup            
                //   137: astore          6
                //   139: checkcast       Ljava/lang/CharSequence;
                //   142: iconst_0       
                //   143: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   146: if_icmpne       284
                //   149: bipush          45
                //   151: aload           arg
                //   153: ldc             Ljava/lang/CharSequence;.class
                //   155: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   158: dup            
                //   159: astore          6
                //   161: checkcast       Ljava/lang/CharSequence;
                //   164: iconst_1       
                //   165: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   168: if_icmpne       278
                //   171: bipush          61
                //   173: aload           arg
                //   175: ldc             Ljava/lang/CharSequence;.class
                //   177: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   180: dup            
                //   181: astore          6
                //   183: checkcast       Ljava/lang/CharSequence;
                //   186: iconst_2       
                //   187: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   190: if_icmpeq       272
                //   193: getstatic       gnu/kawa/slib/srfi37.Lit0:Lgnu/math/IntNum;
                //   196: astore          index
                //   198: aload           index
                //   200: aload           arg
                //   202: ldc             Ljava/lang/CharSequence;.class
                //   204: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   207: dup            
                //   208: astore          7
                //   210: checkcast       Ljava/lang/CharSequence;
                //   213: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   216: i2l            
                //   217: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
                //   220: ifne            229
                //   223: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   226: goto            293
                //   229: bipush          61
                //   231: aload           arg
                //   233: ldc             Ljava/lang/CharSequence;.class
                //   235: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   238: dup            
                //   239: astore          7
                //   241: checkcast       Ljava/lang/CharSequence;
                //   244: aload           index
                //   246: dup            
                //   247: astore          7
                //   249: invokevirtual   java/lang/Number.intValue:()I
                //   252: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   255: if_icmpne       263
                //   258: aload           index
                //   260: goto            293
                //   263: aload           index
                //   265: iconst_1       
                //   266: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
                //   269: goto            196
                //   272: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   275: goto            293
                //   278: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   281: goto            293
                //   284: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   287: goto            293
                //   290: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   293: astore          temp
                //   295: aload           temp
                //   297: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   300: ifeq            493
                //   303: aload           arg
                //   305: ldc             Ljava/lang/CharSequence;.class
                //   307: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   310: dup            
                //   311: astore          7
                //   313: checkcast       Ljava/lang/CharSequence;
                //   316: iconst_2       
                //   317: aload           temp
                //   319: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   322: dup            
                //   323: astore          7
                //   325: checkcast       Ljava/lang/Number;
                //   328: invokevirtual   java/lang/Number.intValue:()I
                //   331: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //   334: astore          name
                //   336: aload           arg
                //   338: ldc             Ljava/lang/CharSequence;.class
                //   340: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   343: dup            
                //   344: astore          8
                //   346: checkcast       Ljava/lang/CharSequence;
                //   349: iconst_1       
                //   350: aload           temp
                //   352: getstatic       gnu/kawa/slib/srfi37.Lit1:Lgnu/math/IntNum;
                //   355: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   358: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   361: dup            
                //   362: astore          8
                //   364: checkcast       Ljava/lang/Number;
                //   367: invokevirtual   java/lang/Number.intValue:()I
                //   370: aload           arg
                //   372: ldc             Ljava/lang/CharSequence;.class
                //   374: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   377: dup            
                //   378: astore          8
                //   380: checkcast       Ljava/lang/CharSequence;
                //   383: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   386: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //   389: astore          option$Mnarg
                //   391: aload_0         /* this */
                //   392: aload           name
                //   394: invokevirtual   gnu/kawa/slib/srfi37$frame.lambda3findOption:(Ljava/lang/Object;)Ljava/lang/Object;
                //   397: astore          x
                //   399: aload           x
                //   401: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   404: ifeq            412
                //   407: aload           x
                //   409: goto            430
                //   412: aload           name
                //   414: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   417: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                //   420: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   423: aload_0         /* this */
                //   424: getfield        gnu/kawa/slib/srfi37$frame.unrecognized$Mnoption$Mnproc:Ljava/lang/Object;
                //   427: invokestatic    gnu/kawa/slib/srfi37.option:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/slib/srfi37$option-type;
                //   430: astore          option
                //   432: getstatic       gnu/kawa/functions/ApplyWithValues.applyWithValues:Lgnu/kawa/functions/ApplyWithValues;
                //   435: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
                //   438: iconst_5       
                //   439: anewarray       Ljava/lang/Object;
                //   442: dup            
                //   443: iconst_0       
                //   444: aload           option
                //   446: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
                //   448: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   451: dup            
                //   452: astore          9
                //   454: checkcast       Lgnu/kawa/slib/srfi37$option-type;
                //   457: invokestatic    gnu/kawa/slib/srfi37.optionProcessor:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
                //   460: aastore        
                //   461: dup            
                //   462: iconst_1       
                //   463: aload           option
                //   465: aastore        
                //   466: dup            
                //   467: iconst_2       
                //   468: aload           name
                //   470: aastore        
                //   471: dup            
                //   472: iconst_3       
                //   473: aload           option$Mnarg
                //   475: aastore        
                //   476: dup            
                //   477: iconst_4       
                //   478: aload_2         /* seeds */
                //   479: aastore        
                //   480: invokevirtual   gnu/mapping/Procedure.applyN:([Ljava/lang/Object;)Ljava/lang/Object;
                //   483: aload_3         /* $heapFrame */
                //   484: getfield        gnu/kawa/slib/srfi37$frame3.lambda$Fn7:Lgnu/expr/ModuleMethod;
                //   487: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   490: goto            921
                //   493: aload           arg
                //   495: ldc             Ljava/lang/CharSequence;.class
                //   497: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   500: dup            
                //   501: astore          6
                //   503: checkcast       Ljava/lang/CharSequence;
                //   506: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   509: iconst_3       
                //   510: if_icmple       804
                //   513: bipush          45
                //   515: aload           arg
                //   517: ldc             Ljava/lang/CharSequence;.class
                //   519: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   522: dup            
                //   523: astore          6
                //   525: checkcast       Ljava/lang/CharSequence;
                //   528: iconst_0       
                //   529: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   532: if_icmpne       804
                //   535: bipush          45
                //   537: aload           arg
                //   539: ldc             Ljava/lang/CharSequence;.class
                //   541: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   544: dup            
                //   545: astore          6
                //   547: checkcast       Ljava/lang/CharSequence;
                //   550: iconst_1       
                //   551: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   554: if_icmpne       804
                //   557: aload           arg
                //   559: ldc             Ljava/lang/CharSequence;.class
                //   561: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   564: dup            
                //   565: astore          7
                //   567: checkcast       Ljava/lang/CharSequence;
                //   570: iconst_2       
                //   571: aload           arg
                //   573: ldc             Ljava/lang/CharSequence;.class
                //   575: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   578: dup            
                //   579: astore          7
                //   581: checkcast       Ljava/lang/CharSequence;
                //   584: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   587: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //   590: astore          name
                //   592: aload_0         /* this */
                //   593: aload           name
                //   595: invokevirtual   gnu/kawa/slib/srfi37$frame.lambda3findOption:(Ljava/lang/Object;)Ljava/lang/Object;
                //   598: astore          x
                //   600: aload           x
                //   602: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   605: ifeq            613
                //   608: aload           x
                //   610: goto            631
                //   613: aload           name
                //   615: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   618: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   621: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   624: aload_0         /* this */
                //   625: getfield        gnu/kawa/slib/srfi37$frame.unrecognized$Mnoption$Mnproc:Ljava/lang/Object;
                //   628: invokestatic    gnu/kawa/slib/srfi37.option:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/slib/srfi37$option-type;
                //   631: astore          option
                //   633: aload           option
                //   635: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
                //   637: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   640: dup            
                //   641: astore          8
                //   643: checkcast       Lgnu/kawa/slib/srfi37$option-type;
                //   646: invokestatic    gnu/kawa/slib/srfi37.isOptionRequiredArg:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
                //   649: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   652: ifeq            742
                //   655: aload_3         /* $heapFrame */
                //   656: getfield        gnu/kawa/slib/srfi37$frame3.args:Ljava/lang/Object;
                //   659: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                //   662: ifeq            742
                //   665: getstatic       gnu/kawa/functions/ApplyWithValues.applyWithValues:Lgnu/kawa/functions/ApplyWithValues;
                //   668: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
                //   671: iconst_5       
                //   672: anewarray       Ljava/lang/Object;
                //   675: dup            
                //   676: iconst_0       
                //   677: aload           option
                //   679: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
                //   681: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   684: dup            
                //   685: astore          8
                //   687: checkcast       Lgnu/kawa/slib/srfi37$option-type;
                //   690: invokestatic    gnu/kawa/slib/srfi37.optionProcessor:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
                //   693: aastore        
                //   694: dup            
                //   695: iconst_1       
                //   696: aload           option
                //   698: aastore        
                //   699: dup            
                //   700: iconst_2       
                //   701: aload           name
                //   703: aastore        
                //   704: dup            
                //   705: iconst_3       
                //   706: aload_3         /* $heapFrame */
                //   707: getfield        gnu/kawa/slib/srfi37$frame3.args:Ljava/lang/Object;
                //   710: ldc             Lgnu/lists/Pair;.class
                //   712: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   715: dup            
                //   716: astore          8
                //   718: checkcast       Lgnu/lists/Pair;
                //   721: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   724: aastore        
                //   725: dup            
                //   726: iconst_4       
                //   727: aload_2         /* seeds */
                //   728: aastore        
                //   729: invokevirtual   gnu/mapping/Procedure.applyN:([Ljava/lang/Object;)Ljava/lang/Object;
                //   732: aload_3         /* $heapFrame */
                //   733: getfield        gnu/kawa/slib/srfi37$frame3.lambda$Fn8:Lgnu/expr/ModuleMethod;
                //   736: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   739: goto            921
                //   742: getstatic       gnu/kawa/functions/ApplyWithValues.applyWithValues:Lgnu/kawa/functions/ApplyWithValues;
                //   745: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
                //   748: iconst_5       
                //   749: anewarray       Ljava/lang/Object;
                //   752: dup            
                //   753: iconst_0       
                //   754: aload           option
                //   756: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
                //   758: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   761: dup            
                //   762: astore          8
                //   764: checkcast       Lgnu/kawa/slib/srfi37$option-type;
                //   767: invokestatic    gnu/kawa/slib/srfi37.optionProcessor:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
                //   770: aastore        
                //   771: dup            
                //   772: iconst_1       
                //   773: aload           option
                //   775: aastore        
                //   776: dup            
                //   777: iconst_2       
                //   778: aload           name
                //   780: aastore        
                //   781: dup            
                //   782: iconst_3       
                //   783: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   786: aastore        
                //   787: dup            
                //   788: iconst_4       
                //   789: aload_2         /* seeds */
                //   790: aastore        
                //   791: invokevirtual   gnu/mapping/Procedure.applyN:([Ljava/lang/Object;)Ljava/lang/Object;
                //   794: aload_3         /* $heapFrame */
                //   795: getfield        gnu/kawa/slib/srfi37$frame3.lambda$Fn9:Lgnu/expr/ModuleMethod;
                //   798: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   801: goto            921
                //   804: aload           arg
                //   806: ldc             Ljava/lang/CharSequence;.class
                //   808: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   811: dup            
                //   812: astore          6
                //   814: checkcast       Ljava/lang/CharSequence;
                //   817: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   820: iconst_1       
                //   821: if_icmple       898
                //   824: bipush          45
                //   826: aload           arg
                //   828: ldc             Ljava/lang/CharSequence;.class
                //   830: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   833: dup            
                //   834: astore          6
                //   836: checkcast       Ljava/lang/CharSequence;
                //   839: iconst_0       
                //   840: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   843: if_icmpne       898
                //   846: aload           arg
                //   848: ldc             Ljava/lang/CharSequence;.class
                //   850: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   853: dup            
                //   854: astore          7
                //   856: checkcast       Ljava/lang/CharSequence;
                //   859: iconst_1       
                //   860: aload           arg
                //   862: ldc             Ljava/lang/CharSequence;.class
                //   864: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   867: dup            
                //   868: astore          7
                //   870: checkcast       Ljava/lang/CharSequence;
                //   873: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   876: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //   879: astore          shorts
                //   881: aload_0         /* this */
                //   882: getstatic       gnu/kawa/slib/srfi37.Lit2:Lgnu/math/IntNum;
                //   885: aload           shorts
                //   887: aload_3         /* $heapFrame */
                //   888: getfield        gnu/kawa/slib/srfi37$frame3.args:Ljava/lang/Object;
                //   891: aload_2         /* seeds */
                //   892: invokevirtual   gnu/kawa/slib/srfi37$frame.lambda6scanShortOptions:(Lgnu/math/IntNum;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   895: goto            921
                //   898: getstatic       gnu/kawa/functions/ApplyWithValues.applyWithValues:Lgnu/kawa/functions/ApplyWithValues;
                //   901: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
                //   904: aload_0         /* this */
                //   905: getfield        gnu/kawa/slib/srfi37$frame.operand$Mnproc:Ljava/lang/Object;
                //   908: aload           arg
                //   910: aload_2         /* seeds */
                //   911: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   914: aload_3         /* $heapFrame */
                //   915: getfield        gnu/kawa/slib/srfi37$frame3.lambda$Fn10:Lgnu/expr/ModuleMethod;
                //   918: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   921: areturn        
                //   922: new             Lgnu/mapping/WrongType;
                //   925: dup_x1         
                //   926: swap           
                //   927: ldc             "car"
                //   929: iconst_1       
                //   930: aload           5
                //   932: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   935: athrow         
                //   936: new             Lgnu/mapping/WrongType;
                //   939: dup_x1         
                //   940: swap           
                //   941: ldc             "cdr"
                //   943: iconst_1       
                //   944: aload           5
                //   946: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   949: athrow         
                //   950: new             Lgnu/mapping/WrongType;
                //   953: dup_x1         
                //   954: swap           
                //   955: ldc             "string=?"
                //   957: iconst_2       
                //   958: aload           5
                //   960: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   963: athrow         
                //   964: new             Lgnu/mapping/WrongType;
                //   967: dup_x1         
                //   968: swap           
                //   969: ldc             "string-length"
                //   971: iconst_1       
                //   972: aload           6
                //   974: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   977: athrow         
                //   978: new             Lgnu/mapping/WrongType;
                //   981: dup_x1         
                //   982: swap           
                //   983: ldc             "string-ref"
                //   985: iconst_1       
                //   986: aload           6
                //   988: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   991: athrow         
                //   992: new             Lgnu/mapping/WrongType;
                //   995: dup_x1         
                //   996: swap           
                //   997: ldc             "string-ref"
                //   999: iconst_1       
                //  1000: aload           6
                //  1002: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1005: athrow         
                //  1006: new             Lgnu/mapping/WrongType;
                //  1009: dup_x1         
                //  1010: swap           
                //  1011: ldc             "string-ref"
                //  1013: iconst_1       
                //  1014: aload           6
                //  1016: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1019: athrow         
                //  1020: new             Lgnu/mapping/WrongType;
                //  1023: dup_x1         
                //  1024: swap           
                //  1025: ldc             "string-length"
                //  1027: iconst_1       
                //  1028: aload           7
                //  1030: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1033: athrow         
                //  1034: new             Lgnu/mapping/WrongType;
                //  1037: dup_x1         
                //  1038: swap           
                //  1039: ldc             "string-ref"
                //  1041: iconst_1       
                //  1042: aload           7
                //  1044: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1047: athrow         
                //  1048: new             Lgnu/mapping/WrongType;
                //  1051: dup_x1         
                //  1052: swap           
                //  1053: ldc             "string-ref"
                //  1055: iconst_2       
                //  1056: aload           7
                //  1058: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1061: athrow         
                //  1062: new             Lgnu/mapping/WrongType;
                //  1065: dup_x1         
                //  1066: swap           
                //  1067: ldc             "substring"
                //  1069: iconst_1       
                //  1070: aload           7
                //  1072: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1075: athrow         
                //  1076: new             Lgnu/mapping/WrongType;
                //  1079: dup_x1         
                //  1080: swap           
                //  1081: ldc             "substring"
                //  1083: iconst_3       
                //  1084: aload           7
                //  1086: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1089: athrow         
                //  1090: new             Lgnu/mapping/WrongType;
                //  1093: dup_x1         
                //  1094: swap           
                //  1095: ldc             "substring"
                //  1097: iconst_1       
                //  1098: aload           8
                //  1100: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1103: athrow         
                //  1104: new             Lgnu/mapping/WrongType;
                //  1107: dup_x1         
                //  1108: swap           
                //  1109: ldc             "substring"
                //  1111: iconst_2       
                //  1112: aload           8
                //  1114: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1117: athrow         
                //  1118: new             Lgnu/mapping/WrongType;
                //  1121: dup_x1         
                //  1122: swap           
                //  1123: ldc             "string-length"
                //  1125: iconst_1       
                //  1126: aload           8
                //  1128: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1131: athrow         
                //  1132: new             Lgnu/mapping/WrongType;
                //  1135: dup_x1         
                //  1136: swap           
                //  1137: ldc             "option-processor"
                //  1139: iconst_0       
                //  1140: aload           9
                //  1142: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1145: athrow         
                //  1146: new             Lgnu/mapping/WrongType;
                //  1149: dup_x1         
                //  1150: swap           
                //  1151: ldc             "string-length"
                //  1153: iconst_1       
                //  1154: aload           6
                //  1156: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1159: athrow         
                //  1160: new             Lgnu/mapping/WrongType;
                //  1163: dup_x1         
                //  1164: swap           
                //  1165: ldc             "string-ref"
                //  1167: iconst_1       
                //  1168: aload           6
                //  1170: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1173: athrow         
                //  1174: new             Lgnu/mapping/WrongType;
                //  1177: dup_x1         
                //  1178: swap           
                //  1179: ldc             "string-ref"
                //  1181: iconst_1       
                //  1182: aload           6
                //  1184: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1187: athrow         
                //  1188: new             Lgnu/mapping/WrongType;
                //  1191: dup_x1         
                //  1192: swap           
                //  1193: ldc             "substring"
                //  1195: iconst_1       
                //  1196: aload           7
                //  1198: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1201: athrow         
                //  1202: new             Lgnu/mapping/WrongType;
                //  1205: dup_x1         
                //  1206: swap           
                //  1207: ldc             "string-length"
                //  1209: iconst_1       
                //  1210: aload           7
                //  1212: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1215: athrow         
                //  1216: new             Lgnu/mapping/WrongType;
                //  1219: dup_x1         
                //  1220: swap           
                //  1221: ldc             "option-required-arg?"
                //  1223: iconst_0       
                //  1224: aload           8
                //  1226: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1229: athrow         
                //  1230: new             Lgnu/mapping/WrongType;
                //  1233: dup_x1         
                //  1234: swap           
                //  1235: ldc             "option-processor"
                //  1237: iconst_0       
                //  1238: aload           8
                //  1240: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1243: athrow         
                //  1244: new             Lgnu/mapping/WrongType;
                //  1247: dup_x1         
                //  1248: swap           
                //  1249: ldc             "car"
                //  1251: iconst_1       
                //  1252: aload           8
                //  1254: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1257: athrow         
                //  1258: new             Lgnu/mapping/WrongType;
                //  1261: dup_x1         
                //  1262: swap           
                //  1263: ldc             "option-processor"
                //  1265: iconst_0       
                //  1266: aload           8
                //  1268: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1271: athrow         
                //  1272: new             Lgnu/mapping/WrongType;
                //  1275: dup_x1         
                //  1276: swap           
                //  1277: ldc             "string-length"
                //  1279: iconst_1       
                //  1280: aload           6
                //  1282: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1285: athrow         
                //  1286: new             Lgnu/mapping/WrongType;
                //  1289: dup_x1         
                //  1290: swap           
                //  1291: ldc             "string-ref"
                //  1293: iconst_1       
                //  1294: aload           6
                //  1296: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1299: athrow         
                //  1300: new             Lgnu/mapping/WrongType;
                //  1303: dup_x1         
                //  1304: swap           
                //  1305: ldc             "substring"
                //  1307: iconst_1       
                //  1308: aload           7
                //  1310: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1313: athrow         
                //  1314: new             Lgnu/mapping/WrongType;
                //  1317: dup_x1         
                //  1318: swap           
                //  1319: ldc             "string-length"
                //  1321: iconst_1       
                //  1322: aload           7
                //  1324: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1327: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  42     45     922    936    Ljava/lang/ClassCastException;
                //  59     62     936    950    Ljava/lang/ClassCastException;
                //  82     85     950    964    Ljava/lang/ClassCastException;
                //  117    120    964    978    Ljava/lang/ClassCastException;
                //  139    142    978    992    Ljava/lang/ClassCastException;
                //  161    164    992    1006   Ljava/lang/ClassCastException;
                //  183    186    1006   1020   Ljava/lang/ClassCastException;
                //  210    213    1020   1034   Ljava/lang/ClassCastException;
                //  241    244    1034   1048   Ljava/lang/ClassCastException;
                //  249    252    1048   1062   Ljava/lang/ClassCastException;
                //  313    316    1062   1076   Ljava/lang/ClassCastException;
                //  325    331    1076   1090   Ljava/lang/ClassCastException;
                //  346    349    1090   1104   Ljava/lang/ClassCastException;
                //  364    370    1104   1118   Ljava/lang/ClassCastException;
                //  380    383    1118   1132   Ljava/lang/ClassCastException;
                //  454    457    1132   1146   Ljava/lang/ClassCastException;
                //  503    506    1146   1160   Ljava/lang/ClassCastException;
                //  525    528    1160   1174   Ljava/lang/ClassCastException;
                //  547    550    1174   1188   Ljava/lang/ClassCastException;
                //  567    570    1188   1202   Ljava/lang/ClassCastException;
                //  581    584    1202   1216   Ljava/lang/ClassCastException;
                //  643    646    1216   1230   Ljava/lang/ClassCastException;
                //  687    690    1230   1244   Ljava/lang/ClassCastException;
                //  718    721    1244   1258   Ljava/lang/ClassCastException;
                //  764    767    1258   1272   Ljava/lang/ClassCastException;
                //  814    817    1272   1286   Ljava/lang/ClassCastException;
                //  836    839    1286   1300   Ljava/lang/ClassCastException;
                //  856    859    1300   1314   Ljava/lang/ClassCastException;
                //  870    873    1314   1328   Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
            
            public static Object lambda2find(final Object l, final Object $Qu) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //     4: ifeq            13
                //     7: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //    10: goto            75
                //    13: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    16: aload_1         /* $Qu */
                //    17: aload_0         /* l */
                //    18: ldc             Lgnu/lists/Pair;.class
                //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    23: dup            
                //    24: astore_2       
                //    25: checkcast       Lgnu/lists/Pair;
                //    28: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    31: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    34: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    37: ifeq            57
                //    40: aload_0         /* l */
                //    41: ldc             Lgnu/lists/Pair;.class
                //    43: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    46: dup            
                //    47: astore_2       
                //    48: checkcast       Lgnu/lists/Pair;
                //    51: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    54: goto            75
                //    57: aload_0         /* l */
                //    58: ldc             Lgnu/lists/Pair;.class
                //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    63: dup            
                //    64: astore_2       
                //    65: checkcast       Lgnu/lists/Pair;
                //    68: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    71: astore_0        /* l */
                //    72: goto            0
                //    75: areturn        
                //    76: new             Lgnu/mapping/WrongType;
                //    79: dup_x1         
                //    80: swap           
                //    81: ldc             "car"
                //    83: iconst_1       
                //    84: aload_2        
                //    85: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //    88: athrow         
                //    89: new             Lgnu/mapping/WrongType;
                //    92: dup_x1         
                //    93: swap           
                //    94: ldc             "car"
                //    96: iconst_1       
                //    97: aload_2        
                //    98: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   101: athrow         
                //   102: new             Lgnu/mapping/WrongType;
                //   105: dup_x1         
                //   106: swap           
                //   107: ldc             "cdr"
                //   109: iconst_1       
                //   110: aload_2        
                //   111: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   114: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  25     28     76     89     Ljava/lang/ClassCastException;
                //  48     51     89     102    Ljava/lang/ClassCastException;
                //  65     68     102    115    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 59 out of bounds for length 59
                //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
                //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
                //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
                //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
                //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
                //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
                //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
                //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
                //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
                //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
            
            public Object lambda3findOption(final Object name) {
                public class srfi37$frame0 extends ModuleBody
                {
                    Object name;
                    srfi37$frame staticLink;
                    final ModuleMethod lambda$Fn1;
                    final ModuleMethod lambda$Fn2;
                    
                    public srfi37$frame0() {
                        final ModuleMethod lambda$Fn2 = new ModuleMethod(this, 1, null, 4097);
                        lambda$Fn2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi37.scm:73");
                        this.lambda$Fn2 = lambda$Fn2;
                        final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 2, null, 4097);
                        lambda$Fn3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi37.scm:70");
                        this.lambda$Fn1 = lambda$Fn3;
                    }
                    
                    Object lambda4(final Object option) {
                        final Object force = Promise.force(option, option-type.class);
                        try {
                            return srfi37$frame.lambda2find(srfi37.optionNames((option-type)force), this.lambda$Fn2);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "option-names", 0, force);
                        }
                    }
                    
                    Object lambda5(final Object test$Mnname) {
                        return Scheme.isEqual.apply2(this.name, test$Mnname);
                    }
                    
                    @Override
                    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
                        switch (proc.selector) {
                            case 2: {
                                ctx.value1 = arg1;
                                ctx.proc = proc;
                                ctx.pc = 1;
                                return 0;
                            }
                            case 1: {
                                ctx.value1 = arg1;
                                ctx.proc = proc;
                                ctx.pc = 1;
                                return 0;
                            }
                            default: {
                                return super.match1(proc, arg1, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply1(final ModuleMethod method, final Object arg1) {
                        switch (method.selector) {
                            case 1: {
                                return this.lambda5(arg1);
                            }
                            case 2: {
                                return this.lambda4(arg1);
                            }
                            default: {
                                return super.apply1(method, arg1);
                            }
                        }
                    }
                }
                final srfi37$frame0 srfi37$frame0 = new srfi37$frame0();
                srfi37$frame0.staticLink = this;
                final srfi37$frame0 $heapFrame = srfi37$frame0;
                $heapFrame.name = name;
                return lambda2find(this.options, $heapFrame.lambda$Fn1);
            }
            
            public Object lambda6scanShortOptions(final IntNum index, final Object shorts, final Object args, final Object seeds) {
                public class srfi37$frame1 extends ModuleBody
                {
                    Object shorts;
                    IntNum index;
                    Object args;
                    srfi37$frame staticLink;
                    final ModuleMethod lambda$Fn3;
                    final ModuleMethod lambda$Fn4;
                    final ModuleMethod lambda$Fn5;
                    
                    public srfi37$frame1() {
                        final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 3, null, -4096);
                        lambda$Fn3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi37.scm:89");
                        this.lambda$Fn3 = lambda$Fn3;
                        final ModuleMethod lambda$Fn4 = new ModuleMethod(this, 4, null, -4096);
                        lambda$Fn4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi37.scm:101");
                        this.lambda$Fn4 = lambda$Fn4;
                        final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 5, null, -4096);
                        lambda$Fn5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi37.scm:109");
                        this.lambda$Fn5 = lambda$Fn5;
                    }
                    
                    Object lambda7$V(final Object[] argsArray) {
                        final LList seeds = LList.makeList(argsArray, 0);
                        return this.staticLink.lambda1scanArgs(this.args, seeds);
                    }
                    
                    Object lambda8$V(final Object[] argsArray) {
                        final LList seeds = LList.makeList(argsArray, 0);
                        final srfi37$frame staticLink = this.staticLink;
                        final Object force = Promise.force(this.args, Pair.class);
                        try {
                            return staticLink.lambda1scanArgs(lists.cdr((Pair)force), seeds);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "cdr", 1, force);
                        }
                    }
                    
                    Object lambda9$V(final Object[] argsArray) {
                        final LList seeds = LList.makeList(argsArray, 0);
                        return this.staticLink.lambda6scanShortOptions(IntNum.add(this.index, 1), this.shorts, this.args, seeds);
                    }
                    
                    @Override
                    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 5: {
                                ctx.values = array;
                                ctx.proc = moduleMethod;
                                ctx.pc = 5;
                                return 0;
                            }
                            case 4: {
                                ctx.values = array;
                                ctx.proc = moduleMethod;
                                ctx.pc = 5;
                                return 0;
                            }
                            case 3: {
                                ctx.values = array;
                                ctx.proc = moduleMethod;
                                ctx.pc = 5;
                                return 0;
                            }
                            default: {
                                return super.matchN(moduleMethod, array, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object applyN(final ModuleMethod method, final Object[] array) {
                        switch (method.selector) {
                            case 3: {
                                return this.lambda7$V(array);
                            }
                            case 4: {
                                return this.lambda8$V(array);
                            }
                            case 5: {
                                return this.lambda9$V(array);
                            }
                            default: {
                                return super.applyN(method, array);
                            }
                        }
                    }
                }
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     3: dup            
                //     4: invokespecial   gnu/kawa/slib/srfi37$frame1.<init>:()V
                //     7: dup            
                //     8: aload_0         /* this */
                //     9: putfield        gnu/kawa/slib/srfi37$frame1.staticLink:Lgnu/kawa/slib/srfi37$frame;
                //    12: astore          $heapFrame
                //    14: aload           $heapFrame
                //    16: aload_1         /* index */
                //    17: putfield        gnu/kawa/slib/srfi37$frame1.index:Lgnu/math/IntNum;
                //    20: aload           $heapFrame
                //    22: aload_2         /* shorts */
                //    23: putfield        gnu/kawa/slib/srfi37$frame1.shorts:Ljava/lang/Object;
                //    26: aload           $heapFrame
                //    28: aload_3         /* args */
                //    29: putfield        gnu/kawa/slib/srfi37$frame1.args:Ljava/lang/Object;
                //    32: aload           $heapFrame
                //    34: getfield        gnu/kawa/slib/srfi37$frame1.index:Lgnu/math/IntNum;
                //    37: aload           $heapFrame
                //    39: getfield        gnu/kawa/slib/srfi37$frame1.shorts:Ljava/lang/Object;
                //    42: ldc             Ljava/lang/CharSequence;.class
                //    44: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    47: dup            
                //    48: astore          6
                //    50: checkcast       Ljava/lang/CharSequence;
                //    53: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //    56: i2l            
                //    57: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
                //    60: ifne            77
                //    63: aload_0         /* this */
                //    64: aload           $heapFrame
                //    66: getfield        gnu/kawa/slib/srfi37$frame1.args:Ljava/lang/Object;
                //    69: aload           seeds
                //    71: invokevirtual   gnu/kawa/slib/srfi37$frame.lambda1scanArgs:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    74: goto            542
                //    77: aload           $heapFrame
                //    79: getfield        gnu/kawa/slib/srfi37$frame1.shorts:Ljava/lang/Object;
                //    82: ldc             Ljava/lang/CharSequence;.class
                //    84: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    87: dup            
                //    88: astore          7
                //    90: checkcast       Ljava/lang/CharSequence;
                //    93: aload           $heapFrame
                //    95: getfield        gnu/kawa/slib/srfi37$frame1.index:Lgnu/math/IntNum;
                //    98: dup            
                //    99: astore          7
                //   101: invokevirtual   java/lang/Number.intValue:()I
                //   104: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   107: istore          name
                //   109: aload_0         /* this */
                //   110: iload           name
                //   112: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //   115: invokevirtual   gnu/kawa/slib/srfi37$frame.lambda3findOption:(Ljava/lang/Object;)Ljava/lang/Object;
                //   118: astore          x
                //   120: aload           x
                //   122: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   125: ifeq            133
                //   128: aload           x
                //   130: goto            154
                //   133: iload           name
                //   135: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //   138: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   141: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   144: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   147: aload_0         /* this */
                //   148: getfield        gnu/kawa/slib/srfi37$frame.unrecognized$Mnoption$Mnproc:Ljava/lang/Object;
                //   151: invokestatic    gnu/kawa/slib/srfi37.option:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/slib/srfi37$option-type;
                //   154: astore          option
                //   156: aload           $heapFrame
                //   158: getfield        gnu/kawa/slib/srfi37$frame1.index:Lgnu/math/IntNum;
                //   161: iconst_1       
                //   162: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
                //   165: aload           $heapFrame
                //   167: getfield        gnu/kawa/slib/srfi37$frame1.shorts:Ljava/lang/Object;
                //   170: ldc             Ljava/lang/CharSequence;.class
                //   172: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   175: dup            
                //   176: astore          8
                //   178: checkcast       Ljava/lang/CharSequence;
                //   181: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   184: i2l            
                //   185: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
                //   188: ifge            362
                //   191: aload           option
                //   193: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
                //   195: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   198: dup            
                //   199: astore          9
                //   201: checkcast       Lgnu/kawa/slib/srfi37$option-type;
                //   204: invokestatic    gnu/kawa/slib/srfi37.isOptionRequiredArg:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
                //   207: astore          x
                //   209: aload           x
                //   211: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   214: ifeq            228
                //   217: aload           x
                //   219: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   222: ifeq            362
                //   225: goto            250
                //   228: aload           option
                //   230: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
                //   232: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   235: dup            
                //   236: astore          9
                //   238: checkcast       Lgnu/kawa/slib/srfi37$option-type;
                //   241: invokestatic    gnu/kawa/slib/srfi37.isOptionOptionalArg:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
                //   244: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   247: ifeq            362
                //   250: getstatic       gnu/kawa/functions/ApplyWithValues.applyWithValues:Lgnu/kawa/functions/ApplyWithValues;
                //   253: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
                //   256: iconst_5       
                //   257: anewarray       Ljava/lang/Object;
                //   260: dup            
                //   261: iconst_0       
                //   262: aload           option
                //   264: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
                //   266: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   269: dup            
                //   270: astore          9
                //   272: checkcast       Lgnu/kawa/slib/srfi37$option-type;
                //   275: invokestatic    gnu/kawa/slib/srfi37.optionProcessor:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
                //   278: aastore        
                //   279: dup            
                //   280: iconst_1       
                //   281: aload           option
                //   283: aastore        
                //   284: dup            
                //   285: iconst_2       
                //   286: iload           name
                //   288: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //   291: aastore        
                //   292: dup            
                //   293: iconst_3       
                //   294: aload           $heapFrame
                //   296: getfield        gnu/kawa/slib/srfi37$frame1.shorts:Ljava/lang/Object;
                //   299: ldc             Ljava/lang/CharSequence;.class
                //   301: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   304: dup            
                //   305: astore          9
                //   307: checkcast       Ljava/lang/CharSequence;
                //   310: aload           $heapFrame
                //   312: getfield        gnu/kawa/slib/srfi37$frame1.index:Lgnu/math/IntNum;
                //   315: invokevirtual   java/lang/Number.intValue:()I
                //   318: iconst_1       
                //   319: iadd           
                //   320: aload           $heapFrame
                //   322: getfield        gnu/kawa/slib/srfi37$frame1.shorts:Ljava/lang/Object;
                //   325: ldc             Ljava/lang/CharSequence;.class
                //   327: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   330: dup            
                //   331: astore          9
                //   333: checkcast       Ljava/lang/CharSequence;
                //   336: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   339: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //   342: aastore        
                //   343: dup            
                //   344: iconst_4       
                //   345: aload           seeds
                //   347: aastore        
                //   348: invokevirtual   gnu/mapping/Procedure.applyN:([Ljava/lang/Object;)Ljava/lang/Object;
                //   351: aload           $heapFrame
                //   353: getfield        gnu/kawa/slib/srfi37$frame1.lambda$Fn3:Lgnu/expr/ModuleMethod;
                //   356: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   359: goto            542
                //   362: aload           option
                //   364: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
                //   366: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   369: dup            
                //   370: astore          8
                //   372: checkcast       Lgnu/kawa/slib/srfi37$option-type;
                //   375: invokestatic    gnu/kawa/slib/srfi37.isOptionRequiredArg:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
                //   378: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   381: ifeq            478
                //   384: aload           $heapFrame
                //   386: getfield        gnu/kawa/slib/srfi37$frame1.args:Ljava/lang/Object;
                //   389: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
                //   392: ifeq            478
                //   395: getstatic       gnu/kawa/functions/ApplyWithValues.applyWithValues:Lgnu/kawa/functions/ApplyWithValues;
                //   398: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
                //   401: iconst_5       
                //   402: anewarray       Ljava/lang/Object;
                //   405: dup            
                //   406: iconst_0       
                //   407: aload           option
                //   409: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
                //   411: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   414: dup            
                //   415: astore          8
                //   417: checkcast       Lgnu/kawa/slib/srfi37$option-type;
                //   420: invokestatic    gnu/kawa/slib/srfi37.optionProcessor:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
                //   423: aastore        
                //   424: dup            
                //   425: iconst_1       
                //   426: aload           option
                //   428: aastore        
                //   429: dup            
                //   430: iconst_2       
                //   431: iload           name
                //   433: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //   436: aastore        
                //   437: dup            
                //   438: iconst_3       
                //   439: aload           $heapFrame
                //   441: getfield        gnu/kawa/slib/srfi37$frame1.args:Ljava/lang/Object;
                //   444: ldc             Lgnu/lists/Pair;.class
                //   446: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   449: dup            
                //   450: astore          8
                //   452: checkcast       Lgnu/lists/Pair;
                //   455: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   458: aastore        
                //   459: dup            
                //   460: iconst_4       
                //   461: aload           seeds
                //   463: aastore        
                //   464: invokevirtual   gnu/mapping/Procedure.applyN:([Ljava/lang/Object;)Ljava/lang/Object;
                //   467: aload           $heapFrame
                //   469: getfield        gnu/kawa/slib/srfi37$frame1.lambda$Fn4:Lgnu/expr/ModuleMethod;
                //   472: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   475: goto            542
                //   478: getstatic       gnu/kawa/functions/ApplyWithValues.applyWithValues:Lgnu/kawa/functions/ApplyWithValues;
                //   481: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
                //   484: iconst_5       
                //   485: anewarray       Ljava/lang/Object;
                //   488: dup            
                //   489: iconst_0       
                //   490: aload           option
                //   492: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
                //   494: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   497: dup            
                //   498: astore          8
                //   500: checkcast       Lgnu/kawa/slib/srfi37$option-type;
                //   503: invokestatic    gnu/kawa/slib/srfi37.optionProcessor:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
                //   506: aastore        
                //   507: dup            
                //   508: iconst_1       
                //   509: aload           option
                //   511: aastore        
                //   512: dup            
                //   513: iconst_2       
                //   514: iload           name
                //   516: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //   519: aastore        
                //   520: dup            
                //   521: iconst_3       
                //   522: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   525: aastore        
                //   526: dup            
                //   527: iconst_4       
                //   528: aload           seeds
                //   530: aastore        
                //   531: invokevirtual   gnu/mapping/Procedure.applyN:([Ljava/lang/Object;)Ljava/lang/Object;
                //   534: aload           $heapFrame
                //   536: getfield        gnu/kawa/slib/srfi37$frame1.lambda$Fn5:Lgnu/expr/ModuleMethod;
                //   539: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   542: areturn        
                //   543: new             Lgnu/mapping/WrongType;
                //   546: dup_x1         
                //   547: swap           
                //   548: ldc             "string-length"
                //   550: iconst_1       
                //   551: aload           6
                //   553: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   556: athrow         
                //   557: new             Lgnu/mapping/WrongType;
                //   560: dup_x1         
                //   561: swap           
                //   562: ldc             "string-ref"
                //   564: iconst_1       
                //   565: aload           7
                //   567: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   570: athrow         
                //   571: new             Lgnu/mapping/WrongType;
                //   574: dup_x1         
                //   575: swap           
                //   576: ldc             "string-ref"
                //   578: iconst_2       
                //   579: aload           7
                //   581: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   584: athrow         
                //   585: new             Lgnu/mapping/WrongType;
                //   588: dup_x1         
                //   589: swap           
                //   590: ldc             "string-length"
                //   592: iconst_1       
                //   593: aload           8
                //   595: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   598: athrow         
                //   599: new             Lgnu/mapping/WrongType;
                //   602: dup_x1         
                //   603: swap           
                //   604: ldc             "option-required-arg?"
                //   606: iconst_0       
                //   607: aload           9
                //   609: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   612: athrow         
                //   613: new             Lgnu/mapping/WrongType;
                //   616: dup_x1         
                //   617: swap           
                //   618: ldc             "option-optional-arg?"
                //   620: iconst_0       
                //   621: aload           9
                //   623: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   626: athrow         
                //   627: new             Lgnu/mapping/WrongType;
                //   630: dup_x1         
                //   631: swap           
                //   632: ldc             "option-processor"
                //   634: iconst_0       
                //   635: aload           9
                //   637: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   640: athrow         
                //   641: new             Lgnu/mapping/WrongType;
                //   644: dup_x1         
                //   645: swap           
                //   646: ldc             "substring"
                //   648: iconst_1       
                //   649: aload           9
                //   651: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   654: athrow         
                //   655: new             Lgnu/mapping/WrongType;
                //   658: dup_x1         
                //   659: swap           
                //   660: ldc             "string-length"
                //   662: iconst_1       
                //   663: aload           9
                //   665: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   668: athrow         
                //   669: new             Lgnu/mapping/WrongType;
                //   672: dup_x1         
                //   673: swap           
                //   674: ldc             "option-required-arg?"
                //   676: iconst_0       
                //   677: aload           8
                //   679: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   682: athrow         
                //   683: new             Lgnu/mapping/WrongType;
                //   686: dup_x1         
                //   687: swap           
                //   688: ldc             "option-processor"
                //   690: iconst_0       
                //   691: aload           8
                //   693: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   696: athrow         
                //   697: new             Lgnu/mapping/WrongType;
                //   700: dup_x1         
                //   701: swap           
                //   702: ldc             "car"
                //   704: iconst_1       
                //   705: aload           8
                //   707: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   710: athrow         
                //   711: new             Lgnu/mapping/WrongType;
                //   714: dup_x1         
                //   715: swap           
                //   716: ldc             "option-processor"
                //   718: iconst_0       
                //   719: aload           8
                //   721: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   724: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  50     53     543    557    Ljava/lang/ClassCastException;
                //  90     93     557    571    Ljava/lang/ClassCastException;
                //  101    104    571    585    Ljava/lang/ClassCastException;
                //  178    181    585    599    Ljava/lang/ClassCastException;
                //  201    204    599    613    Ljava/lang/ClassCastException;
                //  238    241    613    627    Ljava/lang/ClassCastException;
                //  272    275    627    641    Ljava/lang/ClassCastException;
                //  307    310    641    655    Ljava/lang/ClassCastException;
                //  333    336    655    669    Ljava/lang/ClassCastException;
                //  372    375    669    683    Ljava/lang/ClassCastException;
                //  417    420    683    697    Ljava/lang/ClassCastException;
                //  452    455    697    711    Ljava/lang/ClassCastException;
                //  500    503    711    725    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 359 out of bounds for length 359
                //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
                //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
                //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
                //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
                //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
                //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
                //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
                //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
                //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
                //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
            
            public Object lambda10scanOperands(final Object operands, final Object seeds) {
                public class srfi37$frame2 extends ModuleBody
                {
                    Object operands;
                    srfi37$frame staticLink;
                    final ModuleMethod lambda$Fn6;
                    
                    public srfi37$frame2() {
                        final ModuleMethod lambda$Fn6 = new ModuleMethod(this, 6, null, -4096);
                        lambda$Fn6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi37.scm:123");
                        this.lambda$Fn6 = lambda$Fn6;
                    }
                    
                    Object lambda11$V(final Object[] argsArray) {
                        final LList seeds = LList.makeList(argsArray, 0);
                        final srfi37$frame staticLink = this.staticLink;
                        final Object force = Promise.force(this.operands, Pair.class);
                        try {
                            return staticLink.lambda10scanOperands(lists.cdr((Pair)force), seeds);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "cdr", 1, force);
                        }
                    }
                    
                    @Override
                    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
                        if (moduleMethod.selector == 6) {
                            ctx.values = array;
                            ctx.proc = moduleMethod;
                            ctx.pc = 5;
                            return 0;
                        }
                        return super.matchN(moduleMethod, array, ctx);
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object applyN(final ModuleMethod method, final Object[] array) {
                        if (method.selector == 6) {
                            return this.lambda11$V(array);
                        }
                        return super.applyN(method, array);
                    }
                }
                final srfi37$frame2 srfi37$frame2 = new srfi37$frame2();
                srfi37$frame2.staticLink = this;
                final srfi37$frame2 $heapFrame = srfi37$frame2;
                $heapFrame.operands = operands;
                if (lists.isNull($heapFrame.operands)) {
                    return Scheme.apply.apply2(misc.values, seeds);
                }
                final ApplyWithValues applyWithValues = ApplyWithValues.applyWithValues;
                final Apply apply = Scheme.apply;
                final Object operand$Mnproc = this.operand$Mnproc;
                final Object force = Promise.force($heapFrame.operands, Pair.class);
                try {
                    return applyWithValues.apply2(apply.apply3(operand$Mnproc, lists.car((Pair)force), seeds), $heapFrame.lambda$Fn6);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "car", 1, force);
                }
            }
        }
        final srfi37$frame $heapFrame = new srfi37$frame();
        $heapFrame.options = options;
        $heapFrame.unrecognized$Mnoption$Mnproc = unrecognizedOptionProc;
        $heapFrame.operand$Mnproc = operandProc;
        final LList seeds = LList.makeList(argsArray, 0);
        return $heapFrame.lambda1scanArgs(args, seeds);
    }
    
    static {
        Lit9 = Symbol.valueOf("args-fold");
        Lit8 = Symbol.valueOf("option-processor");
        Lit7 = Symbol.valueOf("option-optional-arg?");
        Lit6 = Symbol.valueOf("option-required-arg?");
        Lit5 = Symbol.valueOf("option-names");
        Lit4 = Symbol.valueOf("option");
        Lit3 = Symbol.valueOf("option?");
        Lit2 = IntNum.valueOf(0);
        Lit1 = IntNum.valueOf(1);
        Lit0 = IntNum.valueOf(3);
        option$Mntype = (ClassType)Type.make(option-type.class);
        srfi37.$instance = new srfi37();
        final srfi37 $instance = srfi37.$instance;
        option$Qu = new ModuleMethod($instance, 11, srfi37.Lit3, 4097);
        option = new ModuleMethod($instance, 12, srfi37.Lit4, 16388);
        option$Mnnames = new ModuleMethod($instance, 13, srfi37.Lit5, 4097);
        option$Mnrequired$Mnarg$Qu = new ModuleMethod($instance, 14, srfi37.Lit6, 4097);
        option$Mnoptional$Mnarg$Qu = new ModuleMethod($instance, 15, srfi37.Lit7, 4097);
        option$Mnprocessor = new ModuleMethod($instance, 16, srfi37.Lit8, 4097);
        args$Mnfold = new ModuleMethod($instance, 17, srfi37.Lit9, -4092);
        $runBody$();
    }
    
    public srfi37() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 16: {
                final Object force = Promise.force(o, option-type.class);
                if (!(force instanceof option-type)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 15: {
                final Object force2 = Promise.force(o, option-type.class);
                if (!(force2 instanceof option-type)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 14: {
                final Object force3 = Promise.force(o, option-type.class);
                if (!(force3 instanceof option-type)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 13: {
                final Object force4 = Promise.force(o, option-type.class);
                if (!(force4 instanceof option-type)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 11: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        if (moduleMethod.selector == 12) {
            ctx.value1 = o;
            ctx.value2 = o2;
            ctx.value3 = o3;
            ctx.value4 = o4;
            ctx.proc = moduleMethod;
            ctx.pc = 4;
            return 0;
        }
        return super.match4(moduleMethod, o, o2, o3, o4, ctx);
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        if (moduleMethod.selector == 17) {
            ctx.values = array;
            ctx.proc = moduleMethod;
            ctx.pc = 5;
            return 0;
        }
        return super.matchN(moduleMethod, array, ctx);
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //               22: 44
        //               23: 113
        //               24: 61
        //               25: 74
        //               26: 87
        //               27: 100
        //          default: 113
        //        }
        //    44: aload_2        
        //    45: invokestatic    gnu/kawa/slib/srfi37.isOption:(Ljava/lang/Object;)Z
        //    48: ifeq            57
        //    51: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    54: goto            60
        //    57: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    60: areturn        
        //    61: aload_2        
        //    62: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
        //    64: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    67: checkcast       Lgnu/kawa/slib/srfi37$option-type;
        //    70: invokestatic    gnu/kawa/slib/srfi37.optionNames:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
        //    73: areturn        
        //    74: aload_2        
        //    75: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
        //    77: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    80: checkcast       Lgnu/kawa/slib/srfi37$option-type;
        //    83: invokestatic    gnu/kawa/slib/srfi37.isOptionRequiredArg:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
        //    86: areturn        
        //    87: aload_2        
        //    88: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
        //    90: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    93: checkcast       Lgnu/kawa/slib/srfi37$option-type;
        //    96: invokestatic    gnu/kawa/slib/srfi37.isOptionOptionalArg:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
        //    99: areturn        
        //   100: aload_2        
        //   101: ldc             Lgnu/kawa/slib/srfi37$option-type;.class
        //   103: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   106: checkcast       Lgnu/kawa/slib/srfi37$option-type;
        //   109: invokestatic    gnu/kawa/slib/srfi37.optionProcessor:(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
        //   112: areturn        
        //   113: aload_0        
        //   114: aload_1        
        //   115: aload_2        
        //   116: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   119: areturn        
        //   120: new             Lgnu/mapping/WrongType;
        //   123: dup_x1         
        //   124: swap           
        //   125: ldc             "option-names"
        //   127: iconst_1       
        //   128: aload_2        
        //   129: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   132: athrow         
        //   133: new             Lgnu/mapping/WrongType;
        //   136: dup_x1         
        //   137: swap           
        //   138: ldc             "option-required-arg?"
        //   140: iconst_1       
        //   141: aload_2        
        //   142: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   145: athrow         
        //   146: new             Lgnu/mapping/WrongType;
        //   149: dup_x1         
        //   150: swap           
        //   151: ldc             "option-optional-arg?"
        //   153: iconst_1       
        //   154: aload_2        
        //   155: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   158: athrow         
        //   159: new             Lgnu/mapping/WrongType;
        //   162: dup_x1         
        //   163: swap           
        //   164: ldc             "option-processor"
        //   166: iconst_1       
        //   167: aload_2        
        //   168: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   171: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  67     70     120    133    Ljava/lang/ClassCastException;
        //  80     83     133    146    Ljava/lang/ClassCastException;
        //  93     96     146    159    Ljava/lang/ClassCastException;
        //  106    109    159    172    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 71 out of bounds for length 71
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply4(final ModuleMethod method, final Object o, final Object o2, final Object o3, final Object o4) {
        if (method.selector == 12) {
            return option(o, o2, o3, o4);
        }
        return super.apply4(method, o, o2, o3, o4);
    }
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] args) {
        if (method.selector == 17) {
            final Object args2 = args[0];
            final Object options = args[1];
            final Object unrecognizedOptionProc = args[2];
            final Object operandProc = args[3];
            int n = args.length - 4;
            final Object[] argsArray = new Object[n];
            while (--n >= 0) {
                argsArray[n] = args[n + 4];
            }
            return argsFold$V(args2, options, unrecognizedOptionProc, operandProc, argsArray);
        }
        return super.applyN(method, args);
    }
    
    public class option-type
    {
        public Object names;
        public Object required$Mnarg$Qu;
        public Object optional$Mnarg$Qu;
        public Object processor;
    }
}
