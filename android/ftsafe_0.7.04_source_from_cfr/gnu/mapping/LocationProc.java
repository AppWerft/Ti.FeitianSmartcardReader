/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.ConstrainedLocation;
import gnu.mapping.HasSetter;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure0or1;
import gnu.mapping.Setter0;
import gnu.mapping.Symbol;
import gnu.mapping.Values;

public class LocationProc<T>
extends Procedure0or1
implements HasSetter {
    Location<T> loc;

    public LocationProc(Location loc) {
        this.loc = loc;
    }

    public static LocationProc makeNamed(Symbol name, Location loc) {
        LocationProc<T> lproc = new LocationProc<T>(loc);
        lproc.setSymbol((Object)name);
        return lproc;
    }

    public LocationProc(Location loc, Procedure converter) {
        this.loc = loc;
        if (converter != null) {
            this.pushConverter(converter);
        }
    }

    public void pushConverter(Procedure converter) {
        this.loc = ConstrainedLocation.make(this.loc, converter);
    }

    public final T getValue() throws Throwable {
        return this.loc.get();
    }

    public T apply0() throws Throwable {
        return this.loc.get();
    }

    @Override
    public Object apply1(Object value) throws Throwable {
        this.set0(value);
        return Values.empty;
    }

    @Override
    public void set0(Object value) throws Throwable {
        this.loc.set(value);
    }

    @Override
    public Procedure getSetter() {
        return new Setter0(this);
    }

    public final Location getLocation() {
        return this.loc;
    }

    @Override
    public String toString() {
        Object n = this.getSymbol();
        if (n != null) {
            return super.toString();
        }
        return "#<location-proc " + this.loc + ">";
    }
}

