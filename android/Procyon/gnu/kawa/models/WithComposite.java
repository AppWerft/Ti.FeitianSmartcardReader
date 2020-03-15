// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.AlphaComposite;
import java.util.HashMap;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Shape;
import java.util.Map;
import java.awt.Composite;

public class WithComposite implements Picture
{
    Picture[] children;
    Composite[] composite;
    static Map<String, Composite> namedComposites;
    
    public static WithComposite make(final Picture picture, final Composite composite) {
        final WithComposite comp = new WithComposite();
        comp.children = new Picture[] { picture };
        comp.composite = new Composite[] { composite };
        return comp;
    }
    
    public static WithComposite make(final Picture[] children, final Composite[] composite) {
        final WithComposite comp = new WithComposite();
        comp.children = children;
        comp.composite = composite;
        return comp;
    }
    
    public static WithComposite make(final Object[] arguments) {
        int n = 0;
        int i = arguments.length;
        while (--i >= 0) {
            final Object arg = arguments[i];
            if (arg instanceof Picture || arg instanceof Shape || arg instanceof BufferedImage) {
                ++n;
            }
        }
        final Picture[] children = new Picture[n];
        final Composite[] composite = new Composite[n];
        Composite comp = null;
        int j = 0;
        for (int k = 0; k < arguments.length; ++k) {
            final Object arg2 = arguments[k];
            if (arg2 instanceof Picture || arg2 instanceof Shape || arg2 instanceof BufferedImage) {
                children[j] = Pictures.asPicture(arg2);
                composite[j] = comp;
                ++j;
            }
            else if (arg2 instanceof Composite) {
                comp = (Composite)arg2;
            }
            else {
                final String name = arg2.toString().toLowerCase().replace("-", "");
                comp = WithComposite.namedComposites.get(name);
                if (comp == null) {
                    throw new IllegalArgumentException("unknown composite " + name);
                }
            }
        }
        return make(children, composite);
    }
    
    public Composite singleOp() {
        final int n = this.children.length;
        if (n == 0) {
            return null;
        }
        final Composite first = this.composite[0];
        for (int i = 1; i < n; ++i) {
            final Composite cur = this.composite[i];
            if (cur != null && cur != first) {
                return null;
            }
        }
        return first;
    }
    
    @Override
    public void paint(final Graphics2D graphics) {
        Composite prev;
        final Composite saved = prev = graphics.getComposite();
        try {
            for (int n = this.children.length, i = 0; i < n; ++i) {
                final Composite cur = this.composite[i];
                if (cur != null && cur != prev) {
                    graphics.setComposite(cur);
                    prev = cur;
                }
                this.children[i].paint(graphics);
            }
        }
        finally {
            if (prev != saved) {
                graphics.setComposite(saved);
            }
        }
    }
    
    @Override
    public Rectangle2D getBounds2D() {
        final int n = this.children.length;
        if (n == 0) {
            return null;
        }
        Rectangle2D bounds = this.children[0].getBounds2D();
        for (int i = 1; i < n; ++i) {
            bounds = bounds.createUnion(this.children[i].getBounds2D());
        }
        return bounds;
    }
    
    @Override
    public Picture transform(final AffineTransform tr) {
        final int n = this.children.length;
        final Picture[] transformed = new Picture[n];
        for (int i = 0; i < n; ++i) {
            transformed[i] = this.children[i].transform(tr);
        }
        return make(transformed, this.composite);
    }
    
    @Override
    public void visit(final PictureVisitor visitor) {
        visitor.visitWithComposite(this);
    }
    
    static {
        (WithComposite.namedComposites = new HashMap<String, Composite>()).put("clear", AlphaComposite.Clear);
        WithComposite.namedComposites.put("dstover", AlphaComposite.DstOver);
        WithComposite.namedComposites.put("src", AlphaComposite.Src);
        WithComposite.namedComposites.put("srcover", AlphaComposite.SrcOver);
    }
}
