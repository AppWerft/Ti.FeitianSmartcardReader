/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.KawaConvert;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.swingviews.SwingDisplay;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class swing
extends ModuleBody {
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
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static ActionListener makeActionListener(Object proc) {
        return SwingDisplay.makeActionListener(proc);
    }

    public static /* varargs */ JMenuBar menubar(Object ... args) {
        void menubar;
        JMenuBar jMenuBar = new JMenuBar();
        for (Object arg : args) {
            menubar.add((JMenu)Promise.force(arg, JMenu.class));
        }
        return menubar;
    }

    public static /* varargs */ JMenu menu(Object ... args) {
        void menu;
        JMenu jMenu = new JMenu();
        int num$Mnargs = args.length;
        int i = 0;
        while (i < num$Mnargs) {
            Object arg = args[i];
            if (arg == Lit0 && i + 1 < num$Mnargs) {
                Object object2 = Promise.force(args[i + 1], String.class);
                menu.setText((String)(object2 == null ? null : object2.toString()));
                i += 2;
                continue;
            }
            menu.add((JMenuItem)Promise.force(arg, JMenuItem.class));
            ++i;
        }
        return menu;
    }

    public static JMenuItem menuitem$V(Object[] argsArray) {
        Object object2 = Promise.force(Keyword.searchForKeyword(argsArray, 0, Lit0, null), String.class);
        String label = object2 == null ? null : object2.toString();
        Object oncommand = Keyword.searchForKeyword(argsArray, 0, Lit1, null);
        Object disabled = Keyword.searchForKeyword(argsArray, 0, Lit2, Boolean.FALSE);
        JMenuItem menuitem = new JMenuItem();
        if (KawaConvert.isTrue(disabled)) {
            menuitem.setEnabled(false);
        }
        if (label != null) {
            menuitem.setText(label);
        }
        if (oncommand != null) {
            menuitem.addActionListener(swing.makeActionListener(oncommand));
        }
        return menuitem;
    }

    /*
     * Exception decompiling
     */
    public static JScrollPane scroll$V(Object contents, Object[] argsArray) {
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

    public static {
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
        $instance = new swing();
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
        swing swing2 = $instance;
        make$Mnaction$Mnlistener = new ModuleMethod(swing2, 1, Lit5, 4097);
        menubar = new ModuleMethod(swing2, 2, Lit6, -4096);
        menu = new ModuleMethod(swing2, 3, Lit7, -4096);
        menuitem = new ModuleMethod(swing2, 4, Lit8, -4096);
        scroll = new ModuleMethod(swing2, 5, Lit9, -4095);
        swing.$runBody$();
    }

    public swing() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            callContext.value1 = object2;
            callContext.proc = moduleMethod;
            callContext.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
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
            case 3: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 2: {
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

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        if (moduleMethod.selector == 1) {
            return swing.makeActionListener(object2);
        }
        return super.apply1(moduleMethod, object2);
    }

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        switch (moduleMethod.selector) {
            case 2: {
                return swing.menubar(arrobject);
            }
            case 3: {
                return swing.menu(arrobject);
            }
            case 4: {
                return swing.menuitem$V(arrobject);
            }
            case 5: {
                int n = arrobject.length - 1;
                Object[] arrobject2 = new Object[n];
                while (--n >= 0) {
                    arrobject2 = arrobject2;
                    arrobject2[n] = arrobject[n + 1];
                }
                return swing.scroll$V(arrobject[0], arrobject2);
            }
        }
        return super.applyN(moduleMethod, arrobject);
    }
}

