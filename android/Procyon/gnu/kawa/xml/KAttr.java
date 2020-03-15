// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import org.w3c.dom.TypeInfo;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.DOMException;
import gnu.xml.NodeTree;
import org.w3c.dom.Attr;

public class KAttr extends KNode implements Attr
{
    public KAttr(final NodeTree seq, final int ipos) {
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
    
    public static Object getObjectValue(final NodeTree sequence, final int ipos) {
        return sequence.getPosNext(ipos + 10);
    }
    
    public Object getObjectValue() {
        return getObjectValue((NodeTree)this.sequence, this.ipos);
    }
    
    @Override
    public void setValue(final String value) throws DOMException {
        throw new DOMException((short)7, "setValue not supported");
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
