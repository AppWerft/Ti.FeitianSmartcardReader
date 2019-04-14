package gnu.kawa.xml;

import gnu.kawa.io.CharArrayOutPort;
import gnu.lists.FString;
import gnu.mapping.Procedure1;
import gnu.xml.XMLPrinter;

public class OutputAsXML
  extends Procedure1
{
  public OutputAsXML() {}
  
  public int numArgs()
  {
    return 4097;
  }
  
  public Object apply1(Object arg) {
    CharArrayOutPort port = new CharArrayOutPort();
    XMLPrinter out = new XMLPrinter(port);
    out.writeObject(arg);
    out.flush();
    return new FString(port.toCharArray());
  }
}
