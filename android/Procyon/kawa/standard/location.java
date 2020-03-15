// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.mapping.ProcLocation;
import gnu.mapping.LocationProc;
import gnu.kawa.functions.ApplyToArgs;
import gnu.mapping.Location;
import gnu.bytecode.Member;
import gnu.expr.QuoteExp;
import gnu.expr.Mangling;
import gnu.bytecode.Field;
import gnu.bytecode.ObjectType;
import gnu.mapping.SimpleSymbol;
import gnu.bytecode.Type;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.mapping.Procedure;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.functions.GetNamedPart;
import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Compilation;
import gnu.expr.ReferenceExp;
import gnu.kawa.reflect.Invoke;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.expr.Expression;
import kawa.lang.Translator;
import gnu.expr.PrimProcedure;
import gnu.bytecode.ClassType;
import kawa.lang.Syntax;

public class location extends Syntax
{
    public static final location location;
    private static ClassType thisType;
    private static PrimProcedure makeProcLocProc;
    
    @Override
    public Expression rewrite(final Object obj, final Translator tr) {
        if (!(obj instanceof Pair)) {
            return tr.syntaxError("missing argument to location");
        }
        final Pair pair = (Pair)obj;
        if (pair.getCdr() != LList.Empty) {
            return tr.syntaxError("extra arguments to location");
        }
        final Expression[] array = { null };
        final int n = 0;
        final location location = kawa.standard.location.location;
        array[n] = rewrite(tr.rewrite(pair.getCar()), tr);
        final Expression[] args = array;
        return Invoke.makeInvokeStatic(kawa.standard.location.thisType, "makeLocationProc", args);
    }
    
    public static Expression rewrite(final Expression arg, final Translator tr) {
        if (arg instanceof ReferenceExp) {
            final ReferenceExp rexp = (ReferenceExp)arg;
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
            final ApplyExp aexp = (ApplyExp)arg;
            final Expression afunc = aexp.getFunction();
            final Expression[] aargs = aexp.getArgs();
            final int aalen = aargs.length;
            final Object aproc = afunc.valueIfConstant();
            final StaticFieldLocation sloc = null;
            if (aproc == GetNamedPart.getNamedPart && aalen == 2) {
                final Expression exp = rewriteApply(aargs[0], aargs[1], tr);
                if (exp != null) {
                    return exp;
                }
            }
            if (aproc == Scheme.applyToArgs && aalen == 3 && aargs[0].valueIfConstant() == SlotGet.staticField) {
                final Expression exp = rewriteApply(aargs[1], aargs[2], tr);
                if (exp != null) {
                    return exp;
                }
            }
            final Expression[] args = new Expression[aalen + 1];
            args[0] = afunc;
            System.arraycopy(aargs, 0, args, 1, aalen);
            return new ApplyExp(getMakeProcLocProc(), args);
        }
        return tr.syntaxError("invalid argument to location");
    }
    
    static Expression rewriteApply(final Expression classExp, final Expression nameExp, final Compilation comp) {
        final ClassType caller = comp.curClass;
        Object cls = classExp.valueIfConstant();
        if (cls instanceof Class) {
            cls = Type.make((Class)cls);
        }
        final Object nam = nameExp.valueIfConstant();
        if (cls instanceof ClassType && nam instanceof SimpleSymbol) {
            final String name = nam.toString();
            final ClassType ctype = (ClassType)cls;
            final Member member = SlotGet.lookupMember(ctype, name, caller);
            if (member != null && member.getStaticFlag()) {
                if (member instanceof Field) {
                    final StaticFieldLocation sloc = new StaticFieldLocation(ctype, Mangling.mangleNameIfNeeded(name));
                    final ReferenceExp rexp = new ReferenceExp(sloc.getDeclaration());
                    rexp.setDontDereference(true);
                    return rexp;
                }
                if (member instanceof ClassType) {
                    final ClassType cltype = (ClassType)member;
                    if (cltype.isExisting()) {
                        try {
                            final Class clas = cltype.getReflectClass();
                            if (clas != null) {
                                return new QuoteExp(clas);
                            }
                        }
                        catch (Exception ex) {}
                    }
                }
            }
        }
        return null;
    }
    
    public static synchronized PrimProcedure getMakeProcLocProc() {
        if (kawa.standard.location.makeProcLocProc == null) {
            kawa.standard.location.makeProcLocProc = new PrimProcedure(ClassType.make("kawa.standard.location").getDeclaredMethod("makeProcLocation$V", 2));
        }
        return kawa.standard.location.makeProcLocProc;
    }
    
    public static Location makeProcLocation$V(Procedure proc, final Object[] args) {
        final int nargs = args.length;
        if (proc instanceof ApplyToArgs && nargs > 0 && args[0] instanceof Procedure) {
            proc = (Procedure)args[0];
            if (proc instanceof LocationProc && nargs == 1) {
                return ((LocationProc)proc).getLocation();
            }
            final Object[] rargs = new Object[nargs - 1];
            System.arraycopy(args, 1, rargs, 0, rargs.length);
            return new ProcLocation(proc, rargs);
        }
        else {
            if (proc instanceof LocationProc && nargs == 0) {
                return ((LocationProc)proc).getLocation();
            }
            return new ProcLocation(proc, args);
        }
    }
    
    public static LocationProc makeLocationProc(final Location loc) {
        return new LocationProc(loc);
    }
    
    static {
        (location = new location()).setName("location");
        kawa.standard.location.thisType = ClassType.make("kawa.standard.location");
    }
}
