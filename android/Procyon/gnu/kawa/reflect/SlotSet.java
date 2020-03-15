// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.bytecode.CodeAttr;
import gnu.expr.Expression;
import gnu.expr.CheckedTarget;
import gnu.expr.QuoteExp;
import kawa.standard.Scheme;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.mapping.Values;
import java.lang.reflect.InvocationTargetException;
import gnu.mapping.WrappedException;
import gnu.expr.ClassExp;
import gnu.bytecode.Method;
import gnu.bytecode.Field;
import gnu.bytecode.Member;
import gnu.expr.Mangling;
import gnu.mapping.SimpleSymbol;
import gnu.expr.Language;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.expr.Inlineable;
import gnu.mapping.Procedure3;

public class SlotSet extends Procedure3 implements Inlineable
{
    boolean isStatic;
    public static final SlotSet set$Mnfield$Ex;
    public static final SlotSet set$Mnstatic$Mnfield$Ex;
    static final Type[] type1Array;
    
    public SlotSet(final String name, final boolean isStatic) {
        super(name);
        this.isStatic = isStatic;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplySlotSet");
    }
    
    public static void setField(final Object obj, final String name, final Object value) {
        apply(false, obj, name, value);
    }
    
    public static void setStaticField(final Object obj, final String name, final Object value) {
        apply(true, obj, name, value);
    }
    
    public static void apply(final boolean isStatic, final Object obj, final Object member, final Object value) {
        final Language language = Language.getDefaultLanguage();
        boolean illegalAccess = false;
        String name;
        String fname;
        Class clas;
        if (member instanceof CharSequence || member instanceof SimpleSymbol) {
            name = member.toString();
            fname = Mangling.mangleNameIfNeeded(name);
            clas = (isStatic ? SlotGet.coerceToClass(obj) : obj.getClass());
        }
        else {
            name = (fname = ((Member)member).getName());
            clas = null;
        }
        try {
            final java.lang.reflect.Field field = (member instanceof Field) ? ((Field)member).getReflectField() : clas.getField(fname);
            final Class ftype = field.getType();
            field.set(obj, language.coerceFromObject(ftype, value));
            return;
        }
        catch (NoSuchFieldException ex2) {}
        catch (IllegalAccessException ex3) {
            illegalAccess = true;
        }
        try {
            java.lang.reflect.Method getmethod = null;
            boolean haveSetter = member instanceof Method;
            final String setName = haveSetter ? fname : ClassExp.slotToMethodName("set", name);
            if (haveSetter && !setName.startsWith("set")) {
                haveSetter = false;
            }
            try {
                final String getName = haveSetter ? ("get" + setName.substring(3)) : ClassExp.slotToMethodName("get", name);
                getmethod = clas.getMethod(getName, (Class[])SlotGet.noClasses);
            }
            catch (Exception getEx) {
                final String getName2 = haveSetter ? ("is" + setName.substring(3)) : ClassExp.slotToMethodName("is", name);
                getmethod = clas.getMethod(getName2, (Class[])SlotGet.noClasses);
            }
            final Class[] setArgTypes = { getmethod.getReturnType() };
            final java.lang.reflect.Method setmethod = clas.getMethod(setName, (Class[])setArgTypes);
            final Object[] args = { language.coerceFromObject(setArgTypes[0], value) };
            setmethod.invoke(obj, args);
            return;
        }
        catch (InvocationTargetException ex) {
            WrappedException.rethrow(ex.getTargetException());
        }
        catch (IllegalAccessException ex3) {
            illegalAccess = true;
        }
        catch (NoSuchMethodException ex4) {}
        if (illegalAccess) {
            throw new RuntimeException("illegal access for field " + name);
        }
        throw new RuntimeException("no such field " + name + " in " + clas.getName());
    }
    
    @Override
    public Object apply3(final Object obj, final Object fname, final Object value) {
        apply(this.isStatic, obj, fname, value);
        return Values.empty;
    }
    
    public static Member lookupMember(final ObjectType clas, final String name, ClassType caller) {
        final Field field = clas.getField(Mangling.mangleNameIfNeeded(name), -1);
        if (field != null) {
            if (caller == null) {
                caller = Type.pointer_type;
            }
            if (caller.isAccessible(field, clas)) {
                return field;
            }
        }
        final String setName = ClassExp.slotToMethodName("set", name);
        final Method method = clas.getMethod(setName, SlotSet.type1Array);
        if (method == null) {
            return field;
        }
        return method;
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final Expression[] args = exp.getArgs();
        final int nargs = args.length;
        final Expression arg0 = args[0];
        final Expression arg2 = args[1];
        final Expression value = args[2];
        final Type type = this.isStatic ? Scheme.exp2Type(arg0) : arg0.getType();
        if (type instanceof ObjectType && arg2 instanceof QuoteExp) {
            final Object val1 = ((QuoteExp)arg2).getValue();
            final ObjectType ctype = (ObjectType)type;
            if (val1 instanceof Field) {
                final Field field = (Field)val1;
                final CodeAttr code = comp.getCode();
                final int modifiers = field.getModifiers();
                final boolean isStaticField = (modifiers & 0x8) != 0x0;
                args[0].compile(comp, isStaticField ? Target.Ignore : Target.pushValue(ctype));
                final Type ftype = comp.getLanguage().getLangTypeFor(field.getType());
                args[2].compile(comp, CheckedTarget.getInstance(ftype));
                if (isStaticField) {
                    code.emitPutStatic(field);
                }
                else {
                    code.emitPutField(field);
                }
                comp.compileConstant(Values.empty, target);
                return;
            }
        }
        ApplyExp.compile(exp, comp, target);
    }
    
    static {
        set$Mnfield$Ex = new SlotSet("set-field!", false);
        set$Mnstatic$Mnfield$Ex = new SlotSet("set-static-field!", true);
        type1Array = new Type[1];
    }
}
