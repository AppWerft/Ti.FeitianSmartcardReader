// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.expr.PrimProcedure;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.Mangling;
import gnu.mapping.MethodProc;
import gnu.lists.FVector;
import java.lang.reflect.Array;
import gnu.expr.Keyword;
import gnu.kawa.lispexpr.LangObjType;
import gnu.bytecode.ArrayType;
import gnu.expr.PairClassType;
import gnu.expr.TypeValue;
import gnu.mapping.CallContext;
import gnu.mapping.WrongType;
import gnu.kawa.lispexpr.ClassNamespace;
import gnu.mapping.Symbol;
import gnu.bytecode.ClassType;
import gnu.lists.FString;
import gnu.bytecode.Type;
import gnu.bytecode.ObjectType;
import gnu.mapping.Procedure;
import gnu.expr.Language;
import gnu.mapping.ProcedureN;

public class Invoke extends ProcedureN
{
    char kind;
    Language language;
    public static final Invoke invoke;
    public static final Invoke invokeStatic;
    public static final Invoke invokeSpecial;
    public static final Invoke make;
    
    public Invoke(final String name, final char kind) {
        this(name, kind, Language.getDefaultLanguage());
    }
    
    public Invoke(final String name, final char kind, final Language language) {
        super(name);
        this.kind = kind;
        this.language = language;
        this.setProperty(Procedure.validateXApplyKey, "gnu.kawa.reflect.CompileInvoke:validateApplyInvoke");
    }
    
    public static Object invoke$V(final Object[] args) throws Throwable {
        return Invoke.invoke.applyN(args);
    }
    
    public static Object invokeStatic$V(final Object[] args) throws Throwable {
        return Invoke.invokeStatic.applyN(args);
    }
    
    public static Object make$V(final Object[] args) throws Throwable {
        return Invoke.make.applyN(args);
    }
    
