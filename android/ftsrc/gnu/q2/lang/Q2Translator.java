package gnu.q2.lang;

import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.LetExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import java.util.ArrayList;
import java.util.Stack;
import kawa.lang.Translator;
import kawa.standard.SchemeCompilation;

public class Q2Translator extends SchemeCompilation
{
  public Q2Translator(gnu.expr.Language language, gnu.text.SourceMessages messages, gnu.expr.NameLookup lexical)
  {
    super(language, messages, lexical);
  }
  






  public static Object partition(Object p, Translator tr)
  {
    Stack st = new Stack();
    st.add(Operator.FENCE);
    Object larg = p;
    Pair prev = null;
    
    for (;;)
    {
      if ((p instanceof kawa.lang.SyntaxForm)) {}
      
      Operator op = null;
      Pair pp;
      Pair pp; if (!(p instanceof Pair))
      {
        op = Operator.FENCE;
        pp = null;
      }
      else
      {
        pp = (Pair)p;
        Object obj = pp.getCar();
        if (((obj instanceof gnu.mapping.Symbol)) && (!Q2.instance.selfEvaluatingSymbol(obj)))
        {
          Expression func = tr.rewrite(obj, true);
          Declaration decl;
          Object value;
          if (((func instanceof ReferenceExp)) && ((decl = ((ReferenceExp)func).getBinding()) != null) && (((value = decl.getConstantValue()) instanceof Operator)))
          {


            op = (Operator)value;
          }
        }
      }
      if (op != null)
      {
        if (prev == null) {
          larg = LList.Empty;
        } else if ((p instanceof Pair))
          prev.setCdrBackdoor(LList.Empty);
        int stsz = st.size();
        Operator topop = (Operator)st.get(stsz - 1);
        while (lprio <= rprio)
        {
          gnu.lists.PairWithPosition oppair = (gnu.lists.PairWithPosition)st.get(stsz - 2);
          if (((flags & 0x2) != 0) && (larg == LList.Empty))
          {
            tr.error('e', "missing right operand after " + topop.getName(), oppair); }
          larg = topop.combine((LList)st.get(stsz - 3), larg, oppair);
          
          stsz -= 3;
          st.setSize(stsz);
          topop = (Operator)st.get(stsz - 1);
        }
        if (pp == null)
          break;
        st.add(larg);
        st.add(pp);
        st.add(op);
        larg = pp.getCdr();
        prev = null;
      }
      else {
        prev = pp; }
      p = pp.getCdr();
    }
    return larg;
  }
  
  public Expression makeBody(Expression[] exps) { int nlen = exps.length;
    for (int i = 0; i < nlen - 1; i++) {
      Expression exp = exps[i];
      if ((exp instanceof IfExp)) {
        IfExp iexp = (IfExp)exp;
        if (iexp.getElseClause() == null) {
          Expression[] rest = new Expression[nlen - i - 1];
          System.arraycopy(exps, i + 1, rest, 0, rest.length);
          iexp = new IfExp(iexp.getTest(), iexp.getThenClause(), makeBody(rest));
          
          iexp.setLine(exp);
          if (i == 0)
            return iexp;
          Expression[] init = new Expression[i + 1];
          System.arraycopy(exps, 0, init, 0, i);
          init[i] = iexp;
          return super.makeBody(init);
        }
      }
    }
    return super.makeBody(exps);
  }
  
  public void scanForm(Object st, gnu.expr.ScopeExp defs)
  {
    if ((st instanceof LList))
      st = partition(st, this);
    if (st != LList.Empty) {
      super.scanForm(st, defs);
    }
  }
  
  public Expression rewrite(Object exp, boolean function) {
    if (exp == LList.Empty)
      return QuoteExp.voidExp;
    return super.rewrite(exp, function);
  }
  
  public Expression rewrite_pair(Pair p, boolean function)
  {
    Object partitioned = partition(p, this);
    if ((partitioned instanceof Pair)) {
      Pair pair = (Pair)partitioned;
      Object p_car = pair.getCar();
      if (((p_car instanceof Pair)) && (((Pair)p_car).getCar() == gnu.kawa.lispexpr.LispLanguage.splice_sym))
      {
        return new ApplyExp(gnu.kawa.functions.MakeSplice.quoteInstance, new Expression[] { rewrite_car((Pair)((Pair)p_car).getCdr(), function) });
      }
      
      Expression exp = super.rewrite_pair(pair, function);
      ApplyExp app;
      if (((exp instanceof ApplyExp)) && (isApplyFunction((app = (ApplyExp)exp).getFunction())))
      {
        exp = convertApply(app);
      }
      return exp;
    }
    

    return rewrite(partitioned, function);
  }
  
  public static boolean applyNullary(Expression exp)
  {
    if ((exp instanceof ReferenceExp)) {
      Declaration decl = Declaration.followAliases(((ReferenceExp)exp).getBinding());
      
      if (decl != null) {
        if (decl.isProcedureDecl())
          return true;
        if ((decl.getFlag(2048L)) && (decl.getFlag(16384L)))
        {
          gnu.bytecode.Type type = decl.getType();
          if ("gnu.kawa.lispexpr.LangObjType" == type.getName())
            return true;
        }
      }
    }
    if ((exp instanceof QuoteExp)) {
      Object val = exp.valueIfConstant();
      return ((val instanceof gnu.bytecode.Type)) || ((val instanceof Class));
    }
    return false;
  }
  

  public static Expression convertApply(ApplyExp exp)
  {
    Expression[] args = exp.getArgs();
    int nargs = args.length;
    
    Expression arg0 = args[0];
    if ((nargs == 1) && (!applyNullary(arg0))) {
      if (((arg0 instanceof IfExp)) && (((IfExp)arg0).getElseClause() == null))
      {
        arg0 = new gnu.expr.BeginExp(args); }
      return arg0;
    }
    
    ArrayList<Expression> rargs = new ArrayList();
    
    LetExp let = null;
    for (int i = 0; i < nargs; i++) {
      Expression arg = exp.getArg(i);
      Expression barg;
      Expression barg; if (((arg instanceof LetExp)) && (arg.getFlag(2)) && (let == null))
      {

        barg = ((LetExp)arg).getBody();
      } else
        barg = arg;
      if ((barg instanceof ApplyExp)) {
        ApplyExp aarg = (ApplyExp)barg;
        if (aarg.isAppendValues()) {
          if (arg != barg)
            let = (LetExp)arg;
          int naarg = aarg.getArgCount();
          for (int j = 0; j < naarg; j++) {
            Expression xaarg = aarg.getArg(j);
            if ((xaarg instanceof gnu.expr.SetExp)) {
              xaarg = new ApplyExp(gnu.kawa.functions.MakeSplice.quoteInstance, new Expression[] { new gnu.expr.BeginExp(xaarg, QuoteExp.emptyExp) });
              
              if ((firstSpliceArg == -1) || (firstSpliceArg > j))
              {
                firstSpliceArg = j; }
            }
            rargs.add(xaarg);
          }
          continue;
        }
      }
      rargs.add(arg);
    }
    args = (Expression[])rargs.toArray(new Expression[rargs.size()]);
    gnu.mapping.Procedure proc = kawa.standard.Scheme.applyToArgs;
    exp.setFuncArgs(new QuoteExp(proc), args);
    if (let != null) {
      let.setBody(exp);
      return let;
    }
    return exp;
  }
}
