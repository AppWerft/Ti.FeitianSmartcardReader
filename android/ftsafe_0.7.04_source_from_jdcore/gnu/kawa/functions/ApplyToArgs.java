package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.lists.Sequences;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Promise;
import gnu.mapping.WrongArguments;
import java.util.List;

public class ApplyToArgs extends ProcedureN
{
  Language language;
  
  public int match1(Object arg1, CallContext ctx)
  {
    if ((arg1 instanceof Procedure)) {
      return ((Procedure)arg1).match0(ctx);
    }
    return super.match1(arg1, ctx);
  }
  
  public int match2(Object arg1, Object arg2, CallContext ctx)
  {
    if ((arg1 instanceof Procedure)) {
      return ((Procedure)arg1).match1(arg2, ctx);
    }
    return super.match2(arg1, arg2, ctx);
  }
  
  public int match3(Object arg1, Object arg2, Object arg3, CallContext ctx)
  {
    if ((arg1 instanceof Procedure)) {
      return ((Procedure)arg1).match2(arg2, arg3, ctx);
    }
    return super.match3(arg1, arg2, arg3, ctx);
  }
  

  public int match4(Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx)
  {
    if ((arg1 instanceof Procedure)) {
      return ((Procedure)arg1).match3(arg2, arg3, arg4, ctx);
    }
    return super.match4(arg1, arg2, arg3, arg4, ctx);
  }
  
  public int matchN(Object[] args, CallContext ctx)
  {
    int n = args.length;
    if ((n > 0) && ((args[0] instanceof Procedure)))
    {
      Procedure proc = (Procedure)args[0];
      switch (n)
      {
      case 1: 
        return proc.match0(ctx);
      case 2: 
        return proc.match1(args[1], ctx);
      case 3: 
        return proc.match2(args[1], args[2], ctx);
      case 4: 
        return proc.match3(args[1], args[2], args[3], ctx);
      case 5: 
        return proc.match4(args[1], args[2], args[3], args[4], ctx);
      }
      Object[] xargs = new Object[n - 1];
      System.arraycopy(args, 1, xargs, 0, n - 1);
      return proc.matchN(xargs, ctx);
    }
    
    return super.matchN(args, ctx);
  }
  
  public void check1(Object arg1, CallContext ctx)
  {
    if ((arg1 instanceof Procedure)) {
      ((Procedure)arg1).check0(ctx);
    } else {
      super.check1(arg1, ctx);
    }
  }
  
  public void check2(Object arg1, Object arg2, CallContext ctx) {
    if ((arg1 instanceof Procedure)) {
      ((Procedure)arg1).check1(arg2, ctx);
    } else {
      super.check2(arg1, arg2, ctx);
    }
  }
  
  public void check3(Object arg1, Object arg2, Object arg3, CallContext ctx) {
    if ((arg1 instanceof Procedure)) {
      ((Procedure)arg1).check2(arg2, arg3, ctx);
    } else {
      super.check3(arg1, arg2, arg3, ctx);
    }
  }
  
  public void check4(Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx)
  {
    if ((arg1 instanceof Procedure)) {
      ((Procedure)arg1).check3(arg2, arg3, arg4, ctx);
    } else {
      super.check4(arg1, arg2, arg3, arg4, ctx);
    }
  }
  
  public void checkN(Object[] args, CallContext ctx) {
    int code = matchN(args, ctx);
    if (code != 0)
    {
      Procedure proc = this;
      if ((args.length > 0) && ((args[0] instanceof Procedure)))
      {
        proc = (Procedure)args[0];
        Object[] xargs = new Object[args.length - 1];
        System.arraycopy(args, 1, xargs, 0, xargs.length);
        args = xargs;
      }
      throw gnu.mapping.MethodProc.matchFailAsException(code, proc, args);
    }
  }
  
  public ApplyToArgs(String name, Language language)
  {
    super(name);
    this.language = language;
    setProperty(Procedure.validateXApplyKey, "gnu.kawa.functions.CompilationHelpers:validateApplyToArgs");
  }
  

  public Object applyN(Object[] args)
    throws Throwable
  {
    Object proc = Promise.force(args[0]);
    if ((proc instanceof Procedure)) {
      Object[] rargs = new Object[args.length - 1];
      System.arraycopy(args, 1, rargs, 0, rargs.length);
      return ((Procedure)proc).applyN(rargs);
    }
    if (((proc instanceof gnu.bytecode.Type)) || ((proc instanceof Class)))
    {
      return gnu.kawa.reflect.Invoke.make.applyN(args);
    }
    if ((proc instanceof CharSequence)) {
      if (args.length != 2)
        throw new WrongArguments(this, args.length);
      Object index = Promise.force(args[1]);
      gnu.lists.IntSequence indexes = Sequences.asIntSequenceOrNull(index);
      CharSequence str = (CharSequence)proc;
      if (indexes != null) {
        return gnu.lists.Strings.indirectIndexed(str, indexes);
      }
      int iindex = ((Number)index).intValue();
      return gnu.text.Char.valueOf(gnu.lists.Strings.characterAt(str, iindex));
    }
    
    if ((proc instanceof gnu.lists.Array)) {
      return gnu.lists.ComposedArray.generalIndex((gnu.lists.Array)proc, false, 1, args.length - 1, args);
    }
    
    if ((proc instanceof List)) {
      if (args.length != 2)
        throw new WrongArguments(this, args.length);
      List lst = (List)proc;
      Object arg1 = Promise.force(args[1]);
      gnu.lists.IntSequence indexes = Sequences.asIntSequenceOrNull(arg1);
      if (indexes != null) {
        return Sequences.indirectIndexed(lst, indexes);
      }
      int index = ((Number)arg1).intValue();
      return lst.get(index);
    }
    











    Class pclass = proc.getClass();
    if (pclass.isArray()) {
      if (args.length != 2)
        throw new WrongArguments(this, args.length);
      return java.lang.reflect.Array.get(proc, ((Number)args[1]).intValue());
    }
    throw new gnu.mapping.WrongType(this, 0, proc, "procedure");
  }
}
