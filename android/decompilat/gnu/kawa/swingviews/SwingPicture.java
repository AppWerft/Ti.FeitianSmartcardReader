// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.swingviews;

import java.awt.geom.AffineTransform;
import java.awt.Stroke;
import java.awt.Graphics2D;
import java.awt.Graphics;
import gnu.kawa.models.Pictures;
import java.awt.geom.Rectangle2D;
import java.awt.Dimension;
import gnu.kawa.models.Picture;
import javax.swing.JPanel;

public class SwingPicture extends JPanel
{
    Picture picture;
    Dimension dim;
    Rectangle2D rect;
    
    public SwingPicture(final Picture picture) {
        this.setPicture(picture);
    }
    
    public Picture getPicture() {
        return this.picture;
    }
    
    public void setPicture(final Object picture) {
        this.setPicture(Pictures.asPicture(picture));
    }
    
    public void setPicture(final Picture picture) {
        this.picture = picture;
        final Rectangle2D rect = picture.getBounds2D();
        this.rect = rect;
        final int h = (int)Math.ceil(rect.getHeight());
        final int w = (int)Math.ceil(rect.getWidth());
        this.dim = new Dimension(w, h);
        if (!this.isPreferredSizeSet()) {
            this.setPreferredSize(this.dim);
        }
        this.repaint(0L, 0, 0, this.getWidth(), this.getHeight());
    }
    
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2 = (Graphics2D)g;
        final AffineTransform saveTransform = g2.getTransform();
        final Stroke savedStroke = g2.getStroke();
        try {
            g2.setStroke(Pictures.defaultStroke);
            g2.translate((this.getWidth() - this.rect.getWidth()) * 0.5 - this.rect.getX(), (this.getHeight() - this.rect.getHeight()) * 0.5 - this.rect.getY());
            this.picture.paint(g2);
        }
        finally {
            g2.setTransform(saveTransform);
            g2.setStroke(savedStroke);
        }
    }
}
