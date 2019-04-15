/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.KCharacterData;
import gnu.xml.NodeTree;
import org.w3c.dom.Comment;

public class KComment
extends KCharacterData
implements Comment {
    public KComment(NodeTree seq, int ipos) {
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

    public static KComment valueOf(String text) {
        NodeTree tree = new NodeTree();
        tree.writeComment(text, 0, text.length());
        return new KComment(tree, 0);
    }
}

