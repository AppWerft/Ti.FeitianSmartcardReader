package gnu.xquery.util;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.CollationKey;
import java.text.Collator;


public class NamedCollator
  extends Collator
  implements Externalizable
{
  Collator collator;
  String name;
  public static final String UNICODE_CODEPOINT_COLLATION = "http://www.w3.org/2005/xpath-functions/collation/codepoint";
  
  public static NamedCollator make(String name)
  {
    NamedCollator coll = new NamedCollator();
    name = name;
    coll.resolve();
    return coll;
  }
  
  public String getName()
  {
    return name;
  }
  
  public static NamedCollator find(String name)
  {
    return make(name);
  }
  
  public static final NamedCollator codepointCollation = new NamedCollator();
  static { codepointCollationname = "http://www.w3.org/2005/xpath-functions/collation/codepoint"; }
  
  public void resolve()
  {
    if ((name != null) && (!name.equals("http://www.w3.org/2005/xpath-functions/collation/codepoint")))
    {

      throw new RuntimeException("unknown collation: " + name);
    }
  }
  




  public static int codepointCompare(String str1, String str2)
  {
    int i1 = 0;int i2 = 0;
    int len1 = str1.length();
    int len2 = str2.length();
    for (;;)
    {
      if (i1 == len1)
        return i2 == len2 ? 0 : -1;
      if (i2 == len2)
        return 1;
      int c1 = str1.charAt(i1++);
      if ((c1 >= 55296) && (c1 < 56320) && (i1 < len1)) {
        c1 = (c1 - 55296) * 1024 + (str1.charAt(i1++) - 56320) + 65536;
      }
      int c2 = str2.charAt(i2++);
      if ((c2 >= 55296) && (c2 < 56320) && (i2 < len2)) {
        c2 = (c2 - 55296) * 1024 + (str2.charAt(i2++) - 56320) + 65536;
      }
      if (c1 != c2) {
        return c1 < c2 ? -1 : 1;
      }
    }
  }
  
  public int compare(String str1, String str2)
  {
    if (collator != null) {
      return collator.compare(str1, str2);
    }
    return codepointCompare(str1, str2);
  }
  

  public CollationKey getCollationKey(String source)
  {
    return collator.getCollationKey(source);
  }
  


  public int hashCode()
  {
    if (collator != null) {
      return collator.hashCode();
    }
    return 0;
  }
  
  public void writeExternal(ObjectOutput out) throws IOException
  {
    out.writeUTF(name);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    name = in.readUTF();
    resolve();
  }
  
  public NamedCollator() {}
}
