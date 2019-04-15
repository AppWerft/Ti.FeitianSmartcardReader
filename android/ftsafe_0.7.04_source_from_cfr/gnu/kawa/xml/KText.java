/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.KCharacterData;
import gnu.lists.Consumer;
import gnu.xml.NodeTree;
import org.w3c.dom.DOMException;
import org.w3c.dom.Text;

public class KText
extends KCharacterData
implements Text {
    public KText(NodeTree seq, int ipos) {
        super(seq, ipos);
    }

    public static KText make(String text) {
        NodeTree tree = new NodeTree();
        tree.append(text);
        return new KText(tree, 0);
    }

    @Override
    public short getNodeType() {
        return 3;
    }

    @Override
    public String getNodeName() {
        return "#text";
    }

    @Override
    public Text splitText(int offset) throws DOMException {
        throw new DOMException(7, "splitText not supported");
    }

    @Override
    public String getWholeText() {
        throw new UnsupportedOperationException("getWholeText not implemented yet");
    }

    @Override
    public Text replaceWholeText(String content) throws DOMException {
        throw new DOMException(7, "splitText not supported");
    }

    @Override
    public boolean hasAttributes() {
        return false;
    }

    @Override
    public boolean isElementContentWhitespace() {
        return false;
    }
}

