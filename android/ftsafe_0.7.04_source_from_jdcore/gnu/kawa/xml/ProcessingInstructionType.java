package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.TypeValue;
import gnu.lists.AbstractSequence;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ProcessingInstructionType extends NodeType implements TypeValue, java.io.Externalizable
{
  String target;
  public static final ProcessingInstructionType piNodeTest = new ProcessingInstructionType(null);
  

  public ProcessingInstructionType(String target)
  {
    super("processing-instruction(" + target + ")");
    
    this.target = target;
  }
  
  public static ProcessingInstructionType getInstance(String target)
  {
    return target == null ? piNodeTest : new ProcessingInstructionType(target);
  }
  
  public gnu.bytecode.Type getImplementationType()
  {
    return ClassType.make("gnu.kawa.xml.KProcessingInstruction");
  }
  

  public void emitCoerceFromObject(CodeAttr code)
  {
    code.emitPushString(target);
    code.emitInvokeStatic(coerceMethod);
  }
  
  public Object coerceFromObject(Object obj)
  {
    return coerce(obj, target);
  }
  
  public boolean isInstancePos(AbstractSequence seq, int ipos)
  {
    int kind = seq.getNextKind(ipos);
    if (kind == 37)
      return (target == null) || (target.equals(seq.getNextTypeObject(ipos)));
    if (kind == 32)
      return isInstance(seq.getPosNext(ipos));
    return false;
  }
  
  public boolean isInstance(Object obj)
  {
    return coerceOrNull(obj, target) != null;
  }
  
  public static KProcessingInstruction coerceOrNull(Object obj, String target)
  {
    KProcessingInstruction pos = (KProcessingInstruction)NodeType.coerceOrNull(obj, 32);
    
    return (pos != null) && ((target == null) || (target.equals(pos.getTarget()))) ? pos : null;
  }
  

  public static KProcessingInstruction coerce(Object obj, String target)
  {
    KProcessingInstruction pos = coerceOrNull(obj, target);
    if (pos == null)
      throw new ClassCastException();
    return pos;
  }
  
  protected void emitCoerceOrNullMethod(Variable incoming, Compilation comp)
  {
    CodeAttr code = comp.getCode();
    if (incoming != null)
      code.emitLoad(incoming);
    code.emitPushString(target);
    code.emitInvokeStatic(coerceOrNullMethod);
  }
  
  public static final ClassType typeProcessingInstructionType = ClassType.make("gnu.kawa.xml.ProcessingInstructionType");
  
  static final Method coerceMethod = typeProcessingInstructionType.getDeclaredMethod("coerce", 2);
  
  static final Method coerceOrNullMethod = typeProcessingInstructionType.getDeclaredMethod("coerceOrNull", 2);
  
  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(target);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    target = ((String)in.readObject());
  }
  
  public String toString()
  {
    return "ProcessingInstructionType " + (target == null ? "*" : target);
  }
}
