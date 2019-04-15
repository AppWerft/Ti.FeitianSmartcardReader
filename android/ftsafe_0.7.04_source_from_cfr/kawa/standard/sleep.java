/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.math.BaseUnit;
import gnu.math.Dimensions;
import gnu.math.NamedUnit;
import gnu.math.Quantity;
import gnu.math.Unit;
import kawa.lang.GenericError;

public class sleep {
    public static void sleep(Quantity q) {
        Unit u = q.unit();
        if (u != Unit.Empty && u.dimensions() != Unit.second.dimensions()) {
            throw new GenericError("bad unit for sleep");
        }
        double seconds = q.doubleValue();
        long millis = (long)(seconds * 1000.0);
        int nanos = (int)(seconds * 1.0E9 - (double)millis * 1000000.0);
        try {
            Thread.sleep(millis, nanos);
        }
        catch (InterruptedException ex) {
            throw new GenericError("sleep was interrupted");
        }
    }
}

