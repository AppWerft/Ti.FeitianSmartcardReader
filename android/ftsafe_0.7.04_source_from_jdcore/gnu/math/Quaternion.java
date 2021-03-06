package gnu.math;

public abstract class Quaternion extends Quantity
{
  private static CQuaternion jmOne;
  private static CQuaternion jmMinusOne;
  private static CQuaternion kmOne;
  private static CQuaternion kmMinusOne;
  
  public Quaternion() {}
  
  public Quaternion number() {
    return this;
  }
  
  public boolean isExact() {
    return (re().isExact()) && (im().isExact()) && (jm().isExact()) && (km().isExact());
  }
  




  public int classifyFinite()
  {
    int r = re().classifyFinite();
    if (r < 0)
      return r;
    int i = im().classifyFinite();
    if (i < 0)
      return i;
    int j = jm().classifyFinite();
    if (j < 0)
      return j;
    int k = km().classifyFinite();
    if (k < 0) {
      return k;
    }
    return r * i * j * k;
  }
  
  public Quaternion toExact() {
    RealNum re = re();
    RealNum im = im();
    RealNum jm = jm();
    RealNum km = km();
    RatNum xre = re.toExact();
    RatNum xim = im.toExact();
    RatNum xjm = jm.toExact();
    RatNum xkm = km.toExact();
    if ((xre == re) && (xim == im) && (xjm == jm) && (xkm == km)) {
      return this;
    }
    return new CQuaternion(xre, xim, xjm, xkm);
  }
  
  public Quaternion toInexact() {
    if (isExact())
      return this;
    return new DQuaternion(re().doubleValue(), im().doubleValue(), jm().doubleValue(), km().doubleValue());
  }
  





