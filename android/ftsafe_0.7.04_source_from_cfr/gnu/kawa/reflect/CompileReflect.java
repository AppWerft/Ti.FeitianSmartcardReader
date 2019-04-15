/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.QuoteExp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import java.lang.reflect.Field;
import kawa.standard.Scheme;

public class CompileReflect {
    public static int checkKnownClass(Type type, Compilation comp) {
        if (type instanceof ClassType && type.isExisting()) {
            try {
                type.getReflectClass();
                return 1;
            }
            catch (Exception ex) {
                comp.error('e', "unknown class: " + type.getName());
                return -1;
            }
        }
        return 0;
    }

    public static ApplyExp inlineClassName(ApplyExp exp, int carg, InlineCalls walker) {
        Compilation comp = walker.getCompilation();
        Language language = comp.getLanguage();
        Expression[] args = exp.getArgs();
        if (args.length > carg) {
            Type type = language.getTypeFor(args[carg]);
            if (!(type instanceof Type)) {
                return exp;
            }
            if (CompileReflect.checkKnownClass(type, comp) >= 0) {
                args[carg] = new QuoteExp(type);
                return exp;
            }
        }
        return exp;
    }

    public static Expression validateApplyInstanceOf(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression origTypeExp = exp.getArgCount() >= 2 ? exp.getArg(1) : null;
        exp.visitArgs(visitor);
        exp = CompileReflect.inlineClassName(exp, 1, visitor);
        Expression[] args = exp.getArgs();
        if (args.length == 2) {
            Type texpType;
            Object t;
            Expression value = args[0];
            Expression texp = args[1];
            if (texp instanceof QuoteExp && (t = ((QuoteExp)texp).getValue()) instanceof Type) {
                Type type = (Type)t;
                if (type instanceof PrimType) {
                    type = ((PrimType)type).boxedType();
                }
                if (value instanceof QuoteExp) {
                    return type.isInstance(((QuoteExp)value).getValue()) ? QuoteExp.trueExp : QuoteExp.falseExp;
                }
                if (!value.side_effects() && type instanceof ClassType) {
                    int comp = type.compare(value.getType());
                    if (comp == 1 || comp == 0) {
                        return QuoteExp.trueExp;
                    }
                    if (comp == -3) {
                        return QuoteExp.falseExp;
                    }
                }
            }
            if (Compilation.typeType.isCompatibleWithValue(texpType = texp.getType()) < 0 && Type.javalangClassType.isCompatibleWithValue(texpType) < 0) {
                visitor.getCompilation().error('w', "not a type or class expression", origTypeExp);
            }
        }
        return exp;
    }

