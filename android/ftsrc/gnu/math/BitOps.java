package gnu.math;






public class BitOps
{
  private BitOps() {}
  





  public static boolean bitValue(IntNum x, int bitno)
  {
    int i = ival;
    if (words == null)
    {
      return i < 0;
    }
    

    int wordno = bitno >> 5;
    return words[(i - 1)] < 0;
  }
  





  static int[] dataBufferFor(IntNum x, int bitno)
  {
    int i = ival;
    
    int nwords = bitno + 1 >> 5;
    int[] data; if (words == null)
    {
      if (nwords == 0)
        nwords = 1;
      int[] data = new int[nwords];
      data[0] = i;
      if (i < 0)
      {
        for (int j = 1; j < nwords; j++) {
          data[j] = -1;
        }
      }
    }
    else {
      nwords = bitno + 1 >> 5;
      data = new int[nwords > i ? nwords : i];
      int j = i; for (;;) { j--; if (j < 0) break;
        data[j] = words[j]; }
      if (data[(i - 1)] < 0)
      {
        for (int j = i; j < nwords; j++)
          data[j] = -1;
      }
    }
    return data;
  }
  

  public static IntNum setBitValue(IntNum x, int bitno, int newValue)
  {
    newValue &= 0x1;
    int i = ival;
    

    if (words == null)
    {
      int oldValue = i >> (bitno < 31 ? bitno : 31) & 0x1;
      if (oldValue == newValue)
        return x;
      if (bitno < 63) {
        return IntNum.make(i ^ 1 << bitno);
      }
    }
    else {
      int wordno = bitno >> 5;
      int oldValue;
      int oldValue; if (wordno >= i) {
        oldValue = words[(i - 1)] < 0 ? 1 : 0;
      } else
        oldValue = words[wordno] >> bitno & 0x1;
      if (oldValue == newValue)
        return x;
    }
    int[] data = dataBufferFor(x, bitno);
    data[(bitno >> 5)] ^= 1 << (bitno & 0x1F);
    return IntNum.make(data, data.length);
  }
  

  public static boolean test(IntNum x, int y)
  {
    if (words == null)
      return (ival & y) != 0;
    return (y < 0) || ((words[0] & y) != 0);
  }
  

  public static boolean test(IntNum x, IntNum y)
  {
    if (words == null)
      return test(x, ival);
    if (words == null)
      return test(y, ival);
    if (ival < ival)
    {
      IntNum temp = x;x = y;y = temp;
    }
    for (int i = 0; i < ival; i++)
    {
      if ((words[i] & words[i]) != 0)
        return true;
    }
    return y.isNegative();
  }
  

  public static IntNum and(IntNum x, int y)
  {
    if (x.words == null)
      return IntNum.make(ival & y);
    if (y >= 0)
      return IntNum.make(x.words[0] & y);
    int len = ival;
    int[] words = new int[len];
    words[0] = (x.words[0] & y);
    for (;;) { len--; if (len <= 0) break;
      words[len] = x.words[len]; }
    return IntNum.make(words, ival);
  }
  

  public static IntNum and(IntNum x, IntNum y)
  {
    if (words == null)
      return and(x, ival);
    if (x.words == null)
      return and(y, ival);
    if (ival < ival)
    {
      IntNum temp = x;x = y;y = temp;
    }
    
    int len = y.isNegative() ? ival : ival;
    int[] words = new int[len];
    for (int i = 0; i < ival; i++)
      words[i] = (x.words[i] & words[i]);
    for (; i < len; i++)
      words[i] = x.words[i];
    return IntNum.make(words, len);
  }
  

  public static IntNum ior(IntNum x, IntNum y)
  {
    return bitOp(7, x, y);
  }
  

  public static IntNum xor(IntNum x, IntNum y)
  {
    return bitOp(6, x, y);
  }
  

  public static IntNum not(IntNum x)
  {
    return bitOp(12, x, IntNum.zero());
  }
  



