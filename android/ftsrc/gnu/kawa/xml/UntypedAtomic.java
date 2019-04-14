package gnu.kawa.xml;




public class UntypedAtomic
{
  String text;
  



  public String toString()
  {
    return text;
  }
  
  public UntypedAtomic(String text)
  {
    this.text = text;
  }
  
  public int hashCode()
  {
    return text.hashCode();
  }
  
  public boolean equals(Object arg)
  {
    return ((arg instanceof UntypedAtomic)) && (text.equals(text));
  }
}
