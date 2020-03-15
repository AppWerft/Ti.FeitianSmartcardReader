// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.format;

import java.text.ParsePosition;
import java.text.FieldPosition;
import gnu.lists.Consumer;
import java.text.NumberFormat;

public class EnglishIntegerFormat extends NumberFormat
{
    private static EnglishIntegerFormat cardinalEnglish;
    private static EnglishIntegerFormat ordinalEnglish;
    public boolean ordinal;
    public static final String[] ones;
    public static final String[] onesth;
    public static final String[] tens;
    public static final String[] tensth;
    public static final String[] power1000s;
    
    public EnglishIntegerFormat(final boolean ordinal) {
        this.ordinal = ordinal;
    }
    
    public static EnglishIntegerFormat getInstance(final boolean ordinal) {
        if (ordinal) {
            if (EnglishIntegerFormat.ordinalEnglish == null) {
                EnglishIntegerFormat.ordinalEnglish = new EnglishIntegerFormat(true);
            }
            return EnglishIntegerFormat.ordinalEnglish;
        }
        if (EnglishIntegerFormat.cardinalEnglish == null) {
            EnglishIntegerFormat.cardinalEnglish = new EnglishIntegerFormat(false);
        }
        return EnglishIntegerFormat.cardinalEnglish;
    }
    
    void format999(final StringBuffer sbuf, int num, final boolean ordinal) {
        if (num >= 100) {
            final int num100s = num / 100;
            num %= 100;
            if (num100s > 1) {
                sbuf.append(EnglishIntegerFormat.ones[num100s]);
                sbuf.append(' ');
            }
            sbuf.append("hundred");
            if (num > 0) {
                sbuf.append(' ');
            }
            else if (ordinal) {
                sbuf.append("th");
            }
        }
        if (num >= 20) {
            final int num10s = num / 10;
            num %= 10;
            sbuf.append(((ordinal && num == 0) ? EnglishIntegerFormat.tensth : EnglishIntegerFormat.tens)[num10s]);
            if (num > 0) {
                sbuf.append('-');
            }
        }
        if (num > 0) {
            sbuf.append((ordinal ? EnglishIntegerFormat.onesth : EnglishIntegerFormat.ones)[num]);
        }
    }
    
    void format(final StringBuffer sbuf, long num, final int exp1000, final boolean ordinal) {
        if (num >= 1000L) {
            this.format(sbuf, num / 1000L, exp1000 + 1, false);
            num %= 1000L;
            if (num > 0L) {
                sbuf.append(", ");
            }
            else if (ordinal) {
                sbuf.append("th");
            }
        }
        if (num > 0L) {
            this.format999(sbuf, (int)num, ordinal && exp1000 == 0);
            if (exp1000 >= EnglishIntegerFormat.power1000s.length) {
                sbuf.append(" times ten to the ");
                this.format(sbuf, exp1000 * 3, 0, true);
                sbuf.append(" power");
            }
            else if (exp1000 > 0) {
                sbuf.append(EnglishIntegerFormat.power1000s[exp1000]);
            }
        }
    }
    
    public void writeInt(final int value, final Consumer out) {
        this.writeLong(value, out);
    }
    
    public void writeLong(final long value, final Consumer out) {
        final StringBuffer sbuf = new StringBuffer();
        this.format(value, sbuf, null);
        out.write(sbuf, 0, sbuf.length());
    }
    
    public void writeObject(final Object value, final Consumer out) {
        this.writeLong(((Number)value).longValue(), out);
    }
    
    public void writeBoolean(final boolean value, final Consumer out) {
        this.writeLong(value ? 1 : 0, out);
    }
    
    @Override
    public StringBuffer format(long num, final StringBuffer sbuf, final FieldPosition fpos) {
        if (num == 0L) {
            sbuf.append(this.ordinal ? "zeroth" : "zero");
        }
        else {
            if (num < 0L) {
                sbuf.append("minus ");
                num = -num;
            }
            this.format(sbuf, num, 0, this.ordinal);
        }
        if (fpos != null) {}
        return sbuf;
    }
    
    @Override
    public StringBuffer format(final double num, final StringBuffer sbuf, final FieldPosition fpos) {
        final long inum = (long)num;
        if (inum == num) {
            return this.format(inum, sbuf, fpos);
        }
        sbuf.append(Double.toString(num));
        return sbuf;
    }
    
    @Override
    public Number parse(final String text, final ParsePosition status) {
        throw new Error("EnglishIntegerFormat.parseObject - not implemented");
    }
    
    static {
        ones = new String[] { null, "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        onesth = new String[] { null, "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelveth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth" };
        tens = new String[] { null, null, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
        tensth = new String[] { null, null, "twentieth", "thirtieth", "fortieth", "fiftieth", "sixtieth", "seventieth", "eightieth", "ninetieth" };
        power1000s = new String[] { null, " thousand", " million", " billion", " trillion", " quadrillion", " quintillion", " sextillion", " septillion", " octillion", " nonillion", " decillion", " undecillion", " duodecillion", " tredecillion", " quattuordecillion", " quindecillion", " sexdecillion", " septendecillion", " octodecillion", " novemdecillion", " vigintillion" };
    }
}
