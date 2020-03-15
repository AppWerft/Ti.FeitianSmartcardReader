// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.math.Numeric;
import gnu.math.RealNum;
import gnu.kawa.util.GeneralHashTable;

class DistinctValuesHashTable extends GeneralHashTable
{
    NamedCollator collator;
    
    public DistinctValuesHashTable(final NamedCollator collator) {
        this.collator = collator;
    }
    
    @Override
    public int hash(final Object key) {
        if (key == null) {
            return 0;
        }
        if (key instanceof Number && (key instanceof RealNum || !(key instanceof Numeric))) {
            int hash = Float.floatToIntBits(((Number)key).floatValue());
            if (hash == Integer.MIN_VALUE) {
                hash = 0;
            }
            return hash;
        }
        return key.hashCode();
    }
    
    public boolean matches(final Object value1, final Object value2) {
        return value1 == value2 || (NumberValue.isNaN(value1) && NumberValue.isNaN(value2)) || Compare.apply(72, value1, value2, this.collator);
    }
}
