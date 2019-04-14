package gnu.xquery.util;

import gnu.kawa.functions.NumberCompare;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.XTimeType;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.math.DateTime;
import gnu.math.Duration;

public class Compare extends gnu.mapping.Procedure2
{
  static final int RESULT_GRT = 1;
  static final int RESULT_EQU = 0;
  static final int RESULT_LSS = -1;
  static final int RESULT_NAN = -2;
  static final int RESULT_NEQ = -3;
  static final int TRUE_IF_GRT = 16;
  static final int TRUE_IF_EQU = 8;
  static final int TRUE_IF_LSS = 4;
  static final int TRUE_IF_NAN = 2;
  static final int TRUE_IF_NEQ = 1;
  static final int VALUE_COMPARISON = 32;
  static final int LENIENT_COMPARISON = 64;
  static final int LENIENT_EQ = 72;
  int flags;
  
  public Compare() {}
  
  public static Compare make(String name, int flags)
  {
    Compare proc = new Compare();
    proc.setName(name);
    proc.setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateCompare");
    
    flags = flags;
    return proc;
  }
  


















  public static boolean apply(int flags, Object arg1, Object arg2, NamedCollator collator)
  {
    if ((arg1 instanceof Values))
    {
      Values values1 = (Values)arg1;
      int iter = 0;
      do
      {
        iter = values1.nextPos(iter);
        if (iter == 0)
          return false;
      } while (!apply(flags, values1.getPosPrevious(iter), arg2, collator));
      return true;
    }
    
    if ((arg2 instanceof Values))
    {
      Values values2 = (Values)arg2;
      int iter = 0;
      do
      {
        iter = values2.nextPos(iter);
        if (iter == 0)
          return false;
      } while (!apply(flags, arg1, values2.getPosPrevious(iter), collator));
      return true;
    }
    
    return atomicCompare(flags, KNode.atomicValue(arg1), KNode.atomicValue(arg2), collator);
  }
  



  public static boolean equalityComparison(int flags)
  {
    return ((flags & 0x10) != 0 ? 1 : 0) == ((flags & 0x4) != 0 ? 1 : 0);
  }
  

