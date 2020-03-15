// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.models;

import java.awt.AlphaComposite;
import java.awt.Composite;
import javax.xml.bind.DatatypeConverter;
import java.io.OutputStream;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import gnu.kawa.io.Path;
import java.awt.BasicStroke;
import java.awt.Color;
import gnu.xml.XName;
import gnu.xml.NamespaceBinding;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.Shape;
import gnu.mapping.Symbol;
import java.awt.Stroke;
import java.awt.Paint;
import gnu.lists.Consumer;

public class PictureToSvg extends PictureVisitor
{
    Consumer out;
    Paint paint;
    Stroke stroke;
    int strokePropertiesSet;
    public static final String SVG_NAMESPACE_URI = "http://www.w3.org/2000/svg";
    public static final String XLINK_NAMESPACE_URI = "http://www.w3.org/1999/xlink";
    
    public PictureToSvg(final Consumer out) {
        this.paint = StandardColor.black;
        this.out = out;
    }
    
    public static Symbol svgTag(final String name) {
        return Symbol.make("http://www.w3.org/2000/svg", name, "");
    }
    
    public static Symbol xlinkTag(final String name) {
        return Symbol.make("http://www.w3.org/1999/xlink", name, "xlink");
    }
    
    public static void writeAttribute(final String name, final String value, final Consumer out) {
        out.startAttribute(Symbol.valueOf(name));
        out.write(value);
        out.endAttribute();
    }
    
    public static void writeAttribute(final String name, final double value, final Consumer out) {
        writeAttribute(name, formatDouble(value), out);
    }
    
    public static String formatDouble(final double value) {
        String str = Double.toString(value);
        final int len = str.length();
        final int dot = str.indexOf(46);
        if (dot >= 0) {
            int j;
            for (j = len; j > dot && (j == dot + 1 || str.charAt(j - 1) == '0'); --j) {}
            str = str.substring(0, j);
        }
        return str;
    }
    
    public static String genShapeToString(final Shape shape) {
        final StringBuilder out = new StringBuilder();
        final PathIterator it = shape.getPathIterator(null);
        final double[] data = new double[6];
        while (!it.isDone()) {
            final int kind = it.currentSegment(data);
            if (out.length() > 0) {
                out.append(' ');
            }
            char code = '\0';
            int ncoords = 0;
            switch (kind) {
                case 0: {
                    code = 'M';
                    ncoords = 2;
                    break;
                }
                case 1: {
                    code = 'L';
                    ncoords = 2;
                    break;
                }
                case 2: {
                    code = 'Q';
                    ncoords = 4;
                    break;
                }
                case 3: {
                    code = 'C';
                    ncoords = 6;
                    break;
                }
                case 4: {
                    code = 'Z';
                    ncoords = 0;
                    break;
                }
            }
            out.append(code);
            for (int j = 0; j < ncoords; ++j) {
                if (j > 0) {
                    out.append(',');
                }
                out.append(data[j]);
            }
            it.next();
        }
        return out.toString();
    }
    
    public static void writeShapeStart(final Shape shape, final Consumer out) {
        if (shape instanceof Line2D) {
            final Line2D s = (Line2D)shape;
            out.startElement(svgTag("line"));
            writeAttribute("x1", s.getX1(), out);
            writeAttribute("y1", s.getY1(), out);
            writeAttribute("x2", s.getX2(), out);
            writeAttribute("y2", s.getY2(), out);
        }
        else if (shape instanceof Rectangle2D) {
            final Rectangle2D s2 = (Rectangle2D)shape;
            out.startElement(svgTag("rect"));
            writeAttribute("x", s2.getX(), out);
            writeAttribute("y", s2.getY(), out);
            writeAttribute("width", s2.getWidth(), out);
            writeAttribute("height", s2.getHeight(), out);
        }
        else if (shape instanceof RoundRectangle2D) {
            final RoundRectangle2D s3 = (RoundRectangle2D)shape;
            out.startElement(svgTag("rect"));
            writeAttribute("x", s3.getX(), out);
            writeAttribute("y", s3.getY(), out);
            writeAttribute("width", s3.getWidth(), out);
            writeAttribute("height", s3.getHeight(), out);
            writeAttribute("rx", s3.getArcHeight() / 2.0, out);
        }
        else if (shape instanceof Ellipse2D) {
            final Ellipse2D s4 = (Ellipse2D)shape;
            final double w = s4.getWidth();
            final double h = s4.getHeight();
            final boolean circle = w == h;
            out.startElement(svgTag(circle ? "circle" : "ellipse"));
            writeAttribute("cx", s4.getCenterX(), out);
            writeAttribute("cy", s4.getCenterY(), out);
            if (circle) {
                writeAttribute("r", w / 2.0, out);
            }
            else {
                writeAttribute("rx", w / 2.0, out);
                writeAttribute("ry", h / 2.0, out);
            }
        }
        else {
            out.startElement(svgTag("path"));
            writeAttribute("d", genShapeToString(shape), out);
        }
    }
    
