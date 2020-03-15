// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

public abstract class Complex extends Quaternion
{
    private static CComplex imOne;
    private static CComplex imMinusOne;
    
    @Override
    public final RealNum jm() {
        return IntNum.zero();
    }
    
    @Override
    public final RealNum km() {
        return IntNum.zero();
    }
    
    @Override
    public final Complex complexPart() {
        return this;
    }
    
    @Override
    public Quaternion vectorPart() {
        return make(IntNum.zero(), this.im());
    }
    
    @Override
    public Quaternion unitVector() {
        final int imSign = this.im().sign();
        switch (imSign) {
            case 1: {
                return imOne();
            }
            case 0: {
                return IntNum.zero();
            }
            case -1: {
                return imMinusOne();
            }
            default: {
                return make(0.0, Double.NaN);
            }
        }
    }
    
    @Override
    public Quaternion unitQuaternion() {
        if (this.im().isZero()) {
            return this.re().unitQuaternion();
        }
        if (this.re().isZero()) {
            return make(IntNum.zero(), (RealNum)this.im().unitQuaternion());
        }
        return DComplex.unitQuaternion(this.doubleRealValue(), this.doubleImagValue());
    }
    
    @Override
    public Quaternion conjugate() {
        return make(this.re(), this.im().rneg());
    }
    
    @Override
    public boolean isExact() {
        return this.re().isExact() && this.im().isExact();
    }
    
    @Override
    public int classifyFinite() {
        final int r = this.re().classifyFinite();
        if (r < 0) {
            return r;
        }
        final int i = this.im().classifyFinite();
        return (r < i) ? r : i;
    }
    
    @Override
    public Complex toExact() {
        final RealNum re = this.re();
        final RealNum im = this.im();
        final RatNum xre = re.toExact();
        final RatNum xim = im.toExact();
        if (xre == re && xim == im) {
            return this;
        }
        return new CComplex(xre, xim);
    }
    
    @Override
    public Complex toInexact() {
        if (this.isExact()) {
            return this;
        }
        return new DComplex(this.re().doubleValue(), this.im().doubleValue());
    }
    
    public static CComplex imOne() {
        if (Complex.imOne == null) {
            Complex.imOne = new CComplex(IntNum.zero(), IntNum.one());
        }
        return Complex.imOne;
    }
    
    public static CComplex imMinusOne() {
        if (Complex.imMinusOne == null) {
            Complex.imMinusOne = new CComplex(IntNum.zero(), IntNum.minusOne());
        }
        return Complex.imMinusOne;
    }
    
    public static Complex make(final RealNum re, final RealNum im) {
        if (im.isZero() && im.isExact()) {
            return re;
        }
        if (!re.isExact() && !im.isExact()) {
            return new DComplex(re.doubleValue(), im.doubleValue());
        }
        return new CComplex(re, im);
    }
    
    public static Complex make(final double re, final double im) {
        if (im == 0.0) {
            return new DFloNum(re);
        }
        return new DComplex(re, im);
    }
    
    public static Complex polar(final double r, final double t) {
        if (t == 0.0) {
            return new DFloNum(r);
        }
        return new DComplex(r * Math.cos(t), r * Math.sin(t));
    }
    
    public static Complex polar(final RealNum r, final RealNum t) {
        if (t.isZero() && t.isExact()) {
            return r;
        }
        return polar(r.doubleValue(), t.doubleValue());
    }
    
    public static Complex power(final Complex x, final Complex y) {
        if (y instanceof IntNum) {
            return (Complex)x.power((IntNum)y);
        }
        final double y_re = y.doubleRealValue();
        final double y_im = y.doubleImagValue();
        if (x.isZero() && x.isExact() && y.isExact()) {
            if (y_re > 0.0) {
                return IntNum.zero();
            }
            if (y_re == 0.0 && y_im == 0.0) {
                return IntNum.one();
            }
        }
        final double x_re = x.doubleRealValue();
        final double x_im = x.doubleImagValue();
        if (x_im == 0.0 && y_im == 0.0 && (x_re >= 0.0 || Double.isInfinite(x_re) || Double.isNaN(x_re))) {
            return new DFloNum(Math.pow(x_re, y_re));
        }
        return DComplex.power(x_re, x_im, y_re, y_im);
    }
    
    @Override
    public Numeric abs() {
        return new DFloNum(Math.hypot(this.doubleRealValue(), this.doubleImagValue()));
    }
    
    @Override
    public RealNum angle() {
        return new DFloNum(Math.atan2(this.doubleImagValue(), this.doubleRealValue()));
    }
    
    @Override
    public final RealNum colatitude() {
        return IntNum.zero();
    }
    
    @Override
    public final RealNum longitude() {
        return IntNum.zero();
    }
    
