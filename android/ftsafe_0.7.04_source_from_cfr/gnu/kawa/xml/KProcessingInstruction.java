/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.KNode;
import gnu.lists.AbstractSequence;
import gnu.xml.NodeTree;
import org.w3c.dom.DOMException;
import org.w3c.dom.ProcessingInstruction;

public class KProcessingInstruction
extends KNode
implements ProcessingInstruction {
    public KProcessingInstruction(NodeTree seq, int ipos) {
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
    public void setData(String data) throws DOMException {
        throw new DOMException(7, "setData not supported");
    }

    @Override
    public String getTarget() {
        return ((NodeTree)this.sequence).posTarget(this.ipos);
    }

    public static KProcessingInstruction valueOf(String target, String content) {
        NodeTree tree = new NodeTree();
        tree.writeProcessingInstruction(target, content, 0, content.length());
        return new KProcessingInstruction(tree, 0);
    }
}

