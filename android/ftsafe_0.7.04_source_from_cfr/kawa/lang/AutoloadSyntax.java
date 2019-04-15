/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.mapping.Environment;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.PrintWriter;
import kawa.lang.GenericError;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class AutoloadSyntax
extends Syntax
implements Externalizable {
    String className;
    Environment env;
    Syntax loaded;

    public AutoloadSyntax() {
    }

    public AutoloadSyntax(String name, String className) {
        super(name);
        this.className = className;
    }

    public AutoloadSyntax(String name, String className, Environment env) {
        super(name);
        this.className = className;
        this.env = env;
    }

    public void print(PrintWriter ps) {
        ps.print(this.toString());
    }

    public String toString() {
        StringBuffer sbuf = new StringBuffer(100);
        sbuf.append("#<syntax ");
        if (this.getName() != null) {
            sbuf.append(this.getName());
            sbuf.append(' ');
        }
        if (this.loaded != null) {
            sbuf.append("autoloaded>");
        } else {
            sbuf.append("autoload ");
            sbuf.append(this.className);
            sbuf.append(">");
        }
        return sbuf.toString();
    }

    private void throw_error(String prefix) {
        throw new GenericError(prefix + this.className + " while autoloading " + (this.getName() == null ? "" : this.getName().toString()));
    }

    void load() {
        String name = this.getName();
        try {
            Object value = Class.forName(this.className).newInstance();
            if (value instanceof Syntax) {
                this.loaded = (Syntax)value;
                if (name != null && this.loaded.getName() == null) {
                    this.loaded.setName(name);
                }
            } else {
                this.throw_error("failed to autoload valid syntax object ");
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
        catch (UnboundLocationException e) {
            this.throw_error("missing symbol '" + e.getMessage() + "' ");
        }
        catch (WrongArguments ex) {
            this.throw_error("type error");
        }
    }

    @Override
    public void scanForm(Pair st, ScopeExp defs2, Translator tr) {
        if (this.loaded == null) {
            try {
                this.load();
            }
            catch (RuntimeException e) {
                tr.syntaxError(e.getMessage());
                return;
            }
        }
        this.loaded.scanForm(st, defs2, tr);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        if (this.loaded == null) {
            try {
                this.load();
            }
            catch (GenericError e) {
                return tr.syntaxError(e.getMessage());
            }
            catch (WrongType e) {
                return tr.syntaxError(e.getMessage());
            }
        }
        Syntax saveSyntax = tr.currentSyntax;
        tr.currentSyntax = this.loaded;
        try {
            Expression expression = this.loaded.rewriteForm(form, tr);
            return expression;
        }
        finally {
            tr.currentSyntax = saveSyntax;
        }
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
}

