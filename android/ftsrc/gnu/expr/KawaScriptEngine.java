package gnu.expr;

import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.mapping.Environment;
import gnu.text.SourceError;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.Reader;
import javax.script.ScriptContext;
import javax.script.ScriptException;

public class KawaScriptEngine extends javax.script.AbstractScriptEngine implements javax.script.Compilable
{
  AbstractScriptEngineFactory factory;
  
  public KawaScriptEngine(AbstractScriptEngineFactory factory)
  {
    this.factory = factory;
    context.setBindings(createBindings(), 100);
    context.setReader(InPort.inDefault());
    context.setWriter(OutPort.outDefault());
    context.setErrorWriter(OutPort.errDefault());
  }
  
  public AbstractScriptEngineFactory getFactory()
  {
    return factory;
  }
  
  public javax.script.Bindings createBindings()
  {
    gnu.mapping.SimpleEnvironment env = new gnu.mapping.SimpleEnvironment();
    javax.script.Bindings bindings = new KawaScriptBindings(env);
    return bindings;
  }
  
  public Object eval(Reader in, ScriptContext context)
    throws ScriptException
  {
    return eval((in instanceof InPort) ? (InPort)in : new InPort(in), context);
  }
  
  public Object eval(String string, ScriptContext context)
    throws ScriptException
  {
    return eval(new CharArrayInPort(string), context);
  }
  
  public Object eval(InPort in, ScriptContext context)
    throws ScriptException
  {
    KawaCompiledScript compiled = compile(in, context);
    return compiled.eval(context);
  }
  
  public KawaCompiledScript compile(String string)
    throws ScriptException
  {
    return compile(new CharArrayInPort(string), getContext());
  }
  
  public KawaCompiledScript compile(Reader in)
    throws ScriptException
  {
    return compile((in instanceof InPort) ? (InPort)in : new InPort(in), getContext());
  }
  
  public KawaCompiledScript compile(InPort port, ScriptContext context)
    throws ScriptException
  {
    SourceMessages messages = new SourceMessages();
    try
    {
      return compile(port, context, messages);
    }
    catch (SyntaxException ex)
    {
      messages = ex.getMessages();
      SourceError err = messages.getErrors();
      if (messages.seenErrors())
      {
        while ((severity == 'w') && (next != null))
          err = next;
      }
      throw new ScriptException(message, filename, line, column);

    }
    catch (Exception ex)
    {
      throw new ScriptException(ex);
    }
  }
  
  public KawaCompiledScript compile(InPort port, ScriptContext context, SourceMessages messages)
    throws SyntaxException, java.io.IOException
  {
    Language saveLang = Language.setSaveCurrent(factory.language);
    Environment env = factory.getEnvironment(context);
    Environment saveEnv = Environment.setSaveCurrent(env);
    try
    {
      Compilation comp = factory.language.parse(port, messages, 129);
      

      if (messages.seenErrors())
        throw new SyntaxException(messages);
      ModuleExp mexp = comp.getModule();
      String filename = (String)get("javax.script.filename");
      java.net.URL url;
      java.net.URL url; if (filename != null) {
        url = gnu.kawa.io.Path.toURL(filename); } else { java.net.URL url;
        if ((port instanceof CharArrayInPort)) {
          url = null;
        }
        else {
          gnu.kawa.io.Path portpath = port.getPath();
          url = portpath == null ? null : portpath.toURL();
        } }
      java.io.Writer errorWriter = context.getErrorWriter();
      OutPort errorPort = (errorWriter instanceof OutPort) ? (OutPort)errorWriter : new OutPort(errorWriter);
      

      Object inst = ModuleExp.evalModule1(env, comp, url, errorPort);
      return new KawaCompiledScript(this, mexp, inst);
    }
    finally
    {
      Language.restoreCurrent(saveLang);
      Environment.restoreCurrent(saveEnv);
    }
  }
}
