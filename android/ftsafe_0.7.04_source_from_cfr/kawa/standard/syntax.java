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
import gnu.expr.LetExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.SimpleSymbol;
import gnu.text.SourceLocator;
import kawa.lang.PatternScope;
import kawa.lang.Quote;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxTemplate;
import kawa.lang.Translator;

public class syntax
extends Quote {
    public static final syntax syntax = new syntax("syntax", false);
    public static final syntax quasiSyntax = new syntax("quasisyntax", true);
    static final ClassType typeTemplateScope = ClassType.make("kawa.lang.TemplateScope");
    static final Method makeTemplateScopeMethod = typeTemplateScope.getDeclaredMethod("make", 0);

    public syntax(String name, boolean isQuasi) {
        super(name, isQuasi);
    }

    @Override
    protected boolean matchesUnquote(Pair pair, SyntaxForm syntax2, Translator tr) {
        Object form = pair.getCar();
        if (tr.matches(form, syntax2, "unsyntax")) {
            return true;
        }
        if (tr.matches(form, syntax2, "unquote")) {
            tr.error('w', "unquote inside quasisyntax is deprecated - use unsyntax or #,", pair instanceof PairWithPosition ? (PairWithPosition)pair : tr);
            return true;
        }
        return false;
    }

    @Override
    protected boolean matchesUnquoteSplicing(Pair pair, SyntaxForm syntax2, Translator tr) {
        Object form = pair.getCar();
        if (tr.matches(form, syntax2, "unsyntax-splicing")) {
            return true;
        }
        if (tr.matches(form, syntax2, "unquote-splicing")) {
            tr.error('w', "unquote-splicing inside quasisyntax is deprecated - use unsyntax-splicing or #@,", pair instanceof PairWithPosition ? (PairWithPosition)pair : tr);
            return true;
        }
        return false;
    }

    @Override
    protected boolean matchesQuasiQuote(Object form, SyntaxForm syntax2, Translator tr) {
        return tr.matches(form, syntax2, "quasisyntax");
    }

    @Override
    protected boolean expandColonForms() {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Expression rewriteForm(Pair form, Translator tr) {
        SourceLocator templateScopeDecl;
        if (!(form.getCdr() instanceof Pair) || (form = (Pair)form.getCdr()).getCdr() != LList.Empty) {
            return tr.syntaxError("syntax forms requires a single form");
        }
        Declaration saveTemplateScopeDecl = tr.templateScopeDecl;
        if (saveTemplateScopeDecl == null) {
            tr.letStart();
            ApplyExp init = new ApplyExp(makeTemplateScopeMethod, Expression.noExpressions);
            templateScopeDecl = tr.letVariable(null, typeTemplateScope, init);
            templateScopeDecl.setCanRead();
            tr.templateScopeDecl = templateScopeDecl;
            tr.letEnter();
        }
        try {
            Expression body = this.coerceExpression(this.expand(form.getCar(), this.isQuasi ? 1 : -1, tr), tr);
            templateScopeDecl = saveTemplateScopeDecl == null ? tr.letDone(body) : body;
            return templateScopeDecl;
        }
        finally {
            tr.templateScopeDecl = saveTemplateScopeDecl;
        }
    }

    @Override
    protected Expression leaf(Object val, Translator tr) {
        return syntax.makeSyntax(val, tr);
    }

    static Expression makeSyntax(Object form, Translator tr) {
        SyntaxTemplate template = new SyntaxTemplate(form, null, SyntaxRule.dots3Symbol, tr);
        Expression matchArray = QuoteExp.nullExp;
        PatternScope patternScope = tr.patternScope;
        if (patternScope != null && patternScope.matchArray != null) {
            matchArray = new ReferenceExp(patternScope.matchArray);
        }
        Expression[] args = new Expression[]{new QuoteExp(template), matchArray, new ReferenceExp(tr.templateScopeDecl)};
        return new ApplyExp(ClassType.make("kawa.lang.SyntaxTemplate").getDeclaredMethod("execute", new Type[]{null, typeTemplateScope}), args);
    }
}

