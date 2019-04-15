/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.kawa;

import gnu.bytecode.Type;
import gnu.expr.GenericProc;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.ArrayRef;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Array;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.F64Vector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.CComplex;
import gnu.math.DFloNum;
import gnu.math.IntFraction;
import gnu.math.IntNum;
import gnu.math.Quaternion;
import gnu.math.RealNum;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.arrays;
import kawa.lib.exceptions;
import kawa.lib.kawa.quaternions;
import kawa.lib.numbers;

public class rotations
extends ModuleBody {
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
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static Array quaternion$To$RotationMatrix(Quaternion q) {
        double r;
        double j2;
        double k2;
        double i2;
        Number uq = quaternions.unitQuaternion(q);
        Number number = numbers.realPart(uq);
        try {
            r = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "r", -2, (Object)i2);
        }
        Number number2 = numbers.imagPart(uq);
        try {
            i2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void j2;
            throw new WrongType(classCastException, "i", -2, (Object)j2);
        }
        Number number3 = numbers.jmagPart(uq);
        try {
            j2 = number3.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void k2;
            throw new WrongType(classCastException, "j", -2, (Object)k2);
        }
        Number number4 = numbers.kmagPart(uq);
        try {
            k2 = number4.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "k", -2, (Object)number4);
        }
        F64Vector f64Vector = new F64Vector();
        f64Vector.add(Math.min(Math.max(r * r + i2 * i2 - (j2 * j2 + k2 * k2), (double)-1), 1.0));
        f64Vector.add(Math.min(Math.max((double)2 * (i2 * j2 - r * k2), (double)-1), 1.0));
        f64Vector.add(Math.min(Math.max((double)2 * (i2 * k2 + r * j2), (double)-1), 1.0));
        f64Vector.add(Math.min(Math.max((double)2 * (i2 * j2 + r * k2), (double)-1), 1.0));
        f64Vector.add(Math.min(Math.max(r * r + j2 * j2 - (i2 * i2 + k2 * k2), (double)-1), 1.0));
        f64Vector.add(Math.min(Math.max((double)2 * (j2 * k2 - r * i2), (double)-1), 1.0));
        f64Vector.add(Math.min(Math.max((double)2 * (i2 * k2 - r * j2), (double)-1), 1.0));
        f64Vector.add(Math.min(Math.max((double)2 * (r * i2 + j2 * k2), (double)-1), 1.0));
        f64Vector.add(Math.min(Math.max(r * r + k2 * k2 - (i2 * i2 + j2 * j2), (double)-1), 1.0));
        return arrays.shareArray(f64Vector, arrays.shape(Lit0, Lit1, Lit0, Lit1), lambda$Fn1);
    }

    static Object lambda1(Object i, Object j) {
        return AddOp.apply2(1, ((Procedure)MultiplyOp.$St).apply2(Lit1, i), j);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Quaternion rotationMatrix$To$Quaternion(Array m) {
        Object object4;
        Object s;
        Object object2;
        Object object3;
        void m11;
        void m00;
        Quaternion quaternion;
        Object object6 = ((Procedure)ArrayRef.arrayRef).apply3(m, Lit0, Lit0);
        Object object7 = ((Procedure)ArrayRef.arrayRef).apply3(m, Lit2, Lit2);
        Object m22 = ((Procedure)ArrayRef.arrayRef).apply3(m, Lit3, Lit3);
        Object trace2 = AddOp.apply2(1, AddOp.apply2(1, AddOp.apply2(1, m00, m11), m22), Lit2);
        if (NumberCompare.$Gr(trace2, Lit4)) {
            object4 = Promise.force(trace2, Number.class);
            Object s2 = ((Procedure)DivideOp.$Sl).apply2(Lit5, numbers.sqrt((Number)object4));
            quaternion = (Quaternion)Promise.force(((Procedure)numbers.make$Mnrectangular).apply4(((Procedure)DivideOp.$Sl).apply2(Lit6, s2), ((Procedure)MultiplyOp.$St).apply2(s2, AddOp.apply2(-1, ((Procedure)ArrayRef.arrayRef).apply3(m, Lit3, Lit2), ((Procedure)ArrayRef.arrayRef).apply3(m, Lit2, Lit3))), ((Procedure)MultiplyOp.$St).apply2(s2, AddOp.apply2(-1, ((Procedure)ArrayRef.arrayRef).apply3(m, Lit0, Lit3), ((Procedure)ArrayRef.arrayRef).apply3(m, Lit3, Lit0))), ((Procedure)MultiplyOp.$St).apply2(s2, AddOp.apply2(-1, ((Procedure)ArrayRef.arrayRef).apply3(m, Lit2, Lit0), ((Procedure)ArrayRef.arrayRef).apply3(m, Lit0, Lit2)))), Quaternion.class);
            return quaternion;
        }
        if (NumberCompare.$Gr(m00, m11) && NumberCompare.$Gr(m00, m22)) {
            object3 = Promise.force(AddOp.apply2(1, AddOp.apply2(1, AddOp.apply2(1, Lit2, m00), ((Procedure)AddOp.$Mn).apply1(m11)), ((Procedure)AddOp.$Mn).apply1(m22)), Number.class);
            Object s3 = ((Procedure)MultiplyOp.$St).apply2(Lit3, numbers.sqrt((Number)object3));
            quaternion = (Quaternion)Promise.force(((Procedure)numbers.make$Mnrectangular).apply4(((Procedure)DivideOp.$Sl).apply2(AddOp.apply2(-1, ((Procedure)ArrayRef.arrayRef).apply3(m, Lit3, Lit2), ((Procedure)ArrayRef.arrayRef).apply3(m, Lit2, Lit3)), s3), ((Procedure)MultiplyOp.$St).apply2(Lit7, s3), ((Procedure)DivideOp.$Sl).apply2(AddOp.apply2(1, ((Procedure)ArrayRef.arrayRef).apply3(m, Lit0, Lit2), ((Procedure)ArrayRef.arrayRef).apply3(m, Lit2, Lit0)), s3), ((Procedure)DivideOp.$Sl).apply2(AddOp.apply2(1, ((Procedure)ArrayRef.arrayRef).apply3(m, Lit0, Lit3), ((Procedure)ArrayRef.arrayRef).apply3(m, Lit3, Lit0)), s3)), Quaternion.class);
            return quaternion;
        }
        if (NumberCompare.$Gr(m11, m22)) {
            object2 = Promise.force(AddOp.apply2(1, AddOp.apply2(1, AddOp.apply2(1, Lit2, m11), ((Procedure)AddOp.$Mn).apply1(m00)), ((Procedure)AddOp.$Mn).apply1(m22)), Number.class);
            Object s4 = ((Procedure)MultiplyOp.$St).apply2(Lit3, numbers.sqrt((Number)object2));
            quaternion = (Quaternion)Promise.force(((Procedure)numbers.make$Mnrectangular).apply4(((Procedure)DivideOp.$Sl).apply2(AddOp.apply2(-1, ((Procedure)ArrayRef.arrayRef).apply3(m, Lit0, Lit3), ((Procedure)ArrayRef.arrayRef).apply3(m, Lit3, Lit0)), s4), ((Procedure)DivideOp.$Sl).apply2(AddOp.apply2(1, ((Procedure)ArrayRef.arrayRef).apply3(m, Lit0, Lit2), ((Procedure)ArrayRef.arrayRef).apply3(m, Lit2, Lit0)), s4), ((Procedure)MultiplyOp.$St).apply2(Lit8, s4), ((Procedure)DivideOp.$Sl).apply2(AddOp.apply2(1, ((Procedure)ArrayRef.arrayRef).apply3(m, Lit2, Lit3), ((Procedure)ArrayRef.arrayRef).apply3(m, Lit3, Lit2)), s4)), Quaternion.class);
            return quaternion;
        }
        Object object5 = Promise.force(AddOp.apply2(1, AddOp.apply2(1, AddOp.apply2(1, Lit2, m22), ((Procedure)AddOp.$Mn).apply1(m00)), ((Procedure)AddOp.$Mn).apply1(m11)), Number.class);
        try {
            s = ((Procedure)MultiplyOp.$St).apply2(Lit3, numbers.sqrt((Number)object5));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "sqrt", 1, object5);
        }
        quaternion = (Quaternion)Promise.force(((Procedure)numbers.make$Mnrectangular).apply4(((Procedure)DivideOp.$Sl).apply2(AddOp.apply2(-1, ((Procedure)ArrayRef.arrayRef).apply3(m, Lit2, Lit0), ((Procedure)ArrayRef.arrayRef).apply3(m, Lit0, Lit2)), s), ((Procedure)DivideOp.$Sl).apply2(AddOp.apply2(1, ((Procedure)ArrayRef.arrayRef).apply3(m, Lit0, Lit3), ((Procedure)ArrayRef.arrayRef).apply3(m, Lit3, Lit0)), s), ((Procedure)DivideOp.$Sl).apply2(AddOp.apply2(1, ((Procedure)ArrayRef.arrayRef).apply3(m, Lit2, Lit3), ((Procedure)ArrayRef.arrayRef).apply3(m, Lit3, Lit2)), s), ((Procedure)MultiplyOp.$St).apply2(Lit9, s)), Quaternion.class);
        return quaternion;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "sqrt", 1, object4);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "sqrt", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "sqrt", 1, object2);
        }
    }

    public static Quaternion rotationAxis(Quaternion q) {
        Quaternion u = numbers.unitVector(q);
        return NumberCompare.$Eq(Lit0, u) ? Lit10 : u;
    }

    public static RealNum rotationAngle(Quaternion q) {
        return LangObjType.coerceRealNum(Promise.force(((Procedure)MultiplyOp.$St).apply2(Lit3, ((Procedure)numbers.atan).apply2(numbers.magnitude(quaternions.vectorPart(q)), numbers.realPart(q))), RealNum.class));
    }

    public static Values rotationAxis$SlAngle(Quaternion q) {
        return Values.values2(rotations.rotationAxis(q), rotations.rotationAngle(q));
    }

    public static Quaternion rotx(RealNum angle) {
        RealNum halfangle = RealNum.divide(angle, Lit3);
        return (Quaternion)Promise.force(((Procedure)numbers.make$Mnrectangular).apply2(((Procedure)numbers.cos).apply1(halfangle), ((Procedure)numbers.sin).apply1(halfangle)), Quaternion.class);
    }

    public static Quaternion roty(RealNum angle) {
        RealNum halfangle = RealNum.divide(angle, Lit3);
        return (Quaternion)Promise.force(((Procedure)numbers.make$Mnrectangular).apply4(((Procedure)numbers.cos).apply1(halfangle), Lit0, ((Procedure)numbers.sin).apply1(halfangle), Lit0), Quaternion.class);
    }

    public static Quaternion rotz(RealNum angle) {
        RealNum halfangle = RealNum.divide(angle, Lit3);
        return (Quaternion)Promise.force(((Procedure)numbers.make$Mnrectangular).apply4(((Procedure)numbers.cos).apply1(halfangle), Lit0, Lit0, ((Procedure)numbers.sin).apply1(halfangle)), Quaternion.class);
    }

    public static Object intrinsicXyx(Quaternion q) {
        double r;
        double j2;
        Number beta;
        double k2;
        double i2;
        Number uq = quaternions.unitQuaternion(q);
        Number number = numbers.realPart(uq);
        try {
            r = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "r", -2, (Object)i2);
        }
        Number number2 = numbers.imagPart(uq);
        try {
            i2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void j2;
            throw new WrongType(classCastException, "i", -2, (Object)j2);
        }
        Number number3 = numbers.jmagPart(uq);
        try {
            j2 = number3.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void k2;
            throw new WrongType(classCastException, "j", -2, (Object)k2);
        }
        Number number4 = numbers.kmagPart(uq);
        try {
            k2 = number4.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "k", -2, (Object)beta);
        }
        beta = numbers.acos(Math.min(Math.max(r * r + i2 * i2 - (j2 * j2 + k2 * k2), (double)-1), 1.0));
        boolean x = NumberCompare.$Ls(beta, Lit4);
        return (x ? x : NumberCompare.$Gr(beta, Math.PI - 1.0E-12)) ? Values.makeFromArray(Lit11, beta, ((Procedure)numbers.atan).apply2(-Math.min(Math.max((double)2 * (j2 * k2 - r * i2), (double)-1), 1.0), Math.min(Math.max(r * r + j2 * j2 - (i2 * i2 + k2 * k2), (double)-1), 1.0))) : Values.makeFromArray(((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * j2 + r * k2), (double)-1), 1.0), -Math.min(Math.max((double)2 * (i2 * k2 - r * j2), (double)-1), 1.0)), beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * j2 - r * k2), (double)-1), 1.0), Math.min(Math.max((double)2 * (i2 * k2 + r * j2), (double)-1), 1.0)));
    }

    public static Object intrinsicXzx(Quaternion q) {
        double r;
        double j2;
        Number beta;
        double k2;
        double i2;
        Number uq = quaternions.unitQuaternion(q);
        Number number = numbers.realPart(uq);
        try {
            r = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "r", -2, (Object)i2);
        }
        Number number2 = numbers.imagPart(uq);
        try {
            i2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void j2;
            throw new WrongType(classCastException, "i", -2, (Object)j2);
        }
        Number number3 = numbers.jmagPart(uq);
        try {
            j2 = number3.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void k2;
            throw new WrongType(classCastException, "j", -2, (Object)k2);
        }
        Number number4 = numbers.kmagPart(uq);
        try {
            k2 = number4.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "k", -2, (Object)beta);
        }
        beta = numbers.acos(Math.min(Math.max(r * r + i2 * i2 - (j2 * j2 + k2 * k2), (double)-1), 1.0));
        boolean x = NumberCompare.$Ls(beta, Lit4);
        return (x ? x : NumberCompare.$Gr(beta, Math.PI - 1.0E-12)) ? Values.makeFromArray(Lit11, beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (r * i2 + j2 * k2), (double)-1), 1.0), Math.min(Math.max(r * r + k2 * k2 - (i2 * i2 + j2 * j2), (double)-1), 1.0))) : Values.makeFromArray(((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * k2 - r * j2), (double)-1), 1.0), Math.min(Math.max((double)2 * (i2 * j2 + r * k2), (double)-1), 1.0)), beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * k2 + r * j2), (double)-1), 1.0), -Math.min(Math.max((double)2 * (i2 * j2 - r * k2), (double)-1), 1.0)));
    }

    public static Object intrinsicYxy(Quaternion q) {
        double r;
        double j2;
        Number beta;
        double k2;
        double i2;
        Number uq = quaternions.unitQuaternion(q);
        Number number = numbers.realPart(uq);
        try {
            r = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "r", -2, (Object)i2);
        }
        Number number2 = numbers.imagPart(uq);
        try {
            i2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void j2;
            throw new WrongType(classCastException, "i", -2, (Object)j2);
        }
        Number number3 = numbers.jmagPart(uq);
        try {
            j2 = number3.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void k2;
            throw new WrongType(classCastException, "j", -2, (Object)k2);
        }
        Number number4 = numbers.kmagPart(uq);
        try {
            k2 = number4.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "k", -2, (Object)beta);
        }
        beta = numbers.acos(Math.min(Math.max(r * r + j2 * j2 - (i2 * i2 + k2 * k2), (double)-1), 1.0));
        boolean x = NumberCompare.$Ls(beta, Lit4);
        return (x ? x : NumberCompare.$Gr(beta, Math.PI - 1.0E-12)) ? Values.makeFromArray(Lit11, beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * k2 + r * j2), (double)-1), 1.0), Math.min(Math.max(r * r + i2 * i2 - (j2 * j2 + k2 * k2), (double)-1), 1.0))) : Values.makeFromArray(((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * j2 - r * k2), (double)-1), 1.0), Math.min(Math.max((double)2 * (r * i2 + j2 * k2), (double)-1), 1.0)), beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * j2 + r * k2), (double)-1), 1.0), -Math.min(Math.max((double)2 * (j2 * k2 - r * i2), (double)-1), 1.0)));
    }

    public static Object intrinsicYzy(Quaternion q) {
        double r;
        double j2;
        Number beta;
        double k2;
        double i2;
        Number uq = quaternions.unitQuaternion(q);
        Number number = numbers.realPart(uq);
        try {
            r = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "r", -2, (Object)i2);
        }
        Number number2 = numbers.imagPart(uq);
        try {
            i2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void j2;
            throw new WrongType(classCastException, "i", -2, (Object)j2);
        }
        Number number3 = numbers.jmagPart(uq);
        try {
            j2 = number3.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void k2;
            throw new WrongType(classCastException, "j", -2, (Object)k2);
        }
        Number number4 = numbers.kmagPart(uq);
        try {
            k2 = number4.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "k", -2, (Object)beta);
        }
        beta = numbers.acos(Math.min(Math.max(r * r + j2 * j2 - (i2 * i2 + k2 * k2), (double)-1), 1.0));
        boolean x = NumberCompare.$Ls(beta, Lit4);
        return (x ? x : NumberCompare.$Gr(beta, Math.PI - 1.0E-12)) ? Values.makeFromArray(Lit11, beta, ((Procedure)numbers.atan).apply2(-Math.min(Math.max((double)2 * (i2 * k2 - r * j2), (double)-1), 1.0), Math.min(Math.max(r * r + k2 * k2 - (i2 * i2 + j2 * j2), (double)-1), 1.0))) : Values.makeFromArray(((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (r * i2 + j2 * k2), (double)-1), 1.0), -Math.min(Math.max((double)2 * (i2 * j2 - r * k2), (double)-1), 1.0)), beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (j2 * k2 - r * i2), (double)-1), 1.0), Math.min(Math.max((double)2 * (i2 * j2 + r * k2), (double)-1), 1.0)));
    }

    public static Object intrinsicZxz(Quaternion q) {
        double r;
        double j2;
        Number beta;
        double k2;
        double i2;
        Number uq = quaternions.unitQuaternion(q);
        Number number = numbers.realPart(uq);
        try {
            r = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "r", -2, (Object)i2);
        }
        Number number2 = numbers.imagPart(uq);
        try {
            i2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void j2;
            throw new WrongType(classCastException, "i", -2, (Object)j2);
        }
        Number number3 = numbers.jmagPart(uq);
        try {
            j2 = number3.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void k2;
            throw new WrongType(classCastException, "j", -2, (Object)k2);
        }
        Number number4 = numbers.kmagPart(uq);
        try {
            k2 = number4.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "k", -2, (Object)beta);
        }
        beta = numbers.acos(Math.min(Math.max(r * r + k2 * k2 - (i2 * i2 + j2 * j2), (double)-1), 1.0));
        boolean x = NumberCompare.$Ls(beta, Lit4);
        return (x ? x : NumberCompare.$Gr(beta, Math.PI - 1.0E-12)) ? Values.makeFromArray(Lit11, beta, ((Procedure)numbers.atan).apply2(-Math.min(Math.max((double)2 * (i2 * j2 - r * k2), (double)-1), 1.0), Math.min(Math.max(r * r + i2 * i2 - (j2 * j2 + k2 * k2), (double)-1), 1.0))) : Values.makeFromArray(((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * k2 + r * j2), (double)-1), 1.0), -Math.min(Math.max((double)2 * (j2 * k2 - r * i2), (double)-1), 1.0)), beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * k2 - r * j2), (double)-1), 1.0), Math.min(Math.max((double)2 * (r * i2 + j2 * k2), (double)-1), 1.0)));
    }

    public static Object intrinsicZyz(Quaternion q) {
        double r;
        double j2;
        Number beta;
        double k2;
        double i2;
        Number uq = quaternions.unitQuaternion(q);
        Number number = numbers.realPart(uq);
        try {
            r = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "r", -2, (Object)i2);
        }
        Number number2 = numbers.imagPart(uq);
        try {
            i2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void j2;
            throw new WrongType(classCastException, "i", -2, (Object)j2);
        }
        Number number3 = numbers.jmagPart(uq);
        try {
            j2 = number3.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void k2;
            throw new WrongType(classCastException, "j", -2, (Object)k2);
        }
        Number number4 = numbers.kmagPart(uq);
        try {
            k2 = number4.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "k", -2, (Object)beta);
        }
        beta = numbers.acos(Math.min(Math.max(r * r + k2 * k2 - (i2 * i2 + j2 * j2), (double)-1), 1.0));
        boolean x = NumberCompare.$Ls(beta, Lit4);
        return (x ? x : NumberCompare.$Gr(beta, Math.PI - 1.0E-12)) ? Values.makeFromArray(Lit11, beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * j2 + r * k2), (double)-1), 1.0), Math.min(Math.max(r * r + j2 * j2 - (i2 * i2 + k2 * k2), (double)-1), 1.0))) : Values.makeFromArray(((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (j2 * k2 - r * i2), (double)-1), 1.0), Math.min(Math.max((double)2 * (i2 * k2 + r * j2), (double)-1), 1.0)), beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (r * i2 + j2 * k2), (double)-1), 1.0), -Math.min(Math.max((double)2 * (i2 * k2 - r * j2), (double)-1), 1.0)));
    }

    public static Object intrinsicXyz(Quaternion q) {
        double r;
        double j2;
        Number beta;
        double k2;
        double i2;
        Number uq = quaternions.unitQuaternion(q);
        Number number = numbers.realPart(uq);
        try {
            r = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "r", -2, (Object)i2);
        }
        Number number2 = numbers.imagPart(uq);
        try {
            i2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void j2;
            throw new WrongType(classCastException, "i", -2, (Object)j2);
        }
        Number number3 = numbers.jmagPart(uq);
        try {
            j2 = number3.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void k2;
            throw new WrongType(classCastException, "j", -2, (Object)k2);
        }
        Number number4 = numbers.kmagPart(uq);
        try {
            k2 = number4.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "k", -2, (Object)beta);
        }
        beta = numbers.asin(Math.min(Math.max((double)2 * (i2 * k2 + r * j2), (double)-1), 1.0));
        return NumberCompare.$Gr(numbers.abs(beta), Math.PI / (double)2 - 1.0E-12) ? Values.makeFromArray(Lit11, beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * j2 + r * k2), (double)-1), 1.0), Math.min(Math.max(r * r + j2 * j2 - (i2 * i2 + k2 * k2), (double)-1), 1.0))) : Values.makeFromArray(((Procedure)numbers.atan).apply2(-Math.min(Math.max((double)2 * (j2 * k2 - r * i2), (double)-1), 1.0), Math.min(Math.max(r * r + k2 * k2 - (i2 * i2 + j2 * j2), (double)-1), 1.0)), beta, ((Procedure)numbers.atan).apply2(-Math.min(Math.max((double)2 * (i2 * j2 - r * k2), (double)-1), 1.0), Math.min(Math.max(r * r + i2 * i2 - (j2 * j2 + k2 * k2), (double)-1), 1.0)));
    }

    public static Object intrinsicXzy(Quaternion q) {
        double r;
        double j2;
        Number beta;
        double k2;
        double i2;
        Number uq = quaternions.unitQuaternion(q);
        Number number = numbers.realPart(uq);
        try {
            r = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "r", -2, (Object)i2);
        }
        Number number2 = numbers.imagPart(uq);
        try {
            i2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void j2;
            throw new WrongType(classCastException, "i", -2, (Object)j2);
        }
        Number number3 = numbers.jmagPart(uq);
        try {
            j2 = number3.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void k2;
            throw new WrongType(classCastException, "j", -2, (Object)k2);
        }
        Number number4 = numbers.kmagPart(uq);
        try {
            k2 = number4.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "k", -2, (Object)beta);
        }
        beta = numbers.asin(-Math.min(Math.max((double)2 * (i2 * j2 - r * k2), (double)-1), 1.0));
        return NumberCompare.$Gr(numbers.abs(beta), Math.PI / (double)2 - 1.0E-12) ? Values.makeFromArray(Lit11, beta, ((Procedure)numbers.atan).apply2(-Math.min(Math.max((double)2 * (i2 * k2 - r * j2), (double)-1), 1.0), Math.min(Math.max(r * r + k2 * k2 - (i2 * i2 + j2 * j2), (double)-1), 1.0))) : Values.makeFromArray(((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (r * i2 + j2 * k2), (double)-1), 1.0), Math.min(Math.max(r * r + j2 * j2 - (i2 * i2 + k2 * k2), (double)-1), 1.0)), beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * k2 + r * j2), (double)-1), 1.0), Math.min(Math.max(r * r + i2 * i2 - (j2 * j2 + k2 * k2), (double)-1), 1.0)));
    }

    public static Object intrinsicYxz(Quaternion q) {
        double r;
        double j2;
        Number beta;
        double k2;
        double i2;
        Number uq = quaternions.unitQuaternion(q);
        Number number = numbers.realPart(uq);
        try {
            r = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "r", -2, (Object)i2);
        }
        Number number2 = numbers.imagPart(uq);
        try {
            i2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void j2;
            throw new WrongType(classCastException, "i", -2, (Object)j2);
        }
        Number number3 = numbers.jmagPart(uq);
        try {
            j2 = number3.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void k2;
            throw new WrongType(classCastException, "j", -2, (Object)k2);
        }
        Number number4 = numbers.kmagPart(uq);
        try {
            k2 = number4.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "k", -2, (Object)beta);
        }
        beta = numbers.asin(-Math.min(Math.max((double)2 * (i2 * j2 - r * k2), (double)-1), 1.0));
        return NumberCompare.$Gr(numbers.abs(beta), Math.PI / (double)2 - 1.0E-12) ? Values.makeFromArray(Lit11, beta, ((Procedure)numbers.atan).apply2(-Math.min(Math.max((double)2 * (i2 * j2 - r * k2), (double)-1), 1.0), Math.min(Math.max(r * r + i2 * i2 - (j2 * j2 + k2 * k2), (double)-1), 1.0))) : Values.makeFromArray(((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * k2 + r * j2), (double)-1), 1.0), Math.min(Math.max(r * r + k2 * k2 - (i2 * i2 + j2 * j2), (double)-1), 1.0)), beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * j2 + r * k2), (double)-1), 1.0), Math.min(Math.max(r * r + j2 * j2 - (i2 * i2 + k2 * k2), (double)-1), 1.0)));
    }

    public static Object intrinsicYzx(Quaternion q) {
        double r;
        double j2;
        Number beta;
        double k2;
        double i2;
        Number uq = quaternions.unitQuaternion(q);
        Number number = numbers.realPart(uq);
        try {
            r = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "r", -2, (Object)i2);
        }
        Number number2 = numbers.imagPart(uq);
        try {
            i2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void j2;
            throw new WrongType(classCastException, "i", -2, (Object)j2);
        }
        Number number3 = numbers.jmagPart(uq);
        try {
            j2 = number3.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void k2;
            throw new WrongType(classCastException, "j", -2, (Object)k2);
        }
        Number number4 = numbers.kmagPart(uq);
        try {
            k2 = number4.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "k", -2, (Object)beta);
        }
        beta = numbers.asin(Math.min(Math.max((double)2 * (i2 * j2 + r * k2), (double)-1), 1.0));
        return NumberCompare.$Gr(numbers.abs(beta), Math.PI / (double)2 - 1.0E-12) ? Values.makeFromArray(Lit11, beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (r * i2 + j2 * k2), (double)-1), 1.0), Math.min(Math.max(r * r + k2 * k2 - (i2 * i2 + j2 * j2), (double)-1), 1.0))) : Values.makeFromArray(((Procedure)numbers.atan).apply2(-Math.min(Math.max((double)2 * (i2 * k2 - r * j2), (double)-1), 1.0), Math.min(Math.max(r * r + i2 * i2 - (j2 * j2 + k2 * k2), (double)-1), 1.0)), beta, ((Procedure)numbers.atan).apply2(-Math.min(Math.max((double)2 * (j2 * k2 - r * i2), (double)-1), 1.0), Math.min(Math.max(r * r + j2 * j2 - (i2 * i2 + k2 * k2), (double)-1), 1.0)));
    }

    public static Object intrinsicZxy(Quaternion q) {
        double r;
        double j2;
        Number beta;
        double k2;
        double i2;
        Number uq = quaternions.unitQuaternion(q);
        Number number = numbers.realPart(uq);
        try {
            r = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "r", -2, (Object)i2);
        }
        Number number2 = numbers.imagPart(uq);
        try {
            i2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void j2;
            throw new WrongType(classCastException, "i", -2, (Object)j2);
        }
        Number number3 = numbers.jmagPart(uq);
        try {
            j2 = number3.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void k2;
            throw new WrongType(classCastException, "j", -2, (Object)k2);
        }
        Number number4 = numbers.kmagPart(uq);
        try {
            k2 = number4.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "k", -2, (Object)beta);
        }
        beta = numbers.asin(Math.min(Math.max((double)2 * (r * i2 + j2 * k2), (double)-1), 1.0));
        return NumberCompare.$Gr(numbers.abs(beta), Math.PI / (double)2 - 1.0E-12) ? Values.makeFromArray(Lit11, beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * k2 + r * j2), (double)-1), 1.0), Math.min(Math.max(r * r + i2 * i2 - (j2 * j2 + k2 * k2), (double)-1), 1.0))) : Values.makeFromArray(((Procedure)numbers.atan).apply2(-Math.min(Math.max((double)2 * (i2 * j2 - r * k2), (double)-1), 1.0), Math.min(Math.max(r * r + j2 * j2 - (i2 * i2 + k2 * k2), (double)-1), 1.0)), beta, ((Procedure)numbers.atan).apply2(-Math.min(Math.max((double)2 * (i2 * k2 - r * j2), (double)-1), 1.0), Math.min(Math.max(r * r + k2 * k2 - (i2 * i2 + j2 * j2), (double)-1), 1.0)));
    }

    public static Object intrinsicZyx(Quaternion q) {
        double r;
        double j2;
        Number beta;
        double k2;
        double i2;
        Number uq = quaternions.unitQuaternion(q);
        Number number = numbers.realPart(uq);
        try {
            r = number.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void i2;
            throw new WrongType(classCastException, "r", -2, (Object)i2);
        }
        Number number2 = numbers.imagPart(uq);
        try {
            i2 = number2.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void j2;
            throw new WrongType(classCastException, "i", -2, (Object)j2);
        }
        Number number3 = numbers.jmagPart(uq);
        try {
            j2 = number3.doubleValue();
        }
        catch (ClassCastException classCastException) {
            void k2;
            throw new WrongType(classCastException, "j", -2, (Object)k2);
        }
        Number number4 = numbers.kmagPart(uq);
        try {
            k2 = number4.doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "k", -2, (Object)beta);
        }
        beta = numbers.asin(-Math.min(Math.max((double)2 * (i2 * k2 - r * j2), (double)-1), 1.0));
        return NumberCompare.$Gr(numbers.abs(beta), Math.PI / (double)2 - 1.0E-12) ? Values.makeFromArray(Lit11, beta, ((Procedure)numbers.atan).apply2(-Math.min(Math.max((double)2 * (j2 * k2 - r * i2), (double)-1), 1.0), Math.min(Math.max(r * r + j2 * j2 - (i2 * i2 + k2 * k2), (double)-1), 1.0))) : Values.makeFromArray(((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (i2 * j2 + r * k2), (double)-1), 1.0), Math.min(Math.max(r * r + i2 * i2 - (j2 * j2 + k2 * k2), (double)-1), 1.0)), beta, ((Procedure)numbers.atan).apply2(Math.min(Math.max((double)2 * (r * i2 + j2 * k2), (double)-1), 1.0), Math.min(Math.max(r * r + k2 * k2 - (i2 * i2 + j2 * j2), (double)-1), 1.0)));
    }

    public static Quaternion makeIntrinsicXyx(RealNum alpha, RealNum beta, RealNum gamma) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotx(alpha), rotations.roty(beta)), rotations.rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeIntrinsicXzx(RealNum alpha, RealNum beta, RealNum gamma) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotx(alpha), rotations.rotz(beta)), rotations.rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeIntrinsicYxy(RealNum alpha, RealNum beta, RealNum gamma) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.roty(alpha), rotations.rotx(beta)), rotations.roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeIntrinsicYzy(RealNum alpha, RealNum beta, RealNum gamma) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.roty(alpha), rotations.rotz(beta)), rotations.roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeIntrinsicZxz(RealNum alpha, RealNum beta, RealNum gamma) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotz(alpha), rotations.rotx(beta)), rotations.rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeIntrinsicZyz(RealNum alpha, RealNum beta, RealNum gamma) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotz(alpha), rotations.roty(beta)), rotations.rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeIntrinsicXyz(RealNum alpha, RealNum beta, RealNum gamma) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotx(alpha), rotations.roty(beta)), rotations.rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeIntrinsicXzy(RealNum alpha, RealNum beta, RealNum gamma) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotx(alpha), rotations.rotz(beta)), rotations.roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeIntrinsicYxz(RealNum alpha, RealNum beta, RealNum gamma) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.roty(alpha), rotations.rotx(beta)), rotations.rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeIntrinsicYzx(RealNum alpha, RealNum beta, RealNum gamma) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.roty(alpha), rotations.rotz(beta)), rotations.rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeIntrinsicZxy(RealNum alpha, RealNum beta, RealNum gamma) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotz(alpha), rotations.rotx(beta)), rotations.roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeIntrinsicZyx(RealNum alpha, RealNum beta, RealNum gamma) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotz(alpha), rotations.roty(beta)), rotations.rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Values extrinsicXyx(Quaternion q) {
        void alpha;
        void beta;
        Object object2 = rotations.intrinsicXyx(q);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object gamma = Values.getFromPosFinal(object2, n);
        return Values.makeFromArray(gamma, beta, alpha);
    }

    public static Values extrinsicXyz(Quaternion q) {
        void alpha;
        void beta;
        Object object2 = rotations.intrinsicZyx(q);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object gamma = Values.getFromPosFinal(object2, n);
        return Values.makeFromArray(gamma, beta, alpha);
    }

    public static Values extrinsicXzx(Quaternion q) {
        void alpha;
        void beta;
        Object object2 = rotations.intrinsicXzx(q);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object gamma = Values.getFromPosFinal(object2, n);
        return Values.makeFromArray(gamma, beta, alpha);
    }

    public static Values extrinsicXzy(Quaternion q) {
        void alpha;
        void beta;
        Object object2 = rotations.intrinsicYzx(q);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object gamma = Values.getFromPosFinal(object2, n);
        return Values.makeFromArray(gamma, beta, alpha);
    }

    public static Values extrinsicYxy(Quaternion q) {
        void alpha;
        void beta;
        Object object2 = rotations.intrinsicYxy(q);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object gamma = Values.getFromPosFinal(object2, n);
        return Values.makeFromArray(gamma, beta, alpha);
    }

    public static Values extrinsicYxz(Quaternion q) {
        void alpha;
        void beta;
        Object object2 = rotations.intrinsicZxy(q);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object gamma = Values.getFromPosFinal(object2, n);
        return Values.makeFromArray(gamma, beta, alpha);
    }

    public static Values extrinsicYzx(Quaternion q) {
        void alpha;
        void beta;
        Object object2 = rotations.intrinsicXzy(q);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object gamma = Values.getFromPosFinal(object2, n);
        return Values.makeFromArray(gamma, beta, alpha);
    }

    public static Values extrinsicYzy(Quaternion q) {
        void alpha;
        void beta;
        Object object2 = rotations.intrinsicYzy(q);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object gamma = Values.getFromPosFinal(object2, n);
        return Values.makeFromArray(gamma, beta, alpha);
    }

    public static Values extrinsicZxy(Quaternion q) {
        void alpha;
        void beta;
        Object object2 = rotations.intrinsicYxz(q);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object gamma = Values.getFromPosFinal(object2, n);
        return Values.makeFromArray(gamma, beta, alpha);
    }

    public static Values extrinsicZxz(Quaternion q) {
        void alpha;
        void beta;
        Object object2 = rotations.intrinsicZxz(q);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object gamma = Values.getFromPosFinal(object2, n);
        return Values.makeFromArray(gamma, beta, alpha);
    }

    public static Values extrinsicZyx(Quaternion q) {
        void alpha;
        void beta;
        Object object2 = rotations.intrinsicXyz(q);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object gamma = Values.getFromPosFinal(object2, n);
        return Values.makeFromArray(gamma, beta, alpha);
    }

    public static Values extrinsicZyz(Quaternion q) {
        void alpha;
        void beta;
        Object object2 = rotations.intrinsicZyz(q);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object object4 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object gamma = Values.getFromPosFinal(object2, n);
        return Values.makeFromArray(gamma, beta, alpha);
    }

    public static Quaternion makeExtrinsicXyx(RealNum gamma, RealNum beta, RealNum alpha) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotx(alpha), rotations.roty(beta)), rotations.rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeExtrinsicXyz(RealNum gamma, RealNum beta, RealNum alpha) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotz(alpha), rotations.roty(beta)), rotations.rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeExtrinsicXzx(RealNum gamma, RealNum beta, RealNum alpha) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotx(alpha), rotations.rotz(beta)), rotations.rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeExtrinsicXzy(RealNum gamma, RealNum beta, RealNum alpha) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.roty(alpha), rotations.rotz(beta)), rotations.rotx(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeExtrinsicYxy(RealNum gamma, RealNum beta, RealNum alpha) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.roty(alpha), rotations.rotx(beta)), rotations.roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeExtrinsicYxz(RealNum gamma, RealNum beta, RealNum alpha) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotz(alpha), rotations.rotx(beta)), rotations.roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeExtrinsicYzx(RealNum gamma, RealNum beta, RealNum alpha) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotx(alpha), rotations.rotz(beta)), rotations.roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeExtrinsicYzy(RealNum gamma, RealNum beta, RealNum alpha) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.roty(alpha), rotations.rotz(beta)), rotations.roty(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeExtrinsicZxy(RealNum gamma, RealNum beta, RealNum alpha) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.roty(alpha), rotations.rotx(beta)), rotations.rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeExtrinsicZxz(RealNum gamma, RealNum beta, RealNum alpha) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotz(alpha), rotations.rotx(beta)), rotations.rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeExtrinsicZyx(RealNum gamma, RealNum beta, RealNum alpha) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotx(alpha), rotations.roty(beta)), rotations.rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Quaternion makeExtrinsicZyz(RealNum gamma, RealNum beta, RealNum alpha) {
        Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(rotations.rotz(alpha), rotations.roty(beta)), rotations.rotz(gamma)), Number.class);
        try {
            return (Quaternion)quaternions.unitQuaternion((Number)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unit-quaternion", 1, object2);
        }
    }

    public static Procedure makeRotationProcedure(Quaternion rotation) {
        public class Frame
        extends ModuleBody {
            Number uq$St;
            Number uq;
            final ModuleMethod lambda$Fn2;

            public Frame() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 1, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm:709");
                this.lambda$Fn2 = moduleMethod;
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            Quaternion lambda2(Quaternion vec) {
                if (quaternions.isVectorQuaternion(vec)) {
                    Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(this.uq, vec), this.uq$St), Number.class);
                    return quaternions.vectorPart((Number)object2);
                }
                Type.NeverReturns neverReturns = exceptions.error("vec must be vector quaternion");
                throw Special.reachedUnexpected;
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 1) {
                    Object object3 = Promise.force(object2, Quaternion.class);
                    if (!(object3 instanceof Quaternion)) {
                        return -786431;
                    }
                    callContext.value1 = object3;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, object2, callContext);
            }

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public Object apply1(ModuleMethod moduleMethod, Object object2) {
                if (moduleMethod.selector != 1) return super.apply1(moduleMethod, object2);
                try {
                    return this.lambda2((Quaternion)Promise.force(object2, Quaternion.class));
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "lambda", 1, object2);
                }
            }
        }
        Frame $heapFrame = new Frame();
        $heapFrame.uq = quaternions.unitQuaternion(rotation);
        $heapFrame.uq$St = quaternions.conjugate($heapFrame.uq);
        return $heapFrame.lambda$Fn2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Quaternion rotateVector(Quaternion rotation, Quaternion vec) {
        if (quaternions.isVectorQuaternion(vec)) {
            Number uq = quaternions.unitQuaternion(rotation);
            Number uq$St = quaternions.conjugate(uq);
            Object object2 = Promise.force(((Procedure)MultiplyOp.$St).apply2(((Procedure)MultiplyOp.$St).apply2(uq, vec), uq$St), Number.class);
            return quaternions.vectorPart((Number)object2);
        }
        Type.NeverReturns neverReturns = exceptions.error(Lit12, "vec must be vector quaternion");
        throw Special.reachedUnexpected;
    }

    public static {
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
        Lit13 = Symbol.valueOf("u");
        Lit14 = new SyntaxRules(Lit72, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit72, 1, "rotations.scm:110"), "\u0001", "\u0011\u0018\u00049\u0011\u0018\f\t\u0003\u0018\u0014\u0018\u001c", new Object[]{PairWithPosition.make(Lit73, Pair.make(Lit74, Pair.make(Pair.make(Lit75, Pair.make(Symbol.valueOf("min"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm", 450573), PairWithPosition.make(Lit73, Pair.make(Lit74, Pair.make(Pair.make(Lit75, Pair.make(Symbol.valueOf("max"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm", 450580), PairWithPosition.make(-1, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm", 450588), PairWithPosition.make(1.0, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm", 450594)}, 0)}, 1, Lit13);
        Lit12 = Symbol.valueOf("rotate-vector");
        Lit11 = DFloNum.valueOf(0.0);
        Lit0 = IntNum.valueOf(0);
        Lit2 = IntNum.valueOf(1);
        Lit10 = new CComplex(Lit0, Lit2);
        Lit9 = new IntFraction(Lit2, Lit76);
        Lit8 = new IntFraction(Lit2, Lit76);
        Lit7 = new IntFraction(Lit2, Lit76);
        Lit6 = new IntFraction(Lit2, Lit76);
        Lit3 = IntNum.valueOf(2);
        Lit5 = new IntFraction(Lit2, Lit3);
        Lit4 = 1.0E-12;
        Lit1 = IntNum.valueOf(3);
        $Prvt$M = Math.class;
        $instance = new rotations();
        $Prvt$define = StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
        $Prvt$quaternion = StaticFieldLocation.make("kawa.lib.numbers", "quaternion");
        $Prvt$unit$Mnquaternion = StaticFieldLocation.make("kawa.lib.kawa.quaternions", "unit$Mnquaternion");
        $Prvt$$Pl = StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Pl");
        $Prvt$$Mn = StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Mn");
        $Prvt$$St = StaticFieldLocation.make("gnu.kawa.functions.MultiplyOp", "$St");
        $Prvt$u = Macro.make(Lit13, Lit14, "kawa.lib.kawa.rotations");
        rotations rotations2 = $instance;
        ModuleMethod moduleMethod = new ModuleMethod(rotations2, 2, null, 8194);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm:145");
        lambda$Fn1 = moduleMethod;
        quaternion$Mn$Grrotation$Mnmatrix = new ModuleMethod(rotations2, 3, Lit15, 4097);
        rotation$Mnmatrix$Mn$Grquaternion = new ModuleMethod(rotations2, 4, Lit16, 4097);
        rotation$Mnaxis = new ModuleMethod(rotations2, 5, Lit17, 4097);
        rotation$Mnangle = new ModuleMethod(rotations2, 6, Lit18, 4097);
        rotation$Mnaxis$Slangle = new ModuleMethod(rotations2, 7, Lit19, 4097);
        GenericProc genericProc = new GenericProc("make-axis/angle");
        rotations $instance = rotations.$instance;
        ModuleMethod moduleMethod2 = new ModuleMethod($instance, 8, "make-axis/angle", 8194);
        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm:205");
        genericProc.add(moduleMethod2);
        rotations $instance2 = rotations.$instance;
        ModuleMethod moduleMethod3 = new ModuleMethod($instance2, 9, "make-axis/angle", 16388);
        moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm:211");
        genericProc.add(moduleMethod3);
        make$Mnaxis$Slangle = genericProc;
        rotx = new ModuleMethod(rotations2, 10, Lit20, 4097);
        roty = new ModuleMethod(rotations2, 11, Lit21, 4097);
        rotz = new ModuleMethod(rotations2, 12, Lit22, 4097);
        intrinsic$Mnxyx = new ModuleMethod(rotations2, 13, Lit23, 4097);
        intrinsic$Mnxzx = new ModuleMethod(rotations2, 14, Lit24, 4097);
        intrinsic$Mnyxy = new ModuleMethod(rotations2, 15, Lit25, 4097);
        intrinsic$Mnyzy = new ModuleMethod(rotations2, 16, Lit26, 4097);
        intrinsic$Mnzxz = new ModuleMethod(rotations2, 17, Lit27, 4097);
        intrinsic$Mnzyz = new ModuleMethod(rotations2, 18, Lit28, 4097);
        euler$Mnxyx = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnxyx");
        euler$Mnxzx = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnxzx");
        euler$Mnyxy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnyxy");
        euler$Mnyzy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnyzy");
        euler$Mnzxz = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnzxz");
        euler$Mnzyz = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnzyz");
        intrinsic$Mnxyz = new ModuleMethod(rotations2, 19, Lit29, 4097);
        intrinsic$Mnxzy = new ModuleMethod(rotations2, 20, Lit30, 4097);
        intrinsic$Mnyxz = new ModuleMethod(rotations2, 21, Lit31, 4097);
        intrinsic$Mnyzx = new ModuleMethod(rotations2, 22, Lit32, 4097);
        intrinsic$Mnzxy = new ModuleMethod(rotations2, 23, Lit33, 4097);
        intrinsic$Mnzyx = new ModuleMethod(rotations2, 24, Lit34, 4097);
        tait$Mnbryan$Mnxyz = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnxyz");
        tait$Mnbryan$Mnxzy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnxzy");
        tait$Mnbryan$Mnyxz = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnyxz");
        tait$Mnbryan$Mnyzx = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnyzx");
        tait$Mnbryan$Mnzxy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnzxy");
        tait$Mnbryan$Mnzyx = StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnzyx");
        make$Mnintrinsic$Mnxyx = new ModuleMethod(rotations2, 25, Lit35, 12291);
        make$Mnintrinsic$Mnxzx = new ModuleMethod(rotations2, 26, Lit36, 12291);
        make$Mnintrinsic$Mnyxy = new ModuleMethod(rotations2, 27, Lit37, 12291);
        make$Mnintrinsic$Mnyzy = new ModuleMethod(rotations2, 28, Lit38, 12291);
        make$Mnintrinsic$Mnzxz = new ModuleMethod(rotations2, 29, Lit39, 12291);
        make$Mnintrinsic$Mnzyz = new ModuleMethod(rotations2, 30, Lit40, 12291);
        make$Mnintrinsic$Mnxyz = new ModuleMethod(rotations2, 31, Lit41, 12291);
        make$Mnintrinsic$Mnxzy = new ModuleMethod(rotations2, 32, Lit42, 12291);
        make$Mnintrinsic$Mnyxz = new ModuleMethod(rotations2, 33, Lit43, 12291);
        make$Mnintrinsic$Mnyzx = new ModuleMethod(rotations2, 34, Lit44, 12291);
        make$Mnintrinsic$Mnzxy = new ModuleMethod(rotations2, 35, Lit45, 12291);
        make$Mnintrinsic$Mnzyx = new ModuleMethod(rotations2, 36, Lit46, 12291);
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
        extrinsic$Mnxyx = new ModuleMethod(rotations2, 37, Lit47, 4097);
        extrinsic$Mnxyz = new ModuleMethod(rotations2, 38, Lit48, 4097);
        extrinsic$Mnxzx = new ModuleMethod(rotations2, 39, Lit49, 4097);
        extrinsic$Mnxzy = new ModuleMethod(rotations2, 40, Lit50, 4097);
        extrinsic$Mnyxy = new ModuleMethod(rotations2, 41, Lit51, 4097);
        extrinsic$Mnyxz = new ModuleMethod(rotations2, 42, Lit52, 4097);
        extrinsic$Mnyzx = new ModuleMethod(rotations2, 43, Lit53, 4097);
        extrinsic$Mnyzy = new ModuleMethod(rotations2, 44, Lit54, 4097);
        extrinsic$Mnzxy = new ModuleMethod(rotations2, 45, Lit55, 4097);
        extrinsic$Mnzxz = new ModuleMethod(rotations2, 46, Lit56, 4097);
        extrinsic$Mnzyx = new ModuleMethod(rotations2, 47, Lit57, 4097);
        extrinsic$Mnzyz = new ModuleMethod(rotations2, 48, Lit58, 4097);
        make$Mnextrinsic$Mnxyx = new ModuleMethod(rotations2, 49, Lit59, 12291);
        make$Mnextrinsic$Mnxyz = new ModuleMethod(rotations2, 50, Lit60, 12291);
        make$Mnextrinsic$Mnxzx = new ModuleMethod(rotations2, 51, Lit61, 12291);
        make$Mnextrinsic$Mnxzy = new ModuleMethod(rotations2, 52, Lit62, 12291);
        make$Mnextrinsic$Mnyxy = new ModuleMethod(rotations2, 53, Lit63, 12291);
        make$Mnextrinsic$Mnyxz = new ModuleMethod(rotations2, 54, Lit64, 12291);
        make$Mnextrinsic$Mnyzx = new ModuleMethod(rotations2, 55, Lit65, 12291);
        make$Mnextrinsic$Mnyzy = new ModuleMethod(rotations2, 56, Lit66, 12291);
        make$Mnextrinsic$Mnzxy = new ModuleMethod(rotations2, 57, Lit67, 12291);
        make$Mnextrinsic$Mnzxz = new ModuleMethod(rotations2, 58, Lit68, 12291);
        make$Mnextrinsic$Mnzyx = new ModuleMethod(rotations2, 59, Lit69, 12291);
        make$Mnextrinsic$Mnzyz = new ModuleMethod(rotations2, 60, Lit70, 12291);
        rpy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "extrinsic$Mnxyz");
        make$Mnrpy = StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnextrinsic$Mnxyz");
        make$Mnrotation$Mnprocedure = new ModuleMethod(rotations2, 61, Lit71, 4097);
        rotate$Mnvector = new ModuleMethod(rotations2, 62, Lit12, 8194);
        rotations.$runBody$();
    }

    public rotations() {
        ModuleInfo.register(this);
    }

    public static Quaternion makeAxis$SlAngle(Quaternion axis, RealNum angle) {
        RealNum halfangle = RealNum.divide(angle, Lit3);
        return (Quaternion)Promise.force(AddOp.apply2(1, ((Procedure)numbers.cos).apply1(halfangle), ((Procedure)MultiplyOp.$St).apply2(numbers.unitVector(axis), ((Procedure)numbers.sin).apply1(halfangle))), Quaternion.class);
    }

    public static Quaternion makeAxis$SlAngle(RealNum axis$Mnx, RealNum axis$Mny, RealNum axis$Mnz, RealNum angle) {
        return (Quaternion)Promise.force(((Procedure)make$Mnaxis$Slangle).apply2(((Procedure)numbers.make$Mnrectangular).apply4(Lit0, axis$Mnx, axis$Mny, axis$Mnz), angle), Quaternion.class);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 61: {
                Object object3 = Promise.force(object2, Quaternion.class);
                if (!(object3 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 48: {
                Object object4 = Promise.force(object2, Quaternion.class);
                if (!(object4 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 47: {
                Object object5 = Promise.force(object2, Quaternion.class);
                if (!(object5 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 46: {
                Object object6 = Promise.force(object2, Quaternion.class);
                if (!(object6 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 45: {
                Object object7 = Promise.force(object2, Quaternion.class);
                if (!(object7 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 44: {
                Object object8 = Promise.force(object2, Quaternion.class);
                if (!(object8 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 43: {
                Object object9 = Promise.force(object2, Quaternion.class);
                if (!(object9 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 42: {
                Object object10 = Promise.force(object2, Quaternion.class);
                if (!(object10 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 41: {
                Object object11 = Promise.force(object2, Quaternion.class);
                if (!(object11 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 40: {
                Object object12 = Promise.force(object2, Quaternion.class);
                if (!(object12 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 39: {
                Object object13 = Promise.force(object2, Quaternion.class);
                if (!(object13 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 38: {
                Object object14 = Promise.force(object2, Quaternion.class);
                if (!(object14 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object14;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 37: {
                Object object15 = Promise.force(object2, Quaternion.class);
                if (!(object15 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object15;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 24: {
                Object object16 = Promise.force(object2, Quaternion.class);
                if (!(object16 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object16;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 23: {
                Object object17 = Promise.force(object2, Quaternion.class);
                if (!(object17 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object17;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 22: {
                Object object18 = Promise.force(object2, Quaternion.class);
                if (!(object18 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object18;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 21: {
                Object object19 = Promise.force(object2, Quaternion.class);
                if (!(object19 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object19;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 20: {
                Object object20 = Promise.force(object2, Quaternion.class);
                if (!(object20 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object20;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 19: {
                Object object21 = Promise.force(object2, Quaternion.class);
                if (!(object21 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object21;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 18: {
                Object object22 = Promise.force(object2, Quaternion.class);
                if (!(object22 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object22;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 17: {
                Object object23 = Promise.force(object2, Quaternion.class);
                if (!(object23 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object23;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 16: {
                Object object24 = Promise.force(object2, Quaternion.class);
                if (!(object24 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object24;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 15: {
                Object object25 = Promise.force(object2, Quaternion.class);
                if (!(object25 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object25;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                Object object26 = Promise.force(object2, Quaternion.class);
                if (!(object26 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object26;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 13: {
                Object object27 = Promise.force(object2, Quaternion.class);
                if (!(object27 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object27;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 12: {
                Object object28 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object28) == null) {
                    return -786431;
                }
                callContext.value1 = object28;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 11: {
                Object object29 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object29) == null) {
                    return -786431;
                }
                callContext.value1 = object29;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 10: {
                Object object30 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object30) == null) {
                    return -786431;
                }
                callContext.value1 = object30;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 7: {
                Object object31 = Promise.force(object2, Quaternion.class);
                if (!(object31 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object31;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 6: {
                Object object32 = Promise.force(object2, Quaternion.class);
                if (!(object32 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object32;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 5: {
                Object object33 = Promise.force(object2, Quaternion.class);
                if (!(object33 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object33;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                Object object34 = Promise.force(object2, Array.class);
                if (!(object34 instanceof Array)) {
                    return -786431;
                }
                callContext.value1 = object34;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                Object object35 = Promise.force(object2, Quaternion.class);
                if (!(object35 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object35;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 8: {
                Object object4 = Promise.force(object2, Quaternion.class);
                if (!(object4 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object4;
                Object object5 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object5) == null) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 62: {
                Object object6 = Promise.force(object2, Quaternion.class);
                if (!(object6 instanceof Quaternion)) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3, Quaternion.class);
                if (!(object7 instanceof Quaternion)) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 2: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 60: {
                Object object5 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object5) == null) {
                    return -786431;
                }
                callContext.value1 = object5;
                Object object6 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object6) == null) {
                    return -786430;
                }
                callContext.value2 = object6;
                Object object7 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object7) == null) {
                    return -786429;
                }
                callContext.value3 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 59: {
                Object object8 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object8) == null) {
                    return -786431;
                }
                callContext.value1 = object8;
                Object object9 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object9) == null) {
                    return -786430;
                }
                callContext.value2 = object9;
                Object object10 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object10) == null) {
                    return -786429;
                }
                callContext.value3 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 58: {
                Object object11 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object11) == null) {
                    return -786431;
                }
                callContext.value1 = object11;
                Object object12 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object12) == null) {
                    return -786430;
                }
                callContext.value2 = object12;
                Object object13 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object13) == null) {
                    return -786429;
                }
                callContext.value3 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 57: {
                Object object14 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object14) == null) {
                    return -786431;
                }
                callContext.value1 = object14;
                Object object15 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object15) == null) {
                    return -786430;
                }
                callContext.value2 = object15;
                Object object16 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object16) == null) {
                    return -786429;
                }
                callContext.value3 = object16;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 56: {
                Object object17 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object17) == null) {
                    return -786431;
                }
                callContext.value1 = object17;
                Object object18 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object18) == null) {
                    return -786430;
                }
                callContext.value2 = object18;
                Object object19 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object19) == null) {
                    return -786429;
                }
                callContext.value3 = object19;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 55: {
                Object object20 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object20) == null) {
                    return -786431;
                }
                callContext.value1 = object20;
                Object object21 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object21) == null) {
                    return -786430;
                }
                callContext.value2 = object21;
                Object object22 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object22) == null) {
                    return -786429;
                }
                callContext.value3 = object22;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 54: {
                Object object23 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object23) == null) {
                    return -786431;
                }
                callContext.value1 = object23;
                Object object24 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object24) == null) {
                    return -786430;
                }
                callContext.value2 = object24;
                Object object25 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object25) == null) {
                    return -786429;
                }
                callContext.value3 = object25;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 53: {
                Object object26 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object26) == null) {
                    return -786431;
                }
                callContext.value1 = object26;
                Object object27 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object27) == null) {
                    return -786430;
                }
                callContext.value2 = object27;
                Object object28 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object28) == null) {
                    return -786429;
                }
                callContext.value3 = object28;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 52: {
                Object object29 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object29) == null) {
                    return -786431;
                }
                callContext.value1 = object29;
                Object object30 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object30) == null) {
                    return -786430;
                }
                callContext.value2 = object30;
                Object object31 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object31) == null) {
                    return -786429;
                }
                callContext.value3 = object31;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 51: {
                Object object32 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object32) == null) {
                    return -786431;
                }
                callContext.value1 = object32;
                Object object33 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object33) == null) {
                    return -786430;
                }
                callContext.value2 = object33;
                Object object34 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object34) == null) {
                    return -786429;
                }
                callContext.value3 = object34;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 50: {
                Object object35 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object35) == null) {
                    return -786431;
                }
                callContext.value1 = object35;
                Object object36 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object36) == null) {
                    return -786430;
                }
                callContext.value2 = object36;
                Object object37 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object37) == null) {
                    return -786429;
                }
                callContext.value3 = object37;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 49: {
                Object object38 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object38) == null) {
                    return -786431;
                }
                callContext.value1 = object38;
                Object object39 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object39) == null) {
                    return -786430;
                }
                callContext.value2 = object39;
                Object object40 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object40) == null) {
                    return -786429;
                }
                callContext.value3 = object40;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 36: {
                Object object41 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object41) == null) {
                    return -786431;
                }
                callContext.value1 = object41;
                Object object42 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object42) == null) {
                    return -786430;
                }
                callContext.value2 = object42;
                Object object43 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object43) == null) {
                    return -786429;
                }
                callContext.value3 = object43;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 35: {
                Object object44 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object44) == null) {
                    return -786431;
                }
                callContext.value1 = object44;
                Object object45 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object45) == null) {
                    return -786430;
                }
                callContext.value2 = object45;
                Object object46 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object46) == null) {
                    return -786429;
                }
                callContext.value3 = object46;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 34: {
                Object object47 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object47) == null) {
                    return -786431;
                }
                callContext.value1 = object47;
                Object object48 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object48) == null) {
                    return -786430;
                }
                callContext.value2 = object48;
                Object object49 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object49) == null) {
                    return -786429;
                }
                callContext.value3 = object49;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 33: {
                Object object50 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object50) == null) {
                    return -786431;
                }
                callContext.value1 = object50;
                Object object51 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object51) == null) {
                    return -786430;
                }
                callContext.value2 = object51;
                Object object52 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object52) == null) {
                    return -786429;
                }
                callContext.value3 = object52;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 32: {
                Object object53 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object53) == null) {
                    return -786431;
                }
                callContext.value1 = object53;
                Object object54 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object54) == null) {
                    return -786430;
                }
                callContext.value2 = object54;
                Object object55 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object55) == null) {
                    return -786429;
                }
                callContext.value3 = object55;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 31: {
                Object object56 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object56) == null) {
                    return -786431;
                }
                callContext.value1 = object56;
                Object object57 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object57) == null) {
                    return -786430;
                }
                callContext.value2 = object57;
                Object object58 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object58) == null) {
                    return -786429;
                }
                callContext.value3 = object58;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 30: {
                Object object59 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object59) == null) {
                    return -786431;
                }
                callContext.value1 = object59;
                Object object60 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object60) == null) {
                    return -786430;
                }
                callContext.value2 = object60;
                Object object61 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object61) == null) {
                    return -786429;
                }
                callContext.value3 = object61;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 29: {
                Object object62 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object62) == null) {
                    return -786431;
                }
                callContext.value1 = object62;
                Object object63 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object63) == null) {
                    return -786430;
                }
                callContext.value2 = object63;
                Object object64 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object64) == null) {
                    return -786429;
                }
                callContext.value3 = object64;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 28: {
                Object object65 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object65) == null) {
                    return -786431;
                }
                callContext.value1 = object65;
                Object object66 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object66) == null) {
                    return -786430;
                }
                callContext.value2 = object66;
                Object object67 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object67) == null) {
                    return -786429;
                }
                callContext.value3 = object67;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 27: {
                Object object68 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object68) == null) {
                    return -786431;
                }
                callContext.value1 = object68;
                Object object69 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object69) == null) {
                    return -786430;
                }
                callContext.value2 = object69;
                Object object70 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object70) == null) {
                    return -786429;
                }
                callContext.value3 = object70;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 26: {
                Object object71 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object71) == null) {
                    return -786431;
                }
                callContext.value1 = object71;
                Object object72 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object72) == null) {
                    return -786430;
                }
                callContext.value2 = object72;
                Object object73 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object73) == null) {
                    return -786429;
                }
                callContext.value3 = object73;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 25: {
                Object object74 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object74) == null) {
                    return -786431;
                }
                callContext.value1 = object74;
                Object object75 = Promise.force(object3, RealNum.class);
                if (RealNum.asRealNumOrNull(object75) == null) {
                    return -786430;
                }
                callContext.value2 = object75;
                Object object76 = Promise.force(object4, RealNum.class);
                if (RealNum.asRealNumOrNull(object76) == null) {
                    return -786429;
                }
                callContext.value3 = object76;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        if (moduleMethod.selector == 9) {
            Object object6 = Promise.force(object2, RealNum.class);
            if (RealNum.asRealNumOrNull(object6) == null) {
                return -786431;
            }
            callContext.value1 = object6;
            Object object7 = Promise.force(object3, RealNum.class);
            if (RealNum.asRealNumOrNull(object7) == null) {
                return -786430;
            }
            callContext.value2 = object7;
            Object object8 = Promise.force(object4, RealNum.class);
            if (RealNum.asRealNumOrNull(object8) == null) {
                return -786429;
            }
            callContext.value3 = object8;
            Object object9 = Promise.force(object5, RealNum.class);
            if (RealNum.asRealNumOrNull(object9) == null) {
                return -786428;
            }
            callContext.value4 = object9;
            callContext.proc = moduleMethod;
            callContext.pc = 4;
            return 0;
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 3: {
                return rotations.quaternion$To$RotationMatrix((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 4: {
                return rotations.rotationMatrix$To$Quaternion((Array)Promise.force(object2, Array.class));
            }
            case 5: {
                return rotations.rotationAxis((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 6: {
                return rotations.rotationAngle((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 7: {
                return rotations.rotationAxis$SlAngle((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 10: {
                return rotations.rotx(LangObjType.coerceRealNum(Promise.force(object2, RealNum.class)));
            }
            case 11: {
                return rotations.roty(LangObjType.coerceRealNum(Promise.force(object2, RealNum.class)));
            }
            case 12: {
                return rotations.rotz(LangObjType.coerceRealNum(Promise.force(object2, RealNum.class)));
            }
            case 13: {
                return rotations.intrinsicXyx((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 14: {
                return rotations.intrinsicXzx((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 15: {
                return rotations.intrinsicYxy((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 16: {
                return rotations.intrinsicYzy((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 17: {
                return rotations.intrinsicZxz((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 18: {
                return rotations.intrinsicZyz((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 19: {
                return rotations.intrinsicXyz((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 20: {
                return rotations.intrinsicXzy((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 21: {
                return rotations.intrinsicYxz((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 22: {
                return rotations.intrinsicYzx((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 23: {
                return rotations.intrinsicZxy((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 24: {
                return rotations.intrinsicZyx((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 37: {
                return rotations.extrinsicXyx((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 38: {
                return rotations.extrinsicXyz((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 39: {
                return rotations.extrinsicXzx((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 40: {
                return rotations.extrinsicXzy((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 41: {
                return rotations.extrinsicYxy((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 42: {
                return rotations.extrinsicYxz((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 43: {
                return rotations.extrinsicYzx((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 44: {
                return rotations.extrinsicYzy((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 45: {
                return rotations.extrinsicZxy((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 46: {
                return rotations.extrinsicZxz((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 47: {
                return rotations.extrinsicZyx((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 48: {
                return rotations.extrinsicZyz((Quaternion)Promise.force(object2, Quaternion.class));
            }
            case 61: {
                return rotations.makeRotationProcedure((Quaternion)Promise.force(object2, Quaternion.class));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "quaternion->rotation-matrix", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "rotation-matrix->quaternion", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "rotation-axis", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "rotation-angle", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "rotation-axis/angle", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "rotx", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "roty", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "rotz", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "intrinsic-xyx", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "intrinsic-xzx", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "intrinsic-yxy", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "intrinsic-yzy", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "intrinsic-zxz", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "intrinsic-zyz", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "intrinsic-xyz", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "intrinsic-xzy", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "intrinsic-yxz", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "intrinsic-yzx", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "intrinsic-zxy", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "intrinsic-zyx", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "extrinsic-xyx", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "extrinsic-xyz", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "extrinsic-xzx", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "extrinsic-xzy", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "extrinsic-yxy", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "extrinsic-yxz", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "extrinsic-yzx", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "extrinsic-yzy", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "extrinsic-zxy", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "extrinsic-zxz", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "extrinsic-zyx", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "extrinsic-zyz", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-rotation-procedure", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public Object apply2(ModuleMethod var1_1, Object var2_2, Object var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public Object apply3(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public Object apply4(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4, Object var5_5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

}

