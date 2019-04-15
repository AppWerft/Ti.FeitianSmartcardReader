package kawa.lib.kawa;

import gnu.math.Quaternion;

public class rotations extends gnu.expr.ModuleBody { public static final gnu.expr.ModuleMethod quaternion$Mn$Grrotation$Mnmatrix;
  public static final gnu.expr.ModuleMethod rotation$Mnmatrix$Mn$Grquaternion;
  public static final gnu.expr.ModuleMethod rotation$Mnaxis;
  public static final gnu.expr.ModuleMethod rotation$Mnangle;
  public static final gnu.expr.ModuleMethod rotation$Mnaxis$Slangle;
  public static final gnu.expr.GenericProc make$Mnaxis$Slangle;
  public static final gnu.expr.ModuleMethod rotx;
  public static final gnu.expr.ModuleMethod roty;
  public static final gnu.expr.ModuleMethod rotz;
  public static final gnu.expr.ModuleMethod intrinsic$Mnxyx;
  public static final gnu.expr.ModuleMethod intrinsic$Mnxzx;
  public static final gnu.expr.ModuleMethod intrinsic$Mnyxy;
  public static final gnu.expr.ModuleMethod intrinsic$Mnyzy;
  public static final gnu.expr.ModuleMethod intrinsic$Mnzxz;
  public static final gnu.expr.ModuleMethod intrinsic$Mnzyz;
  public static final gnu.expr.ModuleMethod intrinsic$Mnxyz;
  public static final gnu.expr.ModuleMethod intrinsic$Mnxzy;
  public static final gnu.expr.ModuleMethod intrinsic$Mnyxz;
  public static final gnu.expr.ModuleMethod intrinsic$Mnyzx;
  public static final gnu.expr.ModuleMethod intrinsic$Mnzxy;
  public static final gnu.expr.ModuleMethod intrinsic$Mnzyx;
  public static final gnu.mapping.Location euler$Mnxyx;
  public static final gnu.mapping.Location euler$Mnxzx;
  public static final gnu.mapping.Location euler$Mnyxy;
  public static final gnu.mapping.Location euler$Mnyzy;
  public static final gnu.mapping.Location euler$Mnzxz;
  public static final gnu.mapping.Location euler$Mnzyz;
  public static final gnu.mapping.Location tait$Mnbryan$Mnxyz;
  public static final gnu.mapping.Location tait$Mnbryan$Mnxzy;
  public static final gnu.mapping.Location tait$Mnbryan$Mnyxz;
  public static final gnu.mapping.Location tait$Mnbryan$Mnyzx;
  public static final gnu.mapping.Location tait$Mnbryan$Mnzxy;
  public static final gnu.mapping.Location tait$Mnbryan$Mnzyx;
  public static final gnu.expr.ModuleMethod make$Mnintrinsic$Mnxyx;
  public static final gnu.expr.ModuleMethod make$Mnintrinsic$Mnxzx;
  public static final gnu.expr.ModuleMethod make$Mnintrinsic$Mnyxy;
  public static final gnu.expr.ModuleMethod make$Mnintrinsic$Mnyzy;
  public static final gnu.expr.ModuleMethod make$Mnintrinsic$Mnzxz;
  public static final gnu.expr.ModuleMethod make$Mnintrinsic$Mnzyz;
  public static final gnu.expr.ModuleMethod make$Mnintrinsic$Mnxyz;
  public static final gnu.expr.ModuleMethod make$Mnintrinsic$Mnxzy;
  public static final gnu.expr.ModuleMethod make$Mnintrinsic$Mnyxz;
  public static final gnu.expr.ModuleMethod make$Mnintrinsic$Mnyzx;
  public static final gnu.expr.ModuleMethod make$Mnintrinsic$Mnzxy;
  public static final gnu.expr.ModuleMethod make$Mnintrinsic$Mnzyx;
  public static final gnu.mapping.Location make$Mneuler$Mnxyx;
  public static final gnu.mapping.Location make$Mneuler$Mnxzx;
  public static final gnu.mapping.Location make$Mneuler$Mnyxy; public static final gnu.mapping.Location make$Mneuler$Mnyzy; public static final gnu.mapping.Location make$Mneuler$Mnzxz; public static final gnu.mapping.Location make$Mneuler$Mnzyz; public static final gnu.mapping.Location make$Mntait$Mnbryan$Mnxyz; public static final gnu.mapping.Location make$Mntait$Mnbryan$Mnxzy; public static final gnu.mapping.Location make$Mntait$Mnbryan$Mnyxz; public static final gnu.mapping.Location make$Mntait$Mnbryan$Mnyzx; public static final gnu.mapping.Location make$Mntait$Mnbryan$Mnzxy; public static final gnu.mapping.Location make$Mntait$Mnbryan$Mnzyx; public static final gnu.expr.ModuleMethod extrinsic$Mnxyx; public static final gnu.expr.ModuleMethod extrinsic$Mnxyz; public static final gnu.expr.ModuleMethod extrinsic$Mnxzx; public static final gnu.expr.ModuleMethod extrinsic$Mnxzy; public static final gnu.expr.ModuleMethod extrinsic$Mnyxy; public static final gnu.expr.ModuleMethod extrinsic$Mnyxz; public static final gnu.expr.ModuleMethod extrinsic$Mnyzx; public static final gnu.expr.ModuleMethod extrinsic$Mnyzy; public static final gnu.expr.ModuleMethod extrinsic$Mnzxy; public static final gnu.expr.ModuleMethod extrinsic$Mnzxz; public static final gnu.expr.ModuleMethod extrinsic$Mnzyx; public static final gnu.expr.ModuleMethod extrinsic$Mnzyz; public static final gnu.mapping.Location rpy; public static final gnu.expr.ModuleMethod make$Mnextrinsic$Mnxyx; public static final gnu.expr.ModuleMethod make$Mnextrinsic$Mnxyz; public static final gnu.expr.ModuleMethod make$Mnextrinsic$Mnxzx; public static final gnu.expr.ModuleMethod make$Mnextrinsic$Mnxzy; public static final gnu.expr.ModuleMethod make$Mnextrinsic$Mnyxy; public static final gnu.expr.ModuleMethod make$Mnextrinsic$Mnyxz; public static final gnu.expr.ModuleMethod make$Mnextrinsic$Mnyzx; public static final gnu.expr.ModuleMethod make$Mnextrinsic$Mnyzy; public static final gnu.expr.ModuleMethod make$Mnextrinsic$Mnzxy; public static final gnu.expr.ModuleMethod make$Mnextrinsic$Mnzxz; public static final gnu.expr.ModuleMethod make$Mnextrinsic$Mnzyx; public static final gnu.expr.ModuleMethod make$Mnextrinsic$Mnzyz; public static final gnu.mapping.Location make$Mnrpy; public static final gnu.expr.ModuleMethod make$Mnrotation$Mnprocedure; public static final gnu.expr.ModuleMethod rotate$Mnvector; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$define; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$quaternion; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$unit$Mnquaternion; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$$Pl; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$$Mn; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$$St; public static final Class $Prvt$M; public static final kawa.lang.Macro $Prvt$u; static final gnu.math.IntNum Lit0; static final gnu.math.IntNum Lit1; static final gnu.expr.ModuleMethod lambda$Fn1; static final gnu.math.IntNum Lit2; static final gnu.math.IntNum Lit3; static final Double Lit4; static final gnu.math.IntFraction Lit5; static final gnu.math.IntFraction Lit6; static final gnu.math.IntFraction Lit7; static final gnu.math.IntFraction Lit8; static final gnu.math.IntFraction Lit9; static final gnu.math.CComplex Lit10; static final gnu.math.DFloNum Lit11; static final gnu.mapping.SimpleSymbol Lit12; public static rotations $instance; static final gnu.mapping.SimpleSymbol Lit13; static final kawa.lang.SyntaxRules Lit14; static final gnu.mapping.SimpleSymbol Lit15; static final gnu.mapping.SimpleSymbol Lit16; static final gnu.mapping.SimpleSymbol Lit17; static final gnu.mapping.SimpleSymbol Lit18; static final gnu.mapping.SimpleSymbol Lit19; static final gnu.mapping.SimpleSymbol Lit20; static final gnu.mapping.SimpleSymbol Lit21; static final gnu.mapping.SimpleSymbol Lit22; static final gnu.mapping.SimpleSymbol Lit23; static final gnu.mapping.SimpleSymbol Lit24; static final gnu.mapping.SimpleSymbol Lit25; static final gnu.mapping.SimpleSymbol Lit26; static final gnu.mapping.SimpleSymbol Lit27; static final gnu.mapping.SimpleSymbol Lit28; static final gnu.mapping.SimpleSymbol Lit29; static final gnu.mapping.SimpleSymbol Lit30; static final gnu.mapping.SimpleSymbol Lit31; static final gnu.mapping.SimpleSymbol Lit32;
  private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  static final gnu.mapping.SimpleSymbol Lit33;
  static final gnu.mapping.SimpleSymbol Lit34;
  static final gnu.mapping.SimpleSymbol Lit35;
  static final gnu.mapping.SimpleSymbol Lit36;
  static final gnu.mapping.SimpleSymbol Lit37;
  static final gnu.mapping.SimpleSymbol Lit38;
  static final gnu.mapping.SimpleSymbol Lit39;
  static final gnu.mapping.SimpleSymbol Lit40;
  static final gnu.mapping.SimpleSymbol Lit41;
  static final gnu.mapping.SimpleSymbol Lit42;
  static final gnu.mapping.SimpleSymbol Lit43;
  static final gnu.mapping.SimpleSymbol Lit44;
  static final gnu.mapping.SimpleSymbol Lit45;
  static final gnu.mapping.SimpleSymbol Lit46;
  static final gnu.mapping.SimpleSymbol Lit47;
  static final gnu.mapping.SimpleSymbol Lit48;
  static final gnu.mapping.SimpleSymbol Lit49;
  static final gnu.mapping.SimpleSymbol Lit50;
  static final gnu.mapping.SimpleSymbol Lit51;
  static final gnu.mapping.SimpleSymbol Lit52;
  static final gnu.mapping.SimpleSymbol Lit53;
  static final gnu.mapping.SimpleSymbol Lit54;
  static final gnu.mapping.SimpleSymbol Lit55;
  static final gnu.mapping.SimpleSymbol Lit56;
  static final gnu.mapping.SimpleSymbol Lit57;
  static final gnu.mapping.SimpleSymbol Lit58;
  static final gnu.mapping.SimpleSymbol Lit59;
  static final gnu.mapping.SimpleSymbol Lit60;
  static final gnu.mapping.SimpleSymbol Lit61;
  static final gnu.mapping.SimpleSymbol Lit62;
  static final gnu.mapping.SimpleSymbol Lit63;
  static final gnu.mapping.SimpleSymbol Lit64;
  static final gnu.mapping.SimpleSymbol Lit65;
  static final gnu.mapping.SimpleSymbol Lit66;
  static final gnu.mapping.SimpleSymbol Lit67;
  static final gnu.mapping.SimpleSymbol Lit68;
  static final gnu.mapping.SimpleSymbol Lit69;
  static final gnu.mapping.SimpleSymbol Lit70;
  static final gnu.mapping.SimpleSymbol Lit71; static final Object[] Lit72; static final gnu.mapping.SimpleSymbol Lit73; static final gnu.mapping.SimpleSymbol Lit74; static final gnu.mapping.SimpleSymbol Lit75; static final gnu.math.IntNum Lit76 = gnu.math.IntNum.valueOf(4);
  
















































