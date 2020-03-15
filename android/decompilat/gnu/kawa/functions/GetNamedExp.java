// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.kawa.reflect.CompileInvoke;
import gnu.kawa.reflect.Invoke;
import gnu.expr.ReferenceExp;
import gnu.bytecode.Type;
import gnu.expr.InlineCalls;
import gnu.expr.Compilation;
import gnu.mapping.Procedure;
import gnu.expr.Expression;
import gnu.mapping.Symbol;
import gnu.mapping.Location;
import gnu.mapping.Environment;
import gnu.mapping.CallContext;
import gnu.expr.Declaration;
import gnu.bytecode.ObjectType;
import gnu.expr.PrimProcedure;
import gnu.expr.ApplyExp;

class GetNamedExp extends ApplyExp
{
    char kind;
    PrimProcedure[] methods;
    ObjectType otype;
    String mname;
    public String combinedName;
    static final Declaration fieldDecl;
    static final Declaration staticFieldDecl;
    static final Declaration makeDecl;
    static final Declaration invokeDecl;
    static final Declaration invokeStaticDecl;
    static final Declaration instanceOfDecl;
    static final Declaration castDecl;
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        if (this.combinedName != null) {
            final Environment env = Environment.getCurrent();
            final Symbol sym = env.getSymbol(this.combinedName);
            final Object unb = Location.UNBOUND;
            final Object property = null;
            final Object value = env.get(sym, property, unb);
            if (value != unb) {
                ctx.writeValue(value);
                return;
            }
        }
        super.apply(ctx);
    }
    
    public GetNamedExp(final Expression[] args) {
        super(GetNamedPart.getNamedPart, args);
    }
    
    protected GetNamedExp setProcedureKind(final char kind) {
        this.type = Compilation.typeProcedure;
        this.kind = kind;
        return this;
    }
    
    @Override
    public Expression validateApply(final ApplyExp exp, final InlineCalls visitor, final Type required, Declaration decl) {
        final Expression[] pargs = this.getArgs();
        final Expression context = pargs[0];
        final Expression[] args = exp.getArgs();
        Expression[] xargs = null;
        int adjust = 0;
        switch (this.kind) {
            case 'M': {
                decl = GetNamedExp.invokeDecl;
                xargs = new Expression[args.length + 2];
                xargs[0] = pargs[0];
                xargs[1] = pargs[1];
                System.arraycopy(args, 0, xargs, 2, args.length);
                adjust = 2;
                break;
            }
            case 'N': {
                decl = GetNamedExp.makeDecl;
                xargs = new Expression[args.length + 1];
                System.arraycopy(args, 0, xargs, 1, args.length);
                xargs[0] = context;
                adjust = 1;
                break;
            }
            case 'I': {
                decl = GetNamedExp.instanceOfDecl;
                xargs = new Expression[args.length + 1];
                System.arraycopy(args, 1, xargs, 2, args.length - 1);
                xargs[0] = args[0];
                xargs[1] = context;
                adjust = ((exp.firstSpliceArg > 0) ? 1 : 0);
                break;
            }
            case 'C': {
                decl = GetNamedExp.castDecl;
                xargs = new Expression[args.length + 1];
                System.arraycopy(args, 0, xargs, 1, args.length);
                xargs[0] = context;
                adjust = 1;
                break;
            }
            case 'S': {
                decl = GetNamedExp.invokeStaticDecl;
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
        final ApplyExp result = new ApplyExp(new ReferenceExp(decl), xargs);
        if (exp.firstSpliceArg >= 0) {
            result.firstSpliceArg = exp.firstSpliceArg + adjust;
        }
        result.setLine(exp);
        if (this.methods != null && this.kind == 'S') {
            return CompileInvoke.validateNamedInvoke(result, visitor, this.otype, this.mname, this.methods, Invoke.invokeStatic, required);
        }
        return visitor.visit(result, required);
    }
    
    @Override
    public boolean side_effects() {
        return this.kind != 'S' && this.kind != 'N' && this.kind != 'C' && this.kind != 'I' && (this.kind != 'M' || this.getArgs()[0].side_effects());
    }
    
    static {
        fieldDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.SlotGet", "field");
        staticFieldDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.SlotGet", "staticField");
        makeDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.Invoke", "make");
        invokeDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.Invoke", "invoke");
        invokeStaticDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.Invoke", "invokeStatic");
        instanceOfDecl = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "instanceOf");
        castDecl = Declaration.getDeclarationFromStatic("gnu.kawa.functions.Convert", "as");
    }
}
