package gnu.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;







public class ConstantPool
{
  public static final byte CLASS = 7;
  public static final byte FIELDREF = 9;
  public static final byte METHODREF = 10;
  public static final byte INTERFACE_METHODREF = 11;
  public static final byte ANY_REF = -1;
  public static final byte STRING = 8;
  public static final byte INTEGER = 3;
  public static final byte FLOAT = 4;
  public static final byte LONG = 5;
  public static final byte DOUBLE = 6;
  public static final byte METHOD_HANDLE = 15;
  public static final byte METHOD_TYPE = 16;
  public static final byte INVOKE_DYNAMIC = 18;
  public static final byte NAME_AND_TYPE = 12;
  public static final byte UTF8 = 1;
  CpoolEntry[] pool;
  int count;
  boolean locked;
  CpoolEntry[] hashTab;
  
  public final int getCount()
  {
    return count;
  }
  




  public final CpoolEntry getPoolEntry(int index)
  {
    return pool[index];
  }
  




  void rehash()
  {
    if ((hashTab == null) && (count > 0))
    {

      int i = pool.length; for (;;) { i--; if (i < 0)
          break;
        CpoolEntry entry = pool[i];
        
        if (entry != null) {
          entry.hashCode();
        }
      }
    }
    hashTab = new CpoolEntry[count < 5 ? 101 : 2 * count];
    if (pool != null)
    {
      int i = pool.length; for (;;) { i--; if (i < 0)
          break;
        CpoolEntry entry = pool[i];
        if (entry != null) {
          entry.add_hashed(this);
        }
      }
    }
  }
  
  public CpoolUtf8 addUtf8(String s) {
    s = s.intern();
    int h = s.hashCode();
    

    if (hashTab == null) {
      rehash();
    }
    int index = (h & 0x7FFFFFFF) % hashTab.length;
    for (CpoolEntry entry = hashTab[index]; entry != null; entry = next)
    {
      if ((h == hash) && ((entry instanceof CpoolUtf8)))
      {
        CpoolUtf8 utf = (CpoolUtf8)entry;
        if (string == s)
          return utf;
      }
    }
    if (locked)
      throw new Error("adding new Utf8 entry to locked contant pool: " + s);
    return new CpoolUtf8(this, h, s);
  }
  
  public CpoolClass addClass(ObjectType otype)
  {
    CpoolClass entry = addClass(addUtf8(otype.getInternalName()));
    clas = otype;
    return entry;
  }
  
  public CpoolMethodHandle addMethodHandle(Method method) { int kind;
    int kind;
    if ((access_flags & 0x8) != 0) {
      kind = 6; } else { int kind;
      if (classfile.isInterface()) {
        kind = 9; } else { int kind;
        if ("<init>".equals(method.getName())) {
          kind = 8; } else { int kind;
          if ((access_flags & 0x2) != 0) {
            kind = 7;
          } else
            kind = 5; } } }
    return addMethodHandle(kind, addMethodRef(method));
  }
  
  public CpoolMethodHandle addMethodHandle(int kind, CpoolRef reference) {
    int h = CpoolMethodHandle.hashCode(kind, reference);
    

    if (hashTab == null)
      rehash();
    int index = (h & 0x7FFFFFFF) % hashTab.length;
    for (CpoolEntry entry = hashTab[index]; entry != null; 
        entry = next) {
      if ((h == hash) && ((entry instanceof CpoolMethodHandle)) && (kind == kind) && (reference == reference))
      {


        return (CpoolMethodHandle)entry; }
    }
    return new CpoolMethodHandle(this, h, kind, reference);
  }
  
  public CpoolClass addClass(CpoolUtf8 name)
  {
    int h = CpoolClass.hashCode(name);
    

    if (hashTab == null)
      rehash();
    int index = (h & 0x7FFFFFFF) % hashTab.length;
    for (CpoolEntry entry = hashTab[index]; entry != null; entry = next)
    {
      if ((h == hash) && ((entry instanceof CpoolClass)))
      {
        CpoolClass ent = (CpoolClass)entry;
        if (name == name)
          return ent;
      }
    }
    return new CpoolClass(this, h, name);
  }
  
