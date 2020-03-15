// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

public interface Window
{
    Display getDisplay();
    
    void setContent(final Object p0);
    
    void setTitle(final String p0);
    
    void setMenuBar(final Object p0);
    
    String getTitle();
    
    void open();
}
