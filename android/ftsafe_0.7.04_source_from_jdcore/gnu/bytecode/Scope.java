package gnu.bytecode;

import java.util.HashMap;








public class Scope
{
  Scope parent;
  Scope nextSibling;
  Scope firstChild;
  Scope lastChild;
  boolean preserved;
  boolean autoPop;
  Label start;
  Label end;
  Variable vars;
  Variable last_var;
  
  public Scope() {}
  
  public Scope(Label start, Label end)
  {
    this.start = start;
    this.end = end;
  }
  

  public final Variable firstVar() { return vars; }
  
  public VarEnumerator allVars() { return new VarEnumerator(this); }
  
  public Label getStartLabel() { return start; }
  public Label getEndLabel() { return end; }
  

  public void linkChild(Scope parent)
  {
    this.parent = parent;
    if (parent == null)
      return;
    if (lastChild == null) {
      firstChild = this;
    } else
      lastChild.nextSibling = this;
    lastChild = this;
  }
  
  public Variable addVariable(CodeAttr code, Type type, String name)
  {
    Variable var = new Variable(name, type);
    addVariable(code, var);
    return var;
  }
  
  public void addVariable(Variable var)
  {
    if (last_var == null) {
      vars = var;
    } else
      last_var.next = var;
    last_var = var;
    var.setScope(this);
  }
  

  public void addVariableAfter(Variable prev, Variable var)
  {
    if (prev == null)
    {
      next = vars;
      vars = var;
    }
    else
    {
      next = next;
      next = var;
    }
    if (last_var == prev)
      last_var = var;
    if (next == var)
      throw new Error("cycle");
    var.setScope(this);
  }
  
  public void addVariable(CodeAttr code, Variable var)
  {
    addVariable(var);
    if ((var.isSimple()) && (code != null)) {
      var.allocateLocal(code);
    }
  }
  


  public Variable getVariable(int index)
  {
    Variable var = vars;
    for (;;) { index--; if (index < 0) break;
      var = next; }
    return var;
  }
  


  public void fixParamNames(HashMap<String, Variable> map)
  {
    for (Variable var = firstVar(); var != null; 
        var = var.nextVar()) {
      String name = var.getName();
      if (name != null) {
        String xname = name;
        Variable old;
        for (int i = 0; (old = (Variable)map.get(xname)) != null; i++)
          xname = name + '$' + i;
        if (name != xname)
          var.setName(xname);
        map.put(xname, var);
      }
    }
  }
  
  static boolean equals(byte[] name1, byte[] name2)
  {
    if (name1.length != name2.length)
      return false;
    if (name1 == name2)
      return true;
    int i = name1.length; do { i--; if (i < 0) break;
    } while (name1[i] == name2[i]);
    return false;
    return true;
  }
  
  public void setStartPC(CodeAttr code)
  {
    if (start == null)
      start = new Label();
    boolean reachable = code.reachableHere();
    start.define(code);
    code.setReachable(reachable);
  }
  

  public void noteStartFunction(CodeAttr code)
  {
    setStartPC(code);
  }
  




  public Variable lookup(String name)
  {
    for (Variable var = vars; var != null; var = next) {
      if (name.equals(name))
        return var;
    }
    return null;
  }
  



  void freeLocals(CodeAttr code)
  {
    if (preserved)
      return;
    for (Variable var = vars; var != null; var = next)
    {
      if ((var.isSimple()) && (!var.dead()))
        var.freeLocal(code);
    }
    for (Scope child = firstChild; child != null; child = nextSibling)
    {
      if (preserved)
      {
        preserved = false;
        child.freeLocals(code);
      }
    }
  }
}
