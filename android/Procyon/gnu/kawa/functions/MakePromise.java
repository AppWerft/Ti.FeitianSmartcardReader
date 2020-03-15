// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Promise;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;

public class MakePromise extends Procedure1
{
    public static final MakePromise makeDelay;
    public static final MakePromise makeLazy;
    
    public static <T> Promise<T> makePromise(final Procedure thunk) {
        return new Promise<T>(thunk);
    }
    
    public static <T> Promise<T> makePromiseLazy(final Procedure thunk) {
        final Promise<T> p = new Promise<T>(thunk);
        p.setForceValueIfPromise(true);
        return p;
    }
    
    @Override
    public Object apply1(final Object thunk) {
        final Procedure proc = (Procedure)thunk;
        if (this == MakePromise.makeLazy) {
            return makePromiseLazy(proc);
        }
        return makePromise(proc);
    }
    
    static {
        makeDelay = new MakePromise();
        makeLazy = new MakePromise();
        MakePromise.makeDelay.setName("make-delay");
        MakePromise.makeDelay.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyMakePromise");
        MakePromise.makeLazy.setName("make-lazy");
        MakePromise.makeLazy.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyMakePromise");
    }
}
