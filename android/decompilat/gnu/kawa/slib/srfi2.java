// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import kawa.standard.syntax_case;
import kawa.lib.prim_syntax;
import kawa.lib.std_syntax;
import kawa.lang.TemplateScope;
import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import gnu.expr.ModuleMethod;
import gnu.mapping.Symbol;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import kawa.lang.SyntaxTemplate;
import kawa.lang.SyntaxPattern;
import gnu.mapping.SimpleSymbol;
import kawa.lang.Macro;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class srfi2 extends ModuleBody
{
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        Lit24 = Symbol.valueOf("let");
        Lit23 = Symbol.valueOf("and");
        (Lit22 = new Object[] { null })[0] = srfi2.Lit23;
        Lit21 = new Object[0];
        Lit20 = new SyntaxTemplate("\u0001", "\u0004", new Object[] { Boolean.TRUE }, 0);
        Lit19 = new SyntaxPattern("\f\u0007\f\b\b", srfi2.Lit21, 1, "srfi2.scm:24");
        Lit18 = new SyntaxTemplate("\u0001\u0001\u0000", "\u000b", srfi2.Lit21, 0);
        Lit17 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u000b\b\t\u0003\b\u0012", srfi2.Lit22, 0);
        Lit16 = new SyntaxTemplate("\u0001\u0001\u0000", "\u000b", srfi2.Lit21, 0);
        Lit15 = new SyntaxPattern("\f\u0007\u001c\f\u000f\u0013\b", srfi2.Lit21, 3, "srfi2.scm:20");
        Lit14 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u000b\b\t\u0003\b\u0012", srfi2.Lit22, 0);
        Lit13 = new SyntaxPattern("\f\u0007,\u001c\f\u000f\b\u0013\b", srfi2.Lit21, 3, "srfi2.scm:18");
        Lit12 = new SyntaxTemplate("\u0001\u0001\u0001\u0000", "\u0011\u0018\u0004)\b\t\u000b\b\u0013\b\u0011\u0018\f\t\u000b\b\t\u0003\b\u001a", new Object[] { srfi2.Lit24, srfi2.Lit23 }, 0);
        Lit11 = new SyntaxPattern("\f\u0007<,\f\u000f\f\u0017\b\u001b\b", srfi2.Lit21, 4, "srfi2.scm:15");
        Lit10 = new SyntaxTemplate("\u0001\u0001", "\u000b", srfi2.Lit21, 0);
        Lit9 = new SyntaxTemplate("\u0001\u0001", "\u000b", srfi2.Lit21, 0);
        Lit8 = new SyntaxTemplate("\u0001\u0001", "\u000b", srfi2.Lit21, 0);
        Lit7 = new SyntaxPattern("\f\u0007\u001c\f\u000f\b\b", srfi2.Lit21, 2, "srfi2.scm:11");
        Lit6 = new SyntaxTemplate("\u0001\u0001", "\u000b", srfi2.Lit21, 0);
        Lit5 = new SyntaxPattern("\f\u0007,\u001c\f\u000f\b\b\b", srfi2.Lit21, 2, "srfi2.scm:9");
        Lit4 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0011\u0018\u0004)\b\t\u000b\b\u0013\b\u000b", new Object[] { srfi2.Lit24 }, 0);
        Lit3 = new SyntaxPattern("\f\u0007<,\f\u000f\f\u0017\b\b\b", srfi2.Lit21, 3, "srfi2.scm:7");
        Lit2 = new SyntaxTemplate("\u0001\u0003\u0001\u0000", "\t\u0003\b\u0011\r\u000b\b\b\u0011\u0018\u0004\t\u0013\u001a", new Object[] { Symbol.valueOf("begin") }, 1);
        Lit1 = new SyntaxPattern("\f\u0007,\r\u000f\b\b\b\f\u0017\u001b", srfi2.Lit21, 4, "srfi2.scm:5");
        Lit0 = Symbol.valueOf("and-let*");
        srfi2.$instance = new srfi2();
        $Prvt$and = StaticFieldLocation.make("kawa.lib.std_syntax", "and");
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$begin = StaticFieldLocation.make("kawa.standard.begin", "begin");
        and$Mnlet$St = Macro.make(srfi2.Lit0, new ModuleMethod(srfi2.$instance, 1, null, 4097), "gnu.kawa.slib.srfi2");
        $runBody$();
    }
    
    public srfi2() {
        ModuleInfo.register(this);
    }
    
    static Object lambda1(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(4, null);
        return srfi2.Lit1.match(form, allocVars, 0) ? srfi2.Lit2.execute(allocVars, TemplateScope.make()) : (srfi2.Lit3.match(form, allocVars, 0) ? srfi2.Lit4.execute(allocVars, TemplateScope.make()) : (srfi2.Lit5.match(form, allocVars, 0) ? srfi2.Lit6.execute(allocVars, TemplateScope.make()) : (srfi2.Lit7.match(form, allocVars, 0) ? (std_syntax.isIdentifier(srfi2.Lit8.execute(allocVars, TemplateScope.make())) ? srfi2.Lit9.execute(allocVars, TemplateScope.make()) : prim_syntax.reportSyntaxError(srfi2.Lit10.execute(allocVars, TemplateScope.make()), "expected a variable name")) : (srfi2.Lit11.match(form, allocVars, 0) ? srfi2.Lit12.execute(allocVars, TemplateScope.make()) : (srfi2.Lit13.match(form, allocVars, 0) ? srfi2.Lit14.execute(allocVars, TemplateScope.make()) : (srfi2.Lit15.match(form, allocVars, 0) ? (std_syntax.isIdentifier(srfi2.Lit16.execute(allocVars, TemplateScope.make())) ? srfi2.Lit17.execute(allocVars, TemplateScope.make()) : prim_syntax.reportSyntaxError(srfi2.Lit18.execute(allocVars, TemplateScope.make()), "expected a variable name")) : (srfi2.Lit19.match(form, allocVars, 0) ? srfi2.Lit20.execute(allocVars, TemplateScope.make()) : syntax_case.error("syntax-case", form))))))));
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
