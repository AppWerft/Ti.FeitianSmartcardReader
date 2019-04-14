package gnu.expr;

import gnu.kawa.io.OutPort;
import gnu.lists.Consumer;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import java.io.Writer;
import kawa.Shell;





public class CompiledModule
{
  Language language;
  ModuleExp mexp;
  Object cookie;
  
  public CompiledModule(ModuleExp mexp, Object cookie, Language language)
  {
    this.mexp = mexp;
    this.cookie = cookie;
    this.language = language;
  }
  
  public static CompiledModule make(Class clas, Language language)
  {
    return new CompiledModule(null, clas, language);
  }
  


  public void evalModule(Environment env, CallContext ctx)
    throws Throwable
  {
    Language saveLang = Language.setSaveCurrent(language);
    Environment saveEnv = Environment.setSaveCurrent(env);
    try
    {
      ModuleExp.evalModule2(env, ctx, language, mexp, cookie);
    }
    finally
    {
      Language.restoreCurrent(saveLang);
      Environment.restoreCurrent(saveEnv);
    }
  }
  
  public void evalModule(Environment env, OutPort out)
    throws Throwable
  {
    CallContext ctx = CallContext.getInstance();
    Consumer saveConsumer = consumer;
    boolean print = ModuleBody.getMainPrintValues();
    consumer = (print ? Shell.getOutputConsumer(out) : new VoidConsumer());
    try
    {
      evalModule(env, ctx);
    }
    finally
    {
      if ((consumer instanceof Writer)) {
        ((Writer)consumer).flush();
      }
      consumer = saveConsumer;
    }
  }
  


  public Object evalToResultValue(Environment env, CallContext ctx)
    throws Throwable
  {
    int oldIndex = ctx.startFromContext();
    try
    {
      evalModule(env, ctx);
      return ctx.getFromContext(oldIndex);
    }
    catch (Throwable ex)
    {
      ctx.cleanupFromContext(oldIndex);
      throw ex;
    }
  }
}
