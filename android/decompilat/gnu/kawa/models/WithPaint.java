// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Stroke;
import java.awt.Paint;

public class WithPaint implements Picture
{
    Picture picture;
    Paint paint;
    Stroke stroke;
    int propertiesSet;
    public static final int STROKE_WIDTH_SET = 1;
    public static final int STROKE_LINECAP_SET = 2;
    public static final int STROKE_LINEJOIN_SET = 4;
    public static final int STROKE_MITERLIMIT_SET = 8;
    public static final int STROKE_DASHARRAY_SET = 16;
    public static final int STROKE_DASHOFFSET_SET = 32;
    public static final int STROKE_ALL_SET = 63;
    
    public WithPaint(final Picture picture, final Paint paint) {
        this.picture = picture;
        this.paint = paint;
    }
    
    public WithPaint(final Picture picture, final Paint paint, final Stroke stroke, final int propertiesSet) {
        this.picture = picture;
        this.paint = paint;
        this.stroke = stroke;
        this.propertiesSet = propertiesSet;
    }
    
    public static BasicStroke merge(final BasicStroke newStroke, final int select, final BasicStroke oldStroke) {
        if (oldStroke == null) {
            return newStroke;
        }
        final float width = ((select & 0x1) != 0x0) ? newStroke.getLineWidth() : oldStroke.getLineWidth();
        final int cap = ((select & 0x2) != 0x0) ? newStroke.getEndCap() : oldStroke.getEndCap();
        final int join = ((select & 0x4) != 0x0) ? newStroke.getLineJoin() : oldStroke.getLineJoin();
        final float miterlimit = ((select & 0x8) != 0x0) ? newStroke.getMiterLimit() : oldStroke.getMiterLimit();
        final float[] dash = ((select & 0x10) != 0x0) ? newStroke.getDashArray() : oldStroke.getDashArray();
        final float dash_phase = ((select & 0x20) != 0x0) ? newStroke.getDashPhase() : oldStroke.getDashPhase();
        return new BasicStroke(width, cap, join, miterlimit, dash, dash_phase);
    }
    
    @Override
    public void paint(final Graphics2D graphics) {
        final Paint savedPaint = graphics.getPaint();
        final Stroke savedStroke = graphics.getStroke();
        try {
            if (this.paint != null) {
                graphics.setPaint(this.paint);
            }
            if (this.stroke != null) {
                Stroke nstroke = this.stroke;
                if (savedStroke instanceof BasicStroke && nstroke instanceof BasicStroke && (this.propertiesSet & 0x3F) != 0x3F) {
                    nstroke = merge((BasicStroke)this.stroke, this.propertiesSet, (BasicStroke)savedStroke);
                }
                graphics.setStroke(nstroke);
            }
            this.picture.paint(graphics);
        }
        finally {
            if (this.paint != null) {
                graphics.setPaint(savedPaint);
            }
            if (this.stroke != null) {
                graphics.setStroke(savedStroke);
            }
        }
    }
    
    @Override
    public Rectangle2D getBounds2D() {
        return this.picture.getBounds2D();
    }
    
    @Override
    public Picture transform(final AffineTransform tr) {
        return new WithPaint(this.picture.transform(tr), this.paint, this.stroke, this.propertiesSet);
    }
    
    @Override
    public void visit(final PictureVisitor visitor) {
        visitor.visitWithPaint(this);
    }
}
