/*
 * Decompiled with CFR 0.139.
 */
package gnu.xml;

import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.FilterConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.mapping.Symbol;

public class NamedChildrenFilter
extends FilterConsumer {
    String namespaceURI;
    String localName;
    int level;
    int matchLevel;

    public static NamedChildrenFilter make(String namespaceURI, String localName, Consumer out) {
        return new NamedChildrenFilter(namespaceURI, localName, out);
    }

    public NamedChildrenFilter(String namespaceURI, String localName, Consumer out) {
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
    public void startElement(Object type) {
        if (this.skipping && this.level == 1) {
            String curNamespaceURI;
            String curLocalName;
            if (type instanceof Symbol) {
                Symbol qname = (Symbol)type;
                curNamespaceURI = qname.getNamespaceURI();
                curLocalName = qname.getLocalName();
            } else {
                curNamespaceURI = "";
                curLocalName = type.toString().intern();
            }
            if (!(this.localName != curLocalName && this.localName != null || this.namespaceURI != curNamespaceURI && this.namespaceURI != null)) {
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
    public void writeObject(Object val) {
        if (val instanceof SeqPosition) {
            SeqPosition pos = (SeqPosition)val;
            if (pos.sequence instanceof TreeList) {
                ((TreeList)pos.sequence).consumeNext(pos.ipos, this);
                return;
            }
        }
        if (val instanceof Consumable) {
            ((Consumable)val).consume(this);
        } else {
            super.writeObject(val);
        }
    }
}

