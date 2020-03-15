// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.text.CollationKey;
import java.io.Externalizable;
import java.text.Collator;

public class NamedCollator extends Collator implements Externalizable
{
    Collator collator;
    String name;
    public static final String UNICODE_CODEPOINT_COLLATION = "http://www.w3.org/2005/xpath-functions/collation/codepoint";
    public static final NamedCollator codepointCollation;
    
    public static NamedCollator make(final String name) {
        final NamedCollator coll = new NamedCollator();
        coll.name = name;
        coll.resolve();
        return coll;
    }
    
    public String getName() {
        return this.name;
    }
    
    public static NamedCollator find(final String name) {
        return make(name);
    }
    
    public void resolve() {
        if (this.name != null && !this.name.equals("http://www.w3.org/2005/xpath-functions/collation/codepoint")) {
            throw new RuntimeException("unknown collation: " + this.name);
        }
    }
    
    public static int codepointCompare(final String str1, final String str2) {
        int i1 = 0;
        int i2 = 0;
        final int len1 = str1.length();
        final int len2 = str2.length();
        while (i1 != len1) {
            if (i2 == len2) {
                return 1;
            }
            int c1 = str1.charAt(i1++);
            if (c1 >= 55296 && c1 < 56320 && i1 < len1) {
                c1 = (c1 - 55296) * 1024 + (str1.charAt(i1++) - '\udc00') + 65536;
            }
            int c2 = str2.charAt(i2++);
            if (c2 >= 55296 && c2 < 56320 && i2 < len2) {
                c2 = (c2 - 55296) * 1024 + (str2.charAt(i2++) - '\udc00') + 65536;
            }
            if (c1 != c2) {
                return (c1 < c2) ? -1 : 1;
            }
        }
        return (i2 == len2) ? 0 : -1;
    }
    
    @Override
    public int compare(final String str1, final String str2) {
        if (this.collator != null) {
            return this.collator.compare(str1, str2);
        }
        return codepointCompare(str1, str2);
    }
    
    @Override
    public CollationKey getCollationKey(final String source) {
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
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.resolve();
    }
    
    static {
        codepointCollation = new NamedCollator();
        NamedCollator.codepointCollation.name = "http://www.w3.org/2005/xpath-functions/collation/codepoint";
    }
}
