// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.lispexpr.LangObjType;
import java.util.Iterator;
import gnu.bytecode.SwitchState;
import gnu.bytecode.CodeAttr;
import gnu.text.Char;
import gnu.math.IntNum;
import gnu.lists.PairWithPosition;
import gnu.lists.EmptyList;
import gnu.lists.SimpleVector;
import gnu.bytecode.Label;
import java.util.ArrayList;
import java.util.HashMap;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.bytecode.Type;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;
import gnu.bytecode.Method;

public class CaseExp extends Expression
{
    Expression key;
    CaseClause[] clauses;
    CaseClause elseClause;
    static Method isEqvMethod;
    static Method hashCodeMethod;
    
    public CaseExp(final Expression key, final CaseClause[] clauses) {
        this.key = key;
        this.clauses = clauses;
        this.elseClause = null;
        if (key == null || clauses == null || clauses.length == 0) {
            throw new IllegalArgumentException("CaseExp constructor called with null arguments");
        }
    }
    
    public CaseExp(final Expression key, final CaseClause[] clauses, final CaseClause elseClause) {
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
    public void apply(final CallContext ctx) throws Throwable {
        final Expression e = this.selectCase(this.key.eval(ctx));
        if (e != null) {
            e.apply(ctx);
        }
        else {
            QuoteExp.voidExp.apply(ctx);
        }
    }
    
    @Override
    public void print(final OutPort out) {
        out.startLogicalBlock("(Case ", false, ")");
        out.setIndentation(-2, false);
        this.key.print(out);
        for (int i = 0; i < this.clauses.length; ++i) {
            out.writeSpaceLinear();
            final Expression[] datums = this.clauses[i].datums;
            final Expression exp = this.clauses[i].exp;
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
    public void compile(final Compilation comp, final Target target) {
        final CodeAttr code = comp.getCode();
        this.compileKey(comp);
        if (!code.reachableHere()) {
            return;
        }
        final boolean integer = (this.key.getType() == Type.intType && this.calculateDatumsType() == Type.intType) || ((this.key.getType() == LangPrimType.characterType || this.key.getType() == LangPrimType.charType) && this.calculateDatumsType() == LangPrimType.characterType);
        final HashMap<Integer, ArrayList<Object>> hashToClauseMap = new HashMap<Integer, ArrayList<Object>>();
        final HashMap<Expression, Label> expToLabelMap = new HashMap<Expression, Label>();
        final HashMap<Expression, Integer> expToPendingDatumCounts = new HashMap<Expression, Integer>();
        for (final CaseClause clause : this.clauses) {
            final Expression e = clause.exp;
            int saneDatums = 0;
            for (int j = 0; j < clause.datums.length; ++j) {
                final Expression dexp = clause.datums[j];
                final Object d = this.calculateDatumValue(dexp);
                if (integer || !(d instanceof SimpleVector)) {
                    if (d instanceof EmptyList || !(d instanceof PairWithPosition)) {
                        ++saneDatums;
                        final int hash = d.hashCode();
                        ArrayList<Object> a = hashToClauseMap.get(hash);
                        if (a == null) {
                            a = new ArrayList<Object>();
                            hashToClauseMap.put(hash, a);
                        }
                        a.add(d);
                        a.add(e);
                    }
                }
            }
            expToPendingDatumCounts.put(e, saneDatums);
        }
        final SwitchState sw = code.startSwitch();
        final Label before_label = new Label();
        before_label.setTypes(code);
        final Label defaultl = new Label();
        for (final int h : hashToClauseMap.keySet()) {
            if (!integer) {
                sw.addCase(h, code);
            }
            final ArrayList<Object> dwes = hashToClauseMap.get(h);
            for (int i = 0; i < dwes.size(); i += 2) {
                final Object datum = dwes.get(i);
                final Expression exp = dwes.get(i + 1);
                if (!integer) {
                    if ((this.key.getType() == Type.intType || this.key.getType() == Type.longType) && datum instanceof IntNum) {
                        final IntNum idatum = (IntNum)datum;
                        this.key.compile(comp, this.key.getType());
                        if (idatum.inIntRange() && this.key.getType() == Type.intType) {
                            final int val = idatum.intValue();
                            code.emitPushInt(val);
                        }
                        else {
                            final StackTarget st = new StackTarget(Type.longType);
                            st.compileFromStack(comp, this.key.getType());
                            final long val2 = idatum.longValue();
                            code.emitPushLong(val2);
                        }
                        code.emitIfEq();
                    }
                    else if ((this.key.getType() == LangPrimType.charType || this.key.getType() == LangPrimType.characterType) && datum instanceof Char) {
                        this.key.compile(comp, Type.intType);
                        final int val3 = ((Char)datum).intValue();
                        code.emitPushInt(val3);
                        code.emitIfEq();
                    }
                    else {
                        this.key.compile(comp, Type.objectType);
                        comp.compileConstant(datum, Target.pushObject);
                        code.emitInvokeStatic(CaseExp.isEqvMethod);
                        code.emitIfIntNotZero();
                    }
                }
                final int pendingDatumCount = expToPendingDatumCounts.get(exp) - 1;
                Label expLabel = expToLabelMap.get(exp);
                if (pendingDatumCount == 0) {
                    if (integer) {
                        sw.addCase(h, code);
                    }
                    if (expLabel != null) {
                        expLabel.define(code);
                    }
                    exp.compile(comp, target);
                    sw.exitSwitch(code);
                }
                else {
                    expToPendingDatumCounts.put(exp, pendingDatumCount);
                    if (expLabel == null) {
                        expLabel = new Label(code);
                        expToLabelMap.put(exp, expLabel);
                    }
                    if (integer) {
                        sw.addCaseGoto(h, code, expLabel);
                    }
                    else {
                        code.emitGoto(expLabel);
                    }
                }
                if (!integer) {
                    code.emitFi();
                }
            }
            if (!integer) {
                code.emitGoto(defaultl);
            }
        }
        sw.addDefault(code);
        defaultl.define(code);
        if (this.elseClause != null) {
            this.elseClause.exp.compile(comp, target);
        }
        else {
            QuoteExp.voidExp.compile(comp, target);
        }
        sw.finish(code);
    }
    
    private void compileKey(final Compilation comp) {
        final CodeAttr code = comp.getCode();
        if (this.key.getType() == Type.intType || this.key.getType() == Type.shortType || this.key.getType() == Type.byteType || this.key.getType() == LangPrimType.charType || this.key.getType() == LangPrimType.characterType) {
            this.key.compile(comp, Type.intType);
        }
        else if (this.key.getType() == Type.longType) {
            this.key.compile(comp, Type.longType);
            this.key.compile(comp, Type.longType);
            code.emitPushInt(32);
            code.emitShr();
            code.emitXOr();
            final StackTarget st = new StackTarget(Type.intType);
            st.compileFromStack(comp, Type.longType);
        }
        else {
            this.key.compile(comp, Type.objectType);
            code.emitInvokeVirtual(CaseExp.hashCodeMethod);
        }
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitCaseExp(this, d);
    }
    
    @Override
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
        this.key = visitor.visitAndUpdate(this.key, d);
        for (int i = 0; visitor.exitValue == null && i < this.clauses.length; ++i) {
            final CaseClause clause = this.clauses[i];
            clause.exp = visitor.visitAndUpdate(clause.exp, d);
        }
        if (visitor.exitValue == null && this.elseClause != null) {
            this.elseClause.exp = visitor.visitAndUpdate(this.elseClause.exp, d);
        }
    }
    
    protected Object calculateDatumValue(final Expression datum) {
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
        CaseClause clause = (this.clauses.length > 0) ? this.clauses[0] : null;
        Type t;
        if (clause != null) {
            t = clause.exp.getType();
            for (int i = 1; i < this.clauses.length; ++i) {
                clause = this.clauses[i];
                t = Language.unionType(t, clause.exp.getType());
            }
            t = ((this.elseClause != null) ? Language.unionType(t, this.elseClause.exp.getType()) : Language.unionType(t, Type.voidType));
        }
        else {
            if (this.elseClause == null) {
                throw new Error("Syntax Error: Case without any clause, at least a default clause is required");
            }
            t = this.elseClause.exp.getType();
        }
        return t;
    }
    
    protected Type calculateDatumsType() {
        final boolean atLeastOne = this.clauses.length > 0;
        if (atLeastOne) {
            Type t = this.calculateDatumType(this.clauses[0].datums);
            for (int i = 1; i < this.clauses.length; ++i) {
                t = Language.unionType(t, this.calculateDatumType(this.clauses[i].datums));
            }
            return t;
        }
        if (this.elseClause != null) {
            return Type.voidType;
        }
        throw new Error();
    }
    
    private Type calculateDatumType(final Expression[] datum) {
        Type t = this.resolveType(this.calculateDatumValue(datum[0]));
        for (int i = 1; i < datum.length; ++i) {
            t = Language.unionType(t, this.resolveType(this.calculateDatumValue(datum[i])));
        }
        return t;
    }
    
    private Type resolveType(final Object o) {
        if (o instanceof IntNum) {
            final IntNum ii = (IntNum)o;
            if (ii.inIntRange()) {
                return Type.intType;
            }
            if (ii.inLongRange()) {
                return Type.longType;
            }
            return LangObjType.integerType;
        }
        else {
            if (o instanceof Char) {
                return LangPrimType.characterType;
            }
            if (o instanceof Character) {
                return LangPrimType.charType;
            }
            return Type.make(o.getClass());
        }
    }
    
    public boolean searchValue(final Object keyValue) {
        final Expression exp = this.selectCase(keyValue);
        final Expression elseExp = (this.elseClause != null) ? this.elseClause.exp : null;
        return exp != null && exp != elseExp;
    }
    
    public Expression selectCase(final Object keyValue) {
        for (int i = 0; i < this.clauses.length; ++i) {
            final Expression[] datums = this.clauses[i].datums;
            int pos = -1;
            for (int j = 0; j < datums.length; ++j) {
                if (IsEqv.apply(keyValue, this.calculateDatumValue(datums[j]))) {
                    pos = j;
                }
            }
            if (pos >= 0) {
                return this.clauses[i].exp;
            }
        }
        return (this.elseClause != null) ? this.elseClause.exp : null;
    }
    
    static {
        CaseExp.isEqvMethod = ClassType.make("gnu.kawa.functions.IsEqv").getDeclaredStaticMethod("apply", 2);
        CaseExp.hashCodeMethod = Type.objectType.getDeclaredMethod("hashCode", 0);
    }
    
    public static class CaseClause
    {
        Expression[] datums;
        Expression exp;
        
        public CaseClause(final Expression exp) {
            this.datums = null;
            this.exp = exp;
        }
        
        public CaseClause(final Expression[] datums, final Expression exp) {
            this.datums = datums;
            this.exp = exp;
        }
    }
}
