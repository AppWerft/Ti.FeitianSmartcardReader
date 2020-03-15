// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import java.util.Iterator;
import java.util.AbstractSet;

class EnvironmentMappings extends AbstractSet
{
    SimpleEnvironment env;
    
    public EnvironmentMappings(final SimpleEnvironment env) {
        this.env = env;
    }
    
    @Override
    public int size() {
        return this.env.size();
    }
    
    @Override
    public Iterator iterator() {
        return new LocationEnumeration(this.env);
    }
}
