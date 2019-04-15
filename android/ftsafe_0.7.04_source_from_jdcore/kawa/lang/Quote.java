package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import java.util.IdentityHashMap;
import java.util.Vector;

public class Quote extends Syntax
{
  public static final Quote plainQuote = new Quote("quote", false);
  public static final Quote quasiQuote = new Quote("quasiquote", true);
  protected static final int QUOTE_DEPTH = -1;
  
  public Quote(String name, boolean isQuasi) { super(name);
    this.isQuasi = isQuasi;
  }
  
  protected boolean matchesUnquote(Pair pair, SyntaxForm syntax, Translator tr)
  {
    return tr.matches(pair.getCar(), syntax, "unquote");
  }
  
  protected boolean matchesUnquoteSplicing(Pair pair, SyntaxForm syntax, Translator tr)
  {
    return tr.matches(pair.getCar(), syntax, "unquote-splicing");
  }
  
  protected boolean matchesQuasiQuote(Object form, SyntaxForm syntax, Translator tr)
  {
    return tr.matches(form, syntax, "quasiquote");
  }
  



  protected boolean isQuasi;
  

  protected Object expand(Object template, int depth, Translator tr)
  {
    IdentityHashMap seen = new IdentityHashMap();
    


    return expand(template, depth, null, seen, tr);
  }
  

  public static Object quote(Object obj, Translator tr)
  {
    return plainQuote.expand(obj, -1, tr);
  }
  

  public static Object quote(Object obj)
  {
    return plainQuote.expand(obj, -1, (Translator)Compilation.getCurrent());
  }
  
  protected Expression coerceExpression(Object val, Translator tr) {
    return (val instanceof Expression) ? (Expression)val : leaf(val, tr);
  }
  
  protected Expression leaf(Object val, Translator tr) {
    return new QuoteExp(val);
  }
  
  protected boolean expandColonForms() {
    return true;
  }
  
  public static Symbol makeSymbol(Namespace ns, Object local) {
    String name;
    String name;
    if ((local instanceof CharSequence)) {
      name = ((CharSequence)local).toString();

    }
    else
    {

      name = (String)local; }
    return ns.getSymbol(name.intern());
  }
  
