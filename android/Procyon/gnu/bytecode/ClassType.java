// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.ObjectStreamException;
import java.util.HashMap;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Vector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.lang.reflect.Constructor;
import java.io.Externalizable;

public class ClassType extends ObjectType implements AttrContainer, Externalizable, Member
{
    public static final int JDK_1_1_VERSION = 2949123;
    public static final int JDK_1_2_VERSION = 3014656;
    public static final int JDK_1_3_VERSION = 3080192;
    public static final int JDK_1_4_VERSION = 3145728;
    public static final int JDK_1_5_VERSION = 3211264;
    public static final int JDK_1_6_VERSION = 3276800;
    public static final int JDK_1_7_VERSION = 3342336;
    public static final int JDK_1_8_VERSION = 3407872;
    public static final int JAVA_9_VERSION = 3473408;
    int classfileFormatVersion;
    int thisClassIndex;
    private ClassType superClass;
    int superClassIndex;
    ClassType[] interfaces;
    private ClassType[] allInterfaces;
    int[] interfaceIndexes;
    int access_flags;
    Attribute attributes;
    public static final ClassType[] noClasses;
    boolean emitDebugInfo;
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
        return (short)(this.classfileFormatVersion & 0xFFFF);
    }
    
    public void setClassfileVersion(final int major, final int minor) {
        this.classfileFormatVersion = (major & 0xFFFF) * 65536 + minor * 65535;
    }
    
    public void setClassfileVersion(final int code) {
        this.classfileFormatVersion = code;
    }
    
    public int getClassfileVersion() {
        return this.classfileFormatVersion;
    }
    
    public void setClassfileVersionJava5() {
        this.setClassfileVersion(3211264);
    }
    
    public static ClassType make(final String name) {
        return (ClassType)Type.getType(name);
    }
    
    @Deprecated
    public static ClassType make(final String name, final ClassType superClass) {
        final ClassType type = make(name);
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
    public final void setAttributes(final Attribute attributes) {
        this.attributes = attributes;
    }
    
    @Override
    public final ConstantPool getConstants() {
        return this.constants;
    }
    
    public final CpoolEntry getConstant(final int i) {
        if (this.constants == null || this.constants.pool == null || i > this.constants.count) {
            return null;
        }
        return this.constants.pool[i];
    }
    
    @Override
    public final synchronized int getModifiers() {
        if (this.access_flags == 0 && (this.flags & 0x10) != 0x0 && this.getReflectClass() != null) {
            this.access_flags = this.reflectClass.getModifiers();
        }
        return this.access_flags;
    }
    
    @Override
    public final boolean getStaticFlag() {
        return (this.getModifiers() & 0x8) != 0x0;
    }
    
    public final void setModifiers(final int flags) {
        this.access_flags = flags;
    }
    
    public final void addModifiers(final int flags) {
        this.access_flags |= flags;
    }
    
    public synchronized String getSimpleName() {
        if ((this.flags & 0x10) != 0x0 && this.getReflectClass() != null) {
            try {
                return this.reflectClass.getSimpleName();
            }
            catch (Exception ex) {}
        }
        String name = this.getName();
        if (this.enclosingMember instanceof ClassType) {
            final String enclosingName = ((ClassType)this.enclosingMember).getName();
            final int enclosingLength;
            if (enclosingName != null && name.startsWith(enclosingName) && name.length() > (enclosingLength = enclosingName.length()) + 1 && name.charAt(enclosingLength) == '$') {
                return name.substring(enclosingLength + 1);
            }
        }
        final int dot = name.lastIndexOf(46);
        if (dot > 0) {
            name = name.substring(dot + 1);
        }
        return name;
    }
    
    public void addMemberClass(final ClassType member) {
        ClassType prev = null;
        for (ClassType entry = this.firstInnerClass; entry != null; entry = entry.nextInnerClass) {
            if (entry == member) {
                return;
            }
            prev = entry;
        }
        if (prev == null) {
            this.firstInnerClass = member;
        }
        else {
            prev.nextInnerClass = member;
        }
    }
    
    public ClassType getDeclaredClass(final String simpleName) {
        this.addMemberClasses();
        for (ClassType member = this.firstInnerClass; member != null; member = member.nextInnerClass) {
            if (simpleName.equals(member.getSimpleName())) {
                return member;
            }
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
    
    public void setEnclosingMember(final Member member) {
        this.enclosingMember = member;
    }
    
    synchronized void addEnclosingMember() {
        if ((this.flags & 0x18) != 0x10) {
            return;
        }
        final Class clas = this.getReflectClass();
        this.flags |= 0x8;
        final Class dclas = clas.getEnclosingClass();
        if (dclas == null) {
            return;
        }
        if (!clas.isMemberClass()) {
            final java.lang.reflect.Method rmeth = clas.getEnclosingMethod();
            if (rmeth != null) {
                this.enclosingMember = this.addMethod(rmeth);
                return;
            }
            final Constructor rcons = clas.getEnclosingConstructor();
            if (rcons != null) {
                this.enclosingMember = this.addMethod(rcons);
                return;
            }
        }
        this.enclosingMember = (ClassType)Type.make(dclas);
    }
    
    public synchronized void addMemberClasses() {
        if ((this.flags & 0x14) != 0x10) {
            return;
        }
        final Class clas = this.getReflectClass();
        this.flags |= 0x4;
        final Class[] memberClasses = clas.getClasses();
        final int numMembers = memberClasses.length;
        if (numMembers > 0) {
            for (int i = 0; i < numMembers; ++i) {
                final ClassType member = (ClassType)Type.make(memberClasses[i]);
                this.addMemberClass(member);
            }
        }
    }
    
    public final boolean hasOuterLink() {
        this.getFields();
        return (this.flags & 0x20) != 0x0;
    }
    
    public ClassType getOuterLinkType() {
        return this.hasOuterLink() ? ((ClassType)this.getDeclaredField("this$0").getType()) : null;
    }
    
    public final Field setOuterLink(final ClassType outer) {
        if ((this.flags & 0x10) != 0x0) {
            throw new Error("setOuterLink called for existing class " + this.getName());
        }
        Field field = this.getDeclaredField("this$0");
        if (field == null) {
            field = this.addField("this$0", outer);
            this.flags |= 0x20;
            for (Method meth = this.methods; meth != null; meth = meth.getNext()) {
                if ("<init>".equals(meth.getName())) {
                    if (meth.code != null) {
                        throw new Error("setOuterLink called when " + meth + " has code");
                    }
                    final Type[] arg_types = meth.arg_types;
                    final Type[] new_types = new Type[arg_types.length + 1];
                    System.arraycopy(arg_types, 0, new_types, 1, arg_types.length);
                    new_types[0] = outer;
                    meth.arg_types = new_types;
                    meth.signature = null;
                }
            }
        }
        else if (!outer.equals(field.getType())) {
            throw new Error("inconsistent setOuterLink call for " + this.getName());
        }
        return field;
    }
    
    public boolean isAccessible(final Member member, ObjectType receiver) {
        if (member.getStaticFlag()) {
            receiver = null;
        }
        return this.isAccessible(member.getDeclaringClass(), receiver, member.getModifiers());
    }
    
    public boolean isAccessible(final ClassType declaring, final ObjectType receiver, final int modifiers) {
        final int cmods = declaring.getModifiers();
        if ((modifiers & 0x1) != 0x0 && (cmods & 0x1) != 0x0) {
            return true;
        }
        final String callerName = this.getName();
        final String className = declaring.getName();
        if (callerName.equals(className)) {
            return true;
        }
        if ((modifiers & 0x2) != 0x0) {
            return false;
        }
        int dot = callerName.lastIndexOf(46);
        final String callerPackage = (dot >= 0) ? callerName.substring(0, dot) : "";
        dot = className.lastIndexOf(46);
        final String classPackage = (dot >= 0) ? className.substring(0, dot) : "";
        return callerPackage.equals(classPackage) || ((cmods & 0x1) != 0x0 && ((modifiers & 0x4) != 0x0 && this.isSubclass(declaring) && (!(receiver instanceof ClassType) || ((ClassType)receiver).isSubclass(this))));
    }
    
    @Override
    public void setName(final String name) {
        this.this_name = name;
        this.setSignature(nameToSignature(name));
    }
    
    public static String nameToSignature(final String name) {
        return "L" + name.replace('.', '/') + ";";
    }
    
    public void setStratum(final String stratum) {
        if (this.sourceDbgExt == null) {
            this.sourceDbgExt = new SourceDebugExtAttr(this);
        }
        this.sourceDbgExt.addStratum(stratum);
    }
    
    public void setSourceFile(String name) {
        if (this.sourceDbgExt != null) {
            this.sourceDbgExt.addFile(name);
            if (this.sourceDbgExt.fileCount > 1) {
                return;
            }
        }
        name = SourceFileAttr.fixSourceFile(name);
        final int slash = name.lastIndexOf(47);
        if (slash >= 0) {
            name = name.substring(slash + 1);
        }
        SourceFileAttr.setSourceFile(this, name);
    }
    
    public TypeVariable[] getTypeParameters() {
        TypeVariable[] params = this.typeParameters;
        if (params == null && (this.flags & 0x10) != 0x0 && this.getReflectClass() != null) {
            final java.lang.reflect.TypeVariable[] rparams = this.reflectClass.getTypeParameters();
            final int nparams = rparams.length;
            params = new TypeVariable[nparams];
            for (int i = 0; i < nparams; ++i) {
                params[i] = TypeVariable.make(rparams[i]);
            }
            this.typeParameters = params;
        }
        return params;
    }
    
    public void setSuper(final String name) {
        this.setSuper((name == null) ? Type.pointer_type : make(name));
    }
    
    public void setSuper(final ClassType superClass) {
        this.superClass = superClass;
    }
    
    public synchronized ClassType getSuperclass() {
        if (this.superClass == null && !this.isInterface() && !"java.lang.Object".equals(this.getName()) && (this.flags & 0x10) != 0x0 && this.getReflectClass() != null) {
            this.superClass = (ClassType)Type.make(this.reflectClass.getSuperclass());
        }
        return this.superClass;
    }
    
    public String getPackageName() {
        final String name = this.getName();
        final int index = name.lastIndexOf(46);
        return (index < 0) ? "" : name.substring(0, index);
    }
    
    public synchronized ClassType[] getInterfaces() {
        if (this.interfaces == null && (this.flags & 0x10) != 0x0 && this.getReflectClass() != null) {
            final Class[] reflectInterfaces = this.reflectClass.getInterfaces();
            final int numInterfaces = reflectInterfaces.length;
            this.interfaces = ((numInterfaces == 0) ? ClassType.noClasses : new ClassType[numInterfaces]);
            for (int i = 0; i < numInterfaces; ++i) {
                this.interfaces[i] = (ClassType)Type.make(reflectInterfaces[i]);
            }
        }
        return this.interfaces;
    }
    
    public synchronized ClassType[] getAllInterfaces() {
        if (this.allInterfaces == null) {
            final LinkedHashMap<String, ClassType> map = new LinkedHashMap<String, ClassType>();
            for (ClassType t = this; t != null; t = t.getSuperclass()) {
                if (!t.addInterfaces(map)) {
                    return null;
                }
            }
            final ClassType[] allInts = new ClassType[map.size()];
            int i = 0;
            for (final ClassType intf : map.values()) {
                allInts[i++] = intf;
            }
            this.allInterfaces = allInts;
        }
        return this.allInterfaces;
    }
    
    private boolean addInterfaces(final LinkedHashMap<String, ClassType> map) {
        final ClassType[] intfs = this.getInterfaces();
        if (intfs == null) {
            return false;
        }
        for (final ClassType intf : intfs) {
            if (map.put(intf.getName(), intf) == null && !intf.addInterfaces(map)) {
                return false;
            }
        }
        return true;
    }
    
    public void setInterfaces(final ClassType[] interfaces) {
        this.interfaces = interfaces;
    }
    
    public void addInterface(final ClassType newInterface) {
        int oldCount;
        if (this.interfaces == null || this.interfaces.length == 0) {
            oldCount = 0;
            this.interfaces = new ClassType[1];
        }
        else {
            int i;
            oldCount = (i = this.interfaces.length);
            while (--i >= 0) {
                if (this.interfaces[i] == newInterface) {
                    return;
                }
            }
            final ClassType[] newInterfaces = new ClassType[oldCount + 1];
            System.arraycopy(this.interfaces, 0, newInterfaces, 0, oldCount);
            this.interfaces = newInterfaces;
        }
        this.interfaces[oldCount] = newInterface;
    }
    
    @Override
    public final boolean isInterface() {
        return (this.getModifiers() & 0x200) != 0x0;
    }
    
    public final void setInterface(final boolean val) {
        if (val) {
            this.access_flags |= 0x600;
        }
        else {
            this.access_flags &= 0xFFFFFDFF;
        }
    }
    
    public final boolean isFinal() {
        return (this.getModifiers() & 0x10) != 0x0;
    }
    
    public final boolean isAnnotation() {
        return (this.getModifiers() & 0x2000) != 0x0;
    }
    
    public ClassType() {
        this.classfileFormatVersion = 3211264;
        this.superClassIndex = -1;
        this.emitDebugInfo = true;
    }
    
    public ClassType(final String class_name) {
        this.classfileFormatVersion = 3211264;
        this.superClassIndex = -1;
        this.emitDebugInfo = true;
        this.setName(class_name);
    }
    
    public final synchronized Field getFields() {
        if ((this.flags & 0x11) == 0x10) {
            this.addFields();
        }
        return this.fields;
    }
    
    public final int getFieldCount() {
        return this.fields_count;
    }
    
    public Field getDeclaredField(final String name) {
        for (Field field = this.getFields(); field != null; field = field.next) {
            if (name.equals(field.name)) {
                return field;
            }
        }
        return null;
    }
    
    @Override
    public synchronized Field getField(final String name, final int mask) {
        ClassType cl = this;
        while (true) {
            Field field = cl.getDeclaredField(name);
            if (field != null && (mask == -1 || (field.getModifiers() & mask) != 0x0)) {
                return field;
            }
            final ClassType[] interfaces = cl.getInterfaces();
            if (interfaces != null) {
                for (int i = 0; i < interfaces.length; ++i) {
                    field = interfaces[i].getField(name, mask);
                    if (field != null) {
                        return field;
                    }
                }
            }
            cl = cl.getSuperclass();
            if (cl == null) {
                return null;
            }
        }
    }
    
    public Field getField(final String name) {
        return this.getField(name, 1);
    }
    
    public Field addField() {
        return new Field(this);
    }
    
    public Field addField(final String name) {
        final Field field = new Field(this);
        field.setName(name);
        return field;
    }
    
    public final Field addField(final String name, final Type type) {
        final Field field = new Field(this);
        field.setName(name);
        field.setType(type);
        return field;
    }
    
    public final Field addField(final String name, final Type type, final int flags) {
        final Field field = this.addField(name, type);
        field.flags = flags;
        return field;
    }
    
    public synchronized void addFields() {
        final Class clas = this.getReflectClass();
        java.lang.reflect.Field[] fields;
        try {
            fields = clas.getDeclaredFields();
        }
        catch (SecurityException ex) {
            fields = clas.getFields();
        }
        for (final java.lang.reflect.Field field : fields) {
            if ("this$0".equals(field.getName())) {
                this.flags |= 0x20;
            }
            final int mods = field.getModifiers();
            if ((mods & 0x2) == 0x0) {
                final Field fld = this.addField(field.getName(), null, mods);
                fld.rfield = field;
            }
        }
        this.flags |= 0x1;
    }
    
    public void removeField(final Field field, final Field prev) {
        if (field != ((prev == null) ? this.fields : prev.next)) {
            new Error();
        }
        if (prev == null) {
            this.fields = field.next;
        }
        else {
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
    
    public Method addMethod(final String name) {
        return this.addMethod(name, 0);
    }
    
    public Method addMethod(final String name, final int flags) {
        final Method method = new Method(this, flags);
        method.setName(name);
        return method;
    }
    
    public Method addMethod(final String name, final Type[] arg_types, final Type return_type, final int flags) {
        return this.addMethod(name, flags, arg_types, return_type);
    }
    
    public synchronized Method addMethod(final String name, final int flags, final Type[] arg_types, final Type return_type) {
        Method method = this.getDeclaredMethod(name, arg_types);
        if (method != null && return_type.equals(method.getReturnType()) && (flags & method.access_flags) == flags) {
            return method;
        }
        method = this.addMethod(name, flags);
        method.arg_types = arg_types;
        method.return_type = return_type;
        return method;
    }
    
    public Method addMethod(final java.lang.reflect.Method method) {
        final int modifiers = method.getModifiers();
        final Class[] paramTypes = method.getParameterTypes();
        final java.lang.reflect.Type[] gparamTypes = method.getGenericParameterTypes();
        int j = paramTypes.length;
        final Type[] args = new Type[j];
        while (--j >= 0) {
            args[j] = Type.make(paramTypes[j], gparamTypes[j]);
        }
        final Type rtype = Type.make(method.getReturnType(), method.getGenericReturnType());
        final Method meth = this.addMethod(method.getName(), modifiers, args, rtype);
        meth.rmethod = method;
        return meth;
    }
    
    public Method addMethod(final Constructor method) {
        final Class[] paramTypes = method.getParameterTypes();
        final int modifiers = method.getModifiers();
        int j = paramTypes.length;
        final Type[] args = new Type[j];
        while (--j >= 0) {
            args[j] = Type.make(paramTypes[j]);
        }
        final Method meth = this.addMethod("<init>", modifiers, args, Type.voidType);
        meth.rmethod = method;
        return meth;
    }
    
    public Method addMethod(final String name, final String signature, final int flags) {
        final Method meth = this.addMethod(name, flags);
        meth.setSignature(signature);
        return meth;
    }
    
    public Method getMethod(final java.lang.reflect.Method method) {
        final String name = method.getName();
        final Class[] parameterClasses = method.getParameterTypes();
        final Type[] parameterTypes = new Type[parameterClasses.length];
        int i = parameterClasses.length;
        while (--i >= 0) {
            parameterTypes[i] = Type.make(parameterClasses[i]);
        }
        return this.addMethod(name, method.getModifiers(), parameterTypes, Type.make(method.getReturnType()));
    }
    
    public final synchronized Method getDeclaredMethods() {
        if ((this.flags & 0x12) == 0x10) {
            this.addMethods(this.getReflectClass());
        }
        return this.methods;
    }
    
    public final int countMethods(final Filter filter, final int searchSupers) {
        final Vector vec = new Vector();
        this.getMethods(filter, searchSupers, vec);
        return vec.size();
    }
    
    public Method[] getMethods(final Filter filter, final boolean searchSupers) {
        return this.getMethods(filter, searchSupers ? 1 : 0);
    }
    
    public Method[] getMethods(final Filter filter, final int searchSupers) {
        final Vector<Method> vec = new Vector<Method>();
        this.getMethods(filter, searchSupers, vec);
        final int count = vec.size();
        final Method[] result = new Method[count];
        for (int i = 0; i < count; ++i) {
            result[i] = vec.elementAt(i);
        }
        return result;
    }
    
    @Deprecated
    public int getMethods(final Filter filter, final int searchSupers, final Method[] result, final int offset) {
        final Vector<Method> vec = new Vector<Method>();
        this.getMethods(filter, searchSupers, vec);
        final int count = vec.size();
        for (int i = 0; i < count; ++i) {
            result[offset + i] = vec.elementAt(i);
        }
        return count;
    }
    
    @Override
    public int getMethods(final Filter filter, final int searchSupers, final List<Method> result) {
        int count = 0;
        String inheritingPackage = null;
        for (ClassType ctype = this; ctype != null; ctype = (ctype.isInterface() ? Type.objectType : ctype.getSuperclass())) {
            final String curPackage = ctype.getPackageName();
            for (Method meth = ctype.getDeclaredMethods(); meth != null; meth = meth.getNext()) {
                if (ctype != this) {
                    final int mmods = meth.getModifiers();
                    if ((mmods & 0x2) != 0x0) {
                        continue;
                    }
                    if ((mmods & 0x5) == 0x0 && !curPackage.equals(inheritingPackage)) {
                        continue;
                    }
                }
                if (filter.select(meth)) {
                    if (result != null) {
                        result.add(meth);
                    }
                    ++count;
                }
            }
            inheritingPackage = curPackage;
            if (searchSupers == 0) {
                break;
            }
        }
        if (searchSupers > 1) {
            final ClassType[] interfaces = this.getAllInterfaces();
            if (interfaces != null) {
                for (int i = 0; i < interfaces.length; ++i) {
                    count += interfaces[i].getMethods(filter, 0, result);
                }
            }
        }
        return count;
    }
    
    public Method[] getAbstractMethods() {
        return this.getMethods(AbstractMethodFilter.instance, 2);
    }
    
    public Method getDeclaredMethod(final String name, final Type[] arg_types) {
        final int needOuterLinkArg = ("<init>".equals(name) && this.hasOuterLink()) ? 1 : 0;
        Method found = null;
        for (Method method = this.getDeclaredMethods(); method != null; method = method.next) {
            if (name.equals(method.getName())) {
                final Type[] method_args = method.getParameterTypes();
                final boolean synthetic = (method.getModifiers() & 0x1040) != 0x0;
                if (arg_types == null || (arg_types == method_args && needOuterLinkArg == 0)) {
                    if (!synthetic) {
                        return method;
                    }
                    found = method;
                }
                int i = arg_types.length;
                if (i == method_args.length - needOuterLinkArg) {
                    while (--i >= 0) {
                        final Type meth_type = method_args[i + needOuterLinkArg];
                        final Type need_type = arg_types[i];
                        if (meth_type != need_type) {
                            if (need_type == null) {
                                continue;
                            }
                            final String meth_sig = meth_type.getSignature();
                            final String need_sig = need_type.getSignature();
                            if (!meth_sig.equals(need_sig)) {
                                break;
                            }
                            continue;
                        }
                    }
                    if (i < 0) {
                        if (!synthetic) {
                            return method;
                        }
                        found = method;
                    }
                }
            }
        }
        return found;
    }
    
    synchronized Method getDeclaredMethod(final String name, final boolean mustBeStatic, final int argCount) {
        Method result = null;
        final int needOuterLinkArg = ("<init>".equals(name) && this.hasOuterLink()) ? 1 : 0;
        for (Method method = this.getDeclaredMethods(); method != null; method = method.next) {
            if (!mustBeStatic || method.getStaticFlag()) {
                if (name.equals(method.getName()) && argCount + needOuterLinkArg == method.getParameterTypes().length) {
                    if (result != null) {
                        throw new Error("ambiguous call to getDeclaredMethod(\"" + name + "\", " + argCount + ")\n - " + result + "\n - " + method);
                    }
                    result = method;
                }
            }
        }
        return result;
    }
    
    public Method getDeclaredMethod(final String name, final int argCount) {
        return this.getDeclaredMethod(name, false, argCount);
    }
    
    public Method getDeclaredStaticMethod(final String name, final int argCount) {
        return this.getDeclaredMethod(name, true, argCount);
    }
    
    @Override
    public synchronized Method getMethod(final String name, final Type[] arg_types) {
        for (ClassType cl = this; cl != null; cl = cl.getSuperclass()) {
            final Method m = cl.getDeclaredMethod(name, arg_types);
            if (m != null) {
                return m;
            }
        }
        final ClassType[] interfaces = this.getAllInterfaces();
        if (interfaces != null) {
            for (int i = 0; i < interfaces.length; ++i) {
                final Method j = interfaces[i].getDeclaredMethod(name, arg_types);
                if (j != null) {
                    return j;
                }
            }
        }
        return null;
    }
    
    public Method getDefaultConstructor() {
        return this.getDeclaredMethod("<init>", Type.typeArray0);
    }
    
    public synchronized void addMethods(final Class clas) {
        this.flags |= 0x2;
        java.lang.reflect.Method[] methods;
        try {
            methods = clas.getDeclaredMethods();
        }
        catch (SecurityException ex) {
            methods = clas.getMethods();
        }
        for (final java.lang.reflect.Method method : methods) {
            if (method.getDeclaringClass().equals(clas)) {
                this.addMethod(method);
            }
        }
        Constructor[] cmethods;
        try {
            cmethods = clas.getDeclaredConstructors();
        }
        catch (SecurityException ex2) {
            cmethods = clas.getConstructors();
        }
        for (final Constructor method2 : cmethods) {
            if (method2.getDeclaringClass().equals(clas)) {
                this.addMethod(method2);
            }
        }
    }
    
    public Method[] getMatchingMethods(final String name, final Type[] paramTypes, final int flags) {
        int nMatches = 0;
        final Vector matches = new Vector(10);
        for (Method method = this.methods; method != null; method = method.getNext()) {
            if (name.equals(method.getName())) {
                if ((flags & 0x8) == (method.access_flags & 0x8)) {
                    if ((flags & 0x1) <= (method.access_flags & 0x1)) {
                        final Type[] mtypes = method.arg_types;
                        if (mtypes.length == paramTypes.length) {
                            ++nMatches;
                            matches.addElement(method);
                        }
                    }
                }
            }
        }
        final Method[] result = new Method[nMatches];
        matches.copyInto(result);
        return result;
    }
    
    public <T extends Annotation> T getAnnotation(final Class<T> clas) {
        final T ann = RuntimeAnnotationsAttr.getAnnotation(this, clas);
        if (ann != null) {
            return ann;
        }
        if ((this.flags & 0x10) != 0x0 && this.getReflectClass() != null) {
            final Class<?> c = (Class<?>)this.getReflectClass();
            return c.getAnnotation(clas);
        }
        return null;
    }
    
    public void doFixups() {
        if (this.constants == null) {
            this.constants = new ConstantPool();
        }
        if (this.thisClassIndex == 0) {
            this.thisClassIndex = this.constants.addClass(this).index;
        }
        if (this.superClass == this) {
            this.setSuper((ClassType)null);
        }
        if (this.superClassIndex < 0) {
            this.superClassIndex = ((this.superClass == null) ? 0 : this.constants.addClass(this.superClass).index);
        }
        if (this.interfaces != null && this.interfaceIndexes == null) {
            final int n = this.interfaces.length;
            this.interfaceIndexes = new int[n];
            for (int i = 0; i < n; ++i) {
                this.interfaceIndexes[i] = this.constants.addClass(this.interfaces[i]).index;
            }
        }
        for (Field field = this.fields; field != null; field = field.next) {
            field.assign_constants(this);
        }
        for (Method method = this.methods; method != null; method = method.next) {
            method.assignConstants();
        }
        if (this.enclosingMember instanceof Method) {
            EnclosingMethodAttr attr = EnclosingMethodAttr.getFirstEnclosingMethod(this.getAttributes());
            if (attr == null) {
                attr = new EnclosingMethodAttr(this);
            }
            attr.method = (Method)this.enclosingMember;
        }
        else if (this.enclosingMember instanceof ClassType) {
            this.constants.addClass((ObjectType)this.enclosingMember);
        }
        for (ClassType member = this.firstInnerClass; member != null; member = member.nextInnerClass) {
            this.constants.addClass(member);
        }
        InnerClassesAttr innerAttr = InnerClassesAttr.getFirstInnerClasses(this.getAttributes());
        if (innerAttr != null) {
            innerAttr.setSkipped(true);
        }
        Attribute.assignConstants(this, this);
        for (int i = 1; i <= this.constants.count; ++i) {
            final CpoolEntry entry = this.constants.pool[i];
            if (entry instanceof CpoolClass) {
                final CpoolClass centry = (CpoolClass)entry;
                if (centry.clas instanceof ClassType) {
                    final ClassType ctype = (ClassType)centry.clas;
                    if (ctype.getEnclosingMember() != null) {
                        if (innerAttr == null) {
                            innerAttr = new InnerClassesAttr(this);
                        }
                        innerAttr.addClass(centry, this);
                    }
                }
            }
        }
        if (innerAttr != null) {
            innerAttr.setSkipped(false);
            innerAttr.assignConstants(this);
        }
    }
    
    public void writeToStream(final OutputStream stream) throws IOException {
        final DataOutputStream dstr = new DataOutputStream(stream);
        this.doFixups();
        dstr.writeInt(-889275714);
        dstr.writeShort(this.getClassfileMinorVersion());
        dstr.writeShort(this.getClassfileMajorVersion());
        if (this.constants == null) {
            dstr.writeShort(1);
        }
        else {
            this.constants.write(dstr);
        }
        dstr.writeShort(this.access_flags);
        dstr.writeShort(this.thisClassIndex);
        dstr.writeShort(this.superClassIndex);
        if (this.interfaceIndexes == null) {
            dstr.writeShort(0);
        }
        else {
            final int interfaces_count = this.interfaceIndexes.length;
            dstr.writeShort(interfaces_count);
            for (int i = 0; i < interfaces_count; ++i) {
                dstr.writeShort(this.interfaceIndexes[i]);
            }
        }
        dstr.writeShort(this.fields_count);
        for (Field field = this.fields; field != null; field = field.next) {
            field.write(dstr, this);
        }
        dstr.writeShort(this.methods_count);
        for (Method method = this.methods; method != null; method = method.next) {
            method.write(dstr, this);
        }
        Attribute.writeAll(this, dstr);
        this.flags |= 0xB;
    }
    
    public void writeToFile(final String filename) throws IOException {
        final OutputStream stream = new BufferedOutputStream(new FileOutputStream(filename));
        this.writeToStream(stream);
        stream.close();
    }
    
    public void writeToFile() throws IOException {
        this.writeToFile(this.this_name.replace('.', File.separatorChar) + ".class");
    }
    
    public byte[] writeToArray() {
        final ByteArrayOutputStream stream = new ByteArrayOutputStream(500);
        try {
            this.writeToStream(stream);
        }
        catch (IOException ex) {
            throw new InternalError(ex.toString());
        }
        return stream.toByteArray();
    }
    
    public static byte[] to_utf8(final String str) {
        if (str == null) {
            return null;
        }
        final int str_len = str.length();
        int utf_len = 0;
        for (int i = 0; i < str_len; ++i) {
            final int c = str.charAt(i);
            if (c > 0 && c <= 127) {
                ++utf_len;
            }
            else if (c <= 2047) {
                utf_len += 2;
            }
            else {
                utf_len += 3;
            }
        }
        final byte[] buffer = new byte[utf_len];
        int j = 0;
        for (int k = 0; k < str_len; ++k) {
            final int c2 = str.charAt(k);
            if (c2 > 0 && c2 <= 127) {
                buffer[j++] = (byte)c2;
            }
            else if (c2 <= 2047) {
                buffer[j++] = (byte)(0xC0 | (c2 >> 6 & 0x1F));
                buffer[j++] = (byte)(0x80 | (c2 >> 0 & 0x3F));
            }
            else {
                buffer[j++] = (byte)(0xE0 | (c2 >> 12 & 0xF));
                buffer[j++] = (byte)(0x80 | (c2 >> 6 & 0x3F));
                buffer[j++] = (byte)(0x80 | (c2 >> 0 & 0x3F));
            }
        }
        return buffer;
    }
    
    public final boolean implementsInterface(final ClassType iface) {
        if (this == iface) {
            return true;
        }
        final ClassType baseClass = this.getSuperclass();
        if (baseClass != null && baseClass.implementsInterface(iface)) {
            return true;
        }
        final ClassType[] interfaces = this.getInterfaces();
        if (interfaces != null) {
            int i = interfaces.length;
            while (--i >= 0) {
                if (interfaces[i].implementsInterface(iface)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public final boolean isSubclass(final String cname) {
        ClassType ctype = this;
        while (!cname.equals(ctype.getName())) {
            ctype = ctype.getSuperclass();
            if (ctype == null) {
                return false;
            }
        }
        return true;
    }
    
    public final boolean isSubclass(final ClassType other) {
        if (other.isInterface()) {
            return this.implementsInterface(other);
        }
        if (this == ClassType.javalangStringType && other == ClassType.toStringType) {
            return true;
        }
        if (other == Type.javalangObjectType) {
            return true;
        }
        for (ClassType baseClass = this; baseClass != null; baseClass = baseClass.getSuperclass()) {
            if (baseClass == other) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int isCompatibleWithValue(final Type valueType) {
        if (this == ClassType.objectType && valueType instanceof ObjectType) {
            return 2;
        }
        if (valueType == Type.nullType || Type.isSame(this, valueType)) {
            return 2;
        }
        if (this.isInterface()) {
            final Type rawType = valueType.getRawType();
            if (!(rawType instanceof ClassType)) {
                return -1;
            }
            if (rawType == ClassType.objectType) {
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
        else {
            final int comp = this.compare(valueType);
            if (comp >= 0) {
                return (valueType instanceof ObjectType) ? 2 : 1;
            }
            return (comp == -3) ? -1 : 0;
        }
    }
    
    @Override
    public int compare(final Type other) {
        if (other == ClassType.nullType) {
            return 1;
        }
        if (!(other instanceof ClassType)) {
            return Type.swappedCompareResult(other.compare(this));
        }
        final String name = this.getName();
        if (name != null && name.equals(other.getName())) {
            return 0;
        }
        final ClassType cother = (ClassType)other;
        if (this.isSubclass(cother)) {
            return -1;
        }
        if (cother.isSubclass(this)) {
            return 1;
        }
        if (this.isInterface()) {
            return (cother.isAnnotation() || cother.isFinal()) ? -3 : ((cother == Type.javalangObjectType) ? -1 : -2);
        }
        if (cother.isInterface()) {
            return (this.isAnnotation() || this.isFinal()) ? -3 : ((this == Type.javalangObjectType) ? 1 : -2);
        }
        return -3;
    }
    
    @Override
    public String toString() {
        return "ClassType " + this.getName();
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeUTF(this.getName());
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.setName(in.readUTF());
        this.flags |= 0x10;
    }
    
    public Object readResolve() throws ObjectStreamException {
        final String name = this.getName();
        final HashMap<String, Type> map = ClassType.mapNameToType;
        synchronized (map) {
            final Type found = map.get(name);
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
        final Method[] methods = this.getAbstractMethods();
        final int nmethods = methods.length;
        Method result = null;
        for (final Method meth : methods) {
            final String mname = meth.getName();
            final String sig = meth.getSignature();
            final Filter<Method> filter = new Filter<Method>() {
                @Override
                public boolean select(final Method m) {
                    return !m.isAbstract() && mname.equals(m.getName()) && sig.equals(m.getSignature());
                }
            };
            if (this.countMethods(filter, 2) <= 0) {
                if (result != null) {
                    return null;
                }
                result = meth;
            }
        }
        return result;
    }
    
    static {
        noClasses = new ClassType[0];
    }
    
    static class AbstractMethodFilter implements Filter
    {
        public static final AbstractMethodFilter instance;
        
        @Override
        public boolean select(final Object value) {
            final Method method = (Method)value;
            return method.isAbstract();
        }
        
        static {
            instance = new AbstractMethodFilter();
        }
    }
}
