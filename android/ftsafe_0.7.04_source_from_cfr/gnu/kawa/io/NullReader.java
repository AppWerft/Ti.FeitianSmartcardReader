/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import java.io.Reader;

public class NullReader
extends Reader {
    public static final NullReader nullReader = new NullReader();

    @Override
    public int read(char[] buffer, int offset, int length) {
        return -1;
    }

    @Override
    public boolean ready() {
        return true;
    }

    @Override
    public void close() {
    }
}

