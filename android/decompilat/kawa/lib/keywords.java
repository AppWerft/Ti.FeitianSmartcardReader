// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.expr.Keyword;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class keywords extends ModuleBody
{
    public static final ModuleMethod keyword$Qu;
    public static final ModuleMethod keyword$Mn$Grstring;
    public static final ModuleMethod string$Mn$Grkeyword;
    public static keywords $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static boolean isKeyword(final Object object) {
        return Keyword.isKeyword(object);
    }
    
    public static CharSequence keyword$To$String(final Keyword keyword) {
        return keyword.getName();
    }
    
    public static Keyword string$To$Keyword(final String string) {
        return Keyword.make(string);
    }
    
    static {
        Lit2 = Symbol.valueOf("string->keyword");
        Lit1 = Symbol.valueOf("keyword->string");
        Lit0 = Symbol.valueOf("keyword?");
        keywords.$instance = new keywords();
        final keywords $instance = keywords.$instance;
        keyword$Qu = new ModuleMethod($instance, 1, keywords.Lit0, 4097);
        keyword$Mn$Grstring = new ModuleMethod($instance, 2, keywords.Lit1, 4097);
        string$Mn$Grkeyword = new ModuleMethod($instance, 3, keywords.Lit2, 4097);
        $runBody$();
    }
    
    public keywords() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 3: {
                ctx.value1 = Promise.force(o, String.class);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                final Object force = Promise.force(o, Keyword.class);
                if (!(force instanceof Keyword)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object argValue) {
    Label_0062_Outer:
        while (true) {
            while (true) {
                switch (method.selector) {
                    case 1: {
                        return isKeyword(argValue) ? Boolean.TRUE : Boolean.FALSE;
                    }
                    case 2: {
                        final Object force = Promise.force(argValue, Keyword.class);
                        try {
                            return keyword$To$String((Keyword)force);
                            return super.apply1(method, argValue);
                            final Object force2 = Promise.force(argValue, String.class);
                            return string$To$Keyword((force2 == null) ? null : force2.toString());
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "keyword->string", 1, argValue);
                        }
                        break;
                    }
                    case 3: {
                        continue;
                    }
                    default: {
                        continue Label_0062_Outer;
                    }
                }
                break;
            }
            break;
        }
    }
}
