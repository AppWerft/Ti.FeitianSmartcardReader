package kawa.standard;

import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongType;

public class vector_append
  extends ProcedureN
{
  public static final vector_append vectorAppend = new vector_append("vector-append");
  

  public vector_append(String name)
  {
    super(name);
  }
  
  public Object applyN(Object[] args)
  {
    return apply$V(args);
  }
  
  public static FVector apply$V(Object[] args) {
    return new FVector(appendToArray(args));
  }
  
  public static Object[] appendToArray(Object[] args)
  {
    int length = 0;
    int args_length = args.length;
    int i = args_length; for (;;) { i--; if (i < 0)
        break;
      Object arg = args[i];
      if ((arg instanceof FVector)) {
        length += ((FVector)arg).size();
      }
      else {
        int n = LList.listLength(arg, false);
        if (n < 0)
          throw new WrongType(vectorAppend, i, arg, "list or vector");
        length += n;
      }
    }
    Object[] result = new Object[length];
    int position = 0;
    for (int i = 0; i < args_length; i++)
    {
      Object arg = args[i];
      if ((arg instanceof FVector))
      {
        FVector vec = (FVector)arg;
        int vec_length = vec.size();
        for (int j = 0; j < vec_length; j++) {
          result[(position++)] = vec.get(j);
        }
      } else if ((arg instanceof Pair))
      {
        while (arg != LList.Empty)
        {
          Pair pair = (Pair)arg;
          result[(position++)] = pair.getCar();
          arg = pair.getCdr();
        }
      }
    }
    return result;
  }
}
