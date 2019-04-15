/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumer;
import gnu.lists.Sequence;
import gnu.text.Char;
import java.io.IOException;

public interface CharSeq
extends CharSequence,
Sequence<Char> {
    @Override
    public int length();

    @Override
    public char charAt(int var1);

    public void getChars(int var1, int var2, char[] var3, int var4);

    public void setCharAt(int var1, char var2);

    public void setCharacterAt(int var1, int var2);

    @Override
    public void fill(char var1);

    public void fill(int var1, int var2, char var3);

    @Override
    public CharSeq subSequence(int var1, int var2);

    public void writeTo(int var1, int var2, Appendable var3) throws IOException;

    public void writeTo(Appendable var1) throws IOException;

    public void consume(int var1, int var2, Consumer var3);

    @Override
    public String toString();
}

