// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.lists.ImmutablePair;

public class StreamPair extends ImmutablePair implements Stream
{
    public StreamPair(final Object x, final Object y) {
        super(x, y);
    }
    
    public Object getValue() {
        return this;
    }
}
