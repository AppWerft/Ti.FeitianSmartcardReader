package gnu.kawa.models;

import gnu.kawa.io.Path;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;

public class DrawImage extends Model implements Picture, java.io.Serializable, RenderedImage
{
  BufferedImage image;
  Path src;
  String description;
  
  public DrawImage() {}
  
  public void makeView(Display display, Object where)
  {
    display.addImage(this, where);
  }
  
  RenderedImage loadImage()
  {
    if (image == null)
    {
      try
      {
        image = javax.imageio.ImageIO.read(src.openInputStream());
      }
      catch (Exception ex)
      {
        throw gnu.mapping.WrappedException.wrapIfNeeded(ex);
      }
    }
    return image;
  }
  
  public DrawImage(BufferedImage image)
  {
    this.image = image;
  }
  
  public void paint(Graphics2D graphics)
  {
    loadImage();
    
    graphics.drawRenderedImage(this, WithTransform.identityTransform);
  }
  
  public java.awt.geom.Rectangle2D getBounds2D()
  {
    loadImage();
    int w = image.getWidth();
    int h = image.getHeight();
    return new java.awt.geom.Rectangle2D.Float(0.0F, 0.0F, w, h);
  }
  
  public Picture transform(AffineTransform tr)
  {
    return new WithTransform(this, tr);
  }
  
  public BufferedImage getImage()
  {
    loadImage();
    return image;
  }
  
  public Path getSrc() { return src; }
  
  public void setSrc(Path src)
  {
    this.src = src;
  }
  
  public WritableRaster copyData(WritableRaster raster)
  {
    return getImage().copyData(raster);
  }
  
  public java.awt.image.ColorModel getColorModel() {
    return getImage().getColorModel();
  }
  
  public Raster getData() {
    return getImage().getData();
  }
  
  public Raster getData(Rectangle rect) {
    return getImage().getData(rect);
  }
  
  public int getHeight() {
    return getImage().getHeight();
  }
  
  public int getMinTileX() {
    return getImage().getMinTileX();
  }
  
  public int getMinTileY() {
    return getImage().getMinTileX();
  }
  
  public int getMinX() {
    return getImage().getMinX();
  }
  
  public int getMinY() {
    return getImage().getMinY();
  }
  
  public int getNumXTiles() {
    return getImage().getNumXTiles();
  }
  
  public int getNumYTiles() {
    return getImage().getNumYTiles();
  }
  
  public Raster getTile(int tileX, int tileY) {
    return getImage().getTile(tileX, tileY);
  }
  
  public int getTileGridXOffset() {
    return getImage().getTileGridXOffset();
  }
  
  public int getTileGridYOffset() {
    return getImage().getTileGridYOffset();
  }
  
  public int getTileHeight() {
    return getImage().getTileHeight();
  }
  
  public int getTileWidth() {
    return getImage().getTileWidth();
  }
  
  public java.awt.image.SampleModel getSampleModel() {
    return getImage().getSampleModel();
  }
  
  public int getWidth() {
    return getImage().getWidth();
  }
  
  public java.util.Vector<RenderedImage> getSources() {
    return getImage().getSources();
  }
  
  public Object getProperty(String name) {
    if (src != null) {
      if ("SRC_LINK".equals(name)) {
        System.err.println("request src_link for " + this + " src:" + src);
        return src.toString();
      }
      if ("SRC_PATH".equals(name))
        return src;
    }
    return getImage().getProperty(name);
  }
  
  public String[] getPropertyNames() {
    String[] names = getImage().getPropertyNames();
    if (src != null) {
      int nlen = names == null ? 0 : names.length;
      String[] tmp = new String[nlen + 2];
      tmp[0] = "SRC_LINK";
      tmp[1] = "SRC_PATH";
      if (nlen > 0)
        System.arraycopy(names, 0, src, 2, nlen);
      names = tmp;
    }
    return names;
  }
  
  public void visit(PictureVisitor visitor) { visitor.visitDrawImage(this); }
  

  public static Picture toPictureOrNull(Object value)
  {
    if ((value instanceof Shape))
      return new DrawShape((Shape)value);
    if ((value instanceof BufferedImage))
      return new DrawImage((BufferedImage)value);
    if ((value instanceof Picture)) {
      return (Picture)value;
    }
    return null;
  }
}
