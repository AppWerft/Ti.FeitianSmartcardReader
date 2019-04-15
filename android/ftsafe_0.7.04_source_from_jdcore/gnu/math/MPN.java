package gnu.math;








class MPN
{
  MPN() {}
  






  public static int add_1(int[] dest, int[] x, int size, int y)
  {
    long carry = y & 0xFFFFFFFF;
    for (int i = 0; i < size; i++)
    {
      carry += (x[i] & 0xFFFFFFFF);
      dest[i] = ((int)carry);
      carry >>= 32;
    }
    return (int)carry;
  }
  






  public static int add_n(int[] dest, int[] x, int[] y, int len)
  {
    long carry = 0L;
    for (int i = 0; i < len; i++)
    {
      carry += (x[i] & 0xFFFFFFFF) + (y[i] & 0xFFFFFFFF);
      
      dest[i] = ((int)carry);
      carry >>>= 32;
    }
    return (int)carry;
  }
  






  public static int sub_n(int[] dest, int[] X, int[] Y, int size)
  {
    int cy = 0;
    for (int i = 0; i < size; i++)
    {
      int y = Y[i];
      int x = X[i];
      y += cy;
      

      cy = (y ^ 0x80000000) < (cy ^ 0x80000000) ? 1 : 0;
      y = x - y;
      cy += ((y ^ 0x80000000) > (x ^ 0x80000000) ? 1 : 0);
      dest[i] = y;
    }
    return cy;
  }
  









  public static int mul_1(int[] dest, int[] x, int len, int y)
  {
    long yword = y & 0xFFFFFFFF;
    long carry = 0L;
    for (int j = 0; j < len; j++)
    {
      carry += (x[j] & 0xFFFFFFFF) * yword;
      dest[j] = ((int)carry);
      carry >>>= 32;
    }
    return (int)carry;
  }
  












  public static void mul(int[] dest, int[] x, int xlen, int[] y, int ylen)
  {
    dest[xlen] = mul_1(dest, x, xlen, y[0]);
    
    for (int i = 1; i < ylen; i++)
    {
      long yword = y[i] & 0xFFFFFFFF;
      long carry = 0L;
      for (int j = 0; j < xlen; j++)
      {
        carry += (x[j] & 0xFFFFFFFF) * yword + (dest[(i + j)] & 0xFFFFFFFF);
        
        dest[(i + j)] = ((int)carry);
        carry >>>= 32;
      }
      dest[(i + xlen)] = ((int)carry);
    }
  }
  






  public static long udiv_qrnnd(long N, int D)
  {
    long a1 = N >>> 32;
    long a0 = N & 0xFFFFFFFF;
    long q; long r; if (D >= 0) {
      long r;
      if (a1 < (D - a1 - (a0 >>> 31) & 0xFFFFFFFF))
      {

        long q = N / D;
        r = N % D;

      }
      else
      {
        long c = N - (D << 31);
        
        long q = c / D;
        long r = c % D;
        
        q += -2147483648L;
      }
    }
    else
    {
      long b1 = D >>> 1;
      

      long c = N >>> 1;
      if ((a1 < b1) || (a1 >> 1 < b1)) { long r;
        long q;
        if (a1 < b1)
        {
          long q = c / b1;
          r = c % b1;
        }
        else
        {
          c = c - (b1 << 32) ^ 0xFFFFFFFFFFFFFFFF;
          q = c / b1;
          r = c % b1;
          q = (q ^ 0xFFFFFFFFFFFFFFFF) & 0xFFFFFFFF;
          r = b1 - 1L - r;
        }
        long r = 2L * r + (a0 & 1L);
        if ((D & 0x1) != 0)
        {
          if (r >= q) {
            r -= q;
          } else if (q - r <= (D & 0xFFFFFFFF)) {
            r = r - q + D;
            q -= 1L;
          } else {
            r = r - q + D + D;
            q -= 2L;
          }
        }
      }
      else {
        long r;
        if (a0 >= (-D & 0xFFFFFFFF))
        {
          long q = -1L;
          r = a0 + D;
        }
        else
        {
          q = -2L;
          r = a0 + D + D;
        }
      }
    }
    
    return r << 32 | q & 0xFFFFFFFF;
  }
  







  public static int divmod_1(int[] quotient, int[] dividend, int len, int divisor)
  {
    int i = len - 1;
    long r = dividend[i];
    if ((r & 0xFFFFFFFF) >= (divisor & 0xFFFFFFFF)) {
      r = 0L;
    }
    else {
      quotient[(i--)] = 0;
      r <<= 32;
    }
    for (; 
        i >= 0; i--)
    {
      int n0 = dividend[i];
      r = r & 0xFFFFFFFF00000000 | n0 & 0xFFFFFFFF;
      r = udiv_qrnnd(r, divisor);
      quotient[i] = ((int)r);
    }
    return (int)(r >> 32);
  }
  





