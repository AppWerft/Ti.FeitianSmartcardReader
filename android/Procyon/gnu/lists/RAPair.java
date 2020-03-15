// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class RAPair extends ImmutablePair
{
    public int size;
    
    public Object getTree() {
        return this.car;
    }
    
    public Object getRest() {
        return this.cdr;
    }
    
    public RAPair(final int size, final Object tree, final Object rest) {
        super(tree, rest);
        this.size = size;
    }
    
    private static int half(final int n) {
        return n >> 1;
    }
    
    private static Object treeVal(final Object t) {
        return (t instanceof Node) ? ((Node)t).val : t;
    }
    
    @Override
    public Object getCar() {
        if (this.car instanceof Node) {
            return treeVal(this.car);
        }
        return this.car;
    }
    
    @Override
    public Object getCdr() {
        if (this.car instanceof Node) {
            final Node tnode = (Node)this.car;
            final int sz = half(this.size);
            return new RAPair(sz, tnode.left, new RAPair(sz, tnode.right, this.cdr));
        }
        return this.cdr;
    }
    
    public static Object treeRef(final int size, final Object t, final int i) {
        if (i == 0) {
            return treeVal(t);
        }
        return treeRefA(t, i, half(size - 1));
    }
    
    public static Object treeRefA(Object t, int i, int mid) {
        while (i != 0) {
            if (i <= mid) {
                t = ((Node)t).left;
                --i;
            }
            else {
                t = ((Node)t).right;
                i = i - mid - 1;
            }
            mid = half(mid - 1);
        }
        return treeVal(t);
    }
    
    public static Object listRef(final RAPair ls, final int i) {
        RAPair xs = ls;
        int j = i;
        int xsize;
        while (true) {
            xsize = xs.size;
            if (j < xsize) {
                break;
            }
            j -= xsize;
            xs = (RAPair)xs.cdr;
        }
        return treeRef(xsize, xs.car, j);
    }
    
    @Override
    public Object get(final int i) {
        return listRef(this, i);
    }
    
    public static RAPair cons(final Object x, final Object ls) {
        if (ls instanceof RAPair) {
            final RAPair lspair = (RAPair)ls;
            final int s = lspair.size;
            if (lspair.cdr instanceof RAPair) {
                final RAPair lsrest = (RAPair)lspair.cdr;
                if (lsrest.size == s) {
                    return new RAPair(s + s + 1, new Node(x, lspair.car, lsrest.car), lsrest.cdr);
                }
            }
        }
        return new RAPair(1, x, ls);
    }
    
    public static LList raList(final Object[] xs) {
        LList result = LList.Empty;
        int i = xs.length;
        while (--i >= 0) {
            result = cons(xs[i], result);
        }
        return result;
    }
    
    public static int raLength(Object ls) {
        int sz = 0;
        while (ls instanceof RAPair) {
            final RAPair p = (RAPair)ls;
            sz += p.size;
            ls = p.cdr;
        }
        return sz;
    }
    
    @Override
    public int size() {
        return raLength(this);
    }
    
    public static class Node
    {
        public Object val;
        public Object left;
        public Object right;
        
        public Node(final Object val, final Object left, final Object right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
