/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractCharVector;
import gnu.lists.SimpleVector;

public class CharVector
extends AbstractCharVector<Character> {
    public CharVector(char[] values) {
        this.data = values;
    }

    @Override
    public final Character getRaw(int index) {
        return Character.valueOf(this.data[index]);
    }

    @Override
    public final void setRaw(int index, Character value) {
        this.data[index] = value.charValue();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CharVector && CharVector.equals(this, (CharVector)obj);
    }

    @Override
    protected CharVector newInstance(int newLength) {
        return new CharVector(newLength < 0 ? this.data : new char[newLength]);
    }

    @Override
    public int getElementKind() {
        return 29;
    }

    @Override
    public String getTag() {
        return "c16";
    }
}

