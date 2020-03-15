// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.expr.GenericProc;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;

public class MakeProcedure extends ProcedureN
{
    public static final MakeProcedure makeProcedure;
    
    public MakeProcedure(final String name) {
        super(name);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyMakeProcedure");
    }
    
    public static GenericProc makeProcedure$V(final Object[] args) {
        return GenericProc.make(args);
    }
    
    @Override
    public Object applyN(final Object[] args) {
        return GenericProc.make(args);
    }
    
    static {
        makeProcedure = new MakeProcedure("make-procedure");
    }
}
