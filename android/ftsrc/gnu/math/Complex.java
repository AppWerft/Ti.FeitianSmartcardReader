package gnu.math;

public abstract class Complex extends Quaternion { private static CComplex imOne;
  private static CComplex imMinusOne;
  
  public Complex() {}
  
  public final RealNum jm() { return IntNum.zero(); }
  public final RealNum km() { return IntNum.zero(); }
  
  public final Complex complexPart() { return this; }
  
  public Quaternion vectorPart() {
    return make(IntNum.zero(), im());
  }
  
  public Quaternion unitVector() {
    int imSign = im().sign();
    
    switch (imSign) {
    case 1: 
      return imOne();
    case 0: 
      return IntNum.zero();
    case -1: 
      return imMinusOne();
    }
    return make(0.0D, NaN.0D);
  }
  
  public Quaternion unitQuaternion()
  {
    if (im().isZero())
      return re().unitQuaternion();
    if (re().isZero())
      return make(IntNum.zero(), (RealNum)im().unitQuaternion());
    return DComplex.unitQuaternion(doubleRealValue(), doubleImagValue());
  }
  
  public Quaternion conjugate() {
    return make(re(), im().rneg());
  }
  

  public boolean isExact()
  {
    return (re().isExact()) && (im().isExact());
  }
  


  public int classifyFinite()
  {
    int r = re().classifyFinite();
    if (r < 0)
      return r;
    int i = im().classifyFinite();
    return r < i ? r : i;
  }
  
  public Complex toExact()
  {
    RealNum re = re();
    RealNum im = im();
    RatNum xre = re.toExact();
    RatNum xim = im.toExact();
    if ((xre == re) && (xim == im)) {
      return this;
    }
    return new CComplex(xre, xim);
  }
  
  public Complex toInexact()
  {
    if (isExact())
      return this;
    return new DComplex(re().doubleValue(), im().doubleValue());
  }
  



  public static CComplex imOne()
  {
    if (imOne == null)
      imOne = new CComplex(IntNum.zero(), IntNum.one());
    return imOne;
  }
  
  public static CComplex imMinusOne()
  {
    if (imMinusOne == null)
      imMinusOne = new CComplex(IntNum.zero(), IntNum.minusOne());
    return imMinusOne;
  }
  
  public static Complex make(RealNum re, RealNum im)
  {
    if ((im.isZero()) && (im.isExact()))
      return re;
    if ((!re.isExact()) && (!im.isExact()))
      return new DComplex(re.doubleValue(), im.doubleValue());
    return new CComplex(re, im);
  }
  
  public static Complex make(double re, double im)
  {
    if (im == 0.0D)
      return new DFloNum(re);
    return new DComplex(re, im);
  }
  
  public static Complex polar(double r, double t)
  {
    if (t == 0.0D)
      return new DFloNum(r);
    return new DComplex(r * Math.cos(t), r * Math.sin(t));
  }
  
  public static Complex polar(RealNum r, RealNum t)
  {
    if ((t.isZero()) && (t.isExact()))
      return r;
    return polar(r.doubleValue(), t.doubleValue());
  }
  
  public static Complex power(Complex x, Complex y)
  {
    if ((y instanceof IntNum))
      return (Complex)x.power((IntNum)y);
    double y_re = y.doubleRealValue();
    double y_im = y.doubleImagValue();
    if ((x.isZero()) && (x.isExact()) && (y.isExact())) {
      if (y_re > 0.0D)
        return IntNum.zero();
      if ((y_re == 0.0D) && (y_im == 0.0D))
        return IntNum.one();
    }
    double x_re = x.doubleRealValue();
    double x_im = x.doubleImagValue();
    if ((x_im == 0.0D) && (y_im == 0.0D) && ((x_re >= 0.0D) || (Double.isInfinite(x_re)) || (Double.isNaN(x_re))))
    {
      return new DFloNum(Math.pow(x_re, y_re)); }
    return DComplex.power(x_re, x_im, y_re, y_im);
  }
  

  public Numeric abs()
  {
    return new DFloNum(Math.hypot(doubleRealValue(), doubleImagValue()));
  }
  



  public RealNum angle()
  {
    return new DFloNum(Math.atan2(doubleImagValue(), doubleRealValue()));
  }
  
  public final RealNum colatitude() { return IntNum.zero(); }
  public final RealNum longitude() { return IntNum.zero(); }
  
