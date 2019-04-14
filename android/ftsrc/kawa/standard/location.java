package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Member;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.PrimProcedure;
import gnu.expr.ReferenceExp;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Pair;
import gnu.mapping.Location;
import gnu.mapping.LocationProc;
import gnu.mapping.ProcLocation;
import gnu.mapping.Procedure;
import kawa.lang.Translator;

public class location extends kawa.lang.Syntax
{
  public static final location location = new location();
  static { location.setName("location"); }
  
  public Expression rewrite(Object obj, Translator tr)
  {
    if (!(obj instanceof Pair))
      return tr.syntaxError("missing argument to location");
    Pair pair = (Pair)obj;
    if (pair.getCdr() != gnu.lists.LList.Empty)
      return tr.syntaxError("extra arguments to location");
    Expression[] args = { rewrite(tr.rewrite(pair.getCar()), tr) };
    return gnu.kawa.reflect.Invoke.makeInvokeStatic(thisType, "makeLocationProc", args);
  }
  
  private static ClassType thisType = ClassType.make("kawa.standard.location");
  private static PrimProcedure makeProcLocProc;
  
  public static Expression rewrite(Expression arg, Translator tr) {
    if ((arg instanceof ReferenceExp))
    {
      ReferenceExp rexp = (ReferenceExp)arg;
      rexp.setDontDereference(true);
      Declaration decl = rexp.getBinding();
      if (decl != null)
      {
        decl.maybeIndirectBinding(tr);
        decl = Declaration.followAliases(decl);
        decl.setCanRead(true);
        decl.setCanWrite(true);
      }
      return rexp;
    }
    if ((arg instanceof ApplyExp))
    {
      ApplyExp aexp = (ApplyExp)arg;
      Expression afunc = aexp.getFunction();
      Expression[] aargs = aexp.getArgs();
      int aalen = aargs.length;
      Object aproc = afunc.valueIfConstant();
      StaticFieldLocation sloc = null;
      
      if ((aproc == gnu.kawa.functions.GetNamedPart.getNamedPart) && (aalen == 2)) {
        Expression exp = rewriteApply(aargs[0], aargs[1], tr);
        if (exp != null)
          return exp;
      }
      if ((aproc == Scheme.applyToArgs) && (aalen == 3) && (aargs[0].valueIfConstant() == gnu.kawa.reflect.SlotGet.staticField))
      {
        Expression exp = rewriteApply(aargs[1], aargs[2], tr);
        if (exp != null)
          return exp;
      }
      Expression[] args = new Expression[aalen + 1];
      args[0] = afunc;
      System.arraycopy(aargs, 0, args, 1, aalen);
      return new ApplyExp(getMakeProcLocProc(), args);
    }
    return tr.syntaxError("invalid argument to location");
  }
  



  static Expression rewriteApply(Expression classExp, Expression nameExp, Compilation comp)
  {
    ClassType caller = curClass;
    Object cls = classExp.valueIfConstant();
    if ((cls instanceof Class))
      cls = gnu.bytecode.Type.make((Class)cls);
    Object nam = nameExp.valueIfConstant();
    if (((cls instanceof ClassType)) && ((nam instanceof gnu.mapping.SimpleSymbol))) {
      String name = nam.toString();
      ClassType ctype = (ClassType)cls;
      Member member = gnu.kawa.reflect.SlotGet.lookupMember(ctype, name, caller);
      if ((member != null) && (member.getStaticFlag())) {
        if ((member instanceof gnu.bytecode.Field)) {
          StaticFieldLocation sloc = new StaticFieldLocation(ctype, gnu.expr.Mangling.mangleNameIfNeeded(name));
          
          ReferenceExp rexp = new ReferenceExp(sloc.getDeclaration());
          rexp.setDontDereference(true);
          return rexp;
        }
        if ((member instanceof ClassType)) {
          ClassType cltype = (ClassType)member;
          if (cltype.isExisting()) {
            try {
              Class clas = cltype.getReflectClass();
              if (clas != null) {
                return new gnu.expr.QuoteExp(clas);
              }
            }
            catch (Exception ex) {}
          }
        }
      }
    }
    
    return null;
  }
  
  public static synchronized PrimProcedure getMakeProcLocProc()
  {
    if (makeProcLocProc == null) {
      makeProcLocProc = new PrimProcedure(ClassType.make("kawa.standard.location").getDeclaredMethod("makeProcLocation$V", 2));
    }
    return makeProcLocProc;
  }
  

  public static Location makeProcLocation$V(Procedure proc, Object[] args)
  {
    int nargs = args.length;
    if (((proc instanceof gnu.kawa.functions.ApplyToArgs)) && (nargs > 0) && ((args[0] instanceof Procedure)))
    {


      proc = (Procedure)args[0];
      if (((proc instanceof LocationProc)) && (nargs == 1))
        return ((LocationProc)proc).getLocation();
      Object[] rargs = new Object[nargs - 1];
      System.arraycopy(args, 1, rargs, 0, rargs.length);
      return new ProcLocation(proc, rargs);
    }
    if (((proc instanceof LocationProc)) && (nargs == 0))
      return ((LocationProc)proc).getLocation();
    return new ProcLocation(proc, args);
  }
  

  public static LocationProc makeLocationProc(Location loc)
  {
    return new LocationProc(loc);
  }
  
  public location() {}
}
