/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.kawa;

import gnu.bytecode.Type;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.Format;
import gnu.kawa.models.Picture;
import gnu.kawa.swingviews.SwingFrame;
import gnu.kawa.swingviews.SwingPicture;
import gnu.kawa.xml.KAttr;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.LocationProc;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import kawa.lib.exceptions;
import kawa.lib.kawa.pictures;
import kawa.lib.parameters;
import kawa.lib.strings;

public class swing
extends ModuleBody {
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
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        current$Mnframe = parameters.makeParameter(null);
        current$Mnpicture$Mnpanel = parameters.makeParameter(null);
        ThreadLocal threadLocal = new ThreadLocal();
        default$Mnframe$Mnsize = threadLocal;
    }

    public static SwingPicture picture$To$Jpanel(Object pic) {
        return new SwingPicture(pictures.$To$Picture(pic));
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ SwingFrame frame(Object ... args) {
        String name;
        KAttr attr;
        SwingFrame frame41 = new SwingFrame(null, null, Values.empty);
        int num$Mnargs = args.length;
        int i = 0;
        do {
            if (i >= num$Mnargs) {
                frame41.pack();
                frame41.setVisible(true);
                return frame41;
            }
            Object arg = args[i];
            if (arg instanceof Keyword) {
                Object object2 = Promise.force(arg, Keyword.class);
                swing.frameKeyword(frame41, ((Keyword)object2).getName(), args[i + 1]);
                i += 2;
            }
            if (arg instanceof KAttr) {
                Object object3 = Promise.force(arg, KAttr.class);
                attr = (KAttr)object3;
                name = attr.getName();
                Object value = attr.getObjectValue();
                swing.frameKeyword(frame41, name, value);
                ++i;
                continue;
            }
            swing.frameNonKeyword(frame41, arg);
            ++i;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.expr.Keyword.getName()", 1, (Object)attr);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "attr", -2, (Object)name);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static void frameKeyword(SwingFrame frame41, String name, Object value) {
        Object object3;
        if (strings.isString$Eq(name, "title", new CharSequence[0])) {
            Object object2 = Promise.force(value, String.class);
            frame41.setTitle((String)(object2 == null ? null : object2.toString()));
            return;
        }
        if (strings.isString$Eq(name, "menubar", new CharSequence[0])) {
            object3 = Promise.force(value, JMenuBar.class);
            frame41.setJMenuBar((JMenuBar)object3);
            return;
        }
        if (!strings.isString$Eq(name, "size", new CharSequence[0])) {
            Type.NeverReturns neverReturns = exceptions.error(Format.formatToString(0, "unknown frame attribute ~s", name));
            throw Special.reachedUnexpected;
        }
        Object object2 = Promise.force(value, Dimension.class);
        try {
            frame41.setSize((Dimension)object2);
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.kawa.swingviews.SwingFrame.setSize(java.awt.Dimension)", 2, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.kawa.swingviews.SwingFrame.setJMenuBar(javax.swing.JMenuBar)", 2, object3);
        }
    }

    static void frameNonKeyword(SwingFrame frame41, Object arg) {
        frame41.addComponent(arg);
    }

    public static void setFrameSize$Ex(Dimension dimension) {
        swing.setFrameSize$Ex(dimension, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void setFrameSize$Ex(Dimension size, JFrame frame41) {
        JFrame cur$Mnframe;
        if (frame41 != null) {
            frame41.setSize(size);
            return;
        }
        Object object2 = Promise.force(current$Mnframe.getValue(), JFrame.class);
        try {
            cur$Mnframe = (JFrame)object2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cur-frame", -2, object2);
        }
        default$Mnframe$Mnsize.set(size);
        if (cur$Mnframe == null) return;
        cur$Mnframe.setSize(size);
    }

    public static void showPicture(Object picture) {
        block5 : {
            Dimension sz;
            JFrame fr;
            SwingPicture panel;
            block6 : {
                block4 : {
                    Object object2 = Promise.force(current$Mnpicture$Mnpanel.getValue(), SwingPicture.class);
                    try {
                        panel = (SwingPicture)object2;
                        if (panel != null) break block4;
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "panel", -2, (Object)fr);
                    }
                    panel = swing.picture$To$Jpanel(picture);
                    ((Procedure)current$Mnpicture$Mnpanel).apply1(panel);
                    break block6;
                }
                panel.setPicture(picture);
            }
            Object object3 = Promise.force(current$Mnframe.getValue(), JFrame.class);
            try {
                fr = (JFrame)object3;
                if (fr != null) break block5;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "fr", -2, (Object)sz);
            }
            fr = swing.frame(Lit0, "Kawa-picture", panel);
            sz = default$Mnframe$Mnsize.get();
            fr.setSize(sz != null ? sz : pictures.makeDimension(400.0, 400.0));
            ((Procedure)current$Mnframe).apply1(fr);
        }
    }

    public static {
        Lit4 = Symbol.valueOf("show-picture");
        Lit3 = Symbol.valueOf("set-frame-size!");
        Lit2 = Symbol.valueOf("frame");
        Lit1 = Symbol.valueOf("picture->jpanel");
        Lit0 = Keyword.make("title");
        swing swing2 = $instance = new swing();
        picture$Mn$Grjpanel = new ModuleMethod(swing2, 1, Lit1, 4097);
        frame = new ModuleMethod(swing2, 2, Lit2, -4096);
        set$Mnframe$Mnsize$Ex = new ModuleMethod(swing2, 3, Lit3, 8193);
        show$Mnpicture = new ModuleMethod(swing2, 5, Lit4, 4097);
        swing.$runBody$();
    }

    public swing() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 5: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                Object object3 = Promise.force(object2, Dimension.class);
                if (!(object3 instanceof Dimension)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        if (moduleMethod.selector == 3) {
            Object object4 = Promise.force(object2, Dimension.class);
            if (!(object4 instanceof Dimension)) {
                return -786431;
            }
            callContext.value1 = object4;
            Object object5 = Promise.force(object3, JFrame.class);
            if (!(object5 instanceof JFrame)) {
                return -786430;
            }
            callContext.value2 = object5;
            callContext.proc = moduleMethod;
            callContext.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        if (moduleMethod.selector == 2) {
            callContext.values = arrobject;
            callContext.proc = moduleMethod;
            callContext.pc = 5;
            return 0;
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
            case 1: {
                return swing.picture$To$Jpanel(object2);
            }
            case 3: {
                swing.setFrameSize$Ex((Dimension)Promise.force(object2, Dimension.class));
                return Values.empty;
            }
            case 5: {
                swing.showPicture(object2);
                return Values.empty;
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-frame-size!", 1, object2);
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

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        if (moduleMethod.selector == 2) {
            return swing.frame(arrobject);
        }
        return super.applyN(moduleMethod, arrobject);
    }
}

