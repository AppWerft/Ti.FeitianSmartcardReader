package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class NamedPart extends gnu.mapping.ProcedureN implements gnu.mapping.HasSetter, java.io.Externalizable
{
  Object container;
  Object member;
  char kind;
  MethodProc methods;
  
  public NamedPart(Object container, Object member, char kind)
  {
    this.container = container;
    this.member = member;
    this.kind = kind;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateNamedPart");
  }
  


  public NamedPart(Object container, String mname, char kind, MethodProc methods)
  {
    this(container, mname, kind);
    this.methods = methods;
  }
  
  public int numArgs()
  {
    if ((kind == 'I') || (kind == 'C'))
      return 4097;
    if (kind == 'D')
      return 4096;
    return 61440;
  }
  
  public void apply(CallContext ctx) throws Throwable
  {
    apply(ctx.getArgs(), ctx);
  }
  

  public void apply(Object[] args, CallContext ctx)
    throws Throwable
  {
    if (kind == 'S') {
      methods.checkN(args, ctx);
    } else if (kind == 'M')
    {
      int nargs = args.length;
      Object[] xargs = new Object[nargs + 1];
      xargs[0] = container;
      System.arraycopy(args, 0, xargs, 1, nargs);
      methods.checkN(xargs, ctx);
    }
    else {
      ctx.writeValue(applyN(args));
    }
  }
  
  public Object applyN(Object[] args)
    throws Throwable
  {
    Object[] xargs;
    switch (kind)
    {
    case 'I': 
      return kawa.standard.Scheme.instanceOf.apply2(args[0], container);
    case 'C': 
      return Convert.cast.apply2(container, args[0]);
    case 'N': 
      xargs = new Object[args.length + 1];
      xargs[0] = container;
      System.arraycopy(args, 0, xargs, 1, args.length);
      return gnu.kawa.reflect.Invoke.make.applyN(xargs);
    case 'S': 
      return methods.applyN(args);
    case 'M': 
      xargs = new Object[args.length + 1];
      xargs[0] = container;
      System.arraycopy(args, 0, xargs, 1, args.length);
      return methods.applyN(xargs);
    case 'D': 
      String fname = member.toString().substring(1);
      if (args.length == 0) {
        return gnu.kawa.reflect.SlotGet.staticField((gnu.bytecode.ClassType)container, fname);
      }
      return gnu.kawa.reflect.SlotGet.field(((Type)container).coerceFromObject(args[0]), fname);
    }
    throw new Error("unknown part " + member + " in " + container);
  }
  
  public Procedure getSetter()
  {
    if (kind == 'D') {
      return new Setter(this);
    }
    throw new RuntimeException("procedure '" + getName() + "' has no setter");
  }
  
  public void set0(Object value) throws Throwable
  {
    switch (kind)
    {
    case 'D': 
      String fname = member.toString().substring(1);
      gnu.kawa.reflect.SlotSet.setStaticField((gnu.bytecode.ClassType)container, fname, value);
      return;
    }
    throw new Error("invalid setter for " + this);
  }
  
  public void set1(Object object, Object value)
    throws Throwable
  {
    switch (kind)
    {
    case 'D': 
      String fname = member.toString().substring(1);
      object = ((Type)container).coerceFromObject(object);
      gnu.kawa.reflect.SlotSet.setField(object, fname, value);
      return;
    }
    throw new Error("invalid setter for " + this);
  }
  
  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(container);
    out.writeObject(member);
    out.writeChar(kind);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    kind = in.readChar();
    container = ((Procedure)in.readObject());
    member = ((Procedure)in.readObject());
  }
  
  public static class Setter
    extends gnu.mapping.Setter implements java.io.Externalizable
  {
    public Setter(NamedPart getter)
    {
      super();
      setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateNamedPartSetter");
    }
    

    public int numArgs()
    {
      if (getter).kind == 'D')
        return 8193;
      return 61440;
    }
    
    Procedure getGetter() { return getter; }
    
    public void writeExternal(ObjectOutput out) throws IOException
    {
      out.writeObject(getter);
    }
    
    public void readExternal(ObjectInput in)
      throws IOException, ClassNotFoundException
    {
      getter = ((Procedure)in.readObject());
    }
  }
}
