// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

public abstract class Quantity extends Numeric
{
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
    
    public static Quantity make(final Quaternion x, final Unit u) {
        if (u == Unit.Empty) {
            return x;
        }
        if (x instanceof DFloNum) {
            return new DQuantity(x.doubleValue(), u);
        }
        return new CQuantity(x, u);
    }
    
    public static Quantity make(final RealNum re, final RealNum im, final RealNum jm, final RealNum km, final Unit unit) {
        if (unit == Unit.Empty) {
            return Quaternion.make(re, im, jm, km);
        }
        if (im.isZero() && jm.isZero() && km.isZero() && (!re.isExact() || !im.isExact() || !jm.isExact() || !km.isExact())) {
            return new DQuantity(re.doubleValue(), unit);
        }
        return new CQuantity(re, im, jm, km, unit);
    }
    
    public static Quantity make(final double re, final double im, final double jm, final double km, final Unit unit) {
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
        return make((Quaternion)this.number().neg(), this.unit());
    }
    
    @Override
    public Numeric abs() {
        return make((Quaternion)this.number().abs(), this.unit());
    }
    
    public static int compare(final Quantity x, final Quantity y) {
        if (x.unit() == y.unit()) {
            return Quaternion.compare(x.number(), y.number());
        }
        if (x.dimensions() != y.dimensions() || x.imValue() != y.imValue() || x.jmValue() != y.jmValue() || x.kmValue() != y.kmValue()) {
            return -3;
        }
        return DFloNum.compare(x.reValue(), y.reValue());
    }
    
    @Override
    public int compare(final Object obj) {
        if (!(obj instanceof Quantity)) {
            return ((Numeric)obj).compareReversed(this);
        }
        return compare(this, (Quantity)obj);
    }
    
    @Override
    public int compareReversed(final Numeric x) {
        if (x instanceof Quantity) {
            return compare((Quantity)x, this);
        }
        throw new IllegalArgumentException();
    }
    
    public static Quantity add(final Quantity x, final Quantity y, final int k) {
        if (x.unit() == y.unit()) {
            return make(Quaternion.add(x.number(), y.number(), k), x.unit());
        }
        if (x.dimensions() != y.dimensions()) {
            throw new ArithmeticException("units mis-match");
        }
        final double x_factor = x.unit().doubleValue();
        final double re = (x.reValue() + k * y.reValue()) / x_factor;
        final double im = (x.imValue() + k * y.imValue()) / x_factor;
        final double jm = (x.jmValue() + k * y.jmValue()) / x_factor;
        final double km = (x.kmValue() + k * y.kmValue()) / x_factor;
        return make(re, im, jm, km, x.unit());
    }
    
    @Override
    public Numeric add(final Object y, final int k) {
        if (y instanceof Quantity) {
            return add(this, (Quantity)y, k);
        }
        return ((Numeric)y).addReversed(this, k);
    }
    
    @Override
    public Numeric addReversed(final Numeric x, final int k) {
        if (x instanceof Quantity) {
            return add((Quantity)x, this, k);
        }
        throw new IllegalArgumentException();
    }
    
    public static Quantity times(final Quantity x, final Quantity y) {
        final Unit unit = Unit.times(x.unit(), y.unit());
        final Numeric num = x.number().mul(y.number());
        return make((Quaternion)num, unit);
    }
    
    @Override
    public Numeric mul(final Object y) {
        if (y instanceof Quantity) {
            return times(this, (Quantity)y);
        }
        return ((Numeric)y).mulReversed(this);
    }
    
    @Override
    public Numeric mulReversed(final Numeric x) {
        if (x instanceof Quantity) {
            return times((Quantity)x, this);
        }
        throw new IllegalArgumentException();
    }
    
    public static Quantity divide(final Quantity x, final Quantity y) {
        final Unit unit = Unit.divide(x.unit(), y.unit());
        final Numeric num = x.number().div(y.number());
        return make((Quaternion)num, unit);
    }
    
    @Override
    public Numeric div(final Object y) {
        if (y instanceof Quantity) {
            return divide(this, (Quantity)y);
        }
        return ((Numeric)y).divReversed(this);
    }
    
    @Override
    public Numeric divReversed(final Numeric x) {
        if (x instanceof Quantity) {
            return divide((Quantity)x, this);
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public String toString(final int radix) {
        final String str = this.number().toString(radix);
        if (this.unit() == Unit.Empty) {
            return str;
        }
        return str + this.unit().toString();
    }
}
