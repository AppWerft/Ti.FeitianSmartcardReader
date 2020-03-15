// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public interface Consumer extends Appendable
{
    void writeBoolean(final boolean p0);
    
    void writeFloat(final float p0);
    
    void writeDouble(final double p0);
    
    void writeInt(final int p0);
    
    void writeLong(final long p0);
    
    void startDocument();
    
    void endDocument();
    
    void startElement(final Object p0);
    
    void endElement();
    
    void startAttribute(final Object p0);
    
    void endAttribute();
    
    void writeObject(final Object p0);
    
    boolean ignoring();
    
    void write(final int p0);
    
    void write(final String p0);
    
    void write(final CharSequence p0, final int p1, final int p2);
    
    void write(final char[] p0, final int p1, final int p2);
    
    Consumer append(final char p0);
    
    Consumer append(final CharSequence p0);
    
    Consumer append(final CharSequence p0, final int p1, final int p2);
}
