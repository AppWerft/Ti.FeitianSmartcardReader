package gnu.commonlisp.lang;

import gnu.expr.Declaration;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.Special;
import gnu.expr.Symbols;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Symbol;
import java.util.ArrayList;
import kawa.lang.Lambda;
import kawa.lang.SyntaxForm;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;











public class OrdinaryLambda
  extends Lambda
{
  protected Object allowOtherKeysKeyword;
  protected Object auxKeyword;
  protected Object bodyKeyword;
  Object[] rewriteHelper = new Object[16];
  int rwIdx = 0;
  
  public OrdinaryLambda() {}
  
  public void setKeywords(Object optional, Object rest, Object key, Object allowOthers, Object aux, Object body) {
    optionalKeyword = optional;
    restKeyword = rest;
    keyKeyword = key;
    allowOtherKeysKeyword = allowOthers;
    auxKeyword = aux;
    bodyKeyword = body;
  }
  









  public void rewrite(LambdaExp lexp, Object formals, Object body, Translator tr, TemplateScope templateScopeRest)
  {
    rewriteFormals(lexp, formals, tr, templateScopeRest);
    if ((body instanceof PairWithPosition)) {
      lexp.setFile(((PairWithPosition)body).getFileName());
    }
    rewriteBody(lexp, body, tr);
  }
  








  public void rewriteFormals(LambdaExp lexp, Object formals, Translator tr, TemplateScope templateScopeRest)
  {
    if (lexp.getSymbol() == null)
    {
      String filename = lexp.getFileName();
      int line = lexp.getLineNumber();
      if ((filename != null) && (line > 0))
        lexp.setSourceLocation(filename, line);
    }
    Object bindings = formals;
    Object mode = null;
    TemplateScope templateScope = templateScopeRest;
    int allow_other_keys;
    int aux_args; int key_args; int rest_args; int opt_args = rest_args = aux_args = key_args = aux_args = allow_other_keys = -1;
    


    ArrayList<Keyword> keywords = null;
    Pair pair; for (;; bindings = pair.getCdr())
    {
      if ((bindings instanceof SyntaxForm))
      {
        SyntaxForm sf = (SyntaxForm)bindings;
        bindings = sf.getDatum();
        

        templateScopeRest = sf.getScope();
      }
      if (!(bindings instanceof Pair))
        break;
      pair = (Pair)bindings;
      Object pair_car = pair.getCar();
      if ((pair_car instanceof SyntaxForm))
      {
        SyntaxForm sf = (SyntaxForm)pair_car;
        pair_car = sf.getDatum();
        templateScope = sf.getScope();
      }
      
      if (pair_car == optionalKeyword)
      {
        if (opt_args >= 0) {
          tr.syntaxError("multiple " + optionalKeyword + " keywords in parameter list");
        } else if ((rest_args >= 0) || (key_args >= 0) || (aux_args >= 0)) {
          tr.syntaxError(optionalKeyword + " after " + restKeyword + " or " + keyKeyword + " or " + auxKeyword);
        }
        opt_args = 0;
      }
      else if ((pair_car == restKeyword) || (pair_car == bodyKeyword))
      {
        if (rest_args >= 0) {
          tr.syntaxError("multiple " + pair_car + " keywords in parameter list");
        } else if ((key_args >= 0) || (aux_args >= 0))
          tr.syntaxError(pair_car + " after " + keyKeyword + " or " + auxKeyword);
        rest_args = 0;
      }
      else if (pair_car == keyKeyword)
      {
        if (key_args >= 0)
          tr.syntaxError("multiple " + keyKeyword + " keywords in parameter list");
        key_args = 0;
      }
      else if (pair_car == auxKeyword)
      {
        if (aux_args >= 0)
          tr.syntaxError("multiple " + auxKeyword + " keywords in parameter list");
        aux_args = 0;
      }
      else if (key_args >= 0) {
        key_args++;
      } else if (rest_args >= 0) {
        rest_args++;
      } else if (opt_args >= 0) {
        opt_args++;
      } else if (aux_args >= 0) {
        aux_args++;
      } else {
        min_args += 1; }
      if ((pair_car == optionalKeyword) || (pair_car == restKeyword) || (pair_car == bodyKeyword) || (pair_car == keyKeyword) || (pair_car == auxKeyword))
      {

        mode = pair_car;
      }
      else {
        Object savePos = tr.pushPositionOf(pair);
        Object name = null;
        Object defaultValue = defaultDefault;
        Object suppliedp = null;
        
        Pair p = null;
        pair_car = tr.namespaceResolve(pair_car);
        if ((pair_car instanceof Symbol))
        {
          name = pair_car;
        }
        else if ((pair_car instanceof Pair))
        {
          p = (Pair)pair_car;
          pair_car = p.getCar();
          if ((pair_car instanceof SyntaxForm))
          {
            SyntaxForm sf = (SyntaxForm)pair_car;
            pair_car = sf.getDatum();
            templateScope = sf.getScope();
          }
          pair_car = tr.namespaceResolve(pair_car);
          if (((pair_car instanceof Symbol)) && ((p.getCdr() instanceof Pair)))
          {

            name = pair_car;
            p = (Pair)p.getCdr();
            if ((p != null) && (mode != null))
            {
              defaultValue = p.getCar();
              if ((p.getCdr() instanceof Pair))
              {
                p = (Pair)p.getCdr();
                suppliedp = p.getCar();
              }
              if (p.getCdr() == LList.Empty) {
                p = null;
              }
              else {
                tr.syntaxError("improper list in specifier for parameter '" + name + "')");
                
                break;
              }
            }
            if (p != null)
            {
              if (p.getCdr() != LList.Empty)
              {
                tr.syntaxError("junk at end of specifier for parameter `" + name + "`" + ": " + p.getCdr());
                
                break;
              }
            }
          }
        }
        if ((name == null) && (p != null))
        {
          tr.syntaxError("general symbols in keyword parameter not implemented");
        }
        

















        Declaration decl = new Declaration(name);
        decl.setFlag(8796093022208L);
        
        Declaration tmpVar = new Declaration(Symbols.gentemp());
        

        if (suppliedp != null)
        {
          if (rwIdx >= rewriteHelper.length - 4) {
            Object[] newHelper = new Object[2 * rewriteHelper.length];
            System.arraycopy(rewriteHelper, 0, newHelper, 0, rewriteHelper.length);
            rewriteHelper = newHelper;
          }
          rewriteHelper[(rwIdx++)] = decl;
          rewriteHelper[(rwIdx++)] = defaultValue;
          rewriteHelper[(rwIdx++)] = new Declaration(suppliedp);
          rewriteHelper[(rwIdx++)] = tmpVar;
          tmpVar.setFlag(8796093022208L);
        }
        
        if ((mode == optionalKeyword) || (mode == keyKeyword) || (mode == auxKeyword))
        {

          if (suppliedp != null)
          {
            tmpVar.setInitValue(new LangExp(Special.undefined));
          }
          else
          {
            decl.setInitValue(new LangExp(defaultValue));
          }
          
          if (mode == keyKeyword)
          {
            if (keywords == null) {
              keywords = new ArrayList();
            }
            

            keywords.add(Keyword.make((name instanceof Symbol) ? ((Symbol)name).getName() : name.toString()));
          }
        }
        


        Translator.setLine(decl, bindings);
        if ((mode == restKeyword) || (mode == bodyKeyword))
          decl.setType(LangObjType.listType);
        tmpVar.setFlag(262144L);
        decl.setFlag(262144L);
        
        addParam(suppliedp != null ? tmpVar : decl, templateScope, lexp, tr);
        tr.popPositionOf(savePos);
      } }
    if ((bindings instanceof SyntaxForm))
    {
      SyntaxForm sf = (SyntaxForm)bindings;
      bindings = sf.getDatum();
      templateScopeRest = sf.getScope();
    }
    if ((bindings instanceof Symbol))
    {
      if ((opt_args >= 0) || (key_args >= 0) || (aux_args >= 0))
      {
        tr.syntaxError("dotted rest-arg after " + optionalKeyword + ", " + restKeyword + ", or " + keyKeyword + ", or " + auxKeyword);

      }
      else
      {

        rest_args = 1;
        Declaration decl = new Declaration(bindings);
        decl.setType(LangObjType.listType);
        decl.setFlag(262144L);
        decl.noteValueUnknown();
        addParam(decl, templateScopeRest, lexp, tr);
      }
    }
    else if (bindings != LList.Empty)
    {
      tr.syntaxError("misformed formals in lambda");
    }
    if (rest_args > 1)
    {
      tr.syntaxError("multiple " + restKeyword + " parameters");
      rest_args = 1;
    }
    if (opt_args < 0)
      opt_args = 0;
    if (rest_args < 0)
      rest_args = 0;
    if (key_args < 0)
      key_args = 0;
    if (aux_args < 0)
      aux_args = 0;
    if (rest_args > 0) {
      max_args = -1;
    } else
      max_args = (min_args + opt_args + 2 * key_args);
    opt_args = opt_args;
    if (keywords != null) {
      keywords = ((Keyword[])keywords.toArray(new Keyword[keywords.size()]));
    }
  }
  
  /* Error */
  public gnu.expr.Expression auxillaryRewrite(Object body, Translator tr)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 4	gnu/commonlisp/lang/OrdinaryLambda:rwIdx	I
    //   6: ifne +10 -> 16
    //   9: aload_0
    //   10: aload_1
    //   11: aload_2
    //   12: invokespecial 85	kawa/lang/Lambda:auxillaryRewrite	(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    //   15: areturn
    //   16: iconst_2
    //   17: istore 4
    //   19: aload_0
    //   20: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   23: iload 4
    //   25: aaload
    //   26: ifnull +119 -> 145
    //   29: iconst_1
    //   30: istore_3
    //   31: aload_2
    //   32: invokevirtual 86	kawa/lang/Translator:letStart	()V
    //   35: aload_0
    //   36: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   39: iload 4
    //   41: aaload
    //   42: ifnull +99 -> 141
    //   45: aload_2
    //   46: aload_0
    //   47: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   50: iload 4
    //   52: aaload
    //   53: checkcast 48	gnu/expr/Declaration
    //   56: new 87	gnu/expr/IfExp
    //   59: dup
    //   60: new 88	gnu/expr/ApplyExp
    //   63: dup
    //   64: getstatic 89	gnu/commonlisp/lang/CommonLisp:isEq	Lgnu/kawa/functions/IsEq;
    //   67: iconst_2
    //   68: anewarray 90	gnu/expr/Expression
    //   71: dup
    //   72: iconst_0
    //   73: new 91	gnu/expr/ReferenceExp
    //   76: dup
    //   77: aload_0
    //   78: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   81: iload 4
    //   83: iconst_1
    //   84: iadd
    //   85: aaload
    //   86: checkcast 48	gnu/expr/Declaration
    //   89: invokespecial 92	gnu/expr/ReferenceExp:<init>	(Lgnu/expr/Declaration;)V
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: new 93	gnu/expr/QuoteExp
    //   98: dup
    //   99: getstatic 56	gnu/expr/Special:undefined	Lgnu/expr/Special;
    //   102: invokespecial 94	gnu/expr/QuoteExp:<init>	(Ljava/lang/Object;)V
    //   105: aastore
    //   106: invokespecial 95	gnu/expr/ApplyExp:<init>	(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V
    //   109: new 93	gnu/expr/QuoteExp
    //   112: dup
    //   113: getstatic 96	gnu/commonlisp/lang/CommonLisp:FALSE	Lgnu/lists/LList;
    //   116: invokespecial 94	gnu/expr/QuoteExp:<init>	(Ljava/lang/Object;)V
    //   119: new 93	gnu/expr/QuoteExp
    //   122: dup
    //   123: getstatic 97	gnu/commonlisp/lang/CommonLisp:TRUE	Lgnu/mapping/Symbol;
    //   126: invokespecial 94	gnu/expr/QuoteExp:<init>	(Ljava/lang/Object;)V
    //   129: invokespecial 98	gnu/expr/IfExp:<init>	(Lgnu/expr/Expression;Lgnu/expr/Expression;Lgnu/expr/Expression;)V
    //   132: invokevirtual 99	kawa/lang/Translator:letVariable	(Lgnu/expr/Declaration;Lgnu/expr/Expression;)V
    //   135: iinc 4 4
    //   138: goto -103 -> 35
    //   141: aload_2
    //   142: invokevirtual 100	kawa/lang/Translator:letEnter	()V
    //   145: iconst_0
    //   146: istore 4
    //   148: aload_2
    //   149: invokevirtual 86	kawa/lang/Translator:letStart	()V
    //   152: aload_0
    //   153: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   156: iload 4
    //   158: aaload
    //   159: ifnull +198 -> 357
    //   162: aload_0
    //   163: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   166: iload 4
    //   168: iconst_2
    //   169: iadd
    //   170: aaload
    //   171: ifnull +78 -> 249
    //   174: aload_2
    //   175: aload_0
    //   176: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   179: iload 4
    //   181: aaload
    //   182: checkcast 48	gnu/expr/Declaration
    //   185: new 87	gnu/expr/IfExp
    //   188: dup
    //   189: new 91	gnu/expr/ReferenceExp
    //   192: dup
    //   193: aload_0
    //   194: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   197: iload 4
    //   199: iconst_2
    //   200: iadd
    //   201: aaload
    //   202: checkcast 48	gnu/expr/Declaration
    //   205: invokespecial 92	gnu/expr/ReferenceExp:<init>	(Lgnu/expr/Declaration;)V
    //   208: new 91	gnu/expr/ReferenceExp
    //   211: dup
    //   212: aload_0
    //   213: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   216: iload 4
    //   218: iconst_3
    //   219: iadd
    //   220: aaload
    //   221: checkcast 48	gnu/expr/Declaration
    //   224: invokespecial 92	gnu/expr/ReferenceExp:<init>	(Lgnu/expr/Declaration;)V
    //   227: aload_2
    //   228: aload_0
    //   229: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   232: iload 4
    //   234: iconst_1
    //   235: iadd
    //   236: aaload
    //   237: invokevirtual 101	kawa/lang/Translator:rewrite	(Ljava/lang/Object;)Lgnu/expr/Expression;
    //   240: invokespecial 98	gnu/expr/IfExp:<init>	(Lgnu/expr/Expression;Lgnu/expr/Expression;Lgnu/expr/Expression;)V
    //   243: invokevirtual 99	kawa/lang/Translator:letVariable	(Lgnu/expr/Declaration;Lgnu/expr/Expression;)V
    //   246: goto +105 -> 351
    //   249: aload_2
    //   250: aload_0
    //   251: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   254: iload 4
    //   256: aaload
    //   257: checkcast 48	gnu/expr/Declaration
    //   260: new 87	gnu/expr/IfExp
    //   263: dup
    //   264: new 88	gnu/expr/ApplyExp
    //   267: dup
    //   268: getstatic 89	gnu/commonlisp/lang/CommonLisp:isEq	Lgnu/kawa/functions/IsEq;
    //   271: iconst_2
    //   272: anewarray 90	gnu/expr/Expression
    //   275: dup
    //   276: iconst_0
    //   277: new 91	gnu/expr/ReferenceExp
    //   280: dup
    //   281: aload_0
    //   282: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   285: iload 4
    //   287: iconst_3
    //   288: iadd
    //   289: aaload
    //   290: checkcast 48	gnu/expr/Declaration
    //   293: invokespecial 92	gnu/expr/ReferenceExp:<init>	(Lgnu/expr/Declaration;)V
    //   296: aastore
    //   297: dup
    //   298: iconst_1
    //   299: new 93	gnu/expr/QuoteExp
    //   302: dup
    //   303: getstatic 56	gnu/expr/Special:undefined	Lgnu/expr/Special;
    //   306: invokespecial 94	gnu/expr/QuoteExp:<init>	(Ljava/lang/Object;)V
    //   309: aastore
    //   310: invokespecial 95	gnu/expr/ApplyExp:<init>	(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V
    //   313: aload_2
    //   314: aload_0
    //   315: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   318: iload 4
    //   320: iconst_1
    //   321: iadd
    //   322: aaload
    //   323: invokevirtual 101	kawa/lang/Translator:rewrite	(Ljava/lang/Object;)Lgnu/expr/Expression;
    //   326: new 91	gnu/expr/ReferenceExp
    //   329: dup
    //   330: aload_0
    //   331: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   334: iload 4
    //   336: iconst_3
    //   337: iadd
    //   338: aaload
    //   339: checkcast 48	gnu/expr/Declaration
    //   342: invokespecial 92	gnu/expr/ReferenceExp:<init>	(Lgnu/expr/Declaration;)V
    //   345: invokespecial 98	gnu/expr/IfExp:<init>	(Lgnu/expr/Expression;Lgnu/expr/Expression;Lgnu/expr/Expression;)V
    //   348: invokevirtual 99	kawa/lang/Translator:letVariable	(Lgnu/expr/Declaration;Lgnu/expr/Expression;)V
    //   351: iinc 4 4
    //   354: goto -202 -> 152
    //   357: aload_2
    //   358: invokevirtual 100	kawa/lang/Translator:letEnter	()V
    //   361: aload_2
    //   362: aload_2
    //   363: aload_1
    //   364: invokevirtual 102	kawa/lang/Translator:rewrite_body	(Ljava/lang/Object;)Lgnu/expr/Expression;
    //   367: invokevirtual 103	kawa/lang/Translator:letDone	(Lgnu/expr/Expression;)Lgnu/expr/LetExp;
    //   370: astore 5
    //   372: iload_3
    //   373: ifeq +11 -> 384
    //   376: aload_2
    //   377: aload 5
    //   379: invokevirtual 103	kawa/lang/Translator:letDone	(Lgnu/expr/Expression;)Lgnu/expr/LetExp;
    //   382: astore 5
    //   384: iconst_0
    //   385: istore 4
    //   387: iload 4
    //   389: aload_0
    //   390: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   393: arraylength
    //   394: if_icmpge +27 -> 421
    //   397: aload_0
    //   398: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   401: iload 4
    //   403: aload_0
    //   404: getfield 3	gnu/commonlisp/lang/OrdinaryLambda:rewriteHelper	[Ljava/lang/Object;
    //   407: iload 4
    //   409: iconst_2
    //   410: iadd
    //   411: aconst_null
    //   412: dup_x2
    //   413: aastore
    //   414: aastore
    //   415: iinc 4 4
    //   418: goto -31 -> 387
    //   421: aload_0
    //   422: iconst_0
    //   423: putfield 4	gnu/commonlisp/lang/OrdinaryLambda:rwIdx	I
    //   426: aload 5
    //   428: areturn
    // Line number table:
    //   Java source line #371	-> byte code offset #0
    //   Java source line #372	-> byte code offset #2
    //   Java source line #373	-> byte code offset #9
    //   Java source line #374	-> byte code offset #16
    //   Java source line #375	-> byte code offset #19
    //   Java source line #377	-> byte code offset #29
    //   Java source line #378	-> byte code offset #31
    //   Java source line #379	-> byte code offset #35
    //   Java source line #381	-> byte code offset #45
    //   Java source line #387	-> byte code offset #135
    //   Java source line #389	-> byte code offset #141
    //   Java source line #391	-> byte code offset #145
    //   Java source line #392	-> byte code offset #148
    //   Java source line #393	-> byte code offset #152
    //   Java source line #395	-> byte code offset #162
    //   Java source line #397	-> byte code offset #174
    //   Java source line #404	-> byte code offset #249
    //   Java source line #411	-> byte code offset #351
    //   Java source line #413	-> byte code offset #357
    //   Java source line #414	-> byte code offset #361
    //   Java source line #415	-> byte code offset #372
    //   Java source line #416	-> byte code offset #376
    //   Java source line #418	-> byte code offset #384
    //   Java source line #420	-> byte code offset #397
    //   Java source line #418	-> byte code offset #415
    //   Java source line #423	-> byte code offset #421
    //   Java source line #424	-> byte code offset #426
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	this	OrdinaryLambda
    //   0	429	1	body	Object
    //   0	429	2	tr	Translator
    //   1	372	3	outerLet	boolean
    //   17	399	4	i	int
    //   370	57	5	suppLet	gnu.expr.LetExp
  }
  
  public void print(Consumer out)
  {
    out.write("#<BUILTIN LAMBDA>");
  }
}
