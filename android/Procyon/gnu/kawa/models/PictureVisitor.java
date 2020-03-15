// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.BasicStroke;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;

public class PictureVisitor
{
    public void visitFillShape(final FillShape pic) {
    }
    
    public void visitDrawShape(final DrawShape pic) {
    }
    
    public void visitDrawImage(final DrawImage pic) {
    }
    
    public void visitWithPaint(final WithPaint pic) {
        pic.picture.visit(this);
    }
    
    public void visitWithTransform(final WithTransform pic) {
        pic.picture.visit(this);
    }
    
    public void visitWithComposite(final WithComposite pic) {
        for (final Picture child : pic.children) {
            child.visit(this);
        }
    }
    
    public void visitPBox(final PBox pic) {
        for (final Picture child : pic.children) {
            child.visit(this);
        }
    }
    
    public static class TrackingState extends PictureVisitor
    {
        protected AffineTransform transform;
        protected Stroke stroke;
        protected Paint paint;
        protected int strokePropertiesSet;
        
        public TrackingState(final AffineTransform transform) {
            this.stroke = null;
            this.paint = null;
            this.strokePropertiesSet = 0;
            this.transform = transform;
        }
        
        public TrackingState() {
            this.stroke = null;
            this.paint = null;
            this.strokePropertiesSet = 0;
            this.transform = null;
        }
        
        @Override
        public void visitWithTransform(final WithTransform pic) {
            final AffineTransform savedTransform = this.transform;
            try {
                this.transform = pic.transform;
                if (savedTransform != null) {
                    (this.transform = new AffineTransform(this.transform)).preConcatenate(savedTransform);
                }
                super.visitWithTransform(pic);
            }
            finally {
                this.transform = savedTransform;
            }
        }
        
        @Override
        public void visitWithPaint(final WithPaint pic) {
            final Paint savedPaint = this.paint;
            final Stroke savedStroke = this.stroke;
            final int savedPropertiesSet = this.strokePropertiesSet;
            try {
                if (pic.paint != null) {
                    this.paint = pic.paint;
                }
                Stroke nstroke = pic.stroke;
                if (nstroke != null) {
                    this.strokePropertiesSet |= pic.propertiesSet;
                    if (savedStroke instanceof BasicStroke && nstroke instanceof BasicStroke && (pic.propertiesSet & 0x3F) != 0x3F) {
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
