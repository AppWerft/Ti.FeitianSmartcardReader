package gnu.kawa.lispexpr;

import gnu.mapping.Procedure;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.Reader;


public class ReaderDispatchMacro
  extends ReaderMisc
{
  Procedure procedure;
  
  public ReaderDispatchMacro(Procedure procedure)
  {
    super(5);
    this.procedure = procedure;
  }
  
  public Procedure getProcedure()
  {
    return procedure;
  }
  

  public Object read(Lexer in, int ch, int count)
    throws IOException, SyntaxException
  {
    Reader reader = in.getPort();
    try
    {
      return procedure.apply3(reader, Char.make(ch), IntNum.make(count));
    }
    catch (IOException ex)
    {
      throw ex;
    }
    catch (SyntaxException ex)
    {
      throw ex;
    }
    catch (Error ex)
    {
      throw ex;
    }
    catch (Throwable ex)
    {
      in.fatal("reader macro '" + procedure + "' threw: " + ex); }
    return null;
  }
}
