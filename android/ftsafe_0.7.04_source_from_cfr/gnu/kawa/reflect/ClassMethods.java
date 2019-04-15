/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Filter;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ParameterizedType;
import gnu.bytecode.Type;
import gnu.bytecode.TypeVariable;
import gnu.expr.Expression;
import gnu.expr.GenericProc;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.kawa.reflect.MethodFilter;
import gnu.lists.FString;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import java.util.ArrayList;
import java.util.List;

public class ClassMethods
extends Procedure2 {
    public static final ClassMethods classMethods = new ClassMethods();

    @Override
    public Object apply2(Object arg0, Object arg1) {
        return ClassMethods.apply(this, arg0, arg1);
    }

    public static MethodProc apply(Procedure thisProc, Object arg0, Object arg1) {
        ClassType dtype;
        MethodProc result;
        if (arg0 instanceof Class) {
            arg0 = Type.make((Class)arg0);
        }
        if (arg0 instanceof ClassType) {
            dtype = (ClassType)arg0;
        } else if (arg0 instanceof String || arg0 instanceof FString || arg0 instanceof Symbol) {
            dtype = ClassType.make(arg0.toString());
        } else {
            throw new WrongType(thisProc, 0, null);
        }
        if (!(arg1 instanceof String || arg1 instanceof FString || arg1 instanceof Symbol)) {
            throw new WrongType(thisProc, 1, null);
        }
        String mname = arg1.toString();
        if (!"<init>".equals(mname)) {
            mname = Mangling.mangleName(mname);
        }
        if ((result = ClassMethods.apply(dtype, mname, '\u0000', Language.getDefaultLanguage())) == null) {
            throw new RuntimeException("no applicable method named `" + mname + "' in " + dtype.getName());
        }
        return result;
    }

    private static int removeRedundantMethods(List<Method> methods) {
        int mlength = methods.size();
        int i = 1;
        block0 : while (i < mlength) {
            Method method1 = methods.get(i);
            ClassType class1 = method1.getDeclaringClass();
            Type[] types1 = method1.getParameterTypes();
            int tlen = types1.length;
            for (int j = 0; j < i; ++j) {
                Method method2 = methods.get(j);
                Type[] types2 = method2.getParameterTypes();
                if (tlen != types2.length) continue;
                int k = tlen;
                while (--k >= 0) {
                    Type pt1 = types1[k];
                    Type pt2 = types2[k];
                    if (pt1 instanceof TypeVariable) {
                        pt1 = ((TypeVariable)pt1).getRawType();
                    }
                    if (pt2 instanceof TypeVariable) {
                        pt2 = ((TypeVariable)pt2).getRawType();
                    }
                    if (Type.isSame(pt1, pt2)) continue;
                    break;
                }
                if (k >= 0) continue;
                if (class1.isSubtype(method2.getDeclaringClass())) {
                    methods.set(j, method1);
                }
                methods.set(i, methods.get(mlength - 1));
                --mlength;
                continue block0;
            }
            ++i;
        }
        return mlength;
    }

    public static PrimProcedure[] getMethods(ObjectType dtype, String mname, char mode, ClassType caller, Language language) {
        ObjectType rtype;
        ParameterizedType ptype;
        if (dtype == Type.tostring_type) {
            dtype = Type.string_type;
        }
        MethodFilter filter = new MethodFilter(mname, 0, 0, caller, mode == 'P' ? null : dtype);
        boolean named_class_only = mode == 'P' || "<init>".equals(mname);
        ArrayList<Method> methods = new ArrayList<Method>();
        if (dtype instanceof ParameterizedType) {
            ptype = (ParameterizedType)dtype;
            rtype = ptype.getRawType();
        } else {
            ptype = null;
            rtype = dtype;
        }
        rtype.getMethods(filter, named_class_only ? 0 : 2, methods);
        if (!(named_class_only || dtype instanceof ClassType && !dtype.isInterface())) {
            Type.pointer_type.getMethods(filter, 0, methods);
        }
        int mlength = named_class_only ? methods.size() : ClassMethods.removeRedundantMethods(methods);
        PrimProcedure[] result = new PrimProcedure[mlength];
        int count = 0;
        int i = mlength;
        while (--i >= 0) {
            ClassType mdclass;
            Type itype;
            Method method = methods.get(i);
            PrimProcedure pproc = new PrimProcedure(method, mode, language, ptype);
            if (!(named_class_only || (mdclass = method.getDeclaringClass()) == dtype || !((itype = dtype.getImplementationType()) instanceof ClassType) || ((ClassType)itype).isInterface() && mdclass == Type.objectType)) {
                pproc.setMethodForInvoke(new Method(method, (ClassType)itype));
            }
            result[count++] = pproc;
        }
        return result;
    }

    public static long selectApplicable(PrimProcedure[] methods, Type[] atypes, Type restType) {
        int limit = methods.length;
        int numDefApplicable = 0;
        int numPosApplicable = 0;
        int i = 0;
        while (i < limit) {
            PrimProcedure tmp;
            int code = methods[i].isApplicable(atypes, restType);
            if (code < 0) {
                tmp = methods[limit - 1];
                methods[limit - 1] = methods[i];
                methods[i] = tmp;
                --limit;
                continue;
            }
            if (code > 0) {
                tmp = methods[numDefApplicable];
                methods[numDefApplicable] = methods[i];
                methods[i] = tmp;
                ++numDefApplicable;
                ++i;
                continue;
            }
            ++numPosApplicable;
            ++i;
        }
        return ((long)numDefApplicable << 32) + (long)numPosApplicable;
    }

    public static int selectApplicable(PrimProcedure[] methods, int numArgs, boolean maybeMore) {
        int limit = methods.length;
        int numTooManyArgs = 0;
        int numTooFewArgs = 0;
        int numOk = 0;
        int i = 0;
        while (i < limit) {
            int num = methods[i].numArgs();
            int min = Procedure.minArgs(num);
            int max = Procedure.maxArgs(num);
            boolean ok = false;
            if (numArgs < min && !maybeMore) {
                ++numTooFewArgs;
            } else if (numArgs > max && max >= 0) {
                ++numTooManyArgs;
            } else {
                ok = true;
            }
            if (ok) {
                ++numOk;
                ++i;
                continue;
            }
            PrimProcedure tmp = methods[limit - 1];
            methods[limit - 1] = methods[i];
            methods[i] = tmp;
            --limit;
        }
        return numOk > 0 ? numOk : (numTooFewArgs > 0 ? -983040 : (numTooManyArgs > 0 ? -917504 : 0));
    }

    public static MethodProc apply(ObjectType dtype, String mname, char mode, Language language) {
        PrimProcedure[] methods = ClassMethods.getMethods(dtype, mname, mode, null, language);
        GenericProc gproc = null;
        PrimProcedure pproc = null;
        for (int i = 0; i < methods.length; ++i) {
            PrimProcedure cur = methods[i];
            if (pproc != null && gproc == null) {
                gproc = new GenericProc();
                gproc.add(pproc);
            }
            pproc = cur;
            if (gproc == null) continue;
            gproc.add(pproc);
        }
        if (gproc != null) {
            gproc.setName(dtype.getName() + "." + mname);
            return gproc;
        }
        return pproc;
    }

    static String checkName(Expression exp, boolean reversible) {
        if (exp instanceof QuoteExp) {
            String nam;
            Object name = ((QuoteExp)exp).getValue();
            if (name instanceof FString || name instanceof String) {
                nam = name.toString();
            } else if (name instanceof Symbol) {
                nam = ((Symbol)name).getName();
            } else {
                return null;
            }
            if (Language.isValidJavaName(nam)) {
                return nam;
            }
            return Mangling.mangleName(nam, reversible);
        }
        return null;
    }

    static String checkName(Expression exp) {
        if (exp instanceof QuoteExp) {
            Object name = ((QuoteExp)exp).getValue();
            if (name instanceof FString || name instanceof String) {
                return name.toString();
            }
            if (name instanceof Symbol) {
                return ((Symbol)name).getName();
            }
            return null;
        }
        return null;
    }

    static {
        classMethods.setName("class-methods");
    }
}

