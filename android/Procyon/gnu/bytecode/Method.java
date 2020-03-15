// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.lang.annotation.Annotation;
import java.util.Stack;
import java.io.IOException;
import java.io.DataOutputStream;
import java.lang.reflect.AccessibleObject;

public class Method implements AttrContainer, Member
{
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
    public final void setAttributes(final Attribute attributes) {
        this.attributes = attributes;
    }
    
    public final ExceptionsAttr getExceptionAttr() {
        return this.exceptions;
    }
    
    public void setExceptions(final short[] exn_indices) {
        if (this.exceptions == null) {
            this.exceptions = new ExceptionsAttr(this);
        }
        this.exceptions.setExceptions(exn_indices, this.classfile);
    }
    
    public void setExceptions(final ClassType[] exn_types) {
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
    
    static Method makeCloneMethod(final Type returnType) {
        final Method method = new Method();
        method.name = "clone";
        method.access_flags = 1;
        method.arg_types = Type.typeArray0;
        method.return_type = returnType;
        method.classfile = Type.objectType;
        return method;
    }
    
    public Method(final Method base, final ClassType clas) {
        this.arg_types = base.arg_types;
        this.return_type = base.return_type;
        this.name = base.name;
        this.access_flags = base.access_flags;
        this.classfile = clas;
    }
    
    Method(final ClassType clfile, final int flags) {
        if (clfile.last_method == null) {
            clfile.methods = this;
        }
        else {
            clfile.last_method.next = this;
        }
        clfile.last_method = this;
        ++clfile.methods_count;
        this.access_flags = flags;
        this.classfile = clfile;
    }
    
    public final void setStaticFlag(final boolean is_static) {
        if (is_static) {
            this.access_flags |= 0x8;
        }
        else {
            this.access_flags ^= 0xFFFFFFF7;
        }
    }
    
    @Override
    public final boolean getStaticFlag() {
        return (this.access_flags & 0x8) != 0x0;
    }
    
    public final boolean isAbstract() {
        return (this.access_flags & 0x400) != 0x0;
    }
    
    public final boolean isNative() {
        return (this.access_flags & 0x100) != 0x0;
    }
    
    @Override
    public int getModifiers() {
        return this.access_flags;
    }
    
    public void setModifiers(final int modifiers) {
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
    public void allocate_local(final Variable local) {
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
    
    @Deprecated
    public void init_param_slots() {
        this.startCode();
    }
    
    public CodeAttr startCode() {
        this.initCode();
        this.code.addParamLocals();
        return this.code;
    }
    
    void kill_local(final Variable var) {
        var.freeLocal(this.code);
    }
    
    void prepareCode(final int max_size) {
        if (this.code == null) {
            this.code = new CodeAttr(this);
        }
        this.code.reserve(max_size);
    }
    
    void instruction_start_hook(final int max_size) {
        this.prepareCode(max_size);
    }
    
    final Type pop_stack_type() {
        return this.code.popType();
    }
    
    final void push_stack_type(final Type type) {
        this.code.pushType(type);
    }
    
    public void compile_checkcast(final Type type) {
        this.code.emitCheckcast(type);
    }
    
    public void maybe_compile_checkcast(final Type type) {
        final Type stack_type = this.code.topType();
        if (type != stack_type) {
            this.code.emitCheckcast(type);
        }
    }
    
    @Deprecated
    public void push_var(final Variable var) {
        this.code.emitLoad(var);
    }
    
    @Deprecated
    public void compile_push_value(final Variable var) {
        this.code.emitLoad(var);
    }
    
    @Deprecated
    public void compile_store_value(final Variable var) {
        this.code.emitStore(var);
    }
    
    public void compile_push_this() {
        this.code.emitPushThis();
    }
    
    void write(final DataOutputStream dstr, final ClassType classfile) throws IOException {
        dstr.writeShort(this.access_flags);
        dstr.writeShort(this.name_index);
        dstr.writeShort(this.signature_index);
        Attribute.writeAll(this, dstr);
    }
    
    public static String makeSignature(final Type[] arg_types, final Type return_type) {
        final StringBuilder buf = new StringBuilder(100);
        final int args_count = arg_types.length;
        buf.append('(');
        for (int i = 0; i < args_count; ++i) {
            buf.append(arg_types[i].getSignature());
        }
        buf.append(')');
        buf.append(return_type.getSignature());
        return buf.toString();
    }
    
    public static String makeGenericSignature(final Type[] arg_types, final Type return_type) {
        final StringBuilder buf = new StringBuilder(100);
        final int args_count = arg_types.length;
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
            this.signature = makeSignature(this.arg_types, this.return_type);
        }
        return this.signature;
    }
    
    public void setSignature(final String signature) {
        final int len = signature.length();
        if (len < 3 || signature.charAt(0) != '(') {
            throw new ClassFormatError("bad method signature");
        }
        int pos = 1;
        final Stack<Type> types = new Stack<Type>();
        while (true) {
            final int arg_sig_len = Type.signatureLength(signature, pos);
            if (arg_sig_len < 0) {
                break;
            }
            final Type arg_type = Type.signatureToType(signature, pos, arg_sig_len);
            types.push(arg_type);
            pos += arg_sig_len;
        }
        if (pos < len && signature.charAt(pos) == ')') {
            this.arg_types = new Type[types.size()];
            int i = types.size();
            while (--i >= 0) {
                this.arg_types[i] = types.pop();
            }
            this.return_type = Type.signatureToType(signature, pos + 1, len - pos - 1);
            return;
        }
        throw new ClassFormatError("bad method signature");
    }
    
    public void setSignature(final int signature_index) {
        final CpoolUtf8 sigConstant = (CpoolUtf8)this.getConstants().getForced(signature_index, 1);
        this.signature_index = signature_index;
        this.setSignature(sigConstant.string);
    }
    
    public <T extends Annotation> T getAnnotation(final Class<T> clas) {
        final T ann = RuntimeAnnotationsAttr.getAnnotation(this, clas);
        if (ann != null) {
            return ann;
        }
        return (T)((this.rmethod == null) ? null : this.rmethod.getAnnotation(clas));
    }
    
    void assignConstants() {
        final ConstantPool constants = this.getConstants();
        if (this.name_index == 0 && this.name != null) {
            this.name_index = constants.addUtf8(this.name).index;
        }
        final String signature = this.getSignature();
        final String genericSignature = makeGenericSignature(this.arg_types, this.return_type);
        if (this.signature_index == 0) {
            this.signature_index = constants.addUtf8(signature).index;
        }
        if (genericSignature != null && !genericSignature.equals(signature)) {
            final SignatureAttr attr = new SignatureAttr(genericSignature);
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
    
    public final void setReturnType(final Type type) {
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
    public final void setName(final String name) {
        this.name = name;
    }
    
    public final void setName(final int name_index) {
        if (name_index <= 0) {
            this.name = null;
        }
        else {
            final CpoolUtf8 nameConstant = (CpoolUtf8)this.getConstants().getForced(name_index, 1);
            this.name = nameConstant.string;
        }
        this.name_index = name_index;
    }
    
    public final Method getNext() {
        return this.next;
    }
    
    public void listParameters(final StringBuffer sbuf) {
        final int args_count = this.arg_types.length;
        sbuf.append('(');
        for (int i = 0; i < args_count; ++i) {
            if (i > 0) {
                sbuf.append(',');
            }
            sbuf.append(this.arg_types[i].getName());
        }
        sbuf.append(')');
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer(100);
        final ClassType declaring = this.getDeclaringClass();
        sbuf.append((declaring != null) ? declaring.getName() : "???");
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