  public static boolean atomicCompare(int flags, Object arg1, Object arg2, NamedCollator collator)
  {
    if ((arg1 instanceof gnu.kawa.xml.UntypedAtomic))
    {
      String str = arg1.toString();
      if ((flags & 0x20) != 0) {
        arg1 = str;
      } else if ((arg2 instanceof DateTime)) {
        arg1 = XTimeType.parseDateTime(str, ((DateTime)arg2).components());
      } else if ((arg2 instanceof Duration)) {
        arg1 = Duration.parse(str, ((Duration)arg2).unit());
      } else if ((arg2 instanceof Number)) {
        arg1 = new DFloNum(str);
      } else if ((arg2 instanceof Boolean)) {
        arg1 = XDataType.booleanType.valueOf(str);
      } else
        arg1 = str;
    }
    if ((arg2 instanceof gnu.kawa.xml.UntypedAtomic))
    {
      String str = arg2.toString();
      if ((flags & 0x20) != 0) {
        arg2 = str;
      } else if ((arg1 instanceof DateTime)) {
        arg2 = XTimeType.parseDateTime(str, ((DateTime)arg1).components());
      } else if ((arg1 instanceof Duration)) {
        arg2 = Duration.parse(str, ((Duration)arg1).unit());
      } else if ((arg1 instanceof Number)) {
        arg2 = new DFloNum(str);
      } else if ((arg1 instanceof Boolean)) {
        arg2 = XDataType.booleanType.valueOf(str);
      } else {
        arg2 = str;
      }
    }
    if (((arg1 instanceof Number)) || ((arg2 instanceof Number))) { int comp;
      int comp;
      if ((arg1 instanceof Duration)) {
        int comp;
        if (!(arg2 instanceof Duration)) {
          comp = -3;
        }
        else {
          Duration d1 = (Duration)arg1;
          Duration d2 = (Duration)arg2;
          int comp; if (((unit != unit) || (unit == gnu.math.Unit.duration)) && (!equalityComparison(flags)))
          {
            comp = -3;
          } else
            comp = Duration.compare(d1, d2);
        }
      } else { int comp;
        if ((arg1 instanceof DateTime)) {
          int comp;
          if (!(arg2 instanceof DateTime)) {
            comp = -3;
          }
          else {
            DateTime d1 = (DateTime)arg1;
            DateTime d2 = (DateTime)arg2;
            int m1 = d1.components();
            int m2 = d2.components();
            int comp; if (m1 != m2) {
              comp = -3; } else { int comp;
              if ((!equalityComparison(flags)) && (m1 != 112) && (m1 != 14) && (m1 != 126))
              {


                comp = -3;
              } else
                comp = DateTime.compare(d1, d2);
            }
          } } else { int comp;
          if (((arg2 instanceof Duration)) || ((arg2 instanceof DateTime))) {
            comp = -3;
          } else
            comp = NumberCompare.compare(arg1, arg2, false); } }
      if ((comp == -3) && ((flags & 0x40) == 0))
        throw new IllegalArgumentException("values cannot be compared");
      return NumberCompare.checkCompareCode(comp, flags); }
    int comp;
    int comp; if ((arg1 instanceof Symbol)) {
      int comp;
      if (((arg2 instanceof Symbol)) && (equalityComparison(flags))) {
        comp = arg1.equals(arg2) ? 0 : -2;
      } else
        comp = -3;
    } else { int comp;
      if ((arg1 instanceof Boolean)) {
        int comp;
        if ((arg2 instanceof Boolean))
        {
          boolean b1 = ((Boolean)arg1).booleanValue();
          boolean b2 = ((Boolean)arg2).booleanValue();
          comp = b2 ? -1 : b1 == b2 ? 0 : 1;
        }
        else {
          comp = -3;
        } } else { int comp;
        if (((arg2 instanceof Boolean)) || ((arg2 instanceof Symbol))) {
          comp = -3;
        }
        else {
          String str1 = arg1.toString();
          String str2 = arg2.toString();
          int comp;
          if (collator != null) {
            comp = collator.compare(str1, str2);
          }
          else
            comp = NamedCollator.codepointCompare(str1, str2);
          comp = comp > 0 ? 1 : comp < 0 ? -1 : 0;
        } } }
    if ((comp == -3) && ((flags & 0x40) == 0))
      throw new IllegalArgumentException("values cannot be compared");
    return NumberCompare.checkCompareCode(comp, flags);
  }
  
  public Object apply2(Object arg1, Object arg2)
  {
    if ((flags & 0x20) != 0)
    {
      if ((arg1 == null) || (arg1 == Values.empty)) return arg1;
      if ((arg2 == null) || (arg2 == Values.empty)) return arg2;
      return atomicCompare(flags, KNode.atomicValue(arg1), KNode.atomicValue(arg2), null) ? Boolean.TRUE : Boolean.FALSE;
    }
    


    return apply(flags, arg1, arg2, null) ? Boolean.TRUE : Boolean.FALSE;
  }
  
  public static final Compare $Eq = make("=", 8);
  public static final Compare $Ex$Eq = make("!=", 23);
  
  public static final Compare $Gr = make(">", 16);
  public static final Compare $Gr$Eq = make(">=", 24);
  public static final Compare $Ls = make("<", 4);
  public static final Compare $Ls$Eq = make("<=", 12);
  
  public static final Compare valEq = make("eq", 40);
  
  public static final Compare valNe = make("ne", 55);
  
  public static final Compare valGt = make("gt", 48);
  
  public static final Compare valGe = make("ge", 56);
  
  public static final Compare valLt = make("lt", 36);
  
  public static final Compare valLe = make("le", 44);
}
