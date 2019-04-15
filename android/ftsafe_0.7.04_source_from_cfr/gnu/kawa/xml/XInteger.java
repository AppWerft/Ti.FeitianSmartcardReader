/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.XIntegerType;
import gnu.math.IntNum;

public class XInteger
extends IntNum {
    private XIntegerType type;

    public XIntegerType getIntegerType() {
        return this.type;
    }

    XInteger(IntNum value, XIntegerType type) {
        this.words = value.words;
        this.ival = value.ival;
        this.type = type;
    }
}

