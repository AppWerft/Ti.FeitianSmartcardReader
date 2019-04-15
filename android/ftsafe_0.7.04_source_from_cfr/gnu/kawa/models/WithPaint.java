/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.Picture;
import gnu.kawa.models.PictureVisitor;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class WithPaint
implements Picture {
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

    public WithPaint(Picture picture, Paint paint) {
        this.picture = picture;
        this.paint = paint;
    }

    public WithPaint(Picture picture, Paint paint, Stroke stroke, int propertiesSet) {
        this.picture = picture;
        this.paint = paint;
        this.stroke = stroke;
        this.propertiesSet = propertiesSet;
    }

    public static BasicStroke merge(BasicStroke newStroke, int select, BasicStroke oldStroke) {
        if (oldStroke == null) {
            return newStroke;
        }
        float width = (select & 1) != 0 ? newStroke.getLineWidth() : oldStroke.getLineWidth();
        int cap = (select & 2) != 0 ? newStroke.getEndCap() : oldStroke.getEndCap();
        int join = (select & 4) != 0 ? newStroke.getLineJoin() : oldStroke.getLineJoin();
        float miterlimit = (select & 8) != 0 ? newStroke.getMiterLimit() : oldStroke.getMiterLimit();
        float[] dash = (select & 16) != 0 ? newStroke.getDashArray() : oldStroke.getDashArray();
        float dash_phase = (select & 32) != 0 ? newStroke.getDashPhase() : oldStroke.getDashPhase();
        return new BasicStroke(width, cap, join, miterlimit, dash, dash_phase);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void paint(Graphics2D graphics) {
        Paint savedPaint = graphics.getPaint();
        Stroke savedStroke = graphics.getStroke();
        try {
            if (this.paint != null) {
                graphics.setPaint(this.paint);
            }
            if (this.stroke != null) {
                Stroke nstroke = this.stroke;
                if (savedStroke instanceof BasicStroke && nstroke instanceof BasicStroke && (this.propertiesSet & 63) != 63) {
                    nstroke = WithPaint.merge((BasicStroke)this.stroke, this.propertiesSet, (BasicStroke)savedStroke);
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
    public Picture transform(AffineTransform tr) {
        return new WithPaint(this.picture.transform(tr), this.paint, this.stroke, this.propertiesSet);
    }

    @Override
    public void visit(PictureVisitor visitor) {
        visitor.visitWithPaint(this);
    }
}

