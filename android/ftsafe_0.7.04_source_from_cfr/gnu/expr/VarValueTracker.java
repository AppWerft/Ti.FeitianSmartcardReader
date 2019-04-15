/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.math.BitOps;
import gnu.math.IntNum;
import gnu.text.SourceLocator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class VarValueTracker {
    InlineCalls visitor;
    HashMap<Declaration, IntNum> declValueUsage;
    HashMap<Declaration, IntNum[]> forkValues;
    int forkBranchNumber;
    VarValueTracker outer;
    Set<LambdaExp> lambdasCheckedForUninitializedVariables;

    public VarValueTracker(InlineCalls visitor) {
        this.visitor = visitor;
        this.declValueUsage = new HashMap();
    }

    public VarValueTracker(VarValueTracker outer) {
        this.outer = outer;
        this.declValueUsage = outer.declValueUsage;
    }

    public static void forkPush(InlineCalls visitor) {
        VarValueTracker newTracker;
        VarValueTracker oldTracker = visitor.valueTracker;
        visitor.valueTracker = newTracker = new VarValueTracker(oldTracker);
        newTracker.forkValues = new HashMap();
    }

    public void forkNext() {
        ++this.forkBranchNumber;
        for (Map.Entry<Declaration, IntNum[]> entry : this.forkValues.entrySet()) {
            Declaration decl = entry.getKey();
            IntNum[] vals = entry.getValue();
            IntNum cur = this.declValueUsage.get(decl);
            vals[1] = VarValueTracker.sourceUnion(vals[1], cur);
            this.declValueUsage.put(decl, vals[0]);
        }
        this.lambdasCheckedForUninitializedVariables = null;
    }

    public static void forkPop(InlineCalls visitor) {
        VarValueTracker innerTracker = visitor.valueTracker;
        VarValueTracker outerTracker = innerTracker.outer;
        HashMap<Declaration, IntNum> declValueUsage = innerTracker.declValueUsage;
        visitor.valueTracker = outerTracker;
        for (Map.Entry<Declaration, IntNum[]> entry : innerTracker.forkValues.entrySet()) {
            Declaration decl = entry.getKey();
            IntNum[] vals = entry.getValue();
            IntNum newSource = VarValueTracker.sourceUnion(vals[1], declValueUsage.get(decl));
            outerTracker.noteSet(decl, newSource);
        }
    }

    static IntNum sourceAsMask(IntNum val) {
        if (val.isNegative()) {
            int index = ~val.intValue();
            val = IntNum.shift(IntNum.one(), index + 1);
        }
        return val;
    }

    static IntNum sourceUnion(IntNum set1, IntNum set2) {
        if (set1 == set2) {
            return set1;
        }
        if (set2.isZero()) {
            return set1;
        }
        if (set1.isZero()) {
            return set2;
        }
        return BitOps.ior(VarValueTracker.sourceAsMask(set1), VarValueTracker.sourceAsMask(set2));
    }

    static boolean maybeUninitialized(IntNum set) {
        return !set.isNegative() && set.isOdd();
    }

    public void noteUnitialized(Declaration decl) {
        if (decl.values != Declaration.unknownValueValues) {
            this.declValueUsage.put(decl, IntNum.one());
        }
    }

    public void noteUnitialized(ScopeExp scope) {
        for (Declaration decl = scope.firstDecl(); decl != null; decl = decl.nextDecl()) {
            this.noteUnitialized(decl);
        }
    }

    public void noteSet(Declaration decl, IntNum source) {
        IntNum[] vals;
        IntNum curSource = this.declValueUsage.get(decl);
        if (this.forkValues != null && curSource != null && (vals = this.forkValues.get(decl)) == null) {
            vals = new IntNum[]{curSource, this.forkBranchNumber == 0 ? IntNum.zero() : curSource};
            this.forkValues.put(decl, vals);
        }
        this.declValueUsage.put(decl, source);
    }

    void checkUninitializedVariables(LambdaExp lexp, ReferenceExp referrer, Stack<ReferenceExp> callers) {
        if (this.lambdasCheckedForUninitializedVariables == null) {
            this.lambdasCheckedForUninitializedVariables = new HashSet<LambdaExp>();
        } else if (this.lambdasCheckedForUninitializedVariables.contains(lexp)) {
            return;
        }
        this.lambdasCheckedForUninitializedVariables.add(lexp);
        if (callers == null) {
            callers = new Stack();
        }
        callers.push(referrer);
        ReferenceExp rexp = lexp.siblingReferences;
        while (rexp != null) {
            Declaration decl = rexp.getBinding();
            LambdaExp lvalue = decl.getLambdaValue();
            if (lvalue != null) {
                this.checkUninitializedVariables(lvalue, rexp, callers);
            } else {
                IntNum vals = this.declValueUsage.get(decl);
                if (vals != null && VarValueTracker.maybeUninitialized(vals) && !decl.getFlag(0x4000000000L)) {
                    Compilation comp = this.visitor.getCompilation();
                    comp.error('w', "variable '" + rexp.getName() + "' may be uninitialized here", rexp);
                    if (callers != null) {
                        int i = callers.size();
                        while (--i >= 0) {
                            comp.error('w', "- because of possible call here of function " + ((ReferenceExp)callers.get(i)).getName(), (SourceLocator)callers.get(i));
                        }
                    }
                    decl.setFlag(0x4000000000L);
                }
            }
            rexp = rexp.siblingReferencesNext;
        }
        callers.pop();
    }
}

