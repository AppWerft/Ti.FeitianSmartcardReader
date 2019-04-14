package gnu.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;






public class RuntimeAnnotationsAttr
  extends Attribute
{
  int dataLength;
  int numEntries;
  AnnotationEntry[] entries;
  
  public RuntimeAnnotationsAttr(String name, AnnotationEntry[] entries, int numEntries, AttrContainer container)
  {
    super(name);
    this.entries = entries;
    this.numEntries = numEntries;
    addToFrontOf(container);
  }
  
  public static RuntimeAnnotationsAttr getAnnotationsAttr(AttrContainer container, String name)
  {
    Attribute attr = Attribute.get(container, name);
    if (attr != null)
      return (RuntimeAnnotationsAttr)attr;
    return new RuntimeAnnotationsAttr(name, null, 0, container);
  }
  

  public static RuntimeAnnotationsAttr getRuntimeVisibleAnnotations(AttrContainer container)
  {
    return getAnnotationsAttr(container, "RuntimeVisibleAnnotations");
  }
  

  public static RuntimeAnnotationsAttr getRuntimeInvisibleAnnotations(AttrContainer container)
  {
    return getAnnotationsAttr(container, "RuntimeInvisibleAnnotations");
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> clas) {
    for (int i = 0; i < numEntries; i++) {
      AnnotationEntry ann = entries[i];
      if (ann.getAnnotationType().getReflectClass() == clas) {
        return (Annotation)Proxy.newProxyInstance(ann.getClass().getClassLoader(), new Class[] { clas }, ann);
      }
    }
    return null;
  }
  
  public static <T extends Annotation> T getAnnotation(AttrContainer container, Class<T> clas) {
    for (Attribute attr = container.getAttributes(); 
        attr != null; attr = attr.getNext()) {
      if ((attr instanceof RuntimeAnnotationsAttr)) {
        T ann = ((RuntimeAnnotationsAttr)attr).getAnnotation(clas);
        if (ann != null)
          return ann;
      }
    }
    return null;
  }
  







  public static void maybeAddAnnotation(AttrContainer container, AnnotationEntry annotation)
  {
    RetentionPolicy retention = annotation.getRetention();
    String attrname;
    if (retention == RetentionPolicy.RUNTIME) {
      attrname = "RuntimeVisibleAnnotations"; } else { String attrname;
      if (retention == RetentionPolicy.CLASS)
        attrname = "RuntimeInvisibleAnnotations"; else return;
    }
    String attrname;
    getAnnotationsAttr(container, attrname).addAnnotation(annotation);
  }
  
  public void addAnnotation(AnnotationEntry ann)
  {
    if (entries == null) {
      entries = new AnnotationEntry[4];
    } else if (entries.length <= numEntries) {
      AnnotationEntry[] tmp = new AnnotationEntry[2 * entries.length];
      System.arraycopy(entries, 0, tmp, 0, numEntries);
      entries = tmp;
    }
    entries[(numEntries++)] = ann;
  }
  


  public int getLength() { return dataLength; }
  
  public void print(ClassTypeWriter dst) {
    dst.print("Attribute \"");
    dst.print(getName());
    dst.print("\", length:");
    dst.print(getLength());
    dst.print(", number of entries: ");
    dst.println(numEntries);
    for (int i = 0; i < numEntries; i++) {
      dst.printSpaces(2);
      entries[i].print(2, dst);
      dst.println();
    }
  }
  
  static AnnotationEntry readAnnotationEntry(DataInputStream dstr, ConstantPool constants) throws IOException
  {
    AnnotationEntry aentry = new AnnotationEntry();
    int tindex = dstr.readUnsignedShort();
    CpoolEntry cpentry = constants.getForced(tindex, 1);
    annotationTypeIndex = tindex;
    annotationType = ((ClassType)Type.signatureToType(((CpoolUtf8)cpentry).getString()));
    int count = dstr.readUnsignedShort();
    for (int i = 0; i < count; i++) {
      int nindex = dstr.readUnsignedShort();
      cpentry = constants.getForced(nindex, 1);
      AnnotationEntry.Value value = readAnnotationValue(dstr, constants);
      nindex = nindex;
      aentry.addMember(((CpoolUtf8)cpentry).getString(), value);
    }
    return aentry;
  }
  
  static AnnotationEntry.Value readAnnotationValue(DataInputStream dstr, ConstantPool constants) throws IOException
  {
    byte kind = dstr.readByte();
    int expected = 0;
    AnnotationEntry.Value val = new AnnotationEntry.Value((char)kind, null, null);
    

    CpoolEntry cpentry;
    
    switch (kind) {
    case 66: 
    case 67: 
    case 73: 
    case 83: 
    case 90: 
      index1 = dstr.readUnsignedShort();
      cpentry = constants.getForced(index1, 3);
      int ivalue = value;
      if (kind == 73) { value = Integer.valueOf(ivalue);
      } else if (kind == 83) { value = Short.valueOf((short)ivalue);
      } else if (kind == 66) { value = Byte.valueOf((byte)ivalue);
      } else if (kind == 90) value = Boolean.valueOf(ivalue != 0); else
        value = Character.valueOf((char)ivalue);
      return val;
    case 74: 
      index1 = dstr.readUnsignedShort();
      cpentry = constants.getForced(index1, 5);
      value = Long.valueOf(value);
      return val;
    case 70: 
      index1 = dstr.readUnsignedShort();
      cpentry = constants.getForced(index1, 4);
      value = Float.valueOf(Float.intBitsToFloat(value));
      return val;
    case 68: 
      index1 = dstr.readUnsignedShort();
      cpentry = constants.getForced(index1, 6);
      value = Double.valueOf(Double.longBitsToDouble(value));
      return val;
    case 115: 
      index1 = dstr.readUnsignedShort();
      cpentry = constants.getForced(index1, 1);
      value = ((CpoolUtf8)cpentry).getString();
      return val;
    case 101: 
      index1 = dstr.readUnsignedShort();
      index2 = dstr.readUnsignedShort();
      cpentry = constants.getForced(index1, 1);
      String cname = ((CpoolUtf8)cpentry).getString();
      cpentry = constants.getForced(index2, 1);
      String ename = ((CpoolUtf8)cpentry).getString();
      value = new String[] { cname, ename };
      return val;
    case 99: 
      index1 = dstr.readUnsignedShort();
      cpentry = constants.getForced(index1, 1);
      value = ((CpoolUtf8)cpentry).getString();
      return val;
    case 91: 
      int count = dstr.readUnsignedShort();
      List<AnnotationEntry.Value> values = new ArrayList(count);
      
      for (int i = 0; i < count; i++)
        values.add(readAnnotationValue(dstr, constants));
      value = values;
      return val;
    case 64: 
      value = readAnnotationEntry(dstr, constants);
      return val;
    }
    
    
    return null;
  }
  
  public void assignConstants(ClassType cl) {
    super.assignConstants(cl);
    dataLength = 2;
    for (int i = 0; i < numEntries; i++)
      dataLength += assignConstants(entries[i], cl.getConstants());
  }
  
  static int assignConstants(AnnotationEntry aentry, ConstantPool constants) {
    Map<String, AnnotationEntry.Value> map = elementsValue;
    int dlen = 4;
    annotationTypeIndex = addUtf8annotationType.getSignature()).index;
    
    for (Map.Entry<String, AnnotationEntry.Value> e : map.entrySet()) {
      AnnotationEntry.Value val = (AnnotationEntry.Value)e.getValue();
      nindex = addUtf8getKeyindex;
      dlen += 2;
      dlen += assignConstants(val, constants);
    }
    return dlen;
  }
  
  static int assignConstants(AnnotationEntry.Value val, ConstantPool constants)
  {
    Object value = val.value;
    switch (kind)
    {
    case 'B': 
    case 'I': 
    case 'S': 
      if (index1 == 0)
        index1 = addIntintValueindex;
      return 3;
    case 'J': 
      if (index1 == 0)
        index1 = addLonglongValueindex;
      return 3;
    case 'F': 
      if (index1 == 0)
        index1 = addFloatfloatValueindex;
      return 3;
    case 'D': 
      if (index1 == 0)
        index1 = addDoubledoubleValueindex;
      return 3;
    case 'Z': 
      if (index1 == 0)
        index1 = addIntbooleanValue10index;
      return 3;
    case 'C': 
      if (index1 == 0)
        index1 = addIntcharValueindex;
      return 3;
    case 's': 
      if (index1 == 0)
        index1 = addUtf8index;
      return 3;
    case '[': 
      int dlen = 3;
      List<AnnotationEntry.Value> vals = (List)value;
      int sz = vals.size();
      for (int i = 0; i < sz; i++)
        dlen += assignConstants((AnnotationEntry.Value)vals.get(i), constants);
      return dlen;
    case 'e': 
      String[] sarr = AnnotationEntry.decodeEnumEntry(value);
      if (index1 == 0)
        index1 = addUtf80index;
      if (index2 == 0)
        index2 = addUtf81index;
      return 5;
    case 'c': 
      if (index1 == 0) {
        String str = (value instanceof String) ? (String)value : ((ClassType)value).getSignature();
        
        index1 = addUtf8index;
      }
      return 3;
    case '@': 
      return 1 + assignConstants((AnnotationEntry)value, constants);
    }
    throw new UnsupportedOperationException();
  }
  
  public void write(DataOutputStream dstr) throws IOException
  {
    dstr.writeShort(numEntries);
    for (int i = 0; i < numEntries; i++) {
      write(entries[i], getConstants(), dstr);
    }
  }
  
  static void write(AnnotationEntry aentry, ConstantPool constants, DataOutputStream dstr) throws IOException {
    dstr.writeShort(annotationTypeIndex);
    Map<String, AnnotationEntry.Value> map = elementsValue;
    dstr.writeShort(map.size());
    for (Map.Entry<String, AnnotationEntry.Value> e : map.entrySet()) {
      AnnotationEntry.Value val = (AnnotationEntry.Value)e.getValue();
      dstr.writeShort(nindex);
      write(val, constants, dstr);
    }
  }
  
  static void write(AnnotationEntry.Value val, ConstantPool constants, DataOutputStream dstr) throws IOException
  {
    Object value = val.value;
    int kind = val.kind;
    dstr.writeByte((byte)kind);
    switch (kind) {
    case 66: 
    case 67: 
    case 68: 
    case 70: 
    case 73: 
    case 74: 
    case 83: 
    case 90: 
    case 115: 
      dstr.writeShort(index1);
      break;
    case 91: 
      List<AnnotationEntry.Value> vals = (List)value;
      int sz = vals.size();
      dstr.writeShort(sz);
      for (int i = 0; i < sz; i++)
        write((AnnotationEntry.Value)vals.get(i), constants, dstr);
      break;
    case 101: 
      dstr.writeShort(index1);
      dstr.writeShort(index2);
      break;
    case 99: 
      dstr.writeShort(addUtf8getSignatureindex);
      break;
    case 64: 
      write((AnnotationEntry)value, constants, dstr);
      break;
    case 65: case 69: case 71: case 72: case 75: case 76: case 77: case 78: case 79: case 80: case 81: case 82: case 84: case 85: case 86: case 87: case 88: case 89: case 92: case 93: case 94: case 95: case 96: case 97: case 98: case 100: case 102: case 103: case 104: case 105: case 106: case 107: case 108: case 109: case 110: case 111: case 112: case 113: case 114: default: 
      throw new UnsupportedOperationException();
    }
  }
}
