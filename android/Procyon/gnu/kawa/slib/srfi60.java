// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.lists.EmptyList;
import kawa.lib.lists;
import gnu.lists.LList;
import gnu.lists.Consumer;
import kawa.lib.numbers;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.mapping.Procedure;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class srfi60 extends ModuleBody
{
    public static final int $Pcprovide$Pcsrfi$Mn60 = 123;
    public static final StaticFieldLocation arithmetic$Mnshift;
    public static final StaticFieldLocation ash;
    public static final StaticFieldLocation bitwise$Mnand;
    public static final StaticFieldLocation logand;
    public static final StaticFieldLocation bitwise$Mnior;
    public static final StaticFieldLocation logior;
    public static final StaticFieldLocation bitwise$Mnnot;
    public static final StaticFieldLocation lognot;
    public static final StaticFieldLocation bitwise$Mnxor;
    public static final StaticFieldLocation logxor;
    public static final StaticFieldLocation integer$Mnlength;
    public static final StaticFieldLocation bitwise$Mnif;
    public static final StaticFieldLocation logtest;
    public static final StaticFieldLocation logcount;
    public static ModuleMethod bitwise$Mnmerge;
    public static ModuleMethod any$Mnbits$Mnset$Qu;
    public static ModuleMethod bit$Mncount;
    public static ModuleMethod log2$Mnbinary$Mnfactors;
    public static ModuleMethod first$Mnset$Mnbit;
    public static ModuleMethod bit$Mnfield;
    public static ModuleMethod reverse$Mnbit$Mnfield;
    public static final ModuleMethod logbit$Qu;
    public static Procedure bit$Mnset$Qu;
    public static final ModuleMethod copy$Mnbit$Mnfield;
    public static final ModuleMethod rotate$Mnbit$Mnfield;
    public static final ModuleMethod copy$Mnbit;
    public static final ModuleMethod integer$Mn$Grlist;
    public static final ModuleMethod list$Mn$Grinteger;
    public static final ModuleMethod booleans$Mn$Grinteger;
    static final IntNum Lit0;
    public static srfi60 $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        srfi60.bitwise$Mnmerge = numbers.bitwise$Mnif;
        srfi60.any$Mnbits$Mnset$Qu = numbers.logtest;
        srfi60.bit$Mncount = numbers.logcount;
        srfi60.log2$Mnbinary$Mnfactors = numbers.bitwise$Mnfirst$Mnbit$Mnset;
        srfi60.first$Mnset$Mnbit = numbers.bitwise$Mnfirst$Mnbit$Mnset;
        srfi60.bit$Mnfield = numbers.bitwise$Mnbit$Mnfield;
        srfi60.reverse$Mnbit$Mnfield = numbers.bitwise$Mnreverse$Mnbit$Mnfield;
        srfi60.bit$Mnset$Qu = srfi60.logbit$Qu;
    }
    
    public static boolean isLogbit(final int index, final IntNum n) {
        return numbers.isBitwiseBitSet(n, index);
    }
    
    public static IntNum copyBitField(final IntNum to, final IntNum from, final int start, final int end) {
        return numbers.bitwiseCopyBitField(to, start, end, from);
    }
    
    public static IntNum rotateBitField(final IntNum n, final int count, final int start, final int end) {
        return numbers.bitwiseRotateBitField(n, start, end, count);
    }
    
    public static IntNum copyBit(final int index, final IntNum from, final boolean bit) {
        return numbers.bitwiseCopyBit(from, index, bit ? 1 : 0);
    }
    
    public static LList integer$To$List(final IntNum intNum) {
        return integer$To$List(intNum, numbers.bitwiseLength(intNum));
    }
    
    public static LList integer$To$List(final IntNum k, final int len) {
        final int n = len - 1;
        final EmptyList empty = LList.Empty;
        LList lst = null;
        for (int idx = n; idx >= 0; --idx) {
            final IntNum i;
            final IntNum shift = IntNum.shift(i, -1);
            lst = lists.cons(((i.intValue() & 0x1) != 0x0) ? Boolean.TRUE : Boolean.FALSE, lst);
            i = shift;
        }
        return lst;
    }
    
    public static IntNum list$To$Integer(final LList bools) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       gnu/kawa/slib/srfi60.Lit0:Lgnu/math/IntNum;
        //     4: astore_2       
        //     5: astore_1        /* bs */
        //     6: aload_1         /* bs */
        //     7: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    10: ifne            67
        //    13: aload_1         /* bs */
        //    14: ldc             Lgnu/lists/Pair;.class
        //    16: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    19: dup            
        //    20: astore_3       
        //    21: checkcast       Lgnu/lists/Pair;
        //    24: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    27: aload_1         /* bs */
        //    28: ldc             Lgnu/lists/Pair;.class
        //    30: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    33: dup            
        //    34: astore_3       
        //    35: checkcast       Lgnu/lists/Pair;
        //    38: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    41: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    44: ifeq            59
        //    47: aload_2         /* acc */
        //    48: aload_2         /* acc */
        //    49: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
        //    52: iconst_1       
        //    53: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    56: goto            4
        //    59: aload_2         /* acc */
        //    60: aload_2         /* acc */
        //    61: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
        //    64: goto            4
        //    67: aload_2         /* acc */
        //    68: areturn        
        //    69: new             Lgnu/mapping/WrongType;
        //    72: dup_x1         
        //    73: swap           
        //    74: ldc             "cdr"
        //    76: iconst_1       
        //    77: aload_3        
        //    78: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    81: athrow         
        //    82: new             Lgnu/mapping/WrongType;
        //    85: dup_x1         
        //    86: swap           
        //    87: ldc             "car"
        //    89: iconst_1       
        //    90: aload_3        
        //    91: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    94: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  21     24     69     82     Ljava/lang/ClassCastException;
        //  35     38     82     95     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static IntNum booleans$To$Integer$V(final Object[] argsArray) {
        final LList bools = LList.makeList(argsArray, 0);
        return list$To$Integer(bools);
    }
    
    static {
        Lit7 = Symbol.valueOf("booleans->integer");
        Lit6 = Symbol.valueOf("list->integer");
        Lit5 = Symbol.valueOf("integer->list");
        Lit4 = Symbol.valueOf("copy-bit");
        Lit3 = Symbol.valueOf("rotate-bit-field");
        Lit2 = Symbol.valueOf("copy-bit-field");
        Lit1 = Symbol.valueOf("logbit?");
        Lit0 = IntNum.valueOf(0);
        srfi60.$instance = new srfi60();
        arithmetic$Mnshift = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ashift");
        ash = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ashift");
        bitwise$Mnand = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "and");
        logand = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "and");
        bitwise$Mnior = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ior");
        logior = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ior");
        bitwise$Mnnot = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "not");
        lognot = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "not");
        bitwise$Mnxor = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "xor");
        logxor = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "xor");
        integer$Mnlength = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnlength");
        bitwise$Mnif = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnif");
        logtest = StaticFieldLocation.make("kawa.lib.numbers", "logtest");
        logcount = StaticFieldLocation.make("kawa.lib.numbers", "logcount");
        final srfi60 $instance = srfi60.$instance;
        logbit$Qu = new ModuleMethod($instance, 1, srfi60.Lit1, 8194);
        copy$Mnbit$Mnfield = new ModuleMethod($instance, 2, srfi60.Lit2, 16388);
        rotate$Mnbit$Mnfield = new ModuleMethod($instance, 3, srfi60.Lit3, 16388);
        copy$Mnbit = new ModuleMethod($instance, 4, srfi60.Lit4, 12291);
        integer$Mn$Grlist = new ModuleMethod($instance, 5, srfi60.Lit5, 8193);
        list$Mn$Grinteger = new ModuleMethod($instance, 7, srfi60.Lit6, 4097);
        booleans$Mn$Grinteger = new ModuleMethod($instance, 8, srfi60.Lit7, -4096);
        $runBody$();
    }
    
    public srfi60() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 7: {
                final Object force = Promise.force(arg1, LList.class);
                if (force instanceof LList) {
                    ctx.value1 = force;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 5: {
                final Object force2 = Promise.force(arg1, IntNum.class);
                if (IntNum.asIntNumOrNull(force2) != null) {
                    ctx.value1 = force2;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            default: {
                return super.match1(proc, arg1, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 5: {
                final Object force = Promise.force(arg1, IntNum.class);
                if (IntNum.asIntNumOrNull(force) != null) {
                    ctx.value1 = force;
                    ctx.value2 = Promise.force(arg2);
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 1: {
                ctx.value1 = Promise.force(arg1);
                final Object force2 = Promise.force(arg2, IntNum.class);
                if (IntNum.asIntNumOrNull(force2) != null) {
                    ctx.value2 = force2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            default: {
                return super.match2(proc, arg1, arg2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        if (moduleMethod.selector != 4) {
            return super.match3(moduleMethod, o, o2, o3, ctx);
        }
        ctx.value1 = Promise.force(o);
        final Object force = Promise.force(o2, IntNum.class);
        if (IntNum.asIntNumOrNull(force) == null) {
            return -786430;
        }
        ctx.value2 = force;
        final Object force2 = Promise.force(o3);
        if (force2 instanceof Boolean) {
            ctx.value3 = force2;
            ctx.proc = moduleMethod;
            ctx.pc = 3;
            return 0;
        }
        return -786429;
    }
    
    @Override
    public int match4(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        switch (proc.selector) {
            case 3: {
                final Object force = Promise.force(arg1, IntNum.class);
                if (IntNum.asIntNumOrNull(force) != null) {
                    ctx.value1 = force;
                    ctx.value2 = Promise.force(arg2);
                    ctx.value3 = Promise.force(arg3);
                    ctx.value4 = Promise.force(arg4);
                    ctx.proc = proc;
                    ctx.pc = 4;
                    return 0;
                }
                return -786431;
            }
            case 2: {
                final Object force2 = Promise.force(arg1, IntNum.class);
                if (IntNum.asIntNumOrNull(force2) == null) {
                    return -786431;
                }
                ctx.value1 = force2;
                final Object force3 = Promise.force(arg2, IntNum.class);
                if (IntNum.asIntNumOrNull(force3) != null) {
                    ctx.value2 = force3;
                    ctx.value3 = Promise.force(arg3);
                    ctx.value4 = Promise.force(arg4);
                    ctx.proc = proc;
                    ctx.pc = 4;
                    return 0;
                }
                return -786430;
            }
            default: {
                return super.match4(proc, arg1, arg2, arg3, arg4, ctx);
            }
        }
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        if (moduleMethod.selector == 8) {
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
        //               10: 32
        //               11: 58
        //               12: 45
        //          default: 58
        //        }
        //    32: aload_2        
        //    33: ldc             Lgnu/math/IntNum;.class
        //    35: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    38: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    41: invokestatic    gnu/kawa/slib/srfi60.integer$To$List:(Lgnu/math/IntNum;)Lgnu/lists/LList;
        //    44: areturn        
        //    45: aload_2        
        //    46: ldc             Lgnu/lists/LList;.class
        //    48: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    51: checkcast       Lgnu/lists/LList;
        //    54: invokestatic    gnu/kawa/slib/srfi60.list$To$Integer:(Lgnu/lists/LList;)Lgnu/math/IntNum;
        //    57: areturn        
        //    58: aload_0        
        //    59: aload_1        
        //    60: aload_2        
        //    61: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //    64: areturn        
        //    65: new             Lgnu/mapping/WrongType;
        //    68: dup_x1         
        //    69: swap           
        //    70: ldc_w           "integer->list"
        //    73: iconst_1       
        //    74: aload_2        
        //    75: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    78: athrow         
        //    79: new             Lgnu/mapping/WrongType;
        //    82: dup_x1         
        //    83: swap           
        //    84: ldc_w           "list->integer"
        //    87: iconst_1       
        //    88: aload_2        
        //    89: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    92: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  38     41     65     79     Ljava/lang/ClassCastException;
        //  51     54     79     93     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0058:
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
    
    @Override
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                2: 40
        //                3: 98
        //                4: 98
        //                5: 98
        //                6: 75
        //          default: 98
        //        }
        //    40: aload_2        
        //    41: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    44: checkcast       Ljava/lang/Number;
        //    47: invokevirtual   java/lang/Number.intValue:()I
        //    50: aload_3        
        //    51: ldc             Lgnu/math/IntNum;.class
        //    53: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    56: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    59: invokestatic    gnu/kawa/slib/srfi60.isLogbit:(ILgnu/math/IntNum;)Z
        //    62: ifeq            71
        //    65: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    68: goto            74
        //    71: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    74: areturn        
        //    75: aload_2        
        //    76: ldc             Lgnu/math/IntNum;.class
        //    78: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    81: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    84: aload_3        
        //    85: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    88: checkcast       Ljava/lang/Number;
        //    91: invokevirtual   java/lang/Number.intValue:()I
        //    94: invokestatic    gnu/kawa/slib/srfi60.integer$To$List:(Lgnu/math/IntNum;I)Lgnu/lists/LList;
        //    97: areturn        
        //    98: aload_0        
        //    99: aload_1        
        //   100: aload_2        
        //   101: aload_3        
        //   102: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   105: areturn        
        //   106: new             Lgnu/mapping/WrongType;
        //   109: dup_x1         
        //   110: swap           
        //   111: ldc_w           "logbit?"
        //   114: iconst_1       
        //   115: aload_2        
        //   116: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   119: athrow         
        //   120: new             Lgnu/mapping/WrongType;
        //   123: dup_x1         
        //   124: swap           
        //   125: ldc_w           "logbit?"
        //   128: iconst_2       
        //   129: aload_3        
        //   130: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   133: athrow         
        //   134: new             Lgnu/mapping/WrongType;
        //   137: dup_x1         
        //   138: swap           
        //   139: ldc_w           "integer->list"
        //   142: iconst_1       
        //   143: aload_2        
        //   144: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   147: athrow         
        //   148: new             Lgnu/mapping/WrongType;
        //   151: dup_x1         
        //   152: swap           
        //   153: ldc_w           "integer->list"
        //   156: iconst_2       
        //   157: aload_3        
        //   158: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   161: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  44     50     106    120    Ljava/lang/ClassCastException;
        //  56     59     120    134    Ljava/lang/ClassCastException;
        //  81     84     134    148    Ljava/lang/ClassCastException;
        //  88     94     148    162    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 65 out of bounds for length 65
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
        //     4: iconst_4       
        //     5: if_icmpne       50
        //     8: goto            11
        //    11: aload_2        
        //    12: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    15: checkcast       Ljava/lang/Number;
        //    18: invokevirtual   java/lang/Number.intValue:()I
        //    21: aload_3        
        //    22: ldc             Lgnu/math/IntNum;.class
        //    24: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    27: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    30: aload           4
        //    32: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    35: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    38: ifeq            45
        //    41: iconst_1       
        //    42: goto            46
        //    45: iconst_0       
        //    46: invokestatic    gnu/kawa/slib/srfi60.copyBit:(ILgnu/math/IntNum;Z)Lgnu/math/IntNum;
        //    49: areturn        
        //    50: aload_0        
        //    51: aload_1        
        //    52: aload_2        
        //    53: aload_3        
        //    54: aload           4
        //    56: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    59: areturn        
        //    60: new             Lgnu/mapping/WrongType;
        //    63: dup_x1         
        //    64: swap           
        //    65: ldc_w           "copy-bit"
        //    68: iconst_1       
        //    69: aload_2        
        //    70: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    73: athrow         
        //    74: new             Lgnu/mapping/WrongType;
        //    77: dup_x1         
        //    78: swap           
        //    79: ldc_w           "copy-bit"
        //    82: iconst_2       
        //    83: aload_3        
        //    84: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    87: athrow         
        //    88: new             Lgnu/mapping/WrongType;
        //    91: dup_x1         
        //    92: swap           
        //    93: ldc_w           "copy-bit"
        //    96: iconst_3       
        //    97: aload           4
        //    99: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   102: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  15     21     60     74     Ljava/lang/ClassCastException;
        //  27     30     74     88     Ljava/lang/ClassCastException;
        //  35     46     88     103    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 53 out of bounds for length 53
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
        //     4: tableswitch {
        //                4: 28
        //                5: 72
        //          default: 117
        //        }
        //    28: aload_2        
        //    29: ldc             Lgnu/math/IntNum;.class
        //    31: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    34: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    37: aload_3        
        //    38: ldc             Lgnu/math/IntNum;.class
        //    40: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    43: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    46: aload           4
        //    48: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    51: checkcast       Ljava/lang/Number;
        //    54: invokevirtual   java/lang/Number.intValue:()I
        //    57: aload           5
        //    59: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    62: checkcast       Ljava/lang/Number;
        //    65: invokevirtual   java/lang/Number.intValue:()I
        //    68: invokestatic    gnu/kawa/slib/srfi60.copyBitField:(Lgnu/math/IntNum;Lgnu/math/IntNum;II)Lgnu/math/IntNum;
        //    71: areturn        
        //    72: aload_2        
        //    73: ldc             Lgnu/math/IntNum;.class
        //    75: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    78: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    81: aload_3        
        //    82: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    85: checkcast       Ljava/lang/Number;
        //    88: invokevirtual   java/lang/Number.intValue:()I
        //    91: aload           4
        //    93: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    96: checkcast       Ljava/lang/Number;
        //    99: invokevirtual   java/lang/Number.intValue:()I
        //   102: aload           5
        //   104: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   107: checkcast       Ljava/lang/Number;
        //   110: invokevirtual   java/lang/Number.intValue:()I
        //   113: invokestatic    gnu/kawa/slib/srfi60.rotateBitField:(Lgnu/math/IntNum;III)Lgnu/math/IntNum;
        //   116: areturn        
        //   117: aload_0        
        //   118: aload_1        
        //   119: aload_2        
        //   120: aload_3        
        //   121: aload           4
        //   123: aload           5
        //   125: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   128: areturn        
        //   129: new             Lgnu/mapping/WrongType;
        //   132: dup_x1         
        //   133: swap           
        //   134: ldc_w           "copy-bit-field"
        //   137: iconst_1       
        //   138: aload_2        
        //   139: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   142: athrow         
        //   143: new             Lgnu/mapping/WrongType;
        //   146: dup_x1         
        //   147: swap           
        //   148: ldc_w           "copy-bit-field"
        //   151: iconst_2       
        //   152: aload_3        
        //   153: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   156: athrow         
        //   157: new             Lgnu/mapping/WrongType;
        //   160: dup_x1         
        //   161: swap           
        //   162: ldc_w           "copy-bit-field"
        //   165: iconst_3       
        //   166: aload           4
        //   168: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   171: athrow         
        //   172: new             Lgnu/mapping/WrongType;
        //   175: dup_x1         
        //   176: swap           
        //   177: ldc_w           "copy-bit-field"
        //   180: iconst_4       
        //   181: aload           5
        //   183: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   186: athrow         
        //   187: new             Lgnu/mapping/WrongType;
        //   190: dup_x1         
        //   191: swap           
        //   192: ldc_w           "rotate-bit-field"
        //   195: iconst_1       
        //   196: aload_2        
        //   197: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   200: athrow         
        //   201: new             Lgnu/mapping/WrongType;
        //   204: dup_x1         
        //   205: swap           
        //   206: ldc_w           "rotate-bit-field"
        //   209: iconst_2       
        //   210: aload_3        
        //   211: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   214: athrow         
        //   215: new             Lgnu/mapping/WrongType;
        //   218: dup_x1         
        //   219: swap           
        //   220: ldc_w           "rotate-bit-field"
        //   223: iconst_3       
        //   224: aload           4
        //   226: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   229: athrow         
        //   230: new             Lgnu/mapping/WrongType;
        //   233: dup_x1         
        //   234: swap           
        //   235: ldc_w           "rotate-bit-field"
        //   238: iconst_4       
        //   239: aload           5
        //   241: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   244: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  34     37     129    143    Ljava/lang/ClassCastException;
        //  43     46     143    157    Ljava/lang/ClassCastException;
        //  51     57     157    172    Ljava/lang/ClassCastException;
        //  62     68     172    187    Ljava/lang/ClassCastException;
        //  78     81     187    201    Ljava/lang/ClassCastException;
        //  85     91     201    215    Ljava/lang/ClassCastException;
        //  96     102    215    230    Ljava/lang/ClassCastException;
        //  107    113    230    245    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 111 out of bounds for length 111
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
    public Object applyN(final ModuleMethod method, final Object[] array) {
        if (method.selector == 8) {
            return booleans$To$Integer$V(array);
        }
        return super.applyN(method, array);
    }
}
