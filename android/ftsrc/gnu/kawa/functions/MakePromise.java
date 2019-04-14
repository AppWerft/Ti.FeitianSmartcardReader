package gnu.kawa.functions;

import gnu.mapping.Procedure;

public class MakePromise extends gnu.mapping.Procedure1 {
  public static final MakePromise makeDelay = new MakePromise();
  public static final MakePromise makeLazy = new MakePromise();
  
  static { makeDelay.setName("make-delay");
    makeDelay.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyMakePromise");
    
    makeLazy.setName("make-lazy");
    makeLazy.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyMakePromise");
  }
  
  public static <T> gnu.mapping.Promise<T> makePromise(Procedure thunk)
  {
    return new gnu.mapping.Promise(thunk);
  }
  
  public static <T> gnu.mapping.Promise<T> makePromiseLazy(Procedure thunk) {
    gnu.mapping.Promise<T> p = new gnu.mapping.Promise(thunk);
    p.setForceValueIfPromise(true);
    return p;
  }
  
  public Object apply1(Object thunk) {
    Procedure proc = (Procedure)thunk;
    if (this == makeLazy) {
      return makePromiseLazy(proc);
    }
    return makePromise(proc);
  }
  
  public MakePromise() {}
}
