package gnu.bytecode;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;





public class AnnotationEntry
  implements InvocationHandler, Annotation
{
  ClassType annotationType;
  int annotationTypeIndex;
  
  public RetentionPolicy getRetention()
  {
    Annotation retention = getAnnotationType().getReflectClass().getAnnotation(Retention.class);
    
    if (retention == null)
      return RetentionPolicy.CLASS;
    return ((Retention)retention).value();
  }
  





  public boolean hasTarget(ElementType etype)
  {
    Annotation target = getAnnotationType().getReflectClass().getAnnotation(Target.class);
    
    if (target == null)
      return true;
    if (etype != null)
    {
      ElementType[] etypes = (ElementType[])((Target)target).value();
      int i = etypes.length; do { i--; if (i < 0) break;
      } while (etypes[i] != etype);
      return true;
    }
    return false;
  }
  

  public AnnotationEntry() {}
  

  public AnnotationEntry(ClassType annotationType)
  {
    this.annotationType = annotationType;
  }
  
  LinkedHashMap<String, Value> elementsValue = new LinkedHashMap(10);
  
  public ClassType getAnnotationType()
  {
    return annotationType;
  }
  
  public void addMember(String name, Value value)
  {
    elementsValue.put(name, value);
  }
  
  public void addMember(String name, Object value, Type type)
  {
    elementsValue.put(name, asAnnotationValue(value, type));
  }
  
  public static Value asAnnotationValue(Object val, Type type)
  {
    String sig = type.getSignature();
    char kind = sig.charAt(0);
    switch (kind) {
    case 'B': 
      val = Byte.valueOf(((Number)val).byteValue()); break;
    case 'S':  val = Short.valueOf(((Number)val).shortValue()); break;
    case 'I':  val = Integer.valueOf(((Number)val).intValue()); break;
    case 'J':  val = Long.valueOf(((Number)val).longValue()); break;
    case 'L': 
      if (sig.equals("Ljava/lang/String;"))
      {
        kind = 's';
        val = ((CharSequence)val).toString();
      }
      else if (sig.equals("Ljava/lang/Class;"))
      {
        kind = 'c';
        if ((val instanceof Type)) {
          val = (Type)val;
        } else {
          val = Type.make((Class)val);
        }
      } else if (((ClassType)type).isSubclass("java.lang.Enum"))
      {
        kind = 'e';
      }
      else if (((ClassType)type).implementsInterface(Type.javalangannotationAnnotationType))
      {
        kind = '@';
        val = (AnnotationEntry)Proxy.getInvocationHandler(val);
      }
      break;
    case '[': 
      Type eltype = ((ArrayType)type).getComponentType();
      List<Value> alist = new ArrayList();
      if ((val instanceof List))
      {
        List<?> lst = (List)val;
        int len = lst.size();
        for (int i = 0; i < len; i++) {
          alist.add(asAnnotationValue(lst.get(i), eltype));
        }
      }
      else {
        int len = Array.getLength(val);
        for (int i = 0; i < len; i++)
          alist.add(asAnnotationValue(Array.get(val, i), eltype));
      }
      val = alist;
    }
    
    return new Value(kind, type, val);
  }
  




  public Class<? extends Annotation> annotationType()
  {
    return annotationType.getReflectClass();
  }
  







  public boolean equals(Object obj)
  {
    if (!(obj instanceof AnnotationEntry))
      return false;
    AnnotationEntry other = (AnnotationEntry)obj;
    if (!getAnnotationType().getName().equals(other.getAnnotationType().getName()))
      return false;
    for (Map.Entry<String, Value> it : elementsValue.entrySet())
    {
      String key = (String)it.getKey();
      Value value1 = (Value)it.getValue();
      Value value2 = (Value)elementsValue.get(key);
      if (value1 != value2)
      {
        if ((value1 == null) || (value2 == null) || (!value1.equals(value2)))
        {
          return false; }
      }
    }
    for (Map.Entry<String, Value> it : elementsValue.entrySet())
    {
      String key = (String)it.getKey();
      Object value2 = it.getValue();
      Object value1 = elementsValue.get(key);
      if (value1 != value2)
      {
        if ((value1 == null) || (value2 == null) || (!value1.equals(value2)))
        {
          return false; }
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int hash = 0;
    

    for (Map.Entry<String, Value> it : elementsValue.entrySet())
    {
      int khash = ((String)it.getKey()).hashCode();
      int vhash = ((Value)it.getValue()).hashCode();
      hash += (127 * khash ^ vhash);
    }
    return hash;
  }
  
  public String toString()
  {
    StringBuilder sbuf = new StringBuilder();
    sbuf.append('@');
    sbuf.append(getAnnotationType().getName());
    sbuf.append('(');
    int count = 0;
    for (Map.Entry<String, Value> it : elementsValue.entrySet())
    {
      if (count > 0)
        sbuf.append(", ");
      sbuf.append((String)it.getKey());
      sbuf.append('=');
      sbuf.append(it.getValue());
      count++;
    }
    sbuf.append(')');
    return sbuf.toString();
  }
  
  public void print(int indentation, ClassTypeWriter dst)
  {
    dst.printOptionalIndex(annotationTypeIndex);
    dst.print('@');
    String cname = annotationType != null ? annotationType.getSignature() : ((CpoolUtf8)ctype.constants.getPoolEntry(annotationTypeIndex)).getString();
    
    Type.printSignature(cname, 0, cname.length(), dst);
    int count = elementsValue.size();
    indentation += 2;
    for (Map.Entry<String, Value> e : elementsValue.entrySet())
    {
      dst.println();
      String key = (String)e.getKey();
      Value val = (Value)e.getValue();
      dst.printSpaces(indentation);
      dst.printOptionalIndex(nindex);
      dst.print(key);
      dst.print(" => ");
      val.print(indentation, dst);
    }
  }
  
  public Object invoke(Object proxy, Method method, Object[] args)
  {
    String mname = method.getName();
    int nargs = args == null ? 0 : args.length;
    if ((mname.equals("toString")) && (nargs == 0))
      return toString();
    if ((mname.equals("hashCode")) && (nargs == 0))
      return Integer.valueOf(hashCode());
    return ((Value)elementsValue.get(mname)).getValue();
  }
  



  public static class Value
  {
    Type type;
    


    char kind;
    

    Object value;
    

    Object valuex;
    

    int nindex;
    

    int index1;
    

    int index2;
    


    public Value(char kind, Type type, Object value)
    {
      this.kind = kind;
      this.type = type;
      this.value = value;
    }
    





    public Object getValue()
    {
      if (kind == '[')
      {
        if (valuex == null)
        {
          List<? extends Value> lvalue = (List)value;
          
          int n = lvalue.size();
          Class eltype = this.type.getReflectClass().getComponentType();
          Object arr = Array.newInstance(eltype, n);
          for (int i = 0; i < n; i++)
            Array.set(arr, i, ((Value)lvalue.get(i)).getValue());
          valuex = arr;
        }
        return valuex;
      }
      if (kind == 'e') {
        if (valuex == null) {
          if ((value instanceof Enum)) {
            valuex = value;
          } else {
            String name;
            ClassType type;
            String name;
            if ((value instanceof Field)) {
              Field f = (Field)value;
              ClassType type = f.getDeclaringClass();
              name = f.getName();
            } else {
              String[] sarr = (String[])value;
              type = (ClassType)Type.signatureToType(sarr[0]);
              name = sarr[1];
            }
            Class<?> clas = type.getReflectClass();
            Class<? extends Enum> eclas = clas.asSubclass(Enum.class);
            Enum val = Enum.valueOf(eclas, name);
            valuex = val;
          }
        }
        return valuex;
      }
      
      return value;
    }
    
    public String toString() { return getValue().toString(); }
    
























    public void print(int indentation, ClassTypeWriter out)
    {
      if ((flags & 0x8) != 0)
      {
        out.print("(kind:");
        if ((kind >= 'A') && (kind <= 'z')) {
          out.print(kind);
        } else
          out.print(kind);
        out.print(") ");
      }
      int expected = 0;
      String cname; switch (kind)
      {
      case 'B': 
      case 'C': 
      case 'D': 
      case 'F': 
      case 'I': 
      case 'J': 
      case 'S': 
      case 'Z': 
      case 's': 
        out.printOptionalIndex(out.getCpoolEntry(index1));
        if ((value instanceof String)) {
          out.printQuotedString((String)value);
        } else
          out.print(value.toString());
        break;
      case 'e': 
        String[] sarr = AnnotationEntry.decodeEnumEntry(value);
        cname = sarr[0];
        String ename = sarr[1];
        out.print("enum[");
        if ((flags & 0x8) != 0)
          out.print("type:");
        out.printOptionalIndex(index1);
        Type.printSignature(cname, 0, cname.length(), out);
        if ((flags & 0x8) != 0) {
          out.print(" value:");
        } else
          out.print(' ');
        out.printOptionalIndex(index2);
        out.print(ename);
        out.print("]");
        break;
      case 'c': 
        out.printOptionalIndex(index1);
        cname = (value instanceof String) ? (String)value : ((ClassType)value).getSignature();
        
        Type.printSignature(cname, 0, cname.length(), out);
        break;
      case '@': 
        ((AnnotationEntry)value).print(indentation + 2, out);
        break;
      case '[': 
        List<Value> vals = (List)value;
        int sz = vals.size();
        out.print("array length:");
        out.print(sz);
        for (int i = 0; i < sz; i++)
        {
          out.println();
          out.printSpaces(indentation + 2);
          out.print(i);
          out.print(": ");
          ((Value)vals.get(i)).print(indentation + 2, out);
        }
      }
      
    }
  }
  
  static String[] decodeEnumEntry(Object value)
  {
    if ((value instanceof Field)) {
      Field fld = (Field)value;
      return new String[] { fld.getDeclaringClass().getSignature(), fld.getName() };
    }
    

    if ((value instanceof Enum)) {
      Enum evalue = (Enum)value;
      return new String[] { ClassType.nameToSignature(evalue.getDeclaringClass().getName()), evalue.name() };
    }
    


    return (String[])value;
  }
}
