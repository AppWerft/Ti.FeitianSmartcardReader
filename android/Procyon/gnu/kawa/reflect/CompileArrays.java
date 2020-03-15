// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.bytecode.Method;
import gnu.bytecode.Variable;
import gnu.bytecode.ClassType;
import gnu.kawa.functions.MakeSplice;
import gnu.mapping.Values;
import gnu.expr.StackTarget;
import gnu.bytecode.CodeAttr;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.bytecode.ArrayType;
import gnu.expr.Expression;
import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.ApplyExp;

public class CompileArrays
{
    public static Expression validateArrayNew(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        exp.setType(ArrayType.make(((ArrayNew)proc).element_type));
        return exp;
    }
    
    public static Expression validateArrayLength(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        exp.setType(LangPrimType.intType);
        return exp;
    }
    
    public static Expression validateArrayGet(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        exp.setType(((ArrayGet)proc).element_type);
        return exp;
    }
    
    public static Expression validateArraySet(final ApplyExp exp, final InlineCalls visitor, final Type required, final Procedure proc) {
        exp.visitArgs(visitor);
        exp.setType(Type.void_type);
        return exp;
    }
    
    public static boolean compileGet(final ApplyExp exp, final Compilation comp, final Target target, final Procedure proc) {
        if (!exp.isSimple()) {
            return false;
        }
        final Type element_type = ((ArrayGet)proc).element_type;
        final Expression[] args = exp.getArgs();
        args[0].compile(comp, ArrayType.make(element_type));
        args[1].compile(comp, Type.int_type);
        final CodeAttr code = comp.getCode();
        code.emitArrayLoad(element_type);
        target.compileFromStack(comp, element_type);
        return true;
    }
    
    public static boolean compileSet(final ApplyExp exp, final Compilation comp, final Target target, final Procedure proc) {
        if (!exp.isSimple()) {
            return false;
        }
        final Type element_type = ((ArraySet)proc).element_type;
        final Expression[] args = exp.getArgs();
        args[0].compile(comp, ArrayType.make(element_type));
        args[1].compile(comp, Type.int_type);
        final Target valueTarget = StackTarget.getTruncatingInstance(element_type);
        args[2].compile(comp, valueTarget);
        comp.getCode().emitArrayStore(element_type);
        comp.compileConstant(Values.empty, target);
        return true;
    }
    
    public static boolean compileNew(final ApplyExp exp, final Compilation comp, final Target target, final Procedure proc) {
        if (!exp.isSimple()) {
            return false;
        }
        final Type element_type = ((ArrayNew)proc).element_type;
        final CodeAttr code = comp.getCode();
        exp.getArgs()[0].compile(comp, Type.intType);
        code.emitNewArray(element_type.getImplementationType());
        target.compileFromStack(comp, ArrayType.make(element_type));
        return true;
    }
    
    public static boolean compileLength(final ApplyExp exp, final Compilation comp, final Target target, final Procedure proc) {
        if (!exp.isSimple()) {
            return false;
        }
        final Type element_type = ((ArrayLength)proc).element_type;
        exp.getArgs()[0].compile(comp, ArrayType.make(element_type));
        final CodeAttr code = comp.getCode();
        code.emitArrayLength();
        target.compileFromStack(comp, LangPrimType.intType);
        return true;
    }
    
    public static boolean compileMake(final ApplyExp exp, final Compilation comp, final Target target, final Procedure proc) {
        final Type elementType = ((ArrayMake)proc).elementType;
        final Expression[] args = exp.getArgs();
        createArray(elementType, comp, args, 0, args.length);
        target.compileFromStack(comp, ArrayType.make(elementType));
        return true;
    }
    
    public static void createArray(final Type elementType, final Compilation comp, final Expression[] args, final int start, final int end) {
        final CodeAttr code = comp.getCode();
        int countNonSplice = 0;
        int lastSplice = -1;
        for (int i = start; i < end; ++i) {
            if (MakeSplice.argIfSplice(args[i]) == null) {
                ++countNonSplice;
            }
            else {
                lastSplice = i;
            }
        }
        code.pushScope();
        code.emitPushInt(countNonSplice);
        Variable arrSizeVar;
        if (lastSplice < 0) {
            arrSizeVar = null;
        }
        else {
            arrSizeVar = code.addLocal(Type.intType);
            code.emitStore(arrSizeVar);
        }
        final ClassType utilType = ClassType.make("gnu.kawa.functions.MakeSplice");
        final Method countMethod = utilType.getDeclaredMethod("count", 1);
        final Method copyToMethod4 = utilType.getDeclaredMethod("copyTo", 4);
        final Method copyToMethod5 = utilType.getDeclaredMethod("copyTo", 5);
        final Variable[] tmpVars = new Variable[end - start];
        final Variable[] sizeVars = new Variable[end - start];
        if (lastSplice >= 0) {
            for (int j = start; j < end; ++j) {
                final Expression arg = args[j];
                final Expression argIfSplice = MakeSplice.argIfSplice(arg);
                if (argIfSplice != null || (arg.side_effects() && j < lastSplice)) {
                    if (argIfSplice != null) {
                        argIfSplice.compile(comp, Target.pushObject);
                    }
                    else {
                        arg.compile(comp, elementType);
                    }
                    final Variable tmpVar = code.addLocal((argIfSplice != null) ? Type.objectType : elementType);
                    code.emitStore(tmpVar);
                    tmpVars[j - start] = tmpVar;
                    if (argIfSplice != null) {
                        final Variable sizeVar = code.addLocal(Type.intType);
                        sizeVars[j - start] = sizeVar;
                        code.emitLoad(tmpVar);
                        code.emitInvoke(countMethod);
                        code.emitDup();
                        code.emitStore(sizeVar);
                        code.emitLoad(arrSizeVar);
                        code.emitAdd();
                        code.emitStore(arrSizeVar);
                    }
                }
            }
        }
        if (lastSplice >= 0) {
            code.emitLoad(arrSizeVar);
        }
        code.emitNewArray(elementType.getImplementationType());
        Variable offsetVar = null;
        for (int k = start; k < end; ++k) {
            code.emitDup();
            final Expression arg2 = args[k];
            final Expression argIfSplice2 = MakeSplice.argIfSplice(arg2);
            if (argIfSplice2 != null) {
                if (offsetVar == null) {
                    offsetVar = code.addLocal(Type.intType);
                    code.emitPushInt(k - start);
                    code.emitStore(offsetVar);
                }
                code.emitLoad(offsetVar);
                code.emitLoad(sizeVars[k - start]);
                code.emitLoad(tmpVars[k - start]);
                if (elementType == Type.objectType) {
                    code.emitInvoke(copyToMethod4);
                }
                else {
                    comp.compileConstant(elementType, Target.pushObject);
                    code.emitInvoke(copyToMethod5);
                }
                code.emitLoad(offsetVar);
                code.emitLoad(sizeVars[k - start]);
                code.emitAdd();
                code.emitStore(offsetVar);
            }
            else {
                if (offsetVar == null) {
                    code.emitPushInt(k - start);
                }
                else {
                    code.emitLoad(offsetVar);
                }
                final Variable savedValue = tmpVars[k - start];
                if (savedValue != null) {
                    code.emitLoad(savedValue);
                }
                else {
                    arg2.compile(comp, elementType);
                }
                code.emitArrayStore(elementType);
                if (offsetVar != null) {
                    code.emitInc(offsetVar, (short)1);
                }
            }
        }
        code.popScope();
    }
}
