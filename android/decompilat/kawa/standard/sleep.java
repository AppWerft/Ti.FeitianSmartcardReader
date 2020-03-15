// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import kawa.lang.GenericError;
import gnu.math.Unit;
import gnu.math.Quantity;

public class sleep
{
    public static void sleep(final Quantity q) {
        final Unit u = q.unit();
        if (u == Unit.Empty || u.dimensions() == Unit.second.dimensions()) {
            final double seconds = q.doubleValue();
            final long millis = (long)(seconds * 1000.0);
            final int nanos = (int)(seconds * 1.0E9 - millis * 1000000.0);
            try {
                Thread.sleep(millis, nanos);
            }
            catch (InterruptedException ex) {
                throw new GenericError("sleep was interrupted");
            }
            return;
        }
        throw new GenericError("bad unit for sleep");
    }
}
