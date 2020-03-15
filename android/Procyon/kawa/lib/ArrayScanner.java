// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import kawa.standard.Scheme;
import gnu.kawa.functions.AddOp;
import gnu.expr.Compilation;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.kawa.reflect.SlotGet;
import gnu.text.SourceLocator;
import kawa.lib.kawa.expressions;
import gnu.kawa.functions.Convert;
import gnu.bytecode.ArrayType;
import gnu.expr.Expression;
import gnu.expr.Declaration;
import gnu.bytecode.Type;

public class ArrayScanner extends ScanHelper
{
    public Type elementType;
    public Declaration seqDecl;
    public Declaration idxDecl;
    public Declaration lenDecl;
    
    @Override
    public void init(final Expression arg) {
        final ArrayType arrayType = ArrayType.make(this.elementType);
        final Expression seqArg = expressions.visitExp(expressions.applyExp$V(Convert.cast, new Object[] { arrayType, arg }));
        (this.seqDecl = super.comp.letVariable(null, arrayType, seqArg)).setLocation(arg);
        this.idxDecl = super.comp.letVariable(null, Type.int_type, expressions.$To$Exp(compile_map.Lit4));
        this.lenDecl = super.comp.letVariable(null, Type.int_type, expressions.applyExp$V(SlotGet.field, new Object[] { this.seqDecl, compile_map.Lit10 }));
    }
    
    @Override
    public Declaration eval() {
        final Compilation comp = super.comp;
        final Object name = null;
        final Type type = null;
        final Object force = Promise.force(expressions.applyToArgsExp$V(this.seqDecl, new Object[] { this.idxDecl }), Expression.class);
        try {
            return comp.letVariable(name, type, (Expression)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "gnu.expr.Compilation.letVariable(java.lang.Object,type,gnu.expr.Expression)", 4, force);
        }
    }
    
    @Override
    public Expression incr(final Declaration value) {
        return expressions.setExp(this.idxDecl, expressions.applyExp$V(AddOp.$Pl, new Object[] { this.idxDecl, compile_map.Lit7 }));
    }
    
    @Override
    public Expression test() {
        return expressions.applyExp$V(Scheme.numLss, new Object[] { this.idxDecl, this.lenDecl });
    }
}