  Object expand_pair(Pair list, int depth, SyntaxForm syntax, Object seen, Translator tr)
  {
    Pair pair = list;
    
    Object rest;
    label650:
    Object car;
    for (;;)
    {
      rest = pair;
      

      Pair p1;
      
      Pair p2;
      
      if ((expandColonForms()) && (tr != null) && (pair == list) && (tr.matches(pair.getCar(), syntax, LispLanguage.lookup_sym)) && ((pair.getCdr() instanceof Pair)) && (((p1 = (Pair)pair.getCdr()) instanceof Pair)) && (((p2 = (Pair)p1.getCdr()) instanceof Pair)) && (p2.getCdr() == LList.Empty))
      {






        Expression part1 = tr.rewrite_car(p1, false);
        Expression part2 = tr.rewrite_car_for_lookup(p2);
        Namespace ns = tr.namespaceResolvePrefix(part1);
        Symbol sym = tr.namespaceResolve(ns, part2);
        if (sym != null) {
          Object cdr = sym;
          break label948; } if ((ns != null) && (depth == 1)) {
          Object cdr = new ApplyExp(quoteType.getDeclaredMethod("makeSymbol", 2), new Expression[] { QuoteExp.getInstance(ns), part2 });
          break label948;
        }
        if (((p1.getCar() instanceof gnu.mapping.SimpleSymbol)) && ((part2 instanceof QuoteExp)))
        {
          String s1 = ((QuoteExp)part2).getValue().toString();
          String s2 = p1.getCar().toString();
          Object cdr = Symbol.makeWithUnknownNamespace(s1, s2);
          break label948; }
        String combinedName = gnu.kawa.functions.CompileNamedPart.combineName(part1, part2);
        Object cdr;
        Object cdr; if (combinedName != null) {
          cdr = tr.getGlobalEnvironment().getSymbol(combinedName);
        } else
          cdr = pair;
        break label948;
      }
      if (depth >= 0)
        if (matchesQuasiQuote(pair.getCar(), syntax, tr)) {
          depth++; } else { boolean isUnquote;
          if (((isUnquote = matchesUnquote(pair, syntax, tr))) || (matchesUnquoteSplicing(pair, syntax, tr)))
          {
            depth--;
            Pair pair_cdr;
            if ((!(pair.getCdr() instanceof Pair)) || ((pair_cdr = (Pair)pair.getCdr()).getCdr() != LList.Empty) || ((depth == 0) && (!isUnquote)))
            {


              return tr.syntaxError("invalid used of " + pair.getCar() + " in quasiquote template"); }
            Pair pair_cdr;
            if (depth == 0) {
              Object cdr = tr.rewrite_car(pair_cdr, syntax);
              break label948;
            }
          }
        }
      if ((depth == 1) && ((pair.getCar() instanceof Pair))) {
        Object form = pair.getCar();
        SyntaxForm subsyntax = syntax;
        while ((form instanceof SyntaxForm)) {
          subsyntax = (SyntaxForm)form;
          form = subsyntax.getDatum();
        }
        int splicing = -1;
        if ((form instanceof Pair)) {
          Pair pform = (Pair)form;
          if (matchesUnquote(pform, subsyntax, tr)) {
            splicing = 0;
          } else if (matchesUnquoteSplicing(pform, subsyntax, tr))
            splicing = 1;
        }
        if (splicing >= 0) {
          form = ((Pair)form).getCdr();
          Vector vec = new Vector();
          Object cdr = null;
          
          for (;;)
          {
            if ((form instanceof SyntaxForm)) {
              subsyntax = (SyntaxForm)form;
              form = subsyntax.getDatum();
            }
            if (form == LList.Empty)
              break label650;
            if (!(form instanceof Pair)) break;
            vec.addElement(tr.rewrite_car((Pair)form, subsyntax));
            form = ((Pair)form).getCdr();
          }
          
          return tr.syntaxError("improper list argument to unquote");
          
          int nargs = vec.size() + 1;
          cdr = expand(pair.getCdr(), 1, syntax, seen, tr);
          if (nargs > 1) {
            Expression[] args = new Expression[nargs];
            vec.copyInto(args);
            args[(nargs - 1)] = coerceExpression(cdr, tr);
            Method method = splicing == 0 ? consXMethod : appendMethod;
            cdr = new ApplyExp(method, args);
          }
          rest = pair;
          break label948;
        }
      }
      car = expand(pair.getCar(), depth, syntax, seen, tr);
      if (car != pair.getCar()) break label854;
      rest = pair.getCdr();
      if (!(rest instanceof Pair)) break;
      IdentityHashMap map = (IdentityHashMap)seen;
      Object old = map.get(rest);
      if (old != null) break;
      map.put(rest, WORKING);
      pair = (Pair)rest;
    }
    

    Object cdr = expand(rest, depth, syntax, seen, tr);
    label854: Object cdr; if (cdr == rest) {
      return list;
      

      cdr = expand(pair.getCdr(), depth, syntax, seen, tr);
      if (((car instanceof Expression)) || ((cdr instanceof Expression))) {
        Expression[] args = new Expression[2];
        args[0] = coerceExpression(car, tr);
        args[1] = coerceExpression(cdr, tr);
        cdr = new ApplyExp(makePairMethod, args);
      }
      else {
        cdr = Translator.makePair(pair, car, cdr);
      }
    }
    
    label948:
    
    if (list == rest)
      return cdr;
    Pair p = list;
    Pair[] pairs = new Pair[20];
    int npairs = 0;
    for (;;) {
      if (npairs >= pairs.length) {
        Pair[] tmp = new Pair[2 * npairs];
        System.arraycopy(pairs, 0, tmp, 0, npairs);
        pairs = tmp;
      }
      pairs[(npairs++)] = p;
      if (p.getCdr() == rest)
        break;
      p = (Pair)p.getCdr();
    }
    Object result = (cdr instanceof Expression) ? LList.Empty : cdr;
    for (;;) { npairs--; if (npairs < 0) break;
      p = pairs[npairs];
      result = Translator.makePair(p, p.getCar(), result);
    }
    
    if ((cdr instanceof Expression)) {
      Expression[] args = new Expression[2];
      args[1] = ((Expression)cdr);
      if (npairs == 1)
      {
        args[0] = leaf(list.getCar(), tr);
        return new ApplyExp(makePairMethod, args);
      }
      args[0] = leaf(result, tr);
      return new ApplyExp(appendMethod, args);
    }
    
    return result;
  }
  

  private static final Object WORKING = new String("(working)");
  
  private static final Object SHARED = new String("(shared)");
  










