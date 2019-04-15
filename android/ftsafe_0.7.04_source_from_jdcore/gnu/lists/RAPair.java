package gnu.lists;




public class RAPair
  extends ImmutablePair
{
  public int size;
  


  public Object getTree() { return car; }
  public Object getRest() { return cdr; }
  
  public RAPair(int size, Object tree, Object rest) {
    super(tree, rest);
    this.size = size;
  }
  
  private static int half(int n) { return n >> 1; }
  
  private static Object treeVal(Object t) {
    return (t instanceof Node) ? val : t;
  }
  
  public Object getCar() {
    if ((car instanceof Node)) {
      return treeVal(car);
    }
    return car;
  }
  
  public Object getCdr() {
    if ((car instanceof Node)) {
      Node tnode = (Node)car;
      int sz = half(size);
      return new RAPair(sz, left, new RAPair(sz, right, cdr));
    }
    


    return cdr;
  }
  
  public static Object treeRef(int size, Object t, int i) {
    if (i == 0) {
      return treeVal(t);
    }
    return treeRefA(t, i, half(size - 1));
  }
  


  public static Object treeRefA(Object t, int i, int mid)
  {
    for (;;)
    {
      if (i == 0)
        return treeVal(t);
      if (i <= mid) {
        t = left;
        i--;
      } else {
        t = right;
        i = i - mid - 1;
      }
      mid = half(mid - 1);
    }
  }
  
  public static Object listRef(RAPair ls, int i) {
    RAPair xs = ls;
    int j = i;
    for (;;) {
      int xsize = size;
      if (j < xsize)
        return treeRef(xsize, car, j);
      j -= xsize;
      xs = (RAPair)cdr;
    }
  }
  
  public Object get(int i) {
    return listRef(this, i);
  }
  
  public static RAPair cons(Object x, Object ls) {
    if ((ls instanceof RAPair)) {
      RAPair lspair = (RAPair)ls;
      int s = size;
      if ((cdr instanceof RAPair)) {
        RAPair lsrest = (RAPair)cdr;
        if (size == s) {
          return new RAPair(s + s + 1, new Node(x, car, car), cdr);
        }
      }
    }
    

    return new RAPair(1, x, ls);
  }
  
  public static LList raList(Object[] xs) {
    LList result = LList.Empty;
    int i = xs.length; for (;;) { i--; if (i < 0) break;
      result = cons(xs[i], result); }
    return result;
  }
  
  public static int raLength(Object ls) {
    int sz = 0;
    while ((ls instanceof RAPair)) {
      RAPair p = (RAPair)ls;
      sz += size;
      ls = cdr;
    }
    return sz;
  }
  
  public int size() {
    return raLength(this);
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
