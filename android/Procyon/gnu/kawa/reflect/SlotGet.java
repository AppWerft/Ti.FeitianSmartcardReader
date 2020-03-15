// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.bytecode.CodeAttr;
import gnu.expr.Expression;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.bytecode.ArrayType;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.bytecode.Member;
import gnu.bytecode.ObjectType;
import gnu.mapping.WrongArguments;
import gnu.bytecode.Type;
import java.lang.reflect.InvocationTargetException;
import gnu.mapping.WrappedException;
import gnu.mapping.Values;
import gnu.expr.ClassExp;
import java.lang.reflect.Array;
import gnu.expr.Language;
import gnu.mapping.WrongType;
import gnu.mapping.SimpleSymbol;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.expr.Mangling;
import gnu.bytecode.Field;
import gnu.mapping.Procedure;
import gnu.expr.Inlineable;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure2;

public class SlotGet extends Procedure2 implements HasSetter, Inlineable
{
    static Class[] noClasses;
    boolean isStatic;
    Procedure setter;
    public static final SlotGet field;
    public static final SlotGet slotRef;
    public static final SlotGet staticField;
    
    public SlotGet(final String name, final boolean isStatic) {
        super(name);
        this.isStatic = isStatic;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplySlotGet");
    }
    
    public SlotGet(final String name, final boolean isStatic, final Procedure setter) {
        this(name, isStatic);
        this.setter = setter;
    }
    
    public static Object field(final Object obj, final String fname) {
        return SlotGet.field.apply2(obj, fname);
    }
    
    public static Object staticField(final Object obj, final String fname) {
        return SlotGet.staticField.apply2(obj, fname);
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        String getName = null;
        String isName = null;
        String fname;
        String name;
        if (arg2 instanceof Field) {
            fname = ((Field)arg2).getName();
            name = Mangling.demangleName(fname, true);
        }
        else {
            if (arg2 instanceof ClassType) {
                return arg2;
            }
            if (arg2 instanceof Method) {
                final String mname = ((Method)arg2).getName();
                name = Mangling.demangleName(mname, false);
                if (mname.startsWith("get")) {
                    getName = mname;
                }
                else if (mname.startsWith("is")) {
                    isName = mname;
                }
                fname = null;
            }
            else {
                if (!(arg2 instanceof SimpleSymbol) && !(arg2 instanceof CharSequence)) {
                    throw new WrongType(this, 2, arg2, "string");
                }
                name = arg2.toString();
                fname = Mangling.mangleNameIfNeeded(name);
            }
        }
        if ("class".equals(fname)) {
            fname = "class";
        }
        else if ("length".equals(fname)) {
            fname = "length";
        }
        return getSlotValue(this.isStatic, arg1, name, fname, getName, isName, Language.getDefaultLanguage());
    }
    
