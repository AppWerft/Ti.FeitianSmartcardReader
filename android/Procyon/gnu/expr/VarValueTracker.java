// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.text.SourceLocator;
import java.util.HashSet;
import java.util.Stack;
import gnu.math.BitOps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import gnu.math.IntNum;
import java.util.HashMap;

public class VarValueTracker
{
    InlineCalls visitor;
    HashMap<Declaration, IntNum> declValueUsage;
    HashMap<Declaration, IntNum[]> forkValues;
    int forkBranchNumber;
    VarValueTracker outer;
    Set<LambdaExp> lambdasCheckedForUninitializedVariables;
    
    public VarValueTracker(final InlineCalls visitor) {
        this.visitor = visitor;
        this.declValueUsage = new HashMap<Declaration, IntNum>();
    }
    
    public VarValueTracker(final VarValueTracker outer) {
        this.outer = outer;
        this.declValueUsage = outer.declValueUsage;
    }
    
    public static void forkPush(final InlineCalls visitor) {
        final VarValueTracker oldTracker = visitor.valueTracker;
        final VarValueTracker newTracker = new VarValueTracker(oldTracker);
        visitor.valueTracker = newTracker;
        newTracker.forkValues = new HashMap<Declaration, IntNum[]>();
    }
    
    public void forkNext() {
        ++this.forkBranchNumber;
        for (final Map.Entry<Declaration, IntNum[]> entry : this.forkValues.entrySet()) {
            final Declaration decl = entry.getKey();
            final IntNum[] vals = entry.getValue();
            final IntNum cur = this.declValueUsage.get(decl);
            vals[1] = sourceUnion(vals[1], cur);
            this.declValueUsage.put(decl, vals[0]);
        }
        this.lambdasCheckedForUninitializedVariables = null;
    }
    
    public static void forkPop(final InlineCalls visitor) {
        final VarValueTracker innerTracker = visitor.valueTracker;
        final VarValueTracker outerTracker = innerTracker.outer;
        final HashMap<Declaration, IntNum> declValueUsage = innerTracker.declValueUsage;
        visitor.valueTracker = outerTracker;
        for (final Map.Entry<Declaration, IntNum[]> entry : innerTracker.forkValues.entrySet()) {
            final Declaration decl = entry.getKey();
            final IntNum[] vals = entry.getValue();
            final IntNum newSource = sourceUnion(vals[1], declValueUsage.get(decl));
            outerTracker.noteSet(decl, newSource);
        }
    }
    
    static IntNum sourceAsMask(IntNum val) {
        if (val.isNegative()) {
            final int index = ~val.intValue();
            val = IntNum.shift(IntNum.one(), index + 1);
        }
        return val;
    }
    
    static IntNum sourceUnion(final IntNum set1, final IntNum set2) {
        if (set1 == set2) {
            return set1;
        }
        if (set2.isZero()) {
            return set1;
        }
        if (set1.isZero()) {
            return set2;
        }
        return BitOps.ior(sourceAsMask(set1), sourceAsMask(set2));
    }
    
    static boolean maybeUninitialized(final IntNum set) {
        return !set.isNegative() && set.isOdd();
    }
    
    public void noteUnitialized(final Declaration decl) {
        if (decl.values != Declaration.unknownValueValues) {
            this.declValueUsage.put(decl, IntNum.one());
        }
    }
    
    public void noteUnitialized(final ScopeExp scope) {
        for (Declaration decl = scope.firstDecl(); decl != null; decl = decl.nextDecl()) {
            this.noteUnitialized(decl);
        }
    }
    
    public void noteSet(final Declaration decl, final IntNum source) {
        final IntNum curSource = this.declValueUsage.get(decl);
        if (this.forkValues != null && curSource != null) {
            IntNum[] vals = this.forkValues.get(decl);
            if (vals == null) {
                vals = new IntNum[] { curSource, (this.forkBranchNumber == 0) ? IntNum.zero() : curSource };
                this.forkValues.put(decl, vals);
            }
        }
        this.declValueUsage.put(decl, source);
    }
    
    void checkUninitializedVariables(final LambdaExp lexp, final ReferenceExp referrer, Stack<ReferenceExp> callers) {
        if (this.lambdasCheckedForUninitializedVariables == null) {
            this.lambdasCheckedForUninitializedVariables = new HashSet<LambdaExp>();
        }
        else if (this.lambdasCheckedForUninitializedVariables.contains(lexp)) {
            return;
        }
        this.lambdasCheckedForUninitializedVariables.add(lexp);
        if (callers == null) {
            callers = new Stack<ReferenceExp>();
        }
        callers.push(referrer);
        for (ReferenceExp rexp = lexp.siblingReferences; rexp != null; rexp = rexp.siblingReferencesNext) {
            final Declaration decl = rexp.getBinding();
            final LambdaExp lvalue = decl.getLambdaValue();
            if (lvalue != null) {
                this.checkUninitializedVariables(lvalue, rexp, callers);
            }
            else {
                final IntNum vals = this.declValueUsage.get(decl);
                if (vals != null && maybeUninitialized(vals) && !decl.getFlag(274877906944L)) {
                    final Compilation comp = this.visitor.getCompilation();
                    comp.error('w', "variable '" + rexp.getName() + "' may be uninitialized here", rexp);
                    if (callers != null) {
                        int i = callers.size();
                        while (--i >= 0) {
                            comp.error('w', "- because of possible call here of function " + callers.get(i).getName(), callers.get(i));
                        }
                    }
                    decl.setFlag(274877906944L);
                }
            }
        }
        callers.pop();
    }
}