  static Object lambda1(Object i, Object j)
  {
    return gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.MultiplyOp.$St.apply2(Lit1, i), j);
  }
  
  public static Quaternion rotationMatrix$To$Quaternion(gnu.lists.Array m) {
    Object localObject1 = gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit0, Lit0);
    Object localObject2 = gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit2, Lit2);
    m22 = gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit3, Lit3);
    Object trace = gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.AddOp.apply2(1, m00, m11), m22), Lit2);
    if (gnu.kawa.functions.NumberCompare.$Gr(trace, Lit4)) {}
    try { Object s = gnu.kawa.functions.DivideOp.$Sl.apply2(Lit5, kawa.lib.numbers.sqrt((Number)(localObject3 = gnu.mapping.Promise.force(trace, Number.class))));
      



      tmpTernaryOp = ((Quaternion)gnu.mapping.Promise.force(kawa.lib.numbers.make$Mnrectangular.apply4(gnu.kawa.functions.DivideOp.$Sl.apply2(Lit6, s), gnu.kawa.functions.MultiplyOp.$St.apply2(s, gnu.kawa.functions.AddOp.apply2(-1, gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit3, Lit2), gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit2, Lit3))), gnu.kawa.functions.MultiplyOp.$St.apply2(s, gnu.kawa.functions.AddOp.apply2(-1, gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit0, Lit3), gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit3, Lit0))), gnu.kawa.functions.MultiplyOp.$St.apply2(s, gnu.kawa.functions.AddOp.apply2(-1, gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit2, Lit0), gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit0, Lit2)))), Quaternion.class);
    } catch (ClassCastException localClassCastException2) {
      for (;;) { try { Object s = gnu.kawa.functions.MultiplyOp.$St.apply2(Lit3, kawa.lib.numbers.sqrt((Number)(localObject3 = gnu.mapping.Promise.force(gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.AddOp.apply2(1, Lit2, m00), gnu.kawa.functions.AddOp.$Mn.apply1(m11)), gnu.kawa.functions.AddOp.$Mn.apply1(m22)), Number.class))));
          



          tmpTernaryOp = ((Quaternion)gnu.mapping.Promise.force(kawa.lib.numbers.make$Mnrectangular.apply4(gnu.kawa.functions.DivideOp.$Sl.apply2(gnu.kawa.functions.AddOp.apply2(-1, gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit3, Lit2), gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit2, Lit3)), s), gnu.kawa.functions.MultiplyOp.$St.apply2(Lit7, s), gnu.kawa.functions.DivideOp.$Sl.apply2(gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit0, Lit2), gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit2, Lit0)), s), gnu.kawa.functions.DivideOp.$Sl.apply2(gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit0, Lit3), gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit3, Lit0)), s)), Quaternion.class)); continue;
          if (!gnu.kawa.functions.NumberCompare.$Gr(m11, m22)) {}
        }
        catch (ClassCastException localClassCastException2)
        {
          Object s;
          Object s;
          throw new gnu.mapping.WrongType(localClassCastException2, "sqrt", 1, localObject3);
        }
        


        try
        {
          s = gnu.kawa.functions.MultiplyOp.$St.apply2(Lit3, kawa.lib.numbers.sqrt((Number)(localObject3 = gnu.mapping.Promise.force(gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.AddOp.apply2(1, Lit2, m11), gnu.kawa.functions.AddOp.$Mn.apply1(m00)), gnu.kawa.functions.AddOp.$Mn.apply1(m22)), Number.class))));
          



          tmpTernaryOp = ((Quaternion)gnu.mapping.Promise.force(kawa.lib.numbers.make$Mnrectangular.apply4(gnu.kawa.functions.DivideOp.$Sl.apply2(gnu.kawa.functions.AddOp.apply2(-1, gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit0, Lit3), gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit3, Lit0)), s), gnu.kawa.functions.DivideOp.$Sl.apply2(gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit0, Lit2), gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit2, Lit0)), s), gnu.kawa.functions.MultiplyOp.$St.apply2(Lit8, s), gnu.kawa.functions.DivideOp.$Sl.apply2(gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit2, Lit3), gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit3, Lit2)), s)), Quaternion.class);
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new gnu.mapping.WrongType(localClassCastException3, "sqrt", 1, localObject3);
        }
      }
      

      try
      {
        s = gnu.kawa.functions.MultiplyOp.$St.apply2(Lit3, kawa.lib.numbers.sqrt((Number)(localObject3 = gnu.mapping.Promise.force(gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.AddOp.apply2(1, Lit2, m22), gnu.kawa.functions.AddOp.$Mn.apply1(m00)), gnu.kawa.functions.AddOp.$Mn.apply1(m11)), Number.class))));
        



        return (Quaternion)gnu.mapping.Promise.force(kawa.lib.numbers.make$Mnrectangular.apply4(gnu.kawa.functions.DivideOp.$Sl.apply2(gnu.kawa.functions.AddOp.apply2(-1, gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit2, Lit0), gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit0, Lit2)), s), gnu.kawa.functions.DivideOp.$Sl.apply2(gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit0, Lit3), gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit3, Lit0)), s), gnu.kawa.functions.DivideOp.$Sl.apply2(gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit2, Lit3), gnu.kawa.functions.ArrayRef.arrayRef.apply3(m, Lit3, Lit2)), s), gnu.kawa.functions.MultiplyOp.$St.apply2(Lit9, s)), Quaternion.class);
      }
      catch (ClassCastException localClassCastException4)
      {
        throw new gnu.mapping.WrongType(localClassCastException4, "sqrt", 1, localObject3);
      }
      throw new gnu.mapping.WrongType(
      
























        localClassCastException1, "sqrt", 1, localObject3);
    }
    if ((!gnu.kawa.functions.NumberCompare.$Gr(m00, m11)) || (!gnu.kawa.functions.NumberCompare.$Gr(m00, m22))) {}
  }
  


























  public static Quaternion rotationAxis(Quaternion q)
  {
    Quaternion u = kawa.lib.numbers.unitVector(q);
    return gnu.kawa.functions.NumberCompare.$Eq(Lit0, u) ? Lit10 : u;
  }
  
  public static gnu.math.RealNum rotationAngle(Quaternion q) {
    return gnu.kawa.lispexpr.LangObjType.coerceRealNum(gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(Lit3, kawa.lib.numbers.atan.apply2(kawa.lib.numbers.magnitude(quaternions.vectorPart(q)), kawa.lib.numbers.realPart(q))), gnu.math.RealNum.class));
  }
  
  public static gnu.mapping.Values rotationAxis$SlAngle(Quaternion q) {
    return gnu.mapping.Values.values2(rotationAxis(q), rotationAngle(q));
  }
  



  public static Quaternion makeAxis$SlAngle(Quaternion axis, gnu.math.RealNum angle)
  {
    gnu.math.RealNum halfangle = gnu.math.RealNum.divide(angle, Lit3);
    
    return (Quaternion)gnu.mapping.Promise.force(gnu.kawa.functions.AddOp.apply2(1, kawa.lib.numbers.cos.apply1(halfangle), gnu.kawa.functions.MultiplyOp.$St.apply2(kawa.lib.numbers.unitVector(axis), kawa.lib.numbers.sin.apply1(halfangle))), Quaternion.class);
  }
  
  public static Quaternion makeAxis$SlAngle(gnu.math.RealNum axis$Mnx, gnu.math.RealNum axis$Mny, gnu.math.RealNum axis$Mnz, gnu.math.RealNum angle)
  {
    return (Quaternion)gnu.mapping.Promise.force(make$Mnaxis$Slangle.apply2(kawa.lib.numbers.make$Mnrectangular.apply4(Lit0, axis$Mnx, axis$Mny, axis$Mnz), angle), Quaternion.class);
  }
  
  public static Quaternion rotx(gnu.math.RealNum angle) {
    gnu.math.RealNum halfangle = gnu.math.RealNum.divide(angle, Lit3);
    
    return (Quaternion)gnu.mapping.Promise.force(kawa.lib.numbers.make$Mnrectangular.apply2(kawa.lib.numbers.cos.apply1(halfangle), kawa.lib.numbers.sin.apply1(halfangle)), Quaternion.class);
  }
  
  public static Quaternion roty(gnu.math.RealNum angle) {
    gnu.math.RealNum halfangle = gnu.math.RealNum.divide(angle, Lit3);
    
    return (Quaternion)gnu.mapping.Promise.force(kawa.lib.numbers.make$Mnrectangular.apply4(kawa.lib.numbers.cos.apply1(halfangle), Lit0, kawa.lib.numbers.sin.apply1(halfangle), Lit0), Quaternion.class);
  }
  
  public static Quaternion rotz(gnu.math.RealNum angle) {
    gnu.math.RealNum halfangle = gnu.math.RealNum.divide(angle, Lit3);
    
    return (Quaternion)gnu.mapping.Promise.force(kawa.lib.numbers.make$Mnrectangular.apply4(kawa.lib.numbers.cos.apply1(halfangle), Lit0, Lit0, kawa.lib.numbers.sin.apply1(halfangle)), Quaternion.class);
  }
  





















































































































































































































































































































































  public static Quaternion makeIntrinsicXyx(gnu.math.RealNum alpha, gnu.math.RealNum beta, gnu.math.RealNum gamma)
  {
    try
    {
      return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotx(alpha), roty(beta)), rotx(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeIntrinsicXzx(gnu.math.RealNum alpha, gnu.math.RealNum beta, gnu.math.RealNum gamma) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotx(alpha), rotz(beta)), rotx(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeIntrinsicYxy(gnu.math.RealNum alpha, gnu.math.RealNum beta, gnu.math.RealNum gamma) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(roty(alpha), rotx(beta)), roty(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeIntrinsicYzy(gnu.math.RealNum alpha, gnu.math.RealNum beta, gnu.math.RealNum gamma) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(roty(alpha), rotz(beta)), roty(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeIntrinsicZxz(gnu.math.RealNum alpha, gnu.math.RealNum beta, gnu.math.RealNum gamma) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotz(alpha), rotx(beta)), rotz(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeIntrinsicZyz(gnu.math.RealNum alpha, gnu.math.RealNum beta, gnu.math.RealNum gamma) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotz(alpha), roty(beta)), rotz(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject);
    } }
  
  public static Quaternion makeIntrinsicXyz(gnu.math.RealNum alpha, gnu.math.RealNum beta, gnu.math.RealNum gamma) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotx(alpha), roty(beta)), rotz(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeIntrinsicXzy(gnu.math.RealNum alpha, gnu.math.RealNum beta, gnu.math.RealNum gamma) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotx(alpha), rotz(beta)), roty(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeIntrinsicYxz(gnu.math.RealNum alpha, gnu.math.RealNum beta, gnu.math.RealNum gamma) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(roty(alpha), rotx(beta)), rotz(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeIntrinsicYzx(gnu.math.RealNum alpha, gnu.math.RealNum beta, gnu.math.RealNum gamma) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(roty(alpha), rotz(beta)), rotx(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeIntrinsicZxy(gnu.math.RealNum alpha, gnu.math.RealNum beta, gnu.math.RealNum gamma) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotz(alpha), rotx(beta)), roty(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeIntrinsicZyx(gnu.math.RealNum alpha, gnu.math.RealNum beta, gnu.math.RealNum gamma) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotz(alpha), roty(beta)), rotx(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject);
    }
  }
  







































  public static gnu.mapping.Values extrinsicXyx(Quaternion q)
  {
    Object localObject1 = intrinsicXyx(q);int i = 0;i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject2 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject3 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object gamma = gnu.mapping.Values.getFromPosFinal(localObject1, i);
    Object beta;
    Object alpha;
    return gnu.mapping.Values.makeFromArray(new Object[] { gamma, beta, alpha });
  }
  
  public static gnu.mapping.Values extrinsicXyz(Quaternion q) {
    Object localObject1 = intrinsicZyx(q);int i = 0;i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject2 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject3 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object gamma = gnu.mapping.Values.getFromPosFinal(localObject1, i);
    Object beta;
    Object alpha;
    return gnu.mapping.Values.makeFromArray(new Object[] { gamma, beta, alpha });
  }
  
  public static gnu.mapping.Values extrinsicXzx(Quaternion q)
  {
    Object localObject1 = intrinsicXzx(q);int i = 0;i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject2 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject3 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object gamma = gnu.mapping.Values.getFromPosFinal(localObject1, i);
    Object beta;
    Object alpha;
    return gnu.mapping.Values.makeFromArray(new Object[] { gamma, beta, alpha });
  }
  

  public static gnu.mapping.Values extrinsicXzy(Quaternion q)
  {
    Object localObject1 = intrinsicYzx(q);int i = 0;i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject2 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject3 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object gamma = gnu.mapping.Values.getFromPosFinal(localObject1, i);
    Object beta;
    Object alpha;
    return gnu.mapping.Values.makeFromArray(new Object[] { gamma, beta, alpha });
  }
  


  public static gnu.mapping.Values extrinsicYxy(Quaternion q)
  {
    Object localObject1 = intrinsicYxy(q);int i = 0;i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject2 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject3 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object gamma = gnu.mapping.Values.getFromPosFinal(localObject1, i);
    Object beta;
    Object alpha;
    return gnu.mapping.Values.makeFromArray(new Object[] { gamma, beta, alpha });
  }
  



  public static gnu.mapping.Values extrinsicYxz(Quaternion q)
  {
    Object localObject1 = intrinsicZxy(q);int i = 0;i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject2 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject3 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object gamma = gnu.mapping.Values.getFromPosFinal(localObject1, i);
    Object beta;
    Object alpha;
    return gnu.mapping.Values.makeFromArray(new Object[] { gamma, beta, alpha });
  }
  




  public static gnu.mapping.Values extrinsicYzx(Quaternion q)
  {
    Object localObject1 = intrinsicXzy(q);int i = 0;i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject2 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject3 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object gamma = gnu.mapping.Values.getFromPosFinal(localObject1, i);
    Object beta;
    Object alpha;
    return gnu.mapping.Values.makeFromArray(new Object[] { gamma, beta, alpha });
  }
  





  public static gnu.mapping.Values extrinsicYzy(Quaternion q)
  {
    Object localObject1 = intrinsicYzy(q);int i = 0;i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject2 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject3 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object gamma = gnu.mapping.Values.getFromPosFinal(localObject1, i);
    Object beta;
    Object alpha;
    return gnu.mapping.Values.makeFromArray(new Object[] { gamma, beta, alpha });
  }
  






  public static gnu.mapping.Values extrinsicZxy(Quaternion q)
  {
    Object localObject1 = intrinsicYxz(q);int i = 0;i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject2 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject3 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object gamma = gnu.mapping.Values.getFromPosFinal(localObject1, i);
    Object beta;
    Object alpha;
    return gnu.mapping.Values.makeFromArray(new Object[] { gamma, beta, alpha });
  }
  







  public static gnu.mapping.Values extrinsicZxz(Quaternion q)
  {
    Object localObject1 = intrinsicZxz(q);int i = 0;i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject2 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject3 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object gamma = gnu.mapping.Values.getFromPosFinal(localObject1, i);
    Object beta;
    Object alpha;
    return gnu.mapping.Values.makeFromArray(new Object[] { gamma, beta, alpha });
  }
  








  public static gnu.mapping.Values extrinsicZyx(Quaternion q)
  {
    Object localObject1 = intrinsicXyz(q);int i = 0;i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject2 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject3 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object gamma = gnu.mapping.Values.getFromPosFinal(localObject1, i);
    Object beta;
    Object alpha;
    return gnu.mapping.Values.makeFromArray(new Object[] { gamma, beta, alpha });
  }
  









  public static gnu.mapping.Values extrinsicZyz(Quaternion q)
  {
    Object localObject1 = intrinsicZyz(q);int i = 0;i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject2 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject3 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object gamma = gnu.mapping.Values.getFromPosFinal(localObject1, i);
    Object beta;
    Object alpha;
    return gnu.mapping.Values.makeFromArray(new Object[] { gamma, beta, alpha });
  }
  





































  public static Quaternion makeExtrinsicXyx(gnu.math.RealNum gamma, gnu.math.RealNum beta, gnu.math.RealNum alpha)
  {
    try
    {
      return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotx(alpha), roty(beta)), rotx(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeExtrinsicXyz(gnu.math.RealNum gamma, gnu.math.RealNum beta, gnu.math.RealNum alpha) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotz(alpha), roty(beta)), rotx(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeExtrinsicXzx(gnu.math.RealNum gamma, gnu.math.RealNum beta, gnu.math.RealNum alpha) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotx(alpha), rotz(beta)), rotx(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeExtrinsicXzy(gnu.math.RealNum gamma, gnu.math.RealNum beta, gnu.math.RealNum alpha) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(roty(alpha), rotz(beta)), rotx(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeExtrinsicYxy(gnu.math.RealNum gamma, gnu.math.RealNum beta, gnu.math.RealNum alpha) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(roty(alpha), rotx(beta)), roty(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeExtrinsicYxz(gnu.math.RealNum gamma, gnu.math.RealNum beta, gnu.math.RealNum alpha) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotz(alpha), rotx(beta)), roty(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeExtrinsicYzx(gnu.math.RealNum gamma, gnu.math.RealNum beta, gnu.math.RealNum alpha) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotx(alpha), rotz(beta)), roty(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeExtrinsicYzy(gnu.math.RealNum gamma, gnu.math.RealNum beta, gnu.math.RealNum alpha) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(roty(alpha), rotz(beta)), roty(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeExtrinsicZxy(gnu.math.RealNum gamma, gnu.math.RealNum beta, gnu.math.RealNum alpha) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(roty(alpha), rotx(beta)), rotz(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeExtrinsicZxz(gnu.math.RealNum gamma, gnu.math.RealNum beta, gnu.math.RealNum alpha) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotz(alpha), rotx(beta)), rotz(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeExtrinsicZyx(gnu.math.RealNum gamma, gnu.math.RealNum beta, gnu.math.RealNum alpha) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotx(alpha), roty(beta)), rotz(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject); } }
  public static Quaternion makeExtrinsicZyz(gnu.math.RealNum gamma, gnu.math.RealNum beta, gnu.math.RealNum alpha) { try { return (Quaternion)quaternions.unitQuaternion((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(rotz(alpha), roty(beta)), rotz(gamma)), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "unit-quaternion", 1, localObject);
    }
  }
  
  static
  {
    Lit75 = gnu.mapping.Symbol.valueOf("quasiquote");Lit74 = gnu.mapping.Symbol.valueOf("M");Lit73 = gnu.mapping.Symbol.valueOf("$lookup$");Lit72 = new Object[0];Lit71 = gnu.mapping.Symbol.valueOf("make-rotation-procedure");Lit70 = gnu.mapping.Symbol.valueOf("make-extrinsic-zyz");Lit69 = gnu.mapping.Symbol.valueOf("make-extrinsic-zyx");Lit68 = gnu.mapping.Symbol.valueOf("make-extrinsic-zxz");Lit67 = gnu.mapping.Symbol.valueOf("make-extrinsic-zxy");Lit66 = gnu.mapping.Symbol.valueOf("make-extrinsic-yzy");Lit65 = gnu.mapping.Symbol.valueOf("make-extrinsic-yzx");Lit64 = gnu.mapping.Symbol.valueOf("make-extrinsic-yxz");Lit63 = gnu.mapping.Symbol.valueOf("make-extrinsic-yxy");Lit62 = gnu.mapping.Symbol.valueOf("make-extrinsic-xzy");Lit61 = gnu.mapping.Symbol.valueOf("make-extrinsic-xzx");Lit60 = gnu.mapping.Symbol.valueOf("make-extrinsic-xyz");Lit59 = gnu.mapping.Symbol.valueOf("make-extrinsic-xyx");Lit58 = gnu.mapping.Symbol.valueOf("extrinsic-zyz");Lit57 = gnu.mapping.Symbol.valueOf("extrinsic-zyx");Lit56 = gnu.mapping.Symbol.valueOf("extrinsic-zxz");Lit55 = gnu.mapping.Symbol.valueOf("extrinsic-zxy");Lit54 = gnu.mapping.Symbol.valueOf("extrinsic-yzy");Lit53 = gnu.mapping.Symbol.valueOf("extrinsic-yzx");Lit52 = gnu.mapping.Symbol.valueOf("extrinsic-yxz");Lit51 = gnu.mapping.Symbol.valueOf("extrinsic-yxy");Lit50 = gnu.mapping.Symbol.valueOf("extrinsic-xzy");Lit49 = gnu.mapping.Symbol.valueOf("extrinsic-xzx");Lit48 = gnu.mapping.Symbol.valueOf("extrinsic-xyz");Lit47 = gnu.mapping.Symbol.valueOf("extrinsic-xyx");Lit46 = gnu.mapping.Symbol.valueOf("make-intrinsic-zyx");Lit45 = gnu.mapping.Symbol.valueOf("make-intrinsic-zxy");Lit44 = gnu.mapping.Symbol.valueOf("make-intrinsic-yzx");Lit43 = gnu.mapping.Symbol.valueOf("make-intrinsic-yxz");Lit42 = gnu.mapping.Symbol.valueOf("make-intrinsic-xzy");Lit41 = gnu.mapping.Symbol.valueOf("make-intrinsic-xyz");Lit40 = gnu.mapping.Symbol.valueOf("make-intrinsic-zyz");Lit39 = gnu.mapping.Symbol.valueOf("make-intrinsic-zxz");Lit38 = gnu.mapping.Symbol.valueOf("make-intrinsic-yzy");Lit37 = gnu.mapping.Symbol.valueOf("make-intrinsic-yxy");Lit36 = gnu.mapping.Symbol.valueOf("make-intrinsic-xzx");Lit35 = gnu.mapping.Symbol.valueOf("make-intrinsic-xyx");Lit34 = gnu.mapping.Symbol.valueOf("intrinsic-zyx");Lit33 = gnu.mapping.Symbol.valueOf("intrinsic-zxy");Lit32 = gnu.mapping.Symbol.valueOf("intrinsic-yzx");Lit31 = gnu.mapping.Symbol.valueOf("intrinsic-yxz");Lit30 = gnu.mapping.Symbol.valueOf("intrinsic-xzy");Lit29 = gnu.mapping.Symbol.valueOf("intrinsic-xyz");Lit28 = gnu.mapping.Symbol.valueOf("intrinsic-zyz");Lit27 = gnu.mapping.Symbol.valueOf("intrinsic-zxz");Lit26 = gnu.mapping.Symbol.valueOf("intrinsic-yzy");Lit25 = gnu.mapping.Symbol.valueOf("intrinsic-yxy");Lit24 = gnu.mapping.Symbol.valueOf("intrinsic-xzx");Lit23 = gnu.mapping.Symbol.valueOf("intrinsic-xyx");Lit22 = gnu.mapping.Symbol.valueOf("rotz");Lit21 = gnu.mapping.Symbol.valueOf("roty");Lit20 = gnu.mapping.Symbol.valueOf("rotx");Lit19 = gnu.mapping.Symbol.valueOf("rotation-axis/angle");Lit18 = gnu.mapping.Symbol.valueOf("rotation-angle");Lit17 = gnu.mapping.Symbol.valueOf("rotation-axis");Lit16 = gnu.mapping.Symbol.valueOf("rotation-matrix->quaternion");Lit15 = gnu.mapping.Symbol.valueOf("quaternion->rotation-matrix"); kawa.lang.SyntaxRule[] tmp565_562 = new kawa.lang.SyntaxRule[1]; Object[] tmp598_595 = new Object[4]; Object[] tmp599_598 = tmp598_595;tmp599_598[0] = gnu.lists.PairWithPosition.make(Lit73, gnu.lists.Pair.make(Lit74, gnu.lists.Pair.make(gnu.lists.Pair.make(Lit75, gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("min"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm", 450573); Object[] tmp644_599 = tmp599_598;tmp644_599[1] = gnu.lists.PairWithPosition.make(Lit73, gnu.lists.Pair.make(Lit74, gnu.lists.Pair.make(gnu.lists.Pair.make(Lit75, gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("max"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm", 450580); Object[] tmp689_644 = tmp644_599;tmp689_644[2] = gnu.lists.PairWithPosition.make(Double.valueOf(-1), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm", 450588);tmp689_644[3] = gnu.lists.PairWithPosition.make(Double.valueOf(1.0D), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm", 450594);tmp565_562[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit72, 1, "rotations.scm:110"), "\001", "\021\030\0049\021\030\f\t\003\030\024\030\034", tmp598_595, 0);Lit14 = new kawa.lang.SyntaxRules(Lit72, tmp565_562, 1, rotations.Lit13 = gnu.mapping.Symbol.valueOf("u"));Lit12 = gnu.mapping.Symbol.valueOf("rotate-vector");Lit11 = gnu.math.DFloNum.valueOf(0.0D);Lit10 = new gnu.math.CComplex(rotations.Lit0 = gnu.math.IntNum.valueOf(0), rotations.Lit2 = gnu.math.IntNum.valueOf(1));Lit9 = new gnu.math.IntFraction(Lit2, Lit76);Lit8 = new gnu.math.IntFraction(Lit2, Lit76);Lit7 = new gnu.math.IntFraction(Lit2, Lit76);Lit6 = new gnu.math.IntFraction(Lit2, Lit76);Lit5 = new gnu.math.IntFraction(Lit2, rotations.Lit3 = gnu.math.IntNum.valueOf(2));Lit4 = Double.valueOf(1.0E-12D);Lit1 = gnu.math.IntNum.valueOf(3);$Prvt$M = Math.class;$instance = new rotations();$Prvt$define = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
    $Prvt$quaternion = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.numbers", "quaternion");$Prvt$unit$Mnquaternion = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.quaternions", "unit$Mnquaternion");$Prvt$$Pl = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Pl");$Prvt$$Mn = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Mn");$Prvt$$St = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.functions.MultiplyOp", "$St");$Prvt$u = kawa.lang.Macro.make(Lit13, Lit14, "kawa.lib.kawa.rotations");rotations localRotations1 = $instance; void tmp1011_1008 = new gnu.expr.ModuleMethod(localRotations1, 2, null, 8194);tmp1011_1008.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm:145");lambda$Fn1 = tmp1011_1008;quaternion$Mn$Grrotation$Mnmatrix = new gnu.expr.ModuleMethod(localRotations1, 3, Lit15, 4097);rotation$Mnmatrix$Mn$Grquaternion = new gnu.expr.ModuleMethod(localRotations1, 4, Lit16, 4097);rotation$Mnaxis = new gnu.expr.ModuleMethod(localRotations1, 5, Lit17, 4097);rotation$Mnangle = new gnu.expr.ModuleMethod(localRotations1, 6, Lit18, 4097);rotation$Mnaxis$Slangle = new gnu.expr.ModuleMethod(localRotations1, 7, Lit19, 4097); void 
    












































































































      tmp1126_1123 = new gnu.expr.GenericProc("make-axis/angle");
    rotations $instance = $instance; void tmp1147_1144 = new gnu.expr.ModuleMethod($instance, 8, "make-axis/angle", 8194);tmp1147_1144.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm:205");tmp1126_1123.add(tmp1147_1144); void tmp1160_1126 = tmp1126_1123;
    




    rotations $instance = $instance; void tmp1181_1178 = new gnu.expr.ModuleMethod($instance, 9, "make-axis/angle", 16388);tmp1181_1178.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm:211");tmp1160_1126.add(tmp1181_1178);make$Mnaxis$Slangle = tmp1160_1126;rotx = new gnu.expr.ModuleMethod(localRotations1, 10, Lit20, 4097);roty = new gnu.expr.ModuleMethod(localRotations1, 11, Lit21, 4097);rotz = new gnu.expr.ModuleMethod(localRotations1, 12, Lit22, 4097);intrinsic$Mnxyx = new gnu.expr.ModuleMethod(localRotations1, 13, Lit23, 4097);intrinsic$Mnxzx = new gnu.expr.ModuleMethod(localRotations1, 14, Lit24, 4097);intrinsic$Mnyxy = new gnu.expr.ModuleMethod(localRotations1, 15, Lit25, 4097);intrinsic$Mnyzy = new gnu.expr.ModuleMethod(localRotations1, 16, Lit26, 4097);intrinsic$Mnzxz = new gnu.expr.ModuleMethod(localRotations1, 17, Lit27, 4097);intrinsic$Mnzyz = new gnu.expr.ModuleMethod(localRotations1, 18, Lit28, 4097);
    



















































































































































































    euler$Mnxyx = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnxyx");
    euler$Mnxzx = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnxzx");
    euler$Mnyxy = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnyxy");
    euler$Mnyzy = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnyzy");
    euler$Mnzxz = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnzxz");
    euler$Mnzyz = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnzyz");intrinsic$Mnxyz = new gnu.expr.ModuleMethod(localRotations1, 19, Lit29, 4097);intrinsic$Mnxzy = new gnu.expr.ModuleMethod(localRotations1, 20, Lit30, 4097);intrinsic$Mnyxz = new gnu.expr.ModuleMethod(localRotations1, 21, Lit31, 4097);intrinsic$Mnyzx = new gnu.expr.ModuleMethod(localRotations1, 22, Lit32, 4097);intrinsic$Mnzxy = new gnu.expr.ModuleMethod(localRotations1, 23, Lit33, 4097);intrinsic$Mnzyx = new gnu.expr.ModuleMethod(localRotations1, 24, Lit34, 4097);
    



















































































































































    tait$Mnbryan$Mnxyz = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnxyz");
    tait$Mnbryan$Mnxzy = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnxzy");
    tait$Mnbryan$Mnyxz = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnyxz");
    tait$Mnbryan$Mnyzx = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnyzx");
    tait$Mnbryan$Mnzxy = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnzxy");
    tait$Mnbryan$Mnzyx = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "intrinsic$Mnzyx");make$Mnintrinsic$Mnxyx = new gnu.expr.ModuleMethod(localRotations1, 25, Lit35, 12291);make$Mnintrinsic$Mnxzx = new gnu.expr.ModuleMethod(localRotations1, 26, Lit36, 12291);make$Mnintrinsic$Mnyxy = new gnu.expr.ModuleMethod(localRotations1, 27, Lit37, 12291);make$Mnintrinsic$Mnyzy = new gnu.expr.ModuleMethod(localRotations1, 28, Lit38, 12291);make$Mnintrinsic$Mnzxz = new gnu.expr.ModuleMethod(localRotations1, 29, Lit39, 12291);make$Mnintrinsic$Mnzyz = new gnu.expr.ModuleMethod(localRotations1, 30, Lit40, 12291);make$Mnintrinsic$Mnxyz = new gnu.expr.ModuleMethod(localRotations1, 31, Lit41, 12291);make$Mnintrinsic$Mnxzy = new gnu.expr.ModuleMethod(localRotations1, 32, Lit42, 12291);make$Mnintrinsic$Mnyxz = new gnu.expr.ModuleMethod(localRotations1, 33, Lit43, 12291);make$Mnintrinsic$Mnyzx = new gnu.expr.ModuleMethod(localRotations1, 34, Lit44, 12291);make$Mnintrinsic$Mnzxy = new gnu.expr.ModuleMethod(localRotations1, 35, Lit45, 12291);make$Mnintrinsic$Mnzyx = new gnu.expr.ModuleMethod(localRotations1, 36, Lit46, 12291);
    












































    make$Mneuler$Mnxyx = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnxyx");
    make$Mneuler$Mnxzx = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnxzx");
    make$Mneuler$Mnyxy = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnyxy");
    make$Mneuler$Mnyzy = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnyzy");
    make$Mneuler$Mnzxz = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnzxz");
    make$Mneuler$Mnzyz = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnzyz");
    

    make$Mntait$Mnbryan$Mnxyz = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnxyz");
    make$Mntait$Mnbryan$Mnxzy = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnxzy");
    make$Mntait$Mnbryan$Mnyxz = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnyxz");
    make$Mntait$Mnbryan$Mnyzx = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnyzx");
    make$Mntait$Mnbryan$Mnzxy = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnzxy");
    make$Mntait$Mnbryan$Mnzyx = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnintrinsic$Mnzyx");extrinsic$Mnxyx = new gnu.expr.ModuleMethod(localRotations1, 37, Lit47, 4097);extrinsic$Mnxyz = new gnu.expr.ModuleMethod(localRotations1, 38, Lit48, 4097);extrinsic$Mnxzx = new gnu.expr.ModuleMethod(localRotations1, 39, Lit49, 4097);extrinsic$Mnxzy = new gnu.expr.ModuleMethod(localRotations1, 40, Lit50, 4097);extrinsic$Mnyxy = new gnu.expr.ModuleMethod(localRotations1, 41, Lit51, 4097);extrinsic$Mnyxz = new gnu.expr.ModuleMethod(localRotations1, 42, Lit52, 4097);extrinsic$Mnyzx = new gnu.expr.ModuleMethod(localRotations1, 43, Lit53, 4097);extrinsic$Mnyzy = new gnu.expr.ModuleMethod(localRotations1, 44, Lit54, 4097);extrinsic$Mnzxy = new gnu.expr.ModuleMethod(localRotations1, 45, Lit55, 4097);extrinsic$Mnzxz = new gnu.expr.ModuleMethod(localRotations1, 46, Lit56, 4097);extrinsic$Mnzyx = new gnu.expr.ModuleMethod(localRotations1, 47, Lit57, 4097);extrinsic$Mnzyz = new gnu.expr.ModuleMethod(localRotations1, 48, Lit58, 4097);make$Mnextrinsic$Mnxyx = new gnu.expr.ModuleMethod(localRotations1, 49, Lit59, 12291);make$Mnextrinsic$Mnxyz = new gnu.expr.ModuleMethod(localRotations1, 50, Lit60, 12291);make$Mnextrinsic$Mnxzx = new gnu.expr.ModuleMethod(localRotations1, 51, Lit61, 12291);make$Mnextrinsic$Mnxzy = new gnu.expr.ModuleMethod(localRotations1, 52, Lit62, 12291);make$Mnextrinsic$Mnyxy = new gnu.expr.ModuleMethod(localRotations1, 53, Lit63, 12291);make$Mnextrinsic$Mnyxz = new gnu.expr.ModuleMethod(localRotations1, 54, Lit64, 12291);make$Mnextrinsic$Mnyzx = new gnu.expr.ModuleMethod(localRotations1, 55, Lit65, 12291);make$Mnextrinsic$Mnyzy = new gnu.expr.ModuleMethod(localRotations1, 56, Lit66, 12291);make$Mnextrinsic$Mnzxy = new gnu.expr.ModuleMethod(localRotations1, 57, Lit67, 12291);make$Mnextrinsic$Mnzxz = new gnu.expr.ModuleMethod(localRotations1, 58, Lit68, 12291);make$Mnextrinsic$Mnzyx = new gnu.expr.ModuleMethod(localRotations1, 59, Lit69, 12291);make$Mnextrinsic$Mnzyz = new gnu.expr.ModuleMethod(localRotations1, 60, Lit70, 12291);
    


















































































    rpy = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "extrinsic$Mnxyz");
    make$Mnrpy = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.kawa.rotations", "make$Mnextrinsic$Mnxyz");make$Mnrotation$Mnprocedure = new gnu.expr.ModuleMethod(localRotations1, 61, Lit71, 4097);rotate$Mnvector = new gnu.expr.ModuleMethod(localRotations1, 62, Lit12, 8194);$runBody$();
  }
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {} try { return quaternion$To$RotationMatrix((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      


































































































































































































































































































































































































































































































































































































        localClassCastException1, "quaternion->rotation-matrix", 1, paramObject);
    }
    try
    {
      return rotationMatrix$To$Quaternion((gnu.lists.Array)gnu.mapping.Promise.force(paramObject, gnu.lists.Array.class)); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "rotation-matrix->quaternion", 1, paramObject);
    }
    





































    try
    {
      return rotationAxis((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "rotation-axis", 1, paramObject);
    }
    
    try
    {
      return rotationAngle((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "rotation-angle", 1, paramObject);
    }
    try
    {
      return rotationAxis$SlAngle((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "rotation-axis/angle", 1, paramObject);
    }
    














    try
    {
      return rotx(gnu.kawa.lispexpr.LangObjType.coerceRealNum(gnu.mapping.Promise.force(paramObject, gnu.math.RealNum.class))); } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(localClassCastException6, "rotx", 1, paramObject);
    }
    

    try
    {
      return roty(gnu.kawa.lispexpr.LangObjType.coerceRealNum(gnu.mapping.Promise.force(paramObject, gnu.math.RealNum.class))); } catch (ClassCastException localClassCastException7) { throw new gnu.mapping.WrongType(localClassCastException7, "roty", 1, paramObject);
    }
    

    try
    {
      return rotz(gnu.kawa.lispexpr.LangObjType.coerceRealNum(gnu.mapping.Promise.force(paramObject, gnu.math.RealNum.class))); } catch (ClassCastException localClassCastException8) { throw new gnu.mapping.WrongType(localClassCastException8, "rotz", 1, paramObject);
    }
    









    try
    {
      return intrinsicXyx((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException9) { throw new gnu.mapping.WrongType(localClassCastException9, "intrinsic-xyx", 1, paramObject);
    }
    



















    try
    {
      return intrinsicXzx((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException10) { throw new gnu.mapping.WrongType(localClassCastException10, "intrinsic-xzx", 1, paramObject);
    }
    




















    try
    {
      return intrinsicYxy((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException11) { throw new gnu.mapping.WrongType(localClassCastException11, "intrinsic-yxy", 1, paramObject);
    }
    




















    try
    {
      return intrinsicYzy((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException12) { throw new gnu.mapping.WrongType(localClassCastException12, "intrinsic-yzy", 1, paramObject);
    }
    




















    try
    {
      return intrinsicZxz((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException13) { throw new gnu.mapping.WrongType(localClassCastException13, "intrinsic-zxz", 1, paramObject);
    }
    




















    try
    {
      return intrinsicZyz((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException14) { throw new gnu.mapping.WrongType(localClassCastException14, "intrinsic-zyz", 1, paramObject);
    }
    






























    try
    {
      return intrinsicXyz((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException15) { throw new gnu.mapping.WrongType(localClassCastException15, "intrinsic-xyz", 1, paramObject);
    }
    



















    try
    {
      return intrinsicXzy((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException16) { throw new gnu.mapping.WrongType(localClassCastException16, "intrinsic-xzy", 1, paramObject);
    }
    



















    try
    {
      return intrinsicYxz((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException17) { throw new gnu.mapping.WrongType(localClassCastException17, "intrinsic-yxz", 1, paramObject);
    }
    



















    try
    {
      return intrinsicYzx((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException18) { throw new gnu.mapping.WrongType(localClassCastException18, "intrinsic-yzx", 1, paramObject);
    }
    



















    try
    {
      return intrinsicZxy((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException19) { throw new gnu.mapping.WrongType(localClassCastException19, "intrinsic-zxy", 1, paramObject);
    }
    



















    try
    {
      return intrinsicZyx((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException20) { throw new gnu.mapping.WrongType(localClassCastException20, "intrinsic-zyx", 1, paramObject); } try { return extrinsicXyx((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException21) { throw new gnu.mapping.WrongType(localClassCastException21, "extrinsic-xyx", 1, paramObject); } try { return extrinsicXyz((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException22) { throw new gnu.mapping.WrongType(localClassCastException22, "extrinsic-xyz", 1, paramObject); } try { return extrinsicXzx((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException23) { throw new gnu.mapping.WrongType(localClassCastException23, "extrinsic-xzx", 1, paramObject); } try { return extrinsicXzy((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException24) { throw new gnu.mapping.WrongType(localClassCastException24, "extrinsic-xzy", 1, paramObject); } try { return extrinsicYxy((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException25) { throw new gnu.mapping.WrongType(localClassCastException25, "extrinsic-yxy", 1, paramObject); } try { return extrinsicYxz((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException26) { throw new gnu.mapping.WrongType(localClassCastException26, "extrinsic-yxz", 1, paramObject); } try { return extrinsicYzx((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException27) { throw new gnu.mapping.WrongType(localClassCastException27, "extrinsic-yzx", 1, paramObject); } try { return extrinsicYzy((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException28) { throw new gnu.mapping.WrongType(localClassCastException28, "extrinsic-yzy", 1, paramObject); } try { return extrinsicZxy((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException29) { throw new gnu.mapping.WrongType(localClassCastException29, "extrinsic-zxy", 1, paramObject); } try { return extrinsicZxz((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException30) { throw new gnu.mapping.WrongType(localClassCastException30, "extrinsic-zxz", 1, paramObject); } try { return extrinsicZyx((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException31) { throw new gnu.mapping.WrongType(localClassCastException31, "extrinsic-zyx", 1, paramObject); } try { return extrinsicZyz((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException32) { throw new gnu.mapping.WrongType(localClassCastException32, "extrinsic-zyz", 1, paramObject);
    }
    


















































































































































































    try
    {
      return makeRotationProcedure((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException33) { throw new gnu.mapping.WrongType(localClassCastException33, "make-rotation-procedure", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); } public static gnu.mapping.Procedure makeRotationProcedure(Quaternion rotation) { frame $heapFrame = new frame();
    uq = quaternions.unitQuaternion(rotation);
    uq$St = quaternions.conjugate(uq);
    return lambda$Fn2; } public class frame extends gnu.expr.ModuleBody { Number uq$St; public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject) { if (selector != 1) {} try { return lambda2((Quaternion)gnu.mapping.Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException) { throw new gnu.mapping.WrongType(localClassCastException, "lambda", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { gnu.expr.ModuleMethod.applyError(); } public int match1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { Object tmp18_15 = gnu.mapping.Promise.force(paramObject, Quaternion.class);
        



































































































































































































































































































































































































































































































































































































































































































































        if (!(tmp18_15 instanceof Quaternion)) return -786431; value1 = tmp18_15;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
    Number uq; Quaternion lambda2(Quaternion vec) { if (quaternions.isVectorQuaternion(vec)) {}
      try { tmpTernaryOp = quaternions.vectorPart((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(uq, vec), uq$St), Number.class)));
        break label60; throw gnu.expr.Special.reachedUnexpected; label60: return kawa.lib.exceptions.error(new Object[] { "vec must be vector quaternion" });
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject;
        throw new gnu.mapping.WrongType(
          localClassCastException, "vector-part", 1, localObject); } }
    
    final gnu.expr.ModuleMethod lambda$Fn2;
    public frame() { void tmp18_15 = new gnu.expr.ModuleMethod(this, 1, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/rotations.scm:709");
      lambda$Fn2 = tmp18_15; } }
  
  public static Quaternion rotateVector(Quaternion rotation, Quaternion vec) { Number uq; Number uq$St; if (quaternions.isVectorQuaternion(vec)) {
      uq = quaternions.unitQuaternion(rotation);
      uq$St = quaternions.conjugate(uq); }
    try { tmpTernaryOp = quaternions.vectorPart((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.kawa.functions.MultiplyOp.$St.apply2(uq, vec), uq$St), Number.class)));
      break label72; throw gnu.expr.Special.reachedUnexpected; label72: return kawa.lib.exceptions.error(new Object[] { Lit12, "vec must be vector quaternion" });
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new gnu.mapping.WrongType(
        localClassCastException, "vector-part", 1, localObject);
    }
  }
  
  /* Error */
  public static gnu.lists.Array quaternion$To$RotationMatrix(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/kawa/quaternions:unitQuaternion	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 21	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   9: dup
    //   10: astore 4
    //   12: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   15: dstore_2
    //   16: aload_1
    //   17: invokestatic 40	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   20: dup
    //   21: astore 6
    //   23: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   26: dstore 4
    //   28: aload_1
    //   29: invokestatic 45	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   32: dup
    //   33: astore 8
    //   35: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   38: dstore 6
    //   40: aload_1
    //   41: invokestatic 50	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   44: dup
    //   45: astore 10
    //   47: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   50: dstore 8
    //   52: new 54	gnu/lists/F64Vector
    //   55: dup
    //   56: invokespecial 57	gnu/lists/F64Vector:<init>	()V
    //   59: dup
    //   60: dload_2
    //   61: dload_2
    //   62: dmul
    //   63: dload 4
    //   65: dload 4
    //   67: dmul
    //   68: dadd
    //   69: dload 6
    //   71: dload 6
    //   73: dmul
    //   74: dload 8
    //   76: dload 8
    //   78: dmul
    //   79: dadd
    //   80: dsub
    //   81: iconst_m1
    //   82: i2d
    //   83: invokestatic 63	java/lang/Math:max	(DD)D
    //   86: dconst_1
    //   87: invokestatic 66	java/lang/Math:min	(DD)D
    //   90: invokevirtual 70	gnu/lists/F64Vector:add	(D)V
    //   93: dup
    //   94: iconst_2
    //   95: i2d
    //   96: dload 4
    //   98: dload 6
    //   100: dmul
    //   101: dload_2
    //   102: dload 8
    //   104: dmul
    //   105: dsub
    //   106: dmul
    //   107: iconst_m1
    //   108: i2d
    //   109: invokestatic 63	java/lang/Math:max	(DD)D
    //   112: dconst_1
    //   113: invokestatic 66	java/lang/Math:min	(DD)D
    //   116: invokevirtual 70	gnu/lists/F64Vector:add	(D)V
    //   119: dup
    //   120: iconst_2
    //   121: i2d
    //   122: dload 4
    //   124: dload 8
    //   126: dmul
    //   127: dload_2
    //   128: dload 6
    //   130: dmul
    //   131: dadd
    //   132: dmul
    //   133: iconst_m1
    //   134: i2d
    //   135: invokestatic 63	java/lang/Math:max	(DD)D
    //   138: dconst_1
    //   139: invokestatic 66	java/lang/Math:min	(DD)D
    //   142: invokevirtual 70	gnu/lists/F64Vector:add	(D)V
    //   145: dup
    //   146: iconst_2
    //   147: i2d
    //   148: dload 4
    //   150: dload 6
    //   152: dmul
    //   153: dload_2
    //   154: dload 8
    //   156: dmul
    //   157: dadd
    //   158: dmul
    //   159: iconst_m1
    //   160: i2d
    //   161: invokestatic 63	java/lang/Math:max	(DD)D
    //   164: dconst_1
    //   165: invokestatic 66	java/lang/Math:min	(DD)D
    //   168: invokevirtual 70	gnu/lists/F64Vector:add	(D)V
    //   171: dup
    //   172: dload_2
    //   173: dload_2
    //   174: dmul
    //   175: dload 6
    //   177: dload 6
    //   179: dmul
    //   180: dadd
    //   181: dload 4
    //   183: dload 4
    //   185: dmul
    //   186: dload 8
    //   188: dload 8
    //   190: dmul
    //   191: dadd
    //   192: dsub
    //   193: iconst_m1
    //   194: i2d
    //   195: invokestatic 63	java/lang/Math:max	(DD)D
    //   198: dconst_1
    //   199: invokestatic 66	java/lang/Math:min	(DD)D
    //   202: invokevirtual 70	gnu/lists/F64Vector:add	(D)V
    //   205: dup
    //   206: iconst_2
    //   207: i2d
    //   208: dload 6
    //   210: dload 8
    //   212: dmul
    //   213: dload_2
    //   214: dload 4
    //   216: dmul
    //   217: dsub
    //   218: dmul
    //   219: iconst_m1
    //   220: i2d
    //   221: invokestatic 63	java/lang/Math:max	(DD)D
    //   224: dconst_1
    //   225: invokestatic 66	java/lang/Math:min	(DD)D
    //   228: invokevirtual 70	gnu/lists/F64Vector:add	(D)V
    //   231: dup
    //   232: iconst_2
    //   233: i2d
    //   234: dload 4
    //   236: dload 8
    //   238: dmul
    //   239: dload_2
    //   240: dload 6
    //   242: dmul
    //   243: dsub
    //   244: dmul
    //   245: iconst_m1
    //   246: i2d
    //   247: invokestatic 63	java/lang/Math:max	(DD)D
    //   250: dconst_1
    //   251: invokestatic 66	java/lang/Math:min	(DD)D
    //   254: invokevirtual 70	gnu/lists/F64Vector:add	(D)V
    //   257: dup
    //   258: iconst_2
    //   259: i2d
    //   260: dload_2
    //   261: dload 4
    //   263: dmul
    //   264: dload 6
    //   266: dload 8
    //   268: dmul
    //   269: dadd
    //   270: dmul
    //   271: iconst_m1
    //   272: i2d
    //   273: invokestatic 63	java/lang/Math:max	(DD)D
    //   276: dconst_1
    //   277: invokestatic 66	java/lang/Math:min	(DD)D
    //   280: invokevirtual 70	gnu/lists/F64Vector:add	(D)V
    //   283: dup
    //   284: dload_2
    //   285: dload_2
    //   286: dmul
    //   287: dload 8
    //   289: dload 8
    //   291: dmul
    //   292: dadd
    //   293: dload 4
    //   295: dload 4
    //   297: dmul
    //   298: dload 6
    //   300: dload 6
    //   302: dmul
    //   303: dadd
    //   304: dsub
    //   305: iconst_m1
    //   306: i2d
    //   307: invokestatic 63	java/lang/Math:max	(DD)D
    //   310: dconst_1
    //   311: invokestatic 66	java/lang/Math:min	(DD)D
    //   314: invokevirtual 70	gnu/lists/F64Vector:add	(D)V
    //   317: iconst_4
    //   318: anewarray 72	java/lang/Object
    //   321: dup
    //   322: iconst_0
    //   323: getstatic 78	kawa/lib/kawa/rotations:Lit0	Lgnu/math/IntNum;
    //   326: aastore
    //   327: dup
    //   328: iconst_1
    //   329: getstatic 81	kawa/lib/kawa/rotations:Lit1	Lgnu/math/IntNum;
    //   332: aastore
    //   333: dup
    //   334: iconst_2
    //   335: getstatic 78	kawa/lib/kawa/rotations:Lit0	Lgnu/math/IntNum;
    //   338: aastore
    //   339: dup
    //   340: iconst_3
    //   341: getstatic 81	kawa/lib/kawa/rotations:Lit1	Lgnu/math/IntNum;
    //   344: aastore
    //   345: invokestatic 87	kawa/lib/arrays:shape	([Ljava/lang/Object;)Lgnu/lists/Array;
    //   348: getstatic 108	kawa/lib/kawa/rotations:lambda$Fn1	Lgnu/expr/ModuleMethod;
    //   351: invokestatic 112	kawa/lib/arrays:shareArray	(Lgnu/lists/Array;Lgnu/lists/Array;Lgnu/mapping/Procedure;)Lgnu/lists/Array;
    //   354: areturn
    //   355: new 31	gnu/mapping/WrongType
    //   358: dup_x1
    //   359: swap
    //   360: ldc 33
    //   362: bipush -2
    //   364: aload 4
    //   366: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   369: athrow
    //   370: new 31	gnu/mapping/WrongType
    //   373: dup_x1
    //   374: swap
    //   375: ldc 42
    //   377: bipush -2
    //   379: aload 6
    //   381: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   384: athrow
    //   385: new 31	gnu/mapping/WrongType
    //   388: dup_x1
    //   389: swap
    //   390: ldc 47
    //   392: bipush -2
    //   394: aload 8
    //   396: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   399: athrow
    //   400: new 31	gnu/mapping/WrongType
    //   403: dup_x1
    //   404: swap
    //   405: ldc 52
    //   407: bipush -2
    //   409: aload 10
    //   411: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   414: athrow
    // Line number table:
    //   Java source line #126	-> byte code offset #0
    //   Java source line #128	-> byte code offset #0
    //   Java source line #129	-> byte code offset #5
    //   Java source line #128	-> byte code offset #16
    //   Java source line #130	-> byte code offset #16
    //   Java source line #128	-> byte code offset #28
    //   Java source line #131	-> byte code offset #28
    //   Java source line #128	-> byte code offset #40
    //   Java source line #132	-> byte code offset #40
    //   Java source line #133	-> byte code offset #52
    //   Java source line #134	-> byte code offset #52
    //   Java source line #135	-> byte code offset #60
    //   Java source line #110	-> byte code offset #81
    //   Java source line #136	-> byte code offset #94
    //   Java source line #110	-> byte code offset #107
    //   Java source line #137	-> byte code offset #120
    //   Java source line #110	-> byte code offset #133
    //   Java source line #138	-> byte code offset #146
    //   Java source line #110	-> byte code offset #159
    //   Java source line #139	-> byte code offset #172
    //   Java source line #110	-> byte code offset #193
    //   Java source line #140	-> byte code offset #206
    //   Java source line #110	-> byte code offset #219
    //   Java source line #141	-> byte code offset #232
    //   Java source line #110	-> byte code offset #245
    //   Java source line #142	-> byte code offset #258
    //   Java source line #110	-> byte code offset #271
    //   Java source line #143	-> byte code offset #284
    //   Java source line #110	-> byte code offset #305
    //   Java source line #144	-> byte code offset #317
    //   Java source line #145	-> byte code offset #348
    //   Java source line #129	-> byte code offset #355
    //   Java source line #130	-> byte code offset #370
    //   Java source line #131	-> byte code offset #385
    //   Java source line #132	-> byte code offset #400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	q	Quaternion
    //   4	37	1	uq	Number
    //   15	271	2	r	double
    //   10	1	4	localNumber1	Number
    //   26	339	4	i	double
    //   21	1	6	localNumber2	Number
    //   38	342	6	j	double
    //   33	1	8	localNumber3	Number
    //   50	345	8	k	double
    //   45	365	10	localNumber4	Number
    //   355	1	10	localClassCastException1	ClassCastException
    //   370	1	11	localClassCastException2	ClassCastException
    //   385	1	12	localClassCastException3	ClassCastException
    //   400	1	13	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	15	355	java/lang/ClassCastException
    //   23	26	370	java/lang/ClassCastException
    //   35	38	385	java/lang/ClassCastException
    //   47	50	400	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object intrinsicXyx(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/kawa/quaternions:unitQuaternion	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 21	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   9: dup
    //   10: astore 4
    //   12: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   15: dstore_2
    //   16: aload_1
    //   17: invokestatic 40	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   20: dup
    //   21: astore 6
    //   23: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   26: dstore 4
    //   28: aload_1
    //   29: invokestatic 45	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   32: dup
    //   33: astore 8
    //   35: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   38: dstore 6
    //   40: aload_1
    //   41: invokestatic 50	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   44: dup
    //   45: astore 10
    //   47: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   50: dstore 8
    //   52: dload_2
    //   53: dload_2
    //   54: dmul
    //   55: dload 4
    //   57: dload 4
    //   59: dmul
    //   60: dadd
    //   61: dload 6
    //   63: dload 6
    //   65: dmul
    //   66: dload 8
    //   68: dload 8
    //   70: dmul
    //   71: dadd
    //   72: dsub
    //   73: iconst_m1
    //   74: i2d
    //   75: invokestatic 63	java/lang/Math:max	(DD)D
    //   78: dconst_1
    //   79: invokestatic 66	java/lang/Math:min	(DD)D
    //   82: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   85: invokestatic 249	kawa/lib/numbers:acos	(Ljava/lang/Number;)Ljava/lang/Number;
    //   88: astore 10
    //   90: aload 10
    //   92: getstatic 132	kawa/lib/kawa/rotations:Lit4	Ljava/lang/Double;
    //   95: invokestatic 252	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   98: istore 11
    //   100: iload 11
    //   102: ifeq +11 -> 113
    //   105: iload 11
    //   107: ifeq +113 -> 220
    //   110: goto +21 -> 131
    //   113: aload 10
    //   115: getstatic 256	java/lang/Math:PI	D
    //   118: ldc2_w 257
    //   121: dsub
    //   122: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   125: invokestatic 138	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   128: ifeq +92 -> 220
    //   131: iconst_3
    //   132: anewarray 72	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: getstatic 262	kawa/lib/kawa/rotations:Lit11	Lgnu/math/DFloNum;
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: aload 10
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   151: iconst_2
    //   152: i2d
    //   153: dload 6
    //   155: dload 8
    //   157: dmul
    //   158: dload_2
    //   159: dload 4
    //   161: dmul
    //   162: dsub
    //   163: dmul
    //   164: iconst_m1
    //   165: i2d
    //   166: invokestatic 63	java/lang/Math:max	(DD)D
    //   169: dconst_1
    //   170: invokestatic 66	java/lang/Math:min	(DD)D
    //   173: dneg
    //   174: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   177: dload_2
    //   178: dload_2
    //   179: dmul
    //   180: dload 6
    //   182: dload 6
    //   184: dmul
    //   185: dadd
    //   186: dload 4
    //   188: dload 4
    //   190: dmul
    //   191: dload 8
    //   193: dload 8
    //   195: dmul
    //   196: dadd
    //   197: dsub
    //   198: iconst_m1
    //   199: i2d
    //   200: invokestatic 63	java/lang/Math:max	(DD)D
    //   203: dconst_1
    //   204: invokestatic 66	java/lang/Math:min	(DD)D
    //   207: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   210: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   213: aastore
    //   214: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   217: goto +134 -> 351
    //   220: iconst_3
    //   221: anewarray 72	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   229: iconst_2
    //   230: i2d
    //   231: dload 4
    //   233: dload 6
    //   235: dmul
    //   236: dload_2
    //   237: dload 8
    //   239: dmul
    //   240: dadd
    //   241: dmul
    //   242: iconst_m1
    //   243: i2d
    //   244: invokestatic 63	java/lang/Math:max	(DD)D
    //   247: dconst_1
    //   248: invokestatic 66	java/lang/Math:min	(DD)D
    //   251: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   254: iconst_2
    //   255: i2d
    //   256: dload 4
    //   258: dload 8
    //   260: dmul
    //   261: dload_2
    //   262: dload 6
    //   264: dmul
    //   265: dsub
    //   266: dmul
    //   267: iconst_m1
    //   268: i2d
    //   269: invokestatic 63	java/lang/Math:max	(DD)D
    //   272: dconst_1
    //   273: invokestatic 66	java/lang/Math:min	(DD)D
    //   276: dneg
    //   277: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   280: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload 10
    //   288: aastore
    //   289: dup
    //   290: iconst_2
    //   291: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   294: iconst_2
    //   295: i2d
    //   296: dload 4
    //   298: dload 6
    //   300: dmul
    //   301: dload_2
    //   302: dload 8
    //   304: dmul
    //   305: dsub
    //   306: dmul
    //   307: iconst_m1
    //   308: i2d
    //   309: invokestatic 63	java/lang/Math:max	(DD)D
    //   312: dconst_1
    //   313: invokestatic 66	java/lang/Math:min	(DD)D
    //   316: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   319: iconst_2
    //   320: i2d
    //   321: dload 4
    //   323: dload 8
    //   325: dmul
    //   326: dload_2
    //   327: dload 6
    //   329: dmul
    //   330: dadd
    //   331: dmul
    //   332: iconst_m1
    //   333: i2d
    //   334: invokestatic 63	java/lang/Math:max	(DD)D
    //   337: dconst_1
    //   338: invokestatic 66	java/lang/Math:min	(DD)D
    //   341: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   344: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   347: aastore
    //   348: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   351: areturn
    //   352: new 31	gnu/mapping/WrongType
    //   355: dup_x1
    //   356: swap
    //   357: ldc 33
    //   359: bipush -2
    //   361: aload 4
    //   363: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   366: athrow
    //   367: new 31	gnu/mapping/WrongType
    //   370: dup_x1
    //   371: swap
    //   372: ldc 42
    //   374: bipush -2
    //   376: aload 6
    //   378: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   381: athrow
    //   382: new 31	gnu/mapping/WrongType
    //   385: dup_x1
    //   386: swap
    //   387: ldc 47
    //   389: bipush -2
    //   391: aload 8
    //   393: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   396: athrow
    //   397: new 31	gnu/mapping/WrongType
    //   400: dup_x1
    //   401: swap
    //   402: ldc 52
    //   404: bipush -2
    //   406: aload 10
    //   408: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   411: athrow
    // Line number table:
    //   Java source line #244	-> byte code offset #0
    //   Java source line #245	-> byte code offset #0
    //   Java source line #246	-> byte code offset #5
    //   Java source line #245	-> byte code offset #16
    //   Java source line #247	-> byte code offset #16
    //   Java source line #245	-> byte code offset #28
    //   Java source line #248	-> byte code offset #28
    //   Java source line #245	-> byte code offset #40
    //   Java source line #249	-> byte code offset #40
    //   Java source line #251	-> byte code offset #52
    //   Java source line #110	-> byte code offset #73
    //   Java source line #256	-> byte code offset #90
    //   Java source line #257	-> byte code offset #113
    //   Java source line #259	-> byte code offset #131
    //   Java source line #110	-> byte code offset #164
    //   Java source line #259	-> byte code offset #177
    //   Java source line #110	-> byte code offset #198
    //   Java source line #263	-> byte code offset #220
    //   Java source line #110	-> byte code offset #242
    //   Java source line #263	-> byte code offset #254
    //   Java source line #110	-> byte code offset #267
    //   Java source line #265	-> byte code offset #294
    //   Java source line #110	-> byte code offset #307
    //   Java source line #265	-> byte code offset #319
    //   Java source line #110	-> byte code offset #332
    //   Java source line #246	-> byte code offset #352
    //   Java source line #247	-> byte code offset #367
    //   Java source line #248	-> byte code offset #382
    //   Java source line #249	-> byte code offset #397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	q	Quaternion
    //   4	37	1	uq	Number
    //   15	312	2	r	double
    //   10	1	4	localNumber1	Number
    //   26	336	4	i	double
    //   21	1	6	localNumber2	Number
    //   38	339	6	j	double
    //   33	1	8	localNumber3	Number
    //   50	342	8	k	double
    //   45	1	10	localNumber4	Number
    //   88	319	10	beta	Number
    //   98	8	11	x	boolean
    //   352	1	12	localClassCastException1	ClassCastException
    //   367	1	13	localClassCastException2	ClassCastException
    //   382	1	14	localClassCastException3	ClassCastException
    //   397	1	15	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	15	352	java/lang/ClassCastException
    //   23	26	367	java/lang/ClassCastException
    //   35	38	382	java/lang/ClassCastException
    //   47	50	397	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object intrinsicXzx(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/kawa/quaternions:unitQuaternion	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 21	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   9: dup
    //   10: astore 4
    //   12: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   15: dstore_2
    //   16: aload_1
    //   17: invokestatic 40	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   20: dup
    //   21: astore 6
    //   23: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   26: dstore 4
    //   28: aload_1
    //   29: invokestatic 45	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   32: dup
    //   33: astore 8
    //   35: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   38: dstore 6
    //   40: aload_1
    //   41: invokestatic 50	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   44: dup
    //   45: astore 10
    //   47: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   50: dstore 8
    //   52: dload_2
    //   53: dload_2
    //   54: dmul
    //   55: dload 4
    //   57: dload 4
    //   59: dmul
    //   60: dadd
    //   61: dload 6
    //   63: dload 6
    //   65: dmul
    //   66: dload 8
    //   68: dload 8
    //   70: dmul
    //   71: dadd
    //   72: dsub
    //   73: iconst_m1
    //   74: i2d
    //   75: invokestatic 63	java/lang/Math:max	(DD)D
    //   78: dconst_1
    //   79: invokestatic 66	java/lang/Math:min	(DD)D
    //   82: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   85: invokestatic 249	kawa/lib/numbers:acos	(Ljava/lang/Number;)Ljava/lang/Number;
    //   88: astore 10
    //   90: aload 10
    //   92: getstatic 132	kawa/lib/kawa/rotations:Lit4	Ljava/lang/Double;
    //   95: invokestatic 252	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   98: istore 11
    //   100: iload 11
    //   102: ifeq +11 -> 113
    //   105: iload 11
    //   107: ifeq +112 -> 219
    //   110: goto +21 -> 131
    //   113: aload 10
    //   115: getstatic 256	java/lang/Math:PI	D
    //   118: ldc2_w 257
    //   121: dsub
    //   122: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   125: invokestatic 138	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   128: ifeq +91 -> 219
    //   131: iconst_3
    //   132: anewarray 72	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: getstatic 262	kawa/lib/kawa/rotations:Lit11	Lgnu/math/DFloNum;
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: aload 10
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   151: iconst_2
    //   152: i2d
    //   153: dload_2
    //   154: dload 4
    //   156: dmul
    //   157: dload 6
    //   159: dload 8
    //   161: dmul
    //   162: dadd
    //   163: dmul
    //   164: iconst_m1
    //   165: i2d
    //   166: invokestatic 63	java/lang/Math:max	(DD)D
    //   169: dconst_1
    //   170: invokestatic 66	java/lang/Math:min	(DD)D
    //   173: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   176: dload_2
    //   177: dload_2
    //   178: dmul
    //   179: dload 8
    //   181: dload 8
    //   183: dmul
    //   184: dadd
    //   185: dload 4
    //   187: dload 4
    //   189: dmul
    //   190: dload 6
    //   192: dload 6
    //   194: dmul
    //   195: dadd
    //   196: dsub
    //   197: iconst_m1
    //   198: i2d
    //   199: invokestatic 63	java/lang/Math:max	(DD)D
    //   202: dconst_1
    //   203: invokestatic 66	java/lang/Math:min	(DD)D
    //   206: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   209: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: aastore
    //   213: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   216: goto +134 -> 350
    //   219: iconst_3
    //   220: anewarray 72	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   228: iconst_2
    //   229: i2d
    //   230: dload 4
    //   232: dload 8
    //   234: dmul
    //   235: dload_2
    //   236: dload 6
    //   238: dmul
    //   239: dsub
    //   240: dmul
    //   241: iconst_m1
    //   242: i2d
    //   243: invokestatic 63	java/lang/Math:max	(DD)D
    //   246: dconst_1
    //   247: invokestatic 66	java/lang/Math:min	(DD)D
    //   250: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   253: iconst_2
    //   254: i2d
    //   255: dload 4
    //   257: dload 6
    //   259: dmul
    //   260: dload_2
    //   261: dload 8
    //   263: dmul
    //   264: dadd
    //   265: dmul
    //   266: iconst_m1
    //   267: i2d
    //   268: invokestatic 63	java/lang/Math:max	(DD)D
    //   271: dconst_1
    //   272: invokestatic 66	java/lang/Math:min	(DD)D
    //   275: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   278: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   281: aastore
    //   282: dup
    //   283: iconst_1
    //   284: aload 10
    //   286: aastore
    //   287: dup
    //   288: iconst_2
    //   289: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   292: iconst_2
    //   293: i2d
    //   294: dload 4
    //   296: dload 8
    //   298: dmul
    //   299: dload_2
    //   300: dload 6
    //   302: dmul
    //   303: dadd
    //   304: dmul
    //   305: iconst_m1
    //   306: i2d
    //   307: invokestatic 63	java/lang/Math:max	(DD)D
    //   310: dconst_1
    //   311: invokestatic 66	java/lang/Math:min	(DD)D
    //   314: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   317: iconst_2
    //   318: i2d
    //   319: dload 4
    //   321: dload 6
    //   323: dmul
    //   324: dload_2
    //   325: dload 8
    //   327: dmul
    //   328: dsub
    //   329: dmul
    //   330: iconst_m1
    //   331: i2d
    //   332: invokestatic 63	java/lang/Math:max	(DD)D
    //   335: dconst_1
    //   336: invokestatic 66	java/lang/Math:min	(DD)D
    //   339: dneg
    //   340: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   343: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   346: aastore
    //   347: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   350: areturn
    //   351: new 31	gnu/mapping/WrongType
    //   354: dup_x1
    //   355: swap
    //   356: ldc 33
    //   358: bipush -2
    //   360: aload 4
    //   362: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   365: athrow
    //   366: new 31	gnu/mapping/WrongType
    //   369: dup_x1
    //   370: swap
    //   371: ldc 42
    //   373: bipush -2
    //   375: aload 6
    //   377: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   380: athrow
    //   381: new 31	gnu/mapping/WrongType
    //   384: dup_x1
    //   385: swap
    //   386: ldc 47
    //   388: bipush -2
    //   390: aload 8
    //   392: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   395: athrow
    //   396: new 31	gnu/mapping/WrongType
    //   399: dup_x1
    //   400: swap
    //   401: ldc 52
    //   403: bipush -2
    //   405: aload 10
    //   407: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   410: athrow
    // Line number table:
    //   Java source line #268	-> byte code offset #0
    //   Java source line #269	-> byte code offset #0
    //   Java source line #270	-> byte code offset #5
    //   Java source line #269	-> byte code offset #16
    //   Java source line #271	-> byte code offset #16
    //   Java source line #269	-> byte code offset #28
    //   Java source line #272	-> byte code offset #28
    //   Java source line #269	-> byte code offset #40
    //   Java source line #273	-> byte code offset #40
    //   Java source line #275	-> byte code offset #52
    //   Java source line #110	-> byte code offset #73
    //   Java source line #280	-> byte code offset #90
    //   Java source line #281	-> byte code offset #113
    //   Java source line #283	-> byte code offset #131
    //   Java source line #110	-> byte code offset #164
    //   Java source line #283	-> byte code offset #176
    //   Java source line #110	-> byte code offset #197
    //   Java source line #287	-> byte code offset #219
    //   Java source line #110	-> byte code offset #241
    //   Java source line #287	-> byte code offset #253
    //   Java source line #110	-> byte code offset #266
    //   Java source line #289	-> byte code offset #292
    //   Java source line #110	-> byte code offset #305
    //   Java source line #289	-> byte code offset #317
    //   Java source line #110	-> byte code offset #330
    //   Java source line #270	-> byte code offset #351
    //   Java source line #271	-> byte code offset #366
    //   Java source line #272	-> byte code offset #381
    //   Java source line #273	-> byte code offset #396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	q	Quaternion
    //   4	37	1	uq	Number
    //   15	310	2	r	double
    //   10	1	4	localNumber1	Number
    //   26	335	4	i	double
    //   21	1	6	localNumber2	Number
    //   38	338	6	j	double
    //   33	1	8	localNumber3	Number
    //   50	341	8	k	double
    //   45	1	10	localNumber4	Number
    //   88	318	10	beta	Number
    //   98	8	11	x	boolean
    //   351	1	12	localClassCastException1	ClassCastException
    //   366	1	13	localClassCastException2	ClassCastException
    //   381	1	14	localClassCastException3	ClassCastException
    //   396	1	15	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	15	351	java/lang/ClassCastException
    //   23	26	366	java/lang/ClassCastException
    //   35	38	381	java/lang/ClassCastException
    //   47	50	396	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object intrinsicYxy(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/kawa/quaternions:unitQuaternion	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 21	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   9: dup
    //   10: astore 4
    //   12: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   15: dstore_2
    //   16: aload_1
    //   17: invokestatic 40	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   20: dup
    //   21: astore 6
    //   23: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   26: dstore 4
    //   28: aload_1
    //   29: invokestatic 45	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   32: dup
    //   33: astore 8
    //   35: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   38: dstore 6
    //   40: aload_1
    //   41: invokestatic 50	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   44: dup
    //   45: astore 10
    //   47: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   50: dstore 8
    //   52: dload_2
    //   53: dload_2
    //   54: dmul
    //   55: dload 6
    //   57: dload 6
    //   59: dmul
    //   60: dadd
    //   61: dload 4
    //   63: dload 4
    //   65: dmul
    //   66: dload 8
    //   68: dload 8
    //   70: dmul
    //   71: dadd
    //   72: dsub
    //   73: iconst_m1
    //   74: i2d
    //   75: invokestatic 63	java/lang/Math:max	(DD)D
    //   78: dconst_1
    //   79: invokestatic 66	java/lang/Math:min	(DD)D
    //   82: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   85: invokestatic 249	kawa/lib/numbers:acos	(Ljava/lang/Number;)Ljava/lang/Number;
    //   88: astore 10
    //   90: aload 10
    //   92: getstatic 132	kawa/lib/kawa/rotations:Lit4	Ljava/lang/Double;
    //   95: invokestatic 252	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   98: istore 11
    //   100: iload 11
    //   102: ifeq +11 -> 113
    //   105: iload 11
    //   107: ifeq +112 -> 219
    //   110: goto +21 -> 131
    //   113: aload 10
    //   115: getstatic 256	java/lang/Math:PI	D
    //   118: ldc2_w 257
    //   121: dsub
    //   122: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   125: invokestatic 138	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   128: ifeq +91 -> 219
    //   131: iconst_3
    //   132: anewarray 72	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: getstatic 262	kawa/lib/kawa/rotations:Lit11	Lgnu/math/DFloNum;
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: aload 10
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   151: iconst_2
    //   152: i2d
    //   153: dload 4
    //   155: dload 8
    //   157: dmul
    //   158: dload_2
    //   159: dload 6
    //   161: dmul
    //   162: dadd
    //   163: dmul
    //   164: iconst_m1
    //   165: i2d
    //   166: invokestatic 63	java/lang/Math:max	(DD)D
    //   169: dconst_1
    //   170: invokestatic 66	java/lang/Math:min	(DD)D
    //   173: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   176: dload_2
    //   177: dload_2
    //   178: dmul
    //   179: dload 4
    //   181: dload 4
    //   183: dmul
    //   184: dadd
    //   185: dload 6
    //   187: dload 6
    //   189: dmul
    //   190: dload 8
    //   192: dload 8
    //   194: dmul
    //   195: dadd
    //   196: dsub
    //   197: iconst_m1
    //   198: i2d
    //   199: invokestatic 63	java/lang/Math:max	(DD)D
    //   202: dconst_1
    //   203: invokestatic 66	java/lang/Math:min	(DD)D
    //   206: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   209: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: aastore
    //   213: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   216: goto +134 -> 350
    //   219: iconst_3
    //   220: anewarray 72	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   228: iconst_2
    //   229: i2d
    //   230: dload 4
    //   232: dload 6
    //   234: dmul
    //   235: dload_2
    //   236: dload 8
    //   238: dmul
    //   239: dsub
    //   240: dmul
    //   241: iconst_m1
    //   242: i2d
    //   243: invokestatic 63	java/lang/Math:max	(DD)D
    //   246: dconst_1
    //   247: invokestatic 66	java/lang/Math:min	(DD)D
    //   250: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   253: iconst_2
    //   254: i2d
    //   255: dload_2
    //   256: dload 4
    //   258: dmul
    //   259: dload 6
    //   261: dload 8
    //   263: dmul
    //   264: dadd
    //   265: dmul
    //   266: iconst_m1
    //   267: i2d
    //   268: invokestatic 63	java/lang/Math:max	(DD)D
    //   271: dconst_1
    //   272: invokestatic 66	java/lang/Math:min	(DD)D
    //   275: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   278: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   281: aastore
    //   282: dup
    //   283: iconst_1
    //   284: aload 10
    //   286: aastore
    //   287: dup
    //   288: iconst_2
    //   289: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   292: iconst_2
    //   293: i2d
    //   294: dload 4
    //   296: dload 6
    //   298: dmul
    //   299: dload_2
    //   300: dload 8
    //   302: dmul
    //   303: dadd
    //   304: dmul
    //   305: iconst_m1
    //   306: i2d
    //   307: invokestatic 63	java/lang/Math:max	(DD)D
    //   310: dconst_1
    //   311: invokestatic 66	java/lang/Math:min	(DD)D
    //   314: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   317: iconst_2
    //   318: i2d
    //   319: dload 6
    //   321: dload 8
    //   323: dmul
    //   324: dload_2
    //   325: dload 4
    //   327: dmul
    //   328: dsub
    //   329: dmul
    //   330: iconst_m1
    //   331: i2d
    //   332: invokestatic 63	java/lang/Math:max	(DD)D
    //   335: dconst_1
    //   336: invokestatic 66	java/lang/Math:min	(DD)D
    //   339: dneg
    //   340: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   343: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   346: aastore
    //   347: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   350: areturn
    //   351: new 31	gnu/mapping/WrongType
    //   354: dup_x1
    //   355: swap
    //   356: ldc 33
    //   358: bipush -2
    //   360: aload 4
    //   362: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   365: athrow
    //   366: new 31	gnu/mapping/WrongType
    //   369: dup_x1
    //   370: swap
    //   371: ldc 42
    //   373: bipush -2
    //   375: aload 6
    //   377: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   380: athrow
    //   381: new 31	gnu/mapping/WrongType
    //   384: dup_x1
    //   385: swap
    //   386: ldc 47
    //   388: bipush -2
    //   390: aload 8
    //   392: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   395: athrow
    //   396: new 31	gnu/mapping/WrongType
    //   399: dup_x1
    //   400: swap
    //   401: ldc 52
    //   403: bipush -2
    //   405: aload 10
    //   407: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   410: athrow
    // Line number table:
    //   Java source line #293	-> byte code offset #0
    //   Java source line #294	-> byte code offset #0
    //   Java source line #295	-> byte code offset #5
    //   Java source line #294	-> byte code offset #16
    //   Java source line #296	-> byte code offset #16
    //   Java source line #294	-> byte code offset #28
    //   Java source line #297	-> byte code offset #28
    //   Java source line #294	-> byte code offset #40
    //   Java source line #298	-> byte code offset #40
    //   Java source line #300	-> byte code offset #52
    //   Java source line #110	-> byte code offset #73
    //   Java source line #305	-> byte code offset #90
    //   Java source line #306	-> byte code offset #113
    //   Java source line #308	-> byte code offset #131
    //   Java source line #110	-> byte code offset #164
    //   Java source line #308	-> byte code offset #176
    //   Java source line #110	-> byte code offset #197
    //   Java source line #312	-> byte code offset #219
    //   Java source line #110	-> byte code offset #241
    //   Java source line #312	-> byte code offset #253
    //   Java source line #110	-> byte code offset #266
    //   Java source line #314	-> byte code offset #292
    //   Java source line #110	-> byte code offset #305
    //   Java source line #314	-> byte code offset #317
    //   Java source line #110	-> byte code offset #330
    //   Java source line #295	-> byte code offset #351
    //   Java source line #296	-> byte code offset #366
    //   Java source line #297	-> byte code offset #381
    //   Java source line #298	-> byte code offset #396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	q	Quaternion
    //   4	37	1	uq	Number
    //   15	310	2	r	double
    //   10	1	4	localNumber1	Number
    //   26	335	4	i	double
    //   21	1	6	localNumber2	Number
    //   38	338	6	j	double
    //   33	1	8	localNumber3	Number
    //   50	341	8	k	double
    //   45	1	10	localNumber4	Number
    //   88	318	10	beta	Number
    //   98	8	11	x	boolean
    //   351	1	12	localClassCastException1	ClassCastException
    //   366	1	13	localClassCastException2	ClassCastException
    //   381	1	14	localClassCastException3	ClassCastException
    //   396	1	15	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	15	351	java/lang/ClassCastException
    //   23	26	366	java/lang/ClassCastException
    //   35	38	381	java/lang/ClassCastException
    //   47	50	396	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object intrinsicYzy(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/kawa/quaternions:unitQuaternion	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 21	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   9: dup
    //   10: astore 4
    //   12: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   15: dstore_2
    //   16: aload_1
    //   17: invokestatic 40	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   20: dup
    //   21: astore 6
    //   23: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   26: dstore 4
    //   28: aload_1
    //   29: invokestatic 45	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   32: dup
    //   33: astore 8
    //   35: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   38: dstore 6
    //   40: aload_1
    //   41: invokestatic 50	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   44: dup
    //   45: astore 10
    //   47: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   50: dstore 8
    //   52: dload_2
    //   53: dload_2
    //   54: dmul
    //   55: dload 6
    //   57: dload 6
    //   59: dmul
    //   60: dadd
    //   61: dload 4
    //   63: dload 4
    //   65: dmul
    //   66: dload 8
    //   68: dload 8
    //   70: dmul
    //   71: dadd
    //   72: dsub
    //   73: iconst_m1
    //   74: i2d
    //   75: invokestatic 63	java/lang/Math:max	(DD)D
    //   78: dconst_1
    //   79: invokestatic 66	java/lang/Math:min	(DD)D
    //   82: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   85: invokestatic 249	kawa/lib/numbers:acos	(Ljava/lang/Number;)Ljava/lang/Number;
    //   88: astore 10
    //   90: aload 10
    //   92: getstatic 132	kawa/lib/kawa/rotations:Lit4	Ljava/lang/Double;
    //   95: invokestatic 252	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   98: istore 11
    //   100: iload 11
    //   102: ifeq +11 -> 113
    //   105: iload 11
    //   107: ifeq +113 -> 220
    //   110: goto +21 -> 131
    //   113: aload 10
    //   115: getstatic 256	java/lang/Math:PI	D
    //   118: ldc2_w 257
    //   121: dsub
    //   122: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   125: invokestatic 138	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   128: ifeq +92 -> 220
    //   131: iconst_3
    //   132: anewarray 72	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: getstatic 262	kawa/lib/kawa/rotations:Lit11	Lgnu/math/DFloNum;
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: aload 10
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   151: iconst_2
    //   152: i2d
    //   153: dload 4
    //   155: dload 8
    //   157: dmul
    //   158: dload_2
    //   159: dload 6
    //   161: dmul
    //   162: dsub
    //   163: dmul
    //   164: iconst_m1
    //   165: i2d
    //   166: invokestatic 63	java/lang/Math:max	(DD)D
    //   169: dconst_1
    //   170: invokestatic 66	java/lang/Math:min	(DD)D
    //   173: dneg
    //   174: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   177: dload_2
    //   178: dload_2
    //   179: dmul
    //   180: dload 8
    //   182: dload 8
    //   184: dmul
    //   185: dadd
    //   186: dload 4
    //   188: dload 4
    //   190: dmul
    //   191: dload 6
    //   193: dload 6
    //   195: dmul
    //   196: dadd
    //   197: dsub
    //   198: iconst_m1
    //   199: i2d
    //   200: invokestatic 63	java/lang/Math:max	(DD)D
    //   203: dconst_1
    //   204: invokestatic 66	java/lang/Math:min	(DD)D
    //   207: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   210: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   213: aastore
    //   214: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   217: goto +134 -> 351
    //   220: iconst_3
    //   221: anewarray 72	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   229: iconst_2
    //   230: i2d
    //   231: dload_2
    //   232: dload 4
    //   234: dmul
    //   235: dload 6
    //   237: dload 8
    //   239: dmul
    //   240: dadd
    //   241: dmul
    //   242: iconst_m1
    //   243: i2d
    //   244: invokestatic 63	java/lang/Math:max	(DD)D
    //   247: dconst_1
    //   248: invokestatic 66	java/lang/Math:min	(DD)D
    //   251: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   254: iconst_2
    //   255: i2d
    //   256: dload 4
    //   258: dload 6
    //   260: dmul
    //   261: dload_2
    //   262: dload 8
    //   264: dmul
    //   265: dsub
    //   266: dmul
    //   267: iconst_m1
    //   268: i2d
    //   269: invokestatic 63	java/lang/Math:max	(DD)D
    //   272: dconst_1
    //   273: invokestatic 66	java/lang/Math:min	(DD)D
    //   276: dneg
    //   277: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   280: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload 10
    //   288: aastore
    //   289: dup
    //   290: iconst_2
    //   291: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   294: iconst_2
    //   295: i2d
    //   296: dload 6
    //   298: dload 8
    //   300: dmul
    //   301: dload_2
    //   302: dload 4
    //   304: dmul
    //   305: dsub
    //   306: dmul
    //   307: iconst_m1
    //   308: i2d
    //   309: invokestatic 63	java/lang/Math:max	(DD)D
    //   312: dconst_1
    //   313: invokestatic 66	java/lang/Math:min	(DD)D
    //   316: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   319: iconst_2
    //   320: i2d
    //   321: dload 4
    //   323: dload 6
    //   325: dmul
    //   326: dload_2
    //   327: dload 8
    //   329: dmul
    //   330: dadd
    //   331: dmul
    //   332: iconst_m1
    //   333: i2d
    //   334: invokestatic 63	java/lang/Math:max	(DD)D
    //   337: dconst_1
    //   338: invokestatic 66	java/lang/Math:min	(DD)D
    //   341: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   344: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   347: aastore
    //   348: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   351: areturn
    //   352: new 31	gnu/mapping/WrongType
    //   355: dup_x1
    //   356: swap
    //   357: ldc 33
    //   359: bipush -2
    //   361: aload 4
    //   363: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   366: athrow
    //   367: new 31	gnu/mapping/WrongType
    //   370: dup_x1
    //   371: swap
    //   372: ldc 42
    //   374: bipush -2
    //   376: aload 6
    //   378: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   381: athrow
    //   382: new 31	gnu/mapping/WrongType
    //   385: dup_x1
    //   386: swap
    //   387: ldc 47
    //   389: bipush -2
    //   391: aload 8
    //   393: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   396: athrow
    //   397: new 31	gnu/mapping/WrongType
    //   400: dup_x1
    //   401: swap
    //   402: ldc 52
    //   404: bipush -2
    //   406: aload 10
    //   408: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   411: athrow
    // Line number table:
    //   Java source line #318	-> byte code offset #0
    //   Java source line #319	-> byte code offset #0
    //   Java source line #320	-> byte code offset #5
    //   Java source line #319	-> byte code offset #16
    //   Java source line #321	-> byte code offset #16
    //   Java source line #319	-> byte code offset #28
    //   Java source line #322	-> byte code offset #28
    //   Java source line #319	-> byte code offset #40
    //   Java source line #323	-> byte code offset #40
    //   Java source line #325	-> byte code offset #52
    //   Java source line #110	-> byte code offset #73
    //   Java source line #330	-> byte code offset #90
    //   Java source line #331	-> byte code offset #113
    //   Java source line #333	-> byte code offset #131
    //   Java source line #110	-> byte code offset #164
    //   Java source line #333	-> byte code offset #177
    //   Java source line #110	-> byte code offset #198
    //   Java source line #337	-> byte code offset #220
    //   Java source line #110	-> byte code offset #242
    //   Java source line #337	-> byte code offset #254
    //   Java source line #110	-> byte code offset #267
    //   Java source line #339	-> byte code offset #294
    //   Java source line #110	-> byte code offset #307
    //   Java source line #339	-> byte code offset #319
    //   Java source line #110	-> byte code offset #332
    //   Java source line #320	-> byte code offset #352
    //   Java source line #321	-> byte code offset #367
    //   Java source line #322	-> byte code offset #382
    //   Java source line #323	-> byte code offset #397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	q	Quaternion
    //   4	37	1	uq	Number
    //   15	312	2	r	double
    //   10	1	4	localNumber1	Number
    //   26	336	4	i	double
    //   21	1	6	localNumber2	Number
    //   38	339	6	j	double
    //   33	1	8	localNumber3	Number
    //   50	342	8	k	double
    //   45	1	10	localNumber4	Number
    //   88	319	10	beta	Number
    //   98	8	11	x	boolean
    //   352	1	12	localClassCastException1	ClassCastException
    //   367	1	13	localClassCastException2	ClassCastException
    //   382	1	14	localClassCastException3	ClassCastException
    //   397	1	15	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	15	352	java/lang/ClassCastException
    //   23	26	367	java/lang/ClassCastException
    //   35	38	382	java/lang/ClassCastException
    //   47	50	397	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object intrinsicZxz(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/kawa/quaternions:unitQuaternion	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 21	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   9: dup
    //   10: astore 4
    //   12: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   15: dstore_2
    //   16: aload_1
    //   17: invokestatic 40	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   20: dup
    //   21: astore 6
    //   23: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   26: dstore 4
    //   28: aload_1
    //   29: invokestatic 45	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   32: dup
    //   33: astore 8
    //   35: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   38: dstore 6
    //   40: aload_1
    //   41: invokestatic 50	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   44: dup
    //   45: astore 10
    //   47: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   50: dstore 8
    //   52: dload_2
    //   53: dload_2
    //   54: dmul
    //   55: dload 8
    //   57: dload 8
    //   59: dmul
    //   60: dadd
    //   61: dload 4
    //   63: dload 4
    //   65: dmul
    //   66: dload 6
    //   68: dload 6
    //   70: dmul
    //   71: dadd
    //   72: dsub
    //   73: iconst_m1
    //   74: i2d
    //   75: invokestatic 63	java/lang/Math:max	(DD)D
    //   78: dconst_1
    //   79: invokestatic 66	java/lang/Math:min	(DD)D
    //   82: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   85: invokestatic 249	kawa/lib/numbers:acos	(Ljava/lang/Number;)Ljava/lang/Number;
    //   88: astore 10
    //   90: aload 10
    //   92: getstatic 132	kawa/lib/kawa/rotations:Lit4	Ljava/lang/Double;
    //   95: invokestatic 252	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   98: istore 11
    //   100: iload 11
    //   102: ifeq +11 -> 113
    //   105: iload 11
    //   107: ifeq +113 -> 220
    //   110: goto +21 -> 131
    //   113: aload 10
    //   115: getstatic 256	java/lang/Math:PI	D
    //   118: ldc2_w 257
    //   121: dsub
    //   122: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   125: invokestatic 138	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   128: ifeq +92 -> 220
    //   131: iconst_3
    //   132: anewarray 72	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: getstatic 262	kawa/lib/kawa/rotations:Lit11	Lgnu/math/DFloNum;
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: aload 10
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   151: iconst_2
    //   152: i2d
    //   153: dload 4
    //   155: dload 6
    //   157: dmul
    //   158: dload_2
    //   159: dload 8
    //   161: dmul
    //   162: dsub
    //   163: dmul
    //   164: iconst_m1
    //   165: i2d
    //   166: invokestatic 63	java/lang/Math:max	(DD)D
    //   169: dconst_1
    //   170: invokestatic 66	java/lang/Math:min	(DD)D
    //   173: dneg
    //   174: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   177: dload_2
    //   178: dload_2
    //   179: dmul
    //   180: dload 4
    //   182: dload 4
    //   184: dmul
    //   185: dadd
    //   186: dload 6
    //   188: dload 6
    //   190: dmul
    //   191: dload 8
    //   193: dload 8
    //   195: dmul
    //   196: dadd
    //   197: dsub
    //   198: iconst_m1
    //   199: i2d
    //   200: invokestatic 63	java/lang/Math:max	(DD)D
    //   203: dconst_1
    //   204: invokestatic 66	java/lang/Math:min	(DD)D
    //   207: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   210: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   213: aastore
    //   214: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   217: goto +134 -> 351
    //   220: iconst_3
    //   221: anewarray 72	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   229: iconst_2
    //   230: i2d
    //   231: dload 4
    //   233: dload 8
    //   235: dmul
    //   236: dload_2
    //   237: dload 6
    //   239: dmul
    //   240: dadd
    //   241: dmul
    //   242: iconst_m1
    //   243: i2d
    //   244: invokestatic 63	java/lang/Math:max	(DD)D
    //   247: dconst_1
    //   248: invokestatic 66	java/lang/Math:min	(DD)D
    //   251: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   254: iconst_2
    //   255: i2d
    //   256: dload 6
    //   258: dload 8
    //   260: dmul
    //   261: dload_2
    //   262: dload 4
    //   264: dmul
    //   265: dsub
    //   266: dmul
    //   267: iconst_m1
    //   268: i2d
    //   269: invokestatic 63	java/lang/Math:max	(DD)D
    //   272: dconst_1
    //   273: invokestatic 66	java/lang/Math:min	(DD)D
    //   276: dneg
    //   277: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   280: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload 10
    //   288: aastore
    //   289: dup
    //   290: iconst_2
    //   291: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   294: iconst_2
    //   295: i2d
    //   296: dload 4
    //   298: dload 8
    //   300: dmul
    //   301: dload_2
    //   302: dload 6
    //   304: dmul
    //   305: dsub
    //   306: dmul
    //   307: iconst_m1
    //   308: i2d
    //   309: invokestatic 63	java/lang/Math:max	(DD)D
    //   312: dconst_1
    //   313: invokestatic 66	java/lang/Math:min	(DD)D
    //   316: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   319: iconst_2
    //   320: i2d
    //   321: dload_2
    //   322: dload 4
    //   324: dmul
    //   325: dload 6
    //   327: dload 8
    //   329: dmul
    //   330: dadd
    //   331: dmul
    //   332: iconst_m1
    //   333: i2d
    //   334: invokestatic 63	java/lang/Math:max	(DD)D
    //   337: dconst_1
    //   338: invokestatic 66	java/lang/Math:min	(DD)D
    //   341: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   344: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   347: aastore
    //   348: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   351: areturn
    //   352: new 31	gnu/mapping/WrongType
    //   355: dup_x1
    //   356: swap
    //   357: ldc 33
    //   359: bipush -2
    //   361: aload 4
    //   363: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   366: athrow
    //   367: new 31	gnu/mapping/WrongType
    //   370: dup_x1
    //   371: swap
    //   372: ldc 42
    //   374: bipush -2
    //   376: aload 6
    //   378: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   381: athrow
    //   382: new 31	gnu/mapping/WrongType
    //   385: dup_x1
    //   386: swap
    //   387: ldc 47
    //   389: bipush -2
    //   391: aload 8
    //   393: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   396: athrow
    //   397: new 31	gnu/mapping/WrongType
    //   400: dup_x1
    //   401: swap
    //   402: ldc 52
    //   404: bipush -2
    //   406: aload 10
    //   408: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   411: athrow
    // Line number table:
    //   Java source line #343	-> byte code offset #0
    //   Java source line #344	-> byte code offset #0
    //   Java source line #345	-> byte code offset #5
    //   Java source line #344	-> byte code offset #16
    //   Java source line #346	-> byte code offset #16
    //   Java source line #344	-> byte code offset #28
    //   Java source line #347	-> byte code offset #28
    //   Java source line #344	-> byte code offset #40
    //   Java source line #348	-> byte code offset #40
    //   Java source line #350	-> byte code offset #52
    //   Java source line #110	-> byte code offset #73
    //   Java source line #355	-> byte code offset #90
    //   Java source line #356	-> byte code offset #113
    //   Java source line #358	-> byte code offset #131
    //   Java source line #110	-> byte code offset #164
    //   Java source line #358	-> byte code offset #177
    //   Java source line #110	-> byte code offset #198
    //   Java source line #362	-> byte code offset #220
    //   Java source line #110	-> byte code offset #242
    //   Java source line #362	-> byte code offset #254
    //   Java source line #110	-> byte code offset #267
    //   Java source line #364	-> byte code offset #294
    //   Java source line #110	-> byte code offset #307
    //   Java source line #364	-> byte code offset #319
    //   Java source line #110	-> byte code offset #332
    //   Java source line #345	-> byte code offset #352
    //   Java source line #346	-> byte code offset #367
    //   Java source line #347	-> byte code offset #382
    //   Java source line #348	-> byte code offset #397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	q	Quaternion
    //   4	37	1	uq	Number
    //   15	307	2	r	double
    //   10	1	4	localNumber1	Number
    //   26	336	4	i	double
    //   21	1	6	localNumber2	Number
    //   38	339	6	j	double
    //   33	1	8	localNumber3	Number
    //   50	342	8	k	double
    //   45	1	10	localNumber4	Number
    //   88	319	10	beta	Number
    //   98	8	11	x	boolean
    //   352	1	12	localClassCastException1	ClassCastException
    //   367	1	13	localClassCastException2	ClassCastException
    //   382	1	14	localClassCastException3	ClassCastException
    //   397	1	15	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	15	352	java/lang/ClassCastException
    //   23	26	367	java/lang/ClassCastException
    //   35	38	382	java/lang/ClassCastException
    //   47	50	397	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object intrinsicZyz(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/kawa/quaternions:unitQuaternion	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 21	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   9: dup
    //   10: astore 4
    //   12: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   15: dstore_2
    //   16: aload_1
    //   17: invokestatic 40	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   20: dup
    //   21: astore 6
    //   23: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   26: dstore 4
    //   28: aload_1
    //   29: invokestatic 45	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   32: dup
    //   33: astore 8
    //   35: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   38: dstore 6
    //   40: aload_1
    //   41: invokestatic 50	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   44: dup
    //   45: astore 10
    //   47: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   50: dstore 8
    //   52: dload_2
    //   53: dload_2
    //   54: dmul
    //   55: dload 8
    //   57: dload 8
    //   59: dmul
    //   60: dadd
    //   61: dload 4
    //   63: dload 4
    //   65: dmul
    //   66: dload 6
    //   68: dload 6
    //   70: dmul
    //   71: dadd
    //   72: dsub
    //   73: iconst_m1
    //   74: i2d
    //   75: invokestatic 63	java/lang/Math:max	(DD)D
    //   78: dconst_1
    //   79: invokestatic 66	java/lang/Math:min	(DD)D
    //   82: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   85: invokestatic 249	kawa/lib/numbers:acos	(Ljava/lang/Number;)Ljava/lang/Number;
    //   88: astore 10
    //   90: aload 10
    //   92: getstatic 132	kawa/lib/kawa/rotations:Lit4	Ljava/lang/Double;
    //   95: invokestatic 252	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   98: istore 11
    //   100: iload 11
    //   102: ifeq +11 -> 113
    //   105: iload 11
    //   107: ifeq +112 -> 219
    //   110: goto +21 -> 131
    //   113: aload 10
    //   115: getstatic 256	java/lang/Math:PI	D
    //   118: ldc2_w 257
    //   121: dsub
    //   122: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   125: invokestatic 138	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   128: ifeq +91 -> 219
    //   131: iconst_3
    //   132: anewarray 72	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: getstatic 262	kawa/lib/kawa/rotations:Lit11	Lgnu/math/DFloNum;
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: aload 10
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   151: iconst_2
    //   152: i2d
    //   153: dload 4
    //   155: dload 6
    //   157: dmul
    //   158: dload_2
    //   159: dload 8
    //   161: dmul
    //   162: dadd
    //   163: dmul
    //   164: iconst_m1
    //   165: i2d
    //   166: invokestatic 63	java/lang/Math:max	(DD)D
    //   169: dconst_1
    //   170: invokestatic 66	java/lang/Math:min	(DD)D
    //   173: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   176: dload_2
    //   177: dload_2
    //   178: dmul
    //   179: dload 6
    //   181: dload 6
    //   183: dmul
    //   184: dadd
    //   185: dload 4
    //   187: dload 4
    //   189: dmul
    //   190: dload 8
    //   192: dload 8
    //   194: dmul
    //   195: dadd
    //   196: dsub
    //   197: iconst_m1
    //   198: i2d
    //   199: invokestatic 63	java/lang/Math:max	(DD)D
    //   202: dconst_1
    //   203: invokestatic 66	java/lang/Math:min	(DD)D
    //   206: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   209: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: aastore
    //   213: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   216: goto +134 -> 350
    //   219: iconst_3
    //   220: anewarray 72	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   228: iconst_2
    //   229: i2d
    //   230: dload 6
    //   232: dload 8
    //   234: dmul
    //   235: dload_2
    //   236: dload 4
    //   238: dmul
    //   239: dsub
    //   240: dmul
    //   241: iconst_m1
    //   242: i2d
    //   243: invokestatic 63	java/lang/Math:max	(DD)D
    //   246: dconst_1
    //   247: invokestatic 66	java/lang/Math:min	(DD)D
    //   250: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   253: iconst_2
    //   254: i2d
    //   255: dload 4
    //   257: dload 8
    //   259: dmul
    //   260: dload_2
    //   261: dload 6
    //   263: dmul
    //   264: dadd
    //   265: dmul
    //   266: iconst_m1
    //   267: i2d
    //   268: invokestatic 63	java/lang/Math:max	(DD)D
    //   271: dconst_1
    //   272: invokestatic 66	java/lang/Math:min	(DD)D
    //   275: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   278: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   281: aastore
    //   282: dup
    //   283: iconst_1
    //   284: aload 10
    //   286: aastore
    //   287: dup
    //   288: iconst_2
    //   289: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   292: iconst_2
    //   293: i2d
    //   294: dload_2
    //   295: dload 4
    //   297: dmul
    //   298: dload 6
    //   300: dload 8
    //   302: dmul
    //   303: dadd
    //   304: dmul
    //   305: iconst_m1
    //   306: i2d
    //   307: invokestatic 63	java/lang/Math:max	(DD)D
    //   310: dconst_1
    //   311: invokestatic 66	java/lang/Math:min	(DD)D
    //   314: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   317: iconst_2
    //   318: i2d
    //   319: dload 4
    //   321: dload 8
    //   323: dmul
    //   324: dload_2
    //   325: dload 6
    //   327: dmul
    //   328: dsub
    //   329: dmul
    //   330: iconst_m1
    //   331: i2d
    //   332: invokestatic 63	java/lang/Math:max	(DD)D
    //   335: dconst_1
    //   336: invokestatic 66	java/lang/Math:min	(DD)D
    //   339: dneg
    //   340: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   343: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   346: aastore
    //   347: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   350: areturn
    //   351: new 31	gnu/mapping/WrongType
    //   354: dup_x1
    //   355: swap
    //   356: ldc 33
    //   358: bipush -2
    //   360: aload 4
    //   362: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   365: athrow
    //   366: new 31	gnu/mapping/WrongType
    //   369: dup_x1
    //   370: swap
    //   371: ldc 42
    //   373: bipush -2
    //   375: aload 6
    //   377: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   380: athrow
    //   381: new 31	gnu/mapping/WrongType
    //   384: dup_x1
    //   385: swap
    //   386: ldc 47
    //   388: bipush -2
    //   390: aload 8
    //   392: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   395: athrow
    //   396: new 31	gnu/mapping/WrongType
    //   399: dup_x1
    //   400: swap
    //   401: ldc 52
    //   403: bipush -2
    //   405: aload 10
    //   407: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   410: athrow
    // Line number table:
    //   Java source line #368	-> byte code offset #0
    //   Java source line #369	-> byte code offset #0
    //   Java source line #370	-> byte code offset #5
    //   Java source line #369	-> byte code offset #16
    //   Java source line #371	-> byte code offset #16
    //   Java source line #369	-> byte code offset #28
    //   Java source line #372	-> byte code offset #28
    //   Java source line #369	-> byte code offset #40
    //   Java source line #373	-> byte code offset #40
    //   Java source line #375	-> byte code offset #52
    //   Java source line #110	-> byte code offset #73
    //   Java source line #380	-> byte code offset #90
    //   Java source line #381	-> byte code offset #113
    //   Java source line #383	-> byte code offset #131
    //   Java source line #110	-> byte code offset #164
    //   Java source line #383	-> byte code offset #176
    //   Java source line #110	-> byte code offset #197
    //   Java source line #387	-> byte code offset #219
    //   Java source line #110	-> byte code offset #241
    //   Java source line #387	-> byte code offset #253
    //   Java source line #110	-> byte code offset #266
    //   Java source line #389	-> byte code offset #292
    //   Java source line #110	-> byte code offset #305
    //   Java source line #389	-> byte code offset #317
    //   Java source line #110	-> byte code offset #330
    //   Java source line #370	-> byte code offset #351
    //   Java source line #371	-> byte code offset #366
    //   Java source line #372	-> byte code offset #381
    //   Java source line #373	-> byte code offset #396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	q	Quaternion
    //   4	37	1	uq	Number
    //   15	310	2	r	double
    //   10	1	4	localNumber1	Number
    //   26	335	4	i	double
    //   21	1	6	localNumber2	Number
    //   38	338	6	j	double
    //   33	1	8	localNumber3	Number
    //   50	341	8	k	double
    //   45	1	10	localNumber4	Number
    //   88	318	10	beta	Number
    //   98	8	11	x	boolean
    //   351	1	12	localClassCastException1	ClassCastException
    //   366	1	13	localClassCastException2	ClassCastException
    //   381	1	14	localClassCastException3	ClassCastException
    //   396	1	15	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	15	351	java/lang/ClassCastException
    //   23	26	366	java/lang/ClassCastException
    //   35	38	381	java/lang/ClassCastException
    //   47	50	396	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object intrinsicXyz(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/kawa/quaternions:unitQuaternion	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 21	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   9: dup
    //   10: astore 4
    //   12: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   15: dstore_2
    //   16: aload_1
    //   17: invokestatic 40	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   20: dup
    //   21: astore 6
    //   23: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   26: dstore 4
    //   28: aload_1
    //   29: invokestatic 45	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   32: dup
    //   33: astore 8
    //   35: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   38: dstore 6
    //   40: aload_1
    //   41: invokestatic 50	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   44: dup
    //   45: astore 10
    //   47: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   50: dstore 8
    //   52: iconst_2
    //   53: i2d
    //   54: dload 4
    //   56: dload 8
    //   58: dmul
    //   59: dload_2
    //   60: dload 6
    //   62: dmul
    //   63: dadd
    //   64: dmul
    //   65: iconst_m1
    //   66: i2d
    //   67: invokestatic 63	java/lang/Math:max	(DD)D
    //   70: dconst_1
    //   71: invokestatic 66	java/lang/Math:min	(DD)D
    //   74: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   77: invokestatic 269	kawa/lib/numbers:asin	(Ljava/lang/Number;)Ljava/lang/Number;
    //   80: astore 10
    //   82: aload 10
    //   84: invokestatic 272	kawa/lib/numbers:abs	(Ljava/lang/Number;)Ljava/lang/Number;
    //   87: getstatic 256	java/lang/Math:PI	D
    //   90: iconst_2
    //   91: i2d
    //   92: ddiv
    //   93: ldc2_w 257
    //   96: dsub
    //   97: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   100: invokestatic 138	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   103: ifeq +91 -> 194
    //   106: iconst_3
    //   107: anewarray 72	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: getstatic 262	kawa/lib/kawa/rotations:Lit11	Lgnu/math/DFloNum;
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: aload 10
    //   120: aastore
    //   121: dup
    //   122: iconst_2
    //   123: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   126: iconst_2
    //   127: i2d
    //   128: dload 4
    //   130: dload 6
    //   132: dmul
    //   133: dload_2
    //   134: dload 8
    //   136: dmul
    //   137: dadd
    //   138: dmul
    //   139: iconst_m1
    //   140: i2d
    //   141: invokestatic 63	java/lang/Math:max	(DD)D
    //   144: dconst_1
    //   145: invokestatic 66	java/lang/Math:min	(DD)D
    //   148: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   151: dload_2
    //   152: dload_2
    //   153: dmul
    //   154: dload 6
    //   156: dload 6
    //   158: dmul
    //   159: dadd
    //   160: dload 4
    //   162: dload 4
    //   164: dmul
    //   165: dload 8
    //   167: dload 8
    //   169: dmul
    //   170: dadd
    //   171: dsub
    //   172: iconst_m1
    //   173: i2d
    //   174: invokestatic 63	java/lang/Math:max	(DD)D
    //   177: dconst_1
    //   178: invokestatic 66	java/lang/Math:min	(DD)D
    //   181: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   184: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: aastore
    //   188: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   191: goto +151 -> 342
    //   194: iconst_3
    //   195: anewarray 72	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   203: iconst_2
    //   204: i2d
    //   205: dload 6
    //   207: dload 8
    //   209: dmul
    //   210: dload_2
    //   211: dload 4
    //   213: dmul
    //   214: dsub
    //   215: dmul
    //   216: iconst_m1
    //   217: i2d
    //   218: invokestatic 63	java/lang/Math:max	(DD)D
    //   221: dconst_1
    //   222: invokestatic 66	java/lang/Math:min	(DD)D
    //   225: dneg
    //   226: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   229: dload_2
    //   230: dload_2
    //   231: dmul
    //   232: dload 8
    //   234: dload 8
    //   236: dmul
    //   237: dadd
    //   238: dload 4
    //   240: dload 4
    //   242: dmul
    //   243: dload 6
    //   245: dload 6
    //   247: dmul
    //   248: dadd
    //   249: dsub
    //   250: iconst_m1
    //   251: i2d
    //   252: invokestatic 63	java/lang/Math:max	(DD)D
    //   255: dconst_1
    //   256: invokestatic 66	java/lang/Math:min	(DD)D
    //   259: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   262: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   265: aastore
    //   266: dup
    //   267: iconst_1
    //   268: aload 10
    //   270: aastore
    //   271: dup
    //   272: iconst_2
    //   273: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   276: iconst_2
    //   277: i2d
    //   278: dload 4
    //   280: dload 6
    //   282: dmul
    //   283: dload_2
    //   284: dload 8
    //   286: dmul
    //   287: dsub
    //   288: dmul
    //   289: iconst_m1
    //   290: i2d
    //   291: invokestatic 63	java/lang/Math:max	(DD)D
    //   294: dconst_1
    //   295: invokestatic 66	java/lang/Math:min	(DD)D
    //   298: dneg
    //   299: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   302: dload_2
    //   303: dload_2
    //   304: dmul
    //   305: dload 4
    //   307: dload 4
    //   309: dmul
    //   310: dadd
    //   311: dload 6
    //   313: dload 6
    //   315: dmul
    //   316: dload 8
    //   318: dload 8
    //   320: dmul
    //   321: dadd
    //   322: dsub
    //   323: iconst_m1
    //   324: i2d
    //   325: invokestatic 63	java/lang/Math:max	(DD)D
    //   328: dconst_1
    //   329: invokestatic 66	java/lang/Math:min	(DD)D
    //   332: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   335: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   338: aastore
    //   339: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   342: areturn
    //   343: new 31	gnu/mapping/WrongType
    //   346: dup_x1
    //   347: swap
    //   348: ldc 33
    //   350: bipush -2
    //   352: aload 4
    //   354: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   357: athrow
    //   358: new 31	gnu/mapping/WrongType
    //   361: dup_x1
    //   362: swap
    //   363: ldc 42
    //   365: bipush -2
    //   367: aload 6
    //   369: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   372: athrow
    //   373: new 31	gnu/mapping/WrongType
    //   376: dup_x1
    //   377: swap
    //   378: ldc 47
    //   380: bipush -2
    //   382: aload 8
    //   384: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   387: athrow
    //   388: new 31	gnu/mapping/WrongType
    //   391: dup_x1
    //   392: swap
    //   393: ldc 52
    //   395: bipush -2
    //   397: aload 10
    //   399: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   402: athrow
    // Line number table:
    //   Java source line #403	-> byte code offset #0
    //   Java source line #404	-> byte code offset #0
    //   Java source line #405	-> byte code offset #5
    //   Java source line #404	-> byte code offset #16
    //   Java source line #406	-> byte code offset #16
    //   Java source line #404	-> byte code offset #28
    //   Java source line #407	-> byte code offset #28
    //   Java source line #404	-> byte code offset #40
    //   Java source line #408	-> byte code offset #40
    //   Java source line #410	-> byte code offset #52
    //   Java source line #110	-> byte code offset #65
    //   Java source line #415	-> byte code offset #82
    //   Java source line #417	-> byte code offset #106
    //   Java source line #110	-> byte code offset #139
    //   Java source line #417	-> byte code offset #151
    //   Java source line #110	-> byte code offset #172
    //   Java source line #421	-> byte code offset #194
    //   Java source line #110	-> byte code offset #216
    //   Java source line #421	-> byte code offset #229
    //   Java source line #110	-> byte code offset #250
    //   Java source line #423	-> byte code offset #276
    //   Java source line #110	-> byte code offset #289
    //   Java source line #423	-> byte code offset #302
    //   Java source line #110	-> byte code offset #323
    //   Java source line #405	-> byte code offset #343
    //   Java source line #406	-> byte code offset #358
    //   Java source line #407	-> byte code offset #373
    //   Java source line #408	-> byte code offset #388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	q	Quaternion
    //   4	37	1	uq	Number
    //   15	289	2	r	double
    //   10	1	4	localNumber1	Number
    //   26	327	4	i	double
    //   21	1	6	localNumber2	Number
    //   38	330	6	j	double
    //   33	1	8	localNumber3	Number
    //   50	333	8	k	double
    //   45	1	10	localNumber4	Number
    //   80	318	10	beta	Number
    //   343	1	11	localClassCastException1	ClassCastException
    //   358	1	12	localClassCastException2	ClassCastException
    //   373	1	13	localClassCastException3	ClassCastException
    //   388	1	14	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	15	343	java/lang/ClassCastException
    //   23	26	358	java/lang/ClassCastException
    //   35	38	373	java/lang/ClassCastException
    //   47	50	388	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object intrinsicXzy(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/kawa/quaternions:unitQuaternion	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 21	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   9: dup
    //   10: astore 4
    //   12: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   15: dstore_2
    //   16: aload_1
    //   17: invokestatic 40	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   20: dup
    //   21: astore 6
    //   23: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   26: dstore 4
    //   28: aload_1
    //   29: invokestatic 45	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   32: dup
    //   33: astore 8
    //   35: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   38: dstore 6
    //   40: aload_1
    //   41: invokestatic 50	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   44: dup
    //   45: astore 10
    //   47: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   50: dstore 8
    //   52: iconst_2
    //   53: i2d
    //   54: dload 4
    //   56: dload 6
    //   58: dmul
    //   59: dload_2
    //   60: dload 8
    //   62: dmul
    //   63: dsub
    //   64: dmul
    //   65: iconst_m1
    //   66: i2d
    //   67: invokestatic 63	java/lang/Math:max	(DD)D
    //   70: dconst_1
    //   71: invokestatic 66	java/lang/Math:min	(DD)D
    //   74: dneg
    //   75: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   78: invokestatic 269	kawa/lib/numbers:asin	(Ljava/lang/Number;)Ljava/lang/Number;
    //   81: astore 10
    //   83: aload 10
    //   85: invokestatic 272	kawa/lib/numbers:abs	(Ljava/lang/Number;)Ljava/lang/Number;
    //   88: getstatic 256	java/lang/Math:PI	D
    //   91: iconst_2
    //   92: i2d
    //   93: ddiv
    //   94: ldc2_w 257
    //   97: dsub
    //   98: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   101: invokestatic 138	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   104: ifeq +92 -> 196
    //   107: iconst_3
    //   108: anewarray 72	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: getstatic 262	kawa/lib/kawa/rotations:Lit11	Lgnu/math/DFloNum;
    //   116: aastore
    //   117: dup
    //   118: iconst_1
    //   119: aload 10
    //   121: aastore
    //   122: dup
    //   123: iconst_2
    //   124: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   127: iconst_2
    //   128: i2d
    //   129: dload 4
    //   131: dload 8
    //   133: dmul
    //   134: dload_2
    //   135: dload 6
    //   137: dmul
    //   138: dsub
    //   139: dmul
    //   140: iconst_m1
    //   141: i2d
    //   142: invokestatic 63	java/lang/Math:max	(DD)D
    //   145: dconst_1
    //   146: invokestatic 66	java/lang/Math:min	(DD)D
    //   149: dneg
    //   150: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   153: dload_2
    //   154: dload_2
    //   155: dmul
    //   156: dload 8
    //   158: dload 8
    //   160: dmul
    //   161: dadd
    //   162: dload 4
    //   164: dload 4
    //   166: dmul
    //   167: dload 6
    //   169: dload 6
    //   171: dmul
    //   172: dadd
    //   173: dsub
    //   174: iconst_m1
    //   175: i2d
    //   176: invokestatic 63	java/lang/Math:max	(DD)D
    //   179: dconst_1
    //   180: invokestatic 66	java/lang/Math:min	(DD)D
    //   183: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   186: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   189: aastore
    //   190: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   193: goto +149 -> 342
    //   196: iconst_3
    //   197: anewarray 72	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   205: iconst_2
    //   206: i2d
    //   207: dload_2
    //   208: dload 4
    //   210: dmul
    //   211: dload 6
    //   213: dload 8
    //   215: dmul
    //   216: dadd
    //   217: dmul
    //   218: iconst_m1
    //   219: i2d
    //   220: invokestatic 63	java/lang/Math:max	(DD)D
    //   223: dconst_1
    //   224: invokestatic 66	java/lang/Math:min	(DD)D
    //   227: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   230: dload_2
    //   231: dload_2
    //   232: dmul
    //   233: dload 6
    //   235: dload 6
    //   237: dmul
    //   238: dadd
    //   239: dload 4
    //   241: dload 4
    //   243: dmul
    //   244: dload 8
    //   246: dload 8
    //   248: dmul
    //   249: dadd
    //   250: dsub
    //   251: iconst_m1
    //   252: i2d
    //   253: invokestatic 63	java/lang/Math:max	(DD)D
    //   256: dconst_1
    //   257: invokestatic 66	java/lang/Math:min	(DD)D
    //   260: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   263: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: aload 10
    //   271: aastore
    //   272: dup
    //   273: iconst_2
    //   274: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   277: iconst_2
    //   278: i2d
    //   279: dload 4
    //   281: dload 8
    //   283: dmul
    //   284: dload_2
    //   285: dload 6
    //   287: dmul
    //   288: dadd
    //   289: dmul
    //   290: iconst_m1
    //   291: i2d
    //   292: invokestatic 63	java/lang/Math:max	(DD)D
    //   295: dconst_1
    //   296: invokestatic 66	java/lang/Math:min	(DD)D
    //   299: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   302: dload_2
    //   303: dload_2
    //   304: dmul
    //   305: dload 4
    //   307: dload 4
    //   309: dmul
    //   310: dadd
    //   311: dload 6
    //   313: dload 6
    //   315: dmul
    //   316: dload 8
    //   318: dload 8
    //   320: dmul
    //   321: dadd
    //   322: dsub
    //   323: iconst_m1
    //   324: i2d
    //   325: invokestatic 63	java/lang/Math:max	(DD)D
    //   328: dconst_1
    //   329: invokestatic 66	java/lang/Math:min	(DD)D
    //   332: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   335: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   338: aastore
    //   339: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   342: areturn
    //   343: new 31	gnu/mapping/WrongType
    //   346: dup_x1
    //   347: swap
    //   348: ldc 33
    //   350: bipush -2
    //   352: aload 4
    //   354: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   357: athrow
    //   358: new 31	gnu/mapping/WrongType
    //   361: dup_x1
    //   362: swap
    //   363: ldc 42
    //   365: bipush -2
    //   367: aload 6
    //   369: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   372: athrow
    //   373: new 31	gnu/mapping/WrongType
    //   376: dup_x1
    //   377: swap
    //   378: ldc 47
    //   380: bipush -2
    //   382: aload 8
    //   384: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   387: athrow
    //   388: new 31	gnu/mapping/WrongType
    //   391: dup_x1
    //   392: swap
    //   393: ldc 52
    //   395: bipush -2
    //   397: aload 10
    //   399: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   402: athrow
    // Line number table:
    //   Java source line #427	-> byte code offset #0
    //   Java source line #428	-> byte code offset #0
    //   Java source line #429	-> byte code offset #5
    //   Java source line #428	-> byte code offset #16
    //   Java source line #430	-> byte code offset #16
    //   Java source line #428	-> byte code offset #28
    //   Java source line #431	-> byte code offset #28
    //   Java source line #428	-> byte code offset #40
    //   Java source line #432	-> byte code offset #40
    //   Java source line #434	-> byte code offset #52
    //   Java source line #110	-> byte code offset #65
    //   Java source line #439	-> byte code offset #83
    //   Java source line #441	-> byte code offset #107
    //   Java source line #110	-> byte code offset #140
    //   Java source line #441	-> byte code offset #153
    //   Java source line #110	-> byte code offset #174
    //   Java source line #445	-> byte code offset #196
    //   Java source line #110	-> byte code offset #218
    //   Java source line #445	-> byte code offset #230
    //   Java source line #110	-> byte code offset #251
    //   Java source line #447	-> byte code offset #277
    //   Java source line #110	-> byte code offset #290
    //   Java source line #447	-> byte code offset #302
    //   Java source line #110	-> byte code offset #323
    //   Java source line #429	-> byte code offset #343
    //   Java source line #430	-> byte code offset #358
    //   Java source line #431	-> byte code offset #373
    //   Java source line #432	-> byte code offset #388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	q	Quaternion
    //   4	37	1	uq	Number
    //   15	289	2	r	double
    //   10	1	4	localNumber1	Number
    //   26	327	4	i	double
    //   21	1	6	localNumber2	Number
    //   38	330	6	j	double
    //   33	1	8	localNumber3	Number
    //   50	333	8	k	double
    //   45	1	10	localNumber4	Number
    //   81	317	10	beta	Number
    //   343	1	11	localClassCastException1	ClassCastException
    //   358	1	12	localClassCastException2	ClassCastException
    //   373	1	13	localClassCastException3	ClassCastException
    //   388	1	14	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	15	343	java/lang/ClassCastException
    //   23	26	358	java/lang/ClassCastException
    //   35	38	373	java/lang/ClassCastException
    //   47	50	388	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object intrinsicYxz(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/kawa/quaternions:unitQuaternion	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 21	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   9: dup
    //   10: astore 4
    //   12: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   15: dstore_2
    //   16: aload_1
    //   17: invokestatic 40	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   20: dup
    //   21: astore 6
    //   23: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   26: dstore 4
    //   28: aload_1
    //   29: invokestatic 45	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   32: dup
    //   33: astore 8
    //   35: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   38: dstore 6
    //   40: aload_1
    //   41: invokestatic 50	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   44: dup
    //   45: astore 10
    //   47: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   50: dstore 8
    //   52: iconst_2
    //   53: i2d
    //   54: dload 4
    //   56: dload 6
    //   58: dmul
    //   59: dload_2
    //   60: dload 8
    //   62: dmul
    //   63: dsub
    //   64: dmul
    //   65: iconst_m1
    //   66: i2d
    //   67: invokestatic 63	java/lang/Math:max	(DD)D
    //   70: dconst_1
    //   71: invokestatic 66	java/lang/Math:min	(DD)D
    //   74: dneg
    //   75: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   78: invokestatic 269	kawa/lib/numbers:asin	(Ljava/lang/Number;)Ljava/lang/Number;
    //   81: astore 10
    //   83: aload 10
    //   85: invokestatic 272	kawa/lib/numbers:abs	(Ljava/lang/Number;)Ljava/lang/Number;
    //   88: getstatic 256	java/lang/Math:PI	D
    //   91: iconst_2
    //   92: i2d
    //   93: ddiv
    //   94: ldc2_w 257
    //   97: dsub
    //   98: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   101: invokestatic 138	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   104: ifeq +92 -> 196
    //   107: iconst_3
    //   108: anewarray 72	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: getstatic 262	kawa/lib/kawa/rotations:Lit11	Lgnu/math/DFloNum;
    //   116: aastore
    //   117: dup
    //   118: iconst_1
    //   119: aload 10
    //   121: aastore
    //   122: dup
    //   123: iconst_2
    //   124: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   127: iconst_2
    //   128: i2d
    //   129: dload 4
    //   131: dload 6
    //   133: dmul
    //   134: dload_2
    //   135: dload 8
    //   137: dmul
    //   138: dsub
    //   139: dmul
    //   140: iconst_m1
    //   141: i2d
    //   142: invokestatic 63	java/lang/Math:max	(DD)D
    //   145: dconst_1
    //   146: invokestatic 66	java/lang/Math:min	(DD)D
    //   149: dneg
    //   150: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   153: dload_2
    //   154: dload_2
    //   155: dmul
    //   156: dload 4
    //   158: dload 4
    //   160: dmul
    //   161: dadd
    //   162: dload 6
    //   164: dload 6
    //   166: dmul
    //   167: dload 8
    //   169: dload 8
    //   171: dmul
    //   172: dadd
    //   173: dsub
    //   174: iconst_m1
    //   175: i2d
    //   176: invokestatic 63	java/lang/Math:max	(DD)D
    //   179: dconst_1
    //   180: invokestatic 66	java/lang/Math:min	(DD)D
    //   183: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   186: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   189: aastore
    //   190: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   193: goto +149 -> 342
    //   196: iconst_3
    //   197: anewarray 72	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   205: iconst_2
    //   206: i2d
    //   207: dload 4
    //   209: dload 8
    //   211: dmul
    //   212: dload_2
    //   213: dload 6
    //   215: dmul
    //   216: dadd
    //   217: dmul
    //   218: iconst_m1
    //   219: i2d
    //   220: invokestatic 63	java/lang/Math:max	(DD)D
    //   223: dconst_1
    //   224: invokestatic 66	java/lang/Math:min	(DD)D
    //   227: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   230: dload_2
    //   231: dload_2
    //   232: dmul
    //   233: dload 8
    //   235: dload 8
    //   237: dmul
    //   238: dadd
    //   239: dload 4
    //   241: dload 4
    //   243: dmul
    //   244: dload 6
    //   246: dload 6
    //   248: dmul
    //   249: dadd
    //   250: dsub
    //   251: iconst_m1
    //   252: i2d
    //   253: invokestatic 63	java/lang/Math:max	(DD)D
    //   256: dconst_1
    //   257: invokestatic 66	java/lang/Math:min	(DD)D
    //   260: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   263: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: aload 10
    //   271: aastore
    //   272: dup
    //   273: iconst_2
    //   274: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   277: iconst_2
    //   278: i2d
    //   279: dload 4
    //   281: dload 6
    //   283: dmul
    //   284: dload_2
    //   285: dload 8
    //   287: dmul
    //   288: dadd
    //   289: dmul
    //   290: iconst_m1
    //   291: i2d
    //   292: invokestatic 63	java/lang/Math:max	(DD)D
    //   295: dconst_1
    //   296: invokestatic 66	java/lang/Math:min	(DD)D
    //   299: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   302: dload_2
    //   303: dload_2
    //   304: dmul
    //   305: dload 6
    //   307: dload 6
    //   309: dmul
    //   310: dadd
    //   311: dload 4
    //   313: dload 4
    //   315: dmul
    //   316: dload 8
    //   318: dload 8
    //   320: dmul
    //   321: dadd
    //   322: dsub
    //   323: iconst_m1
    //   324: i2d
    //   325: invokestatic 63	java/lang/Math:max	(DD)D
    //   328: dconst_1
    //   329: invokestatic 66	java/lang/Math:min	(DD)D
    //   332: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   335: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   338: aastore
    //   339: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   342: areturn
    //   343: new 31	gnu/mapping/WrongType
    //   346: dup_x1
    //   347: swap
    //   348: ldc 33
    //   350: bipush -2
    //   352: aload 4
    //   354: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   357: athrow
    //   358: new 31	gnu/mapping/WrongType
    //   361: dup_x1
    //   362: swap
    //   363: ldc 42
    //   365: bipush -2
    //   367: aload 6
    //   369: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   372: athrow
    //   373: new 31	gnu/mapping/WrongType
    //   376: dup_x1
    //   377: swap
    //   378: ldc 47
    //   380: bipush -2
    //   382: aload 8
    //   384: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   387: athrow
    //   388: new 31	gnu/mapping/WrongType
    //   391: dup_x1
    //   392: swap
    //   393: ldc 52
    //   395: bipush -2
    //   397: aload 10
    //   399: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   402: athrow
    // Line number table:
    //   Java source line #451	-> byte code offset #0
    //   Java source line #452	-> byte code offset #0
    //   Java source line #453	-> byte code offset #5
    //   Java source line #452	-> byte code offset #16
    //   Java source line #454	-> byte code offset #16
    //   Java source line #452	-> byte code offset #28
    //   Java source line #455	-> byte code offset #28
    //   Java source line #452	-> byte code offset #40
    //   Java source line #456	-> byte code offset #40
    //   Java source line #458	-> byte code offset #52
    //   Java source line #110	-> byte code offset #65
    //   Java source line #463	-> byte code offset #83
    //   Java source line #465	-> byte code offset #107
    //   Java source line #110	-> byte code offset #140
    //   Java source line #465	-> byte code offset #153
    //   Java source line #110	-> byte code offset #174
    //   Java source line #469	-> byte code offset #196
    //   Java source line #110	-> byte code offset #218
    //   Java source line #469	-> byte code offset #230
    //   Java source line #110	-> byte code offset #251
    //   Java source line #471	-> byte code offset #277
    //   Java source line #110	-> byte code offset #290
    //   Java source line #471	-> byte code offset #302
    //   Java source line #110	-> byte code offset #323
    //   Java source line #453	-> byte code offset #343
    //   Java source line #454	-> byte code offset #358
    //   Java source line #455	-> byte code offset #373
    //   Java source line #456	-> byte code offset #388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	q	Quaternion
    //   4	37	1	uq	Number
    //   15	289	2	r	double
    //   10	1	4	localNumber1	Number
    //   26	327	4	i	double
    //   21	1	6	localNumber2	Number
    //   38	330	6	j	double
    //   33	1	8	localNumber3	Number
    //   50	333	8	k	double
    //   45	1	10	localNumber4	Number
    //   81	317	10	beta	Number
    //   343	1	11	localClassCastException1	ClassCastException
    //   358	1	12	localClassCastException2	ClassCastException
    //   373	1	13	localClassCastException3	ClassCastException
    //   388	1	14	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	15	343	java/lang/ClassCastException
    //   23	26	358	java/lang/ClassCastException
    //   35	38	373	java/lang/ClassCastException
    //   47	50	388	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object intrinsicYzx(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/kawa/quaternions:unitQuaternion	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 21	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   9: dup
    //   10: astore 4
    //   12: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   15: dstore_2
    //   16: aload_1
    //   17: invokestatic 40	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   20: dup
    //   21: astore 6
    //   23: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   26: dstore 4
    //   28: aload_1
    //   29: invokestatic 45	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   32: dup
    //   33: astore 8
    //   35: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   38: dstore 6
    //   40: aload_1
    //   41: invokestatic 50	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   44: dup
    //   45: astore 10
    //   47: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   50: dstore 8
    //   52: iconst_2
    //   53: i2d
    //   54: dload 4
    //   56: dload 6
    //   58: dmul
    //   59: dload_2
    //   60: dload 8
    //   62: dmul
    //   63: dadd
    //   64: dmul
    //   65: iconst_m1
    //   66: i2d
    //   67: invokestatic 63	java/lang/Math:max	(DD)D
    //   70: dconst_1
    //   71: invokestatic 66	java/lang/Math:min	(DD)D
    //   74: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   77: invokestatic 269	kawa/lib/numbers:asin	(Ljava/lang/Number;)Ljava/lang/Number;
    //   80: astore 10
    //   82: aload 10
    //   84: invokestatic 272	kawa/lib/numbers:abs	(Ljava/lang/Number;)Ljava/lang/Number;
    //   87: getstatic 256	java/lang/Math:PI	D
    //   90: iconst_2
    //   91: i2d
    //   92: ddiv
    //   93: ldc2_w 257
    //   96: dsub
    //   97: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   100: invokestatic 138	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   103: ifeq +91 -> 194
    //   106: iconst_3
    //   107: anewarray 72	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: getstatic 262	kawa/lib/kawa/rotations:Lit11	Lgnu/math/DFloNum;
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: aload 10
    //   120: aastore
    //   121: dup
    //   122: iconst_2
    //   123: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   126: iconst_2
    //   127: i2d
    //   128: dload_2
    //   129: dload 4
    //   131: dmul
    //   132: dload 6
    //   134: dload 8
    //   136: dmul
    //   137: dadd
    //   138: dmul
    //   139: iconst_m1
    //   140: i2d
    //   141: invokestatic 63	java/lang/Math:max	(DD)D
    //   144: dconst_1
    //   145: invokestatic 66	java/lang/Math:min	(DD)D
    //   148: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   151: dload_2
    //   152: dload_2
    //   153: dmul
    //   154: dload 8
    //   156: dload 8
    //   158: dmul
    //   159: dadd
    //   160: dload 4
    //   162: dload 4
    //   164: dmul
    //   165: dload 6
    //   167: dload 6
    //   169: dmul
    //   170: dadd
    //   171: dsub
    //   172: iconst_m1
    //   173: i2d
    //   174: invokestatic 63	java/lang/Math:max	(DD)D
    //   177: dconst_1
    //   178: invokestatic 66	java/lang/Math:min	(DD)D
    //   181: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   184: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: aastore
    //   188: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   191: goto +151 -> 342
    //   194: iconst_3
    //   195: anewarray 72	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   203: iconst_2
    //   204: i2d
    //   205: dload 4
    //   207: dload 8
    //   209: dmul
    //   210: dload_2
    //   211: dload 6
    //   213: dmul
    //   214: dsub
    //   215: dmul
    //   216: iconst_m1
    //   217: i2d
    //   218: invokestatic 63	java/lang/Math:max	(DD)D
    //   221: dconst_1
    //   222: invokestatic 66	java/lang/Math:min	(DD)D
    //   225: dneg
    //   226: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   229: dload_2
    //   230: dload_2
    //   231: dmul
    //   232: dload 4
    //   234: dload 4
    //   236: dmul
    //   237: dadd
    //   238: dload 6
    //   240: dload 6
    //   242: dmul
    //   243: dload 8
    //   245: dload 8
    //   247: dmul
    //   248: dadd
    //   249: dsub
    //   250: iconst_m1
    //   251: i2d
    //   252: invokestatic 63	java/lang/Math:max	(DD)D
    //   255: dconst_1
    //   256: invokestatic 66	java/lang/Math:min	(DD)D
    //   259: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   262: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   265: aastore
    //   266: dup
    //   267: iconst_1
    //   268: aload 10
    //   270: aastore
    //   271: dup
    //   272: iconst_2
    //   273: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   276: iconst_2
    //   277: i2d
    //   278: dload 6
    //   280: dload 8
    //   282: dmul
    //   283: dload_2
    //   284: dload 4
    //   286: dmul
    //   287: dsub
    //   288: dmul
    //   289: iconst_m1
    //   290: i2d
    //   291: invokestatic 63	java/lang/Math:max	(DD)D
    //   294: dconst_1
    //   295: invokestatic 66	java/lang/Math:min	(DD)D
    //   298: dneg
    //   299: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   302: dload_2
    //   303: dload_2
    //   304: dmul
    //   305: dload 6
    //   307: dload 6
    //   309: dmul
    //   310: dadd
    //   311: dload 4
    //   313: dload 4
    //   315: dmul
    //   316: dload 8
    //   318: dload 8
    //   320: dmul
    //   321: dadd
    //   322: dsub
    //   323: iconst_m1
    //   324: i2d
    //   325: invokestatic 63	java/lang/Math:max	(DD)D
    //   328: dconst_1
    //   329: invokestatic 66	java/lang/Math:min	(DD)D
    //   332: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   335: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   338: aastore
    //   339: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   342: areturn
    //   343: new 31	gnu/mapping/WrongType
    //   346: dup_x1
    //   347: swap
    //   348: ldc 33
    //   350: bipush -2
    //   352: aload 4
    //   354: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   357: athrow
    //   358: new 31	gnu/mapping/WrongType
    //   361: dup_x1
    //   362: swap
    //   363: ldc 42
    //   365: bipush -2
    //   367: aload 6
    //   369: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   372: athrow
    //   373: new 31	gnu/mapping/WrongType
    //   376: dup_x1
    //   377: swap
    //   378: ldc 47
    //   380: bipush -2
    //   382: aload 8
    //   384: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   387: athrow
    //   388: new 31	gnu/mapping/WrongType
    //   391: dup_x1
    //   392: swap
    //   393: ldc 52
    //   395: bipush -2
    //   397: aload 10
    //   399: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   402: athrow
    // Line number table:
    //   Java source line #475	-> byte code offset #0
    //   Java source line #476	-> byte code offset #0
    //   Java source line #477	-> byte code offset #5
    //   Java source line #476	-> byte code offset #16
    //   Java source line #478	-> byte code offset #16
    //   Java source line #476	-> byte code offset #28
    //   Java source line #479	-> byte code offset #28
    //   Java source line #476	-> byte code offset #40
    //   Java source line #480	-> byte code offset #40
    //   Java source line #482	-> byte code offset #52
    //   Java source line #110	-> byte code offset #65
    //   Java source line #487	-> byte code offset #82
    //   Java source line #489	-> byte code offset #106
    //   Java source line #110	-> byte code offset #139
    //   Java source line #489	-> byte code offset #151
    //   Java source line #110	-> byte code offset #172
    //   Java source line #493	-> byte code offset #194
    //   Java source line #110	-> byte code offset #216
    //   Java source line #493	-> byte code offset #229
    //   Java source line #110	-> byte code offset #250
    //   Java source line #495	-> byte code offset #276
    //   Java source line #110	-> byte code offset #289
    //   Java source line #495	-> byte code offset #302
    //   Java source line #110	-> byte code offset #323
    //   Java source line #477	-> byte code offset #343
    //   Java source line #478	-> byte code offset #358
    //   Java source line #479	-> byte code offset #373
    //   Java source line #480	-> byte code offset #388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	q	Quaternion
    //   4	37	1	uq	Number
    //   15	289	2	r	double
    //   10	1	4	localNumber1	Number
    //   26	327	4	i	double
    //   21	1	6	localNumber2	Number
    //   38	330	6	j	double
    //   33	1	8	localNumber3	Number
    //   50	333	8	k	double
    //   45	1	10	localNumber4	Number
    //   80	318	10	beta	Number
    //   343	1	11	localClassCastException1	ClassCastException
    //   358	1	12	localClassCastException2	ClassCastException
    //   373	1	13	localClassCastException3	ClassCastException
    //   388	1	14	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	15	343	java/lang/ClassCastException
    //   23	26	358	java/lang/ClassCastException
    //   35	38	373	java/lang/ClassCastException
    //   47	50	388	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object intrinsicZxy(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/kawa/quaternions:unitQuaternion	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 21	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   9: dup
    //   10: astore 4
    //   12: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   15: dstore_2
    //   16: aload_1
    //   17: invokestatic 40	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   20: dup
    //   21: astore 6
    //   23: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   26: dstore 4
    //   28: aload_1
    //   29: invokestatic 45	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   32: dup
    //   33: astore 8
    //   35: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   38: dstore 6
    //   40: aload_1
    //   41: invokestatic 50	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   44: dup
    //   45: astore 10
    //   47: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   50: dstore 8
    //   52: iconst_2
    //   53: i2d
    //   54: dload_2
    //   55: dload 4
    //   57: dmul
    //   58: dload 6
    //   60: dload 8
    //   62: dmul
    //   63: dadd
    //   64: dmul
    //   65: iconst_m1
    //   66: i2d
    //   67: invokestatic 63	java/lang/Math:max	(DD)D
    //   70: dconst_1
    //   71: invokestatic 66	java/lang/Math:min	(DD)D
    //   74: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   77: invokestatic 269	kawa/lib/numbers:asin	(Ljava/lang/Number;)Ljava/lang/Number;
    //   80: astore 10
    //   82: aload 10
    //   84: invokestatic 272	kawa/lib/numbers:abs	(Ljava/lang/Number;)Ljava/lang/Number;
    //   87: getstatic 256	java/lang/Math:PI	D
    //   90: iconst_2
    //   91: i2d
    //   92: ddiv
    //   93: ldc2_w 257
    //   96: dsub
    //   97: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   100: invokestatic 138	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   103: ifeq +91 -> 194
    //   106: iconst_3
    //   107: anewarray 72	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: getstatic 262	kawa/lib/kawa/rotations:Lit11	Lgnu/math/DFloNum;
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: aload 10
    //   120: aastore
    //   121: dup
    //   122: iconst_2
    //   123: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   126: iconst_2
    //   127: i2d
    //   128: dload 4
    //   130: dload 8
    //   132: dmul
    //   133: dload_2
    //   134: dload 6
    //   136: dmul
    //   137: dadd
    //   138: dmul
    //   139: iconst_m1
    //   140: i2d
    //   141: invokestatic 63	java/lang/Math:max	(DD)D
    //   144: dconst_1
    //   145: invokestatic 66	java/lang/Math:min	(DD)D
    //   148: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   151: dload_2
    //   152: dload_2
    //   153: dmul
    //   154: dload 4
    //   156: dload 4
    //   158: dmul
    //   159: dadd
    //   160: dload 6
    //   162: dload 6
    //   164: dmul
    //   165: dload 8
    //   167: dload 8
    //   169: dmul
    //   170: dadd
    //   171: dsub
    //   172: iconst_m1
    //   173: i2d
    //   174: invokestatic 63	java/lang/Math:max	(DD)D
    //   177: dconst_1
    //   178: invokestatic 66	java/lang/Math:min	(DD)D
    //   181: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   184: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: aastore
    //   188: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   191: goto +151 -> 342
    //   194: iconst_3
    //   195: anewarray 72	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   203: iconst_2
    //   204: i2d
    //   205: dload 4
    //   207: dload 6
    //   209: dmul
    //   210: dload_2
    //   211: dload 8
    //   213: dmul
    //   214: dsub
    //   215: dmul
    //   216: iconst_m1
    //   217: i2d
    //   218: invokestatic 63	java/lang/Math:max	(DD)D
    //   221: dconst_1
    //   222: invokestatic 66	java/lang/Math:min	(DD)D
    //   225: dneg
    //   226: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   229: dload_2
    //   230: dload_2
    //   231: dmul
    //   232: dload 6
    //   234: dload 6
    //   236: dmul
    //   237: dadd
    //   238: dload 4
    //   240: dload 4
    //   242: dmul
    //   243: dload 8
    //   245: dload 8
    //   247: dmul
    //   248: dadd
    //   249: dsub
    //   250: iconst_m1
    //   251: i2d
    //   252: invokestatic 63	java/lang/Math:max	(DD)D
    //   255: dconst_1
    //   256: invokestatic 66	java/lang/Math:min	(DD)D
    //   259: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   262: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   265: aastore
    //   266: dup
    //   267: iconst_1
    //   268: aload 10
    //   270: aastore
    //   271: dup
    //   272: iconst_2
    //   273: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   276: iconst_2
    //   277: i2d
    //   278: dload 4
    //   280: dload 8
    //   282: dmul
    //   283: dload_2
    //   284: dload 6
    //   286: dmul
    //   287: dsub
    //   288: dmul
    //   289: iconst_m1
    //   290: i2d
    //   291: invokestatic 63	java/lang/Math:max	(DD)D
    //   294: dconst_1
    //   295: invokestatic 66	java/lang/Math:min	(DD)D
    //   298: dneg
    //   299: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   302: dload_2
    //   303: dload_2
    //   304: dmul
    //   305: dload 8
    //   307: dload 8
    //   309: dmul
    //   310: dadd
    //   311: dload 4
    //   313: dload 4
    //   315: dmul
    //   316: dload 6
    //   318: dload 6
    //   320: dmul
    //   321: dadd
    //   322: dsub
    //   323: iconst_m1
    //   324: i2d
    //   325: invokestatic 63	java/lang/Math:max	(DD)D
    //   328: dconst_1
    //   329: invokestatic 66	java/lang/Math:min	(DD)D
    //   332: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   335: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   338: aastore
    //   339: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   342: areturn
    //   343: new 31	gnu/mapping/WrongType
    //   346: dup_x1
    //   347: swap
    //   348: ldc 33
    //   350: bipush -2
    //   352: aload 4
    //   354: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   357: athrow
    //   358: new 31	gnu/mapping/WrongType
    //   361: dup_x1
    //   362: swap
    //   363: ldc 42
    //   365: bipush -2
    //   367: aload 6
    //   369: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   372: athrow
    //   373: new 31	gnu/mapping/WrongType
    //   376: dup_x1
    //   377: swap
    //   378: ldc 47
    //   380: bipush -2
    //   382: aload 8
    //   384: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   387: athrow
    //   388: new 31	gnu/mapping/WrongType
    //   391: dup_x1
    //   392: swap
    //   393: ldc 52
    //   395: bipush -2
    //   397: aload 10
    //   399: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   402: athrow
    // Line number table:
    //   Java source line #499	-> byte code offset #0
    //   Java source line #500	-> byte code offset #0
    //   Java source line #501	-> byte code offset #5
    //   Java source line #500	-> byte code offset #16
    //   Java source line #502	-> byte code offset #16
    //   Java source line #500	-> byte code offset #28
    //   Java source line #503	-> byte code offset #28
    //   Java source line #500	-> byte code offset #40
    //   Java source line #504	-> byte code offset #40
    //   Java source line #506	-> byte code offset #52
    //   Java source line #110	-> byte code offset #65
    //   Java source line #511	-> byte code offset #82
    //   Java source line #513	-> byte code offset #106
    //   Java source line #110	-> byte code offset #139
    //   Java source line #513	-> byte code offset #151
    //   Java source line #110	-> byte code offset #172
    //   Java source line #517	-> byte code offset #194
    //   Java source line #110	-> byte code offset #216
    //   Java source line #517	-> byte code offset #229
    //   Java source line #110	-> byte code offset #250
    //   Java source line #519	-> byte code offset #276
    //   Java source line #110	-> byte code offset #289
    //   Java source line #519	-> byte code offset #302
    //   Java source line #110	-> byte code offset #323
    //   Java source line #501	-> byte code offset #343
    //   Java source line #502	-> byte code offset #358
    //   Java source line #503	-> byte code offset #373
    //   Java source line #504	-> byte code offset #388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	q	Quaternion
    //   4	37	1	uq	Number
    //   15	289	2	r	double
    //   10	1	4	localNumber1	Number
    //   26	327	4	i	double
    //   21	1	6	localNumber2	Number
    //   38	330	6	j	double
    //   33	1	8	localNumber3	Number
    //   50	333	8	k	double
    //   45	1	10	localNumber4	Number
    //   80	318	10	beta	Number
    //   343	1	11	localClassCastException1	ClassCastException
    //   358	1	12	localClassCastException2	ClassCastException
    //   373	1	13	localClassCastException3	ClassCastException
    //   388	1	14	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	15	343	java/lang/ClassCastException
    //   23	26	358	java/lang/ClassCastException
    //   35	38	373	java/lang/ClassCastException
    //   47	50	388	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object intrinsicZyx(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/kawa/quaternions:unitQuaternion	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 21	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   9: dup
    //   10: astore 4
    //   12: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   15: dstore_2
    //   16: aload_1
    //   17: invokestatic 40	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   20: dup
    //   21: astore 6
    //   23: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   26: dstore 4
    //   28: aload_1
    //   29: invokestatic 45	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   32: dup
    //   33: astore 8
    //   35: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   38: dstore 6
    //   40: aload_1
    //   41: invokestatic 50	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   44: dup
    //   45: astore 10
    //   47: invokevirtual 27	java/lang/Number:doubleValue	()D
    //   50: dstore 8
    //   52: iconst_2
    //   53: i2d
    //   54: dload 4
    //   56: dload 8
    //   58: dmul
    //   59: dload_2
    //   60: dload 6
    //   62: dmul
    //   63: dsub
    //   64: dmul
    //   65: iconst_m1
    //   66: i2d
    //   67: invokestatic 63	java/lang/Math:max	(DD)D
    //   70: dconst_1
    //   71: invokestatic 66	java/lang/Math:min	(DD)D
    //   74: dneg
    //   75: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   78: invokestatic 269	kawa/lib/numbers:asin	(Ljava/lang/Number;)Ljava/lang/Number;
    //   81: astore 10
    //   83: aload 10
    //   85: invokestatic 272	kawa/lib/numbers:abs	(Ljava/lang/Number;)Ljava/lang/Number;
    //   88: getstatic 256	java/lang/Math:PI	D
    //   91: iconst_2
    //   92: i2d
    //   93: ddiv
    //   94: ldc2_w 257
    //   97: dsub
    //   98: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   101: invokestatic 138	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   104: ifeq +92 -> 196
    //   107: iconst_3
    //   108: anewarray 72	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: getstatic 262	kawa/lib/kawa/rotations:Lit11	Lgnu/math/DFloNum;
    //   116: aastore
    //   117: dup
    //   118: iconst_1
    //   119: aload 10
    //   121: aastore
    //   122: dup
    //   123: iconst_2
    //   124: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   127: iconst_2
    //   128: i2d
    //   129: dload 6
    //   131: dload 8
    //   133: dmul
    //   134: dload_2
    //   135: dload 4
    //   137: dmul
    //   138: dsub
    //   139: dmul
    //   140: iconst_m1
    //   141: i2d
    //   142: invokestatic 63	java/lang/Math:max	(DD)D
    //   145: dconst_1
    //   146: invokestatic 66	java/lang/Math:min	(DD)D
    //   149: dneg
    //   150: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   153: dload_2
    //   154: dload_2
    //   155: dmul
    //   156: dload 6
    //   158: dload 6
    //   160: dmul
    //   161: dadd
    //   162: dload 4
    //   164: dload 4
    //   166: dmul
    //   167: dload 8
    //   169: dload 8
    //   171: dmul
    //   172: dadd
    //   173: dsub
    //   174: iconst_m1
    //   175: i2d
    //   176: invokestatic 63	java/lang/Math:max	(DD)D
    //   179: dconst_1
    //   180: invokestatic 66	java/lang/Math:min	(DD)D
    //   183: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   186: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   189: aastore
    //   190: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   193: goto +149 -> 342
    //   196: iconst_3
    //   197: anewarray 72	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   205: iconst_2
    //   206: i2d
    //   207: dload 4
    //   209: dload 6
    //   211: dmul
    //   212: dload_2
    //   213: dload 8
    //   215: dmul
    //   216: dadd
    //   217: dmul
    //   218: iconst_m1
    //   219: i2d
    //   220: invokestatic 63	java/lang/Math:max	(DD)D
    //   223: dconst_1
    //   224: invokestatic 66	java/lang/Math:min	(DD)D
    //   227: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   230: dload_2
    //   231: dload_2
    //   232: dmul
    //   233: dload 4
    //   235: dload 4
    //   237: dmul
    //   238: dadd
    //   239: dload 6
    //   241: dload 6
    //   243: dmul
    //   244: dload 8
    //   246: dload 8
    //   248: dmul
    //   249: dadd
    //   250: dsub
    //   251: iconst_m1
    //   252: i2d
    //   253: invokestatic 63	java/lang/Math:max	(DD)D
    //   256: dconst_1
    //   257: invokestatic 66	java/lang/Math:min	(DD)D
    //   260: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   263: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: aload 10
    //   271: aastore
    //   272: dup
    //   273: iconst_2
    //   274: getstatic 202	kawa/lib/numbers:atan	Lgnu/expr/GenericProc;
    //   277: iconst_2
    //   278: i2d
    //   279: dload_2
    //   280: dload 4
    //   282: dmul
    //   283: dload 6
    //   285: dload 8
    //   287: dmul
    //   288: dadd
    //   289: dmul
    //   290: iconst_m1
    //   291: i2d
    //   292: invokestatic 63	java/lang/Math:max	(DD)D
    //   295: dconst_1
    //   296: invokestatic 66	java/lang/Math:min	(DD)D
    //   299: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   302: dload_2
    //   303: dload_2
    //   304: dmul
    //   305: dload 8
    //   307: dload 8
    //   309: dmul
    //   310: dadd
    //   311: dload 4
    //   313: dload 4
    //   315: dmul
    //   316: dload 6
    //   318: dload 6
    //   320: dmul
    //   321: dadd
    //   322: dsub
    //   323: iconst_m1
    //   324: i2d
    //   325: invokestatic 63	java/lang/Math:max	(DD)D
    //   328: dconst_1
    //   329: invokestatic 66	java/lang/Math:min	(DD)D
    //   332: invokestatic 246	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   335: invokevirtual 99	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   338: aastore
    //   339: invokestatic 266	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   342: areturn
    //   343: new 31	gnu/mapping/WrongType
    //   346: dup_x1
    //   347: swap
    //   348: ldc 33
    //   350: bipush -2
    //   352: aload 4
    //   354: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   357: athrow
    //   358: new 31	gnu/mapping/WrongType
    //   361: dup_x1
    //   362: swap
    //   363: ldc 42
    //   365: bipush -2
    //   367: aload 6
    //   369: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   372: athrow
    //   373: new 31	gnu/mapping/WrongType
    //   376: dup_x1
    //   377: swap
    //   378: ldc 47
    //   380: bipush -2
    //   382: aload 8
    //   384: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   387: athrow
    //   388: new 31	gnu/mapping/WrongType
    //   391: dup_x1
    //   392: swap
    //   393: ldc 52
    //   395: bipush -2
    //   397: aload 10
    //   399: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   402: athrow
    // Line number table:
    //   Java source line #523	-> byte code offset #0
    //   Java source line #524	-> byte code offset #0
    //   Java source line #525	-> byte code offset #5
    //   Java source line #524	-> byte code offset #16
    //   Java source line #526	-> byte code offset #16
    //   Java source line #524	-> byte code offset #28
    //   Java source line #527	-> byte code offset #28
    //   Java source line #524	-> byte code offset #40
    //   Java source line #528	-> byte code offset #40
    //   Java source line #530	-> byte code offset #52
    //   Java source line #110	-> byte code offset #65
    //   Java source line #535	-> byte code offset #83
    //   Java source line #537	-> byte code offset #107
    //   Java source line #110	-> byte code offset #140
    //   Java source line #537	-> byte code offset #153
    //   Java source line #110	-> byte code offset #174
    //   Java source line #541	-> byte code offset #196
    //   Java source line #110	-> byte code offset #218
    //   Java source line #541	-> byte code offset #230
    //   Java source line #110	-> byte code offset #251
    //   Java source line #543	-> byte code offset #277
    //   Java source line #110	-> byte code offset #290
    //   Java source line #543	-> byte code offset #302
    //   Java source line #110	-> byte code offset #323
    //   Java source line #525	-> byte code offset #343
    //   Java source line #526	-> byte code offset #358
    //   Java source line #527	-> byte code offset #373
    //   Java source line #528	-> byte code offset #388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	q	Quaternion
    //   4	37	1	uq	Number
    //   15	289	2	r	double
    //   10	1	4	localNumber1	Number
    //   26	327	4	i	double
    //   21	1	6	localNumber2	Number
    //   38	330	6	j	double
    //   33	1	8	localNumber3	Number
    //   50	333	8	k	double
    //   45	1	10	localNumber4	Number
    //   81	317	10	beta	Number
    //   343	1	11	localClassCastException1	ClassCastException
    //   358	1	12	localClassCastException2	ClassCastException
    //   373	1	13	localClassCastException3	ClassCastException
    //   388	1	14	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   12	15	343	java/lang/ClassCastException
    //   23	26	358	java/lang/ClassCastException
    //   35	38	373	java/lang/ClassCastException
    //   47	50	388	java/lang/ClassCastException
  }
  
  public rotations()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(gnu.expr.ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 935	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+1351->1355, 3:+1318->1322, 4:+1284->1288, 5:+1251->1255, 6:+1218->1222, 7:+1185->1189, 8:+1351->1355, 9:+1351->1355, 10:+1149->1153, 11:+1113->1117, 12:+1077->1081, 13:+1044->1048, 14:+1011->1015, 15:+978->982, 16:+945->949, 17:+912->916, 18:+879->883, 19:+846->850, 20:+813->817, 21:+780->784, 22:+747->751, 23:+714->718, 24:+681->685, 25:+1351->1355, 26:+1351->1355, 27:+1351->1355, 28:+1351->1355, 29:+1351->1355, 30:+1351->1355, 31:+1351->1355, 32:+1351->1355, 33:+1351->1355, 34:+1351->1355, 35:+1351->1355, 36:+1351->1355, 37:+648->652, 38:+615->619, 39:+582->586, 40:+549->553, 41:+516->520, 42:+483->487, 43:+450->454, 44:+417->421, 45:+384->388, 46:+351->355, 47:+318->322, 48:+285->289, 49:+1351->1355, 50:+1351->1355, 51:+1351->1355, 52:+1351->1355, 53:+1351->1355, 54:+1351->1355, 55:+1351->1355, 56:+1351->1355, 57:+1351->1355, 58:+1351->1355, 59:+1351->1355, 60:+1351->1355, 61:+252->256
    //   256: aload_3
    //   257: aload_2
    //   258: ldc -85
    //   260: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   263: dup
    //   264: instanceof 171
    //   267: ifne +7 -> 274
    //   270: ldc_w 936
    //   273: ireturn
    //   274: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   277: aload_3
    //   278: aload_1
    //   279: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   282: aload_3
    //   283: iconst_1
    //   284: putfield 947	gnu/mapping/CallContext:pc	I
    //   287: iconst_0
    //   288: ireturn
    //   289: aload_3
    //   290: aload_2
    //   291: ldc -85
    //   293: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   296: dup
    //   297: instanceof 171
    //   300: ifne +7 -> 307
    //   303: ldc_w 936
    //   306: ireturn
    //   307: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   310: aload_3
    //   311: aload_1
    //   312: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   315: aload_3
    //   316: iconst_1
    //   317: putfield 947	gnu/mapping/CallContext:pc	I
    //   320: iconst_0
    //   321: ireturn
    //   322: aload_3
    //   323: aload_2
    //   324: ldc -85
    //   326: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   329: dup
    //   330: instanceof 171
    //   333: ifne +7 -> 340
    //   336: ldc_w 936
    //   339: ireturn
    //   340: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   343: aload_3
    //   344: aload_1
    //   345: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   348: aload_3
    //   349: iconst_1
    //   350: putfield 947	gnu/mapping/CallContext:pc	I
    //   353: iconst_0
    //   354: ireturn
    //   355: aload_3
    //   356: aload_2
    //   357: ldc -85
    //   359: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   362: dup
    //   363: instanceof 171
    //   366: ifne +7 -> 373
    //   369: ldc_w 936
    //   372: ireturn
    //   373: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   376: aload_3
    //   377: aload_1
    //   378: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   381: aload_3
    //   382: iconst_1
    //   383: putfield 947	gnu/mapping/CallContext:pc	I
    //   386: iconst_0
    //   387: ireturn
    //   388: aload_3
    //   389: aload_2
    //   390: ldc -85
    //   392: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   395: dup
    //   396: instanceof 171
    //   399: ifne +7 -> 406
    //   402: ldc_w 936
    //   405: ireturn
    //   406: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   409: aload_3
    //   410: aload_1
    //   411: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   414: aload_3
    //   415: iconst_1
    //   416: putfield 947	gnu/mapping/CallContext:pc	I
    //   419: iconst_0
    //   420: ireturn
    //   421: aload_3
    //   422: aload_2
    //   423: ldc -85
    //   425: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   428: dup
    //   429: instanceof 171
    //   432: ifne +7 -> 439
    //   435: ldc_w 936
    //   438: ireturn
    //   439: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   442: aload_3
    //   443: aload_1
    //   444: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   447: aload_3
    //   448: iconst_1
    //   449: putfield 947	gnu/mapping/CallContext:pc	I
    //   452: iconst_0
    //   453: ireturn
    //   454: aload_3
    //   455: aload_2
    //   456: ldc -85
    //   458: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   461: dup
    //   462: instanceof 171
    //   465: ifne +7 -> 472
    //   468: ldc_w 936
    //   471: ireturn
    //   472: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   475: aload_3
    //   476: aload_1
    //   477: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   480: aload_3
    //   481: iconst_1
    //   482: putfield 947	gnu/mapping/CallContext:pc	I
    //   485: iconst_0
    //   486: ireturn
    //   487: aload_3
    //   488: aload_2
    //   489: ldc -85
    //   491: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   494: dup
    //   495: instanceof 171
    //   498: ifne +7 -> 505
    //   501: ldc_w 936
    //   504: ireturn
    //   505: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   508: aload_3
    //   509: aload_1
    //   510: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   513: aload_3
    //   514: iconst_1
    //   515: putfield 947	gnu/mapping/CallContext:pc	I
    //   518: iconst_0
    //   519: ireturn
    //   520: aload_3
    //   521: aload_2
    //   522: ldc -85
    //   524: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   527: dup
    //   528: instanceof 171
    //   531: ifne +7 -> 538
    //   534: ldc_w 936
    //   537: ireturn
    //   538: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   541: aload_3
    //   542: aload_1
    //   543: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   546: aload_3
    //   547: iconst_1
    //   548: putfield 947	gnu/mapping/CallContext:pc	I
    //   551: iconst_0
    //   552: ireturn
    //   553: aload_3
    //   554: aload_2
    //   555: ldc -85
    //   557: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   560: dup
    //   561: instanceof 171
    //   564: ifne +7 -> 571
    //   567: ldc_w 936
    //   570: ireturn
    //   571: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   574: aload_3
    //   575: aload_1
    //   576: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   579: aload_3
    //   580: iconst_1
    //   581: putfield 947	gnu/mapping/CallContext:pc	I
    //   584: iconst_0
    //   585: ireturn
    //   586: aload_3
    //   587: aload_2
    //   588: ldc -85
    //   590: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   593: dup
    //   594: instanceof 171
    //   597: ifne +7 -> 604
    //   600: ldc_w 936
    //   603: ireturn
    //   604: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   607: aload_3
    //   608: aload_1
    //   609: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   612: aload_3
    //   613: iconst_1
    //   614: putfield 947	gnu/mapping/CallContext:pc	I
    //   617: iconst_0
    //   618: ireturn
    //   619: aload_3
    //   620: aload_2
    //   621: ldc -85
    //   623: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   626: dup
    //   627: instanceof 171
    //   630: ifne +7 -> 637
    //   633: ldc_w 936
    //   636: ireturn
    //   637: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   640: aload_3
    //   641: aload_1
    //   642: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   645: aload_3
    //   646: iconst_1
    //   647: putfield 947	gnu/mapping/CallContext:pc	I
    //   650: iconst_0
    //   651: ireturn
    //   652: aload_3
    //   653: aload_2
    //   654: ldc -85
    //   656: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   659: dup
    //   660: instanceof 171
    //   663: ifne +7 -> 670
    //   666: ldc_w 936
    //   669: ireturn
    //   670: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   673: aload_3
    //   674: aload_1
    //   675: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   678: aload_3
    //   679: iconst_1
    //   680: putfield 947	gnu/mapping/CallContext:pc	I
    //   683: iconst_0
    //   684: ireturn
    //   685: aload_3
    //   686: aload_2
    //   687: ldc -85
    //   689: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   692: dup
    //   693: instanceof 171
    //   696: ifne +7 -> 703
    //   699: ldc_w 936
    //   702: ireturn
    //   703: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   706: aload_3
    //   707: aload_1
    //   708: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   711: aload_3
    //   712: iconst_1
    //   713: putfield 947	gnu/mapping/CallContext:pc	I
    //   716: iconst_0
    //   717: ireturn
    //   718: aload_3
    //   719: aload_2
    //   720: ldc -85
    //   722: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   725: dup
    //   726: instanceof 171
    //   729: ifne +7 -> 736
    //   732: ldc_w 936
    //   735: ireturn
    //   736: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   739: aload_3
    //   740: aload_1
    //   741: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   744: aload_3
    //   745: iconst_1
    //   746: putfield 947	gnu/mapping/CallContext:pc	I
    //   749: iconst_0
    //   750: ireturn
    //   751: aload_3
    //   752: aload_2
    //   753: ldc -85
    //   755: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   758: dup
    //   759: instanceof 171
    //   762: ifne +7 -> 769
    //   765: ldc_w 936
    //   768: ireturn
    //   769: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   772: aload_3
    //   773: aload_1
    //   774: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   777: aload_3
    //   778: iconst_1
    //   779: putfield 947	gnu/mapping/CallContext:pc	I
    //   782: iconst_0
    //   783: ireturn
    //   784: aload_3
    //   785: aload_2
    //   786: ldc -85
    //   788: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   791: dup
    //   792: instanceof 171
    //   795: ifne +7 -> 802
    //   798: ldc_w 936
    //   801: ireturn
    //   802: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   805: aload_3
    //   806: aload_1
    //   807: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   810: aload_3
    //   811: iconst_1
    //   812: putfield 947	gnu/mapping/CallContext:pc	I
    //   815: iconst_0
    //   816: ireturn
    //   817: aload_3
    //   818: aload_2
    //   819: ldc -85
    //   821: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   824: dup
    //   825: instanceof 171
    //   828: ifne +7 -> 835
    //   831: ldc_w 936
    //   834: ireturn
    //   835: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   838: aload_3
    //   839: aload_1
    //   840: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   843: aload_3
    //   844: iconst_1
    //   845: putfield 947	gnu/mapping/CallContext:pc	I
    //   848: iconst_0
    //   849: ireturn
    //   850: aload_3
    //   851: aload_2
    //   852: ldc -85
    //   854: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   857: dup
    //   858: instanceof 171
    //   861: ifne +7 -> 868
    //   864: ldc_w 936
    //   867: ireturn
    //   868: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   871: aload_3
    //   872: aload_1
    //   873: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   876: aload_3
    //   877: iconst_1
    //   878: putfield 947	gnu/mapping/CallContext:pc	I
    //   881: iconst_0
    //   882: ireturn
    //   883: aload_3
    //   884: aload_2
    //   885: ldc -85
    //   887: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   890: dup
    //   891: instanceof 171
    //   894: ifne +7 -> 901
    //   897: ldc_w 936
    //   900: ireturn
    //   901: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   904: aload_3
    //   905: aload_1
    //   906: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   909: aload_3
    //   910: iconst_1
    //   911: putfield 947	gnu/mapping/CallContext:pc	I
    //   914: iconst_0
    //   915: ireturn
    //   916: aload_3
    //   917: aload_2
    //   918: ldc -85
    //   920: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   923: dup
    //   924: instanceof 171
    //   927: ifne +7 -> 934
    //   930: ldc_w 936
    //   933: ireturn
    //   934: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   937: aload_3
    //   938: aload_1
    //   939: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   942: aload_3
    //   943: iconst_1
    //   944: putfield 947	gnu/mapping/CallContext:pc	I
    //   947: iconst_0
    //   948: ireturn
    //   949: aload_3
    //   950: aload_2
    //   951: ldc -85
    //   953: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   956: dup
    //   957: instanceof 171
    //   960: ifne +7 -> 967
    //   963: ldc_w 936
    //   966: ireturn
    //   967: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   970: aload_3
    //   971: aload_1
    //   972: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   975: aload_3
    //   976: iconst_1
    //   977: putfield 947	gnu/mapping/CallContext:pc	I
    //   980: iconst_0
    //   981: ireturn
    //   982: aload_3
    //   983: aload_2
    //   984: ldc -85
    //   986: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   989: dup
    //   990: instanceof 171
    //   993: ifne +7 -> 1000
    //   996: ldc_w 936
    //   999: ireturn
    //   1000: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1003: aload_3
    //   1004: aload_1
    //   1005: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1008: aload_3
    //   1009: iconst_1
    //   1010: putfield 947	gnu/mapping/CallContext:pc	I
    //   1013: iconst_0
    //   1014: ireturn
    //   1015: aload_3
    //   1016: aload_2
    //   1017: ldc -85
    //   1019: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1022: dup
    //   1023: instanceof 171
    //   1026: ifne +7 -> 1033
    //   1029: ldc_w 936
    //   1032: ireturn
    //   1033: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1036: aload_3
    //   1037: aload_1
    //   1038: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1041: aload_3
    //   1042: iconst_1
    //   1043: putfield 947	gnu/mapping/CallContext:pc	I
    //   1046: iconst_0
    //   1047: ireturn
    //   1048: aload_3
    //   1049: aload_2
    //   1050: ldc -85
    //   1052: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1055: dup
    //   1056: instanceof 171
    //   1059: ifne +7 -> 1066
    //   1062: ldc_w 936
    //   1065: ireturn
    //   1066: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1069: aload_3
    //   1070: aload_1
    //   1071: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1074: aload_3
    //   1075: iconst_1
    //   1076: putfield 947	gnu/mapping/CallContext:pc	I
    //   1079: iconst_0
    //   1080: ireturn
    //   1081: aload_3
    //   1082: aload_2
    //   1083: ldc -46
    //   1085: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1088: dup
    //   1089: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1092: ifnull +6 -> 1098
    //   1095: goto +7 -> 1102
    //   1098: ldc_w 936
    //   1101: ireturn
    //   1102: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1105: aload_3
    //   1106: aload_1
    //   1107: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1110: aload_3
    //   1111: iconst_1
    //   1112: putfield 947	gnu/mapping/CallContext:pc	I
    //   1115: iconst_0
    //   1116: ireturn
    //   1117: aload_3
    //   1118: aload_2
    //   1119: ldc -46
    //   1121: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1124: dup
    //   1125: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1128: ifnull +6 -> 1134
    //   1131: goto +7 -> 1138
    //   1134: ldc_w 936
    //   1137: ireturn
    //   1138: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1141: aload_3
    //   1142: aload_1
    //   1143: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1146: aload_3
    //   1147: iconst_1
    //   1148: putfield 947	gnu/mapping/CallContext:pc	I
    //   1151: iconst_0
    //   1152: ireturn
    //   1153: aload_3
    //   1154: aload_2
    //   1155: ldc -46
    //   1157: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1160: dup
    //   1161: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1164: ifnull +6 -> 1170
    //   1167: goto +7 -> 1174
    //   1170: ldc_w 936
    //   1173: ireturn
    //   1174: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1177: aload_3
    //   1178: aload_1
    //   1179: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1182: aload_3
    //   1183: iconst_1
    //   1184: putfield 947	gnu/mapping/CallContext:pc	I
    //   1187: iconst_0
    //   1188: ireturn
    //   1189: aload_3
    //   1190: aload_2
    //   1191: ldc -85
    //   1193: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1196: dup
    //   1197: instanceof 171
    //   1200: ifne +7 -> 1207
    //   1203: ldc_w 936
    //   1206: ireturn
    //   1207: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1210: aload_3
    //   1211: aload_1
    //   1212: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1215: aload_3
    //   1216: iconst_1
    //   1217: putfield 947	gnu/mapping/CallContext:pc	I
    //   1220: iconst_0
    //   1221: ireturn
    //   1222: aload_3
    //   1223: aload_2
    //   1224: ldc -85
    //   1226: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1229: dup
    //   1230: instanceof 171
    //   1233: ifne +7 -> 1240
    //   1236: ldc_w 936
    //   1239: ireturn
    //   1240: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1243: aload_3
    //   1244: aload_1
    //   1245: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1248: aload_3
    //   1249: iconst_1
    //   1250: putfield 947	gnu/mapping/CallContext:pc	I
    //   1253: iconst_0
    //   1254: ireturn
    //   1255: aload_3
    //   1256: aload_2
    //   1257: ldc -85
    //   1259: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1262: dup
    //   1263: instanceof 171
    //   1266: ifne +7 -> 1273
    //   1269: ldc_w 936
    //   1272: ireturn
    //   1273: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1276: aload_3
    //   1277: aload_1
    //   1278: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1281: aload_3
    //   1282: iconst_1
    //   1283: putfield 947	gnu/mapping/CallContext:pc	I
    //   1286: iconst_0
    //   1287: ireturn
    //   1288: aload_3
    //   1289: aload_2
    //   1290: ldc_w 952
    //   1293: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1296: dup
    //   1297: instanceof 952
    //   1300: ifne +7 -> 1307
    //   1303: ldc_w 936
    //   1306: ireturn
    //   1307: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1310: aload_3
    //   1311: aload_1
    //   1312: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1315: aload_3
    //   1316: iconst_1
    //   1317: putfield 947	gnu/mapping/CallContext:pc	I
    //   1320: iconst_0
    //   1321: ireturn
    //   1322: aload_3
    //   1323: aload_2
    //   1324: ldc -85
    //   1326: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1329: dup
    //   1330: instanceof 171
    //   1333: ifne +7 -> 1340
    //   1336: ldc_w 936
    //   1339: ireturn
    //   1340: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1343: aload_3
    //   1344: aload_1
    //   1345: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1348: aload_3
    //   1349: iconst_1
    //   1350: putfield 947	gnu/mapping/CallContext:pc	I
    //   1353: iconst_0
    //   1354: ireturn
    //   1355: aload_0
    //   1356: aload_1
    //   1357: aload_2
    //   1358: aload_3
    //   1359: invokespecial 956	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   1362: ireturn
    // Line number table:
    //   Java source line #706	-> byte code offset #256
    //   Java source line #523	-> byte code offset #685
    //   Java source line #499	-> byte code offset #718
    //   Java source line #475	-> byte code offset #751
    //   Java source line #451	-> byte code offset #784
    //   Java source line #427	-> byte code offset #817
    //   Java source line #403	-> byte code offset #850
    //   Java source line #368	-> byte code offset #883
    //   Java source line #343	-> byte code offset #916
    //   Java source line #318	-> byte code offset #949
    //   Java source line #293	-> byte code offset #982
    //   Java source line #268	-> byte code offset #1015
    //   Java source line #244	-> byte code offset #1048
    //   Java source line #230	-> byte code offset #1081
    //   Java source line #224	-> byte code offset #1117
    //   Java source line #218	-> byte code offset #1153
    //   Java source line #199	-> byte code offset #1189
    //   Java source line #195	-> byte code offset #1222
    //   Java source line #190	-> byte code offset #1255
    //   Java source line #148	-> byte code offset #1288
    //   Java source line #126	-> byte code offset #1322
  }
  
  /* Error */
  public int match2(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 935	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+181->185, 2:+155->159, 8:+36->40, 62:+97->101
    //   40: aload 4
    //   42: aload_2
    //   43: ldc -85
    //   45: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   48: dup
    //   49: instanceof 171
    //   52: ifne +7 -> 59
    //   55: ldc_w 936
    //   58: ireturn
    //   59: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   62: aload 4
    //   64: aload_3
    //   65: ldc -46
    //   67: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   70: dup
    //   71: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   74: ifnull +6 -> 80
    //   77: goto +7 -> 84
    //   80: ldc_w 957
    //   83: ireturn
    //   84: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   87: aload 4
    //   89: aload_1
    //   90: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   93: aload 4
    //   95: iconst_2
    //   96: putfield 947	gnu/mapping/CallContext:pc	I
    //   99: iconst_0
    //   100: ireturn
    //   101: aload 4
    //   103: aload_2
    //   104: ldc -85
    //   106: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   109: dup
    //   110: instanceof 171
    //   113: ifne +7 -> 120
    //   116: ldc_w 936
    //   119: ireturn
    //   120: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   123: aload 4
    //   125: aload_3
    //   126: ldc -85
    //   128: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   131: dup
    //   132: instanceof 171
    //   135: ifne +7 -> 142
    //   138: ldc_w 957
    //   141: ireturn
    //   142: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   145: aload 4
    //   147: aload_1
    //   148: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   151: aload 4
    //   153: iconst_2
    //   154: putfield 947	gnu/mapping/CallContext:pc	I
    //   157: iconst_0
    //   158: ireturn
    //   159: aload 4
    //   161: aload_2
    //   162: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   165: aload 4
    //   167: aload_3
    //   168: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   171: aload 4
    //   173: aload_1
    //   174: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   177: aload 4
    //   179: iconst_2
    //   180: putfield 947	gnu/mapping/CallContext:pc	I
    //   183: iconst_0
    //   184: ireturn
    //   185: aload_0
    //   186: aload_1
    //   187: aload_2
    //   188: aload_3
    //   189: aload 4
    //   191: invokespecial 964	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   194: ireturn
    // Line number table:
    //   Java source line #205	-> byte code offset #40
    //   Java source line #715	-> byte code offset #101
    //   Java source line #145	-> byte code offset #159
  }
  
  /* Error */
  public int match3(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 935	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+2320->2324, 25:+2230->2234, 26:+2140->2144, 27:+2050->2054, 28:+1960->1964, 29:+1870->1874, 30:+1780->1784, 31:+1690->1694, 32:+1600->1604, 33:+1510->1514, 34:+1420->1424, 35:+1330->1334, 36:+1240->1244, 37:+2320->2324, 38:+2320->2324, 39:+2320->2324, 40:+2320->2324, 41:+2320->2324, 42:+2320->2324, 43:+2320->2324, 44:+2320->2324, 45:+2320->2324, 46:+2320->2324, 47:+2320->2324, 48:+2320->2324, 49:+1150->1154, 50:+1060->1064, 51:+970->974, 52:+880->884, 53:+790->794, 54:+700->704, 55:+610->614, 56:+520->524, 57:+430->434, 58:+340->344, 59:+250->254, 60:+160->164
    //   164: aload 5
    //   166: aload_2
    //   167: ldc -46
    //   169: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   172: dup
    //   173: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   176: ifnull +6 -> 182
    //   179: goto +7 -> 186
    //   182: ldc_w 936
    //   185: ireturn
    //   186: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   189: aload 5
    //   191: aload_3
    //   192: ldc -46
    //   194: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   197: dup
    //   198: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   201: ifnull +6 -> 207
    //   204: goto +7 -> 211
    //   207: ldc_w 957
    //   210: ireturn
    //   211: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   214: aload 5
    //   216: aload 4
    //   218: ldc -46
    //   220: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   223: dup
    //   224: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   227: ifnull +6 -> 233
    //   230: goto +7 -> 237
    //   233: ldc_w 965
    //   236: ireturn
    //   237: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   240: aload 5
    //   242: aload_1
    //   243: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   246: aload 5
    //   248: iconst_3
    //   249: putfield 947	gnu/mapping/CallContext:pc	I
    //   252: iconst_0
    //   253: ireturn
    //   254: aload 5
    //   256: aload_2
    //   257: ldc -46
    //   259: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   262: dup
    //   263: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   266: ifnull +6 -> 272
    //   269: goto +7 -> 276
    //   272: ldc_w 936
    //   275: ireturn
    //   276: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   279: aload 5
    //   281: aload_3
    //   282: ldc -46
    //   284: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   287: dup
    //   288: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   291: ifnull +6 -> 297
    //   294: goto +7 -> 301
    //   297: ldc_w 957
    //   300: ireturn
    //   301: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   304: aload 5
    //   306: aload 4
    //   308: ldc -46
    //   310: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   313: dup
    //   314: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   317: ifnull +6 -> 323
    //   320: goto +7 -> 327
    //   323: ldc_w 965
    //   326: ireturn
    //   327: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   330: aload 5
    //   332: aload_1
    //   333: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   336: aload 5
    //   338: iconst_3
    //   339: putfield 947	gnu/mapping/CallContext:pc	I
    //   342: iconst_0
    //   343: ireturn
    //   344: aload 5
    //   346: aload_2
    //   347: ldc -46
    //   349: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   352: dup
    //   353: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   356: ifnull +6 -> 362
    //   359: goto +7 -> 366
    //   362: ldc_w 936
    //   365: ireturn
    //   366: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   369: aload 5
    //   371: aload_3
    //   372: ldc -46
    //   374: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   377: dup
    //   378: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   381: ifnull +6 -> 387
    //   384: goto +7 -> 391
    //   387: ldc_w 957
    //   390: ireturn
    //   391: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   394: aload 5
    //   396: aload 4
    //   398: ldc -46
    //   400: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   403: dup
    //   404: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   407: ifnull +6 -> 413
    //   410: goto +7 -> 417
    //   413: ldc_w 965
    //   416: ireturn
    //   417: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   420: aload 5
    //   422: aload_1
    //   423: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   426: aload 5
    //   428: iconst_3
    //   429: putfield 947	gnu/mapping/CallContext:pc	I
    //   432: iconst_0
    //   433: ireturn
    //   434: aload 5
    //   436: aload_2
    //   437: ldc -46
    //   439: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   442: dup
    //   443: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   446: ifnull +6 -> 452
    //   449: goto +7 -> 456
    //   452: ldc_w 936
    //   455: ireturn
    //   456: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   459: aload 5
    //   461: aload_3
    //   462: ldc -46
    //   464: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   467: dup
    //   468: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   471: ifnull +6 -> 477
    //   474: goto +7 -> 481
    //   477: ldc_w 957
    //   480: ireturn
    //   481: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   484: aload 5
    //   486: aload 4
    //   488: ldc -46
    //   490: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   493: dup
    //   494: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   497: ifnull +6 -> 503
    //   500: goto +7 -> 507
    //   503: ldc_w 965
    //   506: ireturn
    //   507: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   510: aload 5
    //   512: aload_1
    //   513: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   516: aload 5
    //   518: iconst_3
    //   519: putfield 947	gnu/mapping/CallContext:pc	I
    //   522: iconst_0
    //   523: ireturn
    //   524: aload 5
    //   526: aload_2
    //   527: ldc -46
    //   529: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   532: dup
    //   533: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   536: ifnull +6 -> 542
    //   539: goto +7 -> 546
    //   542: ldc_w 936
    //   545: ireturn
    //   546: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   549: aload 5
    //   551: aload_3
    //   552: ldc -46
    //   554: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   557: dup
    //   558: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   561: ifnull +6 -> 567
    //   564: goto +7 -> 571
    //   567: ldc_w 957
    //   570: ireturn
    //   571: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   574: aload 5
    //   576: aload 4
    //   578: ldc -46
    //   580: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   583: dup
    //   584: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   587: ifnull +6 -> 593
    //   590: goto +7 -> 597
    //   593: ldc_w 965
    //   596: ireturn
    //   597: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   600: aload 5
    //   602: aload_1
    //   603: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   606: aload 5
    //   608: iconst_3
    //   609: putfield 947	gnu/mapping/CallContext:pc	I
    //   612: iconst_0
    //   613: ireturn
    //   614: aload 5
    //   616: aload_2
    //   617: ldc -46
    //   619: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   622: dup
    //   623: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   626: ifnull +6 -> 632
    //   629: goto +7 -> 636
    //   632: ldc_w 936
    //   635: ireturn
    //   636: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   639: aload 5
    //   641: aload_3
    //   642: ldc -46
    //   644: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   647: dup
    //   648: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   651: ifnull +6 -> 657
    //   654: goto +7 -> 661
    //   657: ldc_w 957
    //   660: ireturn
    //   661: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   664: aload 5
    //   666: aload 4
    //   668: ldc -46
    //   670: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   673: dup
    //   674: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   677: ifnull +6 -> 683
    //   680: goto +7 -> 687
    //   683: ldc_w 965
    //   686: ireturn
    //   687: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   690: aload 5
    //   692: aload_1
    //   693: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   696: aload 5
    //   698: iconst_3
    //   699: putfield 947	gnu/mapping/CallContext:pc	I
    //   702: iconst_0
    //   703: ireturn
    //   704: aload 5
    //   706: aload_2
    //   707: ldc -46
    //   709: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   712: dup
    //   713: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   716: ifnull +6 -> 722
    //   719: goto +7 -> 726
    //   722: ldc_w 936
    //   725: ireturn
    //   726: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   729: aload 5
    //   731: aload_3
    //   732: ldc -46
    //   734: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   737: dup
    //   738: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   741: ifnull +6 -> 747
    //   744: goto +7 -> 751
    //   747: ldc_w 957
    //   750: ireturn
    //   751: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   754: aload 5
    //   756: aload 4
    //   758: ldc -46
    //   760: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   763: dup
    //   764: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   767: ifnull +6 -> 773
    //   770: goto +7 -> 777
    //   773: ldc_w 965
    //   776: ireturn
    //   777: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   780: aload 5
    //   782: aload_1
    //   783: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   786: aload 5
    //   788: iconst_3
    //   789: putfield 947	gnu/mapping/CallContext:pc	I
    //   792: iconst_0
    //   793: ireturn
    //   794: aload 5
    //   796: aload_2
    //   797: ldc -46
    //   799: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   802: dup
    //   803: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   806: ifnull +6 -> 812
    //   809: goto +7 -> 816
    //   812: ldc_w 936
    //   815: ireturn
    //   816: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   819: aload 5
    //   821: aload_3
    //   822: ldc -46
    //   824: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   827: dup
    //   828: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   831: ifnull +6 -> 837
    //   834: goto +7 -> 841
    //   837: ldc_w 957
    //   840: ireturn
    //   841: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   844: aload 5
    //   846: aload 4
    //   848: ldc -46
    //   850: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   853: dup
    //   854: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   857: ifnull +6 -> 863
    //   860: goto +7 -> 867
    //   863: ldc_w 965
    //   866: ireturn
    //   867: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   870: aload 5
    //   872: aload_1
    //   873: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   876: aload 5
    //   878: iconst_3
    //   879: putfield 947	gnu/mapping/CallContext:pc	I
    //   882: iconst_0
    //   883: ireturn
    //   884: aload 5
    //   886: aload_2
    //   887: ldc -46
    //   889: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   892: dup
    //   893: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   896: ifnull +6 -> 902
    //   899: goto +7 -> 906
    //   902: ldc_w 936
    //   905: ireturn
    //   906: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   909: aload 5
    //   911: aload_3
    //   912: ldc -46
    //   914: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   917: dup
    //   918: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   921: ifnull +6 -> 927
    //   924: goto +7 -> 931
    //   927: ldc_w 957
    //   930: ireturn
    //   931: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   934: aload 5
    //   936: aload 4
    //   938: ldc -46
    //   940: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   943: dup
    //   944: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   947: ifnull +6 -> 953
    //   950: goto +7 -> 957
    //   953: ldc_w 965
    //   956: ireturn
    //   957: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   960: aload 5
    //   962: aload_1
    //   963: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   966: aload 5
    //   968: iconst_3
    //   969: putfield 947	gnu/mapping/CallContext:pc	I
    //   972: iconst_0
    //   973: ireturn
    //   974: aload 5
    //   976: aload_2
    //   977: ldc -46
    //   979: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   982: dup
    //   983: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   986: ifnull +6 -> 992
    //   989: goto +7 -> 996
    //   992: ldc_w 936
    //   995: ireturn
    //   996: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   999: aload 5
    //   1001: aload_3
    //   1002: ldc -46
    //   1004: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1007: dup
    //   1008: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1011: ifnull +6 -> 1017
    //   1014: goto +7 -> 1021
    //   1017: ldc_w 957
    //   1020: ireturn
    //   1021: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1024: aload 5
    //   1026: aload 4
    //   1028: ldc -46
    //   1030: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1033: dup
    //   1034: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1037: ifnull +6 -> 1043
    //   1040: goto +7 -> 1047
    //   1043: ldc_w 965
    //   1046: ireturn
    //   1047: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   1050: aload 5
    //   1052: aload_1
    //   1053: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1056: aload 5
    //   1058: iconst_3
    //   1059: putfield 947	gnu/mapping/CallContext:pc	I
    //   1062: iconst_0
    //   1063: ireturn
    //   1064: aload 5
    //   1066: aload_2
    //   1067: ldc -46
    //   1069: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1072: dup
    //   1073: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1076: ifnull +6 -> 1082
    //   1079: goto +7 -> 1086
    //   1082: ldc_w 936
    //   1085: ireturn
    //   1086: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1089: aload 5
    //   1091: aload_3
    //   1092: ldc -46
    //   1094: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1097: dup
    //   1098: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1101: ifnull +6 -> 1107
    //   1104: goto +7 -> 1111
    //   1107: ldc_w 957
    //   1110: ireturn
    //   1111: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1114: aload 5
    //   1116: aload 4
    //   1118: ldc -46
    //   1120: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1123: dup
    //   1124: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1127: ifnull +6 -> 1133
    //   1130: goto +7 -> 1137
    //   1133: ldc_w 965
    //   1136: ireturn
    //   1137: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   1140: aload 5
    //   1142: aload_1
    //   1143: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1146: aload 5
    //   1148: iconst_3
    //   1149: putfield 947	gnu/mapping/CallContext:pc	I
    //   1152: iconst_0
    //   1153: ireturn
    //   1154: aload 5
    //   1156: aload_2
    //   1157: ldc -46
    //   1159: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1162: dup
    //   1163: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1166: ifnull +6 -> 1172
    //   1169: goto +7 -> 1176
    //   1172: ldc_w 936
    //   1175: ireturn
    //   1176: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1179: aload 5
    //   1181: aload_3
    //   1182: ldc -46
    //   1184: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1187: dup
    //   1188: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1191: ifnull +6 -> 1197
    //   1194: goto +7 -> 1201
    //   1197: ldc_w 957
    //   1200: ireturn
    //   1201: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1204: aload 5
    //   1206: aload 4
    //   1208: ldc -46
    //   1210: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1213: dup
    //   1214: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1217: ifnull +6 -> 1223
    //   1220: goto +7 -> 1227
    //   1223: ldc_w 965
    //   1226: ireturn
    //   1227: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   1230: aload 5
    //   1232: aload_1
    //   1233: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1236: aload 5
    //   1238: iconst_3
    //   1239: putfield 947	gnu/mapping/CallContext:pc	I
    //   1242: iconst_0
    //   1243: ireturn
    //   1244: aload 5
    //   1246: aload_2
    //   1247: ldc -46
    //   1249: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1252: dup
    //   1253: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1256: ifnull +6 -> 1262
    //   1259: goto +7 -> 1266
    //   1262: ldc_w 936
    //   1265: ireturn
    //   1266: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1269: aload 5
    //   1271: aload_3
    //   1272: ldc -46
    //   1274: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1277: dup
    //   1278: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1281: ifnull +6 -> 1287
    //   1284: goto +7 -> 1291
    //   1287: ldc_w 957
    //   1290: ireturn
    //   1291: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1294: aload 5
    //   1296: aload 4
    //   1298: ldc -46
    //   1300: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1303: dup
    //   1304: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1307: ifnull +6 -> 1313
    //   1310: goto +7 -> 1317
    //   1313: ldc_w 965
    //   1316: ireturn
    //   1317: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   1320: aload 5
    //   1322: aload_1
    //   1323: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1326: aload 5
    //   1328: iconst_3
    //   1329: putfield 947	gnu/mapping/CallContext:pc	I
    //   1332: iconst_0
    //   1333: ireturn
    //   1334: aload 5
    //   1336: aload_2
    //   1337: ldc -46
    //   1339: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1342: dup
    //   1343: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1346: ifnull +6 -> 1352
    //   1349: goto +7 -> 1356
    //   1352: ldc_w 936
    //   1355: ireturn
    //   1356: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1359: aload 5
    //   1361: aload_3
    //   1362: ldc -46
    //   1364: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1367: dup
    //   1368: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1371: ifnull +6 -> 1377
    //   1374: goto +7 -> 1381
    //   1377: ldc_w 957
    //   1380: ireturn
    //   1381: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1384: aload 5
    //   1386: aload 4
    //   1388: ldc -46
    //   1390: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1393: dup
    //   1394: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1397: ifnull +6 -> 1403
    //   1400: goto +7 -> 1407
    //   1403: ldc_w 965
    //   1406: ireturn
    //   1407: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   1410: aload 5
    //   1412: aload_1
    //   1413: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1416: aload 5
    //   1418: iconst_3
    //   1419: putfield 947	gnu/mapping/CallContext:pc	I
    //   1422: iconst_0
    //   1423: ireturn
    //   1424: aload 5
    //   1426: aload_2
    //   1427: ldc -46
    //   1429: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1432: dup
    //   1433: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1436: ifnull +6 -> 1442
    //   1439: goto +7 -> 1446
    //   1442: ldc_w 936
    //   1445: ireturn
    //   1446: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1449: aload 5
    //   1451: aload_3
    //   1452: ldc -46
    //   1454: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1457: dup
    //   1458: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1461: ifnull +6 -> 1467
    //   1464: goto +7 -> 1471
    //   1467: ldc_w 957
    //   1470: ireturn
    //   1471: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1474: aload 5
    //   1476: aload 4
    //   1478: ldc -46
    //   1480: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1483: dup
    //   1484: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1487: ifnull +6 -> 1493
    //   1490: goto +7 -> 1497
    //   1493: ldc_w 965
    //   1496: ireturn
    //   1497: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   1500: aload 5
    //   1502: aload_1
    //   1503: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1506: aload 5
    //   1508: iconst_3
    //   1509: putfield 947	gnu/mapping/CallContext:pc	I
    //   1512: iconst_0
    //   1513: ireturn
    //   1514: aload 5
    //   1516: aload_2
    //   1517: ldc -46
    //   1519: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1522: dup
    //   1523: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1526: ifnull +6 -> 1532
    //   1529: goto +7 -> 1536
    //   1532: ldc_w 936
    //   1535: ireturn
    //   1536: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1539: aload 5
    //   1541: aload_3
    //   1542: ldc -46
    //   1544: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1547: dup
    //   1548: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1551: ifnull +6 -> 1557
    //   1554: goto +7 -> 1561
    //   1557: ldc_w 957
    //   1560: ireturn
    //   1561: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1564: aload 5
    //   1566: aload 4
    //   1568: ldc -46
    //   1570: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1573: dup
    //   1574: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1577: ifnull +6 -> 1583
    //   1580: goto +7 -> 1587
    //   1583: ldc_w 965
    //   1586: ireturn
    //   1587: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   1590: aload 5
    //   1592: aload_1
    //   1593: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1596: aload 5
    //   1598: iconst_3
    //   1599: putfield 947	gnu/mapping/CallContext:pc	I
    //   1602: iconst_0
    //   1603: ireturn
    //   1604: aload 5
    //   1606: aload_2
    //   1607: ldc -46
    //   1609: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1612: dup
    //   1613: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1616: ifnull +6 -> 1622
    //   1619: goto +7 -> 1626
    //   1622: ldc_w 936
    //   1625: ireturn
    //   1626: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1629: aload 5
    //   1631: aload_3
    //   1632: ldc -46
    //   1634: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1637: dup
    //   1638: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1641: ifnull +6 -> 1647
    //   1644: goto +7 -> 1651
    //   1647: ldc_w 957
    //   1650: ireturn
    //   1651: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1654: aload 5
    //   1656: aload 4
    //   1658: ldc -46
    //   1660: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1663: dup
    //   1664: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1667: ifnull +6 -> 1673
    //   1670: goto +7 -> 1677
    //   1673: ldc_w 965
    //   1676: ireturn
    //   1677: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   1680: aload 5
    //   1682: aload_1
    //   1683: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1686: aload 5
    //   1688: iconst_3
    //   1689: putfield 947	gnu/mapping/CallContext:pc	I
    //   1692: iconst_0
    //   1693: ireturn
    //   1694: aload 5
    //   1696: aload_2
    //   1697: ldc -46
    //   1699: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1702: dup
    //   1703: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1706: ifnull +6 -> 1712
    //   1709: goto +7 -> 1716
    //   1712: ldc_w 936
    //   1715: ireturn
    //   1716: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1719: aload 5
    //   1721: aload_3
    //   1722: ldc -46
    //   1724: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1727: dup
    //   1728: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1731: ifnull +6 -> 1737
    //   1734: goto +7 -> 1741
    //   1737: ldc_w 957
    //   1740: ireturn
    //   1741: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1744: aload 5
    //   1746: aload 4
    //   1748: ldc -46
    //   1750: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1753: dup
    //   1754: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1757: ifnull +6 -> 1763
    //   1760: goto +7 -> 1767
    //   1763: ldc_w 965
    //   1766: ireturn
    //   1767: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   1770: aload 5
    //   1772: aload_1
    //   1773: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1776: aload 5
    //   1778: iconst_3
    //   1779: putfield 947	gnu/mapping/CallContext:pc	I
    //   1782: iconst_0
    //   1783: ireturn
    //   1784: aload 5
    //   1786: aload_2
    //   1787: ldc -46
    //   1789: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1792: dup
    //   1793: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1796: ifnull +6 -> 1802
    //   1799: goto +7 -> 1806
    //   1802: ldc_w 936
    //   1805: ireturn
    //   1806: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1809: aload 5
    //   1811: aload_3
    //   1812: ldc -46
    //   1814: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1817: dup
    //   1818: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1821: ifnull +6 -> 1827
    //   1824: goto +7 -> 1831
    //   1827: ldc_w 957
    //   1830: ireturn
    //   1831: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1834: aload 5
    //   1836: aload 4
    //   1838: ldc -46
    //   1840: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1843: dup
    //   1844: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1847: ifnull +6 -> 1853
    //   1850: goto +7 -> 1857
    //   1853: ldc_w 965
    //   1856: ireturn
    //   1857: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   1860: aload 5
    //   1862: aload_1
    //   1863: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1866: aload 5
    //   1868: iconst_3
    //   1869: putfield 947	gnu/mapping/CallContext:pc	I
    //   1872: iconst_0
    //   1873: ireturn
    //   1874: aload 5
    //   1876: aload_2
    //   1877: ldc -46
    //   1879: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1882: dup
    //   1883: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1886: ifnull +6 -> 1892
    //   1889: goto +7 -> 1896
    //   1892: ldc_w 936
    //   1895: ireturn
    //   1896: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1899: aload 5
    //   1901: aload_3
    //   1902: ldc -46
    //   1904: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1907: dup
    //   1908: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1911: ifnull +6 -> 1917
    //   1914: goto +7 -> 1921
    //   1917: ldc_w 957
    //   1920: ireturn
    //   1921: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1924: aload 5
    //   1926: aload 4
    //   1928: ldc -46
    //   1930: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1933: dup
    //   1934: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1937: ifnull +6 -> 1943
    //   1940: goto +7 -> 1947
    //   1943: ldc_w 965
    //   1946: ireturn
    //   1947: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   1950: aload 5
    //   1952: aload_1
    //   1953: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1956: aload 5
    //   1958: iconst_3
    //   1959: putfield 947	gnu/mapping/CallContext:pc	I
    //   1962: iconst_0
    //   1963: ireturn
    //   1964: aload 5
    //   1966: aload_2
    //   1967: ldc -46
    //   1969: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1972: dup
    //   1973: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1976: ifnull +6 -> 1982
    //   1979: goto +7 -> 1986
    //   1982: ldc_w 936
    //   1985: ireturn
    //   1986: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1989: aload 5
    //   1991: aload_3
    //   1992: ldc -46
    //   1994: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1997: dup
    //   1998: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2001: ifnull +6 -> 2007
    //   2004: goto +7 -> 2011
    //   2007: ldc_w 957
    //   2010: ireturn
    //   2011: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   2014: aload 5
    //   2016: aload 4
    //   2018: ldc -46
    //   2020: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2023: dup
    //   2024: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2027: ifnull +6 -> 2033
    //   2030: goto +7 -> 2037
    //   2033: ldc_w 965
    //   2036: ireturn
    //   2037: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   2040: aload 5
    //   2042: aload_1
    //   2043: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2046: aload 5
    //   2048: iconst_3
    //   2049: putfield 947	gnu/mapping/CallContext:pc	I
    //   2052: iconst_0
    //   2053: ireturn
    //   2054: aload 5
    //   2056: aload_2
    //   2057: ldc -46
    //   2059: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2062: dup
    //   2063: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2066: ifnull +6 -> 2072
    //   2069: goto +7 -> 2076
    //   2072: ldc_w 936
    //   2075: ireturn
    //   2076: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2079: aload 5
    //   2081: aload_3
    //   2082: ldc -46
    //   2084: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2087: dup
    //   2088: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2091: ifnull +6 -> 2097
    //   2094: goto +7 -> 2101
    //   2097: ldc_w 957
    //   2100: ireturn
    //   2101: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   2104: aload 5
    //   2106: aload 4
    //   2108: ldc -46
    //   2110: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2113: dup
    //   2114: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2117: ifnull +6 -> 2123
    //   2120: goto +7 -> 2127
    //   2123: ldc_w 965
    //   2126: ireturn
    //   2127: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   2130: aload 5
    //   2132: aload_1
    //   2133: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2136: aload 5
    //   2138: iconst_3
    //   2139: putfield 947	gnu/mapping/CallContext:pc	I
    //   2142: iconst_0
    //   2143: ireturn
    //   2144: aload 5
    //   2146: aload_2
    //   2147: ldc -46
    //   2149: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2152: dup
    //   2153: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2156: ifnull +6 -> 2162
    //   2159: goto +7 -> 2166
    //   2162: ldc_w 936
    //   2165: ireturn
    //   2166: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2169: aload 5
    //   2171: aload_3
    //   2172: ldc -46
    //   2174: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2177: dup
    //   2178: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2181: ifnull +6 -> 2187
    //   2184: goto +7 -> 2191
    //   2187: ldc_w 957
    //   2190: ireturn
    //   2191: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   2194: aload 5
    //   2196: aload 4
    //   2198: ldc -46
    //   2200: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2203: dup
    //   2204: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2207: ifnull +6 -> 2213
    //   2210: goto +7 -> 2217
    //   2213: ldc_w 965
    //   2216: ireturn
    //   2217: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   2220: aload 5
    //   2222: aload_1
    //   2223: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2226: aload 5
    //   2228: iconst_3
    //   2229: putfield 947	gnu/mapping/CallContext:pc	I
    //   2232: iconst_0
    //   2233: ireturn
    //   2234: aload 5
    //   2236: aload_2
    //   2237: ldc -46
    //   2239: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2242: dup
    //   2243: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2246: ifnull +6 -> 2252
    //   2249: goto +7 -> 2256
    //   2252: ldc_w 936
    //   2255: ireturn
    //   2256: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2259: aload 5
    //   2261: aload_3
    //   2262: ldc -46
    //   2264: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2267: dup
    //   2268: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2271: ifnull +6 -> 2277
    //   2274: goto +7 -> 2281
    //   2277: ldc_w 957
    //   2280: ireturn
    //   2281: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   2284: aload 5
    //   2286: aload 4
    //   2288: ldc -46
    //   2290: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2293: dup
    //   2294: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2297: ifnull +6 -> 2303
    //   2300: goto +7 -> 2307
    //   2303: ldc_w 965
    //   2306: ireturn
    //   2307: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   2310: aload 5
    //   2312: aload_1
    //   2313: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2316: aload 5
    //   2318: iconst_3
    //   2319: putfield 947	gnu/mapping/CallContext:pc	I
    //   2322: iconst_0
    //   2323: ireturn
    //   2324: aload_0
    //   2325: aload_1
    //   2326: aload_2
    //   2327: aload_3
    //   2328: aload 4
    //   2330: aload 5
    //   2332: invokespecial 972	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   2335: ireturn
  }
  
  /* Error */
  public int match4(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, gnu.mapping.CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 935	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 9
    //   6: if_icmpne +122 -> 128
    //   9: goto +3 -> 12
    //   12: aload 6
    //   14: aload_2
    //   15: ldc -46
    //   17: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   20: dup
    //   21: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   24: ifnull +6 -> 30
    //   27: goto +7 -> 34
    //   30: ldc_w 936
    //   33: ireturn
    //   34: putfield 940	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   37: aload 6
    //   39: aload_3
    //   40: ldc -46
    //   42: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   45: dup
    //   46: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   49: ifnull +6 -> 55
    //   52: goto +7 -> 59
    //   55: ldc_w 957
    //   58: ireturn
    //   59: putfield 960	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   62: aload 6
    //   64: aload 4
    //   66: ldc -46
    //   68: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   71: dup
    //   72: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   75: ifnull +6 -> 81
    //   78: goto +7 -> 85
    //   81: ldc_w 965
    //   84: ireturn
    //   85: putfield 968	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   88: aload 6
    //   90: aload 5
    //   92: ldc -46
    //   94: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   97: dup
    //   98: invokestatic 950	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   101: ifnull +6 -> 107
    //   104: goto +7 -> 111
    //   107: ldc_w 973
    //   110: ireturn
    //   111: putfield 976	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   114: aload 6
    //   116: aload_1
    //   117: putfield 944	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   120: aload 6
    //   122: iconst_4
    //   123: putfield 947	gnu/mapping/CallContext:pc	I
    //   126: iconst_0
    //   127: ireturn
    //   128: aload_0
    //   129: aload_1
    //   130: aload_2
    //   131: aload_3
    //   132: aload 4
    //   134: aload 5
    //   136: aload 6
    //   138: invokespecial 980	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   141: ireturn
    // Line number table:
    //   Java source line #211	-> byte code offset #12
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply2(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 935	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+86->90, 2:+36->40, 8:+64->68, 62:+42->46
    //   40: aload_2
    //   41: aload_3
    //   42: invokestatic 1104	kawa/lib/kawa/rotations:lambda1	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   45: areturn
    //   46: aload_2
    //   47: ldc -85
    //   49: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   52: checkcast 171	gnu/math/Quaternion
    //   55: aload_3
    //   56: ldc -85
    //   58: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   61: checkcast 171	gnu/math/Quaternion
    //   64: invokestatic 1110	kawa/lib/kawa/rotations:rotateVector	(Lgnu/math/Quaternion;Lgnu/math/Quaternion;)Lgnu/math/Quaternion;
    //   67: areturn
    //   68: aload_2
    //   69: ldc -85
    //   71: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   74: checkcast 171	gnu/math/Quaternion
    //   77: aload_3
    //   78: ldc -46
    //   80: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   83: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   86: invokestatic 1114	kawa/lib/kawa/rotations:makeAxis$SlAngle	(Lgnu/math/Quaternion;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   89: areturn
    //   90: aload_0
    //   91: aload_1
    //   92: aload_2
    //   93: aload_3
    //   94: invokespecial 1117	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: areturn
    //   98: new 31	gnu/mapping/WrongType
    //   101: dup_x1
    //   102: swap
    //   103: ldc_w 1106
    //   106: iconst_1
    //   107: aload_2
    //   108: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   111: athrow
    //   112: new 31	gnu/mapping/WrongType
    //   115: dup_x1
    //   116: swap
    //   117: ldc_w 1106
    //   120: iconst_2
    //   121: aload_3
    //   122: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   125: athrow
    //   126: new 31	gnu/mapping/WrongType
    //   129: dup_x1
    //   130: swap
    //   131: ldc_w 498
    //   134: iconst_1
    //   135: aload_2
    //   136: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   139: athrow
    //   140: new 31	gnu/mapping/WrongType
    //   143: dup_x1
    //   144: swap
    //   145: ldc_w 498
    //   148: iconst_2
    //   149: aload_3
    //   150: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   153: athrow
    // Line number table:
    //   Java source line #145	-> byte code offset #40
    //   Java source line #715	-> byte code offset #46
    //   Java source line #205	-> byte code offset #68
    //   Java source line #715	-> byte code offset #98
    //   Java source line #205	-> byte code offset #126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	rotations
    //   0	154	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	154	2	paramObject1	Object
    //   0	154	3	paramObject2	Object
    //   98	1	4	localClassCastException1	ClassCastException
    //   112	1	5	localClassCastException2	ClassCastException
    //   126	1	6	localClassCastException3	ClassCastException
    //   140	1	7	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   52	55	98	java/lang/ClassCastException
    //   61	64	112	java/lang/ClassCastException
    //   74	77	126	java/lang/ClassCastException
    //   83	86	140	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 935	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+928->932, 25:+160->164, 26:+192->196, 27:+224->228, 28:+256->260, 29:+288->292, 30:+320->324, 31:+352->356, 32:+384->388, 33:+416->420, 34:+448->452, 35:+480->484, 36:+512->516, 37:+928->932, 38:+928->932, 39:+928->932, 40:+928->932, 41:+928->932, 42:+928->932, 43:+928->932, 44:+928->932, 45:+928->932, 46:+928->932, 47:+928->932, 48:+928->932, 49:+544->548, 50:+576->580, 51:+608->612, 52:+640->644, 53:+672->676, 54:+704->708, 55:+736->740, 56:+768->772, 57:+800->804, 58:+832->836, 59:+864->868, 60:+896->900
    //   164: aload_2
    //   165: ldc -46
    //   167: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   170: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   173: aload_3
    //   174: ldc -46
    //   176: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   179: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   182: aload 4
    //   184: ldc -46
    //   186: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   189: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   192: invokestatic 1123	kawa/lib/kawa/rotations:makeIntrinsicXyx	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   195: areturn
    //   196: aload_2
    //   197: ldc -46
    //   199: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   202: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   205: aload_3
    //   206: ldc -46
    //   208: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   211: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   214: aload 4
    //   216: ldc -46
    //   218: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   221: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   224: invokestatic 1128	kawa/lib/kawa/rotations:makeIntrinsicXzx	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   227: areturn
    //   228: aload_2
    //   229: ldc -46
    //   231: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   234: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   237: aload_3
    //   238: ldc -46
    //   240: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   243: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   246: aload 4
    //   248: ldc -46
    //   250: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   253: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   256: invokestatic 1133	kawa/lib/kawa/rotations:makeIntrinsicYxy	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   259: areturn
    //   260: aload_2
    //   261: ldc -46
    //   263: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   266: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   269: aload_3
    //   270: ldc -46
    //   272: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   275: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   278: aload 4
    //   280: ldc -46
    //   282: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   285: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   288: invokestatic 1138	kawa/lib/kawa/rotations:makeIntrinsicYzy	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   291: areturn
    //   292: aload_2
    //   293: ldc -46
    //   295: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   298: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   301: aload_3
    //   302: ldc -46
    //   304: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   307: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   310: aload 4
    //   312: ldc -46
    //   314: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   317: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   320: invokestatic 1143	kawa/lib/kawa/rotations:makeIntrinsicZxz	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   323: areturn
    //   324: aload_2
    //   325: ldc -46
    //   327: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   330: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   333: aload_3
    //   334: ldc -46
    //   336: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   339: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   342: aload 4
    //   344: ldc -46
    //   346: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   349: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   352: invokestatic 1148	kawa/lib/kawa/rotations:makeIntrinsicZyz	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   355: areturn
    //   356: aload_2
    //   357: ldc -46
    //   359: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   362: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   365: aload_3
    //   366: ldc -46
    //   368: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   371: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   374: aload 4
    //   376: ldc -46
    //   378: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   381: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   384: invokestatic 1153	kawa/lib/kawa/rotations:makeIntrinsicXyz	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   387: areturn
    //   388: aload_2
    //   389: ldc -46
    //   391: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   394: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   397: aload_3
    //   398: ldc -46
    //   400: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   403: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   406: aload 4
    //   408: ldc -46
    //   410: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   413: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   416: invokestatic 1158	kawa/lib/kawa/rotations:makeIntrinsicXzy	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   419: areturn
    //   420: aload_2
    //   421: ldc -46
    //   423: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   426: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   429: aload_3
    //   430: ldc -46
    //   432: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   435: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   438: aload 4
    //   440: ldc -46
    //   442: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   445: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   448: invokestatic 1163	kawa/lib/kawa/rotations:makeIntrinsicYxz	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   451: areturn
    //   452: aload_2
    //   453: ldc -46
    //   455: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   458: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   461: aload_3
    //   462: ldc -46
    //   464: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   467: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   470: aload 4
    //   472: ldc -46
    //   474: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   477: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   480: invokestatic 1168	kawa/lib/kawa/rotations:makeIntrinsicYzx	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   483: areturn
    //   484: aload_2
    //   485: ldc -46
    //   487: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   490: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   493: aload_3
    //   494: ldc -46
    //   496: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   499: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   502: aload 4
    //   504: ldc -46
    //   506: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   509: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   512: invokestatic 1173	kawa/lib/kawa/rotations:makeIntrinsicZxy	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   515: areturn
    //   516: aload_2
    //   517: ldc -46
    //   519: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   522: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   525: aload_3
    //   526: ldc -46
    //   528: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   531: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   534: aload 4
    //   536: ldc -46
    //   538: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   541: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   544: invokestatic 1178	kawa/lib/kawa/rotations:makeIntrinsicZyx	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   547: areturn
    //   548: aload_2
    //   549: ldc -46
    //   551: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   554: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   557: aload_3
    //   558: ldc -46
    //   560: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   563: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   566: aload 4
    //   568: ldc -46
    //   570: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   573: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   576: invokestatic 1183	kawa/lib/kawa/rotations:makeExtrinsicXyx	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   579: areturn
    //   580: aload_2
    //   581: ldc -46
    //   583: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   586: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   589: aload_3
    //   590: ldc -46
    //   592: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   595: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   598: aload 4
    //   600: ldc -46
    //   602: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   605: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   608: invokestatic 1188	kawa/lib/kawa/rotations:makeExtrinsicXyz	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   611: areturn
    //   612: aload_2
    //   613: ldc -46
    //   615: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   618: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   621: aload_3
    //   622: ldc -46
    //   624: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   627: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   630: aload 4
    //   632: ldc -46
    //   634: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   637: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   640: invokestatic 1193	kawa/lib/kawa/rotations:makeExtrinsicXzx	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   643: areturn
    //   644: aload_2
    //   645: ldc -46
    //   647: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   650: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   653: aload_3
    //   654: ldc -46
    //   656: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   659: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   662: aload 4
    //   664: ldc -46
    //   666: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   669: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   672: invokestatic 1198	kawa/lib/kawa/rotations:makeExtrinsicXzy	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   675: areturn
    //   676: aload_2
    //   677: ldc -46
    //   679: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   682: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   685: aload_3
    //   686: ldc -46
    //   688: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   691: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   694: aload 4
    //   696: ldc -46
    //   698: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   701: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   704: invokestatic 1203	kawa/lib/kawa/rotations:makeExtrinsicYxy	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   707: areturn
    //   708: aload_2
    //   709: ldc -46
    //   711: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   714: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   717: aload_3
    //   718: ldc -46
    //   720: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   723: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   726: aload 4
    //   728: ldc -46
    //   730: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   733: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   736: invokestatic 1208	kawa/lib/kawa/rotations:makeExtrinsicYxz	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   739: areturn
    //   740: aload_2
    //   741: ldc -46
    //   743: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   746: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   749: aload_3
    //   750: ldc -46
    //   752: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   755: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   758: aload 4
    //   760: ldc -46
    //   762: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   765: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   768: invokestatic 1213	kawa/lib/kawa/rotations:makeExtrinsicYzx	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   771: areturn
    //   772: aload_2
    //   773: ldc -46
    //   775: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   778: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   781: aload_3
    //   782: ldc -46
    //   784: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   787: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   790: aload 4
    //   792: ldc -46
    //   794: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   797: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   800: invokestatic 1218	kawa/lib/kawa/rotations:makeExtrinsicYzy	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   803: areturn
    //   804: aload_2
    //   805: ldc -46
    //   807: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   810: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   813: aload_3
    //   814: ldc -46
    //   816: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   819: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   822: aload 4
    //   824: ldc -46
    //   826: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   829: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   832: invokestatic 1223	kawa/lib/kawa/rotations:makeExtrinsicZxy	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   835: areturn
    //   836: aload_2
    //   837: ldc -46
    //   839: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   842: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   845: aload_3
    //   846: ldc -46
    //   848: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   851: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   854: aload 4
    //   856: ldc -46
    //   858: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   861: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   864: invokestatic 1228	kawa/lib/kawa/rotations:makeExtrinsicZxz	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   867: areturn
    //   868: aload_2
    //   869: ldc -46
    //   871: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   874: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   877: aload_3
    //   878: ldc -46
    //   880: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   883: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   886: aload 4
    //   888: ldc -46
    //   890: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   893: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   896: invokestatic 1233	kawa/lib/kawa/rotations:makeExtrinsicZyx	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   899: areturn
    //   900: aload_2
    //   901: ldc -46
    //   903: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   906: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   909: aload_3
    //   910: ldc -46
    //   912: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   915: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   918: aload 4
    //   920: ldc -46
    //   922: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   925: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   928: invokestatic 1238	kawa/lib/kawa/rotations:makeExtrinsicZyz	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   931: areturn
    //   932: aload_0
    //   933: aload_1
    //   934: aload_2
    //   935: aload_3
    //   936: aload 4
    //   938: invokespecial 1241	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   941: areturn
    //   942: new 31	gnu/mapping/WrongType
    //   945: dup_x1
    //   946: swap
    //   947: ldc_w 1119
    //   950: iconst_1
    //   951: aload_2
    //   952: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   955: athrow
    //   956: new 31	gnu/mapping/WrongType
    //   959: dup_x1
    //   960: swap
    //   961: ldc_w 1119
    //   964: iconst_2
    //   965: aload_3
    //   966: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   969: athrow
    //   970: new 31	gnu/mapping/WrongType
    //   973: dup_x1
    //   974: swap
    //   975: ldc_w 1119
    //   978: iconst_3
    //   979: aload 4
    //   981: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   984: athrow
    //   985: new 31	gnu/mapping/WrongType
    //   988: dup_x1
    //   989: swap
    //   990: ldc_w 1125
    //   993: iconst_1
    //   994: aload_2
    //   995: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   998: athrow
    //   999: new 31	gnu/mapping/WrongType
    //   1002: dup_x1
    //   1003: swap
    //   1004: ldc_w 1125
    //   1007: iconst_2
    //   1008: aload_3
    //   1009: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1012: athrow
    //   1013: new 31	gnu/mapping/WrongType
    //   1016: dup_x1
    //   1017: swap
    //   1018: ldc_w 1125
    //   1021: iconst_3
    //   1022: aload 4
    //   1024: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1027: athrow
    //   1028: new 31	gnu/mapping/WrongType
    //   1031: dup_x1
    //   1032: swap
    //   1033: ldc_w 1130
    //   1036: iconst_1
    //   1037: aload_2
    //   1038: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1041: athrow
    //   1042: new 31	gnu/mapping/WrongType
    //   1045: dup_x1
    //   1046: swap
    //   1047: ldc_w 1130
    //   1050: iconst_2
    //   1051: aload_3
    //   1052: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1055: athrow
    //   1056: new 31	gnu/mapping/WrongType
    //   1059: dup_x1
    //   1060: swap
    //   1061: ldc_w 1130
    //   1064: iconst_3
    //   1065: aload 4
    //   1067: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1070: athrow
    //   1071: new 31	gnu/mapping/WrongType
    //   1074: dup_x1
    //   1075: swap
    //   1076: ldc_w 1135
    //   1079: iconst_1
    //   1080: aload_2
    //   1081: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1084: athrow
    //   1085: new 31	gnu/mapping/WrongType
    //   1088: dup_x1
    //   1089: swap
    //   1090: ldc_w 1135
    //   1093: iconst_2
    //   1094: aload_3
    //   1095: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1098: athrow
    //   1099: new 31	gnu/mapping/WrongType
    //   1102: dup_x1
    //   1103: swap
    //   1104: ldc_w 1135
    //   1107: iconst_3
    //   1108: aload 4
    //   1110: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1113: athrow
    //   1114: new 31	gnu/mapping/WrongType
    //   1117: dup_x1
    //   1118: swap
    //   1119: ldc_w 1140
    //   1122: iconst_1
    //   1123: aload_2
    //   1124: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1127: athrow
    //   1128: new 31	gnu/mapping/WrongType
    //   1131: dup_x1
    //   1132: swap
    //   1133: ldc_w 1140
    //   1136: iconst_2
    //   1137: aload_3
    //   1138: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1141: athrow
    //   1142: new 31	gnu/mapping/WrongType
    //   1145: dup_x1
    //   1146: swap
    //   1147: ldc_w 1140
    //   1150: iconst_3
    //   1151: aload 4
    //   1153: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1156: athrow
    //   1157: new 31	gnu/mapping/WrongType
    //   1160: dup_x1
    //   1161: swap
    //   1162: ldc_w 1145
    //   1165: iconst_1
    //   1166: aload_2
    //   1167: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1170: athrow
    //   1171: new 31	gnu/mapping/WrongType
    //   1174: dup_x1
    //   1175: swap
    //   1176: ldc_w 1145
    //   1179: iconst_2
    //   1180: aload_3
    //   1181: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1184: athrow
    //   1185: new 31	gnu/mapping/WrongType
    //   1188: dup_x1
    //   1189: swap
    //   1190: ldc_w 1145
    //   1193: iconst_3
    //   1194: aload 4
    //   1196: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1199: athrow
    //   1200: new 31	gnu/mapping/WrongType
    //   1203: dup_x1
    //   1204: swap
    //   1205: ldc_w 1150
    //   1208: iconst_1
    //   1209: aload_2
    //   1210: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1213: athrow
    //   1214: new 31	gnu/mapping/WrongType
    //   1217: dup_x1
    //   1218: swap
    //   1219: ldc_w 1150
    //   1222: iconst_2
    //   1223: aload_3
    //   1224: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1227: athrow
    //   1228: new 31	gnu/mapping/WrongType
    //   1231: dup_x1
    //   1232: swap
    //   1233: ldc_w 1150
    //   1236: iconst_3
    //   1237: aload 4
    //   1239: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1242: athrow
    //   1243: new 31	gnu/mapping/WrongType
    //   1246: dup_x1
    //   1247: swap
    //   1248: ldc_w 1155
    //   1251: iconst_1
    //   1252: aload_2
    //   1253: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1256: athrow
    //   1257: new 31	gnu/mapping/WrongType
    //   1260: dup_x1
    //   1261: swap
    //   1262: ldc_w 1155
    //   1265: iconst_2
    //   1266: aload_3
    //   1267: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1270: athrow
    //   1271: new 31	gnu/mapping/WrongType
    //   1274: dup_x1
    //   1275: swap
    //   1276: ldc_w 1155
    //   1279: iconst_3
    //   1280: aload 4
    //   1282: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1285: athrow
    //   1286: new 31	gnu/mapping/WrongType
    //   1289: dup_x1
    //   1290: swap
    //   1291: ldc_w 1160
    //   1294: iconst_1
    //   1295: aload_2
    //   1296: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1299: athrow
    //   1300: new 31	gnu/mapping/WrongType
    //   1303: dup_x1
    //   1304: swap
    //   1305: ldc_w 1160
    //   1308: iconst_2
    //   1309: aload_3
    //   1310: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1313: athrow
    //   1314: new 31	gnu/mapping/WrongType
    //   1317: dup_x1
    //   1318: swap
    //   1319: ldc_w 1160
    //   1322: iconst_3
    //   1323: aload 4
    //   1325: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1328: athrow
    //   1329: new 31	gnu/mapping/WrongType
    //   1332: dup_x1
    //   1333: swap
    //   1334: ldc_w 1165
    //   1337: iconst_1
    //   1338: aload_2
    //   1339: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1342: athrow
    //   1343: new 31	gnu/mapping/WrongType
    //   1346: dup_x1
    //   1347: swap
    //   1348: ldc_w 1165
    //   1351: iconst_2
    //   1352: aload_3
    //   1353: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1356: athrow
    //   1357: new 31	gnu/mapping/WrongType
    //   1360: dup_x1
    //   1361: swap
    //   1362: ldc_w 1165
    //   1365: iconst_3
    //   1366: aload 4
    //   1368: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1371: athrow
    //   1372: new 31	gnu/mapping/WrongType
    //   1375: dup_x1
    //   1376: swap
    //   1377: ldc_w 1170
    //   1380: iconst_1
    //   1381: aload_2
    //   1382: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1385: athrow
    //   1386: new 31	gnu/mapping/WrongType
    //   1389: dup_x1
    //   1390: swap
    //   1391: ldc_w 1170
    //   1394: iconst_2
    //   1395: aload_3
    //   1396: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1399: athrow
    //   1400: new 31	gnu/mapping/WrongType
    //   1403: dup_x1
    //   1404: swap
    //   1405: ldc_w 1170
    //   1408: iconst_3
    //   1409: aload 4
    //   1411: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1414: athrow
    //   1415: new 31	gnu/mapping/WrongType
    //   1418: dup_x1
    //   1419: swap
    //   1420: ldc_w 1175
    //   1423: iconst_1
    //   1424: aload_2
    //   1425: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1428: athrow
    //   1429: new 31	gnu/mapping/WrongType
    //   1432: dup_x1
    //   1433: swap
    //   1434: ldc_w 1175
    //   1437: iconst_2
    //   1438: aload_3
    //   1439: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1442: athrow
    //   1443: new 31	gnu/mapping/WrongType
    //   1446: dup_x1
    //   1447: swap
    //   1448: ldc_w 1175
    //   1451: iconst_3
    //   1452: aload 4
    //   1454: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1457: athrow
    //   1458: new 31	gnu/mapping/WrongType
    //   1461: dup_x1
    //   1462: swap
    //   1463: ldc_w 1180
    //   1466: iconst_1
    //   1467: aload_2
    //   1468: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1471: athrow
    //   1472: new 31	gnu/mapping/WrongType
    //   1475: dup_x1
    //   1476: swap
    //   1477: ldc_w 1180
    //   1480: iconst_2
    //   1481: aload_3
    //   1482: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1485: athrow
    //   1486: new 31	gnu/mapping/WrongType
    //   1489: dup_x1
    //   1490: swap
    //   1491: ldc_w 1180
    //   1494: iconst_3
    //   1495: aload 4
    //   1497: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1500: athrow
    //   1501: new 31	gnu/mapping/WrongType
    //   1504: dup_x1
    //   1505: swap
    //   1506: ldc_w 1185
    //   1509: iconst_1
    //   1510: aload_2
    //   1511: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1514: athrow
    //   1515: new 31	gnu/mapping/WrongType
    //   1518: dup_x1
    //   1519: swap
    //   1520: ldc_w 1185
    //   1523: iconst_2
    //   1524: aload_3
    //   1525: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1528: athrow
    //   1529: new 31	gnu/mapping/WrongType
    //   1532: dup_x1
    //   1533: swap
    //   1534: ldc_w 1185
    //   1537: iconst_3
    //   1538: aload 4
    //   1540: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1543: athrow
    //   1544: new 31	gnu/mapping/WrongType
    //   1547: dup_x1
    //   1548: swap
    //   1549: ldc_w 1190
    //   1552: iconst_1
    //   1553: aload_2
    //   1554: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1557: athrow
    //   1558: new 31	gnu/mapping/WrongType
    //   1561: dup_x1
    //   1562: swap
    //   1563: ldc_w 1190
    //   1566: iconst_2
    //   1567: aload_3
    //   1568: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1571: athrow
    //   1572: new 31	gnu/mapping/WrongType
    //   1575: dup_x1
    //   1576: swap
    //   1577: ldc_w 1190
    //   1580: iconst_3
    //   1581: aload 4
    //   1583: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1586: athrow
    //   1587: new 31	gnu/mapping/WrongType
    //   1590: dup_x1
    //   1591: swap
    //   1592: ldc_w 1195
    //   1595: iconst_1
    //   1596: aload_2
    //   1597: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1600: athrow
    //   1601: new 31	gnu/mapping/WrongType
    //   1604: dup_x1
    //   1605: swap
    //   1606: ldc_w 1195
    //   1609: iconst_2
    //   1610: aload_3
    //   1611: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1614: athrow
    //   1615: new 31	gnu/mapping/WrongType
    //   1618: dup_x1
    //   1619: swap
    //   1620: ldc_w 1195
    //   1623: iconst_3
    //   1624: aload 4
    //   1626: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1629: athrow
    //   1630: new 31	gnu/mapping/WrongType
    //   1633: dup_x1
    //   1634: swap
    //   1635: ldc_w 1200
    //   1638: iconst_1
    //   1639: aload_2
    //   1640: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1643: athrow
    //   1644: new 31	gnu/mapping/WrongType
    //   1647: dup_x1
    //   1648: swap
    //   1649: ldc_w 1200
    //   1652: iconst_2
    //   1653: aload_3
    //   1654: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1657: athrow
    //   1658: new 31	gnu/mapping/WrongType
    //   1661: dup_x1
    //   1662: swap
    //   1663: ldc_w 1200
    //   1666: iconst_3
    //   1667: aload 4
    //   1669: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1672: athrow
    //   1673: new 31	gnu/mapping/WrongType
    //   1676: dup_x1
    //   1677: swap
    //   1678: ldc_w 1205
    //   1681: iconst_1
    //   1682: aload_2
    //   1683: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1686: athrow
    //   1687: new 31	gnu/mapping/WrongType
    //   1690: dup_x1
    //   1691: swap
    //   1692: ldc_w 1205
    //   1695: iconst_2
    //   1696: aload_3
    //   1697: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1700: athrow
    //   1701: new 31	gnu/mapping/WrongType
    //   1704: dup_x1
    //   1705: swap
    //   1706: ldc_w 1205
    //   1709: iconst_3
    //   1710: aload 4
    //   1712: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1715: athrow
    //   1716: new 31	gnu/mapping/WrongType
    //   1719: dup_x1
    //   1720: swap
    //   1721: ldc_w 1210
    //   1724: iconst_1
    //   1725: aload_2
    //   1726: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1729: athrow
    //   1730: new 31	gnu/mapping/WrongType
    //   1733: dup_x1
    //   1734: swap
    //   1735: ldc_w 1210
    //   1738: iconst_2
    //   1739: aload_3
    //   1740: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1743: athrow
    //   1744: new 31	gnu/mapping/WrongType
    //   1747: dup_x1
    //   1748: swap
    //   1749: ldc_w 1210
    //   1752: iconst_3
    //   1753: aload 4
    //   1755: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1758: athrow
    //   1759: new 31	gnu/mapping/WrongType
    //   1762: dup_x1
    //   1763: swap
    //   1764: ldc_w 1215
    //   1767: iconst_1
    //   1768: aload_2
    //   1769: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1772: athrow
    //   1773: new 31	gnu/mapping/WrongType
    //   1776: dup_x1
    //   1777: swap
    //   1778: ldc_w 1215
    //   1781: iconst_2
    //   1782: aload_3
    //   1783: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1786: athrow
    //   1787: new 31	gnu/mapping/WrongType
    //   1790: dup_x1
    //   1791: swap
    //   1792: ldc_w 1215
    //   1795: iconst_3
    //   1796: aload 4
    //   1798: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1801: athrow
    //   1802: new 31	gnu/mapping/WrongType
    //   1805: dup_x1
    //   1806: swap
    //   1807: ldc_w 1220
    //   1810: iconst_1
    //   1811: aload_2
    //   1812: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1815: athrow
    //   1816: new 31	gnu/mapping/WrongType
    //   1819: dup_x1
    //   1820: swap
    //   1821: ldc_w 1220
    //   1824: iconst_2
    //   1825: aload_3
    //   1826: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1829: athrow
    //   1830: new 31	gnu/mapping/WrongType
    //   1833: dup_x1
    //   1834: swap
    //   1835: ldc_w 1220
    //   1838: iconst_3
    //   1839: aload 4
    //   1841: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1844: athrow
    //   1845: new 31	gnu/mapping/WrongType
    //   1848: dup_x1
    //   1849: swap
    //   1850: ldc_w 1225
    //   1853: iconst_1
    //   1854: aload_2
    //   1855: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1858: athrow
    //   1859: new 31	gnu/mapping/WrongType
    //   1862: dup_x1
    //   1863: swap
    //   1864: ldc_w 1225
    //   1867: iconst_2
    //   1868: aload_3
    //   1869: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1872: athrow
    //   1873: new 31	gnu/mapping/WrongType
    //   1876: dup_x1
    //   1877: swap
    //   1878: ldc_w 1225
    //   1881: iconst_3
    //   1882: aload 4
    //   1884: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1887: athrow
    //   1888: new 31	gnu/mapping/WrongType
    //   1891: dup_x1
    //   1892: swap
    //   1893: ldc_w 1230
    //   1896: iconst_1
    //   1897: aload_2
    //   1898: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1901: athrow
    //   1902: new 31	gnu/mapping/WrongType
    //   1905: dup_x1
    //   1906: swap
    //   1907: ldc_w 1230
    //   1910: iconst_2
    //   1911: aload_3
    //   1912: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1915: athrow
    //   1916: new 31	gnu/mapping/WrongType
    //   1919: dup_x1
    //   1920: swap
    //   1921: ldc_w 1230
    //   1924: iconst_3
    //   1925: aload 4
    //   1927: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1930: athrow
    //   1931: new 31	gnu/mapping/WrongType
    //   1934: dup_x1
    //   1935: swap
    //   1936: ldc_w 1235
    //   1939: iconst_1
    //   1940: aload_2
    //   1941: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1944: athrow
    //   1945: new 31	gnu/mapping/WrongType
    //   1948: dup_x1
    //   1949: swap
    //   1950: ldc_w 1235
    //   1953: iconst_2
    //   1954: aload_3
    //   1955: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1958: athrow
    //   1959: new 31	gnu/mapping/WrongType
    //   1962: dup_x1
    //   1963: swap
    //   1964: ldc_w 1235
    //   1967: iconst_3
    //   1968: aload 4
    //   1970: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1973: athrow
    // Line number table:
    //   Java source line #573	-> byte code offset #956
    //   Java source line #672	-> byte code offset #1472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1974	0	this	rotations
    //   0	1974	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	1974	2	paramObject1	Object
    //   0	1974	3	paramObject2	Object
    //   0	1974	4	paramObject3	Object
    //   942	1	5	localClassCastException1	ClassCastException
    //   956	1	6	localClassCastException2	ClassCastException
    //   970	1	7	localClassCastException3	ClassCastException
    //   985	1	8	localClassCastException4	ClassCastException
    //   999	1	9	localClassCastException5	ClassCastException
    //   1013	1	10	localClassCastException6	ClassCastException
    //   1028	1	11	localClassCastException7	ClassCastException
    //   1042	1	12	localClassCastException8	ClassCastException
    //   1056	1	13	localClassCastException9	ClassCastException
    //   1071	1	14	localClassCastException10	ClassCastException
    //   1085	1	15	localClassCastException11	ClassCastException
    //   1099	1	16	localClassCastException12	ClassCastException
    //   1114	1	17	localClassCastException13	ClassCastException
    //   1128	1	18	localClassCastException14	ClassCastException
    //   1142	1	19	localClassCastException15	ClassCastException
    //   1157	1	20	localClassCastException16	ClassCastException
    //   1171	1	21	localClassCastException17	ClassCastException
    //   1185	1	22	localClassCastException18	ClassCastException
    //   1200	1	23	localClassCastException19	ClassCastException
    //   1214	1	24	localClassCastException20	ClassCastException
    //   1228	1	25	localClassCastException21	ClassCastException
    //   1243	1	26	localClassCastException22	ClassCastException
    //   1257	1	27	localClassCastException23	ClassCastException
    //   1271	1	28	localClassCastException24	ClassCastException
    //   1286	1	29	localClassCastException25	ClassCastException
    //   1300	1	30	localClassCastException26	ClassCastException
    //   1314	1	31	localClassCastException27	ClassCastException
    //   1329	1	32	localClassCastException28	ClassCastException
    //   1343	1	33	localClassCastException29	ClassCastException
    //   1357	1	34	localClassCastException30	ClassCastException
    //   1372	1	35	localClassCastException31	ClassCastException
    //   1386	1	36	localClassCastException32	ClassCastException
    //   1400	1	37	localClassCastException33	ClassCastException
    //   1415	1	38	localClassCastException34	ClassCastException
    //   1429	1	39	localClassCastException35	ClassCastException
    //   1443	1	40	localClassCastException36	ClassCastException
    //   1458	1	41	localClassCastException37	ClassCastException
    //   1472	1	42	localClassCastException38	ClassCastException
    //   1486	1	43	localClassCastException39	ClassCastException
    //   1501	1	44	localClassCastException40	ClassCastException
    //   1515	1	45	localClassCastException41	ClassCastException
    //   1529	1	46	localClassCastException42	ClassCastException
    //   1544	1	47	localClassCastException43	ClassCastException
    //   1558	1	48	localClassCastException44	ClassCastException
    //   1572	1	49	localClassCastException45	ClassCastException
    //   1587	1	50	localClassCastException46	ClassCastException
    //   1601	1	51	localClassCastException47	ClassCastException
    //   1615	1	52	localClassCastException48	ClassCastException
    //   1630	1	53	localClassCastException49	ClassCastException
    //   1644	1	54	localClassCastException50	ClassCastException
    //   1658	1	55	localClassCastException51	ClassCastException
    //   1673	1	56	localClassCastException52	ClassCastException
    //   1687	1	57	localClassCastException53	ClassCastException
    //   1701	1	58	localClassCastException54	ClassCastException
    //   1716	1	59	localClassCastException55	ClassCastException
    //   1730	1	60	localClassCastException56	ClassCastException
    //   1744	1	61	localClassCastException57	ClassCastException
    //   1759	1	62	localClassCastException58	ClassCastException
    //   1773	1	63	localClassCastException59	ClassCastException
    //   1787	1	64	localClassCastException60	ClassCastException
    //   1802	1	65	localClassCastException61	ClassCastException
    //   1816	1	66	localClassCastException62	ClassCastException
    //   1830	1	67	localClassCastException63	ClassCastException
    //   1845	1	68	localClassCastException64	ClassCastException
    //   1859	1	69	localClassCastException65	ClassCastException
    //   1873	1	70	localClassCastException66	ClassCastException
    //   1888	1	71	localClassCastException67	ClassCastException
    //   1902	1	72	localClassCastException68	ClassCastException
    //   1916	1	73	localClassCastException69	ClassCastException
    //   1931	1	74	localClassCastException70	ClassCastException
    //   1945	1	75	localClassCastException71	ClassCastException
    //   1959	1	76	localClassCastException72	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   170	173	942	java/lang/ClassCastException
    //   179	182	956	java/lang/ClassCastException
    //   189	192	970	java/lang/ClassCastException
    //   202	205	985	java/lang/ClassCastException
    //   211	214	999	java/lang/ClassCastException
    //   221	224	1013	java/lang/ClassCastException
    //   234	237	1028	java/lang/ClassCastException
    //   243	246	1042	java/lang/ClassCastException
    //   253	256	1056	java/lang/ClassCastException
    //   266	269	1071	java/lang/ClassCastException
    //   275	278	1085	java/lang/ClassCastException
    //   285	288	1099	java/lang/ClassCastException
    //   298	301	1114	java/lang/ClassCastException
    //   307	310	1128	java/lang/ClassCastException
    //   317	320	1142	java/lang/ClassCastException
    //   330	333	1157	java/lang/ClassCastException
    //   339	342	1171	java/lang/ClassCastException
    //   349	352	1185	java/lang/ClassCastException
    //   362	365	1200	java/lang/ClassCastException
    //   371	374	1214	java/lang/ClassCastException
    //   381	384	1228	java/lang/ClassCastException
    //   394	397	1243	java/lang/ClassCastException
    //   403	406	1257	java/lang/ClassCastException
    //   413	416	1271	java/lang/ClassCastException
    //   426	429	1286	java/lang/ClassCastException
    //   435	438	1300	java/lang/ClassCastException
    //   445	448	1314	java/lang/ClassCastException
    //   458	461	1329	java/lang/ClassCastException
    //   467	470	1343	java/lang/ClassCastException
    //   477	480	1357	java/lang/ClassCastException
    //   490	493	1372	java/lang/ClassCastException
    //   499	502	1386	java/lang/ClassCastException
    //   509	512	1400	java/lang/ClassCastException
    //   522	525	1415	java/lang/ClassCastException
    //   531	534	1429	java/lang/ClassCastException
    //   541	544	1443	java/lang/ClassCastException
    //   554	557	1458	java/lang/ClassCastException
    //   563	566	1472	java/lang/ClassCastException
    //   573	576	1486	java/lang/ClassCastException
    //   586	589	1501	java/lang/ClassCastException
    //   595	598	1515	java/lang/ClassCastException
    //   605	608	1529	java/lang/ClassCastException
    //   618	621	1544	java/lang/ClassCastException
    //   627	630	1558	java/lang/ClassCastException
    //   637	640	1572	java/lang/ClassCastException
    //   650	653	1587	java/lang/ClassCastException
    //   659	662	1601	java/lang/ClassCastException
    //   669	672	1615	java/lang/ClassCastException
    //   682	685	1630	java/lang/ClassCastException
    //   691	694	1644	java/lang/ClassCastException
    //   701	704	1658	java/lang/ClassCastException
    //   714	717	1673	java/lang/ClassCastException
    //   723	726	1687	java/lang/ClassCastException
    //   733	736	1701	java/lang/ClassCastException
    //   746	749	1716	java/lang/ClassCastException
    //   755	758	1730	java/lang/ClassCastException
    //   765	768	1744	java/lang/ClassCastException
    //   778	781	1759	java/lang/ClassCastException
    //   787	790	1773	java/lang/ClassCastException
    //   797	800	1787	java/lang/ClassCastException
    //   810	813	1802	java/lang/ClassCastException
    //   819	822	1816	java/lang/ClassCastException
    //   829	832	1830	java/lang/ClassCastException
    //   842	845	1845	java/lang/ClassCastException
    //   851	854	1859	java/lang/ClassCastException
    //   861	864	1873	java/lang/ClassCastException
    //   874	877	1888	java/lang/ClassCastException
    //   883	886	1902	java/lang/ClassCastException
    //   893	896	1916	java/lang/ClassCastException
    //   906	909	1931	java/lang/ClassCastException
    //   915	918	1945	java/lang/ClassCastException
    //   925	928	1959	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 935	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 9
    //   6: if_icmpne +48 -> 54
    //   9: goto +3 -> 12
    //   12: aload_2
    //   13: ldc -46
    //   15: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   21: aload_3
    //   22: ldc -46
    //   24: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   27: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   30: aload 4
    //   32: ldc -46
    //   34: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   37: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   40: aload 5
    //   42: ldc -46
    //   44: invokestatic 154	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   47: invokestatic 216	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   50: invokestatic 1244	kawa/lib/kawa/rotations:makeAxis$SlAngle	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   53: areturn
    //   54: aload_0
    //   55: aload_1
    //   56: aload_2
    //   57: aload_3
    //   58: aload 4
    //   60: aload 5
    //   62: invokespecial 1247	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: areturn
    //   66: new 31	gnu/mapping/WrongType
    //   69: dup_x1
    //   70: swap
    //   71: ldc_w 498
    //   74: iconst_1
    //   75: aload_2
    //   76: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   79: athrow
    //   80: new 31	gnu/mapping/WrongType
    //   83: dup_x1
    //   84: swap
    //   85: ldc_w 498
    //   88: iconst_2
    //   89: aload_3
    //   90: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   93: athrow
    //   94: new 31	gnu/mapping/WrongType
    //   97: dup_x1
    //   98: swap
    //   99: ldc_w 498
    //   102: iconst_3
    //   103: aload 4
    //   105: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   108: athrow
    //   109: new 31	gnu/mapping/WrongType
    //   112: dup_x1
    //   113: swap
    //   114: ldc_w 498
    //   117: iconst_4
    //   118: aload 5
    //   120: invokespecial 37	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   123: athrow
    // Line number table:
    //   Java source line #211	-> byte code offset #12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	rotations
    //   0	124	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	124	2	paramObject1	Object
    //   0	124	3	paramObject2	Object
    //   0	124	4	paramObject3	Object
    //   0	124	5	paramObject4	Object
    //   66	1	6	localClassCastException1	ClassCastException
    //   80	1	7	localClassCastException2	ClassCastException
    //   94	1	8	localClassCastException3	ClassCastException
    //   109	1	9	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   18	21	66	java/lang/ClassCastException
    //   27	30	80	java/lang/ClassCastException
    //   37	40	94	java/lang/ClassCastException
    //   47	50	109	java/lang/ClassCastException
  }
}
