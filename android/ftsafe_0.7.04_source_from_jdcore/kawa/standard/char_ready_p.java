package kawa.standard;

import java.io.IOException;

public class char_ready_p {
  public char_ready_p() {}
  
  public static boolean ready(Object arg1) { try { if ((arg1 instanceof java.io.InputStream))
        return ((java.io.InputStream)arg1).available() > 0;
      if ((arg1 instanceof java.io.Reader)) {
        return ((java.io.Reader)arg1).ready();
      }
      throw new ClassCastException("invalid argument to char-ready?");
    }
    catch (IOException ex) {}
    
    return false;
  }
}
