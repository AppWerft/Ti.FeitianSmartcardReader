// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.kawa.functions.GetModuleClass;
import gnu.expr.Compilation;
import gnu.mapping.WrongType;
import kawa.standard.syntax_case;
import kawa.lang.Quote;
import gnu.mapping.Promise;
import kawa.lang.TemplateScope;
import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import gnu.expr.ModuleMethod;
import gnu.math.IntNum;
import gnu.lists.Pair;
import kawa.lang.SyntaxRule;
import gnu.lists.LList;
import gnu.mapping.Values;
import gnu.mapping.Symbol;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.lists.PairWithPosition;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.SyntaxPattern;
import gnu.mapping.SimpleSymbol;
import kawa.lang.Macro;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class misc_syntax extends ModuleBody
{
    public static final StaticFieldLocation $Prvt$define$Mnconstant;
    public static final Macro provide;
    public static final Macro test$Mnbegin;
    public static final Macro module$Mnuri;
    public static final Macro resource$Mnurl;
    public static misc_syntax $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxPattern Lit1;
    static final SyntaxTemplate Lit2;
    static final SyntaxTemplate Lit3;
    static final SyntaxTemplate Lit4;
    static final SyntaxPattern Lit5;
    static final SimpleSymbol Lit6;
    static final SyntaxRules Lit7;
    static final SimpleSymbol Lit8;
    static final SyntaxPattern Lit9;
    static final SimpleSymbol Lit10;
    static final SyntaxRules Lit11;
    static final Object[] Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final PairWithPosition Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        Lit20 = Symbol.valueOf("%test-begin");
        Lit19 = Symbol.valueOf("srfi-64");
        Lit18 = Symbol.valueOf("else");
        Lit17 = PairWithPosition.make(misc_syntax.Lit19, PairWithPosition.make(Values.empty, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 90142), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 90133);
        Lit16 = Symbol.valueOf("cond-expand");
        Lit15 = Symbol.valueOf("begin");
        Lit14 = Symbol.valueOf("quasiquote");
        Lit13 = Symbol.valueOf("$lookup$");
        Lit12 = new Object[0];
        Lit11 = new SyntaxRules(misc_syntax.Lit12, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", misc_syntax.Lit12, 1, "misc_syntax.scm:39"), "\u0001", "\u0011\u0018\u0004\b\b\u0011\u0018\f\u0099\b\u0011\u0018\fa\b\u0011\u0018\f)\u0011\u0018\u0014\b\u0003\u0018\u001c\u0018$\u0018,", new Object[] { PairWithPosition.make(misc_syntax.Lit13, Pair.make(Symbol.valueOf("gnu.kawa.io.URLPath"), Pair.make(Pair.make(misc_syntax.Lit14, Pair.make(Symbol.valueOf("valueOf"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 163847), misc_syntax.Lit13, PairWithPosition.make(misc_syntax.Lit13, Pair.make(PairWithPosition.make(Lit8 = Symbol.valueOf("module-uri"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 167947), Pair.make(Pair.make(misc_syntax.Lit14, Pair.make(Symbol.valueOf("resolve"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 167947), Pair.make(Pair.make(misc_syntax.Lit14, Pair.make(Symbol.valueOf("toURL"), LList.Empty)), LList.Empty), Pair.make(Pair.make(misc_syntax.Lit14, Pair.make(Symbol.valueOf("openConnection"), LList.Empty)), LList.Empty), Pair.make(Pair.make(misc_syntax.Lit14, Pair.make(Symbol.valueOf("getURL"), LList.Empty)), LList.Empty) }, 0) }, 1, Lit10 = Symbol.valueOf("resource-url"));
        Lit9 = new SyntaxPattern("\f\u0018\b", misc_syntax.Lit12, 0, "misc_syntax.scm:33");
        Lit7 = new SyntaxRules(misc_syntax.Lit12, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", misc_syntax.Lit12, 1, "misc_syntax.scm:20"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014\t\u0003\u0018\u001c", new Object[] { misc_syntax.Lit15, PairWithPosition.make(misc_syntax.Lit16, PairWithPosition.make(misc_syntax.Lit17, PairWithPosition.make(PairWithPosition.make(misc_syntax.Lit18, PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("import"), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("except"), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("srfi"), PairWithPosition.make(IntNum.valueOf(64), PairWithPosition.make(Symbol.valueOf("testing"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94260), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94257), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94251), PairWithPosition.make(Lit6 = Symbol.valueOf("test-begin"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94269), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94251), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94243), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94243), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94235), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94235), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94229), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94229), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 90133), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 90120), misc_syntax.Lit20, PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 98336) }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", misc_syntax.Lit12, 2, "misc_syntax.scm:25"), "\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014\t\u0003\b\u000b", new Object[] { misc_syntax.Lit15, PairWithPosition.make(misc_syntax.Lit16, PairWithPosition.make(misc_syntax.Lit17, PairWithPosition.make(PairWithPosition.make(misc_syntax.Lit18, PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("require"), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("quote"), PairWithPosition.make(misc_syntax.Lit19, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110646), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110646), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110645), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110636), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110636), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110630), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110630), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110613), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110600), misc_syntax.Lit20 }, 0) }, 2, misc_syntax.Lit6);
        Lit5 = new SyntaxPattern("\f\u0018\u0003", misc_syntax.Lit12, 1, "misc_syntax.scm:15");
        Lit4 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0018\u0004", new Object[] { Pair.make(Symbol.valueOf("::"), PairWithPosition.make(Symbol.valueOf("int"), PairWithPosition.make(IntNum.valueOf(123), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 57360), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 57356)) }, 0);
        Lit3 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0013", misc_syntax.Lit12, 0);
        Lit2 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0018\u0004", new Object[] { Pair.make(Symbol.valueOf("define-constant"), LList.Empty) }, 0);
        Lit1 = new SyntaxPattern("\f\u0007,\f\u000f\f\u0017\b\b", misc_syntax.Lit12, 3, "misc_syntax.scm:5");
        Lit0 = Symbol.valueOf("provide");
        misc_syntax.$instance = new misc_syntax();
        $Prvt$define$Mnconstant = StaticFieldLocation.make("kawa.lib.prim_syntax", "define$Mnconstant");
        provide = Macro.make(misc_syntax.Lit0, new ModuleMethod(misc_syntax.$instance, 1, null, 4097), "kawa.lib.misc_syntax");
        test$Mnbegin = Macro.make(misc_syntax.Lit6, misc_syntax.Lit7, "kawa.lib.misc_syntax");
        final SimpleSymbol lit8 = misc_syntax.Lit8;
        final ModuleMethod expander = new ModuleMethod(misc_syntax.$instance, 2, null, 4097);
        expander.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm:31");
        module$Mnuri = Macro.make(lit8, expander, "kawa.lib.misc_syntax");
        resource$Mnurl = Macro.make(misc_syntax.Lit10, misc_syntax.Lit11, "kawa.lib.misc_syntax");
        $runBody$();
    }
    
    public misc_syntax() {
        ModuleInfo.register(this);
    }
    
    static Object lambda1(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(3, null);
        Label_0116: {
            if (!misc_syntax.Lit1.match(form, allocVars, 0)) {
                break Label_0116;
            }
            final TemplateScope make = TemplateScope.make();
            final Object[] args = { misc_syntax.Lit2.execute(allocVars, make), null };
            final int n = 1;
            final Object[] args2 = new Object[2];
            final int n2 = 0;
            final Object[] args3 = { "%provide%", null };
            final int n3 = 1;
            final Object force = Promise.force(std_syntax.syntaxObject$To$Datum(misc_syntax.Lit3.execute(allocVars, make)), Symbol.class);
            try {
                args3[n3] = misc.symbol$To$String((Symbol)force);
                args2[n2] = std_syntax.datum$To$SyntaxObject(form, misc.string$To$Symbol(strings.stringAppend(args3)));
                args2[1] = misc_syntax.Lit4.execute(allocVars, make);
                args[n] = Quote.consX$V(args2);
                return Quote.append$V(args);
                append$V = (misc_syntax.Lit5.match(form, allocVars, 0) ? prim_syntax.reportSyntaxError(form, "provide requires a quoted feature-name") : syntax_case.error("syntax-case", form));
                return append$V;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "symbol->string", 1, force);
            }
        }
    }
    
    static Object lambda2(final Object form) {
        return misc_syntax.Lit9.match(form, SyntaxPattern.allocVars(0, null), 0) ? GetModuleClass.getModuleClassURI(Compilation.getCurrent()) : syntax_case.error("syntax-case", form);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 2: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                ctx.value1 = arg1;
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
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object arg1) {
        switch (method.selector) {
            case 1: {
                return lambda1(arg1);
            }
            case 2: {
                return lambda2(arg1);
            }
            default: {
                return super.apply1(method, arg1);
            }
        }
    }
}
