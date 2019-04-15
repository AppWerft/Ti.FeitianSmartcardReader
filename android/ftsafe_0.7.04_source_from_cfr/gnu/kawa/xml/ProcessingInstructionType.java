/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.TypeValue;
import gnu.kawa.xml.KProcessingInstruction;
import gnu.kawa.xml.NodeType;
import gnu.lists.AbstractSequence;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ProcessingInstructionType
extends NodeType
implements TypeValue,
Externalizable {
    String target;
    public static final ProcessingInstructionType piNodeTest = new ProcessingInstructionType(null);
    public static final ClassType typeProcessingInstructionType = ClassType.make("gnu.kawa.xml.ProcessingInstructionType");
    static final Method coerceMethod = typeProcessingInstructionType.getDeclaredMethod("coerce", 2);
    static final Method coerceOrNullMethod = typeProcessingInstructionType.getDeclaredMethod("coerceOrNull", 2);

    public ProcessingInstructionType(String target) {
        super(target == null ? "processing-instruction()" : "processing-instruction(" + target + ")");
        this.target = target;
    }

    public static ProcessingInstructionType getInstance(String target) {
        return target == null ? piNodeTest : new ProcessingInstructionType(target);
    }

    @Override
    public Type getImplementationType() {
        return ClassType.make("gnu.kawa.xml.KProcessingInstruction");
    }

    @Override
    public void emitCoerceFromObject(CodeAttr code) {
        code.emitPushString(this.target);
        code.emitInvokeStatic(coerceMethod);
    }

    @Override
    public Object coerceFromObject(Object obj) {
        return ProcessingInstructionType.coerce(obj, this.target);
    }

    @Override
    public boolean isInstancePos(AbstractSequence seq, int ipos) {
        int kind = seq.getNextKind(ipos);
        if (kind == 37) {
            return this.target == null || this.target.equals(seq.getNextTypeObject(ipos));
        }
        if (kind == 32) {
            return this.isInstance(seq.getPosNext(ipos));
        }
        return false;
    }

    @Override
    public boolean isInstance(Object obj) {
        return ProcessingInstructionType.coerceOrNull(obj, this.target) != null;
    }

    public static KProcessingInstruction coerceOrNull(Object obj, String target) {
        KProcessingInstruction pos = (KProcessingInstruction)NodeType.coerceOrNull(obj, 32);
        return pos != null && (target == null || target.equals(pos.getTarget())) ? pos : null;
    }

    public static KProcessingInstruction coerce(Object obj, String target) {
        KProcessingInstruction pos = ProcessingInstructionType.coerceOrNull(obj, target);
        if (pos == null) {
            throw new ClassCastException();
        }
        return pos;
    }

    @Override
    protected void emitCoerceOrNullMethod(Variable incoming, Compilation comp) {
        CodeAttr code = comp.getCode();
        if (incoming != null) {
            code.emitLoad(incoming);
        }
        code.emitPushString(this.target);
        code.emitInvokeStatic(coerceOrNullMethod);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.target);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.target = (String)in.readObject();
    }

    @Override
    public String toString() {
        return "ProcessingInstructionType " + (this.target == null ? "*" : this.target);
    }
}

