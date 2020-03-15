// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import org.w3c.dom.DOMException;
import gnu.xml.NodeTree;
import org.w3c.dom.Text;

public class KText extends KCharacterData implements Text
{
    public KText(final NodeTree seq, final int ipos) {
        super(seq, ipos);
    }
    
    public static KText make(final String text) {
        final NodeTree tree = new NodeTree();
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
    public Text splitText(final int offset) throws DOMException {
        throw new DOMException((short)7, "splitText not supported");
    }
    
    @Override
    public String getWholeText() {
        throw new UnsupportedOperationException("getWholeText not implemented yet");
    }
    
    @Override
    public Text replaceWholeText(final String content) throws DOMException {
        throw new DOMException((short)7, "splitText not supported");
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
