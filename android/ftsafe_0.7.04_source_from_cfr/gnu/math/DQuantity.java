/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.BaseUnit;
import gnu.math.Complex;
import gnu.math.DFloNum;
import gnu.math.Dimensions;
import gnu.math.Numeric;
import gnu.math.Quantity;
import gnu.math.Quaternion;
import gnu.math.RealNum;
import gnu.math.Unit;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class DQuantity
extends Quantity
implements Externalizable {
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

    public DQuantity(double factor, Unit unit) {
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

    public static DQuantity add(DQuantity x, DQuantity y, double k) {
        if (x.dimensions() != y.dimensions()) {
            throw new ArithmeticException("units mis-match");
        }
        double unit_ratio = y.unit().factor / x.unit().factor;
        return new DQuantity(x.factor + k * unit_ratio * y.factor, x.unit());
    }

    public static DQuantity times(DQuantity x, DQuantity y) {
        double factor = x.factor * y.factor;
        Unit unit = Unit.times(x.unit(), y.unit());
        return new DQuantity(factor, unit);
    }

    public static DQuantity divide(DQuantity x, DQuantity y) {
        double factor = x.factor / y.factor;
        Unit unit = Unit.divide(x.unit(), y.unit());
        return new DQuantity(factor, unit);
    }

    @Override
    public Numeric add(Object y, int k) {
        if (y instanceof DQuantity) {
            return DQuantity.add(this, (DQuantity)y, k);
        }
        if (this.dimensions() == Dimensions.Empty && y instanceof RealNum) {
            return new DQuantity(this.factor + (double)k * ((RealNum)y).doubleValue(), this.unit());
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).addReversed(this, k);
    }

    @Override
    public Numeric addReversed(Numeric x, int k) {
        if (this.dimensions() == Dimensions.Empty && x instanceof RealNum) {
            return new DFloNum(((RealNum)x).doubleValue() + (double)k * this.factor);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Numeric mul(Object y) {
        if (y instanceof DQuantity) {
            return DQuantity.times(this, (DQuantity)y);
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
    public Numeric mulReversed(Numeric x) {
        if (x instanceof RealNum) {
            return new DQuantity(((RealNum)x).doubleValue() * this.factor, this.unit());
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Numeric div(Object y) {
        if (y instanceof DQuantity) {
            DQuantity qy = (DQuantity)y;
            if (this.dimensions() == qy.dimensions()) {
                return new DFloNum(this.factor * this.unit().doubleValue() / (qy.factor * qy.unit().factor));
            }
            return DQuantity.divide(this, qy);
        }
        if (y instanceof RealNum) {
            return new DQuantity(this.factor / ((RealNum)y).doubleValue(), this.unit());
        }
        if (!(y instanceof Numeric)) {
            throw new IllegalArgumentException();
        }
        return ((Numeric)y).divReversed(this);
    }

    @Override
    public Numeric divReversed(Numeric x) {
        if (x instanceof RealNum) {
            return new DQuantity(((RealNum)x).doubleValue() / this.factor, Unit.divide(Unit.Empty, this.unit()));
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(this.factor);
        out.writeObject(this.unt);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.factor = in.readDouble();
        this.unt = (Unit)in.readObject();
    }
}