  public static int submul_1(int[] dest, int offset, int[] x, int len, int y)
  {
    long yl = y & 0xFFFFFFFF;
    int carry = 0;
    int j = 0;
    do
    {
      long prod = (x[j] & 0xFFFFFFFF) * yl;
      int prod_low = (int)prod;
      int prod_high = (int)(prod >> 32);
      prod_low += carry;
      

      carry = ((prod_low ^ 0x80000000) < (carry ^ 0x80000000) ? 1 : 0) + prod_high;
      
      int x_j = dest[(offset + j)];
      prod_low = x_j - prod_low;
      if ((prod_low ^ 0x80000000) > (x_j ^ 0x80000000))
        carry++;
      dest[(offset + j)] = prod_low;
      
      j++; } while (j < len);
    return carry;
  }
  




















  public static void divide(int[] zds, int nx, int[] y, int ny)
  {
    int j = nx;
    
    do
    {
      int qhat;
      int qhat;
      if (zds[j] == y[(ny - 1)]) {
        qhat = -1;
      }
      else {
        long w = (zds[j] << 32) + (zds[(j - 1)] & 0xFFFFFFFF);
        qhat = (int)udiv_qrnnd(w, y[(ny - 1)]);
      }
      if (qhat != 0)
      {
        int borrow = submul_1(zds, j - ny, y, ny, qhat);
        int save = zds[j];
        long num = (save & 0xFFFFFFFF) - (borrow & 0xFFFFFFFF);
        while (num != 0L)
        {
          qhat--;
          long carry = 0L;
          for (int i = 0; i < ny; i++)
          {
            carry += (zds[(j - ny + i)] & 0xFFFFFFFF) + (y[i] & 0xFFFFFFFF);
            
            zds[(j - ny + i)] = ((int)carry);
            carry >>>= 32;
          }
          int tmp177_175 = j;zds[tmp177_175] = ((int)(zds[tmp177_175] + carry));
          num = carry - 1L;
        }
      }
      zds[j] = qhat;
      j--; } while (j >= ny);
  }
  






  public static int chars_per_word(int radix)
  {
    if (radix < 10)
    {
      if (radix < 8)
      {
        if (radix <= 2)
          return 32;
        if (radix == 3)
          return 20;
        if (radix == 4) {
          return 16;
        }
        return 18 - radix;
      }
      
      return 10;
    }
    if (radix < 12)
      return 9;
    if (radix <= 16)
      return 8;
    if (radix <= 23)
      return 7;
    if (radix <= 40) {
      return 6;
    }
    if (radix <= 256) {
      return 4;
    }
    return 1;
  }
  

  public static int count_leading_zeros(int i)
  {
    if (i == 0)
      return 32;
    int count = 0;
    for (int k = 16; k > 0; k >>= 1) {
      int j = i >>> k;
      if (j == 0) {
        count += k;
      } else
        i = j;
    }
    return count;
  }
  
  public static int set_str(int[] dest, byte[] str, int str_len, int base)
  {
    int size = 0;
    if ((base & base - 1) == 0)
    {



      int next_bitpos = 0;
      int bits_per_indigit = 0;
      for (int i = base; i >>= 1 != 0; bits_per_indigit++) {}
      int res_digit = 0;
      
      int i = str_len; for (;;) { i--; if (i < 0)
          break;
        int inp_digit = str[i];
        res_digit |= inp_digit << next_bitpos;
        next_bitpos += bits_per_indigit;
        if (next_bitpos >= 32)
        {
          dest[(size++)] = res_digit;
          next_bitpos -= 32;
          res_digit = inp_digit >> bits_per_indigit - next_bitpos;
        }
      }
      
      if (res_digit != 0) {
        dest[(size++)] = res_digit;
      }
    }
    else
    {
      int indigits_per_limb = chars_per_word(base);
      int str_pos = 0;
      
      while (str_pos < str_len)
      {
        int chunk = str_len - str_pos;
        if (chunk > indigits_per_limb)
          chunk = indigits_per_limb;
        int res_digit = str[(str_pos++)];
        int big_base = base;
        for (;;) {
          chunk--; if (chunk <= 0)
            break;
          res_digit = res_digit * base + str[(str_pos++)];
          big_base *= base;
        }
        int cy_limb;
        int cy_limb;
        if (size == 0) {
          cy_limb = res_digit;
        }
        else {
          cy_limb = mul_1(dest, dest, size, big_base);
          cy_limb += add_1(dest, dest, size, res_digit);
        }
        if (cy_limb != 0)
          dest[(size++)] = cy_limb;
      }
    }
    return size;
  }
  

  public static int cmp(int[] x, int[] y, int size)
  {
    for (;;)
    {
      
      if (size < 0)
        break;
      int x_word = x[size];
      int y_word = y[size];
      if (x_word != y_word)
      {



        return (x_word ^ 0x80000000) > (y_word ^ 0x80000000) ? 1 : -1;
      }
    }
    return 0;
  }
  




  public static int cmp(int[] x, int xlen, int[] y, int ylen)
  {
    return xlen < ylen ? -1 : xlen > ylen ? 1 : cmp(x, y, xlen);
  }
  









