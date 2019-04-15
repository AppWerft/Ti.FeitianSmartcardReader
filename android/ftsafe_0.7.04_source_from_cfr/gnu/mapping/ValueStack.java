/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.lists.Consumer;
import gnu.lists.TreeList;
import gnu.mapping.Values;

class ValueStack
extends TreeList {
    int gapStartOnPush;
    Consumer consumerOnPush = this;
    int oindexOnPush;
    Object lastObject = this;

    ValueStack() {
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
        int oindex = this.find(this.consumerOnPush);
        this.ensureSpace(6);
        int start = this.gapStart;
        this.data[start++] = 61698;
        this.setIntN(start, oindex);
        this.gapStart = start += 2;
        this.data[start++] = 61698;
        this.setIntN(start, this.gapStartOnPush);
        this.gapStart = start + 2;
    }

    void pop(int saved) {
        this.gapStartOnPush = this.getIntN(saved - 2);
        int oindex = this.getIntN(saved - 5);
        this.consumerOnPush = (Consumer)this.objects[oindex];
        this.objects[oindex] = null;
        this.oindexOnPush = oindex;
        this.gapStart = saved - 6;
    }

    Object getValue() {
        Object last = this.lastObject;
        if (this.gapStart == this.gapStartOnPush) {
            return last == this ? Values.empty : last;
        }
        int next = this.nextDataIndex(this.gapStartOnPush);
        if (next == this.gapStart && last == this) {
            return this.getPosNext(this.gapStartOnPush << 1);
        }
        Values.FromTreeList vals = new Values.FromTreeList();
        super.consumeIRange(this.gapStartOnPush, this.gapStart, vals);
        if (this.lastObject != this) {
            vals.writeObject(this.lastObject);
        }
        return vals;
    }

    @Override
    public void ensureSpace(int needed) {
        super.ensureSpace(needed + 3);
        if (this.lastObject != this) {
            super.writeObject(this.lastObject);
            this.lastObject = this;
        }
    }

    @Override
    public void writeObject(Object v) {
        if (this.lastObject != this) {
            super.writeObject(this.lastObject);
        }
        this.lastObject = v;
    }
}