  public static boolean equals(Complex x, Complex y)
  {
    return (x.re().equals(y.re())) && (x.im().equals(y.im()));
  }
  

  public boolean equals(Object obj)
  {
    if ((obj == null) || (!(obj instanceof Complex)))
      return false;
    return equals(this, (Complex)obj);
  }
  
  public static int compare(Complex x, Complex y)
  {
    int code = x.im().compare(y.im());
    if (code != 0)
      return code;
    return x.re().compare(y.re());
  }
  
  public int compare(Object obj)
  {
    if (!(obj instanceof Complex))
      return ((Numeric)obj).compareReversed(this);
    return compare(this, (Complex)obj);
  }
  
  public boolean isZero()
  {
    return (re().isZero()) && (im().isZero());
  }
  












  public String toString(int radix)
  {
    if (im().isZero())
      return re().toString(radix);
    String imString = im().toString(radix) + "i";
    char ch0 = imString.charAt(0);
    if ((ch0 != '-') && (ch0 != '+'))
      imString = "+" + imString;
    if (re().isZero())
      return imString;
    return re().toString(radix) + imString;
  }
  
  public static Complex neg(Complex x)
  {
    return make(x.re().rneg(), x.im().rneg());
  }
  
  public Numeric neg() { return neg(this); }
  
  public static Complex add(Complex x, Complex y, int k)
  {
    return make(RealNum.add(x.re(), y.re(), k), RealNum.add(x.im(), y.im(), k));
  }
  

  public Numeric add(Object y, int k)
  {
    if ((y instanceof Complex))
      return add(this, (Complex)y, k);
    return ((Numeric)y).addReversed(this, k);
  }
  
  public Numeric addReversed(Numeric x, int k)
  {
    if ((x instanceof Complex))
      return add((Complex)x, this, k);
    throw new IllegalArgumentException();
  }
  
  public static Complex times(Complex x, Complex y)
  {
    RealNum x_re = x.re();
    RealNum x_im = x.im();
    RealNum y_re = y.re();
    RealNum y_im = y.im();
    return make(RealNum.add(RealNum.times(x_re, y_re), RealNum.times(x_im, y_im), -1), RealNum.add(RealNum.times(x_re, y_im), RealNum.times(x_im, y_re), 1));
  }
  



  public Numeric mul(Object y)
  {
    if ((y instanceof Complex))
      return times(this, (Complex)y);
    return ((Numeric)y).mulReversed(this);
  }
  
  public Numeric mulReversed(Numeric x)
  {
    if ((x instanceof Complex))
      return times((Complex)x, this);
    throw new IllegalArgumentException();
  }
  
  public static Complex divide(Complex x, Complex y)
  {
    if ((!x.isExact()) || (!y.isExact())) {
      return DComplex.div(x.doubleRealValue(), x.doubleImagValue(), y.doubleRealValue(), y.doubleImagValue());
    }
    
    RealNum x_re = x.re();
    RealNum x_im = x.im();
    RealNum y_re = y.re();
    RealNum y_im = y.im();
    
    RealNum q = RealNum.add(RealNum.times(y_re, y_re), RealNum.times(y_im, y_im), 1);
    
    RealNum n = RealNum.add(RealNum.times(x_re, y_re), RealNum.times(x_im, y_im), 1);
    
    RealNum d = RealNum.add(RealNum.times(x_im, y_re), RealNum.times(x_re, y_im), -1);
    
    return make(RealNum.divide(n, q), RealNum.divide(d, q));
  }
  
  public Numeric div(Object y)
  {
    if ((y instanceof Complex))
      return divide(this, (Complex)y);
    return ((Numeric)y).divReversed(this);
  }
  
  public Numeric divReversed(Numeric x)
  {
    if ((x instanceof Complex))
      return divide((Complex)x, this);
    throw new IllegalArgumentException();
  }
  
  public Complex exp()
  {
    return polar(Math.exp(doubleRealValue()), doubleImagValue());
  }
  

  public Complex log()
  {
    return DComplex.log(doubleRealValue(), doubleImagValue());
  }
  
  public Complex sqrt()
  {
    return DComplex.sqrt(doubleRealValue(), doubleImagValue());
  }
  
  public Complex sin() {
    return DComplex.sin(doubleRealValue(), doubleImagValue());
  }
  
  public Complex cos() {
    return DComplex.cos(doubleRealValue(), doubleImagValue());
  }
  
  public Complex tan() {
    return DComplex.tan(doubleRealValue(), doubleImagValue());
  }
}
