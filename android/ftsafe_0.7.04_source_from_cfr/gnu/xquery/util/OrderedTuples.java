/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.functions.NumberCompare;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.lists.Consumer;
import gnu.lists.FilterConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.xquery.util.NamedCollator;
import gnu.xquery.util.SequenceUtils;

public class OrderedTuples
extends FilterConsumer {
    int n;
    Object[] tuples = new Object[10];
    Object[] comps;
    int first;
    int[] next;
    Procedure body;

    @Override
    public boolean ignoring() {
        return false;
    }

    @Override
    public void writeObject(Object v) {
        if (this.n >= this.tuples.length) {
            Object[] tmp = new Object[2 * this.n];
            System.arraycopy(this.tuples, 0, tmp, 0, this.n);
            this.tuples = tmp;
        }
        this.tuples[this.n++] = v;
    }

    OrderedTuples() {
        super(null);
    }

    public static OrderedTuples make$V(Procedure body, Object[] comps) {
        OrderedTuples tuples = new OrderedTuples();
        tuples.comps = comps;
        tuples.body = body;
        return tuples;
    }

    public void run$X(CallContext ctx) throws Throwable {
        this.first = this.listsort(0);
        this.emit(ctx);
    }

    void emit(CallContext ctx) throws Throwable {
        int p = this.first;
        while (p >= 0) {
            this.emit(p, ctx);
            p = this.next[p];
        }
    }

    void emit(int index, CallContext ctx) throws Throwable {
        Object[] args = (Object[])this.tuples[index];
        this.body.checkN(args, ctx);
        ctx.runUntilDone();
    }

    int cmp(int a, int b) throws Throwable {
        for (int i = 0; i < this.comps.length; i += 3) {
            int c;
            Procedure comparator = (Procedure)this.comps[i];
            String flags = (String)this.comps[i + 1];
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
            boolean empty1 = SequenceUtils.isEmptySequence(val1);
            boolean empty2 = SequenceUtils.isEmptySequence(val2);
            if (empty1 && empty2) continue;
            if (empty1 || empty2) {
                char emptyOrder = flags.charAt(1);
                c = empty1 == (emptyOrder == 'L') ? -1 : 1;
            } else {
                char emptyOrder;
                boolean isNaN2;
                boolean isNaN1 = val1 instanceof Number && Double.isNaN(((Number)val1).doubleValue());
                boolean bl = isNaN2 = val2 instanceof Number && Double.isNaN(((Number)val2).doubleValue());
                if (isNaN1 && isNaN2) continue;
                c = isNaN1 || isNaN2 ? (isNaN1 == ((emptyOrder = flags.charAt(1)) == 'L') ? -1 : 1) : (val1 instanceof Number && val2 instanceof Number ? NumberCompare.compare(val1, val2, false) : collator.compare(val1.toString(), val2.toString()));
            }
            if (c == 0) continue;
            return flags.charAt(0) == 'A' ? c : -c;
        }
        return 0;
    }

    int listsort(int list) throws Throwable {
        if (this.n == 0) {
            return -1;
        }
        this.next = new int[this.n];
        int i = 1;
        do {
            if (i == this.n) break;
            this.next[i - 1] = i++;
        } while (true);
        this.next[i - 1] = -1;
        int insize = 1;
        do {
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
                    if ((q = this.next[q]) < 0) break;
                }
                int qsize = insize;
                while (psize > 0 || qsize > 0 && q >= 0) {
                    int e;
                    if (psize == 0) {
                        e = q;
                        q = this.next[q];
                        --qsize;
                    } else if (qsize == 0 || q < 0) {
                        e = p;
                        p = this.next[p];
                        --psize;
                    } else if (this.cmp(p, q) <= 0) {
                        e = p;
                        p = this.next[p];
                        --psize;
                    } else {
                        e = q;
                        q = this.next[q];
                        --qsize;
                    }
                    if (tail >= 0) {
                        this.next[tail] = e;
                    } else {
                        list = e;
                    }
                    tail = e;
                }
                p = q;
            }
            this.next[tail] = -1;
            if (nmerges <= 1) {
                return list;
            }
            insize *= 2;
        } while (true);
    }
}

