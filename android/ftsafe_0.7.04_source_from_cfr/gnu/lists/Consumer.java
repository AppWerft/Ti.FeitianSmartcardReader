/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

public interface Consumer
extends Appendable {
    public void writeBoolean(boolean var1);

    public void writeFloat(float var1);

    public void writeDouble(double var1);

    public void writeInt(int var1);

    public void writeLong(long var1);

    public void startDocument();

    public void endDocument();

    public void startElement(Object var1);

    public void endElement();

    public void startAttribute(Object var1);

    public void endAttribute();

    public void writeObject(Object var1);

    public boolean ignoring();

    public void write(int var1);

    public void write(String var1);

    public void write(CharSequence var1, int var2, int var3);

    public void write(char[] var1, int var2, int var3);

    @Override
    public Consumer append(char var1);

    @Override
    public Consumer append(CharSequence var1);

    @Override
    public Consumer append(CharSequence var1, int var2, int var3);
}

