package gnu.kawa.lispexpr;

import gnu.bytecode.Type;
import gnu.kawa.io.InPort;
import gnu.kawa.reflect.Invoke;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderDispatchSyntaxQuote extends ReadTableEntry
{
  public ReaderDispatchSyntaxQuote() {}
  
  static Symbol makeSymbol(String name)
  {
    return Namespace.EmptyNamespace.getSymbol(name);
  }
  
  static Symbol syntaxSymbol = makeSymbol("syntax");
  static Symbol quasisyntaxSymbol = makeSymbol("quasisyntax");
  static Symbol unsyntaxSymbol = makeSymbol("unsyntax");
  static Symbol unsyntaxSplicingSymbol = makeSymbol("unsyntax-splicing");
  
  public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException
  {
    LispReader reader = (LispReader)in;
    switch (ch) {
    case 44: 
      if (inQuasiSyntax) {
        return ReaderQuote.read(reader, unsyntaxSymbol, '@', unsyntaxSplicingSymbol);
      }
      
      return readNamedConstructor(reader);
    
    case 39: 
      return ReaderQuote.read(reader, syntaxSymbol, '\000', null);
    case 96: 
      boolean save = inQuasiSyntax;
      inQuasiSyntax = true;
      try {
        return ReaderQuote.read(reader, quasisyntaxSymbol, '\000', null);
      } finally {
        inQuasiSyntax = save;
      }
    }
    return null;
  }
  
  public static Object readNamedConstructor(LispReader reader)
    throws IOException, SyntaxException
  {
    InPort port = reader.getPort();
    
    Object list;
    int length;
    if ((port.peek() == 40) && ((length = gnu.lists.LList.listLength(list = reader.readObject(), false)) > 0) && ((((Pair)list).getCar() instanceof Symbol)))
    {



      String name = ((Pair)list).getCar().toString();
      Object proc = ReadTable.getCurrent().getReaderCtor(name);
      if (proc == null) {
        reader.error("unknown reader constructor " + name);
      } else if ((!(proc instanceof Procedure)) && (!(proc instanceof Type))) {
        reader.error("reader constructor must be procedure or type name");
      } else {
        length--;
        int parg = (proc instanceof Type) ? 1 : 0;
        Object[] args = new Object[parg + length];
        Object argList = ((Pair)list).getCdr();
        for (int i = 0; i < length; i++) {
          Pair pair = (Pair)argList;
          args[(parg + i)] = pair.getCar();
          argList = pair.getCdr();
        }
        try {
          if (parg > 0) {
            args[0] = proc;
            return Invoke.make.applyN(args);
          }
          return ((Procedure)proc).applyN(args);
        }
        catch (Error ex) {
          throw ex;
        }
        catch (Throwable ex) {
          reader.error("caught " + ex + " applying reader constructor " + name);
        }
      }
    }
    else {
      reader.error("a non-empty list starting with a symbol must follow #,"); }
    return Boolean.FALSE;
  }
}
