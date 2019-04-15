/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.kawa.io.OutPort;
import gnu.lists.Consumer;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import java.io.Writer;
import kawa.Shell;

public class CompiledModule {
    Language language;
    ModuleExp mexp;
    Object cookie;

    public CompiledModule(ModuleExp mexp, Object cookie, Language language) {
        this.mexp = mexp;
        this.cookie = cookie;
        this.language = language;
    }

    public static CompiledModule make(Class clas, Language language) {
        return new CompiledModule(null, clas, language);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void evalModule(Environment env, CallContext ctx) throws Throwable {
        Language saveLang = Language.setSaveCurrent(this.language);
        Environment saveEnv = Environment.setSaveCurrent(env);
        try {
            ModuleExp.evalModule2(env, ctx, this.language, this.mexp, this.cookie);
        }
        finally {
            Language.restoreCurrent(saveLang);
            Environment.restoreCurrent(saveEnv);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void evalModule(Environment env, OutPort out) throws Throwable {
        CallContext ctx = CallContext.getInstance();
        Consumer saveConsumer = ctx.consumer;
        boolean print = ModuleBody.getMainPrintValues();
        ctx.consumer = print ? Shell.getOutputConsumer(out) : new VoidConsumer();
        try {
            this.evalModule(env, ctx);
        }
        finally {
            if (ctx.consumer instanceof Writer) {
                ((Writer)((Object)ctx.consumer)).flush();
            }
            ctx.consumer = saveConsumer;
        }
    }

    public Object evalToResultValue(Environment env, CallContext ctx) throws Throwable {
        int oldIndex = ctx.startFromContext();
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

