package kawa.standard;

import gnu.expr.ClassExp;
import gnu.expr.Declaration;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.lists.Pair;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class object extends kawa.lang.Syntax
{
  public static final object objectSyntax = new object(SchemeCompilation.lambda);
  
  static { objectSyntax.setName("object"); }
  
  kawa.lang.Lambda lambda;
  public static final Keyword accessKeyword = Keyword.make("access");
  public static final Keyword classNameKeyword = Keyword.make("class-name");
  public static final Keyword interfaceKeyword = Keyword.make("interface");
  public static final Keyword throwsKeyword = Keyword.make("throws");
  static final Keyword typeKeyword = Keyword.make("type");
  public static final Keyword allocationKeyword = Keyword.make("allocation");
  static final Keyword initKeyword = Keyword.make("init");
  static final Keyword initformKeyword = Keyword.make("initform");
  static final Keyword init_formKeyword = Keyword.make("init-form");
  static final Keyword init_valueKeyword = Keyword.make("init-value");
  static final Keyword init_keywordKeyword = Keyword.make("init-keyword");
  
  static final gnu.mapping.Symbol coloncolon = gnu.mapping.Namespace.EmptyNamespace.getSymbol("::");
  
  public object(kawa.lang.Lambda lambda)
  {
    this.lambda = lambda;
  }
  
  public gnu.expr.Expression rewriteForm(Pair form, Translator tr)
  {
    if (!(form.getCdr() instanceof Pair))
      return tr.syntaxError("missing superclass specification in object");
    Pair pair = (Pair)form.getCdr();
    gnu.expr.ObjectExp oexp = new gnu.expr.ObjectExp();
    if ((pair.getCar() instanceof gnu.lists.FString))
    {

      if (!(pair.getCdr() instanceof Pair))
        return tr.syntaxError("missing superclass specification after object class name");
      pair = (Pair)pair.getCdr();
    }
    Object[] saved = scanClassDef(pair, oexp, tr);
    if (saved != null)
      rewriteClassDef(saved, tr);
    return oexp;
  }
  



  public Object[] scanClassDef(Pair pair, ClassExp oexp, Translator tr)
  {
    tr.mustCompileHere();
    Object superlist = pair.getCar();
    Object components = pair.getCdr();
    Object classNamePair = null;
    long classAccessFlag = 0L;
    
    java.util.Vector inits = new java.util.Vector(20);
    for (Object obj = components; obj != gnu.lists.LList.Empty;)
    {


      while ((obj instanceof SyntaxForm))
        obj = ((SyntaxForm)obj).getDatum();
      if (!(obj instanceof Pair))
      {
        tr.error('e', "object member not a list");
        return null;
      }
      pair = (Pair)obj;
      Object pair_car = pair.getCar();
      while ((pair_car instanceof SyntaxForm))
        pair_car = ((SyntaxForm)pair_car).getDatum();
      obj = pair.getCdr();
      Object savedPos1 = tr.pushPositionOf(pair);
      if ((pair_car instanceof Keyword))
      {
        while ((obj instanceof SyntaxForm))
          obj = ((SyntaxForm)obj).getDatum();
        if ((obj instanceof Pair))
        {
          if (pair_car == interfaceKeyword)
          {
            Object val = ((Pair)obj).getCar();
            while ((val instanceof SyntaxForm))
              val = ((SyntaxForm)val).getDatum();
            if (val == Boolean.FALSE) {
              oexp.setFlag(131072);
            } else
              oexp.setFlag(98304);
            obj = ((Pair)obj).getCdr();
            tr.popPositionOf(savedPos1);
            continue;
          }
          if (pair_car == classNameKeyword)
          {
            if (classNamePair != null)
              tr.error('e', "duplicate class-name specifiers");
            classNamePair = obj;
            obj = ((Pair)obj).getCdr();
            tr.popPositionOf(savedPos1);
            continue;
          }
          if (pair_car == accessKeyword)
          {
            Object savedPos2 = tr.pushPositionOf(obj);
            classAccessFlag = addAccessFlags(((Pair)obj).getCar(), classAccessFlag, 60179873792L, "class", tr);
            


            if (nameDecl == null)
              tr.error('e', "access specifier for anonymous class");
            tr.popPositionOf(savedPos2);
            obj = ((Pair)obj).getCdr();
            tr.popPositionOf(savedPos1);
          }
          
        }
      }
      else if (((pair_car instanceof Pair)) && (kawa.lang.Lambda.isAnnotationSymbol(((Pair)pair_car).getCar())))
      {

        if (nameDecl == null) {
          tr.error('e', "annotation for anonymous class"); continue;
        }
        nameDecl.addAnnotation(new gnu.expr.LangExp(pair));
        continue;
      }
      if (!(pair_car instanceof Pair))
      {
        tr.error('e', "object member not a list");
        return null;
      }
      pair = (Pair)pair_car;
      pair_car = pair.getCar();
      while ((pair_car instanceof SyntaxForm))
        pair_car = ((SyntaxForm)pair_car).getDatum();
      if (((pair_car instanceof String)) || ((pair_car instanceof gnu.mapping.Symbol)) || ((pair_car instanceof Keyword)))
      {

        Pair typePair = null;
        Object sname = pair_car;
        

        int allocationFlag = 0;
        long accessFlag = 0L;
        Object args; Declaration decl; Object args; if ((sname instanceof Keyword))
        {
          Declaration decl = null;
          args = pair;
        }
        else
        {
          decl = oexp.addDeclaration(sname);
          decl.setSimple(false);
          decl.setFlag(1048576L);
          Translator.setLine(decl, pair);
          args = pair.getCdr();
        }
        int nKeywords = 0;
        boolean seenInit = false;
        Pair initPair = null;
        while (args != gnu.lists.LList.Empty)
        {
          while ((args instanceof SyntaxForm))
            args = ((SyntaxForm)args).getDatum();
          pair = (Pair)args;
          Pair keyPair = pair;
          Object key = Translator.stripSyntax(pair.getCar());
          Object savedPos2 = tr.pushPositionOf(pair);
          args = pair.getCdr();
          if (((key == coloncolon) || ((key instanceof Keyword))) && ((args instanceof Pair)))
          {

            nKeywords++;
            pair = (Pair)args;
            Object value = Translator.stripSyntax(pair.getCar());
            args = pair.getCdr();
            if ((key == coloncolon) || (key == typeKeyword)) {
              typePair = pair;
            } else if (key == allocationKeyword)
            {
              if (allocationFlag != 0)
                tr.error('e', "duplicate allocation: specification");
              if ((matches(value, "class", tr)) || (matches(value, "static", tr)))
              {
                allocationFlag = 2048;
              } else if (matches(value, "instance", tr)) {
                allocationFlag = 4096;
              } else {
                tr.error('e', "unknown allocation kind '" + value + "'");
              }
            } else if ((key == initKeyword) || (key == initformKeyword) || (key == init_formKeyword) || (key == init_valueKeyword))
            {



              if (seenInit)
                tr.error('e', "duplicate initialization");
              seenInit = true;
              


              if (key != initKeyword) {
                initPair = pair;
              }
            } else if (key == init_keywordKeyword)
            {
              if (!(value instanceof Keyword)) {
                tr.error('e', "invalid 'init-keyword' - not a keyword");
              } else if (((Keyword)value).getName() != sname.toString())
              {
                tr.error('w', "init-keyword option ignored");
              }
            } else if (key == accessKeyword)
            {
              Object savedPos3 = tr.pushPositionOf(pair);
              accessFlag = addAccessFlags(value, accessFlag, 32463912960L, "field", tr);
              

              tr.popPositionOf(savedPos3);
            }
            else
            {
              tr.error('w', "unknown slot keyword '" + key + "'");
            }
          }
          else if ((args == gnu.lists.LList.Empty) && (!seenInit))
          {

            initPair = keyPair;
            seenInit = true;
          }
          else if (((args instanceof Pair)) && (nKeywords == 0) && (!seenInit) && (typePair == null) && ((pair = (Pair)args).getCdr() == gnu.lists.LList.Empty))
          {



            typePair = keyPair;
            initPair = pair;
            args = pair.getCdr();
            seenInit = true;
          }
          else if (((key instanceof Pair)) && (kawa.lang.Lambda.isAnnotationSymbol(((Pair)key).getCar())))
          {

            decl.addAnnotation(new gnu.expr.LangExp(keyPair));
          }
          else
          {
            args = null;
            break;
          }
          tr.popPositionOf(savedPos2);
        }
        if (args != gnu.lists.LList.Empty)
        {
          tr.error('e', "invalid argument list for slot '" + sname + '\'' + " args:" + (args == null ? "null" : args.getClass().getName()));
          
          return null;
        }
        if (seenInit)
        {
          boolean isStatic = allocationFlag == 2048;
          
          inits.addElement(isStatic ? Boolean.TRUE : decl != null ? decl : Boolean.FALSE);
          
          inits.addElement(initPair);
        }
        if (decl == null)
        {
          if (!seenInit)
          {
            tr.error('e', "missing field name");
            return null;
          }
        }
        else
        {
          if (typePair != null)
          {
            decl.setTypeExp(new gnu.expr.LangExp(typePair));
            decl.setFlag(8192L);
          }
          if (allocationFlag != 0)
            decl.setFlag(allocationFlag);
          if (accessFlag != 0L) {
            decl.setFlag(accessFlag);
          }
          





          decl.noteValueUnknown();
          decl.setCanRead(true);
          decl.setCanWrite(true);
        }
      }
      else if ((pair_car instanceof Pair))
      {
        Pair mpair = (Pair)pair_car;
        Object mname = mpair.getCar();
        while ((mname instanceof SyntaxForm))
          mname = ((SyntaxForm)mname).getDatum();
        if ((!(mname instanceof String)) && (!(mname instanceof gnu.mapping.Symbol)))
        {

          tr.error('e', "missing method name");
          return null;
        }
        LambdaExp lexp = new LambdaExp();
        Declaration decl = oexp.addMethod(lexp, mname);
        Translator.setLine(decl, mpair);
        oexp.pushChild(lexp);
      }
      else {
        tr.error('e', "invalid field/method definition"); }
      tr.popPositionOf(savedPos1);
    }
    oexp.reverseChildList();
    if ((classAccessFlag != 0L) && (nameDecl != null))
    {
      nameDecl.setFlag(classAccessFlag);
      if ((classAccessFlag & 0x800000000) != 0L) {
        oexp.setFlag(32768);
      }
    }
    if (classNamePair != null)
    {
      gnu.expr.Expression classNameExp = tr.rewrite_car((Pair)classNamePair, false);
      Object classNameVal = classNameExp.valueIfConstant();
      

      boolean isString = classNameVal instanceof CharSequence;
      String classNameSpecifier; if ((isString) && ((classNameSpecifier = classNameVal.toString()).length() > 0))
      {
        classNameSpecifier = classNameSpecifier;
      } else {
        tr.errorWithPosition("class-name specifier must be a non-empty string literal", classNamePair);
      }
    }
    Object[] result = { oexp, components, inits, superlist };
    




    return result;
  }
  
  public void rewriteClassDef(Object[] saved, Translator tr)
  {
    ClassExp oexp = (ClassExp)saved[0];
    Object components = saved[1];
    java.util.Vector inits = (java.util.Vector)saved[2];
    Object superlist = saved[3];
    LambdaExp method_list = firstChild;
    
    int num_supers = Translator.listLength(superlist);
    if (num_supers < 0)
    {
      tr.error('e', "object superclass specification not a list");
      num_supers = 0;
    }
    gnu.expr.Expression[] supers = new gnu.expr.Expression[num_supers];
    for (int i = 0; i < num_supers; i++)
    {
      while ((superlist instanceof SyntaxForm))
      {

        superlist = ((SyntaxForm)superlist).getDatum();
      }
      Pair superpair = (Pair)superlist;
      supers[i] = tr.rewrite_car(superpair, false);
      if ((supers[i] instanceof gnu.expr.ReferenceExp))
      {
        Declaration decl = Declaration.followAliases(((gnu.expr.ReferenceExp)supers[i]).getBinding());
        gnu.expr.Expression svalue;
        if ((decl != null) && (((svalue = decl.getValue()) instanceof ClassExp)))
          ((ClassExp)svalue).setFlag(262144);
      }
      superlist = superpair.getCdr();
    }
    
    supers = supers;
    
    oexp.setTypes(tr);
    
    if (nameDecl != null)
      kawa.lang.Lambda.rewriteAnnotations(nameDecl, tr);
    for (Declaration decl = oexp.firstDecl(); decl != null; decl = decl.nextDecl())
    {
      kawa.lang.Lambda.rewriteAnnotations(decl, tr);
    }
    


    int len = inits.size();
    for (int i = 0; i < len; i += 2)
    {
      Object init = inits.elementAt(i + 1);
      if (init != null) {
        rewriteInit(inits.elementAt(i), oexp, (Pair)init, tr, null);
      }
    }
    tr.push(oexp);
    

    LambdaExp meth = method_list;
    int init_index = 0;
    SyntaxForm componentsSyntax = null;
    for (Object obj = components; obj != gnu.lists.LList.Empty;)
    {
      while ((obj instanceof SyntaxForm))
      {
        componentsSyntax = (SyntaxForm)obj;
        obj = componentsSyntax.getDatum();
      }
      Pair pair = (Pair)obj;
      Object savedPos1 = tr.pushPositionOf(pair);
      Object pair_car = pair.getCar();
      SyntaxForm memberSyntax = componentsSyntax;
      while ((pair_car instanceof SyntaxForm))
      {
        memberSyntax = (SyntaxForm)pair_car;
        pair_car = memberSyntax.getDatum();
      }
      try
      {
        obj = pair.getCdr();
        if (((pair_car instanceof Keyword)) && ((obj instanceof Pair)))
        {


          obj = ((Pair)obj).getCdr();
          





















































































































          tr.popPositionOf(savedPos1);
        }
        else
        {
          pair = (Pair)pair_car;
          pair_car = pair.getCar();
          SyntaxForm memberCarSyntax = memberSyntax;
          while ((pair_car instanceof SyntaxForm))
          {
            memberCarSyntax = (SyntaxForm)pair_car;
            pair_car = memberCarSyntax.getDatum();
          }
          if (!kawa.lang.Lambda.isAnnotationSymbol(pair_car))
          {
            if (((pair_car instanceof String)) || ((pair_car instanceof gnu.mapping.Symbol)) || ((pair_car instanceof Keyword)))
            {

              Object type = null;
              int nKeywords = 0;
              Object args = (pair_car instanceof Keyword) ? pair : pair.getCdr();
              Pair initPair = null;
              SyntaxForm initSyntax = null;
              while (args != gnu.lists.LList.Empty)
              {
                while ((args instanceof SyntaxForm))
                {
                  memberSyntax = (SyntaxForm)args;
                  args = memberSyntax.getDatum();
                }
                pair = (Pair)args;
                Object key = pair.getCar();
                while ((key instanceof SyntaxForm))
                  key = ((SyntaxForm)key).getDatum();
                Object savedPos2 = tr.pushPositionOf(pair);
                args = pair.getCdr();
                if (((key == coloncolon) || ((key instanceof Keyword))) && ((args instanceof Pair)))
                {

                  nKeywords++;
                  pair = (Pair)args;
                  Object value = pair.getCar();
                  args = pair.getCdr();
                  if ((key == coloncolon) || (key == typeKeyword)) {
                    type = value;
                  } else if ((key == initKeyword) || (key == initformKeyword) || (key == init_formKeyword) || (key == init_valueKeyword))
                  {



                    initPair = pair;
                    initSyntax = memberSyntax;

                  }
                  


                }
                else if ((args == gnu.lists.LList.Empty) && (initPair == null))
                {

                  initPair = pair;
                  initSyntax = memberSyntax;
                }
                else if (((args instanceof Pair)) && (nKeywords == 0) && (initPair == null) && (type == null) && ((pair = (Pair)args).getCdr() == gnu.lists.LList.Empty))
                {



                  type = key;
                  initPair = pair;
                  initSyntax = memberSyntax;
                  args = pair.getCdr();
                }
                else
                {
                  args = null;
                  break;
                }
                tr.popPositionOf(savedPos2);
              }
              if (initPair != null)
              {
                Object d = inits.elementAt(init_index++);
                boolean isStatic = d == Boolean.TRUE ? true : (d instanceof Declaration) ? ((Declaration)d).getFlag(2048L) : false;
                

                if (inits.elementAt(init_index++) == null) {
                  rewriteInit(d, oexp, initPair, tr, initSyntax);
                }
              }
            } else if ((pair_car instanceof Pair))
            {
              gnu.expr.ScopeExp save_scope = tr.currentScope();
              



              if (memberSyntax != null)
                tr.setCurrentScope(memberSyntax.getScope());
              if ("*init*".equals(meth.getName()))
                meth.setReturnType(gnu.bytecode.Type.voidType);
              Translator.setLine(meth, pair);
              LambdaExp saveLambda = curMethodLambda;
              curMethodLambda = meth;
              lambda.rewrite(meth, ((Pair)pair_car).getCdr(), pair.getCdr(), tr, (memberCarSyntax != null) && ((memberSyntax == null) || (memberCarSyntax.getScope() != memberSyntax.getScope())) ? memberCarSyntax.getScope() : null);
              




              curMethodLambda = saveLambda;
              if (memberSyntax != null)
                tr.setCurrentScope(save_scope);
              meth = nextSibling;
            }
            else {
              tr.syntaxError("invalid field/method definition");
            } }
        }
      } finally {
        tr.popPositionOf(savedPos1);
      }
    }
    for (Declaration decl = oexp.firstDecl(); 
        decl != null; decl = decl.nextDecl())
    {
      gnu.expr.Expression texp = decl.getTypeExpRaw();
      if ((texp instanceof gnu.expr.LangExp))
      {
        Pair typeSpecPair = (Pair)((gnu.expr.LangExp)texp).getLangValue();
        tr.exp2Type(typeSpecPair, decl, null);
      }
    }
    


    if (initMethod != null)
      initMethod.setOuter(oexp);
    if (clinitMethod != null)
      clinitMethod.setOuter(oexp);
    tr.pop(oexp);
  }
  

  private static void rewriteInit(Object d, ClassExp oexp, Pair initPair, Translator tr, SyntaxForm initSyntax)
  {
    boolean isStatic = d == Boolean.TRUE ? true : (d instanceof Declaration) ? ((Declaration)d).getFlag(2048L) : false;
    

    LambdaExp initMethod = isStatic ? clinitMethod : initMethod;
    if (initMethod == null)
    {
      initMethod = new LambdaExp(new gnu.expr.BeginExp());
      initMethod.setClassMethod(true);
      initMethod.setReturnType(gnu.bytecode.Type.voidType);
      if (isStatic)
      {
        initMethod.setName("$clinit$");
        clinitMethod = initMethod;
      }
      else
      {
        initMethod.setName("$finit$");
        initMethod = initMethod;
        

        initMethod.add(null, new Declaration(gnu.expr.ThisExp.THIS_NAME));
      }
      oexp.pushChild(initMethod);
    }
    tr.push(initMethod);
    LambdaExp saveLambda = curMethodLambda;
    curMethodLambda = initMethod;
    gnu.expr.Expression initValue = tr.rewrite_car(initPair, initSyntax);
    if ((d instanceof Declaration))
    {
      Declaration decl = (Declaration)d;
      gnu.expr.SetExp sexp = new gnu.expr.SetExp(decl, initValue);
      sexp.setLocation(decl);
      decl.noteValueFromSet(sexp);
      initValue = sexp;
    }
    else {
      initValue = gnu.expr.Compilation.makeCoercion(initValue, new gnu.expr.QuoteExp(gnu.bytecode.Type.voidType)); }
    ((gnu.expr.BeginExp)body).add(initValue);
    curMethodLambda = saveLambda;
    tr.pop(initMethod);
  }
  



  static boolean matches(Object exp, String tag, Translator tr)
  {
    String value;
    

    if ((exp instanceof Keyword)) {
      value = ((Keyword)exp).getName(); } else { String value;
      if ((exp instanceof gnu.lists.FString)) {
        value = ((gnu.lists.FString)exp).toString(); } else { Object qvalue;
        String value; if (((exp instanceof Pair)) && (((qvalue = tr.matchQuoted((Pair)exp)) instanceof gnu.mapping.SimpleSymbol)))
        {
          value = qvalue.toString();
        } else
          return false; } }
    String value; return (tag == null) || (tag.equals(value));
  }
  

  public static long addAccessFlags(Object value, long previous, long allowed, String kind, Translator tr)
  {
    long flags = matchAccess(value, tr);
    if (flags == 0L) {
      tr.error('e', "unknown access specifier " + value);
    } else if ((flags & (allowed ^ 0xFFFFFFFFFFFFFFFF)) != 0L) {
      tr.error('e', "invalid " + kind + " access specifier " + value);
    } else if ((previous & flags) != 0L)
      tr.error('w', "duplicate " + kind + " access specifiers " + value);
    return previous | flags;
  }
  
  static long matchAccess(Object value, Translator tr)
  {
    while ((value instanceof SyntaxForm))
      value = ((SyntaxForm)value).getDatum();
    if ((value instanceof Pair))
    {
      Pair p = (Pair)value;
      value = tr.matchQuoted((Pair)value);
      if ((value instanceof Pair))
        return matchAccess2((Pair)value, tr);
    }
    return matchAccess1(value, tr);
  }
  
  private static long matchAccess2(Pair pair, Translator tr)
  {
    long icar = matchAccess1(pair.getCar(), tr);
    Object cdr = pair.getCdr();
    if ((cdr == gnu.lists.LList.Empty) || (icar == 0L))
      return icar;
    if ((cdr instanceof Pair))
    {
      long icdr = matchAccess2((Pair)cdr, tr);
      if (icdr != 0L)
        return icar | icdr;
    }
    return 0L;
  }
  
  private static long matchAccess1(Object value, Translator tr)
  {
    if ((value instanceof Keyword)) {
      value = ((Keyword)value).getName();
    } else if ((value instanceof gnu.lists.FString)) {
      value = ((gnu.lists.FString)value).toString();
    } else if ((value instanceof gnu.mapping.SimpleSymbol))
      value = value.toString();
    if ("private".equals(value))
      return 16777216L;
    if ("protected".equals(value))
      return 33554432L;
    if ("public".equals(value))
      return 67108864L;
    if ("package".equals(value))
      return 134217728L;
    if ("volatile".equals(value))
      return 2147483648L;
    if ("transient".equals(value))
      return 4294967296L;
    if ("enum".equals(value))
      return 8589934592L;
    if ("final".equals(value))
      return 17179869184L;
    if ("abstract".equals(value))
      return 34359738368L;
    if ("synchronized".equals(value))
      return 68719476736L;
    if ("strictfp".equals(value))
      return 137438953472L;
    return 0L;
  }
}
