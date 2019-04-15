/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.CollationKey;
import java.text.Collator;

public class NamedCollator
extends Collator
implements Externalizable {
    Collator collator;
    String name;
    public static final String UNICODE_CODEPOINT_COLLATION = "http://www.w3.org/2005/xpath-functions/collation/codepoint";
    public static final NamedCollator codepointCollation = new NamedCollator();

    public static NamedCollator make(String name) {
        NamedCollator coll = new NamedCollator();
        coll.name = name;
        coll.resolve();
        return coll;
    }

    public String getName() {
        return this.name;
    }

    public static NamedCollator find(String name) {
        return NamedCollator.make(name);
    }

    public void resolve() {
        if (this.name != null && !this.name.equals(UNICODE_CODEPOINT_COLLATION)) {
            throw new RuntimeException("unknown collation: " + this.name);
        }
    }

    public static int codepointCompare(String str1, String str2) {
        int c1;
        int c2;
        int i1 = 0;
        int i2 = 0;
        int len1 = str1.length();
        int len2 = str2.length();
        do {
            if (i1 == len1) {
                return i2 == len2 ? 0 : -1;
            }
            if (i2 == len2) {
                return 1;
            }
            if ((c1 = str1.charAt(i1++)) >= 55296 && c1 < 56320 && i1 < len1) {
                c1 = (c1 - 55296) * 1024 + (str1.charAt(i1++) - 56320) + 65536;
            }
            if ((c2 = str2.charAt(i2++)) < 55296 || c2 >= 56320 || i2 >= len2) continue;
            c2 = (c2 - 55296) * 1024 + (str2.charAt(i2++) - 56320) + 65536;
        } while (c1 == c2);
        return c1 < c2 ? -1 : 1;
    }

    @Override
    public int compare(String str1, String str2) {
        if (this.collator != null) {
            return this.collator.compare(str1, str2);
        }
        return NamedCollator.codepointCompare(str1, str2);
    }

    @Override
    public CollationKey getCollationKey(String source) {
        return this.collator.getCollationKey(source);
    }

    @Override
    public int hashCode() {
        if (this.collator != null) {
            return this.collator.hashCode();
        }
        return 0;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.resolve();
    }

    static {
        NamedCollator.codepointCollation.name = UNICODE_CODEPOINT_COLLATION;
    }
}

