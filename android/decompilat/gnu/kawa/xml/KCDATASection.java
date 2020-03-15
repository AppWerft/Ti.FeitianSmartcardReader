// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.xml.NodeTree;
import org.w3c.dom.CDATASection;

public class KCDATASection extends KText implements CDATASection
{
    public KCDATASection(final NodeTree seq, final int ipos) {
        super(seq, ipos);
    }
    
    @Override
    public short getNodeType() {
        return 4;
    }
    
    @Override
    public String getNodeName() {
        return "#cdata-section";
    }
    
    @Override
    public String getData() {
        return this.getNodeValue();
    }
    
    @Override
    public int getLength() {
        final StringBuffer sbuf = new StringBuffer();
        final NodeTree tlist = (NodeTree)this.sequence;
        tlist.stringValue(tlist.posToDataIndex(this.ipos), sbuf);
        return sbuf.length();
    }
}