    public static void writeDrawSimple(final Shape shape, final Consumer out) {
        writeShapeStart(shape, out);
        writeAttribute("stroke", "black", out);
        writeAttribute("fill", "none", out);
        out.endElement();
    }
    
    public static void writeFillSimple(final Shape shape, final Consumer out) {
        writeShapeStart(shape, out);
        writeAttribute("stroke", "none", out);
        writeAttribute("fill", "black", out);
        out.endElement();
    }
    
    public static void writeSVGElementStart(final Rectangle2D bounds, final Consumer out) {
        final NamespaceBinding namespaces = new NamespaceBinding(null, "http://www.w3.org/2000/svg", new NamespaceBinding("xlink", "http://www.w3.org/1999/xlink", NamespaceBinding.predefinedXML));
        out.startElement(new XName(svgTag("svg"), namespaces));
        writeAttribute("version", "1.2", out);
        final double x = bounds.getX();
        final double y = bounds.getY();
        final double w = bounds.getWidth();
        final double h = bounds.getHeight();
        writeAttribute("width", w + "px", out);
        writeAttribute("height", h + "px", out);
        writeAttribute("viewBox", x + " " + y + " " + w + " " + h, out);
    }
    
    private void writePaint(final Paint p, final boolean filling) {
        if (p instanceof Color) {
            String cname;
            if (p instanceof StandardColor) {
                cname = ((StandardColor)p).getName().replace("-", "");
            }
            else {
                final Color color = (Color)p;
                final int r = color.getRed();
                final int g = color.getGreen();
                final int b = color.getBlue();
                final int alpha = color.getAlpha();
                cname = "#" + Character.forDigit(r >> 4, 16) + Character.forDigit(r & 0xF, 16) + Character.forDigit(g >> 4, 16) + Character.forDigit(g & 0xF, 16) + Character.forDigit(b >> 4, 16) + Character.forDigit(b & 0xF, 16);
                if (alpha < 255) {
                    writeAttribute(filling ? "fill-opacity" : "stroke-opacity", alpha / 255.0, this.out);
                }
            }
            writeAttribute(filling ? "fill" : "stroke", cname, this.out);
        }
        else {
            writeAttribute(filling ? "fill" : "stroke", "black", this.out);
        }
        writeAttribute(filling ? "stroke" : "fill", "none", this.out);
    }
    
    private void writeStroke(final Stroke stroke, final int propertiesSet) {
        if (stroke instanceof BasicStroke) {
            final BasicStroke bstroke = (BasicStroke)stroke;
            if ((propertiesSet & 0x1) != 0x0) {
                writeAttribute("stroke-width", bstroke.getLineWidth(), this.out);
            }
            if ((propertiesSet & 0x2) != 0x0) {
                String str = "error-value";
                switch (bstroke.getEndCap()) {
                    case 0: {
                        str = "butt";
                        break;
                    }
                    case 1: {
                        str = "round";
                        break;
                    }
                    case 2: {
                        str = "square";
                        break;
                    }
                }
                writeAttribute("stroke-linecap", str, this.out);
            }
            if ((propertiesSet & 0x4) != 0x0) {
                String str = "error-value";
                switch (bstroke.getLineJoin()) {
                    case 0: {
                        str = "miter";
                        break;
                    }
                    case 1: {
                        str = "round";
                        break;
                    }
                    case 2: {
                        str = "bevel";
                        break;
                    }
                }
                writeAttribute("stroke-linejoin", str, this.out);
            }
            if ((propertiesSet & 0x8) != 0x0) {
                writeAttribute("stroke-miterlimit", bstroke.getMiterLimit(), this.out);
            }
        }
    }
    
    @Override
    public void visitFillShape(final FillShape pic) {
        if (this.paint == StandardColor.transparent) {
            return;
        }
        writeShapeStart(pic.shape, this.out);
        this.writePaint(this.paint, true);
        this.out.endElement();
    }
    
    @Override
    public void visitDrawShape(final DrawShape pic) {
        if (this.paint == StandardColor.transparent) {
            return;
        }
        writeShapeStart(pic.shape, this.out);
        this.writePaint(this.paint, false);
        this.writeStroke(this.stroke, this.strokePropertiesSet);
        this.out.endElement();
    }
    
