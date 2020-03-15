// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import gnu.bytecode.Type;
import gnu.kawa.xml.XDataType;
import gnu.mapping.Procedure;
import gnu.expr.Language;
import gnu.xquery.lang.XQuery;
import gnu.kawa.reflect.InstanceOf;

public class CastableAs extends InstanceOf
{
    public static CastableAs castableAs;
    
    CastableAs() {
        super(XQuery.getInstance(), "castable as");
        this.setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyCastableAs");
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        final Type type = this.language.asType(arg2);
        boolean result;
        if (type instanceof XDataType) {
            result = ((XDataType)type).castable(arg1);
        }
        else {
            result = type.isInstance(arg1);
        }
        return this.language.booleanObject(result);
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        ApplyExp.compile(exp, comp, target);
    }
    
    static {
        CastableAs.castableAs = new CastableAs();
    }
}
