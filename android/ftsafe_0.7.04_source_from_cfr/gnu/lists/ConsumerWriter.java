/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumer;
import java.io.Writer;

public class ConsumerWriter
extends Writer {
    protected Consumer out;

    public ConsumerWriter(Consumer out) {
        this.out = out;
    }

    @Override
    public void write(char[] buffer, int offset, int length) {
        this.out.write(buffer, offset, length);
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() {
        this.flush();
    }

    public void finalize() {
        this.close();
    }
}

