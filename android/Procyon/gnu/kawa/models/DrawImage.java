// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.Shape;
import java.util.Vector;
import java.awt.image.SampleModel;
import java.awt.Rectangle;
import java.awt.image.Raster;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import gnu.mapping.WrappedException;
import javax.imageio.ImageIO;
import gnu.kawa.io.Path;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.Serializable;

public class DrawImage extends Model implements Picture, Serializable, RenderedImage
{
    BufferedImage image;
    Path src;
    String description;
    
    public DrawImage() {
    }
    
    @Override
    public void makeView(final Display display, final Object where) {
        display.addImage(this, where);
    }
    
    RenderedImage loadImage() {
        if (this.image == null) {
            try {
                this.image = ImageIO.read(this.src.openInputStream());
            }
            catch (Exception ex) {
                throw WrappedException.wrapIfNeeded(ex);
            }
        }
        return this.image;
    }
    
    public DrawImage(final BufferedImage image) {
        this.image = image;
    }
    
    @Override
    public void paint(final Graphics2D graphics) {
        this.loadImage();
        graphics.drawRenderedImage(this, WithTransform.identityTransform);
    }
    
    @Override
    public Rectangle2D getBounds2D() {
        this.loadImage();
        final int w = this.image.getWidth();
        final int h = this.image.getHeight();
        return new Rectangle2D.Float(0.0f, 0.0f, (float)w, (float)h);
    }
    
    @Override
    public Picture transform(final AffineTransform tr) {
        return new WithTransform(this, tr);
    }
    
    public BufferedImage getImage() {
        this.loadImage();
        return this.image;
    }
    
    public Path getSrc() {
        return this.src;
    }
    
    public void setSrc(final Path src) {
        this.src = src;
    }
    
    @Override
    public WritableRaster copyData(final WritableRaster raster) {
        return this.getImage().copyData(raster);
    }
    
    @Override
    public ColorModel getColorModel() {
        return this.getImage().getColorModel();
    }
    
    @Override
    public Raster getData() {
        return this.getImage().getData();
    }
    
    @Override
    public Raster getData(final Rectangle rect) {
        return this.getImage().getData(rect);
    }
    
    @Override
    public int getHeight() {
        return this.getImage().getHeight();
    }
    
    @Override
    public int getMinTileX() {
        return this.getImage().getMinTileX();
    }
    
    @Override
    public int getMinTileY() {
        return this.getImage().getMinTileX();
    }
    
    @Override
    public int getMinX() {
        return this.getImage().getMinX();
    }
    
    @Override
    public int getMinY() {
        return this.getImage().getMinY();
    }
    
    @Override
    public int getNumXTiles() {
        return this.getImage().getNumXTiles();
    }
    
    @Override
    public int getNumYTiles() {
        return this.getImage().getNumYTiles();
    }
    
    @Override
    public Raster getTile(final int tileX, final int tileY) {
        return this.getImage().getTile(tileX, tileY);
    }
    
    @Override
    public int getTileGridXOffset() {
        return this.getImage().getTileGridXOffset();
    }
    
    @Override
    public int getTileGridYOffset() {
        return this.getImage().getTileGridYOffset();
    }
    
    @Override
    public int getTileHeight() {
        return this.getImage().getTileHeight();
    }
    
    @Override
    public int getTileWidth() {
        return this.getImage().getTileWidth();
    }
    
    @Override
    public SampleModel getSampleModel() {
        return this.getImage().getSampleModel();
    }
    
    @Override
    public int getWidth() {
        return this.getImage().getWidth();
    }
    
    @Override
    public Vector<RenderedImage> getSources() {
        return this.getImage().getSources();
    }
    
    @Override
    public Object getProperty(final String name) {
        if (this.src != null) {
            if ("SRC_LINK".equals(name)) {
                System.err.println("request src_link for " + this + " src:" + this.src);
                return this.src.toString();
            }
            if ("SRC_PATH".equals(name)) {
                return this.src;
            }
        }
        return this.getImage().getProperty(name);
    }
    
    @Override
    public String[] getPropertyNames() {
        String[] names = this.getImage().getPropertyNames();
        if (this.src != null) {
            final int nlen = (names == null) ? 0 : names.length;
            final String[] tmp = new String[nlen + 2];
            tmp[0] = "SRC_LINK";
            tmp[1] = "SRC_PATH";
            if (nlen > 0) {
                System.arraycopy(names, 0, this.src, 2, nlen);
            }
            names = tmp;
        }
        return names;
    }
    
    @Override
    public void visit(final PictureVisitor visitor) {
        visitor.visitDrawImage(this);
    }
    
    public static Picture toPictureOrNull(final Object value) {
        if (value instanceof Shape) {
            return new DrawShape((Shape)value);
        }
        if (value instanceof BufferedImage) {
            return new DrawImage((BufferedImage)value);
        }
        if (value instanceof Picture) {
            return (Picture)value;
        }
        return null;
    }
}
