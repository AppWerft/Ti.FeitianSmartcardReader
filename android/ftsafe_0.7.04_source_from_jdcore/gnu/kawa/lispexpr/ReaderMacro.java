package gnu.kawa.lispexpr;

import gnu.mapping.Procedure;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.Reader;

public class ReaderMacro extends ReaderMisc
{
  Procedure procedure;
  
  public ReaderMacro(Procedure procedure, boolean nonTerminating)
  {
    super(nonTerminating ? 6 : 5);
    
    this.procedure = procedure;
  }
  
  public ReaderMacro(Procedure procedure)
  {
    super(5);
    this.procedure = procedure;
  }
  
  public boolean isNonTerminating()
  {
    return kind == 6;
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
      return procedure.apply2(reader, Char.make(ch));
    }
    catch (IOException ex)
    {
      throw ex;
    }
    catch (SyntaxException ex)
    {
      throw ex;
    }
    catch (Throwable ex)
    {
      in.fatal("reader macro '" + procedure + "' threw: " + ex); }
    return null;
  }
}
