// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import kawa.lib.std_syntax;
import kawa.standard.syntax_case;
import kawa.lang.TemplateScope;
import gnu.expr.ModuleInfo;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import gnu.kawa.functions.ApplyWithValues;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.functions.AddOp;
import gnu.math.Numeric;
import gnu.mapping.Values;
import gnu.math.RealNum;
import gnu.kawa.functions.Apply;
import kawa.standard.append;
import kawa.standard.Scheme;
import gnu.expr.Special;
import kawa.lib.exceptions;
import gnu.expr.KawaConvert;
import kawa.lib.numbers;
import gnu.text.Char;
import kawa.SourceMethodType;
import kawa.SourceType;
import kawa.lib.ports;
import gnu.kawa.io.InPort;
import gnu.mapping.Promise;
import gnu.mapping.WrongType;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import kawa.lib.lists;
import gnu.lists.LList;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.lists.PairWithPosition;
import kawa.lang.SyntaxTemplate;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRules;
import gnu.math.IntNum;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import kawa.lang.Macro;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class StreamsDerived extends ModuleBody
{
    public static final StaticFieldLocation stream$Mnnull;
    public static final StaticFieldLocation stream$Mncons;
    public static final StaticFieldLocation stream$Qu;
    public static final StaticFieldLocation stream$Mnnull$Qu;
    public static final StaticFieldLocation stream$Mnpair$Qu;
    public static final StaticFieldLocation stream$Mncar;
    public static final StaticFieldLocation stream$Mncdr;
    public static final StaticFieldLocation stream$Mnlambda;
    public static final Macro define$Mnstream;
    public static final ModuleMethod list$Mn$Grstream;
    public static final ModuleMethod port$Mn$Grstream;
    public static final Macro stream;
    public static final ModuleMethod stream$Mn$Grlist;
    public static final ModuleMethod stream$Mnappend;
    public static final ModuleMethod stream$Mnconcat;
    public static final ModuleMethod stream$Mnconstant;
    public static final ModuleMethod stream$Mndrop;
    public static final ModuleMethod stream$Mndrop$Mnwhile;
    public static final ModuleMethod stream$Mnfilter;
    public static final ModuleMethod stream$Mnfold;
    public static final ModuleMethod stream$Mnfor$Mneach;
    public static final ModuleMethod stream$Mnfrom;
    public static final ModuleMethod stream$Mniterate;
    public static final ModuleMethod stream$Mnlength;
    public static final Macro stream$Mnlet;
    public static final ModuleMethod stream$Mnmap;
    public static final Macro stream$Mnmatch;
    public static final Macro stream$Mnof;
    public static final ModuleMethod stream$Mnrange;
    public static final ModuleMethod stream$Mnref;
    public static final ModuleMethod stream$Mnreverse;
    public static final ModuleMethod stream$Mnscan;
    public static final ModuleMethod stream$Mntake;
    public static final ModuleMethod stream$Mntake$Mnwhile;
    public static final ModuleMethod stream$Mnunfold;
    public static final ModuleMethod stream$Mnunfolds;
    public static final ModuleMethod stream$Mnzip;
    public static final int $Pcprovide$Pcsrfi$Mn41$Mnstreams$Mnderived = 123;
    public static final Macro $Prvt$stream$Mnmatch$Mntest;
    public static final Macro $Prvt$stream$Mnmatch$Mnpattern;
    public static final Macro $Prvt$stream$Mnof$Mnaux;
    static final SimpleSymbol Lit0;
    static final IntNum Lit1;
    static final ModuleMethod lambda$Fn7;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final ModuleMethod lambda$Fn26;
    static final IntNum Lit6;
    static final IntNum Lit7;
    static final SimpleSymbol Lit8;
    static final ModuleMethod lambda$Fn33;
    static final SimpleSymbol Lit9;
    static final ModuleMethod lambda$Fn45;
    static final SimpleSymbol Lit10;
    static final ModuleMethod lambda$Fn57;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final ModuleMethod lambda$Fn65;
    public static StreamsDerived $instance;
    static final SimpleSymbol Lit13;
    static final SyntaxRules Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SyntaxRules Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SyntaxRules Lit26;
    static final SimpleSymbol Lit27;
    static final SyntaxRules Lit28;
    static final SimpleSymbol Lit29;
    static final SyntaxRules Lit30;
    static final SimpleSymbol Lit31;
    static final SyntaxPattern Lit32;
    static final SyntaxTemplate Lit33;
    static final SyntaxPattern Lit34;
    static final SyntaxTemplate Lit35;
    static final SyntaxTemplate Lit36;
    static final SyntaxPattern Lit37;
    static final SyntaxTemplate Lit38;
    static final SyntaxPattern Lit39;
    static final SyntaxTemplate Lit40;
    static final SyntaxTemplate Lit41;
    static final SyntaxPattern Lit42;
    static final SyntaxTemplate Lit43;
    static final SyntaxTemplate Lit44;
    static final SimpleSymbol Lit45;
    static final SyntaxRules Lit46;
    static final SimpleSymbol Lit47;
    static final SyntaxRules Lit48;
    static final SimpleSymbol Lit49;
    static final SimpleSymbol Lit50;
    static final SimpleSymbol Lit51;
    static final SimpleSymbol Lit52;
    static final SimpleSymbol Lit53;
    static final SimpleSymbol Lit54;
    static final SimpleSymbol Lit55;
    static final PairWithPosition Lit56;
    static final SimpleSymbol Lit57;
    static final SimpleSymbol Lit58;
    static final SimpleSymbol Lit59;
    static final Object[] Lit60;
    static final SimpleSymbol Lit61;
    static final Object[] Lit62;
    static final SimpleSymbol Lit63;
    static final SimpleSymbol Lit64;
    static final SimpleSymbol Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    static final PairWithPosition Lit71;
    static final SimpleSymbol Lit72;
    static final SimpleSymbol Lit73;
    static final SimpleSymbol Lit74;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        final ModuleMethod exists = srfi1.any;
    }
    
    public static Stream list$To$Stream(final LList objs) {
        public class StreamsDerived$frame extends ModuleBody
        {
            public Object lambda1list$To$Stream(final LList objs) {
                public class StreamsDerived$frame0 extends ModuleBody
                {
                    LList objs;
                    StreamsDerived$frame staticLink;
                    final ModuleMethod lambda$Fn1;
                    final ModuleMethod lambda$Fn2;
                    final ModuleMethod lambda$Fn3;
                    
                    public StreamsDerived$frame0() {
                        this.lambda$Fn2 = new ModuleMethod(this, 1, null, 0);
                        this.lambda$Fn3 = new ModuleMethod(this, 2, null, 0);
                        this.lambda$Fn1 = new ModuleMethod(this, 3, null, 0);
                    }
                    
                    Object lambda2() {
                        return lists.isNull(this.objs) ? StreamsPrimitive.stream$Mnnull : new StreamPair(new StreamPromise(this.lambda$Fn2, false), new StreamPromise(this.lambda$Fn3, true));
                    }
                    
                    Object lambda3() {
                        final LList objs = this.objs;
                        try {
                            return lists.car((Pair)objs);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "car", 1, objs);
                        }
                    }
                    
                    Object lambda4() {
                        final StreamsDerived$frame staticLink = this.staticLink;
                        Object o;
                        final LList list = (LList)(o = this.objs);
                        Object o2;
                        try {
                            o2 = (o = Promise.force(lists.cdr((Pair)list), LList.class));
                            final LList list2 = (LList)o2;
                            return staticLink.lambda1list$To$Stream(list2);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "cdr", 1, o);
                        }
                        try {
                            final LList list2 = (LList)o2;
                            return staticLink.lambda1list$To$Stream(list2);
                        }
                        catch (ClassCastException ex2) {
                            throw new WrongType(ex2, "list->stream", 0, o);
                        }
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 3: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 2: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 1: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(moduleMethod, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 1: {
                                return this.lambda3();
                            }
                            case 2: {
                                return this.lambda4();
                            }
                            case 3: {
                                return this.lambda2();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame0 streamsDerived$frame0 = new StreamsDerived$frame0();
                streamsDerived$frame0.staticLink = this;
                final StreamsDerived$frame0 $heapFrame = streamsDerived$frame0;
                $heapFrame.objs = objs;
                return new StreamPromise($heapFrame.lambda$Fn1, true);
            }
        }
        final StreamsDerived$frame $heapFrame = new StreamsDerived$frame();
        return (Stream)$heapFrame.lambda1list$To$Stream(objs);
    }
    
    public static Stream port$To$Stream() {
        return port$To$Stream(ports.current$Mninput$Mnport.getValue());
    }
    
    public static Stream port$To$Stream(final InPort p) {
        public class StreamsDerived$frame1 extends ModuleBody
        {
            public Object lambda5port$To$Stream(final InPort p) {
                public class StreamsDerived$frame2 extends ModuleBody
                {
                    InPort p;
                    StreamsDerived$frame1 staticLink;
                    final ModuleMethod lambda$Fn4;
                    
                    public StreamsDerived$frame2() {
                        this.lambda$Fn4 = new ModuleMethod(this, 6, null, 0);
                    }
                    
                    Object lambda6() {
                        public class StreamsDerived$frame3 extends ModuleBody
                        {
                            @SourceType("character")
                            int c;
                            StreamsDerived$frame2 staticLink;
                            final ModuleMethod lambda$Fn5;
                            final ModuleMethod lambda$Fn6;
                            
                            public StreamsDerived$frame3() {
                                this.lambda$Fn5 = new ModuleMethod(this, 4, null, 0);
                                this.lambda$Fn6 = new ModuleMethod(this, 5, null, 0);
                            }
                            
                            @SourceMethodType({ "character" })
                            int lambda7() {
                                return this.c;
                            }
                            
                            Object lambda8() {
                                return this.staticLink.staticLink.lambda5port$To$Stream(this.staticLink.p);
                            }
                            
                            @Override
                            public int match0(final ModuleMethod proc, final CallContext ctx) {
                                switch (proc.selector) {
                                    case 5: {
                                        ctx.proc = proc;
                                        return ctx.pc = 0;
                                    }
                                    case 4: {
                                        ctx.proc = proc;
                                        return ctx.pc = 0;
                                    }
                                    default: {
                                        return super.match0(proc, ctx);
                                    }
                                }
                            }
                            
                            @Override
                            public void apply(final CallContext callContext) {
                                final int pc = callContext.pc;
                                ModuleMethod.applyError();
                            }
                            
                            @Override
                            public Object apply0(final ModuleMethod method) {
                                switch (method.selector) {
                                    case 4: {
                                        return Char.make(this.lambda7());
                                    }
                                    case 5: {
                                        return this.lambda8();
                                    }
                                    default: {
                                        return super.apply0(method);
                                    }
                                }
                            }
                        }
                        final StreamsDerived$frame3 streamsDerived$frame3 = new StreamsDerived$frame3();
                        streamsDerived$frame3.staticLink = this;
                        final StreamsDerived$frame3 $heapFrame = streamsDerived$frame3;
                        $heapFrame.c = ports.readChar(this.p);
                        return ($heapFrame.c == -1) ? StreamsPrimitive.stream$Mnnull : new StreamPair(new StreamPromise($heapFrame.lambda$Fn5, false), new StreamPromise($heapFrame.lambda$Fn6, true));
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        if (moduleMethod.selector == 6) {
                            ctx.proc = moduleMethod;
                            return ctx.pc = 0;
                        }
                        return super.match0(moduleMethod, ctx);
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        if (method.selector == 6) {
                            return this.lambda6();
                        }
                        return super.apply0(method);
                    }
                }
                final StreamsDerived$frame2 streamsDerived$frame2 = new StreamsDerived$frame2();
                streamsDerived$frame2.staticLink = this;
                final StreamsDerived$frame2 $heapFrame = streamsDerived$frame2;
                $heapFrame.p = p;
                return new StreamPromise($heapFrame.lambda$Fn4, true);
            }
        }
        final StreamsDerived$frame1 $heapFrame = new StreamsDerived$frame1();
        return (Stream)$heapFrame.lambda5port$To$Stream(p);
    }
    
    public static LList stream$To$List$V(final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //     5: dup            
        //     6: astore_2       
        //     7: astore_1        /* args */
        //     8: aload_1         /* args */
        //     9: invokevirtual   gnu/lists/LList.size:()I
        //    12: iconst_1       
        //    13: if_icmpne       22
        //    16: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    19: goto            31
        //    22: aload_1         /* args */
        //    23: dup            
        //    24: astore_3       
        //    25: checkcast       Lgnu/lists/Pair;
        //    28: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    31: astore_2       
        //    32: aload_1         /* args */
        //    33: invokevirtual   gnu/lists/LList.size:()I
        //    36: iconst_1       
        //    37: if_icmpne       59
        //    40: aload_1         /* args */
        //    41: dup            
        //    42: astore          4
        //    44: checkcast       Lgnu/lists/Pair;
        //    47: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    50: dup            
        //    51: astore          4
        //    53: checkcast       Lgnu/kawa/slib/Stream;
        //    56: goto            69
        //    59: aload_1         /* args */
        //    60: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    63: dup            
        //    64: astore          4
        //    66: checkcast       Lgnu/kawa/slib/Stream;
        //    69: astore_3        /* strm */
        //    70: aload_2         /* n */
        //    71: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    74: ifeq            106
        //    77: aload_2         /* n */
        //    78: invokestatic    kawa/lib/numbers.isInteger:(Ljava/lang/Object;)Z
        //    81: ifne            106
        //    84: iconst_2       
        //    85: anewarray       Ljava/lang/Object;
        //    88: dup            
        //    89: iconst_0       
        //    90: getstatic       gnu/kawa/slib/StreamsDerived.Lit0:Lgnu/mapping/SimpleSymbol;
        //    93: aastore        
        //    94: dup            
        //    95: iconst_1       
        //    96: ldc             "non-integer count"
        //    98: aastore        
        //    99: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   102: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   105: athrow         
        //   106: aload_2         /* n */
        //   107: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   110: ifeq            153
        //   113: aload_2         /* n */
        //   114: ldc             Lgnu/math/RealNum;.class
        //   116: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   119: dup            
        //   120: astore          4
        //   122: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   125: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
        //   128: ifeq            153
        //   131: iconst_2       
        //   132: anewarray       Ljava/lang/Object;
        //   135: dup            
        //   136: iconst_0       
        //   137: getstatic       gnu/kawa/slib/StreamsDerived.Lit0:Lgnu/mapping/SimpleSymbol;
        //   140: aastore        
        //   141: dup            
        //   142: iconst_1       
        //   143: ldc             "negative count"
        //   145: aastore        
        //   146: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   149: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   152: athrow         
        //   153: aload_2         /* n */
        //   154: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   157: ifeq            175
        //   160: aload_2         /* n */
        //   161: ldc             Lgnu/math/IntNum;.class
        //   163: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   166: dup            
        //   167: astore          4
        //   169: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   172: goto            178
        //   175: getstatic       gnu/kawa/slib/StreamsDerived.Lit1:Lgnu/math/IntNum;
        //   178: aload_3         /* strm */
        //   179: invokestatic    gnu/kawa/slib/StreamsDerived.lambda9loop:(Lgnu/math/IntNum;Lgnu/kawa/slib/Stream;)Ljava/lang/Object;
        //   182: ldc             Lgnu/lists/LList;.class
        //   184: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   187: checkcast       Lgnu/lists/LList;
        //   190: areturn        
        //   191: new             Lgnu/mapping/WrongType;
        //   194: dup_x1         
        //   195: swap           
        //   196: ldc             "car"
        //   198: iconst_1       
        //   199: aload_3        
        //   200: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   203: athrow         
        //   204: new             Lgnu/mapping/WrongType;
        //   207: dup_x1         
        //   208: swap           
        //   209: ldc             "car"
        //   211: iconst_1       
        //   212: aload           4
        //   214: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   217: athrow         
        //   218: new             Lgnu/mapping/WrongType;
        //   221: dup_x1         
        //   222: swap           
        //   223: ldc             "strm"
        //   225: bipush          -2
        //   227: aload           4
        //   229: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   232: athrow         
        //   233: new             Lgnu/mapping/WrongType;
        //   236: dup_x1         
        //   237: swap           
        //   238: ldc             "strm"
        //   240: bipush          -2
        //   242: aload           4
        //   244: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   247: athrow         
        //   248: new             Lgnu/mapping/WrongType;
        //   251: dup_x1         
        //   252: swap           
        //   253: ldc             "negative?"
        //   255: iconst_1       
        //   256: aload           4
        //   258: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   261: athrow         
        //   262: new             Lgnu/mapping/WrongType;
        //   265: dup_x1         
        //   266: swap           
        //   267: ldc             "loop"
        //   269: iconst_0       
        //   270: aload           4
        //   272: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   275: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  25     28     191    204    Ljava/lang/ClassCastException;
        //  44     47     204    218    Ljava/lang/ClassCastException;
        //  53     56     218    233    Ljava/lang/ClassCastException;
        //  66     69     233    248    Ljava/lang/ClassCastException;
        //  122    125    248    262    Ljava/lang/ClassCastException;
        //  169    172    262    276    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    
    public static Object lambda9loop(final IntNum n, final Stream strm) {
        final boolean x = numbers.isZero(n);
        Label_0029: {
            if (x) {
                if (!x) {
                    break Label_0029;
                }
            }
            else if (!StreamsPrimitive.isStreamNull(strm)) {
                break Label_0029;
            }
            return LList.Empty;
        }
        final Object streamCar = StreamsPrimitive.streamCar(strm);
        final IntNum add = IntNum.add(n, -1);
        final Object streamCdr = StreamsPrimitive.streamCdr(strm);
        try {
            return lists.cons(streamCar, lambda9loop(add, (Stream)streamCdr));
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "loop", 1, streamCdr);
        }
    }
    
    public static Stream streamAppend$V(final Object[] argsArray) {
        public class StreamsDerived$frame4 extends ModuleBody
        {
            static boolean lambda10(final Object x) {
                return !StreamsPrimitive.isStream(x);
            }
            
            public Object lambda11streamAppend(final LList strms) {
                public class StreamsDerived$frame5 extends ModuleBody
                {
                    LList strms;
                    StreamsDerived$frame4 staticLink;
                    final ModuleMethod lambda$Fn8;
                    final ModuleMethod lambda$Fn9;
                    final ModuleMethod lambda$Fn10;
                    
                    public StreamsDerived$frame5() {
                        this.lambda$Fn9 = new ModuleMethod(this, 7, null, 0);
                        this.lambda$Fn10 = new ModuleMethod(this, 8, null, 0);
                        this.lambda$Fn8 = new ModuleMethod(this, 9, null, 0);
                    }
                    
                    Object lambda12() {
                        // 
                        // This method could not be decompiled.
                        // 
                        // Original Bytecode:
                        // 
                        //     4: dup            
                        //     5: astore_1       
                        //     6: checkcast       Lgnu/lists/Pair;
                        //     9: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                        //    12: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                        //    15: ifeq            33
                        //    18: aload_0         /* this */
                        //    19: getfield        gnu/kawa/slib/StreamsDerived$frame5.strms:Lgnu/lists/LList;
                        //    22: dup            
                        //    23: astore_1       
                        //    24: checkcast       Lgnu/lists/Pair;
                        //    27: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                        //    30: goto            114
                        //    33: aload_0         /* this */
                        //    34: getfield        gnu/kawa/slib/StreamsDerived$frame5.strms:Lgnu/lists/LList;
                        //    37: dup            
                        //    38: astore_1       
                        //    39: checkcast       Lgnu/lists/Pair;
                        //    42: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                        //    45: invokestatic    gnu/kawa/slib/StreamsPrimitive.isStreamNull:(Ljava/lang/Object;)Z
                        //    48: ifeq            83
                        //    51: aload_0         /* this */
                        //    52: getfield        gnu/kawa/slib/StreamsDerived$frame5.staticLink:Lgnu/kawa/slib/StreamsDerived$frame4;
                        //    55: aload_0         /* this */
                        //    56: getfield        gnu/kawa/slib/StreamsDerived$frame5.strms:Lgnu/lists/LList;
                        //    59: dup            
                        //    60: astore_1       
                        //    61: checkcast       Lgnu/lists/Pair;
                        //    64: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                        //    67: ldc             Lgnu/lists/LList;.class
                        //    69: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                        //    72: dup            
                        //    73: astore_1       
                        //    74: checkcast       Lgnu/lists/LList;
                        //    77: invokevirtual   gnu/kawa/slib/StreamsDerived$frame4.lambda11streamAppend:(Lgnu/lists/LList;)Ljava/lang/Object;
                        //    80: goto            114
                        //    83: new             Lgnu/kawa/slib/StreamPair;
                        //    86: dup            
                        //    87: new             Lgnu/kawa/slib/StreamPromise;
                        //    90: dup            
                        //    91: aload_0         /* this */
                        //    92: getfield        gnu/kawa/slib/StreamsDerived$frame5.lambda$Fn9:Lgnu/expr/ModuleMethod;
                        //    95: iconst_0       
                        //    96: invokespecial   gnu/kawa/slib/StreamPromise.<init>:(Lgnu/mapping/Procedure;Z)V
                        //    99: new             Lgnu/kawa/slib/StreamPromise;
                        //   102: dup            
                        //   103: aload_0         /* this */
                        //   104: getfield        gnu/kawa/slib/StreamsDerived$frame5.lambda$Fn10:Lgnu/expr/ModuleMethod;
                        //   107: iconst_1       
                        //   108: invokespecial   gnu/kawa/slib/StreamPromise.<init>:(Lgnu/mapping/Procedure;Z)V
                        //   111: invokespecial   gnu/kawa/slib/StreamPair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
                        //   114: areturn        
                        //   115: new             Lgnu/mapping/WrongType;
                        //   118: dup_x1         
                        //   119: swap           
                        //   120: ldc             "cdr"
                        //   122: iconst_1       
                        //   123: aload_1        
                        //   124: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                        //   127: athrow         
                        //   128: new             Lgnu/mapping/WrongType;
                        //   131: dup_x1         
                        //   132: swap           
                        //   133: ldc             "car"
                        //   135: iconst_1       
                        //   136: aload_1        
                        //   137: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                        //   140: athrow         
                        //   141: new             Lgnu/mapping/WrongType;
                        //   144: dup_x1         
                        //   145: swap           
                        //   146: ldc             "car"
                        //   148: iconst_1       
                        //   149: aload_1        
                        //   150: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                        //   153: athrow         
                        //   154: new             Lgnu/mapping/WrongType;
                        //   157: dup_x1         
                        //   158: swap           
                        //   159: ldc             "cdr"
                        //   161: iconst_1       
                        //   162: aload_1        
                        //   163: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                        //   166: athrow         
                        //   167: new             Lgnu/mapping/WrongType;
                        //   170: dup_x1         
                        //   171: swap           
                        //   172: ldc             "stream-append"
                        //   174: iconst_0       
                        //   175: aload_1        
                        //   176: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                        //   179: athrow         
                        //    Exceptions:
                        //  Try           Handler
                        //  Start  End    Start  End    Type                          
                        //  -----  -----  -----  -----  ------------------------------
                        //  6      9      115    128    Ljava/lang/ClassCastException;
                        //  24     27     128    141    Ljava/lang/ClassCastException;
                        //  39     42     141    154    Ljava/lang/ClassCastException;
                        //  61     64     154    167    Ljava/lang/ClassCastException;
                        //  74     77     167    180    Ljava/lang/ClassCastException;
                        // 
                        // The error that occurred was:
                        // 
                        // java.lang.IndexOutOfBoundsException: Index 94 out of bounds for length 94
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
                    
                    Object lambda13() {
                        final LList strms = this.strms;
                        try {
                            return StreamsPrimitive.streamCar(lists.car((Pair)strms));
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "car", 1, strms);
                        }
                    }
                    
                    Object lambda14() {
                        final StreamsDerived$frame4 staticLink = this.staticLink;
                        LList list2;
                        final LList list = list2 = this.strms;
                        Object streamCdr;
                        LList list3;
                        try {
                            streamCdr = StreamsPrimitive.streamCdr(lists.car((Pair)list));
                            list3 = (list2 = this.strms);
                            final Pair pair = (Pair)list3;
                            final Object o = lists.cdr(pair);
                            final Pair pair2 = lists.cons(streamCdr, o);
                            return staticLink.lambda11streamAppend(pair2);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "car", 1, list2);
                        }
                        try {
                            final Pair pair = (Pair)list3;
                            final Object o = lists.cdr(pair);
                            final Pair pair2 = lists.cons(streamCdr, o);
                            return staticLink.lambda11streamAppend(pair2);
                        }
                        catch (ClassCastException ex2) {
                            throw new WrongType(ex2, "cdr", 1, list2);
                        }
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 9: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 8: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 7: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(moduleMethod, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 7: {
                                return this.lambda13();
                            }
                            case 8: {
                                return this.lambda14();
                            }
                            case 9: {
                                return this.lambda12();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame5 streamsDerived$frame5 = new StreamsDerived$frame5();
                streamsDerived$frame5.staticLink = this;
                final StreamsDerived$frame5 $heapFrame = streamsDerived$frame5;
                $heapFrame.strms = strms;
                return new StreamPromise($heapFrame.lambda$Fn8, true);
            }
        }
        final StreamsDerived$frame4 $heapFrame = new StreamsDerived$frame4();
        final LList strms = LList.makeList(argsArray, 0);
        Stream stream$Mnnull;
        if (lists.isNull(strms)) {
            stream$Mnnull = StreamsPrimitive.stream$Mnnull;
        }
        else {
            if (KawaConvert.isTrue(srfi1.any$V(StreamsDerived.lambda$Fn7, strms, new Object[0]))) {
                exceptions.error(StreamsDerived.Lit2, "non-stream argument");
                throw Special.reachedUnexpected;
            }
            stream$Mnnull = (Stream)$heapFrame.lambda11streamAppend(strms);
        }
        return stream$Mnnull;
    }
    
    public static Stream streamConcat(final Stream strms) {
        public class StreamsDerived$frame6 extends ModuleBody
        {
            public Object lambda15streamConcat(final Stream strms) {
                public class StreamsDerived$frame7 extends ModuleBody
                {
                    Stream strms;
                    StreamsDerived$frame6 staticLink;
                    final ModuleMethod lambda$Fn11;
                    final ModuleMethod lambda$Fn12;
                    final ModuleMethod lambda$Fn13;
                    final ModuleMethod lambda$Fn14;
                    final ModuleMethod lambda$Fn15;
                    
                    public StreamsDerived$frame7() {
                        this.lambda$Fn12 = new ModuleMethod(this, 10, null, 0);
                        this.lambda$Fn14 = new ModuleMethod(this, 11, null, 0);
                        this.lambda$Fn15 = new ModuleMethod(this, 12, null, 0);
                        this.lambda$Fn13 = new ModuleMethod(this, 13, null, 0);
                        this.lambda$Fn11 = new ModuleMethod(this, 14, null, 0);
                    }
                    
                    Object lambda16() {
                        if (StreamsPrimitive.isStreamNull(this.strms)) {
                            return StreamsPrimitive.stream$Mnnull;
                        }
                        if (!StreamsPrimitive.isStream(StreamsPrimitive.streamCar(this.strms))) {
                            exceptions.error(StreamsDerived.Lit3, "non-stream object in input stream");
                            throw Special.reachedUnexpected;
                        }
                        Label_0086: {
                            if (!StreamsPrimitive.isStreamNull(StreamsPrimitive.streamCar(this.strms))) {
                                break Label_0086;
                            }
                            final StreamsDerived$frame6 staticLink = this.staticLink;
                            final Object streamCdr = StreamsPrimitive.streamCdr(this.strms);
                            try {
                                return staticLink.lambda15streamConcat((Stream)streamCdr);
                                final StreamPromise x;
                                final StreamPromise y;
                                o = new StreamPair(x, y);
                                x = new StreamPromise(this.lambda$Fn12, false);
                                y = new StreamPromise(this.lambda$Fn13, true);
                                return o;
                            }
                            catch (ClassCastException ex) {
                                throw new WrongType(ex, "stream-concat", 0, streamCdr);
                            }
                        }
                    }
                    
                    Object lambda17() {
                        return StreamsPrimitive.streamCar(StreamsPrimitive.streamCar(this.strms));
                    }
                    
                    Object lambda18() {
                        return this.staticLink.lambda15streamConcat(new StreamPair(new StreamPromise(this.lambda$Fn14, false), new StreamPromise(this.lambda$Fn15, true)));
                    }
                    
                    Object lambda19() {
                        return StreamsPrimitive.streamCdr(StreamsPrimitive.streamCar(this.strms));
                    }
                    
                    Object lambda20() {
                        return StreamsPrimitive.streamCdr(this.strms);
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 14: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 13: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 12: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 11: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 10: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(moduleMethod, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 10: {
                                return this.lambda17();
                            }
                            case 11: {
                                return this.lambda19();
                            }
                            case 12: {
                                return this.lambda20();
                            }
                            case 13: {
                                return this.lambda18();
                            }
                            case 14: {
                                return this.lambda16();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame7 streamsDerived$frame7 = new StreamsDerived$frame7();
                streamsDerived$frame7.staticLink = this;
                final StreamsDerived$frame7 $heapFrame = streamsDerived$frame7;
                $heapFrame.strms = strms;
                return new StreamPromise($heapFrame.lambda$Fn11, true);
            }
        }
        final StreamsDerived$frame6 $heapFrame = new StreamsDerived$frame6();
        return (Stream)$heapFrame.lambda15streamConcat(strms);
    }
    
    public static Object streamConstant$V(final Object[] argsArray) {
        public class StreamsDerived$frame8 extends ModuleBody
        {
            LList objs;
            final ModuleMethod lambda$Fn16;
            final ModuleMethod lambda$Fn17;
            final ModuleMethod lambda$Fn18;
            final ModuleMethod lambda$Fn19;
            final ModuleMethod lambda$Fn20;
            
            public StreamsDerived$frame8() {
                this.lambda$Fn17 = new ModuleMethod(this, 15, null, 0);
                this.lambda$Fn18 = new ModuleMethod(this, 16, null, 0);
                this.lambda$Fn19 = new ModuleMethod(this, 17, null, 0);
                this.lambda$Fn20 = new ModuleMethod(this, 18, null, 0);
                this.lambda$Fn16 = new ModuleMethod(this, 19, null, 0);
            }
            
            Object lambda21() {
                if (lists.isNull(this.objs)) {
                    return StreamsPrimitive.stream$Mnnull;
                }
                final LList objs = this.objs;
                try {
                    Stream stream$Mnnull;
                    if (lists.isNull(lists.cdr((Pair)objs))) {
                        final StreamPromise x;
                        final StreamPromise y;
                        stream$Mnnull = new StreamPair(x, y);
                        x = new StreamPromise(this.lambda$Fn17, false);
                        y = new StreamPromise(this.lambda$Fn18, true);
                    }
                    else {
                        final StreamPromise x2;
                        final StreamPromise y2;
                        stream$Mnnull = new StreamPair(x2, y2);
                        x2 = new StreamPromise(this.lambda$Fn19, false);
                        y2 = new StreamPromise(this.lambda$Fn20, true);
                    }
                    return stream$Mnnull;
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "cdr", 1, objs);
                }
            }
            
            Object lambda22() {
                final LList objs = this.objs;
                try {
                    return lists.car((Pair)objs);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "car", 1, objs);
                }
            }
            
            Object lambda23() {
                final Object[] argsArray = { null };
                final int n = 0;
                final LList objs = this.objs;
                try {
                    argsArray[n] = lists.car((Pair)objs);
                    return StreamsDerived.streamConstant$V(argsArray);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "car", 1, objs);
                }
            }
            
            Object lambda24() {
                final LList objs = this.objs;
                try {
                    return lists.car((Pair)objs);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "car", 1, objs);
                }
            }
            
            Object lambda25() {
                final Apply apply = Scheme.apply;
                final ModuleMethod stream$Mnconstant = StreamsDerived.stream$Mnconstant;
                final Object[] array = new Object[2];
                final int n = 0;
                LList list2;
                final LList list = list2 = this.objs;
                int n2;
                LList list3;
                try {
                    array[n] = lists.cdr((Pair)list);
                    n2 = 1;
                    list3 = (list2 = this.objs);
                    final Pair pair = (Pair)list3;
                    final Object o = lists.car(pair);
                    final Pair pair2 = LList.list1(o);
                    array[n2] = pair2;
                    final Object o2 = append.append$V(array);
                    return apply.apply2(stream$Mnconstant, o2);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "cdr", 1, list2);
                }
                try {
                    final Pair pair = (Pair)list3;
                    final Object o = lists.car(pair);
                    final Pair pair2 = LList.list1(o);
                    array[n2] = pair2;
                    final Object o2 = append.append$V(array);
                    return apply.apply2(stream$Mnconstant, o2);
                }
                catch (ClassCastException ex2) {
                    throw new WrongType(ex2, "car", 1, list2);
                }
            }
            
            @Override
            public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                switch (moduleMethod.selector) {
                    case 19: {
                        ctx.proc = moduleMethod;
                        return ctx.pc = 0;
                    }
                    case 18: {
                        ctx.proc = moduleMethod;
                        return ctx.pc = 0;
                    }
                    case 17: {
                        ctx.proc = moduleMethod;
                        return ctx.pc = 0;
                    }
                    case 16: {
                        ctx.proc = moduleMethod;
                        return ctx.pc = 0;
                    }
                    case 15: {
                        ctx.proc = moduleMethod;
                        return ctx.pc = 0;
                    }
                    default: {
                        return super.match0(moduleMethod, ctx);
                    }
                }
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply0(final ModuleMethod method) {
                switch (method.selector) {
                    case 15: {
                        return this.lambda22();
                    }
                    case 16: {
                        return this.lambda23();
                    }
                    case 17: {
                        return this.lambda24();
                    }
                    case 18: {
                        return this.lambda25();
                    }
                    case 19: {
                        return this.lambda21();
                    }
                    default: {
                        return super.apply0(method);
                    }
                }
            }
        }
        final StreamsDerived$frame8 $heapFrame = new StreamsDerived$frame8();
        $heapFrame.objs = LList.makeList(argsArray, 0);
        return new StreamPromise($heapFrame.lambda$Fn16, true);
    }
    
    public static Stream streamDrop(final IntNum n, final Stream strm) {
        public class StreamsDerived$frame9 extends ModuleBody
        {
            public Object lambda26streamDrop(final IntNum n, final Stream strm) {
                public class StreamsDerived$frame10 extends ModuleBody
                {
                    Stream strm;
                    IntNum n;
                    StreamsDerived$frame9 staticLink;
                    final ModuleMethod lambda$Fn21;
                    
                    public StreamsDerived$frame10() {
                        this.lambda$Fn21 = new ModuleMethod(this, 20, null, 0);
                    }
                    
                    Object lambda27() {
                        final boolean x = numbers.isZero(this.n);
                        Label_0036: {
                            if (x) {
                                if (!x) {
                                    break Label_0036;
                                }
                            }
                            else if (!StreamsPrimitive.isStreamNull(this.strm)) {
                                break Label_0036;
                            }
                            return this.strm;
                        }
                        final StreamsDerived$frame9 staticLink = this.staticLink;
                        final IntNum add = IntNum.add(this.n, -1);
                        final Object streamCdr = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            return staticLink.lambda26streamDrop(add, (Stream)streamCdr);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "stream-drop", 1, streamCdr);
                        }
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        if (moduleMethod.selector == 20) {
                            ctx.proc = moduleMethod;
                            return ctx.pc = 0;
                        }
                        return super.match0(moduleMethod, ctx);
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        if (method.selector == 20) {
                            return this.lambda27();
                        }
                        return super.apply0(method);
                    }
                }
                final StreamsDerived$frame10 streamsDerived$frame10 = new StreamsDerived$frame10();
                streamsDerived$frame10.staticLink = this;
                final StreamsDerived$frame10 $heapFrame = streamsDerived$frame10;
                $heapFrame.n = n;
                $heapFrame.strm = strm;
                return new StreamPromise($heapFrame.lambda$Fn21, true);
            }
        }
        final StreamsDerived$frame9 $heapFrame = new StreamsDerived$frame9();
        if (numbers.isNegative(n)) {
            exceptions.error(StreamsDerived.Lit4, "negative argument");
            throw Special.reachedUnexpected;
        }
        return (Stream)$heapFrame.lambda26streamDrop(n, strm);
    }
    
    public static Stream streamDropWhile(final Procedure isPred, final Stream strm) {
        public class StreamsDerived$frame11 extends ModuleBody
        {
            Procedure pred$Qu;
            
            public Object lambda28streamDropWhile(final Stream strm) {
                public class StreamsDerived$frame12 extends ModuleBody
                {
                    Stream strm;
                    StreamsDerived$frame11 staticLink;
                    final ModuleMethod lambda$Fn22;
                    
                    public StreamsDerived$frame12() {
                        this.lambda$Fn22 = new ModuleMethod(this, 21, null, 0);
                    }
                    
                    Object lambda29() {
                        Label_0055: {
                            if (!StreamsPrimitive.isStreamPair(this.strm) || !KawaConvert.isTrue(this.staticLink.pred$Qu.apply1(StreamsPrimitive.streamCar(this.strm)))) {
                                break Label_0055;
                            }
                            final StreamsDerived$frame11 staticLink = this.staticLink;
                            final Object streamCdr = StreamsPrimitive.streamCdr(this.strm);
                            try {
                                return staticLink.lambda28streamDropWhile((Stream)streamCdr);
                                o = this.strm;
                                return o;
                            }
                            catch (ClassCastException ex) {
                                throw new WrongType(ex, "stream-drop-while", 0, streamCdr);
                            }
                        }
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        if (moduleMethod.selector == 21) {
                            ctx.proc = moduleMethod;
                            return ctx.pc = 0;
                        }
                        return super.match0(moduleMethod, ctx);
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        if (method.selector == 21) {
                            return this.lambda29();
                        }
                        return super.apply0(method);
                    }
                }
                final StreamsDerived$frame12 streamsDerived$frame12 = new StreamsDerived$frame12();
                streamsDerived$frame12.staticLink = this;
                final StreamsDerived$frame12 $heapFrame = streamsDerived$frame12;
                $heapFrame.strm = strm;
                return new StreamPromise($heapFrame.lambda$Fn22, true);
            }
        }
        final StreamsDerived$frame11 $heapFrame = new StreamsDerived$frame11();
        $heapFrame.pred$Qu = isPred;
        return (Stream)$heapFrame.lambda28streamDropWhile(strm);
    }
    
    public static Stream streamFilter(final Procedure isPred, final Stream strm) {
        public class StreamsDerived$frame13 extends ModuleBody
        {
            Procedure pred$Qu;
            
            public Object lambda30streamFilter(final Stream strm) {
                public class StreamsDerived$frame14 extends ModuleBody
                {
                    Stream strm;
                    StreamsDerived$frame13 staticLink;
                    final ModuleMethod lambda$Fn23;
                    final ModuleMethod lambda$Fn24;
                    final ModuleMethod lambda$Fn25;
                    
                    public StreamsDerived$frame14() {
                        this.lambda$Fn24 = new ModuleMethod(this, 22, null, 0);
                        this.lambda$Fn25 = new ModuleMethod(this, 23, null, 0);
                        this.lambda$Fn23 = new ModuleMethod(this, 24, null, 0);
                    }
                    
                    Object lambda31() {
                        if (StreamsPrimitive.isStreamNull(this.strm)) {
                            return StreamsPrimitive.stream$Mnnull;
                        }
                        if (KawaConvert.isTrue(this.staticLink.pred$Qu.apply1(StreamsPrimitive.streamCar(this.strm)))) {
                            return new StreamPair(new StreamPromise(this.lambda$Fn24, false), new StreamPromise(this.lambda$Fn25, true));
                        }
                        final StreamsDerived$frame13 staticLink = this.staticLink;
                        final Object streamCdr = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            return staticLink.lambda30streamFilter((Stream)streamCdr);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "stream-filter", 0, streamCdr);
                        }
                    }
                    
                    Object lambda32() {
                        return StreamsPrimitive.streamCar(this.strm);
                    }
                    
                    Object lambda33() {
                        final StreamsDerived$frame13 staticLink = this.staticLink;
                        final Object streamCdr = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            return staticLink.lambda30streamFilter((Stream)streamCdr);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "stream-filter", 0, streamCdr);
                        }
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 24: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 23: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 22: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(moduleMethod, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 22: {
                                return this.lambda32();
                            }
                            case 23: {
                                return this.lambda33();
                            }
                            case 24: {
                                return this.lambda31();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame14 streamsDerived$frame14 = new StreamsDerived$frame14();
                streamsDerived$frame14.staticLink = this;
                final StreamsDerived$frame14 $heapFrame = streamsDerived$frame14;
                $heapFrame.strm = strm;
                return new StreamPromise($heapFrame.lambda$Fn23, true);
            }
        }
        final StreamsDerived$frame13 $heapFrame = new StreamsDerived$frame13();
        $heapFrame.pred$Qu = isPred;
        return (Stream)$heapFrame.lambda30streamFilter(strm);
    }
    
    public static Object streamFold(final Procedure proc, final Object base, final Stream strm) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_2         /* strm */
        //     2: astore          4
        //     4: astore_3        /* base */
        //     5: aload           strm
        //     7: invokestatic    gnu/kawa/slib/StreamsPrimitive.isStreamNull:(Ljava/lang/Object;)Z
        //    10: ifeq            17
        //    13: aload_3         /* base */
        //    14: goto            38
        //    17: aload_0         /* proc */
        //    18: aload_3         /* base */
        //    19: aload           strm
        //    21: invokestatic    gnu/kawa/slib/StreamsPrimitive.streamCar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    24: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    27: aload           strm
        //    29: invokestatic    gnu/kawa/slib/StreamsPrimitive.streamCdr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    32: checkcast       Lgnu/kawa/slib/Stream;
        //    35: goto            2
        //    38: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    
    public static Object streamForEach$V(final Procedure proc, final Object[] argsArray) {
        final LList strms = LList.makeList(argsArray, 0);
        if (lists.isNull(strms)) {
            exceptions.error(StreamsDerived.Lit5, "no stream arguments");
            throw Special.reachedUnexpected;
        }
        if (KawaConvert.isTrue(srfi1.any$V(StreamsDerived.lambda$Fn26, strms, new Object[0]))) {
            exceptions.error(StreamsDerived.Lit5, "non-stream argument");
            throw Special.reachedUnexpected;
        }
        LList list = strms;
        while (true) {
            final LList strms2 = list;
            if (KawaConvert.isTrue(srfi1.any$V(StreamsPrimitive.stream$Mnnull$Qu, strms2, new Object[0]))) {
                break;
            }
            final Apply apply = Scheme.apply;
            Object cdr = strms2;
            LList empty = LList.Empty;
            Pair pair = null;
            while (cdr != LList.Empty) {
                final Pair pair2 = (Pair)Promise.force(cdr, Pair.class);
                final Pair cdr2 = new Pair(StreamsPrimitive.streamCar(pair2.getCar()), LList.Empty);
                if (pair == null) {
                    empty = cdr2;
                }
                else {
                    pair.setCdr(cdr2);
                }
                pair = cdr2;
                cdr = pair2.getCdr();
            }
            apply.apply2(proc, empty);
            Object cdr3 = strms2;
            LList empty2 = LList.Empty;
            Pair pair3 = null;
            while (cdr3 != LList.Empty) {
                final Pair pair4 = (Pair)Promise.force(cdr3, Pair.class);
                final Pair cdr4 = new Pair(StreamsPrimitive.streamCdr(pair4.getCar()), LList.Empty);
                if (pair3 == null) {
                    empty2 = cdr4;
                }
                else {
                    pair3.setCdr(cdr4);
                }
                pair3 = cdr4;
                cdr3 = pair4.getCdr();
            }
            list = empty2;
        }
        return Values.empty;
    }
    
    static boolean lambda34(final Object x) {
        return !StreamsPrimitive.isStream(x);
    }
    
    public static Stream streamFrom(final Numeric first) {
        return streamFrom(first, StreamsDerived.Lit6);
    }
    
    public static Stream streamFrom(final Numeric first, final Numeric delta) {
        public class StreamsDerived$frame15 extends ModuleBody
        {
            public Object lambda35streamFrom(final Numeric first, final Numeric delta) {
                public class StreamsDerived$frame16 extends ModuleBody
                {
                    Numeric delta;
                    Numeric first;
                    StreamsDerived$frame15 staticLink;
                    final ModuleMethod lambda$Fn27;
                    final ModuleMethod lambda$Fn28;
                    final ModuleMethod lambda$Fn29;
                    
                    public StreamsDerived$frame16() {
                        this.lambda$Fn28 = new ModuleMethod(this, 25, null, 0);
                        this.lambda$Fn29 = new ModuleMethod(this, 26, null, 0);
                        this.lambda$Fn27 = new ModuleMethod(this, 27, null, 0);
                    }
                    
                    StreamPair lambda36() {
                        return new StreamPair(new StreamPromise(this.lambda$Fn28, false), new StreamPromise(this.lambda$Fn29, true));
                    }
                    
                    Numeric lambda37() {
                        return this.first;
                    }
                    
                    Object lambda38() {
                        final StreamsDerived$frame15 staticLink = this.staticLink;
                        final Object force = Promise.force(AddOp.apply2(1, this.first, this.delta), Numeric.class);
                        try {
                            return staticLink.lambda35streamFrom(LangObjType.coerceNumeric(force), this.delta);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "stream-from", 0, force);
                        }
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 27: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 26: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 25: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(moduleMethod, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 25: {
                                return this.lambda37();
                            }
                            case 26: {
                                return this.lambda38();
                            }
                            case 27: {
                                return this.lambda36();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame16 streamsDerived$frame16 = new StreamsDerived$frame16();
                streamsDerived$frame16.staticLink = this;
                final StreamsDerived$frame16 $heapFrame = streamsDerived$frame16;
                $heapFrame.first = first;
                $heapFrame.delta = delta;
                return new StreamPromise($heapFrame.lambda$Fn27, true);
            }
        }
        final StreamsDerived$frame15 $heapFrame = new StreamsDerived$frame15();
        return (Stream)$heapFrame.lambda35streamFrom(first, delta);
    }
    
    public static Stream streamIterate(final Procedure proc, final Object base) {
        public class StreamsDerived$frame17 extends ModuleBody
        {
            Procedure proc;
            
            public Object lambda39streamIterate(final Object base) {
                public class StreamsDerived$frame18 extends ModuleBody
                {
                    Object base;
                    StreamsDerived$frame17 staticLink;
                    final ModuleMethod lambda$Fn30;
                    final ModuleMethod lambda$Fn31;
                    final ModuleMethod lambda$Fn32;
                    
                    public StreamsDerived$frame18() {
                        this.lambda$Fn31 = new ModuleMethod(this, 28, null, 0);
                        this.lambda$Fn32 = new ModuleMethod(this, 29, null, 0);
                        this.lambda$Fn30 = new ModuleMethod(this, 30, null, 0);
                    }
                    
                    StreamPair lambda40() {
                        return new StreamPair(new StreamPromise(this.lambda$Fn31, false), new StreamPromise(this.lambda$Fn32, true));
                    }
                    
                    Object lambda41() {
                        return this.base;
                    }
                    
                    Object lambda42() {
                        return this.staticLink.lambda39streamIterate(this.staticLink.proc.apply1(this.base));
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 30: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 29: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 28: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(moduleMethod, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 28: {
                                return this.lambda41();
                            }
                            case 29: {
                                return this.lambda42();
                            }
                            case 30: {
                                return this.lambda40();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame18 streamsDerived$frame18 = new StreamsDerived$frame18();
                streamsDerived$frame18.staticLink = this;
                final StreamsDerived$frame18 $heapFrame = streamsDerived$frame18;
                $heapFrame.base = base;
                return new StreamPromise($heapFrame.lambda$Fn30, true);
            }
        }
        final StreamsDerived$frame17 $heapFrame = new StreamsDerived$frame17();
        $heapFrame.proc = proc;
        return (Stream)$heapFrame.lambda39streamIterate(base);
    }
    
    public static IntNum streamLength(final Stream strm) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_0         /* strm */
        //     4: astore_2       
        //     5: astore_1        /* len */
        //     6: aload_2         /* strm */
        //     7: invokestatic    gnu/kawa/slib/StreamsPrimitive.isStreamNull:(Ljava/lang/Object;)Z
        //    10: ifeq            17
        //    13: aload_1         /* len */
        //    14: goto            32
        //    17: aload_1         /* len */
        //    18: iconst_1       
        //    19: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    22: aload_2         /* strm */
        //    23: invokestatic    gnu/kawa/slib/StreamsPrimitive.streamCdr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    26: checkcast       Lgnu/kawa/slib/Stream;
        //    29: goto            4
        //    32: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    
    public static Stream streamMap$V(final Procedure proc, final Object[] argsArray) {
        public class StreamsDerived$frame19 extends ModuleBody
        {
            Procedure proc;
            
            static boolean lambda43(final Object x) {
                return !StreamsPrimitive.isStream(x);
            }
            
            public Object lambda44streamMap(final LList strms) {
                public class StreamsDerived$frame20 extends ModuleBody
                {
                    LList strms;
                    StreamsDerived$frame19 staticLink;
                    final ModuleMethod lambda$Fn34;
                    final ModuleMethod lambda$Fn35;
                    final ModuleMethod lambda$Fn36;
                    
                    public StreamsDerived$frame20() {
                        this.lambda$Fn35 = new ModuleMethod(this, 31, null, 0);
                        this.lambda$Fn36 = new ModuleMethod(this, 32, null, 0);
                        this.lambda$Fn34 = new ModuleMethod(this, 33, null, 0);
                    }
                    
                    Object lambda45() {
                        return KawaConvert.isTrue(srfi1.any$V(StreamsPrimitive.stream$Mnnull$Qu, this.strms, new Object[0])) ? StreamsPrimitive.stream$Mnnull : new StreamPair(new StreamPromise(this.lambda$Fn35, false), new StreamPromise(this.lambda$Fn36, true));
                    }
                    
                    Object lambda46() {
                        final Apply apply = Scheme.apply;
                        final Procedure proc = this.staticLink.proc;
                        Object arg = this.strms;
                        LList empty = LList.Empty;
                        Pair pair = null;
                        while (arg != LList.Empty) {
                            final Pair pair2 = (Pair)Promise.force(arg, Pair.class);
                            final Pair cdr = new Pair(StreamsPrimitive.streamCar(pair2.getCar()), LList.Empty);
                            if (pair == null) {
                                empty = cdr;
                            }
                            else {
                                pair.setCdr(cdr);
                            }
                            pair = cdr;
                            arg = pair2.getCdr();
                        }
                        return apply.apply2(proc, empty);
                    }
                    
                    Object lambda47() {
                        final StreamsDerived$frame19 staticLink = this.staticLink;
                        Object arg = this.strms;
                        LList empty = LList.Empty;
                        Pair pair = null;
                        while (arg != LList.Empty) {
                            final Pair pair2 = (Pair)Promise.force(arg, Pair.class);
                            final Pair cdr = new Pair(StreamsPrimitive.streamCdr(pair2.getCar()), LList.Empty);
                            if (pair == null) {
                                empty = cdr;
                            }
                            else {
                                pair.setCdr(cdr);
                            }
                            pair = cdr;
                            arg = pair2.getCdr();
                        }
                        return staticLink.lambda44streamMap(empty);
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 33: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 32: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 31: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(moduleMethod, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 31: {
                                return this.lambda46();
                            }
                            case 32: {
                                return this.lambda47();
                            }
                            case 33: {
                                return this.lambda45();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame20 streamsDerived$frame20 = new StreamsDerived$frame20();
                streamsDerived$frame20.staticLink = this;
                final StreamsDerived$frame20 $heapFrame = streamsDerived$frame20;
                $heapFrame.strms = strms;
                return new StreamPromise($heapFrame.lambda$Fn34, true);
            }
        }
        final StreamsDerived$frame19 $heapFrame = new StreamsDerived$frame19();
        $heapFrame.proc = proc;
        final LList strms = LList.makeList(argsArray, 0);
        if (lists.isNull(strms)) {
            exceptions.error(StreamsDerived.Lit8, "no stream arguments");
            throw Special.reachedUnexpected;
        }
        if (KawaConvert.isTrue(srfi1.any$V(StreamsDerived.lambda$Fn33, strms, new Object[0]))) {
            exceptions.error(StreamsDerived.Lit8, "non-stream argument");
            throw Special.reachedUnexpected;
        }
        return (Stream)$heapFrame.lambda44streamMap(strms);
    }
    
    public static Stream streamRange$V(final Numeric first, final Numeric past, final Object[] argsArray) {
        public class StreamsDerived$frame21 extends ModuleBody
        {
            public Object lambda48streamRange(final Numeric first, final Numeric past, final Numeric delta, final Procedure isLt) {
                public class StreamsDerived$frame22 extends ModuleBody
                {
                    Numeric delta;
                    Numeric past;
                    Numeric first;
                    Procedure lt$Qu;
                    StreamsDerived$frame21 staticLink;
                    final ModuleMethod lambda$Fn37;
                    final ModuleMethod lambda$Fn38;
                    final ModuleMethod lambda$Fn39;
                    
                    public StreamsDerived$frame22() {
                        this.lambda$Fn38 = new ModuleMethod(this, 34, null, 0);
                        this.lambda$Fn39 = new ModuleMethod(this, 35, null, 0);
                        this.lambda$Fn37 = new ModuleMethod(this, 36, null, 0);
                    }
                    
                    Object lambda49() {
                        return KawaConvert.isTrue(this.lt$Qu.apply2(this.first, this.past)) ? new StreamPair(new StreamPromise(this.lambda$Fn38, false), new StreamPromise(this.lambda$Fn39, true)) : StreamsPrimitive.stream$Mnnull;
                    }
                    
                    Numeric lambda50() {
                        return this.first;
                    }
                    
                    Object lambda51() {
                        final StreamsDerived$frame21 staticLink = this.staticLink;
                        final Object force = Promise.force(AddOp.apply2(1, this.first, this.delta), Numeric.class);
                        try {
                            return staticLink.lambda48streamRange(LangObjType.coerceNumeric(force), this.past, this.delta, this.lt$Qu);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "stream-range", 0, force);
                        }
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 36: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 35: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 34: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(moduleMethod, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 34: {
                                return this.lambda50();
                            }
                            case 35: {
                                return this.lambda51();
                            }
                            case 36: {
                                return this.lambda49();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame22 streamsDerived$frame22 = new StreamsDerived$frame22();
                streamsDerived$frame22.staticLink = this;
                final StreamsDerived$frame22 $heapFrame = streamsDerived$frame22;
                $heapFrame.first = first;
                $heapFrame.past = past;
                $heapFrame.delta = delta;
                $heapFrame.lt$Qu = isLt;
                return new StreamPromise($heapFrame.lambda$Fn37, true);
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/slib/StreamsDerived$frame21.<init>:()V
        //     7: astore          $heapFrame
        //     9: aload_2         /* argsArray */
        //    10: iconst_0       
        //    11: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //    14: dup            
        //    15: astore          5
        //    17: astore_3        /* step */
        //    18: aload_3         /* step */
        //    19: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    22: ifeq            50
        //    25: aload_3         /* step */
        //    26: dup            
        //    27: astore          6
        //    29: checkcast       Lgnu/lists/Pair;
        //    32: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    35: ldc_w           Lgnu/math/Numeric;.class
        //    38: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    41: dup            
        //    42: astore          6
        //    44: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceNumeric:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //    47: goto            67
        //    50: aload_0         /* first */
        //    51: aload_1         /* past */
        //    52: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    55: ifeq            64
        //    58: getstatic       gnu/kawa/slib/StreamsDerived.Lit6:Lgnu/math/IntNum;
        //    61: goto            67
        //    64: getstatic       gnu/kawa/slib/StreamsDerived.Lit1:Lgnu/math/IntNum;
        //    67: astore          delta
        //    69: getstatic       gnu/kawa/slib/StreamsDerived.Lit7:Lgnu/math/IntNum;
        //    72: aload           delta
        //    74: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    77: ifeq            86
        //    80: getstatic       kawa/standard/Scheme.numLss:Lgnu/kawa/functions/NumberCompare;
        //    83: goto            89
        //    86: getstatic       kawa/standard/Scheme.numGrt:Lgnu/kawa/functions/NumberCompare;
        //    89: astore          lt$Qu
        //    91: aload           $heapFrame
        //    93: aload_0         /* first */
        //    94: aload_1         /* past */
        //    95: aload           delta
        //    97: aload           lt$Qu
        //    99: invokevirtual   gnu/kawa/slib/StreamsDerived$frame21.lambda48streamRange:(Lgnu/math/Numeric;Lgnu/math/Numeric;Lgnu/math/Numeric;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //   102: checkcast       Lgnu/kawa/slib/Stream;
        //   105: areturn        
        //   106: new             Lgnu/mapping/WrongType;
        //   109: dup_x1         
        //   110: swap           
        //   111: ldc             "car"
        //   113: iconst_1       
        //   114: aload           6
        //   116: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   119: athrow         
        //   120: new             Lgnu/mapping/WrongType;
        //   123: dup_x1         
        //   124: swap           
        //   125: ldc_w           "delta"
        //   128: bipush          -2
        //   130: aload           6
        //   132: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   135: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  29     32     106    120    Ljava/lang/ClassCastException;
        //  44     47     120    136    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0050:
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object streamRef(final Stream strm, final IntNum n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
        //     4: ifeq            29
        //     7: iconst_2       
        //     8: anewarray       Ljava/lang/Object;
        //    11: dup            
        //    12: iconst_0       
        //    13: getstatic       gnu/kawa/slib/StreamsDerived.Lit9:Lgnu/mapping/SimpleSymbol;
        //    16: aastore        
        //    17: dup            
        //    18: iconst_1       
        //    19: ldc             "negative argument"
        //    21: aastore        
        //    22: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //    25: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //    28: athrow         
        //    29: aload_0         /* strm */
        //    30: aload_1         /* n */
        //    31: astore_3       
        //    32: astore_2        /* strm */
        //    33: aload_2         /* strm */
        //    34: invokestatic    gnu/kawa/slib/StreamsPrimitive.isStreamNull:(Ljava/lang/Object;)Z
        //    37: ifeq            63
        //    40: iconst_2       
        //    41: anewarray       Ljava/lang/Object;
        //    44: dup            
        //    45: iconst_0       
        //    46: getstatic       gnu/kawa/slib/StreamsDerived.Lit9:Lgnu/mapping/SimpleSymbol;
        //    49: aastore        
        //    50: dup            
        //    51: iconst_1       
        //    52: ldc_w           "beyond end of stream"
        //    55: aastore        
        //    56: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //    59: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //    62: athrow         
        //    63: aload_3         /* n */
        //    64: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    67: ifeq            77
        //    70: aload_2         /* strm */
        //    71: invokestatic    gnu/kawa/slib/StreamsPrimitive.streamCar:(Ljava/lang/Object;)Ljava/lang/Object;
        //    74: goto            92
        //    77: aload_2         /* strm */
        //    78: invokestatic    gnu/kawa/slib/StreamsPrimitive.streamCdr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    81: checkcast       Lgnu/kawa/slib/Stream;
        //    84: aload_3         /* n */
        //    85: iconst_m1      
        //    86: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    89: goto            31
        //    92: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    
    public static Stream streamReverse(final Stream strm) {
        public class StreamsDerived$frame23 extends ModuleBody
        {
            public Object lambda52streamReverse(final Stream strm, final Stream rev) {
                public class StreamsDerived$frame24 extends ModuleBody
                {
                    Stream rev;
                    Stream strm;
                    StreamsDerived$frame23 staticLink;
                    final ModuleMethod lambda$Fn40;
                    final ModuleMethod lambda$Fn41;
                    final ModuleMethod lambda$Fn42;
                    
                    public StreamsDerived$frame24() {
                        this.lambda$Fn41 = new ModuleMethod(this, 37, null, 0);
                        this.lambda$Fn42 = new ModuleMethod(this, 38, null, 0);
                        this.lambda$Fn40 = new ModuleMethod(this, 39, null, 0);
                    }
                    
                    Object lambda53() {
                        if (StreamsPrimitive.isStreamNull(this.strm)) {
                            return this.rev;
                        }
                        final StreamsDerived$frame23 staticLink = this.staticLink;
                        final Object streamCdr = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            return staticLink.lambda52streamReverse((Stream)streamCdr, new StreamPair(new StreamPromise(this.lambda$Fn41, false), new StreamPromise(this.lambda$Fn42, true)));
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "stream-reverse", 0, streamCdr);
                        }
                    }
                    
                    Object lambda54() {
                        return StreamsPrimitive.streamCar(this.strm);
                    }
                    
                    Stream lambda55() {
                        return this.rev;
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 39: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 38: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 37: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(moduleMethod, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 37: {
                                return this.lambda54();
                            }
                            case 38: {
                                return this.lambda55();
                            }
                            case 39: {
                                return this.lambda53();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame24 streamsDerived$frame24 = new StreamsDerived$frame24();
                streamsDerived$frame24.staticLink = this;
                final StreamsDerived$frame24 $heapFrame = streamsDerived$frame24;
                $heapFrame.strm = strm;
                $heapFrame.rev = rev;
                return new StreamPromise($heapFrame.lambda$Fn40, true);
            }
        }
        final StreamsDerived$frame23 $heapFrame = new StreamsDerived$frame23();
        return (Stream)$heapFrame.lambda52streamReverse(strm, StreamsPrimitive.stream$Mnnull);
    }
    
    public static Stream streamScan(final Procedure proc, final Object base, final Stream strm) {
        public class StreamsDerived$frame25 extends ModuleBody
        {
            Procedure proc;
            
            public Object lambda56streamScan(final Object base, final Stream strm) {
                public class StreamsDerived$frame26 extends ModuleBody
                {
                    Object base;
                    Stream strm;
                    StreamsDerived$frame25 staticLink;
                    final ModuleMethod lambda$Fn43;
                    final ModuleMethod lambda$Fn44;
                    final ModuleMethod lambda$Fn46;
                    final ModuleMethod lambda$Fn47;
                    
                    public StreamsDerived$frame26() {
                        this.lambda$Fn44 = new ModuleMethod(this, 40, null, 0);
                        this.lambda$Fn46 = new ModuleMethod(this, 41, null, 0);
                        this.lambda$Fn47 = new ModuleMethod(this, 42, null, 0);
                        this.lambda$Fn43 = new ModuleMethod(this, 43, null, 0);
                    }
                    
                    StreamPair lambda57() {
                        return StreamsPrimitive.isStreamNull(this.strm) ? new StreamPair(new StreamPromise(this.lambda$Fn44, false), new StreamPromise(StreamsDerived.lambda$Fn45, true)) : new StreamPair(new StreamPromise(this.lambda$Fn46, false), new StreamPromise(this.lambda$Fn47, true));
                    }
                    
                    Object lambda58() {
                        return this.base;
                    }
                    
                    static StreamPromise lambda59() {
                        return StreamsPrimitive.stream$Mnnull;
                    }
                    
                    Object lambda60() {
                        return this.base;
                    }
                    
                    Object lambda61() {
                        final StreamsDerived$frame25 staticLink = this.staticLink;
                        final Object apply2 = this.staticLink.proc.apply2(this.base, StreamsPrimitive.streamCar(this.strm));
                        final Object streamCdr = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            return staticLink.lambda56streamScan(apply2, (Stream)streamCdr);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "stream-scan", 1, streamCdr);
                        }
                    }
                    
                    @Override
                    public int match0(final ModuleMethod proc, final CallContext ctx) {
                        switch (proc.selector) {
                            case 43: {
                                ctx.proc = proc;
                                return ctx.pc = 0;
                            }
                            case 42: {
                                ctx.proc = proc;
                                return ctx.pc = 0;
                            }
                            case 41: {
                                ctx.proc = proc;
                                return ctx.pc = 0;
                            }
                            case 40: {
                                ctx.proc = proc;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(proc, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 40: {
                                return this.lambda58();
                            }
                            case 41: {
                                return this.lambda60();
                            }
                            case 42: {
                                return this.lambda61();
                            }
                            case 43: {
                                return this.lambda57();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame26 streamsDerived$frame26 = new StreamsDerived$frame26();
                streamsDerived$frame26.staticLink = this;
                final StreamsDerived$frame26 $heapFrame = streamsDerived$frame26;
                $heapFrame.base = base;
                $heapFrame.strm = strm;
                return new StreamPromise($heapFrame.lambda$Fn43, true);
            }
        }
        final StreamsDerived$frame25 $heapFrame = new StreamsDerived$frame25();
        $heapFrame.proc = proc;
        return (Stream)$heapFrame.lambda56streamScan(base, strm);
    }
    
    public static Stream streamTake(final IntNum n, final Stream strm) {
        public class StreamsDerived$frame27 extends ModuleBody
        {
            public Object lambda62streamTake(final IntNum n, final Stream strm) {
                public class StreamsDerived$frame28 extends ModuleBody
                {
                    IntNum n;
                    Stream strm;
                    StreamsDerived$frame27 staticLink;
                    final ModuleMethod lambda$Fn48;
                    final ModuleMethod lambda$Fn49;
                    final ModuleMethod lambda$Fn50;
                    
                    public StreamsDerived$frame28() {
                        this.lambda$Fn49 = new ModuleMethod(this, 44, null, 0);
                        this.lambda$Fn50 = new ModuleMethod(this, 45, null, 0);
                        this.lambda$Fn48 = new ModuleMethod(this, 46, null, 0);
                    }
                    
                    Object lambda63() {
                        final boolean x = StreamsPrimitive.isStreamNull(this.strm);
                        return (x ? x : numbers.isZero(this.n)) ? StreamsPrimitive.stream$Mnnull : new StreamPair(new StreamPromise(this.lambda$Fn49, false), new StreamPromise(this.lambda$Fn50, true));
                    }
                    
                    Object lambda64() {
                        return StreamsPrimitive.streamCar(this.strm);
                    }
                    
                    Object lambda65() {
                        final StreamsDerived$frame27 staticLink = this.staticLink;
                        final IntNum add = IntNum.add(this.n, -1);
                        final Object streamCdr = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            return staticLink.lambda62streamTake(add, (Stream)streamCdr);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "stream-take", 1, streamCdr);
                        }
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 46: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 45: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 44: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(moduleMethod, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 44: {
                                return this.lambda64();
                            }
                            case 45: {
                                return this.lambda65();
                            }
                            case 46: {
                                return this.lambda63();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame28 streamsDerived$frame28 = new StreamsDerived$frame28();
                streamsDerived$frame28.staticLink = this;
                final StreamsDerived$frame28 $heapFrame = streamsDerived$frame28;
                $heapFrame.n = n;
                $heapFrame.strm = strm;
                return new StreamPromise($heapFrame.lambda$Fn48, true);
            }
        }
        final StreamsDerived$frame27 $heapFrame = new StreamsDerived$frame27();
        if (numbers.isNegative(n)) {
            exceptions.error(StreamsDerived.Lit10, "negative argument");
            throw Special.reachedUnexpected;
        }
        return (Stream)$heapFrame.lambda62streamTake(n, strm);
    }
    
    public static Stream streamTakeWhile(final Procedure isPred, final Stream strm) {
        public class StreamsDerived$frame29 extends ModuleBody
        {
            Procedure pred$Qu;
            
            public Object lambda66streamTakeWhile(final Stream strm) {
                public class StreamsDerived$frame30 extends ModuleBody
                {
                    Stream strm;
                    StreamsDerived$frame29 staticLink;
                    final ModuleMethod lambda$Fn51;
                    final ModuleMethod lambda$Fn52;
                    final ModuleMethod lambda$Fn53;
                    
                    public StreamsDerived$frame30() {
                        this.lambda$Fn52 = new ModuleMethod(this, 47, null, 0);
                        this.lambda$Fn53 = new ModuleMethod(this, 48, null, 0);
                        this.lambda$Fn51 = new ModuleMethod(this, 49, null, 0);
                    }
                    
                    Object lambda67() {
                        return StreamsPrimitive.isStreamNull(this.strm) ? StreamsPrimitive.stream$Mnnull : (KawaConvert.isTrue(this.staticLink.pred$Qu.apply1(StreamsPrimitive.streamCar(this.strm))) ? new StreamPair(new StreamPromise(this.lambda$Fn52, false), new StreamPromise(this.lambda$Fn53, true)) : StreamsPrimitive.stream$Mnnull);
                    }
                    
                    Object lambda68() {
                        return StreamsPrimitive.streamCar(this.strm);
                    }
                    
                    Object lambda69() {
                        final StreamsDerived$frame29 staticLink = this.staticLink;
                        final Object streamCdr = StreamsPrimitive.streamCdr(this.strm);
                        try {
                            return staticLink.lambda66streamTakeWhile((Stream)streamCdr);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "stream-take-while", 0, streamCdr);
                        }
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 49: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 48: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 47: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(moduleMethod, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 47: {
                                return this.lambda68();
                            }
                            case 48: {
                                return this.lambda69();
                            }
                            case 49: {
                                return this.lambda67();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame30 streamsDerived$frame30 = new StreamsDerived$frame30();
                streamsDerived$frame30.staticLink = this;
                final StreamsDerived$frame30 $heapFrame = streamsDerived$frame30;
                $heapFrame.strm = strm;
                return new StreamPromise($heapFrame.lambda$Fn51, true);
            }
        }
        final StreamsDerived$frame29 $heapFrame = new StreamsDerived$frame29();
        $heapFrame.pred$Qu = isPred;
        return (Stream)$heapFrame.lambda66streamTakeWhile(strm);
    }
    
    public static Stream streamUnfold(final Procedure mapper, final Procedure isPred, final Procedure generator, final Object base) {
        public class StreamsDerived$frame31 extends ModuleBody
        {
            Procedure generator;
            Procedure mapper;
            Procedure pred$Qu;
            
            public Object lambda70streamUnfold(final Object base) {
                public class StreamsDerived$frame32 extends ModuleBody
                {
                    Object base;
                    StreamsDerived$frame31 staticLink;
                    final ModuleMethod lambda$Fn54;
                    final ModuleMethod lambda$Fn55;
                    final ModuleMethod lambda$Fn56;
                    
                    public StreamsDerived$frame32() {
                        this.lambda$Fn55 = new ModuleMethod(this, 50, null, 0);
                        this.lambda$Fn56 = new ModuleMethod(this, 51, null, 0);
                        this.lambda$Fn54 = new ModuleMethod(this, 52, null, 0);
                    }
                    
                    Object lambda71() {
                        return KawaConvert.isTrue(this.staticLink.pred$Qu.apply1(this.base)) ? new StreamPair(new StreamPromise(this.lambda$Fn55, false), new StreamPromise(this.lambda$Fn56, true)) : StreamsPrimitive.stream$Mnnull;
                    }
                    
                    Object lambda72() {
                        return this.staticLink.mapper.apply1(this.base);
                    }
                    
                    Object lambda73() {
                        return this.staticLink.lambda70streamUnfold(this.staticLink.generator.apply1(this.base));
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 52: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 51: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 50: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(moduleMethod, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 50: {
                                return this.lambda72();
                            }
                            case 51: {
                                return this.lambda73();
                            }
                            case 52: {
                                return this.lambda71();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame32 streamsDerived$frame32 = new StreamsDerived$frame32();
                streamsDerived$frame32.staticLink = this;
                final StreamsDerived$frame32 $heapFrame = streamsDerived$frame32;
                $heapFrame.base = base;
                return new StreamPromise($heapFrame.lambda$Fn54, true);
            }
        }
        final StreamsDerived$frame31 $heapFrame = new StreamsDerived$frame31();
        $heapFrame.mapper = mapper;
        $heapFrame.pred$Qu = isPred;
        $heapFrame.generator = generator;
        return (Stream)$heapFrame.lambda70streamUnfold(base);
    }
    
    public static Object streamUnfolds(final Procedure gen, final Object seed) {
        public class StreamsDerived$frame33 extends ModuleBody
        {
            public Object lambda74unfoldResultStream(final Procedure gen, final Object seed) {
                public class StreamsDerived$frame34 extends ModuleBody
                {
                    Object seed;
                    Procedure gen;
                    StreamsDerived$frame33 staticLink;
                    final ModuleMethod lambda$Fn58;
                    final ModuleMethod lambda$Fn59;
                    
                    public StreamsDerived$frame34() {
                        final ModuleMethod lambda$Fn59 = new ModuleMethod(this, 55, null, -4095);
                        lambda$Fn59.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:331");
                        this.lambda$Fn59 = lambda$Fn59;
                        this.lambda$Fn58 = new ModuleMethod(this, 56, null, 0);
                    }
                    
                    Object lambda77() {
                        return ApplyWithValues.applyWithValues.apply2(this.gen.apply1(this.seed), this.lambda$Fn59);
                    }
                    
                    StreamPair lambda78$V(final Object next, final Object[] argsArray) {
                        public class StreamsDerived$frame35 extends ModuleBody
                        {
                            Object next;
                            LList results;
                            StreamsDerived$frame34 staticLink;
                            final ModuleMethod lambda$Fn60;
                            final ModuleMethod lambda$Fn61;
                            
                            public StreamsDerived$frame35() {
                                this.lambda$Fn60 = new ModuleMethod(this, 53, null, 0);
                                this.lambda$Fn61 = new ModuleMethod(this, 54, null, 0);
                            }
                            
                            LList lambda79() {
                                return this.results;
                            }
                            
                            Object lambda80() {
                                return this.staticLink.staticLink.lambda74unfoldResultStream(this.staticLink.gen, this.next);
                            }
                            
                            @Override
                            public int match0(final ModuleMethod proc, final CallContext ctx) {
                                switch (proc.selector) {
                                    case 54: {
                                        ctx.proc = proc;
                                        return ctx.pc = 0;
                                    }
                                    case 53: {
                                        ctx.proc = proc;
                                        return ctx.pc = 0;
                                    }
                                    default: {
                                        return super.match0(proc, ctx);
                                    }
                                }
                            }
                            
                            @Override
                            public void apply(final CallContext callContext) {
                                final int pc = callContext.pc;
                                ModuleMethod.applyError();
                            }
                            
                            @Override
                            public Object apply0(final ModuleMethod method) {
                                switch (method.selector) {
                                    case 53: {
                                        return this.lambda79();
                                    }
                                    case 54: {
                                        return this.lambda80();
                                    }
                                    default: {
                                        return super.apply0(method);
                                    }
                                }
                            }
                        }
                        final StreamsDerived$frame35 streamsDerived$frame35 = new StreamsDerived$frame35();
                        streamsDerived$frame35.staticLink = this;
                        final StreamsDerived$frame35 $heapFrame = streamsDerived$frame35;
                        $heapFrame.next = next;
                        $heapFrame.results = LList.makeList(argsArray, 0);
                        return new StreamPair(new StreamPromise($heapFrame.lambda$Fn60, false), new StreamPromise($heapFrame.lambda$Fn61, true));
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        if (moduleMethod.selector == 56) {
                            ctx.proc = moduleMethod;
                            return ctx.pc = 0;
                        }
                        return super.match0(moduleMethod, ctx);
                    }
                    
                    @Override
                    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
                        if (moduleMethod.selector == 55) {
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
                    public Object apply0(final ModuleMethod method) {
                        if (method.selector == 56) {
                            return this.lambda77();
                        }
                        return super.apply0(method);
                    }
                    
                    @Override
                    public Object applyN(final ModuleMethod method, final Object[] args) {
                        if (method.selector == 55) {
                            final Object next = args[0];
                            int n = args.length - 1;
                            final Object[] argsArray = new Object[n];
                            while (--n >= 0) {
                                argsArray[n] = args[n + 1];
                            }
                            return this.lambda78$V(next, argsArray);
                        }
                        return super.applyN(method, args);
                    }
                }
                final StreamsDerived$frame34 streamsDerived$frame34 = new StreamsDerived$frame34();
                streamsDerived$frame34.staticLink = this;
                final StreamsDerived$frame34 $heapFrame = streamsDerived$frame34;
                $heapFrame.gen = gen;
                $heapFrame.seed = seed;
                return new StreamPromise($heapFrame.lambda$Fn58, true);
            }
            
            static int lambda75$V(final Object[] argsArray) {
                final LList vs = LList.makeList(argsArray, 0);
                return vs.size() - 1;
            }
            
            public Object lambda76resultStream$To$OutputStream(final Stream resultStream, final IntNum i) {
                public class StreamsDerived$frame36 extends ModuleBody
                {
                    IntNum i;
                    Stream result$Mnstream;
                    StreamsDerived$frame33 staticLink;
                    final ModuleMethod lambda$Fn62;
                    
                    public StreamsDerived$frame36() {
                        this.lambda$Fn62 = new ModuleMethod(this, 59, null, 0);
                    }
                    
                    Object lambda81() {
                        public class StreamsDerived$frame37 extends ModuleBody
                        {
                            Object result;
                            StreamsDerived$frame36 staticLink;
                            final ModuleMethod lambda$Fn63;
                            final ModuleMethod lambda$Fn64;
                            
                            public StreamsDerived$frame37() {
                                this.lambda$Fn63 = new ModuleMethod(this, 57, null, 0);
                                this.lambda$Fn64 = new ModuleMethod(this, 58, null, 0);
                            }
                            
                            Object lambda82() {
                                final Object force = Promise.force(this.result, Pair.class);
                                try {
                                    return lists.car((Pair)force);
                                }
                                catch (ClassCastException ex) {
                                    throw new WrongType(ex, "car", 1, force);
                                }
                            }
                            
                            Object lambda83() {
                                final StreamsDerived$frame33 staticLink = this.staticLink.staticLink;
                                final Object streamCdr = StreamsPrimitive.streamCdr(this.staticLink.result$Mnstream);
                                try {
                                    return staticLink.lambda76resultStream$To$OutputStream((Stream)streamCdr, this.staticLink.i);
                                }
                                catch (ClassCastException ex) {
                                    throw new WrongType(ex, "result-stream->output-stream", 0, streamCdr);
                                }
                            }
                            
                            @Override
                            public int match0(final ModuleMethod proc, final CallContext ctx) {
                                switch (proc.selector) {
                                    case 58: {
                                        ctx.proc = proc;
                                        return ctx.pc = 0;
                                    }
                                    case 57: {
                                        ctx.proc = proc;
                                        return ctx.pc = 0;
                                    }
                                    default: {
                                        return super.match0(proc, ctx);
                                    }
                                }
                            }
                            
                            @Override
                            public void apply(final CallContext callContext) {
                                final int pc = callContext.pc;
                                ModuleMethod.applyError();
                            }
                            
                            @Override
                            public Object apply0(final ModuleMethod method) {
                                switch (method.selector) {
                                    case 57: {
                                        return this.lambda82();
                                    }
                                    case 58: {
                                        return this.lambda83();
                                    }
                                    default: {
                                        return super.apply0(method);
                                    }
                                }
                            }
                        }
                        final StreamsDerived$frame37 streamsDerived$frame37 = new StreamsDerived$frame37();
                        streamsDerived$frame37.staticLink = this;
                        final StreamsDerived$frame37 $heapFrame = streamsDerived$frame37;
                        $heapFrame.result = lists.listRef(StreamsPrimitive.streamCar(this.result$Mnstream), this.i.intValue() - 1);
                        if (lists.isPair($heapFrame.result)) {
                            return new StreamPair(new StreamPromise($heapFrame.lambda$Fn63, false), new StreamPromise($heapFrame.lambda$Fn64, true));
                        }
                        Label_0117: {
                            if (KawaConvert.isTrue($heapFrame.result)) {
                                break Label_0117;
                            }
                            final StreamsDerived$frame33 staticLink = this.staticLink;
                            final Object streamCdr = StreamsPrimitive.streamCdr(this.result$Mnstream);
                            try {
                                return staticLink.lambda76resultStream$To$OutputStream((Stream)streamCdr, this.i);
                                o = StreamsPrimitive.stream$Mnnull;
                                return o;
                                Label_0133: {
                                    exceptions.error(StreamsDerived.Lit11, "can't happen");
                                }
                                throw Special.reachedUnexpected;
                                // iftrue(Label_0133:, !lists.isNull($heapFrame.result))
                                return StreamsPrimitive.stream$Mnnull;
                            }
                            catch (ClassCastException ex) {
                                throw new WrongType(ex, "result-stream->output-stream", 0, streamCdr);
                            }
                        }
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        if (moduleMethod.selector == 59) {
                            ctx.proc = moduleMethod;
                            return ctx.pc = 0;
                        }
                        return super.match0(moduleMethod, ctx);
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        if (method.selector == 59) {
                            return this.lambda81();
                        }
                        return super.apply0(method);
                    }
                }
                final StreamsDerived$frame36 streamsDerived$frame36 = new StreamsDerived$frame36();
                streamsDerived$frame36.staticLink = this;
                final StreamsDerived$frame36 $heapFrame = streamsDerived$frame36;
                $heapFrame.result$Mnstream = resultStream;
                $heapFrame.i = i;
                return new StreamPromise($heapFrame.lambda$Fn62, true);
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/slib/StreamsDerived$frame33.<init>:()V
        //     7: astore_2        /* $heapFrame */
        //     8: aload_2         /* $heapFrame */
        //     9: aload_0         /* gen */
        //    10: aload_1         /* seed */
        //    11: invokevirtual   gnu/kawa/slib/StreamsDerived$frame33.lambda74unfoldResultStream:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //    14: astore_3        /* result$Mnstream */
        //    15: aload_0         /* gen */
        //    16: aload_1         /* seed */
        //    17: astore          5
        //    19: astore          gen
        //    21: getstatic       gnu/kawa/functions/ApplyWithValues.applyWithValues:Lgnu/kawa/functions/ApplyWithValues;
        //    24: aload           gen
        //    26: aload           seed
        //    28: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    31: getstatic       gnu/kawa/slib/StreamsDerived.lambda$Fn57:Lgnu/expr/ModuleMethod;
        //    34: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    37: ldc             Lgnu/math/IntNum;.class
        //    39: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    42: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    45: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    48: astore          5
        //    50: astore          i
        //    52: aload           i
        //    54: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    57: ifeq            74
        //    60: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //    63: getstatic       kawa/lib/misc.values:Lgnu/expr/ModuleMethod;
        //    66: aload           outputs
        //    68: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    71: goto            101
        //    74: aload           i
        //    76: iconst_m1      
        //    77: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    80: aload_2         /* $heapFrame */
        //    81: aload_3         /* result$Mnstream */
        //    82: dup            
        //    83: astore          6
        //    85: checkcast       Lgnu/kawa/slib/Stream;
        //    88: aload           i
        //    90: invokevirtual   gnu/kawa/slib/StreamsDerived$frame33.lambda76resultStream$To$OutputStream:(Lgnu/kawa/slib/Stream;Lgnu/math/IntNum;)Ljava/lang/Object;
        //    93: aload           outputs
        //    95: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    98: goto            48
        //   101: areturn        
        //   102: new             Lgnu/mapping/WrongType;
        //   105: dup_x1         
        //   106: swap           
        //   107: ldc_w           "result-stream->output-stream"
        //   110: iconst_0       
        //   111: aload           6
        //   113: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   116: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  85     88     102    117    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    
    public static Stream streamZip$V(final Object[] argsArray) {
        public class StreamsDerived$frame38 extends ModuleBody
        {
            static boolean lambda84(final Object x) {
                return !StreamsPrimitive.isStream(x);
            }
            
            public Object lambda85streamZip(final LList strms) {
                public class StreamsDerived$frame39 extends ModuleBody
                {
                    LList strms;
                    StreamsDerived$frame38 staticLink;
                    final ModuleMethod lambda$Fn66;
                    final ModuleMethod lambda$Fn67;
                    final ModuleMethod lambda$Fn68;
                    
                    public StreamsDerived$frame39() {
                        this.lambda$Fn67 = new ModuleMethod(this, 60, null, 0);
                        this.lambda$Fn68 = new ModuleMethod(this, 61, null, 0);
                        this.lambda$Fn66 = new ModuleMethod(this, 62, null, 0);
                    }
                    
                    Object lambda86() {
                        return KawaConvert.isTrue(srfi1.any$V(StreamsPrimitive.stream$Mnnull$Qu, this.strms, new Object[0])) ? StreamsPrimitive.stream$Mnnull : new StreamPair(new StreamPromise(this.lambda$Fn67, false), new StreamPromise(this.lambda$Fn68, true));
                    }
                    
                    LList lambda87() {
                        Object arg = this.strms;
                        LList empty = LList.Empty;
                        Pair pair = null;
                        while (arg != LList.Empty) {
                            final Pair pair2 = (Pair)Promise.force(arg, Pair.class);
                            final Pair cdr = new Pair(StreamsPrimitive.streamCar(pair2.getCar()), LList.Empty);
                            if (pair == null) {
                                empty = cdr;
                            }
                            else {
                                pair.setCdr(cdr);
                            }
                            pair = cdr;
                            arg = pair2.getCdr();
                        }
                        return empty;
                    }
                    
                    Object lambda88() {
                        final StreamsDerived$frame38 staticLink = this.staticLink;
                        Object arg = this.strms;
                        LList empty = LList.Empty;
                        Pair pair = null;
                        while (arg != LList.Empty) {
                            final Pair pair2 = (Pair)Promise.force(arg, Pair.class);
                            final Pair cdr = new Pair(StreamsPrimitive.streamCdr(pair2.getCar()), LList.Empty);
                            if (pair == null) {
                                empty = cdr;
                            }
                            else {
                                pair.setCdr(cdr);
                            }
                            pair = cdr;
                            arg = pair2.getCdr();
                        }
                        return staticLink.lambda85streamZip(empty);
                    }
                    
                    @Override
                    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                        switch (moduleMethod.selector) {
                            case 62: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 61: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            case 60: {
                                ctx.proc = moduleMethod;
                                return ctx.pc = 0;
                            }
                            default: {
                                return super.match0(moduleMethod, ctx);
                            }
                        }
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply0(final ModuleMethod method) {
                        switch (method.selector) {
                            case 60: {
                                return this.lambda87();
                            }
                            case 61: {
                                return this.lambda88();
                            }
                            case 62: {
                                return this.lambda86();
                            }
                            default: {
                                return super.apply0(method);
                            }
                        }
                    }
                }
                final StreamsDerived$frame39 streamsDerived$frame39 = new StreamsDerived$frame39();
                streamsDerived$frame39.staticLink = this;
                final StreamsDerived$frame39 $heapFrame = streamsDerived$frame39;
                $heapFrame.strms = strms;
                return new StreamPromise($heapFrame.lambda$Fn66, true);
            }
        }
        final StreamsDerived$frame38 $heapFrame = new StreamsDerived$frame38();
        final LList strms = LList.makeList(argsArray, 0);
        if (lists.isNull(strms)) {
            exceptions.error(StreamsDerived.Lit12, "no stream arguments");
            throw Special.reachedUnexpected;
        }
        if (KawaConvert.isTrue(srfi1.any$V(StreamsDerived.lambda$Fn65, strms, new Object[0]))) {
            exceptions.error(StreamsDerived.Lit12, "non-stream argument");
            throw Special.reachedUnexpected;
        }
        return (Stream)$heapFrame.lambda85streamZip(strms);
    }
    
    static {
        Lit74 = Symbol.valueOf("stream-lambda");
        Lit73 = Symbol.valueOf("stream-cons");
        Lit72 = Symbol.valueOf("stream-null");
        Lit71 = PairWithPosition.make(Symbol.valueOf("quote"), PairWithPosition.make(Lit27 = Symbol.valueOf("stream-match"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847911), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847911);
        Lit70 = Symbol.valueOf("error");
        Lit69 = Symbol.valueOf("list");
        Lit68 = Symbol.valueOf("stream-null?");
        Lit67 = Symbol.valueOf("stream-pair?");
        Lit66 = Symbol.valueOf("and");
        Lit65 = Symbol.valueOf("temp");
        Lit64 = Symbol.valueOf("stream-cdr");
        Lit63 = Symbol.valueOf("stream-car");
        (Lit62 = new Object[] { null })[0] = (Lit59 = Symbol.valueOf("let"));
        Lit61 = Symbol.valueOf("if");
        Lit60 = new Object[0];
        Lit58 = Symbol.valueOf("is");
        Lit57 = Symbol.valueOf("loop");
        Lit56 = PairWithPosition.make(Lit55 = Symbol.valueOf("strm"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1032218);
        Lit54 = Symbol.valueOf("in");
        Lit53 = Symbol.valueOf("stream-unfold");
        Lit52 = Symbol.valueOf("stream-take-while");
        Lit51 = Symbol.valueOf("stream-scan");
        Lit50 = Symbol.valueOf("stream-reverse");
        Lit49 = Symbol.valueOf("stream-range");
        Lit48 = new SyntaxRules(new Object[] { StreamsDerived.Lit54, StreamsDerived.Lit58 }, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", StreamsDerived.Lit60, 2, "StreamsDerived.scm:248"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[] { StreamsDerived.Lit73 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f<\f\u0017\f\u0002\f\u001f\b\r' \b\b", new Object[] { StreamsDerived.Lit54 }, 5, "StreamsDerived.scm:250"), "\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\u0011\u0018\f1\b\u0011\u0018\u0014\b\u001b\b\u0011\u0018\u001c\u0011\u0018$\t\u000b\b\u0011\u0018,)\b\t\u0013\u00184\b\u0011\u0018<\t\u0003\u0011\u0018D\b%#", new Object[] { Lit25 = Symbol.valueOf("stream-let"), StreamsDerived.Lit57, StreamsDerived.Lit55, StreamsDerived.Lit61, PairWithPosition.make(StreamsDerived.Lit68, StreamsDerived.Lit56, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1032204), StreamsDerived.Lit59, PairWithPosition.make(PairWithPosition.make(StreamsDerived.Lit63, StreamsDerived.Lit56, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1040407), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1040407), Lit47 = Symbol.valueOf("stream-of-aux"), PairWithPosition.make(StreamsDerived.Lit57, PairWithPosition.make(PairWithPosition.make(StreamsDerived.Lit64, StreamsDerived.Lit56, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1044520), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1044520), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 1044514) }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f<\f\u0017\f\u0002\f\u001f\b\r' \b\b", new Object[] { StreamsDerived.Lit58 }, 5, "StreamsDerived.scm:256"), "\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004)\b\t\u0013\b\u001b\b\u0011\u0018\f\t\u0003\t\u000b\b%#", new Object[] { StreamsDerived.Lit59, StreamsDerived.Lit47 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\r\u001f\u0018\b\b", StreamsDerived.Lit60, 4, "StreamsDerived.scm:258"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u0013Q\u0011\u0018\f\t\u0003\t\u000b\b\u001d\u001b\b\u000b", new Object[] { StreamsDerived.Lit61, StreamsDerived.Lit47 }, 1) }, 5, StreamsDerived.Lit47);
        Lit46 = new SyntaxRules(StreamsDerived.Lit60, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", StreamsDerived.Lit60, 2, "StreamsDerived.scm:243"), "\u0001\u0003", "\u0011\u0018\u0004\t\u0003\u0011\u0018\f\b\r\u000b", new Object[] { StreamsDerived.Lit47, StreamsDerived.Lit72 }, 1) }, 2, Lit45 = Symbol.valueOf("stream-of"));
        Lit44 = new SyntaxTemplate("", "\u0018\u0004", new Object[] { Symbol.valueOf("_") }, 0);
        Lit43 = new SyntaxTemplate("\u0001\u0001\u0003\u0001", "\u0011\u0018\u0004A!\t\u000b\b\u0003\b\u0015\u0013\b\u001b", StreamsDerived.Lit62, 1);
        Lit42 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u001f\b", StreamsDerived.Lit60, 4, "StreamsDerived.scm:238");
        Lit41 = new SyntaxTemplate("\u0001\u0001\u0003\u0001", "\u0011\u0018\u0004\u0019\b\u0015\u0013\b\u001b", StreamsDerived.Lit62, 1);
        Lit40 = new SyntaxTemplate("\u0001\u0001\u0003\u0001", "\u000b", StreamsDerived.Lit60, 0);
        Lit39 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u001f\b", StreamsDerived.Lit60, 4, "StreamsDerived.scm:235");
        Lit38 = new SyntaxTemplate("\u0001\u0001\u0000\u0003\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0099I\u0011\u0018\u001c\b\u0011\u0018$\b\u0003\b\t\u0003\b\u0011\u0018,\b\u0003\b\u0011\u00184\t\u0003\t\u0012A!\t\u000b\u0018<\b\u001d\u001b\b#", new Object[] { StreamsDerived.Lit66, StreamsDerived.Lit67, StreamsDerived.Lit59, StreamsDerived.Lit65, StreamsDerived.Lit63, StreamsDerived.Lit64, Lit31 = Symbol.valueOf("stream-match-pattern"), PairWithPosition.make(StreamsDerived.Lit65, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 958525) }, 1);
        Lit37 = new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\u0013,\r\u001f\u0018\b\b\f'\b", StreamsDerived.Lit60, 5, "StreamsDerived.scm:231");
        Lit36 = new SyntaxTemplate("\u0001\u0001\u0000\u0003\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014I\b\t\u0003\b\u0011\u0018\u001c\b\u0003\b\u0011\u0018$\t\u0003\t\u0012\u0019\b\u001d\u001b\b#", new Object[] { StreamsDerived.Lit66, StreamsDerived.Lit67, StreamsDerived.Lit59, StreamsDerived.Lit64, StreamsDerived.Lit31 }, 1);
        Lit35 = new SyntaxTemplate("\u0001\u0001\u0000\u0003\u0001", "\u000b", StreamsDerived.Lit60, 0);
        Lit34 = new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\u0013,\r\u001f\u0018\b\b\f'\b", StreamsDerived.Lit60, 5, "StreamsDerived.scm:226");
        Lit33 = new SyntaxTemplate("\u0001\u0003\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0019\b\r\u000b\b\u0013", new Object[] { StreamsDerived.Lit66, StreamsDerived.Lit68, StreamsDerived.Lit59 }, 1);
        Lit32 = new SyntaxPattern("\f\u0018\f\u0007\f\b,\r\u000f\b\b\b\f\u0017\b", StreamsDerived.Lit60, 3, "StreamsDerived.scm:224");
        Lit30 = new SyntaxRules(StreamsDerived.Lit60, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0017\f\u001f\b\b", StreamsDerived.Lit60, 4, "StreamsDerived.scm:213"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\t\u0010\b\u0011\u0018\f\t\u0013\b\u0011\u0018\u0014\b\u001b", new Object[] { StreamsDerived.Lit31, StreamsDerived.Lit66, StreamsDerived.Lit69 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007,\f\u000f\f\u0017\b\b", StreamsDerived.Lit60, 3, "StreamsDerived.scm:215"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\t\u0010\b\u0011\u0018\f\b\u0013", new Object[] { StreamsDerived.Lit31, StreamsDerived.Lit69 }, 0) }, 4, Lit29 = Symbol.valueOf("stream-match-test"));
        Lit28 = new SyntaxRules(StreamsDerived.Lit60, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", StreamsDerived.Lit60, 2, "StreamsDerived.scm:204"), "\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0011\u0018\u001ca\rA\u0011\u0018$\u0011\u0018\f\b\u000b\u0018,\u00184", new Object[] { StreamsDerived.Lit59, StreamsDerived.Lit55, Symbol.valueOf("cond"), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("not"), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("stream?"), StreamsDerived.Lit56, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847887), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847887), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847882), PairWithPosition.make(PairWithPosition.make(StreamsDerived.Lit70, PairWithPosition.make(StreamsDerived.Lit71, PairWithPosition.make("non-stream argument", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847924), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847910), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847903), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847903), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 847881), StreamsDerived.Lit29, PairWithPosition.make(Symbol.valueOf("=>"), PairWithPosition.make(Symbol.valueOf("car"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 852013), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 852010), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("else"), PairWithPosition.make(PairWithPosition.make(StreamsDerived.Lit70, PairWithPosition.make(StreamsDerived.Lit71, PairWithPosition.make("pattern failure", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856100), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856086), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856079), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856079), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856073), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm", 856073) }, 1) }, 2, StreamsDerived.Lit27);
        Lit26 = new SyntaxRules(StreamsDerived.Lit60, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L-\f\u000f\f\u0017\b\b\u0010\b\f\u001f\r' \b\b", StreamsDerived.Lit60, 5, "StreamsDerived.scm:187"), "\u0001\u0003\u0003\u0001\u0003", "±\u0011\u0018\u0004\u0081\b\t\u0003\b\u0011\u0018\f\u0019\b\r\u000b\t\u001b\b%#\b\u0003\b\u0015\u0013", new Object[] { Symbol.valueOf("letrec"), StreamsDerived.Lit74 }, 1) }, 5, StreamsDerived.Lit25);
        Lit24 = Symbol.valueOf("stream-length");
        Lit23 = Symbol.valueOf("stream-iterate");
        Lit22 = Symbol.valueOf("stream-from");
        Lit21 = Symbol.valueOf("stream-fold");
        Lit20 = Symbol.valueOf("stream-filter");
        Lit19 = Symbol.valueOf("stream-drop-while");
        Lit18 = new SyntaxRules(StreamsDerived.Lit60, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\b", StreamsDerived.Lit60, 0, "StreamsDerived.scm:78"), "", "\u0018\u0004", new Object[] { StreamsDerived.Lit72 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", StreamsDerived.Lit60, 2, "StreamsDerived.scm:79"), "\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\b\r\u000b", new Object[] { StreamsDerived.Lit73, Lit17 = Symbol.valueOf("stream") }, 1) }, 2, StreamsDerived.Lit17);
        Lit16 = Symbol.valueOf("port->stream");
        Lit15 = Symbol.valueOf("list->stream");
        Lit14 = new SyntaxRules(StreamsDerived.Lit60, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\f\u0017\r\u001f\u0018\b\b", StreamsDerived.Lit60, 4, "StreamsDerived.scm:56"), "\u0001\u0000\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\t\n\t\u0013\b\u001d\u001b", new Object[] { Symbol.valueOf("define"), StreamsDerived.Lit74 }, 1) }, 4, Lit13 = Symbol.valueOf("define-stream"));
        Lit12 = Symbol.valueOf("stream-zip");
        Lit11 = Symbol.valueOf("stream-unfolds");
        Lit10 = Symbol.valueOf("stream-take");
        Lit9 = Symbol.valueOf("stream-ref");
        Lit8 = Symbol.valueOf("stream-map");
        Lit7 = IntNum.valueOf(0);
        Lit6 = IntNum.valueOf(1);
        Lit5 = Symbol.valueOf("stream-for-each");
        Lit4 = Symbol.valueOf("stream-drop");
        Lit3 = Symbol.valueOf("stream-concat");
        Lit2 = Symbol.valueOf("stream-append");
        Lit1 = IntNum.valueOf(-1);
        Lit0 = Symbol.valueOf("stream->list");
        StreamsDerived.$instance = new StreamsDerived();
        stream$Mnnull = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnnull");
        stream$Mncons = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mncons");
        stream$Qu = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Qu");
        stream$Mnnull$Qu = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnnull$Qu");
        stream$Mnpair$Qu = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnpair$Qu");
        stream$Mncar = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mncar");
        stream$Mncdr = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mncdr");
        stream$Mnlambda = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnlambda");
        define$Mnstream = Macro.make(StreamsDerived.Lit13, StreamsDerived.Lit14, "gnu.kawa.slib.StreamsDerived");
        final StreamsDerived $instance = StreamsDerived.$instance;
        list$Mn$Grstream = new ModuleMethod($instance, 63, StreamsDerived.Lit15, 4097);
        port$Mn$Grstream = new ModuleMethod($instance, 64, StreamsDerived.Lit16, 4096);
        stream = Macro.make(StreamsDerived.Lit17, StreamsDerived.Lit18, "gnu.kawa.slib.StreamsDerived");
        stream$Mn$Grlist = new ModuleMethod($instance, 66, StreamsDerived.Lit0, -4096);
        final ModuleMethod lambda$Fn66 = new ModuleMethod($instance, 67, null, 4097);
        lambda$Fn66.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:100");
        lambda$Fn7 = lambda$Fn66;
        stream$Mnappend = new ModuleMethod($instance, 68, StreamsDerived.Lit2, -4096);
        stream$Mnconcat = new ModuleMethod($instance, 69, StreamsDerived.Lit3, 4097);
        final ModuleMethod stream$Mnconstant2 = new ModuleMethod($instance, 70, "stream-constant", -4096);
        stream$Mnconstant2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:119");
        stream$Mnconstant = stream$Mnconstant2;
        stream$Mndrop = new ModuleMethod($instance, 71, StreamsDerived.Lit4, 8194);
        stream$Mndrop$Mnwhile = new ModuleMethod($instance, 72, StreamsDerived.Lit19, 8194);
        stream$Mnfilter = new ModuleMethod($instance, 73, StreamsDerived.Lit20, 8194);
        stream$Mnfold = new ModuleMethod($instance, 74, StreamsDerived.Lit21, 12291);
        final ModuleMethod lambda$Fn67 = new ModuleMethod($instance, 75, null, 4097);
        lambda$Fn67.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:163");
        lambda$Fn26 = lambda$Fn67;
        stream$Mnfor$Mneach = new ModuleMethod($instance, 76, StreamsDerived.Lit5, -4095);
        stream$Mnfrom = new ModuleMethod($instance, 77, StreamsDerived.Lit22, 8193);
        stream$Mniterate = new ModuleMethod($instance, 79, StreamsDerived.Lit23, 8194);
        stream$Mnlength = new ModuleMethod($instance, 80, StreamsDerived.Lit24, 4097);
        stream$Mnlet = Macro.make(StreamsDerived.Lit25, StreamsDerived.Lit26, "gnu.kawa.slib.StreamsDerived");
        final ModuleMethod lambda$Fn68 = new ModuleMethod($instance, 81, null, 4097);
        lambda$Fn68.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:198");
        lambda$Fn33 = lambda$Fn68;
        stream$Mnmap = new ModuleMethod($instance, 82, StreamsDerived.Lit8, -4095);
        stream$Mnmatch = Macro.make(StreamsDerived.Lit27, StreamsDerived.Lit28, "gnu.kawa.slib.StreamsDerived");
        $Prvt$stream$Mnmatch$Mntest = Macro.make(StreamsDerived.Lit29, StreamsDerived.Lit30, "gnu.kawa.slib.StreamsDerived");
        final SimpleSymbol lit31 = StreamsDerived.Lit31;
        final ModuleMethod expander = new ModuleMethod(StreamsDerived.$instance, 83, null, 4097);
        expander.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:219");
        $Prvt$stream$Mnmatch$Mnpattern = Macro.make(lit31, expander, "gnu.kawa.slib.StreamsDerived");
        stream$Mnof = Macro.make(StreamsDerived.Lit45, StreamsDerived.Lit46, "gnu.kawa.slib.StreamsDerived");
        $Prvt$stream$Mnof$Mnaux = Macro.make(StreamsDerived.Lit47, StreamsDerived.Lit48, "gnu.kawa.slib.StreamsDerived");
        stream$Mnrange = new ModuleMethod($instance, 84, StreamsDerived.Lit49, -4094);
        stream$Mnref = new ModuleMethod($instance, 85, StreamsDerived.Lit9, 8194);
        stream$Mnreverse = new ModuleMethod($instance, 86, StreamsDerived.Lit50, 4097);
        lambda$Fn45 = new ModuleMethod($instance, 87, null, 0);
        stream$Mnscan = new ModuleMethod($instance, 88, StreamsDerived.Lit51, 12291);
        stream$Mntake = new ModuleMethod($instance, 89, StreamsDerived.Lit10, 8194);
        stream$Mntake$Mnwhile = new ModuleMethod($instance, 90, StreamsDerived.Lit52, 8194);
        stream$Mnunfold = new ModuleMethod($instance, 91, StreamsDerived.Lit53, 16388);
        final ModuleMethod lambda$Fn69 = new ModuleMethod($instance, 92, null, -4096);
        lambda$Fn69.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:326");
        lambda$Fn57 = lambda$Fn69;
        stream$Mnunfolds = new ModuleMethod($instance, 93, StreamsDerived.Lit11, 8194);
        final ModuleMethod lambda$Fn70 = new ModuleMethod($instance, 94, null, 4097);
        lambda$Fn70.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsDerived.scm:358");
        lambda$Fn65 = lambda$Fn70;
        stream$Mnzip = new ModuleMethod($instance, 95, StreamsDerived.Lit12, -4096);
        $runBody$();
    }
    
    public StreamsDerived() {
        ModuleInfo.register(this);
    }
    
    static Object lambda89(final Object x) {
        final Object[] allocVars = SyntaxPattern.allocVars(5, null);
        return StreamsDerived.Lit32.match(x, allocVars, 0) ? StreamsDerived.Lit33.execute(allocVars, TemplateScope.make()) : ((StreamsDerived.Lit34.match(x, allocVars, 0) && lambda90isWildcard(StreamsDerived.Lit35.execute(allocVars, TemplateScope.make()))) ? StreamsDerived.Lit36.execute(allocVars, TemplateScope.make()) : (StreamsDerived.Lit37.match(x, allocVars, 0) ? StreamsDerived.Lit38.execute(allocVars, TemplateScope.make()) : ((StreamsDerived.Lit39.match(x, allocVars, 0) && lambda90isWildcard(StreamsDerived.Lit40.execute(allocVars, TemplateScope.make()))) ? StreamsDerived.Lit41.execute(allocVars, TemplateScope.make()) : (StreamsDerived.Lit42.match(x, allocVars, 0) ? StreamsDerived.Lit43.execute(allocVars, TemplateScope.make()) : syntax_case.error("syntax-case", x)))));
    }
    
    public static boolean lambda90isWildcard(final Object x) {
        return std_syntax.isIdentifier(x) && std_syntax.isFreeIdentifier$Eq(x, StreamsDerived.Lit44.execute(null, TemplateScope.make()));
    }
    
    @Override
    public int match0(final ModuleMethod proc, final CallContext ctx) {
        switch (proc.selector) {
            case 87: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 64: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            default: {
                return super.match0(proc, ctx);
            }
        }
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 83: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 94: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 86: {
                if (!(o instanceof Stream)) {
                    return -786431;
                }
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 81: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 80: {
                if (!(o instanceof Stream)) {
                    return -786431;
                }
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 77: {
                final Object force = Promise.force(o, Numeric.class);
                if (Numeric.asNumericOrNull(force) != null) {
                    ctx.value1 = force;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 75: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 69: {
                if (!(o instanceof Stream)) {
                    return -786431;
                }
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 67: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 64: {
                final Object force2 = Promise.force(o, InPort.class);
                if (!(force2 instanceof InPort)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 63: {
                final Object force3 = Promise.force(o, LList.class);
                if (force3 instanceof LList) {
                    ctx.value1 = force3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 93: {
                final Object force = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force) != null) {
                    ctx.value1 = force;
                    ctx.value2 = o2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 90: {
                final Object force2 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force2) == null) {
                    return -786431;
                }
                ctx.value1 = force2;
                if (!(o2 instanceof Stream)) {
                    return -786430;
                }
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 89: {
                final Object force3 = Promise.force(o, IntNum.class);
                if (IntNum.asIntNumOrNull(force3) == null) {
                    return -786431;
                }
                ctx.value1 = force3;
                if (!(o2 instanceof Stream)) {
                    return -786430;
                }
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 85: {
                if (!(o instanceof Stream)) {
                    return -786431;
                }
                ctx.value1 = o;
                final Object force4 = Promise.force(o2, IntNum.class);
                if (IntNum.asIntNumOrNull(force4) != null) {
                    ctx.value2 = force4;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 79: {
                final Object force5 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force5) != null) {
                    ctx.value1 = force5;
                    ctx.value2 = o2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 77: {
                final Object force6 = Promise.force(o, Numeric.class);
                if (Numeric.asNumericOrNull(force6) == null) {
                    return -786431;
                }
                ctx.value1 = force6;
                final Object force7 = Promise.force(o2, Numeric.class);
                if (Numeric.asNumericOrNull(force7) != null) {
                    ctx.value2 = force7;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 73: {
                final Object force8 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force8) == null) {
                    return -786431;
                }
                ctx.value1 = force8;
                if (!(o2 instanceof Stream)) {
                    return -786430;
                }
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 72: {
                final Object force9 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force9) == null) {
                    return -786431;
                }
                ctx.value1 = force9;
                if (!(o2 instanceof Stream)) {
                    return -786430;
                }
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 71: {
                final Object force10 = Promise.force(o, IntNum.class);
                if (IntNum.asIntNumOrNull(force10) == null) {
                    return -786431;
                }
                ctx.value1 = force10;
                if (!(o2 instanceof Stream)) {
                    return -786430;
                }
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            default: {
                return super.match2(moduleMethod, o, o2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        switch (proc.selector) {
            case 88: {
                final Object force = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force) == null) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.value2 = arg2;
                if (!(arg3 instanceof Stream)) {
                    return -786429;
                }
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 74: {
                final Object force2 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force2) == null) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.value2 = arg2;
                if (!(arg3 instanceof Stream)) {
                    return -786429;
                }
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            default: {
                return super.match3(proc, arg1, arg2, arg3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        if (moduleMethod.selector != 91) {
            return super.match4(moduleMethod, o, o2, o3, o4, ctx);
        }
        final Object force = Promise.force(o, Procedure.class);
        if (LangObjType.coerceToProcedureOrNull(force) == null) {
            return -786431;
        }
        ctx.value1 = force;
        final Object force2 = Promise.force(o2, Procedure.class);
        if (LangObjType.coerceToProcedureOrNull(force2) == null) {
            return -786430;
        }
        ctx.value2 = force2;
        final Object force3 = Promise.force(o3, Procedure.class);
        if (LangObjType.coerceToProcedureOrNull(force3) != null) {
            ctx.value3 = force3;
            ctx.value4 = o4;
            ctx.proc = moduleMethod;
            ctx.pc = 4;
            return 0;
        }
        return -786429;
    }
    
    @Override
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        switch (proc.selector) {
            case 95: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 92: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 84: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 82: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 76: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 70: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 68: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 66: {
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
    public Object apply0(final ModuleMethod method) {
        switch (method.selector) {
            case 64: {
                return port$To$Stream();
            }
            case 87: {
                return StreamsDerived$frame26.lambda59();
            }
            default: {
                return super.apply0(method);
            }
        }
    }
    
    @Override
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //               63: 104
        //               64: 117
        //               67: 130
        //               69: 147
        //               75: 155
        //               77: 172
        //               80: 186
        //               81: 194
        //               83: 236
        //               86: 211
        //               94: 219
        //          default: 241
        //        }
        //   104: aload_2        
        //   105: ldc             Lgnu/lists/LList;.class
        //   107: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   110: checkcast       Lgnu/lists/LList;
        //   113: invokestatic    gnu/kawa/slib/StreamsDerived.list$To$Stream:(Lgnu/lists/LList;)Lgnu/kawa/slib/Stream;
        //   116: areturn        
        //   117: aload_2        
        //   118: ldc             Lgnu/kawa/io/InPort;.class
        //   120: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   123: checkcast       Lgnu/kawa/io/InPort;
        //   126: invokestatic    gnu/kawa/slib/StreamsDerived.port$To$Stream:(Lgnu/kawa/io/InPort;)Lgnu/kawa/slib/Stream;
        //   129: areturn        
        //   130: aload_2        
        //   131: invokestatic    gnu/kawa/slib/StreamsDerived$frame4.lambda10:(Ljava/lang/Object;)Z
        //   134: ifeq            143
        //   137: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   140: goto            146
        //   143: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   146: areturn        
        //   147: aload_2        
        //   148: checkcast       Lgnu/kawa/slib/Stream;
        //   151: invokestatic    gnu/kawa/slib/StreamsDerived.streamConcat:(Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
        //   154: areturn        
        //   155: aload_2        
        //   156: invokestatic    gnu/kawa/slib/StreamsDerived.lambda34:(Ljava/lang/Object;)Z
        //   159: ifeq            168
        //   162: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   165: goto            171
        //   168: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   171: areturn        
        //   172: aload_2        
        //   173: ldc_w           Lgnu/math/Numeric;.class
        //   176: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   179: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceNumeric:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //   182: invokestatic    gnu/kawa/slib/StreamsDerived.streamFrom:(Lgnu/math/Numeric;)Lgnu/kawa/slib/Stream;
        //   185: areturn        
        //   186: aload_2        
        //   187: checkcast       Lgnu/kawa/slib/Stream;
        //   190: invokestatic    gnu/kawa/slib/StreamsDerived.streamLength:(Lgnu/kawa/slib/Stream;)Lgnu/math/IntNum;
        //   193: areturn        
        //   194: aload_2        
        //   195: invokestatic    gnu/kawa/slib/StreamsDerived$frame19.lambda43:(Ljava/lang/Object;)Z
        //   198: ifeq            207
        //   201: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   204: goto            210
        //   207: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   210: areturn        
        //   211: aload_2        
        //   212: checkcast       Lgnu/kawa/slib/Stream;
        //   215: invokestatic    gnu/kawa/slib/StreamsDerived.streamReverse:(Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
        //   218: areturn        
        //   219: aload_2        
        //   220: invokestatic    gnu/kawa/slib/StreamsDerived$frame38.lambda84:(Ljava/lang/Object;)Z
        //   223: ifeq            232
        //   226: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   229: goto            235
        //   232: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   235: areturn        
        //   236: aload_2        
        //   237: invokestatic    gnu/kawa/slib/StreamsDerived.lambda89:(Ljava/lang/Object;)Ljava/lang/Object;
        //   240: areturn        
        //   241: aload_0        
        //   242: aload_1        
        //   243: aload_2        
        //   244: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   247: areturn        
        //   248: new             Lgnu/mapping/WrongType;
        //   251: dup_x1         
        //   252: swap           
        //   253: ldc_w           "list->stream"
        //   256: iconst_1       
        //   257: aload_2        
        //   258: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   261: athrow         
        //   262: new             Lgnu/mapping/WrongType;
        //   265: dup_x1         
        //   266: swap           
        //   267: ldc_w           "port->stream"
        //   270: iconst_1       
        //   271: aload_2        
        //   272: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   275: athrow         
        //   276: new             Lgnu/mapping/WrongType;
        //   279: dup_x1         
        //   280: swap           
        //   281: ldc_w           "stream-concat"
        //   284: iconst_1       
        //   285: aload_2        
        //   286: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   289: athrow         
        //   290: new             Lgnu/mapping/WrongType;
        //   293: dup_x1         
        //   294: swap           
        //   295: ldc_w           "stream-from"
        //   298: iconst_1       
        //   299: aload_2        
        //   300: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   303: athrow         
        //   304: new             Lgnu/mapping/WrongType;
        //   307: dup_x1         
        //   308: swap           
        //   309: ldc_w           "stream-length"
        //   312: iconst_1       
        //   313: aload_2        
        //   314: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   317: athrow         
        //   318: new             Lgnu/mapping/WrongType;
        //   321: dup_x1         
        //   322: swap           
        //   323: ldc_w           "stream-reverse"
        //   326: iconst_1       
        //   327: aload_2        
        //   328: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   331: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  110    113    248    262    Ljava/lang/ClassCastException;
        //  123    126    262    276    Ljava/lang/ClassCastException;
        //  148    151    276    290    Ljava/lang/ClassCastException;
        //  179    182    290    304    Ljava/lang/ClassCastException;
        //  187    190    304    318    Ljava/lang/ClassCastException;
        //  212    215    318    332    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 117 out of bounds for length 117
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
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //               71: 88
        //               72: 105
        //               73: 123
        //               77: 141
        //               79: 165
        //               85: 180
        //               89: 197
        //               90: 214
        //               93: 232
        //          default: 247
        //        }
        //    88: aload_2        
        //    89: ldc             Lgnu/math/IntNum;.class
        //    91: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    94: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    97: aload_3        
        //    98: checkcast       Lgnu/kawa/slib/Stream;
        //   101: invokestatic    gnu/kawa/slib/StreamsDerived.streamDrop:(Lgnu/math/IntNum;Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
        //   104: areturn        
        //   105: aload_2        
        //   106: ldc_w           Lgnu/mapping/Procedure;.class
        //   109: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   112: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   115: aload_3        
        //   116: checkcast       Lgnu/kawa/slib/Stream;
        //   119: invokestatic    gnu/kawa/slib/StreamsDerived.streamDropWhile:(Lgnu/mapping/Procedure;Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
        //   122: areturn        
        //   123: aload_2        
        //   124: ldc_w           Lgnu/mapping/Procedure;.class
        //   127: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   130: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   133: aload_3        
        //   134: checkcast       Lgnu/kawa/slib/Stream;
        //   137: invokestatic    gnu/kawa/slib/StreamsDerived.streamFilter:(Lgnu/mapping/Procedure;Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
        //   140: areturn        
        //   141: aload_2        
        //   142: ldc_w           Lgnu/math/Numeric;.class
        //   145: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   148: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceNumeric:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //   151: aload_3        
        //   152: ldc_w           Lgnu/math/Numeric;.class
        //   155: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   158: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceNumeric:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //   161: invokestatic    gnu/kawa/slib/StreamsDerived.streamFrom:(Lgnu/math/Numeric;Lgnu/math/Numeric;)Lgnu/kawa/slib/Stream;
        //   164: areturn        
        //   165: aload_2        
        //   166: ldc_w           Lgnu/mapping/Procedure;.class
        //   169: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   172: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   175: aload_3        
        //   176: invokestatic    gnu/kawa/slib/StreamsDerived.streamIterate:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Lgnu/kawa/slib/Stream;
        //   179: areturn        
        //   180: aload_2        
        //   181: checkcast       Lgnu/kawa/slib/Stream;
        //   184: aload_3        
        //   185: ldc             Lgnu/math/IntNum;.class
        //   187: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   190: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   193: invokestatic    gnu/kawa/slib/StreamsDerived.streamRef:(Lgnu/kawa/slib/Stream;Lgnu/math/IntNum;)Ljava/lang/Object;
        //   196: areturn        
        //   197: aload_2        
        //   198: ldc             Lgnu/math/IntNum;.class
        //   200: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   203: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   206: aload_3        
        //   207: checkcast       Lgnu/kawa/slib/Stream;
        //   210: invokestatic    gnu/kawa/slib/StreamsDerived.streamTake:(Lgnu/math/IntNum;Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
        //   213: areturn        
        //   214: aload_2        
        //   215: ldc_w           Lgnu/mapping/Procedure;.class
        //   218: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   221: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   224: aload_3        
        //   225: checkcast       Lgnu/kawa/slib/Stream;
        //   228: invokestatic    gnu/kawa/slib/StreamsDerived.streamTakeWhile:(Lgnu/mapping/Procedure;Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
        //   231: areturn        
        //   232: aload_2        
        //   233: ldc_w           Lgnu/mapping/Procedure;.class
        //   236: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   239: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   242: aload_3        
        //   243: invokestatic    gnu/kawa/slib/StreamsDerived.streamUnfolds:(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   246: areturn        
        //   247: aload_0        
        //   248: aload_1        
        //   249: aload_2        
        //   250: aload_3        
        //   251: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   254: areturn        
        //   255: new             Lgnu/mapping/WrongType;
        //   258: dup_x1         
        //   259: swap           
        //   260: ldc_w           "stream-drop"
        //   263: iconst_1       
        //   264: aload_2        
        //   265: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   268: athrow         
        //   269: new             Lgnu/mapping/WrongType;
        //   272: dup_x1         
        //   273: swap           
        //   274: ldc_w           "stream-drop"
        //   277: iconst_2       
        //   278: aload_3        
        //   279: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   282: athrow         
        //   283: new             Lgnu/mapping/WrongType;
        //   286: dup_x1         
        //   287: swap           
        //   288: ldc_w           "stream-drop-while"
        //   291: iconst_1       
        //   292: aload_2        
        //   293: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   296: athrow         
        //   297: new             Lgnu/mapping/WrongType;
        //   300: dup_x1         
        //   301: swap           
        //   302: ldc_w           "stream-drop-while"
        //   305: iconst_2       
        //   306: aload_3        
        //   307: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   310: athrow         
        //   311: new             Lgnu/mapping/WrongType;
        //   314: dup_x1         
        //   315: swap           
        //   316: ldc_w           "stream-filter"
        //   319: iconst_1       
        //   320: aload_2        
        //   321: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   324: athrow         
        //   325: new             Lgnu/mapping/WrongType;
        //   328: dup_x1         
        //   329: swap           
        //   330: ldc_w           "stream-filter"
        //   333: iconst_2       
        //   334: aload_3        
        //   335: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   338: athrow         
        //   339: new             Lgnu/mapping/WrongType;
        //   342: dup_x1         
        //   343: swap           
        //   344: ldc_w           "stream-from"
        //   347: iconst_1       
        //   348: aload_2        
        //   349: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   352: athrow         
        //   353: new             Lgnu/mapping/WrongType;
        //   356: dup_x1         
        //   357: swap           
        //   358: ldc_w           "stream-from"
        //   361: iconst_2       
        //   362: aload_3        
        //   363: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   366: athrow         
        //   367: new             Lgnu/mapping/WrongType;
        //   370: dup_x1         
        //   371: swap           
        //   372: ldc_w           "stream-iterate"
        //   375: iconst_1       
        //   376: aload_2        
        //   377: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   380: athrow         
        //   381: new             Lgnu/mapping/WrongType;
        //   384: dup_x1         
        //   385: swap           
        //   386: ldc_w           "stream-ref"
        //   389: iconst_1       
        //   390: aload_2        
        //   391: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   394: athrow         
        //   395: new             Lgnu/mapping/WrongType;
        //   398: dup_x1         
        //   399: swap           
        //   400: ldc_w           "stream-ref"
        //   403: iconst_2       
        //   404: aload_3        
        //   405: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   408: athrow         
        //   409: new             Lgnu/mapping/WrongType;
        //   412: dup_x1         
        //   413: swap           
        //   414: ldc_w           "stream-take"
        //   417: iconst_1       
        //   418: aload_2        
        //   419: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   422: athrow         
        //   423: new             Lgnu/mapping/WrongType;
        //   426: dup_x1         
        //   427: swap           
        //   428: ldc_w           "stream-take"
        //   431: iconst_2       
        //   432: aload_3        
        //   433: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   436: athrow         
        //   437: new             Lgnu/mapping/WrongType;
        //   440: dup_x1         
        //   441: swap           
        //   442: ldc_w           "stream-take-while"
        //   445: iconst_1       
        //   446: aload_2        
        //   447: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   450: athrow         
        //   451: new             Lgnu/mapping/WrongType;
        //   454: dup_x1         
        //   455: swap           
        //   456: ldc_w           "stream-take-while"
        //   459: iconst_2       
        //   460: aload_3        
        //   461: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   464: athrow         
        //   465: new             Lgnu/mapping/WrongType;
        //   468: dup_x1         
        //   469: swap           
        //   470: ldc_w           "stream-unfolds"
        //   473: iconst_1       
        //   474: aload_2        
        //   475: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   478: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  94     97     255    269    Ljava/lang/ClassCastException;
        //  98     101    269    283    Ljava/lang/ClassCastException;
        //  112    115    283    297    Ljava/lang/ClassCastException;
        //  116    119    297    311    Ljava/lang/ClassCastException;
        //  130    133    311    325    Ljava/lang/ClassCastException;
        //  134    137    325    339    Ljava/lang/ClassCastException;
        //  148    151    339    353    Ljava/lang/ClassCastException;
        //  158    161    353    367    Ljava/lang/ClassCastException;
        //  172    175    367    381    Ljava/lang/ClassCastException;
        //  181    184    381    395    Ljava/lang/ClassCastException;
        //  190    193    395    409    Ljava/lang/ClassCastException;
        //  203    206    409    423    Ljava/lang/ClassCastException;
        //  207    210    423    437    Ljava/lang/ClassCastException;
        //  221    224    437    451    Ljava/lang/ClassCastException;
        //  225    228    451    465    Ljava/lang/ClassCastException;
        //  239    242    465    479    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 209 out of bounds for length 209
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
    public Object apply3(final ModuleMethod p0, final Object p1, final Object p2, final Object p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //               74: 32
        //               88: 52
        //          default: 72
        //        }
        //    32: aload_2        
        //    33: ldc_w           Lgnu/mapping/Procedure;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    42: aload_3        
        //    43: aload           4
        //    45: checkcast       Lgnu/kawa/slib/Stream;
        //    48: invokestatic    gnu/kawa/slib/StreamsDerived.streamFold:(Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/kawa/slib/Stream;)Ljava/lang/Object;
        //    51: areturn        
        //    52: aload_2        
        //    53: ldc_w           Lgnu/mapping/Procedure;.class
        //    56: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    59: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    62: aload_3        
        //    63: aload           4
        //    65: checkcast       Lgnu/kawa/slib/Stream;
        //    68: invokestatic    gnu/kawa/slib/StreamsDerived.streamScan:(Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/kawa/slib/Stream;)Lgnu/kawa/slib/Stream;
        //    71: areturn        
        //    72: aload_0        
        //    73: aload_1        
        //    74: aload_2        
        //    75: aload_3        
        //    76: aload           4
        //    78: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    81: areturn        
        //    82: new             Lgnu/mapping/WrongType;
        //    85: dup_x1         
        //    86: swap           
        //    87: ldc_w           "stream-fold"
        //    90: iconst_1       
        //    91: aload_2        
        //    92: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    95: athrow         
        //    96: new             Lgnu/mapping/WrongType;
        //    99: dup_x1         
        //   100: swap           
        //   101: ldc_w           "stream-fold"
        //   104: iconst_3       
        //   105: aload           4
        //   107: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   110: athrow         
        //   111: new             Lgnu/mapping/WrongType;
        //   114: dup_x1         
        //   115: swap           
        //   116: ldc_w           "stream-scan"
        //   119: iconst_1       
        //   120: aload_2        
        //   121: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   124: athrow         
        //   125: new             Lgnu/mapping/WrongType;
        //   128: dup_x1         
        //   129: swap           
        //   130: ldc_w           "stream-scan"
        //   133: iconst_3       
        //   134: aload           4
        //   136: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   139: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  39     42     82     96     Ljava/lang/ClassCastException;
        //  45     48     96     111    Ljava/lang/ClassCastException;
        //  59     62     111    125    Ljava/lang/ClassCastException;
        //  65     68     125    140    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 60 out of bounds for length 60
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
    public Object apply4(final ModuleMethod p0, final Object p1, final Object p2, final Object p3, final Object p4) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: bipush          91
        //     6: if_icmpne       49
        //     9: goto            12
        //    12: aload_2        
        //    13: ldc_w           Lgnu/mapping/Procedure;.class
        //    16: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    19: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    22: aload_3        
        //    23: ldc_w           Lgnu/mapping/Procedure;.class
        //    26: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    29: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    32: aload           4
        //    34: ldc_w           Lgnu/mapping/Procedure;.class
        //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    40: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    43: aload           5
        //    45: invokestatic    gnu/kawa/slib/StreamsDerived.streamUnfold:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Lgnu/kawa/slib/Stream;
        //    48: areturn        
        //    49: aload_0        
        //    50: aload_1        
        //    51: aload_2        
        //    52: aload_3        
        //    53: aload           4
        //    55: aload           5
        //    57: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    60: areturn        
        //    61: new             Lgnu/mapping/WrongType;
        //    64: dup_x1         
        //    65: swap           
        //    66: ldc_w           "stream-unfold"
        //    69: iconst_1       
        //    70: aload_2        
        //    71: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    74: athrow         
        //    75: new             Lgnu/mapping/WrongType;
        //    78: dup_x1         
        //    79: swap           
        //    80: ldc_w           "stream-unfold"
        //    83: iconst_2       
        //    84: aload_3        
        //    85: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    88: athrow         
        //    89: new             Lgnu/mapping/WrongType;
        //    92: dup_x1         
        //    93: swap           
        //    94: ldc_w           "stream-unfold"
        //    97: iconst_3       
        //    98: aload           4
        //   100: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   103: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  19     22     61     75     Ljava/lang/ClassCastException;
        //  29     32     75     89     Ljava/lang/ClassCastException;
        //  40     43     89     104    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 52 out of bounds for length 52
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
    public Object applyN(final ModuleMethod p0, final Object[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //               66: 80
        //               68: 85
        //               70: 90
        //               76: 95
        //               82: 140
        //               84: 185
        //               92: 244
        //               95: 252
        //          default: 257
        //        }
        //    80: aload_2        
        //    81: invokestatic    gnu/kawa/slib/StreamsDerived.stream$To$List$V:([Ljava/lang/Object;)Lgnu/lists/LList;
        //    84: areturn        
        //    85: aload_2        
        //    86: invokestatic    gnu/kawa/slib/StreamsDerived.streamAppend$V:([Ljava/lang/Object;)Lgnu/kawa/slib/Stream;
        //    89: areturn        
        //    90: aload_2        
        //    91: invokestatic    gnu/kawa/slib/StreamsDerived.streamConstant$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //    94: areturn        
        //    95: aload_2        
        //    96: iconst_0       
        //    97: aaload         
        //    98: ldc_w           Lgnu/mapping/Procedure;.class
        //   101: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   104: dup            
        //   105: astore_3       
        //   106: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   109: aload_2        
        //   110: arraylength    
        //   111: iconst_1       
        //   112: isub           
        //   113: istore_3       
        //   114: iload_3        
        //   115: anewarray       Ljava/lang/Object;
        //   118: goto            129
        //   121: dup            
        //   122: iload_3        
        //   123: aload_2        
        //   124: iload_3        
        //   125: iconst_1       
        //   126: iadd           
        //   127: aaload         
        //   128: aastore        
        //   129: iinc            3, -1
        //   132: iload_3        
        //   133: ifge            121
        //   136: invokestatic    gnu/kawa/slib/StreamsDerived.streamForEach$V:(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
        //   139: areturn        
        //   140: aload_2        
        //   141: iconst_0       
        //   142: aaload         
        //   143: ldc_w           Lgnu/mapping/Procedure;.class
        //   146: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   149: dup            
        //   150: astore_3       
        //   151: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   154: aload_2        
        //   155: arraylength    
        //   156: iconst_1       
        //   157: isub           
        //   158: istore_3       
        //   159: iload_3        
        //   160: anewarray       Ljava/lang/Object;
        //   163: goto            174
        //   166: dup            
        //   167: iload_3        
        //   168: aload_2        
        //   169: iload_3        
        //   170: iconst_1       
        //   171: iadd           
        //   172: aaload         
        //   173: aastore        
        //   174: iinc            3, -1
        //   177: iload_3        
        //   178: ifge            166
        //   181: invokestatic    gnu/kawa/slib/StreamsDerived.streamMap$V:(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Lgnu/kawa/slib/Stream;
        //   184: areturn        
        //   185: aload_2        
        //   186: iconst_0       
        //   187: aaload         
        //   188: ldc_w           Lgnu/math/Numeric;.class
        //   191: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   194: dup            
        //   195: astore_3       
        //   196: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceNumeric:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //   199: aload_2        
        //   200: iconst_1       
        //   201: aaload         
        //   202: ldc_w           Lgnu/math/Numeric;.class
        //   205: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   208: dup            
        //   209: astore_3       
        //   210: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceNumeric:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //   213: aload_2        
        //   214: arraylength    
        //   215: iconst_2       
        //   216: isub           
        //   217: istore_3       
        //   218: iload_3        
        //   219: anewarray       Ljava/lang/Object;
        //   222: goto            233
        //   225: dup            
        //   226: iload_3        
        //   227: aload_2        
        //   228: iload_3        
        //   229: iconst_2       
        //   230: iadd           
        //   231: aaload         
        //   232: aastore        
        //   233: iinc            3, -1
        //   236: iload_3        
        //   237: ifge            225
        //   240: invokestatic    gnu/kawa/slib/StreamsDerived.streamRange$V:(Lgnu/math/Numeric;Lgnu/math/Numeric;[Ljava/lang/Object;)Lgnu/kawa/slib/Stream;
        //   243: areturn        
        //   244: aload_2        
        //   245: invokestatic    gnu/kawa/slib/StreamsDerived$frame33.lambda75$V:([Ljava/lang/Object;)I
        //   248: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   251: areturn        
        //   252: aload_2        
        //   253: invokestatic    gnu/kawa/slib/StreamsDerived.streamZip$V:([Ljava/lang/Object;)Lgnu/kawa/slib/Stream;
        //   256: areturn        
        //   257: aload_0        
        //   258: aload_1        
        //   259: aload_2        
        //   260: invokespecial   gnu/expr/ModuleBody.applyN:(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
        //   263: areturn        
        //   264: new             Lgnu/mapping/WrongType;
        //   267: dup_x1         
        //   268: swap           
        //   269: ldc_w           "stream-for-each"
        //   272: iconst_1       
        //   273: aload_3        
        //   274: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   277: athrow         
        //   278: new             Lgnu/mapping/WrongType;
        //   281: dup_x1         
        //   282: swap           
        //   283: ldc_w           "stream-map"
        //   286: iconst_1       
        //   287: aload_3        
        //   288: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   291: athrow         
        //   292: new             Lgnu/mapping/WrongType;
        //   295: dup_x1         
        //   296: swap           
        //   297: ldc_w           "stream-range"
        //   300: iconst_1       
        //   301: aload_3        
        //   302: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   305: athrow         
        //   306: new             Lgnu/mapping/WrongType;
        //   309: dup_x1         
        //   310: swap           
        //   311: ldc_w           "stream-range"
        //   314: iconst_2       
        //   315: aload_3        
        //   316: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   319: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  106    109    264    278    Ljava/lang/ClassCastException;
        //  151    154    278    292    Ljava/lang/ClassCastException;
        //  196    199    292    306    Ljava/lang/ClassCastException;
        //  210    213    306    320    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 151 out of bounds for length 151
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
}
