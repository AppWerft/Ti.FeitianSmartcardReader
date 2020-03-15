// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import java.util.NoSuchElementException;
import java.util.Enumeration;
import java.util.Iterator;

public class LocationEnumeration implements Iterator<Location>, Enumeration<Location>
{
    SimpleEnvironment env;
    NamedLocation prevLoc;
    NamedLocation nextLoc;
    int index;
    LocationEnumeration inherited;
    NamedLocation[] bindings;
    
    public LocationEnumeration(final NamedLocation[] bindings, final int count) {
        this.bindings = bindings;
        this.index = count;
    }
    
    public LocationEnumeration(final SimpleEnvironment env) {
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
        if (this.nextLoc == null && !this.hasMoreElements()) {
            throw new NoSuchElementException();
        }
        final NamedLocation oldPrev = this.prevLoc;
        if (this.prevLoc == null) {
            final NamedLocation first = this.bindings[this.index];
            if (this.nextLoc != first) {
                this.prevLoc = first;
            }
        }
        while (this.prevLoc != null && this.prevLoc.next != this.nextLoc) {
            this.prevLoc = this.prevLoc.next;
        }
        final Location r = this.nextLoc;
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
        final NamedLocation curLoc = (this.prevLoc != null) ? this.prevLoc.next : this.bindings[this.index];
        if (curLoc == null || curLoc.next != this.nextLoc) {
            throw new IllegalStateException();
        }
        curLoc.next = null;
        if (this.prevLoc != null) {
            this.prevLoc.next = this.nextLoc;
        }
        else {
            this.bindings[this.index] = this.nextLoc;
        }
        final SimpleEnvironment env = this.env;
        --env.num_bindings;
    }
}
