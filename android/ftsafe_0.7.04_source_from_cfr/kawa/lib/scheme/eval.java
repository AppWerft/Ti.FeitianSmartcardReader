/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.scheme;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleMethodWithContext;
import gnu.expr.NameLookup;
import gnu.expr.ScopeExp;
import gnu.kawa.functions.Format;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.NamedLocation;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleEnvironment;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import kawa.lang.Eval;
import kawa.lang.Translator;
import kawa.lib.lists;
import kawa.standard.ImportFromLibrary;
import kawa.standard.Scheme;
import kawa.standard.SchemeCompilation;

public class eval
extends ModuleBody {
    public static final ModuleMethod environment;
    public static final ModuleMethod eval;
    public static eval $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static void eval$X(Object object2, CallContext callContext) {
        eval.eval$X(object2, Environment.user(), callContext);
    }

    public static void eval$X(Object exp, Environment env, CallContext $ctx) {
        Consumer $result = $ctx.consumer;
        Eval.evalForm$X(exp, env, $ctx);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Environment environment$V(Object[] argsArray) {
        importer = LList.makeList(argsArray, 0);
        specifiers = importer;
        importer = ImportFromLibrary.instance;
        language = Scheme.getR7rsInstance();
        messages = new SourceMessages();
        lexical = new NameLookup(language);
        tr = new SchemeCompilation(language, messages, lexical);
        tr.immediate = true;
        module = tr.pushNewModule(null);
        env = Environment.make(Format.formatToString(0, new Object[]{"~{~a~^ ~}", specifiers}));
        importer.scanForm(lists.cons(Boolean.FALSE, specifiers), module, tr);
        if (messages.seenErrors()) {
            throw new SyntaxException(messages);
        }
        v0 = module.firstDecl();
        do lbl-1000: // 2 sources:
        {
            if ((decl = v0) == null) {
                env.setLocked();
                return env;
            }
            loc = StaticFieldLocation.make(Declaration.followAliases(decl));
            object2 = Promise.force(decl.getSymbol(), Symbol.class);
            env.addLocation((Symbol)object2, null, loc);
            break;
        } while (true);
        catch (ClassCastException v1) {
            throw new WrongType(v1, "gnu.mapping.SimpleEnvironment.addLocation(gnu.mapping.Symbol,java.lang.Object,gnu.mapping.Location)", 2, object2);
        }
        {
            v0 = decl.nextDecl();
            ** while (true)
        }
    }

    public static {
        Lit1 = Symbol.valueOf("environment");
        Lit0 = Symbol.valueOf("eval");
        eval eval2 = $instance = new eval();
        eval = new ModuleMethodWithContext(eval2, 1, Lit0, 8193);
        environment = new ModuleMethod(eval2, 3, Lit1, -4096);
        eval.$runBody$();
    }

    public eval() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            callContext.value1 = object2;
            callContext.proc = moduleMethod;
            callContext.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            callContext.value1 = object2;
            Object object4 = Promise.force(object3, Environment.class);
            if (!(object4 instanceof Environment)) {
                return -786430;
            }
            callContext.value2 = object4;
            callContext.proc = moduleMethod;
            callContext.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        if (moduleMethod.selector == 3) {
            callContext.values = arrobject;
            callContext.proc = moduleMethod;
            callContext.pc = 5;
            return 0;
        }
        return super.matchN(moduleMethod, arrobject, callContext);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void apply(CallContext callContext) {
        Object object2;
        switch (callContext.pc) {
            case 1: {
                eval.eval$X(callContext.value1, callContext);
                return;
            }
            case 2: {
                object2 = Promise.force(callContext.value2, Environment.class);
                eval.eval$X(callContext.value1, (Environment)object2, callContext);
                return;
            }
        }
        ModuleMethod.applyError();
        return;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "eval", 2, object2);
        }
    }

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        if (moduleMethod.selector == 3) {
            return eval.environment$V(arrobject);
        }
        return super.applyN(moduleMethod, arrobject);
    }
}

