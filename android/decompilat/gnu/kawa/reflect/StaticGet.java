// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.expr.Expression;
import gnu.bytecode.CodeAttr;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.bytecode.Type;
import gnu.bytecode.Field;
import gnu.bytecode.ClassType;
import gnu.expr.Inlineable;
import gnu.mapping.Procedure0;

public class StaticGet extends Procedure0 implements Inlineable
{
    ClassType ctype;
    String fname;
    Field field;
    java.lang.reflect.Field reflectField;
    
    StaticGet(final Class clas, final String fname) {
        this.ctype = (ClassType)Type.make(clas);
        this.fname = fname;
    }
    
    public StaticGet(final ClassType ctype, final String name, final Type ftype, final int flags) {
        this.ctype = ctype;
        this.fname = name;
        this.field = ctype.getField(name);
        if (this.field == null) {
            this.field = ctype.addField(name, ftype, flags);
        }
    }
    
    @Override
    public Object apply0() {
        if (this.reflectField == null) {
            final Class clas = this.ctype.getReflectClass();
            try {
                this.reflectField = clas.getField(this.fname);
            }
            catch (NoSuchFieldException ex) {
                throw new RuntimeException("no such field " + this.fname + " in " + clas.getName());
            }
        }
        try {
            return this.reflectField.get(null);
        }
        catch (IllegalAccessException ex2) {
            throw new RuntimeException("illegal access for field " + this.fname);
        }
    }
    
    private Field getField() {
        if (this.field == null) {
            this.field = this.ctype.getField(this.fname);
            if (this.field == null) {
                this.field = this.ctype.addField(this.fname, Type.make(this.reflectField.getType()), this.reflectField.getModifiers());
            }
        }
        return this.field;
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        this.getField();
        final CodeAttr code = comp.getCode();
        code.emitGetStatic(this.field);
        target.compileFromStack(comp, this.field.getType());
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return this.getField().getType();
    }
}
