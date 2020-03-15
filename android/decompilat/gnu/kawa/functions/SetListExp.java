// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.bytecode.Method;
import gnu.kawa.reflect.Invoke;
import gnu.expr.Compilation;
import gnu.expr.QuoteExp;
import gnu.mapping.Procedure;
import gnu.expr.PrimProcedure;
import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.Declaration;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.Expression;
import gnu.bytecode.ObjectType;
import gnu.expr.ApplyExp;

class SetListExp extends ApplyExp
{
    ObjectType funcType;
    
    public SetListExp(final Expression func, final ObjectType funcType, final Expression[] args) {
        super(func, args);
        this.funcType = funcType;
    }
    
    @Override
    public Expression validateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, final Declaration decl) {
        exp.visitArgs(visitor);
        final Expression[] args = exp.getArgs();
        if (args.length == 2) {
            final Expression[] xargs = new Expression[4];
            final Expression value = args[1];
            if (this.funcType instanceof LangObjType) {
                final LangObjType ltype = (LangObjType)this.funcType;
                final Type elementType = ltype.getElementType();
                if (elementType != null) {
                    final String mname = ltype.elementSetterMethodName();
                    final Type[] atypes = { Type.intType, elementType.getImplementationType() };
                    final Method setter = ltype.getMethod(mname, atypes);
                    final PrimProcedure prproc = new PrimProcedure(setter, Type.voidType, new Type[] { Type.intType, elementType });
                    return visitor.visit(new ApplyExp(prproc, new Expression[] { this.getArgs()[0], args[0], args[1] }), required);
                }
            }
            final Type itype = args[0].getType();
            final int listIndexCompat = LangObjType.sequenceType.isCompatibleWithValue(itype);
            final int intIndexCompat = Type.intType.isCompatibleWithValue(itype);
            if (listIndexCompat < 0 && intIndexCompat < 0) {
                visitor.getCompilation().error('w', "index is neither integer or sequence");
            }
            else if (listIndexCompat <= 0) {
                if (intIndexCompat > 0) {
                    xargs[0] = this.getArgs()[0];
                    xargs[1] = QuoteExp.getInstance("set");
                    xargs[2] = Compilation.makeCoercion(args[0], Type.intType);
                    xargs[3] = value;
                    return visitor.visit(Compilation.makeCoercion(new ApplyExp(Invoke.invoke, xargs), Type.voidType), required);
                }
            }
        }
        return exp;
    }
}
