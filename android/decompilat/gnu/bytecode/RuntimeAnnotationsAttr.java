// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.DataInputStream;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.annotation.Annotation;

public class RuntimeAnnotationsAttr extends Attribute
{
    int dataLength;
    int numEntries;
    AnnotationEntry[] entries;
    
    public RuntimeAnnotationsAttr(final String name, final AnnotationEntry[] entries, final int numEntries, final AttrContainer container) {
        super(name);
        this.entries = entries;
        this.numEntries = numEntries;
        this.addToFrontOf(container);
    }
    
    public static RuntimeAnnotationsAttr getAnnotationsAttr(final AttrContainer container, final String name) {
        final Attribute attr = Attribute.get(container, name);
        if (attr != null) {
            return (RuntimeAnnotationsAttr)attr;
        }
        return new RuntimeAnnotationsAttr(name, null, 0, container);
    }
    
    public static RuntimeAnnotationsAttr getRuntimeVisibleAnnotations(final AttrContainer container) {
        return getAnnotationsAttr(container, "RuntimeVisibleAnnotations");
    }
    
    public static RuntimeAnnotationsAttr getRuntimeInvisibleAnnotations(final AttrContainer container) {
        return getAnnotationsAttr(container, "RuntimeInvisibleAnnotations");
    }
    
    public <T extends Annotation> T getAnnotation(final Class<T> clas) {
        for (int i = 0; i < this.numEntries; ++i) {
            final AnnotationEntry ann = this.entries[i];
            if (ann.getAnnotationType().getReflectClass() == clas) {
                return (T)Proxy.newProxyInstance(ann.getClass().getClassLoader(), new Class[] { clas }, ann);
            }
        }
        return null;
    }
    
    public static <T extends Annotation> T getAnnotation(final AttrContainer container, final Class<T> clas) {
        for (Attribute attr = container.getAttributes(); attr != null; attr = attr.getNext()) {
            if (attr instanceof RuntimeAnnotationsAttr) {
                final T ann = ((RuntimeAnnotationsAttr)attr).getAnnotation(clas);
                if (ann != null) {
                    return ann;
                }
            }
        }
        return null;
    }
    
    public static void maybeAddAnnotation(final AttrContainer container, final AnnotationEntry annotation) {
        final RetentionPolicy retention = annotation.getRetention();
        String attrname;
        if (retention == RetentionPolicy.RUNTIME) {
            attrname = "RuntimeVisibleAnnotations";
        }
        else {
            if (retention != RetentionPolicy.CLASS) {
                return;
            }
            attrname = "RuntimeInvisibleAnnotations";
        }
        getAnnotationsAttr(container, attrname).addAnnotation(annotation);
    }
    
    public void addAnnotation(final AnnotationEntry ann) {
        if (this.entries == null) {
            this.entries = new AnnotationEntry[4];
        }
        else if (this.entries.length <= this.numEntries) {
            final AnnotationEntry[] tmp = new AnnotationEntry[2 * this.entries.length];
            System.arraycopy(this.entries, 0, tmp, 0, this.numEntries);
            this.entries = tmp;
        }
        this.entries[this.numEntries++] = ann;
    }
    
    @Override
    public int getLength() {
        return this.dataLength;
    }
    
