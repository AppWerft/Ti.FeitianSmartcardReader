/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.ClassType;
import gnu.bytecode.Label;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;

public class UninitializedType
extends ObjectType {
    ClassType ctype;
    Label label;

    UninitializedType(ClassType ctype) {
        super(ctype.getName());
        this.setSignature(ctype.getSignature());
        this.ctype = ctype;
    }

    UninitializedType(ClassType ctype, Label label) {
        this(ctype);
        this.label = label;
    }

    static UninitializedType uninitializedThis(ClassType ctype) {
        return new UninitializedType(ctype);
    }

    @Override
    public Type getImplementationType() {
        return this.ctype;
    }

    @Override
    public String toString() {
        return "Uninitialized<" + this.ctype.getName() + '>';
    }
}

