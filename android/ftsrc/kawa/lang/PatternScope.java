package kawa.lang;

import gnu.expr.Declaration;
import gnu.expr.LetExp;
import java.util.Vector;











public class PatternScope
  extends LetExp
{
  PatternScope previousSyntax;
  public Vector pattern_names;
  public StringBuffer patternNesting;
  public Declaration matchArray;
  
  public PatternScope() {}
  
  public static PatternScope push(Translator tr)
  {
    PatternScope newScope = new PatternScope();
    

    PatternScope oldScope = patternScope;
    previousSyntax = oldScope;
    patternScope = newScope;
    if (oldScope == null) {
      pattern_names = new Vector();
      patternNesting = new StringBuffer();
    } else {
      pattern_names = ((Vector)pattern_names.clone());
      patternNesting = new StringBuffer(patternNesting.toString());
    }
    
    newScope.setOuter(tr.currentScope());
    return newScope;
  }
  
  public static void pop(Translator tr) {
    patternScope = patternScope.previousSyntax;
  }
}
