package gnu.bytecode;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;





public class ClassFileInput
  extends DataInputStream
{
  ClassType ctype;
  InputStream str;
  
  public ClassFileInput(InputStream str)
    throws IOException
  {
    super(str);
  }
  
  public ClassFileInput(ClassType ctype, InputStream str)
    throws IOException, ClassFormatError
  {
    super(str);
    this.ctype = ctype;
    if (!readHeader())
      throw new ClassFormatError("invalid magic number");
    constants = readConstants();
    readClassInfo();
    readFields();
    readMethods();
    readAttributes(ctype);
  }
  



  public static ClassType readClassType(InputStream str)
    throws IOException, ClassFormatError
  {
    ClassType ctype = new ClassType();
    new ClassFileInput(ctype, str);
    return ctype;
  }
  
  public boolean readHeader() throws IOException
  {
    int magic = readInt();
    if (magic != -889275714)
      return false;
    readFormatVersion();
    return true;
  }
  
  public void readFormatVersion() throws IOException
  {
    int minor = readUnsignedShort();
    int major = readUnsignedShort();
    ctype.classfileFormatVersion = (major * 65536 + minor);
  }
  
  public ConstantPool readConstants() throws IOException
  {
    return new ConstantPool(this);
  }
  
  public void readClassInfo() throws IOException
  {
    ctype.access_flags = readUnsignedShort();
    


    ctype.thisClassIndex = readUnsignedShort();
    CpoolClass clas = getClassConstant(ctype.thisClassIndex);
    String name = name.string;
    ctype.this_name = name.replace('/', '.');
    ctype.setSignature("L" + name + ";");
    
    ctype.superClassIndex = readUnsignedShort();
    if (ctype.superClassIndex == 0) {
      ctype.setSuper((ClassType)null);
    }
    else {
      clas = getClassConstant(ctype.superClassIndex);
      name = name.string;
      ctype.setSuper(name.replace('/', '.'));
    }
    
    int nInterfaces = readUnsignedShort();
    if (nInterfaces > 0)
    {
      ctype.interfaces = new ClassType[nInterfaces];
      ctype.interfaceIndexes = new int[nInterfaces];
      for (int i = 0; i < nInterfaces; i++)
      {
        int index = readUnsignedShort();
        ctype.interfaceIndexes[i] = index;
        clas = (CpoolClass)ctype.constants.getForced(index, 7);
        
        name = name.string.replace('/', '.');
        ctype.interfaces[i] = ClassType.make(name);
      }
    }
  }
  
  public int readAttributes(AttrContainer container) throws IOException
  {
    int count = readUnsignedShort();
    Attribute last = container.getAttributes();
    for (int i = 0; i < count; i++)
    {
      if (last != null)
      {
        for (;;)
        {
          Attribute next = last.getNext();
          if (next == null)
            break;
          last = next;
        }
      }
      
      int index = readUnsignedShort();
      CpoolUtf8 nameConstant = (CpoolUtf8)ctype.constants.getForced(index, 1);
      
      int length = readInt();
      nameConstant.intern();
      Attribute attr = readAttribute(string, length, container);
      if (attr != null)
      {
        if (attr.getNameIndex() == 0)
          attr.setNameIndex(index);
        if (last == null) {
          container.setAttributes(attr);
        }
        else {
          if (container.getAttributes() == attr)
          {
            container.setAttributes(attr.getNext());
            attr.setNext(null);
          }
          last.setNext(attr);
        }
        last = attr;
      }
    }
    return count;
  }
  
  public final void skipAttribute(int length)
    throws IOException
  {
    int read = 0;
    while (read < length)
    {
      int skipped = (int)skip(length - read);
      if (skipped == 0)
      {
        if (read() < 0) {
          throw new EOFException("EOF while reading class files attributes");
        }
        skipped = 1;
      }
      read += skipped;
    }
  }
  
  public Attribute readAttribute(String name, int length, AttrContainer container)
    throws IOException
  {
    if ((name == "SourceFile") && ((container instanceof ClassType)))
    {
      return new SourceFileAttr(readUnsignedShort(), (ClassType)container);
    }
    if ((name == "Code") && ((container instanceof Method)))
    {
      CodeAttr code = new CodeAttr((Method)container);
      fixup_count = -1;
      code.setMaxStack(readUnsignedShort());
      code.setMaxLocals(readUnsignedShort());
      int code_len = readInt();
      byte[] insns = new byte[code_len];
      readFully(insns);
      code.setCode(insns);
      int exception_table_length = readUnsignedShort();
      for (int i = 0; i < exception_table_length; i++)
      {
        int start_pc = readUnsignedShort();
        int end_pc = readUnsignedShort();
        int handler_pc = readUnsignedShort();
        int catch_type = readUnsignedShort();
        code.addHandler(start_pc, end_pc, handler_pc, catch_type);
      }
      readAttributes(code);
      return code;
    }
    if ((name == "LineNumberTable") && ((container instanceof CodeAttr)))
    {
      int count = 2 * readUnsignedShort();
      short[] numbers = new short[count];
      for (int i = 0; i < count; i++)
      {
        numbers[i] = readShort();
      }
      return new LineNumbersAttr(numbers, (CodeAttr)container);
    }
    if ((name == "LocalVariableTable") && ((container instanceof CodeAttr)))
    {
      CodeAttr code = (CodeAttr)container;
      LocalVarsAttr attr = new LocalVarsAttr(code);
      Method method = attr.getMethod();
      if (parameter_scope == null)
        parameter_scope = method.pushScope();
      Scope scope = parameter_scope;
      if (end == null)
        end = new Label(PC);
      ConstantPool constants = method.getConstants();
      int count = readUnsignedShort();
      int prev_start = start.position;
      int prev_end = end.position;
      for (int i = 0; i < count; i++)
      {
        Variable var = new Variable();
        int start_pc = readUnsignedShort();
        int end_pc = start_pc + readUnsignedShort();
        
        if ((start_pc != prev_start) || (end_pc != prev_end))
        {

          while ((parent != null) && ((start_pc < start.position) || (end_pc > end.position)))
          {
            scope = parent; }
          Scope parent = scope;
          scope = new Scope(new Label(start_pc), new Label(end_pc));
          scope.linkChild(parent);
          prev_start = start_pc;
          prev_end = end_pc;
        }
        scope.addVariable(var);
        var.setName(readUnsignedShort(), constants);
        var.setSignature(readUnsignedShort(), constants);
        offset = readUnsignedShort();
      }
      return attr;
    }
    if ((name == "Signature") && ((container instanceof Member)))
    {
      return new SignatureAttr(readUnsignedShort(), (Member)container);
    }
    if ((name == "StackMapTable") && ((container instanceof CodeAttr)))
    {
      byte[] data = new byte[length];
      readFully(data, 0, length);
      return new StackMapTableAttr(data, (CodeAttr)container);
    }
    if (((name == "RuntimeVisibleAnnotations") || (name == "RuntimeInvisibleAnnotations")) && (((container instanceof Field)) || ((container instanceof Method)) || ((container instanceof ClassType))))
    {




      int numEntries = readUnsignedShort();
      AnnotationEntry[] entries = new AnnotationEntry[numEntries];
      for (int i = 0; i < numEntries; i++)
      {
        entries[i] = RuntimeAnnotationsAttr.readAnnotationEntry(this, container.getConstants());
      }
      return new RuntimeAnnotationsAttr(name, entries, numEntries, container);
    }
    if ((name == "ConstantValue") && ((container instanceof Field)))
    {
      return new ConstantValueAttr(readUnsignedShort());
    }
    if ((name == "InnerClasses") && ((container instanceof ClassType)))
    {
      int count = 4 * readUnsignedShort();
      short[] data = new short[count];
      for (int i = 0; i < count; i++)
      {
        data[i] = readShort();
      }
      return new InnerClassesAttr(data, (ClassType)container);
    }
    if ((name == "EnclosingMethod") && ((container instanceof ClassType)))
    {
      int class_index = readUnsignedShort();
      int method_index = readUnsignedShort();
      return new EnclosingMethodAttr(class_index, method_index, (ClassType)container);
    }
    if ((name == "Exceptions") && ((container instanceof Method)))
    {
      Method meth = (Method)container;
      int count = readUnsignedShort();
      short[] exn_indices = new short[count];
      for (int i = 0; i < count; i++)
        exn_indices[i] = readShort();
      meth.setExceptions(exn_indices);
      return meth.getExceptionAttr();
    }
    if ((name == "SourceDebugExtension") && ((container instanceof ClassType)))
    {
      SourceDebugExtAttr attr = new SourceDebugExtAttr((ClassType)container);
      
      byte[] data = new byte[length];
      readFully(data, 0, length);
      data = data;
      dlength = length;
      return attr;
    }
    if ((name == "AnnotationDefault") && ((container instanceof Method)))
    {
      AnnotationEntry.Value value = RuntimeAnnotationsAttr.readAnnotationValue(this, container.getConstants());
      return new AnnotationDefaultAttr(name, value, container);
    }
    

    byte[] data = new byte[length];
    readFully(data, 0, length);
    return new MiscAttr(name, data);
  }
  
  public void readFields()
    throws IOException
  {
    int nFields = readUnsignedShort();
    ConstantPool constants = ctype.constants;
    for (int i = 0; i < nFields; i++)
    {
      int flags = readUnsignedShort();
      int nameIndex = readUnsignedShort();
      int descriptorIndex = readUnsignedShort();
      Field fld = ctype.addField();
      fld.setName(nameIndex, constants);
      fld.setSignature(descriptorIndex, constants);
      flags = flags;
      readAttributes(fld);
    }
  }
  
  public void readMethods() throws IOException
  {
    int nMethods = readUnsignedShort();
    for (int i = 0; i < nMethods; i++)
    {
      int flags = readUnsignedShort();
      int nameIndex = readUnsignedShort();
      int descriptorIndex = readUnsignedShort();
      Method meth = ctype.addMethod(null, flags);
      meth.setName(nameIndex);
      meth.setSignature(descriptorIndex);
      readAttributes(meth);
    }
  }
  
  CpoolClass getClassConstant(int index)
  {
    return (CpoolClass)ctype.constants.getForced(index, 7);
  }
}
