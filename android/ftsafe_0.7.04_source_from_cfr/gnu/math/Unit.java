/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.BaseUnit;
import gnu.math.Complex;
import gnu.math.DFloNum;
import gnu.math.DQuantity;
import gnu.math.Dimensions;
import gnu.math.IntNum;
import gnu.math.MulUnit;
import gnu.math.NamedUnit;
import gnu.math.Numeric;
import gnu.math.Quantity;
import gnu.math.Quaternion;
import gnu.math.RealNum;

public abstract class Unit
extends Quantity {
    Dimensions dims;
    double factor = 1.0;
    MulUnit products;
    Unit base;
    static NamedUnit[] table = new NamedUnit[100];
    public static BaseUnit Empty;
    public static double NON_COMBINABLE;
    public static final BaseUnit meter;
    public static final BaseUnit duration;
    public static final BaseUnit gram;
    public static final Unit cm;
    public static final Unit mm;
    public static final Unit in;
    public static final Unit pt;
    public static final Unit pica;
    public static final Unit radian;
    public static final Unit degree;
    public static final Unit gradian;
    public static final NamedUnit date;
    public static final NamedUnit second;
    public static final NamedUnit month;
    public static final Unit minute;
    public static final Unit hour;

    @Override
    public final Dimensions dimensions() {
        return this.dims;
    }

    @Override
    public final double doubleValue() {
        return this.factor;
    }

    public int hashCode() {
        return this.dims.hashCode();
    }

    public String getName() {
        return null;
    }

    static Unit times(Unit unit1, int power1, Unit unit2, int power2) {
        if (unit1 == unit2) {
            power1 += power2;
            unit2 = Empty;
            power2 = 0;
        }
        if (power1 == 0 || unit1 == Empty) {
            unit1 = unit2;
            power1 = power2;
            unit2 = Empty;
            power2 = 0;
        }
        if (power2 == 0 || unit2 == Empty) {
            if (power1 == 1) {
                return unit1;
            }
            if (power1 == 0) {
                return Empty;
            }
        }
        if (unit1 instanceof MulUnit) {
            MulUnit munit1 = (MulUnit)unit1;
            if (munit1.unit1 == unit2) {
                return Unit.times(unit2, munit1.power1 * power1 + power2, munit1.unit2, munit1.power2 * power1);
            }
            if (munit1.unit2 == unit2) {
                return Unit.times(munit1.unit1, munit1.power1 * power1, unit2, munit1.power2 * power1 + power2);
            }
            if (unit2 instanceof MulUnit) {
                MulUnit munit2 = (MulUnit)unit2;
                if (munit1.unit1 == munit2.unit1 && munit1.unit2 == munit2.unit2) {
                    return Unit.times(munit1.unit1, munit1.power1 * power1 + munit2.power1 * power2, munit1.unit2, munit1.power2 * power1 + munit2.power2 * power2);
                }
                if (munit1.unit1 == munit2.unit2 && munit1.unit2 == munit2.unit1) {
                    return Unit.times(munit1.unit1, munit1.power1 * power1 + munit2.power2 * power2, munit1.unit2, munit1.power2 * power1 + munit2.power1 * power2);
                }
            }
        }
        if (unit2 instanceof MulUnit) {
            MulUnit munit2 = (MulUnit)unit2;
            if (munit2.unit1 == unit1) {
                return Unit.times(unit1, power1 + munit2.power1 * power2, munit2.unit2, munit2.power2 * power2);
            }
            if (munit2.unit2 == unit1) {
                return Unit.times(munit2.unit1, munit2.power1 * power2, unit1, power1 + munit2.power2 * power2);
            }
        }
        return MulUnit.make(unit1, power1, unit2, power2);
    }

    public static Unit times(Unit unit1, Unit unit2) {
        return Unit.times(unit1, 1, unit2, 1);
    }

    public static Unit divide(Unit unit1, Unit unit2) {
        return Unit.times(unit1, 1, unit2, -1);
    }

    public static Unit pow(Unit unit, int power) {
        return Unit.times(unit, power, Empty, 0);
    }

    Unit() {
    }

    public static NamedUnit make(String name, Quantity value) {
        return NamedUnit.make(name, value);
    }

    public static Unit define(String name, DQuantity value) {
        return new NamedUnit(name, value);
    }

    public static Unit define(String name, double factor, Unit base2) {
        return new NamedUnit(name, factor, base2);
    }

    @Override
    public Complex number() {
        return DFloNum.one();
    }

    @Override
    public boolean isExact() {
        return false;
    }

    @Override
    public final boolean isZero() {
        return false;
    }

    @Override
    public Numeric power(IntNum y) {
        if (y.words != null) {
            throw new ArithmeticException("Unit raised to bignum power");
        }
        return Unit.pow(this, y.ival);
    }

    public Unit sqrt() {
        if (this == Empty) {
            return this;
        }
        throw new RuntimeException("unimplemented Unit.sqrt");
    }

    public static NamedUnit lookup(String name) {
        return NamedUnit.lookup(name);
    }

    public String toString(double val) {
        String str = Double.toString(val);
        if (this == Empty) {
            return str;
        }
        return str + this.toString();
    }

    public String toString(RealNum val) {
        return this.toString(val.doubleValue());
    }

    @Override
    public String toString() {
        String name = this.getName();
        if (name != null) {
            return name;
        }
        if (this == Empty) {
            return "unit";
        }
        return Double.toString(this.factor) + "<unnamed unit>";
    }

    @Override
    public Unit unit() {
        return this;
    }

    static {
        Dimensions.Empty.bases[0] = Empty = new BaseUnit();
        NON_COMBINABLE = 0.0;
        meter = new BaseUnit("m", "Length");
        duration = new BaseUnit("duration", "Time");
        gram = new BaseUnit("g", "Mass");
        cm = Unit.define("cm", 0.01, meter);
        mm = Unit.define("mm", 0.1, cm);
        in = Unit.define("in", 0.0254, meter);
        pt = Unit.define("pt", 3.527778E-4, meter);
        pica = Unit.define("pica", 0.004233333, meter);
        radian = Unit.define("rad", 1.0, Empty);
        degree = Unit.define("deg", 0.017453292519943295, Empty);
        gradian = Unit.define("grad", 0.015707963267948967, Empty);
        date = new NamedUnit("date", NON_COMBINABLE, duration);
        second = new NamedUnit("s", NON_COMBINABLE, duration);
        month = new NamedUnit("month", NON_COMBINABLE, duration);
        minute = Unit.define("min", 60.0, second);
        hour = Unit.define("hour", 60.0, minute);
    }
}

