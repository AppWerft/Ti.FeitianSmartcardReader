// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import gnu.lists.Consumer;
import gnu.lists.TreeList;

class ValueStack extends TreeList
{
    int gapStartOnPush;
    Consumer consumerOnPush;
    int oindexOnPush;
    Object lastObject;
    
    ValueStack() {
        this.consumerOnPush = this;
        this.lastObject = this;
    }
    
    @Override
    public void clear() {
        super.clear();
        this.lastObject = this;
    }
    
    void push() {
        if (this.lastObject != this) {
            super.writeObject(this.lastObject);
            this.lastObject = this;
        }
        final int oindex = this.find(this.consumerOnPush);
        this.ensureSpace(6);
        int start = this.gapStart;
        this.data[start++] = '\uf102';
        this.setIntN(start, oindex);
        start += 2;
        this.gapStart = start;
        this.data[start++] = '\uf102';
        this.setIntN(start, this.gapStartOnPush);
        this.gapStart = start + 2;
    }
    
    void pop(final int saved) {
        this.gapStartOnPush = this.getIntN(saved - 2);
        final int oindex = this.getIntN(saved - 5);
        this.consumerOnPush = (Consumer)this.objects[oindex];
        this.objects[oindex] = null;
        this.oindexOnPush = oindex;
        this.gapStart = saved - 6;
    }
    
    Object getValue() {
        final Object last = this.lastObject;
        if (this.gapStart == this.gapStartOnPush) {
            return (last == this) ? Values.empty : last;
        }
        final int next = this.nextDataIndex(this.gapStartOnPush);
        if (next == this.gapStart && last == this) {
            return this.getPosNext(this.gapStartOnPush << 1);
        }
        final Values.FromTreeList vals = new Values.FromTreeList();
        super.consumeIRange(this.gapStartOnPush, this.gapStart, vals);
        if (this.lastObject != this) {
            vals.writeObject(this.lastObject);
        }
        return vals;
    }
    
    @Override
    public void ensureSpace(final int needed) {
        super.ensureSpace(needed + 3);
        if (this.lastObject != this) {
            super.writeObject(this.lastObject);
            this.lastObject = this;
        }
    }
    
    @Override
    public void writeObject(final Object v) {
        if (this.lastObject != this) {
            super.writeObject(this.lastObject);
        }
        this.lastObject = v;
    }
}
