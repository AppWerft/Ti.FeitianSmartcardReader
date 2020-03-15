// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.mapping.Procedure;
import gnu.mapping.Promise;

public class StreamPromise extends Promise implements Stream
{
    public StreamPromise(final Procedure thunk, final boolean lazy) {
        super(thunk);
        this.setForceValueIfPromise(lazy);
    }
    
    public StreamPromise() {
    }
}
