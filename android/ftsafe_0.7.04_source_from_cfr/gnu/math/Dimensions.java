/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.BaseUnit;
import gnu.math.Unit;

public class Dimensions {
    BaseUnit[] bases;
    short[] powers;
    int hash_code;
    private Dimensions chain;
    private static Dimensions[] hashTable = new Dimensions[100];
    public static Dimensions Empty = new Dimensions();

    public final int hashCode() {
        return this.hash_code;
    }

    private void enterHash(int hash_code) {
        this.hash_code = hash_code;
        int index = (hash_code & Integer.MAX_VALUE) % hashTable.length;
        this.chain = hashTable[index];
        Dimensions.hashTable[index] = this;
    }

    private Dimensions() {
        this.bases = new BaseUnit[1];
        this.bases[0] = Unit.Empty;
        this.enterHash(0);
    }

    Dimensions(BaseUnit unit) {
        this.bases = new BaseUnit[2];
        this.powers = new short[1];
        this.bases[0] = unit;
        this.bases[1] = Unit.Empty;
        this.powers[0] = 1;
        this.enterHash(unit.index);
    }

    private Dimensions(Dimensions a, int mul_a, Dimensions b, int mul_b, int hash_code) {
        int a_i = 0;
        int b_i = 0;
        this.hash_code = hash_code;
        a_i = 0;
        while (a.bases[a_i] != Unit.Empty) {
            ++a_i;
        }
        b_i = 0;
        while (b.bases[b_i] != Unit.Empty) {
            ++b_i;
        }
        int t_i = a_i + b_i + 1;
        this.bases = new BaseUnit[t_i];
        this.powers = new short[t_i];
        t_i = 0;
        b_i = 0;
        a_i = 0;
        do {
            int pow;
            BaseUnit a_base = a.bases[a_i];
            BaseUnit b_base = b.bases[b_i];
            if (a_base.index < b_base.index) {
                pow = a.powers[a_i] * mul_a;
                ++a_i;
            } else if (b_base.index < a_base.index) {
                a_base = b_base;
                pow = b.powers[b_i] * mul_b;
                ++b_i;
            } else {
                if (b_base == Unit.Empty) break;
                pow = a.powers[a_i] * mul_a + b.powers[b_i] * mul_b;
                ++a_i;
                ++b_i;
                if (pow == 0) continue;
            }
            if ((short)pow != pow) {
                throw new ArithmeticException("overflow in dimensions");
            }
            this.bases[t_i] = a_base;
            this.powers[t_i++] = (short)pow;
        } while (true);
        this.bases[t_i] = Unit.Empty;
        this.enterHash(hash_code);
    }

    private boolean matchesProduct(Dimensions a, int mul_a, Dimensions b, int mul_b) {
        int a_i = 0;
        int b_i = 0;
        int t_i = 0;
        do {
            int pow;
            BaseUnit a_base = a.bases[a_i];
            BaseUnit b_base = b.bases[b_i];
            if (a_base.index < b_base.index) {
                pow = a.powers[a_i] * mul_a;
                ++a_i;
            } else if (b_base.index < a_base.index) {
                a_base = b_base;
                pow = b.powers[b_i] * mul_b;
                ++b_i;
            } else {
                if (b_base == Unit.Empty) {
                    return this.bases[t_i] == b_base;
                }
                pow = a.powers[a_i] * mul_a + b.powers[b_i] * mul_b;
                ++a_i;
                ++b_i;
                if (pow == 0) continue;
            }
            if (this.bases[t_i] != a_base || this.powers[t_i] != pow) {
                return false;
            }
            ++t_i;
        } while (true);
    }

    public static Dimensions product(Dimensions a, int mul_a, Dimensions b, int mul_b) {
        int hash = a.hashCode() * mul_a + b.hashCode() * mul_b;
        int index = (hash & Integer.MAX_VALUE) % hashTable.length;
        Dimensions dim = hashTable[index];
        while (dim != null) {
            if (dim.hash_code == hash && dim.matchesProduct(a, mul_a, b, mul_b)) {
                return dim;
            }
            dim = dim.chain;
        }
        return new Dimensions(a, mul_a, b, mul_b, hash);
    }

    public int getPower(BaseUnit unit) {
        int i = 0;
        while (this.bases[i].index <= unit.index) {
            if (this.bases[i] == unit) {
                return this.powers[i];
            }
            ++i;
        }
        return 0;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        int i = 0;
        while (this.bases[i] != Unit.Empty) {
            if (i > 0) {
                buf.append('*');
            }
            buf.append(this.bases[i]);
            short pow = this.powers[i];
            if (pow != 1) {
                buf.append('^');
                buf.append(pow);
            }
            ++i;
        }
        return buf.toString();
    }
}

