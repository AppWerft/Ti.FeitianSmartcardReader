// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.expr.Expression;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ArrayClassLoader;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.bytecode.Type;
import gnu.bytecode.Field;
import gnu.bytecode.ClassType;
import gnu.expr.Inlineable;
import gnu.mapping.Procedure1;

public class GetFieldProc extends Procedure1 implements Inlineable
{
    ClassType ctype;
    Field field;
    
    public GetFieldProc(final Class clas, final String fname) {
        this((ClassType)Type.make(clas), fname);
    }
    
    public GetFieldProc(final ClassType ctype, final String fname) {
        this.ctype = ctype;
        this.field = Field.searchField(ctype.getFields(), fname);
    }
    
    public GetFieldProc(final ClassType ctype, final String name, final Type ftype, final int flags) {
        this.ctype = ctype;
        this.field = ctype.getField(name);
        if (this.field == null) {
            this.field = ctype.addField(name, ftype, flags);
        }
    }
    
    @Override
    public Object apply1(final Object arg1) {
        try {
            final java.lang.reflect.Field reflectField = this.field.getReflectField();
            return reflectField.get(arg1);
        }
        catch (NoSuchFieldException ex) {
            throw new RuntimeException("no such field " + this.field.getSourceName() + " in " + this.ctype.getName());
        }
        catch (IllegalAccessException ex2) {
            throw new RuntimeException("illegal access for field " + this.field.getSourceName());
        }
    }
    
    private Field getField() {
        return this.field;
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final ClassLoader loader = this.ctype.getReflectClass().getClassLoader();
        if (loader instanceof ArrayClassLoader) {
            ApplyExp.compile(exp, comp, target);
            return;
        }
        exp.getArgs()[0].compile(comp, this.ctype);
        final CodeAttr code = comp.getCode();
        code.emitGetField(this.field);
        target.compileFromStack(comp, this.field.getType());
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return this.getField().getType();
    }
}
