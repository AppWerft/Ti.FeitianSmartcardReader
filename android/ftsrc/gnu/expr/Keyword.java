package gnu.expr;

import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;



public class Keyword
  extends Symbol
  implements Externalizable
{
  public static final Namespace keywordNamespace = ;
  
  static {
    keywordNamespace.setName("(keywords)");
  }
  


  private Keyword(String name)
  {
    super(name, keywordNamespace);
  }
  


  public Keyword(Namespace namespace, String name)
  {
    super(name, namespace);
  }
  




  public Symbol asSymbol()
  {
    return Namespace.EmptyNamespace.getSymbol(getName());
  }
  





  public static Keyword make(String name)
  {
    int hash = name.hashCode();
    Keyword keyword = (Keyword)keywordNamespace.lookup(name, hash, false);
    if (keyword == null) {
      keyword = new Keyword(name);
      keywordNamespace.add(keyword, hash);
    }
    return keyword;
  }
  











  public static boolean isKeyword(Object obj)
  {
    return obj instanceof Keyword;
  }
  
  public final String toString()
  {
    return getName() + ':';
  }
  











  public static Object searchForKeyword(Object[] vals, int offset, Object keyword)
  {
    for (int i = offset; i < vals.length; i += 2) {
      if (vals[i] == keyword) {
        return vals[(i + 1)];
      }
    }
    return Special.dfault;
  }
  













  public static Object searchForKeyword(Object[] vals, int offset, Object keyword, Object dfault)
  {
    for (int i = offset; i < vals.length; i += 2) {
      if (vals[i] == keyword) {
        return vals[(i + 1)];
      }
    }
    return dfault;
  }
  
  public void writeExternal(ObjectOutput out) throws IOException
  {
    out.writeObject(getName());
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    name = ((String)in.readObject());
  }
  
  public Object readResolve() throws ObjectStreamException
  {
    return make(keywordNamespace, getName());
  }
  
  public Keyword() {}
}
