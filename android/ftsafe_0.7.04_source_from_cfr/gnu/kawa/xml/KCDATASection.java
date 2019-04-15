/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.KText;
import gnu.lists.AbstractSequence;
import gnu.xml.NodeTree;
import org.w3c.dom.CDATASection;

public class KCDATASection
extends KText
implements CDATASection {
    public KCDATASection(NodeTree seq, int ipos) {
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
        StringBuffer sbuf = new StringBuffer();
        NodeTree tlist = (NodeTree)this.sequence;
        tlist.stringValue(tlist.posToDataIndex(this.ipos), sbuf);
        return sbuf.length();
    }
}

