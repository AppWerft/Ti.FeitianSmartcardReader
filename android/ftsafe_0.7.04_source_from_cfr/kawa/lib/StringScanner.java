/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.Invoke;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import kawa.lib.ScanHelper;
import kawa.lib.compile_map;
import kawa.lib.kawa.expressions;
import kawa.lib.kawa.string-cursors;
import kawa.standard.Scheme;

public class StringScanner
extends ScanHelper {
    public Declaration seqDecl;
    public Declaration idxDecl;
    public Declaration endDecl;

    public void init(Expression arg) {
        this.seqDecl = this.comp.letVariable(null, null, expressions.visitExp(expressions.applyExp$V(Convert.cast, new Object[]{LangObjType.stringType, arg})));
        this.idxDecl = this.comp.letVariable(null, LangPrimType.stringCursorType, expressions.applyExp$V(Convert.as, new Object[]{LangPrimType.stringCursorType, compile_map.Lit4}));
        this.endDecl = this.comp.letVariable(null, LangPrimType.stringCursorType, expressions.applyExp$V(Invoke.invoke, new Object[]{this.seqDecl, compile_map.Lit10}));
    }

    public Expression test() {
        return expressions.applyExp$V(string-cursors.string$Mncursor$Ls$Qu, new Object[]{this.idxDecl, this.endDecl});
    }

    public Declaration eval() {
        return this.comp.letVariable(null, LangPrimType.characterType, expressions.applyExp$V(string-cursors.string$Mncursor$Mnref, new Object[]{this.seqDecl, this.idxDecl}));
    }

    public Expression incr(Declaration value) {
        return expressions.setExp(this.idxDecl, expressions.applyExp$V(Convert.as, new Object[]{LangPrimType.stringCursorType, expressions.applyExp$V(AddOp.$Pl, new Object[]{expressions.applyExp$V(Convert.as, new Object[]{Type.int_type, this.idxDecl}), expressions.ifExp(expressions.applyExp$V(Scheme.numGrt, new Object[]{value, compile_map.Lit5}), compile_map.Lit6, compile_map.Lit7)})}));
    }
}

