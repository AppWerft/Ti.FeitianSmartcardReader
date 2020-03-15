// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import org.w3c.dom.DOMException;
import gnu.xml.NodeTree;
import org.w3c.dom.CharacterData;

public abstract class KCharacterData extends KNode implements CharacterData
{
    public KCharacterData(final NodeTree seq, final int ipos) {
        super(seq, ipos);
    }
    
    @Override
    public int getLength() {
        final StringBuffer sbuf = new StringBuffer();
        final NodeTree tlist = (NodeTree)this.sequence;
        tlist.stringValue(tlist.posToDataIndex(this.ipos), sbuf);
        return sbuf.length();
    }
    
    @Override
    public String getData() {
        return this.getNodeValue();
    }
    
    @Override
    public void setData(final String data) throws DOMException {
        throw new DOMException((short)7, "setData not supported");
    }
    
    @Override
    public String substringData(final int offset, final int count) throws DOMException {
        final String data = this.getData();
        if (offset < 0 || count < 0 || offset + count >= data.length()) {
            throw new DOMException((short)1, "invalid index to substringData");
        }
        return data.substring(offset, count);
    }
    
    @Override
    public void appendData(final String data) throws DOMException {
        throw new DOMException((short)7, "appendData not supported");
    }
    
    @Override
    public void insertData(final int offset, final String data) throws DOMException {
        this.replaceData(offset, 0, data);
    }
    
    @Override
    public void deleteData(final int offset, final int count) throws DOMException {
        this.replaceData(offset, count, "");
    }
    
    @Override
    public void replaceData(final int offset, final int count, final String arg) throws DOMException {
        throw new DOMException((short)7, "replaceData not supported");
    }
}
