package gnu.kawa.lispexpr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.kawa.reflect.LazyType;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Translator;

public class BracketApply extends kawa.lang.Syntax
{
  public static final BracketApply instance = new BracketApply();
  
  public BracketApply() {}
  
  public Expression rewrite(Object obj, Translator tr) { if (!(obj instanceof Pair))
      return tr.syntaxError("internal error - $bracket-apply$ missing functor");
    Pair pair = (Pair)obj;
    int length = LList.listLength(pair, false) - 1;
    Expression arg0 = tr.rewrite_car(pair, false);
    Object val = arg0.valueIfConstant();
    Object pairCdr = pair.getCdr();
    

    if ((length == 1) && (val == LangObjType.promiseType) && ((pairCdr instanceof Pair)))
    {
      Expression arg1 = tr.rewrite_car((Pair)pairCdr, false);
      Object val1 = arg1.valueIfConstant();
      if ((val1 instanceof Type))
        return new QuoteExp(LazyType.getInstance(LazyType.lazyType, (Type)val1)); }
    Class clas;
    Class clas;
    if ((val instanceof Class)) {
      clas = (Class)val; } else { Class clas;
      if ((val instanceof ObjectType)) {
        Type rtype = ((ObjectType)val).getRawType();
        clas = rtype.getReflectClass();
      } else {
        clas = null; } }
    if ((length > 0) && (clas != null)) {
      java.lang.reflect.TypeVariable[] vars = clas.getTypeParameters();
      if (vars.length != length)
        return tr.syntaxError("expected " + vars.length + " parameters for type " + val);
      Type[] params = new Type[length];
      for (int i = 0; i < length; i++) {
        Pair pp = (Pair)pairCdr;
        Expression arg1 = tr.rewrite_car(pp, false);
        Type type1 = tr.getLanguage().getTypeFor(arg1, false);
        gnu.bytecode.TypeVariable tvar = gnu.bytecode.TypeVariable.make(vars[i]);
        if (type1 == null) {
          tr.errorWithPosition("unrecognized parameter type " + pp.getCar(), pp);
          
          type1 = Type.objectType;
        }
        else {
          int comp = tvar.compare(type1);
          Language language = tr.getLanguage();
          if (comp < 0)
            tr.error('e', "type parameter " + tvar.getName() + " must extend " + language.formatType(tvar.getRawType()) + " which is incompatible with " + language.formatType(type1));
        }
        params[i] = type1;
        pairCdr = pp.getCdr();
      }
      if (((val instanceof GenArrayType)) && (length == 1)) {
        int rank = ((GenArrayType)val).rank();
        return new QuoteExp(new GenArrayType(rank, params[0]));
      }
      return new QuoteExp(new gnu.bytecode.ParameterizedType((ClassType)ClassType.make(clas), params));
    }
    if (pair.getCdr() != LList.Empty)
      return tr.syntaxError("unrecognized syntax: type[args]");
    if ((val instanceof Type))
      return new QuoteExp(ArrayType.make((Type)val));
    if ((val instanceof Class))
    {
      Class cls = (Class)val;
      return new QuoteExp(new ArrayType(ClassType.make(cls)).getReflectClass());
    }
    Type typ = tr.getLanguage().getTypeFor(arg0, false);
    if (typ != null)
      return new QuoteExp(ArrayType.make(typ));
    return tr.syntaxError("[] syntax not implemented for non-constant: " + arg0 + "::" + arg0.getClass().getName());
  }
}
