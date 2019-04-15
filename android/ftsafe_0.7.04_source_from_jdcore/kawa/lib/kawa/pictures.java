package kawa.lib.kawa; import gnu.expr.ModuleMethod;

public class pictures extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
  }
  





  public static gnu.kawa.models.DDimension makeDimension(double w, double h)
  {
    return new gnu.kawa.models.DDimension(w, h);
  }
  
  public static java.awt.geom.Rectangle2D pictureBounds(Object picture) {
    return gnu.kawa.models.Pictures.asPicture(picture).getBounds2D();
  }
  


  public static final Class DDimension;
  

  public static final Class DrawImage;
  

  public static final Class Picture;
  

  public static final Class Pictures;
  

  public static final Class StandardColor;
  

  public static final Class AffineTransform;
  

  public static final Class BufferedImage;
  

  public static final Class RenderedImage;
  

  public static final ModuleMethod make$MnPoint;
  

  @gnu.expr.SourceName(name="P", uri="http://kawa.gnu.org/construct", prefix="$construct$")
  public static final kawa.lang.Macro P;
  

  public static final ModuleMethod make$MnDimension;
  

  @gnu.expr.SourceName(name="D", uri="http://kawa.gnu.org/construct", prefix="$construct$")
  public static final kawa.lang.Macro D;
  

  public static final ModuleMethod picture$Mnbounds;
  

  public static final ModuleMethod hbox;
  

  public static final ModuleMethod vbox;
  

  public static final ModuleMethod zbox;
  

  public static final ModuleMethod rectangle;
  

  public static final ModuleMethod line;
  

  public static final ModuleMethod polygon;
  

  public static final ModuleMethod circle;
  

  public static final gnu.expr.GenericProc fill;
  

  public static final ModuleMethod draw;
  

  public static final ModuleMethod border$Mnshape;
  

  public static final gnu.expr.GenericProc border;
  

  public static final gnu.expr.GenericProc padding;
  

  public static final gnu.expr.GenericProc image;
  

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
  

  public static final gnu.expr.GenericProc rotate;
  

  public static final gnu.expr.GenericProc scale;
  

  public static final gnu.expr.GenericProc translate;
  

  public static final gnu.expr.GenericProc re$Mncenter;
  

  public static final gnu.expr.GenericProc affine$Mntransform;
  

  public static final ModuleMethod picture$Mnwrite$Mnsvg;
  

  public static final ModuleMethod picture$Mn$Grsvg$Mnnode;
  

  static final ModuleMethod line$Mnpath;
  

  static final gnu.math.IntNum Lit0;
  

  public static pictures $instance;
  

  static final gnu.mapping.SimpleSymbol Lit1;
  

  static final gnu.mapping.Symbol Lit2;
  

  static final kawa.lang.SyntaxRules Lit3;
  

  static final gnu.mapping.SimpleSymbol Lit4;
  

  static final gnu.mapping.Symbol Lit5;
  

  static final kawa.lang.SyntaxRules Lit6;
  

  static final gnu.mapping.SimpleSymbol Lit7;
  

  static final gnu.mapping.SimpleSymbol Lit8;
  

  static final gnu.mapping.SimpleSymbol Lit9;
  

  static final gnu.mapping.SimpleSymbol Lit10;
  

  static final gnu.mapping.SimpleSymbol Lit11;
  

  static final gnu.mapping.SimpleSymbol Lit12;
  

  static final gnu.mapping.SimpleSymbol Lit13;
  

  static final gnu.mapping.SimpleSymbol Lit14;
  

  static final gnu.mapping.SimpleSymbol Lit15;
  

  static final gnu.mapping.SimpleSymbol Lit16;
  

  static final gnu.mapping.SimpleSymbol Lit17;
  

  static final gnu.math.DFloNum Lit18;
  

  static final gnu.expr.Keyword Lit19;
  

  static final gnu.mapping.SimpleSymbol Lit20;
  

  static final gnu.mapping.SimpleSymbol Lit21;
  

  static final gnu.mapping.SimpleSymbol Lit22;
  

  static final gnu.mapping.SimpleSymbol Lit23;
  

  static final gnu.mapping.SimpleSymbol Lit24;
  

  static final gnu.mapping.SimpleSymbol Lit25;
  

  static final gnu.mapping.SimpleSymbol Lit26;
  

  static final gnu.mapping.SimpleSymbol Lit27;
  

  static final gnu.mapping.SimpleSymbol Lit28;
  

  static final gnu.mapping.SimpleSymbol Lit29;
  

  static final gnu.mapping.SimpleSymbol Lit30;
  

  static final gnu.mapping.SimpleSymbol Lit31;
  

  static final gnu.mapping.SimpleSymbol Lit32;
  

  static final gnu.mapping.SimpleSymbol Lit33;
  

  static final gnu.mapping.SimpleSymbol Lit34;
  

  static final gnu.mapping.SimpleSymbol Lit35;
  

  static final gnu.mapping.SimpleSymbol Lit36;
  

  static final gnu.mapping.SimpleSymbol Lit37;
  

  static final gnu.mapping.SimpleSymbol Lit38;
  

  static final gnu.mapping.SimpleSymbol Lit39;
  
  static final Object[] Lit40;
  
  static final gnu.mapping.SimpleSymbol Lit41;
  
  static final gnu.mapping.SimpleSymbol Lit42;
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 49:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 23: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    








































































    case 36: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 16: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 11: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 10: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 9: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 6: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 5: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 4: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); }
  public static gnu.kawa.models.PBox hbox(Object... args) { return gnu.kawa.models.PBox.makeBox('X', args); }
  
  public static gnu.kawa.models.PBox vbox(Object... args) { return gnu.kawa.models.PBox.makeBox('Y', args); }
  
  public static gnu.kawa.models.PBox zbox(Object... args) { return gnu.kawa.models.PBox.makeBox('Z', args); }
  















  static Object linePath(boolean do$Mnclose, java.awt.geom.Point2D initial, Object... more$Mnpoints)
  {
    java.awt.geom.GeneralPath localGeneralPath1 = new java.awt.geom.GeneralPath();
    double d1 = initial.getX();
    double d2 = initial.getY();
    
    int n$Mnpoints = more$Mnpoints.length;
    double cury; double curx; java.awt.geom.GeneralPath path; path.moveTo(curx, cury);
    int i = 0; for (;;) { Object pt; if (i < n$Mnpoints)
      {



        pt = more$Mnpoints[i];
        if (!(pt instanceof java.awt.geom.Dimension2D)) {} }
      Object localObject1; try { java.awt.geom.Dimension2D p = (java.awt.geom.Dimension2D)(localObject1 = gnu.mapping.Promise.force(pt, java.awt.geom.Dimension2D.class));
        curx += p.getWidth();
        cury += p.getHeight();
      }
      catch (ClassCastException localClassCastException1)
      {
        java.awt.geom.Point2D p;
        throw new gnu.mapping.WrongType(localClassCastException1, "p", -2, localObject1);
      }
      try
      {
        p = (java.awt.geom.Point2D)(localObject1 = gnu.mapping.Promise.force(pt, java.awt.geom.Point2D.class));
        curx = p.getX();
        cury = p.getY();
        path.lineTo(curx, cury);i++;
      }
      catch (ClassCastException localClassCastException2)
      {
        throw new gnu.mapping.WrongType(localClassCastException2, "p", -2, localObject1);
      }
    }
    if (do$Mnclose)
      path.closePath();
    return path;
  }
  






  public static Object line(Object initial, Object... more$Mnpoints)
  {
    try
    {
      return linePath(false, (java.awt.geom.Point2D)(localObject = gnu.mapping.Promise.force(initial, java.awt.geom.Point2D.class)), more$Mnpoints); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "line-path", 1, localObject);
    } }
  
  public static Object polygon(Object initial, Object... more$Mnpoints) { try { return linePath(true, (java.awt.geom.Point2D)(localObject = gnu.mapping.Promise.force(initial, java.awt.geom.Point2D.class)), more$Mnpoints); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "line-path", 1, localObject);
    } }
  
  public static java.awt.geom.Ellipse2D.Double circle(float paramFloat) { return circle(paramFloat, makePoint(Lit0, Lit0)); }
  





  static final gnu.mapping.Namespace Lit43 = gnu.mapping.Namespace.valueOf("http://kawa.gnu.org/construct", "$construct$");
  
  public static gnu.kawa.models.Picture lambda1(java.awt.Shape shape) { return new gnu.kawa.models.FillShape(shape); }
  
  public static gnu.kawa.models.WithPaint lambda2(Object paint, java.awt.Shape shape) { return withPaint(paint, new gnu.kawa.models.FillShape(shape)); }
  
  public static gnu.kawa.models.Picture draw$V(Object[] argsArray) { gnu.lists.LList localLList1; gnu.lists.LList args = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    return gnu.kawa.models.DrawShape.makeDraw(localLList1 = args);
  }
  
  public static java.awt.Shape borderShape(Object widths, boolean border, gnu.kawa.models.Picture picture) { bounds = picture.getBounds2D();
    if ((widths instanceof java.awt.geom.Dimension2D)) {}
    try { java.awt.geom.Dimension2D d = (java.awt.geom.Dimension2D)(localObject1 = gnu.mapping.Promise.force(widths, java.awt.geom.Dimension2D.class));
      

      tmpTernaryOp = gnu.kawa.models.Pictures.borderShape(bounds, border, d.getHeight(), d.getWidth(), d.getHeight(), d.getWidth());
    } catch (ClassCastException localClassCastException2) {
      try { java.awt.geom.Rectangle2D d = (java.awt.geom.Rectangle2D)(localObject1 = gnu.mapping.Promise.force(widths, java.awt.geom.Rectangle2D.class));
        




        tmpTernaryOp = gnu.kawa.models.Pictures.borderShape(bounds, border, bounds.getY() - d.getY(), d.getX() + d.getWidth() - (bounds.getX() + bounds.getWidth()), bounds.getX() - d.getX(), d.getY() + d.getHeight() - (bounds.getY() + bounds.getHeight()));
      }
      catch (ClassCastException localClassCastException2)
      {
        Object localObject1;
        double d;
        throw new gnu.mapping.WrongType(localClassCastException2, "d", -2, localObject1);
      }
      




      try
      {
        d = ((Number)(localObject2 = gnu.mapping.Promise.force(widths))).doubleValue();
        return gnu.kawa.models.Pictures.borderShape(bounds, border, d, d, d, d);
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new gnu.mapping.WrongType(localClassCastException3, "d", -2, localObject2);
      }
      throw new gnu.mapping.WrongType(
      













        localClassCastException1, "d", -2, localObject1);
    }
    if (!(widths instanceof java.awt.geom.Rectangle2D)) {}
  }
  










  public static gnu.kawa.models.PBox lambda3(Object widths, Object paint, Object picture)
  {
    gnu.kawa.models.Picture pic = $To$Picture(picture);
    
    return gnu.kawa.models.PBox.makeBox('Z', new Object[] {fill.apply2(paint, borderShape(widths, true, pic)), pic });
  }
  
  public static gnu.kawa.models.PBox lambda4(Object widths, Object picture) { gnu.kawa.models.Picture pic = $To$Picture(picture);
    
    return gnu.kawa.models.PBox.makeBox('Z', new Object[] {fill.apply1(borderShape(widths, true, pic)), pic });
  }
  
  public static Object lambda5(Object picture) { return border.apply2(Lit18, picture); }
  
  public static gnu.kawa.models.PBox lambda6(Object widths, Object background, Object picture)
  {
    gnu.kawa.models.Picture pic = $To$Picture(picture);
    
    return gnu.kawa.models.PBox.makeBox('Z', new Object[] {fill.apply2(background, borderShape(widths, false, pic)), pic });
  }
  
  public static Object lambda7(Object widths, Object picture) { return padding.apply3(widths, gnu.kawa.models.StandardColor.transparent, picture); }
  
  public static gnu.kawa.models.DrawImage lambda8$V(Object[] argsArray) {
    Object src = gnu.expr.Keyword.searchForKeyword(argsArray, 0, Lit19, Boolean.FALSE); void 
      tmp19_16 = new gnu.kawa.models.DrawImage();
    try { tmp19_16.setSrc(gnu.kawa.io.Path.valueOf(localObject1 = gnu.mapping.Promise.force(src, gnu.kawa.io.Path.class)));return tmp19_16; } catch (ClassCastException localClassCastException) { Object localObject1; throw new gnu.mapping.WrongType(localClassCastException, "gnu.kawa.models.DrawImage.setSrc(path)", 2, localObject1); } }
  
  public static gnu.kawa.models.DrawImage lambda9(java.awt.image.BufferedImage image) { return new gnu.kawa.models.DrawImage(image); }
  
  public static gnu.kawa.models.DrawImage lambda10(Object image) { return new gnu.kawa.models.DrawImage(gnu.kawa.models.Pictures.toImage($To$Picture(image))); }
  

  public static java.awt.image.BufferedImage imageRead(gnu.kawa.io.Path uri) { return javax.imageio.ImageIO.read(uri.openInputStream()); }
  
  public static void imageWrite(Object picture, Object path) {
    String fname = path.toString();
    String lname = fname.toLowerCase();
    

    boolean x = lname.endsWith("jpg");
    

    String format = x ? x : lname.endsWith(".jpeg") ? "jpg" : lname.endsWith(".gif") ? "gif" : "png";
    java.awt.image.RenderedImage img = $To$Image(picture);
    java.awt.image.RenderedImage bimg = (img instanceof gnu.kawa.models.DrawImage) ? ((gnu.kawa.models.DrawImage)img).getImage() : img;
    java.io.OutputStream strm = gnu.kawa.io.Path.valueOf(path).openOutputStream();
    try {
      javax.imageio.ImageIO.write(bimg, format, strm);
    } finally { strm.close();
    } }
  
  public static int imageWidth(java.awt.image.RenderedImage image) { return image.getWidth(); }
  
  public static int imageHeight(java.awt.image.RenderedImage image) {
    return image.getHeight();
  }
  
  public static java.awt.Paint $To$Paint(Object value) {
    if ((value instanceof Integer))
    {
      tmpTernaryOp = new java.awt.Color(((Integer)(localObject = gnu.mapping.Promise.force(; }
    try {
      Object localObject;
      break label110;
      c = gnu.kawa.models.StandardColor.valueOf(value.toString());
      if (c == null)
        throw new ClassCastException(gnu.kawa.functions.Format.formatToString(0, new Object[] { "value ~a cannot be converted to a paint", value }));
      label110: return (value instanceof java.awt.Paint) ? (java.awt.Paint)gnu.mapping.Promise.force(value, java.awt.Paint.class) : (value instanceof gnu.math.IntNum) ? new java.awt.Color(gnu.math.IntNum.intValue(value)) : c;
    }
    catch (ClassCastException localClassCastException)
    {
      gnu.kawa.models.StandardColor c;
      throw new gnu.mapping.WrongType(
      





        localClassCastException, "java.lang.Integer.intValue()", 1, c);
    } }
  
  public static java.awt.image.RenderedImage $To$Image(Object value) { value = gnu.mapping.Promise.force(value);
    Object localObject = value;
    
    return (localObject instanceof java.awt.image.RenderedImage) ? (java.awt.image.RenderedImage)gnu.mapping.Promise.force(value, java.awt.image.RenderedImage.class) : gnu.kawa.models.Pictures.toImage($To$Picture(value));
  }
  
  public static gnu.kawa.models.Picture $To$Picture(Object value) { return gnu.kawa.models.Pictures.asPicture(value); }
  
  public static java.awt.geom.AffineTransform $To$Transform(Object tr) { return (java.awt.geom.AffineTransform)gnu.mapping.Promise.force(tr, java.awt.geom.AffineTransform.class); }
  


  public static gnu.kawa.models.WithPaint withPaint(Object paint, Object pic) { return new gnu.kawa.models.WithPaint($To$Picture(pic), $To$Paint(paint)); }
  
  public static Object withTransform(Object tr, Object pic) {
    tr = $To$Transform(tr);
    if ((pic instanceof java.awt.Shape)) {}
    try { Object localObject1; tmpTernaryOp = tr.createTransformedShape((java.awt.Shape)(localObject1 = gnu.mapping.Promise.force(pic, java.awt.Shape.class)));
    } catch (ClassCastException localClassCastException2) {
      try {
        java.awt.geom.AffineTransform trcopy;
        trcopy.concatenate((java.awt.geom.AffineTransform)(localObject2 = gnu.mapping.Promise.force(pic, java.awt.geom.AffineTransform.class)));
        tmpTernaryOp = trcopy;
        break label112;
        dst = new java.awt.geom.Point2D.Double();
        

        return (pic instanceof java.awt.geom.Point2D) ? tr.transform((java.awt.geom.Point2D)gnu.mapping.Promise.force(pic, java.awt.geom.Point2D.class), dst) : new gnu.kawa.models.WithTransform($To$Picture(pic), tr);
      }
      catch (ClassCastException localClassCastException2)
      {
        Object localObject2;
        java.awt.geom.Point2D.Double dst;
        throw new gnu.mapping.WrongType(localClassCastException2, "java.awt.geom.AffineTransform.concatenate(java.awt.geom.AffineTransform)", 2, localObject2);
      }
      throw new gnu.mapping.WrongType(
      








        localClassCastException1, "java.awt.geom.AffineTransform.createTransformedShape(java.awt.Shape)", 2, dst);
    }
    if ((pic instanceof java.awt.geom.AffineTransform))
    {
      trcopy = new java.awt.geom.AffineTransform(tr);
    }
  }
  






  public static gnu.kawa.models.WithComposite withComposite(Object... arguments) { return gnu.kawa.models.WithComposite.make(arguments); }
  
  static double angleToRadian(Number val) {
    if ((val instanceof gnu.math.DQuantity))
      Number localNumber = val; try { gnu.math.DQuantity qval = (gnu.math.DQuantity)val;
      unit = qval.unit();
      double dval = qval.doubleValue();
      

      boolean x = unit == gnu.math.Unit.degree; boolean x; if (x) if (!x)
          break label108; else { x = unit == gnu.math.Unit.radian;
      }
      label108:
      throw gnu.expr.Special.reachedUnexpected;
      

      if ((val instanceof gnu.math.Numeric)) {
        throw gnu.expr.Special.reachedUnexpected;
      }
      return (val instanceof gnu.math.RealNum) ? ((Number)gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(val, Double.valueOf(Math.PI / 180.0D)))).doubleValue() : x ? x : unit == gnu.math.Unit.gradian ? dval : unit == gnu.math.Unit.Empty ? dval * (Math.PI / 180.0D) : val.doubleValue() * (Math.PI / 180.0D);
    }
    catch (ClassCastException localClassCastException)
    {
      gnu.math.Unit unit;
      throw new gnu.mapping.WrongType(
      













        localClassCastException, "qval", -2, unit);
    }
  }
  
  public static java.awt.geom.AffineTransform lambda11(Object angle) { try { return java.awt.geom.AffineTransform.getRotateInstance(angleToRadian((Number)(localObject = gnu.mapping.Promise.force(angle, Number.class)))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "angle-to-radian", 0, localObject); } }
  
  public static Object lambda12(Object angle, Object picture) { return withTransform(rotate.apply1(angle), picture); }
  


  public static java.awt.geom.AffineTransform lambda13(java.awt.geom.Dimension2D sc) { return java.awt.geom.AffineTransform.getScaleInstance(sc.getWidth(), sc.getHeight()); }
  
  public static java.awt.geom.AffineTransform lambda14(java.awt.geom.Point2D sc) { return java.awt.geom.AffineTransform.getScaleInstance(sc.getX(), sc.getY()); }
  
  public static Object lambda16(Object sc, Object picture)
  {
    return withTransform(scale.apply1(sc), picture);
  }
  

  public static java.awt.geom.AffineTransform lambda17(java.awt.geom.Dimension2D delta) { return java.awt.geom.AffineTransform.getTranslateInstance(delta.getWidth(), delta.getHeight()); }
  
  public static java.awt.geom.AffineTransform lambda18(java.awt.geom.Point2D delta) { return java.awt.geom.AffineTransform.getTranslateInstance(delta.getX(), delta.getY()); }
  
  public static Object lambda19(Object delta, Object picture) { return withTransform(translate.apply1(delta), picture); }
  
  public static Object lambda20(Object xposition, Object yposition, Object picture)
  {
    gnu.kawa.models.Picture pic = $To$Picture(picture);
    java.awt.geom.Rectangle2D bounds = pic.getBounds2D();
    




    boolean x = xposition == Lit33;
    


    throw (xposition == Lit35 ? Lit0 : x ? x : xposition == Lit34 ? Double.valueOf(bounds.getX() + 0.5D * bounds.getWidth()) : xposition == Lit32 ? Double.valueOf(bounds.getX() + bounds.getWidth()) : xposition == Lit31 ? Double.valueOf(bounds.getX()) : gnu.expr.Special.reachedUnexpected);Object xgoal = kawa.lib.exceptions.error(new Object[] { "invalid x-position specifier", xposition });
    




    boolean x = yposition == Lit33;
    


    throw (yposition == Lit35 ? Lit0 : x ? x : yposition == Lit34 ? Double.valueOf(bounds.getX() + 0.5D * bounds.getHeight()) : yposition == Lit37 ? Double.valueOf(bounds.getY() + bounds.getHeight()) : yposition == Lit36 ? Double.valueOf(bounds.getY()) : gnu.expr.Special.reachedUnexpected);Object ygoal = kawa.lib.exceptions.error(new Object[] { "invalid y-position specifier", yposition });
    return withTransform(translate.apply1(makePoint(gnu.kawa.functions.AddOp.$Mn.apply1(xgoal), gnu.kawa.functions.AddOp.$Mn.apply1(ygoal))), picture); }
  
  public static Object lambda21(Object position, Object picture) { boolean x = position == Lit31;
    
    boolean x = position == Lit36;
    

    return x ? x : position == Lit37 ? re$Mncenter.apply3(Lit33, position, picture) : x ? x : position == Lit32 ? re$Mncenter.apply3(position, Lit33, picture) : re$Mncenter.apply3(position, position, picture);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 3:  return pictureBounds(paramObject);
    }
    
    




    try
    {
      return rectangle((java.awt.geom.Point2D)gnu.mapping.Promise.force(paramObject, java.awt.geom.Point2D.class)); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      

































































































































































































































































        localClassCastException1, "rectangle", 1, paramObject);
    }
    try
    {
      return circle(((Number)gnu.mapping.Promise.force(paramObject)).floatValue()); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "circle", 1, paramObject);
    }
    































































    try
    {
      return imageRead(gnu.kawa.io.Path.valueOf(gnu.mapping.Promise.force(paramObject, gnu.kawa.io.Path.class))); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "image-read", 1, paramObject);
    }
    














    try
    {
      return Integer.valueOf(imageWidth((java.awt.image.RenderedImage)gnu.mapping.Promise.force(paramObject, java.awt.image.RenderedImage.class))); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "image-width", 1, paramObject);
    }
    try {
      return Integer.valueOf(imageHeight((java.awt.image.RenderedImage)gnu.mapping.Promise.force(paramObject, java.awt.image.RenderedImage.class))); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "image-height", 1, paramObject);
    }
    
    return $To$Paint(paramObject);
    











    return $To$Image(paramObject);
    




    return $To$Picture(paramObject);
    

    return $To$Transform(paramObject);
    




















































































































    return picture$To$SvgNode(paramObject);
    try
    {
      return lambda1((java.awt.Shape)gnu.mapping.Promise.force(paramObject, java.awt.Shape.class)); } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(
      















































































        localClassCastException6, "lambda", 1, paramObject);
    }
    return lambda5(paramObject);
    











    try
    {
      return lambda9((java.awt.image.BufferedImage)gnu.mapping.Promise.force(paramObject, java.awt.image.BufferedImage.class)); } catch (ClassCastException localClassCastException7) { throw new gnu.mapping.WrongType(localClassCastException7, "lambda", 1, paramObject);
    }
    return lambda10(paramObject);
    




























































































    return lambda11(paramObject);
    


    try
    {
      return lambda13((java.awt.geom.Dimension2D)gnu.mapping.Promise.force(paramObject, java.awt.geom.Dimension2D.class)); } catch (ClassCastException localClassCastException8) { throw new gnu.mapping.WrongType(localClassCastException8, "lambda", 1, paramObject);
    }
    try { return lambda14((java.awt.geom.Point2D)gnu.mapping.Promise.force(paramObject, java.awt.geom.Point2D.class)); } catch (ClassCastException localClassCastException9) { throw new gnu.mapping.WrongType(localClassCastException9, "lambda", 1, paramObject);
    }
    try { return lambda15(gnu.kawa.lispexpr.LangObjType.coerceRealNum(gnu.mapping.Promise.force(paramObject, gnu.math.RealNum.class))); } catch (ClassCastException localClassCastException10) { throw new gnu.mapping.WrongType(localClassCastException10, "lambda", 1, paramObject);
    }
    

    try
    {
      return lambda17((java.awt.geom.Dimension2D)gnu.mapping.Promise.force(paramObject, java.awt.geom.Dimension2D.class)); } catch (ClassCastException localClassCastException11) { throw new gnu.mapping.WrongType(localClassCastException11, "lambda", 1, paramObject);
    }
    try { return lambda18((java.awt.geom.Point2D)gnu.mapping.Promise.force(paramObject, java.awt.geom.Point2D.class)); } catch (ClassCastException localClassCastException12) { throw new gnu.mapping.WrongType(localClassCastException12, "lambda", 1, paramObject);
    }
    


































    return lambda22(paramObject);return super.apply1(paramModuleMethod, paramObject); }
  public static Object lambda22(Object picture) { return re$Mncenter.apply3(Lit33, Lit33, picture); }
  


  public static java.awt.geom.AffineTransform lambda23(double m00, double m10, double m01, double m11, double m02, double m12)
  {
    return new java.awt.geom.AffineTransform(m00, m10, m01, m11, m02, m12);
  }
  
  static
  {
    Lit42 = gnu.mapping.Symbol.valueOf("$string$");Lit41 = gnu.mapping.Symbol.valueOf("%simple-construct-builder");Lit40 = new Object[0];Lit39 = gnu.mapping.Symbol.valueOf("picture->svg-node");Lit38 = gnu.mapping.Symbol.valueOf("picture-write-svg");Lit37 = gnu.mapping.Symbol.valueOf("bottom");Lit36 = gnu.mapping.Symbol.valueOf("top");Lit35 = gnu.mapping.Symbol.valueOf("origin");Lit34 = gnu.mapping.Symbol.valueOf("centre");Lit33 = gnu.mapping.Symbol.valueOf("center");Lit32 = gnu.mapping.Symbol.valueOf("right");Lit31 = gnu.mapping.Symbol.valueOf("left");Lit30 = gnu.mapping.Symbol.valueOf("with-composite");Lit29 = gnu.mapping.Symbol.valueOf("with-transform");Lit28 = gnu.mapping.Symbol.valueOf("with-paint");Lit27 = gnu.mapping.Symbol.valueOf("->transform");Lit26 = gnu.mapping.Symbol.valueOf("->picture");Lit25 = gnu.mapping.Symbol.valueOf("->image");Lit24 = gnu.mapping.Symbol.valueOf("->paint");Lit23 = gnu.mapping.Symbol.valueOf("image-height");Lit22 = gnu.mapping.Symbol.valueOf("image-width");Lit21 = gnu.mapping.Symbol.valueOf("image-write");Lit20 = gnu.mapping.Symbol.valueOf("image-read");Lit19 = gnu.expr.Keyword.make("src");Lit18 = gnu.math.DFloNum.valueOf(1.0D);Lit17 = gnu.mapping.Symbol.valueOf("border-shape");Lit16 = gnu.mapping.Symbol.valueOf("draw");Lit15 = gnu.mapping.Symbol.valueOf("circle");Lit14 = gnu.mapping.Symbol.valueOf("polygon");Lit13 = gnu.mapping.Symbol.valueOf("line");Lit12 = gnu.mapping.Symbol.valueOf("line-path");Lit11 = gnu.mapping.Symbol.valueOf("rectangle");Lit10 = gnu.mapping.Symbol.valueOf("zbox");Lit9 = gnu.mapping.Symbol.valueOf("vbox");Lit8 = gnu.mapping.Symbol.valueOf("hbox");Lit7 = gnu.mapping.Symbol.valueOf("picture-bounds"); kawa.lang.SyntaxRule[] tmp342_339 = new kawa.lang.SyntaxRule[1]; Object[] tmp375_372 = new Object[3]; Object[] tmp376_375 = tmp375_372;tmp376_375[0] = new kawa.lang.SyntaxForms.SimpleSyntaxForm(Lit41, kawa.lang.TemplateScope.make("kawa.lib.syntax")); Object[] tmp395_376 = tmp376_375; gnu.mapping.SimpleSymbol tmp403_400 = gnu.mapping.Symbol.valueOf("make-Dimension");Lit4 = tmp403_400;tmp395_376[1] = tmp403_400;tmp395_376[2] = new kawa.lang.SyntaxForms.SimpleSyntaxForm(Lit42, kawa.lang.TemplateScope.make("kawa.lib.syntax"));tmp342_339[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit40, 1, "pictures.scm:12"), "\000", "\t\004\021\030\f\t\024\t\020\002", tmp375_372, 0);Lit6 = new kawa.lang.SyntaxRules(Lit40, tmp342_339, 1, pictures.Lit5 = gnu.mapping.Symbol.make(Lit43, "D")); kawa.lang.SyntaxRule[] tmp462_459 = new kawa.lang.SyntaxRule[1]; Object[] tmp495_492 = new Object[3]; Object[] tmp496_495 = tmp495_492;tmp496_495[0] = new kawa.lang.SyntaxForms.SimpleSyntaxForm(Lit41, kawa.lang.TemplateScope.make("kawa.lib.syntax")); Object[] tmp515_496 = tmp496_495; gnu.mapping.SimpleSymbol tmp523_520 = gnu.mapping.Symbol.valueOf("make-Point");Lit1 = tmp523_520;tmp515_496[1] = tmp523_520;tmp515_496[2] = new kawa.lang.SyntaxForms.SimpleSyntaxForm(Lit42, kawa.lang.TemplateScope.make("kawa.lib.syntax"));tmp462_459[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit40, 1, "pictures.scm:10"), "\000", "\t\004\021\030\f\t\024\t\020\002", tmp495_492, 0);Lit3 = new kawa.lang.SyntaxRules(Lit40, tmp462_459, 1, pictures.Lit2 = gnu.mapping.Symbol.make(Lit43, "P"));Lit0 = gnu.math.IntNum.valueOf(0);RenderedImage = java.awt.image.RenderedImage.class;BufferedImage = java.awt.image.BufferedImage.class;AffineTransform = java.awt.geom.AffineTransform.class;StandardColor = gnu.kawa.models.StandardColor.class;Pictures = gnu.kawa.models.Pictures.class;Picture = gnu.kawa.models.Picture.class;DrawImage = gnu.kawa.models.DrawImage.class;DDimension = gnu.kawa.models.DDimension.class;$instance = new pictures();pictures localPictures1 = $instance;make$MnPoint = new ModuleMethod(localPictures1, 1, Lit1, 8194);P = kawa.lang.Macro.make(Lit2, Lit3, "kawa.lib.kawa.pictures");make$MnDimension = new ModuleMethod(localPictures1, 2, Lit4, 8194);D = kawa.lang.Macro.make(Lit5, Lit6, "kawa.lib.kawa.pictures");picture$Mnbounds = new ModuleMethod(localPictures1, 3, Lit7, 4097);hbox = new ModuleMethod(localPictures1, 4, Lit8, 61440);vbox = new ModuleMethod(localPictures1, 5, Lit9, 61440);zbox = new ModuleMethod(localPictures1, 6, Lit10, 61440);rectangle = new ModuleMethod(localPictures1, 7, Lit11, 8193);line$Mnpath = new ModuleMethod(localPictures1, 9, Lit12, 61442);line = new ModuleMethod(localPictures1, 10, Lit13, 61441);polygon = new ModuleMethod(localPictures1, 11, Lit14, 61441);circle = new ModuleMethod(localPictures1, 12, Lit15, 8193); void tmp879_876 = new gnu.expr.GenericProc("fill");
    pictures $instance = $instance; void tmp898_895 = new ModuleMethod($instance, 14, null, 4097);tmp898_895.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:78");tmp879_876.add(tmp898_895); void tmp911_879 = tmp879_876;
    
    pictures $instance = $instance; void tmp930_927 = new ModuleMethod($instance, 15, null, 8194);tmp930_927.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:80");tmp911_879.add(tmp930_927);fill = tmp911_879;draw = new ModuleMethod(localPictures1, 16, Lit16, 61440);border$Mnshape = new ModuleMethod(localPictures1, 17, Lit17, 12291); void 
    
























      tmp994_991 = new gnu.expr.GenericProc("border");
    pictures $instance = $instance; void tmp1013_1010 = new ModuleMethod($instance, 18, null, 12291);tmp1013_1010.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:107");tmp994_991.add(tmp1013_1010); void tmp1026_994 = tmp994_991;
    



    pictures $instance = $instance; void tmp1045_1042 = new ModuleMethod($instance, 19, null, 8194);tmp1045_1042.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:112");tmp1026_994.add(tmp1045_1042); void tmp1058_1026 = tmp1026_994;
    



    pictures $instance = $instance; void tmp1079_1076 = new ModuleMethod($instance, 20, null, 4097);tmp1079_1076.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:117");tmp1058_1026.add(tmp1079_1076);border = tmp1058_1026; void 
    

      tmp1105_1102 = new gnu.expr.GenericProc("padding");
    pictures $instance = $instance; void tmp1124_1121 = new ModuleMethod($instance, 21, null, 12291);tmp1124_1121.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:121");tmp1105_1102.add(tmp1124_1121); void tmp1137_1105 = tmp1105_1102;
    



    pictures $instance = $instance; void tmp1156_1153 = new ModuleMethod($instance, 22, null, 8194);tmp1156_1153.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:126");tmp1137_1105.add(tmp1156_1153);padding = tmp1137_1105; void 
    

      tmp1182_1179 = new gnu.expr.GenericProc("image");
    pictures $instance = $instance; void tmp1201_1198 = new ModuleMethod($instance, 23, null, 61440);tmp1201_1198.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:130");tmp1182_1179.add(tmp1201_1198); void tmp1214_1182 = tmp1182_1179;
    
    pictures $instance = $instance; void tmp1233_1230 = new ModuleMethod($instance, 24, null, 4097);tmp1233_1230.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:132");tmp1214_1182.add(tmp1233_1230); void tmp1246_1214 = tmp1214_1182;
    
    pictures $instance = $instance; void tmp1267_1264 = new ModuleMethod($instance, 25, null, 4097);tmp1267_1264.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:134");tmp1246_1214.add(tmp1267_1264);image = tmp1246_1214;image$Mnread = new ModuleMethod(localPictures1, 26, Lit20, 4097);image$Mnwrite = new ModuleMethod(localPictures1, 27, Lit21, 8194);image$Mnwidth = new ModuleMethod(localPictures1, 28, Lit22, 4097);image$Mnheight = new ModuleMethod(localPictures1, 29, Lit23, 4097);$Mn$Grpaint = new ModuleMethod(localPictures1, 30, Lit24, 4097);$Mn$Grimage = new ModuleMethod(localPictures1, 31, Lit25, 4097);$Mn$Grpicture = new ModuleMethod(localPictures1, 32, Lit26, 4097);$Mn$Grtransform = new ModuleMethod(localPictures1, 33, Lit27, 4097);with$Mnpaint = new ModuleMethod(localPictures1, 34, Lit28, 8194);with$Mntransform = new ModuleMethod(localPictures1, 35, Lit29, 8194);with$Mncomposite = new ModuleMethod(localPictures1, 36, Lit30, 61440); void 
    



























































































      tmp1502_1499 = new gnu.expr.GenericProc("rotate");
    pictures $instance = $instance; void tmp1521_1518 = new ModuleMethod($instance, 37, null, 4097);tmp1521_1518.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:228");tmp1502_1499.add(tmp1521_1518); void tmp1534_1502 = tmp1502_1499;
    
    pictures $instance = $instance; void tmp1553_1550 = new ModuleMethod($instance, 38, null, 8194);tmp1553_1550.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:230");tmp1534_1502.add(tmp1553_1550);rotate = tmp1534_1502; void 
    

      tmp1579_1576 = new gnu.expr.GenericProc("scale");
    pictures $instance = $instance; void tmp1598_1595 = new ModuleMethod($instance, 39, null, 4097);tmp1598_1595.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:234");tmp1579_1576.add(tmp1598_1595); void tmp1611_1579 = tmp1579_1576;
    
    pictures $instance = $instance; void tmp1630_1627 = new ModuleMethod($instance, 40, null, 4097);tmp1630_1627.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:236");tmp1611_1579.add(tmp1630_1627); void tmp1643_1611 = tmp1611_1579;
    
    pictures $instance = $instance; void tmp1664_1661 = new ModuleMethod($instance, 41, null, 4097);tmp1664_1661.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:238");tmp1643_1611.add(tmp1664_1661); void tmp1677_1643 = tmp1643_1611;
    
    pictures $instance = $instance; void tmp1698_1695 = new ModuleMethod($instance, 42, null, 8194);tmp1698_1695.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:240");tmp1677_1643.add(tmp1698_1695);scale = tmp1677_1643; void 
    

      tmp1724_1721 = new gnu.expr.GenericProc("translate");
    pictures $instance = $instance; void tmp1743_1740 = new ModuleMethod($instance, 43, null, 4097);tmp1743_1740.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:244");tmp1724_1721.add(tmp1743_1740); void tmp1756_1724 = tmp1724_1721;
    
    pictures $instance = $instance; void tmp1775_1772 = new ModuleMethod($instance, 44, null, 4097);tmp1775_1772.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:246");tmp1756_1724.add(tmp1775_1772); void tmp1788_1756 = tmp1756_1724;
    
    pictures $instance = $instance; void tmp1809_1806 = new ModuleMethod($instance, 45, null, 8194);tmp1809_1806.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:248");tmp1788_1756.add(tmp1809_1806);translate = tmp1788_1756; void 
    

      tmp1835_1832 = new gnu.expr.GenericProc("re-center");
    pictures $instance = $instance; void tmp1854_1851 = new ModuleMethod($instance, 46, null, 12291);tmp1854_1851.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:252");tmp1835_1832.add(tmp1854_1851); void tmp1867_1835 = tmp1835_1832;
    






















    pictures $instance = $instance; void tmp1886_1883 = new ModuleMethod($instance, 47, null, 8194);tmp1886_1883.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:276");tmp1867_1835.add(tmp1886_1883); void tmp1899_1867 = tmp1867_1835;
    





    pictures $instance = $instance; void tmp1920_1917 = new ModuleMethod($instance, 48, null, 4097);tmp1920_1917.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:283");tmp1899_1867.add(tmp1920_1917);re$Mncenter = tmp1899_1867; void 
    

      tmp1946_1943 = new gnu.expr.GenericProc("affine-transform");
    pictures $instance = $instance; void tmp1965_1962 = new ModuleMethod($instance, 49, null, 24582);tmp1965_1962.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:287");tmp1946_1943.add(tmp1965_1962); void tmp1978_1946 = tmp1946_1943;
    


    pictures $instance = $instance; void tmp1997_1994 = new ModuleMethod($instance, 50, null, 12291);tmp1997_1994.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/pictures.scm:291");tmp1978_1946.add(tmp1997_1994);affine$Mntransform = tmp1978_1946;picture$Mnwrite$Mnsvg = new ModuleMethod(localPictures1, 51, Lit38, 12290);picture$Mn$Grsvg$Mnnode = new ModuleMethod(localPictures1, 53, Lit39, 4097);$runBody$();
  }
  
  public static java.awt.geom.AffineTransform lambda24(java.awt.geom.Point2D px, java.awt.geom.Point2D py, java.awt.geom.Point2D p0) { return new java.awt.geom.AffineTransform(px.getX(), px.getY(), py.getX(), py.getY(), p0.getX(), p0.getY()); }
  
  public static void pictureWriteSvg(Object picture, gnu.kawa.io.Path name, boolean headers) {
    gnu.kawa.io.OutPort port = gnu.kawa.io.OutPort.openFile(name);
    try {
      gnu.kawa.models.SVGUtils.toSVG($To$Picture(picture), port, headers);
    } finally { port.close();
    } }
  
  public static gnu.kawa.xml.KElement picture$To$SvgNode(Object picture) { return gnu.kawa.models.SVGUtils.toSVGNode($To$Picture(picture)); }
  
  /* Error */
  public static java.awt.geom.Point2D.Double makePoint(Object x, Object y)
  {
    // Byte code:
    //   0: new 12	java/awt/geom/Point2D$Double
    //   3: dup
    //   4: aload_0
    //   5: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: dup
    //   9: astore_2
    //   10: checkcast 20	java/lang/Number
    //   13: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   16: aload_1
    //   17: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: dup
    //   21: astore_2
    //   22: checkcast 20	java/lang/Number
    //   25: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   28: invokespecial 37	java/awt/geom/Point2D$Double:<init>	(DD)V
    //   31: areturn
    //   32: new 28	gnu/mapping/WrongType
    //   35: dup_x1
    //   36: swap
    //   37: ldc 30
    //   39: iconst_1
    //   40: aload_2
    //   41: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   44: athrow
    //   45: new 28	gnu/mapping/WrongType
    //   48: dup_x1
    //   49: swap
    //   50: ldc 30
    //   52: iconst_2
    //   53: aload_2
    //   54: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   57: athrow
    // Line number table:
    //   Java source line #9	-> byte code offset #0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	x	Object
    //   0	31	1	y	Object
    //   9	45	2	localObject	Object
    //   32	1	3	localClassCastException1	ClassCastException
    //   45	1	4	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   10	16	32	java/lang/ClassCastException
    //   22	28	45	java/lang/ClassCastException
  }
  
  public static java.awt.geom.Rectangle2D rectangle(java.awt.geom.Point2D paramPoint2D)
  {
    return rectangle(paramPoint2D, null);
  }
  
  /* Error */
  public static java.awt.geom.Rectangle2D rectangle(java.awt.geom.Point2D p1, Object p2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 69	java/awt/geom/Point2D:getX	()D
    //   4: dstore_2
    //   5: aload_0
    //   6: invokevirtual 72	java/awt/geom/Point2D:getY	()D
    //   9: dstore 4
    //   11: aload_1
    //   12: ifnonnull +18 -> 30
    //   15: new 74	java/awt/geom/Rectangle2D$Double
    //   18: dup
    //   19: dconst_0
    //   20: dconst_0
    //   21: dload_2
    //   22: dload 4
    //   24: invokespecial 77	java/awt/geom/Rectangle2D$Double:<init>	(DDDD)V
    //   27: goto +100 -> 127
    //   30: aload_1
    //   31: instanceof 79
    //   34: ifeq +40 -> 74
    //   37: aload_1
    //   38: ldc 79
    //   40: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   43: dup
    //   44: astore 7
    //   46: checkcast 79	java/awt/geom/Dimension2D
    //   49: astore 6
    //   51: new 74	java/awt/geom/Rectangle2D$Double
    //   54: dup
    //   55: dload_2
    //   56: dload 4
    //   58: aload 6
    //   60: invokevirtual 87	java/awt/geom/Dimension2D:getWidth	()D
    //   63: aload 6
    //   65: invokevirtual 90	java/awt/geom/Dimension2D:getHeight	()D
    //   68: invokespecial 77	java/awt/geom/Rectangle2D$Double:<init>	(DDDD)V
    //   71: goto +56 -> 127
    //   74: aload_1
    //   75: ldc 66
    //   77: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   80: dup
    //   81: astore 7
    //   83: checkcast 66	java/awt/geom/Point2D
    //   86: astore 6
    //   88: aload 6
    //   90: invokevirtual 69	java/awt/geom/Point2D:getX	()D
    //   93: dload_2
    //   94: dsub
    //   95: invokestatic 96	java/lang/Math:abs	(D)D
    //   98: dstore 7
    //   100: aload 6
    //   102: invokevirtual 72	java/awt/geom/Point2D:getY	()D
    //   105: dload 4
    //   107: dsub
    //   108: invokestatic 96	java/lang/Math:abs	(D)D
    //   111: dstore 9
    //   113: new 74	java/awt/geom/Rectangle2D$Double
    //   116: dup
    //   117: dload_2
    //   118: dload 4
    //   120: dload 7
    //   122: dload 9
    //   124: invokespecial 77	java/awt/geom/Rectangle2D$Double:<init>	(DDDD)V
    //   127: areturn
    //   128: new 28	gnu/mapping/WrongType
    //   131: dup_x1
    //   132: swap
    //   133: ldc 84
    //   135: bipush -2
    //   137: aload 7
    //   139: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   142: athrow
    //   143: new 28	gnu/mapping/WrongType
    //   146: dup_x1
    //   147: swap
    //   148: ldc 84
    //   150: bipush -2
    //   152: aload 7
    //   154: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   157: athrow
    // Line number table:
    //   Java source line #24	-> byte code offset #0
    //   Java source line #26	-> byte code offset #0
    //   Java source line #27	-> byte code offset #5
    //   Java source line #28	-> byte code offset #11
    //   Java source line #29	-> byte code offset #15
    //   Java source line #30	-> byte code offset #30
    //   Java source line #31	-> byte code offset #37
    //   Java source line #32	-> byte code offset #51
    //   Java source line #34	-> byte code offset #74
    //   Java source line #35	-> byte code offset #88
    //   Java source line #34	-> byte code offset #100
    //   Java source line #36	-> byte code offset #100
    //   Java source line #37	-> byte code offset #113
    //   Java source line #31	-> byte code offset #128
    //   Java source line #34	-> byte code offset #143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	p1	java.awt.geom.Point2D
    //   0	127	1	p2	Object
    //   4	1	2	d1	double
    //   11	107	2	x	double
    //   9	110	4	y	double
    //   49	15	6	p	java.awt.geom.Dimension2D
    //   86	15	6	p	java.awt.geom.Point2D
    //   44	38	7	localObject	Object
    //   98	55	7	w	double
    //   111	12	9	h	double
    //   128	1	10	localClassCastException1	ClassCastException
    //   143	1	11	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   46	49	128	java/lang/ClassCastException
    //   83	86	143	java/lang/ClassCastException
  }
  
  /* Error */
  public static java.awt.geom.Ellipse2D.Double circle(float radius, java.awt.geom.Point2D center)
  {
    // Byte code:
    //   0: iconst_2
    //   1: i2d
    //   2: fload_0
    //   3: f2d
    //   4: dmul
    //   5: invokestatic 134	gnu/math/DFloNum:make	(D)Lgnu/math/DFloNum;
    //   8: astore_2
    //   9: new 136	java/awt/geom/Ellipse2D$Double
    //   12: dup
    //   13: aload_1
    //   14: invokevirtual 69	java/awt/geom/Point2D:getX	()D
    //   17: fload_0
    //   18: f2d
    //   19: dsub
    //   20: aload_1
    //   21: invokevirtual 72	java/awt/geom/Point2D:getY	()D
    //   24: fload_0
    //   25: f2d
    //   26: dsub
    //   27: aload_2
    //   28: dup
    //   29: astore_3
    //   30: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   33: aload_2
    //   34: dup
    //   35: astore_3
    //   36: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   39: invokespecial 139	java/awt/geom/Ellipse2D$Double:<init>	(DDDD)V
    //   42: areturn
    //   43: new 28	gnu/mapping/WrongType
    //   46: dup_x1
    //   47: swap
    //   48: ldc -118
    //   50: iconst_3
    //   51: aload_3
    //   52: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   55: athrow
    //   56: new 28	gnu/mapping/WrongType
    //   59: dup_x1
    //   60: swap
    //   61: ldc -118
    //   63: iconst_4
    //   64: aload_3
    //   65: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   68: athrow
    // Line number table:
    //   Java source line #69	-> byte code offset #0
    //   Java source line #71	-> byte code offset #0
    //   Java source line #72	-> byte code offset #9
    //   Java source line #73	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	radius	float
    //   0	42	1	center	java.awt.geom.Point2D
    //   8	26	2	diam	gnu.math.DFloNum
    //   29	36	3	localDFloNum1	gnu.math.DFloNum
    //   43	1	4	localClassCastException1	ClassCastException
    //   56	1	5	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   30	33	43	java/lang/ClassCastException
    //   36	39	56	java/lang/ClassCastException
  }
  
  public static void pictureWriteSvg(Object paramObject, gnu.kawa.io.Path paramPath)
  {
    pictureWriteSvg(paramObject, paramPath, true);
  }
  
  public pictures()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public static java.awt.geom.AffineTransform lambda15(gnu.math.RealNum sc)
  {
    // Byte code:
    //   0: aload_0
    //   1: dup
    //   2: astore_1
    //   3: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   6: aload_0
    //   7: dup
    //   8: astore_1
    //   9: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   12: invokestatic 735	java/awt/geom/AffineTransform:getScaleInstance	(DD)Ljava/awt/geom/AffineTransform;
    //   15: areturn
    //   16: new 28	gnu/mapping/WrongType
    //   19: dup_x1
    //   20: swap
    //   21: ldc_w 741
    //   24: iconst_1
    //   25: aload_1
    //   26: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   29: athrow
    //   30: new 28	gnu/mapping/WrongType
    //   33: dup_x1
    //   34: swap
    //   35: ldc_w 741
    //   38: iconst_2
    //   39: aload_1
    //   40: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   43: athrow
    // Line number table:
    //   Java source line #238	-> byte code offset #0
    //   Java source line #239	-> byte code offset #0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	15	0	sc	gnu.math.RealNum
    //   2	38	1	localRealNum	gnu.math.RealNum
    //   16	1	2	localClassCastException1	ClassCastException
    //   30	1	3	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   3	6	16	java/lang/ClassCastException
    //   9	12	30	java/lang/ClassCastException
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 839	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+750->754, 3:+733->737, 7:+700->704, 12:+680->684, 14:+459->463, 20:+442->446, 24:+408->412, 25:+391->395, 26:+644->648, 28:+611->615, 29:+578->582, 30:+561->565, 31:+544->548, 32:+527->531, 33:+510->514, 37:+374->378, 39:+341->345, 40:+308->312, 41:+271->275, 43:+238->242, 44:+205->209, 48:+188->192, 53:+493->497
    //   192: aload_3
    //   193: aload_2
    //   194: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   197: aload_3
    //   198: aload_1
    //   199: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   202: aload_3
    //   203: iconst_1
    //   204: putfield 850	gnu/mapping/CallContext:pc	I
    //   207: iconst_0
    //   208: ireturn
    //   209: aload_3
    //   210: aload_2
    //   211: ldc 66
    //   213: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   216: dup
    //   217: instanceof 66
    //   220: ifne +7 -> 227
    //   223: ldc_w 851
    //   226: ireturn
    //   227: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   230: aload_3
    //   231: aload_1
    //   232: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   235: aload_3
    //   236: iconst_1
    //   237: putfield 850	gnu/mapping/CallContext:pc	I
    //   240: iconst_0
    //   241: ireturn
    //   242: aload_3
    //   243: aload_2
    //   244: ldc 79
    //   246: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   249: dup
    //   250: instanceof 79
    //   253: ifne +7 -> 260
    //   256: ldc_w 851
    //   259: ireturn
    //   260: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   263: aload_3
    //   264: aload_1
    //   265: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   268: aload_3
    //   269: iconst_1
    //   270: putfield 850	gnu/mapping/CallContext:pc	I
    //   273: iconst_0
    //   274: ireturn
    //   275: aload_3
    //   276: aload_2
    //   277: ldc_w 392
    //   280: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   283: dup
    //   284: invokestatic 855	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   287: ifnull +6 -> 293
    //   290: goto +7 -> 297
    //   293: ldc_w 851
    //   296: ireturn
    //   297: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   300: aload_3
    //   301: aload_1
    //   302: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   305: aload_3
    //   306: iconst_1
    //   307: putfield 850	gnu/mapping/CallContext:pc	I
    //   310: iconst_0
    //   311: ireturn
    //   312: aload_3
    //   313: aload_2
    //   314: ldc 66
    //   316: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   319: dup
    //   320: instanceof 66
    //   323: ifne +7 -> 330
    //   326: ldc_w 851
    //   329: ireturn
    //   330: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   333: aload_3
    //   334: aload_1
    //   335: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   338: aload_3
    //   339: iconst_1
    //   340: putfield 850	gnu/mapping/CallContext:pc	I
    //   343: iconst_0
    //   344: ireturn
    //   345: aload_3
    //   346: aload_2
    //   347: ldc 79
    //   349: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   352: dup
    //   353: instanceof 79
    //   356: ifne +7 -> 363
    //   359: ldc_w 851
    //   362: ireturn
    //   363: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   366: aload_3
    //   367: aload_1
    //   368: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   371: aload_3
    //   372: iconst_1
    //   373: putfield 850	gnu/mapping/CallContext:pc	I
    //   376: iconst_0
    //   377: ireturn
    //   378: aload_3
    //   379: aload_2
    //   380: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   383: aload_3
    //   384: aload_1
    //   385: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   388: aload_3
    //   389: iconst_1
    //   390: putfield 850	gnu/mapping/CallContext:pc	I
    //   393: iconst_0
    //   394: ireturn
    //   395: aload_3
    //   396: aload_2
    //   397: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   400: aload_3
    //   401: aload_1
    //   402: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   405: aload_3
    //   406: iconst_1
    //   407: putfield 850	gnu/mapping/CallContext:pc	I
    //   410: iconst_0
    //   411: ireturn
    //   412: aload_3
    //   413: aload_2
    //   414: ldc_w 857
    //   417: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   420: dup
    //   421: instanceof 857
    //   424: ifne +7 -> 431
    //   427: ldc_w 851
    //   430: ireturn
    //   431: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   434: aload_3
    //   435: aload_1
    //   436: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   439: aload_3
    //   440: iconst_1
    //   441: putfield 850	gnu/mapping/CallContext:pc	I
    //   444: iconst_0
    //   445: ireturn
    //   446: aload_3
    //   447: aload_2
    //   448: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   451: aload_3
    //   452: aload_1
    //   453: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   456: aload_3
    //   457: iconst_1
    //   458: putfield 850	gnu/mapping/CallContext:pc	I
    //   461: iconst_0
    //   462: ireturn
    //   463: aload_3
    //   464: aload_2
    //   465: ldc_w 295
    //   468: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   471: dup
    //   472: instanceof 295
    //   475: ifne +7 -> 482
    //   478: ldc_w 851
    //   481: ireturn
    //   482: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   485: aload_3
    //   486: aload_1
    //   487: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   490: aload_3
    //   491: iconst_1
    //   492: putfield 850	gnu/mapping/CallContext:pc	I
    //   495: iconst_0
    //   496: ireturn
    //   497: aload_3
    //   498: aload_2
    //   499: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   502: aload_3
    //   503: aload_1
    //   504: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   507: aload_3
    //   508: iconst_1
    //   509: putfield 850	gnu/mapping/CallContext:pc	I
    //   512: iconst_0
    //   513: ireturn
    //   514: aload_3
    //   515: aload_2
    //   516: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   519: aload_3
    //   520: aload_1
    //   521: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   524: aload_3
    //   525: iconst_1
    //   526: putfield 850	gnu/mapping/CallContext:pc	I
    //   529: iconst_0
    //   530: ireturn
    //   531: aload_3
    //   532: aload_2
    //   533: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   536: aload_3
    //   537: aload_1
    //   538: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   541: aload_3
    //   542: iconst_1
    //   543: putfield 850	gnu/mapping/CallContext:pc	I
    //   546: iconst_0
    //   547: ireturn
    //   548: aload_3
    //   549: aload_2
    //   550: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   553: aload_3
    //   554: aload_1
    //   555: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   558: aload_3
    //   559: iconst_1
    //   560: putfield 850	gnu/mapping/CallContext:pc	I
    //   563: iconst_0
    //   564: ireturn
    //   565: aload_3
    //   566: aload_2
    //   567: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   570: aload_3
    //   571: aload_1
    //   572: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   575: aload_3
    //   576: iconst_1
    //   577: putfield 850	gnu/mapping/CallContext:pc	I
    //   580: iconst_0
    //   581: ireturn
    //   582: aload_3
    //   583: aload_2
    //   584: ldc -25
    //   586: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   589: dup
    //   590: instanceof 231
    //   593: ifne +7 -> 600
    //   596: ldc_w 851
    //   599: ireturn
    //   600: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   603: aload_3
    //   604: aload_1
    //   605: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   608: aload_3
    //   609: iconst_1
    //   610: putfield 850	gnu/mapping/CallContext:pc	I
    //   613: iconst_0
    //   614: ireturn
    //   615: aload_3
    //   616: aload_2
    //   617: ldc -25
    //   619: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   622: dup
    //   623: instanceof 231
    //   626: ifne +7 -> 633
    //   629: ldc_w 851
    //   632: ireturn
    //   633: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   636: aload_3
    //   637: aload_1
    //   638: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   641: aload_3
    //   642: iconst_1
    //   643: putfield 850	gnu/mapping/CallContext:pc	I
    //   646: iconst_0
    //   647: ireturn
    //   648: aload_3
    //   649: aload_2
    //   650: ldc -89
    //   652: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   655: dup
    //   656: invokestatic 860	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   659: ifnull +6 -> 665
    //   662: goto +7 -> 669
    //   665: ldc_w 851
    //   668: ireturn
    //   669: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   672: aload_3
    //   673: aload_1
    //   674: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   677: aload_3
    //   678: iconst_1
    //   679: putfield 850	gnu/mapping/CallContext:pc	I
    //   682: iconst_0
    //   683: ireturn
    //   684: aload_3
    //   685: aload_2
    //   686: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   689: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   692: aload_3
    //   693: aload_1
    //   694: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   697: aload_3
    //   698: iconst_1
    //   699: putfield 850	gnu/mapping/CallContext:pc	I
    //   702: iconst_0
    //   703: ireturn
    //   704: aload_3
    //   705: aload_2
    //   706: ldc 66
    //   708: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   711: dup
    //   712: instanceof 66
    //   715: ifne +7 -> 722
    //   718: ldc_w 851
    //   721: ireturn
    //   722: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   725: aload_3
    //   726: aload_1
    //   727: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   730: aload_3
    //   731: iconst_1
    //   732: putfield 850	gnu/mapping/CallContext:pc	I
    //   735: iconst_0
    //   736: ireturn
    //   737: aload_3
    //   738: aload_2
    //   739: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   742: aload_3
    //   743: aload_1
    //   744: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   747: aload_3
    //   748: iconst_1
    //   749: putfield 850	gnu/mapping/CallContext:pc	I
    //   752: iconst_0
    //   753: ireturn
    //   754: aload_0
    //   755: aload_1
    //   756: aload_2
    //   757: aload_3
    //   758: invokespecial 864	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   761: ireturn
    // Line number table:
    //   Java source line #283	-> byte code offset #192
    //   Java source line #246	-> byte code offset #209
    //   Java source line #244	-> byte code offset #242
    //   Java source line #238	-> byte code offset #275
    //   Java source line #236	-> byte code offset #312
    //   Java source line #234	-> byte code offset #345
    //   Java source line #228	-> byte code offset #378
    //   Java source line #134	-> byte code offset #395
    //   Java source line #132	-> byte code offset #412
    //   Java source line #117	-> byte code offset #446
    //   Java source line #78	-> byte code offset #463
    //   Java source line #302	-> byte code offset #497
    //   Java source line #184	-> byte code offset #514
    //   Java source line #181	-> byte code offset #531
    //   Java source line #175	-> byte code offset #548
    //   Java source line #162	-> byte code offset #565
    //   Java source line #159	-> byte code offset #582
    //   Java source line #156	-> byte code offset #615
    //   Java source line #137	-> byte code offset #648
    //   Java source line #69	-> byte code offset #684
    //   Java source line #24	-> byte code offset #704
    //   Java source line #14	-> byte code offset #737
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 839	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+599->603, 1:+573->577, 2:+541->545, 7:+499->503, 12:+454->458, 15:+288->292, 19:+262->266, 22:+236->240, 27:+428->432, 34:+402->406, 35:+376->380, 38:+210->214, 42:+184->188, 45:+158->162, 47:+132->136, 51:+331->335
    //   136: aload 4
    //   138: aload_2
    //   139: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   142: aload 4
    //   144: aload_3
    //   145: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   148: aload 4
    //   150: aload_1
    //   151: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   154: aload 4
    //   156: iconst_2
    //   157: putfield 850	gnu/mapping/CallContext:pc	I
    //   160: iconst_0
    //   161: ireturn
    //   162: aload 4
    //   164: aload_2
    //   165: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   168: aload 4
    //   170: aload_3
    //   171: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   174: aload 4
    //   176: aload_1
    //   177: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   180: aload 4
    //   182: iconst_2
    //   183: putfield 850	gnu/mapping/CallContext:pc	I
    //   186: iconst_0
    //   187: ireturn
    //   188: aload 4
    //   190: aload_2
    //   191: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   194: aload 4
    //   196: aload_3
    //   197: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   200: aload 4
    //   202: aload_1
    //   203: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   206: aload 4
    //   208: iconst_2
    //   209: putfield 850	gnu/mapping/CallContext:pc	I
    //   212: iconst_0
    //   213: ireturn
    //   214: aload 4
    //   216: aload_2
    //   217: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   220: aload 4
    //   222: aload_3
    //   223: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   226: aload 4
    //   228: aload_1
    //   229: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   232: aload 4
    //   234: iconst_2
    //   235: putfield 850	gnu/mapping/CallContext:pc	I
    //   238: iconst_0
    //   239: ireturn
    //   240: aload 4
    //   242: aload_2
    //   243: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   246: aload 4
    //   248: aload_3
    //   249: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   252: aload 4
    //   254: aload_1
    //   255: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   258: aload 4
    //   260: iconst_2
    //   261: putfield 850	gnu/mapping/CallContext:pc	I
    //   264: iconst_0
    //   265: ireturn
    //   266: aload 4
    //   268: aload_2
    //   269: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   272: aload 4
    //   274: aload_3
    //   275: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   278: aload 4
    //   280: aload_1
    //   281: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   284: aload 4
    //   286: iconst_2
    //   287: putfield 850	gnu/mapping/CallContext:pc	I
    //   290: iconst_0
    //   291: ireturn
    //   292: aload 4
    //   294: aload_2
    //   295: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   298: aload 4
    //   300: aload_3
    //   301: ldc_w 295
    //   304: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   307: dup
    //   308: instanceof 295
    //   311: ifne +7 -> 318
    //   314: ldc_w 868
    //   317: ireturn
    //   318: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   321: aload 4
    //   323: aload_1
    //   324: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   327: aload 4
    //   329: iconst_2
    //   330: putfield 850	gnu/mapping/CallContext:pc	I
    //   333: iconst_0
    //   334: ireturn
    //   335: aload 4
    //   337: aload_2
    //   338: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   341: aload 4
    //   343: aload_3
    //   344: ldc -89
    //   346: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   349: dup
    //   350: invokestatic 860	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   353: ifnull +6 -> 359
    //   356: goto +7 -> 363
    //   359: ldc_w 868
    //   362: ireturn
    //   363: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   366: aload 4
    //   368: aload_1
    //   369: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   372: aload 4
    //   374: iconst_2
    //   375: putfield 850	gnu/mapping/CallContext:pc	I
    //   378: iconst_0
    //   379: ireturn
    //   380: aload 4
    //   382: aload_2
    //   383: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   386: aload 4
    //   388: aload_3
    //   389: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   392: aload 4
    //   394: aload_1
    //   395: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   398: aload 4
    //   400: iconst_2
    //   401: putfield 850	gnu/mapping/CallContext:pc	I
    //   404: iconst_0
    //   405: ireturn
    //   406: aload 4
    //   408: aload_2
    //   409: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   412: aload 4
    //   414: aload_3
    //   415: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   418: aload 4
    //   420: aload_1
    //   421: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   424: aload 4
    //   426: iconst_2
    //   427: putfield 850	gnu/mapping/CallContext:pc	I
    //   430: iconst_0
    //   431: ireturn
    //   432: aload 4
    //   434: aload_2
    //   435: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   438: aload 4
    //   440: aload_3
    //   441: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   444: aload 4
    //   446: aload_1
    //   447: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   450: aload 4
    //   452: iconst_2
    //   453: putfield 850	gnu/mapping/CallContext:pc	I
    //   456: iconst_0
    //   457: ireturn
    //   458: aload 4
    //   460: aload_2
    //   461: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   464: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   467: aload 4
    //   469: aload_3
    //   470: ldc 66
    //   472: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   475: dup
    //   476: instanceof 66
    //   479: ifne +7 -> 486
    //   482: ldc_w 868
    //   485: ireturn
    //   486: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   489: aload 4
    //   491: aload_1
    //   492: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   495: aload 4
    //   497: iconst_2
    //   498: putfield 850	gnu/mapping/CallContext:pc	I
    //   501: iconst_0
    //   502: ireturn
    //   503: aload 4
    //   505: aload_2
    //   506: ldc 66
    //   508: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   511: dup
    //   512: instanceof 66
    //   515: ifne +7 -> 522
    //   518: ldc_w 851
    //   521: ireturn
    //   522: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   525: aload 4
    //   527: aload_3
    //   528: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   531: aload 4
    //   533: aload_1
    //   534: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   537: aload 4
    //   539: iconst_2
    //   540: putfield 850	gnu/mapping/CallContext:pc	I
    //   543: iconst_0
    //   544: ireturn
    //   545: aload 4
    //   547: aload_2
    //   548: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   551: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   554: aload 4
    //   556: aload_3
    //   557: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   560: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   563: aload 4
    //   565: aload_1
    //   566: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   569: aload 4
    //   571: iconst_2
    //   572: putfield 850	gnu/mapping/CallContext:pc	I
    //   575: iconst_0
    //   576: ireturn
    //   577: aload 4
    //   579: aload_2
    //   580: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   583: aload 4
    //   585: aload_3
    //   586: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   589: aload 4
    //   591: aload_1
    //   592: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   595: aload 4
    //   597: iconst_2
    //   598: putfield 850	gnu/mapping/CallContext:pc	I
    //   601: iconst_0
    //   602: ireturn
    //   603: aload_0
    //   604: aload_1
    //   605: aload_2
    //   606: aload_3
    //   607: aload 4
    //   609: invokespecial 872	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   612: ireturn
    // Line number table:
    //   Java source line #276	-> byte code offset #136
    //   Java source line #248	-> byte code offset #162
    //   Java source line #240	-> byte code offset #188
    //   Java source line #230	-> byte code offset #214
    //   Java source line #126	-> byte code offset #240
    //   Java source line #112	-> byte code offset #266
    //   Java source line #80	-> byte code offset #292
    //   Java source line #296	-> byte code offset #335
    //   Java source line #190	-> byte code offset #380
    //   Java source line #187	-> byte code offset #406
    //   Java source line #140	-> byte code offset #432
    //   Java source line #69	-> byte code offset #458
    //   Java source line #24	-> byte code offset #503
    //   Java source line #11	-> byte code offset #545
    //   Java source line #9	-> byte code offset #577
  }
  
  /* Error */
  public int match3(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 839	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+375->379, 17:+309->313, 18:+207->211, 21:+174->178, 46:+141->145, 50:+60->64, 51:+240->244
    //   64: aload 5
    //   66: aload_2
    //   67: ldc 66
    //   69: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   72: dup
    //   73: instanceof 66
    //   76: ifne +7 -> 83
    //   79: ldc_w 851
    //   82: ireturn
    //   83: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   86: aload 5
    //   88: aload_3
    //   89: ldc 66
    //   91: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   94: dup
    //   95: instanceof 66
    //   98: ifne +7 -> 105
    //   101: ldc_w 868
    //   104: ireturn
    //   105: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   108: aload 5
    //   110: aload 4
    //   112: ldc 66
    //   114: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   117: dup
    //   118: instanceof 66
    //   121: ifne +7 -> 128
    //   124: ldc_w 873
    //   127: ireturn
    //   128: putfield 876	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   131: aload 5
    //   133: aload_1
    //   134: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   137: aload 5
    //   139: iconst_3
    //   140: putfield 850	gnu/mapping/CallContext:pc	I
    //   143: iconst_0
    //   144: ireturn
    //   145: aload 5
    //   147: aload_2
    //   148: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   151: aload 5
    //   153: aload_3
    //   154: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   157: aload 5
    //   159: aload 4
    //   161: putfield 876	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   164: aload 5
    //   166: aload_1
    //   167: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   170: aload 5
    //   172: iconst_3
    //   173: putfield 850	gnu/mapping/CallContext:pc	I
    //   176: iconst_0
    //   177: ireturn
    //   178: aload 5
    //   180: aload_2
    //   181: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   184: aload 5
    //   186: aload_3
    //   187: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   190: aload 5
    //   192: aload 4
    //   194: putfield 876	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   197: aload 5
    //   199: aload_1
    //   200: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   203: aload 5
    //   205: iconst_3
    //   206: putfield 850	gnu/mapping/CallContext:pc	I
    //   209: iconst_0
    //   210: ireturn
    //   211: aload 5
    //   213: aload_2
    //   214: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   217: aload 5
    //   219: aload_3
    //   220: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   223: aload 5
    //   225: aload 4
    //   227: putfield 876	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   230: aload 5
    //   232: aload_1
    //   233: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   236: aload 5
    //   238: iconst_3
    //   239: putfield 850	gnu/mapping/CallContext:pc	I
    //   242: iconst_0
    //   243: ireturn
    //   244: aload 5
    //   246: aload_2
    //   247: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   250: aload 5
    //   252: aload_3
    //   253: ldc -89
    //   255: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   258: dup
    //   259: invokestatic 860	gnu/kawa/io/Path:coerceToPathOrNull	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   262: ifnull +6 -> 268
    //   265: goto +7 -> 272
    //   268: ldc_w 868
    //   271: ireturn
    //   272: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   275: aload 5
    //   277: aload 4
    //   279: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   282: dup
    //   283: instanceof 614
    //   286: ifeq +6 -> 292
    //   289: goto +7 -> 296
    //   292: ldc_w 873
    //   295: ireturn
    //   296: putfield 876	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   299: aload 5
    //   301: aload_1
    //   302: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   305: aload 5
    //   307: iconst_3
    //   308: putfield 850	gnu/mapping/CallContext:pc	I
    //   311: iconst_0
    //   312: ireturn
    //   313: aload 5
    //   315: aload_2
    //   316: putfield 843	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   319: aload 5
    //   321: aload_3
    //   322: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   325: dup
    //   326: instanceof 614
    //   329: ifeq +6 -> 335
    //   332: goto +7 -> 339
    //   335: ldc_w 868
    //   338: ireturn
    //   339: putfield 867	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   342: aload 5
    //   344: aload 4
    //   346: ldc 48
    //   348: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   351: dup
    //   352: instanceof 48
    //   355: ifne +7 -> 362
    //   358: ldc_w 873
    //   361: ireturn
    //   362: putfield 876	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   365: aload 5
    //   367: aload_1
    //   368: putfield 847	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   371: aload 5
    //   373: iconst_3
    //   374: putfield 850	gnu/mapping/CallContext:pc	I
    //   377: iconst_0
    //   378: ireturn
    //   379: aload_0
    //   380: aload_1
    //   381: aload_2
    //   382: aload_3
    //   383: aload 4
    //   385: aload 5
    //   387: invokespecial 880	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   390: ireturn
    // Line number table:
    //   Java source line #291	-> byte code offset #64
    //   Java source line #252	-> byte code offset #145
    //   Java source line #121	-> byte code offset #178
    //   Java source line #107	-> byte code offset #211
    //   Java source line #296	-> byte code offset #244
    //   Java source line #86	-> byte code offset #313
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 839	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+288->292, 1:+132->136, 2:+138->142, 7:+162->166, 12:+176->180, 15:+237->241, 19:+252->256, 22:+258->262, 27:+199->203, 34:+208->212, 35:+214->218, 38:+264->268, 42:+270->274, 45:+276->280, 47:+282->286, 51:+220->224
    //   136: aload_2
    //   137: aload_3
    //   138: invokestatic 124	kawa/lib/kawa/pictures:makePoint	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/awt/geom/Point2D$Double;
    //   141: areturn
    //   142: aload_2
    //   143: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   146: checkcast 20	java/lang/Number
    //   149: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   152: aload_3
    //   153: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   156: checkcast 20	java/lang/Number
    //   159: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   162: invokestatic 986	kawa/lib/kawa/pictures:makeDimension	(DD)Lgnu/kawa/models/DDimension;
    //   165: areturn
    //   166: aload_2
    //   167: ldc 66
    //   169: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   172: checkcast 66	java/awt/geom/Point2D
    //   175: aload_3
    //   176: invokestatic 64	kawa/lib/kawa/pictures:rectangle	(Ljava/awt/geom/Point2D;Ljava/lang/Object;)Ljava/awt/geom/Rectangle2D;
    //   179: areturn
    //   180: aload_2
    //   181: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: checkcast 20	java/lang/Number
    //   187: invokevirtual 903	java/lang/Number:floatValue	()F
    //   190: aload_3
    //   191: ldc 66
    //   193: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   196: checkcast 66	java/awt/geom/Point2D
    //   199: invokestatic 128	kawa/lib/kawa/pictures:circle	(FLjava/awt/geom/Point2D;)Ljava/awt/geom/Ellipse2D$Double;
    //   202: areturn
    //   203: aload_2
    //   204: aload_3
    //   205: invokestatic 989	kawa/lib/kawa/pictures:imageWrite	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   208: getstatic 995	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   211: areturn
    //   212: aload_2
    //   213: aload_3
    //   214: invokestatic 553	kawa/lib/kawa/pictures:withPaint	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/models/WithPaint;
    //   217: areturn
    //   218: aload_2
    //   219: aload_3
    //   220: invokestatic 727	kawa/lib/kawa/pictures:withTransform	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   223: areturn
    //   224: aload_2
    //   225: aload_3
    //   226: ldc -89
    //   228: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   231: invokestatic 216	gnu/kawa/io/Path:valueOf	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   234: invokestatic 1000	kawa/lib/kawa/pictures:pictureWriteSvg	(Ljava/lang/Object;Lgnu/kawa/io/Path;)V
    //   237: getstatic 995	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   240: areturn
    //   241: aload_2
    //   242: aload_3
    //   243: ldc_w 295
    //   246: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   249: checkcast 295	java/awt/Shape
    //   252: invokestatic 1004	kawa/lib/kawa/pictures:lambda2	(Ljava/lang/Object;Ljava/awt/Shape;)Lgnu/kawa/models/WithPaint;
    //   255: areturn
    //   256: aload_2
    //   257: aload_3
    //   258: invokestatic 1008	kawa/lib/kawa/pictures:lambda4	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/models/PBox;
    //   261: areturn
    //   262: aload_2
    //   263: aload_3
    //   264: invokestatic 1011	kawa/lib/kawa/pictures:lambda7	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   267: areturn
    //   268: aload_2
    //   269: aload_3
    //   270: invokestatic 1014	kawa/lib/kawa/pictures:lambda12	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   273: areturn
    //   274: aload_2
    //   275: aload_3
    //   276: invokestatic 1017	kawa/lib/kawa/pictures:lambda16	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   279: areturn
    //   280: aload_2
    //   281: aload_3
    //   282: invokestatic 1020	kawa/lib/kawa/pictures:lambda19	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   285: areturn
    //   286: aload_2
    //   287: aload_3
    //   288: invokestatic 1023	kawa/lib/kawa/pictures:lambda21	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   291: areturn
    //   292: aload_0
    //   293: aload_1
    //   294: aload_2
    //   295: aload_3
    //   296: invokespecial 1026	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   299: areturn
    //   300: new 28	gnu/mapping/WrongType
    //   303: dup_x1
    //   304: swap
    //   305: ldc_w 982
    //   308: iconst_1
    //   309: aload_2
    //   310: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   313: athrow
    //   314: new 28	gnu/mapping/WrongType
    //   317: dup_x1
    //   318: swap
    //   319: ldc_w 982
    //   322: iconst_2
    //   323: aload_3
    //   324: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   327: athrow
    //   328: new 28	gnu/mapping/WrongType
    //   331: dup_x1
    //   332: swap
    //   333: ldc_w 896
    //   336: iconst_1
    //   337: aload_2
    //   338: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   341: athrow
    //   342: new 28	gnu/mapping/WrongType
    //   345: dup_x1
    //   346: swap
    //   347: ldc_w 904
    //   350: iconst_1
    //   351: aload_2
    //   352: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   355: athrow
    //   356: new 28	gnu/mapping/WrongType
    //   359: dup_x1
    //   360: swap
    //   361: ldc_w 904
    //   364: iconst_2
    //   365: aload_3
    //   366: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   369: athrow
    //   370: new 28	gnu/mapping/WrongType
    //   373: dup_x1
    //   374: swap
    //   375: ldc_w 997
    //   378: iconst_2
    //   379: aload_3
    //   380: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   383: athrow
    //   384: new 28	gnu/mapping/WrongType
    //   387: dup_x1
    //   388: swap
    //   389: ldc_w 933
    //   392: iconst_2
    //   393: aload_3
    //   394: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   397: athrow
    // Line number table:
    //   Java source line #9	-> byte code offset #136
    //   Java source line #11	-> byte code offset #142
    //   Java source line #24	-> byte code offset #166
    //   Java source line #69	-> byte code offset #180
    //   Java source line #140	-> byte code offset #203
    //   Java source line #187	-> byte code offset #212
    //   Java source line #190	-> byte code offset #218
    //   Java source line #296	-> byte code offset #224
    //   Java source line #80	-> byte code offset #241
    //   Java source line #112	-> byte code offset #256
    //   Java source line #126	-> byte code offset #262
    //   Java source line #230	-> byte code offset #268
    //   Java source line #240	-> byte code offset #274
    //   Java source line #248	-> byte code offset #280
    //   Java source line #276	-> byte code offset #286
    //   Java source line #11	-> byte code offset #300
    //   Java source line #24	-> byte code offset #328
    //   Java source line #69	-> byte code offset #342
    //   Java source line #70	-> byte code offset #356
    //   Java source line #296	-> byte code offset #370
    //   Java source line #80	-> byte code offset #384
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	pictures
    //   0	398	1	paramModuleMethod	ModuleMethod
    //   0	398	2	paramObject1	Object
    //   0	398	3	paramObject2	Object
    //   300	1	4	localClassCastException1	ClassCastException
    //   314	1	5	localClassCastException2	ClassCastException
    //   328	1	6	localClassCastException3	ClassCastException
    //   342	1	7	localClassCastException4	ClassCastException
    //   356	1	8	localClassCastException5	ClassCastException
    //   370	1	9	localClassCastException6	ClassCastException
    //   384	1	10	localClassCastException7	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   146	152	300	java/lang/ClassCastException
    //   156	162	314	java/lang/ClassCastException
    //   172	175	328	java/lang/ClassCastException
    //   184	190	342	java/lang/ClassCastException
    //   196	199	356	java/lang/ClassCastException
    //   231	234	370	java/lang/ClassCastException
    //   249	252	384	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 839	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+179->183, 17:+60->64, 18:+123->127, 21:+131->135, 46:+139->143, 50:+147->151, 51:+90->94
    //   64: aload_2
    //   65: aload_3
    //   66: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: invokestatic 1032	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   72: ifeq +7 -> 79
    //   75: iconst_1
    //   76: goto +4 -> 80
    //   79: iconst_0
    //   80: aload 4
    //   82: ldc 48
    //   84: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   87: checkcast 48	gnu/kawa/models/Picture
    //   90: invokestatic 575	kawa/lib/kawa/pictures:borderShape	(Ljava/lang/Object;ZLgnu/kawa/models/Picture;)Ljava/awt/Shape;
    //   93: areturn
    //   94: aload_2
    //   95: aload_3
    //   96: ldc -89
    //   98: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   101: invokestatic 216	gnu/kawa/io/Path:valueOf	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
    //   104: aload 4
    //   106: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: invokestatic 1032	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   112: ifeq +7 -> 119
    //   115: iconst_1
    //   116: goto +4 -> 120
    //   119: iconst_0
    //   120: invokestatic 328	kawa/lib/kawa/pictures:pictureWriteSvg	(Ljava/lang/Object;Lgnu/kawa/io/Path;Z)V
    //   123: getstatic 995	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   126: areturn
    //   127: aload_2
    //   128: aload_3
    //   129: aload 4
    //   131: invokestatic 1038	kawa/lib/kawa/pictures:lambda3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/models/PBox;
    //   134: areturn
    //   135: aload_2
    //   136: aload_3
    //   137: aload 4
    //   139: invokestatic 1041	kawa/lib/kawa/pictures:lambda6	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/models/PBox;
    //   142: areturn
    //   143: aload_2
    //   144: aload_3
    //   145: aload 4
    //   147: invokestatic 1044	kawa/lib/kawa/pictures:lambda20	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: areturn
    //   151: aload_2
    //   152: ldc 66
    //   154: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   157: checkcast 66	java/awt/geom/Point2D
    //   160: aload_3
    //   161: ldc 66
    //   163: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   166: checkcast 66	java/awt/geom/Point2D
    //   169: aload 4
    //   171: ldc 66
    //   173: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   176: checkcast 66	java/awt/geom/Point2D
    //   179: invokestatic 1048	kawa/lib/kawa/pictures:lambda24	(Ljava/awt/geom/Point2D;Ljava/awt/geom/Point2D;Ljava/awt/geom/Point2D;)Ljava/awt/geom/AffineTransform;
    //   182: areturn
    //   183: aload_0
    //   184: aload_1
    //   185: aload_2
    //   186: aload_3
    //   187: aload 4
    //   189: invokespecial 1051	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   192: areturn
    //   193: new 28	gnu/mapping/WrongType
    //   196: dup_x1
    //   197: swap
    //   198: ldc_w 1034
    //   201: iconst_2
    //   202: aload_3
    //   203: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   206: athrow
    //   207: new 28	gnu/mapping/WrongType
    //   210: dup_x1
    //   211: swap
    //   212: ldc_w 1034
    //   215: iconst_3
    //   216: aload 4
    //   218: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   221: athrow
    //   222: new 28	gnu/mapping/WrongType
    //   225: dup_x1
    //   226: swap
    //   227: ldc_w 997
    //   230: iconst_2
    //   231: aload_3
    //   232: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   235: athrow
    //   236: new 28	gnu/mapping/WrongType
    //   239: dup_x1
    //   240: swap
    //   241: ldc_w 997
    //   244: iconst_3
    //   245: aload 4
    //   247: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   250: athrow
    //   251: new 28	gnu/mapping/WrongType
    //   254: dup_x1
    //   255: swap
    //   256: ldc_w 933
    //   259: iconst_1
    //   260: aload_2
    //   261: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   264: athrow
    //   265: new 28	gnu/mapping/WrongType
    //   268: dup_x1
    //   269: swap
    //   270: ldc_w 933
    //   273: iconst_2
    //   274: aload_3
    //   275: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   278: athrow
    //   279: new 28	gnu/mapping/WrongType
    //   282: dup_x1
    //   283: swap
    //   284: ldc_w 933
    //   287: iconst_3
    //   288: aload 4
    //   290: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   293: athrow
    // Line number table:
    //   Java source line #86	-> byte code offset #64
    //   Java source line #296	-> byte code offset #94
    //   Java source line #107	-> byte code offset #127
    //   Java source line #121	-> byte code offset #135
    //   Java source line #252	-> byte code offset #143
    //   Java source line #291	-> byte code offset #151
    //   Java source line #86	-> byte code offset #193
    //   Java source line #296	-> byte code offset #222
    //   Java source line #291	-> byte code offset #251
    //   Java source line #292	-> byte code offset #265
    //   Java source line #293	-> byte code offset #279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	pictures
    //   0	294	1	paramModuleMethod	ModuleMethod
    //   0	294	2	paramObject1	Object
    //   0	294	3	paramObject2	Object
    //   0	294	4	paramObject3	Object
    //   193	1	5	localClassCastException1	ClassCastException
    //   207	1	6	localClassCastException2	ClassCastException
    //   222	1	7	localClassCastException3	ClassCastException
    //   236	1	8	localClassCastException4	ClassCastException
    //   251	1	9	localClassCastException5	ClassCastException
    //   265	1	10	localClassCastException6	ClassCastException
    //   279	1	11	localClassCastException7	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   69	80	193	java/lang/ClassCastException
    //   87	90	207	java/lang/ClassCastException
    //   101	104	222	java/lang/ClassCastException
    //   109	120	236	java/lang/ClassCastException
    //   157	160	251	java/lang/ClassCastException
    //   166	169	265	java/lang/ClassCastException
    //   176	179	279	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 839	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+341->345, 4:+92->96, 5:+97->101, 6:+102->106, 9:+107->111, 10:+170->174, 11:+204->208, 16:+238->242, 23:+248->252, 36:+243->247, 49:+253->257
    //   96: aload_2
    //   97: invokestatic 1054	kawa/lib/kawa/pictures:hbox	([Ljava/lang/Object;)Lgnu/kawa/models/PBox;
    //   100: areturn
    //   101: aload_2
    //   102: invokestatic 1056	kawa/lib/kawa/pictures:vbox	([Ljava/lang/Object;)Lgnu/kawa/models/PBox;
    //   105: areturn
    //   106: aload_2
    //   107: invokestatic 1058	kawa/lib/kawa/pictures:zbox	([Ljava/lang/Object;)Lgnu/kawa/models/PBox;
    //   110: areturn
    //   111: aload_2
    //   112: iconst_0
    //   113: aaload
    //   114: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: dup
    //   118: astore_3
    //   119: invokestatic 1032	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   122: ifeq +7 -> 129
    //   125: iconst_1
    //   126: goto +4 -> 130
    //   129: iconst_0
    //   130: aload_2
    //   131: iconst_1
    //   132: aaload
    //   133: ldc 66
    //   135: invokestatic 82	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   138: dup
    //   139: astore_3
    //   140: checkcast 66	java/awt/geom/Point2D
    //   143: aload_2
    //   144: arraylength
    //   145: iconst_2
    //   146: isub
    //   147: istore_3
    //   148: iload_3
    //   149: anewarray 179	java/lang/Object
    //   152: goto +11 -> 163
    //   155: dup
    //   156: iload_3
    //   157: aload_2
    //   158: iload_3
    //   159: iconst_2
    //   160: iadd
    //   161: aaload
    //   162: aastore
    //   163: iinc 3 -1
    //   166: iload_3
    //   167: ifge -12 -> 155
    //   170: invokestatic 116	kawa/lib/kawa/pictures:linePath	(ZLjava/awt/geom/Point2D;[Ljava/lang/Object;)Ljava/lang/Object;
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
    //   183: anewarray 179	java/lang/Object
    //   186: goto +11 -> 197
    //   189: dup
    //   190: iload_3
    //   191: aload_2
    //   192: iload_3
    //   193: iconst_1
    //   194: iadd
    //   195: aaload
    //   196: aastore
    //   197: iinc 3 -1
    //   200: iload_3
    //   201: ifge -12 -> 189
    //   204: invokestatic 1061	kawa/lib/kawa/pictures:line	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
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
    //   217: anewarray 179	java/lang/Object
    //   220: goto +11 -> 231
    //   223: dup
    //   224: iload_3
    //   225: aload_2
    //   226: iload_3
    //   227: iconst_1
    //   228: iadd
    //   229: aaload
    //   230: aastore
    //   231: iinc 3 -1
    //   234: iload_3
    //   235: ifge -12 -> 223
    //   238: invokestatic 1063	kawa/lib/kawa/pictures:polygon	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   241: areturn
    //   242: aload_2
    //   243: invokestatic 1067	kawa/lib/kawa/pictures:draw$V	([Ljava/lang/Object;)Lgnu/kawa/models/Picture;
    //   246: areturn
    //   247: aload_2
    //   248: invokestatic 1070	kawa/lib/kawa/pictures:withComposite	([Ljava/lang/Object;)Lgnu/kawa/models/WithComposite;
    //   251: areturn
    //   252: aload_2
    //   253: invokestatic 1074	kawa/lib/kawa/pictures:lambda8$V	([Ljava/lang/Object;)Lgnu/kawa/models/DrawImage;
    //   256: areturn
    //   257: aload_2
    //   258: iconst_0
    //   259: aaload
    //   260: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   263: dup
    //   264: astore_3
    //   265: checkcast 20	java/lang/Number
    //   268: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   271: aload_2
    //   272: iconst_1
    //   273: aaload
    //   274: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   277: dup
    //   278: astore_3
    //   279: checkcast 20	java/lang/Number
    //   282: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   285: aload_2
    //   286: iconst_2
    //   287: aaload
    //   288: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   291: dup
    //   292: astore_3
    //   293: checkcast 20	java/lang/Number
    //   296: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   299: aload_2
    //   300: iconst_3
    //   301: aaload
    //   302: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   305: dup
    //   306: astore_3
    //   307: checkcast 20	java/lang/Number
    //   310: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   313: aload_2
    //   314: iconst_4
    //   315: aaload
    //   316: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   319: dup
    //   320: astore_3
    //   321: checkcast 20	java/lang/Number
    //   324: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   327: aload_2
    //   328: iconst_5
    //   329: aaload
    //   330: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   333: dup
    //   334: astore_3
    //   335: checkcast 20	java/lang/Number
    //   338: invokevirtual 24	java/lang/Number:doubleValue	()D
    //   341: invokestatic 1078	kawa/lib/kawa/pictures:lambda23	(DDDDDD)Ljava/awt/geom/AffineTransform;
    //   344: areturn
    //   345: aload_0
    //   346: aload_1
    //   347: aload_2
    //   348: invokespecial 1082	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   351: areturn
    //   352: new 28	gnu/mapping/WrongType
    //   355: dup_x1
    //   356: swap
    //   357: ldc 112
    //   359: iconst_1
    //   360: aload_3
    //   361: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   364: athrow
    //   365: new 28	gnu/mapping/WrongType
    //   368: dup_x1
    //   369: swap
    //   370: ldc 112
    //   372: iconst_2
    //   373: aload_3
    //   374: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   377: athrow
    //   378: new 28	gnu/mapping/WrongType
    //   381: dup_x1
    //   382: swap
    //   383: ldc_w 933
    //   386: iconst_1
    //   387: aload_3
    //   388: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   391: athrow
    //   392: new 28	gnu/mapping/WrongType
    //   395: dup_x1
    //   396: swap
    //   397: ldc_w 933
    //   400: iconst_2
    //   401: aload_3
    //   402: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   405: athrow
    //   406: new 28	gnu/mapping/WrongType
    //   409: dup_x1
    //   410: swap
    //   411: ldc_w 933
    //   414: iconst_3
    //   415: aload_3
    //   416: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   419: athrow
    //   420: new 28	gnu/mapping/WrongType
    //   423: dup_x1
    //   424: swap
    //   425: ldc_w 933
    //   428: iconst_4
    //   429: aload_3
    //   430: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   433: athrow
    //   434: new 28	gnu/mapping/WrongType
    //   437: dup_x1
    //   438: swap
    //   439: ldc_w 933
    //   442: iconst_5
    //   443: aload_3
    //   444: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   447: athrow
    //   448: new 28	gnu/mapping/WrongType
    //   451: dup_x1
    //   452: swap
    //   453: ldc_w 933
    //   456: bipush 6
    //   458: aload_3
    //   459: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   462: athrow
    // Line number table:
    //   Java source line #17	-> byte code offset #96
    //   Java source line #19	-> byte code offset #101
    //   Java source line #21	-> byte code offset #106
    //   Java source line #39	-> byte code offset #111
    //   Java source line #63	-> byte code offset #174
    //   Java source line #66	-> byte code offset #208
    //   Java source line #83	-> byte code offset #242
    //   Java source line #205	-> byte code offset #247
    //   Java source line #130	-> byte code offset #252
    //   Java source line #287	-> byte code offset #257
    //   Java source line #39	-> byte code offset #352
    //   Java source line #287	-> byte code offset #378
    //   Java source line #288	-> byte code offset #406
    //   Java source line #289	-> byte code offset #434
    // Exception table:
    //   from	to	target	type
    //   119	130	352	java/lang/ClassCastException
    //   140	143	365	java/lang/ClassCastException
    //   265	271	378	java/lang/ClassCastException
    //   279	285	392	java/lang/ClassCastException
    //   293	299	406	java/lang/ClassCastException
    //   307	313	420	java/lang/ClassCastException
    //   321	327	434	java/lang/ClassCastException
    //   335	341	448	java/lang/ClassCastException
  }
}
