/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.reflect.Invoke;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.text.SourceLocator;
import kawa.lib.ScanHelper;
import kawa.lib.compile_map;
import kawa.lib.kawa.expressions;
import kawa.standard.Scheme;

public class VectorScanner
extends ScanHelper {
    public Declaration seqDecl;
    public Declaration idxDecl;
    public Declaration endDecl;

    public void init(Expression arg) {
        Expression seqArg = expressions.visitExp(expressions.applyExp$V(Convert.cast, new Object[]{compile_map.Lit1, arg}));
        this.seqDecl = this.comp.letVariable(null, null, seqArg);
        this.seqDecl.setLocation(arg);
        this.idxDecl = this.comp.letVariable(null, Type.int_type, expressions.$To$Exp(compile_map.Lit4));
        this.endDecl = this.comp.letVariable(null, Type.int_type, expressions.applyExp$V(Invoke.invoke, new Object[]{this.seqDecl, compile_map.Lit22}));
    }

    public Declaration eval() {
        return this.comp.letVariable(null, null, expressions.applyExp$V(Invoke.invoke, new Object[]{this.seqDecl, compile_map.Lit23, this.idxDecl}));
    }

    public Expression incr(Declaration value) {
        return expressions.setExp(this.idxDecl, expressions.applyExp$V(AddOp.$Pl, new Object[]{this.idxDecl, compile_map.Lit7}));
    }

    public Expression test() {
        return expressions.applyExp$V(Scheme.numLss, new Object[]{this.idxDecl, this.endDecl});
    }
}

