// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.expr.QuoteExp;
import gnu.expr.Expression;
import gnu.expr.GenericProc;
import gnu.bytecode.Filter;
import gnu.bytecode.ParameterizedType;
import java.util.ArrayList;
import gnu.expr.PrimProcedure;
import gnu.bytecode.TypeVariable;
import gnu.bytecode.Method;
import java.util.List;
import gnu.bytecode.ObjectType;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.mapping.WrongType;
import gnu.mapping.Symbol;
import gnu.lists.FString;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;

public class ClassMethods extends Procedure2
{
    public static final ClassMethods classMethods;
    
    @Override
    public Object apply2(final Object arg0, final Object arg1) {
        return apply(this, arg0, arg1);
    }
    
    public static MethodProc apply(final Procedure thisProc, Object arg0, final Object arg1) {
        if (arg0 instanceof Class) {
            arg0 = Type.make((Class)arg0);
        }
        ClassType dtype;
        if (arg0 instanceof ClassType) {
            dtype = (ClassType)arg0;
        }
        else {
            if (!(arg0 instanceof String) && !(arg0 instanceof FString) && !(arg0 instanceof Symbol)) {
                throw new WrongType(thisProc, 0, null);
            }
            dtype = ClassType.make(arg0.toString());
        }
        if (!(arg1 instanceof String) && !(arg1 instanceof FString) && !(arg1 instanceof Symbol)) {
            throw new WrongType(thisProc, 1, null);
        }
        String mname = arg1.toString();
        if (!"<init>".equals(mname)) {
            mname = Mangling.mangleName(mname);
        }
        final MethodProc result = apply(dtype, mname, '\0', Language.getDefaultLanguage());
        if (result == null) {
            throw new RuntimeException("no applicable method named `" + mname + "' in " + dtype.getName());
        }
        return result;
    }
    
