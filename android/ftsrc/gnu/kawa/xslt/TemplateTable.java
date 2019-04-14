package gnu.kawa.xslt;

import gnu.mapping.Procedure;
import gnu.mapping.Symbol;




public class TemplateTable
{
  Symbol name;
  static final TemplateTable nullModeTable = new TemplateTable(XSLT.nullMode);
  TemplateEntry entries;
  
  public TemplateTable(Symbol mode) {
    name = mode;
  }
  
  static TemplateTable getTemplateTable(Symbol name)
  {
    if (name == XSLT.nullMode)
      return nullModeTable;
    return null;
  }
  


  public void enter(String pattern, double priority, Procedure procedure)
  {
    TemplateEntry entry = new TemplateEntry();
    procedure = procedure;
    priority = priority;
    pattern = pattern;
    next = entries;
    entries = entry;
  }
  
  public Procedure find(String name)
  {
    for (TemplateEntry entry = entries; entry != null; entry = next)
    {
      if (pattern.equals(name))
        return procedure;
    }
    return null;
  }
}
