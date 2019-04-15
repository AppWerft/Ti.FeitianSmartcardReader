/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.expr.QuoteExp;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure0;
import gnu.mapping.Symbol;

public class ConstantFunction0
extends Procedure0 {
    final Object value;
    final QuoteExp constant;

    public ConstantFunction0(String name, Object value) {
        this(name, QuoteExp.getInstance(value));
    }

    public ConstantFunction0(String name, QuoteExp constant) {
        super(name);
        this.value = constant.getValue();
        this.constant = constant;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyConstantFunction0");
    }

    @Override
    public Object apply0() {
        return this.value;
    }
}

