/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;

public class IfState {
    IfState previous;
    boolean doing_else;
    Label end_label;
    boolean andThenSet;

    public IfState(CodeAttr code) {
        this(code, new Label(code));
    }

    public IfState(CodeAttr code, Label endLabel) {
        this.previous = code.if_stack;
        code.if_stack = this;
        this.end_label = endLabel;
    }
}