    private static int removeRedundantMethods(final List<Method> methods) {
        int mlength = methods.size();
        int i = 1;
    Label_0009:
        while (i < mlength) {
            final Method method1 = methods.get(i);
            final ClassType class1 = method1.getDeclaringClass();
            final Type[] types1 = method1.getParameterTypes();
            final int tlen = types1.length;
            for (int j = 0; j < i; ++j) {
                final Method method2 = methods.get(j);
                final Type[] types2 = method2.getParameterTypes();
                if (tlen == types2.length) {
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
                        if (!Type.isSame(pt1, pt2)) {
                            break;
                        }
                    }
                    if (k < 0) {
                        if (class1.isSubtype(method2.getDeclaringClass())) {
                            methods.set(j, method1);
                        }
                        methods.set(i, methods.get(mlength - 1));
                        --mlength;
                        continue Label_0009;
                    }
                }
            }
            ++i;
        }
        return mlength;
    }
    
    public static PrimProcedure[] getMethods(ObjectType dtype, final String mname, final char mode, final ClassType caller, final Language language) {
        if (dtype == Type.tostring_type) {
            dtype = Type.string_type;
        }
        final MethodFilter filter = new MethodFilter(mname, 0, 0, caller, (mode == 'P') ? null : dtype);
        final boolean named_class_only = mode == 'P' || "<init>".equals(mname);
        final ArrayList<Method> methods = new ArrayList<Method>();
        ParameterizedType ptype;
        ObjectType rtype;
        if (dtype instanceof ParameterizedType) {
            ptype = (ParameterizedType)dtype;
            rtype = ptype.getRawType();
        }
        else {
            ptype = null;
            rtype = dtype;
        }
        rtype.getMethods(filter, named_class_only ? 0 : 2, methods);
        if (!named_class_only && (!(dtype instanceof ClassType) || dtype.isInterface())) {
            Type.pointer_type.getMethods(filter, 0, methods);
        }
        final int mlength = named_class_only ? methods.size() : removeRedundantMethods(methods);
        final PrimProcedure[] result = new PrimProcedure[mlength];
        int count = 0;
        int i = mlength;
        while (--i >= 0) {
            final Method method = methods.get(i);
            final PrimProcedure pproc = new PrimProcedure(method, mode, language, ptype);
            if (!named_class_only) {
                final ClassType mdclass = method.getDeclaringClass();
                if (mdclass != dtype) {
                    final Type itype = dtype.getImplementationType();
                    if (itype instanceof ClassType && (!((ClassType)itype).isInterface() || mdclass != Type.objectType)) {
                        pproc.setMethodForInvoke(new Method(method, (ClassType)itype));
                    }
                }
            }
            result[count++] = pproc;
        }
        return result;
    }
    
    public static long selectApplicable(final PrimProcedure[] methods, final Type[] atypes, final Type restType) {
        int limit = methods.length;
        int numDefApplicable = 0;
        int numPosApplicable = 0;
        int i = 0;
        while (i < limit) {
            final int code = methods[i].isApplicable(atypes, restType);
            if (code < 0) {
                final PrimProcedure tmp = methods[limit - 1];
                methods[limit - 1] = methods[i];
                methods[i] = tmp;
                --limit;
            }
            else if (code > 0) {
                final PrimProcedure tmp = methods[numDefApplicable];
                methods[numDefApplicable] = methods[i];
                methods[i] = tmp;
                ++numDefApplicable;
                ++i;
            }
            else {
                ++numPosApplicable;
                ++i;
            }
        }
        return ((long)numDefApplicable << 32) + numPosApplicable;
    }
    
    public static int selectApplicable(final PrimProcedure[] methods, final int numArgs, final boolean maybeMore) {
        int limit = methods.length;
        int numTooManyArgs = 0;
        int numTooFewArgs = 0;
        int numOk = 0;
        int i = 0;
        while (i < limit) {
            final int num = methods[i].numArgs();
            final int min = Procedure.minArgs(num);
            final int max = Procedure.maxArgs(num);
            boolean ok = false;
            if (numArgs < min && !maybeMore) {
                ++numTooFewArgs;
            }
            else if (numArgs > max && max >= 0) {
                ++numTooManyArgs;
            }
            else {
                ok = true;
            }
            if (ok) {
                ++numOk;
                ++i;
            }
            else {
                final PrimProcedure tmp = methods[limit - 1];
                methods[limit - 1] = methods[i];
                methods[i] = tmp;
                --limit;
            }
        }
        return (numOk > 0) ? numOk : ((numTooFewArgs > 0) ? -983040 : ((numTooManyArgs > 0) ? -917504 : 0));
    }
    
    public static MethodProc apply(final ObjectType dtype, final String mname, final char mode, final Language language) {
        final PrimProcedure[] methods = getMethods(dtype, mname, mode, null, language);
        GenericProc gproc = null;
        PrimProcedure pproc = null;
        for (int i = 0; i < methods.length; ++i) {
            final PrimProcedure cur = methods[i];
            if (pproc != null && gproc == null) {
                gproc = new GenericProc();
                gproc.add(pproc);
            }
            pproc = cur;
            if (gproc != null) {
                gproc.add(pproc);
            }
        }
        if (gproc != null) {
            gproc.setName(dtype.getName() + "." + mname);
            return gproc;
        }
        return pproc;
    }
    
    static String checkName(final Expression exp, final boolean reversible) {
        if (!(exp instanceof QuoteExp)) {
            return null;
        }
        final Object name = ((QuoteExp)exp).getValue();
        String nam;
        if (name instanceof FString || name instanceof String) {
            nam = name.toString();
        }
        else {
            if (!(name instanceof Symbol)) {
                return null;
            }
            nam = ((Symbol)name).getName();
        }
        if (Language.isValidJavaName(nam)) {
            return nam;
        }
        return Mangling.mangleName(nam, reversible);
    }
    
    static String checkName(final Expression exp) {
        if (!(exp instanceof QuoteExp)) {
            return null;
        }
        final Object name = ((QuoteExp)exp).getValue();
        if (name instanceof FString || name instanceof String) {
            return name.toString();
        }
        if (name instanceof Symbol) {
            return ((Symbol)name).getName();
        }
        return null;
    }
    
    static {
        (classMethods = new ClassMethods()).setName("class-methods");
    }
}
