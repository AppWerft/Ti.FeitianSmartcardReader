package gnu.q2.lang;

import gnu.expr.ReferenceExp;
import gnu.kawa.reflect.FieldLocation;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;

public class Operator extends Syntax
{
  int lprio;
  int rprio;
  Object function;
  int flags;
  static final int RHS_NEEDED = 2;
  static final int ASSIGN_OP = 4;
  public static final Operator FENCE = new Operator("<fence>", 0, -1, 0, null);
  public static final Operator SEMI = new Operator(";", 1, 1, 0, null);
  public static final Operator PLUS = new Operator("+", 5, 5, 2, new StaticFieldLocation("gnu.kawa.functions.AddOp", "$Pl"));
  

  public static final Operator MINUS = new Operator("-", 5, 5, 2, new StaticFieldLocation("gnu.kawa.functions.AddOp", "$Mn"));
  

  public static final Operator STAR = new Operator("*", 6, 6, 2, new StaticFieldLocation("gnu.kawa.functions.MultiplyOp", "$St"));
  

  public static final Operator SLASH = new Operator("/", 6, 6, 2, new StaticFieldLocation("gnu.kawa.functions.DivideOp", "$Sl"));
  

  public static final Operator LT = new Operator("<", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numLss"));
  

  public static final Operator GT = new Operator(">", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numGrt"));
  

  public static final Operator LE = new Operator("<=", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numLEq"));
  

  public static final Operator GE = new Operator(">=", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numGEq"));
  

  public static final Operator EQ = new Operator("==", 3, 3, 2, new StaticFieldLocation("kawa.standard.Scheme", "numEqu"));
  

  public static final Operator ASSIGN = new Operator(":=", 2, 2, 6, null);
  
  public static final Operator IF_THEN = new Operator("?>", 2, 2, 2, new StaticFieldLocation("kawa.lib.prim_syntax", "if"));
  



  public Operator(String name, int lprio, int rprio, int flags, Object function)
  {
    super(name);
    this.lprio = lprio;
    this.rprio = rprio;
    this.flags = flags;
    this.function = function;
  }
  
  public Object combine(Object largs, Object rargs, PairWithPosition op)
  {
    Object funop = null;
    
    if ((flags & 0x4) != 0)
    {
      funop = Symbol.valueOf("set!");
      LList args; LList args; if (((largs instanceof Pair)) && (((Pair)largs).getCdr() == LList.Empty))
      {
        ((Pair)largs).setCdrBackdoor(LList.list1(rargs));
        args = (Pair)largs;
      }
      else {
        args = LList.list2(largs, rargs); }
      return new PairWithPosition(op, funop, args);
    }
    if (this == SEMI)
    {
      funop = kawa.standard.begin.begin;
    }
    else if ((function instanceof FieldLocation))
    {
      funop = new ReferenceExp(Symbol.valueOf(getName()), ((FieldLocation)function).getDeclaration());
    }
    
    if ((largs == LList.Empty) && (rargs == LList.Empty))
    {
      return this == SEMI ? gnu.expr.QuoteExp.voidExp : funop; }
    LList args;
    LList args; if (largs == LList.Empty) {
      args = LList.list1(rargs); } else { LList args;
      if (rargs == LList.Empty) {
        args = LList.list1(largs);
      } else
        args = LList.list2(largs, rargs); }
    return new PairWithPosition(op, funop, args);
  }
  
  public String toString() { return "Operator[" + getName() + "]"; }
}
