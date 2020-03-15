// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

public class Access
{
    public static final short PUBLIC = 1;
    public static final short PRIVATE = 2;
    public static final short PROTECTED = 4;
    public static final short STATIC = 8;
    public static final short FINAL = 16;
    public static final short SUPER = 32;
    public static final short SYNCHRONIZED = 32;
    public static final short VOLATILE = 64;
    public static final short BRIDGE = 64;
    public static final short TRANSIENT = 128;
    public static final short VARARGS = 128;
    public static final short NATIVE = 256;
    public static final short INTERFACE = 512;
    public static final short ABSTRACT = 1024;
    public static final short STRICT = 2048;
    public static final short SYNTHETIC = 4096;
    public static final short ANNOTATION = 8192;
    public static final short ENUM = 16384;
    public static final char CLASS_CONTEXT = 'C';
    public static final char INNERCLASS_CONTEXT = 'I';
    public static final char FIELD_CONTEXT = 'F';
    public static final char METHOD_CONTEXT = 'M';
    public static final short CLASS_MODIFIERS = 30257;
    public static final short INNERCLASS_MODIFIERS = 30239;
    public static final short FIELD_MODIFIERS = 20703;
    public static final short METHOD_MODIFIERS = 7679;
    
    public static String toString(final int flags) {
        return toString(flags, '\0');
    }
    
    public static String toString(int flags, final char kind) {
        final short mask = (short)((kind == 'C') ? 30257 : ((kind == 'I') ? 30239 : ((kind == 'F') ? 20703 : ((kind == 'M') ? 7679 : 32767))));
        final short bad_flags = (short)(flags & ~mask);
        flags &= mask;
        final StringBuffer buf = new StringBuffer();
        if ((flags & 0x1) != 0x0) {
            buf.append(" public");
        }
        if ((flags & 0x2) != 0x0) {
            buf.append(" private");
        }
        if ((flags & 0x4) != 0x0) {
            buf.append(" protected");
        }
        if ((flags & 0x8) != 0x0) {
            buf.append(" static");
        }
        if ((flags & 0x10) != 0x0) {
            buf.append(" final");
        }
        if ((flags & 0x20) != 0x0) {
            buf.append((kind == 'C') ? " super" : " synchronized");
        }
        if ((flags & 0x40) != 0x0) {
            buf.append((kind == 'M') ? " bridge" : " volatile");
        }
        if ((flags & 0x80) != 0x0) {
            buf.append((kind == 'M') ? " varargs" : " transient");
        }
        if ((flags & 0x100) != 0x0) {
            buf.append(" native");
        }
        if ((flags & 0x200) != 0x0) {
            buf.append(" interface");
        }
        if ((flags & 0x400) != 0x0) {
            buf.append(" abstract");
        }
        if ((flags & 0x800) != 0x0) {
            buf.append(" strict");
        }
        if ((flags & 0x4000) != 0x0) {
            buf.append(" enum");
        }
        if ((flags & 0x1000) != 0x0) {
            buf.append(" synthetic");
        }
        if ((flags & 0x2000) != 0x0) {
            buf.append(" annotation");
        }
        if (bad_flags != 0) {
            buf.append(" unknown-flags:0x");
            buf.append(Integer.toHexString(bad_flags));
        }
        return buf.toString();
    }
}
