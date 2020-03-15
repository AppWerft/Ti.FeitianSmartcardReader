// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.scheme;

import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethodWithContext;
import gnu.mapping.SimpleEnvironment;
import gnu.expr.ModuleExp;
import gnu.mapping.WrongType;
import gnu.mapping.Location;
import gnu.mapping.Promise;
import gnu.mapping.Symbol;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.Declaration;
import gnu.text.SyntaxException;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import kawa.lib.lists;
import gnu.kawa.functions.Format;
import gnu.text.Lexer;
import kawa.standard.SchemeCompilation;
import gnu.expr.Language;
import gnu.expr.NameLookup;
import gnu.text.SourceMessages;
import kawa.standard.Scheme;
import kawa.standard.ImportFromLibrary;
import gnu.lists.LList;
import kawa.lang.Eval;
import gnu.mapping.Environment;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class eval extends ModuleBody
{
    public static final ModuleMethod environment;
    public static final ModuleMethod eval;
    public static eval $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static void eval$X(final Object exp, final CallContext $ctx) {
        eval$X(exp, Environment.user(), $ctx);
    }
    
    public static void eval$X(final Object exp, final Environment env, final CallContext $ctx) {
        final Consumer $result = $ctx.consumer;
        Eval.evalForm$X(exp, env, $ctx);
    }
    
    public static Environment environment$V(final Object[] argsArray) {
        final LList specifiers = LList.makeList(argsArray, 0);
        final ImportFromLibrary importer = ImportFromLibrary.instance;
        final Scheme language = Scheme.getR7rsInstance();
        final SourceMessages messages = new SourceMessages();
        final NameLookup lexical = new NameLookup(language);
        final SchemeCompilation tr = new SchemeCompilation(language, messages, lexical);
        tr.immediate = true;
        final ModuleExp module = tr.pushNewModule(null);
        final SimpleEnvironment env = Environment.make(Format.formatToString(0, "~{~a~^ ~}", specifiers));
        importer.scanForm(lists.cons(Boolean.FALSE, specifiers), module, tr);
        if (messages.seenErrors()) {
            throw new SyntaxException(messages);
        }
        Declaration declaration = module.firstDecl();
        while (true) {
            final Declaration decl = declaration;
            Label_0173: {
                if (decl == null) {
                    break Label_0173;
                }
                final StaticFieldLocation loc = StaticFieldLocation.make(Declaration.followAliases(decl));
                final SimpleEnvironment simpleEnvironment = env;
                final Object force = Promise.force(decl.getSymbol(), Symbol.class);
                try {
                    simpleEnvironment.addLocation((Symbol)force, null, loc);
                    declaration = decl.nextDecl();
                    continue;
                    env.setLocked();
                    return env;
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "gnu.mapping.SimpleEnvironment.addLocation(gnu.mapping.Symbol,java.lang.Object,gnu.mapping.Location)", 2, force);
                }
            }
        }
    }
    
    static {
        Lit1 = Symbol.valueOf("environment");
        Lit0 = Symbol.valueOf("eval");
        kawa.lib.scheme.eval.$instance = new eval();
        final eval $instance = kawa.lib.scheme.eval.$instance;
        eval = new ModuleMethodWithContext($instance, 1, kawa.lib.scheme.eval.Lit0, 8193);
        environment = new ModuleMethod($instance, 3, kawa.lib.scheme.eval.Lit1, -4096);
        $runBody$();
    }
    
    public eval() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        if (moduleMethod.selector == 1) {
            ctx.value1 = o;
            ctx.proc = moduleMethod;
            ctx.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, o, ctx);
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        if (moduleMethod.selector != 1) {
            return super.match2(moduleMethod, o, o2, ctx);
        }
        ctx.value1 = o;
        final Object force = Promise.force(o2, Environment.class);
        if (!(force instanceof Environment)) {
            return -786430;
        }
        ctx.value2 = force;
        ctx.proc = moduleMethod;
        ctx.pc = 2;
        return 0;
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        if (moduleMethod.selector == 3) {
            ctx.values = array;
            ctx.proc = moduleMethod;
            ctx.pc = 5;
            return 0;
        }
        return super.matchN(moduleMethod, array, ctx);
    }
    
    @Override
    public void apply(final CallContext $ctx) {
        while (true) {
            switch ($ctx.pc) {
                case 1: {
                    eval$X($ctx.value1, $ctx);
                }
                case 2: {
                    final Object value1 = $ctx.value1;
                    final Object force = Promise.force($ctx.value2, Environment.class);
                    try {
                        eval$X(value1, (Environment)force, $ctx);
                        return;
                        ModuleMethod.applyError();
                        return;
                    }
                    catch (ClassCastException ex) {
                        throw new WrongType(ex, "eval", 2, force);
                    }
                    break;
                }
                default: {
                    continue;
                }
            }
            break;
        }
    }
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] array) {
        if (method.selector == 3) {
            return environment$V(array);
        }
        return super.applyN(method, array);
    }
}
