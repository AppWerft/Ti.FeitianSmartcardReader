/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.KNode;
import gnu.lists.AbstractSequence;
import gnu.xml.NodeTree;
import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;

public abstract class KCharacterData
extends KNode
implements CharacterData {
    public KCharacterData(NodeTree seq, int ipos) {
        super(seq, ipos);
    }

    @Override
    public int getLength() {
        StringBuffer sbuf = new StringBuffer();
        NodeTree tlist = (NodeTree)this.sequence;
        tlist.stringValue(tlist.posToDataIndex(this.ipos), sbuf);
        return sbuf.length();
    }

    @Override
    public String getData() {
        return this.getNodeValue();
    }

    @Override
    public void setData(String data) throws DOMException {
        throw new DOMException(7, "setData not supported");
    }

    @Override
    public String substringData(int offset, int count) throws DOMException {
        String data = this.getData();
        if (offset < 0 || count < 0 || offset + count >= data.length()) {
            throw new DOMException(1, "invalid index to substringData");
        }
        return data.substring(offset, count);
    }

    @Override
    public void appendData(String data) throws DOMException {
        throw new DOMException(7, "appendData not supported");
    }

    @Override
    public void insertData(int offset, String data) throws DOMException {
        this.replaceData(offset, 0, data);
    }

    @Override
    public void deleteData(int offset, int count) throws DOMException {
        this.replaceData(offset, count, "");
    }

    @Override
    public void replaceData(int offset, int count, String arg) throws DOMException {
        throw new DOMException(7, "replaceData not supported");
    }
}

