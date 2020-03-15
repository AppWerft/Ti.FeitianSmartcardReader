// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import java.awt.Rectangle;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import java.awt.geom.AffineTransform;
import java.awt.Paint;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Graphics;
import javax.swing.text.Element;
import java.awt.geom.Rectangle2D;
import gnu.kawa.models.Picture;
import javax.swing.text.View;

class PictureView extends View
{
    Picture p;
    Rectangle2D bounds;
    
    public PictureView(final Element elem, final Picture picture) {
        super(elem);
        this.p = picture;
        this.bounds = picture.getBounds2D();
    }
    
    @Override
    public void paint(final Graphics g, final Shape a) {
        final Graphics2D g2 = (Graphics2D)g;
        final Rectangle2D abounds = a.getBounds2D();
        final AffineTransform saveTransform = g2.getTransform();
        final Paint savePaint = g2.getPaint();
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
    public float getAlignment(final int axis) {
        switch (axis) {
            case 1: {
                return 1.0f;
            }
            default: {
                return super.getAlignment(axis);
            }
        }
    }
    
    @Override
    public float getPreferredSpan(final int axis) {
        switch (axis) {
            case 0: {
                return (float)this.bounds.getWidth();
            }
            case 1: {
                return (float)this.bounds.getHeight();
            }
            default: {
                throw new IllegalArgumentException("Invalid axis: " + axis);
            }
        }
    }
    
    @Override
    public Shape modelToView(final int pos, final Shape a, final Position.Bias b) throws BadLocationException {
        final int p0 = this.getStartOffset();
        final int p2 = this.getEndOffset();
        if (pos >= p0 && pos <= p2) {
            final Rectangle r = a.getBounds();
            if (pos == p2) {
                final Rectangle rectangle = r;
                rectangle.x += r.width;
            }
            r.width = 0;
            return r;
        }
        throw new BadLocationException(pos + " not in range " + p0 + "," + p2, pos);
    }
    
    @Override
    public int viewToModel(final float x, final float y, final Shape a, final Position.Bias[] bias) {
        final Rectangle alloc = (Rectangle)a;
        if (x < alloc.x + alloc.width / 2) {
            bias[0] = Position.Bias.Forward;
            return this.getStartOffset();
        }
        bias[0] = Position.Bias.Backward;
        return this.getEndOffset();
    }
}
