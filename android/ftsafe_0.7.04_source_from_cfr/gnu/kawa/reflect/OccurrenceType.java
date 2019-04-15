/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.reflect.LazyType;
import gnu.kawa.reflect.SingletonType;
import gnu.lists.AbstractSequence;
import gnu.lists.ItemPredicate;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class OccurrenceType
extends Type
implements Externalizable,
TypeValue {
    Type base;
    int minOccurs;
    int maxOccurs;
    public static final Type emptySequenceType = OccurrenceType.getInstance(SingletonType.instance, 0, 0);
    public static final ClassType typeOccurrenceType = ClassType.make("gnu.kawa.reflect.OccurrenceType");
    static final Method isInstanceMethod = typeOccurrenceType.getDeclaredMethod("isInstance", 1);

    public Type getBase() {
        return this.base;
    }

    protected void setBase(Type base2) {
        this.base = base2;
    }

    public int minOccurs() {
        return this.minOccurs;
    }

    public int maxOccurs() {
        return this.maxOccurs;
    }

    public OccurrenceType(Type base2, int minOccurs, int maxOccurs) {
        super(Type.objectType);
        this.setName(null);
        this.base = base2;
        this.minOccurs = minOccurs;
        this.maxOccurs = maxOccurs;
    }

    public static Type getInstance(Type base2, int minOccurs, int maxOccurs) {
        if (minOccurs == 1 && maxOccurs == 1) {
            return base2;
        }
        if (minOccurs == 0 && maxOccurs < 0 && (base2 == SingletonType.instance || base2 == Type.pointer_type)) {
            return Type.pointer_type;
        }
        if (base2 instanceof OccurrenceType) {
            OccurrenceType occ = (OccurrenceType)base2;
            minOccurs *= occ.minOccurs;
            maxOccurs = maxOccurs < 0 || occ.maxOccurs < 0 ? -1 : maxOccurs * occ.maxOccurs;
            base2 = occ.base;
        }
        return new OccurrenceType(base2, minOccurs, maxOccurs);
    }

    @Override
    public Type getImplementationType() {
        return Type.pointer_type;
    }

    @Override
    public int compare(Type other) {
        if (other instanceof LazyType) {
            other = ((LazyType)other).getValueType();
        }
        if (other instanceof OccurrenceType) {
            OccurrenceType occOther = (OccurrenceType)other;
            if (this.minOccurs == occOther.minOccurs && this.maxOccurs == occOther.maxOccurs) {
                return this.base.compare(occOther.getBase());
            }
        }
        int numThis = OccurrenceType.itemCountRange(this);
        int numOther = OccurrenceType.itemCountRange(other);
        int minThis = numThis & 4095;
        int minOther = numOther & 4095;
        int maxThis = numThis >> 12;
        int maxOther = numOther >> 12;
        if (minThis > maxOther && maxOther >= 0 || minOther > maxThis && maxThis >= 0) {
            return -3;
        }
        return -2;
    }

    @Override
    public Object coerceFromObject(Object obj) {
        if (!(obj instanceof Values) && this.minOccurs <= 1 && this.maxOccurs != 0) {
            return this.base.coerceFromObject(obj);
        }
        if (!this.isInstance(obj)) {
            throw new ClassCastException();
        }
        return obj;
    }

    @Override
    public boolean isInstance(Object obj) {
        if (obj instanceof Values) {
            Values vals = (Values)obj;
            int pos = vals.startPos();
            int n = 0;
            if (this.base instanceof ItemPredicate) {
                ItemPredicate pred = (ItemPredicate)((Object)this.base);
                do {
                    boolean matches = pred.isInstancePos(vals, pos);
                    if ((pos = vals.nextPos(pos)) == 0) {
                        return n >= this.minOccurs && (this.maxOccurs < 0 || n <= this.maxOccurs);
                    }
                    if (!matches) {
                        return false;
                    }
                    ++n;
                } while (true);
            }
            do {
                if ((pos = vals.nextPos(pos)) == 0) {
                    return n >= this.minOccurs && (this.maxOccurs < 0 || n <= this.maxOccurs);
                }
                Object value = vals.getPosPrevious(pos);
                if (!this.base.isInstance(value)) {
                    return false;
                }
                ++n;
            } while (true);
        }
        if (this.minOccurs > 1 || this.maxOccurs == 0) {
            return false;
        }
        return this.base.isInstance(obj);
    }

    @Override
    public void emitTestIf(Variable incoming, Declaration decl, Compilation comp) {
        CodeAttr code = comp.getCode();
        if (incoming != null) {
            code.emitLoad(incoming);
        }
        if (decl != null) {
            code.emitDup();
            decl.compileStore(comp);
        }
        comp.compileConstant(this);
        code.emitSwap();
        code.emitInvokeVirtual(isInstanceMethod);
        code.emitIfIntNotZero();
    }

    @Override
    public void emitIsInstance(Variable incoming, Compilation comp, Target target) {
        InstanceOf.emitIsInstance(this, incoming, comp, target);
    }

    @Override
    public Expression convertValue(Expression value) {
        return null;
    }

    @Override
    public Procedure getConstructor() {
        return null;
    }

    public static int itemCountRange(Type type) {
        int cmp;
        if (type instanceof SingletonType) {
            return 4097;
        }
        if (type instanceof OccurrenceType) {
            OccurrenceType occ = (OccurrenceType)type;
            int min = occ.minOccurs();
            int max = occ.maxOccurs();
            int bnum = OccurrenceType.itemCountRange(occ.getBase());
            if (min == 1 && max == 1 || bnum == 0) {
                return bnum;
            }
            if (max > 1048575) {
                max = -1;
            }
            if (max == 0) {
                return 0;
            }
            int bmin = bnum & 4095;
            int bmax = bnum >> 12;
            if (bnum != 4097) {
                if (min > 4095) {
                    min = 4095;
                }
                if ((min *= bmin) > 4095) {
                    min = 4095;
                }
                max = max < 0 || bmax < 0 ? -1 : (max *= bmax);
                if (max > 1048575) {
                    max = -1;
                }
            }
            return max << 12 | min;
        }
        if (type instanceof PrimType) {
            return type.isVoid() ? 0 : 4097;
        }
        if (type instanceof ArrayType) {
            return 4097;
        }
        if (type instanceof ObjectType && (cmp = type.compare(Compilation.typeValues)) == -3) {
            return 4097;
        }
        return -4096;
    }

    public static char itemCountCode(Type type) {
        int num = OccurrenceType.itemCountRange(type);
        int min = num & 4095;
        int max = num >> 12;
        return (char)(max == 0 ? 48 : (min == 0 ? (max == 1 ? 63 : 42) : (min == 1 && max == 1 ? 49 : 43)));
    }

    public static boolean itemCountIsZeroOrOne(Type type) {
        return OccurrenceType.itemCountRange(type) >> 13 == 0;
    }

    public static int itemCountMin(Type type) {
        return OccurrenceType.itemCountRange(type) & 4095;
    }

    public static int itemCountMax(Type type) {
        return OccurrenceType.itemCountRange(type) >> 12;
    }

    public static boolean itemCountIsOne(Type type) {
        return OccurrenceType.itemCountRange(type) == 4097;
    }

    public static int compatibleWithCount(Type type, int count) {
        int num = OccurrenceType.itemCountRange(type);
        int min = num & 4095;
        int max = num >> 12;
        return count < min ? -1 : (max >= 0 && count > max ? 1 : 0);
    }

    public static Type itemPrimeType(Type type) {
        while (type instanceof OccurrenceType) {
            type = ((OccurrenceType)type).getBase();
        }
        return OccurrenceType.itemCountIsOne(type) ? type : SingletonType.instance;
    }

    @Override
    public String toString() {
        String b = this.base.toString();
        boolean parens = b == null || b.indexOf(32) >= 0;
        StringBuffer sbuf = new StringBuffer();
        if (parens) {
            sbuf.append('(');
        }
        sbuf.append(b);
        if (parens) {
            sbuf.append(')');
        }
        if (this.minOccurs != 1 || this.maxOccurs != 1) {
            if (this.minOccurs == 0 && this.maxOccurs == 1) {
                sbuf.append('?');
            } else if (this.minOccurs == 1 && this.maxOccurs == -1) {
                sbuf.append('+');
            } else if (this.minOccurs == 0 && this.maxOccurs == -1) {
                sbuf.append('*');
            } else {
                sbuf.append('{');
                sbuf.append(this.minOccurs);
                sbuf.append(',');
                if (this.maxOccurs >= 0) {
                    sbuf.append(this.maxOccurs);
                } else {
                    sbuf.append('*');
                }
                sbuf.append('}');
            }
        }
        return sbuf.toString();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.base);
        out.writeInt(this.minOccurs);
        out.writeInt(this.maxOccurs);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.base = (Type)in.readObject();
        this.minOccurs = in.readInt();
        this.maxOccurs = in.readInt();
    }

    @Override
    public String encodeType(Language language) {
        return null;
    }
}

