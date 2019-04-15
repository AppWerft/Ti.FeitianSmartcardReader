/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.SlotSet;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class SlotGet
extends Procedure2
implements HasSetter,
Inlineable {
    static Class[] noClasses = new Class[0];
    boolean isStatic;
    Procedure setter;
    public static final SlotGet field = new SlotGet("field", false, SlotSet.set$Mnfield$Ex);
    public static final SlotGet slotRef = new SlotGet("slot-ref", false, SlotSet.set$Mnfield$Ex);
    public static final SlotGet staticField = new SlotGet("static-field", true, SlotSet.set$Mnstatic$Mnfield$Ex);

    public SlotGet(String name, boolean isStatic) {
        super(name);
        this.isStatic = isStatic;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplySlotGet");
    }

    public SlotGet(String name, boolean isStatic, Procedure setter) {
        this(name, isStatic);
        this.setter = setter;
    }

    public static Object field(Object obj, String fname) {
        return field.apply2(obj, fname);
    }

    public static Object staticField(Object obj, String fname) {
        return staticField.apply2(obj, fname);
    }

    @Override
    public Object apply2(Object arg1, Object arg2) {
        String name;
        String fname;
        String getName = null;
        String isName = null;
        if (arg2 instanceof gnu.bytecode.Field) {
            fname = ((gnu.bytecode.Field)arg2).getName();
            name = Mangling.demangleName(fname, true);
        } else {
            if (arg2 instanceof ClassType) {
                return arg2;
            }
            if (arg2 instanceof Method) {
                String mname = ((Method)arg2).getName();
                name = Mangling.demangleName(mname, false);
                if (mname.startsWith("get")) {
                    getName = mname;
                } else if (mname.startsWith("is")) {
                    isName = mname;
                }
                fname = null;
            } else if (arg2 instanceof SimpleSymbol || arg2 instanceof CharSequence) {
                name = arg2.toString();
                fname = Mangling.mangleNameIfNeeded(name);
            } else {
                throw new WrongType((Procedure)this, 2, arg2, "string");
            }
        }
        if ("class".equals(fname)) {
            fname = "class";
        } else if ("length".equals(fname)) {
            fname = "length";
        }
        return SlotGet.getSlotValue(this.isStatic, arg1, name, fname, getName, isName, Language.getDefaultLanguage());
    }

    public static Object getSlotValue(boolean isStatic, Object obj, String name, String fname, String getName, String isName, Language language) {
        Class<?> clas;
        Class<?> class_ = clas = isStatic ? SlotGet.coerceToClass(obj) : obj.getClass();
        if (fname == "length" && clas.isArray()) {
            int length = Array.getLength(obj);
            return length;
        }
        if (fname == "class") {
            return clas;
        }
        boolean illegalAccess = false;
        if (fname != null) {
            Field field;
            try {
                field = clas.getField(fname);
            }
            catch (Exception ex) {
                Class<?>[] memberClasses = clas.getClasses();
                int i = memberClasses.length;
                while (--i >= 0) {
                    Class<?> memberClass = memberClasses[i];
                    if (!memberClass.getSimpleName().equals(fname)) continue;
                    return memberClass;
                }
                field = null;
            }
            if (field != null) {
                if (isStatic && (field.getModifiers() & 8) == 0) {
                    throw new RuntimeException("cannot access non-static field '" + fname + '\'');
                }
                try {
                    return language.coerceToObject(field.getType(), field.get(obj));
                }
                catch (IllegalAccessException ex) {
                    illegalAccess = true;
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        try {
            String mname = null;
            java.lang.reflect.Method getmethod = null;
            try {
                mname = getName != null ? getName : ClassExp.slotToMethodName("get", name);
                getmethod = clas.getMethod(mname, noClasses);
            }
            catch (Exception getEx) {
                mname = isName != null ? isName : ClassExp.slotToMethodName("is", name);
                getmethod = clas.getMethod(mname, noClasses);
            }
            if (isStatic && (getmethod.getModifiers() & 8) == 0) {
                throw new RuntimeException("cannot call non-static getter method '" + mname + '\'');
            }
            Object result = getmethod.invoke(obj, Values.noArgs);
            result = language.coerceToObject(getmethod.getReturnType(), result);
            return result;
        }
        catch (InvocationTargetException ex) {
            WrappedException.rethrow(ex.getTargetException());
        }
        catch (IllegalAccessException ex) {
            illegalAccess = true;
        }
        catch (NoSuchMethodException ex) {
            // empty catch block
        }
        if (illegalAccess) {
            throw new RuntimeException("illegal access for field " + fname);
        }
        throw new RuntimeException("no such field " + fname + " in " + clas.getName());
    }

    static Class coerceToClass(Object obj) {
        if (obj instanceof Class) {
            return (Class)obj;
        }
        if (obj instanceof Type) {
            return ((Type)obj).getReflectClass();
        }
        throw new RuntimeException("argument is neither Class nor Type");
    }

    @Override
    public void setN(Object[] args) {
        int nargs = args.length;
        if (nargs != 3) {
            throw new WrongArguments(this.getSetter(), nargs);
        }
        this.set2(args[0], args[1], args[2]);
    }

    public void set2(Object obj, Object name, Object value) {
        SlotSet.apply(this.isStatic, obj, (String)name, value);
    }

    public static Member lookupMember(ObjectType clas, String name, ClassType caller) {
        String getname;
        Method method;
        String mname = Mangling.mangleNameIfNeeded(name);
        Member member = clas.getField(mname, -1);
        if (member == null && clas instanceof ClassType) {
            member = ((ClassType)clas).getDeclaredClass(mname);
        }
        if (member != null) {
            if (caller == null) {
                caller = Type.pointer_type;
            }
            if (caller.isAccessible(member, clas)) {
                return member;
            }
        }
        if ((method = clas.getMethod(getname = ClassExp.slotToMethodName("get", name), Type.typeArray0)) == null) {
            method = clas.getMethod(ClassExp.slotToMethodName("is", name), Type.typeArray0);
        }
        if (method == null) {
            return member;
        }
        return method;
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        Expression[] args = exp.getArgs();
        Expression arg0 = args[0];
        Expression arg1 = args[1];
        Language language = comp.getLanguage();
        Type type = this.isStatic ? language.getTypeFor(arg0) : arg0.getType();
        CodeAttr code = comp.getCode();
        if (type instanceof ObjectType && arg1 instanceof QuoteExp) {
            ObjectType ctype = (ObjectType)type;
            Object part = ((QuoteExp)arg1).getValue();
            if (this.isStatic && part instanceof SimpleSymbol && "class".equals(((SimpleSymbol)part).getName())) {
                comp.loadClassRef((ObjectType)type);
                target.compileFromStack(comp, Compilation.typeClass);
                return;
            }
            if (part instanceof gnu.bytecode.Field) {
                gnu.bytecode.Field field = (gnu.bytecode.Field)part;
                int modifiers = field.getModifiers();
                boolean isStaticField = (modifiers & 8) != 0;
                args[0].compile(comp, isStaticField ? Target.Ignore : Target.pushValue(ctype));
                if (isStaticField) {
                    boolean inlined = false;
                    if (!inlined) {
                        code.emitGetStatic(field);
                    }
                } else {
                    code.emitGetField(field);
                }
                Type ftype = language.getLangTypeFor(field.getType());
                target.compileFromStack(comp, ftype);
                return;
            }
            if (part instanceof Method) {
                Method method = (Method)part;
                int modifiers = method.getModifiers();
                boolean isStaticMethod = method.getStaticFlag();
                args[0].compile(comp, isStaticMethod ? Target.Ignore : Target.pushValue(ctype));
                if (isStaticMethod) {
                    code.emitInvokeStatic(method);
                } else {
                    code.emitInvoke(method);
                }
                target.compileFromStack(comp, method.getReturnType());
                return;
            }
        }
        String name = ClassMethods.checkName(arg1);
        if (type instanceof ArrayType && "length".equals(name) && !this.isStatic) {
            args[0].compile(comp, Target.pushValue(type));
            code.emitArrayLength();
            target.compileFromStack(comp, LangPrimType.intType);
            return;
        }
        ApplyExp.compile(exp, comp, target);
    }

    @Override
    public Procedure getSetter() {
        return this.setter == null ? super.getSetter() : this.setter;
    }

    public static ApplyExp makeGetField(Expression value, String fieldName) {
        Expression[] args = new Expression[]{value, new QuoteExp(fieldName)};
        return new ApplyExp(field, args);
    }
}

