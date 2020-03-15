// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class DQuantity extends Quantity implements Externalizable
{
    double factor;
    Unit unt;
    
    @Override
    public final Unit unit() {
        return this.unt;
    }
    
    @Override
    public final Complex number() {
        return new DFloNum(this.factor);
    }
    
    @Override
    public final RealNum re() {
        return new DFloNum(this.factor);
    }
    
    @Override
    public final double doubleValue() {
        return this.factor * this.unt.factor;
    }
    
    public DQuantity(final double factor, final Unit unit) {
        this.factor = factor;
        this.unt = unit;
    }
    
    @Override
    public boolean isExact() {
        return false;
    }
    
    @Override
    public boolean isZero() {
        return this.factor == 0.0;
    }
    
    public static DQuantity add(final DQuantity x, final DQuantity y, final double k) {
        if (x.dimensions() != y.dimensions()) {
            throw new ArithmeticException("units mis-match");
        }
        final double unit_ratio = y.unit().factor / x.unit().factor;
        return new DQuantity(x.factor + k * unit_ratio * y.factor, x.unit());
    }
    
    public static DQuantity times(final DQuantity x, final DQuantity y) {
        final double factor = x.factor * y.factor;
        final Unit unit = Unit.times(x.unit(), y.unit());
        return new DQuantity(factor, unit);
    }
    
    public static DQuantity divide(final DQuantity x, final DQuantity y) {
        final double factor = x.factor / y.factor;
        final Unit unit = Unit.divide(x.unit(), y.unit());
        return new DQuantity(factor, unit);
    }
    
    @Override
    public Numeric add(final Object y, final int k) {
        if (y instanceof DQuantity) {
            return add(this, (DQuantity)y, (double)k);
        }
        if (this.dimensions() == Dimensions.Empty && y instanceof RealNum) {
            return new DQuantity(this.factor + k * ((RealNum)y).doubleValue(), this.unit());
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).addReversed(this, k);
    }
    
    @Override
    public Numeric addReversed(final Numeric x, final int k) {
        if (this.dimensions() == Dimensions.Empty && x instanceof RealNum) {
            return new DFloNum(((RealNum)x).doubleValue() + k * this.factor);
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public Numeric mul(final Object y) {
        if (y instanceof DQuantity) {
            return times(this, (DQuantity)y);
        }
        if (y instanceof RealNum) {
            return new DQuantity(this.factor * ((RealNum)y).doubleValue(), this.unit());
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).mulReversed(this);
    }
    
    @Override
    public Numeric mulReversed(final Numeric x) {
        if (x instanceof RealNum) {
            return new DQuantity(((RealNum)x).doubleValue() * this.factor, this.unit());
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public Numeric div(final Object y) {
        if (y instanceof DQuantity) {
            final DQuantity qy = (DQuantity)y;
            if (this.dimensions() == qy.dimensions()) {
                return new DFloNum(this.factor * this.unit().doubleValue() / (qy.factor * qy.unit().factor));
            }
            return divide(this, qy);
        }
        else {
            if (y instanceof RealNum) {
                return new DQuantity(this.factor / ((RealNum)y).doubleValue(), this.unit());
            }
            if (!(y instanceof Numeric)) {
                throw new IllegalArgumentException();
            }
            return ((Numeric)y).divReversed(this);
        }
    }
    
    @Override
    public Numeric divReversed(final Numeric x) {
        if (x instanceof RealNum) {
            return new DQuantity(((RealNum)x).doubleValue() / this.factor, Unit.divide(Unit.Empty, this.unit()));
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeDouble(this.factor);
        out.writeObject(this.unt);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.factor = in.readDouble();
        this.unt = (Unit)in.readObject();
    }
}
