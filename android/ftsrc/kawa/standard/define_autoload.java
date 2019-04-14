package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.ScopeExp;
import gnu.kawa.lispexpr.LispReader;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.io.File;
import kawa.lang.Translator;

public class define_autoload extends kawa.lang.Syntax
{
  public static final define_autoload define_autoload = new define_autoload("define-autoload", false);
  
  public static final define_autoload define_autoloads_from_file = new define_autoload("define-autoloads-from-file", true);
  
  boolean fromFile;
  

  public define_autoload(String name, boolean fromFile)
  {
    super(name);
    this.fromFile = fromFile;
  }
  

  public boolean scanForDefinitions(Pair st, ScopeExp defs, Translator tr)
  {
    if (!(st.getCdr() instanceof Pair))
      return super.scanForDefinitions(st, defs, tr);
    Pair p = (Pair)st.getCdr();
    if (fromFile)
    {



      while ((p.getCar() instanceof CharSequence))
      {




        if (!scanFile(p.getCar().toString(), defs, tr))
          return false;
        Object rest = p.getCdr();
        if (rest == gnu.lists.LList.Empty)
          return true;
        if (!(rest instanceof Pair))
          break;
        p = (Pair)p.getCdr();
      }
      tr.syntaxError("invalid syntax for define-autoloads-from-file");
      return false;
    }
    Object names = p.getCar();
    Object filename = null;
    if ((p.getCdr() instanceof Pair))
    {
      p = (Pair)p.getCdr();
      filename = p.getCar();
      return process(names, filename, defs, tr);
    }
    tr.syntaxError("invalid syntax for define-autoload");
    return false;
  }
  
  public boolean scanFile(String filespec, ScopeExp defs, Translator tr)
  {
    if (filespec.endsWith(".el")) {}
    
    File file = new File(filespec);
    if (!file.isAbsolute())
      file = new File(new File(tr.getFileName()).getParent(), filespec);
    String filename = file.getPath();
    int dot = filename.lastIndexOf('.');
    
    if (dot >= 0)
    {
      String extension = filename.substring(dot);
      Language language = Language.getInstance(extension);
      if (language == null)
      {
        tr.syntaxError("unknown extension for " + filename);
        return true;
      }
      


















      String prefix = classPrefix;
      int extlen = extension.length();
      int speclen = filespec.length();
      String cname = filespec.substring(0, speclen - extlen);
      while (cname.startsWith("../"))
      {
        int i = prefix.lastIndexOf('.', prefix.length() - 2);
        if (i < 0)
        {
          tr.syntaxError("cannot use relative filename \"" + filespec + "\" with simple prefix \"" + prefix + "\"");
          
          return false;
        }
        prefix = prefix.substring(0, i + 1);
        cname = cname.substring(3);
      }
      String classname = (prefix + cname).replace('/', '.');
      
      try
      {
        gnu.kawa.io.InPort port = gnu.kawa.io.InPort.openFile(filename);
        gnu.text.Lexer lexer = language.getLexer(port, tr.getMessages());
        findAutoloadComments((LispReader)lexer, classname, defs, tr);
      }
      catch (Exception ex)
      {
        tr.syntaxError("error reading " + filename + ": " + ex);
        return true;
      }
    }
    return true;
  }
  

  public static void findAutoloadComments(LispReader in, String filename, ScopeExp defs, Translator tr)
    throws java.io.IOException, gnu.text.SyntaxException
  {
    boolean lineStart = true;
    String magic = ";;;###autoload";
    int magicLength = magic.length();
    
    for (;;)
    {
      int ch = in.peek();
      if (ch < 0)
        return;
      if ((ch == 10) || (ch == 13))
      {
        in.read();
        lineStart = true;
      }
      else {
        if ((lineStart) && (ch == 59))
        {
          int i = 0;
          for (;;)
          {
            if (i == magicLength)
              break label137;
            ch = in.read();
            if (ch < 0)
              return;
            if ((ch == 10) || (ch == 13))
            {
              lineStart = true;
              break;
            }
            if ((i >= 0) && (ch != magic.charAt(i++)))
            {
              i = -1; } }
          label137:
          if (i > 0)
          {
            Object form = in.readObject();
            if ((form instanceof Pair))
            {
              Pair pair = (Pair)form;
              Object value = null;
              String name = null;
              Object car = pair.getCar();
              String command = (car instanceof Symbol) ? ((Symbol)car).getName() : (car instanceof String) ? car.toString() : null;
              


              if (command == "defun")
              {
                name = ((Pair)pair.getCdr()).getCar().toString();
                value = new kawa.lang.AutoloadProcedure(name, filename, tr.getLanguage());
              }
              else
              {
                tr.error('w', "unsupported ;;;###autoload followed by: " + pair.getCar());
              }
              if (value != null)
              {
                Declaration decl = defs.getDefine(name, tr);
                Expression ex = new gnu.expr.QuoteExp(value);
                decl.setFlag(16384L);
                decl.noteValue(ex);
              }
            }
            lineStart = false;
            continue;
          }
        }
        lineStart = false;
        in.skip();
        if (ch == 35)
        {
          if (in.peek() == 124)
          {
            in.skip();
            in.readNestedComment('#', '|', '|', '#');
            continue;
          }
        }
        if (!Character.isWhitespace((char)ch))
        {


          Object skipped = in.readObject(ch);
          if (skipped == gnu.lists.Sequence.eofValue) {
            return;
          }
        }
      }
    }
  }
  
  public static boolean process(Object names, Object filename, ScopeExp defs, Translator tr) {
    if ((names instanceof Pair))
    {
      Pair p = (Pair)names;
      return (process(p.getCar(), filename, defs, tr)) && (process(p.getCdr(), filename, defs, tr));
    }
    
    if (names == gnu.lists.LList.Empty) {
      return true;
    }
    





















    if (((names instanceof String)) || ((names instanceof Symbol)))
    {
      String name = names.toString();
      Declaration decl = defs.getDefine(name, tr);
      String fn; int len; if (((filename instanceof gnu.mapping.SimpleSymbol)) && ((len = (fn = filename.toString()).length()) > 2) && (fn.charAt(0) == '<') && (fn.charAt(len - 1) == '>'))
      {

        filename = fn.substring(1, len - 1); }
      Object value = new kawa.lang.AutoloadProcedure(name, filename.toString(), tr.getLanguage());
      
      Expression ex = new gnu.expr.QuoteExp(value);
      decl.setFlag(16384L);
      decl.noteValue(ex);
      return true;
    }
    return false;
  }
  
  public Expression rewriteForm(Pair form, Translator tr)
  {
    return null;
  }
}