  Object expand(Object template, int depth, SyntaxForm syntax, Object seen, Translator tr)
  {
    IdentityHashMap map = (IdentityHashMap)seen;
    Object old = map.get(template);
    if (old == WORKING) {
      map.put(template, SHARED);
      return template; }
    if (old == SHARED)
      return template;
    if (old != null)
      return old;
    map.put(template, WORKING);
    Object result;
    label369:
    Object result; if ((template instanceof Pair)) {
      result = expand_pair((Pair)template, depth, syntax, seen, tr); } else { Object result;
      if ((template instanceof SyntaxForm)) {
        syntax = (SyntaxForm)template;
        result = expand(syntax.getDatum(), depth, syntax, seen, tr); } else { Object result;
        if ((template instanceof FVector)) {
          FVector vector = (FVector)template;
          int n = vector.size();
          Object[] buffer = new Object[n];
          




          byte[] state = new byte[n];
          byte max_state = 0;
          for (int i = 0; i < n; i++) {
            Object element = vector.get(i);
            int element_depth = depth;
            Pair pair;
            if (((element instanceof Pair)) && (depth > -1) && (matchesUnquoteSplicing(pair = (Pair)element, syntax, tr))) { element_depth--; if (element_depth == 0)
              {
                Pair pair_cdr;
                
                if ((!(pair.getCdr() instanceof Pair)) || ((pair_cdr = (Pair)pair.getCdr()).getCdr() != LList.Empty))
                {
                  return tr.syntaxError("invalid used of " + pair.getCar() + " in quasiquote template"); }
                Pair pair_cdr;
                buffer[i] = tr.rewrite_car(pair_cdr, syntax);
                state[i] = 3;
                break label369; } }
            buffer[i] = expand(element, element_depth, syntax, seen, tr);
            if (buffer[i] == element) {
              state[i] = 0;
            } else if ((buffer[i] instanceof Expression)) {
              state[i] = 2;
            } else {
              state[i] = 1;
            }
            if (state[i] > max_state)
              max_state = state[i]; }
          Object result;
          if (max_state == 0) {
            result = vector; } else { Object result;
            if (max_state == 1) {
              result = FVector.makeConstant(buffer);
            } else {
              Expression[] args = new Expression[n];
              int firstSpliceArg = -1;
              for (int i = 0; i < n; i++) {
                if (state[i] == 3) {
                  args[i] = new ApplyExp(MakeSplice.quoteInstance, new Expression[] { (Expression)buffer[i] });
                }
                else
                  args[i] = coerceExpression(buffer[i], tr);
              }
              ApplyExp exp = makeInvokeMakeVector(args);
              firstSpliceArg = firstSpliceArg;
              result = exp;
            }
          }
        } else {
          result = template;
        } } }
    if ((template != result) && (map.get(template) == SHARED))
      tr.error('e', "cycle in non-literal data");
    map.put(template, result);
    
    return result;
  }
  
  private static ApplyExp makeInvokeMakeVector(Expression[] args) {
    return new ApplyExp(makeVectorMethod, args);
  }
  
  public Expression rewrite(Object obj, Translator tr) {
    Pair pair;
    if ((!(obj instanceof Pair)) || ((pair = (Pair)obj).getCdr() != LList.Empty))
    {
      return tr.syntaxError("wrong number of arguments to quote"); }
    Pair pair; return coerceExpression(expand(pair.getCar(), isQuasi ? 1 : -1, tr), tr);
  }
  
  public static Object consX$V(Object[] args)
  {
    return LList.consX(args);
  }
  
  public static Object append$V(Object[] args)
  {
    int count = args.length;
    if (count == 0)
      return LList.Empty;
    Object result = args[(count - 1)];
    int i = count - 1; for (;;) { i--; if (i < 0) break;
      Object list = args[i];
      Object copy = null;
      Pair last = null;
      SyntaxForm syntax = null;
      for (;;) {
        if ((list instanceof SyntaxForm)) {
          syntax = (SyntaxForm)list;
          list = syntax.getDatum();
        } else {
          if (list == LList.Empty)
            break;
          if (!(list instanceof Pair)) {
            if ((list instanceof gnu.expr.ErrorExp))
              return list;
            throw new Error("expected list in quasi-quote splicing");
          }
          Pair list_pair = (Pair)list;
          Object car = list_pair.getCar();
          if ((syntax != null) && (!(car instanceof SyntaxForm)))
            car = SyntaxForms.makeForm(car, syntax.getScope());
          Pair new_pair = new Pair(car, null);
          if (last == null) {
            copy = new_pair;
          } else
            last.setCdr(new_pair);
          last = new_pair;
          list = list_pair.getCdr();
        } }
      if (last != null) {
        last.setCdr(result);
        result = copy;
      }
    }
    return result;
  }
  
  static final ClassType quoteType = ClassType.make("kawa.lang.Quote");
  static final Method consXMethod = quoteType.getDeclaredMethod("consX$V", 1);
  static final Method appendMethod = quoteType.getDeclaredMethod("append$V", 1);
  static final Method makePairMethod = Compilation.typePair.getDeclaredMethod("make", 2);
  static final Method makeVectorMethod = ClassType.make("gnu.lists.FVector").getDeclaredMethod("makeConstant", 1);
}
