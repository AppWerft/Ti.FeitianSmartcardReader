// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

public class Dimensions
{
    BaseUnit[] bases;
    short[] powers;
    int hash_code;
    private Dimensions chain;
    private static Dimensions[] hashTable;
    public static Dimensions Empty;
    
    @Override
    public final int hashCode() {
        return this.hash_code;
    }
    
    private void enterHash(final int hash_code) {
        this.hash_code = hash_code;
        final int index = (hash_code & Integer.MAX_VALUE) % Dimensions.hashTable.length;
        this.chain = Dimensions.hashTable[index];
        Dimensions.hashTable[index] = this;
    }
    
    private Dimensions() {
        (this.bases = new BaseUnit[1])[0] = Unit.Empty;
        this.enterHash(0);
    }
    
    Dimensions(final BaseUnit unit) {
        this.bases = new BaseUnit[2];
        this.powers = new short[1];
        this.bases[0] = unit;
        this.bases[1] = Unit.Empty;
        this.powers[0] = 1;
        this.enterHash(unit.index);
    }
    
    private Dimensions(final Dimensions a, final int mul_a, final Dimensions b, final int mul_b, final int hash_code) {
        int a_i = 0;
        int b_i = 0;
        this.hash_code = hash_code;
        for (a_i = 0; a.bases[a_i] != Unit.Empty; ++a_i) {}
        for (b_i = 0; b.bases[b_i] != Unit.Empty; ++b_i) {}
        int t_i = a_i + b_i + 1;
        this.bases = new BaseUnit[t_i];
        this.powers = new short[t_i];
        b_i = (a_i = (t_i = 0));
        while (true) {
            BaseUnit a_base = a.bases[a_i];
            final BaseUnit b_base = b.bases[b_i];
            int pow;
            if (a_base.index < b_base.index) {
                pow = a.powers[a_i] * mul_a;
                ++a_i;
            }
            else if (b_base.index < a_base.index) {
                a_base = b_base;
                pow = b.powers[b_i] * mul_b;
                ++b_i;
            }
            else {
                if (b_base == Unit.Empty) {
                    this.bases[t_i] = Unit.Empty;
                    this.enterHash(hash_code);
                    return;
                }
                pow = a.powers[a_i] * mul_a + b.powers[b_i] * mul_b;
                ++a_i;
                ++b_i;
                if (pow == 0) {
                    continue;
                }
            }
            if ((short)pow != pow) {
                throw new ArithmeticException("overflow in dimensions");
            }
            this.bases[t_i] = a_base;
            this.powers[t_i++] = (short)pow;
        }
    }
    
    private boolean matchesProduct(final Dimensions a, final int mul_a, final Dimensions b, final int mul_b) {
        int a_i = 0;
        int b_i = 0;
        int t_i = 0;
        while (true) {
            BaseUnit a_base = a.bases[a_i];
            final BaseUnit b_base = b.bases[b_i];
            int pow;
            if (a_base.index < b_base.index) {
                pow = a.powers[a_i] * mul_a;
                ++a_i;
            }
            else if (b_base.index < a_base.index) {
                a_base = b_base;
                pow = b.powers[b_i] * mul_b;
                ++b_i;
            }
            else {
                if (b_base == Unit.Empty) {
                    return this.bases[t_i] == b_base;
                }
                pow = a.powers[a_i] * mul_a + b.powers[b_i] * mul_b;
                ++a_i;
                ++b_i;
                if (pow == 0) {
                    continue;
                }
            }
            if (this.bases[t_i] != a_base || this.powers[t_i] != pow) {
                return false;
            }
            ++t_i;
        }
    }
    
    public static Dimensions product(final Dimensions a, final int mul_a, final Dimensions b, final int mul_b) {
        final int hash = a.hashCode() * mul_a + b.hashCode() * mul_b;
        final int index = (hash & Integer.MAX_VALUE) % Dimensions.hashTable.length;
        for (Dimensions dim = Dimensions.hashTable[index]; dim != null; dim = dim.chain) {
            if (dim.hash_code == hash && dim.matchesProduct(a, mul_a, b, mul_b)) {
                return dim;
            }
        }
        return new Dimensions(a, mul_a, b, mul_b, hash);
    }
    
    public int getPower(final BaseUnit unit) {
        for (int i = 0; this.bases[i].index <= unit.index; ++i) {
            if (this.bases[i] == unit) {
                return this.powers[i];
            }
        }
        return 0;
    }
    
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        for (int i = 0; this.bases[i] != Unit.Empty; ++i) {
            if (i > 0) {
                buf.append('*');
            }
            buf.append(this.bases[i]);
            final int pow = this.powers[i];
            if (pow != 1) {
                buf.append('^');
                buf.append(pow);
            }
        }
        return buf.toString();
    }
    
    static {
        Dimensions.hashTable = new Dimensions[100];
        Dimensions.Empty = new Dimensions();
    }
}
