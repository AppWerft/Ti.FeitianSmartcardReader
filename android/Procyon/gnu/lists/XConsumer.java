// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public interface XConsumer extends Consumer
{
    void writeComment(final char[] p0, final int p1, final int p2);
    
    void writeProcessingInstruction(final String p0, final char[] p1, final int p2, final int p3);
    
    void writeCDATA(final char[] p0, final int p1, final int p2);
    
    void beginEntity(final Object p0);
    
    void endEntity();
}
