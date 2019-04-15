package gnu.kawa.slib;

import gnu.mapping.Promise;

public class StreamPromise extends Promise implements Stream {
  public StreamPromise(gnu.mapping.Procedure thunk, boolean lazy) {
    super(thunk);
    setForceValueIfPromise(lazy);
  }
  
  public StreamPromise() {}
}