  public static CQuaternion jmOne()
  {
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
  
  public double doubleValue() { return re().doubleValue(); }
  public double doubleImagValue() { return im().doubleValue(); }
  public double doubleJmagValue() { return jm().doubleValue(); }
  public double doubleKmagValue() { return km().doubleValue(); }
  public final double doubleRealValue() { return doubleValue(); }
  public long longValue() { return re().longValue(); }
  
  public Complex complexPart() {
    return Complex.make(re(), im());
  }
  
  public Quaternion vectorPart() {
    return make(IntNum.zero(), im(), jm(), km());
  }
  
  public Quaternion unitVector() {
    int imSign = im().sign();
    int jmSign = jm().sign();
    int kmSign = km().sign();
    
    if ((imSign == -2) || (jmSign == -2) || (kmSign == -2)) {
      return make(0.0D, NaN.0D, NaN.0D, NaN.0D);
    }
    if ((imSign == 0) && (jmSign == 0) && (kmSign == 0)) {
      return IntNum.zero();
    }
    if ((imSign == 0) && (jmSign == 0)) {
      return kmSign == 1 ? kmOne() : kmMinusOne();
    }
    if ((imSign == 0) && (kmSign == 0)) {
      return jmSign == 1 ? jmOne() : jmMinusOne();
    }
    if ((jmSign == 0) && (kmSign == 0)) {
      return imSign == 1 ? Complex.imOne() : Complex.imMinusOne();
    }
    double im = doubleImagValue();
    double jm = doubleJmagValue();
    double km = doubleKmagValue();
    double vmag = DQuaternion.hypot3(im, jm, km);
    
    return make(0.0D, im / vmag, jm / vmag, km / vmag);
  }
  
  public Quaternion unitQuaternion() {
    int reSign = re().sign();
    int imSign = im().sign();
    int jmSign = jm().sign();
    int kmSign = km().sign();
    
    if ((reSign == -2) || (imSign == -2) || (jmSign == -2) || (kmSign == -2)) {
      return make(NaN.0D, NaN.0D, NaN.0D, NaN.0D);
    }
    
    if ((imSign == 0) && (jmSign == 0) && (kmSign == 0)) {
      return make((RealNum)re().unitQuaternion(), IntNum.zero(), IntNum.zero(), IntNum.zero());
    }
    



    if ((reSign == 0) && (jmSign == 0) && (kmSign == 0)) {
      return make(IntNum.zero(), (RealNum)im().unitQuaternion(), IntNum.zero(), IntNum.zero());
    }
    



    if ((reSign == 0) && (imSign == 0) && (kmSign == 0)) {
      return make(IntNum.zero(), IntNum.zero(), (RealNum)jm().unitQuaternion(), IntNum.zero());
    }
    



    if ((reSign == 0) && (imSign == 0) && (jmSign == 0)) {
      return make(IntNum.zero(), IntNum.zero(), IntNum.zero(), (RealNum)km().unitQuaternion());
    }
    



    double re = doubleRealValue();
    double im = doubleImagValue();
    double jm = doubleJmagValue();
    double km = doubleKmagValue();
    double mag = DQuaternion.hypot4(re, im, jm, km);
    return make(re / mag, im / mag, jm / mag, km / mag);
  }
  
  public static Quaternion make(RealNum re, RealNum im, RealNum jm, RealNum km)
  {
    if ((km.isZero()) && (km.isExact()) && (jm.isZero()) && (jm.isExact()))
      return Complex.make(re, im);
    if ((!re.isExact()) && (!im.isExact()) && (!jm.isExact()) && (!km.isExact())) {
      return new DQuaternion(re.doubleValue(), im.doubleValue(), jm.doubleValue(), km.doubleValue());
    }
    return new CQuaternion(re, im, jm, km);
  }
  
  public static Quaternion make(double re, double im, double jm, double km)
  {
    if ((jm == 0.0D) && (km == 0.0D))
      return Complex.make(re, im);
    return new DQuaternion(re, im, jm, km);
  }
  
  public static Quaternion polar(double r, double t, double u, double v)
  {
    double z = r * Math.sin(t) * Math.sin(u) * Math.sin(v);
    double y = r * Math.sin(t) * Math.sin(u) * Math.cos(v);
    
    double x = r * Math.sin(t) * Math.cos(u);
    
    double w = r * Math.cos(t);
    
    return make(w, x, y, z);
  }
  
  public static Quaternion polar(RealNum r, RealNum t, RealNum u, RealNum v) {
    return polar(r.doubleValue(), t.doubleValue(), u.doubleValue(), v.doubleValue());
  }
  
  public static Quaternion power(Quaternion x, Quaternion y)
  {
    if ((y instanceof IntNum))
      return (Quaternion)x.power((IntNum)y);
    double y_re = y.doubleRealValue();
    double y_im = y.doubleImagValue();
    double y_jm = y.doubleJmagValue();
    double y_km = y.doubleKmagValue();
    if ((x.isZero()) && (x.isExact()) && (y.isExact())) {
      if (y_re > 0.0D)
        return IntNum.zero();
      if ((y_re == 0.0D) && (y_im == 0.0D) && (y_jm == 0.0D) && (y_km == 0.0D))
        return IntNum.one();
    }
    double x_re = x.doubleRealValue();
    double x_im = x.doubleImagValue();
    double x_jm = x.doubleJmagValue();
    double x_km = x.doubleKmagValue();
    if ((x_im == 0.0D) && (y_im == 0.0D) && (x_jm == 0.0D) && (y_jm == 0.0D) && (x_km == 0.0D) && (y_km == 0.0D) && ((x_re >= 0.0D) || (Double.isInfinite(x_re)) || (Double.isNaN(x_re))))
    {

      return new DFloNum(Math.pow(x_re, y_re)); }
    return DQuaternion.power(x_re, x_im, x_jm, x_km, y_re, y_im, y_jm, y_km);
  }
  
  public Numeric abs()
  {
    return new DFloNum(DQuaternion.hypot4(doubleRealValue(), doubleImagValue(), doubleJmagValue(), doubleKmagValue()));
  }
  


  public RealNum angle()
  {
    return new DFloNum(Math.atan2(Math.hypot(Math.hypot(doubleImagValue(), doubleJmagValue()), doubleKmagValue()), doubleRealValue()));
  }
  


  public RealNum colatitude()
  {
    return new DFloNum(Math.atan2(Math.hypot(doubleJmagValue(), doubleKmagValue()), doubleImagValue()));
  }
  

  public RealNum longitude()
  {
    return new DFloNum(Math.atan2(doubleKmagValue(), doubleJmagValue()));
  }
  
  public Quaternion conjugate() {
    return make(re(), im().rneg(), jm().rneg(), km().rneg());
  }
  
  public static boolean equals(Quaternion x, Quaternion y) {
    return (x.re().equals(y.re())) && (x.im().equals(y.im())) && (x.jm().equals(y.jm())) && (x.km().equals(y.km()));
  }
  


  public boolean equals(Object obj)
  {
    if ((obj == null) || (!(obj instanceof Quaternion)))
      return false;
    return equals(this, (Quaternion)obj);
  }
  
  public static int compare(Quaternion x, Quaternion y) {
    int code = x.km().compare(y.km());
    if (code != 0)
      return code;
    code = x.jm().compare(y.jm());
    if (code != 0)
      return code;
    code = x.im().compare(y.im());
    if (code != 0)
      return code;
    return x.re().compare(y.re());
  }
  
  public int compare(Object obj) {
    if (!(obj instanceof Quaternion))
      return ((Numeric)obj).compareReversed(this);
    return compare(this, (Quaternion)obj);
  }
  
  public boolean isZero() {
    return (re().isZero()) && (im().isZero()) && (jm().isZero()) && (km().isZero());
  }
  
  public String toString(int radix) {
    if ((im().isZero()) && (jm().isZero()) && (km().isZero()))
      return re().toString(radix);
    String imString = "";String jmString = "";String kmString = "";
    if (!im().isZero()) {
      imString = im().toString(radix) + "i";
      char ch0 = imString.charAt(0);
      if ((ch0 != '-') && (ch0 != '+'))
        imString = "+" + imString;
    }
    if (!jm().isZero()) {
      jmString = jm().toString(radix) + "j";
      char ch0 = jmString.charAt(0);
      if ((ch0 != '-') && (ch0 != '+'))
        jmString = "+" + jmString;
    }
    if (!km().isZero()) {
      kmString = km().toString(radix) + "k";
      char ch0 = kmString.charAt(0);
      if ((ch0 != '-') && (ch0 != '+'))
        kmString = "+" + kmString;
    }
    if (re().isZero())
      return imString + jmString + kmString;
    return re().toString(radix) + imString + jmString + kmString;
  }
  
  public static Quaternion neg(Quaternion x) {
    return make(x.re().rneg(), x.im().rneg(), x.jm().rneg(), x.km().rneg());
  }
  
  public Numeric neg() {
    return neg(this);
  }
  
  public static Quaternion add(Quaternion x, Quaternion y, int k) { return make(RealNum.add(x.re(), y.re(), k), RealNum.add(x.im(), y.im(), k), RealNum.add(x.jm(), y.jm(), k), RealNum.add(x.km(), y.km(), k)); }
  



  public Numeric add(Object y, int k)
  {
    if ((y instanceof Quaternion))
      return add(this, (Quaternion)y, k);
    return ((Numeric)y).addReversed(this, k);
  }
  
  public Numeric addReversed(Numeric x, int k) {
    if ((x instanceof Quaternion))
      return add((Quaternion)x, this, k);
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
    


    return make(r, i, j, k);
  }
  
  public Numeric mul(Object y) {
    if ((y instanceof Quaternion))
      return times(this, (Quaternion)y);
    return ((Numeric)y).mulReversed(this);
  }
  
  public Numeric mulReversed(Numeric x) {
    if ((x instanceof Quaternion))
      return times((Quaternion)x, this);
    throw new IllegalArgumentException();
  }
  
  public static Quaternion divide(Quaternion x, Quaternion y) {
    if ((!x.isExact()) || (!y.isExact())) {
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
    



    return make(RealNum.divide(r, y_norm), RealNum.divide(i, y_norm), RealNum.divide(j, y_norm), RealNum.divide(k, y_norm));
  }
  


  public Numeric div(Object y)
  {
    if ((y instanceof Quaternion))
      return divide(this, (Quaternion)y);
    return ((Numeric)y).divReversed(this);
  }
  
  public Numeric divReversed(Numeric x) {
    if ((x instanceof Quaternion))
      return divide((Quaternion)x, this);
    throw new IllegalArgumentException();
  }
  
  public Quaternion exp() {
    return DQuaternion.exp(doubleRealValue(), doubleImagValue(), doubleJmagValue(), doubleKmagValue());
  }
  
  public Quaternion log()
  {
    return DQuaternion.log(doubleRealValue(), doubleImagValue(), doubleJmagValue(), doubleKmagValue());
  }
  
  public Quaternion sqrt()
  {
    return DQuaternion.sqrt(doubleRealValue(), doubleImagValue(), doubleJmagValue(), doubleKmagValue());
  }
  
  public Quaternion sin()
  {
    return DQuaternion.sin(doubleRealValue(), doubleImagValue(), doubleJmagValue(), doubleKmagValue());
  }
  
  public Quaternion cos()
  {
    return DQuaternion.cos(doubleRealValue(), doubleImagValue(), doubleJmagValue(), doubleKmagValue());
  }
  
  public Quaternion tan()
  {
    return DQuaternion.tan(doubleRealValue(), doubleImagValue(), doubleJmagValue(), doubleKmagValue());
  }
}
