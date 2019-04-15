/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.KNode;
import gnu.lists.AbstractSequence;
import gnu.xml.NodeTree;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

public class KAttr
extends KNode
implements Attr {
    public KAttr(NodeTree seq, int ipos) {
        super(seq, ipos);
    }

    @Override
    public String getName() {
        return ((NodeTree)this.sequence).getNextTypeName(this.ipos);
    }

    @Override
    public short getNodeType() {
        return 2;
    }

    @Override
    public String getValue() {
        return this.getNodeValue();
    }

    public static Object getObjectValue(NodeTree sequence, int ipos) {
        return sequence.getPosNext(ipos + 10);
    }

    public Object getObjectValue() {
        return KAttr.getObjectValue((NodeTree)this.sequence, this.ipos);
    }

    @Override
    public void setValue(String value) throws DOMException {
        throw new DOMException(7, "setValue not supported");
    }

    @Override
    public Node getParentNode() {
        return null;
    }

    @Override
    public Element getOwnerElement() {
        return (Element)super.getParentNode();
    }

    @Override
    public boolean getSpecified() {
        return true;
    }

    @Override
    public TypeInfo getSchemaTypeInfo() {
        return null;
    }

    @Override
    public boolean isId() {
        return false;
    }
}

