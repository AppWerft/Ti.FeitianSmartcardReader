/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.prim_syntax;
import kawa.lib.std_syntax;
import kawa.standard.syntax_case;

public class srfi2
extends ModuleBody {
    public static final StaticFieldLocation $Prvt$and;
    public static final StaticFieldLocation $Prvt$let;
    public static final StaticFieldLocation $Prvt$begin;
    public static final Macro and$Mnlet$St;
    public static srfi2 $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxPattern Lit1;
    static final SyntaxTemplate Lit2;
    static final SyntaxPattern Lit3;
    static final SyntaxTemplate Lit4;
    static final SyntaxPattern Lit5;
    static final SyntaxTemplate Lit6;
    static final SyntaxPattern Lit7;
    static final SyntaxTemplate Lit8;
    static final SyntaxTemplate Lit9;
    static final SyntaxTemplate Lit10;
    static final SyntaxPattern Lit11;
    static final SyntaxTemplate Lit12;
    static final SyntaxPattern Lit13;
    static final SyntaxTemplate Lit14;
    static final SyntaxPattern Lit15;
    static final SyntaxTemplate Lit16;
    static final SyntaxTemplate Lit17;
    static final SyntaxTemplate Lit18;
    static final SyntaxPattern Lit19;
    static final SyntaxTemplate Lit20;
    static final Object[] Lit21;
    static final Object[] Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        Lit24 = Symbol.valueOf("let");
        Lit23 = Symbol.valueOf("and");
        Object[] arrobject = new Object[1];
        Lit22 = arrobject;
        arrobject[0] = Lit23;
        Lit21 = new Object[0];
        Lit20 = new SyntaxTemplate("\u0001", "\u0004", new Object[]{Boolean.TRUE}, 0);
        Lit19 = new SyntaxPattern("\f\u0007\f\b\b", Lit21, 1, "srfi2.scm:24");
        Lit18 = new SyntaxTemplate("\u0001\u0001\u0000", "\u000b", Lit21, 0);
        Lit17 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u000b\b\t\u0003\b\u0012", Lit22, 0);
        Lit16 = new SyntaxTemplate("\u0001\u0001\u0000", "\u000b", Lit21, 0);
        Lit15 = new SyntaxPattern("\f\u0007\u001c\f\u000f\u0013\b", Lit21, 3, "srfi2.scm:20");
        Lit14 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u000b\b\t\u0003\b\u0012", Lit22, 0);
        Lit13 = new SyntaxPattern("\f\u0007,\u001c\f\u000f\b\u0013\b", Lit21, 3, "srfi2.scm:18");
        Lit12 = new SyntaxTemplate("\u0001\u0001\u0001\u0000", "\u0011\u0018\u0004)\b\t\u000b\b\u0013\b\u0011\u0018\f\t\u000b\b\t\u0003\b\u001a", new Object[]{Lit24, Lit23}, 0);
        Lit11 = new SyntaxPattern("\f\u0007<,\f\u000f\f\u0017\b\u001b\b", Lit21, 4, "srfi2.scm:15");
        Lit10 = new SyntaxTemplate("\u0001\u0001", "\u000b", Lit21, 0);
        Lit9 = new SyntaxTemplate("\u0001\u0001", "\u000b", Lit21, 0);
        Lit8 = new SyntaxTemplate("\u0001\u0001", "\u000b", Lit21, 0);
        Lit7 = new SyntaxPattern("\f\u0007\u001c\f\u000f\b\b", Lit21, 2, "srfi2.scm:11");
        Lit6 = new SyntaxTemplate("\u0001\u0001", "\u000b", Lit21, 0);
        Lit5 = new SyntaxPattern("\f\u0007,\u001c\f\u000f\b\b\b", Lit21, 2, "srfi2.scm:9");
        Lit4 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0011\u0018\u0004)\b\t\u000b\b\u0013\b\u000b", new Object[]{Lit24}, 0);
        Lit3 = new SyntaxPattern("\f\u0007<,\f\u000f\f\u0017\b\b\b", Lit21, 3, "srfi2.scm:7");
        Lit2 = new SyntaxTemplate("\u0001\u0003\u0001\u0000", "\t\u0003\b\u0011\r\u000b\b\b\u0011\u0018\u0004\t\u0013\u001a", new Object[]{Symbol.valueOf("begin")}, 1);
        Lit1 = new SyntaxPattern("\f\u0007,\r\u000f\b\b\b\f\u0017\u001b", Lit21, 4, "srfi2.scm:5");
        Lit0 = Symbol.valueOf("and-let*");
        $instance = new srfi2();
        $Prvt$and = StaticFieldLocation.make("kawa.lib.std_syntax", "and");
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$begin = StaticFieldLocation.make("kawa.standard.begin", "begin");
        srfi2 srfi22 = $instance;
        and$Mnlet$St = Macro.make(Lit0, new ModuleMethod(srfi22, 1, null, 4097), "gnu.kawa.slib.srfi2");
        srfi2.$runBody$();
    }

    public srfi2() {
        ModuleInfo.register(this);
    }

    static Object lambda1(Object form) {
        Object object2;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(4, null);
        if (((Pattern)Lit1).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit2.execute(arrobject, templateScope);
        } else if (((Pattern)Lit3).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit4.execute(arrobject, templateScope);
        } else if (((Pattern)Lit5).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit6.execute(arrobject, templateScope);
        } else if (((Pattern)Lit7).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            if (std_syntax.isIdentifier(Lit8.execute(arrobject, templateScope))) {
                templateScope = TemplateScope.make();
                object2 = Lit9.execute(arrobject, templateScope);
            } else {
                templateScope = TemplateScope.make();
                object2 = prim_syntax.reportSyntaxError(Lit10.execute(arrobject, templateScope), "expected a variable name");
            }
        } else if (((Pattern)Lit11).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit12.execute(arrobject, templateScope);
        } else if (((Pattern)Lit13).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit14.execute(arrobject, templateScope);
        } else if (((Pattern)Lit15).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            if (std_syntax.isIdentifier(Lit16.execute(arrobject, templateScope))) {
                templateScope = TemplateScope.make();
                object2 = Lit17.execute(arrobject, templateScope);
            } else {
                templateScope = TemplateScope.make();
                object2 = prim_syntax.reportSyntaxError(Lit18.execute(arrobject, templateScope), "expected a variable name");
            }
        } else if (((Pattern)Lit19).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit20.execute(arrobject, templateScope);
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
            return srfi2.lambda1(object2);
        }
        return super.apply1(moduleMethod, object2);
    }
}

