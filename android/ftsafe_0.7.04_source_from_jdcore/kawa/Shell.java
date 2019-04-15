package kawa;

import gnu.expr.Compilation;
import gnu.expr.CompiledModule;
import gnu.expr.Language;
import gnu.expr.ModuleManager;
import gnu.kawa.format.AbstractFormat;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.TtyInPort;
import gnu.kawa.util.Signals;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.WrongArguments;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class Shell
{
  public static ThreadLocal currentLoadPath = new ThreadLocal();
  




  private static Class[] noClasses = new Class[0];
  private static Class[] boolClasses = { Boolean.TYPE };
  private static Class[] lispPushClasses = { OutPort.class, Character.TYPE, Boolean.TYPE };
  private static Class[] xmlPrinterClasses = { Consumer.class, Object.class };
  private static Class[] httpPrinterClasses = { OutPort.class };
  private static Object consumerArg = "(consumer)";
  








  static Object[][] formats = { { "scheme", "gnu.kawa.functions.DisplayFormat", "getSchemeFormat", boolClasses, Boolean.FALSE }, { "readable-scheme", "gnu.kawa.functions.DisplayFormat", "getSchemeFormat", boolClasses, Boolean.TRUE }, { "elisp", "gnu.kawa.functions.DisplayFormat", "getEmacsLispFormat", boolClasses, Boolean.FALSE }, { "readable-elisp", "gnu.kawa.functions.DisplayFormat", "getEmacsLispFormat", boolClasses, Boolean.TRUE }, { "clisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", boolClasses, Boolean.FALSE }, { "readable-clisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", boolClasses, Boolean.TRUE }, { "commonlisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", boolClasses, Boolean.FALSE }, { "readable-commonlisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", boolClasses, Boolean.TRUE }, { "xml", "gnu.xml.XMLPrinter", "make", xmlPrinterClasses, consumerArg, null }, { "html", "gnu.xml.XMLPrinter", "make", xmlPrinterClasses, consumerArg, "html" }, { "xhtml", "gnu.xml.XMLPrinter", "make", xmlPrinterClasses, consumerArg, "xhtml" }, { "cgi", "gnu.kawa.xml.HttpPrinter", "make", httpPrinterClasses, consumerArg }, { "ignore", "gnu.lists.VoidConsumer", "make", { Consumer.class }, consumerArg }, { null } };
  








  public static String defaultFormatName;
  








  public static Object[] defaultFormatInfo;
  








  public static Method defaultFormatMethod;
  








  public Shell() {}
  








  public static void setDefaultFormat(String name)
  {
    name = name.intern();
    defaultFormatName = name;
    for (int i = 0;; i++)
    {
      Object[] info = formats[i];
      Object iname = info[0];
      if (iname == null)
      {
        System.err.println("kawa: unknown output format '" + name + "'");
        System.exit(-1);
      }
      else if (iname == name)
      {
        defaultFormatInfo = info;
        try
        {
          Class formatClass = Class.forName((String)info[1]);
          defaultFormatMethod = formatClass.getMethod((String)info[2], (Class[])info[3]);

        }
        catch (Throwable ex)
        {

          System.err.println("kawa:  caught " + ex + " while looking for format '" + name + "'");
          System.exit(-1);
        }
      }
    }
    
    if (!defaultFormatInfo[1].equals("gnu.lists.VoidConsumer")) {
      gnu.expr.ModuleBody.setMainPrintValues(true);
    }
  }
  



  public static Consumer getOutputConsumer(OutPort out)
  {
    Object[] info = defaultFormatInfo;
    if (out == null)
      return gnu.lists.VoidConsumer.getInstance();
    if (info == null) {
      return Language.getDefaultLanguage().getOutputConsumer(out);
    }
    try {
      Object[] args = new Object[info.length - 4];
      System.arraycopy(info, 4, args, 0, args.length);
      boolean useConsumer = args[0] == consumerArg;
      int i = args.length; for (;;) { i--; if (i < 0) break;
        if (args[i] == consumerArg)
          args[i] = out;
      }
      Object format = defaultFormatMethod.invoke(null, args);
      if ((format instanceof AbstractFormat)) {
        return ((AbstractFormat)format).makeConsumer(out);
      }
      return (Consumer)format;
    }
    catch (Exception ex)
    {
      throw new RuntimeException("cannot get output-format '" + defaultFormatName + "' - caught " + ex);
    }
  }
  

  public static boolean run(Language language, Environment env)
  {
    InPort inp = InPort.inDefault();
    SourceMessages messages = new SourceMessages();
    OutPort perr;
    OutPort perr; if ((inp instanceof TtyInPort))
    {
      ((TtyInPort)inp).setPrompter(defaultPrompter);
      perr = OutPort.errDefault();
    }
    else {
      perr = null;
    }
    Throwable ex = run(language, env, inp, OutPort.outDefault(), perr, messages);
    
    if (ex == null)
      return true;
    printError(ex, messages, OutPort.errDefault());
    return false;
  }
  


  public static Throwable run(Language language, Environment env, InPort inp, OutPort pout, OutPort perr, SourceMessages messages)
  {
    Consumer out = getOutputConsumer(pout);
    return run(language, env, inp, out, perr, null, messages);
  }
  


  public static boolean run(Language language, Environment env, InPort inp, Consumer out, OutPort perr, URL url)
  {
    SourceMessages messages = new SourceMessages();
    Throwable ex = run(language, env, inp, out, perr, url, messages);
    if (ex != null)
      printError(ex, messages, perr);
    return ex == null;
  }
  


  public static Throwable run(Language language, Environment env, InPort inp, Consumer out, OutPort perr, URL url, SourceMessages messages)
  {
    Language saveLanguage = Language.setSaveCurrent(language);
    Lexer lexer = language.getLexer(inp, messages);
    boolean interactive = inp instanceof TtyInPort;
    lexer.setInteractive(interactive);
    CallContext ctx = CallContext.getInstance();
    Consumer saveConsumer = null;
    if (out != null)
    {
      saveConsumer = consumer;
      consumer = out;
    }
    try
    {
      Thread thread = Thread.currentThread();
      ClassLoader parentLoader = thread.getContextClassLoader();
      


      if (!(parentLoader instanceof gnu.bytecode.ArrayClassLoader)) {
        thread.setContextClassLoader(new gnu.bytecode.ArrayClassLoader(parentLoader));
      }
    }
    catch (SecurityException ex) {}
    

    Method parserMethod = getJLineParserMethod(inp);
    Environment saveEnv = Environment.setSaveCurrent(env);
    try
    {
      SigIntHandler sigIntHandler = null;
      if (interactive) {
        sigIntHandler = new SigIntHandler();
        sigIntHandler = sigIntHandler;
      }
      for (;;)
      {
        Object oldIntHandler = null;
        int opts = 135;
        
        try
        {
          if (interactive) {
            oldIntHandler = Signals.register("INT", sigIntHandler);
          }
          Compilation comp;
          if (parserMethod != null) {
            try {
              comp = (Compilation)parserMethod.invoke(null, new Object[] { language, lexer });
            } catch (InvocationTargetException ex) {
              throw ex.getTargetException();
            }
          } else {
            comp = language.parse(lexer, opts, null);
          }
          
          if (interactive) {
            boolean sawError = messages.checkErrors(perr, 20);
            perr.flush();
          } else {
            if (messages.seenErrors()) {
              throw new SyntaxException(messages);
            }
            sawError = false; }
          if (comp == null)
          {

































            if (oldIntHandler == null) break;
            Signals.unregister("INT", oldIntHandler); break;
          }
          if (sawError) {
            lexical.pop(mainLambda);
            






























            if (oldIntHandler != null) {
              Signals.unregister("INT", oldIntHandler);
            }
          }
          else
          {
            if (!gnu.expr.ModuleExp.evalModule(env, ctx, comp, url, perr))
              throw new SyntaxException(messages);
            if ((out instanceof Writer))
              ((Writer)out).flush();
            if (inp.eofSeen())
            {























              if (oldIntHandler == null) break;
              Signals.unregister("INT", oldIntHandler); break;
            }
          }
        }
        catch (ThreadDeath e)
        {
          if (!interactive)
            throw e;
          if ((sigIntHandler == null) || (trace == null)) {
            e.printStackTrace(perr);
          } else
            trace.printStackTrace(perr);
          Thread.interrupted();
        }
        catch (Error e)
        {
          throw e;
        }
        catch (Throwable e) {
          boolean sawError;
          if (!interactive) {
            sawError = e;
            



            if (oldIntHandler != null) {
              Signals.unregister("INT", oldIntHandler);
            }
            






            return sawError;
          }
          printError(e, messages, perr);
        }
        finally
        {
          if (oldIntHandler != null) {
            Signals.unregister("INT", oldIntHandler);
          }
        }
      }
    }
    finally {
      Environment.restoreCurrent(saveEnv);
      if (out != null)
        consumer = saveConsumer;
      Language.restoreCurrent(saveLanguage);
    }
    return null;
  }
  
  static Method getJLineParserMethod(InPort in) {
    Class cls = in.getClass();
    try {
      if (cls.getName().equals("gnu.kawa.io.JLineInPort")) {
        cls = Class.forName("gnu.kawa.io.JLineInPort$KawaParsedLine");
        return cls.getDeclaredMethod("parse", new Class[] { Language.class, Lexer.class });
      }
    }
    catch (Throwable ex) {}
    
    return null;
  }
  

  public static void printError(Throwable ex, SourceMessages messages, OutPort perr)
  {
    if ((ex instanceof WrongArguments))
    {
      WrongArguments e = (WrongArguments)ex;
      messages.printAll(perr, 20);
      if (usage != null)
        perr.println("usage: " + usage);
      e.printStackTrace(perr);
    }
    else
    {
      SyntaxException se;
      









      if (((ex instanceof SyntaxException)) && ((se = (SyntaxException)ex).getMessages() == messages))
      {

        se.printAll(perr, 20);
        se.clear();
      }
      else
      {
        messages.printAll(perr, 20);
        ex.printStackTrace(perr);
      }
    }
    perr.flush();
  }
  
  public static final CompiledModule checkCompiledZip(InputStream fs, Path path, Environment env, Language language)
    throws IOException
  {
    try
    {
      fs.mark(5);
      boolean isZip = (fs.read() == 80) && (fs.read() == 75) && (fs.read() == 3) && (fs.read() == 4);
      
      fs.reset();
      if (!isZip) {
        return null;
      }
    }
    catch (IOException ex) {
      return null;
    }
    fs.close();
    Environment orig_env = Environment.getCurrent();
    String name = path.toString();
    try
    {
      if (env != orig_env)
        Environment.setCurrent(env);
      File zfile = path.toFile();
      if (zfile == null)
        throw new RuntimeException("load: " + name + " - not a file path");
      if (!zfile.exists())
        throw new RuntimeException("load: " + name + " - not found");
      if (!zfile.canRead())
        throw new RuntimeException("load: " + name + " - not readable");
      gnu.bytecode.ZipLoader loader = new gnu.bytecode.ZipLoader(name);
      Class clas = loader.loadAllClasses();
      return CompiledModule.make(clas, language);
    }
    catch (IOException ex)
    {
      throw new gnu.mapping.WrappedException("load: " + name + " - " + ex.toString(), ex);
    }
    finally
    {
      if (env != orig_env)
        Environment.setCurrent(orig_env);
    }
  }
  
  static InPort openFile(InputStream fs, Path path) throws IOException {
    Object conv = Environment.user().get("port-char-encoding");
    
    if ((conv == null) || (conv == Boolean.TRUE)) {
      return gnu.kawa.io.BinaryInPort.openHeuristicFile(fs, path);
    }
    return InPort.openFile(fs, path, conv);
  }
  















  public static boolean runFileOrClass(String fname, boolean lineByLine, int skipLines)
  {
    Language language = Language.getDefaultLanguage();
    try {
      InputStream fs;
      Path path;
      InputStream fs;
      if (fname.equals("-"))
      {
        Path path = Path.valueOf("/dev/stdin");
        fs = System.in;
      }
      else
      {
        path = Path.valueOf(fname);
        fs = path.openInputStream();
      }
      try
      {
        Environment env = Environment.getCurrent();
        return runFile(fs, path, env, lineByLine, skipLines);
      }
      catch (Error e)
      {
        throw e;
      }
      catch (Throwable e)
      {
        e.printStackTrace(System.err);
        return false;
      }
      














      Class clas;
      













      return false;
    }
    catch (Error e)
    {
      throw e;

    }
    catch (Throwable e)
    {
      try
      {
        clas = Class.forName(fname);
      }
      catch (Exception ex)
      {
        System.err.println("Cannot read file " + e.getMessage());
        return false;
      }
      try
      {
        runClass(clas, Environment.getCurrent());
        return true;
      }
      catch (Error ex)
      {
        throw ex;

      }
      catch (Throwable ex)
      {
        ex.printStackTrace();
      }
    }
  }
  
  public static void runClass(Class clas, Environment env) throws Throwable
  {
    CompiledModule cmodule = CompiledModule.make(clas, Language.getDefaultLanguage());
    cmodule.evalModule(env, OutPort.outDefault());
  }
  

  public static final boolean runFile(InputStream fs, Path path, Environment env, boolean lineByLine, int skipLines)
    throws Throwable
  {
    if ((!(fs instanceof java.io.BufferedInputStream)) && (!(fs instanceof gnu.kawa.io.NBufferedInputStream)))
    {
      fs = new gnu.kawa.io.NBufferedInputStream(fs); }
    Language language = Language.getDefaultLanguage();
    Path savePath = (Path)currentLoadPath.get();
    try {
      currentLoadPath.set(path);
      CompiledModule cmodule = checkCompiledZip(fs, path, env, language);
      if (cmodule == null) {
        InPort src = openFile(fs, path);
        for (;;) { skipLines--; if (skipLines < 0) break;
          src.skipRestOfLine();
        }
        try { SourceMessages messages = new SourceMessages();
          URL url = path.toURL();
          OutPort perr = OutPort.errDefault();
          boolean print; if (lineByLine) {
            print = gnu.expr.ModuleBody.getMainPrintValues();
            Consumer out = print ? getOutputConsumer(OutPort.outDefault()) : new gnu.lists.VoidConsumer();
            

            Throwable ex = run(language, env, src, out, perr, url, messages);
            
            if (((ex instanceof SyntaxException)) && (((SyntaxException)ex).getMessages() == messages))
            {
              messages.printAll(perr, 20);
              perr.flush();
              boolean bool1 = false;
              









              src.close();
              




              return bool1;
            }
            if (ex != null)
              throw ex;
          } else {
            cmodule = compileSource(src, env, url, language, messages, perr);
            
            if (cmodule == null) {
              print = false;
              

              src.close();
              




              return print;
            }
          }
        }
        finally
        {
          src.close();
        }
      }
      if (cmodule != null)
        cmodule.evalModule(env, OutPort.outDefault());
    } finally {
      currentLoadPath.set(savePath);
    }
    return true;
  }
  




  static CompiledModule compileSource(InPort port, Environment env, URL url, Language language, SourceMessages messages, OutPort perr)
    throws SyntaxException, IOException
  {
    ModuleManager manager = ModuleManager.getInstance();
    gnu.expr.ModuleInfo minfo = manager.findWithSourcePath(port.getName());
    Lexer lexer = language.getLexer(port, messages);
    try {
      Compilation comp = language.parse(lexer, 1, minfo);
      
      CallContext ctx = CallContext.getInstance();
      values = gnu.mapping.Values.noArgs;
      Object inst = gnu.expr.ModuleExp.evalModule1(env, comp, url, null);
      messages.printAll(perr, 20);
      perr.flush();
      if ((inst == null) || (messages.seenErrors()))
        return null;
      return new CompiledModule(comp.getModule(), inst, language);
    }
    catch (Error ex) {
      throw ex;
    }
    catch (Throwable ex) {
      if ((!(ex instanceof SyntaxException)) || (((SyntaxException)ex).getMessages() != messages))
      {
        lexer.error('e', "unexpected exception while compiling: " + ex);
        messages.printAll(perr, 20);
        ex.printStackTrace(perr);
      }
      else {
        messages.printAll(perr, 20); } }
    return null;
  }
  

  public static final gnu.mapping.Procedure1 defaultPrompter = new Prompter();
  
  static class Prompter extends gnu.mapping.Procedure1 { Prompter() {}
    public Object apply1(Object arg) { return ((TtyInPort)arg).defaultPrompt(); }
  }
  
  static class SigIntHandler implements Runnable {
    public Thread thread;
    public Error trace;
    
    public SigIntHandler(Thread thread) { this.thread = thread; }
    public SigIntHandler() { thread = Thread.currentThread(); }
    
    public void run() {
      Error ex = new Error("user interrupt of " + thread);
      ex.setStackTrace(thread.getStackTrace());
      trace = ex;
      thread.stop();
    }
  }
}
