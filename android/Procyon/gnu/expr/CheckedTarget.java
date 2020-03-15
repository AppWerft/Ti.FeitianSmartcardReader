// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.Scope;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Variable;
import gnu.bytecode.Type;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;

public class CheckedTarget extends StackTarget
{
    LambdaExp proc;
    String procname;
    int argno;
    static ClassType typeClassCastException;
    static ClassType typeWrongType;
    static Method initWrongTypeStringMethod;
    static Method initWrongTypeProcMethod;
    
    public CheckedTarget(final Type type) {
        super(type);
        this.argno = -4;
    }
    
    public CheckedTarget(final Type type, final LambdaExp proc, final int argno) {
        super(type);
        this.proc = proc;
        this.procname = proc.getName();
        this.argno = argno;
    }
    
    public CheckedTarget(final Type type, final String procname, final int argno) {
        super(type);
        this.procname = procname;
        this.argno = argno;
    }
    
    public static Target getInstance(final Type type, final String procname, final int argno) {
        return (type == Type.objectType) ? Target.pushObject : new CheckedTarget(type, procname, argno);
    }
    
    public static Target getInstance(final Type type, final LambdaExp proc, final int argno) {
        return (type == Type.objectType) ? Target.pushObject : new CheckedTarget(type, proc, argno);
    }
    
    public static Target getInstance(final Type type) {
        return (type == Type.objectType) ? Target.pushObject : new CheckedTarget(type);
    }
    
    public static Target getInstance(final Declaration decl) {
        final Type type = decl.getType();
        if (type == Type.objectType) {
            return Target.pushObject;
        }
        final StackTarget targ = new CheckedTarget(type, decl.getName(), -2);
        if (decl.field != null) {
            targ.autoTruncates = true;
        }
        return targ;
    }
    
    @Override
    protected StackTarget getClonedInstance(final Type type) {
        final CheckedTarget target = new CheckedTarget(type);
        target.procname = this.procname;
        target.proc = this.proc;
        target.argno = this.argno;
        return target;
    }
    
    private static void initWrongType() {
        if (CheckedTarget.typeClassCastException == null) {
            CheckedTarget.typeClassCastException = ClassType.make("java.lang.ClassCastException");
        }
        if (CheckedTarget.typeWrongType == null) {
            CheckedTarget.typeWrongType = ClassType.make("gnu.mapping.WrongType");
            Type[] args = { CheckedTarget.typeClassCastException, Compilation.javaStringType, Type.intType, Type.objectType };
            CheckedTarget.initWrongTypeStringMethod = CheckedTarget.typeWrongType.addMethod("<init>", 1, args, Type.voidType);
            args = new Type[] { CheckedTarget.typeClassCastException, Compilation.typeProcedure, Type.intType, Type.objectType };
            CheckedTarget.initWrongTypeProcMethod = CheckedTarget.typeWrongType.addMethod("<init>", 1, args, Type.voidType);
        }
    }
    
    @Override
    protected void doCoerce(final Compilation comp) {
        emitCheckedCoerce(comp, this.proc, this.procname, this.argno, this.type, null);
    }
    
    public static void emitCheckedCoerce(final Compilation comp, final String procname, final int argno, final Type type) {
        StackTarget.forceLazyIfNeeded(comp, Type.objectType, type);
        emitCheckedCoerce(comp, null, procname, argno, type, null);
    }
    
    public static void emitCheckedCoerce(final Compilation comp, final LambdaExp proc, final int argno, final Type stackType, final Type type, final Variable argValue) {
        StackTarget.forceLazyIfNeeded(comp, stackType, type);
        emitCheckedCoerce(comp, proc, proc.getName(), argno, type, argValue);
    }
    
    static void emitCheckedCoerce(final Compilation comp, final LambdaExp proc, final String procname, final int argno, final Type type, Variable argValue) {
        final CodeAttr code = comp.getCode();
        final boolean isInTry = code.isInTry();
        initWrongType();
        final Label startTry = new Label(code);
        Scope tmpScope;
        if (argValue == null && type != Type.toStringType) {
            tmpScope = code.pushScope();
            argValue = code.addLocal(Type.objectType);
            code.emitDup(1);
            code.emitStore(argValue);
        }
        else {
            tmpScope = null;
        }
        final int startPC = code.getPC();
        startTry.define(code);
        StackTarget.emitCoerceFromObject(type, comp);
        final int endPC = code.getPC();
        if (endPC == startPC || type == Type.toStringType) {
            if (tmpScope != null) {
                code.popScope();
            }
            return;
        }
        final Label endTry = new Label(code);
        endTry.define(code);
        final Label endLabel = new Label(code);
        endLabel.setTypes(code);
        if (isInTry) {
            code.emitGoto(endLabel);
        }
        int fragment_cookie = 0;
        code.setUnreachable();
        if (!isInTry) {
            fragment_cookie = code.beginFragment(endLabel);
        }
        code.addHandler(startTry, endTry, CheckedTarget.typeClassCastException);
        boolean thisIsProc = false;
        if (proc != null && proc.isClassGenerated() && !comp.method.getStaticFlag() && comp.method.getDeclaringClass() == proc.getCompiledClassType(comp)) {
            thisIsProc = true;
        }
        final int line = comp.getLineNumber();
        if (line > 0) {
            code.putLineNumber(line);
        }
        code.emitNew(CheckedTarget.typeWrongType);
        code.emitDupX();
        code.emitSwap();
        if (thisIsProc) {
            code.emitPushThis();
        }
        else {
            code.emitPushString((procname == null && argno != -4) ? "lambda" : procname);
        }
        code.emitPushInt(argno);
        code.emitLoad(argValue);
        code.emitInvokeSpecial(thisIsProc ? CheckedTarget.initWrongTypeProcMethod : CheckedTarget.initWrongTypeStringMethod);
        if (tmpScope != null) {
            code.popScope();
        }
        code.emitThrow();
        if (isInTry) {
            endLabel.define(code);
        }
        else {
            code.endFragment(fragment_cookie);
        }
    }
}
