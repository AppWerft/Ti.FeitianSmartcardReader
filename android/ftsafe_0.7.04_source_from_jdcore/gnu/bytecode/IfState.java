package gnu.bytecode;




public class IfState
{
  IfState previous;
  


  boolean doing_else;
  


  Label end_label;
  

  boolean andThenSet;
  


  public IfState(CodeAttr code)
  {
    this(code, new Label(code));
  }
  
  public IfState(CodeAttr code, Label endLabel)
  {
    previous = if_stack;
    if_stack = this;
    end_label = endLabel;
  }
}
