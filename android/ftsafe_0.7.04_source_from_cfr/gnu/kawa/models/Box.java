/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.Display;
import gnu.kawa.models.Model;
import gnu.kawa.models.Spacer;
import gnu.kawa.models.Viewable;
import gnu.math.IntNum;
import java.awt.Dimension;
import java.io.Serializable;

public abstract class Box
extends Model
implements Viewable,
Serializable {
    Viewable[] components;
    int numComponents;
    Viewable cellSpacing;

    public Viewable getCellSpacing() {
        return this.cellSpacing;
    }

    public void setCellSpacing(Object cellSpacing) {
        if (cellSpacing instanceof IntNum || cellSpacing instanceof Integer) {
            int size = ((Number)cellSpacing).intValue();
            Dimension dim = this.getAxis() == 0 ? new Dimension(size, 0) : new Dimension(0, size);
            this.cellSpacing = Spacer.rigidArea(dim);
        } else {
            this.cellSpacing = (Viewable)cellSpacing;
        }
    }

    public abstract int getAxis();

    public final int getComponentCount() {
        return this.numComponents;
    }

    public final Viewable getComponent(int i) {
        return this.components[i];
    }

    public void add(Viewable component) {
        Viewable[] arr = this.components;
        int n = this.numComponents;
        if (n == 0) {
            this.components = arr = new Viewable[4];
        } else if (arr.length <= n) {
            this.components = new Viewable[2 * n];
            System.arraycopy(arr, 0, this.components, 0, n);
            arr = this.components;
        }
        this.components[n] = component;
        this.numComponents = n + 1;
    }

    @Override
    public void makeView(Display display, Object where) {
        display.addBox(this, where);
    }
}