    @Override
    public void visitWithPaint(final WithPaint pic) {
        final Paint savePaint = this.paint;
        final Stroke saveStroke = this.stroke;
        final int savePropertiesSet = this.strokePropertiesSet;
        if (pic.paint != null) {
            this.paint = pic.paint;
        }
        Stroke nstroke = pic.stroke;
        if (nstroke != null) {
            this.strokePropertiesSet |= pic.propertiesSet;
            if (saveStroke instanceof BasicStroke && nstroke instanceof BasicStroke && (pic.propertiesSet & 0x3F) != 0x3F) {
                nstroke = WithPaint.merge((BasicStroke)nstroke, pic.propertiesSet, (BasicStroke)saveStroke);
            }
            this.stroke = nstroke;
        }
        super.visitWithPaint(pic);
        this.paint = savePaint;
        this.stroke = saveStroke;
        this.strokePropertiesSet = savePropertiesSet;
    }
    
    @Override
    public void visitDrawImage(final DrawImage image) {
        this.out.startElement(svgTag("image"));
        writeAttribute("width", image.getWidth(), this.out);
        writeAttribute("height", image.getHeight(), this.out);
        final Path src = image.src;
        final String srcstr = (src == null) ? null : src.toString();
        if (src != null && Path.uriSchemeSpecified(srcstr)) {
            this.out.startAttribute(xlinkTag("href"));
            this.out.write(srcstr);
            this.out.endAttribute();
        }
        else {
            try {
                final ByteArrayOutputStream bout = new ByteArrayOutputStream();
                ImageIO.write(image, "png", bout);
                final byte[] imgbytes = bout.toByteArray();
                final String b64 = DatatypeConverter.printBase64Binary(imgbytes);
                this.out.startAttribute(xlinkTag("href"));
                this.out.write("data:image/png;base64,");
                this.out.write(b64);
                this.out.endAttribute();
            }
            catch (Throwable t) {}
        }
        this.out.endElement();
    }
    
    @Override
    public void visitPBox(final PBox pic) {
        final int n = pic.children.length;
        final AffineTransform tr = (n <= 1 || pic.axis == 'Z') ? null : new AffineTransform();
        for (int i = 0; i < n; ++i) {
            final Picture child = pic.children[i];
            final double offset = pic.translations[i];
            if (i > 0 && pic.axis != 'Z') {
                if (pic.axis == 'X') {
                    tr.setToTranslation(offset, 0.0);
                }
                else {
                    tr.setToTranslation(0.0, offset);
                }
                this.visitWithTransform(child, tr);
            }
            else {
                child.visit(this);
            }
        }
    }
    
    public static String transformAttribute(final AffineTransform tr) {
        final double m00 = tr.getScaleX();
        final double m2 = tr.getShearY();
        final double m3 = tr.getShearX();
        final double m4 = tr.getScaleY();
        final double m5 = tr.getTranslateX();
        final double m6 = tr.getTranslateY();
        return String.format("matrix(%g %g %g %g %g %g)", m00, m2, m3, m4, m5, m6);
    }
    
    @Override
    public void visitWithTransform(final WithTransform pic) {
        this.visitWithTransform(pic.picture, pic.transform);
    }
    
    public void visitWithTransform(final Picture pic, final AffineTransform tr) {
        this.out.startElement(svgTag("g"));
        writeAttribute("transform", transformAttribute(tr), this.out);
        pic.visit(this);
        this.out.endElement();
    }
    
    void writeCompOp(final Composite comp) {
        String op = null;
        if (comp == AlphaComposite.Clear) {
            op = "clear";
        }
        else if (comp == AlphaComposite.DstOver) {
            op = "dst-over";
        }
        else if (comp == AlphaComposite.Src) {
            op = "src";
        }
        else if (comp == AlphaComposite.SrcOver) {
            op = "src-over";
        }
        if (op != null) {
            writeAttribute("comp-op", op, this.out);
        }
    }
    
    @Override
    public void visitWithComposite(final WithComposite pic) {
        this.out.startElement(svgTag("g"));
        Composite op = pic.singleOp();
        final int n = pic.children.length;
        if (n != 0) {
            if (op != null) {
                this.writeCompOp(op);
                for (int i = 0; i < n; ++i) {
                    pic.children[i].visit(this);
                }
            }
            else {
                Composite prev = null;
                for (int j = 0; j < n; ++j) {
                    op = pic.composite[j];
                    if (op != null && op != prev) {
                        if (prev != null) {
                            this.out.endElement();
                        }
                        this.out.startElement(svgTag("g"));
                        this.writeCompOp(op);
                        prev = op;
                    }
                    pic.children[j].visit(this);
                }
                if (prev != null) {
                    this.out.endElement();
                }
            }
        }
        this.out.endElement();
    }
}
