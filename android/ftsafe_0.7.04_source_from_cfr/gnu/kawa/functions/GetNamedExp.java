/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.PrimProcedure;
import gnu.expr.ReferenceExp;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.reflect.CompileInvoke;
import gnu.kawa.reflect.Invoke;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;

class GetNamedExp
extends ApplyExp {
    char kind;
    PrimProcedure[] methods;
    ObjectType otype;
    String mname;
    public String combinedName;
    static final Declaration fieldDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.SlotGet", "field");
    static final Declaration staticFieldDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.SlotGet", "staticField");
    static final Declaration makeDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.Invoke", "make");
    static final Declaration invokeDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.Invoke", "invoke");
    static final Declaration invokeStaticDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.Invoke", "invokeStatic");
    static final Declaration instanceOfDecl = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "instanceOf");
    static final Declaration castDecl = Declaration.getDeclarationFromStatic("gnu.kawa.functions.Convert", "as");

    @Override
    public void apply(CallContext ctx) throws Throwable {
        String unb;
        Object value;
        Environment env;
        Object property;
        Symbol sym;
        if (this.combinedName != null && (value = (env = Environment.getCurrent()).get(sym = env.getSymbol(this.combinedName), property = null, unb = Location.UNBOUND)) != unb) {
            ctx.writeValue(value);
            return;
        }
        super.apply(ctx);
    }

    public GetNamedExp(Expression[] args) {
        super(GetNamedPart.getNamedPart, args);
    }

    protected GetNamedExp setProcedureKind(char kind) {
        this.type = Compilation.typeProcedure;
        this.kind = kind;
        return this;
    }

    @Override
    public Expression validateApply(ApplyExp exp, InlineCalls visitor, Type required, Declaration decl) {
        int adjust;
        Expression[] xargs;
        Expression[] pargs = this.getArgs();
        Expression context = pargs[0];
        Expression[] args = exp.getArgs();
        switch (this.kind) {
            case 'M': {
                decl = invokeDecl;
                xargs = new Expression[args.length + 2];
                xargs[0] = pargs[0];
                xargs[1] = pargs[1];
                System.arraycopy(args, 0, xargs, 2, args.length);
                adjust = 2;
                break;
            }
            case 'N': {
                decl = makeDecl;
                xargs = new Expression[args.length + 1];
                System.arraycopy(args, 0, xargs, 1, args.length);
                xargs[0] = context;
                adjust = 1;
                break;
            }
            case 'I': {
                decl = instanceOfDecl;
                xargs = new Expression[args.length + 1];
                System.arraycopy(args, 1, xargs, 2, args.length - 1);
                xargs[0] = args[0];
                xargs[1] = context;
                adjust = exp.firstSpliceArg > 0 ? 1 : 0;
                break;
            }
            case 'C': {
                decl = castDecl;
                xargs = new Expression[args.length + 1];
                System.arraycopy(args, 0, xargs, 1, args.length);
                xargs[0] = context;
                adjust = 1;
                break;
            }
            case 'S': {
                decl = invokeStaticDecl;
                xargs = new Expression[args.length + 2];
                xargs[0] = context;
                xargs[1] = pargs[1];
                System.arraycopy(args, 0, xargs, 2, args.length);
                adjust = 2;
                break;
            }
            default: {
                return exp;
            }
        }
        ApplyExp result = new ApplyExp(new ReferenceExp(decl), xargs);
        if (exp.firstSpliceArg >= 0) {
            result.firstSpliceArg = exp.firstSpliceArg + adjust;
        }
        result.setLine(exp);
        if (this.methods != null && this.kind == 'S') {
            return CompileInvoke.validateNamedInvoke(result, visitor, this.otype, this.mname, this.methods, Invoke.invokeStatic, required);
        }
        return visitor.visit((Expression)result, required);
    }

    @Override
    public boolean side_effects() {
        if (this.kind == 'S' || this.kind == 'N' || this.kind == 'C' || this.kind == 'I') {
            return false;
        }
        if (this.kind == 'M') {
            return this.getArgs()[0].side_effects();
        }
        return true;
    }
}

