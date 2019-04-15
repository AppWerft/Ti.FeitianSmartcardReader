/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.BaseUnit;
import gnu.math.CComplex;
import gnu.math.Complex;
import gnu.math.DFloNum;
import gnu.math.Dimensions;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.Quaternion;
import gnu.math.RealNum;
import gnu.math.Unit;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class DComplex
extends Complex
implements Externalizable {
    double real;
    double imag;

    public DComplex() {
    }

    public DComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
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
    public boolean isExact() {
        return false;
    }

    @Override
    public Complex toExact() {
        return new CComplex(DFloNum.toExact(this.real), DFloNum.toExact(this.imag));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Complex)) {
            return false;
        }
        Complex y = (Complex)obj;
        return y.unit() == Unit.Empty && Double.doubleToLongBits(this.real) == Double.doubleToLongBits(y.reValue()) && Double.doubleToLongBits(this.imag) == Double.doubleToLongBits(y.imValue());
    }

    @Override
    public String toString() {
        char ch0;
        String prefix = "";
        String reString = DFloNum.toString(this.real);
        if (Double.doubleToLongBits(this.imag) == 0L) {
            return reString;
        }
        String imString = DFloNum.toString(this.imag);
        StringBuilder sbuf = new StringBuilder();
        if (!reString.equals("0.0")) {
            sbuf.append(reString);
        }
        if ((ch0 = imString.charAt(0)) != '-' && ch0 != '+') {
            sbuf.append('+');
        }
        sbuf.append(imString);
        sbuf.append('i');
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
        return new DComplex(-this.real, -this.imag);
    }

    @Override
    public Numeric add(Object y, int k) {
        if (y instanceof Complex) {
            Complex yc = (Complex)y;
            if (yc.dimensions() != Dimensions.Empty) {
                throw new ArithmeticException("units mis-match");
            }
            return new DComplex(this.real + (double)k * yc.reValue(), this.imag + (double)k * yc.imValue());
        }
        return ((Numeric)y).addReversed(this, k);
    }

    @Override
    public Numeric mul(Object y) {
        if (y instanceof Complex) {
            Complex yc = (Complex)y;
            if (yc.unit() == Unit.Empty) {
                double y_re = yc.reValue();
                double y_im = yc.imValue();
                return new DComplex(this.real * y_re - this.imag * y_im, this.real * y_im + this.imag * y_re);
            }
            return Complex.times(this, yc);
        }
        return ((Numeric)y).mulReversed(this);
    }

    @Override
    public Numeric div(Object y) {
        if (y instanceof Complex) {
            Complex yc = (Complex)y;
            return DComplex.div(this.real, this.imag, yc.doubleValue(), yc.doubleImagValue());
        }
        return ((Numeric)y).divReversed(this);
    }

    public static Complex power(double x_re, double x_im, double y_re, double y_im) {
        if (x_re == 0.0 && x_im == 0.0) {
            if (y_re > 0.0) {
                return DFloNum.zero();
            }
            if (y_re == 0.0 && y_im == 0.0) {
                return DFloNum.valueOf(1.0);
            }
        }
        double h = Math.hypot(x_re, x_im);
        double logr = Math.log(h);
        double t = Math.atan2(x_im, x_re);
        double r = Math.exp(logr * y_re - y_im * t);
        t = y_im * logr + y_re * t;
        return Complex.polar(r, t);
    }

    public static Complex log(double x_re, double x_im) {
        double h = Math.hypot(x_re, x_im);
        return DComplex.make(Math.log(h), Math.atan2(x_im, x_re));
    }

    public static DComplex div(double x_re, double x_im, double y_re, double y_im) {
        double ai;
        double ni;
        double d;
        double nr;
        double ar = Math.abs(y_re);
        if (ar <= (ai = Math.abs(y_im))) {
            double t = y_re / y_im;
            d = y_im * (1.0 + t * t);
            nr = x_re * t + x_im;
            ni = x_im * t - x_re;
        } else {
            double t = y_im / y_re;
            d = y_re * (1.0 + t * t);
            nr = x_re + x_im * t;
            ni = x_im - x_re * t;
        }
        return new DComplex(nr / d, ni / d);
    }

    public static Complex sqrt(double x_re, double x_im) {
        double nr;
        double ni;
        double r = Math.hypot(x_re, x_im);
        if (r == 0.0) {
            nr = ni = r;
        } else if (x_re > 0.0) {
            nr = Math.sqrt(0.5 * (r + x_re));
            ni = x_im / nr / 2.0;
        } else {
            ni = Math.sqrt(0.5 * (r - x_re));
            if (x_im < 0.0) {
                ni = -ni;
            }
            nr = x_im / ni / 2.0;
        }
        return new DComplex(nr, ni);
    }

    public static Complex sin(double x_re, double x_im) {
        if (x_im == 0.0) {
            return new DFloNum(Math.sin(x_re));
        }
        return Complex.make(Math.sin(x_re) * Math.cosh(x_im), Math.cos(x_re) * Math.sinh(x_im));
    }

    public static Complex cos(double x_re, double x_im) {
        if (x_im == 0.0) {
            return new DFloNum(Math.cos(x_re));
        }
        return Complex.make(Math.cos(x_re) * Math.cosh(x_im), -Math.sin(x_re) * Math.sinh(x_im));
    }

    public static Complex tan(double x_re, double x_im) {
        if (x_im == 0.0) {
            return new DFloNum(Math.tan(x_re));
        }
        double sin_re = Math.sin(x_re);
        double cos_re = Math.cos(x_re);
        double sinh_im = Math.sinh(x_im);
        double cosh_im = Math.cosh(x_im);
        return DComplex.div(sin_re * cosh_im, cos_re * sinh_im, cos_re * cosh_im, -sin_re * sinh_im);
    }

    public static Complex unitQuaternion(double x_re, double x_im) {
        double r = Math.hypot(x_re, x_im);
        if (r == 0.0) {
            return IntNum.zero();
        }
        return Complex.make(x_re / r, x_im / r);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(this.real);
        out.writeDouble(this.imag);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.real = in.readDouble();
        this.imag = in.readDouble();
    }
}

