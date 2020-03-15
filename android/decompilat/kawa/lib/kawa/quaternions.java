// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.kawa;

import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.MultiplyOp;
import gnu.expr.Special;
import kawa.lib.exceptions;
import gnu.lists.LList;
import gnu.math.RealNum;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import kawa.lib.numbers;
import gnu.math.Quaternion;
import gnu.math.Complex;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class quaternions extends ModuleBody
{
    public static final StaticFieldLocation quaternion;
    public static final StaticFieldLocation quaternion$Qu;
    public static final StaticFieldLocation real$Mnpart;
    public static final StaticFieldLocation imag$Mnpart;
    public static final StaticFieldLocation jmag$Mnpart;
    public static final StaticFieldLocation kmag$Mnpart;
    public static final ModuleMethod complex$Mnpart;
    public static final ModuleMethod vector$Mnpart;
    public static final ModuleMethod unit$Mnquaternion;
    public static final StaticFieldLocation unit$Mnvector;
    public static final ModuleMethod vector$Mnquaternion$Qu;
    public static final ModuleMethod make$Mnvector$Mnquaternion;
    public static final ModuleMethod vector$Mnquaternion$Mn$Grlist;
    public static final StaticFieldLocation magnitude;
    public static final StaticFieldLocation angle;
    public static final ModuleMethod colatitude;
    public static final ModuleMethod longitude;
    public static final StaticFieldLocation make$Mnrectangular;
    public static final StaticFieldLocation make$Mnpolar;
    public static final StaticFieldLocation $Pl;
    public static final StaticFieldLocation $Mn;
    public static final StaticFieldLocation $St;
    public static final StaticFieldLocation $Sl;
    public static final ModuleMethod dot$Mnproduct;
    public static final ModuleMethod cross$Mnproduct;
    public static final ModuleMethod conjugate;
    public static final StaticFieldLocation exp;
    public static final StaticFieldLocation log;
    public static final StaticFieldLocation expt;
    public static final StaticFieldLocation sqrt;
    public static final StaticFieldLocation sin;
    public static final StaticFieldLocation cos;
    public static final StaticFieldLocation tan;
    public static final StaticFieldLocation asin;
    public static final StaticFieldLocation acos;
    public static final StaticFieldLocation atan;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final IntNum Lit2;
    static final DFloNum Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    public static quaternions $instance;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Complex complexPart(final Number x) {
        return (x instanceof Quaternion) ? ((Quaternion)x).complexPart() : x;
    }
    
    public static Quaternion vectorPart(final Number x) {
        return (x instanceof Quaternion) ? ((Quaternion)x).vectorPart() : quaternions.Lit0;
    }
    
    public static Number colatitude(final Number x) {
        return (x instanceof Quaternion) ? ((Quaternion)x).colatitude() : quaternions.Lit0;
    }
    
    public static Number longitude(final Number x) {
        return (x instanceof Quaternion) ? ((Quaternion)x).longitude() : quaternions.Lit0;
    }
    
    public static Number unitQuaternion(final Number x) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: instanceof      Lgnu/math/Quaternion;
        //     4: ifeq            17
        //     7: aload_0         /* x */
        //     8: checkcast       Lgnu/math/Quaternion;
        //    11: invokevirtual   gnu/math/Quaternion.unitQuaternion:()Lgnu/math/Quaternion;
        //    14: goto            104
        //    17: aload_0         /* x */
        //    18: instanceof      Lgnu/math/Quantity;
        //    21: ifeq            52
        //    24: aload_0         /* x */
        //    25: checkcast       Lgnu/math/Quantity;
        //    28: invokevirtual   gnu/math/Quantity.number:()Lgnu/math/Quaternion;
        //    31: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //    34: dup            
        //    35: astore_1       
        //    36: checkcast       Lgnu/math/Quaternion;
        //    39: aload_0         /* x */
        //    40: checkcast       Lgnu/math/Quantity;
        //    43: invokevirtual   gnu/math/Quantity.unit:()Lgnu/math/Unit;
        //    46: invokestatic    gnu/math/Quantity.make:(Lgnu/math/Quaternion;Lgnu/math/Unit;)Lgnu/math/Quantity;
        //    49: goto            104
        //    52: aload_0         /* x */
        //    53: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    56: ifeq            65
        //    59: getstatic       kawa/lib/kawa/quaternions.Lit0:Lgnu/math/IntNum;
        //    62: goto            104
        //    65: aload_0         /* x */
        //    66: dup            
        //    67: astore_1       
        //    68: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    71: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
        //    74: ifeq            83
        //    77: getstatic       kawa/lib/kawa/quaternions.Lit1:Lgnu/math/IntNum;
        //    80: goto            104
        //    83: aload_0         /* x */
        //    84: dup            
        //    85: astore_1       
        //    86: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    89: invokestatic    kawa/lib/numbers.isPositive:(Lgnu/math/RealNum;)Z
        //    92: ifeq            101
        //    95: getstatic       kawa/lib/kawa/quaternions.Lit2:Lgnu/math/IntNum;
        //    98: goto            104
        //   101: getstatic       kawa/lib/kawa/quaternions.Lit3:Lgnu/math/DFloNum;
        //   104: areturn        
        //   105: new             Lgnu/mapping/WrongType;
        //   108: dup_x1         
        //   109: swap           
        //   110: ldc             "gnu.math.Quantity.make(gnu.math.Quaternion,gnu.math.Unit)"
        //   112: iconst_1       
        //   113: aload_1        
        //   114: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   117: athrow         
        //   118: new             Lgnu/mapping/WrongType;
        //   121: dup_x1         
        //   122: swap           
        //   123: ldc             "negative?"
        //   125: iconst_1       
        //   126: aload_1        
        //   127: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   130: athrow         
        //   131: new             Lgnu/mapping/WrongType;
        //   134: dup_x1         
        //   135: swap           
        //   136: ldc             "positive?"
        //   138: iconst_1       
        //   139: aload_1        
        //   140: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   143: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  36     39     105    118    Ljava/lang/ClassCastException;
        //  68     71     118    131    Ljava/lang/ClassCastException;
        //  86     89     131    144    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 69 out of bounds for length 69
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
    
    public static boolean isVectorQuaternion(final Object o) {
        Label_0027: {
            if (!numbers.isQuaternion(o)) {
                break Label_0027;
            }
            final Object force = Promise.force(o, Number.class);
            try {
                return numbers.isZero(numbers.realPart((Number)force));
                zero = false;
                return zero;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "real-part", 1, force);
            }
        }
    }
    
    public static Quaternion makeVectorQuaternion(final RealNum x, final RealNum y, final RealNum z) {
        return (Quaternion)Promise.force(numbers.make$Mnrectangular.apply4(quaternions.Lit0, x, y, z), Quaternion.class);
    }
    
    public static LList vectorQuaternion$To$List(final Quaternion vec) {
        return LList.list3(numbers.imagPart(vec), numbers.jmagPart(vec), numbers.kmagPart(vec));
    }
    
    public static RealNum dotProduct(final Number x, final Number y) {
        if (!isVectorQuaternion(x) || !isVectorQuaternion(y)) {
            exceptions.error(quaternions.Lit4, "arguments must be vector quaternions");
            throw Special.reachedUnexpected;
        }
        return LangObjType.coerceRealNum(Promise.force(AddOp.apply2(1, AddOp.apply2(1, MultiplyOp.$St.apply2(numbers.imagPart(x), numbers.imagPart(y)), MultiplyOp.$St.apply2(numbers.jmagPart(x), numbers.jmagPart(y))), MultiplyOp.$St.apply2(numbers.kmagPart(x), numbers.kmagPart(y))), RealNum.class));
    }
    
    public static Quaternion crossProduct(final Number x, final Number y) {
        if (!isVectorQuaternion(x) || !isVectorQuaternion(y)) {
            exceptions.error(quaternions.Lit5, "arguments must be vector quaternions");
            throw Special.reachedUnexpected;
        }
        final Object force = Promise.force(MultiplyOp.$St.apply2(x, y), Number.class);
        try {
            return vectorPart((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "vector-part", 0, force);
        }
    }
    
    public static Number conjugate(final Number x) {
        return (x instanceof Quaternion) ? ((Quaternion)x).conjugate() : x;
    }
    
    static {
        Lit14 = Symbol.valueOf("conjugate");
        Lit13 = Symbol.valueOf("vector-quaternion->list");
        Lit12 = Symbol.valueOf("make-vector-quaternion");
        Lit11 = Symbol.valueOf("vector-quaternion?");
        Lit10 = Symbol.valueOf("unit-quaternion");
        Lit9 = Symbol.valueOf("longitude");
        Lit8 = Symbol.valueOf("colatitude");
        Lit7 = Symbol.valueOf("vector-part");
        Lit6 = Symbol.valueOf("complex-part");
        Lit5 = Symbol.valueOf("cross-product");
        Lit4 = Symbol.valueOf("dot-product");
        Lit3 = DFloNum.valueOf(Double.NaN);
        Lit2 = IntNum.valueOf(1);
        Lit1 = IntNum.valueOf(-1);
        Lit0 = IntNum.valueOf(0);
        quaternions.$instance = new quaternions();
        $Pl = StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Pl");
        $Mn = StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Mn");
        $Sl = StaticFieldLocation.make("gnu.kawa.functions.DivideOp", "$Sl");
        $St = StaticFieldLocation.make("gnu.kawa.functions.MultiplyOp", "$St");
        expt = StaticFieldLocation.make("kawa.standard.expt", "expt");
        quaternion = StaticFieldLocation.make("kawa.lib.numbers", "quaternion");
        quaternion$Qu = StaticFieldLocation.make("kawa.lib.numbers", "quaternion$Qu");
        real$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "real$Mnpart");
        imag$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "imag$Mnpart");
        jmag$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "jmag$Mnpart");
        kmag$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "kmag$Mnpart");
        unit$Mnvector = StaticFieldLocation.make("kawa.lib.numbers", "unit$Mnvector");
        magnitude = StaticFieldLocation.make("kawa.lib.numbers", "magnitude");
        angle = StaticFieldLocation.make("kawa.lib.numbers", "angle");
        make$Mnrectangular = StaticFieldLocation.make("kawa.lib.numbers", "make$Mnrectangular");
        make$Mnpolar = StaticFieldLocation.make("kawa.lib.numbers", "make$Mnpolar");
        exp = StaticFieldLocation.make("kawa.lib.numbers", "exp");
        log = StaticFieldLocation.make("kawa.lib.numbers", "log");
        sqrt = StaticFieldLocation.make("kawa.lib.numbers", "sqrt");
        sin = StaticFieldLocation.make("kawa.lib.numbers", "sin");
        cos = StaticFieldLocation.make("kawa.lib.numbers", "cos");
        tan = StaticFieldLocation.make("kawa.lib.numbers", "tan");
        asin = StaticFieldLocation.make("kawa.lib.numbers", "asin");
        acos = StaticFieldLocation.make("kawa.lib.numbers", "acos");
        atan = StaticFieldLocation.make("kawa.lib.numbers", "atan");
        final quaternions $instance = quaternions.$instance;
        complex$Mnpart = new ModuleMethod($instance, 1, quaternions.Lit6, 4097);
        vector$Mnpart = new ModuleMethod($instance, 2, quaternions.Lit7, 4097);
        colatitude = new ModuleMethod($instance, 3, quaternions.Lit8, 4097);
        longitude = new ModuleMethod($instance, 4, quaternions.Lit9, 4097);
        unit$Mnquaternion = new ModuleMethod($instance, 5, quaternions.Lit10, 4097);
        vector$Mnquaternion$Qu = new ModuleMethod($instance, 6, quaternions.Lit11, 4097);
        make$Mnvector$Mnquaternion = new ModuleMethod($instance, 7, quaternions.Lit12, 12291);
        vector$Mnquaternion$Mn$Grlist = new ModuleMethod($instance, 8, quaternions.Lit13, 4097);
        dot$Mnproduct = new ModuleMethod($instance, 9, quaternions.Lit4, 8194);
        cross$Mnproduct = new ModuleMethod($instance, 10, quaternions.Lit5, 8194);
        conjugate = new ModuleMethod($instance, 11, quaternions.Lit14, 4097);
        $runBody$();
    }
    
    public quaternions() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 11: {
                final Object force = Promise.force(arg1, Number.class);
                if (!(force instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 8: {
                final Object force2 = Promise.force(arg1, Quaternion.class);
                if (!(force2 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 6: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 5: {
                final Object force3 = Promise.force(arg1, Number.class);
                if (!(force3 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                final Object force4 = Promise.force(arg1, Number.class);
                if (!(force4 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 3: {
                final Object force5 = Promise.force(arg1, Number.class);
                if (!(force5 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                final Object force6 = Promise.force(arg1, Number.class);
                if (!(force6 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                final Object force7 = Promise.force(arg1, Number.class);
                if (!(force7 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force7;
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
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 10: {
                final Object force = Promise.force(arg1, Number.class);
                if (!(force instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2, Number.class);
                if (!(force2 instanceof Number)) {
                    return -786430;
                }
                ctx.value2 = force2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 9: {
                final Object force3 = Promise.force(arg1, Number.class);
                if (!(force3 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force3;
                final Object force4 = Promise.force(arg2, Number.class);
                if (!(force4 instanceof Number)) {
                    return -786430;
                }
                ctx.value2 = force4;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            default: {
                return super.match2(proc, arg1, arg2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        if (moduleMethod.selector != 7) {
            return super.match3(moduleMethod, o, o2, o3, ctx);
        }
        final Object force = Promise.force(o, RealNum.class);
        if (RealNum.asRealNumOrNull(force) == null) {
            return -786431;
        }
        ctx.value1 = force;
        final Object force2 = Promise.force(o2, RealNum.class);
        if (RealNum.asRealNumOrNull(force2) == null) {
            return -786430;
        }
        ctx.value2 = force2;
        final Object force3 = Promise.force(o3, RealNum.class);
        if (RealNum.asRealNumOrNull(force3) != null) {
            ctx.value3 = force3;
            ctx.proc = moduleMethod;
            ctx.pc = 3;
            return 0;
        }
        return -786429;
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
        //                2: 64
        //                3: 77
        //                4: 90
        //                5: 103
        //                6: 116
        //                7: 129
        //                8: 172
        //                9: 146
        //               10: 172
        //               11: 172
        //               12: 159
        //          default: 172
        //        }
        //    64: aload_2        
        //    65: ldc             Ljava/lang/Number;.class
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    70: checkcast       Ljava/lang/Number;
        //    73: invokestatic    kawa/lib/kawa/quaternions.complexPart:(Ljava/lang/Number;)Lgnu/math/Complex;
        //    76: areturn        
        //    77: aload_2        
        //    78: ldc             Ljava/lang/Number;.class
        //    80: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    83: checkcast       Ljava/lang/Number;
        //    86: invokestatic    kawa/lib/kawa/quaternions.vectorPart:(Ljava/lang/Number;)Lgnu/math/Quaternion;
        //    89: areturn        
        //    90: aload_2        
        //    91: ldc             Ljava/lang/Number;.class
        //    93: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    96: checkcast       Ljava/lang/Number;
        //    99: invokestatic    kawa/lib/kawa/quaternions.colatitude:(Ljava/lang/Number;)Ljava/lang/Number;
        //   102: areturn        
        //   103: aload_2        
        //   104: ldc             Ljava/lang/Number;.class
        //   106: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   109: checkcast       Ljava/lang/Number;
        //   112: invokestatic    kawa/lib/kawa/quaternions.longitude:(Ljava/lang/Number;)Ljava/lang/Number;
        //   115: areturn        
        //   116: aload_2        
        //   117: ldc             Ljava/lang/Number;.class
        //   119: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   122: checkcast       Ljava/lang/Number;
        //   125: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //   128: areturn        
        //   129: aload_2        
        //   130: invokestatic    kawa/lib/kawa/quaternions.isVectorQuaternion:(Ljava/lang/Object;)Z
        //   133: ifeq            142
        //   136: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   139: goto            145
        //   142: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   145: areturn        
        //   146: aload_2        
        //   147: ldc             Lgnu/math/Quaternion;.class
        //   149: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   152: checkcast       Lgnu/math/Quaternion;
        //   155: invokestatic    kawa/lib/kawa/quaternions.vectorQuaternion$To$List:(Lgnu/math/Quaternion;)Lgnu/lists/LList;
        //   158: areturn        
        //   159: aload_2        
        //   160: ldc             Ljava/lang/Number;.class
        //   162: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   165: checkcast       Ljava/lang/Number;
        //   168: invokestatic    kawa/lib/kawa/quaternions.conjugate:(Ljava/lang/Number;)Ljava/lang/Number;
        //   171: areturn        
        //   172: aload_0        
        //   173: aload_1        
        //   174: aload_2        
        //   175: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   178: areturn        
        //   179: new             Lgnu/mapping/WrongType;
        //   182: dup_x1         
        //   183: swap           
        //   184: ldc_w           "complex-part"
        //   187: iconst_1       
        //   188: aload_2        
        //   189: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   192: athrow         
        //   193: new             Lgnu/mapping/WrongType;
        //   196: dup_x1         
        //   197: swap           
        //   198: ldc             "vector-part"
        //   200: iconst_1       
        //   201: aload_2        
        //   202: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   205: athrow         
        //   206: new             Lgnu/mapping/WrongType;
        //   209: dup_x1         
        //   210: swap           
        //   211: ldc_w           "colatitude"
        //   214: iconst_1       
        //   215: aload_2        
        //   216: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   219: athrow         
        //   220: new             Lgnu/mapping/WrongType;
        //   223: dup_x1         
        //   224: swap           
        //   225: ldc_w           "longitude"
        //   228: iconst_1       
        //   229: aload_2        
        //   230: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   233: athrow         
        //   234: new             Lgnu/mapping/WrongType;
        //   237: dup_x1         
        //   238: swap           
        //   239: ldc_w           "unit-quaternion"
        //   242: iconst_1       
        //   243: aload_2        
        //   244: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   247: athrow         
        //   248: new             Lgnu/mapping/WrongType;
        //   251: dup_x1         
        //   252: swap           
        //   253: ldc_w           "vector-quaternion->list"
        //   256: iconst_1       
        //   257: aload_2        
        //   258: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   261: athrow         
        //   262: new             Lgnu/mapping/WrongType;
        //   265: dup_x1         
        //   266: swap           
        //   267: ldc_w           "conjugate"
        //   270: iconst_1       
        //   271: aload_2        
        //   272: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   275: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  70     73     179    193    Ljava/lang/ClassCastException;
        //  83     86     193    206    Ljava/lang/ClassCastException;
        //  96     99     206    220    Ljava/lang/ClassCastException;
        //  109    112    220    234    Ljava/lang/ClassCastException;
        //  122    125    234    248    Ljava/lang/ClassCastException;
        //  152    155    248    262    Ljava/lang/ClassCastException;
        //  165    168    262    276    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 113 out of bounds for length 113
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
        //     4: tableswitch {
        //               18: 28
        //               19: 50
        //          default: 72
        //        }
        //    28: aload_2        
        //    29: ldc             Ljava/lang/Number;.class
        //    31: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    34: checkcast       Ljava/lang/Number;
        //    37: aload_3        
        //    38: ldc             Ljava/lang/Number;.class
        //    40: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    43: checkcast       Ljava/lang/Number;
        //    46: invokestatic    kawa/lib/kawa/quaternions.dotProduct:(Ljava/lang/Number;Ljava/lang/Number;)Lgnu/math/RealNum;
        //    49: areturn        
        //    50: aload_2        
        //    51: ldc             Ljava/lang/Number;.class
        //    53: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    56: checkcast       Ljava/lang/Number;
        //    59: aload_3        
        //    60: ldc             Ljava/lang/Number;.class
        //    62: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    65: checkcast       Ljava/lang/Number;
        //    68: invokestatic    kawa/lib/kawa/quaternions.crossProduct:(Ljava/lang/Number;Ljava/lang/Number;)Lgnu/math/Quaternion;
        //    71: areturn        
        //    72: aload_0        
        //    73: aload_1        
        //    74: aload_2        
        //    75: aload_3        
        //    76: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    79: areturn        
        //    80: new             Lgnu/mapping/WrongType;
        //    83: dup_x1         
        //    84: swap           
        //    85: ldc_w           "dot-product"
        //    88: iconst_1       
        //    89: aload_2        
        //    90: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    93: athrow         
        //    94: new             Lgnu/mapping/WrongType;
        //    97: dup_x1         
        //    98: swap           
        //    99: ldc_w           "dot-product"
        //   102: iconst_2       
        //   103: aload_3        
        //   104: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   107: athrow         
        //   108: new             Lgnu/mapping/WrongType;
        //   111: dup_x1         
        //   112: swap           
        //   113: ldc_w           "cross-product"
        //   116: iconst_1       
        //   117: aload_2        
        //   118: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   121: athrow         
        //   122: new             Lgnu/mapping/WrongType;
        //   125: dup_x1         
        //   126: swap           
        //   127: ldc_w           "cross-product"
        //   130: iconst_2       
        //   131: aload_3        
        //   132: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   135: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  34     37     80     94     Ljava/lang/ClassCastException;
        //  43     46     94     108    Ljava/lang/ClassCastException;
        //  56     59     108    122    Ljava/lang/ClassCastException;
        //  65     68     122    136    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 61 out of bounds for length 61
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
        //     4: bipush          7
        //     6: if_icmpne       44
        //     9: goto            12
        //    12: aload_2        
        //    13: ldc             Lgnu/math/RealNum;.class
        //    15: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    18: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    21: aload_3        
        //    22: ldc             Lgnu/math/RealNum;.class
        //    24: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    27: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    30: aload           4
        //    32: ldc             Lgnu/math/RealNum;.class
        //    34: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    37: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    40: invokestatic    kawa/lib/kawa/quaternions.makeVectorQuaternion:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //    43: areturn        
        //    44: aload_0        
        //    45: aload_1        
        //    46: aload_2        
        //    47: aload_3        
        //    48: aload           4
        //    50: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    53: areturn        
        //    54: new             Lgnu/mapping/WrongType;
        //    57: dup_x1         
        //    58: swap           
        //    59: ldc_w           "make-vector-quaternion"
        //    62: iconst_1       
        //    63: aload_2        
        //    64: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    67: athrow         
        //    68: new             Lgnu/mapping/WrongType;
        //    71: dup_x1         
        //    72: swap           
        //    73: ldc_w           "make-vector-quaternion"
        //    76: iconst_2       
        //    77: aload_3        
        //    78: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    81: athrow         
        //    82: new             Lgnu/mapping/WrongType;
        //    85: dup_x1         
        //    86: swap           
        //    87: ldc_w           "make-vector-quaternion"
        //    90: iconst_3       
        //    91: aload           4
        //    93: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    96: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  18     21     54     68     Ljava/lang/ClassCastException;
        //  27     30     68     82     Ljava/lang/ClassCastException;
        //  37     40     82     97     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 50 out of bounds for length 50
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
