/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.kawa.util.ExitCalled;
import gnu.mapping.Procedure;
import kawa.lang.CalledContinuation;
import kawa.lib.ExceptionClasses;
import kawa.lib.ExceptionWithValue;

public class HandlerLink {
    public Procedure handlerProc;
    public HandlerLink outer;

    public static HandlerLink push(Procedure handler) {
        new HandlerLink().handlerProc = handler;
        new HandlerLink().outer = ExceptionClasses.current$Mnhandler.get();
        HandlerLink handlerLink = new HandlerLink();
        ExceptionClasses.current$Mnhandler.set(handlerLink);
        return handlerLink;
    }

    public void pop() {
        ExceptionClasses.current$Mnhandler.set(this.outer);
    }

    public Throwable handle(Throwable ex) {
        ExceptionClasses.current$Mnhandler.set(this.outer);
        boolean x = ex instanceof CalledContinuation;
        if (x ? !x : !(ex instanceof ExitCalled)) {
            Object cause = ExceptionWithValue.unwrap(ex);
            this.handlerProc.apply1(cause);
        }
        return ex;
    }
}

