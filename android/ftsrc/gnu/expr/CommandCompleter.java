package gnu.expr;

import java.util.List;








public class CommandCompleter
  extends RuntimeException
{
  public static final char COMPLETE_REQUEST = '';
  int prefixLength;
  public String word;
  public int wordCursor;
  public List<String> candidates;
  Compilation comp;
  
  public CommandCompleter(int prefixLength, List<String> candidates, String word, int wordCursor, Compilation comp)
  {
    this.prefixLength = prefixLength;
    this.candidates = candidates;
    this.word = word;
    this.wordCursor = wordCursor;
    this.comp = comp;
  }
  
  public Throwable fillInStackTrace() {
    return this;
  }
  




































  public Compilation getCompilation()
  {
    return comp;
  }
}
