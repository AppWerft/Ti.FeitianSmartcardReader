/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package gnu.kawa.android;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.SourceName;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.Quote;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.lists;
import kawa.standard.syntax_case;

public class defs
extends ModuleBody {
    public static final StaticFieldLocation current$Mnactivity;
    public static final Class Button;
    public static final Class EditText;
    public static final Class ImageView;
    public static final Class LinearLayout;
    public static final Class ScrollView;
    public static final Class TextView;
    public static final Class View;
    public static final Macro activity;
    @SourceName(name="android.view.View", uri="gnu.kawa.reflect/ObjectBuilder")
    public static final String android$Dtview$DtView;
    static final SyntaxPattern Lit0;
    static final SyntaxTemplate Lit1;
    static final SyntaxTemplate Lit2;
    static final SyntaxPattern Lit3;
    static final SyntaxTemplate Lit4;
    static final SyntaxTemplate Lit5;
    static final SyntaxPattern Lit6;
    static final SyntaxTemplate Lit7;
    static final SyntaxTemplate Lit8;
    static final SyntaxPattern Lit9;
    public static defs $instance;
    static final SimpleSymbol Lit10;
    static final SyntaxPattern Lit11;
    static final SyntaxTemplate Lit12;
    static final SyntaxTemplate Lit13;
    static final SyntaxTemplate Lit14;
    static final Object[] Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final PairWithPosition Lit20;
    static final PairWithPosition Lit21;
    static final SimpleSymbol Lit22;
    static final PairWithPosition Lit23;
    static final SimpleSymbol Lit24;
    static final PairWithPosition Lit25;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    static Object $PcProcessActivity(Object form) {
        Object object2;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(3, null);
        if (((Pattern)Lit0).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            Object object4 = Lit1.execute(arrobject, templateScope);
            templateScope = TemplateScope.make();
            object2 = lists.cons(object4, defs.$PcProcessActivity(Lit2.execute(arrobject, templateScope)));
        } else if (((Pattern)Lit3).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            Object object5 = Lit4.execute(arrobject, templateScope);
            templateScope = TemplateScope.make();
            object2 = lists.cons(object5, defs.$PcProcessActivity(Lit5.execute(arrobject, templateScope)));
        } else if (((Pattern)Lit6).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            Object object6 = Lit7.execute(arrobject, templateScope);
            templateScope = TemplateScope.make();
            object2 = lists.cons(object6, defs.$PcProcessActivity(Lit8.execute(arrobject, templateScope)));
        } else {
            object2 = ((Pattern)Lit9).match(form, arrobject, 0) ? LList.Empty : syntax_case.error("syntax-case", form);
        }
        return object2;
    }

    public static {
        Lit20 = PairWithPosition.make(Symbol.valueOf("this"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106542);
        Lit25 = PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("current-activity"), PairWithPosition.make(Lit20, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 110641), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 110623), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 110622);
        Lit24 = Symbol.valueOf("parameterize");
        Lit17 = Symbol.valueOf("android.app.Activity");
        Lit18 = Symbol.valueOf("onCreate");
        Lit19 = Symbol.valueOf("savedInstanceState");
        Lit23 = PairWithPosition.make(Symbol.valueOf("invoke-special"), PairWithPosition.make(Lit17, PairWithPosition.make(Lit20, PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("quote"), PairWithPosition.make(Lit18, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106550), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106550), PairWithPosition.make(Lit19, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106559), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106549), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106542), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106521), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106505);
        Lit22 = Symbol.valueOf("void");
        Lit16 = Symbol.valueOf("::");
        Lit21 = PairWithPosition.make(Lit18, PairWithPosition.make(PairWithPosition.make(Lit19, PairWithPosition.make(Lit16, PairWithPosition.make(Symbol.valueOf("android.os.Bundle"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102449), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102446), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102426), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102426), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102416);
        Lit15 = new Object[0];
        Lit14 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0010", Lit15, 0);
        Lit13 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0012", Lit15, 0);
        Lit12 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u000b\u0018\f", new Object[]{Symbol.valueOf("define-simple-class"), PairWithPosition.make(PairWithPosition.make(Lit17, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 155680), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 155680)}, 0);
        Lit11 = new SyntaxPattern("\f\u0007\f\u000f\u0013", Lit15, 3, "defs.scm:37");
        Lit10 = Symbol.valueOf("activity");
        Lit9 = new SyntaxPattern("\b", Lit15, 0, "defs.scm:33");
        Lit8 = new SyntaxTemplate("\u0001\u0000", "\n", Lit15, 0);
        Lit7 = new SyntaxTemplate("\u0001\u0000", "\u0003", Lit15, 0);
        Lit6 = new SyntaxPattern("\f\u0007\u000b", Lit15, 2, "defs.scm:31");
        Lit5 = new SyntaxTemplate("\u0003\u0001\u0000", "\u0012", Lit15, 0);
        Lit4 = new SyntaxTemplate("\u0003\u0001\u0000", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\u0011\u0018,\u0011\u0005\u0003\b\u0011\u00184\b\u000b", new Object[]{Lit21, Lit16, Lit22, Lit23, Lit24, Lit25, PairWithPosition.make(Symbol.valueOf("$lookup$"), Pair.make(Lit20, Pair.make(Pair.make(Symbol.valueOf("quasiquote"), Pair.make(Symbol.valueOf("setContentView"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 118815)}, 1);
        Lit3 = new SyntaxPattern("T\f\u0002\r\u0007\u0000\b\u0016\f\u000f\b\u0013", new Object[]{Symbol.valueOf("on-create-view")}, 3, "defs.scm:24");
        Lit2 = new SyntaxTemplate("\u0003\u0000", "\n", Lit15, 0);
        Lit1 = new SyntaxTemplate("\u0003\u0000", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\u0011\u0018,\b\u0005\u0003", new Object[]{Lit21, Lit16, Lit22, Lit23, Lit24, Lit25}, 1);
        Lit0 = new SyntaxPattern("<\f\u0002\r\u0007\u0000\b\b\u000b", new Object[]{Symbol.valueOf("on-create")}, 2, "defs.scm:18");
        View = View.class;
        TextView = TextView.class;
        ScrollView = ScrollView.class;
        LinearLayout = LinearLayout.class;
        ImageView = ImageView.class;
        EditText = EditText.class;
        Button = Button.class;
        $instance = new defs();
        current$Mnactivity = StaticFieldLocation.make("gnu.kawa.android.utils", "current$Mnactivity");
        defs defs2 = $instance;
        activity = Macro.make(Lit10, new ModuleMethod(defs2, 1, null, 4097), "gnu.kawa.android.defs");
        android$Dtview$DtView = "gnu.kawa.android.ViewBuilder";
        defs.$runBody$();
    }

    public defs() {
        ModuleInfo.register(this);
    }

    static Object lambda1(Object form) {
        Object object2;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(3, null);
        if (((Pattern)Lit11).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Quote.append$V(new Object[]{Lit12.execute(arrobject, templateScope), Quote.append$V(new Object[]{defs.$PcProcessActivity(Lit13.execute(arrobject, templateScope)), Lit14.execute(arrobject, templateScope)})});
        } else {
            object2 = syntax_case.error("syntax-case", form);
        }
        return object2;
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

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        if (moduleMethod.selector == 1) {
            return defs.lambda1(object2);
        }
        return super.apply1(moduleMethod, object2);
    }
}

