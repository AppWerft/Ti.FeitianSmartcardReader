// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.android;

import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.expr.Declaration;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.mapping.Symbol;
import gnu.mapping.SimpleSymbol;
import gnu.bytecode.ClassType;
import gnu.kawa.reflect.CompileBuildObject;

public class ViewBuilder extends CompileBuildObject
{
    public static ClassType activityType;
    public static final Class ViewBuilder;
    static final SimpleSymbol Lit0;
    static final ClassType Lit1;
    
    static {
        Lit1 = ClassType.make("android.app.Activity");
        Lit0 = Symbol.valueOf("current-activity");
        ViewBuilder$frame.$instance = new ViewBuilder$frame();
        ViewBuilder = ViewBuilder.class;
        gnu.kawa.android.ViewBuilder.activityType = ClassType.make("android.app.Activity");
        $runBody$();
    }
    
    @Override
    public boolean hasAddChildMethod() {
        return true;
    }
    
    @Override
    public String getAddChildMethodName() {
        return "addView";
    }
    
    @Override
    public boolean useBuilder(final int numCode, final InlineCalls visitor) {
        final boolean x = this.getArgCount() < 2;
        if (x) {
            if (!x) {
                return super.useBuilder(numCode, visitor);
            }
        }
        else {
            final Expression arg1 = visitor.visit(this.getArg(1), (Type)null);
            final Type type1 = arg1.getType();
            final int cmp = gnu.kawa.android.ViewBuilder.activityType.compare(type1);
            this.setArg(1, arg1);
            if (cmp >= 0) {
                return super.useBuilder(numCode, visitor);
            }
        }
        final Declaration activity$Mndecl = this.getCompilation().getModule().lookup(gnu.kawa.android.ViewBuilder.Lit0);
        this.insertArgument(1, visitor.visit(Compilation.makeCoercion(new ApplyExp(new ReferenceExp(activity$Mndecl), new Expression[0]), gnu.kawa.android.ViewBuilder.Lit1), (Type)null));
        return true;
        useBuilder = super.useBuilder(numCode, visitor);
        return useBuilder;
    }
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
}
