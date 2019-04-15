/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.CQuaternion;
import gnu.math.Complex;
import gnu.math.DFloNum;
import gnu.math.DQuaternion;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.Quantity;
import gnu.math.RatNum;
import gnu.math.RealNum;

public abstract class Quaternion
extends Quantity {
    private static CQuaternion jmOne;
    private static CQuaternion jmMinusOne;
    private static CQuaternion kmOne;
    private static CQuaternion kmMinusOne;

    @Override
    public Quaternion number() {
        return this;
    }

    @Override
    public boolean isExact() {
        return this.re().isExact() && this.im().isExact() && this.jm().isExact() && this.km().isExact();
    }

    public int classifyFinite() {
        int r = this.re().classifyFinite();
        if (r < 0) {
            return r;
        }
        int i = this.im().classifyFinite();
        if (i < 0) {
            return i;
        }
        int j = this.jm().classifyFinite();
        if (j < 0) {
            return j;
        }
        int k = this.km().classifyFinite();
        if (k < 0) {
            return k;
        }
        return r * i * j * k;
    }

    @Override
    public Quaternion toExact() {
        RealNum re = this.re();
        RealNum im = this.im();
        RealNum jm = this.jm();
        RealNum km = this.km();
        RatNum xre = re.toExact();
        RatNum xim = im.toExact();
        RatNum xjm = jm.toExact();
        RatNum xkm = km.toExact();
        if (xre == re && xim == im && xjm == jm && xkm == km) {
            return this;
        }
        return new CQuaternion(xre, xim, xjm, xkm);
    }

    @Override
    public Quaternion toInexact() {
        if (this.isExact()) {
            return this;
        }
        return new DQuaternion(this.re().doubleValue(), this.im().doubleValue(), this.jm().doubleValue(), this.km().doubleValue());
    }

    public static CQuaternion jmOne() {
        if (jmOne == null) {
            jmOne = new CQuaternion(IntNum.zero(), IntNum.zero(), IntNum.one(), IntNum.zero());
        }
        return jmOne;
    }

    public static CQuaternion jmMinusOne() {
        if (jmMinusOne == null) {
            jmMinusOne = new CQuaternion(IntNum.zero(), IntNum.zero(), IntNum.minusOne(), IntNum.zero());
        }
        return jmMinusOne;
    }

    public static CQuaternion kmOne() {
        if (kmOne == null) {
            kmOne = new CQuaternion(IntNum.zero(), IntNum.zero(), IntNum.zero(), IntNum.one());
        }
        return kmOne;
    }

    public static CQuaternion kmMinusOne() {
        if (kmMinusOne == null) {
            kmMinusOne = new CQuaternion(IntNum.zero(), IntNum.zero(), IntNum.zero(), IntNum.minusOne());
        }
        return kmMinusOne;
    }

    @Override
    public double doubleValue() {
        return this.re().doubleValue();
    }

    @Override
    public double doubleImagValue() {
        return this.im().doubleValue();
    }

    @Override
    public double doubleJmagValue() {
        return this.jm().doubleValue();
    }

    @Override
    public double doubleKmagValue() {
        return this.km().doubleValue();
    }

    public final double doubleRealValue() {
        return this.doubleValue();
    }

    @Override
    public long longValue() {
        return this.re().longValue();
    }

    public Complex complexPart() {
        return Complex.make(this.re(), this.im());
    }

    public Quaternion vectorPart() {
        return Quaternion.make(IntNum.zero(), this.im(), this.jm(), this.km());
    }

    public Quaternion unitVector() {
        int imSign = this.im().sign();
        int jmSign = this.jm().sign();
        int kmSign = this.km().sign();
        if (imSign == -2 || jmSign == -2 || kmSign == -2) {
            return Quaternion.make(0.0, Double.NaN, Double.NaN, Double.NaN);
        }
        if (imSign == 0 && jmSign == 0 && kmSign == 0) {
            return IntNum.zero();
        }
        if (imSign == 0 && jmSign == 0) {
            return kmSign == 1 ? Quaternion.kmOne() : Quaternion.kmMinusOne();
        }
        if (imSign == 0 && kmSign == 0) {
            return jmSign == 1 ? Quaternion.jmOne() : Quaternion.jmMinusOne();
        }
        if (jmSign == 0 && kmSign == 0) {
            return imSign == 1 ? Complex.imOne() : Complex.imMinusOne();
        }
        double im = this.doubleImagValue();
        double jm = this.doubleJmagValue();
        double km = this.doubleKmagValue();
        double vmag = DQuaternion.hypot3(im, jm, km);
        return Quaternion.make(0.0, im / vmag, jm / vmag, km / vmag);
    }

    public Quaternion unitQuaternion() {
        int reSign = this.re().sign();
        int imSign = this.im().sign();
        int jmSign = this.jm().sign();
        int kmSign = this.km().sign();
        if (reSign == -2 || imSign == -2 || jmSign == -2 || kmSign == -2) {
            return Quaternion.make(Double.NaN, Double.NaN, Double.NaN, Double.NaN);
        }
        if (imSign == 0 && jmSign == 0 && kmSign == 0) {
            return Quaternion.make((RealNum)this.re().unitQuaternion(), IntNum.zero(), IntNum.zero(), IntNum.zero());
        }
        if (reSign == 0 && jmSign == 0 && kmSign == 0) {
            return Quaternion.make(IntNum.zero(), (RealNum)this.im().unitQuaternion(), IntNum.zero(), IntNum.zero());
        }
        if (reSign == 0 && imSign == 0 && kmSign == 0) {
            return Quaternion.make(IntNum.zero(), IntNum.zero(), (RealNum)this.jm().unitQuaternion(), IntNum.zero());
        }
        if (reSign == 0 && imSign == 0 && jmSign == 0) {
            return Quaternion.make(IntNum.zero(), IntNum.zero(), IntNum.zero(), (RealNum)this.km().unitQuaternion());
        }
        double re = this.doubleRealValue();
        double im = this.doubleImagValue();
        double jm = this.doubleJmagValue();
        double km = this.doubleKmagValue();
        double mag = DQuaternion.hypot4(re, im, jm, km);
        return Quaternion.make(re / mag, im / mag, jm / mag, km / mag);
    }

    public static Quaternion make(RealNum re, RealNum im, RealNum jm, RealNum km) {
        if (km.isZero() && km.isExact() && jm.isZero() && jm.isExact()) {
            return Complex.make(re, im);
        }
        if (!(re.isExact() || im.isExact() || jm.isExact() || km.isExact())) {
            return new DQuaternion(re.doubleValue(), im.doubleValue(), jm.doubleValue(), km.doubleValue());
        }
        return new CQuaternion(re, im, jm, km);
    }

    public static Quaternion make(double re, double im, double jm, double km) {
        if (jm == 0.0 && km == 0.0) {
            return Complex.make(re, im);
        }
        return new DQuaternion(re, im, jm, km);
    }

    public static Quaternion polar(double r, double t, double u, double v) {
        double z = r * Math.sin(t) * Math.sin(u) * Math.sin(v);
        double y = r * Math.sin(t) * Math.sin(u) * Math.cos(v);
        double x = r * Math.sin(t) * Math.cos(u);
        double w = r * Math.cos(t);
        return Quaternion.make(w, x, y, z);
    }

    public static Quaternion polar(RealNum r, RealNum t, RealNum u, RealNum v) {
        return Quaternion.polar(r.doubleValue(), t.doubleValue(), u.doubleValue(), v.doubleValue());
    }

    public static Quaternion power(Quaternion x, Quaternion y) {
        if (y instanceof IntNum) {
            return (Quaternion)x.power((IntNum)y);
        }
        double y_re = y.doubleRealValue();
        double y_im = y.doubleImagValue();
        double y_jm = y.doubleJmagValue();
        double y_km = y.doubleKmagValue();
        if (x.isZero() && x.isExact() && y.isExact()) {
            if (y_re > 0.0) {
                return IntNum.zero();
            }
            if (y_re == 0.0 && y_im == 0.0 && y_jm == 0.0 && y_km == 0.0) {
                return IntNum.one();
            }
        }
        double x_re = x.doubleRealValue();
        double x_im = x.doubleImagValue();
        double x_jm = x.doubleJmagValue();
        double x_km = x.doubleKmagValue();
        if (x_im == 0.0 && y_im == 0.0 && x_jm == 0.0 && y_jm == 0.0 && x_km == 0.0 && y_km == 0.0 && (x_re >= 0.0 || Double.isInfinite(x_re) || Double.isNaN(x_re))) {
            return new DFloNum(Math.pow(x_re, y_re));
        }
        return DQuaternion.power(x_re, x_im, x_jm, x_km, y_re, y_im, y_jm, y_km);
    }

    @Override
    public Numeric abs() {
        return new DFloNum(DQuaternion.hypot4(this.doubleRealValue(), this.doubleImagValue(), this.doubleJmagValue(), this.doubleKmagValue()));
    }

    public RealNum angle() {
        return new DFloNum(Math.atan2(Math.hypot(Math.hypot(this.doubleImagValue(), this.doubleJmagValue()), this.doubleKmagValue()), this.doubleRealValue()));
    }

    public RealNum colatitude() {
        return new DFloNum(Math.atan2(Math.hypot(this.doubleJmagValue(), this.doubleKmagValue()), this.doubleImagValue()));
    }

    public RealNum longitude() {
        return new DFloNum(Math.atan2(this.doubleKmagValue(), this.doubleJmagValue()));
    }

    public Quaternion conjugate() {
        return Quaternion.make(this.re(), this.im().rneg(), this.jm().rneg(), this.km().rneg());
    }

    public static boolean equals(Quaternion x, Quaternion y) {
        return x.re().equals(y.re()) && x.im().equals(y.im()) && x.jm().equals(y.jm()) && x.km().equals(y.km());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Quaternion)) {
            return false;
        }
        return Quaternion.equals(this, (Quaternion)obj);
    }

    public static int compare(Quaternion x, Quaternion y) {
        int code = x.km().compare(y.km());
        if (code != 0) {
            return code;
        }
        code = x.jm().compare(y.jm());
        if (code != 0) {
            return code;
        }
        code = x.im().compare(y.im());
        if (code != 0) {
            return code;
        }
        return x.re().compare(y.re());
    }

    @Override
    public int compare(Object obj) {
        if (!(obj instanceof Quaternion)) {
            return ((Numeric)obj).compareReversed(this);
        }
        return Quaternion.compare(this, (Quaternion)obj);
    }

    @Override
    public boolean isZero() {
        return this.re().isZero() && this.im().isZero() && this.jm().isZero() && this.km().isZero();
    }

    @Override
    public String toString(int radix) {
        char ch0;
        if (this.im().isZero() && this.jm().isZero() && this.km().isZero()) {
            return this.re().toString(radix);
        }
        String imString = "";
        String jmString = "";
        String kmString = "";
        if (!this.im().isZero() && (ch0 = (imString = this.im().toString(radix) + "i").charAt(0)) != '-' && ch0 != '+') {
            imString = "+" + imString;
        }
        if (!this.jm().isZero() && (ch0 = (jmString = this.jm().toString(radix) + "j").charAt(0)) != '-' && ch0 != '+') {
            jmString = "+" + jmString;
        }
        if (!this.km().isZero() && (ch0 = (kmString = this.km().toString(radix) + "k").charAt(0)) != '-' && ch0 != '+') {
            kmString = "+" + kmString;
        }
        if (this.re().isZero()) {
            return imString + jmString + kmString;
        }
        return this.re().toString(radix) + imString + jmString + kmString;
    }

    public static Quaternion neg(Quaternion x) {
        return Quaternion.make(x.re().rneg(), x.im().rneg(), x.jm().rneg(), x.km().rneg());
    }

    @Override
    public Numeric neg() {
        return Quaternion.neg(this);
    }

    public static Quaternion add(Quaternion x, Quaternion y, int k) {
        return Quaternion.make(RealNum.add(x.re(), y.re(), k), RealNum.add(x.im(), y.im(), k), RealNum.add(x.jm(), y.jm(), k), RealNum.add(x.km(), y.km(), k));
    }

    @Override
    public Numeric add(Object y, int k) {
        if (y instanceof Quaternion) {
            return Quaternion.add(this, (Quaternion)y, k);
        }
        return ((Numeric)y).addReversed(this, k);
    }

    @Override
    public Numeric addReversed(Numeric x, int k) {
        if (x instanceof Quaternion) {
            return Quaternion.add((Quaternion)x, this, k);
        }
        throw new IllegalArgumentException();
    }

    public static Quaternion times(Quaternion x, Quaternion y) {
        RealNum x_re = x.re();
        RealNum x_im = x.im();
        RealNum x_jm = x.jm();
        RealNum x_km = x.km();
        RealNum y_re = y.re();
        RealNum y_im = y.im();
        RealNum y_jm = y.jm();
        RealNum y_km = y.km();
        RealNum r = RealNum.add(RealNum.add(RealNum.times(x_re, y_re), RealNum.times(x_im, y_im), -1), RealNum.add(RealNum.times(x_jm, y_jm), RealNum.times(x_km, y_km), 1), -1);
        RealNum i = RealNum.add(RealNum.add(RealNum.times(x_re, y_im), RealNum.times(x_im, y_re), 1), RealNum.add(RealNum.times(x_jm, y_km), RealNum.times(x_km, y_jm), -1), 1);
        RealNum j = RealNum.add(RealNum.add(RealNum.times(x_re, y_jm), RealNum.times(x_im, y_km), -1), RealNum.add(RealNum.times(x_jm, y_re), RealNum.times(x_km, y_im), 1), 1);
        RealNum k = RealNum.add(RealNum.add(RealNum.times(x_re, y_km), RealNum.times(x_im, y_jm), 1), RealNum.add(RealNum.times(x_jm, y_im), RealNum.times(x_km, y_re), -1), -1);
        return Quaternion.make(r, i, j, k);
    }

    @Override
    public Numeric mul(Object y) {
        if (y instanceof Quaternion) {
            return Quaternion.times(this, (Quaternion)y);
        }
        return ((Numeric)y).mulReversed(this);
    }

    @Override
    public Numeric mulReversed(Numeric x) {
        if (x instanceof Quaternion) {
            return Quaternion.times((Quaternion)x, this);
        }
        throw new IllegalArgumentException();
    }

    public static Quaternion divide(Quaternion x, Quaternion y) {
        if (!x.isExact() || !y.isExact()) {
            return DQuaternion.div(x.doubleRealValue(), x.doubleImagValue(), x.doubleJmagValue(), x.doubleKmagValue(), y.doubleRealValue(), y.doubleImagValue(), y.doubleJmagValue(), y.doubleKmagValue());
        }
        RealNum x_re = x.re();
        RealNum x_im = x.im();
        RealNum x_jm = x.jm();
        RealNum x_km = x.km();
        RealNum y_re = y.re();
        RealNum y_im = y.im();
        RealNum y_jm = y.jm();
        RealNum y_km = y.km();
        RealNum y_norm = RealNum.add(RealNum.add(RealNum.times(y_re, y_re), RealNum.times(y_im, y_im), 1), RealNum.add(RealNum.times(y_jm, y_jm), RealNum.times(y_km, y_km), 1), 1);
        RealNum r = RealNum.add(RealNum.add(RealNum.times(x_re, y_re), RealNum.times(x_im, y_im), 1), RealNum.add(RealNum.times(x_jm, y_jm), RealNum.times(x_km, y_km), 1), 1);
        RealNum i = RealNum.add(RealNum.add(RealNum.times(x_im, y_re), RealNum.times(x_re, y_im), -1), RealNum.add(RealNum.times(x_km, y_jm), RealNum.times(x_jm, y_km), -1), 1);
        RealNum j = RealNum.add(RealNum.add(RealNum.times(x_jm, y_re), RealNum.times(x_re, y_jm), -1), RealNum.add(RealNum.times(x_im, y_km), RealNum.times(x_km, y_im), -1), 1);
        RealNum k = RealNum.add(RealNum.add(RealNum.times(x_km, y_re), RealNum.times(x_re, y_km), -1), RealNum.add(RealNum.times(x_jm, y_im), RealNum.times(x_im, y_jm), -1), 1);
        return Quaternion.make(RealNum.divide(r, y_norm), RealNum.divide(i, y_norm), RealNum.divide(j, y_norm), RealNum.divide(k, y_norm));
    }

    @Override
    public Numeric div(Object y) {
        if (y instanceof Quaternion) {
            return Quaternion.divide(this, (Quaternion)y);
        }
        return ((Numeric)y).divReversed(this);
    }

    @Override
    public Numeric divReversed(Numeric x) {
        if (x instanceof Quaternion) {
            return Quaternion.divide((Quaternion)x, this);
        }
        throw new IllegalArgumentException();
    }

    public Quaternion exp() {
        return DQuaternion.exp(this.doubleRealValue(), this.doubleImagValue(), this.doubleJmagValue(), this.doubleKmagValue());
    }

    public Quaternion log() {
        return DQuaternion.log(this.doubleRealValue(), this.doubleImagValue(), this.doubleJmagValue(), this.doubleKmagValue());
    }

    public Quaternion sqrt() {
        return DQuaternion.sqrt(this.doubleRealValue(), this.doubleImagValue(), this.doubleJmagValue(), this.doubleKmagValue());
    }

    public Quaternion sin() {
        return DQuaternion.sin(this.doubleRealValue(), this.doubleImagValue(), this.doubleJmagValue(), this.doubleKmagValue());
    }

    public Quaternion cos() {
        return DQuaternion.cos(this.doubleRealValue(), this.doubleImagValue(), this.doubleJmagValue(), this.doubleKmagValue());
    }

    public Quaternion tan() {
        return DQuaternion.tan(this.doubleRealValue(), this.doubleImagValue(), this.doubleJmagValue(), this.doubleKmagValue());
    }
}

