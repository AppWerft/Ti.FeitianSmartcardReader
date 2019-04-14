package gnu.kawa.functions;

import gnu.expr.Keyword;
import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.BinaryOutPort;
import gnu.kawa.io.FilePath;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.lists.ByteVector;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RunProcess extends gnu.mapping.MethodProc
{
  public static final RunProcess instance = new RunProcess("run-process");
  
  public RunProcess(String name) {
    setName(name);
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.functions.CompileProcess:validateApplyRunProcess");
  }
  
  public void apply(CallContext ctx) throws Throwable
  {
    doit(ctx.getArgs(), consumer);
  }
  
  protected void error(String message) {
    throw new RuntimeException("run-process: " + message);
  }
  
  public static final SimpleSymbol inheritSymbol = Symbol.valueOf("inherit");
  public static final SimpleSymbol pipeSymbol = Symbol.valueOf("pipe");
  public static final SimpleSymbol currentSymbol = Symbol.valueOf("current");
  public static final SimpleSymbol outSymbol = Symbol.valueOf("out");
  
  public void doit(Object[] args, Consumer consumer) throws Throwable {
    ProcessBuilder builder = new ProcessBuilder(new String[0]);
    int nargs = args.length;
    boolean useShell = false;
    boolean returnBlob = true;
    Object inRedirect = null;
    Object outRedirect = null;
    Object errRedirect = null;
    boolean outNeedsClose = false;
    boolean errNeedsClose = false;
    InputStream inputBytes = null;
    boolean directorySet = false;
    Object command = null;
    for (int iarg = 0; iarg < nargs; iarg++) {
      Object arg = args[iarg];
      if ((arg instanceof Keyword)) {
        String key = ((Keyword)arg).getName();
        boolean outSpecifier = key.startsWith("out");
        iarg++; if (iarg >= nargs)
          error("missing keyword value for keyword " + arg);
        Object kval = args[iarg];
        Object newRedirect = null;
        if (key.equals("shell")) {
          useShell = ((Boolean)kval).booleanValue();
        } else if (key.equals("in")) {
          inputBytes = getInputStreamFrom(kval);
        }
        else if ((key.equals("out-to")) || (key.equals("err-to")) || (key.equals("in-from")))
        {

          boolean inSpecifier = key.equals("in-from");
          if (kval == currentSymbol) {
            newRedirect = outSpecifier ? OutPort.outDefault() : inSpecifier ? gnu.kawa.io.InPort.inDefault() : OutPort.errDefault();










          }
          else if (kval == pipeSymbol) {
            newRedirect = kval;
          }
          else if ((kval == inheritSymbol) && (!inSpecifier)) {
            newRedirect = outSpecifier ? OutPort.getSystemOut() : OutPort.getSystemErr();


          }
          else if ((!outSpecifier) && (!inSpecifier) && (kval == outSymbol))
          {



            error("err-to: 'out redirect requires Java 7");
            newRedirect = null;
          }
          else if (inSpecifier ? (!(kval instanceof InputStream)) || (!(kval instanceof Reader)) : ((kval instanceof OutputStream)) || ((kval instanceof Writer)))
          {



            newRedirect = kval;
          } else {
            FilePath fpath = FilePath.coerceToFilePathOrNull(kval);
            if (fpath != null) {
              File file = fpath.toFile();
              



              if (inSpecifier) {
                inputBytes = new FileInputStream(file);
              } else {
                newRedirect = new FileOutputStream(file, false);
                if (outSpecifier) {
                  outNeedsClose = true;
                } else {
                  errNeedsClose = true;
                }
              }
            } else {
              error("unimplemented keyword value for " + arg);
            } }
          if (inSpecifier) {
            inRedirect = newRedirect;
            newRedirect = null;
          }
        }
        else if ((key.equals("out-append-to")) || (key.equals("err-append-to")))
        {
          FilePath fpath = FilePath.coerceToFilePathOrNull(kval);
          if (fpath != null) {
            File file = fpath.toFile();
            



            newRedirect = new FileOutputStream(file, true);
          }
          else {
            error("unimplemented keyword value for " + arg);
          }
        } else if ((key.startsWith("env-")) && (key.length() > 0)) {
          String evar = key.substring(4);
          String evalue = kval.toString();
          builder.environment().put(evar, evalue);
        } else if (key.toUpperCase().equals(key)) {
          String evalue = kval.toString();
          builder.environment().put(key, evalue);
        } else if (key.equals("env")) {
          Map<String, String> env = builder.environment();
          env.clear();
          env.putAll((Map)kval);
        } else if (key.equals("directory")) {
          try {
            directorySet = true;
            if (kval != inheritSymbol) {
              FilePath fpath = FilePath.coerceToFilePathOrNull(kval);
              
              builder.directory(fpath.toFile());
            }
          } catch (Exception ex) {
            throw new IllegalArgumentException("invalid directory");
          }
        } else {
          error("unknown keyword " + arg); }
        if (outSpecifier)
          returnBlob = false;
        if (newRedirect != null)
        {
          if (outSpecifier) {
            outRedirect = newRedirect;
          }
          else {
            errRedirect = newRedirect;
          }
        }
      }
      else if ((inputBytes == null) && (iarg + 2 == nargs)) {
        inputBytes = getInputStreamFrom(arg);
      } else if (command == null) {
        command = arg;
      } else {
        error("multiple command arguments");
      }
    }
    List<String> cmd = null;
    if (!(command instanceof CharSequence))
    {
      if ((command instanceof List)) {
        cmd = new ArrayList();
        for (Object arg : (List)command) {
          if ((arg instanceof CharSequence)) {
            cmd.add(arg.toString());
          } else
            error("element in command sequence is not a string");
        }
        if (cmd.isEmpty())
          command = null;
      } else {
        error("command is neither string nor string sequence"); } }
    if (command == null)
      error("missing command");
    if (useShell) {
      if (cmd != null) {
        StringBuilder sbuf = new StringBuilder((String)cmd.get(0));
        int ncmds = cmd.size();
        for (int i = 1; i < ncmds; i++) {
          sbuf.append(' ');
          sbuf.append((String)cmd.get(i));
        }
        command = sbuf;
      }
      cmd = new ArrayList();
      cmd.add("/bin/sh");
      cmd.add("-c");
      String commands = command.toString();
      tokenize(commands, true, cmd);







    }
    else if (cmd == null) {
      cmd = new ArrayList();
      String commands = command.toString();
      tokenize(commands, false, cmd);
    }
    










    builder.command(cmd);
    if (!directorySet) {
      Path cur = Path.currentPath();
      if (cur != Path.userDirPath) {
        builder.directory(((FilePath)cur).toFile());
      }
    }
    




    if (errRedirect == null) {
      errRedirect = OutPort.errDefault();
    }
    




















    Process proc = builder.start();
    if ((inRedirect instanceof Reader)) {
      if ((inRedirect instanceof BinaryInPort)) {
        inputBytes = ((BinaryInPort)inRedirect).getInputStream();
      } else {
        OutputStreamWriter outs = new OutputStreamWriter(proc.getOutputStream());
        
        copyCharsInThread((Reader)inRedirect, outs, false, true);
      }
    }
    if ((inRedirect instanceof InputStream)) {
      inputBytes = (InputStream)inRedirect;
    }
    if (inputBytes != null) {
      InputStream inb = inputBytes;
      copyStreamInThread(inputBytes, proc.getOutputStream(), true);
    }
    if ((outRedirect instanceof OutputStream)) {
      copyStreamInThread(proc.getInputStream(), (OutputStream)outRedirect, outNeedsClose);
    }
    else if ((outRedirect instanceof Writer)) {
      copyWriterInThread(proc.getInputStream(), (Writer)outRedirect, outNeedsClose);
    }
    
    if ((errRedirect instanceof OutputStream)) {
      copyStreamInThread(proc.getErrorStream(), (OutputStream)errRedirect, errNeedsClose);
    }
    else if ((errRedirect instanceof Writer)) {
      copyWriterInThread(proc.getErrorStream(), (Writer)errRedirect, errNeedsClose);
    }
    
    if (returnBlob) {
      LProcess lproc = new LProcess(proc);
      OutPort pout = OutPort.getPassThroughOutPort(consumer);
      if (pout != null) {
        InputStream in = proc.getInputStream();
        if ((pout instanceof BinaryOutPort)) {
          BinaryOutPort bout = (BinaryOutPort)pout;
          byte[] buffer = new byte['ࠀ'];
          for (;;) {
            int cnt = in.read(buffer, 0, buffer.length);
            if (cnt < 0)
              break;
            bout.writeBytes(buffer, 0, cnt);
          }
          bout.flush();
          in.close();
        }
        else
        {
          Reader inr = new InputStreamReader(in);
          char[] buffer = new char['ࠀ'];
          for (;;) {
            int cnt = inr.read(buffer, 0, buffer.length);
            if (cnt < 0)
              break;
            pout.write(buffer, 0, cnt);
          }
          pout.flush();
          inr.close();
        }
      }
      else {
        consumer.writeObject(lproc);
      }
    } else {
      consumer.writeObject(proc);
    }
  }
  




  public void tokenize(String str, boolean useShell, List<String> arr)
  {
    StringBuffer sbuf = new StringBuffer(100);
    









    int state = -1;
    int len = str.length();
    int inGroup = 0;
    int inSubstitution = 0;
    for (int i = 0; i < len; i++) {
      char ch = str.charAt(i);
      if (ch == 61952) {
        if (inGroup > 0)
          sbuf.append(ch);
        inGroup++;

      }
      else if (ch == 61953) {
        inGroup--;
        if (inGroup > 0) {
          sbuf.append(ch);
        }
      }
      else if (ch == 61954) {
        if (inSubstitution > 0)
          sbuf.append(ch);
        inSubstitution++;

      }
      else if (ch == 61955) {
        inSubstitution--;
        if (inSubstitution > 0) {
          sbuf.append(ch);
        } else {
          if (state == 1) {
            sbuf.append('\'');
            state = -1;
          }
          if ((inGroup > 0) && (i + 1 < len) && (str.charAt(i + 1) == 61954))
          {
            if ((useShell) || (state == 34) || (state == 39)) {
              sbuf.append(' ');
            } else {
              arr.add(sbuf.toString());
              sbuf.setLength(0);
            }
          }
        }
      }
      else
      {
        if ((ch == '\n') && (inSubstitution > 0) && (inGroup == 0))
        {
          int nlCount = 1;
          for (;;) {
            ch = str.charAt(i + nlCount);
            if (ch != '\n')
              break;
            nlCount++;
          }
          i += nlCount - 1;
          if (ch == 61955) {
            continue;
          }
          
          ch = '\n';
          if ((state == 34) && (inGroup == 0)) {
            for (;;) {
              nlCount--; if (nlCount < 0) break;
              if (useShell) {
                sbuf.append("\" \"");
              } else {
                arr.add(sbuf.toString());
                sbuf.setLength(0);
              }
            }
          }
          if (state <= 1)
          {
            if (useShell)
              ch = ' ';
          } else {
            for (;;) { nlCount--; if (nlCount <= 0) break;
              sbuf.append('\n');
            }
          }
        }
        if (useShell) {
          if (inSubstitution > 0)
          {
            if (state == 34) {
              if ((ch == '$') || (ch == '\\'))
                sbuf.append('\\');
            } else if (ch == '\'') {
              if (state == -1) {
                sbuf.append("\\'");
              } else
                sbuf.append("'\\'");
            } else if ((state <= 1) && (inGroup == 0) && ((ch == ' ') || (ch == '\t') || (ch == '\n') || (ch == '\r')))
            {

              if (state == 1)
                sbuf.append('\'');
              state = -1;
            } else if (state == -1) {
              sbuf.append('\'');
              state = 1;
            }
            
          }
          else if ((ch == '\\') && (state != 39) && (i + 1 < len)) {
            sbuf.append(ch);
            i++;
            ch = str.charAt(i);
          } else if (state < 0) {
            if ((ch == '"') || (ch == '\'')) {
              state = ch;
            }
          } else if (ch == state) {
            state = -1;
          }
        }
        else
        {
          if ((state <= 0) && (inGroup == 0) && ((ch == ' ') || (ch == '\t') || (ch == '\n') || (ch == '\r')))
          {

            if ((sbuf.length() <= 0) && (state != 0)) continue;
            arr.add(sbuf.toString());
            sbuf.setLength(0);
            state = -1; continue;
          }
          
          if (inSubstitution <= 0)
          {
            if (state <= 0) {
              if ((ch == '\\') || (ch == '\'') || (ch == '"')) {
                state = ch;
                continue;
              }
            } else if (state == 92) {
              state = 0;
            } else if (ch == state) {
              state = 0;
              continue;
            } }
        }
        sbuf.append(ch);
      } }
    if ((sbuf.length() > 0) || (state >= 0) || (useShell))
      arr.add(sbuf.toString());
    if ((!useShell) && ((state > 0) || (inSubstitution > 0) || (inGroup > 0)))
      error("bad quotes");
  }
  
  public static InputStream getInputStreamFrom(Object val) {
    if ((val instanceof ByteVector))
      return ((ByteVector)val).getInputStream();
    if ((val instanceof Process))
      return ((Process)val).getInputStream();
    if ((val instanceof byte[]))
      return new ByteArrayInputStream((byte[])val);
    if ((val instanceof CharSequence))
    {

      return new ByteArrayInputStream(((CharSequence)val).toString().getBytes()); }
    throw new ClassCastException("invalid input");
  }
  





  static void copyStreamInThread(InputStream in, final OutputStream out, final boolean closeOut)
  {
    Thread thread = new Thread()
    {
      public void run() {
        try {
          RunProcess.copyStream(val$in, out, closeOut);
        }
        catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    };
    thread.start();
  }
  





  void copyWriterInThread(InputStream in, Writer out, boolean closeOut)
    throws IOException
  {
    if ((out instanceof BinaryOutPort)) {
      BinaryOutPort bout = (BinaryOutPort)out;
      copyStreamInThread(in, bout.getOutputStream(), closeOut);
    } else {
      out.flush();
      copyCharsInThread(new InputStreamReader(in), out, true, closeOut);
    }
  }
  


  static void copyCharsInThread(Reader in, final Writer out, boolean closeIn, final boolean closeOut)
    throws IOException
  {
    new Thread() {
      public void run() {
        try {
          char[] buffer = new char['ࠀ'];
          try
          {
            for (;;) {
              int cnt = val$in.read(buffer, 0, buffer.length);
              if (cnt < 0)
                break;
              out.write(buffer, 0, cnt);
            }
          } catch (IOException ex) { if (!"Broken pipe".equals(ex.getMessage()))
            {

              throw ex;
            }
            
            out.flush();
          } finally {
            val$in.close();
            if (closeOut) {
              out.close();
            }
          }
          

          return;
        }
        catch (IOException ex)
        {
          throw new RuntimeException(ex);
        }
      }
    }.start();
  }
  



  public static void copyStream(InputStream in, OutputStream out, boolean closeOut)
    throws IOException
  {
    byte[] buffer = new byte['ࠀ'];
    try {
      for (;;) {
        int cnt = in.read(buffer, 0, buffer.length);
        if (cnt < 0)
          break;
        try {
          out.write(buffer, 0, cnt);
        } catch (IOException ex) {
          if (!"Broken pipe".equals(ex.getMessage())) break label53; }
        break;
        label53:
        throw ex;
      }
      
      out.flush();
    } finally {
      in.close();
      if (closeOut) {
        out.close();
      }
    }
  }
}
