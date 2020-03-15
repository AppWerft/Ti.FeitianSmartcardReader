// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.QuoteExp;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxPattern;
import gnu.lists.LList;
import gnu.mapping.Symbol;
import kawa.lang.SyntaxRule;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.lists.Pair;
import kawa.lang.Syntax;

public class syntax_rules extends Syntax
{
    public static final syntax_rules syntax_rules;
    
    @Override
    public Expression rewriteForm(final Pair form, final Translator tr) {
        final Pair pair1 = (Pair)form.getCdr();
        Object car1 = pair1.getCar();
        Object cdr1 = pair1.getCdr();
        Object ellipsis = SyntaxRule.dots3Symbol;
        if (Translator.stripSyntax(car1) instanceof Symbol && cdr1 instanceof Pair) {
            final Pair pair2 = (Pair)cdr1;
            final Object car2 = pair2.getCar();
            final Object cdr2 = pair2.getCdr();
            if (car2 instanceof LList) {
                ellipsis = car1;
                car1 = car2;
                cdr1 = cdr2;
            }
        }
        final Object[] literal_identifiers = SyntaxPattern.getLiteralsList(car1, null, tr);
        final SyntaxRules rules = new SyntaxRules(ellipsis, literal_identifiers, cdr1, tr);
        return new QuoteExp(rules);
    }
    
    static {
        (syntax_rules = new syntax_rules()).setName("syntax-rules");
    }
}
