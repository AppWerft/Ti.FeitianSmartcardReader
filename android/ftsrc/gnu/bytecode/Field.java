package gnu.bytecode;

import java.io.DataOutputStream;

public class Field extends Location
  implements AttrContainer, Member
{
  int flags;
  Field next;
  Attribute attributes;
  ClassType owner;
  String sourceName;
  java.lang.reflect.Field rfield;
  
  public final Attribute getAttributes() { return attributes; }
  
  public final void setAttributes(Attribute attributes) { this.attributes = attributes; }
  









  public Field(ClassType ctype)
  {
    if (last_field == null) {
      fields = this;
    } else
      last_field.next = this;
    last_field = this;
    fields_count += 1;
    owner = ctype;
  }
  
  public final ClassType getDeclaringClass() {
    return owner;
  }
  
  public final ConstantPool getConstants() {
    return owner.constants;
  }
  
  public final void setStaticFlag(boolean is_static) {
    if (is_static) {
      flags |= 0x8;
    } else
      flags ^= 0xFFFFFFF7;
  }
  
  public final boolean getStaticFlag() {
    return (flags & 0x8) != 0;
  }
  
  public final int getFlags() {
    return flags;
  }
  
  public final int getModifiers() {
    return flags;
  }
  
  public final void setModifiers(int modifiers) {
    flags = modifiers;
  }
  
  public Type getType()
  {
    synchronized (this) {
      Type t = super.getType();
      if ((t == null) && (rfield != null)) {
        t = Type.make(rfield.getType(), rfield.getGenericType());
        super.setType(t);
      }
      return t;
    }
  }
  
  void write(DataOutputStream dstr, ClassType classfile) throws java.io.IOException
  {
    dstr.writeShort(flags);
    dstr.writeShort(name_index);
    dstr.writeShort(signature_index);
    
    Attribute.writeAll(this, dstr);
  }
  
  void assign_constants(ClassType classfile) {
    ConstantPool constants = constants;
    Type t = getType();
    String signature = t.getSignature();
    String genericSignature = t.getGenericSignature();
    if ((genericSignature != null) && (!genericSignature.equals(signature))) {
      SignatureAttr attr = new SignatureAttr(genericSignature);
      attr.addToFrontOf(this);
    }
    if ((name_index == 0) && (name != null))
      name_index = addUtf8name).index;
    if ((signature_index == 0) && (t != null))
      signature_index = addUtf8index;
    Attribute.assignConstants(this, classfile);
  }
  
  public synchronized java.lang.reflect.Field getReflectField() throws NoSuchFieldException
  {
    if (rfield == null)
      rfield = owner.getReflectClass().getDeclaredField(getName());
    return rfield;
  }
  
  public <T extends java.lang.annotation.Annotation> T getAnnotation(Class<T> clas)
  {
    T ann = RuntimeAnnotationsAttr.getAnnotation(this, clas);
    if (ann != null)
      return ann;
    return rfield == null ? null : rfield.getAnnotation(clas);
  }
  
  public void setSourceName(String name) {
    sourceName = name;
  }
  
  public String getSourceName() {
    if (sourceName == null)
      sourceName = getName().intern();
    return sourceName;
  }
  
  public static Field searchField(Field fields, String name)
  {
    for (; 
        

        fields != null; fields = next) {
      if (fields.getSourceName() == name)
        return fields;
    }
    return null;
  }
  
  public final Field getNext() {
    return next;
  }
  





  public final void setConstantValue(Object value, ClassType ctype)
  {
    ConstantPool cpool = constants;
    if (cpool == null)
      constants = (cpool = new ConstantPool());
    char sig1 = getType().getSignature().charAt(0);
    CpoolEntry entry;
    switch (sig1) {
    case 'Z': 
      entry = cpool.addInt(PrimType.booleanValue(value) ? 1 : 0);
      break;
    case 'C': 
      if ((value instanceof Character))
        entry = cpool.addInt(((Character)value).charValue());
      break;
    

    case 'B': 
    case 'I': 
    case 'S': 
      entry = cpool.addInt(((Number)value).intValue());
      break;
    case 'J': 
      entry = cpool.addLong(((Number)value).longValue());
      break;
    case 'F': 
      entry = cpool.addFloat(((Number)value).floatValue());
      break;
    case 'D': 
      entry = cpool.addDouble(((Number)value).doubleValue());
      break;
    }
    CpoolEntry entry = cpool.addString(value.toString());
    
    ConstantValueAttr attr = new ConstantValueAttr(entry.getIndex());
    attr.addToFrontOf(this);
  }
  
  public boolean hasConstantValueAttr() {
    return Attribute.get(this, "ConstantValue") != null;
  }
  
  public String toString() {
    StringBuffer sbuf = new StringBuffer(100);
    sbuf.append("Field:");
    sbuf.append(getDeclaringClass().getName());
    sbuf.append('.');
    sbuf.append(name);
    return sbuf.toString();
  }
}
