// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.lang.reflect.ParameterizedType;

public class TypeVariable extends ObjectType
{
    ClassType rawType;
    java.lang.reflect.TypeVariable rtype;
    
    public TypeVariable(final String name) {
        super(name);
    }
    
    public static TypeVariable make(final java.lang.reflect.TypeVariable rtype) {
        final TypeVariable tvar = new TypeVariable(rtype.getName());
        tvar.rawType = Type.objectType;
        final java.lang.reflect.Type[] bounds = rtype.getBounds();
        Type bound = null;
        if (bounds.length == 1) {
            final java.lang.reflect.Type bound2 = bounds[0];
            if (bound2 instanceof Class) {
                bound = Type.make(bound2);
            }
            else if (bound2 instanceof ParameterizedType) {
                bound = Type.make(((ParameterizedType)bound2).getRawType());
            }
        }
        if (bound != null) {
            bound = bound.getRawType();
        }
        if (bound instanceof ClassType) {
            tvar.rawType = (ClassType)bound;
        }
        tvar.rtype = rtype;
        return tvar;
    }
    
    @Override
    public int compare(final Type other) {
        return this.rawType.compare(other);
    }
    
    @Override
    public ClassType getRawType() {
        return this.rawType;
    }
    
    @Override
    public void emitCoerceFromObject(final CodeAttr code) {
        this.rawType.emitCoerceFromObject(code);
    }
    
    @Override
    public String getSignature() {
        return this.getRawType().getSignature();
    }
    
    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof TypeVariable)) {
            return false;
        }
        final TypeVariable tvother = (TypeVariable)other;
        return Type.isSame(this.rawType, tvother.rawType) && this.getName().equals(tvother.getName());
    }
}
