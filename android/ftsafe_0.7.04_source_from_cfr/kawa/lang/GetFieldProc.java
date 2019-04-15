/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.Procedure1;
import java.lang.reflect.Field;

public class GetFieldProc
extends Procedure1
implements Inlineable {
    ClassType ctype;
    gnu.bytecode.Field field;

    public GetFieldProc(Class clas, String fname) {
        this((ClassType)Type.make(clas), fname);
    }

    public GetFieldProc(ClassType ctype, String fname) {
        this.ctype = ctype;
        this.field = gnu.bytecode.Field.searchField(ctype.getFields(), fname);
    }

    public GetFieldProc(ClassType ctype, String name, Type ftype, int flags) {
        this.ctype = ctype;
        this.field = ctype.getField(name);
        if (this.field == null) {
            this.field = ctype.addField(name, ftype, flags);
        }
    }

    @Override
    public Object apply1(Object arg1) {
        try {
            Field reflectField = this.field.getReflectField();
            return reflectField.get(arg1);
        }
        catch (NoSuchFieldException ex) {
            throw new RuntimeException("no such field " + this.field.getSourceName() + " in " + this.ctype.getName());
        }
        catch (IllegalAccessException ex) {
            throw new RuntimeException("illegal access for field " + this.field.getSourceName());
        }
    }

    private gnu.bytecode.Field getField() {
        return this.field;
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        ClassLoader loader = this.ctype.getReflectClass().getClassLoader();
        if (loader instanceof ArrayClassLoader) {
            ApplyExp.compile(exp, comp, target);
            return;
        }
        exp.getArgs()[0].compile(comp, this.ctype);
        CodeAttr code = comp.getCode();
        code.emitGetField(this.field);
        target.compileFromStack(comp, this.field.getType());
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return this.getField().getType();
    }
}

