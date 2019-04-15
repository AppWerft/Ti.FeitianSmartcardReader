package kawa.standard;

import gnu.bytecode.Type;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Translator;

public class prim_method extends kawa.lang.Syntax
{
  public static final prim_method virtual_method = new prim_method(182); public static final prim_method static_method;
  static { virtual_method.setName("primitive-virtual-method");
    
    static_method = new prim_method(184);
    static_method.setName("primitive-static-method");
    
    interface_method = new prim_method(185);
    interface_method.setName("primitive-interface-method");
    
    op1 = new prim_method();
    op1.setName("primitive-op1"); }
  
  public static final prim_method interface_method; public static final prim_method op1; private static kawa.lang.Pattern pattern3 = new kawa.lang.ListPat(3);
  private static kawa.lang.Pattern pattern4 = new kawa.lang.ListPat(4);
  int op_code;
  
  int opcode() {
    return op_code;
  }
  
  public prim_method(int opcode) {
    op_code = opcode;
  }
  




  public gnu.expr.Expression rewrite(Object obj, Translator tr)
  {
    Object[] match = new Object[4];
    if (op_code == 0 ? !pattern3.match(obj, match, 1) : !pattern4.match(obj, match, 0))
    {
      return tr.syntaxError("wrong number of arguments to " + getName() + "(opcode:" + op_code + ")");
    }
    
    if (!(match[3] instanceof LList))
      return tr.syntaxError("missing/invalid parameter list in " + getName());
    LList argp = (LList)match[3];
    
    int narg = argp.size();
    Type[] args = new Type[narg];
    for (int i = 0; i < narg; i++)
    {
      Pair p = (Pair)argp;
      args[i] = tr.exp2Type(p);
      argp = (LList)p.getCdr();
    }
    Type rtype = tr.exp2Type(new Pair(match[2], null));
    gnu.expr.PrimProcedure proc;
    gnu.expr.PrimProcedure proc; if (op_code == 0)
    {
      int opcode = ((Number)match[1]).intValue();
      proc = new gnu.expr.PrimProcedure(opcode, rtype, args);
    }
    else
    {
      gnu.bytecode.ClassType cl = null;
      Type ctype = tr.exp2Type((Pair)obj);
      if (ctype != null) {
        ctype = ctype.getImplementationType();
      }
      try {
        cl = (gnu.bytecode.ClassType)ctype;
        cl.getReflectClass();
      }
      catch (Exception ex) {
        char code;
        char code;
        if (cl == null) {
          code = 'e';
        }
        else {
          code = 'w';
          cl.setExisting(false);
        }
        tr.error(code, "unknown class: " + match[0]);
      }
      Pair p;
      if (((match[1] instanceof Pair)) && ((p = (Pair)match[1]).getCar() == "quote"))
      {
        match[1] = ((Pair)p.getCdr()).getCar(); }
      proc = new gnu.expr.PrimProcedure(op_code, cl, match[1].toString(), rtype, args);
    }
    
    return new gnu.expr.QuoteExp(proc);
  }
  
  public prim_method() {}
}
