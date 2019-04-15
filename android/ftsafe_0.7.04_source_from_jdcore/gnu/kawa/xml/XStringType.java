package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.xml.TextUtils;
import gnu.xml.XName;
import java.util.regex.Matcher;
import java.util.regex.Pattern;






public class XStringType
  extends XDataType
{
  Pattern pattern;
  static ClassType XStringType = ClassType.make("gnu.kawa.xml.XString");
  

  public XStringType(String name, XDataType base, int typeCode, String pattern)
  {
    super(name, XStringType, typeCode);
    baseType = base;
    
    if (pattern != null) {
      this.pattern = Pattern.compile(pattern);
    }
  }
  
  public static final XStringType normalizedStringType = new XStringType("normalizedString", stringType, 39, null);
  


  public static final XStringType tokenType = new XStringType("token", normalizedStringType, 40, null);
  


  public static final XStringType languageType = new XStringType("language", tokenType, 41, "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*");
  


  public static final XStringType NMTOKENType = new XStringType("NMTOKEN", tokenType, 42, "\\c+");
  


  public static final XStringType NameType = new XStringType("Name", tokenType, 43, null);
  


  public static final XStringType NCNameType = new XStringType("NCName", NameType, 44, null);
  


  public static final XStringType IDType = new XStringType("ID", NCNameType, 45, null);
  


  public static final XStringType IDREFType = new XStringType("IDREF", NCNameType, 46, null);
  


  public static final XStringType ENTITYType = new XStringType("ENTITY", NCNameType, 47, null);
  


  public boolean isInstance(Object obj)
  {
    if (!(obj instanceof XString)) {
      return false;
    }
    


    XDataType objType = ((XString)obj).getStringType();
    while (objType != null)
    {
      if (objType == this)
        return true;
      objType = baseType;
    }
    return false;
  }
  


  public String matches(String value)
  {
    boolean status;
    

    switch (typeCode)
    {







    case 39: 
    case 40: 
      boolean collapse = typeCode != 39;
      status = value == TextUtils.replaceWhitespace(value, collapse);
      break;
    case 43: 
      status = XName.isName(value);
      break;
    case 44: 
    case 45: 
    case 46: 
    case 47: 
      status = XName.isNCName(value);
      break;
    case 42: 
      status = XName.isNmToken(value);
      break;
    case 41: 
    default: 
      status = (pattern == null) || (pattern.matcher(value).matches());
    }
    
    


    return "not a valid XML " + getName();
  }
  
  public Object valueOf(String value)
  {
    value = TextUtils.replaceWhitespace(value, this != normalizedStringType);
    String err = matches(value);
    if (err != null)
      throw new ClassCastException("cannot cast " + value + " to " + name);
    return new XString(value, this);
  }
  
  public Object cast(Object value)
  {
    if ((value instanceof XString))
    {
      XString xvalue = (XString)value;
      if (xvalue.getStringType() == this)
        return xvalue;
    }
    return valueOf((String)stringType.cast(value));
  }
  
  public static XString makeNCName(String value)
  {
    return (XString)NCNameType.valueOf(value);
  }
}
