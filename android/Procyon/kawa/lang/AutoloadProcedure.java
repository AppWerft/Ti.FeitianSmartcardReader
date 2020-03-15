// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.mapping.HasSetter;
import gnu.mapping.Environment;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.EnvironmentKey;
import gnu.expr.ModuleBody;
import gnu.kawa.reflect.ClassMemberLocation;
import gnu.expr.ModuleContext;
import gnu.mapping.Symbol;
import java.io.PrintWriter;
import gnu.expr.Language;
import java.io.Externalizable;
import gnu.mapping.Procedure;

public class AutoloadProcedure extends Procedure implements Externalizable
{
    String className;
    Language language;
    Procedure loaded;
    static final Class classModuleBody;
    
    public AutoloadProcedure() {
    }
    
    public AutoloadProcedure(final String name, final String className) {
        super(name);
        this.className = className;
    }
    
    public AutoloadProcedure(final String name, final String className, final Language language) {
        super(name);
        this.className = className;
        this.language = language;
    }
    
    public void print(final PrintWriter ps) {
        ps.print("#<procedure ");
        final String name = this.getName();
        if (name != null) {
            ps.print(name);
        }
        ps.print('>');
    }
    
    private void throw_error(final String prefix) {
        this.loaded = null;
        final String name = this.getName();
        throw new RuntimeException(prefix + this.className + " while autoloading " + ((name == null) ? "" : name.toString()));
    }
    
    void load() {
        final Object name = this.getSymbol();
        Language lang = this.language;
        if (lang == null) {
            lang = Language.getDefaultLanguage();
        }
        final Environment env = lang.getLangEnvironment();
        final Symbol sym = (Symbol)((name instanceof Symbol) ? name : env.getSymbol(name.toString()));
        try {
            final Class procClass = Class.forName(this.className);
            if (AutoloadProcedure.classModuleBody.isAssignableFrom(procClass)) {
                final ModuleContext context = ModuleContext.getContext();
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
                final Object value = env.getFunction(sym, null);
                if (value == null || !(value instanceof Procedure)) {
                    this.throw_error("invalid ModuleBody class - does not define " + name);
                }
                this.loaded = (Procedure)value;
            }
            else {
                this.loaded = procClass.newInstance();
                if (this.loaded == this) {
                    this.throw_error("circularity detected");
                }
                if (name != null) {
                    try {
                        final Object property = lang.hasSeparateFunctionNamespace() ? EnvironmentKey.FUNCTION : null;
                        env.put(sym, property, this.loaded);
                    }
                    catch (UnboundLocationException ex5) {}
                }
            }
            if (name != null && this.loaded.getSymbol() == null) {
                this.loaded.setSymbol(name);
            }
        }
        catch (ClassNotFoundException ex2) {
            this.throw_error("failed to find class ");
        }
        catch (InstantiationException ex3) {
            this.throw_error("failed to instantiate class ");
        }
        catch (IllegalAccessException ex4) {
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
    public Object apply1(final Object arg1) throws Throwable {
        return this.getLoaded().apply1(arg1);
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) throws Throwable {
        return this.getLoaded().apply2(arg1, arg2);
    }
    
    @Override
    public Object apply3(final Object arg1, final Object arg2, final Object arg3) throws Throwable {
        return this.getLoaded().apply3(arg1, arg2, arg3);
    }
    
    @Override
    public Object apply4(final Object arg1, final Object arg2, final Object arg3, final Object arg4) throws Throwable {
        return this.getLoaded().apply4(arg1, arg2, arg3, arg4);
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
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
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.className);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.setName((String)in.readObject());
        this.className = (String)in.readObject();
    }
    
    @Override
    public Object getProperty(final Object key, final Object defaultValue) {
        final Object value = super.getProperty(key, null);
        if (value != null) {
            return value;
        }
        return this.getLoaded().getProperty(key, defaultValue);
    }
    
    static {
        classModuleBody = ModuleBody.class;
    }
}
