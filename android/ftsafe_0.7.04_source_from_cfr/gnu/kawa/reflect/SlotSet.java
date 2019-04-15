/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.CheckedTarget;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.reflect.SlotGet;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure3;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kawa.standard.Scheme;

public class SlotSet
extends Procedure3
implements Inlineable {
    boolean isStatic;
    public static final SlotSet set$Mnfield$Ex = new SlotSet("set-field!", false);
    public static final SlotSet set$Mnstatic$Mnfield$Ex = new SlotSet("set-static-field!", true);
    static final Type[] type1Array = new Type[1];

    public SlotSet(String name, boolean isStatic) {
        super(name);
        this.isStatic = isStatic;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplySlotSet");
    }

    public static void setField(Object obj, String name, Object value) {
        SlotSet.apply(false, obj, name, value);
    }

    public static void setStaticField(Object obj, String name, Object value) {
        SlotSet.apply(true, obj, name, value);
    }

    public static void apply(boolean isStatic, Object obj, Object member, Object value) {
        String fname;
        Class<?> clas;
        String name;
        Language language = Language.getDefaultLanguage();
        boolean illegalAccess = false;
        if (member instanceof CharSequence || member instanceof SimpleSymbol) {
            name = member.toString();
            fname = Mangling.mangleNameIfNeeded(name);
            clas = isStatic ? SlotGet.coerceToClass(obj) : obj.getClass();
        } else {
            fname = name = ((Member)member).getName();
            clas = null;
        }
        try {
            Field field = member instanceof gnu.bytecode.Field ? ((gnu.bytecode.Field)member).getReflectField() : clas.getField(fname);
            Class<?> ftype = field.getType();
            field.set(obj, language.coerceFromObject(ftype, value));
            return;
        }
        catch (NoSuchFieldException ex) {
        }
        catch (IllegalAccessException ex) {
            illegalAccess = true;
        }
        try {
            String setName;
            java.lang.reflect.Method getmethod = null;
            boolean haveSetter = member instanceof Method;
            String string = setName = haveSetter ? fname : ClassExp.slotToMethodName("set", name);
            if (haveSetter && !setName.startsWith("set")) {
                haveSetter = false;
            }
            try {
                String getName = haveSetter ? "get" + setName.substring(3) : ClassExp.slotToMethodName("get", name);
                getmethod = clas.getMethod(getName, SlotGet.noClasses);
            }
            catch (Exception getEx) {
                String getName = haveSetter ? "is" + setName.substring(3) : ClassExp.slotToMethodName("is", name);
                getmethod = clas.getMethod(getName, SlotGet.noClasses);
            }
            Class[] setArgTypes = new Class[]{getmethod.getReturnType()};
            java.lang.reflect.Method setmethod = clas.getMethod(setName, setArgTypes);
            Object[] args = new Object[]{language.coerceFromObject(setArgTypes[0], value)};
            setmethod.invoke(obj, args);
            return;
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
            throw new RuntimeException("illegal access for field " + name);
        }
        throw new RuntimeException("no such field " + name + " in " + clas.getName());
    }

    @Override
    public Object apply3(Object obj, Object fname, Object value) {
        SlotSet.apply(this.isStatic, obj, fname, value);
        return Values.empty;
    }

    public static Member lookupMember(ObjectType clas, String name, ClassType caller) {
        String setName;
        Method method;
        gnu.bytecode.Field field = clas.getField(Mangling.mangleNameIfNeeded(name), -1);
        if (field != null) {
            if (caller == null) {
                caller = Type.pointer_type;
            }
            if (caller.isAccessible(field, clas)) {
                return field;
            }
        }
        if ((method = clas.getMethod(setName = ClassExp.slotToMethodName("set", name), type1Array)) == null) {
            return field;
        }
        return method;
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        Type type;
        Expression[] args = exp.getArgs();
        int nargs = args.length;
        Expression arg0 = args[0];
        Expression arg1 = args[1];
        Expression value = args[2];
        Type type2 = type = this.isStatic ? Scheme.exp2Type(arg0) : arg0.getType();
        if (type instanceof ObjectType && arg1 instanceof QuoteExp) {
            Object val1 = ((QuoteExp)arg1).getValue();
            ObjectType ctype = (ObjectType)type;
            if (val1 instanceof gnu.bytecode.Field) {
                gnu.bytecode.Field field = (gnu.bytecode.Field)val1;
                CodeAttr code = comp.getCode();
                int modifiers = field.getModifiers();
                boolean isStaticField = (modifiers & 8) != 0;
                args[0].compile(comp, isStaticField ? Target.Ignore : Target.pushValue(ctype));
                Type ftype = comp.getLanguage().getLangTypeFor(field.getType());
                args[2].compile(comp, CheckedTarget.getInstance(ftype));
                if (isStaticField) {
                    code.emitPutStatic(field);
                } else {
                    code.emitPutField(field);
                }
                comp.compileConstant(Values.empty, target);
                return;
            }
        }
        ApplyExp.compile(exp, comp, target);
    }
}

