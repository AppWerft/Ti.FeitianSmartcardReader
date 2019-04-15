/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import java.lang.reflect.Field;

public class SetFieldProc
extends Procedure2
implements Inlineable {
    ClassType ctype;
    gnu.bytecode.Field field;

    public SetFieldProc(Class clas, String fname) {
        this((ClassType)Type.make(clas), fname);
    }

    public SetFieldProc(ClassType ctype, String fname) {
        this.ctype = ctype;
        this.field = gnu.bytecode.Field.searchField(ctype.getFields(), fname);
    }

    public SetFieldProc(ClassType ctype, String name, Type ftype, int flags) {
        this.ctype = ctype;
        this.field = ctype.getField(name);
        if (this.field == null) {
            this.field = ctype.addField(name, ftype, flags);
        }
    }

    @Override
    public Object apply2(Object arg1, Object arg2) {
        try {
            Field reflectField = this.field.getReflectField();
            arg2 = this.field.getType().coerceFromObject(arg2);
            reflectField.set(arg1, arg2);
        }
        catch (NoSuchFieldException ex) {
            throw new RuntimeException("no such field " + this.field.getSourceName() + " in " + this.ctype.getName());
        }
        catch (IllegalAccessException ex) {
            throw new RuntimeException("illegal access for field " + this.field.getSourceName());
        }
        return Values.empty;
    }

    @Override
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        ClassLoader loader = this.ctype.getReflectClass().getClassLoader();
        if (loader instanceof ArrayClassLoader) {
            ApplyExp.compile(exp, comp, target);
            return;
        }
        Expression[] args = exp.getArgs();
        args[0].compile(comp, this.ctype);
        args[1].compile(comp, this.field.getType());
        CodeAttr code = comp.getCode();
        code.emitPutField(this.field);
        comp.compileConstant(Values.empty, target);
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return Type.voidType;
    }
}

