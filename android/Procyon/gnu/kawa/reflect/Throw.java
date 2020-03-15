// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.bytecode.Type;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.mapping.Values;
import gnu.mapping.Procedure;
import gnu.expr.Inlineable;
import gnu.mapping.Procedure1;

public class Throw extends Procedure1 implements Inlineable
{
    public static final Throw primitiveThrow;
    
    public Throw(final String name) {
        super(name);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateThrow");
    }
    
    public static void doThrow(final Object arg1) throws Throwable {
        throw (Throwable)arg1;
    }
    
    @Override
    public Object apply1(final Object arg1) throws Throwable {
        doThrow(arg1);
        return Values.empty;
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        exp.getArgs()[0].compile(comp, Type.javalangThrowableType);
        comp.getCode().emitThrow();
    }
    
    static {
        primitiveThrow = new Throw("throw");
    }
}
