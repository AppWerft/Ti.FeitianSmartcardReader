package gnu.text;

import org.xml.sax.Locator;

public abstract interface SourceLocator
  extends Locator
{
  public abstract int getColumnNumber();
  
  public abstract int getLineNumber();
  
  public abstract String getPublicId();
  
  public abstract String getSystemId();
  
  public abstract String getFileName();
  
  public abstract boolean isStableSourceLocation();
}
