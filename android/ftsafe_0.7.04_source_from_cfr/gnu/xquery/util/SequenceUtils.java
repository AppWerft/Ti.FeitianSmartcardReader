/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.kawa.xml.KAttr;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.NodeType;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.ItemPredicate;
import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.xml.NodeTree;
import gnu.xquery.util.Compare;
import gnu.xquery.util.NamedCollator;
import gnu.xquery.util.NumberValue;

public class SequenceUtils {
    public static final NodeType textOrElement = new NodeType("element-or-text", 3);

    public static boolean isZeroOrOne(Object arg) {
        return !(arg instanceof Values) || ((Values)arg).isEmpty();
    }

    static Object coerceToZeroOrOne(Object arg, String functionName, int iarg) {
        if (SequenceUtils.isZeroOrOne(arg)) {
            return arg;
        }
        throw new WrongType(functionName, iarg, arg, "xs:item()?");
    }

    public static Object zeroOrOne(Object arg) {
        return SequenceUtils.coerceToZeroOrOne(arg, "zero-or-one", 1);
    }

    public static Object oneOrMore(Object arg) {
        if (arg instanceof Values && ((Values)arg).isEmpty()) {
            throw new IllegalArgumentException();
        }
        return arg;
    }

    public static Object exactlyOne(Object arg) {
        if (arg instanceof Values) {
            throw new IllegalArgumentException();
        }
        return arg;
    }

    public static boolean isEmptySequence(Object arg) {
        return arg instanceof Values && ((Values)arg).isEmpty();
    }

    public static boolean exists(Object arg) {
        return !(arg instanceof Values) || !((Values)arg).isEmpty();
    }

    public static void insertBefore$X(Object target, long position, Object inserts, CallContext ctx) {
        Consumer out = ctx.consumer;
        boolean written = false;
        if (position <= 0L) {
            position = 1L;
        }
        if (target instanceof Values) {
            Values values = (Values)target;
            int ipos = 0;
            long i = 0L;
            do {
                int next;
                if ((next = values.nextPos(ipos)) == 0 && !written || ++i == position) {
                    Values.writeValues(inserts, out);
                    written = true;
                }
                if (next != 0) {
                    values.consumePosRange(ipos, next, out);
                    ipos = next;
                    continue;
                }
                break;
            } while (true);
        } else {
            if (position <= 1L) {
                Values.writeValues(inserts, out);
            }
            out.writeObject(target);
            if (position > 1L) {
                Values.writeValues(inserts, out);
            }
        }
    }

    public static void remove$X(Object arg, long position, CallContext ctx) {
        Consumer out = ctx.consumer;
        if (arg instanceof Values) {
            int next;
            Values values = (Values)arg;
            int ipos = 0;
            long i = 0L;
            while ((next = values.nextPos(ipos)) != 0) {
                if (++i != position) {
                    values.consumePosRange(ipos, next, out);
                }
                ipos = next;
            }
        } else if (position != 1L) {
            out.writeObject(arg);
        }
    }

    public static void reverse$X(Object arg, CallContext ctx) {
        Consumer out = ctx.consumer;
        if (!(arg instanceof Values)) {
            out.writeObject(arg);
            return;
        }
        Values vals = (Values)arg;
        int ipos = 0;
        int[] poses = new int[100];
        int n = 0;
        do {
            if (n >= poses.length) {
                int[] t = new int[2 * n];
                System.arraycopy(poses, 0, t, 0, n);
                poses = t;
            }
            poses[n++] = ipos;
        } while ((ipos = vals.nextPos(ipos)) != 0);
        int i = n - 1;
        while (--i >= 0) {
            vals.consumePosRange(poses[i], poses[i + 1], out);
        }
    }

    public static void indexOf$X(Object seqParam, Object srchParam, NamedCollator collator, CallContext ctx) {
        Consumer out = ctx.consumer;
        if (seqParam instanceof Values) {
            Values vals = (Values)seqParam;
            int ipos = vals.startPos();
            int i = 1;
            while ((ipos = vals.nextPos(ipos)) != 0) {
                if (Compare.apply(72, vals.getPosPrevious(ipos), srchParam, collator)) {
                    out.writeInt(i);
                }
                ++i;
            }
        } else if (Compare.apply(72, seqParam, srchParam, collator)) {
            out.writeInt(1);
        }
    }

    public static boolean deepEqualChildren(NodeTree seq1, int ipos1, NodeTree seq2, int ipos2, NamedCollator collator) {
        NodeType filter = textOrElement;
        int child1 = seq1.firstChildPos(ipos1, filter);
        int child2 = seq2.firstChildPos(ipos2, filter);
        while (child1 != 0 && child2 != 0) {
            if (!SequenceUtils.deepEqual(seq1, child1, seq2, child2, collator)) {
                return false;
            }
            child1 = seq1.nextMatching(child1, filter, -1, false);
            child2 = seq2.nextMatching(child2, filter, -1, false);
        }
        return child1 == child2;
    }

