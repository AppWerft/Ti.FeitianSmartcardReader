/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Target;

public class IgnoreTarget
extends Target {
    @Override
    public Type getType() {
        return Type.voidType;
    }

    @Override
    public void compileFromStack(Compilation comp, Type stackType) {
        CodeAttr code;
        if (!stackType.isVoid() && (code = comp.getCode()).reachableHere()) {
            code.emitPop(1);
        }
    }
}

