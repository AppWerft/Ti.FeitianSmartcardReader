// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;

public class ClassFileInput extends DataInputStream
{
    ClassType ctype;
    InputStream str;
    
    public ClassFileInput(final InputStream str) throws IOException {
        super(str);
    }
    
    public ClassFileInput(final ClassType ctype, final InputStream str) throws IOException, ClassFormatError {
        super(str);
        this.ctype = ctype;
        if (!this.readHeader()) {
            throw new ClassFormatError("invalid magic number");
        }
        ctype.constants = this.readConstants();
        this.readClassInfo();
        this.readFields();
        this.readMethods();
        this.readAttributes(ctype);
    }
    
    public static ClassType readClassType(final InputStream str) throws IOException, ClassFormatError {
        final ClassType ctype = new ClassType();
        new ClassFileInput(ctype, str);
        return ctype;
    }
    
    public boolean readHeader() throws IOException {
        final int magic = this.readInt();
        if (magic != -889275714) {
            return false;
        }
        this.readFormatVersion();
        return true;
    }
    
    public void readFormatVersion() throws IOException {
        final int minor = this.readUnsignedShort();
        final int major = this.readUnsignedShort();
        this.ctype.classfileFormatVersion = major * 65536 + minor;
    }
    
    public ConstantPool readConstants() throws IOException {
        return new ConstantPool(this);
    }
    
    public void readClassInfo() throws IOException {
        this.ctype.access_flags = this.readUnsignedShort();
        this.ctype.thisClassIndex = this.readUnsignedShort();
        CpoolClass clas = this.getClassConstant(this.ctype.thisClassIndex);
        String name = clas.name.string;
        this.ctype.this_name = name.replace('/', '.');
        this.ctype.setSignature("L" + name + ";");
        this.ctype.superClassIndex = this.readUnsignedShort();
        if (this.ctype.superClassIndex == 0) {
            this.ctype.setSuper((ClassType)null);
        }
        else {
            clas = this.getClassConstant(this.ctype.superClassIndex);
            name = clas.name.string;
            this.ctype.setSuper(name.replace('/', '.'));
        }
        final int nInterfaces = this.readUnsignedShort();
        if (nInterfaces > 0) {
            this.ctype.interfaces = new ClassType[nInterfaces];
            this.ctype.interfaceIndexes = new int[nInterfaces];
            for (int i = 0; i < nInterfaces; ++i) {
                final int index = this.readUnsignedShort();
                this.ctype.interfaceIndexes[i] = index;
                clas = (CpoolClass)this.ctype.constants.getForced(index, 7);
                name = clas.name.string.replace('/', '.');
                this.ctype.interfaces[i] = ClassType.make(name);
            }
        }
    }
    
