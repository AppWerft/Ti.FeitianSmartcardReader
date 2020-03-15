// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lisp;

import gnu.expr.ModuleInfo;
import gnu.mapping.DynamicLocation;
import gnu.lists.PairWithPosition;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import gnu.kawa.functions.DivideOp;
import gnu.mapping.Values;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.IsEqv;
import gnu.mapping.UnboundLocationException;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Procedure;
import kawa.lib.lists;
import gnu.kawa.functions.AddOp;
import gnu.lists.LList;
import gnu.mapping.Promise;
import gnu.lists.Pair;
import gnu.commonlisp.lang.Lisp2;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.expr.Keyword;
import gnu.math.IntNum;
import kawa.lang.Macro;
import gnu.expr.ModuleMethod;
import gnu.mapping.Location;
import gnu.expr.ModuleBody;

public class primitives extends ModuleBody
{
    static final Location loc$typep;
    static final Location loc$null;
    public static final ModuleMethod car;
    public static final ModuleMethod first;
    public static final ModuleMethod cdr;
    public static final ModuleMethod rest;
    public static final ModuleMethod second;
    public static final ModuleMethod third;
    public static final ModuleMethod nthcdr;
    public static final ModuleMethod nth;
    public static final ModuleMethod $N1$Mn;
    public static final ModuleMethod $N1$Pl;
    public static final ModuleMethod acons;
    public static final ModuleMethod listp;
    public static final ModuleMethod numberp;
    public static final ModuleMethod atom;
    public static final ModuleMethod eql;
    public static final ModuleMethod complement;
    public static final ModuleMethod member$Mnwith$Mntest;
    public static final ModuleMethod member$Mnwith$Mnkey;
    public static final ModuleMethod member$Mnplain;
    public static final ModuleMethod member;
    public static final ModuleMethod apply;
    public static final ModuleMethod funcall;
    public static final ModuleMethod minusp;
    public static final ModuleMethod plusp;
    public static final Macro flet;
    public static final Macro labels;
    public static final Macro multiple$Mnvalue$Mnbind;
    public static final ModuleMethod floor;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final Keyword Lit2;
    static final Keyword Lit3;
    static final Keyword Lit4;
    static final SimpleSymbol Lit5;
    public static primitives $instance;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SyntaxRules Lit33;
    static final SimpleSymbol Lit34;
    static final SyntaxRules Lit35;
    static final SimpleSymbol Lit36;
    static final SyntaxRules Lit37;
    static final SimpleSymbol Lit38;
    static final Object[] Lit39;
    static final SimpleSymbol Lit40;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Object car(final Object x) {
        return Lisp2.isTrueLisp(x) ? ((Pair)Promise.force(x, Pair.class)).getCar() : LList.Empty;
    }
    
    public static Object first(final Object x) {
        return car(x);
    }
    
    public static Object cdr(final Object x) {
        return Lisp2.isTrueLisp(x) ? ((Pair)Promise.force(x, Pair.class)).getCdr() : LList.Empty;
    }
    
    public static Object rest(final Object x) {
        return cdr(x);
    }
    
    public static Object second(final Object x) {
        return first(rest(x));
    }
    
    public static Object third(final Object x) {
        return first(rest(rest(x)));
    }
    
    public static Object nthcdr(final Object n, final Object lst) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //     4: dup            
        //     5: astore_3       
        //     6: checkcast       Ljava/lang/Number;
        //     9: invokevirtual   java/lang/Number.intValue:()I
        //    12: istore_2        /* n */
        //    13: iload_2         /* n */
        //    14: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    17: aload_1         /* lst */
        //    18: astore          4
        //    20: astore_3        /* i */
        //    21: aload_3         /* i */
        //    22: getstatic       gnu/commonlisp/lisp/primitives.Lit0:Lgnu/math/IntNum;
        //    25: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    28: ifne            43
        //    31: aload_3         /* i */
        //    32: invokestatic    gnu/commonlisp/lisp/primitives.$N1$Mn:(Ljava/lang/Object;)Ljava/lang/Object;
        //    35: aload           result
        //    37: invokestatic    gnu/commonlisp/lisp/primitives.cdr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    40: goto            18
        //    43: aload           result
        //    45: areturn        
        //    46: new             Lgnu/mapping/WrongType;
        //    49: dup_x1         
        //    50: swap           
        //    51: ldc             "n"
        //    53: bipush          -2
        //    55: aload_3        
        //    56: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    59: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  6      12     46     60     Ljava/lang/ClassCastException;
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
    
