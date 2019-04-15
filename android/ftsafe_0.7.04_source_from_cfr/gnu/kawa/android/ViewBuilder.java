/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.android;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.ModuleExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.android.ViewBuilder$frame;
import gnu.kawa.reflect.CompileBuildObject;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;

public class ViewBuilder
extends CompileBuildObject {
    public static ClassType activityType;
    public static final Class ViewBuilder;
    static final SimpleSymbol Lit0;
    static final ClassType Lit1;

    public static {
        Lit1 = ClassType.make("android.app.Activity");
        Lit0 = Symbol.valueOf("current-activity");
        ViewBuilder$frame.$instance = new ViewBuilder$frame();
        ViewBuilder = ViewBuilder.class;
        activityType = ClassType.make("android.app.Activity");
        ViewBuilder.$runBody$();
    }

    public boolean hasAddChildMethod() {
        return true;
    }

    public String getAddChildMethodName() {
        return "addView";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean useBuilder(int numCode, InlineCalls visitor) {
        block3 : {
            block4 : {
                block2 : {
                    boolean x;
                    boolean bl = x = this.getArgCount() < 2;
                    if (!x) break block2;
                    if (!x) break block3;
                    break block4;
                }
                Expression arg1 = visitor.visit(this.getArg(1), null);
                Type type1 = arg1.getType();
                int cmp = activityType.compare(type1);
                this.setArg(1, arg1);
                if (cmp >= 0) break block3;
            }
            Declaration activity$Mndecl = this.getCompilation().getModule().lookup(Lit0);
            this.insertArgument(1, visitor.visit((Expression)Compilation.makeCoercion((Expression)new ApplyExp(new ReferenceExp(activity$Mndecl), new Expression[0]), Lit1), null));
            return true;
        }
        boolean bl = super.useBuilder(numCode, visitor);
        return bl;
    }

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }
}

