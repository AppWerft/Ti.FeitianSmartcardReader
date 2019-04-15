/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import gnu.kawa.util.BoundedHashable;
import gnu.lists.Arrays;
import java.lang.reflect.Array;
import java.util.List;

public class HashUtils {
    public static int boundedHash(Object object2) {
        return HashUtils.boundedHash(object2, 0, 50);
    }

    public static int boundedHash(Object object2, int seed, int limit) {
        if (object2 == null) {
            return HashUtils.hashInt(seed, 0);
        }
        if (!(object2 instanceof CharSequence)) {
            if (object2 instanceof BoundedHashable) {
                return ((BoundedHashable)object2).boundedHash(seed, limit);
            }
            if (object2 instanceof List) {
                return HashUtils.boundedHash((List)object2, seed, limit);
            }
            if (object2.getClass().isArray()) {
                return HashUtils.boundedHashArray(object2, seed, limit);
            }
            if (object2 instanceof gnu.lists.Array) {
                return HashUtils.boundedHash((gnu.lists.Array)object2, seed, limit);
            }
        }
        return HashUtils.hashInt(seed, object2.hashCode());
    }

    public static int hashInt(int seed, int value) {
        return HashUtils.murmur3finish(HashUtils.murmur3step(seed, value), 4);
    }

    public static int boundedHash(List object2, int seed, int limit) {
        int count = 0;
        int sublimit = limit >> 1;
        for (Object obj : object2) {
            if (++count > limit) break;
            seed = HashUtils.murmur3step(seed, HashUtils.boundedHash(obj, 0, sublimit));
        }
        return HashUtils.murmur3finish(seed, count);
    }

    public static int boundedHashArray(Object object2, int seed, int limit) {
        int count = 0;
        int sublimit = limit >> 1;
        int length = Array.getLength(object2);
        for (int i = 0; i < length && ++count <= limit; ++i) {
            Object element = Array.get(object2, i);
            seed = HashUtils.murmur3step(seed, HashUtils.boundedHash(element, 0, sublimit));
        }
        return HashUtils.murmur3finish(seed, count);
    }

    public static int boundedHash(gnu.lists.Array arr, int seed, int limit) {
        int rank = arr.rank();
        int[] indexes = new int[rank];
        int size = 1;
        for (int r = 0; r < rank; ++r) {
            indexes[r] = arr.getLowBound(r);
            size *= arr.getSize(r);
        }
        int count = 0;
        int sublimit = limit >> 1;
        for (int i = 0; i < size && ++count <= limit; ++i) {
            Object element = arr.get(indexes);
            seed = HashUtils.murmur3step(seed, HashUtils.boundedHash(element, 0, sublimit));
            Arrays.incrementIndexes(indexes, arr);
        }
        return HashUtils.murmur3finish(seed, count);
    }

    public static int murmur3step(int h1, int k1) {
        return ((h1 ^= ((k1 *= -862048943) << 15 | k1 >>> 17) * 461845907) << 13 | h1 >>> 19) * 5 + -430675100;
    }

    public static int murmur3finish(int hash, int length) {
        hash ^= length;
        hash = (hash ^ hash >>> 16) * -2048144789;
        hash = (hash ^ hash >>> 13) * -1028477387;
        return hash ^ hash >>> 16;
    }
}

