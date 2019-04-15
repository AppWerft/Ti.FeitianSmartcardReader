/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;

public class ParameterizedType
extends ObjectType {
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

    public Type getTypeArgumentType(int index) {
        return this.typeArgumentTypes[index];
    }

    public void setTypeArgumentBound(int index, char bound) {
        int sz = this.typeArgumentTypes == null || index >= this.typeArgumentTypes.length ? index + 1 : this.typeArgumentTypes.length;
        char[] bounds = this.typeArgumentBounds;
        if (bounds == null) {
            this.typeArgumentBounds = bounds = new char[sz];
        } else if (sz > bounds.length) {
            this.typeArgumentBounds = new char[sz];
            System.arraycopy(bounds, 0, this.typeArgumentBounds, 0, bounds.length);
            bounds = this.typeArgumentBounds;
        }
        bounds[index] = bound;
    }

    public char getTypeArgumentBound(int index) {
        if (this.typeArgumentBounds == null || index >= this.typeArgumentBounds.length) {
            return '\u0000';
        }
        return this.typeArgumentBounds[index];
    }

    public void setTypeArgumentBounds(char[] bounds) {
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
            StringBuilder buf = new StringBuilder();
            buf.append('L');
            buf.append(this.rawType.getName().replace('.', '/'));
            buf.append('<');
            int n = this.typeArgumentTypes.length;
            for (int i = 0; i < n; ++i) {
                char bound = this.getTypeArgumentBound(i);
                Type tt = this.getTypeArgumentType(i);
                if (bound == '+' && tt == Type.objectType) {
                    buf.append('*');
                    continue;
                }
                if (bound != '\u0000') {
                    buf.append(bound);
                }
                buf.append(tt.getMaybeGenericSignature());
            }
            buf.append(">;");
            s = buf.toString();
            super.setGenericSignature(s);
        }
        return s;
    }

    @Override
    public void emitCoerceFromObject(CodeAttr code) {
        this.getRawType().emitCoerceFromObject(code);
    }

    @Override
    public String getName() {
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(this.rawType);
        buf.append('<');
        int n = this.typeArgumentTypes.length;
        for (int i = 0; i < n; ++i) {
            char bound;
            if (i > 0) {
                buf.append(',');
            }
            if ((bound = this.getTypeArgumentBound(i)) == '+') {
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
    public int compare(Type other) {
        return this.rawType.compare(other);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType pother = (ParameterizedType)other;
        if (!Type.isSame(this.rawType, pother.rawType)) {
            return false;
        }
        int n = this.typeArgumentTypes.length;
        Type[] otherArgumentTypes = pother.typeArgumentTypes;
        if (n != otherArgumentTypes.length) {
            return false;
        }
        while (--n >= 0) {
            if (Type.isSame(this.typeArgumentTypes[n], pother.typeArgumentTypes[n]) && this.getTypeArgumentBound(n) == pother.getTypeArgumentBound(n)) continue;
            return false;
        }
        return true;
    }

    public /* varargs */ ParameterizedType(ClassType rawType, Type ... typeArgumentTypes) {
        this.rawType = rawType;
        this.typeArgumentTypes = typeArgumentTypes;
    }
}

