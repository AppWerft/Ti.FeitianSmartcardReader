/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.ArrayType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.reflect.SlotGet;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.SourceLocator;
import kawa.lib.ScanHelper;
import kawa.lib.compile_map;
import kawa.lib.kawa.expressions;
import kawa.standard.Scheme;

public class ArrayScanner
extends ScanHelper {
    public Type elementType;
    public Declaration seqDecl;
    public Declaration idxDecl;
    public Declaration lenDecl;

    public void init(Expression arg) {
        ArrayType arrayType = ArrayType.make(this.elementType);
        Expression seqArg = expressions.visitExp(expressions.applyExp$V(Convert.cast, new Object[]{arrayType, arg}));
        this.seqDecl = this.comp.letVariable(null, arrayType, seqArg);
        this.seqDecl.setLocation(arg);
        this.idxDecl = this.comp.letVariable(null, Type.int_type, expressions.$To$Exp(compile_map.Lit4));
        this.lenDecl = this.comp.letVariable(null, Type.int_type, expressions.applyExp$V(SlotGet.field, new Object[]{this.seqDecl, compile_map.Lit10}));
    }

    public Declaration eval() {
        Object object2 = Promise.force(expressions.applyToArgsExp$V(this.seqDecl, new Object[]{this.idxDecl}), Expression.class);
        try {
            return this.comp.letVariable(null, null, (Expression)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.expr.Compilation.letVariable(java.lang.Object,type,gnu.expr.Expression)", 4, object2);
        }
    }

    public Expression incr(Declaration value) {
        return expressions.setExp(this.idxDecl, expressions.applyExp$V(AddOp.$Pl, new Object[]{this.idxDecl, compile_map.Lit7}));
    }

    public Expression test() {
        return expressions.applyExp$V(Scheme.numLss, new Object[]{this.idxDecl, this.lenDecl});
    }
}

