package gnu.kawa.io;

import java.io.Reader;

public class NullReader extends Reader { public NullReader() {}
  
  public static final NullReader nullReader = new NullReader();
  
  public int read(char[] buffer, int offset, int length) { return -1; }
  
  public boolean ready() { return true; }
  
  public void close() {}
}
