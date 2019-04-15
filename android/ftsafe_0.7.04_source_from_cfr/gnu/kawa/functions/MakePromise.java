/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import gnu.mapping.Promise;
import gnu.mapping.Symbol;

public class MakePromise
extends Procedure1 {
    public static final MakePromise makeDelay = new MakePromise();
    public static final MakePromise makeLazy = new MakePromise();

    public static <T> Promise<T> makePromise(Procedure thunk) {
        return new Promise(thunk);
    }

    public static <T> Promise<T> makePromiseLazy(Procedure thunk) {
        Promise p = new Promise(thunk);
        p.setForceValueIfPromise(true);
        return p;
    }

    @Override
    public Object apply1(Object thunk) {
        Procedure proc = (Procedure)thunk;
        if (this == makeLazy) {
            return MakePromise.makePromiseLazy(proc);
        }
        return MakePromise.makePromise(proc);
    }

    static {
        makeDelay.setName("make-delay");
        makeDelay.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyMakePromise");
        makeLazy.setName("make-lazy");
        makeLazy.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyMakePromise");
    }
}

