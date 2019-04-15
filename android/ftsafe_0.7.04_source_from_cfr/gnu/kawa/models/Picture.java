/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.PictureVisitor;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public interface Picture {
    public void paint(Graphics2D var1);

    public Rectangle2D getBounds2D();

    public Picture transform(AffineTransform var1);

    public void visit(PictureVisitor var1);
}

