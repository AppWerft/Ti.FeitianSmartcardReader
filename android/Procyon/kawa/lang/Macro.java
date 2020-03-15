// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.expr.ErrorExp;
import gnu.text.SourceLocator;
import gnu.lists.PairWithPosition;
import gnu.expr.LambdaExp;
import gnu.expr.Compilation;
import gnu.expr.LangExp;
import gnu.lists.Consumer;
import gnu.lists.Pair;
import gnu.expr.QuoteExp;
import gnu.expr.Expression;
import gnu.mapping.Procedure;
import gnu.expr.Declaration;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import java.io.Externalizable;
import gnu.kawa.format.Printable;

public class Macro extends Syntax implements Printable, Externalizable
{
    public Object expander;
    Object instance;
    public static final int HYGIENIC = 1;
    public static final int SKIP_SCAN_FORM = 2;
    private int flags;
    ScopeExp capturedScope;
    
    public final void setFlags(final int flags) {
        this.flags = flags;
    }
    
    public final boolean isHygienic() {
        return (this.flags & 0x1) != 0x0;
    }
    
    public final void setHygienic(final boolean hygienic) {
        if (hygienic) {
            this.flags |= 0x1;
        }
        else {
            this.flags &= 0xFFFFFFFE;
        }
    }
    
    public ScopeExp getCapturedScope() {
        if (this.capturedScope == null) {
            if (this.instance instanceof ModuleExp) {
                this.capturedScope = (ModuleExp)this.instance;
            }
            else if (this.instance instanceof String) {
                this.capturedScope = ModuleInfo.findWithClassName((String)this.instance).getModuleExp();
            }
            else if (this.instance != null) {
                this.capturedScope = ModuleInfo.findFromInstance(this.instance).getModuleExp();
            }
        }
        return this.capturedScope;
    }
    
    public void setCapturedScope(final ScopeExp scope) {
        this.capturedScope = scope;
    }
    
    public static Macro make(final Declaration decl) {
        final Macro mac = new Macro(decl.getSymbol());
        decl.setSyntax();
        mac.capturedScope = decl.context;
        return mac;
    }
    
    public static Macro makeNonHygienic(final Object name, final Procedure expander) {
        final Macro mac = new Macro(name, expander);
        mac.setHygienic(false);
        return mac;
    }
    
    public static Macro makeNonHygienic(final Object name, final Procedure expander, final Object instance) {
        final Macro mac = new Macro(name, expander);
        mac.setHygienic(false);
        mac.instance = instance;
        return mac;
    }
    
    public static Macro makeSkipScanForm(final Object name, final Procedure expander, final Object instance) {
        final Macro mac = new Macro(name, expander);
        mac.flags = 3;
        mac.instance = instance;
        return mac;
    }
    
    public static Macro make(final Object name, final Procedure expander) {
        return new Macro(name, expander);
    }
    
    public static Macro make(final Object name, final Procedure expander, final Object instance) {
        final Macro mac = new Macro(name, expander);
        mac.instance = instance;
        return mac;
    }
    
    public Macro() {
        this.flags = 1;
    }
    
    public Macro(final Macro old) {
        this.flags = 1;
        this.name = old.name;
        this.expander = old.expander;
        this.flags = old.flags;
    }
    
    public Macro(final Object name, final Procedure expander) {
        super(name);
        this.flags = 1;
        this.expander = ((expander instanceof Expression) ? expander : new QuoteExp(expander));
    }
    
    public Macro(final Object name) {
        super(name);
        this.flags = 1;
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        return tr.rewrite(this.expand(form, tr), 'N');
    }
    
    @Override
    public String toString() {
        return "#<macro " + this.getName() + '>';
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#<macro ");
        out.write(this.getName());
        out.write(62);
    }
    
    public Object rewriteIfNeeded() {
        Object exp = this.expander;
        if (exp instanceof LangExp) {
            final Object[] lval = (Object[])((LangExp)exp).getLangValue();
            final Object p = lval[0];
            final Translator xtr = (Translator)lval[1];
            final ScopeExp scope = (ScopeExp)lval[2];
            final Macro savedMacro = xtr.currentMacroDefinition;
            final Compilation savedComp = Compilation.getCurrent();
            xtr.currentMacroDefinition = this;
            Compilation.setCurrent(xtr);
            final ScopeExp savedScope = xtr.setPushCurrentScope(scope);
            Expression rule;
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
            exp = (this.expander = rule);
        }
        return exp;
    }
    
    public Object expand(Object form, final Translator tr) {
        final Object savedMacroMark = tr.currentMacroMark;
        tr.currentMacroMark = new Object();
        try {
            Object exp = this.expander;
            Procedure pr;
            if (exp instanceof Procedure && !(exp instanceof Expression)) {
                pr = (Procedure)exp;
            }
            else {
                exp = this.rewriteIfNeeded();
                if (!(exp instanceof Expression)) {
                    final Macro savedMacro = tr.currentMacroDefinition;
                    tr.currentMacroDefinition = this;
                    try {
                        exp = tr.rewrite(exp);
                        this.expander = exp;
                    }
                    finally {
                        tr.currentMacroDefinition = savedMacro;
                    }
                }
                pr = (Procedure)((Expression)exp).eval(tr.getGlobalEnvironment());
            }
            Object result;
            if (!this.isHygienic()) {
                form = Quote.quote(form, tr);
                final int nargs = Translator.listLength(form);
                if (nargs <= 0) {
                    return tr.syntaxError("invalid macro argument list to " + this);
                }
                final Object[] args = new Object[nargs - 1];
                for (int i = 0; i < nargs; ++i) {
                    final Pair pair = (Pair)form;
                    if (i > 0) {
                        args[i - 1] = pair.getCar();
                    }
                    form = pair.getCdr();
                }
                result = pr.applyN(args);
            }
            else {
                result = pr.apply1(form);
            }
            if (form instanceof PairWithPosition && result instanceof Pair && !(result instanceof PairWithPosition)) {
                final Pair p = (Pair)result;
                result = new PairWithPosition((SourceLocator)form, p.getCar(), p.getCdr());
            }
            return result;
        }
        catch (Throwable ex) {
            final String msg = "evaluating syntax transformer '" + this.getName() + "' threw " + ex;
            tr.getMessages().error('e', msg, ex);
            return new ErrorExp(msg);
        }
        finally {
            tr.currentMacroMark = savedMacroMark;
        }
    }
    
    @Override
    public void scanForm(final Pair st, final ScopeExp defs, final Translator tr) {
        if ((this.flags & 0x2) != 0x0) {
            super.scanForm(st, defs, tr);
            return;
        }
        final String save_filename = tr.getFileName();
        final int save_line = tr.getLineNumber();
        final int save_column = tr.getColumnNumber();
        final Syntax saveSyntax = tr.currentSyntax;
        try {
            tr.setLine(st);
            tr.currentSyntax = this;
            final Object x = this.expand(st, tr);
            tr.scanForm(x, defs);
        }
        finally {
            tr.setLine(save_filename, save_line, save_column);
            tr.currentSyntax = saveSyntax;
        }
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(((QuoteExp)this.expander).getValue());
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.setName((String)in.readObject());
        this.expander = new QuoteExp(in.readObject());
    }
}
