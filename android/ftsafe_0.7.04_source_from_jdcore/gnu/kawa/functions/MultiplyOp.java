package gnu.kawa.functions;

import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RatNum;
import gnu.math.UInt;
import gnu.math.ULong;
import java.math.BigDecimal;
import java.math.BigInteger;

public class MultiplyOp extends ArithOp
{
  public static final MultiplyOp $St = new MultiplyOp("*");
  
  public MultiplyOp(String name)
  {
    super(name, 3);
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
    
    Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileArith:forMul");
  }
  
  public Object defaultResult()
  {
    return IntNum.one();
  }
  
  public static Object apply(Object arg1, Object arg2) {
    int code1 = Arithmetic.classifyValue(arg1);
    int code2 = Arithmetic.classifyValue(arg2);
    return combine((Number)arg1, arg2, Arithmetic.leastSpecificCode(code1, code2));
  }
  
  public Object applyN(Object[] args)
  {
    int len = args.length;
    if (len == 0)
      return IntNum.one();
    Number result = (Number)gnu.mapping.Promise.force(args[0]);
    int code = Arithmetic.classifyValue(result);
    for (int i = 1; i < len; i++) {
      Object arg2 = args[i];
      int code2 = Arithmetic.classifyValue(arg2);
      code = Arithmetic.leastSpecificCode(code, code2);
      result = combine(result, arg2, code);
    }
    return result; }
  
  public static Number combine(Number result, Object arg2, int code) { double d1;
    double d2;
    switch (code) {
    case 1: 
    case 2: 
      int i1 = Arithmetic.asInt(result);
      int i2 = Arithmetic.asInt(arg2);
      int ir = i1 * i2;
      return code == 1 ? Integer.valueOf(ir) : UInt.valueOf(ir);
    
    case 3: 
    case 4: 
      long l1 = Arithmetic.asLong(result);
      long l2 = Arithmetic.asLong(arg2);
      long lr = l1 * l2;
      return code == 3 ? Long.valueOf(lr) : ULong.valueOf(lr);
    
    case 5: 
      BigInteger bi1 = Arithmetic.asBigInteger(result);
      BigInteger bi2 = Arithmetic.asBigInteger(arg2);
      result = bi1.multiply(bi2);
      break;
    case 6: 
      result = IntNum.times(Arithmetic.asIntNum(result), Arithmetic.asIntNum(arg2));
      
      break;
    case 7: 
      BigDecimal bd1 = Arithmetic.asBigDecimal(result);
      BigDecimal bd2 = Arithmetic.asBigDecimal(arg2);
      result = bd1.multiply(bd2);
      break;
    case 8: 
      result = RatNum.times(Arithmetic.asRatNum(result), Arithmetic.asRatNum(arg2));
      
      break;
    case 9: 
      float f1 = Arithmetic.asFloat(result);
      float f2 = Arithmetic.asFloat(arg2);
      result = new Float(f1 * f2);
      break;
    case 10: 
      d1 = Arithmetic.asDouble(result);
      d2 = Arithmetic.asDouble(arg2);
      result = new Double(d1 * d2);
      break;
    case 11: 
      d1 = Arithmetic.asDouble(result);
      d2 = Arithmetic.asDouble(arg2);
      result = new DFloNum(d1 * d2);
      break;
    default: 
      result = Arithmetic.asNumeric(result).mul(Arithmetic.asNumeric(arg2));
    }
    
    return result;
  }
}
