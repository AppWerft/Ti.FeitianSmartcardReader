package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import gnu.math.IntNum;
import gnu.math.Numeric;

public class NumberPredicate extends Procedure1
{
  public static final int ODD = 1;
  public static final int EVEN = 2;
  final int op;
  Language language;
  
  protected final Language getLanguage()
  {
    return language;
  }
  
  public static boolean isOdd(Object obj) {
    return isOddEven(true, obj);
  }
  
  public static boolean isEven(Object obj) {
    return isOddEven(false, obj);
  }
  
  public static boolean isOddEven(boolean isOdd, Object obj) {
    obj = gnu.mapping.Promise.force(obj);
    IntNum iarg = IntNum.asIntNumOrNull(obj);
    if ((iarg == null) && ((obj instanceof Number)) && (((obj instanceof gnu.math.RealNum)) || (!(obj instanceof Numeric))))
    {
      double r = Math.IEEEremainder(((Number)obj).doubleValue(), 2.0D);
      if (r == 0.0D)
        return !isOdd;
      if ((r == -1.0D) || (r == 1.0D))
        return isOdd;
    }
    if (iarg == null) {
      throw new gnu.mapping.WrongType(-4, obj, gnu.kawa.lispexpr.LangObjType.integerType);
    }
    
    return iarg.isOdd() == isOdd;
  }
  
  public Object apply1(Object arg1) {
    boolean result;
    switch (op) {
    case 1:  result = isOddEven(true, arg1); break;
    case 2:  result = isOddEven(false, arg1); break;
    default:  throw new Error();
    }
    return getLanguage().booleanObject(result);
  }
  
  public NumberPredicate(Language language, String name, int op)
  {
    super(name);
    this.language = language;
    this.op = op;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplySimpleBoolean");
    
    setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileNumPredicate");
  }
  

  public int numArgs()
  {
    return 4097;
  }
}
