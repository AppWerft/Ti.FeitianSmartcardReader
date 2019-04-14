package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;













public abstract class CpoolEntry
{
  int hash;
  public int index;
  CpoolEntry next;
  
  public int getIndex()
  {
    return index;
  }
  

  public abstract int getTag();
  
  public int hashCode()
  {
    return hash;
  }
  

  abstract void write(DataOutputStream paramDataOutputStream)
    throws IOException;
  

  void add_hashed(ConstantPool cpool)
  {
    CpoolEntry[] hashTab = hashTab;
    int index = (hash & 0x7FFFFFFF) % hashTab.length;
    next = hashTab[index];
    hashTab[index] = this;
  }
  
  protected CpoolEntry() {}
  
  public CpoolEntry(ConstantPool cpool, int h)
  {
    hash = h;
    if (locked)
      throw new Error("adding new entry to locked contant pool");
    index = (++count);
    

    if (pool == null) {
      pool = new CpoolEntry[60];
    } else if (index >= pool.length)
    {
      int old_size = pool.length;
      int new_size = 2 * pool.length;
      CpoolEntry[] new_pool = new CpoolEntry[new_size];
      for (int i = 0; i < old_size; i++)
        new_pool[i] = pool[i];
      pool = new_pool;
    }
    

    if ((hashTab == null) || (index >= 0.6D * hashTab.length)) {
      cpool.rehash();
    }
    
    pool[index] = this;
    
    add_hashed(cpool);
  }
  
  public abstract void print(ClassTypeWriter paramClassTypeWriter, int paramInt);
}
