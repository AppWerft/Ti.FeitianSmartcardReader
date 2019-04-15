package kawa.standard;

import gnu.expr.AbstractScriptEngineFactory;
import java.util.List;

public class SchemeScriptEngineFactory extends AbstractScriptEngineFactory
{
  public SchemeScriptEngineFactory()
  {
    super(Scheme.instance);
  }
  
  protected void getNames(List<String> names)
  {
    names.add("scheme");
    names.add("kawa");
    names.add("kawa-scheme");
  }
}
