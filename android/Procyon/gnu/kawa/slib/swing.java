// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import javax.swing.JScrollPane;
import gnu.expr.KawaConvert;
import gnu.mapping.Promise;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import gnu.kawa.swingviews.SwingDisplay;
import java.awt.event.ActionListener;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.Keyword;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class swing extends ModuleBody
{
    public static final ModuleMethod make$Mnaction$Mnlistener;
    public static final StaticFieldLocation fill;
    public static final StaticFieldLocation draw;
    public static final StaticFieldLocation set$Mncontent;
    public static final StaticFieldLocation with$Mnpaint;
    public static final StaticFieldLocation with$Mncomposite;
    public static final StaticFieldLocation composite$Mnsrc$Mnover;
    public static final StaticFieldLocation composite$Mnsrc;
    public static final StaticFieldLocation button;
    public static final StaticFieldLocation Button;
    public static final StaticFieldLocation Label;
    public static final StaticFieldLocation Column;
    public static final StaticFieldLocation Row;
    public static final StaticFieldLocation Text;
    public static final StaticFieldLocation Window;
    public static final StaticFieldLocation run$Mnapplication;
    public static final StaticFieldLocation Image;
    public static final StaticFieldLocation image$Mnread;
    public static final StaticFieldLocation image$Mnwidth;
    public static final StaticFieldLocation image$Mnheight;
    public static final StaticFieldLocation rotation;
    public static final StaticFieldLocation with$Mntransform;
    public static final StaticFieldLocation color$Mnred;
    public static final ModuleMethod menubar;
    public static final ModuleMethod menu;
    public static final ModuleMethod menuitem;
    public static final StaticFieldLocation polygon;
    public static final ModuleMethod scroll;
    public static final StaticFieldLocation frame;
    public static final StaticFieldLocation picture$Mn$Grjpanel;
    static final Keyword Lit0;
    static final Keyword Lit1;
    static final Keyword Lit2;
    static final Keyword Lit3;
    static final Keyword Lit4;
    public static swing $instance;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static ActionListener makeActionListener(final Object proc) {
        return SwingDisplay.makeActionListener(proc);
    }
    
    public static JMenuBar menubar(final Object... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   javax/swing/JMenuBar.<init>:()V
        //     7: astore_1       
        //     8: aload_0         /* args */
        //     9: arraylength    
        //    10: istore_2        /* num$Mnargs */
        //    11: iconst_0       
        //    12: istore_3        /* i */
        //    13: iload_3         /* i */
        //    14: iload_2         /* num$Mnargs */
        //    15: if_icmpge       44
        //    18: aload_0         /* args */
        //    19: iload_3         /* i */
        //    20: aaload         
        //    21: astore          arg
        //    23: aload_1         /* menubar */
        //    24: aload           arg
        //    26: ldc             Ljavax/swing/JMenu;.class
        //    28: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    31: checkcast       Ljavax/swing/JMenu;
        //    34: invokevirtual   javax/swing/JMenuBar.add:(Ljavax/swing/JMenu;)Ljavax/swing/JMenu;
        //    37: pop            
        //    38: iinc            i, 1
        //    41: goto            13
        //    44: aload_1         /* menubar */
        //    45: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static JMenu menu(final Object... args) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   javax/swing/JMenu.<init>:()V
        //     7: astore_1       
        //     8: aload_0         /* args */
        //     9: arraylength    
        //    10: istore_2        /* num$Mnargs */
        //    11: iconst_0       
        //    12: istore_3        /* i */
        //    13: iload_3         /* i */
        //    14: iload_2         /* num$Mnargs */
        //    15: if_icmpge       91
        //    18: aload_0         /* args */
        //    19: iload_3         /* i */
        //    20: aaload         
        //    21: astore          arg
        //    23: aload           arg
        //    25: getstatic       gnu/kawa/slib/swing.Lit0:Lgnu/expr/Keyword;
        //    28: if_acmpne       70
        //    31: iload_3         /* i */
        //    32: iconst_1       
        //    33: iadd           
        //    34: iload_2         /* num$Mnargs */
        //    35: if_icmpge       70
        //    38: aload_1         /* menu */
        //    39: aload_0         /* args */
        //    40: iload_3         /* i */
        //    41: iconst_1       
        //    42: iadd           
        //    43: aaload         
        //    44: ldc             Ljava/lang/String;.class
        //    46: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    49: dup            
        //    50: ifnonnull       58
        //    53: pop            
        //    54: aconst_null    
        //    55: goto            61
        //    58: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    61: invokevirtual   javax/swing/JMenu.setText:(Ljava/lang/String;)V
        //    64: iinc            i, 2
        //    67: goto            13
        //    70: aload_1         /* menu */
        //    71: aload           arg
        //    73: ldc             Ljavax/swing/JMenuItem;.class
        //    75: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    78: checkcast       Ljavax/swing/JMenuItem;
        //    81: invokevirtual   javax/swing/JMenu.add:(Ljavax/swing/JMenuItem;)Ljavax/swing/JMenuItem;
        //    84: pop            
        //    85: iinc            i, 1
        //    88: goto            13
        //    91: aload_1         /* menu */
        //    92: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static JMenuItem menuitem$V(final Object[] argsArray) {
        final Object force = Promise.force(Keyword.searchForKeyword(argsArray, 0, swing.Lit0, null), String.class);
        final String label = (force == null) ? null : force.toString();
        final Object oncommand = Keyword.searchForKeyword(argsArray, 0, swing.Lit1, null);
        final Object disabled = Keyword.searchForKeyword(argsArray, 0, swing.Lit2, Boolean.FALSE);
        final JMenuItem menuitem = new JMenuItem();
        if (KawaConvert.isTrue(disabled)) {
            menuitem.setEnabled(false);
        }
        if (label != null) {
            menuitem.setText(label);
        }
        if (oncommand != null) {
            menuitem.addActionListener(makeActionListener(oncommand));
        }
        return menuitem;
    }
    
    public static JScrollPane scroll$V(final Object contents, final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: getstatic       gnu/kawa/slib/swing.Lit3:Lgnu/expr/Keyword;
        //     5: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //     8: invokestatic    gnu/expr/Keyword.searchForKeyword:([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    11: astore_2        /* w */
        //    12: aload_1         /* argsArray */
        //    13: iconst_0       
        //    14: getstatic       gnu/kawa/slib/swing.Lit4:Lgnu/expr/Keyword;
        //    17: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    20: invokestatic    gnu/expr/Keyword.searchForKeyword:([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    23: astore_3        /* h */
        //    24: aload_0         /* contents */
        //    25: instanceof      Lgnu/kawa/models/Picture;
        //    28: ifeq            51
        //    31: new             Lgnu/kawa/swingviews/SwingPicture;
        //    34: dup            
        //    35: aload_0         /* contents */
        //    36: ldc             Lgnu/kawa/models/Picture;.class
        //    38: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    41: dup            
        //    42: astore          4
        //    44: checkcast       Lgnu/kawa/models/Picture;
        //    47: invokespecial   gnu/kawa/swingviews/SwingPicture.<init>:(Lgnu/kawa/models/Picture;)V
        //    50: astore_0        /* contents */
        //    51: new             Ljavax/swing/JScrollPane;
        //    54: dup            
        //    55: aload_0         /* contents */
        //    56: ldc             Ljava/awt/Component;.class
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    61: dup            
        //    62: astore          5
        //    64: checkcast       Ljava/awt/Component;
        //    67: invokespecial   javax/swing/JScrollPane.<init>:(Ljava/awt/Component;)V
        //    70: astore          scr
        //    72: aload           scr
        //    74: new             Ljava/awt/Dimension;
        //    77: dup            
        //    78: aload_2         /* w */
        //    79: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    82: dup            
        //    83: astore          5
        //    85: checkcast       Ljava/lang/Number;
        //    88: invokevirtual   java/lang/Number.intValue:()I
        //    91: aload_3         /* h */
        //    92: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    95: dup            
        //    96: astore          5
        //    98: checkcast       Ljava/lang/Number;
        //   101: invokevirtual   java/lang/Number.intValue:()I
        //   104: invokespecial   java/awt/Dimension.<init>:(II)V
        //   107: invokevirtual   javax/swing/JScrollPane.setPreferredSize:(Ljava/awt/Dimension;)V
        //   110: aload           scr
        //   112: areturn        
        //   113: new             Lgnu/mapping/WrongType;
        //   116: dup_x1         
        //   117: swap           
        //   118: ldc             "gnu.kawa.swingviews.SwingPicture.<init>(gnu.kawa.models.Picture)"
        //   120: iconst_1       
        //   121: aload           4
        //   123: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   126: athrow         
        //   127: new             Lgnu/mapping/WrongType;
        //   130: dup_x1         
        //   131: swap           
        //   132: ldc             "javax.swing.JScrollPane.<init>(java.awt.Component)"
        //   134: iconst_1       
        //   135: aload           5
        //   137: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   140: athrow         
        //   141: new             Lgnu/mapping/WrongType;
        //   144: dup_x1         
        //   145: swap           
        //   146: ldc             "java.awt.Dimension.<init>(int,int)"
        //   148: iconst_1       
        //   149: aload           5
        //   151: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   154: athrow         
        //   155: new             Lgnu/mapping/WrongType;
        //   158: dup_x1         
        //   159: swap           
        //   160: ldc             "java.awt.Dimension.<init>(int,int)"
        //   162: iconst_2       
        //   163: aload           5
        //   165: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   168: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  44     47     113    127    Ljava/lang/ClassCastException;
        //  64     67     127    141    Ljava/lang/ClassCastException;
        //  85     91     141    155    Ljava/lang/ClassCastException;
        //  98     104    155    169    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 86 out of bounds for length 86
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
    
    static {
        Lit9 = Symbol.valueOf("scroll");
        Lit8 = Symbol.valueOf("menuitem");
        Lit7 = Symbol.valueOf("menu");
        Lit6 = Symbol.valueOf("menubar");
        Lit5 = Symbol.valueOf("make-action-listener");
        Lit4 = Keyword.make("h");
        Lit3 = Keyword.make("w");
        Lit2 = Keyword.make("disabled");
        Lit1 = Keyword.make("oncommand");
        Lit0 = Keyword.make("label");
        swing.$instance = new swing();
        fill = StaticFieldLocation.make("kawa.lib.kawa.pictures", "fill");
        draw = StaticFieldLocation.make("kawa.lib.kawa.pictures", "draw");
        image$Mnread = StaticFieldLocation.make("kawa.lib.kawa.pictures", "image$Mnread");
        image$Mnwidth = StaticFieldLocation.make("kawa.lib.kawa.pictures", "image$Mnwidth");
        image$Mnheight = StaticFieldLocation.make("kawa.lib.kawa.pictures", "image$Mnheight");
        with$Mnpaint = StaticFieldLocation.make("kawa.lib.kawa.pictures", "with$Mnpaint");
        with$Mntransform = StaticFieldLocation.make("kawa.lib.kawa.pictures", "with$Mntransform");
        with$Mncomposite = StaticFieldLocation.make("kawa.lib.kawa.pictures", "with$Mncomposite");
        polygon = StaticFieldLocation.make("gnu.kawa.slib.gui", "polygon");
        button = StaticFieldLocation.make("gnu.kawa.slib.gui", "button");
        Button = StaticFieldLocation.make("gnu.kawa.slib.gui", "Button");
        Image = StaticFieldLocation.make("gnu.kawa.slib.gui", "Image");
        color$Mnred = StaticFieldLocation.make("gnu.kawa.slib.gui", "color$Mnred");
        composite$Mnsrc$Mnover = StaticFieldLocation.make("gnu.kawa.slib.gui", "composite$Mnsrc$Mnover");
        composite$Mnsrc = StaticFieldLocation.make("gnu.kawa.slib.gui", "composite$Mnsrc");
        rotation = StaticFieldLocation.make("gnu.kawa.slib.gui", "rotation");
        Label = StaticFieldLocation.make("gnu.kawa.slib.gui", "Label");
        Text = StaticFieldLocation.make("gnu.kawa.slib.gui", "Text");
        Row = StaticFieldLocation.make("gnu.kawa.slib.gui", "Row");
        Column = StaticFieldLocation.make("gnu.kawa.slib.gui", "Column");
        set$Mncontent = StaticFieldLocation.make("gnu.kawa.slib.gui", "set$Mncontent");
        Window = StaticFieldLocation.make("gnu.kawa.slib.gui", "Window");
        run$Mnapplication = StaticFieldLocation.make("gnu.kawa.slib.gui", "run$Mnapplication");
        picture$Mn$Grjpanel = StaticFieldLocation.make("kawa.lib.kawa.swing", "picture$Mn$Grjpanel");
        frame = StaticFieldLocation.make("kawa.lib.kawa.swing", "frame");
        final swing $instance = swing.$instance;
        make$Mnaction$Mnlistener = new ModuleMethod($instance, 1, swing.Lit5, 4097);
        menubar = new ModuleMethod($instance, 2, swing.Lit6, -4096);
        menu = new ModuleMethod($instance, 3, swing.Lit7, -4096);
        menuitem = new ModuleMethod($instance, 4, swing.Lit8, -4096);
        scroll = new ModuleMethod($instance, 5, swing.Lit9, -4095);
        $runBody$();
    }
    
    public swing() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        if (moduleMethod.selector == 1) {
            ctx.value1 = o;
            ctx.proc = moduleMethod;
            ctx.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, o, ctx);
    }
    
    @Override
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        switch (proc.selector) {
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
            case 3: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 2: {
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
    public Object apply1(final ModuleMethod method, final Object o) {
        if (method.selector == 1) {
            return makeActionListener(o);
        }
        return super.apply1(method, o);
    }
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] array) {
        switch (method.selector) {
            case 2: {
                return menubar(array);
            }
            case 3: {
                return menu(array);
            }
            case 4: {
                return menuitem$V(array);
            }
            case 5: {
                final Object contents = array[0];
                int n = array.length - 1;
                final Object[] argsArray = new Object[n];
                while (--n >= 0) {
                    argsArray[n] = array[n + 1];
                }
                return scroll$V(contents, argsArray);
            }
            default: {
                return super.applyN(method, array);
            }
        }
    }
}
