package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.mapping.Procedure;
import gnu.math.IntNum;
import gnu.math.Numeric;
import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberCompare extends gnu.mapping.ProcedureN
{
  Language language;
  static final int RESULT_GRT = 1;
  static final int RESULT_EQU = 0;
  static final int RESULT_LSS = -1;
  static final int RESULT_NAN = -2;
  static final int RESULT_NEQ = -3;
  public static final int TRUE_IF_GRT = 16;
  public static final int TRUE_IF_EQU = 8;
  public static final int TRUE_IF_LSS = 4;
  public static final int TRUE_IF_NAN = 2;
  public static final int TRUE_IF_NEQ = 1;
  int flags;
  
  public NumberCompare() {}
  
  public int numArgs()
  {
    return 61442;
  }
  
  public static boolean $Eq(Object arg1, Object arg2) {
    return apply2(8, arg1, arg2);
  }
  
  public static boolean $Gr(Object arg1, Object arg2)
  {
    return apply2(16, arg1, arg2);
  }
  
  public static boolean $Gr$Eq(Object arg1, Object arg2)
  {
    return apply2(24, arg1, arg2);
  }
  
  public static boolean $Ls(Object arg1, Object arg2)
  {
    return apply2(4, arg1, arg2);
  }
  
  public static boolean $Ls$Eq(Object arg1, Object arg2)
  {
    return apply2(12, arg1, arg2);
  }
  

  public static boolean $Eq$V(Object arg1, Object arg2, Object arg3, Object[] rest)
  {
    return ($Eq(arg1, arg2)) && ($Eq(arg2, arg3)) && ((rest.length == 0) || (($Eq(arg3, rest[0])) && (applyN(8, rest))));
  }
  



  public static boolean $Gr$V(Object arg1, Object arg2, Object arg3, Object[] rest)
  {
    return ($Gr(arg1, arg2)) && ($Gr(arg2, arg3)) && ((rest.length == 0) || (($Gr(arg3, rest[0])) && (applyN(16, rest))));
  }
  



  public static boolean $Gr$Eq$V(Object arg1, Object arg2, Object arg3, Object[] rest)
  {
    return ($Gr$Eq(arg1, arg2)) && ($Gr$Eq(arg2, arg3)) && ((rest.length == 0) || (($Gr$Eq(arg3, rest[0])) && (applyN(24, rest))));
  }
  




  public static boolean $Ls$V(Object arg1, Object arg2, Object arg3, Object[] rest)
  {
    return ($Ls(arg1, arg2)) && ($Ls(arg2, arg3)) && ((rest.length == 0) || (($Ls(arg3, rest[0])) && (applyN(4, rest))));
  }
  



  public static boolean $Ls$Eq$V(Object arg1, Object arg2, Object arg3, Object[] rest)
  {
    return ($Ls$Eq(arg1, arg2)) && ($Ls$Eq(arg2, arg3)) && ((rest.length == 0) || (($Ls$Eq(arg3, rest[0])) && (applyN(12, rest))));
  }
  



  public static NumberCompare make(Language language, String name, int flags)
  {
    NumberCompare proc = new NumberCompare();
    language = language;
    proc.setName(name);
    flags = flags;
    proc.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplySimpleBoolean");
    
    proc.setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileNumberCompare");
    
    return proc;
  }
  
  protected final Language getLanguage()
  {
    return language;
  }
  
  public Object apply2(Object arg1, Object arg2)
  {
    return getLanguage().booleanObject(apply2(flags, arg1, arg2));
  }
  
  public static boolean apply2(int flags, Object arg1, Object arg2)
  {
    return (1 << 3 + compareStrict(arg1, arg2, true) & flags) != 0;
  }
  
  public static boolean checkCompareCode(int code, int flags)
  {
    return (1 << 3 + code & flags) != 0;
  }
  
  public static boolean applyWithPromotion(int flags, Object arg1, Object arg2)
  {
    return checkCompareCode(compareStrict(arg1, arg2, false), flags);
  }
  







  public static int compare(Object arg1, Object arg2, boolean exact)
  {
    int code1 = Arithmetic.classifyValue(arg1);
    int code2 = Arithmetic.classifyValue(arg2);
    return compare(arg1, code1, arg2, code2, exact);
  }
  
  public static int compareStrict(Object arg1, Object arg2, boolean exact)
  {
    int code1 = Arithmetic.classifyValue(arg1);
    int code2 = Arithmetic.classifyValue(arg2);
    int r = compare(arg1, code1, arg2, code2, exact);
    if (r == -3)
      throw new IllegalArgumentException("bad value for numeric compare");
    return r;
  }
  


  public static int compare(Object arg1, int code1, Object arg2, int code2, boolean exact)
  {
    int code = Arithmetic.leastSpecificCode(code1, code2);
    if (code == 0)
      return -3;
    int comp;
    int comp; switch (code)
    {
    case 1: 
      int i1 = Arithmetic.asInt(arg1);
      int i2 = Arithmetic.asInt(arg2);
      comp = i1 > i2 ? 1 : i1 < i2 ? -1 : 0;
      break;
    case 2: 
    case 3: 
    case 4: 
      long l1 = Arithmetic.asLong(arg1);
      long l2 = Arithmetic.asLong(arg2);
      if (code == 4)
      {
        if ((code1 == 1) && (l1 < 0L))
          return -1;
        if ((code2 == 1) && (l2 < 0L))
          return 1;
        l1 += Long.MIN_VALUE;
        l2 += Long.MIN_VALUE;
      }
      comp = l1 > l2 ? 1 : l1 < l2 ? -1 : 0;
      break;
    case 5: 
      BigInteger bi1 = Arithmetic.asBigInteger(arg1);
      BigInteger bi2 = Arithmetic.asBigInteger(arg2);
      comp = bi1.compareTo(bi2);
      break;
    case 6: 
      comp = IntNum.compare(Arithmetic.asIntNum(arg1), Arithmetic.asIntNum(arg2));
      
      break;
    case 7: 
      BigDecimal bd1 = Arithmetic.asBigDecimal(arg1);
      BigDecimal bd2 = Arithmetic.asBigDecimal(arg2);
      comp = bd1.compareTo(bd2);
      break;
    case 8: 
      comp = gnu.math.RatNum.compare(Arithmetic.asRatNum(arg1), Arithmetic.asRatNum(arg2));
      
      break;
    case 9: 
      if ((!exact) || ((code1 > 8) && (code2 > 8)))
      {


        float f1 = Arithmetic.asFloat(arg1);
        float f2 = Arithmetic.asFloat(arg2);
        comp = f1 == f2 ? 0 : f1 < f2 ? -1 : f1 > f2 ? 1 : -2; }
      break;
    

    case 10: 
    case 11: 
      if ((!exact) || ((code1 > 8) && (code2 > 8)))
      {


        double d1 = Arithmetic.asDouble(arg1);
        double d2 = Arithmetic.asDouble(arg2);
        comp = d1 == d2 ? 0 : d1 < d2 ? -1 : d1 > d2 ? 1 : -2; }
      break;
    }
    
    
    Numeric num1 = Arithmetic.asNumeric(arg1);
    Numeric num2 = Arithmetic.asNumeric(arg2);
    int comp = num1.compare(num2);
    
    return comp;
  }
  


  static boolean applyN(int flags, Object[] args)
  {
    for (int i = 0; i < args.length - 1; i++)
    {
      Object arg1 = args[i];
      Object arg2 = args[(i + 1)];
      if (!apply2(flags, arg1, arg2))
        return false;
    }
    return true;
  }
  


  public Object applyN(Object[] args)
  {
    return getLanguage().booleanObject(applyN(flags, args));
  }
}
