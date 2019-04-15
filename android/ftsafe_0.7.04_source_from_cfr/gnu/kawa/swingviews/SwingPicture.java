/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.swingviews;

import gnu.kawa.models.Picture;
import gnu.kawa.models.Pictures;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class SwingPicture
extends JPanel {
    Picture picture;
    Dimension dim;
    Rectangle2D rect;

    public SwingPicture(Picture picture) {
        this.setPicture(picture);
    }

    public Picture getPicture() {
        return this.picture;
    }

    public void setPicture(Object picture) {
        this.setPicture(Pictures.asPicture(picture));
    }

    public void setPicture(Picture picture) {
        Rectangle2D rect;
        this.picture = picture;
        this.rect = rect = picture.getBounds2D();
        int h = (int)Math.ceil(rect.getHeight());
        int w = (int)Math.ceil(rect.getWidth());
        this.dim = new Dimension(w, h);
        if (!this.isPreferredSizeSet()) {
            this.setPreferredSize(this.dim);
        }
        this.repaint(0L, 0, 0, this.getWidth(), this.getHeight());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform saveTransform = g2.getTransform();
        Stroke savedStroke = g2.getStroke();
        try {
            g2.setStroke(Pictures.defaultStroke);
            g2.translate(((double)this.getWidth() - this.rect.getWidth()) * 0.5 - this.rect.getX(), ((double)this.getHeight() - this.rect.getHeight()) * 0.5 - this.rect.getY());
            this.picture.paint(g2);
        }
        finally {
            g2.setTransform(saveTransform);
            g2.setStroke(savedStroke);
        }
    }
}

