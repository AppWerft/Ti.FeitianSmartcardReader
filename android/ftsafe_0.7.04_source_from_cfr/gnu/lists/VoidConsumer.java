/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumer;
import gnu.lists.FilterConsumer;

public class VoidConsumer
extends FilterConsumer {
    public static VoidConsumer instance = new VoidConsumer();

    public static VoidConsumer getInstance() {
        return instance;
    }

    public VoidConsumer() {
        super(null);
        this.skipping = true;
    }

    public VoidConsumer(Consumer out) {
        super(out);
        this.skipping = true;
    }

    public static VoidConsumer make(Consumer old) {
        return new VoidConsumer(old);
    }

    @Override
    public boolean ignoring() {
        return true;
    }
}

