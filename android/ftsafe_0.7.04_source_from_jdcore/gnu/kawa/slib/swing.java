package gnu.kawa.slib; import gnu.kawa.reflect.StaticFieldLocation;

public class swing extends gnu.expr.ModuleBody { public static final gnu.expr.ModuleMethod make$Mnaction$Mnlistener; public static final StaticFieldLocation fill; public static final StaticFieldLocation draw; public static final StaticFieldLocation set$Mncontent; public static final StaticFieldLocation with$Mnpaint; public static final StaticFieldLocation with$Mncomposite; public static final StaticFieldLocation composite$Mnsrc$Mnover; public static final StaticFieldLocation composite$Mnsrc; public static final StaticFieldLocation button; public static final StaticFieldLocation Button; public static final StaticFieldLocation Label; public static final StaticFieldLocation Column; public static final StaticFieldLocation Row; public static final StaticFieldLocation Text; public static final StaticFieldLocation Window; public static final StaticFieldLocation run$Mnapplication; public static final StaticFieldLocation Image; public static final StaticFieldLocation image$Mnread; public static final StaticFieldLocation image$Mnwidth; public static final StaticFieldLocation image$Mnheight; public static final StaticFieldLocation rotation; public static final StaticFieldLocation with$Mntransform; public static final StaticFieldLocation color$Mnred; public static final gnu.expr.ModuleMethod menubar; public static final gnu.expr.ModuleMethod menu; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static final gnu.expr.ModuleMethod menuitem;
  public static final StaticFieldLocation polygon;
  public static final gnu.expr.ModuleMethod scroll;
  public static final StaticFieldLocation frame;
  public static final StaticFieldLocation picture$Mn$Grjpanel;
  static final gnu.expr.Keyword Lit0;
  static final gnu.expr.Keyword Lit1;
  static final gnu.expr.Keyword Lit2;
  static final gnu.expr.Keyword Lit3; static final gnu.expr.Keyword Lit4; public static swing $instance; static final gnu.mapping.SimpleSymbol Lit5; static final gnu.mapping.SimpleSymbol Lit6; static final gnu.mapping.SimpleSymbol Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final gnu.mapping.SimpleSymbol Lit9 = gnu.mapping.Symbol.valueOf("scroll"); static { Lit8 = gnu.mapping.Symbol.valueOf("menuitem");Lit7 = gnu.mapping.Symbol.valueOf("menu");Lit6 = gnu.mapping.Symbol.valueOf("menubar");Lit5 = gnu.mapping.Symbol.valueOf("make-action-listener");Lit4 = gnu.expr.Keyword.make("h");Lit3 = gnu.expr.Keyword.make("w");Lit2 = gnu.expr.Keyword.make("disabled");Lit1 = gnu.expr.Keyword.make("oncommand");Lit0 = gnu.expr.Keyword.make("label");$instance = new swing();fill = StaticFieldLocation.make("kawa.lib.kawa.pictures", "fill");draw = StaticFieldLocation.make("kawa.lib.kawa.pictures", "draw");image$Mnread = StaticFieldLocation.make("kawa.lib.kawa.pictures", "image$Mnread");image$Mnwidth = StaticFieldLocation.make("kawa.lib.kawa.pictures", "image$Mnwidth");image$Mnheight = StaticFieldLocation.make("kawa.lib.kawa.pictures", "image$Mnheight");with$Mnpaint = StaticFieldLocation.make("kawa.lib.kawa.pictures", "with$Mnpaint");with$Mntransform = StaticFieldLocation.make("kawa.lib.kawa.pictures", "with$Mntransform");with$Mncomposite = StaticFieldLocation.make("kawa.lib.kawa.pictures", "with$Mncomposite");polygon = StaticFieldLocation.make("gnu.kawa.slib.gui", "polygon");button = StaticFieldLocation.make("gnu.kawa.slib.gui", "button");Button = StaticFieldLocation.make("gnu.kawa.slib.gui", "Button");Image = StaticFieldLocation.make("gnu.kawa.slib.gui", "Image");color$Mnred = StaticFieldLocation.make("gnu.kawa.slib.gui", "color$Mnred");composite$Mnsrc$Mnover = StaticFieldLocation.make("gnu.kawa.slib.gui", "composite$Mnsrc$Mnover");composite$Mnsrc = StaticFieldLocation.make("gnu.kawa.slib.gui", "composite$Mnsrc");rotation = StaticFieldLocation.make("gnu.kawa.slib.gui", "rotation");Label = StaticFieldLocation.make("gnu.kawa.slib.gui", "Label");Text = StaticFieldLocation.make("gnu.kawa.slib.gui", "Text");Row = StaticFieldLocation.make("gnu.kawa.slib.gui", "Row");Column = StaticFieldLocation.make("gnu.kawa.slib.gui", "Column");set$Mncontent = StaticFieldLocation.make("gnu.kawa.slib.gui", "set$Mncontent");Window = StaticFieldLocation.make("gnu.kawa.slib.gui", "Window");run$Mnapplication = StaticFieldLocation.make("gnu.kawa.slib.gui", "run$Mnapplication");
    
    picture$Mn$Grjpanel = StaticFieldLocation.make("kawa.lib.kawa.swing", "picture$Mn$Grjpanel");frame = StaticFieldLocation.make("kawa.lib.kawa.swing", "frame");swing localSwing = $instance;make$Mnaction$Mnlistener = new gnu.expr.ModuleMethod(localSwing, 1, Lit5, 4097);menubar = new gnu.expr.ModuleMethod(localSwing, 2, Lit6, 61440);menu = new gnu.expr.ModuleMethod(localSwing, 3, Lit7, 61440);menuitem = new gnu.expr.ModuleMethod(localSwing, 4, Lit8, 61440);scroll = new gnu.expr.ModuleMethod(localSwing, 5, Lit9, 61441);$runBody$(); }
  
