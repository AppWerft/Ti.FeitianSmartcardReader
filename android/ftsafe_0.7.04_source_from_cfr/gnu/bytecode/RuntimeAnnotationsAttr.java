/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.AnnotationEntry;
import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolUtf8;
import gnu.bytecode.CpoolValue1;
import gnu.bytecode.CpoolValue2;
import gnu.bytecode.Type;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RuntimeAnnotationsAttr
extends Attribute {
    int dataLength;
    int numEntries;
    AnnotationEntry[] entries;

    public RuntimeAnnotationsAttr(String name, AnnotationEntry[] entries, int numEntries, AttrContainer container) {
        super(name);
        this.entries = entries;
        this.numEntries = numEntries;
        this.addToFrontOf(container);
    }

    public static RuntimeAnnotationsAttr getAnnotationsAttr(AttrContainer container, String name) {
        Attribute attr = Attribute.get(container, name);
        if (attr != null) {
            return (RuntimeAnnotationsAttr)attr;
        }
        return new RuntimeAnnotationsAttr(name, null, 0, container);
    }

    public static RuntimeAnnotationsAttr getRuntimeVisibleAnnotations(AttrContainer container) {
        return RuntimeAnnotationsAttr.getAnnotationsAttr(container, "RuntimeVisibleAnnotations");
    }

    public static RuntimeAnnotationsAttr getRuntimeInvisibleAnnotations(AttrContainer container) {
        return RuntimeAnnotationsAttr.getAnnotationsAttr(container, "RuntimeInvisibleAnnotations");
    }

    public <T extends Annotation> T getAnnotation(Class<T> clas) {
        for (int i = 0; i < this.numEntries; ++i) {
            AnnotationEntry ann = this.entries[i];
            if (ann.getAnnotationType().getReflectClass() != clas) continue;
            return (T)((Annotation)Proxy.newProxyInstance(ann.getClass().getClassLoader(), new Class[]{clas}, ann));
        }
        return null;
    }

    public static <T extends Annotation> T getAnnotation(AttrContainer container, Class<T> clas) {
        for (Attribute attr = container.getAttributes(); attr != null; attr = attr.getNext()) {
            T ann;
            if (!(attr instanceof RuntimeAnnotationsAttr) || (ann = ((RuntimeAnnotationsAttr)attr).getAnnotation(clas)) == null) continue;
            return ann;
        }
        return null;
    }

    public static void maybeAddAnnotation(AttrContainer container, AnnotationEntry annotation) {
        String attrname;
        RetentionPolicy retention = annotation.getRetention();
        if (retention == RetentionPolicy.RUNTIME) {
            attrname = "RuntimeVisibleAnnotations";
        } else if (retention == RetentionPolicy.CLASS) {
            attrname = "RuntimeInvisibleAnnotations";
        } else {
            return;
        }
        RuntimeAnnotationsAttr.getAnnotationsAttr(container, attrname).addAnnotation(annotation);
    }

    public void addAnnotation(AnnotationEntry ann) {
        if (this.entries == null) {
            this.entries = new AnnotationEntry[4];
        } else if (this.entries.length <= this.numEntries) {
            AnnotationEntry[] tmp = new AnnotationEntry[2 * this.entries.length];
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
    public void print(ClassTypeWriter dst) {
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

    static AnnotationEntry readAnnotationEntry(DataInputStream dstr, ConstantPool constants) throws IOException {
        AnnotationEntry aentry = new AnnotationEntry();
        int tindex = dstr.readUnsignedShort();
        CpoolEntry cpentry = constants.getForced(tindex, 1);
        aentry.annotationTypeIndex = tindex;
        aentry.annotationType = (ClassType)Type.signatureToType(((CpoolUtf8)cpentry).getString());
        int count = dstr.readUnsignedShort();
        for (int i = 0; i < count; ++i) {
            int nindex = dstr.readUnsignedShort();
            cpentry = constants.getForced(nindex, 1);
            AnnotationEntry.Value value = RuntimeAnnotationsAttr.readAnnotationValue(dstr, constants);
            value.nindex = nindex;
            aentry.addMember(((CpoolUtf8)cpentry).getString(), value);
        }
        return aentry;
    }

    static AnnotationEntry.Value readAnnotationValue(DataInputStream dstr, ConstantPool constants) throws IOException {
        byte kind = dstr.readByte();
        boolean expected = false;
        AnnotationEntry.Value val = new AnnotationEntry.Value((char)kind, null, null);
        switch (kind) {
            case 66: 
            case 67: 
            case 73: 
            case 83: 
            case 90: {
                val.index1 = dstr.readUnsignedShort();
                CpoolEntry cpentry = constants.getForced(val.index1, 3);
                int ivalue = ((CpoolValue1)cpentry).value;
                val.value = kind == 73 ? Integer.valueOf(ivalue) : (kind == 83 ? Short.valueOf((short)ivalue) : (kind == 66 ? Byte.valueOf((byte)ivalue) : (kind == 90 ? (Comparable<Boolean>)(ivalue != 0) : (Comparable<Boolean>)Character.valueOf((char)ivalue))));
                return val;
            }
            case 74: {
                val.index1 = dstr.readUnsignedShort();
                CpoolEntry cpentry = constants.getForced(val.index1, 5);
                val.value = ((CpoolValue2)cpentry).value;
                return val;
            }
            case 70: {
                val.index1 = dstr.readUnsignedShort();
                CpoolEntry cpentry = constants.getForced(val.index1, 4);
                val.value = Float.valueOf(Float.intBitsToFloat(((CpoolValue1)cpentry).value));
                return val;
            }
            case 68: {
                val.index1 = dstr.readUnsignedShort();
                CpoolEntry cpentry = constants.getForced(val.index1, 6);
                val.value = Double.longBitsToDouble(((CpoolValue2)cpentry).value);
                return val;
            }
            case 115: {
                val.index1 = dstr.readUnsignedShort();
                CpoolEntry cpentry = constants.getForced(val.index1, 1);
                val.value = ((CpoolUtf8)cpentry).getString();
                return val;
            }
            case 101: {
                val.index1 = dstr.readUnsignedShort();
                val.index2 = dstr.readUnsignedShort();
                CpoolEntry cpentry = constants.getForced(val.index1, 1);
                String cname = ((CpoolUtf8)cpentry).getString();
                cpentry = constants.getForced(val.index2, 1);
                String ename = ((CpoolUtf8)cpentry).getString();
                val.value = new String[]{cname, ename};
                return val;
            }
            case 99: {
                val.index1 = dstr.readUnsignedShort();
                CpoolEntry cpentry = constants.getForced(val.index1, 1);
                val.value = ((CpoolUtf8)cpentry).getString();
                return val;
            }
            case 91: {
                int count = dstr.readUnsignedShort();
                ArrayList<AnnotationEntry.Value> values = new ArrayList<AnnotationEntry.Value>(count);
                for (int i = 0; i < count; ++i) {
                    values.add(RuntimeAnnotationsAttr.readAnnotationValue(dstr, constants));
                }
                val.value = values;
                return val;
            }
            case 64: {
                val.value = RuntimeAnnotationsAttr.readAnnotationEntry(dstr, constants);
                return val;
            }
        }
        return null;
    }

    @Override
    public void assignConstants(ClassType cl) {
        super.assignConstants(cl);
        this.dataLength = 2;
        for (int i = 0; i < this.numEntries; ++i) {
            this.dataLength += RuntimeAnnotationsAttr.assignConstants(this.entries[i], cl.getConstants());
        }
    }

    static int assignConstants(AnnotationEntry aentry, ConstantPool constants) {
        LinkedHashMap<String, AnnotationEntry.Value> map = aentry.elementsValue;
        int dlen = 4;
        aentry.annotationTypeIndex = constants.addUtf8((String)aentry.annotationType.getSignature()).index;
        for (Map.Entry e : map.entrySet()) {
            AnnotationEntry.Value val = (AnnotationEntry.Value)e.getValue();
            val.nindex = constants.addUtf8((String)((String)e.getKey())).index;
            dlen += 2;
            dlen += RuntimeAnnotationsAttr.assignConstants(val, constants);
        }
        return dlen;
    }

    static int assignConstants(AnnotationEntry.Value val, ConstantPool constants) {
        Object value = val.value;
        switch (val.kind) {
            case 'B': 
            case 'I': 
            case 'S': {
                if (val.index1 == 0) {
                    val.index1 = constants.addInt((int)((Number)value).intValue()).index;
                }
                return 3;
            }
            case 'J': {
                if (val.index1 == 0) {
                    val.index1 = constants.addLong((long)((Long)value).longValue()).index;
                }
                return 3;
            }
            case 'F': {
                if (val.index1 == 0) {
                    val.index1 = constants.addFloat((float)((Float)value).floatValue()).index;
                }
                return 3;
            }
            case 'D': {
                if (val.index1 == 0) {
                    val.index1 = constants.addDouble((double)((Double)value).doubleValue()).index;
                }
                return 3;
            }
            case 'Z': {
                if (val.index1 == 0) {
                    val.index1 = constants.addInt((int)(((Boolean)value).booleanValue() != false ? 1 : 0)).index;
                }
                return 3;
            }
            case 'C': {
                if (val.index1 == 0) {
                    val.index1 = constants.addInt((int)((Character)value).charValue()).index;
                }
                return 3;
            }
            case 's': {
                if (val.index1 == 0) {
                    val.index1 = constants.addUtf8((String)((String)value)).index;
                }
                return 3;
            }
            case '[': {
                int dlen = 3;
                List vals = (List)value;
                int sz = vals.size();
                for (int i = 0; i < sz; ++i) {
                    dlen += RuntimeAnnotationsAttr.assignConstants((AnnotationEntry.Value)vals.get(i), constants);
                }
                return dlen;
            }
            case 'e': {
                String[] sarr = AnnotationEntry.decodeEnumEntry(value);
                if (val.index1 == 0) {
                    val.index1 = constants.addUtf8((String)sarr[0]).index;
                }
                if (val.index2 == 0) {
                    val.index2 = constants.addUtf8((String)sarr[1]).index;
                }
                return 5;
            }
            case 'c': {
                if (val.index1 == 0) {
                    String str = value instanceof String ? (String)value : ((ClassType)value).getSignature();
                    val.index1 = constants.addUtf8((String)str).index;
                }
                return 3;
            }
            case '@': {
                return 1 + RuntimeAnnotationsAttr.assignConstants((AnnotationEntry)value, constants);
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.numEntries);
        for (int i = 0; i < this.numEntries; ++i) {
            RuntimeAnnotationsAttr.write(this.entries[i], this.getConstants(), dstr);
        }
    }

    static void write(AnnotationEntry aentry, ConstantPool constants, DataOutputStream dstr) throws IOException {
        dstr.writeShort(aentry.annotationTypeIndex);
        LinkedHashMap<String, AnnotationEntry.Value> map = aentry.elementsValue;
        dstr.writeShort(map.size());
        for (Map.Entry e : map.entrySet()) {
            AnnotationEntry.Value val = (AnnotationEntry.Value)e.getValue();
            dstr.writeShort(val.nindex);
            RuntimeAnnotationsAttr.write(val, constants, dstr);
        }
    }

    static void write(AnnotationEntry.Value val, ConstantPool constants, DataOutputStream dstr) throws IOException {
        Object value = val.value;
        char kind = val.kind;
        dstr.writeByte((byte)kind);
        switch (kind) {
            case 'B': 
            case 'C': 
            case 'D': 
            case 'F': 
            case 'I': 
            case 'J': 
            case 'S': 
            case 'Z': 
            case 's': {
                dstr.writeShort(val.index1);
                break;
            }
            case '[': {
                List vals = (List)value;
                int sz = vals.size();
                dstr.writeShort(sz);
                for (int i = 0; i < sz; ++i) {
                    RuntimeAnnotationsAttr.write((AnnotationEntry.Value)vals.get(i), constants, dstr);
                }
                break;
            }
            case 'e': {
                dstr.writeShort(val.index1);
                dstr.writeShort(val.index2);
                break;
            }
            case 'c': {
                dstr.writeShort(constants.addUtf8((String)((ClassType)value).getSignature()).index);
                break;
            }
            case '@': {
                RuntimeAnnotationsAttr.write((AnnotationEntry)value, constants, dstr);
                break;
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }
}

