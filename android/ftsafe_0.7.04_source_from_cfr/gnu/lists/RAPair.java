/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.EmptyList;
import gnu.lists.ImmutablePair;
import gnu.lists.LList;

public class RAPair
extends ImmutablePair {
    public int size;

    public Object getTree() {
        return this.car;
    }

    public Object getRest() {
        return this.cdr;
    }

    public RAPair(int size, Object tree, Object rest) {
        super(tree, rest);
        this.size = size;
    }

    private static int half(int n) {
        return n >> 1;
    }

    private static Object treeVal(Object t) {
        return t instanceof Node ? ((Node)t).val : t;
    }

    @Override
    public Object getCar() {
        if (this.car instanceof Node) {
            return RAPair.treeVal(this.car);
        }
        return this.car;
    }

    @Override
    public Object getCdr() {
        if (this.car instanceof Node) {
            Node tnode = (Node)this.car;
            int sz = RAPair.half(this.size);
            return new RAPair(sz, tnode.left, new RAPair(sz, tnode.right, this.cdr));
        }
        return this.cdr;
    }

    public static Object treeRef(int size, Object t, int i) {
        if (i == 0) {
            return RAPair.treeVal(t);
        }
        return RAPair.treeRefA(t, i, RAPair.half(size - 1));
    }

    public static Object treeRefA(Object t, int i, int mid) {
        while (i != 0) {
            if (i <= mid) {
                t = ((Node)t).left;
                --i;
            } else {
                t = ((Node)t).right;
                i = i - mid - 1;
            }
            mid = RAPair.half(mid - 1);
        }
        return RAPair.treeVal(t);
    }

    public static Object listRef(RAPair ls, int i) {
        RAPair xs = ls;
        int j = i;
        int xsize;
        while (j >= (xsize = xs.size)) {
            j -= xsize;
            xs = (RAPair)xs.cdr;
        }
        return RAPair.treeRef(xsize, xs.car, j);
    }

    @Override
    public Object get(int i) {
        return RAPair.listRef(this, i);
    }

    public static RAPair cons(Object x, Object ls) {
        if (ls instanceof RAPair) {
            RAPair lspair = (RAPair)ls;
            int s = lspair.size;
            if (lspair.cdr instanceof RAPair) {
                RAPair lsrest = (RAPair)lspair.cdr;
                if (lsrest.size == s) {
                    return new RAPair(s + s + 1, new Node(x, lspair.car, lsrest.car), lsrest.cdr);
                }
            }
        }
        return new RAPair(1, x, ls);
    }

    public static LList raList(Object[] xs) {
        LList result = LList.Empty;
        int i = xs.length;
        while (--i >= 0) {
            result = RAPair.cons(xs[i], result);
        }
        return result;
    }

    public static int raLength(Object ls) {
        int sz = 0;
        while (ls instanceof RAPair) {
            RAPair p = (RAPair)ls;
            sz += p.size;
            ls = p.cdr;
        }
        return sz;
    }

    @Override
    public int size() {
        return RAPair.raLength(this);
    }

    public static class Node {
        public Object val;
        public Object left;
        public Object right;

        public Node(Object val, Object left, Object right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

