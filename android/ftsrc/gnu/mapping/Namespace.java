package gnu.mapping;

import gnu.kawa.util.AbstractHashTable;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Hashtable;











public class Namespace
  extends AbstractHashTable<SymbolRef, String, Symbol>
  implements Externalizable, HasNamedParts
{
  protected static final Hashtable nsTable = new Hashtable(50);
  

  public static final Namespace EmptyNamespace = valueOf("");
  

  String name;
  
  protected String prefix = "";
  

  public final String getName() { return name; }
  
  public final void setName(String name) { this.name = name; }
  
  public final String getPrefix() { return prefix; }
  
  public Namespace()
  {
    this(64);
  }
  
  protected Namespace(int capacity)
  {
    super(capacity);
  }
  
  public static Namespace create(int capacity)
  {
    return new Namespace(capacity);
  }
  
  public static Namespace create()
  {
    return new Namespace(64);
  }
  
  public static Namespace getDefault()
  {
    return EmptyNamespace;
  }
  
  public static Symbol getDefaultSymbol(String name)
  {
    return EmptyNamespace.getSymbol(name);
  }
  
  public static Namespace valueOf()
  {
    return EmptyNamespace;
  }
  



  public static Namespace valueOf(String name)
  {
    if (name == null)
      name = "";
    synchronized (nsTable)
    {
      Namespace ns = (Namespace)nsTable.get(name);
      if (ns != null)
        return ns;
      ns = new Namespace();
      ns.setName(name.intern());
      nsTable.put(name, ns);
      return ns;
    }
  }
  


  public static Namespace valueOfNoCreate(String name)
  {
    if (name == null)
      name = "";
    return (Namespace)nsTable.get(name);
  }
  
  public static Namespace valueOf(String uri, String prefix)
  {
    if ((prefix == null) || (prefix.length() == 0))
      return valueOf(uri);
    String xname = prefix + " -> " + uri;
    synchronized (nsTable)
    {
      Object old = nsTable.get(xname);
      if ((old instanceof Namespace))
        return (Namespace)old;
      Namespace ns = new Namespace();
      if (uri != UNKNOWN_NAMESPACE)
        uri = uri.intern();
      ns.setName(uri);
      prefix = prefix.intern();
      nsTable.put(xname, ns);
      return ns;
    }
  }
  
  public static Namespace valueOf(String uri, SimpleSymbol prefix)
  {
    return valueOf(uri, prefix == null ? null : prefix.getName());
  }
  
  public static final String UNKNOWN_NAMESPACE = new String("$unknown$");
  
  public boolean isUnknownNamespace()
  {
    return name == UNKNOWN_NAMESPACE;
  }
  



  public static Namespace makeUnknownNamespace(String prefix)
  {
    String uri = (prefix == null) || (prefix == "") ? "" : UNKNOWN_NAMESPACE;
    
    return valueOf(uri, prefix);
  }
  
  public Object get(String key)
  {
    return Environment.getCurrent().get(getSymbol(key));
  }
  
  public boolean isConstant(String key)
  {
    return false;
  }
  




  public Symbol getSymbol(String key)
  {
    return lookup(key, key.hashCode(), true);
  }
  



  public Symbol lookup(String key)
  {
    return lookup(key, key.hashCode(), false);
  }
  



  protected final Symbol lookupInternal(String key, int hash)
  {
    int index = hashToIndex(hash);
    SymbolRef prev = null;
    for (SymbolRef ref = ((SymbolRef[])table)[index]; ref != null;)
    {
      SymbolRef next = next;
      Symbol sym = ref.getSymbol();
      if (sym == null)
      {

        if (prev == null) {
          ((SymbolRef[])table)[index] = next;
        } else
          next = next;
        num_bindings -= 1;
      }
      else
      {
        if (sym.getLocalPart().equals(key))
          return sym;
        prev = ref;
      }
      ref = next;
    }
    return null;
  }
  
  public Symbol add(Symbol sym, int hash)
  {
    put(sym.getName(), hash, sym);
    return sym;
  }
  
  public Symbol get(Object key, Symbol defaultValue)
  {
    if ((key instanceof String))
    {
      Symbol sym = lookup((String)key, key.hashCode(), false);
      if (sym != null)
        return sym;
    }
    return defaultValue;
  }
  
  public Symbol lookup(String key, int hash, boolean create)
  {
    synchronized (this)
    {
      Symbol sym = lookupInternal(key, hash);
      if (sym != null) {
        return sym;
      }
      









      if (create)
      {
        if (this == EmptyNamespace) {
          sym = new SimpleSymbol(key);
        } else
          sym = new Symbol(key, this);
        return add(sym, hash);
      }
      
      return null;
    }
  }
  
  public boolean remove(Symbol symbol)
  {
    synchronized (this)
    {
      String name = symbol.getLocalPart();
      return remove(name) != null;
    }
  }
  
  protected int getEntryHashCode(SymbolRef entry) { return entry.hashCode(); }
  
  protected SymbolRef getEntryNext(SymbolRef entry) { return next; }
  
  protected void setEntryNext(SymbolRef entry, SymbolRef next) { next = next; }
  
  protected SymbolRef[] allocEntries(int n) { return new SymbolRef[n]; }
  
  protected SymbolRef makeEntry(String key, int hash, Symbol value) {
    return new SymbolRef(value);
  }
  
  public void writeExternal(ObjectOutput out) throws IOException
  {
    out.writeObject(getName());
    out.writeObject(prefix);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    name = ((String)in.readObject()).intern();
    prefix = ((String)in.readObject());
  }
  
  public Object readResolve() throws ObjectStreamException
  {
    String name = getName();
    if (name != null)
    {
      String xname = prefix + " -> " + name;
      
      Namespace ns = (Namespace)nsTable.get(xname);
      if (ns != null)
        return ns;
      nsTable.put(xname, this);
    }
    return this;
  }
  

  public String toString()
  {
    StringBuilder sbuf = new StringBuilder("#,(namespace \"");
    sbuf.append(name);
    sbuf.append('"');
    if ((prefix != null) && (prefix != ""))
    {
      sbuf.append(' ');
      sbuf.append(prefix);
    }
    sbuf.append(')');
    return sbuf.toString();
  }
}
