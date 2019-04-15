/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.Field;
import gnu.expr.Compilation;

public abstract class Initializer {
    Initializer next;
    public Field field;

    public abstract void emit(Compilation var1);

    public static Initializer reverse(Initializer list) {
        Initializer prev = null;
        while (list != null) {
            Initializer next = list.next;
            list.next = prev;
            prev = list;
            list = next;
        }
        return prev;
    }

    public void reportError(String message, Compilation comp) {
        comp.error('e', message + "field " + this.field);
    }
}

