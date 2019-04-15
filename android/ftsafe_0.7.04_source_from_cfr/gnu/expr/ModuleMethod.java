/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.ModuleBody;
import gnu.expr.PrimProcedure;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.mapping.WrongArguments;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kawa.SourceMethodType;

public class ModuleMethod
extends MethodProc {
    public ModuleBody module;
    public int selector;
    protected int numArgs;

    public ModuleMethod(ModuleBody module, int selector, Object name, int numArgs) {
        this.init(module, selector, name, numArgs);
    }

    public ModuleMethod(ModuleBody module, int selector, Object name, int numArgs, Object argTypes) {
        this.init(module, selector, name, numArgs);
        this.argTypes = argTypes;
    }

    public ModuleMethod init(ModuleBody module, int selector, Object name, int numArgs) {
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
        block9 : {
            Method method = null;
            String name = this.getName();
            if (name != null) {
                try {
                    Language lang;
                    String[] annotTypes;
                    Class<?> moduleClass = this.module.getClass();
                    Method[] methods = moduleClass.getDeclaredMethods();
                    String mangledName = Mangling.mangleNameIfNeeded(name);
                    int i = methods.length;
                    while (--i >= 0) {
                        if (!methods[i].getName().equals(mangledName)) continue;
                        if (method != null) {
                            method = null;
                            break;
                        }
                        method = methods[i];
                    }
                    if (method == null || (lang = Language.getDefaultLanguage()) == null) break block9;
                    Class<?>[] parameterClasses = method.getParameterTypes();
                    int numParamTypes = parameterClasses.length;
                    Type[] atypes = new Type[numParamTypes];
                    try {
                        SourceMethodType sourceType = method.getAnnotation(SourceMethodType.class);
                        annotTypes = sourceType == null ? null : sourceType.value();
                    }
                    catch (Throwable ex) {
                        annotTypes = null;
                    }
                    int i2 = numParamTypes;
                    while (--i2 >= 0) {
                        atypes[i2] = lang.getTypeFor(parameterClasses[i2]);
                        if (annotTypes == null) continue;
                        atypes[i2] = PrimProcedure.decodeType(atypes[i2], annotTypes, i2 + 1, null, lang);
                    }
                    this.argTypes = atypes;
                }
                catch (Exception ex) {
                    // empty catch block
                }
            }
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
    public int match0(CallContext ctx) {
        ctx.count = 0;
        ctx.where = 0;
        return this.module.match0(this, ctx);
    }

    @Override
    public int match1(Object arg1, CallContext ctx) {
        ctx.count = 1;
        ctx.where = 1;
        return this.module.match1(this, arg1, ctx);
    }

    @Override
    public int match2(Object arg1, Object arg2, CallContext ctx) {
        ctx.count = 2;
        ctx.where = 33;
        return this.module.match2(this, arg1, arg2, ctx);
    }

    @Override
    public int match3(Object arg1, Object arg2, Object arg3, CallContext ctx) {
        ctx.count = 3;
        ctx.where = 801;
        return this.module.match3(this, arg1, arg2, arg3, ctx);
    }

    @Override
    public int match4(Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx) {
        ctx.count = 4;
        ctx.where = 17185;
        return this.module.match4(this, arg1, arg2, arg3, arg4, ctx);
    }

    @Override
    public int matchN(Object[] args, CallContext ctx) {
        int nargs = args.length;
        int num = this.numArgs();
        int min = ModuleMethod.minArgs(num);
        if (nargs < min) {
            return -983040 | min;
        }
        int max = ModuleMethod.maxArgs(num);
        if (max > 0 && nargs > max) {
            return -917504 | max;
        }
        ctx.count = nargs;
        ctx.where = 0;
        return this.module.matchN(this, args, ctx);
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        Object result;
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
    public Object apply1(Object arg1) throws Throwable {
        return this.module.apply1(this, arg1);
    }

    @Override
    public Object apply2(Object arg1, Object arg2) throws Throwable {
        return this.module.apply2(this, arg1, arg2);
    }

    @Override
    public Object apply3(Object arg1, Object arg2, Object arg3) throws Throwable {
        return this.module.apply3(this, arg1, arg2, arg3);
    }

    @Override
    public Object apply4(Object arg1, Object arg2, Object arg3, Object arg4) throws Throwable {
        return this.module.apply4(this, arg1, arg2, arg3, arg4);
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        return this.module.applyN(this, args);
    }

    public static Object apply0Default(ModuleMethod method) throws Throwable {
        return method.module.applyN(method, Values.noArgs);
    }

    public static Object apply1Default(ModuleMethod method, Object arg1) throws Throwable {
        Object[] args = new Object[]{arg1};
        return method.module.applyN(method, args);
    }

    public static Object apply2Default(ModuleMethod method, Object arg1, Object arg2) throws Throwable {
        Object[] args = new Object[]{arg1, arg2};
        return method.module.applyN(method, args);
    }

    public static Object apply3Default(ModuleMethod method, Object arg1, Object arg2, Object arg3) throws Throwable {
        Object[] args = new Object[]{arg1, arg2, arg3};
        return method.module.applyN(method, args);
    }

    public static Object apply4Default(ModuleMethod method, Object arg1, Object arg2, Object arg3, Object arg4) throws Throwable {
        Object[] args = new Object[]{arg1, arg2, arg3, arg4};
        return method.module.applyN(method, args);
    }

    public static Object applyNDefault(ModuleMethod method, Object[] args) throws Throwable {
        int count = args.length;
        int num = method.numArgs();
        ModuleBody module = method.module;
        if (count >= (num & 4095) && (num < 0 || count <= num >> 12)) {
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