  public int match1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 1) return makeActionListener(paramObject); return super.apply1(paramModuleMethod, paramObject);
  }
  
  public static java.awt.event.ActionListener makeActionListener(Object proc) { return gnu.kawa.swingviews.SwingDisplay.makeActionListener(proc); }
  





















































































  public int matchN(gnu.expr.ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 5:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 4: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 3: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 2: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }
  
  public static javax.swing.JMenuBar menubar(Object... args) { javax.swing.JMenuBar localJMenuBar1 = new javax.swing.JMenuBar();
    int num$Mnargs = args.length;
    javax.swing.JMenuBar menubar; int i = 0;
    while (i < num$Mnargs) {
      Object arg = args[i];
      
      menubar.add((javax.swing.JMenu)gnu.mapping.Promise.force(arg, javax.swing.JMenu.class));
      i++; }
    return menubar;
  }
  
  public static javax.swing.JMenu menu(Object... args)
  {
    javax.swing.JMenu localJMenu1 = new javax.swing.JMenu();
    int num$Mnargs = args.length;
    javax.swing.JMenu menu; int i = 0;
    while (i < num$Mnargs) {
      Object arg = args[i];
      if ((arg == Lit0) && (i + 1 < num$Mnargs))
      {
        Object tmp49_46 = gnu.mapping.Promise.force(args[(i + 1)], String.class);tmp49_46;menu.setText(tmp49_46 == null ? null : tmp49_46.toString());
        
        i += 2;
      } else {
        menu.add((javax.swing.JMenuItem)gnu.mapping.Promise.force(arg, javax.swing.JMenuItem.class));
        i++; } }
    return menu; }
  
  public static javax.swing.JMenuItem menuitem$V(Object[] argsArray) { ; ; ; Object tmp14_11 = gnu.mapping.Promise.force(gnu.expr.Keyword.searchForKeyword(argsArray, 0, Lit0, null), String.class);tmp14_11;String label = tmp14_11 == null ? null : tmp14_11.toString();Object oncommand = gnu.expr.Keyword.searchForKeyword(argsArray, 0, Lit1, null);Object disabled = gnu.expr.Keyword.searchForKeyword(argsArray, 0, Lit2, Boolean.FALSE);
    







    javax.swing.JMenuItem menuitem = new javax.swing.JMenuItem();
    if (gnu.expr.KawaConvert.isTrue(disabled))
      menuitem.setEnabled(false);
    if (label != null)
      menuitem.setText(label);
    if (oncommand != null)
      menuitem.addActionListener(makeActionListener(oncommand));
    return menuitem;
  }
  
  public Object applyN(gnu.expr.ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (selector) {case 2:  return menubar(paramArrayOfObject);
    










    case 3: 
      return menu(paramArrayOfObject);
    















    case 4: 
      return menuitem$V(paramArrayOfObject);
    















    case 5: 
      int i = paramArrayOfObject.length - 1; do { i--; } while (i >= 0); return scroll$V(paramArrayOfObject[0], new Object[] { paramArrayOfObject[(i + 1)] }); } return super.applyN(paramModuleMethod, paramArrayOfObject);
  }
  
  /* Error */
  public static javax.swing.JScrollPane scroll$V(Object contents, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: getstatic 96	gnu/kawa/slib/swing:Lit3	Lgnu/expr/Keyword;
    //   5: getstatic 76	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   8: invokestatic 64	gnu/expr/Keyword:searchForKeyword	([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_1
    //   13: iconst_0
    //   14: getstatic 99	gnu/kawa/slib/swing:Lit4	Lgnu/expr/Keyword;
    //   17: getstatic 76	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   20: invokestatic 64	gnu/expr/Keyword:searchForKeyword	([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   23: astore_3
    //   24: aload_0
    //   25: instanceof 101
    //   28: ifeq +23 -> 51
    //   31: new 103	gnu/kawa/swingviews/SwingPicture
    //   34: dup
    //   35: aload_0
    //   36: ldc 101
    //   38: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   41: dup
    //   42: astore 4
    //   44: checkcast 101	gnu/kawa/models/Picture
    //   47: invokespecial 115	gnu/kawa/swingviews/SwingPicture:<init>	(Lgnu/kawa/models/Picture;)V
    //   50: astore_0
    //   51: new 117	javax/swing/JScrollPane
    //   54: dup
    //   55: aload_0
    //   56: ldc 119
    //   58: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   61: dup
    //   62: astore 5
    //   64: checkcast 119	java/awt/Component
    //   67: invokespecial 124	javax/swing/JScrollPane:<init>	(Ljava/awt/Component;)V
    //   70: astore 4
    //   72: aload 4
    //   74: new 126	java/awt/Dimension
    //   77: dup
    //   78: aload_2
    //   79: invokestatic 129	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: dup
    //   83: astore 5
    //   85: checkcast 131	java/lang/Number
    //   88: invokevirtual 135	java/lang/Number:intValue	()I
    //   91: aload_3
    //   92: invokestatic 129	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: dup
    //   96: astore 5
    //   98: checkcast 131	java/lang/Number
    //   101: invokevirtual 135	java/lang/Number:intValue	()I
    //   104: invokespecial 140	java/awt/Dimension:<init>	(II)V
    //   107: invokevirtual 144	javax/swing/JScrollPane:setPreferredSize	(Ljava/awt/Dimension;)V
    //   110: aload 4
    //   112: areturn
    //   113: new 107	gnu/mapping/WrongType
    //   116: dup_x1
    //   117: swap
    //   118: ldc 109
    //   120: iconst_1
    //   121: aload 4
    //   123: invokespecial 112	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   126: athrow
    //   127: new 107	gnu/mapping/WrongType
    //   130: dup_x1
    //   131: swap
    //   132: ldc 121
    //   134: iconst_1
    //   135: aload 5
    //   137: invokespecial 112	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   140: athrow
    //   141: new 107	gnu/mapping/WrongType
    //   144: dup_x1
    //   145: swap
    //   146: ldc -119
    //   148: iconst_1
    //   149: aload 5
    //   151: invokespecial 112	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   154: athrow
    //   155: new 107	gnu/mapping/WrongType
    //   158: dup_x1
    //   159: swap
    //   160: ldc -119
    //   162: iconst_2
    //   163: aload 5
    //   165: invokespecial 112	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   168: athrow
    // Line number table:
    //   Java source line #107	-> byte code offset #0
    //   Java source line #108	-> byte code offset #24
    //   Java source line #109	-> byte code offset #31
    //   Java source line #110	-> byte code offset #51
    //   Java source line #111	-> byte code offset #51
    //   Java source line #112	-> byte code offset #72
    //   Java source line #113	-> byte code offset #110
    //   Java source line #109	-> byte code offset #113
    //   Java source line #111	-> byte code offset #127
    //   Java source line #112	-> byte code offset #141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	contents	Object
    //   0	112	1	argsArray	Object[]
    //   0	79	2	w	Object
    //   0	92	3	h	Object
    //   42	1	4	localObject1	Object
    //   70	52	4	scr	javax.swing.JScrollPane
    //   62	102	5	localObject2	Object
    //   113	1	7	localClassCastException1	ClassCastException
    //   127	1	8	localClassCastException2	ClassCastException
    //   141	1	9	localClassCastException3	ClassCastException
    //   155	1	10	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   44	47	113	java/lang/ClassCastException
    //   64	67	127	java/lang/ClassCastException
    //   85	91	141	java/lang/ClassCastException
    //   98	104	155	java/lang/ClassCastException
  }
  
  public swing()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
}
