package gnu.expr;

import gnu.mapping.CallContext;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptException;

































































































































class KawaCompiledScript
  extends CompiledScript
{
  KawaScriptEngine engine;
  CompiledModule cmodule;
  
  public KawaCompiledScript(KawaScriptEngine engine, ModuleExp mexp, Object cookie)
  {
    this.engine = engine;
    cmodule = new CompiledModule(mexp, cookie, factory.language);
  }
  
  public Object eval(ScriptContext context) throws ScriptException
  {
    try
    {
      return cmodule.evalToResultValue(engine.factory.getEnvironment(context), CallContext.getInstance());

    }
    catch (Throwable ex)
    {
      if ((ex instanceof Exception))
        throw new ScriptException((Exception)ex);
      if ((ex instanceof Error)) {
        throw ((Error)ex);
      }
      throw new RuntimeException(ex);
    }
  }
  
  public KawaScriptEngine getEngine()
  {
    return engine;
  }
}
