/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.kawa.functions.Convert;
import gnu.kawa.reflect.Invoke;
import gnu.mapping.SimpleSymbol;
import gnu.text.SourceLocator;
import kawa.lib.ScanHelper;
import kawa.lib.compile_map;
import kawa.lib.kawa.expressions;

public class IterableScanner
extends ScanHelper {
    public boolean useGeneric;
    public Declaration iteratorDecl;

    private void $finit$() {
        this.useGeneric = true;
    }

    public void init(Expression arg) {
        Expression seqArg = expressions.visitExp(arg);
        if (this.useGeneric) {
            this.iteratorDecl = this.comp.letVariable(null, null, expressions.applyExp$V(Invoke.invokeStatic, new Object[]{compile_map.Lit11, compile_map.Lit12, seqArg}));
        } else {
            expressions.applyExp$V(Convert.as, new Object[]{compile_map.Lit3, seqArg});
            this.iteratorDecl = this.comp.letVariable(null, compile_map.Lit13, expressions.applyExp$V(Invoke.invoke, new Object[]{seqArg, compile_map.Lit14}));
        }
        this.iteratorDecl.setLocation(arg);
    }

    public Expression test() {
        return expressions.applyExp$V(Invoke.invoke, new Object[]{this.iteratorDecl, compile_map.Lit15});
    }

    public Declaration eval() {
        return this.comp.letVariable(null, null, expressions.applyExp$V(Invoke.invoke, new Object[]{this.iteratorDecl, compile_map.Lit16}));
    }

    public IterableScanner() {
        this.$finit$();
    }
}

