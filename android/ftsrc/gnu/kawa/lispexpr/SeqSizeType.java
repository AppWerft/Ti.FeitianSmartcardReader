package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import java.util.List;

public class SeqSizeType extends LangObjType
{
  int requiredSize;
  boolean requiredExact;
  
  public SeqSizeType(String name, int requiredSize, boolean requiredExact, String implClass)
  {
    super(name, implClass, -1);
    this.requiredSize = requiredSize;
    this.requiredExact = requiredExact;
  }
  
  public SeqSizeType(int requiredSize, boolean requiredExact, String implClass) {
    this((requiredExact ? "list#=" : "list#>=") + requiredSize, requiredSize, requiredExact, implClass);
  }
  

  public Object coerceFromObject(Object obj)
  {
    List list = (List)obj;
    int size = list.size();
    if (requiredExact ? size == requiredSize : size >= requiredSize)
      return list;
    throw new ClassCastException();
  }
  
  public static void checkSizeEq(List list, int requiredSize) {
    int sz = list.size();
    if (sz != requiredSize)
      throw new ClassCastException("sequence has size " + sz + " should be " + requiredSize);
  }
  
  public static void checkSizeGe(List list, int requiredSize) {
    int sz = list.size();
    if (sz < requiredSize)
      throw new ClassCastException("sequence has size " + sz + " should be at least " + requiredSize);
  }
  
  public static List coerceEqOrNull(Object object, int requiredSize) {
    if ((object instanceof List)) {
      List list = (List)object;
      if (list.size() == requiredSize)
        return list;
    }
    return null;
  }
  
  public static List coerceGeOrNull(Object object, int requiredSize) {
    if ((object instanceof List)) {
      List list = (List)object;
      if (list.size() >= requiredSize)
        return list;
    }
    return null;
  }
  
  public void emitCoerceFromObject(CodeAttr code)
  {
    code.emitCheckcast(implementationType);
    code.emitDup();
    code.emitPushInt(requiredSize);
    ClassType thisCl = ClassType.make("gnu.kawa.lispexpr.SeqSizeType");
    code.emitInvokeStatic(thisCl.getDeclaredMethod(requiredExact ? "checkSizeEq" : "checkSizeGe", 2));
  }
  
  public boolean emitCoercionOrNull(CodeAttr code) {
    ClassType thisCl = ClassType.make("gnu.kawa.lispexpr.SeqSizeType");
    code.emitPushInt(requiredSize);
    code.emitInvokeStatic(thisCl.getDeclaredMethod(requiredExact ? "coerceEqOrNull" : "coerceGeOrNull", 2));
    return true;
  }
  
  public int isCompatibleWithValue(Type valueType)
  {
    return Type.isSame(this, valueType) ? 2 : Type.isCompatibleWithValue(this, valueType);
  }
  
  public int compare(Type other)
  {
    if ((other instanceof SeqSizeType)) {
      SeqSizeType sother = (SeqSizeType)other;
      if ((requiredSize != requiredSize) && (
        ((requiredExact) && (requiredExact)) || ((requiredExact) && (requiredSize < requiredSize)) || ((requiredExact) && (requiredSize > requiredSize))))
      {


        return -3;
      }
      
      if (getImplementationType() == sother.getImplementationType()) {
        if ((requiredSize == requiredSize) && (requiredExact) && (requiredExact))
        {
          return 0; }
        if ((requiredSize < requiredSize) && (!requiredExact))
          return 1;
        if ((requiredSize > requiredSize) && (!requiredExact))
          return -1;
      }
    }
    int r = getImplementationType().compare(other);
    return r == -3 ? -3 : (r == 0) || (r == -1) ? -1 : -2;
  }
}
