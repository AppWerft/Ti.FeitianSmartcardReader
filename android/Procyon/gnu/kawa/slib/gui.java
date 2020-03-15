// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.mapping.Values;
import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import gnu.lists.PairWithPosition;
import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.mapping.Symbol;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.kawa.models.Display;
import gnu.kawa.models.Model;
import gnu.kawa.models.Window;
import gnu.kawa.models.Column;
import gnu.kawa.models.Viewable;
import gnu.kawa.models.Box;
import gnu.kawa.models.Row;
import gnu.kawa.models.Text;
import gnu.kawa.models.Label;
import gnu.expr.Special;
import kawa.lib.exceptions;
import gnu.kawa.functions.Format;
import gnu.expr.KawaConvert;
import gnu.kawa.models.Button;
import gnu.mapping.WrongType;
import gnu.kawa.reflect.SlotGet;
import gnu.math.IntNum;
import gnu.mapping.Promise;
import java.awt.geom.AffineTransform;
import java.awt.AlphaComposite;
import java.awt.Composite;
import gnu.math.Complex;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import java.awt.Color;
import kawa.lang.Macro;
import gnu.expr.ModuleMethod;
import gnu.expr.SourceName;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class gui extends ModuleBody
{
    public static final StaticFieldLocation make$MnPoint;
    @SourceName(name = "P", uri = "http://kawa.gnu.org/construct", prefix = "$construct$")
    public static final StaticFieldLocation P;
    public static final StaticFieldLocation circle;
    public static final StaticFieldLocation fill;
    public static final StaticFieldLocation draw;
    public static final StaticFieldLocation image$Mnread;
    public static final StaticFieldLocation image$Mnwidth;
    public static final StaticFieldLocation image$Mnheight;
    public static final StaticFieldLocation with$Mnpaint;
    public static final StaticFieldLocation with$Mntransform;
    public static final StaticFieldLocation with$Mncomposite;
    public static final StaticFieldLocation process$Mnkeywords;
    public static final ModuleMethod polygon;
    public static final ModuleMethod button;
    public static final ModuleMethod Button;
    public static final Macro Image;
    public static final Color color$Mnred;
    public static final ModuleMethod as$Mncolor;
    public static final ModuleMethod composite$Mnsrc$Mnover;
    public static final ModuleMethod composite$Mnsrc;
    public static final ModuleMethod rotation;
    public static final ModuleMethod Label;
    public static final ModuleMethod Text;
    public static final ModuleMethod Row;
    public static final ModuleMethod Column;
    public static final ModuleMethod set$Mncontent;
    public static final ModuleMethod Window;
    public static final Macro run$Mnapplication;
    static final Class Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    public static gui $instance;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SyntaxRules Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SyntaxRules Lit19;
    static final Object[] Lit20;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        color$Mnred = Color.red;
    }
    
    public static Object polygon(final Complex initial, final Object... more$Mnpoints) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/awt/geom/GeneralPath.<init>:()V
        //     7: astore_2       
        //     8: aload_1         /* more$Mnpoints */
        //     9: arraylength    
        //    10: istore_3        /* n$Mnpoints */
        //    11: aload_2         /* path */
        //    12: aload_0         /* initial */
        //    13: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    16: invokevirtual   java/lang/Number.doubleValue:()D
        //    19: aload_0         /* initial */
        //    20: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    23: invokevirtual   java/lang/Number.doubleValue:()D
        //    26: invokevirtual   java/awt/geom/GeneralPath.moveTo:(DD)V
        //    29: iconst_0       
        //    30: istore          i
        //    32: iload           i
        //    34: iload_3         /* n$Mnpoints */
        //    35: if_icmpge       81
        //    38: aload_1         /* more$Mnpoints */
        //    39: iload           i
        //    41: aaload         
        //    42: ldc             Lgnu/math/Complex;.class
        //    44: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    47: dup            
        //    48: astore          6
        //    50: checkcast       Lgnu/math/Complex;
        //    53: astore          pt
        //    55: aload_2         /* path */
        //    56: aload           pt
        //    58: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    61: invokevirtual   java/lang/Number.doubleValue:()D
        //    64: aload           pt
        //    66: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
        //    69: invokevirtual   java/lang/Number.doubleValue:()D
        //    72: invokevirtual   java/awt/geom/GeneralPath.lineTo:(DD)V
        //    75: iinc            i, 1
        //    78: goto            32
        //    81: aload_2         /* path */
        //    82: invokevirtual   java/awt/geom/GeneralPath.closePath:()V
        //    85: aload_2         /* path */
        //    86: areturn        
        //    87: new             Lgnu/mapping/WrongType;
        //    90: dup_x1         
        //    91: swap           
        //    92: ldc             "pt"
        //    94: bipush          -2
        //    96: aload           6
        //    98: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   101: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  50     53     87     102    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    
    public static Composite compositeSrcOver() {
        return compositeSrcOver(1.0f);
    }
    
    public static Composite compositeSrcOver(final float alpha) {
        return AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
    }
    
    public static Composite compositeSrc() {
        return compositeSrc(1.0f);
    }
    
    public static Composite compositeSrc(final float alpha) {
        return AlphaComposite.getInstance(AlphaComposite.SRC, alpha);
    }
    
    public static AffineTransform rotation(final double theta) {
        return AffineTransform.getRotateInstance(theta);
    }
    
    public static Color asColor(final Object value) {
        if (value instanceof Color) {
            return (Color)Promise.force(value, Color.class);
        }
        Label_0050: {
            if (!(value instanceof Integer)) {
                break Label_0050;
            }
            Color color2 = null;
            Color color = color2;
            final Object force = Promise.force(value, Integer.class);
            try {
                color2 = new Color((int)force);
                return color;
                color = ((value instanceof IntNum) ? new Color(IntNum.intValue(value)) : Promise.force(SlotGet.staticField.apply2(gui.Lit0, value.toString()), Color.class));
                return color;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "java.lang.Integer.intValue()", 1, force);
            }
        }
    }
    
    public static Button button(final Object... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/models/Button.<init>:()V
        //     7: astore_1        /* button */
        //     8: aload_0         /* args */
        //     9: arraylength    
        //    10: istore_2        /* num$Mnargs */
        //    11: iconst_0       
        //    12: istore_3        /* i */
        //    13: iload_3         /* i */
        //    14: iload_2         /* num$Mnargs */
        //    15: if_icmpge       126
        //    18: aload_0         /* args */
        //    19: iload_3         /* i */
        //    20: aaload         
        //    21: astore          arg
        //    23: aload           arg
        //    25: instanceof      Lgnu/expr/Keyword;
        //    28: ifeq            62
        //    31: aload_1         /* button */
        //    32: aload           arg
        //    34: ldc             Lgnu/expr/Keyword;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          5
        //    42: checkcast       Lgnu/expr/Keyword;
        //    45: invokevirtual   gnu/expr/Keyword.getName:()Ljava/lang/String;
        //    48: aload_0         /* args */
        //    49: iload_3         /* i */
        //    50: iconst_1       
        //    51: iadd           
        //    52: aaload         
        //    53: invokestatic    gnu/kawa/slib/gui.buttonKeyword:(Lgnu/kawa/models/Button;Ljava/lang/String;Ljava/lang/Object;)V
        //    56: iinc            i, 2
        //    59: goto            13
        //    62: aload           arg
        //    64: instanceof      Lgnu/kawa/xml/KAttr;
        //    67: ifeq            113
        //    70: aload           arg
        //    72: ldc             Lgnu/kawa/xml/KAttr;.class
        //    74: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    77: dup            
        //    78: astore          6
        //    80: checkcast       Lgnu/kawa/xml/KAttr;
        //    83: astore          attr
        //    85: aload           attr
        //    87: invokevirtual   gnu/kawa/xml/KAttr.getName:()Ljava/lang/String;
        //    90: astore          name
        //    92: aload           attr
        //    94: invokevirtual   gnu/kawa/xml/KAttr.getObjectValue:()Ljava/lang/Object;
        //    97: astore          value
        //    99: aload_1         /* button */
        //   100: aload           name
        //   102: aload           value
        //   104: invokestatic    gnu/kawa/slib/gui.buttonKeyword:(Lgnu/kawa/models/Button;Ljava/lang/String;Ljava/lang/Object;)V
        //   107: iinc            i, 1
        //   110: goto            13
        //   113: aload_1         /* button */
        //   114: aload           arg
        //   116: invokestatic    gnu/kawa/slib/gui.buttonNonKeyword:(Lgnu/kawa/models/Button;Ljava/lang/Object;)Z
        //   119: pop            
        //   120: iinc            i, 1
        //   123: goto            13
        //   126: aload_1         /* button */
        //   127: areturn        
        //   128: new             Lgnu/mapping/WrongType;
        //   131: dup_x1         
        //   132: swap           
        //   133: ldc             "gnu.expr.Keyword.getName()"
        //   135: iconst_1       
        //   136: aload           5
        //   138: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   141: athrow         
        //   142: new             Lgnu/mapping/WrongType;
        //   145: dup_x1         
        //   146: swap           
        //   147: ldc             "attr"
        //   149: bipush          -2
        //   151: aload           6
        //   153: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   156: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  42     45     128    142    Ljava/lang/ClassCastException;
        //  80     83     142    157    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0113:
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
    
    static void buttonKeyword(final Button button, final String name, final Object value) {
        if (name == "foreground") {
            button.setForeground(asColor(value));
            return;
        }
        if (name == "background") {
            button.setBackground(asColor(value));
            return;
        }
        if (name == "action") {
            button.setAction(value);
            return;
        }
        if (name == "text") {
            final Object force = Promise.force(value, String.class);
            button.setText((force == null) ? null : force.toString());
            return;
        }
        Label_0109: {
            if (name != "disabled") {
                break Label_0109;
            }
            final Object force2 = Promise.force(value);
            try {
                button.setDisabled(KawaConvert.isTrue(force2));
                return;
                exceptions.error(Format.formatToString(0, "unknown button attribute ~s", name));
                throw Special.reachedUnexpected;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "gnu.kawa.models.Button.setDisabled(boolean)", 2, force2);
            }
        }
    }
    
    static boolean buttonNonKeyword(final Button button, final Object arg) {
        return true;
    }
    
    public static Button Button(final Object... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/models/Button.<init>:()V
        //     7: astore_1        /* button */
        //     8: aload_0         /* args */
        //     9: arraylength    
        //    10: istore_2        /* num$Mnargs */
        //    11: iconst_0       
        //    12: istore_3        /* i */
        //    13: iload_3         /* i */
        //    14: iload_2         /* num$Mnargs */
        //    15: if_icmpge       126
        //    18: aload_0         /* args */
        //    19: iload_3         /* i */
        //    20: aaload         
        //    21: astore          arg
        //    23: aload           arg
        //    25: instanceof      Lgnu/expr/Keyword;
        //    28: ifeq            62
        //    31: aload_1         /* button */
        //    32: aload           arg
        //    34: ldc             Lgnu/expr/Keyword;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          5
        //    42: checkcast       Lgnu/expr/Keyword;
        //    45: invokevirtual   gnu/expr/Keyword.getName:()Ljava/lang/String;
        //    48: aload_0         /* args */
        //    49: iload_3         /* i */
        //    50: iconst_1       
        //    51: iadd           
        //    52: aaload         
        //    53: invokestatic    gnu/kawa/slib/gui.buttonKeyword:(Lgnu/kawa/models/Button;Ljava/lang/String;Ljava/lang/Object;)V
        //    56: iinc            i, 2
        //    59: goto            13
        //    62: aload           arg
        //    64: instanceof      Lgnu/kawa/xml/KAttr;
        //    67: ifeq            113
        //    70: aload           arg
        //    72: ldc             Lgnu/kawa/xml/KAttr;.class
        //    74: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    77: dup            
        //    78: astore          6
        //    80: checkcast       Lgnu/kawa/xml/KAttr;
        //    83: astore          attr
        //    85: aload           attr
        //    87: invokevirtual   gnu/kawa/xml/KAttr.getName:()Ljava/lang/String;
        //    90: astore          name
        //    92: aload           attr
        //    94: invokevirtual   gnu/kawa/xml/KAttr.getObjectValue:()Ljava/lang/Object;
        //    97: astore          value
        //    99: aload_1         /* button */
        //   100: aload           name
        //   102: aload           value
        //   104: invokestatic    gnu/kawa/slib/gui.buttonKeyword:(Lgnu/kawa/models/Button;Ljava/lang/String;Ljava/lang/Object;)V
        //   107: iinc            i, 1
        //   110: goto            13
        //   113: aload_1         /* button */
        //   114: aload           arg
        //   116: invokestatic    gnu/kawa/slib/gui.buttonNonKeyword:(Lgnu/kawa/models/Button;Ljava/lang/Object;)Z
        //   119: pop            
        //   120: iinc            i, 1
        //   123: goto            13
        //   126: aload_1         /* button */
        //   127: areturn        
        //   128: new             Lgnu/mapping/WrongType;
        //   131: dup_x1         
        //   132: swap           
        //   133: ldc             "gnu.expr.Keyword.getName()"
        //   135: iconst_1       
        //   136: aload           5
        //   138: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   141: athrow         
        //   142: new             Lgnu/mapping/WrongType;
        //   145: dup_x1         
        //   146: swap           
        //   147: ldc             "attr"
        //   149: bipush          -2
        //   151: aload           6
        //   153: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   156: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  42     45     128    142    Ljava/lang/ClassCastException;
        //  80     83     142    157    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0113:
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
    
    public static Label Label(final Object... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/models/Label.<init>:()V
        //     7: astore_1        /* instance */
        //     8: aload_0         /* args */
        //     9: arraylength    
        //    10: istore_2        /* num$Mnargs */
        //    11: iconst_0       
        //    12: istore_3        /* i */
        //    13: iload_3         /* i */
        //    14: iload_2         /* num$Mnargs */
        //    15: if_icmpge       125
        //    18: aload_0         /* args */
        //    19: iload_3         /* i */
        //    20: aaload         
        //    21: astore          arg
        //    23: aload           arg
        //    25: instanceof      Lgnu/expr/Keyword;
        //    28: ifeq            62
        //    31: aload_1         /* instance */
        //    32: aload           arg
        //    34: ldc             Lgnu/expr/Keyword;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          5
        //    42: checkcast       Lgnu/expr/Keyword;
        //    45: invokevirtual   gnu/expr/Keyword.getName:()Ljava/lang/String;
        //    48: aload_0         /* args */
        //    49: iload_3         /* i */
        //    50: iconst_1       
        //    51: iadd           
        //    52: aaload         
        //    53: invokestatic    gnu/kawa/slib/gui.labelKeyword:(Lgnu/kawa/models/Label;Ljava/lang/String;Ljava/lang/Object;)V
        //    56: iinc            i, 2
        //    59: goto            13
        //    62: aload           arg
        //    64: instanceof      Lgnu/kawa/xml/KAttr;
        //    67: ifeq            113
        //    70: aload           arg
        //    72: ldc             Lgnu/kawa/xml/KAttr;.class
        //    74: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    77: dup            
        //    78: astore          6
        //    80: checkcast       Lgnu/kawa/xml/KAttr;
        //    83: astore          attr
        //    85: aload           attr
        //    87: invokevirtual   gnu/kawa/xml/KAttr.getName:()Ljava/lang/String;
        //    90: astore          name
        //    92: aload           attr
        //    94: invokevirtual   gnu/kawa/xml/KAttr.getObjectValue:()Ljava/lang/Object;
        //    97: astore          value
        //    99: aload_1         /* instance */
        //   100: aload           name
        //   102: aload           value
        //   104: invokestatic    gnu/kawa/slib/gui.labelKeyword:(Lgnu/kawa/models/Label;Ljava/lang/String;Ljava/lang/Object;)V
        //   107: iinc            i, 1
        //   110: goto            13
        //   113: aload_1         /* instance */
        //   114: aload           arg
        //   116: invokestatic    gnu/kawa/slib/gui.labelNonKeyword:(Lgnu/kawa/models/Label;Ljava/lang/Object;)V
        //   119: iinc            i, 1
        //   122: goto            13
        //   125: aload_1         /* instance */
        //   126: areturn        
        //   127: new             Lgnu/mapping/WrongType;
        //   130: dup_x1         
        //   131: swap           
        //   132: ldc             "gnu.expr.Keyword.getName()"
        //   134: iconst_1       
        //   135: aload           5
        //   137: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   140: athrow         
        //   141: new             Lgnu/mapping/WrongType;
        //   144: dup_x1         
        //   145: swap           
        //   146: ldc             "attr"
        //   148: bipush          -2
        //   150: aload           6
        //   152: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   155: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  42     45     127    141    Ljava/lang/ClassCastException;
        //  80     83     141    156    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0113:
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
    
    static void labelKeyword(final Label instance, final String name, final Object value) {
        if (name == gui.Lit1) {
            final Object force = Promise.force(value, String.class);
            instance.setText((force == null) ? null : force.toString());
            return;
        }
        exceptions.error(Format.formatToString(0, "unknown label attribute ~s", name));
        throw Special.reachedUnexpected;
    }
    
    static void labelNonKeyword(final Label instance, final Object arg) {
        final Object force = Promise.force(arg, String.class);
        instance.setText((force == null) ? null : force.toString());
    }
    
    public static Text Text(final Object... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/models/Text.<init>:()V
        //     7: astore_1        /* instance */
        //     8: aload_0         /* args */
        //     9: arraylength    
        //    10: istore_2        /* num$Mnargs */
        //    11: iconst_0       
        //    12: istore_3        /* i */
        //    13: iload_3         /* i */
        //    14: iload_2         /* num$Mnargs */
        //    15: if_icmpge       125
        //    18: aload_0         /* args */
        //    19: iload_3         /* i */
        //    20: aaload         
        //    21: astore          arg
        //    23: aload           arg
        //    25: instanceof      Lgnu/expr/Keyword;
        //    28: ifeq            62
        //    31: aload_1         /* instance */
        //    32: aload           arg
        //    34: ldc             Lgnu/expr/Keyword;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          5
        //    42: checkcast       Lgnu/expr/Keyword;
        //    45: invokevirtual   gnu/expr/Keyword.getName:()Ljava/lang/String;
        //    48: aload_0         /* args */
        //    49: iload_3         /* i */
        //    50: iconst_1       
        //    51: iadd           
        //    52: aaload         
        //    53: invokestatic    gnu/kawa/slib/gui.textKeyword:(Lgnu/kawa/models/Text;Ljava/lang/String;Ljava/lang/Object;)V
        //    56: iinc            i, 2
        //    59: goto            13
        //    62: aload           arg
        //    64: instanceof      Lgnu/kawa/xml/KAttr;
        //    67: ifeq            113
        //    70: aload           arg
        //    72: ldc             Lgnu/kawa/xml/KAttr;.class
        //    74: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    77: dup            
        //    78: astore          6
        //    80: checkcast       Lgnu/kawa/xml/KAttr;
        //    83: astore          attr
        //    85: aload           attr
        //    87: invokevirtual   gnu/kawa/xml/KAttr.getName:()Ljava/lang/String;
        //    90: astore          name
        //    92: aload           attr
        //    94: invokevirtual   gnu/kawa/xml/KAttr.getObjectValue:()Ljava/lang/Object;
        //    97: astore          value
        //    99: aload_1         /* instance */
        //   100: aload           name
        //   102: aload           value
        //   104: invokestatic    gnu/kawa/slib/gui.textKeyword:(Lgnu/kawa/models/Text;Ljava/lang/String;Ljava/lang/Object;)V
        //   107: iinc            i, 1
        //   110: goto            13
        //   113: aload_1         /* instance */
        //   114: aload           arg
        //   116: invokestatic    gnu/kawa/slib/gui.textNonKeyword:(Lgnu/kawa/models/Text;Ljava/lang/Object;)V
        //   119: iinc            i, 1
        //   122: goto            13
        //   125: aload_1         /* instance */
        //   126: areturn        
        //   127: new             Lgnu/mapping/WrongType;
        //   130: dup_x1         
        //   131: swap           
        //   132: ldc             "gnu.expr.Keyword.getName()"
        //   134: iconst_1       
        //   135: aload           5
        //   137: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   140: athrow         
        //   141: new             Lgnu/mapping/WrongType;
        //   144: dup_x1         
        //   145: swap           
        //   146: ldc             "attr"
        //   148: bipush          -2
        //   150: aload           6
        //   152: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   155: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  42     45     127    141    Ljava/lang/ClassCastException;
        //  80     83     141    156    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0113:
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
    
    static void textKeyword(final Text instance, final String name, final Object value) {
        if (name == gui.Lit1) {
            final Object force = Promise.force(value, String.class);
            instance.setText((force == null) ? null : force.toString());
            return;
        }
        exceptions.error(Format.formatToString(0, "unknown text attribute ~s", name));
        throw Special.reachedUnexpected;
    }
    
    static void textNonKeyword(final Text instance, final Object arg) {
        final Object force = Promise.force(arg, String.class);
        instance.setText((force == null) ? null : force.toString());
    }
    
    public static Row Row(final Object... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/models/Row.<init>:()V
        //     7: astore_1        /* instance */
        //     8: aload_0         /* args */
        //     9: arraylength    
        //    10: istore_2        /* num$Mnargs */
        //    11: iconst_0       
        //    12: istore_3        /* i */
        //    13: iload_3         /* i */
        //    14: iload_2         /* num$Mnargs */
        //    15: if_icmpge       125
        //    18: aload_0         /* args */
        //    19: iload_3         /* i */
        //    20: aaload         
        //    21: astore          arg
        //    23: aload           arg
        //    25: instanceof      Lgnu/expr/Keyword;
        //    28: ifeq            62
        //    31: aload_1         /* instance */
        //    32: aload           arg
        //    34: ldc             Lgnu/expr/Keyword;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          5
        //    42: checkcast       Lgnu/expr/Keyword;
        //    45: invokevirtual   gnu/expr/Keyword.getName:()Ljava/lang/String;
        //    48: aload_0         /* args */
        //    49: iload_3         /* i */
        //    50: iconst_1       
        //    51: iadd           
        //    52: aaload         
        //    53: invokestatic    gnu/kawa/slib/gui.boxKeyword:(Lgnu/kawa/models/Box;Ljava/lang/String;Ljava/lang/Object;)V
        //    56: iinc            i, 2
        //    59: goto            13
        //    62: aload           arg
        //    64: instanceof      Lgnu/kawa/xml/KAttr;
        //    67: ifeq            113
        //    70: aload           arg
        //    72: ldc             Lgnu/kawa/xml/KAttr;.class
        //    74: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    77: dup            
        //    78: astore          6
        //    80: checkcast       Lgnu/kawa/xml/KAttr;
        //    83: astore          attr
        //    85: aload           attr
        //    87: invokevirtual   gnu/kawa/xml/KAttr.getName:()Ljava/lang/String;
        //    90: astore          name
        //    92: aload           attr
        //    94: invokevirtual   gnu/kawa/xml/KAttr.getObjectValue:()Ljava/lang/Object;
        //    97: astore          value
        //    99: aload_1         /* instance */
        //   100: aload           name
        //   102: aload           value
        //   104: invokestatic    gnu/kawa/slib/gui.boxKeyword:(Lgnu/kawa/models/Box;Ljava/lang/String;Ljava/lang/Object;)V
        //   107: iinc            i, 1
        //   110: goto            13
        //   113: aload_1         /* instance */
        //   114: aload           arg
        //   116: invokestatic    gnu/kawa/slib/gui.boxNonKeyword:(Lgnu/kawa/models/Box;Ljava/lang/Object;)V
        //   119: iinc            i, 1
        //   122: goto            13
        //   125: aload_1         /* instance */
        //   126: areturn        
        //   127: new             Lgnu/mapping/WrongType;
        //   130: dup_x1         
        //   131: swap           
        //   132: ldc             "gnu.expr.Keyword.getName()"
        //   134: iconst_1       
        //   135: aload           5
        //   137: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   140: athrow         
        //   141: new             Lgnu/mapping/WrongType;
        //   144: dup_x1         
        //   145: swap           
        //   146: ldc             "attr"
        //   148: bipush          -2
        //   150: aload           6
        //   152: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   155: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  42     45     127    141    Ljava/lang/ClassCastException;
        //  80     83     141    156    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0113:
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
    
    static void boxKeyword(final Box instance, final String name, final Object value) {
        if (name == gui.Lit2) {
            instance.setCellSpacing(value);
            return;
        }
        exceptions.error(Format.formatToString(0, "unknown box attribute ~s", name));
        throw Special.reachedUnexpected;
    }
    
    static void boxNonKeyword(final Box box, final Object arg) {
        box.add(asModel(arg));
    }
    
    public static Column Column(final Object... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/models/Column.<init>:()V
        //     7: astore_1        /* instance */
        //     8: aload_0         /* args */
        //     9: arraylength    
        //    10: istore_2        /* num$Mnargs */
        //    11: iconst_0       
        //    12: istore_3        /* i */
        //    13: iload_3         /* i */
        //    14: iload_2         /* num$Mnargs */
        //    15: if_icmpge       125
        //    18: aload_0         /* args */
        //    19: iload_3         /* i */
        //    20: aaload         
        //    21: astore          arg
        //    23: aload           arg
        //    25: instanceof      Lgnu/expr/Keyword;
        //    28: ifeq            62
        //    31: aload_1         /* instance */
        //    32: aload           arg
        //    34: ldc             Lgnu/expr/Keyword;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          5
        //    42: checkcast       Lgnu/expr/Keyword;
        //    45: invokevirtual   gnu/expr/Keyword.getName:()Ljava/lang/String;
        //    48: aload_0         /* args */
        //    49: iload_3         /* i */
        //    50: iconst_1       
        //    51: iadd           
        //    52: aaload         
        //    53: invokestatic    gnu/kawa/slib/gui.boxKeyword:(Lgnu/kawa/models/Box;Ljava/lang/String;Ljava/lang/Object;)V
        //    56: iinc            i, 2
        //    59: goto            13
        //    62: aload           arg
        //    64: instanceof      Lgnu/kawa/xml/KAttr;
        //    67: ifeq            113
        //    70: aload           arg
        //    72: ldc             Lgnu/kawa/xml/KAttr;.class
        //    74: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    77: dup            
        //    78: astore          6
        //    80: checkcast       Lgnu/kawa/xml/KAttr;
        //    83: astore          attr
        //    85: aload           attr
        //    87: invokevirtual   gnu/kawa/xml/KAttr.getName:()Ljava/lang/String;
        //    90: astore          name
        //    92: aload           attr
        //    94: invokevirtual   gnu/kawa/xml/KAttr.getObjectValue:()Ljava/lang/Object;
        //    97: astore          value
        //    99: aload_1         /* instance */
        //   100: aload           name
        //   102: aload           value
        //   104: invokestatic    gnu/kawa/slib/gui.boxKeyword:(Lgnu/kawa/models/Box;Ljava/lang/String;Ljava/lang/Object;)V
        //   107: iinc            i, 1
        //   110: goto            13
        //   113: aload_1         /* instance */
        //   114: aload           arg
        //   116: invokestatic    gnu/kawa/slib/gui.boxNonKeyword:(Lgnu/kawa/models/Box;Ljava/lang/Object;)V
        //   119: iinc            i, 1
        //   122: goto            13
        //   125: aload_1         /* instance */
        //   126: areturn        
        //   127: new             Lgnu/mapping/WrongType;
        //   130: dup_x1         
        //   131: swap           
        //   132: ldc             "gnu.expr.Keyword.getName()"
        //   134: iconst_1       
        //   135: aload           5
        //   137: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   140: athrow         
        //   141: new             Lgnu/mapping/WrongType;
        //   144: dup_x1         
        //   145: swap           
        //   146: ldc             "attr"
        //   148: bipush          -2
        //   150: aload           6
        //   152: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   155: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  42     45     127    141    Ljava/lang/ClassCastException;
        //  80     83     141    156    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0113:
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
    
    public static void setContent(final Window window, final Object pane) {
        window.setContent(pane);
    }
    
    public static Window Window(final Object... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokevirtual   gnu/kawa/models/Display.makeWindow:()Lgnu/kawa/models/Window;
        //     6: astore_1        /* instance */
        //     7: aload_0         /* args */
        //     8: arraylength    
        //     9: istore_2        /* num$Mnargs */
        //    10: iconst_0       
        //    11: istore_3        /* i */
        //    12: iload_3         /* i */
        //    13: iload_2         /* num$Mnargs */
        //    14: if_icmpge       124
        //    17: aload_0         /* args */
        //    18: iload_3         /* i */
        //    19: aaload         
        //    20: astore          arg
        //    22: aload           arg
        //    24: instanceof      Lgnu/expr/Keyword;
        //    27: ifeq            61
        //    30: aload_1         /* instance */
        //    31: aload           arg
        //    33: ldc             Lgnu/expr/Keyword;.class
        //    35: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    38: dup            
        //    39: astore          5
        //    41: checkcast       Lgnu/expr/Keyword;
        //    44: invokevirtual   gnu/expr/Keyword.getName:()Ljava/lang/String;
        //    47: aload_0         /* args */
        //    48: iload_3         /* i */
        //    49: iconst_1       
        //    50: iadd           
        //    51: aaload         
        //    52: invokestatic    gnu/kawa/slib/gui.windowKeyword:(Lgnu/kawa/models/Window;Ljava/lang/String;Ljava/lang/Object;)V
        //    55: iinc            i, 2
        //    58: goto            12
        //    61: aload           arg
        //    63: instanceof      Lgnu/kawa/xml/KAttr;
        //    66: ifeq            112
        //    69: aload           arg
        //    71: ldc             Lgnu/kawa/xml/KAttr;.class
        //    73: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    76: dup            
        //    77: astore          6
        //    79: checkcast       Lgnu/kawa/xml/KAttr;
        //    82: astore          attr
        //    84: aload           attr
        //    86: invokevirtual   gnu/kawa/xml/KAttr.getName:()Ljava/lang/String;
        //    89: astore          name
        //    91: aload           attr
        //    93: invokevirtual   gnu/kawa/xml/KAttr.getObjectValue:()Ljava/lang/Object;
        //    96: astore          value
        //    98: aload_1         /* instance */
        //    99: aload           name
        //   101: aload           value
        //   103: invokestatic    gnu/kawa/slib/gui.windowKeyword:(Lgnu/kawa/models/Window;Ljava/lang/String;Ljava/lang/Object;)V
        //   106: iinc            i, 1
        //   109: goto            12
        //   112: aload_1         /* instance */
        //   113: aload           arg
        //   115: invokestatic    gnu/kawa/slib/gui.windowNonKeyword:(Lgnu/kawa/models/Window;Ljava/lang/Object;)V
        //   118: iinc            i, 1
        //   121: goto            12
        //   124: aload_1         /* instance */
        //   125: areturn        
        //   126: new             Lgnu/mapping/WrongType;
        //   129: dup_x1         
        //   130: swap           
        //   131: ldc             "gnu.expr.Keyword.getName()"
        //   133: iconst_1       
        //   134: aload           5
        //   136: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   139: athrow         
        //   140: new             Lgnu/mapping/WrongType;
        //   143: dup_x1         
        //   144: swap           
        //   145: ldc             "attr"
        //   147: bipush          -2
        //   149: aload           6
        //   151: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   154: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  41     44     126    140    Ljava/lang/ClassCastException;
        //  79     82     140    155    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0112:
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
    
    static void windowKeyword(final Window instance, final String name, final Object value) {
        if (name == "title") {
            final Object force = Promise.force(value, String.class);
            instance.setTitle((force == null) ? null : force.toString());
        }
        else if (name == "content") {
            instance.setContent(value);
        }
        else {
            if (name != "menubar") {
                exceptions.error(Format.formatToString(0, "unknown window attribute ~s", name));
                throw Special.reachedUnexpected;
            }
            instance.setMenuBar(value);
        }
    }
    
    static void windowNonKeyword(final Window instance, final Object arg) {
        instance.setContent(arg);
    }
    
    static Model asModel(final Object arg) {
        return Display.getInstance().coerceToModel(arg);
    }
    
    static {
        Lit20 = new Object[0];
        Lit19 = new SyntaxRules(gui.Lit20, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", gui.Lit20, 1, "gui.scm:193"), "\u0001", "\u0011\u0018\u0004\b\u0003", new Object[] { PairWithPosition.make(Symbol.valueOf("$lookup$"), Pair.make(Symbol.valueOf("gnu.kawa.models.Window"), Pair.make(Pair.make(Symbol.valueOf("quasiquote"), Pair.make(Symbol.valueOf("open"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/gui.scm", 794631) }, 0) }, 1, Lit18 = Symbol.valueOf("run-application"));
        Lit17 = Symbol.valueOf("Window");
        Lit16 = Symbol.valueOf("set-content");
        Lit15 = Symbol.valueOf("Column");
        Lit14 = Symbol.valueOf("Row");
        Lit13 = Symbol.valueOf("Text");
        Lit12 = Symbol.valueOf("Label");
        Lit11 = new SyntaxRules(gui.Lit20, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", gui.Lit20, 1, "gui.scm:87"), "\u0000", "\u0011\u0018\u0004\u0011\u0018\f\u0002", new Object[] { Symbol.valueOf("make"), Symbol.valueOf("<gnu.kawa.models.DrawImage>") }, 0) }, 1, Lit10 = Symbol.valueOf("Image"));
        Lit9 = Symbol.valueOf("Button");
        Lit8 = Symbol.valueOf("button");
        Lit7 = Symbol.valueOf("as-color");
        Lit6 = Symbol.valueOf("rotation");
        Lit5 = Symbol.valueOf("composite-src");
        Lit4 = Symbol.valueOf("composite-src-over");
        Lit3 = Symbol.valueOf("polygon");
        Lit2 = Symbol.valueOf("cell-spacing");
        Lit1 = Symbol.valueOf("text");
        Lit0 = Color.class;
        gui.$instance = new gui();
        make$MnPoint = StaticFieldLocation.make("kawa.lib.kawa.pictures", "make$MnPoint");
        P = StaticFieldLocation.make("kawa.lib.kawa.pictures", "P");
        circle = StaticFieldLocation.make("kawa.lib.kawa.pictures", "circle");
        fill = StaticFieldLocation.make("kawa.lib.kawa.pictures", "fill");
        draw = StaticFieldLocation.make("kawa.lib.kawa.pictures", "draw");
        image$Mnread = StaticFieldLocation.make("kawa.lib.kawa.pictures", "image$Mnread");
        image$Mnwidth = StaticFieldLocation.make("kawa.lib.kawa.pictures", "image$Mnwidth");
        image$Mnheight = StaticFieldLocation.make("kawa.lib.kawa.pictures", "image$Mnheight");
        with$Mnpaint = StaticFieldLocation.make("kawa.lib.kawa.pictures", "with$Mnpaint");
        with$Mntransform = StaticFieldLocation.make("kawa.lib.kawa.pictures", "with$Mntransform");
        with$Mncomposite = StaticFieldLocation.make("kawa.lib.kawa.pictures", "with$Mncomposite");
        process$Mnkeywords = StaticFieldLocation.make("kawa.lib.kawa.process-keywords", "process$Mnkeywords");
        final gui $instance = gui.$instance;
        polygon = new ModuleMethod($instance, 1, gui.Lit3, -4095);
        composite$Mnsrc$Mnover = new ModuleMethod($instance, 2, gui.Lit4, 4096);
        composite$Mnsrc = new ModuleMethod($instance, 4, gui.Lit5, 4096);
        rotation = new ModuleMethod($instance, 6, gui.Lit6, 4097);
        as$Mncolor = new ModuleMethod($instance, 7, gui.Lit7, 4097);
        button = new ModuleMethod($instance, 8, gui.Lit8, -4096);
        Button = new ModuleMethod($instance, 9, gui.Lit9, -4096);
        Image = Macro.make(gui.Lit10, gui.Lit11, "gnu.kawa.slib.gui");
        Label = new ModuleMethod($instance, 10, gui.Lit12, -4096);
        Text = new ModuleMethod($instance, 11, gui.Lit13, -4096);
        Row = new ModuleMethod($instance, 12, gui.Lit14, -4096);
        Column = new ModuleMethod($instance, 13, gui.Lit15, -4096);
        set$Mncontent = new ModuleMethod($instance, 14, gui.Lit16, 8194);
        Window = new ModuleMethod($instance, 15, gui.Lit17, -4096);
        run$Mnapplication = Macro.make(gui.Lit18, gui.Lit19, "gnu.kawa.slib.gui");
        $runBody$();
    }
    
    public gui() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match0(final ModuleMethod proc, final CallContext ctx) {
        switch (proc.selector) {
            case 4: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 2: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            default: {
                return super.match0(proc, ctx);
            }
        }
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 7: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 6: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                ctx.value1 = Promise.force(arg1);
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                ctx.value1 = Promise.force(arg1);
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
        if (moduleMethod.selector != 14) {
            return super.match2(moduleMethod, o, o2, ctx);
        }
        final Object force = Promise.force(o, Window.class);
        if (!(force instanceof Window)) {
            return -786431;
        }
        ctx.value1 = force;
        ctx.value2 = o2;
        ctx.proc = moduleMethod;
        ctx.pc = 2;
        return 0;
    }
    
    @Override
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        switch (proc.selector) {
            case 15: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 13: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 12: {
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
            case 8: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 1: {
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
    public Object apply0(final ModuleMethod method) {
        switch (method.selector) {
            case 2: {
                return compositeSrcOver();
            }
            case 4: {
                return compositeSrc();
            }
            default: {
                return super.apply0(method);
            }
        }
    }
    
    @Override
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                4: 44
        //                5: 91
        //                6: 58
        //                7: 91
        //                8: 72
        //                9: 86
        //          default: 91
        //        }
        //    44: aload_2        
        //    45: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    48: checkcast       Ljava/lang/Number;
        //    51: invokevirtual   java/lang/Number.floatValue:()F
        //    54: invokestatic    gnu/kawa/slib/gui.compositeSrcOver:(F)Ljava/awt/Composite;
        //    57: areturn        
        //    58: aload_2        
        //    59: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    62: checkcast       Ljava/lang/Number;
        //    65: invokevirtual   java/lang/Number.floatValue:()F
        //    68: invokestatic    gnu/kawa/slib/gui.compositeSrc:(F)Ljava/awt/Composite;
        //    71: areturn        
        //    72: aload_2        
        //    73: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    76: checkcast       Ljava/lang/Number;
        //    79: invokevirtual   java/lang/Number.doubleValue:()D
        //    82: invokestatic    gnu/kawa/slib/gui.rotation:(D)Ljava/awt/geom/AffineTransform;
        //    85: areturn        
        //    86: aload_2        
        //    87: invokestatic    gnu/kawa/slib/gui.asColor:(Ljava/lang/Object;)Ljava/awt/Color;
        //    90: areturn        
        //    91: aload_0        
        //    92: aload_1        
        //    93: aload_2        
        //    94: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //    97: areturn        
        //    98: new             Lgnu/mapping/WrongType;
        //   101: dup_x1         
        //   102: swap           
        //   103: ldc_w           "composite-src-over"
        //   106: iconst_1       
        //   107: aload_2        
        //   108: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   111: athrow         
        //   112: new             Lgnu/mapping/WrongType;
        //   115: dup_x1         
        //   116: swap           
        //   117: ldc_w           "composite-src"
        //   120: iconst_1       
        //   121: aload_2        
        //   122: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   125: athrow         
        //   126: new             Lgnu/mapping/WrongType;
        //   129: dup_x1         
        //   130: swap           
        //   131: ldc_w           "rotation"
        //   134: iconst_1       
        //   135: aload_2        
        //   136: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   139: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  48     54     98     112    Ljava/lang/ClassCastException;
        //  62     68     112    126    Ljava/lang/ClassCastException;
        //  76     82     126    140    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 53 out of bounds for length 53
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
    public Object apply2(final ModuleMethod method, final Object argValue, final Object o) {
        Label_0029: {
            if (method.selector != 14) {
                break Label_0029;
            }
            final Object force = Promise.force(argValue, Window.class);
            try {
                setContent((Window)force, o);
                return Values.empty;
                return super.apply2(method, argValue, o);
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "set-content", 1, argValue);
            }
        }
    }
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] array) {
    Label_0134_Outer:
        while (true) {
        Label_0149_Outer:
            while (true) {
            Label_0129_Outer:
                while (true) {
                Label_0154_Outer:
                    while (true) {
                    Label_0144_Outer:
                        while (true) {
                        Label_0124_Outer:
                            while (true) {
                            Label_0139_Outer:
                                while (true) {
                                    while (true) {
                                        switch (method.selector) {
                                            case 1: {
                                                final Object force = Promise.force(array[0], Complex.class);
                                                try {
                                                    final Complex initial = (Complex)force;
                                                    int n = array.length - 1;
                                                    final Object[] more$Mnpoints = new Object[n];
                                                    while (--n >= 0) {
                                                        more$Mnpoints[n] = array[n + 1];
                                                    }
                                                    return polygon(initial, more$Mnpoints);
                                                    return super.applyN(method, array);
                                                    return Label(array);
                                                    return Column(array);
                                                    return Button(array);
                                                    return Window(array);
                                                    return Row(array);
                                                    return button(array);
                                                    return Text(array);
                                                }
                                                catch (ClassCastException ex) {
                                                    throw new WrongType(ex, "polygon", 1, force);
                                                }
                                                break;
                                            }
                                            case 8: {
                                                continue Label_0139_Outer;
                                            }
                                            case 9: {
                                                continue Label_0154_Outer;
                                            }
                                            case 10: {
                                                continue Label_0149_Outer;
                                            }
                                            case 11: {
                                                continue;
                                            }
                                            case 12: {
                                                continue Label_0124_Outer;
                                            }
                                            case 13: {
                                                continue Label_0129_Outer;
                                            }
                                            case 15: {
                                                continue Label_0144_Outer;
                                            }
                                            default: {
                                                continue Label_0134_Outer;
                                            }
                                        }
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    break;
                }
                break;
            }
            break;
        }
    }
}
