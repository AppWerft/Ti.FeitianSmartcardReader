// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

public class ParameterizedType extends ObjectType
{
    ClassType rawType;
    Type[] typeArgumentTypes;
    char[] typeArgumentBounds;
    
    @Override
    public ClassType getRawType() {
        return this.rawType;
    }
    
    @Override
    public Class getReflectClass() {
        return this.rawType.getReflectClass();
    }
    
    public Type[] getTypeArgumentTypes() {
        return this.typeArgumentTypes;
    }
    
    public Type getTypeArgumentType(final int index) {
        return this.typeArgumentTypes[index];
    }
    
    public void setTypeArgumentBound(final int index, final char bound) {
        final int sz = (this.typeArgumentTypes == null || index >= this.typeArgumentTypes.length) ? (index + 1) : this.typeArgumentTypes.length;
        char[] bounds = this.typeArgumentBounds;
        if (bounds == null) {
            bounds = (this.typeArgumentBounds = new char[sz]);
        }
        else if (sz > bounds.length) {
            System.arraycopy(bounds, 0, this.typeArgumentBounds = new char[sz], 0, bounds.length);
            bounds = this.typeArgumentBounds;
        }
        bounds[index] = bound;
    }
    
    public char getTypeArgumentBound(final int index) {
        if (this.typeArgumentBounds == null || index >= this.typeArgumentBounds.length) {
            return '\0';
        }
        return this.typeArgumentBounds[index];
    }
    
    public void setTypeArgumentBounds(final char[] bounds) {
        this.typeArgumentBounds = bounds;
    }
    
    @Override
    public String getSignature() {
        return this.getRawType().getSignature();
    }
    
    @Override
    public String getGenericSignature() {
        String s = super.getGenericSignature();
        if (s == null) {
            final StringBuilder buf = new StringBuilder();
            buf.append('L');
            buf.append(this.rawType.getName().replace('.', '/'));
            buf.append('<');
            for (int n = this.typeArgumentTypes.length, i = 0; i < n; ++i) {
                final char bound = this.getTypeArgumentBound(i);
                final Type tt = this.getTypeArgumentType(i);
                if (bound == '+' && tt == Type.objectType) {
                    buf.append('*');
                }
                else {
                    if (bound != '\0') {
                        buf.append(bound);
                    }
                    buf.append(tt.getMaybeGenericSignature());
                }
            }
            buf.append(">;");
            s = buf.toString();
            super.setGenericSignature(s);
        }
        return s;
    }
    
    @Override
    public void emitCoerceFromObject(final CodeAttr code) {
        this.getRawType().emitCoerceFromObject(code);
    }
    
    @Override
    public String getName() {
        return this.toString();
    }
    
    @Override
    public String toString() {
        final StringBuilder buf = new StringBuilder();
        buf.append(this.rawType);
        buf.append('<');
        for (int n = this.typeArgumentTypes.length, i = 0; i < n; ++i) {
            if (i > 0) {
                buf.append(',');
            }
            final char bound = this.getTypeArgumentBound(i);
            if (bound == '+') {
                buf.append("? extends ");
            }
            if (bound == '-') {
                buf.append("? super ");
            }
            buf.append(this.getTypeArgumentType(i));
        }
        buf.append('>');
        return buf.toString();
    }
    
    @Override
    public int compare(final Type other) {
        return this.rawType.compare(other);
    }
    
    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ParameterizedType)) {
            return false;
        }
        final ParameterizedType pother = (ParameterizedType)other;
        if (!Type.isSame(this.rawType, pother.rawType)) {
            return false;
        }
        int n = this.typeArgumentTypes.length;
        final Type[] otherArgumentTypes = pother.typeArgumentTypes;
        if (n != otherArgumentTypes.length) {
            return false;
        }
        while (--n >= 0) {
            if (!Type.isSame(this.typeArgumentTypes[n], pother.typeArgumentTypes[n]) || this.getTypeArgumentBound(n) != pother.getTypeArgumentBound(n)) {
                return false;
            }
        }
        return true;
    }
    
    public ParameterizedType(final ClassType rawType, final Type... typeArgumentTypes) {
        this.rawType = rawType;
        this.typeArgumentTypes = typeArgumentTypes;
    }
}