    public static boolean deepEqual(NodeTree seq1, int ipos1, NodeTree seq2, int ipos2, NamedCollator collator) {
        int kind1 = seq1.getNextKind(ipos1);
        int kind2 = seq2.getNextKind(ipos2);
        switch (kind1) {
            case 33: {
                String loc2;
                String ns2;
                if (kind1 != kind2) {
                    return false;
                }
                String loc1 = seq1.posLocalName(ipos1);
                if (loc1 != (loc2 = seq2.posLocalName(ipos2))) {
                    return false;
                }
                String ns1 = seq1.posNamespaceURI(ipos1);
                if (ns1 != (ns2 = seq2.posNamespaceURI(ipos2))) {
                    return false;
                }
                int attr1 = seq1.firstAttributePos(ipos1);
                int nattr1 = 0;
                while (attr1 != 0 && seq1.getNextKind(attr1) == 35) {
                    String aval2;
                    ++nattr1;
                    String local = seq1.posLocalName(attr1);
                    String ns = seq1.posNamespaceURI(attr1);
                    int attr2 = seq2.getAttributeI(ipos2, ns, local);
                    if (attr2 == 0) {
                        return false;
                    }
                    String aval1 = KNode.getNodeValue(seq1, attr1);
                    if (!SequenceUtils.deepEqualItems(aval1, aval2 = KNode.getNodeValue(seq2, attr2), collator)) {
                        return false;
                    }
                    attr1 = seq1.nextPos(attr1);
                }
                int nattr2 = seq2.getAttributeCount(ipos2);
                if (nattr1 != nattr2) {
                    return false;
                }
            }
            case 34: {
                return SequenceUtils.deepEqualChildren(seq1, ipos1, seq2, ipos2, collator);
            }
            case 35: {
                if (seq1.posLocalName(ipos1) != seq2.posLocalName(ipos2) || seq1.posNamespaceURI(ipos1) != seq2.posNamespaceURI(ipos2)) {
                    return false;
                }
                return SequenceUtils.deepEqualItems(KAttr.getObjectValue(seq1, ipos1), KAttr.getObjectValue(seq2, ipos2), collator);
            }
            case 37: {
                if (!seq1.posTarget(ipos1).equals(seq2.posTarget(ipos2))) {
                    return false;
                }
                return KNode.getNodeValue(seq1, ipos1).equals(KNode.getNodeValue(seq2, ipos2));
            }
        }
        if (kind1 != kind2) {
            return false;
        }
        return KNode.getNodeValue(seq1, ipos1).equals(KNode.getNodeValue(seq2, ipos2));
    }

    public static boolean deepEqualItems(Object arg1, Object arg2, NamedCollator collator) {
        if (NumberValue.isNaN(arg1) && NumberValue.isNaN(arg2)) {
            return true;
        }
        return Compare.atomicCompare(8, arg1, arg2, collator);
    }

    public static boolean deepEqual(Object arg1, Object arg2, NamedCollator collator) {
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
        boolean is1seq = arg1 instanceof Values;
        boolean is2seq = arg2 instanceof Values;
        Values vals1 = is1seq ? (Values)arg1 : null;
        Values vals2 = is2seq ? (Values)arg2 : null;
        boolean first = true;
        do {
            block17 : {
                Object item2;
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
                Object item1 = is1seq ? vals1.getPosPrevious(ipos1) : arg1;
                Object object2 = item2 = is2seq ? vals2.getPosPrevious(ipos2) : arg2;
                if (!(item1 instanceof KNode) && !(item2 instanceof KNode)) {
                    try {
                        if (!SequenceUtils.deepEqualItems(arg1, arg2, collator)) {
                            return false;
                        }
                        break block17;
                    }
                    catch (Exception ex) {
                        return false;
                    }
                }
                if (item1 instanceof KNode && item2 instanceof KNode) {
                    KNode node1 = (KNode)item1;
                    KNode node2 = (KNode)item2;
                    if (!SequenceUtils.deepEqual((NodeTree)node1.sequence, node1.ipos, (NodeTree)node2.sequence, node2.ipos, collator)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (!first) continue;
            first = false;
            if (!is1seq) {
                ipos1 = 0;
            }
            if (is2seq) continue;
            ipos2 = 0;
        } while (true);
    }

    public static void subList$X(Object seq, double start, double end, CallContext ctx) {
        SequenceUtils.subList$C(seq, start, end, ctx.consumer);
    }

    public static void subList$C(Object seq, double start, double end, Consumer out) {
        if (seq instanceof Values) {
            int istart = (int)(start - 1.0);
            int iend = (int)(end - 1.0);
            Values vals = (Values)seq;
            int sz = vals.size();
            if (istart < 0) {
                istart = 0;
            }
            if (iend > sz) {
                iend = sz;
            }
            if (iend > istart) {
                vals.consume(istart, iend, out);
            }
        } else if (start <= 1.0 && end >= 2.0) {
            out.writeObject(seq);
        }
    }
}

