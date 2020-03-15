// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.PrintStream;
import java.io.OutputStream;
import java.io.Writer;
import java.io.PrintWriter;

public class ClassTypeWriter extends PrintWriter
{
    ClassType ctype;
    int flags;
    public static final int PRINT_CONSTANT_POOL = 1;
    public static final int PRINT_CONSTANT_POOL_INDEXES = 2;
    public static final int PRINT_VERSION = 4;
    public static final int PRINT_EXTRAS = 8;
    public static final int PRINT_VERBOSE = 15;
    
    public ClassTypeWriter(final ClassType ctype, final Writer stream, final int flags) {
        super(stream);
        this.ctype = ctype;
        this.flags = flags;
    }
    
    public ClassTypeWriter(final ClassType ctype, final OutputStream stream, final int flags) {
        super(stream);
        this.ctype = ctype;
        this.flags = flags;
    }
    
    public void setFlags(final int flags) {
        this.flags = flags;
    }
    
    public static void print(final ClassType ctype, final PrintWriter stream, final int flags) {
        final ClassTypeWriter writer = new ClassTypeWriter(ctype, stream, flags);
        writer.print();
        writer.flush();
    }
    
    public static void print(final ClassType ctype, final PrintStream stream, final int flags) {
        final ClassTypeWriter writer = new ClassTypeWriter(ctype, stream, flags);
        writer.print();
        writer.flush();
    }
    
    public void print() {
        if ((this.flags & 0x4) != 0x0) {
            this.print("Classfile format major version: ");
            this.print(this.ctype.getClassfileMajorVersion());
            this.print(", minor version: ");
            this.print(this.ctype.getClassfileMinorVersion());
            this.println('.');
        }
        if ((this.flags & 0x1) != 0x0) {
            this.printConstantPool();
        }
        this.printClassInfo();
        this.printFields();
        this.printMethods();
        this.printAttributes();
    }
    
    public void setClass(final ClassType ctype) {
        this.ctype = ctype;
    }
    
    public void print(final ClassType ctype) {
        this.ctype = ctype;
        this.print();
    }
    
    public void printAttributes() {
        final AttrContainer attrs = this.ctype;
        this.println();
        this.print("Attributes (count: ");
        this.print(Attribute.count(attrs));
        this.println("):");
        this.printAttributes(attrs);
    }
    
    public void printAttributes(final AttrContainer container) {
        for (Attribute attr = container.getAttributes(); attr != null; attr = attr.getNext()) {
            attr.print(this);
        }
    }
    
