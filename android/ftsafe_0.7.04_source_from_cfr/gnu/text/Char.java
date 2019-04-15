/*
 * Decompiled with CFR 0.139.
 */
package gnu.text;

import gnu.kawa.util.AbstractWeakHashTable;
import gnu.lists.Consumer;
import gnu.lists.Sequence;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Map;

public class Char
implements Comparable,
Externalizable {
    int value;
    public static final int IGNORABLE_CHAR = 2097151;
    static Char[] ascii;
    static CharMap hashTable;
    private static String charNameValues;
    static String[] charNames;

    public Char() {
    }

    Char(int ch) {
        this.value = ch;
    }

    public void print(Consumer out) {
        Char.print(this.value, out);
    }

    public static char castToChar(Object obj) {
        if (obj instanceof Char) {
            return ((Char)obj).charValue();
        }
        return ((Character)obj).charValue();
    }

    public static int castToCharacter(Object obj) {
        if (obj instanceof Char) {
            return ((Char)obj).intValue();
        }
        return ((Character)obj).charValue();
    }

    public static int castToCharacterOrEof(Object obj) {
        if (obj == Sequence.eofValue) {
            return -1;
        }
        return Char.castToCharacter(obj);
    }

    public static boolean isChar(Object obj) {
        return obj instanceof Char || obj instanceof Character;
    }

    public static boolean isCharOrEof(Object obj) {
        return obj instanceof Char || obj instanceof Character || obj == Sequence.eofValue;
    }

    public static int checkCharOrEof(Object obj) {
        if (obj instanceof Char) {
            return ((Char)obj).intValue();
        }
        if (obj instanceof Character) {
            return ((Character)obj).charValue();
        }
        if (obj == Sequence.eofValue) {
            return -1;
        }
        return -2;
    }

    public static void print(int i, Appendable out) {
        try {
            Char.append(i, out);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void append(int i, Appendable out) throws IOException {
        if (i >= 65536 && i != 2097151) {
            out.append((char)((i - 65536 >> 10) + 55296));
            i = (i & 1023) + 56320;
        }
        out.append((char)i);
    }

    public final char charValue() {
        return (char)this.value;
    }

    public final int intValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Char valueOf(int ch) {
        if (ch < 128) {
            return ascii[ch];
        }
        CharMap charMap = hashTable;
        synchronized (charMap) {
            return hashTable.get(ch);
        }
    }

    public static Char make(int ch) {
        return Char.valueOf(ch);
    }

    public static Object makeOrEof(int ch) {
        if (ch < 0) {
            return Sequence.eofValue;
        }
        return Char.make(ch);
    }

    public boolean equals(Object obj) {
        return obj != null && obj instanceof Char && ((Char)obj).intValue() == this.value;
    }

    public static void addNamedChars(Map<String, String> map) {
        int i = charNames.length;
        while (--i >= 0) {
            map.put(charNames[i], charNameValues.substring(i, i + 1));
        }
    }

    public static int nameToChar(String name) {
        char ch;
        int i = charNames.length;
        while (--i >= 0) {
            if (!charNames[i].equals(name)) continue;
            return charNameValues.charAt(i);
        }
        i = charNames.length;
        while (--i >= 0) {
            if (!charNames[i].equalsIgnoreCase(name)) continue;
            return charNameValues.charAt(i);
        }
        if ("ignorable-char".equalsIgnoreCase(name)) {
            return 2097151;
        }
        int len = name.length();
        if (len > 1 && name.charAt(0) == 'u') {
            int value = 0;
            int pos = 1;
            do {
                if (pos == len) {
                    return value;
                }
                int dig = Character.digit(name.charAt(pos), 16);
                if (dig < 0) break;
                value = (value << 4) + dig;
                ++pos;
            } while (true);
        }
        if (len == 3 && name.charAt(1) == '-' && ((ch = name.charAt(0)) == 'c' || ch == 'C')) {
            ch = name.charAt(2);
            return ch & 31;
        }
        return -1;
    }

    public String toString() {
        return Char.toString(this.value);
    }

    public static String toString(int value) {
        StringBuffer buf = new StringBuffer();
        buf.append('\'');
        if (value >= 32 && value < 127 && value != 39) {
            buf.append((char)value);
        } else {
            buf.append('\\');
            if (value == 39) {
                buf.append('\'');
            } else if (value == 10) {
                buf.append('n');
            } else if (value == 13) {
                buf.append('r');
            } else if (value == 9) {
                buf.append('t');
            } else if (value < 256) {
                String str = Integer.toOctalString(value);
                int i = 3 - str.length();
                while (--i >= 0) {
                    buf.append('0');
                }
                buf.append(str);
            } else {
                buf.append('u');
                String str = Integer.toHexString(value);
                int i = 4 - str.length();
                while (--i >= 0) {
                    buf.append('0');
                }
                buf.append(str);
            }
        }
        buf.append('\'');
        return buf.toString();
    }

    public static String toScmReadableString(int ch) {
        StringBuffer sbuf = new StringBuffer(20);
        sbuf.append("#\\");
        int nlen = charNameValues.length();
        for (int i = 0; i < nlen; ++i) {
            if ((char)ch != charNameValues.charAt(i)) continue;
            sbuf.append(charNames[i]);
            return sbuf.toString();
        }
        if (ch == 2097151) {
            sbuf.append("ignorable-char");
        } else if (ch < 32 || ch > 127) {
            sbuf.append('x');
            sbuf.append(Integer.toString(ch, 16));
        } else {
            sbuf.append((char)ch);
        }
        return sbuf.toString();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.value = in.readInt();
    }

    public Object readResolve() throws ObjectStreamException {
        return Char.make(this.value);
    }

    public int compareTo(Object o) {
        return this.value - ((Char)o).value;
    }

    static {
        hashTable = new CharMap();
        ascii = new Char[128];
        int i = 128;
        while (--i >= 0) {
            Char.ascii[i] = new Char(i);
        }
        charNameValues = " \t\n\n\r\f\b\u001b\u001b\u0007\u0007\u000b\u0000\u0000";
        charNames = new String[]{"space", "tab", "newline", "linefeed", "return", "page", "backspace", "escape", "esc", "delete", "del", "rubout", "alarm", "bel", "vtab", "null", "nul"};
    }

    static class CharMap
    extends AbstractWeakHashTable<Char, Char> {
        CharMap() {
        }

        public Char get(int key) {
            this.cleanup();
            int hash = key;
            int index = this.hashToIndex(hash);
            AbstractWeakHashTable.WEntry node = ((AbstractWeakHashTable.WEntry[])this.table)[index];
            while (node != null) {
                Char val = (Char)node.getValue();
                if (val != null && val.intValue() == key) {
                    return val;
                }
                node = node.next;
            }
            Char val = new Char(key);
            super.put(val, val);
            return val;
        }

        @Override
        protected Char getKeyFromValue(Char ch) {
            return ch;
        }

        protected boolean matches(Char oldValue, Char newValue) {
            return oldValue.intValue() == newValue.intValue();
        }
    }

}

