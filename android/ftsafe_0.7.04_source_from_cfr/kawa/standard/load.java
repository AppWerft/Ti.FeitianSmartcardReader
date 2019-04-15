/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.kawa.io.Path;
import gnu.mapping.Environment;
import gnu.mapping.Procedure1or2;
import gnu.mapping.Values;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kawa.Shell;

public class load
extends Procedure1or2 {
    boolean relative;
    public static final load load = new load("load", false);
    public static final load loadRelative = new load("load-relative", true);

    public load(String name, boolean relative) {
        super(name);
        this.relative = relative;
    }

    @Override
    public final Object apply1(Object arg1) throws Throwable {
        return this.apply2(arg1, Environment.getCurrent());
    }

    @Override
    public final Object apply2(Object name, Object arg2) throws Throwable {
        InputStream fs;
        Path curPath;
        Environment env = (Environment)arg2;
        Path path = Path.valueOf(name);
        if (this.relative && (curPath = (Path)Shell.currentLoadPath.get()) != null) {
            path = curPath.resolve(path);
        }
        try {
            fs = path.openInputStream();
        }
        catch (FileNotFoundException e) {
            Class<?> clas = null;
            if (!this.relative && name instanceof CharSequence) {
                try {
                    clas = Class.forName(name.toString());
                }
                catch (Exception e2) {
                    // empty catch block
                }
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
}

