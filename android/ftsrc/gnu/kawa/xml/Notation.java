package gnu.kawa.xml;

import gnu.mapping.Symbol;

public class Notation {
  Symbol qname;
  
  public Notation() {}
  
  public boolean equals(Notation n1, Notation n2) { return qname.equals(qname); }
  

  public boolean equals(Object obj)
  {
    return ((obj instanceof Notation)) && (equals(this, (Notation)obj));
  }
  
  public int hashCode()
  {
    return qname.hashCode();
  }
}
