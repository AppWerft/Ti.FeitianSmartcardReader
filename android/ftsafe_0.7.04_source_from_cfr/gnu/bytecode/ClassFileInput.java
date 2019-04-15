/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.AnnotationDefaultAttr;
import gnu.bytecode.AnnotationEntry;
import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.ConstantValueAttr;
import gnu.bytecode.CpoolClass;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolUtf8;
import gnu.bytecode.EnclosingMethodAttr;
import gnu.bytecode.ExceptionsAttr;
import gnu.bytecode.Field;
import gnu.bytecode.InnerClassesAttr;
import gnu.bytecode.Label;
import gnu.bytecode.LineNumbersAttr;
import gnu.bytecode.LocalVarsAttr;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.MiscAttr;
import gnu.bytecode.RuntimeAnnotationsAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.SignatureAttr;
import gnu.bytecode.SourceDebugExtAttr;
import gnu.bytecode.SourceFileAttr;
import gnu.bytecode.StackMapTableAttr;
import gnu.bytecode.Variable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class ClassFileInput
extends DataInputStream {
    ClassType ctype;
    InputStream str;

    public ClassFileInput(InputStream str) throws IOException {
        super(str);
    }

    public ClassFileInput(ClassType ctype, InputStream str) throws IOException, ClassFormatError {
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

    public static ClassType readClassType(InputStream str) throws IOException, ClassFormatError {
        ClassType ctype = new ClassType();
        new ClassFileInput(ctype, str);
        return ctype;
    }

    public boolean readHeader() throws IOException {
        int magic = this.readInt();
        if (magic != -889275714) {
            return false;
        }
        this.readFormatVersion();
        return true;
    }

    public void readFormatVersion() throws IOException {
        int minor = this.readUnsignedShort();
        int major = this.readUnsignedShort();
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
        } else {
            clas = this.getClassConstant(this.ctype.superClassIndex);
            name = clas.name.string;
            this.ctype.setSuper(name.replace('/', '.'));
        }
        int nInterfaces = this.readUnsignedShort();
        if (nInterfaces > 0) {
            this.ctype.interfaces = new ClassType[nInterfaces];
            this.ctype.interfaceIndexes = new int[nInterfaces];
            for (int i = 0; i < nInterfaces; ++i) {
                int index;
                this.ctype.interfaceIndexes[i] = index = this.readUnsignedShort();
                clas = (CpoolClass)this.ctype.constants.getForced(index, 7);
                name = clas.name.string.replace('/', '.');
                this.ctype.interfaces[i] = ClassType.make(name);
            }
        }
    }

    public int readAttributes(AttrContainer container) throws IOException {
        int count = this.readUnsignedShort();
        Attribute last = container.getAttributes();
        for (int i = 0; i < count; ++i) {
            if (last != null) {
                Attribute next;
                while ((next = last.getNext()) != null) {
                    last = next;
                }
            }
            int index = this.readUnsignedShort();
            CpoolUtf8 nameConstant = (CpoolUtf8)this.ctype.constants.getForced(index, 1);
            int length = this.readInt();
            nameConstant.intern();
            Attribute attr = this.readAttribute(nameConstant.string, length, container);
            if (attr == null) continue;
            if (attr.getNameIndex() == 0) {
                attr.setNameIndex(index);
            }
            if (last == null) {
                container.setAttributes(attr);
            } else {
                if (container.getAttributes() == attr) {
                    container.setAttributes(attr.getNext());
                    attr.setNext(null);
                }
                last.setNext(attr);
            }
            last = attr;
        }
        return count;
    }

    public final void skipAttribute(int length) throws IOException {
        int skipped;
        for (int read2 = 0; read2 < length; read2 += skipped) {
            skipped = (int)this.skip(length - read2);
            if (skipped != 0) continue;
            if (this.read() < 0) {
                throw new EOFException("EOF while reading class files attributes");
            }
            skipped = 1;
        }
    }

    public Attribute readAttribute(String name, int length, AttrContainer container) throws IOException {
        if (name == "SourceFile" && container instanceof ClassType) {
            return new SourceFileAttr(this.readUnsignedShort(), (ClassType)container);
        }
        if (name == "Code" && container instanceof Method) {
            CodeAttr code = new CodeAttr((Method)container);
            code.fixup_count = -1;
            code.setMaxStack(this.readUnsignedShort());
            code.setMaxLocals(this.readUnsignedShort());
            int code_len = this.readInt();
            byte[] insns = new byte[code_len];
            this.readFully(insns);
            code.setCode(insns);
            int exception_table_length = this.readUnsignedShort();
            for (int i = 0; i < exception_table_length; ++i) {
                int start_pc = this.readUnsignedShort();
                int end_pc = this.readUnsignedShort();
                int handler_pc = this.readUnsignedShort();
                int catch_type = this.readUnsignedShort();
                code.addHandler(start_pc, end_pc, handler_pc, catch_type);
            }
            this.readAttributes(code);
            return code;
        }
        if (name == "LineNumberTable" && container instanceof CodeAttr) {
            int count = 2 * this.readUnsignedShort();
            short[] numbers2 = new short[count];
            for (int i = 0; i < count; ++i) {
                numbers2[i] = this.readShort();
            }
            return new LineNumbersAttr(numbers2, (CodeAttr)container);
        }
        if (name == "LocalVariableTable" && container instanceof CodeAttr) {
            CodeAttr code = (CodeAttr)container;
            LocalVarsAttr attr = new LocalVarsAttr(code);
            Method method = attr.getMethod();
            if (attr.parameter_scope == null) {
                attr.parameter_scope = method.pushScope();
            }
            Scope scope = attr.parameter_scope;
            if (scope.end == null) {
                scope.end = new Label(code.PC);
            }
            ConstantPool constants = method.getConstants();
            int count = this.readUnsignedShort();
            int prev_start = scope.start.position;
            int prev_end = scope.end.position;
            for (int i = 0; i < count; ++i) {
                Variable var = new Variable();
                int start_pc = this.readUnsignedShort();
                int end_pc = start_pc + this.readUnsignedShort();
                if (start_pc != prev_start || end_pc != prev_end) {
                    while (scope.parent != null && (start_pc < scope.start.position || end_pc > scope.end.position)) {
                        scope = scope.parent;
                    }
                    Scope parent = scope;
                    scope = new Scope(new Label(start_pc), new Label(end_pc));
                    scope.linkChild(parent);
                    prev_start = start_pc;
                    prev_end = end_pc;
                }
                scope.addVariable(var);
                var.setName(this.readUnsignedShort(), constants);
                var.setSignature(this.readUnsignedShort(), constants);
                var.offset = this.readUnsignedShort();
            }
            return attr;
        }
        if (name == "Signature" && container instanceof Member) {
            return new SignatureAttr(this.readUnsignedShort(), (Member)((Object)container));
        }
        if (name == "StackMapTable" && container instanceof CodeAttr) {
            byte[] data = new byte[length];
            this.readFully(data, 0, length);
            return new StackMapTableAttr(data, (CodeAttr)container);
        }
        if ((name == "RuntimeVisibleAnnotations" || name == "RuntimeInvisibleAnnotations") && (container instanceof Field || container instanceof Method || container instanceof ClassType)) {
            int numEntries = this.readUnsignedShort();
            AnnotationEntry[] entries = new AnnotationEntry[numEntries];
            for (int i = 0; i < numEntries; ++i) {
                entries[i] = RuntimeAnnotationsAttr.readAnnotationEntry(this, container.getConstants());
            }
            return new RuntimeAnnotationsAttr(name, entries, numEntries, container);
        }
        if (name == "ConstantValue" && container instanceof Field) {
            return new ConstantValueAttr(this.readUnsignedShort());
        }
        if (name == "InnerClasses" && container instanceof ClassType) {
            int count = 4 * this.readUnsignedShort();
            short[] data = new short[count];
            for (int i = 0; i < count; ++i) {
                data[i] = this.readShort();
            }
            return new InnerClassesAttr(data, (ClassType)container);
        }
        if (name == "EnclosingMethod" && container instanceof ClassType) {
            int class_index = this.readUnsignedShort();
            int method_index = this.readUnsignedShort();
            return new EnclosingMethodAttr(class_index, method_index, (ClassType)container);
        }
        if (name == "Exceptions" && container instanceof Method) {
            Method meth = (Method)container;
            int count = this.readUnsignedShort();
            short[] exn_indices = new short[count];
            for (int i = 0; i < count; ++i) {
                exn_indices[i] = this.readShort();
            }
            meth.setExceptions(exn_indices);
            return meth.getExceptionAttr();
        }
        if (name == "SourceDebugExtension" && container instanceof ClassType) {
            SourceDebugExtAttr attr = new SourceDebugExtAttr((ClassType)container);
            byte[] data = new byte[length];
            this.readFully(data, 0, length);
            attr.data = data;
            attr.dlength = length;
            return attr;
        }
        if (name == "AnnotationDefault" && container instanceof Method) {
            AnnotationEntry.Value value = RuntimeAnnotationsAttr.readAnnotationValue(this, container.getConstants());
            return new AnnotationDefaultAttr(name, value, container);
        }
        byte[] data = new byte[length];
        this.readFully(data, 0, length);
        return new MiscAttr(name, data);
    }

    public void readFields() throws IOException {
        int nFields = this.readUnsignedShort();
        ConstantPool constants = this.ctype.constants;
        for (int i = 0; i < nFields; ++i) {
            int flags = this.readUnsignedShort();
            int nameIndex = this.readUnsignedShort();
            int descriptorIndex = this.readUnsignedShort();
            Field fld = this.ctype.addField();
            fld.setName(nameIndex, constants);
            fld.setSignature(descriptorIndex, constants);
            fld.flags = flags;
            this.readAttributes(fld);
        }
    }

    public void readMethods() throws IOException {
        int nMethods = this.readUnsignedShort();
        for (int i = 0; i < nMethods; ++i) {
            int flags = this.readUnsignedShort();
            int nameIndex = this.readUnsignedShort();
            int descriptorIndex = this.readUnsignedShort();
            Method meth = this.ctype.addMethod(null, flags);
            meth.setName(nameIndex);
            meth.setSignature(descriptorIndex);
            this.readAttributes(meth);
        }
    }

    CpoolClass getClassConstant(int index) {
        return (CpoolClass)this.ctype.constants.getForced(index, 7);
    }
}

