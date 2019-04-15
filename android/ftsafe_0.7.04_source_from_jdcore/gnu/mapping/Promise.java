package gnu.mapping;

import gnu.kawa.format.Printable;
import gnu.lists.Consumer;
import java.io.IOException;









public class Promise<T>
  implements Printable, Lazy<T>
{
  Procedure thunk;
  boolean forceValueIfPromise;
  
  public void setForceValueIfPromise(boolean value)
  {
    forceValueIfPromise = value;
  }
  

  private volatile Object result = Location.UNBOUND;
  


  private Throwable throwable;
  



  public Promise() {}
  


  public Promise(Procedure thunk)
  {
    this.thunk = thunk;
  }
  
  public static <T> Lazy<T> makeBoundPromise(T value)
  {
    Promise<T> p = new Promise(null);
    result = value;
    return p;
  }
  
  public static Lazy<Object> coerceToLazy(Object value) {
    if ((value instanceof Lazy))
      return (Lazy)value;
    Promise<Object> p = new Promise(null);
    result = value;
    return p;
  }
  
  public synchronized T getValue()
  {
    Object r;
    synchronized (this) {
      for (;;) { if (isBlank()) {
          try {
            wait();
          }
          catch (InterruptedException ex) {}
        }
        else {
          r = result;
          if ((r != Location.UNBOUND) || (throwable != null))
            break label144;
          try {
            r = thunk.apply0();
            if (result == Location.UNBOUND) {
              result = r;
            } else
              r = result;
            if ((forceValueIfPromise) && ((r instanceof Promise))) {
              Promise pr = (Promise)r;
              synchronized (r) {
                if (!pr.isBlank()) {
                  moveFrom(pr);
                }
              }
            }
          }
          catch (Throwable ex) {
            throwable = ex;
          } } }
      thunk = null;
      label144:
      if (throwable != null)
        WrappedException.rethrow(throwable);
    }
    if ((forceValueIfPromise) && ((r instanceof Lazy)))
      return ((Lazy)r).getValue();
    return r;
  }
  



  private void moveFrom(Promise other)
  {
    thunk = thunk;
    forceValueIfPromise = forceValueIfPromise;
    throwable = throwable;
    result = result;
    
    result = this;
    forceValueIfPromise = true;
    thunk = null;
    throwable = null;
  }
  
  public final synchronized boolean isBlank() {
    return (thunk == null) && (result == Location.UNBOUND) && (throwable == null);
  }
  
  public void checkBlank() {
    if (!isBlank()) {
      throw new IllegalStateException();
    }
  }
  
  public synchronized void setValue(Object value) {
    checkBlank();
    result = value;
    notifyAll();
  }
  
  public synchronized void setAlias(Lazy promise)
  {
    checkBlank();
    result = promise;
    setForceValueIfPromise(true);
    notifyAll();
  }
  
  public synchronized void setException(Throwable exception)
  {
    checkBlank();
    throwable = exception;
    notifyAll();
  }
  
  public synchronized void setThunk(Procedure thunk)
  {
    checkBlank();
    this.thunk = thunk;
    notifyAll();
  }
  


  public static Object force1(Object arg)
  {
    if ((arg instanceof Lazy))
      arg = ((Lazy)arg).getValue();
    return arg;
  }
  


  public static Object force(Object arg)
  {
    while ((arg instanceof Lazy)) {
      Object val = ((Lazy)arg).getValue();
      if (arg == val)
        break;
      arg = val;
    }
    return arg;
  }
  

  public static Object force(Object arg, Class target)
  {
    while (((arg instanceof Lazy)) && (!target.isInstance(arg))) {
      Object val = ((Lazy)arg).getValue();
      if (arg == val)
        break;
      arg = val;
    }
    return arg;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    try {
      print(sb);
    }
    catch (IOException ex) {
      return "caught " + ex;
    }
    return sb.toString();
  }
  
  public void print(Consumer out) {
    try {
      print(out);
    }
    catch (IOException ex) {
      out.write("caught " + ex);
    }
  }
  
  public void print(Appendable out) throws IOException {
    Object r = result;
    if (r == Location.UNBOUND) {
      synchronized (this) {
        if (throwable != null) {
          out.append("#<promise - force threw a ");
          out.append(throwable.getClass().getName());
          out.append('>');
        }
        else {
          out.append("#<promise - not forced yet>");
        }
      }
    } else if (r == null) {
      out.append("#<promise - forced to null>");
    } else {
      out.append("#<promise - forced to a ");
      out.append(r.getClass().getName());
      out.append('>');
    }
  }
}
