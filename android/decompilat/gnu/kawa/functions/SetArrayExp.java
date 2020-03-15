// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.kawa.reflect.ArraySet;
import gnu.expr.Declaration;
import gnu.expr.InlineCalls;
import gnu.mapping.Procedure;
import gnu.expr.QuoteExp;
import gnu.kawa.reflect.Invoke;
import gnu.bytecode.ArrayType;
import gnu.expr.Expression;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;
import gnu.expr.ApplyExp;

class SetArrayExp extends ApplyExp
{
    public static final ClassType typeSetArray;
    Type elementType;
    
    public SetArrayExp(final Expression array, final ArrayType arrayType) {
        super(Invoke.make, new Expression[] { new QuoteExp(SetArrayExp.typeSetArray), array });
        this.elementType = arrayType.getComponentType();
    }
    
    @Override
    public Expression validateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Declaration decl) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        if (args.length == 2) {
            final Expression array = this.getArgs()[1];
            final Expression[] xargs = { array, args[0], args[1] };
            final ArraySet arrSetter = new ArraySet(this.elementType);
            return visitor.visitApplyOnly(new ApplyExp(arrSetter, xargs), required);
        }
        return exp;
    }
    
    static {
        typeSetArray = ClassType.make("gnu.kawa.functions.SetArray");
    }
}
