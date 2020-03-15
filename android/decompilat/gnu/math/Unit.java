// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

public abstract class Unit extends Quantity
{
    Dimensions dims;
    double factor;
    MulUnit products;
    Unit base;
    static NamedUnit[] table;
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
    
    @Override
    public int hashCode() {
        return this.dims.hashCode();
    }
    
    public String getName() {
        return null;
    }
    
    static Unit times(Unit unit1, int power1, Unit unit2, int power2) {
        if (unit1 == unit2) {
            power1 += power2;
            unit2 = Unit.Empty;
            power2 = 0;
        }
        if (power1 == 0 || unit1 == Unit.Empty) {
            unit1 = unit2;
            power1 = power2;
            unit2 = Unit.Empty;
            power2 = 0;
        }
        if (power2 == 0 || unit2 == Unit.Empty) {
            if (power1 == 1) {
                return unit1;
            }
            if (power1 == 0) {
                return Unit.Empty;
            }
        }
        if (unit1 instanceof MulUnit) {
            final MulUnit munit1 = (MulUnit)unit1;
            if (munit1.unit1 == unit2) {
                return times(unit2, munit1.power1 * power1 + power2, munit1.unit2, munit1.power2 * power1);
            }
            if (munit1.unit2 == unit2) {
                return times(munit1.unit1, munit1.power1 * power1, unit2, munit1.power2 * power1 + power2);
            }
            if (unit2 instanceof MulUnit) {
                final MulUnit munit2 = (MulUnit)unit2;
                if (munit1.unit1 == munit2.unit1 && munit1.unit2 == munit2.unit2) {
                    return times(munit1.unit1, munit1.power1 * power1 + munit2.power1 * power2, munit1.unit2, munit1.power2 * power1 + munit2.power2 * power2);
                }
                if (munit1.unit1 == munit2.unit2 && munit1.unit2 == munit2.unit1) {
                    return times(munit1.unit1, munit1.power1 * power1 + munit2.power2 * power2, munit1.unit2, munit1.power2 * power1 + munit2.power1 * power2);
                }
            }
        }
        if (unit2 instanceof MulUnit) {
            final MulUnit munit3 = (MulUnit)unit2;
            if (munit3.unit1 == unit1) {
                return times(unit1, power1 + munit3.power1 * power2, munit3.unit2, munit3.power2 * power2);
            }
            if (munit3.unit2 == unit1) {
                return times(munit3.unit1, munit3.power1 * power2, unit1, power1 + munit3.power2 * power2);
            }
        }
        return MulUnit.make(unit1, power1, unit2, power2);
    }
    
    public static Unit times(final Unit unit1, final Unit unit2) {
        return times(unit1, 1, unit2, 1);
    }
    
    public static Unit divide(final Unit unit1, final Unit unit2) {
        return times(unit1, 1, unit2, -1);
    }
    
    public static Unit pow(final Unit unit, final int power) {
        return times(unit, power, Unit.Empty, 0);
    }
    
    Unit() {
        this.factor = 1.0;
    }
    
    public static NamedUnit make(final String name, final Quantity value) {
        return NamedUnit.make(name, value);
    }
    
    public static Unit define(final String name, final DQuantity value) {
        return new NamedUnit(name, value);
    }
    
    public static Unit define(final String name, final double factor, final Unit base) {
        return new NamedUnit(name, factor, base);
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
    public Numeric power(final IntNum y) {
        if (y.words != null) {
            throw new ArithmeticException("Unit raised to bignum power");
        }
        return pow(this, y.ival);
    }
    
    public Unit sqrt() {
        if (this == Unit.Empty) {
            return this;
        }
        throw new RuntimeException("unimplemented Unit.sqrt");
    }
    
    public static NamedUnit lookup(final String name) {
        return NamedUnit.lookup(name);
    }
    
    public String toString(final double val) {
        final String str = Double.toString(val);
        if (this == Unit.Empty) {
            return str;
        }
        return str + this.toString();
    }
    
    public String toString(final RealNum val) {
        return this.toString(val.doubleValue());
    }
    
    @Override
    public String toString() {
        final String name = this.getName();
        if (name != null) {
            return name;
        }
        if (this == Unit.Empty) {
            return "unit";
        }
        return Double.toString(this.factor) + "<unnamed unit>";
    }
    
    @Override
    public Unit unit() {
        return this;
    }
    
    static {
        Unit.table = new NamedUnit[100];
        Unit.Empty = new BaseUnit();
        Dimensions.Empty.bases[0] = Unit.Empty;
        Unit.NON_COMBINABLE = 0.0;
        meter = new BaseUnit("m", "Length");
        duration = new BaseUnit("duration", "Time");
        gram = new BaseUnit("g", "Mass");
        cm = define("cm", 0.01, Unit.meter);
        mm = define("mm", 0.1, Unit.cm);
        in = define("in", 0.0254, Unit.meter);
        pt = define("pt", 3.527778E-4, Unit.meter);
        pica = define("pica", 0.004233333, Unit.meter);
        radian = define("rad", 1.0, Unit.Empty);
        degree = define("deg", 0.017453292519943295, Unit.Empty);
        gradian = define("grad", 0.015707963267948967, Unit.Empty);
        date = new NamedUnit("date", Unit.NON_COMBINABLE, Unit.duration);
        second = new NamedUnit("s", Unit.NON_COMBINABLE, Unit.duration);
        month = new NamedUnit("month", Unit.NON_COMBINABLE, Unit.duration);
        minute = define("min", 60.0, Unit.second);
        hour = define("hour", 60.0, Unit.minute);
    }
}
