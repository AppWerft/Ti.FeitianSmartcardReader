// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.mapping.Values;
import gnu.expr.ModuleInfo;
import gnu.mapping.MethodProc;
import gnu.mapping.Symbol;
import gnu.math.Duration;
import gnu.math.Unit;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.functions.Format;
import gnu.lists.FString;
import gnu.math.BitOps;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.functions.GetNamedPart;
import gnu.math.Numeric;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.math.RatNum;
import gnu.math.RealNum;
import gnu.math.Complex;
import gnu.math.Quaternion;
import java.math.BigDecimal;
import java.math.BigInteger;
import gnu.math.Quantity;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.math.IntFraction;
import gnu.math.DFloNum;
import gnu.math.CComplex;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.expr.GenericProc;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class numbers extends ModuleBody
{
    public static final Class Double;
    public static final Class IntNum;
    public static final Class BitOps;
    public static final Class Numeric;
    public static final Class RatNum;
    public static final Class RealNum;
    public static final Class quaternion;
    public static final Class LangObjType;
    public static final ModuleMethod number$Qu;
    public static final ModuleMethod quantity$Qu;
    public static final ModuleMethod quaternion$Qu;
    public static final ModuleMethod complex$Qu;
    public static final ModuleMethod real$Qu;
    public static final ModuleMethod rational$Qu;
    public static final ModuleMethod integer$Qu;
    public static final ModuleMethod exact$Mninteger$Qu;
    public static final ModuleMethod real$Mnvalued$Qu;
    public static final ModuleMethod rational$Mnvalued$Qu;
    public static final ModuleMethod integer$Mnvalued$Qu;
    public static final ModuleMethod exact$Qu;
    public static final ModuleMethod inexact$Qu;
    public static final ModuleMethod zero$Qu;
    public static final ModuleMethod positive$Qu;
    public static final ModuleMethod negative$Qu;
    public static final ModuleMethod finite$Qu;
    public static final ModuleMethod infinite$Qu;
    public static final ModuleMethod nan$Qu;
    public static final ModuleMethod max;
    public static final ModuleMethod min;
    public static final ModuleMethod abs;
    public static final ModuleMethod floor$Sl;
    public static final ModuleMethod truncate$Sl;
    public static final ModuleMethod div$Mnand$Mnmod;
    public static final ModuleMethod div0$Mnand$Mnmod0;
    public static final ModuleMethod gcd;
    public static final ModuleMethod lcm;
    public static final ModuleMethod numerator;
    public static final ModuleMethod denominator;
    public static final ModuleMethod floor;
    public static final ModuleMethod ceiling;
    public static final ModuleMethod truncate;
    public static final ModuleMethod round;
    public static final ModuleMethod rationalize;
    public static final ModuleMethod exp;
    public static final GenericProc log;
    public static final GenericProc sin;
    public static final GenericProc cos;
    public static final GenericProc tan;
    public static final ModuleMethod asin;
    public static final ModuleMethod acos;
    public static final GenericProc atan;
    public static final GenericProc sinh;
    public static final GenericProc cosh;
    public static final GenericProc tanh;
    public static final GenericProc asinh;
    public static final GenericProc acosh;
    public static final GenericProc atanh;
    public static final ModuleMethod sqrt;
    public static final ModuleMethod square;
    public static final GenericProc make$Mnrectangular;
    public static final GenericProc make$Mnpolar;
    public static final ModuleMethod real$Mnpart;
    public static final ModuleMethod imag$Mnpart;
    public static final ModuleMethod jmag$Mnpart;
    public static final ModuleMethod kmag$Mnpart;
    public static final ModuleMethod unit$Mnvector;
    public static final ModuleMethod magnitude;
    public static final ModuleMethod angle;
    public static final ModuleMethod inexact;
    public static final ModuleMethod exact;
    public static final ModuleMethod exact$Mn$Grinexact;
    public static final ModuleMethod inexact$Mn$Grexact;
    public static final ModuleMethod logop;
    public static final ModuleMethod bitwise$Mnbit$Mnset$Qu;
    public static final ModuleMethod bitwise$Mncopy$Mnbit;
    public static final ModuleMethod bitwise$Mncopy$Mnbit$Mnfield;
    public static final ModuleMethod bitwise$Mnbit$Mnfield;
    public static final ModuleMethod bitwise$Mnif;
    public static final ModuleMethod logtest;
    public static final ModuleMethod logcount;
    public static final ModuleMethod bitwise$Mnbit$Mncount;
    public static final ModuleMethod bitwise$Mnlength;
    public static final ModuleMethod bitwise$Mnfirst$Mnbit$Mnset;
    public static final ModuleMethod bitwise$Mnrotate$Mnbit$Mnfield;
    public static final ModuleMethod bitwise$Mnreverse$Mnbit$Mnfield;
    public static final ModuleMethod number$Mn$Grstring;
    public static final ModuleMethod string$Mn$Grnumber;
    public static final ModuleMethod quantity$Mn$Grnumber;
    public static final ModuleMethod quantity$Mn$Grunit;
    public static final ModuleMethod make$Mnquantity;
    public static final ModuleMethod duration;
    public static final ModuleMethod exact$Mninteger$Mnsqrt;
    static final IntNum Lit0;
    static final SimpleSymbol Lit1;
    static final IntNum Lit2;
    static final IntNum Lit3;
    static final CComplex Lit4;
    static final DFloNum Lit5;
    public static numbers $instance;
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
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final SimpleSymbol Lit38;
    static final SimpleSymbol Lit39;
    static final SimpleSymbol Lit40;
    static final SimpleSymbol Lit41;
    static final SimpleSymbol Lit42;
    static final SimpleSymbol Lit43;
    static final IntFraction Lit44;
    static final IntNum Lit45;
    static final SimpleSymbol Lit46;
    static final SimpleSymbol Lit47;
    static final SimpleSymbol Lit48;
    static final SimpleSymbol Lit49;
    static final SimpleSymbol Lit50;
    static final SimpleSymbol Lit51;
    static final SimpleSymbol Lit52;
    static final SimpleSymbol Lit53;
    static final SimpleSymbol Lit54;
    static final SimpleSymbol Lit55;
    static final SimpleSymbol Lit56;
    static final SimpleSymbol Lit57;
    static final SimpleSymbol Lit58;
    static final SimpleSymbol Lit59;
    static final SimpleSymbol Lit60;
    static final SimpleSymbol Lit61;
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final SimpleSymbol Lit64;
    static final SimpleSymbol Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final SimpleSymbol Lit73;
    static final SimpleSymbol Lit74;
    static final SimpleSymbol Lit75;
    static final SimpleSymbol Lit76;
    static final SimpleSymbol Lit77;
    static final SimpleSymbol Lit78;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static boolean isNumber(final Object x) {
        return x instanceof Number;
    }
    
    public static boolean isQuantity(final Object x) {
        final boolean x2 = x instanceof Quantity;
        return x2 ? x2 : isJava$DtLang$DtReal(x);
    }
    
    static boolean isJava$DtLang$DtReal(final Object x) {
        boolean b;
        if (x instanceof Number) {
            final boolean x2 = x instanceof Long;
            if (x2) {
                b = x2;
            }
            else {
                final boolean x3 = x instanceof Integer;
                if (x3) {
                    b = x3;
                }
                else {
                    final boolean x4 = x instanceof Short;
                    if (x4) {
                        b = x4;
                    }
                    else {
                        final boolean x5 = x instanceof Byte;
                        if (x5) {
                            b = x5;
                        }
                        else {
                            final boolean x6 = x instanceof Double;
                            if (x6) {
                                b = x6;
                            }
                            else {
                                final boolean x7 = x instanceof Float;
                                if (x7) {
                                    b = x7;
                                }
                                else {
                                    final boolean x8 = x instanceof BigInteger;
                                    b = (x8 ? x8 : (x instanceof BigDecimal));
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    public static boolean isQuaternion(final Object x) {
        final boolean x2 = x instanceof Quaternion;
        return x2 ? x2 : isJava$DtLang$DtReal(x);
    }
    
    public static boolean isComplex(final Object x) {
        final boolean x2 = x instanceof Complex;
        return x2 ? x2 : isJava$DtLang$DtReal(x);
    }
    
    public static boolean isReal(final Object x) {
        final boolean x2 = gnu.math.RealNum.asRealNumOrNull(x) != null;
        return x2 ? x2 : isJava$DtLang$DtReal(x);
    }
    
    public static boolean isRational(final Object x) {
        final boolean x2 = gnu.math.RatNum.asRatNumOrNull(x) != null;
        boolean b;
        if (x2) {
            b = x2;
        }
        else if (x instanceof Number) {
            final boolean x3 = x instanceof Long;
            if (x3) {
                b = x3;
            }
            else {
                final boolean x4 = x instanceof Integer;
                if (x4) {
                    b = x4;
                }
                else {
                    final boolean x5 = x instanceof Short;
                    if (x5) {
                        b = x5;
                    }
                    else {
                        final boolean x6 = x instanceof Byte;
                        if (x6) {
                            b = x6;
                        }
                        else {
                            final boolean x7 = x instanceof BigInteger;
                            b = (x7 ? x7 : (x instanceof BigDecimal));
                        }
                    }
                }
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    public static boolean isInteger(final Object x) {
        final boolean x2 = x instanceof IntNum;
        if (x2) {
            return x2;
        }
        Label_0215: {
            if (!(x instanceof Number)) {
                break Label_0215;
            }
            final boolean x3 = x instanceof Long;
            Label_0101: {
                if (x3) {
                    if (!x3) {
                        break Label_0101;
                    }
                }
                else {
                    final boolean x4 = x instanceof Integer;
                    if (x4) {
                        if (!x4) {
                            break Label_0101;
                        }
                    }
                    else {
                        final boolean x5 = x instanceof Short;
                        if (x5) {
                            if (!x5) {
                                break Label_0101;
                            }
                        }
                        else {
                            final boolean x6 = x instanceof Byte;
                            if (x6) {
                                if (!x6) {
                                    break Label_0101;
                                }
                            }
                            else if (!(x instanceof BigInteger)) {
                                break Label_0101;
                            }
                        }
                    }
                }
                return true;
            }
            final boolean x4 = x instanceof DFloNum;
            Label_0175: {
                if (x4) {
                    if (!x4) {
                        break Label_0175;
                    }
                }
                else {
                    final boolean x5 = x instanceof Float;
                    if (x5) {
                        if (!x5) {
                            break Label_0175;
                        }
                    }
                    else if (!(x instanceof Double)) {
                        break Label_0175;
                    }
                }
                final Object force = Promise.force(x, Number.class);
                try {
                    return Math.IEEEremainder(((Number)force).doubleValue(), 1.0) == 0.0;
                    boolean b2 = false;
                    b = b2;
                    return b;
                    // iftrue(Label_0211:, !x instanceof BigDecimal)
                    Block_18: {
                        break Block_18;
                        Label_0211: {
                            b = false;
                        }
                        return b;
                    }
                    try {
                        ((BigDecimal)Promise.force(x, BigDecimal.class)).toBigIntegerExact();
                        b2 = true;
                    }
                    catch (ArithmeticException ex) {
                        b2 = false;
                    }
                    return b2;
                    b = false;
                    return b;
                }
                catch (ClassCastException ex2) {
                    throw new WrongType(ex2, "java.lang.Number.doubleValue()", 1, force);
                }
            }
        }
    }
    
    public static boolean isExactInteger(final Object x) {
        final boolean x2 = x instanceof IntNum;
        boolean b;
        if (x2) {
            b = x2;
        }
        else if (x instanceof Number) {
            final boolean x3 = x instanceof Long;
            if (x3) {
                b = x3;
            }
            else {
                final boolean x4 = x instanceof Integer;
                if (x4) {
                    b = x4;
                }
                else {
                    final boolean x5 = x instanceof Short;
                    if (x5) {
                        b = x5;
                    }
                    else {
                        final boolean x6 = x instanceof Byte;
                        b = (x6 ? x6 : (x instanceof BigInteger));
                    }
                }
            }
        }
        else {
            b = false;
        }
        return b;
    }
    
    public static boolean isRealValued(final Object x) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/numbers.isQuaternion:(Ljava/lang/Object;)Z
        //     4: ifeq            99
        //     7: aload_0         /* x */
        //     8: ldc             Ljava/lang/Number;.class
        //    10: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    13: dup            
        //    14: astore_1       
        //    15: checkcast       Ljava/lang/Number;
        //    18: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    21: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    24: ifeq            95
        //    27: aload_0         /* x */
        //    28: ldc             Ljava/lang/Number;.class
        //    30: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    33: dup            
        //    34: astore_1       
        //    35: checkcast       Ljava/lang/Number;
        //    38: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    41: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    44: ifeq            91
        //    47: aload_0         /* x */
        //    48: ldc             Ljava/lang/Number;.class
        //    50: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    53: dup            
        //    54: astore_1       
        //    55: checkcast       Ljava/lang/Number;
        //    58: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    61: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    64: ifeq            87
        //    67: aload_0         /* x */
        //    68: ldc             Ljava/lang/Number;.class
        //    70: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    73: dup            
        //    74: astore_1       
        //    75: checkcast       Ljava/lang/Number;
        //    78: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    81: invokestatic    kawa/lib/numbers.isReal:(Ljava/lang/Object;)Z
        //    84: goto            100
        //    87: iconst_0       
        //    88: goto            100
        //    91: iconst_0       
        //    92: goto            100
        //    95: iconst_0       
        //    96: goto            100
        //    99: iconst_0       
        //   100: ireturn        
        //   101: new             Lgnu/mapping/WrongType;
        //   104: dup_x1         
        //   105: swap           
        //   106: ldc             "imag-part"
        //   108: iconst_0       
        //   109: aload_1        
        //   110: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   113: athrow         
        //   114: new             Lgnu/mapping/WrongType;
        //   117: dup_x1         
        //   118: swap           
        //   119: ldc             "jmag-part"
        //   121: iconst_0       
        //   122: aload_1        
        //   123: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   126: athrow         
        //   127: new             Lgnu/mapping/WrongType;
        //   130: dup_x1         
        //   131: swap           
        //   132: ldc             "kmag-part"
        //   134: iconst_0       
        //   135: aload_1        
        //   136: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   139: athrow         
        //   140: new             Lgnu/mapping/WrongType;
        //   143: dup_x1         
        //   144: swap           
        //   145: ldc             "real-part"
        //   147: iconst_0       
        //   148: aload_1        
        //   149: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   152: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  15     18     101    114    Ljava/lang/ClassCastException;
        //  35     38     114    127    Ljava/lang/ClassCastException;
        //  55     58     127    140    Ljava/lang/ClassCastException;
        //  75     78     140    153    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 79 out of bounds for length 79
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
    
    public static boolean isZero(final Number x) {
        return (x instanceof Numeric) ? ((Numeric)x).isZero() : ((x instanceof BigInteger) ? NumberCompare.$Eq(numbers.Lit0, GetNamedPart.getNamedPart.apply2(x, numbers.Lit1)) : ((x instanceof BigDecimal) ? NumberCompare.$Eq(numbers.Lit0, GetNamedPart.getNamedPart.apply2(x, numbers.Lit1)) : (x.doubleValue() == 0.0)));
    }
    
    public static Number imagPart(final Number x) {
        return (x instanceof Quaternion) ? ((Quaternion)x).im() : gnu.math.IntNum.zero();
    }
    
    public static Number jmagPart(final Number x) {
        return (x instanceof Quaternion) ? ((Quaternion)x).jm() : gnu.math.IntNum.zero();
    }
    
    public static Number kmagPart(final Number x) {
        return (x instanceof Quaternion) ? ((Quaternion)x).km() : gnu.math.IntNum.zero();
    }
    
    public static Number realPart(final Number x) {
        return (x instanceof Quaternion) ? ((Quaternion)x).re() : x;
    }
    
    public static boolean isRationalValued(final Object x) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/numbers.isQuaternion:(Ljava/lang/Object;)Z
        //     4: ifeq            99
        //     7: aload_0         /* x */
        //     8: ldc             Ljava/lang/Number;.class
        //    10: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    13: dup            
        //    14: astore_1       
        //    15: checkcast       Ljava/lang/Number;
        //    18: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    21: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    24: ifeq            95
        //    27: aload_0         /* x */
        //    28: ldc             Ljava/lang/Number;.class
        //    30: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    33: dup            
        //    34: astore_1       
        //    35: checkcast       Ljava/lang/Number;
        //    38: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    41: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    44: ifeq            91
        //    47: aload_0         /* x */
        //    48: ldc             Ljava/lang/Number;.class
        //    50: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    53: dup            
        //    54: astore_1       
        //    55: checkcast       Ljava/lang/Number;
        //    58: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    61: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    64: ifeq            87
        //    67: aload_0         /* x */
        //    68: ldc             Ljava/lang/Number;.class
        //    70: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    73: dup            
        //    74: astore_1       
        //    75: checkcast       Ljava/lang/Number;
        //    78: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    81: invokestatic    kawa/lib/numbers.isRational:(Ljava/lang/Object;)Z
        //    84: goto            100
        //    87: iconst_0       
        //    88: goto            100
        //    91: iconst_0       
        //    92: goto            100
        //    95: iconst_0       
        //    96: goto            100
        //    99: iconst_0       
        //   100: ireturn        
        //   101: new             Lgnu/mapping/WrongType;
        //   104: dup_x1         
        //   105: swap           
        //   106: ldc             "imag-part"
        //   108: iconst_0       
        //   109: aload_1        
        //   110: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   113: athrow         
        //   114: new             Lgnu/mapping/WrongType;
        //   117: dup_x1         
        //   118: swap           
        //   119: ldc             "jmag-part"
        //   121: iconst_0       
        //   122: aload_1        
        //   123: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   126: athrow         
        //   127: new             Lgnu/mapping/WrongType;
        //   130: dup_x1         
        //   131: swap           
        //   132: ldc             "kmag-part"
        //   134: iconst_0       
        //   135: aload_1        
        //   136: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   139: athrow         
        //   140: new             Lgnu/mapping/WrongType;
        //   143: dup_x1         
        //   144: swap           
        //   145: ldc             "real-part"
        //   147: iconst_0       
        //   148: aload_1        
        //   149: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   152: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  15     18     101    114    Ljava/lang/ClassCastException;
        //  35     38     114    127    Ljava/lang/ClassCastException;
        //  55     58     127    140    Ljava/lang/ClassCastException;
        //  75     78     140    153    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 79 out of bounds for length 79
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
    
    public static boolean isIntegerValued(final Object x) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/numbers.isQuaternion:(Ljava/lang/Object;)Z
        //     4: ifeq            99
        //     7: aload_0         /* x */
        //     8: ldc             Ljava/lang/Number;.class
        //    10: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    13: dup            
        //    14: astore_1       
        //    15: checkcast       Ljava/lang/Number;
        //    18: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    21: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    24: ifeq            95
        //    27: aload_0         /* x */
        //    28: ldc             Ljava/lang/Number;.class
        //    30: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    33: dup            
        //    34: astore_1       
        //    35: checkcast       Ljava/lang/Number;
        //    38: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    41: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    44: ifeq            91
        //    47: aload_0         /* x */
        //    48: ldc             Ljava/lang/Number;.class
        //    50: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    53: dup            
        //    54: astore_1       
        //    55: checkcast       Ljava/lang/Number;
        //    58: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    61: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //    64: ifeq            87
        //    67: aload_0         /* x */
        //    68: ldc             Ljava/lang/Number;.class
        //    70: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    73: dup            
        //    74: astore_1       
        //    75: checkcast       Ljava/lang/Number;
        //    78: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    81: invokestatic    kawa/lib/numbers.isInteger:(Ljava/lang/Object;)Z
        //    84: goto            100
        //    87: iconst_0       
        //    88: goto            100
        //    91: iconst_0       
        //    92: goto            100
        //    95: iconst_0       
        //    96: goto            100
        //    99: iconst_0       
        //   100: ireturn        
        //   101: new             Lgnu/mapping/WrongType;
        //   104: dup_x1         
        //   105: swap           
        //   106: ldc             "imag-part"
        //   108: iconst_0       
        //   109: aload_1        
        //   110: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   113: athrow         
        //   114: new             Lgnu/mapping/WrongType;
        //   117: dup_x1         
        //   118: swap           
        //   119: ldc             "jmag-part"
        //   121: iconst_0       
        //   122: aload_1        
        //   123: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   126: athrow         
        //   127: new             Lgnu/mapping/WrongType;
        //   130: dup_x1         
        //   131: swap           
        //   132: ldc             "kmag-part"
        //   134: iconst_0       
        //   135: aload_1        
        //   136: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   139: athrow         
        //   140: new             Lgnu/mapping/WrongType;
        //   143: dup_x1         
        //   144: swap           
        //   145: ldc             "real-part"
        //   147: iconst_0       
        //   148: aload_1        
        //   149: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   152: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  15     18     101    114    Ljava/lang/ClassCastException;
        //  35     38     114    127    Ljava/lang/ClassCastException;
        //  55     58     127    140    Ljava/lang/ClassCastException;
        //  75     78     140    153    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 79 out of bounds for length 79
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
    
    public static boolean isExact(final Object x) {
        return x instanceof Number && Arithmetic.isExact((Number)Promise.force(x, Number.class));
    }
    
    public static boolean isInexact(final Object x) {
        return x instanceof Number && !Arithmetic.isExact((Number)Promise.force(x, Number.class));
    }
    
    public static boolean isPositive(final RealNum x) {
        return x.sign() > 0;
    }
    
    public static boolean isNegative(final RealNum x) {
        return x.isNegative();
    }
    
    public static boolean isFinite(final Number z) {
        boolean b;
        if (z instanceof Quaternion) {
            b = (((Quaternion)z).classifyFinite() > 0);
        }
        else if (isJava$DtLang$DtReal(z)) {
            final double d = z.doubleValue();
            b = (!java.lang.Double.isInfinite(d) && !java.lang.Double.isNaN(d));
        }
        else {
            b = false;
        }
        return b;
    }
    
    public static boolean isInfinite(final Number z) {
        Label_0107: {
            if (!(z instanceof Quaternion)) {
                break Label_0107;
            }
            try {
                final Quaternion zc = (Quaternion)z;
                final boolean x = zc.re().classifyFinite() == 0;
                boolean infinite;
                if (x) {
                    infinite = x;
                }
                else {
                    final boolean x2 = zc.im().classifyFinite() == 0;
                    if (x2) {
                        infinite = x2;
                    }
                    else {
                        final boolean x3 = zc.jm().classifyFinite() == 0;
                        infinite = (x3 ? x3 : (zc.km().classifyFinite() == 0));
                    }
                }
                return infinite;
                Label_0126: {
                    infinite = false;
                }
                return infinite;
                while (true) {
                    final double d = z.doubleValue();
                    infinite = java.lang.Double.isInfinite(d);
                    return infinite;
                    continue;
                }
            }
            // iftrue(Label_0126:, !isJava$DtLang$DtReal((Object)z))
            catch (ClassCastException ex) {
                throw new WrongType(ex, "zc", -2, z);
            }
        }
    }
    
    public static boolean isNan(final Number z) {
        boolean naN;
        if (z instanceof Quaternion) {
            naN = (((Quaternion)z).classifyFinite() < 0);
        }
        else if (isJava$DtLang$DtReal(z)) {
            final double d = z.doubleValue();
            naN = java.lang.Double.isNaN(d);
        }
        else {
            naN = false;
        }
        return naN;
    }
    
    public static Object max(final Object... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: istore_1       
        //     3: aload_0         /* args */
        //     4: iconst_0       
        //     5: aaload         
        //     6: ldc             Lgnu/math/RealNum;.class
        //     8: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    11: dup            
        //    12: astore_3       
        //    13: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    16: astore_2        /* result */
        //    17: iconst_1       
        //    18: istore_3        /* i */
        //    19: iload_3         /* i */
        //    20: iload_1         /* n */
        //    21: if_icmpge       49
        //    24: aload_2         /* result */
        //    25: aload_0         /* args */
        //    26: iload_3         /* i */
        //    27: aaload         
        //    28: ldc             Lgnu/math/RealNum;.class
        //    30: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    33: dup            
        //    34: astore          4
        //    36: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    39: invokevirtual   gnu/math/RealNum.max:(Lgnu/math/RealNum;)Lgnu/math/RealNum;
        //    42: astore_2        /* result */
        //    43: iinc            i, 1
        //    46: goto            19
        //    49: aload_2         /* result */
        //    50: areturn        
        //    51: new             Lgnu/mapping/WrongType;
        //    54: dup_x1         
        //    55: swap           
        //    56: ldc             "result"
        //    58: bipush          -2
        //    60: aload_3        
        //    61: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    64: athrow         
        //    65: new             Lgnu/mapping/WrongType;
        //    68: dup_x1         
        //    69: swap           
        //    70: ldc             "gnu.math.RealNum.max(real)"
        //    72: iconst_2       
        //    73: aload           4
        //    75: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    78: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  13     16     51     65     Ljava/lang/ClassCastException;
        //  36     39     65     79     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object min(final Object... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: istore_1       
        //     3: aload_0         /* args */
        //     4: iconst_0       
        //     5: aaload         
        //     6: ldc             Lgnu/math/RealNum;.class
        //     8: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    11: dup            
        //    12: astore_3       
        //    13: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    16: astore_2        /* result */
        //    17: iconst_0       
        //    18: istore_3        /* i */
        //    19: iload_3         /* i */
        //    20: iload_1         /* n */
        //    21: if_icmpge       49
        //    24: aload_2         /* result */
        //    25: aload_0         /* args */
        //    26: iload_3         /* i */
        //    27: aaload         
        //    28: ldc             Lgnu/math/RealNum;.class
        //    30: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    33: dup            
        //    34: astore          4
        //    36: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    39: invokevirtual   gnu/math/RealNum.min:(Lgnu/math/RealNum;)Lgnu/math/RealNum;
        //    42: astore_2        /* result */
        //    43: iinc            i, 1
        //    46: goto            19
        //    49: aload_2         /* result */
        //    50: areturn        
        //    51: new             Lgnu/mapping/WrongType;
        //    54: dup_x1         
        //    55: swap           
        //    56: ldc             "result"
        //    58: bipush          -2
        //    60: aload_3        
        //    61: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    64: athrow         
        //    65: new             Lgnu/mapping/WrongType;
        //    68: dup_x1         
        //    69: swap           
        //    70: ldc             "gnu.math.RealNum.min(real)"
        //    72: iconst_2       
        //    73: aload           4
        //    75: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    78: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  13     16     51     65     Ljava/lang/ClassCastException;
        //  36     39     65     79     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Number abs(final Number x) {
        return (x instanceof Numeric) ? ((Numeric)x).abs() : (NumberCompare.$Gr$Eq(x, numbers.Lit0) ? x : Promise.force(AddOp.$Mn.apply1(x), Number.class));
    }
    
    public static Object floor$Sl(final RealNum x, final RealNum y) {
        final Object force = Promise.force(DivideOp.floorQuotient.apply2(x, y), RealNum.class);
        RealNum q;
        Object force2;
        Object o;
        try {
            q = gnu.kawa.lispexpr.LangObjType.coerceRealNum(force);
            o = (force2 = Promise.force(AddOp.apply2(-1, x, MultiplyOp.$St.apply2(q, y)), RealNum.class));
            final RealNum r = gnu.kawa.lispexpr.LangObjType.coerceRealNum(o);
            final int n = 2;
            final Object[] array = new Object[n];
            final int n2 = 0;
            final RealNum realNum = q;
            array[n2] = realNum;
            final int n3 = 1;
            final RealNum realNum2 = r;
            array[n3] = realNum2;
            return misc.values(array);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "q", -2, force);
        }
        try {
            final RealNum r = gnu.kawa.lispexpr.LangObjType.coerceRealNum(o);
            final int n = 2;
            final Object[] array = new Object[n];
            final int n2 = 0;
            final RealNum realNum = q;
            array[n2] = realNum;
            final int n3 = 1;
            final RealNum realNum2 = r;
            array[n3] = realNum2;
            return misc.values(array);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "r", -2, force2);
        }
    }
    
    public static Object truncate$Sl(final RealNum x, final RealNum y) {
        final Object force = Promise.force(DivideOp.quotient.apply2(x, y), RealNum.class);
        RealNum q;
        Object force2;
        Object o;
        try {
            q = gnu.kawa.lispexpr.LangObjType.coerceRealNum(force);
            o = (force2 = Promise.force(AddOp.apply2(-1, x, MultiplyOp.$St.apply2(q, y)), RealNum.class));
            final RealNum r = gnu.kawa.lispexpr.LangObjType.coerceRealNum(o);
            final int n = 2;
            final Object[] array = new Object[n];
            final int n2 = 0;
            final RealNum realNum = q;
            array[n2] = realNum;
            final int n3 = 1;
            final RealNum realNum2 = r;
            array[n3] = realNum2;
            return misc.values(array);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "q", -2, force);
        }
        try {
            final RealNum r = gnu.kawa.lispexpr.LangObjType.coerceRealNum(o);
            final int n = 2;
            final Object[] array = new Object[n];
            final int n2 = 0;
            final RealNum realNum = q;
            array[n2] = realNum;
            final int n3 = 1;
            final RealNum realNum2 = r;
            array[n3] = realNum2;
            return misc.values(array);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "r", -2, force2);
        }
    }
    
    public static Object divAndMod(final RealNum x, final RealNum y) {
        final Object force = Promise.force(DivideOp.div.apply2(x, y), RealNum.class);
        RealNum q;
        Object force2;
        Object o;
        try {
            q = gnu.kawa.lispexpr.LangObjType.coerceRealNum(force);
            o = (force2 = Promise.force(AddOp.apply2(-1, x, MultiplyOp.$St.apply2(q, y)), RealNum.class));
            final RealNum r = gnu.kawa.lispexpr.LangObjType.coerceRealNum(o);
            final int n = 2;
            final Object[] array = new Object[n];
            final int n2 = 0;
            final RealNum realNum = q;
            array[n2] = realNum;
            final int n3 = 1;
            final RealNum realNum2 = r;
            array[n3] = realNum2;
            return misc.values(array);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "q", -2, force);
        }
        try {
            final RealNum r = gnu.kawa.lispexpr.LangObjType.coerceRealNum(o);
            final int n = 2;
            final Object[] array = new Object[n];
            final int n2 = 0;
            final RealNum realNum = q;
            array[n2] = realNum;
            final int n3 = 1;
            final RealNum realNum2 = r;
            array[n3] = realNum2;
            return misc.values(array);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "r", -2, force2);
        }
    }
    
    public static Object div0AndMod0(final RealNum x, final RealNum y) {
        final Object force = Promise.force(DivideOp.div0.apply2(x, y), RealNum.class);
        RealNum q;
        Object force2;
        Object o;
        try {
            q = gnu.kawa.lispexpr.LangObjType.coerceRealNum(force);
            o = (force2 = Promise.force(AddOp.apply2(-1, x, MultiplyOp.$St.apply2(q, y)), RealNum.class));
            final RealNum r = gnu.kawa.lispexpr.LangObjType.coerceRealNum(o);
            final int n = 2;
            final Object[] array = new Object[n];
            final int n2 = 0;
            final RealNum realNum = q;
            array[n2] = realNum;
            final int n3 = 1;
            final RealNum realNum2 = r;
            array[n3] = realNum2;
            return misc.values(array);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "q", -2, force);
        }
        try {
            final RealNum r = gnu.kawa.lispexpr.LangObjType.coerceRealNum(o);
            final int n = 2;
            final Object[] array = new Object[n];
            final int n2 = 0;
            final RealNum realNum = q;
            array[n2] = realNum;
            final int n3 = 1;
            final RealNum realNum2 = r;
            array[n3] = realNum2;
            return misc.values(array);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "r", -2, force2);
        }
    }
    
    public static RealNum gcd(final RealNum... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: istore_1       
        //     3: iconst_0       
        //     4: istore_2       
        //     5: getstatic       kawa/lib/numbers.Lit0:Lgnu/math/IntNum;
        //     8: astore_3        /* result */
        //     9: iconst_0       
        //    10: istore          i
        //    12: iload           i
        //    14: iload_1         /* n */
        //    15: if_icmpge       85
        //    18: aload_0         /* args */
        //    19: iload           i
        //    21: aaload         
        //    22: astore          val
        //    24: aload           val
        //    26: invokestatic    kawa/lib/numbers.isInexact:(Ljava/lang/Object;)Z
        //    29: istore          cur$Mninexact
        //    31: iload           cur$Mninexact
        //    33: ifeq            52
        //    36: iconst_1       
        //    37: istore_2        /* result$Mninexact */
        //    38: aload           val
        //    40: invokestatic    kawa/lib/numbers.exact:(Ljava/lang/Number;)Ljava/lang/Number;
        //    43: dup            
        //    44: astore          8
        //    46: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    49: goto            60
        //    52: aload           val
        //    54: dup            
        //    55: astore          8
        //    57: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    60: astore          cur
        //    62: iload           i
        //    64: ifne            72
        //    67: aload           cur
        //    69: goto            78
        //    72: aload_3         /* result */
        //    73: aload           cur
        //    75: invokestatic    gnu/math/IntNum.gcd:(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
        //    78: astore_3        /* result */
        //    79: iinc            i, 1
        //    82: goto            12
        //    85: iload_2         /* result$Mninexact */
        //    86: ifeq            99
        //    89: aload_3         /* result */
        //    90: invokestatic    kawa/lib/numbers.inexact:(Ljava/lang/Number;)Ljava/lang/Number;
        //    93: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    96: goto            100
        //    99: aload_3         /* result */
        //   100: areturn        
        //   101: new             Lgnu/mapping/WrongType;
        //   104: dup_x1         
        //   105: swap           
        //   106: ldc_w           "cur"
        //   109: bipush          -2
        //   111: aload           8
        //   113: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   116: athrow         
        //   117: new             Lgnu/mapping/WrongType;
        //   120: dup_x1         
        //   121: swap           
        //   122: ldc_w           "cur"
        //   125: bipush          -2
        //   127: aload           8
        //   129: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   132: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  46     49     101    117    Ljava/lang/ClassCastException;
        //  57     60     117    133    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Number exact(final Number num) {
        return Arithmetic.toExact(num);
    }
    
    public static Number inexact(final Number num) {
        return Arithmetic.toInexact(num);
    }
    
    public static RealNum lcm(final RealNum... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: istore_1       
        //     3: iconst_0       
        //     4: istore_2       
        //     5: getstatic       kawa/lib/numbers.Lit2:Lgnu/math/IntNum;
        //     8: astore_3        /* result */
        //     9: iconst_0       
        //    10: istore          i
        //    12: iload           i
        //    14: iload_1         /* n */
        //    15: if_icmpge       85
        //    18: aload_0         /* args */
        //    19: iload           i
        //    21: aaload         
        //    22: astore          val
        //    24: aload           val
        //    26: invokestatic    kawa/lib/numbers.isInexact:(Ljava/lang/Object;)Z
        //    29: istore          cur$Mninexact
        //    31: iload           cur$Mninexact
        //    33: ifeq            52
        //    36: iconst_1       
        //    37: istore_2        /* result$Mninexact */
        //    38: aload           val
        //    40: invokestatic    kawa/lib/numbers.exact:(Ljava/lang/Number;)Ljava/lang/Number;
        //    43: dup            
        //    44: astore          8
        //    46: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    49: goto            60
        //    52: aload           val
        //    54: dup            
        //    55: astore          8
        //    57: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    60: astore          cur
        //    62: iload           i
        //    64: ifne            72
        //    67: aload           cur
        //    69: goto            78
        //    72: aload_3         /* result */
        //    73: aload           cur
        //    75: invokestatic    gnu/math/IntNum.lcm:(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
        //    78: astore_3        /* result */
        //    79: iinc            i, 1
        //    82: goto            12
        //    85: iload_2         /* result$Mninexact */
        //    86: ifeq            99
        //    89: aload_3         /* result */
        //    90: invokestatic    kawa/lib/numbers.inexact:(Ljava/lang/Number;)Ljava/lang/Number;
        //    93: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    96: goto            100
        //    99: aload_3         /* result */
        //   100: areturn        
        //   101: new             Lgnu/mapping/WrongType;
        //   104: dup_x1         
        //   105: swap           
        //   106: ldc_w           "cur"
        //   109: bipush          -2
        //   111: aload           8
        //   113: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   116: athrow         
        //   117: new             Lgnu/mapping/WrongType;
        //   120: dup_x1         
        //   121: swap           
        //   122: ldc_w           "cur"
        //   125: bipush          -2
        //   127: aload           8
        //   129: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   132: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  46     49     101    117    Ljava/lang/ClassCastException;
        //  57     60     117    133    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static RealNum numerator(final RealNum x) {
        return (x instanceof RatNum) ? ((RatNum)x).numerator() : gnu.kawa.lispexpr.LangObjType.coerceRealNum(inexact(gnu.kawa.lispexpr.LangObjType.coerceRatNum(exact(x)).numerator()));
    }
    
    public static RealNum denominator(final RealNum x) {
        return (x instanceof RatNum) ? ((RatNum)x).denominator() : gnu.kawa.lispexpr.LangObjType.coerceRealNum(inexact(gnu.kawa.lispexpr.LangObjType.coerceRatNum(exact(x)).denominator()));
    }
    
    public static RealNum floor(final RealNum x) {
        return x.toInt(gnu.math.Numeric.FLOOR);
    }
    
    public static RealNum ceiling(final RealNum x) {
        return x.toInt(gnu.math.Numeric.CEILING);
    }
    
    public static RealNum truncate(final RealNum x) {
        return x.toInt(gnu.math.Numeric.TRUNCATE);
    }
    
    public static RealNum round(final RealNum x) {
        return x.toInt(gnu.math.Numeric.ROUND);
    }
    
    public static RealNum rationalize(final RealNum x, final RealNum y) {
        return gnu.math.RatNum.rationalize(gnu.kawa.lispexpr.LangObjType.coerceRealNum(x.sub(y)), gnu.kawa.lispexpr.LangObjType.coerceRealNum(x.add(y)));
    }
    
    public static Number exp(final Number x) {
        Label_0022: {
            if (!isJava$DtLang$DtReal(x)) {
                break Label_0022;
            }
            try {
                return Math.exp(x.doubleValue());
                Label_0039: {
                    throw new IllegalArgumentException();
                }
                n = ((Quaternion)x).exp();
                return n;
                // iftrue(Label_0039:, !x instanceof Quaternion)
                return ((Quaternion)x).exp();
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "java.lang.Math.exp(double)", 1, x);
            }
        }
    }
    
    public static Number asin(final Number x) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/numbers.isJava$DtLang$DtReal:(Ljava/lang/Object;)Z
        //     4: ifeq            22
        //     7: aload_0         /* x */
        //     8: dup            
        //     9: astore_1       
        //    10: invokevirtual   java/lang/Number.doubleValue:()D
        //    13: invokestatic    java/lang/Math.asin:(D)D
        //    16: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    19: goto            164
        //    22: aload_0         /* x */
        //    23: invokestatic    kawa/lib/numbers.isRealValued:(Ljava/lang/Object;)Z
        //    26: ifeq            63
        //    29: getstatic       kawa/lib/numbers.Lit3:Lgnu/math/IntNum;
        //    32: aload_0         /* x */
        //    33: getstatic       kawa/lib/numbers.Lit2:Lgnu/math/IntNum;
        //    36: iconst_0       
        //    37: anewarray       Ljava/lang/Object;
        //    40: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq$V:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
        //    43: ifeq            63
        //    46: new             Lgnu/math/DFloNum;
        //    49: dup            
        //    50: aload_0         /* x */
        //    51: invokevirtual   java/lang/Number.doubleValue:()D
        //    54: invokestatic    java/lang/Math.asin:(D)D
        //    57: invokespecial   gnu/math/DFloNum.<init>:(D)V
        //    60: goto            164
        //    63: aload_0         /* x */
        //    64: invokestatic    gnu/kawa/functions/Arithmetic.asNumeric:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //    67: dup            
        //    68: astore_2       
        //    69: checkcast       Lgnu/math/Quaternion;
        //    72: astore_1        /* q */
        //    73: aload_1         /* q */
        //    74: invokestatic    kawa/lib/numbers.unitVector:(Ljava/lang/Number;)Lgnu/math/Quaternion;
        //    77: astore_2        /* u */
        //    78: getstatic       kawa/lib/numbers.Lit0:Lgnu/math/IntNum;
        //    81: aload_2         /* u */
        //    82: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    85: ifeq            94
        //    88: getstatic       kawa/lib/numbers.Lit4:Lgnu/math/CComplex;
        //    91: goto            95
        //    94: aload_2         /* u */
        //    95: astore_3        /* v */
        //    96: getstatic       gnu/kawa/functions/AddOp.$Mn:Lgnu/kawa/functions/AddOp;
        //    99: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   102: aload_3         /* v */
        //   103: getstatic       kawa/lib/numbers.log:Lgnu/expr/GenericProc;
        //   106: iconst_1       
        //   107: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   110: aload_3         /* v */
        //   111: aload_1         /* q */
        //   112: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   115: iconst_m1      
        //   116: getstatic       kawa/lib/numbers.Lit2:Lgnu/math/IntNum;
        //   119: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   122: aload_1         /* q */
        //   123: aload_1         /* q */
        //   124: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   127: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   130: ldc             Ljava/lang/Number;.class
        //   132: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   135: dup            
        //   136: astore          4
        //   138: checkcast       Ljava/lang/Number;
        //   141: invokestatic    kawa/lib/numbers.sqrt:(Ljava/lang/Number;)Ljava/lang/Number;
        //   144: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   147: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   150: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   153: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   156: ldc             Ljava/lang/Number;.class
        //   158: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   161: checkcast       Ljava/lang/Number;
        //   164: areturn        
        //   165: new             Lgnu/mapping/WrongType;
        //   168: dup_x1         
        //   169: swap           
        //   170: ldc_w           "java.lang.Math.asin(double)"
        //   173: iconst_1       
        //   174: aload_1        
        //   175: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   178: athrow         
        //   179: new             Lgnu/mapping/WrongType;
        //   182: dup_x1         
        //   183: swap           
        //   184: ldc             "q"
        //   186: bipush          -2
        //   188: aload_2        
        //   189: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   192: athrow         
        //   193: new             Lgnu/mapping/WrongType;
        //   196: dup_x1         
        //   197: swap           
        //   198: ldc_w           "sqrt"
        //   201: iconst_0       
        //   202: aload           4
        //   204: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   207: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  10     13     165    179    Ljava/lang/ClassCastException;
        //  69     72     179    193    Ljava/lang/ClassCastException;
        //  138    141    193    208    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 98 out of bounds for length 98
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
    
    public static Quaternion unitVector(final Number x) {
        return (x instanceof Quaternion) ? ((Quaternion)x).unitVector() : numbers.Lit0;
    }
    
    public static Number sqrt(final Number x) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/numbers.isJava$DtLang$DtReal:(Ljava/lang/Object;)Z
        //     4: ifeq            22
        //     7: aload_0         /* x */
        //     8: dup            
        //     9: astore_1       
        //    10: invokevirtual   java/lang/Number.doubleValue:()D
        //    13: invokestatic    java/lang/Math.sqrt:(D)D
        //    16: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    19: goto            67
        //    22: aload_0         /* x */
        //    23: instanceof      Lgnu/math/Quantity;
        //    26: ifeq            56
        //    29: aload_0         /* x */
        //    30: dup            
        //    31: astore_2       
        //    32: checkcast       Lgnu/math/Quantity;
        //    35: astore_1        /* num */
        //    36: aload_1         /* num */
        //    37: invokevirtual   gnu/math/Quantity.number:()Lgnu/math/Quaternion;
        //    40: invokevirtual   gnu/math/Quaternion.sqrt:()Lgnu/math/Quaternion;
        //    43: aload_1         /* num */
        //    44: invokevirtual   gnu/math/Quantity.unit:()Lgnu/math/Unit;
        //    47: invokevirtual   gnu/math/Unit.sqrt:()Lgnu/math/Unit;
        //    50: invokestatic    gnu/math/Quantity.make:(Lgnu/math/Quaternion;Lgnu/math/Unit;)Lgnu/math/Quantity;
        //    53: goto            67
        //    56: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    59: ldc             Ljava/lang/Number;.class
        //    61: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    64: checkcast       Ljava/lang/Number;
        //    67: areturn        
        //    68: new             Lgnu/mapping/WrongType;
        //    71: dup_x1         
        //    72: swap           
        //    73: ldc_w           "java.lang.Math.sqrt(double)"
        //    76: iconst_1       
        //    77: aload_1        
        //    78: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    81: athrow         
        //    82: new             Lgnu/mapping/WrongType;
        //    85: dup_x1         
        //    86: swap           
        //    87: ldc_w           "num"
        //    90: bipush          -2
        //    92: aload_2        
        //    93: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    96: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  10     13     68     82     Ljava/lang/ClassCastException;
        //  32     35     82     97     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0056:
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
    
    public static Number acos(final Number x) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/numbers.isJava$DtLang$DtReal:(Ljava/lang/Object;)Z
        //     4: ifeq            22
        //     7: aload_0         /* x */
        //     8: dup            
        //     9: astore_1       
        //    10: invokevirtual   java/lang/Number.doubleValue:()D
        //    13: invokestatic    java/lang/Math.acos:(D)D
        //    16: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    19: goto            157
        //    22: aload_0         /* x */
        //    23: invokestatic    kawa/lib/numbers.isRealValued:(Ljava/lang/Object;)Z
        //    26: ifeq            63
        //    29: getstatic       kawa/lib/numbers.Lit3:Lgnu/math/IntNum;
        //    32: aload_0         /* x */
        //    33: getstatic       kawa/lib/numbers.Lit2:Lgnu/math/IntNum;
        //    36: iconst_0       
        //    37: anewarray       Ljava/lang/Object;
        //    40: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq$V:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
        //    43: ifeq            63
        //    46: new             Lgnu/math/DFloNum;
        //    49: dup            
        //    50: aload_0         /* x */
        //    51: invokevirtual   java/lang/Number.doubleValue:()D
        //    54: invokestatic    java/lang/Math.acos:(D)D
        //    57: invokespecial   gnu/math/DFloNum.<init>:(D)V
        //    60: goto            157
        //    63: aload_0         /* x */
        //    64: invokestatic    gnu/kawa/functions/Arithmetic.asNumeric:(Ljava/lang/Object;)Lgnu/math/Numeric;
        //    67: dup            
        //    68: astore_2       
        //    69: checkcast       Lgnu/math/Quaternion;
        //    72: astore_1        /* q */
        //    73: aload_1         /* q */
        //    74: invokestatic    kawa/lib/numbers.unitVector:(Ljava/lang/Number;)Lgnu/math/Quaternion;
        //    77: astore_2        /* u */
        //    78: getstatic       kawa/lib/numbers.Lit0:Lgnu/math/IntNum;
        //    81: aload_2         /* u */
        //    82: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    85: ifeq            94
        //    88: getstatic       kawa/lib/numbers.Lit4:Lgnu/math/CComplex;
        //    91: goto            95
        //    94: aload_2         /* u */
        //    95: astore_3        /* v */
        //    96: getstatic       gnu/kawa/functions/AddOp.$Mn:Lgnu/kawa/functions/AddOp;
        //    99: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   102: aload_3         /* v */
        //   103: getstatic       kawa/lib/numbers.log:Lgnu/expr/GenericProc;
        //   106: iconst_1       
        //   107: aload_1         /* q */
        //   108: iconst_m1      
        //   109: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   112: aload_1         /* q */
        //   113: aload_1         /* q */
        //   114: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   117: getstatic       kawa/lib/numbers.Lit2:Lgnu/math/IntNum;
        //   120: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   123: ldc             Ljava/lang/Number;.class
        //   125: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   128: dup            
        //   129: astore          4
        //   131: checkcast       Ljava/lang/Number;
        //   134: invokestatic    kawa/lib/numbers.sqrt:(Ljava/lang/Number;)Ljava/lang/Number;
        //   137: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   140: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   143: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   146: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   149: ldc             Ljava/lang/Number;.class
        //   151: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   154: checkcast       Ljava/lang/Number;
        //   157: areturn        
        //   158: new             Lgnu/mapping/WrongType;
        //   161: dup_x1         
        //   162: swap           
        //   163: ldc_w           "java.lang.Math.acos(double)"
        //   166: iconst_1       
        //   167: aload_1        
        //   168: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   171: athrow         
        //   172: new             Lgnu/mapping/WrongType;
        //   175: dup_x1         
        //   176: swap           
        //   177: ldc             "q"
        //   179: bipush          -2
        //   181: aload_2        
        //   182: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   185: athrow         
        //   186: new             Lgnu/mapping/WrongType;
        //   189: dup_x1         
        //   190: swap           
        //   191: ldc_w           "sqrt"
        //   194: iconst_0       
        //   195: aload           4
        //   197: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   200: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  10     13     158    172    Ljava/lang/ClassCastException;
        //  69     72     172    186    Ljava/lang/ClassCastException;
        //  131    134    186    201    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 95 out of bounds for length 95
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
    
    public static Number square(final Number x) {
        return (Number)Promise.force(MultiplyOp.$St.apply2(x, x), Number.class);
    }
    
    public static Number magnitude(final Number x) {
        return abs(x);
    }
    
    public static RealNum angle(final Number x) {
        return (x instanceof Quaternion) ? ((Quaternion)x).angle() : ((x.doubleValue() < 0.0) ? DFloNum.make(Math.PI) : numbers.Lit5);
    }
    
    public static Number exact$To$Inexact(final Number num) {
        return Arithmetic.toInexact(num);
    }
    
    public static Number inexact$To$Exact(final Number num) {
        return Arithmetic.toExact(num);
    }
    
    public static IntNum logop(final int op, final IntNum i, final IntNum j) {
        return gnu.math.BitOps.bitOp(op, i, j);
    }
    
    public static boolean isBitwiseBitSet(final IntNum i, final int bitno) {
        return gnu.math.BitOps.bitValue(i, bitno);
    }
    
    public static IntNum bitwiseCopyBit(final IntNum i, final int bitno, final int new$Mnvalue) {
        return gnu.math.BitOps.setBitValue(i, bitno, new$Mnvalue);
    }
    
    public static IntNum bitwiseCopyBitField(final IntNum to, final int start, final int end, final IntNum from) {
        return bitwiseIf(gnu.math.BitOps.makeMask(start, end), gnu.math.IntNum.shift(from, start), to);
    }
    
    public static IntNum bitwiseIf(final IntNum e1, final IntNum e2, final IntNum e3) {
        return gnu.math.BitOps.ior(gnu.math.BitOps.and(e1, e2), gnu.math.BitOps.and(gnu.math.BitOps.not(e1), e3));
    }
    
    public static IntNum bitwiseBitField(final IntNum i, final int start, final int end) {
        return gnu.math.BitOps.extract(i, start, end);
    }
    
    public static boolean logtest(final IntNum i, final IntNum j) {
        return gnu.math.BitOps.test(i, j);
    }
    
    public static int logcount(final IntNum i) {
        return gnu.math.BitOps.bitCount((gnu.math.IntNum.compare(i, 0L) >= 0) ? i : gnu.math.BitOps.not(i));
    }
    
    public static int bitwiseBitCount(final IntNum i) {
        return (gnu.math.IntNum.compare(i, 0L) >= 0) ? gnu.math.BitOps.bitCount(i) : (-1 - gnu.math.BitOps.bitCount(gnu.math.BitOps.not(i)));
    }
    
    public static int bitwiseLength(final IntNum i) {
        return i.intLength();
    }
    
    public static int bitwiseFirstBitSet(final IntNum i) {
        return gnu.math.BitOps.lowestBitSet(i);
    }
    
    public static IntNum bitwiseRotateBitField(final IntNum n, final int start, final int end, final int count) {
        final int width = end - start;
        IntNum bitwiseCopyBitField;
        if (width > 0) {
            final int r = count % width;
            final int count2 = (r < 0) ? (r + width) : r;
            final IntNum field0 = bitwiseBitField(n, start, end);
            final IntNum field2 = gnu.math.IntNum.shift(field0, count2);
            final IntNum field3 = gnu.math.IntNum.shift(field0, count2 - width);
            final IntNum field4 = gnu.math.BitOps.ior(field2, field3);
            bitwiseCopyBitField = bitwiseCopyBitField(n, start, end, field4);
        }
        else {
            bitwiseCopyBitField = n;
        }
        return bitwiseCopyBitField;
    }
    
    public static IntNum bitwiseReverseBitField(final IntNum n, final int start, final int end) {
        return gnu.math.BitOps.reverseBits(n, start, end);
    }
    
    public static CharSequence number$To$String(final Number arg) {
        return number$To$String(arg, 10);
    }
    
    public static CharSequence number$To$String(final Number arg, final int radix) {
        final boolean x = radix < 2;
        if (x) {
            if (!x) {
                return new FString((CharSequence)Arithmetic.toString(arg, radix));
            }
        }
        else if (radix <= 36) {
            return new FString((CharSequence)Arithmetic.toString(arg, radix));
        }
        throw new IllegalArgumentException(Format.formatToString(0, "invalid radix ~d", radix));
    }
    
    public static Object string$To$Number(final CharSequence str) {
        return string$To$Number(str, 10);
    }
    
    public static Object string$To$Number(final CharSequence str, final int radix) {
        final boolean x = radix < 2;
        Label_0057: {
            if (x) {
                if (!x) {
                    break Label_0057;
                }
            }
            else if (radix <= 36) {
                break Label_0057;
            }
            throw new IllegalArgumentException(Format.formatToString(0, "invalid radix ~d", radix));
        }
        final Object result = LispReader.parseNumber(str, -radix);
        return (result instanceof Numeric) ? result : Boolean.FALSE;
    }
    
    public static Quaternion quantity$To$Number(final Quantity q) {
        q.unit();
        final double factor = q.doubleValue();
        return (factor == 1.0) ? q.number() : Quaternion.make(q.reValue(), q.imValue(), q.jmValue(), q.kmValue());
    }
    
    public static Unit quantity$To$Unit(final Quantity q) {
        return q.unit();
    }
    
    public static Quantity makeQuantity(final Object val, final Object unit) {
        Object o2 = null;
        Unit u = null;
        Object o3 = null;
        Label_0022: {
            if (!(unit instanceof Unit)) {
                break Label_0022;
            }
            final Object o = o2 = Promise.force(unit, Unit.class);
            try {
                Unit lookup = (Unit)o;
                while (true) {
                    u = lookup;
                    if (u == null) {
                        throw new IllegalArgumentException(Format.formatToString(0, "unknown unit: ~s", unit).toString());
                    }
                    o3 = (o2 = Promise.force(val, Quaternion.class));
                    final Quaternion quaternion = (Quaternion)o3;
                    final Unit unit2 = u;
                    return Quantity.make(quaternion, unit2);
                    final Object force = Promise.force(unit, String.class);
                    lookup = Unit.lookup((force == null) ? null : force.toString());
                    continue;
                }
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "u", -2, o2);
            }
        }
        try {
            final Quaternion quaternion = (Quaternion)o3;
            final Unit unit2 = u;
            return Quantity.make(quaternion, unit2);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "gnu.math.Quantity.make(gnu.math.Quaternion,gnu.math.Unit)", 1, o2);
        }
    }
    
    public static Duration duration(final Object duration) {
        final Object force = Promise.force(duration, String.class);
        return Duration.parseDuration((force == null) ? null : force.toString());
    }
    
    public static Object exactIntegerSqrt(final IntNum i) {
        if (gnu.math.IntNum.compare(i, 0L) < 0) {
            throw new IllegalArgumentException(Format.formatToString(0, "negative argument: ~A", i));
        }
        final double dval = i.doubleValue();
        IntNum intNum;
        if (java.lang.Double.isInfinite(dval)) {
            final int il = i.intLength();
            intNum = gnu.math.BitOps.makeMask(il, il + 1);
        }
        else {
            intNum = gnu.math.RealNum.toExactInt(Math.sqrt(dval), gnu.math.Numeric.TRUNCATE);
        }
        IntNum shift;
        final IntNum init = shift = intNum;
        IntNum q;
        IntNum rem;
        while (true) {
            q = shift;
            rem = gnu.math.IntNum.sub(i, gnu.math.IntNum.times(q, q));
            final boolean x = gnu.math.IntNum.compare(rem, 0L) < 0;
            if (x) {
                if (!x) {
                    break;
                }
            }
            else if (gnu.math.IntNum.compare(gnu.math.IntNum.shift(q, 1), gnu.math.IntNum.add(rem, -1)) > 0) {
                break;
            }
            shift = gnu.math.IntNum.shift(gnu.math.IntNum.add(q, gnu.math.IntNum.quotient(i, q)), -1);
        }
        return misc.values(q, rem);
    }
    
    static {
        Lit78 = Symbol.valueOf("exact-integer-sqrt");
        Lit77 = Symbol.valueOf("duration");
        Lit76 = Symbol.valueOf("make-quantity");
        Lit75 = Symbol.valueOf("quantity->unit");
        Lit74 = Symbol.valueOf("quantity->number");
        Lit73 = Symbol.valueOf("string->number");
        Lit72 = Symbol.valueOf("number->string");
        Lit71 = Symbol.valueOf("bitwise-reverse-bit-field");
        Lit70 = Symbol.valueOf("bitwise-rotate-bit-field");
        Lit69 = Symbol.valueOf("bitwise-first-bit-set");
        Lit68 = Symbol.valueOf("bitwise-length");
        Lit67 = Symbol.valueOf("bitwise-bit-count");
        Lit66 = Symbol.valueOf("logcount");
        Lit65 = Symbol.valueOf("logtest");
        Lit64 = Symbol.valueOf("bitwise-if");
        Lit63 = Symbol.valueOf("bitwise-bit-field");
        Lit62 = Symbol.valueOf("bitwise-copy-bit-field");
        Lit61 = Symbol.valueOf("bitwise-copy-bit");
        Lit60 = Symbol.valueOf("bitwise-bit-set?");
        Lit59 = Symbol.valueOf("logop");
        Lit58 = Symbol.valueOf("inexact->exact");
        Lit57 = Symbol.valueOf("exact->inexact");
        Lit56 = Symbol.valueOf("exact");
        Lit55 = Symbol.valueOf("inexact");
        Lit54 = Symbol.valueOf("angle");
        Lit53 = Symbol.valueOf("magnitude");
        Lit52 = Symbol.valueOf("unit-vector");
        Lit51 = Symbol.valueOf("kmag-part");
        Lit50 = Symbol.valueOf("jmag-part");
        Lit49 = Symbol.valueOf("imag-part");
        Lit48 = Symbol.valueOf("real-part");
        Lit47 = Symbol.valueOf("square");
        Lit46 = Symbol.valueOf("sqrt");
        Lit45 = gnu.math.IntNum.valueOf(2);
        Lit44 = new IntFraction(Lit2 = gnu.math.IntNum.valueOf(1), numbers.Lit45);
        Lit43 = Symbol.valueOf("acos");
        Lit42 = Symbol.valueOf("asin");
        Lit41 = Symbol.valueOf("exp");
        Lit40 = Symbol.valueOf("rationalize");
        Lit39 = Symbol.valueOf("round");
        Lit38 = Symbol.valueOf("truncate");
        Lit37 = Symbol.valueOf("ceiling");
        Lit36 = Symbol.valueOf("floor");
        Lit35 = Symbol.valueOf("denominator");
        Lit34 = Symbol.valueOf("numerator");
        Lit33 = Symbol.valueOf("lcm");
        Lit32 = Symbol.valueOf("gcd");
        Lit31 = Symbol.valueOf("div0-and-mod0");
        Lit30 = Symbol.valueOf("div-and-mod");
        Lit29 = Symbol.valueOf("truncate/");
        Lit28 = Symbol.valueOf("floor/");
        Lit27 = Symbol.valueOf("abs");
        Lit26 = Symbol.valueOf("min");
        Lit25 = Symbol.valueOf("max");
        Lit24 = Symbol.valueOf("nan?");
        Lit23 = Symbol.valueOf("infinite?");
        Lit22 = Symbol.valueOf("finite?");
        Lit21 = Symbol.valueOf("negative?");
        Lit20 = Symbol.valueOf("positive?");
        Lit19 = Symbol.valueOf("zero?");
        Lit18 = Symbol.valueOf("inexact?");
        Lit17 = Symbol.valueOf("exact?");
        Lit16 = Symbol.valueOf("integer-valued?");
        Lit15 = Symbol.valueOf("rational-valued?");
        Lit14 = Symbol.valueOf("real-valued?");
        Lit13 = Symbol.valueOf("exact-integer?");
        Lit12 = Symbol.valueOf("integer?");
        Lit11 = Symbol.valueOf("rational?");
        Lit10 = Symbol.valueOf("real?");
        Lit9 = Symbol.valueOf("complex?");
        Lit8 = Symbol.valueOf("quaternion?");
        Lit7 = Symbol.valueOf("quantity?");
        Lit6 = Symbol.valueOf("number?");
        Lit5 = DFloNum.valueOf(0.0);
        Lit4 = new CComplex(Lit0 = gnu.math.IntNum.valueOf(0), numbers.Lit2);
        Lit3 = gnu.math.IntNum.valueOf(-1);
        Lit1 = Symbol.valueOf("signum");
        LangObjType = LangObjType.class;
        quaternion = Quaternion.class;
        RealNum = RealNum.class;
        RatNum = RatNum.class;
        Numeric = Numeric.class;
        BitOps = BitOps.class;
        IntNum = IntNum.class;
        Double = Double.class;
        numbers.$instance = new numbers();
        final numbers $instance4 = numbers.$instance;
        number$Qu = new ModuleMethod($instance4, 1, numbers.Lit6, 4097);
        quantity$Qu = new ModuleMethod($instance4, 2, numbers.Lit7, 4097);
        quaternion$Qu = new ModuleMethod($instance4, 3, numbers.Lit8, 4097);
        complex$Qu = new ModuleMethod($instance4, 4, numbers.Lit9, 4097);
        real$Qu = new ModuleMethod($instance4, 5, numbers.Lit10, 4097);
        rational$Qu = new ModuleMethod($instance4, 6, numbers.Lit11, 4097);
        integer$Qu = new ModuleMethod($instance4, 7, numbers.Lit12, 4097);
        exact$Mninteger$Qu = new ModuleMethod($instance4, 8, numbers.Lit13, 4097);
        real$Mnvalued$Qu = new ModuleMethod($instance4, 9, numbers.Lit14, 4097);
        rational$Mnvalued$Qu = new ModuleMethod($instance4, 10, numbers.Lit15, 4097);
        integer$Mnvalued$Qu = new ModuleMethod($instance4, 11, numbers.Lit16, 4097);
        exact$Qu = new ModuleMethod($instance4, 12, numbers.Lit17, 4097);
        inexact$Qu = new ModuleMethod($instance4, 13, numbers.Lit18, 4097);
        zero$Qu = new ModuleMethod($instance4, 14, numbers.Lit19, 4097);
        positive$Qu = new ModuleMethod($instance4, 15, numbers.Lit20, 4097);
        negative$Qu = new ModuleMethod($instance4, 16, numbers.Lit21, 4097);
        finite$Qu = new ModuleMethod($instance4, 17, numbers.Lit22, 4097);
        infinite$Qu = new ModuleMethod($instance4, 18, numbers.Lit23, 4097);
        nan$Qu = new ModuleMethod($instance4, 19, numbers.Lit24, 4097);
        max = new ModuleMethod($instance4, 20, numbers.Lit25, -4096);
        min = new ModuleMethod($instance4, 21, numbers.Lit26, -4096);
        abs = new ModuleMethod($instance4, 22, numbers.Lit27, 4097);
        floor$Sl = new ModuleMethod($instance4, 23, numbers.Lit28, 8194);
        truncate$Sl = new ModuleMethod($instance4, 24, numbers.Lit29, 8194);
        div$Mnand$Mnmod = new ModuleMethod($instance4, 25, numbers.Lit30, 8194);
        div0$Mnand$Mnmod0 = new ModuleMethod($instance4, 26, numbers.Lit31, 8194);
        gcd = new ModuleMethod($instance4, 27, numbers.Lit32, -4096);
        lcm = new ModuleMethod($instance4, 28, numbers.Lit33, -4096);
        numerator = new ModuleMethod($instance4, 29, numbers.Lit34, 4097);
        denominator = new ModuleMethod($instance4, 30, numbers.Lit35, 4097);
        floor = new ModuleMethod($instance4, 31, numbers.Lit36, 4097);
        ceiling = new ModuleMethod($instance4, 32, numbers.Lit37, 4097);
        truncate = new ModuleMethod($instance4, 33, numbers.Lit38, 4097);
        round = new ModuleMethod($instance4, 34, numbers.Lit39, 4097);
        rationalize = new ModuleMethod($instance4, 35, numbers.Lit40, 8194);
        exp = new ModuleMethod($instance4, 36, numbers.Lit41, 4097);
        final GenericProc log2 = new GenericProc("log");
        numbers $instance = numbers.$instance;
        final ModuleMethod method = new ModuleMethod($instance, 37, null, 8194);
        method.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:258");
        log2.add(method);
        numbers $instance2 = numbers.$instance;
        final ModuleMethod method2 = new ModuleMethod($instance2, 38, null, 4097);
        method2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:266");
        log2.add(method2);
        log = log2;
        final GenericProc sin2 = new GenericProc("sin");
        $instance = numbers.$instance;
        final ModuleMethod method3 = new ModuleMethod($instance, 39, null, 4097);
        method3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:273");
        sin2.add(method3);
        $instance2 = numbers.$instance;
        final ModuleMethod method4 = new ModuleMethod($instance2, 40, null, 4097);
        method4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:275");
        sin2.add(method4);
        sin = sin2;
        final GenericProc cos2 = new GenericProc("cos");
        $instance = numbers.$instance;
        final ModuleMethod method5 = new ModuleMethod($instance, 41, null, 4097);
        method5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:279");
        cos2.add(method5);
        $instance2 = numbers.$instance;
        final ModuleMethod method6 = new ModuleMethod($instance2, 42, null, 4097);
        method6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:281");
        cos2.add(method6);
        cos = cos2;
        final GenericProc tan2 = new GenericProc("tan");
        $instance = numbers.$instance;
        final ModuleMethod method7 = new ModuleMethod($instance, 43, null, 4097);
        method7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:285");
        tan2.add(method7);
        $instance2 = numbers.$instance;
        final ModuleMethod method8 = new ModuleMethod($instance2, 44, null, 4097);
        method8.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:287");
        tan2.add(method8);
        tan = tan2;
        asin = new ModuleMethod($instance4, 45, numbers.Lit42, 4097);
        acos = new ModuleMethod($instance4, 46, numbers.Lit43, 4097);
        final GenericProc atan2 = new GenericProc("atan");
        $instance = numbers.$instance;
        final ModuleMethod method9 = new ModuleMethod($instance, 47, null, 8194);
        method9.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:315");
        atan2.add(method9);
        $instance2 = numbers.$instance;
        final ModuleMethod method10 = new ModuleMethod($instance2, 48, null, 4097);
        method10.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:325");
        atan2.add(method10);
        atan = atan2;
        final GenericProc sinh2 = new GenericProc("sinh");
        $instance = numbers.$instance;
        final ModuleMethod method11 = new ModuleMethod($instance, 49, null, 4097);
        method11.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:338");
        sinh2.add(method11);
        $instance2 = numbers.$instance;
        final ModuleMethod method12 = new ModuleMethod($instance2, 50, null, 4097);
        method12.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:344");
        sinh2.add(method12);
        numbers $instance3 = numbers.$instance;
        final ModuleMethod method13 = new ModuleMethod($instance3, 51, null, 4097);
        method13.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:347");
        sinh2.add(method13);
        sinh = sinh2;
        final GenericProc cosh2 = new GenericProc("cosh");
        $instance = numbers.$instance;
        final ModuleMethod method14 = new ModuleMethod($instance, 52, null, 4097);
        method14.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:352");
        cosh2.add(method14);
        $instance2 = numbers.$instance;
        final ModuleMethod method15 = new ModuleMethod($instance2, 53, null, 4097);
        method15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:358");
        cosh2.add(method15);
        $instance3 = numbers.$instance;
        final ModuleMethod method16 = new ModuleMethod($instance3, 54, null, 4097);
        method16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:361");
        cosh2.add(method16);
        cosh = cosh2;
        final GenericProc tanh2 = new GenericProc("tanh");
        $instance = numbers.$instance;
        final ModuleMethod method17 = new ModuleMethod($instance, 55, null, 4097);
        method17.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:366");
        tanh2.add(method17);
        $instance2 = numbers.$instance;
        final ModuleMethod method18 = new ModuleMethod($instance2, 56, null, 4097);
        method18.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:374");
        tanh2.add(method18);
        $instance3 = numbers.$instance;
        final ModuleMethod method19 = new ModuleMethod($instance3, 57, null, 4097);
        method19.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:379");
        tanh2.add(method19);
        tanh = tanh2;
        final GenericProc asinh2 = new GenericProc("asinh");
        $instance = numbers.$instance;
        final ModuleMethod method20 = new ModuleMethod($instance, 58, null, 4097);
        method20.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:384");
        asinh2.add(method20);
        $instance2 = numbers.$instance;
        final ModuleMethod method21 = new ModuleMethod($instance2, 59, null, 4097);
        method21.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:387");
        asinh2.add(method21);
        asinh = asinh2;
        final GenericProc acosh2 = new GenericProc("acosh");
        $instance = numbers.$instance;
        final ModuleMethod method22 = new ModuleMethod($instance, 60, null, 4097);
        method22.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:392");
        acosh2.add(method22);
        $instance2 = numbers.$instance;
        final ModuleMethod method23 = new ModuleMethod($instance2, 61, null, 4097);
        method23.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:395");
        acosh2.add(method23);
        acosh = acosh2;
        final GenericProc atanh2 = new GenericProc("atanh");
        $instance = numbers.$instance;
        final ModuleMethod method24 = new ModuleMethod($instance, 62, null, 4097);
        method24.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:400");
        atanh2.add(method24);
        $instance2 = numbers.$instance;
        final ModuleMethod method25 = new ModuleMethod($instance2, 63, null, 4097);
        method25.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:403");
        atanh2.add(method25);
        atanh = atanh2;
        sqrt = new ModuleMethod($instance4, 64, numbers.Lit46, 4097);
        square = new ModuleMethod($instance4, 65, numbers.Lit47, 4097);
        final GenericProc make$Mnrectangular2 = new GenericProc("make-rectangular");
        $instance = numbers.$instance;
        final ModuleMethod method26 = new ModuleMethod($instance, 66, null, 8194);
        method26.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:419");
        make$Mnrectangular2.add(method26);
        $instance2 = numbers.$instance;
        final ModuleMethod method27 = new ModuleMethod($instance2, 67, null, 16388);
        method27.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:421");
        make$Mnrectangular2.add(method27);
        make$Mnrectangular = make$Mnrectangular2;
        final GenericProc make$Mnpolar2 = new GenericProc("make-polar");
        $instance = numbers.$instance;
        final ModuleMethod method28 = new ModuleMethod($instance, 68, null, 8194);
        method28.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:425");
        make$Mnpolar2.add(method28);
        $instance2 = numbers.$instance;
        final ModuleMethod method29 = new ModuleMethod($instance2, 69, null, 16388);
        method29.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:427");
        make$Mnpolar2.add(method29);
        make$Mnpolar = make$Mnpolar2;
        real$Mnpart = new ModuleMethod($instance4, 70, numbers.Lit48, 4097);
        imag$Mnpart = new ModuleMethod($instance4, 71, numbers.Lit49, 4097);
        jmag$Mnpart = new ModuleMethod($instance4, 72, numbers.Lit50, 4097);
        kmag$Mnpart = new ModuleMethod($instance4, 73, numbers.Lit51, 4097);
        unit$Mnvector = new ModuleMethod($instance4, 74, numbers.Lit52, 4097);
        magnitude = new ModuleMethod($instance4, 75, numbers.Lit53, 4097);
        angle = new ModuleMethod($instance4, 76, numbers.Lit54, 4097);
        inexact = new ModuleMethod($instance4, 77, numbers.Lit55, 4097);
        exact = new ModuleMethod($instance4, 78, numbers.Lit56, 4097);
        exact$Mn$Grinexact = new ModuleMethod($instance4, 79, numbers.Lit57, 4097);
        inexact$Mn$Grexact = new ModuleMethod($instance4, 80, numbers.Lit58, 4097);
        logop = new ModuleMethod($instance4, 81, numbers.Lit59, 12291);
        bitwise$Mnbit$Mnset$Qu = new ModuleMethod($instance4, 82, numbers.Lit60, 8194);
        bitwise$Mncopy$Mnbit = new ModuleMethod($instance4, 83, numbers.Lit61, 12291);
        bitwise$Mncopy$Mnbit$Mnfield = new ModuleMethod($instance4, 84, numbers.Lit62, 16388);
        bitwise$Mnbit$Mnfield = new ModuleMethod($instance4, 85, numbers.Lit63, 12291);
        bitwise$Mnif = new ModuleMethod($instance4, 86, numbers.Lit64, 12291);
        logtest = new ModuleMethod($instance4, 87, numbers.Lit65, 8194);
        logcount = new ModuleMethod($instance4, 88, numbers.Lit66, 4097);
        bitwise$Mnbit$Mncount = new ModuleMethod($instance4, 89, numbers.Lit67, 4097);
        bitwise$Mnlength = new ModuleMethod($instance4, 90, numbers.Lit68, 4097);
        bitwise$Mnfirst$Mnbit$Mnset = new ModuleMethod($instance4, 91, numbers.Lit69, 4097);
        bitwise$Mnrotate$Mnbit$Mnfield = new ModuleMethod($instance4, 92, numbers.Lit70, 16388);
        bitwise$Mnreverse$Mnbit$Mnfield = new ModuleMethod($instance4, 93, numbers.Lit71, 12291);
        number$Mn$Grstring = new ModuleMethod($instance4, 94, numbers.Lit72, 8193);
        string$Mn$Grnumber = new ModuleMethod($instance4, 96, numbers.Lit73, 8193);
        quantity$Mn$Grnumber = new ModuleMethod($instance4, 98, numbers.Lit74, 4097);
        quantity$Mn$Grunit = new ModuleMethod($instance4, 99, numbers.Lit75, 4097);
        make$Mnquantity = new ModuleMethod($instance4, 100, numbers.Lit76, 8194);
        duration = new ModuleMethod($instance4, 101, numbers.Lit77, 4097);
        exact$Mninteger$Mnsqrt = new ModuleMethod($instance4, 102, numbers.Lit78, 4097);
        $runBody$();
    }
    
    public numbers() {
        ModuleInfo.register(this);
    }
    
    public static Number lambda1(final Number x, final Number base) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: instanceof      Lgnu/math/RealNum;
        //     4: ifeq            45
        //     7: aload_1         /* base */
        //     8: instanceof      Lgnu/math/RealNum;
        //    11: ifeq            45
        //    14: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //    17: getstatic       kawa/lib/numbers.log:Lgnu/expr/GenericProc;
        //    20: aload_0         /* x */
        //    21: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    24: getstatic       kawa/lib/numbers.log:Lgnu/expr/GenericProc;
        //    27: aload_1         /* base */
        //    28: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    31: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    34: ldc             Ljava/lang/Number;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: checkcast       Ljava/lang/Number;
        //    42: goto            146
        //    45: aload_0         /* x */
        //    46: invokestatic    kawa/lib/numbers.isJava$DtLang$DtReal:(Ljava/lang/Object;)Z
        //    49: istore_2        /* x */
        //    50: iload_2         /* x */
        //    51: ifeq            61
        //    54: iload_2         /* x */
        //    55: ifeq            118
        //    58: goto            68
        //    61: aload_0         /* x */
        //    62: instanceof      Lgnu/math/RealNum;
        //    65: ifeq            118
        //    68: aload_1         /* base */
        //    69: invokestatic    kawa/lib/numbers.isJava$DtLang$DtReal:(Ljava/lang/Object;)Z
        //    72: istore_3        /* x */
        //    73: iload_3         /* x */
        //    74: ifeq            84
        //    77: iload_3         /* x */
        //    78: ifeq            118
        //    81: goto            91
        //    84: aload_1         /* base */
        //    85: instanceof      Lgnu/math/RealNum;
        //    88: ifeq            118
        //    91: aload_0         /* x */
        //    92: dup            
        //    93: astore          4
        //    95: invokevirtual   java/lang/Number.doubleValue:()D
        //    98: invokestatic    java/lang/Math.log:(D)D
        //   101: aload_1         /* base */
        //   102: dup            
        //   103: astore          4
        //   105: invokevirtual   java/lang/Number.doubleValue:()D
        //   108: invokestatic    java/lang/Math.log:(D)D
        //   111: ddiv           
        //   112: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   115: goto            146
        //   118: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   121: getstatic       kawa/lib/numbers.log:Lgnu/expr/GenericProc;
        //   124: aload_0         /* x */
        //   125: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   128: getstatic       kawa/lib/numbers.log:Lgnu/expr/GenericProc;
        //   131: aload_1         /* base */
        //   132: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   135: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   138: ldc             Ljava/lang/Number;.class
        //   140: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   143: checkcast       Ljava/lang/Number;
        //   146: areturn        
        //   147: new             Lgnu/mapping/WrongType;
        //   150: dup_x1         
        //   151: swap           
        //   152: ldc_w           "java.lang.Math.log(double)"
        //   155: iconst_1       
        //   156: aload           4
        //   158: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   161: athrow         
        //   162: new             Lgnu/mapping/WrongType;
        //   165: dup_x1         
        //   166: swap           
        //   167: ldc_w           "java.lang.Math.log(double)"
        //   170: iconst_1       
        //   171: aload           4
        //   173: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   176: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  95     98     147    162    Ljava/lang/ClassCastException;
        //  105    108    162    177    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0118:
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
    
    public static Number lambda2(final Number x) {
        Label_0022: {
            if (!isJava$DtLang$DtReal(x)) {
                break Label_0022;
            }
            try {
                return Math.log(x.doubleValue());
                value = ((x instanceof Quaternion) ? ((Quaternion)x).log() : Promise.force(Values.empty, Number.class));
                return value;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "java.lang.Math.log(double)", 1, x);
            }
        }
    }
    
    public static Quaternion lambda3(final Quaternion q) {
        return q.sin();
    }
    
    public static double lambda4(final double x) {
        return Math.sin(x);
    }
    
    public static Quaternion lambda5(final Quaternion q) {
        return q.cos();
    }
    
    public static double lambda6(final double x) {
        return Math.cos(x);
    }
    
    public static Quaternion lambda7(final Quaternion q) {
        return q.tan();
    }
    
    public static double lambda8(final double x) {
        return Math.tan(x);
    }
    
    public static Number lambda9(final Number y, final Number x) {
        if (!(y instanceof RealNum) || !(x instanceof RealNum)) {
            final boolean x2 = isJava$DtLang$DtReal(y);
            if (x2) {
                if (!x2) {
                    throw new IllegalArgumentException();
                }
            }
            else if (!(y instanceof RealNum)) {
                throw new IllegalArgumentException();
            }
            final boolean x3 = isJava$DtLang$DtReal(x);
            if (x3) {
                if (!x3) {
                    throw new IllegalArgumentException();
                }
            }
            else if (!(x instanceof RealNum)) {
                throw new IllegalArgumentException();
            }
            final Comparable<Double> value = Math.atan2(y.doubleValue(), x.doubleValue());
            return (Number)value;
        }
        final Comparable<Double> value = (Comparable<Double>)new DFloNum(Math.atan2(y.doubleValue(), x.doubleValue()));
        return (Number)value;
    }
    
    public static Number lambda10(final Number x) {
        if (x instanceof RealNum) {
            final Object value = new DFloNum(Math.atan(x.doubleValue()));
            return (Number)value;
        }
        if (isJava$DtLang$DtReal(x)) {
            final Object value = Math.atan(x.doubleValue());
            return (Number)value;
        }
        try {
            final Quaternion q = (Quaternion)x;
            final Quaternion u = unitVector(q);
            final Quaternion v = NumberCompare.$Eq(numbers.Lit0, u) ? numbers.Lit4 : u;
            final Object value = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(numbers.Lit44, v), numbers.log.apply1(MultiplyOp.$St.apply2(AddOp.apply2(1, v, q), DivideOp.$Sl.apply2(numbers.Lit2, AddOp.apply2(-1, v, q))))), Number.class);
            return (Number)value;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "q", -2, x);
        }
    }
    
    public static Complex lambda11(final Complex z) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: dup            
        //     5: astore_3       
        //     6: invokevirtual   java/lang/Number.doubleValue:()D
        //     9: dstore_1       
        //    10: aload_0         /* z */
        //    11: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    14: dup            
        //    15: astore          5
        //    17: invokevirtual   java/lang/Number.doubleValue:()D
        //    20: dstore_3       
        //    21: dload_1         /* x */
        //    22: invokestatic    java/lang/Math.sinh:(D)D
        //    25: dload_3        
        //    26: invokestatic    java/lang/Math.cos:(D)D
        //    29: dmul           
        //    30: dload_1         /* x */
        //    31: invokestatic    java/lang/Math.cosh:(D)D
        //    34: dload_3        
        //    35: invokestatic    java/lang/Math.sin:(D)D
        //    38: dmul           
        //    39: invokestatic    gnu/math/Complex.make:(DD)Lgnu/math/Complex;
        //    42: areturn        
        //    43: new             Lgnu/mapping/WrongType;
        //    46: dup_x1         
        //    47: swap           
        //    48: ldc_w           "x"
        //    51: bipush          -2
        //    53: aload_3        
        //    54: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    57: athrow         
        //    58: new             Lgnu/mapping/WrongType;
        //    61: dup_x1         
        //    62: swap           
        //    63: ldc_w           "y"
        //    66: bipush          -2
        //    68: aload           5
        //    70: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    73: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  6      9      43     58     Ljava/lang/ClassCastException;
        //  17     20     58     74     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Quaternion lambda12(final Quaternion q) {
        final DivideOp $Sl = DivideOp.$Sl;
        final int plusOrMinus = -1;
        final Number exp = exp(q);
        final Object force = Promise.force(AddOp.$Mn.apply1(q), Number.class);
        try {
            return (Quaternion)Promise.force($Sl.apply2(AddOp.apply2(plusOrMinus, exp, exp((Number)force)), numbers.Lit45), Quaternion.class);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "exp", 0, force);
        }
    }
    
    public static double lambda13(final double x) {
        return Math.sinh(x);
    }
    
    public static Complex lambda14(final Complex z) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: dup            
        //     5: astore_3       
        //     6: invokevirtual   java/lang/Number.doubleValue:()D
        //     9: dstore_1       
        //    10: aload_0         /* z */
        //    11: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    14: dup            
        //    15: astore          5
        //    17: invokevirtual   java/lang/Number.doubleValue:()D
        //    20: dstore_3       
        //    21: dload_1         /* x */
        //    22: invokestatic    java/lang/Math.cosh:(D)D
        //    25: dload_3        
        //    26: invokestatic    java/lang/Math.cos:(D)D
        //    29: dmul           
        //    30: dload_1         /* x */
        //    31: invokestatic    java/lang/Math.sinh:(D)D
        //    34: dload_3        
        //    35: invokestatic    java/lang/Math.sin:(D)D
        //    38: dmul           
        //    39: invokestatic    gnu/math/Complex.make:(DD)Lgnu/math/Complex;
        //    42: areturn        
        //    43: new             Lgnu/mapping/WrongType;
        //    46: dup_x1         
        //    47: swap           
        //    48: ldc_w           "x"
        //    51: bipush          -2
        //    53: aload_3        
        //    54: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    57: athrow         
        //    58: new             Lgnu/mapping/WrongType;
        //    61: dup_x1         
        //    62: swap           
        //    63: ldc_w           "y"
        //    66: bipush          -2
        //    68: aload           5
        //    70: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    73: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  6      9      43     58     Ljava/lang/ClassCastException;
        //  17     20     58     74     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Quaternion lambda15(final Quaternion q) {
        final DivideOp $Sl = DivideOp.$Sl;
        final int plusOrMinus = 1;
        final Number exp = exp(q);
        final Object force = Promise.force(AddOp.$Mn.apply1(q), Number.class);
        try {
            return (Quaternion)Promise.force($Sl.apply2(AddOp.apply2(plusOrMinus, exp, exp((Number)force)), numbers.Lit45), Quaternion.class);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "exp", 0, force);
        }
    }
    
    public static double lambda16(final double x) {
        return Math.cosh(x);
    }
    
    public static Complex lambda17(final Complex z) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       kawa/lib/numbers.Lit45:Lgnu/math/IntNum;
        //     6: aload_0         /* z */
        //     7: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    10: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    13: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    16: dup            
        //    17: astore_3       
        //    18: checkcast       Ljava/lang/Number;
        //    21: invokevirtual   java/lang/Number.doubleValue:()D
        //    24: dstore_1       
        //    25: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //    28: getstatic       kawa/lib/numbers.Lit45:Lgnu/math/IntNum;
        //    31: aload_0         /* z */
        //    32: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    35: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    38: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    41: dup            
        //    42: astore          5
        //    44: checkcast       Ljava/lang/Number;
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore_3        /* y */
        //    51: dload_1         /* x */
        //    52: invokestatic    java/lang/Math.cosh:(D)D
        //    55: dload_3         /* y */
        //    56: invokestatic    java/lang/Math.cos:(D)D
        //    59: dadd           
        //    60: dstore          w
        //    62: dload_1         /* x */
        //    63: invokestatic    java/lang/Math.sinh:(D)D
        //    66: dload           w
        //    68: ddiv           
        //    69: dload_3         /* y */
        //    70: invokestatic    java/lang/Math.sin:(D)D
        //    73: dload           w
        //    75: ddiv           
        //    76: invokestatic    gnu/math/Complex.make:(DD)Lgnu/math/Complex;
        //    79: areturn        
        //    80: new             Lgnu/mapping/WrongType;
        //    83: dup_x1         
        //    84: swap           
        //    85: ldc_w           "x"
        //    88: bipush          -2
        //    90: aload_3        
        //    91: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    94: athrow         
        //    95: new             Lgnu/mapping/WrongType;
        //    98: dup_x1         
        //    99: swap           
        //   100: ldc_w           "y"
        //   103: bipush          -2
        //   105: aload           5
        //   107: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   110: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  18     24     80     95     Ljava/lang/ClassCastException;
        //  44     50     95     111    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Quaternion lambda18(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/numbers.exp:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: dup            
        //     5: astore_2       
        //     6: checkcast       Lgnu/math/Quaternion;
        //     9: astore_1       
        //    10: getstatic       gnu/kawa/functions/AddOp.$Mn:Lgnu/kawa/functions/AddOp;
        //    13: aload_0         /* q */
        //    14: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    17: ldc             Ljava/lang/Number;.class
        //    19: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    22: dup            
        //    23: astore_3       
        //    24: checkcast       Ljava/lang/Number;
        //    27: invokestatic    kawa/lib/numbers.exp:(Ljava/lang/Number;)Ljava/lang/Number;
        //    30: dup            
        //    31: astore_3       
        //    32: checkcast       Lgnu/math/Quaternion;
        //    35: astore_2        /* e$Up$Mnq */
        //    36: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //    39: iconst_m1      
        //    40: aload_1         /* e$Upq */
        //    41: aload_2         /* e$Up$Mnq */
        //    42: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    45: iconst_1       
        //    46: aload_1         /* e$Upq */
        //    47: aload_2         /* e$Up$Mnq */
        //    48: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    51: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    54: ldc             Lgnu/math/Quaternion;.class
        //    56: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    59: checkcast       Lgnu/math/Quaternion;
        //    62: areturn        
        //    63: new             Lgnu/mapping/WrongType;
        //    66: dup_x1         
        //    67: swap           
        //    68: ldc_w           "e^q"
        //    71: bipush          -2
        //    73: aload_2        
        //    74: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    77: athrow         
        //    78: new             Lgnu/mapping/WrongType;
        //    81: dup_x1         
        //    82: swap           
        //    83: ldc_w           "exp"
        //    86: iconst_0       
        //    87: aload_3        
        //    88: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    91: athrow         
        //    92: new             Lgnu/mapping/WrongType;
        //    95: dup_x1         
        //    96: swap           
        //    97: ldc_w           "e^-q"
        //   100: bipush          -2
        //   102: aload_3        
        //   103: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   106: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  6      9      63     78     Ljava/lang/ClassCastException;
        //  24     27     78     92     Ljava/lang/ClassCastException;
        //  32     35     92     107    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static double lambda19(final double x) {
        return Math.tanh(x);
    }
    
    public static Quaternion lambda20(final Quaternion q) {
        final GenericProc log = numbers.log;
        final int plusOrMinus = 1;
        final Object force = Promise.force(AddOp.apply2(1, MultiplyOp.$St.apply2(q, q), numbers.Lit2), Number.class);
        try {
            return (Quaternion)Promise.force(log.apply1(AddOp.apply2(plusOrMinus, q, sqrt((Number)force))), Quaternion.class);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "sqrt", 0, force);
        }
    }
    
    public static double lambda21(final double x) {
        return Math.log(x + Math.sqrt(x * x + 1.0));
    }
    
    public static Quaternion lambda22(final Quaternion q) {
        final GenericProc log = numbers.log;
        final int n = 1;
        final MultiplyOp $St = MultiplyOp.$St;
        Object o2;
        final Object o = o2 = Promise.force(AddOp.apply2(1, q, numbers.Lit2), Number.class);
        Number sqrt;
        Object o3;
        try {
            sqrt = sqrt((Number)o);
            o3 = (o2 = Promise.force(AddOp.apply2(-1, q, numbers.Lit2), Number.class));
            final Number n2 = (Number)o3;
            final Number n3 = sqrt(n2);
            final Object o4 = $St.apply2(sqrt, n3);
            final Object o5 = AddOp.apply2(n, q, o4);
            final Object o6 = log.apply1(o5);
            final Class<Quaternion> clazz = Quaternion.class;
            final Object o7 = Promise.force(o6, clazz);
            return (Quaternion)o7;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "sqrt", 0, o2);
        }
        try {
            final Number n2 = (Number)o3;
            final Number n3 = sqrt(n2);
            final Object o4 = $St.apply2(sqrt, n3);
            final Object o5 = AddOp.apply2(n, q, o4);
            final Object o6 = log.apply1(o5);
            final Class<Quaternion> clazz = Quaternion.class;
            final Object o7 = Promise.force(o6, clazz);
            return (Quaternion)o7;
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "sqrt", 0, o2);
        }
    }
    
    public static double lambda23(final double x) {
        return Math.log(x + Math.sqrt(x * x - 1.0));
    }
    
    public static Quaternion lambda24(final Quaternion q) {
        return (Quaternion)Promise.force(DivideOp.$Sl.apply2(AddOp.apply2(-1, numbers.log.apply1(AddOp.apply2(1, numbers.Lit2, q)), numbers.log.apply1(AddOp.apply2(-1, numbers.Lit2, q))), numbers.Lit45), Quaternion.class);
    }
    
    public static double lambda25(final double x) {
        return 0.5 * Math.log((1.0 + x) / (1.0 - x));
    }
    
    public static Complex lambda26(final RealNum x, final RealNum y) {
        return Complex.make(x, y);
    }
    
    public static Quaternion lambda27(final RealNum w, final RealNum x, final RealNum y, final RealNum z) {
        return Quaternion.make(w, x, y, z);
    }
    
    public static Complex lambda28(final double x, final double y) {
        return Complex.polar(x, y);
    }
    
    public static Quaternion lambda29(final double r, final double t, final double u, final double v) {
        return Quaternion.polar(r, t, u, v);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 63: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 62: {
                final Object force = Promise.force(o, Quaternion.class);
                if (!(force instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 61: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 60: {
                final Object force2 = Promise.force(o, Quaternion.class);
                if (!(force2 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 59: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 58: {
                final Object force3 = Promise.force(o, Quaternion.class);
                if (!(force3 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 57: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 56: {
                final Object force4 = Promise.force(o, Quaternion.class);
                if (!(force4 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 55: {
                final Object force5 = Promise.force(o, Complex.class);
                if (!(force5 instanceof Complex)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 54: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 53: {
                final Object force6 = Promise.force(o, Quaternion.class);
                if (!(force6 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 52: {
                final Object force7 = Promise.force(o, Complex.class);
                if (!(force7 instanceof Complex)) {
                    return -786431;
                }
                ctx.value1 = force7;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 51: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 50: {
                final Object force8 = Promise.force(o, Quaternion.class);
                if (!(force8 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 49: {
                final Object force9 = Promise.force(o, Complex.class);
                if (!(force9 instanceof Complex)) {
                    return -786431;
                }
                ctx.value1 = force9;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 48: {
                final Object force10 = Promise.force(o, Number.class);
                if (!(force10 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force10;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 44: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 43: {
                final Object force11 = Promise.force(o, Quaternion.class);
                if (!(force11 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force11;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 42: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 41: {
                final Object force12 = Promise.force(o, Quaternion.class);
                if (!(force12 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force12;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 40: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 39: {
                final Object force13 = Promise.force(o, Quaternion.class);
                if (!(force13 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force13;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 38: {
                final Object force14 = Promise.force(o, Number.class);
                if (!(force14 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force14;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 102: {
                final Object force15 = Promise.force(o, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force15) != null) {
                    ctx.value1 = force15;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 101: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 99: {
                final Object force16 = Promise.force(o, Quantity.class);
                if (!(force16 instanceof Quantity)) {
                    return -786431;
                }
                ctx.value1 = force16;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 98: {
                final Object force17 = Promise.force(o, Quantity.class);
                if (!(force17 instanceof Quantity)) {
                    return -786431;
                }
                ctx.value1 = force17;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 96: {
                final Object force18 = Promise.force(o, CharSequence.class);
                if (force18 instanceof CharSequence) {
                    ctx.value1 = force18;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 94: {
                final Object force19 = Promise.force(o, Number.class);
                if (!(force19 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force19;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 91: {
                final Object force20 = Promise.force(o, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force20) != null) {
                    ctx.value1 = force20;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 90: {
                final Object force21 = Promise.force(o, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force21) != null) {
                    ctx.value1 = force21;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 89: {
                final Object force22 = Promise.force(o, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force22) != null) {
                    ctx.value1 = force22;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 88: {
                final Object force23 = Promise.force(o, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force23) != null) {
                    ctx.value1 = force23;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 80: {
                final Object force24 = Promise.force(o, Number.class);
                if (!(force24 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force24;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 79: {
                final Object force25 = Promise.force(o, Number.class);
                if (!(force25 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force25;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 78: {
                final Object force26 = Promise.force(o, Number.class);
                if (!(force26 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force26;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 77: {
                final Object force27 = Promise.force(o, Number.class);
                if (!(force27 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force27;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 76: {
                final Object force28 = Promise.force(o, Number.class);
                if (!(force28 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force28;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 75: {
                final Object force29 = Promise.force(o, Number.class);
                if (!(force29 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force29;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 74: {
                final Object force30 = Promise.force(o, Number.class);
                if (!(force30 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force30;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 73: {
                final Object force31 = Promise.force(o, Number.class);
                if (!(force31 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force31;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 72: {
                final Object force32 = Promise.force(o, Number.class);
                if (!(force32 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force32;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 71: {
                final Object force33 = Promise.force(o, Number.class);
                if (!(force33 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force33;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 70: {
                final Object force34 = Promise.force(o, Number.class);
                if (!(force34 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force34;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 65: {
                final Object force35 = Promise.force(o, Number.class);
                if (!(force35 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force35;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 64: {
                final Object force36 = Promise.force(o, Number.class);
                if (!(force36 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force36;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 46: {
                final Object force37 = Promise.force(o, Number.class);
                if (!(force37 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force37;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 45: {
                final Object force38 = Promise.force(o, Number.class);
                if (!(force38 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force38;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 36: {
                final Object force39 = Promise.force(o, Number.class);
                if (!(force39 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force39;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 34: {
                final Object force40 = Promise.force(o, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force40) != null) {
                    ctx.value1 = force40;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 33: {
                final Object force41 = Promise.force(o, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force41) != null) {
                    ctx.value1 = force41;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 32: {
                final Object force42 = Promise.force(o, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force42) != null) {
                    ctx.value1 = force42;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 31: {
                final Object force43 = Promise.force(o, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force43) != null) {
                    ctx.value1 = force43;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 30: {
                final Object force44 = Promise.force(o, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force44) != null) {
                    ctx.value1 = force44;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 29: {
                final Object force45 = Promise.force(o, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force45) != null) {
                    ctx.value1 = force45;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 22: {
                final Object force46 = Promise.force(o, Number.class);
                if (!(force46 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force46;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 19: {
                final Object force47 = Promise.force(o, Number.class);
                if (!(force47 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force47;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 18: {
                final Object force48 = Promise.force(o, Number.class);
                if (!(force48 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force48;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 17: {
                final Object force49 = Promise.force(o, Number.class);
                if (!(force49 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force49;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 16: {
                final Object force50 = Promise.force(o, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force50) != null) {
                    ctx.value1 = force50;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 15: {
                final Object force51 = Promise.force(o, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force51) != null) {
                    ctx.value1 = force51;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 14: {
                final Object force52 = Promise.force(o, Number.class);
                if (!(force52 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force52;
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
            case 12: {
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
            case 9: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 8: {
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
            case 1: {
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
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 68: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 66: {
                final Object force = Promise.force(arg1, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force) == null) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force2) != null) {
                    ctx.value2 = force2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 47: {
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
            case 37: {
                final Object force5 = Promise.force(arg1, Number.class);
                if (!(force5 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force5;
                final Object force6 = Promise.force(arg2, Number.class);
                if (!(force6 instanceof Number)) {
                    return -786430;
                }
                ctx.value2 = force6;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 100: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 96: {
                final Object force7 = Promise.force(arg1, CharSequence.class);
                if (force7 instanceof CharSequence) {
                    ctx.value1 = force7;
                    ctx.value2 = Promise.force(arg2);
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 94: {
                final Object force8 = Promise.force(arg1, Number.class);
                if (!(force8 instanceof Number)) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 87: {
                final Object force9 = Promise.force(arg1, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force9) == null) {
                    return -786431;
                }
                ctx.value1 = force9;
                final Object force10 = Promise.force(arg2, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force10) != null) {
                    ctx.value2 = force10;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 82: {
                final Object force11 = Promise.force(arg1, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force11) != null) {
                    ctx.value1 = force11;
                    ctx.value2 = Promise.force(arg2);
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 35: {
                final Object force12 = Promise.force(arg1, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force12) == null) {
                    return -786431;
                }
                ctx.value1 = force12;
                final Object force13 = Promise.force(arg2, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force13) != null) {
                    ctx.value2 = force13;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 26: {
                final Object force14 = Promise.force(arg1, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force14) == null) {
                    return -786431;
                }
                ctx.value1 = force14;
                final Object force15 = Promise.force(arg2, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force15) != null) {
                    ctx.value2 = force15;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 25: {
                final Object force16 = Promise.force(arg1, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force16) == null) {
                    return -786431;
                }
                ctx.value1 = force16;
                final Object force17 = Promise.force(arg2, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force17) != null) {
                    ctx.value2 = force17;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 24: {
                final Object force18 = Promise.force(arg1, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force18) == null) {
                    return -786431;
                }
                ctx.value1 = force18;
                final Object force19 = Promise.force(arg2, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force19) != null) {
                    ctx.value2 = force19;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 23: {
                final Object force20 = Promise.force(arg1, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force20) == null) {
                    return -786431;
                }
                ctx.value1 = force20;
                final Object force21 = Promise.force(arg2, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force21) != null) {
                    ctx.value2 = force21;
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
        switch (moduleMethod.selector) {
            case 93: {
                final Object force = Promise.force(o, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force) != null) {
                    ctx.value1 = force;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 86: {
                final Object force2 = Promise.force(o, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force2) == null) {
                    return -786431;
                }
                ctx.value1 = force2;
                final Object force3 = Promise.force(o2, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force3) == null) {
                    return -786430;
                }
                ctx.value2 = force3;
                final Object force4 = Promise.force(o3, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force4) != null) {
                    ctx.value3 = force4;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 85: {
                final Object force5 = Promise.force(o, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force5) != null) {
                    ctx.value1 = force5;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 83: {
                final Object force6 = Promise.force(o, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force6) != null) {
                    ctx.value1 = force6;
                    ctx.value2 = Promise.force(o2);
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 81: {
                ctx.value1 = Promise.force(o);
                final Object force7 = Promise.force(o2, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force7) == null) {
                    return -786430;
                }
                ctx.value2 = force7;
                final Object force8 = Promise.force(o3, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force8) != null) {
                    ctx.value3 = force8;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            default: {
                return super.match3(moduleMethod, o, o2, o3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        switch (proc.selector) {
            case 69: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = Promise.force(arg2);
                ctx.value3 = Promise.force(arg3);
                ctx.value4 = Promise.force(arg4);
                ctx.proc = proc;
                ctx.pc = 4;
                return 0;
            }
            case 67: {
                final Object force = Promise.force(arg1, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force) == null) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force2) == null) {
                    return -786430;
                }
                ctx.value2 = force2;
                final Object force3 = Promise.force(arg3, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force3) == null) {
                    return -786429;
                }
                ctx.value3 = force3;
                final Object force4 = Promise.force(arg4, RealNum.class);
                if (gnu.math.RealNum.asRealNumOrNull(force4) != null) {
                    ctx.value4 = force4;
                    ctx.proc = proc;
                    ctx.pc = 4;
                    return 0;
                }
                return -786428;
            }
            case 92: {
                final Object force5 = Promise.force(arg1, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force5) != null) {
                    ctx.value1 = force5;
                    ctx.value2 = Promise.force(arg2);
                    ctx.value3 = Promise.force(arg3);
                    ctx.value4 = Promise.force(arg4);
                    ctx.proc = proc;
                    ctx.pc = 4;
                    return 0;
                }
                return -786431;
            }
            case 84: {
                final Object force6 = Promise.force(arg1, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force6) == null) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.value2 = Promise.force(arg2);
                ctx.value3 = Promise.force(arg3);
                final Object force7 = Promise.force(arg4, IntNum.class);
                if (gnu.math.IntNum.asIntNumOrNull(force7) != null) {
                    ctx.value4 = force7;
                    ctx.proc = proc;
                    ctx.pc = 4;
                    return 0;
                }
                return -786428;
            }
            default: {
                return super.match4(proc, arg1, arg2, arg3, arg4, ctx);
            }
        }
    }
    
    @Override
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        switch (proc.selector) {
            case 28: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 27: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 21: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 20: {
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
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                2: 428
        //                3: 445
        //                4: 462
        //                5: 479
        //                6: 496
        //                7: 513
        //                8: 530
        //                9: 547
        //               10: 564
        //               11: 581
        //               12: 598
        //               13: 615
        //               14: 632
        //               15: 649
        //               16: 674
        //               17: 699
        //               18: 724
        //               19: 749
        //               20: 774
        //               21: 1568
        //               22: 1568
        //               23: 799
        //               24: 1568
        //               25: 1568
        //               26: 1568
        //               27: 1568
        //               28: 1568
        //               29: 1568
        //               30: 812
        //               31: 825
        //               32: 838
        //               33: 851
        //               34: 864
        //               35: 877
        //               36: 1568
        //               37: 890
        //               38: 1568
        //               39: 1233
        //               40: 1246
        //               41: 1259
        //               42: 1276
        //               43: 1289
        //               44: 1306
        //               45: 1319
        //               46: 903
        //               47: 916
        //               48: 1568
        //               49: 1336
        //               50: 1349
        //               51: 1362
        //               52: 1375
        //               53: 1392
        //               54: 1405
        //               55: 1418
        //               56: 1435
        //               57: 1448
        //               58: 1461
        //               59: 1478
        //               60: 1491
        //               61: 1508
        //               62: 1521
        //               63: 1538
        //               64: 1551
        //               65: 929
        //               66: 942
        //               67: 1568
        //               68: 1568
        //               69: 1568
        //               70: 1568
        //               71: 955
        //               72: 968
        //               73: 981
        //               74: 994
        //               75: 1007
        //               76: 1020
        //               77: 1033
        //               78: 1046
        //               79: 1059
        //               80: 1072
        //               81: 1085
        //               82: 1568
        //               83: 1568
        //               84: 1568
        //               85: 1568
        //               86: 1568
        //               87: 1568
        //               88: 1568
        //               89: 1098
        //               90: 1114
        //               91: 1130
        //               92: 1146
        //               93: 1568
        //               94: 1568
        //               95: 1162
        //               96: 1568
        //               97: 1175
        //               98: 1568
        //               99: 1189
        //              100: 1202
        //              101: 1568
        //              102: 1215
        //              103: 1220
        //          default: 1568
        //        }
        //   428: aload_2        
        //   429: invokestatic    kawa/lib/numbers.isNumber:(Ljava/lang/Object;)Z
        //   432: ifeq            441
        //   435: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   438: goto            444
        //   441: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   444: areturn        
        //   445: aload_2        
        //   446: invokestatic    kawa/lib/numbers.isQuantity:(Ljava/lang/Object;)Z
        //   449: ifeq            458
        //   452: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   455: goto            461
        //   458: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   461: areturn        
        //   462: aload_2        
        //   463: invokestatic    kawa/lib/numbers.isQuaternion:(Ljava/lang/Object;)Z
        //   466: ifeq            475
        //   469: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   472: goto            478
        //   475: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   478: areturn        
        //   479: aload_2        
        //   480: invokestatic    kawa/lib/numbers.isComplex:(Ljava/lang/Object;)Z
        //   483: ifeq            492
        //   486: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   489: goto            495
        //   492: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   495: areturn        
        //   496: aload_2        
        //   497: invokestatic    kawa/lib/numbers.isReal:(Ljava/lang/Object;)Z
        //   500: ifeq            509
        //   503: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   506: goto            512
        //   509: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   512: areturn        
        //   513: aload_2        
        //   514: invokestatic    kawa/lib/numbers.isRational:(Ljava/lang/Object;)Z
        //   517: ifeq            526
        //   520: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   523: goto            529
        //   526: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   529: areturn        
        //   530: aload_2        
        //   531: invokestatic    kawa/lib/numbers.isInteger:(Ljava/lang/Object;)Z
        //   534: ifeq            543
        //   537: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   540: goto            546
        //   543: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   546: areturn        
        //   547: aload_2        
        //   548: invokestatic    kawa/lib/numbers.isExactInteger:(Ljava/lang/Object;)Z
        //   551: ifeq            560
        //   554: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   557: goto            563
        //   560: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   563: areturn        
        //   564: aload_2        
        //   565: invokestatic    kawa/lib/numbers.isRealValued:(Ljava/lang/Object;)Z
        //   568: ifeq            577
        //   571: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   574: goto            580
        //   577: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   580: areturn        
        //   581: aload_2        
        //   582: invokestatic    kawa/lib/numbers.isRationalValued:(Ljava/lang/Object;)Z
        //   585: ifeq            594
        //   588: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   591: goto            597
        //   594: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   597: areturn        
        //   598: aload_2        
        //   599: invokestatic    kawa/lib/numbers.isIntegerValued:(Ljava/lang/Object;)Z
        //   602: ifeq            611
        //   605: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   608: goto            614
        //   611: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   614: areturn        
        //   615: aload_2        
        //   616: invokestatic    kawa/lib/numbers.isExact:(Ljava/lang/Object;)Z
        //   619: ifeq            628
        //   622: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   625: goto            631
        //   628: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   631: areturn        
        //   632: aload_2        
        //   633: invokestatic    kawa/lib/numbers.isInexact:(Ljava/lang/Object;)Z
        //   636: ifeq            645
        //   639: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   642: goto            648
        //   645: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   648: areturn        
        //   649: aload_2        
        //   650: ldc             Ljava/lang/Number;.class
        //   652: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   655: checkcast       Ljava/lang/Number;
        //   658: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //   661: ifeq            670
        //   664: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   667: goto            673
        //   670: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   673: areturn        
        //   674: aload_2        
        //   675: ldc             Lgnu/math/RealNum;.class
        //   677: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   680: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   683: invokestatic    kawa/lib/numbers.isPositive:(Lgnu/math/RealNum;)Z
        //   686: ifeq            695
        //   689: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   692: goto            698
        //   695: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   698: areturn        
        //   699: aload_2        
        //   700: ldc             Lgnu/math/RealNum;.class
        //   702: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   705: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   708: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
        //   711: ifeq            720
        //   714: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   717: goto            723
        //   720: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   723: areturn        
        //   724: aload_2        
        //   725: ldc             Ljava/lang/Number;.class
        //   727: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   730: checkcast       Ljava/lang/Number;
        //   733: invokestatic    kawa/lib/numbers.isFinite:(Ljava/lang/Number;)Z
        //   736: ifeq            745
        //   739: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   742: goto            748
        //   745: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   748: areturn        
        //   749: aload_2        
        //   750: ldc             Ljava/lang/Number;.class
        //   752: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   755: checkcast       Ljava/lang/Number;
        //   758: invokestatic    kawa/lib/numbers.isInfinite:(Ljava/lang/Number;)Z
        //   761: ifeq            770
        //   764: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   767: goto            773
        //   770: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   773: areturn        
        //   774: aload_2        
        //   775: ldc             Ljava/lang/Number;.class
        //   777: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   780: checkcast       Ljava/lang/Number;
        //   783: invokestatic    kawa/lib/numbers.isNan:(Ljava/lang/Number;)Z
        //   786: ifeq            795
        //   789: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   792: goto            798
        //   795: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   798: areturn        
        //   799: aload_2        
        //   800: ldc             Ljava/lang/Number;.class
        //   802: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   805: checkcast       Ljava/lang/Number;
        //   808: invokestatic    kawa/lib/numbers.abs:(Ljava/lang/Number;)Ljava/lang/Number;
        //   811: areturn        
        //   812: aload_2        
        //   813: ldc             Lgnu/math/RealNum;.class
        //   815: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   818: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   821: invokestatic    kawa/lib/numbers.numerator:(Lgnu/math/RealNum;)Lgnu/math/RealNum;
        //   824: areturn        
        //   825: aload_2        
        //   826: ldc             Lgnu/math/RealNum;.class
        //   828: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   831: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   834: invokestatic    kawa/lib/numbers.denominator:(Lgnu/math/RealNum;)Lgnu/math/RealNum;
        //   837: areturn        
        //   838: aload_2        
        //   839: ldc             Lgnu/math/RealNum;.class
        //   841: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   844: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   847: invokestatic    kawa/lib/numbers.floor:(Lgnu/math/RealNum;)Lgnu/math/RealNum;
        //   850: areturn        
        //   851: aload_2        
        //   852: ldc             Lgnu/math/RealNum;.class
        //   854: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   857: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   860: invokestatic    kawa/lib/numbers.ceiling:(Lgnu/math/RealNum;)Lgnu/math/RealNum;
        //   863: areturn        
        //   864: aload_2        
        //   865: ldc             Lgnu/math/RealNum;.class
        //   867: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   870: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   873: invokestatic    kawa/lib/numbers.truncate:(Lgnu/math/RealNum;)Lgnu/math/RealNum;
        //   876: areturn        
        //   877: aload_2        
        //   878: ldc             Lgnu/math/RealNum;.class
        //   880: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   883: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   886: invokestatic    kawa/lib/numbers.round:(Lgnu/math/RealNum;)Lgnu/math/RealNum;
        //   889: areturn        
        //   890: aload_2        
        //   891: ldc             Ljava/lang/Number;.class
        //   893: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   896: checkcast       Ljava/lang/Number;
        //   899: invokestatic    kawa/lib/numbers.exp:(Ljava/lang/Number;)Ljava/lang/Number;
        //   902: areturn        
        //   903: aload_2        
        //   904: ldc             Ljava/lang/Number;.class
        //   906: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   909: checkcast       Ljava/lang/Number;
        //   912: invokestatic    kawa/lib/numbers.asin:(Ljava/lang/Number;)Ljava/lang/Number;
        //   915: areturn        
        //   916: aload_2        
        //   917: ldc             Ljava/lang/Number;.class
        //   919: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   922: checkcast       Ljava/lang/Number;
        //   925: invokestatic    kawa/lib/numbers.acos:(Ljava/lang/Number;)Ljava/lang/Number;
        //   928: areturn        
        //   929: aload_2        
        //   930: ldc             Ljava/lang/Number;.class
        //   932: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   935: checkcast       Ljava/lang/Number;
        //   938: invokestatic    kawa/lib/numbers.sqrt:(Ljava/lang/Number;)Ljava/lang/Number;
        //   941: areturn        
        //   942: aload_2        
        //   943: ldc             Ljava/lang/Number;.class
        //   945: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   948: checkcast       Ljava/lang/Number;
        //   951: invokestatic    kawa/lib/numbers.square:(Ljava/lang/Number;)Ljava/lang/Number;
        //   954: areturn        
        //   955: aload_2        
        //   956: ldc             Ljava/lang/Number;.class
        //   958: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   961: checkcast       Ljava/lang/Number;
        //   964: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //   967: areturn        
        //   968: aload_2        
        //   969: ldc             Ljava/lang/Number;.class
        //   971: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   974: checkcast       Ljava/lang/Number;
        //   977: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //   980: areturn        
        //   981: aload_2        
        //   982: ldc             Ljava/lang/Number;.class
        //   984: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   987: checkcast       Ljava/lang/Number;
        //   990: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //   993: areturn        
        //   994: aload_2        
        //   995: ldc             Ljava/lang/Number;.class
        //   997: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1000: checkcast       Ljava/lang/Number;
        //  1003: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //  1006: areturn        
        //  1007: aload_2        
        //  1008: ldc             Ljava/lang/Number;.class
        //  1010: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1013: checkcast       Ljava/lang/Number;
        //  1016: invokestatic    kawa/lib/numbers.unitVector:(Ljava/lang/Number;)Lgnu/math/Quaternion;
        //  1019: areturn        
        //  1020: aload_2        
        //  1021: ldc             Ljava/lang/Number;.class
        //  1023: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1026: checkcast       Ljava/lang/Number;
        //  1029: invokestatic    kawa/lib/numbers.magnitude:(Ljava/lang/Number;)Ljava/lang/Number;
        //  1032: areturn        
        //  1033: aload_2        
        //  1034: ldc             Ljava/lang/Number;.class
        //  1036: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1039: checkcast       Ljava/lang/Number;
        //  1042: invokestatic    kawa/lib/numbers.angle:(Ljava/lang/Number;)Lgnu/math/RealNum;
        //  1045: areturn        
        //  1046: aload_2        
        //  1047: ldc             Ljava/lang/Number;.class
        //  1049: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1052: checkcast       Ljava/lang/Number;
        //  1055: invokestatic    kawa/lib/numbers.inexact:(Ljava/lang/Number;)Ljava/lang/Number;
        //  1058: areturn        
        //  1059: aload_2        
        //  1060: ldc             Ljava/lang/Number;.class
        //  1062: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1065: checkcast       Ljava/lang/Number;
        //  1068: invokestatic    kawa/lib/numbers.exact:(Ljava/lang/Number;)Ljava/lang/Number;
        //  1071: areturn        
        //  1072: aload_2        
        //  1073: ldc             Ljava/lang/Number;.class
        //  1075: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1078: checkcast       Ljava/lang/Number;
        //  1081: invokestatic    kawa/lib/numbers.exact$To$Inexact:(Ljava/lang/Number;)Ljava/lang/Number;
        //  1084: areturn        
        //  1085: aload_2        
        //  1086: ldc             Ljava/lang/Number;.class
        //  1088: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1091: checkcast       Ljava/lang/Number;
        //  1094: invokestatic    kawa/lib/numbers.inexact$To$Exact:(Ljava/lang/Number;)Ljava/lang/Number;
        //  1097: areturn        
        //  1098: aload_2        
        //  1099: ldc             Lgnu/math/IntNum;.class
        //  1101: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1104: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //  1107: invokestatic    kawa/lib/numbers.logcount:(Lgnu/math/IntNum;)I
        //  1110: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  1113: areturn        
        //  1114: aload_2        
        //  1115: ldc             Lgnu/math/IntNum;.class
        //  1117: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1120: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //  1123: invokestatic    kawa/lib/numbers.bitwiseBitCount:(Lgnu/math/IntNum;)I
        //  1126: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  1129: areturn        
        //  1130: aload_2        
        //  1131: ldc             Lgnu/math/IntNum;.class
        //  1133: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1136: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //  1139: invokestatic    kawa/lib/numbers.bitwiseLength:(Lgnu/math/IntNum;)I
        //  1142: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  1145: areturn        
        //  1146: aload_2        
        //  1147: ldc             Lgnu/math/IntNum;.class
        //  1149: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1152: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //  1155: invokestatic    kawa/lib/numbers.bitwiseFirstBitSet:(Lgnu/math/IntNum;)I
        //  1158: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  1161: areturn        
        //  1162: aload_2        
        //  1163: ldc             Ljava/lang/Number;.class
        //  1165: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1168: checkcast       Ljava/lang/Number;
        //  1171: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
        //  1174: areturn        
        //  1175: aload_2        
        //  1176: ldc_w           Ljava/lang/CharSequence;.class
        //  1179: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1182: checkcast       Ljava/lang/CharSequence;
        //  1185: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;)Ljava/lang/Object;
        //  1188: areturn        
        //  1189: aload_2        
        //  1190: ldc             Lgnu/math/Quantity;.class
        //  1192: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1195: checkcast       Lgnu/math/Quantity;
        //  1198: invokestatic    kawa/lib/numbers.quantity$To$Number:(Lgnu/math/Quantity;)Lgnu/math/Quaternion;
        //  1201: areturn        
        //  1202: aload_2        
        //  1203: ldc             Lgnu/math/Quantity;.class
        //  1205: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1208: checkcast       Lgnu/math/Quantity;
        //  1211: invokestatic    kawa/lib/numbers.quantity$To$Unit:(Lgnu/math/Quantity;)Lgnu/math/Unit;
        //  1214: areturn        
        //  1215: aload_2        
        //  1216: invokestatic    kawa/lib/numbers.duration:(Ljava/lang/Object;)Lgnu/math/Duration;
        //  1219: areturn        
        //  1220: aload_2        
        //  1221: ldc             Lgnu/math/IntNum;.class
        //  1223: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1226: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //  1229: invokestatic    kawa/lib/numbers.exactIntegerSqrt:(Lgnu/math/IntNum;)Ljava/lang/Object;
        //  1232: areturn        
        //  1233: aload_2        
        //  1234: ldc             Ljava/lang/Number;.class
        //  1236: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1239: checkcast       Ljava/lang/Number;
        //  1242: invokestatic    kawa/lib/numbers.lambda2:(Ljava/lang/Number;)Ljava/lang/Number;
        //  1245: areturn        
        //  1246: aload_2        
        //  1247: ldc             Lgnu/math/Quaternion;.class
        //  1249: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1252: checkcast       Lgnu/math/Quaternion;
        //  1255: invokestatic    kawa/lib/numbers.lambda3:(Lgnu/math/Quaternion;)Lgnu/math/Quaternion;
        //  1258: areturn        
        //  1259: aload_2        
        //  1260: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1263: checkcast       Ljava/lang/Number;
        //  1266: invokevirtual   java/lang/Number.doubleValue:()D
        //  1269: invokestatic    kawa/lib/numbers.lambda4:(D)D
        //  1272: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //  1275: areturn        
        //  1276: aload_2        
        //  1277: ldc             Lgnu/math/Quaternion;.class
        //  1279: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1282: checkcast       Lgnu/math/Quaternion;
        //  1285: invokestatic    kawa/lib/numbers.lambda5:(Lgnu/math/Quaternion;)Lgnu/math/Quaternion;
        //  1288: areturn        
        //  1289: aload_2        
        //  1290: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1293: checkcast       Ljava/lang/Number;
        //  1296: invokevirtual   java/lang/Number.doubleValue:()D
        //  1299: invokestatic    kawa/lib/numbers.lambda6:(D)D
        //  1302: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //  1305: areturn        
        //  1306: aload_2        
        //  1307: ldc             Lgnu/math/Quaternion;.class
        //  1309: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1312: checkcast       Lgnu/math/Quaternion;
        //  1315: invokestatic    kawa/lib/numbers.lambda7:(Lgnu/math/Quaternion;)Lgnu/math/Quaternion;
        //  1318: areturn        
        //  1319: aload_2        
        //  1320: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1323: checkcast       Ljava/lang/Number;
        //  1326: invokevirtual   java/lang/Number.doubleValue:()D
        //  1329: invokestatic    kawa/lib/numbers.lambda8:(D)D
        //  1332: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //  1335: areturn        
        //  1336: aload_2        
        //  1337: ldc             Ljava/lang/Number;.class
        //  1339: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1342: checkcast       Ljava/lang/Number;
        //  1345: invokestatic    kawa/lib/numbers.lambda10:(Ljava/lang/Number;)Ljava/lang/Number;
        //  1348: areturn        
        //  1349: aload_2        
        //  1350: ldc             Lgnu/math/Complex;.class
        //  1352: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1355: checkcast       Lgnu/math/Complex;
        //  1358: invokestatic    kawa/lib/numbers.lambda11:(Lgnu/math/Complex;)Lgnu/math/Complex;
        //  1361: areturn        
        //  1362: aload_2        
        //  1363: ldc             Lgnu/math/Quaternion;.class
        //  1365: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1368: checkcast       Lgnu/math/Quaternion;
        //  1371: invokestatic    kawa/lib/numbers.lambda12:(Lgnu/math/Quaternion;)Lgnu/math/Quaternion;
        //  1374: areturn        
        //  1375: aload_2        
        //  1376: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1379: checkcast       Ljava/lang/Number;
        //  1382: invokevirtual   java/lang/Number.doubleValue:()D
        //  1385: invokestatic    kawa/lib/numbers.lambda13:(D)D
        //  1388: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //  1391: areturn        
        //  1392: aload_2        
        //  1393: ldc             Lgnu/math/Complex;.class
        //  1395: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1398: checkcast       Lgnu/math/Complex;
        //  1401: invokestatic    kawa/lib/numbers.lambda14:(Lgnu/math/Complex;)Lgnu/math/Complex;
        //  1404: areturn        
        //  1405: aload_2        
        //  1406: ldc             Lgnu/math/Quaternion;.class
        //  1408: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1411: checkcast       Lgnu/math/Quaternion;
        //  1414: invokestatic    kawa/lib/numbers.lambda15:(Lgnu/math/Quaternion;)Lgnu/math/Quaternion;
        //  1417: areturn        
        //  1418: aload_2        
        //  1419: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1422: checkcast       Ljava/lang/Number;
        //  1425: invokevirtual   java/lang/Number.doubleValue:()D
        //  1428: invokestatic    kawa/lib/numbers.lambda16:(D)D
        //  1431: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //  1434: areturn        
        //  1435: aload_2        
        //  1436: ldc             Lgnu/math/Complex;.class
        //  1438: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1441: checkcast       Lgnu/math/Complex;
        //  1444: invokestatic    kawa/lib/numbers.lambda17:(Lgnu/math/Complex;)Lgnu/math/Complex;
        //  1447: areturn        
        //  1448: aload_2        
        //  1449: ldc             Lgnu/math/Quaternion;.class
        //  1451: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1454: checkcast       Lgnu/math/Quaternion;
        //  1457: invokestatic    kawa/lib/numbers.lambda18:(Lgnu/math/Quaternion;)Lgnu/math/Quaternion;
        //  1460: areturn        
        //  1461: aload_2        
        //  1462: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1465: checkcast       Ljava/lang/Number;
        //  1468: invokevirtual   java/lang/Number.doubleValue:()D
        //  1471: invokestatic    kawa/lib/numbers.lambda19:(D)D
        //  1474: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //  1477: areturn        
        //  1478: aload_2        
        //  1479: ldc             Lgnu/math/Quaternion;.class
        //  1481: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1484: checkcast       Lgnu/math/Quaternion;
        //  1487: invokestatic    kawa/lib/numbers.lambda20:(Lgnu/math/Quaternion;)Lgnu/math/Quaternion;
        //  1490: areturn        
        //  1491: aload_2        
        //  1492: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1495: checkcast       Ljava/lang/Number;
        //  1498: invokevirtual   java/lang/Number.doubleValue:()D
        //  1501: invokestatic    kawa/lib/numbers.lambda21:(D)D
        //  1504: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //  1507: areturn        
        //  1508: aload_2        
        //  1509: ldc             Lgnu/math/Quaternion;.class
        //  1511: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1514: checkcast       Lgnu/math/Quaternion;
        //  1517: invokestatic    kawa/lib/numbers.lambda22:(Lgnu/math/Quaternion;)Lgnu/math/Quaternion;
        //  1520: areturn        
        //  1521: aload_2        
        //  1522: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1525: checkcast       Ljava/lang/Number;
        //  1528: invokevirtual   java/lang/Number.doubleValue:()D
        //  1531: invokestatic    kawa/lib/numbers.lambda23:(D)D
        //  1534: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //  1537: areturn        
        //  1538: aload_2        
        //  1539: ldc             Lgnu/math/Quaternion;.class
        //  1541: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1544: checkcast       Lgnu/math/Quaternion;
        //  1547: invokestatic    kawa/lib/numbers.lambda24:(Lgnu/math/Quaternion;)Lgnu/math/Quaternion;
        //  1550: areturn        
        //  1551: aload_2        
        //  1552: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1555: checkcast       Ljava/lang/Number;
        //  1558: invokevirtual   java/lang/Number.doubleValue:()D
        //  1561: invokestatic    kawa/lib/numbers.lambda25:(D)D
        //  1564: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //  1567: areturn        
        //  1568: aload_0        
        //  1569: aload_1        
        //  1570: aload_2        
        //  1571: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //  1574: areturn        
        //  1575: new             Lgnu/mapping/WrongType;
        //  1578: dup_x1         
        //  1579: swap           
        //  1580: ldc_w           "zero?"
        //  1583: iconst_1       
        //  1584: aload_2        
        //  1585: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1588: athrow         
        //  1589: new             Lgnu/mapping/WrongType;
        //  1592: dup_x1         
        //  1593: swap           
        //  1594: ldc_w           "positive?"
        //  1597: iconst_1       
        //  1598: aload_2        
        //  1599: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1602: athrow         
        //  1603: new             Lgnu/mapping/WrongType;
        //  1606: dup_x1         
        //  1607: swap           
        //  1608: ldc_w           "negative?"
        //  1611: iconst_1       
        //  1612: aload_2        
        //  1613: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1616: athrow         
        //  1617: new             Lgnu/mapping/WrongType;
        //  1620: dup_x1         
        //  1621: swap           
        //  1622: ldc_w           "finite?"
        //  1625: iconst_1       
        //  1626: aload_2        
        //  1627: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1630: athrow         
        //  1631: new             Lgnu/mapping/WrongType;
        //  1634: dup_x1         
        //  1635: swap           
        //  1636: ldc_w           "infinite?"
        //  1639: iconst_1       
        //  1640: aload_2        
        //  1641: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1644: athrow         
        //  1645: new             Lgnu/mapping/WrongType;
        //  1648: dup_x1         
        //  1649: swap           
        //  1650: ldc_w           "nan?"
        //  1653: iconst_1       
        //  1654: aload_2        
        //  1655: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1658: athrow         
        //  1659: new             Lgnu/mapping/WrongType;
        //  1662: dup_x1         
        //  1663: swap           
        //  1664: ldc_w           "abs"
        //  1667: iconst_1       
        //  1668: aload_2        
        //  1669: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1672: athrow         
        //  1673: new             Lgnu/mapping/WrongType;
        //  1676: dup_x1         
        //  1677: swap           
        //  1678: ldc_w           "numerator"
        //  1681: iconst_1       
        //  1682: aload_2        
        //  1683: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1686: athrow         
        //  1687: new             Lgnu/mapping/WrongType;
        //  1690: dup_x1         
        //  1691: swap           
        //  1692: ldc_w           "denominator"
        //  1695: iconst_1       
        //  1696: aload_2        
        //  1697: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1700: athrow         
        //  1701: new             Lgnu/mapping/WrongType;
        //  1704: dup_x1         
        //  1705: swap           
        //  1706: ldc_w           "floor"
        //  1709: iconst_1       
        //  1710: aload_2        
        //  1711: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1714: athrow         
        //  1715: new             Lgnu/mapping/WrongType;
        //  1718: dup_x1         
        //  1719: swap           
        //  1720: ldc_w           "ceiling"
        //  1723: iconst_1       
        //  1724: aload_2        
        //  1725: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1728: athrow         
        //  1729: new             Lgnu/mapping/WrongType;
        //  1732: dup_x1         
        //  1733: swap           
        //  1734: ldc_w           "truncate"
        //  1737: iconst_1       
        //  1738: aload_2        
        //  1739: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1742: athrow         
        //  1743: new             Lgnu/mapping/WrongType;
        //  1746: dup_x1         
        //  1747: swap           
        //  1748: ldc_w           "round"
        //  1751: iconst_1       
        //  1752: aload_2        
        //  1753: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1756: athrow         
        //  1757: new             Lgnu/mapping/WrongType;
        //  1760: dup_x1         
        //  1761: swap           
        //  1762: ldc_w           "exp"
        //  1765: iconst_1       
        //  1766: aload_2        
        //  1767: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1770: athrow         
        //  1771: new             Lgnu/mapping/WrongType;
        //  1774: dup_x1         
        //  1775: swap           
        //  1776: ldc_w           "asin"
        //  1779: iconst_1       
        //  1780: aload_2        
        //  1781: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1784: athrow         
        //  1785: new             Lgnu/mapping/WrongType;
        //  1788: dup_x1         
        //  1789: swap           
        //  1790: ldc_w           "acos"
        //  1793: iconst_1       
        //  1794: aload_2        
        //  1795: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1798: athrow         
        //  1799: new             Lgnu/mapping/WrongType;
        //  1802: dup_x1         
        //  1803: swap           
        //  1804: ldc_w           "sqrt"
        //  1807: iconst_1       
        //  1808: aload_2        
        //  1809: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1812: athrow         
        //  1813: new             Lgnu/mapping/WrongType;
        //  1816: dup_x1         
        //  1817: swap           
        //  1818: ldc_w           "square"
        //  1821: iconst_1       
        //  1822: aload_2        
        //  1823: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1826: athrow         
        //  1827: new             Lgnu/mapping/WrongType;
        //  1830: dup_x1         
        //  1831: swap           
        //  1832: ldc             "real-part"
        //  1834: iconst_1       
        //  1835: aload_2        
        //  1836: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1839: athrow         
        //  1840: new             Lgnu/mapping/WrongType;
        //  1843: dup_x1         
        //  1844: swap           
        //  1845: ldc             "imag-part"
        //  1847: iconst_1       
        //  1848: aload_2        
        //  1849: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1852: athrow         
        //  1853: new             Lgnu/mapping/WrongType;
        //  1856: dup_x1         
        //  1857: swap           
        //  1858: ldc             "jmag-part"
        //  1860: iconst_1       
        //  1861: aload_2        
        //  1862: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1865: athrow         
        //  1866: new             Lgnu/mapping/WrongType;
        //  1869: dup_x1         
        //  1870: swap           
        //  1871: ldc             "kmag-part"
        //  1873: iconst_1       
        //  1874: aload_2        
        //  1875: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1878: athrow         
        //  1879: new             Lgnu/mapping/WrongType;
        //  1882: dup_x1         
        //  1883: swap           
        //  1884: ldc_w           "unit-vector"
        //  1887: iconst_1       
        //  1888: aload_2        
        //  1889: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1892: athrow         
        //  1893: new             Lgnu/mapping/WrongType;
        //  1896: dup_x1         
        //  1897: swap           
        //  1898: ldc_w           "magnitude"
        //  1901: iconst_1       
        //  1902: aload_2        
        //  1903: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1906: athrow         
        //  1907: new             Lgnu/mapping/WrongType;
        //  1910: dup_x1         
        //  1911: swap           
        //  1912: ldc_w           "angle"
        //  1915: iconst_1       
        //  1916: aload_2        
        //  1917: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1920: athrow         
        //  1921: new             Lgnu/mapping/WrongType;
        //  1924: dup_x1         
        //  1925: swap           
        //  1926: ldc_w           "inexact"
        //  1929: iconst_1       
        //  1930: aload_2        
        //  1931: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1934: athrow         
        //  1935: new             Lgnu/mapping/WrongType;
        //  1938: dup_x1         
        //  1939: swap           
        //  1940: ldc_w           "exact"
        //  1943: iconst_1       
        //  1944: aload_2        
        //  1945: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1948: athrow         
        //  1949: new             Lgnu/mapping/WrongType;
        //  1952: dup_x1         
        //  1953: swap           
        //  1954: ldc_w           "exact->inexact"
        //  1957: iconst_1       
        //  1958: aload_2        
        //  1959: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1962: athrow         
        //  1963: new             Lgnu/mapping/WrongType;
        //  1966: dup_x1         
        //  1967: swap           
        //  1968: ldc_w           "inexact->exact"
        //  1971: iconst_1       
        //  1972: aload_2        
        //  1973: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1976: athrow         
        //  1977: new             Lgnu/mapping/WrongType;
        //  1980: dup_x1         
        //  1981: swap           
        //  1982: ldc_w           "logcount"
        //  1985: iconst_1       
        //  1986: aload_2        
        //  1987: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1990: athrow         
        //  1991: new             Lgnu/mapping/WrongType;
        //  1994: dup_x1         
        //  1995: swap           
        //  1996: ldc_w           "bitwise-bit-count"
        //  1999: iconst_1       
        //  2000: aload_2        
        //  2001: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2004: athrow         
        //  2005: new             Lgnu/mapping/WrongType;
        //  2008: dup_x1         
        //  2009: swap           
        //  2010: ldc_w           "bitwise-length"
        //  2013: iconst_1       
        //  2014: aload_2        
        //  2015: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2018: athrow         
        //  2019: new             Lgnu/mapping/WrongType;
        //  2022: dup_x1         
        //  2023: swap           
        //  2024: ldc_w           "bitwise-first-bit-set"
        //  2027: iconst_1       
        //  2028: aload_2        
        //  2029: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2032: athrow         
        //  2033: new             Lgnu/mapping/WrongType;
        //  2036: dup_x1         
        //  2037: swap           
        //  2038: ldc_w           "number->string"
        //  2041: iconst_1       
        //  2042: aload_2        
        //  2043: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2046: athrow         
        //  2047: new             Lgnu/mapping/WrongType;
        //  2050: dup_x1         
        //  2051: swap           
        //  2052: ldc_w           "string->number"
        //  2055: iconst_1       
        //  2056: aload_2        
        //  2057: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2060: athrow         
        //  2061: new             Lgnu/mapping/WrongType;
        //  2064: dup_x1         
        //  2065: swap           
        //  2066: ldc_w           "quantity->number"
        //  2069: iconst_1       
        //  2070: aload_2        
        //  2071: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2074: athrow         
        //  2075: new             Lgnu/mapping/WrongType;
        //  2078: dup_x1         
        //  2079: swap           
        //  2080: ldc_w           "quantity->unit"
        //  2083: iconst_1       
        //  2084: aload_2        
        //  2085: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2088: athrow         
        //  2089: new             Lgnu/mapping/WrongType;
        //  2092: dup_x1         
        //  2093: swap           
        //  2094: ldc_w           "exact-integer-sqrt"
        //  2097: iconst_1       
        //  2098: aload_2        
        //  2099: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2102: athrow         
        //  2103: new             Lgnu/mapping/WrongType;
        //  2106: dup_x1         
        //  2107: swap           
        //  2108: ldc_w           "lambda"
        //  2111: iconst_1       
        //  2112: aload_2        
        //  2113: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2116: athrow         
        //  2117: new             Lgnu/mapping/WrongType;
        //  2120: dup_x1         
        //  2121: swap           
        //  2122: ldc_w           "lambda"
        //  2125: iconst_1       
        //  2126: aload_2        
        //  2127: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2130: athrow         
        //  2131: new             Lgnu/mapping/WrongType;
        //  2134: dup_x1         
        //  2135: swap           
        //  2136: ldc_w           "lambda"
        //  2139: iconst_1       
        //  2140: aload_2        
        //  2141: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2144: athrow         
        //  2145: new             Lgnu/mapping/WrongType;
        //  2148: dup_x1         
        //  2149: swap           
        //  2150: ldc_w           "lambda"
        //  2153: iconst_1       
        //  2154: aload_2        
        //  2155: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2158: athrow         
        //  2159: new             Lgnu/mapping/WrongType;
        //  2162: dup_x1         
        //  2163: swap           
        //  2164: ldc_w           "lambda"
        //  2167: iconst_1       
        //  2168: aload_2        
        //  2169: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2172: athrow         
        //  2173: new             Lgnu/mapping/WrongType;
        //  2176: dup_x1         
        //  2177: swap           
        //  2178: ldc_w           "lambda"
        //  2181: iconst_1       
        //  2182: aload_2        
        //  2183: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2186: athrow         
        //  2187: new             Lgnu/mapping/WrongType;
        //  2190: dup_x1         
        //  2191: swap           
        //  2192: ldc_w           "lambda"
        //  2195: iconst_1       
        //  2196: aload_2        
        //  2197: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2200: athrow         
        //  2201: new             Lgnu/mapping/WrongType;
        //  2204: dup_x1         
        //  2205: swap           
        //  2206: ldc_w           "lambda"
        //  2209: iconst_1       
        //  2210: aload_2        
        //  2211: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2214: athrow         
        //  2215: new             Lgnu/mapping/WrongType;
        //  2218: dup_x1         
        //  2219: swap           
        //  2220: ldc_w           "lambda"
        //  2223: iconst_1       
        //  2224: aload_2        
        //  2225: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2228: athrow         
        //  2229: new             Lgnu/mapping/WrongType;
        //  2232: dup_x1         
        //  2233: swap           
        //  2234: ldc_w           "lambda"
        //  2237: iconst_1       
        //  2238: aload_2        
        //  2239: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2242: athrow         
        //  2243: new             Lgnu/mapping/WrongType;
        //  2246: dup_x1         
        //  2247: swap           
        //  2248: ldc_w           "lambda"
        //  2251: iconst_1       
        //  2252: aload_2        
        //  2253: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2256: athrow         
        //  2257: new             Lgnu/mapping/WrongType;
        //  2260: dup_x1         
        //  2261: swap           
        //  2262: ldc_w           "lambda"
        //  2265: iconst_1       
        //  2266: aload_2        
        //  2267: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2270: athrow         
        //  2271: new             Lgnu/mapping/WrongType;
        //  2274: dup_x1         
        //  2275: swap           
        //  2276: ldc_w           "lambda"
        //  2279: iconst_1       
        //  2280: aload_2        
        //  2281: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2284: athrow         
        //  2285: new             Lgnu/mapping/WrongType;
        //  2288: dup_x1         
        //  2289: swap           
        //  2290: ldc_w           "lambda"
        //  2293: iconst_1       
        //  2294: aload_2        
        //  2295: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2298: athrow         
        //  2299: new             Lgnu/mapping/WrongType;
        //  2302: dup_x1         
        //  2303: swap           
        //  2304: ldc_w           "lambda"
        //  2307: iconst_1       
        //  2308: aload_2        
        //  2309: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2312: athrow         
        //  2313: new             Lgnu/mapping/WrongType;
        //  2316: dup_x1         
        //  2317: swap           
        //  2318: ldc_w           "lambda"
        //  2321: iconst_1       
        //  2322: aload_2        
        //  2323: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2326: athrow         
        //  2327: new             Lgnu/mapping/WrongType;
        //  2330: dup_x1         
        //  2331: swap           
        //  2332: ldc_w           "lambda"
        //  2335: iconst_1       
        //  2336: aload_2        
        //  2337: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2340: athrow         
        //  2341: new             Lgnu/mapping/WrongType;
        //  2344: dup_x1         
        //  2345: swap           
        //  2346: ldc_w           "lambda"
        //  2349: iconst_1       
        //  2350: aload_2        
        //  2351: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2354: athrow         
        //  2355: new             Lgnu/mapping/WrongType;
        //  2358: dup_x1         
        //  2359: swap           
        //  2360: ldc_w           "lambda"
        //  2363: iconst_1       
        //  2364: aload_2        
        //  2365: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2368: athrow         
        //  2369: new             Lgnu/mapping/WrongType;
        //  2372: dup_x1         
        //  2373: swap           
        //  2374: ldc_w           "lambda"
        //  2377: iconst_1       
        //  2378: aload_2        
        //  2379: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2382: athrow         
        //  2383: new             Lgnu/mapping/WrongType;
        //  2386: dup_x1         
        //  2387: swap           
        //  2388: ldc_w           "lambda"
        //  2391: iconst_1       
        //  2392: aload_2        
        //  2393: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2396: athrow         
        //  2397: new             Lgnu/mapping/WrongType;
        //  2400: dup_x1         
        //  2401: swap           
        //  2402: ldc_w           "lambda"
        //  2405: iconst_1       
        //  2406: aload_2        
        //  2407: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2410: athrow         
        //  2411: new             Lgnu/mapping/WrongType;
        //  2414: dup_x1         
        //  2415: swap           
        //  2416: ldc_w           "lambda"
        //  2419: iconst_1       
        //  2420: aload_2        
        //  2421: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  2424: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  655    658    1575   1589   Ljava/lang/ClassCastException;
        //  680    683    1589   1603   Ljava/lang/ClassCastException;
        //  705    708    1603   1617   Ljava/lang/ClassCastException;
        //  730    733    1617   1631   Ljava/lang/ClassCastException;
        //  755    758    1631   1645   Ljava/lang/ClassCastException;
        //  780    783    1645   1659   Ljava/lang/ClassCastException;
        //  805    808    1659   1673   Ljava/lang/ClassCastException;
        //  818    821    1673   1687   Ljava/lang/ClassCastException;
        //  831    834    1687   1701   Ljava/lang/ClassCastException;
        //  844    847    1701   1715   Ljava/lang/ClassCastException;
        //  857    860    1715   1729   Ljava/lang/ClassCastException;
        //  870    873    1729   1743   Ljava/lang/ClassCastException;
        //  883    886    1743   1757   Ljava/lang/ClassCastException;
        //  896    899    1757   1771   Ljava/lang/ClassCastException;
        //  909    912    1771   1785   Ljava/lang/ClassCastException;
        //  922    925    1785   1799   Ljava/lang/ClassCastException;
        //  935    938    1799   1813   Ljava/lang/ClassCastException;
        //  948    951    1813   1827   Ljava/lang/ClassCastException;
        //  961    964    1827   1840   Ljava/lang/ClassCastException;
        //  974    977    1840   1853   Ljava/lang/ClassCastException;
        //  987    990    1853   1866   Ljava/lang/ClassCastException;
        //  1000   1003   1866   1879   Ljava/lang/ClassCastException;
        //  1013   1016   1879   1893   Ljava/lang/ClassCastException;
        //  1026   1029   1893   1907   Ljava/lang/ClassCastException;
        //  1039   1042   1907   1921   Ljava/lang/ClassCastException;
        //  1052   1055   1921   1935   Ljava/lang/ClassCastException;
        //  1065   1068   1935   1949   Ljava/lang/ClassCastException;
        //  1078   1081   1949   1963   Ljava/lang/ClassCastException;
        //  1091   1094   1963   1977   Ljava/lang/ClassCastException;
        //  1104   1107   1977   1991   Ljava/lang/ClassCastException;
        //  1120   1123   1991   2005   Ljava/lang/ClassCastException;
        //  1136   1139   2005   2019   Ljava/lang/ClassCastException;
        //  1152   1155   2019   2033   Ljava/lang/ClassCastException;
        //  1168   1171   2033   2047   Ljava/lang/ClassCastException;
        //  1182   1185   2047   2061   Ljava/lang/ClassCastException;
        //  1195   1198   2061   2075   Ljava/lang/ClassCastException;
        //  1208   1211   2075   2089   Ljava/lang/ClassCastException;
        //  1226   1229   2089   2103   Ljava/lang/ClassCastException;
        //  1239   1242   2103   2117   Ljava/lang/ClassCastException;
        //  1252   1255   2117   2131   Ljava/lang/ClassCastException;
        //  1263   1269   2131   2145   Ljava/lang/ClassCastException;
        //  1282   1285   2145   2159   Ljava/lang/ClassCastException;
        //  1293   1299   2159   2173   Ljava/lang/ClassCastException;
        //  1312   1315   2173   2187   Ljava/lang/ClassCastException;
        //  1323   1329   2187   2201   Ljava/lang/ClassCastException;
        //  1342   1345   2201   2215   Ljava/lang/ClassCastException;
        //  1355   1358   2215   2229   Ljava/lang/ClassCastException;
        //  1368   1371   2229   2243   Ljava/lang/ClassCastException;
        //  1379   1385   2243   2257   Ljava/lang/ClassCastException;
        //  1398   1401   2257   2271   Ljava/lang/ClassCastException;
        //  1411   1414   2271   2285   Ljava/lang/ClassCastException;
        //  1422   1428   2285   2299   Ljava/lang/ClassCastException;
        //  1441   1444   2299   2313   Ljava/lang/ClassCastException;
        //  1454   1457   2313   2327   Ljava/lang/ClassCastException;
        //  1465   1471   2327   2341   Ljava/lang/ClassCastException;
        //  1484   1487   2341   2355   Ljava/lang/ClassCastException;
        //  1495   1501   2355   2369   Ljava/lang/ClassCastException;
        //  1514   1517   2369   2383   Ljava/lang/ClassCastException;
        //  1525   1531   2383   2397   Ljava/lang/ClassCastException;
        //  1544   1547   2397   2411   Ljava/lang/ClassCastException;
        //  1555   1561   2411   2425   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 993 out of bounds for length 993
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
        //               23: 128
        //               24: 150
        //               25: 172
        //               26: 194
        //               35: 216
        //               37: 360
        //               47: 382
        //               66: 404
        //               68: 426
        //               82: 238
        //               87: 273
        //               94: 307
        //               96: 330
        //              100: 354
        //          default: 450
        //        }
        //   128: aload_2        
        //   129: ldc             Lgnu/math/RealNum;.class
        //   131: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   134: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   137: aload_3        
        //   138: ldc             Lgnu/math/RealNum;.class
        //   140: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   143: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   146: invokestatic    kawa/lib/numbers.floor$Sl:(Lgnu/math/RealNum;Lgnu/math/RealNum;)Ljava/lang/Object;
        //   149: areturn        
        //   150: aload_2        
        //   151: ldc             Lgnu/math/RealNum;.class
        //   153: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   156: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   159: aload_3        
        //   160: ldc             Lgnu/math/RealNum;.class
        //   162: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   165: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   168: invokestatic    kawa/lib/numbers.truncate$Sl:(Lgnu/math/RealNum;Lgnu/math/RealNum;)Ljava/lang/Object;
        //   171: areturn        
        //   172: aload_2        
        //   173: ldc             Lgnu/math/RealNum;.class
        //   175: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   178: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   181: aload_3        
        //   182: ldc             Lgnu/math/RealNum;.class
        //   184: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   187: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   190: invokestatic    kawa/lib/numbers.divAndMod:(Lgnu/math/RealNum;Lgnu/math/RealNum;)Ljava/lang/Object;
        //   193: areturn        
        //   194: aload_2        
        //   195: ldc             Lgnu/math/RealNum;.class
        //   197: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   200: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   203: aload_3        
        //   204: ldc             Lgnu/math/RealNum;.class
        //   206: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   209: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   212: invokestatic    kawa/lib/numbers.div0AndMod0:(Lgnu/math/RealNum;Lgnu/math/RealNum;)Ljava/lang/Object;
        //   215: areturn        
        //   216: aload_2        
        //   217: ldc             Lgnu/math/RealNum;.class
        //   219: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   222: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   225: aload_3        
        //   226: ldc             Lgnu/math/RealNum;.class
        //   228: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   231: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   234: invokestatic    kawa/lib/numbers.rationalize:(Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/RealNum;
        //   237: areturn        
        //   238: aload_2        
        //   239: ldc             Lgnu/math/IntNum;.class
        //   241: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   244: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   247: aload_3        
        //   248: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   251: checkcast       Ljava/lang/Number;
        //   254: invokevirtual   java/lang/Number.intValue:()I
        //   257: invokestatic    kawa/lib/numbers.isBitwiseBitSet:(Lgnu/math/IntNum;I)Z
        //   260: ifeq            269
        //   263: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   266: goto            272
        //   269: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   272: areturn        
        //   273: aload_2        
        //   274: ldc             Lgnu/math/IntNum;.class
        //   276: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   279: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   282: aload_3        
        //   283: ldc             Lgnu/math/IntNum;.class
        //   285: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   288: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   291: invokestatic    kawa/lib/numbers.logtest:(Lgnu/math/IntNum;Lgnu/math/IntNum;)Z
        //   294: ifeq            303
        //   297: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   300: goto            306
        //   303: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   306: areturn        
        //   307: aload_2        
        //   308: ldc             Ljava/lang/Number;.class
        //   310: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   313: checkcast       Ljava/lang/Number;
        //   316: aload_3        
        //   317: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   320: checkcast       Ljava/lang/Number;
        //   323: invokevirtual   java/lang/Number.intValue:()I
        //   326: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;I)Ljava/lang/CharSequence;
        //   329: areturn        
        //   330: aload_2        
        //   331: ldc_w           Ljava/lang/CharSequence;.class
        //   334: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   337: checkcast       Ljava/lang/CharSequence;
        //   340: aload_3        
        //   341: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   344: checkcast       Ljava/lang/Number;
        //   347: invokevirtual   java/lang/Number.intValue:()I
        //   350: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;I)Ljava/lang/Object;
        //   353: areturn        
        //   354: aload_2        
        //   355: aload_3        
        //   356: invokestatic    kawa/lib/numbers.makeQuantity:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/math/Quantity;
        //   359: areturn        
        //   360: aload_2        
        //   361: ldc             Ljava/lang/Number;.class
        //   363: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   366: checkcast       Ljava/lang/Number;
        //   369: aload_3        
        //   370: ldc             Ljava/lang/Number;.class
        //   372: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   375: checkcast       Ljava/lang/Number;
        //   378: invokestatic    kawa/lib/numbers.lambda1:(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
        //   381: areturn        
        //   382: aload_2        
        //   383: ldc             Ljava/lang/Number;.class
        //   385: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   388: checkcast       Ljava/lang/Number;
        //   391: aload_3        
        //   392: ldc             Ljava/lang/Number;.class
        //   394: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   397: checkcast       Ljava/lang/Number;
        //   400: invokestatic    kawa/lib/numbers.lambda9:(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
        //   403: areturn        
        //   404: aload_2        
        //   405: ldc             Lgnu/math/RealNum;.class
        //   407: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   410: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   413: aload_3        
        //   414: ldc             Lgnu/math/RealNum;.class
        //   416: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   419: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   422: invokestatic    kawa/lib/numbers.lambda26:(Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Complex;
        //   425: areturn        
        //   426: aload_2        
        //   427: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   430: checkcast       Ljava/lang/Number;
        //   433: invokevirtual   java/lang/Number.doubleValue:()D
        //   436: aload_3        
        //   437: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   440: checkcast       Ljava/lang/Number;
        //   443: invokevirtual   java/lang/Number.doubleValue:()D
        //   446: invokestatic    kawa/lib/numbers.lambda28:(DD)Lgnu/math/Complex;
        //   449: areturn        
        //   450: aload_0        
        //   451: aload_1        
        //   452: aload_2        
        //   453: aload_3        
        //   454: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   457: areturn        
        //   458: new             Lgnu/mapping/WrongType;
        //   461: dup_x1         
        //   462: swap           
        //   463: ldc_w           "floor/"
        //   466: iconst_1       
        //   467: aload_2        
        //   468: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   471: athrow         
        //   472: new             Lgnu/mapping/WrongType;
        //   475: dup_x1         
        //   476: swap           
        //   477: ldc_w           "floor/"
        //   480: iconst_2       
        //   481: aload_3        
        //   482: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   485: athrow         
        //   486: new             Lgnu/mapping/WrongType;
        //   489: dup_x1         
        //   490: swap           
        //   491: ldc_w           "truncate/"
        //   494: iconst_1       
        //   495: aload_2        
        //   496: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   499: athrow         
        //   500: new             Lgnu/mapping/WrongType;
        //   503: dup_x1         
        //   504: swap           
        //   505: ldc_w           "truncate/"
        //   508: iconst_2       
        //   509: aload_3        
        //   510: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   513: athrow         
        //   514: new             Lgnu/mapping/WrongType;
        //   517: dup_x1         
        //   518: swap           
        //   519: ldc_w           "div-and-mod"
        //   522: iconst_1       
        //   523: aload_2        
        //   524: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   527: athrow         
        //   528: new             Lgnu/mapping/WrongType;
        //   531: dup_x1         
        //   532: swap           
        //   533: ldc_w           "div-and-mod"
        //   536: iconst_2       
        //   537: aload_3        
        //   538: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   541: athrow         
        //   542: new             Lgnu/mapping/WrongType;
        //   545: dup_x1         
        //   546: swap           
        //   547: ldc_w           "div0-and-mod0"
        //   550: iconst_1       
        //   551: aload_2        
        //   552: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   555: athrow         
        //   556: new             Lgnu/mapping/WrongType;
        //   559: dup_x1         
        //   560: swap           
        //   561: ldc_w           "div0-and-mod0"
        //   564: iconst_2       
        //   565: aload_3        
        //   566: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   569: athrow         
        //   570: new             Lgnu/mapping/WrongType;
        //   573: dup_x1         
        //   574: swap           
        //   575: ldc_w           "rationalize"
        //   578: iconst_1       
        //   579: aload_2        
        //   580: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   583: athrow         
        //   584: new             Lgnu/mapping/WrongType;
        //   587: dup_x1         
        //   588: swap           
        //   589: ldc_w           "rationalize"
        //   592: iconst_2       
        //   593: aload_3        
        //   594: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   597: athrow         
        //   598: new             Lgnu/mapping/WrongType;
        //   601: dup_x1         
        //   602: swap           
        //   603: ldc_w           "bitwise-bit-set?"
        //   606: iconst_1       
        //   607: aload_2        
        //   608: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   611: athrow         
        //   612: new             Lgnu/mapping/WrongType;
        //   615: dup_x1         
        //   616: swap           
        //   617: ldc_w           "bitwise-bit-set?"
        //   620: iconst_2       
        //   621: aload_3        
        //   622: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   625: athrow         
        //   626: new             Lgnu/mapping/WrongType;
        //   629: dup_x1         
        //   630: swap           
        //   631: ldc_w           "logtest"
        //   634: iconst_1       
        //   635: aload_2        
        //   636: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   639: athrow         
        //   640: new             Lgnu/mapping/WrongType;
        //   643: dup_x1         
        //   644: swap           
        //   645: ldc_w           "logtest"
        //   648: iconst_2       
        //   649: aload_3        
        //   650: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   653: athrow         
        //   654: new             Lgnu/mapping/WrongType;
        //   657: dup_x1         
        //   658: swap           
        //   659: ldc_w           "number->string"
        //   662: iconst_1       
        //   663: aload_2        
        //   664: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   667: athrow         
        //   668: new             Lgnu/mapping/WrongType;
        //   671: dup_x1         
        //   672: swap           
        //   673: ldc_w           "number->string"
        //   676: iconst_2       
        //   677: aload_3        
        //   678: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   681: athrow         
        //   682: new             Lgnu/mapping/WrongType;
        //   685: dup_x1         
        //   686: swap           
        //   687: ldc_w           "string->number"
        //   690: iconst_1       
        //   691: aload_2        
        //   692: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   695: athrow         
        //   696: new             Lgnu/mapping/WrongType;
        //   699: dup_x1         
        //   700: swap           
        //   701: ldc_w           "string->number"
        //   704: iconst_2       
        //   705: aload_3        
        //   706: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   709: athrow         
        //   710: new             Lgnu/mapping/WrongType;
        //   713: dup_x1         
        //   714: swap           
        //   715: ldc_w           "lambda"
        //   718: iconst_1       
        //   719: aload_2        
        //   720: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   723: athrow         
        //   724: new             Lgnu/mapping/WrongType;
        //   727: dup_x1         
        //   728: swap           
        //   729: ldc_w           "lambda"
        //   732: iconst_2       
        //   733: aload_3        
        //   734: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   737: athrow         
        //   738: new             Lgnu/mapping/WrongType;
        //   741: dup_x1         
        //   742: swap           
        //   743: ldc_w           "lambda"
        //   746: iconst_1       
        //   747: aload_2        
        //   748: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   751: athrow         
        //   752: new             Lgnu/mapping/WrongType;
        //   755: dup_x1         
        //   756: swap           
        //   757: ldc_w           "lambda"
        //   760: iconst_2       
        //   761: aload_3        
        //   762: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   765: athrow         
        //   766: new             Lgnu/mapping/WrongType;
        //   769: dup_x1         
        //   770: swap           
        //   771: ldc_w           "lambda"
        //   774: iconst_1       
        //   775: aload_2        
        //   776: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   779: athrow         
        //   780: new             Lgnu/mapping/WrongType;
        //   783: dup_x1         
        //   784: swap           
        //   785: ldc_w           "lambda"
        //   788: iconst_2       
        //   789: aload_3        
        //   790: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   793: athrow         
        //   794: new             Lgnu/mapping/WrongType;
        //   797: dup_x1         
        //   798: swap           
        //   799: ldc_w           "lambda"
        //   802: iconst_1       
        //   803: aload_2        
        //   804: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   807: athrow         
        //   808: new             Lgnu/mapping/WrongType;
        //   811: dup_x1         
        //   812: swap           
        //   813: ldc_w           "lambda"
        //   816: iconst_2       
        //   817: aload_3        
        //   818: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   821: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  134    137    458    472    Ljava/lang/ClassCastException;
        //  143    146    472    486    Ljava/lang/ClassCastException;
        //  156    159    486    500    Ljava/lang/ClassCastException;
        //  165    168    500    514    Ljava/lang/ClassCastException;
        //  178    181    514    528    Ljava/lang/ClassCastException;
        //  187    190    528    542    Ljava/lang/ClassCastException;
        //  200    203    542    556    Ljava/lang/ClassCastException;
        //  209    212    556    570    Ljava/lang/ClassCastException;
        //  222    225    570    584    Ljava/lang/ClassCastException;
        //  231    234    584    598    Ljava/lang/ClassCastException;
        //  244    247    598    612    Ljava/lang/ClassCastException;
        //  251    257    612    626    Ljava/lang/ClassCastException;
        //  279    282    626    640    Ljava/lang/ClassCastException;
        //  288    291    640    654    Ljava/lang/ClassCastException;
        //  313    316    654    668    Ljava/lang/ClassCastException;
        //  320    326    668    682    Ljava/lang/ClassCastException;
        //  337    340    682    696    Ljava/lang/ClassCastException;
        //  344    350    696    710    Ljava/lang/ClassCastException;
        //  366    369    710    724    Ljava/lang/ClassCastException;
        //  375    378    724    738    Ljava/lang/ClassCastException;
        //  388    391    738    752    Ljava/lang/ClassCastException;
        //  397    400    752    766    Ljava/lang/ClassCastException;
        //  410    413    766    780    Ljava/lang/ClassCastException;
        //  419    422    780    794    Ljava/lang/ClassCastException;
        //  430    436    794    808    Ljava/lang/ClassCastException;
        //  440    446    808    822    Ljava/lang/ClassCastException;
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
        //               81: 56
        //               83: 89
        //               85: 123
        //               86: 157
        //               93: 189
        //          default: 223
        //        }
        //    56: aload_2        
        //    57: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    60: checkcast       Ljava/lang/Number;
        //    63: invokevirtual   java/lang/Number.intValue:()I
        //    66: aload_3        
        //    67: ldc             Lgnu/math/IntNum;.class
        //    69: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    72: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    75: aload           4
        //    77: ldc             Lgnu/math/IntNum;.class
        //    79: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    82: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    85: invokestatic    kawa/lib/numbers.logop:(ILgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
        //    88: areturn        
        //    89: aload_2        
        //    90: ldc             Lgnu/math/IntNum;.class
        //    92: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    95: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    98: aload_3        
        //    99: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   102: checkcast       Ljava/lang/Number;
        //   105: invokevirtual   java/lang/Number.intValue:()I
        //   108: aload           4
        //   110: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   113: checkcast       Ljava/lang/Number;
        //   116: invokevirtual   java/lang/Number.intValue:()I
        //   119: invokestatic    kawa/lib/numbers.bitwiseCopyBit:(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
        //   122: areturn        
        //   123: aload_2        
        //   124: ldc             Lgnu/math/IntNum;.class
        //   126: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   129: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   132: aload_3        
        //   133: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   136: checkcast       Ljava/lang/Number;
        //   139: invokevirtual   java/lang/Number.intValue:()I
        //   142: aload           4
        //   144: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   147: checkcast       Ljava/lang/Number;
        //   150: invokevirtual   java/lang/Number.intValue:()I
        //   153: invokestatic    kawa/lib/numbers.bitwiseBitField:(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
        //   156: areturn        
        //   157: aload_2        
        //   158: ldc             Lgnu/math/IntNum;.class
        //   160: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   163: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   166: aload_3        
        //   167: ldc             Lgnu/math/IntNum;.class
        //   169: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   172: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   175: aload           4
        //   177: ldc             Lgnu/math/IntNum;.class
        //   179: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   182: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   185: invokestatic    kawa/lib/numbers.bitwiseIf:(Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
        //   188: areturn        
        //   189: aload_2        
        //   190: ldc             Lgnu/math/IntNum;.class
        //   192: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   195: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   198: aload_3        
        //   199: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   202: checkcast       Ljava/lang/Number;
        //   205: invokevirtual   java/lang/Number.intValue:()I
        //   208: aload           4
        //   210: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   213: checkcast       Ljava/lang/Number;
        //   216: invokevirtual   java/lang/Number.intValue:()I
        //   219: invokestatic    kawa/lib/numbers.bitwiseReverseBitField:(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
        //   222: areturn        
        //   223: aload_0        
        //   224: aload_1        
        //   225: aload_2        
        //   226: aload_3        
        //   227: aload           4
        //   229: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   232: areturn        
        //   233: new             Lgnu/mapping/WrongType;
        //   236: dup_x1         
        //   237: swap           
        //   238: ldc_w           "logop"
        //   241: iconst_1       
        //   242: aload_2        
        //   243: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   246: athrow         
        //   247: new             Lgnu/mapping/WrongType;
        //   250: dup_x1         
        //   251: swap           
        //   252: ldc_w           "logop"
        //   255: iconst_2       
        //   256: aload_3        
        //   257: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   260: athrow         
        //   261: new             Lgnu/mapping/WrongType;
        //   264: dup_x1         
        //   265: swap           
        //   266: ldc_w           "logop"
        //   269: iconst_3       
        //   270: aload           4
        //   272: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   275: athrow         
        //   276: new             Lgnu/mapping/WrongType;
        //   279: dup_x1         
        //   280: swap           
        //   281: ldc_w           "bitwise-copy-bit"
        //   284: iconst_1       
        //   285: aload_2        
        //   286: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   289: athrow         
        //   290: new             Lgnu/mapping/WrongType;
        //   293: dup_x1         
        //   294: swap           
        //   295: ldc_w           "bitwise-copy-bit"
        //   298: iconst_2       
        //   299: aload_3        
        //   300: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   303: athrow         
        //   304: new             Lgnu/mapping/WrongType;
        //   307: dup_x1         
        //   308: swap           
        //   309: ldc_w           "bitwise-copy-bit"
        //   312: iconst_3       
        //   313: aload           4
        //   315: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   318: athrow         
        //   319: new             Lgnu/mapping/WrongType;
        //   322: dup_x1         
        //   323: swap           
        //   324: ldc_w           "bitwise-bit-field"
        //   327: iconst_1       
        //   328: aload_2        
        //   329: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   332: athrow         
        //   333: new             Lgnu/mapping/WrongType;
        //   336: dup_x1         
        //   337: swap           
        //   338: ldc_w           "bitwise-bit-field"
        //   341: iconst_2       
        //   342: aload_3        
        //   343: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   346: athrow         
        //   347: new             Lgnu/mapping/WrongType;
        //   350: dup_x1         
        //   351: swap           
        //   352: ldc_w           "bitwise-bit-field"
        //   355: iconst_3       
        //   356: aload           4
        //   358: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   361: athrow         
        //   362: new             Lgnu/mapping/WrongType;
        //   365: dup_x1         
        //   366: swap           
        //   367: ldc_w           "bitwise-if"
        //   370: iconst_1       
        //   371: aload_2        
        //   372: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   375: athrow         
        //   376: new             Lgnu/mapping/WrongType;
        //   379: dup_x1         
        //   380: swap           
        //   381: ldc_w           "bitwise-if"
        //   384: iconst_2       
        //   385: aload_3        
        //   386: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   389: athrow         
        //   390: new             Lgnu/mapping/WrongType;
        //   393: dup_x1         
        //   394: swap           
        //   395: ldc_w           "bitwise-if"
        //   398: iconst_3       
        //   399: aload           4
        //   401: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   404: athrow         
        //   405: new             Lgnu/mapping/WrongType;
        //   408: dup_x1         
        //   409: swap           
        //   410: ldc_w           "bitwise-reverse-bit-field"
        //   413: iconst_1       
        //   414: aload_2        
        //   415: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   418: athrow         
        //   419: new             Lgnu/mapping/WrongType;
        //   422: dup_x1         
        //   423: swap           
        //   424: ldc_w           "bitwise-reverse-bit-field"
        //   427: iconst_2       
        //   428: aload_3        
        //   429: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   432: athrow         
        //   433: new             Lgnu/mapping/WrongType;
        //   436: dup_x1         
        //   437: swap           
        //   438: ldc_w           "bitwise-reverse-bit-field"
        //   441: iconst_3       
        //   442: aload           4
        //   444: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   447: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  60     66     233    247    Ljava/lang/ClassCastException;
        //  72     75     247    261    Ljava/lang/ClassCastException;
        //  82     85     261    276    Ljava/lang/ClassCastException;
        //  95     98     276    290    Ljava/lang/ClassCastException;
        //  102    108    290    304    Ljava/lang/ClassCastException;
        //  113    119    304    319    Ljava/lang/ClassCastException;
        //  129    132    319    333    Ljava/lang/ClassCastException;
        //  136    142    333    347    Ljava/lang/ClassCastException;
        //  147    153    347    362    Ljava/lang/ClassCastException;
        //  163    166    362    376    Ljava/lang/ClassCastException;
        //  172    175    376    390    Ljava/lang/ClassCastException;
        //  182    185    390    405    Ljava/lang/ClassCastException;
        //  195    198    405    419    Ljava/lang/ClassCastException;
        //  202    208    419    433    Ljava/lang/ClassCastException;
        //  213    219    433    448    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 200 out of bounds for length 200
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
        //     4: lookupswitch {
        //               67: 137
        //               69: 179
        //               84: 48
        //               92: 92
        //          default: 225
        //        }
        //    48: aload_2        
        //    49: ldc             Lgnu/math/IntNum;.class
        //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    54: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    57: aload_3        
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    61: checkcast       Ljava/lang/Number;
        //    64: invokevirtual   java/lang/Number.intValue:()I
        //    67: aload           4
        //    69: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    72: checkcast       Ljava/lang/Number;
        //    75: invokevirtual   java/lang/Number.intValue:()I
        //    78: aload           5
        //    80: ldc             Lgnu/math/IntNum;.class
        //    82: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    85: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //    88: invokestatic    kawa/lib/numbers.bitwiseCopyBitField:(Lgnu/math/IntNum;IILgnu/math/IntNum;)Lgnu/math/IntNum;
        //    91: areturn        
        //    92: aload_2        
        //    93: ldc             Lgnu/math/IntNum;.class
        //    95: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    98: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   101: aload_3        
        //   102: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   105: checkcast       Ljava/lang/Number;
        //   108: invokevirtual   java/lang/Number.intValue:()I
        //   111: aload           4
        //   113: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   116: checkcast       Ljava/lang/Number;
        //   119: invokevirtual   java/lang/Number.intValue:()I
        //   122: aload           5
        //   124: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   127: checkcast       Ljava/lang/Number;
        //   130: invokevirtual   java/lang/Number.intValue:()I
        //   133: invokestatic    kawa/lib/numbers.bitwiseRotateBitField:(Lgnu/math/IntNum;III)Lgnu/math/IntNum;
        //   136: areturn        
        //   137: aload_2        
        //   138: ldc             Lgnu/math/RealNum;.class
        //   140: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   143: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   146: aload_3        
        //   147: ldc             Lgnu/math/RealNum;.class
        //   149: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   152: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   155: aload           4
        //   157: ldc             Lgnu/math/RealNum;.class
        //   159: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   162: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   165: aload           5
        //   167: ldc             Lgnu/math/RealNum;.class
        //   169: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   172: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   175: invokestatic    kawa/lib/numbers.lambda27:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   178: areturn        
        //   179: aload_2        
        //   180: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   183: checkcast       Ljava/lang/Number;
        //   186: invokevirtual   java/lang/Number.doubleValue:()D
        //   189: aload_3        
        //   190: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   193: checkcast       Ljava/lang/Number;
        //   196: invokevirtual   java/lang/Number.doubleValue:()D
        //   199: aload           4
        //   201: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   204: checkcast       Ljava/lang/Number;
        //   207: invokevirtual   java/lang/Number.doubleValue:()D
        //   210: aload           5
        //   212: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   215: checkcast       Ljava/lang/Number;
        //   218: invokevirtual   java/lang/Number.doubleValue:()D
        //   221: invokestatic    kawa/lib/numbers.lambda29:(DDDD)Lgnu/math/Quaternion;
        //   224: areturn        
        //   225: aload_0        
        //   226: aload_1        
        //   227: aload_2        
        //   228: aload_3        
        //   229: aload           4
        //   231: aload           5
        //   233: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   236: areturn        
        //   237: new             Lgnu/mapping/WrongType;
        //   240: dup_x1         
        //   241: swap           
        //   242: ldc_w           "bitwise-copy-bit-field"
        //   245: iconst_1       
        //   246: aload_2        
        //   247: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   250: athrow         
        //   251: new             Lgnu/mapping/WrongType;
        //   254: dup_x1         
        //   255: swap           
        //   256: ldc_w           "bitwise-copy-bit-field"
        //   259: iconst_2       
        //   260: aload_3        
        //   261: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   264: athrow         
        //   265: new             Lgnu/mapping/WrongType;
        //   268: dup_x1         
        //   269: swap           
        //   270: ldc_w           "bitwise-copy-bit-field"
        //   273: iconst_3       
        //   274: aload           4
        //   276: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   279: athrow         
        //   280: new             Lgnu/mapping/WrongType;
        //   283: dup_x1         
        //   284: swap           
        //   285: ldc_w           "bitwise-copy-bit-field"
        //   288: iconst_4       
        //   289: aload           5
        //   291: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   294: athrow         
        //   295: new             Lgnu/mapping/WrongType;
        //   298: dup_x1         
        //   299: swap           
        //   300: ldc_w           "bitwise-rotate-bit-field"
        //   303: iconst_1       
        //   304: aload_2        
        //   305: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   308: athrow         
        //   309: new             Lgnu/mapping/WrongType;
        //   312: dup_x1         
        //   313: swap           
        //   314: ldc_w           "bitwise-rotate-bit-field"
        //   317: iconst_2       
        //   318: aload_3        
        //   319: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   322: athrow         
        //   323: new             Lgnu/mapping/WrongType;
        //   326: dup_x1         
        //   327: swap           
        //   328: ldc_w           "bitwise-rotate-bit-field"
        //   331: iconst_3       
        //   332: aload           4
        //   334: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   337: athrow         
        //   338: new             Lgnu/mapping/WrongType;
        //   341: dup_x1         
        //   342: swap           
        //   343: ldc_w           "bitwise-rotate-bit-field"
        //   346: iconst_4       
        //   347: aload           5
        //   349: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   352: athrow         
        //   353: new             Lgnu/mapping/WrongType;
        //   356: dup_x1         
        //   357: swap           
        //   358: ldc_w           "lambda"
        //   361: iconst_1       
        //   362: aload_2        
        //   363: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   366: athrow         
        //   367: new             Lgnu/mapping/WrongType;
        //   370: dup_x1         
        //   371: swap           
        //   372: ldc_w           "lambda"
        //   375: iconst_2       
        //   376: aload_3        
        //   377: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   380: athrow         
        //   381: new             Lgnu/mapping/WrongType;
        //   384: dup_x1         
        //   385: swap           
        //   386: ldc_w           "lambda"
        //   389: iconst_3       
        //   390: aload           4
        //   392: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   395: athrow         
        //   396: new             Lgnu/mapping/WrongType;
        //   399: dup_x1         
        //   400: swap           
        //   401: ldc_w           "lambda"
        //   404: iconst_4       
        //   405: aload           5
        //   407: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   410: athrow         
        //   411: new             Lgnu/mapping/WrongType;
        //   414: dup_x1         
        //   415: swap           
        //   416: ldc_w           "lambda"
        //   419: iconst_1       
        //   420: aload_2        
        //   421: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   424: athrow         
        //   425: new             Lgnu/mapping/WrongType;
        //   428: dup_x1         
        //   429: swap           
        //   430: ldc_w           "lambda"
        //   433: iconst_2       
        //   434: aload_3        
        //   435: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   438: athrow         
        //   439: new             Lgnu/mapping/WrongType;
        //   442: dup_x1         
        //   443: swap           
        //   444: ldc_w           "lambda"
        //   447: iconst_3       
        //   448: aload           4
        //   450: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   453: athrow         
        //   454: new             Lgnu/mapping/WrongType;
        //   457: dup_x1         
        //   458: swap           
        //   459: ldc_w           "lambda"
        //   462: iconst_4       
        //   463: aload           5
        //   465: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   468: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  54     57     237    251    Ljava/lang/ClassCastException;
        //  61     67     251    265    Ljava/lang/ClassCastException;
        //  72     78     265    280    Ljava/lang/ClassCastException;
        //  85     88     280    295    Ljava/lang/ClassCastException;
        //  98     101    295    309    Ljava/lang/ClassCastException;
        //  105    111    309    323    Ljava/lang/ClassCastException;
        //  116    122    323    338    Ljava/lang/ClassCastException;
        //  127    133    338    353    Ljava/lang/ClassCastException;
        //  143    146    353    367    Ljava/lang/ClassCastException;
        //  152    155    367    381    Ljava/lang/ClassCastException;
        //  162    165    381    396    Ljava/lang/ClassCastException;
        //  172    175    396    411    Ljava/lang/ClassCastException;
        //  183    189    411    425    Ljava/lang/ClassCastException;
        //  193    199    425    439    Ljava/lang/ClassCastException;
        //  204    210    439    454    Ljava/lang/ClassCastException;
        //  215    221    454    469    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 211 out of bounds for length 211
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
        //     4: tableswitch {
        //               40: 56
        //               41: 61
        //               42: 132
        //               43: 132
        //               44: 132
        //               45: 132
        //               46: 132
        //               47: 66
        //               48: 99
        //          default: 132
        //        }
        //    56: aload_2        
        //    57: invokestatic    kawa/lib/numbers.max:([Ljava/lang/Object;)Ljava/lang/Object;
        //    60: areturn        
        //    61: aload_2        
        //    62: invokestatic    kawa/lib/numbers.min:([Ljava/lang/Object;)Ljava/lang/Object;
        //    65: areturn        
        //    66: aload_2        
        //    67: arraylength    
        //    68: istore_3       
        //    69: iload_3        
        //    70: anewarray       Lgnu/math/RealNum;
        //    73: goto            88
        //    76: dup            
        //    77: iload_3        
        //    78: aload_2        
        //    79: iload_3        
        //    80: aaload         
        //    81: dup            
        //    82: astore          4
        //    84: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    87: aastore        
        //    88: iinc            3, -1
        //    91: iload_3        
        //    92: ifge            76
        //    95: invokestatic    kawa/lib/numbers.gcd:([Lgnu/math/RealNum;)Lgnu/math/RealNum;
        //    98: areturn        
        //    99: aload_2        
        //   100: arraylength    
        //   101: istore_3       
        //   102: iload_3        
        //   103: anewarray       Lgnu/math/RealNum;
        //   106: goto            121
        //   109: dup            
        //   110: iload_3        
        //   111: aload_2        
        //   112: iload_3        
        //   113: aaload         
        //   114: dup            
        //   115: astore          4
        //   117: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   120: aastore        
        //   121: iinc            3, -1
        //   124: iload_3        
        //   125: ifge            109
        //   128: invokestatic    kawa/lib/numbers.lcm:([Lgnu/math/RealNum;)Lgnu/math/RealNum;
        //   131: areturn        
        //   132: aload_0        
        //   133: aload_1        
        //   134: aload_2        
        //   135: invokespecial   gnu/expr/ModuleBody.applyN:(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
        //   138: areturn        
        //   139: new             Lgnu/mapping/WrongType;
        //   142: dup_x1         
        //   143: swap           
        //   144: ldc_w           "gcd"
        //   147: iconst_0       
        //   148: aload           4
        //   150: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   153: athrow         
        //   154: new             Lgnu/mapping/WrongType;
        //   157: dup_x1         
        //   158: swap           
        //   159: ldc_w           "lcm"
        //   162: iconst_0       
        //   163: aload           4
        //   165: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   168: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  84     87     139    154    Ljava/lang/ClassCastException;
        //  117    120    154    169    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0121:
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
}
