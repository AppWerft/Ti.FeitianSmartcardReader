/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.LambdaExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;

public class CheckedTarget
extends StackTarget {
    LambdaExp proc;
    String procname;
    int argno;
    static ClassType typeClassCastException;
    static ClassType typeWrongType;
    static Method initWrongTypeStringMethod;
    static Method initWrongTypeProcMethod;

    public CheckedTarget(Type type) {
        super(type);
        this.argno = -4;
    }

    public CheckedTarget(Type type, LambdaExp proc, int argno) {
        super(type);
        this.proc = proc;
        this.procname = proc.getName();
        this.argno = argno;
    }

    public CheckedTarget(Type type, String procname, int argno) {
        super(type);
        this.procname = procname;
        this.argno = argno;
    }

    public static Target getInstance(Type type, String procname, int argno) {
        return type == Type.objectType ? Target.pushObject : new CheckedTarget(type, procname, argno);
    }

    public static Target getInstance(Type type, LambdaExp proc, int argno) {
        return type == Type.objectType ? Target.pushObject : new CheckedTarget(type, proc, argno);
    }

    public static Target getInstance(Type type) {
        return type == Type.objectType ? Target.pushObject : new CheckedTarget(type);
    }

    public static Target getInstance(Declaration decl) {
        Type type = decl.getType();
        if (type == Type.objectType) {
            return Target.pushObject;
        }
        CheckedTarget targ = new CheckedTarget(type, decl.getName(), -2);
        if (decl.field != null) {
            targ.autoTruncates = true;
        }
        return targ;
    }

    @Override
    protected StackTarget getClonedInstance(Type type) {
        CheckedTarget target = new CheckedTarget(type);
        target.procname = this.procname;
        target.proc = this.proc;
        target.argno = this.argno;
        return target;
    }

    private static void initWrongType() {
        if (typeClassCastException == null) {
            typeClassCastException = ClassType.make("java.lang.ClassCastException");
        }
        if (typeWrongType == null) {
            typeWrongType = ClassType.make("gnu.mapping.WrongType");
            Type[] args = new Type[]{typeClassCastException, Compilation.javaStringType, Type.intType, Type.objectType};
            initWrongTypeStringMethod = typeWrongType.addMethod("<init>", 1, args, Type.voidType);
            args = new Type[]{typeClassCastException, Compilation.typeProcedure, Type.intType, Type.objectType};
            initWrongTypeProcMethod = typeWrongType.addMethod("<init>", 1, args, Type.voidType);
        }
    }

    @Override
    protected void doCoerce(Compilation comp) {
        CheckedTarget.emitCheckedCoerce(comp, this.proc, this.procname, this.argno, this.type, null);
    }

    public static void emitCheckedCoerce(Compilation comp, String procname, int argno, Type type) {
        CheckedTarget.forceLazyIfNeeded(comp, Type.objectType, type);
        CheckedTarget.emitCheckedCoerce(comp, null, procname, argno, type, null);
    }

    public static void emitCheckedCoerce(Compilation comp, LambdaExp proc, int argno, Type stackType, Type type, Variable argValue) {
        CheckedTarget.forceLazyIfNeeded(comp, stackType, type);
        CheckedTarget.emitCheckedCoerce(comp, proc, proc.getName(), argno, type, argValue);
    }

    static void emitCheckedCoerce(Compilation comp, LambdaExp proc, String procname, int argno, Type type, Variable argValue) {
        int line;
        Scope tmpScope;
        CodeAttr code = comp.getCode();
        boolean isInTry = code.isInTry();
        CheckedTarget.initWrongType();
        Label startTry = new Label(code);
        if (argValue == null && type != Type.toStringType) {
            tmpScope = code.pushScope();
            argValue = code.addLocal(Type.objectType);
            code.emitDup(1);
            code.emitStore(argValue);
        } else {
            tmpScope = null;
        }
        int startPC = code.getPC();
        startTry.define(code);
        CheckedTarget.emitCoerceFromObject(type, comp);
        int endPC = code.getPC();
        if (endPC == startPC || type == Type.toStringType) {
            if (tmpScope != null) {
                code.popScope();
            }
            return;
        }
        Label endTry = new Label(code);
        endTry.define(code);
        Label endLabel = new Label(code);
        endLabel.setTypes(code);
        if (isInTry) {
            code.emitGoto(endLabel);
        }
        int fragment_cookie = 0;
        code.setUnreachable();
        if (!isInTry) {
            fragment_cookie = code.beginFragment(endLabel);
        }
        code.addHandler(startTry, endTry, typeClassCastException);
        boolean thisIsProc = false;
        if (proc != null && proc.isClassGenerated() && !comp.method.getStaticFlag() && comp.method.getDeclaringClass() == proc.getCompiledClassType(comp)) {
            thisIsProc = true;
        }
        if ((line = comp.getLineNumber()) > 0) {
            code.putLineNumber(line);
        }
        code.emitNew(typeWrongType);
        code.emitDupX();
        code.emitSwap();
        if (thisIsProc) {
            code.emitPushThis();
        } else {
            code.emitPushString(procname == null && argno != -4 ? "lambda" : procname);
        }
        code.emitPushInt(argno);
        code.emitLoad(argValue);
        code.emitInvokeSpecial(thisIsProc ? initWrongTypeProcMethod : initWrongTypeStringMethod);
        if (tmpScope != null) {
            code.popScope();
        }
        code.emitThrow();
        if (isInTry) {
            endLabel.define(code);
        } else {
            code.endFragment(fragment_cookie);
        }
    }
}

