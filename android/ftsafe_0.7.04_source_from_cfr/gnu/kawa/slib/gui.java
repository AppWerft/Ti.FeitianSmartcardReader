/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.bytecode.Type;
import gnu.expr.KawaConvert;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.SourceName;
import gnu.expr.Special;
import gnu.kawa.functions.Format;
import gnu.kawa.models.Box;
import gnu.kawa.models.Button;
import gnu.kawa.models.Column;
import gnu.kawa.models.Display;
import gnu.kawa.models.Label;
import gnu.kawa.models.Model;
import gnu.kawa.models.Row;
import gnu.kawa.models.Text;
import gnu.kawa.models.Viewable;
import gnu.kawa.models.Window;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.xml.KAttr;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.Complex;
import gnu.math.IntNum;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.exceptions;
import kawa.lib.numbers;

public class gui
extends ModuleBody {
    public static final StaticFieldLocation make$MnPoint;
    @SourceName(name="P", uri="http://kawa.gnu.org/construct", prefix="$construct$")
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
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        color$Mnred = Color.red;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ Object polygon(Complex initial, Object ... more$Mnpoints) {
        generalPath = new GeneralPath();
        n$Mnpoints = more$Mnpoints.length;
        path.moveTo(numbers.realPart(initial).doubleValue(), numbers.imagPart(initial).doubleValue());
        i = 0;
        do lbl-1000: // 2 sources:
        {
            if (i >= n$Mnpoints) {
                path.closePath();
                return path;
            }
            object2 = Promise.force(more$Mnpoints[i], Complex.class);
            pt = (Complex)object2;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "pt", -2, object2);
        }
        {
            path.lineTo(numbers.realPart(pt).doubleValue(), numbers.imagPart(pt).doubleValue());
            ++i;
            ** while (true)
        }
    }

    public static Composite compositeSrcOver() {
        return gui.compositeSrcOver(1.0f);
    }

    public static Composite compositeSrcOver(float alpha) {
        return AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
    }

    public static Composite compositeSrc() {
        return gui.compositeSrc(1.0f);
    }

    public static Composite compositeSrc(float alpha) {
        return AlphaComposite.getInstance(AlphaComposite.SRC, alpha);
    }

    public static AffineTransform rotation(double theta) {
        return AffineTransform.getRotateInstance(theta);
    }

    public static Color asColor(Object value) {
        return value instanceof Color ? (Color)Promise.force(value, Color.class) : (value instanceof Integer ? new Color((Integer)Promise.force(value, Integer.class)) : (value instanceof IntNum ? new Color(IntNum.intValue(value)) : (Color)Promise.force(((Procedure)SlotGet.staticField).apply2(Lit0, value.toString()), Color.class)));
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ Button button(Object ... args) {
        String name;
        KAttr attr;
        Button button = new Button();
        int num$Mnargs = args.length;
        int i = 0;
        while (i < num$Mnargs) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                Object object2 = Promise.force(arg, Keyword.class);
                gui.buttonKeyword(button, ((Keyword)object2).getName(), args[i + 1]);
                i += 2;
                continue;
            }
            if (arg instanceof KAttr) {
                Object object3 = Promise.force(arg, KAttr.class);
                attr = (KAttr)object3;
                name = attr.getName();
                Object value = attr.getObjectValue();
                gui.buttonKeyword(button, name, value);
                ++i;
                continue;
            }
            gui.buttonNonKeyword(button, arg);
            ++i;
        }
        return button;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.expr.Keyword.getName()", 1, (Object)attr);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "attr", -2, (Object)name);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void buttonKeyword(Button button, String name, Object value) {
        if (name == "foreground") {
            button.setForeground(gui.asColor(value));
            return;
        }
        if (name == "background") {
            button.setBackground(gui.asColor(value));
            return;
        }
        if (name == "action") {
            button.setAction(value);
            return;
        }
        if (name == "text") {
            Object object2 = Promise.force(value, String.class);
            button.setText((String)(object2 == null ? null : object2.toString()));
            return;
        }
        if (name != "disabled") {
            Type.NeverReturns neverReturns = exceptions.error(Format.formatToString(0, "unknown button attribute ~s", name));
            throw Special.reachedUnexpected;
        }
        Object object2 = Promise.force(value);
        try {
            button.setDisabled(KawaConvert.isTrue(object2));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.kawa.models.Button.setDisabled(boolean)", 2, object2);
        }
    }

    static boolean buttonNonKeyword(Button button, Object arg) {
        return true;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ Button Button(Object ... args) {
        String name;
        KAttr attr;
        Button button = new Button();
        int num$Mnargs = args.length;
        int i = 0;
        while (i < num$Mnargs) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                Object object2 = Promise.force(arg, Keyword.class);
                gui.buttonKeyword(button, ((Keyword)object2).getName(), args[i + 1]);
                i += 2;
                continue;
            }
            if (arg instanceof KAttr) {
                Object object3 = Promise.force(arg, KAttr.class);
                attr = (KAttr)object3;
                name = attr.getName();
                Object value = attr.getObjectValue();
                gui.buttonKeyword(button, name, value);
                ++i;
                continue;
            }
            gui.buttonNonKeyword(button, arg);
            ++i;
        }
        return button;
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
    public static /* varargs */ Label Label(Object ... args) {
        String name;
        KAttr attr;
        Label instance = new Label();
        int num$Mnargs = args.length;
        int i = 0;
        while (i < num$Mnargs) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                Object object2 = Promise.force(arg, Keyword.class);
                gui.labelKeyword(instance, ((Keyword)object2).getName(), args[i + 1]);
                i += 2;
                continue;
            }
            if (arg instanceof KAttr) {
                Object object3 = Promise.force(arg, KAttr.class);
                attr = (KAttr)object3;
                name = attr.getName();
                Object value = attr.getObjectValue();
                gui.labelKeyword(instance, name, value);
                ++i;
                continue;
            }
            gui.labelNonKeyword(instance, arg);
            ++i;
        }
        return instance;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.expr.Keyword.getName()", 1, (Object)attr);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "attr", -2, (Object)name);
        }
    }

    static void labelKeyword(Label instance, String name, Object value) {
        if (name != Lit1) {
            Type.NeverReturns neverReturns = exceptions.error(Format.formatToString(0, "unknown label attribute ~s", name));
            throw Special.reachedUnexpected;
        }
        Object object2 = Promise.force(value, String.class);
        instance.setText((String)(object2 == null ? null : object2.toString()));
    }

    static void labelNonKeyword(Label instance, Object arg) {
        Object object2 = Promise.force(arg, String.class);
        instance.setText((String)(object2 == null ? null : object2.toString()));
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ Text Text(Object ... args) {
        String name;
        KAttr attr;
        Text instance = new Text();
        int num$Mnargs = args.length;
        int i = 0;
        while (i < num$Mnargs) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                Object object2 = Promise.force(arg, Keyword.class);
                gui.textKeyword(instance, ((Keyword)object2).getName(), args[i + 1]);
                i += 2;
                continue;
            }
            if (arg instanceof KAttr) {
                Object object3 = Promise.force(arg, KAttr.class);
                attr = (KAttr)object3;
                name = attr.getName();
                Object value = attr.getObjectValue();
                gui.textKeyword(instance, name, value);
                ++i;
                continue;
            }
            gui.textNonKeyword(instance, arg);
            ++i;
        }
        return instance;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.expr.Keyword.getName()", 1, (Object)attr);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "attr", -2, (Object)name);
        }
    }

    static void textKeyword(Text instance, String name, Object value) {
        if (name != Lit1) {
            Type.NeverReturns neverReturns = exceptions.error(Format.formatToString(0, "unknown text attribute ~s", name));
            throw Special.reachedUnexpected;
        }
        Object object2 = Promise.force(value, String.class);
        instance.setText((String)(object2 == null ? null : object2.toString()));
    }

    static void textNonKeyword(Text instance, Object arg) {
        Object object2 = Promise.force(arg, String.class);
        instance.setText((String)(object2 == null ? null : object2.toString()));
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ Row Row(Object ... args) {
        String name;
        KAttr attr;
        Row instance = new Row();
        int num$Mnargs = args.length;
        int i = 0;
        while (i < num$Mnargs) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                Object object2 = Promise.force(arg, Keyword.class);
                gui.boxKeyword(instance, ((Keyword)object2).getName(), args[i + 1]);
                i += 2;
                continue;
            }
            if (arg instanceof KAttr) {
                Object object3 = Promise.force(arg, KAttr.class);
                attr = (KAttr)object3;
                name = attr.getName();
                Object value = attr.getObjectValue();
                gui.boxKeyword(instance, name, value);
                ++i;
                continue;
            }
            gui.boxNonKeyword(instance, arg);
            ++i;
        }
        return instance;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.expr.Keyword.getName()", 1, (Object)attr);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "attr", -2, (Object)name);
        }
    }

    static void boxKeyword(Box instance, String name, Object value) {
        if (name != Lit2) {
            Type.NeverReturns neverReturns = exceptions.error(Format.formatToString(0, "unknown box attribute ~s", name));
            throw Special.reachedUnexpected;
        }
        instance.setCellSpacing(value);
    }

    static void boxNonKeyword(Box box, Object arg) {
        box.add(gui.asModel(arg));
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ Column Column(Object ... args) {
        String name;
        KAttr attr;
        Column instance = new Column();
        int num$Mnargs = args.length;
        int i = 0;
        while (i < num$Mnargs) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                Object object2 = Promise.force(arg, Keyword.class);
                gui.boxKeyword(instance, ((Keyword)object2).getName(), args[i + 1]);
                i += 2;
                continue;
            }
            if (arg instanceof KAttr) {
                Object object3 = Promise.force(arg, KAttr.class);
                attr = (KAttr)object3;
                name = attr.getName();
                Object value = attr.getObjectValue();
                gui.boxKeyword(instance, name, value);
                ++i;
                continue;
            }
            gui.boxNonKeyword(instance, arg);
            ++i;
        }
        return instance;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.expr.Keyword.getName()", 1, (Object)attr);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "attr", -2, (Object)name);
        }
    }

    public static void setContent(Window window, Object pane) {
        window.setContent(pane);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ Window Window(Object ... args) {
        String name;
        KAttr attr;
        Window instance = Display.getInstance().makeWindow();
        int num$Mnargs = args.length;
        int i = 0;
        while (i < num$Mnargs) {
            Object arg = args[i];
            if (arg instanceof Keyword) {
                Object object2 = Promise.force(arg, Keyword.class);
                gui.windowKeyword(instance, ((Keyword)object2).getName(), args[i + 1]);
                i += 2;
                continue;
            }
            if (arg instanceof KAttr) {
                Object object3 = Promise.force(arg, KAttr.class);
                attr = (KAttr)object3;
                name = attr.getName();
                Object value = attr.getObjectValue();
                gui.windowKeyword(instance, name, value);
                ++i;
                continue;
            }
            gui.windowNonKeyword(instance, arg);
            ++i;
        }
        return instance;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.expr.Keyword.getName()", 1, (Object)attr);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "attr", -2, (Object)name);
        }
    }

    static void windowKeyword(Window instance, String name, Object value) {
        if (name == "title") {
            Object object2 = Promise.force(value, String.class);
            instance.setTitle((String)(object2 == null ? null : object2.toString()));
        } else if (name == "content") {
            instance.setContent(value);
        } else if (name == "menubar") {
            instance.setMenuBar(value);
        } else {
            Type.NeverReturns neverReturns = exceptions.error(Format.formatToString(0, "unknown window attribute ~s", name));
            throw Special.reachedUnexpected;
        }
    }

    static void windowNonKeyword(Window instance, Object arg) {
        instance.setContent(arg);
    }

    static Model asModel(Object arg) {
        return Display.getInstance().coerceToModel(arg);
    }

    public static {
        Lit20 = new Object[0];
        Lit18 = Symbol.valueOf("run-application");
        Lit19 = new SyntaxRules(Lit20, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit20, 1, "gui.scm:193"), "\u0001", "\u0011\u0018\u0004\b\u0003", new Object[]{PairWithPosition.make(Symbol.valueOf("$lookup$"), Pair.make(Symbol.valueOf("gnu.kawa.models.Window"), Pair.make(Pair.make(Symbol.valueOf("quasiquote"), Pair.make(Symbol.valueOf("open"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/gui.scm", 794631)}, 0)}, 1, Lit18);
        Lit17 = Symbol.valueOf("Window");
        Lit16 = Symbol.valueOf("set-content");
        Lit15 = Symbol.valueOf("Column");
        Lit14 = Symbol.valueOf("Row");
        Lit13 = Symbol.valueOf("Text");
        Lit12 = Symbol.valueOf("Label");
        Lit10 = Symbol.valueOf("Image");
        Lit11 = new SyntaxRules(Lit20, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit20, 1, "gui.scm:87"), "\u0000", "\u0011\u0018\u0004\u0011\u0018\f\u0002", new Object[]{Symbol.valueOf("make"), Symbol.valueOf("<gnu.kawa.models.DrawImage>")}, 0)}, 1, Lit10);
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
        $instance = new gui();
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
        gui gui2 = $instance;
        polygon = new ModuleMethod(gui2, 1, Lit3, -4095);
        composite$Mnsrc$Mnover = new ModuleMethod(gui2, 2, Lit4, 4096);
        composite$Mnsrc = new ModuleMethod(gui2, 4, Lit5, 4096);
        rotation = new ModuleMethod(gui2, 6, Lit6, 4097);
        as$Mncolor = new ModuleMethod(gui2, 7, Lit7, 4097);
        button = new ModuleMethod(gui2, 8, Lit8, -4096);
        Button = new ModuleMethod(gui2, 9, Lit9, -4096);
        Image = Macro.make(Lit10, Lit11, "gnu.kawa.slib.gui");
        Label = new ModuleMethod(gui2, 10, Lit12, -4096);
        Text = new ModuleMethod(gui2, 11, Lit13, -4096);
        Row = new ModuleMethod(gui2, 12, Lit14, -4096);
        Column = new ModuleMethod(gui2, 13, Lit15, -4096);
        set$Mncontent = new ModuleMethod(gui2, 14, Lit16, 8194);
        Window = new ModuleMethod(gui2, 15, Lit17, -4096);
        run$Mnapplication = Macro.make(Lit18, Lit19, "gnu.kawa.slib.gui");
        gui.$runBody$();
    }

    public gui() {
        ModuleInfo.register(this);
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 4: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 2: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 7: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 6: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        if (moduleMethod.selector == 14) {
            Object object4 = Promise.force(object2, Window.class);
            if (!(object4 instanceof Window)) {
                return -786431;
            }
            callContext.value1 = object4;
            callContext.value2 = object3;
            callContext.proc = moduleMethod;
            callContext.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 15: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 13: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 12: {
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
            case 8: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 1: {
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

    public Object apply0(ModuleMethod moduleMethod) {
        switch (moduleMethod.selector) {
            case 2: {
                return gui.compositeSrcOver();
            }
            case 4: {
                return gui.compositeSrc();
            }
        }
        return super.apply0(moduleMethod);
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
            case 2: {
                return gui.compositeSrcOver(((Number)Promise.force(object2)).floatValue());
            }
            case 4: {
                return gui.compositeSrc(((Number)Promise.force(object2)).floatValue());
            }
            case 6: {
                return gui.rotation(((Number)Promise.force(object2)).doubleValue());
            }
            case 7: {
                return gui.asColor(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "composite-src-over", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "composite-src", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "rotation", 1, object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        if (moduleMethod.selector != 14) return super.apply2(moduleMethod, object2, object3);
        try {
            gui.setContent((Window)Promise.force(object2, Window.class), object3);
            return Values.empty;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-content", 1, object2);
        }
    }

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        switch (moduleMethod.selector) {
            case 1: {
                Object object2 = Promise.force(arrobject[0], Complex.class);
                int n = arrobject.length - 1;
                Object[] arrobject2 = new Object[n];
                while (--n >= 0) {
                    arrobject2 = arrobject2;
                    arrobject2[n] = arrobject[n + 1];
                }
                return gui.polygon((Complex)object2, arrobject2);
            }
            case 8: {
                return gui.button(arrobject);
            }
            case 9: {
                return gui.Button(arrobject);
            }
            case 10: {
                return gui.Label(arrobject);
            }
            case 11: {
                return gui.Text(arrobject);
            }
            case 12: {
                return gui.Row(arrobject);
            }
            case 13: {
                return gui.Column(arrobject);
            }
            case 15: {
                return gui.Window(arrobject);
            }
        }
        return super.applyN(moduleMethod, arrobject);
    }
}

