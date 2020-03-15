// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.kawa;

import gnu.mapping.Values;
import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import javax.swing.JFrame;
import gnu.kawa.swingviews.SwingFrame;
import gnu.kawa.swingviews.SwingPicture;
import gnu.lists.Consumer;
import kawa.lib.parameters;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.Keyword;
import java.awt.Dimension;
import gnu.mapping.LocationProc;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class swing extends ModuleBody
{
    public static final ModuleMethod picture$Mn$Grjpanel;
    public static final ModuleMethod frame;
    public static LocationProc current$Mnframe;
    public static LocationProc current$Mnpicture$Mnpanel;
    static ThreadLocal<Dimension> default$Mnframe$Mnsize;
    public static final ModuleMethod set$Mnframe$Mnsize$Ex;
    public static final ModuleMethod show$Mnpicture;
    static final Keyword Lit0;
    public static swing $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        swing.current$Mnframe = parameters.makeParameter(null);
        swing.current$Mnpicture$Mnpanel = parameters.makeParameter(null);
        swing.default$Mnframe$Mnsize = new ThreadLocal<Dimension>();
    }
    
    public static SwingPicture picture$To$Jpanel(final Object pic) {
        return new SwingPicture(pictures.$To$Picture(pic));
    }
    
    public static SwingFrame frame(final Object... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aconst_null    
        //     5: aconst_null    
        //     6: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //     9: invokespecial   gnu/kawa/swingviews/SwingFrame.<init>:(Ljava/lang/String;Ljavax/swing/JMenuBar;Ljava/lang/Object;)V
        //    12: astore_1        /* frame */
        //    13: aload_0         /* args */
        //    14: arraylength    
        //    15: istore_2        /* num$Mnargs */
        //    16: iconst_0       
        //    17: istore_3        /* i */
        //    18: iload_3         /* i */
        //    19: iload_2         /* num$Mnargs */
        //    20: if_icmpge       130
        //    23: aload_0         /* args */
        //    24: iload_3         /* i */
        //    25: aaload         
        //    26: astore          arg
        //    28: aload           arg
        //    30: instanceof      Lgnu/expr/Keyword;
        //    33: ifeq            67
        //    36: aload_1         /* frame */
        //    37: aload           arg
        //    39: ldc             Lgnu/expr/Keyword;.class
        //    41: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    44: dup            
        //    45: astore          5
        //    47: checkcast       Lgnu/expr/Keyword;
        //    50: invokevirtual   gnu/expr/Keyword.getName:()Ljava/lang/String;
        //    53: aload_0         /* args */
        //    54: iload_3         /* i */
        //    55: iconst_1       
        //    56: iadd           
        //    57: aaload         
        //    58: invokestatic    kawa/lib/kawa/swing.frameKeyword:(Lgnu/kawa/swingviews/SwingFrame;Ljava/lang/String;Ljava/lang/Object;)V
        //    61: iinc            i, 2
        //    64: goto            18
        //    67: aload           arg
        //    69: instanceof      Lgnu/kawa/xml/KAttr;
        //    72: ifeq            118
        //    75: aload           arg
        //    77: ldc             Lgnu/kawa/xml/KAttr;.class
        //    79: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    82: dup            
        //    83: astore          6
        //    85: checkcast       Lgnu/kawa/xml/KAttr;
        //    88: astore          attr
        //    90: aload           attr
        //    92: invokevirtual   gnu/kawa/xml/KAttr.getName:()Ljava/lang/String;
        //    95: astore          name
        //    97: aload           attr
        //    99: invokevirtual   gnu/kawa/xml/KAttr.getObjectValue:()Ljava/lang/Object;
        //   102: astore          value
        //   104: aload_1         /* frame */
        //   105: aload           name
        //   107: aload           value
        //   109: invokestatic    kawa/lib/kawa/swing.frameKeyword:(Lgnu/kawa/swingviews/SwingFrame;Ljava/lang/String;Ljava/lang/Object;)V
        //   112: iinc            i, 1
        //   115: goto            18
        //   118: aload_1         /* frame */
        //   119: aload           arg
        //   121: invokestatic    kawa/lib/kawa/swing.frameNonKeyword:(Lgnu/kawa/swingviews/SwingFrame;Ljava/lang/Object;)V
        //   124: iinc            i, 1
        //   127: goto            18
        //   130: aload_1         /* frame */
        //   131: invokevirtual   gnu/kawa/swingviews/SwingFrame.pack:()V
        //   134: aload_1         /* frame */
        //   135: iconst_1       
        //   136: invokevirtual   gnu/kawa/swingviews/SwingFrame.setVisible:(Z)V
        //   139: aload_1         /* frame */
        //   140: areturn        
        //   141: new             Lgnu/mapping/WrongType;
        //   144: dup_x1         
        //   145: swap           
        //   146: ldc             "gnu.expr.Keyword.getName()"
        //   148: iconst_1       
        //   149: aload           5
        //   151: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   154: athrow         
        //   155: new             Lgnu/mapping/WrongType;
        //   158: dup_x1         
        //   159: swap           
        //   160: ldc             "attr"
        //   162: bipush          -2
        //   164: aload           6
        //   166: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   169: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  47     50     141    155    Ljava/lang/ClassCastException;
        //  85     88     155    170    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0118:
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
    
    static void frameKeyword(final SwingFrame frame, final String name, final Object value) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "title"
        //     3: iconst_0       
        //     4: anewarray       Ljava/lang/CharSequence;
        //     7: invokestatic    kawa/lib/strings.isString$Eq:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
        //    10: ifeq            38
        //    13: aload_0         /* frame */
        //    14: aload_2         /* value */
        //    15: ldc             Ljava/lang/String;.class
        //    17: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    20: dup            
        //    21: ifnonnull       29
        //    24: pop            
        //    25: aconst_null    
        //    26: goto            32
        //    29: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    32: invokevirtual   gnu/kawa/swingviews/SwingFrame.setTitle:(Ljava/lang/String;)V
        //    35: goto            131
        //    38: aload_1         /* name */
        //    39: ldc             "menubar"
        //    41: iconst_0       
        //    42: anewarray       Ljava/lang/CharSequence;
        //    45: invokestatic    kawa/lib/strings.isString$Eq:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
        //    48: ifeq            69
        //    51: aload_0         /* frame */
        //    52: aload_2         /* value */
        //    53: ldc             Ljavax/swing/JMenuBar;.class
        //    55: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    58: dup            
        //    59: astore_3       
        //    60: checkcast       Ljavax/swing/JMenuBar;
        //    63: invokevirtual   gnu/kawa/swingviews/SwingFrame.setJMenuBar:(Ljavax/swing/JMenuBar;)V
        //    66: goto            131
        //    69: aload_1         /* name */
        //    70: ldc             "size"
        //    72: iconst_0       
        //    73: anewarray       Ljava/lang/CharSequence;
        //    76: invokestatic    kawa/lib/strings.isString$Eq:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
        //    79: ifeq            100
        //    82: aload_0         /* frame */
        //    83: aload_2         /* value */
        //    84: ldc             Ljava/awt/Dimension;.class
        //    86: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    89: dup            
        //    90: astore_3       
        //    91: checkcast       Ljava/awt/Dimension;
        //    94: invokevirtual   gnu/kawa/swingviews/SwingFrame.setSize:(Ljava/awt/Dimension;)V
        //    97: goto            131
        //   100: iconst_1       
        //   101: anewarray       Ljava/lang/Object;
        //   104: dup            
        //   105: iconst_0       
        //   106: iconst_0       
        //   107: iconst_2       
        //   108: anewarray       Ljava/lang/Object;
        //   111: dup            
        //   112: iconst_0       
        //   113: ldc             "unknown frame attribute ~s"
        //   115: aastore        
        //   116: dup            
        //   117: iconst_1       
        //   118: aload_1         /* name */
        //   119: aastore        
        //   120: invokestatic    gnu/kawa/functions/Format.formatToString:(I[Ljava/lang/Object;)Ljava/lang/String;
        //   123: aastore        
        //   124: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   127: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   130: athrow         
        //   131: return         
        //   132: new             Lgnu/mapping/WrongType;
        //   135: dup_x1         
        //   136: swap           
        //   137: ldc             "gnu.kawa.swingviews.SwingFrame.setJMenuBar(javax.swing.JMenuBar)"
        //   139: iconst_2       
        //   140: aload_3        
        //   141: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   144: athrow         
        //   145: new             Lgnu/mapping/WrongType;
        //   148: dup_x1         
        //   149: swap           
        //   150: ldc             "gnu.kawa.swingviews.SwingFrame.setSize(java.awt.Dimension)"
        //   152: iconst_2       
        //   153: aload_3        
        //   154: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   157: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  60     63     132    145    Ljava/lang/ClassCastException;
        //  91     94     145    158    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0100:
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
    
    static void frameNonKeyword(final SwingFrame frame, final Object arg) {
        frame.addComponent(arg);
    }
    
    public static void setFrameSize$Ex(final Dimension size) {
        setFrameSize$Ex(size, null);
    }
    
    public static void setFrameSize$Ex(final Dimension size, final JFrame frame) {
        if (frame != null) {
            frame.setSize(size);
            return;
        }
        final Object force = Promise.force(swing.current$Mnframe.getValue(), JFrame.class);
        try {
            final JFrame cur$Mnframe = (JFrame)force;
            swing.default$Mnframe$Mnsize.set(size);
            if (cur$Mnframe != null) {
                cur$Mnframe.setSize(size);
            }
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "cur-frame", -2, force);
        }
    }
    
    public static void showPicture(final Object picture) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokevirtual   gnu/mapping/LocationProc.getValue:()Ljava/lang/Object;
        //     6: ldc             Lgnu/kawa/swingviews/SwingPicture;.class
        //     8: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    11: dup            
        //    12: astore_2       
        //    13: checkcast       Lgnu/kawa/swingviews/SwingPicture;
        //    16: astore_1        /* panel */
        //    17: aload_1         /* panel */
        //    18: ifnonnull       37
        //    21: aload_0         /* picture */
        //    22: invokestatic    kawa/lib/kawa/swing.picture$To$Jpanel:(Ljava/lang/Object;)Lgnu/kawa/swingviews/SwingPicture;
        //    25: astore_1        /* panel */
        //    26: getstatic       kawa/lib/kawa/swing.current$Mnpicture$Mnpanel:Lgnu/mapping/LocationProc;
        //    29: aload_1         /* panel */
        //    30: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    33: pop            
        //    34: goto            42
        //    37: aload_1         /* panel */
        //    38: aload_0         /* picture */
        //    39: invokevirtual   gnu/kawa/swingviews/SwingPicture.setPicture:(Ljava/lang/Object;)V
        //    42: getstatic       kawa/lib/kawa/swing.current$Mnframe:Lgnu/mapping/LocationProc;
        //    45: invokevirtual   gnu/mapping/LocationProc.getValue:()Ljava/lang/Object;
        //    48: ldc             Ljavax/swing/JFrame;.class
        //    50: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    53: dup            
        //    54: astore_3       
        //    55: checkcast       Ljavax/swing/JFrame;
        //    58: astore_2        /* fr */
        //    59: aload_2         /* fr */
        //    60: ifnonnull       126
        //    63: iconst_3       
        //    64: anewarray       Ljava/lang/Object;
        //    67: dup            
        //    68: iconst_0       
        //    69: getstatic       kawa/lib/kawa/swing.Lit0:Lgnu/expr/Keyword;
        //    72: aastore        
        //    73: dup            
        //    74: iconst_1       
        //    75: ldc             "Kawa-picture"
        //    77: aastore        
        //    78: dup            
        //    79: iconst_2       
        //    80: aload_1         /* panel */
        //    81: aastore        
        //    82: invokestatic    kawa/lib/kawa/swing.frame:([Ljava/lang/Object;)Lgnu/kawa/swingviews/SwingFrame;
        //    85: astore_2        /* fr */
        //    86: getstatic       kawa/lib/kawa/swing.default$Mnframe$Mnsize:Ljava/lang/ThreadLocal;
        //    89: invokevirtual   java/lang/ThreadLocal.get:()Ljava/lang/Object;
        //    92: checkcast       Ljava/awt/Dimension;
        //    95: astore_3        /* sz */
        //    96: aload_2         /* fr */
        //    97: aload_3         /* sz */
        //    98: aconst_null    
        //    99: if_acmpeq       106
        //   102: aload_3         /* sz */
        //   103: goto            115
        //   106: ldc2_w          400.0
        //   109: ldc2_w          400.0
        //   112: invokestatic    kawa/lib/kawa/pictures.makeDimension:(DD)Lgnu/kawa/models/DDimension;
        //   115: invokevirtual   javax/swing/JFrame.setSize:(Ljava/awt/Dimension;)V
        //   118: getstatic       kawa/lib/kawa/swing.current$Mnframe:Lgnu/mapping/LocationProc;
        //   121: aload_2         /* fr */
        //   122: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   125: pop            
        //   126: return         
        //   127: new             Lgnu/mapping/WrongType;
        //   130: dup_x1         
        //   131: swap           
        //   132: ldc             "panel"
        //   134: bipush          -2
        //   136: aload_2        
        //   137: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   140: athrow         
        //   141: new             Lgnu/mapping/WrongType;
        //   144: dup_x1         
        //   145: swap           
        //   146: ldc             "fr"
        //   148: bipush          -2
        //   150: aload_3        
        //   151: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   154: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  13     16     127    141    Ljava/lang/ClassCastException;
        //  55     58     141    155    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0106:
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
    
    static {
        Lit4 = Symbol.valueOf("show-picture");
        Lit3 = Symbol.valueOf("set-frame-size!");
        Lit2 = Symbol.valueOf("frame");
        Lit1 = Symbol.valueOf("picture->jpanel");
        Lit0 = Keyword.make("title");
        swing.$instance = new swing();
        final swing $instance = swing.$instance;
        picture$Mn$Grjpanel = new ModuleMethod($instance, 1, swing.Lit1, 4097);
        frame = new ModuleMethod($instance, 2, swing.Lit2, -4096);
        set$Mnframe$Mnsize$Ex = new ModuleMethod($instance, 3, swing.Lit3, 8193);
        show$Mnpicture = new ModuleMethod($instance, 5, swing.Lit4, 4097);
        $runBody$();
    }
    
    public swing() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 5: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 3: {
                final Object force = Promise.force(o, Dimension.class);
                if (!(force instanceof Dimension)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        if (moduleMethod.selector != 3) {
            return super.match2(moduleMethod, o, o2, ctx);
        }
        final Object force = Promise.force(o, Dimension.class);
        if (!(force instanceof Dimension)) {
            return -786431;
        }
        ctx.value1 = force;
        final Object force2 = Promise.force(o2, JFrame.class);
        if (!(force2 instanceof JFrame)) {
            return -786430;
        }
        ctx.value2 = force2;
        ctx.proc = moduleMethod;
        ctx.pc = 2;
        return 0;
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        if (moduleMethod.selector == 2) {
            ctx.values = array;
            ctx.proc = moduleMethod;
            ctx.pc = 5;
            return 0;
        }
        return super.matchN(moduleMethod, array, ctx);
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object argValue) {
    Label_0069_Outer:
        while (true) {
            while (true) {
                switch (method.selector) {
                    case 1: {
                        return picture$To$Jpanel(argValue);
                    }
                    case 3: {
                        final Object force = Promise.force(argValue, Dimension.class);
                        try {
                            setFrameSize$Ex((Dimension)force);
                            return Values.empty;
                            showPicture(argValue);
                            return Values.empty;
                            return super.apply1(method, argValue);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "set-frame-size!", 1, argValue);
                        }
                        break;
                    }
                    case 5: {
                        continue Label_0069_Outer;
                    }
                    default: {
                        continue;
                    }
                }
                break;
            }
            break;
        }
    }
    
    @Override
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: iconst_3       
        //     5: if_icmpne       36
        //     8: goto            11
        //    11: aload_2        
        //    12: ldc             Ljava/awt/Dimension;.class
        //    14: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    17: checkcast       Ljava/awt/Dimension;
        //    20: aload_3        
        //    21: ldc             Ljavax/swing/JFrame;.class
        //    23: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    26: checkcast       Ljavax/swing/JFrame;
        //    29: invokestatic    kawa/lib/kawa/swing.setFrameSize$Ex:(Ljava/awt/Dimension;Ljavax/swing/JFrame;)V
        //    32: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    35: areturn        
        //    36: aload_0        
        //    37: aload_1        
        //    38: aload_2        
        //    39: aload_3        
        //    40: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    43: areturn        
        //    44: new             Lgnu/mapping/WrongType;
        //    47: dup_x1         
        //    48: swap           
        //    49: ldc_w           "set-frame-size!"
        //    52: iconst_1       
        //    53: aload_2        
        //    54: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    57: athrow         
        //    58: new             Lgnu/mapping/WrongType;
        //    61: dup_x1         
        //    62: swap           
        //    63: ldc_w           "set-frame-size!"
        //    66: iconst_2       
        //    67: aload_3        
        //    68: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    71: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  17     20     44     58     Ljava/lang/ClassCastException;
        //  26     29     58     72     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0036:
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
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] array) {
        if (method.selector == 2) {
            return frame(array);
        }
        return super.applyN(method, array);
    }
}
