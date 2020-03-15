// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

public class XString implements CharSequence
{
    public String text;
    private XStringType type;
    
    public XStringType getStringType() {
        return this.type;
    }
    
    @Override
    public char charAt(final int index) {
        return this.text.charAt(index);
    }
    
    @Override
    public int length() {
        return this.text.length();
    }
    
    @Override
    public CharSequence subSequence(final int start, final int end) {
        return this.text.substring(start, end);
    }
    
    @Override
    public String toString() {
        return this.text;
    }
    
    XString(final String text, final XStringType type) {
        this.text = text;
        this.type = type;
    }
}
