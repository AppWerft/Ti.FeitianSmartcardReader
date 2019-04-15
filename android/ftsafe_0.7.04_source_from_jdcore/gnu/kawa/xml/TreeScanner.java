package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public abstract class TreeScanner
  extends MethodProc implements Externalizable
{
  public NodePredicate type;
  
  TreeScanner()
  {
    setProperty(Procedure.validateApplyKey, "gnu.kawa.xml.CompileXmlFunctions:validateApplyTreeScanner");
  }
  

  public NodePredicate getNodePredicate()
  {
    return type;
  }
  
  public abstract void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer);
  
  public int numArgs() { return 4097; }
  
  public void apply(CallContext ctx) throws Throwable
  {
    PositionConsumer out = (PositionConsumer)consumer;
    Object node = ctx.getNextArg();
    ctx.lastArg();
    KNode spos;
    try
    {
      spos = (KNode)node;
    }
    catch (ClassCastException ex)
    {
      throw new WrongType(getDesc(), -4, node, "node()");
    }
    scan(sequence, spos.getPos(), out);
  }
  
  public void writeExternal(ObjectOutput out) throws IOException
  {
    out.writeObject(type);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    type = ((NodePredicate)in.readObject());
  }
  
  public String getDesc()
  {
    String thisName = getClass().getName();
    int dot = thisName.lastIndexOf('.');
    if (dot > 0)
      thisName = thisName.substring(dot + 1);
    return thisName + "::" + type;
  }
  
  public String toString()
  {
    return "#<" + getClass().getName() + ' ' + type + '>';
  }
}
