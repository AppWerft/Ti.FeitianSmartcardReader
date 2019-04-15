/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.LangExp;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.expr.ThisExp;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import kawa.lang.Macro;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;

public class define_syntax
extends Syntax {
    int flags;
    public static final define_syntax define_macro = new define_syntax((Object)"%define-macro", false);
    public static final define_syntax define_syntax = new define_syntax((Object)"%define-syntax", true);
    public static final define_syntax define_rewrite_syntax = new define_syntax((Object)"define-rewrite-syntax", 3);
    static ClassType typeMacro = ClassType.make("kawa.lang.Macro");
    static PrimProcedure makeHygienic = new PrimProcedure(typeMacro.getDeclaredMethod("make", 3));
    static PrimProcedure makeNonHygienic = new PrimProcedure(typeMacro.getDeclaredMethod("makeNonHygienic", 3));
    static PrimProcedure makeSkipScanForm = new PrimProcedure(typeMacro.getDeclaredMethod("makeSkipScanForm", 3));
    static PrimProcedure setCapturedScope = new PrimProcedure(typeMacro.getDeclaredMethod("setCapturedScope", 1));

    public define_syntax() {
        this.flags = 1;
    }

    public define_syntax(Object name, int flags) {
        super(name);
        this.flags = flags;
    }

    public define_syntax(Object name, boolean hygienic) {
        this(name, hygienic ? 1 : 0);
    }

    @Override
    public void scanForm(Pair st, ScopeExp defs2, Translator tr) {
        Object name;
        SyntaxForm syntax2 = null;
        Object st_cdr = st.getCdr();
        while (st_cdr instanceof SyntaxForm) {
            syntax2 = (SyntaxForm)st_cdr;
            st_cdr = syntax2.getDatum();
        }
        Object p = st_cdr;
        if (p instanceof Pair) {
            Pair pp2 = (Pair)p;
            name = pp2.getCar();
            p = pp2.getCdr();
        } else {
            name = null;
        }
        SyntaxForm nameSyntax = syntax2;
        while (name instanceof SyntaxForm) {
            nameSyntax = (SyntaxForm)name;
            name = nameSyntax.getDatum();
        }
        if (!((name = tr.namespaceResolve(name)) instanceof Symbol)) {
            tr.pushForm(tr.syntaxError("missing macro name for " + Translator.safeCar(st)));
            return;
        }
        if (p == null || Translator.safeCdr(p) != LList.Empty) {
            tr.pushForm(tr.syntaxError("invalid syntax for " + this.getName()));
            return;
        }
        Declaration decl = tr.define(name, nameSyntax, defs2);
        decl.setType(typeMacro);
        tr.push(decl);
        Macro savedMacro = tr.currentMacroDefinition;
        Macro macro = Macro.make(decl);
        macro.setFlags(this.flags);
        ScopeExp scope = syntax2 != null ? syntax2.getScope() : tr.currentScope();
        Expression rule = new LangExp(new Object[]{p, tr, scope});
        macro.expander = rule;
        rule = new QuoteExp(macro);
        decl.noteValue(rule);
        decl.setProcedureDecl(true);
        if (decl.context instanceof ModuleExp) {
            SetExp result = new SetExp(decl, rule);
            result.setDefining(true);
            if (tr.getLanguage().hasSeparateFunctionNamespace()) {
                result.setFuncDef(true);
            }
            Pair ret = Translator.makePair(st, this, Translator.makePair(st, result, LList.Empty));
            tr.pushForm(ret);
            if (tr.immediate) {
                Expression[] args = new Expression[]{new ReferenceExp(decl), new QuoteExp(defs2)};
                tr.pushForm(new ApplyExp(setCapturedScope, args));
            }
        } else {
            macro.rewriteIfNeeded();
        }
    }

    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        Object x1;
        Pair p1;
        if (form instanceof Pair && (x1 = (p1 = (Pair)form.getCdr()).getCar()) instanceof SetExp) {
            SetExp sexp = (SetExp)x1;
            Object val = sexp.getNewValue().valueIfConstant();
            Declaration decl = sexp.getBinding();
            Object name = decl.getSymbol();
            ScopeExp defs2 = decl.getContext();
            if (val instanceof Macro) {
                PrimProcedure makeMacroProc;
                Macro macro = (Macro)val;
                macro.rewriteIfNeeded();
                Expression rule = (Expression)macro.expander;
                PrimProcedure primProcedure = (this.flags & 2) != 0 ? makeSkipScanForm : (makeMacroProc = (this.flags & 1) != 0 ? makeHygienic : makeNonHygienic);
                if (defs2 instanceof ModuleExp) {
                    rule = new ApplyExp(makeMacroProc, new QuoteExp(name), rule, ThisExp.makeGivingContext(defs2));
                }
                sexp.setNewValue(rule);
                decl.setValue(rule);
            }
            return (SetExp)x1;
        }
        return tr.syntaxError("define-syntax not in a body");
    }

    static {
        makeHygienic.setSideEffectFree();
        makeNonHygienic.setSideEffectFree();
        makeSkipScanForm.setSideEffectFree();
    }
}

