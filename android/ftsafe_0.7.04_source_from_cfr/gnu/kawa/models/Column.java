/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.Box;
import gnu.kawa.models.Viewable;
import java.io.Serializable;

public class Column
extends Box
implements Viewable,
Serializable {
    @Override
    public int getAxis() {
        return 1;
    }
}

