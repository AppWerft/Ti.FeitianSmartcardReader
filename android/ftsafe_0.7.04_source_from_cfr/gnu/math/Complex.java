/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.CComplex;
import gnu.math.DComplex;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.Quaternion;
import gnu.math.RatNum;
import gnu.math.RealNum;

public abstract class Complex
extends Quaternion {
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
        return Complex.make(IntNum.zero(), this.im());
    }

    @Override
    public Quaternion unitVector() {
        int imSign = this.im().sign();
        switch (imSign) {
            case 1: {
                return Complex.imOne();
            }
            case 0: {
                return IntNum.zero();
            }
            case -1: {
                return Complex.imMinusOne();
            }
        }
        return Complex.make(0.0, Double.NaN);
    }

    @Override
    public Quaternion unitQuaternion() {
        if (this.im().isZero()) {
            return this.re().unitQuaternion();
        }
        if (this.re().isZero()) {
            return Complex.make(IntNum.zero(), (RealNum)this.im().unitQuaternion());
        }
        return DComplex.unitQuaternion(this.doubleRealValue(), this.doubleImagValue());
    }

    @Override
    public Quaternion conjugate() {
        return Complex.make(this.re(), this.im().rneg());
    }

    @Override
    public boolean isExact() {
        return this.re().isExact() && this.im().isExact();
    }

    @Override
    public int classifyFinite() {
        int r = this.re().classifyFinite();
        if (r < 0) {
            return r;
        }
        int i = this.im().classifyFinite();
        return r < i ? r : i;
    }

    @Override
    public Complex toExact() {
        RealNum re = this.re();
        RealNum im = this.im();
        RatNum xre = re.toExact();
        RatNum xim = im.toExact();
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
        if (imOne == null) {
            imOne = new CComplex(IntNum.zero(), IntNum.one());
        }
        return imOne;
    }

    public static CComplex imMinusOne() {
        if (imMinusOne == null) {
            imMinusOne = new CComplex(IntNum.zero(), IntNum.minusOne());
        }
        return imMinusOne;
    }

    public static Complex make(RealNum re, RealNum im) {
        if (im.isZero() && im.isExact()) {
            return re;
        }
        if (!re.isExact() && !im.isExact()) {
            return new DComplex(re.doubleValue(), im.doubleValue());
        }
        return new CComplex(re, im);
    }

    public static Complex make(double re, double im) {
        if (im == 0.0) {
            return new DFloNum(re);
        }
        return new DComplex(re, im);
    }

    public static Complex polar(double r, double t) {
        if (t == 0.0) {
            return new DFloNum(r);
        }
        return new DComplex(r * Math.cos(t), r * Math.sin(t));
    }

    public static Complex polar(RealNum r, RealNum t) {
        if (t.isZero() && t.isExact()) {
            return r;
        }
        return Complex.polar(r.doubleValue(), t.doubleValue());
    }

    public static Complex power(Complex x, Complex y) {
        if (y instanceof IntNum) {
            return (Complex)x.power((IntNum)y);
        }
        double y_re = y.doubleRealValue();
        double y_im = y.doubleImagValue();
        if (x.isZero() && x.isExact() && y.isExact()) {
            if (y_re > 0.0) {
                return IntNum.zero();
            }
            if (y_re == 0.0 && y_im == 0.0) {
                return IntNum.one();
            }
        }
        double x_re = x.doubleRealValue();
        double x_im = x.doubleImagValue();
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

    public static boolean equals(Complex x, Complex y) {
        return x.re().equals(y.re()) && x.im().equals(y.im());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Complex)) {
            return false;
        }
        return Complex.equals(this, (Complex)obj);
    }

    public static int compare(Complex x, Complex y) {
        int code = x.im().compare(y.im());
        if (code != 0) {
            return code;
        }
        return x.re().compare(y.re());
    }

    @Override
    public int compare(Object obj) {
        if (!(obj instanceof Complex)) {
            return ((Numeric)obj).compareReversed(this);
        }
        return Complex.compare(this, (Complex)obj);
    }

    @Override
    public boolean isZero() {
        return this.re().isZero() && this.im().isZero();
    }

    @Override
    public String toString(int radix) {
        if (this.im().isZero()) {
            return this.re().toString(radix);
        }
        String imString = this.im().toString(radix) + "i";
        char ch0 = imString.charAt(0);
        if (ch0 != '-' && ch0 != '+') {
            imString = "+" + imString;
        }
        if (this.re().isZero()) {
            return imString;
        }
        return this.re().toString(radix) + imString;
    }

    public static Complex neg(Complex x) {
        return Complex.make(x.re().rneg(), x.im().rneg());
    }

    @Override
    public Numeric neg() {
        return Complex.neg(this);
    }

    public static Complex add(Complex x, Complex y, int k) {
        return Complex.make(RealNum.add(x.re(), y.re(), k), RealNum.add(x.im(), y.im(), k));
    }

    @Override
    public Numeric add(Object y, int k) {
        if (y instanceof Complex) {
            return Complex.add(this, (Complex)y, k);
        }
        return ((Numeric)y).addReversed(this, k);
    }

    @Override
    public Numeric addReversed(Numeric x, int k) {
        if (x instanceof Complex) {
            return Complex.add((Complex)x, this, k);
        }
        throw new IllegalArgumentException();
    }

    public static Complex times(Complex x, Complex y) {
        RealNum x_re = x.re();
        RealNum x_im = x.im();
        RealNum y_re = y.re();
        RealNum y_im = y.im();
        return Complex.make(RealNum.add(RealNum.times(x_re, y_re), RealNum.times(x_im, y_im), -1), RealNum.add(RealNum.times(x_re, y_im), RealNum.times(x_im, y_re), 1));
    }

    @Override
    public Numeric mul(Object y) {
        if (y instanceof Complex) {
            return Complex.times(this, (Complex)y);
        }
        return ((Numeric)y).mulReversed(this);
    }

    @Override
    public Numeric mulReversed(Numeric x) {
        if (x instanceof Complex) {
            return Complex.times((Complex)x, this);
        }
        throw new IllegalArgumentException();
    }

    public static Complex divide(Complex x, Complex y) {
        if (!x.isExact() || !y.isExact()) {
            return DComplex.div(x.doubleRealValue(), x.doubleImagValue(), y.doubleRealValue(), y.doubleImagValue());
        }
        RealNum x_re = x.re();
        RealNum x_im = x.im();
        RealNum y_re = y.re();
        RealNum y_im = y.im();
        RealNum q = RealNum.add(RealNum.times(y_re, y_re), RealNum.times(y_im, y_im), 1);
        RealNum n = RealNum.add(RealNum.times(x_re, y_re), RealNum.times(x_im, y_im), 1);
        RealNum d = RealNum.add(RealNum.times(x_im, y_re), RealNum.times(x_re, y_im), -1);
        return Complex.make(RealNum.divide(n, q), RealNum.divide(d, q));
    }

    @Override
    public Numeric div(Object y) {
        if (y instanceof Complex) {
            return Complex.divide(this, (Complex)y);
        }
        return ((Numeric)y).divReversed(this);
    }

    @Override
    public Numeric divReversed(Numeric x) {
        if (x instanceof Complex) {
            return Complex.divide((Complex)x, this);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Complex exp() {
        return Complex.polar(Math.exp(this.doubleRealValue()), this.doubleImagValue());
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

