package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.text.SourceMessages;

public class Eval
{
  public Eval() {}
  
  public static void evalForm$X(Object sexpr, Environment env, CallContext ctx) throws Throwable
  {
    PairWithPosition body;
    PairWithPosition body;
    if ((sexpr instanceof PairWithPosition)) {
      body = new PairWithPosition((PairWithPosition)sexpr, sexpr, gnu.lists.LList.Empty);
    }
    else
    {
      body = new PairWithPosition(sexpr, gnu.lists.LList.Empty);
      body.setFile("<eval>");
    }
    evalBody(body, env, new SourceMessages(), ctx);
  }
  
  public static Object eval(Object sexpr, Environment env)
    throws Throwable
  {
    CallContext ctx = CallContext.getInstance();
    int oldIndex = ctx.startFromContext();
    try
    {
      evalForm$X(sexpr, env, ctx);
      return ctx.getFromContext(oldIndex);
    }
    catch (Throwable ex)
    {
      ctx.cleanupFromContext(oldIndex);
      throw ex;
    }
  }
  

  public static Object evalBody(Object body, Environment env, SourceMessages messages)
    throws Throwable
  {
    CallContext ctx = CallContext.getInstance();
    int oldIndex = ctx.startFromContext();
    try
    {
      evalBody(body, env, messages, ctx);
      return ctx.getFromContext(oldIndex);
    }
    catch (Throwable ex)
    {
      ctx.cleanupFromContext(oldIndex);
      throw ex;
    }
  }
  

  public static void evalBody(Object body, Environment env, SourceMessages messages, CallContext ctx)
    throws Throwable
  {
    Language language = Language.getDefaultLanguage();
    Environment saveGlobalEnv = Environment.getCurrent();
    try
    {
      if (env != saveGlobalEnv)
        Environment.setCurrent(env);
      Translator tr = (Translator)language.getCompilation(messages, gnu.expr.NameLookup.getInstance(env, language));
      
      immediate = true;
      

      tr.setState(3);
      tr.setSharedModuleDefs(true);
      ModuleExp mod = tr.pushNewModule(null);
      if (env == Environment.user())
        mod.setFlag(4194304);
      Compilation saveComp = Compilation.setSaveCurrent(tr);
      try
      {
        tr.scanBody(body, mod, false);
        tr.finishModule(mod);
        if ((body instanceof PairWithPosition))
          mod.setFile(((PairWithPosition)body).getFileName());
        tr.setEvalName();
        tr.process(6);
      }
      finally
      {
        Compilation.restoreCurrent(saveComp);
      }
      
      ModuleExp.evalModule(env, ctx, tr, null, null);
      if (messages.seenErrors()) {
        throw new RuntimeException("invalid syntax in eval form:\n" + messages.toString(20));
      }
    }
    finally
    {
      if (env != saveGlobalEnv) {
        Environment.setCurrent(saveGlobalEnv);
      }
    }
  }
}
