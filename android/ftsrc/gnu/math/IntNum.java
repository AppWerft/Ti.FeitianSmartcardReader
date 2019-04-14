package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
import java.math.BigInteger;








public class IntNum
  extends RatNum
  implements Externalizable
{
  public int ival;
  public int[] words;
  static final int minFixNum = -100;
  static final int maxFixNum = 1024;
  static final int numFixNum = 1125;
  static final IntNum[] smallFixNums = new IntNum['ѥ'];
  
  static {
    int i = 1125; for (;;) { i--; if (i < 0) break;
      smallFixNums[i] = new IntNum(i + -100);
    }
  }
  





  public IntNum(int value)
  {
    ival = value;
  }
  
  public static final IntNum zero()
  {
    return smallFixNums[100];
  }
  
  public static final IntNum one()
  {
    return smallFixNums[101];
  }
  
  public static final IntNum ten()
  {
    return smallFixNums[110];
  }
  

  public static IntNum minusOne()
  {
    return smallFixNums[99];
  }
  
  public static IntNum asIntNumOrNull(Object value)
  {
    if ((value instanceof IntNum))
      return (IntNum)value;
    if ((value instanceof UnsignedPrim))
      return ((UnsignedPrim)value).toIntNum();
    if ((value instanceof BigInteger))
      return valueOf(value.toString(), 10);
    if (((value instanceof Number)) && (((value instanceof Integer)) || ((value instanceof Long)) || ((value instanceof Short)) || ((value instanceof Byte))))
    {

      return make(((Number)value).longValue()); }
    return null;
  }
  



  public static IntNum alloc(int nwords)
  {
    if (nwords <= 1)
      return new IntNum();
    IntNum result = new IntNum();
    words = new int[nwords];
    return result;
  }
  


  public void realloc(int nwords)
  {
    if (nwords == 0)
    {
      if (words != null)
      {
        if (ival > 0)
          ival = words[0];
        words = null;
      }
    }
    else if ((words == null) || (words.length < nwords) || (words.length > nwords + 2))
    {


      int[] new_words = new int[nwords];
      if (words == null)
      {
        new_words[0] = ival;
        ival = 1;
      }
      else
      {
        if (nwords < ival)
          ival = nwords;
        System.arraycopy(words, 0, new_words, 0, ival);
      }
      words = new_words;
    }
  }
  
  public final IntNum numerator()
  {
    return this;
  }
  
  public final IntNum denominator()
  {
    return one();
  }
  
  public final boolean isNegative()
  {
    return (words == null ? ival : words[(ival - 1)]) < 0;
  }
  
  public int sign()
  {
    int n = ival;
    int[] w = words;
    if (w == null)
      return n < 0 ? -1 : n > 0 ? 1 : 0;
    int i = w[(--n)];
    if (i > 0)
      return 1;
    if (i < 0) {
      return -1;
    }
    do {
      if (n == 0)
        return 0;
    } while (w[(--n)] == 0);
    return 1;
  }
  


  public static int compare(IntNum x, IntNum y)
  {
    if ((words == null) && (words == null))
      return ival > ival ? 1 : ival < ival ? -1 : 0;
    boolean x_negative = x.isNegative();
    boolean y_negative = y.isNegative();
    if (x_negative != y_negative)
      return x_negative ? -1 : 1;
    int x_len = words == null ? 1 : ival;
    int y_len = words == null ? 1 : ival;
    if (x_len != y_len)
      return x_len > y_len != x_negative ? 1 : -1;
    return MPN.cmp(words, words, x_len);
  }
  

  public static int compare(IntNum x, long y)
  {
    long x_word;
    if (words == null) {
      x_word = ival;
    }
    else {
      boolean x_negative = x.isNegative();
      boolean y_negative = y < 0L;
      if (x_negative != y_negative)
        return x_negative ? -1 : 1;
      int x_len = words == null ? 1 : ival;
      long x_word; if (x_len == 1) {
        x_word = words[0]; } else { long x_word;
        if (x_len == 2) {
          x_word = x.longValue();
        } else
          return x_negative ? -1 : 1; } }
    long x_word;
    return x_word > y ? 1 : x_word < y ? -1 : 0;
  }
  
  public int compare(Object obj)
  {
    if ((obj instanceof IntNum))
      return compare(this, (IntNum)obj);
    return ((Numeric)obj).compareReversed(this);
  }
  
  public final boolean isOdd()
  {
    int low = words == null ? ival : words[0];
    return (low & 0x1) != 0;
  }
  
  public final boolean isZero()
  {
    return (words == null) && (ival == 0);
  }
  
  public final boolean isOne()
  {
    return (words == null) && (ival == 1);
  }
  
  public final boolean isMinusOne()
  {
    return (words == null) && (ival == -1);
  }
  





  public static int wordsNeeded(int[] words, int len)
  {
    int i = len;
    if (i > 0)
    {
      int word = words[(--i)];
      if (word == -1) {
        do {
          if ((i <= 0) || ((word = words[(i - 1)]) >= 0))
            break;
          i--;
        } while (word == -1);

      }
      else
      {
        while ((word == 0) && (i > 0) && ((word = words[(i - 1)]) >= 0)) i--;
      }
    }
    return i + 1;
  }
  
  public IntNum canonicalize()
  {
    if ((words != null) && ((this.ival = wordsNeeded(words, ival)) <= 1))
    {

      if (ival == 1)
        ival = words[0];
      words = null;
    }
    if ((words == null) && (ival >= -100) && (ival <= 1024))
      return smallFixNums[(ival - -100)];
    return this;
  }
  

  public static final IntNum add(int x, int y)
  {
    return make(x + y);
  }
  

  public static IntNum add(IntNum x, int y)
  {
    if (words == null)
      return add(ival, y);
    IntNum result = new IntNum(0);
    result.setAdd(x, y);
    return result.canonicalize();
  }
  


  public void setAdd(IntNum x, int y)
  {
    if (words == null)
    {
      set(ival + y);
      return;
    }
    int len = ival;
    realloc(len + 1);
    long carry = y;
    for (int i = 0; i < len; i++)
    {
      carry += (words[i] & 0xFFFFFFFF);
      words[i] = ((int)carry);
      carry >>= 32;
    }
    if (words[(len - 1)] < 0)
      carry -= 1L;
    words[len] = ((int)carry);
    ival = wordsNeeded(words, len + 1);
  }
  

  public final void setAdd(int y)
  {
    setAdd(this, y);
  }
  

  public final void set(int y)
  {
    words = null;
    ival = y;
  }
  

  public final void set(long y)
  {
    int i = (int)y;
    if (i == y)
    {
      ival = i;
      words = null;
    }
    else
    {
      realloc(2);
      words[0] = i;
      words[1] = ((int)(y >> 32));
      ival = 2;
    }
  }
  


  public final void set(int[] words, int length)
  {
    ival = length;
    this.words = words;
  }
  

  public final void set(IntNum y)
  {
    if (words == null) {
      set(ival);
    } else if (this != y)
    {
      realloc(ival);
      System.arraycopy(words, 0, words, 0, ival);
      ival = ival;
    }
  }
  

  public static IntNum add(IntNum x, IntNum y)
  {
    return add(x, y, 1);
  }
  

  public static IntNum sub(IntNum x, IntNum y)
  {
    return add(x, y, -1);
  }
  

  public static IntNum add(IntNum x, IntNum y, int k)
  {
    if (words == null) {
      int yval = ival;
      if (yval == 0)
        return x;
      if (words == null)
        return make(k * yval + ival);
    }
    if (k != 1)
    {
      if (k == -1) {
        y = neg(y);
      } else
        y = times(y, make(k));
    }
    if (words == null)
      return add(y, ival);
    if (words == null) {
      return add(x, ival);
    }
    
    if (ival > ival)
    {
      IntNum tmp = x;x = y;y = tmp;
    }
    IntNum result = alloc(ival + 1);
    int i = ival;
    long carry = MPN.add_n(words, words, words, i);
    long y_ext = words[(i - 1)] < 0 ? 4294967295L : 0L;
    for (; i < ival; i++)
    {
      carry += (words[i] & 0xFFFFFFFF) + y_ext;
      words[i] = ((int)carry);
      carry >>>= 32;
    }
    if (words[(i - 1)] < 0)
      y_ext -= 1L;
    words[i] = ((int)(carry + y_ext));
    ival = (i + 1);
    return result.canonicalize();
  }
  

  public static final IntNum times(int x, int y)
  {
    return make(x * y);
  }
  
  public static final IntNum times(IntNum x, int y)
  {
    if (y == 0)
      return zero();
    if (y == 1)
      return x;
    int[] xwords = words;
    int xlen = ival;
    if (xwords == null) {
      return make(xlen * y);
    }
    IntNum result = alloc(xlen + 1);
    boolean negative; if (xwords[(xlen - 1)] < 0)
    {
      boolean negative = true;
      negate(words, xwords, xlen);
      xwords = words;
    }
    else {
      negative = false; }
    if (y < 0)
    {
      negative = !negative;
      y = -y;
    }
    words[xlen] = MPN.mul_1(words, xwords, xlen, y);
    ival = (xlen + 1);
    if (negative)
      result.setNegative();
    return result.canonicalize();
  }
  
  public static final IntNum times(IntNum x, IntNum y)
  {
    if (words == null)
      return times(x, ival);
    if (words == null)
      return times(y, ival);
    boolean negative = false;
    

    int xlen = ival;
    int ylen = ival;
    int[] xwords; if (x.isNegative())
    {
      negative = true;
      int[] xwords = new int[xlen];
      negate(xwords, words, xlen);
    }
    else
    {
      negative = false;
      xwords = words; }
    int[] ywords;
    if (y.isNegative())
    {
      negative = !negative;
      int[] ywords = new int[ylen];
      negate(ywords, words, ylen);
    }
    else {
      ywords = words;
    }
    if (xlen < ylen)
    {
      int[] twords = xwords;xwords = ywords;ywords = twords;
      int tlen = xlen;xlen = ylen;ylen = tlen;
    }
    IntNum result = alloc(xlen + ylen);
    MPN.mul(words, xwords, xlen, ywords, ylen);
    ival = (xlen + ylen);
    if (negative)
      result.setNegative();
    return result.canonicalize();
  }
  



  public static void divide(long x, long y, IntNum quotient, IntNum remainder, int rounding_mode)
  {
    if (rounding_mode == 5)
      rounding_mode = y < 0L ? 2 : 1;
    boolean xNegative; if (x < 0L)
    {
      boolean xNegative = true;
      if (x == Long.MIN_VALUE)
      {
        divide(make(x), make(y), quotient, remainder, rounding_mode);
        
        return;
      }
      x = -x;
    }
    else {
      xNegative = false; }
    boolean yNegative;
    if (y < 0L)
    {
      boolean yNegative = true;
      if (y == Long.MIN_VALUE)
      {
        if (rounding_mode == 3)
        {
          if (quotient != null)
            quotient.set(0);
          if (remainder != null) {
            remainder.set(x);
          }
        } else {
          divide(make(x), make(y), quotient, remainder, rounding_mode);
        }
        return;
      }
      y = -y;
    }
    else {
      yNegative = false;
    }
    long q = x / y;
    long r = x % y;
    boolean qNegative = xNegative ^ yNegative;
    
    boolean add_one = false;
    if (r != 0L)
    {
      switch (rounding_mode)
      {
      case 3: 
        break;
      case 1: 
      case 2: 
        if (qNegative == (rounding_mode == 1))
          add_one = true;
        break;
      case 4: 
        add_one = r > y - (q & 1L) >> 1;
      }
      
    }
    if (quotient != null)
    {
      if (add_one)
        q += 1L;
      if (qNegative)
        q = -q;
      quotient.set(q);
    }
    if (remainder != null)
    {

      if (add_one)
      {

        r = y - r;
        

        xNegative = !xNegative;
      }
      




      if (xNegative)
        r = -r;
      remainder.set(r);
    }
  }
  










  public static void divide(IntNum x, IntNum y, IntNum quotient, IntNum remainder, int rounding_mode)
  {
    if (((words == null) || (ival <= 2)) && ((words == null) || (ival <= 2)))
    {

      long x_l = x.longValue();
      long y_l = y.longValue();
      if ((x_l != Long.MIN_VALUE) && (y_l != Long.MIN_VALUE))
      {
        divide(x_l, y_l, quotient, remainder, rounding_mode);
        return;
      }
    }
    
    boolean xNegative = x.isNegative();
    boolean yNegative = y.isNegative();
    boolean qNegative = xNegative ^ yNegative;
    
    int ylen = words == null ? 1 : ival;
    int[] ywords = new int[ylen];
    y.getAbsolute(ywords);
    while ((ylen > 1) && (ywords[(ylen - 1)] == 0)) { ylen--;
    }
    int xlen = words == null ? 1 : ival;
    int[] xwords = new int[xlen + 2];
    x.getAbsolute(xwords);
    while ((xlen > 1) && (xwords[(xlen - 1)] == 0)) { xlen--;
    }
    

    int cmpval = MPN.cmp(xwords, xlen, ywords, ylen);
    int rlen; int qlen; if (cmpval < 0)
    {
      int[] rwords = xwords;xwords = ywords;ywords = rwords;
      int rlen = xlen;int qlen = 1;xwords[0] = 0;
    } else { int rlen;
      if (cmpval == 0)
      {
        xwords[0] = 1;int qlen = 1;
        ywords[0] = 0;rlen = 1;
      }
      else if (ylen == 1)
      {
        int qlen = xlen;
        int rlen = 1;
        ywords[0] = MPN.divmod_1(xwords, xwords, xlen, ywords[0]);


      }
      else
      {


        int nshift = MPN.count_leading_zeros(ywords[(ylen - 1)]);
        if (nshift != 0)
        {


          MPN.lshift(ywords, 0, ywords, ylen, nshift);
          


          int x_high = MPN.lshift(xwords, 0, xwords, xlen, nshift);
          xwords[(xlen++)] = x_high;
        }
        
        if (xlen == ylen)
          xwords[(xlen++)] = 0;
        MPN.divide(xwords, xlen, ywords, ylen);
        rlen = ylen;
        MPN.rshift0(ywords, xwords, 0, rlen, nshift);
        
        qlen = xlen + 1 - ylen;
        if (quotient != null)
        {
          for (int i = 0; i < qlen; i++)
            xwords[i] = xwords[(i + ylen)];
        }
      }
    }
    while ((rlen > 1) && (ywords[(rlen - 1)] == 0))
      rlen--;
    if (ywords[(rlen - 1)] < 0)
    {
      ywords[rlen] = 0;
      rlen++;
    }
    


    boolean add_one = false;
    if ((rlen > 1) || (ywords[0] != 0))
    {
      if (rounding_mode == 5)
      {
        rounding_mode = yNegative ? 2 : 1;
      }
      switch (rounding_mode)
      {
      case 3: 
        break;
      case 1: 
      case 2: 
        if (qNegative == (rounding_mode == 1)) {
          add_one = true;
        }
        break;
      case 4: 
        IntNum tmp = remainder == null ? new IntNum() : remainder;
        tmp.set(ywords, rlen);
        tmp = shift(tmp, 1);
        if (yNegative)
          tmp.setNegative();
        int cmp = compare(tmp, y);
        
        if (yNegative)
          cmp = -cmp;
        add_one = (cmp == 1) || ((cmp == 0) && ((xwords[0] & 0x1) != 0));
      }
    }
    if (quotient != null)
    {
      if (xwords[(qlen - 1)] < 0)
      {
        xwords[qlen] = 0;
        qlen++;
      }
      quotient.set(xwords, qlen);
      if (qNegative)
      {
        if (add_one) {
          quotient.setInvert();
        } else {
          quotient.setNegative();
        }
      } else if (add_one)
        quotient.setAdd(1);
    }
    if (remainder != null)
    {

      remainder.set(ywords, rlen);
      if (add_one)
      {
        IntNum tmp;
        

        if (words == null)
        {
          IntNum tmp = remainder;
          tmp.set(yNegative ? ywords[0] + ival : ywords[0] - ival);
        }
        else {
          tmp = add(remainder, y, yNegative ? 1 : -1);
        }
        


        if (xNegative) {
          remainder.setNegative(tmp);
        } else {
          remainder.set(tmp);

        }
        

      }
      else if (xNegative) {
        remainder.setNegative();
      }
    }
  }
  
  public static IntNum quotient(IntNum x, IntNum y, int rounding_mode)
  {
    IntNum quotient = new IntNum();
    divide(x, y, quotient, null, rounding_mode);
    return quotient.canonicalize();
  }
  
  public static IntNum quotient(IntNum x, IntNum y)
  {
    return quotient(x, y, 3);
  }
  
  public IntNum toExactInt(int rounding_mode)
  {
    return this;
  }
  
  public RealNum toInt(int rounding_mode)
  {
    return this;
  }
  
  public static IntNum remainder(IntNum x, IntNum y, int rounding_mode)
  {
    if (y.isZero())
      return x;
    IntNum rem = new IntNum();
    divide(x, y, null, rem, rounding_mode);
    return rem.canonicalize();
  }
  
  public static IntNum remainder(IntNum x, IntNum y)
  {
    return remainder(x, y, 3);
  }
  
  public static IntNum modulo(IntNum x, IntNum y)
  {
    return remainder(x, y, 1);
  }
  
  public Numeric power(IntNum y)
  {
    if (isOne())
      return this;
    if (isMinusOne())
      return y.isOdd() ? this : one();
    if ((words == null) && (ival >= 0))
      return power(this, ival);
    if (isZero())
      return y.isNegative() ? RatNum.infinity(-1) : this;
    return super.power(y);
  }
  




  public static IntNum power(IntNum x, int y)
  {
    if (y <= 0)
    {
      if (y == 0) {
        return one();
      }
      throw new IllegalArgumentException("negative exponent");
    }
    if (x.isZero())
      return x;
    int plen = words == null ? 1 : ival;
    int blen = (x.intLength() * y >> 5) + 2 * plen;
    boolean negative = (x.isNegative()) && ((y & 0x1) != 0);
    int[] pow2 = new int[blen];
    int[] rwords = new int[blen];
    int[] work = new int[blen];
    x.getAbsolute(pow2);
    int rlen = 1;
    rwords[0] = 1;
    

    for (;;)
    {
      if ((y & 0x1) != 0)
      {
        MPN.mul(work, pow2, plen, rwords, rlen);
        int[] temp = work;work = rwords;rwords = temp;
        rlen += plen;
        while (rwords[(rlen - 1)] == 0) rlen--;
      }
      y >>= 1;
      if (y == 0) {
        break;
      }
      MPN.mul(work, pow2, plen, pow2, plen);
      int[] temp = work;work = pow2;pow2 = temp;
      plen *= 2;
      while (pow2[(plen - 1)] == 0) plen--;
    }
    if (rwords[(rlen - 1)] < 0)
      rlen++;
    if (negative)
      negate(rwords, rwords, rlen);
    return make(rwords, rlen);
  }
  


  public static final int gcd(int a, int b)
  {
    if (b > a)
    {
      int tmp = a;a = b;b = tmp;
    }
    for (;;)
    {
      if (b == 0)
        return a;
      if (b == 1) {
        return b;
      }
      
      int tmp = b;
      b = a % b;
      a = tmp;
    }
  }
  

  public static IntNum gcd(IntNum x, IntNum y)
  {
    int xval = ival;
    int yval = ival;
    if (words == null)
    {
      if (xval == 0)
        return abs(y);
      if ((words == null) && (xval != Integer.MIN_VALUE) && (yval != Integer.MIN_VALUE))
      {

        if (xval < 0)
          xval = -xval;
        if (yval < 0)
          yval = -yval;
        return make(gcd(xval, yval));
      }
      xval = 1;
    }
    if (words == null)
    {
      if (yval == 0)
        return abs(x);
      yval = 1;
    }
    int len = xval > yval ? xval : yval;
    int[] xwords = new int[len];
    int[] ywords = new int[len];
    x.getAbsolute(xwords);
    y.getAbsolute(ywords);
    len = MPN.gcd(xwords, ywords, len);
    IntNum result = new IntNum(0);
    

    if (xwords[(len - 1)] < 0)
      xwords[(len++)] = 0;
    ival = len;
    words = xwords;
    return result.canonicalize();
  }
  
  public static IntNum lcm(IntNum x, IntNum y)
  {
    if ((x.isZero()) || (y.isZero()))
      return zero();
    x = abs(x);
    y = abs(y);
    IntNum quotient = new IntNum();
    divide(times(x, y), gcd(x, y), quotient, null, 3);
    return quotient.canonicalize();
  }
  
  void setInvert()
  {
    if (words == null) {
      ival ^= 0xFFFFFFFF;
    }
    else {
      int i = ival; for (;;) { i--; if (i < 0) break;
        words[i] ^= 0xFFFFFFFF;
      }
    }
  }
  
  void setShiftLeft(IntNum x, int count) { int xlen;
    int[] xwords;
    int xlen;
    if (words == null)
    {
      if (count < 32)
      {
        set(ival << count);
        return;
      }
      int[] xwords = new int[1];
      xwords[0] = ival;
      xlen = 1;
    }
    else
    {
      xwords = words;
      xlen = ival;
    }
    int word_count = count >> 5;
    count &= 0x1F;
    int new_len = xlen + word_count;
    if (count == 0)
    {
      realloc(new_len);
      int i = xlen; for (;;) { i--; if (i < 0) break;
        words[(i + word_count)] = xwords[i];
      }
    }
    else {
      new_len++;
      realloc(new_len);
      int shift_out = MPN.lshift(words, word_count, xwords, xlen, count);
      count = 32 - count;
      words[(new_len - 1)] = (shift_out << count >> count);
    }
    ival = new_len;
    int i = word_count; for (;;) { i--; if (i < 0) break;
      words[i] = 0;
    }
  }
  
  void setShiftRight(IntNum x, int count) {
    if (words == null) {
      set(ival < 0 ? -1 : count < 32 ? ival >> count : 0);
    } else if (count == 0) {
      set(x);
    }
    else {
      boolean neg = x.isNegative();
      int word_count = count >> 5;
      count &= 0x1F;
      int d_len = ival - word_count;
      if (d_len <= 0) {
        set(neg ? -1 : 0);
      }
      else {
        if ((words == null) || (words.length < d_len))
          realloc(d_len);
        MPN.rshift0(words, words, word_count, d_len, count);
        ival = d_len;
        if (neg) {
          words[(d_len - 1)] |= -2 << 31 - count;
        }
      }
    }
  }
  
  void setShift(IntNum x, int count) {
    if (count > 0) {
      setShiftLeft(x, count);
    } else {
      setShiftRight(x, -count);
    }
  }
  
  public static IntNum shift(IntNum x, int count) {
    if (words == null)
    {
      if (count <= 0)
        return make(ival < 0 ? -1 : count > -32 ? ival >> -count : 0);
      if (count < 32)
        return make(ival << count);
    }
    if (count == 0)
      return x;
    IntNum result = new IntNum(0);
    result.setShift(x, count);
    return result.canonicalize();
  }
  

  public void format(int radix, StringBuffer buffer)
  {
    if (radix == 10)
    {
      if (words == null)
      {
        buffer.append(ival);
        return;
      }
      if (ival <= 2)
      {
        buffer.append(longValue());
        return;
      }
    }
    buffer.append(toString(radix));
  }
  







  public void format(int radix, StringBuilder buffer)
  {
    if (words == null)
    {
      if (radix == 10) {
        buffer.append(ival);
      } else {
        buffer.append(Integer.toString(ival, radix));
      }
    } else if (ival <= 2)
    {
      long lval = longValue();
      if (radix == 10) {
        buffer.append(lval);
      } else {
        buffer.append(Long.toString(lval, radix));
      }
    }
    else {
      boolean neg = isNegative();
      int[] work;
      if ((neg) || (radix != 16))
      {
        int[] work = new int[ival];
        getAbsolute(work);
      }
      else {
        work = words; }
      int len = ival;
      
      if (radix == 16)
      {
        if (neg)
          buffer.append('-');
        int buf_start = buffer.length();
        int i = len; for (;;) { i--; if (i < 0)
            break;
          int word = work[i];
          int j = 8; for (;;) { j--; if (j < 0)
              break;
            int hex_digit = word >> 4 * j & 0xF;
            
            if ((hex_digit > 0) || (buffer.length() > buf_start)) {
              buffer.append(Character.forDigit(hex_digit, 16));
            }
          }
        }
      }
      else {
        int chars_per_word = MPN.chars_per_word(radix);
        int wradix = radix;
        int j = chars_per_word; for (;;) { j--; if (j <= 0) break;
          wradix *= radix; }
        int i = buffer.length();
        for (;;)
        {
          int wdigit = MPN.divmod_1(work, work, len, wradix);
          while ((len > 0) && (work[(len - 1)] == 0)) len--;
          int j = chars_per_word; for (;;) { j--; if (j < 0)
              break;
            if ((len == 0) && (wdigit == 0)) break;
            int digit;
            if (wdigit < 0)
            {
              long ldigit = wdigit & 0xFFFFFFFFFFFFFFFF;
              int digit = (int)(ldigit % radix);
              wdigit /= radix;
            }
            else
            {
              digit = wdigit % radix;
              wdigit /= radix;
            }
            buffer.append(Character.forDigit(digit, radix));
          }
          if (len == 0)
            break;
        }
        if (neg) {
          buffer.append('-');
        }
        for (int j = buffer.length() - 1; 
            i < j; 
            



            j--)
        {
          char tmp = buffer.charAt(i);
          buffer.setCharAt(i, buffer.charAt(j));
          buffer.setCharAt(j, tmp);
          i++;
        }
      }
    }
  }
  
  public String toString(int radix)
  {
    if (words == null)
      return Integer.toString(ival, radix);
    if (ival <= 2)
      return Long.toString(longValue(), radix);
    int buf_size = ival * (MPN.chars_per_word(radix) + 1);
    
    StringBuilder buffer = new StringBuilder(buf_size);
    


    format(radix, buffer);
    return buffer.toString();
  }
  
  public int intValue()
  {
    if (words == null)
      return ival;
    return words[0];
  }
  

  public static int intValue(Object obj)
  {
    IntNum inum = (IntNum)obj;
    if (words != null)
    {
      throw new ClassCastException("integer too large"); }
    return ival;
  }
  
  public long longValue()
  {
    if (words == null)
      return ival;
    if (ival == 1)
      return words[0];
    return (words[1] << 32) + (words[0] & 0xFFFFFFFF);
  }
  
  public int hashCode()
  {
    return words == null ? ival : words[0] + words[(ival - 1)];
  }
  

  public static boolean equals(IntNum x, IntNum y)
  {
    if ((words == null) && (words == null))
      return ival == ival;
    if ((words == null) || (words == null) || (ival != ival))
      return false;
    int i = ival; do { i--; if (i < 0)
        break;
    } while (words[i] == words[i]);
    return false;
    
    return true;
  }
  

  public boolean equals(Object obj)
  {
    if ((obj == null) || (!(obj instanceof IntNum)))
      return false;
    return equals(this, (IntNum)obj);
  }
  
  public static IntNum make(int value) {
    return valueOf(value);
  }
  
  public static IntNum valueOfUnsigned(long value) {
    if (value >= 0L)
      return valueOf(value);
    IntNum result = alloc(3);
    ival = 3;
    words[0] = ((int)value);
    words[1] = ((int)(value >> 32));
    words[2] = 0;
    return result;
  }
  
  public static IntNum valueOfUnsigned(int value)
  {
    if (value >= 0)
      return valueOf(value);
    IntNum result = alloc(2);
    ival = 2;
    words[0] = value;
    words[1] = 0;
    return result;
  }
  


  public static IntNum make(int[] words, int len)
  {
    if (words == null)
      return make(len);
    len = wordsNeeded(words, len);
    if (len <= 1)
      return len == 0 ? zero() : make(words[0]);
    IntNum num = new IntNum();
    words = words;
    ival = len;
    return num;
  }
  
  public static IntNum make(int[] words) {
    return make(words, words.length);
  }
  
  public static IntNum make(long value) {
    return valueOf(value);
  }
  
  public static IntNum valueOf(int value)
  {
    if ((value >= -100) && (value <= 1024)) {
      return smallFixNums[(value - -100)];
    }
    return new IntNum(value);
  }
  
  public static IntNum valueOf(long value)
  {
    if ((value >= -100L) && (value <= 1024L))
      return smallFixNums[((int)value - -100)];
    int i = (int)value;
    if (i == value)
      return new IntNum(i);
    IntNum result = alloc(2);
    ival = 2;
    words[0] = i;
    words[1] = ((int)(value >> 32));
    return result;
  }
  

  public static IntNum valueOf(char[] buf, int offset, int length, int radix, boolean negative)
  {
    int byte_len = 0;
    byte[] bytes = new byte[length];
    for (int i = 0; i < length; i++)
    {
      char ch = buf[(offset + i)];
      if (ch == '-') {
        negative = true;
      } else if ((ch != '_') && ((byte_len != 0) || ((ch != ' ') && (ch != '\t'))))
      {


        int digit = Character.digit(ch, radix);
        if (digit < 0)
          break;
        bytes[(byte_len++)] = ((byte)digit);
      }
    }
    return valueOf(bytes, byte_len, negative, radix);
  }
  
  public static IntNum valueOf(String s, int radix)
    throws NumberFormatException
  {
    int len = s.length();
    

    if (len + radix <= 28)
    {

      if ((len > 1) && (s.charAt(0) == '+') && (Character.digit(s.charAt(1), radix) >= 0))
      {
        s = s.substring(1);
      }
      return make(Long.parseLong(s, radix));
    }
    
    int byte_len = 0;
    byte[] bytes = new byte[len];
    boolean negative = false;
    for (int i = 0; i < len; i++)
    {
      char ch = s.charAt(i);
      if ((ch == '-') && (i == 0)) {
        negative = true;
      } else if ((ch != '+') || (i != 0))
      {
        if ((ch != '_') && ((byte_len != 0) || ((ch != ' ') && (ch != '\t'))))
        {


          int digit = Character.digit(ch, radix);
          if (digit < 0)
            throw new NumberFormatException("For input string: \"" + s + '"');
          bytes[(byte_len++)] = ((byte)digit);
        } }
    }
    return valueOf(bytes, byte_len, negative, radix);
  }
  

  public static IntNum valueOf(byte[] digits, int byte_len, boolean negative, int radix)
  {
    int chars_per_word = MPN.chars_per_word(radix);
    int[] words = new int[byte_len / chars_per_word + 1];
    int size = MPN.set_str(words, digits, byte_len, radix);
    if (size == 0)
      return zero();
    if (words[(size - 1)] < 0)
      words[(size++)] = 0;
    if (negative)
      negate(words, words, size);
    return make(words, size);
  }
  
  public static IntNum valueOf(String s)
    throws NumberFormatException
  {
    return valueOf(s, 10);
  }
  
  public double doubleValue()
  {
    if (words == null)
      return ival;
    if (ival <= 2)
      return longValue();
    if (isNegative()) {
      return neg(this).roundToDouble(0, true, false);
    }
    return roundToDouble(0, false, false);
  }
  


  boolean checkBits(int n)
  {
    if (n <= 0)
      return false;
    if (words == null) {
      return (n > 31) || ((ival & (1 << n) - 1) != 0);
    }
    for (int i = 0; i < n >> 5; i++)
      if (words[i] != 0)
        return true;
    return ((n & 0x1F) != 0) && ((words[i] & (1 << (n & 0x1F)) - 1) != 0);
  }
  









  public double roundToDouble(int exp, boolean neg, boolean remainder)
  {
    int il = intLength();
    


    exp += il - 1;
    




    if (exp < 64461) {
      return neg ? -0.0D : 0.0D;
    }
    
    if (exp > 1023) {
      return neg ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
    }
    

    int ml = exp >= 64514 ? 53 : 53 + exp + 1022;
    


    int excess_bits = il - (ml + 1);
    long m; long m; if (excess_bits > 0) {
      m = words == null ? ival >> excess_bits : MPN.rshift_long(words, ival, excess_bits);
    }
    else {
      m = longValue() << -excess_bits;
    }
    

    if ((exp == 1023) && (m >> 1 == 9007199254740991L))
    {
      if ((remainder) || (checkBits(il - ml))) {
        return neg ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
      }
      return neg ? -1.7976931348623157E308D : Double.MAX_VALUE;
    }
    


    if (((m & 1L) == 1L) && (((m & 0x2) == 2L) || (remainder) || (checkBits(excess_bits))))
    {

      m += 2L;
      
      if ((m & 0x40000000000000) != 0L)
      {
        exp++;
        
        m >>= 1;


      }
      else if ((ml == 52) && ((m & 0x20000000000000) != 0L)) {
        exp++;
      }
    }
    
    m >>= 1;
    
    long bits_sign = neg ? Long.MIN_VALUE : 0L;
    exp += 1023;
    long bits_exp = exp <= 0 ? 0L : exp << 52;
    long bits_mant = m & 0xFFEFFFFFFFFFFFFF;
    return Double.longBitsToDouble(bits_sign | bits_exp | bits_mant);
  }
  

  public Numeric add(Object y, int k)
  {
    if ((y instanceof IntNum))
      return add(this, (IntNum)y, k);
    if (!(y instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)y).addReversed(this, k);
  }
  
  public Numeric mul(Object y)
  {
    if ((y instanceof IntNum))
      return times(this, (IntNum)y);
    if (!(y instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)y).mulReversed(this);
  }
  
  public Numeric div(Object y)
  {
    if ((y instanceof RatNum))
    {
      RatNum r = (RatNum)y;
      return RatNum.make(times(this, r.denominator()), r.numerator());
    }
    
    if (!(y instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)y).divReversed(this);
  }
  



  public void getAbsolute(int[] words)
  {
    int len;
    

    if (this.words == null)
    {
      int len = 1;
      words[0] = ival;
    }
    else
    {
      len = ival;
      int i = len; for (;;) { i--; if (i < 0) break;
        words[i] = this.words[i];
      } }
    if (words[(len - 1)] < 0)
      negate(words, words, len);
    int i = words.length; for (;;) { i--; if (i <= len) break;
      words[i] = 0;
    }
  }
  


  public static boolean negate(int[] dest, int[] src, int len)
  {
    long carry = 1L;
    boolean negative = src[(len - 1)] < 0;
    for (int i = 0; i < len; i++)
    {
      carry += ((src[i] ^ 0xFFFFFFFF) & 0xFFFFFFFF);
      dest[i] = ((int)carry);
      carry >>= 32;
    }
    return (negative) && (dest[(len - 1)] < 0);
  }
  


  public void setNegative(IntNum x)
  {
    int len = ival;
    if (words == null)
    {
      if (len == Integer.MIN_VALUE) {
        set(-len);
      } else
        set(-len);
      return;
    }
    realloc(len + 1);
    if (negate(words, words, len))
      words[(len++)] = 0;
    ival = len;
  }
  

  public final void setNegative()
  {
    setNegative(this);
  }
  
  public static IntNum abs(IntNum x)
  {
    return x.isNegative() ? neg(x) : x;
  }
  
  public static IntNum neg(IntNum x)
  {
    if ((words == null) && (ival != Integer.MIN_VALUE))
      return make(-ival);
    IntNum result = new IntNum(0);
    result.setNegative(x);
    return result.canonicalize();
  }
  
  public Numeric neg()
  {
    return neg(this);
  }
  



  public int intLength()
  {
    if (words == null) {
      return MPN.intLength(ival);
    }
    return MPN.intLength(words, ival);
  }
  








  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    int nwords = words == null ? 1 : wordsNeeded(words, ival);
    if (nwords <= 1)
    {
      int i = words.length == 0 ? 0 : words == null ? ival : words[0];
      if (i >= -1073741824) {
        out.writeInt(i);
      }
      else {
        out.writeInt(-2147483647);
        out.writeInt(i);
      }
    }
    else
    {
      out.writeInt(0x80000000 | nwords);
      for (;;) { nwords--; if (nwords < 0) break;
        out.writeInt(words[nwords]);
      }
    }
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    int i = in.readInt();
    if (i <= -1073741824)
    {
      i &= 0x7FFFFFFF;
      if (i == 1) {
        i = in.readInt();
      }
      else {
        int[] w = new int[i];
        int j = i; for (;;) { j--; if (j < 0) break;
          w[j] = in.readInt(); }
        words = w;
      }
    }
    ival = i;
  }
  
  public Object readResolve() throws ObjectStreamException
  {
    return canonicalize();
  }
  
  public BigInteger asBigInteger()
  {
    if ((words == null) || (ival <= 2))
      return BigInteger.valueOf(longValue());
    return new BigInteger(toString());
  }
  
  public BigDecimal asBigDecimal()
  {
    if (words == null)
      return new BigDecimal(ival);
    if (ival <= 2)
      return BigDecimal.valueOf(longValue());
    return new BigDecimal(toString());
  }
  

  public boolean inRange(long lo, long hi)
  {
    return (compare(this, lo) >= 0) && (compare(this, hi) <= 0);
  }
  

  public boolean inIntRange()
  {
    return inRange(-2147483648L, 2147483647L);
  }
  

  public boolean inLongRange()
  {
    return inRange(Long.MIN_VALUE, Long.MAX_VALUE);
  }
  
  public IntNum() {}
}
