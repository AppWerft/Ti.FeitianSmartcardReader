package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.reflect.Invoke;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Lambda;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class define extends Syntax
{
  public static final define defineRaw = new define(SchemeCompilation.lambda);
  
  Lambda lambda;
  
  String getName(int options)
  {
    if ((options & 0x4) != 0)
      return "define-private";
    if ((options & 0x8) != 0)
      return "define-constant";
    if ((options & 0x20) != 0) {
      return "define-variable";
    }
    return "define";
  }
  
  public define(Lambda lambda)
  {
    this.lambda = lambda;
  }
  
  public void scanForm(Pair st, ScopeExp defs, Translator tr)
  {
    Pair p1 = (Pair)st.getCdr();
    Pair p2 = (Pair)p1.getCdr();
    Pair p3 = (Pair)p2.getCdr();
    kawa.lang.TemplateScope templateScope = null;
    Object name = p1.getCar();
    while ((name instanceof SyntaxForm))
    {
      SyntaxForm nameSyntax = (SyntaxForm)name;
      templateScope = nameSyntax.getScope();
      name = nameSyntax.getDatum();
    }
    int options = ((Number)Translator.stripSyntax(p2.getCar())).intValue();
    boolean makePrivate = (options & 0x4) != 0;
    boolean makeConstant = (options & 0x8) != 0;
    boolean makeFluid = (options & 0x20) != 0;
    boolean makeCompoundProcedure = options == 27;
    
    name = tr.namespaceResolve(name);
    if (!(name instanceof gnu.mapping.Symbol))
    {
      tr.error('e', "'" + name + "' is not a valid identifier");
      name = null;
    }
    
    Object savePos = tr.pushPositionOf(p1);
    Declaration decl = tr.define(name, templateScope, defs);
    tr.popPositionOf(savePos);
    name = decl.getSymbol();
    if (makePrivate)
    {
      if (((defs instanceof ModuleExp)) && (defs.getFlag(4194304))) {
        tr.error('w', "'define-private' should not be used in interactive mode");
      } else {
        decl.setFlag(16777216L);
        decl.setPrivate(true);
      }
    }
    if (makeConstant)
      decl.setFlag(16384L);
    if ((options & 0x10) != 0)
      decl.setFlag(536870912L);
    decl.setFlag(262144L);
    Expression value;
    Expression value; if (((options & 0x2) != 0) && (!makeCompoundProcedure))
    {
      LambdaExp lexp = new LambdaExp();
      lexp.setSymbol(name);
      if (Compilation.inlineOk)
      {
        decl.setProcedureDecl(true);
        decl.setType(Compilation.typeProcedure);
        nameDecl = decl;
      }
      Translator.setLine(lexp, p1);
      value = lexp;
    }
    else {
      value = null; }
    SetExp sexp = new SetExp(decl, value);
    
    if (((defs instanceof ModuleExp)) && (!makePrivate) && (!makeConstant) && ((!Compilation.inlineOk) || (tr.sharedModuleDefs())))
    {
      decl.setCanWrite(true);
    }
    if (makeFluid) {
      decl.setSimple(false);
      decl.setPrivate(true);
      decl.setFlag(268435456L);
      decl.setCanRead(true);
      decl.setCanWrite(true);
      decl.setIndirectBinding(true);
      sexp.setSetIfUnbound(true);
    }
    
    if ((options & 0x1) != 0)
    {
      decl.setTypeExp(new LangExp(p3));
      decl.setFlag(8192L);
    }
    
    st = Translator.makePair(st, this, Translator.makePair(p1, sexp, p2));
    
    Translator.setLine(decl, p1);
    
    tr.pushForm(st);
  }
  
  public Expression rewriteForm(Pair form, Translator tr)
  {
    Pair p1 = (Pair)form.getCdr();
    Pair p2 = (Pair)p1.getCdr();
    Pair p3 = (Pair)p2.getCdr();
    Pair p4 = (Pair)p3.getCdr();
    Object name = p1.getCar();
    int options = ((Number)Translator.stripSyntax(p2.getCar())).intValue();
    boolean makePrivate = (options & 0x4) != 0;
    boolean makeFluid = (options & 0x20) != 0;
    boolean makeCompoundProcedure = options == 27;
    
    if (!(name instanceof SetExp))
      return tr.syntaxError(getName(options) + " is only allowed in a <body>");
    SetExp sexp = (SetExp)name;
    Declaration decl = sexp.getBinding();
    
    if (decl.getFlag(8192L))
    {
      Expression texp = decl.getTypeExp();
      if ((texp instanceof LangExp))
      {
        Pair typeSpecPair = (Pair)((LangExp)texp).getLangValue();
        decl.setType(tr.exp2Type(typeSpecPair));
      }
    }
    if ((makeFluid) && (Translator.stripSyntax(p4.getCar()) == gnu.expr.Special.undefined))
    {
      return QuoteExp.voidExp;
    }
    BeginExp bexp2 = null;
    boolean unknownValue;
    boolean unknownValue; if (((options & 0x2) != 0) && (!makeCompoundProcedure))
    {
      LambdaExp lexp = (LambdaExp)sexp.getNewValue();
      Object formals = p4.getCar();
      Object body = p4.getCdr();
      lambda.rewrite(lexp, formals, body, tr, null);
      unknownValue = !Compilation.inlineOk;
    }
    else
    {
      unknownValue = ((context instanceof ModuleExp)) && (!makePrivate) && (decl.getCanWrite());
      if (makeCompoundProcedure) {
        tr.letStart();
        ClassType classGenericProc = ClassType.make("gnu.expr.GenericProc");
        Declaration gproc = tr.letVariable(null, classGenericProc, new ApplyExp(Invoke.make, new Expression[] { QuoteExp.getInstance(classGenericProc), QuoteExp.getInstance(decl.getName()) }));
        





        gproc.setFlag(549755813888L);
        tr.letEnter();
        BeginExp bexp1 = new BeginExp();
        Method addMethod = classGenericProc.getDeclaredMethod("add", 1);
        Method setPropMethod = classGenericProc.getDeclaredMethod("setProperty", 2);
        for (;;)
        {
          Keyword key = null;
          Object car = Translator.stripSyntax(p4.getCar());
          if ((car instanceof Keyword)) {
            key = (Keyword)car;
            Object cdr = p4.getCdr();
            if ((!(cdr instanceof Pair)) || ((Translator.safeCar(cdr) instanceof Keyword)))
            {
              tr.error('e', "missing value following keyword");
              break;
            }
            p4 = (Pair)cdr;
          }
          Expression arg = tr.rewrite_car(p4, false);
          if (key != null) {
            if (bexp2 == null)
              bexp2 = new BeginExp();
            bexp2.add(new ApplyExp(setPropMethod, new Expression[] { new ReferenceExp(decl), QuoteExp.getInstance(key), arg }));

          }
          else
          {

            Declaration gdecl = (arg instanceof LambdaExp) ? gproc : decl;
            Expression addCall = new ApplyExp(addMethod, new Expression[] { new ReferenceExp(gdecl), arg });
            



            if ((arg instanceof LambdaExp)) {
              LambdaExp larg = (LambdaExp)arg;
              String lname = larg.getName();
              String dname = decl.getName();
              if ((lname == null) || (lname.equals(dname)))
              {

                if (decl.isPublic()) {
                  larg.setFlag(16384);
                }
              }
              







              bexp1.add(addCall);
            } else {
              if (bexp2 == null)
                bexp2 = new BeginExp();
              bexp2.add(addCall);
            }
          }
          Object cdr = p4.getCdr();
          if (!(cdr instanceof Pair)) {
            if (cdr == LList.Empty) break;
            tr.error('e', "not a proper list"); break;
          }
          
          p4 = (Pair)cdr;
        }
        ReferenceExp gref = new ReferenceExp(gproc);
        gref.setFlag(32);
        bexp1.add(gref);
        sexp.setNewValue(tr.letDone(BeginExp.canonicalize(bexp1)));
      } else {
        sexp.setNewValue(tr.rewrite_car(p4, false));
      } }
    if (unknownValue) {
      decl.noteValueUnknown();
    } else {
      decl.noteValueFromSet(sexp);
    }
    sexp.setDefining(true);
    if ((makePrivate) && (!(decl.getContext() instanceof ModuleExp)))
      tr.error('w', "define-private not at top level");
    if (bexp2 != null)
      return new BeginExp(sexp, bexp2);
    return sexp;
  }
}
