// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;

public class IgnoreTarget extends Target
{
    @Override
    public Type getType() {
        return Type.voidType;
    }
    
    @Override
    public void compileFromStack(final Compilation comp, final Type stackType) {
        if (!stackType.isVoid()) {
            final CodeAttr code = comp.getCode();
            if (code.reachableHere()) {
                code.emitPop(1);
            }
        }
    }
}
