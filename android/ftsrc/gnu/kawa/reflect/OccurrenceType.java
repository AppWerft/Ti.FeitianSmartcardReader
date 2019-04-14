package gnu.kawa.reflect;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.lists.ItemPredicate;
import gnu.mapping.Values;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class OccurrenceType
  extends Type
  implements java.io.Externalizable, gnu.expr.TypeValue
{
  Type base;
  int minOccurs;
  int maxOccurs;
  
  public Type getBase() { return base; }
  protected void setBase(Type base) { this.base = base; }
  public int minOccurs() { return minOccurs; }
  public int maxOccurs() { return maxOccurs; }
  
  public OccurrenceType(Type base, int minOccurs, int maxOccurs)
  {
    super(Type.objectType);
    setName(null);
    this.base = base;
    this.minOccurs = minOccurs;
    this.maxOccurs = maxOccurs;
  }
  
  public static Type getInstance(Type base, int minOccurs, int maxOccurs)
  {
    if ((minOccurs == 1) && (maxOccurs == 1))
      return base;
    if ((minOccurs == 0) && (maxOccurs < 0) && ((base == SingletonType.instance) || (base == Type.pointer_type)))
    {
      return Type.pointer_type; }
    if ((base instanceof OccurrenceType)) {
      OccurrenceType occ = (OccurrenceType)base;
      minOccurs *= minOccurs;
      maxOccurs = (maxOccurs < 0) || (maxOccurs < 0) ? -1 : maxOccurs * maxOccurs;
      
      base = base;
    }
    return new OccurrenceType(base, minOccurs, maxOccurs);
  }
  
  public static final Type emptySequenceType = getInstance(SingletonType.instance, 0, 0);
  

  public Type getImplementationType()
  {
    return Type.pointer_type;
  }
  
  public int compare(Type other)
  {
    if ((other instanceof LazyType))
      other = ((LazyType)other).getValueType();
    if ((other instanceof OccurrenceType))
    {
      OccurrenceType occOther = (OccurrenceType)other;
      if ((minOccurs == minOccurs) && (maxOccurs == maxOccurs))
      {
        return base.compare(occOther.getBase()); }
    }
    int numThis = itemCountRange(this);
    int numOther = itemCountRange(other);
    int minThis = numThis & 0xFFF;
    int minOther = numOther & 0xFFF;
    int maxThis = numThis >> 12;
    int maxOther = numOther >> 12;
    if (((minThis > maxOther) && (maxOther >= 0)) || ((minOther > maxThis) && (maxThis >= 0)))
    {
      return -3;
    }
    




    return -2;
  }
  


























  public Object coerceFromObject(Object obj)
  {
    if (!(obj instanceof Values))
    {




      if ((minOccurs <= 1) && (maxOccurs != 0)) {
        return base.coerceFromObject(obj);
      }
    }
    if (!isInstance(obj))
      throw new ClassCastException();
    return obj;
  }
  
  public boolean isInstance(Object obj)
  {
    if ((obj instanceof Values))
    {
      Values vals = (Values)obj;
      int pos = vals.startPos();
      int n = 0;
      if ((base instanceof ItemPredicate))
      {
        ItemPredicate pred = (ItemPredicate)base;
        
        for (;;)
        {
          boolean matches = pred.isInstancePos(vals, pos);
          pos = vals.nextPos(pos);
          if (pos == 0)
          {
            return (n >= minOccurs) && ((maxOccurs < 0) || (n <= maxOccurs));
          }
          
          if (!matches)
            return false;
          n++;
        }
      }
      


      for (;;)
      {
        pos = vals.nextPos(pos);
        if (pos == 0)
        {
          return (n >= minOccurs) && ((maxOccurs < 0) || (n <= maxOccurs));
        }
        
        Object value = vals.getPosPrevious(pos);
        if (!base.isInstance(value))
          return false;
        n++;
      }
    }
    


    if ((minOccurs > 1) || (maxOccurs == 0))
      return false;
    return base.isInstance(obj);
  }
  


  public void emitTestIf(Variable incoming, Declaration decl, Compilation comp)
  {
    CodeAttr code = comp.getCode();
    if (incoming != null)
      code.emitLoad(incoming);
    if (decl != null)
    {
      code.emitDup();
      decl.compileStore(comp);
    }
    comp.compileConstant(this);
    code.emitSwap();
    code.emitInvokeVirtual(isInstanceMethod);
    code.emitIfIntNotZero();
  }
  

  public void emitIsInstance(Variable incoming, Compilation comp, gnu.expr.Target target)
  {
    InstanceOf.emitIsInstance(this, incoming, comp, target);
  }
  
  public gnu.expr.Expression convertValue(gnu.expr.Expression value)
  {
    return null;
  }
  
  public gnu.mapping.Procedure getConstructor()
  {
    return null;
  }
  




  public static int itemCountRange(Type type)
  {
    if ((type instanceof SingletonType))
      return 4097;
    if ((type instanceof OccurrenceType))
    {
      OccurrenceType occ = (OccurrenceType)type;
      int min = occ.minOccurs();
      int max = occ.maxOccurs();
      int bnum = itemCountRange(occ.getBase());
      if (((min == 1) && (max == 1)) || (bnum == 0))
      {
        return bnum; }
      if (max > 1048575)
        max = -1;
      if (max == 0)
        return 0;
      int bmin = bnum & 0xFFF;
      int bmax = bnum >> 12;
      if (bnum != 4097)
      {
        if (min > 4095)
          min = 4095;
        min *= bmin;
        if (min > 4095)
          min = 4095;
        if ((max < 0) || (bmax < 0)) {
          max = -1;
        } else
          max *= bmax;
        if (max > 1048575)
          max = -1;
      }
      return max << 12 | min;
    }
    if ((type instanceof gnu.bytecode.PrimType))
      return type.isVoid() ? 0 : 4097;
    if ((type instanceof gnu.bytecode.ArrayType))
      return 4097;
    if ((type instanceof gnu.bytecode.ObjectType))
    {
      int cmp = type.compare(Compilation.typeValues);
      if (cmp == -3)
        return 4097;
    }
    return 61440;
  }
  







  public static char itemCountCode(Type type)
  {
    int num = itemCountRange(type);
    int min = num & 0xFFF;
    int max = num >> 12;
    return (min == 1) && (max == 1) ? '1' : min == 0 ? '*' : max == 1 ? '?' : max == 0 ? '0' : '+';
  }
  



  public static boolean itemCountIsZeroOrOne(Type type)
  {
    return itemCountRange(type) >> 13 == 0;
  }
  
  public static int itemCountMin(Type type) {
    return itemCountRange(type) & 0xFFF;
  }
  
  public static int itemCountMax(Type type) {
    return itemCountRange(type) >> 12;
  }
  
  public static boolean itemCountIsOne(Type type)
  {
    return itemCountRange(type) == 4097;
  }
  
  public static int compatibleWithCount(Type type, int count) {
    int num = itemCountRange(type);
    int min = num & 0xFFF;
    int max = num >> 12;
    return (max >= 0) && (count > max) ? 1 : count < min ? -1 : 0;
  }
  




  public static Type itemPrimeType(Type type)
  {
    while ((type instanceof OccurrenceType))
      type = ((OccurrenceType)type).getBase();
    return itemCountIsOne(type) ? type : SingletonType.instance;
  }
  

  public String toString()
  {
    String b = base.toString();
    boolean parens = (b == null) || (b.indexOf(' ') >= 0);
    StringBuffer sbuf = new StringBuffer();
    if (parens)
      sbuf.append('(');
    sbuf.append(b);
    if (parens)
      sbuf.append(')');
    if ((minOccurs != 1) || (maxOccurs != 1))
    {
      if ((minOccurs == 0) && (maxOccurs == 1)) {
        sbuf.append('?');
      } else if ((minOccurs == 1) && (maxOccurs == -1)) {
        sbuf.append('+');
      } else if ((minOccurs == 0) && (maxOccurs == -1)) {
        sbuf.append('*');
      }
      else {
        sbuf.append('{');
        sbuf.append(minOccurs);
        sbuf.append(',');
        if (maxOccurs >= 0) {
          sbuf.append(maxOccurs);
        } else
          sbuf.append('*');
        sbuf.append('}');
      } }
    return sbuf.toString();
  }
  
  public void writeExternal(ObjectOutput out) throws java.io.IOException
  {
    out.writeObject(base);
    out.writeInt(minOccurs);
    out.writeInt(maxOccurs);
  }
  
  public void readExternal(ObjectInput in)
    throws java.io.IOException, ClassNotFoundException
  {
    base = ((Type)in.readObject());
    minOccurs = in.readInt();
    maxOccurs = in.readInt();
  }
  
  public String encodeType(gnu.expr.Language language) {
    return null;
  }
  
  public static final gnu.bytecode.ClassType typeOccurrenceType = gnu.bytecode.ClassType.make("gnu.kawa.reflect.OccurrenceType");
  
  static final gnu.bytecode.Method isInstanceMethod = typeOccurrenceType.getDeclaredMethod("isInstance", 1);
}
