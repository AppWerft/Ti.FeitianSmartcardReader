/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.models;

import gnu.kawa.io.Path;
import gnu.kawa.models.DrawImage;
import gnu.kawa.models.DrawShape;
import gnu.kawa.models.FillShape;
import gnu.kawa.models.PBox;
import gnu.kawa.models.Picture;
import gnu.kawa.models.PictureVisitor;
import gnu.kawa.models.StandardColor;
import gnu.kawa.models.WithComposite;
import gnu.kawa.models.WithPaint;
import gnu.kawa.models.WithTransform;
import gnu.lists.Consumer;
import gnu.mapping.Symbol;
import gnu.xml.NamespaceBinding;
import gnu.xml.XName;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

public class PictureToSvg
extends PictureVisitor {
    Consumer out;
    Paint paint = StandardColor.black;
    Stroke stroke;
    int strokePropertiesSet;
    public static final String SVG_NAMESPACE_URI = "http://www.w3.org/2000/svg";
    public static final String XLINK_NAMESPACE_URI = "http://www.w3.org/1999/xlink";

    public PictureToSvg(Consumer out) {
        this.out = out;
    }

    public static Symbol svgTag(String name) {
        return Symbol.make(SVG_NAMESPACE_URI, name, "");
    }

    public static Symbol xlinkTag(String name) {
        return Symbol.make(XLINK_NAMESPACE_URI, name, "xlink");
    }

    public static void writeAttribute(String name, String value, Consumer out) {
        out.startAttribute(Symbol.valueOf(name));
        out.write(value);
        out.endAttribute();
    }

    public static void writeAttribute(String name, double value, Consumer out) {
        PictureToSvg.writeAttribute(name, PictureToSvg.formatDouble(value), out);
    }

    public static String formatDouble(double value) {
        String str = Double.toString(value);
        int len = str.length();
        int dot = str.indexOf(46);
        if (dot >= 0) {
            int j;
            for (j = len; j > dot && (j == dot + 1 || str.charAt(j - 1) == '0'); --j) {
            }
            str = str.substring(0, j);
        }
        return str;
    }

    public static String genShapeToString(Shape shape) {
        StringBuilder out = new StringBuilder();
        PathIterator it = shape.getPathIterator(null);
        double[] data = new double[6];
        while (!it.isDone()) {
            int kind = it.currentSegment(data);
            if (out.length() > 0) {
                out.append(' ');
            }
            char code = '\u0000';
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

    public static void writeShapeStart(Shape shape, Consumer out) {
        if (shape instanceof Line2D) {
            Line2D s = (Line2D)shape;
            out.startElement(PictureToSvg.svgTag("line"));
            PictureToSvg.writeAttribute("x1", s.getX1(), out);
            PictureToSvg.writeAttribute("y1", s.getY1(), out);
            PictureToSvg.writeAttribute("x2", s.getX2(), out);
            PictureToSvg.writeAttribute("y2", s.getY2(), out);
        } else if (shape instanceof Rectangle2D) {
            Rectangle2D s = (Rectangle2D)shape;
            out.startElement(PictureToSvg.svgTag("rect"));
            PictureToSvg.writeAttribute("x", s.getX(), out);
            PictureToSvg.writeAttribute("y", s.getY(), out);
            PictureToSvg.writeAttribute("width", s.getWidth(), out);
            PictureToSvg.writeAttribute("height", s.getHeight(), out);
        } else if (shape instanceof RoundRectangle2D) {
            RoundRectangle2D s = (RoundRectangle2D)shape;
            out.startElement(PictureToSvg.svgTag("rect"));
            PictureToSvg.writeAttribute("x", s.getX(), out);
            PictureToSvg.writeAttribute("y", s.getY(), out);
            PictureToSvg.writeAttribute("width", s.getWidth(), out);
            PictureToSvg.writeAttribute("height", s.getHeight(), out);
            PictureToSvg.writeAttribute("rx", s.getArcHeight() / 2.0, out);
        } else if (shape instanceof Ellipse2D) {
            double h;
            Ellipse2D s = (Ellipse2D)shape;
            double w = s.getWidth();
            boolean circle = w == (h = s.getHeight());
            out.startElement(PictureToSvg.svgTag(circle ? "circle" : "ellipse"));
            PictureToSvg.writeAttribute("cx", s.getCenterX(), out);
            PictureToSvg.writeAttribute("cy", s.getCenterY(), out);
            if (circle) {
                PictureToSvg.writeAttribute("r", w / 2.0, out);
            } else {
                PictureToSvg.writeAttribute("rx", w / 2.0, out);
                PictureToSvg.writeAttribute("ry", h / 2.0, out);
            }
        } else {
            out.startElement(PictureToSvg.svgTag("path"));
            PictureToSvg.writeAttribute("d", PictureToSvg.genShapeToString(shape), out);
        }
    }

    public static void writeDrawSimple(Shape shape, Consumer out) {
        PictureToSvg.writeShapeStart(shape, out);
        PictureToSvg.writeAttribute("stroke", "black", out);
        PictureToSvg.writeAttribute("fill", "none", out);
        out.endElement();
    }

    public static void writeFillSimple(Shape shape, Consumer out) {
        PictureToSvg.writeShapeStart(shape, out);
        PictureToSvg.writeAttribute("stroke", "none", out);
        PictureToSvg.writeAttribute("fill", "black", out);
        out.endElement();
    }

    public static void writeSVGElementStart(Rectangle2D bounds, Consumer out) {
        NamespaceBinding namespaces = new NamespaceBinding(null, SVG_NAMESPACE_URI, new NamespaceBinding("xlink", XLINK_NAMESPACE_URI, NamespaceBinding.predefinedXML));
        out.startElement(new XName(PictureToSvg.svgTag("svg"), namespaces));
        PictureToSvg.writeAttribute("version", "1.2", out);
        double x = bounds.getX();
        double y = bounds.getY();
        double w = bounds.getWidth();
        double h = bounds.getHeight();
        PictureToSvg.writeAttribute("width", w + "px", out);
        PictureToSvg.writeAttribute("height", h + "px", out);
        PictureToSvg.writeAttribute("viewBox", x + " " + y + " " + w + " " + h, out);
    }

    private void writePaint(Paint p, boolean filling) {
        if (p instanceof Color) {
            String cname;
            if (p instanceof StandardColor) {
                cname = ((StandardColor)p).getName().replace("-", "");
            } else {
                Color color = (Color)p;
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                int alpha = color.getAlpha();
                cname = "#" + Character.forDigit(r >> 4, 16) + Character.forDigit(r & 15, 16) + Character.forDigit(g >> 4, 16) + Character.forDigit(g & 15, 16) + Character.forDigit(b >> 4, 16) + Character.forDigit(b & 15, 16);
                if (alpha < 255) {
                    PictureToSvg.writeAttribute(filling ? "fill-opacity" : "stroke-opacity", (double)alpha / 255.0, this.out);
                }
            }
            PictureToSvg.writeAttribute(filling ? "fill" : "stroke", cname, this.out);
        } else {
            PictureToSvg.writeAttribute(filling ? "fill" : "stroke", "black", this.out);
        }
        PictureToSvg.writeAttribute(filling ? "stroke" : "fill", "none", this.out);
    }

    private void writeStroke(Stroke stroke, int propertiesSet) {
        if (stroke instanceof BasicStroke) {
            String str;
            BasicStroke bstroke = (BasicStroke)stroke;
            if ((propertiesSet & 1) != 0) {
                PictureToSvg.writeAttribute("stroke-width", bstroke.getLineWidth(), this.out);
            }
            if ((propertiesSet & 2) != 0) {
                str = "error-value";
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
                    }
                }
                PictureToSvg.writeAttribute("stroke-linecap", str, this.out);
            }
            if ((propertiesSet & 4) != 0) {
                str = "error-value";
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
                    }
                }
                PictureToSvg.writeAttribute("stroke-linejoin", str, this.out);
            }
            if ((propertiesSet & 8) != 0) {
                PictureToSvg.writeAttribute("stroke-miterlimit", bstroke.getMiterLimit(), this.out);
            }
        }
    }

    @Override
    public void visitFillShape(FillShape pic) {
        if (this.paint == StandardColor.transparent) {
            return;
        }
        PictureToSvg.writeShapeStart(pic.shape, this.out);
        this.writePaint(this.paint, true);
        this.out.endElement();
    }

    @Override
    public void visitDrawShape(DrawShape pic) {
        if (this.paint == StandardColor.transparent) {
            return;
        }
        PictureToSvg.writeShapeStart(pic.shape, this.out);
        this.writePaint(this.paint, false);
        this.writeStroke(this.stroke, this.strokePropertiesSet);
        this.out.endElement();
    }

    @Override
    public void visitWithPaint(WithPaint pic) {
        Stroke nstroke;
        Paint savePaint = this.paint;
        Stroke saveStroke = this.stroke;
        int savePropertiesSet = this.strokePropertiesSet;
        if (pic.paint != null) {
            this.paint = pic.paint;
        }
        if ((nstroke = pic.stroke) != null) {
            this.strokePropertiesSet |= pic.propertiesSet;
            if (saveStroke instanceof BasicStroke && nstroke instanceof BasicStroke && (pic.propertiesSet & 63) != 63) {
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
    public void visitDrawImage(DrawImage image) {
        String srcstr;
        this.out.startElement(PictureToSvg.svgTag("image"));
        PictureToSvg.writeAttribute("width", image.getWidth(), this.out);
        PictureToSvg.writeAttribute("height", image.getHeight(), this.out);
        Path src = image.src;
        String string = srcstr = src == null ? null : src.toString();
        if (src != null && Path.uriSchemeSpecified(srcstr)) {
            this.out.startAttribute(PictureToSvg.xlinkTag("href"));
            this.out.write(srcstr);
            this.out.endAttribute();
        } else {
            try {
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                ImageIO.write((RenderedImage)image, "png", bout);
                byte[] imgbytes = bout.toByteArray();
                String b64 = DatatypeConverter.printBase64Binary(imgbytes);
                this.out.startAttribute(PictureToSvg.xlinkTag("href"));
                this.out.write("data:image/png;base64,");
                this.out.write(b64);
                this.out.endAttribute();
            }
            catch (Throwable ex) {
                // empty catch block
            }
        }
        this.out.endElement();
    }

    @Override
    public void visitPBox(PBox pic) {
        int n = pic.children.length;
        AffineTransform tr = n <= 1 || pic.axis == 'Z' ? null : new AffineTransform();
        for (int i = 0; i < n; ++i) {
            Picture child = pic.children[i];
            double offset = pic.translations[i];
            if (i > 0 && pic.axis != 'Z') {
                if (pic.axis == 'X') {
                    tr.setToTranslation(offset, 0.0);
                } else {
                    tr.setToTranslation(0.0, offset);
                }
                this.visitWithTransform(child, tr);
                continue;
            }
            child.visit(this);
        }
    }

    public static String transformAttribute(AffineTransform tr) {
        double m00 = tr.getScaleX();
        double m10 = tr.getShearY();
        double m01 = tr.getShearX();
        double m11 = tr.getScaleY();
        double m02 = tr.getTranslateX();
        double m12 = tr.getTranslateY();
        return String.format("matrix(%g %g %g %g %g %g)", m00, m10, m01, m11, m02, m12);
    }

    @Override
    public void visitWithTransform(WithTransform pic) {
        this.visitWithTransform(pic.picture, pic.transform);
    }

    public void visitWithTransform(Picture pic, AffineTransform tr) {
        this.out.startElement(PictureToSvg.svgTag("g"));
        PictureToSvg.writeAttribute("transform", PictureToSvg.transformAttribute(tr), this.out);
        pic.visit(this);
        this.out.endElement();
    }

    void writeCompOp(Composite comp) {
        String op = null;
        if (comp == AlphaComposite.Clear) {
            op = "clear";
        } else if (comp == AlphaComposite.DstOver) {
            op = "dst-over";
        } else if (comp == AlphaComposite.Src) {
            op = "src";
        } else if (comp == AlphaComposite.SrcOver) {
            op = "src-over";
        }
        if (op != null) {
            PictureToSvg.writeAttribute("comp-op", op, this.out);
        }
    }

    @Override
    public void visitWithComposite(WithComposite pic) {
        this.out.startElement(PictureToSvg.svgTag("g"));
        Composite op = pic.singleOp();
        int n = pic.children.length;
        if (n != 0) {
            if (op != null) {
                this.writeCompOp(op);
                for (int i = 0; i < n; ++i) {
                    pic.children[i].visit(this);
                }
            } else {
                Composite prev = null;
                for (int i = 0; i < n; ++i) {
                    op = pic.composite[i];
                    if (op != null && op != prev) {
                        if (prev != null) {
                            this.out.endElement();
                        }
                        this.out.startElement(PictureToSvg.svgTag("g"));
                        this.writeCompOp(op);
                        prev = op;
                    }
                    pic.children[i].visit(this);
                }
                if (prev != null) {
                    this.out.endElement();
                }
            }
        }
        this.out.endElement();
    }
}

