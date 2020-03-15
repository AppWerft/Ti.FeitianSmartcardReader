// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.io.Serializable;

public class Column extends Box implements Viewable, Serializable
{
    @Override
    public int getAxis() {
        return 1;
    }
}
