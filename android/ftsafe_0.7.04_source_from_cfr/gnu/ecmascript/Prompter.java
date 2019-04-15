/*
 * Decompiled with CFR 0.139.
 */
package gnu.ecmascript;

import gnu.kawa.io.InPort;
import gnu.mapping.Procedure1;

class Prompter
extends Procedure1 {
    Prompter() {
    }

    String prompt(InPort port) {
        return "(EcmaScript:" + (port.getLineNumber() + 1) + ") ";
    }

    @Override
    public Object apply1(Object arg) {
        return this.prompt((InPort)arg);
    }
}

