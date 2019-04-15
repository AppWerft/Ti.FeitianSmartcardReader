/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.SwitchState;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.io.OutPort;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.lists.EmptyList;
import gnu.lists.PairWithPosition;
import gnu.lists.SimpleVector;
import gnu.mapping.CallContext;
import gnu.math.IntNum;
import gnu.text.Char;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CaseExp
extends Expression {
    Expression key;
    CaseClause[] clauses;
    CaseClause elseClause;
    static Method isEqvMethod = ClassType.make("gnu.kawa.functions.IsEqv").getDeclaredStaticMethod("apply", 2);
    static Method hashCodeMethod = Type.objectType.getDeclaredMethod("hashCode", 0);

    public CaseExp(Expression key, CaseClause[] clauses) {
        this.key = key;
        this.clauses = clauses;
        this.elseClause = null;
        if (key == null || clauses == null || clauses.length == 0) {
            throw new IllegalArgumentException("CaseExp constructor called with null arguments");
        }
    }

    public CaseExp(Expression key, CaseClause[] clauses, CaseClause elseClause) {
        this.key = key;
        this.clauses = clauses;
        this.elseClause = elseClause;
        if (key == null || clauses == null || elseClause == null) {
            throw new IllegalArgumentException("CaseExp constructor called with null arguments");
        }
    }

    @Override
    protected boolean mustCompile() {
        return false;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        Expression e = this.selectCase(this.key.eval(ctx));
        if (e != null) {
            e.apply(ctx);
        } else {
            QuoteExp.voidExp.apply(ctx);
        }
    }

    @Override
    public void print(OutPort out) {
        out.startLogicalBlock("(Case ", false, ")");
        out.setIndentation(-2, false);
        this.key.print(out);
        for (int i = 0; i < this.clauses.length; ++i) {
            out.writeSpaceLinear();
            Expression[] datums = this.clauses[i].datums;
            Expression exp = this.clauses[i].exp;
            out.startLogicalBlock("(", false, ")");
            out.startLogicalBlock("(", false, ")");
            for (int j = 0; j < datums.length; ++j) {
                if (j > 0) {
                    out.print(' ');
                }
                out.print(((QuoteExp)datums[j]).getValue());
            }
            out.endLogicalBlock(")");
            out.writeSpaceLinear();
            exp.print(out);
            out.endLogicalBlock(")");
        }
        if (this.elseClause != null) {
            out.writeSpaceLinear();
            out.startLogicalBlock("(else ", false, ")");
            this.elseClause.exp.print(out);
            out.endLogicalBlock(")");
        }
        out.endLogicalBlock(")");
    }

    @Override
    public void compile(Compilation comp, Target target) {
        CodeAttr code = comp.getCode();
        this.compileKey(comp);
        if (!code.reachableHere()) {
            return;
        }
        boolean integer = this.key.getType() == Type.intType && this.calculateDatumsType() == Type.intType || (this.key.getType() == LangPrimType.characterType || this.key.getType() == LangPrimType.charType) && this.calculateDatumsType() == LangPrimType.characterType;
        HashMap<Integer, ArrayList<Object>> hashToClauseMap = new HashMap<Integer, ArrayList<Object>>();
        HashMap<Expression, Label> expToLabelMap = new HashMap<Expression, Label>();
        HashMap<Expression, Integer> expToPendingDatumCounts = new HashMap<Expression, Integer>();
        for (CaseClause clause : this.clauses) {
            Expression e = clause.exp;
            int saneDatums = 0;
            for (int j = 0; j < clause.datums.length; ++j) {
                Expression dexp = clause.datums[j];
                Object d = this.calculateDatumValue(dexp);
                if (!integer && d instanceof SimpleVector || !(d instanceof EmptyList) && d instanceof PairWithPosition) continue;
                ++saneDatums;
                int hash = d.hashCode();
                ArrayList<Object> a = (ArrayList<Object>)hashToClauseMap.get(hash);
                if (a == null) {
                    a = new ArrayList<Object>();
                    hashToClauseMap.put(hash, a);
                }
                a.add(d);
                a.add(e);
            }
            expToPendingDatumCounts.put(e, saneDatums);
        }
        SwitchState sw = code.startSwitch();
        Label before_label = new Label();
        before_label.setTypes(code);
        Label defaultl = new Label();
        Iterator i$ = hashToClauseMap.keySet().iterator();
        while (i$.hasNext()) {
            int h = (Integer)i$.next();
            if (!integer) {
                sw.addCase(h, code);
            }
            ArrayList dwes = (ArrayList)hashToClauseMap.get(h);
            for (int i = 0; i < dwes.size(); i += 2) {
                Object datum = dwes.get(i);
                Expression exp = (Expression)dwes.get(i + 1);
                if (!integer) {
                    if ((this.key.getType() == Type.intType || this.key.getType() == Type.longType) && datum instanceof IntNum) {
                        IntNum idatum = (IntNum)datum;
                        this.key.compile(comp, this.key.getType());
                        if (idatum.inIntRange() && this.key.getType() == Type.intType) {
                            int val = idatum.intValue();
                            code.emitPushInt(val);
                        } else {
                            StackTarget st = new StackTarget(Type.longType);
                            st.compileFromStack(comp, this.key.getType());
                            long val = idatum.longValue();
                            code.emitPushLong(val);
                        }
                        code.emitIfEq();
                    } else if ((this.key.getType() == LangPrimType.charType || this.key.getType() == LangPrimType.characterType) && datum instanceof Char) {
                        this.key.compile(comp, Type.intType);
                        int val = ((Char)datum).intValue();
                        code.emitPushInt(val);
                        code.emitIfEq();
                    } else {
                        this.key.compile(comp, Type.objectType);
                        comp.compileConstant(datum, Target.pushObject);
                        code.emitInvokeStatic(isEqvMethod);
                        code.emitIfIntNotZero();
                    }
                }
                int pendingDatumCount = (Integer)expToPendingDatumCounts.get(exp) - 1;
                Label expLabel = (Label)expToLabelMap.get(exp);
                if (pendingDatumCount == 0) {
                    if (integer) {
                        sw.addCase(h, code);
                    }
                    if (expLabel != null) {
                        expLabel.define(code);
                    }
                    exp.compile(comp, target);
                    sw.exitSwitch(code);
                } else {
                    expToPendingDatumCounts.put(exp, pendingDatumCount);
                    if (expLabel == null) {
                        expLabel = new Label(code);
                        expToLabelMap.put(exp, expLabel);
                    }
                    if (integer) {
                        sw.addCaseGoto(h, code, expLabel);
                    } else {
                        code.emitGoto(expLabel);
                    }
                }
                if (integer) continue;
                code.emitFi();
            }
            if (integer) continue;
            code.emitGoto(defaultl);
        }
        sw.addDefault(code);
        defaultl.define(code);
        if (this.elseClause != null) {
            this.elseClause.exp.compile(comp, target);
        } else {
            QuoteExp.voidExp.compile(comp, target);
        }
        sw.finish(code);
    }

    private void compileKey(Compilation comp) {
        CodeAttr code = comp.getCode();
        if (this.key.getType() == Type.intType || this.key.getType() == Type.shortType || this.key.getType() == Type.byteType || this.key.getType() == LangPrimType.charType || this.key.getType() == LangPrimType.characterType) {
            this.key.compile(comp, Type.intType);
        } else if (this.key.getType() == Type.longType) {
            this.key.compile(comp, Type.longType);
            this.key.compile(comp, Type.longType);
            code.emitPushInt(32);
            code.emitShr();
            code.emitXOr();
            StackTarget st = new StackTarget(Type.intType);
            st.compileFromStack(comp, Type.longType);
        } else {
            this.key.compile(comp, Type.objectType);
            code.emitInvokeVirtual(hashCodeMethod);
        }
    }

    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitCaseExp(this, d);
    }

    @Override
    protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
        this.key = visitor.visitAndUpdate(this.key, d);
        for (int i = 0; visitor.exitValue == null && i < this.clauses.length; ++i) {
            CaseClause clause = this.clauses[i];
            clause.exp = visitor.visitAndUpdate(clause.exp, d);
        }
        if (visitor.exitValue == null && this.elseClause != null) {
            this.elseClause.exp = visitor.visitAndUpdate(this.elseClause.exp, d);
        }
    }

    protected Object calculateDatumValue(Expression datum) {
        if (datum instanceof QuoteExp) {
            return ((QuoteExp)datum).value;
        }
        if (datum instanceof ReferenceExp) {
            return ((ReferenceExp)datum).getSymbol();
        }
        throw new Error("Invalid Datum");
    }

    @Override
    protected Type calculateType() {
        CaseClause clause;
        Type t;
        CaseClause caseClause = clause = this.clauses.length > 0 ? this.clauses[0] : null;
        if (clause != null) {
            t = clause.exp.getType();
            for (int i = 1; i < this.clauses.length; ++i) {
                clause = this.clauses[i];
                t = Language.unionType(t, clause.exp.getType());
            }
            t = this.elseClause != null ? Language.unionType(t, this.elseClause.exp.getType()) : Language.unionType(t, Type.voidType);
        } else if (this.elseClause != null) {
            t = this.elseClause.exp.getType();
        } else {
            throw new Error("Syntax Error: Case without any clause, at least a default clause is required");
        }
        return t;
    }

    protected Type calculateDatumsType() {
        Type t;
        boolean atLeastOne;
        boolean bl = atLeastOne = this.clauses.length > 0;
        if (atLeastOne) {
            t = this.calculateDatumType(this.clauses[0].datums);
            for (int i = 1; i < this.clauses.length; ++i) {
                t = Language.unionType(t, this.calculateDatumType(this.clauses[i].datums));
            }
        } else {
            if (this.elseClause != null) {
                return Type.voidType;
            }
            throw new Error();
        }
        return t;
    }

    private Type calculateDatumType(Expression[] datum) {
        Type t = this.resolveType(this.calculateDatumValue(datum[0]));
        for (int i = 1; i < datum.length; ++i) {
            t = Language.unionType(t, this.resolveType(this.calculateDatumValue(datum[i])));
        }
        return t;
    }

    private Type resolveType(Object o) {
        if (o instanceof IntNum) {
            IntNum ii = (IntNum)o;
            if (ii.inIntRange()) {
                return Type.intType;
            }
            if (ii.inLongRange()) {
                return Type.longType;
            }
            return LangObjType.integerType;
        }
        if (o instanceof Char) {
            return LangPrimType.characterType;
        }
        if (o instanceof Character) {
            return LangPrimType.charType;
        }
        return Type.make(o.getClass());
    }

    public boolean searchValue(Object keyValue) {
        Expression exp = this.selectCase(keyValue);
        Expression elseExp = this.elseClause != null ? this.elseClause.exp : null;
        return exp != null && exp != elseExp;
    }

    public Expression selectCase(Object keyValue) {
        for (int i = 0; i < this.clauses.length; ++i) {
            Expression[] datums = this.clauses[i].datums;
            int pos = -1;
            for (int j = 0; j < datums.length; ++j) {
                if (!IsEqv.apply(keyValue, this.calculateDatumValue(datums[j]))) continue;
                pos = j;
            }
            if (pos < 0) continue;
            return this.clauses[i].exp;
        }
        return this.elseClause != null ? this.elseClause.exp : null;
    }

    public static class CaseClause {
        Expression[] datums;
        Expression exp;

        public CaseClause(Expression exp) {
            this.datums = null;
            this.exp = exp;
        }

        public CaseClause(Expression[] datums, Expression exp) {
            this.datums = datums;
            this.exp = exp;
        }
    }

}

