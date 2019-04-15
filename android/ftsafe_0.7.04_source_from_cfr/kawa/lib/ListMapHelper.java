/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LetExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.functions.IsEq;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.Invoke;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.mapping.SimpleSymbol;
import kawa.lib.MapHelper;
import kawa.lib.ScanHelper;
import kawa.lib.compile_map;
import kawa.lib.kawa.expressions;
import kawa.standard.Scheme;

public class ListMapHelper
extends MapHelper {
    public boolean collecting;
    public Declaration resultDecl;
    public Declaration lastDecl;

    public ScanHelper makeScanner(Expression exp, Type etype) {
        return compile_map.scannerFor(exp, etype, this.comp);
    }

    public void initialize(ApplyExp exp, Compilation comp) {
        if (this.collecting) {
            this.resultDecl = comp.letVariable(null, LangObjType.listType, QuoteExp.getInstance(LList.Empty));
            this.lastDecl = comp.letVariable(null, compile_map.Lit20, QuoteExp.nullExp);
        }
    }

    public Expression doCollect(Expression value) {
        Expression expression;
        if (this.collecting) {
            this.comp.letStart();
            Declaration pairDecl = this.comp.letVariable(null, compile_map.Lit20, expressions.applyExp$V(Invoke.make, new Object[]{compile_map.Lit17, value, LList.Empty}));
            pairDecl.setFlag(Declaration.ALLOCATE_ON_STACK);
            ReferenceExp pairLastRef = new ReferenceExp(pairDecl);
            pairLastRef.setFlag(ReferenceExp.ALLOCATE_ON_STACK_LAST);
            this.comp.letEnter();
            expression = this.comp.letDone(expressions.beginExp$V(new Object[]{expressions.ifExp(expressions.applyExp$V(Scheme.isEq, new Object[]{this.lastDecl, null}), expressions.setExp(this.resultDecl, pairDecl), expressions.applyExp$V(Invoke.invoke, new Object[]{this.lastDecl, compile_map.Lit21, pairDecl})), expressions.setExp(this.lastDecl, pairLastRef)}));
        } else {
            expression = value;
        }
        return expression;
    }

    public Expression collectResult(Expression result) {
        return this.collecting ? expressions.beginExp$V(new Object[]{result, this.resultDecl}) : result;
    }
}

