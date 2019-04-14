package gnu.kawa.models;

public abstract interface Window
{
  public abstract Display getDisplay();
  
  public abstract void setContent(Object paramObject);
  
  public abstract void setTitle(String paramString);
  
  public abstract void setMenuBar(Object paramObject);
  
  public abstract String getTitle();
  
  public abstract void open();
}
