/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ArrayType;
import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolClass;
import gnu.bytecode.CpoolEntry;
import gnu.bytecode.CpoolMethodHandle;
import gnu.bytecode.CpoolRef;
import gnu.bytecode.CpoolString;
import gnu.bytecode.CpoolValue1;
import gnu.bytecode.CpoolValue2;
import gnu.bytecode.ExitableBlock;
import gnu.bytecode.Field;
import gnu.bytecode.IfState;
import gnu.bytecode.Label;
import gnu.bytecode.LineNumbersAttr;
import gnu.bytecode.LocalVarsAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.SourceDebugExtAttr;
import gnu.bytecode.StackMapTableAttr;
import gnu.bytecode.SwitchState;
import gnu.bytecode.TryState;
import gnu.bytecode.Type;
import gnu.bytecode.UninitializedType;
import gnu.bytecode.Variable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

public class CodeAttr
extends Attribute
implements AttrContainer {
    Attribute attributes;
    LineNumbersAttr lines;
    public LocalVarsAttr locals;
    public StackMapTableAttr stackMap;
    SourceDebugExtAttr sourceDbgExt;
    public static final int GENERATE_STACK_MAP_TABLE = 1;
    public static final int DONT_USE_JSR = 2;
    int flags;
    public Type[] stack_types;
    Type[] local_types = new Type[20];
    Label previousLabel;
    boolean[] varsSetInCurrentBlock;
    int SP;
    private int max_stack;
    private int max_locals;
    int PC;
    byte[] code;
    short[] exception_table;
    int exception_table_length;
    static final int FIXUP_DEFINE = 0;
    static final int FIXUP_DEFINE_UNREACHABLE = 1;
    static final int FIXUP_SWITCH = 2;
    static final int FIXUP_CASE = 3;
    static final int FIXUP_GOTO = 4;
    static final int FIXUP_JSR = 5;
    static final int FIXUP_TRANSFER = 6;
    static final int FIXUP_TRANSFER2 = 7;
    static final int FIXUP_DELETE3 = 8;
    static final int FIXUP_MOVE = 9;
    static final int FIXUP_MOVE_TO_END = 10;
    static final int FIXUP_TRY = 11;
    static final int FIXUP_TRY_END = 12;
    static final int FIXUP_TRY_HANDLER = 13;
    static final int FIXUP_LINE_PC = 14;
    static final int FIXUP_LINE_NUMBER = 15;
    int[] fixup_offsets;
    Label[] fixup_labels;
    int fixup_count;
    public static boolean instructionLineMode = false;
    IfState if_stack;
    TryState try_stack;
    private boolean unreachable_here;
    ExitableBlock currentExitableBlock;
    int exitableBlockLevel;

    @Override
    public final Attribute getAttributes() {
        return this.attributes;
    }

    @Override
    public final void setAttributes(Attribute attributes) {
        this.attributes = attributes;
    }

    boolean useJsr() {
        return (this.flags & 2) == 0;
    }

    public final void fixupChain(Label here, Label target) {
        this.fixupAdd(9, -1, target);
        here.defineRaw(this);
        this.setPreviousLabelHere(here);
    }

    public final void fixupAdd(int kind, Label label) {
        this.fixupAdd(kind, this.PC, label);
    }

    final void fixupAdd(int kind, int offset, Label label) {
        int count;
        if (label != null && kind != 0 && kind != 1 && kind != 2 && kind != 11) {
            label.needsStackMapEntry = true;
        }
        if ((count = this.fixup_count) == 0) {
            this.fixup_offsets = new int[30];
            this.fixup_labels = new Label[30];
        } else if (this.fixup_count == this.fixup_offsets.length) {
            int new_length = 2 * count;
            Label[] new_labels = new Label[new_length];
            System.arraycopy(this.fixup_labels, 0, new_labels, 0, count);
            this.fixup_labels = new_labels;
            int[] new_offsets = new int[new_length];
            System.arraycopy(this.fixup_offsets, 0, new_offsets, 0, count);
            this.fixup_offsets = new_offsets;
        }
        this.fixupSet(count, kind, offset);
        this.fixup_labels[count] = label;
        this.fixup_count = count + 1;
    }

    private final int fixupOffset(int index) {
        return this.fixup_offsets[index] >> 4;
    }

    private final int fixupKind(int index) {
        return this.fixup_offsets[index] & 15;
    }

    private void fixupSet(int index, int kind, int offset) {
        this.fixup_offsets[index] = this.fixupEncode(kind, offset);
    }

    private int fixupEncode(int kind, int offset) {
        return offset << 4 | kind;
    }

    public final Method getMethod() {
        return (Method)this.getContainer();
    }

    public final int getPC() {
        return this.PC;
    }

    public final int getSP() {
        return this.SP;
    }

    @Override
    public final ConstantPool getConstants() {
        return this.getMethod().classfile.constants;
    }

    public final boolean reachableHere() {
        return !this.unreachable_here;
    }

    public final void setReachable(boolean val) {
        this.unreachable_here = !val;
    }

    public final void setUnreachable() {
        this.unreachable_here = true;
    }

    public int getMaxStack() {
        return this.max_stack;
    }

    public int getMaxLocals() {
        return this.max_locals;
    }

    public void setMaxStack(int n) {
        this.max_stack = n;
    }

    public void setMaxLocals(int n) {
        this.max_locals = n;
    }

    public byte[] getCode() {
        return this.code;
    }

    public void setCode(byte[] code) {
        this.code = code;
        this.PC = code.length;
    }

    public void setCodeLength(int len) {
        this.PC = len;
    }

    public int getCodeLength() {
        return this.PC;
    }

    public CodeAttr(Method meth) {
        super("Code");
        this.addToFrontOf(meth);
        meth.code = this;
        if (meth.getDeclaringClass().getClassfileMajorVersion() >= 50) {
            this.flags |= 3;
        }
    }

    public final void reserve(int bytes) {
        if (this.code == null) {
            this.code = new byte[100 + bytes];
        } else if (this.PC + bytes > this.code.length) {
            byte[] new_code = new byte[2 * this.code.length + bytes];
            System.arraycopy(this.code, 0, new_code, 0, this.PC);
            this.code = new_code;
        }
    }

    byte invert_opcode(byte opcode) {
        int iopcode = opcode & 255;
        if (iopcode >= 153 && iopcode <= 166 || iopcode >= 198 && iopcode <= 199) {
            return (byte)(iopcode ^ 1);
        }
        throw new Error("unknown opcode to invert_opcode");
    }

    public final void put1(int i) {
        this.code[this.PC++] = (byte)i;
        this.unreachable_here = false;
    }

    public final void put2(int i) {
        this.code[this.PC++] = (byte)(i >> 8);
        this.code[this.PC++] = (byte)i;
        this.unreachable_here = false;
    }

    public final void put4(int i) {
        this.code[this.PC++] = (byte)(i >> 24);
        this.code[this.PC++] = (byte)(i >> 16);
        this.code[this.PC++] = (byte)(i >> 8);
        this.code[this.PC++] = (byte)i;
        this.unreachable_here = false;
    }

    public final void putIndex2(CpoolEntry cnst) {
        this.put2(cnst.index);
    }

    public final void putLineNumber(String filename, int linenumber) {
        if (filename != null) {
            this.getMethod().classfile.setSourceFile(filename);
        }
        this.putLineNumber(linenumber);
    }

    public final void putLineNumber(int linenumber) {
        if (this.sourceDbgExt != null) {
            linenumber = this.sourceDbgExt.fixLine(linenumber);
        }
        this.fixupAdd(14, null);
        this.fixupAdd(15, linenumber, null);
    }

    void noteParamTypes() {
        Method method = this.getMethod();
        int offset = 0;
        if ((method.access_flags & 8) == 0) {
            ObjectType type = method.classfile;
            if ("<init>".equals(method.getName()) && !"java.lang.Object".equals(type.getName())) {
                type = UninitializedType.uninitializedThis(type);
            }
            this.noteVarType(offset++, type);
        }
        for (Type type : method.arg_types) {
            this.noteVarType(offset++, type);
            int size = type.getSizeInWords();
            while (--size > 0) {
                ++offset;
            }
        }
        if ((this.flags & 1) != 0) {
            this.stackMap = new StackMapTableAttr();
            int[] encodedLocals = new int[20 + offset];
            int count = 0;
            for (int i = 0; i < offset; ++i) {
                int encoded = this.stackMap.encodeVerificationType(this.local_types[i], this);
                encodedLocals[count++] = encoded;
                int tag = encoded & 255;
                if (tag != 3 && tag != 4) continue;
                ++i;
            }
            this.stackMap.encodedLocals = encodedLocals;
            this.stackMap.countLocals = count;
            this.stackMap.encodedStack = new int[10];
            this.stackMap.countStack = 0;
        }
    }

    void setPreviousLabelHere(Label here) {
        this.previousLabel = here;
        boolean[] varsSet = this.varsSetInCurrentBlock;
        if (varsSet != null) {
            int i = varsSet.length;
            while (--i >= 0) {
                varsSet[i] = false;
            }
        }
    }

    public void noteVarType(int offset, Type type) {
        Type prev;
        int size = type.getSizeInWords();
        if (this.local_types == null) {
            this.local_types = new Type[offset + size + 20];
        } else if (offset + size > this.local_types.length) {
            Type[] new_array = new Type[2 * (offset + size)];
            System.arraycopy(this.local_types, 0, new_array, 0, this.local_types.length);
            this.local_types = new_array;
        }
        this.local_types[offset] = type;
        if (this.varsSetInCurrentBlock == null) {
            this.varsSetInCurrentBlock = new boolean[this.local_types.length];
        } else if (this.varsSetInCurrentBlock.length <= offset) {
            boolean[] tmp = new boolean[this.local_types.length];
            System.arraycopy(this.varsSetInCurrentBlock, 0, tmp, 0, this.varsSetInCurrentBlock.length);
            this.varsSetInCurrentBlock = tmp;
        }
        this.varsSetInCurrentBlock[offset] = true;
        if (offset > 0 && (prev = this.local_types[offset - 1]) != null && prev.getSizeInWords() == 2) {
            this.local_types[offset - 1] = null;
        }
        while (--size > 0) {
            this.local_types[++offset] = null;
        }
    }

    public final void setTypes(Label label) {
        this.setTypes(label.localTypes, label.stackTypes);
    }

    public final void setTypes(Type[] labelLocals, Type[] labelStack) {
        int i;
        int usedStack = labelStack.length;
        int usedLocals = labelLocals.length;
        if (this.local_types != null) {
            if (usedLocals > 0) {
                System.arraycopy(labelLocals, 0, this.local_types, 0, usedLocals);
            }
            for (i = usedLocals; i < this.local_types.length; ++i) {
                this.local_types[i] = null;
            }
        }
        if (this.stack_types == null || usedStack > this.stack_types.length) {
            this.stack_types = new Type[usedStack];
        } else {
            for (i = usedStack; i < this.stack_types.length; ++i) {
                this.stack_types[i] = null;
            }
        }
        System.arraycopy(labelStack, 0, this.stack_types, 0, usedStack);
        this.SP = usedStack;
    }

    public final void pushType(Type type) {
        if (type.size == 0) {
            throw new Error("pushing void type onto stack");
        }
        if (this.stack_types == null || this.stack_types.length == 0) {
            this.stack_types = new Type[20];
        } else if (this.SP + 1 >= this.stack_types.length) {
            Type[] new_array = new Type[2 * this.stack_types.length];
            System.arraycopy(this.stack_types, 0, new_array, 0, this.SP);
            this.stack_types = new_array;
        }
        if (type.size == 8) {
            this.stack_types[this.SP++] = Type.voidType;
        }
        this.stack_types[this.SP++] = type;
        if (this.SP > this.max_stack) {
            this.max_stack = this.SP;
        }
    }

    public final Type popType() {
        if (this.SP <= 0) {
            throw new Error("popType called with empty stack " + this.getMethod());
        }
        Type type = this.stack_types[--this.SP];
        if (type.size == 8 && !this.popType().isVoid()) {
            throw new Error("missing void type on stack");
        }
        return type;
    }

    public final Type topType() {
        return this.stack_types[this.SP - 1];
    }

    public void emitPop(int nvalues) {
        while (nvalues > 0) {
            this.reserve(1);
            Type type = this.popType();
            if (type.size > 4) {
                this.put1(88);
            } else if (nvalues > 1) {
                Type type2 = this.popType();
                if (type2.size > 4) {
                    this.put1(87);
                    this.reserve(1);
                }
                this.put1(88);
                --nvalues;
            } else {
                this.put1(87);
            }
            --nvalues;
        }
    }

    public Label getLabel() {
        Label label = new Label();
        label.defineRaw(this);
        return label;
    }

    public void emitSwap() {
        this.reserve(1);
        Type type1 = this.popType();
        Type type2 = this.popType();
        if (type1.size > 4 || type2.size > 4) {
            this.pushType(type2);
            this.pushType(type1);
            this.emitDupX();
            this.emitPop(1);
        } else {
            this.pushType(type1);
            this.put1(95);
            this.pushType(type2);
        }
    }

    public void emitDup() {
        this.reserve(1);
        Type type = this.topType();
        this.put1(type.size <= 4 ? 89 : 92);
        this.pushType(type);
    }

    public void emitDupX() {
        this.reserve(1);
        Type type = this.popType();
        Type skipedType = this.popType();
        if (skipedType.size <= 4) {
            this.put1(type.size <= 4 ? 90 : 93);
        } else {
            this.put1(type.size <= 4 ? 91 : 94);
        }
        this.pushType(type);
        this.pushType(skipedType);
        this.pushType(type);
    }

    public void emitDup(int size, int offset) {
        int kind;
        if (size == 0) {
            return;
        }
        this.reserve(1);
        Type copied1 = this.popType();
        Type copied2 = null;
        if (size == 1) {
            if (copied1.size > 4) {
                throw new Error("using dup for 2-word type");
            }
        } else {
            if (size != 2) {
                throw new Error("invalid size to emitDup");
            }
            if (copied1.size <= 4) {
                copied2 = this.popType();
                if (copied2.size > 4) {
                    throw new Error("dup will cause invalid types on stack");
                }
            }
        }
        Type skipped1 = null;
        Type skipped2 = null;
        if (offset == 0) {
            kind = size == 1 ? 89 : 92;
        } else if (offset == 1) {
            kind = size == 1 ? 90 : 93;
            skipped1 = this.popType();
            if (skipped1.size > 4) {
                throw new Error("dup will cause invalid types on stack");
            }
        } else if (offset == 2) {
            kind = size == 1 ? 91 : 94;
            skipped1 = this.popType();
            if (skipped1.size <= 4) {
                skipped2 = this.popType();
                if (skipped2.size > 4) {
                    throw new Error("dup will cause invalid types on stack");
                }
            }
        } else {
            throw new Error("emitDup:  invalid offset");
        }
        this.put1(kind);
        if (copied2 != null) {
            this.pushType(copied2);
        }
        this.pushType(copied1);
        if (skipped2 != null) {
            this.pushType(skipped2);
        }
        if (skipped1 != null) {
            this.pushType(skipped1);
        }
        if (copied2 != null) {
            this.pushType(copied2);
        }
        this.pushType(copied1);
    }

    public void emitDup(int size) {
        this.emitDup(size, 0);
    }

    public void emitDup(Type type) {
        this.emitDup(type.size > 4 ? 2 : 1, 0);
    }

    public void enterScope(Scope scope) {
        scope.setStartPC(this);
        this.locals.enterScope(scope);
    }

    public Scope pushScope() {
        Scope scope = new Scope();
        if (this.locals == null) {
            this.locals = new LocalVarsAttr(this.getMethod());
        }
        this.enterScope(scope);
        if (this.locals.parameter_scope == null) {
            this.locals.parameter_scope = scope;
        }
        return scope;
    }

    public Scope pushAutoPoppableScope() {
        Scope scope = this.pushScope();
        scope.autoPop = true;
        return scope;
    }

    public Scope getCurrentScope() {
        return this.locals.current_scope;
    }

    public Scope popScope() {
        Scope scope;
        Label end = this.getLabel();
        do {
            scope = this.locals.current_scope;
            this.locals.current_scope = scope.parent;
            scope.freeLocals(this);
            scope.end = end;
        } while (scope.autoPop);
        return scope;
    }

    public Variable getArg(int index) {
        return this.locals.parameter_scope.getVariable(index);
    }

    public Variable lookup(String name) {
        Scope scope = this.locals.current_scope;
        while (scope != null) {
            Variable var = scope.lookup(name);
            if (var != null) {
                return var;
            }
            scope = scope.parent;
        }
        return null;
    }

    public Variable addLocal(Type type) {
        return this.locals.current_scope.addVariable(this, type, null);
    }

    public Variable addLocal(Type type, String name) {
        return this.locals.current_scope.addVariable(this, type, name);
    }

    public void addParamLocals() {
        Method method = this.getMethod();
        if ((method.access_flags & 8) == 0) {
            this.addLocal(method.classfile).setParameter(true);
        }
        int arg_count = method.arg_types.length;
        for (int i = 0; i < arg_count; ++i) {
            this.addLocal(method.arg_types[i]).setParameter(true);
        }
    }

    public final void emitPushConstant(int val, Type type) {
        switch (type.getSignature().charAt(0)) {
            case 'B': 
            case 'C': 
            case 'I': 
            case 'S': 
            case 'Z': {
                this.emitPushInt(val);
                break;
            }
            case 'J': {
                this.emitPushLong(val);
                break;
            }
            case 'F': {
                this.emitPushFloat(val);
                break;
            }
            case 'D': {
                this.emitPushDouble(val);
                break;
            }
            default: {
                throw new Error("bad type to emitPushConstant");
            }
        }
    }

    public final void emitPushConstant(CpoolEntry cnst) {
        this.reserve(3);
        int index = cnst.index;
        if (cnst instanceof CpoolValue2) {
            this.put1(20);
            this.put2(index);
        } else if (index < 256) {
            this.put1(18);
            this.put1(index);
        } else {
            this.put1(19);
            this.put2(index);
        }
    }

    public final void emitPushInt(int i) {
        this.reserve(3);
        if (i >= -1 && i <= 5) {
            this.put1(i + 3);
        } else if (i >= -128 && i < 128) {
            this.put1(16);
            this.put1(i);
        } else if (i >= -32768 && i < 32768) {
            this.put1(17);
            this.put2(i);
        } else {
            this.emitPushConstant(this.getConstants().addInt(i));
        }
        this.pushType(Type.intType);
    }

    public void emitPushLong(long i) {
        if (i == 0L || i == 1L) {
            this.reserve(1);
            this.put1(9 + (int)i);
        } else if ((long)((int)i) == i) {
            this.emitPushInt((int)i);
            this.reserve(1);
            this.popType();
            this.put1(133);
        } else {
            this.emitPushConstant(this.getConstants().addLong(i));
        }
        this.pushType(Type.longType);
    }

    public void emitPushFloat(float x) {
        int xi = (int)x;
        if ((float)xi == x && xi >= -128 && xi < 128) {
            if (xi >= 0 && xi <= 2) {
                this.reserve(1);
                this.put1(11 + xi);
                if (xi == 0 && Float.floatToIntBits(x) != 0) {
                    this.reserve(1);
                    this.put1(118);
                }
            } else {
                this.emitPushInt(xi);
                this.reserve(1);
                this.popType();
                this.put1(134);
            }
        } else {
            this.emitPushConstant(this.getConstants().addFloat(x));
        }
        this.pushType(Type.floatType);
    }

    public void emitPushDouble(double x) {
        int xi = (int)x;
        if ((double)xi == x && xi >= -128 && xi < 128) {
            if (xi == 0 || xi == 1) {
                this.reserve(1);
                this.put1(14 + xi);
                if (xi == 0 && Double.doubleToLongBits(x) != 0L) {
                    this.reserve(1);
                    this.put1(119);
                }
            } else {
                this.emitPushInt(xi);
                this.reserve(1);
                this.popType();
                this.put1(135);
            }
        } else {
            this.emitPushConstant(this.getConstants().addDouble(x));
        }
        this.pushType(Type.doubleType);
    }

    public static final String calculateSplit(String str) {
        int strLength = str.length();
        StringBuffer sbuf = new StringBuffer(20);
        int segmentStart = 0;
        int byteLength = 0;
        for (int i = 0; i < strLength; ++i) {
            int bytes;
            char ch = str.charAt(i);
            int n = ch >= '\u0800' ? 3 : (bytes = ch >= '' || ch == '\u0000' ? 2 : 1);
            if (byteLength + bytes > 65535) {
                sbuf.append((char)(i - segmentStart));
                segmentStart = i;
                byteLength = 0;
            }
            byteLength += bytes;
        }
        sbuf.append((char)(strLength - segmentStart));
        return sbuf.toString();
    }

    public final void emitPushString(String str) {
        if (str == null) {
            this.emitPushNull();
        } else {
            int length = str.length();
            String segments = CodeAttr.calculateSplit(str);
            int numSegments = segments.length();
            if (numSegments > 1) {
                if (numSegments == 2) {
                    char firstSegment = segments.charAt(0);
                    this.emitPushString(str.substring(0, firstSegment));
                    this.emitPushString(str.substring(firstSegment));
                    Method concatMethod = Type.javalangStringType.getDeclaredMethod("concat", 1);
                    this.emitInvokeVirtual(concatMethod);
                } else {
                    ClassType sbufType = ClassType.make("java.lang.StringBuffer");
                    this.emitNew(sbufType);
                    this.emitDup(sbufType);
                    this.emitPushInt(length);
                    Type[] args1 = new Type[]{Type.intType};
                    this.emitInvokeSpecial(sbufType.getDeclaredMethod("<init>", args1));
                    Type[] args2 = new Type[]{Type.javalangStringType};
                    Method appendMethod = sbufType.getDeclaredMethod("append", args2);
                    int segStart = 0;
                    for (int seg = 0; seg < numSegments; ++seg) {
                        this.emitDup(sbufType);
                        int segEnd = segStart + segments.charAt(seg);
                        this.emitPushString(str.substring(segStart, segEnd));
                        this.emitInvokeVirtual(appendMethod);
                        segStart = segEnd;
                    }
                    this.emitInvokeVirtual(Type.toString_method);
                }
                if (str == str.intern()) {
                    this.emitInvokeVirtual(Type.javalangStringType.getDeclaredMethod("intern", 0));
                }
                return;
            }
            this.emitPushConstant(this.getConstants().addString(str));
            this.pushType(Type.javalangStringType);
        }
    }

    public final void emitPushClass(ObjectType ctype) {
        this.emitPushConstant(this.getConstants().addClass(ctype));
        this.pushType(Type.javalangClassType);
    }

    public final void emitPushMethodHandle(Method method) {
        this.emitPushConstant(this.getConstants().addMethodHandle(method));
        this.pushType(Type.javalanginvokeMethodHandleType);
    }

    public void emitPushNull() {
        this.emitPushNull(Type.nullType);
    }

    public void emitPushNull(ObjectType type) {
        this.reserve(1);
        this.put1(1);
        this.pushType(type);
    }

    public void emitPushDefaultValue(Type type) {
        if ((type = type.getImplementationType()) instanceof PrimType) {
            this.emitPushConstant(0, type);
        } else {
            this.emitPushNull();
        }
    }

    public void emitStoreDefaultValue(Variable var) {
        this.emitPushDefaultValue(var.getType());
        this.emitStore(var);
    }

    public final void emitPushThis() {
        this.emitLoad(this.locals.used[0]);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void emitPushPrimArray(Object value, ArrayType arrayType) {
        elementType = arrayType.getComponentType();
        len = Array.getLength(value);
        this.emitPushInt(len);
        this.emitNewArray(elementType);
        sig = elementType.getSignature().charAt(0);
        i = 0;
        while (i < len) {
            block17 : {
                ival = 0L;
                fval = 0.0f;
                dval = 0.0;
                switch (sig) {
                    case 'J': {
                        ival = ((long[])value)[i];
                        if (ival != 0L) break;
                        ** break;
                    }
                    case 'I': {
                        ival = ((int[])value)[i];
                        if (ival != 0L) break;
                        ** break;
                    }
                    case 'S': {
                        ival = ((short[])value)[i];
                        if (ival != 0L) break;
                        ** break;
                    }
                    case 'C': {
                        ival = ((char[])value)[i];
                        if (ival != 0L) break;
                        ** break;
                    }
                    case 'B': {
                        ival = ((byte[])value)[i];
                        if (ival != 0L) break;
                        ** break;
                    }
                    case 'Z': {
                        v0 = ival = ((boolean[])value)[i] != false ? 1L : 0L;
                        if (ival != 0L) break;
                        ** break;
                    }
                    case 'F': {
                        fval = ((float[])value)[i];
                        if ((double)fval != 0.0) break;
                        ** break;
                    }
                    case 'D': {
                        dval = ((double[])value)[i];
                        if (dval == 0.0) break block17;
                    }
                }
                this.emitDup(arrayType);
                this.emitPushInt(i);
                switch (sig) {
                    case 'B': 
                    case 'C': 
                    case 'I': 
                    case 'S': 
                    case 'Z': {
                        this.emitPushInt((int)ival);
                        break;
                    }
                    case 'J': {
                        this.emitPushLong(ival);
                        break;
                    }
                    case 'F': {
                        this.emitPushFloat(fval);
                        break;
                    }
                    case 'D': {
                        this.emitPushDouble(dval);
                    }
                }
                this.emitArrayStore(elementType);
            }
            ++i;
        }
    }

    void emitNewArray(int type_code) {
        this.reserve(2);
        this.put1(188);
        this.put1(type_code);
    }

    public final void emitArrayLength() {
        if (!(this.popType() instanceof ArrayType)) {
            throw new Error("non-array type in emitArrayLength");
        }
        this.reserve(1);
        this.put1(190);
        this.pushType(Type.intType);
    }

    private int adjustTypedOp(char sig) {
        switch (sig) {
            case 'I': {
                return 0;
            }
            case 'J': {
                return 1;
            }
            case 'F': {
                return 2;
            }
            case 'D': {
                return 3;
            }
            default: {
                return 4;
            }
            case 'B': 
            case 'Z': {
                return 5;
            }
            case 'C': {
                return 6;
            }
            case 'S': 
        }
        return 7;
    }

    private int adjustTypedOp(Type type) {
        return this.adjustTypedOp(type.getSignature().charAt(0));
    }

    private void emitTypedOp(int op, Type type) {
        this.reserve(1);
        this.put1(op + this.adjustTypedOp(type));
    }

    private void emitTypedOp(int op, char sig) {
        this.reserve(1);
        this.put1(op + this.adjustTypedOp(sig));
    }

    public void emitArrayStore(Type element_type) {
        this.popType();
        this.popType();
        this.popType();
        this.emitTypedOp(79, element_type);
    }

    public void emitArrayStore() {
        this.popType();
        this.popType();
        Type arrayType = this.popType().getImplementationType();
        Type elementType = ((ArrayType)arrayType).getComponentType();
        this.emitTypedOp(79, elementType);
    }

    public void emitArrayLoad(Type element_type) {
        this.popType();
        this.popType();
        this.emitTypedOp(46, element_type);
        this.pushType(element_type);
    }

    public void emitArrayLoad() {
        this.popType();
        Type arrayType = this.popType().getImplementationType();
        Type elementType = ((ArrayType)arrayType).getComponentType();
        this.emitTypedOp(46, elementType);
        this.pushType(elementType);
    }

    public void emitNew(ClassType type) {
        this.reserve(3);
        Label label = new Label(this);
        label.defineRaw(this);
        this.put1(187);
        this.putIndex2(this.getConstants().addClass(type));
        this.pushType(new UninitializedType(type, label));
    }

    public void emitNewArray(Type element_type, int dims) {
        if (this.popType().promote() != Type.intType) {
            throw new Error("non-int dim. spec. in emitNewArray");
        }
        if (element_type instanceof PrimType) {
            int code;
            switch (element_type.getSignature().charAt(0)) {
                case 'B': {
                    code = 8;
                    break;
                }
                case 'S': {
                    code = 9;
                    break;
                }
                case 'I': {
                    code = 10;
                    break;
                }
                case 'J': {
                    code = 11;
                    break;
                }
                case 'F': {
                    code = 6;
                    break;
                }
                case 'D': {
                    code = 7;
                    break;
                }
                case 'Z': {
                    code = 4;
                    break;
                }
                case 'C': {
                    code = 5;
                    break;
                }
                default: {
                    throw new Error("bad PrimType in emitNewArray");
                }
            }
            this.emitNewArray(code);
        } else if (element_type instanceof ArrayType && dims > 1) {
            this.reserve(4);
            this.put1(197);
            this.putIndex2(this.getConstants().addClass(new ArrayType(element_type)));
            if (dims < 1 || dims > 255) {
                throw new Error("dims out of range in emitNewArray");
            }
            this.put1(dims);
            while (--dims > 0) {
                if (this.popType().promote() == Type.intType) continue;
                throw new Error("non-int dim. spec. in emitNewArray");
            }
        } else if (element_type instanceof ObjectType) {
            this.reserve(3);
            this.put1(189);
            this.putIndex2(this.getConstants().addClass((ObjectType)element_type));
        } else {
            throw new Error("unimplemented type in emitNewArray");
        }
        this.pushType(new ArrayType(element_type));
    }

    public void emitNewArray(Type element_type) {
        this.emitNewArray(element_type, 1);
    }

    private void emitBinop(int base_code) {
        Type type2 = this.popType().promote();
        Type type1_raw = this.popType();
        Type type1 = type1_raw.promote();
        if (type1 != type2 || !(type1 instanceof PrimType)) {
            throw new Error("non-matching or bad types in binary operation");
        }
        this.emitTypedOp(base_code, type1);
        this.pushType(type1_raw);
    }

    private void emitBinop(int base_code, char sig) {
        this.popType();
        this.popType();
        this.emitTypedOp(base_code, sig);
        this.pushType(Type.signatureToPrimitive(sig));
    }

    public void emitBinop(int base_code, Type type) {
        this.popType();
        this.popType();
        this.emitTypedOp(base_code, type);
        this.pushType(type);
    }

    public final void emitAdd(char sig) {
        this.emitBinop(96, sig);
    }

    public final void emitAdd(PrimType type) {
        this.emitBinop(96, type);
    }

    @Deprecated
    public final void emitAdd() {
        this.emitBinop(96);
    }

    public final void emitSub(char sig) {
        this.emitBinop(100, sig);
    }

    public final void emitSub(PrimType type) {
        this.emitBinop(100, type);
    }

    @Deprecated
    public final void emitSub() {
        this.emitBinop(100);
    }

    public final void emitMul() {
        this.emitBinop(104);
    }

    public final void emitDiv() {
        this.emitBinop(108);
    }

    public final void emitRem() {
        this.emitBinop(112);
    }

    public final void emitAnd() {
        this.emitBinop(126);
    }

    public final void emitIOr() {
        this.emitBinop(128);
    }

    public final void emitXOr() {
        this.emitBinop(130);
    }

    public final void emitShl() {
        this.emitShift(120);
    }

    public final void emitShr() {
        this.emitShift(122);
    }

    public final void emitUshr() {
        this.emitShift(124);
    }

    private void emitShift(int base_code) {
        Type type2 = this.popType().promote();
        Type type1_raw = this.popType();
        Type type1 = type1_raw.promote();
        if (type1 != Type.intType && type1 != Type.longType) {
            throw new Error("the value shifted must be an int or a long");
        }
        if (type2 != Type.intType) {
            throw new Error("the amount of shift must be an int");
        }
        this.emitTypedOp(base_code, type1);
        this.pushType(type1_raw);
    }

    public final void emitNot(Type type) {
        this.emitPushConstant(1, type);
        this.emitAdd();
        this.emitPushConstant(1, type);
        this.emitAnd();
    }

    public void emitPrimop(int opcode, int arg_count, Type retType) {
        this.reserve(1);
        while (--arg_count >= 0) {
            this.popType();
        }
        this.put1(opcode);
        this.pushType(retType);
    }

    void emitMaybeWide(int opcode, int index) {
        if (index >= 256) {
            this.put1(196);
            this.put1(opcode);
            this.put2(index);
        } else {
            this.put1(opcode);
            this.put1(index);
        }
    }

    public final void emitLoad(Variable var) {
        if (var.dead()) {
            throw new Error("attempting to push dead variable");
        }
        int offset = var.offset;
        if (offset < 0 || !var.isSimple()) {
            throw new Error("attempting to load from unassigned variable " + var + " simple:" + var.isSimple() + ", offset: " + offset);
        }
        Type type = var.getType().promote();
        this.reserve(4);
        int kind = this.adjustTypedOp(type);
        if (offset <= 3) {
            this.put1(26 + 4 * kind + offset);
        } else {
            this.emitMaybeWide(21 + kind, offset);
        }
        this.pushType(var.getType());
    }

    public void emitStore(Variable var) {
        if (!this.reachableHere()) {
            return;
        }
        int offset = var.offset;
        if (offset < 0 || !var.isSimple()) {
            throw new Error("attempting to store in unassigned " + var + " simple:" + var.isSimple() + ", offset: " + offset);
        }
        Type type = var.getType().promote();
        this.noteVarType(offset, type);
        this.reserve(4);
        this.popType();
        int kind = this.adjustTypedOp(type);
        if (offset <= 3) {
            this.put1(59 + 4 * kind + offset);
        } else {
            this.emitMaybeWide(54 + kind, offset);
        }
    }

    public void emitInc(Variable var, short inc) {
        boolean wide;
        if (var.dead()) {
            throw new Error("attempting to increment dead variable");
        }
        int offset = var.offset;
        if (offset < 0 || !var.isSimple()) {
            throw new Error("attempting to increment unassigned variable" + var.getName() + " simple:" + var.isSimple() + ", offset: " + offset);
        }
        if (inc == 0) {
            return;
        }
        this.reserve(6);
        if (var.getType().getImplementationType().promote() != Type.intType) {
            throw new Error("attempting to increment non-int variable");
        }
        boolean bl = wide = offset > 255 || inc > 255 || inc < -256;
        if (wide) {
            this.put1(196);
            this.put1(132);
            this.put2(offset);
            this.put2(inc);
        } else {
            this.put1(132);
            this.put1(offset);
            this.put1(inc);
        }
    }

    private final void emitFieldop(Field field, int opcode) {
        this.reserve(3);
        this.put1(opcode);
        this.putIndex2(this.getConstants().addFieldRef(field));
    }

    public final void emitGetStatic(Field field) {
        this.pushType(field.getType());
        this.emitFieldop(field, 178);
    }

    public final void emitGetField(Field field) {
        this.popType();
        this.pushType(field.getType());
        this.emitFieldop(field, 180);
    }

    public final void emitPutStatic(Field field) {
        this.popType();
        this.emitFieldop(field, 179);
    }

    public final void emitPutField(Field field) {
        this.popType();
        this.popType();
        this.emitFieldop(field, 181);
    }

    private int words(Type[] types) {
        int res = 0;
        int i = types.length;
        while (--i >= 0) {
            if (types[i].size > 4) {
                res += 2;
                continue;
            }
            ++res;
        }
        return res;
    }

    public void emitInvokeMethod(Method method, int opcode) {
        Type t;
        if (!this.reachableHere()) {
            return;
        }
        this.reserve(opcode == 185 ? 5 : 3);
        int arg_count = method.arg_types.length;
        boolean is_invokestatic = opcode == 184;
        boolean is_init = opcode == 183 && "<init>".equals(method.getName());
        if (is_invokestatic != ((method.access_flags & 8) != 0)) {
            throw new Error("emitInvokeXxx static flag mis-match method.flags=" + method.access_flags);
        }
        if (!is_invokestatic && !is_init) {
            ++arg_count;
        }
        this.put1(opcode);
        this.putIndex2(this.getConstants().addMethodRef(method));
        if (opcode == 185) {
            this.put1(this.words(method.arg_types) + 1);
            this.put1(0);
        }
        while (--arg_count >= 0) {
            t = this.popType();
            if (!(t instanceof UninitializedType)) continue;
            throw new Error("passing " + t + " as parameter");
        }
        if (is_init) {
            int i;
            t = this.popType();
            if (!(t instanceof UninitializedType)) {
                throw new Error("calling <init> on already-initialized object");
            }
            ClassType ctype = ((UninitializedType)t).ctype;
            for (int i2 = 0; i2 < this.SP; ++i2) {
                if (this.stack_types[i2] != t) continue;
                this.stack_types[i2] = ctype;
            }
            Variable[] used = this.locals.used;
            int n = i = used == null ? 0 : used.length;
            while (--i >= 0) {
                Variable var = used[i];
                if (var == null || var.getType() != t) continue;
                var.setType(ctype);
            }
            int n2 = i = this.local_types == null ? 0 : this.local_types.length;
            while (--i >= 0) {
                if (this.local_types[i] != t) continue;
                this.local_types[i] = ctype;
            }
        }
        if (method.return_type.size != 0) {
            this.pushType(method.return_type);
        }
    }

    public void emitInvoke(Method method) {
        int opcode = (method.access_flags & 8) != 0 ? 184 : (method.classfile.isInterface() ? 185 : ("<init>".equals(method.getName()) || (method.access_flags & 2) != 0 ? 183 : 182));
        this.emitInvokeMethod(method, opcode);
    }

    public void emitInvokeVirtual(Method method) {
        this.emitInvokeMethod(method, 182);
    }

    public void emitInvokeSpecial(Method method) {
        this.emitInvokeMethod(method, 183);
    }

    public void emitInvokeStatic(Method method) {
        this.emitInvokeMethod(method, 184);
    }

    public void emitInvokeInterface(Method method) {
        this.emitInvokeMethod(method, 185);
    }

    final void emitTransfer(Label label, int opcode) {
        label.setTypes(this);
        this.fixupAdd(6, label);
        this.put1(opcode);
        this.PC += 2;
    }

    public final void emitGoto(Label label) {
        label.setTypes(this);
        this.fixupAdd(4, label);
        this.reserve(3);
        this.put1(167);
        this.PC += 2;
        this.setUnreachable();
    }

    public final void emitJsr(Label label) {
        this.fixupAdd(5, label);
        this.reserve(3);
        this.put1(168);
        this.PC += 2;
    }

    public ExitableBlock startExitableBlock(Type resultType, boolean runFinallyBlocks) {
        ExitableBlock bl = new ExitableBlock(resultType, this, runFinallyBlocks);
        bl.outer = this.currentExitableBlock;
        this.currentExitableBlock = bl;
        return bl;
    }

    public void endExitableBlock() {
        ExitableBlock bl = this.currentExitableBlock;
        bl.finish();
        this.currentExitableBlock = bl.outer;
    }

    public final void emitGotoIfCompare1(Label label, int opcode) {
        this.popType();
        this.reserve(3);
        this.emitTransfer(label, opcode);
    }

    public final void emitGotoIfIntEqZero(Label label) {
        this.emitGotoIfCompare1(label, 153);
    }

    public final void emitGotoIfIntNeZero(Label label) {
        this.emitGotoIfCompare1(label, 154);
    }

    public final void emitGotoIfIntLtZero(Label label) {
        this.emitGotoIfCompare1(label, 155);
    }

    public final void emitGotoIfIntGeZero(Label label) {
        this.emitGotoIfCompare1(label, 156);
    }

    public final void emitGotoIfIntGtZero(Label label) {
        this.emitGotoIfCompare1(label, 157);
    }

    public final void emitGotoIfIntLeZero(Label label) {
        this.emitGotoIfCompare1(label, 158);
    }

    public final void emitGotoIfNull(Label label) {
        this.emitGotoIfCompare1(label, 198);
    }

    public final void emitGotoIfNonNull(Label label) {
        this.emitGotoIfCompare1(label, 199);
    }

    public final void emitGotoIfCompare2(Label label, int logop) {
        boolean cmpg;
        if (logop < 153 || logop > 158) {
            throw new Error("emitGotoIfCompare2: logop must be one of ifeq...ifle");
        }
        Type type2 = this.popType().promote();
        Type type1 = this.popType().promote();
        this.reserve(4);
        char sig1 = type1.getSignature().charAt(0);
        char sig2 = type2.getSignature().charAt(0);
        boolean bl = cmpg = logop == 155 || logop == 158;
        if (sig1 == 'I' && sig2 == 'I') {
            logop += 6;
        } else if (sig1 == 'J' && sig2 == 'J') {
            this.put1(148);
        } else if (sig1 == 'F' && sig2 == 'F') {
            this.put1(cmpg ? 149 : 150);
        } else if (sig1 == 'D' && sig2 == 'D') {
            this.put1(cmpg ? 151 : 152);
        } else if (!(sig1 != 'L' && sig1 != '[' || sig2 != 'L' && sig2 != '[' || logop > 154)) {
            logop += 12;
        } else {
            throw new Error("invalid types to emitGotoIfCompare2");
        }
        this.emitTransfer(label, logop);
    }

    @Deprecated
    public final void emitGotoIfEq(Label label, boolean invert) {
        this.emitGotoIfCompare2(label, invert ? 154 : 153);
    }

    public final void emitGotoIfEq(Label label) {
        this.emitGotoIfCompare2(label, 153);
    }

    public final void emitGotoIfNE(Label label) {
        this.emitGotoIfCompare2(label, 154);
    }

    public final void emitGotoIfLt(Label label) {
        this.emitGotoIfCompare2(label, 155);
    }

    public final void emitGotoIfGe(Label label) {
        this.emitGotoIfCompare2(label, 156);
    }

    public final void emitGotoIfGt(Label label) {
        this.emitGotoIfCompare2(label, 157);
    }

    public final void emitGotoIfLe(Label label) {
        this.emitGotoIfCompare2(label, 158);
    }

    public final void emitIfCompare1(int opcode) {
        IfState new_if = this.pushIfState();
        if (this.popType().promote() != Type.intType) {
            throw new Error("non-int type to emitIfCompare1");
        }
        this.reserve(3);
        this.emitTransfer(new_if.end_label, opcode);
    }

    public final void emitIfIntNotZero() {
        this.emitIfCompare1(153);
    }

    public final void emitIfIntEqZero() {
        this.emitIfCompare1(154);
    }

    public final void emitIfIntLEqZero() {
        this.emitIfCompare1(157);
    }

    public final void emitIfIntGEqZero() {
        this.emitIfCompare1(155);
    }

    public final void emitIfRefCompare1(int opcode) {
        IfState new_if = this.pushIfState();
        if (!(this.popType() instanceof ObjectType)) {
            throw new Error("non-ref type to emitIfRefCompare1");
        }
        this.reserve(3);
        this.emitTransfer(new_if.end_label, opcode);
    }

    public final void emitIfNotNull() {
        this.emitIfRefCompare1(198);
    }

    public final void emitIfNull() {
        this.emitIfRefCompare1(199);
    }

    public final void emitIfIntCompare(int opcode) {
        IfState new_if = this.pushIfState();
        this.popType();
        this.popType();
        this.reserve(3);
        this.emitTransfer(new_if.end_label, opcode);
    }

    public final void emitIfIntLt() {
        this.emitIfIntCompare(162);
    }

    public final void emitIfIntGEq() {
        this.emitIfIntCompare(161);
    }

    public final void emitIfNEq() {
        IfState new_if = this.pushIfState();
        this.emitGotoIfEq(new_if.end_label);
    }

    public final void emitIfEq() {
        IfState new_if = this.pushIfState();
        this.emitGotoIfNE(new_if.end_label);
    }

    public final void emitIfLt() {
        IfState new_if = this.pushIfState();
        this.emitGotoIfGe(new_if.end_label);
    }

    public final void emitIfGe() {
        IfState new_if = this.pushIfState();
        this.emitGotoIfLt(new_if.end_label);
    }

    public final void emitIfGt() {
        IfState new_if = this.pushIfState();
        this.emitGotoIfLe(new_if.end_label);
    }

    public final void emitIfLe() {
        IfState new_if = this.pushIfState();
        this.emitGotoIfGt(new_if.end_label);
    }

    public void emitRet(Variable var) {
        int offset = var.offset;
        if (offset < 256) {
            this.reserve(2);
            this.put1(169);
            this.put1(offset);
        } else {
            this.reserve(4);
            this.put1(196);
            this.put1(169);
            this.put2(offset);
        }
    }

    public final void emitThen() {
    }

    public final void emitIfThen() {
        new IfState(this, null);
    }

    public final void emitElse() {
        Label else_label = this.if_stack.end_label;
        if (this.reachableHere()) {
            Label end_label;
            this.if_stack.end_label = end_label = new Label(this);
            this.emitGoto(end_label);
        } else {
            this.if_stack.end_label = null;
        }
        if (else_label != null) {
            else_label.define(this);
        }
        this.if_stack.doing_else = true;
    }

    public final void emitFi() {
        if (this.if_stack.end_label != null) {
            this.if_stack.end_label.define(this);
        }
        this.if_stack = this.if_stack.previous;
    }

    public void emitAndThen() {
        if (this.if_stack == null || this.if_stack.andThenSet) {
            throw new InternalError();
        }
        this.if_stack.andThenSet = true;
    }

    private IfState pushIfState() {
        if (this.if_stack != null && this.if_stack.andThenSet) {
            this.if_stack.andThenSet = false;
            return this.if_stack;
        }
        return new IfState(this);
    }

    public final void fixUnsigned(Type stackType) {
        if (stackType instanceof PrimType && ((PrimType)stackType).isUnsigned()) {
            char sig1 = stackType.getSignature().charAt(0);
            if (sig1 == 'S') {
                this.reserve(1);
                this.put1(146);
            } else if (sig1 == 'B') {
                this.emitPushInt(255);
                this.emitAnd();
            }
        }
    }

    public final void emitConvert(PrimType from, PrimType to) {
        String to_sig = to.getSignature();
        String from_sig = from.getSignature();
        int op = -1;
        int to_sig0 = to_sig.charAt(0);
        int from_sig0 = from_sig.charAt(0);
        if (from_sig0 == to_sig0) {
            return;
        }
        if (from.size < 4) {
            from_sig0 = 73;
        }
        if (to.size < 4) {
            this.emitConvert(from, Type.intType);
            from_sig0 = 73;
            if (to.isUnsigned()) {
                if (to_sig0 == 83) {
                    to_sig0 = 67;
                } else if (to_sig0 == 66) {
                    this.emitPushInt(255);
                    this.emitAnd();
                    return;
                }
            }
        }
        if (from_sig0 == 74 && from.isUnsigned() && (to_sig0 == 70 || to_sig0 == 68)) {
            this.emitPushInt(1);
            this.emitUshr();
            this.emitConvert(Type.longType, to);
            this.emitPushConstant(2, to);
            this.emitMul();
            return;
        }
        if (from_sig0 == 73 && from.isUnsigned() && (to_sig0 == 74 || to_sig0 == 70 || to_sig0 == 68)) {
            this.emitConvert(Type.intType, Type.longType);
            this.reserve(4);
            this.emitPushLong(0xFFFFFFFFL);
            this.emitAnd();
            from_sig0 = 74;
        }
        if (from_sig0 == to_sig0) {
            return;
        }
        block0 : switch (from_sig0) {
            case 73: {
                switch (to_sig0) {
                    case 66: {
                        op = 145;
                        break block0;
                    }
                    case 67: {
                        op = 146;
                        break block0;
                    }
                    case 83: {
                        op = 147;
                        break block0;
                    }
                    case 74: {
                        op = 133;
                        break block0;
                    }
                    case 70: {
                        op = 134;
                        break block0;
                    }
                    case 68: {
                        op = 135;
                    }
                }
                break;
            }
            case 74: {
                switch (to_sig0) {
                    case 73: {
                        op = 136;
                        break block0;
                    }
                    case 70: {
                        op = 137;
                        break block0;
                    }
                    case 68: {
                        op = 138;
                    }
                }
                break;
            }
            case 70: {
                switch (to_sig0) {
                    case 73: {
                        op = 139;
                        break block0;
                    }
                    case 74: {
                        op = 140;
                        break block0;
                    }
                    case 68: {
                        op = 141;
                    }
                }
                break;
            }
            case 68: {
                switch (to_sig0) {
                    case 73: {
                        op = 142;
                        break block0;
                    }
                    case 74: {
                        op = 143;
                        break block0;
                    }
                    case 70: {
                        op = 144;
                    }
                }
            }
        }
        if (op < 0) {
            throw new Error("unsupported CodeAttr.emitConvert");
        }
        this.reserve(1);
        this.popType();
        this.put1(op);
        this.pushType(to);
    }

    private void emitCheckcast(Type type, int opcode) {
        this.reserve(3);
        this.popType();
        this.put1(opcode);
        if (!(type instanceof ObjectType)) {
            throw new Error("unimplemented type " + type + " in emitCheckcast/emitInstanceof");
        }
        this.putIndex2(this.getConstants().addClass((ObjectType)type));
    }

    public static boolean castNeeded(Type top, Type required) {
        top = top.getRawType();
        do {
            if (top == required) {
                return false;
            }
            if (required instanceof ClassType && top instanceof ClassType && ((ClassType)top).isSubclass((ClassType)required)) {
                return false;
            }
            if (!(required instanceof ArrayType) || !(top instanceof ArrayType)) break;
            required = ((ArrayType)required).getComponentType();
            top = ((ArrayType)top).getComponentType();
        } while (true);
        return true;
    }

    public void emitCheckcast(Type type) {
        if (CodeAttr.castNeeded(this.topType(), type)) {
            this.emitCheckcast(type, 192);
            this.pushType(type);
        }
    }

    public void emitInstanceof(Type type) {
        this.emitCheckcast(type, 193);
        this.pushType(Type.booleanType);
    }

    public final void emitThrow() {
        this.popType();
        this.reserve(1);
        this.put1(191);
        this.setUnreachable();
    }

    public final void emitMonitorEnter() {
        this.popType();
        this.reserve(1);
        this.put1(194);
    }

    public final void emitMonitorExit() {
        this.popType();
        this.reserve(1);
        this.put1(195);
    }

    public final void emitReturn() {
        if (this.try_stack != null) {
            new Error();
        }
        this.emitRawReturn();
    }

    final void emitRawReturn() {
        if (!this.reachableHere()) {
            return;
        }
        if (this.getMethod().getReturnType().size == 0) {
            this.reserve(1);
            this.put1(177);
        } else {
            this.emitTypedOp(172, this.popType().promote());
        }
        this.setUnreachable();
    }

    public void addHandler(int start_pc, int end_pc, int handler_pc, int catch_type) {
        int index = 4 * this.exception_table_length;
        if (this.exception_table == null) {
            this.exception_table = new short[20];
        } else if (this.exception_table.length <= index) {
            short[] new_table = new short[2 * this.exception_table.length];
            System.arraycopy(this.exception_table, 0, new_table, 0, index);
            this.exception_table = new_table;
        }
        this.exception_table[index++] = (short)start_pc;
        this.exception_table[index++] = (short)end_pc;
        this.exception_table[index++] = (short)handler_pc;
        this.exception_table[index++] = (short)catch_type;
        ++this.exception_table_length;
    }

    public void addHandler(Label start_try, Label end_try, ClassType catch_type) {
        ConstantPool constants = this.getConstants();
        int catch_type_index = catch_type == null ? 0 : constants.addClass((ObjectType)catch_type).index;
        this.fixupAdd(11, start_try);
        this.fixupAdd(12, catch_type_index, end_try);
        Label handler = new Label();
        handler.localTypes = start_try.localTypes;
        handler.stackTypes = new Type[1];
        ClassType handler_class = catch_type == null ? Type.javalangThrowableType : catch_type;
        handler.stackTypes[0] = handler_class;
        this.setTypes(handler);
        this.fixupAdd(13, 0, handler);
        this.setReachable(true);
    }

    public void emitWithCleanupStart() {
        int savedSP = this.SP;
        this.SP = 0;
        this.emitTryStart(false, null);
        this.SP = savedSP;
    }

    public void emitWithCleanupCatch(Variable catchVar) {
        this.emitTryEnd(false);
        this.try_stack.saved_result = catchVar;
        this.emitCatchStart(catchVar);
    }

    public void emitWithCleanupDone() {
        Variable catchVar = this.try_stack.saved_result;
        this.try_stack.saved_result = null;
        if (catchVar != null) {
            this.emitLoad(catchVar);
        }
        this.emitThrow();
        this.emitCatchEnd();
        this.emitTryCatchEnd();
    }

    public void emitTryStart(boolean has_finally, Type result_type) {
        Type last;
        int usedLocals;
        Type[] startLocals;
        if (result_type != null && result_type.isVoid()) {
            result_type = null;
        }
        Variable[] savedStack = null;
        if (result_type != null || this.SP > 0) {
            this.pushScope();
        }
        if (this.SP > 0) {
            savedStack = new Variable[this.SP];
            int i = 0;
            while (this.SP > 0) {
                Variable var = this.addLocal(this.topType());
                this.emitStore(var);
                savedStack[i++] = var;
            }
        }
        TryState try_state = new TryState(this);
        try_state.savedStack = savedStack;
        int n = usedLocals = this.local_types == null ? 0 : this.local_types.length;
        while (usedLocals > 0 && (last = this.local_types[usedLocals - 1]) == null) {
            --usedLocals;
        }
        if (usedLocals == 0) {
            startLocals = Type.typeArray0;
        } else {
            startLocals = new Type[usedLocals];
            System.arraycopy(this.local_types, 0, startLocals, 0, usedLocals);
        }
        try_state.start_try.localTypes = startLocals;
        if (result_type != null) {
            try_state.saved_result = this.addLocal(result_type);
        }
        if (has_finally) {
            try_state.finally_subr = new Label();
        }
    }

    @Deprecated
    public void emitTryEnd() {
    }

    private void emitTryEnd(boolean fromFinally) {
        if (this.try_stack.tryClauseDone) {
            return;
        }
        this.try_stack.tryClauseDone = true;
        if (this.try_stack.finally_subr != null) {
            this.try_stack.exception = this.addLocal(Type.javalangThrowableType);
        }
        this.gotoFinallyOrEnd(fromFinally);
        this.try_stack.end_try = this.getLabel();
    }

    public void emitCatchStart(Variable var) {
        if (var == null) {
            this.emitCatchStart((ClassType)null);
        } else {
            this.emitCatchStart((ClassType)var.getType());
            this.emitStore(var);
        }
    }

    public void emitCatchStart(ClassType type) {
        this.emitTryEnd(false);
        this.setTypes(this.try_stack.start_try.localTypes, Type.typeArray0);
        if (this.try_stack.try_type != null) {
            this.emitCatchEnd();
        }
        this.try_stack.try_type = type;
        this.addHandler(this.try_stack.start_try, this.try_stack.end_try, type);
        this.setReachable(true);
    }

    public void emitCatchEnd() {
        this.gotoFinallyOrEnd(false);
        this.try_stack.try_type = null;
    }

    private void gotoFinallyOrEnd(boolean fromFinally) {
        if (this.reachableHere()) {
            if (this.try_stack.saved_result != null) {
                this.emitStore(this.try_stack.saved_result);
            }
            if (this.try_stack.end_label == null) {
                this.try_stack.end_label = new Label();
            }
            if (this.try_stack.finally_subr == null || this.useJsr()) {
                if (this.try_stack.finally_subr != null) {
                    this.emitJsr(this.try_stack.finally_subr);
                }
                this.emitGoto(this.try_stack.end_label);
            } else {
                if (this.try_stack.exitCases != null) {
                    this.emitPushInt(0);
                }
                this.emitPushNull();
                if (!fromFinally) {
                    this.emitGoto(this.try_stack.finally_subr);
                }
            }
        }
    }

    public void emitFinallyStart() {
        this.emitTryEnd(true);
        if (this.try_stack.try_type != null) {
            this.emitCatchEnd();
        }
        this.try_stack.end_try = this.getLabel();
        this.pushScope();
        if (this.useJsr()) {
            this.SP = 0;
            this.emitCatchStart((ClassType)null);
            this.emitStore(this.try_stack.exception);
            this.emitJsr(this.try_stack.finally_subr);
            this.emitLoad(this.try_stack.exception);
            this.emitThrow();
        } else {
            if (this.reachableHere()) {
                this.emitGoto(this.try_stack.finally_subr);
            }
            this.addHandler(this.try_stack.start_try, this.try_stack.end_try, Type.javalangThrowableType);
            if (this.try_stack.saved_result != null) {
                this.emitStoreDefaultValue(this.try_stack.saved_result);
            }
            if (this.try_stack.exitCases != null) {
                this.emitPushInt(-1);
                this.emitSwap();
            }
        }
        this.try_stack.finally_subr.define(this);
        if (this.useJsr()) {
            ClassType ret_addr_type = Type.objectType;
            this.try_stack.finally_ret_addr = this.addLocal(ret_addr_type);
            this.pushType(ret_addr_type);
            this.emitStore(this.try_stack.finally_ret_addr);
        }
    }

    public void emitFinallyEnd() {
        if (!this.reachableHere()) {
            this.try_stack.end_label = null;
        } else if (this.useJsr()) {
            this.emitRet(this.try_stack.finally_ret_addr);
        } else if (this.try_stack.end_label == null && this.try_stack.exitCases == null) {
            this.emitThrow();
        } else {
            this.emitStore(this.try_stack.exception);
            this.emitLoad(this.try_stack.exception);
            this.emitIfNotNull();
            this.emitLoad(this.try_stack.exception);
            this.emitThrow();
            this.emitElse();
            ExitableBlock exit = this.try_stack.exitCases;
            if (exit != null) {
                SwitchState sw = this.startSwitch();
                while (exit != null) {
                    ExitableBlock next = exit.nextCase;
                    exit.nextCase = null;
                    exit.currentTryState = null;
                    TryState nextTry = TryState.outerHandler(this.try_stack.previous, exit.initialTryState);
                    if (nextTry == exit.initialTryState) {
                        sw.addCaseGoto(exit.switchCase, this, exit.endLabel);
                    } else {
                        sw.addCase(exit.switchCase, this);
                        exit.exit(nextTry);
                    }
                    exit = next;
                }
                this.try_stack.exitCases = null;
                sw.addDefault(this);
                sw.finish(this);
            }
            this.emitFi();
            this.setUnreachable();
        }
        this.popScope();
        this.try_stack.finally_subr = null;
    }

    public void emitTryCatchEnd() {
        if (this.try_stack.finally_subr != null) {
            this.emitFinallyEnd();
        }
        Variable[] vars = this.try_stack.savedStack;
        if (this.try_stack.end_label == null) {
            this.setUnreachable();
        } else {
            this.setTypes(this.try_stack.start_try.localTypes, Type.typeArray0);
            this.try_stack.end_label.define(this);
            if (vars != null) {
                int i = vars.length;
                while (--i >= 0) {
                    Variable v = vars[i];
                    if (v == null) continue;
                    this.emitLoad(v);
                }
            }
            if (this.try_stack.saved_result != null) {
                this.emitLoad(this.try_stack.saved_result);
            }
        }
        if (this.try_stack.saved_result != null || vars != null) {
            this.popScope();
        }
        this.try_stack = this.try_stack.previous;
    }

    public final TryState getCurrentTry() {
        return this.try_stack;
    }

    public final boolean isInTry() {
        return this.try_stack != null;
    }

    public SwitchState startSwitch() {
        SwitchState sw = new SwitchState(this);
        sw.switchValuePushed(this);
        return sw;
    }

    public void emitTailCall(boolean pop_args, Label start) {
        if (pop_args) {
            Method meth = this.getMethod();
            int arg_slots = (meth.access_flags & 8) != 0 ? 0 : 1;
            int i = meth.arg_types.length;
            while (--i >= 0) {
                arg_slots += meth.arg_types[i].size > 4 ? 2 : 1;
            }
            i = meth.arg_types.length;
            while (--i >= 0) {
                this.emitStore(this.locals.used[arg_slots -= meth.arg_types[i].size > 4 ? 2 : 1]);
            }
        }
        this.emitGoto(start);
    }

    public void emitTailCall(boolean pop_args, Scope scope) {
        this.emitTailCall(pop_args, scope.start);
    }

    public void processFixups() {
        if (this.fixup_count <= 0) {
            return;
        }
        int delta = 0;
        int instruction_tail = this.fixup_count;
        this.fixupAdd(9, -1, null);
        int i = 0;
        block33 : do {
            int offset = this.fixup_offsets[i];
            int kind = offset & 15;
            offset >>= 4;
            Label label = this.fixup_labels[i];
            if (kind >= 3 && kind <= 7) {
                int max = this.fixup_count;
                block34 : while (label != null && --max >= 0) {
                    int labpc = this.fixupOffset(label.first_fixup);
                    for (int def = label.first_fixup + 1; def < this.fixup_count && labpc == this.fixupOffset(def); ++def) {
                        if (this.fixupKind(def) != 4 && this.fixupKind(def) != 8) continue;
                        this.fixup_labels[i] = label = this.fixup_labels[def];
                        continue block34;
                    }
                }
            }
            switch (kind) {
                case 11: {
                    i += 2;
                    break;
                }
                case 14: {
                    ++i;
                }
                case 3: 
                case 8: {
                    break;
                }
                case 1: {
                    while (i + 1 < this.fixup_count && this.fixupKind(i + 1) == 0 && this.fixupOffset(i + 1) == offset) {
                        label.position += delta;
                        label = this.fixup_labels[++i];
                    }
                    if (i + 1 < this.fixup_count && this.fixupKind(i + 1) == 4 && this.fixupOffset(i + 1) == offset) {
                        int j = i;
                        do {
                            this.fixup_labels[j].needsStackMapEntry = false;
                            if (this.fixupKind(j) == 1) break;
                            --j;
                        } while (true);
                        this.fixupSet(++i, 8, offset);
                        delta -= 3;
                        continue block33;
                    }
                }
                case 0: {
                    label.position += delta;
                    break;
                }
                case 2: {
                    delta += 3;
                    break;
                }
                case 4: {
                    if (this.fixupOffset(label.first_fixup) == offset + 3) {
                        this.fixupSet(i, 8, offset);
                        delta -= 3;
                        break;
                    }
                }
                case 5: {
                    if (this.PC < 32768) break;
                    delta += 2;
                    break;
                }
                case 6: {
                    if (this.PC < 32768) break;
                    delta += 5;
                    break;
                }
                case 10: {
                    this.fixup_labels[instruction_tail] = this.fixup_labels[i + 1];
                    instruction_tail = offset;
                }
                case 9: {
                    int cur_pc = i + 1 >= this.fixup_count ? this.PC : this.fixupOffset(this.fixup_labels[i + 1].first_fixup);
                    this.fixupSet(i, 9, cur_pc);
                    if (label == null) break block33;
                    i = label.first_fixup;
                    int next_pc = this.fixupOffset(i);
                    delta = cur_pc + delta - next_pc;
                    continue block33;
                }
                default: {
                    throw new Error("unexpected fixup");
                }
            }
            ++i;
        } while (true);
        int new_size = this.PC;
        delta = 0;
        int i2 = 0;
        block38 : while (i2 < this.fixup_count) {
            int offset = this.fixup_offsets[i2];
            int kind = offset & 15;
            Label label = this.fixup_labels[i2];
            if (label != null && label.position < 0) {
                throw new Error("undefined label " + label);
            }
            offset >>= 4;
            switch (kind) {
                case 11: {
                    this.fixup_labels[i2 += 2].position = offset + delta;
                    break;
                }
                case 14: {
                    ++i2;
                }
                case 3: {
                    break;
                }
                case 8: {
                    delta -= 3;
                    new_size -= 3;
                    break;
                }
                case 0: 
                case 1: {
                    label.position = offset + delta;
                    break;
                }
                case 2: {
                    int padding = 3 - (offset + delta) & 3;
                    delta += padding;
                    new_size += padding;
                    break;
                }
                case 4: 
                case 5: 
                case 6: {
                    int rel = label.position - (offset + delta);
                    if ((short)rel == rel) {
                        this.fixupSet(i2, 7, offset);
                        break;
                    }
                    delta += kind == 6 ? 5 : 2;
                    new_size += kind == 6 ? 5 : 2;
                    break;
                }
                case 9: {
                    if (label == null) break block38;
                    i2 = label.first_fixup;
                    int next_pc = this.fixupOffset(i2);
                    delta = offset + delta - next_pc;
                    continue block38;
                }
                default: {
                    throw new Error("unexpected fixup");
                }
            }
            ++i2;
        }
        byte[] new_code = new byte[new_size];
        int prev_linenumber = -1;
        int new_pc = 0;
        int next_fixup_index = 0;
        int next_fixup_offset = this.fixupOffset(0);
        int oldPC = -1;
        Label pendingStackMapLabel = null;
        int old_pc = 0;
        block39 : do {
            if (old_pc < next_fixup_offset) {
                new_code[new_pc++] = this.code[old_pc++];
                continue;
            }
            int kind = this.fixup_offsets[next_fixup_index] & 15;
            Label label = this.fixup_labels[next_fixup_index];
            if (pendingStackMapLabel != null && pendingStackMapLabel.position < new_pc) {
                this.stackMap.emitStackMapEntry(pendingStackMapLabel, this);
                pendingStackMapLabel = null;
            }
            if (pendingStackMapLabel != null && pendingStackMapLabel.position > new_pc) {
                throw new Error("labels out of order");
            }
            switch (kind) {
                case 0: 
                case 1: {
                    if (this.stackMap == null || label == null || !label.isUsed() || !label.needsStackMapEntry) break;
                    pendingStackMapLabel = this.mergeLabels(pendingStackMapLabel, label);
                    break;
                }
                case 8: {
                    old_pc += 3;
                    break;
                }
                case 7: {
                    delta = label.position - new_pc;
                    new_code[new_pc++] = this.code[old_pc];
                    new_code[new_pc++] = (byte)(delta >> 8);
                    new_code[new_pc++] = (byte)(delta & 255);
                    old_pc += 3;
                    break;
                }
                case 4: 
                case 5: 
                case 6: {
                    delta = label.position - new_pc;
                    int opcode = this.code[old_pc];
                    if (kind == 6) {
                        opcode = this.invert_opcode((byte)opcode);
                        new_code[new_pc++] = opcode;
                        new_code[new_pc++] = 0;
                        new_code[new_pc++] = 8;
                        opcode = -56;
                    } else {
                        opcode = (byte)(opcode + 33);
                    }
                    new_code[new_pc++] = opcode;
                    new_code[new_pc++] = (byte)(delta >> 24);
                    new_code[new_pc++] = (byte)(delta >> 16);
                    new_code[new_pc++] = (byte)(delta >> 8);
                    new_code[new_pc++] = (byte)(delta & 255);
                    old_pc += 3;
                    break;
                }
                case 2: {
                    int padding = 3 - new_pc & 3;
                    int switch_start = new_pc;
                    new_code[new_pc++] = this.code[old_pc++];
                    while (--padding >= 0) {
                        new_code[new_pc++] = 0;
                    }
                    while (next_fixup_index < this.fixup_count && this.fixupKind(next_fixup_index + 1) == 3) {
                        int offset = this.fixupOffset(++next_fixup_index);
                        while (old_pc < offset) {
                            new_code[new_pc++] = this.code[old_pc++];
                        }
                        delta = this.fixup_labels[next_fixup_index].position - switch_start;
                        new_code[new_pc++] = (byte)(delta >> 24);
                        new_code[new_pc++] = (byte)(delta >> 16);
                        new_code[new_pc++] = (byte)(delta >> 8);
                        new_code[new_pc++] = (byte)(delta & 255);
                        old_pc += 4;
                    }
                    break;
                }
                case 11: {
                    label = this.fixup_labels[next_fixup_index + 2];
                    int handler_type_index = this.fixupOffset(next_fixup_index + 1);
                    if (this.stackMap != null) {
                        pendingStackMapLabel = this.mergeLabels(pendingStackMapLabel, label);
                    }
                    this.addHandler(this.fixup_labels[next_fixup_index].position, this.fixup_labels[next_fixup_index + 1].position, new_pc, handler_type_index);
                    next_fixup_index += 2;
                    break;
                }
                case 14: {
                    int linenumber;
                    if (this.lines == null) {
                        this.lines = new LineNumbersAttr(this);
                    }
                    if ((linenumber = this.fixupOffset(++next_fixup_index)) != prev_linenumber) {
                        this.lines.put(linenumber, new_pc);
                    }
                    prev_linenumber = linenumber;
                    break;
                }
                case 9: {
                    if (label == null) break block39;
                    next_fixup_index = label.first_fixup;
                    next_fixup_offset = old_pc = this.fixupOffset(next_fixup_index);
                    if (label.position == new_pc) continue block39;
                    throw new Error("bad pc");
                }
                default: {
                    throw new Error("unexpected fixup");
                }
            }
            next_fixup_offset = this.fixupOffset(++next_fixup_index);
        } while (true);
        if (new_size != new_pc) {
            throw new Error("PC confusion new_pc:" + new_pc + " new_size:" + new_size);
        }
        this.PC = new_size;
        this.code = new_code;
        this.fixup_count = 0;
        this.fixup_labels = null;
        this.fixup_offsets = null;
    }

    private Label mergeLabels(Label oldLabel, Label newLabel) {
        if (oldLabel != null) {
            newLabel.setTypes(oldLabel);
        }
        return newLabel;
    }

    @Override
    public void assignConstants(ClassType cl) {
        if (this.locals != null && this.locals.container == null && !this.locals.isEmpty()) {
            this.locals.addToFrontOf(this);
        }
        this.processFixups();
        if (this.stackMap != null && this.stackMap.numEntries > 0) {
            this.stackMap.addToFrontOf(this);
        }
        if (instructionLineMode) {
            if (this.lines == null) {
                this.lines = new LineNumbersAttr(this);
            }
            this.lines.linenumber_count = 0;
            int codeLen = this.getCodeLength();
            for (int i = 0; i < codeLen; ++i) {
                this.lines.put(i, i);
            }
        }
        super.assignConstants(cl);
        Attribute.assignConstants(this, cl);
    }

    @Override
    public final int getLength() {
        return 12 + this.getCodeLength() + 8 * this.exception_table_length + Attribute.getLengthAll(this);
    }

    @Override
    public void write(DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.max_stack);
        dstr.writeShort(this.max_locals);
        dstr.writeInt(this.PC);
        dstr.write(this.code, 0, this.PC);
        dstr.writeShort(this.exception_table_length);
        int count = this.exception_table_length;
        int i = 0;
        while (--count >= 0) {
            dstr.writeShort(this.exception_table[i]);
            dstr.writeShort(this.exception_table[i + 1]);
            dstr.writeShort(this.exception_table[i + 2]);
            dstr.writeShort(this.exception_table[i + 3]);
            i += 4;
        }
        Attribute.writeAll(this, dstr);
    }

    @Override
    public void print(ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", max_stack:");
        dst.print(this.max_stack);
        dst.print(", max_locals:");
        dst.print(this.max_locals);
        dst.print(", code_length:");
        int length = this.getCodeLength();
        dst.println(length);
        this.disAssemble(dst, 0, length);
        if (this.exception_table_length > 0) {
            dst.print("Exceptions (count: ");
            dst.print(this.exception_table_length);
            dst.println("):");
            int count = this.exception_table_length;
            int i = 0;
            while (--count >= 0) {
                dst.print("  start: ");
                dst.print(this.exception_table[i] & 65535);
                dst.print(", end: ");
                dst.print(this.exception_table[i + 1] & 65535);
                dst.print(", handler: ");
                dst.print(this.exception_table[i + 2] & 65535);
                dst.print(", type: ");
                int catch_type_index = this.exception_table[i + 3] & 65535;
                if (catch_type_index == 0) {
                    dst.print("0 /* finally */");
                } else {
                    dst.printOptionalIndex(catch_type_index);
                    dst.printConstantTersely(catch_type_index, 7);
                }
                dst.println();
                i += 4;
            }
        }
        dst.printAttributes(this);
    }

    public void disAssemble(ClassTypeWriter dst, int start, int limit) {
        boolean wide = false;
        int i = start;
        while (i < limit) {
            int index;
            int delta;
            int oldpc = i++;
            int op = this.code[oldpc] & 255;
            String str = Integer.toString(oldpc);
            int printConstant = 0;
            int j = str.length();
            while (++j <= 3) {
                dst.print(' ');
            }
            dst.print(str);
            dst.print(": ");
            if (op < 120) {
                if (op < 87) {
                    if (op < 3) {
                        this.print("nop;aconst_null;iconst_m1;", op, dst);
                    } else if (op < 9) {
                        dst.print("iconst_");
                        dst.print(op - 3);
                    } else if (op < 16) {
                        char typ;
                        if (op < 11) {
                            typ = 'l';
                            op -= 9;
                        } else if (op < 14) {
                            typ = 'f';
                            op -= 11;
                        } else {
                            typ = 'd';
                            op -= 14;
                        }
                        dst.print(typ);
                        dst.print("const_");
                        dst.print(op);
                    } else if (op < 21) {
                        if (op < 18) {
                            short constant;
                            this.print("bipush ;sipush ;", op - 16, dst);
                            if (op == 16) {
                                constant = this.code[i++];
                            } else {
                                constant = (short)this.readUnsignedShort(i);
                                i += 2;
                            }
                            dst.print(constant);
                        } else {
                            printConstant = op == 18 ? 1 : 2;
                            this.print("ldc;ldc_w;ldc2_w;", op - 18, dst);
                        }
                    } else {
                        String load_or_store;
                        int index2;
                        if (op < 54) {
                            load_or_store = "load";
                        } else {
                            load_or_store = "store";
                            op -= 33;
                        }
                        if (op < 26) {
                            index2 = -1;
                            op -= 21;
                        } else if (op < 46) {
                            index2 = (op -= 26) % 4;
                            op >>= 2;
                        } else {
                            index2 = -2;
                            op -= 46;
                        }
                        dst.print("ilfdabcs".charAt(op));
                        if (index2 == -2) {
                            dst.write(97);
                        }
                        dst.print(load_or_store);
                        if (index2 >= 0) {
                            dst.write(95);
                            dst.print(index2);
                        } else if (index2 == -1) {
                            if (wide) {
                                index2 = this.readUnsignedShort(i);
                                i += 2;
                            } else {
                                index2 = this.code[i] & 255;
                                ++i;
                            }
                            wide = false;
                            dst.print(' ');
                            dst.print(index2);
                        }
                    }
                } else if (op < 96) {
                    this.print("pop;pop2;dup;dup_x1;dup_x2;dup2;dup2_x1;dup2_x2;swap;", op - 87, dst);
                } else {
                    dst.print("ilfda".charAt((op - 96) % 4));
                    this.print("add;sub;mul;div;rem;neg;", op - 96 >> 2, dst);
                }
            } else if (op < 170) {
                if (op < 132) {
                    dst.print((op & 1) == 0 ? (char)'i' : 'l');
                    this.print("shl;shr;ushr;and;or;xor;", op - 120 >> 1, dst);
                } else if (op == 132) {
                    short constant;
                    int var_index;
                    dst.print("iinc");
                    if (!wide) {
                        var_index = 255 & this.code[i++];
                        constant = this.code[i++];
                    } else {
                        var_index = this.readUnsignedShort(i);
                        constant = (short)this.readUnsignedShort(i += 2);
                        i += 2;
                        wide = false;
                    }
                    dst.print(' ');
                    dst.print(var_index);
                    dst.print(' ');
                    dst.print(constant);
                } else if (op < 148) {
                    dst.print("ilfdi".charAt((op - 133) / 3));
                    dst.print('2');
                    dst.print("lfdifdildilfbcs".charAt(op - 133));
                } else if (op < 153) {
                    this.print("lcmp;fcmpl;fcmpg;dcmpl;dcmpg;", op - 148, dst);
                } else if (op < 169) {
                    if (op < 159) {
                        dst.print("if");
                        this.print("eq;ne;lt;ge;gt;le;", op - 153, dst);
                    } else if (op < 167) {
                        if (op < 165) {
                            dst.print("if_icmp");
                        } else {
                            dst.print("if_acmp");
                            op -= 6;
                        }
                        this.print("eq;ne;lt;ge;gt;le;", op - 159, dst);
                    } else {
                        this.print("goto;jsr;", op - 167, dst);
                    }
                    delta = this.readUnsignedShort(i);
                    i += 2;
                    dst.print(' ');
                    dst.print(oldpc + delta);
                } else {
                    dst.print("ret ");
                    if (wide) {
                        index = this.readUnsignedShort(i);
                        i += 2;
                    } else {
                        index = this.code[i] & 255;
                        ++i;
                    }
                    wide = false;
                    dst.print(index);
                }
            } else if (op < 172) {
                if (this.fixup_count <= 0) {
                    i = i + 3 & -4;
                }
                int code_offset = this.readInt(i);
                i += 4;
                if (op == 170) {
                    dst.print("tableswitch");
                    int low = this.readInt(i);
                    int high = this.readInt(i += 4);
                    i += 4;
                    dst.print(" low: ");
                    dst.print(low);
                    dst.print(" high: ");
                    dst.print(high);
                    dst.print(" default: ");
                    dst.print(oldpc + code_offset);
                    while (low <= high) {
                        code_offset = this.readInt(i);
                        i += 4;
                        dst.println();
                        dst.print("  ");
                        dst.print(low);
                        dst.print(": ");
                        dst.print(oldpc + code_offset);
                        ++low;
                    }
                } else {
                    dst.print("lookupswitch");
                    int npairs = this.readInt(i);
                    i += 4;
                    dst.print(" npairs: ");
                    dst.print(npairs);
                    dst.print(" default: ");
                    dst.print(oldpc + code_offset);
                    while (--npairs >= 0) {
                        int match = this.readInt(i);
                        code_offset = this.readInt(i += 4);
                        i += 4;
                        dst.println();
                        dst.print("  ");
                        dst.print(match);
                        dst.print(": ");
                        dst.print(oldpc + code_offset);
                    }
                }
            } else if (op < 178) {
                if (op < 177) {
                    dst.print("ilfda".charAt(op - 172));
                }
                dst.print("return");
            } else if (op < 182) {
                this.print("getstatic;putstatic;getfield;putfield;", op - 178, dst);
                printConstant = 2;
            } else if (op < 185) {
                dst.print("invoke");
                this.print("virtual;special;static;", op - 182, dst);
                printConstant = 2;
            } else if (op == 185) {
                dst.print("invokeinterface (");
                index = this.readUnsignedShort(i);
                int args = 255 & this.code[i += 2];
                i += 2;
                dst.print(args + " args)");
                dst.printConstantOperand(index);
            } else if (op == 186) {
                dst.print("invokedynamic");
                index = this.readUnsignedShort(i);
                i += 4;
                dst.printConstantOperand(index);
            } else if (op < 196) {
                this.print("186;new;newarray;anewarray;arraylength;athrow;checkcast;instanceof;monitorenter;monitorexit;", op - 186, dst);
                if (op == 187 || op == 189 || op == 192 || op == 193) {
                    printConstant = 2;
                } else if (op == 188) {
                    byte type = this.code[i++];
                    dst.print(' ');
                    if (type >= 4 && type <= 11) {
                        this.print("boolean;char;float;double;byte;short;int;long;", type - 4, dst);
                    } else {
                        dst.print(type);
                    }
                }
            } else if (op == 196) {
                dst.print("wide");
                wide = true;
            } else if (op == 197) {
                dst.print("multianewarray");
                index = this.readUnsignedShort(i);
                i += 2;
                dst.printConstantOperand(index);
                int dims = 255 & this.code[i++];
                dst.print(' ');
                dst.print(dims);
            } else if (op < 200) {
                this.print("ifnull;ifnonnull;", op - 198, dst);
                delta = (short)this.readUnsignedShort(i);
                i += 2;
                dst.print(' ');
                dst.print(oldpc + delta);
            } else if (op < 202) {
                this.print("goto_w;jsr_w;", op - 200, dst);
                delta = this.readInt(i);
                i += 4;
                dst.print(' ');
                dst.print(oldpc + delta);
            } else {
                dst.print(op);
            }
            if (printConstant > 0) {
                if (printConstant == 1) {
                    index = 255 & this.code[i++];
                } else {
                    index = this.readUnsignedShort(i);
                    i += 2;
                }
                dst.printConstantOperand(index);
            }
            dst.println();
        }
    }

    private int readUnsignedShort(int offset) {
        return (255 & this.code[offset]) << 8 | 255 & this.code[offset + 1];
    }

    private int readInt(int offset) {
        return this.readUnsignedShort(offset) << 16 | this.readUnsignedShort(offset + 2);
    }

    private void print(String str, int i, PrintWriter dst) {
        int last = 0;
        int pos = -1;
        while (i >= 0) {
            last = ++pos;
            pos = str.indexOf(59, last);
            --i;
        }
        dst.write(str, last, pos - last);
    }

    public int beginFragment(Label after) {
        return this.beginFragment(new Label(), after);
    }

    public int beginFragment(Label start, Label after) {
        int i = this.fixup_count;
        this.fixupAdd(10, after);
        start.define(this);
        return i;
    }

    public void endFragment(int cookie) {
        this.fixupSet(cookie, 10, this.fixup_count);
        Label after = this.fixup_labels[cookie];
        this.fixupAdd(9, -1, null);
        after.define(this);
        int fx = this.fixup_count - 1;
        this.fixupSet(fx, 0, this.fixupOffset(fx));
    }
}

