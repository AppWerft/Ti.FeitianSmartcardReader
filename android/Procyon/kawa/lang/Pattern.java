// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.expr.Compilation;
import gnu.lists.Consumer;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.kawa.format.Printable;

public abstract class Pattern implements Printable
{
    public static ClassType typePattern;
    private static Type[] matchArgs;
    public static final Method matchPatternMethod;
    
    public Object[] match(final Object obj) {
        final Object[] vars = new Object[this.varCount()];
        return (Object[])(this.match(obj, vars, 0) ? vars : null);
    }
    
    public abstract boolean match(final Object p0, final Object[] p1, final int p2);
    
    public abstract int varCount();
    
    @Override
    public void print(final Consumer out) {
        out.write(this.toString());
    }
    
    static {
        Pattern.typePattern = ClassType.make("kawa.lang.Pattern");
        Pattern.matchArgs = new Type[] { Type.pointer_type, Compilation.objArrayType, Type.intType };
        matchPatternMethod = Pattern.typePattern.addMethod("match", Pattern.matchArgs, Type.booleanType, 1);
    }
}
