package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;








public class LocalVarsAttr
  extends Attribute
{
  private Method method;
  Variable[] used;
  public Scope current_scope;
  Scope parameter_scope;
  
  public LocalVarsAttr(CodeAttr code)
  {
    super("LocalVariableTable");
    addToFrontOf(code);
    method = ((Method)code.getContainer());
    locals = this;
  }
  

  public LocalVarsAttr(Method method)
  {
    super("LocalVariableTable");
    CodeAttr code = code;
    this.method = method;
    locals = this;
  }
  
  public final Method getMethod() { return method; }
  
  public VarEnumerator allVars()
  {
    return new VarEnumerator(parameter_scope);
  }
  
  public void enterScope(Scope scope) {
    scope.linkChild(current_scope);
    current_scope = scope;
    CodeAttr code = method.getCode();
    for (Variable var = scope.firstVar(); var != null; var = var.nextVar())
    {
      if (var.isSimple())
      {
        if (!var.isAssigned()) {
          var.allocateLocal(code);
        } else if (used[offset] == null) {
          used[offset] = var;
        } else if (used[offset] != var) {
          throw new Error("inconsistent local variable assignments for " + var + " != " + used[offset]);
        }
      }
    }
  }
  




  public void preserveVariablesUpto(Scope scope)
  {
    for (Scope cur = current_scope; cur != scope; cur = parent) {
      preserved = true;
    }
  }
  
  public final boolean isEmpty() {
    VarEnumerator vars = allVars();
    Variable var;
    while ((var = vars.nextVar()) != null)
    {
      if ((var.isSimple()) && (name != null))
        return false;
    }
    return true;
  }
  
  public final int getCount()
  {
    int local_variable_count = 0;
    VarEnumerator vars = allVars();
    Variable var;
    while ((var = vars.nextVar()) != null)
    {
      if (var.shouldEmit())
        local_variable_count++;
    }
    return local_variable_count;
  }
  
  public final int getLength()
  {
    return 2 + 10 * getCount();
  }
  
  public void assignConstants(ClassType cl)
  {
    super.assignConstants(cl);
    
    VarEnumerator vars = allVars();
    Variable var;
    while ((var = vars.nextVar()) != null)
    {
      if ((var.isSimple()) && (name != null))
      {
        if (name_index == 0)
          name_index = getConstantsaddUtf8getNameindex;
        if (signature_index == 0) {
          signature_index = getConstantsaddUtf8getTypegetSignatureindex;
        }
      }
    }
  }
  
  public void write(DataOutputStream dstr) throws IOException
  {
    VarEnumerator vars = allVars();
    
    dstr.writeShort(getCount());
    Variable var;
    for (vars.reset(); (var = vars.nextVar()) != null;)
    {
      if (var.shouldEmit())
      {
        Scope scope = var.getScope();
        int start_pc = start.position;
        int end_pc = end.position;
        dstr.writeShort(start_pc);
        dstr.writeShort(end_pc - start_pc);
        dstr.writeShort(name_index);
        dstr.writeShort(signature_index);
        dstr.writeShort(offset);
      }
    }
  }
  
  public void print(ClassTypeWriter dst)
  {
    VarEnumerator vars = allVars();
    dst.print("Attribute \"");
    dst.print(getName());
    dst.print("\", length:");
    dst.print(getLength());
    dst.print(", count: ");
    dst.println(getCount());
    
    Variable var;
    for (vars.reset(); (var = vars.nextVar()) != null;)
    {
      if ((var.isSimple()) && (name != null))
      {
        dst.print("  slot#");
        dst.print(offset);
        dst.print(": name: ");
        dst.printOptionalIndex(name_index);
        dst.print(var.getName());
        dst.print(", type: ");
        dst.printOptionalIndex(signature_index);
        dst.printSignature(var.getType());
        dst.print(" (pc: ");
        Scope scope = var.getScope();
        int start_pc;
        int end_pc; if ((scope == null) || (start == null) || (end == null) || ((start_pc = start.position) < 0) || ((end_pc = end.position) < 0))
        {

          dst.print("unknown");
        } else { int end_pc;
          int start_pc;
          dst.print(start_pc);
          dst.print(" length: ");
          dst.print(end_pc - start_pc);
        }
        dst.println(')');
      }
    }
  }
}
