package gnu.kawa.functions;

import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequences;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Values;
import java.util.Iterator;




public class Map
  extends ProcedureN
{
  boolean collect;
  final ApplyToArgs applyToArgs;
  final IsEq isEq;
  
  public Map(boolean collect, ApplyToArgs applyToArgs, IsEq isEq)
  {
    super(collect ? "map" : "for-each");
    this.collect = collect;
    this.applyToArgs = applyToArgs;
    this.isEq = isEq;
    setProperty(Procedure.validateApplyKey, collect ? "kawa.lib.compile_map:listMapValidateApply" : "kawa.lib.compile_map:listForEachValidateApply");
  }
  

  public static Object map1(Procedure proc, LList list)
    throws Throwable
  {
    Object cur = list;
    Object result = LList.Empty;
    Pair last = null;
    while (cur != LList.Empty) {
      Pair pair = (Pair)cur;
      Pair new_pair = new Pair(proc.apply1(pair.getCar()), LList.Empty);
      if (last == null) {
        result = new_pair;
      } else
        last.setCdr(new_pair);
      last = new_pair;
      cur = pair.getCdr();
    }
    return result;
  }
  
  public static Object map1(Procedure proc, Object list) throws Throwable {
    if ((list instanceof LList)) {
      return map1(proc, (LList)list);
    }
    Object result = LList.Empty;
    Pair last = null;
    for (Iterator it = Sequences.getIterator(list); it.hasNext();) {
      Pair new_pair = new Pair(proc.apply1(it.next()), LList.Empty);
      if (last == null) {
        result = new_pair;
      } else
        last.setCdr(new_pair);
      last = new_pair;
    }
    return result;
  }
  
  public static void forEach1(Procedure proc, LList list)
    throws Throwable
  {
    for (Object cur = list; cur != LList.Empty;) {
      Pair pair = (Pair)cur;
      proc.apply1(pair.getCar());
      cur = pair.getCdr();
    }
  }
  
  public static void forEach1(Procedure proc, Object list) throws Throwable {
    Iterator it;
    if ((list instanceof LList)) {
      forEach1(proc, (LList)list);
    } else {
      for (it = Sequences.getIterator(list); it.hasNext();)
        proc.apply1(it.next());
    }
  }
  
  public Object apply2(Object arg1, Object arg2) throws Throwable {
    if ((arg1 instanceof Procedure))
    {
      Procedure proc = (Procedure)arg1;
      if (collect)
        return map1(proc, arg2);
      forEach1(proc, arg2);
      return Values.empty;
    }
    return applyN(new Object[] { arg1, arg2 });
  }
  
  public Object applyN(Object[] args) throws Throwable {
    int arity = args.length - 1;
    if ((arity == 1) && ((args[0] instanceof Procedure))) {
      Procedure proc = (Procedure)args[0];
      if (collect)
        return map1(proc, args[1]);
      forEach1(proc, args[1]);
      return Values.empty;
    }
    
    Pair last = null;
    Object result; Object result; if (collect) {
      result = LList.Empty;
    } else
      result = Values.empty;
    Procedure proc;
    int need_apply;
    Object[] each_args;
    Procedure proc; if ((args[0] instanceof Procedure)) {
      int need_apply = 0;
      Object[] each_args = new Object[arity];
      proc = (Procedure)args[0];
    } else {
      need_apply = 1;
      each_args = new Object[arity + 1];
      each_args[0] = args[0];
      proc = applyToArgs;
    }
    Iterator[] iterators = new Iterator[arity];
    for (int i = 0; i < arity; i++)
      iterators[i] = Sequences.getIterator(args[(i + 1)]);
    for (;;) {
      for (int i = 0; i < arity; i++) {
        Iterator it = iterators[i];
        if (!it.hasNext())
          return result;
        each_args[(need_apply + i)] = it.next();
      }
      Object value = proc.applyN(each_args);
      if (collect) {
        Pair new_pair = new Pair(value, LList.Empty);
        if (last == null) {
          result = new_pair;
        } else
          last.setCdr(new_pair);
        last = new_pair;
      }
    }
  }
  
  public int numArgs() { return 61442; }
}
