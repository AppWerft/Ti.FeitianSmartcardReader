// 
// Decompiled by Procyon v0.5.36
// 

package gnu.text;

import org.xml.sax.Locator;

public interface SourceLocator extends Locator
{
    int getColumnNumber();
    
    int getLineNumber();
    
    String getPublicId();
    
    String getSystemId();
    
    String getFileName();
    
    boolean isStableSourceLocation();
}
