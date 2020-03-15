// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.kawa.reflect.LazyType;
import gnu.mapping.Values;
import gnu.bytecode.Type;
import gnu.bytecode.Method;
import gnu.bytecode.Label;

public class ConditionalTarget extends Target
{
    public Label ifTrue;
    public Label ifFalse;
    Language language;
    public static final Method isTrueMethod;
    public boolean trueBranchComesFirst;
    
    public ConditionalTarget(final Label ifTrue, final Label ifFalse, final Language language) {
        this.trueBranchComesFirst = true;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
        this.language = language;
    }
    
    @Override
    public Type getType() {
        return Type.booleanType;
    }
    
    @Override
    public void compileFromStack(final Compilation comp, Type stackType) {
        final CodeAttr code = comp.getCode();
        stackType = comp.asBooleanValue(this, stackType);
        if (stackType == null) {
            return;
        }
        final char sig = stackType.getSignature().charAt(0);
        if (this.language != null) {
            Object zero = null;
            switch (sig) {
                case 'B':
                case 'D':
                case 'F':
                case 'I':
                case 'J':
                case 'S': {
                    zero = 0;
                    break;
                }
                case 'C': {
                    zero = '\0';
                    break;
                }
                default: {
                    zero = null;
                    break;
                }
            }
            if (zero != null && this.language.booleanValue(zero) > 0) {
                code.emitPop(1);
                code.emitGoto(this.ifTrue);
                return;
            }
        }
        switch (sig) {
            case 'V': {
                final int voidValue = this.language.booleanValue(Values.empty);
                Label lab;
                if (voidValue > 0) {
                    lab = this.ifTrue;
                }
                else {
                    if (voidValue < 0) {
                        comp.error('e', "invalid void value in condition");
                    }
                    lab = this.ifFalse;
                }
                code.emitGoto(lab);
                return;
            }
            case 'J': {
                code.emitPushLong(0L);
                break;
            }
            case 'D': {
                code.emitPushDouble(0.0);
                break;
            }
            case 'F': {
                code.emitPushFloat(0.0f);
                break;
            }
            default: {
                if (this.trueBranchComesFirst) {
                    code.emitGotoIfIntEqZero(this.ifFalse);
                }
                else {
                    code.emitGotoIfIntNeZero(this.ifTrue);
                }
                this.emitGotoFirstBranch(code);
                return;
            }
            case 'L':
            case '[': {
                if (this.language.booleanValue(null) != 0) {
                    comp.compileConstant(this.language.booleanObject(false));
                    break;
                }
                if (Type.javalangBooleanType.compare(stackType) == -3 && !LazyType.maybeLazy(stackType)) {
                    comp.compileConstant(null);
                    break;
                }
                code.emitInvokeStatic(ConditionalTarget.isTrueMethod);
                if (this.trueBranchComesFirst) {
                    code.emitGotoIfIntEqZero(this.ifFalse);
                }
                else {
                    code.emitGotoIfIntNeZero(this.ifTrue);
                }
                this.emitGotoFirstBranch(code);
                return;
            }
        }
        if (this.trueBranchComesFirst) {
            code.emitGotoIfEq(this.ifFalse);
        }
        else {
            code.emitGotoIfNE(this.ifTrue);
        }
        this.emitGotoFirstBranch(code);
    }
    
    public final void emitGotoFirstBranch(final CodeAttr code) {
        code.emitGoto(this.trueBranchComesFirst ? this.ifTrue : this.ifFalse);
    }
    
    static {
        isTrueMethod = ClassType.make("gnu.expr.KawaConvert").getDeclaredMethod("isTrue", 1);
    }
}
