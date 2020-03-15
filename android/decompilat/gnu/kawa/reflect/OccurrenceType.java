// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.expr.Language;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.bytecode.ObjectType;
import gnu.bytecode.ArrayType;
import gnu.bytecode.PrimType;
import gnu.mapping.Procedure;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.bytecode.CodeAttr;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.bytecode.Variable;
import gnu.lists.AbstractSequence;
import gnu.lists.ItemPredicate;
import gnu.mapping.Values;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.expr.TypeValue;
import java.io.Externalizable;
import gnu.bytecode.Type;

public class OccurrenceType extends Type implements Externalizable, TypeValue
{
    Type base;
    int minOccurs;
    int maxOccurs;
    public static final Type emptySequenceType;
    public static final ClassType typeOccurrenceType;
    static final Method isInstanceMethod;
    
    public Type getBase() {
        return this.base;
    }
    
    protected void setBase(final Type base) {
        this.base = base;
    }
    
    public int minOccurs() {
        return this.minOccurs;
    }
    
    public int maxOccurs() {
        return this.maxOccurs;
    }
    
    public OccurrenceType(final Type base, final int minOccurs, final int maxOccurs) {
        super(Type.objectType);
        this.setName(null);
        this.base = base;
        this.minOccurs = minOccurs;
        this.maxOccurs = maxOccurs;
    }
    
