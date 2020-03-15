// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.lang.reflect.Method;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Proxy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;

public class AnnotationEntry implements InvocationHandler, Annotation
{
    ClassType annotationType;
    int annotationTypeIndex;
    LinkedHashMap<String, Value> elementsValue;
    
    public RetentionPolicy getRetention() {
        final Annotation retention = this.getAnnotationType().getReflectClass().getAnnotation(Retention.class);
        if (retention == null) {
            return RetentionPolicy.CLASS;
        }
        return ((Retention)retention).value();
    }
    
    public boolean hasTarget(final ElementType etype) {
        final Annotation target = this.getAnnotationType().getReflectClass().getAnnotation(Target.class);
        if (target == null) {
            return true;
        }
        if (etype != null) {
            final ElementType[] etypes = ((Target)target).value();
            int i = etypes.length;
            while (--i >= 0) {
                if (etypes[i] == etype) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public AnnotationEntry() {
        this.elementsValue = new LinkedHashMap<String, Value>(10);
    }
    
    public AnnotationEntry(final ClassType annotationType) {
        this.elementsValue = new LinkedHashMap<String, Value>(10);
        this.annotationType = annotationType;
    }
    
    public ClassType getAnnotationType() {
        return this.annotationType;
    }
    
    public void addMember(final String name, final Value value) {
        this.elementsValue.put(name, value);
    }
    
    public void addMember(final String name, final Object value, final Type type) {
        this.elementsValue.put(name, asAnnotationValue(value, type));
    }
    
    public static Value asAnnotationValue(Object val, final Type type) {
        final String sig = type.getSignature();
        char kind = sig.charAt(0);
        switch (kind) {
            case 'B': {
                val = ((Number)val).byteValue();
                break;
            }
            case 'S': {
                val = ((Number)val).shortValue();
                break;
            }
            case 'I': {
                val = ((Number)val).intValue();
                break;
            }
            case 'J': {
                val = ((Number)val).longValue();
                break;
            }
            case 'L': {
                if (sig.equals("Ljava/lang/String;")) {
                    kind = 's';
                    val = ((CharSequence)val).toString();
                    break;
                }
                if (sig.equals("Ljava/lang/Class;")) {
                    kind = 'c';
                    if (val instanceof Type) {
                        val = val;
                        break;
                    }
                    val = Type.make((Class)val);
                    break;
                }
                else {
                    if (((ClassType)type).isSubclass("java.lang.Enum")) {
                        kind = 'e';
                        break;
                    }
                    if (((ClassType)type).implementsInterface(Type.javalangannotationAnnotationType)) {
                        kind = '@';
                        val = Proxy.getInvocationHandler(val);
                        break;
                    }
                    break;
                }
                break;
            }
            case '[': {
                final Type eltype = ((ArrayType)type).getComponentType();
                final List<Value> alist = new ArrayList<Value>();
                if (val instanceof List) {
                    final List<?> lst = (List<?>)val;
                    for (int len = lst.size(), i = 0; i < len; ++i) {
                        alist.add(asAnnotationValue(lst.get(i), eltype));
                    }
                }
                else {
                    for (int len2 = Array.getLength(val), j = 0; j < len2; ++j) {
                        alist.add(asAnnotationValue(Array.get(val, j), eltype));
                    }
                }
                val = alist;
                break;
            }
        }
        return new Value(kind, type, val);
    }
    
    @Override
    public Class<? extends Annotation> annotationType() {
        return (Class<? extends Annotation>)this.annotationType.getReflectClass();
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof AnnotationEntry)) {
            return false;
        }
        final AnnotationEntry other = (AnnotationEntry)obj;
        if (!this.getAnnotationType().getName().equals(other.getAnnotationType().getName())) {
            return false;
        }
        for (final Map.Entry<String, Value> it : this.elementsValue.entrySet()) {
            final String key = it.getKey();
            final Value value1 = it.getValue();
            final Value value2 = other.elementsValue.get(key);
            if (value1 != value2 && (value1 == null || value2 == null || !value1.equals(value2))) {
                return false;
            }
        }
        for (final Map.Entry<String, Value> it : other.elementsValue.entrySet()) {
            final String key = it.getKey();
            final Object value3 = it.getValue();
            final Object value4 = this.elementsValue.get(key);
            if (value4 != value3 && (value4 == null || value3 == null || !value4.equals(value3))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        for (final Map.Entry<String, Value> it : this.elementsValue.entrySet()) {
            final int khash = it.getKey().hashCode();
            final int vhash = it.getValue().hashCode();
            hash += (127 * khash ^ vhash);
        }
        return hash;
    }
    
    @Override
    public String toString() {
        final StringBuilder sbuf = new StringBuilder();
        sbuf.append('@');
        sbuf.append(this.getAnnotationType().getName());
        sbuf.append('(');
        int count = 0;
        for (final Map.Entry<String, Value> it : this.elementsValue.entrySet()) {
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
    
    public void print(int indentation, final ClassTypeWriter dst) {
        dst.printOptionalIndex(this.annotationTypeIndex);
        dst.print('@');
        final String cname = (this.annotationType != null) ? this.annotationType.getSignature() : ((CpoolUtf8)dst.ctype.constants.getPoolEntry(this.annotationTypeIndex)).getString();
        Type.printSignature(cname, 0, cname.length(), dst);
        final int count = this.elementsValue.size();
        indentation += 2;
        for (final Map.Entry<String, Value> e : this.elementsValue.entrySet()) {
            dst.println();
            final String key = e.getKey();
            final Value val = e.getValue();
            dst.printSpaces(indentation);
            dst.printOptionalIndex(val.nindex);
            dst.print(key);
            dst.print(" => ");
            val.print(indentation, dst);
        }
    }
    
    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) {
        final String mname = method.getName();
        final int nargs = (args == null) ? 0 : args.length;
        if (mname.equals("toString") && nargs == 0) {
            return this.toString();
        }
        if (mname.equals("hashCode") && nargs == 0) {
            return this.hashCode();
        }
        return this.elementsValue.get(mname).getValue();
    }
    
    static String[] decodeEnumEntry(final Object value) {
        if (value instanceof Field) {
            final Field fld = (Field)value;
            return new String[] { fld.getDeclaringClass().getSignature(), fld.getName() };
        }
        if (value instanceof Enum) {
            final Enum evalue = (Enum)value;
            return new String[] { ClassType.nameToSignature(evalue.getDeclaringClass().getName()), evalue.name() };
        }
        return (String[])value;
    }
    
    public static class Value
    {
        Type type;
        char kind;
        Object value;
        Object valuex;
        int nindex;
        int index1;
        int index2;
        
        public Value(final char kind, final Type type, final Object value) {
            this.kind = kind;
            this.type = type;
            this.value = value;
        }
        
        public Object getValue() {
            if (this.kind == '[') {
                if (this.valuex == null) {
                    final List<? extends Value> lvalue = (List<? extends Value>)this.value;
                    final int n = lvalue.size();
                    final Class eltype = this.type.getReflectClass().getComponentType();
                    final Object arr = Array.newInstance(eltype, n);
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
                    }
                    else {
                        ClassType type;
                        String name;
                        if (this.value instanceof Field) {
                            final Field f = (Field)this.value;
                            type = f.getDeclaringClass();
                            name = f.getName();
                        }
                        else {
                            final String[] sarr = (String[])this.value;
                            type = (ClassType)Type.signatureToType(sarr[0]);
                            name = sarr[1];
                        }
                        final Class<?> clas = (Class<?>)type.getReflectClass();
                        final Class<? extends Enum> eclas = clas.asSubclass(Enum.class);
                        final Enum val = (Enum)Enum.valueOf(eclas, name);
                        this.valuex = val;
                    }
                }
                return this.valuex;
            }
            return this.value;
        }
        
        @Override
        public String toString() {
            return this.getValue().toString();
        }
        
        public void print(final int indentation, final ClassTypeWriter out) {
            if ((out.flags & 0x8) != 0x0) {
                out.print("(kind:");
                if (this.kind >= 'A' && this.kind <= 'z') {
                    out.print(this.kind);
                }
                else {
                    out.print((int)this.kind);
                }
                out.print(") ");
            }
            final int expected = 0;
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
                    final String[] sarr = AnnotationEntry.decodeEnumEntry(this.value);
                    final String cname = sarr[0];
                    final String ename = sarr[1];
                    out.print("enum[");
                    if ((out.flags & 0x8) != 0x0) {
                        out.print("type:");
                    }
                    out.printOptionalIndex(this.index1);
                    Type.printSignature(cname, 0, cname.length(), out);
                    if ((out.flags & 0x8) != 0x0) {
                        out.print(" value:");
                    }
                    else {
                        out.print(' ');
                    }
                    out.printOptionalIndex(this.index2);
                    out.print(ename);
                    out.print("]");
                    break;
                }
                case 'c': {
                    out.printOptionalIndex(this.index1);
                    final String cname = (String)((this.value instanceof String) ? this.value : ((ClassType)this.value).getSignature());
                    Type.printSignature(cname, 0, cname.length(), out);
                    break;
                }
                case '@': {
                    ((AnnotationEntry)this.value).print(indentation + 2, out);
                    break;
                }
                case '[': {
                    final List<Value> vals = (List<Value>)this.value;
                    final int sz = vals.size();
                    out.print("array length:");
                    out.print(sz);
                    for (int i = 0; i < sz; ++i) {
                        out.println();
                        out.printSpaces(indentation + 2);
                        out.print(i);
                        out.print(": ");
                        vals.get(i).print(indentation + 2, out);
                    }
                    break;
                }
            }
        }
    }
}
