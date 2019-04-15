/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.PairClassType;
import gnu.expr.PrimProcedure;
import gnu.expr.TypeValue;
import gnu.kawa.lispexpr.ClassNamespace;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.CompileInvoke;
import gnu.kawa.reflect.SlotSet;
import gnu.lists.FString;
import gnu.lists.FVector;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import java.lang.reflect.Array;

public class Invoke
extends ProcedureN {
    char kind;
    Language language;
    public static final Invoke invoke = new Invoke("invoke", '*');
    public static final Invoke invokeStatic = new Invoke("invoke-static", 'S');
    public static final Invoke invokeSpecial = new Invoke("invoke-special", 'P');
    public static final Invoke make = new Invoke("make", 'N');

    public Invoke(String name, char kind) {
        this(name, kind, Language.getDefaultLanguage());
    }

    public Invoke(String name, char kind, Language language) {
        super(name);
        this.kind = kind;
        this.language = language;
        this.setProperty(Procedure.validateXApplyKey, "gnu.kawa.reflect.CompileInvoke:validateApplyInvoke");
    }

    public static Object invoke$V(Object[] args) throws Throwable {
        return invoke.applyN(args);
    }

    public static Object invokeStatic$V(Object[] args) throws Throwable {
        return invokeStatic.applyN(args);
    }

    public static Object make$V(Object[] args) throws Throwable {
        return make.applyN(args);
    }

    private static ObjectType typeFrom(Object arg, Invoke thisProc) {
        if (arg instanceof Class) {
            arg = Type.make((Class)arg);
        }
        if (arg instanceof ObjectType) {
            return (ObjectType)arg;
        }
        if (arg instanceof String || arg instanceof FString) {
            return ClassType.make(arg.toString());
        }
        if (arg instanceof Symbol) {
            return ClassType.make(((Symbol)arg).getName());
        }
        if (arg instanceof ClassNamespace) {
            return ((ClassNamespace)arg).getClassType();
        }
        throw new WrongType((Procedure)thisProc, 0, arg, "class-specifier");
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        Object[] args = ctx.getArgs();
        if (this.kind == 'S' || this.kind == 'V' || this.kind == 's' || this.kind == '*') {
            int nargs = args.length;
            Procedure.checkArgCount(this, nargs);
            Object arg0 = args[0];
            ObjectType dtype = this.kind == 'S' || this.kind == 's' ? Invoke.typeFrom(arg0, this) : Type.make(arg0.getClass());
            MethodProc proc = this.lookupMethods(dtype, args[1]);
            Object[] margs = new Object[nargs - (this.kind == 'S' ? 2 : 1)];
            int i = 0;
            if (this.kind == 'V' || this.kind == '*') {
                margs[i++] = args[0];
            }
            System.arraycopy(args, 2, margs, i, nargs - 2);
            proc.checkN(margs, ctx);
        } else {
            ctx.writeValue(this.applyN(args));
        }
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        Object result;
        Object mname;
        Object arg;
        int keywordStart;
        ObjectType dtype;
        if (this.kind == 'P') {
            throw new RuntimeException(this.getName() + ": invoke-special not allowed at run time");
        }
        int nargs = args.length;
        Procedure.checkArgCount(this, nargs);
        Object arg0 = args[0];
        ObjectType objectType = dtype = this.kind != 'V' && this.kind != '*' ? Invoke.typeFrom(arg0, this) : (ObjectType)Type.make(arg0.getClass());
        if (this.kind == 'N') {
            Procedure constructor;
            mname = null;
            if (dtype instanceof TypeValue && (constructor = ((TypeValue)((Object)dtype)).getConstructor()) != null) {
                Object[] xargs = new Object[--nargs];
                System.arraycopy(args, 1, xargs, 0, nargs);
                return constructor.applyN(xargs);
            }
            if (dtype instanceof PairClassType) {
                PairClassType ptype = (PairClassType)dtype;
                dtype = ptype.instanceType;
            }
            if (dtype instanceof ArrayType || dtype == LangObjType.constVectorType) {
                String name;
                boolean lengthSpecified;
                int length;
                int i;
                int len = args.length - 1;
                if (len >= 2 && args[1] instanceof Keyword && ("length".equals(name = ((Keyword)args[1]).getName()) || "size".equals(name))) {
                    length = ((Number)args[2]).intValue();
                    i = 3;
                    lengthSpecified = true;
                } else {
                    length = len;
                    i = 1;
                    lengthSpecified = false;
                }
                ClassType elementType = dtype == LangObjType.constVectorType ? Type.objectType : ((ArrayType)dtype).getComponentType();
                Object arr = Array.newInstance(((Type)elementType).getReflectClass(), length);
                int index = 0;
                while (i <= len) {
                    Object arg2 = args[i];
                    if (lengthSpecified && arg2 instanceof Keyword && i < len) {
                        String kname = ((Keyword)arg2).getName();
                        try {
                            index = Integer.parseInt(kname);
                        }
                        catch (Exception ex) {
                            throw new RuntimeException("non-integer keyword '" + kname + "' in array constructor");
                        }
                        arg2 = args[++i];
                    }
                    Array.set(arr, index, ((Type)elementType).coerceFromObject(arg2));
                    ++index;
                    ++i;
                }
                if (dtype == LangObjType.constVectorType) {
                    return FVector.makeConstant((Object[])arr);
                }
                return arr;
            }
        } else {
            mname = args[1];
        }
        MethodProc proc = this.lookupMethods(dtype, mname);
        if (this.kind != 'N') {
            Object[] margs = new Object[nargs - (this.kind == 'S' || this.kind == 's' ? 2 : 1)];
            int i = 0;
            if (this.kind == 'V' || this.kind == '*') {
                margs[i++] = args[0];
            }
            System.arraycopy(args, 2, margs, i, nargs - 2);
            return proc.applyN(margs);
        }
        CallContext vars = CallContext.getInstance();
        for (keywordStart = 0; keywordStart < args.length && !(args[keywordStart] instanceof Keyword); ++keywordStart) {
        }
        int err = -1;
        if (keywordStart == args.length) {
            err = proc.matchN(args, vars);
            if (err == 0) {
                return vars.runUntilValue();
            }
            MethodProc vproc = ClassMethods.apply(dtype, "valueOf", '\u0000', this.language);
            if (vproc != null) {
                Object[] margs = new Object[nargs - 1];
                System.arraycopy(args, 1, margs, 0, nargs - 1);
                err = vproc.matchN(margs, vars);
                if (err == 0) {
                    return vars.runUntilValue();
                }
            }
            result = proc.apply1(args[0]);
        } else {
            Object[] cargs = new Object[keywordStart];
            System.arraycopy(args, 0, cargs, 0, keywordStart);
            result = proc.applyN(cargs);
        }
        int i = keywordStart;
        while (i + 1 < args.length && (arg = args[i]) instanceof Keyword) {
            Keyword key = (Keyword)arg;
            arg = args[i + 1];
            SlotSet.apply(false, result, key.getName(), arg);
            i += 2;
        }
        if (keywordStart == args.length) {
            i = 1;
        }
        if (i != args.length) {
            MethodProc aproc = ClassMethods.apply(dtype, "add", '\u0000', this.language);
            if (aproc == null) {
                throw MethodProc.matchFailAsException(err, proc, args);
            }
            while (i < args.length) {
                aproc.apply2(result, args[i++]);
            }
        }
        return result;
    }

    @Override
    public int numArgs() {
        return -4096 | (this.kind == 'N' ? 1 : 2);
    }

    protected MethodProc lookupMethods(ObjectType dtype, Object name) {
        String mname;
        if (this.kind == 'N') {
            mname = "<init>";
        } else {
            if (name instanceof CharSequence) {
                mname = name.toString();
            } else if (name instanceof Symbol) {
                mname = ((Symbol)name).getName();
            } else {
                throw new WrongType((Procedure)this, 1, name, "string-or-symbol");
            }
            mname = Mangling.mangleName(mname);
        }
        MethodProc proc = ClassMethods.apply(dtype, mname, (char)(this.kind == 'P' ? 80 : (this.kind == '*' || this.kind == 'V' ? 86 : 0)), this.language);
        if (proc == null) {
            throw new RuntimeException(this.getName() + ": no method named `" + mname + "' in class " + dtype.getName());
        }
        return proc;
    }

    public static synchronized /* varargs */ ApplyExp makeInvokeStatic(ClassType type, String name, Expression ... args) {
        PrimProcedure method = Invoke.getStaticMethod(type, name, args);
        if (method == null) {
            throw new RuntimeException("missing or ambiguous method `" + name + "' in " + type.getName());
        }
        return new ApplyExp(method, args);
    }

    @Deprecated
    public static synchronized PrimProcedure getStaticMethod(ClassType type, String name, Expression[] args) {
        return CompileInvoke.getStaticMethod(type, name, args);
    }
}

