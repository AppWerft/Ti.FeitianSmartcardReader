package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import kawa.lib.lists;

public class srfi1 extends ModuleBody
{
  public static final int $Pcprovide$Pcsrfi$Mn1 = 123;
  public static final int $Pcprovide$Pclist$Mnlib = 123;
  public static final ModuleMethod xcons;
  public static final ModuleMethod list$Mntabulate;
  public static final ModuleMethod cons$St;
  public static final ModuleMethod iota;
  public static final ModuleMethod circular$Mnlist;
  public static final ModuleMethod proper$Mnlist$Qu;
  public static final ModuleMethod dotted$Mnlist$Qu;
  public static final ModuleMethod circular$Mnlist$Qu;
  public static final ModuleMethod not$Mnpair$Qu;
  public static final ModuleMethod null$Mnlist$Qu;
  public static final ModuleMethod list$Eq;
  public static final ModuleMethod length$Pl;
  public static final ModuleMethod zip;
  public static gnu.expr.GenericProc first;
  public static gnu.expr.GenericProc second;
  public static gnu.expr.GenericProc third;
  public static gnu.expr.GenericProc fourth;
  public static final ModuleMethod fifth;
  public static final ModuleMethod sixth;
  public static final ModuleMethod seventh;
  public static final ModuleMethod eighth;
  public static final ModuleMethod ninth;
  public static final ModuleMethod tenth;
  public static final ModuleMethod car$Plcdr;
  public static final ModuleMethod take;
  public static final ModuleMethod drop;
  public static final ModuleMethod take$Ex;
  public static final ModuleMethod take$Mnright;
  public static final ModuleMethod drop$Mnright;
  public static final ModuleMethod drop$Mnright$Ex;
  public static final ModuleMethod split$Mnat;
  public static final ModuleMethod split$Mnat$Ex;
  public static final ModuleMethod last;
  public static final ModuleMethod last$Mnpair;
  public static final ModuleMethod unzip1;
  public static final ModuleMethod unzip2;
  public static final ModuleMethod unzip3;
  public static final ModuleMethod unzip4;
  public static final ModuleMethod unzip5;
  public static final ModuleMethod append$Ex;
  public static final ModuleMethod append$Mnreverse;
  public static final ModuleMethod append$Mnreverse$Ex;
  public static final ModuleMethod concatenate;
  public static final ModuleMethod concatenate$Ex;
  public static final ModuleMethod count;
  public static final ModuleMethod unfold$Mnright;
  public static final ModuleMethod unfold;
  public static final ModuleMethod fold;
  public static final ModuleMethod fold$Mnright;
  public static final ModuleMethod pair$Mnfold$Mnright;
  public static final ModuleMethod pair$Mnfold;
  public static final ModuleMethod reduce;
  public static final ModuleMethod reduce$Mnright;
  public static final ModuleMethod append$Mnmap;
  public static final ModuleMethod append$Mnmap$Ex;
  public static final ModuleMethod pair$Mnfor$Mneach;
  public static final ModuleMethod map$Ex;
  public static final ModuleMethod filter$Mnmap;
  public static gnu.kawa.functions.Map map$Mnin$Mnorder;
  public static final ModuleMethod filter;
  public static final ModuleMethod filter$Ex;
  public static final ModuleMethod partition;
  public static final ModuleMethod partition$Ex;
  public static final ModuleMethod remove;
  public static final ModuleMethod remove$Ex;
  public static final ModuleMethod delete;
  public static final ModuleMethod delete$Ex;
  public static final ModuleMethod delete$Mnduplicates;
  public static final ModuleMethod delete$Mnduplicates$Ex;
  public static final ModuleMethod alist$Mncons;
  public static final ModuleMethod alist$Mncopy;
  public static final ModuleMethod alist$Mndelete;
  public static final ModuleMethod alist$Mndelete$Ex;
  public static final ModuleMethod find;
  public static final ModuleMethod find$Mntail;
  public static final ModuleMethod take$Mnwhile;
  public static final ModuleMethod drop$Mnwhile;
  public static final ModuleMethod take$Mnwhile$Ex;
  public static final ModuleMethod span;
  public static final ModuleMethod span$Ex;
  public static final ModuleMethod jdField_break;
  public static final ModuleMethod break$Ex;
  public static final ModuleMethod any;
  public static final ModuleMethod every;
  public static final kawa.lang.Macro $Pcevery;
  public static final ModuleMethod list$Mnindex;
  public static final ModuleMethod lset$Ls$Eq;
  public static final ModuleMethod lset$Eq;
  public static final ModuleMethod lset$Mnadjoin;
  public static final ModuleMethod lset$Mnunion;
  public static final ModuleMethod lset$Mnunion$Ex;
  public static final ModuleMethod lset$Mnintersection;
  public static final ModuleMethod lset$Mnintersection$Ex;
  public static final ModuleMethod lset$Mndifference;
  public static final ModuleMethod lset$Mndifference$Ex;
  public static final ModuleMethod lset$Mnxor;
  public static final ModuleMethod lset$Mnxor$Ex;
  public static final ModuleMethod lset$Mndiff$Plintersection;
  public static final ModuleMethod lset$Mndiff$Plintersection$Ex;
  static final gnu.math.IntNum Lit0;
  static final gnu.math.IntNum Lit1;
  static final SimpleSymbol Lit2;
  public static srfi1 $instance;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28;
  static final SimpleSymbol Lit29;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31;
  static final SimpleSymbol Lit32;
  static final SimpleSymbol Lit33;
  static final SimpleSymbol Lit34;
  static final SimpleSymbol Lit35;
  static final SimpleSymbol Lit36;
  static final SimpleSymbol Lit37;
  static final SimpleSymbol Lit38;
  static final SimpleSymbol Lit39;
  static final SimpleSymbol Lit40;
  static final SimpleSymbol Lit41;
  static final SimpleSymbol Lit42;
  static final SimpleSymbol Lit43;
  static final SimpleSymbol Lit44;
  static final SimpleSymbol Lit45;
  static final SimpleSymbol Lit46;
  static final SimpleSymbol Lit47;
  static final SimpleSymbol Lit48;
  static final SimpleSymbol Lit49;
  static final SimpleSymbol Lit50;
  static final SimpleSymbol Lit51;
  static final SimpleSymbol Lit52;
  static final SimpleSymbol Lit53;
  static final SimpleSymbol Lit54;
  static final SimpleSymbol Lit55;
  static final SimpleSymbol Lit56;
  static final SimpleSymbol Lit57;
  static final SimpleSymbol Lit58;
  static final SimpleSymbol Lit59;
  static final SimpleSymbol Lit60;
  static final SimpleSymbol Lit61;
  static final SimpleSymbol Lit62;
  static final SimpleSymbol Lit63;
  static final SimpleSymbol Lit64;
  static final SimpleSymbol Lit65;
  static final SimpleSymbol Lit66;
  static final SimpleSymbol Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final SimpleSymbol Lit70;
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72;
  static final SimpleSymbol Lit73;
  static final SimpleSymbol Lit74;
  static final SimpleSymbol Lit75;
  static final SimpleSymbol Lit76;
  static final SimpleSymbol Lit77;
  static final SimpleSymbol Lit78;
  static final SimpleSymbol Lit79;
  static final SimpleSymbol Lit80;
  static final SimpleSymbol Lit81;
  static final SimpleSymbol Lit82;
  static final kawa.lang.SyntaxRules Lit83;
  static final SimpleSymbol Lit84;
  static final SimpleSymbol Lit85;
  static final SimpleSymbol Lit86;
  static final SimpleSymbol Lit87;
  static final SimpleSymbol Lit88;
  static final SimpleSymbol Lit89;
  static final SimpleSymbol Lit90;
  static final SimpleSymbol Lit91;
  static final SimpleSymbol Lit92;
  static final SimpleSymbol Lit93;
  static final SimpleSymbol Lit94;
  static final SimpleSymbol Lit95;
  static final SimpleSymbol Lit96;
  static final SimpleSymbol Lit97;
  static final Object[] Lit98;
  static final SimpleSymbol Lit99;
  static final SimpleSymbol Lit100;
  static final SimpleSymbol Lit101;
  static final SimpleSymbol Lit102;
  static final gnu.lists.PairWithPosition Lit103;
  static final SimpleSymbol Lit104 = Symbol.valueOf("cdr");
  
  public static Pair xcons(Object d, Object a)
  {
    return lists.cons(a, d);
  }
  
























  public static Object listTabulate(Object len, Procedure proc)
  {
    boolean x = !kawa.lib.numbers.isInteger(len); if (x ? x : gnu.kawa.functions.NumberCompare.$Ls(len, Lit0))
      throw gnu.expr.Special.reachedUnexpected;
    gnu.lists.EmptyList localEmptyList = LList.Empty;Object i = gnu.kawa.functions.AddOp.apply2(-1, len, Lit1);
    Object ans;
    return ans;
  }
  



























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (selector) {case 135:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 134: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 133: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 132: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 131: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 130: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 129: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 128: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 127: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 126: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 125: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 124: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 123: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 122: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 121: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 120: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 90: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 89: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 88: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 87: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 86: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 83: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 82: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 81: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 80: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 79: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 77: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 76: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 71: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 48: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 46: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 40: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 36: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); }
  public static Object cons$St(Object... args) { return LList.consX(args); }
  











  public static Object iota(gnu.math.IntNum count, gnu.math.Numeric start, gnu.math.Numeric step)
  {
    if (gnu.math.IntNum.compare(count, 0L) < 0) throw gnu.expr.Special.reachedUnexpected;
    try { Object localObject1; gnu.math.Numeric last$Mnval = gnu.kawa.lispexpr.LangObjType.coerceNumeric(localObject1 = gnu.mapping.Promise.force(gnu.kawa.functions.AddOp.apply2(1, start, gnu.kawa.functions.MultiplyOp.$St.apply2(gnu.math.IntNum.add(count, -1), step)), gnu.math.Numeric.class));
      gnu.lists.EmptyList localEmptyList = LList.Empty;gnu.math.Numeric localNumeric1 = last$Mnval;count = count;
      Object ans;
      Object val;
      return ans;
    }
    catch (ClassCastException localClassCastException)
    {
      gnu.math.IntNum count;
      throw new gnu.mapping.WrongType(
      


        localClassCastException, "last-val", -2, count);
    }
  }
  





















  public static Pair circularList$V(Object val1, Object[] argsArray)
  {
    LList localLList1;
    




















    LList vals = localLList1 = LList.makeList(argsArray, 0);
    Pair ans = lists.cons(val1, vals);
    try { lists.setCdr$Ex((Pair)(localObject = gnu.mapping.Promise.force(lastPair(ans), Pair.class)), ans);
      return ans;
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new gnu.mapping.WrongType(
        localClassCastException, "set-cdr!", 1, localObject);
    }
  }
  
  public static Object isProperList(Object x)
  {
    for (;;)
    {
      Object localObject1 = x;Object x = x;
      Object lag; if (lists.isPair(x)) {}
      try { x = lists.cdr((Pair)(localObject2 = gnu.mapping.Promise.force(x, Pair.class)));
        if (!lists.isPair(x)) {} } catch (ClassCastException localClassCastException2) { try { Object localObject3;
          Object localObject2 = lists.cdr((Pair)(localObject3 = gnu.mapping.Promise.force(x, Pair.class))); } catch (ClassCastException localClassCastException2) { Object x; Object lag; Object x; label123: throw new gnu.mapping.WrongType(localClassCastException2, "cdr", 1, lag); }
        try { lag = lists.cdr((Pair)(localObject4 = gnu.mapping.Promise.force(lag, Pair.class)));
          tmpTernaryOp = Boolean.FALSE;
          break label123; tmpTernaryOp = Boolean.FALSE;
          return lists.isNull(x) ? Boolean.TRUE : lists.isNull(x) ? Boolean.TRUE : Boolean.FALSE;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new gnu.mapping.WrongType(localClassCastException3, "cdr", 1, localObject4);
        }
        throw new gnu.mapping.WrongType(
        




          localClassCastException1, "cdr", 1, x);
      }
    }
  }
  


  public static Object isDottedList(Object x)
  {
    for (;;)
    {
      Object localObject1 = x;Object x = x;
      Object lag; if (lists.isPair(x)) {}
      try { x = lists.cdr((Pair)(localObject2 = gnu.mapping.Promise.force(x, Pair.class)));
        if (!lists.isPair(x)) {} } catch (ClassCastException localClassCastException2) { try { Object localObject3;
          Object localObject2 = lists.cdr((Pair)(localObject3 = gnu.mapping.Promise.force(x, Pair.class))); } catch (ClassCastException localClassCastException2) { Object x; Object lag; Object x; label123: throw new gnu.mapping.WrongType(localClassCastException2, "cdr", 1, lag); }
        try { lag = lists.cdr((Pair)(localObject4 = gnu.mapping.Promise.force(lag, Pair.class)));
          tmpTernaryOp = Boolean.FALSE;
          break label123; tmpTernaryOp = Boolean.TRUE;
          return lists.isNull(x) ? Boolean.FALSE : lists.isNull(x) ? Boolean.FALSE : Boolean.TRUE;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new gnu.mapping.WrongType(localClassCastException3, "cdr", 1, localObject4);
        }
        throw new gnu.mapping.WrongType(
        




          localClassCastException1, "cdr", 1, x);
      } } }
  
  public static Object isCircularList(Object x) { for (;;) { Object localObject1 = x;Object x = x;
      Object lag; if (lists.isPair(x)) {}
      try { x = lists.cdr((Pair)(localObject2 = gnu.mapping.Promise.force(x, Pair.class)));
        if (!lists.isPair(x)) {} } catch (ClassCastException localClassCastException2) { try { Object x;
          Object localObject3; Object localObject2 = lists.cdr((Pair)(localObject3 = gnu.mapping.Promise.force(x, Pair.class))); } catch (ClassCastException localClassCastException2) { Object localObject4; Object lag; Object x; throw new gnu.mapping.WrongType(localClassCastException2, "cdr", 1, lag); }
        try { lag = lists.cdr((Pair)(localObject4 = gnu.mapping.Promise.force(lag, Pair.class)));
          x = x == lag;tmpTernaryOp = lag; continue;tmpTernaryOp = Boolean.FALSE;return x ? Boolean.FALSE : x ? Boolean.TRUE : Boolean.FALSE;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new gnu.mapping.WrongType(localClassCastException3, "cdr", 1, x);
        }
        throw new gnu.mapping.WrongType(
        


          localClassCastException1, "cdr", 1, x); } } }
  
  public static boolean isNotPair(Object x) { return !lists.isPair(x); }
  









  public static boolean isNullList(Object l)
  {
    throw (l == LList.Empty ? 1 : (l instanceof Pair) ? 0 : gnu.expr.Special.reachedUnexpected);return kawa.lib.exceptions.error(new Object[] { "null-list?: argument out of domain", l });
  }
  























  public static Object length$Pl(Object x)
  {
    for (;;)
    {
      gnu.math.IntNum localIntNum = Lit0;Object localObject1 = x;Object x = x;
      Object len; Object lag; if (lists.isPair(x)) {}
      try { Object localObject3; Object localObject2 = lists.cdr((Pair)(localObject3 = gnu.mapping.Promise.force(x, Pair.class)));
        len = gnu.kawa.functions.AddOp.apply2(1, len, Lit1);
        if (!lists.isPair(x)) {} } catch (ClassCastException localClassCastException2) { try { Object x;
          Object localObject4 = lists.cdr((Pair)(localObject5 = gnu.mapping.Promise.force(x, Pair.class))); } catch (ClassCastException localClassCastException2) { Object len; Object localObject5; Object localObject6; Object lag; Object x; label124: throw new gnu.mapping.WrongType(localClassCastException2, "cdr", 1, lag); }
        try { localObject5 = lists.cdr((Pair)(localObject6 = gnu.mapping.Promise.force(lag, Pair.class)));
          len = gnu.kawa.functions.AddOp.apply2(1, len, Lit1);
          tmpTernaryOp = Boolean.FALSE;
          break label124;
          tmpTernaryOp = len;return len;
        } catch (ClassCastException localClassCastException3) {
          throw new gnu.mapping.WrongType(localClassCastException3, "cdr", 1, len);
        }
        throw new gnu.mapping.WrongType(localClassCastException1, "cdr", 1, len);
      }
    }
  }
  

  public static Object zip$V(Object list1, Object[] argsArray)
  {
    LList localLList1;
    
    LList more$Mnlists = localLList1 = LList.makeList(argsArray, 0);return kawa.standard.Scheme.apply.apply4(kawa.standard.Scheme.map, gnu.kawa.lispexpr.LangObjType.listType, list1, more$Mnlists);
  }
  




































  public static Object fifth(Object x)
  {
    try
    {
      return lists.car((Pair)(localObject = gnu.mapping.Promise.force(lists.cddddr(x), Pair.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "car", 1, localObject); } }
  public static Object sixth(Object x) { return lists.cadr(lists.cddddr(x)); }
  public static Object seventh(Object x) { return lists.caddr(lists.cddddr(x)); }
  public static Object eighth(Object x) { return lists.cadddr(lists.cddddr(x)); }
  public static Object ninth(Object x) { try { return lists.car((Pair)(localObject = gnu.mapping.Promise.force(lists.cddddr(lists.cddddr(x)), Pair.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "car", 1, localObject); } }
  public static Object tenth(Object x) { return lists.cadr(lists.cddddr(lists.cddddr(x))); }
  







  public static Object drop(Object lis, gnu.math.IntNum k)
  {
    for (;;)
    {
      gnu.math.IntNum localIntNum1 = k;Object lis = lis;
      try { gnu.math.IntNum k; tmpTernaryOp = (kawa.lib.numbers.isZero(k) ? lis : gnu.math.IntNum.add(k, -1); } catch (ClassCastException localClassCastException) { Object localObject1; throw new gnu.mapping.WrongType(localClassCastException, "cdr", 1, localObject1); } } return lists.cdr((Pair)(localObject1 = gnu.mapping.Promise.force(lis, Pair.class)));
  }
  
  public static Object take$Ex(Object lis, gnu.math.IntNum k) {
    try { lists.setCdr$Ex((Pair)(localObject = gnu.mapping.Promise.force(drop(lis, gnu.math.IntNum.add(k, -1)), Pair.class)), LList.Empty);
      return kawa.lib.numbers.isZero(k) ? LList.Empty : lis;
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new gnu.mapping.WrongType(
        localClassCastException, "set-cdr!", 1, localObject);
    }
  }
  







  public static Object dropRight(Object lis, gnu.math.IntNum k)
  {
    return lambda1recur(lis, drop(lis, k));
  }
  









































































  public static Object lastPair(Pair lis)
  {
    for (;;)
    {
      Object lis = lis;
      try { Object tail = lists.cdr((Pair)(localObject1 = gnu.mapping.Promise.force(lis, Pair.class)));
        return lis;
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject1;
        throw new gnu.mapping.WrongType(
          localClassCastException, "cdr", 1, localObject1);
      }
    }
  }
  


  public static Object unzip2(Object lis)
  {
    return lambda2recur(lis);
  }
  



  public static Object unzip3(Object lis)
  {
    return lambda3recur(lis);
  }
  




  public static Object unzip4(Object lis)
  {
    return lambda4recur(lis);
  }
  





  public static Object unzip5(Object lis)
  {
    return lambda5recur(lis);
  }
  




  public static Object append$Ex$V(Object[] argsArray)
  {
    LList localLList1;
    



    LList lists = localLList1 = LList.makeList(argsArray, 0);
    
    gnu.lists.EmptyList localEmptyList = LList.Empty;Object lists = lists;
    for (;;) { Object tail$Mncons;
      Object localObject7; Object rest; try { Object prev; Object localObject2; Object localObject1 = lists.car((Pair)(localObject2 = gnu.mapping.Promise.force(lists, Pair.class))); } catch (ClassCastException localClassCastException1) { Object localObject3; Object rest; Object first; Object localObject4; Object rest; Object localObject6; Object localObject5; Object next; throw new gnu.mapping.WrongType(
        





          localClassCastException1, "car", 1, rest);
      }
      try
      {
        rest = lists.cdr((Pair)(localObject3 = gnu.mapping.Promise.force(lists, Pair.class)));
        if (!lists.isPair(first)) { tmpTernaryOp = first;
        }
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new gnu.mapping.WrongType(localClassCastException2, "cdr", 1, tail$Mncons);
      }
      try
      {
        localObject4 = rest;tail$Mncons = lastPair((Pair)(localObject3 = gnu.mapping.Promise.force(first, Pair.class)));
        
        if (!lists.isPair(rest)) {}
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new gnu.mapping.WrongType(localClassCastException3, "last-pair", 0, tail$Mncons);
      }
      try {
        localObject5 = lists.car((Pair)(localObject6 = gnu.mapping.Promise.force(rest, Pair.class))); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "car", 1, rest); }
      try { rest = lists.cdr((Pair)(localObject7 = gnu.mapping.Promise.force(rest, Pair.class))); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "cdr", 1, localObject7); }
      try { lists.setCdr$Ex((Pair)(localObject7 = gnu.mapping.Promise.force(tail$Mncons, Pair.class)), next);
        if (!lists.isPair(next)) {}
      }
      catch (ClassCastException localClassCastException6)
      {
        throw new gnu.mapping.WrongType(localClassCastException6, "set-cdr!", 1, localObject7); }
      try { tmpTernaryOp = lastPair((Pair)(localObject7 = gnu.mapping.Promise.force(next, Pair.class)));
        tmpTernaryOp = rest;
      }
      catch (ClassCastException localClassCastException7)
      {
        throw new gnu.mapping.WrongType(localClassCastException7, "last-pair", 0, localObject7);
      }
    }
    return !lists.isPair(lists) ? prev : first;
  }
  


























  public static Object appendReverse$Ex(Object rev$Mnhead, Object tail)
  {
    for (;;)
    {
      Object localObject1 = tail;Object rev$Mnhead = rev$Mnhead;
      Object localObject2;
      try { next$Mnrev = lists.cdr((Pair)(localObject2 = gnu.mapping.Promise.force(rev$Mnhead, Pair.class))); } catch (ClassCastException localClassCastException1) { Object tail; Object next$Mnrev; throw new gnu.mapping.WrongType(
        
          localClassCastException1, "cdr", 1, localObject2);
      }
      try
      {
        lists.setCdr$Ex((Pair)(localObject2 = gnu.mapping.Promise.force(rev$Mnhead, Pair.class)), tail);
        tmpTernaryOp = (isNullList(rev$Mnhead) ? tail : rev$Mnhead;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new gnu.mapping.WrongType(localClassCastException2, "set-cdr!", 1, localObject2); } }
    return next$Mnrev;
  }
  
  public static Object concatenate(Object lists) { return reduceRight(kawa.standard.append.append, LList.Empty, lists); }
  public static Object concatenate$Ex(Object lists) { return reduceRight(append$Ex, LList.Empty, lists); }
  




























  static Object $PcCars$Pl(Object lists, Object lastElt)
  {
    frame36 $heapFrame = new frame36();last$Mnelt = lastElt;
    return $heapFrame.lambda47recur(lists); }
  public class frame36 extends ModuleBody { public frame36() {} public Object lambda47recur(Object lists) { if (lists.isPair(lists)) {} try { tmpTernaryOp = lists.cons(lists.caar(lists), lambda47recur(lists.cdr((Pair)(localObject = gnu.mapping.Promise.force(lists, Pair.class)))));return LList.list1(last$Mnelt); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "cdr", 1, localObject);
      }
    }
    
    Object last$Mnelt;
  }
  
  public class frame37 extends ModuleBody { kawa.lang.Continuation abort;
    
    public frame37() {}
    
    public Object lambda48recur(Object lists) { Values localValues1 = srfi1.car$PlCdr(lists);int i = 0;i = Values.incrPos(localValues1, i);Object localObject1 = Values.getFromPos(localValues1, i);i = Values.incrPos(localValues1, i);Object other$Mnlists = Values.getFromPosFinal(localValues1, i);
      Object list;
      Values localValues2 = srfi1.car$PlCdr(list);int j = 0;j = Values.incrPos(localValues2, j);Object localObject2 = Values.getFromPos(localValues2, j);j = Values.incrPos(localValues2, j);Object d = Values.getFromPosFinal(localValues2, j);
      Object a; Object localObject3 = lambda48recur(other$Mnlists);int k = 0;k = Values.incrPos(localObject3, k);Object localObject4 = Values.getFromPos(localObject3, k);k = Values.incrPos(localObject3, k);Object cdrs = Values.getFromPosFinal(localObject3, k);
      Object cars;
      return lists.isPair(lists) ? Values.values2(lists.cons(a, cars), lists.cons(d, cdrs)) : srfi1.isNullList(list) ? abort.apply2(LList.Empty, LList.Empty) : Values.values2(LList.Empty, LList.Empty);
    }
  }
  
  static Pair $PcCars$PlCdrs$SlPair(Object lists)
  {
    Object localObject1 = $PcCars$PlCdrs(lists);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object cdrs = Values.getFromPosFinal(localObject1, i);
    Object cars; return lists.cons(cars, cdrs);
  }
  
  public class frame39 extends ModuleBody {
    kawa.lang.Continuation abort;
    srfi1.frame38 staticLink;
    
    public frame39() {}
    
    public Object lambda49recur(Object lists) { Values localValues1 = srfi1.car$PlCdr(lists);int i = 0;i = Values.incrPos(localValues1, i);Object localObject1 = Values.getFromPos(localValues1, i);i = Values.incrPos(localValues1, i);Object other$Mnlists = Values.getFromPosFinal(localValues1, i);
      Object list;
      Values localValues2 = srfi1.car$PlCdr(list);int j = 0;j = Values.incrPos(localValues2, j);Object localObject2 = Values.getFromPos(localValues2, j);j = Values.incrPos(localValues2, j);Object d = Values.getFromPosFinal(localValues2, j);
      Object a; Object localObject3 = lambda49recur(other$Mnlists);int k = 0;k = Values.incrPos(localObject3, k);Object localObject4 = Values.getFromPos(localObject3, k);k = Values.incrPos(localObject3, k);Object cdrs = Values.getFromPosFinal(localObject3, k);
      Object cars;
      return lists.isPair(lists) ? Values.values2(lists.cons(a, cars), lists.cons(d, cdrs)) : srfi1.isNullList(list) ? abort.apply2(LList.Empty, LList.Empty) : Values.values2(LList.list1(staticLink.cars$Mnfinal), LList.Empty);
    }
  }
  
  static Object $PcCars$PlCdrs$SlNoTest(Object lists) { return lambda50recur(lists); }
  
  public static Object lambda50recur(Object lists) { Values localValues1 = car$PlCdr(lists);int i = 0;i = Values.incrPos(localValues1, i);Object localObject1 = Values.getFromPos(localValues1, i);i = Values.incrPos(localValues1, i);Object other$Mnlists = Values.getFromPosFinal(localValues1, i);
    Object list; Values localValues2 = car$PlCdr(list);int j = 0;j = Values.incrPos(localValues2, j);Object localObject2 = Values.getFromPos(localValues2, j);j = Values.incrPos(localValues2, j);Object d = Values.getFromPosFinal(localValues2, j);
    Object a; Object localObject3 = lambda50recur(other$Mnlists);int k = 0;k = Values.incrPos(localObject3, k);Object localObject4 = Values.getFromPos(localObject3, k);k = Values.incrPos(localObject3, k);Object cdrs = Values.getFromPosFinal(localObject3, k);
    Object cars;
    return lists.isPair(lists) ? Values.values2(lists.cons(a, cars), lists.cons(d, cdrs)) : Values.values2(LList.Empty, LList.Empty);
  }
  
  static Pair $PcCars$PlCdrs$SlNoTest$SlPair(Object lists) { Object localObject1 = $PcCars$PlCdrs$SlNoTest(lists);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object cdrs = Values.getFromPosFinal(localObject1, i);
    Object cars; return lists.cons(cars, cdrs);
  }
  
























  public static Object unfoldRight(Procedure p, Procedure f, Procedure g, Object seed, Object maybe$Mntail)
  {
    for (;;)
    {
      Object localObject1 = maybe$Mntail;Object seed = seed;
      
      Object ans;
      tmpTernaryOp = (gnu.expr.KawaConvert.isTrue(p.apply1(seed)) ? ans : lists.cons(f.apply1(seed), ans); } return g.apply1(seed);
  }
  






  public class frame
    extends ModuleBody
  {
    Procedure kons;
    





    Object knil;
    





    public frame() {}
    





    public Object lambda6recur(Object lists)
    {
      Object cdrs = srfi1.$PcCdrs(lists);
      
      return lists.isNull(cdrs) ? knil : kawa.standard.Scheme.apply.apply2(kons, srfi1.$PcCars$Pl(lists, lambda6recur(cdrs)));
    }
    
    /* Error */
    public Object lambda7recur(Object lis)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 43	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
      //   4: ifeq +10 -> 14
      //   7: aload_0
      //   8: getfield 18	gnu/kawa/slib/srfi1$frame:knil	Ljava/lang/Object;
      //   11: goto +44 -> 55
      //   14: aload_1
      //   15: ldc 45
      //   17: invokestatic 51	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   20: dup
      //   21: astore_3
      //   22: checkcast 45	gnu/lists/Pair
      //   25: invokestatic 64	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   28: astore_2
      //   29: aload_0
      //   30: getfield 28	gnu/kawa/slib/srfi1$frame:kons	Lgnu/mapping/Procedure;
      //   33: aload_2
      //   34: aload_0
      //   35: aload_1
      //   36: ldc 45
      //   38: invokestatic 51	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   41: dup
      //   42: astore_3
      //   43: checkcast 45	gnu/lists/Pair
      //   46: invokestatic 68	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   49: invokevirtual 71	gnu/kawa/slib/srfi1$frame:lambda7recur	(Ljava/lang/Object;)Ljava/lang/Object;
      //   52: invokevirtual 40	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   55: areturn
      //   56: new 55	gnu/mapping/WrongType
      //   59: dup_x1
      //   60: swap
      //   61: ldc 57
      //   63: iconst_1
      //   64: aload_3
      //   65: invokespecial 61	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   68: athrow
      //   69: new 55	gnu/mapping/WrongType
      //   72: dup_x1
      //   73: swap
      //   74: ldc 66
      //   76: iconst_1
      //   77: aload_3
      //   78: invokespecial 61	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   81: athrow
      // Line number table:
      //   Java source line #863	-> byte code offset #0
      //   Java source line #864	-> byte code offset #14
      //   Java source line #865	-> byte code offset #29
      //   Java source line #864	-> byte code offset #56
      //   Java source line #865	-> byte code offset #69
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	56	0	this	frame
      //   0	55	1	lis	Object
      //   28	6	2	head	Object
      //   21	57	3	localObject1	Object
      //   56	1	4	localClassCastException1	ClassCastException
      //   69	1	5	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   22	25	56	java/lang/ClassCastException
      //   43	46	69	java/lang/ClassCastException
    }
  }
  
  public static Object foldRight$V(Procedure kons, Object knil, Object lis1, Object[] argsArray)
  {
    frame $heapFrame = new frame();kons = kons;knil = knil; LList localLList1; LList lists = localLList1 = LList.makeList(argsArray, 0);
    





    return lists.isPair(lists) ? $heapFrame.lambda6recur(lists.cons(lis1, lists)) : $heapFrame.lambda7recur(lis1);
  }
  

  public static Object pairFoldRight$V(Procedure f, Object zero, Object lis1, Object[] argsArray)
  {
    frame0 $heapFrame = new frame0();f = f;zero = zero; LList localLList1; LList lists = localLList1 = LList.makeList(argsArray, 0);
    





    return lists.isPair(lists) ? $heapFrame.lambda8recur(lists.cons(lis1, lists)) : $heapFrame.lambda9recur(lis1);
  }
  
  public class frame0
    extends ModuleBody
  {
    Procedure f;
    Object zero;
    
    public frame0() {}
    
    public Object lambda8recur(Object lists)
    {
      Object cdrs = srfi1.$PcCdrs(lists);
      
      return lists.isNull(cdrs) ? zero : kawa.standard.Scheme.apply.apply2(f, srfi1.append$Ex$V(new Object[] { lists, LList.list1(lambda8recur(cdrs)) }));
    }
    
    public Object lambda9recur(Object lis) { try { return srfi1.isNullList(lis) ? zero : f.apply2(lis, lambda9recur(lists.cdr((Pair)(localObject = gnu.mapping.Promise.force(lis, Pair.class))))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "cdr", 1, localObject); } } }
  
  public static Object pairFold$V(Procedure f, Object zero, Object lis1, Object[] argsArray) { LList localLList1; LList lists = localLList1 = LList.makeList(argsArray, 0);
    
    Object localObject1 = zero;Object lists = lists.cons(lis1, lists);
    Object ans; Object tails = $PcCdrs(lists);
    
    for (;;)
    {
      ans = zero;Object lis = lis1;
      try { Object ans;
        Object tail = lists.cdr((Pair)(localObject2 = gnu.mapping.Promise.force(lis, Pair.class)));
        tmpTernaryOp = (isNullList(lis) ? ans : lists.isNull(tails) ? ans : f.apply2(lis, ans);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject2;
        throw new gnu.mapping.WrongType(
          localClassCastException, "cdr", 1, localObject2); } } return tail;
  }
  













  public static Object pairForEach$V(Procedure proc, Object lis1, Object[] argsArray)
  {
    LList localLList1;
    












    LList lists = localLList1 = LList.makeList(argsArray, 0);
    

    Object lists = lists.cons(lis1, lists);
    Object tails = $PcCdrs(lists);
    
    kawa.standard.Scheme.apply.apply2(proc, lists);
    
    for (;;)
    {
      Object lis = lis1;
      if (!isNullList(lis)) {}
      try { Object tail = lists.cdr((Pair)(localObject1 = gnu.mapping.Promise.force(lis, Pair.class)));
        proc.apply1(lis);
        tmpTernaryOp = tail;
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject1;
        throw new gnu.mapping.WrongType(
        
          localClassCastException, "cdr", 1, localObject1); } } return lists.isPair(lists) ? Values.empty : Values.empty;
  }
  

  public class frame2
    extends ModuleBody
  {
    Procedure f;
    
    final ModuleMethod lambda$Fn1;
    

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (selector == 1) { lambda11(paramObject);return Values.empty; } return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 1) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
    
    /* Error */
    void lambda11(Object pair)
    {
      // Byte code:
      //   0: aload_1
      //   1: ldc 2
      //   3: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   6: dup
      //   7: astore_2
      //   8: checkcast 2	gnu/lists/Pair
      //   11: aload_0
      //   12: getfield 24	gnu/kawa/slib/srfi1$frame2:f	Lgnu/mapping/Procedure;
      //   15: aload_1
      //   16: ldc 2
      //   18: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   21: dup
      //   22: astore_2
      //   23: checkcast 2	gnu/lists/Pair
      //   26: invokestatic 31	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   29: invokevirtual 37	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   32: invokestatic 41	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   35: return
      //   36: new 12	gnu/mapping/WrongType
      //   39: dup_x1
      //   40: swap
      //   41: ldc 14
      //   43: iconst_1
      //   44: aload_2
      //   45: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   48: athrow
      //   49: new 12	gnu/mapping/WrongType
      //   52: dup_x1
      //   53: swap
      //   54: ldc 26
      //   56: iconst_1
      //   57: aload_2
      //   58: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   61: athrow
      // Line number table:
      //   Java source line #948	-> byte code offset #0
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	36	0	this	frame2
      //   0	35	1	pair	Object
      //   7	51	2	localObject	Object
      //   36	1	3	localClassCastException1	ClassCastException
      //   49	1	4	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   8	11	36	java/lang/ClassCastException
      //   23	26	49	java/lang/ClassCastException
    }
    
    public frame2()
    {
      void tmp18_15 = new ModuleMethod(this, 1, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:948");
      lambda$Fn1 = tmp18_15;
    }
  }
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
    

















































































































































































































































































































































































































































































    first = lists.car;
    second = lists.cadr;
    third = lists.caddr;
    fourth = lists.cadddr;
    

































































































































































































































































































































































































































































































































    map$Mnin$Mnorder = kawa.standard.Scheme.map;
  }
  























































  public static Object filter$Ex(Procedure pred, Object lis)
  {
    for (;;)
    {
      Object ans = lis;
      try {
        if (gnu.expr.KawaConvert.isTrue(pred.apply1(lists.car((Pair)(localObject1 = gnu.mapping.Promise.force(ans, Pair.class)))))) {} } catch (ClassCastException localClassCastException2) { for (;;) { Object prev; Object prev; try { tmpTernaryOp = lists.cdr((Pair)(localObject1 = gnu.mapping.Promise.force(ans, Pair.class))); } catch (ClassCastException localClassCastException2) { Object localObject1; Object localObject2; Object lis; Object localObject3; Object localObject4; Object lis; Object lis; throw new gnu.mapping.WrongType(localClassCastException2, "cdr", 1, prev);
          }
          






          try
          {
            localObject2 = 
            











              lists.cdr((Pair)(localObject1 = gnu.mapping.Promise.force(ans, Pair.class)));prev = ans;
            if (!lists.isPair(lis)) {}




          }
          catch (ClassCastException localClassCastException3)
          {




            throw new gnu.mapping.WrongType(localClassCastException3, "cdr", 1, prev);
          }
          try
          {
            if (!gnu.expr.KawaConvert.isTrue(pred.apply1(lists.car((Pair)(localObject3 = gnu.mapping.Promise.force(lis, Pair.class)))))) {} } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(
            









              localClassCastException4, "car", 1, prev);
          }
          try
          {
            tmpTernaryOp = lists.cdr((Pair)(localObject3 = gnu.mapping.Promise.force(lis, Pair.class))); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "cdr", 1, prev); }
          try { tmpTernaryOp = lists.cdr((Pair)(localObject3 = gnu.mapping.Promise.force(lis, Pair.class)));
            localObject4 = prev;prev = lis;
            lis = lis;
            if (!lists.isPair(lis)) {}
          }
          catch (ClassCastException localClassCastException6)
          {
            throw new gnu.mapping.WrongType(localClassCastException6, "cdr", 1, prev);
          }
          try
          {
            if (!gnu.expr.KawaConvert.isTrue(pred.apply1(lists.car((Pair)(localObject5 = gnu.mapping.Promise.force(lis, Pair.class)))))) {} } catch (ClassCastException localClassCastException7) { throw new gnu.mapping.WrongType(localClassCastException7, "car", 1, localObject5); }
          try { lists.setCdr$Ex((Pair)(localObject5 = gnu.mapping.Promise.force(prev, Pair.class)), lis); } catch (ClassCastException localClassCastException8) { throw new gnu.mapping.WrongType(localClassCastException8, "set-cdr!", 1, localObject5); }
          try { tmpTernaryOp = lists.cdr((Pair)(localObject5 = gnu.mapping.Promise.force(lis, Pair.class))); } catch (ClassCastException localClassCastException9) { throw new gnu.mapping.WrongType(localClassCastException9, "cdr", 1, localObject5); }
          try { tmpTernaryOp = lists.cdr((Pair)(localObject5 = gnu.mapping.Promise.force(lis, Pair.class))); } catch (ClassCastException localClassCastException10) { throw new gnu.mapping.WrongType(localClassCastException10, "cdr", 1, localObject5); } }
        try { lists.setCdr$Ex((Pair)(localObject5 = gnu.mapping.Promise.force(prev, Pair.class)), lis);
          
          return isNullList(ans) ? ans : ans;
        }
        catch (ClassCastException localClassCastException11)
        {
          throw new gnu.mapping.WrongType(localClassCastException11, "set-cdr!", 1, localObject5);
        }
        throw new gnu.mapping.WrongType(
        























          localClassCastException1, "car", 1, prev);
      }
    }
  }
  





























  public class frame3
    extends ModuleBody
  {
    Object pred;
    




























    final ModuleMethod lambda$Fn2;
    





























    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (selector == 2) return lambda12(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 2) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda12(Object x) { return !gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.applyToArgs.apply2(pred, x)); } public frame3() { void tmp18_15 = new ModuleMethod(this, 2, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1186");
      lambda$Fn2 = tmp18_15; } } public static Object remove(Object pred, Object l) { frame3 $heapFrame = new frame3();pred = pred;return filter(lambda$Fn2, l); }
  public class frame4 extends ModuleBody { Object pred; final ModuleMethod lambda$Fn3; public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 3) return lambda13(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 3) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda13(Object x) { return !gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.applyToArgs.apply2(pred, x)); } public frame4() { void tmp18_15 = new ModuleMethod(this, 3, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1187");
      lambda$Fn3 = tmp18_15; } } public static Object remove$Ex(Object pred, Object l) { frame4 $heapFrame = new frame4();pred = pred;return filter$Ex(lambda$Fn3, l);
  }
  



  public class frame5
    extends ModuleBody
  {
    Object x;
    


    Object maybe$Mn$Eq;
    

    final ModuleMethod lambda$Fn4;
    


    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (selector == 4) return lambda14(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 4) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda14(Object y) { return !gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.applyToArgs.apply3(maybe$Mn$Eq, x, y));
    }
    
    public frame5()
    {
      void tmp18_15 = new ModuleMethod(this, 4, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1209");
      lambda$Fn4 = tmp18_15;
    }
  }
  
  public static Object delete(Object x, Object lis, Object maybe$Mn$Eq)
  {
    frame5 $heapFrame = new frame5();x = x;maybe$Mn$Eq = maybe$Mn$Eq;
    return filter(lambda$Fn4, lis);
  }
  
  public class frame6 extends ModuleBody { public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 5) return lambda15(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 5) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda15(Object y) { return !gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.applyToArgs.apply3(maybe$Mn$Eq, x, y));
    }
    
    Object x;
    Object maybe$Mn$Eq;
    final ModuleMethod lambda$Fn5;
    public frame6()
    {
      void tmp18_15 = new ModuleMethod(this, 5, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1212");
      lambda$Fn5 = tmp18_15;
    }
  }
  
  public static Object delete$Ex(Object x, Object lis, Object maybe$Mn$Eq)
  {
    frame6 $heapFrame = new frame6();x = x;maybe$Mn$Eq = maybe$Mn$Eq;
    return filter$Ex(lambda$Fn5, lis);
  }
  


















  public static Object deleteDuplicates(Object lis, Procedure maybe$Mn$Eq)
  {
    frame7 $heapFrame = new frame7();maybe$Mn$Eq = maybe$Mn$Eq;
    return $heapFrame.lambda16recur(lis);
  }
  


  public static Object deleteDuplicates$Ex(Object lis, Procedure maybe$Mn$Eq)
  {
    frame8 $heapFrame = new frame8();maybe$Mn$Eq = maybe$Mn$Eq;
    return $heapFrame.lambda17recur(lis);
  }
  











  public static Pair alistCons(Object key, Object datum, Object alist)
  {
    return lists.cons(lists.cons(key, datum), alist);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {} try { return iota(gnu.kawa.lispexpr.LangObjType.coerceIntNum(gnu.mapping.Promise.force(paramObject, gnu.math.IntNum.class))); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      



















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































        localClassCastException1, "iota", 1, paramObject);
    }
    return isProperList(paramObject);
    

















    return isDottedList(paramObject);
    









    return isCircularList(paramObject);
    







    return isNotPair(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    








    return isNullList(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    






























    return length$Pl(paramObject);
    






















































    return fifth(paramObject);
    return sixth(paramObject);
    return seventh(paramObject);
    return eighth(paramObject);
    return ninth(paramObject);
    return tenth(paramObject);
    
    return car$PlCdr(paramObject);
    









































































































    return last(paramObject);
    try {
      return lastPair((Pair)gnu.mapping.Promise.force(paramObject, Pair.class)); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "last-pair", 1, paramObject);
    }
    






    return unzip1(paramObject);
    
    return unzip2(paramObject);
    






    return unzip3(paramObject);
    







    return unzip4(paramObject);
    








    return unzip5(paramObject);
    
































































    return concatenate(paramObject);
    return concatenate$Ex(paramObject);
    

















































































































































































































































































































































































































































































































































    return deleteDuplicates(paramObject);
    






    return deleteDuplicates$Ex(paramObject);
    

















    return alistCopy(paramObject);return super.apply1(paramModuleMethod, paramObject);
  }
  
  public class frame9 extends ModuleBody { Object key;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 6) return lambda18(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 6) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda18(Object elt) { try { return !gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.applyToArgs.apply3(maybe$Mn$Eq, key, lists.car((Pair)(localObject = gnu.mapping.Promise.force(elt, Pair.class))))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "car", 1, localObject);
      }
    }
    
    Object maybe$Mn$Eq;
    final ModuleMethod lambda$Fn6;
    public frame9()
    {
      void tmp19_16 = new ModuleMethod(this, 6, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1267");
      lambda$Fn6 = tmp19_16;
    }
  }
  
  public static Object alistDelete(Object key, Object alist, Object maybe$Mn$Eq)
  {
    frame9 $heapFrame = new frame9();key = key;maybe$Mn$Eq = maybe$Mn$Eq;
    return filter(lambda$Fn6, alist);
  }
  
  public class frame10 extends ModuleBody { public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 7) return lambda19(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 7) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda19(Object elt) { try { return !gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.applyToArgs.apply3(maybe$Mn$Eq, key, lists.car((Pair)(localObject = gnu.mapping.Promise.force(elt, Pair.class))))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "car", 1, localObject);
      }
    }
    
    Object key;
    Object maybe$Mn$Eq;
    final ModuleMethod lambda$Fn7;
    public frame10()
    {
      void tmp19_16 = new ModuleMethod(this, 7, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1270");
      lambda$Fn7 = tmp19_16;
    }
  }
  
  public static Object alistDelete$Ex(Object key, Object alist, Object maybe$Mn$Eq)
  {
    frame10 $heapFrame = new frame10();key = key;maybe$Mn$Eq = maybe$Mn$Eq;
    return filter$Ex(lambda$Fn7, alist);
  }
  




  public static Object findTail(Procedure pred, Object list)
  {
    for (;;)
    {
      Object list = list;
      if (!isNullList(list)) {}
      Object localObject1; try { if (gnu.expr.KawaConvert.isTrue(pred.apply1(lists.car((Pair)(localObject1 = gnu.mapping.Promise.force(list, Pair.class)))))) tmpTernaryOp = list; } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
          localClassCastException1, "car", 1, localObject1); } try { tmpTernaryOp = lists.cdr((Pair)(localObject1 = gnu.mapping.Promise.force(list, Pair.class))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "cdr", 1, localObject1); } } return Boolean.FALSE; }
  
  public static Object takeWhile(Procedure pred, Object lis) { frame11 $heapFrame = new frame11();pred = pred;
    return $heapFrame.lambda20recur(lis);
  }
  

  public static Object dropWhile(Procedure pred, Object lis)
  {
    for (;;)
    {
      Object lis = lis;
      Object localObject1;
      try { if (!gnu.expr.KawaConvert.isTrue(pred.apply1(lists.car((Pair)(localObject1 = gnu.mapping.Promise.force(lis, Pair.class)))))) {} } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(localClassCastException1, "car", 1, localObject1); }
      try { tmpTernaryOp = lists.cdr((Pair)(localObject1 = gnu.mapping.Promise.force(lis, Pair.class))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "cdr", 1, localObject1);
      }
    }
    return isNullList(lis) ? LList.Empty : lis;
  }
  







  public static Object span(Procedure pred, Object lis)
  {
    for (;;)
    {
      gnu.lists.EmptyList localEmptyList = LList.Empty;Object lis = lis;
      Object res; if (isNullList(lis)) {}
      try { Object localObject1; tmpTernaryOp = Values.values2(lists.reverse$Ex((LList)(localObject1 = gnu.mapping.Promise.force(res, LList.class))), lis);
      } catch (ClassCastException localClassCastException2) { try { head = lists.car((Pair)(localObject2 = gnu.mapping.Promise.force(lis, Pair.class)));
          if (gnu.expr.KawaConvert.isTrue(pred.apply1(head))) {
            localObject2 = gnu.mapping.Promise.force(lis, Pair.class);
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          Object head;
          throw new gnu.mapping.WrongType(localClassCastException2, "car", 1, localObject2);
        }
        try { tmpTernaryOp = lists.cons(head, res); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "cdr", 1, localObject2); }
        try { return Values.values2(lists.reverse$Ex((LList)(localObject2 = gnu.mapping.Promise.force(res, LList.class))), lis); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "reverse!", 1, localObject2);
        }
        throw new gnu.mapping.WrongType(
        


          localClassCastException1, "reverse!", 1, head);
      }
    }
  }
  
  public class frame12
    extends ModuleBody
  {
    Object pred;
    final ModuleMethod lambda$Fn8;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (selector == 8) return lambda21(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 8) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda21(Object x) { return !gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.applyToArgs.apply2(pred, x)); } public frame12() { void tmp19_16 = new ModuleMethod(this, 8, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1330");
      lambda$Fn8 = tmp19_16; } } public static Object jdMethod_break(Object pred, Object lis) { frame12 $heapFrame = new frame12();pred = pred;return span(lambda$Fn8, lis); }
  public class frame13 extends ModuleBody { Object pred; final ModuleMethod lambda$Fn9; public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 9) return lambda22(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 9) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda22(Object x) { return !gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.applyToArgs.apply2(pred, x)); } public frame13() { void tmp19_16 = new ModuleMethod(this, 9, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1331");
      lambda$Fn9 = tmp19_16; } } public static Object break$Ex(Object pred, Object lis) { frame13 $heapFrame = new frame13();pred = pred;return span$Ex(lambda$Fn9, lis);
  }
  

























  public static Object listIndex$V(Procedure pred, Object lis1, Object[] argsArray)
  {
    LList localLList1;
    























    LList lists = localLList1 = LList.makeList(argsArray, 0);
    


    gnu.math.IntNum localIntNum1 = Lit0;Object lists = lists.cons(lis1, lists);
    gnu.math.IntNum n; localObject1 = $PcCars$PlCdrs(lists);int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);Object tails = Values.getFromPosFinal(localObject1, i);
    
    for (;;)
    {
      Object heads;
      
      n = Lit0;Object lis = lis1;
      gnu.math.IntNum n; if (!isNullList(lis)) {}
      try { localObject1 = gnu.mapping.Promise.force(lis, Pair.class); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(localClassCastException1, "car", 1, localObject1); } try { tmpTernaryOp = gnu.math.IntNum.add(n, 1); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "cdr", 1, localObject1); } } return lists.isPair(lists) ? Boolean.FALSE : gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.apply.apply2(pred, heads)) ? n : Boolean.FALSE;
  }
  





  public class frame40
    extends ModuleBody
  {
    Object $Eq;
    




    Object lis2;
    




    final ModuleMethod lambda$Fn33;
    




    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (selector == 33) return lambda51(paramObject); return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 33) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } Object lambda51(Object x) { try { return lists.member(x, lis2, (Procedure)(localObject = gnu.mapping.Promise.force($Eq, Procedure.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "member", 3, localObject); } } public frame40() { void tmp19_16 = new ModuleMethod(this, 33, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1430");
      lambda$Fn33 = tmp19_16; } } static Object $PcLset2$Ls$Eq(Object $Eq, Object lis1, Object lis2) { frame40 $heapFrame = new frame40();$Eq = $Eq;lis2 = lis2;return every$V(lambda$Fn33, lis1, new Object[0]);
  }
  




  public class frame14
    extends ModuleBody
  {
    Procedure $Eq;
    



    final ModuleMethod lambda$Fn10;
    




    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (selector == 10) return lambda23(paramObject1, paramObject2); return super.apply2(paramModuleMethod, paramObject1, paramObject2); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext) { if (selector == 10) { value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } Object lambda23(Object elt, Object ans) { return gnu.expr.KawaConvert.isTrue(lists.member(elt, ans, $Eq)) ? ans : lists.cons(elt, ans);
    }
    
    public frame14()
    {
      void tmp19_16 = new ModuleMethod(this, 10, null, 8194);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1453");
      lambda$Fn10 = tmp19_16;
    }
  }
  
  public static Object lsetAdjoin$V(Procedure $Eq, Object lis, Object[] argsArray)
  {
    frame14 $heapFrame = new frame14();$Eq = $Eq; LList localLList1; LList elts = localLList1 = LList.makeList(argsArray, 0);
    
    return fold$V(lambda$Fn10, lis, elts, new Object[0]);
  }
  
  public class frame15 extends ModuleBody {
    Procedure $Eq;
    final ModuleMethod lambda$Fn11;
    final ModuleMethod lambda$Fn12;
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) {
      switch (selector) {case 12:  return lambda25(paramObject1, paramObject2);
      case 13: 
        return lambda24(paramObject1, paramObject2); } return super.apply2(paramModuleMethod, paramObject1, paramObject2); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext) { switch (selector) {case 13:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
      


      case 12: 
        value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } Object lambda25(Object elt, Object ans) { void tmp7_4 = new srfi1.frame16();74staticLink = this;srfi1.frame16 $heapFrame = tmp7_4;elt = elt;
      
      return gnu.expr.KawaConvert.isTrue(srfi1.any$V(lambda$Fn13, ans, new Object[0])) ? ans : lists.cons(elt, ans); }
    Object lambda24(Object lis, Object ans) { return lis == ans ? ans : lists.isNull(ans) ? lis : lists.isNull(lis) ? ans : srfi1.fold$V(lambda$Fn12, ans, lis, new Object[0]);
    }
    
    public frame15()
    {
      void tmp19_16 = new ModuleMethod(this, 12, null, 8194);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1463");
      lambda$Fn12 = tmp19_16;
      void tmp45_42 = new ModuleMethod(this, 13, null, 8194);
      tmp45_42.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1458");
      lambda$Fn11 = tmp45_42;
    }
  }
  
  public static Object lsetUnion$V(Procedure $Eq, Object[] argsArray)
  {
    frame15 $heapFrame = new frame15();$Eq = $Eq; LList localLList1; LList lists = localLList1 = LList.makeList(argsArray, 0);
    








    return reduce(lambda$Fn11, LList.Empty, lists);
  }
  
  public class frame17 extends ModuleBody {
    Procedure $Eq;
    final ModuleMethod lambda$Fn14;
    final ModuleMethod lambda$Fn15;
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { switch (selector) {case 15:  return lambda28(paramObject1, paramObject2);
      case 16: 
        return lambda27(paramObject1, paramObject2); } return super.apply2(paramModuleMethod, paramObject1, paramObject2); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext) { switch (selector) {case 16:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
      


      case 15: 
        value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
    
    /* Error */
    Object lambda28(Object pair, Object ans)
    {
      // Byte code:
      //   0: new 8	gnu/kawa/slib/srfi1$frame18
      //   3: dup
      //   4: invokespecial 12	gnu/kawa/slib/srfi1$frame18:<init>	()V
      //   7: dup
      //   8: aload_0
      //   9: putfield 16	gnu/kawa/slib/srfi1$frame18:staticLink	Lgnu/kawa/slib/srfi1$frame17;
      //   12: astore_3
      //   13: aload_1
      //   14: ldc 18
      //   16: invokestatic 24	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   19: dup
      //   20: astore 4
      //   22: checkcast 18	gnu/lists/Pair
      //   25: invokestatic 36	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   28: aload_3
      //   29: swap
      //   30: putfield 40	gnu/kawa/slib/srfi1$frame18:elt	Ljava/lang/Object;
      //   33: aload_3
      //   34: getfield 44	gnu/kawa/slib/srfi1$frame18:lambda$Fn16	Lgnu/expr/ModuleMethod;
      //   37: aload_2
      //   38: iconst_0
      //   39: anewarray 46	java/lang/Object
      //   42: invokestatic 52	gnu/kawa/slib/srfi1:any$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   45: invokestatic 57	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   48: ifeq +7 -> 55
      //   51: aload_2
      //   52: goto +20 -> 72
      //   55: aload_1
      //   56: ldc 18
      //   58: invokestatic 24	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   61: dup
      //   62: astore 4
      //   64: checkcast 18	gnu/lists/Pair
      //   67: aload_2
      //   68: invokestatic 63	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   71: aload_1
      //   72: areturn
      //   73: new 28	gnu/mapping/WrongType
      //   76: dup_x1
      //   77: swap
      //   78: ldc 30
      //   80: iconst_1
      //   81: aload 4
      //   83: invokespecial 33	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   86: athrow
      //   87: new 28	gnu/mapping/WrongType
      //   90: dup_x1
      //   91: swap
      //   92: ldc 59
      //   94: iconst_1
      //   95: aload 4
      //   97: invokespecial 33	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   100: athrow
      // Line number table:
      //   Java source line #1475	-> byte code offset #0
      //   Java source line #1476	-> byte code offset #13
      //   Java source line #1477	-> byte code offset #33
      //   Java source line #1479	-> byte code offset #55
      //   Java source line #1476	-> byte code offset #73
      //   Java source line #1479	-> byte code offset #87
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	73	0	this	frame17
      //   0	72	1	pair	Object
      //   0	72	2	ans	Object
      //   12	22	3	$heapFrame	srfi1.frame18
      //   20	76	4	localObject	Object
      //   73	1	5	localClassCastException1	ClassCastException
      //   87	1	6	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   22	25	73	java/lang/ClassCastException
      //   64	67	87	java/lang/ClassCastException
    }
    
    Object lambda27(Object lis, Object ans)
    {
      return lis == ans ? ans : lists.isNull(ans) ? lis : lists.isNull(lis) ? ans : srfi1.pairFold$V(lambda$Fn15, ans, lis, new Object[0]);
    }
    
    public frame17()
    {
      void tmp19_16 = new ModuleMethod(this, 15, null, 8194);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1475");
      lambda$Fn15 = tmp19_16;
      void tmp45_42 = new ModuleMethod(this, 16, null, 8194);
      tmp45_42.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1470");
      lambda$Fn14 = tmp45_42;
    }
  }
  
  public static Object lsetUnion$Ex$V(Procedure $Eq, Object[] argsArray)
  {
    frame17 $heapFrame = new frame17();$Eq = $Eq; LList localLList1; LList lists = localLList1 = LList.makeList(argsArray, 0);
    










    return reduce(lambda$Fn14, LList.Empty, lists);
  }
  
  public class frame19 extends ModuleBody { Object lists;
    Procedure $Eq;
    final ModuleMethod lambda$Fn17;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 18) return lambda30(paramObject); return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 18) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } Object lambda30(Object x) { void tmp7_4 = new srfi1.frame20();74staticLink = this;srfi1.frame20 $heapFrame = tmp7_4;x = x;
      return srfi1.every$V(lambda$Fn18, lists, new Object[0]);
    }
    
    public frame19()
    {
      void tmp19_16 = new ModuleMethod(this, 18, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1488");
      lambda$Fn17 = tmp19_16;
    }
  }
  
  public static Object lsetIntersection$V(Procedure $Eq, Object lis1, Object[] argsArray)
  {
    frame19 $heapFrame = new frame19();$Eq = $Eq; LList localLList1; LList lists = localLList1 = LList.makeList(argsArray, 0);
    lists = delete(lis1, lists, kawa.standard.Scheme.isEq);
    



    return lists.isNull(lists) ? lis1 : gnu.expr.KawaConvert.isTrue(any$V(null$Mnlist$Qu, lists, new Object[0])) ? LList.Empty : filter(lambda$Fn17, lis1); }
  
  public class frame21 extends ModuleBody { Object lists;
    Procedure $Eq;
    final ModuleMethod lambda$Fn19;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 20) return lambda32(paramObject); return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 20) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } Object lambda32(Object x) { void tmp7_4 = new srfi1.frame22();74staticLink = this;srfi1.frame22 $heapFrame = tmp7_4;x = x;
      return srfi1.every$V(lambda$Fn20, lists, new Object[0]);
    }
    
    public frame21()
    {
      void tmp19_16 = new ModuleMethod(this, 20, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1496");
      lambda$Fn19 = tmp19_16;
    }
  }
  
  public static Object lsetIntersection$Ex$V(Procedure $Eq, Object lis1, Object[] argsArray)
  {
    frame21 $heapFrame = new frame21();$Eq = $Eq; LList localLList1; LList lists = localLList1 = LList.makeList(argsArray, 0);
    lists = delete(lis1, lists, kawa.standard.Scheme.isEq);
    



    return lists.isNull(lists) ? lis1 : gnu.expr.KawaConvert.isTrue(any$V(null$Mnlist$Qu, lists, new Object[0])) ? LList.Empty : filter$Ex(lambda$Fn19, lis1);
  }
  
  public class frame23 extends ModuleBody { Object lists;
    Procedure $Eq;
    final ModuleMethod lambda$Fn21;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 22) return lambda34(paramObject); return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 22) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } Object lambda34(Object x) { void tmp7_4 = new srfi1.frame24();74staticLink = this;srfi1.frame24 $heapFrame = tmp7_4;x = x;
      
      return srfi1.every$V(lambda$Fn22, lists, new Object[0]);
    }
    
    public frame23()
    {
      void tmp19_16 = new ModuleMethod(this, 22, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1505");
      lambda$Fn21 = tmp19_16;
    }
  }
  
  public static Object lsetDifference$V(Procedure $Eq, Object lis1, Object[] argsArray)
  {
    frame23 $heapFrame = new frame23();$Eq = $Eq; LList localLList1; LList lists = localLList1 = LList.makeList(argsArray, 0);
    lists = filter(lists.pair$Qu, lists);
    




    return gnu.expr.KawaConvert.isTrue(lists.memq(lis1, lists)) ? LList.Empty : lists.isNull(lists) ? lis1 : filter(lambda$Fn21, lis1); }
  
  public class frame25 extends ModuleBody { Object lists;
    Procedure $Eq;
    final ModuleMethod lambda$Fn23;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 24) return lambda36(paramObject); return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 24) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } Object lambda36(Object x) { void tmp7_4 = new srfi1.frame26();74staticLink = this;srfi1.frame26 $heapFrame = tmp7_4;x = x;
      
      return srfi1.every$V(lambda$Fn24, lists, new Object[0]);
    }
    
    public frame25()
    {
      void tmp19_16 = new ModuleMethod(this, 24, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1514");
      lambda$Fn23 = tmp19_16;
    }
  }
  
  public static Object lsetDifference$Ex$V(Procedure $Eq, Object lis1, Object[] argsArray)
  {
    frame25 $heapFrame = new frame25();$Eq = $Eq; LList localLList1; LList lists = localLList1 = LList.makeList(argsArray, 0);
    lists = filter(lists.pair$Qu, lists);
    




    return gnu.expr.KawaConvert.isTrue(lists.memq(lis1, lists)) ? LList.Empty : lists.isNull(lists) ? lis1 : filter$Ex(lambda$Fn23, lis1); }
  
  public class frame27 extends ModuleBody { Procedure $Eq;
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { if (selector == 26) return lambda38(paramObject1, paramObject2); return super.apply2(paramModuleMethod, paramObject1, paramObject2); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext) { if (selector == 26) { value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } Object lambda38(Object b, Object a) { void tmp7_4 = new srfi1.frame28();74staticLink = this;srfi1.frame28 $heapFrame = tmp7_4;
      








      Object localObject1 = srfi1.lsetDiff$PlIntersection$V($Eq, a, new Object[] { b });int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);a$Mnint$Mnb = Values.getFromPosFinal(localObject1, i);
      

      Object a$Mnb;
      

      return lists.isNull(a$Mnint$Mnb) ? kawa.standard.append.append$V(new Object[] { b, a }) : lists.isNull(a$Mnb) ? srfi1.lsetDifference$V($Eq, b, new Object[] { a }) : srfi1.fold$V(lambda$Fn26, a$Mnb, b, new Object[0]);
    }
    
    final ModuleMethod lambda$Fn25;
    public frame27()
    {
      void tmp19_16 = new ModuleMethod(this, 26, null, 8194);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1521");
      lambda$Fn25 = tmp19_16;
    }
  }
  
  public static Object lsetXor$V(Procedure $Eq, Object[] argsArray)
  {
    frame27 $heapFrame = new frame27();$Eq = $Eq; LList localLList1; LList lists = localLList1 = LList.makeList(argsArray, 0);
    
















    return reduce(lambda$Fn25, LList.Empty, lists); }
  
  public class frame29 extends ModuleBody { Procedure $Eq;
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { if (selector == 28) return lambda40(paramObject1, paramObject2); return super.apply2(paramModuleMethod, paramObject1, paramObject2); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext) { if (selector == 28) { value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } Object lambda40(Object b, Object a) { void tmp7_4 = new srfi1.frame30();74staticLink = this;srfi1.frame30 $heapFrame = tmp7_4;
      








      Object localObject1 = srfi1.lsetDiff$PlIntersection$Ex$V($Eq, a, new Object[] { b });int i = 0;i = Values.incrPos(localObject1, i);Object localObject2 = Values.getFromPos(localObject1, i);i = Values.incrPos(localObject1, i);a$Mnint$Mnb = Values.getFromPosFinal(localObject1, i);
      


      Object a$Mnb;
      

      return lists.isNull(a$Mnint$Mnb) ? srfi1.append$Ex$V(new Object[] { b, a }) : lists.isNull(a$Mnb) ? srfi1.lsetDifference$Ex$V($Eq, b, new Object[] { a }) : srfi1.pairFold$V(lambda$Fn28, a$Mnb, b, new Object[0]);
    }
    
    final ModuleMethod lambda$Fn27;
    public frame29()
    {
      void tmp19_16 = new ModuleMethod(this, 28, null, 8194);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1542");
      lambda$Fn27 = tmp19_16;
    }
  }
  
  public static Object lsetXor$Ex$V(Procedure $Eq, Object[] argsArray)
  {
    frame29 $heapFrame = new frame29();$Eq = $Eq; LList localLList1; LList lists = localLList1 = LList.makeList(argsArray, 0);
    

















    return reduce(lambda$Fn27, LList.Empty, lists); }
  
  public class frame31 extends ModuleBody { LList lists;
    Procedure $Eq;
    final ModuleMethod lambda$Fn29;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 30) return lambda42(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 30) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda42(Object elt) { void tmp7_4 = new srfi1.frame32();74staticLink = this;srfi1.frame32 $heapFrame = tmp7_4;elt = elt;
      
      return !gnu.expr.KawaConvert.isTrue(srfi1.any$V(lambda$Fn30, lists, new Object[0]));
    }
    
    public frame31()
    {
      void tmp19_16 = new ModuleMethod(this, 30, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1566");
      lambda$Fn29 = tmp19_16;
    }
  }
  
  public static Object lsetDiff$PlIntersection$V(Procedure $Eq, Object lis1, Object[] argsArray)
  {
    ;
    frame31 $heapFrame = new frame31();$Eq = $Eq; LList localLList1; lists = (localLList1 = LList.makeList(argsArray, 0));
    




    return gnu.expr.KawaConvert.isTrue(lists.memq(lis1, lists)) ? Values.values2(LList.Empty, lis1) : gnu.expr.KawaConvert.isTrue(every$V(null$Mnlist$Qu, lists, new Object[0])) ? Values.values2(lis1, LList.Empty) : partition(lambda$Fn29, lis1);
  }
  
  public class frame33 extends ModuleBody { LList lists;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 32) return lambda44(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 32) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda44(Object elt) { void tmp7_4 = new srfi1.frame34();74staticLink = this;srfi1.frame34 $heapFrame = tmp7_4;elt = elt;
      
      return !gnu.expr.KawaConvert.isTrue(srfi1.any$V(lambda$Fn32, lists, new Object[0]));
    }
    
    Procedure $Eq;
    final ModuleMethod lambda$Fn31;
    public frame33()
    {
      void tmp19_16 = new ModuleMethod(this, 32, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1574");
      lambda$Fn31 = tmp19_16;
    }
  }
  
  public static Object lsetDiff$PlIntersection$Ex$V(Procedure $Eq, Object lis1, Object[] argsArray)
  {
    ;
    frame33 $heapFrame = new frame33();$Eq = $Eq; LList localLList1; lists = (localLList1 = LList.makeList(argsArray, 0));
    




    return gnu.expr.KawaConvert.isTrue(lists.memq(lis1, lists)) ? Values.values2(LList.Empty, lis1) : gnu.expr.KawaConvert.isTrue(every$V(null$Mnlist$Qu, lists, new Object[0])) ? Values.values2(lis1, LList.Empty) : partition$Ex(lambda$Fn31, lis1);
  }
  
  public static Object iota(gnu.math.IntNum paramIntNum)
  {
    return iota(paramIntNum, Lit0, Lit1);
  }
  
  public static Object iota(gnu.math.IntNum paramIntNum, gnu.math.Numeric paramNumeric)
  {
    return iota(paramIntNum, paramNumeric, Lit1);
  }
  
  /* Error */
  public static Object list$Eq$V(Object $Eq, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 132	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 160	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   12: istore_3
    //   13: iload_3
    //   14: ifeq +19 -> 33
    //   17: iload_3
    //   18: ifeq +9 -> 27
    //   21: getstatic 163	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   24: goto +246 -> 270
    //   27: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   30: goto +240 -> 270
    //   33: aload_2
    //   34: dup
    //   35: astore 4
    //   37: checkcast 138	gnu/lists/Pair
    //   40: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   43: aload_2
    //   44: dup
    //   45: astore 4
    //   47: checkcast 138	gnu/lists/Pair
    //   50: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   53: astore 5
    //   55: astore 4
    //   57: aload 5
    //   59: invokestatic 160	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   62: istore 6
    //   64: iload 6
    //   66: ifeq +20 -> 86
    //   69: iload 6
    //   71: ifeq +9 -> 80
    //   74: getstatic 163	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   77: goto +193 -> 270
    //   80: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   83: goto +187 -> 270
    //   86: aload 5
    //   88: ldc -118
    //   90: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   93: dup
    //   94: astore 8
    //   96: checkcast 138	gnu/lists/Pair
    //   99: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   102: astore 7
    //   104: aload 5
    //   106: ldc -118
    //   108: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   111: dup
    //   112: astore 9
    //   114: checkcast 138	gnu/lists/Pair
    //   117: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   120: astore 8
    //   122: aload 4
    //   124: aload 7
    //   126: if_acmpne +10 -> 136
    //   129: aload 7
    //   131: aload 8
    //   133: goto -80 -> 53
    //   136: aload 4
    //   138: aload 7
    //   140: astore 10
    //   142: astore 9
    //   144: aload 9
    //   146: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   149: ifeq +24 -> 173
    //   152: aload 10
    //   154: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   157: ifeq +10 -> 167
    //   160: aload 10
    //   162: aload 8
    //   164: goto -111 -> 53
    //   167: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   170: goto +100 -> 270
    //   173: aload 10
    //   175: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   178: ifne +89 -> 267
    //   181: getstatic 178	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   184: aload_0
    //   185: aload 9
    //   187: ldc -118
    //   189: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   192: dup
    //   193: astore 11
    //   195: checkcast 138	gnu/lists/Pair
    //   198: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   201: aload 10
    //   203: ldc -118
    //   205: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   208: dup
    //   209: astore 11
    //   211: checkcast 138	gnu/lists/Pair
    //   214: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   217: invokevirtual 182	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   220: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   223: ifeq +38 -> 261
    //   226: aload 9
    //   228: ldc -118
    //   230: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   233: dup
    //   234: astore 11
    //   236: checkcast 138	gnu/lists/Pair
    //   239: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   242: aload 10
    //   244: ldc -118
    //   246: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   249: dup
    //   250: astore 11
    //   252: checkcast 138	gnu/lists/Pair
    //   255: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   258: goto -118 -> 140
    //   261: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   264: goto +6 -> 270
    //   267: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   270: areturn
    //   271: new 122	gnu/mapping/WrongType
    //   274: dup_x1
    //   275: swap
    //   276: ldc -89
    //   278: iconst_1
    //   279: aload 4
    //   281: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   284: athrow
    //   285: new 122	gnu/mapping/WrongType
    //   288: dup_x1
    //   289: swap
    //   290: ldc -107
    //   292: iconst_1
    //   293: aload 4
    //   295: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   298: athrow
    //   299: new 122	gnu/mapping/WrongType
    //   302: dup_x1
    //   303: swap
    //   304: ldc -89
    //   306: iconst_1
    //   307: aload 8
    //   309: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   312: athrow
    //   313: new 122	gnu/mapping/WrongType
    //   316: dup_x1
    //   317: swap
    //   318: ldc -107
    //   320: iconst_1
    //   321: aload 9
    //   323: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   326: athrow
    //   327: new 122	gnu/mapping/WrongType
    //   330: dup_x1
    //   331: swap
    //   332: ldc -89
    //   334: iconst_1
    //   335: aload 11
    //   337: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   340: athrow
    //   341: new 122	gnu/mapping/WrongType
    //   344: dup_x1
    //   345: swap
    //   346: ldc -89
    //   348: iconst_1
    //   349: aload 11
    //   351: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   354: athrow
    //   355: new 122	gnu/mapping/WrongType
    //   358: dup_x1
    //   359: swap
    //   360: ldc -107
    //   362: iconst_1
    //   363: aload 11
    //   365: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   368: athrow
    //   369: new 122	gnu/mapping/WrongType
    //   372: dup_x1
    //   373: swap
    //   374: ldc -107
    //   376: iconst_1
    //   377: aload 11
    //   379: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   382: athrow
    // Line number table:
    //   Java source line #401	-> byte code offset #0
    //   Java source line #402	-> byte code offset #8
    //   Java source line #404	-> byte code offset #33
    //   Java source line #405	-> byte code offset #57
    //   Java source line #406	-> byte code offset #86
    //   Java source line #407	-> byte code offset #104
    //   Java source line #408	-> byte code offset #122
    //   Java source line #409	-> byte code offset #129
    //   Java source line #410	-> byte code offset #136
    //   Java source line #411	-> byte code offset #144
    //   Java source line #412	-> byte code offset #152
    //   Java source line #413	-> byte code offset #160
    //   Java source line #414	-> byte code offset #173
    //   Java source line #415	-> byte code offset #184
    //   Java source line #416	-> byte code offset #226
    //   Java source line #404	-> byte code offset #271
    //   Java source line #406	-> byte code offset #299
    //   Java source line #407	-> byte code offset #313
    //   Java source line #415	-> byte code offset #327
    //   Java source line #416	-> byte code offset #355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	$Eq	Object
    //   0	270	1	argsArray	Object[]
    //   0	44	2	lists	LList
    //   6	1	3	localLList1	LList
    //   12	6	3	x	boolean
    //   35	11	4	localLList2	LList
    //   55	239	4	list$Mna	Object
    //   53	1	5	localObject1	Object
    //   57	48	5	others	Object
    //   62	8	6	x	boolean
    //   102	1	7	localObject2	Object
    //   122	17	7	list$Mnb	Object
    //   94	1	8	localObject3	Object
    //   120	188	8	others	Object
    //   112	1	9	localObject4	Object
    //   142	180	9	list$Mna	Object
    //   140	1	10	localObject5	Object
    //   144	99	10	list$Mnb	Object
    //   193	185	11	localObject6	Object
    //   271	1	19	localClassCastException1	ClassCastException
    //   285	1	20	localClassCastException2	ClassCastException
    //   299	1	21	localClassCastException3	ClassCastException
    //   313	1	22	localClassCastException4	ClassCastException
    //   327	1	23	localClassCastException5	ClassCastException
    //   341	1	24	localClassCastException6	ClassCastException
    //   355	1	25	localClassCastException7	ClassCastException
    //   369	1	26	localClassCastException8	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   37	40	271	java/lang/ClassCastException
    //   47	50	285	java/lang/ClassCastException
    //   96	99	299	java/lang/ClassCastException
    //   114	117	313	java/lang/ClassCastException
    //   195	198	327	java/lang/ClassCastException
    //   211	214	341	java/lang/ClassCastException
    //   236	239	355	java/lang/ClassCastException
    //   252	255	369	java/lang/ClassCastException
  }
  
  /* Error */
  public static Values car$PlCdr(Object pair)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc -118
    //   3: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore_1
    //   8: checkcast 138	gnu/lists/Pair
    //   11: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   14: aload_0
    //   15: ldc -118
    //   17: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   20: dup
    //   21: astore_1
    //   22: checkcast 138	gnu/lists/Pair
    //   25: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   28: invokestatic 242	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
    //   31: areturn
    //   32: new 122	gnu/mapping/WrongType
    //   35: dup_x1
    //   36: swap
    //   37: ldc -89
    //   39: iconst_1
    //   40: aload_1
    //   41: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   44: athrow
    //   45: new 122	gnu/mapping/WrongType
    //   48: dup_x1
    //   49: swap
    //   50: ldc -107
    //   52: iconst_1
    //   53: aload_1
    //   54: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   57: athrow
    // Line number table:
    //   Java source line #490	-> byte code offset #0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	pair	Object
    //   7	47	1	localObject	Object
    //   32	1	2	localClassCastException1	ClassCastException
    //   45	1	3	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   8	11	32	java/lang/ClassCastException
    //   22	25	45	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object take(Object lis, gnu.math.IntNum k)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   5: astore 4
    //   7: astore_3
    //   8: astore_2
    //   9: aload_3
    //   10: invokestatic 246	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   13: ifeq +22 -> 35
    //   16: aload 4
    //   18: ldc 62
    //   20: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   23: dup
    //   24: astore 5
    //   26: checkcast 62	gnu/lists/LList
    //   29: invokestatic 252	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   32: goto +46 -> 78
    //   35: aload_2
    //   36: ldc -118
    //   38: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   41: dup
    //   42: astore 5
    //   44: checkcast 138	gnu/lists/Pair
    //   47: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   50: aload_3
    //   51: iconst_m1
    //   52: invokestatic 101	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   55: aload_2
    //   56: ldc -118
    //   58: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   61: dup
    //   62: astore 5
    //   64: checkcast 138	gnu/lists/Pair
    //   67: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   70: aload 4
    //   72: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   75: goto -70 -> 5
    //   78: areturn
    //   79: new 122	gnu/mapping/WrongType
    //   82: dup_x1
    //   83: swap
    //   84: ldc -8
    //   86: iconst_1
    //   87: aload 5
    //   89: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   92: athrow
    //   93: new 122	gnu/mapping/WrongType
    //   96: dup_x1
    //   97: swap
    //   98: ldc -107
    //   100: iconst_1
    //   101: aload 5
    //   103: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   106: athrow
    //   107: new 122	gnu/mapping/WrongType
    //   110: dup_x1
    //   111: swap
    //   112: ldc -89
    //   114: iconst_1
    //   115: aload 5
    //   117: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   120: athrow
    // Line number table:
    //   Java source line #494	-> byte code offset #0
    //   Java source line #495	-> byte code offset #0
    //   Java source line #496	-> byte code offset #9
    //   Java source line #497	-> byte code offset #16
    //   Java source line #498	-> byte code offset #35
    //   Java source line #497	-> byte code offset #79
    //   Java source line #498	-> byte code offset #93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	lis	Object
    //   0	78	1	k	gnu.math.IntNum
    //   8	48	2	lis	Object
    //   7	1	3	localIntNum1	gnu.math.IntNum
    //   9	42	3	k	gnu.math.IntNum
    //   5	1	4	localEmptyList	gnu.lists.EmptyList
    //   9	62	4	res	Object
    //   24	92	5	localObject1	Object
    //   79	1	8	localClassCastException1	ClassCastException
    //   93	1	9	localClassCastException2	ClassCastException
    //   107	1	10	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   26	29	79	java/lang/ClassCastException
    //   44	47	93	java/lang/ClassCastException
    //   64	67	107	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object takeRight(Object lis, gnu.math.IntNum k)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: aload_1
    //   3: invokestatic 256	gnu/kawa/slib/srfi1:drop	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   6: astore_3
    //   7: astore_2
    //   8: aload_3
    //   9: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   12: ifeq +36 -> 48
    //   15: aload_2
    //   16: ldc -118
    //   18: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   21: dup
    //   22: astore 4
    //   24: checkcast 138	gnu/lists/Pair
    //   27: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   30: aload_3
    //   31: ldc -118
    //   33: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   36: dup
    //   37: astore 4
    //   39: checkcast 138	gnu/lists/Pair
    //   42: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   45: goto -39 -> 6
    //   48: aload_2
    //   49: areturn
    //   50: new 122	gnu/mapping/WrongType
    //   53: dup_x1
    //   54: swap
    //   55: ldc -107
    //   57: iconst_1
    //   58: aload 4
    //   60: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   63: athrow
    //   64: new 122	gnu/mapping/WrongType
    //   67: dup_x1
    //   68: swap
    //   69: ldc -107
    //   71: iconst_1
    //   72: aload 4
    //   74: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   77: athrow
    // Line number table:
    //   Java source line #513	-> byte code offset #0
    //   Java source line #514	-> byte code offset #0
    //   Java source line #515	-> byte code offset #8
    //   Java source line #516	-> byte code offset #15
    //   Java source line #515	-> byte code offset #48
    //   Java source line #516	-> byte code offset #50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	lis	Object
    //   0	49	1	k	gnu.math.IntNum
    //   7	42	2	lag	Object
    //   6	1	3	localObject1	Object
    //   8	23	3	lead	Object
    //   22	51	4	localObject2	Object
    //   50	1	6	localClassCastException1	ClassCastException
    //   64	1	7	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   24	27	50	java/lang/ClassCastException
    //   39	42	64	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object lambda1recur(Object lag, Object lead)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   4: ifeq +54 -> 58
    //   7: aload_0
    //   8: ldc -118
    //   10: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   13: dup
    //   14: astore_2
    //   15: checkcast 138	gnu/lists/Pair
    //   18: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   21: aload_0
    //   22: ldc -118
    //   24: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   27: dup
    //   28: astore_2
    //   29: checkcast 138	gnu/lists/Pair
    //   32: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   35: aload_1
    //   36: ldc -118
    //   38: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   41: dup
    //   42: astore_2
    //   43: checkcast 138	gnu/lists/Pair
    //   46: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   49: invokestatic 259	gnu/kawa/slib/srfi1:lambda1recur	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   55: goto +6 -> 61
    //   58: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   61: areturn
    //   62: new 122	gnu/mapping/WrongType
    //   65: dup_x1
    //   66: swap
    //   67: ldc -89
    //   69: iconst_1
    //   70: aload_2
    //   71: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   74: athrow
    //   75: new 122	gnu/mapping/WrongType
    //   78: dup_x1
    //   79: swap
    //   80: ldc -107
    //   82: iconst_1
    //   83: aload_2
    //   84: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   87: athrow
    //   88: new 122	gnu/mapping/WrongType
    //   91: dup_x1
    //   92: swap
    //   93: ldc -107
    //   95: iconst_1
    //   96: aload_2
    //   97: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   100: athrow
    // Line number table:
    //   Java source line #521	-> byte code offset #0
    //   Java source line #522	-> byte code offset #7
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	lag	Object
    //   0	61	1	lead	Object
    //   14	83	2	localObject	Object
    //   62	1	3	localClassCastException1	ClassCastException
    //   75	1	4	localClassCastException2	ClassCastException
    //   88	1	5	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   15	18	62	java/lang/ClassCastException
    //   29	32	75	java/lang/ClassCastException
    //   43	46	88	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object dropRight$Ex(Object lis, gnu.math.IntNum k)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 256	gnu/kawa/slib/srfi1:drop	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   5: astore_2
    //   6: aload_2
    //   7: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   10: ifeq +85 -> 95
    //   13: aload_0
    //   14: aload_2
    //   15: ldc -118
    //   17: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   20: dup
    //   21: astore_3
    //   22: checkcast 138	gnu/lists/Pair
    //   25: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   28: astore 4
    //   30: astore_3
    //   31: aload 4
    //   33: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   36: ifeq +37 -> 73
    //   39: aload_3
    //   40: ldc -118
    //   42: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   45: dup
    //   46: astore 5
    //   48: checkcast 138	gnu/lists/Pair
    //   51: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   54: aload 4
    //   56: ldc -118
    //   58: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   61: dup
    //   62: astore 5
    //   64: checkcast 138	gnu/lists/Pair
    //   67: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   70: goto -42 -> 28
    //   73: aload_3
    //   74: ldc -118
    //   76: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   79: dup
    //   80: astore 5
    //   82: checkcast 138	gnu/lists/Pair
    //   85: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   88: invokestatic 144	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   91: aload_0
    //   92: goto +6 -> 98
    //   95: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   98: areturn
    //   99: new 122	gnu/mapping/WrongType
    //   102: dup_x1
    //   103: swap
    //   104: ldc -107
    //   106: iconst_1
    //   107: aload_3
    //   108: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   111: athrow
    //   112: new 122	gnu/mapping/WrongType
    //   115: dup_x1
    //   116: swap
    //   117: ldc -107
    //   119: iconst_1
    //   120: aload 5
    //   122: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   125: athrow
    //   126: new 122	gnu/mapping/WrongType
    //   129: dup_x1
    //   130: swap
    //   131: ldc -107
    //   133: iconst_1
    //   134: aload 5
    //   136: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   139: athrow
    //   140: new 122	gnu/mapping/WrongType
    //   143: dup_x1
    //   144: swap
    //   145: ldc -116
    //   147: iconst_1
    //   148: aload 5
    //   150: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   153: athrow
    // Line number table:
    //   Java source line #527	-> byte code offset #0
    //   Java source line #528	-> byte code offset #0
    //   Java source line #529	-> byte code offset #6
    //   Java source line #531	-> byte code offset #13
    //   Java source line #532	-> byte code offset #31
    //   Java source line #533	-> byte code offset #39
    //   Java source line #534	-> byte code offset #73
    //   Java source line #535	-> byte code offset #91
    //   Java source line #531	-> byte code offset #99
    //   Java source line #533	-> byte code offset #112
    //   Java source line #534	-> byte code offset #140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	lis	Object
    //   0	98	1	k	gnu.math.IntNum
    //   5	10	2	lead	Object
    //   21	1	3	localObject1	Object
    //   30	78	3	lag	Object
    //   28	1	4	localObject2	Object
    //   31	24	4	lead	Object
    //   46	103	5	localObject3	Object
    //   99	1	8	localClassCastException1	ClassCastException
    //   112	1	9	localClassCastException2	ClassCastException
    //   126	1	10	localClassCastException3	ClassCastException
    //   140	1	11	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   22	25	99	java/lang/ClassCastException
    //   48	51	112	java/lang/ClassCastException
    //   64	67	126	java/lang/ClassCastException
    //   82	85	140	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object splitAt(Object x, gnu.math.IntNum k)
  {
    // Byte code:
    //   0: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   3: aload_0
    //   4: aload_1
    //   5: astore 4
    //   7: astore_3
    //   8: astore_2
    //   9: aload 4
    //   11: invokestatic 246	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   14: ifeq +25 -> 39
    //   17: aload_2
    //   18: ldc 62
    //   20: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   23: dup
    //   24: astore 5
    //   26: checkcast 62	gnu/lists/LList
    //   29: invokestatic 252	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   32: aload_3
    //   33: invokestatic 242	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
    //   36: goto +46 -> 82
    //   39: aload_3
    //   40: ldc -118
    //   42: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   45: dup
    //   46: astore 5
    //   48: checkcast 138	gnu/lists/Pair
    //   51: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   54: aload_2
    //   55: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   58: aload_3
    //   59: ldc -118
    //   61: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   64: dup
    //   65: astore 5
    //   67: checkcast 138	gnu/lists/Pair
    //   70: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   73: aload 4
    //   75: iconst_m1
    //   76: invokestatic 101	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   79: goto -74 -> 5
    //   82: areturn
    //   83: new 122	gnu/mapping/WrongType
    //   86: dup_x1
    //   87: swap
    //   88: ldc -8
    //   90: iconst_1
    //   91: aload 5
    //   93: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   96: athrow
    //   97: new 122	gnu/mapping/WrongType
    //   100: dup_x1
    //   101: swap
    //   102: ldc -89
    //   104: iconst_1
    //   105: aload 5
    //   107: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   110: athrow
    //   111: new 122	gnu/mapping/WrongType
    //   114: dup_x1
    //   115: swap
    //   116: ldc -107
    //   118: iconst_1
    //   119: aload 5
    //   121: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   124: athrow
    // Line number table:
    //   Java source line #583	-> byte code offset #0
    //   Java source line #584	-> byte code offset #0
    //   Java source line #585	-> byte code offset #9
    //   Java source line #586	-> byte code offset #17
    //   Java source line #587	-> byte code offset #39
    //   Java source line #586	-> byte code offset #83
    //   Java source line #587	-> byte code offset #97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	x	Object
    //   0	82	1	k	gnu.math.IntNum
    //   8	47	2	prefix	Object
    //   7	1	3	localObject1	Object
    //   9	50	3	suffix	Object
    //   5	1	4	localIntNum1	gnu.math.IntNum
    //   9	65	4	k	gnu.math.IntNum
    //   24	96	5	localObject2	Object
    //   83	1	8	localClassCastException1	ClassCastException
    //   97	1	9	localClassCastException2	ClassCastException
    //   111	1	10	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   26	29	83	java/lang/ClassCastException
    //   48	51	97	java/lang/ClassCastException
    //   67	70	111	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object splitAt$Ex(Object x, gnu.math.IntNum k)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 246	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   4: ifeq +13 -> 17
    //   7: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   10: aload_0
    //   11: invokestatic 242	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
    //   14: goto +52 -> 66
    //   17: aload_0
    //   18: aload_1
    //   19: iconst_m1
    //   20: invokestatic 101	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   23: invokestatic 256	gnu/kawa/slib/srfi1:drop	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   26: astore_2
    //   27: aload_2
    //   28: ldc -118
    //   30: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   33: dup
    //   34: astore 4
    //   36: checkcast 138	gnu/lists/Pair
    //   39: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   42: astore_3
    //   43: aload_2
    //   44: ldc -118
    //   46: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   49: dup
    //   50: astore 4
    //   52: checkcast 138	gnu/lists/Pair
    //   55: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   58: invokestatic 144	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   61: aload_0
    //   62: aload_3
    //   63: invokestatic 242	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
    //   66: areturn
    //   67: new 122	gnu/mapping/WrongType
    //   70: dup_x1
    //   71: swap
    //   72: ldc -107
    //   74: iconst_1
    //   75: aload 4
    //   77: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   80: athrow
    //   81: new 122	gnu/mapping/WrongType
    //   84: dup_x1
    //   85: swap
    //   86: ldc -116
    //   88: iconst_1
    //   89: aload 4
    //   91: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   94: athrow
    // Line number table:
    //   Java source line #589	-> byte code offset #0
    //   Java source line #590	-> byte code offset #0
    //   Java source line #591	-> byte code offset #17
    //   Java source line #592	-> byte code offset #27
    //   Java source line #593	-> byte code offset #43
    //   Java source line #594	-> byte code offset #61
    //   Java source line #592	-> byte code offset #67
    //   Java source line #593	-> byte code offset #81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	x	Object
    //   0	66	1	k	gnu.math.IntNum
    //   26	18	2	prev	Object
    //   42	21	3	suffix	Object
    //   34	56	4	localObject1	Object
    //   67	1	5	localClassCastException1	ClassCastException
    //   81	1	6	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   36	39	67	java/lang/ClassCastException
    //   52	55	81	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object last(Object lis)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc -118
    //   3: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore_1
    //   8: checkcast 138	gnu/lists/Pair
    //   11: invokestatic 136	gnu/kawa/slib/srfi1:lastPair	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   14: ldc -118
    //   16: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   19: dup
    //   20: astore_1
    //   21: checkcast 138	gnu/lists/Pair
    //   24: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   27: areturn
    //   28: new 122	gnu/mapping/WrongType
    //   31: dup_x1
    //   32: swap
    //   33: ldc_w 261
    //   36: iconst_0
    //   37: aload_1
    //   38: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   41: athrow
    //   42: new 122	gnu/mapping/WrongType
    //   45: dup_x1
    //   46: swap
    //   47: ldc -89
    //   49: iconst_1
    //   50: aload_1
    //   51: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   54: athrow
    // Line number table:
    //   Java source line #597	-> byte code offset #0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	lis	Object
    //   7	44	1	localObject	Object
    //   28	1	2	localClassCastException1	ClassCastException
    //   42	1	3	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   8	11	28	java/lang/ClassCastException
    //   21	24	42	java/lang/ClassCastException
  }
  
  /* Error */
  public static LList unzip1(Object lis)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 267	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   4: astore_1
    //   5: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   8: astore_2
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_1
    //   12: invokeinterface 273 1 0
    //   17: ifeq +56 -> 73
    //   20: aload_1
    //   21: invokeinterface 277 1 0
    //   26: astore 4
    //   28: new 138	gnu/lists/Pair
    //   31: dup
    //   32: aload 4
    //   34: ldc -118
    //   36: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   39: dup
    //   40: astore 6
    //   42: checkcast 138	gnu/lists/Pair
    //   45: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   48: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   51: invokespecial 280	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   54: aload_3
    //   55: ifnonnull +8 -> 63
    //   58: dup
    //   59: astore_2
    //   60: goto +9 -> 69
    //   63: aload_3
    //   64: swap
    //   65: dup_x1
    //   66: invokevirtual 284	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   69: astore_3
    //   70: goto -59 -> 11
    //   73: aload_2
    //   74: areturn
    //   75: new 122	gnu/mapping/WrongType
    //   78: dup_x1
    //   79: swap
    //   80: ldc -89
    //   82: iconst_1
    //   83: aload 6
    //   85: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   88: athrow
    // Line number table:
    //   Java source line #608	-> byte code offset #0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	lis	Object
    // Exception table:
    //   from	to	target	type
    //   42	45	75	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object lambda2recur(Object lis)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   4: ifeq +11 -> 15
    //   7: aload_0
    //   8: aload_0
    //   9: invokestatic 242	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
    //   12: goto +96 -> 108
    //   15: aload_0
    //   16: ldc -118
    //   18: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   21: dup
    //   22: astore_2
    //   23: checkcast 138	gnu/lists/Pair
    //   26: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   29: astore_1
    //   30: aload_0
    //   31: ldc -118
    //   33: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   36: dup
    //   37: astore_3
    //   38: checkcast 138	gnu/lists/Pair
    //   41: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   44: invokestatic 287	gnu/kawa/slib/srfi1:lambda2recur	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: astore_2
    //   48: iconst_0
    //   49: istore_3
    //   50: aload_2
    //   51: iload_3
    //   52: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   55: istore_3
    //   56: aload_2
    //   57: iload_3
    //   58: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   61: astore 4
    //   63: aload_2
    //   64: iload_3
    //   65: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   68: istore_3
    //   69: aload_2
    //   70: iload_3
    //   71: invokestatic 298	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   74: astore 5
    //   76: aload_1
    //   77: ldc -118
    //   79: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   82: dup
    //   83: astore 6
    //   85: checkcast 138	gnu/lists/Pair
    //   88: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   91: aload 4
    //   93: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   96: aload_1
    //   97: invokestatic 232	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: aload 5
    //   102: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   105: invokestatic 242	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
    //   108: areturn
    //   109: new 122	gnu/mapping/WrongType
    //   112: dup_x1
    //   113: swap
    //   114: ldc -89
    //   116: iconst_1
    //   117: aload_2
    //   118: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   121: athrow
    //   122: new 122	gnu/mapping/WrongType
    //   125: dup_x1
    //   126: swap
    //   127: ldc -107
    //   129: iconst_1
    //   130: aload_3
    //   131: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   134: athrow
    //   135: new 122	gnu/mapping/WrongType
    //   138: dup_x1
    //   139: swap
    //   140: ldc -89
    //   142: iconst_1
    //   143: aload 6
    //   145: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   148: athrow
    // Line number table:
    //   Java source line #612	-> byte code offset #0
    //   Java source line #613	-> byte code offset #15
    //   Java source line #614	-> byte code offset #30
    //   Java source line #615	-> byte code offset #76
    //   Java source line #616	-> byte code offset #96
    //   Java source line #613	-> byte code offset #109
    //   Java source line #614	-> byte code offset #122
    //   Java source line #615	-> byte code offset #135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	lis	Object
    //   29	68	1	elt	Object
    //   22	96	2	localObject1	Object
    //   37	1	3	localObject2	Object
    //   49	82	3	i	int
    //   61	1	4	localObject3	Object
    //   76	16	4	a	Object
    //   74	27	5	b	Object
    //   83	61	6	localObject4	Object
    //   109	1	9	localClassCastException1	ClassCastException
    //   122	1	10	localClassCastException2	ClassCastException
    //   135	1	11	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   23	26	109	java/lang/ClassCastException
    //   38	41	122	java/lang/ClassCastException
    //   85	88	135	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object lambda3recur(Object lis)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   4: ifeq +25 -> 29
    //   7: iconst_3
    //   8: anewarray 37	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_0
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: aload_0
    //   18: aastore
    //   19: dup
    //   20: iconst_2
    //   21: aload_0
    //   22: aastore
    //   23: invokestatic 305	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   26: goto +131 -> 157
    //   29: aload_0
    //   30: ldc -118
    //   32: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   35: dup
    //   36: astore_2
    //   37: checkcast 138	gnu/lists/Pair
    //   40: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   43: astore_1
    //   44: aload_0
    //   45: ldc -118
    //   47: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   50: dup
    //   51: astore_3
    //   52: checkcast 138	gnu/lists/Pair
    //   55: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   58: invokestatic 301	gnu/kawa/slib/srfi1:lambda3recur	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: astore_2
    //   62: iconst_0
    //   63: istore_3
    //   64: aload_2
    //   65: iload_3
    //   66: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   69: istore_3
    //   70: aload_2
    //   71: iload_3
    //   72: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   75: astore 4
    //   77: aload_2
    //   78: iload_3
    //   79: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   82: istore_3
    //   83: aload_2
    //   84: iload_3
    //   85: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   88: astore 5
    //   90: aload_2
    //   91: iload_3
    //   92: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   95: istore_3
    //   96: aload_2
    //   97: iload_3
    //   98: invokestatic 298	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   101: astore 6
    //   103: iconst_3
    //   104: anewarray 37	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_1
    //   110: ldc -118
    //   112: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   115: dup
    //   116: astore 7
    //   118: checkcast 138	gnu/lists/Pair
    //   121: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   124: aload 4
    //   126: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: aload_1
    //   133: invokestatic 232	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: aload 5
    //   138: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   141: aastore
    //   142: dup
    //   143: iconst_2
    //   144: aload_1
    //   145: invokestatic 234	kawa/lib/lists:caddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   148: aload 6
    //   150: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   153: aastore
    //   154: invokestatic 305	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   157: areturn
    //   158: new 122	gnu/mapping/WrongType
    //   161: dup_x1
    //   162: swap
    //   163: ldc -89
    //   165: iconst_1
    //   166: aload_2
    //   167: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   170: athrow
    //   171: new 122	gnu/mapping/WrongType
    //   174: dup_x1
    //   175: swap
    //   176: ldc -107
    //   178: iconst_1
    //   179: aload_3
    //   180: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   183: athrow
    //   184: new 122	gnu/mapping/WrongType
    //   187: dup_x1
    //   188: swap
    //   189: ldc -89
    //   191: iconst_1
    //   192: aload 7
    //   194: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   197: athrow
    // Line number table:
    //   Java source line #620	-> byte code offset #0
    //   Java source line #621	-> byte code offset #29
    //   Java source line #622	-> byte code offset #44
    //   Java source line #623	-> byte code offset #103
    //   Java source line #624	-> byte code offset #132
    //   Java source line #625	-> byte code offset #144
    //   Java source line #621	-> byte code offset #158
    //   Java source line #622	-> byte code offset #171
    //   Java source line #623	-> byte code offset #184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	lis	Object
    //   43	102	1	elt	Object
    //   36	131	2	localObject1	Object
    //   51	1	3	localObject2	Object
    //   63	117	3	i	int
    //   75	1	4	localObject3	Object
    //   103	22	4	a	Object
    //   88	1	5	localObject4	Object
    //   103	34	5	b	Object
    //   101	48	6	c	Object
    //   116	77	7	localObject5	Object
    //   158	1	11	localClassCastException1	ClassCastException
    //   171	1	12	localClassCastException2	ClassCastException
    //   184	1	13	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   37	40	158	java/lang/ClassCastException
    //   52	55	171	java/lang/ClassCastException
    //   118	121	184	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object lambda4recur(Object lis)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   4: ifeq +29 -> 33
    //   7: iconst_4
    //   8: anewarray 37	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_0
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: aload_0
    //   18: aastore
    //   19: dup
    //   20: iconst_2
    //   21: aload_0
    //   22: aastore
    //   23: dup
    //   24: iconst_3
    //   25: aload_0
    //   26: aastore
    //   27: invokestatic 305	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   30: goto +156 -> 186
    //   33: aload_0
    //   34: ldc -118
    //   36: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   39: dup
    //   40: astore_2
    //   41: checkcast 138	gnu/lists/Pair
    //   44: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   47: astore_1
    //   48: aload_0
    //   49: ldc -118
    //   51: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   54: dup
    //   55: astore_3
    //   56: checkcast 138	gnu/lists/Pair
    //   59: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   62: invokestatic 308	gnu/kawa/slib/srfi1:lambda4recur	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: astore_2
    //   66: iconst_0
    //   67: istore_3
    //   68: aload_2
    //   69: iload_3
    //   70: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   73: istore_3
    //   74: aload_2
    //   75: iload_3
    //   76: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   79: astore 4
    //   81: aload_2
    //   82: iload_3
    //   83: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   86: istore_3
    //   87: aload_2
    //   88: iload_3
    //   89: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   92: astore 5
    //   94: aload_2
    //   95: iload_3
    //   96: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   99: istore_3
    //   100: aload_2
    //   101: iload_3
    //   102: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   105: astore 6
    //   107: aload_2
    //   108: iload_3
    //   109: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   112: istore_3
    //   113: aload_2
    //   114: iload_3
    //   115: invokestatic 298	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   118: astore 7
    //   120: iconst_4
    //   121: anewarray 37	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload_1
    //   127: ldc -118
    //   129: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   132: dup
    //   133: astore 8
    //   135: checkcast 138	gnu/lists/Pair
    //   138: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   141: aload 4
    //   143: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload_1
    //   150: invokestatic 232	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: aload 5
    //   155: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   158: aastore
    //   159: dup
    //   160: iconst_2
    //   161: aload_1
    //   162: invokestatic 234	kawa/lib/lists:caddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   165: aload 6
    //   167: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   170: aastore
    //   171: dup
    //   172: iconst_3
    //   173: aload_1
    //   174: invokestatic 236	kawa/lib/lists:cadddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   177: aload 7
    //   179: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   182: aastore
    //   183: invokestatic 305	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   186: areturn
    //   187: new 122	gnu/mapping/WrongType
    //   190: dup_x1
    //   191: swap
    //   192: ldc -89
    //   194: iconst_1
    //   195: aload_2
    //   196: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   199: athrow
    //   200: new 122	gnu/mapping/WrongType
    //   203: dup_x1
    //   204: swap
    //   205: ldc -107
    //   207: iconst_1
    //   208: aload_3
    //   209: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   212: athrow
    //   213: new 122	gnu/mapping/WrongType
    //   216: dup_x1
    //   217: swap
    //   218: ldc -89
    //   220: iconst_1
    //   221: aload 8
    //   223: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   226: athrow
    // Line number table:
    //   Java source line #629	-> byte code offset #0
    //   Java source line #630	-> byte code offset #33
    //   Java source line #631	-> byte code offset #48
    //   Java source line #632	-> byte code offset #120
    //   Java source line #633	-> byte code offset #149
    //   Java source line #634	-> byte code offset #161
    //   Java source line #635	-> byte code offset #173
    //   Java source line #630	-> byte code offset #187
    //   Java source line #631	-> byte code offset #200
    //   Java source line #632	-> byte code offset #213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	lis	Object
    //   47	127	1	elt	Object
    //   40	156	2	localObject1	Object
    //   55	1	3	localObject2	Object
    //   67	142	3	i	int
    //   79	1	4	localObject3	Object
    //   120	22	4	a	Object
    //   92	1	5	localObject4	Object
    //   120	34	5	b	Object
    //   105	1	6	localObject5	Object
    //   120	46	6	c	Object
    //   118	60	7	d	Object
    //   133	89	8	localObject6	Object
    //   187	1	13	localClassCastException1	ClassCastException
    //   200	1	14	localClassCastException2	ClassCastException
    //   213	1	15	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   41	44	187	java/lang/ClassCastException
    //   56	59	200	java/lang/ClassCastException
    //   135	138	213	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object lambda5recur(Object lis)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   4: ifeq +33 -> 37
    //   7: iconst_5
    //   8: anewarray 37	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_0
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: aload_0
    //   18: aastore
    //   19: dup
    //   20: iconst_2
    //   21: aload_0
    //   22: aastore
    //   23: dup
    //   24: iconst_3
    //   25: aload_0
    //   26: aastore
    //   27: dup
    //   28: iconst_4
    //   29: aload_0
    //   30: aastore
    //   31: invokestatic 305	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   34: goto +195 -> 229
    //   37: aload_0
    //   38: ldc -118
    //   40: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   43: dup
    //   44: astore_2
    //   45: checkcast 138	gnu/lists/Pair
    //   48: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   51: astore_1
    //   52: aload_0
    //   53: ldc -118
    //   55: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   58: dup
    //   59: astore_3
    //   60: checkcast 138	gnu/lists/Pair
    //   63: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   66: invokestatic 311	gnu/kawa/slib/srfi1:lambda5recur	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: astore_2
    //   70: iconst_0
    //   71: istore_3
    //   72: aload_2
    //   73: iload_3
    //   74: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   77: istore_3
    //   78: aload_2
    //   79: iload_3
    //   80: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   83: astore 4
    //   85: aload_2
    //   86: iload_3
    //   87: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   90: istore_3
    //   91: aload_2
    //   92: iload_3
    //   93: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   96: astore 5
    //   98: aload_2
    //   99: iload_3
    //   100: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   103: istore_3
    //   104: aload_2
    //   105: iload_3
    //   106: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   109: astore 6
    //   111: aload_2
    //   112: iload_3
    //   113: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   116: istore_3
    //   117: aload_2
    //   118: iload_3
    //   119: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   122: astore 7
    //   124: aload_2
    //   125: iload_3
    //   126: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   129: istore_3
    //   130: aload_2
    //   131: iload_3
    //   132: invokestatic 298	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   135: astore 8
    //   137: iconst_5
    //   138: anewarray 37	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_1
    //   144: ldc -118
    //   146: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   149: dup
    //   150: astore 9
    //   152: checkcast 138	gnu/lists/Pair
    //   155: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   158: aload 4
    //   160: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: aload_1
    //   167: invokestatic 232	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   170: aload 5
    //   172: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload_1
    //   179: invokestatic 234	kawa/lib/lists:caddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   182: aload 6
    //   184: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   187: aastore
    //   188: dup
    //   189: iconst_3
    //   190: aload_1
    //   191: invokestatic 236	kawa/lib/lists:cadddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   194: aload 7
    //   196: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   199: aastore
    //   200: dup
    //   201: iconst_4
    //   202: aload_1
    //   203: invokestatic 230	kawa/lib/lists:cddddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   206: ldc -118
    //   208: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   211: dup
    //   212: astore 9
    //   214: checkcast 138	gnu/lists/Pair
    //   217: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   220: aload 8
    //   222: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   225: aastore
    //   226: invokestatic 305	gnu/mapping/Values:makeFromArray	([Ljava/lang/Object;)Lgnu/mapping/Values;
    //   229: areturn
    //   230: new 122	gnu/mapping/WrongType
    //   233: dup_x1
    //   234: swap
    //   235: ldc -89
    //   237: iconst_1
    //   238: aload_2
    //   239: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   242: athrow
    //   243: new 122	gnu/mapping/WrongType
    //   246: dup_x1
    //   247: swap
    //   248: ldc -107
    //   250: iconst_1
    //   251: aload_3
    //   252: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   255: athrow
    //   256: new 122	gnu/mapping/WrongType
    //   259: dup_x1
    //   260: swap
    //   261: ldc -89
    //   263: iconst_1
    //   264: aload 9
    //   266: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   269: athrow
    //   270: new 122	gnu/mapping/WrongType
    //   273: dup_x1
    //   274: swap
    //   275: ldc -89
    //   277: iconst_1
    //   278: aload 9
    //   280: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   283: athrow
    // Line number table:
    //   Java source line #639	-> byte code offset #0
    //   Java source line #640	-> byte code offset #37
    //   Java source line #641	-> byte code offset #52
    //   Java source line #642	-> byte code offset #137
    //   Java source line #643	-> byte code offset #166
    //   Java source line #644	-> byte code offset #178
    //   Java source line #645	-> byte code offset #190
    //   Java source line #646	-> byte code offset #202
    //   Java source line #640	-> byte code offset #230
    //   Java source line #641	-> byte code offset #243
    //   Java source line #642	-> byte code offset #256
    //   Java source line #646	-> byte code offset #270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	lis	Object
    //   51	152	1	elt	Object
    //   44	195	2	localObject1	Object
    //   59	1	3	localObject2	Object
    //   71	181	3	i	int
    //   83	1	4	localObject3	Object
    //   137	22	4	a	Object
    //   96	1	5	localObject4	Object
    //   137	34	5	b	Object
    //   109	1	6	localObject5	Object
    //   137	46	6	c	Object
    //   122	1	7	localObject6	Object
    //   137	58	7	d	Object
    //   135	86	8	e	Object
    //   150	129	9	localObject7	Object
    //   230	1	15	localClassCastException1	ClassCastException
    //   243	1	16	localClassCastException2	ClassCastException
    //   256	1	17	localClassCastException3	ClassCastException
    //   270	1	18	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   45	48	230	java/lang/ClassCastException
    //   60	63	243	java/lang/ClassCastException
    //   152	155	256	java/lang/ClassCastException
    //   214	217	270	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object appendReverse(Object rev$Mnhead, Object tail)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: astore_3
    //   3: astore_2
    //   4: aload_2
    //   5: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   8: ifeq +7 -> 15
    //   11: aload_3
    //   12: goto +40 -> 52
    //   15: aload_2
    //   16: ldc -118
    //   18: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   21: dup
    //   22: astore 4
    //   24: checkcast 138	gnu/lists/Pair
    //   27: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   30: aload_2
    //   31: ldc -118
    //   33: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   36: dup
    //   37: astore 4
    //   39: checkcast 138	gnu/lists/Pair
    //   42: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   45: aload_3
    //   46: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   49: goto -47 -> 2
    //   52: areturn
    //   53: new 122	gnu/mapping/WrongType
    //   56: dup_x1
    //   57: swap
    //   58: ldc -107
    //   60: iconst_1
    //   61: aload 4
    //   63: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   66: athrow
    //   67: new 122	gnu/mapping/WrongType
    //   70: dup_x1
    //   71: swap
    //   72: ldc -89
    //   74: iconst_1
    //   75: aload 4
    //   77: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   80: athrow
    // Line number table:
    //   Java source line #690	-> byte code offset #0
    //   Java source line #691	-> byte code offset #0
    //   Java source line #692	-> byte code offset #4
    //   Java source line #693	-> byte code offset #15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	rev$Mnhead	Object
    //   0	52	1	tail	Object
    //   3	28	2	rev$Mnhead	Object
    //   2	1	3	localObject1	Object
    //   4	42	3	tail	Object
    //   22	54	4	localObject2	Object
    //   53	1	6	localClassCastException1	ClassCastException
    //   67	1	7	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   24	27	53	java/lang/ClassCastException
    //   39	42	67	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object reduceRight(Procedure f, Object ridentity, Object lis)
  {
    // Byte code:
    //   0: new 397	gnu/kawa/slib/srfi1$frame1
    //   3: dup
    //   4: invokespecial 398	gnu/kawa/slib/srfi1$frame1:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: putfield 399	gnu/kawa/slib/srfi1$frame1:f	Lgnu/mapping/Procedure;
    //   13: aload_2
    //   14: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   17: ifeq +7 -> 24
    //   20: aload_1
    //   21: goto +37 -> 58
    //   24: aload_3
    //   25: aload_2
    //   26: ldc -118
    //   28: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   31: dup
    //   32: astore 4
    //   34: checkcast 138	gnu/lists/Pair
    //   37: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   40: aload_2
    //   41: ldc -118
    //   43: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   46: dup
    //   47: astore 4
    //   49: checkcast 138	gnu/lists/Pair
    //   52: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   55: invokevirtual 402	gnu/kawa/slib/srfi1$frame1:lambda10recur	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: areturn
    //   59: new 122	gnu/mapping/WrongType
    //   62: dup_x1
    //   63: swap
    //   64: ldc -89
    //   66: iconst_1
    //   67: aload 4
    //   69: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   72: athrow
    //   73: new 122	gnu/mapping/WrongType
    //   76: dup_x1
    //   77: swap
    //   78: ldc -107
    //   80: iconst_1
    //   81: aload 4
    //   83: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   86: athrow
    // Line number table:
    //   Java source line #898	-> byte code offset #0
    //   Java source line #899	-> byte code offset #13
    //   Java source line #900	-> byte code offset #24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	f	Procedure
    //   0	58	1	ridentity	Object
    //   0	58	2	lis	Object
    //   7	18	3	$heapFrame	frame1
    //   32	50	4	localObject	Object
    //   59	1	5	localClassCastException1	ClassCastException
    //   73	1	6	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   34	37	59	java/lang/ClassCastException
    //   49	52	73	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object count$V(Procedure pred, Object list1, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 132	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: aload_3
    //   10: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   13: ifeq +127 -> 140
    //   16: aload_1
    //   17: aload_3
    //   18: getstatic 29	gnu/kawa/slib/srfi1:Lit0	Lgnu/math/IntNum;
    //   21: astore 6
    //   23: astore 5
    //   25: astore 4
    //   27: aload 4
    //   29: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   32: ifeq +8 -> 40
    //   35: aload 6
    //   37: goto +183 -> 220
    //   40: aload 5
    //   42: invokestatic 328	gnu/kawa/slib/srfi1:$PcCars$PlCdrs$SlPair	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   45: astore 7
    //   47: aload 7
    //   49: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   52: astore 8
    //   54: aload 7
    //   56: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   59: astore 9
    //   61: aload 8
    //   63: invokestatic 160	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   66: ifeq +8 -> 74
    //   69: aload 6
    //   71: goto +149 -> 220
    //   74: aload 4
    //   76: ldc -118
    //   78: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   81: dup
    //   82: astore 10
    //   84: checkcast 138	gnu/lists/Pair
    //   87: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   90: aload 9
    //   92: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   95: aload_0
    //   96: aload 4
    //   98: ldc -118
    //   100: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   103: dup
    //   104: astore 10
    //   106: checkcast 138	gnu/lists/Pair
    //   109: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   112: aload 8
    //   114: invokevirtual 182	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   117: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   120: ifeq +15 -> 135
    //   123: iconst_1
    //   124: aload 6
    //   126: getstatic 54	gnu/kawa/slib/srfi1:Lit1	Lgnu/math/IntNum;
    //   129: invokestatic 60	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: goto -111 -> 21
    //   135: aload 6
    //   137: goto -116 -> 21
    //   140: aload_1
    //   141: getstatic 29	gnu/kawa/slib/srfi1:Lit0	Lgnu/math/IntNum;
    //   144: astore 5
    //   146: astore 4
    //   148: aload 4
    //   150: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   153: ifeq +8 -> 161
    //   156: aload 5
    //   158: goto +62 -> 220
    //   161: aload 4
    //   163: ldc -118
    //   165: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   168: dup
    //   169: astore 6
    //   171: checkcast 138	gnu/lists/Pair
    //   174: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   177: aload_0
    //   178: aload 4
    //   180: ldc -118
    //   182: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   185: dup
    //   186: astore 6
    //   188: checkcast 138	gnu/lists/Pair
    //   191: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   194: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   197: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   200: ifeq +15 -> 215
    //   203: iconst_1
    //   204: aload 5
    //   206: getstatic 54	gnu/kawa/slib/srfi1:Lit1	Lgnu/math/IntNum;
    //   209: invokestatic 60	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: goto -68 -> 144
    //   215: aload 5
    //   217: goto -73 -> 144
    //   220: areturn
    //   221: new 122	gnu/mapping/WrongType
    //   224: dup_x1
    //   225: swap
    //   226: ldc -107
    //   228: iconst_1
    //   229: aload 10
    //   231: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   234: athrow
    //   235: new 122	gnu/mapping/WrongType
    //   238: dup_x1
    //   239: swap
    //   240: ldc -89
    //   242: iconst_1
    //   243: aload 10
    //   245: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   248: athrow
    //   249: new 122	gnu/mapping/WrongType
    //   252: dup_x1
    //   253: swap
    //   254: ldc -107
    //   256: iconst_1
    //   257: aload 6
    //   259: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   262: athrow
    //   263: new 122	gnu/mapping/WrongType
    //   266: dup_x1
    //   267: swap
    //   268: ldc -89
    //   270: iconst_1
    //   271: aload 6
    //   273: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   276: athrow
    // Line number table:
    //   Java source line #793	-> byte code offset #0
    //   Java source line #794	-> byte code offset #9
    //   Java source line #797	-> byte code offset #16
    //   Java source line #798	-> byte code offset #27
    //   Java source line #800	-> byte code offset #40
    //   Java source line #801	-> byte code offset #47
    //   Java source line #800	-> byte code offset #54
    //   Java source line #802	-> byte code offset #54
    //   Java source line #803	-> byte code offset #61
    //   Java source line #804	-> byte code offset #74
    //   Java source line #805	-> byte code offset #90
    //   Java source line #806	-> byte code offset #92
    //   Java source line #807	-> byte code offset #123
    //   Java source line #806	-> byte code offset #135
    //   Java source line #811	-> byte code offset #140
    //   Java source line #812	-> byte code offset #148
    //   Java source line #813	-> byte code offset #161
    //   Java source line #804	-> byte code offset #221
    //   Java source line #806	-> byte code offset #235
    //   Java source line #813	-> byte code offset #249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	pred	Procedure
    //   0	220	1	list1	Object
    //   0	220	2	argsArray	Object[]
    //   0	18	3	lists	LList
    //   6	1	4	localLList1	LList
    //   25	72	4	list1	Object
    //   146	33	4	lis	Object
    //   23	1	5	localLList2	LList
    //   27	118	5	lists	Object
    //   148	68	5	i	Object
    //   21	1	6	localIntNum	gnu.math.IntNum
    //   27	245	6	i	Object
    //   45	10	7	split	Pair
    //   52	61	8	a$Mns	Object
    //   59	32	9	d$Mns	Object
    //   82	162	10	localObject1	Object
    //   221	1	16	localClassCastException1	ClassCastException
    //   235	1	17	localClassCastException2	ClassCastException
    //   249	1	18	localClassCastException3	ClassCastException
    //   263	1	19	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   84	87	221	java/lang/ClassCastException
    //   106	109	235	java/lang/ClassCastException
    //   171	174	249	java/lang/ClassCastException
    //   188	191	263	java/lang/ClassCastException
  }
  
  public static Object unfoldRight(Procedure paramProcedure1, Procedure paramProcedure2, Procedure paramProcedure3, Object paramObject)
  {
    return unfoldRight(paramProcedure1, paramProcedure2, paramProcedure3, paramObject, LList.Empty);
  }
  
  /* Error */
  public static Object unfold$V(Procedure p, Procedure f, Procedure g, Object seed, Object[] argsArray)
  {
    // Byte code:
    //   0: aload 4
    //   2: iconst_0
    //   3: invokestatic 132	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   6: dup
    //   7: astore 6
    //   9: astore 5
    //   11: aload 5
    //   13: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   16: ifeq +146 -> 162
    //   19: aload 5
    //   21: dup
    //   22: astore 7
    //   24: checkcast 138	gnu/lists/Pair
    //   27: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   30: astore 6
    //   32: aload 5
    //   34: dup
    //   35: astore 7
    //   37: checkcast 138	gnu/lists/Pair
    //   40: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   43: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   46: ifeq +58 -> 104
    //   49: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   52: bipush 8
    //   54: anewarray 37	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: getstatic 334	kawa/lib/exceptions:error	Lgnu/expr/ModuleMethod;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: ldc_w 336
    //   68: aastore
    //   69: dup
    //   70: iconst_2
    //   71: getstatic 339	gnu/kawa/slib/srfi1:unfold	Lgnu/expr/ModuleMethod;
    //   74: aastore
    //   75: dup
    //   76: iconst_3
    //   77: aload_0
    //   78: aastore
    //   79: dup
    //   80: iconst_4
    //   81: aload_1
    //   82: aastore
    //   83: dup
    //   84: iconst_5
    //   85: aload_2
    //   86: aastore
    //   87: dup
    //   88: bipush 6
    //   90: aload_3
    //   91: aastore
    //   92: dup
    //   93: bipush 7
    //   95: aload 5
    //   97: aastore
    //   98: invokevirtual 342	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
    //   101: goto +120 -> 221
    //   104: aload_3
    //   105: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   108: astore 8
    //   110: astore 7
    //   112: aload_0
    //   113: aload 7
    //   115: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   121: ifeq +21 -> 142
    //   124: aload 8
    //   126: getstatic 178	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   129: aload 6
    //   131: aload 7
    //   133: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: invokestatic 345	gnu/kawa/slib/srfi1:appendReverse$Ex	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: goto +82 -> 221
    //   142: aload_2
    //   143: aload 7
    //   145: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   148: aload_1
    //   149: aload 7
    //   151: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   154: aload 8
    //   156: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   159: goto -51 -> 108
    //   162: aload_3
    //   163: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   166: astore 7
    //   168: astore 6
    //   170: aload_0
    //   171: aload 6
    //   173: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   176: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   179: ifeq +22 -> 201
    //   182: aload 7
    //   184: ldc 62
    //   186: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   189: dup
    //   190: astore 8
    //   192: checkcast 62	gnu/lists/LList
    //   195: invokestatic 252	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   198: goto +23 -> 221
    //   201: aload_2
    //   202: aload 6
    //   204: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   207: aload_1
    //   208: aload 6
    //   210: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   213: aload 7
    //   215: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   218: goto -52 -> 166
    //   221: areturn
    //   222: new 122	gnu/mapping/WrongType
    //   225: dup_x1
    //   226: swap
    //   227: ldc -89
    //   229: iconst_1
    //   230: aload 7
    //   232: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   235: athrow
    //   236: new 122	gnu/mapping/WrongType
    //   239: dup_x1
    //   240: swap
    //   241: ldc -107
    //   243: iconst_1
    //   244: aload 7
    //   246: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   249: athrow
    //   250: new 122	gnu/mapping/WrongType
    //   253: dup_x1
    //   254: swap
    //   255: ldc -8
    //   257: iconst_1
    //   258: aload 8
    //   260: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   263: athrow
    // Line number table:
    //   Java source line #826	-> byte code offset #0
    //   Java source line #827	-> byte code offset #11
    //   Java source line #829	-> byte code offset #19
    //   Java source line #830	-> byte code offset #32
    //   Java source line #831	-> byte code offset #49
    //   Java source line #833	-> byte code offset #104
    //   Java source line #834	-> byte code offset #112
    //   Java source line #835	-> byte code offset #124
    //   Java source line #836	-> byte code offset #142
    //   Java source line #838	-> byte code offset #162
    //   Java source line #839	-> byte code offset #170
    //   Java source line #840	-> byte code offset #182
    //   Java source line #841	-> byte code offset #201
    //   Java source line #829	-> byte code offset #222
    //   Java source line #830	-> byte code offset #236
    //   Java source line #840	-> byte code offset #250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	p	Procedure
    //   0	221	1	f	Procedure
    //   0	221	2	g	Procedure
    //   0	221	3	seed	Object
    //   0	221	4	argsArray	Object[]
    //   0	96	5	maybe$Mntail$Mngen	LList
    //   7	1	6	localLList1	LList
    //   30	100	6	tail$Mngen	Object
    //   168	41	6	seed	Object
    //   22	14	7	localLList2	LList
    //   110	57	7	seed	Object
    //   170	75	7	res	Object
    //   108	1	8	localEmptyList	gnu.lists.EmptyList
    //   112	147	8	res	Object
    //   222	1	14	localClassCastException1	ClassCastException
    //   236	1	15	localClassCastException2	ClassCastException
    //   250	1	16	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   24	27	222	java/lang/ClassCastException
    //   37	40	236	java/lang/ClassCastException
    //   192	195	250	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object fold$V(Procedure kons, Object knil, Object lis1, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_3
    //   1: iconst_0
    //   2: invokestatic 132	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 5
    //   8: astore 4
    //   10: aload 4
    //   12: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   15: ifeq +89 -> 104
    //   18: aload_2
    //   19: aload 4
    //   21: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   24: aload_1
    //   25: astore 6
    //   27: astore 5
    //   29: aload 5
    //   31: aload 6
    //   33: invokestatic 348	gnu/kawa/slib/srfi1:$PcCars$PlCdrs$Pl	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   36: astore 7
    //   38: iconst_0
    //   39: istore 8
    //   41: aload 7
    //   43: iload 8
    //   45: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   48: istore 8
    //   50: aload 7
    //   52: iload 8
    //   54: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   57: astore 9
    //   59: aload 7
    //   61: iload 8
    //   63: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   66: istore 8
    //   68: aload 7
    //   70: iload 8
    //   72: invokestatic 298	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   75: astore 10
    //   77: aload 9
    //   79: invokestatic 160	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   82: ifeq +8 -> 90
    //   85: aload 6
    //   87: goto +77 -> 164
    //   90: aload 10
    //   92: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   95: aload_0
    //   96: aload 9
    //   98: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   101: goto -76 -> 25
    //   104: aload_2
    //   105: aload_1
    //   106: astore 6
    //   108: astore 5
    //   110: aload 5
    //   112: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   115: ifeq +8 -> 123
    //   118: aload 6
    //   120: goto +44 -> 164
    //   123: aload 5
    //   125: ldc -118
    //   127: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   130: dup
    //   131: astore 7
    //   133: checkcast 138	gnu/lists/Pair
    //   136: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   139: aload_0
    //   140: aload 5
    //   142: ldc -118
    //   144: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   147: dup
    //   148: astore 7
    //   150: checkcast 138	gnu/lists/Pair
    //   153: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   156: aload 6
    //   158: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: goto -55 -> 106
    //   164: areturn
    //   165: new 122	gnu/mapping/WrongType
    //   168: dup_x1
    //   169: swap
    //   170: ldc -107
    //   172: iconst_1
    //   173: aload 7
    //   175: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   178: athrow
    //   179: new 122	gnu/mapping/WrongType
    //   182: dup_x1
    //   183: swap
    //   184: ldc -89
    //   186: iconst_1
    //   187: aload 7
    //   189: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   192: athrow
    // Line number table:
    //   Java source line #843	-> byte code offset #0
    //   Java source line #844	-> byte code offset #10
    //   Java source line #845	-> byte code offset #18
    //   Java source line #846	-> byte code offset #29
    //   Java source line #847	-> byte code offset #77
    //   Java source line #848	-> byte code offset #90
    //   Java source line #850	-> byte code offset #104
    //   Java source line #851	-> byte code offset #110
    //   Java source line #852	-> byte code offset #123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	kons	Procedure
    //   0	164	1	knil	Object
    //   0	164	2	lis1	Object
    //   0	164	3	argsArray	Object[]
    //   0	20	4	lists	LList
    //   6	1	5	localLList1	LList
    //   27	3	5	lists	Object
    //   108	33	5	lis	Object
    //   25	1	6	localObject1	Object
    //   29	78	6	ans	Object
    //   110	47	6	ans	Object
    //   36	152	7	localObject2	Object
    //   39	32	8	i	int
    //   57	1	9	localObject3	Object
    //   77	20	9	cars$Plans	Object
    //   75	16	10	cdrs	Object
    //   165	1	16	localClassCastException1	ClassCastException
    //   179	1	17	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   133	136	165	java/lang/ClassCastException
    //   150	153	179	java/lang/ClassCastException
  }
  
  /* Error */
  static Object $PcCars$PlCdrs$Pl(Object lists, Object carsFinal)
  {
    // Byte code:
    //   0: new 735	gnu/kawa/slib/srfi1$frame38
    //   3: dup
    //   4: invokespecial 736	gnu/kawa/slib/srfi1$frame38:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: putfield 739	gnu/kawa/slib/srfi1$frame38:cars$Mnfinal	Ljava/lang/Object;
    //   13: new 696	kawa/lang/Continuation
    //   16: dup
    //   17: invokestatic 7	gnu/mapping/CallContext:getInstance	()Lgnu/mapping/CallContext;
    //   20: dup
    //   21: astore 4
    //   23: invokespecial 699	kawa/lang/Continuation:<init>	(Lgnu/mapping/CallContext;)V
    //   26: astore_3
    //   27: aload_3
    //   28: astore 6
    //   30: new 741	gnu/kawa/slib/srfi1$frame39
    //   33: dup
    //   34: invokespecial 742	gnu/kawa/slib/srfi1$frame39:<init>	()V
    //   37: dup
    //   38: aload_2
    //   39: putfield 746	gnu/kawa/slib/srfi1$frame39:staticLink	Lgnu/kawa/slib/srfi1$frame38;
    //   42: astore 7
    //   44: aload 7
    //   46: aload 6
    //   48: putfield 747	gnu/kawa/slib/srfi1$frame39:abort	Lkawa/lang/Continuation;
    //   51: aload 7
    //   53: aload_0
    //   54: invokevirtual 750	gnu/kawa/slib/srfi1$frame39:lambda49recur	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: aload_3
    //   58: iconst_1
    //   59: putfield 713	kawa/lang/Continuation:invoked	Z
    //   62: astore 5
    //   64: goto +9 -> 73
    //   67: aload_3
    //   68: invokestatic 717	kawa/lang/Continuation:handleException	(Ljava/lang/Throwable;Lkawa/lang/Continuation;)Ljava/lang/Object;
    //   71: astore 5
    //   73: aload 5
    //   75: areturn
    // Line number table:
    //   Java source line #765	-> byte code offset #0
    //   Java source line #766	-> byte code offset #13
    //   Java source line #767	-> byte code offset #28
    //   Java source line #768	-> byte code offset #51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	lists	Object
    //   0	75	1	carsFinal	Object
    //   7	32	2	$heapFrame	frame38
    //   26	42	3	localContinuation1	kawa.lang.Continuation
    //   13	9	4	$ctx	CallContext
    //   62	12	5	localObject	Object
    //   28	19	6	abort	kawa.lang.Continuation
    //   42	10	7	$heapFrame	frame39
    // Exception table:
    //   from	to	target	type
    //   27	67	67	finally
  }
  
  /* Error */
  static Object $PcCdrs(Object lists)
  {
    // Byte code:
    //   0: new 696	kawa/lang/Continuation
    //   3: dup
    //   4: invokestatic 7	gnu/mapping/CallContext:getInstance	()Lgnu/mapping/CallContext;
    //   7: dup
    //   8: astore_2
    //   9: invokespecial 699	kawa/lang/Continuation:<init>	(Lgnu/mapping/CallContext;)V
    //   12: astore_1
    //   13: aload_1
    //   14: astore 4
    //   16: new 701	gnu/kawa/slib/srfi1$frame35
    //   19: dup
    //   20: invokespecial 702	gnu/kawa/slib/srfi1$frame35:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: aload 4
    //   29: putfield 706	gnu/kawa/slib/srfi1$frame35:abort	Lkawa/lang/Continuation;
    //   32: aload 5
    //   34: aload_0
    //   35: invokevirtual 709	gnu/kawa/slib/srfi1$frame35:lambda46recur	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: aload_1
    //   39: iconst_1
    //   40: putfield 713	kawa/lang/Continuation:invoked	Z
    //   43: astore_3
    //   44: goto +8 -> 52
    //   47: aload_1
    //   48: invokestatic 717	kawa/lang/Continuation:handleException	(Ljava/lang/Throwable;Lkawa/lang/Continuation;)Ljava/lang/Object;
    //   51: astore_3
    //   52: aload_3
    //   53: areturn
    // Line number table:
    //   Java source line #726	-> byte code offset #0
    //   Java source line #727	-> byte code offset #0
    //   Java source line #728	-> byte code offset #14
    //   Java source line #729	-> byte code offset #32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	lists	Object
    //   12	36	1	localContinuation1	kawa.lang.Continuation
    //   0	9	2	$ctx	CallContext
    //   43	10	3	localObject	Object
    //   14	14	4	abort	kawa.lang.Continuation
    //   23	10	5	$heapFrame	frame35
    // Exception table:
    //   from	to	target	type
    //   13	47	47	finally
  }
  
  /* Error */
  public static Object reduce(Procedure f, Object ridentity, Object lis)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   4: ifeq +7 -> 11
    //   7: aload_1
    //   8: goto +39 -> 47
    //   11: aload_0
    //   12: aload_2
    //   13: ldc -118
    //   15: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: dup
    //   19: astore_3
    //   20: checkcast 138	gnu/lists/Pair
    //   23: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   26: aload_2
    //   27: ldc -118
    //   29: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   32: dup
    //   33: astore_3
    //   34: checkcast 138	gnu/lists/Pair
    //   37: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   40: iconst_0
    //   41: anewarray 37	java/lang/Object
    //   44: invokestatic 395	gnu/kawa/slib/srfi1:fold$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   47: areturn
    //   48: new 122	gnu/mapping/WrongType
    //   51: dup_x1
    //   52: swap
    //   53: ldc -89
    //   55: iconst_1
    //   56: aload_3
    //   57: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   60: athrow
    //   61: new 122	gnu/mapping/WrongType
    //   64: dup_x1
    //   65: swap
    //   66: ldc -107
    //   68: iconst_1
    //   69: aload_3
    //   70: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    // Line number table:
    //   Java source line #894	-> byte code offset #0
    //   Java source line #895	-> byte code offset #0
    //   Java source line #896	-> byte code offset #11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	f	Procedure
    //   0	47	1	ridentity	Object
    //   0	47	2	lis	Object
    //   19	51	3	localObject	Object
    //   48	1	4	localClassCastException1	ClassCastException
    //   61	1	5	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   20	23	48	java/lang/ClassCastException
    //   34	37	61	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object appendMap$V(Object f, Object lis1, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 132	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: aload_3
    //   10: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   13: ifeq +27 -> 40
    //   16: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   19: getstatic 317	kawa/standard/append:append	Lkawa/standard/append;
    //   22: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   25: getstatic 195	kawa/standard/Scheme:map	Lgnu/kawa/functions/Map;
    //   28: aload_0
    //   29: aload_1
    //   30: aload_3
    //   31: invokevirtual 203	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   34: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   37: goto +89 -> 126
    //   40: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   43: getstatic 317	kawa/standard/append:append	Lkawa/standard/append;
    //   46: aload_1
    //   47: invokestatic 267	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   50: astore 4
    //   52: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   55: astore 5
    //   57: aconst_null
    //   58: astore 6
    //   60: aload 4
    //   62: invokeinterface 273 1 0
    //   67: ifeq +54 -> 121
    //   70: aload 4
    //   72: invokeinterface 277 1 0
    //   77: astore 7
    //   79: new 138	gnu/lists/Pair
    //   82: dup
    //   83: getstatic 178	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   86: aload_0
    //   87: aload 7
    //   89: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   95: invokespecial 280	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   98: aload 6
    //   100: ifnonnull +9 -> 109
    //   103: dup
    //   104: astore 5
    //   106: goto +10 -> 116
    //   109: aload 6
    //   111: swap
    //   112: dup_x1
    //   113: invokevirtual 284	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   116: astore 6
    //   118: goto -58 -> 60
    //   121: aload 5
    //   123: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: areturn
    // Line number table:
    //   Java source line #910	-> byte code offset #0
    //   Java source line #911	-> byte code offset #9
    //   Java source line #912	-> byte code offset #16
    //   Java source line #913	-> byte code offset #40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	f	Object
    //   0	126	1	lis1	Object
    //   0	126	2	argsArray	Object[]
    //   0	126	3	lists	LList
  }
  
  /* Error */
  public static Object appendMap$Ex$V(Object f, Object lis1, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 132	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: aload_3
    //   10: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   13: ifeq +27 -> 40
    //   16: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   19: getstatic 324	gnu/kawa/slib/srfi1:append$Ex	Lgnu/expr/ModuleMethod;
    //   22: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   25: getstatic 195	kawa/standard/Scheme:map	Lgnu/kawa/functions/Map;
    //   28: aload_0
    //   29: aload_1
    //   30: aload_3
    //   31: invokevirtual 203	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   34: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   37: goto +89 -> 126
    //   40: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   43: getstatic 324	gnu/kawa/slib/srfi1:append$Ex	Lgnu/expr/ModuleMethod;
    //   46: aload_1
    //   47: invokestatic 267	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   50: astore 4
    //   52: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   55: astore 5
    //   57: aconst_null
    //   58: astore 6
    //   60: aload 4
    //   62: invokeinterface 273 1 0
    //   67: ifeq +54 -> 121
    //   70: aload 4
    //   72: invokeinterface 277 1 0
    //   77: astore 7
    //   79: new 138	gnu/lists/Pair
    //   82: dup
    //   83: getstatic 178	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   86: aload_0
    //   87: aload 7
    //   89: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   95: invokespecial 280	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   98: aload 6
    //   100: ifnonnull +9 -> 109
    //   103: dup
    //   104: astore 5
    //   106: goto +10 -> 116
    //   109: aload 6
    //   111: swap
    //   112: dup_x1
    //   113: invokevirtual 284	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   116: astore 6
    //   118: goto -58 -> 60
    //   121: aload 5
    //   123: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: areturn
    // Line number table:
    //   Java source line #915	-> byte code offset #0
    //   Java source line #916	-> byte code offset #9
    //   Java source line #917	-> byte code offset #16
    //   Java source line #918	-> byte code offset #40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	f	Object
    //   0	126	1	lis1	Object
    //   0	126	2	argsArray	Object[]
    //   0	126	3	lists	LList
  }
  
  /* Error */
  public static Object map$Ex$V(Procedure f, Object lis1, Object[] argsArray)
  {
    // Byte code:
    //   0: new 408	gnu/kawa/slib/srfi1$frame2
    //   3: dup
    //   4: invokespecial 409	gnu/kawa/slib/srfi1$frame2:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_0
    //   12: putfield 410	gnu/kawa/slib/srfi1$frame2:f	Lgnu/mapping/Procedure;
    //   15: aload_2
    //   16: iconst_0
    //   17: invokestatic 132	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   20: dup
    //   21: astore 5
    //   23: astore_3
    //   24: aload_3
    //   25: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   28: ifeq +104 -> 132
    //   31: aload_1
    //   32: aload_3
    //   33: astore 6
    //   35: astore 5
    //   37: aload 5
    //   39: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   42: ifne +104 -> 146
    //   45: aload 6
    //   47: invokestatic 413	gnu/kawa/slib/srfi1:$PcCars$PlCdrs$SlNoTest$SlPair	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   50: astore 7
    //   52: aload 7
    //   54: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   57: astore 8
    //   59: aload 7
    //   61: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   64: astore 9
    //   66: aload 5
    //   68: ldc -118
    //   70: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   73: dup
    //   74: astore 10
    //   76: checkcast 138	gnu/lists/Pair
    //   79: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   82: aload 4
    //   84: getfield 410	gnu/kawa/slib/srfi1$frame2:f	Lgnu/mapping/Procedure;
    //   87: aload 5
    //   89: ldc -118
    //   91: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   94: dup
    //   95: astore 10
    //   97: checkcast 138	gnu/lists/Pair
    //   100: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   103: aload 8
    //   105: invokevirtual 182	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: invokestatic 418	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   111: aload 5
    //   113: ldc -118
    //   115: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   118: dup
    //   119: astore 10
    //   121: checkcast 138	gnu/lists/Pair
    //   124: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   127: aload 9
    //   129: goto -96 -> 33
    //   132: aload 4
    //   134: getfield 421	gnu/kawa/slib/srfi1$frame2:lambda$Fn1	Lgnu/expr/ModuleMethod;
    //   137: aload_1
    //   138: iconst_0
    //   139: anewarray 37	java/lang/Object
    //   142: invokestatic 425	gnu/kawa/slib/srfi1:pairForEach$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   145: pop
    //   146: aload_1
    //   147: areturn
    //   148: new 122	gnu/mapping/WrongType
    //   151: dup_x1
    //   152: swap
    //   153: ldc_w 415
    //   156: iconst_1
    //   157: aload 10
    //   159: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   162: athrow
    //   163: new 122	gnu/mapping/WrongType
    //   166: dup_x1
    //   167: swap
    //   168: ldc -89
    //   170: iconst_1
    //   171: aload 10
    //   173: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   176: athrow
    //   177: new 122	gnu/mapping/WrongType
    //   180: dup_x1
    //   181: swap
    //   182: ldc -107
    //   184: iconst_1
    //   185: aload 10
    //   187: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   190: athrow
    // Line number table:
    //   Java source line #937	-> byte code offset #0
    //   Java source line #938	-> byte code offset #24
    //   Java source line #939	-> byte code offset #31
    //   Java source line #940	-> byte code offset #37
    //   Java source line #941	-> byte code offset #45
    //   Java source line #942	-> byte code offset #52
    //   Java source line #941	-> byte code offset #59
    //   Java source line #943	-> byte code offset #59
    //   Java source line #944	-> byte code offset #66
    //   Java source line #945	-> byte code offset #111
    //   Java source line #948	-> byte code offset #132
    //   Java source line #949	-> byte code offset #146
    //   Java source line #944	-> byte code offset #148
    //   Java source line #945	-> byte code offset #177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	f	Procedure
    //   0	147	1	lis1	Object
    //   0	147	2	argsArray	Object[]
    //   0	33	3	lists	LList
    //   7	126	4	$heapFrame	frame2
    //   21	1	5	localLList1	LList
    //   35	77	5	lis1	Object
    //   33	1	6	localLList2	LList
    //   37	9	6	lists	Object
    //   50	10	7	split	Pair
    //   57	47	8	heads	Object
    //   64	64	9	tails	Object
    //   74	112	10	localObject1	Object
    //   148	1	13	localClassCastException1	ClassCastException
    //   163	1	14	localClassCastException2	ClassCastException
    //   177	1	15	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   76	79	148	java/lang/ClassCastException
    //   97	100	163	java/lang/ClassCastException
    //   121	124	177	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object filterMap$V(Procedure f, Object lis1, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 132	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: aload_3
    //   10: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   13: ifeq +126 -> 139
    //   16: aload_1
    //   17: aload_3
    //   18: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   21: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   24: astore 5
    //   26: astore 4
    //   28: aload 4
    //   30: invokestatic 428	gnu/kawa/slib/srfi1:$PcCars$PlCdrs	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: astore 6
    //   35: iconst_0
    //   36: istore 7
    //   38: aload 6
    //   40: iload 7
    //   42: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   45: istore 7
    //   47: aload 6
    //   49: iload 7
    //   51: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   54: astore 8
    //   56: aload 6
    //   58: iload 7
    //   60: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   63: istore 7
    //   65: aload 6
    //   67: iload 7
    //   69: invokestatic 298	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   72: astore 9
    //   74: aload 8
    //   76: invokestatic 431	gnu/kawa/slib/srfi1:isNotPair	(Ljava/lang/Object;)Z
    //   79: ifeq +22 -> 101
    //   82: aload 5
    //   84: ldc 62
    //   86: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   89: dup
    //   90: astore 10
    //   92: checkcast 62	gnu/lists/LList
    //   95: invokestatic 252	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   98: goto +143 -> 241
    //   101: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   104: aload_0
    //   105: aload 8
    //   107: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: astore 10
    //   112: aload 10
    //   114: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   117: ifeq +15 -> 132
    //   120: aload 9
    //   122: aload 10
    //   124: aload 5
    //   126: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   129: goto -105 -> 24
    //   132: aload 9
    //   134: astore 4
    //   136: goto -108 -> 28
    //   139: aload_1
    //   140: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   143: astore 5
    //   145: astore 4
    //   147: aload 4
    //   149: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   152: ifeq +22 -> 174
    //   155: aload 5
    //   157: ldc 62
    //   159: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   162: dup
    //   163: astore 6
    //   165: checkcast 62	gnu/lists/LList
    //   168: invokestatic 252	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   171: goto +70 -> 241
    //   174: aload_0
    //   175: aload 4
    //   177: ldc -118
    //   179: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   182: dup
    //   183: astore 7
    //   185: checkcast 138	gnu/lists/Pair
    //   188: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   191: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   194: astore 6
    //   196: aload 4
    //   198: ldc -118
    //   200: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   203: dup
    //   204: astore 8
    //   206: checkcast 138	gnu/lists/Pair
    //   209: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   212: astore 7
    //   214: aload 6
    //   216: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   219: ifeq +15 -> 234
    //   222: aload 7
    //   224: aload 6
    //   226: aload 5
    //   228: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   231: goto -88 -> 143
    //   234: aload 7
    //   236: astore 4
    //   238: goto -91 -> 147
    //   241: areturn
    //   242: new 122	gnu/mapping/WrongType
    //   245: dup_x1
    //   246: swap
    //   247: ldc -8
    //   249: iconst_1
    //   250: aload 10
    //   252: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   255: athrow
    //   256: new 122	gnu/mapping/WrongType
    //   259: dup_x1
    //   260: swap
    //   261: ldc -8
    //   263: iconst_1
    //   264: aload 6
    //   266: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   269: athrow
    //   270: new 122	gnu/mapping/WrongType
    //   273: dup_x1
    //   274: swap
    //   275: ldc -89
    //   277: iconst_1
    //   278: aload 7
    //   280: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   283: athrow
    //   284: new 122	gnu/mapping/WrongType
    //   287: dup_x1
    //   288: swap
    //   289: ldc -107
    //   291: iconst_1
    //   292: aload 8
    //   294: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   297: athrow
    // Line number table:
    //   Java source line #953	-> byte code offset #0
    //   Java source line #954	-> byte code offset #9
    //   Java source line #955	-> byte code offset #16
    //   Java source line #956	-> byte code offset #28
    //   Java source line #957	-> byte code offset #74
    //   Java source line #958	-> byte code offset #82
    //   Java source line #959	-> byte code offset #101
    //   Java source line #960	-> byte code offset #112
    //   Java source line #961	-> byte code offset #120
    //   Java source line #962	-> byte code offset #132
    //   Java source line #964	-> byte code offset #139
    //   Java source line #965	-> byte code offset #147
    //   Java source line #966	-> byte code offset #155
    //   Java source line #967	-> byte code offset #174
    //   Java source line #968	-> byte code offset #196
    //   Java source line #969	-> byte code offset #214
    //   Java source line #970	-> byte code offset #222
    //   Java source line #971	-> byte code offset #234
    //   Java source line #958	-> byte code offset #242
    //   Java source line #966	-> byte code offset #256
    //   Java source line #967	-> byte code offset #270
    //   Java source line #968	-> byte code offset #284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	f	Procedure
    //   0	241	1	lis1	Object
    //   0	241	2	argsArray	Object[]
    //   0	241	3	lists	LList
    //   28	111	4	lists	Object
    //   147	94	4	lis	Object
    //   28	111	5	res	Object
    //   147	94	5	res	Object
    //   214	27	6	head	Object
    //   214	27	7	tail	Object
    //   74	65	8	cars	Object
    //   74	65	9	cdrs	Object
    //   112	27	10	head	Object
    // Exception table:
    //   from	to	target	type
    //   92	95	242	java/lang/ClassCastException
    //   165	168	256	java/lang/ClassCastException
    //   185	188	270	java/lang/ClassCastException
    //   206	209	284	java/lang/ClassCastException
  }
  
  /* Error */
  static Object $PcCars$PlCdrs(Object lists)
  {
    // Byte code:
    //   0: new 696	kawa/lang/Continuation
    //   3: dup
    //   4: invokestatic 7	gnu/mapping/CallContext:getInstance	()Lgnu/mapping/CallContext;
    //   7: dup
    //   8: astore_2
    //   9: invokespecial 699	kawa/lang/Continuation:<init>	(Lgnu/mapping/CallContext;)V
    //   12: astore_1
    //   13: aload_1
    //   14: astore 4
    //   16: new 728	gnu/kawa/slib/srfi1$frame37
    //   19: dup
    //   20: invokespecial 729	gnu/kawa/slib/srfi1$frame37:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: aload 4
    //   29: putfield 730	gnu/kawa/slib/srfi1$frame37:abort	Lkawa/lang/Continuation;
    //   32: aload 5
    //   34: aload_0
    //   35: invokevirtual 733	gnu/kawa/slib/srfi1$frame37:lambda48recur	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: aload_1
    //   39: iconst_1
    //   40: putfield 713	kawa/lang/Continuation:invoked	Z
    //   43: astore_3
    //   44: goto +8 -> 52
    //   47: aload_1
    //   48: invokestatic 717	kawa/lang/Continuation:handleException	(Ljava/lang/Throwable;Lkawa/lang/Continuation;)Ljava/lang/Object;
    //   51: astore_3
    //   52: aload_3
    //   53: areturn
    // Line number table:
    //   Java source line #744	-> byte code offset #0
    //   Java source line #745	-> byte code offset #0
    //   Java source line #746	-> byte code offset #14
    //   Java source line #747	-> byte code offset #32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	lists	Object
    //   12	36	1	localContinuation1	kawa.lang.Continuation
    //   0	9	2	$ctx	CallContext
    //   43	10	3	localObject	Object
    //   14	14	4	abort	kawa.lang.Continuation
    //   23	10	5	$heapFrame	frame37
    // Exception table:
    //   from	to	target	type
    //   13	47	47	finally
  }
  
  /* Error */
  public static Object filter(Procedure pred, Object lis)
  {
    // Byte code:
    //   0: aload_1
    //   1: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   4: astore_3
    //   5: astore_2
    //   6: aload_2
    //   7: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   10: ifeq +21 -> 31
    //   13: aload_3
    //   14: ldc 62
    //   16: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   19: dup
    //   20: astore 4
    //   22: checkcast 62	gnu/lists/LList
    //   25: invokestatic 252	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   28: goto +66 -> 94
    //   31: aload_2
    //   32: ldc -118
    //   34: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   37: dup
    //   38: astore 5
    //   40: checkcast 138	gnu/lists/Pair
    //   43: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   46: astore 4
    //   48: aload_2
    //   49: ldc -118
    //   51: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   54: dup
    //   55: astore 6
    //   57: checkcast 138	gnu/lists/Pair
    //   60: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   63: astore 5
    //   65: aload_0
    //   66: aload 4
    //   68: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   74: ifeq +14 -> 88
    //   77: aload 5
    //   79: aload 4
    //   81: aload_3
    //   82: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   85: goto -81 -> 4
    //   88: aload 5
    //   90: astore_2
    //   91: goto -85 -> 6
    //   94: areturn
    //   95: new 122	gnu/mapping/WrongType
    //   98: dup_x1
    //   99: swap
    //   100: ldc -8
    //   102: iconst_1
    //   103: aload 4
    //   105: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   108: athrow
    //   109: new 122	gnu/mapping/WrongType
    //   112: dup_x1
    //   113: swap
    //   114: ldc -89
    //   116: iconst_1
    //   117: aload 5
    //   119: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   122: athrow
    //   123: new 122	gnu/mapping/WrongType
    //   126: dup_x1
    //   127: swap
    //   128: ldc -107
    //   130: iconst_1
    //   131: aload 6
    //   133: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   136: athrow
    // Line number table:
    //   Java source line #1007	-> byte code offset #0
    //   Java source line #1008	-> byte code offset #0
    //   Java source line #1009	-> byte code offset #6
    //   Java source line #1010	-> byte code offset #13
    //   Java source line #1011	-> byte code offset #31
    //   Java source line #1012	-> byte code offset #48
    //   Java source line #1013	-> byte code offset #65
    //   Java source line #1014	-> byte code offset #77
    //   Java source line #1015	-> byte code offset #88
    //   Java source line #1010	-> byte code offset #95
    //   Java source line #1011	-> byte code offset #109
    //   Java source line #1012	-> byte code offset #123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	pred	Procedure
    //   0	94	1	lis	Object
    //   6	88	2	lis	Object
    //   6	88	3	res	Object
    //   65	29	4	head	Object
    //   65	29	5	tail	Object
    // Exception table:
    //   from	to	target	type
    //   22	25	95	java/lang/ClassCastException
    //   40	43	109	java/lang/ClassCastException
    //   57	60	123	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object partition(Procedure pred, Object lis)
  {
    // Byte code:
    //   0: aload_1
    //   1: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   4: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   7: astore 4
    //   9: astore_3
    //   10: astore_2
    //   11: aload_2
    //   12: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   15: ifeq +40 -> 55
    //   18: aload_3
    //   19: ldc 62
    //   21: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   24: dup
    //   25: astore 5
    //   27: checkcast 62	gnu/lists/LList
    //   30: invokestatic 252	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   33: aload 4
    //   35: ldc 62
    //   37: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   40: dup
    //   41: astore 5
    //   43: checkcast 62	gnu/lists/LList
    //   46: invokestatic 252	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   49: invokestatic 242	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
    //   52: goto +77 -> 129
    //   55: aload_2
    //   56: ldc -118
    //   58: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   61: dup
    //   62: astore 6
    //   64: checkcast 138	gnu/lists/Pair
    //   67: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   70: astore 5
    //   72: aload_2
    //   73: ldc -118
    //   75: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   78: dup
    //   79: astore 7
    //   81: checkcast 138	gnu/lists/Pair
    //   84: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   87: astore 6
    //   89: aload_0
    //   90: aload 5
    //   92: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   98: ifeq +16 -> 114
    //   101: aload 6
    //   103: aload 5
    //   105: aload_3
    //   106: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   109: astore_3
    //   110: astore_2
    //   111: goto -100 -> 11
    //   114: aload 6
    //   116: aload 5
    //   118: aload 4
    //   120: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   123: astore 4
    //   125: astore_2
    //   126: goto -115 -> 11
    //   129: areturn
    //   130: new 122	gnu/mapping/WrongType
    //   133: dup_x1
    //   134: swap
    //   135: ldc -8
    //   137: iconst_1
    //   138: aload 5
    //   140: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   143: athrow
    //   144: new 122	gnu/mapping/WrongType
    //   147: dup_x1
    //   148: swap
    //   149: ldc -8
    //   151: iconst_1
    //   152: aload 5
    //   154: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   157: athrow
    //   158: new 122	gnu/mapping/WrongType
    //   161: dup_x1
    //   162: swap
    //   163: ldc -89
    //   165: iconst_1
    //   166: aload 6
    //   168: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   171: athrow
    //   172: new 122	gnu/mapping/WrongType
    //   175: dup_x1
    //   176: swap
    //   177: ldc -107
    //   179: iconst_1
    //   180: aload 7
    //   182: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   185: athrow
    // Line number table:
    //   Java source line #1090	-> byte code offset #0
    //   Java source line #1091	-> byte code offset #0
    //   Java source line #1092	-> byte code offset #11
    //   Java source line #1093	-> byte code offset #18
    //   Java source line #1094	-> byte code offset #55
    //   Java source line #1095	-> byte code offset #72
    //   Java source line #1096	-> byte code offset #89
    //   Java source line #1097	-> byte code offset #101
    //   Java source line #1098	-> byte code offset #114
    //   Java source line #1093	-> byte code offset #130
    //   Java source line #1094	-> byte code offset #158
    //   Java source line #1095	-> byte code offset #172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	pred	Procedure
    //   0	129	1	lis	Object
    //   11	118	2	lis	Object
    //   11	118	3	in	Object
    //   11	118	4	out	Object
    //   89	40	5	head	Object
    //   89	40	6	tail	Object
    // Exception table:
    //   from	to	target	type
    //   27	30	130	java/lang/ClassCastException
    //   43	46	144	java/lang/ClassCastException
    //   64	67	158	java/lang/ClassCastException
    //   81	84	172	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object partition$Ex(Procedure pred, Object lis)
  {
    // Byte code:
    //   0: getstatic 438	gnu/kawa/slib/srfi1:Lit2	Lgnu/mapping/SimpleSymbol;
    //   3: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   6: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   9: astore_2
    //   10: getstatic 438	gnu/kawa/slib/srfi1:Lit2	Lgnu/mapping/SimpleSymbol;
    //   13: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   16: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   19: astore_3
    //   20: aload_2
    //   21: aload_3
    //   22: aload_1
    //   23: astore 6
    //   25: astore 5
    //   27: astore 4
    //   29: aload 6
    //   31: invokestatic 431	gnu/kawa/slib/srfi1:isNotPair	(Ljava/lang/Object;)Z
    //   34: ifeq +55 -> 89
    //   37: aload 4
    //   39: ldc -118
    //   41: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   44: dup
    //   45: astore 7
    //   47: checkcast 138	gnu/lists/Pair
    //   50: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   53: invokestatic 144	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   56: aload 5
    //   58: ldc -118
    //   60: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   63: dup
    //   64: astore 7
    //   66: checkcast 138	gnu/lists/Pair
    //   69: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   72: invokestatic 144	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   75: aload_2
    //   76: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   79: aload_3
    //   80: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   83: invokestatic 242	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
    //   86: goto +115 -> 201
    //   89: aload_0
    //   90: aload 6
    //   92: ldc -118
    //   94: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   97: dup
    //   98: astore 7
    //   100: checkcast 138	gnu/lists/Pair
    //   103: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   106: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   112: ifeq +46 -> 158
    //   115: aload 4
    //   117: ldc -118
    //   119: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   122: dup
    //   123: astore 7
    //   125: checkcast 138	gnu/lists/Pair
    //   128: aload 6
    //   130: invokestatic 144	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   133: aload 6
    //   135: aload 6
    //   137: ldc -118
    //   139: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   142: dup
    //   143: astore 7
    //   145: checkcast 138	gnu/lists/Pair
    //   148: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   151: astore 6
    //   153: astore 4
    //   155: goto -126 -> 29
    //   158: aload 5
    //   160: ldc -118
    //   162: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   165: dup
    //   166: astore 7
    //   168: checkcast 138	gnu/lists/Pair
    //   171: aload 6
    //   173: invokestatic 144	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   176: aload 6
    //   178: aload 6
    //   180: ldc -118
    //   182: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   185: dup
    //   186: astore 7
    //   188: checkcast 138	gnu/lists/Pair
    //   191: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   194: astore 6
    //   196: astore 5
    //   198: goto -169 -> 29
    //   201: areturn
    //   202: new 122	gnu/mapping/WrongType
    //   205: dup_x1
    //   206: swap
    //   207: ldc -116
    //   209: iconst_1
    //   210: aload 7
    //   212: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   215: athrow
    //   216: new 122	gnu/mapping/WrongType
    //   219: dup_x1
    //   220: swap
    //   221: ldc -116
    //   223: iconst_1
    //   224: aload 7
    //   226: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    //   230: new 122	gnu/mapping/WrongType
    //   233: dup_x1
    //   234: swap
    //   235: ldc -89
    //   237: iconst_1
    //   238: aload 7
    //   240: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   243: athrow
    //   244: new 122	gnu/mapping/WrongType
    //   247: dup_x1
    //   248: swap
    //   249: ldc -116
    //   251: iconst_1
    //   252: aload 7
    //   254: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   257: athrow
    //   258: new 122	gnu/mapping/WrongType
    //   261: dup_x1
    //   262: swap
    //   263: ldc -107
    //   265: iconst_1
    //   266: aload 7
    //   268: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   271: athrow
    //   272: new 122	gnu/mapping/WrongType
    //   275: dup_x1
    //   276: swap
    //   277: ldc -116
    //   279: iconst_1
    //   280: aload 7
    //   282: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   285: athrow
    //   286: new 122	gnu/mapping/WrongType
    //   289: dup_x1
    //   290: swap
    //   291: ldc -107
    //   293: iconst_1
    //   294: aload 7
    //   296: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   299: athrow
    // Line number table:
    //   Java source line #1116	-> byte code offset #0
    //   Java source line #1117	-> byte code offset #0
    //   Java source line #1118	-> byte code offset #20
    //   Java source line #1119	-> byte code offset #29
    //   Java source line #1121	-> byte code offset #37
    //   Java source line #1122	-> byte code offset #56
    //   Java source line #1123	-> byte code offset #75
    //   Java source line #1124	-> byte code offset #89
    //   Java source line #1126	-> byte code offset #115
    //   Java source line #1127	-> byte code offset #133
    //   Java source line #1129	-> byte code offset #158
    //   Java source line #1130	-> byte code offset #176
    //   Java source line #1121	-> byte code offset #202
    //   Java source line #1122	-> byte code offset #216
    //   Java source line #1124	-> byte code offset #230
    //   Java source line #1126	-> byte code offset #244
    //   Java source line #1127	-> byte code offset #258
    //   Java source line #1129	-> byte code offset #272
    //   Java source line #1130	-> byte code offset #286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	pred	Procedure
    //   0	201	1	lis	Object
    //   20	181	2	in$Mnhead	Pair
    //   20	181	3	out$Mnhead	Pair
    //   29	172	4	in	Object
    //   29	172	5	out	Object
    //   29	172	6	lis	Object
    // Exception table:
    //   from	to	target	type
    //   47	50	202	java/lang/ClassCastException
    //   66	69	216	java/lang/ClassCastException
    //   100	103	230	java/lang/ClassCastException
    //   125	128	244	java/lang/ClassCastException
    //   145	148	258	java/lang/ClassCastException
    //   168	171	272	java/lang/ClassCastException
    //   188	191	286	java/lang/ClassCastException
  }
  
  public static Object delete(Object paramObject1, Object paramObject2)
  {
    return delete(paramObject1, paramObject2, kawa.standard.Scheme.isEqual);
  }
  
  public static Object delete$Ex(Object paramObject1, Object paramObject2)
  {
    return delete$Ex(paramObject1, paramObject2, kawa.standard.Scheme.isEqual);
  }
  
  public static Object deleteDuplicates(Object paramObject)
  {
    return deleteDuplicates(paramObject, kawa.standard.Scheme.isEqual);
  }
  
  public static Object deleteDuplicates$Ex(Object paramObject)
  {
    return deleteDuplicates$Ex(paramObject, kawa.standard.Scheme.isEqual);
  }
  
  /* Error */
  public static LList alistCopy(Object alist)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 267	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   4: astore_1
    //   5: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   8: astore_2
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_1
    //   12: invokeinterface 273 1 0
    //   17: ifeq +75 -> 92
    //   20: aload_1
    //   21: invokeinterface 277 1 0
    //   26: astore 4
    //   28: new 138	gnu/lists/Pair
    //   31: dup
    //   32: aload 4
    //   34: ldc -118
    //   36: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   39: dup
    //   40: astore 6
    //   42: checkcast 138	gnu/lists/Pair
    //   45: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   48: aload 4
    //   50: ldc -118
    //   52: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   55: dup
    //   56: astore 6
    //   58: checkcast 138	gnu/lists/Pair
    //   61: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   64: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   67: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   70: invokespecial 280	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   73: aload_3
    //   74: ifnonnull +8 -> 82
    //   77: dup
    //   78: astore_2
    //   79: goto +9 -> 88
    //   82: aload_3
    //   83: swap
    //   84: dup_x1
    //   85: invokevirtual 284	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   88: astore_3
    //   89: goto -78 -> 11
    //   92: aload_2
    //   93: areturn
    //   94: new 122	gnu/mapping/WrongType
    //   97: dup_x1
    //   98: swap
    //   99: ldc -89
    //   101: iconst_1
    //   102: aload 6
    //   104: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   107: athrow
    //   108: new 122	gnu/mapping/WrongType
    //   111: dup_x1
    //   112: swap
    //   113: ldc -107
    //   115: iconst_1
    //   116: aload 6
    //   118: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   121: athrow
    // Line number table:
    //   Java source line #1262	-> byte code offset #0
    //   Java source line #1263	-> byte code offset #0
    //   Java source line #1264	-> byte code offset #0
    //   Java source line #1263	-> byte code offset #32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	alist	Object
    // Exception table:
    //   from	to	target	type
    //   42	45	94	java/lang/ClassCastException
    //   58	61	108	java/lang/ClassCastException
  }
  
  public static Object alistDelete(Object paramObject1, Object paramObject2)
  {
    return alistDelete(paramObject1, paramObject2, kawa.standard.Scheme.isEqual);
  }
  
  public static Object alistDelete$Ex(Object paramObject1, Object paramObject2)
  {
    return alistDelete$Ex(paramObject1, paramObject2, kawa.standard.Scheme.isEqual);
  }
  
  /* Error */
  public static Object find(Object pred, Object list)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 68
    //   3: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore_3
    //   8: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   11: aload_1
    //   12: invokestatic 546	gnu/kawa/slib/srfi1:findTail	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   15: astore_2
    //   16: aload_2
    //   17: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   20: ifeq +20 -> 40
    //   23: aload_2
    //   24: ldc -118
    //   26: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   29: dup
    //   30: astore_3
    //   31: checkcast 138	gnu/lists/Pair
    //   34: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   37: goto +6 -> 43
    //   40: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   43: areturn
    //   44: new 122	gnu/mapping/WrongType
    //   47: dup_x1
    //   48: swap
    //   49: ldc_w 543
    //   52: iconst_0
    //   53: aload_3
    //   54: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   57: athrow
    //   58: new 122	gnu/mapping/WrongType
    //   61: dup_x1
    //   62: swap
    //   63: ldc -89
    //   65: iconst_1
    //   66: aload_3
    //   67: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   70: athrow
    // Line number table:
    //   Java source line #1276	-> byte code offset #0
    //   Java source line #1277	-> byte code offset #0
    //   Java source line #10000	-> byte code offset #23
    //   Java source line #1277	-> byte code offset #44
    //   Java source line #10000	-> byte code offset #58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	pred	Object
    //   0	43	1	list	Object
    //   15	9	2	temp	Object
    //   7	60	3	localObject1	Object
    //   44	1	4	localClassCastException1	ClassCastException
    //   58	1	5	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   8	11	44	java/lang/ClassCastException
    //   31	34	58	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object takeWhile$Ex(Procedure pred, Object lis)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   4: istore_2
    //   5: iload_2
    //   6: ifeq +10 -> 16
    //   9: iload_2
    //   10: ifeq +36 -> 46
    //   13: goto +27 -> 40
    //   16: aload_0
    //   17: aload_1
    //   18: ldc -118
    //   20: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   23: dup
    //   24: astore_3
    //   25: checkcast 138	gnu/lists/Pair
    //   28: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   31: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   37: ifne +9 -> 46
    //   40: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   43: goto +99 -> 142
    //   46: aload_1
    //   47: aload_1
    //   48: ldc -118
    //   50: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   53: dup
    //   54: astore_3
    //   55: checkcast 138	gnu/lists/Pair
    //   58: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   61: astore 4
    //   63: astore_3
    //   64: aload 4
    //   66: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   69: ifeq +72 -> 141
    //   72: aload 4
    //   74: ldc -118
    //   76: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   79: dup
    //   80: astore 6
    //   82: checkcast 138	gnu/lists/Pair
    //   85: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   88: astore 5
    //   90: aload_0
    //   91: aload 5
    //   93: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   99: ifeq +24 -> 123
    //   102: aload 4
    //   104: aload 4
    //   106: ldc -118
    //   108: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   111: dup
    //   112: astore 6
    //   114: checkcast 138	gnu/lists/Pair
    //   117: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   120: goto -59 -> 61
    //   123: aload_3
    //   124: ldc -118
    //   126: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   129: dup
    //   130: astore 6
    //   132: checkcast 138	gnu/lists/Pair
    //   135: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   138: invokestatic 144	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   141: aload_1
    //   142: areturn
    //   143: new 122	gnu/mapping/WrongType
    //   146: dup_x1
    //   147: swap
    //   148: ldc -89
    //   150: iconst_1
    //   151: aload_3
    //   152: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   155: athrow
    //   156: new 122	gnu/mapping/WrongType
    //   159: dup_x1
    //   160: swap
    //   161: ldc -107
    //   163: iconst_1
    //   164: aload_3
    //   165: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   168: athrow
    //   169: new 122	gnu/mapping/WrongType
    //   172: dup_x1
    //   173: swap
    //   174: ldc -89
    //   176: iconst_1
    //   177: aload 6
    //   179: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   182: athrow
    //   183: new 122	gnu/mapping/WrongType
    //   186: dup_x1
    //   187: swap
    //   188: ldc -107
    //   190: iconst_1
    //   191: aload 6
    //   193: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   196: athrow
    //   197: new 122	gnu/mapping/WrongType
    //   200: dup_x1
    //   201: swap
    //   202: ldc -116
    //   204: iconst_1
    //   205: aload 6
    //   207: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   210: athrow
    // Line number table:
    //   Java source line #1301	-> byte code offset #0
    //   Java source line #1302	-> byte code offset #0
    //   Java source line #1303	-> byte code offset #46
    //   Java source line #1304	-> byte code offset #64
    //   Java source line #1305	-> byte code offset #72
    //   Java source line #1306	-> byte code offset #90
    //   Java source line #1307	-> byte code offset #123
    //   Java source line #1308	-> byte code offset #141
    //   Java source line #1302	-> byte code offset #143
    //   Java source line #1303	-> byte code offset #156
    //   Java source line #1305	-> byte code offset #169
    //   Java source line #1306	-> byte code offset #183
    //   Java source line #1307	-> byte code offset #197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	pred	Procedure
    //   0	142	1	lis	Object
    //   4	6	2	x	boolean
    //   24	31	3	localObject1	Object
    //   63	102	3	prev	Object
    //   61	1	4	localObject2	Object
    //   64	41	4	rest	Object
    //   88	4	5	x	Object
    //   80	126	6	localObject3	Object
    //   143	1	9	localClassCastException1	ClassCastException
    //   156	1	10	localClassCastException2	ClassCastException
    //   169	1	11	localClassCastException3	ClassCastException
    //   183	1	12	localClassCastException4	ClassCastException
    //   197	1	13	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   25	28	143	java/lang/ClassCastException
    //   55	58	156	java/lang/ClassCastException
    //   82	85	169	java/lang/ClassCastException
    //   114	117	183	java/lang/ClassCastException
    //   132	135	197	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object span$Ex(Procedure pred, Object lis)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   4: istore_2
    //   5: iload_2
    //   6: ifeq +10 -> 16
    //   9: iload_2
    //   10: ifeq +40 -> 50
    //   13: goto +27 -> 40
    //   16: aload_0
    //   17: aload_1
    //   18: ldc -118
    //   20: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   23: dup
    //   24: astore_3
    //   25: checkcast 138	gnu/lists/Pair
    //   28: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   31: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   37: ifne +13 -> 50
    //   40: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   43: aload_1
    //   44: invokestatic 242	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
    //   47: goto +114 -> 161
    //   50: aload_1
    //   51: aload_1
    //   52: ldc -118
    //   54: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   57: dup
    //   58: astore 4
    //   60: checkcast 138	gnu/lists/Pair
    //   63: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   66: astore 5
    //   68: astore 4
    //   70: aload 5
    //   72: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   75: ifeq +8 -> 83
    //   78: aload 5
    //   80: goto +75 -> 155
    //   83: aload 5
    //   85: ldc -118
    //   87: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   90: dup
    //   91: astore 7
    //   93: checkcast 138	gnu/lists/Pair
    //   96: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   99: astore 6
    //   101: aload_0
    //   102: aload 6
    //   104: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   110: ifeq +24 -> 134
    //   113: aload 5
    //   115: aload 5
    //   117: ldc -118
    //   119: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   122: dup
    //   123: astore 7
    //   125: checkcast 138	gnu/lists/Pair
    //   128: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   131: goto -65 -> 66
    //   134: aload 4
    //   136: ldc -118
    //   138: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   141: dup
    //   142: astore 7
    //   144: checkcast 138	gnu/lists/Pair
    //   147: getstatic 66	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   150: invokestatic 144	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   153: aload 5
    //   155: astore_3
    //   156: aload_1
    //   157: aload_3
    //   158: invokestatic 242	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
    //   161: areturn
    //   162: new 122	gnu/mapping/WrongType
    //   165: dup_x1
    //   166: swap
    //   167: ldc -89
    //   169: iconst_1
    //   170: aload_3
    //   171: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   174: athrow
    //   175: new 122	gnu/mapping/WrongType
    //   178: dup_x1
    //   179: swap
    //   180: ldc -107
    //   182: iconst_1
    //   183: aload 4
    //   185: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   188: athrow
    //   189: new 122	gnu/mapping/WrongType
    //   192: dup_x1
    //   193: swap
    //   194: ldc -89
    //   196: iconst_1
    //   197: aload 7
    //   199: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   202: athrow
    //   203: new 122	gnu/mapping/WrongType
    //   206: dup_x1
    //   207: swap
    //   208: ldc -107
    //   210: iconst_1
    //   211: aload 7
    //   213: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    //   217: new 122	gnu/mapping/WrongType
    //   220: dup_x1
    //   221: swap
    //   222: ldc -116
    //   224: iconst_1
    //   225: aload 7
    //   227: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   230: athrow
    // Line number table:
    //   Java source line #1319	-> byte code offset #0
    //   Java source line #1320	-> byte code offset #0
    //   Java source line #1321	-> byte code offset #50
    //   Java source line #1322	-> byte code offset #70
    //   Java source line #1323	-> byte code offset #83
    //   Java source line #1324	-> byte code offset #101
    //   Java source line #1325	-> byte code offset #134
    //   Java source line #1326	-> byte code offset #153
    //   Java source line #1327	-> byte code offset #156
    //   Java source line #1320	-> byte code offset #162
    //   Java source line #1321	-> byte code offset #175
    //   Java source line #1323	-> byte code offset #189
    //   Java source line #1324	-> byte code offset #203
    //   Java source line #1325	-> byte code offset #217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	pred	Procedure
    //   0	161	1	lis	Object
    //   4	6	2	x	boolean
    //   24	1	3	localObject1	Object
    //   155	16	3	suffix	Object
    //   58	1	4	localObject2	Object
    //   68	116	4	prev	Object
    //   66	1	5	localObject3	Object
    //   70	84	5	rest	Object
    //   99	4	6	x	Object
    //   91	135	7	localObject4	Object
    //   162	1	11	localClassCastException1	ClassCastException
    //   175	1	12	localClassCastException2	ClassCastException
    //   189	1	13	localClassCastException3	ClassCastException
    //   203	1	14	localClassCastException4	ClassCastException
    //   217	1	15	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   25	28	162	java/lang/ClassCastException
    //   60	63	175	java/lang/ClassCastException
    //   93	96	189	java/lang/ClassCastException
    //   125	128	203	java/lang/ClassCastException
    //   144	147	217	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object any$V(Procedure pred, Object lis1, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 132	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: aload_3
    //   10: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   13: ifeq +146 -> 159
    //   16: aload_1
    //   17: aload_3
    //   18: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   21: invokestatic 428	gnu/kawa/slib/srfi1:$PcCars$PlCdrs	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: astore 4
    //   26: iconst_0
    //   27: istore 5
    //   29: aload 4
    //   31: iload 5
    //   33: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   36: istore 5
    //   38: aload 4
    //   40: iload 5
    //   42: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   45: astore 6
    //   47: aload 4
    //   49: iload 5
    //   51: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   54: istore 5
    //   56: aload 4
    //   58: iload 5
    //   60: invokestatic 298	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   63: astore 7
    //   65: aload 6
    //   67: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   70: ifeq +83 -> 153
    //   73: aload 6
    //   75: aload 7
    //   77: astore 9
    //   79: astore 8
    //   81: aload 9
    //   83: invokestatic 328	gnu/kawa/slib/srfi1:$PcCars$PlCdrs$SlPair	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   86: astore 10
    //   88: aload 10
    //   90: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   93: astore 11
    //   95: aload 10
    //   97: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   100: astore 12
    //   102: aload 11
    //   104: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   107: ifeq +34 -> 141
    //   110: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   113: aload_0
    //   114: aload 8
    //   116: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: astore 13
    //   121: aload 13
    //   123: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   126: ifeq +8 -> 134
    //   129: aload 13
    //   131: goto +145 -> 276
    //   134: aload 11
    //   136: aload 12
    //   138: goto -61 -> 77
    //   141: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   144: aload_0
    //   145: aload 8
    //   147: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: goto +126 -> 276
    //   153: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   156: goto +120 -> 276
    //   159: aload_1
    //   160: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   163: ifne +110 -> 273
    //   166: aload_1
    //   167: ldc -118
    //   169: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   172: dup
    //   173: astore 4
    //   175: checkcast 138	gnu/lists/Pair
    //   178: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   181: aload_1
    //   182: ldc -118
    //   184: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   187: dup
    //   188: astore 4
    //   190: checkcast 138	gnu/lists/Pair
    //   193: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   196: astore 5
    //   198: astore 4
    //   200: aload 5
    //   202: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   205: ifeq +12 -> 217
    //   208: aload_0
    //   209: aload 4
    //   211: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   214: goto +62 -> 276
    //   217: aload_0
    //   218: aload 4
    //   220: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   223: astore 6
    //   225: aload 6
    //   227: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   230: ifeq +8 -> 238
    //   233: aload 6
    //   235: goto +41 -> 276
    //   238: aload 5
    //   240: ldc -118
    //   242: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   245: dup
    //   246: astore 7
    //   248: checkcast 138	gnu/lists/Pair
    //   251: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   254: aload 5
    //   256: ldc -118
    //   258: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   261: dup
    //   262: astore 7
    //   264: checkcast 138	gnu/lists/Pair
    //   267: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   270: goto -74 -> 196
    //   273: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   276: areturn
    //   277: new 122	gnu/mapping/WrongType
    //   280: dup_x1
    //   281: swap
    //   282: ldc -89
    //   284: iconst_1
    //   285: aload 4
    //   287: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   290: athrow
    //   291: new 122	gnu/mapping/WrongType
    //   294: dup_x1
    //   295: swap
    //   296: ldc -107
    //   298: iconst_1
    //   299: aload 4
    //   301: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   304: athrow
    //   305: new 122	gnu/mapping/WrongType
    //   308: dup_x1
    //   309: swap
    //   310: ldc -89
    //   312: iconst_1
    //   313: aload 7
    //   315: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   318: athrow
    //   319: new 122	gnu/mapping/WrongType
    //   322: dup_x1
    //   323: swap
    //   324: ldc -107
    //   326: iconst_1
    //   327: aload 7
    //   329: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   332: athrow
    // Line number table:
    //   Java source line #1333	-> byte code offset #0
    //   Java source line #1334	-> byte code offset #9
    //   Java source line #1337	-> byte code offset #16
    //   Java source line #1338	-> byte code offset #65
    //   Java source line #1339	-> byte code offset #73
    //   Java source line #1340	-> byte code offset #81
    //   Java source line #1341	-> byte code offset #88
    //   Java source line #1340	-> byte code offset #95
    //   Java source line #1342	-> byte code offset #95
    //   Java source line #1343	-> byte code offset #102
    //   Java source line #1344	-> byte code offset #110
    //   Java source line #1345	-> byte code offset #141
    //   Java source line #1348	-> byte code offset #159
    //   Java source line #1349	-> byte code offset #166
    //   Java source line #1350	-> byte code offset #200
    //   Java source line #1351	-> byte code offset #208
    //   Java source line #1352	-> byte code offset #217
    //   Java source line #1349	-> byte code offset #277
    //   Java source line #1352	-> byte code offset #305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	pred	Procedure
    //   0	276	1	lis1	Object
    //   0	276	2	argsArray	Object[]
    //   0	18	3	lists	LList
    //   6	183	4	localObject1	Object
    //   198	102	4	head	Object
    //   27	32	5	i	int
    //   196	1	5	localObject2	Object
    //   200	55	5	tail	Object
    //   45	1	6	localObject3	Object
    //   65	9	6	heads	Object
    //   223	11	6	x	Object
    //   63	265	7	tails	Object
    //   79	67	8	heads	Object
    //   77	1	9	localObject4	Object
    //   81	1	9	tails	Object
    //   86	10	10	split	Pair
    //   93	42	11	next$Mnheads	Object
    //   100	37	12	next$Mntails	Object
    //   119	11	13	x	Object
    //   277	1	20	localClassCastException1	ClassCastException
    //   291	1	21	localClassCastException2	ClassCastException
    //   305	1	22	localClassCastException3	ClassCastException
    //   319	1	23	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   175	178	277	java/lang/ClassCastException
    //   190	193	291	java/lang/ClassCastException
    //   248	251	305	java/lang/ClassCastException
    //   264	267	319	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object every$V(Procedure pred, Object lis1, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 132	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: aload_3
    //   10: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   13: ifeq +191 -> 204
    //   16: aload_1
    //   17: aload_3
    //   18: invokestatic 17	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   21: invokestatic 428	gnu/kawa/slib/srfi1:$PcCars$PlCdrs	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: astore 4
    //   26: iconst_0
    //   27: istore 5
    //   29: aload 4
    //   31: iload 5
    //   33: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   36: istore 5
    //   38: aload 4
    //   40: iload 5
    //   42: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   45: astore 6
    //   47: aload 4
    //   49: iload 5
    //   51: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   54: istore 5
    //   56: aload 4
    //   58: iload 5
    //   60: invokestatic 298	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   63: astore 7
    //   65: aload 6
    //   67: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   70: ifeq +7 -> 77
    //   73: iconst_0
    //   74: goto +4 -> 78
    //   77: iconst_1
    //   78: istore 8
    //   80: iload 8
    //   82: ifeq +20 -> 102
    //   85: iload 8
    //   87: ifeq +9 -> 96
    //   90: getstatic 163	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   93: goto +240 -> 333
    //   96: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   99: goto +234 -> 333
    //   102: aload 6
    //   104: aload 7
    //   106: astore 10
    //   108: astore 9
    //   110: aload 10
    //   112: invokestatic 428	gnu/kawa/slib/srfi1:$PcCars$PlCdrs	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: astore 11
    //   117: iconst_0
    //   118: istore 12
    //   120: aload 11
    //   122: iload 12
    //   124: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   127: istore 12
    //   129: aload 11
    //   131: iload 12
    //   133: invokestatic 295	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   136: astore 13
    //   138: aload 11
    //   140: iload 12
    //   142: invokestatic 291	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   145: istore 12
    //   147: aload 11
    //   149: iload 12
    //   151: invokestatic 298	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   154: astore 14
    //   156: aload 13
    //   158: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   161: ifeq +31 -> 192
    //   164: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   167: aload_0
    //   168: aload 9
    //   170: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   176: ifeq +10 -> 186
    //   179: aload 13
    //   181: aload 14
    //   183: goto -77 -> 106
    //   186: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   189: goto +144 -> 333
    //   192: getstatic 191	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   195: aload_0
    //   196: aload 9
    //   198: invokevirtual 104	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: goto +132 -> 333
    //   204: aload_1
    //   205: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   208: istore 4
    //   210: iload 4
    //   212: ifeq +20 -> 232
    //   215: iload 4
    //   217: ifeq +9 -> 226
    //   220: getstatic 163	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   223: goto +110 -> 333
    //   226: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   229: goto +104 -> 333
    //   232: aload_1
    //   233: ldc -118
    //   235: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   238: dup
    //   239: astore 5
    //   241: checkcast 138	gnu/lists/Pair
    //   244: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   247: aload_1
    //   248: ldc -118
    //   250: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   253: dup
    //   254: astore 5
    //   256: checkcast 138	gnu/lists/Pair
    //   259: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   262: astore 6
    //   264: astore 5
    //   266: aload 6
    //   268: invokestatic 172	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
    //   271: ifeq +12 -> 283
    //   274: aload_0
    //   275: aload 5
    //   277: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   280: goto +53 -> 333
    //   283: aload_0
    //   284: aload 5
    //   286: invokevirtual 72	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   289: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   292: ifeq +38 -> 330
    //   295: aload 6
    //   297: ldc -118
    //   299: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   302: dup
    //   303: astore 7
    //   305: checkcast 138	gnu/lists/Pair
    //   308: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   311: aload 6
    //   313: ldc -118
    //   315: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   318: dup
    //   319: astore 7
    //   321: checkcast 138	gnu/lists/Pair
    //   324: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   327: goto -65 -> 262
    //   330: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   333: areturn
    //   334: new 122	gnu/mapping/WrongType
    //   337: dup_x1
    //   338: swap
    //   339: ldc -89
    //   341: iconst_1
    //   342: aload 5
    //   344: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   347: athrow
    //   348: new 122	gnu/mapping/WrongType
    //   351: dup_x1
    //   352: swap
    //   353: ldc -107
    //   355: iconst_1
    //   356: aload 5
    //   358: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   361: athrow
    //   362: new 122	gnu/mapping/WrongType
    //   365: dup_x1
    //   366: swap
    //   367: ldc -89
    //   369: iconst_1
    //   370: aload 7
    //   372: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   375: athrow
    //   376: new 122	gnu/mapping/WrongType
    //   379: dup_x1
    //   380: swap
    //   381: ldc -107
    //   383: iconst_1
    //   384: aload 7
    //   386: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   389: athrow
    // Line number table:
    //   Java source line #1361	-> byte code offset #0
    //   Java source line #1362	-> byte code offset #9
    //   Java source line #1365	-> byte code offset #16
    //   Java source line #1366	-> byte code offset #65
    //   Java source line #1367	-> byte code offset #102
    //   Java source line #1368	-> byte code offset #110
    //   Java source line #1369	-> byte code offset #156
    //   Java source line #1370	-> byte code offset #164
    //   Java source line #1371	-> byte code offset #192
    //   Java source line #1374	-> byte code offset #204
    //   Java source line #1375	-> byte code offset #232
    //   Java source line #1376	-> byte code offset #266
    //   Java source line #1377	-> byte code offset #274
    //   Java source line #1378	-> byte code offset #283
    //   Java source line #1375	-> byte code offset #334
    //   Java source line #1378	-> byte code offset #362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	pred	Procedure
    //   0	333	1	lis1	Object
    //   0	333	2	argsArray	Object[]
    //   0	18	3	lists	LList
    //   6	51	4	localObject1	Object
    //   208	8	4	x	boolean
    //   27	32	5	i	int
    //   239	16	5	localObject2	Object
    //   264	93	5	head	Object
    //   45	1	6	localObject3	Object
    //   65	198	6	heads	Object
    //   266	46	6	tail	Object
    //   63	322	7	tails	Object
    //   78	8	8	x	boolean
    //   108	89	9	heads	Object
    //   106	1	10	localObject4	Object
    //   110	1	10	tails	Object
    //   115	33	11	localObject5	Object
    //   118	32	12	j	int
    //   136	1	13	localObject6	Object
    //   156	24	13	next$Mnheads	Object
    //   154	28	14	next$Mntails	Object
    //   334	1	22	localClassCastException1	ClassCastException
    //   348	1	23	localClassCastException2	ClassCastException
    //   362	1	24	localClassCastException3	ClassCastException
    //   376	1	25	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   241	244	334	java/lang/ClassCastException
    //   256	259	348	java/lang/ClassCastException
    //   305	308	362	java/lang/ClassCastException
    //   321	324	376	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object lset$Ls$Eq$V(Procedure $Eq, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 132	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   12: ifeq +7 -> 19
    //   15: iconst_0
    //   16: goto +4 -> 20
    //   19: iconst_1
    //   20: istore_3
    //   21: iload_3
    //   22: ifeq +19 -> 41
    //   25: iload_3
    //   26: ifeq +9 -> 35
    //   29: getstatic 163	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   32: goto +157 -> 189
    //   35: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   38: goto +151 -> 189
    //   41: aload_2
    //   42: dup
    //   43: astore 4
    //   45: checkcast 138	gnu/lists/Pair
    //   48: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   51: aload_2
    //   52: dup
    //   53: astore 4
    //   55: checkcast 138	gnu/lists/Pair
    //   58: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   61: astore 5
    //   63: astore 4
    //   65: aload 5
    //   67: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   70: ifeq +7 -> 77
    //   73: iconst_0
    //   74: goto +4 -> 78
    //   77: iconst_1
    //   78: istore 6
    //   80: iload 6
    //   82: ifeq +20 -> 102
    //   85: iload 6
    //   87: ifeq +9 -> 96
    //   90: getstatic 163	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   93: goto +96 -> 189
    //   96: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   99: goto +90 -> 189
    //   102: aload 5
    //   104: ldc -118
    //   106: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   109: dup
    //   110: astore 8
    //   112: checkcast 138	gnu/lists/Pair
    //   115: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   118: astore 7
    //   120: aload 5
    //   122: ldc -118
    //   124: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   127: dup
    //   128: astore 9
    //   130: checkcast 138	gnu/lists/Pair
    //   133: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   136: astore 8
    //   138: aload 7
    //   140: aload 4
    //   142: if_acmpne +7 -> 149
    //   145: iconst_1
    //   146: goto +4 -> 150
    //   149: iconst_0
    //   150: istore 9
    //   152: iload 9
    //   154: ifeq +11 -> 165
    //   157: iload 9
    //   159: ifeq +27 -> 186
    //   162: goto +17 -> 179
    //   165: aload_0
    //   166: aload 4
    //   168: aload 7
    //   170: invokestatic 577	gnu/kawa/slib/srfi1:$PcLset2$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   176: ifeq +10 -> 186
    //   179: aload 7
    //   181: aload 8
    //   183: goto -122 -> 61
    //   186: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   189: areturn
    //   190: new 122	gnu/mapping/WrongType
    //   193: dup_x1
    //   194: swap
    //   195: ldc -89
    //   197: iconst_1
    //   198: aload 4
    //   200: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   203: athrow
    //   204: new 122	gnu/mapping/WrongType
    //   207: dup_x1
    //   208: swap
    //   209: ldc -107
    //   211: iconst_1
    //   212: aload 4
    //   214: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   217: athrow
    //   218: new 122	gnu/mapping/WrongType
    //   221: dup_x1
    //   222: swap
    //   223: ldc -89
    //   225: iconst_1
    //   226: aload 8
    //   228: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   231: athrow
    //   232: new 122	gnu/mapping/WrongType
    //   235: dup_x1
    //   236: swap
    //   237: ldc -107
    //   239: iconst_1
    //   240: aload 9
    //   242: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   245: athrow
    // Line number table:
    //   Java source line #1432	-> byte code offset #0
    //   Java source line #1433	-> byte code offset #8
    //   Java source line #1434	-> byte code offset #41
    //   Java source line #1435	-> byte code offset #65
    //   Java source line #1436	-> byte code offset #102
    //   Java source line #1437	-> byte code offset #138
    //   Java source line #1438	-> byte code offset #165
    //   Java source line #1439	-> byte code offset #179
    //   Java source line #1434	-> byte code offset #190
    //   Java source line #1436	-> byte code offset #218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	$Eq	Procedure
    //   0	189	1	argsArray	Object[]
    //   0	52	2	lists	LList
    //   6	1	3	localLList1	LList
    //   20	6	3	x	boolean
    //   43	11	4	localLList2	LList
    //   63	150	4	s1	Object
    //   61	1	5	localObject1	Object
    //   65	56	5	rest	Object
    //   78	8	6	x	boolean
    //   118	1	7	localObject2	Object
    //   138	42	7	s2	Object
    //   110	1	8	localObject3	Object
    //   136	91	8	rest	Object
    //   128	1	9	localObject4	Object
    //   150	91	9	x	boolean
    //   190	1	16	localClassCastException1	ClassCastException
    //   204	1	17	localClassCastException2	ClassCastException
    //   218	1	18	localClassCastException3	ClassCastException
    //   232	1	19	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   45	48	190	java/lang/ClassCastException
    //   55	58	204	java/lang/ClassCastException
    //   112	115	218	java/lang/ClassCastException
    //   130	133	232	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object lset$Eq$V(Procedure $Eq, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokestatic 132	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore_3
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   12: ifeq +7 -> 19
    //   15: iconst_0
    //   16: goto +4 -> 20
    //   19: iconst_1
    //   20: istore_3
    //   21: iload_3
    //   22: ifeq +19 -> 41
    //   25: iload_3
    //   26: ifeq +9 -> 35
    //   29: getstatic 163	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   32: goto +171 -> 203
    //   35: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   38: goto +165 -> 203
    //   41: aload_2
    //   42: dup
    //   43: astore 4
    //   45: checkcast 138	gnu/lists/Pair
    //   48: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   51: aload_2
    //   52: dup
    //   53: astore 4
    //   55: checkcast 138	gnu/lists/Pair
    //   58: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   61: astore 5
    //   63: astore 4
    //   65: aload 5
    //   67: invokestatic 147	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   70: ifeq +7 -> 77
    //   73: iconst_0
    //   74: goto +4 -> 78
    //   77: iconst_1
    //   78: istore 6
    //   80: iload 6
    //   82: ifeq +20 -> 102
    //   85: iload 6
    //   87: ifeq +9 -> 96
    //   90: getstatic 163	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   93: goto +110 -> 203
    //   96: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   99: goto +104 -> 203
    //   102: aload 5
    //   104: ldc -118
    //   106: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   109: dup
    //   110: astore 8
    //   112: checkcast 138	gnu/lists/Pair
    //   115: invokestatic 169	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   118: astore 7
    //   120: aload 5
    //   122: ldc -118
    //   124: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   127: dup
    //   128: astore 9
    //   130: checkcast 138	gnu/lists/Pair
    //   133: invokestatic 151	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   136: astore 8
    //   138: aload 4
    //   140: aload 7
    //   142: if_acmpne +7 -> 149
    //   145: iconst_1
    //   146: goto +4 -> 150
    //   149: iconst_0
    //   150: istore 9
    //   152: iload 9
    //   154: ifeq +11 -> 165
    //   157: iload 9
    //   159: ifeq +41 -> 200
    //   162: goto +31 -> 193
    //   165: aload_0
    //   166: aload 4
    //   168: aload 7
    //   170: invokestatic 577	gnu/kawa/slib/srfi1:$PcLset2$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   176: ifeq +24 -> 200
    //   179: aload_0
    //   180: aload 7
    //   182: aload 4
    //   184: invokestatic 577	gnu/kawa/slib/srfi1:$PcLset2$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: invokestatic 187	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   190: ifeq +10 -> 200
    //   193: aload 7
    //   195: aload 8
    //   197: goto -136 -> 61
    //   200: getstatic 157	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   203: areturn
    //   204: new 122	gnu/mapping/WrongType
    //   207: dup_x1
    //   208: swap
    //   209: ldc -89
    //   211: iconst_1
    //   212: aload 4
    //   214: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   217: athrow
    //   218: new 122	gnu/mapping/WrongType
    //   221: dup_x1
    //   222: swap
    //   223: ldc -107
    //   225: iconst_1
    //   226: aload 4
    //   228: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   231: athrow
    //   232: new 122	gnu/mapping/WrongType
    //   235: dup_x1
    //   236: swap
    //   237: ldc -89
    //   239: iconst_1
    //   240: aload 8
    //   242: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   245: athrow
    //   246: new 122	gnu/mapping/WrongType
    //   249: dup_x1
    //   250: swap
    //   251: ldc -107
    //   253: iconst_1
    //   254: aload 9
    //   256: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   259: athrow
    // Line number table:
    //   Java source line #1441	-> byte code offset #0
    //   Java source line #1442	-> byte code offset #8
    //   Java source line #1443	-> byte code offset #41
    //   Java source line #1444	-> byte code offset #65
    //   Java source line #1445	-> byte code offset #102
    //   Java source line #1446	-> byte code offset #120
    //   Java source line #1447	-> byte code offset #138
    //   Java source line #1448	-> byte code offset #165
    //   Java source line #1449	-> byte code offset #193
    //   Java source line #1443	-> byte code offset #204
    //   Java source line #1445	-> byte code offset #232
    //   Java source line #1446	-> byte code offset #246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	$Eq	Procedure
    //   0	203	1	argsArray	Object[]
    //   0	52	2	lists	LList
    //   6	1	3	localLList1	LList
    //   20	6	3	x	boolean
    //   43	11	4	localLList2	LList
    //   63	164	4	s1	Object
    //   61	1	5	localObject1	Object
    //   65	56	5	rest	Object
    //   78	8	6	x	boolean
    //   118	1	7	localObject2	Object
    //   138	56	7	s2	Object
    //   110	1	8	localObject3	Object
    //   136	105	8	rest	Object
    //   128	1	9	localObject4	Object
    //   150	105	9	x	boolean
    //   204	1	16	localClassCastException1	ClassCastException
    //   218	1	17	localClassCastException2	ClassCastException
    //   232	1	18	localClassCastException3	ClassCastException
    //   246	1	19	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   45	48	204	java/lang/ClassCastException
    //   55	58	218	java/lang/ClassCastException
    //   112	115	232	java/lang/ClassCastException
    //   130	133	246	java/lang/ClassCastException
  }
  
  static
  {
    Lit103 = gnu.lists.PairWithPosition.make(srfi1.Lit99 = Symbol.valueOf("tail"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668888);
    Lit102 = Symbol.valueOf("car");
    Lit101 = Symbol.valueOf("lp");
    Lit100 = Symbol.valueOf("head");
    Lit98 = new Object[0];
    Lit97 = Symbol.valueOf("lset-diff+intersection!");
    Lit96 = Symbol.valueOf("lset-diff+intersection");
    Lit95 = Symbol.valueOf("lset-xor!");
    Lit94 = Symbol.valueOf("lset-xor");
    Lit93 = Symbol.valueOf("lset-difference!");
    Lit92 = Symbol.valueOf("lset-difference");
    Lit91 = Symbol.valueOf("lset-intersection!");
    Lit90 = Symbol.valueOf("lset-intersection");
    Lit89 = Symbol.valueOf("lset-union!");
    Lit88 = Symbol.valueOf("lset-union");
    Lit87 = Symbol.valueOf("lset-adjoin");
    Lit86 = Symbol.valueOf("lset=");
    Lit85 = Symbol.valueOf("lset<=");
    Lit84 = Symbol.valueOf("list-index");
    kawa.lang.SyntaxRule[] tmp203_200 = new kawa.lang.SyntaxRule[1];
    Object[] tmp237_234 = new Object[10];
    Object[] tmp238_237 = tmp237_234;
    tmp238_237[0] = Symbol.valueOf("let");
    Object[] tmp247_238 = tmp238_237;
    tmp247_238[1] = Lit101;
    Object[] tmp253_247 = tmp247_238;
    tmp253_247[2] = Lit100;
    Object[] tmp259_253 = tmp253_247;
    tmp259_253[3] = Lit102;
    Object[] tmp265_259 = tmp259_253;
    tmp265_259[4] = Lit99;
    Object[] tmp271_265 = tmp265_259;
    tmp271_265[5] = Lit104;
    Object[] tmp277_271 = tmp271_265;
    tmp277_271[6] = Symbol.valueOf("and");
    Object[] tmp287_277 = tmp277_271;
    SimpleSymbol tmp296_293 = Symbol.valueOf("null-list?");
    Lit12 = tmp296_293;
    tmp287_277[7] = gnu.lists.PairWithPosition.make(tmp296_293, Lit103, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668876);
    Object[] tmp313_287 = tmp287_277;
    tmp313_287[8] = gnu.lists.PairWithPosition.make(Lit100, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668900);
    tmp313_287[9] = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit101, gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit102, Lit103, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668910), gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit104, Lit103, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668921), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668921), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668910), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668906), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668906);
    tmp203_200[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit98, 2, "srfi1.scm:1382"), "\001\001", "\021\030\004\021\030\f¡I\021\030\024\b\021\030\034\b\013\b\021\030$\b\021\030,\b\013\b\021\0304\021\030<!\t\003\030D\030L", tmp237_234, 0);
    Lit83 = new kawa.lang.SyntaxRules(Lit98, tmp203_200, 2, srfi1.Lit82 = Symbol.valueOf("%every"));
    Lit81 = Symbol.valueOf("every");
    Lit80 = Symbol.valueOf("any");
    Lit79 = Symbol.valueOf("break!");
    Lit78 = Symbol.valueOf("break");
    Lit77 = Symbol.valueOf("span!");
    Lit76 = Symbol.valueOf("span");
    Lit75 = Symbol.valueOf("take-while!");
    Lit74 = Symbol.valueOf("drop-while");
    Lit73 = Symbol.valueOf("take-while");
    Lit72 = Symbol.valueOf("find-tail");
    Lit71 = Symbol.valueOf("find");
    Lit70 = Symbol.valueOf("alist-delete!");
    Lit69 = Symbol.valueOf("alist-delete");
    Lit68 = Symbol.valueOf("alist-copy");
    Lit67 = Symbol.valueOf("alist-cons");
    Lit66 = Symbol.valueOf("delete-duplicates!");
    Lit65 = Symbol.valueOf("delete-duplicates");
    Lit64 = Symbol.valueOf("delete!");
    Lit63 = Symbol.valueOf("delete");
    Lit62 = Symbol.valueOf("remove!");
    Lit61 = Symbol.valueOf("remove");
    Lit60 = Symbol.valueOf("partition!");
    Lit59 = Symbol.valueOf("partition");
    Lit58 = Symbol.valueOf("filter!");
    Lit57 = Symbol.valueOf("filter");
    Lit56 = Symbol.valueOf("filter-map");
    Lit55 = Symbol.valueOf("map!");
    Lit54 = Symbol.valueOf("pair-for-each");
    Lit53 = Symbol.valueOf("append-map!");
    Lit52 = Symbol.valueOf("append-map");
    Lit51 = Symbol.valueOf("reduce-right");
    Lit50 = Symbol.valueOf("reduce");
    Lit49 = Symbol.valueOf("pair-fold");
    Lit48 = Symbol.valueOf("pair-fold-right");
    Lit47 = Symbol.valueOf("fold-right");
    Lit46 = Symbol.valueOf("fold");
    Lit45 = Symbol.valueOf("unfold");
    Lit44 = Symbol.valueOf("unfold-right");
    Lit43 = Symbol.valueOf("count");
    Lit42 = Symbol.valueOf("concatenate!");
    Lit41 = Symbol.valueOf("concatenate");
    Lit40 = Symbol.valueOf("append-reverse!");
    Lit39 = Symbol.valueOf("append-reverse");
    Lit38 = Symbol.valueOf("append!");
    Lit37 = Symbol.valueOf("unzip5");
    Lit36 = Symbol.valueOf("unzip4");
    Lit35 = Symbol.valueOf("unzip3");
    Lit34 = Symbol.valueOf("unzip2");
    Lit33 = Symbol.valueOf("unzip1");
    Lit32 = Symbol.valueOf("last-pair");
    Lit31 = Symbol.valueOf("last");
    Lit30 = Symbol.valueOf("split-at!");
    Lit29 = Symbol.valueOf("split-at");
    Lit28 = Symbol.valueOf("drop-right!");
    Lit27 = Symbol.valueOf("drop-right");
    Lit26 = Symbol.valueOf("take-right");
    Lit25 = Symbol.valueOf("take!");
    Lit24 = Symbol.valueOf("drop");
    Lit23 = Symbol.valueOf("take");
    Lit22 = Symbol.valueOf("car+cdr");
    Lit21 = Symbol.valueOf("tenth");
    Lit20 = Symbol.valueOf("ninth");
    Lit19 = Symbol.valueOf("eighth");
    Lit18 = Symbol.valueOf("seventh");
    Lit17 = Symbol.valueOf("sixth");
    Lit16 = Symbol.valueOf("fifth");
    Lit15 = Symbol.valueOf("zip");
    Lit14 = Symbol.valueOf("length+");
    Lit13 = Symbol.valueOf("list=");
    Lit11 = Symbol.valueOf("not-pair?");
    Lit10 = Symbol.valueOf("circular-list?");
    Lit9 = Symbol.valueOf("dotted-list?");
    Lit8 = Symbol.valueOf("proper-list?");
    Lit7 = Symbol.valueOf("circular-list");
    Lit6 = Symbol.valueOf("iota");
    Lit5 = Symbol.valueOf("cons*");
    Lit4 = Symbol.valueOf("list-tabulate");
    Lit3 = Symbol.valueOf("xcons");
    Lit2 = Symbol.valueOf("tmp");
    Lit1 = gnu.math.IntNum.valueOf(1);
    Lit0 = gnu.math.IntNum.valueOf(0);
    $instance = new srfi1();
    srfi1 localSrfi1 = $instance;
    xcons = new ModuleMethod(localSrfi1, 34, Lit3, 8194);
    list$Mntabulate = new ModuleMethod(localSrfi1, 35, Lit4, 8194);
    cons$St = new ModuleMethod(localSrfi1, 36, Lit5, 61440);
    iota = new ModuleMethod(localSrfi1, 37, Lit6, 12289);
    circular$Mnlist = new ModuleMethod(localSrfi1, 40, Lit7, 61441);
    proper$Mnlist$Qu = new ModuleMethod(localSrfi1, 41, Lit8, 4097);
    dotted$Mnlist$Qu = new ModuleMethod(localSrfi1, 42, Lit9, 4097);
    circular$Mnlist$Qu = new ModuleMethod(localSrfi1, 43, Lit10, 4097);
    not$Mnpair$Qu = new ModuleMethod(localSrfi1, 44, Lit11, 4097);
    null$Mnlist$Qu = new ModuleMethod(localSrfi1, 45, Lit12, 4097);
    list$Eq = new ModuleMethod(localSrfi1, 46, Lit13, 61441);
    length$Pl = new ModuleMethod(localSrfi1, 47, Lit14, 4097);
    zip = new ModuleMethod(localSrfi1, 48, Lit15, 61441);
    fifth = new ModuleMethod(localSrfi1, 49, Lit16, 4097);
    sixth = new ModuleMethod(localSrfi1, 50, Lit17, 4097);
    seventh = new ModuleMethod(localSrfi1, 51, Lit18, 4097);
    eighth = new ModuleMethod(localSrfi1, 52, Lit19, 4097);
    ninth = new ModuleMethod(localSrfi1, 53, Lit20, 4097);
    tenth = new ModuleMethod(localSrfi1, 54, Lit21, 4097);
    car$Plcdr = new ModuleMethod(localSrfi1, 55, Lit22, 4097);
    take = new ModuleMethod(localSrfi1, 56, Lit23, 8194);
    drop = new ModuleMethod(localSrfi1, 57, Lit24, 8194);
    take$Ex = new ModuleMethod(localSrfi1, 58, Lit25, 8194);
    take$Mnright = new ModuleMethod(localSrfi1, 59, Lit26, 8194);
    drop$Mnright = new ModuleMethod(localSrfi1, 60, Lit27, 8194);
    drop$Mnright$Ex = new ModuleMethod(localSrfi1, 61, Lit28, 8194);
    split$Mnat = new ModuleMethod(localSrfi1, 62, Lit29, 8194);
    split$Mnat$Ex = new ModuleMethod(localSrfi1, 63, Lit30, 8194);
    last = new ModuleMethod(localSrfi1, 64, Lit31, 4097);
    last$Mnpair = new ModuleMethod(localSrfi1, 65, Lit32, 4097);
    unzip1 = new ModuleMethod(localSrfi1, 66, Lit33, 4097);
    unzip2 = new ModuleMethod(localSrfi1, 67, Lit34, 4097);
    unzip3 = new ModuleMethod(localSrfi1, 68, Lit35, 4097);
    unzip4 = new ModuleMethod(localSrfi1, 69, Lit36, 4097);
    unzip5 = new ModuleMethod(localSrfi1, 70, Lit37, 4097);
    append$Ex = new ModuleMethod(localSrfi1, 71, Lit38, 61440);
    append$Mnreverse = new ModuleMethod(localSrfi1, 72, Lit39, 8194);
    append$Mnreverse$Ex = new ModuleMethod(localSrfi1, 73, Lit40, 8194);
    concatenate = new ModuleMethod(localSrfi1, 74, Lit41, 4097);
    concatenate$Ex = new ModuleMethod(localSrfi1, 75, Lit42, 4097);
    count = new ModuleMethod(localSrfi1, 76, Lit43, 61442);
    unfold$Mnright = new ModuleMethod(localSrfi1, 77, Lit44, 20484);
    unfold = new ModuleMethod(localSrfi1, 79, Lit45, 61444);
    fold = new ModuleMethod(localSrfi1, 80, Lit46, 61443);
    fold$Mnright = new ModuleMethod(localSrfi1, 81, Lit47, 61443);
    pair$Mnfold$Mnright = new ModuleMethod(localSrfi1, 82, Lit48, 61443);
    pair$Mnfold = new ModuleMethod(localSrfi1, 83, Lit49, 61443);
    reduce = new ModuleMethod(localSrfi1, 84, Lit50, 12291);
    reduce$Mnright = new ModuleMethod(localSrfi1, 85, Lit51, 12291);
    append$Mnmap = new ModuleMethod(localSrfi1, 86, Lit52, 61442);
    append$Mnmap$Ex = new ModuleMethod(localSrfi1, 87, Lit53, 61442);
    pair$Mnfor$Mneach = new ModuleMethod(localSrfi1, 88, Lit54, 61442);
    map$Ex = new ModuleMethod(localSrfi1, 89, Lit55, 61442);
    filter$Mnmap = new ModuleMethod(localSrfi1, 90, Lit56, 61442);
    filter = new ModuleMethod(localSrfi1, 91, Lit57, 8194);
    filter$Ex = new ModuleMethod(localSrfi1, 92, Lit58, 8194);
    partition = new ModuleMethod(localSrfi1, 93, Lit59, 8194);
    partition$Ex = new ModuleMethod(localSrfi1, 94, Lit60, 8194);
    remove = new ModuleMethod(localSrfi1, 95, Lit61, 8194);
    remove$Ex = new ModuleMethod(localSrfi1, 96, Lit62, 8194);
    delete = new ModuleMethod(localSrfi1, 97, Lit63, 12290);
    delete$Ex = new ModuleMethod(localSrfi1, 99, Lit64, 12290);
    delete$Mnduplicates = new ModuleMethod(localSrfi1, 101, Lit65, 8193);
    delete$Mnduplicates$Ex = new ModuleMethod(localSrfi1, 103, Lit66, 8193);
    alist$Mncons = new ModuleMethod(localSrfi1, 105, Lit67, 12291);
    alist$Mncopy = new ModuleMethod(localSrfi1, 106, Lit68, 4097);
    alist$Mndelete = new ModuleMethod(localSrfi1, 107, Lit69, 12290);
    alist$Mndelete$Ex = new ModuleMethod(localSrfi1, 109, Lit70, 12290);
    find = new ModuleMethod(localSrfi1, 111, Lit71, 8194);
    find$Mntail = new ModuleMethod(localSrfi1, 112, Lit72, 8194);
    take$Mnwhile = new ModuleMethod(localSrfi1, 113, Lit73, 8194);
    drop$Mnwhile = new ModuleMethod(localSrfi1, 114, Lit74, 8194);
    take$Mnwhile$Ex = new ModuleMethod(localSrfi1, 115, Lit75, 8194);
    span = new ModuleMethod(localSrfi1, 116, Lit76, 8194);
    span$Ex = new ModuleMethod(localSrfi1, 117, Lit77, 8194);
    break = new ModuleMethod(localSrfi1, 118, Lit78, 8194);
    break$Ex = new ModuleMethod(localSrfi1, 119, Lit79, 8194);
    any = new ModuleMethod(localSrfi1, 120, Lit80, 61442);
    every = new ModuleMethod(localSrfi1, 121, Lit81, 61442);
    $Pcevery = kawa.lang.Macro.make(Lit82, Lit83, "gnu.kawa.slib.srfi1");
    list$Mnindex = new ModuleMethod(localSrfi1, 122, Lit84, 61442);
    lset$Ls$Eq = new ModuleMethod(localSrfi1, 123, Lit85, 61441);
    lset$Eq = new ModuleMethod(localSrfi1, 124, Lit86, 61441);
    lset$Mnadjoin = new ModuleMethod(localSrfi1, 125, Lit87, 61442);
    lset$Mnunion = new ModuleMethod(localSrfi1, 126, Lit88, 61441);
    lset$Mnunion$Ex = new ModuleMethod(localSrfi1, 127, Lit89, 61441);
    lset$Mnintersection = new ModuleMethod(localSrfi1, 128, Lit90, 61442);
    lset$Mnintersection$Ex = new ModuleMethod(localSrfi1, 129, Lit91, 61442);
    lset$Mndifference = new ModuleMethod(localSrfi1, 130, Lit92, 61442);
    lset$Mndifference$Ex = new ModuleMethod(localSrfi1, 131, Lit93, 61442);
    lset$Mnxor = new ModuleMethod(localSrfi1, 132, Lit94, 61441);
    lset$Mnxor$Ex = new ModuleMethod(localSrfi1, 133, Lit95, 61441);
    lset$Mndiff$Plintersection = new ModuleMethod(localSrfi1, 134, Lit96, 61442);
    lset$Mndiff$Plintersection$Ex = new ModuleMethod(localSrfi1, 135, Lit97, 61442);
    $runBody$();
  }
  
  public srfi1()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1351	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+697->701, 37:+661->665, 41:+644->648, 42:+627->631, 43:+610->614, 44:+593->597, 45:+576->580, 47:+559->563, 49:+542->546, 50:+525->529, 51:+508->512, 52:+491->495, 53:+474->478, 54:+457->461, 55:+440->444, 64:+423->427, 65:+390->394, 66:+373->377, 67:+356->360, 68:+339->343, 69:+322->326, 70:+305->309, 74:+288->292, 75:+271->275, 101:+254->258, 103:+237->241, 106:+220->224
    //   224: aload_3
    //   225: aload_2
    //   226: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   229: aload_3
    //   230: aload_1
    //   231: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   234: aload_3
    //   235: iconst_1
    //   236: putfield 1360	gnu/mapping/CallContext:pc	I
    //   239: iconst_0
    //   240: ireturn
    //   241: aload_3
    //   242: aload_2
    //   243: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   246: aload_3
    //   247: aload_1
    //   248: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   251: aload_3
    //   252: iconst_1
    //   253: putfield 1360	gnu/mapping/CallContext:pc	I
    //   256: iconst_0
    //   257: ireturn
    //   258: aload_3
    //   259: aload_2
    //   260: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   263: aload_3
    //   264: aload_1
    //   265: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   268: aload_3
    //   269: iconst_1
    //   270: putfield 1360	gnu/mapping/CallContext:pc	I
    //   273: iconst_0
    //   274: ireturn
    //   275: aload_3
    //   276: aload_2
    //   277: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   280: aload_3
    //   281: aload_1
    //   282: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   285: aload_3
    //   286: iconst_1
    //   287: putfield 1360	gnu/mapping/CallContext:pc	I
    //   290: iconst_0
    //   291: ireturn
    //   292: aload_3
    //   293: aload_2
    //   294: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   297: aload_3
    //   298: aload_1
    //   299: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   302: aload_3
    //   303: iconst_1
    //   304: putfield 1360	gnu/mapping/CallContext:pc	I
    //   307: iconst_0
    //   308: ireturn
    //   309: aload_3
    //   310: aload_2
    //   311: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   314: aload_3
    //   315: aload_1
    //   316: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   319: aload_3
    //   320: iconst_1
    //   321: putfield 1360	gnu/mapping/CallContext:pc	I
    //   324: iconst_0
    //   325: ireturn
    //   326: aload_3
    //   327: aload_2
    //   328: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   331: aload_3
    //   332: aload_1
    //   333: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   336: aload_3
    //   337: iconst_1
    //   338: putfield 1360	gnu/mapping/CallContext:pc	I
    //   341: iconst_0
    //   342: ireturn
    //   343: aload_3
    //   344: aload_2
    //   345: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   348: aload_3
    //   349: aload_1
    //   350: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   353: aload_3
    //   354: iconst_1
    //   355: putfield 1360	gnu/mapping/CallContext:pc	I
    //   358: iconst_0
    //   359: ireturn
    //   360: aload_3
    //   361: aload_2
    //   362: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   365: aload_3
    //   366: aload_1
    //   367: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   370: aload_3
    //   371: iconst_1
    //   372: putfield 1360	gnu/mapping/CallContext:pc	I
    //   375: iconst_0
    //   376: ireturn
    //   377: aload_3
    //   378: aload_2
    //   379: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   382: aload_3
    //   383: aload_1
    //   384: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   387: aload_3
    //   388: iconst_1
    //   389: putfield 1360	gnu/mapping/CallContext:pc	I
    //   392: iconst_0
    //   393: ireturn
    //   394: aload_3
    //   395: aload_2
    //   396: ldc -118
    //   398: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   401: dup
    //   402: instanceof 138
    //   405: ifne +7 -> 412
    //   408: ldc_w 1361
    //   411: ireturn
    //   412: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   415: aload_3
    //   416: aload_1
    //   417: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   420: aload_3
    //   421: iconst_1
    //   422: putfield 1360	gnu/mapping/CallContext:pc	I
    //   425: iconst_0
    //   426: ireturn
    //   427: aload_3
    //   428: aload_2
    //   429: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   432: aload_3
    //   433: aload_1
    //   434: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   437: aload_3
    //   438: iconst_1
    //   439: putfield 1360	gnu/mapping/CallContext:pc	I
    //   442: iconst_0
    //   443: ireturn
    //   444: aload_3
    //   445: aload_2
    //   446: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   449: aload_3
    //   450: aload_1
    //   451: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   454: aload_3
    //   455: iconst_1
    //   456: putfield 1360	gnu/mapping/CallContext:pc	I
    //   459: iconst_0
    //   460: ireturn
    //   461: aload_3
    //   462: aload_2
    //   463: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   466: aload_3
    //   467: aload_1
    //   468: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   471: aload_3
    //   472: iconst_1
    //   473: putfield 1360	gnu/mapping/CallContext:pc	I
    //   476: iconst_0
    //   477: ireturn
    //   478: aload_3
    //   479: aload_2
    //   480: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   483: aload_3
    //   484: aload_1
    //   485: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   488: aload_3
    //   489: iconst_1
    //   490: putfield 1360	gnu/mapping/CallContext:pc	I
    //   493: iconst_0
    //   494: ireturn
    //   495: aload_3
    //   496: aload_2
    //   497: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   500: aload_3
    //   501: aload_1
    //   502: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   505: aload_3
    //   506: iconst_1
    //   507: putfield 1360	gnu/mapping/CallContext:pc	I
    //   510: iconst_0
    //   511: ireturn
    //   512: aload_3
    //   513: aload_2
    //   514: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   517: aload_3
    //   518: aload_1
    //   519: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   522: aload_3
    //   523: iconst_1
    //   524: putfield 1360	gnu/mapping/CallContext:pc	I
    //   527: iconst_0
    //   528: ireturn
    //   529: aload_3
    //   530: aload_2
    //   531: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   534: aload_3
    //   535: aload_1
    //   536: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   539: aload_3
    //   540: iconst_1
    //   541: putfield 1360	gnu/mapping/CallContext:pc	I
    //   544: iconst_0
    //   545: ireturn
    //   546: aload_3
    //   547: aload_2
    //   548: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   551: aload_3
    //   552: aload_1
    //   553: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   556: aload_3
    //   557: iconst_1
    //   558: putfield 1360	gnu/mapping/CallContext:pc	I
    //   561: iconst_0
    //   562: ireturn
    //   563: aload_3
    //   564: aload_2
    //   565: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   568: aload_3
    //   569: aload_1
    //   570: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   573: aload_3
    //   574: iconst_1
    //   575: putfield 1360	gnu/mapping/CallContext:pc	I
    //   578: iconst_0
    //   579: ireturn
    //   580: aload_3
    //   581: aload_2
    //   582: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   585: aload_3
    //   586: aload_1
    //   587: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   590: aload_3
    //   591: iconst_1
    //   592: putfield 1360	gnu/mapping/CallContext:pc	I
    //   595: iconst_0
    //   596: ireturn
    //   597: aload_3
    //   598: aload_2
    //   599: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   602: aload_3
    //   603: aload_1
    //   604: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   607: aload_3
    //   608: iconst_1
    //   609: putfield 1360	gnu/mapping/CallContext:pc	I
    //   612: iconst_0
    //   613: ireturn
    //   614: aload_3
    //   615: aload_2
    //   616: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   619: aload_3
    //   620: aload_1
    //   621: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   624: aload_3
    //   625: iconst_1
    //   626: putfield 1360	gnu/mapping/CallContext:pc	I
    //   629: iconst_0
    //   630: ireturn
    //   631: aload_3
    //   632: aload_2
    //   633: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   636: aload_3
    //   637: aload_1
    //   638: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   641: aload_3
    //   642: iconst_1
    //   643: putfield 1360	gnu/mapping/CallContext:pc	I
    //   646: iconst_0
    //   647: ireturn
    //   648: aload_3
    //   649: aload_2
    //   650: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   653: aload_3
    //   654: aload_1
    //   655: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   658: aload_3
    //   659: iconst_1
    //   660: putfield 1360	gnu/mapping/CallContext:pc	I
    //   663: iconst_0
    //   664: ireturn
    //   665: aload_3
    //   666: aload_2
    //   667: ldc 82
    //   669: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   672: dup
    //   673: invokestatic 1365	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   676: ifnull +6 -> 682
    //   679: goto +7 -> 686
    //   682: ldc_w 1361
    //   685: ireturn
    //   686: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   689: aload_3
    //   690: aload_1
    //   691: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   694: aload_3
    //   695: iconst_1
    //   696: putfield 1360	gnu/mapping/CallContext:pc	I
    //   699: iconst_0
    //   700: ireturn
    //   701: aload_0
    //   702: aload_1
    //   703: aload_2
    //   704: aload_3
    //   705: invokespecial 1369	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   708: ireturn
    // Line number table:
    //   Java source line #1262	-> byte code offset #224
    //   Java source line #1243	-> byte code offset #241
    //   Java source line #1235	-> byte code offset #258
    //   Java source line #704	-> byte code offset #275
    //   Java source line #703	-> byte code offset #292
    //   Java source line #637	-> byte code offset #309
    //   Java source line #627	-> byte code offset #326
    //   Java source line #618	-> byte code offset #343
    //   Java source line #610	-> byte code offset #360
    //   Java source line #608	-> byte code offset #377
    //   Java source line #599	-> byte code offset #394
    //   Java source line #597	-> byte code offset #427
    //   Java source line #490	-> byte code offset #444
    //   Java source line #488	-> byte code offset #461
    //   Java source line #487	-> byte code offset #478
    //   Java source line #486	-> byte code offset #495
    //   Java source line #485	-> byte code offset #512
    //   Java source line #484	-> byte code offset #529
    //   Java source line #483	-> byte code offset #546
    //   Java source line #427	-> byte code offset #563
    //   Java source line #395	-> byte code offset #580
    //   Java source line #385	-> byte code offset #597
    //   Java source line #376	-> byte code offset #614
    //   Java source line #365	-> byte code offset #631
    //   Java source line #346	-> byte code offset #648
    //   Java source line #281	-> byte code offset #665
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1351	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+1605->1609, 34:+1579->1583, 35:+1534->1538, 37:+1470->1474, 56:+1425->1429, 57:+1380->1384, 58:+1335->1339, 59:+1290->1294, 60:+1245->1249, 61:+1200->1204, 62:+1155->1159, 63:+1110->1114, 72:+1084->1088, 73:+1058->1062, 91:+1013->1017, 92:+968->972, 93:+923->927, 94:+878->882, 95:+852->856, 96:+826->830, 97:+800->804, 99:+774->778, 101:+729->733, 103:+684->688, 107:+658->662, 109:+632->636, 111:+606->610, 112:+561->565, 113:+516->520, 114:+471->475, 115:+426->430, 116:+381->385, 117:+336->340, 118:+310->314, 119:+284->288
    //   288: aload 4
    //   290: aload_2
    //   291: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   294: aload 4
    //   296: aload_3
    //   297: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   300: aload 4
    //   302: aload_1
    //   303: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   306: aload 4
    //   308: iconst_2
    //   309: putfield 1360	gnu/mapping/CallContext:pc	I
    //   312: iconst_0
    //   313: ireturn
    //   314: aload 4
    //   316: aload_2
    //   317: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   320: aload 4
    //   322: aload_3
    //   323: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   326: aload 4
    //   328: aload_1
    //   329: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   332: aload 4
    //   334: iconst_2
    //   335: putfield 1360	gnu/mapping/CallContext:pc	I
    //   338: iconst_0
    //   339: ireturn
    //   340: aload 4
    //   342: aload_2
    //   343: ldc 68
    //   345: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   348: dup
    //   349: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   352: ifnull +6 -> 358
    //   355: goto +7 -> 362
    //   358: ldc_w 1361
    //   361: ireturn
    //   362: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   365: aload 4
    //   367: aload_3
    //   368: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   371: aload 4
    //   373: aload_1
    //   374: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   377: aload 4
    //   379: iconst_2
    //   380: putfield 1360	gnu/mapping/CallContext:pc	I
    //   383: iconst_0
    //   384: ireturn
    //   385: aload 4
    //   387: aload_2
    //   388: ldc 68
    //   390: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   393: dup
    //   394: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   397: ifnull +6 -> 403
    //   400: goto +7 -> 407
    //   403: ldc_w 1361
    //   406: ireturn
    //   407: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   410: aload 4
    //   412: aload_3
    //   413: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   416: aload 4
    //   418: aload_1
    //   419: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   422: aload 4
    //   424: iconst_2
    //   425: putfield 1360	gnu/mapping/CallContext:pc	I
    //   428: iconst_0
    //   429: ireturn
    //   430: aload 4
    //   432: aload_2
    //   433: ldc 68
    //   435: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   438: dup
    //   439: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   442: ifnull +6 -> 448
    //   445: goto +7 -> 452
    //   448: ldc_w 1361
    //   451: ireturn
    //   452: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   455: aload 4
    //   457: aload_3
    //   458: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   461: aload 4
    //   463: aload_1
    //   464: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   467: aload 4
    //   469: iconst_2
    //   470: putfield 1360	gnu/mapping/CallContext:pc	I
    //   473: iconst_0
    //   474: ireturn
    //   475: aload 4
    //   477: aload_2
    //   478: ldc 68
    //   480: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   483: dup
    //   484: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   487: ifnull +6 -> 493
    //   490: goto +7 -> 497
    //   493: ldc_w 1361
    //   496: ireturn
    //   497: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   500: aload 4
    //   502: aload_3
    //   503: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   506: aload 4
    //   508: aload_1
    //   509: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   512: aload 4
    //   514: iconst_2
    //   515: putfield 1360	gnu/mapping/CallContext:pc	I
    //   518: iconst_0
    //   519: ireturn
    //   520: aload 4
    //   522: aload_2
    //   523: ldc 68
    //   525: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   528: dup
    //   529: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   532: ifnull +6 -> 538
    //   535: goto +7 -> 542
    //   538: ldc_w 1361
    //   541: ireturn
    //   542: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   545: aload 4
    //   547: aload_3
    //   548: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   551: aload 4
    //   553: aload_1
    //   554: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   557: aload 4
    //   559: iconst_2
    //   560: putfield 1360	gnu/mapping/CallContext:pc	I
    //   563: iconst_0
    //   564: ireturn
    //   565: aload 4
    //   567: aload_2
    //   568: ldc 68
    //   570: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   573: dup
    //   574: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   577: ifnull +6 -> 583
    //   580: goto +7 -> 587
    //   583: ldc_w 1361
    //   586: ireturn
    //   587: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   590: aload 4
    //   592: aload_3
    //   593: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   596: aload 4
    //   598: aload_1
    //   599: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   602: aload 4
    //   604: iconst_2
    //   605: putfield 1360	gnu/mapping/CallContext:pc	I
    //   608: iconst_0
    //   609: ireturn
    //   610: aload 4
    //   612: aload_2
    //   613: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   616: aload 4
    //   618: aload_3
    //   619: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   622: aload 4
    //   624: aload_1
    //   625: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   628: aload 4
    //   630: iconst_2
    //   631: putfield 1360	gnu/mapping/CallContext:pc	I
    //   634: iconst_0
    //   635: ireturn
    //   636: aload 4
    //   638: aload_2
    //   639: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   642: aload 4
    //   644: aload_3
    //   645: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   648: aload 4
    //   650: aload_1
    //   651: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   654: aload 4
    //   656: iconst_2
    //   657: putfield 1360	gnu/mapping/CallContext:pc	I
    //   660: iconst_0
    //   661: ireturn
    //   662: aload 4
    //   664: aload_2
    //   665: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   668: aload 4
    //   670: aload_3
    //   671: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   674: aload 4
    //   676: aload_1
    //   677: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   680: aload 4
    //   682: iconst_2
    //   683: putfield 1360	gnu/mapping/CallContext:pc	I
    //   686: iconst_0
    //   687: ireturn
    //   688: aload 4
    //   690: aload_2
    //   691: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   694: aload 4
    //   696: aload_3
    //   697: ldc 68
    //   699: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   702: dup
    //   703: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   706: ifnull +6 -> 712
    //   709: goto +7 -> 716
    //   712: ldc_w 1376
    //   715: ireturn
    //   716: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   719: aload 4
    //   721: aload_1
    //   722: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   725: aload 4
    //   727: iconst_2
    //   728: putfield 1360	gnu/mapping/CallContext:pc	I
    //   731: iconst_0
    //   732: ireturn
    //   733: aload 4
    //   735: aload_2
    //   736: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   739: aload 4
    //   741: aload_3
    //   742: ldc 68
    //   744: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   747: dup
    //   748: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   751: ifnull +6 -> 757
    //   754: goto +7 -> 761
    //   757: ldc_w 1376
    //   760: ireturn
    //   761: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   764: aload 4
    //   766: aload_1
    //   767: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   770: aload 4
    //   772: iconst_2
    //   773: putfield 1360	gnu/mapping/CallContext:pc	I
    //   776: iconst_0
    //   777: ireturn
    //   778: aload 4
    //   780: aload_2
    //   781: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   784: aload 4
    //   786: aload_3
    //   787: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   790: aload 4
    //   792: aload_1
    //   793: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   796: aload 4
    //   798: iconst_2
    //   799: putfield 1360	gnu/mapping/CallContext:pc	I
    //   802: iconst_0
    //   803: ireturn
    //   804: aload 4
    //   806: aload_2
    //   807: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   810: aload 4
    //   812: aload_3
    //   813: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   816: aload 4
    //   818: aload_1
    //   819: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   822: aload 4
    //   824: iconst_2
    //   825: putfield 1360	gnu/mapping/CallContext:pc	I
    //   828: iconst_0
    //   829: ireturn
    //   830: aload 4
    //   832: aload_2
    //   833: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   836: aload 4
    //   838: aload_3
    //   839: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   842: aload 4
    //   844: aload_1
    //   845: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   848: aload 4
    //   850: iconst_2
    //   851: putfield 1360	gnu/mapping/CallContext:pc	I
    //   854: iconst_0
    //   855: ireturn
    //   856: aload 4
    //   858: aload_2
    //   859: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   862: aload 4
    //   864: aload_3
    //   865: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   868: aload 4
    //   870: aload_1
    //   871: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   874: aload 4
    //   876: iconst_2
    //   877: putfield 1360	gnu/mapping/CallContext:pc	I
    //   880: iconst_0
    //   881: ireturn
    //   882: aload 4
    //   884: aload_2
    //   885: ldc 68
    //   887: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   890: dup
    //   891: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   894: ifnull +6 -> 900
    //   897: goto +7 -> 904
    //   900: ldc_w 1361
    //   903: ireturn
    //   904: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   907: aload 4
    //   909: aload_3
    //   910: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   913: aload 4
    //   915: aload_1
    //   916: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   919: aload 4
    //   921: iconst_2
    //   922: putfield 1360	gnu/mapping/CallContext:pc	I
    //   925: iconst_0
    //   926: ireturn
    //   927: aload 4
    //   929: aload_2
    //   930: ldc 68
    //   932: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   935: dup
    //   936: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   939: ifnull +6 -> 945
    //   942: goto +7 -> 949
    //   945: ldc_w 1361
    //   948: ireturn
    //   949: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   952: aload 4
    //   954: aload_3
    //   955: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   958: aload 4
    //   960: aload_1
    //   961: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   964: aload 4
    //   966: iconst_2
    //   967: putfield 1360	gnu/mapping/CallContext:pc	I
    //   970: iconst_0
    //   971: ireturn
    //   972: aload 4
    //   974: aload_2
    //   975: ldc 68
    //   977: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   980: dup
    //   981: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   984: ifnull +6 -> 990
    //   987: goto +7 -> 994
    //   990: ldc_w 1361
    //   993: ireturn
    //   994: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   997: aload 4
    //   999: aload_3
    //   1000: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1003: aload 4
    //   1005: aload_1
    //   1006: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1009: aload 4
    //   1011: iconst_2
    //   1012: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1015: iconst_0
    //   1016: ireturn
    //   1017: aload 4
    //   1019: aload_2
    //   1020: ldc 68
    //   1022: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1025: dup
    //   1026: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1029: ifnull +6 -> 1035
    //   1032: goto +7 -> 1039
    //   1035: ldc_w 1361
    //   1038: ireturn
    //   1039: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1042: aload 4
    //   1044: aload_3
    //   1045: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1048: aload 4
    //   1050: aload_1
    //   1051: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1054: aload 4
    //   1056: iconst_2
    //   1057: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1060: iconst_0
    //   1061: ireturn
    //   1062: aload 4
    //   1064: aload_2
    //   1065: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1068: aload 4
    //   1070: aload_3
    //   1071: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1074: aload 4
    //   1076: aload_1
    //   1077: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1080: aload 4
    //   1082: iconst_2
    //   1083: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1086: iconst_0
    //   1087: ireturn
    //   1088: aload 4
    //   1090: aload_2
    //   1091: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1094: aload 4
    //   1096: aload_3
    //   1097: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1100: aload 4
    //   1102: aload_1
    //   1103: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1106: aload 4
    //   1108: iconst_2
    //   1109: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1112: iconst_0
    //   1113: ireturn
    //   1114: aload 4
    //   1116: aload_2
    //   1117: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1120: aload 4
    //   1122: aload_3
    //   1123: ldc 82
    //   1125: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1128: dup
    //   1129: invokestatic 1365	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1132: ifnull +6 -> 1138
    //   1135: goto +7 -> 1142
    //   1138: ldc_w 1376
    //   1141: ireturn
    //   1142: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1145: aload 4
    //   1147: aload_1
    //   1148: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1151: aload 4
    //   1153: iconst_2
    //   1154: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1157: iconst_0
    //   1158: ireturn
    //   1159: aload 4
    //   1161: aload_2
    //   1162: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1165: aload 4
    //   1167: aload_3
    //   1168: ldc 82
    //   1170: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1173: dup
    //   1174: invokestatic 1365	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1177: ifnull +6 -> 1183
    //   1180: goto +7 -> 1187
    //   1183: ldc_w 1376
    //   1186: ireturn
    //   1187: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1190: aload 4
    //   1192: aload_1
    //   1193: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1196: aload 4
    //   1198: iconst_2
    //   1199: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1202: iconst_0
    //   1203: ireturn
    //   1204: aload 4
    //   1206: aload_2
    //   1207: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1210: aload 4
    //   1212: aload_3
    //   1213: ldc 82
    //   1215: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1218: dup
    //   1219: invokestatic 1365	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1222: ifnull +6 -> 1228
    //   1225: goto +7 -> 1232
    //   1228: ldc_w 1376
    //   1231: ireturn
    //   1232: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1235: aload 4
    //   1237: aload_1
    //   1238: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1241: aload 4
    //   1243: iconst_2
    //   1244: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1247: iconst_0
    //   1248: ireturn
    //   1249: aload 4
    //   1251: aload_2
    //   1252: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1255: aload 4
    //   1257: aload_3
    //   1258: ldc 82
    //   1260: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1263: dup
    //   1264: invokestatic 1365	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1267: ifnull +6 -> 1273
    //   1270: goto +7 -> 1277
    //   1273: ldc_w 1376
    //   1276: ireturn
    //   1277: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1280: aload 4
    //   1282: aload_1
    //   1283: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1286: aload 4
    //   1288: iconst_2
    //   1289: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1292: iconst_0
    //   1293: ireturn
    //   1294: aload 4
    //   1296: aload_2
    //   1297: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1300: aload 4
    //   1302: aload_3
    //   1303: ldc 82
    //   1305: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1308: dup
    //   1309: invokestatic 1365	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1312: ifnull +6 -> 1318
    //   1315: goto +7 -> 1322
    //   1318: ldc_w 1376
    //   1321: ireturn
    //   1322: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1325: aload 4
    //   1327: aload_1
    //   1328: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1331: aload 4
    //   1333: iconst_2
    //   1334: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1337: iconst_0
    //   1338: ireturn
    //   1339: aload 4
    //   1341: aload_2
    //   1342: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1345: aload 4
    //   1347: aload_3
    //   1348: ldc 82
    //   1350: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1353: dup
    //   1354: invokestatic 1365	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1357: ifnull +6 -> 1363
    //   1360: goto +7 -> 1367
    //   1363: ldc_w 1376
    //   1366: ireturn
    //   1367: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1370: aload 4
    //   1372: aload_1
    //   1373: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1376: aload 4
    //   1378: iconst_2
    //   1379: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1382: iconst_0
    //   1383: ireturn
    //   1384: aload 4
    //   1386: aload_2
    //   1387: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1390: aload 4
    //   1392: aload_3
    //   1393: ldc 82
    //   1395: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1398: dup
    //   1399: invokestatic 1365	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1402: ifnull +6 -> 1408
    //   1405: goto +7 -> 1412
    //   1408: ldc_w 1376
    //   1411: ireturn
    //   1412: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1415: aload 4
    //   1417: aload_1
    //   1418: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1421: aload 4
    //   1423: iconst_2
    //   1424: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1427: iconst_0
    //   1428: ireturn
    //   1429: aload 4
    //   1431: aload_2
    //   1432: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1435: aload 4
    //   1437: aload_3
    //   1438: ldc 82
    //   1440: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1443: dup
    //   1444: invokestatic 1365	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1447: ifnull +6 -> 1453
    //   1450: goto +7 -> 1457
    //   1453: ldc_w 1376
    //   1456: ireturn
    //   1457: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1460: aload 4
    //   1462: aload_1
    //   1463: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1466: aload 4
    //   1468: iconst_2
    //   1469: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1472: iconst_0
    //   1473: ireturn
    //   1474: aload 4
    //   1476: aload_2
    //   1477: ldc 82
    //   1479: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1482: dup
    //   1483: invokestatic 1365	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   1486: ifnull +6 -> 1492
    //   1489: goto +7 -> 1496
    //   1492: ldc_w 1361
    //   1495: ireturn
    //   1496: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1499: aload 4
    //   1501: aload_3
    //   1502: ldc 106
    //   1504: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1507: dup
    //   1508: invokestatic 1379	gnu/math/Numeric:asNumericOrNull	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   1511: ifnull +6 -> 1517
    //   1514: goto +7 -> 1521
    //   1517: ldc_w 1376
    //   1520: ireturn
    //   1521: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1524: aload 4
    //   1526: aload_1
    //   1527: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1530: aload 4
    //   1532: iconst_2
    //   1533: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1536: iconst_0
    //   1537: ireturn
    //   1538: aload 4
    //   1540: aload_2
    //   1541: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1544: aload 4
    //   1546: aload_3
    //   1547: ldc 68
    //   1549: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1552: dup
    //   1553: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1556: ifnull +6 -> 1562
    //   1559: goto +7 -> 1566
    //   1562: ldc_w 1376
    //   1565: ireturn
    //   1566: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1569: aload 4
    //   1571: aload_1
    //   1572: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1575: aload 4
    //   1577: iconst_2
    //   1578: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1581: iconst_0
    //   1582: ireturn
    //   1583: aload 4
    //   1585: aload_2
    //   1586: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   1589: aload 4
    //   1591: aload_3
    //   1592: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   1595: aload 4
    //   1597: aload_1
    //   1598: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   1601: aload 4
    //   1603: iconst_2
    //   1604: putfield 1360	gnu/mapping/CallContext:pc	I
    //   1607: iconst_0
    //   1608: ireturn
    //   1609: aload_0
    //   1610: aload_1
    //   1611: aload_2
    //   1612: aload_3
    //   1613: aload 4
    //   1615: invokespecial 1383	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   1618: ireturn
    // Line number table:
    //   Java source line #1331	-> byte code offset #288
    //   Java source line #1330	-> byte code offset #314
    //   Java source line #1319	-> byte code offset #340
    //   Java source line #1310	-> byte code offset #385
    //   Java source line #1301	-> byte code offset #430
    //   Java source line #1294	-> byte code offset #475
    //   Java source line #1286	-> byte code offset #520
    //   Java source line #1280	-> byte code offset #565
    //   Java source line #1276	-> byte code offset #610
    //   Java source line #1269	-> byte code offset #636
    //   Java source line #1266	-> byte code offset #662
    //   Java source line #1243	-> byte code offset #688
    //   Java source line #1235	-> byte code offset #733
    //   Java source line #1211	-> byte code offset #778
    //   Java source line #1208	-> byte code offset #804
    //   Java source line #1187	-> byte code offset #830
    //   Java source line #1186	-> byte code offset #856
    //   Java source line #1116	-> byte code offset #882
    //   Java source line #1090	-> byte code offset #927
    //   Java source line #1058	-> byte code offset #972
    //   Java source line #1007	-> byte code offset #1017
    //   Java source line #695	-> byte code offset #1062
    //   Java source line #690	-> byte code offset #1088
    //   Java source line #589	-> byte code offset #1114
    //   Java source line #583	-> byte code offset #1159
    //   Java source line #527	-> byte code offset #1204
    //   Java source line #519	-> byte code offset #1249
    //   Java source line #513	-> byte code offset #1294
    //   Java source line #504	-> byte code offset #1339
    //   Java source line #500	-> byte code offset #1384
    //   Java source line #494	-> byte code offset #1429
    //   Java source line #281	-> byte code offset #1474
    //   Java source line #254	-> byte code offset #1538
    //   Java source line #226	-> byte code offset #1583
  }
  
  /* Error */
  public int match3(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1351	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+435->439, 37:+345->349, 84:+293->297, 85:+241->245, 97:+208->212, 99:+175->179, 105:+142->146, 107:+109->113, 109:+76->80
    //   80: aload 5
    //   82: aload_2
    //   83: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   86: aload 5
    //   88: aload_3
    //   89: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   92: aload 5
    //   94: aload 4
    //   96: putfield 1386	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   99: aload 5
    //   101: aload_1
    //   102: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   105: aload 5
    //   107: iconst_3
    //   108: putfield 1360	gnu/mapping/CallContext:pc	I
    //   111: iconst_0
    //   112: ireturn
    //   113: aload 5
    //   115: aload_2
    //   116: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   119: aload 5
    //   121: aload_3
    //   122: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   125: aload 5
    //   127: aload 4
    //   129: putfield 1386	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   132: aload 5
    //   134: aload_1
    //   135: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   138: aload 5
    //   140: iconst_3
    //   141: putfield 1360	gnu/mapping/CallContext:pc	I
    //   144: iconst_0
    //   145: ireturn
    //   146: aload 5
    //   148: aload_2
    //   149: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   152: aload 5
    //   154: aload_3
    //   155: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   158: aload 5
    //   160: aload 4
    //   162: putfield 1386	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   165: aload 5
    //   167: aload_1
    //   168: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   171: aload 5
    //   173: iconst_3
    //   174: putfield 1360	gnu/mapping/CallContext:pc	I
    //   177: iconst_0
    //   178: ireturn
    //   179: aload 5
    //   181: aload_2
    //   182: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   185: aload 5
    //   187: aload_3
    //   188: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   191: aload 5
    //   193: aload 4
    //   195: putfield 1386	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   198: aload 5
    //   200: aload_1
    //   201: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   204: aload 5
    //   206: iconst_3
    //   207: putfield 1360	gnu/mapping/CallContext:pc	I
    //   210: iconst_0
    //   211: ireturn
    //   212: aload 5
    //   214: aload_2
    //   215: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   218: aload 5
    //   220: aload_3
    //   221: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   224: aload 5
    //   226: aload 4
    //   228: putfield 1386	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   231: aload 5
    //   233: aload_1
    //   234: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   237: aload 5
    //   239: iconst_3
    //   240: putfield 1360	gnu/mapping/CallContext:pc	I
    //   243: iconst_0
    //   244: ireturn
    //   245: aload 5
    //   247: aload_2
    //   248: ldc 68
    //   250: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   253: dup
    //   254: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   257: ifnull +6 -> 263
    //   260: goto +7 -> 267
    //   263: ldc_w 1361
    //   266: ireturn
    //   267: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   270: aload 5
    //   272: aload_3
    //   273: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   276: aload 5
    //   278: aload 4
    //   280: putfield 1386	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   283: aload 5
    //   285: aload_1
    //   286: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   289: aload 5
    //   291: iconst_3
    //   292: putfield 1360	gnu/mapping/CallContext:pc	I
    //   295: iconst_0
    //   296: ireturn
    //   297: aload 5
    //   299: aload_2
    //   300: ldc 68
    //   302: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   305: dup
    //   306: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   309: ifnull +6 -> 315
    //   312: goto +7 -> 319
    //   315: ldc_w 1361
    //   318: ireturn
    //   319: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   322: aload 5
    //   324: aload_3
    //   325: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   328: aload 5
    //   330: aload 4
    //   332: putfield 1386	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   335: aload 5
    //   337: aload_1
    //   338: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   341: aload 5
    //   343: iconst_3
    //   344: putfield 1360	gnu/mapping/CallContext:pc	I
    //   347: iconst_0
    //   348: ireturn
    //   349: aload 5
    //   351: aload_2
    //   352: ldc 82
    //   354: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   357: dup
    //   358: invokestatic 1365	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   361: ifnull +6 -> 367
    //   364: goto +7 -> 371
    //   367: ldc_w 1361
    //   370: ireturn
    //   371: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   374: aload 5
    //   376: aload_3
    //   377: ldc 106
    //   379: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   382: dup
    //   383: invokestatic 1379	gnu/math/Numeric:asNumericOrNull	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   386: ifnull +6 -> 392
    //   389: goto +7 -> 396
    //   392: ldc_w 1376
    //   395: ireturn
    //   396: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   399: aload 5
    //   401: aload 4
    //   403: ldc 106
    //   405: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   408: dup
    //   409: invokestatic 1379	gnu/math/Numeric:asNumericOrNull	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   412: ifnull +6 -> 418
    //   415: goto +7 -> 422
    //   418: ldc_w 1387
    //   421: ireturn
    //   422: putfield 1386	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   425: aload 5
    //   427: aload_1
    //   428: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   431: aload 5
    //   433: iconst_3
    //   434: putfield 1360	gnu/mapping/CallContext:pc	I
    //   437: iconst_0
    //   438: ireturn
    //   439: aload_0
    //   440: aload_1
    //   441: aload_2
    //   442: aload_3
    //   443: aload 4
    //   445: aload 5
    //   447: invokespecial 1391	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   450: ireturn
    // Line number table:
    //   Java source line #1269	-> byte code offset #80
    //   Java source line #1266	-> byte code offset #113
    //   Java source line #1260	-> byte code offset #146
    //   Java source line #1211	-> byte code offset #179
    //   Java source line #1208	-> byte code offset #212
    //   Java source line #898	-> byte code offset #245
    //   Java source line #894	-> byte code offset #297
    //   Java source line #281	-> byte code offset #349
  }
  
  /* Error */
  public int match4(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1351	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 77
    //   6: if_icmpne +103 -> 109
    //   9: goto +3 -> 12
    //   12: aload 6
    //   14: aload_2
    //   15: ldc 68
    //   17: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   20: dup
    //   21: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   24: ifnull +6 -> 30
    //   27: goto +7 -> 34
    //   30: ldc_w 1361
    //   33: ireturn
    //   34: putfield 1354	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   37: aload 6
    //   39: aload_3
    //   40: ldc 68
    //   42: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   45: dup
    //   46: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   49: ifnull +6 -> 55
    //   52: goto +7 -> 59
    //   55: ldc_w 1376
    //   58: ireturn
    //   59: putfield 1372	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   62: aload 6
    //   64: aload 4
    //   66: ldc 68
    //   68: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   71: dup
    //   72: invokestatic 1375	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   75: ifnull +6 -> 81
    //   78: goto +7 -> 85
    //   81: ldc_w 1387
    //   84: ireturn
    //   85: putfield 1386	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   88: aload 6
    //   90: aload 5
    //   92: putfield 1394	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   95: aload 6
    //   97: aload_1
    //   98: putfield 1357	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   101: aload 6
    //   103: iconst_4
    //   104: putfield 1360	gnu/mapping/CallContext:pc	I
    //   107: iconst_0
    //   108: ireturn
    //   109: aload_0
    //   110: aload_1
    //   111: aload_2
    //   112: aload_3
    //   113: aload 4
    //   115: aload 5
    //   117: aload 6
    //   119: invokespecial 1398	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   122: ireturn
    // Line number table:
    //   Java source line #819	-> byte code offset #12
  }
  
  public void apply(CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1351	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+672->676, 34:+284->288, 35:+290->294, 37:+304->308, 56:+326->330, 57:+340->344, 58:+354->358, 59:+368->372, 60:+382->386, 61:+396->400, 62:+410->414, 63:+424->428, 72:+438->442, 73:+444->448, 91:+450->454, 92:+464->468, 93:+478->482, 94:+492->496, 95:+506->510, 96:+512->516, 97:+518->522, 99:+524->528, 101:+530->534, 103:+544->548, 107:+558->562, 109:+564->568, 111:+570->574, 112:+576->580, 113:+590->594, 114:+604->608, 115:+618->622, 116:+632->636, 117:+646->650, 118:+660->664, 119:+666->670
    //   288: aload_2
    //   289: aload_3
    //   290: invokestatic 1468	gnu/kawa/slib/srfi1:xcons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   293: areturn
    //   294: aload_2
    //   295: aload_3
    //   296: ldc 68
    //   298: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   301: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   304: invokestatic 1473	gnu/kawa/slib/srfi1:listTabulate	(Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   307: areturn
    //   308: aload_2
    //   309: ldc 82
    //   311: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   314: invokestatic 1412	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   317: aload_3
    //   318: ldc 106
    //   320: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   323: invokestatic 118	gnu/kawa/lispexpr/LangObjType:coerceNumeric	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   326: invokestatic 1476	gnu/kawa/slib/srfi1:iota	(Lgnu/math/IntNum;Lgnu/math/Numeric;)Ljava/lang/Object;
    //   329: areturn
    //   330: aload_2
    //   331: aload_3
    //   332: ldc 82
    //   334: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   337: invokestatic 1412	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   340: invokestatic 1479	gnu/kawa/slib/srfi1:take	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   343: areturn
    //   344: aload_2
    //   345: aload_3
    //   346: ldc 82
    //   348: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   351: invokestatic 1412	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   354: invokestatic 256	gnu/kawa/slib/srfi1:drop	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   357: areturn
    //   358: aload_2
    //   359: aload_3
    //   360: ldc 82
    //   362: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   365: invokestatic 1412	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   368: invokestatic 1484	gnu/kawa/slib/srfi1:take$Ex	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   371: areturn
    //   372: aload_2
    //   373: aload_3
    //   374: ldc 82
    //   376: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   379: invokestatic 1412	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   382: invokestatic 1489	gnu/kawa/slib/srfi1:takeRight	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   385: areturn
    //   386: aload_2
    //   387: aload_3
    //   388: ldc 82
    //   390: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   393: invokestatic 1412	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   396: invokestatic 1494	gnu/kawa/slib/srfi1:dropRight	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   399: areturn
    //   400: aload_2
    //   401: aload_3
    //   402: ldc 82
    //   404: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   407: invokestatic 1412	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   410: invokestatic 1499	gnu/kawa/slib/srfi1:dropRight$Ex	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   413: areturn
    //   414: aload_2
    //   415: aload_3
    //   416: ldc 82
    //   418: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   421: invokestatic 1412	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   424: invokestatic 1504	gnu/kawa/slib/srfi1:splitAt	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   427: areturn
    //   428: aload_2
    //   429: aload_3
    //   430: ldc 82
    //   432: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   435: invokestatic 1412	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   438: invokestatic 1509	gnu/kawa/slib/srfi1:splitAt$Ex	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   441: areturn
    //   442: aload_2
    //   443: aload_3
    //   444: invokestatic 1512	gnu/kawa/slib/srfi1:appendReverse	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   447: areturn
    //   448: aload_2
    //   449: aload_3
    //   450: invokestatic 345	gnu/kawa/slib/srfi1:appendReverse$Ex	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   453: areturn
    //   454: aload_2
    //   455: ldc 68
    //   457: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   460: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   463: aload_3
    //   464: invokestatic 451	gnu/kawa/slib/srfi1:filter	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   467: areturn
    //   468: aload_2
    //   469: ldc 68
    //   471: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   474: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   477: aload_3
    //   478: invokestatic 461	gnu/kawa/slib/srfi1:filter$Ex	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   481: areturn
    //   482: aload_2
    //   483: ldc 68
    //   485: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   488: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   491: aload_3
    //   492: invokestatic 683	gnu/kawa/slib/srfi1:partition	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   495: areturn
    //   496: aload_2
    //   497: ldc 68
    //   499: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   502: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   505: aload_3
    //   506: invokestatic 694	gnu/kawa/slib/srfi1:partition$Ex	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   509: areturn
    //   510: aload_2
    //   511: aload_3
    //   512: invokestatic 1520	gnu/kawa/slib/srfi1:remove	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   515: areturn
    //   516: aload_2
    //   517: aload_3
    //   518: invokestatic 1522	gnu/kawa/slib/srfi1:remove$Ex	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   521: areturn
    //   522: aload_2
    //   523: aload_3
    //   524: invokestatic 1524	gnu/kawa/slib/srfi1:delete	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   527: areturn
    //   528: aload_2
    //   529: aload_3
    //   530: invokestatic 1526	gnu/kawa/slib/srfi1:delete$Ex	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   533: areturn
    //   534: aload_2
    //   535: aload_3
    //   536: ldc 68
    //   538: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   541: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   544: invokestatic 495	gnu/kawa/slib/srfi1:deleteDuplicates	(Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   547: areturn
    //   548: aload_2
    //   549: aload_3
    //   550: ldc 68
    //   552: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   555: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   558: invokestatic 506	gnu/kawa/slib/srfi1:deleteDuplicates$Ex	(Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   561: areturn
    //   562: aload_2
    //   563: aload_3
    //   564: invokestatic 1532	gnu/kawa/slib/srfi1:alistDelete	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   567: areturn
    //   568: aload_2
    //   569: aload_3
    //   570: invokestatic 1534	gnu/kawa/slib/srfi1:alistDelete$Ex	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   573: areturn
    //   574: aload_2
    //   575: aload_3
    //   576: invokestatic 1536	gnu/kawa/slib/srfi1:find	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: areturn
    //   580: aload_2
    //   581: ldc 68
    //   583: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   586: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   589: aload_3
    //   590: invokestatic 546	gnu/kawa/slib/srfi1:findTail	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   593: areturn
    //   594: aload_2
    //   595: ldc 68
    //   597: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   600: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   603: aload_3
    //   604: invokestatic 1541	gnu/kawa/slib/srfi1:takeWhile	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   607: areturn
    //   608: aload_2
    //   609: ldc 68
    //   611: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   614: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   617: aload_3
    //   618: invokestatic 1546	gnu/kawa/slib/srfi1:dropWhile	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   621: areturn
    //   622: aload_2
    //   623: ldc 68
    //   625: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   628: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   631: aload_3
    //   632: invokestatic 1551	gnu/kawa/slib/srfi1:takeWhile$Ex	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   635: areturn
    //   636: aload_2
    //   637: ldc 68
    //   639: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   642: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   645: aload_3
    //   646: invokestatic 564	gnu/kawa/slib/srfi1:span	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   649: areturn
    //   650: aload_2
    //   651: ldc 68
    //   653: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   656: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   659: aload_3
    //   660: invokestatic 574	gnu/kawa/slib/srfi1:span$Ex	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   663: areturn
    //   664: aload_2
    //   665: aload_3
    //   666: invokestatic 1556	gnu/kawa/slib/srfi1:break	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   669: areturn
    //   670: aload_2
    //   671: aload_3
    //   672: invokestatic 1558	gnu/kawa/slib/srfi1:break$Ex	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   675: areturn
    //   676: aload_0
    //   677: aload_1
    //   678: aload_2
    //   679: aload_3
    //   680: invokespecial 1561	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   683: areturn
    //   684: new 122	gnu/mapping/WrongType
    //   687: dup_x1
    //   688: swap
    //   689: ldc_w 1470
    //   692: iconst_2
    //   693: aload_3
    //   694: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   697: athrow
    //   698: new 122	gnu/mapping/WrongType
    //   701: dup_x1
    //   702: swap
    //   703: ldc_w 1413
    //   706: iconst_1
    //   707: aload_2
    //   708: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   711: athrow
    //   712: new 122	gnu/mapping/WrongType
    //   715: dup_x1
    //   716: swap
    //   717: ldc_w 1413
    //   720: iconst_2
    //   721: aload_3
    //   722: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   725: athrow
    //   726: new 122	gnu/mapping/WrongType
    //   729: dup_x1
    //   730: swap
    //   731: ldc_w 1477
    //   734: iconst_2
    //   735: aload_3
    //   736: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   739: athrow
    //   740: new 122	gnu/mapping/WrongType
    //   743: dup_x1
    //   744: swap
    //   745: ldc_w 1480
    //   748: iconst_2
    //   749: aload_3
    //   750: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   753: athrow
    //   754: new 122	gnu/mapping/WrongType
    //   757: dup_x1
    //   758: swap
    //   759: ldc_w 1482
    //   762: iconst_2
    //   763: aload_3
    //   764: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   767: athrow
    //   768: new 122	gnu/mapping/WrongType
    //   771: dup_x1
    //   772: swap
    //   773: ldc_w 1486
    //   776: iconst_2
    //   777: aload_3
    //   778: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   781: athrow
    //   782: new 122	gnu/mapping/WrongType
    //   785: dup_x1
    //   786: swap
    //   787: ldc_w 1491
    //   790: iconst_2
    //   791: aload_3
    //   792: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   795: athrow
    //   796: new 122	gnu/mapping/WrongType
    //   799: dup_x1
    //   800: swap
    //   801: ldc_w 1496
    //   804: iconst_2
    //   805: aload_3
    //   806: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   809: athrow
    //   810: new 122	gnu/mapping/WrongType
    //   813: dup_x1
    //   814: swap
    //   815: ldc_w 1501
    //   818: iconst_2
    //   819: aload_3
    //   820: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   823: athrow
    //   824: new 122	gnu/mapping/WrongType
    //   827: dup_x1
    //   828: swap
    //   829: ldc_w 1506
    //   832: iconst_2
    //   833: aload_3
    //   834: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   837: athrow
    //   838: new 122	gnu/mapping/WrongType
    //   841: dup_x1
    //   842: swap
    //   843: ldc_w 1513
    //   846: iconst_1
    //   847: aload_2
    //   848: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   851: athrow
    //   852: new 122	gnu/mapping/WrongType
    //   855: dup_x1
    //   856: swap
    //   857: ldc_w 1515
    //   860: iconst_1
    //   861: aload_2
    //   862: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   865: athrow
    //   866: new 122	gnu/mapping/WrongType
    //   869: dup_x1
    //   870: swap
    //   871: ldc_w 1516
    //   874: iconst_1
    //   875: aload_2
    //   876: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   879: athrow
    //   880: new 122	gnu/mapping/WrongType
    //   883: dup_x1
    //   884: swap
    //   885: ldc_w 1518
    //   888: iconst_1
    //   889: aload_2
    //   890: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   893: athrow
    //   894: new 122	gnu/mapping/WrongType
    //   897: dup_x1
    //   898: swap
    //   899: ldc_w 1528
    //   902: iconst_2
    //   903: aload_3
    //   904: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   907: athrow
    //   908: new 122	gnu/mapping/WrongType
    //   911: dup_x1
    //   912: swap
    //   913: ldc_w 1530
    //   916: iconst_2
    //   917: aload_3
    //   918: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   921: athrow
    //   922: new 122	gnu/mapping/WrongType
    //   925: dup_x1
    //   926: swap
    //   927: ldc_w 543
    //   930: iconst_1
    //   931: aload_2
    //   932: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   935: athrow
    //   936: new 122	gnu/mapping/WrongType
    //   939: dup_x1
    //   940: swap
    //   941: ldc_w 1538
    //   944: iconst_1
    //   945: aload_2
    //   946: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   949: athrow
    //   950: new 122	gnu/mapping/WrongType
    //   953: dup_x1
    //   954: swap
    //   955: ldc_w 1543
    //   958: iconst_1
    //   959: aload_2
    //   960: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   963: athrow
    //   964: new 122	gnu/mapping/WrongType
    //   967: dup_x1
    //   968: swap
    //   969: ldc_w 1548
    //   972: iconst_1
    //   973: aload_2
    //   974: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   977: athrow
    //   978: new 122	gnu/mapping/WrongType
    //   981: dup_x1
    //   982: swap
    //   983: ldc_w 1552
    //   986: iconst_1
    //   987: aload_2
    //   988: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   991: athrow
    //   992: new 122	gnu/mapping/WrongType
    //   995: dup_x1
    //   996: swap
    //   997: ldc_w 1554
    //   1000: iconst_1
    //   1001: aload_2
    //   1002: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1005: athrow
    // Line number table:
    //   Java source line #226	-> byte code offset #288
    //   Java source line #254	-> byte code offset #294
    //   Java source line #281	-> byte code offset #308
    //   Java source line #494	-> byte code offset #330
    //   Java source line #500	-> byte code offset #344
    //   Java source line #504	-> byte code offset #358
    //   Java source line #513	-> byte code offset #372
    //   Java source line #519	-> byte code offset #386
    //   Java source line #527	-> byte code offset #400
    //   Java source line #583	-> byte code offset #414
    //   Java source line #589	-> byte code offset #428
    //   Java source line #690	-> byte code offset #442
    //   Java source line #695	-> byte code offset #448
    //   Java source line #1007	-> byte code offset #454
    //   Java source line #1058	-> byte code offset #468
    //   Java source line #1090	-> byte code offset #482
    //   Java source line #1116	-> byte code offset #496
    //   Java source line #1186	-> byte code offset #510
    //   Java source line #1187	-> byte code offset #516
    //   Java source line #1208	-> byte code offset #522
    //   Java source line #1211	-> byte code offset #528
    //   Java source line #1235	-> byte code offset #534
    //   Java source line #1243	-> byte code offset #548
    //   Java source line #1266	-> byte code offset #562
    //   Java source line #1269	-> byte code offset #568
    //   Java source line #1276	-> byte code offset #574
    //   Java source line #1280	-> byte code offset #580
    //   Java source line #1286	-> byte code offset #594
    //   Java source line #1294	-> byte code offset #608
    //   Java source line #1301	-> byte code offset #622
    //   Java source line #1310	-> byte code offset #636
    //   Java source line #1319	-> byte code offset #650
    //   Java source line #1330	-> byte code offset #664
    //   Java source line #1331	-> byte code offset #670
    //   Java source line #254	-> byte code offset #684
    //   Java source line #281	-> byte code offset #698
    //   Java source line #494	-> byte code offset #726
    //   Java source line #500	-> byte code offset #740
    //   Java source line #504	-> byte code offset #754
    //   Java source line #513	-> byte code offset #768
    //   Java source line #519	-> byte code offset #782
    //   Java source line #527	-> byte code offset #796
    //   Java source line #583	-> byte code offset #810
    //   Java source line #589	-> byte code offset #824
    //   Java source line #1007	-> byte code offset #838
    //   Java source line #1058	-> byte code offset #852
    //   Java source line #1090	-> byte code offset #866
    //   Java source line #1116	-> byte code offset #880
    //   Java source line #1235	-> byte code offset #894
    //   Java source line #1243	-> byte code offset #908
    //   Java source line #1280	-> byte code offset #922
    //   Java source line #1286	-> byte code offset #936
    //   Java source line #1294	-> byte code offset #950
    //   Java source line #1301	-> byte code offset #964
    //   Java source line #1310	-> byte code offset #978
    //   Java source line #1319	-> byte code offset #992
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1006	0	this	srfi1
    //   0	1006	1	paramModuleMethod	ModuleMethod
    //   0	1006	2	paramObject1	Object
    //   0	1006	3	paramObject2	Object
    //   684	1	4	localClassCastException1	ClassCastException
    //   698	1	5	localClassCastException2	ClassCastException
    //   712	1	6	localClassCastException3	ClassCastException
    //   726	1	7	localClassCastException4	ClassCastException
    //   740	1	8	localClassCastException5	ClassCastException
    //   754	1	9	localClassCastException6	ClassCastException
    //   768	1	10	localClassCastException7	ClassCastException
    //   782	1	11	localClassCastException8	ClassCastException
    //   796	1	12	localClassCastException9	ClassCastException
    //   810	1	13	localClassCastException10	ClassCastException
    //   824	1	14	localClassCastException11	ClassCastException
    //   838	1	15	localClassCastException12	ClassCastException
    //   852	1	16	localClassCastException13	ClassCastException
    //   866	1	17	localClassCastException14	ClassCastException
    //   880	1	18	localClassCastException15	ClassCastException
    //   894	1	19	localClassCastException16	ClassCastException
    //   908	1	20	localClassCastException17	ClassCastException
    //   922	1	21	localClassCastException18	ClassCastException
    //   936	1	22	localClassCastException19	ClassCastException
    //   950	1	23	localClassCastException20	ClassCastException
    //   964	1	24	localClassCastException21	ClassCastException
    //   978	1	25	localClassCastException22	ClassCastException
    //   992	1	26	localClassCastException23	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   301	304	684	java/lang/ClassCastException
    //   314	317	698	java/lang/ClassCastException
    //   323	326	712	java/lang/ClassCastException
    //   337	340	726	java/lang/ClassCastException
    //   351	354	740	java/lang/ClassCastException
    //   365	368	754	java/lang/ClassCastException
    //   379	382	768	java/lang/ClassCastException
    //   393	396	782	java/lang/ClassCastException
    //   407	410	796	java/lang/ClassCastException
    //   421	424	810	java/lang/ClassCastException
    //   435	438	824	java/lang/ClassCastException
    //   460	463	838	java/lang/ClassCastException
    //   474	477	852	java/lang/ClassCastException
    //   488	491	866	java/lang/ClassCastException
    //   502	505	880	java/lang/ClassCastException
    //   541	544	894	java/lang/ClassCastException
    //   555	558	908	java/lang/ClassCastException
    //   586	589	922	java/lang/ClassCastException
    //   600	603	936	java/lang/ClassCastException
    //   614	617	950	java/lang/ClassCastException
    //   628	631	964	java/lang/ClassCastException
    //   642	645	978	java/lang/ClassCastException
    //   656	659	992	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1351	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+180->184, 37:+76->80, 84:+108->112, 85:+124->128, 97:+140->144, 99:+148->152, 105:+156->160, 107:+164->168, 109:+172->176
    //   80: aload_2
    //   81: ldc 82
    //   83: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   86: invokestatic 1412	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   89: aload_3
    //   90: ldc 106
    //   92: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   95: invokestatic 118	gnu/kawa/lispexpr/LangObjType:coerceNumeric	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   98: aload 4
    //   100: ldc 106
    //   102: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   105: invokestatic 118	gnu/kawa/lispexpr/LangObjType:coerceNumeric	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   108: invokestatic 80	gnu/kawa/slib/srfi1:iota	(Lgnu/math/IntNum;Lgnu/math/Numeric;Lgnu/math/Numeric;)Ljava/lang/Object;
    //   111: areturn
    //   112: aload_2
    //   113: ldc 68
    //   115: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   118: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   121: aload_3
    //   122: aload 4
    //   124: invokestatic 596	gnu/kawa/slib/srfi1:reduce	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: areturn
    //   128: aload_2
    //   129: ldc 68
    //   131: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   134: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   137: aload_3
    //   138: aload 4
    //   140: invokestatic 321	gnu/kawa/slib/srfi1:reduceRight	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: areturn
    //   144: aload_2
    //   145: aload_3
    //   146: aload 4
    //   148: invokestatic 468	gnu/kawa/slib/srfi1:delete	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: areturn
    //   152: aload_2
    //   153: aload_3
    //   154: aload 4
    //   156: invokestatic 483	gnu/kawa/slib/srfi1:delete$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   159: areturn
    //   160: aload_2
    //   161: aload_3
    //   162: aload 4
    //   164: invokestatic 1568	gnu/kawa/slib/srfi1:alistCons	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   167: areturn
    //   168: aload_2
    //   169: aload_3
    //   170: aload 4
    //   172: invokestatic 516	gnu/kawa/slib/srfi1:alistDelete	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: areturn
    //   176: aload_2
    //   177: aload_3
    //   178: aload 4
    //   180: invokestatic 529	gnu/kawa/slib/srfi1:alistDelete$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: areturn
    //   184: aload_0
    //   185: aload_1
    //   186: aload_2
    //   187: aload_3
    //   188: aload 4
    //   190: invokespecial 1571	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   193: areturn
    //   194: new 122	gnu/mapping/WrongType
    //   197: dup_x1
    //   198: swap
    //   199: ldc_w 1413
    //   202: iconst_1
    //   203: aload_2
    //   204: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   207: athrow
    //   208: new 122	gnu/mapping/WrongType
    //   211: dup_x1
    //   212: swap
    //   213: ldc_w 1413
    //   216: iconst_2
    //   217: aload_3
    //   218: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   221: athrow
    //   222: new 122	gnu/mapping/WrongType
    //   225: dup_x1
    //   226: swap
    //   227: ldc_w 1413
    //   230: iconst_3
    //   231: aload 4
    //   233: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   236: athrow
    //   237: new 122	gnu/mapping/WrongType
    //   240: dup_x1
    //   241: swap
    //   242: ldc_w 1562
    //   245: iconst_1
    //   246: aload_2
    //   247: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   250: athrow
    //   251: new 122	gnu/mapping/WrongType
    //   254: dup_x1
    //   255: swap
    //   256: ldc_w 1564
    //   259: iconst_1
    //   260: aload_2
    //   261: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   264: athrow
    // Line number table:
    //   Java source line #281	-> byte code offset #80
    //   Java source line #894	-> byte code offset #112
    //   Java source line #898	-> byte code offset #128
    //   Java source line #1208	-> byte code offset #144
    //   Java source line #1211	-> byte code offset #152
    //   Java source line #1260	-> byte code offset #160
    //   Java source line #1266	-> byte code offset #168
    //   Java source line #1269	-> byte code offset #176
    //   Java source line #281	-> byte code offset #194
    //   Java source line #894	-> byte code offset #237
    //   Java source line #898	-> byte code offset #251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	srfi1
    //   0	265	1	paramModuleMethod	ModuleMethod
    //   0	265	2	paramObject1	Object
    //   0	265	3	paramObject2	Object
    //   0	265	4	paramObject3	Object
    //   194	1	5	localClassCastException1	ClassCastException
    //   208	1	6	localClassCastException2	ClassCastException
    //   222	1	7	localClassCastException3	ClassCastException
    //   237	1	8	localClassCastException4	ClassCastException
    //   251	1	9	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   86	89	194	java/lang/ClassCastException
    //   95	98	208	java/lang/ClassCastException
    //   105	108	222	java/lang/ClassCastException
    //   118	121	237	java/lang/ClassCastException
    //   134	137	251	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1351	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 77
    //   6: if_icmpne +40 -> 46
    //   9: goto +3 -> 12
    //   12: aload_2
    //   13: ldc 68
    //   15: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   21: aload_3
    //   22: ldc 68
    //   24: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   27: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   30: aload 4
    //   32: ldc 68
    //   34: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   37: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   40: aload 5
    //   42: invokestatic 1576	gnu/kawa/slib/srfi1:unfoldRight	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   45: areturn
    //   46: aload_0
    //   47: aload_1
    //   48: aload_2
    //   49: aload_3
    //   50: aload 4
    //   52: aload 5
    //   54: invokespecial 1579	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   57: areturn
    //   58: new 122	gnu/mapping/WrongType
    //   61: dup_x1
    //   62: swap
    //   63: ldc_w 1573
    //   66: iconst_1
    //   67: aload_2
    //   68: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   71: athrow
    //   72: new 122	gnu/mapping/WrongType
    //   75: dup_x1
    //   76: swap
    //   77: ldc_w 1573
    //   80: iconst_2
    //   81: aload_3
    //   82: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   85: athrow
    //   86: new 122	gnu/mapping/WrongType
    //   89: dup_x1
    //   90: swap
    //   91: ldc_w 1573
    //   94: iconst_3
    //   95: aload 4
    //   97: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   100: athrow
    // Line number table:
    //   Java source line #819	-> byte code offset #12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	srfi1
    //   0	101	1	paramModuleMethod	ModuleMethod
    //   0	101	2	paramObject1	Object
    //   0	101	3	paramObject2	Object
    //   0	101	4	paramObject3	Object
    //   0	101	5	paramObject4	Object
    //   58	1	6	localClassCastException1	ClassCastException
    //   72	1	7	localClassCastException2	ClassCastException
    //   86	1	8	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   18	21	58	java/lang/ClassCastException
    //   27	30	72	java/lang/ClassCastException
    //   37	40	86	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1351	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+1883->1887, 36:+276->280, 40:+281->285, 46:+315->319, 48:+349->353, 71:+383->387, 76:+388->392, 77:+435->439, 79:+505->509, 80:+586->590, 81:+642->646, 82:+698->702, 83:+754->758, 86:+810->814, 87:+852->856, 88:+894->898, 89:+947->951, 90:+1000->1004, 120:+1053->1057, 121:+1106->1110, 122:+1159->1163, 123:+1212->1216, 124:+1262->1266, 125:+1312->1316, 126:+1365->1369, 127:+1415->1419, 128:+1465->1469, 129:+1518->1522, 130:+1571->1575, 131:+1624->1628, 132:+1677->1681, 133:+1727->1731, 134:+1777->1781, 135:+1830->1834
    //   280: aload_2
    //   281: invokestatic 1581	gnu/kawa/slib/srfi1:cons$St	([Ljava/lang/Object;)Ljava/lang/Object;
    //   284: areturn
    //   285: aload_2
    //   286: iconst_0
    //   287: aaload
    //   288: aload_2
    //   289: arraylength
    //   290: iconst_1
    //   291: isub
    //   292: istore_3
    //   293: iload_3
    //   294: anewarray 37	java/lang/Object
    //   297: goto +11 -> 308
    //   300: dup
    //   301: iload_3
    //   302: aload_2
    //   303: iload_3
    //   304: iconst_1
    //   305: iadd
    //   306: aaload
    //   307: aastore
    //   308: iinc 3 -1
    //   311: iload_3
    //   312: ifge -12 -> 300
    //   315: invokestatic 1585	gnu/kawa/slib/srfi1:circularList$V	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/Pair;
    //   318: areturn
    //   319: aload_2
    //   320: iconst_0
    //   321: aaload
    //   322: aload_2
    //   323: arraylength
    //   324: iconst_1
    //   325: isub
    //   326: istore_3
    //   327: iload_3
    //   328: anewarray 37	java/lang/Object
    //   331: goto +11 -> 342
    //   334: dup
    //   335: iload_3
    //   336: aload_2
    //   337: iload_3
    //   338: iconst_1
    //   339: iadd
    //   340: aaload
    //   341: aastore
    //   342: iinc 3 -1
    //   345: iload_3
    //   346: ifge -12 -> 334
    //   349: invokestatic 1589	gnu/kawa/slib/srfi1:list$Eq$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   352: areturn
    //   353: aload_2
    //   354: iconst_0
    //   355: aaload
    //   356: aload_2
    //   357: arraylength
    //   358: iconst_1
    //   359: isub
    //   360: istore_3
    //   361: iload_3
    //   362: anewarray 37	java/lang/Object
    //   365: goto +11 -> 376
    //   368: dup
    //   369: iload_3
    //   370: aload_2
    //   371: iload_3
    //   372: iconst_1
    //   373: iadd
    //   374: aaload
    //   375: aastore
    //   376: iinc 3 -1
    //   379: iload_3
    //   380: ifge -12 -> 368
    //   383: invokestatic 1592	gnu/kawa/slib/srfi1:zip$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   386: areturn
    //   387: aload_2
    //   388: invokestatic 391	gnu/kawa/slib/srfi1:append$Ex$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   391: areturn
    //   392: aload_2
    //   393: iconst_0
    //   394: aaload
    //   395: ldc 68
    //   397: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   400: dup
    //   401: astore_3
    //   402: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   405: aload_2
    //   406: iconst_1
    //   407: aaload
    //   408: aload_2
    //   409: arraylength
    //   410: iconst_2
    //   411: isub
    //   412: istore_3
    //   413: iload_3
    //   414: anewarray 37	java/lang/Object
    //   417: goto +11 -> 428
    //   420: dup
    //   421: iload_3
    //   422: aload_2
    //   423: iload_3
    //   424: iconst_2
    //   425: iadd
    //   426: aaload
    //   427: aastore
    //   428: iinc 3 -1
    //   431: iload_3
    //   432: ifge -12 -> 420
    //   435: invokestatic 1596	gnu/kawa/slib/srfi1:count$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   438: areturn
    //   439: aload_2
    //   440: arraylength
    //   441: iconst_4
    //   442: isub
    //   443: istore_3
    //   444: aload_2
    //   445: iconst_0
    //   446: aaload
    //   447: ldc 68
    //   449: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   452: dup
    //   453: astore 4
    //   455: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   458: aload_2
    //   459: iconst_1
    //   460: aaload
    //   461: ldc 68
    //   463: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   466: dup
    //   467: astore 4
    //   469: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   472: aload_2
    //   473: iconst_2
    //   474: aaload
    //   475: ldc 68
    //   477: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   480: dup
    //   481: astore 4
    //   483: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   486: aload_2
    //   487: iconst_3
    //   488: aaload
    //   489: iload_3
    //   490: ifgt +9 -> 499
    //   493: invokestatic 1576	gnu/kawa/slib/srfi1:unfoldRight	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   496: goto +12 -> 508
    //   499: iinc 3 -1
    //   502: aload_2
    //   503: iconst_4
    //   504: aaload
    //   505: invokestatic 332	gnu/kawa/slib/srfi1:unfoldRight	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   508: areturn
    //   509: aload_2
    //   510: iconst_0
    //   511: aaload
    //   512: ldc 68
    //   514: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   517: dup
    //   518: astore 4
    //   520: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   523: aload_2
    //   524: iconst_1
    //   525: aaload
    //   526: ldc 68
    //   528: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   531: dup
    //   532: astore 4
    //   534: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   537: aload_2
    //   538: iconst_2
    //   539: aaload
    //   540: ldc 68
    //   542: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   545: dup
    //   546: astore 4
    //   548: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   551: aload_2
    //   552: iconst_3
    //   553: aaload
    //   554: aload_2
    //   555: arraylength
    //   556: iconst_4
    //   557: isub
    //   558: istore 4
    //   560: iload 4
    //   562: anewarray 37	java/lang/Object
    //   565: goto +13 -> 578
    //   568: dup
    //   569: iload 4
    //   571: aload_2
    //   572: iload 4
    //   574: iconst_4
    //   575: iadd
    //   576: aaload
    //   577: aastore
    //   578: iinc 4 -1
    //   581: iload 4
    //   583: ifge -15 -> 568
    //   586: invokestatic 1601	gnu/kawa/slib/srfi1:unfold$V	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   589: areturn
    //   590: aload_2
    //   591: iconst_0
    //   592: aaload
    //   593: ldc 68
    //   595: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   598: dup
    //   599: astore 4
    //   601: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   604: aload_2
    //   605: iconst_1
    //   606: aaload
    //   607: aload_2
    //   608: iconst_2
    //   609: aaload
    //   610: aload_2
    //   611: arraylength
    //   612: iconst_3
    //   613: isub
    //   614: istore 4
    //   616: iload 4
    //   618: anewarray 37	java/lang/Object
    //   621: goto +13 -> 634
    //   624: dup
    //   625: iload 4
    //   627: aload_2
    //   628: iload 4
    //   630: iconst_3
    //   631: iadd
    //   632: aaload
    //   633: aastore
    //   634: iinc 4 -1
    //   637: iload 4
    //   639: ifge -15 -> 624
    //   642: invokestatic 395	gnu/kawa/slib/srfi1:fold$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   645: areturn
    //   646: aload_2
    //   647: iconst_0
    //   648: aaload
    //   649: ldc 68
    //   651: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   654: dup
    //   655: astore 4
    //   657: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   660: aload_2
    //   661: iconst_1
    //   662: aaload
    //   663: aload_2
    //   664: iconst_2
    //   665: aaload
    //   666: aload_2
    //   667: arraylength
    //   668: iconst_3
    //   669: isub
    //   670: istore 4
    //   672: iload 4
    //   674: anewarray 37	java/lang/Object
    //   677: goto +13 -> 690
    //   680: dup
    //   681: iload 4
    //   683: aload_2
    //   684: iload 4
    //   686: iconst_3
    //   687: iadd
    //   688: aaload
    //   689: aastore
    //   690: iinc 4 -1
    //   693: iload 4
    //   695: ifge -15 -> 680
    //   698: invokestatic 1607	gnu/kawa/slib/srfi1:foldRight$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   701: areturn
    //   702: aload_2
    //   703: iconst_0
    //   704: aaload
    //   705: ldc 68
    //   707: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   710: dup
    //   711: astore 4
    //   713: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   716: aload_2
    //   717: iconst_1
    //   718: aaload
    //   719: aload_2
    //   720: iconst_2
    //   721: aaload
    //   722: aload_2
    //   723: arraylength
    //   724: iconst_3
    //   725: isub
    //   726: istore 4
    //   728: iload 4
    //   730: anewarray 37	java/lang/Object
    //   733: goto +13 -> 746
    //   736: dup
    //   737: iload 4
    //   739: aload_2
    //   740: iload 4
    //   742: iconst_3
    //   743: iadd
    //   744: aaload
    //   745: aastore
    //   746: iinc 4 -1
    //   749: iload 4
    //   751: ifge -15 -> 736
    //   754: invokestatic 1612	gnu/kawa/slib/srfi1:pairFoldRight$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   757: areturn
    //   758: aload_2
    //   759: iconst_0
    //   760: aaload
    //   761: ldc 68
    //   763: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   766: dup
    //   767: astore 4
    //   769: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   772: aload_2
    //   773: iconst_1
    //   774: aaload
    //   775: aload_2
    //   776: iconst_2
    //   777: aaload
    //   778: aload_2
    //   779: arraylength
    //   780: iconst_3
    //   781: isub
    //   782: istore 4
    //   784: iload 4
    //   786: anewarray 37	java/lang/Object
    //   789: goto +13 -> 802
    //   792: dup
    //   793: iload 4
    //   795: aload_2
    //   796: iload 4
    //   798: iconst_3
    //   799: iadd
    //   800: aaload
    //   801: aastore
    //   802: iinc 4 -1
    //   805: iload 4
    //   807: ifge -15 -> 792
    //   810: invokestatic 1617	gnu/kawa/slib/srfi1:pairFold$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   813: areturn
    //   814: aload_2
    //   815: iconst_0
    //   816: aaload
    //   817: aload_2
    //   818: iconst_1
    //   819: aaload
    //   820: aload_2
    //   821: arraylength
    //   822: iconst_2
    //   823: isub
    //   824: istore 4
    //   826: iload 4
    //   828: anewarray 37	java/lang/Object
    //   831: goto +13 -> 844
    //   834: dup
    //   835: iload 4
    //   837: aload_2
    //   838: iload 4
    //   840: iconst_2
    //   841: iadd
    //   842: aaload
    //   843: aastore
    //   844: iinc 4 -1
    //   847: iload 4
    //   849: ifge -15 -> 834
    //   852: invokestatic 1621	gnu/kawa/slib/srfi1:appendMap$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   855: areturn
    //   856: aload_2
    //   857: iconst_0
    //   858: aaload
    //   859: aload_2
    //   860: iconst_1
    //   861: aaload
    //   862: aload_2
    //   863: arraylength
    //   864: iconst_2
    //   865: isub
    //   866: istore 4
    //   868: iload 4
    //   870: anewarray 37	java/lang/Object
    //   873: goto +13 -> 886
    //   876: dup
    //   877: iload 4
    //   879: aload_2
    //   880: iload 4
    //   882: iconst_2
    //   883: iadd
    //   884: aaload
    //   885: aastore
    //   886: iinc 4 -1
    //   889: iload 4
    //   891: ifge -15 -> 876
    //   894: invokestatic 1624	gnu/kawa/slib/srfi1:appendMap$Ex$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   897: areturn
    //   898: aload_2
    //   899: iconst_0
    //   900: aaload
    //   901: ldc 68
    //   903: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   906: dup
    //   907: astore 4
    //   909: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   912: aload_2
    //   913: iconst_1
    //   914: aaload
    //   915: aload_2
    //   916: arraylength
    //   917: iconst_2
    //   918: isub
    //   919: istore 4
    //   921: iload 4
    //   923: anewarray 37	java/lang/Object
    //   926: goto +13 -> 939
    //   929: dup
    //   930: iload 4
    //   932: aload_2
    //   933: iload 4
    //   935: iconst_2
    //   936: iadd
    //   937: aaload
    //   938: aastore
    //   939: iinc 4 -1
    //   942: iload 4
    //   944: ifge -15 -> 929
    //   947: invokestatic 425	gnu/kawa/slib/srfi1:pairForEach$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   950: areturn
    //   951: aload_2
    //   952: iconst_0
    //   953: aaload
    //   954: ldc 68
    //   956: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   959: dup
    //   960: astore 4
    //   962: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   965: aload_2
    //   966: iconst_1
    //   967: aaload
    //   968: aload_2
    //   969: arraylength
    //   970: iconst_2
    //   971: isub
    //   972: istore 4
    //   974: iload 4
    //   976: anewarray 37	java/lang/Object
    //   979: goto +13 -> 992
    //   982: dup
    //   983: iload 4
    //   985: aload_2
    //   986: iload 4
    //   988: iconst_2
    //   989: iadd
    //   990: aaload
    //   991: aastore
    //   992: iinc 4 -1
    //   995: iload 4
    //   997: ifge -15 -> 982
    //   1000: invokestatic 1631	gnu/kawa/slib/srfi1:map$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1003: areturn
    //   1004: aload_2
    //   1005: iconst_0
    //   1006: aaload
    //   1007: ldc 68
    //   1009: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1012: dup
    //   1013: astore 4
    //   1015: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1018: aload_2
    //   1019: iconst_1
    //   1020: aaload
    //   1021: aload_2
    //   1022: arraylength
    //   1023: iconst_2
    //   1024: isub
    //   1025: istore 4
    //   1027: iload 4
    //   1029: anewarray 37	java/lang/Object
    //   1032: goto +13 -> 1045
    //   1035: dup
    //   1036: iload 4
    //   1038: aload_2
    //   1039: iload 4
    //   1041: iconst_2
    //   1042: iadd
    //   1043: aaload
    //   1044: aastore
    //   1045: iinc 4 -1
    //   1048: iload 4
    //   1050: ifge -15 -> 1035
    //   1053: invokestatic 1636	gnu/kawa/slib/srfi1:filterMap$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1056: areturn
    //   1057: aload_2
    //   1058: iconst_0
    //   1059: aaload
    //   1060: ldc 68
    //   1062: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1065: dup
    //   1066: astore 4
    //   1068: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1071: aload_2
    //   1072: iconst_1
    //   1073: aaload
    //   1074: aload_2
    //   1075: arraylength
    //   1076: iconst_2
    //   1077: isub
    //   1078: istore 4
    //   1080: iload 4
    //   1082: anewarray 37	java/lang/Object
    //   1085: goto +13 -> 1098
    //   1088: dup
    //   1089: iload 4
    //   1091: aload_2
    //   1092: iload 4
    //   1094: iconst_2
    //   1095: iadd
    //   1096: aaload
    //   1097: aastore
    //   1098: iinc 4 -1
    //   1101: iload 4
    //   1103: ifge -15 -> 1088
    //   1106: invokestatic 620	gnu/kawa/slib/srfi1:any$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1109: areturn
    //   1110: aload_2
    //   1111: iconst_0
    //   1112: aaload
    //   1113: ldc 68
    //   1115: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1118: dup
    //   1119: astore 4
    //   1121: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1124: aload_2
    //   1125: iconst_1
    //   1126: aaload
    //   1127: aload_2
    //   1128: arraylength
    //   1129: iconst_2
    //   1130: isub
    //   1131: istore 4
    //   1133: iload 4
    //   1135: anewarray 37	java/lang/Object
    //   1138: goto +13 -> 1151
    //   1141: dup
    //   1142: iload 4
    //   1144: aload_2
    //   1145: iload 4
    //   1147: iconst_2
    //   1148: iadd
    //   1149: aaload
    //   1150: aastore
    //   1151: iinc 4 -1
    //   1154: iload 4
    //   1156: ifge -15 -> 1141
    //   1159: invokestatic 677	gnu/kawa/slib/srfi1:every$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1162: areturn
    //   1163: aload_2
    //   1164: iconst_0
    //   1165: aaload
    //   1166: ldc 68
    //   1168: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1171: dup
    //   1172: astore 4
    //   1174: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1177: aload_2
    //   1178: iconst_1
    //   1179: aaload
    //   1180: aload_2
    //   1181: arraylength
    //   1182: iconst_2
    //   1183: isub
    //   1184: istore 4
    //   1186: iload 4
    //   1188: anewarray 37	java/lang/Object
    //   1191: goto +13 -> 1204
    //   1194: dup
    //   1195: iload 4
    //   1197: aload_2
    //   1198: iload 4
    //   1200: iconst_2
    //   1201: iadd
    //   1202: aaload
    //   1203: aastore
    //   1204: iinc 4 -1
    //   1207: iload 4
    //   1209: ifge -15 -> 1194
    //   1212: invokestatic 1643	gnu/kawa/slib/srfi1:listIndex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1215: areturn
    //   1216: aload_2
    //   1217: iconst_0
    //   1218: aaload
    //   1219: ldc 68
    //   1221: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1224: dup
    //   1225: astore 4
    //   1227: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1230: aload_2
    //   1231: arraylength
    //   1232: iconst_1
    //   1233: isub
    //   1234: istore 4
    //   1236: iload 4
    //   1238: anewarray 37	java/lang/Object
    //   1241: goto +13 -> 1254
    //   1244: dup
    //   1245: iload 4
    //   1247: aload_2
    //   1248: iload 4
    //   1250: iconst_1
    //   1251: iadd
    //   1252: aaload
    //   1253: aastore
    //   1254: iinc 4 -1
    //   1257: iload 4
    //   1259: ifge -15 -> 1244
    //   1262: invokestatic 1649	gnu/kawa/slib/srfi1:lset$Ls$Eq$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1265: areturn
    //   1266: aload_2
    //   1267: iconst_0
    //   1268: aaload
    //   1269: ldc 68
    //   1271: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1274: dup
    //   1275: astore 4
    //   1277: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1280: aload_2
    //   1281: arraylength
    //   1282: iconst_1
    //   1283: isub
    //   1284: istore 4
    //   1286: iload 4
    //   1288: anewarray 37	java/lang/Object
    //   1291: goto +13 -> 1304
    //   1294: dup
    //   1295: iload 4
    //   1297: aload_2
    //   1298: iload 4
    //   1300: iconst_1
    //   1301: iadd
    //   1302: aaload
    //   1303: aastore
    //   1304: iinc 4 -1
    //   1307: iload 4
    //   1309: ifge -15 -> 1294
    //   1312: invokestatic 1654	gnu/kawa/slib/srfi1:lset$Eq$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1315: areturn
    //   1316: aload_2
    //   1317: iconst_0
    //   1318: aaload
    //   1319: ldc 68
    //   1321: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1324: dup
    //   1325: astore 4
    //   1327: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1330: aload_2
    //   1331: iconst_1
    //   1332: aaload
    //   1333: aload_2
    //   1334: arraylength
    //   1335: iconst_2
    //   1336: isub
    //   1337: istore 4
    //   1339: iload 4
    //   1341: anewarray 37	java/lang/Object
    //   1344: goto +13 -> 1357
    //   1347: dup
    //   1348: iload 4
    //   1350: aload_2
    //   1351: iload 4
    //   1353: iconst_2
    //   1354: iadd
    //   1355: aaload
    //   1356: aastore
    //   1357: iinc 4 -1
    //   1360: iload 4
    //   1362: ifge -15 -> 1347
    //   1365: invokestatic 1659	gnu/kawa/slib/srfi1:lsetAdjoin$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1368: areturn
    //   1369: aload_2
    //   1370: iconst_0
    //   1371: aaload
    //   1372: ldc 68
    //   1374: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1377: dup
    //   1378: astore 4
    //   1380: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1383: aload_2
    //   1384: arraylength
    //   1385: iconst_1
    //   1386: isub
    //   1387: istore 4
    //   1389: iload 4
    //   1391: anewarray 37	java/lang/Object
    //   1394: goto +13 -> 1407
    //   1397: dup
    //   1398: iload 4
    //   1400: aload_2
    //   1401: iload 4
    //   1403: iconst_1
    //   1404: iadd
    //   1405: aaload
    //   1406: aastore
    //   1407: iinc 4 -1
    //   1410: iload 4
    //   1412: ifge -15 -> 1397
    //   1415: invokestatic 1664	gnu/kawa/slib/srfi1:lsetUnion$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1418: areturn
    //   1419: aload_2
    //   1420: iconst_0
    //   1421: aaload
    //   1422: ldc 68
    //   1424: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1427: dup
    //   1428: astore 4
    //   1430: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1433: aload_2
    //   1434: arraylength
    //   1435: iconst_1
    //   1436: isub
    //   1437: istore 4
    //   1439: iload 4
    //   1441: anewarray 37	java/lang/Object
    //   1444: goto +13 -> 1457
    //   1447: dup
    //   1448: iload 4
    //   1450: aload_2
    //   1451: iload 4
    //   1453: iconst_1
    //   1454: iadd
    //   1455: aaload
    //   1456: aastore
    //   1457: iinc 4 -1
    //   1460: iload 4
    //   1462: ifge -15 -> 1447
    //   1465: invokestatic 1669	gnu/kawa/slib/srfi1:lsetUnion$Ex$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1468: areturn
    //   1469: aload_2
    //   1470: iconst_0
    //   1471: aaload
    //   1472: ldc 68
    //   1474: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1477: dup
    //   1478: astore 4
    //   1480: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1483: aload_2
    //   1484: iconst_1
    //   1485: aaload
    //   1486: aload_2
    //   1487: arraylength
    //   1488: iconst_2
    //   1489: isub
    //   1490: istore 4
    //   1492: iload 4
    //   1494: anewarray 37	java/lang/Object
    //   1497: goto +13 -> 1510
    //   1500: dup
    //   1501: iload 4
    //   1503: aload_2
    //   1504: iload 4
    //   1506: iconst_2
    //   1507: iadd
    //   1508: aaload
    //   1509: aastore
    //   1510: iinc 4 -1
    //   1513: iload 4
    //   1515: ifge -15 -> 1500
    //   1518: invokestatic 1674	gnu/kawa/slib/srfi1:lsetIntersection$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1521: areturn
    //   1522: aload_2
    //   1523: iconst_0
    //   1524: aaload
    //   1525: ldc 68
    //   1527: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1530: dup
    //   1531: astore 4
    //   1533: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1536: aload_2
    //   1537: iconst_1
    //   1538: aaload
    //   1539: aload_2
    //   1540: arraylength
    //   1541: iconst_2
    //   1542: isub
    //   1543: istore 4
    //   1545: iload 4
    //   1547: anewarray 37	java/lang/Object
    //   1550: goto +13 -> 1563
    //   1553: dup
    //   1554: iload 4
    //   1556: aload_2
    //   1557: iload 4
    //   1559: iconst_2
    //   1560: iadd
    //   1561: aaload
    //   1562: aastore
    //   1563: iinc 4 -1
    //   1566: iload 4
    //   1568: ifge -15 -> 1553
    //   1571: invokestatic 1679	gnu/kawa/slib/srfi1:lsetIntersection$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1574: areturn
    //   1575: aload_2
    //   1576: iconst_0
    //   1577: aaload
    //   1578: ldc 68
    //   1580: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1583: dup
    //   1584: astore 4
    //   1586: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1589: aload_2
    //   1590: iconst_1
    //   1591: aaload
    //   1592: aload_2
    //   1593: arraylength
    //   1594: iconst_2
    //   1595: isub
    //   1596: istore 4
    //   1598: iload 4
    //   1600: anewarray 37	java/lang/Object
    //   1603: goto +13 -> 1616
    //   1606: dup
    //   1607: iload 4
    //   1609: aload_2
    //   1610: iload 4
    //   1612: iconst_2
    //   1613: iadd
    //   1614: aaload
    //   1615: aastore
    //   1616: iinc 4 -1
    //   1619: iload 4
    //   1621: ifge -15 -> 1606
    //   1624: invokestatic 1684	gnu/kawa/slib/srfi1:lsetDifference$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1627: areturn
    //   1628: aload_2
    //   1629: iconst_0
    //   1630: aaload
    //   1631: ldc 68
    //   1633: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1636: dup
    //   1637: astore 4
    //   1639: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1642: aload_2
    //   1643: iconst_1
    //   1644: aaload
    //   1645: aload_2
    //   1646: arraylength
    //   1647: iconst_2
    //   1648: isub
    //   1649: istore 4
    //   1651: iload 4
    //   1653: anewarray 37	java/lang/Object
    //   1656: goto +13 -> 1669
    //   1659: dup
    //   1660: iload 4
    //   1662: aload_2
    //   1663: iload 4
    //   1665: iconst_2
    //   1666: iadd
    //   1667: aaload
    //   1668: aastore
    //   1669: iinc 4 -1
    //   1672: iload 4
    //   1674: ifge -15 -> 1659
    //   1677: invokestatic 1689	gnu/kawa/slib/srfi1:lsetDifference$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1680: areturn
    //   1681: aload_2
    //   1682: iconst_0
    //   1683: aaload
    //   1684: ldc 68
    //   1686: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1689: dup
    //   1690: astore 4
    //   1692: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1695: aload_2
    //   1696: arraylength
    //   1697: iconst_1
    //   1698: isub
    //   1699: istore 4
    //   1701: iload 4
    //   1703: anewarray 37	java/lang/Object
    //   1706: goto +13 -> 1719
    //   1709: dup
    //   1710: iload 4
    //   1712: aload_2
    //   1713: iload 4
    //   1715: iconst_1
    //   1716: iadd
    //   1717: aaload
    //   1718: aastore
    //   1719: iinc 4 -1
    //   1722: iload 4
    //   1724: ifge -15 -> 1709
    //   1727: invokestatic 1694	gnu/kawa/slib/srfi1:lsetXor$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1730: areturn
    //   1731: aload_2
    //   1732: iconst_0
    //   1733: aaload
    //   1734: ldc 68
    //   1736: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1739: dup
    //   1740: astore 4
    //   1742: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1745: aload_2
    //   1746: arraylength
    //   1747: iconst_1
    //   1748: isub
    //   1749: istore 4
    //   1751: iload 4
    //   1753: anewarray 37	java/lang/Object
    //   1756: goto +13 -> 1769
    //   1759: dup
    //   1760: iload 4
    //   1762: aload_2
    //   1763: iload 4
    //   1765: iconst_1
    //   1766: iadd
    //   1767: aaload
    //   1768: aastore
    //   1769: iinc 4 -1
    //   1772: iload 4
    //   1774: ifge -15 -> 1759
    //   1777: invokestatic 1699	gnu/kawa/slib/srfi1:lsetXor$Ex$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1780: areturn
    //   1781: aload_2
    //   1782: iconst_0
    //   1783: aaload
    //   1784: ldc 68
    //   1786: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1789: dup
    //   1790: astore 4
    //   1792: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1795: aload_2
    //   1796: iconst_1
    //   1797: aaload
    //   1798: aload_2
    //   1799: arraylength
    //   1800: iconst_2
    //   1801: isub
    //   1802: istore 4
    //   1804: iload 4
    //   1806: anewarray 37	java/lang/Object
    //   1809: goto +13 -> 1822
    //   1812: dup
    //   1813: iload 4
    //   1815: aload_2
    //   1816: iload 4
    //   1818: iconst_2
    //   1819: iadd
    //   1820: aaload
    //   1821: aastore
    //   1822: iinc 4 -1
    //   1825: iload 4
    //   1827: ifge -15 -> 1812
    //   1830: invokestatic 1704	gnu/kawa/slib/srfi1:lsetDiff$PlIntersection$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1833: areturn
    //   1834: aload_2
    //   1835: iconst_0
    //   1836: aaload
    //   1837: ldc 68
    //   1839: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1842: dup
    //   1843: astore 4
    //   1845: invokestatic 541	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   1848: aload_2
    //   1849: iconst_1
    //   1850: aaload
    //   1851: aload_2
    //   1852: arraylength
    //   1853: iconst_2
    //   1854: isub
    //   1855: istore 4
    //   1857: iload 4
    //   1859: anewarray 37	java/lang/Object
    //   1862: goto +13 -> 1875
    //   1865: dup
    //   1866: iload 4
    //   1868: aload_2
    //   1869: iload 4
    //   1871: iconst_2
    //   1872: iadd
    //   1873: aaload
    //   1874: aastore
    //   1875: iinc 4 -1
    //   1878: iload 4
    //   1880: ifge -15 -> 1865
    //   1883: invokestatic 1709	gnu/kawa/slib/srfi1:lsetDiff$PlIntersection$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1886: areturn
    //   1887: aload_0
    //   1888: aload_1
    //   1889: aload_2
    //   1890: invokespecial 1712	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1893: areturn
    //   1894: new 122	gnu/mapping/WrongType
    //   1897: dup_x1
    //   1898: swap
    //   1899: ldc_w 1593
    //   1902: iconst_1
    //   1903: aload_3
    //   1904: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1907: athrow
    //   1908: new 122	gnu/mapping/WrongType
    //   1911: dup_x1
    //   1912: swap
    //   1913: ldc_w 1573
    //   1916: iconst_1
    //   1917: aload 4
    //   1919: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1922: athrow
    //   1923: new 122	gnu/mapping/WrongType
    //   1926: dup_x1
    //   1927: swap
    //   1928: ldc_w 1573
    //   1931: iconst_2
    //   1932: aload 4
    //   1934: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1937: athrow
    //   1938: new 122	gnu/mapping/WrongType
    //   1941: dup_x1
    //   1942: swap
    //   1943: ldc_w 1573
    //   1946: iconst_3
    //   1947: aload 4
    //   1949: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1952: athrow
    //   1953: new 122	gnu/mapping/WrongType
    //   1956: dup_x1
    //   1957: swap
    //   1958: ldc_w 1597
    //   1961: iconst_1
    //   1962: aload 4
    //   1964: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1967: athrow
    //   1968: new 122	gnu/mapping/WrongType
    //   1971: dup_x1
    //   1972: swap
    //   1973: ldc_w 1597
    //   1976: iconst_2
    //   1977: aload 4
    //   1979: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1982: athrow
    //   1983: new 122	gnu/mapping/WrongType
    //   1986: dup_x1
    //   1987: swap
    //   1988: ldc_w 1597
    //   1991: iconst_3
    //   1992: aload 4
    //   1994: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1997: athrow
    //   1998: new 122	gnu/mapping/WrongType
    //   2001: dup_x1
    //   2002: swap
    //   2003: ldc_w 1602
    //   2006: iconst_1
    //   2007: aload 4
    //   2009: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2012: athrow
    //   2013: new 122	gnu/mapping/WrongType
    //   2016: dup_x1
    //   2017: swap
    //   2018: ldc_w 1604
    //   2021: iconst_1
    //   2022: aload 4
    //   2024: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2027: athrow
    //   2028: new 122	gnu/mapping/WrongType
    //   2031: dup_x1
    //   2032: swap
    //   2033: ldc_w 1609
    //   2036: iconst_1
    //   2037: aload 4
    //   2039: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2042: athrow
    //   2043: new 122	gnu/mapping/WrongType
    //   2046: dup_x1
    //   2047: swap
    //   2048: ldc_w 1614
    //   2051: iconst_1
    //   2052: aload 4
    //   2054: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2057: athrow
    //   2058: new 122	gnu/mapping/WrongType
    //   2061: dup_x1
    //   2062: swap
    //   2063: ldc_w 1626
    //   2066: iconst_1
    //   2067: aload 4
    //   2069: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2072: athrow
    //   2073: new 122	gnu/mapping/WrongType
    //   2076: dup_x1
    //   2077: swap
    //   2078: ldc_w 1628
    //   2081: iconst_1
    //   2082: aload 4
    //   2084: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2087: athrow
    //   2088: new 122	gnu/mapping/WrongType
    //   2091: dup_x1
    //   2092: swap
    //   2093: ldc_w 1633
    //   2096: iconst_1
    //   2097: aload 4
    //   2099: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2102: athrow
    //   2103: new 122	gnu/mapping/WrongType
    //   2106: dup_x1
    //   2107: swap
    //   2108: ldc_w 1637
    //   2111: iconst_1
    //   2112: aload 4
    //   2114: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2117: athrow
    //   2118: new 122	gnu/mapping/WrongType
    //   2121: dup_x1
    //   2122: swap
    //   2123: ldc_w 1638
    //   2126: iconst_1
    //   2127: aload 4
    //   2129: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2132: athrow
    //   2133: new 122	gnu/mapping/WrongType
    //   2136: dup_x1
    //   2137: swap
    //   2138: ldc_w 1640
    //   2141: iconst_1
    //   2142: aload 4
    //   2144: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2147: athrow
    //   2148: new 122	gnu/mapping/WrongType
    //   2151: dup_x1
    //   2152: swap
    //   2153: ldc_w 1645
    //   2156: iconst_1
    //   2157: aload 4
    //   2159: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2162: athrow
    //   2163: new 122	gnu/mapping/WrongType
    //   2166: dup_x1
    //   2167: swap
    //   2168: ldc_w 1651
    //   2171: iconst_1
    //   2172: aload 4
    //   2174: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2177: athrow
    //   2178: new 122	gnu/mapping/WrongType
    //   2181: dup_x1
    //   2182: swap
    //   2183: ldc_w 1656
    //   2186: iconst_1
    //   2187: aload 4
    //   2189: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2192: athrow
    //   2193: new 122	gnu/mapping/WrongType
    //   2196: dup_x1
    //   2197: swap
    //   2198: ldc_w 1661
    //   2201: iconst_1
    //   2202: aload 4
    //   2204: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2207: athrow
    //   2208: new 122	gnu/mapping/WrongType
    //   2211: dup_x1
    //   2212: swap
    //   2213: ldc_w 1666
    //   2216: iconst_1
    //   2217: aload 4
    //   2219: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2222: athrow
    //   2223: new 122	gnu/mapping/WrongType
    //   2226: dup_x1
    //   2227: swap
    //   2228: ldc_w 1671
    //   2231: iconst_1
    //   2232: aload 4
    //   2234: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2237: athrow
    //   2238: new 122	gnu/mapping/WrongType
    //   2241: dup_x1
    //   2242: swap
    //   2243: ldc_w 1676
    //   2246: iconst_1
    //   2247: aload 4
    //   2249: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2252: athrow
    //   2253: new 122	gnu/mapping/WrongType
    //   2256: dup_x1
    //   2257: swap
    //   2258: ldc_w 1681
    //   2261: iconst_1
    //   2262: aload 4
    //   2264: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2267: athrow
    //   2268: new 122	gnu/mapping/WrongType
    //   2271: dup_x1
    //   2272: swap
    //   2273: ldc_w 1686
    //   2276: iconst_1
    //   2277: aload 4
    //   2279: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2282: athrow
    //   2283: new 122	gnu/mapping/WrongType
    //   2286: dup_x1
    //   2287: swap
    //   2288: ldc_w 1691
    //   2291: iconst_1
    //   2292: aload 4
    //   2294: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2297: athrow
    //   2298: new 122	gnu/mapping/WrongType
    //   2301: dup_x1
    //   2302: swap
    //   2303: ldc_w 1696
    //   2306: iconst_1
    //   2307: aload 4
    //   2309: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2312: athrow
    //   2313: new 122	gnu/mapping/WrongType
    //   2316: dup_x1
    //   2317: swap
    //   2318: ldc_w 1701
    //   2321: iconst_1
    //   2322: aload 4
    //   2324: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2327: athrow
    //   2328: new 122	gnu/mapping/WrongType
    //   2331: dup_x1
    //   2332: swap
    //   2333: ldc_w 1706
    //   2336: iconst_1
    //   2337: aload 4
    //   2339: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2342: athrow
    // Line number table:
    //   Java source line #266	-> byte code offset #280
    //   Java source line #336	-> byte code offset #285
    //   Java source line #401	-> byte code offset #319
    //   Java source line #440	-> byte code offset #353
    //   Java source line #652	-> byte code offset #387
    //   Java source line #793	-> byte code offset #392
    //   Java source line #819	-> byte code offset #439
    //   Java source line #826	-> byte code offset #509
    //   Java source line #843	-> byte code offset #590
    //   Java source line #855	-> byte code offset #646
    //   Java source line #868	-> byte code offset #702
    //   Java source line #878	-> byte code offset #758
    //   Java source line #910	-> byte code offset #814
    //   Java source line #915	-> byte code offset #856
    //   Java source line #920	-> byte code offset #898
    //   Java source line #937	-> byte code offset #951
    //   Java source line #953	-> byte code offset #1004
    //   Java source line #1333	-> byte code offset #1057
    //   Java source line #1361	-> byte code offset #1110
    //   Java source line #1386	-> byte code offset #1163
    //   Java source line #1432	-> byte code offset #1216
    //   Java source line #1441	-> byte code offset #1266
    //   Java source line #1452	-> byte code offset #1316
    //   Java source line #1457	-> byte code offset #1369
    //   Java source line #1469	-> byte code offset #1419
    //   Java source line #1484	-> byte code offset #1469
    //   Java source line #1492	-> byte code offset #1522
    //   Java source line #1501	-> byte code offset #1575
    //   Java source line #1510	-> byte code offset #1628
    //   Java source line #1520	-> byte code offset #1681
    //   Java source line #1541	-> byte code offset #1731
    //   Java source line #1563	-> byte code offset #1781
    //   Java source line #1571	-> byte code offset #1834
    //   Java source line #793	-> byte code offset #1894
    //   Java source line #819	-> byte code offset #1908
    //   Java source line #826	-> byte code offset #1953
    //   Java source line #843	-> byte code offset #1998
    //   Java source line #855	-> byte code offset #2013
    //   Java source line #868	-> byte code offset #2028
    //   Java source line #878	-> byte code offset #2043
    //   Java source line #920	-> byte code offset #2058
    //   Java source line #937	-> byte code offset #2073
    //   Java source line #953	-> byte code offset #2088
    //   Java source line #1333	-> byte code offset #2103
    //   Java source line #1361	-> byte code offset #2118
    //   Java source line #1386	-> byte code offset #2133
    //   Java source line #1432	-> byte code offset #2148
    //   Java source line #1441	-> byte code offset #2163
    //   Java source line #1452	-> byte code offset #2178
    //   Java source line #1457	-> byte code offset #2193
    //   Java source line #1469	-> byte code offset #2208
    //   Java source line #1484	-> byte code offset #2223
    //   Java source line #1492	-> byte code offset #2238
    //   Java source line #1501	-> byte code offset #2253
    //   Java source line #1510	-> byte code offset #2268
    //   Java source line #1520	-> byte code offset #2283
    //   Java source line #1541	-> byte code offset #2298
    //   Java source line #1563	-> byte code offset #2313
    //   Java source line #1571	-> byte code offset #2328
    // Exception table:
    //   from	to	target	type
    //   402	405	1894	java/lang/ClassCastException
    //   455	458	1908	java/lang/ClassCastException
    //   469	472	1923	java/lang/ClassCastException
    //   483	486	1938	java/lang/ClassCastException
    //   520	523	1953	java/lang/ClassCastException
    //   534	537	1968	java/lang/ClassCastException
    //   548	551	1983	java/lang/ClassCastException
    //   601	604	1998	java/lang/ClassCastException
    //   657	660	2013	java/lang/ClassCastException
    //   713	716	2028	java/lang/ClassCastException
    //   769	772	2043	java/lang/ClassCastException
    //   909	912	2058	java/lang/ClassCastException
    //   962	965	2073	java/lang/ClassCastException
    //   1015	1018	2088	java/lang/ClassCastException
    //   1068	1071	2103	java/lang/ClassCastException
    //   1121	1124	2118	java/lang/ClassCastException
    //   1174	1177	2133	java/lang/ClassCastException
    //   1227	1230	2148	java/lang/ClassCastException
    //   1277	1280	2163	java/lang/ClassCastException
    //   1327	1330	2178	java/lang/ClassCastException
    //   1380	1383	2193	java/lang/ClassCastException
    //   1430	1433	2208	java/lang/ClassCastException
    //   1480	1483	2223	java/lang/ClassCastException
    //   1533	1536	2238	java/lang/ClassCastException
    //   1586	1589	2253	java/lang/ClassCastException
    //   1639	1642	2268	java/lang/ClassCastException
    //   1692	1695	2283	java/lang/ClassCastException
    //   1742	1745	2298	java/lang/ClassCastException
    //   1792	1795	2313	java/lang/ClassCastException
    //   1845	1848	2328	java/lang/ClassCastException
  }
  
  public class frame1
    extends ModuleBody
  {
    Procedure f;
    
    public frame1() {}
    
    /* Error */
    public Object lambda10recur(Object head, Object lis)
    {
      // Byte code:
      //   0: aload_2
      //   1: invokestatic 6	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   4: ifeq +46 -> 50
      //   7: aload_0
      //   8: getfield 12	gnu/kawa/slib/srfi1$frame1:f	Lgnu/mapping/Procedure;
      //   11: aload_1
      //   12: aload_0
      //   13: aload_2
      //   14: ldc 14
      //   16: invokestatic 20	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   19: dup
      //   20: astore_3
      //   21: checkcast 14	gnu/lists/Pair
      //   24: invokestatic 33	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   27: aload_2
      //   28: ldc 14
      //   30: invokestatic 20	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   33: dup
      //   34: astore_3
      //   35: checkcast 14	gnu/lists/Pair
      //   38: invokestatic 37	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   41: invokevirtual 41	gnu/kawa/slib/srfi1$frame1:lambda10recur	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   44: invokevirtual 46	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   47: goto +4 -> 51
      //   50: aload_1
      //   51: areturn
      //   52: new 24	gnu/mapping/WrongType
      //   55: dup_x1
      //   56: swap
      //   57: ldc 26
      //   59: iconst_1
      //   60: aload_3
      //   61: invokespecial 30	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   64: athrow
      //   65: new 24	gnu/mapping/WrongType
      //   68: dup_x1
      //   69: swap
      //   70: ldc 35
      //   72: iconst_1
      //   73: aload_3
      //   74: invokespecial 30	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   77: athrow
      // Line number table:
      //   Java source line #901	-> byte code offset #0
      //   Java source line #902	-> byte code offset #7
      //   Java source line #901	-> byte code offset #50
      //   Java source line #902	-> byte code offset #52
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	52	0	this	frame1
      //   0	51	1	head	Object
      //   0	51	2	lis	Object
      //   20	54	3	localObject	Object
      //   52	1	4	localClassCastException1	ClassCastException
      //   65	1	5	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   21	24	52	java/lang/ClassCastException
      //   35	38	65	java/lang/ClassCastException
    }
  }
  
  public class frame7
    extends ModuleBody
  {
    Procedure maybe$Mn$Eq;
    
    public frame7() {}
    
    /* Error */
    public Object lambda16recur(Object lis)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 6	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
      //   4: ifeq +7 -> 11
      //   7: aload_1
      //   8: goto +65 -> 73
      //   11: aload_1
      //   12: ldc 8
      //   14: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   17: dup
      //   18: astore_3
      //   19: checkcast 8	gnu/lists/Pair
      //   22: invokestatic 29	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   25: astore_2
      //   26: aload_1
      //   27: ldc 8
      //   29: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   32: dup
      //   33: astore 4
      //   35: checkcast 8	gnu/lists/Pair
      //   38: invokestatic 33	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   41: astore_3
      //   42: aload_0
      //   43: aload_2
      //   44: aload_3
      //   45: aload_0
      //   46: getfield 39	gnu/kawa/slib/srfi1$frame7:maybe$Mn$Eq	Lgnu/mapping/Procedure;
      //   49: invokestatic 43	gnu/kawa/slib/srfi1:delete	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   52: invokevirtual 47	gnu/kawa/slib/srfi1$frame7:lambda16recur	(Ljava/lang/Object;)Ljava/lang/Object;
      //   55: astore 4
      //   57: aload_3
      //   58: aload 4
      //   60: if_acmpne +7 -> 67
      //   63: aload_1
      //   64: goto +9 -> 73
      //   67: aload_2
      //   68: aload 4
      //   70: invokestatic 51	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   73: areturn
      //   74: new 18	gnu/mapping/WrongType
      //   77: dup_x1
      //   78: swap
      //   79: ldc 20
      //   81: iconst_1
      //   82: aload_3
      //   83: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   86: athrow
      //   87: new 18	gnu/mapping/WrongType
      //   90: dup_x1
      //   91: swap
      //   92: ldc 31
      //   94: iconst_1
      //   95: aload 4
      //   97: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   100: athrow
      // Line number table:
      //   Java source line #1237	-> byte code offset #0
      //   Java source line #1238	-> byte code offset #11
      //   Java source line #1239	-> byte code offset #26
      //   Java source line #1238	-> byte code offset #42
      //   Java source line #1240	-> byte code offset #42
      //   Java source line #1241	-> byte code offset #57
      //   Java source line #1238	-> byte code offset #74
      //   Java source line #1239	-> byte code offset #87
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	frame7
      //   0	73	1	lis	Object
      //   25	43	2	x	Object
      //   18	1	3	localObject1	Object
      //   41	42	3	tail	Object
      //   33	1	4	localObject2	Object
      //   55	41	4	new$Mntail	Object
      //   74	1	7	localClassCastException1	ClassCastException
      //   87	1	8	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   19	22	74	java/lang/ClassCastException
      //   35	38	87	java/lang/ClassCastException
    }
  }
  
  public class frame8
    extends ModuleBody
  {
    Procedure maybe$Mn$Eq;
    
    public frame8() {}
    
    /* Error */
    public Object lambda17recur(Object lis)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 6	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
      //   4: ifeq +7 -> 11
      //   7: aload_1
      //   8: goto +65 -> 73
      //   11: aload_1
      //   12: ldc 8
      //   14: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   17: dup
      //   18: astore_3
      //   19: checkcast 8	gnu/lists/Pair
      //   22: invokestatic 29	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   25: astore_2
      //   26: aload_1
      //   27: ldc 8
      //   29: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   32: dup
      //   33: astore 4
      //   35: checkcast 8	gnu/lists/Pair
      //   38: invokestatic 33	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   41: astore_3
      //   42: aload_0
      //   43: aload_2
      //   44: aload_3
      //   45: aload_0
      //   46: getfield 39	gnu/kawa/slib/srfi1$frame8:maybe$Mn$Eq	Lgnu/mapping/Procedure;
      //   49: invokestatic 43	gnu/kawa/slib/srfi1:delete$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   52: invokevirtual 47	gnu/kawa/slib/srfi1$frame8:lambda17recur	(Ljava/lang/Object;)Ljava/lang/Object;
      //   55: astore 4
      //   57: aload_3
      //   58: aload 4
      //   60: if_acmpne +7 -> 67
      //   63: aload_1
      //   64: goto +9 -> 73
      //   67: aload_2
      //   68: aload 4
      //   70: invokestatic 51	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   73: areturn
      //   74: new 18	gnu/mapping/WrongType
      //   77: dup_x1
      //   78: swap
      //   79: ldc 20
      //   81: iconst_1
      //   82: aload_3
      //   83: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   86: athrow
      //   87: new 18	gnu/mapping/WrongType
      //   90: dup_x1
      //   91: swap
      //   92: ldc 31
      //   94: iconst_1
      //   95: aload 4
      //   97: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   100: athrow
      // Line number table:
      //   Java source line #1245	-> byte code offset #0
      //   Java source line #1246	-> byte code offset #11
      //   Java source line #1247	-> byte code offset #26
      //   Java source line #1246	-> byte code offset #42
      //   Java source line #1248	-> byte code offset #42
      //   Java source line #1249	-> byte code offset #57
      //   Java source line #1246	-> byte code offset #74
      //   Java source line #1247	-> byte code offset #87
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	frame8
      //   0	73	1	lis	Object
      //   25	43	2	x	Object
      //   18	1	3	localObject1	Object
      //   41	42	3	tail	Object
      //   33	1	4	localObject2	Object
      //   55	41	4	new$Mntail	Object
      //   74	1	7	localClassCastException1	ClassCastException
      //   87	1	8	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   19	22	74	java/lang/ClassCastException
      //   35	38	87	java/lang/ClassCastException
    }
  }
  
  public class frame11
    extends ModuleBody
  {
    Procedure pred;
    
    public frame11() {}
    
    /* Error */
    public Object lambda20recur(Object lis)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 6	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
      //   4: ifeq +9 -> 13
      //   7: getstatic 12	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   10: goto +60 -> 70
      //   13: aload_1
      //   14: ldc 14
      //   16: invokestatic 20	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   19: dup
      //   20: astore_3
      //   21: checkcast 14	gnu/lists/Pair
      //   24: invokestatic 35	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   27: astore_2
      //   28: aload_0
      //   29: getfield 41	gnu/kawa/slib/srfi1$frame11:pred	Lgnu/mapping/Procedure;
      //   32: aload_2
      //   33: invokevirtual 47	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   36: invokestatic 52	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   39: ifeq +28 -> 67
      //   42: aload_2
      //   43: aload_0
      //   44: aload_1
      //   45: ldc 14
      //   47: invokestatic 20	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   50: dup
      //   51: astore_3
      //   52: checkcast 14	gnu/lists/Pair
      //   55: invokestatic 56	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   58: invokevirtual 59	gnu/kawa/slib/srfi1$frame11:lambda20recur	(Ljava/lang/Object;)Ljava/lang/Object;
      //   61: invokestatic 63	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   64: goto +6 -> 70
      //   67: getstatic 12	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   70: areturn
      //   71: new 24	gnu/mapping/WrongType
      //   74: dup_x1
      //   75: swap
      //   76: ldc 26
      //   78: iconst_1
      //   79: aload_3
      //   80: invokespecial 30	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   83: athrow
      //   84: new 24	gnu/mapping/WrongType
      //   87: dup_x1
      //   88: swap
      //   89: ldc 54
      //   91: iconst_1
      //   92: aload_3
      //   93: invokespecial 30	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   96: athrow
      // Line number table:
      //   Java source line #1288	-> byte code offset #0
      //   Java source line #1289	-> byte code offset #13
      //   Java source line #1290	-> byte code offset #28
      //   Java source line #1291	-> byte code offset #42
      //   Java source line #1289	-> byte code offset #71
      //   Java source line #1291	-> byte code offset #84
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	71	0	this	frame11
      //   0	70	1	lis	Object
      //   27	16	2	x	Object
      //   20	73	3	localObject1	Object
      //   71	1	4	localClassCastException1	ClassCastException
      //   84	1	5	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   21	24	71	java/lang/ClassCastException
      //   52	55	84	java/lang/ClassCastException
    }
  }
  
  public class frame35
    extends ModuleBody
  {
    kawa.lang.Continuation abort;
    
    public frame35() {}
    
    /* Error */
    public Object lambda46recur(Object lists)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 6	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   4: ifeq +76 -> 80
      //   7: aload_1
      //   8: ldc 8
      //   10: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   13: dup
      //   14: astore_3
      //   15: checkcast 8	gnu/lists/Pair
      //   18: invokestatic 27	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   21: astore_2
      //   22: aload_2
      //   23: invokestatic 32	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Z
      //   26: ifeq +16 -> 42
      //   29: aload_0
      //   30: getfield 38	gnu/kawa/slib/srfi1$frame35:abort	Lkawa/lang/Continuation;
      //   33: getstatic 44	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   36: invokevirtual 50	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   39: goto +44 -> 83
      //   42: aload_2
      //   43: ldc 8
      //   45: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   48: dup
      //   49: astore_3
      //   50: checkcast 8	gnu/lists/Pair
      //   53: invokestatic 54	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   56: aload_0
      //   57: aload_1
      //   58: ldc 8
      //   60: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   63: dup
      //   64: astore_3
      //   65: checkcast 8	gnu/lists/Pair
      //   68: invokestatic 54	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   71: invokevirtual 57	gnu/kawa/slib/srfi1$frame35:lambda46recur	(Ljava/lang/Object;)Ljava/lang/Object;
      //   74: invokestatic 61	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   77: goto +6 -> 83
      //   80: getstatic 44	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   83: areturn
      //   84: new 18	gnu/mapping/WrongType
      //   87: dup_x1
      //   88: swap
      //   89: ldc 20
      //   91: iconst_1
      //   92: aload_3
      //   93: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   96: athrow
      //   97: new 18	gnu/mapping/WrongType
      //   100: dup_x1
      //   101: swap
      //   102: ldc 52
      //   104: iconst_1
      //   105: aload_3
      //   106: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   109: athrow
      //   110: new 18	gnu/mapping/WrongType
      //   113: dup_x1
      //   114: swap
      //   115: ldc 52
      //   117: iconst_1
      //   118: aload_3
      //   119: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   122: athrow
      // Line number table:
      //   Java source line #730	-> byte code offset #0
      //   Java source line #731	-> byte code offset #7
      //   Java source line #732	-> byte code offset #22
      //   Java source line #733	-> byte code offset #42
      //   Java source line #731	-> byte code offset #84
      //   Java source line #733	-> byte code offset #97
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	84	0	this	frame35
      //   0	83	1	lists	Object
      //   21	22	2	lis	Object
      //   14	105	3	localObject1	Object
      //   84	1	4	localClassCastException1	ClassCastException
      //   97	1	5	localClassCastException2	ClassCastException
      //   110	1	6	localClassCastException3	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   15	18	84	java/lang/ClassCastException
      //   50	53	97	java/lang/ClassCastException
      //   65	68	110	java/lang/ClassCastException
    }
  }
  
  public class frame38
    extends ModuleBody
  {
    Object cars$Mnfinal;
    
    public frame38() {}
  }
}
