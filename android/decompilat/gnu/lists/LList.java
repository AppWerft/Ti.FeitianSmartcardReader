// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.ObjectStreamException;
import java.io.ObjectOutput;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.Iterator;
import java.util.List;
import gnu.kawa.util.HashUtils;
import java.io.Externalizable;

public class LList extends ExtSequence<Object> implements Sequence<Object>, Externalizable, Comparable
{
    public static final EmptyList Empty;
    
    public static int listLength(final Object obj, final boolean allowOtherSequence) {
        int n = 0;
        Object slow = obj;
        Object fast = obj;
        while (fast != LList.Empty) {
            if (!(fast instanceof Pair)) {
                if (fast instanceof Sequence && allowOtherSequence) {
                    final int j = ((Sequence)fast).size();
                    return (j >= 0) ? (n + j) : j;
                }
                return -2;
            }
            else {
                final Pair fast_pair = (Pair)fast;
                final Object fast_cdr = fast_pair.getCdr();
                if (fast_cdr == LList.Empty) {
                    return n + 1;
                }
                if (fast == slow && n > 0) {
                    return -1;
                }
                if (!(fast_cdr instanceof Pair)) {
                    ++n;
                    fast = fast_cdr;
                }
                else {
                    if (!(slow instanceof Pair)) {
                        return -2;
                    }
                    slow = ((Pair)slow).getCdr();
                    fast = ((Pair)fast_cdr).getCdr();
                    n += 2;
                }
            }
        }
        return n;
    }
    
    @Override
    public boolean equals(final Object obj) {
        return this == obj;
    }
    
    @Override
    public int compareTo(final Object obj) {
        return (obj == LList.Empty) ? 0 : -1;
    }
    
    @Override
    public int size() {
        return 0;
    }
    
    @Override
    public boolean isEmpty() {
        return true;
    }
    
    @Override
    public SeqPosition getIterator(final int index) {
        return new LListPosition(this, index, false);
    }
    
    @Override
    public int createPos(final int index, final boolean isAfter) {
        final ExtPosition pos = new LListPosition(this, index, isAfter);
        return PositionManager.manager.register(pos);
    }
    
