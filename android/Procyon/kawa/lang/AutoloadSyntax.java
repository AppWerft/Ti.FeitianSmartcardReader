// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.mapping.WrongType;
import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.mapping.WrongArguments;
import gnu.mapping.UnboundLocationException;
import java.io.PrintWriter;
import gnu.mapping.Environment;
import java.io.Externalizable;

public class AutoloadSyntax extends Syntax implements Externalizable
{
    String className;
    Environment env;
    Syntax loaded;
    
    public AutoloadSyntax() {
    }
    
    public AutoloadSyntax(final String name, final String className) {
        super(name);
        this.className = className;
    }
    
    public AutoloadSyntax(final String name, final String className, final Environment env) {
        super(name);
        this.className = className;
        this.env = env;
    }
    
    public void print(final PrintWriter ps) {
        ps.print(this.toString());
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer(100);
        sbuf.append("#<syntax ");
        if (this.getName() != null) {
            sbuf.append(this.getName());
            sbuf.append(' ');
        }
        if (this.loaded != null) {
            sbuf.append("autoloaded>");
        }
        else {
            sbuf.append("autoload ");
            sbuf.append(this.className);
            sbuf.append(">");
        }
        return sbuf.toString();
    }
    
    private void throw_error(final String prefix) {
        throw new GenericError(prefix + this.className + " while autoloading " + ((this.getName() == null) ? "" : this.getName().toString()));
    }
    
    void load() {
        final String name = this.getName();
        try {
            final Object value = Class.forName(this.className).newInstance();
            if (value instanceof Syntax) {
                this.loaded = (Syntax)value;
                if (name != null && this.loaded.getName() == null) {
                    this.loaded.setName(name);
                }
            }
            else {
                this.throw_error("failed to autoload valid syntax object ");
            }
        }
        catch (ClassNotFoundException ex) {
            this.throw_error("failed to find class ");
        }
        catch (InstantiationException ex2) {
            this.throw_error("failed to instantiate class ");
        }
        catch (IllegalAccessException ex3) {
            this.throw_error("illegal access in class ");
        }
        catch (UnboundLocationException e) {
            this.throw_error("missing symbol '" + e.getMessage() + "' ");
        }
        catch (WrongArguments ex4) {
            this.throw_error("type error");
        }
    }
    
    @Override
    public void scanForm(final Pair st, final ScopeExp defs, final Translator tr) {
        if (this.loaded == null) {
            try {
                this.load();
            }
            catch (RuntimeException e) {
                tr.syntaxError(e.getMessage());
                return;
            }
        }
        this.loaded.scanForm(st, defs, tr);
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        if (this.loaded == null) {
            try {
                this.load();
            }
            catch (GenericError e) {
                return tr.syntaxError(e.getMessage());
            }
            catch (WrongType e2) {
                return tr.syntaxError(e2.getMessage());
            }
        }
        final Syntax saveSyntax = tr.currentSyntax;
        tr.currentSyntax = this.loaded;
        try {
            return this.loaded.rewriteForm(form, tr);
        }
        finally {
            tr.currentSyntax = saveSyntax;
        }
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
}
