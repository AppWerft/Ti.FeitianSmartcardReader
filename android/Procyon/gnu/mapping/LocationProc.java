// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class LocationProc<T> extends Procedure0or1 implements HasSetter
{
    Location<T> loc;
    
    public LocationProc(final Location loc) {
        this.loc = (Location<T>)loc;
    }
    
    public static LocationProc makeNamed(final Symbol name, final Location loc) {
        final LocationProc lproc = new LocationProc(loc);
        lproc.setSymbol(name);
        return lproc;
    }
    
    public LocationProc(final Location loc, final Procedure converter) {
        this.loc = (Location<T>)loc;
        if (converter != null) {
            this.pushConverter(converter);
        }
    }
    
    public void pushConverter(final Procedure converter) {
        this.loc = ConstrainedLocation.make(this.loc, converter);
    }
    
    public final T getValue() throws Throwable {
        return this.loc.get();
    }
    
    @Override
    public T apply0() throws Throwable {
        return this.loc.get();
    }
    
    @Override
    public Object apply1(final Object value) throws Throwable {
        this.set0(value);
        return Values.empty;
    }
    
    @Override
    public void set0(final Object value) throws Throwable {
        this.loc.set((T)value);
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
        final Object n = this.getSymbol();
        if (n != null) {
            return super.toString();
        }
        return "#<location-proc " + this.loc + ">";
    }
}
