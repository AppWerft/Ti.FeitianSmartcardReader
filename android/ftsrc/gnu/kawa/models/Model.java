package gnu.kawa.models;



public abstract class Model
  implements Viewable
{
  transient WeakListener listeners;
  


  public Model() {}
  

  public void addListener(ModelListener listener)
  {
    listeners = new WeakListener(listener, listeners);
  }
  
  public void addListener(WeakListener listener)
  {
    next = listeners;
    listeners = listener;
  }
  
  public void notifyListeners(String key)
  {
    WeakListener prev = null;
    WeakListener wlistener = listeners;
    while (wlistener != null)
    {
      Object listener = wlistener.get();
      WeakListener next = next;
      if (listener == null)
      {
        if (prev != null) {
          next = next;
        }
      }
      else {
        prev = wlistener;
        wlistener.update(listener, this, key);
      }
      wlistener = next;
    }
  }
}
