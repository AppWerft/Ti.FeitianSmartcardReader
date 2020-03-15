// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.kawa.reflect.Invoke;
import gnu.kawa.functions.Convert;
import gnu.lists.LList;
import kawa.standard.Scheme;
import gnu.text.SourceLocator;
import gnu.bytecode.Type;
import kawa.lib.kawa.expressions;
import gnu.expr.Expression;
import gnu.expr.Declaration;

public class ListScanner extends ScanHelper
{
    public Declaration listDecl;
    public Declaration pairDecl;
    
    @Override
    public void init(final Expression arg) {
        final Expression listArg = expressions.visitExp(arg);
        (this.listDecl = super.comp.letVariable(null, null, listArg)).setLocation(arg);
    }
    
    @Override
    public Expression test() {
        return expressions.applyExp$V(Scheme.not, new Object[] { expressions.applyExp$V(Scheme.isEq, new Object[] { this.listDecl, LList.Empty }) });
    }
    
    @Override
    public Declaration eval() {
        final Declaration pDecl = super.comp.letVariable(null, null, expressions.applyExp$V(Convert.cast, new Object[] { compile_map.Lit17, this.listDecl }));
        this.pairDecl = pDecl;
        return super.comp.letVariable(null, null, expressions.applyExp$V(Invoke.invoke, new Object[] { pDecl, compile_map.Lit18 }));
    }
    
    @Override
    public Expression incr(final Declaration value) {
        return expressions.setExp(this.listDecl, expressions.applyExp$V(Invoke.invoke, new Object[] { this.pairDecl, compile_map.Lit19 }));
    }
}
