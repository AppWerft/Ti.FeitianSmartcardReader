/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class char_ready_p {
    public static boolean ready(Object arg1) {
        try {
            if (arg1 instanceof InputStream) {
                return ((InputStream)arg1).available() > 0;
            }
            if (arg1 instanceof Reader) {
                return ((Reader)arg1).ready();
            }
            throw new ClassCastException("invalid argument to char-ready?");
        }
        catch (IOException ex) {
            return false;
        }
    }
}

