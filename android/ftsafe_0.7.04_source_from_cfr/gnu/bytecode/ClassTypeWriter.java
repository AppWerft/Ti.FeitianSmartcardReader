/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.Access;
import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.ClassType;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolUtf8;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class ClassTypeWriter
extends PrintWriter {
    ClassType ctype;
    int flags;
    public static final int PRINT_CONSTANT_POOL = 1;
    public static final int PRINT_CONSTANT_POOL_INDEXES = 2;
    public static final int PRINT_VERSION = 4;
    public static final int PRINT_EXTRAS = 8;
    public static final int PRINT_VERBOSE = 15;

    public ClassTypeWriter(ClassType ctype, Writer stream, int flags) {
        super(stream);
        this.ctype = ctype;
        this.flags = flags;
    }

    public ClassTypeWriter(ClassType ctype, OutputStream stream, int flags) {
        super(stream);
        this.ctype = ctype;
        this.flags = flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public static void print(ClassType ctype, PrintWriter stream, int flags) {
        ClassTypeWriter writer = new ClassTypeWriter(ctype, stream, flags);
        writer.print();
        writer.flush();
    }

    public static void print(ClassType ctype, PrintStream stream, int flags) {
        ClassTypeWriter writer = new ClassTypeWriter(ctype, stream, flags);
        writer.print();
        writer.flush();
    }

    public void print() {
        if ((this.flags & 4) != 0) {
            this.print("Classfile format major version: ");
            this.print(this.ctype.getClassfileMajorVersion());
            this.print(", minor version: ");
            this.print(this.ctype.getClassfileMinorVersion());
            this.println('.');
        }
        if ((this.flags & 1) != 0) {
            this.printConstantPool();
        }
        this.printClassInfo();
        this.printFields();
        this.printMethods();
        this.printAttributes();
    }

    public void setClass(ClassType ctype) {
        this.ctype = ctype;
    }

    public void print(ClassType ctype) {
        this.ctype = ctype;
        this.print();
    }

    public void printAttributes() {
        ClassType attrs = this.ctype;
        this.println();
        this.print("Attributes (count: ");
        this.print(Attribute.count(attrs));
        this.println("):");
        this.printAttributes(attrs);
    }

    public void printAttributes(AttrContainer container) {
        for (Attribute attr = container.getAttributes(); attr != null; attr = attr.getNext()) {
            attr.print(this);
        }
    }

    public void printClassInfo() {
        this.println();
        this.print("Access flags:");
        int modifiers = this.ctype.getModifiers();
        this.print(Access.toString(modifiers, 'C'));
        this.println();
        this.print("This class: ");
        this.printOptionalIndex(this.ctype.thisClassIndex);
        this.printConstantTersely(this.ctype.thisClassIndex, 7);
        this.print(" super: ");
        if (this.ctype.superClassIndex == -1) {
            this.print("<unknown>");
        } else if (this.ctype.superClassIndex == 0) {
            this.print("0");
        } else {
            this.printOptionalIndex(this.ctype.superClassIndex);
            this.printConstantTersely(this.ctype.superClassIndex, 7);
        }
        this.println();
        this.print("Interfaces (count: ");
        int[] interfaces = this.ctype.interfaceIndexes;
        int n_interfaces = interfaces == null ? 0 : interfaces.length;
        this.print(n_interfaces);
        this.print("):");
        this.println();
        for (int i = 0; i < n_interfaces; ++i) {
            this.print("- Implements: ");
            int index = interfaces[i];
            this.printOptionalIndex(index);
            this.printConstantTersely(index, 7);
            this.println();
        }
    }

    public void printFields() {
        this.println();
        this.print("Fields (count: ");
        this.print(this.ctype.fields_count);
        this.print("):");
        this.println();
        int ifield = 0;
        Field field = this.ctype.fields;
        while (field != null) {
            this.print("Field name: ");
            if (field.name_index != 0) {
                this.printOptionalIndex(field.name_index);
            }
            this.print(field.getName());
            this.print(Access.toString(field.flags, 'F'));
            this.print(" Signature: ");
            if (field.signature_index != 0) {
                this.printOptionalIndex(field.signature_index);
            }
            this.printSignature(field.getType());
            this.println();
            this.printAttributes(field);
            ++ifield;
            field = field.next;
        }
    }

    public void printMethods() {
        this.println();
        this.print("Methods (count: ");
        this.print(this.ctype.methods_count);
        this.print("):");
        this.println();
        Method method = this.ctype.methods;
        while (method != null) {
            this.printMethod(method);
            method = method.next;
        }
    }

    public void printMethod(Method method) {
        this.println();
        this.print("Method name:");
        if (method.name_index != 0) {
            this.printOptionalIndex(method.name_index);
        }
        this.print('\"');
        this.print(method.getName());
        this.print('\"');
        this.print(Access.toString(method.access_flags, 'M'));
        this.print(" Signature: ");
        if (method.signature_index != 0) {
            this.printOptionalIndex(method.signature_index);
        }
        this.print('(');
        for (int i = 0; i < method.arg_types.length; ++i) {
            if (i > 0) {
                this.print(',');
            }
            this.printSignature(method.arg_types[i]);
        }
        this.print(')');
        this.printSignature(method.return_type);
        this.println();
        this.printAttributes(method);
    }

    CpoolEntry getCpoolEntry(int index) {
        CpoolEntry[] pool = this.ctype.constants.pool;
        if (pool == null || index < 0 || index >= pool.length) {
            return null;
        }
        return pool[index];
    }

    final void printConstantTersely(CpoolEntry entry, int expected_tag) {
        if (entry == null) {
            this.print("<invalid constant index>");
        } else if (entry.getTag() != expected_tag) {
            this.print("<unexpected constant type ");
            entry.print(this, 1);
            this.print('>');
        } else {
            entry.print(this, 0);
        }
    }

    final void printConstantTersely(int index, int expected_tag) {
        this.printConstantTersely(this.getCpoolEntry(index), expected_tag);
    }

    final void printContantUtf8AsClass(int type_index) {
        CpoolEntry entry = this.getCpoolEntry(type_index);
        if (entry != null && entry.getTag() == 1) {
            String name = ((CpoolUtf8)entry).string;
            Type.printSignature(name, 0, name.length(), this);
        } else {
            this.printConstantTersely(type_index, 1);
        }
    }

    final void printConstantOperand(int index) {
        CpoolEntry entry;
        this.print(' ');
        this.printOptionalIndex(index);
        CpoolEntry[] pool = this.ctype.constants.pool;
        if (pool == null || index < 0 || index >= pool.length || (entry = pool[index]) == null) {
            this.print("<invalid constant index>");
        } else {
            this.print('<');
            entry.print(this, 1);
            this.print('>');
        }
    }

    public final void printQuotedString(String string) {
        this.print('\"');
        int len = string.length();
        for (int i = 0; i < len; ++i) {
            char ch = string.charAt(i);
            if (ch == '\"') {
                this.print("\\\"");
                continue;
            }
            if (ch >= ' ' && ch < '') {
                this.print(ch);
                continue;
            }
            if (ch == '\n') {
                this.print("\\n");
                continue;
            }
            this.print("\\u");
            int j = 4;
            while (--j >= 0) {
                this.print(Character.forDigit(ch >> j * 4 & 15, 16));
            }
        }
        this.print('\"');
    }

    public void printConstantPool() {
        CpoolEntry[] pool = this.ctype.constants.pool;
        int length = this.ctype.constants.count;
        for (int i = 1; i <= length; ++i) {
            CpoolEntry entry = pool[i];
            if (entry == null) continue;
            this.print('#');
            this.print(entry.index);
            this.print(": ");
            entry.print(this, 2);
            this.println();
        }
    }

    public final void printOptionalIndex(int index) {
        if (index >= 0 && (this.flags & 2) != 0) {
            this.print('#');
            this.print(index);
            this.print('=');
        }
    }

    public final void printOptionalIndex(CpoolEntry entry) {
        this.printOptionalIndex(entry.index);
    }

    void printName(String name) {
        this.print(name);
    }

    public final int printSignature(String sig, int pos) {
        String name;
        int len = sig.length();
        if (pos >= len) {
            this.print("<empty signature>");
            return pos;
        }
        int sig_length = Type.signatureLength(sig, pos);
        if (sig_length > 0 && (name = Type.signatureToName(sig.substring(pos, pos + sig_length))) != null) {
            this.print(name);
            return pos + sig_length;
        }
        char c = sig.charAt(pos);
        if (c != '(') {
            this.print(c);
            return pos + 1;
        }
        int nargs = 0;
        ++pos;
        this.print(c);
        do {
            if (pos >= len) {
                this.print("<truncated method signature>");
                return pos;
            }
            c = sig.charAt(pos);
            if (c == ')') break;
            if (nargs++ > 0) {
                this.print(',');
            }
            pos = this.printSignature(sig, pos);
        } while (true);
        this.print(c);
        return this.printSignature(sig, ++pos);
    }

    public final void printSignature(String sig) {
        int len;
        int pos = this.printSignature(sig, 0);
        if (pos < (len = sig.length())) {
            this.print("<trailing junk:");
            this.print(sig.substring(pos));
            this.print('>');
        }
    }

    public final void printSignature(Type type) {
        if (type == null) {
            this.print("<unknown type>");
        } else {
            this.printSignature(type.getSignature());
        }
    }

    public void printSpaces(int count) {
        while (--count >= 0) {
            this.print(' ');
        }
    }
}

