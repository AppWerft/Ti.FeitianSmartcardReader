// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

public abstract class Quaternion extends Quantity
{
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
        final int r = this.re().classifyFinite();
        if (r < 0) {
            return r;
        }
        final int i = this.im().classifyFinite();
        if (i < 0) {
            return i;
        }
        final int j = this.jm().classifyFinite();
        if (j < 0) {
            return j;
        }
        final int k = this.km().classifyFinite();
        if (k < 0) {
            return k;
        }
        return r * i * j * k;
    }
    
    @Override
    public Quaternion toExact() {
        final RealNum re = this.re();
        final RealNum im = this.im();
        final RealNum jm = this.jm();
        final RealNum km = this.km();
        final RatNum xre = re.toExact();
        final RatNum xim = im.toExact();
        final RatNum xjm = jm.toExact();
        final RatNum xkm = km.toExact();
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
        if (Quaternion.jmOne == null) {
            Quaternion.jmOne = new CQuaternion(IntNum.zero(), IntNum.zero(), IntNum.one(), IntNum.zero());
        }
        return Quaternion.jmOne;
    }
    
    public static CQuaternion jmMinusOne() {
        if (Quaternion.jmMinusOne == null) {
            Quaternion.jmMinusOne = new CQuaternion(IntNum.zero(), IntNum.zero(), IntNum.minusOne(), IntNum.zero());
        }
        return Quaternion.jmMinusOne;
    }
    
    public static CQuaternion kmOne() {
        if (Quaternion.kmOne == null) {
            Quaternion.kmOne = new CQuaternion(IntNum.zero(), IntNum.zero(), IntNum.zero(), IntNum.one());
        }
        return Quaternion.kmOne;
    }
    
    public static CQuaternion kmMinusOne() {
        if (Quaternion.kmMinusOne == null) {
            Quaternion.kmMinusOne = new CQuaternion(IntNum.zero(), IntNum.zero(), IntNum.zero(), IntNum.minusOne());
        }
        return Quaternion.kmMinusOne;
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
        return make(IntNum.zero(), this.im(), this.jm(), this.km());
    }
    
    public Quaternion unitVector() {
        final int imSign = this.im().sign();
        final int jmSign = this.jm().sign();
        final int kmSign = this.km().sign();
        if (imSign == -2 || jmSign == -2 || kmSign == -2) {
            return make(0.0, Double.NaN, Double.NaN, Double.NaN);
        }
        if (imSign == 0 && jmSign == 0 && kmSign == 0) {
            return IntNum.zero();
        }
        if (imSign == 0 && jmSign == 0) {
            return (kmSign == 1) ? kmOne() : kmMinusOne();
        }
        if (imSign == 0 && kmSign == 0) {
            return (jmSign == 1) ? jmOne() : jmMinusOne();
        }
        if (jmSign == 0 && kmSign == 0) {
            return (imSign == 1) ? Complex.imOne() : Complex.imMinusOne();
        }
        final double im = this.doubleImagValue();
        final double jm = this.doubleJmagValue();
        final double km = this.doubleKmagValue();
        final double vmag = DQuaternion.hypot3(im, jm, km);
        return make(0.0, im / vmag, jm / vmag, km / vmag);
    }
    
    public Quaternion unitQuaternion() {
        final int reSign = this.re().sign();
        final int imSign = this.im().sign();
        final int jmSign = this.jm().sign();
        final int kmSign = this.km().sign();
        if (reSign == -2 || imSign == -2 || jmSign == -2 || kmSign == -2) {
            return make(Double.NaN, Double.NaN, Double.NaN, Double.NaN);
        }
        if (imSign == 0 && jmSign == 0 && kmSign == 0) {
            return make((RealNum)this.re().unitQuaternion(), IntNum.zero(), IntNum.zero(), IntNum.zero());
        }
        if (reSign == 0 && jmSign == 0 && kmSign == 0) {
            return make(IntNum.zero(), (RealNum)this.im().unitQuaternion(), IntNum.zero(), IntNum.zero());
        }
        if (reSign == 0 && imSign == 0 && kmSign == 0) {
            return make(IntNum.zero(), IntNum.zero(), (RealNum)this.jm().unitQuaternion(), IntNum.zero());
        }
        if (reSign == 0 && imSign == 0 && jmSign == 0) {
            return make(IntNum.zero(), IntNum.zero(), IntNum.zero(), (RealNum)this.km().unitQuaternion());
        }
        final double re = this.doubleRealValue();
        final double im = this.doubleImagValue();
        final double jm = this.doubleJmagValue();
        final double km = this.doubleKmagValue();
        final double mag = DQuaternion.hypot4(re, im, jm, km);
        return make(re / mag, im / mag, jm / mag, km / mag);
    }
    
    public static Quaternion make(final RealNum re, final RealNum im, final RealNum jm, final RealNum km) {
        if (km.isZero() && km.isExact() && jm.isZero() && jm.isExact()) {
            return Complex.make(re, im);
        }
        if (!re.isExact() && !im.isExact() && !jm.isExact() && !km.isExact()) {
            return new DQuaternion(re.doubleValue(), im.doubleValue(), jm.doubleValue(), km.doubleValue());
        }
        return new CQuaternion(re, im, jm, km);
    }
    
    public static Quaternion make(final double re, final double im, final double jm, final double km) {
        if (jm == 0.0 && km == 0.0) {
            return Complex.make(re, im);
        }
        return new DQuaternion(re, im, jm, km);
    }
    
    public static Quaternion polar(final double r, final double t, final double u, final double v) {
        final double z = r * Math.sin(t) * Math.sin(u) * Math.sin(v);
        final double y = r * Math.sin(t) * Math.sin(u) * Math.cos(v);
        final double x = r * Math.sin(t) * Math.cos(u);
        final double w = r * Math.cos(t);
        return make(w, x, y, z);
    }
    
    public static Quaternion polar(final RealNum r, final RealNum t, final RealNum u, final RealNum v) {
        return polar(r.doubleValue(), t.doubleValue(), u.doubleValue(), v.doubleValue());
    }
    
    public static Quaternion power(final Quaternion x, final Quaternion y) {
        if (y instanceof IntNum) {
            return (Quaternion)x.power((IntNum)y);
        }
        final double y_re = y.doubleRealValue();
        final double y_im = y.doubleImagValue();
        final double y_jm = y.doubleJmagValue();
        final double y_km = y.doubleKmagValue();
        if (x.isZero() && x.isExact() && y.isExact()) {
            if (y_re > 0.0) {
                return IntNum.zero();
            }
            if (y_re == 0.0 && y_im == 0.0 && y_jm == 0.0 && y_km == 0.0) {
                return IntNum.one();
            }
        }
        final double x_re = x.doubleRealValue();
        final double x_im = x.doubleImagValue();
        final double x_jm = x.doubleJmagValue();
        final double x_km = x.doubleKmagValue();
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
        return make(this.re(), this.im().rneg(), this.jm().rneg(), this.km().rneg());
    }
    
    public static boolean equals(final Quaternion x, final Quaternion y) {
        return x.re().equals(y.re()) && x.im().equals(y.im()) && x.jm().equals(y.jm()) && x.km().equals(y.km());
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj != null && obj instanceof Quaternion && equals(this, (Quaternion)obj);
    }
    
    public static int compare(final Quaternion x, final Quaternion y) {
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
    public int compare(final Object obj) {
        if (!(obj instanceof Quaternion)) {
            return ((Numeric)obj).compareReversed(this);
        }
        return compare(this, (Quaternion)obj);
    }
    
    @Override
    public boolean isZero() {
        return this.re().isZero() && this.im().isZero() && this.jm().isZero() && this.km().isZero();
    }
    
    @Override
    public String toString(final int radix) {
        if (this.im().isZero() && this.jm().isZero() && this.km().isZero()) {
            return this.re().toString(radix);
        }
        String imString = "";
        String jmString = "";
        String kmString = "";
        if (!this.im().isZero()) {
            imString = this.im().toString(radix) + "i";
            final char ch0 = imString.charAt(0);
            if (ch0 != '-' && ch0 != '+') {
                imString = "+" + imString;
            }
        }
        if (!this.jm().isZero()) {
            jmString = this.jm().toString(radix) + "j";
            final char ch0 = jmString.charAt(0);
            if (ch0 != '-' && ch0 != '+') {
                jmString = "+" + jmString;
            }
        }
        if (!this.km().isZero()) {
            kmString = this.km().toString(radix) + "k";
            final char ch0 = kmString.charAt(0);
            if (ch0 != '-' && ch0 != '+') {
                kmString = "+" + kmString;
            }
        }
        if (this.re().isZero()) {
            return imString + jmString + kmString;
        }
        return this.re().toString(radix) + imString + jmString + kmString;
    }
    
    public static Quaternion neg(final Quaternion x) {
        return make(x.re().rneg(), x.im().rneg(), x.jm().rneg(), x.km().rneg());
    }
    
    @Override
    public Numeric neg() {
        return neg(this);
    }
    
    public static Quaternion add(final Quaternion x, final Quaternion y, final int k) {
        return make(RealNum.add(x.re(), y.re(), k), RealNum.add(x.im(), y.im(), k), RealNum.add(x.jm(), y.jm(), k), RealNum.add(x.km(), y.km(), k));
    }
    
    @Override
    public Numeric add(final Object y, final int k) {
        if (y instanceof Quaternion) {
            return add(this, (Quaternion)y, k);
        }
        return ((Numeric)y).addReversed(this, k);
    }
    
    @Override
    public Numeric addReversed(final Numeric x, final int k) {
        if (x instanceof Quaternion) {
            return add((Quaternion)x, this, k);
        }
        throw new IllegalArgumentException();
    }
    
    public static Quaternion times(final Quaternion x, final Quaternion y) {
        final RealNum x_re = x.re();
        final RealNum x_im = x.im();
        final RealNum x_jm = x.jm();
        final RealNum x_km = x.km();
        final RealNum y_re = y.re();
        final RealNum y_im = y.im();
        final RealNum y_jm = y.jm();
        final RealNum y_km = y.km();
        final RealNum r = RealNum.add(RealNum.add(RealNum.times(x_re, y_re), RealNum.times(x_im, y_im), -1), RealNum.add(RealNum.times(x_jm, y_jm), RealNum.times(x_km, y_km), 1), -1);
        final RealNum i = RealNum.add(RealNum.add(RealNum.times(x_re, y_im), RealNum.times(x_im, y_re), 1), RealNum.add(RealNum.times(x_jm, y_km), RealNum.times(x_km, y_jm), -1), 1);
        final RealNum j = RealNum.add(RealNum.add(RealNum.times(x_re, y_jm), RealNum.times(x_im, y_km), -1), RealNum.add(RealNum.times(x_jm, y_re), RealNum.times(x_km, y_im), 1), 1);
        final RealNum k = RealNum.add(RealNum.add(RealNum.times(x_re, y_km), RealNum.times(x_im, y_jm), 1), RealNum.add(RealNum.times(x_jm, y_im), RealNum.times(x_km, y_re), -1), -1);
        return make(r, i, j, k);
    }
    
    @Override
    public Numeric mul(final Object y) {
        if (y instanceof Quaternion) {
            return times(this, (Quaternion)y);
        }
        return ((Numeric)y).mulReversed(this);
    }
    
    @Override
    public Numeric mulReversed(final Numeric x) {
        if (x instanceof Quaternion) {
            return times((Quaternion)x, this);
        }
        throw new IllegalArgumentException();
    }
    
    public static Quaternion divide(final Quaternion x, final Quaternion y) {
        if (!x.isExact() || !y.isExact()) {
            return DQuaternion.div(x.doubleRealValue(), x.doubleImagValue(), x.doubleJmagValue(), x.doubleKmagValue(), y.doubleRealValue(), y.doubleImagValue(), y.doubleJmagValue(), y.doubleKmagValue());
        }
        final RealNum x_re = x.re();
        final RealNum x_im = x.im();
        final RealNum x_jm = x.jm();
        final RealNum x_km = x.km();
        final RealNum y_re = y.re();
        final RealNum y_im = y.im();
        final RealNum y_jm = y.jm();
        final RealNum y_km = y.km();
        final RealNum y_norm = RealNum.add(RealNum.add(RealNum.times(y_re, y_re), RealNum.times(y_im, y_im), 1), RealNum.add(RealNum.times(y_jm, y_jm), RealNum.times(y_km, y_km), 1), 1);
        final RealNum r = RealNum.add(RealNum.add(RealNum.times(x_re, y_re), RealNum.times(x_im, y_im), 1), RealNum.add(RealNum.times(x_jm, y_jm), RealNum.times(x_km, y_km), 1), 1);
        final RealNum i = RealNum.add(RealNum.add(RealNum.times(x_im, y_re), RealNum.times(x_re, y_im), -1), RealNum.add(RealNum.times(x_km, y_jm), RealNum.times(x_jm, y_km), -1), 1);
        final RealNum j = RealNum.add(RealNum.add(RealNum.times(x_jm, y_re), RealNum.times(x_re, y_jm), -1), RealNum.add(RealNum.times(x_im, y_km), RealNum.times(x_km, y_im), -1), 1);
        final RealNum k = RealNum.add(RealNum.add(RealNum.times(x_km, y_re), RealNum.times(x_re, y_km), -1), RealNum.add(RealNum.times(x_jm, y_im), RealNum.times(x_im, y_jm), -1), 1);
        return make(RealNum.divide(r, y_norm), RealNum.divide(i, y_norm), RealNum.divide(j, y_norm), RealNum.divide(k, y_norm));
    }
    
    @Override
    public Numeric div(final Object y) {
        if (y instanceof Quaternion) {
            return divide(this, (Quaternion)y);
        }
        return ((Numeric)y).divReversed(this);
    }
    
    @Override
    public Numeric divReversed(final Numeric x) {
        if (x instanceof Quaternion) {
            return divide((Quaternion)x, this);
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