    public int readAttributes(final AttrContainer container) throws IOException {
        final int count = this.readUnsignedShort();
        Attribute last = container.getAttributes();
        for (int i = 0; i < count; ++i) {
            if (last != null) {
                while (true) {
                    final Attribute next = last.getNext();
                    if (next == null) {
                        break;
                    }
                    last = next;
                }
            }
            final int index = this.readUnsignedShort();
            final CpoolUtf8 nameConstant = (CpoolUtf8)this.ctype.constants.getForced(index, 1);
            final int length = this.readInt();
            nameConstant.intern();
            final Attribute attr = this.readAttribute(nameConstant.string, length, container);
            if (attr != null) {
                if (attr.getNameIndex() == 0) {
                    attr.setNameIndex(index);
                }
                if (last == null) {
                    container.setAttributes(attr);
                }
                else {
                    if (container.getAttributes() == attr) {
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
    
    public final void skipAttribute(final int length) throws IOException {
        int skipped;
        for (int read = 0; read < length; read += skipped) {
            skipped = (int)this.skip(length - read);
            if (skipped == 0) {
                if (this.read() < 0) {
                    throw new EOFException("EOF while reading class files attributes");
                }
                skipped = 1;
            }
        }
    }
    
    public Attribute readAttribute(final String name, final int length, final AttrContainer container) throws IOException {
        if (name == "SourceFile" && container instanceof ClassType) {
            return new SourceFileAttr(this.readUnsignedShort(), (ClassType)container);
        }
        if (name == "Code" && container instanceof Method) {
            final CodeAttr code = new CodeAttr((Method)container);
            code.fixup_count = -1;
            code.setMaxStack(this.readUnsignedShort());
            code.setMaxLocals(this.readUnsignedShort());
            final int code_len = this.readInt();
            final byte[] insns = new byte[code_len];
            this.readFully(insns);
            code.setCode(insns);
            for (int exception_table_length = this.readUnsignedShort(), i = 0; i < exception_table_length; ++i) {
                final int start_pc = this.readUnsignedShort();
                final int end_pc = this.readUnsignedShort();
                final int handler_pc = this.readUnsignedShort();
                final int catch_type = this.readUnsignedShort();
                code.addHandler(start_pc, end_pc, handler_pc, catch_type);
            }
            this.readAttributes(code);
            return code;
        }
        if (name == "LineNumberTable" && container instanceof CodeAttr) {
            final int count = 2 * this.readUnsignedShort();
            final short[] numbers = new short[count];
            for (int j = 0; j < count; ++j) {
                numbers[j] = this.readShort();
            }
            return new LineNumbersAttr(numbers, (CodeAttr)container);
        }
        if (name == "LocalVariableTable" && container instanceof CodeAttr) {
            final CodeAttr code = (CodeAttr)container;
            final LocalVarsAttr attr = new LocalVarsAttr(code);
            final Method method = attr.getMethod();
            if (attr.parameter_scope == null) {
                attr.parameter_scope = method.pushScope();
            }
            Scope scope = attr.parameter_scope;
            if (scope.end == null) {
                scope.end = new Label(code.PC);
            }
            final ConstantPool constants = method.getConstants();
            final int count2 = this.readUnsignedShort();
            int prev_start = scope.start.position;
            int prev_end = scope.end.position;
            for (int k = 0; k < count2; ++k) {
                final Variable var = new Variable();
                final int start_pc2 = this.readUnsignedShort();
                final int end_pc2 = start_pc2 + this.readUnsignedShort();
                if (start_pc2 != prev_start || end_pc2 != prev_end) {
                    while (scope.parent != null && (start_pc2 < scope.start.position || end_pc2 > scope.end.position)) {
                        scope = scope.parent;
                    }
                    final Scope parent = scope;
                    scope = new Scope(new Label(start_pc2), new Label(end_pc2));
                    scope.linkChild(parent);
                    prev_start = start_pc2;
                    prev_end = end_pc2;
                }
                scope.addVariable(var);
                var.setName(this.readUnsignedShort(), constants);
                var.setSignature(this.readUnsignedShort(), constants);
                var.offset = this.readUnsignedShort();
            }
            return attr;
        }
        if (name == "Signature" && container instanceof Member) {
            return new SignatureAttr(this.readUnsignedShort(), (Member)container);
        }
        if (name == "StackMapTable" && container instanceof CodeAttr) {
            final byte[] data = new byte[length];
            this.readFully(data, 0, length);
            return new StackMapTableAttr(data, (CodeAttr)container);
        }
        if ((name == "RuntimeVisibleAnnotations" || name == "RuntimeInvisibleAnnotations") && (container instanceof Field || container instanceof Method || container instanceof ClassType)) {
            final int numEntries = this.readUnsignedShort();
            final AnnotationEntry[] entries = new AnnotationEntry[numEntries];
            for (int j = 0; j < numEntries; ++j) {
                entries[j] = RuntimeAnnotationsAttr.readAnnotationEntry(this, container.getConstants());
            }
            return new RuntimeAnnotationsAttr(name, entries, numEntries, container);
        }
        if (name == "ConstantValue" && container instanceof Field) {
            return new ConstantValueAttr(this.readUnsignedShort());
        }
        if (name == "InnerClasses" && container instanceof ClassType) {
            final int count = 4 * this.readUnsignedShort();
            final short[] data2 = new short[count];
            for (int j = 0; j < count; ++j) {
                data2[j] = this.readShort();
            }
            return new InnerClassesAttr(data2, (ClassType)container);
        }
        if (name == "EnclosingMethod" && container instanceof ClassType) {
            final int class_index = this.readUnsignedShort();
            final int method_index = this.readUnsignedShort();
            return new EnclosingMethodAttr(class_index, method_index, (ClassType)container);
        }
        if (name == "Exceptions" && container instanceof Method) {
            final Method meth = (Method)container;
            final int count3 = this.readUnsignedShort();
            final short[] exn_indices = new short[count3];
            for (int l = 0; l < count3; ++l) {
                exn_indices[l] = this.readShort();
            }
            meth.setExceptions(exn_indices);
            return meth.getExceptionAttr();
        }
        if (name == "SourceDebugExtension" && container instanceof ClassType) {
            final SourceDebugExtAttr attr2 = new SourceDebugExtAttr((ClassType)container);
            final byte[] data3 = new byte[length];
            this.readFully(data3, 0, length);
            attr2.data = data3;
            attr2.dlength = length;
            return attr2;
        }
        if (name == "AnnotationDefault" && container instanceof Method) {
            final AnnotationEntry.Value value = RuntimeAnnotationsAttr.readAnnotationValue(this, container.getConstants());
            return new AnnotationDefaultAttr(name, value, container);
        }
        final byte[] data = new byte[length];
        this.readFully(data, 0, length);
        return new MiscAttr(name, data);
    }
    
    public void readFields() throws IOException {
        final int nFields = this.readUnsignedShort();
        final ConstantPool constants = this.ctype.constants;
        for (int i = 0; i < nFields; ++i) {
            final int flags = this.readUnsignedShort();
            final int nameIndex = this.readUnsignedShort();
            final int descriptorIndex = this.readUnsignedShort();
            final Field fld = this.ctype.addField();
            fld.setName(nameIndex, constants);
            fld.setSignature(descriptorIndex, constants);
            fld.flags = flags;
            this.readAttributes(fld);
        }
    }
    
    public void readMethods() throws IOException {
        for (int nMethods = this.readUnsignedShort(), i = 0; i < nMethods; ++i) {
            final int flags = this.readUnsignedShort();
            final int nameIndex = this.readUnsignedShort();
            final int descriptorIndex = this.readUnsignedShort();
            final Method meth = this.ctype.addMethod(null, flags);
            meth.setName(nameIndex);
            meth.setSignature(descriptorIndex);
            this.readAttributes(meth);
        }
    }
    
    CpoolClass getClassConstant(final int index) {
        return (CpoolClass)this.ctype.constants.getForced(index, 7);
    }
}
