package kawa.lang;

public abstract interface SyntaxForm
{
  public abstract Object getDatum();
  
  public abstract TemplateScope getScope();
}
