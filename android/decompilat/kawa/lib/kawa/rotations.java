// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.kawa;

import gnu.expr.ModuleInfo;
import gnu.mapping.MethodProc;
import gnu.lists.PairWithPosition;
import gnu.lists.Pair;
import gnu.lists.LList;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import gnu.expr.Special;
import kawa.lib.exceptions;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import gnu.mapping.Values;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Promise;
import gnu.math.RealNum;
import gnu.kawa.functions.NumberCompare;
import kawa.lib.numbers;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.MultiplyOp;
import gnu.lists.Array;
import gnu.math.Quaternion;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.math.DFloNum;
import gnu.math.CComplex;
import gnu.math.IntFraction;
import gnu.math.IntNum;
import kawa.lang.Macro;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.mapping.Location;
import gnu.expr.GenericProc;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class rotations extends ModuleBody
{
    public static final ModuleMethod quaternion$Mn$Grrotation$Mnmatrix;
    public static final ModuleMethod rotation$Mnmatrix$Mn$Grquaternion;
    public static final ModuleMethod rotation$Mnaxis;
    public static final ModuleMethod rotation$Mnangle;
    public static final ModuleMethod rotation$Mnaxis$Slangle;
    public static final GenericProc make$Mnaxis$Slangle;
    public static final ModuleMethod rotx;
    public static final ModuleMethod roty;
    public static final ModuleMethod rotz;
    public static final ModuleMethod intrinsic$Mnxyx;
    public static final ModuleMethod intrinsic$Mnxzx;
    public static final ModuleMethod intrinsic$Mnyxy;
    public static final ModuleMethod intrinsic$Mnyzy;
    public static final ModuleMethod intrinsic$Mnzxz;
    public static final ModuleMethod intrinsic$Mnzyz;
    public static final ModuleMethod intrinsic$Mnxyz;
    public static final ModuleMethod intrinsic$Mnxzy;
    public static final ModuleMethod intrinsic$Mnyxz;
    public static final ModuleMethod intrinsic$Mnyzx;
    public static final ModuleMethod intrinsic$Mnzxy;
    public static final ModuleMethod intrinsic$Mnzyx;
    public static final Location euler$Mnxyx;
    public static final Location euler$Mnxzx;
    public static final Location euler$Mnyxy;
    public static final Location euler$Mnyzy;
    public static final Location euler$Mnzxz;
    public static final Location euler$Mnzyz;
    public static final Location tait$Mnbryan$Mnxyz;
    public static final Location tait$Mnbryan$Mnxzy;
    public static final Location tait$Mnbryan$Mnyxz;
    public static final Location tait$Mnbryan$Mnyzx;
    public static final Location tait$Mnbryan$Mnzxy;
    public static final Location tait$Mnbryan$Mnzyx;
    public static final ModuleMethod make$Mnintrinsic$Mnxyx;
    public static final ModuleMethod make$Mnintrinsic$Mnxzx;
    public static final ModuleMethod make$Mnintrinsic$Mnyxy;
    public static final ModuleMethod make$Mnintrinsic$Mnyzy;
    public static final ModuleMethod make$Mnintrinsic$Mnzxz;
    public static final ModuleMethod make$Mnintrinsic$Mnzyz;
    public static final ModuleMethod make$Mnintrinsic$Mnxyz;
    public static final ModuleMethod make$Mnintrinsic$Mnxzy;
    public static final ModuleMethod make$Mnintrinsic$Mnyxz;
    public static final ModuleMethod make$Mnintrinsic$Mnyzx;
    public static final ModuleMethod make$Mnintrinsic$Mnzxy;
    public static final ModuleMethod make$Mnintrinsic$Mnzyx;
    public static final Location make$Mneuler$Mnxyx;
    public static final Location make$Mneuler$Mnxzx;
    public static final Location make$Mneuler$Mnyxy;
    public static final Location make$Mneuler$Mnyzy;
    public static final Location make$Mneuler$Mnzxz;
    public static final Location make$Mneuler$Mnzyz;
    public static final Location make$Mntait$Mnbryan$Mnxyz;
    public static final Location make$Mntait$Mnbryan$Mnxzy;
    public static final Location make$Mntait$Mnbryan$Mnyxz;
    public static final Location make$Mntait$Mnbryan$Mnyzx;
    public static final Location make$Mntait$Mnbryan$Mnzxy;
    public static final Location make$Mntait$Mnbryan$Mnzyx;
    public static final ModuleMethod extrinsic$Mnxyx;
    public static final ModuleMethod extrinsic$Mnxyz;
    public static final ModuleMethod extrinsic$Mnxzx;
    public static final ModuleMethod extrinsic$Mnxzy;
    public static final ModuleMethod extrinsic$Mnyxy;
    public static final ModuleMethod extrinsic$Mnyxz;
    public static final ModuleMethod extrinsic$Mnyzx;
    public static final ModuleMethod extrinsic$Mnyzy;
    public static final ModuleMethod extrinsic$Mnzxy;
    public static final ModuleMethod extrinsic$Mnzxz;
    public static final ModuleMethod extrinsic$Mnzyx;
    public static final ModuleMethod extrinsic$Mnzyz;
    public static final Location rpy;
    public static final ModuleMethod make$Mnextrinsic$Mnxyx;
    public static final ModuleMethod make$Mnextrinsic$Mnxyz;
    public static final ModuleMethod make$Mnextrinsic$Mnxzx;
    public static final ModuleMethod make$Mnextrinsic$Mnxzy;
    public static final ModuleMethod make$Mnextrinsic$Mnyxy;
    public static final ModuleMethod make$Mnextrinsic$Mnyxz;
    public static final ModuleMethod make$Mnextrinsic$Mnyzx;
    public static final ModuleMethod make$Mnextrinsic$Mnyzy;
    public static final ModuleMethod make$Mnextrinsic$Mnzxy;
    public static final ModuleMethod make$Mnextrinsic$Mnzxz;
    public static final ModuleMethod make$Mnextrinsic$Mnzyx;
    public static final ModuleMethod make$Mnextrinsic$Mnzyz;
    public static final Location make$Mnrpy;
    public static final ModuleMethod make$Mnrotation$Mnprocedure;
    public static final ModuleMethod rotate$Mnvector;
    public static final StaticFieldLocation $Prvt$define;
    public static final StaticFieldLocation $Prvt$quaternion;
    public static final StaticFieldLocation $Prvt$unit$Mnquaternion;
    public static final StaticFieldLocation $Prvt$$Pl;
    public static final StaticFieldLocation $Prvt$$Mn;
    public static final StaticFieldLocation $Prvt$$St;
    public static final Class $Prvt$M;
    public static final Macro $Prvt$u;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final ModuleMethod lambda$Fn1;
    static final IntNum Lit2;
    static final IntNum Lit3;
    static final Double Lit4;
    static final IntFraction Lit5;
    static final IntFraction Lit6;
    static final IntFraction Lit7;
    static final IntFraction Lit8;
    static final IntFraction Lit9;
    static final CComplex Lit10;
    static final DFloNum Lit11;
    static final SimpleSymbol Lit12;
    public static rotations $instance;
    static final SimpleSymbol Lit13;
    static final SyntaxRules Lit14;
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
    static final SimpleSymbol Lit44;
    static final SimpleSymbol Lit45;
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
    static final Object[] Lit72;
    static final SimpleSymbol Lit73;
    static final SimpleSymbol Lit74;
    static final SimpleSymbol Lit75;
    static final IntNum Lit76;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Array quaternion$To$RotationMatrix(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: astore_1        /* uq */
        //     5: aload_1         /* uq */
        //     6: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     9: dup            
        //    10: astore          4
        //    12: invokevirtual   java/lang/Number.doubleValue:()D
        //    15: dstore_2        /* r */
        //    16: aload_1         /* uq */
        //    17: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    20: dup            
        //    21: astore          6
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: dstore          i
        //    28: aload_1         /* uq */
        //    29: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    32: dup            
        //    33: astore          8
        //    35: invokevirtual   java/lang/Number.doubleValue:()D
        //    38: dstore          j
        //    40: aload_1         /* uq */
        //    41: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    44: dup            
        //    45: astore          10
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore          k
        //    52: new             Lgnu/lists/F64Vector;
        //    55: dup            
        //    56: invokespecial   gnu/lists/F64Vector.<init>:()V
        //    59: dup            
        //    60: dload_2         /* r */
        //    61: dload_2         /* r */
        //    62: dmul           
        //    63: dload           i
        //    65: dload           i
        //    67: dmul           
        //    68: dadd           
        //    69: dload           j
        //    71: dload           j
        //    73: dmul           
        //    74: dload           k
        //    76: dload           k
        //    78: dmul           
        //    79: dadd           
        //    80: dsub           
        //    81: iconst_m1      
        //    82: i2d            
        //    83: invokestatic    java/lang/Math.max:(DD)D
        //    86: dconst_1       
        //    87: invokestatic    java/lang/Math.min:(DD)D
        //    90: invokevirtual   gnu/lists/F64Vector.add:(D)V
        //    93: dup            
        //    94: iconst_2       
        //    95: i2d            
        //    96: dload           i
        //    98: dload           j
        //   100: dmul           
        //   101: dload_2         /* r */
        //   102: dload           k
        //   104: dmul           
        //   105: dsub           
        //   106: dmul           
        //   107: iconst_m1      
        //   108: i2d            
        //   109: invokestatic    java/lang/Math.max:(DD)D
        //   112: dconst_1       
        //   113: invokestatic    java/lang/Math.min:(DD)D
        //   116: invokevirtual   gnu/lists/F64Vector.add:(D)V
        //   119: dup            
        //   120: iconst_2       
        //   121: i2d            
        //   122: dload           i
        //   124: dload           k
        //   126: dmul           
        //   127: dload_2         /* r */
        //   128: dload           j
        //   130: dmul           
        //   131: dadd           
        //   132: dmul           
        //   133: iconst_m1      
        //   134: i2d            
        //   135: invokestatic    java/lang/Math.max:(DD)D
        //   138: dconst_1       
        //   139: invokestatic    java/lang/Math.min:(DD)D
        //   142: invokevirtual   gnu/lists/F64Vector.add:(D)V
        //   145: dup            
        //   146: iconst_2       
        //   147: i2d            
        //   148: dload           i
        //   150: dload           j
        //   152: dmul           
        //   153: dload_2         /* r */
        //   154: dload           k
        //   156: dmul           
        //   157: dadd           
        //   158: dmul           
        //   159: iconst_m1      
        //   160: i2d            
        //   161: invokestatic    java/lang/Math.max:(DD)D
        //   164: dconst_1       
        //   165: invokestatic    java/lang/Math.min:(DD)D
        //   168: invokevirtual   gnu/lists/F64Vector.add:(D)V
        //   171: dup            
        //   172: dload_2         /* r */
        //   173: dload_2         /* r */
        //   174: dmul           
        //   175: dload           j
        //   177: dload           j
        //   179: dmul           
        //   180: dadd           
        //   181: dload           i
        //   183: dload           i
        //   185: dmul           
        //   186: dload           k
        //   188: dload           k
        //   190: dmul           
        //   191: dadd           
        //   192: dsub           
        //   193: iconst_m1      
        //   194: i2d            
        //   195: invokestatic    java/lang/Math.max:(DD)D
        //   198: dconst_1       
        //   199: invokestatic    java/lang/Math.min:(DD)D
        //   202: invokevirtual   gnu/lists/F64Vector.add:(D)V
        //   205: dup            
        //   206: iconst_2       
        //   207: i2d            
        //   208: dload           j
        //   210: dload           k
        //   212: dmul           
        //   213: dload_2         /* r */
        //   214: dload           i
        //   216: dmul           
        //   217: dsub           
        //   218: dmul           
        //   219: iconst_m1      
        //   220: i2d            
        //   221: invokestatic    java/lang/Math.max:(DD)D
        //   224: dconst_1       
        //   225: invokestatic    java/lang/Math.min:(DD)D
        //   228: invokevirtual   gnu/lists/F64Vector.add:(D)V
        //   231: dup            
        //   232: iconst_2       
        //   233: i2d            
        //   234: dload           i
        //   236: dload           k
        //   238: dmul           
        //   239: dload_2         /* r */
        //   240: dload           j
        //   242: dmul           
        //   243: dsub           
        //   244: dmul           
        //   245: iconst_m1      
        //   246: i2d            
        //   247: invokestatic    java/lang/Math.max:(DD)D
        //   250: dconst_1       
        //   251: invokestatic    java/lang/Math.min:(DD)D
        //   254: invokevirtual   gnu/lists/F64Vector.add:(D)V
        //   257: dup            
        //   258: iconst_2       
        //   259: i2d            
        //   260: dload_2         /* r */
        //   261: dload           i
        //   263: dmul           
        //   264: dload           j
        //   266: dload           k
        //   268: dmul           
        //   269: dadd           
        //   270: dmul           
        //   271: iconst_m1      
        //   272: i2d            
        //   273: invokestatic    java/lang/Math.max:(DD)D
        //   276: dconst_1       
        //   277: invokestatic    java/lang/Math.min:(DD)D
        //   280: invokevirtual   gnu/lists/F64Vector.add:(D)V
        //   283: dup            
        //   284: dload_2         /* r */
        //   285: dload_2         /* r */
        //   286: dmul           
        //   287: dload           k
        //   289: dload           k
        //   291: dmul           
        //   292: dadd           
        //   293: dload           i
        //   295: dload           i
        //   297: dmul           
        //   298: dload           j
        //   300: dload           j
        //   302: dmul           
        //   303: dadd           
        //   304: dsub           
        //   305: iconst_m1      
        //   306: i2d            
        //   307: invokestatic    java/lang/Math.max:(DD)D
        //   310: dconst_1       
        //   311: invokestatic    java/lang/Math.min:(DD)D
        //   314: invokevirtual   gnu/lists/F64Vector.add:(D)V
        //   317: iconst_4       
        //   318: anewarray       Ljava/lang/Object;
        //   321: dup            
        //   322: iconst_0       
        //   323: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   326: aastore        
        //   327: dup            
        //   328: iconst_1       
        //   329: getstatic       kawa/lib/kawa/rotations.Lit1:Lgnu/math/IntNum;
        //   332: aastore        
        //   333: dup            
        //   334: iconst_2       
        //   335: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   338: aastore        
        //   339: dup            
        //   340: iconst_3       
        //   341: getstatic       kawa/lib/kawa/rotations.Lit1:Lgnu/math/IntNum;
        //   344: aastore        
        //   345: invokestatic    kawa/lib/arrays.shape:([Ljava/lang/Object;)Lgnu/lists/Array;
        //   348: getstatic       kawa/lib/kawa/rotations.lambda$Fn1:Lgnu/expr/ModuleMethod;
        //   351: invokestatic    kawa/lib/arrays.shareArray:(Lgnu/lists/Array;Lgnu/lists/Array;Lgnu/mapping/Procedure;)Lgnu/lists/Array;
        //   354: areturn        
        //   355: new             Lgnu/mapping/WrongType;
        //   358: dup_x1         
        //   359: swap           
        //   360: ldc             "r"
        //   362: bipush          -2
        //   364: aload           4
        //   366: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   369: athrow         
        //   370: new             Lgnu/mapping/WrongType;
        //   373: dup_x1         
        //   374: swap           
        //   375: ldc             "i"
        //   377: bipush          -2
        //   379: aload           6
        //   381: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   384: athrow         
        //   385: new             Lgnu/mapping/WrongType;
        //   388: dup_x1         
        //   389: swap           
        //   390: ldc             "j"
        //   392: bipush          -2
        //   394: aload           8
        //   396: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   399: athrow         
        //   400: new             Lgnu/mapping/WrongType;
        //   403: dup_x1         
        //   404: swap           
        //   405: ldc             "k"
        //   407: bipush          -2
        //   409: aload           10
        //   411: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   414: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  12     15     355    370    Ljava/lang/ClassCastException;
        //  23     26     370    385    Ljava/lang/ClassCastException;
        //  35     38     385    400    Ljava/lang/ClassCastException;
        //  47     50     400    415    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 252 out of bounds for length 252
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
    
    static Object lambda1(final Object i, final Object j) {
        return AddOp.apply2(1, MultiplyOp.$St.apply2(rotations.Lit1, i), j);
    }
    
    public static Quaternion rotationMatrix$To$Quaternion(final Array m) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_0         /* m */
        //     4: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //     7: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //    10: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    13: astore_1       
        //    14: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //    17: aload_0         /* m */
        //    18: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //    21: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //    24: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    27: astore_2       
        //    28: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //    31: aload_0         /* m */
        //    32: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //    35: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //    38: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    41: astore_3        /* m22 */
        //    42: iconst_1       
        //    43: iconst_1       
        //    44: iconst_1       
        //    45: aload_1         /* m00 */
        //    46: aload_2         /* m11 */
        //    47: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    50: aload_3         /* m22 */
        //    51: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    54: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //    57: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    60: astore          trace
        //    62: aload           trace
        //    64: getstatic       kawa/lib/kawa/rotations.Lit4:Ljava/lang/Double;
        //    67: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    70: ifeq            242
        //    73: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //    76: getstatic       kawa/lib/kawa/rotations.Lit5:Lgnu/math/IntFraction;
        //    79: aload           trace
        //    81: ldc             Ljava/lang/Number;.class
        //    83: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    86: dup            
        //    87: astore          6
        //    89: checkcast       Ljava/lang/Number;
        //    92: invokestatic    kawa/lib/numbers.sqrt:(Ljava/lang/Number;)Ljava/lang/Number;
        //    95: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    98: astore          s
        //   100: getstatic       kawa/lib/numbers.make$Mnrectangular:Lgnu/expr/GenericProc;
        //   103: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   106: getstatic       kawa/lib/kawa/rotations.Lit6:Lgnu/math/IntFraction;
        //   109: aload           s
        //   111: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   114: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   117: aload           s
        //   119: iconst_m1      
        //   120: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   123: aload_0         /* m */
        //   124: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   127: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   130: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   133: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   136: aload_0         /* m */
        //   137: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   140: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   143: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   146: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   149: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   152: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   155: aload           s
        //   157: iconst_m1      
        //   158: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   161: aload_0         /* m */
        //   162: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   165: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   168: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   171: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   174: aload_0         /* m */
        //   175: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   178: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   181: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   184: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   187: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   190: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   193: aload           s
        //   195: iconst_m1      
        //   196: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   199: aload_0         /* m */
        //   200: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   203: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   206: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   209: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   212: aload_0         /* m */
        //   213: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   216: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   219: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   222: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   225: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   228: invokevirtual   gnu/mapping/Procedure.apply4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   231: ldc             Lgnu/math/Quaternion;.class
        //   233: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   236: checkcast       Lgnu/math/Quaternion;
        //   239: goto            854
        //   242: aload_1         /* m00 */
        //   243: aload_2         /* m11 */
        //   244: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   247: ifeq            455
        //   250: aload_1         /* m00 */
        //   251: aload_3         /* m22 */
        //   252: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   255: ifeq            455
        //   258: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   261: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   264: iconst_1       
        //   265: iconst_1       
        //   266: iconst_1       
        //   267: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   270: aload_1         /* m00 */
        //   271: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   274: getstatic       gnu/kawa/functions/AddOp.$Mn:Lgnu/kawa/functions/AddOp;
        //   277: aload_2         /* m11 */
        //   278: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   281: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   284: getstatic       gnu/kawa/functions/AddOp.$Mn:Lgnu/kawa/functions/AddOp;
        //   287: aload_3         /* m22 */
        //   288: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   291: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   294: ldc             Ljava/lang/Number;.class
        //   296: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   299: dup            
        //   300: astore          6
        //   302: checkcast       Ljava/lang/Number;
        //   305: invokestatic    kawa/lib/numbers.sqrt:(Ljava/lang/Number;)Ljava/lang/Number;
        //   308: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   311: astore          s
        //   313: getstatic       kawa/lib/numbers.make$Mnrectangular:Lgnu/expr/GenericProc;
        //   316: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   319: iconst_m1      
        //   320: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   323: aload_0         /* m */
        //   324: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   327: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   330: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   333: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   336: aload_0         /* m */
        //   337: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   340: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   343: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   346: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   349: aload           s
        //   351: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   354: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   357: getstatic       kawa/lib/kawa/rotations.Lit7:Lgnu/math/IntFraction;
        //   360: aload           s
        //   362: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   365: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   368: iconst_1       
        //   369: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   372: aload_0         /* m */
        //   373: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   376: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   379: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   382: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   385: aload_0         /* m */
        //   386: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   389: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   392: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   395: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   398: aload           s
        //   400: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   403: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   406: iconst_1       
        //   407: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   410: aload_0         /* m */
        //   411: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   414: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   417: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   420: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   423: aload_0         /* m */
        //   424: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   427: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   430: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   433: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   436: aload           s
        //   438: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   441: invokevirtual   gnu/mapping/Procedure.apply4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   444: ldc             Lgnu/math/Quaternion;.class
        //   446: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   449: checkcast       Lgnu/math/Quaternion;
        //   452: goto            854
        //   455: aload_2         /* m11 */
        //   456: aload_3         /* m22 */
        //   457: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   460: ifeq            660
        //   463: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   466: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   469: iconst_1       
        //   470: iconst_1       
        //   471: iconst_1       
        //   472: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   475: aload_2         /* m11 */
        //   476: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   479: getstatic       gnu/kawa/functions/AddOp.$Mn:Lgnu/kawa/functions/AddOp;
        //   482: aload_1         /* m00 */
        //   483: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   486: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   489: getstatic       gnu/kawa/functions/AddOp.$Mn:Lgnu/kawa/functions/AddOp;
        //   492: aload_3         /* m22 */
        //   493: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   496: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   499: ldc             Ljava/lang/Number;.class
        //   501: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   504: dup            
        //   505: astore          6
        //   507: checkcast       Ljava/lang/Number;
        //   510: invokestatic    kawa/lib/numbers.sqrt:(Ljava/lang/Number;)Ljava/lang/Number;
        //   513: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   516: astore          s
        //   518: getstatic       kawa/lib/numbers.make$Mnrectangular:Lgnu/expr/GenericProc;
        //   521: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   524: iconst_m1      
        //   525: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   528: aload_0         /* m */
        //   529: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   532: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   535: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   538: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   541: aload_0         /* m */
        //   542: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   545: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   548: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   551: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   554: aload           s
        //   556: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   559: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   562: iconst_1       
        //   563: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   566: aload_0         /* m */
        //   567: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   570: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   573: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   576: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   579: aload_0         /* m */
        //   580: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   583: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   586: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   589: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   592: aload           s
        //   594: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   597: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   600: getstatic       kawa/lib/kawa/rotations.Lit8:Lgnu/math/IntFraction;
        //   603: aload           s
        //   605: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   608: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   611: iconst_1       
        //   612: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   615: aload_0         /* m */
        //   616: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   619: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   622: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   625: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   628: aload_0         /* m */
        //   629: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   632: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   635: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   638: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   641: aload           s
        //   643: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   646: invokevirtual   gnu/mapping/Procedure.apply4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   649: ldc             Lgnu/math/Quaternion;.class
        //   651: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   654: checkcast       Lgnu/math/Quaternion;
        //   657: goto            854
        //   660: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   663: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   666: iconst_1       
        //   667: iconst_1       
        //   668: iconst_1       
        //   669: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   672: aload_3         /* m22 */
        //   673: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   676: getstatic       gnu/kawa/functions/AddOp.$Mn:Lgnu/kawa/functions/AddOp;
        //   679: aload_1         /* m00 */
        //   680: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   683: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   686: getstatic       gnu/kawa/functions/AddOp.$Mn:Lgnu/kawa/functions/AddOp;
        //   689: aload_2         /* m11 */
        //   690: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   693: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   696: ldc             Ljava/lang/Number;.class
        //   698: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   701: dup            
        //   702: astore          6
        //   704: checkcast       Ljava/lang/Number;
        //   707: invokestatic    kawa/lib/numbers.sqrt:(Ljava/lang/Number;)Ljava/lang/Number;
        //   710: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   713: astore          s
        //   715: getstatic       kawa/lib/numbers.make$Mnrectangular:Lgnu/expr/GenericProc;
        //   718: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   721: iconst_m1      
        //   722: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   725: aload_0         /* m */
        //   726: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   729: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   732: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   735: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   738: aload_0         /* m */
        //   739: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   742: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   745: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   748: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   751: aload           s
        //   753: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   756: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   759: iconst_1       
        //   760: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   763: aload_0         /* m */
        //   764: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   767: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   770: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   773: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   776: aload_0         /* m */
        //   777: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   780: getstatic       kawa/lib/kawa/rotations.Lit0:Lgnu/math/IntNum;
        //   783: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   786: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   789: aload           s
        //   791: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   794: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   797: iconst_1       
        //   798: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   801: aload_0         /* m */
        //   802: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   805: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   808: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   811: getstatic       gnu/kawa/functions/ArrayRef.arrayRef:Lgnu/kawa/functions/ArrayRef;
        //   814: aload_0         /* m */
        //   815: getstatic       kawa/lib/kawa/rotations.Lit3:Lgnu/math/IntNum;
        //   818: getstatic       kawa/lib/kawa/rotations.Lit2:Lgnu/math/IntNum;
        //   821: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   824: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   827: aload           s
        //   829: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   832: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   835: getstatic       kawa/lib/kawa/rotations.Lit9:Lgnu/math/IntFraction;
        //   838: aload           s
        //   840: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   843: invokevirtual   gnu/mapping/Procedure.apply4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   846: ldc             Lgnu/math/Quaternion;.class
        //   848: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   851: checkcast       Lgnu/math/Quaternion;
        //   854: areturn        
        //   855: new             Lgnu/mapping/WrongType;
        //   858: dup_x1         
        //   859: swap           
        //   860: ldc             "sqrt"
        //   862: iconst_1       
        //   863: aload           6
        //   865: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   868: athrow         
        //   869: new             Lgnu/mapping/WrongType;
        //   872: dup_x1         
        //   873: swap           
        //   874: ldc             "sqrt"
        //   876: iconst_1       
        //   877: aload           6
        //   879: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   882: athrow         
        //   883: new             Lgnu/mapping/WrongType;
        //   886: dup_x1         
        //   887: swap           
        //   888: ldc             "sqrt"
        //   890: iconst_1       
        //   891: aload           6
        //   893: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   896: athrow         
        //   897: new             Lgnu/mapping/WrongType;
        //   900: dup_x1         
        //   901: swap           
        //   902: ldc             "sqrt"
        //   904: iconst_1       
        //   905: aload           6
        //   907: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   910: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  89     92     855    869    Ljava/lang/ClassCastException;
        //  302    305    869    883    Ljava/lang/ClassCastException;
        //  507    510    883    897    Ljava/lang/ClassCastException;
        //  704    707    897    911    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Quaternion rotationAxis(final Quaternion q) {
        final Quaternion u = numbers.unitVector(q);
        return NumberCompare.$Eq(rotations.Lit0, u) ? rotations.Lit10 : u;
    }
    
    public static RealNum rotationAngle(final Quaternion q) {
        return LangObjType.coerceRealNum(Promise.force(MultiplyOp.$St.apply2(rotations.Lit3, numbers.atan.apply2(numbers.magnitude(quaternions.vectorPart(q)), numbers.realPart(q))), RealNum.class));
    }
    
    public static Values rotationAxis$SlAngle(final Quaternion q) {
        return Values.values2(rotationAxis(q), rotationAngle(q));
    }
    
    public static Quaternion rotx(final RealNum angle) {
        final RealNum halfangle = RealNum.divide(angle, rotations.Lit3);
        return (Quaternion)Promise.force(numbers.make$Mnrectangular.apply2(numbers.cos.apply1(halfangle), numbers.sin.apply1(halfangle)), Quaternion.class);
    }
    
    public static Quaternion roty(final RealNum angle) {
        final RealNum halfangle = RealNum.divide(angle, rotations.Lit3);
        return (Quaternion)Promise.force(numbers.make$Mnrectangular.apply4(numbers.cos.apply1(halfangle), rotations.Lit0, numbers.sin.apply1(halfangle), rotations.Lit0), Quaternion.class);
    }
    
    public static Quaternion rotz(final RealNum angle) {
        final RealNum halfangle = RealNum.divide(angle, rotations.Lit3);
        return (Quaternion)Promise.force(numbers.make$Mnrectangular.apply4(numbers.cos.apply1(halfangle), rotations.Lit0, rotations.Lit0, numbers.sin.apply1(halfangle)), Quaternion.class);
    }
    
    public static Object intrinsicXyx(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: astore_1        /* uq */
        //     5: aload_1         /* uq */
        //     6: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     9: dup            
        //    10: astore          4
        //    12: invokevirtual   java/lang/Number.doubleValue:()D
        //    15: dstore_2        /* r */
        //    16: aload_1         /* uq */
        //    17: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    20: dup            
        //    21: astore          6
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: dstore          i
        //    28: aload_1         /* uq */
        //    29: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    32: dup            
        //    33: astore          8
        //    35: invokevirtual   java/lang/Number.doubleValue:()D
        //    38: dstore          j
        //    40: aload_1         /* uq */
        //    41: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    44: dup            
        //    45: astore          10
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore          k
        //    52: dload_2         /* r */
        //    53: dload_2         /* r */
        //    54: dmul           
        //    55: dload           i
        //    57: dload           i
        //    59: dmul           
        //    60: dadd           
        //    61: dload           j
        //    63: dload           j
        //    65: dmul           
        //    66: dload           k
        //    68: dload           k
        //    70: dmul           
        //    71: dadd           
        //    72: dsub           
        //    73: iconst_m1      
        //    74: i2d            
        //    75: invokestatic    java/lang/Math.max:(DD)D
        //    78: dconst_1       
        //    79: invokestatic    java/lang/Math.min:(DD)D
        //    82: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    85: invokestatic    kawa/lib/numbers.acos:(Ljava/lang/Number;)Ljava/lang/Number;
        //    88: astore          beta
        //    90: aload           beta
        //    92: getstatic       kawa/lib/kawa/rotations.Lit4:Ljava/lang/Double;
        //    95: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    98: istore          x
        //   100: iload           x
        //   102: ifeq            113
        //   105: iload           x
        //   107: ifeq            220
        //   110: goto            131
        //   113: aload           beta
        //   115: getstatic       java/lang/Math.PI:D
        //   118: ldc2_w          1.0E-12
        //   121: dsub           
        //   122: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   125: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   128: ifeq            220
        //   131: iconst_3       
        //   132: anewarray       Ljava/lang/Object;
        //   135: dup            
        //   136: iconst_0       
        //   137: getstatic       kawa/lib/kawa/rotations.Lit11:Lgnu/math/DFloNum;
        //   140: aastore        
        //   141: dup            
        //   142: iconst_1       
        //   143: aload           beta
        //   145: aastore        
        //   146: dup            
        //   147: iconst_2       
        //   148: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   151: iconst_2       
        //   152: i2d            
        //   153: dload           j
        //   155: dload           k
        //   157: dmul           
        //   158: dload_2         /* r */
        //   159: dload           i
        //   161: dmul           
        //   162: dsub           
        //   163: dmul           
        //   164: iconst_m1      
        //   165: i2d            
        //   166: invokestatic    java/lang/Math.max:(DD)D
        //   169: dconst_1       
        //   170: invokestatic    java/lang/Math.min:(DD)D
        //   173: dneg           
        //   174: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   177: dload_2         /* r */
        //   178: dload_2         /* r */
        //   179: dmul           
        //   180: dload           j
        //   182: dload           j
        //   184: dmul           
        //   185: dadd           
        //   186: dload           i
        //   188: dload           i
        //   190: dmul           
        //   191: dload           k
        //   193: dload           k
        //   195: dmul           
        //   196: dadd           
        //   197: dsub           
        //   198: iconst_m1      
        //   199: i2d            
        //   200: invokestatic    java/lang/Math.max:(DD)D
        //   203: dconst_1       
        //   204: invokestatic    java/lang/Math.min:(DD)D
        //   207: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   210: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   213: aastore        
        //   214: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   217: goto            351
        //   220: iconst_3       
        //   221: anewarray       Ljava/lang/Object;
        //   224: dup            
        //   225: iconst_0       
        //   226: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   229: iconst_2       
        //   230: i2d            
        //   231: dload           i
        //   233: dload           j
        //   235: dmul           
        //   236: dload_2         /* r */
        //   237: dload           k
        //   239: dmul           
        //   240: dadd           
        //   241: dmul           
        //   242: iconst_m1      
        //   243: i2d            
        //   244: invokestatic    java/lang/Math.max:(DD)D
        //   247: dconst_1       
        //   248: invokestatic    java/lang/Math.min:(DD)D
        //   251: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   254: iconst_2       
        //   255: i2d            
        //   256: dload           i
        //   258: dload           k
        //   260: dmul           
        //   261: dload_2         /* r */
        //   262: dload           j
        //   264: dmul           
        //   265: dsub           
        //   266: dmul           
        //   267: iconst_m1      
        //   268: i2d            
        //   269: invokestatic    java/lang/Math.max:(DD)D
        //   272: dconst_1       
        //   273: invokestatic    java/lang/Math.min:(DD)D
        //   276: dneg           
        //   277: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   280: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   283: aastore        
        //   284: dup            
        //   285: iconst_1       
        //   286: aload           beta
        //   288: aastore        
        //   289: dup            
        //   290: iconst_2       
        //   291: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   294: iconst_2       
        //   295: i2d            
        //   296: dload           i
        //   298: dload           j
        //   300: dmul           
        //   301: dload_2         /* r */
        //   302: dload           k
        //   304: dmul           
        //   305: dsub           
        //   306: dmul           
        //   307: iconst_m1      
        //   308: i2d            
        //   309: invokestatic    java/lang/Math.max:(DD)D
        //   312: dconst_1       
        //   313: invokestatic    java/lang/Math.min:(DD)D
        //   316: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   319: iconst_2       
        //   320: i2d            
        //   321: dload           i
        //   323: dload           k
        //   325: dmul           
        //   326: dload_2         /* r */
        //   327: dload           j
        //   329: dmul           
        //   330: dadd           
        //   331: dmul           
        //   332: iconst_m1      
        //   333: i2d            
        //   334: invokestatic    java/lang/Math.max:(DD)D
        //   337: dconst_1       
        //   338: invokestatic    java/lang/Math.min:(DD)D
        //   341: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   344: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   347: aastore        
        //   348: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   351: areturn        
        //   352: new             Lgnu/mapping/WrongType;
        //   355: dup_x1         
        //   356: swap           
        //   357: ldc             "r"
        //   359: bipush          -2
        //   361: aload           4
        //   363: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   366: athrow         
        //   367: new             Lgnu/mapping/WrongType;
        //   370: dup_x1         
        //   371: swap           
        //   372: ldc             "i"
        //   374: bipush          -2
        //   376: aload           6
        //   378: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   381: athrow         
        //   382: new             Lgnu/mapping/WrongType;
        //   385: dup_x1         
        //   386: swap           
        //   387: ldc             "j"
        //   389: bipush          -2
        //   391: aload           8
        //   393: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   396: athrow         
        //   397: new             Lgnu/mapping/WrongType;
        //   400: dup_x1         
        //   401: swap           
        //   402: ldc             "k"
        //   404: bipush          -2
        //   406: aload           10
        //   408: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   411: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  12     15     352    367    Ljava/lang/ClassCastException;
        //  23     26     367    382    Ljava/lang/ClassCastException;
        //  35     38     382    397    Ljava/lang/ClassCastException;
        //  47     50     397    412    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 236 out of bounds for length 236
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
    
    public static Object intrinsicXzx(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: astore_1        /* uq */
        //     5: aload_1         /* uq */
        //     6: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     9: dup            
        //    10: astore          4
        //    12: invokevirtual   java/lang/Number.doubleValue:()D
        //    15: dstore_2        /* r */
        //    16: aload_1         /* uq */
        //    17: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    20: dup            
        //    21: astore          6
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: dstore          i
        //    28: aload_1         /* uq */
        //    29: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    32: dup            
        //    33: astore          8
        //    35: invokevirtual   java/lang/Number.doubleValue:()D
        //    38: dstore          j
        //    40: aload_1         /* uq */
        //    41: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    44: dup            
        //    45: astore          10
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore          k
        //    52: dload_2         /* r */
        //    53: dload_2         /* r */
        //    54: dmul           
        //    55: dload           i
        //    57: dload           i
        //    59: dmul           
        //    60: dadd           
        //    61: dload           j
        //    63: dload           j
        //    65: dmul           
        //    66: dload           k
        //    68: dload           k
        //    70: dmul           
        //    71: dadd           
        //    72: dsub           
        //    73: iconst_m1      
        //    74: i2d            
        //    75: invokestatic    java/lang/Math.max:(DD)D
        //    78: dconst_1       
        //    79: invokestatic    java/lang/Math.min:(DD)D
        //    82: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    85: invokestatic    kawa/lib/numbers.acos:(Ljava/lang/Number;)Ljava/lang/Number;
        //    88: astore          beta
        //    90: aload           beta
        //    92: getstatic       kawa/lib/kawa/rotations.Lit4:Ljava/lang/Double;
        //    95: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    98: istore          x
        //   100: iload           x
        //   102: ifeq            113
        //   105: iload           x
        //   107: ifeq            219
        //   110: goto            131
        //   113: aload           beta
        //   115: getstatic       java/lang/Math.PI:D
        //   118: ldc2_w          1.0E-12
        //   121: dsub           
        //   122: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   125: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   128: ifeq            219
        //   131: iconst_3       
        //   132: anewarray       Ljava/lang/Object;
        //   135: dup            
        //   136: iconst_0       
        //   137: getstatic       kawa/lib/kawa/rotations.Lit11:Lgnu/math/DFloNum;
        //   140: aastore        
        //   141: dup            
        //   142: iconst_1       
        //   143: aload           beta
        //   145: aastore        
        //   146: dup            
        //   147: iconst_2       
        //   148: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   151: iconst_2       
        //   152: i2d            
        //   153: dload_2         /* r */
        //   154: dload           i
        //   156: dmul           
        //   157: dload           j
        //   159: dload           k
        //   161: dmul           
        //   162: dadd           
        //   163: dmul           
        //   164: iconst_m1      
        //   165: i2d            
        //   166: invokestatic    java/lang/Math.max:(DD)D
        //   169: dconst_1       
        //   170: invokestatic    java/lang/Math.min:(DD)D
        //   173: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   176: dload_2         /* r */
        //   177: dload_2         /* r */
        //   178: dmul           
        //   179: dload           k
        //   181: dload           k
        //   183: dmul           
        //   184: dadd           
        //   185: dload           i
        //   187: dload           i
        //   189: dmul           
        //   190: dload           j
        //   192: dload           j
        //   194: dmul           
        //   195: dadd           
        //   196: dsub           
        //   197: iconst_m1      
        //   198: i2d            
        //   199: invokestatic    java/lang/Math.max:(DD)D
        //   202: dconst_1       
        //   203: invokestatic    java/lang/Math.min:(DD)D
        //   206: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   209: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   212: aastore        
        //   213: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   216: goto            350
        //   219: iconst_3       
        //   220: anewarray       Ljava/lang/Object;
        //   223: dup            
        //   224: iconst_0       
        //   225: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   228: iconst_2       
        //   229: i2d            
        //   230: dload           i
        //   232: dload           k
        //   234: dmul           
        //   235: dload_2         /* r */
        //   236: dload           j
        //   238: dmul           
        //   239: dsub           
        //   240: dmul           
        //   241: iconst_m1      
        //   242: i2d            
        //   243: invokestatic    java/lang/Math.max:(DD)D
        //   246: dconst_1       
        //   247: invokestatic    java/lang/Math.min:(DD)D
        //   250: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   253: iconst_2       
        //   254: i2d            
        //   255: dload           i
        //   257: dload           j
        //   259: dmul           
        //   260: dload_2         /* r */
        //   261: dload           k
        //   263: dmul           
        //   264: dadd           
        //   265: dmul           
        //   266: iconst_m1      
        //   267: i2d            
        //   268: invokestatic    java/lang/Math.max:(DD)D
        //   271: dconst_1       
        //   272: invokestatic    java/lang/Math.min:(DD)D
        //   275: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   278: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   281: aastore        
        //   282: dup            
        //   283: iconst_1       
        //   284: aload           beta
        //   286: aastore        
        //   287: dup            
        //   288: iconst_2       
        //   289: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   292: iconst_2       
        //   293: i2d            
        //   294: dload           i
        //   296: dload           k
        //   298: dmul           
        //   299: dload_2         /* r */
        //   300: dload           j
        //   302: dmul           
        //   303: dadd           
        //   304: dmul           
        //   305: iconst_m1      
        //   306: i2d            
        //   307: invokestatic    java/lang/Math.max:(DD)D
        //   310: dconst_1       
        //   311: invokestatic    java/lang/Math.min:(DD)D
        //   314: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   317: iconst_2       
        //   318: i2d            
        //   319: dload           i
        //   321: dload           j
        //   323: dmul           
        //   324: dload_2         /* r */
        //   325: dload           k
        //   327: dmul           
        //   328: dsub           
        //   329: dmul           
        //   330: iconst_m1      
        //   331: i2d            
        //   332: invokestatic    java/lang/Math.max:(DD)D
        //   335: dconst_1       
        //   336: invokestatic    java/lang/Math.min:(DD)D
        //   339: dneg           
        //   340: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   343: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   346: aastore        
        //   347: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   350: areturn        
        //   351: new             Lgnu/mapping/WrongType;
        //   354: dup_x1         
        //   355: swap           
        //   356: ldc             "r"
        //   358: bipush          -2
        //   360: aload           4
        //   362: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   365: athrow         
        //   366: new             Lgnu/mapping/WrongType;
        //   369: dup_x1         
        //   370: swap           
        //   371: ldc             "i"
        //   373: bipush          -2
        //   375: aload           6
        //   377: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   380: athrow         
        //   381: new             Lgnu/mapping/WrongType;
        //   384: dup_x1         
        //   385: swap           
        //   386: ldc             "j"
        //   388: bipush          -2
        //   390: aload           8
        //   392: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   395: athrow         
        //   396: new             Lgnu/mapping/WrongType;
        //   399: dup_x1         
        //   400: swap           
        //   401: ldc             "k"
        //   403: bipush          -2
        //   405: aload           10
        //   407: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   410: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  12     15     351    366    Ljava/lang/ClassCastException;
        //  23     26     366    381    Ljava/lang/ClassCastException;
        //  35     38     381    396    Ljava/lang/ClassCastException;
        //  47     50     396    411    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 235 out of bounds for length 235
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
    
    public static Object intrinsicYxy(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: astore_1        /* uq */
        //     5: aload_1         /* uq */
        //     6: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     9: dup            
        //    10: astore          4
        //    12: invokevirtual   java/lang/Number.doubleValue:()D
        //    15: dstore_2        /* r */
        //    16: aload_1         /* uq */
        //    17: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    20: dup            
        //    21: astore          6
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: dstore          i
        //    28: aload_1         /* uq */
        //    29: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    32: dup            
        //    33: astore          8
        //    35: invokevirtual   java/lang/Number.doubleValue:()D
        //    38: dstore          j
        //    40: aload_1         /* uq */
        //    41: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    44: dup            
        //    45: astore          10
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore          k
        //    52: dload_2         /* r */
        //    53: dload_2         /* r */
        //    54: dmul           
        //    55: dload           j
        //    57: dload           j
        //    59: dmul           
        //    60: dadd           
        //    61: dload           i
        //    63: dload           i
        //    65: dmul           
        //    66: dload           k
        //    68: dload           k
        //    70: dmul           
        //    71: dadd           
        //    72: dsub           
        //    73: iconst_m1      
        //    74: i2d            
        //    75: invokestatic    java/lang/Math.max:(DD)D
        //    78: dconst_1       
        //    79: invokestatic    java/lang/Math.min:(DD)D
        //    82: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    85: invokestatic    kawa/lib/numbers.acos:(Ljava/lang/Number;)Ljava/lang/Number;
        //    88: astore          beta
        //    90: aload           beta
        //    92: getstatic       kawa/lib/kawa/rotations.Lit4:Ljava/lang/Double;
        //    95: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    98: istore          x
        //   100: iload           x
        //   102: ifeq            113
        //   105: iload           x
        //   107: ifeq            219
        //   110: goto            131
        //   113: aload           beta
        //   115: getstatic       java/lang/Math.PI:D
        //   118: ldc2_w          1.0E-12
        //   121: dsub           
        //   122: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   125: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   128: ifeq            219
        //   131: iconst_3       
        //   132: anewarray       Ljava/lang/Object;
        //   135: dup            
        //   136: iconst_0       
        //   137: getstatic       kawa/lib/kawa/rotations.Lit11:Lgnu/math/DFloNum;
        //   140: aastore        
        //   141: dup            
        //   142: iconst_1       
        //   143: aload           beta
        //   145: aastore        
        //   146: dup            
        //   147: iconst_2       
        //   148: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   151: iconst_2       
        //   152: i2d            
        //   153: dload           i
        //   155: dload           k
        //   157: dmul           
        //   158: dload_2         /* r */
        //   159: dload           j
        //   161: dmul           
        //   162: dadd           
        //   163: dmul           
        //   164: iconst_m1      
        //   165: i2d            
        //   166: invokestatic    java/lang/Math.max:(DD)D
        //   169: dconst_1       
        //   170: invokestatic    java/lang/Math.min:(DD)D
        //   173: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   176: dload_2         /* r */
        //   177: dload_2         /* r */
        //   178: dmul           
        //   179: dload           i
        //   181: dload           i
        //   183: dmul           
        //   184: dadd           
        //   185: dload           j
        //   187: dload           j
        //   189: dmul           
        //   190: dload           k
        //   192: dload           k
        //   194: dmul           
        //   195: dadd           
        //   196: dsub           
        //   197: iconst_m1      
        //   198: i2d            
        //   199: invokestatic    java/lang/Math.max:(DD)D
        //   202: dconst_1       
        //   203: invokestatic    java/lang/Math.min:(DD)D
        //   206: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   209: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   212: aastore        
        //   213: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   216: goto            350
        //   219: iconst_3       
        //   220: anewarray       Ljava/lang/Object;
        //   223: dup            
        //   224: iconst_0       
        //   225: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   228: iconst_2       
        //   229: i2d            
        //   230: dload           i
        //   232: dload           j
        //   234: dmul           
        //   235: dload_2         /* r */
        //   236: dload           k
        //   238: dmul           
        //   239: dsub           
        //   240: dmul           
        //   241: iconst_m1      
        //   242: i2d            
        //   243: invokestatic    java/lang/Math.max:(DD)D
        //   246: dconst_1       
        //   247: invokestatic    java/lang/Math.min:(DD)D
        //   250: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   253: iconst_2       
        //   254: i2d            
        //   255: dload_2         /* r */
        //   256: dload           i
        //   258: dmul           
        //   259: dload           j
        //   261: dload           k
        //   263: dmul           
        //   264: dadd           
        //   265: dmul           
        //   266: iconst_m1      
        //   267: i2d            
        //   268: invokestatic    java/lang/Math.max:(DD)D
        //   271: dconst_1       
        //   272: invokestatic    java/lang/Math.min:(DD)D
        //   275: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   278: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   281: aastore        
        //   282: dup            
        //   283: iconst_1       
        //   284: aload           beta
        //   286: aastore        
        //   287: dup            
        //   288: iconst_2       
        //   289: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   292: iconst_2       
        //   293: i2d            
        //   294: dload           i
        //   296: dload           j
        //   298: dmul           
        //   299: dload_2         /* r */
        //   300: dload           k
        //   302: dmul           
        //   303: dadd           
        //   304: dmul           
        //   305: iconst_m1      
        //   306: i2d            
        //   307: invokestatic    java/lang/Math.max:(DD)D
        //   310: dconst_1       
        //   311: invokestatic    java/lang/Math.min:(DD)D
        //   314: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   317: iconst_2       
        //   318: i2d            
        //   319: dload           j
        //   321: dload           k
        //   323: dmul           
        //   324: dload_2         /* r */
        //   325: dload           i
        //   327: dmul           
        //   328: dsub           
        //   329: dmul           
        //   330: iconst_m1      
        //   331: i2d            
        //   332: invokestatic    java/lang/Math.max:(DD)D
        //   335: dconst_1       
        //   336: invokestatic    java/lang/Math.min:(DD)D
        //   339: dneg           
        //   340: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   343: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   346: aastore        
        //   347: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   350: areturn        
        //   351: new             Lgnu/mapping/WrongType;
        //   354: dup_x1         
        //   355: swap           
        //   356: ldc             "r"
        //   358: bipush          -2
        //   360: aload           4
        //   362: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   365: athrow         
        //   366: new             Lgnu/mapping/WrongType;
        //   369: dup_x1         
        //   370: swap           
        //   371: ldc             "i"
        //   373: bipush          -2
        //   375: aload           6
        //   377: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   380: athrow         
        //   381: new             Lgnu/mapping/WrongType;
        //   384: dup_x1         
        //   385: swap           
        //   386: ldc             "j"
        //   388: bipush          -2
        //   390: aload           8
        //   392: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   395: athrow         
        //   396: new             Lgnu/mapping/WrongType;
        //   399: dup_x1         
        //   400: swap           
        //   401: ldc             "k"
        //   403: bipush          -2
        //   405: aload           10
        //   407: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   410: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  12     15     351    366    Ljava/lang/ClassCastException;
        //  23     26     366    381    Ljava/lang/ClassCastException;
        //  35     38     381    396    Ljava/lang/ClassCastException;
        //  47     50     396    411    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 235 out of bounds for length 235
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
    
    public static Object intrinsicYzy(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: astore_1        /* uq */
        //     5: aload_1         /* uq */
        //     6: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     9: dup            
        //    10: astore          4
        //    12: invokevirtual   java/lang/Number.doubleValue:()D
        //    15: dstore_2        /* r */
        //    16: aload_1         /* uq */
        //    17: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    20: dup            
        //    21: astore          6
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: dstore          i
        //    28: aload_1         /* uq */
        //    29: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    32: dup            
        //    33: astore          8
        //    35: invokevirtual   java/lang/Number.doubleValue:()D
        //    38: dstore          j
        //    40: aload_1         /* uq */
        //    41: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    44: dup            
        //    45: astore          10
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore          k
        //    52: dload_2         /* r */
        //    53: dload_2         /* r */
        //    54: dmul           
        //    55: dload           j
        //    57: dload           j
        //    59: dmul           
        //    60: dadd           
        //    61: dload           i
        //    63: dload           i
        //    65: dmul           
        //    66: dload           k
        //    68: dload           k
        //    70: dmul           
        //    71: dadd           
        //    72: dsub           
        //    73: iconst_m1      
        //    74: i2d            
        //    75: invokestatic    java/lang/Math.max:(DD)D
        //    78: dconst_1       
        //    79: invokestatic    java/lang/Math.min:(DD)D
        //    82: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    85: invokestatic    kawa/lib/numbers.acos:(Ljava/lang/Number;)Ljava/lang/Number;
        //    88: astore          beta
        //    90: aload           beta
        //    92: getstatic       kawa/lib/kawa/rotations.Lit4:Ljava/lang/Double;
        //    95: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    98: istore          x
        //   100: iload           x
        //   102: ifeq            113
        //   105: iload           x
        //   107: ifeq            220
        //   110: goto            131
        //   113: aload           beta
        //   115: getstatic       java/lang/Math.PI:D
        //   118: ldc2_w          1.0E-12
        //   121: dsub           
        //   122: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   125: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   128: ifeq            220
        //   131: iconst_3       
        //   132: anewarray       Ljava/lang/Object;
        //   135: dup            
        //   136: iconst_0       
        //   137: getstatic       kawa/lib/kawa/rotations.Lit11:Lgnu/math/DFloNum;
        //   140: aastore        
        //   141: dup            
        //   142: iconst_1       
        //   143: aload           beta
        //   145: aastore        
        //   146: dup            
        //   147: iconst_2       
        //   148: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   151: iconst_2       
        //   152: i2d            
        //   153: dload           i
        //   155: dload           k
        //   157: dmul           
        //   158: dload_2         /* r */
        //   159: dload           j
        //   161: dmul           
        //   162: dsub           
        //   163: dmul           
        //   164: iconst_m1      
        //   165: i2d            
        //   166: invokestatic    java/lang/Math.max:(DD)D
        //   169: dconst_1       
        //   170: invokestatic    java/lang/Math.min:(DD)D
        //   173: dneg           
        //   174: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   177: dload_2         /* r */
        //   178: dload_2         /* r */
        //   179: dmul           
        //   180: dload           k
        //   182: dload           k
        //   184: dmul           
        //   185: dadd           
        //   186: dload           i
        //   188: dload           i
        //   190: dmul           
        //   191: dload           j
        //   193: dload           j
        //   195: dmul           
        //   196: dadd           
        //   197: dsub           
        //   198: iconst_m1      
        //   199: i2d            
        //   200: invokestatic    java/lang/Math.max:(DD)D
        //   203: dconst_1       
        //   204: invokestatic    java/lang/Math.min:(DD)D
        //   207: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   210: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   213: aastore        
        //   214: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   217: goto            351
        //   220: iconst_3       
        //   221: anewarray       Ljava/lang/Object;
        //   224: dup            
        //   225: iconst_0       
        //   226: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   229: iconst_2       
        //   230: i2d            
        //   231: dload_2         /* r */
        //   232: dload           i
        //   234: dmul           
        //   235: dload           j
        //   237: dload           k
        //   239: dmul           
        //   240: dadd           
        //   241: dmul           
        //   242: iconst_m1      
        //   243: i2d            
        //   244: invokestatic    java/lang/Math.max:(DD)D
        //   247: dconst_1       
        //   248: invokestatic    java/lang/Math.min:(DD)D
        //   251: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   254: iconst_2       
        //   255: i2d            
        //   256: dload           i
        //   258: dload           j
        //   260: dmul           
        //   261: dload_2         /* r */
        //   262: dload           k
        //   264: dmul           
        //   265: dsub           
        //   266: dmul           
        //   267: iconst_m1      
        //   268: i2d            
        //   269: invokestatic    java/lang/Math.max:(DD)D
        //   272: dconst_1       
        //   273: invokestatic    java/lang/Math.min:(DD)D
        //   276: dneg           
        //   277: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   280: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   283: aastore        
        //   284: dup            
        //   285: iconst_1       
        //   286: aload           beta
        //   288: aastore        
        //   289: dup            
        //   290: iconst_2       
        //   291: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   294: iconst_2       
        //   295: i2d            
        //   296: dload           j
        //   298: dload           k
        //   300: dmul           
        //   301: dload_2         /* r */
        //   302: dload           i
        //   304: dmul           
        //   305: dsub           
        //   306: dmul           
        //   307: iconst_m1      
        //   308: i2d            
        //   309: invokestatic    java/lang/Math.max:(DD)D
        //   312: dconst_1       
        //   313: invokestatic    java/lang/Math.min:(DD)D
        //   316: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   319: iconst_2       
        //   320: i2d            
        //   321: dload           i
        //   323: dload           j
        //   325: dmul           
        //   326: dload_2         /* r */
        //   327: dload           k
        //   329: dmul           
        //   330: dadd           
        //   331: dmul           
        //   332: iconst_m1      
        //   333: i2d            
        //   334: invokestatic    java/lang/Math.max:(DD)D
        //   337: dconst_1       
        //   338: invokestatic    java/lang/Math.min:(DD)D
        //   341: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   344: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   347: aastore        
        //   348: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   351: areturn        
        //   352: new             Lgnu/mapping/WrongType;
        //   355: dup_x1         
        //   356: swap           
        //   357: ldc             "r"
        //   359: bipush          -2
        //   361: aload           4
        //   363: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   366: athrow         
        //   367: new             Lgnu/mapping/WrongType;
        //   370: dup_x1         
        //   371: swap           
        //   372: ldc             "i"
        //   374: bipush          -2
        //   376: aload           6
        //   378: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   381: athrow         
        //   382: new             Lgnu/mapping/WrongType;
        //   385: dup_x1         
        //   386: swap           
        //   387: ldc             "j"
        //   389: bipush          -2
        //   391: aload           8
        //   393: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   396: athrow         
        //   397: new             Lgnu/mapping/WrongType;
        //   400: dup_x1         
        //   401: swap           
        //   402: ldc             "k"
        //   404: bipush          -2
        //   406: aload           10
        //   408: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   411: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  12     15     352    367    Ljava/lang/ClassCastException;
        //  23     26     367    382    Ljava/lang/ClassCastException;
        //  35     38     382    397    Ljava/lang/ClassCastException;
        //  47     50     397    412    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 236 out of bounds for length 236
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
    
    public static Object intrinsicZxz(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: astore_1        /* uq */
        //     5: aload_1         /* uq */
        //     6: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     9: dup            
        //    10: astore          4
        //    12: invokevirtual   java/lang/Number.doubleValue:()D
        //    15: dstore_2        /* r */
        //    16: aload_1         /* uq */
        //    17: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    20: dup            
        //    21: astore          6
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: dstore          i
        //    28: aload_1         /* uq */
        //    29: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    32: dup            
        //    33: astore          8
        //    35: invokevirtual   java/lang/Number.doubleValue:()D
        //    38: dstore          j
        //    40: aload_1         /* uq */
        //    41: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    44: dup            
        //    45: astore          10
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore          k
        //    52: dload_2         /* r */
        //    53: dload_2         /* r */
        //    54: dmul           
        //    55: dload           k
        //    57: dload           k
        //    59: dmul           
        //    60: dadd           
        //    61: dload           i
        //    63: dload           i
        //    65: dmul           
        //    66: dload           j
        //    68: dload           j
        //    70: dmul           
        //    71: dadd           
        //    72: dsub           
        //    73: iconst_m1      
        //    74: i2d            
        //    75: invokestatic    java/lang/Math.max:(DD)D
        //    78: dconst_1       
        //    79: invokestatic    java/lang/Math.min:(DD)D
        //    82: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    85: invokestatic    kawa/lib/numbers.acos:(Ljava/lang/Number;)Ljava/lang/Number;
        //    88: astore          beta
        //    90: aload           beta
        //    92: getstatic       kawa/lib/kawa/rotations.Lit4:Ljava/lang/Double;
        //    95: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    98: istore          x
        //   100: iload           x
        //   102: ifeq            113
        //   105: iload           x
        //   107: ifeq            220
        //   110: goto            131
        //   113: aload           beta
        //   115: getstatic       java/lang/Math.PI:D
        //   118: ldc2_w          1.0E-12
        //   121: dsub           
        //   122: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   125: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   128: ifeq            220
        //   131: iconst_3       
        //   132: anewarray       Ljava/lang/Object;
        //   135: dup            
        //   136: iconst_0       
        //   137: getstatic       kawa/lib/kawa/rotations.Lit11:Lgnu/math/DFloNum;
        //   140: aastore        
        //   141: dup            
        //   142: iconst_1       
        //   143: aload           beta
        //   145: aastore        
        //   146: dup            
        //   147: iconst_2       
        //   148: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   151: iconst_2       
        //   152: i2d            
        //   153: dload           i
        //   155: dload           j
        //   157: dmul           
        //   158: dload_2         /* r */
        //   159: dload           k
        //   161: dmul           
        //   162: dsub           
        //   163: dmul           
        //   164: iconst_m1      
        //   165: i2d            
        //   166: invokestatic    java/lang/Math.max:(DD)D
        //   169: dconst_1       
        //   170: invokestatic    java/lang/Math.min:(DD)D
        //   173: dneg           
        //   174: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   177: dload_2         /* r */
        //   178: dload_2         /* r */
        //   179: dmul           
        //   180: dload           i
        //   182: dload           i
        //   184: dmul           
        //   185: dadd           
        //   186: dload           j
        //   188: dload           j
        //   190: dmul           
        //   191: dload           k
        //   193: dload           k
        //   195: dmul           
        //   196: dadd           
        //   197: dsub           
        //   198: iconst_m1      
        //   199: i2d            
        //   200: invokestatic    java/lang/Math.max:(DD)D
        //   203: dconst_1       
        //   204: invokestatic    java/lang/Math.min:(DD)D
        //   207: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   210: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   213: aastore        
        //   214: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   217: goto            351
        //   220: iconst_3       
        //   221: anewarray       Ljava/lang/Object;
        //   224: dup            
        //   225: iconst_0       
        //   226: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   229: iconst_2       
        //   230: i2d            
        //   231: dload           i
        //   233: dload           k
        //   235: dmul           
        //   236: dload_2         /* r */
        //   237: dload           j
        //   239: dmul           
        //   240: dadd           
        //   241: dmul           
        //   242: iconst_m1      
        //   243: i2d            
        //   244: invokestatic    java/lang/Math.max:(DD)D
        //   247: dconst_1       
        //   248: invokestatic    java/lang/Math.min:(DD)D
        //   251: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   254: iconst_2       
        //   255: i2d            
        //   256: dload           j
        //   258: dload           k
        //   260: dmul           
        //   261: dload_2         /* r */
        //   262: dload           i
        //   264: dmul           
        //   265: dsub           
        //   266: dmul           
        //   267: iconst_m1      
        //   268: i2d            
        //   269: invokestatic    java/lang/Math.max:(DD)D
        //   272: dconst_1       
        //   273: invokestatic    java/lang/Math.min:(DD)D
        //   276: dneg           
        //   277: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   280: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   283: aastore        
        //   284: dup            
        //   285: iconst_1       
        //   286: aload           beta
        //   288: aastore        
        //   289: dup            
        //   290: iconst_2       
        //   291: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   294: iconst_2       
        //   295: i2d            
        //   296: dload           i
        //   298: dload           k
        //   300: dmul           
        //   301: dload_2         /* r */
        //   302: dload           j
        //   304: dmul           
        //   305: dsub           
        //   306: dmul           
        //   307: iconst_m1      
        //   308: i2d            
        //   309: invokestatic    java/lang/Math.max:(DD)D
        //   312: dconst_1       
        //   313: invokestatic    java/lang/Math.min:(DD)D
        //   316: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   319: iconst_2       
        //   320: i2d            
        //   321: dload_2         /* r */
        //   322: dload           i
        //   324: dmul           
        //   325: dload           j
        //   327: dload           k
        //   329: dmul           
        //   330: dadd           
        //   331: dmul           
        //   332: iconst_m1      
        //   333: i2d            
        //   334: invokestatic    java/lang/Math.max:(DD)D
        //   337: dconst_1       
        //   338: invokestatic    java/lang/Math.min:(DD)D
        //   341: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   344: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   347: aastore        
        //   348: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   351: areturn        
        //   352: new             Lgnu/mapping/WrongType;
        //   355: dup_x1         
        //   356: swap           
        //   357: ldc             "r"
        //   359: bipush          -2
        //   361: aload           4
        //   363: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   366: athrow         
        //   367: new             Lgnu/mapping/WrongType;
        //   370: dup_x1         
        //   371: swap           
        //   372: ldc             "i"
        //   374: bipush          -2
        //   376: aload           6
        //   378: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   381: athrow         
        //   382: new             Lgnu/mapping/WrongType;
        //   385: dup_x1         
        //   386: swap           
        //   387: ldc             "j"
        //   389: bipush          -2
        //   391: aload           8
        //   393: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   396: athrow         
        //   397: new             Lgnu/mapping/WrongType;
        //   400: dup_x1         
        //   401: swap           
        //   402: ldc             "k"
        //   404: bipush          -2
        //   406: aload           10
        //   408: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   411: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  12     15     352    367    Ljava/lang/ClassCastException;
        //  23     26     367    382    Ljava/lang/ClassCastException;
        //  35     38     382    397    Ljava/lang/ClassCastException;
        //  47     50     397    412    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 236 out of bounds for length 236
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
    
    public static Object intrinsicZyz(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: astore_1        /* uq */
        //     5: aload_1         /* uq */
        //     6: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     9: dup            
        //    10: astore          4
        //    12: invokevirtual   java/lang/Number.doubleValue:()D
        //    15: dstore_2        /* r */
        //    16: aload_1         /* uq */
        //    17: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    20: dup            
        //    21: astore          6
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: dstore          i
        //    28: aload_1         /* uq */
        //    29: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    32: dup            
        //    33: astore          8
        //    35: invokevirtual   java/lang/Number.doubleValue:()D
        //    38: dstore          j
        //    40: aload_1         /* uq */
        //    41: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    44: dup            
        //    45: astore          10
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore          k
        //    52: dload_2         /* r */
        //    53: dload_2         /* r */
        //    54: dmul           
        //    55: dload           k
        //    57: dload           k
        //    59: dmul           
        //    60: dadd           
        //    61: dload           i
        //    63: dload           i
        //    65: dmul           
        //    66: dload           j
        //    68: dload           j
        //    70: dmul           
        //    71: dadd           
        //    72: dsub           
        //    73: iconst_m1      
        //    74: i2d            
        //    75: invokestatic    java/lang/Math.max:(DD)D
        //    78: dconst_1       
        //    79: invokestatic    java/lang/Math.min:(DD)D
        //    82: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    85: invokestatic    kawa/lib/numbers.acos:(Ljava/lang/Number;)Ljava/lang/Number;
        //    88: astore          beta
        //    90: aload           beta
        //    92: getstatic       kawa/lib/kawa/rotations.Lit4:Ljava/lang/Double;
        //    95: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    98: istore          x
        //   100: iload           x
        //   102: ifeq            113
        //   105: iload           x
        //   107: ifeq            219
        //   110: goto            131
        //   113: aload           beta
        //   115: getstatic       java/lang/Math.PI:D
        //   118: ldc2_w          1.0E-12
        //   121: dsub           
        //   122: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   125: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   128: ifeq            219
        //   131: iconst_3       
        //   132: anewarray       Ljava/lang/Object;
        //   135: dup            
        //   136: iconst_0       
        //   137: getstatic       kawa/lib/kawa/rotations.Lit11:Lgnu/math/DFloNum;
        //   140: aastore        
        //   141: dup            
        //   142: iconst_1       
        //   143: aload           beta
        //   145: aastore        
        //   146: dup            
        //   147: iconst_2       
        //   148: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   151: iconst_2       
        //   152: i2d            
        //   153: dload           i
        //   155: dload           j
        //   157: dmul           
        //   158: dload_2         /* r */
        //   159: dload           k
        //   161: dmul           
        //   162: dadd           
        //   163: dmul           
        //   164: iconst_m1      
        //   165: i2d            
        //   166: invokestatic    java/lang/Math.max:(DD)D
        //   169: dconst_1       
        //   170: invokestatic    java/lang/Math.min:(DD)D
        //   173: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   176: dload_2         /* r */
        //   177: dload_2         /* r */
        //   178: dmul           
        //   179: dload           j
        //   181: dload           j
        //   183: dmul           
        //   184: dadd           
        //   185: dload           i
        //   187: dload           i
        //   189: dmul           
        //   190: dload           k
        //   192: dload           k
        //   194: dmul           
        //   195: dadd           
        //   196: dsub           
        //   197: iconst_m1      
        //   198: i2d            
        //   199: invokestatic    java/lang/Math.max:(DD)D
        //   202: dconst_1       
        //   203: invokestatic    java/lang/Math.min:(DD)D
        //   206: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   209: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   212: aastore        
        //   213: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   216: goto            350
        //   219: iconst_3       
        //   220: anewarray       Ljava/lang/Object;
        //   223: dup            
        //   224: iconst_0       
        //   225: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   228: iconst_2       
        //   229: i2d            
        //   230: dload           j
        //   232: dload           k
        //   234: dmul           
        //   235: dload_2         /* r */
        //   236: dload           i
        //   238: dmul           
        //   239: dsub           
        //   240: dmul           
        //   241: iconst_m1      
        //   242: i2d            
        //   243: invokestatic    java/lang/Math.max:(DD)D
        //   246: dconst_1       
        //   247: invokestatic    java/lang/Math.min:(DD)D
        //   250: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   253: iconst_2       
        //   254: i2d            
        //   255: dload           i
        //   257: dload           k
        //   259: dmul           
        //   260: dload_2         /* r */
        //   261: dload           j
        //   263: dmul           
        //   264: dadd           
        //   265: dmul           
        //   266: iconst_m1      
        //   267: i2d            
        //   268: invokestatic    java/lang/Math.max:(DD)D
        //   271: dconst_1       
        //   272: invokestatic    java/lang/Math.min:(DD)D
        //   275: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   278: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   281: aastore        
        //   282: dup            
        //   283: iconst_1       
        //   284: aload           beta
        //   286: aastore        
        //   287: dup            
        //   288: iconst_2       
        //   289: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   292: iconst_2       
        //   293: i2d            
        //   294: dload_2         /* r */
        //   295: dload           i
        //   297: dmul           
        //   298: dload           j
        //   300: dload           k
        //   302: dmul           
        //   303: dadd           
        //   304: dmul           
        //   305: iconst_m1      
        //   306: i2d            
        //   307: invokestatic    java/lang/Math.max:(DD)D
        //   310: dconst_1       
        //   311: invokestatic    java/lang/Math.min:(DD)D
        //   314: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   317: iconst_2       
        //   318: i2d            
        //   319: dload           i
        //   321: dload           k
        //   323: dmul           
        //   324: dload_2         /* r */
        //   325: dload           j
        //   327: dmul           
        //   328: dsub           
        //   329: dmul           
        //   330: iconst_m1      
        //   331: i2d            
        //   332: invokestatic    java/lang/Math.max:(DD)D
        //   335: dconst_1       
        //   336: invokestatic    java/lang/Math.min:(DD)D
        //   339: dneg           
        //   340: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   343: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   346: aastore        
        //   347: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   350: areturn        
        //   351: new             Lgnu/mapping/WrongType;
        //   354: dup_x1         
        //   355: swap           
        //   356: ldc             "r"
        //   358: bipush          -2
        //   360: aload           4
        //   362: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   365: athrow         
        //   366: new             Lgnu/mapping/WrongType;
        //   369: dup_x1         
        //   370: swap           
        //   371: ldc             "i"
        //   373: bipush          -2
        //   375: aload           6
        //   377: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   380: athrow         
        //   381: new             Lgnu/mapping/WrongType;
        //   384: dup_x1         
        //   385: swap           
        //   386: ldc             "j"
        //   388: bipush          -2
        //   390: aload           8
        //   392: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   395: athrow         
        //   396: new             Lgnu/mapping/WrongType;
        //   399: dup_x1         
        //   400: swap           
        //   401: ldc             "k"
        //   403: bipush          -2
        //   405: aload           10
        //   407: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   410: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  12     15     351    366    Ljava/lang/ClassCastException;
        //  23     26     366    381    Ljava/lang/ClassCastException;
        //  35     38     381    396    Ljava/lang/ClassCastException;
        //  47     50     396    411    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 235 out of bounds for length 235
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
    
    public static Object intrinsicXyz(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: astore_1        /* uq */
        //     5: aload_1         /* uq */
        //     6: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     9: dup            
        //    10: astore          4
        //    12: invokevirtual   java/lang/Number.doubleValue:()D
        //    15: dstore_2        /* r */
        //    16: aload_1         /* uq */
        //    17: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    20: dup            
        //    21: astore          6
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: dstore          i
        //    28: aload_1         /* uq */
        //    29: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    32: dup            
        //    33: astore          8
        //    35: invokevirtual   java/lang/Number.doubleValue:()D
        //    38: dstore          j
        //    40: aload_1         /* uq */
        //    41: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    44: dup            
        //    45: astore          10
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore          k
        //    52: iconst_2       
        //    53: i2d            
        //    54: dload           i
        //    56: dload           k
        //    58: dmul           
        //    59: dload_2         /* r */
        //    60: dload           j
        //    62: dmul           
        //    63: dadd           
        //    64: dmul           
        //    65: iconst_m1      
        //    66: i2d            
        //    67: invokestatic    java/lang/Math.max:(DD)D
        //    70: dconst_1       
        //    71: invokestatic    java/lang/Math.min:(DD)D
        //    74: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    77: invokestatic    kawa/lib/numbers.asin:(Ljava/lang/Number;)Ljava/lang/Number;
        //    80: astore          beta
        //    82: aload           beta
        //    84: invokestatic    kawa/lib/numbers.abs:(Ljava/lang/Number;)Ljava/lang/Number;
        //    87: getstatic       java/lang/Math.PI:D
        //    90: iconst_2       
        //    91: i2d            
        //    92: ddiv           
        //    93: ldc2_w          1.0E-12
        //    96: dsub           
        //    97: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   100: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   103: ifeq            194
        //   106: iconst_3       
        //   107: anewarray       Ljava/lang/Object;
        //   110: dup            
        //   111: iconst_0       
        //   112: getstatic       kawa/lib/kawa/rotations.Lit11:Lgnu/math/DFloNum;
        //   115: aastore        
        //   116: dup            
        //   117: iconst_1       
        //   118: aload           beta
        //   120: aastore        
        //   121: dup            
        //   122: iconst_2       
        //   123: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   126: iconst_2       
        //   127: i2d            
        //   128: dload           i
        //   130: dload           j
        //   132: dmul           
        //   133: dload_2         /* r */
        //   134: dload           k
        //   136: dmul           
        //   137: dadd           
        //   138: dmul           
        //   139: iconst_m1      
        //   140: i2d            
        //   141: invokestatic    java/lang/Math.max:(DD)D
        //   144: dconst_1       
        //   145: invokestatic    java/lang/Math.min:(DD)D
        //   148: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   151: dload_2         /* r */
        //   152: dload_2         /* r */
        //   153: dmul           
        //   154: dload           j
        //   156: dload           j
        //   158: dmul           
        //   159: dadd           
        //   160: dload           i
        //   162: dload           i
        //   164: dmul           
        //   165: dload           k
        //   167: dload           k
        //   169: dmul           
        //   170: dadd           
        //   171: dsub           
        //   172: iconst_m1      
        //   173: i2d            
        //   174: invokestatic    java/lang/Math.max:(DD)D
        //   177: dconst_1       
        //   178: invokestatic    java/lang/Math.min:(DD)D
        //   181: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   184: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   187: aastore        
        //   188: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   191: goto            342
        //   194: iconst_3       
        //   195: anewarray       Ljava/lang/Object;
        //   198: dup            
        //   199: iconst_0       
        //   200: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   203: iconst_2       
        //   204: i2d            
        //   205: dload           j
        //   207: dload           k
        //   209: dmul           
        //   210: dload_2         /* r */
        //   211: dload           i
        //   213: dmul           
        //   214: dsub           
        //   215: dmul           
        //   216: iconst_m1      
        //   217: i2d            
        //   218: invokestatic    java/lang/Math.max:(DD)D
        //   221: dconst_1       
        //   222: invokestatic    java/lang/Math.min:(DD)D
        //   225: dneg           
        //   226: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   229: dload_2         /* r */
        //   230: dload_2         /* r */
        //   231: dmul           
        //   232: dload           k
        //   234: dload           k
        //   236: dmul           
        //   237: dadd           
        //   238: dload           i
        //   240: dload           i
        //   242: dmul           
        //   243: dload           j
        //   245: dload           j
        //   247: dmul           
        //   248: dadd           
        //   249: dsub           
        //   250: iconst_m1      
        //   251: i2d            
        //   252: invokestatic    java/lang/Math.max:(DD)D
        //   255: dconst_1       
        //   256: invokestatic    java/lang/Math.min:(DD)D
        //   259: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   262: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   265: aastore        
        //   266: dup            
        //   267: iconst_1       
        //   268: aload           beta
        //   270: aastore        
        //   271: dup            
        //   272: iconst_2       
        //   273: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   276: iconst_2       
        //   277: i2d            
        //   278: dload           i
        //   280: dload           j
        //   282: dmul           
        //   283: dload_2         /* r */
        //   284: dload           k
        //   286: dmul           
        //   287: dsub           
        //   288: dmul           
        //   289: iconst_m1      
        //   290: i2d            
        //   291: invokestatic    java/lang/Math.max:(DD)D
        //   294: dconst_1       
        //   295: invokestatic    java/lang/Math.min:(DD)D
        //   298: dneg           
        //   299: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   302: dload_2         /* r */
        //   303: dload_2         /* r */
        //   304: dmul           
        //   305: dload           i
        //   307: dload           i
        //   309: dmul           
        //   310: dadd           
        //   311: dload           j
        //   313: dload           j
        //   315: dmul           
        //   316: dload           k
        //   318: dload           k
        //   320: dmul           
        //   321: dadd           
        //   322: dsub           
        //   323: iconst_m1      
        //   324: i2d            
        //   325: invokestatic    java/lang/Math.max:(DD)D
        //   328: dconst_1       
        //   329: invokestatic    java/lang/Math.min:(DD)D
        //   332: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   335: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   338: aastore        
        //   339: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   342: areturn        
        //   343: new             Lgnu/mapping/WrongType;
        //   346: dup_x1         
        //   347: swap           
        //   348: ldc             "r"
        //   350: bipush          -2
        //   352: aload           4
        //   354: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   357: athrow         
        //   358: new             Lgnu/mapping/WrongType;
        //   361: dup_x1         
        //   362: swap           
        //   363: ldc             "i"
        //   365: bipush          -2
        //   367: aload           6
        //   369: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   372: athrow         
        //   373: new             Lgnu/mapping/WrongType;
        //   376: dup_x1         
        //   377: swap           
        //   378: ldc             "j"
        //   380: bipush          -2
        //   382: aload           8
        //   384: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   387: athrow         
        //   388: new             Lgnu/mapping/WrongType;
        //   391: dup_x1         
        //   392: swap           
        //   393: ldc             "k"
        //   395: bipush          -2
        //   397: aload           10
        //   399: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   402: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  12     15     343    358    Ljava/lang/ClassCastException;
        //  23     26     358    373    Ljava/lang/ClassCastException;
        //  35     38     373    388    Ljava/lang/ClassCastException;
        //  47     50     388    403    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 236 out of bounds for length 236
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
    
    public static Object intrinsicXzy(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: astore_1        /* uq */
        //     5: aload_1         /* uq */
        //     6: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     9: dup            
        //    10: astore          4
        //    12: invokevirtual   java/lang/Number.doubleValue:()D
        //    15: dstore_2        /* r */
        //    16: aload_1         /* uq */
        //    17: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    20: dup            
        //    21: astore          6
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: dstore          i
        //    28: aload_1         /* uq */
        //    29: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    32: dup            
        //    33: astore          8
        //    35: invokevirtual   java/lang/Number.doubleValue:()D
        //    38: dstore          j
        //    40: aload_1         /* uq */
        //    41: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    44: dup            
        //    45: astore          10
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore          k
        //    52: iconst_2       
        //    53: i2d            
        //    54: dload           i
        //    56: dload           j
        //    58: dmul           
        //    59: dload_2         /* r */
        //    60: dload           k
        //    62: dmul           
        //    63: dsub           
        //    64: dmul           
        //    65: iconst_m1      
        //    66: i2d            
        //    67: invokestatic    java/lang/Math.max:(DD)D
        //    70: dconst_1       
        //    71: invokestatic    java/lang/Math.min:(DD)D
        //    74: dneg           
        //    75: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    78: invokestatic    kawa/lib/numbers.asin:(Ljava/lang/Number;)Ljava/lang/Number;
        //    81: astore          beta
        //    83: aload           beta
        //    85: invokestatic    kawa/lib/numbers.abs:(Ljava/lang/Number;)Ljava/lang/Number;
        //    88: getstatic       java/lang/Math.PI:D
        //    91: iconst_2       
        //    92: i2d            
        //    93: ddiv           
        //    94: ldc2_w          1.0E-12
        //    97: dsub           
        //    98: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   101: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   104: ifeq            196
        //   107: iconst_3       
        //   108: anewarray       Ljava/lang/Object;
        //   111: dup            
        //   112: iconst_0       
        //   113: getstatic       kawa/lib/kawa/rotations.Lit11:Lgnu/math/DFloNum;
        //   116: aastore        
        //   117: dup            
        //   118: iconst_1       
        //   119: aload           beta
        //   121: aastore        
        //   122: dup            
        //   123: iconst_2       
        //   124: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   127: iconst_2       
        //   128: i2d            
        //   129: dload           i
        //   131: dload           k
        //   133: dmul           
        //   134: dload_2         /* r */
        //   135: dload           j
        //   137: dmul           
        //   138: dsub           
        //   139: dmul           
        //   140: iconst_m1      
        //   141: i2d            
        //   142: invokestatic    java/lang/Math.max:(DD)D
        //   145: dconst_1       
        //   146: invokestatic    java/lang/Math.min:(DD)D
        //   149: dneg           
        //   150: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   153: dload_2         /* r */
        //   154: dload_2         /* r */
        //   155: dmul           
        //   156: dload           k
        //   158: dload           k
        //   160: dmul           
        //   161: dadd           
        //   162: dload           i
        //   164: dload           i
        //   166: dmul           
        //   167: dload           j
        //   169: dload           j
        //   171: dmul           
        //   172: dadd           
        //   173: dsub           
        //   174: iconst_m1      
        //   175: i2d            
        //   176: invokestatic    java/lang/Math.max:(DD)D
        //   179: dconst_1       
        //   180: invokestatic    java/lang/Math.min:(DD)D
        //   183: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   186: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   189: aastore        
        //   190: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   193: goto            342
        //   196: iconst_3       
        //   197: anewarray       Ljava/lang/Object;
        //   200: dup            
        //   201: iconst_0       
        //   202: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   205: iconst_2       
        //   206: i2d            
        //   207: dload_2         /* r */
        //   208: dload           i
        //   210: dmul           
        //   211: dload           j
        //   213: dload           k
        //   215: dmul           
        //   216: dadd           
        //   217: dmul           
        //   218: iconst_m1      
        //   219: i2d            
        //   220: invokestatic    java/lang/Math.max:(DD)D
        //   223: dconst_1       
        //   224: invokestatic    java/lang/Math.min:(DD)D
        //   227: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   230: dload_2         /* r */
        //   231: dload_2         /* r */
        //   232: dmul           
        //   233: dload           j
        //   235: dload           j
        //   237: dmul           
        //   238: dadd           
        //   239: dload           i
        //   241: dload           i
        //   243: dmul           
        //   244: dload           k
        //   246: dload           k
        //   248: dmul           
        //   249: dadd           
        //   250: dsub           
        //   251: iconst_m1      
        //   252: i2d            
        //   253: invokestatic    java/lang/Math.max:(DD)D
        //   256: dconst_1       
        //   257: invokestatic    java/lang/Math.min:(DD)D
        //   260: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   263: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   266: aastore        
        //   267: dup            
        //   268: iconst_1       
        //   269: aload           beta
        //   271: aastore        
        //   272: dup            
        //   273: iconst_2       
        //   274: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   277: iconst_2       
        //   278: i2d            
        //   279: dload           i
        //   281: dload           k
        //   283: dmul           
        //   284: dload_2         /* r */
        //   285: dload           j
        //   287: dmul           
        //   288: dadd           
        //   289: dmul           
        //   290: iconst_m1      
        //   291: i2d            
        //   292: invokestatic    java/lang/Math.max:(DD)D
        //   295: dconst_1       
        //   296: invokestatic    java/lang/Math.min:(DD)D
        //   299: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   302: dload_2         /* r */
        //   303: dload_2         /* r */
        //   304: dmul           
        //   305: dload           i
        //   307: dload           i
        //   309: dmul           
        //   310: dadd           
        //   311: dload           j
        //   313: dload           j
        //   315: dmul           
        //   316: dload           k
        //   318: dload           k
        //   320: dmul           
        //   321: dadd           
        //   322: dsub           
        //   323: iconst_m1      
        //   324: i2d            
        //   325: invokestatic    java/lang/Math.max:(DD)D
        //   328: dconst_1       
        //   329: invokestatic    java/lang/Math.min:(DD)D
        //   332: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   335: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   338: aastore        
        //   339: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   342: areturn        
        //   343: new             Lgnu/mapping/WrongType;
        //   346: dup_x1         
        //   347: swap           
        //   348: ldc             "r"
        //   350: bipush          -2
        //   352: aload           4
        //   354: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   357: athrow         
        //   358: new             Lgnu/mapping/WrongType;
        //   361: dup_x1         
        //   362: swap           
        //   363: ldc             "i"
        //   365: bipush          -2
        //   367: aload           6
        //   369: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   372: athrow         
        //   373: new             Lgnu/mapping/WrongType;
        //   376: dup_x1         
        //   377: swap           
        //   378: ldc             "j"
        //   380: bipush          -2
        //   382: aload           8
        //   384: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   387: athrow         
        //   388: new             Lgnu/mapping/WrongType;
        //   391: dup_x1         
        //   392: swap           
        //   393: ldc             "k"
        //   395: bipush          -2
        //   397: aload           10
        //   399: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   402: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  12     15     343    358    Ljava/lang/ClassCastException;
        //  23     26     358    373    Ljava/lang/ClassCastException;
        //  35     38     373    388    Ljava/lang/ClassCastException;
        //  47     50     388    403    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 236 out of bounds for length 236
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
    
    public static Object intrinsicYxz(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: astore_1        /* uq */
        //     5: aload_1         /* uq */
        //     6: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     9: dup            
        //    10: astore          4
        //    12: invokevirtual   java/lang/Number.doubleValue:()D
        //    15: dstore_2        /* r */
        //    16: aload_1         /* uq */
        //    17: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    20: dup            
        //    21: astore          6
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: dstore          i
        //    28: aload_1         /* uq */
        //    29: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    32: dup            
        //    33: astore          8
        //    35: invokevirtual   java/lang/Number.doubleValue:()D
        //    38: dstore          j
        //    40: aload_1         /* uq */
        //    41: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    44: dup            
        //    45: astore          10
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore          k
        //    52: iconst_2       
        //    53: i2d            
        //    54: dload           i
        //    56: dload           j
        //    58: dmul           
        //    59: dload_2         /* r */
        //    60: dload           k
        //    62: dmul           
        //    63: dsub           
        //    64: dmul           
        //    65: iconst_m1      
        //    66: i2d            
        //    67: invokestatic    java/lang/Math.max:(DD)D
        //    70: dconst_1       
        //    71: invokestatic    java/lang/Math.min:(DD)D
        //    74: dneg           
        //    75: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    78: invokestatic    kawa/lib/numbers.asin:(Ljava/lang/Number;)Ljava/lang/Number;
        //    81: astore          beta
        //    83: aload           beta
        //    85: invokestatic    kawa/lib/numbers.abs:(Ljava/lang/Number;)Ljava/lang/Number;
        //    88: getstatic       java/lang/Math.PI:D
        //    91: iconst_2       
        //    92: i2d            
        //    93: ddiv           
        //    94: ldc2_w          1.0E-12
        //    97: dsub           
        //    98: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   101: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   104: ifeq            196
        //   107: iconst_3       
        //   108: anewarray       Ljava/lang/Object;
        //   111: dup            
        //   112: iconst_0       
        //   113: getstatic       kawa/lib/kawa/rotations.Lit11:Lgnu/math/DFloNum;
        //   116: aastore        
        //   117: dup            
        //   118: iconst_1       
        //   119: aload           beta
        //   121: aastore        
        //   122: dup            
        //   123: iconst_2       
        //   124: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   127: iconst_2       
        //   128: i2d            
        //   129: dload           i
        //   131: dload           j
        //   133: dmul           
        //   134: dload_2         /* r */
        //   135: dload           k
        //   137: dmul           
        //   138: dsub           
        //   139: dmul           
        //   140: iconst_m1      
        //   141: i2d            
        //   142: invokestatic    java/lang/Math.max:(DD)D
        //   145: dconst_1       
        //   146: invokestatic    java/lang/Math.min:(DD)D
        //   149: dneg           
        //   150: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   153: dload_2         /* r */
        //   154: dload_2         /* r */
        //   155: dmul           
        //   156: dload           i
        //   158: dload           i
        //   160: dmul           
        //   161: dadd           
        //   162: dload           j
        //   164: dload           j
        //   166: dmul           
        //   167: dload           k
        //   169: dload           k
        //   171: dmul           
        //   172: dadd           
        //   173: dsub           
        //   174: iconst_m1      
        //   175: i2d            
        //   176: invokestatic    java/lang/Math.max:(DD)D
        //   179: dconst_1       
        //   180: invokestatic    java/lang/Math.min:(DD)D
        //   183: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   186: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   189: aastore        
        //   190: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   193: goto            342
        //   196: iconst_3       
        //   197: anewarray       Ljava/lang/Object;
        //   200: dup            
        //   201: iconst_0       
        //   202: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   205: iconst_2       
        //   206: i2d            
        //   207: dload           i
        //   209: dload           k
        //   211: dmul           
        //   212: dload_2         /* r */
        //   213: dload           j
        //   215: dmul           
        //   216: dadd           
        //   217: dmul           
        //   218: iconst_m1      
        //   219: i2d            
        //   220: invokestatic    java/lang/Math.max:(DD)D
        //   223: dconst_1       
        //   224: invokestatic    java/lang/Math.min:(DD)D
        //   227: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   230: dload_2         /* r */
        //   231: dload_2         /* r */
        //   232: dmul           
        //   233: dload           k
        //   235: dload           k
        //   237: dmul           
        //   238: dadd           
        //   239: dload           i
        //   241: dload           i
        //   243: dmul           
        //   244: dload           j
        //   246: dload           j
        //   248: dmul           
        //   249: dadd           
        //   250: dsub           
        //   251: iconst_m1      
        //   252: i2d            
        //   253: invokestatic    java/lang/Math.max:(DD)D
        //   256: dconst_1       
        //   257: invokestatic    java/lang/Math.min:(DD)D
        //   260: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   263: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   266: aastore        
        //   267: dup            
        //   268: iconst_1       
        //   269: aload           beta
        //   271: aastore        
        //   272: dup            
        //   273: iconst_2       
        //   274: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   277: iconst_2       
        //   278: i2d            
        //   279: dload           i
        //   281: dload           j
        //   283: dmul           
        //   284: dload_2         /* r */
        //   285: dload           k
        //   287: dmul           
        //   288: dadd           
        //   289: dmul           
        //   290: iconst_m1      
        //   291: i2d            
        //   292: invokestatic    java/lang/Math.max:(DD)D
        //   295: dconst_1       
        //   296: invokestatic    java/lang/Math.min:(DD)D
        //   299: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   302: dload_2         /* r */
        //   303: dload_2         /* r */
        //   304: dmul           
        //   305: dload           j
        //   307: dload           j
        //   309: dmul           
        //   310: dadd           
        //   311: dload           i
        //   313: dload           i
        //   315: dmul           
        //   316: dload           k
        //   318: dload           k
        //   320: dmul           
        //   321: dadd           
        //   322: dsub           
        //   323: iconst_m1      
        //   324: i2d            
        //   325: invokestatic    java/lang/Math.max:(DD)D
        //   328: dconst_1       
        //   329: invokestatic    java/lang/Math.min:(DD)D
        //   332: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   335: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   338: aastore        
        //   339: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   342: areturn        
        //   343: new             Lgnu/mapping/WrongType;
        //   346: dup_x1         
        //   347: swap           
        //   348: ldc             "r"
        //   350: bipush          -2
        //   352: aload           4
        //   354: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   357: athrow         
        //   358: new             Lgnu/mapping/WrongType;
        //   361: dup_x1         
        //   362: swap           
        //   363: ldc             "i"
        //   365: bipush          -2
        //   367: aload           6
        //   369: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   372: athrow         
        //   373: new             Lgnu/mapping/WrongType;
        //   376: dup_x1         
        //   377: swap           
        //   378: ldc             "j"
        //   380: bipush          -2
        //   382: aload           8
        //   384: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   387: athrow         
        //   388: new             Lgnu/mapping/WrongType;
        //   391: dup_x1         
        //   392: swap           
        //   393: ldc             "k"
        //   395: bipush          -2
        //   397: aload           10
        //   399: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   402: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  12     15     343    358    Ljava/lang/ClassCastException;
        //  23     26     358    373    Ljava/lang/ClassCastException;
        //  35     38     373    388    Ljava/lang/ClassCastException;
        //  47     50     388    403    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 236 out of bounds for length 236
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
    
    public static Object intrinsicYzx(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: astore_1        /* uq */
        //     5: aload_1         /* uq */
        //     6: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     9: dup            
        //    10: astore          4
        //    12: invokevirtual   java/lang/Number.doubleValue:()D
        //    15: dstore_2        /* r */
        //    16: aload_1         /* uq */
        //    17: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    20: dup            
        //    21: astore          6
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: dstore          i
        //    28: aload_1         /* uq */
        //    29: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    32: dup            
        //    33: astore          8
        //    35: invokevirtual   java/lang/Number.doubleValue:()D
        //    38: dstore          j
        //    40: aload_1         /* uq */
        //    41: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    44: dup            
        //    45: astore          10
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore          k
        //    52: iconst_2       
        //    53: i2d            
        //    54: dload           i
        //    56: dload           j
        //    58: dmul           
        //    59: dload_2         /* r */
        //    60: dload           k
        //    62: dmul           
        //    63: dadd           
        //    64: dmul           
        //    65: iconst_m1      
        //    66: i2d            
        //    67: invokestatic    java/lang/Math.max:(DD)D
        //    70: dconst_1       
        //    71: invokestatic    java/lang/Math.min:(DD)D
        //    74: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    77: invokestatic    kawa/lib/numbers.asin:(Ljava/lang/Number;)Ljava/lang/Number;
        //    80: astore          beta
        //    82: aload           beta
        //    84: invokestatic    kawa/lib/numbers.abs:(Ljava/lang/Number;)Ljava/lang/Number;
        //    87: getstatic       java/lang/Math.PI:D
        //    90: iconst_2       
        //    91: i2d            
        //    92: ddiv           
        //    93: ldc2_w          1.0E-12
        //    96: dsub           
        //    97: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   100: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   103: ifeq            194
        //   106: iconst_3       
        //   107: anewarray       Ljava/lang/Object;
        //   110: dup            
        //   111: iconst_0       
        //   112: getstatic       kawa/lib/kawa/rotations.Lit11:Lgnu/math/DFloNum;
        //   115: aastore        
        //   116: dup            
        //   117: iconst_1       
        //   118: aload           beta
        //   120: aastore        
        //   121: dup            
        //   122: iconst_2       
        //   123: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   126: iconst_2       
        //   127: i2d            
        //   128: dload_2         /* r */
        //   129: dload           i
        //   131: dmul           
        //   132: dload           j
        //   134: dload           k
        //   136: dmul           
        //   137: dadd           
        //   138: dmul           
        //   139: iconst_m1      
        //   140: i2d            
        //   141: invokestatic    java/lang/Math.max:(DD)D
        //   144: dconst_1       
        //   145: invokestatic    java/lang/Math.min:(DD)D
        //   148: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   151: dload_2         /* r */
        //   152: dload_2         /* r */
        //   153: dmul           
        //   154: dload           k
        //   156: dload           k
        //   158: dmul           
        //   159: dadd           
        //   160: dload           i
        //   162: dload           i
        //   164: dmul           
        //   165: dload           j
        //   167: dload           j
        //   169: dmul           
        //   170: dadd           
        //   171: dsub           
        //   172: iconst_m1      
        //   173: i2d            
        //   174: invokestatic    java/lang/Math.max:(DD)D
        //   177: dconst_1       
        //   178: invokestatic    java/lang/Math.min:(DD)D
        //   181: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   184: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   187: aastore        
        //   188: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   191: goto            342
        //   194: iconst_3       
        //   195: anewarray       Ljava/lang/Object;
        //   198: dup            
        //   199: iconst_0       
        //   200: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   203: iconst_2       
        //   204: i2d            
        //   205: dload           i
        //   207: dload           k
        //   209: dmul           
        //   210: dload_2         /* r */
        //   211: dload           j
        //   213: dmul           
        //   214: dsub           
        //   215: dmul           
        //   216: iconst_m1      
        //   217: i2d            
        //   218: invokestatic    java/lang/Math.max:(DD)D
        //   221: dconst_1       
        //   222: invokestatic    java/lang/Math.min:(DD)D
        //   225: dneg           
        //   226: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   229: dload_2         /* r */
        //   230: dload_2         /* r */
        //   231: dmul           
        //   232: dload           i
        //   234: dload           i
        //   236: dmul           
        //   237: dadd           
        //   238: dload           j
        //   240: dload           j
        //   242: dmul           
        //   243: dload           k
        //   245: dload           k
        //   247: dmul           
        //   248: dadd           
        //   249: dsub           
        //   250: iconst_m1      
        //   251: i2d            
        //   252: invokestatic    java/lang/Math.max:(DD)D
        //   255: dconst_1       
        //   256: invokestatic    java/lang/Math.min:(DD)D
        //   259: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   262: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   265: aastore        
        //   266: dup            
        //   267: iconst_1       
        //   268: aload           beta
        //   270: aastore        
        //   271: dup            
        //   272: iconst_2       
        //   273: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   276: iconst_2       
        //   277: i2d            
        //   278: dload           j
        //   280: dload           k
        //   282: dmul           
        //   283: dload_2         /* r */
        //   284: dload           i
        //   286: dmul           
        //   287: dsub           
        //   288: dmul           
        //   289: iconst_m1      
        //   290: i2d            
        //   291: invokestatic    java/lang/Math.max:(DD)D
        //   294: dconst_1       
        //   295: invokestatic    java/lang/Math.min:(DD)D
        //   298: dneg           
        //   299: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   302: dload_2         /* r */
        //   303: dload_2         /* r */
        //   304: dmul           
        //   305: dload           j
        //   307: dload           j
        //   309: dmul           
        //   310: dadd           
        //   311: dload           i
        //   313: dload           i
        //   315: dmul           
        //   316: dload           k
        //   318: dload           k
        //   320: dmul           
        //   321: dadd           
        //   322: dsub           
        //   323: iconst_m1      
        //   324: i2d            
        //   325: invokestatic    java/lang/Math.max:(DD)D
        //   328: dconst_1       
        //   329: invokestatic    java/lang/Math.min:(DD)D
        //   332: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   335: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   338: aastore        
        //   339: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   342: areturn        
        //   343: new             Lgnu/mapping/WrongType;
        //   346: dup_x1         
        //   347: swap           
        //   348: ldc             "r"
        //   350: bipush          -2
        //   352: aload           4
        //   354: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   357: athrow         
        //   358: new             Lgnu/mapping/WrongType;
        //   361: dup_x1         
        //   362: swap           
        //   363: ldc             "i"
        //   365: bipush          -2
        //   367: aload           6
        //   369: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   372: athrow         
        //   373: new             Lgnu/mapping/WrongType;
        //   376: dup_x1         
        //   377: swap           
        //   378: ldc             "j"
        //   380: bipush          -2
        //   382: aload           8
        //   384: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   387: athrow         
        //   388: new             Lgnu/mapping/WrongType;
        //   391: dup_x1         
        //   392: swap           
        //   393: ldc             "k"
        //   395: bipush          -2
        //   397: aload           10
        //   399: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   402: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  12     15     343    358    Ljava/lang/ClassCastException;
        //  23     26     358    373    Ljava/lang/ClassCastException;
        //  35     38     373    388    Ljava/lang/ClassCastException;
        //  47     50     388    403    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 236 out of bounds for length 236
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
    
    public static Object intrinsicZxy(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: astore_1        /* uq */
        //     5: aload_1         /* uq */
        //     6: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     9: dup            
        //    10: astore          4
        //    12: invokevirtual   java/lang/Number.doubleValue:()D
        //    15: dstore_2        /* r */
        //    16: aload_1         /* uq */
        //    17: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    20: dup            
        //    21: astore          6
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: dstore          i
        //    28: aload_1         /* uq */
        //    29: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    32: dup            
        //    33: astore          8
        //    35: invokevirtual   java/lang/Number.doubleValue:()D
        //    38: dstore          j
        //    40: aload_1         /* uq */
        //    41: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    44: dup            
        //    45: astore          10
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore          k
        //    52: iconst_2       
        //    53: i2d            
        //    54: dload_2         /* r */
        //    55: dload           i
        //    57: dmul           
        //    58: dload           j
        //    60: dload           k
        //    62: dmul           
        //    63: dadd           
        //    64: dmul           
        //    65: iconst_m1      
        //    66: i2d            
        //    67: invokestatic    java/lang/Math.max:(DD)D
        //    70: dconst_1       
        //    71: invokestatic    java/lang/Math.min:(DD)D
        //    74: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    77: invokestatic    kawa/lib/numbers.asin:(Ljava/lang/Number;)Ljava/lang/Number;
        //    80: astore          beta
        //    82: aload           beta
        //    84: invokestatic    kawa/lib/numbers.abs:(Ljava/lang/Number;)Ljava/lang/Number;
        //    87: getstatic       java/lang/Math.PI:D
        //    90: iconst_2       
        //    91: i2d            
        //    92: ddiv           
        //    93: ldc2_w          1.0E-12
        //    96: dsub           
        //    97: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   100: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   103: ifeq            194
        //   106: iconst_3       
        //   107: anewarray       Ljava/lang/Object;
        //   110: dup            
        //   111: iconst_0       
        //   112: getstatic       kawa/lib/kawa/rotations.Lit11:Lgnu/math/DFloNum;
        //   115: aastore        
        //   116: dup            
        //   117: iconst_1       
        //   118: aload           beta
        //   120: aastore        
        //   121: dup            
        //   122: iconst_2       
        //   123: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   126: iconst_2       
        //   127: i2d            
        //   128: dload           i
        //   130: dload           k
        //   132: dmul           
        //   133: dload_2         /* r */
        //   134: dload           j
        //   136: dmul           
        //   137: dadd           
        //   138: dmul           
        //   139: iconst_m1      
        //   140: i2d            
        //   141: invokestatic    java/lang/Math.max:(DD)D
        //   144: dconst_1       
        //   145: invokestatic    java/lang/Math.min:(DD)D
        //   148: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   151: dload_2         /* r */
        //   152: dload_2         /* r */
        //   153: dmul           
        //   154: dload           i
        //   156: dload           i
        //   158: dmul           
        //   159: dadd           
        //   160: dload           j
        //   162: dload           j
        //   164: dmul           
        //   165: dload           k
        //   167: dload           k
        //   169: dmul           
        //   170: dadd           
        //   171: dsub           
        //   172: iconst_m1      
        //   173: i2d            
        //   174: invokestatic    java/lang/Math.max:(DD)D
        //   177: dconst_1       
        //   178: invokestatic    java/lang/Math.min:(DD)D
        //   181: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   184: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   187: aastore        
        //   188: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   191: goto            342
        //   194: iconst_3       
        //   195: anewarray       Ljava/lang/Object;
        //   198: dup            
        //   199: iconst_0       
        //   200: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   203: iconst_2       
        //   204: i2d            
        //   205: dload           i
        //   207: dload           j
        //   209: dmul           
        //   210: dload_2         /* r */
        //   211: dload           k
        //   213: dmul           
        //   214: dsub           
        //   215: dmul           
        //   216: iconst_m1      
        //   217: i2d            
        //   218: invokestatic    java/lang/Math.max:(DD)D
        //   221: dconst_1       
        //   222: invokestatic    java/lang/Math.min:(DD)D
        //   225: dneg           
        //   226: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   229: dload_2         /* r */
        //   230: dload_2         /* r */
        //   231: dmul           
        //   232: dload           j
        //   234: dload           j
        //   236: dmul           
        //   237: dadd           
        //   238: dload           i
        //   240: dload           i
        //   242: dmul           
        //   243: dload           k
        //   245: dload           k
        //   247: dmul           
        //   248: dadd           
        //   249: dsub           
        //   250: iconst_m1      
        //   251: i2d            
        //   252: invokestatic    java/lang/Math.max:(DD)D
        //   255: dconst_1       
        //   256: invokestatic    java/lang/Math.min:(DD)D
        //   259: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   262: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   265: aastore        
        //   266: dup            
        //   267: iconst_1       
        //   268: aload           beta
        //   270: aastore        
        //   271: dup            
        //   272: iconst_2       
        //   273: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   276: iconst_2       
        //   277: i2d            
        //   278: dload           i
        //   280: dload           k
        //   282: dmul           
        //   283: dload_2         /* r */
        //   284: dload           j
        //   286: dmul           
        //   287: dsub           
        //   288: dmul           
        //   289: iconst_m1      
        //   290: i2d            
        //   291: invokestatic    java/lang/Math.max:(DD)D
        //   294: dconst_1       
        //   295: invokestatic    java/lang/Math.min:(DD)D
        //   298: dneg           
        //   299: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   302: dload_2         /* r */
        //   303: dload_2         /* r */
        //   304: dmul           
        //   305: dload           k
        //   307: dload           k
        //   309: dmul           
        //   310: dadd           
        //   311: dload           i
        //   313: dload           i
        //   315: dmul           
        //   316: dload           j
        //   318: dload           j
        //   320: dmul           
        //   321: dadd           
        //   322: dsub           
        //   323: iconst_m1      
        //   324: i2d            
        //   325: invokestatic    java/lang/Math.max:(DD)D
        //   328: dconst_1       
        //   329: invokestatic    java/lang/Math.min:(DD)D
        //   332: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   335: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   338: aastore        
        //   339: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   342: areturn        
        //   343: new             Lgnu/mapping/WrongType;
        //   346: dup_x1         
        //   347: swap           
        //   348: ldc             "r"
        //   350: bipush          -2
        //   352: aload           4
        //   354: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   357: athrow         
        //   358: new             Lgnu/mapping/WrongType;
        //   361: dup_x1         
        //   362: swap           
        //   363: ldc             "i"
        //   365: bipush          -2
        //   367: aload           6
        //   369: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   372: athrow         
        //   373: new             Lgnu/mapping/WrongType;
        //   376: dup_x1         
        //   377: swap           
        //   378: ldc             "j"
        //   380: bipush          -2
        //   382: aload           8
        //   384: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   387: athrow         
        //   388: new             Lgnu/mapping/WrongType;
        //   391: dup_x1         
        //   392: swap           
        //   393: ldc             "k"
        //   395: bipush          -2
        //   397: aload           10
        //   399: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   402: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  12     15     343    358    Ljava/lang/ClassCastException;
        //  23     26     358    373    Ljava/lang/ClassCastException;
        //  35     38     373    388    Ljava/lang/ClassCastException;
        //  47     50     388    403    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 236 out of bounds for length 236
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
    
    public static Object intrinsicZyx(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/quaternions.unitQuaternion:(Ljava/lang/Number;)Ljava/lang/Number;
        //     4: astore_1        /* uq */
        //     5: aload_1         /* uq */
        //     6: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //     9: dup            
        //    10: astore          4
        //    12: invokevirtual   java/lang/Number.doubleValue:()D
        //    15: dstore_2        /* r */
        //    16: aload_1         /* uq */
        //    17: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    20: dup            
        //    21: astore          6
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: dstore          i
        //    28: aload_1         /* uq */
        //    29: invokestatic    kawa/lib/numbers.jmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    32: dup            
        //    33: astore          8
        //    35: invokevirtual   java/lang/Number.doubleValue:()D
        //    38: dstore          j
        //    40: aload_1         /* uq */
        //    41: invokestatic    kawa/lib/numbers.kmagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    44: dup            
        //    45: astore          10
        //    47: invokevirtual   java/lang/Number.doubleValue:()D
        //    50: dstore          k
        //    52: iconst_2       
        //    53: i2d            
        //    54: dload           i
        //    56: dload           k
        //    58: dmul           
        //    59: dload_2         /* r */
        //    60: dload           j
        //    62: dmul           
        //    63: dsub           
        //    64: dmul           
        //    65: iconst_m1      
        //    66: i2d            
        //    67: invokestatic    java/lang/Math.max:(DD)D
        //    70: dconst_1       
        //    71: invokestatic    java/lang/Math.min:(DD)D
        //    74: dneg           
        //    75: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //    78: invokestatic    kawa/lib/numbers.asin:(Ljava/lang/Number;)Ljava/lang/Number;
        //    81: astore          beta
        //    83: aload           beta
        //    85: invokestatic    kawa/lib/numbers.abs:(Ljava/lang/Number;)Ljava/lang/Number;
        //    88: getstatic       java/lang/Math.PI:D
        //    91: iconst_2       
        //    92: i2d            
        //    93: ddiv           
        //    94: ldc2_w          1.0E-12
        //    97: dsub           
        //    98: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   101: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   104: ifeq            196
        //   107: iconst_3       
        //   108: anewarray       Ljava/lang/Object;
        //   111: dup            
        //   112: iconst_0       
        //   113: getstatic       kawa/lib/kawa/rotations.Lit11:Lgnu/math/DFloNum;
        //   116: aastore        
        //   117: dup            
        //   118: iconst_1       
        //   119: aload           beta
        //   121: aastore        
        //   122: dup            
        //   123: iconst_2       
        //   124: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   127: iconst_2       
        //   128: i2d            
        //   129: dload           j
        //   131: dload           k
        //   133: dmul           
        //   134: dload_2         /* r */
        //   135: dload           i
        //   137: dmul           
        //   138: dsub           
        //   139: dmul           
        //   140: iconst_m1      
        //   141: i2d            
        //   142: invokestatic    java/lang/Math.max:(DD)D
        //   145: dconst_1       
        //   146: invokestatic    java/lang/Math.min:(DD)D
        //   149: dneg           
        //   150: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   153: dload_2         /* r */
        //   154: dload_2         /* r */
        //   155: dmul           
        //   156: dload           j
        //   158: dload           j
        //   160: dmul           
        //   161: dadd           
        //   162: dload           i
        //   164: dload           i
        //   166: dmul           
        //   167: dload           k
        //   169: dload           k
        //   171: dmul           
        //   172: dadd           
        //   173: dsub           
        //   174: iconst_m1      
        //   175: i2d            
        //   176: invokestatic    java/lang/Math.max:(DD)D
        //   179: dconst_1       
        //   180: invokestatic    java/lang/Math.min:(DD)D
        //   183: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   186: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   189: aastore        
        //   190: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   193: goto            342
        //   196: iconst_3       
        //   197: anewarray       Ljava/lang/Object;
        //   200: dup            
        //   201: iconst_0       
        //   202: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   205: iconst_2       
        //   206: i2d            
        //   207: dload           i
        //   209: dload           j
        //   211: dmul           
        //   212: dload_2         /* r */
        //   213: dload           k
        //   215: dmul           
        //   216: dadd           
        //   217: dmul           
        //   218: iconst_m1      
        //   219: i2d            
        //   220: invokestatic    java/lang/Math.max:(DD)D
        //   223: dconst_1       
        //   224: invokestatic    java/lang/Math.min:(DD)D
        //   227: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   230: dload_2         /* r */
        //   231: dload_2         /* r */
        //   232: dmul           
        //   233: dload           i
        //   235: dload           i
        //   237: dmul           
        //   238: dadd           
        //   239: dload           j
        //   241: dload           j
        //   243: dmul           
        //   244: dload           k
        //   246: dload           k
        //   248: dmul           
        //   249: dadd           
        //   250: dsub           
        //   251: iconst_m1      
        //   252: i2d            
        //   253: invokestatic    java/lang/Math.max:(DD)D
        //   256: dconst_1       
        //   257: invokestatic    java/lang/Math.min:(DD)D
        //   260: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   263: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   266: aastore        
        //   267: dup            
        //   268: iconst_1       
        //   269: aload           beta
        //   271: aastore        
        //   272: dup            
        //   273: iconst_2       
        //   274: getstatic       kawa/lib/numbers.atan:Lgnu/expr/GenericProc;
        //   277: iconst_2       
        //   278: i2d            
        //   279: dload_2         /* r */
        //   280: dload           i
        //   282: dmul           
        //   283: dload           j
        //   285: dload           k
        //   287: dmul           
        //   288: dadd           
        //   289: dmul           
        //   290: iconst_m1      
        //   291: i2d            
        //   292: invokestatic    java/lang/Math.max:(DD)D
        //   295: dconst_1       
        //   296: invokestatic    java/lang/Math.min:(DD)D
        //   299: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   302: dload_2         /* r */
        //   303: dload_2         /* r */
        //   304: dmul           
        //   305: dload           k
        //   307: dload           k
        //   309: dmul           
        //   310: dadd           
        //   311: dload           i
        //   313: dload           i
        //   315: dmul           
        //   316: dload           j
        //   318: dload           j
        //   320: dmul           
        //   321: dadd           
        //   322: dsub           
        //   323: iconst_m1      
        //   324: i2d            
        //   325: invokestatic    java/lang/Math.max:(DD)D
        //   328: dconst_1       
        //   329: invokestatic    java/lang/Math.min:(DD)D
        //   332: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
        //   335: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   338: aastore        
        //   339: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //   342: areturn        
        //   343: new             Lgnu/mapping/WrongType;
        //   346: dup_x1         
        //   347: swap           
        //   348: ldc             "r"
        //   350: bipush          -2
        //   352: aload           4
        //   354: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   357: athrow         
        //   358: new             Lgnu/mapping/WrongType;
        //   361: dup_x1         
        //   362: swap           
        //   363: ldc             "i"
        //   365: bipush          -2
        //   367: aload           6
        //   369: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   372: athrow         
        //   373: new             Lgnu/mapping/WrongType;
        //   376: dup_x1         
        //   377: swap           
        //   378: ldc             "j"
        //   380: bipush          -2
        //   382: aload           8
        //   384: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   387: athrow         
        //   388: new             Lgnu/mapping/WrongType;
        //   391: dup_x1         
        //   392: swap           
        //   393: ldc             "k"
        //   395: bipush          -2
        //   397: aload           10
        //   399: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   402: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  12     15     343    358    Ljava/lang/ClassCastException;
        //  23     26     358    373    Ljava/lang/ClassCastException;
        //  35     38     373    388    Ljava/lang/ClassCastException;
        //  47     50     388    403    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 236 out of bounds for length 236
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
    
    public static Quaternion makeIntrinsicXyx(final RealNum alpha, final RealNum beta, final RealNum gamma) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotx(alpha), roty(beta)), rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeIntrinsicXzx(final RealNum alpha, final RealNum beta, final RealNum gamma) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotx(alpha), rotz(beta)), rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeIntrinsicYxy(final RealNum alpha, final RealNum beta, final RealNum gamma) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(roty(alpha), rotx(beta)), roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeIntrinsicYzy(final RealNum alpha, final RealNum beta, final RealNum gamma) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(roty(alpha), rotz(beta)), roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeIntrinsicZxz(final RealNum alpha, final RealNum beta, final RealNum gamma) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotz(alpha), rotx(beta)), rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeIntrinsicZyz(final RealNum alpha, final RealNum beta, final RealNum gamma) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotz(alpha), roty(beta)), rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeIntrinsicXyz(final RealNum alpha, final RealNum beta, final RealNum gamma) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotx(alpha), roty(beta)), rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeIntrinsicXzy(final RealNum alpha, final RealNum beta, final RealNum gamma) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotx(alpha), rotz(beta)), roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeIntrinsicYxz(final RealNum alpha, final RealNum beta, final RealNum gamma) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(roty(alpha), rotx(beta)), rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeIntrinsicYzx(final RealNum alpha, final RealNum beta, final RealNum gamma) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(roty(alpha), rotz(beta)), rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeIntrinsicZxy(final RealNum alpha, final RealNum beta, final RealNum gamma) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotz(alpha), rotx(beta)), roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeIntrinsicZyx(final RealNum alpha, final RealNum beta, final RealNum gamma) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotz(alpha), roty(beta)), rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Values extrinsicXyx(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/rotations.intrinsicXyx:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //     4: astore_1       
        //     5: iconst_0       
        //     6: istore_2       
        //     7: aload_1        
        //     8: iload_2        
        //     9: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    12: istore_2       
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_1        
        //    20: iload_2        
        //    21: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    24: istore_2       
        //    25: aload_1        
        //    26: iload_2        
        //    27: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    30: astore          4
        //    32: aload_1        
        //    33: iload_2        
        //    34: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    37: istore_2       
        //    38: aload_1        
        //    39: iload_2        
        //    40: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          gamma
        //    45: iconst_3       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload           gamma
        //    53: aastore        
        //    54: dup            
        //    55: iconst_1       
        //    56: aload           beta
        //    58: aastore        
        //    59: dup            
        //    60: iconst_2       
        //    61: aload_3         /* alpha */
        //    62: aastore        
        //    63: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    66: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Values extrinsicXyz(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/rotations.intrinsicZyx:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //     4: astore_1       
        //     5: iconst_0       
        //     6: istore_2       
        //     7: aload_1        
        //     8: iload_2        
        //     9: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    12: istore_2       
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_1        
        //    20: iload_2        
        //    21: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    24: istore_2       
        //    25: aload_1        
        //    26: iload_2        
        //    27: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    30: astore          4
        //    32: aload_1        
        //    33: iload_2        
        //    34: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    37: istore_2       
        //    38: aload_1        
        //    39: iload_2        
        //    40: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          gamma
        //    45: iconst_3       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload           gamma
        //    53: aastore        
        //    54: dup            
        //    55: iconst_1       
        //    56: aload           beta
        //    58: aastore        
        //    59: dup            
        //    60: iconst_2       
        //    61: aload_3         /* alpha */
        //    62: aastore        
        //    63: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    66: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Values extrinsicXzx(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/rotations.intrinsicXzx:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //     4: astore_1       
        //     5: iconst_0       
        //     6: istore_2       
        //     7: aload_1        
        //     8: iload_2        
        //     9: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    12: istore_2       
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_1        
        //    20: iload_2        
        //    21: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    24: istore_2       
        //    25: aload_1        
        //    26: iload_2        
        //    27: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    30: astore          4
        //    32: aload_1        
        //    33: iload_2        
        //    34: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    37: istore_2       
        //    38: aload_1        
        //    39: iload_2        
        //    40: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          gamma
        //    45: iconst_3       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload           gamma
        //    53: aastore        
        //    54: dup            
        //    55: iconst_1       
        //    56: aload           beta
        //    58: aastore        
        //    59: dup            
        //    60: iconst_2       
        //    61: aload_3         /* alpha */
        //    62: aastore        
        //    63: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    66: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Values extrinsicXzy(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/rotations.intrinsicYzx:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //     4: astore_1       
        //     5: iconst_0       
        //     6: istore_2       
        //     7: aload_1        
        //     8: iload_2        
        //     9: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    12: istore_2       
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_1        
        //    20: iload_2        
        //    21: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    24: istore_2       
        //    25: aload_1        
        //    26: iload_2        
        //    27: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    30: astore          4
        //    32: aload_1        
        //    33: iload_2        
        //    34: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    37: istore_2       
        //    38: aload_1        
        //    39: iload_2        
        //    40: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          gamma
        //    45: iconst_3       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload           gamma
        //    53: aastore        
        //    54: dup            
        //    55: iconst_1       
        //    56: aload           beta
        //    58: aastore        
        //    59: dup            
        //    60: iconst_2       
        //    61: aload_3         /* alpha */
        //    62: aastore        
        //    63: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    66: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Values extrinsicYxy(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/rotations.intrinsicYxy:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //     4: astore_1       
        //     5: iconst_0       
        //     6: istore_2       
        //     7: aload_1        
        //     8: iload_2        
        //     9: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    12: istore_2       
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_1        
        //    20: iload_2        
        //    21: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    24: istore_2       
        //    25: aload_1        
        //    26: iload_2        
        //    27: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    30: astore          4
        //    32: aload_1        
        //    33: iload_2        
        //    34: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    37: istore_2       
        //    38: aload_1        
        //    39: iload_2        
        //    40: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          gamma
        //    45: iconst_3       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload           gamma
        //    53: aastore        
        //    54: dup            
        //    55: iconst_1       
        //    56: aload           beta
        //    58: aastore        
        //    59: dup            
        //    60: iconst_2       
        //    61: aload_3         /* alpha */
        //    62: aastore        
        //    63: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    66: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Values extrinsicYxz(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/rotations.intrinsicZxy:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //     4: astore_1       
        //     5: iconst_0       
        //     6: istore_2       
        //     7: aload_1        
        //     8: iload_2        
        //     9: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    12: istore_2       
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_1        
        //    20: iload_2        
        //    21: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    24: istore_2       
        //    25: aload_1        
        //    26: iload_2        
        //    27: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    30: astore          4
        //    32: aload_1        
        //    33: iload_2        
        //    34: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    37: istore_2       
        //    38: aload_1        
        //    39: iload_2        
        //    40: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          gamma
        //    45: iconst_3       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload           gamma
        //    53: aastore        
        //    54: dup            
        //    55: iconst_1       
        //    56: aload           beta
        //    58: aastore        
        //    59: dup            
        //    60: iconst_2       
        //    61: aload_3         /* alpha */
        //    62: aastore        
        //    63: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    66: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Values extrinsicYzx(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/rotations.intrinsicXzy:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //     4: astore_1       
        //     5: iconst_0       
        //     6: istore_2       
        //     7: aload_1        
        //     8: iload_2        
        //     9: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    12: istore_2       
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_1        
        //    20: iload_2        
        //    21: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    24: istore_2       
        //    25: aload_1        
        //    26: iload_2        
        //    27: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    30: astore          4
        //    32: aload_1        
        //    33: iload_2        
        //    34: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    37: istore_2       
        //    38: aload_1        
        //    39: iload_2        
        //    40: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          gamma
        //    45: iconst_3       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload           gamma
        //    53: aastore        
        //    54: dup            
        //    55: iconst_1       
        //    56: aload           beta
        //    58: aastore        
        //    59: dup            
        //    60: iconst_2       
        //    61: aload_3         /* alpha */
        //    62: aastore        
        //    63: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    66: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Values extrinsicYzy(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/rotations.intrinsicYzy:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //     4: astore_1       
        //     5: iconst_0       
        //     6: istore_2       
        //     7: aload_1        
        //     8: iload_2        
        //     9: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    12: istore_2       
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_1        
        //    20: iload_2        
        //    21: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    24: istore_2       
        //    25: aload_1        
        //    26: iload_2        
        //    27: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    30: astore          4
        //    32: aload_1        
        //    33: iload_2        
        //    34: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    37: istore_2       
        //    38: aload_1        
        //    39: iload_2        
        //    40: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          gamma
        //    45: iconst_3       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload           gamma
        //    53: aastore        
        //    54: dup            
        //    55: iconst_1       
        //    56: aload           beta
        //    58: aastore        
        //    59: dup            
        //    60: iconst_2       
        //    61: aload_3         /* alpha */
        //    62: aastore        
        //    63: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    66: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Values extrinsicZxy(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/rotations.intrinsicYxz:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //     4: astore_1       
        //     5: iconst_0       
        //     6: istore_2       
        //     7: aload_1        
        //     8: iload_2        
        //     9: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    12: istore_2       
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_1        
        //    20: iload_2        
        //    21: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    24: istore_2       
        //    25: aload_1        
        //    26: iload_2        
        //    27: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    30: astore          4
        //    32: aload_1        
        //    33: iload_2        
        //    34: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    37: istore_2       
        //    38: aload_1        
        //    39: iload_2        
        //    40: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          gamma
        //    45: iconst_3       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload           gamma
        //    53: aastore        
        //    54: dup            
        //    55: iconst_1       
        //    56: aload           beta
        //    58: aastore        
        //    59: dup            
        //    60: iconst_2       
        //    61: aload_3         /* alpha */
        //    62: aastore        
        //    63: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    66: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Values extrinsicZxz(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/rotations.intrinsicZxz:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //     4: astore_1       
        //     5: iconst_0       
        //     6: istore_2       
        //     7: aload_1        
        //     8: iload_2        
        //     9: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    12: istore_2       
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_1        
        //    20: iload_2        
        //    21: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    24: istore_2       
        //    25: aload_1        
        //    26: iload_2        
        //    27: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    30: astore          4
        //    32: aload_1        
        //    33: iload_2        
        //    34: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    37: istore_2       
        //    38: aload_1        
        //    39: iload_2        
        //    40: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          gamma
        //    45: iconst_3       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload           gamma
        //    53: aastore        
        //    54: dup            
        //    55: iconst_1       
        //    56: aload           beta
        //    58: aastore        
        //    59: dup            
        //    60: iconst_2       
        //    61: aload_3         /* alpha */
        //    62: aastore        
        //    63: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    66: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Values extrinsicZyx(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/rotations.intrinsicXyz:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //     4: astore_1       
        //     5: iconst_0       
        //     6: istore_2       
        //     7: aload_1        
        //     8: iload_2        
        //     9: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    12: istore_2       
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_1        
        //    20: iload_2        
        //    21: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    24: istore_2       
        //    25: aload_1        
        //    26: iload_2        
        //    27: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    30: astore          4
        //    32: aload_1        
        //    33: iload_2        
        //    34: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    37: istore_2       
        //    38: aload_1        
        //    39: iload_2        
        //    40: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          gamma
        //    45: iconst_3       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload           gamma
        //    53: aastore        
        //    54: dup            
        //    55: iconst_1       
        //    56: aload           beta
        //    58: aastore        
        //    59: dup            
        //    60: iconst_2       
        //    61: aload_3         /* alpha */
        //    62: aastore        
        //    63: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    66: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Values extrinsicZyz(final Quaternion q) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/rotations.intrinsicZyz:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //     4: astore_1       
        //     5: iconst_0       
        //     6: istore_2       
        //     7: aload_1        
        //     8: iload_2        
        //     9: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    12: istore_2       
        //    13: aload_1        
        //    14: iload_2        
        //    15: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    18: astore_3       
        //    19: aload_1        
        //    20: iload_2        
        //    21: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    24: istore_2       
        //    25: aload_1        
        //    26: iload_2        
        //    27: invokestatic    gnu/mapping/Values.getFromPos:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    30: astore          4
        //    32: aload_1        
        //    33: iload_2        
        //    34: invokestatic    gnu/mapping/Values.incrPos:(Ljava/lang/Object;I)I
        //    37: istore_2       
        //    38: aload_1        
        //    39: iload_2        
        //    40: invokestatic    gnu/mapping/Values.getFromPosFinal:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          gamma
        //    45: iconst_3       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload           gamma
        //    53: aastore        
        //    54: dup            
        //    55: iconst_1       
        //    56: aload           beta
        //    58: aastore        
        //    59: dup            
        //    60: iconst_2       
        //    61: aload_3         /* alpha */
        //    62: aastore        
        //    63: invokestatic    gnu/mapping/Values.makeFromArray:([Ljava/lang/Object;)Lgnu/mapping/Values;
        //    66: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Quaternion makeExtrinsicXyx(final RealNum gamma, final RealNum beta, final RealNum alpha) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotx(alpha), roty(beta)), rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeExtrinsicXyz(final RealNum gamma, final RealNum beta, final RealNum alpha) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotz(alpha), roty(beta)), rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeExtrinsicXzx(final RealNum gamma, final RealNum beta, final RealNum alpha) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotx(alpha), rotz(beta)), rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeExtrinsicXzy(final RealNum gamma, final RealNum beta, final RealNum alpha) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(roty(alpha), rotz(beta)), rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeExtrinsicYxy(final RealNum gamma, final RealNum beta, final RealNum alpha) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(roty(alpha), rotx(beta)), roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeExtrinsicYxz(final RealNum gamma, final RealNum beta, final RealNum alpha) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotz(alpha), rotx(beta)), roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeExtrinsicYzx(final RealNum gamma, final RealNum beta, final RealNum alpha) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotx(alpha), rotz(beta)), roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeExtrinsicYzy(final RealNum gamma, final RealNum beta, final RealNum alpha) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(roty(alpha), rotz(beta)), roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeExtrinsicZxy(final RealNum gamma, final RealNum beta, final RealNum alpha) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(roty(alpha), rotx(beta)), rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeExtrinsicZxz(final RealNum gamma, final RealNum beta, final RealNum alpha) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotz(alpha), rotx(beta)), rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeExtrinsicZyx(final RealNum gamma, final RealNum beta, final RealNum alpha) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotx(alpha), roty(beta)), rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Quaternion makeExtrinsicZyz(final RealNum gamma, final RealNum beta, final RealNum alpha) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(rotz(alpha), roty(beta)), rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "unit-quaternion", 1, force);
        }
    }
    
    public static Procedure makeRotationProcedure(final Quaternion rotation) {
        public class rotations$frame extends ModuleBody
        {
            Number uq$St;
            Number uq;
            final ModuleMethod lambda$Fn2;
            
            public rotations$frame() {
                final ModuleMethod lambda$Fn2 = new ModuleMethod(this, 1, null, 4097);
                lambda$Fn2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm:709");
                this.lambda$Fn2 = lambda$Fn2;
            }
            
            Quaternion lambda2(final Quaternion vec) {
                Label_0044: {
                    if (!quaternions.isVectorQuaternion(vec)) {
                        break Label_0044;
                    }
                    final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(this.uq, vec), this.uq$St), Number.class);
                    try {
                        return quaternions.vectorPart((Number)force);
                        exceptions.error("vec must be vector quaternion");
                        throw Special.reachedUnexpected;
                    }
                    catch (ClassCastException ex) {
                        throw new WrongType(ex, "vector-part", 1, force);
                    }
                }
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector != 1) {
                    return super.match1(moduleMethod, o, ctx);
                }
                final Object force = Promise.force(o, Quaternion.class);
                if (!(force instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object argValue) {
                Label_0025: {
                    if (method.selector != 1) {
                        break Label_0025;
                    }
                    final Object force = Promise.force(argValue, Quaternion.class);
                    try {
                        return this.lambda2((Quaternion)force);
                        return super.apply1(method, argValue);
                    }
                    catch (ClassCastException ex) {
                        throw new WrongType(ex, "lambda", 1, argValue);
                    }
                }
            }
        }
        final rotations$frame $heapFrame = new rotations$frame();
        $heapFrame.uq = quaternions.unitQuaternion(rotation);
        $heapFrame.uq$St = quaternions.conjugate($heapFrame.uq);
        return $heapFrame.lambda$Fn2;
    }
    
    public static Quaternion rotateVector(final Quaternion rotation, final Quaternion vec) {
        Label_0049: {
            if (!quaternions.isVectorQuaternion(vec)) {
                break Label_0049;
            }
            final Number uq = quaternions.unitQuaternion(rotation);
            final Number uq$St = quaternions.conjugate(uq);
            final Object force = Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(uq, vec), uq$St), Number.class);
            try {
                return quaternions.vectorPart((Number)force);
                exceptions.error(rotations.Lit12, "vec must be vector quaternion");
                throw Special.reachedUnexpected;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "vector-part", 1, force);
            }
        }
    }
    
    static {
        Lit76 = IntNum.valueOf(4);
        Lit75 = Symbol.valueOf("quasiquote");
        Lit74 = Symbol.valueOf("M");
        Lit73 = Symbol.valueOf("$lookup$");
        Lit72 = new Object[0];
        Lit71 = Symbol.valueOf("make-rotation-procedure");
        Lit70 = Symbol.valueOf("make-extrinsic-zyz");
        Lit69 = Symbol.valueOf("make-extrinsic-zyx");
        Lit68 = Symbol.valueOf("make-extrinsic-zxz");
        Lit67 = Symbol.valueOf("make-extrinsic-zxy");
        Lit66 = Symbol.valueOf("make-extrinsic-yzy");
        Lit65 = Symbol.valueOf("make-extrinsic-yzx");
        Lit64 = Symbol.valueOf("make-extrinsic-yxz");
        Lit63 = Symbol.valueOf("make-extrinsic-yxy");
        Lit62 = Symbol.valueOf("make-extrinsic-xzy");
        Lit61 = Symbol.valueOf("make-extrinsic-xzx");
        Lit60 = Symbol.valueOf("make-extrinsic-xyz");
        Lit59 = Symbol.valueOf("make-extrinsic-xyx");
        Lit58 = Symbol.valueOf("extrinsic-zyz");
        Lit57 = Symbol.valueOf("extrinsic-zyx");
        Lit56 = Symbol.valueOf("extrinsic-zxz");
        Lit55 = Symbol.valueOf("extrinsic-zxy");
        Lit54 = Symbol.valueOf("extrinsic-yzy");
        Lit53 = Symbol.valueOf("extrinsic-yzx");
        Lit52 = Symbol.valueOf("extrinsic-yxz");
        Lit51 = Symbol.valueOf("extrinsic-yxy");
        Lit50 = Symbol.valueOf("extrinsic-xzy");
        Lit49 = Symbol.valueOf("extrinsic-xzx");
        Lit48 = Symbol.valueOf("extrinsic-xyz");
        Lit47 = Symbol.valueOf("extrinsic-xyx");
        Lit46 = Symbol.valueOf("make-intrinsic-zyx");
        Lit45 = Symbol.valueOf("make-intrinsic-zxy");
        Lit44 = Symbol.valueOf("make-intrinsic-yzx");
        Lit43 = Symbol.valueOf("make-intrinsic-yxz");
        Lit42 = Symbol.valueOf("make-intrinsic-xzy");
        Lit41 = Symbol.valueOf("make-intrinsic-xyz");
        Lit40 = Symbol.valueOf("make-intrinsic-zyz");
        Lit39 = Symbol.valueOf("make-intrinsic-zxz");
        Lit38 = Symbol.valueOf("make-intrinsic-yzy");
        Lit37 = Symbol.valueOf("make-intrinsic-yxy");
        Lit36 = Symbol.valueOf("make-intrinsic-xzx");
        Lit35 = Symbol.valueOf("make-intrinsic-xyx");
        Lit34 = Symbol.valueOf("intrinsic-zyx");
        Lit33 = Symbol.valueOf("intrinsic-zxy");
        Lit32 = Symbol.valueOf("intrinsic-yzx");
        Lit31 = Symbol.valueOf("intrinsic-yxz");
        Lit30 = Symbol.valueOf("intrinsic-xzy");
        Lit29 = Symbol.valueOf("intrinsic-xyz");
        Lit28 = Symbol.valueOf("intrinsic-zyz");
        Lit27 = Symbol.valueOf("intrinsic-zxz");
        Lit26 = Symbol.valueOf("intrinsic-yzy");
        Lit25 = Symbol.valueOf("intrinsic-yxy");
        Lit24 = Symbol.valueOf("intrinsic-xzx");
        Lit23 = Symbol.valueOf("intrinsic-xyx");
        Lit22 = Symbol.valueOf("rotz");
        Lit21 = Symbol.valueOf("roty");
        Lit20 = Symbol.valueOf("rotx");
        Lit19 = Symbol.valueOf("rotation-axis/angle");
        Lit18 = Symbol.valueOf("rotation-angle");
        Lit17 = Symbol.valueOf("rotation-axis");
        Lit16 = Symbol.valueOf("rotation-matrix->quaternion");
        Lit15 = Symbol.valueOf("quaternion->rotation-matrix");
        Lit14 = new SyntaxRules(rotations.Lit72, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", rotations.Lit72, 1, "rotations.scm:110"), "\u0001", "\u0011\u0018\u00049\u0011\u0018\f\t\u0003\u0018\u0014\u0018\u001c", new Object[] { PairWithPosition.make(rotations.Lit73, Pair.make(rotations.Lit74, Pair.make(Pair.make(rotations.Lit75, Pair.make(Symbol.valueOf("min"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm", 450573), PairWithPosition.make(rotations.Lit73, Pair.make(rotations.Lit74, Pair.make(Pair.make(rotations.Lit75, Pair.make(Symbol.valueOf("max"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm", 450580), PairWithPosition.make(-1, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm", 450588), PairWithPosition.make(1.0, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm", 450594) }, 0) }, 1, Lit13 = Symbol.valueOf("u"));
        Lit12 = Symbol.valueOf("rotate-vector");
        Lit11 = DFloNum.valueOf(0.0);
        Lit10 = new CComplex(Lit0 = IntNum.valueOf(0), Lit2 = IntNum.valueOf(1));
        Lit9 = new IntFraction(rotations.Lit2, rotations.Lit76);
        Lit8 = new IntFraction(rotations.Lit2, rotations.Lit76);
        Lit7 = new IntFraction(rotations.Lit2, rotations.Lit76);
        Lit6 = new IntFraction(rotations.Lit2, rotations.Lit76);
        Lit5 = new IntFraction(rotations.Lit2, Lit3 = IntNum.valueOf(2));
        Lit4 = 1.0E-12;
        Lit1 = IntNum.valueOf(3);
        $Prvt$M = Math.class;
        rotations.$instance = new rotations();
        $Prvt$define = StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
        $Prvt$quaternion = StaticFieldLocation.make("kawa.lib.numbers", "quaternion");
        $Prvt$unit$Mnquaternion = StaticFieldLocation.make("kawa.lib.kawa.quaternions", "unit$Mnquaternion");
        $Prvt$$Pl = StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Pl");
        $Prvt$$Mn = StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Mn");
        $Prvt$$St = StaticFieldLocation.make("gnu.kawa.functions.MultiplyOp", "$St");
        $Prvt$u = Macro.make(rotations.Lit13, rotations.Lit14, "kawa.lib.kawa.rotations");
        final rotations $instance3 = rotations.$instance;
        final ModuleMethod lambda$Fn2 = new ModuleMethod($instance3, 2, null, 8194);
        lambda$Fn2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm:145");
        lambda$Fn1 = lambda$Fn2;
        quaternion$Mn$Grrotation$Mnmatrix = new ModuleMethod($instance3, 3, rotations.Lit15, 4097);
        rotation$Mnmatrix$Mn$Grquaternion = new ModuleMethod($instance3, 4, rotations.Lit16, 4097);
        rotation$Mnaxis = new ModuleMethod($instance3, 5, rotations.Lit17, 4097);
        rotation$Mnangle = new ModuleMethod($instance3, 6, rotations.Lit18, 4097);
        rotation$Mnaxis$Slangle = new ModuleMethod($instance3, 7, rotations.Lit19, 4097);
        final GenericProc make$Mnaxis$Slangle2 = new GenericProc("make-axis/angle");
        final rotations $instance = rotations.$instance;
        final ModuleMethod method = new ModuleMethod($instance, 8, "make-axis/angle", 8194);
        method.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm:205");
        make$Mnaxis$Slangle2.add(method);
        final rotations $instance2 = rotations.$instance;
        final ModuleMethod method2 = new ModuleMethod($instance2, 9, "make-axis/angle", 16388);
        method2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm:211");
        make$Mnaxis$Slangle2.add(method2);
        make$Mnaxis$Slangle = make$Mnaxis$Slangle2;
        rotx = new ModuleMethod($instance3, 10, rotations.Lit20, 4097);
        roty = new ModuleMethod($instance3, 11, rotations.Lit21, 4097);
        rotz = new ModuleMethod($instance3, 12, rotations.Lit22, 4097);
        intrinsic$Mnxyx = new ModuleMethod($instance3, 13, rotations.Lit23, 4097);
        intrinsic$Mnxzx = new ModuleMethod($instance3, 14, rotations.Lit24, 4097);
        intrinsic$Mnyxy = new ModuleMethod($instance3, 15, rotations.Lit25, 4097);
        intrinsic$Mnyzy = new ModuleMethod($instance3, 16, rotations.Lit26, 4097);
        intrinsic$Mnzxz = new ModuleMethod($instance3, 17, rotations.Lit27, 4097);
        intrinsic$Mnzyz = new ModuleMethod($instance3, 18, rotations.Lit28, 4097);
        euler$Mnxyx = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnxyx");
        euler$Mnxzx = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnxzx");
        euler$Mnyxy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnyxy");
        euler$Mnyzy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnyzy");
        euler$Mnzxz = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnzxz");
        euler$Mnzyz = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnzyz");
        intrinsic$Mnxyz = new ModuleMethod($instance3, 19, rotations.Lit29, 4097);
        intrinsic$Mnxzy = new ModuleMethod($instance3, 20, rotations.Lit30, 4097);
        intrinsic$Mnyxz = new ModuleMethod($instance3, 21, rotations.Lit31, 4097);
        intrinsic$Mnyzx = new ModuleMethod($instance3, 22, rotations.Lit32, 4097);
        intrinsic$Mnzxy = new ModuleMethod($instance3, 23, rotations.Lit33, 4097);
        intrinsic$Mnzyx = new ModuleMethod($instance3, 24, rotations.Lit34, 4097);
        tait$Mnbryan$Mnxyz = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnxyz");
        tait$Mnbryan$Mnxzy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnxzy");
        tait$Mnbryan$Mnyxz = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnyxz");
        tait$Mnbryan$Mnyzx = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnyzx");
        tait$Mnbryan$Mnzxy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnzxy");
        tait$Mnbryan$Mnzyx = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnzyx");
        make$Mnintrinsic$Mnxyx = new ModuleMethod($instance3, 25, rotations.Lit35, 12291);
        make$Mnintrinsic$Mnxzx = new ModuleMethod($instance3, 26, rotations.Lit36, 12291);
        make$Mnintrinsic$Mnyxy = new ModuleMethod($instance3, 27, rotations.Lit37, 12291);
        make$Mnintrinsic$Mnyzy = new ModuleMethod($instance3, 28, rotations.Lit38, 12291);
        make$Mnintrinsic$Mnzxz = new ModuleMethod($instance3, 29, rotations.Lit39, 12291);
        make$Mnintrinsic$Mnzyz = new ModuleMethod($instance3, 30, rotations.Lit40, 12291);
        make$Mnintrinsic$Mnxyz = new ModuleMethod($instance3, 31, rotations.Lit41, 12291);
        make$Mnintrinsic$Mnxzy = new ModuleMethod($instance3, 32, rotations.Lit42, 12291);
        make$Mnintrinsic$Mnyxz = new ModuleMethod($instance3, 33, rotations.Lit43, 12291);
        make$Mnintrinsic$Mnyzx = new ModuleMethod($instance3, 34, rotations.Lit44, 12291);
        make$Mnintrinsic$Mnzxy = new ModuleMethod($instance3, 35, rotations.Lit45, 12291);
        make$Mnintrinsic$Mnzyx = new ModuleMethod($instance3, 36, rotations.Lit46, 12291);
        make$Mneuler$Mnxyx = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnxyx");
        make$Mneuler$Mnxzx = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnxzx");
        make$Mneuler$Mnyxy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnyxy");
        make$Mneuler$Mnyzy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnyzy");
        make$Mneuler$Mnzxz = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnzxz");
        make$Mneuler$Mnzyz = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnzyz");
        make$Mntait$Mnbryan$Mnxyz = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnxyz");
        make$Mntait$Mnbryan$Mnxzy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnxzy");
        make$Mntait$Mnbryan$Mnyxz = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnyxz");
        make$Mntait$Mnbryan$Mnyzx = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnyzx");
        make$Mntait$Mnbryan$Mnzxy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnzxy");
        make$Mntait$Mnbryan$Mnzyx = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnzyx");
        extrinsic$Mnxyx = new ModuleMethod($instance3, 37, rotations.Lit47, 4097);
        extrinsic$Mnxyz = new ModuleMethod($instance3, 38, rotations.Lit48, 4097);
        extrinsic$Mnxzx = new ModuleMethod($instance3, 39, rotations.Lit49, 4097);
        extrinsic$Mnxzy = new ModuleMethod($instance3, 40, rotations.Lit50, 4097);
        extrinsic$Mnyxy = new ModuleMethod($instance3, 41, rotations.Lit51, 4097);
        extrinsic$Mnyxz = new ModuleMethod($instance3, 42, rotations.Lit52, 4097);
        extrinsic$Mnyzx = new ModuleMethod($instance3, 43, rotations.Lit53, 4097);
        extrinsic$Mnyzy = new ModuleMethod($instance3, 44, rotations.Lit54, 4097);
        extrinsic$Mnzxy = new ModuleMethod($instance3, 45, rotations.Lit55, 4097);
        extrinsic$Mnzxz = new ModuleMethod($instance3, 46, rotations.Lit56, 4097);
        extrinsic$Mnzyx = new ModuleMethod($instance3, 47, rotations.Lit57, 4097);
        extrinsic$Mnzyz = new ModuleMethod($instance3, 48, rotations.Lit58, 4097);
        make$Mnextrinsic$Mnxyx = new ModuleMethod($instance3, 49, rotations.Lit59, 12291);
        make$Mnextrinsic$Mnxyz = new ModuleMethod($instance3, 50, rotations.Lit60, 12291);
        make$Mnextrinsic$Mnxzx = new ModuleMethod($instance3, 51, rotations.Lit61, 12291);
        make$Mnextrinsic$Mnxzy = new ModuleMethod($instance3, 52, rotations.Lit62, 12291);
        make$Mnextrinsic$Mnyxy = new ModuleMethod($instance3, 53, rotations.Lit63, 12291);
        make$Mnextrinsic$Mnyxz = new ModuleMethod($instance3, 54, rotations.Lit64, 12291);
        make$Mnextrinsic$Mnyzx = new ModuleMethod($instance3, 55, rotations.Lit65, 12291);
        make$Mnextrinsic$Mnyzy = new ModuleMethod($instance3, 56, rotations.Lit66, 12291);
        make$Mnextrinsic$Mnzxy = new ModuleMethod($instance3, 57, rotations.Lit67, 12291);
        make$Mnextrinsic$Mnzxz = new ModuleMethod($instance3, 58, rotations.Lit68, 12291);
        make$Mnextrinsic$Mnzyx = new ModuleMethod($instance3, 59, rotations.Lit69, 12291);
        make$Mnextrinsic$Mnzyz = new ModuleMethod($instance3, 60, rotations.Lit70, 12291);
        rpy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "extrinsic$Mnxyz");
        make$Mnrpy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnextrinsic$Mnxyz");
        make$Mnrotation$Mnprocedure = new ModuleMethod($instance3, 61, rotations.Lit71, 4097);
        rotate$Mnvector = new ModuleMethod($instance3, 62, rotations.Lit12, 8194);
        $runBody$();
    }
    
    public rotations() {
        ModuleInfo.register(this);
    }
    
    public static Quaternion makeAxis$SlAngle(final Quaternion axis, final RealNum angle) {
        final RealNum halfangle = RealNum.divide(angle, rotations.Lit3);
        return (Quaternion)Promise.force(AddOp.apply2(1, numbers.cos.apply1(halfangle), MultiplyOp.$St.apply2(numbers.unitVector(axis), numbers.sin.apply1(halfangle))), Quaternion.class);
    }
    
    public static Quaternion makeAxis$SlAngle(final RealNum axis$Mnx, final RealNum axis$Mny, final RealNum axis$Mnz, final RealNum angle) {
        return (Quaternion)Promise.force(rotations.make$Mnaxis$Slangle.apply2(numbers.make$Mnrectangular.apply4(rotations.Lit0, axis$Mnx, axis$Mny, axis$Mnz), angle), Quaternion.class);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 61: {
                final Object force = Promise.force(o, Quaternion.class);
                if (!(force instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 48: {
                final Object force2 = Promise.force(o, Quaternion.class);
                if (!(force2 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 47: {
                final Object force3 = Promise.force(o, Quaternion.class);
                if (!(force3 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 46: {
                final Object force4 = Promise.force(o, Quaternion.class);
                if (!(force4 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 45: {
                final Object force5 = Promise.force(o, Quaternion.class);
                if (!(force5 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 44: {
                final Object force6 = Promise.force(o, Quaternion.class);
                if (!(force6 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 43: {
                final Object force7 = Promise.force(o, Quaternion.class);
                if (!(force7 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force7;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 42: {
                final Object force8 = Promise.force(o, Quaternion.class);
                if (!(force8 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 41: {
                final Object force9 = Promise.force(o, Quaternion.class);
                if (!(force9 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force9;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 40: {
                final Object force10 = Promise.force(o, Quaternion.class);
                if (!(force10 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force10;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 39: {
                final Object force11 = Promise.force(o, Quaternion.class);
                if (!(force11 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force11;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 38: {
                final Object force12 = Promise.force(o, Quaternion.class);
                if (!(force12 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force12;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 37: {
                final Object force13 = Promise.force(o, Quaternion.class);
                if (!(force13 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force13;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 24: {
                final Object force14 = Promise.force(o, Quaternion.class);
                if (!(force14 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force14;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 23: {
                final Object force15 = Promise.force(o, Quaternion.class);
                if (!(force15 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force15;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 22: {
                final Object force16 = Promise.force(o, Quaternion.class);
                if (!(force16 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force16;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 21: {
                final Object force17 = Promise.force(o, Quaternion.class);
                if (!(force17 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force17;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 20: {
                final Object force18 = Promise.force(o, Quaternion.class);
                if (!(force18 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force18;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 19: {
                final Object force19 = Promise.force(o, Quaternion.class);
                if (!(force19 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force19;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 18: {
                final Object force20 = Promise.force(o, Quaternion.class);
                if (!(force20 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force20;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 17: {
                final Object force21 = Promise.force(o, Quaternion.class);
                if (!(force21 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force21;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 16: {
                final Object force22 = Promise.force(o, Quaternion.class);
                if (!(force22 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force22;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 15: {
                final Object force23 = Promise.force(o, Quaternion.class);
                if (!(force23 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force23;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 14: {
                final Object force24 = Promise.force(o, Quaternion.class);
                if (!(force24 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force24;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 13: {
                final Object force25 = Promise.force(o, Quaternion.class);
                if (!(force25 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force25;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 12: {
                final Object force26 = Promise.force(o, RealNum.class);
                if (RealNum.asRealNumOrNull(force26) != null) {
                    ctx.value1 = force26;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 11: {
                final Object force27 = Promise.force(o, RealNum.class);
                if (RealNum.asRealNumOrNull(force27) != null) {
                    ctx.value1 = force27;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 10: {
                final Object force28 = Promise.force(o, RealNum.class);
                if (RealNum.asRealNumOrNull(force28) != null) {
                    ctx.value1 = force28;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 7: {
                final Object force29 = Promise.force(o, Quaternion.class);
                if (!(force29 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force29;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 6: {
                final Object force30 = Promise.force(o, Quaternion.class);
                if (!(force30 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force30;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 5: {
                final Object force31 = Promise.force(o, Quaternion.class);
                if (!(force31 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force31;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                final Object force32 = Promise.force(o, Array.class);
                if (!(force32 instanceof Array)) {
                    return -786431;
                }
                ctx.value1 = force32;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 3: {
                final Object force33 = Promise.force(o, Quaternion.class);
                if (!(force33 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force33;
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
            case 8: {
                final Object force = Promise.force(o, Quaternion.class);
                if (!(force instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(o2, RealNum.class);
                if (RealNum.asRealNumOrNull(force2) != null) {
                    ctx.value2 = force2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 62: {
                final Object force3 = Promise.force(o, Quaternion.class);
                if (!(force3 instanceof Quaternion)) {
                    return -786431;
                }
                ctx.value1 = force3;
                final Object force4 = Promise.force(o2, Quaternion.class);
                if (!(force4 instanceof Quaternion)) {
                    return -786430;
                }
                ctx.value2 = force4;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 2: {
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
            case 60: {
                final Object force = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force) == null) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force2) == null) {
                    return -786430;
                }
                ctx.value2 = force2;
                final Object force3 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force3) != null) {
                    ctx.value3 = force3;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 59: {
                final Object force4 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force4) == null) {
                    return -786431;
                }
                ctx.value1 = force4;
                final Object force5 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force5) == null) {
                    return -786430;
                }
                ctx.value2 = force5;
                final Object force6 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force6) != null) {
                    ctx.value3 = force6;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 58: {
                final Object force7 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force7) == null) {
                    return -786431;
                }
                ctx.value1 = force7;
                final Object force8 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force8) == null) {
                    return -786430;
                }
                ctx.value2 = force8;
                final Object force9 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force9) != null) {
                    ctx.value3 = force9;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 57: {
                final Object force10 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force10) == null) {
                    return -786431;
                }
                ctx.value1 = force10;
                final Object force11 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force11) == null) {
                    return -786430;
                }
                ctx.value2 = force11;
                final Object force12 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force12) != null) {
                    ctx.value3 = force12;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 56: {
                final Object force13 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force13) == null) {
                    return -786431;
                }
                ctx.value1 = force13;
                final Object force14 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force14) == null) {
                    return -786430;
                }
                ctx.value2 = force14;
                final Object force15 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force15) != null) {
                    ctx.value3 = force15;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 55: {
                final Object force16 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force16) == null) {
                    return -786431;
                }
                ctx.value1 = force16;
                final Object force17 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force17) == null) {
                    return -786430;
                }
                ctx.value2 = force17;
                final Object force18 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force18) != null) {
                    ctx.value3 = force18;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 54: {
                final Object force19 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force19) == null) {
                    return -786431;
                }
                ctx.value1 = force19;
                final Object force20 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force20) == null) {
                    return -786430;
                }
                ctx.value2 = force20;
                final Object force21 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force21) != null) {
                    ctx.value3 = force21;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 53: {
                final Object force22 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force22) == null) {
                    return -786431;
                }
                ctx.value1 = force22;
                final Object force23 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force23) == null) {
                    return -786430;
                }
                ctx.value2 = force23;
                final Object force24 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force24) != null) {
                    ctx.value3 = force24;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 52: {
                final Object force25 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force25) == null) {
                    return -786431;
                }
                ctx.value1 = force25;
                final Object force26 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force26) == null) {
                    return -786430;
                }
                ctx.value2 = force26;
                final Object force27 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force27) != null) {
                    ctx.value3 = force27;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 51: {
                final Object force28 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force28) == null) {
                    return -786431;
                }
                ctx.value1 = force28;
                final Object force29 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force29) == null) {
                    return -786430;
                }
                ctx.value2 = force29;
                final Object force30 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force30) != null) {
                    ctx.value3 = force30;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 50: {
                final Object force31 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force31) == null) {
                    return -786431;
                }
                ctx.value1 = force31;
                final Object force32 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force32) == null) {
                    return -786430;
                }
                ctx.value2 = force32;
                final Object force33 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force33) != null) {
                    ctx.value3 = force33;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 49: {
                final Object force34 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force34) == null) {
                    return -786431;
                }
                ctx.value1 = force34;
                final Object force35 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force35) == null) {
                    return -786430;
                }
                ctx.value2 = force35;
                final Object force36 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force36) != null) {
                    ctx.value3 = force36;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 36: {
                final Object force37 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force37) == null) {
                    return -786431;
                }
                ctx.value1 = force37;
                final Object force38 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force38) == null) {
                    return -786430;
                }
                ctx.value2 = force38;
                final Object force39 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force39) != null) {
                    ctx.value3 = force39;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 35: {
                final Object force40 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force40) == null) {
                    return -786431;
                }
                ctx.value1 = force40;
                final Object force41 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force41) == null) {
                    return -786430;
                }
                ctx.value2 = force41;
                final Object force42 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force42) != null) {
                    ctx.value3 = force42;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 34: {
                final Object force43 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force43) == null) {
                    return -786431;
                }
                ctx.value1 = force43;
                final Object force44 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force44) == null) {
                    return -786430;
                }
                ctx.value2 = force44;
                final Object force45 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force45) != null) {
                    ctx.value3 = force45;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 33: {
                final Object force46 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force46) == null) {
                    return -786431;
                }
                ctx.value1 = force46;
                final Object force47 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force47) == null) {
                    return -786430;
                }
                ctx.value2 = force47;
                final Object force48 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force48) != null) {
                    ctx.value3 = force48;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 32: {
                final Object force49 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force49) == null) {
                    return -786431;
                }
                ctx.value1 = force49;
                final Object force50 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force50) == null) {
                    return -786430;
                }
                ctx.value2 = force50;
                final Object force51 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force51) != null) {
                    ctx.value3 = force51;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 31: {
                final Object force52 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force52) == null) {
                    return -786431;
                }
                ctx.value1 = force52;
                final Object force53 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force53) == null) {
                    return -786430;
                }
                ctx.value2 = force53;
                final Object force54 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force54) != null) {
                    ctx.value3 = force54;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 30: {
                final Object force55 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force55) == null) {
                    return -786431;
                }
                ctx.value1 = force55;
                final Object force56 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force56) == null) {
                    return -786430;
                }
                ctx.value2 = force56;
                final Object force57 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force57) != null) {
                    ctx.value3 = force57;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 29: {
                final Object force58 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force58) == null) {
                    return -786431;
                }
                ctx.value1 = force58;
                final Object force59 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force59) == null) {
                    return -786430;
                }
                ctx.value2 = force59;
                final Object force60 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force60) != null) {
                    ctx.value3 = force60;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 28: {
                final Object force61 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force61) == null) {
                    return -786431;
                }
                ctx.value1 = force61;
                final Object force62 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force62) == null) {
                    return -786430;
                }
                ctx.value2 = force62;
                final Object force63 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force63) != null) {
                    ctx.value3 = force63;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 27: {
                final Object force64 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force64) == null) {
                    return -786431;
                }
                ctx.value1 = force64;
                final Object force65 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force65) == null) {
                    return -786430;
                }
                ctx.value2 = force65;
                final Object force66 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force66) != null) {
                    ctx.value3 = force66;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 26: {
                final Object force67 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force67) == null) {
                    return -786431;
                }
                ctx.value1 = force67;
                final Object force68 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force68) == null) {
                    return -786430;
                }
                ctx.value2 = force68;
                final Object force69 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force69) != null) {
                    ctx.value3 = force69;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 25: {
                final Object force70 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force70) == null) {
                    return -786431;
                }
                ctx.value1 = force70;
                final Object force71 = Promise.force(arg2, RealNum.class);
                if (RealNum.asRealNumOrNull(force71) == null) {
                    return -786430;
                }
                ctx.value2 = force71;
                final Object force72 = Promise.force(arg3, RealNum.class);
                if (RealNum.asRealNumOrNull(force72) != null) {
                    ctx.value3 = force72;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            default: {
                return super.match3(proc, arg1, arg2, arg3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        if (moduleMethod.selector != 9) {
            return super.match4(moduleMethod, o, o2, o3, o4, ctx);
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
        if (RealNum.asRealNumOrNull(force3) == null) {
            return -786429;
        }
        ctx.value3 = force3;
        final Object force4 = Promise.force(o4, RealNum.class);
        if (RealNum.asRealNumOrNull(force4) != null) {
            ctx.value4 = force4;
            ctx.proc = moduleMethod;
            ctx.pc = 4;
            return 0;
        }
        return -786428;
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
        //                6: 256
        //                7: 269
        //                8: 283
        //                9: 296
        //               10: 309
        //               11: 686
        //               12: 686
        //               13: 322
        //               14: 335
        //               15: 348
        //               16: 361
        //               17: 374
        //               18: 387
        //               19: 400
        //               20: 413
        //               21: 426
        //               22: 439
        //               23: 452
        //               24: 465
        //               25: 478
        //               26: 491
        //               27: 504
        //               28: 686
        //               29: 686
        //               30: 686
        //               31: 686
        //               32: 686
        //               33: 686
        //               34: 686
        //               35: 686
        //               36: 686
        //               37: 686
        //               38: 686
        //               39: 686
        //               40: 517
        //               41: 530
        //               42: 543
        //               43: 556
        //               44: 569
        //               45: 582
        //               46: 595
        //               47: 608
        //               48: 621
        //               49: 634
        //               50: 647
        //               51: 660
        //               52: 686
        //               53: 686
        //               54: 686
        //               55: 686
        //               56: 686
        //               57: 686
        //               58: 686
        //               59: 686
        //               60: 686
        //               61: 686
        //               62: 686
        //               63: 686
        //               64: 673
        //          default: 686
        //        }
        //   256: aload_2        
        //   257: ldc             Lgnu/math/Quaternion;.class
        //   259: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   262: checkcast       Lgnu/math/Quaternion;
        //   265: invokestatic    kawa/lib/kawa/rotations.quaternion$To$RotationMatrix:(Lgnu/math/Quaternion;)Lgnu/lists/Array;
        //   268: areturn        
        //   269: aload_2        
        //   270: ldc_w           Lgnu/lists/Array;.class
        //   273: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   276: checkcast       Lgnu/lists/Array;
        //   279: invokestatic    kawa/lib/kawa/rotations.rotationMatrix$To$Quaternion:(Lgnu/lists/Array;)Lgnu/math/Quaternion;
        //   282: areturn        
        //   283: aload_2        
        //   284: ldc             Lgnu/math/Quaternion;.class
        //   286: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   289: checkcast       Lgnu/math/Quaternion;
        //   292: invokestatic    kawa/lib/kawa/rotations.rotationAxis:(Lgnu/math/Quaternion;)Lgnu/math/Quaternion;
        //   295: areturn        
        //   296: aload_2        
        //   297: ldc             Lgnu/math/Quaternion;.class
        //   299: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   302: checkcast       Lgnu/math/Quaternion;
        //   305: invokestatic    kawa/lib/kawa/rotations.rotationAngle:(Lgnu/math/Quaternion;)Lgnu/math/RealNum;
        //   308: areturn        
        //   309: aload_2        
        //   310: ldc             Lgnu/math/Quaternion;.class
        //   312: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   315: checkcast       Lgnu/math/Quaternion;
        //   318: invokestatic    kawa/lib/kawa/rotations.rotationAxis$SlAngle:(Lgnu/math/Quaternion;)Lgnu/mapping/Values;
        //   321: areturn        
        //   322: aload_2        
        //   323: ldc             Lgnu/math/RealNum;.class
        //   325: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   328: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   331: invokestatic    kawa/lib/kawa/rotations.rotx:(Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   334: areturn        
        //   335: aload_2        
        //   336: ldc             Lgnu/math/RealNum;.class
        //   338: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   341: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   344: invokestatic    kawa/lib/kawa/rotations.roty:(Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   347: areturn        
        //   348: aload_2        
        //   349: ldc             Lgnu/math/RealNum;.class
        //   351: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   354: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   357: invokestatic    kawa/lib/kawa/rotations.rotz:(Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   360: areturn        
        //   361: aload_2        
        //   362: ldc             Lgnu/math/Quaternion;.class
        //   364: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   367: checkcast       Lgnu/math/Quaternion;
        //   370: invokestatic    kawa/lib/kawa/rotations.intrinsicXyx:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //   373: areturn        
        //   374: aload_2        
        //   375: ldc             Lgnu/math/Quaternion;.class
        //   377: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   380: checkcast       Lgnu/math/Quaternion;
        //   383: invokestatic    kawa/lib/kawa/rotations.intrinsicXzx:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //   386: areturn        
        //   387: aload_2        
        //   388: ldc             Lgnu/math/Quaternion;.class
        //   390: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   393: checkcast       Lgnu/math/Quaternion;
        //   396: invokestatic    kawa/lib/kawa/rotations.intrinsicYxy:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //   399: areturn        
        //   400: aload_2        
        //   401: ldc             Lgnu/math/Quaternion;.class
        //   403: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   406: checkcast       Lgnu/math/Quaternion;
        //   409: invokestatic    kawa/lib/kawa/rotations.intrinsicYzy:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //   412: areturn        
        //   413: aload_2        
        //   414: ldc             Lgnu/math/Quaternion;.class
        //   416: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   419: checkcast       Lgnu/math/Quaternion;
        //   422: invokestatic    kawa/lib/kawa/rotations.intrinsicZxz:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //   425: areturn        
        //   426: aload_2        
        //   427: ldc             Lgnu/math/Quaternion;.class
        //   429: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   432: checkcast       Lgnu/math/Quaternion;
        //   435: invokestatic    kawa/lib/kawa/rotations.intrinsicZyz:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //   438: areturn        
        //   439: aload_2        
        //   440: ldc             Lgnu/math/Quaternion;.class
        //   442: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   445: checkcast       Lgnu/math/Quaternion;
        //   448: invokestatic    kawa/lib/kawa/rotations.intrinsicXyz:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //   451: areturn        
        //   452: aload_2        
        //   453: ldc             Lgnu/math/Quaternion;.class
        //   455: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   458: checkcast       Lgnu/math/Quaternion;
        //   461: invokestatic    kawa/lib/kawa/rotations.intrinsicXzy:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //   464: areturn        
        //   465: aload_2        
        //   466: ldc             Lgnu/math/Quaternion;.class
        //   468: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   471: checkcast       Lgnu/math/Quaternion;
        //   474: invokestatic    kawa/lib/kawa/rotations.intrinsicYxz:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //   477: areturn        
        //   478: aload_2        
        //   479: ldc             Lgnu/math/Quaternion;.class
        //   481: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   484: checkcast       Lgnu/math/Quaternion;
        //   487: invokestatic    kawa/lib/kawa/rotations.intrinsicYzx:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //   490: areturn        
        //   491: aload_2        
        //   492: ldc             Lgnu/math/Quaternion;.class
        //   494: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   497: checkcast       Lgnu/math/Quaternion;
        //   500: invokestatic    kawa/lib/kawa/rotations.intrinsicZxy:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //   503: areturn        
        //   504: aload_2        
        //   505: ldc             Lgnu/math/Quaternion;.class
        //   507: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   510: checkcast       Lgnu/math/Quaternion;
        //   513: invokestatic    kawa/lib/kawa/rotations.intrinsicZyx:(Lgnu/math/Quaternion;)Ljava/lang/Object;
        //   516: areturn        
        //   517: aload_2        
        //   518: ldc             Lgnu/math/Quaternion;.class
        //   520: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   523: checkcast       Lgnu/math/Quaternion;
        //   526: invokestatic    kawa/lib/kawa/rotations.extrinsicXyx:(Lgnu/math/Quaternion;)Lgnu/mapping/Values;
        //   529: areturn        
        //   530: aload_2        
        //   531: ldc             Lgnu/math/Quaternion;.class
        //   533: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   536: checkcast       Lgnu/math/Quaternion;
        //   539: invokestatic    kawa/lib/kawa/rotations.extrinsicXyz:(Lgnu/math/Quaternion;)Lgnu/mapping/Values;
        //   542: areturn        
        //   543: aload_2        
        //   544: ldc             Lgnu/math/Quaternion;.class
        //   546: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   549: checkcast       Lgnu/math/Quaternion;
        //   552: invokestatic    kawa/lib/kawa/rotations.extrinsicXzx:(Lgnu/math/Quaternion;)Lgnu/mapping/Values;
        //   555: areturn        
        //   556: aload_2        
        //   557: ldc             Lgnu/math/Quaternion;.class
        //   559: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   562: checkcast       Lgnu/math/Quaternion;
        //   565: invokestatic    kawa/lib/kawa/rotations.extrinsicXzy:(Lgnu/math/Quaternion;)Lgnu/mapping/Values;
        //   568: areturn        
        //   569: aload_2        
        //   570: ldc             Lgnu/math/Quaternion;.class
        //   572: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   575: checkcast       Lgnu/math/Quaternion;
        //   578: invokestatic    kawa/lib/kawa/rotations.extrinsicYxy:(Lgnu/math/Quaternion;)Lgnu/mapping/Values;
        //   581: areturn        
        //   582: aload_2        
        //   583: ldc             Lgnu/math/Quaternion;.class
        //   585: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   588: checkcast       Lgnu/math/Quaternion;
        //   591: invokestatic    kawa/lib/kawa/rotations.extrinsicYxz:(Lgnu/math/Quaternion;)Lgnu/mapping/Values;
        //   594: areturn        
        //   595: aload_2        
        //   596: ldc             Lgnu/math/Quaternion;.class
        //   598: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   601: checkcast       Lgnu/math/Quaternion;
        //   604: invokestatic    kawa/lib/kawa/rotations.extrinsicYzx:(Lgnu/math/Quaternion;)Lgnu/mapping/Values;
        //   607: areturn        
        //   608: aload_2        
        //   609: ldc             Lgnu/math/Quaternion;.class
        //   611: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   614: checkcast       Lgnu/math/Quaternion;
        //   617: invokestatic    kawa/lib/kawa/rotations.extrinsicYzy:(Lgnu/math/Quaternion;)Lgnu/mapping/Values;
        //   620: areturn        
        //   621: aload_2        
        //   622: ldc             Lgnu/math/Quaternion;.class
        //   624: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   627: checkcast       Lgnu/math/Quaternion;
        //   630: invokestatic    kawa/lib/kawa/rotations.extrinsicZxy:(Lgnu/math/Quaternion;)Lgnu/mapping/Values;
        //   633: areturn        
        //   634: aload_2        
        //   635: ldc             Lgnu/math/Quaternion;.class
        //   637: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   640: checkcast       Lgnu/math/Quaternion;
        //   643: invokestatic    kawa/lib/kawa/rotations.extrinsicZxz:(Lgnu/math/Quaternion;)Lgnu/mapping/Values;
        //   646: areturn        
        //   647: aload_2        
        //   648: ldc             Lgnu/math/Quaternion;.class
        //   650: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   653: checkcast       Lgnu/math/Quaternion;
        //   656: invokestatic    kawa/lib/kawa/rotations.extrinsicZyx:(Lgnu/math/Quaternion;)Lgnu/mapping/Values;
        //   659: areturn        
        //   660: aload_2        
        //   661: ldc             Lgnu/math/Quaternion;.class
        //   663: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   666: checkcast       Lgnu/math/Quaternion;
        //   669: invokestatic    kawa/lib/kawa/rotations.extrinsicZyz:(Lgnu/math/Quaternion;)Lgnu/mapping/Values;
        //   672: areturn        
        //   673: aload_2        
        //   674: ldc             Lgnu/math/Quaternion;.class
        //   676: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   679: checkcast       Lgnu/math/Quaternion;
        //   682: invokestatic    kawa/lib/kawa/rotations.makeRotationProcedure:(Lgnu/math/Quaternion;)Lgnu/mapping/Procedure;
        //   685: areturn        
        //   686: aload_0        
        //   687: aload_1        
        //   688: aload_2        
        //   689: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   692: areturn        
        //   693: new             Lgnu/mapping/WrongType;
        //   696: dup_x1         
        //   697: swap           
        //   698: ldc_w           "quaternion->rotation-matrix"
        //   701: iconst_1       
        //   702: aload_2        
        //   703: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   706: athrow         
        //   707: new             Lgnu/mapping/WrongType;
        //   710: dup_x1         
        //   711: swap           
        //   712: ldc_w           "rotation-matrix->quaternion"
        //   715: iconst_1       
        //   716: aload_2        
        //   717: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   720: athrow         
        //   721: new             Lgnu/mapping/WrongType;
        //   724: dup_x1         
        //   725: swap           
        //   726: ldc_w           "rotation-axis"
        //   729: iconst_1       
        //   730: aload_2        
        //   731: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   734: athrow         
        //   735: new             Lgnu/mapping/WrongType;
        //   738: dup_x1         
        //   739: swap           
        //   740: ldc_w           "rotation-angle"
        //   743: iconst_1       
        //   744: aload_2        
        //   745: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   748: athrow         
        //   749: new             Lgnu/mapping/WrongType;
        //   752: dup_x1         
        //   753: swap           
        //   754: ldc_w           "rotation-axis/angle"
        //   757: iconst_1       
        //   758: aload_2        
        //   759: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   762: athrow         
        //   763: new             Lgnu/mapping/WrongType;
        //   766: dup_x1         
        //   767: swap           
        //   768: ldc_w           "rotx"
        //   771: iconst_1       
        //   772: aload_2        
        //   773: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   776: athrow         
        //   777: new             Lgnu/mapping/WrongType;
        //   780: dup_x1         
        //   781: swap           
        //   782: ldc_w           "roty"
        //   785: iconst_1       
        //   786: aload_2        
        //   787: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   790: athrow         
        //   791: new             Lgnu/mapping/WrongType;
        //   794: dup_x1         
        //   795: swap           
        //   796: ldc_w           "rotz"
        //   799: iconst_1       
        //   800: aload_2        
        //   801: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   804: athrow         
        //   805: new             Lgnu/mapping/WrongType;
        //   808: dup_x1         
        //   809: swap           
        //   810: ldc_w           "intrinsic-xyx"
        //   813: iconst_1       
        //   814: aload_2        
        //   815: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   818: athrow         
        //   819: new             Lgnu/mapping/WrongType;
        //   822: dup_x1         
        //   823: swap           
        //   824: ldc_w           "intrinsic-xzx"
        //   827: iconst_1       
        //   828: aload_2        
        //   829: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   832: athrow         
        //   833: new             Lgnu/mapping/WrongType;
        //   836: dup_x1         
        //   837: swap           
        //   838: ldc_w           "intrinsic-yxy"
        //   841: iconst_1       
        //   842: aload_2        
        //   843: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   846: athrow         
        //   847: new             Lgnu/mapping/WrongType;
        //   850: dup_x1         
        //   851: swap           
        //   852: ldc_w           "intrinsic-yzy"
        //   855: iconst_1       
        //   856: aload_2        
        //   857: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   860: athrow         
        //   861: new             Lgnu/mapping/WrongType;
        //   864: dup_x1         
        //   865: swap           
        //   866: ldc_w           "intrinsic-zxz"
        //   869: iconst_1       
        //   870: aload_2        
        //   871: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   874: athrow         
        //   875: new             Lgnu/mapping/WrongType;
        //   878: dup_x1         
        //   879: swap           
        //   880: ldc_w           "intrinsic-zyz"
        //   883: iconst_1       
        //   884: aload_2        
        //   885: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   888: athrow         
        //   889: new             Lgnu/mapping/WrongType;
        //   892: dup_x1         
        //   893: swap           
        //   894: ldc_w           "intrinsic-xyz"
        //   897: iconst_1       
        //   898: aload_2        
        //   899: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   902: athrow         
        //   903: new             Lgnu/mapping/WrongType;
        //   906: dup_x1         
        //   907: swap           
        //   908: ldc_w           "intrinsic-xzy"
        //   911: iconst_1       
        //   912: aload_2        
        //   913: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   916: athrow         
        //   917: new             Lgnu/mapping/WrongType;
        //   920: dup_x1         
        //   921: swap           
        //   922: ldc_w           "intrinsic-yxz"
        //   925: iconst_1       
        //   926: aload_2        
        //   927: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   930: athrow         
        //   931: new             Lgnu/mapping/WrongType;
        //   934: dup_x1         
        //   935: swap           
        //   936: ldc_w           "intrinsic-yzx"
        //   939: iconst_1       
        //   940: aload_2        
        //   941: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   944: athrow         
        //   945: new             Lgnu/mapping/WrongType;
        //   948: dup_x1         
        //   949: swap           
        //   950: ldc_w           "intrinsic-zxy"
        //   953: iconst_1       
        //   954: aload_2        
        //   955: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   958: athrow         
        //   959: new             Lgnu/mapping/WrongType;
        //   962: dup_x1         
        //   963: swap           
        //   964: ldc_w           "intrinsic-zyx"
        //   967: iconst_1       
        //   968: aload_2        
        //   969: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   972: athrow         
        //   973: new             Lgnu/mapping/WrongType;
        //   976: dup_x1         
        //   977: swap           
        //   978: ldc_w           "extrinsic-xyx"
        //   981: iconst_1       
        //   982: aload_2        
        //   983: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   986: athrow         
        //   987: new             Lgnu/mapping/WrongType;
        //   990: dup_x1         
        //   991: swap           
        //   992: ldc_w           "extrinsic-xyz"
        //   995: iconst_1       
        //   996: aload_2        
        //   997: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1000: athrow         
        //  1001: new             Lgnu/mapping/WrongType;
        //  1004: dup_x1         
        //  1005: swap           
        //  1006: ldc_w           "extrinsic-xzx"
        //  1009: iconst_1       
        //  1010: aload_2        
        //  1011: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1014: athrow         
        //  1015: new             Lgnu/mapping/WrongType;
        //  1018: dup_x1         
        //  1019: swap           
        //  1020: ldc_w           "extrinsic-xzy"
        //  1023: iconst_1       
        //  1024: aload_2        
        //  1025: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1028: athrow         
        //  1029: new             Lgnu/mapping/WrongType;
        //  1032: dup_x1         
        //  1033: swap           
        //  1034: ldc_w           "extrinsic-yxy"
        //  1037: iconst_1       
        //  1038: aload_2        
        //  1039: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1042: athrow         
        //  1043: new             Lgnu/mapping/WrongType;
        //  1046: dup_x1         
        //  1047: swap           
        //  1048: ldc_w           "extrinsic-yxz"
        //  1051: iconst_1       
        //  1052: aload_2        
        //  1053: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1056: athrow         
        //  1057: new             Lgnu/mapping/WrongType;
        //  1060: dup_x1         
        //  1061: swap           
        //  1062: ldc_w           "extrinsic-yzx"
        //  1065: iconst_1       
        //  1066: aload_2        
        //  1067: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1070: athrow         
        //  1071: new             Lgnu/mapping/WrongType;
        //  1074: dup_x1         
        //  1075: swap           
        //  1076: ldc_w           "extrinsic-yzy"
        //  1079: iconst_1       
        //  1080: aload_2        
        //  1081: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1084: athrow         
        //  1085: new             Lgnu/mapping/WrongType;
        //  1088: dup_x1         
        //  1089: swap           
        //  1090: ldc_w           "extrinsic-zxy"
        //  1093: iconst_1       
        //  1094: aload_2        
        //  1095: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1098: athrow         
        //  1099: new             Lgnu/mapping/WrongType;
        //  1102: dup_x1         
        //  1103: swap           
        //  1104: ldc_w           "extrinsic-zxz"
        //  1107: iconst_1       
        //  1108: aload_2        
        //  1109: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1112: athrow         
        //  1113: new             Lgnu/mapping/WrongType;
        //  1116: dup_x1         
        //  1117: swap           
        //  1118: ldc_w           "extrinsic-zyx"
        //  1121: iconst_1       
        //  1122: aload_2        
        //  1123: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1126: athrow         
        //  1127: new             Lgnu/mapping/WrongType;
        //  1130: dup_x1         
        //  1131: swap           
        //  1132: ldc_w           "extrinsic-zyz"
        //  1135: iconst_1       
        //  1136: aload_2        
        //  1137: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1140: athrow         
        //  1141: new             Lgnu/mapping/WrongType;
        //  1144: dup_x1         
        //  1145: swap           
        //  1146: ldc_w           "make-rotation-procedure"
        //  1149: iconst_1       
        //  1150: aload_2        
        //  1151: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1154: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  262    265    693    707    Ljava/lang/ClassCastException;
        //  276    279    707    721    Ljava/lang/ClassCastException;
        //  289    292    721    735    Ljava/lang/ClassCastException;
        //  302    305    735    749    Ljava/lang/ClassCastException;
        //  315    318    749    763    Ljava/lang/ClassCastException;
        //  328    331    763    777    Ljava/lang/ClassCastException;
        //  341    344    777    791    Ljava/lang/ClassCastException;
        //  354    357    791    805    Ljava/lang/ClassCastException;
        //  367    370    805    819    Ljava/lang/ClassCastException;
        //  380    383    819    833    Ljava/lang/ClassCastException;
        //  393    396    833    847    Ljava/lang/ClassCastException;
        //  406    409    847    861    Ljava/lang/ClassCastException;
        //  419    422    861    875    Ljava/lang/ClassCastException;
        //  432    435    875    889    Ljava/lang/ClassCastException;
        //  445    448    889    903    Ljava/lang/ClassCastException;
        //  458    461    903    917    Ljava/lang/ClassCastException;
        //  471    474    917    931    Ljava/lang/ClassCastException;
        //  484    487    931    945    Ljava/lang/ClassCastException;
        //  497    500    945    959    Ljava/lang/ClassCastException;
        //  510    513    959    973    Ljava/lang/ClassCastException;
        //  523    526    973    987    Ljava/lang/ClassCastException;
        //  536    539    987    1001   Ljava/lang/ClassCastException;
        //  549    552    1001   1015   Ljava/lang/ClassCastException;
        //  562    565    1015   1029   Ljava/lang/ClassCastException;
        //  575    578    1029   1043   Ljava/lang/ClassCastException;
        //  588    591    1043   1057   Ljava/lang/ClassCastException;
        //  601    604    1057   1071   Ljava/lang/ClassCastException;
        //  614    617    1071   1085   Ljava/lang/ClassCastException;
        //  627    630    1085   1099   Ljava/lang/ClassCastException;
        //  640    643    1099   1113   Ljava/lang/ClassCastException;
        //  653    656    1113   1127   Ljava/lang/ClassCastException;
        //  666    669    1127   1141   Ljava/lang/ClassCastException;
        //  679    682    1141   1155   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 470 out of bounds for length 470
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
        //                2: 40
        //                8: 68
        //               62: 46
        //          default: 90
        //        }
        //    40: aload_2        
        //    41: aload_3        
        //    42: invokestatic    kawa/lib/kawa/rotations.lambda1:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    45: areturn        
        //    46: aload_2        
        //    47: ldc             Lgnu/math/Quaternion;.class
        //    49: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    52: checkcast       Lgnu/math/Quaternion;
        //    55: aload_3        
        //    56: ldc             Lgnu/math/Quaternion;.class
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    61: checkcast       Lgnu/math/Quaternion;
        //    64: invokestatic    kawa/lib/kawa/rotations.rotateVector:(Lgnu/math/Quaternion;Lgnu/math/Quaternion;)Lgnu/math/Quaternion;
        //    67: areturn        
        //    68: aload_2        
        //    69: ldc             Lgnu/math/Quaternion;.class
        //    71: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    74: checkcast       Lgnu/math/Quaternion;
        //    77: aload_3        
        //    78: ldc             Lgnu/math/RealNum;.class
        //    80: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    83: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    86: invokestatic    kawa/lib/kawa/rotations.makeAxis$SlAngle:(Lgnu/math/Quaternion;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //    89: areturn        
        //    90: aload_0        
        //    91: aload_1        
        //    92: aload_2        
        //    93: aload_3        
        //    94: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    97: areturn        
        //    98: new             Lgnu/mapping/WrongType;
        //   101: dup_x1         
        //   102: swap           
        //   103: ldc_w           "rotate-vector"
        //   106: iconst_1       
        //   107: aload_2        
        //   108: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   111: athrow         
        //   112: new             Lgnu/mapping/WrongType;
        //   115: dup_x1         
        //   116: swap           
        //   117: ldc_w           "rotate-vector"
        //   120: iconst_2       
        //   121: aload_3        
        //   122: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   125: athrow         
        //   126: new             Lgnu/mapping/WrongType;
        //   129: dup_x1         
        //   130: swap           
        //   131: ldc_w           "make-axis/angle"
        //   134: iconst_1       
        //   135: aload_2        
        //   136: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   139: athrow         
        //   140: new             Lgnu/mapping/WrongType;
        //   143: dup_x1         
        //   144: swap           
        //   145: ldc_w           "make-axis/angle"
        //   148: iconst_2       
        //   149: aload_3        
        //   150: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   153: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  52     55     98     112    Ljava/lang/ClassCastException;
        //  61     64     112    126    Ljava/lang/ClassCastException;
        //  74     77     126    140    Ljava/lang/ClassCastException;
        //  83     86     140    154    Ljava/lang/ClassCastException;
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
        //     4: tableswitch {
        //               50: 164
        //               51: 196
        //               52: 228
        //               53: 260
        //               54: 292
        //               55: 324
        //               56: 356
        //               57: 388
        //               58: 420
        //               59: 452
        //               60: 484
        //               61: 516
        //               62: 932
        //               63: 932
        //               64: 932
        //               65: 932
        //               66: 932
        //               67: 932
        //               68: 932
        //               69: 932
        //               70: 932
        //               71: 932
        //               72: 932
        //               73: 932
        //               74: 548
        //               75: 580
        //               76: 612
        //               77: 644
        //               78: 676
        //               79: 708
        //               80: 740
        //               81: 772
        //               82: 804
        //               83: 836
        //               84: 868
        //               85: 900
        //          default: 932
        //        }
        //   164: aload_2        
        //   165: ldc             Lgnu/math/RealNum;.class
        //   167: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   170: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   173: aload_3        
        //   174: ldc             Lgnu/math/RealNum;.class
        //   176: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   179: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   182: aload           4
        //   184: ldc             Lgnu/math/RealNum;.class
        //   186: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   189: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   192: invokestatic    kawa/lib/kawa/rotations.makeIntrinsicXyx:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   195: areturn        
        //   196: aload_2        
        //   197: ldc             Lgnu/math/RealNum;.class
        //   199: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   202: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   205: aload_3        
        //   206: ldc             Lgnu/math/RealNum;.class
        //   208: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   211: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   214: aload           4
        //   216: ldc             Lgnu/math/RealNum;.class
        //   218: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   221: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   224: invokestatic    kawa/lib/kawa/rotations.makeIntrinsicXzx:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   227: areturn        
        //   228: aload_2        
        //   229: ldc             Lgnu/math/RealNum;.class
        //   231: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   234: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   237: aload_3        
        //   238: ldc             Lgnu/math/RealNum;.class
        //   240: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   243: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   246: aload           4
        //   248: ldc             Lgnu/math/RealNum;.class
        //   250: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   253: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   256: invokestatic    kawa/lib/kawa/rotations.makeIntrinsicYxy:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   259: areturn        
        //   260: aload_2        
        //   261: ldc             Lgnu/math/RealNum;.class
        //   263: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   266: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   269: aload_3        
        //   270: ldc             Lgnu/math/RealNum;.class
        //   272: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   275: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   278: aload           4
        //   280: ldc             Lgnu/math/RealNum;.class
        //   282: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   285: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   288: invokestatic    kawa/lib/kawa/rotations.makeIntrinsicYzy:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   291: areturn        
        //   292: aload_2        
        //   293: ldc             Lgnu/math/RealNum;.class
        //   295: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   298: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   301: aload_3        
        //   302: ldc             Lgnu/math/RealNum;.class
        //   304: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   307: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   310: aload           4
        //   312: ldc             Lgnu/math/RealNum;.class
        //   314: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   317: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   320: invokestatic    kawa/lib/kawa/rotations.makeIntrinsicZxz:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   323: areturn        
        //   324: aload_2        
        //   325: ldc             Lgnu/math/RealNum;.class
        //   327: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   330: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   333: aload_3        
        //   334: ldc             Lgnu/math/RealNum;.class
        //   336: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   339: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   342: aload           4
        //   344: ldc             Lgnu/math/RealNum;.class
        //   346: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   349: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   352: invokestatic    kawa/lib/kawa/rotations.makeIntrinsicZyz:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   355: areturn        
        //   356: aload_2        
        //   357: ldc             Lgnu/math/RealNum;.class
        //   359: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   362: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   365: aload_3        
        //   366: ldc             Lgnu/math/RealNum;.class
        //   368: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   371: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   374: aload           4
        //   376: ldc             Lgnu/math/RealNum;.class
        //   378: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   381: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   384: invokestatic    kawa/lib/kawa/rotations.makeIntrinsicXyz:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   387: areturn        
        //   388: aload_2        
        //   389: ldc             Lgnu/math/RealNum;.class
        //   391: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   394: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   397: aload_3        
        //   398: ldc             Lgnu/math/RealNum;.class
        //   400: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   403: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   406: aload           4
        //   408: ldc             Lgnu/math/RealNum;.class
        //   410: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   413: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   416: invokestatic    kawa/lib/kawa/rotations.makeIntrinsicXzy:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   419: areturn        
        //   420: aload_2        
        //   421: ldc             Lgnu/math/RealNum;.class
        //   423: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   426: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   429: aload_3        
        //   430: ldc             Lgnu/math/RealNum;.class
        //   432: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   435: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   438: aload           4
        //   440: ldc             Lgnu/math/RealNum;.class
        //   442: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   445: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   448: invokestatic    kawa/lib/kawa/rotations.makeIntrinsicYxz:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   451: areturn        
        //   452: aload_2        
        //   453: ldc             Lgnu/math/RealNum;.class
        //   455: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   458: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   461: aload_3        
        //   462: ldc             Lgnu/math/RealNum;.class
        //   464: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   467: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   470: aload           4
        //   472: ldc             Lgnu/math/RealNum;.class
        //   474: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   477: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   480: invokestatic    kawa/lib/kawa/rotations.makeIntrinsicYzx:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   483: areturn        
        //   484: aload_2        
        //   485: ldc             Lgnu/math/RealNum;.class
        //   487: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   490: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   493: aload_3        
        //   494: ldc             Lgnu/math/RealNum;.class
        //   496: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   499: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   502: aload           4
        //   504: ldc             Lgnu/math/RealNum;.class
        //   506: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   509: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   512: invokestatic    kawa/lib/kawa/rotations.makeIntrinsicZxy:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   515: areturn        
        //   516: aload_2        
        //   517: ldc             Lgnu/math/RealNum;.class
        //   519: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   522: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   525: aload_3        
        //   526: ldc             Lgnu/math/RealNum;.class
        //   528: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   531: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   534: aload           4
        //   536: ldc             Lgnu/math/RealNum;.class
        //   538: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   541: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   544: invokestatic    kawa/lib/kawa/rotations.makeIntrinsicZyx:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   547: areturn        
        //   548: aload_2        
        //   549: ldc             Lgnu/math/RealNum;.class
        //   551: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   554: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   557: aload_3        
        //   558: ldc             Lgnu/math/RealNum;.class
        //   560: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   563: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   566: aload           4
        //   568: ldc             Lgnu/math/RealNum;.class
        //   570: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   573: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   576: invokestatic    kawa/lib/kawa/rotations.makeExtrinsicXyx:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   579: areturn        
        //   580: aload_2        
        //   581: ldc             Lgnu/math/RealNum;.class
        //   583: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   586: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   589: aload_3        
        //   590: ldc             Lgnu/math/RealNum;.class
        //   592: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   595: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   598: aload           4
        //   600: ldc             Lgnu/math/RealNum;.class
        //   602: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   605: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   608: invokestatic    kawa/lib/kawa/rotations.makeExtrinsicXyz:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   611: areturn        
        //   612: aload_2        
        //   613: ldc             Lgnu/math/RealNum;.class
        //   615: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   618: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   621: aload_3        
        //   622: ldc             Lgnu/math/RealNum;.class
        //   624: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   627: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   630: aload           4
        //   632: ldc             Lgnu/math/RealNum;.class
        //   634: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   637: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   640: invokestatic    kawa/lib/kawa/rotations.makeExtrinsicXzx:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   643: areturn        
        //   644: aload_2        
        //   645: ldc             Lgnu/math/RealNum;.class
        //   647: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   650: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   653: aload_3        
        //   654: ldc             Lgnu/math/RealNum;.class
        //   656: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   659: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   662: aload           4
        //   664: ldc             Lgnu/math/RealNum;.class
        //   666: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   669: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   672: invokestatic    kawa/lib/kawa/rotations.makeExtrinsicXzy:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   675: areturn        
        //   676: aload_2        
        //   677: ldc             Lgnu/math/RealNum;.class
        //   679: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   682: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   685: aload_3        
        //   686: ldc             Lgnu/math/RealNum;.class
        //   688: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   691: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   694: aload           4
        //   696: ldc             Lgnu/math/RealNum;.class
        //   698: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   701: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   704: invokestatic    kawa/lib/kawa/rotations.makeExtrinsicYxy:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   707: areturn        
        //   708: aload_2        
        //   709: ldc             Lgnu/math/RealNum;.class
        //   711: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   714: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   717: aload_3        
        //   718: ldc             Lgnu/math/RealNum;.class
        //   720: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   723: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   726: aload           4
        //   728: ldc             Lgnu/math/RealNum;.class
        //   730: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   733: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   736: invokestatic    kawa/lib/kawa/rotations.makeExtrinsicYxz:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   739: areturn        
        //   740: aload_2        
        //   741: ldc             Lgnu/math/RealNum;.class
        //   743: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   746: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   749: aload_3        
        //   750: ldc             Lgnu/math/RealNum;.class
        //   752: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   755: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   758: aload           4
        //   760: ldc             Lgnu/math/RealNum;.class
        //   762: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   765: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   768: invokestatic    kawa/lib/kawa/rotations.makeExtrinsicYzx:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   771: areturn        
        //   772: aload_2        
        //   773: ldc             Lgnu/math/RealNum;.class
        //   775: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   778: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   781: aload_3        
        //   782: ldc             Lgnu/math/RealNum;.class
        //   784: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   787: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   790: aload           4
        //   792: ldc             Lgnu/math/RealNum;.class
        //   794: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   797: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   800: invokestatic    kawa/lib/kawa/rotations.makeExtrinsicYzy:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   803: areturn        
        //   804: aload_2        
        //   805: ldc             Lgnu/math/RealNum;.class
        //   807: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   810: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   813: aload_3        
        //   814: ldc             Lgnu/math/RealNum;.class
        //   816: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   819: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   822: aload           4
        //   824: ldc             Lgnu/math/RealNum;.class
        //   826: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   829: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   832: invokestatic    kawa/lib/kawa/rotations.makeExtrinsicZxy:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   835: areturn        
        //   836: aload_2        
        //   837: ldc             Lgnu/math/RealNum;.class
        //   839: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   842: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   845: aload_3        
        //   846: ldc             Lgnu/math/RealNum;.class
        //   848: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   851: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   854: aload           4
        //   856: ldc             Lgnu/math/RealNum;.class
        //   858: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   861: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   864: invokestatic    kawa/lib/kawa/rotations.makeExtrinsicZxz:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   867: areturn        
        //   868: aload_2        
        //   869: ldc             Lgnu/math/RealNum;.class
        //   871: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   874: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   877: aload_3        
        //   878: ldc             Lgnu/math/RealNum;.class
        //   880: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   883: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   886: aload           4
        //   888: ldc             Lgnu/math/RealNum;.class
        //   890: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   893: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   896: invokestatic    kawa/lib/kawa/rotations.makeExtrinsicZyx:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   899: areturn        
        //   900: aload_2        
        //   901: ldc             Lgnu/math/RealNum;.class
        //   903: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   906: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   909: aload_3        
        //   910: ldc             Lgnu/math/RealNum;.class
        //   912: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   915: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   918: aload           4
        //   920: ldc             Lgnu/math/RealNum;.class
        //   922: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   925: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   928: invokestatic    kawa/lib/kawa/rotations.makeExtrinsicZyz:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //   931: areturn        
        //   932: aload_0        
        //   933: aload_1        
        //   934: aload_2        
        //   935: aload_3        
        //   936: aload           4
        //   938: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   941: areturn        
        //   942: new             Lgnu/mapping/WrongType;
        //   945: dup_x1         
        //   946: swap           
        //   947: ldc_w           "make-intrinsic-xyx"
        //   950: iconst_1       
        //   951: aload_2        
        //   952: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   955: athrow         
        //   956: new             Lgnu/mapping/WrongType;
        //   959: dup_x1         
        //   960: swap           
        //   961: ldc_w           "make-intrinsic-xyx"
        //   964: iconst_2       
        //   965: aload_3        
        //   966: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   969: athrow         
        //   970: new             Lgnu/mapping/WrongType;
        //   973: dup_x1         
        //   974: swap           
        //   975: ldc_w           "make-intrinsic-xyx"
        //   978: iconst_3       
        //   979: aload           4
        //   981: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   984: athrow         
        //   985: new             Lgnu/mapping/WrongType;
        //   988: dup_x1         
        //   989: swap           
        //   990: ldc_w           "make-intrinsic-xzx"
        //   993: iconst_1       
        //   994: aload_2        
        //   995: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   998: athrow         
        //   999: new             Lgnu/mapping/WrongType;
        //  1002: dup_x1         
        //  1003: swap           
        //  1004: ldc_w           "make-intrinsic-xzx"
        //  1007: iconst_2       
        //  1008: aload_3        
        //  1009: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1012: athrow         
        //  1013: new             Lgnu/mapping/WrongType;
        //  1016: dup_x1         
        //  1017: swap           
        //  1018: ldc_w           "make-intrinsic-xzx"
        //  1021: iconst_3       
        //  1022: aload           4
        //  1024: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1027: athrow         
        //  1028: new             Lgnu/mapping/WrongType;
        //  1031: dup_x1         
        //  1032: swap           
        //  1033: ldc_w           "make-intrinsic-yxy"
        //  1036: iconst_1       
        //  1037: aload_2        
        //  1038: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1041: athrow         
        //  1042: new             Lgnu/mapping/WrongType;
        //  1045: dup_x1         
        //  1046: swap           
        //  1047: ldc_w           "make-intrinsic-yxy"
        //  1050: iconst_2       
        //  1051: aload_3        
        //  1052: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1055: athrow         
        //  1056: new             Lgnu/mapping/WrongType;
        //  1059: dup_x1         
        //  1060: swap           
        //  1061: ldc_w           "make-intrinsic-yxy"
        //  1064: iconst_3       
        //  1065: aload           4
        //  1067: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1070: athrow         
        //  1071: new             Lgnu/mapping/WrongType;
        //  1074: dup_x1         
        //  1075: swap           
        //  1076: ldc_w           "make-intrinsic-yzy"
        //  1079: iconst_1       
        //  1080: aload_2        
        //  1081: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1084: athrow         
        //  1085: new             Lgnu/mapping/WrongType;
        //  1088: dup_x1         
        //  1089: swap           
        //  1090: ldc_w           "make-intrinsic-yzy"
        //  1093: iconst_2       
        //  1094: aload_3        
        //  1095: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1098: athrow         
        //  1099: new             Lgnu/mapping/WrongType;
        //  1102: dup_x1         
        //  1103: swap           
        //  1104: ldc_w           "make-intrinsic-yzy"
        //  1107: iconst_3       
        //  1108: aload           4
        //  1110: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1113: athrow         
        //  1114: new             Lgnu/mapping/WrongType;
        //  1117: dup_x1         
        //  1118: swap           
        //  1119: ldc_w           "make-intrinsic-zxz"
        //  1122: iconst_1       
        //  1123: aload_2        
        //  1124: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1127: athrow         
        //  1128: new             Lgnu/mapping/WrongType;
        //  1131: dup_x1         
        //  1132: swap           
        //  1133: ldc_w           "make-intrinsic-zxz"
        //  1136: iconst_2       
        //  1137: aload_3        
        //  1138: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1141: athrow         
        //  1142: new             Lgnu/mapping/WrongType;
        //  1145: dup_x1         
        //  1146: swap           
        //  1147: ldc_w           "make-intrinsic-zxz"
        //  1150: iconst_3       
        //  1151: aload           4
        //  1153: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1156: athrow         
        //  1157: new             Lgnu/mapping/WrongType;
        //  1160: dup_x1         
        //  1161: swap           
        //  1162: ldc_w           "make-intrinsic-zyz"
        //  1165: iconst_1       
        //  1166: aload_2        
        //  1167: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1170: athrow         
        //  1171: new             Lgnu/mapping/WrongType;
        //  1174: dup_x1         
        //  1175: swap           
        //  1176: ldc_w           "make-intrinsic-zyz"
        //  1179: iconst_2       
        //  1180: aload_3        
        //  1181: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1184: athrow         
        //  1185: new             Lgnu/mapping/WrongType;
        //  1188: dup_x1         
        //  1189: swap           
        //  1190: ldc_w           "make-intrinsic-zyz"
        //  1193: iconst_3       
        //  1194: aload           4
        //  1196: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1199: athrow         
        //  1200: new             Lgnu/mapping/WrongType;
        //  1203: dup_x1         
        //  1204: swap           
        //  1205: ldc_w           "make-intrinsic-xyz"
        //  1208: iconst_1       
        //  1209: aload_2        
        //  1210: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1213: athrow         
        //  1214: new             Lgnu/mapping/WrongType;
        //  1217: dup_x1         
        //  1218: swap           
        //  1219: ldc_w           "make-intrinsic-xyz"
        //  1222: iconst_2       
        //  1223: aload_3        
        //  1224: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1227: athrow         
        //  1228: new             Lgnu/mapping/WrongType;
        //  1231: dup_x1         
        //  1232: swap           
        //  1233: ldc_w           "make-intrinsic-xyz"
        //  1236: iconst_3       
        //  1237: aload           4
        //  1239: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1242: athrow         
        //  1243: new             Lgnu/mapping/WrongType;
        //  1246: dup_x1         
        //  1247: swap           
        //  1248: ldc_w           "make-intrinsic-xzy"
        //  1251: iconst_1       
        //  1252: aload_2        
        //  1253: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1256: athrow         
        //  1257: new             Lgnu/mapping/WrongType;
        //  1260: dup_x1         
        //  1261: swap           
        //  1262: ldc_w           "make-intrinsic-xzy"
        //  1265: iconst_2       
        //  1266: aload_3        
        //  1267: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1270: athrow         
        //  1271: new             Lgnu/mapping/WrongType;
        //  1274: dup_x1         
        //  1275: swap           
        //  1276: ldc_w           "make-intrinsic-xzy"
        //  1279: iconst_3       
        //  1280: aload           4
        //  1282: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1285: athrow         
        //  1286: new             Lgnu/mapping/WrongType;
        //  1289: dup_x1         
        //  1290: swap           
        //  1291: ldc_w           "make-intrinsic-yxz"
        //  1294: iconst_1       
        //  1295: aload_2        
        //  1296: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1299: athrow         
        //  1300: new             Lgnu/mapping/WrongType;
        //  1303: dup_x1         
        //  1304: swap           
        //  1305: ldc_w           "make-intrinsic-yxz"
        //  1308: iconst_2       
        //  1309: aload_3        
        //  1310: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1313: athrow         
        //  1314: new             Lgnu/mapping/WrongType;
        //  1317: dup_x1         
        //  1318: swap           
        //  1319: ldc_w           "make-intrinsic-yxz"
        //  1322: iconst_3       
        //  1323: aload           4
        //  1325: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1328: athrow         
        //  1329: new             Lgnu/mapping/WrongType;
        //  1332: dup_x1         
        //  1333: swap           
        //  1334: ldc_w           "make-intrinsic-yzx"
        //  1337: iconst_1       
        //  1338: aload_2        
        //  1339: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1342: athrow         
        //  1343: new             Lgnu/mapping/WrongType;
        //  1346: dup_x1         
        //  1347: swap           
        //  1348: ldc_w           "make-intrinsic-yzx"
        //  1351: iconst_2       
        //  1352: aload_3        
        //  1353: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1356: athrow         
        //  1357: new             Lgnu/mapping/WrongType;
        //  1360: dup_x1         
        //  1361: swap           
        //  1362: ldc_w           "make-intrinsic-yzx"
        //  1365: iconst_3       
        //  1366: aload           4
        //  1368: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1371: athrow         
        //  1372: new             Lgnu/mapping/WrongType;
        //  1375: dup_x1         
        //  1376: swap           
        //  1377: ldc_w           "make-intrinsic-zxy"
        //  1380: iconst_1       
        //  1381: aload_2        
        //  1382: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1385: athrow         
        //  1386: new             Lgnu/mapping/WrongType;
        //  1389: dup_x1         
        //  1390: swap           
        //  1391: ldc_w           "make-intrinsic-zxy"
        //  1394: iconst_2       
        //  1395: aload_3        
        //  1396: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1399: athrow         
        //  1400: new             Lgnu/mapping/WrongType;
        //  1403: dup_x1         
        //  1404: swap           
        //  1405: ldc_w           "make-intrinsic-zxy"
        //  1408: iconst_3       
        //  1409: aload           4
        //  1411: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1414: athrow         
        //  1415: new             Lgnu/mapping/WrongType;
        //  1418: dup_x1         
        //  1419: swap           
        //  1420: ldc_w           "make-intrinsic-zyx"
        //  1423: iconst_1       
        //  1424: aload_2        
        //  1425: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1428: athrow         
        //  1429: new             Lgnu/mapping/WrongType;
        //  1432: dup_x1         
        //  1433: swap           
        //  1434: ldc_w           "make-intrinsic-zyx"
        //  1437: iconst_2       
        //  1438: aload_3        
        //  1439: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1442: athrow         
        //  1443: new             Lgnu/mapping/WrongType;
        //  1446: dup_x1         
        //  1447: swap           
        //  1448: ldc_w           "make-intrinsic-zyx"
        //  1451: iconst_3       
        //  1452: aload           4
        //  1454: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1457: athrow         
        //  1458: new             Lgnu/mapping/WrongType;
        //  1461: dup_x1         
        //  1462: swap           
        //  1463: ldc_w           "make-extrinsic-xyx"
        //  1466: iconst_1       
        //  1467: aload_2        
        //  1468: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1471: athrow         
        //  1472: new             Lgnu/mapping/WrongType;
        //  1475: dup_x1         
        //  1476: swap           
        //  1477: ldc_w           "make-extrinsic-xyx"
        //  1480: iconst_2       
        //  1481: aload_3        
        //  1482: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1485: athrow         
        //  1486: new             Lgnu/mapping/WrongType;
        //  1489: dup_x1         
        //  1490: swap           
        //  1491: ldc_w           "make-extrinsic-xyx"
        //  1494: iconst_3       
        //  1495: aload           4
        //  1497: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1500: athrow         
        //  1501: new             Lgnu/mapping/WrongType;
        //  1504: dup_x1         
        //  1505: swap           
        //  1506: ldc_w           "make-extrinsic-xyz"
        //  1509: iconst_1       
        //  1510: aload_2        
        //  1511: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1514: athrow         
        //  1515: new             Lgnu/mapping/WrongType;
        //  1518: dup_x1         
        //  1519: swap           
        //  1520: ldc_w           "make-extrinsic-xyz"
        //  1523: iconst_2       
        //  1524: aload_3        
        //  1525: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1528: athrow         
        //  1529: new             Lgnu/mapping/WrongType;
        //  1532: dup_x1         
        //  1533: swap           
        //  1534: ldc_w           "make-extrinsic-xyz"
        //  1537: iconst_3       
        //  1538: aload           4
        //  1540: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1543: athrow         
        //  1544: new             Lgnu/mapping/WrongType;
        //  1547: dup_x1         
        //  1548: swap           
        //  1549: ldc_w           "make-extrinsic-xzx"
        //  1552: iconst_1       
        //  1553: aload_2        
        //  1554: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1557: athrow         
        //  1558: new             Lgnu/mapping/WrongType;
        //  1561: dup_x1         
        //  1562: swap           
        //  1563: ldc_w           "make-extrinsic-xzx"
        //  1566: iconst_2       
        //  1567: aload_3        
        //  1568: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1571: athrow         
        //  1572: new             Lgnu/mapping/WrongType;
        //  1575: dup_x1         
        //  1576: swap           
        //  1577: ldc_w           "make-extrinsic-xzx"
        //  1580: iconst_3       
        //  1581: aload           4
        //  1583: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1586: athrow         
        //  1587: new             Lgnu/mapping/WrongType;
        //  1590: dup_x1         
        //  1591: swap           
        //  1592: ldc_w           "make-extrinsic-xzy"
        //  1595: iconst_1       
        //  1596: aload_2        
        //  1597: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1600: athrow         
        //  1601: new             Lgnu/mapping/WrongType;
        //  1604: dup_x1         
        //  1605: swap           
        //  1606: ldc_w           "make-extrinsic-xzy"
        //  1609: iconst_2       
        //  1610: aload_3        
        //  1611: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1614: athrow         
        //  1615: new             Lgnu/mapping/WrongType;
        //  1618: dup_x1         
        //  1619: swap           
        //  1620: ldc_w           "make-extrinsic-xzy"
        //  1623: iconst_3       
        //  1624: aload           4
        //  1626: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1629: athrow         
        //  1630: new             Lgnu/mapping/WrongType;
        //  1633: dup_x1         
        //  1634: swap           
        //  1635: ldc_w           "make-extrinsic-yxy"
        //  1638: iconst_1       
        //  1639: aload_2        
        //  1640: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1643: athrow         
        //  1644: new             Lgnu/mapping/WrongType;
        //  1647: dup_x1         
        //  1648: swap           
        //  1649: ldc_w           "make-extrinsic-yxy"
        //  1652: iconst_2       
        //  1653: aload_3        
        //  1654: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1657: athrow         
        //  1658: new             Lgnu/mapping/WrongType;
        //  1661: dup_x1         
        //  1662: swap           
        //  1663: ldc_w           "make-extrinsic-yxy"
        //  1666: iconst_3       
        //  1667: aload           4
        //  1669: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1672: athrow         
        //  1673: new             Lgnu/mapping/WrongType;
        //  1676: dup_x1         
        //  1677: swap           
        //  1678: ldc_w           "make-extrinsic-yxz"
        //  1681: iconst_1       
        //  1682: aload_2        
        //  1683: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1686: athrow         
        //  1687: new             Lgnu/mapping/WrongType;
        //  1690: dup_x1         
        //  1691: swap           
        //  1692: ldc_w           "make-extrinsic-yxz"
        //  1695: iconst_2       
        //  1696: aload_3        
        //  1697: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1700: athrow         
        //  1701: new             Lgnu/mapping/WrongType;
        //  1704: dup_x1         
        //  1705: swap           
        //  1706: ldc_w           "make-extrinsic-yxz"
        //  1709: iconst_3       
        //  1710: aload           4
        //  1712: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1715: athrow         
        //  1716: new             Lgnu/mapping/WrongType;
        //  1719: dup_x1         
        //  1720: swap           
        //  1721: ldc_w           "make-extrinsic-yzx"
        //  1724: iconst_1       
        //  1725: aload_2        
        //  1726: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1729: athrow         
        //  1730: new             Lgnu/mapping/WrongType;
        //  1733: dup_x1         
        //  1734: swap           
        //  1735: ldc_w           "make-extrinsic-yzx"
        //  1738: iconst_2       
        //  1739: aload_3        
        //  1740: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1743: athrow         
        //  1744: new             Lgnu/mapping/WrongType;
        //  1747: dup_x1         
        //  1748: swap           
        //  1749: ldc_w           "make-extrinsic-yzx"
        //  1752: iconst_3       
        //  1753: aload           4
        //  1755: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1758: athrow         
        //  1759: new             Lgnu/mapping/WrongType;
        //  1762: dup_x1         
        //  1763: swap           
        //  1764: ldc_w           "make-extrinsic-yzy"
        //  1767: iconst_1       
        //  1768: aload_2        
        //  1769: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1772: athrow         
        //  1773: new             Lgnu/mapping/WrongType;
        //  1776: dup_x1         
        //  1777: swap           
        //  1778: ldc_w           "make-extrinsic-yzy"
        //  1781: iconst_2       
        //  1782: aload_3        
        //  1783: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1786: athrow         
        //  1787: new             Lgnu/mapping/WrongType;
        //  1790: dup_x1         
        //  1791: swap           
        //  1792: ldc_w           "make-extrinsic-yzy"
        //  1795: iconst_3       
        //  1796: aload           4
        //  1798: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1801: athrow         
        //  1802: new             Lgnu/mapping/WrongType;
        //  1805: dup_x1         
        //  1806: swap           
        //  1807: ldc_w           "make-extrinsic-zxy"
        //  1810: iconst_1       
        //  1811: aload_2        
        //  1812: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1815: athrow         
        //  1816: new             Lgnu/mapping/WrongType;
        //  1819: dup_x1         
        //  1820: swap           
        //  1821: ldc_w           "make-extrinsic-zxy"
        //  1824: iconst_2       
        //  1825: aload_3        
        //  1826: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1829: athrow         
        //  1830: new             Lgnu/mapping/WrongType;
        //  1833: dup_x1         
        //  1834: swap           
        //  1835: ldc_w           "make-extrinsic-zxy"
        //  1838: iconst_3       
        //  1839: aload           4
        //  1841: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1844: athrow         
        //  1845: new             Lgnu/mapping/WrongType;
        //  1848: dup_x1         
        //  1849: swap           
        //  1850: ldc_w           "make-extrinsic-zxz"
        //  1853: iconst_1       
        //  1854: aload_2        
        //  1855: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1858: athrow         
        //  1859: new             Lgnu/mapping/WrongType;
        //  1862: dup_x1         
        //  1863: swap           
        //  1864: ldc_w           "make-extrinsic-zxz"
        //  1867: iconst_2       
        //  1868: aload_3        
        //  1869: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1872: athrow         
        //  1873: new             Lgnu/mapping/WrongType;
        //  1876: dup_x1         
        //  1877: swap           
        //  1878: ldc_w           "make-extrinsic-zxz"
        //  1881: iconst_3       
        //  1882: aload           4
        //  1884: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1887: athrow         
        //  1888: new             Lgnu/mapping/WrongType;
        //  1891: dup_x1         
        //  1892: swap           
        //  1893: ldc_w           "make-extrinsic-zyx"
        //  1896: iconst_1       
        //  1897: aload_2        
        //  1898: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1901: athrow         
        //  1902: new             Lgnu/mapping/WrongType;
        //  1905: dup_x1         
        //  1906: swap           
        //  1907: ldc_w           "make-extrinsic-zyx"
        //  1910: iconst_2       
        //  1911: aload_3        
        //  1912: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1915: athrow         
        //  1916: new             Lgnu/mapping/WrongType;
        //  1919: dup_x1         
        //  1920: swap           
        //  1921: ldc_w           "make-extrinsic-zyx"
        //  1924: iconst_3       
        //  1925: aload           4
        //  1927: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1930: athrow         
        //  1931: new             Lgnu/mapping/WrongType;
        //  1934: dup_x1         
        //  1935: swap           
        //  1936: ldc_w           "make-extrinsic-zyz"
        //  1939: iconst_1       
        //  1940: aload_2        
        //  1941: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1944: athrow         
        //  1945: new             Lgnu/mapping/WrongType;
        //  1948: dup_x1         
        //  1949: swap           
        //  1950: ldc_w           "make-extrinsic-zyz"
        //  1953: iconst_2       
        //  1954: aload_3        
        //  1955: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1958: athrow         
        //  1959: new             Lgnu/mapping/WrongType;
        //  1962: dup_x1         
        //  1963: swap           
        //  1964: ldc_w           "make-extrinsic-zyz"
        //  1967: iconst_3       
        //  1968: aload           4
        //  1970: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1973: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  170    173    942    956    Ljava/lang/ClassCastException;
        //  179    182    956    970    Ljava/lang/ClassCastException;
        //  189    192    970    985    Ljava/lang/ClassCastException;
        //  202    205    985    999    Ljava/lang/ClassCastException;
        //  211    214    999    1013   Ljava/lang/ClassCastException;
        //  221    224    1013   1028   Ljava/lang/ClassCastException;
        //  234    237    1028   1042   Ljava/lang/ClassCastException;
        //  243    246    1042   1056   Ljava/lang/ClassCastException;
        //  253    256    1056   1071   Ljava/lang/ClassCastException;
        //  266    269    1071   1085   Ljava/lang/ClassCastException;
        //  275    278    1085   1099   Ljava/lang/ClassCastException;
        //  285    288    1099   1114   Ljava/lang/ClassCastException;
        //  298    301    1114   1128   Ljava/lang/ClassCastException;
        //  307    310    1128   1142   Ljava/lang/ClassCastException;
        //  317    320    1142   1157   Ljava/lang/ClassCastException;
        //  330    333    1157   1171   Ljava/lang/ClassCastException;
        //  339    342    1171   1185   Ljava/lang/ClassCastException;
        //  349    352    1185   1200   Ljava/lang/ClassCastException;
        //  362    365    1200   1214   Ljava/lang/ClassCastException;
        //  371    374    1214   1228   Ljava/lang/ClassCastException;
        //  381    384    1228   1243   Ljava/lang/ClassCastException;
        //  394    397    1243   1257   Ljava/lang/ClassCastException;
        //  403    406    1257   1271   Ljava/lang/ClassCastException;
        //  413    416    1271   1286   Ljava/lang/ClassCastException;
        //  426    429    1286   1300   Ljava/lang/ClassCastException;
        //  435    438    1300   1314   Ljava/lang/ClassCastException;
        //  445    448    1314   1329   Ljava/lang/ClassCastException;
        //  458    461    1329   1343   Ljava/lang/ClassCastException;
        //  467    470    1343   1357   Ljava/lang/ClassCastException;
        //  477    480    1357   1372   Ljava/lang/ClassCastException;
        //  490    493    1372   1386   Ljava/lang/ClassCastException;
        //  499    502    1386   1400   Ljava/lang/ClassCastException;
        //  509    512    1400   1415   Ljava/lang/ClassCastException;
        //  522    525    1415   1429   Ljava/lang/ClassCastException;
        //  531    534    1429   1443   Ljava/lang/ClassCastException;
        //  541    544    1443   1458   Ljava/lang/ClassCastException;
        //  554    557    1458   1472   Ljava/lang/ClassCastException;
        //  563    566    1472   1486   Ljava/lang/ClassCastException;
        //  573    576    1486   1501   Ljava/lang/ClassCastException;
        //  586    589    1501   1515   Ljava/lang/ClassCastException;
        //  595    598    1515   1529   Ljava/lang/ClassCastException;
        //  605    608    1529   1544   Ljava/lang/ClassCastException;
        //  618    621    1544   1558   Ljava/lang/ClassCastException;
        //  627    630    1558   1572   Ljava/lang/ClassCastException;
        //  637    640    1572   1587   Ljava/lang/ClassCastException;
        //  650    653    1587   1601   Ljava/lang/ClassCastException;
        //  659    662    1601   1615   Ljava/lang/ClassCastException;
        //  669    672    1615   1630   Ljava/lang/ClassCastException;
        //  682    685    1630   1644   Ljava/lang/ClassCastException;
        //  691    694    1644   1658   Ljava/lang/ClassCastException;
        //  701    704    1658   1673   Ljava/lang/ClassCastException;
        //  714    717    1673   1687   Ljava/lang/ClassCastException;
        //  723    726    1687   1701   Ljava/lang/ClassCastException;
        //  733    736    1701   1716   Ljava/lang/ClassCastException;
        //  746    749    1716   1730   Ljava/lang/ClassCastException;
        //  755    758    1730   1744   Ljava/lang/ClassCastException;
        //  765    768    1744   1759   Ljava/lang/ClassCastException;
        //  778    781    1759   1773   Ljava/lang/ClassCastException;
        //  787    790    1773   1787   Ljava/lang/ClassCastException;
        //  797    800    1787   1802   Ljava/lang/ClassCastException;
        //  810    813    1802   1816   Ljava/lang/ClassCastException;
        //  819    822    1816   1830   Ljava/lang/ClassCastException;
        //  829    832    1830   1845   Ljava/lang/ClassCastException;
        //  842    845    1845   1859   Ljava/lang/ClassCastException;
        //  851    854    1859   1873   Ljava/lang/ClassCastException;
        //  861    864    1873   1888   Ljava/lang/ClassCastException;
        //  874    877    1888   1902   Ljava/lang/ClassCastException;
        //  883    886    1902   1916   Ljava/lang/ClassCastException;
        //  893    896    1916   1931   Ljava/lang/ClassCastException;
        //  906    909    1931   1945   Ljava/lang/ClassCastException;
        //  915    918    1945   1959   Ljava/lang/ClassCastException;
        //  925    928    1959   1974   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 922 out of bounds for length 922
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
        //     4: bipush          9
        //     6: if_icmpne       54
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
        //    40: aload           5
        //    42: ldc             Lgnu/math/RealNum;.class
        //    44: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    47: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //    50: invokestatic    kawa/lib/kawa/rotations.makeAxis$SlAngle:(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
        //    53: areturn        
        //    54: aload_0        
        //    55: aload_1        
        //    56: aload_2        
        //    57: aload_3        
        //    58: aload           4
        //    60: aload           5
        //    62: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    65: areturn        
        //    66: new             Lgnu/mapping/WrongType;
        //    69: dup_x1         
        //    70: swap           
        //    71: ldc_w           "make-axis/angle"
        //    74: iconst_1       
        //    75: aload_2        
        //    76: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    79: athrow         
        //    80: new             Lgnu/mapping/WrongType;
        //    83: dup_x1         
        //    84: swap           
        //    85: ldc_w           "make-axis/angle"
        //    88: iconst_2       
        //    89: aload_3        
        //    90: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    93: athrow         
        //    94: new             Lgnu/mapping/WrongType;
        //    97: dup_x1         
        //    98: swap           
        //    99: ldc_w           "make-axis/angle"
        //   102: iconst_3       
        //   103: aload           4
        //   105: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   108: athrow         
        //   109: new             Lgnu/mapping/WrongType;
        //   112: dup_x1         
        //   113: swap           
        //   114: ldc_w           "make-axis/angle"
        //   117: iconst_4       
        //   118: aload           5
        //   120: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   123: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  18     21     66     80     Ljava/lang/ClassCastException;
        //  27     30     80     94     Ljava/lang/ClassCastException;
        //  37     40     94     109    Ljava/lang/ClassCastException;
        //  47     50     109    124    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 63 out of bounds for length 63
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
