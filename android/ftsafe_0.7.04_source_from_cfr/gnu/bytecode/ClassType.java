/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolClass;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.EnclosingMethodAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Filter;
import gnu.bytecode.InnerClassesAttr;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.RuntimeAnnotationsAttr;
import gnu.bytecode.SourceDebugExtAttr;
import gnu.bytecode.SourceFileAttr;
import gnu.bytecode.Type;
import gnu.bytecode.TypeVariable;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.Externalizable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;

public class ClassType
extends ObjectType
implements AttrContainer,
Externalizable,
Member {
    public static final int JDK_1_1_VERSION = 2949123;
    public static final int JDK_1_2_VERSION = 3014656;
    public static final int JDK_1_3_VERSION = 3080192;
    public static final int JDK_1_4_VERSION = 3145728;
    public static final int JDK_1_5_VERSION = 3211264;
    public static final int JDK_1_6_VERSION = 3276800;
    public static final int JDK_1_7_VERSION = 3342336;
    public static final int JDK_1_8_VERSION = 3407872;
    public static final int JAVA_9_VERSION = 3473408;
    int classfileFormatVersion = 3211264;
    int thisClassIndex;
    private ClassType superClass;
    int superClassIndex = -1;
    ClassType[] interfaces;
    private ClassType[] allInterfaces;
    int[] interfaceIndexes;
    int access_flags;
    Attribute attributes;
    public static final ClassType[] noClasses = new ClassType[0];
    boolean emitDebugInfo = true;
    ConstantPool constants;
    ClassType firstInnerClass;
    ClassType nextInnerClass;
    Member enclosingMember;
    SourceDebugExtAttr sourceDbgExt;
    TypeVariable[] typeParameters;
    Field fields;
    int fields_count;
    Field last_field;
    int ConstantValue_name_index;
    int Code_name_index;
    int LocalVariableTable_name_index;
    int LineNumberTable_name_index;
    Method methods;
    int methods_count;
    Method last_method;
    public Method constructor;

    public short getClassfileMajorVersion() {
        return (short)(this.classfileFormatVersion >> 16);
    }

    public short getClassfileMinorVersion() {
        return (short)(this.classfileFormatVersion & 65535);
    }

    public void setClassfileVersion(int major, int minor) {
        this.classfileFormatVersion = (major & 65535) * 65536 + minor * 65535;
    }

    public void setClassfileVersion(int code) {
        this.classfileFormatVersion = code;
    }

    public int getClassfileVersion() {
        return this.classfileFormatVersion;
    }

    public void setClassfileVersionJava5() {
        this.setClassfileVersion(3211264);
    }

    public static ClassType make(String name) {
        return (ClassType)Type.getType(name);
    }

    @Deprecated
    public static ClassType make(String name, ClassType superClass) {
        ClassType type = ClassType.make(name);
        if (type.superClass == null) {
            type.setSuper(superClass);
        }
        return type;
    }

    @Override
    public final Attribute getAttributes() {
        return this.attributes;
    }

    @Override
    public final void setAttributes(Attribute attributes) {
        this.attributes = attributes;
    }

    @Override
    public final ConstantPool getConstants() {
        return this.constants;
    }

    public final CpoolEntry getConstant(int i) {
        if (this.constants == null || this.constants.pool == null || i > this.constants.count) {
            return null;
        }
        return this.constants.pool[i];
    }

    @Override
    public final synchronized int getModifiers() {
        if (this.access_flags == 0 && (this.flags & 16) != 0 && this.getReflectClass() != null) {
            this.access_flags = this.reflectClass.getModifiers();
        }
        return this.access_flags;
    }

    @Override
    public final boolean getStaticFlag() {
        return (this.getModifiers() & 8) != 0;
    }

    public final void setModifiers(int flags) {
        this.access_flags = flags;
    }

    public final void addModifiers(int flags) {
        this.access_flags |= flags;
    }

    public synchronized String getSimpleName() {
        int dot;
        String enclosingName;
        if ((this.flags & 16) != 0 && this.getReflectClass() != null) {
            try {
                return this.reflectClass.getSimpleName();
            }
            catch (Exception ex) {
                // empty catch block
            }
        }
        String name = this.getName();
        if (this.enclosingMember instanceof ClassType && (enclosingName = ((ClassType)this.enclosingMember).getName()) != null && name.startsWith(enclosingName)) {
            int enclosingLength = enclosingName.length();
            if (name.length() > enclosingLength + 1 && name.charAt(enclosingLength) == '$') {
                return name.substring(enclosingLength + 1);
            }
        }
        if ((dot = name.lastIndexOf(46)) > 0) {
            name = name.substring(dot + 1);
        }
        return name;
    }

    public void addMemberClass(ClassType member) {
        ClassType prev = null;
        ClassType entry = this.firstInnerClass;
        while (entry != null) {
            if (entry == member) {
                return;
            }
            prev = entry;
            entry = entry.nextInnerClass;
        }
        if (prev == null) {
            this.firstInnerClass = member;
        } else {
            prev.nextInnerClass = member;
        }
    }

    public ClassType getDeclaredClass(String simpleName) {
        this.addMemberClasses();
        ClassType member = this.firstInnerClass;
        while (member != null) {
            if (simpleName.equals(member.getSimpleName())) {
                return member;
            }
            member = member.nextInnerClass;
        }
        return null;
    }

    @Override
    public ClassType getDeclaringClass() {
        this.addEnclosingMember();
        if (this.enclosingMember instanceof ClassType) {
            return (ClassType)this.enclosingMember;
        }
        return null;
    }

    public Member getEnclosingMember() {
        this.addEnclosingMember();
        return this.enclosingMember;
    }

    public void setEnclosingMember(Member member) {
        this.enclosingMember = member;
    }

    synchronized void addEnclosingMember() {
        if ((this.flags & 24) != 16) {
            return;
        }
        Class clas = this.getReflectClass();
        this.flags |= 8;
        Class<?> dclas = clas.getEnclosingClass();
        if (dclas == null) {
            return;
        }
        if (!clas.isMemberClass()) {
            java.lang.reflect.Method rmeth = clas.getEnclosingMethod();
            if (rmeth != null) {
                this.enclosingMember = this.addMethod(rmeth);
                return;
            }
            Constructor<?> rcons = clas.getEnclosingConstructor();
            if (rcons != null) {
                this.enclosingMember = this.addMethod(rcons);
                return;
            }
        }
        this.enclosingMember = (ClassType)Type.make(dclas);
    }

    public synchronized void addMemberClasses() {
        if ((this.flags & 20) != 16) {
            return;
        }
        Class clas = this.getReflectClass();
        this.flags |= 4;
        Class<?>[] memberClasses = clas.getClasses();
        int numMembers = memberClasses.length;
        if (numMembers > 0) {
            for (int i = 0; i < numMembers; ++i) {
                ClassType member = (ClassType)Type.make(memberClasses[i]);
                this.addMemberClass(member);
            }
        }
    }

    public final boolean hasOuterLink() {
        this.getFields();
        return (this.flags & 32) != 0;
    }

    public ClassType getOuterLinkType() {
        return !this.hasOuterLink() ? null : (ClassType)this.getDeclaredField("this$0").getType();
    }

    public final Field setOuterLink(ClassType outer) {
        if ((this.flags & 16) != 0) {
            throw new Error("setOuterLink called for existing class " + this.getName());
        }
        Field field = this.getDeclaredField("this$0");
        if (field == null) {
            field = this.addField("this$0", outer);
            this.flags |= 32;
            for (Method meth = this.methods; meth != null; meth = meth.getNext()) {
                if (!"<init>".equals(meth.getName())) continue;
                if (meth.code != null) {
                    throw new Error("setOuterLink called when " + meth + " has code");
                }
                Type[] arg_types = meth.arg_types;
                Type[] new_types = new Type[arg_types.length + 1];
                System.arraycopy(arg_types, 0, new_types, 1, arg_types.length);
                new_types[0] = outer;
                meth.arg_types = new_types;
                meth.signature = null;
            }
        } else if (!outer.equals(field.getType())) {
            throw new Error("inconsistent setOuterLink call for " + this.getName());
        }
        return field;
    }

    public boolean isAccessible(Member member, ObjectType receiver) {
        if (member.getStaticFlag()) {
            receiver = null;
        }
        return this.isAccessible(member.getDeclaringClass(), receiver, member.getModifiers());
    }

    public boolean isAccessible(ClassType declaring, ObjectType receiver, int modifiers) {
        String classPackage;
        String className;
        int cmods = declaring.getModifiers();
        if ((modifiers & 1) != 0 && (cmods & 1) != 0) {
            return true;
        }
        String callerName = this.getName();
        if (callerName.equals(className = declaring.getName())) {
            return true;
        }
        if ((modifiers & 2) != 0) {
            return false;
        }
        int dot = callerName.lastIndexOf(46);
        String callerPackage = dot >= 0 ? callerName.substring(0, dot) : "";
        dot = className.lastIndexOf(46);
        String string = classPackage = dot >= 0 ? className.substring(0, dot) : "";
        if (callerPackage.equals(classPackage)) {
            return true;
        }
        if ((cmods & 1) == 0) {
            return false;
        }
        return (modifiers & 4) != 0 && this.isSubclass(declaring) && (!(receiver instanceof ClassType) || ((ClassType)receiver).isSubclass(this));
    }

    @Override
    public void setName(String name) {
        this.this_name = name;
        this.setSignature(ClassType.nameToSignature(name));
    }

    public static String nameToSignature(String name) {
        return "L" + name.replace('.', '/') + ";";
    }

    public void setStratum(String stratum) {
        if (this.sourceDbgExt == null) {
            this.sourceDbgExt = new SourceDebugExtAttr(this);
        }
        this.sourceDbgExt.addStratum(stratum);
    }

    public void setSourceFile(String name) {
        int slash;
        if (this.sourceDbgExt != null) {
            this.sourceDbgExt.addFile(name);
            if (this.sourceDbgExt.fileCount > 1) {
                return;
            }
        }
        if ((slash = (name = SourceFileAttr.fixSourceFile(name)).lastIndexOf(47)) >= 0) {
            name = name.substring(slash + 1);
        }
        SourceFileAttr.setSourceFile(this, name);
    }

    public TypeVariable[] getTypeParameters() {
        TypeVariable[] params = this.typeParameters;
        if (params == null && (this.flags & 16) != 0 && this.getReflectClass() != null) {
            java.lang.reflect.TypeVariable<Class<T>>[] rparams = this.reflectClass.getTypeParameters();
            int nparams = rparams.length;
            params = new TypeVariable[nparams];
            for (int i = 0; i < nparams; ++i) {
                params[i] = TypeVariable.make(rparams[i]);
            }
            this.typeParameters = params;
        }
        return params;
    }

    public void setSuper(String name) {
        this.setSuper(name == null ? Type.pointer_type : ClassType.make(name));
    }

    public void setSuper(ClassType superClass) {
        this.superClass = superClass;
    }

    public synchronized ClassType getSuperclass() {
        if (this.superClass == null && !this.isInterface() && !"java.lang.Object".equals(this.getName()) && (this.flags & 16) != 0 && this.getReflectClass() != null) {
            this.superClass = (ClassType)ClassType.make(this.reflectClass.getSuperclass());
        }
        return this.superClass;
    }

    public String getPackageName() {
        String name = this.getName();
        int index = name.lastIndexOf(46);
        return index < 0 ? "" : name.substring(0, index);
    }

    public synchronized ClassType[] getInterfaces() {
        if (this.interfaces == null && (this.flags & 16) != 0 && this.getReflectClass() != null) {
            Class<?>[] reflectInterfaces = this.reflectClass.getInterfaces();
            int numInterfaces = reflectInterfaces.length;
            this.interfaces = numInterfaces == 0 ? noClasses : new ClassType[numInterfaces];
            for (int i = 0; i < numInterfaces; ++i) {
                this.interfaces[i] = (ClassType)Type.make(reflectInterfaces[i]);
            }
        }
        return this.interfaces;
    }

    public synchronized ClassType[] getAllInterfaces() {
        if (this.allInterfaces == null) {
            LinkedHashMap<String, ClassType> map = new LinkedHashMap<String, ClassType>();
            for (ClassType t = this; t != null; t = t.getSuperclass()) {
                if (t.addInterfaces(map)) continue;
                return null;
            }
            ClassType[] allInts = new ClassType[map.size()];
            int i = 0;
            for (ClassType intf : map.values()) {
                allInts[i++] = intf;
            }
            this.allInterfaces = allInts;
        }
        return this.allInterfaces;
    }

    private boolean addInterfaces(LinkedHashMap<String, ClassType> map) {
        ClassType[] intfs = this.getInterfaces();
        if (intfs == null) {
            return false;
        }
        for (ClassType intf : intfs) {
            if (map.put(intf.getName(), intf) != null || intf.addInterfaces(map)) continue;
            return false;
        }
        return true;
    }

    public void setInterfaces(ClassType[] interfaces) {
        this.interfaces = interfaces;
    }

    public void addInterface(ClassType newInterface) {
        int oldCount;
        if (this.interfaces == null || this.interfaces.length == 0) {
            oldCount = 0;
            this.interfaces = new ClassType[1];
        } else {
            int i = oldCount = this.interfaces.length;
            while (--i >= 0) {
                if (this.interfaces[i] != newInterface) continue;
                return;
            }
            ClassType[] newInterfaces = new ClassType[oldCount + 1];
            System.arraycopy(this.interfaces, 0, newInterfaces, 0, oldCount);
            this.interfaces = newInterfaces;
        }
        this.interfaces[oldCount] = newInterface;
    }

    @Override
    public final boolean isInterface() {
        return (this.getModifiers() & 512) != 0;
    }

    public final void setInterface(boolean val) {
        this.access_flags = val ? (this.access_flags |= 1536) : (this.access_flags &= -513);
    }

    public final boolean isFinal() {
        return (this.getModifiers() & 16) != 0;
    }

    public final boolean isAnnotation() {
        return (this.getModifiers() & 8192) != 0;
    }

    public ClassType() {
    }

    public ClassType(String class_name) {
        this.setName(class_name);
    }

    public final synchronized Field getFields() {
        if ((this.flags & 17) == 16) {
            this.addFields();
        }
        return this.fields;
    }

    public final int getFieldCount() {
        return this.fields_count;
    }

    public Field getDeclaredField(String name) {
        Field field = this.getFields();
        while (field != null) {
            if (name.equals(field.name)) {
                return field;
            }
            field = field.next;
        }
        return null;
    }

    @Override
    public synchronized Field getField(String name, int mask) {
        ClassType cl = this;
        do {
            Field field;
            if ((field = cl.getDeclaredField(name)) != null && (mask == -1 || (field.getModifiers() & mask) != 0)) {
                return field;
            }
            ClassType[] interfaces = cl.getInterfaces();
            if (interfaces == null) continue;
            for (int i = 0; i < interfaces.length; ++i) {
                field = interfaces[i].getField(name, mask);
                if (field == null) continue;
                return field;
            }
        } while ((cl = cl.getSuperclass()) != null);
        return null;
    }

    public Field getField(String name) {
        return this.getField(name, 1);
    }

    public Field addField() {
        return new Field(this);
    }

    public Field addField(String name) {
        Field field = new Field(this);
        field.setName(name);
        return field;
    }

    public final Field addField(String name, Type type) {
        Field field = new Field(this);
        field.setName(name);
        field.setType(type);
        return field;
    }

    public final Field addField(String name, Type type, int flags) {
        Field field = this.addField(name, type);
        field.flags = flags;
        return field;
    }

    public synchronized void addFields() {
        java.lang.reflect.Field[] fields;
        Class clas = this.getReflectClass();
        try {
            fields = clas.getDeclaredFields();
        }
        catch (SecurityException ex) {
            fields = clas.getFields();
        }
        for (java.lang.reflect.Field field : fields) {
            int mods;
            if ("this$0".equals(field.getName())) {
                this.flags |= 32;
            }
            if (((mods = field.getModifiers()) & 2) != 0) continue;
            Field fld = this.addField(field.getName(), null, mods);
            fld.rfield = field;
        }
        this.flags |= 1;
    }

    public void removeField(Field field, Field prev) {
        if (field != (prev == null ? this.fields : prev.next)) {
            new Error();
        }
        if (prev == null) {
            this.fields = field.next;
        } else {
            prev.next = field.next;
        }
        if (this.last_field == field) {
            this.last_field = null;
        }
        --this.fields_count;
    }

    public final Method getMethods() {
        return this.methods;
    }

    public final int getMethodCount() {
        return this.methods_count;
    }

    Method addMethod() {
        return new Method(this, 0);
    }

    public Method addMethod(String name) {
        return this.addMethod(name, 0);
    }

    public Method addMethod(String name, int flags) {
        Method method = new Method(this, flags);
        method.setName(name);
        return method;
    }

    public Method addMethod(String name, Type[] arg_types, Type return_type, int flags) {
        return this.addMethod(name, flags, arg_types, return_type);
    }

    public synchronized Method addMethod(String name, int flags, Type[] arg_types, Type return_type) {
        Method method = this.getDeclaredMethod(name, arg_types);
        if (method != null && return_type.equals(method.getReturnType()) && (flags & method.access_flags) == flags) {
            return method;
        }
        method = this.addMethod(name, flags);
        method.arg_types = arg_types;
        method.return_type = return_type;
        return method;
    }

    public Method addMethod(java.lang.reflect.Method method) {
        int modifiers = method.getModifiers();
        Class<?>[] paramTypes = method.getParameterTypes();
        java.lang.reflect.Type[] gparamTypes = method.getGenericParameterTypes();
        int j = paramTypes.length;
        Type[] args = new Type[j];
        while (--j >= 0) {
            args[j] = Type.make(paramTypes[j], gparamTypes[j]);
        }
        Type rtype = Type.make(method.getReturnType(), method.getGenericReturnType());
        Method meth = this.addMethod(method.getName(), modifiers, args, rtype);
        meth.rmethod = method;
        return meth;
    }

    public Method addMethod(Constructor method) {
        Class<?>[] paramTypes = method.getParameterTypes();
        int modifiers = method.getModifiers();
        int j = paramTypes.length;
        Type[] args = new Type[j];
        while (--j >= 0) {
            args[j] = Type.make(paramTypes[j]);
        }
        Method meth = this.addMethod("<init>", modifiers, args, Type.voidType);
        meth.rmethod = method;
        return meth;
    }

    public Method addMethod(String name, String signature, int flags) {
        Method meth = this.addMethod(name, flags);
        meth.setSignature(signature);
        return meth;
    }

    public Method getMethod(java.lang.reflect.Method method) {
        String name = method.getName();
        Class<?>[] parameterClasses = method.getParameterTypes();
        Type[] parameterTypes = new Type[parameterClasses.length];
        int i = parameterClasses.length;
        while (--i >= 0) {
            parameterTypes[i] = Type.make(parameterClasses[i]);
        }
        return this.addMethod(name, method.getModifiers(), parameterTypes, Type.make(method.getReturnType()));
    }

    public final synchronized Method getDeclaredMethods() {
        if ((this.flags & 18) == 16) {
            this.addMethods(this.getReflectClass());
        }
        return this.methods;
    }

    public final int countMethods(Filter filter, int searchSupers) {
        Vector<Method> vec = new Vector<Method>();
        this.getMethods(filter, searchSupers, vec);
        return vec.size();
    }

    public Method[] getMethods(Filter filter, boolean searchSupers) {
        return this.getMethods(filter, searchSupers ? 1 : 0);
    }

    public Method[] getMethods(Filter filter, int searchSupers) {
        Vector<Method> vec = new Vector<Method>();
        this.getMethods(filter, searchSupers, vec);
        int count = vec.size();
        Method[] result = new Method[count];
        for (int i = 0; i < count; ++i) {
            result[i] = vec.elementAt(i);
        }
        return result;
    }

    @Deprecated
    public int getMethods(Filter filter, int searchSupers, Method[] result, int offset) {
        Vector<Method> vec = new Vector<Method>();
        this.getMethods(filter, searchSupers, vec);
        int count = vec.size();
        for (int i = 0; i < count; ++i) {
            result[offset + i] = vec.elementAt(i);
        }
        return count;
    }

    @Override
    public int getMethods(Filter filter, int searchSupers, List<Method> result) {
        ClassType[] interfaces;
        int count = 0;
        String inheritingPackage = null;
        ClassType ctype = this;
        while (ctype != null) {
            String curPackage = ctype.getPackageName();
            for (Method meth = ctype.getDeclaredMethods(); meth != null; meth = meth.getNext()) {
                int mmods;
                if (ctype != this && (((mmods = meth.getModifiers()) & 2) != 0 || (mmods & 5) == 0 && !curPackage.equals(inheritingPackage)) || !filter.select(meth)) continue;
                if (result != null) {
                    result.add(meth);
                }
                ++count;
            }
            inheritingPackage = curPackage;
            if (searchSupers == 0) break;
            ctype = ctype.isInterface() ? Type.objectType : ctype.getSuperclass();
        }
        if (searchSupers > 1 && (interfaces = this.getAllInterfaces()) != null) {
            for (int i = 0; i < interfaces.length; ++i) {
                count += interfaces[i].getMethods(filter, 0, result);
            }
        }
        return count;
    }

    public Method[] getAbstractMethods() {
        return this.getMethods((Filter)AbstractMethodFilter.instance, 2);
    }

    public Method getDeclaredMethod(String name, Type[] arg_types) {
        int needOuterLinkArg = "<init>".equals(name) && this.hasOuterLink() ? 1 : 0;
        Method found = null;
        Method method = this.getDeclaredMethods();
        while (method != null) {
            if (name.equals(method.getName())) {
                boolean synthetic;
                int i;
                Type[] method_args = method.getParameterTypes();
                boolean bl = synthetic = (method.getModifiers() & 4160) != 0;
                if (arg_types == null || arg_types == method_args && needOuterLinkArg == 0) {
                    if (!synthetic) {
                        return method;
                    }
                    found = method;
                }
                if ((i = arg_types.length) == method_args.length - needOuterLinkArg) {
                    Type meth_type;
                    String need_sig;
                    Type need_type;
                    String meth_sig;
                    while (--i >= 0 && ((meth_type = method_args[i + needOuterLinkArg]) == (need_type = arg_types[i]) || need_type == null || (meth_sig = meth_type.getSignature()).equals(need_sig = need_type.getSignature()))) {
                    }
                    if (i < 0) {
                        if (!synthetic) {
                            return method;
                        }
                        found = method;
                    }
                }
            }
            method = method.next;
        }
        return found;
    }

    synchronized Method getDeclaredMethod(String name, boolean mustBeStatic, int argCount) {
        Method result = null;
        int needOuterLinkArg = "<init>".equals(name) && this.hasOuterLink() ? 1 : 0;
        Method method = this.getDeclaredMethods();
        while (method != null) {
            if ((!mustBeStatic || method.getStaticFlag()) && name.equals(method.getName()) && argCount + needOuterLinkArg == method.getParameterTypes().length) {
                if (result != null) {
                    throw new Error("ambiguous call to getDeclaredMethod(\"" + name + "\", " + argCount + ")\n - " + result + "\n - " + method);
                }
                result = method;
            }
            method = method.next;
        }
        return result;
    }

    public Method getDeclaredMethod(String name, int argCount) {
        return this.getDeclaredMethod(name, false, argCount);
    }

    public Method getDeclaredStaticMethod(String name, int argCount) {
        return this.getDeclaredMethod(name, true, argCount);
    }

    @Override
    public synchronized Method getMethod(String name, Type[] arg_types) {
        for (ClassType cl = this; cl != null; cl = cl.getSuperclass()) {
            Method m = cl.getDeclaredMethod(name, arg_types);
            if (m == null) continue;
            return m;
        }
        ClassType[] interfaces = this.getAllInterfaces();
        if (interfaces != null) {
            for (int i = 0; i < interfaces.length; ++i) {
                Method m = interfaces[i].getDeclaredMethod(name, arg_types);
                if (m == null) continue;
                return m;
            }
        }
        return null;
    }

    public Method getDefaultConstructor() {
        return this.getDeclaredMethod("<init>", Type.typeArray0);
    }

    public synchronized void addMethods(Class clas) {
        java.lang.reflect.Method[] methods;
        Constructor<?>[] cmethods;
        this.flags |= 2;
        try {
            methods = clas.getDeclaredMethods();
        }
        catch (SecurityException ex) {
            methods = clas.getMethods();
        }
        for (java.lang.reflect.Method method : methods) {
            if (!method.getDeclaringClass().equals((Object)clas)) continue;
            this.addMethod(method);
        }
        try {
            cmethods = clas.getDeclaredConstructors();
        }
        catch (SecurityException ex) {
            cmethods = clas.getConstructors();
        }
        for (Constructor<?> method : cmethods) {
            if (!method.getDeclaringClass().equals((Object)clas)) continue;
            this.addMethod(method);
        }
    }

    public Method[] getMatchingMethods(String name, Type[] paramTypes, int flags) {
        int nMatches = 0;
        Vector<Method> matches = new Vector<Method>(10);
        for (Method method = this.methods; method != null; method = method.getNext()) {
            Type[] mtypes;
            if (!name.equals(method.getName()) || (flags & 8) != (method.access_flags & 8) || (flags & 1) > (method.access_flags & 1) || (mtypes = method.arg_types).length != paramTypes.length) continue;
            ++nMatches;
            matches.addElement(method);
        }
        Object[] result = new Method[nMatches];
        matches.copyInto(result);
        return result;
    }

    public <T extends Annotation> T getAnnotation(Class<T> clas) {
        T ann = RuntimeAnnotationsAttr.getAnnotation(this, clas);
        if (ann != null) {
            return ann;
        }
        if ((this.flags & 16) != 0 && this.getReflectClass() != null) {
            Class c = this.getReflectClass();
            return c.getAnnotation(clas);
        }
        return null;
    }

    public void doFixups() {
        int i;
        if (this.constants == null) {
            this.constants = new ConstantPool();
        }
        if (this.thisClassIndex == 0) {
            this.thisClassIndex = this.constants.addClass((ObjectType)this).index;
        }
        if (this.superClass == this) {
            this.setSuper((ClassType)null);
        }
        if (this.superClassIndex < 0) {
            int n = this.superClassIndex = this.superClass == null ? 0 : this.constants.addClass((ObjectType)this.superClass).index;
        }
        if (this.interfaces != null && this.interfaceIndexes == null) {
            int n = this.interfaces.length;
            this.interfaceIndexes = new int[n];
            for (i = 0; i < n; ++i) {
                this.interfaceIndexes[i] = this.constants.addClass((ObjectType)this.interfaces[i]).index;
            }
        }
        Field field = this.fields;
        while (field != null) {
            field.assign_constants(this);
            field = field.next;
        }
        Method method = this.methods;
        while (method != null) {
            method.assignConstants();
            method = method.next;
        }
        if (this.enclosingMember instanceof Method) {
            EnclosingMethodAttr attr = EnclosingMethodAttr.getFirstEnclosingMethod(this.getAttributes());
            if (attr == null) {
                attr = new EnclosingMethodAttr(this);
            }
            attr.method = (Method)this.enclosingMember;
        } else if (this.enclosingMember instanceof ClassType) {
            this.constants.addClass((ClassType)this.enclosingMember);
        }
        ClassType member = this.firstInnerClass;
        while (member != null) {
            this.constants.addClass(member);
            member = member.nextInnerClass;
        }
        InnerClassesAttr innerAttr = InnerClassesAttr.getFirstInnerClasses(this.getAttributes());
        if (innerAttr != null) {
            innerAttr.setSkipped(true);
        }
        Attribute.assignConstants(this, this);
        for (i = 1; i <= this.constants.count; ++i) {
            ClassType ctype;
            CpoolEntry entry = this.constants.pool[i];
            if (!(entry instanceof CpoolClass)) continue;
            CpoolClass centry = (CpoolClass)entry;
            if (!(centry.clas instanceof ClassType) || (ctype = (ClassType)centry.clas).getEnclosingMember() == null) continue;
            if (innerAttr == null) {
                innerAttr = new InnerClassesAttr(this);
            }
            innerAttr.addClass(centry, this);
        }
        if (innerAttr != null) {
            innerAttr.setSkipped(false);
            innerAttr.assignConstants(this);
        }
    }

    public void writeToStream(OutputStream stream) throws IOException {
        DataOutputStream dstr = new DataOutputStream(stream);
        this.doFixups();
        dstr.writeInt(-889275714);
        dstr.writeShort(this.getClassfileMinorVersion());
        dstr.writeShort(this.getClassfileMajorVersion());
        if (this.constants == null) {
            dstr.writeShort(1);
        } else {
            this.constants.write(dstr);
        }
        dstr.writeShort(this.access_flags);
        dstr.writeShort(this.thisClassIndex);
        dstr.writeShort(this.superClassIndex);
        if (this.interfaceIndexes == null) {
            dstr.writeShort(0);
        } else {
            int interfaces_count = this.interfaceIndexes.length;
            dstr.writeShort(interfaces_count);
            for (int i = 0; i < interfaces_count; ++i) {
                dstr.writeShort(this.interfaceIndexes[i]);
            }
        }
        dstr.writeShort(this.fields_count);
        Field field = this.fields;
        while (field != null) {
            field.write(dstr, this);
            field = field.next;
        }
        dstr.writeShort(this.methods_count);
        Method method = this.methods;
        while (method != null) {
            method.write(dstr, this);
            method = method.next;
        }
        Attribute.writeAll(this, dstr);
        this.flags |= 11;
    }

    public void writeToFile(String filename) throws IOException {
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(filename));
        this.writeToStream(stream);
        ((OutputStream)stream).close();
    }

    public void writeToFile() throws IOException {
        this.writeToFile(this.this_name.replace('.', File.separatorChar) + ".class");
    }

    public byte[] writeToArray() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream(500);
        try {
            this.writeToStream(stream);
        }
        catch (IOException ex) {
            throw new InternalError(ex.toString());
        }
        return stream.toByteArray();
    }

    public static byte[] to_utf8(String str) {
        if (str == null) {
            return null;
        }
        int str_len = str.length();
        int utf_len = 0;
        for (int i = 0; i < str_len; ++i) {
            char c = str.charAt(i);
            if (c > '\u0000' && c <= '') {
                ++utf_len;
                continue;
            }
            if (c <= '\u07ff') {
                utf_len += 2;
                continue;
            }
            utf_len += 3;
        }
        byte[] buffer = new byte[utf_len];
        int j = 0;
        for (int i = 0; i < str_len; ++i) {
            char c = str.charAt(i);
            if (c > '\u0000' && c <= '') {
                buffer[j++] = (byte)c;
                continue;
            }
            if (c <= '\u07ff') {
                buffer[j++] = (byte)(192 | c >> 6 & 31);
                buffer[j++] = (byte)(128 | c >> 0 & 63);
                continue;
            }
            buffer[j++] = (byte)(224 | c >> 12 & 15);
            buffer[j++] = (byte)(128 | c >> 6 & 63);
            buffer[j++] = (byte)(128 | c >> 0 & 63);
        }
        return buffer;
    }

    public final boolean implementsInterface(ClassType iface) {
        if (this == iface) {
            return true;
        }
        ClassType baseClass = this.getSuperclass();
        if (baseClass != null && baseClass.implementsInterface(iface)) {
            return true;
        }
        ClassType[] interfaces = this.getInterfaces();
        if (interfaces != null) {
            int i = interfaces.length;
            while (--i >= 0) {
                if (!interfaces[i].implementsInterface(iface)) continue;
                return true;
            }
        }
        return false;
    }

    public final boolean isSubclass(String cname) {
        ClassType ctype = this;
        do {
            if (!cname.equals(ctype.getName())) continue;
            return true;
        } while ((ctype = ctype.getSuperclass()) != null);
        return false;
    }

    public final boolean isSubclass(ClassType other) {
        if (other.isInterface()) {
            return this.implementsInterface(other);
        }
        if (this == javalangStringType && other == toStringType) {
            return true;
        }
        if (other == Type.javalangObjectType) {
            return true;
        }
        for (ClassType baseClass = this; baseClass != null; baseClass = baseClass.getSuperclass()) {
            if (baseClass != other) continue;
            return true;
        }
        return false;
    }

    @Override
    public int isCompatibleWithValue(Type valueType) {
        if (this == objectType && valueType instanceof ObjectType) {
            return 2;
        }
        if (valueType == Type.nullType || Type.isSame(this, valueType)) {
            return 2;
        }
        if (this.isInterface()) {
            Type rawType = valueType.getRawType();
            if (!(rawType instanceof ClassType)) {
                return -1;
            }
            if (rawType == objectType) {
                return 0;
            }
            if (((ClassType)rawType).implementsInterface(this)) {
                return 2;
            }
            if (rawType.isInterface() && this.implementsInterface((ClassType)rawType)) {
                return 0;
            }
            return -1;
        }
        int comp = this.compare(valueType);
        if (comp >= 0) {
            return valueType instanceof ObjectType ? 2 : 1;
        }
        return comp == -3 ? -1 : 0;
    }

    @Override
    public int compare(Type other) {
        if (other == nullType) {
            return 1;
        }
        if (!(other instanceof ClassType)) {
            return ClassType.swappedCompareResult(other.compare(this));
        }
        String name = this.getName();
        if (name != null && name.equals(other.getName())) {
            return 0;
        }
        ClassType cother = (ClassType)other;
        if (this.isSubclass(cother)) {
            return -1;
        }
        if (cother.isSubclass(this)) {
            return 1;
        }
        if (this.isInterface()) {
            return cother.isAnnotation() || cother.isFinal() ? -3 : (cother == Type.javalangObjectType ? -1 : -2);
        }
        if (cother.isInterface()) {
            return this.isAnnotation() || this.isFinal() ? -3 : (this == Type.javalangObjectType ? 1 : -2);
        }
        return -3;
    }

    @Override
    public String toString() {
        return "ClassType " + this.getName();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.getName());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setName(in.readUTF());
        this.flags |= 16;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object readResolve() throws ObjectStreamException {
        HashMap map;
        String name = this.getName();
        HashMap hashMap = map = mapNameToType;
        synchronized (hashMap) {
            Type found = (Type)map.get(name);
            if (found != null) {
                return found;
            }
            map.put(name, this);
        }
        return this;
    }

    public void cleanupAfterCompilation() {
        for (Method meth = this.methods; meth != null; meth = meth.getNext()) {
            meth.cleanupAfterCompilation();
        }
        this.constants = null;
        this.attributes = null;
        this.sourceDbgExt = null;
    }

    public Method checkSingleAbstractMethod() {
        Method[] methods = this.getAbstractMethods();
        int nmethods = methods.length;
        Method result = null;
        for (int i = 0; i < nmethods; ++i) {
            String sig;
            Method meth = methods[i];
            final String mname = meth.getName();
            Filter<Method> filter = new Filter<Method>(sig = meth.getSignature()){
                final /* synthetic */ String val$sig;
                {
                    this.val$sig = string2;
                }

                @Override
                public boolean select(Method m) {
                    return !m.isAbstract() && mname.equals(m.getName()) && this.val$sig.equals(m.getSignature());
                }
            };
            if (this.countMethods(filter, 2) > 0) continue;
            if (result != null) {
                return null;
            }
            result = meth;
        }
        return result;
    }

    static class AbstractMethodFilter
    implements Filter {
        public static final AbstractMethodFilter instance = new AbstractMethodFilter();

        AbstractMethodFilter() {
        }

        public boolean select(Object value) {
            Method method = (Method)value;
            return method.isAbstract();
        }
    }

}