    public static boolean equals(final Complex x, final Complex y) {
        return x.re().equals(y.re()) && x.im().equals(y.im());
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj != null && obj instanceof Complex && equals(this, (Complex)obj);
    }
    
    public static int compare(final Complex x, final Complex y) {
        final int code = x.im().compare(y.im());
        if (code != 0) {
            return code;
        }
        return x.re().compare(y.re());
    }
    
    @Override
    public int compare(final Object obj) {
        if (!(obj instanceof Complex)) {
            return ((Numeric)obj).compareReversed(this);
        }
        return compare(this, (Complex)obj);
    }
    
    @Override
    public boolean isZero() {
        return this.re().isZero() && this.im().isZero();
    }
    
    @Override
    public String toString(final int radix) {
        if (this.im().isZero()) {
            return this.re().toString(radix);
        }
        String imString = this.im().toString(radix) + "i";
        final char ch0 = imString.charAt(0);
        if (ch0 != '-' && ch0 != '+') {
            imString = "+" + imString;
        }
        if (this.re().isZero()) {
            return imString;
        }
        return this.re().toString(radix) + imString;
    }
    
    public static Complex neg(final Complex x) {
        return make(x.re().rneg(), x.im().rneg());
    }
    
    @Override
    public Numeric neg() {
        return neg(this);
    }
    
    public static Complex add(final Complex x, final Complex y, final int k) {
        return make(RealNum.add(x.re(), y.re(), k), RealNum.add(x.im(), y.im(), k));
    }
    
    @Override
    public Numeric add(final Object y, final int k) {
        if (y instanceof Complex) {
            return add(this, (Complex)y, k);
        }
        return ((Numeric)y).addReversed(this, k);
    }
    
    @Override
    public Numeric addReversed(final Numeric x, final int k) {
        if (x instanceof Complex) {
            return add((Complex)x, this, k);
        }
        throw new IllegalArgumentException();
    }
    
    public static Complex times(final Complex x, final Complex y) {
        final RealNum x_re = x.re();
        final RealNum x_im = x.im();
        final RealNum y_re = y.re();
        final RealNum y_im = y.im();
        return make(RealNum.add(RealNum.times(x_re, y_re), RealNum.times(x_im, y_im), -1), RealNum.add(RealNum.times(x_re, y_im), RealNum.times(x_im, y_re), 1));
    }
    
    @Override
    public Numeric mul(final Object y) {
        if (y instanceof Complex) {
            return times(this, (Complex)y);
        }
        return ((Numeric)y).mulReversed(this);
    }
    
    @Override
    public Numeric mulReversed(final Numeric x) {
        if (x instanceof Complex) {
            return times((Complex)x, this);
        }
        throw new IllegalArgumentException();
    }
    
    public static Complex divide(final Complex x, final Complex y) {
        if (!x.isExact() || !y.isExact()) {
            return DComplex.div(x.doubleRealValue(), x.doubleImagValue(), y.doubleRealValue(), y.doubleImagValue());
        }
        final RealNum x_re = x.re();
        final RealNum x_im = x.im();
        final RealNum y_re = y.re();
        final RealNum y_im = y.im();
        final RealNum q = RealNum.add(RealNum.times(y_re, y_re), RealNum.times(y_im, y_im), 1);
        final RealNum n = RealNum.add(RealNum.times(x_re, y_re), RealNum.times(x_im, y_im), 1);
        final RealNum d = RealNum.add(RealNum.times(x_im, y_re), RealNum.times(x_re, y_im), -1);
        return make(RealNum.divide(n, q), RealNum.divide(d, q));
    }
    
    @Override
    public Numeric div(final Object y) {
        if (y instanceof Complex) {
            return divide(this, (Complex)y);
        }
        return ((Numeric)y).divReversed(this);
    }
    
    @Override
    public Numeric divReversed(final Numeric x) {
        if (x instanceof Complex) {
            return divide((Complex)x, this);
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public Complex exp() {
        return polar(Math.exp(this.doubleRealValue()), this.doubleImagValue());
    }
    
    @Override
    public Complex log() {
        return DComplex.log(this.doubleRealValue(), this.doubleImagValue());
    }
    
    @Override
    public Complex sqrt() {
        return DComplex.sqrt(this.doubleRealValue(), this.doubleImagValue());
    }
    
    @Override
    public Complex sin() {
        return DComplex.sin(this.doubleRealValue(), this.doubleImagValue());
    }
    
    @Override
    public Complex cos() {
        return DComplex.cos(this.doubleRealValue(), this.doubleImagValue());
    }
    
    @Override
    public Complex tan() {
        return DComplex.tan(this.doubleRealValue(), this.doubleImagValue());
    }
}
