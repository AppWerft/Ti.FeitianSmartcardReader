package gnu.kawa.reflect;

import gnu.bytecode.Type;

public class MultValuesType extends OccurrenceType
{
  Type[] itemTypes;
  
  public MultValuesType(Type[] itemTypes)
  {
    super(SingletonType.instance, itemTypes.length, itemTypes.length);
    this.itemTypes = itemTypes;
  }
  
  public int getValueCount() { return itemTypes.length; }
  public Type getValueType(int index) { return itemTypes[index]; }
  
  public Type getImplementationType() {
    return itemTypes.length == 1 ? Type.objectType : gnu.expr.Compilation.typeValues;
  }
  
  public static Type create(Type[] itemTypes)
  {
    if (itemTypes.length == 1) {
      Type t0 = itemTypes[0];
      return t0 == null ? SingletonType.getInstance() : t0;
    }
    return new MultValuesType(itemTypes);
  }
  
  public String toString() {
    StringBuilder sbuf = new StringBuilder();
    sbuf.append("mult-values[");
    for (int i = 0; i < itemTypes.length; i++) {
      if (i > 0)
        sbuf.append(' ');
      sbuf.append(itemTypes[i]);
    }
    sbuf.append(']');
    return sbuf.toString();
  }
  
  public int isCompatibleWithValue(Type valueType) {
    if ((valueType instanceof LazyType))
      valueType = ((LazyType)valueType).getValueType();
    if (Type.isSame(this, valueType))
      return 2;
    if ((valueType instanceof MultValuesType)) {
      Type[] items = itemTypes;
      MultValuesType mOther = (MultValuesType)valueType;
      Type[] itemsOther = itemTypes;
      if (items.length != itemsOther.length)
        return -3;
      int prev = 2;
      for (int i = 0; i < items.length; i++) {
        Type item = items[i];
        Type itemOther = itemsOther[i];
        if (item == null)
          item = Type.objectType;
        int cmp = item.isCompatibleWithValue(itemOther);
        if (cmp < 0)
          return cmp;
        if (cmp < prev)
          prev = cmp;
      }
      return prev;
    }
    return super.isCompatibleWithValue(valueType);
  }
  
  public int compare(Type other)
  {
    if ((other instanceof LazyType))
      other = ((LazyType)other).getValueType();
    if ((other instanceof MultValuesType)) {
      MultValuesType mOther = (MultValuesType)other;
      if (this == other)
        return 0;
      Type[] items = itemTypes;
      Type[] itemsOther = itemTypes;
      if (items.length != itemsOther.length)
        return -3;
      int prev = 0;
      for (int i = 0; i < items.length; i++) {
        Type item = items[i];
        Type itemOther = itemsOther[i];
        if (item == null)
          item = Type.objectType;
        int cmp = item.compare(itemOther);
        if (cmp == -3)
          return -3;
        if ((cmp != 0) && (cmp != prev))
        {
          prev = -2; }
      }
      return prev;
    }
    return super.compare(other);
  }
  
  public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
    out.writeObject(itemTypes);
  }
  
  public void readExternal(java.io.ObjectInput in) throws java.io.IOException, ClassNotFoundException {
    itemTypes = ((Type[])in.readObject());
    base = SingletonType.instance;
    minOccurs = itemTypes.length;
    maxOccurs = itemTypes.length;
  }
}
