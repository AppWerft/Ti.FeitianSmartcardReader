/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.format;

import gnu.lists.Consumer;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class EnglishIntegerFormat
extends NumberFormat {
    private static EnglishIntegerFormat cardinalEnglish;
    private static EnglishIntegerFormat ordinalEnglish;
    public boolean ordinal;
    public static final String[] ones;
    public static final String[] onesth;
    public static final String[] tens;
    public static final String[] tensth;
    public static final String[] power1000s;

    public EnglishIntegerFormat(boolean ordinal) {
        this.ordinal = ordinal;
    }

    public static EnglishIntegerFormat getInstance(boolean ordinal) {
        if (ordinal) {
            if (ordinalEnglish == null) {
                ordinalEnglish = new EnglishIntegerFormat(true);
            }
            return ordinalEnglish;
        }
        if (cardinalEnglish == null) {
            cardinalEnglish = new EnglishIntegerFormat(false);
        }
        return cardinalEnglish;
    }

    void format999(StringBuffer sbuf, int num, boolean ordinal) {
        if (num >= 100) {
            int num100s = num / 100;
            num %= 100;
            if (num100s > 1) {
                sbuf.append(ones[num100s]);
                sbuf.append(' ');
            }
            sbuf.append("hundred");
            if (num > 0) {
                sbuf.append(' ');
            } else if (ordinal) {
                sbuf.append("th");
            }
        }
        if (num >= 20) {
            int num10s = num / 10;
            sbuf.append((ordinal && (num %= 10) == 0 ? tensth : tens)[num10s]);
            if (num > 0) {
                sbuf.append('-');
            }
        }
        if (num > 0) {
            sbuf.append((ordinal ? onesth : ones)[num]);
        }
    }

    void format(StringBuffer sbuf, long num, int exp1000, boolean ordinal) {
        if (num >= 1000L) {
            this.format(sbuf, num / 1000L, exp1000 + 1, false);
            if ((num %= 1000L) > 0L) {
                sbuf.append(", ");
            } else if (ordinal) {
                sbuf.append("th");
            }
        }
        if (num > 0L) {
            this.format999(sbuf, (int)num, ordinal && exp1000 == 0);
            if (exp1000 >= power1000s.length) {
                sbuf.append(" times ten to the ");
                this.format(sbuf, exp1000 * 3, 0, true);
                sbuf.append(" power");
            } else if (exp1000 > 0) {
                sbuf.append(power1000s[exp1000]);
            }
        }
    }

    public void writeInt(int value, Consumer out) {
        this.writeLong(value, out);
    }

    public void writeLong(long value, Consumer out) {
        StringBuffer sbuf = new StringBuffer();
        this.format(value, sbuf, (FieldPosition)null);
        out.write(sbuf, 0, sbuf.length());
    }

    public void writeObject(Object value, Consumer out) {
        this.writeLong(((Number)value).longValue(), out);
    }

    public void writeBoolean(boolean value, Consumer out) {
        this.writeLong(value ? 1L : 0L, out);
    }

    @Override
    public StringBuffer format(long num, StringBuffer sbuf, FieldPosition fpos) {
        if (num == 0L) {
            sbuf.append(this.ordinal ? "zeroth" : "zero");
        } else {
            if (num < 0L) {
                sbuf.append("minus ");
                num = -num;
            }
            this.format(sbuf, num, 0, this.ordinal);
        }
        if (fpos != null) {
            // empty if block
        }
        return sbuf;
    }

    @Override
    public StringBuffer format(double num, StringBuffer sbuf, FieldPosition fpos) {
        long inum = (long)num;
        if ((double)inum == num) {
            return this.format(inum, sbuf, fpos);
        }
        sbuf.append(Double.toString(num));
        return sbuf;
    }

    @Override
    public Number parse(String text, ParsePosition status) {
        throw new Error("EnglishIntegerFormat.parseObject - not implemented");
    }

    static {
        ones = new String[]{null, "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        onesth = new String[]{null, "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelveth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth"};
        tens = new String[]{null, null, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        tensth = new String[]{null, null, "twentieth", "thirtieth", "fortieth", "fiftieth", "sixtieth", "seventieth", "eightieth", "ninetieth"};
        power1000s = new String[]{null, " thousand", " million", " billion", " trillion", " quadrillion", " quintillion", " sextillion", " septillion", " octillion", " nonillion", " decillion", " undecillion", " duodecillion", " tredecillion", " quattuordecillion", " quindecillion", " sexdecillion", " septendecillion", " octodecillion", " novemdecillion", " vigintillion"};
    }
}