  public static int swappedOp(int op)
  {
    return "\000\001\004\005\002\003\006\007\b\t\f\r\n\013\016\017".charAt(op);
  }
  



  public static IntNum bitOp(int op, IntNum x, IntNum y)
  {
    switch (op) {
    case 0: 
      return IntNum.zero();
    case 1:  return and(x, y);
    case 3:  return x;
    case 5:  return y;
    case 15:  return IntNum.minusOne();
    }
    IntNum result = new IntNum();
    setBitOp(result, op, x, y);
    return result.canonicalize();
  }
  

  public static void setBitOp(IntNum result, int op, IntNum x, IntNum y)
  {
    if ((words != null) && (
      (words == null) || (ival < ival)))
    {
      IntNum temp = x;x = y;y = temp;
      op = swappedOp(op);
    }
    int ylen;
    int yi;
    int ylen;
    if (words == null)
    {
      int yi = ival;
      ylen = 1;
    }
    else
    {
      yi = words[0];
      ylen = ival; }
    int xlen;
    int xi; int xlen; if (words == null)
    {
      int xi = ival;
      xlen = 1;
    }
    else
    {
      xi = words[0];
      xlen = ival;
    }
    if (xlen > 1)
      result.realloc(xlen);
    int[] w = words;
    int i = 0;
    



    int finish = 0;
    int ni;
    switch (op)
    {
    case 0: 
      ni = 0;
      break;
    case 1: 
      for (;;)
      {
        ni = xi & yi;
        if (i + 1 >= ylen) break;
        w[(i++)] = ni;xi = words[i];yi = words[i];
      }
      if (yi < 0) finish = 1;
      break;
    case 2: 
      for (;;)
      {
        ni = xi & (yi ^ 0xFFFFFFFF);
        if (i + 1 >= ylen) break;
        w[(i++)] = ni;xi = words[i];yi = words[i];
      }
      if (yi >= 0) finish = 1;
      break;
    case 3: 
      ni = xi;
      finish = 1;
      break;
    case 4: 
      for (;;)
      {
        ni = (xi ^ 0xFFFFFFFF) & yi;
        if (i + 1 >= ylen) break;
        w[(i++)] = ni;xi = words[i];yi = words[i];
      }
      if (yi < 0) finish = 2;
      break;
    case 5: 
      for (;;)
      {
        ni = yi;
        if (i + 1 >= ylen) break;
        w[(i++)] = ni;xi = words[i];yi = words[i];
      }
    
    case 6: 
      for (;;)
      {
        ni = xi ^ yi;
        if (i + 1 >= ylen) break;
        w[(i++)] = ni;xi = words[i];yi = words[i];
      }
      finish = yi < 0 ? 2 : 1;
      break;
    case 7: 
      for (;;)
      {
        ni = xi | yi;
        if (i + 1 >= ylen) break;
        w[(i++)] = ni;xi = words[i];yi = words[i];
      }
      if (yi >= 0) finish = 1;
      break;
    case 8: 
      for (;;)
      {
        ni = (xi | yi) ^ 0xFFFFFFFF;
        if (i + 1 >= ylen) break;
        w[(i++)] = ni;xi = words[i];yi = words[i];
      }
      if (yi >= 0) finish = 2;
      break;
    case 9: 
      for (;;)
      {
        ni = xi ^ yi ^ 0xFFFFFFFF;
        if (i + 1 >= ylen) break;
        w[(i++)] = ni;xi = words[i];yi = words[i];
      }
      finish = yi >= 0 ? 2 : 1;
      break;
    case 10: 
      for (;;)
      {
        ni = yi ^ 0xFFFFFFFF;
        if (i + 1 >= ylen) break;
        w[(i++)] = ni;xi = words[i];yi = words[i];
      }
    
    case 11: 
      for (;;)
      {
        ni = xi | yi ^ 0xFFFFFFFF;
        if (i + 1 >= ylen) break;
        w[(i++)] = ni;xi = words[i];yi = words[i];
      }
      if (yi < 0) finish = 1;
      break;
    case 12: 
      ni = xi ^ 0xFFFFFFFF;
      finish = 2;
      break;
    case 13: 
      for (;;)
      {
        ni = xi ^ 0xFFFFFFFF | yi;
        if (i + 1 >= ylen) break;
        w[(i++)] = ni;xi = words[i];yi = words[i];
      }
      if (yi >= 0) finish = 2;
      break;
    case 14: 
      for (;;)
      {
        ni = xi & yi ^ 0xFFFFFFFF;
        if (i + 1 >= ylen) break;
        w[(i++)] = ni;xi = words[i];yi = words[i];
      }
      if (yi < 0) finish = 2;
      break;
    case 15: 
    default: 
      ni = -1;
    }
    
    

    if (i + 1 == xlen)
      finish = 0;
    switch (finish)
    {
    case 0: 
      if ((i == 0) && (w == null))
      {
        ival = ni;
        return;
      }
      w[(i++)] = ni;
      break;
    case 1:  for (w[i] = ni;; w[i] = words[i]) { i++; if (i >= xlen) break;
      }  case 2:  for (w[i] = ni;; w[i] = (words[i] ^ 0xFFFFFFFF)) { i++; if (i >= xlen) break;
      } }
    ival = i;
  }
  
