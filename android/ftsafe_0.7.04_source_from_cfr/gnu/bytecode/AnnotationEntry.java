/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolUtf8;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
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
import java.util.Map;
import java.util.Set;

public class AnnotationEntry
implements InvocationHandler,
Annotation {
    ClassType annotationType;
    int annotationTypeIndex;
    LinkedHashMap<String, Value> elementsValue = new LinkedHashMap(10);

    public RetentionPolicy getRetention() {
        Retention retention = this.getAnnotationType().getReflectClass().getAnnotation(Retention.class);
        if (retention == null) {
            return RetentionPolicy.CLASS;
        }
        return retention.value();
    }

    public boolean hasTarget(ElementType etype) {
        Target target = this.getAnnotationType().getReflectClass().getAnnotation(Target.class);
        if (target == null) {
            return true;
        }
        if (etype != null) {
            ElementType[] etypes = target.value();
            int i = etypes.length;
            while (--i >= 0) {
                if (etypes[i] != etype) continue;
                return true;
            }
        }
        return false;
    }

    public AnnotationEntry() {
    }

    public AnnotationEntry(ClassType annotationType) {
        this.annotationType = annotationType;
    }

    public ClassType getAnnotationType() {
        return this.annotationType;
    }

    public void addMember(String name, Value value) {
        this.elementsValue.put(name, value);
    }

    public void addMember(String name, Object value, Type type) {
        this.elementsValue.put(name, AnnotationEntry.asAnnotationValue(value, type));
    }

    public static Value asAnnotationValue(Object val, Type type) {
        String sig = type.getSignature();
        int kind = sig.charAt(0);
        switch (kind) {
            case 66: {
                val = ((Number)val).byteValue();
                break;
            }
            case 83: {
                val = ((Number)val).shortValue();
                break;
            }
            case 73: {
                val = ((Number)val).intValue();
                break;
            }
            case 74: {
                val = ((Number)val).longValue();
                break;
            }
            case 76: {
                if (sig.equals("Ljava/lang/String;")) {
                    kind = 115;
                    val = ((Object)((CharSequence)val)).toString();
                    break;
                }
                if (sig.equals("Ljava/lang/Class;")) {
                    kind = 99;
                    if (val instanceof Type) {
                        val = (Type)val;
                        break;
                    }
                    val = Type.make((Class)val);
                    break;
                }
                if (((ClassType)type).isSubclass("java.lang.Enum")) {
                    kind = 101;
                    break;
                }
                if (!((ClassType)type).implementsInterface(Type.javalangannotationAnnotationType)) break;
                kind = 64;
                val = (AnnotationEntry)Proxy.getInvocationHandler(val);
                break;
            }
            case 91: {
                Type eltype = ((ArrayType)type).getComponentType();
                ArrayList<Value> alist = new ArrayList<Value>();
                if (val instanceof List) {
                    List lst = (List)val;
                    int len = lst.size();
                    for (int i = 0; i < len; ++i) {
                        alist.add(AnnotationEntry.asAnnotationValue(lst.get(i), eltype));
                    }
                } else {
                    int len = Array.getLength(val);
                    for (int i = 0; i < len; ++i) {
                        alist.add(AnnotationEntry.asAnnotationValue(Array.get(val, i), eltype));
                    }
                }
                val = alist;
            }
        }
        return new Value((char)kind, type, val);
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return this.annotationType.getReflectClass();
    }

    @Override
    public boolean equals(Object obj) {
        String key;
        if (!(obj instanceof AnnotationEntry)) {
            return false;
        }
        AnnotationEntry other = (AnnotationEntry)obj;
        if (!this.getAnnotationType().getName().equals(other.getAnnotationType().getName())) {
            return false;
        }
        for (Map.Entry<String, Value> it : this.elementsValue.entrySet()) {
            Value value2;
            key = it.getKey();
            Value value1 = it.getValue();
            if (value1 == (value2 = other.elementsValue.get(key)) || value1 != null && value2 != null && value1.equals(value2)) continue;
            return false;
        }
        for (Map.Entry<String, Value> it : other.elementsValue.entrySet()) {
            key = it.getKey();
            Value value2 = it.getValue();
            Value value1 = this.elementsValue.get(key);
            if (value1 == value2 || value1 != null && value2 != null && value1.equals(value2)) continue;
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Map.Entry<String, Value> it : this.elementsValue.entrySet()) {
            int khash = it.getKey().hashCode();
            int vhash = it.getValue().hashCode();
            hash += 127 * khash ^ vhash;
        }
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sbuf = new StringBuilder();
        sbuf.append('@');
        sbuf.append(this.getAnnotationType().getName());
        sbuf.append('(');
        int count = 0;
        for (Map.Entry<String, Value> it : this.elementsValue.entrySet()) {
            if (count > 0) {
                sbuf.append(", ");
            }
            sbuf.append(it.getKey());
            sbuf.append('=');
            sbuf.append(it.getValue());
            ++count;
        }
        sbuf.append(')');
        return sbuf.toString();
    }

    public void print(int indentation, ClassTypeWriter dst) {
        dst.printOptionalIndex(this.annotationTypeIndex);
        dst.print('@');
        String cname = this.annotationType != null ? this.annotationType.getSignature() : ((CpoolUtf8)dst.ctype.constants.getPoolEntry(this.annotationTypeIndex)).getString();
        Type.printSignature(cname, 0, cname.length(), dst);
        int count = this.elementsValue.size();
        indentation += 2;
        for (Map.Entry<String, Value> e : this.elementsValue.entrySet()) {
            dst.println();
            String key = e.getKey();
            Value val = e.getValue();
            dst.printSpaces(indentation);
            dst.printOptionalIndex(val.nindex);
            dst.print(key);
            dst.print(" => ");
            val.print(indentation, dst);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        int nargs;
        String mname = method.getName();
        int n = nargs = args == null ? 0 : args.length;
        if (mname.equals("toString") && nargs == 0) {
            return this.toString();
        }
        if (mname.equals("hashCode") && nargs == 0) {
            return this.hashCode();
        }
        return this.elementsValue.get(mname).getValue();
    }

    static String[] decodeEnumEntry(Object value) {
        if (value instanceof Field) {
            Field fld = (Field)value;
            return new String[]{fld.getDeclaringClass().getSignature(), fld.getName()};
        }
        if (value instanceof Enum) {
            Enum evalue = (Enum)value;
            return new String[]{ClassType.nameToSignature(evalue.getDeclaringClass().getName()), evalue.name()};
        }
        return (String[])value;
    }

    public static class Value {
        Type type;
        char kind;
        Object value;
        Object valuex;
        int nindex;
        int index1;
        int index2;

        public Value(char kind, Type type, Object value) {
            this.kind = kind;
            this.type = type;
            this.value = value;
        }

        public Object getValue() {
            if (this.kind == '[') {
                if (this.valuex == null) {
                    List lvalue = (List)this.value;
                    int n = lvalue.size();
                    Class<?> eltype = this.type.getReflectClass().getComponentType();
                    Object arr = Array.newInstance(eltype, n);
                    for (int i = 0; i < n; ++i) {
                        Array.set(arr, i, ((Value)lvalue.get(i)).getValue());
                    }
                    this.valuex = arr;
                }
                return this.valuex;
            }
            if (this.kind == 'e') {
                if (this.valuex == null) {
                    if (this.value instanceof Enum) {
                        this.valuex = this.value;
                    } else {
                        String name;
                        ClassType type;
                        if (this.value instanceof Field) {
                            Field f = (Field)this.value;
                            type = f.getDeclaringClass();
                            name = f.getName();
                        } else {
                            String[] sarr = (String[])this.value;
                            type = (ClassType)Type.signatureToType(sarr[0]);
                            name = sarr[1];
                        }
                        Class clas = type.getReflectClass();
                        Class<Enum> eclas = clas.asSubclass(Enum.class);
                        Enum val = Enum.valueOf(eclas, name);
                        this.valuex = val;
                    }
                }
                return this.valuex;
            }
            return this.value;
        }

        public String toString() {
            return this.getValue().toString();
        }

        public void print(int indentation, ClassTypeWriter out) {
            if ((out.flags & 8) != 0) {
                out.print("(kind:");
                if (this.kind >= 'A' && this.kind <= 'z') {
                    out.print(this.kind);
                } else {
                    out.print((int)this.kind);
                }
                out.print(") ");
            }
            boolean expected = false;
            switch (this.kind) {
                case 'B': 
                case 'C': 
                case 'D': 
                case 'F': 
                case 'I': 
                case 'J': 
                case 'S': 
                case 'Z': 
                case 's': {
                    out.printOptionalIndex(out.getCpoolEntry(this.index1));
                    if (this.value instanceof String) {
                        out.printQuotedString((String)this.value);
                        break;
                    }
                    out.print(this.value.toString());
                    break;
                }
                case 'e': {
                    String[] sarr = AnnotationEntry.decodeEnumEntry(this.value);
                    String cname = sarr[0];
                    String ename = sarr[1];
                    out.print("enum[");
                    if ((out.flags & 8) != 0) {
                        out.print("type:");
                    }
                    out.printOptionalIndex(this.index1);
                    Type.printSignature(cname, 0, cname.length(), out);
                    if ((out.flags & 8) != 0) {
                        out.print(" value:");
                    } else {
                        out.print(' ');
                    }
                    out.printOptionalIndex(this.index2);
                    out.print(ename);
                    out.print("]");
                    break;
                }
                case 'c': {
                    out.printOptionalIndex(this.index1);
                    String cname = this.value instanceof String ? (String)this.value : ((ClassType)this.value).getSignature();
                    Type.printSignature(cname, 0, cname.length(), out);
                    break;
                }
                case '@': {
                    ((AnnotationEntry)this.value).print(indentation + 2, out);
                    break;
                }
                case '[': {
                    List vals = (List)this.value;
                    int sz = vals.size();
                    out.print("array length:");
                    out.print(sz);
                    for (int i = 0; i < sz; ++i) {
                        out.println();
                        out.printSpaces(indentation + 2);
                        out.print(i);
                        out.print(": ");
                        ((Value)vals.get(i)).print(indentation + 2, out);
                    }
                    break;
                }
            }
        }
    }

}

