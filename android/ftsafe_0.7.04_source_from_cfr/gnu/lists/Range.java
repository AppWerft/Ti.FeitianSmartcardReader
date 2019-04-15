/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.MultiplyOp;
import gnu.lists.AVector;
import gnu.lists.AbstractSequence;
import gnu.lists.IntSequence;
import gnu.math.IntNum;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.PrintStream;
import java.util.List;

public class Range<E>
extends AbstractSequence<E>
implements AVector<E> {
    E start;
    Object step;
    int size;
    public static final IntRange zeroAndUp = new IntRange(0, 1);

    public Range(E start, Object step, int size) {
        this.start = start;
        this.step = step;
        this.size = size;
    }

    public E getStart() {
        return this.start;
    }

    public Object getStep() {
        return this.step;
    }

    @Override
    public E get(int index) {
        if (index >= this.size && this.size >= 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E)AddOp.$Pl(this.start, MultiplyOp.apply(index, this.step));
    }

    @Override
    public E getRaw(int index) {
        return this.get(index);
    }

    @Override
    public int size() {
        return this.size;
    }

    public boolean isUnbounded() {
        return this.size < 0;
    }

    public boolean isUnspecifiedStart() {
        return this.size == -2;
    }

    public boolean isUnspecifiedLast() {
        return this.isUnbounded();
    }

    public static void listAll(Range r) {
        int i = 0;
        for (Object x : r) {
            System.err.println("[" + i++ + "]: " + r);
        }
    }

    @Override
    public String toString() {
        return "#<range start:" + this.getStart() + " step:" + this.getStep() + " size:" + this.size + ">";
    }

    public static IntRange upto(IntNum iistart, IntNum iistep, IntNum iiend, boolean orEqual) {
        int isize;
        int istart = iistart.intValue();
        int istep = iistep.intValue();
        IntNum size = IntNum.sub(iiend, iistart);
        if (istep != 1) {
            size = IntNum.quotient(size, iistep, orEqual ? 3 : 2);
        }
        if (size.sign() < 0) {
            isize = 0;
        } else {
            if (IntNum.compare(size, Integer.MAX_VALUE - (orEqual ? 1 : 0)) > 0) {
                throw new IndexOutOfBoundsException("size too large");
            }
            isize = size.intValue() + (orEqual ? 1 : 0);
        }
        return new IntRange(istart, istep, isize);
    }

    public static IntRange downto(IntNum iistart, IntNum iistep, IntNum iiend, boolean orEqual) {
        int isize;
        int istart = iistart.intValue();
        int istep = iistep.intValue();
        IntNum size = IntNum.sub(iistart, iiend);
        if (istep != -1) {
            size = IntNum.quotient(size, IntNum.neg(iistep), orEqual ? 3 : 2);
        }
        if (size.sign() < 0) {
            isize = 0;
        } else {
            if (IntNum.compare(size, Integer.MAX_VALUE - (orEqual ? 1 : 0)) > 0) {
                throw new IndexOutOfBoundsException("size too large");
            }
            isize = size.intValue() + (orEqual ? 1 : 0);
        }
        return new IntRange(istart, istep, isize);
    }

    public static class IntRange
    extends Range<Integer>
    implements IntSequence,
    Externalizable {
        int istart;
        int istep;

        public IntRange(int start, int step, int size) {
            super(start, step, size);
            this.istart = start;
            this.istep = step;
        }

        public IntRange(int start, int step) {
            super(start, step, -1);
            this.istart = start;
            this.istep = step;
        }

        public int getStartInt() {
            return this.istart;
        }

        public int getLastInt() {
            return this.istart + (this.size - 1) * this.istep;
        }

        public int getStepInt() {
            return this.istep;
        }

        @Override
        public int getInt(int index) {
            if (index >= this.size && this.size >= 0) {
                throw new IndexOutOfBoundsException("index:" + index + " size:" + this.size);
            }
            return this.istart + this.istep * index;
        }

        public IntRange subListFromRange(int rstart, int rstep, int rsize) {
            int nsize;
            int nstart = this.istart + rstart * this.istep;
            int nstep = this.istep * rstep;
            if (this.isUnbounded() && rsize == -1) {
                return new IntRange(nstart, nstep);
            }
            if (this.isUnbounded()) {
                nsize = rsize;
            } else {
                nsize = (this.size - rstart + rstep - 1) / rstep;
                if (rsize != -1) {
                    if (rsize > nsize) {
                        throw new IndexOutOfBoundsException();
                    }
                    nsize = rsize;
                }
            }
            return new IntRange(nstart, nstep, nsize);
        }

        public IntRange subList(int fromIx, int toIx) {
            return this.subListFromRange(fromIx, 1, toIx - fromIx);
        }

        @Override
        public Integer getStart() {
            return this.getStartInt();
        }

        @Override
        public Integer get(int index) {
            return this.getInt(index);
        }

        @Override
        public Integer getRaw(int index) {
            return this.getInt(index);
        }

        @Override
        public int getIntRaw(int index) {
            return this.getInt(index);
        }

        @Override
        public int getElementKind() {
            return 22;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(this.size);
            out.writeInt(this.istart);
            out.writeInt(this.istep);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.size = in.readInt();
            this.istart = in.readInt();
            this.istep = in.readInt();
        }
    }

}