    public static Type getInstance(Type base, int minOccurs, int maxOccurs) {
        if (minOccurs == 1 && maxOccurs == 1) {
            return base;
        }
        if (minOccurs == 0 && maxOccurs < 0 && (base == SingletonType.instance || base == Type.pointer_type)) {
            return Type.pointer_type;
        }
        if (base instanceof OccurrenceType) {
            final OccurrenceType occ = (OccurrenceType)base;
            minOccurs *= occ.minOccurs;
            maxOccurs = ((maxOccurs < 0 || occ.maxOccurs < 0) ? -1 : (maxOccurs * occ.maxOccurs));
            base = occ.base;
        }
        return new OccurrenceType(base, minOccurs, maxOccurs);
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
            final OccurrenceType occOther = (OccurrenceType)other;
            if (this.minOccurs == occOther.minOccurs && this.maxOccurs == occOther.maxOccurs) {
                return this.base.compare(occOther.getBase());
            }
        }
        final int numThis = itemCountRange(this);
        final int numOther = itemCountRange(other);
        final int minThis = numThis & 0xFFF;
        final int minOther = numOther & 0xFFF;
        final int maxThis = numThis >> 12;
        final int maxOther = numOther >> 12;
        if ((minThis > maxOther && maxOther >= 0) || (minOther > maxThis && maxThis >= 0)) {
            return -3;
        }
        return -2;
    }
    
    @Override
    public Object coerceFromObject(final Object obj) {
        if (!(obj instanceof Values)) {
            if (this.minOccurs <= 1 && this.maxOccurs != 0) {
                return this.base.coerceFromObject(obj);
            }
        }
        if (!this.isInstance(obj)) {
            throw new ClassCastException();
        }
        return obj;
    }
    
    @Override
    public boolean isInstance(final Object obj) {
        if (!(obj instanceof Values)) {
            return this.minOccurs <= 1 && this.maxOccurs != 0 && this.base.isInstance(obj);
        }
        final Values vals = (Values)obj;
        int pos = vals.startPos();
        int n = 0;
        if (this.base instanceof ItemPredicate) {
            final ItemPredicate pred = (ItemPredicate)this.base;
            while (true) {
                final boolean matches = pred.isInstancePos(vals, pos);
                pos = vals.nextPos(pos);
                if (pos == 0) {
                    return n >= this.minOccurs && (this.maxOccurs < 0 || n <= this.maxOccurs);
                }
                if (!matches) {
                    return false;
                }
                ++n;
            }
        }
        else {
            while (true) {
                pos = vals.nextPos(pos);
                if (pos == 0) {
                    return n >= this.minOccurs && (this.maxOccurs < 0 || n <= this.maxOccurs);
                }
                final Object value = vals.getPosPrevious(pos);
                if (!this.base.isInstance(value)) {
                    return false;
                }
                ++n;
            }
        }
    }
    
    @Override
    public void emitTestIf(final Variable incoming, final Declaration decl, final Compilation comp) {
        final CodeAttr code = comp.getCode();
        if (incoming != null) {
            code.emitLoad(incoming);
        }
        if (decl != null) {
            code.emitDup();
            decl.compileStore(comp);
        }
        comp.compileConstant(this);
        code.emitSwap();
        code.emitInvokeVirtual(OccurrenceType.isInstanceMethod);
        code.emitIfIntNotZero();
    }
    
    @Override
    public void emitIsInstance(final Variable incoming, final Compilation comp, final Target target) {
        InstanceOf.emitIsInstance(this, incoming, comp, target);
    }
    
    @Override
    public Expression convertValue(final Expression value) {
        return null;
    }
    
    @Override
    public Procedure getConstructor() {
        return null;
    }
    
    public static int itemCountRange(final Type type) {
        if (type instanceof SingletonType) {
            return 4097;
        }
        if (type instanceof OccurrenceType) {
            final OccurrenceType occ = (OccurrenceType)type;
            int min = occ.minOccurs();
            int max = occ.maxOccurs();
            final int bnum = itemCountRange(occ.getBase());
            if ((min == 1 && max == 1) || bnum == 0) {
                return bnum;
            }
            if (max > 1048575) {
                max = -1;
            }
            if (max == 0) {
                return 0;
            }
            final int bmin = bnum & 0xFFF;
            final int bmax = bnum >> 12;
            if (bnum != 4097) {
                if (min > 4095) {
                    min = 4095;
                }
                min *= bmin;
                if (min > 4095) {
                    min = 4095;
                }
                if (max < 0 || bmax < 0) {
                    max = -1;
                }
                else {
                    max *= bmax;
                }
                if (max > 1048575) {
                    max = -1;
                }
            }
            return max << 12 | min;
        }
        else {
            if (type instanceof PrimType) {
                return type.isVoid() ? 0 : 4097;
            }
            if (type instanceof ArrayType) {
                return 4097;
            }
            if (type instanceof ObjectType) {
                final int cmp = type.compare(Compilation.typeValues);
                if (cmp == -3) {
                    return 4097;
                }
            }
            return -4096;
        }
    }
    
    public static char itemCountCode(final Type type) {
        final int num = itemCountRange(type);
        final int min = num & 0xFFF;
        final int max = num >> 12;
        return (max == 0) ? '0' : ((min == 0) ? ((max == 1) ? '?' : '*') : ((min == 1 && max == 1) ? '1' : '+'));
    }
    
    public static boolean itemCountIsZeroOrOne(final Type type) {
        return itemCountRange(type) >> 13 == 0;
    }
    
    public static int itemCountMin(final Type type) {
        return itemCountRange(type) & 0xFFF;
    }
    
    public static int itemCountMax(final Type type) {
        return itemCountRange(type) >> 12;
    }
    
    public static boolean itemCountIsOne(final Type type) {
        return itemCountRange(type) == 4097;
    }
    
    public static int compatibleWithCount(final Type type, final int count) {
        final int num = itemCountRange(type);
        final int min = num & 0xFFF;
        final int max = num >> 12;
        return (count < min) ? -1 : ((max >= 0 && count > max) ? 1 : 0);
    }
    
    public static Type itemPrimeType(Type type) {
        while (type instanceof OccurrenceType) {
            type = ((OccurrenceType)type).getBase();
        }
        return itemCountIsOne(type) ? type : SingletonType.instance;
    }
    
    @Override
    public String toString() {
        final String b = this.base.toString();
        final boolean parens = b == null || b.indexOf(32) >= 0;
        final StringBuffer sbuf = new StringBuffer();
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
            }
            else if (this.minOccurs == 1 && this.maxOccurs == -1) {
                sbuf.append('+');
            }
            else if (this.minOccurs == 0 && this.maxOccurs == -1) {
                sbuf.append('*');
            }
            else {
                sbuf.append('{');
                sbuf.append(this.minOccurs);
                sbuf.append(',');
                if (this.maxOccurs >= 0) {
                    sbuf.append(this.maxOccurs);
                }
                else {
                    sbuf.append('*');
                }
                sbuf.append('}');
            }
        }
        return sbuf.toString();
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.base);
        out.writeInt(this.minOccurs);
        out.writeInt(this.maxOccurs);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.base = (Type)in.readObject();
        this.minOccurs = in.readInt();
        this.maxOccurs = in.readInt();
    }
    
    @Override
    public String encodeType(final Language language) {
        return null;
    }
    
    static {
        emptySequenceType = getInstance(SingletonType.instance, 0, 0);
        typeOccurrenceType = ClassType.make("gnu.kawa.reflect.OccurrenceType");
        isInstanceMethod = OccurrenceType.typeOccurrenceType.getDeclaredMethod("isInstance", 1);
    }
}
