/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.kawa.util.HashUtils;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.ExtSequence;
import gnu.lists.LListPosition;
import gnu.lists.Pair;
import gnu.lists.PositionManager;
import gnu.lists.SeqPosition;
import gnu.lists.Sequence;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Iterator;
import java.util.List;

public class LList
extends ExtSequence<Object>
implements Sequence<Object>,
Externalizable,
Comparable {
    public static final EmptyList Empty = EmptyList.emptyList;

    public static int listLength(Object obj, boolean allowOtherSequence) {
        int n = 0;
        Object slow = obj;
        Object fast = obj;
        while (fast != Empty) {
            if (!(fast instanceof Pair)) {
                if (fast instanceof Sequence && allowOtherSequence) {
                    int j = ((Sequence)fast).size();
                    return j >= 0 ? n + j : j;
                }
                return -2;
            }
            Pair fast_pair = (Pair)fast;
            Object fast_cdr = fast_pair.getCdr();
            if (fast_cdr == Empty) {
                return n + 1;
            }
            if (fast == slow && n > 0) {
                return -1;
            }
            if (!(fast_cdr instanceof Pair)) {
                ++n;
                fast = fast_cdr;
                continue;
            }
            if (!(slow instanceof Pair)) {
                return -2;
            }
            slow = ((Pair)slow).getCdr();
            fast = ((Pair)fast_cdr).getCdr();
            n += 2;
        }
        return n;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    public int compareTo(Object obj) {
        return obj == Empty ? 0 : -1;
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
    public SeqPosition getIterator(int index) {
        return new LListPosition(this, index, false);
    }

    @Override
    public int createPos(int index, boolean isAfter) {
        LListPosition pos = new LListPosition(this, index, isAfter);
        return PositionManager.manager.register(pos);
    }

    @Override
    public int createRelativePos(int pos, int delta, boolean isAfter) {
        boolean old_after = this.isAfterPos(pos);
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
        LListPosition old = (LListPosition)PositionManager.getPositionObject(pos);
        if (old.xpos == null) {
            return super.createRelativePos(pos, delta, isAfter);
        }
        LListPosition it = new LListPosition(old);
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
        do {
            if (!(it_xpos instanceof Pair)) {
                throw new IndexOutOfBoundsException();
            }
            if (--delta < 0) break;
            Pair p = (Pair)it_xpos;
            it_ipos += 2;
            it_xpos = p.getCdr();
        } while (true);
        it.ipos = it_ipos;
        it.xpos = it_xpos;
        return PositionManager.manager.register(it);
    }

    @Override
    public boolean hasNext(int ipos) {
        return false;
    }

    @Override
    public int nextPos(int ipos) {
        return 0;
    }

    @Override
    public Object getPosNext(int ipos) {
        return eofValue;
    }

    @Override
    public Object getPosPrevious(int ipos) {
        return eofValue;
    }

    @Override
    protected void setPosNext(int ipos, Object value) {
        if (ipos <= 0) {
            if (ipos == -1 || !(this instanceof Pair)) {
                throw new IndexOutOfBoundsException();
            }
            ((Pair)this).car = value;
        } else {
            PositionManager.getPositionObject(ipos).setNext(value);
        }
    }

    @Override
    protected void setPosPrevious(int ipos, Object value) {
        if (ipos <= 0) {
            if (ipos == 0 || !(this instanceof Pair)) {
                throw new IndexOutOfBoundsException();
            }
            ((Pair)this).lastPair().car = value;
        } else {
            PositionManager.getPositionObject(ipos).setPrevious(value);
        }
    }

    @Override
    public Object get(int index) {
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
        int sublimit = limit >> 1;
        int count = 0;
        while (list instanceof Pair && ++count <= limit) {
            Pair pair = (Pair)list;
            int h = HashUtils.boundedHash(pair.getCar(), 0, sublimit);
            seed = HashUtils.murmur3step(seed, h);
            list = pair.getCdr();
        }
        if (--limit >= 0 && list != Empty && list != null) {
            int h = HashUtils.boundedHash(list, 0, sublimit);
            seed = HashUtils.murmur3step(seed, h);
            ++count;
        }
        return HashUtils.murmur3finish(seed, count);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        Object list = this;
        while (list instanceof Pair) {
            Pair pair = (Pair)list;
            Object obj = pair.getCar();
            hash = 31 * hash + (obj == null ? 0 : obj.hashCode());
            list = pair.getCdr();
        }
        if (list != Empty && list != null) {
            hash ^= list.hashCode();
        }
        return hash;
    }

    public static LList makeList(List vals) {
        Iterator e = vals.iterator();
        LList result = Empty;
        Pair last = null;
        while (e.hasNext()) {
            Pair pair = new Pair(e.next(), Empty);
            if (last == null) {
                result = pair;
            } else {
                last.cdr = pair;
            }
            last = pair;
        }
        return result;
    }

    public static LList makeList(Object[] vals, int offset, int length) {
        LList result = Empty;
        int i = length;
        while (--i >= 0) {
            result = new Pair(vals[offset + i], result);
        }
        return result;
    }

    public static LList makeList(Object[] vals, int offset) {
        LList result = Empty;
        int i = vals.length - offset;
        while (--i >= 0) {
            result = new Pair(vals[offset + i], result);
        }
        return result;
    }

    @Override
    public void consume(Consumer out) {
        Object list = this;
        out.startElement("list");
        while (list instanceof Pair) {
            if (list != this) {
                out.write(32);
            }
            Pair pair = (Pair)list;
            out.writeObject(pair.getCar());
            list = pair.getCdr();
        }
        if (list != Empty) {
            out.write(32);
            out.write(". ");
            out.writeObject(LList.checkNonList(list));
        }
        out.endElement();
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
    }

    public Object readResolve() throws ObjectStreamException {
        return Empty;
    }

    public static Pair list1(Object arg1) {
        return new Pair(arg1, Empty);
    }

    public static Pair list2(Object arg1, Object arg2) {
        return new Pair(arg1, new Pair(arg2, Empty));
    }

    public static Pair list3(Object arg1, Object arg2, Object arg3) {
        return new Pair(arg1, new Pair(arg2, new Pair(arg3, Empty)));
    }

    public static Pair list4(Object arg1, Object arg2, Object arg3, Object arg4) {
        return new Pair(arg1, new Pair(arg2, new Pair(arg3, new Pair(arg4, Empty))));
    }

    public static Pair chain1(Pair old, Object arg1) {
        Pair p1 = new Pair(arg1, Empty);
        old.cdr = p1;
        return p1;
    }

    public static Pair chain4(Pair old, Object arg1, Object arg2, Object arg3, Object arg4) {
        Pair p4 = new Pair(arg4, Empty);
        old.cdr = new Pair(arg1, new Pair(arg2, new Pair(arg3, p4)));
        return p4;
    }

    public static LList reverseInPlace(Object list) {
        LList prev = Empty;
        while (list != Empty) {
            Pair pair = (Pair)list;
            list = pair.cdr;
            pair.cdr = prev;
            prev = pair;
        }
        return prev;
    }

    public static Object consX(Object[] args) {
        Pair result;
        Object first = args[0];
        int n = args.length - 1;
        if (n <= 0) {
            return first;
        }
        Pair prev = result = new Pair(first, null);
        for (int i = 1; i < n; ++i) {
            Pair next = new Pair(args[i], null);
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
        StringBuffer sbuf = new StringBuffer(100);
        sbuf.append('(');
        while (rest != Empty) {
            if (i > 0) {
                sbuf.append(' ');
            }
            if (i >= 10) {
                sbuf.append("...");
                break;
            }
            if (!(rest instanceof Pair)) {
                sbuf.append(". ");
                sbuf.append(LList.checkNonList(rest));
                break;
            }
            Pair pair = (Pair)rest;
            sbuf.append(pair.getCar());
            rest = pair.getCdr();
            ++i;
        }
        sbuf.append(')');
        return sbuf.toString();
    }

    public static Object checkNonList(Object rest) {
        return rest instanceof LList ? "#<not a pair>" : rest;
    }
}

