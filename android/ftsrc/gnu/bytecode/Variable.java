package gnu.bytecode;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class Variable
  extends Location
  implements Enumeration
{
  Variable next;
  
  public final Variable nextVar() { return next; }
  public final boolean hasMoreElements() { return next != null; }
  
  public Object nextElement() {
    if (next == null)
      throw new NoSuchElementException("Variable enumeration");
    return next;
  }
  

  public Variable() {}
  

  public Variable(String name)
  {
    setName(name);
  }
  
  public Variable(String name, Type type)
  {
    setName(name);
    setType(type);
  }
  
  private int flags = 1;
  
  private static final int SIMPLE_FLAG = 1;
  
  private static final int PARAMETER_FLAG = 2;
  
  private static final int LIVE_FLAG = 4;
  
  static final int UNASSIGNED = -1;
  
  int offset = -1;
  private Scope scope;
  
  public final boolean isAssigned() { return offset != -1; }
  

  public Scope getScope() { return scope; }
  void setScope(Scope scope) { this.scope = scope; }
  
  public final boolean dead() { return (flags & 0x4) == 0; }
  
  private void setFlag(boolean setting, int flag)
  {
    if (setting) flags |= flag; else {
      flags &= (flag ^ 0xFFFFFFFF);
    }
  }
  





  public final boolean isSimple()
  {
    return (flags & 0x1) != 0;
  }
  
  public final void setSimple(boolean simple) {
    setFlag(simple, 1);
  }
  
  public final boolean isParameter() {
    return (flags & 0x2) != 0;
  }
  
  public final void setParameter(boolean parameter)
  {
    setFlag(parameter, 2);
  }
  



  public boolean reserveLocal(int varIndex, CodeAttr code)
  {
    int size = getType().getSizeInWords();
    if (locals.used == null) {
      locals.used = new Variable[20 + size];
    } else if (code.getMaxLocals() + size >= locals.used.length) {
      Variable[] new_locals = new Variable[2 * locals.used.length + size];
      System.arraycopy(locals.used, 0, new_locals, 0, code.getMaxLocals());
      locals.used = new_locals;
    }
    for (int j = 0; j < size; j++)
    {
      if (locals.used[(varIndex + j)] != null)
        return false;
    }
    for (int j = 0; j < size; j++)
      locals.used[(varIndex + j)] = this;
    if (varIndex + size > code.getMaxLocals())
      code.setMaxLocals(varIndex + size);
    offset = varIndex;
    flags |= 0x4;
    if (offset == 0)
    {


      if ("<init>".equals(code.getMethod().getName()))
        setType(local_types[0]);
    }
    return true;
  }
  



  public void allocateLocal(CodeAttr code)
  {
    if (offset != -1)
      return;
    for (int i = 0;; i++)
    {
      if (reserveLocal(i, code)) {
        return;
      }
    }
  }
  
  public void freeLocal(CodeAttr code) {
    flags &= 0xFFFFFFFB;
    int size = getTypesize > 4 ? 2 : 1;
    int vnum = offset + size; for (;;) { vnum--; if (vnum < offset)
        break;
      locals.used[vnum] = null;
      Type[] local_types = local_types;
      if ((local_types != null) && (vnum < local_types.length)) {
        local_types[vnum] = null;
      }
    }
  }
  
  boolean shouldEmit() {
    Scope sc = scope;
    Label start;
    int pos;
    Label end; return (isSimple()) && (name != null) && (sc != null) && ((start = start) != null) && ((pos = position) >= 0) && ((end = end) != null) && (position > pos);
  }
  




  public String toString()
  {
    return "Variable[" + getName() + " offset:" + offset + ']';
  }
}
