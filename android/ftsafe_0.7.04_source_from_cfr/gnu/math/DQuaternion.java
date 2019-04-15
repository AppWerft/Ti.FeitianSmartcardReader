/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.BaseUnit;
import gnu.math.CQuaternion;
import gnu.math.Complex;
import gnu.math.DComplex;
import gnu.math.DFloNum;
import gnu.math.Dimensions;
import gnu.math.Numeric;
import gnu.math.Quaternion;
import gnu.math.RealNum;
import gnu.math.Unit;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class DQuaternion
extends Quaternion
implements Externalizable {
    double real;
    double imag;
    double jmag;
    double kmag;

    public DQuaternion() {
    }

    public DQuaternion(double real, double imag, double jmag, double kmag) {
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
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Quaternion)) {
            return false;
        }
        Quaternion y = (Quaternion)obj;
        return y.unit() == Unit.Empty && Double.doubleToLongBits(this.real) == Double.doubleToLongBits(y.reValue()) && Double.doubleToLongBits(this.imag) == Double.doubleToLongBits(y.imValue()) && Double.doubleToLongBits(this.jmag) == Double.doubleToLongBits(y.jmValue()) && Double.doubleToLongBits(this.kmag) == Double.doubleToLongBits(y.kmValue());
    }

    @Override
    public String toString() {
        char ch0;
        String reString = DFloNum.toString(this.real);
        if (Double.doubleToLongBits(this.imag) == 0L && Double.doubleToLongBits(this.jmag) == 0L && Double.doubleToLongBits(this.kmag) == 0L) {
            return reString;
        }
        StringBuilder sbuf = new StringBuilder();
        if (!reString.equals("0.0")) {
            sbuf.append(reString);
        }
        if (Double.doubleToLongBits(this.imag) != 0L) {
            String imString = DFloNum.toString(this.imag);
            ch0 = imString.charAt(0);
            if (ch0 != '-' && ch0 != '+') {
                sbuf.append('+');
            }
            sbuf.append(imString);
            sbuf.append('i');
        }
        if (Double.doubleToLongBits(this.jmag) != 0L) {
            String jmString = DFloNum.toString(this.jmag);
            ch0 = jmString.charAt(0);
            if (ch0 != '-' && ch0 != '+') {
                sbuf.append('+');
            }
            sbuf.append(jmString);
            sbuf.append('j');
        }
        if (Double.doubleToLongBits(this.kmag) != 0L) {
            String kmString = DFloNum.toString(this.kmag);
            ch0 = kmString.charAt(0);
            if (ch0 != '-' && ch0 != '+') {
                sbuf.append('+');
            }
            sbuf.append(kmString);
            sbuf.append('k');
        }
        return sbuf.toString();
    }

    @Override
    public String toString(int radix) {
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
    public Numeric add(Object y, int k) {
        if (y instanceof Quaternion) {
            Quaternion yq = (Quaternion)y;
            if (yq.dimensions() != Dimensions.Empty) {
                throw new ArithmeticException("units mis-match");
            }
            return Quaternion.make(this.real + (double)k * yq.reValue(), this.imag + (double)k * yq.imValue(), this.jmag + (double)k * yq.jmValue(), this.kmag + (double)k * yq.kmValue());
        }
        return ((Numeric)y).addReversed(this, k);
    }

    @Override
    public Numeric mul(Object y) {
        if (y instanceof Quaternion) {
            Quaternion yq = (Quaternion)y;
            if (yq.unit() == Unit.Empty) {
                double y_re = yq.reValue();
                double y_im = yq.imValue();
                double y_jm = yq.jmValue();
                double y_km = yq.kmValue();
                return Quaternion.make(this.real * y_re - this.imag * y_im - this.jmag * y_jm - this.kmag * y_km, this.real * y_im + this.imag * y_re + this.jmag * y_km - this.kmag * y_jm, this.real * y_jm - this.imag * y_km + this.jmag * y_re + this.kmag * y_im, this.real * y_km + this.imag * y_jm - this.jmag * y_im + this.kmag * y_re);
            }
            return Quaternion.times(this, yq);
        }
        return ((Numeric)y).mulReversed(this);
    }

    @Override
    public Numeric div(Object y) {
        if (y instanceof Quaternion) {
            Quaternion yq = (Quaternion)y;
            return DQuaternion.div(this.real, this.imag, this.jmag, this.kmag, yq.doubleValue(), yq.doubleImagValue(), yq.doubleJmagValue(), yq.doubleKmagValue());
        }
        return ((Numeric)y).divReversed(this);
    }

    public static double hypot4(double w, double x, double y, double z) {
        return Math.hypot(Math.hypot(w, x), Math.hypot(y, z));
    }

    public static double hypot3(double x, double y, double z) {
        return Math.hypot(Math.hypot(x, y), z);
    }

    public static Quaternion power(double x_re, double x_im, double x_jm, double x_km, double y_re, double y_im, double y_jm, double y_km) {
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
        double qmag = DQuaternion.hypot4(x_re, x_im, x_jm, x_km);
        double vmag = DQuaternion.hypot3(x_im, x_jm, x_km);
        double atv = Math.atan2(vmag, x_re) / vmag;
        double ln_r = Math.log(qmag);
        double ln_i = atv * x_im;
        double ln_j = atv * x_jm;
        double ln_k = atv * x_km;
        double p_r = ln_r * y_re - ln_i * y_im - ln_j * y_jm - ln_k * y_km;
        double p_i = ln_r * y_im + ln_i * y_re + ln_j * y_km - ln_k * y_jm;
        double p_j = ln_r * y_jm - ln_i * y_km + ln_j * y_re + ln_k * y_im;
        double p_k = ln_r * y_km + ln_i * y_jm - ln_j * y_im + ln_k * y_re;
        double pvmag = DQuaternion.hypot3(p_i, p_j, p_k);
        double sinpvmag = Math.sin(pvmag);
        double expr = Math.exp(p_r);
        if (pvmag == 0.0 || sinpvmag == 0.0) {
            return DFloNum.valueOf(expr * Math.cos(pvmag));
        }
        return Quaternion.make(expr * Math.cos(pvmag), expr * sinpvmag * p_i / pvmag, expr * sinpvmag * p_j / pvmag, expr * sinpvmag * p_k / pvmag);
    }

    public static Quaternion exp(double x_re, double x_im, double x_jm, double x_km) {
        if (x_jm == 0.0 && x_km == 0.0) {
            return Complex.polar(Math.exp(x_re), x_im);
        }
        double vmag = DQuaternion.hypot3(x_im, x_jm, x_km);
        double sinvmag = Math.sin(vmag);
        double expr = Math.exp(x_re);
        return Quaternion.make(expr * Math.cos(vmag), expr * sinvmag * x_im / vmag, expr * sinvmag * x_jm / vmag, expr * sinvmag * x_km / vmag);
    }

    public static Quaternion log(double x_re, double x_im, double x_jm, double x_km) {
        if (x_jm == 0.0 && x_km == 0.0) {
            return DComplex.log(x_re, x_im);
        }
        double qmag = DQuaternion.hypot4(x_re, x_im, x_jm, x_km);
        double vmag = DQuaternion.hypot3(x_im, x_jm, x_km);
        double atv = Math.atan2(vmag, x_re) / vmag;
        double r = Math.log(qmag);
        double i = atv * x_im;
        double j = atv * x_jm;
        double k = atv * x_km;
        return Quaternion.make(r, i, j, k);
    }

    public static Quaternion div(double x_re, double x_im, double x_jm, double x_km, double y_re, double y_im, double y_jm, double y_km) {
        if (x_jm == 0.0 && x_km == 0.0 && y_jm == 0.0 && y_km == 0.0) {
            return DComplex.div(x_re, x_im, y_re, y_im);
        }
        double y_norm = y_re * y_re + y_im * y_im + y_jm * y_jm + y_km * y_km;
        double r = x_re * y_re + x_im * y_im + x_jm * y_jm + x_km * y_km;
        double i = x_im * y_re - x_re * y_im + x_km * y_jm - x_jm * y_km;
        double j = x_jm * y_re - x_re * y_jm + x_im * y_km - x_km * y_im;
        double k = x_km * y_re - x_re * y_km + x_jm * y_im - x_im * y_jm;
        return Quaternion.make(r / y_norm, i / y_norm, j / y_norm, k / y_norm);
    }

    public static Quaternion sqrt(double x_re, double x_im, double x_jm, double x_km) {
        if (x_jm == 0.0 && x_km == 0.0) {
            return DComplex.sqrt(x_re, x_im);
        }
        double qmag = DQuaternion.hypot4(x_re, x_im, x_jm, x_km);
        double vmag = DQuaternion.hypot3(x_im, x_jm, x_km);
        double t = Math.acos(x_re / qmag);
        double y_mag = Math.sqrt(qmag);
        double s = Math.sin(t / 2.0);
        return Quaternion.make(y_mag * Math.cos(t / 2.0), y_mag * s * x_im / vmag, y_mag * s * x_jm / vmag, y_mag * s * x_km / vmag);
    }

    public static Quaternion sin(double x_re, double x_im, double x_jm, double x_km) {
        if (x_jm == 0.0 && x_km == 0.0) {
            return DComplex.sin(x_re, x_im);
        }
        double vmag = DQuaternion.hypot3(x_im, x_jm, x_km);
        double r = Math.sin(x_re) * Math.cosh(vmag);
        double v = Math.cos(x_re) * Math.sinh(vmag);
        return Quaternion.make(r, v * x_im / vmag, v * x_jm / vmag, v * x_km / vmag);
    }

    public static Quaternion cos(double x_re, double x_im, double x_jm, double x_km) {
        if (x_jm == 0.0 && x_km == 0.0) {
            return DComplex.cos(x_re, x_im);
        }
        double vmag = DQuaternion.hypot3(x_im, x_jm, x_km);
        double r = Math.cos(x_re) * Math.cosh(vmag);
        double v = -Math.sin(x_re) * Math.sinh(vmag);
        return Quaternion.make(r, v * x_im / vmag, v * x_jm / vmag, v * x_km / vmag);
    }

    public static Quaternion tan(double x_re, double x_im, double x_jm, double x_km) {
        if (x_jm == 0.0 && x_km == 0.0) {
            return DComplex.tan(x_re, x_im);
        }
        double vmag = DQuaternion.hypot3(x_im, x_jm, x_km);
        double sin_re = Math.sin(x_re);
        double cos_re = Math.cos(x_re);
        double sinh_v = Math.sinh(vmag);
        double cosh_v = Math.cosh(vmag);
        return DQuaternion.div(sin_re * cosh_v, cos_re * sinh_v * x_im / vmag, cos_re * sinh_v * x_jm / vmag, cos_re * sinh_v * x_km / vmag, cos_re * cosh_v, -sin_re * sinh_v * x_im / vmag, -sin_re * sinh_v * x_jm / vmag, -sin_re * sinh_v * x_km / vmag);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(this.real);
        out.writeDouble(this.imag);
        out.writeDouble(this.jmag);
        out.writeDouble(this.kmag);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.real = in.readDouble();
        this.imag = in.readDouble();
        this.jmag = in.readDouble();
        this.kmag = in.readDouble();
    }
}

