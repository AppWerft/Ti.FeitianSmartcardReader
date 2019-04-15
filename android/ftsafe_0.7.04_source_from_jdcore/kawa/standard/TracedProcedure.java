package kawa.standard;

import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.math.IntNum;
import java.io.IOException;
import java.io.PrintWriter;

public class TracedProcedure extends gnu.mapping.ProcedureN
{
  public Procedure proc;
  boolean enabled;
  static int indentationStep = 2;
  static Symbol curIndentSym = Symbol.makeUninterned("current-indentation");
  
  public TracedProcedure(Procedure proc, boolean enable)
  {
    this.proc = proc;
    enabled = enable;
    String name = proc.getName();
    if (name != null) {
      setName(name);
    }
  }
  
  static void put(Object value, PrintWriter out)
  {
    try {
      if (!gnu.kawa.functions.ObjectFormat.format(value, out, 50, true)) {
        out.print("...");
      }
    }
    catch (IOException ex) {
      out.print("<caught ");
      out.print(ex);
      out.print('>');
    }
  }
  
  static void indent(int i, PrintWriter out) {
    for (;;) { 
      if (i < 0) break;
      out.print(' ');
    }
  }
  
  public Object applyN(Object[] args) throws Throwable {
    if (enabled)
    {
      Environment env = Environment.getCurrent();
      Location curIndentLoc = env.getLocation(curIndentSym);
      Object oldIndent = curIndentLoc.get(null);
      int curIndent;
      if (!(oldIndent instanceof IntNum))
      {
        int curIndent = 0;
        curIndentLoc.set(IntNum.zero());
      }
      else {
        curIndent = ((IntNum)oldIndent).intValue(); }
      PrintWriter out = gnu.kawa.io.OutPort.errDefault();
      String name = getName();
      if (name == null) {
        name = "??";
      }
      
      indent(curIndent, out);
      out.print("call to ");
      out.print(name);
      int len = args.length;
      out.print(" (");
      for (int i = 0; i < len; i++)
      {
        if (i > 0)
          out.print(' ');
        put(args[i], out);
      }
      out.println(")");
      

      IntNum newIndentation = IntNum.make(curIndent + indentationStep);
      
      Object save = curIndentLoc.setWithSave(newIndentation);
      Object result;
      try {
        result = proc.applyN(args);
      }
      catch (RuntimeException e)
      {
        indent(curIndent, out);
        out.println("procedure " + name + " throws exception " + e);
        throw e;
      }
      finally
      {
        curIndentLoc.setRestore(save);
      }
      

      indent(curIndent, out);
      out.print("return from ");
      out.print(name);
      out.print(" => ");
      put(result, out);
      out.println();
      return result;
    }
    return proc.applyN(args);
  }
  
  public static Procedure doTrace(Procedure proc, boolean enable)
  {
    if ((proc instanceof TracedProcedure))
    {
      enabled = enable;
      return proc;
    }
    
    return new TracedProcedure(proc, enable);
  }
  
  public void print(PrintWriter ps)
  {
    ps.print("#<procedure ");
    String n = getName();
    if (n == null) {
      ps.print("<unnamed>");
    } else
      ps.print(n);
    ps.print(enabled ? ", traced>" : ">");
  }
}
