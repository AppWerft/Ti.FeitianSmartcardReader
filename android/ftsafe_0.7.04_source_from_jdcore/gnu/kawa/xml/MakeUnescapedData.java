package gnu.kawa.xml;

import gnu.mapping.Procedure1;

public class MakeUnescapedData extends Procedure1
{
  public static final MakeUnescapedData unescapedData = new MakeUnescapedData();
  

  public MakeUnescapedData()
  {
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.xml.CompileXmlFunctions:validateApplyMakeUnescapedData");
  }
  

  public Object apply1(Object arg)
  {
    return new gnu.lists.UnescapedData(arg == null ? "" : arg.toString());
  }
}
