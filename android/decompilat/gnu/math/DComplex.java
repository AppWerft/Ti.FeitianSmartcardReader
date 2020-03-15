// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class DComplex extends Complex implements Externalizable
{
    double real;
    double imag;
    
    public DComplex() {
    }
    
    public DComplex(final double real, final double imag) {
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
    public boolean equals(final Object obj) {
        if (obj == null || !(obj instanceof Complex)) {
            return false;
        }
        final Complex y = (Complex)obj;
        return y.unit() == Unit.Empty && Double.doubleToLongBits(this.real) == Double.doubleToLongBits(y.reValue()) && Double.doubleToLongBits(this.imag) == Double.doubleToLongBits(y.imValue());
    }
    
    @Override
    public String toString() {
        final String prefix = "";
        final String reString = DFloNum.toString(this.real);
        if (Double.doubleToLongBits(this.imag) == 0L) {
            return reString;
        }
        final String imString = DFloNum.toString(this.imag);
        final StringBuilder sbuf = new StringBuilder();
        if (!reString.equals("0.0")) {
            sbuf.append(reString);
        }
        final char ch0 = imString.charAt(0);
        if (ch0 != '-' && ch0 != '+') {
            sbuf.append('+');
        }
        sbuf.append(imString);
        sbuf.append('i');
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
        return new DComplex(-this.real, -this.imag);
    }
    
    @Override
    public Numeric add(final Object y, final int k) {
        if (!(y instanceof Complex)) {
            return ((Numeric)y).addReversed(this, k);
        }
        final Complex yc = (Complex)y;
        if (yc.dimensions() != Dimensions.Empty) {
            throw new ArithmeticException("units mis-match");
        }
        return new DComplex(this.real + k * yc.reValue(), this.imag + k * yc.imValue());
    }
    
    @Override
    public Numeric mul(final Object y) {
        if (!(y instanceof Complex)) {
            return ((Numeric)y).mulReversed(this);
        }
        final Complex yc = (Complex)y;
        if (yc.unit() == Unit.Empty) {
            final double y_re = yc.reValue();
            final double y_im = yc.imValue();
            return new DComplex(this.real * y_re - this.imag * y_im, this.real * y_im + this.imag * y_re);
        }
        return Complex.times(this, yc);
    }
    
    @Override
    public Numeric div(final Object y) {
        if (y instanceof Complex) {
            final Complex yc = (Complex)y;
            return div(this.real, this.imag, yc.doubleValue(), yc.doubleImagValue());
        }
        return ((Numeric)y).divReversed(this);
    }
    
    public static Complex power(final double x_re, final double x_im, final double y_re, final double y_im) {
        if (x_re == 0.0 && x_im == 0.0) {
            if (y_re > 0.0) {
                return DFloNum.zero();
            }
            if (y_re == 0.0 && y_im == 0.0) {
                return DFloNum.valueOf(1.0);
            }
        }
        final double h = Math.hypot(x_re, x_im);
        final double logr = Math.log(h);
        double t = Math.atan2(x_im, x_re);
        final double r = Math.exp(logr * y_re - y_im * t);
        t = y_im * logr + y_re * t;
        return Complex.polar(r, t);
    }
    
    public static Complex log(final double x_re, final double x_im) {
        final double h = Math.hypot(x_re, x_im);
        return Complex.make(Math.log(h), Math.atan2(x_im, x_re));
    }
    
    public static DComplex div(final double x_re, final double x_im, final double y_re, final double y_im) {
        final double ar = Math.abs(y_re);
        final double ai = Math.abs(y_im);
        double d;
        double nr;
        double ni;
        if (ar <= ai) {
            final double t = y_re / y_im;
            d = y_im * (1.0 + t * t);
            nr = x_re * t + x_im;
            ni = x_im * t - x_re;
        }
        else {
            final double t = y_im / y_re;
            d = y_re * (1.0 + t * t);
            nr = x_re + x_im * t;
            ni = x_im - x_re * t;
        }
        return new DComplex(nr / d, ni / d);
    }
    
    public static Complex sqrt(final double x_re, final double x_im) {
        final double r = Math.hypot(x_re, x_im);
        double nr;
        double ni;
        if (r == 0.0) {
            ni = (nr = r);
        }
        else if (x_re > 0.0) {
            nr = Math.sqrt(0.5 * (r + x_re));
            ni = x_im / nr / 2.0;
        }
        else {
            ni = Math.sqrt(0.5 * (r - x_re));
            if (x_im < 0.0) {
                ni = -ni;
            }
            nr = x_im / ni / 2.0;
        }
        return new DComplex(nr, ni);
    }
    
    public static Complex sin(final double x_re, final double x_im) {
        if (x_im == 0.0) {
            return new DFloNum(Math.sin(x_re));
        }
        return Complex.make(Math.sin(x_re) * Math.cosh(x_im), Math.cos(x_re) * Math.sinh(x_im));
    }
    
    public static Complex cos(final double x_re, final double x_im) {
        if (x_im == 0.0) {
            return new DFloNum(Math.cos(x_re));
        }
        return Complex.make(Math.cos(x_re) * Math.cosh(x_im), -Math.sin(x_re) * Math.sinh(x_im));
    }
    
    public static Complex tan(final double x_re, final double x_im) {
        if (x_im == 0.0) {
            return new DFloNum(Math.tan(x_re));
        }
        final double sin_re = Math.sin(x_re);
        final double cos_re = Math.cos(x_re);
        final double sinh_im = Math.sinh(x_im);
        final double cosh_im = Math.cosh(x_im);
        return div(sin_re * cosh_im, cos_re * sinh_im, cos_re * cosh_im, -sin_re * sinh_im);
    }
    
    public static Complex unitQuaternion(final double x_re, final double x_im) {
        final double r = Math.hypot(x_re, x_im);
        if (r == 0.0) {
            return IntNum.zero();
        }
        return Complex.make(x_re / r, x_im / r);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeDouble(this.real);
        out.writeDouble(this.imag);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.real = in.readDouble();
        this.imag = in.readDouble();
    }
}
