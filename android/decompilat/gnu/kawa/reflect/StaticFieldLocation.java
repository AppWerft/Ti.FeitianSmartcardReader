// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.reflect;

import gnu.expr.Declaration;
import gnu.mapping.Location;
import gnu.mapping.Symbol;
import gnu.mapping.Environment;
import kawa.lang.Macro;
import java.lang.reflect.Field;
import gnu.bytecode.ClassType;

public class StaticFieldLocation extends FieldLocation
{
    public StaticFieldLocation(final String cname, final String fname) {
        super(null, cname, fname);
    }
    
    public StaticFieldLocation(final ClassType type, final String mname) {
        super(null, type, mname);
    }
    
    public StaticFieldLocation(final Field field) {
        super(null, field);
    }
    
    @Override
    public Object get(final Object defaultValue) {
        final Object val = super.get(defaultValue);
        if (val instanceof Macro) {
            this.getDeclaration();
        }
        return val;
    }
    
    public static StaticFieldLocation define(final Environment environ, final Symbol sym, final Object property, final String cname, final String fname) {
        final StaticFieldLocation loc = new StaticFieldLocation(cname, fname);
        environ.addLocation(sym, property, loc);
        return loc;
    }
    
    public static StaticFieldLocation make(final Declaration decl) {
        final gnu.bytecode.Field fld = decl.field;
        final ClassType ctype = fld.getDeclaringClass();
        final StaticFieldLocation loc = new StaticFieldLocation(ctype, fld.getName());
        loc.setDeclaration(decl);
        return loc;
    }
    
    public static StaticFieldLocation make(final String cname, final String fldName) {
        return new StaticFieldLocation(cname, fldName);
    }
}
