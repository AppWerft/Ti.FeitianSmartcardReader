package kawa.standard;

import gnu.expr.Expression;
import gnu.lists.Pair;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRules;
import kawa.lang.Translator;

public class syntax_rules extends kawa.lang.Syntax
{
  public static final syntax_rules syntax_rules = new syntax_rules();
  static { syntax_rules.setName("syntax-rules"); }
  
  public Expression rewriteForm(Pair form, Translator tr) {
    Pair pair1 = (Pair)form.getCdr();
    
    Object car1 = pair1.getCar();
    Object cdr1 = pair1.getCdr();
    Object ellipsis = kawa.lang.SyntaxRule.dots3Symbol;
    if (((Translator.stripSyntax(car1) instanceof gnu.mapping.Symbol)) && ((cdr1 instanceof Pair)))
    {
      Pair pair2 = (Pair)cdr1;
      Object car2 = pair2.getCar();
      Object cdr2 = pair2.getCdr();
      if ((car2 instanceof gnu.lists.LList)) {
        ellipsis = car1;
        car1 = car2;
        cdr1 = cdr2;
      }
    }
    

    Object[] literal_identifiers = SyntaxPattern.getLiteralsList(car1, null, tr);
    
    SyntaxRules rules = new SyntaxRules(ellipsis, literal_identifiers, cdr1, tr);
    
    return new gnu.expr.QuoteExp(rules);
  }
  
  public syntax_rules() {}
}
