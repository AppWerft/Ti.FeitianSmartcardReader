package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.mapping.Namespace;

public class BindingInitializer extends Initializer
{
  Declaration decl;
  Expression value;
  
  public static void create(Declaration decl, Expression value, Compilation comp)
  {
    BindingInitializer init = new BindingInitializer(decl, value);
    if (field != null ? field.getStaticFlag() : decl.isStatic())
    {
      next = clinitChain;
      clinitChain = init;
    }
    else
    {
      ModuleExp mod = comp.getModule();
      next = initChain;
      initChain = init;
    }
  }
  
  public BindingInitializer(Declaration decl, Expression value)
  {
    this.decl = decl;
    this.value = value;
    field = field;
  }
  
  public void emit(Compilation comp)
  {
    if (decl.ignorable())
    {
      if (value != null)
        value.compile(comp, Target.Ignore);
      return;
    }
    CodeAttr code = comp.getCode();
    
    if ((value instanceof QuoteExp))
    {
      Object val = ((QuoteExp)value).getValue();
      if ((val != null) && (!(val instanceof String)))
      {
        Literal lit = litTable.findLiteral(val);
        if (field == field) {
          return;
        }
      }
    }
    int line = decl.getLineNumber();
    gnu.text.SourceMessages messages = comp.getMessages();
    gnu.text.SourceLocator saveLoc = messages.swapSourceLocator(decl);
    if (line > 0)
      code.putLineNumber(decl.getFileName(), line);
    if ((field != null) && (!field.getStaticFlag())) {
      code.emitPushThis();
    }
    if (value == null)
    {
      boolean func = comp.getLanguage().hasSeparateFunctionNamespace();
      Object property = (func) && (decl.isProcedureDecl()) ? gnu.mapping.EnvironmentKey.FUNCTION : null;
      

      Object name = decl.getSymbol();
      
      if (decl.getFlag(268500992L))
      {
        if ((name instanceof String))
          name = Namespace.EmptyNamespace.getSymbol((String)name);
        comp.compileConstant(name, Target.pushObject);
        if (property == null) {
          code.emitPushNull();
        } else
          comp.compileConstant(property, Target.pushObject);
        code.emitInvokeStatic(typeDynamicLocation.getDeclaredMethod("getInstance", 2));
      }
      else if (decl.isFluid())
      {



        Type[] atypes = new Type[1];
        atypes[0] = ((name instanceof gnu.mapping.Symbol) ? Compilation.typeSymbol : Type.toStringType);
        
        comp.compileConstant(name, Target.pushObject);
        gnu.bytecode.Method m = typeThreadLocation.getDeclaredMethod("makeAnonymous", atypes);
        
        code.emitInvokeStatic(m);
      }
      else
      {
        if ((name instanceof String))
          name = Namespace.EmptyNamespace.getSymbol(((String)name).intern());
        comp.compileConstant(name, Target.pushObject);
        code.emitInvokeStatic(Compilation.typeLocation.getDeclaredMethod("define", 1));
      }
    }
    else
    {
      Type type = field == null ? decl.getType() : field.getType();
      value.compileWithPosition(comp, StackTarget.getInstance(type));
    }
    

    if (field == null)
    {
      gnu.bytecode.Variable var = decl.getVariable();
      if (var == null)
        var = decl.allocateVariable(code, true);
      code.emitStore(var);
    }
    else if (field.getStaticFlag()) {
      code.emitPutStatic(field);
    } else {
      code.emitPutField(field); }
    messages.swapSourceLocator(saveLoc);
  }
  
  static final ClassType typeThreadLocation = ClassType.make("gnu.mapping.ThreadLocation");
  
  static final ClassType typeDynamicLocation = ClassType.make("gnu.mapping.DynamicLocation");
  

  public static gnu.bytecode.Method makeLocationMethod(Object name)
  {
    Type[] atypes = new Type[1];
    if ((name instanceof gnu.mapping.Symbol)) {
      atypes[0] = Compilation.typeSymbol;
    } else
      atypes[0] = Type.javalangStringType;
    return Compilation.typeLocation.getDeclaredMethod("make", atypes);
  }
}
