// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.xml.NodeTree;
import org.w3c.dom.Comment;

public class KComment extends KCharacterData implements Comment
{
    public KComment(final NodeTree seq, final int ipos) {
        super(seq, ipos);
    }
    
    @Override
    public short getNodeType() {
        return 8;
    }
    
    @Override
    public String getNodeName() {
        return "#comment";
    }
    
    public static KComment valueOf(final String text) {
        final NodeTree tree = new NodeTree();
        tree.writeComment(text, 0, text.length());
        return new KComment(tree, 0);
    }
}
