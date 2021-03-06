package gnu.bytecode;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class ArrayType extends ObjectType implements java.io.Externalizable
{
  public Type elements;
  
  public ArrayType(Type elements)
  {
    this(elements, elements.getName() + "[]");
  }
  
  ArrayType(Type elements, String name) {
    this_name = name;
    this.elements = elements;
  }
  
  public String getSignature() {
    if (signature == null)
      setSignature("[" + elements.getSignature());
    return signature;
  }
  
  public Type getImplementationType() {
    Type eltype = elements.getImplementationType();
    return elements == eltype ? this : make(eltype);
  }
  
  public Type getRawType()
  {
    Type eltype = elements.getRawType();
    return elements == eltype ? this : make(eltype);
  }
  
  static ArrayType make(String name)
  {
    Type elements = Type.getType(name.substring(0, name.length() - 2));
    ArrayType array_type = array_type;
    if (array_type == null) {
      array_type = new ArrayType(elements, name);
      array_type = array_type;
    }
    return array_type;
  }
  
  public static ArrayType make(Type elements)
  {
    ArrayType array_type = elements.array_type;
    if (array_type == null) {
      array_type = new ArrayType(elements, elements.getName() + "[]");
      elements.array_type = array_type;
    }
    return array_type;
  }
  
  public Type getComponentType() { return elements; }
  
  public String getInternalName() { return getSignature(); }
  
  public Class getReflectClass() {
    try {
      if (reflectClass == null) {
        String cname = getInternalName().replace('/', '.');
        Class elClass = elements.getReflectClass();
        reflectClass = Class.forName(cname, false, elClass.getClassLoader());
      }
      
      flags |= 0x10;
    } catch (ClassNotFoundException ex) {
      if ((flags & 0x10) != 0) {
        RuntimeException rex = new RuntimeException("no such array class: " + getName());
        
        rex.initCause(ex);
        throw rex;
      }
    }
    return reflectClass;
  }
  
  public int getMethods(Filter filter, int searchSupers, List<Method> result) {
    if (searchSupers > 0) {
      int count = Type.objectType.getMethods(filter, 0, result);
      if ((searchSupers > 1) && (filter.select(Type.clone_method))) {
        if (result != null) {
          Method meth = Type.clone_method;
          result.add(meth);
        }
        count++;
      }
      return count;
    }
    return 0;
  }
  
  public int isCompatibleWithValue(Type valueType)
  {
    if ((valueType instanceof ArrayType)) {
      return getComponentType().isCompatibleWithValue(((ArrayType)valueType).getComponentType());
    }
    
    if (valueType == nullType)
      return 2;
    if (valueType == objectType)
      return 0;
    return -1;
  }
  
  public int compare(Type other) {
    if (other == nullType)
      return 1;
    if ((other instanceof ArrayType))
      return elements.compare(elements);
    if ((other.getName().equals("java.lang.Object")) || (other == toStringType))
    {
      return -1;
    }
    return -3;
  }
  
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeObject(elements);
  }
  
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
  {
    elements = ((Type)in.readObject());
  }
  
  public Object readResolve() throws java.io.ObjectStreamException {
    ArrayType array_type = elements.array_type;
    if (array_type != null) {
      return array_type;
    }
    elements.array_type = this;
    return this;
  }
}
