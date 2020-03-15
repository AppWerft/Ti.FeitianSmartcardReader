// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import kawa.lang.PatternScope;
import gnu.expr.ReferenceExp;
import gnu.expr.QuoteExp;
import kawa.lang.SyntaxTemplate;
import kawa.lang.SyntaxRule;
import gnu.expr.Declaration;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.lists.LList;
import gnu.expr.Expression;
import gnu.text.SourceLocator;
import gnu.lists.PairWithPosition;
import kawa.lang.Translator;
import kawa.lang.SyntaxForm;
import gnu.lists.Pair;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import kawa.lang.Quote;

public class syntax extends Quote
{
    public static final syntax syntax;
    public static final syntax quasiSyntax;
    static final ClassType typeTemplateScope;
    static final Method makeTemplateScopeMethod;
    
    public syntax(final String name, final boolean isQuasi) {
        super(name, isQuasi);
    }
    
    @Override
    protected boolean matchesUnquote(final Pair pair, final SyntaxForm syntax, final Translator tr) {
        final Object form = pair.getCar();
        if (tr.matches(form, syntax, "unsyntax")) {
            return true;
        }
        if (tr.matches(form, syntax, "unquote")) {
            tr.error('w', "unquote inside quasisyntax is deprecated - use unsyntax or #,", (pair instanceof PairWithPosition) ? ((PairWithPosition)pair) : tr);
            return true;
        }
        return false;
    }
    
    @Override
    protected boolean matchesUnquoteSplicing(final Pair pair, final SyntaxForm syntax, final Translator tr) {
        final Object form = pair.getCar();
        if (tr.matches(form, syntax, "unsyntax-splicing")) {
            return true;
        }
        if (tr.matches(form, syntax, "unquote-splicing")) {
            tr.error('w', "unquote-splicing inside quasisyntax is deprecated - use unsyntax-splicing or #@,", (pair instanceof PairWithPosition) ? ((PairWithPosition)pair) : tr);
            return true;
        }
        return false;
    }
    
    @Override
    protected boolean matchesQuasiQuote(final Object form, final SyntaxForm syntax, final Translator tr) {
        return tr.matches(form, syntax, "quasisyntax");
    }
    
    @Override
    protected boolean expandColonForms() {
        return false;
    }
    
    @Override
    public Expression rewriteForm(Pair form, final Translator tr) {
        if (!(form.getCdr() instanceof Pair) || (form = (Pair)form.getCdr()).getCdr() != LList.Empty) {
            return tr.syntaxError("syntax forms requires a single form");
        }
        final Declaration saveTemplateScopeDecl = tr.templateScopeDecl;
        if (saveTemplateScopeDecl == null) {
            tr.letStart();
            final Expression init = new ApplyExp(kawa.standard.syntax.makeTemplateScopeMethod, Expression.noExpressions);
            final Declaration templateScopeDecl = tr.letVariable(null, kawa.standard.syntax.typeTemplateScope, init);
            templateScopeDecl.setCanRead();
            tr.templateScopeDecl = templateScopeDecl;
            tr.letEnter();
        }
        try {
            final Expression body = this.coerceExpression(this.expand(form.getCar(), this.isQuasi ? 1 : -1, tr), tr);
            return (saveTemplateScopeDecl == null) ? tr.letDone(body) : body;
        }
        finally {
            tr.templateScopeDecl = saveTemplateScopeDecl;
        }
    }
    
    @Override
    protected Expression leaf(final Object val, final Translator tr) {
        return makeSyntax(val, tr);
    }
    
    static Expression makeSyntax(final Object form, final Translator tr) {
        final SyntaxTemplate template = new SyntaxTemplate(form, null, SyntaxRule.dots3Symbol, tr);
        Expression matchArray = QuoteExp.nullExp;
        final PatternScope patternScope = tr.patternScope;
        if (patternScope != null && patternScope.matchArray != null) {
            matchArray = new ReferenceExp(patternScope.matchArray);
        }
        final Expression[] args = { new QuoteExp(template), matchArray, new ReferenceExp(tr.templateScopeDecl) };
        return new ApplyExp(ClassType.make("kawa.lang.SyntaxTemplate").getDeclaredMethod("execute", new Type[] { null, kawa.standard.syntax.typeTemplateScope }), args);
    }
    
    static {
        syntax = new syntax("syntax", false);
        quasiSyntax = new syntax("quasisyntax", true);
        typeTemplateScope = ClassType.make("kawa.lang.TemplateScope");
        makeTemplateScopeMethod = kawa.standard.syntax.typeTemplateScope.getDeclaredMethod("make", 0);
    }
}
