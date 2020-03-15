// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.bytecode.Field;

public class ClassInitializer extends Initializer
{
    ClassExp cexp;
    
    public ClassInitializer(final ClassExp cexp, final Field field, final Compilation comp) {
        this.field = field;
        this.cexp = cexp;
        if (field.getStaticFlag()) {
            this.next = comp.clinitChain;
            comp.clinitChain = this;
        }
        else {
            final LambdaExp heapLambda = cexp.getOwningLambda();
            this.next = heapLambda.initChain;
            heapLambda.initChain = this;
        }
    }
    
    @Override
    public void emit(final Compilation comp) {
        final CodeAttr code = comp.getCode();
        if (!this.field.getStaticFlag()) {
            code.emitPushThis();
        }
        if (comp.immediate && this.field.getStaticFlag() && this.cexp.type != Type.javalangClassType) {
            comp.compileConstant(this.cexp.compiledType);
        }
        else {
            this.cexp.compilePushClass(comp, Target.pushValue(this.field.getType()));
        }
        if (this.field.getStaticFlag()) {
            code.emitPutStatic(this.field);
        }
        else {
            code.emitPutField(this.field);
        }
        if (this.cexp.compiledType == comp.mainClass && this.cexp.clinitMethod != null) {
            this.cexp.clinitMethod.body.compileWithPosition(comp, Target.Ignore);
        }
    }
}
