// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.expr.LambdaExp;
import gnu.mapping.SimpleSymbol;
import kawa.standard.Scheme;
import gnu.expr.ClassExp;
import gnu.expr.Mangling;
import gnu.kawa.lispexpr.LangObjType;
import gnu.bytecode.Method;
import gnu.bytecode.Member;
import gnu.expr.ErrorExp;
import gnu.bytecode.Field;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ArrayType;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import gnu.bytecode.PrimType;
import gnu.mapping.Procedure;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;
import gnu.bytecode.ClassType;
import gnu.expr.Compilation;
import gnu.bytecode.Type;

public class CompileReflect
{
    public static int checkKnownClass(final Type type, final Compilation comp) {
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
    
    public static ApplyExp inlineClassName(final ApplyExp exp, final int carg, final InlineCalls walker) {
        final Compilation comp = walker.getCompilation();
        final Language language = comp.getLanguage();
        final Expression[] args = exp.getArgs();
        if (args.length > carg) {
            final Type type = language.getTypeFor(args[carg]);
            if (!(type instanceof Type)) {
                return exp;
            }
            if (checkKnownClass(type, comp) >= 0) {
                args[carg] = new QuoteExp(type);
                return exp;
            }
        }
        return exp;
    }
    
    public static Expression validateApplyInstanceOf(ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Expression origTypeExp = (exp.getArgCount() >= 2) ? exp.getArg(1) : null;
        exp.visitArgs(visitor);
        exp = inlineClassName(exp, 1, visitor);
        final Expression[] args = exp.getArgs();
        if (args.length == 2) {
            final Expression value = args[0];
            final Expression texp = args[1];
            if (texp instanceof QuoteExp) {
                final Object t = ((QuoteExp)texp).getValue();
                if (t instanceof Type) {
                    Type type = (Type)t;
                    if (type instanceof PrimType) {
                        type = ((PrimType)type).boxedType();
                    }
                    if (value instanceof QuoteExp) {
                        return type.isInstance(((QuoteExp)value).getValue()) ? QuoteExp.trueExp : QuoteExp.falseExp;
                    }
                    if (!value.side_effects() && type instanceof ClassType) {
                        final int comp = type.compare(value.getType());
                        if (comp == 1 || comp == 0) {
                            return QuoteExp.trueExp;
                        }
                        if (comp == -3) {
                            return QuoteExp.falseExp;
                        }
                    }
                }
            }
            final Type texpType = texp.getType();
            if (Compilation.typeType.isCompatibleWithValue(texpType) < 0 && Type.javalangClassType.isCompatibleWithValue(texpType) < 0) {
                visitor.getCompilation().error('w', "not a type or class expression", origTypeExp);
            }
        }
        return exp;
    }
    
    public static Expression validateApplySlotGet(ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Compilation comp = visitor.getCompilation();
        final Language language = comp.getLanguage();
        final SlotGet gproc = (SlotGet)proc;
        final boolean isStatic = gproc.isStatic;
        final Expression[] args = exp.getArgs();
        final Expression arg0 = args[0];
        final Expression arg2 = args[1];
        final Object val1 = arg2.valueIfConstant();
        String name = null;
        if (val1 instanceof CharSequence || val1 instanceof Symbol) {
            name = val1.toString();
            Type type;
            if (isStatic) {
                type = language.getTypeFor(arg0);
                final int known = checkKnownClass(type, comp);
                if (known < 0 || "class".equals(name)) {
                    return exp;
                }
                if (type != null) {
                    final Expression[] nargs = { new QuoteExp(type), arg2 };
                    final ApplyExp nexp = new ApplyExp(exp.getFunction(), nargs);
                    nexp.setLine(exp);
                    exp = nexp;
                }
            }
            else {
                type = arg0.getType();
                if (type instanceof ArrayType && "length".equals(name)) {
                    exp.setType(Type.intType);
                    return exp;
                }
            }
            Type rtype = null;
            if (type instanceof ObjectType) {
                final ObjectType ctype = (ObjectType)type;
                final ClassType caller = (comp.curClass != null) ? comp.curClass : comp.mainClass;
                final Member part = SlotGet.lookupMember(ctype, name, caller);
                if (part instanceof Field) {
                    final Field field = (Field)part;
                    final int modifiers = field.getModifiers();
                    final boolean isStaticField = (modifiers & 0x8) != 0x0;
                    if (isStatic && !isStaticField) {
                        return new ErrorExp("cannot access non-static field `" + name + "' using `" + proc.getName() + '\'', comp);
                    }
                    if (caller != null && !caller.isAccessible(field, ctype)) {
                        return new ErrorExp("field " + field.getDeclaringClass().getName() + '.' + name + " is not accessible here", comp);
                    }
                    if (isStatic && (modifiers & 0x4010) == 0x4010) {
                        try {
                            return new QuoteExp(field.getReflectField().get(null), field.getType());
                        }
                        catch (Exception ex) {}
                    }
                    rtype = field.getType();
                }
                else if (part instanceof Method) {
                    final Method method = (Method)part;
                    final ClassType dtype = method.getDeclaringClass();
                    final int modifiers2 = method.getModifiers();
                    final boolean isStaticMethod = method.getStaticFlag();
                    if (isStatic && !isStaticMethod) {
                        return new ErrorExp("cannot call non-static getter method `" + name + "' using `" + proc.getName() + '\'', comp);
                    }
                    if (caller != null && !caller.isAccessible(dtype, ctype, modifiers2)) {
                        return new ErrorExp("method " + method + " is not accessible here", comp);
                    }
                    rtype = method.getReturnType();
                }
                else if (part instanceof ClassType && ((ClassType)part).getStaticFlag()) {
                    Object result = part;
                    if (arg0.valueIfConstant() instanceof Class) {
                        final Class cls = ((ClassType)part).getReflectClass();
                        if (cls != null) {
                            result = cls;
                        }
                    }
                    return QuoteExp.getInstance(result);
                }
                if (part != null) {
                    final Expression[] nargs2 = { arg0, new QuoteExp(part) };
                    final ApplyExp nexp2 = new ApplyExp(exp.getFunction(), nargs2);
                    nexp2.setLine(exp);
                    nexp2.setType(rtype);
                    return nexp2;
                }
                if (part == null && type instanceof ClassType && isStatic) {
                    final ClassType mcl = ((ClassType)type).getDeclaredClass(name);
                    if (mcl != null) {
                        if (arg0.valueIfConstant() instanceof Class) {
                            try {
                                return new QuoteExp(mcl.getReflectClass());
                            }
                            catch (Exception ex2) {}
                        }
                        return new QuoteExp(mcl);
                    }
                }
                if (type != Type.pointer_type && type != LangObjType.dynamicType && comp.warnUnknownMember()) {
                    comp.error('w', "no slot `" + name + "' in " + ctype.getName());
                }
            }
            String fname = Mangling.mangleNameIfNeeded(name);
            fname = fname.intern();
            final String getName = ClassExp.slotToMethodName("get", name);
            final String isName = ClassExp.slotToMethodName("is", name);
            final ApplyExp nexp3 = new ApplyExp(Invoke.invokeStatic, new Expression[] { QuoteExp.getInstance("gnu.kawa.reflect.SlotGet"), QuoteExp.getInstance("getSlotValue"), isStatic ? QuoteExp.trueExp : QuoteExp.falseExp, args[0], QuoteExp.getInstance(name), QuoteExp.getInstance(fname), QuoteExp.getInstance(getName), QuoteExp.getInstance(isName), QuoteExp.getInstance(language) });
            nexp3.setLine(exp);
            return visitor.visitApplyOnly(nexp3, required);
        }
        return exp;
    }
    
    public static Expression validateApplySlotSet(ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Expression[] args = exp.getArgs();
        final SlotSet sproc = (SlotSet)proc;
        final boolean isStatic = sproc.isStatic;
        args[0] = visitor.visit(args[0], (Type)null);
        args[1] = visitor.visit(args[1], (Type)null);
        final Type type = isStatic ? Scheme.exp2Type(args[0]) : args[0].getType();
        final Object val1 = args[1].valueIfConstant();
        String name = null;
        final Compilation comp = visitor.getCompilation();
        final ClassType caller = (comp.curClass != null) ? comp.curClass : comp.mainClass;
        if (val1 instanceof CharSequence || val1 instanceof SimpleSymbol) {
            name = val1.toString();
            if (type instanceof ClassType) {
                final ClassType ctype = (ClassType)type;
                final Member part = SlotSet.lookupMember(ctype, name, caller);
                if (part != null) {
                    return visitor.visit(makeSetterCall(args[0], part, args[2]), Type.voidType);
                }
                if (type != Type.pointer_type && comp.warnUnknownMember()) {
                    comp.error('w', "no slot `" + name + "' in " + ctype.getName());
                }
            }
        }
        else if (val1 instanceof Member) {
            final Member part2 = (Member)val1;
            name = part2.getName();
            final ClassType ctype2 = part2.getDeclaringClass();
            if (caller != null && !caller.isAccessible(part2, ctype2)) {
                return new ErrorExp("slot '" + name + "' in " + ctype2.getName() + " not accessible here", comp);
            }
            if (part2 instanceof Field) {
                final Field field = (Field)part2;
                final boolean isStaticField = field.getStaticFlag();
                final Type ftype = comp.getLanguage().getLangTypeFor(((Field)val1).getType());
                if (isStatic && !isStaticField) {
                    return new ErrorExp("cannot access non-static field `" + name + "' using `" + proc.getName() + '\'', comp);
                }
                args[2] = visitor.visit(args[2], ftype);
            }
        }
        args[2] = visitor.visit(args[2], (Type)null);
        if (isStatic && visitor.getCompilation().mustCompile) {
            exp = inlineClassName(exp, 0, visitor);
        }
        exp.setType(Type.voidType);
        return exp;
    }
    
    public static Expression validateApplyTypeSwitch(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        for (int i = 1; i < args.length; ++i) {
            if (args[i] instanceof LambdaExp) {
                final LambdaExp lexp = (LambdaExp)args[i];
                lexp.setInlineOnly(exp, visitor.getCurrentLambda());
                lexp.setFlag(16384);
            }
        }
        return exp;
    }
    
    public static Expression makeSetterCall(final Expression receiver, Object slot, final Expression newValue) {
        Procedure p;
        if (slot instanceof Field) {
            p = SlotSet.set$Mnfield$Ex;
        }
        else {
            slot = ((Member)slot).getName();
            p = Invoke.invoke;
        }
        final Expression[] sargs = { receiver, new QuoteExp(slot), newValue };
        return new ApplyExp(p, sargs);
    }
    
    public static Expression validateThrow(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        final Expression[] args = exp.getArgs();
        args[0] = visitor.visit(args[0], Type.javalangThrowableType);
        exp.setType(Type.neverReturnsType);
        return exp;
    }
}
