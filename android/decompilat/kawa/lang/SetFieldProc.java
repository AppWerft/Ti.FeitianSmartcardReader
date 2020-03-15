// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.bytecode.CodeAttr;
import gnu.expr.Expression;
import gnu.bytecode.ArrayClassLoader;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.mapping.Values;
import gnu.bytecode.Type;
import gnu.bytecode.Field;
import gnu.bytecode.ClassType;
import gnu.expr.Inlineable;
import gnu.mapping.Procedure2;

public class SetFieldProc extends Procedure2 implements Inlineable
{
    ClassType ctype;
    Field field;
    
    public SetFieldProc(final Class clas, final String fname) {
        this((ClassType)Type.make(clas), fname);
    }
    
    public SetFieldProc(final ClassType ctype, final String fname) {
        this.ctype = ctype;
        this.field = Field.searchField(ctype.getFields(), fname);
    }
    
    public SetFieldProc(final ClassType ctype, final String name, final Type ftype, final int flags) {
        this.ctype = ctype;
        this.field = ctype.getField(name);
        if (this.field == null) {
            this.field = ctype.addField(name, ftype, flags);
        }
    }
    
    @Override
    public Object apply2(final Object arg1, Object arg2) {
        try {
            final java.lang.reflect.Field reflectField = this.field.getReflectField();
            arg2 = this.field.getType().coerceFromObject(arg2);
            reflectField.set(arg1, arg2);
        }
        catch (NoSuchFieldException ex) {
            throw new RuntimeException("no such field " + this.field.getSourceName() + " in " + this.ctype.getName());
        }
        catch (IllegalAccessException ex2) {
            throw new RuntimeException("illegal access for field " + this.field.getSourceName());
        }
        return Values.empty;
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        final ClassLoader loader = this.ctype.getReflectClass().getClassLoader();
        if (loader instanceof ArrayClassLoader) {
            ApplyExp.compile(exp, comp, target);
            return;
        }
        final Expression[] args = exp.getArgs();
        args[0].compile(comp, this.ctype);
        args[1].compile(comp, this.field.getType());
        final CodeAttr code = comp.getCode();
        code.emitPutField(this.field);
        comp.compileConstant(Values.empty, target);
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return Type.voidType;
    }
}
