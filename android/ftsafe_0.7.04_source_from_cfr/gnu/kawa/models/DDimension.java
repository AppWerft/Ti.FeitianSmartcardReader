/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;

public class DDimension
extends Dimension {
    private double w;
    private double h;

    public DDimension() {
    }

    public DDimension(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public DDimension(Dimension2D d) {
        this(d.getWidth(), d.getHeight());
    }

    @Override
    public double getWidth() {
        return this.w;
    }

    @Override
    public double getHeight() {
        return this.h;
    }

    @Override
    public DDimension getSize() {
        return new DDimension(this.w, this.h);
    }

    public void setWidth(double width) {
        this.w = width;
        this.width = (int)Math.ceil(width);
    }

    public void setHeight(double height) {
        this.h = height;
        this.height = (int)Math.ceil(height);
    }

    @Override
    public void setSize(int width, int height) {
        this.w = width;
        this.width = width;
        this.h = height;
        this.height = height;
    }

    @Override
    public void setSize(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    @Override
    public void setSize(Dimension d) {
        this.setSize(d.getWidth(), d.getHeight());
    }

    @Override
    public void setSize(Dimension2D d) {
        this.setSize(d.getWidth(), d.getHeight());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DDimension) {
            DDimension d = (DDimension)obj;
            return this.w == d.w && this.h == d.h;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[width=" + this.getWidth() + ",height=" + this.getHeight() + "]";
    }
}

