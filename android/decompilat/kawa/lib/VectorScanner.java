// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import kawa.standard.Scheme;
import gnu.kawa.functions.AddOp;
import gnu.kawa.reflect.Invoke;
import gnu.text.SourceLocator;
import gnu.bytecode.Type;
import kawa.lib.kawa.expressions;
import gnu.kawa.functions.Convert;
import gnu.expr.Expression;
import gnu.expr.Declaration;

public class VectorScanner extends ScanHelper
{
    public Declaration seqDecl;
    public Declaration idxDecl;
    public Declaration endDecl;
    
    @Override
    public void init(final Expression arg) {
        final Expression seqArg = expressions.visitExp(expressions.applyExp$V(Convert.cast, new Object[] { compile_map.Lit1, arg }));
        (this.seqDecl = super.comp.letVariable(null, null, seqArg)).setLocation(arg);
        this.idxDecl = super.comp.letVariable(null, Type.int_type, expressions.$To$Exp(compile_map.Lit4));
        this.endDecl = super.comp.letVariable(null, Type.int_type, expressions.applyExp$V(Invoke.invoke, new Object[] { this.seqDecl, compile_map.Lit22 }));
    }
    
    @Override
    public Declaration eval() {
        return super.comp.letVariable(null, null, expressions.applyExp$V(Invoke.invoke, new Object[] { this.seqDecl, compile_map.Lit23, this.idxDecl }));
    }
    
    @Override
    public Expression incr(final Declaration value) {
        return expressions.setExp(this.idxDecl, expressions.applyExp$V(AddOp.$Pl, new Object[] { this.idxDecl, compile_map.Lit7 }));
    }
    
    @Override
    public Expression test() {
        return expressions.applyExp$V(Scheme.numLss, new Object[] { this.idxDecl, this.endDecl });
    }
}
