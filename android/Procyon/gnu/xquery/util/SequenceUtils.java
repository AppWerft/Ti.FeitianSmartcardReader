// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.kawa.xml.KAttr;
import gnu.kawa.xml.KNode;
import gnu.lists.ItemPredicate;
import gnu.xml.NodeTree;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.WrongType;
import gnu.mapping.Values;
import gnu.kawa.xml.NodeType;

public class SequenceUtils
{
    public static final NodeType textOrElement;
    
    public static boolean isZeroOrOne(final Object arg) {
        return !(arg instanceof Values) || ((Values)arg).isEmpty();
    }
    
    static Object coerceToZeroOrOne(final Object arg, final String functionName, final int iarg) {
        if (isZeroOrOne(arg)) {
            return arg;
        }
        throw new WrongType(functionName, iarg, arg, "xs:item()?");
    }
    
    public static Object zeroOrOne(final Object arg) {
        return coerceToZeroOrOne(arg, "zero-or-one", 1);
    }
    
    public static Object oneOrMore(final Object arg) {
        if (arg instanceof Values && ((Values)arg).isEmpty()) {
            throw new IllegalArgumentException();
        }
        return arg;
    }
    
    public static Object exactlyOne(final Object arg) {
        if (arg instanceof Values) {
            throw new IllegalArgumentException();
        }
        return arg;
    }
    
    public static boolean isEmptySequence(final Object arg) {
        return arg instanceof Values && ((Values)arg).isEmpty();
    }
    
    public static boolean exists(final Object arg) {
        return !(arg instanceof Values) || !((Values)arg).isEmpty();
    }
    
    public static void insertBefore$X(final Object target, long position, final Object inserts, final CallContext ctx) {
        final Consumer out = ctx.consumer;
        boolean written = false;
        if (position <= 0L) {
            position = 1L;
        }
        if (target instanceof Values) {
            final Values values = (Values)target;
            int ipos = 0;
            long i = 0L;
            while (true) {
                final int next = values.nextPos(ipos);
                if ((next == 0 && !written) || ++i == position) {
                    Values.writeValues(inserts, out);
                    written = true;
                }
                if (next == 0) {
                    break;
                }
                values.consumePosRange(ipos, next, out);
                ipos = next;
            }
        }
        else {
            if (position <= 1L) {
                Values.writeValues(inserts, out);
            }
            out.writeObject(target);
            if (position > 1L) {
                Values.writeValues(inserts, out);
            }
        }
    }
    
    public static void remove$X(final Object arg, final long position, final CallContext ctx) {
        final Consumer out = ctx.consumer;
        if (arg instanceof Values) {
            final Values values = (Values)arg;
            int ipos = 0;
            long i = 0L;
            while (true) {
                final int next = values.nextPos(ipos);
                if (next == 0) {
                    break;
                }
                if (++i != position) {
                    values.consumePosRange(ipos, next, out);
                }
                ipos = next;
            }
        }
        else if (position != 1L) {
            out.writeObject(arg);
        }
    }
    
    public static void reverse$X(final Object arg, final CallContext ctx) {
        final Consumer out = ctx.consumer;
        if (!(arg instanceof Values)) {
            out.writeObject(arg);
            return;
        }
        final Values vals = (Values)arg;
        int ipos = 0;
        int[] poses = new int[100];
        int n = 0;
        do {
            if (n >= poses.length) {
                final int[] t = new int[2 * n];
                System.arraycopy(poses, 0, t, 0, n);
                poses = t;
            }
            poses[n++] = ipos;
            ipos = vals.nextPos(ipos);
        } while (ipos != 0);
        int i = n - 1;
        while (--i >= 0) {
            vals.consumePosRange(poses[i], poses[i + 1], out);
        }
    }
    
    public static void indexOf$X(final Object seqParam, final Object srchParam, final NamedCollator collator, final CallContext ctx) {
        final Consumer out = ctx.consumer;
        if (seqParam instanceof Values) {
            final Values vals = (Values)seqParam;
            int ipos = vals.startPos();
            int i = 1;
            while ((ipos = vals.nextPos(ipos)) != 0) {
                if (Compare.apply(72, vals.getPosPrevious(ipos), srchParam, collator)) {
                    out.writeInt(i);
                }
                ++i;
            }
        }
        else if (Compare.apply(72, seqParam, srchParam, collator)) {
            out.writeInt(1);
        }
    }
    
    public static boolean deepEqualChildren(final NodeTree seq1, final int ipos1, final NodeTree seq2, final int ipos2, final NamedCollator collator) {
        NodeType filter;
        int child1;
        int child2;
        for (filter = SequenceUtils.textOrElement, child1 = seq1.firstChildPos(ipos1, filter), child2 = seq2.firstChildPos(ipos2, filter); child1 != 0 && child2 != 0; child1 = seq1.nextMatching(child1, filter, -1, false), child2 = seq2.nextMatching(child2, filter, -1, false)) {
            if (!deepEqual(seq1, child1, seq2, child2, collator)) {
                return false;
            }
        }
        return child1 == child2;
    }
    
