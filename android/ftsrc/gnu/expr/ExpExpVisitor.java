package gnu.expr;

import gnu.text.SourceLocator;


public abstract class ExpExpVisitor<D>
  extends ExpVisitor<Expression, D>
{
  public ExpExpVisitor() {}
  
  protected Expression update(Expression exp, Expression r)
  {
    return r;
  }
  
  protected Expression defaultValue(Expression r, D d)
  {
    return r;
  }
  
  public ErrorExp error(String msg)
  {
    return comp.syntaxError(msg);
  }
  

  public ErrorExp error(char severity, String message, SourceLocator location)
  {
    comp.error(severity, message, location);
    return new ErrorExp(message);
  }
}
