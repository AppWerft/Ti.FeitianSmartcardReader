package gnu.kawa.util;

import gnu.lists.Arrays;
import java.util.List;








public class HashUtils
{
  public HashUtils() {}
  
  public static int boundedHash(Object object)
  {
    return boundedHash(object, 0, 50);
  }
  









  public static int boundedHash(Object object, int seed, int limit)
  {
    if (object == null)
      return hashInt(seed, 0);
    if (!(object instanceof CharSequence))
    {
      if ((object instanceof BoundedHashable))
        return ((BoundedHashable)object).boundedHash(seed, limit);
      if ((object instanceof List))
        return boundedHash((List)object, seed, limit);
      if (object.getClass().isArray())
        return boundedHashArray(object, seed, limit);
      if ((object instanceof gnu.lists.Array))
        return boundedHash((gnu.lists.Array)object, seed, limit); }
    return hashInt(seed, object.hashCode());
  }
  
  public static int hashInt(int seed, int value) {
    return murmur3finish(murmur3step(seed, value), 4);
  }
  

















  public static int boundedHash(List object, int seed, int limit)
  {
    int count = 0;
    int sublimit = limit >> 1;
    for (Object obj : object) {
      count++; if (count > limit)
        break;
      seed = murmur3step(seed, boundedHash(obj, 0, sublimit));
    }
    return murmur3finish(seed, count);
  }
  
  public static int boundedHashArray(Object object, int seed, int limit) {
    int count = 0;
    int sublimit = limit >> 1;
    int length = java.lang.reflect.Array.getLength(object);
    for (int i = 0; i < length; i++) {
      count++; if (count > limit)
        break;
      Object element = java.lang.reflect.Array.get(object, i);
      seed = murmur3step(seed, boundedHash(element, 0, sublimit));
    }
    return murmur3finish(seed, count);
  }
  
  public static int boundedHash(gnu.lists.Array arr, int seed, int limit) {
    int rank = arr.rank();
    int[] indexes = new int[rank];
    int size = 1;
    for (int r = 0; r < rank; r++) {
      indexes[r] = arr.getLowBound(r);
      size *= arr.getSize(r);
    }
    int count = 0;
    int sublimit = limit >> 1;
    for (int i = 0; i < size; i++) {
      count++; if (count > limit)
        break;
      Object element = arr.get(indexes);
      seed = murmur3step(seed, boundedHash(element, 0, sublimit));
      Arrays.incrementIndexes(indexes, arr);
    }
    return murmur3finish(seed, count);
  }
  
  public static int murmur3step(int h1, int k1) {
    k1 *= -862048943;
    h1 ^= (k1 << 15 | k1 >>> 17) * 461845907;
    return (h1 << 13 | h1 >>> 19) * 5 + -430675100;
  }
  
  public static int murmur3finish(int hash, int length) {
    hash ^= length;
    hash = (hash ^ hash >>> 16) * -2048144789;
    hash = (hash ^ hash >>> 13) * -1028477387;
    return hash ^ hash >>> 16;
  }
}
