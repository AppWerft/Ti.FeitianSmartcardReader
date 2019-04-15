/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.BaseUnit;
import gnu.math.CQuantity;
import gnu.math.DFloNum;
import gnu.math.DQuantity;
import gnu.math.Dimensions;
import gnu.math.Numeric;
import gnu.math.Quaternion;
import gnu.math.RealNum;
import gnu.math.Unit;

public abstract class Quantity
extends Numeric {
    public Unit unit() {
        return Unit.Empty;
    }

    public Dimensions dimensions() {
        return this.unit().dimensions();
    }

    public abstract Quaternion number();

    public RealNum re() {
        return this.number().re();
    }

    public RealNum im() {
        return this.number().im();
    }

    public RealNum jm() {
        return this.number().jm();
    }

    public RealNum km() {
        return this.number().km();
    }

    public final double reValue() {
        return this.doubleValue();
    }

    public final double imValue() {
        return this.doubleImagValue();
    }

    public final double jmValue() {
        return this.doubleJmagValue();
    }

    public final double kmValue() {
        return this.doubleKmagValue();
    }

    @Override
    public double doubleValue() {
        return this.unit().doubleValue() * this.re().doubleValue();
    }

    public double doubleImagValue() {
        return this.unit().doubleValue() * this.im().doubleValue();
    }

    public double doubleJmagValue() {
        return this.unit().doubleValue() * this.jm().doubleValue();
    }

    public double doubleKmagValue() {
        return this.unit().doubleValue() * this.km().doubleValue();
    }

    public static Quantity make(Quaternion x, Unit u) {
        if (u == Unit.Empty) {
            return x;
        }
        if (x instanceof DFloNum) {
            return new DQuantity(x.doubleValue(), u);
        }
        return new CQuantity(x, u);
    }

    public static Quantity make(RealNum re, RealNum im, RealNum jm, RealNum km, Unit unit) {
        if (unit == Unit.Empty) {
            return Quaternion.make(re, im, jm, km);
        }
        if (!(!im.isZero() || !jm.isZero() || !km.isZero() || re.isExact() && im.isExact() && jm.isExact() && km.isExact())) {
            return new DQuantity(re.doubleValue(), unit);
        }
        return new CQuantity(re, im, jm, km, unit);
    }

    public static Quantity make(double re, double im, double jm, double km, Unit unit) {
        if (unit == Unit.Empty) {
            return Quaternion.make(re, im, jm, km);
        }
        if (im == 0.0 && jm == 0.0 && km == 0.0) {
            return new DQuantity(re, unit);
        }
        return new CQuantity(new DFloNum(re), new DFloNum(im), new DFloNum(jm), new DFloNum(km), unit);
    }

    @Override
    public Numeric neg() {
        return Quantity.make((Quaternion)this.number().neg(), this.unit());
    }

    @Override
    public Numeric abs() {
        return Quantity.make((Quaternion)this.number().abs(), this.unit());
    }

    public static int compare(Quantity x, Quantity y) {
        if (x.unit() == y.unit()) {
            return Quaternion.compare(x.number(), y.number());
        }
        if (x.dimensions() != y.dimensions() || x.imValue() != y.imValue() || x.jmValue() != y.jmValue() || x.kmValue() != y.kmValue()) {
            return -3;
        }
        return DFloNum.compare(x.reValue(), y.reValue());
    }

    @Override
    public int compare(Object obj) {
        if (!(obj instanceof Quantity)) {
            return ((Numeric)obj).compareReversed(this);
        }
        return Quantity.compare(this, (Quantity)obj);
    }

    @Override
    public int compareReversed(Numeric x) {
        if (x instanceof Quantity) {
            return Quantity.compare((Quantity)x, this);
        }
        throw new IllegalArgumentException();
    }

    public static Quantity add(Quantity x, Quantity y, int k) {
        if (x.unit() == y.unit()) {
            return Quantity.make(Quaternion.add(x.number(), y.number(), k), x.unit());
        }
        if (x.dimensions() != y.dimensions()) {
            throw new ArithmeticException("units mis-match");
        }
        double x_factor = x.unit().doubleValue();
        double re = (x.reValue() + (double)k * y.reValue()) / x_factor;
        double im = (x.imValue() + (double)k * y.imValue()) / x_factor;
        double jm = (x.jmValue() + (double)k * y.jmValue()) / x_factor;
        double km = (x.kmValue() + (double)k * y.kmValue()) / x_factor;
        return Quantity.make(re, im, jm, km, x.unit());
    }

    @Override
    public Numeric add(Object y, int k) {
        if (y instanceof Quantity) {
            return Quantity.add(this, (Quantity)y, k);
        }
        return ((Numeric)y).addReversed(this, k);
    }

    @Override
    public Numeric addReversed(Numeric x, int k) {
        if (x instanceof Quantity) {
            return Quantity.add((Quantity)x, this, k);
        }
        throw new IllegalArgumentException();
    }

    public static Quantity times(Quantity x, Quantity y) {
        Unit unit = Unit.times(x.unit(), y.unit());
        Numeric num = x.number().mul(y.number());
        return Quantity.make((Quaternion)num, unit);
    }

    @Override
    public Numeric mul(Object y) {
        if (y instanceof Quantity) {
            return Quantity.times(this, (Quantity)y);
        }
        return ((Numeric)y).mulReversed(this);
    }

    @Override
    public Numeric mulReversed(Numeric x) {
        if (x instanceof Quantity) {
            return Quantity.times((Quantity)x, this);
        }
        throw new IllegalArgumentException();
    }

    public static Quantity divide(Quantity x, Quantity y) {
        Unit unit = Unit.divide(x.unit(), y.unit());
        Numeric num = x.number().div(y.number());
        return Quantity.make((Quaternion)num, unit);
    }

    @Override
    public Numeric div(Object y) {
        if (y instanceof Quantity) {
            return Quantity.divide(this, (Quantity)y);
        }
        return ((Numeric)y).divReversed(this);
    }

    @Override
    public Numeric divReversed(Numeric x) {
        if (x instanceof Quantity) {
            return Quantity.divide((Quantity)x, this);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString(int radix) {
        String str = this.number().toString(radix);
        if (this.unit() == Unit.Empty) {
            return str;
        }
        return str + this.unit().toString();
    }
}

