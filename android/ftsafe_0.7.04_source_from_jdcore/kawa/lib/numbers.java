package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispReader;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.BitOps;
import gnu.math.CComplex;
import gnu.math.Complex;
import gnu.math.DFloNum;
import gnu.math.Duration;
import gnu.math.IntFraction;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.Quantity;
import gnu.math.Quaternion;
import gnu.math.RatNum;
import gnu.math.RealNum;
import gnu.math.Unit;
import java.math.BigDecimal;
import java.math.BigInteger;

public class numbers
  extends ModuleBody
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
  
  private static void $runBody$()
  {
    ;
    Consumer $result = getInstanceconsumer;
  }
  
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
  
  static boolean isJava$DtLang$DtReal(Object x)
  {
    boolean x = x instanceof Long;
    boolean x = x instanceof Integer;
    boolean x = x instanceof Short;
    boolean x = x instanceof Byte;
    boolean x = x instanceof Double;
    boolean x = x instanceof Float;
    boolean x = x instanceof BigInteger;
    return (x instanceof Number) ? x instanceof BigDecimal : x ? x : x ? x : x ? x : x ? x : x ? x : x ? x : x ? x : false;
  }
  
  public static final ModuleMethod zero$Qu;
  
  public static boolean isNumber(Object x)
  {
    return x instanceof Number;
  }
  
  public static final ModuleMethod positive$Qu;
  public static final ModuleMethod negative$Qu;
  
  public static boolean isQuantity(Object x)
  {
    boolean x = x instanceof Quantity;
    return x ? x : isJava$DtLang$DtReal(x);
  }
  
  public static final ModuleMethod finite$Qu;
  
  public static boolean isQuaternion(Object x)
  {
    boolean x = x instanceof Quaternion;
    return x ? x : isJava$DtLang$DtReal(x);
  }
  
  public static final ModuleMethod infinite$Qu;
  public static boolean isComplex(Object x)
  {
    boolean x = x instanceof Complex;
    return x ? x : isJava$DtLang$DtReal(x);
  }
  
  public static boolean isReal(Object x)
  {
    boolean x = RealNum.asRealNumOrNull(x) != null;
    return x ? x : isJava$DtLang$DtReal(x);
  }
  public static final ModuleMethod nan$Qu;
  public static final ModuleMethod max;
  
  public static boolean isRational(Object x)
  {
    boolean x = RatNum.asRatNumOrNull(x) != null;
    
    boolean x = x instanceof Long;
    boolean x = x instanceof Integer;
    boolean x = x instanceof Short;
    boolean x = x instanceof Byte;
    boolean x = x instanceof BigInteger;
    return (x instanceof Number) ? x instanceof BigDecimal : x ? x : x ? x : x ? x : x ? x : x ? x : x ? x : false;
  }
  
  public static final ModuleMethod min;
  public static final ModuleMethod abs;
  
  public static boolean isInteger(Object x)
  {
    boolean x = x instanceof IntNum;
    label101: boolean x; if ((x instanceof Number)) {
      boolean x = x instanceof Long; boolean x; if (x) { if (!x) break label101;
      } else { boolean x = x instanceof Integer;
        if (x) { if (!x)
            break label101;
        } else { boolean x = x instanceof Short;
          if (x) if (!x) {
              break label101;
            } else
            x = x instanceof Byte;
        }
      }
      boolean x = x instanceof DFloNum; if (x) { if (!x) break label175;
      } else { x = x instanceof Float;
        if (x ? !x : 
        
          !(x instanceof Double)) break label175;
      } }
    try { tmpTernaryOp = false;
      
      break label216;
      try
      {
        label175:
        ((BigDecimal)Promise.force(x, BigDecimal.class)).toBigIntegerExact(); ArithmeticException ex; x = true; } catch (ArithmeticException localArithmeticException1) { x = false; } tmpTernaryOp = false; label216: return Math.IEEEremainder(((Number)(x = Promise.force(x, Number.class))).doubleValue(), 1.0D) == 0.0D;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(
      




        localClassCastException, "java.lang.Number.doubleValue()", 1, x);
    }
  }
  
  public static final ModuleMethod floor$Sl;
  public static final ModuleMethod truncate$Sl;
  public static final ModuleMethod div$Mnand$Mnmod;
  public static final ModuleMethod div0$Mnand$Mnmod0;
  
  public static boolean isExactInteger(Object x)
  {
    boolean x = x instanceof IntNum;
    
    boolean x = x instanceof Long;
    boolean x = x instanceof Integer;
    boolean x = x instanceof Short;
    boolean x = x instanceof Byte;
    return (x instanceof Number) ? x instanceof BigInteger : x ? x : x ? x : x ? x : x ? x : x ? x : false;
  }
  
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
  
  public static boolean isExact(Object x)
  {
    return (x instanceof Number) ? Arithmetic.isExact((Number)Promise.force(x, Number.class)) : false;
  }
  
  public static final GenericProc atanh;
  public static final ModuleMethod sqrt;
  
  public static boolean isInexact(Object x)
  {
    return !Arithmetic.isExact((Number)Promise.force(x, Number.class));
  }
  
  public static final ModuleMethod square;
  public static final GenericProc make$Mnrectangular;
  public static final GenericProc make$Mnpolar;
  public static final ModuleMethod real$Mnpart;
  public static final ModuleMethod imag$Mnpart;
  public static final ModuleMethod jmag$Mnpart;
  public static final ModuleMethod kmag$Mnpart;
  public static final ModuleMethod unit$Mnvector;
  
  public static boolean isZero(Number x)
  {
    return x.doubleValue() == 0.0D ? true : (x instanceof BigDecimal) ? NumberCompare.$Eq(Lit0, GetNamedPart.getNamedPart.apply2((BigDecimal)x, Lit1)) : (x instanceof BigInteger) ? NumberCompare.$Eq(Lit0, GetNamedPart.getNamedPart.apply2((BigInteger)x, Lit1)) : (x instanceof Numeric) ? ((Numeric)x).isZero() : false;
  }
  
  public static final ModuleMethod magnitude;
  
  public static boolean isPositive(RealNum x)
  {
    return x.sign() > 0; }
  
  public static final ModuleMethod angle; public static final ModuleMethod inexact;
  public static boolean isNegative(RealNum x) { return x.isNegative(); }
  
  public static final ModuleMethod exact;
  public static final ModuleMethod exact$Mn$Grinexact;
  public static final ModuleMethod inexact$Mn$Grexact;
  public static final ModuleMethod logop;
  public static final ModuleMethod bitwise$Mnbit$Mnset$Qu; public static boolean isFinite(Number z) { double d = z.doubleValue();
    
    return ((Quaternion)z).classifyFinite() > 0;
  }
  
  public static boolean isInfinite(Number z) { if ((z instanceof Quaternion))
      Number localNumber = z; try { Quaternion zc = (Quaternion)z;
      x = zc.re().classifyFinite() == 0;
      boolean x = zc.im().classifyFinite() == 0;
      boolean x = zc.jm().classifyFinite() == 0;
      tmpTernaryOp = false;
      break label127;
      double d = z.doubleValue();
      label127: return isJava$DtLang$DtReal(z) ? Double.isInfinite(d) : zc.km().classifyFinite() == 0 ? true : x ? x : x ? x : x ? x : false;
    }
    catch (ClassCastException localClassCastException)
    {
      boolean x;
      throw new WrongType(
      





        localClassCastException, "zc", -2, x);
    }
  }
  
  public static boolean isNan(Number z)
  {
    double d = z.doubleValue();
    return ((Quaternion)z).classifyFinite() < 0;
  }
  

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
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (selector) {case 28:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 27: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 21: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 20: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); }
  public static Object max(Object... args) { int i = args.length;
    for (;;) { Object localObject2; try { Object localObject1; result = LangObjType.coerceRealNum(localObject1 = Promise.force(args[0], RealNum.class));
        int n; i = 1; if (i >= n) {}
      }
      catch (ClassCastException localClassCastException1)
      {
        RealNum result;
        int i;
        throw new WrongType(
        
          localClassCastException1, "result", -2, i);
      }
      try { result = result.max(LangObjType.coerceRealNum(localObject2 = Promise.force(args[i], RealNum.class)));i++; } catch (ClassCastException localClassCastException2) { throw new WrongType(localClassCastException2, "gnu.math.RealNum.max(real)", 2, localObject2);
      }
    }
    return result;
  }
  
  public static Object min(Object... args)
  {
    int i = args.length;
    for (;;) { Object localObject2; try { Object localObject1; result = LangObjType.coerceRealNum(localObject1 = Promise.force(args[0], RealNum.class));
        int n; i = 0; if (i >= n) {}
      }
      catch (ClassCastException localClassCastException1)
      {
        RealNum result;
        int i;
        throw new WrongType(
        
          localClassCastException1, "result", -2, i);
      }
      try { result = result.min(LangObjType.coerceRealNum(localObject2 = Promise.force(args[i], RealNum.class)));i++; } catch (ClassCastException localClassCastException2) { throw new WrongType(localClassCastException2, "gnu.math.RealNum.min(real)", 2, localObject2);
      }
    }
    return result;
  }
  







  public static Number abs(Number x) { return NumberCompare.$Gr$Eq(x, Lit0) ? x : (x instanceof Numeric) ? ((Numeric)x).abs() : (Number)Promise.force(AddOp.$Mn.apply1(x), Number.class); }
  
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
  public static RealNum gcd(RealNum... args) { int i = args.length;int j = 0;
    
    IntNum result = Lit0;
    boolean result$Mninexact; int n; int i = 0;
    for (;; 
        



        )
    {
      RealNum val;
      if (i < n)
      {

        val = args[i];
        boolean cur$Mninexact = isInexact(val);
        
        if (cur$Mninexact)
          result$Mninexact = true; }
      try { tmpTernaryOp = LangObjType.coerceIntNum(localObject = exact(val)); } catch (ClassCastException localClassCastException1) { IntNum cur; throw new WrongType(localClassCastException1, "cur", -2, localObject);
      }
    }
    return result$Mninexact ? LangObjType.coerceRealNum(inexact(result)) : result;
  }
  







  public static RealNum lcm(RealNum... args)
  {
    int i = args.length;int j = 0;
    
    IntNum result = Lit2;
    boolean result$Mninexact; int n; int i = 0;
    for (;; 
        



        )
    {
      RealNum val;
      if (i < n)
      {

        val = args[i];
        boolean cur$Mninexact = isInexact(val);
        
        if (cur$Mninexact)
          result$Mninexact = true; }
      try { tmpTernaryOp = LangObjType.coerceIntNum(localObject = exact(val)); } catch (ClassCastException localClassCastException1) { IntNum cur; throw new WrongType(localClassCastException1, "cur", -2, localObject);
      }
    }
    return result$Mninexact ? LangObjType.coerceRealNum(inexact(result)) : result; }
  
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
  
  public static RealNum numerator(RealNum x) { return (x instanceof RatNum) ? ((RatNum)x).numerator() : LangObjType.coerceRealNum(inexact(LangObjType.coerceRatNum(exact(x)).numerator())); }
  

  public static RealNum denominator(RealNum x)
  {
    return (x instanceof RatNum) ? ((RatNum)x).denominator() : LangObjType.coerceRealNum(inexact(LangObjType.coerceRatNum(exact(x)).denominator()));
  }
  
  public static RealNum floor(RealNum x) { return x.toInt(Numeric.FLOOR); }
  
  public static RealNum ceiling(RealNum x) {
    return x.toInt(Numeric.CEILING);
  }
  
  public static RealNum truncate(RealNum x) { return x.toInt(Numeric.TRUNCATE); }
  

  public static RealNum round(RealNum x) { return x.toInt(Numeric.ROUND); }
  static final SimpleSymbol Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final SimpleSymbol Lit70; static final SimpleSymbol Lit71; static final SimpleSymbol Lit72;
  public static RealNum rationalize(RealNum x, RealNum y) { return RatNum.rationalize(LangObjType.coerceRealNum(x.sub(y)), LangObjType.coerceRealNum(x.add(y))); }
  
  static final SimpleSymbol Lit73;
  static final SimpleSymbol Lit74;
  static final SimpleSymbol Lit75;
  static final SimpleSymbol Lit76;
  static final SimpleSymbol Lit77;
  static final SimpleSymbol Lit78 = Symbol.valueOf("exact-integer-sqrt");
  



  public static Number lambda2(Number x)
  {
    Number localNumber;
    


    if (isJava$DtLang$DtReal(x)) localNumber = x; try { tmpTernaryOp = Double.valueOf(Math.log(x.doubleValue()));
      
      return (x instanceof Quaternion) ? ((Quaternion)x).log() : (Number)Promise.force(Values.empty, Number.class);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(
      
        localClassCastException, "java.lang.Math.log(double)", 1, localNumber);
    }
  }
  
  public static Quaternion lambda3(Quaternion q) { return q.sin(); }
  
  public static double lambda4(double x) { return Math.sin(x); }
  


  public static Quaternion lambda5(Quaternion q) { return q.cos(); }
  
  public static double lambda6(double x) { return Math.cos(x); }
  


  public static Quaternion lambda7(Quaternion q) { return q.tan(); }
  
  public static double lambda8(double x) { return Math.tan(x); }
  
  public static Number asin(Number x) {
    if (isJava$DtLang$DtReal(x))
      Number localNumber = x; try { tmpTernaryOp = Double.valueOf(Math.asin(x.doubleValue()));
    }
    catch (ClassCastException localClassCastException2) {
      try {
        Numeric localNumeric;
        q = (Quaternion)(localNumeric = Arithmetic.asNumeric(x));
        u = unitVector(q);
        v = NumberCompare.$Eq(Lit0, u) ? Lit4 : u;
      }
      catch (ClassCastException localClassCastException2)
      {
        Quaternion q;
        Quaternion u;
        Quaternion v;
        throw new WrongType(localClassCastException2, "q", -2, u);
      }
      try {
        return (Number)Promise.force(AddOp.$Mn.apply1(MultiplyOp.$St.apply2(v, log.apply1(AddOp.apply2(1, MultiplyOp.$St.apply2(v, q), sqrt((Number)(localObject = Promise.force(AddOp.apply2(-1, Lit2, MultiplyOp.$St.apply2(q, q)), Number.class))))))), Number.class); } catch (ClassCastException localClassCastException3) { throw new WrongType(localClassCastException3, "sqrt", 0, localObject);
      }
      throw new WrongType(
      






        localClassCastException1, "java.lang.Math.asin(double)", 1, q);
    }
    if ((isRealValued(x)) && (NumberCompare.$Ls$Eq$V(Lit3, x, Lit2, new Object[0]))) {
      tmpTernaryOp = new DFloNum(Math.asin(;
    }
  }
  



  public static Number acos(Number x)
  {
    if (isJava$DtLang$DtReal(x))
      Number localNumber = x; try { tmpTernaryOp = Double.valueOf(Math.acos(x.doubleValue()));
    }
    catch (ClassCastException localClassCastException2) {
      try {
        Numeric localNumeric;
        q = (Quaternion)(localNumeric = Arithmetic.asNumeric(x));
        u = unitVector(q);
        v = NumberCompare.$Eq(Lit0, u) ? Lit4 : u;
      }
      catch (ClassCastException localClassCastException2)
      {
        Quaternion q;
        Quaternion u;
        Quaternion v;
        throw new WrongType(localClassCastException2, "q", -2, u);
      }
      try {
        return (Number)Promise.force(AddOp.$Mn.apply1(MultiplyOp.$St.apply2(v, log.apply1(AddOp.apply2(1, q, sqrt((Number)(localObject = Promise.force(AddOp.apply2(-1, MultiplyOp.$St.apply2(q, q), Lit2), Number.class))))))), Number.class); } catch (ClassCastException localClassCastException3) { throw new WrongType(localClassCastException3, "sqrt", 0, localObject);
      }
      throw new WrongType(
      






        localClassCastException1, "java.lang.Math.acos(double)", 1, q);
    }
    if ((isRealValued(x)) && (NumberCompare.$Ls$Eq$V(Lit3, x, Lit2, new Object[0]))) {
      tmpTernaryOp = new DFloNum(Math.acos(;
    }
  }
  




















  public static Number lambda10(Number x)
  {
    Number localNumber = x; try { Quaternion q = (Quaternion)x;
      u = unitVector(q);
      Quaternion v = NumberCompare.$Eq(Lit0, u) ? Lit4 : u;
      return isJava$DtLang$DtReal(x) ? Double.valueOf(Math.atan(x.doubleValue())) : (x instanceof RealNum) ? new DFloNum(Math.atan(x.doubleValue())) : (Number)Promise.force(MultiplyOp.$St.apply2(MultiplyOp.$St.apply2(Lit44, v), log.apply1(MultiplyOp.$St.apply2(AddOp.apply2(1, v, q), DivideOp.$Sl.apply2(Lit2, AddOp.apply2(-1, v, q))))), Number.class);
    }
    catch (ClassCastException localClassCastException)
    {
      Quaternion u;
      throw new WrongType(
      

        localClassCastException, "q", -2, u);
    }
  }
  



  public static Quaternion lambda12(Quaternion q)
  {
    try
    {
      return (Quaternion)Promise.force(DivideOp.$Sl.apply2(AddOp.apply2(-1, exp(q), exp((Number)(localObject = Promise.force(AddOp.$Mn.apply1(q), Number.class)))), Lit45), Quaternion.class); } catch (ClassCastException localClassCastException) { Object localObject; throw new WrongType(localClassCastException, "exp", 0, localObject);
    } }
  
  public static double lambda13(double x) { return Math.sinh(x); }
  





  public static Quaternion lambda15(Quaternion q)
  {
    try
    {
      return (Quaternion)Promise.force(DivideOp.$Sl.apply2(AddOp.apply2(1, exp(q), exp((Number)(localObject = Promise.force(AddOp.$Mn.apply1(q), Number.class)))), Lit45), Quaternion.class); } catch (ClassCastException localClassCastException) { Object localObject; throw new WrongType(localClassCastException, "exp", 0, localObject);
    } }
  
  public static double lambda16(double x) { return Math.cosh(x); }
  














  public static double lambda19(double x)
  {
    return Math.tanh(x);
  }
  
  public static Quaternion lambda20(Quaternion q) {
    try {
      return (Quaternion)Promise.force(log.apply1(AddOp.apply2(1, q, sqrt((Number)(localObject = Promise.force(AddOp.apply2(1, MultiplyOp.$St.apply2(q, q), Lit2), Number.class))))), Quaternion.class); } catch (ClassCastException localClassCastException) { Object localObject; throw new WrongType(localClassCastException, "sqrt", 0, localObject);
    } }
  
  public static double lambda21(double x) { return Math.log(x + Math.sqrt(x * x + 1.0D)); }
  




  public static double lambda23(double x)
  {
    return Math.log(x + Math.sqrt(x * x - 1.0D));
  }
  
  public static Quaternion lambda24(Quaternion q)
  {
    return (Quaternion)Promise.force(DivideOp.$Sl.apply2(AddOp.apply2(-1, log.apply1(AddOp.apply2(1, Lit2, q)), log.apply1(AddOp.apply2(-1, Lit2, q))), Lit45), Quaternion.class);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return isNumber(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    case 2:  return isQuantity(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    
    case 3: 
      return isQuaternion(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    
    case 4: 
      return isComplex(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    
    case 5: 
      return isReal(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    
    case 6: 
      return isRational(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    







    case 7: 
      return isInteger(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    






















    case 8: 
      return isExactInteger(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    






    case 9: 
      return isRealValued(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    



    case 10: 
      return isRationalValued(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    



    case 11: 
      return isIntegerValued(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    




    case 12: 
      return isExact(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    

    case 13: 
      return isInexact(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    }
    for (;;) {
      try {
        return isZero((Number)Promise.force(paramObject, Number.class)) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException1) { throw new WrongType(
        








































































































































































































































































































          localClassCastException1, "zero?", 1, paramObject);
      }
      try
      {
        return isPositive(LangObjType.coerceRealNum(Promise.force(paramObject, RealNum.class))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException2) { throw new WrongType(localClassCastException2, "positive?", 1, paramObject);
      }
      try {
        return isNegative(LangObjType.coerceRealNum(Promise.force(paramObject, RealNum.class))) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException3) { throw new WrongType(localClassCastException3, "negative?", 1, paramObject);
      }
      try {
        return isFinite((Number)Promise.force(paramObject, Number.class)) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException4) { throw new WrongType(localClassCastException4, "finite?", 1, paramObject);
      }
      



      try
      {
        return isInfinite((Number)Promise.force(paramObject, Number.class)) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException5) { throw new WrongType(localClassCastException5, "infinite?", 1, paramObject);
      }
      






      try
      {
        return isNan((Number)Promise.force(paramObject, Number.class)) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException6) { throw new WrongType(localClassCastException6, "nan?", 1, paramObject);
      }
    }
    

















    try
    {
      return abs((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException7) { throw new WrongType(localClassCastException7, "abs", 1, paramObject);
    }
    

























































    try
    {
      return numerator(LangObjType.coerceRealNum(Promise.force(paramObject, RealNum.class))); } catch (ClassCastException localClassCastException8) { throw new WrongType(localClassCastException8, "numerator", 1, paramObject);
    }
    
    try
    {
      return denominator(LangObjType.coerceRealNum(Promise.force(paramObject, RealNum.class))); } catch (ClassCastException localClassCastException9) { throw new WrongType(localClassCastException9, "denominator", 1, paramObject);
    }
    
    try
    {
      return floor(LangObjType.coerceRealNum(Promise.force(paramObject, RealNum.class))); } catch (ClassCastException localClassCastException10) { throw new WrongType(localClassCastException10, "floor", 1, paramObject);
    }
    try {
      return ceiling(LangObjType.coerceRealNum(Promise.force(paramObject, RealNum.class))); } catch (ClassCastException localClassCastException11) { throw new WrongType(localClassCastException11, "ceiling", 1, paramObject);
    }
    try {
      return truncate(LangObjType.coerceRealNum(Promise.force(paramObject, RealNum.class))); } catch (ClassCastException localClassCastException12) { throw new WrongType(localClassCastException12, "truncate", 1, paramObject);
    }
    try {
      return round(LangObjType.coerceRealNum(Promise.force(paramObject, RealNum.class))); } catch (ClassCastException localClassCastException13) { throw new WrongType(localClassCastException13, "round", 1, paramObject);
    }
    



    try
    {
      return exp((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException14) { throw new WrongType(localClassCastException14, "exp", 1, paramObject);
    }
    

































    try
    {
      return asin((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException15) { throw new WrongType(localClassCastException15, "asin", 1, paramObject);
    }
    







    try
    {
      return acos((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException16) { throw new WrongType(localClassCastException16, "acos", 1, paramObject);
    }
    




































































































    try
    {
      return sqrt((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException17) { throw new WrongType(localClassCastException17, "sqrt", 1, paramObject);
    }
    



    try
    {
      return square((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException18) { throw new WrongType(localClassCastException18, "square", 1, paramObject);
    }
    










    try
    {
      return realPart((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException19) { throw new WrongType(localClassCastException19, "real-part", 1, paramObject);
    }
    
    try
    {
      return imagPart((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException20) { throw new WrongType(localClassCastException20, "imag-part", 1, paramObject);
    }
    
    try
    {
      return jmagPart((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException21) { throw new WrongType(localClassCastException21, "jmag-part", 1, paramObject);
    }
    
    try
    {
      return kmagPart((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException22) { throw new WrongType(localClassCastException22, "kmag-part", 1, paramObject);
    }
    
    try
    {
      return unitVector((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException23) { throw new WrongType(localClassCastException23, "unit-vector", 1, paramObject);
    }
    
    try
    {
      return magnitude((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException24) { throw new WrongType(localClassCastException24, "magnitude", 1, paramObject);
    }
    try {
      return angle((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException25) { throw new WrongType(localClassCastException25, "angle", 1, paramObject);
    }
    
    try
    {
      return inexact((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException26) { throw new WrongType(localClassCastException26, "inexact", 1, paramObject);
    }
    try {
      return exact((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException27) { throw new WrongType(localClassCastException27, "exact", 1, paramObject);
    }
    try {
      return exact$To$Inexact((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException28) { throw new WrongType(localClassCastException28, "exact->inexact", 1, paramObject);
    }
    try {
      return inexact$To$Exact((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException29) { throw new WrongType(localClassCastException29, "inexact->exact", 1, paramObject);
    }
    
























    try
    {
      return Integer.valueOf(logcount(LangObjType.coerceIntNum(Promise.force(paramObject, IntNum.class)))); } catch (ClassCastException localClassCastException30) { throw new WrongType(localClassCastException30, "logcount", 1, paramObject);
    }
    try
    {
      return Integer.valueOf(bitwiseBitCount(LangObjType.coerceIntNum(Promise.force(paramObject, IntNum.class)))); } catch (ClassCastException localClassCastException31) { throw new WrongType(localClassCastException31, "bitwise-bit-count", 1, paramObject);
    }
    
    try
    {
      return Integer.valueOf(bitwiseLength(LangObjType.coerceIntNum(Promise.force(paramObject, IntNum.class)))); } catch (ClassCastException localClassCastException32) { throw new WrongType(localClassCastException32, "bitwise-length", 1, paramObject);
    }
    try {
      return Integer.valueOf(bitwiseFirstBitSet(LangObjType.coerceIntNum(Promise.force(paramObject, IntNum.class)))); } catch (ClassCastException localClassCastException33) { throw new WrongType(localClassCastException33, "bitwise-first-bit-set", 1, paramObject);
    }
    














    try
    {
      return number$To$String((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException34) { throw new WrongType(localClassCastException34, "number->string", 1, paramObject);
    }
    



    try
    {
      return string$To$Number((CharSequence)Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException35) { throw new WrongType(localClassCastException35, "string->number", 1, paramObject);
    }
    



    try
    {
      return quantity$To$Number((Quantity)Promise.force(paramObject, Quantity.class)); } catch (ClassCastException localClassCastException36) { throw new WrongType(localClassCastException36, "quantity->number", 1, paramObject);
    }
    


    try
    {
      return quantity$To$Unit((Quantity)Promise.force(paramObject, Quantity.class)); } catch (ClassCastException localClassCastException37) { throw new WrongType(localClassCastException37, "quantity->unit", 1, paramObject);
    }
    









    return duration(paramObject);
    try
    {
      return exactIntegerSqrt(LangObjType.coerceIntNum(Promise.force(paramObject, IntNum.class))); } catch (ClassCastException localClassCastException38) { throw new WrongType(localClassCastException38, "exact-integer-sqrt", 1, paramObject);
    }
    try
    {
      return lambda2((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException39) { throw new WrongType(
      














































































































































































































































































































        localClassCastException39, "lambda", 1, paramObject);
    }
    try
    {
      return lambda3((Quaternion)Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException40) { throw new WrongType(localClassCastException40, "lambda", 1, paramObject);
    }
    try { return Double.valueOf(lambda4(((Number)Promise.force(paramObject)).doubleValue())); } catch (ClassCastException localClassCastException41) { throw new WrongType(localClassCastException41, "lambda", 1, paramObject);
    }
    try
    {
      return lambda5((Quaternion)Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException42) { throw new WrongType(localClassCastException42, "lambda", 1, paramObject);
    }
    try { return Double.valueOf(lambda6(((Number)Promise.force(paramObject)).doubleValue())); } catch (ClassCastException localClassCastException43) { throw new WrongType(localClassCastException43, "lambda", 1, paramObject);
    }
    try
    {
      return lambda7((Quaternion)Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException44) { throw new WrongType(localClassCastException44, "lambda", 1, paramObject);
    }
    try { return Double.valueOf(lambda8(((Number)Promise.force(paramObject)).doubleValue())); } catch (ClassCastException localClassCastException45) { throw new WrongType(localClassCastException45, "lambda", 1, paramObject);
    }
    

































    try
    {
      return lambda10((Number)Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException46) { throw new WrongType(localClassCastException46, "lambda", 1, paramObject);
    }
    








    try
    {
      return lambda11((Complex)Promise.force(paramObject, Complex.class)); } catch (ClassCastException localClassCastException47) { throw new WrongType(localClassCastException47, "lambda", 1, paramObject);
    }
    

    try
    {
      return lambda12((Quaternion)Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException48) { throw new WrongType(localClassCastException48, "lambda", 1, paramObject);
    }
    try {
      return Double.valueOf(lambda13(((Number)Promise.force(paramObject)).doubleValue())); } catch (ClassCastException localClassCastException49) { throw new WrongType(localClassCastException49, "lambda", 1, paramObject);
    }
    
    try
    {
      return lambda14((Complex)Promise.force(paramObject, Complex.class)); } catch (ClassCastException localClassCastException50) { throw new WrongType(localClassCastException50, "lambda", 1, paramObject);
    }
    

    try
    {
      return lambda15((Quaternion)Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException51) { throw new WrongType(localClassCastException51, "lambda", 1, paramObject);
    }
    try {
      return Double.valueOf(lambda16(((Number)Promise.force(paramObject)).doubleValue())); } catch (ClassCastException localClassCastException52) { throw new WrongType(localClassCastException52, "lambda", 1, paramObject);
    }
    
    try
    {
      return lambda17((Complex)Promise.force(paramObject, Complex.class)); } catch (ClassCastException localClassCastException53) { throw new WrongType(localClassCastException53, "lambda", 1, paramObject);
    }
    



    try
    {
      return lambda18((Quaternion)Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException54) { throw new WrongType(localClassCastException54, "lambda", 1, paramObject);
    }
    
    try
    {
      return Double.valueOf(lambda19(((Number)Promise.force(paramObject)).doubleValue())); } catch (ClassCastException localClassCastException55) { throw new WrongType(localClassCastException55, "lambda", 1, paramObject);
    }
    
    try
    {
      return lambda20((Quaternion)Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException56) { throw new WrongType(localClassCastException56, "lambda", 1, paramObject);
    }
    try {
      return Double.valueOf(lambda21(((Number)Promise.force(paramObject)).doubleValue())); } catch (ClassCastException localClassCastException57) { throw new WrongType(localClassCastException57, "lambda", 1, paramObject);
    }
    
    try
    {
      return lambda22((Quaternion)Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException58) { throw new WrongType(localClassCastException58, "lambda", 1, paramObject);
    }
    try {
      return Double.valueOf(lambda23(((Number)Promise.force(paramObject)).doubleValue())); } catch (ClassCastException localClassCastException59) { throw new WrongType(localClassCastException59, "lambda", 1, paramObject);
    }
    
    try
    {
      return lambda24((Quaternion)Promise.force(paramObject, Quaternion.class)); } catch (ClassCastException localClassCastException60) { throw new WrongType(localClassCastException60, "lambda", 1, paramObject);
    }
    try {
      return Double.valueOf(lambda25(((Number)Promise.force(paramObject)).doubleValue())); } catch (ClassCastException localClassCastException61) { throw new WrongType(localClassCastException61, "lambda", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  
  public static double lambda25(double x) { return 0.5D * Math.log((1.0D + x) / (1.0D - x)); }
  
  public static Number sqrt(Number x) {
    if (isJava$DtLang$DtReal(x))
      Number localNumber1 = x; try { tmpTernaryOp = Double.valueOf(Math.sqrt(x.doubleValue()));
    } catch (ClassCastException localClassCastException2) {
      try { num = (Quantity)x;
        
        tmpTernaryOp = Quantity.make(num.number().sqrt(), num.unit().sqrt());return (Number)Promise.force(Values.empty, Number.class);
      }
      catch (ClassCastException localClassCastException2)
      {
        Number localNumber2;
        Quantity num;
        throw new WrongType(localClassCastException2, "num", -2, localNumber2);
      }
      throw new WrongType(
      


        localClassCastException1, "java.lang.Math.sqrt(double)", 1, num);
    }
    if ((x instanceof Quantity)) {
      localNumber2 = x;
    }
  }
  
  public static Number square(Number x) {
    return (Number)Promise.force(MultiplyOp.$St.apply2(x, x), Number.class);
  }
  

  public static Complex lambda26(RealNum x, RealNum y) { return Complex.make(x, y); }
  
  public static Quaternion lambda27(RealNum w, RealNum x, RealNum y, RealNum z) { return Quaternion.make(w, x, y, z); }
  
  public static Complex lambda28(double x, double y)
  {
    return Complex.polar(x, y);
  }
  
  static
  {
    Lit77 = Symbol.valueOf("duration");Lit76 = Symbol.valueOf("make-quantity");Lit75 = Symbol.valueOf("quantity->unit");Lit74 = Symbol.valueOf("quantity->number");Lit73 = Symbol.valueOf("string->number");Lit72 = Symbol.valueOf("number->string");Lit71 = Symbol.valueOf("bitwise-reverse-bit-field");Lit70 = Symbol.valueOf("bitwise-rotate-bit-field");Lit69 = Symbol.valueOf("bitwise-first-bit-set");Lit68 = Symbol.valueOf("bitwise-length");Lit67 = Symbol.valueOf("bitwise-bit-count");Lit66 = Symbol.valueOf("logcount");Lit65 = Symbol.valueOf("logtest");Lit64 = Symbol.valueOf("bitwise-if");Lit63 = Symbol.valueOf("bitwise-bit-field");Lit62 = Symbol.valueOf("bitwise-copy-bit-field");Lit61 = Symbol.valueOf("bitwise-copy-bit");Lit60 = Symbol.valueOf("bitwise-bit-set?");Lit59 = Symbol.valueOf("logop");Lit58 = Symbol.valueOf("inexact->exact");Lit57 = Symbol.valueOf("exact->inexact");Lit56 = Symbol.valueOf("exact");Lit55 = Symbol.valueOf("inexact");Lit54 = Symbol.valueOf("angle");Lit53 = Symbol.valueOf("magnitude");Lit52 = Symbol.valueOf("unit-vector");Lit51 = Symbol.valueOf("kmag-part");Lit50 = Symbol.valueOf("jmag-part");Lit49 = Symbol.valueOf("imag-part");Lit48 = Symbol.valueOf("real-part");Lit47 = Symbol.valueOf("square");Lit46 = Symbol.valueOf("sqrt");Lit45 = IntNum.valueOf(2);Lit44 = new IntFraction(numbers.Lit2 = IntNum.valueOf(1), Lit45);Lit43 = Symbol.valueOf("acos");Lit42 = Symbol.valueOf("asin");Lit41 = Symbol.valueOf("exp");Lit40 = Symbol.valueOf("rationalize");Lit39 = Symbol.valueOf("round");Lit38 = Symbol.valueOf("truncate");Lit37 = Symbol.valueOf("ceiling");Lit36 = Symbol.valueOf("floor");Lit35 = Symbol.valueOf("denominator");Lit34 = Symbol.valueOf("numerator");Lit33 = Symbol.valueOf("lcm");Lit32 = Symbol.valueOf("gcd");Lit31 = Symbol.valueOf("div0-and-mod0");Lit30 = Symbol.valueOf("div-and-mod");Lit29 = Symbol.valueOf("truncate/");Lit28 = Symbol.valueOf("floor/");Lit27 = Symbol.valueOf("abs");Lit26 = Symbol.valueOf("min");Lit25 = Symbol.valueOf("max");Lit24 = Symbol.valueOf("nan?");Lit23 = Symbol.valueOf("infinite?");Lit22 = Symbol.valueOf("finite?");Lit21 = Symbol.valueOf("negative?");Lit20 = Symbol.valueOf("positive?");Lit19 = Symbol.valueOf("zero?");Lit18 = Symbol.valueOf("inexact?");Lit17 = Symbol.valueOf("exact?");Lit16 = Symbol.valueOf("integer-valued?");Lit15 = Symbol.valueOf("rational-valued?");Lit14 = Symbol.valueOf("real-valued?");Lit13 = Symbol.valueOf("exact-integer?");Lit12 = Symbol.valueOf("integer?");Lit11 = Symbol.valueOf("rational?");Lit10 = Symbol.valueOf("real?");Lit9 = Symbol.valueOf("complex?");Lit8 = Symbol.valueOf("quaternion?");Lit7 = Symbol.valueOf("quantity?");Lit6 = Symbol.valueOf("number?");Lit5 = DFloNum.valueOf(0.0D);Lit4 = new CComplex(numbers.Lit0 = IntNum.valueOf(0), Lit2);Lit3 = IntNum.valueOf(-1);Lit1 = Symbol.valueOf("signum");LangObjType = LangObjType.class;quaternion = Quaternion.class;RealNum = RealNum.class;RatNum = RatNum.class;Numeric = Numeric.class;BitOps = BitOps.class;IntNum = IntNum.class;Double = Double.class;$instance = new numbers();numbers localNumbers1 = $instance;number$Qu = new ModuleMethod(localNumbers1, 1, Lit6, 4097);quantity$Qu = new ModuleMethod(localNumbers1, 2, Lit7, 4097);quaternion$Qu = new ModuleMethod(localNumbers1, 3, Lit8, 4097);complex$Qu = new ModuleMethod(localNumbers1, 4, Lit9, 4097);real$Qu = new ModuleMethod(localNumbers1, 5, Lit10, 4097);rational$Qu = new ModuleMethod(localNumbers1, 6, Lit11, 4097);integer$Qu = new ModuleMethod(localNumbers1, 7, Lit12, 4097);exact$Mninteger$Qu = new ModuleMethod(localNumbers1, 8, Lit13, 4097);real$Mnvalued$Qu = new ModuleMethod(localNumbers1, 9, Lit14, 4097);rational$Mnvalued$Qu = new ModuleMethod(localNumbers1, 10, Lit15, 4097);integer$Mnvalued$Qu = new ModuleMethod(localNumbers1, 11, Lit16, 4097);exact$Qu = new ModuleMethod(localNumbers1, 12, Lit17, 4097);inexact$Qu = new ModuleMethod(localNumbers1, 13, Lit18, 4097);zero$Qu = new ModuleMethod(localNumbers1, 14, Lit19, 4097);positive$Qu = new ModuleMethod(localNumbers1, 15, Lit20, 4097);negative$Qu = new ModuleMethod(localNumbers1, 16, Lit21, 4097);finite$Qu = new ModuleMethod(localNumbers1, 17, Lit22, 4097);infinite$Qu = new ModuleMethod(localNumbers1, 18, Lit23, 4097);nan$Qu = new ModuleMethod(localNumbers1, 19, Lit24, 4097);max = new ModuleMethod(localNumbers1, 20, Lit25, 61440);min = new ModuleMethod(localNumbers1, 21, Lit26, 61440);abs = new ModuleMethod(localNumbers1, 22, Lit27, 4097);floor$Sl = new ModuleMethod(localNumbers1, 23, Lit28, 8194);truncate$Sl = new ModuleMethod(localNumbers1, 24, Lit29, 8194);div$Mnand$Mnmod = new ModuleMethod(localNumbers1, 25, Lit30, 8194);div0$Mnand$Mnmod0 = new ModuleMethod(localNumbers1, 26, Lit31, 8194);gcd = new ModuleMethod(localNumbers1, 27, Lit32, 61440);lcm = new ModuleMethod(localNumbers1, 28, Lit33, 61440);numerator = new ModuleMethod(localNumbers1, 29, Lit34, 4097);denominator = new ModuleMethod(localNumbers1, 30, Lit35, 4097);floor = new ModuleMethod(localNumbers1, 31, Lit36, 4097);ceiling = new ModuleMethod(localNumbers1, 32, Lit37, 4097);truncate = new ModuleMethod(localNumbers1, 33, Lit38, 4097);round = new ModuleMethod(localNumbers1, 34, Lit39, 4097);rationalize = new ModuleMethod(localNumbers1, 35, Lit40, 8194);exp = new ModuleMethod(localNumbers1, 36, Lit41, 4097); void tmp1451_1448 = new GenericProc("log");
    numbers $instance = $instance; void tmp1470_1467 = new ModuleMethod($instance, 37, null, 8194);tmp1470_1467.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:258");tmp1451_1448.add(tmp1470_1467); void tmp1483_1451 = tmp1451_1448;
    






    numbers $instance = $instance; void tmp1502_1499 = new ModuleMethod($instance, 38, null, 4097);tmp1502_1499.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:266");tmp1483_1451.add(tmp1502_1499);log = tmp1483_1451; void 
    




      tmp1528_1525 = new GenericProc("sin");
    numbers $instance = $instance; void tmp1547_1544 = new ModuleMethod($instance, 39, null, 4097);tmp1547_1544.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:273");tmp1528_1525.add(tmp1547_1544); void tmp1560_1528 = tmp1528_1525;
    
    numbers $instance = $instance; void tmp1579_1576 = new ModuleMethod($instance, 40, null, 4097);tmp1579_1576.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:275");tmp1560_1528.add(tmp1579_1576);sin = tmp1560_1528; void 
    

      tmp1605_1602 = new GenericProc("cos");
    numbers $instance = $instance; void tmp1624_1621 = new ModuleMethod($instance, 41, null, 4097);tmp1624_1621.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:279");tmp1605_1602.add(tmp1624_1621); void tmp1637_1605 = tmp1605_1602;
    
    numbers $instance = $instance; void tmp1656_1653 = new ModuleMethod($instance, 42, null, 4097);tmp1656_1653.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:281");tmp1637_1605.add(tmp1656_1653);cos = tmp1637_1605; void 
    

      tmp1682_1679 = new GenericProc("tan");
    numbers $instance = $instance; void tmp1701_1698 = new ModuleMethod($instance, 43, null, 4097);tmp1701_1698.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:285");tmp1682_1679.add(tmp1701_1698); void tmp1714_1682 = tmp1682_1679;
    
    numbers $instance = $instance; void tmp1733_1730 = new ModuleMethod($instance, 44, null, 4097);tmp1733_1730.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:287");tmp1714_1682.add(tmp1733_1730);tan = tmp1714_1682;asin = new ModuleMethod(localNumbers1, 45, Lit42, 4097);acos = new ModuleMethod(localNumbers1, 46, Lit43, 4097); void 
    

























      tmp1797_1794 = new GenericProc("atan");
    numbers $instance = $instance; void tmp1816_1813 = new ModuleMethod($instance, 47, null, 8194);tmp1816_1813.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:315");tmp1797_1794.add(tmp1816_1813); void tmp1829_1797 = tmp1797_1794;
    








    numbers $instance = $instance; void tmp1848_1845 = new ModuleMethod($instance, 48, null, 4097);tmp1848_1845.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:325");tmp1829_1797.add(tmp1848_1845);atan = tmp1829_1797; void 
    










      tmp1874_1871 = new GenericProc("sinh");
    numbers $instance = $instance; void tmp1893_1890 = new ModuleMethod($instance, 49, null, 4097);tmp1893_1890.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:338");tmp1874_1871.add(tmp1893_1890); void tmp1906_1874 = tmp1874_1871;
    




    numbers $instance = $instance; void tmp1925_1922 = new ModuleMethod($instance, 50, null, 4097);tmp1925_1922.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:344");tmp1906_1874.add(tmp1925_1922); void tmp1938_1906 = tmp1906_1874;
    

    numbers $instance = $instance; void tmp1959_1956 = new ModuleMethod($instance, 51, null, 4097);tmp1959_1956.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:347");tmp1938_1906.add(tmp1959_1956);sinh = tmp1938_1906; void 
    


      tmp1985_1982 = new GenericProc("cosh");
    numbers $instance = $instance; void tmp2004_2001 = new ModuleMethod($instance, 52, null, 4097);tmp2004_2001.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:352");tmp1985_1982.add(tmp2004_2001); void tmp2017_1985 = tmp1985_1982;
    




    numbers $instance = $instance; void tmp2036_2033 = new ModuleMethod($instance, 53, null, 4097);tmp2036_2033.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:358");tmp2017_1985.add(tmp2036_2033); void tmp2049_2017 = tmp2017_1985;
    

    numbers $instance = $instance; void tmp2070_2067 = new ModuleMethod($instance, 54, null, 4097);tmp2070_2067.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:361");tmp2049_2017.add(tmp2070_2067);cosh = tmp2049_2017; void 
    


      tmp2096_2093 = new GenericProc("tanh");
    numbers $instance = $instance; void tmp2115_2112 = new ModuleMethod($instance, 55, null, 4097);tmp2115_2112.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:366");tmp2096_2093.add(tmp2115_2112); void tmp2128_2096 = tmp2096_2093;
    






    numbers $instance = $instance; void tmp2147_2144 = new ModuleMethod($instance, 56, null, 4097);tmp2147_2144.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:374");tmp2128_2096.add(tmp2147_2144); void tmp2160_2128 = tmp2128_2096;
    



    numbers $instance = $instance; void tmp2181_2178 = new ModuleMethod($instance, 57, null, 4097);tmp2181_2178.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:379");tmp2160_2128.add(tmp2181_2178);tanh = tmp2160_2128; void 
    


      tmp2207_2204 = new GenericProc("asinh");
    numbers $instance = $instance; void tmp2226_2223 = new ModuleMethod($instance, 58, null, 4097);tmp2226_2223.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:384");tmp2207_2204.add(tmp2226_2223); void tmp2239_2207 = tmp2207_2204;
    

    numbers $instance = $instance; void tmp2258_2255 = new ModuleMethod($instance, 59, null, 4097);tmp2258_2255.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:387");tmp2239_2207.add(tmp2258_2255);asinh = tmp2239_2207; void 
    


      tmp2284_2281 = new GenericProc("acosh");
    numbers $instance = $instance; void tmp2303_2300 = new ModuleMethod($instance, 60, null, 4097);tmp2303_2300.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:392");tmp2284_2281.add(tmp2303_2300); void tmp2316_2284 = tmp2284_2281;
    

    numbers $instance = $instance; void tmp2335_2332 = new ModuleMethod($instance, 61, null, 4097);tmp2335_2332.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:395");tmp2316_2284.add(tmp2335_2332);acosh = tmp2316_2284; void 
    


      tmp2361_2358 = new GenericProc("atanh");
    numbers $instance = $instance; void tmp2380_2377 = new ModuleMethod($instance, 62, null, 4097);tmp2380_2377.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:400");tmp2361_2358.add(tmp2380_2377); void tmp2393_2361 = tmp2361_2358;
    

    numbers $instance = $instance; void tmp2412_2409 = new ModuleMethod($instance, 63, null, 4097);tmp2412_2409.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:403");tmp2393_2361.add(tmp2412_2409);atanh = tmp2393_2361;sqrt = new ModuleMethod(localNumbers1, 64, Lit46, 4097);square = new ModuleMethod(localNumbers1, 65, Lit47, 4097); void 
    













      tmp2476_2473 = new GenericProc("make-rectangular");
    numbers $instance = $instance; void tmp2495_2492 = new ModuleMethod($instance, 66, null, 8194);tmp2495_2492.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:419");tmp2476_2473.add(tmp2495_2492); void tmp2508_2476 = tmp2476_2473;
    
    numbers $instance = $instance; void tmp2527_2524 = new ModuleMethod($instance, 67, null, 16388);tmp2527_2524.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:421");tmp2508_2476.add(tmp2527_2524);make$Mnrectangular = tmp2508_2476; void 
    

      tmp2553_2550 = new GenericProc("make-polar");
    numbers $instance = $instance; void tmp2572_2569 = new ModuleMethod($instance, 68, null, 8194);tmp2572_2569.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:425");tmp2553_2550.add(tmp2572_2569); void tmp2585_2553 = tmp2553_2550;
    
    numbers $instance = $instance; void tmp2604_2601 = new ModuleMethod($instance, 69, null, 16388);tmp2604_2601.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/numbers.scm:427");tmp2585_2553.add(tmp2604_2601);make$Mnpolar = tmp2585_2553;real$Mnpart = new ModuleMethod(localNumbers1, 70, Lit48, 4097);imag$Mnpart = new ModuleMethod(localNumbers1, 71, Lit49, 4097);jmag$Mnpart = new ModuleMethod(localNumbers1, 72, Lit50, 4097);kmag$Mnpart = new ModuleMethod(localNumbers1, 73, Lit51, 4097);unit$Mnvector = new ModuleMethod(localNumbers1, 74, Lit52, 4097);magnitude = new ModuleMethod(localNumbers1, 75, Lit53, 4097);angle = new ModuleMethod(localNumbers1, 76, Lit54, 4097);inexact = new ModuleMethod(localNumbers1, 77, Lit55, 4097);exact = new ModuleMethod(localNumbers1, 78, Lit56, 4097);exact$Mn$Grinexact = new ModuleMethod(localNumbers1, 79, Lit57, 4097);inexact$Mn$Grexact = new ModuleMethod(localNumbers1, 80, Lit58, 4097);logop = new ModuleMethod(localNumbers1, 81, Lit59, 12291);bitwise$Mnbit$Mnset$Qu = new ModuleMethod(localNumbers1, 82, Lit60, 8194);bitwise$Mncopy$Mnbit = new ModuleMethod(localNumbers1, 83, Lit61, 12291);bitwise$Mncopy$Mnbit$Mnfield = new ModuleMethod(localNumbers1, 84, Lit62, 16388);bitwise$Mnbit$Mnfield = new ModuleMethod(localNumbers1, 85, Lit63, 12291);bitwise$Mnif = new ModuleMethod(localNumbers1, 86, Lit64, 12291);logtest = new ModuleMethod(localNumbers1, 87, Lit65, 8194);logcount = new ModuleMethod(localNumbers1, 88, Lit66, 4097);bitwise$Mnbit$Mncount = new ModuleMethod(localNumbers1, 89, Lit67, 4097);bitwise$Mnlength = new ModuleMethod(localNumbers1, 90, Lit68, 4097);bitwise$Mnfirst$Mnbit$Mnset = new ModuleMethod(localNumbers1, 91, Lit69, 4097);bitwise$Mnrotate$Mnbit$Mnfield = new ModuleMethod(localNumbers1, 92, Lit70, 16388);bitwise$Mnreverse$Mnbit$Mnfield = new ModuleMethod(localNumbers1, 93, Lit71, 12291);number$Mn$Grstring = new ModuleMethod(localNumbers1, 94, Lit72, 8193);string$Mn$Grnumber = new ModuleMethod(localNumbers1, 96, Lit73, 8193);quantity$Mn$Grnumber = new ModuleMethod(localNumbers1, 98, Lit74, 4097);quantity$Mn$Grunit = new ModuleMethod(localNumbers1, 99, Lit75, 4097);make$Mnquantity = new ModuleMethod(localNumbers1, 100, Lit76, 8194);duration = new ModuleMethod(localNumbers1, 101, Lit77, 4097);exact$Mninteger$Mnsqrt = new ModuleMethod(localNumbers1, 102, Lit78, 4097);$runBody$();
  }
  
  public static Quaternion lambda29(double r, double t, double u, double v)
  {
    return Quaternion.polar(r, t, u, v);
  }
  
  public static Number realPart(Number x)
  {
    return (x instanceof Quaternion) ? 
      ((Quaternion)x).re() : x;
  }
  
  public static Number imagPart(Number x)
  {
    return (x instanceof Quaternion) ? ((Quaternion)x).im() : IntNum.zero();
  }
  
  public static Number jmagPart(Number x)
  {
    return (x instanceof Quaternion) ? ((Quaternion)x).jm() : IntNum.zero();
  }
  
  public static Number kmagPart(Number x)
  {
    return (x instanceof Quaternion) ? ((Quaternion)x).km() : IntNum.zero();
  }
  
  public static Quaternion unitVector(Number x)
  {
    return (x instanceof Quaternion) ? 
      ((Quaternion)x).unitVector() : Lit0;
  }
  
  public static Number magnitude(Number x)
  {
    return abs(x);
  }
  
  public static RealNum angle(Number x)
  {
    return x.doubleValue() < 0.0D ? DFloNum.make(Math.PI) : (x instanceof Quaternion) ? ((Quaternion)x).angle() : Lit5;
  }
  
  public static Number inexact(Number num)
  {
    return Arithmetic.toInexact(num);
  }
  
  public static Number exact(Number num)
  {
    return Arithmetic.toExact(num);
  }
  
  public static Number exact$To$Inexact(Number num)
  {
    return Arithmetic.toInexact(num);
  }
  
  public static Number inexact$To$Exact(Number num)
  {
    return Arithmetic.toExact(num);
  }
  
  public static IntNum logop(int op, IntNum i, IntNum j)
  {
    return BitOps.bitOp(op, i, j);
  }
  
  public static boolean isBitwiseBitSet(IntNum i, int bitno)
  {
    return BitOps.bitValue(i, bitno);
  }
  
  public static IntNum bitwiseCopyBit(IntNum i, int bitno, int new$Mnvalue)
  {
    return BitOps.setBitValue(i, bitno, new$Mnvalue);
  }
  
  public static IntNum bitwiseCopyBitField(IntNum to, int start, int end, IntNum from)
  {
    return bitwiseIf(BitOps.makeMask(start, end), IntNum.shift(from, start), to);
  }
  
  public static IntNum bitwiseBitField(IntNum i, int start, int end)
  {
    return BitOps.extract(i, start, end);
  }
  
  public static IntNum bitwiseIf(IntNum e1, IntNum e2, IntNum e3)
  {
    return BitOps.ior(BitOps.and(e1, e2), BitOps.and(BitOps.not(e1), e3));
  }
  
  public static boolean logtest(IntNum i, IntNum j)
  {
    return BitOps.test(i, j);
  }
  
  public static int logcount(IntNum i)
  {
    return BitOps.bitCount(IntNum.compare(i, 0L) >= 0 ? i : BitOps.not(i));
  }
  
  public static int bitwiseBitCount(IntNum i)
  {
    return IntNum.compare(i, 0L) >= 0 ? BitOps.bitCount(i) : -1 - BitOps.bitCount(BitOps.not(i));
  }
  
  public static int bitwiseLength(IntNum i)
  {
    return i.intLength();
  }
  
  public static int bitwiseFirstBitSet(IntNum i)
  {
    return BitOps.lowestBitSet(i);
  }
  
  public static IntNum bitwiseRotateBitField(IntNum n, int start, int end, int count)
  {
    int width = end - start;
    

    int r = count % width;
    int count = r < 0 ? r + width : r;
    IntNum field0 = bitwiseBitField(n, start, end);
    IntNum field1 = IntNum.shift(field0, count);
    IntNum field2 = IntNum.shift(field0, count - width);
    IntNum field = BitOps.ior(field1, field2);return width > 0 ? 
      bitwiseCopyBitField(n, start, end, field) : n;
  }
  
  public static IntNum bitwiseReverseBitField(IntNum n, int start, int end)
  {
    return BitOps.reverseBits(n, start, end);
  }
  
  public static CharSequence number$To$String(Number arg, int radix)
  {
    boolean x = radix < 2; if (x ? x : radix > 36)
    {
      throw new IllegalArgumentException(Format.formatToString(0, new Object[] { "invalid radix ~d", Integer.valueOf(radix) }));
    }
    return new FString(Arithmetic.toString(arg, radix));
  }
  
  public static Object string$To$Number(CharSequence str, int radix)
  {
    boolean x = radix < 2; if (x ? x : radix > 36)
    {
      throw new IllegalArgumentException(Format.formatToString(0, new Object[] { "invalid radix ~d", Integer.valueOf(radix) })); }
    Object result = LispReader.parseNumber(str, -radix);
    return (result instanceof Numeric) ? result : Boolean.FALSE;
  }
  
  public static Quaternion quantity$To$Number(Quantity q)
  {
    q.unit();
    double factor = q.doubleValue();
    

    return factor == 1.0D ? q.number() : Quaternion.make(q.reValue(), q.imValue(), q.jmValue(), q.kmValue());
  }
  
  public static Unit quantity$To$Unit(Quantity q)
  {
    return q.unit();
  }
  
  public static Duration duration(Object duration)
  {
    Object tmp7_4 = Promise.force(duration, String.class);tmp7_4;return Duration.parseDuration(tmp7_4 == null ? null : tmp7_4.toString());
  }
  
  public static Object exactIntegerSqrt(IntNum i)
  {
    if (IntNum.compare(i, 0L) < 0)
    {
      throw new IllegalArgumentException(Format.formatToString(0, new Object[] { "negative argument: ~A", i })); }
    double dval = i.doubleValue();
    

    int il = i.intLength();
    

    IntNum init = Double.isInfinite(dval) ? BitOps.makeMask(il, il + 1) : RealNum.toExactInt(Math.sqrt(dval), Numeric.TRUNCATE);
    
    IntNum q = init;
    IntNum rem = IntNum.sub(i, IntNum.times(q, q));
    
    boolean x = IntNum.compare(rem, 0L) < 0;
    




    return misc.values(new Object[] { q, rem });
  }
  
  /* Error */
  public static boolean isRealValued(Object x)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 91	kawa/lib/numbers:isQuaternion	(Ljava/lang/Object;)Z
    //   4: ifeq +95 -> 99
    //   7: aload_0
    //   8: ldc 12
    //   10: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   13: dup
    //   14: astore_1
    //   15: checkcast 12	java/lang/Number
    //   18: invokestatic 97	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   21: invokestatic 101	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   24: ifeq +71 -> 95
    //   27: aload_0
    //   28: ldc 12
    //   30: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   33: dup
    //   34: astore_1
    //   35: checkcast 12	java/lang/Number
    //   38: invokestatic 106	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   41: invokestatic 101	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   44: ifeq +47 -> 91
    //   47: aload_0
    //   48: ldc 12
    //   50: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   53: dup
    //   54: astore_1
    //   55: checkcast 12	java/lang/Number
    //   58: invokestatic 111	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   61: invokestatic 101	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   64: ifeq +23 -> 87
    //   67: aload_0
    //   68: ldc 12
    //   70: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   73: dup
    //   74: astore_1
    //   75: checkcast 12	java/lang/Number
    //   78: invokestatic 116	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   81: invokestatic 119	kawa/lib/numbers:isReal	(Ljava/lang/Object;)Z
    //   84: goto +16 -> 100
    //   87: iconst_0
    //   88: goto +12 -> 100
    //   91: iconst_0
    //   92: goto +8 -> 100
    //   95: iconst_0
    //   96: goto +4 -> 100
    //   99: iconst_0
    //   100: ireturn
    //   101: new 66	gnu/mapping/WrongType
    //   104: dup_x1
    //   105: swap
    //   106: ldc 93
    //   108: iconst_0
    //   109: aload_1
    //   110: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   113: athrow
    //   114: new 66	gnu/mapping/WrongType
    //   117: dup_x1
    //   118: swap
    //   119: ldc 103
    //   121: iconst_0
    //   122: aload_1
    //   123: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   126: athrow
    //   127: new 66	gnu/mapping/WrongType
    //   130: dup_x1
    //   131: swap
    //   132: ldc 108
    //   134: iconst_0
    //   135: aload_1
    //   136: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   139: athrow
    //   140: new 66	gnu/mapping/WrongType
    //   143: dup_x1
    //   144: swap
    //   145: ldc 113
    //   147: iconst_0
    //   148: aload_1
    //   149: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   152: athrow
    // Line number table:
    //   Java source line #78	-> byte code offset #0
    //   Java source line #79	-> byte code offset #0
    //   Java source line #80	-> byte code offset #7
    //   Java source line #81	-> byte code offset #27
    //   Java source line #82	-> byte code offset #47
    //   Java source line #83	-> byte code offset #67
    //   Java source line #80	-> byte code offset #101
    //   Java source line #81	-> byte code offset #114
    //   Java source line #82	-> byte code offset #127
    //   Java source line #83	-> byte code offset #140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	x	Object
    //   14	135	1	localObject	Object
    //   101	1	2	localClassCastException1	ClassCastException
    //   114	1	3	localClassCastException2	ClassCastException
    //   127	1	4	localClassCastException3	ClassCastException
    //   140	1	5	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   15	18	101	java/lang/ClassCastException
    //   35	38	114	java/lang/ClassCastException
    //   55	58	127	java/lang/ClassCastException
    //   75	78	140	java/lang/ClassCastException
  }
  
  /* Error */
  public static boolean isRationalValued(Object x)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 91	kawa/lib/numbers:isQuaternion	(Ljava/lang/Object;)Z
    //   4: ifeq +95 -> 99
    //   7: aload_0
    //   8: ldc 12
    //   10: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   13: dup
    //   14: astore_1
    //   15: checkcast 12	java/lang/Number
    //   18: invokestatic 97	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   21: invokestatic 101	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   24: ifeq +71 -> 95
    //   27: aload_0
    //   28: ldc 12
    //   30: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   33: dup
    //   34: astore_1
    //   35: checkcast 12	java/lang/Number
    //   38: invokestatic 106	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   41: invokestatic 101	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   44: ifeq +47 -> 91
    //   47: aload_0
    //   48: ldc 12
    //   50: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   53: dup
    //   54: astore_1
    //   55: checkcast 12	java/lang/Number
    //   58: invokestatic 111	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   61: invokestatic 101	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   64: ifeq +23 -> 87
    //   67: aload_0
    //   68: ldc 12
    //   70: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   73: dup
    //   74: astore_1
    //   75: checkcast 12	java/lang/Number
    //   78: invokestatic 116	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   81: invokestatic 122	kawa/lib/numbers:isRational	(Ljava/lang/Object;)Z
    //   84: goto +16 -> 100
    //   87: iconst_0
    //   88: goto +12 -> 100
    //   91: iconst_0
    //   92: goto +8 -> 100
    //   95: iconst_0
    //   96: goto +4 -> 100
    //   99: iconst_0
    //   100: ireturn
    //   101: new 66	gnu/mapping/WrongType
    //   104: dup_x1
    //   105: swap
    //   106: ldc 93
    //   108: iconst_0
    //   109: aload_1
    //   110: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   113: athrow
    //   114: new 66	gnu/mapping/WrongType
    //   117: dup_x1
    //   118: swap
    //   119: ldc 103
    //   121: iconst_0
    //   122: aload_1
    //   123: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   126: athrow
    //   127: new 66	gnu/mapping/WrongType
    //   130: dup_x1
    //   131: swap
    //   132: ldc 108
    //   134: iconst_0
    //   135: aload_1
    //   136: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   139: athrow
    //   140: new 66	gnu/mapping/WrongType
    //   143: dup_x1
    //   144: swap
    //   145: ldc 113
    //   147: iconst_0
    //   148: aload_1
    //   149: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   152: athrow
    // Line number table:
    //   Java source line #84	-> byte code offset #0
    //   Java source line #85	-> byte code offset #0
    //   Java source line #86	-> byte code offset #7
    //   Java source line #87	-> byte code offset #27
    //   Java source line #88	-> byte code offset #47
    //   Java source line #89	-> byte code offset #67
    //   Java source line #86	-> byte code offset #101
    //   Java source line #87	-> byte code offset #114
    //   Java source line #88	-> byte code offset #127
    //   Java source line #89	-> byte code offset #140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	x	Object
    //   14	135	1	localObject	Object
    //   101	1	2	localClassCastException1	ClassCastException
    //   114	1	3	localClassCastException2	ClassCastException
    //   127	1	4	localClassCastException3	ClassCastException
    //   140	1	5	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   15	18	101	java/lang/ClassCastException
    //   35	38	114	java/lang/ClassCastException
    //   55	58	127	java/lang/ClassCastException
    //   75	78	140	java/lang/ClassCastException
  }
  
  /* Error */
  public static boolean isIntegerValued(Object x)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 91	kawa/lib/numbers:isQuaternion	(Ljava/lang/Object;)Z
    //   4: ifeq +95 -> 99
    //   7: aload_0
    //   8: ldc 12
    //   10: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   13: dup
    //   14: astore_1
    //   15: checkcast 12	java/lang/Number
    //   18: invokestatic 97	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   21: invokestatic 101	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   24: ifeq +71 -> 95
    //   27: aload_0
    //   28: ldc 12
    //   30: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   33: dup
    //   34: astore_1
    //   35: checkcast 12	java/lang/Number
    //   38: invokestatic 106	kawa/lib/numbers:jmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   41: invokestatic 101	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   44: ifeq +47 -> 91
    //   47: aload_0
    //   48: ldc 12
    //   50: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   53: dup
    //   54: astore_1
    //   55: checkcast 12	java/lang/Number
    //   58: invokestatic 111	kawa/lib/numbers:kmagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   61: invokestatic 101	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   64: ifeq +23 -> 87
    //   67: aload_0
    //   68: ldc 12
    //   70: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   73: dup
    //   74: astore_1
    //   75: checkcast 12	java/lang/Number
    //   78: invokestatic 116	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   81: invokestatic 125	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   84: goto +16 -> 100
    //   87: iconst_0
    //   88: goto +12 -> 100
    //   91: iconst_0
    //   92: goto +8 -> 100
    //   95: iconst_0
    //   96: goto +4 -> 100
    //   99: iconst_0
    //   100: ireturn
    //   101: new 66	gnu/mapping/WrongType
    //   104: dup_x1
    //   105: swap
    //   106: ldc 93
    //   108: iconst_0
    //   109: aload_1
    //   110: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   113: athrow
    //   114: new 66	gnu/mapping/WrongType
    //   117: dup_x1
    //   118: swap
    //   119: ldc 103
    //   121: iconst_0
    //   122: aload_1
    //   123: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   126: athrow
    //   127: new 66	gnu/mapping/WrongType
    //   130: dup_x1
    //   131: swap
    //   132: ldc 108
    //   134: iconst_0
    //   135: aload_1
    //   136: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   139: athrow
    //   140: new 66	gnu/mapping/WrongType
    //   143: dup_x1
    //   144: swap
    //   145: ldc 113
    //   147: iconst_0
    //   148: aload_1
    //   149: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   152: athrow
    // Line number table:
    //   Java source line #90	-> byte code offset #0
    //   Java source line #91	-> byte code offset #0
    //   Java source line #92	-> byte code offset #7
    //   Java source line #93	-> byte code offset #27
    //   Java source line #94	-> byte code offset #47
    //   Java source line #95	-> byte code offset #67
    //   Java source line #92	-> byte code offset #101
    //   Java source line #93	-> byte code offset #114
    //   Java source line #94	-> byte code offset #127
    //   Java source line #95	-> byte code offset #140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	x	Object
    //   14	135	1	localObject	Object
    //   101	1	2	localClassCastException1	ClassCastException
    //   114	1	3	localClassCastException2	ClassCastException
    //   127	1	4	localClassCastException3	ClassCastException
    //   140	1	5	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   15	18	101	java/lang/ClassCastException
    //   35	38	114	java/lang/ClassCastException
    //   55	58	127	java/lang/ClassCastException
    //   75	78	140	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object floor$Sl(RealNum x, RealNum y)
  {
    // Byte code:
    //   0: getstatic 235	gnu/kawa/functions/DivideOp:floorQuotient	Lgnu/kawa/functions/DivideOp;
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: ldc 26
    //   10: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   13: dup
    //   14: astore_3
    //   15: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   18: astore_2
    //   19: iconst_m1
    //   20: aload_0
    //   21: getstatic 243	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: invokestatic 246	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: ldc 26
    //   34: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   37: dup
    //   38: astore 4
    //   40: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   43: astore_3
    //   44: iconst_2
    //   45: anewarray 250	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_2
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: aload_3
    //   55: aastore
    //   56: invokestatic 256	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   59: areturn
    //   60: new 66	gnu/mapping/WrongType
    //   63: dup_x1
    //   64: swap
    //   65: ldc -19
    //   67: bipush -2
    //   69: aload_3
    //   70: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    //   74: new 66	gnu/mapping/WrongType
    //   77: dup_x1
    //   78: swap
    //   79: ldc -8
    //   81: bipush -2
    //   83: aload 4
    //   85: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   88: athrow
    // Line number table:
    //   Java source line #171	-> byte code offset #0
    //   Java source line #172	-> byte code offset #0
    //   Java source line #173	-> byte code offset #19
    //   Java source line #174	-> byte code offset #44
    //   Java source line #172	-> byte code offset #60
    //   Java source line #173	-> byte code offset #74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	x	RealNum
    //   0	59	1	y	RealNum
    //   18	33	2	q	RealNum
    //   14	1	3	localObject1	Object
    //   43	27	3	r	RealNum
    //   38	46	4	localObject2	Object
    //   60	1	6	localClassCastException1	ClassCastException
    //   74	1	7	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   15	18	60	java/lang/ClassCastException
    //   40	43	74	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object truncate$Sl(RealNum x, RealNum y)
  {
    // Byte code:
    //   0: getstatic 259	gnu/kawa/functions/DivideOp:quotient	Lgnu/kawa/functions/DivideOp;
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: ldc 26
    //   10: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   13: dup
    //   14: astore_3
    //   15: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   18: astore_2
    //   19: iconst_m1
    //   20: aload_0
    //   21: getstatic 243	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: invokestatic 246	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: ldc 26
    //   34: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   37: dup
    //   38: astore 4
    //   40: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   43: astore_3
    //   44: iconst_2
    //   45: anewarray 250	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_2
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: aload_3
    //   55: aastore
    //   56: invokestatic 256	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   59: areturn
    //   60: new 66	gnu/mapping/WrongType
    //   63: dup_x1
    //   64: swap
    //   65: ldc -19
    //   67: bipush -2
    //   69: aload_3
    //   70: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    //   74: new 66	gnu/mapping/WrongType
    //   77: dup_x1
    //   78: swap
    //   79: ldc -8
    //   81: bipush -2
    //   83: aload 4
    //   85: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   88: athrow
    // Line number table:
    //   Java source line #176	-> byte code offset #0
    //   Java source line #177	-> byte code offset #0
    //   Java source line #178	-> byte code offset #19
    //   Java source line #179	-> byte code offset #44
    //   Java source line #177	-> byte code offset #60
    //   Java source line #178	-> byte code offset #74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	x	RealNum
    //   0	59	1	y	RealNum
    //   18	33	2	q	RealNum
    //   14	1	3	localObject1	Object
    //   43	27	3	r	RealNum
    //   38	46	4	localObject2	Object
    //   60	1	6	localClassCastException1	ClassCastException
    //   74	1	7	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   15	18	60	java/lang/ClassCastException
    //   40	43	74	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object divAndMod(RealNum x, RealNum y)
  {
    // Byte code:
    //   0: getstatic 262	gnu/kawa/functions/DivideOp:div	Lgnu/kawa/functions/DivideOp;
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: ldc 26
    //   10: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   13: dup
    //   14: astore_3
    //   15: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   18: astore_2
    //   19: iconst_m1
    //   20: aload_0
    //   21: getstatic 243	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: invokestatic 246	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: ldc 26
    //   34: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   37: dup
    //   38: astore 4
    //   40: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   43: astore_3
    //   44: iconst_2
    //   45: anewarray 250	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_2
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: aload_3
    //   55: aastore
    //   56: invokestatic 256	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   59: areturn
    //   60: new 66	gnu/mapping/WrongType
    //   63: dup_x1
    //   64: swap
    //   65: ldc -19
    //   67: bipush -2
    //   69: aload_3
    //   70: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    //   74: new 66	gnu/mapping/WrongType
    //   77: dup_x1
    //   78: swap
    //   79: ldc -8
    //   81: bipush -2
    //   83: aload 4
    //   85: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   88: athrow
    // Line number table:
    //   Java source line #181	-> byte code offset #0
    //   Java source line #182	-> byte code offset #0
    //   Java source line #183	-> byte code offset #19
    //   Java source line #184	-> byte code offset #44
    //   Java source line #182	-> byte code offset #60
    //   Java source line #183	-> byte code offset #74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	x	RealNum
    //   0	59	1	y	RealNum
    //   18	33	2	q	RealNum
    //   14	1	3	localObject1	Object
    //   43	27	3	r	RealNum
    //   38	46	4	localObject2	Object
    //   60	1	6	localClassCastException1	ClassCastException
    //   74	1	7	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   15	18	60	java/lang/ClassCastException
    //   40	43	74	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object div0AndMod0(RealNum x, RealNum y)
  {
    // Byte code:
    //   0: getstatic 265	gnu/kawa/functions/DivideOp:div0	Lgnu/kawa/functions/DivideOp;
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: ldc 26
    //   10: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   13: dup
    //   14: astore_3
    //   15: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   18: astore_2
    //   19: iconst_m1
    //   20: aload_0
    //   21: getstatic 243	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: invokestatic 246	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: ldc 26
    //   34: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   37: dup
    //   38: astore 4
    //   40: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   43: astore_3
    //   44: iconst_2
    //   45: anewarray 250	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_2
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: aload_3
    //   55: aastore
    //   56: invokestatic 256	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   59: areturn
    //   60: new 66	gnu/mapping/WrongType
    //   63: dup_x1
    //   64: swap
    //   65: ldc -19
    //   67: bipush -2
    //   69: aload_3
    //   70: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    //   74: new 66	gnu/mapping/WrongType
    //   77: dup_x1
    //   78: swap
    //   79: ldc -8
    //   81: bipush -2
    //   83: aload 4
    //   85: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   88: athrow
    // Line number table:
    //   Java source line #186	-> byte code offset #0
    //   Java source line #187	-> byte code offset #0
    //   Java source line #188	-> byte code offset #19
    //   Java source line #189	-> byte code offset #44
    //   Java source line #187	-> byte code offset #60
    //   Java source line #188	-> byte code offset #74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	x	RealNum
    //   0	59	1	y	RealNum
    //   18	33	2	q	RealNum
    //   14	1	3	localObject1	Object
    //   43	27	3	r	RealNum
    //   38	46	4	localObject2	Object
    //   60	1	6	localClassCastException1	ClassCastException
    //   74	1	7	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   15	18	60	java/lang/ClassCastException
    //   40	43	74	java/lang/ClassCastException
  }
  
  /* Error */
  public static Number exp(Number x)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 20	kawa/lib/numbers:isJava$DtLang$DtReal	(Ljava/lang/Object;)Z
    //   4: ifeq +18 -> 22
    //   7: aload_0
    //   8: dup
    //   9: astore_1
    //   10: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   13: invokestatic 334	java/lang/Math:exp	(D)D
    //   16: invokestatic 338	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   19: goto +28 -> 47
    //   22: aload_0
    //   23: instanceof 22
    //   26: ifeq +13 -> 39
    //   29: aload_0
    //   30: checkcast 22	gnu/math/Quaternion
    //   33: invokevirtual 341	gnu/math/Quaternion:exp	()Lgnu/math/Quaternion;
    //   36: goto +11 -> 47
    //   39: new 343	java/lang/IllegalArgumentException
    //   42: dup
    //   43: invokespecial 346	java/lang/IllegalArgumentException:<init>	()V
    //   46: athrow
    //   47: areturn
    //   48: new 66	gnu/mapping/WrongType
    //   51: dup_x1
    //   52: swap
    //   53: ldc_w 330
    //   56: iconst_1
    //   57: aload_1
    //   58: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   61: athrow
    // Line number table:
    //   Java source line #252	-> byte code offset #0
    //   Java source line #253	-> byte code offset #0
    //   Java source line #254	-> byte code offset #22
    //   Java source line #255	-> byte code offset #39
    //   Java source line #253	-> byte code offset #48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	x	Number
    // Exception table:
    //   from	to	target	type
    //   10	13	48	java/lang/ClassCastException
  }
  
  public static CharSequence number$To$String(Number paramNumber)
  {
    return number$To$String(paramNumber, 10);
  }
  
  public static Object string$To$Number(CharSequence paramCharSequence)
  {
    return string$To$Number(paramCharSequence, 10);
  }
  
  /* Error */
  public static Quantity makeQuantity(Object val, Object unit)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 405
    //   4: ifeq +18 -> 22
    //   7: aload_1
    //   8: ldc_w 405
    //   11: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   14: dup
    //   15: astore_3
    //   16: checkcast 405	gnu/math/Unit
    //   19: goto +25 -> 44
    //   22: aload_1
    //   23: ldc_w 573
    //   26: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   29: dup
    //   30: ifnonnull +8 -> 38
    //   33: pop
    //   34: aconst_null
    //   35: goto +6 -> 41
    //   38: invokevirtual 576	java/lang/Object:toString	()Ljava/lang/String;
    //   41: invokestatic 580	gnu/math/Unit:lookup	(Ljava/lang/String;)Lgnu/math/NamedUnit;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnonnull +32 -> 78
    //   49: new 343	java/lang/IllegalArgumentException
    //   52: dup
    //   53: iconst_0
    //   54: iconst_2
    //   55: anewarray 250	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: ldc_w 582
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_1
    //   67: aastore
    //   68: invokestatic 526	gnu/kawa/functions/Format:formatToString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   71: invokevirtual 583	java/lang/String:toString	()Ljava/lang/String;
    //   74: invokespecial 529	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //   78: aload_0
    //   79: ldc 22
    //   81: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   84: dup
    //   85: astore_3
    //   86: checkcast 22	gnu/math/Quaternion
    //   89: aload_2
    //   90: invokestatic 411	gnu/math/Quantity:make	(Lgnu/math/Quaternion;Lgnu/math/Unit;)Lgnu/math/Quantity;
    //   93: areturn
    //   94: new 66	gnu/mapping/WrongType
    //   97: dup_x1
    //   98: swap
    //   99: ldc_w 571
    //   102: bipush -2
    //   104: aload_3
    //   105: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   108: athrow
    //   109: new 66	gnu/mapping/WrongType
    //   112: dup_x1
    //   113: swap
    //   114: ldc_w 585
    //   117: iconst_1
    //   118: aload_3
    //   119: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   122: athrow
    // Line number table:
    //   Java source line #558	-> byte code offset #0
    //   Java source line #559	-> byte code offset #0
    //   Java source line #560	-> byte code offset #0
    //   Java source line #561	-> byte code offset #22
    //   Java source line #562	-> byte code offset #45
    //   Java source line #563	-> byte code offset #49
    //   Java source line #564	-> byte code offset #53
    //   Java source line #565	-> byte code offset #78
    //   Java source line #560	-> byte code offset #94
    //   Java source line #565	-> byte code offset #109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	val	Object
    //   0	93	1	unit	Object
    //   44	46	2	u	Unit
    //   15	104	3	localObject	Object
    //   94	1	4	localClassCastException1	ClassCastException
    //   109	1	5	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   16	19	94	java/lang/ClassCastException
    //   86	89	109	java/lang/ClassCastException
  }
  
  public numbers()
  {
    ModuleInfo.register(this);
  }
  
  /* Error */
  public static Number lambda1(Number x, Number base)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 26
    //   4: ifeq +41 -> 45
    //   7: aload_1
    //   8: instanceof 26
    //   11: ifeq +34 -> 45
    //   14: getstatic 846	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   17: getstatic 379	kawa/lib/numbers:log	Lgnu/expr/GenericProc;
    //   20: aload_0
    //   21: invokevirtual 229	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: getstatic 379	kawa/lib/numbers:log	Lgnu/expr/GenericProc;
    //   27: aload_1
    //   28: invokevirtual 229	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   34: ldc 12
    //   36: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   39: checkcast 12	java/lang/Number
    //   42: goto +104 -> 146
    //   45: aload_0
    //   46: invokestatic 20	kawa/lib/numbers:isJava$DtLang$DtReal	(Ljava/lang/Object;)Z
    //   49: istore_2
    //   50: iload_2
    //   51: ifeq +10 -> 61
    //   54: iload_2
    //   55: ifeq +63 -> 118
    //   58: goto +10 -> 68
    //   61: aload_0
    //   62: instanceof 26
    //   65: ifeq +53 -> 118
    //   68: aload_1
    //   69: invokestatic 20	kawa/lib/numbers:isJava$DtLang$DtReal	(Ljava/lang/Object;)Z
    //   72: istore_3
    //   73: iload_3
    //   74: ifeq +10 -> 84
    //   77: iload_3
    //   78: ifeq +40 -> 118
    //   81: goto +10 -> 91
    //   84: aload_1
    //   85: instanceof 26
    //   88: ifeq +30 -> 118
    //   91: aload_0
    //   92: dup
    //   93: astore 4
    //   95: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   98: invokestatic 850	java/lang/Math:log	(D)D
    //   101: aload_1
    //   102: dup
    //   103: astore 4
    //   105: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   108: invokestatic 850	java/lang/Math:log	(D)D
    //   111: ddiv
    //   112: invokestatic 338	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   115: goto +31 -> 146
    //   118: getstatic 846	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   121: getstatic 379	kawa/lib/numbers:log	Lgnu/expr/GenericProc;
    //   124: aload_0
    //   125: invokevirtual 229	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: getstatic 379	kawa/lib/numbers:log	Lgnu/expr/GenericProc;
    //   131: aload_1
    //   132: invokevirtual 229	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   138: ldc 12
    //   140: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   143: checkcast 12	java/lang/Number
    //   146: areturn
    //   147: new 66	gnu/mapping/WrongType
    //   150: dup_x1
    //   151: swap
    //   152: ldc_w 848
    //   155: iconst_1
    //   156: aload 4
    //   158: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   161: athrow
    //   162: new 66	gnu/mapping/WrongType
    //   165: dup_x1
    //   166: swap
    //   167: ldc_w 848
    //   170: iconst_1
    //   171: aload 4
    //   173: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   176: athrow
    // Line number table:
    //   Java source line #258	-> byte code offset #0
    //   Java source line #260	-> byte code offset #0
    //   Java source line #261	-> byte code offset #14
    //   Java source line #262	-> byte code offset #45
    //   Java source line #263	-> byte code offset #68
    //   Java source line #264	-> byte code offset #91
    //   Java source line #265	-> byte code offset #118
    //   Java source line #264	-> byte code offset #147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	x	Number
    //   0	146	1	base	Number
    //   49	6	2	x	boolean
    //   72	6	3	x	boolean
    //   93	79	4	localNumber	Number
    //   147	1	5	localClassCastException1	ClassCastException
    //   162	1	6	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   95	98	147	java/lang/ClassCastException
    //   105	108	162	java/lang/ClassCastException
  }
  
  /* Error */
  public static Number lambda9(Number y, Number x)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 26
    //   4: ifeq +31 -> 35
    //   7: aload_1
    //   8: instanceof 26
    //   11: ifeq +24 -> 35
    //   14: new 52	gnu/math/DFloNum
    //   17: dup
    //   18: aload_0
    //   19: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   22: aload_1
    //   23: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   26: invokestatic 918	java/lang/Math:atan2	(DD)D
    //   29: invokespecial 364	gnu/math/DFloNum:<init>	(D)V
    //   32: goto +74 -> 106
    //   35: aload_0
    //   36: invokestatic 20	kawa/lib/numbers:isJava$DtLang$DtReal	(Ljava/lang/Object;)Z
    //   39: istore_2
    //   40: iload_2
    //   41: ifeq +10 -> 51
    //   44: iload_2
    //   45: ifeq +53 -> 98
    //   48: goto +10 -> 58
    //   51: aload_0
    //   52: instanceof 26
    //   55: ifeq +43 -> 98
    //   58: aload_1
    //   59: invokestatic 20	kawa/lib/numbers:isJava$DtLang$DtReal	(Ljava/lang/Object;)Z
    //   62: istore_3
    //   63: iload_3
    //   64: ifeq +10 -> 74
    //   67: iload_3
    //   68: ifeq +30 -> 98
    //   71: goto +10 -> 81
    //   74: aload_1
    //   75: instanceof 26
    //   78: ifeq +20 -> 98
    //   81: aload_0
    //   82: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   85: aload_1
    //   86: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   89: invokestatic 918	java/lang/Math:atan2	(DD)D
    //   92: invokestatic 338	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   95: goto +11 -> 106
    //   98: new 343	java/lang/IllegalArgumentException
    //   101: dup
    //   102: invokespecial 346	java/lang/IllegalArgumentException:<init>	()V
    //   105: athrow
    //   106: areturn
    // Line number table:
    //   Java source line #315	-> byte code offset #0
    //   Java source line #317	-> byte code offset #0
    //   Java source line #318	-> byte code offset #14
    //   Java source line #319	-> byte code offset #22
    //   Java source line #320	-> byte code offset #35
    //   Java source line #321	-> byte code offset #58
    //   Java source line #322	-> byte code offset #81
    //   Java source line #324	-> byte code offset #98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	y	Number
    //   0	106	1	x	Number
    //   40	58	2	x	boolean
    //   63	35	3	x	boolean
  }
  
  /* Error */
  public static Complex lambda11(Complex z)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 116	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: dup
    //   5: astore_3
    //   6: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   9: dstore_1
    //   10: aload_0
    //   11: invokestatic 97	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   14: dup
    //   15: astore 5
    //   17: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   20: dstore_3
    //   21: dload_1
    //   22: invokestatic 938	java/lang/Math:sinh	(D)D
    //   25: dload_3
    //   26: invokestatic 887	java/lang/Math:cos	(D)D
    //   29: dmul
    //   30: dload_1
    //   31: invokestatic 941	java/lang/Math:cosh	(D)D
    //   34: dload_3
    //   35: invokestatic 875	java/lang/Math:sin	(D)D
    //   38: dmul
    //   39: invokestatic 944	gnu/math/Complex:make	(DD)Lgnu/math/Complex;
    //   42: areturn
    //   43: new 66	gnu/mapping/WrongType
    //   46: dup_x1
    //   47: swap
    //   48: ldc_w 934
    //   51: bipush -2
    //   53: aload_3
    //   54: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   57: athrow
    //   58: new 66	gnu/mapping/WrongType
    //   61: dup_x1
    //   62: swap
    //   63: ldc_w 936
    //   66: bipush -2
    //   68: aload 5
    //   70: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    // Line number table:
    //   Java source line #338	-> byte code offset #0
    //   Java source line #340	-> byte code offset #0
    //   Java source line #341	-> byte code offset #10
    //   Java source line #342	-> byte code offset #21
    //   Java source line #343	-> byte code offset #30
    //   Java source line #340	-> byte code offset #43
    //   Java source line #341	-> byte code offset #58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	z	Complex
    //   9	1	1	d1	double
    //   21	10	1	x	double
    //   5	1	3	localNumber1	Number
    //   20	34	3	y	double
    //   15	54	5	localNumber2	Number
    //   43	1	6	localClassCastException1	ClassCastException
    //   58	1	7	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   6	9	43	java/lang/ClassCastException
    //   17	20	58	java/lang/ClassCastException
  }
  
  /* Error */
  public static Complex lambda14(Complex z)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 116	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: dup
    //   5: astore_3
    //   6: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   9: dstore_1
    //   10: aload_0
    //   11: invokestatic 97	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   14: dup
    //   15: astore 5
    //   17: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   20: dstore_3
    //   21: dload_1
    //   22: invokestatic 941	java/lang/Math:cosh	(D)D
    //   25: dload_3
    //   26: invokestatic 887	java/lang/Math:cos	(D)D
    //   29: dmul
    //   30: dload_1
    //   31: invokestatic 938	java/lang/Math:sinh	(D)D
    //   34: dload_3
    //   35: invokestatic 875	java/lang/Math:sin	(D)D
    //   38: dmul
    //   39: invokestatic 944	gnu/math/Complex:make	(DD)Lgnu/math/Complex;
    //   42: areturn
    //   43: new 66	gnu/mapping/WrongType
    //   46: dup_x1
    //   47: swap
    //   48: ldc_w 934
    //   51: bipush -2
    //   53: aload_3
    //   54: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   57: athrow
    //   58: new 66	gnu/mapping/WrongType
    //   61: dup_x1
    //   62: swap
    //   63: ldc_w 936
    //   66: bipush -2
    //   68: aload 5
    //   70: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    // Line number table:
    //   Java source line #352	-> byte code offset #0
    //   Java source line #354	-> byte code offset #0
    //   Java source line #355	-> byte code offset #10
    //   Java source line #356	-> byte code offset #21
    //   Java source line #357	-> byte code offset #30
    //   Java source line #354	-> byte code offset #43
    //   Java source line #355	-> byte code offset #58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	z	Complex
    //   9	1	1	d1	double
    //   21	10	1	x	double
    //   5	1	3	localNumber1	Number
    //   20	34	3	y	double
    //   15	54	5	localNumber2	Number
    //   43	1	6	localClassCastException1	ClassCastException
    //   58	1	7	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   6	9	43	java/lang/ClassCastException
    //   17	20	58	java/lang/ClassCastException
  }
  
  /* Error */
  public static Complex lambda17(Complex z)
  {
    // Byte code:
    //   0: getstatic 243	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   3: getstatic 952	kawa/lib/numbers:Lit45	Lgnu/math/IntNum;
    //   6: aload_0
    //   7: invokestatic 116	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   10: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: dup
    //   17: astore_3
    //   18: checkcast 12	java/lang/Number
    //   21: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   24: dstore_1
    //   25: getstatic 243	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   28: getstatic 952	kawa/lib/numbers:Lit45	Lgnu/math/IntNum;
    //   31: aload_0
    //   32: invokestatic 97	kawa/lib/numbers:imagPart	(Ljava/lang/Number;)Ljava/lang/Number;
    //   35: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: dup
    //   42: astore 5
    //   44: checkcast 12	java/lang/Number
    //   47: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   50: dstore_3
    //   51: dload_1
    //   52: invokestatic 941	java/lang/Math:cosh	(D)D
    //   55: dload_3
    //   56: invokestatic 887	java/lang/Math:cos	(D)D
    //   59: dadd
    //   60: dstore 5
    //   62: dload_1
    //   63: invokestatic 938	java/lang/Math:sinh	(D)D
    //   66: dload 5
    //   68: ddiv
    //   69: dload_3
    //   70: invokestatic 875	java/lang/Math:sin	(D)D
    //   73: dload 5
    //   75: ddiv
    //   76: invokestatic 944	gnu/math/Complex:make	(DD)Lgnu/math/Complex;
    //   79: areturn
    //   80: new 66	gnu/mapping/WrongType
    //   83: dup_x1
    //   84: swap
    //   85: ldc_w 934
    //   88: bipush -2
    //   90: aload_3
    //   91: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   94: athrow
    //   95: new 66	gnu/mapping/WrongType
    //   98: dup_x1
    //   99: swap
    //   100: ldc_w 936
    //   103: bipush -2
    //   105: aload 5
    //   107: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   110: athrow
    // Line number table:
    //   Java source line #366	-> byte code offset #0
    //   Java source line #368	-> byte code offset #0
    //   Java source line #369	-> byte code offset #25
    //   Java source line #370	-> byte code offset #51
    //   Java source line #371	-> byte code offset #55
    //   Java source line #372	-> byte code offset #62
    //   Java source line #373	-> byte code offset #69
    //   Java source line #368	-> byte code offset #80
    //   Java source line #369	-> byte code offset #95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	z	Complex
    //   24	1	1	d1	double
    //   51	12	1	x	double
    //   17	1	3	localObject1	Object
    //   50	41	3	y	double
    //   42	1	5	localObject2	Object
    //   60	46	5	w	double
    //   80	1	7	localClassCastException1	ClassCastException
    //   95	1	8	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   18	24	80	java/lang/ClassCastException
    //   44	50	95	java/lang/ClassCastException
  }
  
  /* Error */
  public static Quaternion lambda18(Quaternion q)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 948	kawa/lib/numbers:exp	(Ljava/lang/Number;)Ljava/lang/Number;
    //   4: dup
    //   5: astore_2
    //   6: checkcast 22	gnu/math/Quaternion
    //   9: astore_1
    //   10: getstatic 225	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   13: aload_0
    //   14: invokevirtual 229	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: ldc 12
    //   19: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   22: dup
    //   23: astore_3
    //   24: checkcast 12	java/lang/Number
    //   27: invokestatic 948	kawa/lib/numbers:exp	(Ljava/lang/Number;)Ljava/lang/Number;
    //   30: dup
    //   31: astore_3
    //   32: checkcast 22	gnu/math/Quaternion
    //   35: astore_2
    //   36: getstatic 846	gnu/kawa/functions/DivideOp:$Sl	Lgnu/kawa/functions/DivideOp;
    //   39: iconst_m1
    //   40: aload_1
    //   41: aload_2
    //   42: invokestatic 246	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   45: iconst_1
    //   46: aload_1
    //   47: aload_2
    //   48: invokestatic 246	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: ldc 22
    //   56: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   59: checkcast 22	gnu/math/Quaternion
    //   62: areturn
    //   63: new 66	gnu/mapping/WrongType
    //   66: dup_x1
    //   67: swap
    //   68: ldc_w 975
    //   71: bipush -2
    //   73: aload_2
    //   74: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   77: athrow
    //   78: new 66	gnu/mapping/WrongType
    //   81: dup_x1
    //   82: swap
    //   83: ldc_w 949
    //   86: iconst_0
    //   87: aload_3
    //   88: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   91: athrow
    //   92: new 66	gnu/mapping/WrongType
    //   95: dup_x1
    //   96: swap
    //   97: ldc_w 977
    //   100: bipush -2
    //   102: aload_3
    //   103: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   106: athrow
    // Line number table:
    //   Java source line #374	-> byte code offset #0
    //   Java source line #376	-> byte code offset #0
    //   Java source line #377	-> byte code offset #10
    //   Java source line #378	-> byte code offset #36
    //   Java source line #376	-> byte code offset #63
    //   Java source line #377	-> byte code offset #78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	q	Quaternion
    //   9	1	1	localQuaternion1	Quaternion
    //   36	11	1	e$Upq	Quaternion
    //   5	1	2	localNumber	Number
    //   35	39	2	e$Up$Mnq	Quaternion
    //   23	80	3	localObject	Object
    //   63	1	6	localClassCastException1	ClassCastException
    //   78	1	7	localClassCastException2	ClassCastException
    //   92	1	8	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   6	9	63	java/lang/ClassCastException
    //   24	27	78	java/lang/ClassCastException
    //   32	35	92	java/lang/ClassCastException
  }
  
  /* Error */
  public static Quaternion lambda22(Quaternion q)
  {
    // Byte code:
    //   0: getstatic 379	kawa/lib/numbers:log	Lgnu/expr/GenericProc;
    //   3: iconst_1
    //   4: aload_0
    //   5: getstatic 243	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   8: iconst_1
    //   9: aload_0
    //   10: getstatic 287	kawa/lib/numbers:Lit2	Lgnu/math/IntNum;
    //   13: invokestatic 246	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: ldc 12
    //   18: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   21: dup
    //   22: astore_1
    //   23: checkcast 12	java/lang/Number
    //   26: invokestatic 383	kawa/lib/numbers:sqrt	(Ljava/lang/Number;)Ljava/lang/Number;
    //   29: iconst_m1
    //   30: aload_0
    //   31: getstatic 287	kawa/lib/numbers:Lit2	Lgnu/math/IntNum;
    //   34: invokestatic 246	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   37: ldc 12
    //   39: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   42: dup
    //   43: astore_1
    //   44: checkcast 12	java/lang/Number
    //   47: invokestatic 383	kawa/lib/numbers:sqrt	(Ljava/lang/Number;)Ljava/lang/Number;
    //   50: invokevirtual 155	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: invokestatic 246	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   56: invokevirtual 229	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: ldc 22
    //   61: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   64: checkcast 22	gnu/math/Quaternion
    //   67: areturn
    //   68: new 66	gnu/mapping/WrongType
    //   71: dup_x1
    //   72: swap
    //   73: ldc_w 381
    //   76: iconst_0
    //   77: aload_1
    //   78: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   81: athrow
    //   82: new 66	gnu/mapping/WrongType
    //   85: dup_x1
    //   86: swap
    //   87: ldc_w 381
    //   90: iconst_0
    //   91: aload_1
    //   92: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   95: athrow
    // Line number table:
    //   Java source line #392	-> byte code offset #0
    //   Java source line #394	-> byte code offset #0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	q	Quaternion
    //   22	70	1	localObject	Object
    //   68	1	2	localClassCastException1	ClassCastException
    //   82	1	3	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   23	26	68	java/lang/ClassCastException
    //   44	47	82	java/lang/ClassCastException
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1240	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+2601->2605, 1:+2584->2588, 2:+2567->2571, 3:+2550->2554, 4:+2533->2537, 5:+2516->2520, 6:+2499->2503, 7:+2482->2486, 8:+2465->2469, 9:+2448->2452, 10:+2431->2435, 11:+2414->2418, 12:+2397->2401, 13:+2380->2384, 14:+2347->2351, 15:+2311->2315, 16:+2275->2279, 17:+2242->2246, 18:+2209->2213, 19:+2176->2180, 20:+2601->2605, 21:+2601->2605, 22:+2143->2147, 23:+2601->2605, 24:+2601->2605, 25:+2601->2605, 26:+2601->2605, 27:+2601->2605, 28:+2601->2605, 29:+2107->2111, 30:+2071->2075, 31:+2035->2039, 32:+1999->2003, 33:+1963->1967, 34:+1927->1931, 35:+2601->2605, 36:+1894->1898, 37:+2601->2605, 38:+1033->1037, 39:+1000->1004, 40:+980->984, 41:+947->951, 42:+927->931, 43:+894->898, 44:+874->878, 45:+1861->1865, 46:+1828->1832, 47:+2601->2605, 48:+841->845, 49:+808->812, 50:+775->779, 51:+755->759, 52:+722->726, 53:+689->693, 54:+669->673, 55:+636->640, 56:+603->607, 57:+583->587, 58:+550->554, 59:+530->534, 60:+497->501, 61:+477->481, 62:+444->448, 63:+424->428, 64:+1795->1799, 65:+1762->1766, 66:+2601->2605, 67:+2601->2605, 68:+2601->2605, 69:+2601->2605, 70:+1729->1733, 71:+1696->1700, 72:+1663->1667, 73:+1630->1634, 74:+1597->1601, 75:+1564->1568, 76:+1531->1535, 77:+1498->1502, 78:+1465->1469, 79:+1432->1436, 80:+1399->1403, 81:+2601->2605, 82:+2601->2605, 83:+2601->2605, 84:+2601->2605, 85:+2601->2605, 86:+2601->2605, 87:+2601->2605, 88:+1363->1367, 89:+1327->1331, 90:+1291->1295, 91:+1255->1259, 92:+2601->2605, 93:+2601->2605, 94:+1222->1226, 95:+2601->2605, 96:+1185->1189, 97:+2601->2605, 98:+1152->1156, 99:+1119->1123, 100:+2601->2605, 101:+1102->1106, 102:+1066->1070
    //   428: aload_3
    //   429: aload_2
    //   430: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   433: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   436: aload_3
    //   437: aload_1
    //   438: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   441: aload_3
    //   442: iconst_1
    //   443: putfield 1251	gnu/mapping/CallContext:pc	I
    //   446: iconst_0
    //   447: ireturn
    //   448: aload_3
    //   449: aload_2
    //   450: ldc 22
    //   452: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   455: dup
    //   456: instanceof 22
    //   459: ifne +7 -> 466
    //   462: ldc_w 1252
    //   465: ireturn
    //   466: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   469: aload_3
    //   470: aload_1
    //   471: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   474: aload_3
    //   475: iconst_1
    //   476: putfield 1251	gnu/mapping/CallContext:pc	I
    //   479: iconst_0
    //   480: ireturn
    //   481: aload_3
    //   482: aload_2
    //   483: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   486: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   489: aload_3
    //   490: aload_1
    //   491: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   494: aload_3
    //   495: iconst_1
    //   496: putfield 1251	gnu/mapping/CallContext:pc	I
    //   499: iconst_0
    //   500: ireturn
    //   501: aload_3
    //   502: aload_2
    //   503: ldc 22
    //   505: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   508: dup
    //   509: instanceof 22
    //   512: ifne +7 -> 519
    //   515: ldc_w 1252
    //   518: ireturn
    //   519: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   522: aload_3
    //   523: aload_1
    //   524: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   527: aload_3
    //   528: iconst_1
    //   529: putfield 1251	gnu/mapping/CallContext:pc	I
    //   532: iconst_0
    //   533: ireturn
    //   534: aload_3
    //   535: aload_2
    //   536: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   539: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   542: aload_3
    //   543: aload_1
    //   544: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   547: aload_3
    //   548: iconst_1
    //   549: putfield 1251	gnu/mapping/CallContext:pc	I
    //   552: iconst_0
    //   553: ireturn
    //   554: aload_3
    //   555: aload_2
    //   556: ldc 22
    //   558: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   561: dup
    //   562: instanceof 22
    //   565: ifne +7 -> 572
    //   568: ldc_w 1252
    //   571: ireturn
    //   572: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   575: aload_3
    //   576: aload_1
    //   577: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   580: aload_3
    //   581: iconst_1
    //   582: putfield 1251	gnu/mapping/CallContext:pc	I
    //   585: iconst_0
    //   586: ireturn
    //   587: aload_3
    //   588: aload_2
    //   589: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   592: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   595: aload_3
    //   596: aload_1
    //   597: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   600: aload_3
    //   601: iconst_1
    //   602: putfield 1251	gnu/mapping/CallContext:pc	I
    //   605: iconst_0
    //   606: ireturn
    //   607: aload_3
    //   608: aload_2
    //   609: ldc 22
    //   611: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   614: dup
    //   615: instanceof 22
    //   618: ifne +7 -> 625
    //   621: ldc_w 1252
    //   624: ireturn
    //   625: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   628: aload_3
    //   629: aload_1
    //   630: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   633: aload_3
    //   634: iconst_1
    //   635: putfield 1251	gnu/mapping/CallContext:pc	I
    //   638: iconst_0
    //   639: ireturn
    //   640: aload_3
    //   641: aload_2
    //   642: ldc 24
    //   644: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   647: dup
    //   648: instanceof 24
    //   651: ifne +7 -> 658
    //   654: ldc_w 1252
    //   657: ireturn
    //   658: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   661: aload_3
    //   662: aload_1
    //   663: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   666: aload_3
    //   667: iconst_1
    //   668: putfield 1251	gnu/mapping/CallContext:pc	I
    //   671: iconst_0
    //   672: ireturn
    //   673: aload_3
    //   674: aload_2
    //   675: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   678: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   681: aload_3
    //   682: aload_1
    //   683: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   686: aload_3
    //   687: iconst_1
    //   688: putfield 1251	gnu/mapping/CallContext:pc	I
    //   691: iconst_0
    //   692: ireturn
    //   693: aload_3
    //   694: aload_2
    //   695: ldc 22
    //   697: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   700: dup
    //   701: instanceof 22
    //   704: ifne +7 -> 711
    //   707: ldc_w 1252
    //   710: ireturn
    //   711: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   714: aload_3
    //   715: aload_1
    //   716: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   719: aload_3
    //   720: iconst_1
    //   721: putfield 1251	gnu/mapping/CallContext:pc	I
    //   724: iconst_0
    //   725: ireturn
    //   726: aload_3
    //   727: aload_2
    //   728: ldc 24
    //   730: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   733: dup
    //   734: instanceof 24
    //   737: ifne +7 -> 744
    //   740: ldc_w 1252
    //   743: ireturn
    //   744: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   747: aload_3
    //   748: aload_1
    //   749: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   752: aload_3
    //   753: iconst_1
    //   754: putfield 1251	gnu/mapping/CallContext:pc	I
    //   757: iconst_0
    //   758: ireturn
    //   759: aload_3
    //   760: aload_2
    //   761: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   764: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   767: aload_3
    //   768: aload_1
    //   769: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   772: aload_3
    //   773: iconst_1
    //   774: putfield 1251	gnu/mapping/CallContext:pc	I
    //   777: iconst_0
    //   778: ireturn
    //   779: aload_3
    //   780: aload_2
    //   781: ldc 22
    //   783: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   786: dup
    //   787: instanceof 22
    //   790: ifne +7 -> 797
    //   793: ldc_w 1252
    //   796: ireturn
    //   797: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   800: aload_3
    //   801: aload_1
    //   802: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   805: aload_3
    //   806: iconst_1
    //   807: putfield 1251	gnu/mapping/CallContext:pc	I
    //   810: iconst_0
    //   811: ireturn
    //   812: aload_3
    //   813: aload_2
    //   814: ldc 24
    //   816: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   819: dup
    //   820: instanceof 24
    //   823: ifne +7 -> 830
    //   826: ldc_w 1252
    //   829: ireturn
    //   830: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   833: aload_3
    //   834: aload_1
    //   835: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   838: aload_3
    //   839: iconst_1
    //   840: putfield 1251	gnu/mapping/CallContext:pc	I
    //   843: iconst_0
    //   844: ireturn
    //   845: aload_3
    //   846: aload_2
    //   847: ldc 12
    //   849: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   852: dup
    //   853: instanceof 12
    //   856: ifne +7 -> 863
    //   859: ldc_w 1252
    //   862: ireturn
    //   863: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   866: aload_3
    //   867: aload_1
    //   868: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   871: aload_3
    //   872: iconst_1
    //   873: putfield 1251	gnu/mapping/CallContext:pc	I
    //   876: iconst_0
    //   877: ireturn
    //   878: aload_3
    //   879: aload_2
    //   880: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   883: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   886: aload_3
    //   887: aload_1
    //   888: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   891: aload_3
    //   892: iconst_1
    //   893: putfield 1251	gnu/mapping/CallContext:pc	I
    //   896: iconst_0
    //   897: ireturn
    //   898: aload_3
    //   899: aload_2
    //   900: ldc 22
    //   902: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   905: dup
    //   906: instanceof 22
    //   909: ifne +7 -> 916
    //   912: ldc_w 1252
    //   915: ireturn
    //   916: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   919: aload_3
    //   920: aload_1
    //   921: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   924: aload_3
    //   925: iconst_1
    //   926: putfield 1251	gnu/mapping/CallContext:pc	I
    //   929: iconst_0
    //   930: ireturn
    //   931: aload_3
    //   932: aload_2
    //   933: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   936: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   939: aload_3
    //   940: aload_1
    //   941: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   944: aload_3
    //   945: iconst_1
    //   946: putfield 1251	gnu/mapping/CallContext:pc	I
    //   949: iconst_0
    //   950: ireturn
    //   951: aload_3
    //   952: aload_2
    //   953: ldc 22
    //   955: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   958: dup
    //   959: instanceof 22
    //   962: ifne +7 -> 969
    //   965: ldc_w 1252
    //   968: ireturn
    //   969: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   972: aload_3
    //   973: aload_1
    //   974: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   977: aload_3
    //   978: iconst_1
    //   979: putfield 1251	gnu/mapping/CallContext:pc	I
    //   982: iconst_0
    //   983: ireturn
    //   984: aload_3
    //   985: aload_2
    //   986: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   989: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   992: aload_3
    //   993: aload_1
    //   994: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   997: aload_3
    //   998: iconst_1
    //   999: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1002: iconst_0
    //   1003: ireturn
    //   1004: aload_3
    //   1005: aload_2
    //   1006: ldc 22
    //   1008: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1011: dup
    //   1012: instanceof 22
    //   1015: ifne +7 -> 1022
    //   1018: ldc_w 1252
    //   1021: ireturn
    //   1022: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1025: aload_3
    //   1026: aload_1
    //   1027: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1030: aload_3
    //   1031: iconst_1
    //   1032: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1035: iconst_0
    //   1036: ireturn
    //   1037: aload_3
    //   1038: aload_2
    //   1039: ldc 12
    //   1041: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1044: dup
    //   1045: instanceof 12
    //   1048: ifne +7 -> 1055
    //   1051: ldc_w 1252
    //   1054: ireturn
    //   1055: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1058: aload_3
    //   1059: aload_1
    //   1060: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1063: aload_3
    //   1064: iconst_1
    //   1065: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1068: iconst_0
    //   1069: ireturn
    //   1070: aload_3
    //   1071: aload_2
    //   1072: ldc 50
    //   1074: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1077: dup
    //   1078: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1081: ifnull +6 -> 1087
    //   1084: goto +7 -> 1091
    //   1087: ldc_w 1252
    //   1090: ireturn
    //   1091: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1094: aload_3
    //   1095: aload_1
    //   1096: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1099: aload_3
    //   1100: iconst_1
    //   1101: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1104: iconst_0
    //   1105: ireturn
    //   1106: aload_3
    //   1107: aload_2
    //   1108: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1111: aload_3
    //   1112: aload_1
    //   1113: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1116: aload_3
    //   1117: iconst_1
    //   1118: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1121: iconst_0
    //   1122: ireturn
    //   1123: aload_3
    //   1124: aload_2
    //   1125: ldc 14
    //   1127: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1130: dup
    //   1131: instanceof 14
    //   1134: ifne +7 -> 1141
    //   1137: ldc_w 1252
    //   1140: ireturn
    //   1141: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1144: aload_3
    //   1145: aload_1
    //   1146: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1149: aload_3
    //   1150: iconst_1
    //   1151: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1154: iconst_0
    //   1155: ireturn
    //   1156: aload_3
    //   1157: aload_2
    //   1158: ldc 14
    //   1160: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1163: dup
    //   1164: instanceof 14
    //   1167: ifne +7 -> 1174
    //   1170: ldc_w 1252
    //   1173: ireturn
    //   1174: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1177: aload_3
    //   1178: aload_1
    //   1179: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1182: aload_3
    //   1183: iconst_1
    //   1184: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1187: iconst_0
    //   1188: ireturn
    //   1189: aload_3
    //   1190: aload_2
    //   1191: ldc_w 1257
    //   1194: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1197: dup
    //   1198: instanceof 1257
    //   1201: ifeq +6 -> 1207
    //   1204: goto +7 -> 1211
    //   1207: ldc_w 1252
    //   1210: ireturn
    //   1211: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1214: aload_3
    //   1215: aload_1
    //   1216: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1219: aload_3
    //   1220: iconst_1
    //   1221: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1224: iconst_0
    //   1225: ireturn
    //   1226: aload_3
    //   1227: aload_2
    //   1228: ldc 12
    //   1230: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1233: dup
    //   1234: instanceof 12
    //   1237: ifne +7 -> 1244
    //   1240: ldc_w 1252
    //   1243: ireturn
    //   1244: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1247: aload_3
    //   1248: aload_1
    //   1249: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1252: aload_3
    //   1253: iconst_1
    //   1254: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1257: iconst_0
    //   1258: ireturn
    //   1259: aload_3
    //   1260: aload_2
    //   1261: ldc 50
    //   1263: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1266: dup
    //   1267: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1270: ifnull +6 -> 1276
    //   1273: goto +7 -> 1280
    //   1276: ldc_w 1252
    //   1279: ireturn
    //   1280: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1283: aload_3
    //   1284: aload_1
    //   1285: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1288: aload_3
    //   1289: iconst_1
    //   1290: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1293: iconst_0
    //   1294: ireturn
    //   1295: aload_3
    //   1296: aload_2
    //   1297: ldc 50
    //   1299: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1302: dup
    //   1303: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1306: ifnull +6 -> 1312
    //   1309: goto +7 -> 1316
    //   1312: ldc_w 1252
    //   1315: ireturn
    //   1316: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1319: aload_3
    //   1320: aload_1
    //   1321: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1324: aload_3
    //   1325: iconst_1
    //   1326: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1329: iconst_0
    //   1330: ireturn
    //   1331: aload_3
    //   1332: aload_2
    //   1333: ldc 50
    //   1335: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1338: dup
    //   1339: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1342: ifnull +6 -> 1348
    //   1345: goto +7 -> 1352
    //   1348: ldc_w 1252
    //   1351: ireturn
    //   1352: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1355: aload_3
    //   1356: aload_1
    //   1357: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1360: aload_3
    //   1361: iconst_1
    //   1362: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1365: iconst_0
    //   1366: ireturn
    //   1367: aload_3
    //   1368: aload_2
    //   1369: ldc 50
    //   1371: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1374: dup
    //   1375: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1378: ifnull +6 -> 1384
    //   1381: goto +7 -> 1388
    //   1384: ldc_w 1252
    //   1387: ireturn
    //   1388: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1391: aload_3
    //   1392: aload_1
    //   1393: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1396: aload_3
    //   1397: iconst_1
    //   1398: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1401: iconst_0
    //   1402: ireturn
    //   1403: aload_3
    //   1404: aload_2
    //   1405: ldc 12
    //   1407: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1410: dup
    //   1411: instanceof 12
    //   1414: ifne +7 -> 1421
    //   1417: ldc_w 1252
    //   1420: ireturn
    //   1421: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1424: aload_3
    //   1425: aload_1
    //   1426: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1429: aload_3
    //   1430: iconst_1
    //   1431: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1434: iconst_0
    //   1435: ireturn
    //   1436: aload_3
    //   1437: aload_2
    //   1438: ldc 12
    //   1440: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1443: dup
    //   1444: instanceof 12
    //   1447: ifne +7 -> 1454
    //   1450: ldc_w 1252
    //   1453: ireturn
    //   1454: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1457: aload_3
    //   1458: aload_1
    //   1459: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1462: aload_3
    //   1463: iconst_1
    //   1464: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1467: iconst_0
    //   1468: ireturn
    //   1469: aload_3
    //   1470: aload_2
    //   1471: ldc 12
    //   1473: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1476: dup
    //   1477: instanceof 12
    //   1480: ifne +7 -> 1487
    //   1483: ldc_w 1252
    //   1486: ireturn
    //   1487: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1490: aload_3
    //   1491: aload_1
    //   1492: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1495: aload_3
    //   1496: iconst_1
    //   1497: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1500: iconst_0
    //   1501: ireturn
    //   1502: aload_3
    //   1503: aload_2
    //   1504: ldc 12
    //   1506: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1509: dup
    //   1510: instanceof 12
    //   1513: ifne +7 -> 1520
    //   1516: ldc_w 1252
    //   1519: ireturn
    //   1520: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1523: aload_3
    //   1524: aload_1
    //   1525: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1528: aload_3
    //   1529: iconst_1
    //   1530: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1533: iconst_0
    //   1534: ireturn
    //   1535: aload_3
    //   1536: aload_2
    //   1537: ldc 12
    //   1539: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1542: dup
    //   1543: instanceof 12
    //   1546: ifne +7 -> 1553
    //   1549: ldc_w 1252
    //   1552: ireturn
    //   1553: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1556: aload_3
    //   1557: aload_1
    //   1558: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1561: aload_3
    //   1562: iconst_1
    //   1563: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1566: iconst_0
    //   1567: ireturn
    //   1568: aload_3
    //   1569: aload_2
    //   1570: ldc 12
    //   1572: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1575: dup
    //   1576: instanceof 12
    //   1579: ifne +7 -> 1586
    //   1582: ldc_w 1252
    //   1585: ireturn
    //   1586: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1589: aload_3
    //   1590: aload_1
    //   1591: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1594: aload_3
    //   1595: iconst_1
    //   1596: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1599: iconst_0
    //   1600: ireturn
    //   1601: aload_3
    //   1602: aload_2
    //   1603: ldc 12
    //   1605: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1608: dup
    //   1609: instanceof 12
    //   1612: ifne +7 -> 1619
    //   1615: ldc_w 1252
    //   1618: ireturn
    //   1619: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1622: aload_3
    //   1623: aload_1
    //   1624: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1627: aload_3
    //   1628: iconst_1
    //   1629: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1632: iconst_0
    //   1633: ireturn
    //   1634: aload_3
    //   1635: aload_2
    //   1636: ldc 12
    //   1638: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1641: dup
    //   1642: instanceof 12
    //   1645: ifne +7 -> 1652
    //   1648: ldc_w 1252
    //   1651: ireturn
    //   1652: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1655: aload_3
    //   1656: aload_1
    //   1657: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1660: aload_3
    //   1661: iconst_1
    //   1662: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1665: iconst_0
    //   1666: ireturn
    //   1667: aload_3
    //   1668: aload_2
    //   1669: ldc 12
    //   1671: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1674: dup
    //   1675: instanceof 12
    //   1678: ifne +7 -> 1685
    //   1681: ldc_w 1252
    //   1684: ireturn
    //   1685: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1688: aload_3
    //   1689: aload_1
    //   1690: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1693: aload_3
    //   1694: iconst_1
    //   1695: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1698: iconst_0
    //   1699: ireturn
    //   1700: aload_3
    //   1701: aload_2
    //   1702: ldc 12
    //   1704: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1707: dup
    //   1708: instanceof 12
    //   1711: ifne +7 -> 1718
    //   1714: ldc_w 1252
    //   1717: ireturn
    //   1718: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1721: aload_3
    //   1722: aload_1
    //   1723: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1726: aload_3
    //   1727: iconst_1
    //   1728: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1731: iconst_0
    //   1732: ireturn
    //   1733: aload_3
    //   1734: aload_2
    //   1735: ldc 12
    //   1737: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1740: dup
    //   1741: instanceof 12
    //   1744: ifne +7 -> 1751
    //   1747: ldc_w 1252
    //   1750: ireturn
    //   1751: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1754: aload_3
    //   1755: aload_1
    //   1756: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1759: aload_3
    //   1760: iconst_1
    //   1761: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1764: iconst_0
    //   1765: ireturn
    //   1766: aload_3
    //   1767: aload_2
    //   1768: ldc 12
    //   1770: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1773: dup
    //   1774: instanceof 12
    //   1777: ifne +7 -> 1784
    //   1780: ldc_w 1252
    //   1783: ireturn
    //   1784: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1787: aload_3
    //   1788: aload_1
    //   1789: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1792: aload_3
    //   1793: iconst_1
    //   1794: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1797: iconst_0
    //   1798: ireturn
    //   1799: aload_3
    //   1800: aload_2
    //   1801: ldc 12
    //   1803: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1806: dup
    //   1807: instanceof 12
    //   1810: ifne +7 -> 1817
    //   1813: ldc_w 1252
    //   1816: ireturn
    //   1817: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1820: aload_3
    //   1821: aload_1
    //   1822: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1825: aload_3
    //   1826: iconst_1
    //   1827: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1830: iconst_0
    //   1831: ireturn
    //   1832: aload_3
    //   1833: aload_2
    //   1834: ldc 12
    //   1836: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1839: dup
    //   1840: instanceof 12
    //   1843: ifne +7 -> 1850
    //   1846: ldc_w 1252
    //   1849: ireturn
    //   1850: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1853: aload_3
    //   1854: aload_1
    //   1855: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1858: aload_3
    //   1859: iconst_1
    //   1860: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1863: iconst_0
    //   1864: ireturn
    //   1865: aload_3
    //   1866: aload_2
    //   1867: ldc 12
    //   1869: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1872: dup
    //   1873: instanceof 12
    //   1876: ifne +7 -> 1883
    //   1879: ldc_w 1252
    //   1882: ireturn
    //   1883: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1886: aload_3
    //   1887: aload_1
    //   1888: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1891: aload_3
    //   1892: iconst_1
    //   1893: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1896: iconst_0
    //   1897: ireturn
    //   1898: aload_3
    //   1899: aload_2
    //   1900: ldc 12
    //   1902: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1905: dup
    //   1906: instanceof 12
    //   1909: ifne +7 -> 1916
    //   1912: ldc_w 1252
    //   1915: ireturn
    //   1916: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1919: aload_3
    //   1920: aload_1
    //   1921: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1924: aload_3
    //   1925: iconst_1
    //   1926: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1929: iconst_0
    //   1930: ireturn
    //   1931: aload_3
    //   1932: aload_2
    //   1933: ldc 26
    //   1935: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1938: dup
    //   1939: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1942: ifnull +6 -> 1948
    //   1945: goto +7 -> 1952
    //   1948: ldc_w 1252
    //   1951: ireturn
    //   1952: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1955: aload_3
    //   1956: aload_1
    //   1957: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1960: aload_3
    //   1961: iconst_1
    //   1962: putfield 1251	gnu/mapping/CallContext:pc	I
    //   1965: iconst_0
    //   1966: ireturn
    //   1967: aload_3
    //   1968: aload_2
    //   1969: ldc 26
    //   1971: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1974: dup
    //   1975: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1978: ifnull +6 -> 1984
    //   1981: goto +7 -> 1988
    //   1984: ldc_w 1252
    //   1987: ireturn
    //   1988: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1991: aload_3
    //   1992: aload_1
    //   1993: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1996: aload_3
    //   1997: iconst_1
    //   1998: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2001: iconst_0
    //   2002: ireturn
    //   2003: aload_3
    //   2004: aload_2
    //   2005: ldc 26
    //   2007: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2010: dup
    //   2011: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2014: ifnull +6 -> 2020
    //   2017: goto +7 -> 2024
    //   2020: ldc_w 1252
    //   2023: ireturn
    //   2024: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2027: aload_3
    //   2028: aload_1
    //   2029: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2032: aload_3
    //   2033: iconst_1
    //   2034: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2037: iconst_0
    //   2038: ireturn
    //   2039: aload_3
    //   2040: aload_2
    //   2041: ldc 26
    //   2043: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2046: dup
    //   2047: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2050: ifnull +6 -> 2056
    //   2053: goto +7 -> 2060
    //   2056: ldc_w 1252
    //   2059: ireturn
    //   2060: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2063: aload_3
    //   2064: aload_1
    //   2065: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2068: aload_3
    //   2069: iconst_1
    //   2070: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2073: iconst_0
    //   2074: ireturn
    //   2075: aload_3
    //   2076: aload_2
    //   2077: ldc 26
    //   2079: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2082: dup
    //   2083: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2086: ifnull +6 -> 2092
    //   2089: goto +7 -> 2096
    //   2092: ldc_w 1252
    //   2095: ireturn
    //   2096: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2099: aload_3
    //   2100: aload_1
    //   2101: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2104: aload_3
    //   2105: iconst_1
    //   2106: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2109: iconst_0
    //   2110: ireturn
    //   2111: aload_3
    //   2112: aload_2
    //   2113: ldc 26
    //   2115: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2118: dup
    //   2119: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2122: ifnull +6 -> 2128
    //   2125: goto +7 -> 2132
    //   2128: ldc_w 1252
    //   2131: ireturn
    //   2132: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2135: aload_3
    //   2136: aload_1
    //   2137: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2140: aload_3
    //   2141: iconst_1
    //   2142: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2145: iconst_0
    //   2146: ireturn
    //   2147: aload_3
    //   2148: aload_2
    //   2149: ldc 12
    //   2151: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2154: dup
    //   2155: instanceof 12
    //   2158: ifne +7 -> 2165
    //   2161: ldc_w 1252
    //   2164: ireturn
    //   2165: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2168: aload_3
    //   2169: aload_1
    //   2170: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2173: aload_3
    //   2174: iconst_1
    //   2175: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2178: iconst_0
    //   2179: ireturn
    //   2180: aload_3
    //   2181: aload_2
    //   2182: ldc 12
    //   2184: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2187: dup
    //   2188: instanceof 12
    //   2191: ifne +7 -> 2198
    //   2194: ldc_w 1252
    //   2197: ireturn
    //   2198: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2201: aload_3
    //   2202: aload_1
    //   2203: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2206: aload_3
    //   2207: iconst_1
    //   2208: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2211: iconst_0
    //   2212: ireturn
    //   2213: aload_3
    //   2214: aload_2
    //   2215: ldc 12
    //   2217: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2220: dup
    //   2221: instanceof 12
    //   2224: ifne +7 -> 2231
    //   2227: ldc_w 1252
    //   2230: ireturn
    //   2231: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2234: aload_3
    //   2235: aload_1
    //   2236: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2239: aload_3
    //   2240: iconst_1
    //   2241: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2244: iconst_0
    //   2245: ireturn
    //   2246: aload_3
    //   2247: aload_2
    //   2248: ldc 12
    //   2250: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2253: dup
    //   2254: instanceof 12
    //   2257: ifne +7 -> 2264
    //   2260: ldc_w 1252
    //   2263: ireturn
    //   2264: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2267: aload_3
    //   2268: aload_1
    //   2269: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2272: aload_3
    //   2273: iconst_1
    //   2274: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2277: iconst_0
    //   2278: ireturn
    //   2279: aload_3
    //   2280: aload_2
    //   2281: ldc 26
    //   2283: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2286: dup
    //   2287: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2290: ifnull +6 -> 2296
    //   2293: goto +7 -> 2300
    //   2296: ldc_w 1252
    //   2299: ireturn
    //   2300: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2303: aload_3
    //   2304: aload_1
    //   2305: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2308: aload_3
    //   2309: iconst_1
    //   2310: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2313: iconst_0
    //   2314: ireturn
    //   2315: aload_3
    //   2316: aload_2
    //   2317: ldc 26
    //   2319: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2322: dup
    //   2323: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2326: ifnull +6 -> 2332
    //   2329: goto +7 -> 2336
    //   2332: ldc_w 1252
    //   2335: ireturn
    //   2336: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2339: aload_3
    //   2340: aload_1
    //   2341: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2344: aload_3
    //   2345: iconst_1
    //   2346: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2349: iconst_0
    //   2350: ireturn
    //   2351: aload_3
    //   2352: aload_2
    //   2353: ldc 12
    //   2355: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2358: dup
    //   2359: instanceof 12
    //   2362: ifne +7 -> 2369
    //   2365: ldc_w 1252
    //   2368: ireturn
    //   2369: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2372: aload_3
    //   2373: aload_1
    //   2374: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2377: aload_3
    //   2378: iconst_1
    //   2379: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2382: iconst_0
    //   2383: ireturn
    //   2384: aload_3
    //   2385: aload_2
    //   2386: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2389: aload_3
    //   2390: aload_1
    //   2391: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2394: aload_3
    //   2395: iconst_1
    //   2396: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2399: iconst_0
    //   2400: ireturn
    //   2401: aload_3
    //   2402: aload_2
    //   2403: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2406: aload_3
    //   2407: aload_1
    //   2408: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2411: aload_3
    //   2412: iconst_1
    //   2413: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2416: iconst_0
    //   2417: ireturn
    //   2418: aload_3
    //   2419: aload_2
    //   2420: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2423: aload_3
    //   2424: aload_1
    //   2425: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2428: aload_3
    //   2429: iconst_1
    //   2430: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2433: iconst_0
    //   2434: ireturn
    //   2435: aload_3
    //   2436: aload_2
    //   2437: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2440: aload_3
    //   2441: aload_1
    //   2442: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2445: aload_3
    //   2446: iconst_1
    //   2447: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2450: iconst_0
    //   2451: ireturn
    //   2452: aload_3
    //   2453: aload_2
    //   2454: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2457: aload_3
    //   2458: aload_1
    //   2459: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2462: aload_3
    //   2463: iconst_1
    //   2464: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2467: iconst_0
    //   2468: ireturn
    //   2469: aload_3
    //   2470: aload_2
    //   2471: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2474: aload_3
    //   2475: aload_1
    //   2476: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2479: aload_3
    //   2480: iconst_1
    //   2481: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2484: iconst_0
    //   2485: ireturn
    //   2486: aload_3
    //   2487: aload_2
    //   2488: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2491: aload_3
    //   2492: aload_1
    //   2493: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2496: aload_3
    //   2497: iconst_1
    //   2498: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2501: iconst_0
    //   2502: ireturn
    //   2503: aload_3
    //   2504: aload_2
    //   2505: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2508: aload_3
    //   2509: aload_1
    //   2510: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2513: aload_3
    //   2514: iconst_1
    //   2515: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2518: iconst_0
    //   2519: ireturn
    //   2520: aload_3
    //   2521: aload_2
    //   2522: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2525: aload_3
    //   2526: aload_1
    //   2527: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2530: aload_3
    //   2531: iconst_1
    //   2532: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2535: iconst_0
    //   2536: ireturn
    //   2537: aload_3
    //   2538: aload_2
    //   2539: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2542: aload_3
    //   2543: aload_1
    //   2544: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2547: aload_3
    //   2548: iconst_1
    //   2549: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2552: iconst_0
    //   2553: ireturn
    //   2554: aload_3
    //   2555: aload_2
    //   2556: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2559: aload_3
    //   2560: aload_1
    //   2561: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2564: aload_3
    //   2565: iconst_1
    //   2566: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2569: iconst_0
    //   2570: ireturn
    //   2571: aload_3
    //   2572: aload_2
    //   2573: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2576: aload_3
    //   2577: aload_1
    //   2578: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2581: aload_3
    //   2582: iconst_1
    //   2583: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2586: iconst_0
    //   2587: ireturn
    //   2588: aload_3
    //   2589: aload_2
    //   2590: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   2593: aload_3
    //   2594: aload_1
    //   2595: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   2598: aload_3
    //   2599: iconst_1
    //   2600: putfield 1251	gnu/mapping/CallContext:pc	I
    //   2603: iconst_0
    //   2604: ireturn
    //   2605: aload_0
    //   2606: aload_1
    //   2607: aload_2
    //   2608: aload_3
    //   2609: invokespecial 1261	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   2612: ireturn
    // Line number table:
    //   Java source line #403	-> byte code offset #428
    //   Java source line #400	-> byte code offset #448
    //   Java source line #395	-> byte code offset #481
    //   Java source line #392	-> byte code offset #501
    //   Java source line #387	-> byte code offset #534
    //   Java source line #384	-> byte code offset #554
    //   Java source line #379	-> byte code offset #587
    //   Java source line #374	-> byte code offset #607
    //   Java source line #366	-> byte code offset #640
    //   Java source line #361	-> byte code offset #673
    //   Java source line #358	-> byte code offset #693
    //   Java source line #352	-> byte code offset #726
    //   Java source line #347	-> byte code offset #759
    //   Java source line #344	-> byte code offset #779
    //   Java source line #338	-> byte code offset #812
    //   Java source line #325	-> byte code offset #845
    //   Java source line #287	-> byte code offset #878
    //   Java source line #285	-> byte code offset #898
    //   Java source line #281	-> byte code offset #931
    //   Java source line #279	-> byte code offset #951
    //   Java source line #275	-> byte code offset #984
    //   Java source line #273	-> byte code offset #1004
    //   Java source line #266	-> byte code offset #1037
    //   Java source line #570	-> byte code offset #1070
    //   Java source line #567	-> byte code offset #1106
    //   Java source line #555	-> byte code offset #1123
    //   Java source line #548	-> byte code offset #1156
    //   Java source line #540	-> byte code offset #1189
    //   Java source line #532	-> byte code offset #1226
    //   Java source line #513	-> byte code offset #1259
    //   Java source line #510	-> byte code offset #1295
    //   Java source line #505	-> byte code offset #1331
    //   Java source line #501	-> byte code offset #1367
    //   Java source line #472	-> byte code offset #1403
    //   Java source line #469	-> byte code offset #1436
    //   Java source line #466	-> byte code offset #1469
    //   Java source line #463	-> byte code offset #1502
    //   Java source line #458	-> byte code offset #1535
    //   Java source line #455	-> byte code offset #1568
    //   Java source line #450	-> byte code offset #1601
    //   Java source line #445	-> byte code offset #1634
    //   Java source line #440	-> byte code offset #1667
    //   Java source line #435	-> byte code offset #1700
    //   Java source line #430	-> byte code offset #1733
    //   Java source line #415	-> byte code offset #1766
    //   Java source line #407	-> byte code offset #1799
    //   Java source line #302	-> byte code offset #1832
    //   Java source line #290	-> byte code offset #1865
    //   Java source line #252	-> byte code offset #1898
    //   Java source line #244	-> byte code offset #1931
    //   Java source line #241	-> byte code offset #1967
    //   Java source line #238	-> byte code offset #2003
    //   Java source line #235	-> byte code offset #2039
    //   Java source line #230	-> byte code offset #2075
    //   Java source line #225	-> byte code offset #2111
    //   Java source line #163	-> byte code offset #2147
    //   Java source line #140	-> byte code offset #2180
    //   Java source line #129	-> byte code offset #2213
    //   Java source line #121	-> byte code offset #2246
    //   Java source line #118	-> byte code offset #2279
    //   Java source line #115	-> byte code offset #2315
    //   Java source line #105	-> byte code offset #2351
    //   Java source line #101	-> byte code offset #2384
    //   Java source line #97	-> byte code offset #2401
    //   Java source line #90	-> byte code offset #2418
    //   Java source line #84	-> byte code offset #2435
    //   Java source line #78	-> byte code offset #2452
    //   Java source line #69	-> byte code offset #2469
    //   Java source line #44	-> byte code offset #2486
    //   Java source line #34	-> byte code offset #2503
    //   Java source line #31	-> byte code offset #2520
    //   Java source line #28	-> byte code offset #2537
    //   Java source line #25	-> byte code offset #2554
    //   Java source line #22	-> byte code offset #2571
    //   Java source line #21	-> byte code offset #2588
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1240	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+888->892, 23:+824->828, 24:+760->764, 25:+696->700, 26:+632->636, 35:+568->572, 37:+278->282, 47:+220->224, 66:+156->160, 68:+124->128, 82:+520->524, 87:+456->460, 94:+411->415, 96:+362->366, 100:+336->340
    //   128: aload 4
    //   130: aload_2
    //   131: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   134: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   137: aload 4
    //   139: aload_3
    //   140: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   143: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   146: aload 4
    //   148: aload_1
    //   149: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   152: aload 4
    //   154: iconst_2
    //   155: putfield 1251	gnu/mapping/CallContext:pc	I
    //   158: iconst_0
    //   159: ireturn
    //   160: aload 4
    //   162: aload_2
    //   163: ldc 26
    //   165: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   168: dup
    //   169: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   172: ifnull +6 -> 178
    //   175: goto +7 -> 182
    //   178: ldc_w 1252
    //   181: ireturn
    //   182: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   185: aload 4
    //   187: aload_3
    //   188: ldc 26
    //   190: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   193: dup
    //   194: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   197: ifnull +6 -> 203
    //   200: goto +7 -> 207
    //   203: ldc_w 1265
    //   206: ireturn
    //   207: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   210: aload 4
    //   212: aload_1
    //   213: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   216: aload 4
    //   218: iconst_2
    //   219: putfield 1251	gnu/mapping/CallContext:pc	I
    //   222: iconst_0
    //   223: ireturn
    //   224: aload 4
    //   226: aload_2
    //   227: ldc 12
    //   229: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   232: dup
    //   233: instanceof 12
    //   236: ifne +7 -> 243
    //   239: ldc_w 1252
    //   242: ireturn
    //   243: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   246: aload 4
    //   248: aload_3
    //   249: ldc 12
    //   251: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   254: dup
    //   255: instanceof 12
    //   258: ifne +7 -> 265
    //   261: ldc_w 1265
    //   264: ireturn
    //   265: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   268: aload 4
    //   270: aload_1
    //   271: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   274: aload 4
    //   276: iconst_2
    //   277: putfield 1251	gnu/mapping/CallContext:pc	I
    //   280: iconst_0
    //   281: ireturn
    //   282: aload 4
    //   284: aload_2
    //   285: ldc 12
    //   287: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   290: dup
    //   291: instanceof 12
    //   294: ifne +7 -> 301
    //   297: ldc_w 1252
    //   300: ireturn
    //   301: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   304: aload 4
    //   306: aload_3
    //   307: ldc 12
    //   309: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   312: dup
    //   313: instanceof 12
    //   316: ifne +7 -> 323
    //   319: ldc_w 1265
    //   322: ireturn
    //   323: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   326: aload 4
    //   328: aload_1
    //   329: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   332: aload 4
    //   334: iconst_2
    //   335: putfield 1251	gnu/mapping/CallContext:pc	I
    //   338: iconst_0
    //   339: ireturn
    //   340: aload 4
    //   342: aload_2
    //   343: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   346: aload 4
    //   348: aload_3
    //   349: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   352: aload 4
    //   354: aload_1
    //   355: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   358: aload 4
    //   360: iconst_2
    //   361: putfield 1251	gnu/mapping/CallContext:pc	I
    //   364: iconst_0
    //   365: ireturn
    //   366: aload 4
    //   368: aload_2
    //   369: ldc_w 1257
    //   372: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   375: dup
    //   376: instanceof 1257
    //   379: ifeq +6 -> 385
    //   382: goto +7 -> 389
    //   385: ldc_w 1252
    //   388: ireturn
    //   389: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   392: aload 4
    //   394: aload_3
    //   395: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   398: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   401: aload 4
    //   403: aload_1
    //   404: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   407: aload 4
    //   409: iconst_2
    //   410: putfield 1251	gnu/mapping/CallContext:pc	I
    //   413: iconst_0
    //   414: ireturn
    //   415: aload 4
    //   417: aload_2
    //   418: ldc 12
    //   420: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   423: dup
    //   424: instanceof 12
    //   427: ifne +7 -> 434
    //   430: ldc_w 1252
    //   433: ireturn
    //   434: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   437: aload 4
    //   439: aload_3
    //   440: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   443: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   446: aload 4
    //   448: aload_1
    //   449: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   452: aload 4
    //   454: iconst_2
    //   455: putfield 1251	gnu/mapping/CallContext:pc	I
    //   458: iconst_0
    //   459: ireturn
    //   460: aload 4
    //   462: aload_2
    //   463: ldc 50
    //   465: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   468: dup
    //   469: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   472: ifnull +6 -> 478
    //   475: goto +7 -> 482
    //   478: ldc_w 1252
    //   481: ireturn
    //   482: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   485: aload 4
    //   487: aload_3
    //   488: ldc 50
    //   490: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   493: dup
    //   494: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   497: ifnull +6 -> 503
    //   500: goto +7 -> 507
    //   503: ldc_w 1265
    //   506: ireturn
    //   507: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   510: aload 4
    //   512: aload_1
    //   513: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   516: aload 4
    //   518: iconst_2
    //   519: putfield 1251	gnu/mapping/CallContext:pc	I
    //   522: iconst_0
    //   523: ireturn
    //   524: aload 4
    //   526: aload_2
    //   527: ldc 50
    //   529: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   532: dup
    //   533: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   536: ifnull +6 -> 542
    //   539: goto +7 -> 546
    //   542: ldc_w 1252
    //   545: ireturn
    //   546: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   549: aload 4
    //   551: aload_3
    //   552: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   555: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   558: aload 4
    //   560: aload_1
    //   561: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   564: aload 4
    //   566: iconst_2
    //   567: putfield 1251	gnu/mapping/CallContext:pc	I
    //   570: iconst_0
    //   571: ireturn
    //   572: aload 4
    //   574: aload_2
    //   575: ldc 26
    //   577: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   580: dup
    //   581: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   584: ifnull +6 -> 590
    //   587: goto +7 -> 594
    //   590: ldc_w 1252
    //   593: ireturn
    //   594: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   597: aload 4
    //   599: aload_3
    //   600: ldc 26
    //   602: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   605: dup
    //   606: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   609: ifnull +6 -> 615
    //   612: goto +7 -> 619
    //   615: ldc_w 1265
    //   618: ireturn
    //   619: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   622: aload 4
    //   624: aload_1
    //   625: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   628: aload 4
    //   630: iconst_2
    //   631: putfield 1251	gnu/mapping/CallContext:pc	I
    //   634: iconst_0
    //   635: ireturn
    //   636: aload 4
    //   638: aload_2
    //   639: ldc 26
    //   641: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   644: dup
    //   645: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   648: ifnull +6 -> 654
    //   651: goto +7 -> 658
    //   654: ldc_w 1252
    //   657: ireturn
    //   658: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   661: aload 4
    //   663: aload_3
    //   664: ldc 26
    //   666: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   669: dup
    //   670: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   673: ifnull +6 -> 679
    //   676: goto +7 -> 683
    //   679: ldc_w 1265
    //   682: ireturn
    //   683: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   686: aload 4
    //   688: aload_1
    //   689: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   692: aload 4
    //   694: iconst_2
    //   695: putfield 1251	gnu/mapping/CallContext:pc	I
    //   698: iconst_0
    //   699: ireturn
    //   700: aload 4
    //   702: aload_2
    //   703: ldc 26
    //   705: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   708: dup
    //   709: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   712: ifnull +6 -> 718
    //   715: goto +7 -> 722
    //   718: ldc_w 1252
    //   721: ireturn
    //   722: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   725: aload 4
    //   727: aload_3
    //   728: ldc 26
    //   730: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   733: dup
    //   734: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   737: ifnull +6 -> 743
    //   740: goto +7 -> 747
    //   743: ldc_w 1265
    //   746: ireturn
    //   747: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   750: aload 4
    //   752: aload_1
    //   753: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   756: aload 4
    //   758: iconst_2
    //   759: putfield 1251	gnu/mapping/CallContext:pc	I
    //   762: iconst_0
    //   763: ireturn
    //   764: aload 4
    //   766: aload_2
    //   767: ldc 26
    //   769: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   772: dup
    //   773: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   776: ifnull +6 -> 782
    //   779: goto +7 -> 786
    //   782: ldc_w 1252
    //   785: ireturn
    //   786: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   789: aload 4
    //   791: aload_3
    //   792: ldc 26
    //   794: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   797: dup
    //   798: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   801: ifnull +6 -> 807
    //   804: goto +7 -> 811
    //   807: ldc_w 1265
    //   810: ireturn
    //   811: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   814: aload 4
    //   816: aload_1
    //   817: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   820: aload 4
    //   822: iconst_2
    //   823: putfield 1251	gnu/mapping/CallContext:pc	I
    //   826: iconst_0
    //   827: ireturn
    //   828: aload 4
    //   830: aload_2
    //   831: ldc 26
    //   833: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   836: dup
    //   837: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   840: ifnull +6 -> 846
    //   843: goto +7 -> 850
    //   846: ldc_w 1252
    //   849: ireturn
    //   850: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   853: aload 4
    //   855: aload_3
    //   856: ldc 26
    //   858: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   861: dup
    //   862: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   865: ifnull +6 -> 871
    //   868: goto +7 -> 875
    //   871: ldc_w 1265
    //   874: ireturn
    //   875: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   878: aload 4
    //   880: aload_1
    //   881: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   884: aload 4
    //   886: iconst_2
    //   887: putfield 1251	gnu/mapping/CallContext:pc	I
    //   890: iconst_0
    //   891: ireturn
    //   892: aload_0
    //   893: aload_1
    //   894: aload_2
    //   895: aload_3
    //   896: aload 4
    //   898: invokespecial 1269	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   901: ireturn
    // Line number table:
    //   Java source line #425	-> byte code offset #128
    //   Java source line #419	-> byte code offset #160
    //   Java source line #315	-> byte code offset #224
    //   Java source line #258	-> byte code offset #282
    //   Java source line #558	-> byte code offset #340
    //   Java source line #540	-> byte code offset #366
    //   Java source line #532	-> byte code offset #415
    //   Java source line #498	-> byte code offset #460
    //   Java source line #478	-> byte code offset #524
    //   Java source line #247	-> byte code offset #572
    //   Java source line #186	-> byte code offset #636
    //   Java source line #181	-> byte code offset #700
    //   Java source line #176	-> byte code offset #764
    //   Java source line #171	-> byte code offset #828
  }
  
  /* Error */
  public int match3(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1240	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+390->394, 81:+316->320, 83:+258->262, 85:+200->204, 86:+110->114, 93:+52->56
    //   56: aload 5
    //   58: aload_2
    //   59: ldc 50
    //   61: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   64: dup
    //   65: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   68: ifnull +6 -> 74
    //   71: goto +7 -> 78
    //   74: ldc_w 1252
    //   77: ireturn
    //   78: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   81: aload 5
    //   83: aload_3
    //   84: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   87: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   90: aload 5
    //   92: aload 4
    //   94: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: putfield 1272	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   100: aload 5
    //   102: aload_1
    //   103: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   106: aload 5
    //   108: iconst_3
    //   109: putfield 1251	gnu/mapping/CallContext:pc	I
    //   112: iconst_0
    //   113: ireturn
    //   114: aload 5
    //   116: aload_2
    //   117: ldc 50
    //   119: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   122: dup
    //   123: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   126: ifnull +6 -> 132
    //   129: goto +7 -> 136
    //   132: ldc_w 1252
    //   135: ireturn
    //   136: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   139: aload 5
    //   141: aload_3
    //   142: ldc 50
    //   144: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   147: dup
    //   148: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   151: ifnull +6 -> 157
    //   154: goto +7 -> 161
    //   157: ldc_w 1265
    //   160: ireturn
    //   161: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   164: aload 5
    //   166: aload 4
    //   168: ldc 50
    //   170: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   173: dup
    //   174: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   177: ifnull +6 -> 183
    //   180: goto +7 -> 187
    //   183: ldc_w 1273
    //   186: ireturn
    //   187: putfield 1272	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   190: aload 5
    //   192: aload_1
    //   193: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   196: aload 5
    //   198: iconst_3
    //   199: putfield 1251	gnu/mapping/CallContext:pc	I
    //   202: iconst_0
    //   203: ireturn
    //   204: aload 5
    //   206: aload_2
    //   207: ldc 50
    //   209: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   212: dup
    //   213: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   216: ifnull +6 -> 222
    //   219: goto +7 -> 226
    //   222: ldc_w 1252
    //   225: ireturn
    //   226: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   229: aload 5
    //   231: aload_3
    //   232: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   235: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   238: aload 5
    //   240: aload 4
    //   242: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   245: putfield 1272	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   248: aload 5
    //   250: aload_1
    //   251: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   254: aload 5
    //   256: iconst_3
    //   257: putfield 1251	gnu/mapping/CallContext:pc	I
    //   260: iconst_0
    //   261: ireturn
    //   262: aload 5
    //   264: aload_2
    //   265: ldc 50
    //   267: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   270: dup
    //   271: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   274: ifnull +6 -> 280
    //   277: goto +7 -> 284
    //   280: ldc_w 1252
    //   283: ireturn
    //   284: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   287: aload 5
    //   289: aload_3
    //   290: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   293: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   296: aload 5
    //   298: aload 4
    //   300: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   303: putfield 1272	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   306: aload 5
    //   308: aload_1
    //   309: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   312: aload 5
    //   314: iconst_3
    //   315: putfield 1251	gnu/mapping/CallContext:pc	I
    //   318: iconst_0
    //   319: ireturn
    //   320: aload 5
    //   322: aload_2
    //   323: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   326: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   329: aload 5
    //   331: aload_3
    //   332: ldc 50
    //   334: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   337: dup
    //   338: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   341: ifnull +6 -> 347
    //   344: goto +7 -> 351
    //   347: ldc_w 1265
    //   350: ireturn
    //   351: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   354: aload 5
    //   356: aload 4
    //   358: ldc 50
    //   360: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   363: dup
    //   364: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   367: ifnull +6 -> 373
    //   370: goto +7 -> 377
    //   373: ldc_w 1273
    //   376: ireturn
    //   377: putfield 1272	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   380: aload 5
    //   382: aload_1
    //   383: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   386: aload 5
    //   388: iconst_3
    //   389: putfield 1251	gnu/mapping/CallContext:pc	I
    //   392: iconst_0
    //   393: ireturn
    //   394: aload_0
    //   395: aload_1
    //   396: aload_2
    //   397: aload_3
    //   398: aload 4
    //   400: aload 5
    //   402: invokespecial 1277	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   405: ireturn
    // Line number table:
    //   Java source line #529	-> byte code offset #56
    //   Java source line #494	-> byte code offset #114
    //   Java source line #490	-> byte code offset #204
    //   Java source line #481	-> byte code offset #262
    //   Java source line #475	-> byte code offset #320
  }
  
  /* Error */
  public int match4(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1240	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+364->368, 67:+96->100, 69:+44->48, 84:+280->284, 92:+212->216
    //   48: aload 6
    //   50: aload_2
    //   51: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   57: aload 6
    //   59: aload_3
    //   60: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   66: aload 6
    //   68: aload 4
    //   70: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: putfield 1272	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   76: aload 6
    //   78: aload 5
    //   80: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: putfield 1280	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   86: aload 6
    //   88: aload_1
    //   89: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   92: aload 6
    //   94: iconst_4
    //   95: putfield 1251	gnu/mapping/CallContext:pc	I
    //   98: iconst_0
    //   99: ireturn
    //   100: aload 6
    //   102: aload_2
    //   103: ldc 26
    //   105: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   108: dup
    //   109: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   112: ifnull +6 -> 118
    //   115: goto +7 -> 122
    //   118: ldc_w 1252
    //   121: ireturn
    //   122: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   125: aload 6
    //   127: aload_3
    //   128: ldc 26
    //   130: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   133: dup
    //   134: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   137: ifnull +6 -> 143
    //   140: goto +7 -> 147
    //   143: ldc_w 1265
    //   146: ireturn
    //   147: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   150: aload 6
    //   152: aload 4
    //   154: ldc 26
    //   156: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   159: dup
    //   160: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   163: ifnull +6 -> 169
    //   166: goto +7 -> 173
    //   169: ldc_w 1273
    //   172: ireturn
    //   173: putfield 1272	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   176: aload 6
    //   178: aload 5
    //   180: ldc 26
    //   182: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   185: dup
    //   186: invokestatic 30	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   189: ifnull +6 -> 195
    //   192: goto +7 -> 199
    //   195: ldc_w 1281
    //   198: ireturn
    //   199: putfield 1280	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   202: aload 6
    //   204: aload_1
    //   205: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   208: aload 6
    //   210: iconst_4
    //   211: putfield 1251	gnu/mapping/CallContext:pc	I
    //   214: iconst_0
    //   215: ireturn
    //   216: aload 6
    //   218: aload_2
    //   219: ldc 50
    //   221: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   224: dup
    //   225: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   228: ifnull +6 -> 234
    //   231: goto +7 -> 238
    //   234: ldc_w 1252
    //   237: ireturn
    //   238: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   241: aload 6
    //   243: aload_3
    //   244: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   247: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   250: aload 6
    //   252: aload 4
    //   254: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   257: putfield 1272	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   260: aload 6
    //   262: aload 5
    //   264: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   267: putfield 1280	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   270: aload 6
    //   272: aload_1
    //   273: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   276: aload 6
    //   278: iconst_4
    //   279: putfield 1251	gnu/mapping/CallContext:pc	I
    //   282: iconst_0
    //   283: ireturn
    //   284: aload 6
    //   286: aload_2
    //   287: ldc 50
    //   289: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   292: dup
    //   293: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   296: ifnull +6 -> 302
    //   299: goto +7 -> 306
    //   302: ldc_w 1252
    //   305: ireturn
    //   306: putfield 1244	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   309: aload 6
    //   311: aload_3
    //   312: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   315: putfield 1264	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   318: aload 6
    //   320: aload 4
    //   322: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   325: putfield 1272	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   328: aload 6
    //   330: aload 5
    //   332: ldc 50
    //   334: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   337: dup
    //   338: invokestatic 1255	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   341: ifnull +6 -> 347
    //   344: goto +7 -> 351
    //   347: ldc_w 1281
    //   350: ireturn
    //   351: putfield 1280	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   354: aload 6
    //   356: aload_1
    //   357: putfield 1248	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   360: aload 6
    //   362: iconst_4
    //   363: putfield 1251	gnu/mapping/CallContext:pc	I
    //   366: iconst_0
    //   367: ireturn
    //   368: aload_0
    //   369: aload_1
    //   370: aload_2
    //   371: aload_3
    //   372: aload 4
    //   374: aload 5
    //   376: aload 6
    //   378: invokespecial 1285	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   381: ireturn
    // Line number table:
    //   Java source line #427	-> byte code offset #48
    //   Java source line #421	-> byte code offset #100
    //   Java source line #516	-> byte code offset #216
    //   Java source line #485	-> byte code offset #284
  }
  
  public void apply(CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1240	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+446->450, 23:+124->128, 24:+146->150, 25:+168->172, 26:+190->194, 35:+212->216, 37:+356->360, 47:+378->382, 66:+400->404, 68:+422->426, 82:+234->238, 87:+269->273, 94:+303->307, 96:+326->330, 100:+350->354
    //   128: aload_2
    //   129: ldc 26
    //   131: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   134: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   137: aload_3
    //   138: ldc 26
    //   140: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   143: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   146: invokestatic 1523	kawa/lib/numbers:floor$Sl	(Lgnu/math/RealNum;Lgnu/math/RealNum;)Ljava/lang/Object;
    //   149: areturn
    //   150: aload_2
    //   151: ldc 26
    //   153: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   156: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   159: aload_3
    //   160: ldc 26
    //   162: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   165: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   168: invokestatic 1527	kawa/lib/numbers:truncate$Sl	(Lgnu/math/RealNum;Lgnu/math/RealNum;)Ljava/lang/Object;
    //   171: areturn
    //   172: aload_2
    //   173: ldc 26
    //   175: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   178: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   181: aload_3
    //   182: ldc 26
    //   184: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   187: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   190: invokestatic 1532	kawa/lib/numbers:divAndMod	(Lgnu/math/RealNum;Lgnu/math/RealNum;)Ljava/lang/Object;
    //   193: areturn
    //   194: aload_2
    //   195: ldc 26
    //   197: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   200: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   203: aload_3
    //   204: ldc 26
    //   206: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   209: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   212: invokestatic 1537	kawa/lib/numbers:div0AndMod0	(Lgnu/math/RealNum;Lgnu/math/RealNum;)Ljava/lang/Object;
    //   215: areturn
    //   216: aload_2
    //   217: ldc 26
    //   219: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   222: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   225: aload_3
    //   226: ldc 26
    //   228: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   231: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   234: invokestatic 1539	kawa/lib/numbers:rationalize	(Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   237: areturn
    //   238: aload_2
    //   239: ldc 50
    //   241: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   244: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   247: aload_3
    //   248: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   251: checkcast 12	java/lang/Number
    //   254: invokevirtual 1544	java/lang/Number:intValue	()I
    //   257: invokestatic 1547	kawa/lib/numbers:isBitwiseBitSet	(Lgnu/math/IntNum;I)Z
    //   260: ifeq +9 -> 269
    //   263: getstatic 1301	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   266: goto +6 -> 272
    //   269: getstatic 553	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   272: areturn
    //   273: aload_2
    //   274: ldc 50
    //   276: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   279: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   282: aload_3
    //   283: ldc 50
    //   285: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   288: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   291: invokestatic 1550	kawa/lib/numbers:logtest	(Lgnu/math/IntNum;Lgnu/math/IntNum;)Z
    //   294: ifeq +9 -> 303
    //   297: getstatic 1301	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   300: goto +6 -> 306
    //   303: getstatic 553	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   306: areturn
    //   307: aload_2
    //   308: ldc 12
    //   310: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   313: checkcast 12	java/lang/Number
    //   316: aload_3
    //   317: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   320: checkcast 12	java/lang/Number
    //   323: invokevirtual 1544	java/lang/Number:intValue	()I
    //   326: invokestatic 515	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;I)Ljava/lang/CharSequence;
    //   329: areturn
    //   330: aload_2
    //   331: ldc_w 1257
    //   334: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   337: checkcast 1257	java/lang/CharSequence
    //   340: aload_3
    //   341: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   344: checkcast 12	java/lang/Number
    //   347: invokevirtual 1544	java/lang/Number:intValue	()I
    //   350: invokestatic 542	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;I)Ljava/lang/Object;
    //   353: areturn
    //   354: aload_2
    //   355: aload_3
    //   356: invokestatic 1554	kawa/lib/numbers:makeQuantity	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/math/Quantity;
    //   359: areturn
    //   360: aload_2
    //   361: ldc 12
    //   363: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   366: checkcast 12	java/lang/Number
    //   369: aload_3
    //   370: ldc 12
    //   372: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   375: checkcast 12	java/lang/Number
    //   378: invokestatic 1558	kawa/lib/numbers:lambda1	(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
    //   381: areturn
    //   382: aload_2
    //   383: ldc 12
    //   385: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   388: checkcast 12	java/lang/Number
    //   391: aload_3
    //   392: ldc 12
    //   394: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   397: checkcast 12	java/lang/Number
    //   400: invokestatic 1561	kawa/lib/numbers:lambda9	(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
    //   403: areturn
    //   404: aload_2
    //   405: ldc 26
    //   407: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   410: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   413: aload_3
    //   414: ldc 26
    //   416: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   419: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   422: invokestatic 1564	kawa/lib/numbers:lambda26	(Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Complex;
    //   425: areturn
    //   426: aload_2
    //   427: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   430: checkcast 12	java/lang/Number
    //   433: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   436: aload_3
    //   437: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   440: checkcast 12	java/lang/Number
    //   443: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   446: invokestatic 1567	kawa/lib/numbers:lambda28	(DD)Lgnu/math/Complex;
    //   449: areturn
    //   450: aload_0
    //   451: aload_1
    //   452: aload_2
    //   453: aload_3
    //   454: invokespecial 1570	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   457: areturn
    //   458: new 66	gnu/mapping/WrongType
    //   461: dup_x1
    //   462: swap
    //   463: ldc_w 1520
    //   466: iconst_1
    //   467: aload_2
    //   468: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   471: athrow
    //   472: new 66	gnu/mapping/WrongType
    //   475: dup_x1
    //   476: swap
    //   477: ldc_w 1520
    //   480: iconst_2
    //   481: aload_3
    //   482: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   485: athrow
    //   486: new 66	gnu/mapping/WrongType
    //   489: dup_x1
    //   490: swap
    //   491: ldc_w 1525
    //   494: iconst_1
    //   495: aload_2
    //   496: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   499: athrow
    //   500: new 66	gnu/mapping/WrongType
    //   503: dup_x1
    //   504: swap
    //   505: ldc_w 1525
    //   508: iconst_2
    //   509: aload_3
    //   510: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   513: athrow
    //   514: new 66	gnu/mapping/WrongType
    //   517: dup_x1
    //   518: swap
    //   519: ldc_w 1529
    //   522: iconst_1
    //   523: aload_2
    //   524: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   527: athrow
    //   528: new 66	gnu/mapping/WrongType
    //   531: dup_x1
    //   532: swap
    //   533: ldc_w 1529
    //   536: iconst_2
    //   537: aload_3
    //   538: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   541: athrow
    //   542: new 66	gnu/mapping/WrongType
    //   545: dup_x1
    //   546: swap
    //   547: ldc_w 1534
    //   550: iconst_1
    //   551: aload_2
    //   552: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   555: athrow
    //   556: new 66	gnu/mapping/WrongType
    //   559: dup_x1
    //   560: swap
    //   561: ldc_w 1534
    //   564: iconst_2
    //   565: aload_3
    //   566: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   569: athrow
    //   570: new 66	gnu/mapping/WrongType
    //   573: dup_x1
    //   574: swap
    //   575: ldc_w 1538
    //   578: iconst_1
    //   579: aload_2
    //   580: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   583: athrow
    //   584: new 66	gnu/mapping/WrongType
    //   587: dup_x1
    //   588: swap
    //   589: ldc_w 1538
    //   592: iconst_2
    //   593: aload_3
    //   594: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   597: athrow
    //   598: new 66	gnu/mapping/WrongType
    //   601: dup_x1
    //   602: swap
    //   603: ldc_w 1541
    //   606: iconst_1
    //   607: aload_2
    //   608: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   611: athrow
    //   612: new 66	gnu/mapping/WrongType
    //   615: dup_x1
    //   616: swap
    //   617: ldc_w 1541
    //   620: iconst_2
    //   621: aload_3
    //   622: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   625: athrow
    //   626: new 66	gnu/mapping/WrongType
    //   629: dup_x1
    //   630: swap
    //   631: ldc_w 1548
    //   634: iconst_1
    //   635: aload_2
    //   636: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   639: athrow
    //   640: new 66	gnu/mapping/WrongType
    //   643: dup_x1
    //   644: swap
    //   645: ldc_w 1548
    //   648: iconst_2
    //   649: aload_3
    //   650: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   653: athrow
    //   654: new 66	gnu/mapping/WrongType
    //   657: dup_x1
    //   658: swap
    //   659: ldc_w 1413
    //   662: iconst_1
    //   663: aload_2
    //   664: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   667: athrow
    //   668: new 66	gnu/mapping/WrongType
    //   671: dup_x1
    //   672: swap
    //   673: ldc_w 1413
    //   676: iconst_2
    //   677: aload_3
    //   678: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   681: athrow
    //   682: new 66	gnu/mapping/WrongType
    //   685: dup_x1
    //   686: swap
    //   687: ldc_w 1418
    //   690: iconst_1
    //   691: aload_2
    //   692: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   695: athrow
    //   696: new 66	gnu/mapping/WrongType
    //   699: dup_x1
    //   700: swap
    //   701: ldc_w 1418
    //   704: iconst_2
    //   705: aload_3
    //   706: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   709: athrow
    //   710: new 66	gnu/mapping/WrongType
    //   713: dup_x1
    //   714: swap
    //   715: ldc_w 1444
    //   718: iconst_1
    //   719: aload_2
    //   720: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   723: athrow
    //   724: new 66	gnu/mapping/WrongType
    //   727: dup_x1
    //   728: swap
    //   729: ldc_w 1444
    //   732: iconst_2
    //   733: aload_3
    //   734: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   737: athrow
    //   738: new 66	gnu/mapping/WrongType
    //   741: dup_x1
    //   742: swap
    //   743: ldc_w 1444
    //   746: iconst_1
    //   747: aload_2
    //   748: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   751: athrow
    //   752: new 66	gnu/mapping/WrongType
    //   755: dup_x1
    //   756: swap
    //   757: ldc_w 1444
    //   760: iconst_2
    //   761: aload_3
    //   762: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   765: athrow
    //   766: new 66	gnu/mapping/WrongType
    //   769: dup_x1
    //   770: swap
    //   771: ldc_w 1444
    //   774: iconst_1
    //   775: aload_2
    //   776: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   779: athrow
    //   780: new 66	gnu/mapping/WrongType
    //   783: dup_x1
    //   784: swap
    //   785: ldc_w 1444
    //   788: iconst_2
    //   789: aload_3
    //   790: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   793: athrow
    //   794: new 66	gnu/mapping/WrongType
    //   797: dup_x1
    //   798: swap
    //   799: ldc_w 1444
    //   802: iconst_1
    //   803: aload_2
    //   804: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   807: athrow
    //   808: new 66	gnu/mapping/WrongType
    //   811: dup_x1
    //   812: swap
    //   813: ldc_w 1444
    //   816: iconst_2
    //   817: aload_3
    //   818: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   821: athrow
    // Line number table:
    //   Java source line #171	-> byte code offset #128
    //   Java source line #176	-> byte code offset #150
    //   Java source line #181	-> byte code offset #172
    //   Java source line #186	-> byte code offset #194
    //   Java source line #247	-> byte code offset #216
    //   Java source line #478	-> byte code offset #238
    //   Java source line #498	-> byte code offset #273
    //   Java source line #532	-> byte code offset #307
    //   Java source line #540	-> byte code offset #330
    //   Java source line #558	-> byte code offset #354
    //   Java source line #258	-> byte code offset #360
    //   Java source line #315	-> byte code offset #382
    //   Java source line #419	-> byte code offset #404
    //   Java source line #425	-> byte code offset #426
    //   Java source line #171	-> byte code offset #458
    //   Java source line #176	-> byte code offset #486
    //   Java source line #181	-> byte code offset #514
    //   Java source line #186	-> byte code offset #542
    //   Java source line #247	-> byte code offset #570
    //   Java source line #478	-> byte code offset #598
    //   Java source line #498	-> byte code offset #626
    //   Java source line #532	-> byte code offset #654
    //   Java source line #533	-> byte code offset #668
    //   Java source line #540	-> byte code offset #682
    //   Java source line #258	-> byte code offset #710
    //   Java source line #315	-> byte code offset #738
    //   Java source line #419	-> byte code offset #766
    //   Java source line #425	-> byte code offset #794
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	822	0	this	numbers
    //   0	822	1	paramModuleMethod	ModuleMethod
    //   0	822	2	paramObject1	Object
    //   0	822	3	paramObject2	Object
    //   458	1	4	localClassCastException1	ClassCastException
    //   472	1	5	localClassCastException2	ClassCastException
    //   486	1	6	localClassCastException3	ClassCastException
    //   500	1	7	localClassCastException4	ClassCastException
    //   514	1	8	localClassCastException5	ClassCastException
    //   528	1	9	localClassCastException6	ClassCastException
    //   542	1	10	localClassCastException7	ClassCastException
    //   556	1	11	localClassCastException8	ClassCastException
    //   570	1	12	localClassCastException9	ClassCastException
    //   584	1	13	localClassCastException10	ClassCastException
    //   598	1	14	localClassCastException11	ClassCastException
    //   612	1	15	localClassCastException12	ClassCastException
    //   626	1	16	localClassCastException13	ClassCastException
    //   640	1	17	localClassCastException14	ClassCastException
    //   654	1	18	localClassCastException15	ClassCastException
    //   668	1	19	localClassCastException16	ClassCastException
    //   682	1	20	localClassCastException17	ClassCastException
    //   696	1	21	localClassCastException18	ClassCastException
    //   710	1	22	localClassCastException19	ClassCastException
    //   724	1	23	localClassCastException20	ClassCastException
    //   738	1	24	localClassCastException21	ClassCastException
    //   752	1	25	localClassCastException22	ClassCastException
    //   766	1	26	localClassCastException23	ClassCastException
    //   780	1	27	localClassCastException24	ClassCastException
    //   794	1	28	localClassCastException25	ClassCastException
    //   808	1	29	localClassCastException26	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   134	137	458	java/lang/ClassCastException
    //   143	146	472	java/lang/ClassCastException
    //   156	159	486	java/lang/ClassCastException
    //   165	168	500	java/lang/ClassCastException
    //   178	181	514	java/lang/ClassCastException
    //   187	190	528	java/lang/ClassCastException
    //   200	203	542	java/lang/ClassCastException
    //   209	212	556	java/lang/ClassCastException
    //   222	225	570	java/lang/ClassCastException
    //   231	234	584	java/lang/ClassCastException
    //   244	247	598	java/lang/ClassCastException
    //   251	257	612	java/lang/ClassCastException
    //   279	282	626	java/lang/ClassCastException
    //   288	291	640	java/lang/ClassCastException
    //   313	316	654	java/lang/ClassCastException
    //   320	326	668	java/lang/ClassCastException
    //   337	340	682	java/lang/ClassCastException
    //   344	350	696	java/lang/ClassCastException
    //   366	369	710	java/lang/ClassCastException
    //   375	378	724	java/lang/ClassCastException
    //   388	391	738	java/lang/ClassCastException
    //   397	400	752	java/lang/ClassCastException
    //   410	413	766	java/lang/ClassCastException
    //   419	422	780	java/lang/ClassCastException
    //   430	436	794	java/lang/ClassCastException
    //   440	446	808	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1240	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+219->223, 81:+52->56, 83:+85->89, 85:+119->123, 86:+153->157, 93:+185->189
    //   56: aload_2
    //   57: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 12	java/lang/Number
    //   63: invokevirtual 1544	java/lang/Number:intValue	()I
    //   66: aload_3
    //   67: ldc 50
    //   69: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   72: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   75: aload 4
    //   77: ldc 50
    //   79: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   82: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   85: invokestatic 1573	kawa/lib/numbers:logop	(ILgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   88: areturn
    //   89: aload_2
    //   90: ldc 50
    //   92: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   95: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   98: aload_3
    //   99: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 12	java/lang/Number
    //   105: invokevirtual 1544	java/lang/Number:intValue	()I
    //   108: aload 4
    //   110: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   113: checkcast 12	java/lang/Number
    //   116: invokevirtual 1544	java/lang/Number:intValue	()I
    //   119: invokestatic 1578	kawa/lib/numbers:bitwiseCopyBit	(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
    //   122: areturn
    //   123: aload_2
    //   124: ldc 50
    //   126: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   129: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   132: aload_3
    //   133: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast 12	java/lang/Number
    //   139: invokevirtual 1544	java/lang/Number:intValue	()I
    //   142: aload 4
    //   144: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   147: checkcast 12	java/lang/Number
    //   150: invokevirtual 1544	java/lang/Number:intValue	()I
    //   153: invokestatic 504	kawa/lib/numbers:bitwiseBitField	(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
    //   156: areturn
    //   157: aload_2
    //   158: ldc 50
    //   160: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   163: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   166: aload_3
    //   167: ldc 50
    //   169: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   172: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   175: aload 4
    //   177: ldc 50
    //   179: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   182: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   185: invokestatic 470	kawa/lib/numbers:bitwiseIf	(Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   188: areturn
    //   189: aload_2
    //   190: ldc 50
    //   192: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   195: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   198: aload_3
    //   199: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   202: checkcast 12	java/lang/Number
    //   205: invokevirtual 1544	java/lang/Number:intValue	()I
    //   208: aload 4
    //   210: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   213: checkcast 12	java/lang/Number
    //   216: invokevirtual 1544	java/lang/Number:intValue	()I
    //   219: invokestatic 1587	kawa/lib/numbers:bitwiseReverseBitField	(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
    //   222: areturn
    //   223: aload_0
    //   224: aload_1
    //   225: aload_2
    //   226: aload_3
    //   227: aload 4
    //   229: invokespecial 1591	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   232: areturn
    //   233: new 66	gnu/mapping/WrongType
    //   236: dup_x1
    //   237: swap
    //   238: ldc_w 1571
    //   241: iconst_1
    //   242: aload_2
    //   243: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: new 66	gnu/mapping/WrongType
    //   250: dup_x1
    //   251: swap
    //   252: ldc_w 1571
    //   255: iconst_2
    //   256: aload_3
    //   257: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   260: athrow
    //   261: new 66	gnu/mapping/WrongType
    //   264: dup_x1
    //   265: swap
    //   266: ldc_w 1571
    //   269: iconst_3
    //   270: aload 4
    //   272: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   275: athrow
    //   276: new 66	gnu/mapping/WrongType
    //   279: dup_x1
    //   280: swap
    //   281: ldc_w 1575
    //   284: iconst_1
    //   285: aload_2
    //   286: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   289: athrow
    //   290: new 66	gnu/mapping/WrongType
    //   293: dup_x1
    //   294: swap
    //   295: ldc_w 1575
    //   298: iconst_2
    //   299: aload_3
    //   300: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   303: athrow
    //   304: new 66	gnu/mapping/WrongType
    //   307: dup_x1
    //   308: swap
    //   309: ldc_w 1575
    //   312: iconst_3
    //   313: aload 4
    //   315: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   318: athrow
    //   319: new 66	gnu/mapping/WrongType
    //   322: dup_x1
    //   323: swap
    //   324: ldc_w 1580
    //   327: iconst_1
    //   328: aload_2
    //   329: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   332: athrow
    //   333: new 66	gnu/mapping/WrongType
    //   336: dup_x1
    //   337: swap
    //   338: ldc_w 1580
    //   341: iconst_2
    //   342: aload_3
    //   343: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   346: athrow
    //   347: new 66	gnu/mapping/WrongType
    //   350: dup_x1
    //   351: swap
    //   352: ldc_w 1580
    //   355: iconst_3
    //   356: aload 4
    //   358: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   361: athrow
    //   362: new 66	gnu/mapping/WrongType
    //   365: dup_x1
    //   366: swap
    //   367: ldc_w 1582
    //   370: iconst_1
    //   371: aload_2
    //   372: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   375: athrow
    //   376: new 66	gnu/mapping/WrongType
    //   379: dup_x1
    //   380: swap
    //   381: ldc_w 1582
    //   384: iconst_2
    //   385: aload_3
    //   386: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   389: athrow
    //   390: new 66	gnu/mapping/WrongType
    //   393: dup_x1
    //   394: swap
    //   395: ldc_w 1582
    //   398: iconst_3
    //   399: aload 4
    //   401: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   404: athrow
    //   405: new 66	gnu/mapping/WrongType
    //   408: dup_x1
    //   409: swap
    //   410: ldc_w 1584
    //   413: iconst_1
    //   414: aload_2
    //   415: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   418: athrow
    //   419: new 66	gnu/mapping/WrongType
    //   422: dup_x1
    //   423: swap
    //   424: ldc_w 1584
    //   427: iconst_2
    //   428: aload_3
    //   429: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   432: athrow
    //   433: new 66	gnu/mapping/WrongType
    //   436: dup_x1
    //   437: swap
    //   438: ldc_w 1584
    //   441: iconst_3
    //   442: aload 4
    //   444: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   447: athrow
    // Line number table:
    //   Java source line #475	-> byte code offset #56
    //   Java source line #481	-> byte code offset #89
    //   Java source line #490	-> byte code offset #123
    //   Java source line #494	-> byte code offset #157
    //   Java source line #529	-> byte code offset #189
    //   Java source line #475	-> byte code offset #233
    //   Java source line #481	-> byte code offset #276
    //   Java source line #490	-> byte code offset #319
    //   Java source line #494	-> byte code offset #362
    //   Java source line #529	-> byte code offset #405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	numbers
    //   0	448	1	paramModuleMethod	ModuleMethod
    //   0	448	2	paramObject1	Object
    //   0	448	3	paramObject2	Object
    //   0	448	4	paramObject3	Object
    //   233	1	5	localClassCastException1	ClassCastException
    //   247	1	6	localClassCastException2	ClassCastException
    //   261	1	7	localClassCastException3	ClassCastException
    //   276	1	8	localClassCastException4	ClassCastException
    //   290	1	9	localClassCastException5	ClassCastException
    //   304	1	10	localClassCastException6	ClassCastException
    //   319	1	11	localClassCastException7	ClassCastException
    //   333	1	12	localClassCastException8	ClassCastException
    //   347	1	13	localClassCastException9	ClassCastException
    //   362	1	14	localClassCastException10	ClassCastException
    //   376	1	15	localClassCastException11	ClassCastException
    //   390	1	16	localClassCastException12	ClassCastException
    //   405	1	17	localClassCastException13	ClassCastException
    //   419	1	18	localClassCastException14	ClassCastException
    //   433	1	19	localClassCastException15	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   60	66	233	java/lang/ClassCastException
    //   72	75	247	java/lang/ClassCastException
    //   82	85	261	java/lang/ClassCastException
    //   95	98	276	java/lang/ClassCastException
    //   102	108	290	java/lang/ClassCastException
    //   113	119	304	java/lang/ClassCastException
    //   129	132	319	java/lang/ClassCastException
    //   136	142	333	java/lang/ClassCastException
    //   147	153	347	java/lang/ClassCastException
    //   163	166	362	java/lang/ClassCastException
    //   172	175	376	java/lang/ClassCastException
    //   182	185	390	java/lang/ClassCastException
    //   195	198	405	java/lang/ClassCastException
    //   202	208	419	java/lang/ClassCastException
    //   213	219	433	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1240	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+221->225, 67:+133->137, 69:+175->179, 84:+44->48, 92:+88->92
    //   48: aload_2
    //   49: ldc 50
    //   51: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   54: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   57: aload_3
    //   58: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 12	java/lang/Number
    //   64: invokevirtual 1544	java/lang/Number:intValue	()I
    //   67: aload 4
    //   69: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 12	java/lang/Number
    //   75: invokevirtual 1544	java/lang/Number:intValue	()I
    //   78: aload 5
    //   80: ldc 50
    //   82: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   85: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   88: invokestatic 508	kawa/lib/numbers:bitwiseCopyBitField	(Lgnu/math/IntNum;IILgnu/math/IntNum;)Lgnu/math/IntNum;
    //   91: areturn
    //   92: aload_2
    //   93: ldc 50
    //   95: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   98: invokestatic 275	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   101: aload_3
    //   102: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   105: checkcast 12	java/lang/Number
    //   108: invokevirtual 1544	java/lang/Number:intValue	()I
    //   111: aload 4
    //   113: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: checkcast 12	java/lang/Number
    //   119: invokevirtual 1544	java/lang/Number:intValue	()I
    //   122: aload 5
    //   124: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   127: checkcast 12	java/lang/Number
    //   130: invokevirtual 1544	java/lang/Number:intValue	()I
    //   133: invokestatic 1599	kawa/lib/numbers:bitwiseRotateBitField	(Lgnu/math/IntNum;III)Lgnu/math/IntNum;
    //   136: areturn
    //   137: aload_2
    //   138: ldc 26
    //   140: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   143: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   146: aload_3
    //   147: ldc 26
    //   149: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   152: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   155: aload 4
    //   157: ldc 26
    //   159: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   162: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   165: aload 5
    //   167: ldc 26
    //   169: invokestatic 62	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   172: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   175: invokestatic 1602	kawa/lib/numbers:lambda27	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   178: areturn
    //   179: aload_2
    //   180: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   183: checkcast 12	java/lang/Number
    //   186: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   189: aload_3
    //   190: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   193: checkcast 12	java/lang/Number
    //   196: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   199: aload 4
    //   201: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   204: checkcast 12	java/lang/Number
    //   207: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   210: aload 5
    //   212: invokestatic 971	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   215: checkcast 12	java/lang/Number
    //   218: invokevirtual 76	java/lang/Number:doubleValue	()D
    //   221: invokestatic 1605	kawa/lib/numbers:lambda29	(DDDD)Lgnu/math/Quaternion;
    //   224: areturn
    //   225: aload_0
    //   226: aload_1
    //   227: aload_2
    //   228: aload_3
    //   229: aload 4
    //   231: aload 5
    //   233: invokespecial 1609	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   236: areturn
    //   237: new 66	gnu/mapping/WrongType
    //   240: dup_x1
    //   241: swap
    //   242: ldc_w 1593
    //   245: iconst_1
    //   246: aload_2
    //   247: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   250: athrow
    //   251: new 66	gnu/mapping/WrongType
    //   254: dup_x1
    //   255: swap
    //   256: ldc_w 1593
    //   259: iconst_2
    //   260: aload_3
    //   261: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   264: athrow
    //   265: new 66	gnu/mapping/WrongType
    //   268: dup_x1
    //   269: swap
    //   270: ldc_w 1593
    //   273: iconst_3
    //   274: aload 4
    //   276: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: new 66	gnu/mapping/WrongType
    //   283: dup_x1
    //   284: swap
    //   285: ldc_w 1593
    //   288: iconst_4
    //   289: aload 5
    //   291: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   294: athrow
    //   295: new 66	gnu/mapping/WrongType
    //   298: dup_x1
    //   299: swap
    //   300: ldc_w 1595
    //   303: iconst_1
    //   304: aload_2
    //   305: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   308: athrow
    //   309: new 66	gnu/mapping/WrongType
    //   312: dup_x1
    //   313: swap
    //   314: ldc_w 1595
    //   317: iconst_2
    //   318: aload_3
    //   319: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   322: athrow
    //   323: new 66	gnu/mapping/WrongType
    //   326: dup_x1
    //   327: swap
    //   328: ldc_w 1595
    //   331: iconst_3
    //   332: aload 4
    //   334: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   337: athrow
    //   338: new 66	gnu/mapping/WrongType
    //   341: dup_x1
    //   342: swap
    //   343: ldc_w 1595
    //   346: iconst_4
    //   347: aload 5
    //   349: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   352: athrow
    //   353: new 66	gnu/mapping/WrongType
    //   356: dup_x1
    //   357: swap
    //   358: ldc_w 1444
    //   361: iconst_1
    //   362: aload_2
    //   363: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   366: athrow
    //   367: new 66	gnu/mapping/WrongType
    //   370: dup_x1
    //   371: swap
    //   372: ldc_w 1444
    //   375: iconst_2
    //   376: aload_3
    //   377: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   380: athrow
    //   381: new 66	gnu/mapping/WrongType
    //   384: dup_x1
    //   385: swap
    //   386: ldc_w 1444
    //   389: iconst_3
    //   390: aload 4
    //   392: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   395: athrow
    //   396: new 66	gnu/mapping/WrongType
    //   399: dup_x1
    //   400: swap
    //   401: ldc_w 1444
    //   404: iconst_4
    //   405: aload 5
    //   407: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   410: athrow
    //   411: new 66	gnu/mapping/WrongType
    //   414: dup_x1
    //   415: swap
    //   416: ldc_w 1444
    //   419: iconst_1
    //   420: aload_2
    //   421: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   424: athrow
    //   425: new 66	gnu/mapping/WrongType
    //   428: dup_x1
    //   429: swap
    //   430: ldc_w 1444
    //   433: iconst_2
    //   434: aload_3
    //   435: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   438: athrow
    //   439: new 66	gnu/mapping/WrongType
    //   442: dup_x1
    //   443: swap
    //   444: ldc_w 1444
    //   447: iconst_3
    //   448: aload 4
    //   450: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   453: athrow
    //   454: new 66	gnu/mapping/WrongType
    //   457: dup_x1
    //   458: swap
    //   459: ldc_w 1444
    //   462: iconst_4
    //   463: aload 5
    //   465: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   468: athrow
    // Line number table:
    //   Java source line #485	-> byte code offset #48
    //   Java source line #516	-> byte code offset #92
    //   Java source line #421	-> byte code offset #137
    //   Java source line #427	-> byte code offset #179
    //   Java source line #485	-> byte code offset #237
    //   Java source line #516	-> byte code offset #295
    //   Java source line #421	-> byte code offset #353
    //   Java source line #427	-> byte code offset #411
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	this	numbers
    //   0	469	1	paramModuleMethod	ModuleMethod
    //   0	469	2	paramObject1	Object
    //   0	469	3	paramObject2	Object
    //   0	469	4	paramObject3	Object
    //   0	469	5	paramObject4	Object
    //   237	1	6	localClassCastException1	ClassCastException
    //   251	1	7	localClassCastException2	ClassCastException
    //   265	1	8	localClassCastException3	ClassCastException
    //   280	1	9	localClassCastException4	ClassCastException
    //   295	1	10	localClassCastException5	ClassCastException
    //   309	1	11	localClassCastException6	ClassCastException
    //   323	1	12	localClassCastException7	ClassCastException
    //   338	1	13	localClassCastException8	ClassCastException
    //   353	1	14	localClassCastException9	ClassCastException
    //   367	1	15	localClassCastException10	ClassCastException
    //   381	1	16	localClassCastException11	ClassCastException
    //   396	1	17	localClassCastException12	ClassCastException
    //   411	1	18	localClassCastException13	ClassCastException
    //   425	1	19	localClassCastException14	ClassCastException
    //   439	1	20	localClassCastException15	ClassCastException
    //   454	1	21	localClassCastException16	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   54	57	237	java/lang/ClassCastException
    //   61	67	251	java/lang/ClassCastException
    //   72	78	265	java/lang/ClassCastException
    //   85	88	280	java/lang/ClassCastException
    //   98	101	295	java/lang/ClassCastException
    //   105	111	309	java/lang/ClassCastException
    //   116	122	323	java/lang/ClassCastException
    //   127	133	338	java/lang/ClassCastException
    //   143	146	353	java/lang/ClassCastException
    //   152	155	367	java/lang/ClassCastException
    //   162	165	381	java/lang/ClassCastException
    //   172	175	396	java/lang/ClassCastException
    //   183	189	411	java/lang/ClassCastException
    //   193	199	425	java/lang/ClassCastException
    //   204	210	439	java/lang/ClassCastException
    //   215	221	454	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1240	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+128->132, 20:+52->56, 21:+57->61, 22:+128->132, 23:+128->132, 24:+128->132, 25:+128->132, 26:+128->132, 27:+62->66, 28:+95->99
    //   56: aload_2
    //   57: invokestatic 1611	kawa/lib/numbers:max	([Ljava/lang/Object;)Ljava/lang/Object;
    //   60: areturn
    //   61: aload_2
    //   62: invokestatic 1613	kawa/lib/numbers:min	([Ljava/lang/Object;)Ljava/lang/Object;
    //   65: areturn
    //   66: aload_2
    //   67: arraylength
    //   68: istore_3
    //   69: iload_3
    //   70: anewarray 26	gnu/math/RealNum
    //   73: goto +15 -> 88
    //   76: dup
    //   77: iload_3
    //   78: aload_2
    //   79: iload_3
    //   80: aaload
    //   81: dup
    //   82: astore 4
    //   84: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   87: aastore
    //   88: iinc 3 -1
    //   91: iload_3
    //   92: ifge -16 -> 76
    //   95: invokestatic 1617	kawa/lib/numbers:gcd	([Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   98: areturn
    //   99: aload_2
    //   100: arraylength
    //   101: istore_3
    //   102: iload_3
    //   103: anewarray 26	gnu/math/RealNum
    //   106: goto +15 -> 121
    //   109: dup
    //   110: iload_3
    //   111: aload_2
    //   112: iload_3
    //   113: aaload
    //   114: dup
    //   115: astore 4
    //   117: invokestatic 199	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   120: aastore
    //   121: iinc 3 -1
    //   124: iload_3
    //   125: ifge -16 -> 109
    //   128: invokestatic 1620	kawa/lib/numbers:lcm	([Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   131: areturn
    //   132: aload_0
    //   133: aload_1
    //   134: aload_2
    //   135: invokespecial 1624	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   138: areturn
    //   139: new 66	gnu/mapping/WrongType
    //   142: dup_x1
    //   143: swap
    //   144: ldc_w 1614
    //   147: iconst_0
    //   148: aload 4
    //   150: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   153: athrow
    //   154: new 66	gnu/mapping/WrongType
    //   157: dup_x1
    //   158: swap
    //   159: ldc_w 1618
    //   162: iconst_0
    //   163: aload 4
    //   165: invokespecial 72	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   168: athrow
    // Line number table:
    //   Java source line #147	-> byte code offset #56
    //   Java source line #155	-> byte code offset #61
    //   Java source line #191	-> byte code offset #66
    //   Java source line #208	-> byte code offset #99
    //   Java source line #191	-> byte code offset #139
    //   Java source line #208	-> byte code offset #154
    // Exception table:
    //   from	to	target	type
    //   84	87	139	java/lang/ClassCastException
    //   117	120	154	java/lang/ClassCastException
  }
}
