// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.expr.Compilation;
import gnu.bytecode.Variable;
import gnu.lists.AbstractSequence;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import java.io.Externalizable;
import gnu.expr.TypeValue;

public class ProcessingInstructionType extends NodeType implements TypeValue, Externalizable
{
    String target;
    public static final ProcessingInstructionType piNodeTest;
    public static final ClassType typeProcessingInstructionType;
    static final Method coerceMethod;
    static final Method coerceOrNullMethod;
    
    public ProcessingInstructionType(final String target) {
        super((target == null) ? "processing-instruction()" : ("processing-instruction(" + target + ")"));
        this.target = target;
    }
    
    public static ProcessingInstructionType getInstance(final String target) {
        return (target == null) ? ProcessingInstructionType.piNodeTest : new ProcessingInstructionType(target);
    }
    
    @Override
    public Type getImplementationType() {
        return ClassType.make("gnu.kawa.xml.KProcessingInstruction");
    }
    
    @Override
    public void emitCoerceFromObject(final CodeAttr code) {
        code.emitPushString(this.target);
        code.emitInvokeStatic(ProcessingInstructionType.coerceMethod);
    }
    
    @Override
    public Object coerceFromObject(final Object obj) {
        return coerce(obj, this.target);
    }
    
    @Override
    public boolean isInstancePos(final AbstractSequence seq, final int ipos) {
        final int kind = seq.getNextKind(ipos);
        if (kind == 37) {
            return this.target == null || this.target.equals(seq.getNextTypeObject(ipos));
        }
        return kind == 32 && this.isInstance(seq.getPosNext(ipos));
    }
    
    @Override
    public boolean isInstance(final Object obj) {
        return coerceOrNull(obj, this.target) != null;
    }
    
    public static KProcessingInstruction coerceOrNull(final Object obj, final String target) {
        final KProcessingInstruction pos = (KProcessingInstruction)NodeType.coerceOrNull(obj, 32);
        return (pos != null && (target == null || target.equals(pos.getTarget()))) ? pos : null;
    }
    
    public static KProcessingInstruction coerce(final Object obj, final String target) {
        final KProcessingInstruction pos = coerceOrNull(obj, target);
        if (pos == null) {
            throw new ClassCastException();
        }
        return pos;
    }
    
    @Override
    protected void emitCoerceOrNullMethod(final Variable incoming, final Compilation comp) {
        final CodeAttr code = comp.getCode();
        if (incoming != null) {
            code.emitLoad(incoming);
        }
        code.emitPushString(this.target);
        code.emitInvokeStatic(ProcessingInstructionType.coerceOrNullMethod);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.target);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.target = (String)in.readObject();
    }
    
    @Override
    public String toString() {
        return "ProcessingInstructionType " + ((this.target == null) ? "*" : this.target);
    }
    
    static {
        piNodeTest = new ProcessingInstructionType((String)null);
        typeProcessingInstructionType = ClassType.make("gnu.kawa.xml.ProcessingInstructionType");
        coerceMethod = ProcessingInstructionType.typeProcessingInstructionType.getDeclaredMethod("coerce", 2);
        coerceOrNullMethod = ProcessingInstructionType.typeProcessingInstructionType.getDeclaredMethod("coerceOrNull", 2);
    }
}
