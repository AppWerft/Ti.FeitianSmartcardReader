package gnu.bytecode;

import java.util.Enumeration;
import java.util.NoSuchElementException;





public class VarEnumerator
  implements Enumeration
{
  Scope topScope;
  Scope currentScope;
  Variable next;
  
  public VarEnumerator(Scope scope)
  {
    topScope = scope;
    reset();
  }
  
  public final void reset()
  {
    currentScope = topScope;
    if (topScope != null)
    {
      next = currentScope.firstVar();
      if (next == null) {
        fixup();
      }
    }
  }
  
  private void fixup() {
    while (next == null)
    {
      if (currentScope.firstChild != null) {
        currentScope = currentScope.firstChild;
      }
      else {
        while (currentScope.nextSibling == null)
        {
          if (currentScope == topScope)
            return;
          currentScope = currentScope.parent;
        }
        currentScope = currentScope.nextSibling;
      }
      next = currentScope.firstVar();
    }
  }
  

  public final Variable nextVar()
  {
    Variable result = next;
    if (result != null)
    {
      next = result.nextVar();
      if (next == null)
        fixup();
    }
    return result;
  }
  
  public final boolean hasMoreElements()
  {
    return next != null;
  }
  
  public Object nextElement()
  {
    Variable result = nextVar();
    if (result == null)
      throw new NoSuchElementException("VarEnumerator");
    return result;
  }
}
