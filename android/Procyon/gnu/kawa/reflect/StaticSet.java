// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.expr.Expression;
import gnu.bytecode.CodeAttr;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.mapping.Values;
import gnu.bytecode.Type;
import gnu.bytecode.Field;
import gnu.bytecode.ClassType;
import gnu.expr.Inlineable;
import gnu.mapping.Procedure1;

public class StaticSet extends Procedure1 implements Inlineable
{
    ClassType ctype;
    String fname;
    Field field;
    java.lang.reflect.Field reflectField;
    
    StaticSet(final Class clas, final String fname) {
        this.ctype = (ClassType)Type.make(clas);
        this.fname = fname;
    }
    
    public StaticSet(final ClassType ctype, final String name, final Type ftype, final int flags) {
        this.ctype = ctype;
        this.fname = name;
        this.field = ctype.getField(name);
        if (this.field == null) {
            this.field = ctype.addField(name, ftype, flags);
        }
    }
    
    @Override
    public Object apply1(final Object arg1) {
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
            this.reflectField.set(null, arg1);
            return Values.empty;
        }
        catch (IllegalAccessException ex2) {
            throw new RuntimeException("illegal access for field " + this.fname);
        }
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        if (this.field == null) {
            this.field = this.ctype.getField(this.fname);
            if (this.field == null) {
                this.field = this.ctype.addField(this.fname, Type.make(this.reflectField.getType()), this.reflectField.getModifiers());
            }
        }
        exp.getArgs()[0].compile(comp, this.field.getType());
        final CodeAttr code = comp.getCode();
        code.emitPutStatic(this.field);
        comp.compileConstant(Values.empty, target);
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return Type.voidType;
    }
}
