package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.lists.AbstractSequence;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class NodeType extends ObjectType implements gnu.expr.TypeValue, gnu.lists.NodePredicate, java.io.Externalizable
{
  public static final int TEXT_OK = 1;
  public static final int ELEMENT_OK = 2;
  public static final int ATTRIBUTE_OK = 4;
  public static final int DOCUMENT_OK = 8;
  public static final int COMMENT_OK = 16;
  public static final int PI_OK = 32;
  int kinds = -1;
  
  public NodeType(String name, int kinds)
  {
    super(name);
    this.kinds = kinds;
  }
  
  public NodeType(String name)
  {
    this(name, -1);
  }
  
  public void emitCoerceFromObject(CodeAttr code)
  {
    code.emitPushInt(kinds);
    code.emitInvokeStatic(coerceMethod);
  }
  
  public Expression convertValue(Expression value)
  {
    ApplyExp aexp = new ApplyExp(coerceMethod, new Expression[] { value });
    aexp.setType(this);
    return aexp;
  }
  
  public Object coerceFromObject(Object obj)
  {
    return coerceForce(obj, kinds);
  }
  
  public Type getImplementationType()
  {
    return typeKNode;
  }
  
  public int compare(Type other)
  {
    return getImplementationType().compare(other);
  }
  
  public boolean isInstance(Object obj) {
    return isInstance(obj, kinds);
  }
  
  static boolean isInstance(Object obj, int kinds) {
    if ((obj instanceof KNode)) {
      KNode pos = (KNode)obj;
      return isInstance(sequence, pos.getPos(), kinds);
    }
    return false;
  }
  
  public boolean isInstancePos(AbstractSequence seq, int ipos)
  {
    return isInstance(seq, ipos, kinds);
  }
  
  public static boolean isInstance(AbstractSequence seq, int ipos, int kinds)
  {
    int kind = seq.getNextKind(ipos);
    if (kinds < 0) {
      return kind != 0;
    }
    
    switch (kind)
    {
    case 0: 
      return false;
    case 32: 
      return isInstance(seq.getPosNext(ipos), kinds);
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
      return (kinds & 0x1) != 0;
    case 33: 
      return (kinds & 0x2) != 0;
    case 35: 
      return (kinds & 0x4) != 0;
    case 34: 
      return (kinds & 0x8) != 0;
    case 36: 
      return (kinds & 0x10) != 0;
    case 37: 
      return (kinds & 0x20) != 0;
    }
    
    return true;
  }
  
  public static KNode coerceForce(Object obj, int kinds)
  {
    KNode pos = coerceOrNull(obj, kinds);
    if (pos == null)
      throw new ClassCastException("coerce from " + obj.getClass());
    return pos;
  }
  
  public static KNode coerceOrNull(Object obj, int kinds)
  {
    KNode pos;
    if ((obj instanceof gnu.xml.NodeTree)) {
      pos = KNode.make((gnu.xml.NodeTree)obj); } else { KNode pos;
      if ((obj instanceof KNode)) {
        pos = (KNode)obj;
      } else
        return null; }
    KNode pos; return isInstance(sequence, ipos, kinds) ? pos : null;
  }
  

  protected void emitCoerceOrNullMethod(Variable incoming, Compilation comp)
  {
    CodeAttr code = comp.getCode();
    if (incoming != null)
      code.emitLoad(incoming);
    code.emitPushInt(kinds);
    code.emitInvokeStatic(coerceOrNullMethod);
  }
  
  public void emitTestIf(Variable incoming, Declaration decl, Compilation comp)
  {
    CodeAttr code = comp.getCode();
    emitCoerceOrNullMethod(incoming, comp);
    if (decl != null)
    {
      code.emitDup();
      decl.compileStore(comp);
    }
    code.emitIfNotNull();
  }
  

  public void emitIsInstance(Variable incoming, Compilation comp, gnu.expr.Target target)
  {
    if ((target instanceof ConditionalTarget))
    {
      ConditionalTarget ctarget = (ConditionalTarget)target;
      emitCoerceOrNullMethod(incoming, comp);
      CodeAttr code = comp.getCode();
      if (trueBranchComesFirst) {
        code.emitGotoIfCompare1(ifFalse, 198);
      } else
        code.emitGotoIfCompare1(ifTrue, 199);
      ctarget.emitGotoFirstBranch(code);
    }
    else {
      gnu.kawa.reflect.InstanceOf.emitIsInstance(this, incoming, comp, target);
    } }
  
  public static final ClassType typeKNode = ClassType.make("gnu.kawa.xml.KNode");
  public static final ClassType typeNodeType = ClassType.make("gnu.kawa.xml.NodeType");
  public static final NodeType nodeType = new NodeType("gnu.kawa.xml.KNode");
  static final Method coerceMethod = typeNodeType.getDeclaredMethod("coerceForce", 2);
  
  static final Method coerceOrNullMethod = typeNodeType.getDeclaredMethod("coerceOrNull", 2);
  

  public gnu.mapping.Procedure getConstructor()
  {
    return null;
  }
  
  public String toString()
  {
    return "NodeType " + getName();
  }
  
  public void writeExternal(ObjectOutput out) throws java.io.IOException
  {
    String name = getName();
    out.writeUTF(name == null ? "" : name);
    out.writeInt(kinds);
  }
  
  public void readExternal(ObjectInput in)
    throws java.io.IOException, ClassNotFoundException
  {
    String name = in.readUTF();
    if (name.length() > 0)
      setName(name);
    kinds = in.readInt();
  }
  
  public String encodeType(Language language) {
    return null;
  }
  
  public static final NodeType documentNodeTest = new NodeType("document-node", 8);
  
  public static final NodeType textNodeTest = new NodeType("text", 1);
  
  public static final NodeType commentNodeTest = new NodeType("comment", 16);
  
  public static final NodeType anyNodeTest = new NodeType("node");
}
