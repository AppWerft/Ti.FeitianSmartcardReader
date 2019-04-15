/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.AbstractScriptEngineFactory;
import gnu.expr.CompiledModule;
import gnu.expr.KawaScriptEngine;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

class KawaCompiledScript
extends CompiledScript {
    KawaScriptEngine engine;
    CompiledModule cmodule;

    public KawaCompiledScript(KawaScriptEngine engine, ModuleExp mexp, Object cookie) {
        this.engine = engine;
        this.cmodule = new CompiledModule(mexp, cookie, engine.factory.language);
    }

    @Override
    public Object eval(ScriptContext context) throws ScriptException {
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

