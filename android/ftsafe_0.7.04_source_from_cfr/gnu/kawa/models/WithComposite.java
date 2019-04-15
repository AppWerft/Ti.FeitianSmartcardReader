/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.models.Picture;
import gnu.kawa.models.PictureVisitor;
import gnu.kawa.models.Pictures;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class WithComposite
implements Picture {
    Picture[] children;
    Composite[] composite;
    static Map<String, Composite> namedComposites = new HashMap<String, Composite>();

    public static WithComposite make(Picture picture, Composite composite) {
        WithComposite comp = new WithComposite();
        comp.children = new Picture[]{picture};
        comp.composite = new Composite[]{composite};
        return comp;
    }

    public static WithComposite make(Picture[] children, Composite[] composite) {
        WithComposite comp = new WithComposite();
        comp.children = children;
        comp.composite = composite;
        return comp;
    }

    public static WithComposite make(Object[] arguments) {
        int n = 0;
        int i = arguments.length;
        while (--i >= 0) {
            Object arg = arguments[i];
            if (!(arg instanceof Picture) && !(arg instanceof Shape) && !(arg instanceof BufferedImage)) continue;
            ++n;
        }
        Picture[] children = new Picture[n];
        Composite[] composite = new Composite[n];
        Composite comp = null;
        int j = 0;
        for (int i2 = 0; i2 < arguments.length; ++i2) {
            Object arg = arguments[i2];
            if (arg instanceof Picture || arg instanceof Shape || arg instanceof BufferedImage) {
                children[j] = Pictures.asPicture(arg);
                composite[j] = comp;
                ++j;
                continue;
            }
            if (arg instanceof Composite) {
                comp = (Composite)arg;
                continue;
            }
            String name = arg.toString().toLowerCase().replace("-", "");
            comp = namedComposites.get(name);
            if (comp != null) continue;
            throw new IllegalArgumentException("unknown composite " + name);
        }
        return WithComposite.make(children, composite);
    }

    public Composite singleOp() {
        int n = this.children.length;
        if (n == 0) {
            return null;
        }
        Composite first = this.composite[0];
        for (int i = 1; i < n; ++i) {
            Composite cur = this.composite[i];
            if (cur == null || cur == first) continue;
            return null;
        }
        return first;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void paint(Graphics2D graphics) {
        Composite saved;
        Composite prev = saved = graphics.getComposite();
        try {
            int n = this.children.length;
            for (int i = 0; i < n; ++i) {
                Composite cur = this.composite[i];
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
        int n = this.children.length;
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
    public Picture transform(AffineTransform tr) {
        int n = this.children.length;
        Picture[] transformed = new Picture[n];
        for (int i = 0; i < n; ++i) {
            transformed[i] = this.children[i].transform(tr);
        }
        return WithComposite.make(transformed, this.composite);
    }

    @Override
    public void visit(PictureVisitor visitor) {
        visitor.visitWithComposite(this);
    }

    static {
        namedComposites.put("clear", AlphaComposite.Clear);
        namedComposites.put("dstover", AlphaComposite.DstOver);
        namedComposites.put("src", AlphaComposite.Src);
        namedComposites.put("srcover", AlphaComposite.SrcOver);
    }
}

