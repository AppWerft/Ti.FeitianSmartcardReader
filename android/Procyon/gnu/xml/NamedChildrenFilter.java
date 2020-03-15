// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xml;

import gnu.lists.Consumable;
import gnu.lists.TreeList;
import gnu.lists.SeqPosition;
import gnu.mapping.Symbol;
import gnu.lists.Consumer;
import gnu.lists.FilterConsumer;

public class NamedChildrenFilter extends FilterConsumer
{
    String namespaceURI;
    String localName;
    int level;
    int matchLevel;
    
    public static NamedChildrenFilter make(final String namespaceURI, final String localName, final Consumer out) {
        return new NamedChildrenFilter(namespaceURI, localName, out);
    }
    
    public NamedChildrenFilter(final String namespaceURI, final String localName, final Consumer out) {
        super(out);
        this.namespaceURI = namespaceURI;
        this.localName = localName;
        this.skipping = true;
    }
    
    @Override
    public void startDocument() {
        ++this.level;
        super.startDocument();
    }
    
    @Override
    public void endDocument() {
        --this.level;
        super.endDocument();
    }
    
    @Override
    public void startElement(final Object type) {
        if (this.skipping && this.level == 1) {
            String curNamespaceURI;
            String curLocalName;
            if (type instanceof Symbol) {
                final Symbol qname = (Symbol)type;
                curNamespaceURI = qname.getNamespaceURI();
                curLocalName = qname.getLocalName();
            }
            else {
                curNamespaceURI = "";
                curLocalName = type.toString().intern();
            }
            if ((this.localName == curLocalName || this.localName == null) && (this.namespaceURI == curNamespaceURI || this.namespaceURI == null)) {
                this.skipping = false;
                this.matchLevel = this.level;
            }
        }
        super.startElement(type);
        ++this.level;
    }
    
    @Override
    public void endElement() {
        --this.level;
        super.endElement();
        if (!this.skipping && this.matchLevel == this.level) {
            this.skipping = true;
        }
    }
    
    @Override
    public void writeObject(final Object val) {
        if (val instanceof SeqPosition) {
            final SeqPosition pos = (SeqPosition)val;
            if (pos.sequence instanceof TreeList) {
                ((TreeList)pos.sequence).consumeNext(pos.ipos, this);
                return;
            }
        }
        if (val instanceof Consumable) {
            ((Consumable)val).consume(this);
        }
        else {
            super.writeObject(val);
        }
    }
}
