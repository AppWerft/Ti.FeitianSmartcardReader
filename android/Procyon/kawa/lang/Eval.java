// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.kawa.io.OutPort;
import java.net.URL;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.expr.Compilation;
import gnu.text.Lexer;
import gnu.expr.NameLookup;
import gnu.expr.Language;
import gnu.text.SourceMessages;
import gnu.text.SourceLocator;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;

public class Eval
{
    public static void evalForm$X(final Object sexpr, final Environment env, final CallContext ctx) throws Throwable {
        PairWithPosition body;
        if (sexpr instanceof PairWithPosition) {
            body = new PairWithPosition((SourceLocator)sexpr, sexpr, LList.Empty);
        }
        else {
            body = new PairWithPosition(sexpr, LList.Empty);
            body.setFile("<eval>");
        }
        evalBody(body, env, new SourceMessages(), ctx);
    }
    
    public static Object eval(final Object sexpr, final Environment env) throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        final int oldIndex = ctx.startFromContext();
        try {
            evalForm$X(sexpr, env, ctx);
            return ctx.getFromContext(oldIndex);
        }
        catch (Throwable ex) {
            ctx.cleanupFromContext(oldIndex);
            throw ex;
        }
    }
    
    public static Object evalBody(final Object body, final Environment env, final SourceMessages messages) throws Throwable {
        final CallContext ctx = CallContext.getInstance();
        final int oldIndex = ctx.startFromContext();
        try {
            evalBody(body, env, messages, ctx);
            return ctx.getFromContext(oldIndex);
        }
        catch (Throwable ex) {
            ctx.cleanupFromContext(oldIndex);
            throw ex;
        }
    }
    
    public static void evalBody(final Object body, final Environment env, final SourceMessages messages, final CallContext ctx) throws Throwable {
        final Language language = Language.getDefaultLanguage();
        final Environment saveGlobalEnv = Environment.getCurrent();
        try {
            if (env != saveGlobalEnv) {
                Environment.setCurrent(env);
            }
            final Translator tr = (Translator)language.getCompilation(messages, NameLookup.getInstance(env, language));
            tr.immediate = true;
            tr.setState(3);
            tr.setSharedModuleDefs(true);
            final ModuleExp mod = tr.pushNewModule(null);
            if (env == Environment.user()) {
                mod.setFlag(4194304);
            }
            final Compilation saveComp = Compilation.setSaveCurrent(tr);
            try {
                tr.scanBody(body, mod, false);
                tr.finishModule(mod);
                if (body instanceof PairWithPosition) {
                    mod.setFile(((PairWithPosition)body).getFileName());
                }
                tr.setEvalName();
                tr.process(6);
            }
            finally {
                Compilation.restoreCurrent(saveComp);
            }
            ModuleExp.evalModule(env, ctx, tr, null, null);
            if (messages.seenErrors()) {
                throw new RuntimeException("invalid syntax in eval form:\n" + messages.toString(20));
            }
        }
        finally {
            if (env != saveGlobalEnv) {
                Environment.setCurrent(saveGlobalEnv);
            }
        }
    }
}
