package gnu.math;





public class Dimensions
{
  BaseUnit[] bases;
  



  short[] powers;
  



  int hash_code;
  



  private Dimensions chain;
  


  private static Dimensions[] hashTable = new Dimensions[100];
  
  public final int hashCode() { return hash_code; }
  
  private void enterHash(int hash_code)
  {
    this.hash_code = hash_code;
    int index = (hash_code & 0x7FFFFFFF) % hashTable.length;
    chain = hashTable[index];
    hashTable[index] = this;
  }
  

  public static Dimensions Empty = new Dimensions();
  

  private Dimensions()
  {
    bases = new BaseUnit[1];
    bases[0] = Unit.Empty;
    enterHash(0);
  }
  

  Dimensions(BaseUnit unit)
  {
    bases = new BaseUnit[2];
    powers = new short[1];
    bases[0] = unit;
    bases[1] = Unit.Empty;
    powers[0] = 1;
    enterHash(index);
  }
  


  private Dimensions(Dimensions a, int mul_a, Dimensions b, int mul_b, int hash_code)
  {
    int a_i = 0;int b_i = 0;
    this.hash_code = hash_code;
    for (a_i = 0; bases[a_i] != Unit.Empty; a_i++) {}
    for (b_i = 0; bases[b_i] != Unit.Empty; b_i++) {}
    int t_i = a_i + b_i + 1;
    bases = new BaseUnit[t_i];
    powers = new short[t_i];
    a_i = b_i = t_i = 0;
    for (;;)
    {
      BaseUnit a_base = bases[a_i];
      BaseUnit b_base = bases[b_i];
      int pow;
      if (index < index)
      {
        int pow = powers[a_i] * mul_a;
        a_i++;
      }
      else if (index < index)
      {
        a_base = b_base;
        int pow = powers[b_i] * mul_b;
        b_i++;
      } else {
        if (b_base == Unit.Empty) {
          break;
        }
        
        pow = powers[a_i] * mul_a + powers[b_i] * mul_b;
        a_i++;b_i++;
        if (pow == 0)
          continue;
      }
      if ((short)pow != pow)
        throw new ArithmeticException("overflow in dimensions");
      bases[t_i] = a_base;
      powers[(t_i++)] = ((short)pow);
    }
    bases[t_i] = Unit.Empty;
    enterHash(hash_code);
  }
  


  private boolean matchesProduct(Dimensions a, int mul_a, Dimensions b, int mul_b)
  {
    int a_i = 0;int b_i = 0;
    int t_i = 0;
    for (;;) {
      BaseUnit a_base = bases[a_i];
      BaseUnit b_base = bases[b_i];
      int pow;
      if (index < index)
      {
        int pow = powers[a_i] * mul_a;
        a_i++;
      }
      else if (index < index)
      {
        a_base = b_base;
        int pow = powers[b_i] * mul_b;
        b_i++;
      } else {
        if (b_base == Unit.Empty) {
          return bases[t_i] == b_base;
        }
        
        pow = powers[a_i] * mul_a + powers[b_i] * mul_b;
        a_i++;b_i++;
        if (pow == 0)
          continue;
      }
      if ((bases[t_i] != a_base) || (powers[t_i] != pow))
        return false;
      t_i++;
    }
  }
  

  public static Dimensions product(Dimensions a, int mul_a, Dimensions b, int mul_b)
  {
    int hash = a.hashCode() * mul_a + b.hashCode() * mul_b;
    int index = (hash & 0x7FFFFFFF) % hashTable.length;
    for (Dimensions dim = hashTable[index]; 
        dim != null; dim = chain)
    {
      if ((hash_code == hash) && (dim.matchesProduct(a, mul_a, b, mul_b)))
        return dim;
    }
    return new Dimensions(a, mul_a, b, mul_b, hash);
  }
  

  public int getPower(BaseUnit unit)
  {
    for (int i = 0; bases[i].index <= index; i++)
    {
      if (bases[i] == unit)
        return powers[i];
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuffer buf = new StringBuffer();
    for (int i = 0; bases[i] != Unit.Empty; i++)
    {
      if (i > 0)
        buf.append('*');
      buf.append(bases[i]);
      int pow = powers[i];
      if (pow != 1)
      {
        buf.append('^');
        buf.append(pow);
      }
    }
    return buf.toString();
  }
}
