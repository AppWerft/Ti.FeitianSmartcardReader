// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.WrongArguments;
import gnu.mapping.Values;
import gnu.mapping.Procedure;
import gnu.mapping.CallContext;
import java.lang.reflect.Method;
import gnu.bytecode.ParameterizedType;
import kawa.SourceMethodType;
import gnu.bytecode.Type;
import gnu.mapping.MethodProc;

public class ModuleMethod extends MethodProc
{
    public ModuleBody module;
    public int selector;
    protected int numArgs;
    
    public ModuleMethod(final ModuleBody module, final int selector, final Object name, final int numArgs) {
        this.init(module, selector, name, numArgs);
    }
    
    public ModuleMethod(final ModuleBody module, final int selector, final Object name, final int numArgs, final Object argTypes) {
        this.init(module, selector, name, numArgs);
        this.argTypes = argTypes;
    }
    
    public ModuleMethod init(final ModuleBody module, final int selector, final Object name, final int numArgs) {
        this.module = module;
        this.selector = selector;
        this.numArgs = numArgs;
        if (name != null) {
            this.setSymbol(name);
        }
        return this;
    }
    
    @Override
    protected void resolveParameterTypes() {
        Method method = null;
        final String name = this.getName();
        if (name != null) {
            try {
                final Class moduleClass = this.module.getClass();
                final Method[] methods = moduleClass.getDeclaredMethods();
                final String mangledName = Mangling.mangleNameIfNeeded(name);
                int i = methods.length;
                while (--i >= 0) {
                    if (methods[i].getName().equals(mangledName)) {
                        if (method != null) {
                            method = null;
                            break;
                        }
                        method = methods[i];
                    }
                }
                if (method != null) {
                    final Language lang = Language.getDefaultLanguage();
                    if (lang != null) {
                        final Class[] parameterClasses = method.getParameterTypes();
                        final int numParamTypes = parameterClasses.length;
                        final Type[] atypes = new Type[numParamTypes];
                        String[] annotTypes;
                        try {
                            final SourceMethodType sourceType = method.getAnnotation(SourceMethodType.class);
                            annotTypes = (String[])((sourceType == null) ? null : sourceType.value());
                        }
                        catch (Throwable ex) {
                            annotTypes = null;
                        }
                        int j = numParamTypes;
                        while (--j >= 0) {
                            atypes[j] = lang.getTypeFor(parameterClasses[j]);
                            if (annotTypes != null) {
                                atypes[j] = PrimProcedure.decodeType(atypes[j], annotTypes, j + 1, null, lang);
                            }
                        }
                        this.argTypes = atypes;
                    }
                }
            }
            catch (Exception ex2) {}
        }
        if (this.argTypes == null) {
            super.resolveParameterTypes();
        }
    }
    
    @Override
    public int numArgs() {
        return this.numArgs;
    }
    
    @Override
    public int match0(final CallContext ctx) {
        ctx.count = 0;
        ctx.where = 0;
        return this.module.match0(this, ctx);
    }
    
    @Override
    public int match1(final Object arg1, final CallContext ctx) {
        ctx.count = 1;
        ctx.where = 1;
        return this.module.match1(this, arg1, ctx);
    }
    
    @Override
    public int match2(final Object arg1, final Object arg2, final CallContext ctx) {
        ctx.count = 2;
        ctx.where = 33;
        return this.module.match2(this, arg1, arg2, ctx);
    }
    
    @Override
    public int match3(final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        ctx.count = 3;
        ctx.where = 801;
        return this.module.match3(this, arg1, arg2, arg3, ctx);
    }
    
    @Override
    public int match4(final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        ctx.count = 4;
        ctx.where = 17185;
        return this.module.match4(this, arg1, arg2, arg3, arg4, ctx);
    }
    
    @Override
    public int matchN(final Object[] args, final CallContext ctx) {
        final int num = this.numArgs();
        final int min = Procedure.minArgs(num);
        final int nargs = args.length;
        if (nargs < min) {
            return 0xFFF10000 | min;
        }
        final int max = Procedure.maxArgs(num);
        if (max > 0 && nargs > max) {
            return 0xFFF20000 | max;
        }
        ctx.count = nargs;
        ctx.where = 0;
        return this.module.matchN(this, args, ctx);
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        Object result = null;
        switch (ctx.pc) {
            case 0: {
                result = this.apply0();
                break;
            }
            case 1: {
                result = this.apply1(ctx.value1);
                break;
            }
            case 2: {
                result = this.apply2(ctx.value1, ctx.value2);
                break;
            }
            case 3: {
                result = this.apply3(ctx.value1, ctx.value2, ctx.value3);
                break;
            }
            case 4: {
                result = this.apply4(ctx.value1, ctx.value2, ctx.value3, ctx.value4);
                break;
            }
            case 5: {
                result = this.applyN(ctx.values);
                break;
            }
            default: {
                throw new Error("internal error - apply " + this);
            }
        }
        ctx.writeValue(result);
    }
    
    @Override
    public Object apply0() throws Throwable {
        return this.module.apply0(this);
    }
    
    @Override
    public Object apply1(final Object arg1) throws Throwable {
        return this.module.apply1(this, arg1);
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) throws Throwable {
        return this.module.apply2(this, arg1, arg2);
    }
    
    @Override
    public Object apply3(final Object arg1, final Object arg2, final Object arg3) throws Throwable {
        return this.module.apply3(this, arg1, arg2, arg3);
    }
    
    @Override
    public Object apply4(final Object arg1, final Object arg2, final Object arg3, final Object arg4) throws Throwable {
        return this.module.apply4(this, arg1, arg2, arg3, arg4);
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        return this.module.applyN(this, args);
    }
    
    public static Object apply0Default(final ModuleMethod method) throws Throwable {
        return method.module.applyN(method, Values.noArgs);
    }
    
    public static Object apply1Default(final ModuleMethod method, final Object arg1) throws Throwable {
        final Object[] args = { arg1 };
        return method.module.applyN(method, args);
    }
    
    public static Object apply2Default(final ModuleMethod method, final Object arg1, final Object arg2) throws Throwable {
        final Object[] args = { arg1, arg2 };
        return method.module.applyN(method, args);
    }
    
    public static Object apply3Default(final ModuleMethod method, final Object arg1, final Object arg2, final Object arg3) throws Throwable {
        final Object[] args = { arg1, arg2, arg3 };
        return method.module.applyN(method, args);
    }
    
    public static Object apply4Default(final ModuleMethod method, final Object arg1, final Object arg2, final Object arg3, final Object arg4) throws Throwable {
        final Object[] args = { arg1, arg2, arg3, arg4 };
        return method.module.applyN(method, args);
    }
    
    public static Object applyNDefault(final ModuleMethod method, final Object[] args) throws Throwable {
        final int count = args.length;
        final int num = method.numArgs();
        final ModuleBody module = method.module;
        if (count >= (num & 0xFFF) && (num < 0 || count <= num >> 12)) {
            switch (count) {
                case 0: {
                    return module.apply0(method);
                }
                case 1: {
                    return module.apply1(method, args[0]);
                }
                case 2: {
                    return module.apply2(method, args[0], args[1]);
                }
                case 3: {
                    return module.apply3(method, args[0], args[1], args[2]);
                }
                case 4: {
                    return module.apply4(method, args[0], args[1], args[2], args[3]);
                }
            }
        }
        throw new WrongArguments(method, count);
    }
    
    public static void applyError() {
        throw new Error("internal error - bad selector");
    }
}
