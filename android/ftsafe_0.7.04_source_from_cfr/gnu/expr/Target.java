/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.IgnoreTarget;
import gnu.expr.StackTarget;

public abstract class Target {
    public static final Target Ignore = new IgnoreTarget();
    public static final Target pushObject = new StackTarget(Type.pointer_type);

    public abstract Type getType();

    public abstract void compileFromStack(Compilation var1, Type var2);

    public static Target pushValue(Type type) {
        return type.isVoid() ? Ignore : StackTarget.getInstance(type);
    }
}

