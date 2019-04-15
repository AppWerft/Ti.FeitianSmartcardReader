/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.EmptyList;
import gnu.lists.ImmutablePair;
import gnu.lists.LList;
import gnu.lists.LListPosition;
import gnu.lists.PositionManager;
import gnu.lists.SeqPosition;
import gnu.lists.Sequence;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class Pair
extends LList
implements Externalizable {
    protected Object car;
    protected Object cdr;
    public static final Pair incompleteListMarker = new ImmutablePair("<incomplete>", LList.Empty);

    public Pair(Object carval, Object cdrval) {
        this.car = carval;
        this.cdr = cdrval;
    }

    public Pair() {
    }

    public Object getCar() {
        return this.car;
    }

    public Object getCdr() {
        return this.cdr;
    }

    public void setCar(Object car) {
        this.car = car;
    }

    public void setCdr(Object cdr) {
        this.cdr = cdr;
    }

    public void setCarBackdoor(Object car) {
        this.car = car;
    }

    public void setCdrBackdoor(Object cdr) {
        this.cdr = cdr;
    }

    @Override
    public int size() {
        int n = Pair.listLength(this, true);
        if (n >= 0) {
            return n;
        }
        if (n == -1) {
            return Integer.MAX_VALUE;
        }
        throw new RuntimeException("not a true list");
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public int length() {
        int n = 0;
        Object slow = this;
        Object fast = this;
        while (fast != Empty) {
            if (!(fast instanceof Pair)) {
                if (fast instanceof Sequence) {
                    int j = ((Sequence)fast).size();
                    return j >= 0 ? n + j : j;
                }
                return -2;
            }
            Object fast_pair = fast;
            Object fast_pair_cdr = ((Pair)fast_pair).getCdr();
            if (fast_pair_cdr == Empty) {
                return n + 1;
            }
            if (fast == slow && n > 0) {
                return -1;
            }
            if (!(fast_pair_cdr instanceof Pair)) {
                ++n;
                fast = fast_pair_cdr;
                continue;
            }
            if (!(slow instanceof Pair)) {
                return -2;
            }
            slow = ((Pair)slow).getCdr();
            fast = ((Pair)fast_pair_cdr).getCdr();
            n += 2;
        }
        return n;
    }

    @Override
    public boolean hasNext(int ipos) {
        if (ipos <= 0) {
            return ipos == 0;
        }
        return PositionManager.getPositionObject(ipos).hasNext();
    }

    @Override
    public int nextPos(int ipos) {
        if (ipos <= 0) {
            if (ipos < 0) {
                return 0;
            }
            return PositionManager.manager.register(new LListPosition(this, 1, true));
        }
        LListPosition it = (LListPosition)PositionManager.getPositionObject(ipos);
        return it.gotoNext() ? ipos : 0;
    }

    @Override
    public Object getPosNext(int ipos) {
        if (ipos <= 0) {
            return ipos == 0 ? this.getCar() : eofValue;
        }
        return PositionManager.getPositionObject(ipos).getNext();
    }

    @Override
    public Object getPosPrevious(int ipos) {
        if (ipos <= 0) {
            return ipos == 0 ? eofValue : this.lastPair().getCar();
        }
        return PositionManager.getPositionObject(ipos).getPrevious();
    }

    public Pair lastPair() {
        Object next;
        Pair pair = this;
        while ((next = pair.getCdr()) instanceof Pair) {
            pair = (Pair)next;
        }
        return pair;
    }

    public static boolean equals(Pair pair1, Pair pair2) {
        if (pair1 == pair2) {
            return true;
        }
        if (pair1 == null || pair2 == null) {
            return false;
        }
        Object x2;
        Object x1;
        while ((x1 = pair1.getCar()) == (x2 = pair2.getCar()) || x1 != null && x1.equals(x2)) {
            x1 = pair1.getCdr();
            if (x1 == (x2 = pair2.getCdr())) {
                return true;
            }
            if (x1 == null || x2 == null) {
                return false;
            }
            if (!(x1 instanceof Pair) || !(x2 instanceof Pair)) {
                return x1.equals(x2);
            }
            pair1 = (Pair)x1;
            pair2 = (Pair)x2;
        }
        return false;
    }

    public static int compareTo(Pair pair1, Pair pair2) {
        if (pair1 == pair2) {
            return 0;
        }
        if (pair1 == null) {
            return -1;
        }
        if (pair2 == null) {
            return 1;
        }
        Object x2;
        Object x1;
        int d;
        while ((d = ((Comparable)(x1 = pair1.getCar())).compareTo((Comparable)(x2 = pair2.getCar()))) == 0) {
            x1 = pair1.cdr;
            x2 = pair2.cdr;
            if (x1 == x2) {
                return 0;
            }
            if (x1 == null) {
                return -1;
            }
            if (x2 == null) {
                return 1;
            }
            if (!(x1 instanceof Pair) || !(x2 instanceof Pair)) {
                return ((Comparable)x1).compareTo((Comparable)x2);
            }
            pair1 = (Pair)x1;
            pair2 = (Pair)x2;
        }
        return d;
    }

    @Override
    public int compareTo(Object obj) {
        if (obj == Empty) {
            return 1;
        }
        return Pair.compareTo(this, (Pair)obj);
    }

    @Override
    public Object get(int index) {
        int i;
        Pair pair = this;
        for (i = index; i > 0; --i) {
            Object pair_cdr = pair.getCdr();
            if (pair_cdr instanceof Pair) {
                pair = (Pair)pair_cdr;
                continue;
            }
            if (!(pair_cdr instanceof Sequence)) break;
            return ((Sequence)pair_cdr).get(i);
        }
        if (i == 0) {
            return pair.getCar();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Pair) {
            return Pair.equals(this, (Pair)obj);
        }
        return false;
    }

    public static Pair make(Object car, Object cdr) {
        return new Pair(car, cdr);
    }

    @Override
    public Object[] toArray() {
        int i;
        int len = this.size();
        Object[] arr = new Object[len];
        Sequence<Object> rest = this;
        for (i = 0; i < len && rest instanceof Pair; ++i) {
            Pair pair = rest;
            arr[i] = pair.getCar();
            rest = (Sequence)pair.getCdr();
        }
        int prefix = i;
        while (i < len) {
            arr[i] = rest.get(i - prefix);
            ++i;
        }
        return arr;
    }

    @Override
    public Object[] toArray(Object[] arr) {
        int i;
        int alen = arr.length;
        int len = this.length();
        if (len > alen) {
            arr = new Object[len];
            alen = len;
        }
        Sequence<Object> rest = this;
        for (i = 0; i < len && rest instanceof Pair; ++i) {
            Pair pair = rest;
            arr[i] = pair.getCar();
            rest = (Sequence)pair.getCdr();
        }
        int prefix = i;
        while (i < len) {
            arr[i] = rest.get(i - prefix);
            ++i;
        }
        if (len < alen) {
            arr[len] = null;
        }
        return arr;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.car);
        out.writeObject(this.cdr);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.car = in.readObject();
        this.cdr = in.readObject();
    }

    @Override
    public Object readResolve() throws ObjectStreamException {
        return this;
    }
}

