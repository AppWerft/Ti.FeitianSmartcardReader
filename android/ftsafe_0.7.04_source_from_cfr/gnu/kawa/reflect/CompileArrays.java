/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.ArrayGet;
import gnu.kawa.reflect.ArrayLength;
import gnu.kawa.reflect.ArrayMake;
import gnu.kawa.reflect.ArrayNew;
import gnu.kawa.reflect.ArraySet;
import gnu.mapping.Procedure;
import gnu.mapping.Values;

public class CompileArrays {
    public static Expression validateArrayNew(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        exp.setType(ArrayType.make(((ArrayNew)proc).element_type));
        return exp;
    }

    public static Expression validateArrayLength(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        exp.setType(LangPrimType.intType);
        return exp;
    }

    public static Expression validateArrayGet(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        exp.setType(((ArrayGet)proc).element_type);
        return exp;
    }

    public static Expression validateArraySet(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        exp.visitArgs(visitor);
        exp.setType(Type.void_type);
        return exp;
    }

    public static boolean compileGet(ApplyExp exp, Compilation comp, Target target, Procedure proc) {
        if (!exp.isSimple()) {
            return false;
        }
        Type element_type = ((ArrayGet)proc).element_type;
        Expression[] args = exp.getArgs();
        args[0].compile(comp, ArrayType.make(element_type));
        args[1].compile(comp, Type.int_type);
        CodeAttr code = comp.getCode();
        code.emitArrayLoad(element_type);
        target.compileFromStack(comp, element_type);
        return true;
    }

    public static boolean compileSet(ApplyExp exp, Compilation comp, Target target, Procedure proc) {
        if (!exp.isSimple()) {
            return false;
        }
        Type element_type = ((ArraySet)proc).element_type;
        Expression[] args = exp.getArgs();
        args[0].compile(comp, ArrayType.make(element_type));
        args[1].compile(comp, Type.int_type);
        Target valueTarget = StackTarget.getTruncatingInstance(element_type);
        args[2].compile(comp, valueTarget);
        comp.getCode().emitArrayStore(element_type);
        comp.compileConstant(Values.empty, target);
        return true;
    }

    public static boolean compileNew(ApplyExp exp, Compilation comp, Target target, Procedure proc) {
        if (!exp.isSimple()) {
            return false;
        }
        Type element_type = ((ArrayNew)proc).element_type;
        CodeAttr code = comp.getCode();
        exp.getArgs()[0].compile(comp, Type.intType);
        code.emitNewArray(element_type.getImplementationType());
        target.compileFromStack(comp, ArrayType.make(element_type));
        return true;
    }

    public static boolean compileLength(ApplyExp exp, Compilation comp, Target target, Procedure proc) {
        if (!exp.isSimple()) {
            return false;
        }
        Type element_type = ((ArrayLength)proc).element_type;
        exp.getArgs()[0].compile(comp, ArrayType.make(element_type));
        CodeAttr code = comp.getCode();
        code.emitArrayLength();
        target.compileFromStack(comp, LangPrimType.intType);
        return true;
    }

    public static boolean compileMake(ApplyExp exp, Compilation comp, Target target, Procedure proc) {
        Type elementType = ((ArrayMake)proc).elementType;
        Expression[] args = exp.getArgs();
        CompileArrays.createArray(elementType, comp, args, 0, args.length);
        target.compileFromStack(comp, ArrayType.make(elementType));
        return true;
    }

    public static void createArray(Type elementType, Compilation comp, Expression[] args, int start, int end) {
        Variable arrSizeVar;
        CodeAttr code = comp.getCode();
        int countNonSplice = 0;
        int lastSplice = -1;
        for (int i = start; i < end; ++i) {
            if (MakeSplice.argIfSplice(args[i]) == null) {
                ++countNonSplice;
                continue;
            }
            lastSplice = i;
        }
        code.pushScope();
        code.emitPushInt(countNonSplice);
        if (lastSplice < 0) {
            arrSizeVar = null;
        } else {
            arrSizeVar = code.addLocal(Type.intType);
            code.emitStore(arrSizeVar);
        }
        ClassType utilType = ClassType.make("gnu.kawa.functions.MakeSplice");
        Method countMethod = utilType.getDeclaredMethod("count", 1);
        Method copyToMethod4 = utilType.getDeclaredMethod("copyTo", 4);
        Method copyToMethod5 = utilType.getDeclaredMethod("copyTo", 5);
        Variable[] tmpVars = new Variable[end - start];
        Variable[] sizeVars = new Variable[end - start];
        if (lastSplice >= 0) {
            for (int i = start; i < end; ++i) {
                Variable sizeVar;
                Expression arg = args[i];
                Expression argIfSplice = MakeSplice.argIfSplice(arg);
                if (argIfSplice == null && (!arg.side_effects() || i >= lastSplice)) continue;
                if (argIfSplice != null) {
                    argIfSplice.compile(comp, Target.pushObject);
                } else {
                    arg.compile(comp, elementType);
                }
                Variable tmpVar = code.addLocal(argIfSplice != null ? Type.objectType : elementType);
                code.emitStore(tmpVar);
                tmpVars[i - start] = tmpVar;
                if (argIfSplice == null) continue;
                sizeVars[i - start] = sizeVar = code.addLocal(Type.intType);
                code.emitLoad(tmpVar);
                code.emitInvoke(countMethod);
                code.emitDup();
                code.emitStore(sizeVar);
                code.emitLoad(arrSizeVar);
                code.emitAdd();
                code.emitStore(arrSizeVar);
            }
        }
        if (lastSplice >= 0) {
            code.emitLoad(arrSizeVar);
        }
        code.emitNewArray(elementType.getImplementationType());
        Variable offsetVar = null;
        for (int i = start; i < end; ++i) {
            code.emitDup();
            Expression arg = args[i];
            Expression argIfSplice = MakeSplice.argIfSplice(arg);
            if (argIfSplice != null) {
                if (offsetVar == null) {
                    offsetVar = code.addLocal(Type.intType);
                    code.emitPushInt(i - start);
                    code.emitStore(offsetVar);
                }
                code.emitLoad(offsetVar);
                code.emitLoad(sizeVars[i - start]);
                code.emitLoad(tmpVars[i - start]);
                if (elementType == Type.objectType) {
                    code.emitInvoke(copyToMethod4);
                } else {
                    comp.compileConstant(elementType, Target.pushObject);
                    code.emitInvoke(copyToMethod5);
                }
                code.emitLoad(offsetVar);
                code.emitLoad(sizeVars[i - start]);
                code.emitAdd();
                code.emitStore(offsetVar);
                continue;
            }
            if (offsetVar == null) {
                code.emitPushInt(i - start);
            } else {
                code.emitLoad(offsetVar);
            }
            Variable savedValue = tmpVars[i - start];
            if (savedValue != null) {
                code.emitLoad(savedValue);
            } else {
                arg.compile(comp, elementType);
            }
            code.emitArrayStore(elementType);
            if (offsetVar == null) continue;
            code.emitInc(offsetVar, (short)1);
        }
        code.popScope();
    }
}

