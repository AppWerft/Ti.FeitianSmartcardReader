// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.android;

import kawa.lang.Quote;
import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import gnu.expr.ModuleMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.View;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import kawa.standard.syntax_case;
import gnu.lists.LList;
import kawa.lib.lists;
import kawa.lang.TemplateScope;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.lists.PairWithPosition;
import gnu.mapping.SimpleSymbol;
import kawa.lang.SyntaxTemplate;
import kawa.lang.SyntaxPattern;
import gnu.expr.SourceName;
import kawa.lang.Macro;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class defs extends ModuleBody
{
    public static final StaticFieldLocation current$Mnactivity;
    public static final Class Button;
    public static final Class EditText;
    public static final Class ImageView;
    public static final Class LinearLayout;
    public static final Class ScrollView;
    public static final Class TextView;
    public static final Class View;
    public static final Macro activity;
    @SourceName(name = "android.view.View", uri = "gnu.kawa.reflect/ObjectBuilder")
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static Object $PcProcessActivity(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(3, null);
        return defs.Lit0.match(form, allocVars, 0) ? lists.cons(defs.Lit1.execute(allocVars, TemplateScope.make()), $PcProcessActivity(defs.Lit2.execute(allocVars, TemplateScope.make()))) : (defs.Lit3.match(form, allocVars, 0) ? lists.cons(defs.Lit4.execute(allocVars, TemplateScope.make()), $PcProcessActivity(defs.Lit5.execute(allocVars, TemplateScope.make()))) : (defs.Lit6.match(form, allocVars, 0) ? lists.cons(defs.Lit7.execute(allocVars, TemplateScope.make()), $PcProcessActivity(defs.Lit8.execute(allocVars, TemplateScope.make()))) : (defs.Lit9.match(form, allocVars, 0) ? LList.Empty : syntax_case.error("syntax-case", form))));
    }
    
    static {
        Lit25 = PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("current-activity"), PairWithPosition.make(Lit20 = PairWithPosition.make(Symbol.valueOf("this"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106542), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 110641), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 110623), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 110622);
        Lit24 = Symbol.valueOf("parameterize");
        Lit23 = PairWithPosition.make(Symbol.valueOf("invoke-special"), PairWithPosition.make(Lit17 = Symbol.valueOf("android.app.Activity"), PairWithPosition.make(defs.Lit20, PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("quote"), PairWithPosition.make(Lit18 = Symbol.valueOf("onCreate"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106550), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106550), PairWithPosition.make(Lit19 = Symbol.valueOf("savedInstanceState"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106559), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106549), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106542), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106521), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106505);
        Lit22 = Symbol.valueOf("void");
        Lit21 = PairWithPosition.make(defs.Lit18, PairWithPosition.make(PairWithPosition.make(defs.Lit19, PairWithPosition.make(Lit16 = Symbol.valueOf("::"), PairWithPosition.make(Symbol.valueOf("android.os.Bundle"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102449), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102446), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102426), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102426), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102416);
        Lit15 = new Object[0];
        Lit14 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0010", defs.Lit15, 0);
        Lit13 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0012", defs.Lit15, 0);
        Lit12 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u000b\u0018\f", new Object[] { Symbol.valueOf("define-simple-class"), PairWithPosition.make(PairWithPosition.make(defs.Lit17, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 155680), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 155680) }, 0);
        Lit11 = new SyntaxPattern("\f\u0007\f\u000f\u0013", defs.Lit15, 3, "defs.scm:37");
        Lit10 = Symbol.valueOf("activity");
        Lit9 = new SyntaxPattern("\b", defs.Lit15, 0, "defs.scm:33");
        Lit8 = new SyntaxTemplate("\u0001\u0000", "\n", defs.Lit15, 0);
        Lit7 = new SyntaxTemplate("\u0001\u0000", "\u0003", defs.Lit15, 0);
        Lit6 = new SyntaxPattern("\f\u0007\u000b", defs.Lit15, 2, "defs.scm:31");
        Lit5 = new SyntaxTemplate("\u0003\u0001\u0000", "\u0012", defs.Lit15, 0);
        Lit4 = new SyntaxTemplate("\u0003\u0001\u0000", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\u0011\u0018,\u0011\u0005\u0003\b\u0011\u00184\b\u000b", new Object[] { defs.Lit21, defs.Lit16, defs.Lit22, defs.Lit23, defs.Lit24, defs.Lit25, PairWithPosition.make(Symbol.valueOf("$lookup$"), Pair.make(defs.Lit20, Pair.make(Pair.make(Symbol.valueOf("quasiquote"), Pair.make(Symbol.valueOf("setContentView"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 118815) }, 1);
        Lit3 = new SyntaxPattern("T\f\u0002\r\u0007\u0000\b\u0016\f\u000f\b\u0013", new Object[] { Symbol.valueOf("on-create-view") }, 3, "defs.scm:24");
        Lit2 = new SyntaxTemplate("\u0003\u0000", "\n", defs.Lit15, 0);
        Lit1 = new SyntaxTemplate("\u0003\u0000", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\u0011\u0018,\b\u0005\u0003", new Object[] { defs.Lit21, defs.Lit16, defs.Lit22, defs.Lit23, defs.Lit24, defs.Lit25 }, 1);
        Lit0 = new SyntaxPattern("<\f\u0002\r\u0007\u0000\b\b\u000b", new Object[] { Symbol.valueOf("on-create") }, 2, "defs.scm:18");
        View = View.class;
        TextView = TextView.class;
        ScrollView = ScrollView.class;
        LinearLayout = LinearLayout.class;
        ImageView = ImageView.class;
        EditText = EditText.class;
        Button = Button.class;
        defs.$instance = new defs();
        current$Mnactivity = StaticFieldLocation.make("gnu.kawa.android.utils", "current$Mnactivity");
        activity = Macro.make(defs.Lit10, new ModuleMethod(defs.$instance, 1, null, 4097), "gnu.kawa.android.defs");
        android$Dtview$DtView = "gnu.kawa.android.ViewBuilder";
        $runBody$();
    }
    
    public defs() {
        ModuleInfo.register(this);
    }
    
    static Object lambda1(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(3, null);
        Object o;
        if (defs.Lit11.match(form, allocVars, 0)) {
            final TemplateScope make = TemplateScope.make();
            o = Quote.append$V(new Object[] { defs.Lit12.execute(allocVars, make), Quote.append$V(new Object[] { $PcProcessActivity(defs.Lit13.execute(allocVars, make)), defs.Lit14.execute(allocVars, make) }) });
        }
        else {
            o = syntax_case.error("syntax-case", form);
        }
        return o;
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
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object o) {
        if (method.selector == 1) {
            return lambda1(o);
        }
        return super.apply1(method, o);
    }
}
