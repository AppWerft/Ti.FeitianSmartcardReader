// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import java.io.InputStream;
import gnu.text.SyntaxException;
import java.io.FileNotFoundException;
import gnu.mapping.Values;
import kawa.Shell;
import gnu.kawa.io.Path;
import gnu.mapping.Environment;
import gnu.mapping.Procedure1or2;

public class load extends Procedure1or2
{
    boolean relative;
    public static final load load;
    public static final load loadRelative;
    
    public load(final String name, final boolean relative) {
        super(name);
        this.relative = relative;
    }
    
    @Override
    public final Object apply1(final Object arg1) throws Throwable {
        return this.apply2(arg1, Environment.getCurrent());
    }
    
    @Override
    public final Object apply2(final Object name, final Object arg2) throws Throwable {
        final Environment env = (Environment)arg2;
        Path path = Path.valueOf(name);
        if (this.relative) {
            final Path curPath = Shell.currentLoadPath.get();
            if (curPath != null) {
                path = curPath.resolve(path);
            }
        }
        InputStream fs;
        try {
            fs = path.openInputStream();
        }
        catch (FileNotFoundException e) {
            Class clas = null;
            if (!this.relative && name instanceof CharSequence) {
                try {
                    clas = Class.forName(name.toString());
                }
                catch (Exception ex2) {}
            }
            if (clas == null) {
                throw new RuntimeException("cannot load " + e.getMessage());
            }
            Shell.runClass(clas, env);
            return Values.empty;
        }
        try {
            Shell.runFile(fs, path, env, true, 0);
            return Values.empty;
        }
        catch (SyntaxException ex) {
            throw new RuntimeException("load: errors while compiling '" + name + "':\n" + ex.getMessages().toString(20));
        }
    }
    
    static {
        load = new load("load", false);
        loadRelative = new load("load-relative", true);
    }
}