    public static Object getSlotValue(final boolean isStatic, final Object obj, final String name, final String fname, final String getName, final String isName, final Language language) {
        final Class clas = isStatic ? coerceToClass(obj) : obj.getClass();
        if (fname == "length" && clas.isArray()) {
            final int length = Array.getLength(obj);
            return length;
        }
        if (fname == "class") {
            return clas;
        }
        boolean illegalAccess = false;
        if (fname != null) {
            java.lang.reflect.Field field;
            try {
                field = clas.getField(fname);
            }
            catch (Exception ex) {
                final Class[] memberClasses = clas.getClasses();
                int i = memberClasses.length;
                while (--i >= 0) {
                    final Class memberClass = memberClasses[i];
                    if (memberClass.getSimpleName().equals(fname)) {
                        return memberClass;
                    }
                }
                field = null;
            }
            if (field != null) {
                if (isStatic && (field.getModifiers() & 0x8) == 0x0) {
                    throw new RuntimeException("cannot access non-static field '" + fname + '\'');
                }
                try {
                    return language.coerceToObject(field.getType(), field.get(obj));
                }
                catch (IllegalAccessException ex3) {
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
                mname = ((getName != null) ? getName : ClassExp.slotToMethodName("get", name));
                getmethod = clas.getMethod(mname, (Class[])SlotGet.noClasses);
            }
            catch (Exception getEx) {
                mname = ((isName != null) ? isName : ClassExp.slotToMethodName("is", name));
                getmethod = clas.getMethod(mname, (Class[])SlotGet.noClasses);
            }
            if (isStatic && (getmethod.getModifiers() & 0x8) == 0x0) {
                throw new RuntimeException("cannot call non-static getter method '" + mname + '\'');
            }
            Object result = getmethod.invoke(obj, Values.noArgs);
            result = language.coerceToObject(getmethod.getReturnType(), result);
            return result;
        }
        catch (InvocationTargetException ex2) {
            WrappedException.rethrow(ex2.getTargetException());
        }
        catch (IllegalAccessException ex4) {
            illegalAccess = true;
        }
        catch (NoSuchMethodException ex5) {}
        if (illegalAccess) {
            throw new RuntimeException("illegal access for field " + fname);
        }
        throw new RuntimeException("no such field " + fname + " in " + clas.getName());
    }
    
    static Class coerceToClass(final Object obj) {
        if (obj instanceof Class) {
            return (Class)obj;
        }
        if (obj instanceof Type) {
            return ((Type)obj).getReflectClass();
        }
        throw new RuntimeException("argument is neither Class nor Type");
    }
    
    @Override
    public void setN(final Object[] args) {
        final int nargs = args.length;
        if (nargs != 3) {
            throw new WrongArguments(this.getSetter(), nargs);
        }
        this.set2(args[0], args[1], args[2]);
    }
    
    public void set2(final Object obj, final Object name, final Object value) {
        SlotSet.apply(this.isStatic, obj, name, value);
    }
    
    public static Member lookupMember(final ObjectType clas, final String name, ClassType caller) {
        final String mname = Mangling.mangleNameIfNeeded(name);
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
        final String getname = ClassExp.slotToMethodName("get", name);
        Method method = clas.getMethod(getname, Type.typeArray0);
        if (method == null) {
            method = clas.getMethod(ClassExp.slotToMethodName("is", name), Type.typeArray0);
        }
        if (method == null) {
            return member;
        }
        return method;
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final Expression[] args = exp.getArgs();
        final Expression arg0 = args[0];
        final Expression arg2 = args[1];
        final Language language = comp.getLanguage();
        final Type type = this.isStatic ? language.getTypeFor(arg0) : arg0.getType();
        final CodeAttr code = comp.getCode();
        if (type instanceof ObjectType && arg2 instanceof QuoteExp) {
            final ObjectType ctype = (ObjectType)type;
            final Object part = ((QuoteExp)arg2).getValue();
            if (this.isStatic && part instanceof SimpleSymbol && "class".equals(((SimpleSymbol)part).getName())) {
                comp.loadClassRef((ObjectType)type);
                target.compileFromStack(comp, Compilation.typeClass);
                return;
            }
            if (part instanceof Field) {
                final Field field = (Field)part;
                final int modifiers = field.getModifiers();
                final boolean isStaticField = (modifiers & 0x8) != 0x0;
                args[0].compile(comp, isStaticField ? Target.Ignore : Target.pushValue(ctype));
                if (isStaticField) {
                    final boolean inlined = false;
                    if (!inlined) {
                        code.emitGetStatic(field);
                    }
                }
                else {
                    code.emitGetField(field);
                }
                final Type ftype = language.getLangTypeFor(field.getType());
                target.compileFromStack(comp, ftype);
                return;
            }
            if (part instanceof Method) {
                final Method method = (Method)part;
                final int modifiers = method.getModifiers();
                final boolean isStaticMethod = method.getStaticFlag();
                args[0].compile(comp, isStaticMethod ? Target.Ignore : Target.pushValue(ctype));
                if (isStaticMethod) {
                    code.emitInvokeStatic(method);
                }
                else {
                    code.emitInvoke(method);
                }
                target.compileFromStack(comp, method.getReturnType());
                return;
            }
        }
        final String name = ClassMethods.checkName(arg2);
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
        return (this.setter == null) ? super.getSetter() : this.setter;
    }
    
    public static ApplyExp makeGetField(final Expression value, final String fieldName) {
        final Expression[] args = { value, new QuoteExp((Object)fieldName) };
        return new ApplyExp(SlotGet.field, args);
    }
    
    static {
        SlotGet.noClasses = new Class[0];
        field = new SlotGet("field", false, SlotSet.set$Mnfield$Ex);
        slotRef = new SlotGet("slot-ref", false, SlotSet.set$Mnfield$Ex);
        staticField = new SlotGet("static-field", true, SlotSet.set$Mnstatic$Mnfield$Ex);
    }
}
