package gnu.commonlisp.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.Declaration;
import gnu.expr.NameLookup;
import gnu.expr.ReferenceExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Translator;

public class Lisp2Compilation extends Translator
{
  public Lisp2Compilation(gnu.expr.Language language, gnu.text.SourceMessages messages, NameLookup lexical)
  {
    super(language, messages, lexical);
  }
  

  public void emitPushBoolean(boolean value)
  {
    CodeAttr code = getCode();
    if (value) {
      code.emitGetStatic(ClassType.make("gnu.commonlisp.lang.Lisp2").getDeclaredField("TRUE"));
    } else
      code.emitGetStatic(gnu.expr.Compilation.scmListType.getDeclaredField("Empty"));
  }
  
  static final gnu.bytecode.Method isTrueMethod = ClassType.make("gnu.commonlisp.lang.Lisp2").getDeclaredMethod("isTrueLisp", 1);
  


  public Type asBooleanValue(gnu.expr.ConditionalTarget target, Type stackType)
  {
    if ((stackType instanceof gnu.bytecode.ObjectType)) {
      getCode().emitInvoke(isTrueMethod);
      stackType = Type.booleanType;
    }
    return stackType;
  }
  






  protected void rewriteBody(LList list)
  {
    if (list.isEmpty()) {
      return;
    }
    Object head = ((Pair)list).getCar();
    

    Object body = ((Pair)list).getCdr();
    
    if (((head instanceof Pair)) && (matches(((Pair)head).getCar(), "declare")))
    {
      Object decls = ((Pair)head).getCdr();
      


      letStart();
      
      while (decls != LList.Empty)
      {
        if ((!(decls instanceof Pair)) || (!(((Pair)decls).getCar() instanceof Pair)))
        {
          errorWithPosition("Arguments to declare must be proper lists", decls);
          break;
        }
        
        Pair declItem = (Pair)((Pair)decls).getCar();
        
        if (!(declItem.getCdr() instanceof Pair))
        {
          errorWithPosition("Bad declare syntax, expected a list but got something else.", declItem);
          break; }
        Object vars;
        Object vars;
        if (matches(declItem.getCar(), "type"))
        {

          declItem = (Pair)declItem.getCdr();
          
          if (!(declItem.getCdr() instanceof Pair)) {
            Object save = pushPositionOf(declItem);
            error('e', "A type specifier must be applied to at least one declaration.");
            popPositionOf(save);
            break;
          }
          
          vars = (Pair)declItem.getCdr();

        }
        else
        {

          vars = (Pair)declItem.getCdr();
        }
        


        while (vars != LList.Empty)
        {
          if (!(vars instanceof Pair)) {
            Object save = pushPositionOf(vars);
            error('e', "The variable list in a declare form must be a proper list.");
            popPositionOf(save);
            break;
          }
          
          Object var = ((Pair)vars).getCar();
          Declaration varDecl = (Declaration)lexical.get(var);
          if (varDecl != null)
          {
            Declaration aliasedDecl = new Declaration(varDecl.getSymbol());
            ReferenceExp ref = new ReferenceExp(varDecl);
            letVariable(aliasedDecl, ref);
            aliasedDecl.setType(exp2Type(declItem));
            aliasedDecl.setFlag(8192L);
            aliasedDecl.setFlag(262144L);
          }
          else
          {
            error('w', "No declaration seen for `" + var + "`");
          }
          vars = ((Pair)vars).getCdr();
        }
        decls = ((Pair)decls).getCdr();
      }
      letEnter();
      pushForm(letDone(super.rewrite_body(body)));
    } else {
      super.rewriteBody(list);
    }
  }
}
