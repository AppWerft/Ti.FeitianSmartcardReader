/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.Invoke;
import gnu.mapping.Procedure;

class SetListExp
extends ApplyExp {
    ObjectType funcType;

    public SetListExp(Expression func, ObjectType funcType, Expression[] args) {
        super(func, args);
        this.funcType = funcType;
    }

    @Override
    public Expression validateApply(ApplyExp exp, InlineCalls visitor, Type required, Declaration decl) {
        exp.visitArgs(visitor);
        Expression[] args = exp.getArgs();
        if (args.length == 2) {
            Type elementType;
            LangObjType ltype;
            Expression[] xargs = new Expression[4];
            Expression value = args[1];
            if (this.funcType instanceof LangObjType && (elementType = (ltype = (LangObjType)this.funcType).getElementType()) != null) {
                String mname = ltype.elementSetterMethodName();
                Type[] atypes = new Type[]{Type.intType, elementType.getImplementationType()};
                Method setter = ltype.getMethod(mname, atypes);
                PrimProcedure prproc = new PrimProcedure(setter, (Type)Type.voidType, new Type[]{Type.intType, elementType});
                return visitor.visit((Expression)new ApplyExp(prproc, this.getArgs()[0], args[0], args[1]), required);
            }
            Type itype = args[0].getType();
            int listIndexCompat = LangObjType.sequenceType.isCompatibleWithValue(itype);
            int intIndexCompat = Type.intType.isCompatibleWithValue(itype);
            if (listIndexCompat < 0 && intIndexCompat < 0) {
                visitor.getCompilation().error('w', "index is neither integer or sequence");
            } else if (listIndexCompat <= 0 && intIndexCompat > 0) {
                xargs[0] = this.getArgs()[0];
                xargs[1] = QuoteExp.getInstance("set");
                xargs[2] = Compilation.makeCoercion(args[0], Type.intType);
                xargs[3] = value;
                return visitor.visit((Expression)Compilation.makeCoercion((Expression)new ApplyExp(Invoke.invoke, xargs), Type.voidType), required);
            }
        }
        return exp;
    }
}

