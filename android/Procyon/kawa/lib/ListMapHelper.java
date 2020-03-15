// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import kawa.standard.Scheme;
import gnu.expr.ReferenceExp;
import kawa.lib.kawa.expressions;
import gnu.kawa.reflect.Invoke;
import gnu.expr.QuoteExp;
import gnu.lists.LList;
import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.bytecode.Type;
import gnu.expr.Expression;
import gnu.expr.Declaration;

public class ListMapHelper extends MapHelper
{
    public boolean collecting;
    public Declaration resultDecl;
    public Declaration lastDecl;
    
    @Override
    public ScanHelper makeScanner(final Expression exp, final Type etype) {
        return compile_map.scannerFor(exp, etype, super.comp);
    }
    
    @Override
    public void initialize(final ApplyExp exp, final Compilation comp) {
        if (this.collecting) {
            this.resultDecl = comp.letVariable(null, LangObjType.listType, QuoteExp.getInstance(LList.Empty));
            this.lastDecl = comp.letVariable(null, compile_map.Lit20, QuoteExp.nullExp);
        }
    }
    
    @Override
    public Expression doCollect(final Expression value) {
        Expression letDone;
        if (this.collecting) {
            super.comp.letStart();
            final Declaration pairDecl = super.comp.letVariable(null, compile_map.Lit20, expressions.applyExp$V(Invoke.make, new Object[] { compile_map.Lit17, value, LList.Empty }));
            pairDecl.setFlag(Declaration.ALLOCATE_ON_STACK);
            final ReferenceExp pairLastRef = new ReferenceExp(pairDecl);
            pairLastRef.setFlag(ReferenceExp.ALLOCATE_ON_STACK_LAST);
            super.comp.letEnter();
            letDone = super.comp.letDone(expressions.beginExp$V(new Object[] { expressions.ifExp(expressions.applyExp$V(Scheme.isEq, new Object[] { this.lastDecl, null }), expressions.setExp(this.resultDecl, pairDecl), expressions.applyExp$V(Invoke.invoke, new Object[] { this.lastDecl, compile_map.Lit21, pairDecl })), expressions.setExp(this.lastDecl, pairLastRef) }));
        }
        else {
            letDone = value;
        }
        return letDone;
    }
    
    @Override
    public Expression collectResult(final Expression result) {
        return this.collecting ? expressions.beginExp$V(new Object[] { result, this.resultDecl }) : result;
    }
}
