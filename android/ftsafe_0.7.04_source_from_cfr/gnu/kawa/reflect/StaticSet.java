/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;
import java.lang.reflect.Field;

public class StaticSet
extends Procedure1
implements Inlineable {
    ClassType ctype;
    String fname;
    gnu.bytecode.Field field;
    Field reflectField;

    StaticSet(Class clas, String fname) {
        this.ctype = (ClassType)Type.make(clas);
        this.fname = fname;
    }

    public StaticSet(ClassType ctype, String name, Type ftype, int flags) {
        this.ctype = ctype;
        this.fname = name;
        this.field = ctype.getField(name);
        if (this.field == null) {
            this.field = ctype.addField(name, ftype, flags);
        }
    }

    @Override
    public Object apply1(Object arg1) {
        if (this.reflectField == null) {
            Class clas = this.ctype.getReflectClass();
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
        catch (IllegalAccessException ex) {
            throw new RuntimeException("illegal access for field " + this.fname);
        }
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        if (this.field == null) {
            this.field = this.ctype.getField(this.fname);
            if (this.field == null) {
                this.field = this.ctype.addField(this.fname, Type.make(this.reflectField.getType()), this.reflectField.getModifiers());
            }
        }
        exp.getArgs()[0].compile(comp, this.field.getType());
        CodeAttr code = comp.getCode();
        code.emitPutStatic(this.field);
        comp.compileConstant(Values.empty, target);
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return Type.voidType;
    }
}

