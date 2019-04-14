package gnu.kawa.xml;




public class XString
  implements CharSequence
{
  public String text;
  

  private XStringType type;
  


  public XStringType getStringType()
  {
    return type;
  }
  
  public char charAt(int index) { return text.charAt(index); }
  
  public int length() { return text.length(); }
  
  public CharSequence subSequence(int start, int end)
  {
    return text.substring(start, end);
  }
  
  public String toString() { return text; }
  
  XString(String text, XStringType type)
  {
    this.text = text;
    this.type = type;
  }
}
