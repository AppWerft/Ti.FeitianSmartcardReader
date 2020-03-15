// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import org.w3c.dom.DOMException;
import gnu.xml.NodeTree;
import org.w3c.dom.ProcessingInstruction;

public class KProcessingInstruction extends KNode implements ProcessingInstruction
{
    public KProcessingInstruction(final NodeTree seq, final int ipos) {
        super(seq, ipos);
    }
    
    @Override
    public short getNodeType() {
        return 7;
    }
    
    @Override
    public String getNodeName() {
        return this.getTarget();
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
    public String getTarget() {
        return ((NodeTree)this.sequence).posTarget(this.ipos);
    }
    
    public static KProcessingInstruction valueOf(final String target, final String content) {
        final NodeTree tree = new NodeTree();
        tree.writeProcessingInstruction(target, content, 0, content.length());
        return new KProcessingInstruction(tree, 0);
    }
}
