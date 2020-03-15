// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.kawa.io.OutPort;
import gnu.mapping.WrongType;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.kawa.io.Path;
import kawa.lib.ports;
import gnu.lists.LList;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.text.Char;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class ppfile extends ModuleBody
{
    public static final ModuleMethod pprint$Mnfilter$Mnfile;
    public static final ModuleMethod pprint$Mnfile;
    static final Char Lit0;
    static final ModuleMethod lambda$Fn3;
    public static ppfile $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Object pprintFilterFile$V(final Object inport, final Object filter, final Object[] argsArray) {
        public class ppfile$frame extends ModuleBody
        {
            LList optarg;
            Object filter;
            final ModuleMethod fun$Fn1;
            
            public ppfile$frame() {
                final ModuleMethod fun$Fn1 = new ModuleMethod(this, 2, "fun", 4097);
                fun$Fn1.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/ppfile.scm:27");
                this.fun$Fn1 = fun$Fn1;
            }
            
            public Object lambda1fun(final Object port) {
                public class ppfile$frame0 extends ModuleBody
                {
                    Object port;
                    ppfile$frame staticLink;
                    final ModuleMethod fun$Fn2;
                    
                    public ppfile$frame0() {
                        final ModuleMethod fun$Fn2 = new ModuleMethod(this, 1, "fun", 4097);
                        fun$Fn2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/ppfile.scm:34");
                        this.fun$Fn2 = fun$Fn2;
                    }
                    
                    public Object lambda2fun(final Object export) {
                        // 
                        // This method could not be decompiled.
                        // 
                        // Original Bytecode:
                        // 
                        //     1: getfield        gnu/kawa/slib/ppfile$frame0.port:Ljava/lang/Object;
                        //     4: invokestatic    kawa/lib/ports.peekChar:(Ljava/lang/Object;)I
                        //     7: invokestatic    gnu/text/Char.makeOrEof:(I)Ljava/lang/Object;
                        //    10: astore_2        /* c */
                        //    11: aload_2         /* c */
                        //    12: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                        //    15: getstatic       gnu/lists/EofClass.eofValue:Lgnu/lists/EofClass;
                        //    18: if_acmpne       25
                        //    21: iconst_1       
                        //    22: goto            26
                        //    25: iconst_0       
                        //    26: istore_3        /* x */
                        //    27: iload_3         /* x */
                        //    28: ifeq            47
                        //    31: iload_3         /* x */
                        //    32: ifeq            41
                        //    35: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                        //    38: goto            340
                        //    41: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                        //    44: goto            340
                        //    47: aload_2         /* c */
                        //    48: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                        //    51: dup            
                        //    52: astore          4
                        //    54: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
                        //    57: invokestatic    kawa/lib/rnrs/unicode.isCharWhitespace:(I)Z
                        //    60: ifeq            90
                        //    63: aload_0         /* this */
                        //    64: getfield        gnu/kawa/slib/ppfile$frame0.port:Ljava/lang/Object;
                        //    67: invokestatic    kawa/lib/ports.readChar:(Ljava/lang/Object;)I
                        //    70: invokestatic    gnu/text/Char.makeOrEof:(I)Ljava/lang/Object;
                        //    73: aload_1         /* export */
                        //    74: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
                        //    77: aload_0         /* this */
                        //    78: getfield        gnu/kawa/slib/ppfile$frame0.port:Ljava/lang/Object;
                        //    81: invokestatic    kawa/lib/ports.peekChar:(Ljava/lang/Object;)I
                        //    84: invokestatic    gnu/text/Char.makeOrEof:(I)Ljava/lang/Object;
                        //    87: goto            10
                        //    90: bipush          59
                        //    92: aload_2         /* c */
                        //    93: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                        //    96: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
                        //    99: if_icmpne       106
                        //   102: aload_2         /* c */
                        //   103: goto            109
                        //   106: goto            215
                        //   109: astore_3        /* x */
                        //   110: aload_3         /* c */
                        //   111: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                        //   114: getstatic       gnu/lists/EofClass.eofValue:Lgnu/lists/EofClass;
                        //   117: if_acmpne       124
                        //   120: iconst_1       
                        //   121: goto            125
                        //   124: iconst_0       
                        //   125: istore          x
                        //   127: iload           x
                        //   129: ifeq            149
                        //   132: iload           x
                        //   134: ifeq            143
                        //   137: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                        //   140: goto            340
                        //   143: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                        //   146: goto            340
                        //   149: bipush          10
                        //   151: aload_3         /* c */
                        //   152: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                        //   155: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
                        //   158: if_icmpne       188
                        //   161: aload_0         /* this */
                        //   162: getfield        gnu/kawa/slib/ppfile$frame0.port:Ljava/lang/Object;
                        //   165: invokestatic    kawa/lib/ports.readChar:(Ljava/lang/Object;)I
                        //   168: invokestatic    gnu/text/Char.makeOrEof:(I)Ljava/lang/Object;
                        //   171: aload_1         /* export */
                        //   172: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
                        //   175: aload_0         /* this */
                        //   176: getfield        gnu/kawa/slib/ppfile$frame0.port:Ljava/lang/Object;
                        //   179: invokestatic    kawa/lib/ports.peekChar:(Ljava/lang/Object;)I
                        //   182: invokestatic    gnu/text/Char.makeOrEof:(I)Ljava/lang/Object;
                        //   185: goto            10
                        //   188: aload_0         /* this */
                        //   189: getfield        gnu/kawa/slib/ppfile$frame0.port:Ljava/lang/Object;
                        //   192: invokestatic    kawa/lib/ports.readChar:(Ljava/lang/Object;)I
                        //   195: invokestatic    gnu/text/Char.makeOrEof:(I)Ljava/lang/Object;
                        //   198: aload_1         /* export */
                        //   199: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
                        //   202: aload_0         /* this */
                        //   203: getfield        gnu/kawa/slib/ppfile$frame0.port:Ljava/lang/Object;
                        //   206: invokestatic    kawa/lib/ports.peekChar:(Ljava/lang/Object;)I
                        //   209: invokestatic    gnu/text/Char.makeOrEof:(I)Ljava/lang/Object;
                        //   212: goto            109
                        //   215: aload_0         /* this */
                        //   216: getfield        gnu/kawa/slib/ppfile$frame0.port:Ljava/lang/Object;
                        //   219: ldc             Lgnu/kawa/io/InPort;.class
                        //   221: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                        //   224: dup            
                        //   225: astore          4
                        //   227: checkcast       Lgnu/kawa/io/InPort;
                        //   230: invokestatic    kawa/lib/ports.read:(Lgnu/kawa/io/InPort;)Ljava/lang/Object;
                        //   233: astore_3        /* o */
                        //   234: aload_3         /* o */
                        //   235: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                        //   238: getstatic       gnu/lists/EofClass.eofValue:Lgnu/lists/EofClass;
                        //   241: if_acmpne       248
                        //   244: iconst_1       
                        //   245: goto            249
                        //   248: iconst_0       
                        //   249: istore          x
                        //   251: iload           x
                        //   253: ifeq            273
                        //   256: iload           x
                        //   258: ifeq            267
                        //   261: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                        //   264: goto            340
                        //   267: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                        //   270: goto            340
                        //   273: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                        //   276: aload_0         /* this */
                        //   277: getfield        gnu/kawa/slib/ppfile$frame0.staticLink:Lgnu/kawa/slib/ppfile$frame;
                        //   280: getfield        gnu/kawa/slib/ppfile$frame.filter:Ljava/lang/Object;
                        //   283: aload_3         /* o */
                        //   284: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                        //   287: aload_1         /* export */
                        //   288: invokestatic    gnu/kawa/slib/pp.prettyPrint:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                        //   291: pop            
                        //   292: aload_0         /* this */
                        //   293: getfield        gnu/kawa/slib/ppfile$frame0.port:Ljava/lang/Object;
                        //   296: invokestatic    kawa/lib/ports.peekChar:(Ljava/lang/Object;)I
                        //   299: invokestatic    gnu/text/Char.makeOrEof:(I)Ljava/lang/Object;
                        //   302: astore          c
                        //   304: getstatic       gnu/kawa/slib/ppfile.Lit0:Lgnu/text/Char;
                        //   307: aload           c
                        //   309: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                        //   312: ifeq            335
                        //   315: aload_0         /* this */
                        //   316: getfield        gnu/kawa/slib/ppfile$frame0.port:Ljava/lang/Object;
                        //   319: invokestatic    kawa/lib/ports.readChar:(Ljava/lang/Object;)I
                        //   322: pop            
                        //   323: aload_0         /* this */
                        //   324: getfield        gnu/kawa/slib/ppfile$frame0.port:Ljava/lang/Object;
                        //   327: invokestatic    kawa/lib/ports.peekChar:(Ljava/lang/Object;)I
                        //   330: invokestatic    gnu/text/Char.makeOrEof:(I)Ljava/lang/Object;
                        //   333: astore          c
                        //   335: aload           c
                        //   337: goto            10
                        //   340: areturn        
                        //   341: new             Lgnu/mapping/WrongType;
                        //   344: dup_x1         
                        //   345: swap           
                        //   346: ldc             "char-whitespace?"
                        //   348: iconst_1       
                        //   349: aload           4
                        //   351: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                        //   354: athrow         
                        //   355: new             Lgnu/mapping/WrongType;
                        //   358: dup_x1         
                        //   359: swap           
                        //   360: ldc             "read"
                        //   362: iconst_1       
                        //   363: aload           4
                        //   365: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                        //   368: athrow         
                        //    Exceptions:
                        //  Try           Handler
                        //  Start  End    Start  End    Type                          
                        //  -----  -----  -----  -----  ------------------------------
                        //  54     57     341    355    Ljava/lang/ClassCastException;
                        //  227    230    355    369    Ljava/lang/ClassCastException;
                        // 
                        // The error that occurred was:
                        // 
                        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0248:
                        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
                        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
                        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
                        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
                    
                    @Override
                    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                        if (moduleMethod.selector == 1) {
                            ctx.value1 = o;
                            ctx.proc = moduleMethod;
                            ctx.pc = 1;
                            return 0;
                        }
                        return super.match1(moduleMethod, o, ctx);
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply1(final ModuleMethod method, final Object o) {
                        if (method.selector == 1) {
                            return this.lambda2fun(o);
                        }
                        return super.apply1(method, o);
                    }
                }
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     3: dup            
                //     4: invokespecial   gnu/kawa/slib/ppfile$frame0.<init>:()V
                //     7: dup            
                //     8: aload_0         /* this */
                //     9: putfield        gnu/kawa/slib/ppfile$frame0.staticLink:Lgnu/kawa/slib/ppfile$frame;
                //    12: astore_2        /* $heapFrame */
                //    13: aload_2         /* $heapFrame */
                //    14: aload_1         /* port */
                //    15: putfield        gnu/kawa/slib/ppfile$frame0.port:Ljava/lang/Object;
                //    18: aload_2         /* $heapFrame */
                //    19: getfield        gnu/kawa/slib/ppfile$frame0.fun$Fn2:Lgnu/expr/ModuleMethod;
                //    22: astore_3        /* fun */
                //    23: aload_0         /* this */
                //    24: getfield        gnu/kawa/slib/ppfile$frame.optarg:Lgnu/lists/LList;
                //    27: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //    30: ifeq            45
                //    33: getstatic       kawa/lib/ports.current$Mnoutput$Mnport:Lgnu/mapping/LocationProc;
                //    36: invokevirtual   gnu/mapping/LocationProc.getValue:()Ljava/lang/Object;
                //    39: checkcast       Lgnu/kawa/io/OutPort;
                //    42: goto            58
                //    45: aload_0         /* this */
                //    46: getfield        gnu/kawa/slib/ppfile$frame.optarg:Lgnu/lists/LList;
                //    49: dup            
                //    50: astore          5
                //    52: checkcast       Lgnu/lists/Pair;
                //    55: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    58: astore          outport
                //    60: aload           outport
                //    62: invokestatic    kawa/lib/ports.isOutputPort:(Ljava/lang/Object;)Z
                //    65: ifeq            77
                //    68: aload_2         /* $heapFrame */
                //    69: aload           outport
                //    71: invokevirtual   gnu/kawa/slib/ppfile$frame0.lambda2fun:(Ljava/lang/Object;)Ljava/lang/Object;
                //    74: goto            97
                //    77: aload           outport
                //    79: ldc             Lgnu/kawa/io/Path;.class
                //    81: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    84: dup            
                //    85: astore          5
                //    87: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
                //    90: aload_2         /* $heapFrame */
                //    91: getfield        gnu/kawa/slib/ppfile$frame0.fun$Fn2:Lgnu/expr/ModuleMethod;
                //    94: invokestatic    kawa/lib/ports.callWithOutputFile:(Lgnu/kawa/io/Path;Lgnu/mapping/Procedure;)Ljava/lang/Object;
                //    97: areturn        
                //    98: new             Lgnu/mapping/WrongType;
                //   101: dup_x1         
                //   102: swap           
                //   103: ldc             "car"
                //   105: iconst_1       
                //   106: aload           5
                //   108: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   111: athrow         
                //   112: new             Lgnu/mapping/WrongType;
                //   115: dup_x1         
                //   116: swap           
                //   117: ldc             "call-with-output-file"
                //   119: iconst_1       
                //   120: aload           5
                //   122: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   125: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  52     55     98     112    Ljava/lang/ClassCastException;
                //  87     90     112    126    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0097:
                //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
                //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 2) {
                    ctx.value1 = o;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, o, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object o) {
                if (method.selector == 2) {
                    return this.lambda1fun(o);
                }
                return super.apply1(method, o);
            }
        }
        final ppfile$frame $heapFrame = new ppfile$frame();
        $heapFrame.filter = filter;
        $heapFrame.optarg = LList.makeList(argsArray, 0);
        final Procedure fun = $heapFrame.fun$Fn1;
        if (ports.isInputPort(inport)) {
            return $heapFrame.lambda1fun(inport);
        }
        final Object force = Promise.force(inport, Path.class);
        try {
            return ports.callWithInputFile(Path.valueOf(force), $heapFrame.fun$Fn1);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "call-with-input-file", 1, force);
        }
    }
    
    public static Object pprintFile(final Object ifile) {
        return pprintFile(ifile, ports.current$Mnoutput$Mnport.getValue());
    }
    
    public static Object pprintFile(final Object ifile, final Object oport) {
        return pprintFilterFile$V(ifile, ppfile.lambda$Fn3, new Object[] { oport });
    }
    
    static Object lambda3(final Object x) {
        return x;
    }
    
    static {
        Lit2 = Symbol.valueOf("pprint-file");
        Lit1 = Symbol.valueOf("pprint-filter-file");
        Lit0 = Char.valueOf(10);
        ppfile.$instance = new ppfile();
        final ppfile $instance = ppfile.$instance;
        pprint$Mnfilter$Mnfile = new ModuleMethod($instance, 3, ppfile.Lit1, -4094);
        final ModuleMethod lambda$Fn4 = new ModuleMethod($instance, 4, null, 4097);
        lambda$Fn4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/ppfile.scm:70");
        lambda$Fn3 = lambda$Fn4;
        pprint$Mnfile = new ModuleMethod($instance, 5, ppfile.Lit2, 8193);
        $runBody$();
    }
    
    public ppfile() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 5: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
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
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        if (moduleMethod.selector == 5) {
            ctx.value1 = o;
            ctx.value2 = o2;
            ctx.proc = moduleMethod;
            ctx.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, o, o2, ctx);
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        if (moduleMethod.selector == 3) {
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
    public Object apply1(final ModuleMethod method, final Object o) {
        switch (method.selector) {
            case 4: {
                return lambda3(o);
            }
            case 5: {
                return pprintFile(o);
            }
            default: {
                return super.apply1(method, o);
            }
        }
    }
    
    @Override
    public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
        if (method.selector == 5) {
            return pprintFile(o, o2);
        }
        return super.apply2(method, o, o2);
    }
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] args) {
        if (method.selector == 3) {
            final Object inport = args[0];
            final Object filter = args[1];
            int n = args.length - 2;
            final Object[] argsArray = new Object[n];
            while (--n >= 0) {
                argsArray[n] = args[n + 2];
            }
            return pprintFilterFile$V(inport, filter, argsArray);
        }
        return super.applyN(method, args);
    }
}
