// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.kawa.util.ExitCalled;
import kawa.lang.CalledContinuation;
import gnu.mapping.Procedure;

public class HandlerLink
{
    public Procedure handlerProc;
    public HandlerLink outer;
    
    public static HandlerLink push(final Procedure handler) {
        final HandlerLink handlerLink = new HandlerLink();
        handlerLink.handlerProc = handler;
        handlerLink.outer = ExceptionClasses.current$Mnhandler.get();
        final HandlerLink new1 = handlerLink;
        ExceptionClasses.current$Mnhandler.set(new1);
        return new1;
    }
    
    public void pop() {
        ExceptionClasses.current$Mnhandler.set(this.outer);
    }
    
    public Throwable handle(final Throwable ex) {
        ExceptionClasses.current$Mnhandler.set(this.outer);
        final boolean x = ex instanceof CalledContinuation;
        if (x) {
            if (x) {
                return ex;
            }
        }
        else if (ex instanceof ExitCalled) {
            return ex;
        }
        final Object cause = ExceptionWithValue.unwrap(ex);
        this.handlerProc.apply1(cause);
        return ex;
    }
}
