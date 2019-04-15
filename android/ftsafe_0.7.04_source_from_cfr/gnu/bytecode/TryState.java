/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ExitableBlock;
import gnu.bytecode.Label;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;

public class TryState {
    TryState previous;
    Label end_label;
    Label finally_subr;
    Variable finally_ret_addr;
    Variable saved_result;
    Variable[] savedStack;
    Label start_try;
    Label end_try;
    ClassType try_type;
    Type[] savedTypes;
    ExitableBlock exitCases;
    Variable exception;
    boolean tryClauseDone;

    public TryState(CodeAttr code) {
        this.previous = code.try_stack;
        code.try_stack = this;
        this.start_try = code.getLabel();
    }

    static TryState outerHandler(TryState innerTry, TryState outerTry) {
        while (innerTry != outerTry && (innerTry.finally_subr == null || innerTry.tryClauseDone)) {
            innerTry = innerTry.previous;
        }
        return innerTry;
    }
}

