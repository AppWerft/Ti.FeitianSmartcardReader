/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.Target;
import gnu.kawa.reflect.LazyType;
import gnu.mapping.Values;

public class ConditionalTarget
extends Target {
    public Label ifTrue;
    public Label ifFalse;
    Language language;
    public static final Method isTrueMethod = ClassType.make("gnu.expr.KawaConvert").getDeclaredMethod("isTrue", 1);
    public boolean trueBranchComesFirst = true;

    public ConditionalTarget(Label ifTrue, Label ifFalse, Language language) {
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
        this.language = language;
    }

    @Override
    public Type getType() {
        return Type.booleanType;
    }

    @Override
    public void compileFromStack(Compilation comp, Type stackType) {
        CodeAttr code = comp.getCode();
        if ((stackType = comp.asBooleanValue(this, stackType)) == null) {
            return;
        }
        char sig = stackType.getSignature().charAt(0);
        if (this.language != null) {
            Comparable<Integer> zero;
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
                    zero = Character.valueOf('\u0000');
                    break;
                }
                default: {
                    zero = null;
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
                Label lab;
                int voidValue = this.language.booleanValue(Values.empty);
                if (voidValue > 0) {
                    lab = this.ifTrue;
                } else {
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
                } else {
                    code.emitGotoIfIntNeZero(this.ifTrue);
                }
                this.emitGotoFirstBranch(code);
                return;
            }
            case 'L': 
            case '[': {
                if (this.language.booleanValue(null) == 0) {
                    if (Type.javalangBooleanType.compare(stackType) == -3 && !LazyType.maybeLazy(stackType)) {
                        comp.compileConstant(null);
                        break;
                    }
                    code.emitInvokeStatic(isTrueMethod);
                    if (this.trueBranchComesFirst) {
                        code.emitGotoIfIntEqZero(this.ifFalse);
                    } else {
                        code.emitGotoIfIntNeZero(this.ifTrue);
                    }
                    this.emitGotoFirstBranch(code);
                    return;
                }
                comp.compileConstant(this.language.booleanObject(false));
            }
        }
        if (this.trueBranchComesFirst) {
            code.emitGotoIfEq(this.ifFalse);
        } else {
            code.emitGotoIfNE(this.ifTrue);
        }
        this.emitGotoFirstBranch(code);
    }

    public final void emitGotoFirstBranch(CodeAttr code) {
        code.emitGoto(this.trueBranchComesFirst ? this.ifTrue : this.ifFalse);
    }
}

