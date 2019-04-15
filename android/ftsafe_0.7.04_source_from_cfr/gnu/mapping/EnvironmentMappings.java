/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.LocationEnumeration;
import gnu.mapping.SimpleEnvironment;
import java.util.AbstractSet;
import java.util.Iterator;

class EnvironmentMappings
extends AbstractSet {
    SimpleEnvironment env;

    public EnvironmentMappings(SimpleEnvironment env) {
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

