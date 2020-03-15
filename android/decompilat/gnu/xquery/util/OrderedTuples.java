// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.kawa.functions.NumberCompare;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.KNode;
import gnu.mapping.CallContext;
import gnu.lists.Consumer;
import gnu.mapping.Procedure;
import gnu.lists.FilterConsumer;

public class OrderedTuples extends FilterConsumer
{
    int n;
    Object[] tuples;
    Object[] comps;
    int first;
    int[] next;
    Procedure body;
    
    @Override
    public boolean ignoring() {
        return false;
    }
    
    @Override
    public void writeObject(final Object v) {
        if (this.n >= this.tuples.length) {
            final Object[] tmp = new Object[2 * this.n];
            System.arraycopy(this.tuples, 0, tmp, 0, this.n);
            this.tuples = tmp;
        }
        this.tuples[this.n++] = v;
    }
    
    OrderedTuples() {
        super(null);
        this.tuples = new Object[10];
    }
    
    public static OrderedTuples make$V(final Procedure body, final Object[] comps) {
        final OrderedTuples tuples = new OrderedTuples();
        tuples.comps = comps;
        tuples.body = body;
        return tuples;
    }
    
    public void run$X(final CallContext ctx) throws Throwable {
        this.first = this.listsort(0);
        this.emit(ctx);
    }
    
    void emit(final CallContext ctx) throws Throwable {
        for (int p = this.first; p >= 0; p = this.next[p]) {
            this.emit(p, ctx);
        }
    }
    
    void emit(final int index, final CallContext ctx) throws Throwable {
        final Object[] args = (Object[])this.tuples[index];
        this.body.checkN(args, ctx);
        ctx.runUntilDone();
    }
    
    int cmp(final int a, final int b) throws Throwable {
        for (int i = 0; i < this.comps.length; i += 3) {
            final Procedure comparator = (Procedure)this.comps[i];
            final String flags = (String)this.comps[i + 1];
            NamedCollator collator = (NamedCollator)this.comps[i + 2];
            if (collator == null) {
                collator = NamedCollator.codepointCollation;
            }
            Object val1 = comparator.applyN((Object[])this.tuples[a]);
            Object val2 = comparator.applyN((Object[])this.tuples[b]);
            val1 = KNode.atomicValue(val1);
            val2 = KNode.atomicValue(val2);
            if (val1 instanceof UntypedAtomic) {
                val1 = val1.toString();
            }
            if (val2 instanceof UntypedAtomic) {
                val2 = val2.toString();
            }
            final boolean empty1 = SequenceUtils.isEmptySequence(val1);
            final boolean empty2 = SequenceUtils.isEmptySequence(val2);
            if (!empty1 || !empty2) {
                int c;
                if (empty1 || empty2) {
                    final char emptyOrder = flags.charAt(1);
                    c = ((empty1 == (emptyOrder == 'L')) ? -1 : 1);
                }
                else {
                    final boolean isNaN1 = val1 instanceof Number && Double.isNaN(((Number)val1).doubleValue());
                    final boolean isNaN2 = val2 instanceof Number && Double.isNaN(((Number)val2).doubleValue());
                    if (isNaN1 && isNaN2) {
                        continue;
                    }
                    if (isNaN1 || isNaN2) {
                        final char emptyOrder2 = flags.charAt(1);
                        c = ((isNaN1 == (emptyOrder2 == 'L')) ? -1 : 1);
                    }
                    else if (val1 instanceof Number && val2 instanceof Number) {
                        c = NumberCompare.compare(val1, val2, false);
                    }
                    else {
                        c = collator.compare(val1.toString(), val2.toString());
                    }
                }
                if (c != 0) {
                    return (flags.charAt(0) == 'A') ? c : (-c);
                }
            }
        }
        return 0;
    }
    
    int listsort(int list) throws Throwable {
        if (this.n == 0) {
            return -1;
        }
        this.next = new int[this.n];
        int i;
        for (i = 1; i != this.n; ++i) {
            this.next[i - 1] = i;
        }
        this.next[i - 1] = -1;
        int insize = 1;
        while (true) {
            int p = list;
            list = -1;
            int tail = -1;
            int nmerges = 0;
            while (p >= 0) {
                ++nmerges;
                int q = p;
                int psize = 0;
                for (i = 0; i < insize; ++i) {
                    ++psize;
                    q = this.next[q];
                    if (q < 0) {
                        break;
                    }
                }
                int qsize = insize;
                while (psize > 0 || (qsize > 0 && q >= 0)) {
                    int e;
                    if (psize == 0) {
                        e = q;
                        q = this.next[q];
                        --qsize;
                    }
                    else if (qsize == 0 || q < 0) {
                        e = p;
                        p = this.next[p];
                        --psize;
                    }
                    else if (this.cmp(p, q) <= 0) {
                        e = p;
                        p = this.next[p];
                        --psize;
                    }
                    else {
                        e = q;
                        q = this.next[q];
                        --qsize;
                    }
                    if (tail >= 0) {
                        this.next[tail] = e;
                    }
                    else {
                        list = e;
                    }
                    tail = e;
                }
                p = q;
            }
            this.next[tail] = -1;
            if (nmerges <= 1) {
                break;
            }
            insize *= 2;
        }
        return list;
    }
}