    public static boolean deepEqual(final NodeTree seq1, final int ipos1, final NodeTree seq2, final int ipos2, final NamedCollator collator) {
        final int kind1 = seq1.getNextKind(ipos1);
        final int kind2 = seq2.getNextKind(ipos2);
        switch (kind1) {
            case 33: {
                if (kind1 != kind2) {
                    return false;
                }
                final String loc1 = seq1.posLocalName(ipos1);
                final String loc2 = seq2.posLocalName(ipos2);
                if (loc1 != loc2) {
                    return false;
                }
                final String ns1 = seq1.posNamespaceURI(ipos1);
                final String ns2 = seq2.posNamespaceURI(ipos2);
                if (ns1 != ns2) {
                    return false;
                }
                int attr1 = seq1.firstAttributePos(ipos1);
                int nattr1 = 0;
                while (attr1 != 0 && seq1.getNextKind(attr1) == 35) {
                    ++nattr1;
                    final String local = seq1.posLocalName(attr1);
                    final String ns3 = seq1.posNamespaceURI(attr1);
                    final int attr2 = seq2.getAttributeI(ipos2, ns3, local);
                    if (attr2 == 0) {
                        return false;
                    }
                    final String aval1 = KNode.getNodeValue(seq1, attr1);
                    final String aval2 = KNode.getNodeValue(seq2, attr2);
                    if (!deepEqualItems(aval1, aval2, collator)) {
                        return false;
                    }
                    attr1 = seq1.nextPos(attr1);
                }
                final int nattr2 = seq2.getAttributeCount(ipos2);
                if (nattr1 != nattr2) {
                    return false;
                }
                return deepEqualChildren(seq1, ipos1, seq2, ipos2, collator);
            }
            case 34: {
                return deepEqualChildren(seq1, ipos1, seq2, ipos2, collator);
            }
            case 35: {
                return seq1.posLocalName(ipos1) == seq2.posLocalName(ipos2) && seq1.posNamespaceURI(ipos1) == seq2.posNamespaceURI(ipos2) && deepEqualItems(KAttr.getObjectValue(seq1, ipos1), KAttr.getObjectValue(seq2, ipos2), collator);
            }
            case 37: {
                return seq1.posTarget(ipos1).equals(seq2.posTarget(ipos2)) && KNode.getNodeValue(seq1, ipos1).equals(KNode.getNodeValue(seq2, ipos2));
            }
            default: {
                return kind1 == kind2 && KNode.getNodeValue(seq1, ipos1).equals(KNode.getNodeValue(seq2, ipos2));
            }
        }
    }
    
    public static boolean deepEqualItems(final Object arg1, final Object arg2, final NamedCollator collator) {
        return (NumberValue.isNaN(arg1) && NumberValue.isNaN(arg2)) || Compare.atomicCompare(8, arg1, arg2, collator);
    }
    
    public static boolean deepEqual(final Object arg1, final Object arg2, final NamedCollator collator) {
        if (arg1 == arg2) {
            return true;
        }
        if (arg1 == null || arg1 == Values.empty) {
            return arg2 == null || arg2 == Values.empty;
        }
        if (arg2 == null || arg2 == Values.empty) {
            return false;
        }
        int ipos1 = 1;
        int ipos2 = 1;
        final boolean is1seq = arg1 instanceof Values;
        final boolean is2seq = arg2 instanceof Values;
        final Values vals1 = is1seq ? ((Values)arg1) : null;
        final Values vals2 = is2seq ? ((Values)arg2) : null;
        boolean first = true;
        while (true) {
            if (is1seq) {
                if (first) {
                    ipos1 = vals1.startPos();
                }
                ipos1 = vals1.nextPos(ipos1);
            }
            if (is2seq) {
                if (first) {
                    ipos2 = vals2.startPos();
                }
                ipos2 = vals2.nextPos(ipos2);
            }
            if (ipos1 == 0 || ipos2 == 0) {
                return ipos1 == ipos2;
            }
            final Object item1 = is1seq ? vals1.getPosPrevious(ipos1) : arg1;
            final Object item2 = is2seq ? vals2.getPosPrevious(ipos2) : arg2;
            Label_0307: {
                if (!(item1 instanceof KNode) && !(item2 instanceof KNode)) {
                    try {
                        if (!deepEqualItems(arg1, arg2, collator)) {
                            return false;
                        }
                        break Label_0307;
                    }
                    catch (Exception ex) {
                        return false;
                    }
                }
                if (!(item1 instanceof KNode) || !(item2 instanceof KNode)) {
                    return false;
                }
                final KNode node1 = (KNode)item1;
                final KNode node2 = (KNode)item2;
                if (!deepEqual((NodeTree)node1.sequence, node1.ipos, (NodeTree)node2.sequence, node2.ipos, collator)) {
                    return false;
                }
            }
            if (!first) {
                continue;
            }
            first = false;
            if (!is1seq) {
                ipos1 = 0;
            }
            if (is2seq) {
                continue;
            }
            ipos2 = 0;
        }
    }
    
    public static void subList$X(final Object seq, final double start, final double end, final CallContext ctx) {
        subList$C(seq, start, end, ctx.consumer);
    }
    
    public static void subList$C(final Object seq, final double start, final double end, final Consumer out) {
        if (seq instanceof Values) {
            int istart = (int)(start - 1.0);
            int iend = (int)(end - 1.0);
            final Values vals = (Values)seq;
            final int sz = vals.size();
            if (istart < 0) {
                istart = 0;
            }
            if (iend > sz) {
                iend = sz;
            }
            if (iend > istart) {
                vals.consume(istart, iend, out);
            }
        }
        else if (start <= 1.0 && end >= 2.0) {
            out.writeObject(seq);
        }
    }
    
    static {
        textOrElement = new NodeType("element-or-text", 3);
    }
}
