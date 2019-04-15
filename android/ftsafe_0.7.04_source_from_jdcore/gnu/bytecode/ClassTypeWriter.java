package gnu.bytecode;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;









public class ClassTypeWriter
  extends PrintWriter
{
  ClassType ctype;
  int flags;
  public static final int PRINT_CONSTANT_POOL = 1;
  public static final int PRINT_CONSTANT_POOL_INDEXES = 2;
  public static final int PRINT_VERSION = 4;
  public static final int PRINT_EXTRAS = 8;
  public static final int PRINT_VERBOSE = 15;
  
  public ClassTypeWriter(ClassType ctype, Writer stream, int flags)
  {
    super(stream);
    this.ctype = ctype;
    this.flags = flags;
  }
  
  public ClassTypeWriter(ClassType ctype, OutputStream stream, int flags)
  {
    super(stream);
    this.ctype = ctype;
    this.flags = flags;
  }
  
  public void setFlags(int flags)
  {
    this.flags = flags;
  }
  
  public static void print(ClassType ctype, PrintWriter stream, int flags)
  {
    ClassTypeWriter writer = new ClassTypeWriter(ctype, stream, flags);
    writer.print();
    writer.flush();
  }
  
  public static void print(ClassType ctype, PrintStream stream, int flags)
  {
    ClassTypeWriter writer = new ClassTypeWriter(ctype, stream, flags);
    writer.print();
    writer.flush();
  }
  
  public void print()
  {
    if ((flags & 0x4) != 0)
    {
      print("Classfile format major version: ");
      print(ctype.getClassfileMajorVersion());
      print(", minor version: ");
      print(ctype.getClassfileMinorVersion());
      println('.');
    }
    if ((flags & 0x1) != 0)
      printConstantPool();
    printClassInfo();
    printFields();
    printMethods();
    printAttributes();
  }
  
  public void setClass(ClassType ctype)
  {
    this.ctype = ctype;
  }
  
  public void print(ClassType ctype)
  {
    this.ctype = ctype;
    print();
  }
  
  public void printAttributes()
  {
    AttrContainer attrs = ctype;
    println();
    print("Attributes (count: ");
    print(Attribute.count(attrs));
    println("):");
    printAttributes(attrs);
  }
  
  public void printAttributes(AttrContainer container)
  {
    for (Attribute attr = container.getAttributes(); 
        attr != null; attr = attr.getNext())
    {
      attr.print(this);
    }
  }
  
  public void printClassInfo()
  {
    println();
    print("Access flags:");
    int modifiers = ctype.getModifiers();
    print(Access.toString(modifiers, 'C'));
    println();
    print("This class: ");
    printOptionalIndex(ctype.thisClassIndex);
    printConstantTersely(ctype.thisClassIndex, 7);
    print(" super: ");
    if (ctype.superClassIndex == -1) {
      print("<unknown>");
    } else if (ctype.superClassIndex == 0) {
      print("0");
    }
    else {
      printOptionalIndex(ctype.superClassIndex);
      printConstantTersely(ctype.superClassIndex, 7);
    }
    println();
    print("Interfaces (count: ");
    int[] interfaces = ctype.interfaceIndexes;
    int n_interfaces = interfaces == null ? 0 : interfaces.length;
    print(n_interfaces);
    print("):");
    println();
    for (int i = 0; i < n_interfaces; i++)
    {
      print("- Implements: ");
      int index = interfaces[i];
      printOptionalIndex(index);
      printConstantTersely(index, 7);
      println();
    }
  }
  
  public void printFields()
  {
    println();
    print("Fields (count: ");
    print(ctype.fields_count);
    print("):");
    println();
    int ifield = 0;
    for (Field field = ctype.fields; 
        field != null; field = next)
    {
      print("Field name: ");
      if (name_index != 0)
        printOptionalIndex(name_index);
      print(field.getName());
      print(Access.toString(flags, 'F'));
      print(" Signature: ");
      if (signature_index != 0)
        printOptionalIndex(signature_index);
      printSignature(field.getType());
      println();
      printAttributes(field);ifield++;
    }
  }
  


  public void printMethods()
  {
    println();
    print("Methods (count: ");
    print(ctype.methods_count);
    print("):");
    println();
    for (Method method = ctype.methods; 
        method != null; method = next) {
      printMethod(method);
    }
  }
  
  public void printMethod(Method method) {
    println();
    print("Method name:");
    if (name_index != 0)
      printOptionalIndex(name_index);
    print('"');
    print(method.getName());
    print('"');
    print(Access.toString(access_flags, 'M'));
    print(" Signature: ");
    if (signature_index != 0)
      printOptionalIndex(signature_index);
    print('(');
    for (int i = 0; i < arg_types.length; i++)
    {
      if (i > 0)
        print(',');
      printSignature(arg_types[i]);
    }
    print(')');
    printSignature(return_type);
    println();
    printAttributes(method);
  }
  
  CpoolEntry getCpoolEntry(int index)
  {
    CpoolEntry[] pool = ctype.constants.pool;
    if ((pool == null) || (index < 0) || (index >= pool.length)) {
      return null;
    }
    return pool[index];
  }
  
  final void printConstantTersely(CpoolEntry entry, int expected_tag)
  {
    if (entry == null) {
      print("<invalid constant index>");
    } else if (entry.getTag() != expected_tag)
    {
      print("<unexpected constant type ");
      entry.print(this, 1);
      print('>');
    }
    else {
      entry.print(this, 0);
    }
  }
  
  final void printConstantTersely(int index, int expected_tag) {
    printConstantTersely(getCpoolEntry(index), expected_tag);
  }
  
  final void printContantUtf8AsClass(int type_index)
  {
    CpoolEntry entry = getCpoolEntry(type_index);
    if ((entry != null) && (entry.getTag() == 1))
    {
      String name = string;
      Type.printSignature(name, 0, name.length(), this);
    }
    else {
      printConstantTersely(type_index, 1);
    }
  }
  
  final void printConstantOperand(int index)
  {
    print(' ');
    printOptionalIndex(index);
    CpoolEntry[] pool = ctype.constants.pool;
    CpoolEntry entry;
    if ((pool == null) || (index < 0) || (index >= pool.length) || ((entry = pool[index]) == null))
    {
      print("<invalid constant index>");
    } else {
      CpoolEntry entry;
      print('<');
      entry.print(this, 1);
      print('>');
    }
  }
  
  public final void printQuotedString(String string)
  {
    print('"');
    int len = string.length();
    for (int i = 0; i < len; i++)
    {
      char ch = string.charAt(i);
      if (ch == '"') {
        print("\\\"");
      } else if ((ch >= ' ') && (ch < '')) {
        print(ch);
      } else if (ch == '\n') {
        print("\\n");
      }
      else {
        print("\\u");
        int j = 4; for (;;) { j--; if (j < 0) break;
          print(Character.forDigit(ch >> j * 4 & 0xF, 16));
        }
      } }
    print('"');
  }
  
  public void printConstantPool()
  {
    CpoolEntry[] pool = ctype.constants.pool;
    int length = ctype.constants.count;
    for (int i = 1; i <= length; i++)
    {
      CpoolEntry entry = pool[i];
      if (entry != null)
      {
        print('#');
        print(index);
        print(": ");
        entry.print(this, 2);
        println();
      }
    }
  }
  
  public final void printOptionalIndex(int index) {
    if ((index >= 0) && ((flags & 0x2) != 0))
    {
      print('#');
      print(index);
      print('=');
    }
  }
  
  public final void printOptionalIndex(CpoolEntry entry)
  {
    printOptionalIndex(index);
  }
  

  void printName(String name)
  {
    print(name);
  }
  




  public final int printSignature(String sig, int pos)
  {
    int len = sig.length();
    if (pos >= len)
    {
      print("<empty signature>");
      return pos;
    }
    int sig_length = Type.signatureLength(sig, pos);
    if (sig_length > 0)
    {
      String name = Type.signatureToName(sig.substring(pos, pos + sig_length));
      if (name != null)
      {
        print(name);
        return pos + sig_length;
      }
    }
    char c = sig.charAt(pos);
    if (c != '(')
    {
      print(c);
      return pos + 1;
    }
    int nargs = 0;
    pos++;
    print(c);
    for (;;)
    {
      if (pos >= len)
      {
        print("<truncated method signature>");
        return pos;
      }
      c = sig.charAt(pos);
      if (c == ')')
      {
        pos++;
        print(c);
        break;
      }
      if (nargs++ > 0)
        print(',');
      pos = printSignature(sig, pos);
    }
    return printSignature(sig, pos);
  }
  




























































  public final void printSignature(String sig)
  {
    int pos = printSignature(sig, 0);
    int len = sig.length();
    if (pos < len)
    {
      print("<trailing junk:");
      print(sig.substring(pos));
      print('>');
    }
  }
  
  public final void printSignature(Type type)
  {
    if (type == null) {
      print("<unknown type>");
    } else
      printSignature(type.getSignature());
  }
  
  public void printSpaces(int count) {
    for (;;) { 
      if (count < 0) break;
      print(' ');
    }
  }
}
