/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.kawa.format.Printable;
import gnu.lists.Consumer;

public abstract class Pattern
implements Printable {
    public static ClassType typePattern = ClassType.make("kawa.lang.Pattern");
    private static Type[] matchArgs = new Type[]{Type.pointer_type, Compilation.objArrayType, Type.intType};
    public static final Method matchPatternMethod = typePattern.addMethod("match", matchArgs, Type.booleanType, 1);

    public Object[] match(Object obj) {
        Object[] vars = new Object[this.varCount()];
        return this.match(obj, vars, 0) ? vars : null;
    }

    public abstract boolean match(Object var1, Object[] var2, int var3);

    public abstract int varCount();

    @Override
    public void print(Consumer out) {
        out.write(this.toString());
    }
}

