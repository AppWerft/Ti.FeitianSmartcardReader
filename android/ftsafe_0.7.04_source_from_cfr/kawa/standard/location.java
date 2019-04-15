/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.Mangling;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Location;
import gnu.mapping.LocationProc;
import gnu.mapping.ProcLocation;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import kawa.lang.Syntax;
import kawa.lang.Translator;
import kawa.standard.Scheme;

public class location
extends Syntax {
    public static final location location = new location();
    private static ClassType thisType;
    private static PrimProcedure makeProcLocProc;

    @Override
    public Expression rewrite(Object obj, Translator tr) {
        if (!(obj instanceof Pair)) {
            return tr.syntaxError("missing argument to location");
        }
        Pair pair = (Pair)obj;
        if (pair.getCdr() != LList.Empty) {
            return tr.syntaxError("extra arguments to location");
        }
        Expression[] args = new Expression[]{location.rewrite(tr.rewrite(pair.getCar()), tr)};
        return Invoke.makeInvokeStatic(thisType, "makeLocationProc", args);
    }

    public static Expression rewrite(Expression arg, Translator tr) {
        if (arg instanceof ReferenceExp) {
            ReferenceExp rexp = (ReferenceExp)arg;
            rexp.setDontDereference(true);
            Declaration decl = rexp.getBinding();
            if (decl != null) {
                decl.maybeIndirectBinding(tr);
                decl = Declaration.followAliases(decl);
                decl.setCanRead(true);
                decl.setCanWrite(true);
            }
            return rexp;
        }
        if (arg instanceof ApplyExp) {
            Expression exp;
            ApplyExp aexp = (ApplyExp)arg;
            Expression afunc = aexp.getFunction();
            Expression[] aargs = aexp.getArgs();
            int aalen = aargs.length;
            Object aproc = afunc.valueIfConstant();
            Object sloc = null;
            if (aproc == GetNamedPart.getNamedPart && aalen == 2 && (exp = location.rewriteApply(aargs[0], aargs[1], tr)) != null) {
                return exp;
            }
            if (aproc == Scheme.applyToArgs && aalen == 3 && aargs[0].valueIfConstant() == SlotGet.staticField && (exp = location.rewriteApply(aargs[1], aargs[2], tr)) != null) {
                return exp;
            }
            Expression[] args = new Expression[aalen + 1];
            args[0] = afunc;
            System.arraycopy(aargs, 0, args, 1, aalen);
            return new ApplyExp(location.getMakeProcLocProc(), args);
        }
        return tr.syntaxError("invalid argument to location");
    }

    static Expression rewriteApply(Expression classExp, Expression nameExp, Compilation comp) {
        String name;
        Member member;
        ClassType ctype;
        ClassType caller = comp.curClass;
        Object cls = classExp.valueIfConstant();
        if (cls instanceof Class) {
            cls = Type.make((Class)cls);
        }
        Object nam = nameExp.valueIfConstant();
        if (cls instanceof ClassType && nam instanceof SimpleSymbol && (member = SlotGet.lookupMember(ctype = (ClassType)cls, name = nam.toString(), caller)) != null && member.getStaticFlag()) {
            ClassType cltype;
            if (member instanceof Field) {
                StaticFieldLocation sloc = new StaticFieldLocation(ctype, Mangling.mangleNameIfNeeded(name));
                ReferenceExp rexp = new ReferenceExp(sloc.getDeclaration());
                rexp.setDontDereference(true);
                return rexp;
            }
            if (member instanceof ClassType && (cltype = (ClassType)member).isExisting()) {
                try {
                    Class clas = cltype.getReflectClass();
                    if (clas != null) {
                        return new QuoteExp(clas);
                    }
                }
                catch (Exception ex) {
                    // empty catch block
                }
            }
        }
        return null;
    }

    public static synchronized PrimProcedure getMakeProcLocProc() {
        if (makeProcLocProc == null) {
            makeProcLocProc = new PrimProcedure(ClassType.make("kawa.standard.location").getDeclaredMethod("makeProcLocation$V", 2));
        }
        return makeProcLocProc;
    }

    public static Location makeProcLocation$V(Procedure proc, Object[] args) {
        int nargs = args.length;
        if (proc instanceof ApplyToArgs && nargs > 0 && args[0] instanceof Procedure) {
            proc = (Procedure)args[0];
            if (proc instanceof LocationProc && nargs == 1) {
                return ((LocationProc)proc).getLocation();
            }
            Object[] rargs = new Object[nargs - 1];
            System.arraycopy(args, 1, rargs, 0, rargs.length);
            return new ProcLocation(proc, rargs);
        }
        if (proc instanceof LocationProc && nargs == 0) {
            return ((LocationProc)proc).getLocation();
        }
        return new ProcLocation(proc, args);
    }

    public static LocationProc makeLocationProc(Location loc) {
        return new LocationProc(loc);
    }

    static {
        location.setName("location");
        thisType = ClassType.make("kawa.standard.location");
    }
}

