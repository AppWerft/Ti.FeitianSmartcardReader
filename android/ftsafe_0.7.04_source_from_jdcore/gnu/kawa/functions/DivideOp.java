package gnu.kawa.functions;

import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RealNum;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class DivideOp extends ArithOp
{
  int rounding_mode;
  
  public int getRoundingMode()
  {
    return rounding_mode;
  }
  
  public static final DivideOp $Sl = new DivideOp("/", 4);
  public static final DivideOp idiv = new DivideOp("idiv", 7);
  public static final DivideOp iceil = new DivideOp("iceil", 7);
  public static final DivideOp floorQuotient = new DivideOp("floor-quotient", 6);
  public static final DivideOp quotient = new DivideOp("quotient", 6);
  public static final DivideOp remainder = new DivideOp("remainder", 8);
  public static final DivideOp modulo = new DivideOp("modulo", 8);
  public static final DivideOp div = new DivideOp("div", 6);
  public static final DivideOp mod = new DivideOp("mod", 8);
  public static final DivideOp div0 = new DivideOp("div0", 6);
  public static final DivideOp mod0 = new DivideOp("mod0", 8);
  
  static { idivrounding_mode = 3;
    iceilrounding_mode = 2;
    quotientrounding_mode = 3;
    floorQuotientrounding_mode = 1;
    remainderrounding_mode = 3;
    modulorounding_mode = 1;
    divrounding_mode = 5;
    modrounding_mode = 5;
    div0rounding_mode = 4;
    mod0rounding_mode = 4;
  }
  
  public DivideOp(String name, int op)
  {
    super(name, op);
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
    
    gnu.mapping.Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileArith:forDiv");
  }
  
  public Object applyN(Object[] args)
    throws Throwable
  {
    int len = args.length;
    if (len == 0)
      return IntNum.one();
    Object result = args[0];
    if (len == 1)
      return apply2(IntNum.one(), result);
    for (int i = 1; i < len; i++)
      result = apply2(result, args[i]);
    return result;
  }
  
  public Object apply2(Object arg1, Object arg2) throws Throwable {
    int code1 = Arithmetic.classifyValue(arg1);
    int code2 = Arithmetic.classifyValue(arg2);
    int code = Arithmetic.leastSpecificCode(code1, code2);
    int scode = code;
    if ((code < 6) && (code != 0))
    {
      switch (op)
      {
      case 4: 
      case 5: 
        scode = code = 6;
        break;
      default: 
        if ((rounding_mode != 3) || (code < 1) || (code > 3))
        {








          scode = 6; }
        break;
      }
    }
    if ((op == 5) && (code <= 12) && (code != 0))
    {

      scode = 12;
      if ((code != 10) && (code != 9)) {
        code = 11;
      }
    } else if ((scode == 10) || (scode == 9))
    {
      scode = 11;
      if (op == 7)
        code = scode; }
    Number result;
    Number result; switch (scode)
    {
    case 1: 
      int i1 = Arithmetic.asInt(arg1);
      int i2 = Arithmetic.asInt(arg2);
      switch (op)
      {
      case 8: 
        i1 %= i2;
        break;
      default: 
        i1 /= i2;
      }
      
      result = Integer.valueOf(i1);
      break;
    case 2: 
    case 3: 
      long l1 = Arithmetic.asLong(arg1);
      long l2 = Arithmetic.asLong(arg2);
      if (scode == 2)
      {
        l1 &= 0xFFFFFFFF;
        l2 &= 0xFFFFFFFF;
      }
      switch (op)
      {
      case 8: 
        l1 %= l2;
        break;
      default: 
        l1 /= l2;
      }
      
      if (scode == 2) {
        result = gnu.math.UInt.valueOf((int)l1);
      } else
        result = Long.valueOf(l1);
      break;
    















    case 6: 
      switch (op) {
      case 5: 
      case 6: 
      case 7: 
      default: 
        result = IntNum.quotient(Arithmetic.asIntNum(arg1), Arithmetic.asIntNum(arg2), getRoundingMode());
        

        break;
      case 8: 
        result = IntNum.remainder(Arithmetic.asIntNum(arg1), Arithmetic.asIntNum(arg2), getRoundingMode());
        

        break;
      case 4: 
        result = gnu.math.RatNum.make(Arithmetic.asIntNum(arg1), Arithmetic.asIntNum(arg2));
        
        code = (result instanceof IntNum) ? 6 : 8;
        
        scode = code; }
      break;
    


    case 7: 
      BigDecimal bd1 = Arithmetic.asBigDecimal(arg1);
      BigDecimal bd2 = Arithmetic.asBigDecimal(arg2);
      int mprec = 0;
      RoundingMode mround;
      switch (getRoundingMode())
      {
      case 1: 
        mround = RoundingMode.FLOOR;
        break;
      case 2: 
        mround = RoundingMode.CEILING;
        break;
      case 3: 
        mround = RoundingMode.DOWN;
        break;
      case 5: 
        mround = bd2.signum() < 0 ? RoundingMode.CEILING : RoundingMode.FLOOR;
      case 4: default: 
        mround = RoundingMode.HALF_EVEN;
      }
      
      java.math.MathContext mcontext = new java.math.MathContext(mprec, mround);
      switch (op) {
      case 4: 
      case 5: 
      default: 
        result = bd1.divide(bd2);
        break;
      case 6: 
        result = bd1.divideToIntegralValue(bd2, mcontext);
        break;
      case 7: 
        result = bd1.divideToIntegralValue(bd2, mcontext).toBigInteger();
        
        code = scode = 5;
        break;
      case 8: 
        result = bd1.remainder(bd2, mcontext); }
      break;
    


    case 11: 
      double d1 = Arithmetic.asDouble(arg1);
      double d2 = Arithmetic.asDouble(arg2);
      switch (op)
      {
      case 4: 
      case 5: 
      default: 
        result = DFloNum.valueOf(d1 / d2);
        break;
      case 6: 
        result = Double.valueOf(RealNum.toInt(d1 / d2, getRoundingMode()));
        break;
      case 7: 
        result = RealNum.toExactInt(d1 / d2, getRoundingMode());
        code = scode = 6;
        break;
      case 8: 
        if (d2 != 0.0D)
          d1 -= RealNum.toInt(d1 / d2, getRoundingMode()) * d2;
        result = DFloNum.valueOf(d1); }
      break;
    case 4: case 5: 
    case 8: case 9: 
    case 10: case 12: 
    default: 
      Numeric num1 = Arithmetic.asNumeric(arg1);
      Numeric num2 = Arithmetic.asNumeric(arg2);
      if ((op == 8) && (num2.isZero()))
        return num2.isExact() ? num1 : num1.toInexact();
      Numeric numr = num1.div(num2);
      if (op == 8)
        numr = num1.sub(((RealNum)numr).toInt(getRoundingMode()).mul(num2));
      switch (op)
      {
      case 7: 
        result = ((RealNum)numr).toExactInt(rounding_mode);
        scode = code = 6;
        break;
      case 6: 
        result = ((RealNum)numr).toInt(rounding_mode);
        break;
      case 5: 
        result = numr.toInexact();
        break;
      default: 
        result = numr;
      }
      break; }
    if (code != scode)
    {
      switch (code)
      {
      case 1: 
        result = Integer.valueOf(result.intValue());
        break;
      case 2: 
        result = gnu.math.UInt.valueOf(result.intValue());
        break;
      case 3: 
        result = Long.valueOf(result.longValue());
        break;
      case 4: 
        result = gnu.math.ULong.valueOf(result.longValue());
        break;
      case 9: 
        result = Float.valueOf(result.floatValue());
        break;
      case 10: 
        result = Double.valueOf(result.doubleValue());
        break;
      case 5: 
        result = Arithmetic.asBigInteger(result);
      }
    }
    return result;
  }
  
  public int numArgs()
  {
    return op == 4 ? 61441 : 8194;
  }
}
