/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.Not;
import gnu.kawa.reflect.Invoke;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.mapping.SimpleSymbol;
import gnu.text.SourceLocator;
import kawa.lib.ScanHelper;
import kawa.lib.compile_map;
import kawa.lib.kawa.expressions;
import kawa.standard.Scheme;

public class ListScanner
extends ScanHelper {
    public Declaration listDecl;
    public Declaration pairDecl;

    public void init(Expression arg) {
        Expression listArg = expressions.visitExp(arg);
        this.listDecl = this.comp.letVariable(null, null, listArg);
        this.listDecl.setLocation(arg);
    }

    public Expression test() {
        return expressions.applyExp$V(Scheme.not, new Object[]{expressions.applyExp$V(Scheme.isEq, new Object[]{this.listDecl, LList.Empty})});
    }

    public Declaration eval() {
        Declaration pDecl;
        this.pairDecl = pDecl = this.comp.letVariable(null, null, expressions.applyExp$V(Convert.cast, new Object[]{compile_map.Lit17, this.listDecl}));
        return this.comp.letVariable(null, null, expressions.applyExp$V(Invoke.invoke, new Object[]{pDecl, compile_map.Lit18}));
    }

    public Expression incr(Declaration value) {
        return expressions.setExp(this.listDecl, expressions.applyExp$V(Invoke.invoke, new Object[]{this.pairDecl, compile_map.Lit19}));
    }
}

