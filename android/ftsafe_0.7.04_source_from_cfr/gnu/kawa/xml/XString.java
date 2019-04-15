/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.XStringType;

public class XString
implements CharSequence {
    public String text;
    private XStringType type;

    public XStringType getStringType() {
        return this.type;
    }

    @Override
    public char charAt(int index) {
        return this.text.charAt(index);
    }

    @Override
    public int length() {
        return this.text.length();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.text.substring(start, end);
    }

    @Override
    public String toString() {
        return this.text;
    }

    XString(String text, XStringType type) {
        this.text = text;
        this.type = type;
    }
}

