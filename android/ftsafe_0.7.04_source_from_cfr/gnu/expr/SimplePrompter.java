/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.kawa.io.InPort;
import gnu.mapping.Procedure1;

class SimplePrompter
extends Procedure1 {
    public String prefix = "[";
    public String suffix = "] ";

    SimplePrompter() {
    }

    @Override
    public Object apply1(Object arg) {
        InPort port;
        int line;
        if (arg instanceof InPort && (line = (port = (InPort)arg).getLineNumber() + 1) >= 0) {
            return this.prefix + line + this.suffix;
        }
        return this.suffix;
    }
}