    public static Object $N1$Mn(final Object x) {
        return AddOp.apply2(-1, x, primitives.Lit1);
    }
    
    public static Object nth(final Object n, final Object x) {
        return first(nthcdr(n, x));
    }
    
    public static Object $N1$Pl(final Object x) {
        return AddOp.apply2(1, x, primitives.Lit1);
    }
    
    public static Pair acons(final Object key, final Object datum, final Object alist) {
        return lists.cons(lists.cons(key, datum), alist);
    }
    
    public static Object listp(final Object obj) {
        final Location loc$typep = primitives.loc$typep;
        try {
            return ((Procedure)Promise.force(loc$typep.get(), Procedure.class)).apply2(obj, LangObjType.listType);
        }
        catch (UnboundLocationException ex) {
            ex.setLine("/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp", 39, 3);
            throw ex;
        }
    }
    
    public static Object numberp(final Object obj) {
        final Location loc$typep = primitives.loc$typep;
        try {
            return ((Procedure)Promise.force(loc$typep.get(), Procedure.class)).apply2(obj, LangObjType.numericType);
        }
        catch (UnboundLocationException ex) {
            ex.setLine("/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp", 42, 3);
            throw ex;
        }
    }
    
    public static boolean atom(final Object obj) {
        return !lists.isPair(obj);
    }
    
    public static boolean eql(final Object x, final Object y) {
        return IsEqv.apply(x, y);
    }
    
