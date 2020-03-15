// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.util.List;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;
import gnu.math.IntNum;
import java.util.Iterator;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.MultiplyOp;

public class Range<E> extends AbstractSequence<E> implements AVector<E>
{
    E start;
    Object step;
    int size;
    public static final IntRange zeroAndUp;
    
    public Range(final E start, final Object step, final int size) {
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
    public E get(final int index) {
        if (index >= this.size && this.size >= 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E)AddOp.$Pl(this.start, MultiplyOp.apply(index, this.step));
    }
    
    @Override
    public E getRaw(final int index) {
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
    
    public static void listAll(final Range r) {
        int i = 0;
        for (final Object x : r) {
            System.err.println("[" + i++ + "]: " + r);
        }
    }
    
    @Override
    public String toString() {
        return "#<range start:" + this.getStart() + " step:" + this.getStep() + " size:" + this.size + ">";
    }
    
    public static IntRange upto(final IntNum iistart, final IntNum iistep, final IntNum iiend, final boolean orEqual) {
        final int istart = iistart.intValue();
        final int istep = iistep.intValue();
        IntNum size = IntNum.sub(iiend, iistart);
        if (istep != 1) {
            size = IntNum.quotient(size, iistep, orEqual ? 3 : 2);
        }
        int isize;
        if (size.sign() < 0) {
            isize = 0;
        }
        else {
            if (IntNum.compare(size, Integer.MAX_VALUE - (orEqual ? 1 : 0)) > 0) {
                throw new IndexOutOfBoundsException("size too large");
            }
            isize = size.intValue() + (orEqual ? 1 : 0);
        }
        return new IntRange(istart, istep, isize);
    }
    
    public static IntRange downto(final IntNum iistart, final IntNum iistep, final IntNum iiend, final boolean orEqual) {
        final int istart = iistart.intValue();
        final int istep = iistep.intValue();
        IntNum size = IntNum.sub(iistart, iiend);
        if (istep != -1) {
            size = IntNum.quotient(size, IntNum.neg(iistep), orEqual ? 3 : 2);
        }
        int isize;
        if (size.sign() < 0) {
            isize = 0;
        }
        else {
            if (IntNum.compare(size, Integer.MAX_VALUE - (orEqual ? 1 : 0)) > 0) {
                throw new IndexOutOfBoundsException("size too large");
            }
            isize = size.intValue() + (orEqual ? 1 : 0);
        }
        return new IntRange(istart, istep, isize);
    }
    
    static {
        zeroAndUp = new IntRange(0, 1);
    }
    
    public static class IntRange extends Range<Integer> implements IntSequence, Externalizable
    {
        int istart;
        int istep;
        
        public IntRange(final int start, final int step, final int size) {
            super(start, step, size);
            this.istart = start;
            this.istep = step;
        }
        
        public IntRange(final int start, final int step) {
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
        public int getInt(final int index) {
            if (index >= this.size && this.size >= 0) {
                throw new IndexOutOfBoundsException("index:" + index + " size:" + this.size);
            }
            return this.istart + this.istep * index;
        }
        
        public IntRange subListFromRange(final int rstart, final int rstep, final int rsize) {
            final int nstart = this.istart + rstart * this.istep;
            final int nstep = this.istep * rstep;
            if (this.isUnbounded() && rsize == -1) {
                return new IntRange(nstart, nstep);
            }
            int nsize;
            if (this.isUnbounded()) {
                nsize = rsize;
            }
            else {
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
        
        @Override
        public IntRange subList(final int fromIx, final int toIx) {
            return this.subListFromRange(fromIx, 1, toIx - fromIx);
        }
        
        @Override
        public Integer getStart() {
            return this.getStartInt();
        }
        
        @Override
        public Integer get(final int index) {
            return this.getInt(index);
        }
        
        @Override
        public Integer getRaw(final int index) {
            return this.getInt(index);
        }
        
        @Override
        public int getIntRaw(final int index) {
            return this.getInt(index);
        }
        
        @Override
        public int getElementKind() {
            return 22;
        }
        
        @Override
        public void writeExternal(final ObjectOutput out) throws IOException {
            out.writeInt(this.size);
            out.writeInt(this.istart);
            out.writeInt(this.istep);
        }
        
        @Override
        public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
            this.size = in.readInt();
            this.istart = in.readInt();
            this.istep = in.readInt();
        }
    }
}