  public static int rshift(int[] dest, int[] x, int x_start, int len, int count)
  {
    int count_2 = 32 - count;
    int low_word = x[x_start];
    int retval = low_word << count_2;
    for (int i = 1; 
        i < len; i++)
    {
      int high_word = x[(x_start + i)];
      dest[(i - 1)] = (low_word >>> count | high_word << count_2);
      low_word = high_word;
    }
    dest[(i - 1)] = (low_word >>> count);
    return retval;
  }
  








  public static void rshift0(int[] dest, int[] x, int x_start, int len, int count)
  {
    if (count > 0) {
      rshift(dest, x, x_start, len, count);
    } else {
      for (int i = 0; i < len; i++) {
        dest[i] = x[(i + x_start)];
      }
    }
  }
  




  public static long rshift_long(int[] x, int len, int count)
  {
    int wordno = count >> 5;
    count &= 0x1F;
    int sign = x[(len - 1)] < 0 ? -1 : 0;
    int w0 = wordno >= len ? sign : x[wordno];
    wordno++;
    int w1 = wordno >= len ? sign : x[wordno];
    if (count != 0)
    {
      wordno++;
      int w2 = wordno >= len ? sign : x[wordno];
      w0 = w0 >>> count | w1 << 32 - count;
      w1 = w1 >>> count | w2 << 32 - count;
    }
    return w1 << 32 | w0 & 0xFFFFFFFF;
  }
  








  public static int lshift(int[] dest, int d_offset, int[] x, int len, int count)
  {
    int count_2 = 32 - count;
    int i = len - 1;
    int high_word = x[i];
    int retval = high_word >>> count_2;
    d_offset++;
    for (;;) { i--; if (i < 0)
        break;
      int low_word = x[i];
      dest[(d_offset + i)] = (high_word << count | low_word >>> count_2);
      high_word = low_word;
    }
    dest[(d_offset + i)] = (high_word << count);
    return retval;
  }
  


  static int findLowestBit(int word)
  {
    int i = 0;
    while ((word & 0xF) == 0)
    {
      word >>= 4;
      i += 4;
    }
    if ((word & 0x3) == 0)
    {
      word >>= 2;
      i += 2;
    }
    if ((word & 0x1) == 0)
      i++;
    return i;
  }
  


  static int findLowestBit(int[] words)
  {
    for (int i = 0;; i++)
    {
      if (words[i] != 0) {
        return 32 * i + findLowestBit(words[i]);
      }
    }
  }
  



  public static int gcd(int[] x, int[] y, int len)
  {
    int word;
    

    for (int i = 0;; i++)
    {
      word = x[i] | y[i];
      if (word != 0) {
        break;
      }
    }
    

    int initShiftWords = i;
    int initShiftBits = findLowestBit(word);
    


    len -= initShiftWords;
    rshift0(x, x, initShiftWords, len, initShiftBits);
    rshift0(y, y, initShiftWords, len, initShiftBits);
    int[] other_arg;
    int[] odd_arg;
    int[] other_arg;
    if ((x[0] & 0x1) != 0)
    {
      int[] odd_arg = x;
      other_arg = y;
    }
    else
    {
      odd_arg = y;
      other_arg = x;
    }
    



    for (;;)
    {
      for (i = 0; other_arg[i] == 0; i++) {}
      if (i > 0)
      {

        for (int j = 0; j < len - i; j++)
          other_arg[j] = other_arg[(j + i)];
        for (; j < len; j++)
          other_arg[j] = 0;
      }
      i = findLowestBit(other_arg[0]);
      if (i > 0) {
        rshift(other_arg, other_arg, 0, len, i);
      }
      



      i = cmp(odd_arg, other_arg, len);
      if (i == 0)
        break;
      if (i > 0)
      {
        sub_n(odd_arg, odd_arg, other_arg, len);
        
        int[] tmp = odd_arg;odd_arg = other_arg;other_arg = tmp;
      }
      else
      {
        sub_n(other_arg, other_arg, odd_arg, len);
      }
      while ((odd_arg[(len - 1)] == 0) && (other_arg[(len - 1)] == 0))
        len--;
    }
    if (initShiftWords + initShiftBits > 0)
    {
      if (initShiftBits > 0)
      {
        int sh_out = lshift(x, initShiftWords, x, len, initShiftBits);
        if (sh_out != 0) {
          x[(len++ + initShiftWords)] = sh_out;
        }
      }
      else {
        i = len; for (;;) { i--; if (i < 0) break;
          x[(i + initShiftWords)] = x[i];
        } }
      i = initShiftWords; for (;;) { i--; if (i < 0) break;
        x[i] = 0; }
      len += initShiftWords;
    }
    return len;
  }
  
  public static int intLength(int i)
  {
    return 32 - count_leading_zeros(i < 0 ? i ^ 0xFFFFFFFF : i);
  }
  


  public static int intLength(int[] words, int len)
  {
    len--;
    return intLength(words[len]) + 32 * len;
  }
}
