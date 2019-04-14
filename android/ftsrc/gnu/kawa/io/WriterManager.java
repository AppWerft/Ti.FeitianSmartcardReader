package gnu.kawa.io;

import java.io.Writer;
import java.lang.ref.WeakReference;









public final class WriterManager
  implements Runnable
{
  public static final WriterManager instance = new WriterManager();
  
  WriterRef first;
  

  private WriterManager() {}
  
  public synchronized WriterRef register(OutPort port)
  {
    WriterRef ref = new WriterRef(port);
    WriterRef first = this.first;
    if (first != null)
    {
      next = first;
      prev = ref;
    }
    this.first = ref;
    return ref;
  }
  



  public synchronized void unregister(WriterRef key)
  {
    if (key == null)
      return;
    WriterRef ref = key;
    WriterRef next = next;
    WriterRef prev = prev;
    if (next != null)
      prev = prev;
    if (prev != null)
      next = next;
    next = null;
    prev = null;
    if (ref == first) {
      first = next;
    }
  }
  
  public synchronized void run() {
    for (WriterRef ref = first; ref != null;)
    {
      WriterRef next = next;
      Object port = ref.get();
      if (port != null)
      {
        try
        {
          ((OutPort)port).close();
        }
        catch (Exception ex) {}
      }
      


      ref = next;
    }
    first = null;
  }
  



  public boolean registerShutdownHook()
  {
    try
    {
      Runtime.getRuntime().addShutdownHook(new Thread(this));
      return true;
    }
    catch (Exception ex) {}
    
    return false;
  }
  

  public static class WriterRef
    extends WeakReference
  {
    WriterRef next;
    WriterRef prev;
    
    public WriterRef(Writer wr)
    {
      super();
    }
    
    int id = ++counter;
    public String toString() { return "WriterRef#" + id + ":" + get(); }
    
    static int counter;
  }
}
