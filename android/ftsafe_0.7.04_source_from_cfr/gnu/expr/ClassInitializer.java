/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Initializer;
import gnu.expr.LambdaExp;
import gnu.expr.Target;

public class ClassInitializer
extends Initializer {
    ClassExp cexp;

    public ClassInitializer(ClassExp cexp, Field field, Compilation comp) {
        this.field = field;
        this.cexp = cexp;
        if (field.getStaticFlag()) {
            this.next = comp.clinitChain;
            comp.clinitChain = this;
        } else {
            LambdaExp heapLambda = cexp.getOwningLambda();
            this.next = heapLambda.initChain;
            heapLambda.initChain = this;
        }
    }

    @Override
    public void emit(Compilation comp) {
        CodeAttr code = comp.getCode();
        if (!this.field.getStaticFlag()) {
            code.emitPushThis();
        }
        if (comp.immediate && this.field.getStaticFlag() && this.cexp.type != Type.javalangClassType) {
            comp.compileConstant(this.cexp.compiledType);
        } else {
            this.cexp.compilePushClass(comp, Target.pushValue(this.field.getType()));
        }
        if (this.field.getStaticFlag()) {
            code.emitPutStatic(this.field);
        } else {
            code.emitPutField(this.field);
        }
        if (this.cexp.compiledType == comp.mainClass && this.cexp.clinitMethod != null) {
            this.cexp.clinitMethod.body.compileWithPosition(comp, Target.Ignore);
        }
    }
}

