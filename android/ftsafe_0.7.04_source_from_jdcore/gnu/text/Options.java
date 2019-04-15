package gnu.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;








public class Options
{
  public static final int BOOLEAN_OPTION = 1;
  public static final int STRING_OPTION = 2;
  Options previous;
  OptionInfo first;
  OptionInfo last;
  HashMap<String, Object> valueTable;
  HashMap<String, OptionInfo> infoTable;
  public static final String UNKNOWN = "unknown option name";
  
  public Options() {}
  
  public Options(Options previous)
  {
    this.previous = previous;
  }
  











  public OptionInfo add(String key, int kind, String documentation)
  {
    return add(key, kind, null, documentation);
  }
  

  public OptionInfo add(String key, int kind, Object defaultValue, String documentation)
  {
    if (infoTable == null) {
      infoTable = new HashMap();
    } else if (infoTable.get(key) != null)
      throw new RuntimeException("duplicate option key: " + key);
    OptionInfo info = new OptionInfo();
    key = key;
    kind = kind;
    defaultValue = defaultValue;
    documentation = documentation;
    if (first == null) {
      first = info;
    } else
      last.next = info;
    last = info;
    infoTable.put(key, info);
    return info;
  }
  
  public static Boolean booleanValue(String argument) {
    if ((argument == null) || (argument.equals("1")) || (argument.equals("on")) || (argument.equals("yes")) || (argument.equals("true")))
    {



      return Boolean.TRUE; }
    if ((argument.equals("0")) || (argument.equals("off")) || (argument.equals("no")) || (argument.equals("false")))
    {


      return Boolean.FALSE; }
    return null;
  }
  
  static Object valueOf(OptionInfo info, String argument)
  {
    if ((kind & 0x1) != 0)
    {
      return booleanValue(argument);
    }
    return argument;
  }
  
  private void error(String message, SourceMessages messages)
  {
    if (messages == null) {
      throw new RuntimeException(message);
    }
    messages.error('e', message);
  }
  

  public void set(String key, Object value)
  {
    set(key, value, null);
  }
  


  public Object set(String key, Object value, SourceMessages messages)
  {
    if (valueTable == null)
      valueTable = new HashMap();
    Object oldValue = valueTable.get(key);
    OptionInfo info = getInfo(key);
    if (info == null)
    {
      error("invalid option key: " + key, messages);
      return oldValue;
    }
    if ((kind & 0x1) != 0)
    {
      if ((value instanceof String))
        value = valueOf(info, (String)value);
      if (!(value instanceof Boolean))
      {
        error("value for option " + key + " must be boolean or yes/no/true/false/on/off/1/0", messages);
        

        return oldValue;
      }
    }
    else if (value == null) {
      value = ""; }
    valueTable.put(key, value);
    return oldValue;
  }
  

  public void reset(String key, Object oldValue)
  {
    if (valueTable == null)
      valueTable = new HashMap();
    if (oldValue == null) {
      valueTable.remove(key);
    } else {
      valueTable.put(key, oldValue);
    }
  }
  




  public String set(String key, String argument)
  {
    OptionInfo info = getInfo(key);
    if (info == null)
      return "unknown option name";
    Object value = valueOf(info, argument);
    if (value == null)
    {
      if ((kind & 0x1) != 0)
        return "value of option " + key + " must be yes/no/true/false/on/off/1/0";
    }
    if (valueTable == null)
      valueTable = new HashMap();
    valueTable.put(key, value);
    return null;
  }
  
  public OptionInfo getInfo(String key)
  {
    Object info = infoTable == null ? null : (OptionInfo)infoTable.get(key);
    if ((info == null) && (previous != null))
      info = previous.getInfo(key);
    return (OptionInfo)info;
  }
  




  public Object get(String key, Object defaultValue)
  {
    OptionInfo info = getInfo(key);
    if (info == null)
      throw new RuntimeException("invalid option key: " + key);
    return get(info, defaultValue);
  }
  
  public Object get(OptionInfo key, Object defaultValue)
  {
    Options options = this;
    while (options != null)
    {
      OptionInfo info = key;
      for (;;) {
        Object val = valueTable == null ? null : valueTable.get(key);
        
        if (val != null)
          return val;
        if ((defaultValue instanceof OptionInfo)) {
          info = (OptionInfo)defaultValue;
        }
        else {
          if (defaultValue == null) break;
          defaultValue = defaultValue; break;
        }
      }
      
      options = previous;
    }
    return defaultValue;
  }
  
  public Object get(OptionInfo key)
  {
    return get(key, null);
  }
  





  public Object getLocal(String key)
  {
    return valueTable == null ? null : valueTable.get(key);
  }
  
  public boolean getBoolean(String key)
  {
    return ((Boolean)get(key, Boolean.FALSE)).booleanValue();
  }
  
  public boolean getBoolean(String key, boolean defaultValue)
  {
    Boolean defaultObject = defaultValue ? Boolean.TRUE : Boolean.FALSE;
    return ((Boolean)get(key, defaultObject)).booleanValue();
  }
  
  public boolean getBoolean(OptionInfo key, boolean defaultValue)
  {
    Boolean defaultObject = defaultValue ? Boolean.TRUE : Boolean.FALSE;
    return ((Boolean)get(key, defaultObject)).booleanValue();
  }
  
  public boolean getBoolean(OptionInfo key)
  {
    Object value = get(key, null);
    return value == null ? false : ((Boolean)value).booleanValue();
  }
  






  public void pushOptionValues(Vector options)
  {
    int len = options.size();
    for (int i = 0; i < len; i += 3)
    {
      String key = (String)options.elementAt(i);
      Object oldValue = set(key, options.elementAt(i + 2), null);
      options.setElementAt(oldValue, i + 1);
    }
  }
  


  public void popOptionValues(Vector options)
  {
    int i = options.size(); for (;;) { i -= 3; if (i < 0)
        break;
      String key = (String)options.elementAt(i);
      Object oldValue = options.elementAt(i + 1);
      options.setElementAt(null, i + 1);
      reset(key, oldValue);
    }
  }
  


  public ArrayList<String> keys()
  {
    ArrayList<String> allKeys = new ArrayList();
    for (Options options = this; options != null; options = previous)
    {
      if (infoTable != null)
      {
        for (String k : infoTable.keySet())
        {
          if (!allKeys.contains(k))
            allKeys.add(k);
        }
      }
    }
    return allKeys;
  }
  
  public String getDoc(String key)
  {
    OptionInfo info = getInfo(key);
    if (key == null)
      return null;
    return documentation;
  }
  
  public static final class OptionInfo
  {
    OptionInfo next;
    String key;
    int kind;
    String documentation;
    Object defaultValue;
    
    public OptionInfo() {}
  }
}