  CpoolValue1 addValue1(int tag, int val)
  {
    int h = CpoolValue1.hashCode(val);
    

    if (hashTab == null)
      rehash();
    int index = (h & 0x7FFFFFFF) % hashTab.length;
    for (CpoolEntry entry = hashTab[index]; entry != null; entry = next)
    {
      if ((h == hash) && ((entry instanceof CpoolValue1)))
      {
        CpoolValue1 ent = (CpoolValue1)entry;
        if ((tag == tag) && (value == val))
          return ent;
      }
    }
    return new CpoolValue1(this, tag, h, val);
  }
  
  CpoolValue2 addValue2(int tag, long val)
  {
    int h = CpoolValue2.hashCode(val);
    

    if (hashTab == null)
      rehash();
    int index = (h & 0x7FFFFFFF) % hashTab.length;
    for (CpoolEntry entry = hashTab[index]; entry != null; entry = next)
    {
      if ((h == hash) && ((entry instanceof CpoolValue2)))
      {
        CpoolValue2 ent = (CpoolValue2)entry;
        if ((tag == tag) && (value == val))
          return ent;
      }
    }
    return new CpoolValue2(this, tag, h, val);
  }
  
  public CpoolValue1 addInt(int val)
  {
    return addValue1(3, val);
  }
  
  public CpoolValue2 addLong(long val)
  {
    return addValue2(5, val);
  }
  
  public CpoolValue1 addFloat(float val)
  {
    return addValue1(4, Float.floatToIntBits(val));
  }
  
  public CpoolValue2 addDouble(double val)
  {
    return addValue2(6, Double.doubleToLongBits(val));
  }
  
  public final CpoolString addString(String string)
  {
    return addString(addUtf8(string));
  }
  
  public CpoolString addString(CpoolUtf8 str)
  {
    int h = CpoolString.hashCode(str);
    

    if (hashTab == null)
      rehash();
    int index = (h & 0x7FFFFFFF) % hashTab.length;
    for (CpoolEntry entry = hashTab[index]; entry != null; entry = next)
    {
      if ((h == hash) && ((entry instanceof CpoolString)))
      {
        CpoolString ent = (CpoolString)entry;
        if (str == str)
          return ent;
      }
    }
    return new CpoolString(this, h, str);
  }
  
  public CpoolNameAndType addNameAndType(Method method)
  {
    CpoolUtf8 name = addUtf8(method.getName());
    CpoolUtf8 type = addUtf8(method.getSignature());
    return addNameAndType(name, type);
  }
  
  public CpoolNameAndType addNameAndType(Field field)
  {
    CpoolUtf8 name = addUtf8(field.getName());
    CpoolUtf8 type = addUtf8(field.getSignature());
    return addNameAndType(name, type);
  }
  

  public CpoolNameAndType addNameAndType(CpoolUtf8 name, CpoolUtf8 type)
  {
    int h = CpoolNameAndType.hashCode(name, type);
    

    if (hashTab == null)
      rehash();
    int index = (h & 0x7FFFFFFF) % hashTab.length;
    for (CpoolEntry entry = hashTab[index]; entry != null; entry = next)
    {
      if ((h == hash) && ((entry instanceof CpoolNameAndType)) && (name == name) && (type == type))
      {


        return (CpoolNameAndType)entry; }
    }
    return new CpoolNameAndType(this, h, name, type);
  }
  

  public CpoolRef addRef(int tag, CpoolClass clas, CpoolNameAndType nameAndType)
  {
    int h = CpoolRef.hashCode(clas, nameAndType);
    

    if (hashTab == null)
      rehash();
    int index = (h & 0x7FFFFFFF) % hashTab.length;
    for (CpoolEntry entry = hashTab[index]; entry != null; entry = next)
    {
      if ((h == hash) && ((entry instanceof CpoolRef)))
      {
        CpoolRef ref = (CpoolRef)entry;
        if ((tag == tag) && (clas == clas) && (nameAndType == nameAndType))
        {

          return ref; }
      }
    }
    return new CpoolRef(this, h, tag, clas, nameAndType);
  }
  
  public CpoolRef addMethodRef(Method method)
  {
    CpoolClass clas = addClass(classfile);
    int tag;
    int tag; if ((method.getDeclaringClass().getModifiers() & 0x200) == 0) {
      tag = 10;
    } else
      tag = 11;
    CpoolNameAndType nameType = addNameAndType(method);
    return addRef(tag, clas, nameType);
  }
  
