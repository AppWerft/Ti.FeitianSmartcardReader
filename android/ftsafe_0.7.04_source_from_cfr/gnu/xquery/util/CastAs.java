/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.util;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Target;
import gnu.kawa.functions.Convert;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.xml.XDataType;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import java.util.ArrayList;

public class CastAs
extends Convert {
    public static final CastAs castAs = new CastAs();

    public CastAs() {
        super("cast-as", false);
        this.setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyCastAs");
    }

    @Override
    public Object apply2(Object arg1, Object arg2) {
        Type base2;
        OccurrenceType occ;
        Type type = (Type)arg1;
        if (type instanceof XDataType) {
            return ((XDataType)type).cast(arg2);
        }
        if (type instanceof OccurrenceType && (base2 = (occ = (OccurrenceType)type).getBase()) instanceof XDataType) {
            int min = occ.minOccurs();
            int max = occ.maxOccurs();
            if (arg2 instanceof Values) {
                if (arg2 == Values.empty && min == 0) {
                    return arg2;
                }
                Values vals = (Values)arg2;
                int pos = vals.startPos();
                int n = 0;
                ArrayList<Object> lst = new ArrayList<Object>();
                while ((pos = vals.nextPos(pos)) != 0) {
                    Object value = vals.getPosPrevious(pos);
                    value = ((XDataType)base2).cast(value);
                    lst.add(value);
                    ++n;
                }
                if (n >= min && (max < 0 || n <= max)) {
                    return Values.make(lst);
                }
            } else if (min <= 1 && max != 0) {
                return ((XDataType)base2).cast(arg2);
            }
            throw new ClassCastException("cannot cast " + arg2 + " to " + arg1);
        }
        return super.apply2(arg1, arg2);
    }

    public void compile(ApplyExp exp, Compilation comp, Target target) {
        ApplyExp.compile(exp, comp, target);
    }
}

