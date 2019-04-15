/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.NumberCompare;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure2;
import gnu.mapping.Promise;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class IsEqual
extends Procedure2 {
    Language language;

    public IsEqual(Language language, String name) {
        this.language = language;
        this.setName(name);
    }

    public static boolean numberEquals(Number num1, Number num2) {
        boolean exact1 = Arithmetic.isExact(num1);
        boolean exact2 = Arithmetic.isExact(num2);
        if (exact1 && exact2) {
            return NumberCompare.$Eq(num1, num2);
        }
        return exact1 == exact2 && num1.equals(num2);
    }

    boolean arrayEquals(Object arg1, Object arg2, Map<Object, ArrayList<Object>> map) {
        int len2;
        String tname2;
        int len1 = Array.getLength(arg1);
        if (len1 != (len2 = Array.getLength(arg2))) {
            return false;
        }
        String tname1 = arg1.getClass().getName();
        if (!tname1.equals(tname2 = arg2.getClass().getName())) {
            return false;
        }
        if (tname1.length() == 2) {
            switch (tname1.charAt(1)) {
                case 'Z': {
                    return Arrays.equals((boolean[])arg1, (boolean[])arg2);
                }
                case 'B': {
                    return Arrays.equals((byte[])arg1, (byte[])arg2);
                }
                case 'C': {
                    return Arrays.equals((char[])arg1, (char[])arg2);
                }
                case 'D': {
                    return Arrays.equals((double[])arg1, (double[])arg2);
                }
                case 'F': {
                    return Arrays.equals((float[])arg1, (float[])arg2);
                }
                case 'I': {
                    return Arrays.equals((int[])arg1, (int[])arg2);
                }
                case 'J': {
                    return Arrays.equals((long[])arg1, (long[])arg2);
                }
                case 'S': {
                    return Arrays.equals((short[])arg1, (short[])arg2);
                }
            }
        }
        if (IsEqual.noteEqual(arg1, arg2, map)) {
            return true;
        }
        int i = len1;
        while (--i >= 0) {
            if (this.apply(Array.get(arg1, i), Array.get(arg2, i), map)) continue;
            return false;
        }
        return true;
    }

    static boolean noteEqual(Object arg1, Object arg2, Map<Object, ArrayList<Object>> map) {
        ArrayList<Object> set2;
        ArrayList<Object> set1 = map.get(arg1);
        if (set1 == (set2 = map.get(arg2))) {
            if (set1 != null) {
                return true;
            }
            ArrayList<Object> setn = new ArrayList<Object>();
            setn.add(arg1);
            setn.add(arg2);
            map.put(arg1, setn);
            map.put(arg2, setn);
        } else if (set1 == null) {
            set2.add(arg1);
            map.put(arg1, set2);
        } else if (set2 == null) {
            set1.add(arg2);
            map.put(arg2, set1);
        } else if (set1.size() > set2.size()) {
            for (Object x : set2) {
                set1.add(x);
                map.put(x, set1);
            }
        } else {
            for (Object x : set1) {
                set2.add(x);
                map.put(x, set2);
            }
        }
        return false;
    }

    public boolean apply(Object arg1, Object arg2) {
        return this.apply(arg1, arg2, null);
    }

    public boolean apply(Object arg1, Object arg2, Map<Object, ArrayList<Object>> map) {
        if ((arg1 = Promise.force(arg1)) == (arg2 = Promise.force(arg2))) {
            return true;
        }
        if (arg1 == null || arg2 == null) {
            return false;
        }
        if (arg1 instanceof Number || arg2 instanceof Number) {
            return arg1 instanceof Number && arg2 instanceof Number && IsEqual.numberEquals((Number)arg1, (Number)arg2);
        }
        if (arg1 instanceof CharSequence || arg2 instanceof CharSequence) {
            int len2;
            if (!(arg1 instanceof CharSequence) || !(arg2 instanceof CharSequence)) {
                return false;
            }
            CharSequence seq1 = (CharSequence)arg1;
            CharSequence seq2 = (CharSequence)arg2;
            int len1 = seq1.length();
            if (len1 != (len2 = seq2.length())) {
                return false;
            }
            int i = len1;
            while (--i >= 0) {
                if (seq1.charAt(i) == seq2.charAt(i)) continue;
                return false;
            }
            return true;
        }
        if (map == null) {
            map = new IdentityHashMap<Object, ArrayList<Object>>();
        }
        if (arg1 instanceof LList || arg2 instanceof LList) {
            if (!(arg1 instanceof Pair) || !(arg2 instanceof Pair)) {
                return false;
            }
            Pair pair1 = (Pair)arg1;
            Pair pair2 = (Pair)arg2;
            do {
                if (IsEqual.noteEqual(pair1, pair2, map)) {
                    return true;
                }
                if (!this.apply(pair1.getCar(), pair2.getCar(), map)) {
                    return false;
                }
                Object x1 = pair1.getCdr();
                Object x2 = pair2.getCdr();
                if (!(x1 instanceof Pair) || !(x2 instanceof Pair)) {
                    return this.apply(x1, x2, map);
                }
                pair1 = (Pair)x1;
                pair2 = (Pair)x2;
            } while (true);
        }
        if (arg1 instanceof List || arg2 instanceof List) {
            if (!(arg1 instanceof List) || !(arg2 instanceof List)) {
                return false;
            }
            if (IsEqual.noteEqual(arg1, arg2, map)) {
                return true;
            }
            ListIterator e1 = ((List)arg1).listIterator();
            ListIterator e2 = ((List)arg2).listIterator();
            while (e1.hasNext() && e2.hasNext()) {
                if (this.apply(e1.next(), e2.next(), map)) continue;
                return false;
            }
            return !e1.hasNext() && !e2.hasNext();
        }
        if (arg1 instanceof gnu.lists.Array || arg2 instanceof gnu.lists.Array) {
            if (!(arg1 instanceof gnu.lists.Array) || !(arg2 instanceof gnu.lists.Array)) {
                return false;
            }
            gnu.lists.Array arr1 = (gnu.lists.Array)arg1;
            gnu.lists.Array arr2 = (gnu.lists.Array)arg2;
            int rank = arr1.rank();
            if (rank != arr2.rank() || arr1.getElementKind() != arr2.getElementKind()) {
                return false;
            }
            int[] indexes = new int[rank];
            int size = 1;
            int r = rank;
            while (--r >= 0) {
                int low = arr1.getLowBound(r);
                int dim = arr1.getSize(r);
                indexes[r] = low;
                size *= dim;
                if (dim == arr2.getSize(r) && low == arr1.getLowBound(r)) continue;
                return false;
            }
            if (IsEqual.noteEqual(arg1, arg2, map)) {
                return true;
            }
            for (int i = 0; i < size; ++i) {
                if (!this.apply(arr1.get(indexes), arr2.get(indexes), map)) {
                    return false;
                }
                gnu.lists.Arrays.incrementIndexes(indexes, arr1);
            }
            return true;
        }
        boolean is1Array = arg1.getClass().isArray();
        boolean is2Array = arg2.getClass().isArray();
        if (is1Array || is2Array) {
            return is1Array && is2Array && this.arrayEquals(arg1, arg2, map);
        }
        return arg1.equals(arg2);
    }

    @Override
    public Object apply2(Object arg1, Object arg2) {
        return this.language.booleanObject(this.apply(arg1, arg2));
    }
}

