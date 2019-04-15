package gnu.kawa.models;

import gnu.lists.Consumer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class PictureToSvg extends PictureVisitor
{
  Consumer out;
  java.awt.Paint paint = StandardColor.black;
  
  java.awt.Stroke stroke;
  
  int strokePropertiesSet;
  public static final String SVG_NAMESPACE_URI = "http://www.w3.org/2000/svg";
  public static final String XLINK_NAMESPACE_URI = "http://www.w3.org/1999/xlink";
  
  public PictureToSvg(Consumer out)
  {
    this.out = out;
  }
  
  public static gnu.mapping.Symbol svgTag(String name) {
    return gnu.mapping.Symbol.make("http://www.w3.org/2000/svg", name, "");
  }
  
  public static gnu.mapping.Symbol xlinkTag(String name) { return gnu.mapping.Symbol.make("http://www.w3.org/1999/xlink", name, "xlink"); }
  
  public static void writeAttribute(String name, String value, Consumer out) {
    out.startAttribute(gnu.mapping.Symbol.valueOf(name));
    out.write(value);
    out.endAttribute();
  }
  
  public static void writeAttribute(String name, double value, Consumer out) { writeAttribute(name, formatDouble(value), out); }
  
  public static String formatDouble(double value) {
    String str = Double.toString(value);
    int len = str.length();
    int dot = str.indexOf('.');
    if (dot >= 0) {
      int j = len;
      while ((j > dot) && ((j == dot + 1) || (str.charAt(j - 1) == '0')))
        j--;
      str = str.substring(0, j);
    }
    return str;
  }
  
  public static String genShapeToString(Shape shape) { StringBuilder out = new StringBuilder();
    java.awt.geom.PathIterator it = shape.getPathIterator(null);
    double[] data = new double[6];
    while (!it.isDone()) {
      int kind = it.currentSegment(data);
      if (out.length() > 0)
        out.append(' ');
      char code = '\000';
      int ncoords = 0;
      switch (kind) {
      case 0:  code = 'M';ncoords = 2; break;
      case 1:  code = 'L';ncoords = 2; break;
      case 2:  code = 'Q';ncoords = 4; break;
      case 3:  code = 'C';ncoords = 6; break;
      case 4:  code = 'Z';ncoords = 0;
      }
      out.append(code);
      for (int j = 0; j < ncoords; j++) {
        if (j > 0)
          out.append(',');
        out.append(data[j]);
      }
      it.next();
    }
    return out.toString();
  }
  
  public static void writeShapeStart(Shape shape, Consumer out) {
    if ((shape instanceof Line2D)) {
      Line2D s = (Line2D)shape;
      out.startElement(svgTag("line"));
      writeAttribute("x1", s.getX1(), out);
      writeAttribute("y1", s.getY1(), out);
      writeAttribute("x2", s.getX2(), out);
      writeAttribute("y2", s.getY2(), out);
    } else if ((shape instanceof Rectangle2D)) {
      Rectangle2D s = (Rectangle2D)shape;
      out.startElement(svgTag("rect"));
      writeAttribute("x", s.getX(), out);
      writeAttribute("y", s.getY(), out);
      writeAttribute("width", s.getWidth(), out);
      writeAttribute("height", s.getHeight(), out);
    } else if ((shape instanceof RoundRectangle2D)) {
      RoundRectangle2D s = (RoundRectangle2D)shape;
      out.startElement(svgTag("rect"));
      writeAttribute("x", s.getX(), out);
      writeAttribute("y", s.getY(), out);
      writeAttribute("width", s.getWidth(), out);
      writeAttribute("height", s.getHeight(), out);
      writeAttribute("rx", s.getArcHeight() / 2.0D, out);
    } else if ((shape instanceof Ellipse2D)) {
      Ellipse2D s = (Ellipse2D)shape;
      double w = s.getWidth();
      double h = s.getHeight();
      boolean circle = w == h;
      out.startElement(svgTag(circle ? "circle" : "ellipse"));
      writeAttribute("cx", s.getCenterX(), out);
      writeAttribute("cy", s.getCenterY(), out);
      if (circle) {
        writeAttribute("r", w / 2.0D, out);
      } else {
        writeAttribute("rx", w / 2.0D, out);
        writeAttribute("ry", h / 2.0D, out);
      }
    } else {
      out.startElement(svgTag("path"));
      writeAttribute("d", genShapeToString(shape), out);
    }
  }
  
  public static void writeDrawSimple(Shape shape, Consumer out) { writeShapeStart(shape, out);
    writeAttribute("stroke", "black", out);
    writeAttribute("fill", "none", out);
    out.endElement();
  }
  
  public static void writeFillSimple(Shape shape, Consumer out) { writeShapeStart(shape, out);
    writeAttribute("stroke", "none", out);
    writeAttribute("fill", "black", out);
    out.endElement();
  }
  
  public static void writeSVGElementStart(Rectangle2D bounds, Consumer out) { gnu.xml.NamespaceBinding namespaces = new gnu.xml.NamespaceBinding(null, "http://www.w3.org/2000/svg", new gnu.xml.NamespaceBinding("xlink", "http://www.w3.org/1999/xlink", gnu.xml.NamespaceBinding.predefinedXML));
    


    out.startElement(new gnu.xml.XName(svgTag("svg"), namespaces));
    writeAttribute("version", "1.2", out);
    double x = bounds.getX();
    double y = bounds.getY();
    double w = bounds.getWidth();
    double h = bounds.getHeight();
    writeAttribute("width", w + "px", out);
    writeAttribute("height", h + "px", out);
    writeAttribute("viewBox", x + " " + y + " " + w + " " + h, out);
  }
  
  private void writePaint(java.awt.Paint p, boolean filling) {
    if ((p instanceof Color)) { String cname;
      String cname;
      if ((p instanceof StandardColor)) {
        cname = ((StandardColor)p).getName().replace("-", "");
      } else {
        Color color = (Color)p;
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        int alpha = color.getAlpha();
        
        cname = "#" + Character.forDigit(r >> 4, 16) + Character.forDigit(r & 0xF, 16) + Character.forDigit(g >> 4, 16) + Character.forDigit(g & 0xF, 16) + Character.forDigit(b >> 4, 16) + Character.forDigit(b & 0xF, 16);
        


        if (alpha < 255) {
          writeAttribute(filling ? "fill-opacity" : "stroke-opacity", alpha / 255.0D, out);
        }
      }
      
      writeAttribute(filling ? "fill" : "stroke", cname, out);
    }
    else {
      writeAttribute(filling ? "fill" : "stroke", "black", out);
    }
    writeAttribute(filling ? "stroke" : "fill", "none", out);
  }
  
  private void writeStroke(java.awt.Stroke stroke, int propertiesSet) {
    if ((stroke instanceof BasicStroke)) {
      BasicStroke bstroke = (BasicStroke)stroke;
      if ((propertiesSet & 0x1) != 0)
        writeAttribute("stroke-width", bstroke.getLineWidth(), out);
      if ((propertiesSet & 0x2) != 0) {
        String str = "error-value";
        switch (bstroke.getEndCap()) {
        case 0:  str = "butt"; break;
        case 1:  str = "round"; break;
        case 2:  str = "square";
        }
        writeAttribute("stroke-linecap", str, out);
      }
      if ((propertiesSet & 0x4) != 0) {
        String str = "error-value";
        switch (bstroke.getLineJoin()) {
        case 0:  str = "miter"; break;
        case 1:  str = "round"; break;
        case 2:  str = "bevel";
        }
        writeAttribute("stroke-linejoin", str, out);
      }
      if ((propertiesSet & 0x8) != 0) {
        writeAttribute("stroke-miterlimit", bstroke.getMiterLimit(), out);
      }
    }
  }
  
  public void visitFillShape(FillShape pic) {
    if (paint == StandardColor.transparent)
      return;
    writeShapeStart(shape, out);
    writePaint(paint, true);
    out.endElement();
  }
  
  public void visitDrawShape(DrawShape pic) {
    if (paint == StandardColor.transparent)
      return;
    writeShapeStart(shape, out);
    writePaint(paint, false);
    writeStroke(stroke, strokePropertiesSet);
    out.endElement();
  }
  
  public void visitWithPaint(WithPaint pic) {
    java.awt.Paint savePaint = paint;
    java.awt.Stroke saveStroke = stroke;
    int savePropertiesSet = strokePropertiesSet;
    if (paint != null)
      paint = paint;
    java.awt.Stroke nstroke = stroke;
    if (nstroke != null) {
      strokePropertiesSet |= propertiesSet;
      if (((saveStroke instanceof BasicStroke)) && ((nstroke instanceof BasicStroke)) && ((propertiesSet & 0x3F) != 63))
      {

        nstroke = WithPaint.merge((BasicStroke)nstroke, propertiesSet, (BasicStroke)saveStroke);
      }
      stroke = nstroke;
    }
    super.visitWithPaint(pic);
    paint = savePaint;
    stroke = saveStroke;
    strokePropertiesSet = savePropertiesSet;
  }
  
  public void visitDrawImage(DrawImage image) {
    out.startElement(svgTag("image"));
    writeAttribute("width", image.getWidth(), out);
    writeAttribute("height", image.getHeight(), out);
    gnu.kawa.io.Path src = src;
    String srcstr = src == null ? null : src.toString();
    if ((src != null) && (gnu.kawa.io.Path.uriSchemeSpecified(srcstr))) {
      out.startAttribute(xlinkTag("href"));
      out.write(srcstr);
      out.endAttribute();
    } else {
      try {
        java.io.ByteArrayOutputStream bout = new java.io.ByteArrayOutputStream();
        javax.imageio.ImageIO.write(image, "png", bout);
        byte[] imgbytes = bout.toByteArray();
        



        String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imgbytes);
        

        out.startAttribute(xlinkTag("href"));
        out.write("data:image/png;base64,");
        out.write(b64);
        out.endAttribute();
      }
      catch (Throwable ex) {}
    }
    
    out.endElement();
  }
  
  public void visitPBox(PBox pic) { int n = children.length;
    AffineTransform tr = (n <= 1) || (axis == 'Z') ? null : new AffineTransform();
    
    for (int i = 0; i < n; i++) {
      Picture child = children[i];
      double offset = translations[i];
      if ((i > 0) && (axis != 'Z')) {
        if (axis == 'X') {
          tr.setToTranslation(offset, 0.0D);
        } else
          tr.setToTranslation(0.0D, offset);
        visitWithTransform(child, tr);
      }
      else {
        child.visit(this);
      }
    }
  }
  
  public static String transformAttribute(AffineTransform tr) { double m00 = tr.getScaleX();
    double m10 = tr.getShearY();
    double m01 = tr.getShearX();
    double m11 = tr.getScaleY();
    double m02 = tr.getTranslateX();
    double m12 = tr.getTranslateY();
    return String.format("matrix(%g %g %g %g %g %g)", new Object[] { Double.valueOf(m00), Double.valueOf(m10), Double.valueOf(m01), Double.valueOf(m11), Double.valueOf(m02), Double.valueOf(m12) });
  }
  


  public void visitWithTransform(WithTransform pic) { visitWithTransform(picture, transform); }
  
  public void visitWithTransform(Picture pic, AffineTransform tr) {
    out.startElement(svgTag("g"));
    writeAttribute("transform", transformAttribute(tr), out);
    pic.visit(this);
    out.endElement();
  }
  
  void writeCompOp(java.awt.Composite comp) { String op = null;
    if (comp == java.awt.AlphaComposite.Clear) {
      op = "clear";
    } else if (comp == java.awt.AlphaComposite.DstOver) {
      op = "dst-over";
    } else if (comp == java.awt.AlphaComposite.Src) {
      op = "src";
    } else if (comp == java.awt.AlphaComposite.SrcOver) {
      op = "src-over";
    }
    if (op != null) {
      writeAttribute("comp-op", op, out);
    }
  }
  
  public void visitWithComposite(WithComposite pic) {
    out.startElement(svgTag("g"));
    java.awt.Composite op = pic.singleOp();
    int n = children.length;
    if (n != 0)
      if (op != null) {
        writeCompOp(op);
        for (int i = 0; i < n; i++) {
          children[i].visit(this);
        }
      } else {
        java.awt.Composite prev = null;
        for (int i = 0; i < n; i++) {
          op = composite[i];
          if ((op != null) && (op != prev)) {
            if (prev != null)
              out.endElement();
            out.startElement(svgTag("g"));
            writeCompOp(op);
            prev = op;
          }
          children[i].visit(this);
        }
        if (prev != null)
          out.endElement();
      }
    out.endElement();
  }
}
