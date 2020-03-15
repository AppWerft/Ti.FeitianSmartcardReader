// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.kawa;

import gnu.kawa.functions.AddOp;
import java.awt.geom.Dimension2D;
import gnu.kawa.models.FillShape;
import gnu.expr.ModuleInfo;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import kawa.lang.SyntaxForms;
import kawa.lang.TemplateScope;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.math.Numeric;
import gnu.kawa.functions.MultiplyOp;
import gnu.math.RealNum;
import gnu.expr.Special;
import kawa.lib.exceptions;
import gnu.math.Unit;
import gnu.math.DQuantity;
import gnu.kawa.xml.KElement;
import gnu.lists.PrintConsumer;
import gnu.kawa.models.SVGUtils;
import gnu.kawa.io.OutPort;
import gnu.kawa.models.WithComposite;
import gnu.kawa.models.WithPaint;
import java.awt.geom.AffineTransform;
import gnu.kawa.functions.Format;
import gnu.kawa.models.StandardColor;
import java.awt.Color;
import java.awt.Paint;
import java.io.OutputStream;
import java.awt.image.RenderedImage;
import gnu.kawa.models.DrawImage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import gnu.kawa.io.Path;
import java.awt.Shape;
import java.util.List;
import gnu.kawa.models.DrawShape;
import gnu.lists.LList;
import gnu.kawa.models.Picture;
import java.awt.geom.Ellipse2D;
import gnu.kawa.models.PBox;
import gnu.kawa.models.Pictures;
import java.awt.geom.Rectangle2D;
import gnu.kawa.models.DDimension;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import java.awt.geom.Point2D;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Namespace;
import gnu.expr.Keyword;
import gnu.math.DFloNum;
import kawa.lang.SyntaxRules;
import gnu.mapping.Symbol;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.expr.GenericProc;
import gnu.expr.SourceName;
import kawa.lang.Macro;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class pictures extends ModuleBody
{
    public static final Class DDimension;
    public static final Class DrawImage;
    public static final Class Picture;
    public static final Class Pictures;
    public static final Class StandardColor;
    public static final Class AffineTransform;
    public static final Class BufferedImage;
    public static final Class RenderedImage;
    public static final ModuleMethod make$MnPoint;
    @SourceName(name = "P", uri = "http://kawa.gnu.org/construct", prefix = "$construct$")
    public static final Macro P;
    public static final ModuleMethod make$MnDimension;
    @SourceName(name = "D", uri = "http://kawa.gnu.org/construct", prefix = "$construct$")
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Point2D.Double makePoint(final Object x, final Object y) {
        Object o2;
        final Object o = o2 = Promise.force(x);
        double doubleValue;
        Object o3;
        try {
            doubleValue = ((Number)o).doubleValue();
            o3 = (o2 = Promise.force(y));
            final Number n = (Number)o3;
            final double n2 = n.doubleValue();
            return new Point2D.Double(doubleValue, n2);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "java.awt.geom.Point2D$Double.<init>(double,double)", 1, o2);
        }
        try {
            final Number n = (Number)o3;
            final double n2 = n.doubleValue();
            return new Point2D.Double(doubleValue, n2);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "java.awt.geom.Point2D$Double.<init>(double,double)", 2, o2);
        }
    }
    
    public static DDimension makeDimension(final double w, final double h) {
        return new DDimension(w, h);
    }
    
    public static Rectangle2D pictureBounds(final Object picture) {
        return gnu.kawa.models.Pictures.asPicture(picture).getBounds2D();
    }
    
    public static PBox hbox(final Object... args) {
        return PBox.makeBox('X', args);
    }
    
    public static PBox vbox(final Object... args) {
        return PBox.makeBox('Y', args);
    }
    
    public static PBox zbox(final Object... args) {
        return PBox.makeBox('Z', args);
    }
    
    public static Rectangle2D rectangle(final Point2D p) {
        return rectangle(p, null);
    }
    
    public static Rectangle2D rectangle(final Point2D p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   java/awt/geom/Point2D.getX:()D
        //     4: dstore_2       
        //     5: aload_0         /* p1 */
        //     6: invokevirtual   java/awt/geom/Point2D.getY:()D
        //     9: dstore          y
        //    11: aload_1         /* p2 */
        //    12: ifnonnull       30
        //    15: new             Ljava/awt/geom/Rectangle2D$Double;
        //    18: dup            
        //    19: dconst_0       
        //    20: dconst_0       
        //    21: dload_2         /* x */
        //    22: dload           y
        //    24: invokespecial   java/awt/geom/Rectangle2D$Double.<init>:(DDDD)V
        //    27: goto            127
        //    30: aload_1         /* p2 */
        //    31: instanceof      Ljava/awt/geom/Dimension2D;
        //    34: ifeq            74
        //    37: aload_1         /* p2 */
        //    38: ldc             Ljava/awt/geom/Dimension2D;.class
        //    40: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    43: dup            
        //    44: astore          7
        //    46: checkcast       Ljava/awt/geom/Dimension2D;
        //    49: astore          p
        //    51: new             Ljava/awt/geom/Rectangle2D$Double;
        //    54: dup            
        //    55: dload_2         /* x */
        //    56: dload           y
        //    58: aload           p
        //    60: invokevirtual   java/awt/geom/Dimension2D.getWidth:()D
        //    63: aload           p
        //    65: invokevirtual   java/awt/geom/Dimension2D.getHeight:()D
        //    68: invokespecial   java/awt/geom/Rectangle2D$Double.<init>:(DDDD)V
        //    71: goto            127
        //    74: aload_1         /* p2 */
        //    75: ldc             Ljava/awt/geom/Point2D;.class
        //    77: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    80: dup            
        //    81: astore          7
        //    83: checkcast       Ljava/awt/geom/Point2D;
        //    86: astore          p
        //    88: aload           p
        //    90: invokevirtual   java/awt/geom/Point2D.getX:()D
        //    93: dload_2         /* x */
        //    94: dsub           
        //    95: invokestatic    java/lang/Math.abs:(D)D
        //    98: dstore          w
        //   100: aload           p
        //   102: invokevirtual   java/awt/geom/Point2D.getY:()D
        //   105: dload           y
        //   107: dsub           
        //   108: invokestatic    java/lang/Math.abs:(D)D
        //   111: dstore          h
        //   113: new             Ljava/awt/geom/Rectangle2D$Double;
        //   116: dup            
        //   117: dload_2         /* x */
        //   118: dload           y
        //   120: dload           w
        //   122: dload           h
        //   124: invokespecial   java/awt/geom/Rectangle2D$Double.<init>:(DDDD)V
        //   127: areturn        
        //   128: new             Lgnu/mapping/WrongType;
        //   131: dup_x1         
        //   132: swap           
        //   133: ldc             "p"
        //   135: bipush          -2
        //   137: aload           7
        //   139: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   142: athrow         
        //   143: new             Lgnu/mapping/WrongType;
        //   146: dup_x1         
        //   147: swap           
        //   148: ldc             "p"
        //   150: bipush          -2
        //   152: aload           7
        //   154: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   157: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  46     49     128    143    Ljava/lang/ClassCastException;
        //  83     86     143    158    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object linePath(final boolean do$Mnclose, final Point2D initial, final Object... more$Mnpoints) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/awt/geom/GeneralPath.<init>:()V
        //     7: astore_3       
        //     8: aload_1         /* initial */
        //     9: invokevirtual   java/awt/geom/Point2D.getX:()D
        //    12: dstore          4
        //    14: aload_1         /* initial */
        //    15: invokevirtual   java/awt/geom/Point2D.getY:()D
        //    18: dstore          6
        //    20: aload_2         /* more$Mnpoints */
        //    21: arraylength    
        //    22: istore          n$Mnpoints
        //    24: aload_3         /* path */
        //    25: dload           curx
        //    27: dload           cury
        //    29: invokevirtual   java/awt/geom/GeneralPath.moveTo:(DD)V
        //    32: iconst_0       
        //    33: istore          i
        //    35: iload           i
        //    37: iload           n$Mnpoints
        //    39: if_icmpge       137
        //    42: aload_2         /* more$Mnpoints */
        //    43: iload           i
        //    45: aaload         
        //    46: astore          pt
        //    48: aload           pt
        //    50: instanceof      Ljava/awt/geom/Dimension2D;
        //    53: ifeq            94
        //    56: aload           pt
        //    58: ldc             Ljava/awt/geom/Dimension2D;.class
        //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    63: dup            
        //    64: astore          12
        //    66: checkcast       Ljava/awt/geom/Dimension2D;
        //    69: astore          p
        //    71: dload           curx
        //    73: aload           p
        //    75: invokevirtual   java/awt/geom/Dimension2D.getWidth:()D
        //    78: dadd           
        //    79: dstore          curx
        //    81: dload           cury
        //    83: aload           p
        //    85: invokevirtual   java/awt/geom/Dimension2D.getHeight:()D
        //    88: dadd           
        //    89: dstore          cury
        //    91: goto            123
        //    94: aload           pt
        //    96: ldc             Ljava/awt/geom/Point2D;.class
        //    98: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   101: dup            
        //   102: astore          12
        //   104: checkcast       Ljava/awt/geom/Point2D;
        //   107: astore          p
        //   109: aload           p
        //   111: invokevirtual   java/awt/geom/Point2D.getX:()D
        //   114: dstore          curx
        //   116: aload           p
        //   118: invokevirtual   java/awt/geom/Point2D.getY:()D
        //   121: dstore          cury
        //   123: aload_3         /* path */
        //   124: dload           curx
        //   126: dload           cury
        //   128: invokevirtual   java/awt/geom/GeneralPath.lineTo:(DD)V
        //   131: iinc            i, 1
        //   134: goto            35
        //   137: iload_0         /* do$Mnclose */
        //   138: ifeq            145
        //   141: aload_3         /* path */
        //   142: invokevirtual   java/awt/geom/GeneralPath.closePath:()V
        //   145: aload_3         /* path */
        //   146: areturn        
        //   147: new             Lgnu/mapping/WrongType;
        //   150: dup_x1         
        //   151: swap           
        //   152: ldc             "p"
        //   154: bipush          -2
        //   156: aload           12
        //   158: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   161: athrow         
        //   162: new             Lgnu/mapping/WrongType;
        //   165: dup_x1         
        //   166: swap           
        //   167: ldc             "p"
        //   169: bipush          -2
        //   171: aload           12
        //   173: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   176: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  66     69     147    162    Ljava/lang/ClassCastException;
        //  104    107    162    177    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object line(final Object initial, final Object... more$Mnpoints) {
        final boolean do$Mnclose = false;
        final Object force = Promise.force(initial, Point2D.class);
        try {
            return linePath(do$Mnclose, (Point2D)force, more$Mnpoints);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "line-path", 1, force);
        }
    }
    
    public static Object polygon(final Object initial, final Object... more$Mnpoints) {
        final boolean do$Mnclose = true;
        final Object force = Promise.force(initial, Point2D.class);
        try {
            return linePath(do$Mnclose, (Point2D)force, more$Mnpoints);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "line-path", 1, force);
        }
    }
    
    public static Ellipse2D.Double circle(final float radius) {
        return circle(radius, makePoint(pictures.Lit0, pictures.Lit0));
    }
    
    public static Ellipse2D.Double circle(final float radius, final Point2D center) {
        final DFloNum diam = DFloNum.make(2 * (double)radius);
        final double n = center.getX() - radius;
        final double n2 = center.getY() - radius;
        DFloNum dFloNum2;
        final DFloNum dFloNum = dFloNum2 = diam;
        double doubleValue;
        DFloNum dFloNum3;
        try {
            doubleValue = dFloNum.doubleValue();
            dFloNum3 = (dFloNum2 = diam);
            final double n3 = dFloNum3.doubleValue();
            return new Ellipse2D.Double(n, n2, doubleValue, n3);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "java.awt.geom.Ellipse2D$Double.<init>(double,double,double,double)", 3, dFloNum2);
        }
        try {
            final double n3 = dFloNum3.doubleValue();
            return new Ellipse2D.Double(n, n2, doubleValue, n3);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "java.awt.geom.Ellipse2D$Double.<init>(double,double,double,double)", 4, dFloNum2);
        }
    }
    
    public static Picture draw$V(final Object[] argsArray) {
        final LList args = LList.makeList(argsArray, 0);
        return DrawShape.makeDraw(args);
    }
    
    public static Shape borderShape(final Object widths, final boolean border, final Picture picture) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokeinterface gnu/kawa/models/Picture.getBounds2D:()Ljava/awt/geom/Rectangle2D;
        //     6: astore_3        /* bounds */
        //     7: aload_0         /* widths */
        //     8: instanceof      Ljava/awt/geom/Dimension2D;
        //    11: ifeq            56
        //    14: aload_0         /* widths */
        //    15: ldc             Ljava/awt/geom/Dimension2D;.class
        //    17: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    20: dup            
        //    21: astore          5
        //    23: checkcast       Ljava/awt/geom/Dimension2D;
        //    26: astore          d
        //    28: aload_3         /* bounds */
        //    29: iload_1         /* border */
        //    30: aload           d
        //    32: invokevirtual   java/awt/geom/Dimension2D.getHeight:()D
        //    35: aload           d
        //    37: invokevirtual   java/awt/geom/Dimension2D.getWidth:()D
        //    40: aload           d
        //    42: invokevirtual   java/awt/geom/Dimension2D.getHeight:()D
        //    45: aload           d
        //    47: invokevirtual   java/awt/geom/Dimension2D.getWidth:()D
        //    50: invokestatic    gnu/kawa/models/Pictures.borderShape:(Ljava/awt/geom/Rectangle2D;ZDDDD)Ljava/awt/Shape;
        //    53: goto            175
        //    56: aload_0         /* widths */
        //    57: instanceof      Ljava/awt/geom/Rectangle2D;
        //    60: ifeq            147
        //    63: aload_0         /* widths */
        //    64: ldc             Ljava/awt/geom/Rectangle2D;.class
        //    66: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    69: dup            
        //    70: astore          5
        //    72: checkcast       Ljava/awt/geom/Rectangle2D;
        //    75: astore          d
        //    77: aload_3         /* bounds */
        //    78: iload_1         /* border */
        //    79: aload_3         /* bounds */
        //    80: invokevirtual   java/awt/geom/RectangularShape.getY:()D
        //    83: aload           d
        //    85: invokevirtual   java/awt/geom/RectangularShape.getY:()D
        //    88: dsub           
        //    89: aload           d
        //    91: invokevirtual   java/awt/geom/RectangularShape.getX:()D
        //    94: aload           d
        //    96: invokevirtual   java/awt/geom/RectangularShape.getWidth:()D
        //    99: dadd           
        //   100: aload_3         /* bounds */
        //   101: invokevirtual   java/awt/geom/RectangularShape.getX:()D
        //   104: aload_3         /* bounds */
        //   105: invokevirtual   java/awt/geom/RectangularShape.getWidth:()D
        //   108: dadd           
        //   109: dsub           
        //   110: aload_3         /* bounds */
        //   111: invokevirtual   java/awt/geom/RectangularShape.getX:()D
        //   114: aload           d
        //   116: invokevirtual   java/awt/geom/RectangularShape.getX:()D
        //   119: dsub           
        //   120: aload           d
        //   122: invokevirtual   java/awt/geom/RectangularShape.getY:()D
        //   125: aload           d
        //   127: invokevirtual   java/awt/geom/RectangularShape.getHeight:()D
        //   130: dadd           
        //   131: aload_3         /* bounds */
        //   132: invokevirtual   java/awt/geom/RectangularShape.getY:()D
        //   135: aload_3         /* bounds */
        //   136: invokevirtual   java/awt/geom/RectangularShape.getHeight:()D
        //   139: dadd           
        //   140: dsub           
        //   141: invokestatic    gnu/kawa/models/Pictures.borderShape:(Ljava/awt/geom/Rectangle2D;ZDDDD)Ljava/awt/Shape;
        //   144: goto            175
        //   147: aload_0         /* widths */
        //   148: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   151: dup            
        //   152: astore          6
        //   154: checkcast       Ljava/lang/Number;
        //   157: invokevirtual   java/lang/Number.doubleValue:()D
        //   160: dstore          d
        //   162: aload_3         /* bounds */
        //   163: iload_1         /* border */
        //   164: dload           d
        //   166: dload           d
        //   168: dload           d
        //   170: dload           d
        //   172: invokestatic    gnu/kawa/models/Pictures.borderShape:(Ljava/awt/geom/Rectangle2D;ZDDDD)Ljava/awt/Shape;
        //   175: areturn        
        //   176: new             Lgnu/mapping/WrongType;
        //   179: dup_x1         
        //   180: swap           
        //   181: ldc             "d"
        //   183: bipush          -2
        //   185: aload           5
        //   187: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   190: athrow         
        //   191: new             Lgnu/mapping/WrongType;
        //   194: dup_x1         
        //   195: swap           
        //   196: ldc             "d"
        //   198: bipush          -2
        //   200: aload           5
        //   202: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   205: athrow         
        //   206: new             Lgnu/mapping/WrongType;
        //   209: dup_x1         
        //   210: swap           
        //   211: ldc             "d"
        //   213: bipush          -2
        //   215: aload           6
        //   217: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   220: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  23     26     176    191    Ljava/lang/ClassCastException;
        //  72     75     191    206    Ljava/lang/ClassCastException;
        //  154    160    206    221    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 110 out of bounds for length 110
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static BufferedImage imageRead(final Path uri) {
        return ImageIO.read(uri.openInputStream());
    }
    
    public static void imageWrite(final Object picture, final Object path) {
        final String fname = path.toString();
        final String lname = fname.toLowerCase();
        String s;
        if (lname.endsWith(".gif")) {
            s = "gif";
        }
        else {
            final boolean x = lname.endsWith("jpg");
            s = ((x ? x : lname.endsWith(".jpeg")) ? "jpg" : "png");
        }
        final String format = s;
        final RenderedImage img = $To$Image(picture);
        final RenderedImage bimg = (img instanceof DrawImage) ? ((DrawImage)img).getImage() : img;
        final OutputStream strm = Path.valueOf(path).openOutputStream();
        try {
            ImageIO.write(bimg, format, strm);
        }
        finally {
            strm.close();
        }
    }
    
    public static RenderedImage $To$Image(Object value) {
        value = Promise.force(value);
        return (value instanceof RenderedImage) ? ((RenderedImage)Promise.force(value, RenderedImage.class)) : gnu.kawa.models.Pictures.toImage($To$Picture(value));
    }
    
    public static int imageWidth(final RenderedImage image) {
        return image.getWidth();
    }
    
    public static int imageHeight(final RenderedImage image) {
        return image.getHeight();
    }
    
    public static Paint $To$Paint(final Object value) {
        if (value instanceof Paint) {
            return (Paint)Promise.force(value, Paint.class);
        }
        Label_0050: {
            if (!(value instanceof Integer)) {
                break Label_0050;
            }
            Color color = null;
            Paint paint = color;
            final Object force = Promise.force(value, Integer.class);
            try {
                color = new Color((int)force);
                return paint;
                // iftrue(Label_0071:, !value instanceof IntNum)
                paint = new Color(IntNum.intValue(value));
                return paint;
                Label_0071: {
                    final StandardColor c = gnu.kawa.models.StandardColor.valueOf(value.toString());
                }
                // iftrue(Label_0109:, c != null)
                throw new ClassCastException(Format.formatToString(0, "value ~a cannot be converted to a paint", value));
                final StandardColor c;
                Label_0109:
                paint = c;
                return paint;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "java.lang.Integer.intValue()", 1, force);
            }
        }
    }
    
    public static Picture $To$Picture(final Object value) {
        return gnu.kawa.models.Pictures.asPicture(value);
    }
    
    public static AffineTransform $To$Transform(final Object tr) {
        return (AffineTransform)Promise.force(tr, AffineTransform.class);
    }
    
    public static WithPaint withPaint(final Object paint, final Object pic) {
        return new WithPaint($To$Picture(pic), $To$Paint(paint));
    }
    
    public static Object withTransform(final Object tr, final Object pic) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/kawa/pictures.$To$Transform:(Ljava/lang/Object;)Ljava/awt/geom/AffineTransform;
        //     4: astore_2        /* tr */
        //     5: aload_1         /* pic */
        //     6: instanceof      Ljava/awt/Shape;
        //     9: ifeq            31
        //    12: aload_2         /* tr */
        //    13: aload_1         /* pic */
        //    14: ldc_w           Ljava/awt/Shape;.class
        //    17: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    20: dup            
        //    21: astore_3       
        //    22: checkcast       Ljava/awt/Shape;
        //    25: invokevirtual   java/awt/geom/AffineTransform.createTransformedShape:(Ljava/awt/Shape;)Ljava/awt/Shape;
        //    28: goto            112
        //    31: aload_1         /* pic */
        //    32: instanceof      Ljava/awt/geom/AffineTransform;
        //    35: ifeq            68
        //    38: new             Ljava/awt/geom/AffineTransform;
        //    41: dup            
        //    42: aload_2         /* tr */
        //    43: invokespecial   java/awt/geom/AffineTransform.<init>:(Ljava/awt/geom/AffineTransform;)V
        //    46: astore_3        /* trcopy */
        //    47: aload_3         /* trcopy */
        //    48: aload_1         /* pic */
        //    49: ldc_w           Ljava/awt/geom/AffineTransform;.class
        //    52: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    55: dup            
        //    56: astore          4
        //    58: checkcast       Ljava/awt/geom/AffineTransform;
        //    61: invokevirtual   java/awt/geom/AffineTransform.concatenate:(Ljava/awt/geom/AffineTransform;)V
        //    64: aload_3         /* trcopy */
        //    65: goto            112
        //    68: aload_1         /* pic */
        //    69: instanceof      Ljava/awt/geom/Point2D;
        //    72: ifeq            100
        //    75: new             Ljava/awt/geom/Point2D$Double;
        //    78: dup            
        //    79: invokespecial   java/awt/geom/Point2D$Double.<init>:()V
        //    82: astore_3        /* dst */
        //    83: aload_2         /* tr */
        //    84: aload_1         /* pic */
        //    85: ldc             Ljava/awt/geom/Point2D;.class
        //    87: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    90: checkcast       Ljava/awt/geom/Point2D;
        //    93: aload_3         /* dst */
        //    94: invokevirtual   java/awt/geom/AffineTransform.transform:(Ljava/awt/geom/Point2D;Ljava/awt/geom/Point2D;)Ljava/awt/geom/Point2D;
        //    97: goto            112
        //   100: new             Lgnu/kawa/models/WithTransform;
        //   103: dup            
        //   104: aload_1         /* pic */
        //   105: invokestatic    kawa/lib/kawa/pictures.$To$Picture:(Ljava/lang/Object;)Lgnu/kawa/models/Picture;
        //   108: aload_2         /* tr */
        //   109: invokespecial   gnu/kawa/models/WithTransform.<init>:(Lgnu/kawa/models/Picture;Ljava/awt/geom/AffineTransform;)V
        //   112: areturn        
        //   113: new             Lgnu/mapping/WrongType;
        //   116: dup_x1         
        //   117: swap           
        //   118: ldc_w           "java.awt.geom.AffineTransform.createTransformedShape(java.awt.Shape)"
        //   121: iconst_2       
        //   122: aload_3        
        //   123: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   126: athrow         
        //   127: new             Lgnu/mapping/WrongType;
        //   130: dup_x1         
        //   131: swap           
        //   132: ldc_w           "java.awt.geom.AffineTransform.concatenate(java.awt.geom.AffineTransform)"
        //   135: iconst_2       
        //   136: aload           4
        //   138: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   141: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  22     25     113    127    Ljava/lang/ClassCastException;
        //  58     61     127    142    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0068:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static WithComposite withComposite(final Object... arguments) {
        return WithComposite.make(arguments);
    }
    
    public static void pictureWriteSvg(final Object picture, final Path name) {
        pictureWriteSvg(picture, name, true);
    }
    
    public static void pictureWriteSvg(final Object picture, final Path name, final boolean headers) {
        final OutPort port = OutPort.openFile(name);
        try {
            SVGUtils.toSVG($To$Picture(picture), port, headers);
        }
        finally {
            port.close();
        }
    }
    
    public static KElement picture$To$SvgNode(final Object picture) {
        return SVGUtils.toSVGNode($To$Picture(picture));
    }
    
    static double angleToRadian(final Number val) {
        Label_0125: {
            if (!(val instanceof DQuantity)) {
                break Label_0125;
            }
            try {
                final DQuantity qval = (DQuantity)val;
                final Unit unit = qval.unit();
                final double dval = qval.doubleValue();
                if (unit != Unit.Empty) {
                    final boolean x = unit == Unit.degree;
                    Label_0108: {
                        if (x) {
                            if (!x) {
                                break Label_0108;
                            }
                        }
                        else {
                            final boolean x2 = unit == Unit.radian;
                            if (x2) {
                                if (!x2) {
                                    break Label_0108;
                                }
                            }
                            else if (unit != Unit.gradian) {
                                break Label_0108;
                            }
                        }
                        return dval;
                    }
                    exceptions.error("invalid unit for angle");
                    throw Special.reachedUnexpected;
                }
                return dval * (Math.PI / 180.0);
                // iftrue(Label_0161:, !val instanceof RealNum)
                return ((Number)Promise.force(MultiplyOp.$St.apply2(val, Math.PI / 180.0))).doubleValue();
                while (true) {
                    exceptions.error("not a real number for angle");
                    throw Special.reachedUnexpected;
                    doubleValue = ((Number)Promise.force(MultiplyOp.$St.apply2(val, Math.PI / 180.0))).doubleValue();
                    return doubleValue;
                    Label_0185: {
                        doubleValue = val.doubleValue() * (Math.PI / 180.0);
                    }
                    return doubleValue;
                    Label_0161:
                    continue;
                }
            }
            // iftrue(Label_0185:, !val instanceof Numeric)
            catch (ClassCastException ex) {
                throw new WrongType(ex, "qval", -2, val);
            }
        }
    }
    
    static {
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
        Lit6 = new SyntaxRules(pictures.Lit40, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", pictures.Lit40, 1, "pictures.scm:12"), "\u0000", "\t\u0004\u0011\u0018\f\t\u0014\t\u0010\u0002", new Object[] { new SyntaxForms.SimpleSyntaxForm(pictures.Lit41, TemplateScope.make("kawa.lib.syntax")), Lit4 = Symbol.valueOf("make-Dimension"), new SyntaxForms.SimpleSyntaxForm(pictures.Lit42, TemplateScope.make("kawa.lib.syntax")) }, 0) }, 1, Lit5 = Symbol.make(pictures.Lit43, "D"));
        Lit3 = new SyntaxRules(pictures.Lit40, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", pictures.Lit40, 1, "pictures.scm:10"), "\u0000", "\t\u0004\u0011\u0018\f\t\u0014\t\u0010\u0002", new Object[] { new SyntaxForms.SimpleSyntaxForm(pictures.Lit41, TemplateScope.make("kawa.lib.syntax")), Lit1 = Symbol.valueOf("make-Point"), new SyntaxForms.SimpleSyntaxForm(pictures.Lit42, TemplateScope.make("kawa.lib.syntax")) }, 0) }, 1, Lit2 = Symbol.make(pictures.Lit43, "P"));
        Lit0 = IntNum.valueOf(0);
        RenderedImage = RenderedImage.class;
        BufferedImage = BufferedImage.class;
        AffineTransform = AffineTransform.class;
        StandardColor = StandardColor.class;
        Pictures = Pictures.class;
        Picture = Picture.class;
        DrawImage = DrawImage.class;
        DDimension = DDimension.class;
        pictures.$instance = new pictures();
        final pictures $instance5 = pictures.$instance;
        make$MnPoint = new ModuleMethod($instance5, 1, pictures.Lit1, 8194);
        P = Macro.make(pictures.Lit2, pictures.Lit3, "kawa.lib.kawa.pictures");
        make$MnDimension = new ModuleMethod($instance5, 2, pictures.Lit4, 8194);
        D = Macro.make(pictures.Lit5, pictures.Lit6, "kawa.lib.kawa.pictures");
        picture$Mnbounds = new ModuleMethod($instance5, 3, pictures.Lit7, 4097);
        hbox = new ModuleMethod($instance5, 4, pictures.Lit8, -4096);
        vbox = new ModuleMethod($instance5, 5, pictures.Lit9, -4096);
        zbox = new ModuleMethod($instance5, 6, pictures.Lit10, -4096);
        rectangle = new ModuleMethod($instance5, 7, pictures.Lit11, 8193);
        line$Mnpath = new ModuleMethod($instance5, 9, pictures.Lit12, -4094);
        line = new ModuleMethod($instance5, 10, pictures.Lit13, -4095);
        polygon = new ModuleMethod($instance5, 11, pictures.Lit14, -4095);
        circle = new ModuleMethod($instance5, 12, pictures.Lit15, 8193);
        final GenericProc fill2 = new GenericProc("fill");
        pictures $instance = pictures.$instance;
        final ModuleMethod method = new ModuleMethod($instance, 14, null, 4097);
        method.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:78");
        fill2.add(method);
        pictures $instance2 = pictures.$instance;
        final ModuleMethod method2 = new ModuleMethod($instance2, 15, null, 8194);
        method2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:80");
        fill2.add(method2);
        fill = fill2;
        draw = new ModuleMethod($instance5, 16, pictures.Lit16, -4096);
        border$Mnshape = new ModuleMethod($instance5, 17, pictures.Lit17, 12291);
        final GenericProc border2 = new GenericProc("border");
        $instance = pictures.$instance;
        final ModuleMethod method3 = new ModuleMethod($instance, 18, null, 12291);
        method3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:107");
        border2.add(method3);
        $instance2 = pictures.$instance;
        final ModuleMethod method4 = new ModuleMethod($instance2, 19, null, 8194);
        method4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:112");
        border2.add(method4);
        pictures $instance3 = pictures.$instance;
        final ModuleMethod method5 = new ModuleMethod($instance3, 20, null, 4097);
        method5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:117");
        border2.add(method5);
        border = border2;
        final GenericProc padding2 = new GenericProc("padding");
        $instance = pictures.$instance;
        final ModuleMethod method6 = new ModuleMethod($instance, 21, null, 12291);
        method6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:121");
        padding2.add(method6);
        $instance2 = pictures.$instance;
        final ModuleMethod method7 = new ModuleMethod($instance2, 22, null, 8194);
        method7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:126");
        padding2.add(method7);
        padding = padding2;
        final GenericProc image2 = new GenericProc("image");
        $instance = pictures.$instance;
        final ModuleMethod method8 = new ModuleMethod($instance, 23, null, -4096);
        method8.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:130");
        image2.add(method8);
        $instance2 = pictures.$instance;
        final ModuleMethod method9 = new ModuleMethod($instance2, 24, null, 4097);
        method9.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:132");
        image2.add(method9);
        $instance3 = pictures.$instance;
        final ModuleMethod method10 = new ModuleMethod($instance3, 25, null, 4097);
        method10.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:134");
        image2.add(method10);
        image = image2;
        image$Mnread = new ModuleMethod($instance5, 26, pictures.Lit20, 4097);
        image$Mnwrite = new ModuleMethod($instance5, 27, pictures.Lit21, 8194);
        image$Mnwidth = new ModuleMethod($instance5, 28, pictures.Lit22, 4097);
        image$Mnheight = new ModuleMethod($instance5, 29, pictures.Lit23, 4097);
        $Mn$Grpaint = new ModuleMethod($instance5, 30, pictures.Lit24, 4097);
        $Mn$Grimage = new ModuleMethod($instance5, 31, pictures.Lit25, 4097);
        $Mn$Grpicture = new ModuleMethod($instance5, 32, pictures.Lit26, 4097);
        $Mn$Grtransform = new ModuleMethod($instance5, 33, pictures.Lit27, 4097);
        with$Mnpaint = new ModuleMethod($instance5, 34, pictures.Lit28, 8194);
        with$Mntransform = new ModuleMethod($instance5, 35, pictures.Lit29, 8194);
        with$Mncomposite = new ModuleMethod($instance5, 36, pictures.Lit30, -4096);
        final GenericProc rotate2 = new GenericProc("rotate");
        $instance = pictures.$instance;
        final ModuleMethod method11 = new ModuleMethod($instance, 37, null, 4097);
        method11.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:228");
        rotate2.add(method11);
        $instance2 = pictures.$instance;
        final ModuleMethod method12 = new ModuleMethod($instance2, 38, null, 8194);
        method12.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:230");
        rotate2.add(method12);
        rotate = rotate2;
        final GenericProc scale2 = new GenericProc("scale");
        $instance = pictures.$instance;
        final ModuleMethod method13 = new ModuleMethod($instance, 39, null, 4097);
        method13.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:234");
        scale2.add(method13);
        $instance2 = pictures.$instance;
        final ModuleMethod method14 = new ModuleMethod($instance2, 40, null, 4097);
        method14.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:236");
        scale2.add(method14);
        $instance3 = pictures.$instance;
        final ModuleMethod method15 = new ModuleMethod($instance3, 41, null, 4097);
        method15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:238");
        scale2.add(method15);
        final pictures $instance4 = pictures.$instance;
        final ModuleMethod method16 = new ModuleMethod($instance4, 42, null, 8194);
        method16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:240");
        scale2.add(method16);
        scale = scale2;
        final GenericProc translate2 = new GenericProc("translate");
        $instance = pictures.$instance;
        final ModuleMethod method17 = new ModuleMethod($instance, 43, null, 4097);
        method17.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:244");
        translate2.add(method17);
        $instance2 = pictures.$instance;
        final ModuleMethod method18 = new ModuleMethod($instance2, 44, null, 4097);
        method18.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:246");
        translate2.add(method18);
        $instance3 = pictures.$instance;
        final ModuleMethod method19 = new ModuleMethod($instance3, 45, null, 8194);
        method19.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:248");
        translate2.add(method19);
        translate = translate2;
        final GenericProc re$Mncenter2 = new GenericProc("re-center");
        $instance = pictures.$instance;
        final ModuleMethod method20 = new ModuleMethod($instance, 46, null, 12291);
        method20.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:252");
        re$Mncenter2.add(method20);
        $instance2 = pictures.$instance;
        final ModuleMethod method21 = new ModuleMethod($instance2, 47, null, 8194);
        method21.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:276");
        re$Mncenter2.add(method21);
        $instance3 = pictures.$instance;
        final ModuleMethod method22 = new ModuleMethod($instance3, 48, null, 4097);
        method22.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:283");
        re$Mncenter2.add(method22);
        re$Mncenter = re$Mncenter2;
        final GenericProc affine$Mntransform2 = new GenericProc("affine-transform");
        $instance = pictures.$instance;
        final ModuleMethod method23 = new ModuleMethod($instance, 49, null, 24582);
        method23.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:287");
        affine$Mntransform2.add(method23);
        $instance2 = pictures.$instance;
        final ModuleMethod method24 = new ModuleMethod($instance2, 50, null, 12291);
        method24.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:291");
        affine$Mntransform2.add(method24);
        affine$Mntransform = affine$Mntransform2;
        picture$Mnwrite$Mnsvg = new ModuleMethod($instance5, 51, pictures.Lit38, 12290);
        picture$Mn$Grsvg$Mnnode = new ModuleMethod($instance5, 53, pictures.Lit39, 4097);
        $runBody$();
    }
    
    public pictures() {
        ModuleInfo.register(this);
    }
    
    public static Picture lambda1(final Shape shape) {
        return new FillShape(shape);
    }
    
    public static WithPaint lambda2(final Object paint, final Shape shape) {
        return withPaint(paint, new FillShape(shape));
    }
    
    public static PBox lambda3(final Object widths, final Object paint, final Object picture) {
        final Picture pic = $To$Picture(picture);
        return PBox.makeBox('Z', pictures.fill.apply2(paint, borderShape(widths, true, pic)), pic);
    }
    
    public static PBox lambda4(final Object widths, final Object picture) {
        final Picture pic = $To$Picture(picture);
        return PBox.makeBox('Z', pictures.fill.apply1(borderShape(widths, true, pic)), pic);
    }
    
    public static Object lambda5(final Object picture) {
        return pictures.border.apply2(pictures.Lit18, picture);
    }
    
    public static PBox lambda6(final Object widths, final Object background, final Object picture) {
        final Picture pic = $To$Picture(picture);
        return PBox.makeBox('Z', pictures.fill.apply2(background, borderShape(widths, false, pic)), pic);
    }
    
    public static Object lambda7(final Object widths, final Object picture) {
        return pictures.padding.apply3(widths, gnu.kawa.models.StandardColor.transparent, picture);
    }
    
    public static DrawImage lambda8$V(final Object[] argsArray) {
        final Object src = Keyword.searchForKeyword(argsArray, 0, pictures.Lit19, Boolean.FALSE);
        final DrawImage drawImage = new DrawImage();
        final Object force = Promise.force(src, Path.class);
        try {
            drawImage.setSrc(Path.valueOf(force));
            return drawImage;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "gnu.kawa.models.DrawImage.setSrc(path)", 2, force);
        }
    }
    
    public static DrawImage lambda9(final BufferedImage image) {
        return new DrawImage(image);
    }
    
    public static DrawImage lambda10(final Object image) {
        return new DrawImage(gnu.kawa.models.Pictures.toImage($To$Picture(image)));
    }
    
    public static AffineTransform lambda11(final Object angle) {
        final Object force = Promise.force(angle, Number.class);
        try {
            return java.awt.geom.AffineTransform.getRotateInstance(angleToRadian((Number)force));
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "angle-to-radian", 0, force);
        }
    }
    
    public static Object lambda12(final Object angle, final Object picture) {
        return withTransform(pictures.rotate.apply1(angle), picture);
    }
    
    public static AffineTransform lambda13(final Dimension2D sc) {
        return java.awt.geom.AffineTransform.getScaleInstance(sc.getWidth(), sc.getHeight());
    }
    
    public static AffineTransform lambda14(final Point2D sc) {
        return java.awt.geom.AffineTransform.getScaleInstance(sc.getX(), sc.getY());
    }
    
    public static AffineTransform lambda15(final RealNum sc) {
        RealNum realNum = sc;
        double doubleValue;
        try {
            doubleValue = sc.doubleValue();
            realNum = sc;
            final double n = sc.doubleValue();
            return java.awt.geom.AffineTransform.getScaleInstance(doubleValue, n);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "java.awt.geom.AffineTransform.getScaleInstance(double,double)", 1, realNum);
        }
        try {
            final double n = sc.doubleValue();
            return java.awt.geom.AffineTransform.getScaleInstance(doubleValue, n);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "java.awt.geom.AffineTransform.getScaleInstance(double,double)", 2, realNum);
        }
    }
    
    public static Object lambda16(final Object sc, final Object picture) {
        return withTransform(pictures.scale.apply1(sc), picture);
    }
    
    public static AffineTransform lambda17(final Dimension2D delta) {
        return java.awt.geom.AffineTransform.getTranslateInstance(delta.getWidth(), delta.getHeight());
    }
    
    public static AffineTransform lambda18(final Point2D delta) {
        return java.awt.geom.AffineTransform.getTranslateInstance(delta.getX(), delta.getY());
    }
    
    public static Object lambda19(final Object delta, final Object picture) {
        return withTransform(pictures.translate.apply1(delta), picture);
    }
    
    public static Object lambda20(final Object xposition, final Object yposition, final Object picture) {
        final Picture pic = $To$Picture(picture);
        final Rectangle2D bounds = pic.getBounds2D();
        Object o = null;
        Label_0144: {
            if (xposition == pictures.Lit31) {
                o = bounds.getX();
            }
            else if (xposition == pictures.Lit32) {
                o = bounds.getX() + bounds.getWidth();
            }
            else {
                final boolean x = xposition == pictures.Lit33;
                Label_0110: {
                    if (x) {
                        if (!x) {
                            break Label_0110;
                        }
                    }
                    else if (xposition != pictures.Lit34) {
                        break Label_0110;
                    }
                    o = bounds.getX() + 0.5 * bounds.getWidth();
                    break Label_0144;
                }
                if (xposition != pictures.Lit35) {
                    exceptions.error("invalid x-position specifier", xposition);
                    throw Special.reachedUnexpected;
                }
                o = pictures.Lit0;
            }
        }
        final Object xgoal = o;
        Object o2 = null;
        Label_0277: {
            if (yposition == pictures.Lit36) {
                o2 = bounds.getY();
            }
            else if (yposition == pictures.Lit37) {
                o2 = bounds.getY() + bounds.getHeight();
            }
            else {
                final boolean x2 = yposition == pictures.Lit33;
                Label_0243: {
                    if (x2) {
                        if (!x2) {
                            break Label_0243;
                        }
                    }
                    else if (yposition != pictures.Lit34) {
                        break Label_0243;
                    }
                    o2 = bounds.getX() + 0.5 * bounds.getHeight();
                    break Label_0277;
                }
                if (yposition != pictures.Lit35) {
                    exceptions.error("invalid y-position specifier", yposition);
                    throw Special.reachedUnexpected;
                }
                o2 = pictures.Lit0;
            }
        }
        final Object ygoal = o2;
        return withTransform(pictures.translate.apply1(makePoint(AddOp.$Mn.apply1(xgoal), AddOp.$Mn.apply1(ygoal))), picture);
    }
    
    public static Object lambda21(final Object position, final Object picture) {
        final boolean x = position == pictures.Lit31;
        Label_0045: {
            if (x) {
                if (!x) {
                    break Label_0045;
                }
            }
            else if (position != pictures.Lit32) {
                break Label_0045;
            }
            return pictures.re$Mncenter.apply3(position, pictures.Lit33, picture);
        }
        final boolean x2 = position == pictures.Lit36;
        return (x2 ? x2 : (position == pictures.Lit37)) ? pictures.re$Mncenter.apply3(pictures.Lit33, position, picture) : pictures.re$Mncenter.apply3(position, position, picture);
    }
    
    public static Object lambda22(final Object picture) {
        return pictures.re$Mncenter.apply3(pictures.Lit33, pictures.Lit33, picture);
    }
    
    public static AffineTransform lambda23(final double m00, final double m10, final double m01, final double m11, final double m02, final double m12) {
        return new AffineTransform(m00, m10, m01, m11, m02, m12);
    }
    
    public static AffineTransform lambda24(final Point2D px, final Point2D py, final Point2D p0) {
        return new AffineTransform(px.getX(), px.getY(), py.getX(), py.getY(), p0.getX(), p0.getY());
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 48: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 44: {
                final Object force = Promise.force(arg1, Point2D.class);
                if (!(force instanceof Point2D)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 43: {
                final Object force2 = Promise.force(arg1, Dimension2D.class);
                if (!(force2 instanceof Dimension2D)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 41: {
                final Object force3 = Promise.force(arg1, RealNum.class);
                if (RealNum.asRealNumOrNull(force3) != null) {
                    ctx.value1 = force3;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 40: {
                final Object force4 = Promise.force(arg1, Point2D.class);
                if (!(force4 instanceof Point2D)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 39: {
                final Object force5 = Promise.force(arg1, Dimension2D.class);
                if (!(force5 instanceof Dimension2D)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 37: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 25: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 24: {
                final Object force6 = Promise.force(arg1, BufferedImage.class);
                if (!(force6 instanceof BufferedImage)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 20: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 14: {
                final Object force7 = Promise.force(arg1, Shape.class);
                if (!(force7 instanceof Shape)) {
                    return -786431;
                }
                ctx.value1 = force7;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 53: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 33: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 32: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 31: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 30: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 29: {
                final Object force8 = Promise.force(arg1, RenderedImage.class);
                if (!(force8 instanceof RenderedImage)) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 28: {
                final Object force9 = Promise.force(arg1, RenderedImage.class);
                if (!(force9 instanceof RenderedImage)) {
                    return -786431;
                }
                ctx.value1 = force9;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 26: {
                final Object force10 = Promise.force(arg1, Path.class);
                if (Path.coerceToPathOrNull(force10) != null) {
                    ctx.value1 = force10;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 12: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 7: {
                final Object force11 = Promise.force(arg1, Point2D.class);
                if (!(force11 instanceof Point2D)) {
                    return -786431;
                }
                ctx.value1 = force11;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 3: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(proc, arg1, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 47: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 45: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 42: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 38: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 22: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 19: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 15: {
                ctx.value1 = o;
                final Object force = Promise.force(o2, Shape.class);
                if (!(force instanceof Shape)) {
                    return -786430;
                }
                ctx.value2 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 51: {
                ctx.value1 = o;
                final Object force2 = Promise.force(o2, Path.class);
                if (Path.coerceToPathOrNull(force2) != null) {
                    ctx.value2 = force2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 35: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 34: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 27: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 12: {
                ctx.value1 = Promise.force(o);
                final Object force3 = Promise.force(o2, Point2D.class);
                if (!(force3 instanceof Point2D)) {
                    return -786430;
                }
                ctx.value2 = force3;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 7: {
                final Object force4 = Promise.force(o, Point2D.class);
                if (!(force4 instanceof Point2D)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 2: {
                ctx.value1 = Promise.force(o);
                ctx.value2 = Promise.force(o2);
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 1: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            default: {
                return super.match2(moduleMethod, o, o2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        switch (proc.selector) {
            case 50: {
                final Object force = Promise.force(arg1, Point2D.class);
                if (!(force instanceof Point2D)) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2, Point2D.class);
                if (!(force2 instanceof Point2D)) {
                    return -786430;
                }
                ctx.value2 = force2;
                final Object force3 = Promise.force(arg3, Point2D.class);
                if (!(force3 instanceof Point2D)) {
                    return -786429;
                }
                ctx.value3 = force3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 46: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 21: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 18: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 51: {
                ctx.value1 = arg1;
                final Object force4 = Promise.force(arg2, Path.class);
                if (Path.coerceToPathOrNull(force4) == null) {
                    return -786430;
                }
                ctx.value2 = force4;
                final Object force5 = Promise.force(arg3);
                if (force5 instanceof Boolean) {
                    ctx.value3 = force5;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 17: {
                ctx.value1 = arg1;
                final Object force6 = Promise.force(arg2);
                if (!(force6 instanceof Boolean)) {
                    return -786430;
                }
                ctx.value2 = force6;
                final Object force7 = Promise.force(arg3, Picture.class);
                if (!(force7 instanceof Picture)) {
                    return -786429;
                }
                ctx.value3 = force7;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            default: {
                return super.match3(proc, arg1, arg2, arg3, ctx);
            }
        }
    }
    
    @Override
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        switch (proc.selector) {
            case 49: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 23: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 36: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 16: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 11: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 10: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 9: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 6: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 5: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 4: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            default: {
                return super.matchN(proc, args, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                3: 192
        //                7: 197
        //               12: 210
        //               14: 294
        //               20: 308
        //               24: 313
        //               25: 327
        //               26: 224
        //               28: 237
        //               29: 253
        //               30: 269
        //               31: 274
        //               32: 279
        //               33: 284
        //               37: 332
        //               39: 337
        //               40: 350
        //               41: 363
        //               43: 377
        //               44: 390
        //               48: 403
        //               53: 289
        //          default: 408
        //        }
        //   192: aload_2        
        //   193: invokestatic    kawa/lib/kawa/pictures.pictureBounds:(Ljava/lang/Object;)Ljava/awt/geom/Rectangle2D;
        //   196: areturn        
        //   197: aload_2        
        //   198: ldc             Ljava/awt/geom/Point2D;.class
        //   200: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   203: checkcast       Ljava/awt/geom/Point2D;
        //   206: invokestatic    kawa/lib/kawa/pictures.rectangle:(Ljava/awt/geom/Point2D;)Ljava/awt/geom/Rectangle2D;
        //   209: areturn        
        //   210: aload_2        
        //   211: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   214: checkcast       Ljava/lang/Number;
        //   217: invokevirtual   java/lang/Number.floatValue:()F
        //   220: invokestatic    kawa/lib/kawa/pictures.circle:(F)Ljava/awt/geom/Ellipse2D$Double;
        //   223: areturn        
        //   224: aload_2        
        //   225: ldc             Lgnu/kawa/io/Path;.class
        //   227: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   230: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   233: invokestatic    kawa/lib/kawa/pictures.imageRead:(Lgnu/kawa/io/Path;)Ljava/awt/image/BufferedImage;
        //   236: areturn        
        //   237: aload_2        
        //   238: ldc             Ljava/awt/image/RenderedImage;.class
        //   240: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   243: checkcast       Ljava/awt/image/RenderedImage;
        //   246: invokestatic    kawa/lib/kawa/pictures.imageWidth:(Ljava/awt/image/RenderedImage;)I
        //   249: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   252: areturn        
        //   253: aload_2        
        //   254: ldc             Ljava/awt/image/RenderedImage;.class
        //   256: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   259: checkcast       Ljava/awt/image/RenderedImage;
        //   262: invokestatic    kawa/lib/kawa/pictures.imageHeight:(Ljava/awt/image/RenderedImage;)I
        //   265: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   268: areturn        
        //   269: aload_2        
        //   270: invokestatic    kawa/lib/kawa/pictures.$To$Paint:(Ljava/lang/Object;)Ljava/awt/Paint;
        //   273: areturn        
        //   274: aload_2        
        //   275: invokestatic    kawa/lib/kawa/pictures.$To$Image:(Ljava/lang/Object;)Ljava/awt/image/RenderedImage;
        //   278: areturn        
        //   279: aload_2        
        //   280: invokestatic    kawa/lib/kawa/pictures.$To$Picture:(Ljava/lang/Object;)Lgnu/kawa/models/Picture;
        //   283: areturn        
        //   284: aload_2        
        //   285: invokestatic    kawa/lib/kawa/pictures.$To$Transform:(Ljava/lang/Object;)Ljava/awt/geom/AffineTransform;
        //   288: areturn        
        //   289: aload_2        
        //   290: invokestatic    kawa/lib/kawa/pictures.picture$To$SvgNode:(Ljava/lang/Object;)Lgnu/kawa/xml/KElement;
        //   293: areturn        
        //   294: aload_2        
        //   295: ldc_w           Ljava/awt/Shape;.class
        //   298: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   301: checkcast       Ljava/awt/Shape;
        //   304: invokestatic    kawa/lib/kawa/pictures.lambda1:(Ljava/awt/Shape;)Lgnu/kawa/models/Picture;
        //   307: areturn        
        //   308: aload_2        
        //   309: invokestatic    kawa/lib/kawa/pictures.lambda5:(Ljava/lang/Object;)Ljava/lang/Object;
        //   312: areturn        
        //   313: aload_2        
        //   314: ldc_w           Ljava/awt/image/BufferedImage;.class
        //   317: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   320: checkcast       Ljava/awt/image/BufferedImage;
        //   323: invokestatic    kawa/lib/kawa/pictures.lambda9:(Ljava/awt/image/BufferedImage;)Lgnu/kawa/models/DrawImage;
        //   326: areturn        
        //   327: aload_2        
        //   328: invokestatic    kawa/lib/kawa/pictures.lambda10:(Ljava/lang/Object;)Lgnu/kawa/models/DrawImage;
        //   331: areturn        
        //   332: aload_2        
        //   333: invokestatic    kawa/lib/kawa/pictures.lambda11:(Ljava/lang/Object;)Ljava/awt/geom/AffineTransform;
        //   336: areturn        
        //   337: aload_2        
        //   338: ldc             Ljava/awt/geom/Dimension2D;.class
        //   340: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   343: checkcast       Ljava/awt/geom/Dimension2D;
        //   346: invokestatic    kawa/lib/kawa/pictures.lambda13:(Ljava/awt/geom/Dimension2D;)Ljava/awt/geom/AffineTransform;
        //   349: areturn        
        //   350: aload_2        
        //   351: ldc             Ljava/awt/geom/Point2D;.class
        //   353: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   356: checkcast       Ljava/awt/geom/Point2D;
        //   359: invokestatic    kawa/lib/kawa/pictures.lambda14:(Ljava/awt/geom/Point2D;)Ljava/awt/geom/AffineTransform;
        //   362: areturn        
        //   363: aload_2        
        //   364: ldc_w           Lgnu/math/RealNum;.class
        //   367: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   370: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   373: invokestatic    kawa/lib/kawa/pictures.lambda15:(Lgnu/math/RealNum;)Ljava/awt/geom/AffineTransform;
        //   376: areturn        
        //   377: aload_2        
        //   378: ldc             Ljava/awt/geom/Dimension2D;.class
        //   380: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   383: checkcast       Ljava/awt/geom/Dimension2D;
        //   386: invokestatic    kawa/lib/kawa/pictures.lambda17:(Ljava/awt/geom/Dimension2D;)Ljava/awt/geom/AffineTransform;
        //   389: areturn        
        //   390: aload_2        
        //   391: ldc             Ljava/awt/geom/Point2D;.class
        //   393: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   396: checkcast       Ljava/awt/geom/Point2D;
        //   399: invokestatic    kawa/lib/kawa/pictures.lambda18:(Ljava/awt/geom/Point2D;)Ljava/awt/geom/AffineTransform;
        //   402: areturn        
        //   403: aload_2        
        //   404: invokestatic    kawa/lib/kawa/pictures.lambda22:(Ljava/lang/Object;)Ljava/lang/Object;
        //   407: areturn        
        //   408: aload_0        
        //   409: aload_1        
        //   410: aload_2        
        //   411: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   414: areturn        
        //   415: new             Lgnu/mapping/WrongType;
        //   418: dup_x1         
        //   419: swap           
        //   420: ldc_w           "rectangle"
        //   423: iconst_1       
        //   424: aload_2        
        //   425: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   428: athrow         
        //   429: new             Lgnu/mapping/WrongType;
        //   432: dup_x1         
        //   433: swap           
        //   434: ldc_w           "circle"
        //   437: iconst_1       
        //   438: aload_2        
        //   439: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   442: athrow         
        //   443: new             Lgnu/mapping/WrongType;
        //   446: dup_x1         
        //   447: swap           
        //   448: ldc_w           "image-read"
        //   451: iconst_1       
        //   452: aload_2        
        //   453: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   456: athrow         
        //   457: new             Lgnu/mapping/WrongType;
        //   460: dup_x1         
        //   461: swap           
        //   462: ldc_w           "image-width"
        //   465: iconst_1       
        //   466: aload_2        
        //   467: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   470: athrow         
        //   471: new             Lgnu/mapping/WrongType;
        //   474: dup_x1         
        //   475: swap           
        //   476: ldc_w           "image-height"
        //   479: iconst_1       
        //   480: aload_2        
        //   481: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   484: athrow         
        //   485: new             Lgnu/mapping/WrongType;
        //   488: dup_x1         
        //   489: swap           
        //   490: ldc_w           "lambda"
        //   493: iconst_1       
        //   494: aload_2        
        //   495: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   498: athrow         
        //   499: new             Lgnu/mapping/WrongType;
        //   502: dup_x1         
        //   503: swap           
        //   504: ldc_w           "lambda"
        //   507: iconst_1       
        //   508: aload_2        
        //   509: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   512: athrow         
        //   513: new             Lgnu/mapping/WrongType;
        //   516: dup_x1         
        //   517: swap           
        //   518: ldc_w           "lambda"
        //   521: iconst_1       
        //   522: aload_2        
        //   523: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   526: athrow         
        //   527: new             Lgnu/mapping/WrongType;
        //   530: dup_x1         
        //   531: swap           
        //   532: ldc_w           "lambda"
        //   535: iconst_1       
        //   536: aload_2        
        //   537: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   540: athrow         
        //   541: new             Lgnu/mapping/WrongType;
        //   544: dup_x1         
        //   545: swap           
        //   546: ldc_w           "lambda"
        //   549: iconst_1       
        //   550: aload_2        
        //   551: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   554: athrow         
        //   555: new             Lgnu/mapping/WrongType;
        //   558: dup_x1         
        //   559: swap           
        //   560: ldc_w           "lambda"
        //   563: iconst_1       
        //   564: aload_2        
        //   565: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   568: athrow         
        //   569: new             Lgnu/mapping/WrongType;
        //   572: dup_x1         
        //   573: swap           
        //   574: ldc_w           "lambda"
        //   577: iconst_1       
        //   578: aload_2        
        //   579: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   582: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  203    206    415    429    Ljava/lang/ClassCastException;
        //  214    220    429    443    Ljava/lang/ClassCastException;
        //  230    233    443    457    Ljava/lang/ClassCastException;
        //  243    246    457    471    Ljava/lang/ClassCastException;
        //  259    262    471    485    Ljava/lang/ClassCastException;
        //  301    304    485    499    Ljava/lang/ClassCastException;
        //  320    323    499    513    Ljava/lang/ClassCastException;
        //  343    346    513    527    Ljava/lang/ClassCastException;
        //  356    359    527    541    Ljava/lang/ClassCastException;
        //  370    373    541    555    Ljava/lang/ClassCastException;
        //  383    386    555    569    Ljava/lang/ClassCastException;
        //  396    399    569    583    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 208 out of bounds for length 208
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                1: 136
        //                2: 142
        //                7: 166
        //               12: 180
        //               15: 241
        //               19: 256
        //               22: 262
        //               27: 203
        //               34: 212
        //               35: 218
        //               38: 268
        //               42: 274
        //               45: 280
        //               47: 286
        //               51: 224
        //          default: 292
        //        }
        //   136: aload_2        
        //   137: aload_3        
        //   138: invokestatic    kawa/lib/kawa/pictures.makePoint:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/awt/geom/Point2D$Double;
        //   141: areturn        
        //   142: aload_2        
        //   143: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   146: checkcast       Ljava/lang/Number;
        //   149: invokevirtual   java/lang/Number.doubleValue:()D
        //   152: aload_3        
        //   153: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   156: checkcast       Ljava/lang/Number;
        //   159: invokevirtual   java/lang/Number.doubleValue:()D
        //   162: invokestatic    kawa/lib/kawa/pictures.makeDimension:(DD)Lgnu/kawa/models/DDimension;
        //   165: areturn        
        //   166: aload_2        
        //   167: ldc             Ljava/awt/geom/Point2D;.class
        //   169: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   172: checkcast       Ljava/awt/geom/Point2D;
        //   175: aload_3        
        //   176: invokestatic    kawa/lib/kawa/pictures.rectangle:(Ljava/awt/geom/Point2D;Ljava/lang/Object;)Ljava/awt/geom/Rectangle2D;
        //   179: areturn        
        //   180: aload_2        
        //   181: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   184: checkcast       Ljava/lang/Number;
        //   187: invokevirtual   java/lang/Number.floatValue:()F
        //   190: aload_3        
        //   191: ldc             Ljava/awt/geom/Point2D;.class
        //   193: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   196: checkcast       Ljava/awt/geom/Point2D;
        //   199: invokestatic    kawa/lib/kawa/pictures.circle:(FLjava/awt/geom/Point2D;)Ljava/awt/geom/Ellipse2D$Double;
        //   202: areturn        
        //   203: aload_2        
        //   204: aload_3        
        //   205: invokestatic    kawa/lib/kawa/pictures.imageWrite:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   208: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   211: areturn        
        //   212: aload_2        
        //   213: aload_3        
        //   214: invokestatic    kawa/lib/kawa/pictures.withPaint:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/models/WithPaint;
        //   217: areturn        
        //   218: aload_2        
        //   219: aload_3        
        //   220: invokestatic    kawa/lib/kawa/pictures.withTransform:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   223: areturn        
        //   224: aload_2        
        //   225: aload_3        
        //   226: ldc             Lgnu/kawa/io/Path;.class
        //   228: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   231: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   234: invokestatic    kawa/lib/kawa/pictures.pictureWriteSvg:(Ljava/lang/Object;Lgnu/kawa/io/Path;)V
        //   237: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   240: areturn        
        //   241: aload_2        
        //   242: aload_3        
        //   243: ldc_w           Ljava/awt/Shape;.class
        //   246: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   249: checkcast       Ljava/awt/Shape;
        //   252: invokestatic    kawa/lib/kawa/pictures.lambda2:(Ljava/lang/Object;Ljava/awt/Shape;)Lgnu/kawa/models/WithPaint;
        //   255: areturn        
        //   256: aload_2        
        //   257: aload_3        
        //   258: invokestatic    kawa/lib/kawa/pictures.lambda4:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/models/PBox;
        //   261: areturn        
        //   262: aload_2        
        //   263: aload_3        
        //   264: invokestatic    kawa/lib/kawa/pictures.lambda7:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   267: areturn        
        //   268: aload_2        
        //   269: aload_3        
        //   270: invokestatic    kawa/lib/kawa/pictures.lambda12:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   273: areturn        
        //   274: aload_2        
        //   275: aload_3        
        //   276: invokestatic    kawa/lib/kawa/pictures.lambda16:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   279: areturn        
        //   280: aload_2        
        //   281: aload_3        
        //   282: invokestatic    kawa/lib/kawa/pictures.lambda19:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   285: areturn        
        //   286: aload_2        
        //   287: aload_3        
        //   288: invokestatic    kawa/lib/kawa/pictures.lambda21:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   291: areturn        
        //   292: aload_0        
        //   293: aload_1        
        //   294: aload_2        
        //   295: aload_3        
        //   296: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   299: areturn        
        //   300: new             Lgnu/mapping/WrongType;
        //   303: dup_x1         
        //   304: swap           
        //   305: ldc_w           "make-Dimension"
        //   308: iconst_1       
        //   309: aload_2        
        //   310: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   313: athrow         
        //   314: new             Lgnu/mapping/WrongType;
        //   317: dup_x1         
        //   318: swap           
        //   319: ldc_w           "make-Dimension"
        //   322: iconst_2       
        //   323: aload_3        
        //   324: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   327: athrow         
        //   328: new             Lgnu/mapping/WrongType;
        //   331: dup_x1         
        //   332: swap           
        //   333: ldc_w           "rectangle"
        //   336: iconst_1       
        //   337: aload_2        
        //   338: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   341: athrow         
        //   342: new             Lgnu/mapping/WrongType;
        //   345: dup_x1         
        //   346: swap           
        //   347: ldc_w           "circle"
        //   350: iconst_1       
        //   351: aload_2        
        //   352: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   355: athrow         
        //   356: new             Lgnu/mapping/WrongType;
        //   359: dup_x1         
        //   360: swap           
        //   361: ldc_w           "circle"
        //   364: iconst_2       
        //   365: aload_3        
        //   366: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   369: athrow         
        //   370: new             Lgnu/mapping/WrongType;
        //   373: dup_x1         
        //   374: swap           
        //   375: ldc_w           "picture-write-svg"
        //   378: iconst_2       
        //   379: aload_3        
        //   380: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   383: athrow         
        //   384: new             Lgnu/mapping/WrongType;
        //   387: dup_x1         
        //   388: swap           
        //   389: ldc_w           "lambda"
        //   392: iconst_2       
        //   393: aload_3        
        //   394: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   397: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  146    152    300    314    Ljava/lang/ClassCastException;
        //  156    162    314    328    Ljava/lang/ClassCastException;
        //  172    175    328    342    Ljava/lang/ClassCastException;
        //  184    190    342    356    Ljava/lang/ClassCastException;
        //  196    199    356    370    Ljava/lang/ClassCastException;
        //  231    234    370    384    Ljava/lang/ClassCastException;
        //  249    252    384    398    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 148 out of bounds for length 148
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply3(final ModuleMethod p0, final Object p1, final Object p2, final Object p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //               17: 64
        //               18: 127
        //               21: 135
        //               46: 143
        //               50: 151
        //               51: 94
        //          default: 183
        //        }
        //    64: aload_2        
        //    65: aload_3        
        //    66: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    69: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    72: ifeq            79
        //    75: iconst_1       
        //    76: goto            80
        //    79: iconst_0       
        //    80: aload           4
        //    82: ldc             Lgnu/kawa/models/Picture;.class
        //    84: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    87: checkcast       Lgnu/kawa/models/Picture;
        //    90: invokestatic    kawa/lib/kawa/pictures.borderShape:(Ljava/lang/Object;ZLgnu/kawa/models/Picture;)Ljava/awt/Shape;
        //    93: areturn        
        //    94: aload_2        
        //    95: aload_3        
        //    96: ldc             Lgnu/kawa/io/Path;.class
        //    98: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   101: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   104: aload           4
        //   106: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   109: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   112: ifeq            119
        //   115: iconst_1       
        //   116: goto            120
        //   119: iconst_0       
        //   120: invokestatic    kawa/lib/kawa/pictures.pictureWriteSvg:(Ljava/lang/Object;Lgnu/kawa/io/Path;Z)V
        //   123: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   126: areturn        
        //   127: aload_2        
        //   128: aload_3        
        //   129: aload           4
        //   131: invokestatic    kawa/lib/kawa/pictures.lambda3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/models/PBox;
        //   134: areturn        
        //   135: aload_2        
        //   136: aload_3        
        //   137: aload           4
        //   139: invokestatic    kawa/lib/kawa/pictures.lambda6:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/models/PBox;
        //   142: areturn        
        //   143: aload_2        
        //   144: aload_3        
        //   145: aload           4
        //   147: invokestatic    kawa/lib/kawa/pictures.lambda20:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   150: areturn        
        //   151: aload_2        
        //   152: ldc             Ljava/awt/geom/Point2D;.class
        //   154: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   157: checkcast       Ljava/awt/geom/Point2D;
        //   160: aload_3        
        //   161: ldc             Ljava/awt/geom/Point2D;.class
        //   163: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   166: checkcast       Ljava/awt/geom/Point2D;
        //   169: aload           4
        //   171: ldc             Ljava/awt/geom/Point2D;.class
        //   173: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   176: checkcast       Ljava/awt/geom/Point2D;
        //   179: invokestatic    kawa/lib/kawa/pictures.lambda24:(Ljava/awt/geom/Point2D;Ljava/awt/geom/Point2D;Ljava/awt/geom/Point2D;)Ljava/awt/geom/AffineTransform;
        //   182: areturn        
        //   183: aload_0        
        //   184: aload_1        
        //   185: aload_2        
        //   186: aload_3        
        //   187: aload           4
        //   189: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   192: areturn        
        //   193: new             Lgnu/mapping/WrongType;
        //   196: dup_x1         
        //   197: swap           
        //   198: ldc_w           "border-shape"
        //   201: iconst_2       
        //   202: aload_3        
        //   203: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   206: athrow         
        //   207: new             Lgnu/mapping/WrongType;
        //   210: dup_x1         
        //   211: swap           
        //   212: ldc_w           "border-shape"
        //   215: iconst_3       
        //   216: aload           4
        //   218: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   221: athrow         
        //   222: new             Lgnu/mapping/WrongType;
        //   225: dup_x1         
        //   226: swap           
        //   227: ldc_w           "picture-write-svg"
        //   230: iconst_2       
        //   231: aload_3        
        //   232: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   235: athrow         
        //   236: new             Lgnu/mapping/WrongType;
        //   239: dup_x1         
        //   240: swap           
        //   241: ldc_w           "picture-write-svg"
        //   244: iconst_3       
        //   245: aload           4
        //   247: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   250: athrow         
        //   251: new             Lgnu/mapping/WrongType;
        //   254: dup_x1         
        //   255: swap           
        //   256: ldc_w           "lambda"
        //   259: iconst_1       
        //   260: aload_2        
        //   261: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   264: athrow         
        //   265: new             Lgnu/mapping/WrongType;
        //   268: dup_x1         
        //   269: swap           
        //   270: ldc_w           "lambda"
        //   273: iconst_2       
        //   274: aload_3        
        //   275: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   278: athrow         
        //   279: new             Lgnu/mapping/WrongType;
        //   282: dup_x1         
        //   283: swap           
        //   284: ldc_w           "lambda"
        //   287: iconst_3       
        //   288: aload           4
        //   290: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   293: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  69     80     193    207    Ljava/lang/ClassCastException;
        //  87     90     207    222    Ljava/lang/ClassCastException;
        //  101    104    222    236    Ljava/lang/ClassCastException;
        //  109    120    236    251    Ljava/lang/ClassCastException;
        //  157    160    251    265    Ljava/lang/ClassCastException;
        //  166    169    265    279    Ljava/lang/ClassCastException;
        //  176    179    279    294    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 124 out of bounds for length 124
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object applyN(final ModuleMethod p0, final Object[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                4: 96
        //                5: 101
        //                6: 106
        //                9: 111
        //               10: 174
        //               11: 208
        //               16: 242
        //               23: 252
        //               36: 247
        //               49: 257
        //          default: 345
        //        }
        //    96: aload_2        
        //    97: invokestatic    kawa/lib/kawa/pictures.hbox:([Ljava/lang/Object;)Lgnu/kawa/models/PBox;
        //   100: areturn        
        //   101: aload_2        
        //   102: invokestatic    kawa/lib/kawa/pictures.vbox:([Ljava/lang/Object;)Lgnu/kawa/models/PBox;
        //   105: areturn        
        //   106: aload_2        
        //   107: invokestatic    kawa/lib/kawa/pictures.zbox:([Ljava/lang/Object;)Lgnu/kawa/models/PBox;
        //   110: areturn        
        //   111: aload_2        
        //   112: iconst_0       
        //   113: aaload         
        //   114: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   117: dup            
        //   118: astore_3       
        //   119: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   122: ifeq            129
        //   125: iconst_1       
        //   126: goto            130
        //   129: iconst_0       
        //   130: aload_2        
        //   131: iconst_1       
        //   132: aaload         
        //   133: ldc             Ljava/awt/geom/Point2D;.class
        //   135: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   138: dup            
        //   139: astore_3       
        //   140: checkcast       Ljava/awt/geom/Point2D;
        //   143: aload_2        
        //   144: arraylength    
        //   145: iconst_2       
        //   146: isub           
        //   147: istore_3       
        //   148: iload_3        
        //   149: anewarray       Ljava/lang/Object;
        //   152: goto            163
        //   155: dup            
        //   156: iload_3        
        //   157: aload_2        
        //   158: iload_3        
        //   159: iconst_2       
        //   160: iadd           
        //   161: aaload         
        //   162: aastore        
        //   163: iinc            3, -1
        //   166: iload_3        
        //   167: ifge            155
        //   170: invokestatic    kawa/lib/kawa/pictures.linePath:(ZLjava/awt/geom/Point2D;[Ljava/lang/Object;)Ljava/lang/Object;
        //   173: areturn        
        //   174: aload_2        
        //   175: iconst_0       
        //   176: aaload         
        //   177: aload_2        
        //   178: arraylength    
        //   179: iconst_1       
        //   180: isub           
        //   181: istore_3       
        //   182: iload_3        
        //   183: anewarray       Ljava/lang/Object;
        //   186: goto            197
        //   189: dup            
        //   190: iload_3        
        //   191: aload_2        
        //   192: iload_3        
        //   193: iconst_1       
        //   194: iadd           
        //   195: aaload         
        //   196: aastore        
        //   197: iinc            3, -1
        //   200: iload_3        
        //   201: ifge            189
        //   204: invokestatic    kawa/lib/kawa/pictures.line:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   207: areturn        
        //   208: aload_2        
        //   209: iconst_0       
        //   210: aaload         
        //   211: aload_2        
        //   212: arraylength    
        //   213: iconst_1       
        //   214: isub           
        //   215: istore_3       
        //   216: iload_3        
        //   217: anewarray       Ljava/lang/Object;
        //   220: goto            231
        //   223: dup            
        //   224: iload_3        
        //   225: aload_2        
        //   226: iload_3        
        //   227: iconst_1       
        //   228: iadd           
        //   229: aaload         
        //   230: aastore        
        //   231: iinc            3, -1
        //   234: iload_3        
        //   235: ifge            223
        //   238: invokestatic    kawa/lib/kawa/pictures.polygon:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   241: areturn        
        //   242: aload_2        
        //   243: invokestatic    kawa/lib/kawa/pictures.draw$V:([Ljava/lang/Object;)Lgnu/kawa/models/Picture;
        //   246: areturn        
        //   247: aload_2        
        //   248: invokestatic    kawa/lib/kawa/pictures.withComposite:([Ljava/lang/Object;)Lgnu/kawa/models/WithComposite;
        //   251: areturn        
        //   252: aload_2        
        //   253: invokestatic    kawa/lib/kawa/pictures.lambda8$V:([Ljava/lang/Object;)Lgnu/kawa/models/DrawImage;
        //   256: areturn        
        //   257: aload_2        
        //   258: iconst_0       
        //   259: aaload         
        //   260: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   263: dup            
        //   264: astore_3       
        //   265: checkcast       Ljava/lang/Number;
        //   268: invokevirtual   java/lang/Number.doubleValue:()D
        //   271: aload_2        
        //   272: iconst_1       
        //   273: aaload         
        //   274: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   277: dup            
        //   278: astore_3       
        //   279: checkcast       Ljava/lang/Number;
        //   282: invokevirtual   java/lang/Number.doubleValue:()D
        //   285: aload_2        
        //   286: iconst_2       
        //   287: aaload         
        //   288: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   291: dup            
        //   292: astore_3       
        //   293: checkcast       Ljava/lang/Number;
        //   296: invokevirtual   java/lang/Number.doubleValue:()D
        //   299: aload_2        
        //   300: iconst_3       
        //   301: aaload         
        //   302: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   305: dup            
        //   306: astore_3       
        //   307: checkcast       Ljava/lang/Number;
        //   310: invokevirtual   java/lang/Number.doubleValue:()D
        //   313: aload_2        
        //   314: iconst_4       
        //   315: aaload         
        //   316: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   319: dup            
        //   320: astore_3       
        //   321: checkcast       Ljava/lang/Number;
        //   324: invokevirtual   java/lang/Number.doubleValue:()D
        //   327: aload_2        
        //   328: iconst_5       
        //   329: aaload         
        //   330: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   333: dup            
        //   334: astore_3       
        //   335: checkcast       Ljava/lang/Number;
        //   338: invokevirtual   java/lang/Number.doubleValue:()D
        //   341: invokestatic    kawa/lib/kawa/pictures.lambda23:(DDDDDD)Ljava/awt/geom/AffineTransform;
        //   344: areturn        
        //   345: aload_0        
        //   346: aload_1        
        //   347: aload_2        
        //   348: invokespecial   gnu/expr/ModuleBody.applyN:(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
        //   351: areturn        
        //   352: new             Lgnu/mapping/WrongType;
        //   355: dup_x1         
        //   356: swap           
        //   357: ldc             "line-path"
        //   359: iconst_1       
        //   360: aload_3        
        //   361: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   364: athrow         
        //   365: new             Lgnu/mapping/WrongType;
        //   368: dup_x1         
        //   369: swap           
        //   370: ldc             "line-path"
        //   372: iconst_2       
        //   373: aload_3        
        //   374: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   377: athrow         
        //   378: new             Lgnu/mapping/WrongType;
        //   381: dup_x1         
        //   382: swap           
        //   383: ldc_w           "lambda"
        //   386: iconst_1       
        //   387: aload_3        
        //   388: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   391: athrow         
        //   392: new             Lgnu/mapping/WrongType;
        //   395: dup_x1         
        //   396: swap           
        //   397: ldc_w           "lambda"
        //   400: iconst_2       
        //   401: aload_3        
        //   402: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   405: athrow         
        //   406: new             Lgnu/mapping/WrongType;
        //   409: dup_x1         
        //   410: swap           
        //   411: ldc_w           "lambda"
        //   414: iconst_3       
        //   415: aload_3        
        //   416: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   419: athrow         
        //   420: new             Lgnu/mapping/WrongType;
        //   423: dup_x1         
        //   424: swap           
        //   425: ldc_w           "lambda"
        //   428: iconst_4       
        //   429: aload_3        
        //   430: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   433: athrow         
        //   434: new             Lgnu/mapping/WrongType;
        //   437: dup_x1         
        //   438: swap           
        //   439: ldc_w           "lambda"
        //   442: iconst_5       
        //   443: aload_3        
        //   444: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   447: athrow         
        //   448: new             Lgnu/mapping/WrongType;
        //   451: dup_x1         
        //   452: swap           
        //   453: ldc_w           "lambda"
        //   456: bipush          6
        //   458: aload_3        
        //   459: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   462: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  119    130    352    365    Ljava/lang/ClassCastException;
        //  140    143    365    378    Ljava/lang/ClassCastException;
        //  265    271    378    392    Ljava/lang/ClassCastException;
        //  279    285    392    406    Ljava/lang/ClassCastException;
        //  293    299    406    420    Ljava/lang/ClassCastException;
        //  307    313    420    434    Ljava/lang/ClassCastException;
        //  321    327    434    448    Ljava/lang/ClassCastException;
        //  335    341    448    463    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 228 out of bounds for length 228
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
