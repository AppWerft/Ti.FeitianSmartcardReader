// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import gnu.mapping.CallContext;
import javax.script.ScriptContext;
import javax.script.CompiledScript;

class KawaCompiledScript extends CompiledScript
{
    KawaScriptEngine engine;
    CompiledModule cmodule;
    
    public KawaCompiledScript(final KawaScriptEngine engine, final ModuleExp mexp, final Object cookie) {
        this.engine = engine;
        this.cmodule = new CompiledModule(mexp, cookie, engine.factory.language);
    }
    
    @Override
    public Object eval(final ScriptContext context) throws ScriptException {
        try {
            return this.cmodule.evalToResultValue(this.engine.factory.getEnvironment(context), CallContext.getInstance());
        }
        catch (Throwable ex) {
            if (ex instanceof Exception) {
                throw new ScriptException((Exception)ex);
            }
            if (ex instanceof Error) {
                throw (Error)ex;
            }
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public KawaScriptEngine getEngine() {
        return this.engine;
    }
}
