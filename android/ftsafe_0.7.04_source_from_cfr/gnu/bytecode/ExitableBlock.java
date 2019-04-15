/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Scope;
import gnu.bytecode.TryState;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;

public class ExitableBlock {
    Variable resultVariable;
    CodeAttr code;
    Type resultType;
    TryState initialTryState;
    Label endLabel;
    ExitableBlock outer;
    TryState currentTryState;
    ExitableBlock nextCase;
    int switchCase;
    int startStackSize;

    ExitableBlock(Type resultType, CodeAttr code, boolean runFinallyBlocks) {
        this.code = code;
        this.resultType = resultType;
        this.startStackSize = code.SP;
        this.initialTryState = code.try_stack;
        if (runFinallyBlocks && resultType != null) {
            Variable var;
            code.pushScope();
            this.resultVariable = var = code.addLocal(resultType);
            code.emitStoreDefaultValue(var);
            this.switchCase = ++code.exitableBlockLevel;
        }
        this.endLabel = new Label(code);
    }

    void finish() {
        boolean reachable = this.code.reachableHere();
        if (this.resultVariable != null && reachable) {
            this.code.emitStore(this.resultVariable);
        }
        this.endLabel.define(this.code);
        if (!reachable && !this.endLabel.needsStackMapEntry) {
            this.code.setUnreachable();
        } else if (this.resultVariable != null) {
            this.code.emitLoad(this.resultVariable);
        }
        if (this.resultVariable != null) {
            this.code.popScope();
            --this.code.exitableBlockLevel;
        }
    }

    public void exit() {
        if (this.resultVariable != null) {
            this.code.emitStore(this.resultVariable);
        }
        this.exit(TryState.outerHandler(this.code.try_stack, this.initialTryState));
    }

    public Label exitIsGoto() {
        if (TryState.outerHandler(this.code.try_stack, this.initialTryState) == this.initialTryState) {
            return this.endLabel;
        }
        return null;
    }

    private void popStack(CodeAttr code) {
        int retSize;
        Variable resultVar;
        int n = this.resultVariable != null || this.resultType == null ? 0 : (retSize = this.resultType.size > 4 ? 2 : 1);
        if (code.SP == this.startStackSize + retSize) {
            return;
        }
        if (retSize > 0) {
            code.pushScope();
            resultVar = code.addLocal(this.resultType);
            code.emitStore(resultVar);
        } else {
            resultVar = null;
        }
        code.emitPop(code.SP - this.startStackSize);
        if (resultVar != null) {
            code.emitLoad(resultVar);
            code.popScope();
        }
    }

    void exit(TryState activeTry) {
        if (!this.code.reachableHere()) {
            return;
        }
        this.popStack(this.code);
        if (activeTry == this.initialTryState) {
            this.code.emitGoto(this.endLabel);
        } else if (this.code.useJsr()) {
            TryState stack = this.code.try_stack;
            while (stack != this.initialTryState) {
                if (stack.finally_subr != null && stack.finally_ret_addr == null) {
                    this.code.emitJsr(stack.finally_subr);
                }
                stack = stack.previous;
            }
            this.code.emitGoto(this.endLabel);
        } else {
            if (this.currentTryState == null) {
                this.linkCase(activeTry);
            }
            if (activeTry.saved_result != null) {
                this.code.emitStoreDefaultValue(activeTry.saved_result);
            }
            this.code.emitPushInt(this.switchCase);
            this.code.emitPushNull();
            this.code.emitGoto(activeTry.finally_subr);
        }
    }

    void linkCase(TryState tryState) {
        if (this.currentTryState != tryState) {
            if (this.currentTryState != null) {
                throw new Error();
            }
            this.nextCase = tryState.exitCases;
            tryState.exitCases = this;
            this.currentTryState = tryState;
        }
    }
}

