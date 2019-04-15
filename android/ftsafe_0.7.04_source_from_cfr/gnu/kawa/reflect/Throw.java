/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import gnu.mapping.Symbol;
import gnu.mapping.Values;

public class Throw
extends Procedure1
implements Inlineable {
    public static final Throw primitiveThrow = new Throw("throw");

    public Throw(String name) {
        super(name);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateThrow");
    }

    public static void doThrow(Object arg1) throws Throwable {
        throw (Throwable)arg1;
    }

    @Override
    public Object apply1(Object arg1) throws Throwable {
        Throw.doThrow(arg1);
        return Values.empty;
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        exp.getArgs()[0].compile(comp, Type.javalangThrowableType);
        comp.getCode().emitThrow();
    }
}

