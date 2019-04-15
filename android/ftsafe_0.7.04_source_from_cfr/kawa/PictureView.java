/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import gnu.kawa.models.Picture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.View;

class PictureView
extends View {
    Picture p;
    Rectangle2D bounds;

    public PictureView(Element elem, Picture picture) {
        super(elem);
        this.p = picture;
        this.bounds = picture.getBounds2D();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void paint(Graphics g, Shape a) {
        Graphics2D g2 = (Graphics2D)g;
        Rectangle2D abounds = a.getBounds2D();
        AffineTransform saveTransform = g2.getTransform();
        Paint savePaint = g2.getPaint();
        try {
            g2.translate(abounds.getX() - this.bounds.getX(), abounds.getY() - this.bounds.getY());
            g2.setPaint(Color.BLACK);
            this.p.paint(g2);
        }
        finally {
            g2.setTransform(saveTransform);
            g2.setPaint(savePaint);
        }
    }

    @Override
    public float getAlignment(int axis) {
        switch (axis) {
            case 1: {
                return 1.0f;
            }
        }
        return super.getAlignment(axis);
    }

    @Override
    public float getPreferredSpan(int axis) {
        switch (axis) {
            case 0: {
                return (float)this.bounds.getWidth();
            }
            case 1: {
                return (float)this.bounds.getHeight();
            }
        }
        throw new IllegalArgumentException("Invalid axis: " + axis);
    }

    @Override
    public Shape modelToView(int pos, Shape a, Position.Bias b) throws BadLocationException {
        int p0 = this.getStartOffset();
        int p1 = this.getEndOffset();
        if (pos >= p0 && pos <= p1) {
            Rectangle r = a.getBounds();
            if (pos == p1) {
                r.x += r.width;
            }
            r.width = 0;
            return r;
        }
        throw new BadLocationException(pos + " not in range " + p0 + "," + p1, pos);
    }

    @Override
    public int viewToModel(float x, float y, Shape a, Position.Bias[] bias) {
        Rectangle alloc = (Rectangle)a;
        if (x < (float)(alloc.x + alloc.width / 2)) {
            bias[0] = Position.Bias.Forward;
            return this.getStartOffset();
        }
        bias[0] = Position.Bias.Backward;
        return this.getEndOffset();
    }
}