    public void printClassInfo() {
        this.println();
        this.print("Access flags:");
        final int modifiers = this.ctype.getModifiers();
        this.print(Access.toString(modifiers, 'C'));
        this.println();
        this.print("This class: ");
        this.printOptionalIndex(this.ctype.thisClassIndex);
        this.printConstantTersely(this.ctype.thisClassIndex, 7);
        this.print(" super: ");
        if (this.ctype.superClassIndex == -1) {
            this.print("<unknown>");
        }
        else if (this.ctype.superClassIndex == 0) {
            this.print("0");
        }
        else {
            this.printOptionalIndex(this.ctype.superClassIndex);
            this.printConstantTersely(this.ctype.superClassIndex, 7);
        }
        this.println();
        this.print("Interfaces (count: ");
        final int[] interfaces = this.ctype.interfaceIndexes;
        final int n_interfaces = (interfaces == null) ? 0 : interfaces.length;
        this.print(n_interfaces);
        this.print("):");
        this.println();
        for (int i = 0; i < n_interfaces; ++i) {
            this.print("- Implements: ");
            final int index = interfaces[i];
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
        for (Field field = this.ctype.fields; field != null; field = field.next) {
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
        }
    }
    
    public void printMethods() {
        this.println();
        this.print("Methods (count: ");
        this.print(this.ctype.methods_count);
        this.print("):");
        this.println();
        for (Method method = this.ctype.methods; method != null; method = method.next) {
            this.printMethod(method);
        }
    }
    
    public void printMethod(final Method method) {
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
    
    CpoolEntry getCpoolEntry(final int index) {
        final CpoolEntry[] pool = this.ctype.constants.pool;
        if (pool == null || index < 0 || index >= pool.length) {
            return null;
        }
        return pool[index];
    }
    
    final void printConstantTersely(final CpoolEntry entry, final int expected_tag) {
        if (entry == null) {
            this.print("<invalid constant index>");
        }
        else if (entry.getTag() != expected_tag) {
            this.print("<unexpected constant type ");
            entry.print(this, 1);
            this.print('>');
        }
        else {
            entry.print(this, 0);
        }
    }
    
    final void printConstantTersely(final int index, final int expected_tag) {
        this.printConstantTersely(this.getCpoolEntry(index), expected_tag);
    }
    
    final void printContantUtf8AsClass(final int type_index) {
        final CpoolEntry entry = this.getCpoolEntry(type_index);
        if (entry != null && entry.getTag() == 1) {
            final String name = ((CpoolUtf8)entry).string;
            Type.printSignature(name, 0, name.length(), this);
        }
        else {
            this.printConstantTersely(type_index, 1);
        }
    }
    
    final void printConstantOperand(final int index) {
        this.print(' ');
        this.printOptionalIndex(index);
        final CpoolEntry[] pool = this.ctype.constants.pool;
        final CpoolEntry entry;
        if (pool == null || index < 0 || index >= pool.length || (entry = pool[index]) == null) {
            this.print("<invalid constant index>");
        }
        else {
            this.print('<');
            entry.print(this, 1);
            this.print('>');
        }
    }
    
    public final void printQuotedString(final String string) {
        this.print('\"');
        for (int len = string.length(), i = 0; i < len; ++i) {
            final char ch = string.charAt(i);
            if (ch == '\"') {
                this.print("\\\"");
            }
            else if (ch >= ' ' && ch < '\u007f') {
                this.print(ch);
            }
            else if (ch == '\n') {
                this.print("\\n");
            }
            else {
                this.print("\\u");
                int j = 4;
                while (--j >= 0) {
                    this.print(Character.forDigit(ch >> j * 4 & 0xF, 16));
                }
            }
        }
        this.print('\"');
    }
    
    public void printConstantPool() {
        final CpoolEntry[] pool = this.ctype.constants.pool;
        for (int length = this.ctype.constants.count, i = 1; i <= length; ++i) {
            final CpoolEntry entry = pool[i];
            if (entry != null) {
                this.print('#');
                this.print(entry.index);
                this.print(": ");
                entry.print(this, 2);
                this.println();
            }
        }
    }
    
    public final void printOptionalIndex(final int index) {
        if (index >= 0 && (this.flags & 0x2) != 0x0) {
            this.print('#');
            this.print(index);
            this.print('=');
        }
    }
    
    public final void printOptionalIndex(final CpoolEntry entry) {
        this.printOptionalIndex(entry.index);
    }
    
    void printName(final String name) {
        this.print(name);
    }
    
    public final int printSignature(final String sig, int pos) {
        final int len = sig.length();
        if (pos >= len) {
            this.print("<empty signature>");
            return pos;
        }
        final int sig_length = Type.signatureLength(sig, pos);
        if (sig_length > 0) {
            final String name = Type.signatureToName(sig.substring(pos, pos + sig_length));
            if (name != null) {
                this.print(name);
                return pos + sig_length;
            }
        }
        char c = sig.charAt(pos);
        if (c != '(') {
            this.print(c);
            return pos + 1;
        }
        int nargs = 0;
        ++pos;
        this.print(c);
        while (pos < len) {
            c = sig.charAt(pos);
            if (c == ')') {
                ++pos;
                this.print(c);
                return this.printSignature(sig, pos);
            }
            if (nargs++ > 0) {
                this.print(',');
            }
            pos = this.printSignature(sig, pos);
        }
        this.print("<truncated method signature>");
        return pos;
    }
    
    public final void printSignature(final String sig) {
        final int pos = this.printSignature(sig, 0);
        final int len = sig.length();
        if (pos < len) {
            this.print("<trailing junk:");
            this.print(sig.substring(pos));
            this.print('>');
        }
    }
    
    public final void printSignature(final Type type) {
        if (type == null) {
            this.print("<unknown type>");
        }
        else {
            this.printSignature(type.getSignature());
        }
    }
    
    public void printSpaces(int count) {
        while (--count >= 0) {
            this.print(' ');
        }
    }
}