  public CpoolRef addFieldRef(Field field)
  {
    CpoolClass clas = addClass(owner);
    int tag = 9;
    CpoolNameAndType nameType = addNameAndType(field);
    return addRef(tag, clas, nameType);
  }
  
  void write(DataOutputStream dstr) throws IOException
  {
    dstr.writeShort(count + 1);
    for (int i = 1; i <= count; i++)
    {
      CpoolEntry entry = pool[i];
      if (entry != null)
        entry.write(dstr);
    }
    locked = true;
  }
  



  CpoolEntry getForced(int index, int tag)
  {
    index &= 0xFFFF;
    CpoolEntry entry = pool[index];
    if (entry == null) {
      if (locked)
        throw new Error("adding new entry to locked contant pool");
      switch (tag) {
      case 1:  entry = new CpoolUtf8(); break;
      case 3: case 4: 
        entry = new CpoolValue1(tag); break;
      case 5: case 6: 
        entry = new CpoolValue2(tag); break;
      case 7:  entry = new CpoolClass(); break;
      case 8:  entry = new CpoolString(); break;
      case -1: case 9: 
      case 10: 
      case 11: 
        entry = new CpoolRef(tag); break;
      case 12:  entry = new CpoolNameAndType(); break;
      case 18:  entry = new CpoolInvokeDynamic(); break;
      case 15:  entry = new CpoolMethodHandle(); break;
      case 16:  entry = new CpoolMethodType(); break;
      case 0: case 2: case 13: case 14: case 17: default:  System.err.println("tag: " + tag);
      }
      pool[index] = entry;
      index = index;
    } else if (entry.getTag() != tag) {
      if (entry.getTag() == -1) {
        tag = tag;
      } else if (tag != -1)
        throw new ClassFormatError("conflicting constant pool tags at " + index);
    }
    return entry;
  }
  
  CpoolClass getForcedClass(int index)
  {
    return (CpoolClass)getForced(index, 7);
  }
  
  public ConstantPool() {}
  
  public ConstantPool(DataInputStream dstr)
    throws IOException
  {
    count = (dstr.readUnsignedShort() - 1);
    pool = new CpoolEntry[count + 1];
    for (int i = 1; i <= count; i++)
    {
      byte tag = dstr.readByte();
      CpoolEntry entry = getForced(i, tag);
      switch (tag)
      {
      case 1: 
        string = dstr.readUTF();
        break;
      case 3: 
      case 4: 
        value = dstr.readInt();
        break;
      case 5: 
      case 6: 
        value = dstr.readLong();
        i++;
        break;
      case 7: 
        name = ((CpoolUtf8)getForced(dstr.readUnsignedShort(), 1));
        
        break;
      case 8: 
        str = ((CpoolUtf8)getForced(dstr.readUnsignedShort(), 1));
        
        break;
      case 9: 
      case 10: 
      case 11: 
        CpoolRef ref = (CpoolRef)entry;
        clas = getForcedClass(dstr.readUnsignedShort());
        nameAndType = ((CpoolNameAndType)getForced(dstr.readUnsignedShort(), 12));
        
        break;
      case 15: 
        CpoolMethodHandle mh = (CpoolMethodHandle)entry;
        
        kind = dstr.readUnsignedByte();
        




        reference = ((CpoolRef)getForced(dstr.readUnsignedShort(), -1));
        
        break;
      case 16: 
        CpoolMethodType mt = (CpoolMethodType)entry;
        descriptor = ((CpoolUtf8)getForced(dstr.readUnsignedShort(), 1));
        
        break;
      case 18: 
        CpoolInvokeDynamic idyn = (CpoolInvokeDynamic)entry;
        bootstrapMethodIndex = dstr.readUnsignedShort();
        nameAndType = ((CpoolNameAndType)getForced(dstr.readUnsignedShort(), 12));
        
        break;
      case 12: 
        CpoolNameAndType ntyp = (CpoolNameAndType)entry;
        name = ((CpoolUtf8)getForced(dstr.readUnsignedShort(), 1));
        type = ((CpoolUtf8)getForced(dstr.readUnsignedShort(), 1));
      }
    }
  }
}
