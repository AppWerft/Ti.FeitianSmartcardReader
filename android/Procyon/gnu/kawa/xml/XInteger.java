// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.math.IntNum;

public class XInteger extends IntNum
{
    private XIntegerType type;
    
    public XIntegerType getIntegerType() {
        return this.type;
    }
    
    XInteger(final IntNum value, final XIntegerType type) {
        this.words = value.words;
        this.ival = value.ival;
        this.type = type;
    }
}
