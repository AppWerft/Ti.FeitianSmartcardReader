// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.lists.Consumer;
import java.io.Writer;
import gnu.lists.VoidConsumer;
import kawa.Shell;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;

public class CompiledModule
{
    Language language;
    ModuleExp mexp;
    Object cookie;
    
    public CompiledModule(final ModuleExp mexp, final Object cookie, final Language language) {
        this.mexp = mexp;
        this.cookie = cookie;
        this.language = language;
    }
    
    public static CompiledModule make(final Class clas, final Language language) {
        return new CompiledModule(null, clas, language);
    }
    
    public void evalModule(final Environment env, final CallContext ctx) throws Throwable {
        final Language saveLang = Language.setSaveCurrent(this.language);
        final Environment saveEnv = Environment.setSaveCurrent(env);
        try {
            ModuleExp.evalModule2(env, ctx, this.language, this.mexp, this.cookie);
        }
        finally {
            Language.restoreCurrent(saveLang);
            Environment.restoreCurrent(saveEnv);
        }
    }
    
    public void evalModule(final Environment env, final OutPort out) throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        final Consumer saveConsumer = ctx.consumer;
        final boolean print = ModuleBody.getMainPrintValues();
        ctx.consumer = (print ? Shell.getOutputConsumer(out) : new VoidConsumer());
        try {
            this.evalModule(env, ctx);
        }
        finally {
            if (ctx.consumer instanceof Writer) {
                ((Writer)ctx.consumer).flush();
            }
            ctx.consumer = saveConsumer;
        }
    }
    
    public Object evalToResultValue(final Environment env, final CallContext ctx) throws Throwable {
        final int oldIndex = ctx.startFromContext();
        try {
            this.evalModule(env, ctx);
            return ctx.getFromContext(oldIndex);
        }
        catch (Throwable ex) {
            ctx.cleanupFromContext(oldIndex);
            throw ex;
        }
    }
}
