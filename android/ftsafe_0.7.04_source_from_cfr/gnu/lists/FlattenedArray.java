/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AVector;
import gnu.lists.Array;
import gnu.lists.Arrays;
import gnu.lists.GeneralArray;
import gnu.lists.TransformedArray;

public class FlattenedArray<E>
extends TransformedArray<E>
implements AVector<E> {
    private final int size;
    private final int brank;

    public FlattenedArray(Array<E> base2) {
        super(base2);
        this.size = base2.getSize();
        this.brank = base2.rank();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int getSize(int dim) {
        if (dim != 0) {
            this.badRank(dim);
        }
        return this.size;
    }

    @Override
    public int effectiveIndex(int i) {
        return Arrays.rowMajorToEffectiveIndex(this.base, i);
    }

    public static <E> AVector<E> flatten(Array<E> array) {
        if (array instanceof AVector) {
            return (AVector)array;
        }
        if (array instanceof GeneralArray) {
            GeneralArray garr = (GeneralArray)array;
            if (garr.simple && garr.base instanceof AVector) {
                return (AVector)garr.base;
            }
        }
        return new FlattenedArray<E>(array);
    }
}

