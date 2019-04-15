/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.kawa.format.Printable;
import gnu.lists.Consumer;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kawa.lang.Quote;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class Macro
extends Syntax
implements Printable,
Externalizable {
    public Object expander;
    Object instance;
    public static final int HYGIENIC = 1;
    public static final int SKIP_SCAN_FORM = 2;
    private int flags = 1;
    ScopeExp capturedScope;

    public final void setFlags(int flags) {
        this.flags = flags;
    }

    public final boolean isHygienic() {
        return (this.flags & 1) != 0;
    }

    public final void setHygienic(boolean hygienic) {
        this.flags = hygienic ? (this.flags |= 1) : (this.flags &= -2);
    }

    public ScopeExp getCapturedScope() {
        if (this.capturedScope == null) {
            if (this.instance instanceof ModuleExp) {
                this.capturedScope = (ModuleExp)this.instance;
            } else if (this.instance instanceof String) {
                this.capturedScope = ModuleInfo.findWithClassName((String)this.instance).getModuleExp();
            } else if (this.instance != null) {
                this.capturedScope = ModuleInfo.findFromInstance(this.instance).getModuleExp();
            }
        }
        return this.capturedScope;
    }

    public void setCapturedScope(ScopeExp scope) {
        this.capturedScope = scope;
    }

    public static Macro make(Declaration decl) {
        Macro mac = new Macro(decl.getSymbol());
        decl.setSyntax();
        mac.capturedScope = decl.context;
        return mac;
    }

    public static Macro makeNonHygienic(Object name, Procedure expander) {
        Macro mac = new Macro(name, expander);
        mac.setHygienic(false);
        return mac;
    }

    public static Macro makeNonHygienic(Object name, Procedure expander, Object instance) {
        Macro mac = new Macro(name, expander);
        mac.setHygienic(false);
        mac.instance = instance;
        return mac;
    }

    public static Macro makeSkipScanForm(Object name, Procedure expander, Object instance) {
        Macro mac = new Macro(name, expander);
        mac.flags = 3;
        mac.instance = instance;
        return mac;
    }

    public static Macro make(Object name, Procedure expander) {
        return new Macro(name, expander);
    }

    public static Macro make(Object name, Procedure expander, Object instance) {
        Macro mac = new Macro(name, expander);
        mac.instance = instance;
        return mac;
    }

    public Macro() {
    }

    public Macro(Macro old) {
        this.name = old.name;
        this.expander = old.expander;
        this.flags = old.flags;
    }

    public Macro(Object name, Procedure expander) {
        super(name);
        this.expander = expander instanceof Expression ? expander : new QuoteExp(expander);
    }

    public Macro(Object name) {
        super(name);
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        return tr.rewrite(this.expand(form, tr), 'N');
    }

    public String toString() {
        return "#<macro " + this.getName() + '>';
    }

    @Override
    public void print(Consumer out) {
        out.write("#<macro ");
        out.write(this.getName());
        out.write(62);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object rewriteIfNeeded() {
        Object exp = this.expander;
        if (exp instanceof LangExp) {
            Expression rule;
            Object[] lval = (Object[])((LangExp)exp).getLangValue();
            Object p = lval[0];
            Translator xtr = (Translator)lval[1];
            ScopeExp scope = (ScopeExp)lval[2];
            Macro savedMacro = xtr.currentMacroDefinition;
            Compilation savedComp = Compilation.getCurrent();
            xtr.currentMacroDefinition = this;
            Compilation.setCurrent(xtr);
            ScopeExp savedScope = xtr.setPushCurrentScope(scope);
            try {
                rule = xtr.rewrite_car((Pair)p, false);
            }
            finally {
                xtr.setPopCurrentScope(savedScope);
                xtr.currentMacroDefinition = savedMacro;
                Compilation.setCurrent(savedComp);
            }
            if (rule instanceof LambdaExp) {
                ((LambdaExp)rule).setFlag(256);
            }
            this.expander = exp = rule;
        }
        return exp;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object expand(Object form, Translator tr) {
        Object result;
        Object savedMacroMark = tr.currentMacroMark;
        tr.currentMacroMark = new Object();
        try {
            Procedure pr;
            Object exp = this.expander;
            if (exp instanceof Procedure && !(exp instanceof Expression)) {
                pr = (Procedure)exp;
            } else {
                exp = this.rewriteIfNeeded();
                if (!(exp instanceof Expression)) {
                    Macro savedMacro = tr.currentMacroDefinition;
                    tr.currentMacroDefinition = this;
                    try {
                        this.expander = exp = tr.rewrite(exp);
                    }
                    finally {
                        tr.currentMacroDefinition = savedMacro;
                    }
                }
                pr = (Procedure)((Expression)exp).eval(tr.getGlobalEnvironment());
            }
            if (!this.isHygienic()) {
                int nargs = Translator.listLength(form = Quote.quote(form, tr));
                if (nargs <= 0) {
                    ErrorExp errorExp = tr.syntaxError("invalid macro argument list to " + this);
                    return errorExp;
                }
                Object[] args = new Object[nargs - 1];
                for (int i = 0; i < nargs; ++i) {
                    Pair pair = (Pair)form;
                    if (i > 0) {
                        args[i - 1] = pair.getCar();
                    }
                    form = pair.getCdr();
                }
                result = pr.applyN(args);
            } else {
                result = pr.apply1(form);
            }
            if (form instanceof PairWithPosition && result instanceof Pair && !(result instanceof PairWithPosition)) {
                Pair p = (Pair)result;
                result = new PairWithPosition((PairWithPosition)form, p.getCar(), p.getCdr());
            }
            Object p = result;
            return p;
        }
        catch (Throwable ex) {
            String msg = "evaluating syntax transformer '" + this.getName() + "' threw " + ex;
            tr.getMessages().error('e', msg, ex);
            result = new ErrorExp(msg);
            return result;
        }
        finally {
            tr.currentMacroMark = savedMacroMark;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void scanForm(Pair st, ScopeExp defs2, Translator tr) {
        if ((this.flags & 2) != 0) {
            super.scanForm(st, defs2, tr);
            return;
        }
        String save_filename = tr.getFileName();
        int save_line = tr.getLineNumber();
        int save_column = tr.getColumnNumber();
        Syntax saveSyntax = tr.currentSyntax;
        try {
            tr.setLine(st);
            tr.currentSyntax = this;
            Object x = this.expand(st, tr);
            tr.scanForm(x, defs2);
        }
        finally {
            tr.setLine(save_filename, save_line, save_column);
            tr.currentSyntax = saveSyntax;
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(((QuoteExp)this.expander).getValue());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setName((String)in.readObject());
        this.expander = new QuoteExp(in.readObject());
    }
}