    @Override
    public void print(final ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", number of entries: ");
        dst.println(this.numEntries);
        for (int i = 0; i < this.numEntries; ++i) {
            dst.printSpaces(2);
            this.entries[i].print(2, dst);
            dst.println();
        }
    }
    
    static AnnotationEntry readAnnotationEntry(final DataInputStream dstr, final ConstantPool constants) throws IOException {
        final AnnotationEntry aentry = new AnnotationEntry();
        final int tindex = dstr.readUnsignedShort();
        CpoolEntry cpentry = constants.getForced(tindex, 1);
        aentry.annotationTypeIndex = tindex;
        aentry.annotationType = (ClassType)Type.signatureToType(((CpoolUtf8)cpentry).getString());
        for (int count = dstr.readUnsignedShort(), i = 0; i < count; ++i) {
            final int nindex = dstr.readUnsignedShort();
            cpentry = constants.getForced(nindex, 1);
            final AnnotationEntry.Value value = readAnnotationValue(dstr, constants);
            value.nindex = nindex;
            aentry.addMember(((CpoolUtf8)cpentry).getString(), value);
        }
        return aentry;
    }
    
    static AnnotationEntry.Value readAnnotationValue(final DataInputStream dstr, final ConstantPool constants) throws IOException {
        final byte kind = dstr.readByte();
        final int expected = 0;
        final AnnotationEntry.Value val = new AnnotationEntry.Value((char)kind, null, null);
        switch (kind) {
            case 66:
            case 67:
            case 73:
            case 83:
            case 90: {
                val.index1 = dstr.readUnsignedShort();
                final CpoolEntry cpentry = constants.getForced(val.index1, 3);
                final int ivalue = ((CpoolValue1)cpentry).value;
                if (kind == 73) {
                    val.value = ivalue;
                }
                else if (kind == 83) {
                    val.value = (short)ivalue;
                }
                else if (kind == 66) {
                    val.value = (byte)ivalue;
                }
                else if (kind == 90) {
                    val.value = (ivalue != 0);
                }
                else {
                    val.value = (char)ivalue;
                }
                return val;
            }
            case 74: {
                val.index1 = dstr.readUnsignedShort();
                final CpoolEntry cpentry = constants.getForced(val.index1, 5);
                val.value = ((CpoolValue2)cpentry).value;
                return val;
            }
            case 70: {
                val.index1 = dstr.readUnsignedShort();
                final CpoolEntry cpentry = constants.getForced(val.index1, 4);
                val.value = Float.intBitsToFloat(((CpoolValue1)cpentry).value);
                return val;
            }
            case 68: {
                val.index1 = dstr.readUnsignedShort();
                final CpoolEntry cpentry = constants.getForced(val.index1, 6);
                val.value = Double.longBitsToDouble(((CpoolValue2)cpentry).value);
                return val;
            }
            case 115: {
                val.index1 = dstr.readUnsignedShort();
                final CpoolEntry cpentry = constants.getForced(val.index1, 1);
                val.value = ((CpoolUtf8)cpentry).getString();
                return val;
            }
            case 101: {
                val.index1 = dstr.readUnsignedShort();
                val.index2 = dstr.readUnsignedShort();
                CpoolEntry cpentry = constants.getForced(val.index1, 1);
                final String cname = ((CpoolUtf8)cpentry).getString();
                cpentry = constants.getForced(val.index2, 1);
                final String ename = ((CpoolUtf8)cpentry).getString();
                val.value = new String[] { cname, ename };
                return val;
            }
            case 99: {
                val.index1 = dstr.readUnsignedShort();
                final CpoolEntry cpentry = constants.getForced(val.index1, 1);
                val.value = ((CpoolUtf8)cpentry).getString();
                return val;
            }
            case 91: {
                final int count = dstr.readUnsignedShort();
                final List<AnnotationEntry.Value> values = new ArrayList<AnnotationEntry.Value>(count);
                for (int i = 0; i < count; ++i) {
                    values.add(readAnnotationValue(dstr, constants));
                }
                val.value = values;
                return val;
            }
            case 64: {
                val.value = readAnnotationEntry(dstr, constants);
                return val;
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public void assignConstants(final ClassType cl) {
        super.assignConstants(cl);
        this.dataLength = 2;
        for (int i = 0; i < this.numEntries; ++i) {
            this.dataLength += assignConstants(this.entries[i], cl.getConstants());
        }
    }
    
    static int assignConstants(final AnnotationEntry aentry, final ConstantPool constants) {
        final Map<String, AnnotationEntry.Value> map = aentry.elementsValue;
        int dlen = 4;
        aentry.annotationTypeIndex = constants.addUtf8(aentry.annotationType.getSignature()).index;
        for (final Map.Entry<String, AnnotationEntry.Value> e : map.entrySet()) {
            final AnnotationEntry.Value val = e.getValue();
            val.nindex = constants.addUtf8(e.getKey()).index;
            dlen += 2;
            dlen += assignConstants(val, constants);
        }
        return dlen;
    }
    
    static int assignConstants(final AnnotationEntry.Value val, final ConstantPool constants) {
        final Object value = val.value;
        switch (val.kind) {
            case 'B':
            case 'I':
            case 'S': {
                if (val.index1 == 0) {
                    val.index1 = constants.addInt(((Number)value).intValue()).index;
                }
                return 3;
            }
            case 'J': {
                if (val.index1 == 0) {
                    val.index1 = constants.addLong((long)value).index;
                }
                return 3;
            }
            case 'F': {
                if (val.index1 == 0) {
                    val.index1 = constants.addFloat((float)value).index;
                }
                return 3;
            }
            case 'D': {
                if (val.index1 == 0) {
                    val.index1 = constants.addDouble((double)value).index;
                }
                return 3;
            }
            case 'Z': {
                if (val.index1 == 0) {
                    val.index1 = constants.addInt(((boolean)value) ? 1 : 0).index;
                }
                return 3;
            }
            case 'C': {
                if (val.index1 == 0) {
                    val.index1 = constants.addInt((char)value).index;
                }
                return 3;
            }
            case 's': {
                if (val.index1 == 0) {
                    val.index1 = constants.addUtf8((String)value).index;
                }
                return 3;
            }
            case '[': {
                int dlen = 3;
                final List<AnnotationEntry.Value> vals = (List<AnnotationEntry.Value>)value;
                for (int sz = vals.size(), i = 0; i < sz; ++i) {
                    dlen += assignConstants(vals.get(i), constants);
                }
                return dlen;
            }
            case 'e': {
                final String[] sarr = AnnotationEntry.decodeEnumEntry(value);
                if (val.index1 == 0) {
                    val.index1 = constants.addUtf8(sarr[0]).index;
                }
                if (val.index2 == 0) {
                    val.index2 = constants.addUtf8(sarr[1]).index;
                }
                return 5;
            }
            case 'c': {
                if (val.index1 == 0) {
                    final String str = (String)((value instanceof String) ? value : ((ClassType)value).getSignature());
                    val.index1 = constants.addUtf8(str).index;
                }
                return 3;
            }
            case '@': {
                return 1 + assignConstants((AnnotationEntry)value, constants);
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }
    
    @Override
    public void write(final DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.numEntries);
        for (int i = 0; i < this.numEntries; ++i) {
            write(this.entries[i], this.getConstants(), dstr);
        }
    }
    
    static void write(final AnnotationEntry aentry, final ConstantPool constants, final DataOutputStream dstr) throws IOException {
        dstr.writeShort(aentry.annotationTypeIndex);
        final Map<String, AnnotationEntry.Value> map = aentry.elementsValue;
        dstr.writeShort(map.size());
        for (final Map.Entry<String, AnnotationEntry.Value> e : map.entrySet()) {
            final AnnotationEntry.Value val = e.getValue();
            dstr.writeShort(val.nindex);
            write(val, constants, dstr);
        }
    }
    
    static void write(final AnnotationEntry.Value val, final ConstantPool constants, final DataOutputStream dstr) throws IOException {
        final Object value = val.value;
        final int kind = val.kind;
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
            case 115: {
                dstr.writeShort(val.index1);
                break;
            }
            case 91: {
                final List<AnnotationEntry.Value> vals = (List<AnnotationEntry.Value>)value;
                final int sz = vals.size();
                dstr.writeShort(sz);
                for (int i = 0; i < sz; ++i) {
                    write(vals.get(i), constants, dstr);
                }
                break;
            }
            case 101: {
                dstr.writeShort(val.index1);
                dstr.writeShort(val.index2);
                break;
            }
            case 99: {
                dstr.writeShort(constants.addUtf8(((ClassType)value).getSignature()).index);
                break;
            }
            case 64: {
                write((AnnotationEntry)value, constants, dstr);
                break;
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }
}
