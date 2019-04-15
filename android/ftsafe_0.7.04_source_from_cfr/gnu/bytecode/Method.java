/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolUtf8;
import gnu.bytecode.ExceptionsAttr;
import gnu.bytecode.Member;
import gnu.bytecode.RuntimeAnnotationsAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.SignatureAttr;
import gnu.bytecode.SourceDebugExtAttr;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.util.Stack;

public class Method
implements AttrContainer,
Member {
    private String name;
    Type[] arg_types;
    Type return_type;
    int access_flags;
    int name_index;
    int signature_index;
    Method next;
    ClassType classfile;
    CodeAttr code;
    AccessibleObject rmethod;
    Attribute attributes;
    ExceptionsAttr exceptions;
    String signature;

    @Override
    public final Attribute getAttributes() {
        return this.attributes;
    }

    @Override
    public final void setAttributes(Attribute attributes) {
        this.attributes = attributes;
    }

    public final ExceptionsAttr getExceptionAttr() {
        return this.exceptions;
    }

    public void setExceptions(short[] exn_indices) {
        if (this.exceptions == null) {
            this.exceptions = new ExceptionsAttr(this);
        }
        this.exceptions.setExceptions(exn_indices, this.classfile);
    }

    public void setExceptions(ClassType[] exn_types) {
        if (this.exceptions == null) {
            this.exceptions = new ExceptionsAttr(this);
        }
        this.exceptions.setExceptions(exn_types);
    }

    public final CodeAttr getCode() {
        return this.code;
    }

    private Method() {
    }

    static Method makeCloneMethod(Type returnType) {
        Method method = new Method();
        method.name = "clone";
        method.access_flags = 1;
        method.arg_types = Type.typeArray0;
        method.return_type = returnType;
        method.classfile = Type.objectType;
        return method;
    }

    public Method(Method base2, ClassType clas) {
        this.arg_types = base2.arg_types;
        this.return_type = base2.return_type;
        this.name = base2.name;
        this.access_flags = base2.access_flags;
        this.classfile = clas;
    }

    Method(ClassType clfile, int flags) {
        if (clfile.last_method == null) {
            clfile.methods = this;
        } else {
            clfile.last_method.next = this;
        }
        clfile.last_method = this;
        ++clfile.methods_count;
        this.access_flags = flags;
        this.classfile = clfile;
    }

    public final void setStaticFlag(boolean is_static) {
        this.access_flags = is_static ? (this.access_flags |= 8) : (this.access_flags ^= -9);
    }

    @Override
    public final boolean getStaticFlag() {
        return (this.access_flags & 8) != 0;
    }

    public final boolean isAbstract() {
        return (this.access_flags & 1024) != 0;
    }

    public final boolean isNative() {
        return (this.access_flags & 256) != 0;
    }

    @Override
    public int getModifiers() {
        return this.access_flags;
    }

    public void setModifiers(int modifiers) {
        this.access_flags = modifiers;
    }

    @Override
    public final ConstantPool getConstants() {
        return this.classfile.constants;
    }

    public Scope pushScope() {
        this.prepareCode(0);
        return this.code.pushScope();
    }

    public final boolean reachableHere() {
        return this.code.reachableHere();
    }

    public Scope popScope() {
        return this.code.popScope();
    }

    @Deprecated
    public void allocate_local(Variable local) {
        local.allocateLocal(this.code);
    }

    public void initCode() {
        if (this.classfile.constants == null) {
            this.classfile.constants = new ConstantPool();
        }
        this.prepareCode(0);
        this.code.sourceDbgExt = this.classfile.sourceDbgExt;
        this.code.noteParamTypes();
        this.code.pushScope();
    }

    public void init_param_slots() {
        this.startCode();
    }

    public CodeAttr startCode() {
        this.initCode();
        this.code.addParamLocals();
        return this.code;
    }

    void kill_local(Variable var) {
        var.freeLocal(this.code);
    }

    void prepareCode(int max_size) {
        if (this.code == null) {
            this.code = new CodeAttr(this);
        }
        this.code.reserve(max_size);
    }

    void instruction_start_hook(int max_size) {
        this.prepareCode(max_size);
    }

    final Type pop_stack_type() {
        return this.code.popType();
    }

    final void push_stack_type(Type type) {
        this.code.pushType(type);
    }

    public void compile_checkcast(Type type) {
        this.code.emitCheckcast(type);
    }

    public void maybe_compile_checkcast(Type type) {
        Type stack_type = this.code.topType();
        if (type != stack_type) {
            this.code.emitCheckcast(type);
        }
    }

    public void push_var(Variable var) {
        this.code.emitLoad(var);
    }

    @Deprecated
    public void compile_push_value(Variable var) {
        this.code.emitLoad(var);
    }

    @Deprecated
    public void compile_store_value(Variable var) {
        this.code.emitStore(var);
    }

    public void compile_push_this() {
        this.code.emitPushThis();
    }

    void write(DataOutputStream dstr, ClassType classfile) throws IOException {
        dstr.writeShort(this.access_flags);
        dstr.writeShort(this.name_index);
        dstr.writeShort(this.signature_index);
        Attribute.writeAll(this, dstr);
    }

    public static String makeSignature(Type[] arg_types, Type return_type) {
        StringBuilder buf = new StringBuilder(100);
        int args_count = arg_types.length;
        buf.append('(');
        for (int i = 0; i < args_count; ++i) {
            buf.append(arg_types[i].getSignature());
        }
        buf.append(')');
        buf.append(return_type.getSignature());
        return buf.toString();
    }

    public static String makeGenericSignature(Type[] arg_types, Type return_type) {
        StringBuilder buf = new StringBuilder(100);
        int args_count = arg_types.length;
        buf.append('(');
        for (int i = 0; i < args_count; ++i) {
            buf.append(arg_types[i].getMaybeGenericSignature());
        }
        buf.append(')');
        buf.append(return_type.getMaybeGenericSignature());
        return buf.toString();
    }

    public String getSignature() {
        if (this.signature == null) {
            this.signature = Method.makeSignature(this.arg_types, this.return_type);
        }
        return this.signature;
    }

    public void setSignature(String signature) {
        int len = signature.length();
        if (len < 3 || signature.charAt(0) != '(') {
            throw new ClassFormatError("bad method signature");
        }
        int pos = 1;
        Stack<Type> types = new Stack<Type>();
        do {
            int arg_sig_len;
            if ((arg_sig_len = Type.signatureLength(signature, pos)) < 0) {
                if (pos < len && signature.charAt(pos) == ')') break;
                throw new ClassFormatError("bad method signature");
            }
            Type arg_type = Type.signatureToType(signature, pos, arg_sig_len);
            types.push(arg_type);
            pos += arg_sig_len;
        } while (true);
        this.arg_types = new Type[types.size()];
        int i = types.size();
        while (--i >= 0) {
            this.arg_types[i] = (Type)types.pop();
        }
        this.return_type = Type.signatureToType(signature, pos + 1, len - pos - 1);
    }

    public void setSignature(int signature_index) {
        CpoolUtf8 sigConstant = (CpoolUtf8)this.getConstants().getForced(signature_index, 1);
        this.signature_index = signature_index;
        this.setSignature(sigConstant.string);
    }

    public <T extends Annotation> T getAnnotation(Class<T> clas) {
        T ann = RuntimeAnnotationsAttr.getAnnotation(this, clas);
        if (ann != null) {
            return ann;
        }
        return this.rmethod == null ? null : (T)this.rmethod.getAnnotation(clas);
    }

    void assignConstants() {
        ConstantPool constants = this.getConstants();
        if (this.name_index == 0 && this.name != null) {
            this.name_index = constants.addUtf8((String)this.name).index;
        }
        String signature = this.getSignature();
        String genericSignature = Method.makeGenericSignature(this.arg_types, this.return_type);
        if (this.signature_index == 0) {
            this.signature_index = constants.addUtf8((String)signature).index;
        }
        if (genericSignature != null && !genericSignature.equals(signature)) {
            SignatureAttr attr = new SignatureAttr(genericSignature);
            attr.addToFrontOf(this);
        }
        Attribute.assignConstants(this, this.classfile);
    }

    @Override
    public ClassType getDeclaringClass() {
        return this.classfile;
    }

    public final Type getReturnType() {
        return this.return_type;
    }

    public final void setReturnType(Type type) {
        this.return_type = type;
    }

    public final Type[] getParameterTypes() {
        return this.arg_types;
    }

    public final ClassType[] getExceptions() {
        if (this.exceptions == null) {
            return null;
        }
        return this.exceptions.getExceptions();
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final void setName(String name) {
        this.name = name;
    }

    public final void setName(int name_index) {
        if (name_index <= 0) {
            this.name = null;
        } else {
            CpoolUtf8 nameConstant = (CpoolUtf8)this.getConstants().getForced(name_index, 1);
            this.name = nameConstant.string;
        }
        this.name_index = name_index;
    }

    public final Method getNext() {
        return this.next;
    }

    public void listParameters(StringBuffer sbuf) {
        int args_count = this.arg_types.length;
        sbuf.append('(');
        for (int i = 0; i < args_count; ++i) {
            if (i > 0) {
                sbuf.append(',');
            }
            sbuf.append(this.arg_types[i].getName());
        }
        sbuf.append(')');
    }

    public String toString() {
        StringBuffer sbuf = new StringBuffer(100);
        ClassType declaring = this.getDeclaringClass();
        sbuf.append(declaring != null ? declaring.getName() : "???");
        sbuf.append('.');
        sbuf.append(this.name);
        if (this.arg_types != null) {
            this.listParameters(sbuf);
            sbuf.append(this.return_type.getName());
        }
        return sbuf.toString();
    }

    public void cleanupAfterCompilation() {
        this.attributes = null;
        this.exceptions = null;
        this.code = null;
    }
}

