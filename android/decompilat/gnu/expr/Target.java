// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.Type;

public abstract class Target
{
    public static final Target Ignore;
    public static final Target pushObject;
    
    public abstract Type getType();
    
    public abstract void compileFromStack(final Compilation p0, final Type p1);
    
    public static Target pushValue(final Type type) {
        return type.isVoid() ? Target.Ignore : StackTarget.getInstance(type);
    }
    
    static {
        Ignore = new IgnoreTarget();
        pushObject = new StackTarget(Type.pointer_type);
    }
}
