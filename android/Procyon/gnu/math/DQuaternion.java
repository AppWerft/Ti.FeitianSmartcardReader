// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class DQuaternion extends Quaternion implements Externalizable
{
    double real;
    double imag;
    double jmag;
    double kmag;
    
    public DQuaternion() {
    }
    
    public DQuaternion(final double real, final double imag, final double jmag, final double kmag) {
        this.real = real;
        this.imag = imag;
        this.jmag = jmag;
        this.kmag = kmag;
    }
    
    @Override
    public RealNum re() {
        return new DFloNum(this.real);
    }
    
    @Override
    public double doubleValue() {
        return this.real;
    }
    
    @Override
    public RealNum im() {
        return new DFloNum(this.imag);
    }
    
    @Override
    public double doubleImagValue() {
        return this.imag;
    }
    
    @Override
    public RealNum jm() {
        return new DFloNum(this.jmag);
    }
    
    @Override
    public double doubleJmagValue() {
        return this.jmag;
    }
    
    @Override
    public RealNum km() {
        return new DFloNum(this.kmag);
    }
    
    @Override
    public double doubleKmagValue() {
        return this.kmag;
    }
    
    @Override
    public boolean isExact() {
        return false;
    }
    
    @Override
    public Quaternion toExact() {
        return new CQuaternion(DFloNum.toExact(this.real), DFloNum.toExact(this.imag), DFloNum.toExact(this.jmag), DFloNum.toExact(this.kmag));
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !(obj instanceof Quaternion)) {
            return false;
        }
        final Quaternion y = (Quaternion)obj;
        return y.unit() == Unit.Empty && Double.doubleToLongBits(this.real) == Double.doubleToLongBits(y.reValue()) && Double.doubleToLongBits(this.imag) == Double.doubleToLongBits(y.imValue()) && Double.doubleToLongBits(this.jmag) == Double.doubleToLongBits(y.jmValue()) && Double.doubleToLongBits(this.kmag) == Double.doubleToLongBits(y.kmValue());
    }
    
    @Override
    public String toString() {
        final String reString = DFloNum.toString(this.real);
        if (Double.doubleToLongBits(this.imag) == 0L && Double.doubleToLongBits(this.jmag) == 0L && Double.doubleToLongBits(this.kmag) == 0L) {
            return reString;
        }
        final StringBuilder sbuf = new StringBuilder();
        if (!reString.equals("0.0")) {
            sbuf.append(reString);
        }
        if (Double.doubleToLongBits(this.imag) != 0L) {
            final String imString = DFloNum.toString(this.imag);
            final char ch0 = imString.charAt(0);
            if (ch0 != '-' && ch0 != '+') {
                sbuf.append('+');
            }
            sbuf.append(imString);
            sbuf.append('i');
        }
        if (Double.doubleToLongBits(this.jmag) != 0L) {
            final String jmString = DFloNum.toString(this.jmag);
            final char ch0 = jmString.charAt(0);
            if (ch0 != '-' && ch0 != '+') {
                sbuf.append('+');
            }
            sbuf.append(jmString);
            sbuf.append('j');
        }
        if (Double.doubleToLongBits(this.kmag) != 0L) {
            final String kmString = DFloNum.toString(this.kmag);
            final char ch0 = kmString.charAt(0);
            if (ch0 != '-' && ch0 != '+') {
                sbuf.append('+');
            }
            sbuf.append(kmString);
            sbuf.append('k');
        }
        return sbuf.toString();
    }
    
    @Override
    public String toString(final int radix) {
        if (radix == 10) {
            return this.toString();
        }
        return "#d" + this.toString();
    }
    
    @Override
    public final Numeric neg() {
        return new DQuaternion(-this.real, -this.imag, -this.jmag, -this.kmag);
    }
    
    @Override
    public Numeric add(final Object y, final int k) {
        if (!(y instanceof Quaternion)) {
            return ((Numeric)y).addReversed(this, k);
        }
        final Quaternion yq = (Quaternion)y;
        if (yq.dimensions() != Dimensions.Empty) {
            throw new ArithmeticException("units mis-match");
        }
        return Quaternion.make(this.real + k * yq.reValue(), this.imag + k * yq.imValue(), this.jmag + k * yq.jmValue(), this.kmag + k * yq.kmValue());
    }
    
    @Override
    public Numeric mul(final Object y) {
        if (!(y instanceof Quaternion)) {
            return ((Numeric)y).mulReversed(this);
        }
        final Quaternion yq = (Quaternion)y;
        if (yq.unit() == Unit.Empty) {
            final double y_re = yq.reValue();
            final double y_im = yq.imValue();
            final double y_jm = yq.jmValue();
            final double y_km = yq.kmValue();
            return Quaternion.make(this.real * y_re - this.imag * y_im - this.jmag * y_jm - this.kmag * y_km, this.real * y_im + this.imag * y_re + this.jmag * y_km - this.kmag * y_jm, this.real * y_jm - this.imag * y_km + this.jmag * y_re + this.kmag * y_im, this.real * y_km + this.imag * y_jm - this.jmag * y_im + this.kmag * y_re);
        }
        return Quaternion.times(this, yq);
    }
    
    @Override
    public Numeric div(final Object y) {
        if (y instanceof Quaternion) {
            final Quaternion yq = (Quaternion)y;
            return div(this.real, this.imag, this.jmag, this.kmag, yq.doubleValue(), yq.doubleImagValue(), yq.doubleJmagValue(), yq.doubleKmagValue());
        }
        return ((Numeric)y).divReversed(this);
    }
    
    public static double hypot4(final double w, final double x, final double y, final double z) {
        return Math.hypot(Math.hypot(w, x), Math.hypot(y, z));
    }
    
    public static double hypot3(final double x, final double y, final double z) {
        return Math.hypot(Math.hypot(x, y), z);
    }
    
    public static Quaternion power(final double x_re, final double x_im, final double x_jm, final double x_km, final double y_re, final double y_im, final double y_jm, final double y_km) {
        if (x_jm == 0.0 && x_km == 0.0 && y_jm == 0.0 && y_km == 0.0) {
            return DComplex.power(x_re, x_im, y_re, y_im);
        }
        if (x_re == 0.0 && x_im == 0.0 && x_jm == 0.0 && x_km == 0.0) {
            if (y_re > 0.0) {
                return DFloNum.valueOf(0.0);
            }
            if (y_re == 0.0 && y_im == 0.0 && y_jm == 0.0 && y_km == 0.0) {
                return DFloNum.valueOf(1.0);
            }
        }
        final double qmag = hypot4(x_re, x_im, x_jm, x_km);
        final double vmag = hypot3(x_im, x_jm, x_km);
        final double atv = Math.atan2(vmag, x_re) / vmag;
        final double ln_r = Math.log(qmag);
        final double ln_i = atv * x_im;
        final double ln_j = atv * x_jm;
        final double ln_k = atv * x_km;
        final double p_r = ln_r * y_re - ln_i * y_im - ln_j * y_jm - ln_k * y_km;
        final double p_i = ln_r * y_im + ln_i * y_re + ln_j * y_km - ln_k * y_jm;
        final double p_j = ln_r * y_jm - ln_i * y_km + ln_j * y_re + ln_k * y_im;
        final double p_k = ln_r * y_km + ln_i * y_jm - ln_j * y_im + ln_k * y_re;
        final double pvmag = hypot3(p_i, p_j, p_k);
        final double sinpvmag = Math.sin(pvmag);
        final double expr = Math.exp(p_r);
        if (pvmag == 0.0 || sinpvmag == 0.0) {
            return DFloNum.valueOf(expr * Math.cos(pvmag));
        }
        return Quaternion.make(expr * Math.cos(pvmag), expr * sinpvmag * p_i / pvmag, expr * sinpvmag * p_j / pvmag, expr * sinpvmag * p_k / pvmag);
    }
    
    public static Quaternion exp(final double x_re, final double x_im, final double x_jm, final double x_km) {
        if (x_jm == 0.0 && x_km == 0.0) {
            return Complex.polar(Math.exp(x_re), x_im);
        }
        final double vmag = hypot3(x_im, x_jm, x_km);
        final double sinvmag = Math.sin(vmag);
        final double expr = Math.exp(x_re);
        return Quaternion.make(expr * Math.cos(vmag), expr * sinvmag * x_im / vmag, expr * sinvmag * x_jm / vmag, expr * sinvmag * x_km / vmag);
    }
    
    public static Quaternion log(final double x_re, final double x_im, final double x_jm, final double x_km) {
        if (x_jm == 0.0 && x_km == 0.0) {
            return DComplex.log(x_re, x_im);
        }
        final double qmag = hypot4(x_re, x_im, x_jm, x_km);
        final double vmag = hypot3(x_im, x_jm, x_km);
        final double atv = Math.atan2(vmag, x_re) / vmag;
        final double r = Math.log(qmag);
        final double i = atv * x_im;
        final double j = atv * x_jm;
        final double k = atv * x_km;
        return Quaternion.make(r, i, j, k);
    }
    
    public static Quaternion div(final double x_re, final double x_im, final double x_jm, final double x_km, final double y_re, final double y_im, final double y_jm, final double y_km) {
        if (x_jm == 0.0 && x_km == 0.0 && y_jm == 0.0 && y_km == 0.0) {
            return DComplex.div(x_re, x_im, y_re, y_im);
        }
        final double y_norm = y_re * y_re + y_im * y_im + y_jm * y_jm + y_km * y_km;
        final double r = x_re * y_re + x_im * y_im + x_jm * y_jm + x_km * y_km;
        final double i = x_im * y_re - x_re * y_im + x_km * y_jm - x_jm * y_km;
        final double j = x_jm * y_re - x_re * y_jm + x_im * y_km - x_km * y_im;
        final double k = x_km * y_re - x_re * y_km + x_jm * y_im - x_im * y_jm;
        return Quaternion.make(r / y_norm, i / y_norm, j / y_norm, k / y_norm);
    }
    
    public static Quaternion sqrt(final double x_re, final double x_im, final double x_jm, final double x_km) {
        if (x_jm == 0.0 && x_km == 0.0) {
            return DComplex.sqrt(x_re, x_im);
        }
        final double qmag = hypot4(x_re, x_im, x_jm, x_km);
        final double vmag = hypot3(x_im, x_jm, x_km);
        final double t = Math.acos(x_re / qmag);
        final double y_mag = Math.sqrt(qmag);
        final double s = Math.sin(t / 2.0);
        return Quaternion.make(y_mag * Math.cos(t / 2.0), y_mag * s * x_im / vmag, y_mag * s * x_jm / vmag, y_mag * s * x_km / vmag);
    }
    
    public static Quaternion sin(final double x_re, final double x_im, final double x_jm, final double x_km) {
        if (x_jm == 0.0 && x_km == 0.0) {
            return DComplex.sin(x_re, x_im);
        }
        final double vmag = hypot3(x_im, x_jm, x_km);
        final double r = Math.sin(x_re) * Math.cosh(vmag);
        final double v = Math.cos(x_re) * Math.sinh(vmag);
        return Quaternion.make(r, v * x_im / vmag, v * x_jm / vmag, v * x_km / vmag);
    }
    
    public static Quaternion cos(final double x_re, final double x_im, final double x_jm, final double x_km) {
        if (x_jm == 0.0 && x_km == 0.0) {
            return DComplex.cos(x_re, x_im);
        }
        final double vmag = hypot3(x_im, x_jm, x_km);
        final double r = Math.cos(x_re) * Math.cosh(vmag);
        final double v = -Math.sin(x_re) * Math.sinh(vmag);
        return Quaternion.make(r, v * x_im / vmag, v * x_jm / vmag, v * x_km / vmag);
    }
    
    public static Quaternion tan(final double x_re, final double x_im, final double x_jm, final double x_km) {
        if (x_jm == 0.0 && x_km == 0.0) {
            return DComplex.tan(x_re, x_im);
        }
        final double vmag = hypot3(x_im, x_jm, x_km);
        final double sin_re = Math.sin(x_re);
        final double cos_re = Math.cos(x_re);
        final double sinh_v = Math.sinh(vmag);
        final double cosh_v = Math.cosh(vmag);
        return div(sin_re * cosh_v, cos_re * sinh_v * x_im / vmag, cos_re * sinh_v * x_jm / vmag, cos_re * sinh_v * x_km / vmag, cos_re * cosh_v, -sin_re * sinh_v * x_im / vmag, -sin_re * sinh_v * x_jm / vmag, -sin_re * sinh_v * x_km / vmag);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeDouble(this.real);
        out.writeDouble(this.imag);
        out.writeDouble(this.jmag);
        out.writeDouble(this.kmag);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.real = in.readDouble();
        this.imag = in.readDouble();
        this.jmag = in.readDouble();
        this.kmag = in.readDouble();
    }
}
