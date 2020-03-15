// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import kawa.standard.Scheme;
import gnu.kawa.functions.AddOp;
import kawa.lib.kawa.string-cursors;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.bytecode.Type;
import kawa.lib.kawa.expressions;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.functions.Convert;
import gnu.expr.Expression;
import gnu.expr.Declaration;

public class StringScanner extends ScanHelper
{
    public Declaration seqDecl;
    public Declaration idxDecl;
    public Declaration endDecl;
    
    @Override
    public void init(final Expression arg) {
        this.seqDecl = super.comp.letVariable(null, null, expressions.visitExp(expressions.applyExp$V(Convert.cast, new Object[] { LangObjType.stringType, arg })));
        this.idxDecl = super.comp.letVariable(null, LangPrimType.stringCursorType, expressions.applyExp$V(Convert.as, new Object[] { LangPrimType.stringCursorType, compile_map.Lit4 }));
        this.endDecl = super.comp.letVariable(null, LangPrimType.stringCursorType, expressions.applyExp$V(Invoke.invoke, new Object[] { this.seqDecl, compile_map.Lit10 }));
    }
    
    @Override
    public Expression test() {
        return expressions.applyExp$V(string-cursors.string$Mncursor$Ls$Qu, new Object[] { this.idxDecl, this.endDecl });
    }
    
    @Override
    public Declaration eval() {
        return super.comp.letVariable(null, LangPrimType.characterType, expressions.applyExp$V(string-cursors.string$Mncursor$Mnref, new Object[] { this.seqDecl, this.idxDecl }));
    }
    
    @Override
    public Expression incr(final Declaration value) {
        return expressions.setExp(this.idxDecl, expressions.applyExp$V(Convert.as, new Object[] { LangPrimType.stringCursorType, expressions.applyExp$V(AddOp.$Pl, new Object[] { expressions.applyExp$V(Convert.as, new Object[] { Type.int_type, this.idxDecl }), expressions.ifExp(expressions.applyExp$V(Scheme.numGrt, new Object[] { value, compile_map.Lit5 }), compile_map.Lit6, compile_map.Lit7) }) }));
    }
}
