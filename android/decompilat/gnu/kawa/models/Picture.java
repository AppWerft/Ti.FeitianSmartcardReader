// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;

public interface Picture
{
    void paint(final Graphics2D p0);
    
    Rectangle2D getBounds2D();
    
    Picture transform(final AffineTransform p0);
    
    void visit(final PictureVisitor p0);
}
