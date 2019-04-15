/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Location;
import gnu.mapping.NamedLocation;
import gnu.mapping.SimpleEnvironment;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LocationEnumeration
implements Iterator<Location>,
Enumeration<Location> {
    SimpleEnvironment env;
    NamedLocation prevLoc;
    NamedLocation nextLoc;
    int index;
    LocationEnumeration inherited;
    NamedLocation[] bindings;

    public LocationEnumeration(NamedLocation[] bindings, int count) {
        this.bindings = bindings;
        this.index = count;
    }

    public LocationEnumeration(SimpleEnvironment env) {
        this(env.table, 1 << env.log2Size);
    }

    @Override
    public boolean hasMoreElements() {
        return this.env.hasMoreElements(this);
    }

    @Override
    public Location nextElement() {
        return this.nextLocation();
    }

    public Location nextLocation() {
        NamedLocation first;
        if (this.nextLoc == null && !this.hasMoreElements()) {
            throw new NoSuchElementException();
        }
        NamedLocation oldPrev = this.prevLoc;
        if (this.prevLoc == null && this.nextLoc != (first = this.bindings[this.index])) {
            this.prevLoc = first;
        }
        while (this.prevLoc != null && this.prevLoc.next != this.nextLoc) {
            this.prevLoc = this.prevLoc.next;
        }
        NamedLocation r = this.nextLoc;
        this.nextLoc = this.nextLoc.next;
        return r;
    }

    @Override
    public boolean hasNext() {
        return this.hasMoreElements();
    }

    @Override
    public Location next() {
        return this.nextElement();
    }

    @Override
    public void remove() {
        NamedLocation curLoc;
        NamedLocation namedLocation = curLoc = this.prevLoc != null ? this.prevLoc.next : this.bindings[this.index];
        if (curLoc == null || curLoc.next != this.nextLoc) {
            throw new IllegalStateException();
        }
        curLoc.next = null;
        if (this.prevLoc != null) {
            this.prevLoc.next = this.nextLoc;
        } else {
            this.bindings[this.index] = this.nextLoc;
        }
        --this.env.num_bindings;
    }
}

