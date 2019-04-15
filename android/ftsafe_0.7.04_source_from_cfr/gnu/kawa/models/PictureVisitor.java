/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.DrawImage;
import gnu.kawa.models.DrawShape;
import gnu.kawa.models.FillShape;
import gnu.kawa.models.PBox;
import gnu.kawa.models.Picture;
import gnu.kawa.models.WithComposite;
import gnu.kawa.models.WithPaint;
import gnu.kawa.models.WithTransform;
import java.awt.BasicStroke;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;

public class PictureVisitor {
    public void visitFillShape(FillShape pic) {
    }

    public void visitDrawShape(DrawShape pic) {
    }

    public void visitDrawImage(DrawImage pic) {
    }

    public void visitWithPaint(WithPaint pic) {
        pic.picture.visit(this);
    }

    public void visitWithTransform(WithTransform pic) {
        pic.picture.visit(this);
    }

    public void visitWithComposite(WithComposite pic) {
        for (Picture child : pic.children) {
            child.visit(this);
        }
    }

    public void visitPBox(PBox pic) {
        for (Picture child : pic.children) {
            child.visit(this);
        }
    }

    public static class TrackingState
    extends PictureVisitor {
        protected AffineTransform transform;
        protected Stroke stroke = null;
        protected Paint paint = null;
        protected int strokePropertiesSet = 0;

        public TrackingState(AffineTransform transform) {
            this.transform = transform;
        }

        public TrackingState() {
            this.transform = null;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void visitWithTransform(WithTransform pic) {
            AffineTransform savedTransform = this.transform;
            try {
                this.transform = pic.transform;
                if (savedTransform != null) {
                    this.transform = new AffineTransform(this.transform);
                    this.transform.preConcatenate(savedTransform);
                }
                super.visitWithTransform(pic);
            }
            finally {
                this.transform = savedTransform;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void visitWithPaint(WithPaint pic) {
            Paint savedPaint = this.paint;
            Stroke savedStroke = this.stroke;
            int savedPropertiesSet = this.strokePropertiesSet;
            try {
                Stroke nstroke;
                if (pic.paint != null) {
                    this.paint = pic.paint;
                }
                if ((nstroke = pic.stroke) != null) {
                    this.strokePropertiesSet |= pic.propertiesSet;
                    if (savedStroke instanceof BasicStroke && nstroke instanceof BasicStroke && (pic.propertiesSet & 63) != 63) {
                        nstroke = WithPaint.merge((BasicStroke)nstroke, pic.propertiesSet, (BasicStroke)savedStroke);
                    }
                    this.stroke = nstroke;
                }
                super.visitWithPaint(pic);
            }
            finally {
                if (pic.paint != null) {
                    this.paint = savedPaint;
                }
                if (this.stroke != null) {
                    this.stroke = savedStroke;
                }
                this.strokePropertiesSet = savedPropertiesSet;
            }
        }
    }

}

