// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.text.SourceLocator;
import gnu.kawa.functions.Convert;
import gnu.bytecode.Type;
import gnu.kawa.reflect.Invoke;
import kawa.lib.kawa.expressions;
import gnu.expr.Expression;
import gnu.expr.Declaration;

public class IterableScanner extends ScanHelper
{
    public boolean useGeneric;
    public Declaration iteratorDecl;
    
    private void $finit$() {
        this.useGeneric = true;
    }
    
    @Override
    public void init(final Expression arg) {
        final Expression seqArg = expressions.visitExp(arg);
        if (this.useGeneric) {
            this.iteratorDecl = super.comp.letVariable(null, null, expressions.applyExp$V(Invoke.invokeStatic, new Object[] { compile_map.Lit11, compile_map.Lit12, seqArg }));
        }
        else {
            expressions.applyExp$V(Convert.as, new Object[] { compile_map.Lit3, seqArg });
            this.iteratorDecl = super.comp.letVariable(null, compile_map.Lit13, expressions.applyExp$V(Invoke.invoke, new Object[] { seqArg, compile_map.Lit14 }));
        }
        this.iteratorDecl.setLocation(arg);
    }
    
    @Override
    public Expression test() {
        return expressions.applyExp$V(Invoke.invoke, new Object[] { this.iteratorDecl, compile_map.Lit15 });
    }
    
    @Override
    public Declaration eval() {
        return super.comp.letVariable(null, null, expressions.applyExp$V(Invoke.invoke, new Object[] { this.iteratorDecl, compile_map.Lit16 }));
    }
    
    public IterableScanner() {
        this.$finit$();
    }
}
