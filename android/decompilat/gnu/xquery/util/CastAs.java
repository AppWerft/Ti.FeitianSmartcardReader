// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.util;

import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import java.util.List;
import java.util.ArrayList;
import gnu.mapping.Values;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.xml.XDataType;
import gnu.bytecode.Type;
import gnu.mapping.Procedure;
import gnu.kawa.functions.Convert;

public class CastAs extends Convert
{
    public static final CastAs castAs;
    
    public CastAs() {
        super("cast-as", false);
        this.setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyCastAs");
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        final Type type = (Type)arg1;
        if (type instanceof XDataType) {
            return ((XDataType)type).cast(arg2);
        }
        if (type instanceof OccurrenceType) {
            final OccurrenceType occ = (OccurrenceType)type;
            final Type base = occ.getBase();
            if (base instanceof XDataType) {
                final int min = occ.minOccurs();
                final int max = occ.maxOccurs();
                if (arg2 instanceof Values) {
                    if (arg2 == Values.empty && min == 0) {
                        return arg2;
                    }
                    final Values vals = (Values)arg2;
                    int pos = vals.startPos();
                    int n = 0;
                    final List lst = new ArrayList();
                    while ((pos = vals.nextPos(pos)) != 0) {
                        Object value = vals.getPosPrevious(pos);
                        value = ((XDataType)base).cast(value);
                        lst.add(value);
                        ++n;
                    }
                    if (n >= min && (max < 0 || n <= max)) {
                        return Values.make((List<Object>)lst);
                    }
                }
                else if (min <= 1 && max != 0) {
                    return ((XDataType)base).cast(arg2);
                }
                throw new ClassCastException("cannot cast " + arg2 + " to " + arg1);
            }
        }
        return super.apply2(arg1, arg2);
    }
    
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        ApplyExp.compile(exp, comp, target);
    }
    
    static {
        castAs = new CastAs();
    }
}
