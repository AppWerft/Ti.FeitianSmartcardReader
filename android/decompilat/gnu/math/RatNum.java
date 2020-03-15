// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.math.BigDecimal;

public abstract class RatNum extends RealNum
{
    public static final IntNum ten_exp_9;
    
    public abstract IntNum numerator();
    
    public abstract IntNum denominator();
    
    @Override
    public int classifyFinite() {
        return this.denominator().isZero() ? (this.numerator().isZero() ? -1 : 0) : 1;
    }
    
    public static RatNum make(IntNum num, IntNum den) {
        IntNum g = IntNum.gcd(num, den);
        if (den.isNegative()) {
            g = IntNum.neg(g);
        }
        if (!g.isOne()) {
            num = IntNum.quotient(num, g);
            den = IntNum.quotient(den, g);
        }
        return (RatNum)(den.isOne() ? num : new IntFraction(num, den));
    }
    
    public static RatNum valueOf(final BigDecimal value) {
        RatNum v = IntNum.valueOf(value.unscaledValue().toString(), 10);
        int scale;
        for (scale = value.scale(); scale >= 9; scale -= 9) {
            v = divide(v, RatNum.ten_exp_9);
        }
        while (scale <= -9) {
            v = times(v, RatNum.ten_exp_9);
            scale += 9;
        }
        IntNum scaleVal = null;
        switch ((scale > 0) ? scale : (-scale)) {
            case 1: {
                scaleVal = IntNum.make(10);
                break;
            }
            case 2: {
                scaleVal = IntNum.make(100);
                break;
            }
            case 3: {
                scaleVal = IntNum.make(1000);
                break;
            }
            case 4: {
                scaleVal = IntNum.make(10000);
                break;
            }
            case 5: {
                scaleVal = IntNum.make(100000);
                break;
            }
            case 6: {
                scaleVal = IntNum.make(1000000);
                break;
            }
            case 7: {
                scaleVal = IntNum.make(10000000);
                break;
            }
            case 8: {
                scaleVal = IntNum.make(100000000);
                break;
            }
            default: {
                return v;
            }
        }
        if (scale > 0) {
            return divide(v, scaleVal);
        }
        return times(v, scaleVal);
    }
    
    public static RatNum asRatNumOrNull(final Object value) {
        if (value instanceof RatNum) {
            return (RatNum)value;
        }
        if (value instanceof BigDecimal) {
            return valueOf((BigDecimal)value);
        }
        return IntNum.asIntNumOrNull(value);
    }
    
    @Override
    public boolean isExact() {
        return true;
    }
    
    @Override
    public boolean isZero() {
        return this.numerator().isZero();
    }
    
    @Override
    public final RatNum rneg() {
        return neg(this);
    }
    
    public static RatNum infinity(final int sign) {
        return new IntFraction(IntNum.make(sign), IntNum.zero());
    }
    
    public static int compare(final RatNum x, final RatNum y) {
        final IntNum xn = x.numerator();
        final IntNum xd = x.denominator();
        final IntNum yn = y.numerator();
        final IntNum yd = y.denominator();
        IntNum left;
        IntNum right;
        if (xd.isZero() && yd.isZero()) {
            left = xn;
            right = yn;
        }
        else {
            left = IntNum.times(xn, yd);
            right = IntNum.times(yn, xd);
        }
        return IntNum.compare(left, right);
    }
    
    public static boolean equals(final RatNum x, final RatNum y) {
        return IntNum.equals(x.numerator(), y.numerator()) && IntNum.equals(x.denominator(), y.denominator());
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj != null && obj instanceof RatNum && equals(this, (RatNum)obj);
    }
    
    public static RatNum add(final RatNum x, final RatNum y, final int k) {
        final IntNum x_num = x.numerator();
        final IntNum x_den = x.denominator();
        final IntNum y_num = y.numerator();
        final IntNum y_den = y.denominator();
        if (IntNum.equals(x_den, y_den)) {
            return make(IntNum.add(x_num, y_num, k), x_den);
        }
        return make(IntNum.add(IntNum.times(y_den, x_num), IntNum.times(y_num, x_den), k), IntNum.times(x_den, y_den));
    }
    
    public static RatNum neg(final RatNum x) {
        final IntNum x_num = x.numerator();
        final IntNum x_den = x.denominator();
        return make(IntNum.neg(x_num), x_den);
    }
    
    public static RatNum times(final RatNum x, final RatNum y) {
        return make(IntNum.times(x.numerator(), y.numerator()), IntNum.times(x.denominator(), y.denominator()));
    }
    
    public static RatNum divide(final RatNum x, final RatNum y) {
        return make(IntNum.times(x.numerator(), y.denominator()), IntNum.times(x.denominator(), y.numerator()));
    }
    
    @Override
    public Numeric power(IntNum y) {
        boolean inv;
        if (y.isNegative()) {
            inv = true;
            y = IntNum.neg(y);
        }
        else {
            inv = false;
        }
        if (y.words == null) {
            final IntNum num = IntNum.power(this.numerator(), y.ival);
            final IntNum den = IntNum.power(this.denominator(), y.ival);
            return inv ? make(den, num) : make(num, den);
        }
        double d = this.doubleValue();
        final boolean neg = d < 0.0 && y.isOdd();
        d = Math.pow(d, y.doubleValue());
        if (inv) {
            d = 1.0 / d;
        }
        return new DFloNum(neg ? (-d) : d);
    }
    
    @Override
    public final RatNum toExact() {
        return this;
    }
    
    @Override
    public RealNum toInt(final int rounding_mode) {
        return IntNum.quotient(this.numerator(), this.denominator(), rounding_mode);
    }
    
    @Override
    public IntNum toExactInt(final int rounding_mode) {
        return IntNum.quotient(this.numerator(), this.denominator(), rounding_mode);
    }
    
    public static RealNum rationalize(final RealNum x, final RealNum y) {
        if (x.grt(y)) {
            return simplest_rational2(y, x);
        }
        if (!y.grt(x)) {
            return x;
        }
        if (x.sign() > 0) {
            return simplest_rational2(x, y);
        }
        if (y.isNegative()) {
            return (RealNum)simplest_rational2((RealNum)y.neg(), (RealNum)x.neg()).neg();
        }
        if (x.isExact() && y.isExact()) {
            return IntNum.zero();
        }
        return DFloNum.zero();
    }
    
    private static RealNum simplest_rational2(final RealNum x, final RealNum y) {
        final RealNum fx = x.toInt(1);
        final RealNum fy = y.toInt(1);
        if (!x.grt(fx)) {
            return fx;
        }
        if (fx.equals(fy)) {
            final RealNum n = (RealNum)IntNum.one().div(y.sub(fy));
            final RealNum d = (RealNum)IntNum.one().div(x.sub(fx));
            return (RealNum)fx.add(IntNum.one().div(simplest_rational2(n, d)), 1);
        }
        return (RealNum)fx.add(IntNum.one(), 1);
    }
    
    static {
        ten_exp_9 = IntNum.make(1000000000);
    }
}
