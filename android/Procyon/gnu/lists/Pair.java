// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class Pair extends LList implements Externalizable
{
    protected Object car;
    protected Object cdr;
    public static final Pair incompleteListMarker;
    
    public Pair(final Object carval, final Object cdrval) {
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
    
    public void setCar(final Object car) {
        this.car = car;
    }
    
    public void setCdr(final Object cdr) {
        this.cdr = cdr;
    }
    
    public void setCarBackdoor(final Object car) {
        this.car = car;
    }
    
    public void setCdrBackdoor(final Object cdr) {
        this.cdr = cdr;
    }
    
    @Override
    public int size() {
        final int n = LList.listLength(this, true);
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
        while (fast != Pair.Empty) {
            if (!(fast instanceof Pair)) {
                if (fast instanceof Sequence) {
                    final int j = ((Sequence)fast).size();
                    return (j >= 0) ? (n + j) : j;
                }
                return -2;
            }
            else {
                final Pair fast_pair = (Pair)fast;
                final Object fast_pair_cdr = fast_pair.getCdr();
                if (fast_pair_cdr == Pair.Empty) {
                    return n + 1;
                }
                if (fast == slow && n > 0) {
                    return -1;
                }
                if (!(fast_pair_cdr instanceof Pair)) {
                    ++n;
                    fast = fast_pair_cdr;
                }
                else {
                    if (!(slow instanceof Pair)) {
                        return -2;
                    }
                    slow = ((Pair)slow).getCdr();
                    fast = ((Pair)fast_pair_cdr).getCdr();
                    n += 2;
                }
            }
        }
        return n;
    }
    
    @Override
    public boolean hasNext(final int ipos) {
        if (ipos <= 0) {
            return ipos == 0;
        }
        return PositionManager.getPositionObject(ipos).hasNext();
    }
    
    @Override
    public int nextPos(final int ipos) {
        if (ipos > 0) {
            final LListPosition it = (LListPosition)PositionManager.getPositionObject(ipos);
            return it.gotoNext() ? ipos : 0;
        }
        if (ipos < 0) {
            return 0;
        }
        return PositionManager.manager.register(new LListPosition(this, 1, true));
    }
    
    @Override
    public Object getPosNext(final int ipos) {
        if (ipos <= 0) {
            return (ipos == 0) ? this.getCar() : Pair.eofValue;
        }
        return PositionManager.getPositionObject(ipos).getNext();
    }
    
    @Override
    public Object getPosPrevious(final int ipos) {
        if (ipos <= 0) {
            return (ipos == 0) ? Pair.eofValue : this.lastPair().getCar();
        }
        return PositionManager.getPositionObject(ipos).getPrevious();
    }
    
    public Pair lastPair() {
        Pair pair = this;
        while (true) {
            final Object next = pair.getCdr();
            if (!(next instanceof Pair)) {
                break;
            }
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
        while (true) {
            Object x1 = pair1.getCar();
            Object x2 = pair2.getCar();
            if (x1 != x2 && (x1 == null || !x1.equals(x2))) {
                return false;
            }
            x1 = pair1.getCdr();
            x2 = pair2.getCdr();
            if (x1 == x2) {
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
        while (true) {
            Object x1 = pair1.getCar();
            Object x2 = pair2.getCar();
            final int d = ((Comparable)x1).compareTo(x2);
            if (d != 0) {
                return d;
            }
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
                return ((Comparable)x1).compareTo(x2);
            }
            pair1 = (Pair)x1;
            pair2 = (Pair)x2;
        }
    }
    
    @Override
    public int compareTo(final Object obj) {
        if (obj == Pair.Empty) {
            return 1;
        }
        return compareTo(this, (Pair)obj);
    }
    
    @Override
    public Object get(final int index) {
        Pair pair = this;
        int i = index;
        while (i > 0) {
            --i;
            final Object pair_cdr = pair.getCdr();
            if (pair_cdr instanceof Pair) {
                pair = (Pair)pair_cdr;
            }
            else {
                if (pair_cdr instanceof Sequence) {
                    return ((Sequence)pair_cdr).get(i);
                }
                break;
            }
        }
        if (i == 0) {
            return pair.getCar();
        }
        throw new IndexOutOfBoundsException();
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj != null && obj instanceof Pair && equals(this, (Pair)obj);
    }
    
    public static Pair make(final Object car, final Object cdr) {
        return new Pair(car, cdr);
    }
    
    @Override
    public Object[] toArray() {
        final int len = this.size();
        final Object[] arr = new Object[len];
        int i;
        Sequence rest;
        Pair pair;
        for (i = 0, rest = this; i < len && rest instanceof Pair; rest = (Sequence)pair.getCdr(), ++i) {
            pair = (Pair)rest;
            arr[i] = pair.getCar();
        }
        final int prefix = i;
        while (i < len) {
            arr[i] = rest.get(i - prefix);
            ++i;
        }
        return arr;
    }
    
    @Override
    public Object[] toArray(Object[] arr) {
        int alen = arr.length;
        final int len = this.length();
        if (len > alen) {
            arr = new Object[len];
            alen = len;
        }
        int i;
        Sequence rest;
        Pair pair;
        for (i = 0, rest = this; i < len && rest instanceof Pair; rest = (Sequence)pair.getCdr(), ++i) {
            pair = (Pair)rest;
            arr[i] = pair.getCar();
        }
        final int prefix = i;
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
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.car);
        out.writeObject(this.cdr);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.car = in.readObject();
        this.cdr = in.readObject();
    }
    
    @Override
    public Object readResolve() throws ObjectStreamException {
        return this;
    }
    
    static {
        incompleteListMarker = new ImmutablePair("<incomplete>", LList.Empty);
    }
}