    private static ObjectType typeFrom(Object arg, final Invoke thisProc) {
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
        throw new WrongType(thisProc, 0, arg, "class-specifier");
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        final Object[] args = ctx.getArgs();
        if (this.kind == 'S' || this.kind == 'V' || this.kind == 's' || this.kind == '*') {
            final int nargs = args.length;
            Procedure.checkArgCount(this, nargs);
            final Object arg0 = args[0];
            final ObjectType dtype = (ObjectType)((this.kind == 'S' || this.kind == 's') ? typeFrom(arg0, this) : Type.make(arg0.getClass()));
            final Procedure proc = this.lookupMethods(dtype, args[1]);
            final Object[] margs = new Object[nargs - ((this.kind == 'S') ? 2 : 1)];
            int i = 0;
            if (this.kind == 'V' || this.kind == '*') {
                margs[i++] = args[0];
            }
            System.arraycopy(args, 2, margs, i, nargs - 2);
            proc.checkN(margs, ctx);
        }
        else {
            ctx.writeValue(this.applyN(args));
        }
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        if (this.kind == 'P') {
            throw new RuntimeException(this.getName() + ": invoke-special not allowed at run time");
        }
        int nargs = args.length;
        Procedure.checkArgCount(this, nargs);
        final Object arg0 = args[0];
        ObjectType dtype = (ObjectType)((this.kind != 'V' && this.kind != '*') ? typeFrom(arg0, this) : Type.make(arg0.getClass()));
        Object mname;
        if (this.kind == 'N') {
            mname = null;
            if (dtype instanceof TypeValue) {
                final Procedure constructor = ((TypeValue)dtype).getConstructor();
                if (constructor != null) {
                    final Object[] xargs = new Object[--nargs];
                    System.arraycopy(args, 1, xargs, 0, nargs);
                    return constructor.applyN(xargs);
                }
            }
            if (dtype instanceof PairClassType) {
                final PairClassType ptype = (PairClassType)dtype;
                dtype = ptype.instanceType;
            }
            if (dtype instanceof ArrayType || dtype == LangObjType.constVectorType) {
                final int len = args.length - 1;
                final String name;
                int length;
                int i;
                boolean lengthSpecified;
                if (len >= 2 && args[1] instanceof Keyword && ("length".equals(name = ((Keyword)args[1]).getName()) || "size".equals(name))) {
                    length = ((Number)args[2]).intValue();
                    i = 3;
                    lengthSpecified = true;
                }
                else {
                    length = len;
                    i = 1;
                    lengthSpecified = false;
                }
                final Type elementType = (dtype == LangObjType.constVectorType) ? Type.objectType : ((ArrayType)dtype).getComponentType();
                final Object arr = Array.newInstance(elementType.getReflectClass(), length);
                int index = 0;
                while (i <= len) {
                    Object arg2 = args[i];
                    if (lengthSpecified && arg2 instanceof Keyword && i < len) {
                        final String kname = ((Keyword)arg2).getName();
                        try {
                            index = Integer.parseInt(kname);
                        }
                        catch (Exception ex) {
                            throw new RuntimeException("non-integer keyword '" + kname + "' in array constructor");
                        }
                        arg2 = args[++i];
                    }
                    Array.set(arr, index, elementType.coerceFromObject(arg2));
                    ++index;
                    ++i;
                }
                if (dtype == LangObjType.constVectorType) {
                    return FVector.makeConstant((Object[])arr);
                }
                return arr;
            }
        }
        else {
            mname = args[1];
        }
        final MethodProc proc = this.lookupMethods(dtype, mname);
        if (this.kind != 'N') {
            final Object[] margs = new Object[nargs - ((this.kind == 'S' || this.kind == 's') ? 2 : 1)];
            int j = 0;
            if (this.kind == 'V' || this.kind == '*') {
                margs[j++] = args[0];
            }
            System.arraycopy(args, 2, margs, j, nargs - 2);
            return proc.applyN(margs);
        }
        final CallContext vars = CallContext.getInstance();
        int keywordStart;
        for (keywordStart = 0; keywordStart < args.length && !(args[keywordStart] instanceof Keyword); ++keywordStart) {}
        int err = -1;
        Object result;
        if (keywordStart == args.length) {
            err = proc.matchN(args, vars);
            if (err == 0) {
                return vars.runUntilValue();
            }
            final MethodProc vproc = ClassMethods.apply(dtype, "valueOf", '\0', this.language);
            if (vproc != null) {
                final Object[] margs2 = new Object[nargs - 1];
                System.arraycopy(args, 1, margs2, 0, nargs - 1);
                err = vproc.matchN(margs2, vars);
                if (err == 0) {
                    return vars.runUntilValue();
                }
            }
            result = proc.apply1(args[0]);
        }
        else {
            final Object[] cargs = new Object[keywordStart];
            System.arraycopy(args, 0, cargs, 0, keywordStart);
            result = proc.applyN(cargs);
        }
        int k;
        for (k = keywordStart; k + 1 < args.length; k += 2) {
            Object arg3 = args[k];
            if (!(arg3 instanceof Keyword)) {
                break;
            }
            final Keyword key = (Keyword)arg3;
            arg3 = args[k + 1];
            SlotSet.apply(false, result, key.getName(), arg3);
        }
        if (keywordStart == args.length) {
            k = 1;
        }
        if (k != args.length) {
            final MethodProc aproc = ClassMethods.apply(dtype, "add", '\0', this.language);
            if (aproc == null) {
                throw MethodProc.matchFailAsException(err, proc, args);
            }
            while (k < args.length) {
                aproc.apply2(result, args[k++]);
            }
        }
        return result;
    }
    
    @Override
    public int numArgs() {
        return 0xFFFFF000 | ((this.kind == 'N') ? 1 : 2);
    }
    
    protected MethodProc lookupMethods(final ObjectType dtype, final Object name) {
        String mname;
        if (this.kind == 'N') {
            mname = "<init>";
        }
        else {
            if (name instanceof CharSequence) {
                mname = name.toString();
            }
            else {
                if (!(name instanceof Symbol)) {
                    throw new WrongType(this, 1, name, "string-or-symbol");
                }
                mname = ((Symbol)name).getName();
            }
            mname = Mangling.mangleName(mname);
        }
        final MethodProc proc = ClassMethods.apply(dtype, mname, (this.kind == 'P') ? 'P' : ((this.kind == '*' || this.kind == 'V') ? 'V' : '\0'), this.language);
        if (proc == null) {
            throw new RuntimeException(this.getName() + ": no method named `" + mname + "' in class " + dtype.getName());
        }
        return proc;
    }
    
    public static synchronized ApplyExp makeInvokeStatic(final ClassType type, final String name, final Expression... args) {
        final PrimProcedure method = getStaticMethod(type, name, args);
        if (method == null) {
            throw new RuntimeException("missing or ambiguous method `" + name + "' in " + type.getName());
        }
        return new ApplyExp(method, args);
    }
    
    @Deprecated
    public static synchronized PrimProcedure getStaticMethod(final ClassType type, final String name, final Expression[] args) {
        return CompileInvoke.getStaticMethod(type, name, args);
    }
    
    static {
        invoke = new Invoke("invoke", '*');
        invokeStatic = new Invoke("invoke-static", 'S');
        invokeSpecial = new Invoke("invoke-special", 'P');
        make = new Invoke("make", 'N');
    }
}