  public static IntNum makeMask(int startBit, int endBit)
  {
    int width = endBit - startBit;
    if (width <= 0)
      return IntNum.zero();
    if (endBit < 64)
      return IntNum.make((-1L << width ^ 0xFFFFFFFFFFFFFFFF) << startBit);
    int len = (endBit >> 5) + 1;
    int[] buf = new int[len];
    int startWord = startBit >> 5;
    int i = width >> 5;
    buf[i] = (-1 << (width & 0x1F) ^ 0xFFFFFFFF);
    for (;;) { i--; if (i < 0) break;
      buf[i] = -1;
    }
    MPN.lshift(buf, startWord, buf, len - startWord, startBit & 0x1F);
    i = startWord; for (;;) { i--; if (i < 0) break;
      buf[i] = 0; }
    return IntNum.make(buf, len);
  }
  



  public static IntNum extract(IntNum x, int startBit, int endBit)
  {
    if (endBit < 32)
    {
      int word0 = words == null ? ival : words[0];
      return IntNum.make((word0 & (-1 << endBit ^ 0xFFFFFFFF)) >> startBit);
    }
    int x_len;
    if (words == null)
    {
      if (ival >= 0)
        return IntNum.make(startBit >= 31 ? 0 : ival >> startBit);
      x_len = 1;
    }
    else {
      x_len = ival; }
    boolean neg = x.isNegative();
    if (endBit > 32 * x_len)
    {
      endBit = 32 * x_len;
      if ((!neg) && (startBit == 0)) {
        return x;
      }
    } else {
      x_len = endBit + 31 >> 5; }
    int length = endBit - startBit;
    if (length < 64) {
      long l;
      long l;
      if (words == null) {
        l = ival >> (startBit >= 32 ? 31 : startBit);
      } else
        l = MPN.rshift_long(words, x_len, startBit);
      return IntNum.make(l & (-1L << length ^ 0xFFFFFFFFFFFFFFFF));
    }
    int startWord = startBit >> 5;
    


    int buf_len = (endBit >> 5) + 1 - startWord;
    int[] buf = new int[buf_len];
    if (words == null) {
      buf[0] = (startBit >= 32 ? -1 : ival >> startBit);
    }
    else {
      x_len -= startWord;
      startBit &= 0x1F;
      MPN.rshift0(buf, words, startWord, x_len, startBit);
    }
    int x_len = length >> 5;
    buf[x_len] &= (-1 << length ^ 0xFFFFFFFF);
    return IntNum.make(buf, x_len + 1);
  }
  
