// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

public class ExitableBlock
{
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
    
    ExitableBlock(final Type resultType, final CodeAttr code, final boolean runFinallyBlocks) {
        this.code = code;
        this.resultType = resultType;
        this.startStackSize = code.SP;
        this.initialTryState = code.try_stack;
        if (runFinallyBlocks && resultType != null) {
            code.pushScope();
            final Variable var = code.addLocal(resultType);
            code.emitStoreDefaultValue(this.resultVariable = var);
            this.switchCase = ++code.exitableBlockLevel;
        }
        this.endLabel = new Label(code);
    }
    
    void finish() {
        final boolean reachable = this.code.reachableHere();
        if (this.resultVariable != null && reachable) {
            this.code.emitStore(this.resultVariable);
        }
        this.endLabel.define(this.code);
        if (!reachable && !this.endLabel.needsStackMapEntry) {
            this.code.setUnreachable();
        }
        else if (this.resultVariable != null) {
            this.code.emitLoad(this.resultVariable);
        }
        if (this.resultVariable != null) {
            this.code.popScope();
            final CodeAttr code = this.code;
            --code.exitableBlockLevel;
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
    
    private void popStack(final CodeAttr code) {
        final int retSize = (this.resultVariable != null || this.resultType == null) ? 0 : ((this.resultType.size > 4) ? 2 : 1);
        if (code.SP == this.startStackSize + retSize) {
            return;
        }
        Variable resultVar;
        if (retSize > 0) {
            code.pushScope();
            resultVar = code.addLocal(this.resultType);
            code.emitStore(resultVar);
        }
        else {
            resultVar = null;
        }
        code.emitPop(code.SP - this.startStackSize);
        if (resultVar != null) {
            code.emitLoad(resultVar);
            code.popScope();
        }
    }
    
    void exit(final TryState activeTry) {
        if (!this.code.reachableHere()) {
            return;
        }
        this.popStack(this.code);
        if (activeTry == this.initialTryState) {
            this.code.emitGoto(this.endLabel);
        }
        else if (this.code.useJsr()) {
            for (TryState stack = this.code.try_stack; stack != this.initialTryState; stack = stack.previous) {
                if (stack.finally_subr != null && stack.finally_ret_addr == null) {
                    this.code.emitJsr(stack.finally_subr);
                }
            }
            this.code.emitGoto(this.endLabel);
        }
        else {
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
    
    void linkCase(final TryState tryState) {
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
