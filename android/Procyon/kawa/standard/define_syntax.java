// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.ThisExp;
import gnu.expr.Declaration;
import gnu.mapping.Procedure;
import gnu.expr.ApplyExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Expression;
import gnu.expr.SetExp;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.LangExp;
import kawa.lang.Macro;
import gnu.bytecode.Type;
import gnu.lists.LList;
import gnu.mapping.Symbol;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.expr.PrimProcedure;
import gnu.bytecode.ClassType;
import kawa.lang.Syntax;

public class define_syntax extends Syntax
{
    int flags;
    public static final define_syntax define_macro;
    public static final define_syntax define_syntax;
    public static final define_syntax define_rewrite_syntax;
    static ClassType typeMacro;
    static PrimProcedure makeHygienic;
    static PrimProcedure makeNonHygienic;
    static PrimProcedure makeSkipScanForm;
    static PrimProcedure setCapturedScope;
    
    public define_syntax() {
        this.flags = 1;
    }
    
    public define_syntax(final Object name, final int flags) {
        super(name);
        this.flags = flags;
    }
    
    public define_syntax(final Object name, final boolean hygienic) {
        this(name, hygienic ? 1 : 0);
    }
    
    @Override
    public void scanForm(final Pair st, final ScopeExp defs, final Translator tr) {
        SyntaxForm syntax;
        Object st_cdr;
        for (syntax = null, st_cdr = st.getCdr(); st_cdr instanceof SyntaxForm; st_cdr = syntax.getDatum()) {
            syntax = (SyntaxForm)st_cdr;
        }
        Object p = st_cdr;
        Object name;
        if (p instanceof Pair) {
            final Pair pp = (Pair)p;
            name = pp.getCar();
            p = pp.getCdr();
        }
        else {
            name = null;
        }
        SyntaxForm nameSyntax;
        for (nameSyntax = syntax; name instanceof SyntaxForm; name = nameSyntax.getDatum()) {
            nameSyntax = (SyntaxForm)name;
        }
        name = tr.namespaceResolve(name);
        if (!(name instanceof Symbol)) {
            tr.pushForm(tr.syntaxError("missing macro name for " + Translator.safeCar(st)));
            return;
        }
        if (p == null || Translator.safeCdr(p) != LList.Empty) {
            tr.pushForm(tr.syntaxError("invalid syntax for " + this.getName()));
            return;
        }
        final Declaration decl = tr.define(name, nameSyntax, defs);
        decl.setType(kawa.standard.define_syntax.typeMacro);
        tr.push(decl);
        final Macro savedMacro = tr.currentMacroDefinition;
        final Macro macro = Macro.make(decl);
        macro.setFlags(this.flags);
        final ScopeExp scope = (syntax != null) ? syntax.getScope() : tr.currentScope();
        Expression rule = new LangExp(new Object[] { p, tr, scope });
        macro.expander = rule;
        rule = new QuoteExp(macro);
        decl.noteValue(rule);
        decl.setProcedureDecl(true);
        if (decl.context instanceof ModuleExp) {
            final SetExp result = new SetExp(decl, rule);
            result.setDefining(true);
            if (tr.getLanguage().hasSeparateFunctionNamespace()) {
                result.setFuncDef(true);
            }
            final Object ret = Translator.makePair(st, this, Translator.makePair(st, result, LList.Empty));
            tr.pushForm(ret);
            if (tr.immediate) {
                final Expression[] args = { new ReferenceExp(decl), new QuoteExp(defs) };
                tr.pushForm(new ApplyExp(kawa.standard.define_syntax.setCapturedScope, args));
            }
        }
        else {
            macro.rewriteIfNeeded();
        }
    }
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        if (form instanceof Pair) {
            final Pair p1 = (Pair)form.getCdr();
            final Object x1 = p1.getCar();
            if (x1 instanceof SetExp) {
                final SetExp sexp = (SetExp)x1;
                final Object val = sexp.getNewValue().valueIfConstant();
                final Declaration decl = sexp.getBinding();
                final Object name = decl.getSymbol();
                final ScopeExp defs = decl.getContext();
                if (val instanceof Macro) {
                    final Macro macro = (Macro)val;
                    macro.rewriteIfNeeded();
                    Expression rule = (Expression)macro.expander;
                    final Procedure makeMacroProc = ((this.flags & 0x2) != 0x0) ? kawa.standard.define_syntax.makeSkipScanForm : (((this.flags & 0x1) != 0x0) ? kawa.standard.define_syntax.makeHygienic : kawa.standard.define_syntax.makeNonHygienic);
                    if (defs instanceof ModuleExp) {
                        rule = new ApplyExp(makeMacroProc, new Expression[] { new QuoteExp(name), rule, ThisExp.makeGivingContext(defs) });
                    }
                    sexp.setNewValue(rule);
                    decl.setValue(rule);
                }
                return (SetExp)x1;
            }
        }
        return tr.syntaxError("define-syntax not in a body");
    }
    
    static {
        define_macro = new define_syntax("%define-macro", false);
        define_syntax = new define_syntax("%define-syntax", true);
        define_rewrite_syntax = new define_syntax("define-rewrite-syntax", 3);
        kawa.standard.define_syntax.typeMacro = ClassType.make("kawa.lang.Macro");
        kawa.standard.define_syntax.makeHygienic = new PrimProcedure(kawa.standard.define_syntax.typeMacro.getDeclaredMethod("make", 3));
        kawa.standard.define_syntax.makeNonHygienic = new PrimProcedure(kawa.standard.define_syntax.typeMacro.getDeclaredMethod("makeNonHygienic", 3));
        kawa.standard.define_syntax.makeSkipScanForm = new PrimProcedure(kawa.standard.define_syntax.typeMacro.getDeclaredMethod("makeSkipScanForm", 3));
        kawa.standard.define_syntax.setCapturedScope = new PrimProcedure(kawa.standard.define_syntax.typeMacro.getDeclaredMethod("setCapturedScope", 1));
        kawa.standard.define_syntax.makeHygienic.setSideEffectFree();
        kawa.standard.define_syntax.makeNonHygienic.setSideEffectFree();
        kawa.standard.define_syntax.makeSkipScanForm.setSideEffectFree();
    }
}