    public static Expression validateApplySlotGet(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Type type;
        exp.visitArgs(visitor);
        Compilation comp = visitor.getCompilation();
        Language language = comp.getLanguage();
        SlotGet gproc = (SlotGet)proc;
        boolean isStatic = gproc.isStatic;
        Expression[] args = exp.getArgs();
        Expression arg0 = args[0];
        Expression arg1 = args[1];
        Object val1 = arg1.valueIfConstant();
        String name = null;
        if (!(val1 instanceof CharSequence) && !(val1 instanceof Symbol)) {
            return exp;
        }
        name = val1.toString();
        if (isStatic) {
            type = language.getTypeFor(arg0);
            int known = CompileReflect.checkKnownClass(type, comp);
            if (known < 0 || "class".equals(name)) {
                return exp;
            }
            if (type != null) {
                Expression[] nargs = new Expression[]{new QuoteExp(type), arg1};
                ApplyExp nexp = new ApplyExp(exp.getFunction(), nargs);
                nexp.setLine(exp);
                exp = nexp;
            }
        } else {
            type = arg0.getType();
            if (type instanceof ArrayType && "length".equals(name)) {
                exp.setType(Type.intType);
                return exp;
            }
        }
        Type rtype = null;
        if (type instanceof ObjectType) {
            ClassType mcl;
            ObjectType ctype = (ObjectType)type;
            ClassType caller = comp.curClass != null ? comp.curClass : comp.mainClass;
            Member part = SlotGet.lookupMember(ctype, name, caller);
            if (part instanceof gnu.bytecode.Field) {
                boolean isStaticField;
                gnu.bytecode.Field field = (gnu.bytecode.Field)part;
                int modifiers = field.getModifiers();
                boolean bl = isStaticField = (modifiers & 8) != 0;
                if (isStatic && !isStaticField) {
                    return new ErrorExp("cannot access non-static field `" + name + "' using `" + proc.getName() + '\'', comp);
                }
                if (caller != null && !caller.isAccessible(field, ctype)) {
                    return new ErrorExp("field " + field.getDeclaringClass().getName() + '.' + name + " is not accessible here", comp);
                }
                if (isStatic && (modifiers & 16400) == 16400) {
                    try {
                        return new QuoteExp(field.getReflectField().get(null), field.getType());
                    }
                    catch (Exception ex) {
                        // empty catch block
                    }
                }
                rtype = field.getType();
            } else if (part instanceof Method) {
                Method method = (Method)part;
                ClassType dtype = method.getDeclaringClass();
                int modifiers = method.getModifiers();
                boolean isStaticMethod = method.getStaticFlag();
                if (isStatic && !isStaticMethod) {
                    return new ErrorExp("cannot call non-static getter method `" + name + "' using `" + proc.getName() + '\'', comp);
                }
                if (caller != null && !caller.isAccessible(dtype, ctype, modifiers)) {
                    return new ErrorExp("method " + method + " is not accessible here", comp);
                }
                rtype = method.getReturnType();
            } else if (part instanceof ClassType && ((ClassType)part).getStaticFlag()) {
                Class cls;
                Object result = part;
                if (arg0.valueIfConstant() instanceof Class && (cls = ((ClassType)part).getReflectClass()) != null) {
                    result = cls;
                }
                return QuoteExp.getInstance(result);
            }
            if (part != null) {
                Expression[] nargs = new Expression[]{arg0, new QuoteExp(part)};
                ApplyExp nexp = new ApplyExp(exp.getFunction(), nargs);
                nexp.setLine(exp);
                nexp.setType(rtype);
                return nexp;
            }
            if (part == null && type instanceof ClassType && isStatic && (mcl = ((ClassType)type).getDeclaredClass(name)) != null) {
                if (arg0.valueIfConstant() instanceof Class) {
                    try {
                        return new QuoteExp(mcl.getReflectClass());
                    }
                    catch (Exception ex) {
                        // empty catch block
                    }
                }
                return new QuoteExp(mcl);
            }
            if (type != Type.pointer_type && type != LangObjType.dynamicType && comp.warnUnknownMember()) {
                comp.error('w', "no slot `" + name + "' in " + ctype.getName());
            }
        }
        String fname = Mangling.mangleNameIfNeeded(name);
        fname = fname.intern();
        String getName = ClassExp.slotToMethodName("get", name);
        String isName = ClassExp.slotToMethodName("is", name);
        ApplyExp nexp = new ApplyExp(Invoke.invokeStatic, QuoteExp.getInstance("gnu.kawa.reflect.SlotGet"), QuoteExp.getInstance("getSlotValue"), isStatic ? QuoteExp.trueExp : QuoteExp.falseExp, args[0], QuoteExp.getInstance(name), QuoteExp.getInstance(fname), QuoteExp.getInstance(getName), QuoteExp.getInstance(isName), QuoteExp.getInstance(language));
        nexp.setLine(exp);
        return visitor.visitApplyOnly(nexp, required);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Expression validateApplySlotSet(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        ClassType caller;
        Expression[] args = exp.getArgs();
        SlotSet sproc = (SlotSet)proc;
        boolean isStatic = sproc.isStatic;
        args[0] = visitor.visit(args[0], null);
        args[1] = visitor.visit(args[1], null);
        Type type = isStatic ? Scheme.exp2Type(args[0]) : args[0].getType();
        Object val1 = args[1].valueIfConstant();
        String name = null;
        Compilation comp = visitor.getCompilation();
        ClassType classType = caller = comp.curClass != null ? comp.curClass : comp.mainClass;
        if (val1 instanceof CharSequence || val1 instanceof SimpleSymbol) {
            name = val1.toString();
            if (type instanceof ClassType) {
                ClassType ctype = (ClassType)type;
                Member part = SlotSet.lookupMember(ctype, name, caller);
                if (part != null) return visitor.visit(CompileReflect.makeSetterCall(args[0], part, args[2]), Type.voidType);
                if (type != Type.pointer_type && comp.warnUnknownMember()) {
                    comp.error('w', "no slot `" + name + "' in " + ctype.getName());
                }
            }
        } else if (val1 instanceof Member) {
            Member part = (Member)val1;
            name = part.getName();
            ClassType ctype = part.getDeclaringClass();
            if (caller != null && !caller.isAccessible(part, ctype)) {
                return new ErrorExp("slot '" + name + "' in " + ctype.getName() + " not accessible here", comp);
            }
            if (part instanceof gnu.bytecode.Field) {
                gnu.bytecode.Field field = (gnu.bytecode.Field)part;
                boolean isStaticField = field.getStaticFlag();
                Type ftype = comp.getLanguage().getLangTypeFor(((gnu.bytecode.Field)val1).getType());
                if (isStatic && !isStaticField) {
                    return new ErrorExp("cannot access non-static field `" + name + "' using `" + proc.getName() + '\'', comp);
                }
                args[2] = visitor.visit(args[2], ftype);
            }
        }
        args[2] = visitor.visit(args[2], null);
        if (isStatic && visitor.getCompilation().mustCompile) {
            exp = CompileReflect.inlineClassName(exp, 0, visitor);
        }
        exp.setType(Type.voidType);
        return exp;
    }

    public static Expression validateApplyTypeSwitch(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        for (int i = 1; i < args.length; ++i) {
            if (!(args[i] instanceof LambdaExp)) continue;
            LambdaExp lexp = (LambdaExp)args[i];
            lexp.setInlineOnly(exp, visitor.getCurrentLambda());
            lexp.setFlag(16384);
        }
        return exp;
    }

    public static Expression makeSetterCall(Expression receiver, Object slot, Expression newValue) {
        Procedure p;
        if (slot instanceof gnu.bytecode.Field) {
            p = SlotSet.set$Mnfield$Ex;
        } else {
            slot = ((Member)slot).getName();
            p = Invoke.invoke;
        }
        Expression[] sargs = new Expression[]{receiver, new QuoteExp(slot), newValue};
        return new ApplyExp(p, sargs);
    }

    public static Expression validateThrow(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        Expression[] args = exp.getArgs();
        args[0] = visitor.visit(args[0], Type.javalangThrowableType);
        exp.setType(Type.neverReturnsType);
        return exp;
    }
}