    @Override
    public int createRelativePos(final int pos, int delta, final boolean isAfter) {
        final boolean old_after = this.isAfterPos(pos);
        if (delta < 0 || pos == 0) {
            return super.createRelativePos(pos, delta, isAfter);
        }
        if (delta == 0) {
            if (isAfter == old_after) {
                return this.copyPos(pos);
            }
            if (isAfter && !old_after) {
                return super.createRelativePos(pos, delta, isAfter);
            }
        }
        if (pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        final LListPosition old = (LListPosition)PositionManager.getPositionObject(pos);
        if (old.xpos == null) {
            return super.createRelativePos(pos, delta, isAfter);
        }
        final LListPosition it = new LListPosition(old);
        Object it_xpos = it.xpos;
        int it_ipos = it.ipos;
        if (isAfter && !old_after) {
            --delta;
            it_ipos += 3;
        }
        if (!isAfter && old_after) {
            ++delta;
            it_ipos -= 3;
        }
        while (it_xpos instanceof Pair) {
            if (--delta < 0) {
                it.ipos = it_ipos;
                it.xpos = it_xpos;
                return PositionManager.manager.register(it);
            }
            final Pair p = (Pair)it_xpos;
            it_ipos += 2;
            it_xpos = p.getCdr();
        }
        throw new IndexOutOfBoundsException();
    }
    
    @Override
    public boolean hasNext(final int ipos) {
        return false;
    }
    
    @Override
    public int nextPos(final int ipos) {
        return 0;
    }
    
    @Override
    public Object getPosNext(final int ipos) {
        return LList.eofValue;
    }
    
    @Override
    public Object getPosPrevious(final int ipos) {
        return LList.eofValue;
    }
    
    @Override
    protected void setPosNext(final int ipos, final Object value) {
        if (ipos <= 0) {
            if (ipos == -1 || !(this instanceof Pair)) {
                throw new IndexOutOfBoundsException();
            }
            ((Pair)this).car = value;
        }
        else {
            PositionManager.getPositionObject(ipos).setNext(value);
        }
    }
    
    @Override
    protected void setPosPrevious(final int ipos, final Object value) {
        if (ipos <= 0) {
            if (ipos == 0 || !(this instanceof Pair)) {
                throw new IndexOutOfBoundsException();
            }
            ((Pair)this).lastPair().car = value;
        }
        else {
            PositionManager.getPositionObject(ipos).setPrevious(value);
        }
    }
    
    @Override
    public Object get(final int index) {
        throw new IndexOutOfBoundsException();
    }
    
    public static final int length(Object arg) {
        int count = 0;
        while (arg instanceof Pair) {
            ++count;
            arg = ((Pair)arg).getCdr();
        }
        return count;
    }
    
    @Override
    public int boundedHash(int seed, int limit) {
        Object list = this;
        final int sublimit = limit >> 1;
        int count;
        Pair pair;
        for (count = 0; list instanceof Pair && ++count <= limit; list = pair.getCdr()) {
            pair = (Pair)list;
            final int h = HashUtils.boundedHash(pair.getCar(), 0, sublimit);
            seed = HashUtils.murmur3step(seed, h);
        }
        if (--limit >= 0 && list != LList.Empty && list != null) {
            final int h2 = HashUtils.boundedHash(list, 0, sublimit);
            seed = HashUtils.murmur3step(seed, h2);
            ++count;
        }
        return HashUtils.murmur3finish(seed, count);
    }
    
    @Override
    public int hashCode() {
        int hash = 1;
        Object list;
        Pair pair;
        for (list = this; list instanceof Pair; list = pair.getCdr()) {
            pair = (Pair)list;
            final Object obj = pair.getCar();
            hash = 31 * hash + ((obj == null) ? 0 : obj.hashCode());
        }
        if (list != LList.Empty && list != null) {
            hash ^= list.hashCode();
        }
        return hash;
    }
    
    public static LList makeList(final List vals) {
        final Iterator e = vals.iterator();
        LList result = LList.Empty;
        Pair last = null;
        while (e.hasNext()) {
            final Pair pair = new Pair(e.next(), LList.Empty);
            if (last == null) {
                result = pair;
            }
            else {
                last.cdr = pair;
            }
            last = pair;
        }
        return result;
    }
    
    public static LList makeList(final Object[] vals, final int offset, final int length) {
        LList result = LList.Empty;
        int i = length;
        while (--i >= 0) {
            result = new Pair(vals[offset + i], result);
        }
        return result;
    }
    
    public static LList makeList(final Object[] vals, final int offset) {
        LList result = LList.Empty;
        int i = vals.length - offset;
        while (--i >= 0) {
            result = new Pair(vals[offset + i], result);
        }
        return result;
    }
    
    @Override
    public void consume(final Consumer out) {
        Object list = this;
        out.startElement("list");
        while (list instanceof Pair) {
            if (list != this) {
                out.write(32);
            }
            final Pair pair = (Pair)list;
            out.writeObject(pair.getCar());
            list = pair.getCdr();
        }
        if (list != LList.Empty) {
            out.write(32);
            out.write(". ");
            out.writeObject(checkNonList(list));
        }
        out.endElement();
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
    }
    
    public Object readResolve() throws ObjectStreamException {
        return LList.Empty;
    }
    
    public static Pair list1(final Object arg1) {
        return new Pair(arg1, LList.Empty);
    }
    
    public static Pair list2(final Object arg1, final Object arg2) {
        return new Pair(arg1, new Pair(arg2, LList.Empty));
    }
    
    public static Pair list3(final Object arg1, final Object arg2, final Object arg3) {
        return new Pair(arg1, new Pair(arg2, new Pair(arg3, LList.Empty)));
    }
    
    public static Pair list4(final Object arg1, final Object arg2, final Object arg3, final Object arg4) {
        return new Pair(arg1, new Pair(arg2, new Pair(arg3, new Pair(arg4, LList.Empty))));
    }
    
    public static Pair chain1(final Pair old, final Object arg1) {
        final Pair p1 = new Pair(arg1, LList.Empty);
        return (Pair)(old.cdr = p1);
    }
    
    public static Pair chain4(final Pair old, final Object arg1, final Object arg2, final Object arg3, final Object arg4) {
        final Pair p4 = new Pair(arg4, LList.Empty);
        old.cdr = new Pair(arg1, new Pair(arg2, new Pair(arg3, p4)));
        return p4;
    }
    
    public static LList reverseInPlace(Object list) {
        LList prev;
        Pair pair;
        for (prev = LList.Empty; list != LList.Empty; list = pair.cdr, pair.cdr = prev, prev = pair) {
            pair = (Pair)list;
        }
        return prev;
    }
    
    public static Object consX(final Object[] args) {
        final Object first = args[0];
        final int n = args.length - 1;
        if (n <= 0) {
            return first;
        }
        Pair prev;
        final Pair result = prev = new Pair(first, null);
        for (int i = 1; i < n; ++i) {
            final Pair next = new Pair(args[i], null);
            prev.cdr = next;
            prev = next;
        }
        prev.cdr = args[n];
        return result;
    }
    
    @Override
    public String toString() {
        Object rest = this;
        int i = 0;
        final StringBuffer sbuf = new StringBuffer(100);
        sbuf.append('(');
        while (true) {
            while (rest != LList.Empty) {
                if (i > 0) {
                    sbuf.append(' ');
                }
                if (i >= 10) {
                    sbuf.append("...");
                }
                else {
                    if (rest instanceof Pair) {
                        final Pair pair = (Pair)rest;
                        sbuf.append(pair.getCar());
                        rest = pair.getCdr();
                        ++i;
                        continue;
                    }
                    sbuf.append(". ");
                    sbuf.append(checkNonList(rest));
                }
                sbuf.append(')');
                return sbuf.toString();
            }
            continue;
        }
    }
    
    public static Object checkNonList(final Object rest) {
        return (rest instanceof LList) ? "#<not a pair>" : rest;
    }
    
    static {
        Empty = EmptyList.emptyList;
    }
}
