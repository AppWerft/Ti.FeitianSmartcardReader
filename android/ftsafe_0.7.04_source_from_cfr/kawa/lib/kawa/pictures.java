/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.kawa;

import gnu.bytecode.Type;
import gnu.expr.GenericProc;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.SourceName;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.models.DDimension;
import gnu.kawa.models.DrawImage;
import gnu.kawa.models.DrawShape;
import gnu.kawa.models.FillShape;
import gnu.kawa.models.PBox;
import gnu.kawa.models.Picture;
import gnu.kawa.models.Pictures;
import gnu.kawa.models.SVGUtils;
import gnu.kawa.models.StandardColor;
import gnu.kawa.models.WithComposite;
import gnu.kawa.models.WithPaint;
import gnu.kawa.models.WithTransform;
import gnu.kawa.xml.KElement;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.math.BaseUnit;
import gnu.math.DFloNum;
import gnu.math.DQuantity;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RealNum;
import gnu.math.Unit;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import kawa.lang.Macro;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.TemplateScope;
import kawa.lib.exceptions;

public class pictures
extends ModuleBody {
    public static final Class DDimension;
    public static final Class DrawImage;
    public static final Class Picture;
    public static final Class Pictures;
    public static final Class StandardColor;
    public static final Class AffineTransform;
    public static final Class BufferedImage;
    public static final Class RenderedImage;
    public static final ModuleMethod make$MnPoint;
    @SourceName(name="P", uri="http://kawa.gnu.org/construct", prefix="$construct$")
    public static final Macro P;
    public static final ModuleMethod make$MnDimension;
    @SourceName(name="D", uri="http://kawa.gnu.org/construct", prefix="$construct$")
    public static final Macro D;
    public static final ModuleMethod picture$Mnbounds;
    public static final ModuleMethod hbox;
    public static final ModuleMethod vbox;
    public static final ModuleMethod zbox;
    public static final ModuleMethod rectangle;
    public static final ModuleMethod line;
    public static final ModuleMethod polygon;
    public static final ModuleMethod circle;
    public static final GenericProc fill;
    public static final ModuleMethod draw;
    public static final ModuleMethod border$Mnshape;
    public static final GenericProc border;
    public static final GenericProc padding;
    public static final GenericProc image;
    public static final ModuleMethod image$Mnread;
    public static final ModuleMethod image$Mnwrite;
    public static final ModuleMethod image$Mnwidth;
    public static final ModuleMethod image$Mnheight;
    public static final ModuleMethod $Mn$Grpaint;
    public static final ModuleMethod $Mn$Grimage;
    public static final ModuleMethod $Mn$Grpicture;
    public static final ModuleMethod $Mn$Grtransform;
    public static final ModuleMethod with$Mnpaint;
    public static final ModuleMethod with$Mntransform;
    public static final ModuleMethod with$Mncomposite;
    public static final GenericProc rotate;
    public static final GenericProc scale;
    public static final GenericProc translate;
    public static final GenericProc re$Mncenter;
    public static final GenericProc affine$Mntransform;
    public static final ModuleMethod picture$Mnwrite$Mnsvg;
    public static final ModuleMethod picture$Mn$Grsvg$Mnnode;
    static final ModuleMethod line$Mnpath;
    static final IntNum Lit0;
    public static pictures $instance;
    static final SimpleSymbol Lit1;
    static final Symbol Lit2;
    static final SyntaxRules Lit3;
    static final SimpleSymbol Lit4;
    static final Symbol Lit5;
    static final SyntaxRules Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final DFloNum Lit18;
    static final Keyword Lit19;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final SimpleSymbol Lit38;
    static final SimpleSymbol Lit39;
    static final Object[] Lit40;
    static final SimpleSymbol Lit41;
    static final SimpleSymbol Lit42;
    static final Namespace Lit43;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    /*
     * Exception decompiling
     */
    public static Point2D.Double makePoint(Object x, Object y) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public static DDimension makeDimension(double w, double h) {
        return new DDimension(w, h);
    }

    public static Rectangle2D pictureBounds(Object picture) {
        return Pictures.asPicture(picture).getBounds2D();
    }

    public static /* varargs */ PBox hbox(Object ... args) {
        return PBox.makeBox('X', args);
    }

    public static /* varargs */ PBox vbox(Object ... args) {
        return PBox.makeBox('Y', args);
    }

    public static /* varargs */ PBox zbox(Object ... args) {
        return PBox.makeBox('Z', args);
    }

    public static Rectangle2D rectangle(Point2D point2D) {
        return pictures.rectangle(point2D, null);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Rectangle2D rectangle(Point2D p1, Object p2) {
        Point2D p;
        void x;
        Rectangle2D.Double double_;
        double d = p1.getX();
        double y = p1.getY();
        if (p2 == null) {
            double_ = new Rectangle2D.Double(0.0, 0.0, (double)x, y);
            return double_;
        }
        if (p2 instanceof Dimension2D) {
            Object object2 = Promise.force(p2, Dimension2D.class);
            Dimension2D p3 = (Dimension2D)object2;
            double_ = new Rectangle2D.Double((double)x, y, p3.getWidth(), p3.getHeight());
            return double_;
        }
        Object object3 = Promise.force(p2, Point2D.class);
        try {
            p = (Point2D)object3;
        }
        catch (ClassCastException classCastException) {
            void w;
            throw new WrongType(classCastException, "p", -2, (Object)w);
        }
        double w = Math.abs(p.getX() - x);
        double h = Math.abs(p.getY() - y);
        double_ = new Rectangle2D.Double((double)x, y, w, h);
        return double_;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "p", -2, (Object)w);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static /* varargs */ Object linePath(boolean do$Mnclose, Point2D initial, Object ... more$Mnpoints) {
        double curx;
        void path;
        double cury;
        Object object2;
        GeneralPath generalPath = new GeneralPath();
        double d = initial.getX();
        double d2 = initial.getY();
        int n$Mnpoints = more$Mnpoints.length;
        path.moveTo(curx, cury);
        int i = 0;
        do {
            Cloneable p;
            if (i >= n$Mnpoints) {
                if (!do$Mnclose) return path;
                path.closePath();
                return path;
            }
            Object pt = more$Mnpoints[i];
            if (pt instanceof Dimension2D) {
                object2 = Promise.force(pt, Dimension2D.class);
                p = (Dimension2D)object2;
                curx += ((Dimension2D)p).getWidth();
                cury += ((Dimension2D)p).getHeight();
            }
            object2 = Promise.force(pt, Point2D.class);
            p = (Point2D)object2;
            curx = ((Point2D)p).getX();
            cury = ((Point2D)p).getY();
            path.lineTo(curx, cury);
            ++i;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "p", -2, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "p", -2, object2);
        }
    }

    public static /* varargs */ Object line(Object initial, Object ... more$Mnpoints) {
        Object object2 = Promise.force(initial, Point2D.class);
        try {
            return pictures.linePath(false, (Point2D)object2, more$Mnpoints);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "line-path", 1, object2);
        }
    }

    public static /* varargs */ Object polygon(Object initial, Object ... more$Mnpoints) {
        Object object2 = Promise.force(initial, Point2D.class);
        try {
            return pictures.linePath(true, (Point2D)object2, more$Mnpoints);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "line-path", 1, object2);
        }
    }

    public static Ellipse2D.Double circle(float f) {
        return pictures.circle(f, pictures.makePoint(Lit0, Lit0));
    }

    /*
     * Exception decompiling
     */
    public static Ellipse2D.Double circle(float radius, Point2D center) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public static Picture draw$V(Object[] argsArray) {
        LList lList;
        LList args;
        lList = args = (lList = LList.makeList(argsArray, 0));
        return DrawShape.makeDraw(lList);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Shape borderShape(Object widths, boolean border, Picture picture) {
        double d;
        Object object3;
        Shape shape;
        Object object4;
        Rectangle2D bounds = picture.getBounds2D();
        if (widths instanceof Dimension2D) {
            object3 = Promise.force(widths, Dimension2D.class);
            Dimension2D d2 = (Dimension2D)object3;
            shape = Pictures.borderShape(bounds, border, d2.getHeight(), d2.getWidth(), d2.getHeight(), d2.getWidth());
            return shape;
        }
        if (widths instanceof Rectangle2D) {
            object4 = Promise.force(widths, Rectangle2D.class);
            Rectangle2D d3 = (Rectangle2D)object4;
            shape = Pictures.borderShape(bounds, border, bounds.getY() - d3.getY(), d3.getX() + d3.getWidth() - (bounds.getX() + bounds.getWidth()), bounds.getX() - d3.getX(), d3.getY() + d3.getHeight() - (bounds.getY() + bounds.getHeight()));
            return shape;
        }
        Object object2 = Promise.force(widths);
        try {
            d = ((Number)object2).doubleValue();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "d", -2, object2);
        }
        shape = Pictures.borderShape(bounds, border, d, d, d, d);
        return shape;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "d", -2, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "d", -2, object4);
        }
    }

    public static BufferedImage imageRead(Path uri) {
        return ImageIO.read(uri.openInputStream());
    }

    public static void imageWrite(Object picture, Object path) {
        boolean x;
        String fname = path.toString();
        String lname = fname.toLowerCase();
        String format = lname.endsWith(".gif") ? "gif" : (((x = lname.endsWith("jpg")) ? x : lname.endsWith(".jpeg")) ? "jpg" : "png");
        RenderedImage img = pictures.$To$Image(picture);
        RenderedImage bimg = img instanceof DrawImage ? ((DrawImage)img).getImage() : img;
        OutputStream strm = Path.valueOf(path).openOutputStream();
        try {
            ImageIO.write(bimg, format, strm);
            Object var9_9 = null;
        }
        catch (Throwable throwable) {
            Object var9_10 = null;
            strm.close();
            throw throwable;
        }
        strm.close();
        {
        }
    }

    public static RenderedImage $To$Image(Object value) {
        Object object2 = value = Promise.force(value);
        return object2 instanceof RenderedImage ? (RenderedImage)Promise.force(value, RenderedImage.class) : Pictures.toImage(pictures.$To$Picture(value));
    }

    public static int imageWidth(RenderedImage image) {
        return image.getWidth();
    }

    public static int imageHeight(RenderedImage image) {
        return image.getHeight();
    }

    /*
     * Exception decompiling
     */
    public static Paint $To$Paint(Object value) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public static Picture $To$Picture(Object value) {
        return Pictures.asPicture(value);
    }

    public static AffineTransform $To$Transform(Object tr) {
        return (AffineTransform)Promise.force(tr, AffineTransform.class);
    }

    public static WithPaint withPaint(Object paint, Object pic) {
        return new WithPaint(pictures.$To$Picture(pic), pictures.$To$Paint(paint));
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object withTransform(Object tr, Object pic) {
        Object object2;
        Object object3;
        AffineTransform tr2 = pictures.$To$Transform(tr);
        if (pic instanceof Shape) {
            Object object4 = Promise.force(pic, Shape.class);
            object3 = tr2.createTransformedShape((Shape)object4);
            return object3;
        }
        if (pic instanceof AffineTransform) {
            AffineTransform trcopy = new AffineTransform(tr2);
            object2 = Promise.force(pic, AffineTransform.class);
            trcopy.concatenate((AffineTransform)object2);
            object3 = trcopy;
            return object3;
        }
        if (pic instanceof Point2D) {
            Point2D.Double dst = new Point2D.Double();
            object3 = tr2.transform((Point2D)Promise.force(pic, Point2D.class), dst);
            return object3;
        }
        object3 = new WithTransform(pictures.$To$Picture(pic), tr2);
        return object3;
        catch (ClassCastException classCastException) {
            void dst;
            throw new WrongType(classCastException, "java.awt.geom.AffineTransform.createTransformedShape(java.awt.Shape)", 2, (Object)dst);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "java.awt.geom.AffineTransform.concatenate(java.awt.geom.AffineTransform)", 2, object2);
        }
    }

    public static /* varargs */ WithComposite withComposite(Object ... arguments) {
        return WithComposite.make(arguments);
    }

    public static void pictureWriteSvg(Object object2, Path path) {
        pictures.pictureWriteSvg(object2, path, true);
    }

    public static void pictureWriteSvg(Object picture, Path name, boolean headers) {
        OutPort port = OutPort.openFile(name);
        try {
            SVGUtils.toSVG(pictures.$To$Picture(picture), port, headers);
            Object var5_4 = null;
            port.close();
        }
        catch (Throwable throwable) {
            Object var5_5 = null;
            port.close();
            throw throwable;
        }
    }

    public static KElement picture$To$SvgNode(Object picture) {
        return SVGUtils.toSVGNode(pictures.$To$Picture(picture));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static double angleToRadian(Number val) {
        double d;
        block8 : {
            block10 : {
                double dval;
                block11 : {
                    boolean x;
                    Unit unit;
                    block9 : {
                        boolean x2;
                        DQuantity qval;
                        if (!(val instanceof DQuantity)) break block8;
                        Number number = val;
                        try {
                            qval = (DQuantity)number;
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "qval", -2, (Object)unit);
                        }
                        unit = qval.unit();
                        dval = qval.doubleValue();
                        if (unit == Unit.Empty) {
                            d = dval * (Math.PI / 180.0);
                            return d;
                        }
                        boolean bl = x2 = unit == Unit.degree;
                        if (!x2) break block9;
                        if (!x2) break block10;
                        break block11;
                    }
                    boolean bl = x = unit == Unit.radian;
                    if (!(x ? x : unit == Unit.gradian)) break block10;
                }
                d = dval;
                return d;
            }
            Type.NeverReturns neverReturns = exceptions.error("invalid unit for angle");
            throw Special.reachedUnexpected;
        }
        if (val instanceof RealNum) {
            d = ((Number)Promise.force(((Procedure)MultiplyOp.$St).apply2(val, Math.PI / 180.0))).doubleValue();
            return d;
        }
        if (val instanceof Numeric) {
            Type.NeverReturns neverReturns = exceptions.error("not a real number for angle");
            throw Special.reachedUnexpected;
        }
        d = val.doubleValue() * (Math.PI / 180.0);
        return d;
    }

    public static {
        Lit43 = Namespace.valueOf("http://kawa.gnu.org/construct", "$construct$");
        Lit42 = Symbol.valueOf("$string$");
        Lit41 = Symbol.valueOf("%simple-construct-builder");
        Lit40 = new Object[0];
        Lit39 = Symbol.valueOf("picture->svg-node");
        Lit38 = Symbol.valueOf("picture-write-svg");
        Lit37 = Symbol.valueOf("bottom");
        Lit36 = Symbol.valueOf("top");
        Lit35 = Symbol.valueOf("origin");
        Lit34 = Symbol.valueOf("centre");
        Lit33 = Symbol.valueOf("center");
        Lit32 = Symbol.valueOf("right");
        Lit31 = Symbol.valueOf("left");
        Lit30 = Symbol.valueOf("with-composite");
        Lit29 = Symbol.valueOf("with-transform");
        Lit28 = Symbol.valueOf("with-paint");
        Lit27 = Symbol.valueOf("->transform");
        Lit26 = Symbol.valueOf("->picture");
        Lit25 = Symbol.valueOf("->image");
        Lit24 = Symbol.valueOf("->paint");
        Lit23 = Symbol.valueOf("image-height");
        Lit22 = Symbol.valueOf("image-width");
        Lit21 = Symbol.valueOf("image-write");
        Lit20 = Symbol.valueOf("image-read");
        Lit19 = Keyword.make("src");
        Lit18 = DFloNum.valueOf(1.0);
        Lit17 = Symbol.valueOf("border-shape");
        Lit16 = Symbol.valueOf("draw");
        Lit15 = Symbol.valueOf("circle");
        Lit14 = Symbol.valueOf("polygon");
        Lit13 = Symbol.valueOf("line");
        Lit12 = Symbol.valueOf("line-path");
        Lit11 = Symbol.valueOf("rectangle");
        Lit10 = Symbol.valueOf("zbox");
        Lit9 = Symbol.valueOf("vbox");
        Lit8 = Symbol.valueOf("hbox");
        Lit7 = Symbol.valueOf("picture-bounds");
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[1];
        Object[] arrobject = new Object[3];
        arrobject[0] = new SyntaxForms.SimpleSyntaxForm(Lit41, TemplateScope.make("kawa.lib.syntax"));
        Lit4 = Symbol.valueOf("make-Dimension");
        arrobject[1] = Lit4;
        arrobject[2] = new SyntaxForms.SimpleSyntaxForm(Lit42, TemplateScope.make("kawa.lib.syntax"));
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit40, 1, "pictures.scm:12"), "\u0000", "\t\u0004\u0011\u0018\f\t\u0014\t\u0010\u0002", arrobject, 0);
        Lit5 = Symbol.make(Lit43, "D");
        Lit6 = new SyntaxRules(Lit40, arrsyntaxRule, 1, Lit5);
        SyntaxRule[] arrsyntaxRule2 = new SyntaxRule[1];
        Object[] arrobject2 = new Object[3];
        arrobject2[0] = new SyntaxForms.SimpleSyntaxForm(Lit41, TemplateScope.make("kawa.lib.syntax"));
        Lit1 = Symbol.valueOf("make-Point");
        arrobject2[1] = Lit1;
        arrobject2[2] = new SyntaxForms.SimpleSyntaxForm(Lit42, TemplateScope.make("kawa.lib.syntax"));
        arrsyntaxRule2[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit40, 1, "pictures.scm:10"), "\u0000", "\t\u0004\u0011\u0018\f\t\u0014\t\u0010\u0002", arrobject2, 0);
        Lit2 = Symbol.make(Lit43, "P");
        Lit3 = new SyntaxRules(Lit40, arrsyntaxRule2, 1, Lit2);
        Lit0 = IntNum.valueOf(0);
        RenderedImage = RenderedImage.class;
        BufferedImage = BufferedImage.class;
        AffineTransform = AffineTransform.class;
        StandardColor = StandardColor.class;
        Pictures = Pictures.class;
        Picture = Picture.class;
        DrawImage = DrawImage.class;
        DDimension = DDimension.class;
        pictures pictures2 = $instance = new pictures();
        make$MnPoint = new ModuleMethod(pictures2, 1, Lit1, 8194);
        P = Macro.make(Lit2, Lit3, "kawa.lib.kawa.pictures");
        make$MnDimension = new ModuleMethod(pictures2, 2, Lit4, 8194);
        D = Macro.make(Lit5, Lit6, "kawa.lib.kawa.pictures");
        picture$Mnbounds = new ModuleMethod(pictures2, 3, Lit7, 4097);
        hbox = new ModuleMethod(pictures2, 4, Lit8, -4096);
        vbox = new ModuleMethod(pictures2, 5, Lit9, -4096);
        zbox = new ModuleMethod(pictures2, 6, Lit10, -4096);
        rectangle = new ModuleMethod(pictures2, 7, Lit11, 8193);
        line$Mnpath = new ModuleMethod(pictures2, 9, Lit12, -4094);
        line = new ModuleMethod(pictures2, 10, Lit13, -4095);
        polygon = new ModuleMethod(pictures2, 11, Lit14, -4095);
        circle = new ModuleMethod(pictures2, 12, Lit15, 8193);
        GenericProc genericProc = new GenericProc("fill");
        pictures $instance = pictures.$instance;
        ModuleMethod moduleMethod = new ModuleMethod($instance, 14, null, 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:78");
        genericProc.add(moduleMethod);
        pictures $instance2 = pictures.$instance;
        ModuleMethod moduleMethod2 = new ModuleMethod($instance2, 15, null, 8194);
        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:80");
        genericProc.add(moduleMethod2);
        fill = genericProc;
        draw = new ModuleMethod(pictures2, 16, Lit16, -4096);
        border$Mnshape = new ModuleMethod(pictures2, 17, Lit17, 12291);
        GenericProc genericProc2 = new GenericProc("border");
        $instance = pictures.$instance;
        ModuleMethod moduleMethod3 = new ModuleMethod($instance, 18, null, 12291);
        moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:107");
        genericProc2.add(moduleMethod3);
        $instance2 = pictures.$instance;
        ModuleMethod moduleMethod4 = new ModuleMethod($instance2, 19, null, 8194);
        moduleMethod4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:112");
        genericProc2.add(moduleMethod4);
        pictures $instance3 = pictures.$instance;
        ModuleMethod moduleMethod5 = new ModuleMethod($instance3, 20, null, 4097);
        moduleMethod5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:117");
        genericProc2.add(moduleMethod5);
        border = genericProc2;
        GenericProc genericProc3 = new GenericProc("padding");
        $instance = pictures.$instance;
        ModuleMethod moduleMethod6 = new ModuleMethod($instance, 21, null, 12291);
        moduleMethod6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:121");
        genericProc3.add(moduleMethod6);
        $instance2 = pictures.$instance;
        ModuleMethod moduleMethod7 = new ModuleMethod($instance2, 22, null, 8194);
        moduleMethod7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:126");
        genericProc3.add(moduleMethod7);
        padding = genericProc3;
        GenericProc genericProc4 = new GenericProc("image");
        $instance = pictures.$instance;
        ModuleMethod moduleMethod8 = new ModuleMethod($instance, 23, null, -4096);
        moduleMethod8.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:130");
        genericProc4.add(moduleMethod8);
        $instance2 = pictures.$instance;
        ModuleMethod moduleMethod9 = new ModuleMethod($instance2, 24, null, 4097);
        moduleMethod9.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:132");
        genericProc4.add(moduleMethod9);
        $instance3 = pictures.$instance;
        ModuleMethod moduleMethod10 = new ModuleMethod($instance3, 25, null, 4097);
        moduleMethod10.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:134");
        genericProc4.add(moduleMethod10);
        image = genericProc4;
        image$Mnread = new ModuleMethod(pictures2, 26, Lit20, 4097);
        image$Mnwrite = new ModuleMethod(pictures2, 27, Lit21, 8194);
        image$Mnwidth = new ModuleMethod(pictures2, 28, Lit22, 4097);
        image$Mnheight = new ModuleMethod(pictures2, 29, Lit23, 4097);
        $Mn$Grpaint = new ModuleMethod(pictures2, 30, Lit24, 4097);
        $Mn$Grimage = new ModuleMethod(pictures2, 31, Lit25, 4097);
        $Mn$Grpicture = new ModuleMethod(pictures2, 32, Lit26, 4097);
        $Mn$Grtransform = new ModuleMethod(pictures2, 33, Lit27, 4097);
        with$Mnpaint = new ModuleMethod(pictures2, 34, Lit28, 8194);
        with$Mntransform = new ModuleMethod(pictures2, 35, Lit29, 8194);
        with$Mncomposite = new ModuleMethod(pictures2, 36, Lit30, -4096);
        GenericProc genericProc5 = new GenericProc("rotate");
        $instance = pictures.$instance;
        ModuleMethod moduleMethod11 = new ModuleMethod($instance, 37, null, 4097);
        moduleMethod11.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:228");
        genericProc5.add(moduleMethod11);
        $instance2 = pictures.$instance;
        ModuleMethod moduleMethod12 = new ModuleMethod($instance2, 38, null, 8194);
        moduleMethod12.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:230");
        genericProc5.add(moduleMethod12);
        rotate = genericProc5;
        GenericProc genericProc6 = new GenericProc("scale");
        $instance = pictures.$instance;
        ModuleMethod moduleMethod13 = new ModuleMethod($instance, 39, null, 4097);
        moduleMethod13.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:234");
        genericProc6.add(moduleMethod13);
        $instance2 = pictures.$instance;
        ModuleMethod moduleMethod14 = new ModuleMethod($instance2, 40, null, 4097);
        moduleMethod14.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:236");
        genericProc6.add(moduleMethod14);
        $instance3 = pictures.$instance;
        ModuleMethod moduleMethod15 = new ModuleMethod($instance3, 41, null, 4097);
        moduleMethod15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:238");
        genericProc6.add(moduleMethod15);
        pictures $instance4 = pictures.$instance;
        ModuleMethod moduleMethod16 = new ModuleMethod($instance4, 42, null, 8194);
        moduleMethod16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:240");
        genericProc6.add(moduleMethod16);
        scale = genericProc6;
        GenericProc genericProc7 = new GenericProc("translate");
        $instance = pictures.$instance;
        ModuleMethod moduleMethod17 = new ModuleMethod($instance, 43, null, 4097);
        moduleMethod17.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:244");
        genericProc7.add(moduleMethod17);
        $instance2 = pictures.$instance;
        ModuleMethod moduleMethod18 = new ModuleMethod($instance2, 44, null, 4097);
        moduleMethod18.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:246");
        genericProc7.add(moduleMethod18);
        $instance3 = pictures.$instance;
        ModuleMethod moduleMethod19 = new ModuleMethod($instance3, 45, null, 8194);
        moduleMethod19.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:248");
        genericProc7.add(moduleMethod19);
        translate = genericProc7;
        GenericProc genericProc8 = new GenericProc("re-center");
        $instance = pictures.$instance;
        ModuleMethod moduleMethod20 = new ModuleMethod($instance, 46, null, 12291);
        moduleMethod20.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:252");
        genericProc8.add(moduleMethod20);
        $instance2 = pictures.$instance;
        ModuleMethod moduleMethod21 = new ModuleMethod($instance2, 47, null, 8194);
        moduleMethod21.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:276");
        genericProc8.add(moduleMethod21);
        $instance3 = pictures.$instance;
        ModuleMethod moduleMethod22 = new ModuleMethod($instance3, 48, null, 4097);
        moduleMethod22.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:283");
        genericProc8.add(moduleMethod22);
        re$Mncenter = genericProc8;
        GenericProc genericProc9 = new GenericProc("affine-transform");
        $instance = pictures.$instance;
        ModuleMethod moduleMethod23 = new ModuleMethod($instance, 49, null, 24582);
        moduleMethod23.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:287");
        genericProc9.add(moduleMethod23);
        $instance2 = pictures.$instance;
        ModuleMethod moduleMethod24 = new ModuleMethod($instance2, 50, null, 12291);
        moduleMethod24.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:291");
        genericProc9.add(moduleMethod24);
        affine$Mntransform = genericProc9;
        picture$Mnwrite$Mnsvg = new ModuleMethod(pictures2, 51, Lit38, 12290);
        picture$Mn$Grsvg$Mnnode = new ModuleMethod(pictures2, 53, Lit39, 4097);
        pictures.$runBody$();
    }

    public pictures() {
        ModuleInfo.register(this);
    }

    public static Picture lambda1(Shape shape) {
        return new FillShape(shape);
    }

    public static WithPaint lambda2(Object paint, Shape shape) {
        return pictures.withPaint(paint, new FillShape(shape));
    }

    public static PBox lambda3(Object widths, Object paint, Object picture) {
        Picture pic = pictures.$To$Picture(picture);
        return PBox.makeBox('Z', ((Procedure)fill).apply2(paint, pictures.borderShape(widths, true, pic)), pic);
    }

    public static PBox lambda4(Object widths, Object picture) {
        Picture pic = pictures.$To$Picture(picture);
        return PBox.makeBox('Z', ((Procedure)fill).apply1(pictures.borderShape(widths, true, pic)), pic);
    }

    public static Object lambda5(Object picture) {
        return ((Procedure)border).apply2(Lit18, picture);
    }

    public static PBox lambda6(Object widths, Object background, Object picture) {
        Picture pic = pictures.$To$Picture(picture);
        return PBox.makeBox('Z', ((Procedure)fill).apply2(background, pictures.borderShape(widths, false, pic)), pic);
    }

    public static Object lambda7(Object widths, Object picture) {
        return ((Procedure)padding).apply3(widths, StandardColor.transparent, picture);
    }

    public static DrawImage lambda8$V(Object[] argsArray) {
        Object src = Keyword.searchForKeyword(argsArray, 0, Lit19, Boolean.FALSE);
        DrawImage drawImage = new DrawImage();
        Object object2 = Promise.force(src, Path.class);
        try {
            drawImage.setSrc(Path.valueOf(object2));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.kawa.models.DrawImage.setSrc(path)", 2, object2);
        }
        return drawImage;
    }

    public static DrawImage lambda9(BufferedImage image) {
        return new DrawImage(image);
    }

    public static DrawImage lambda10(Object image) {
        return new DrawImage(Pictures.toImage(pictures.$To$Picture(image)));
    }

    public static AffineTransform lambda11(Object angle) {
        Object object2 = Promise.force(angle, Number.class);
        try {
            return AffineTransform.getRotateInstance(pictures.angleToRadian((Number)object2));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "angle-to-radian", 0, object2);
        }
    }

    public static Object lambda12(Object angle, Object picture) {
        return pictures.withTransform(((Procedure)rotate).apply1(angle), picture);
    }

    public static AffineTransform lambda13(Dimension2D sc) {
        return AffineTransform.getScaleInstance(sc.getWidth(), sc.getHeight());
    }

    public static AffineTransform lambda14(Point2D sc) {
        return AffineTransform.getScaleInstance(sc.getX(), sc.getY());
    }

    /*
     * Exception decompiling
     */
    public static AffineTransform lambda15(RealNum sc) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public static Object lambda16(Object sc, Object picture) {
        return pictures.withTransform(((Procedure)scale).apply1(sc), picture);
    }

    public static AffineTransform lambda17(Dimension2D delta) {
        return AffineTransform.getTranslateInstance(delta.getWidth(), delta.getHeight());
    }

    public static AffineTransform lambda18(Point2D delta) {
        return AffineTransform.getTranslateInstance(delta.getX(), delta.getY());
    }

    public static Object lambda19(Object delta, Object picture) {
        return pictures.withTransform(((Procedure)translate).apply1(delta), picture);
    }

    public static Object lambda20(Object xposition, Object yposition, Object picture) {
        Number number;
        Number number2;
        Picture pic = pictures.$To$Picture(picture);
        Rectangle2D bounds = pic.getBounds2D();
        if (xposition == Lit31) {
            number = bounds.getX();
        } else if (xposition == Lit32) {
            number = bounds.getX() + bounds.getWidth();
        } else {
            boolean x;
            boolean bl = x = xposition == Lit33;
            if (x ? x : xposition == Lit34) {
                number = bounds.getX() + 0.5 * bounds.getWidth();
            } else if (xposition == Lit35) {
                number = Lit0;
            } else {
                Type.NeverReturns neverReturns = exceptions.error("invalid x-position specifier", xposition);
                throw Special.reachedUnexpected;
            }
        }
        Double xgoal = number;
        if (yposition == Lit36) {
            number2 = bounds.getY();
        } else if (yposition == Lit37) {
            number2 = bounds.getY() + bounds.getHeight();
        } else {
            boolean x;
            boolean bl = x = yposition == Lit33;
            if (x ? x : yposition == Lit34) {
                number2 = bounds.getX() + 0.5 * bounds.getHeight();
            } else if (yposition == Lit35) {
                number2 = Lit0;
            } else {
                Type.NeverReturns neverReturns = exceptions.error("invalid y-position specifier", yposition);
                throw Special.reachedUnexpected;
            }
        }
        Double ygoal = number2;
        return pictures.withTransform(((Procedure)translate).apply1(pictures.makePoint(((Procedure)AddOp.$Mn).apply1(xgoal), ((Procedure)AddOp.$Mn).apply1(ygoal))), picture);
    }

    public static Object lambda21(Object position, Object picture) {
        boolean x;
        Object object2;
        boolean bl = x = position == Lit31;
        if (x ? x : position == Lit32) {
            object2 = ((Procedure)re$Mncenter).apply3(position, Lit33, picture);
        } else {
            boolean x2;
            boolean bl2 = x2 = position == Lit36;
            object2 = (x2 ? x2 : position == Lit37) ? ((Procedure)re$Mncenter).apply3(Lit33, position, picture) : ((Procedure)re$Mncenter).apply3(position, position, picture);
        }
        return object2;
    }

    public static Object lambda22(Object picture) {
        return ((Procedure)re$Mncenter).apply3(Lit33, Lit33, picture);
    }

    public static AffineTransform lambda23(double m00, double m10, double m01, double m11, double m02, double m12) {
        return new AffineTransform(m00, m10, m01, m11, m02, m12);
    }

    public static AffineTransform lambda24(Point2D px, Point2D py, Point2D p0) {
        return new AffineTransform(px.getX(), px.getY(), py.getX(), py.getY(), p0.getX(), p0.getY());
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 48: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 44: {
                Object object3 = Promise.force(object2, Point2D.class);
                if (!(object3 instanceof Point2D)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 43: {
                Object object4 = Promise.force(object2, Dimension2D.class);
                if (!(object4 instanceof Dimension2D)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 41: {
                Object object5 = Promise.force(object2, RealNum.class);
                if (RealNum.asRealNumOrNull(object5) == null) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 40: {
                Object object6 = Promise.force(object2, Point2D.class);
                if (!(object6 instanceof Point2D)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 39: {
                Object object7 = Promise.force(object2, Dimension2D.class);
                if (!(object7 instanceof Dimension2D)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 37: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 25: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 24: {
                Object object8 = Promise.force(object2, BufferedImage.class);
                if (!(object8 instanceof BufferedImage)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 20: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                Object object9 = Promise.force(object2, Shape.class);
                if (!(object9 instanceof Shape)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 53: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 33: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 32: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 31: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 30: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 29: {
                Object object10 = Promise.force(object2, RenderedImage.class);
                if (!(object10 instanceof RenderedImage)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 28: {
                Object object11 = Promise.force(object2, RenderedImage.class);
                if (!(object11 instanceof RenderedImage)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 26: {
                Object object12 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object12) == null) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 12: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 7: {
                Object object13 = Promise.force(object2, Point2D.class);
                if (!(object13 instanceof Point2D)) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 47: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 45: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 42: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 38: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 22: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 19: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 15: {
                callContext.value1 = object2;
                Object object4 = Promise.force(object3, Shape.class);
                if (!(object4 instanceof Shape)) {
                    return -786430;
                }
                callContext.value2 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 51: {
                callContext.value1 = object2;
                Object object5 = Promise.force(object3, Path.class);
                if (Path.coerceToPathOrNull(object5) == null) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 35: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 34: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 27: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 12: {
                callContext.value1 = Promise.force(object2);
                Object object6 = Promise.force(object3, Point2D.class);
                if (!(object6 instanceof Point2D)) {
                    return -786430;
                }
                callContext.value2 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 7: {
                Object object7 = Promise.force(object2, Point2D.class);
                if (!(object7 instanceof Point2D)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 2: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 1: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 50: {
                Object object5 = Promise.force(object2, Point2D.class);
                if (!(object5 instanceof Point2D)) {
                    return -786431;
                }
                callContext.value1 = object5;
                Object object6 = Promise.force(object3, Point2D.class);
                if (!(object6 instanceof Point2D)) {
                    return -786430;
                }
                callContext.value2 = object6;
                Object object7 = Promise.force(object4, Point2D.class);
                if (!(object7 instanceof Point2D)) {
                    return -786429;
                }
                callContext.value3 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 46: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 21: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 18: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 51: {
                callContext.value1 = object2;
                Object object8 = Promise.force(object3, Path.class);
                if (Path.coerceToPathOrNull(object8) == null) {
                    return -786430;
                }
                callContext.value2 = object8;
                Object object9 = Promise.force(object4);
                if (!(object9 instanceof Boolean)) {
                    return -786429;
                }
                callContext.value3 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 17: {
                callContext.value1 = object2;
                Object object10 = Promise.force(object3);
                if (!(object10 instanceof Boolean)) {
                    return -786430;
                }
                callContext.value2 = object10;
                Object object11 = Promise.force(object4, Picture.class);
                if (!(object11 instanceof Picture)) {
                    return -786429;
                }
                callContext.value3 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 49: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 23: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 36: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 16: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 11: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 10: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 9: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 6: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 5: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 4: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
        }
        return super.matchN(moduleMethod, arrobject, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 3: {
                return pictures.pictureBounds(object2);
            }
            case 7: {
                return pictures.rectangle((Point2D)Promise.force(object2, Point2D.class));
            }
            case 12: {
                return pictures.circle(((Number)Promise.force(object2)).floatValue());
            }
            case 26: {
                return pictures.imageRead(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 28: {
                return pictures.imageWidth((RenderedImage)Promise.force(object2, RenderedImage.class));
            }
            case 29: {
                return pictures.imageHeight((RenderedImage)Promise.force(object2, RenderedImage.class));
            }
            case 30: {
                return pictures.$To$Paint(object2);
            }
            case 31: {
                return pictures.$To$Image(object2);
            }
            case 32: {
                return pictures.$To$Picture(object2);
            }
            case 33: {
                return pictures.$To$Transform(object2);
            }
            case 53: {
                return pictures.picture$To$SvgNode(object2);
            }
            case 14: {
                return pictures.lambda1((Shape)Promise.force(object2, Shape.class));
            }
            case 20: {
                return pictures.lambda5(object2);
            }
            case 24: {
                return pictures.lambda9((BufferedImage)Promise.force(object2, BufferedImage.class));
            }
            case 25: {
                return pictures.lambda10(object2);
            }
            case 37: {
                return pictures.lambda11(object2);
            }
            case 39: {
                return pictures.lambda13((Dimension2D)Promise.force(object2, Dimension2D.class));
            }
            case 40: {
                return pictures.lambda14((Point2D)Promise.force(object2, Point2D.class));
            }
            case 41: {
                return pictures.lambda15(LangObjType.coerceRealNum(Promise.force(object2, RealNum.class)));
            }
            case 43: {
                return pictures.lambda17((Dimension2D)Promise.force(object2, Dimension2D.class));
            }
            case 44: {
                return pictures.lambda18((Point2D)Promise.force(object2, Point2D.class));
            }
            case 48: {
                return pictures.lambda22(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "rectangle", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "circle", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "image-read", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "image-width", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "image-height", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "lambda", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public Object apply2(ModuleMethod var1_1, Object var2_2, Object var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public Object apply3(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public Object applyN(ModuleMethod var1_1, Object[] var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 6 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }
}