    public static Procedure complement(final Object pred) {
        public class primitives$frame extends ModuleBody
        {
            Object pred;
            final ModuleMethod lambda$Fn1;
            
            public primitives$frame() {
                final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, -4096);
                lambda$Fn1.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp:51");
                this.lambda$Fn1 = lambda$Fn1;
            }
            
            boolean lambda1$V(final Object[] argsArray) {
                final LList arguments = LList.makeList(argsArray, 0);
                return !Lisp2.isTrueLisp(primitives.apply$V(this.pred, new Object[] { arguments }));
            }
            
            @Override
            public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
                if (moduleMethod.selector == 1) {
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
                if (method.selector == 1) {
                    return this.lambda1$V(array) ? Lisp2.TRUE : LList.Empty;
                }
                return super.applyN(method, array);
            }
        }
        final primitives$frame $heapFrame = new primitives$frame();
        $heapFrame.pred = pred;
        return $heapFrame.lambda$Fn1;
    }
    
    public static Object apply$V(final Object func, final Object[] argsArray) {
        final LList args = LList.makeList(argsArray, 0);
        return ((Procedure)(PrimOps.symbolp(func) ? Promise.force(PrimOps.symbolFunction(func), Procedure.class) : ((Procedure)Promise.force(func, Procedure.class)))).applyN(Apply.getArguments(args, 0, primitives.apply));
    }
    
    public static Object memberWithTest(final Object x, final Object lst, final Object test, final Object key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/lists/LList;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore          5
        //     9: checkcast       Lgnu/lists/LList;
        //    12: astore          lst
        //    14: getstatic       gnu/commonlisp/lisp/primitives.loc$null:Lgnu/mapping/Location;
        //    17: invokevirtual   gnu/mapping/Location.get:()Ljava/lang/Object;
        //    20: ldc             Lgnu/mapping/Procedure;.class
        //    22: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    25: checkcast       Lgnu/mapping/Procedure;
        //    28: aload           lst
        //    30: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    33: invokestatic    gnu/commonlisp/lang/Lisp2.isTrueLisp:(Ljava/lang/Object;)Z
        //    36: ifeq            45
        //    39: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    42: goto            96
        //    45: aload_2         /* test */
        //    46: iconst_2       
        //    47: anewarray       Ljava/lang/Object;
        //    50: dup            
        //    51: iconst_0       
        //    52: aload_0         /* x */
        //    53: aastore        
        //    54: dup            
        //    55: iconst_1       
        //    56: aload_3         /* key */
        //    57: iconst_1       
        //    58: anewarray       Ljava/lang/Object;
        //    61: dup            
        //    62: iconst_0       
        //    63: aload           lst
        //    65: invokestatic    gnu/commonlisp/lisp/primitives.car:(Ljava/lang/Object;)Ljava/lang/Object;
        //    68: aastore        
        //    69: invokestatic    gnu/commonlisp/lisp/primitives.funcall$V:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    72: aastore        
        //    73: invokestatic    gnu/commonlisp/lisp/primitives.funcall$V:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    76: invokestatic    gnu/commonlisp/lang/Lisp2.isTrueLisp:(Ljava/lang/Object;)Z
        //    79: ifeq            87
        //    82: aload           lst
        //    84: goto            96
        //    87: aload           lst
        //    89: invokestatic    gnu/commonlisp/lisp/primitives.cdr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    92: astore_1        /* lst */
        //    93: goto            0
        //    96: areturn        
        //    97: new             Lgnu/mapping/WrongType;
        //   100: dup_x1         
        //   101: swap           
        //   102: ldc             "lst"
        //   104: bipush          -2
        //   106: aload           5
        //   108: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   111: athrow         
        //   112: dup            
        //   113: ldc             "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp"
        //   115: bipush          56
        //   117: bipush          10
        //   119: invokevirtual   gnu/mapping/UnboundLocationException.setLine:(Ljava/lang/String;II)V
        //   122: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                  
        //  -----  -----  -----  -----  --------------------------------------
        //  9      12     97     112    Ljava/lang/ClassCastException;
        //  17     20     112    123    Lgnu/mapping/UnboundLocationException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0045:
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
    
    public static Object funcall$V(final Object func, final Object[] argsArray) {
        final LList args = LList.makeList(argsArray, 0);
        return apply$V(func, new Object[] { args });
    }
    
    public static Object memberWithKey(final Object x, final Object lst, final Object key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/lists/LList;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore          4
        //     9: checkcast       Lgnu/lists/LList;
        //    12: astore_3        /* lst */
        //    13: getstatic       gnu/commonlisp/lisp/primitives.loc$null:Lgnu/mapping/Location;
        //    16: invokevirtual   gnu/mapping/Location.get:()Ljava/lang/Object;
        //    19: ldc             Lgnu/mapping/Procedure;.class
        //    21: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    24: checkcast       Lgnu/mapping/Procedure;
        //    27: aload_3         /* lst */
        //    28: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    31: invokestatic    gnu/commonlisp/lang/Lisp2.isTrueLisp:(Ljava/lang/Object;)Z
        //    34: ifeq            43
        //    37: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    40: goto            77
        //    43: aload_0         /* x */
        //    44: aload_2         /* key */
        //    45: iconst_1       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload_3         /* lst */
        //    52: invokestatic    gnu/commonlisp/lisp/primitives.car:(Ljava/lang/Object;)Ljava/lang/Object;
        //    55: aastore        
        //    56: invokestatic    gnu/commonlisp/lisp/primitives.funcall$V:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    59: invokestatic    gnu/commonlisp/lisp/primitives.eql:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    62: ifeq            69
        //    65: aload_3         /* lst */
        //    66: goto            77
        //    69: aload_3         /* lst */
        //    70: invokestatic    gnu/commonlisp/lisp/primitives.cdr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    73: astore_1        /* lst */
        //    74: goto            0
        //    77: areturn        
        //    78: new             Lgnu/mapping/WrongType;
        //    81: dup_x1         
        //    82: swap           
        //    83: ldc             "lst"
        //    85: bipush          -2
        //    87: aload           4
        //    89: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    92: athrow         
        //    93: dup            
        //    94: ldc             "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp"
        //    96: bipush          62
        //    98: bipush          10
        //   100: invokevirtual   gnu/mapping/UnboundLocationException.setLine:(Ljava/lang/String;II)V
        //   103: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                  
        //  -----  -----  -----  -----  --------------------------------------
        //  9      12     78     93     Ljava/lang/ClassCastException;
        //  16     19     93     104    Lgnu/mapping/UnboundLocationException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0043:
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
    
    public static Object memberPlain(final Object x, final Object lst) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/lists/LList;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_3       
        //     8: checkcast       Lgnu/lists/LList;
        //    11: astore_2        /* lst */
        //    12: getstatic       gnu/commonlisp/lisp/primitives.loc$null:Lgnu/mapping/Location;
        //    15: invokevirtual   gnu/mapping/Location.get:()Ljava/lang/Object;
        //    18: ldc             Lgnu/mapping/Procedure;.class
        //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    23: checkcast       Lgnu/mapping/Procedure;
        //    26: aload_2         /* lst */
        //    27: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    30: invokestatic    gnu/commonlisp/lang/Lisp2.isTrueLisp:(Ljava/lang/Object;)Z
        //    33: ifeq            42
        //    36: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    39: goto            65
        //    42: aload_0         /* x */
        //    43: aload_2         /* lst */
        //    44: invokestatic    gnu/commonlisp/lisp/primitives.car:(Ljava/lang/Object;)Ljava/lang/Object;
        //    47: invokestatic    gnu/commonlisp/lisp/primitives.eql:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    50: ifeq            57
        //    53: aload_2         /* lst */
        //    54: goto            65
        //    57: aload_2         /* lst */
        //    58: invokestatic    gnu/commonlisp/lisp/primitives.cdr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    61: astore_1        /* lst */
        //    62: goto            0
        //    65: areturn        
        //    66: new             Lgnu/mapping/WrongType;
        //    69: dup_x1         
        //    70: swap           
        //    71: ldc             "lst"
        //    73: bipush          -2
        //    75: aload_3        
        //    76: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    79: athrow         
        //    80: dup            
        //    81: ldc             "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp"
        //    83: bipush          68
        //    85: bipush          10
        //    87: invokevirtual   gnu/mapping/UnboundLocationException.setLine:(Ljava/lang/String;II)V
        //    90: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                  
        //  -----  -----  -----  -----  --------------------------------------
        //  8      11     66     80     Ljava/lang/ClassCastException;
        //  15     18     80     91     Lgnu/mapping/UnboundLocationException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0042:
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
    
    public static Object member$V(final Object x, final Object lst, final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: getstatic       gnu/commonlisp/lisp/primitives.Lit2:Lgnu/expr/Keyword;
        //     5: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //     8: invokestatic    gnu/expr/Keyword.searchForKeyword:([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    11: astore_3        /* key */
        //    12: aload_2         /* argsArray */
        //    13: iconst_0       
        //    14: getstatic       gnu/commonlisp/lisp/primitives.Lit3:Lgnu/expr/Keyword;
        //    17: getstatic       gnu/expr/Special.undefined:Lgnu/expr/Special;
        //    20: invokestatic    gnu/expr/Keyword.searchForKeyword:([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    23: astore          GS$Dt35
        //    25: aload_2         /* argsArray */
        //    26: iconst_0       
        //    27: getstatic       gnu/commonlisp/lisp/primitives.Lit4:Lgnu/expr/Keyword;
        //    30: getstatic       gnu/expr/Special.undefined:Lgnu/expr/Special;
        //    33: invokestatic    gnu/expr/Keyword.searchForKeyword:([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    36: astore          GS$Dt36
        //    38: aload           GS$Dt35
        //    40: getstatic       gnu/expr/Special.undefined:Lgnu/expr/Special;
        //    43: if_acmpne       52
        //    46: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    49: goto            55
        //    52: getstatic       gnu/commonlisp/lisp/primitives.Lit5:Lgnu/mapping/SimpleSymbol;
        //    55: astore          6
        //    57: aload           GS$Dt36
        //    59: getstatic       gnu/expr/Special.undefined:Lgnu/expr/Special;
        //    62: if_acmpne       71
        //    65: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    68: goto            74
        //    71: getstatic       gnu/commonlisp/lisp/primitives.Lit5:Lgnu/mapping/SimpleSymbol;
        //    74: astore          test$Mnnot$Mnsupplied
        //    76: aload           test$Mnsupplied
        //    78: invokestatic    gnu/commonlisp/lang/Lisp2.isTrueLisp:(Ljava/lang/Object;)Z
        //    81: ifeq            89
        //    84: aload           GS$Dt35
        //    86: goto            92
        //    89: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    92: astore          8
        //    94: aload           test$Mnnot$Mnsupplied
        //    96: invokestatic    gnu/commonlisp/lang/Lisp2.isTrueLisp:(Ljava/lang/Object;)Z
        //    99: ifeq            107
        //   102: aload           GS$Dt36
        //   104: goto            110
        //   107: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   110: astore          test$Mnnot
        //   112: aload_1         /* lst */
        //   113: ldc             Lgnu/lists/LList;.class
        //   115: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   118: dup            
        //   119: astore          11
        //   121: checkcast       Lgnu/lists/LList;
        //   124: astore          lst
        //   126: aload           test$Mnsupplied
        //   128: invokestatic    gnu/commonlisp/lang/Lisp2.isTrueLisp:(Ljava/lang/Object;)Z
        //   131: ifeq            146
        //   134: aload_0         /* x */
        //   135: aload           lst
        //   137: aload           test
        //   139: aload_3         /* key */
        //   140: invokestatic    gnu/commonlisp/lisp/primitives.memberWithTest:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   143: goto            192
        //   146: aload           test$Mnnot$Mnsupplied
        //   148: invokestatic    gnu/commonlisp/lang/Lisp2.isTrueLisp:(Ljava/lang/Object;)Z
        //   151: ifeq            169
        //   154: aload_0         /* x */
        //   155: aload           lst
        //   157: aload           test$Mnnot
        //   159: invokestatic    gnu/commonlisp/lisp/primitives.complement:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   162: aload_3         /* key */
        //   163: invokestatic    gnu/commonlisp/lisp/primitives.memberWithTest:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   166: goto            192
        //   169: aload_3         /* key */
        //   170: invokestatic    gnu/commonlisp/lang/Lisp2.isTrueLisp:(Ljava/lang/Object;)Z
        //   173: ifeq            186
        //   176: aload_0         /* x */
        //   177: aload           lst
        //   179: aload_3         /* key */
        //   180: invokestatic    gnu/commonlisp/lisp/primitives.memberWithKey:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   183: goto            192
        //   186: aload_0         /* x */
        //   187: aload           lst
        //   189: invokestatic    gnu/commonlisp/lisp/primitives.memberPlain:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   192: areturn        
        //   193: new             Lgnu/mapping/WrongType;
        //   196: dup_x1         
        //   197: swap           
        //   198: ldc             "lst"
        //   200: bipush          -2
        //   202: aload           11
        //   204: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   207: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  121    124    193    208    Ljava/lang/ClassCastException;
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
    
    public static boolean minusp(final Object x) {
        return NumberCompare.$Ls(x, primitives.Lit0);
    }
    
    public static boolean plusp(final Object x) {
        return NumberCompare.$Gr(x, primitives.Lit0);
    }
    
    public static Values floor(final Object number) {
        return floor(number, primitives.Lit1);
    }
    
    public static Values floor(final Object number, final Object divisor) {
        return Values.values2(DivideOp.div.apply2(number, divisor), DivideOp.remainder.apply2(number, divisor));
    }
    
    static {
        Lit40 = Symbol.valueOf("lambda");
        Lit39 = new Object[0];
        Lit38 = Symbol.valueOf("floor");
        Lit37 = new SyntaxRules(primitives.Lit39, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\r\u0017\u0010\b\b", primitives.Lit39, 3, "primitives.lisp:133"), "\u0001\u0001\u0003", "\u0011\u0018\u00049\u0011\u0018\f\t\u0010\b\u000b\b\u0011\u0018\f\t\u0003\b\u0015\u0013", new Object[] { Symbol.valueOf("call-with-values"), primitives.Lit40 }, 1) }, 3, Lit36 = Symbol.valueOf("multiple-value-bind"));
        Lit35 = new SyntaxRules(primitives.Lit39, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018lM\f\u0007\f\u000f\r\u0017\u0010\b\b\u0000\u0018\b\r\u001f\u0018\b\b", primitives.Lit39, 4, "primitives.lisp:117"), "\u0003\u0003\u0005\u0003", "\u0011\u0018\u0004A\b\u0005\t\u0003\t\u000b\u0018\f\u0099\u0005\u0011\u0018\u0014)\u0011\u0018\u001c\b\u0003\b\u0011\u0018$\t\u000b\b\u0015\u0013\b\u001d\u001b", new Object[] { Lit32 = Symbol.valueOf("flet"), PairWithPosition.make(Values.empty, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp", 483359), Symbol.valueOf("set!"), Symbol.valueOf("function"), primitives.Lit40 }, 2) }, 4, Lit34 = Symbol.valueOf("labels"));
        Lit33 = new SyntaxRules(primitives.Lit39, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018lM\f\u0007\f\u000f\r\u0017\u0010\b\b\u0000\u0018\b\r\u001f\u0018\b\b", primitives.Lit39, 4, "primitives.lisp:110"), "\u0003\u0003\u0005\u0003", "\u0011\u0018\u0004i\b\u0005\t\u0003\b\u0011\u0018\f\t\u000b\b\u0015\u0013\b\u001d\u001b", new Object[] { Symbol.valueOf("%flet"), primitives.Lit40 }, 2) }, 4, primitives.Lit32);
        Lit31 = Symbol.valueOf("plusp");
        Lit30 = Symbol.valueOf("minusp");
        Lit29 = Symbol.valueOf("funcall");
        Lit28 = Symbol.valueOf("apply");
        Lit27 = Symbol.valueOf("member");
        Lit26 = Symbol.valueOf("member-plain");
        Lit25 = Symbol.valueOf("member-with-key");
        Lit24 = Symbol.valueOf("member-with-test");
        Lit23 = Symbol.valueOf("complement");
        Lit22 = Symbol.valueOf("eql");
        Lit21 = Symbol.valueOf("atom");
        Lit20 = Symbol.valueOf("numberp");
        Lit19 = Symbol.valueOf("listp");
        Lit18 = Symbol.valueOf("acons");
        Lit17 = Symbol.valueOf("1+");
        Lit16 = Symbol.valueOf("1-");
        Lit15 = Symbol.valueOf("nth");
        Lit14 = Symbol.valueOf("nthcdr");
        Lit13 = Symbol.valueOf("third");
        Lit12 = Symbol.valueOf("second");
        Lit11 = Symbol.valueOf("rest");
        Lit10 = Symbol.valueOf("cdr");
        Lit9 = Symbol.valueOf("first");
        Lit8 = Symbol.valueOf("car");
        Lit7 = Symbol.valueOf("null");
        Lit6 = Symbol.valueOf("typep");
        Lit5 = Symbol.valueOf("t");
        Lit4 = Keyword.make("test-not");
        Lit3 = Keyword.make("test");
        Lit2 = Keyword.make("key");
        Lit1 = IntNum.valueOf(1);
        Lit0 = IntNum.valueOf(0);
        primitives.$instance = new primitives();
        loc$typep = DynamicLocation.getInstance(primitives.Lit6, Symbol.FUNCTION);
        loc$null = DynamicLocation.getInstance(primitives.Lit7, Symbol.FUNCTION);
        final primitives $instance = primitives.$instance;
        car = new ModuleMethod($instance, 2, primitives.Lit8, 4097);
        first = new ModuleMethod($instance, 3, primitives.Lit9, 4097);
        cdr = new ModuleMethod($instance, 4, primitives.Lit10, 4097);
        rest = new ModuleMethod($instance, 5, primitives.Lit11, 4097);
        second = new ModuleMethod($instance, 6, primitives.Lit12, 4097);
        third = new ModuleMethod($instance, 7, primitives.Lit13, 4097);
        nthcdr = new ModuleMethod($instance, 8, primitives.Lit14, 8194);
        nth = new ModuleMethod($instance, 9, primitives.Lit15, 8194);
        $N1$Mn = new ModuleMethod($instance, 10, primitives.Lit16, 4097);
        $N1$Pl = new ModuleMethod($instance, 11, primitives.Lit17, 4097);
        acons = new ModuleMethod($instance, 12, primitives.Lit18, 12291);
        listp = new ModuleMethod($instance, 13, primitives.Lit19, 4097);
        numberp = new ModuleMethod($instance, 14, primitives.Lit20, 4097);
        atom = new ModuleMethod($instance, 15, primitives.Lit21, 4097);
        eql = new ModuleMethod($instance, 16, primitives.Lit22, 8194);
        complement = new ModuleMethod($instance, 17, primitives.Lit23, 4097);
        member$Mnwith$Mntest = new ModuleMethod($instance, 18, primitives.Lit24, 16388);
        member$Mnwith$Mnkey = new ModuleMethod($instance, 19, primitives.Lit25, 12291);
        member$Mnplain = new ModuleMethod($instance, 20, primitives.Lit26, 8194);
        member = new ModuleMethod($instance, 21, primitives.Lit27, -4094);
        apply = new ModuleMethod($instance, 22, primitives.Lit28, -4095);
        funcall = new ModuleMethod($instance, 23, primitives.Lit29, -4095);
        minusp = new ModuleMethod($instance, 24, primitives.Lit30, 4097);
        plusp = new ModuleMethod($instance, 25, primitives.Lit31, 4097);
        flet = Macro.make(primitives.Lit32, primitives.Lit33, "gnu.commonlisp.lisp.primitives");
        labels = Macro.make(primitives.Lit34, primitives.Lit35, "gnu.commonlisp.lisp.primitives");
        multiple$Mnvalue$Mnbind = Macro.make(primitives.Lit36, primitives.Lit37, "gnu.commonlisp.lisp.primitives");
        floor = new ModuleMethod($instance, 26, primitives.Lit38, 8193);
        $runBody$();
    }
    
    public primitives() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 26: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 25: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 24: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 17: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 15: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 14: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 13: {
                ctx.value1 = o;
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
            case 10: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 7: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 6: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 5: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 3: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
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
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 26: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 20: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 16: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 9: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 8: {
                ctx.value1 = o;
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
            case 19: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 12: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
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
        if (moduleMethod.selector == 18) {
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
        switch (moduleMethod.selector) {
            case 23: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 22: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 21: {
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
    public Object apply1(final ModuleMethod method, final Object arg1) {
        switch (method.selector) {
            case 2: {
                return car(arg1);
            }
            case 3: {
                return first(arg1);
            }
            case 4: {
                return cdr(arg1);
            }
            case 5: {
                return rest(arg1);
            }
            case 6: {
                return second(arg1);
            }
            case 7: {
                return third(arg1);
            }
            case 10: {
                return $N1$Mn(arg1);
            }
            case 11: {
                return $N1$Pl(arg1);
            }
            case 13: {
                return listp(arg1);
            }
            case 14: {
                return numberp(arg1);
            }
            case 15: {
                return atom(arg1) ? Lisp2.TRUE : LList.Empty;
            }
            case 17: {
                return complement(arg1);
            }
            case 24: {
                return minusp(arg1) ? Lisp2.TRUE : LList.Empty;
            }
            case 25: {
                return plusp(arg1) ? Lisp2.TRUE : LList.Empty;
            }
            case 26: {
                return floor(arg1);
            }
            default: {
                return super.apply1(method, arg1);
            }
        }
    }
    
    @Override
    public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
        switch (method.selector) {
            case 8: {
                return nthcdr(o, o2);
            }
            case 9: {
                return nth(o, o2);
            }
            case 16: {
                return eql(o, o2) ? Lisp2.TRUE : LList.Empty;
            }
            case 20: {
                return memberPlain(o, o2);
            }
            case 26: {
                return floor(o, o2);
            }
            default: {
                return super.apply2(method, o, o2);
            }
        }
    }
    
    @Override
    public Object apply3(final ModuleMethod method, final Object arg1, final Object arg2, final Object arg3) {
        switch (method.selector) {
            case 12: {
                return acons(arg1, arg2, arg3);
            }
            case 19: {
                return memberWithKey(arg1, arg2, arg3);
            }
            default: {
                return super.apply3(method, arg1, arg2, arg3);
            }
        }
    }
    
    @Override
    public Object apply4(final ModuleMethod method, final Object o, final Object o2, final Object o3, final Object o4) {
        if (method.selector == 18) {
            return memberWithTest(o, o2, o3, o4);
        }
        return super.apply4(method, o, o2, o3, o4);
    }
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] args) {
        switch (method.selector) {
            case 21: {
                final Object x = args[0];
                final Object lst = args[1];
                int n = args.length - 2;
                final Object[] argsArray = new Object[n];
                while (--n >= 0) {
                    argsArray[n] = args[n + 2];
                }
                return member$V(x, lst, argsArray);
            }
            case 22: {
                final Object func = args[0];
                int n2 = args.length - 1;
                final Object[] argsArray2 = new Object[n2];
                while (--n2 >= 0) {
                    argsArray2[n2] = args[n2 + 1];
                }
                return apply$V(func, argsArray2);
            }
            case 23: {
                final Object func2 = args[0];
                int n3 = args.length - 1;
                final Object[] argsArray3 = new Object[n3];
                while (--n3 >= 0) {
                    argsArray3[n3] = args[n3 + 1];
                }
                return funcall$V(func2, argsArray3);
            }
            default: {
                return super.applyN(method, args);
            }
        }
    }
}
