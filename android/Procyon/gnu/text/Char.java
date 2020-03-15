// 
// Decompiled by Procyon v0.5.36
// 

package gnu.text;

import gnu.kawa.util.AbstractWeakHashTable;
import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import java.io.IOException;
import gnu.lists.Sequence;
import gnu.lists.Consumer;
import java.io.Externalizable;

public class Char implements Comparable, Externalizable
{
    int value;
    public static final int IGNORABLE_CHAR = 2097151;
    static Char[] ascii;
    static CharMap hashTable;
    private static String charNameValues;
    static String[] charNames;
    
    public Char() {
    }
    
    Char(final int ch) {
        this.value = ch;
    }
    
    public void print(final Consumer out) {
        print(this.value, out);
    }
    
    public static char castToChar(final Object obj) {
        if (obj instanceof Char) {
            return ((Char)obj).charValue();
        }
        return (char)obj;
    }
    
    public static int castToCharacter(final Object obj) {
        if (obj instanceof Char) {
            return ((Char)obj).intValue();
        }
        return (char)obj;
    }
    
    public static int castToCharacterOrEof(final Object obj) {
        if (obj == Sequence.eofValue) {
            return -1;
        }
        return castToCharacter(obj);
    }
    
    public static boolean isChar(final Object obj) {
        return obj instanceof Char || obj instanceof Character;
    }
    
    public static boolean isCharOrEof(final Object obj) {
        return obj instanceof Char || obj instanceof Character || obj == Sequence.eofValue;
    }
    
    public static int checkCharOrEof(final Object obj) {
        if (obj instanceof Char) {
            return ((Char)obj).intValue();
        }
        if (obj instanceof Character) {
            return (char)obj;
        }
        if (obj == Sequence.eofValue) {
            return -1;
        }
        return -2;
    }
    
    public static void print(final int i, final Appendable out) {
        try {
            append(i, out);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static void append(int i, final Appendable out) throws IOException {
        if (i >= 65536 && i != 2097151) {
            out.append((char)((i - 65536 >> 10) + 55296));
            i = (i & 0x3FF) + 56320;
        }
        out.append((char)i);
    }
    
    public final char charValue() {
        return (char)this.value;
    }
    
    public final int intValue() {
        return this.value;
    }
    
    @Override
    public int hashCode() {
        return this.value;
    }
    
    public static Char valueOf(final int ch) {
        if (ch < 128) {
            return Char.ascii[ch];
        }
        synchronized (Char.hashTable) {
            return Char.hashTable.get(ch);
        }
    }
    
    public static Char make(final int ch) {
        return valueOf(ch);
    }
    
    public static Object makeOrEof(final int ch) {
        if (ch < 0) {
            return Sequence.eofValue;
        }
        return make(ch);
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj != null && obj instanceof Char && ((Char)obj).intValue() == this.value;
    }
    
    public static void addNamedChars(final Map<String, String> map) {
        int i = Char.charNames.length;
        while (--i >= 0) {
            map.put(Char.charNames[i], Char.charNameValues.substring(i, i + 1));
        }
    }
    
    public static int nameToChar(final String name) {
        int i = Char.charNames.length;
        while (--i >= 0) {
            if (Char.charNames[i].equals(name)) {
                return Char.charNameValues.charAt(i);
            }
        }
        i = Char.charNames.length;
        while (--i >= 0) {
            if (Char.charNames[i].equalsIgnoreCase(name)) {
                return Char.charNameValues.charAt(i);
            }
        }
        if ("ignorable-char".equalsIgnoreCase(name)) {
            return 2097151;
        }
        final int len = name.length();
        Label_0140: {
            if (len > 1 && name.charAt(0) == 'u') {
                int value = 0;
                for (int pos = 1; pos != len; ++pos) {
                    final int dig = Character.digit(name.charAt(pos), 16);
                    if (dig < 0) {
                        break Label_0140;
                    }
                    value = (value << 4) + dig;
                }
                return value;
            }
        }
        if (len == 3 && name.charAt(1) == '-') {
            char ch = name.charAt(0);
            if (ch == 'c' || ch == 'C') {
                ch = name.charAt(2);
                return ch & '\u001f';
            }
        }
        return -1;
    }
    
    @Override
    public String toString() {
        return toString(this.value);
    }
    
    public static String toString(final int value) {
        final StringBuffer buf = new StringBuffer();
        buf.append('\'');
        if (value >= 32 && value < 127 && value != 39) {
            buf.append((char)value);
        }
        else {
            buf.append('\\');
            if (value == 39) {
                buf.append('\'');
            }
            else if (value == 10) {
                buf.append('n');
            }
            else if (value == 13) {
                buf.append('r');
            }
            else if (value == 9) {
                buf.append('t');
            }
            else if (value < 256) {
                final String str = Integer.toOctalString(value);
                int i = 3 - str.length();
                while (--i >= 0) {
                    buf.append('0');
                }
                buf.append(str);
            }
            else {
                buf.append('u');
                final String str = Integer.toHexString(value);
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
    
    public static String toScmReadableString(final int ch) {
        final StringBuffer sbuf = new StringBuffer(20);
        sbuf.append("#\\");
        for (int nlen = Char.charNameValues.length(), i = 0; i < nlen; ++i) {
            if ((char)ch == Char.charNameValues.charAt(i)) {
                sbuf.append(Char.charNames[i]);
                return sbuf.toString();
            }
        }
        if (ch == 2097151) {
            sbuf.append("ignorable-char");
        }
        else if (ch < 32 || ch > 127) {
            sbuf.append('x');
            sbuf.append(Integer.toString(ch, 16));
        }
        else {
            sbuf.append((char)ch);
        }
        return sbuf.toString();
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeInt(this.value);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.value = in.readInt();
    }
    
    public Object readResolve() throws ObjectStreamException {
        return make(this.value);
    }
    
    @Override
    public int compareTo(final Object o) {
        return this.value - ((Char)o).value;
    }
    
    static {
        Char.hashTable = new CharMap();
        Char.ascii = new Char[128];
        int i = 128;
        while (--i >= 0) {
            Char.ascii[i] = new Char(i);
        }
        Char.charNameValues = " \t\n\n\r\f\b\u001b\u001b\u007f\u007f\u007f\u0007\u0007\u000b\u0000\u0000";
        Char.charNames = new String[] { "space", "tab", "newline", "linefeed", "return", "page", "backspace", "escape", "esc", "delete", "del", "rubout", "alarm", "bel", "vtab", "null", "nul" };
    }
    
    static class CharMap extends AbstractWeakHashTable<Char, Char>
    {
        public Char get(final int key) {
            this.cleanup();
            final int hash = key;
            final int index = this.hashToIndex(hash);
            for (WEntry<Char, Char> node = (WEntry<Char, Char>)((WEntry[])this.table)[index]; node != null; node = node.next) {
                final Char val = node.getValue();
                if (val != null && val.intValue() == key) {
                    return val;
                }
            }
            final Char val2 = new Char(key);
            super.put(val2, val2);
            return val2;
        }
        
        @Override
        protected Char getKeyFromValue(final Char ch) {
            return ch;
        }
        
        protected boolean matches(final Char oldValue, final Char newValue) {
            return oldValue.intValue() == newValue.intValue();
        }
    }
}