  public static int lowestBitSet(int i)
  {
    if (i == 0)
      return -1;
    int index = 0;
    while ((i & 0xFF) == 0)
    {
      i >>>= 8;
      index += 8;
    }
    while ((i & 0x3) == 0)
    {
      i >>>= 2;
      index += 2;
    }
    if ((i & 0x1) == 0)
      index++;
    return index;
  }
  
  public static int lowestBitSet(IntNum x)
  {
    int[] x_words = words;
    if (x_words == null)
    {
      return lowestBitSet(ival);
    }
    

    int x_len = ival;
    for (int i = 0; i < x_len;)
    {
      int b = lowestBitSet(x_words[i]);
      if (b >= 0)
        return 32 * i + b;
    }
    return -1;
  }
  


  static final byte[] bit4_count = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
  

  public static int bitCount(int i)
  {
    int count = 0;
    while (i != 0)
    {
      count += bit4_count[(i & 0xF)];
      i >>>= 4;
    }
    return count;
  }
  
  public static int bitCount(int[] x, int len)
  {
    int count = 0;
    for (;;) { len--; if (len < 0) break;
      count += bitCount(x[len]); }
    return count;
  }
  



  public static int bitCount(IntNum x)
  {
    int[] x_words = words;
    int i; int x_len; int i; if (x_words == null)
    {
      int x_len = 1;
      i = bitCount(ival);
    }
    else
    {
      x_len = ival;
      i = bitCount(x_words, x_len);
    }
    return x.isNegative() ? x_len * 32 - i : i;
  }
  
  public static IntNum reverseBits(IntNum x, int start, int end)
  {
    int ival = x.ival;
    int[] xwords = words;
    if (xwords == null)
    {
      if (end < 63)
      {
        long w = ival;
        int i = start;
        int j = end - 1;
        while (i < j)
        {
          long biti = w >> i & 1L;
          long bitj = w >> j & 1L;
          w &= ((1L << i | 1L << j) ^ 0xFFFFFFFFFFFFFFFF);
          w = w | biti << j | bitj << i;
          i++;
          j--;
        }
        return IntNum.make(w);
      }
    }
    int[] data = dataBufferFor(x, end - 1);
    int i = start;
    int j = end - 1;
    while (i < j)
    {
      int ii = i >> 5;
      int jj = j >> 5;
      int wi = data[ii];
      int biti = wi >> i & 0x1;
      if (ii == jj)
      {
        int bitj = wi >> j & 0x1;
        wi = (int)(wi & ((1L << i | 1L << j) ^ 0xFFFFFFFFFFFFFFFF));
        wi = wi | biti << j | bitj << i;
      }
      else
      {
        int wj = data[jj];
        int bitj = wj >> (j & 0x1F) & 0x1;
        wi &= (1 << (i & 0x1F) ^ 0xFFFFFFFF);
        wj &= (1 << (j & 0x1F) ^ 0xFFFFFFFF);
        wi |= bitj << (i & 0x1F);
        wj |= biti << (j & 0x1F);
        data[jj] = wj;
      }
      data[ii] = wi;
      i++;
      j--;
    }
    return IntNum.make(data, data.length);
  }
  
  public static int shift(int x, int count) {
    if (count >= 32)
      return 0;
    if (count >= 0)
      return x << count;
    count = -count;
    if (count >= 32)
      return x < 0 ? -1 : 0;
    return x >> count;
  }
  
  public static int shiftUnsigned(int x, int count) {
    if (count >= 32)
      return 0;
    if (count >= 0)
      return x << count;
    count = -count;
    return count >= 32 ? 0 : x >>> count;
  }
  
  public static long shift(long x, int count) {
    if (count >= 64)
      return 0L;
    if (count >= 0)
      return x << count;
    count = -count;
    if (count >= 64)
      return x < 0L ? -1L : 0L;
    return x >> count;
  }
  
  public static long shiftUnsigned(long x, int count) {
    if (count >= 64)
      return 0L;
    if (count >= 0)
      return x << count;
    count = -count;
    return count >= 64 ? 0L : x >>> count;
  }
}
