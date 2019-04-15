/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleContext;
import gnu.kawa.reflect.ClassMemberLocation;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public class AutoloadProcedure
extends Procedure
implements Externalizable {
    String className;
    Language language;
    Procedure loaded;
    static final Class classModuleBody = ModuleBody.class;

    public AutoloadProcedure() {
    }

    public AutoloadProcedure(String name, String className) {
        super(name);
        this.className = className;
    }

    public AutoloadProcedure(String name, String className, Language language) {
        super(name);
        this.className = className;
        this.language = language;
    }

    public void print(PrintWriter ps) {
        ps.print("#<procedure ");
        String name = this.getName();
        if (name != null) {
            ps.print(name);
        }
        ps.print('>');
    }

    private void throw_error(String prefix) {
        String name;
        this.loaded = null;
        throw new RuntimeException(prefix + this.className + " while autoloading " + ((name = this.getName()) == null ? "" : name.toString()));
    }

    void load() {
        Object name = this.getSymbol();
        Language lang = this.language;
        if (lang == null) {
            lang = Language.getDefaultLanguage();
        }
        Environment env = lang.getLangEnvironment();
        Symbol sym = name instanceof Symbol ? (Symbol)name : env.getSymbol(name.toString());
        try {
            Class<?> procClass = Class.forName(this.className);
            if (classModuleBody.isAssignableFrom(procClass)) {
                Object value;
                ModuleContext context = ModuleContext.getContext();
                Object mod = context.searchInstance(procClass);
                if (mod == null) {
                    try {
                        mod = procClass.getDeclaredField("$instance").get(null);
                    }
                    catch (NoSuchFieldException ex) {
                        mod = procClass.newInstance();
                    }
                }
                ClassMemberLocation.defineAll(mod, lang, env);
                if (mod instanceof ModuleBody) {
                    ((ModuleBody)mod).run();
                }
                if ((value = env.getFunction(sym, null)) == null || !(value instanceof Procedure)) {
                    this.throw_error("invalid ModuleBody class - does not define " + name);
                }
                this.loaded = (Procedure)value;
            } else {
                this.loaded = (Procedure)procClass.newInstance();
                if (this.loaded == this) {
                    this.throw_error("circularity detected");
                }
                if (name != null) {
                    try {
                        Object property = lang.hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null;
                        env.put(sym, property, this.loaded);
                    }
                    catch (UnboundLocationException ex) {
                        // empty catch block
                    }
                }
            }
            if (name != null && this.loaded.getSymbol() == null) {
                this.loaded.setSymbol(name);
            }
        }
        catch (ClassNotFoundException ex) {
            this.throw_error("failed to find class ");
        }
        catch (InstantiationException ex) {
            this.throw_error("failed to instantiate class ");
        }
        catch (IllegalAccessException ex) {
            this.throw_error("illegal access in class ");
        }
    }

    public Procedure getLoaded() {
        if (this.loaded == null) {
            this.load();
        }
        return this.loaded;
    }

    @Override
    public int numArgs() {
        return this.getLoaded().numArgs();
    }

    @Override
    public Object apply0() throws Throwable {
        return this.getLoaded().apply0();
    }

    @Override
    public Object apply1(Object arg1) throws Throwable {
        return this.getLoaded().apply1(arg1);
    }

    @Override
    public Object apply2(Object arg1, Object arg2) throws Throwable {
        return this.getLoaded().apply2(arg1, arg2);
    }

    @Override
    public Object apply3(Object arg1, Object arg2, Object arg3) throws Throwable {
        return this.getLoaded().apply3(arg1, arg2, arg3);
    }

    @Override
    public Object apply4(Object arg1, Object arg2, Object arg3, Object arg4) throws Throwable {
        return this.getLoaded().apply4(arg1, arg2, arg3, arg4);
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        if (this.loaded == null) {
            this.load();
        }
        if (this.loaded instanceof AutoloadProcedure) {
            throw new InternalError("circularity in autoload of " + this.getName());
        }
        return this.loaded.applyN(args);
    }

    @Override
    public Procedure getSetter() {
        if (this.loaded == null) {
            this.load();
        }
        if (this.loaded instanceof HasSetter) {
            return this.loaded.getSetter();
        }
        return super.getSetter();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.className);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setName((String)in.readObject());
        this.className = (String)in.readObject();
    }

    @Override
    public Object getProperty(Object key, Object defaultValue) {
        Object value = super.getProperty(key, null);
        if (value != null) {
            return value;
        }
        return this.getLoaded().getProperty(key, defaultValue);
    }
}

