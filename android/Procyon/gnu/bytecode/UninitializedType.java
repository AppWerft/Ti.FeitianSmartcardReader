// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

public class UninitializedType extends ObjectType
{
    ClassType ctype;
    Label label;
    
    UninitializedType(final ClassType ctype) {
        super(ctype.getName());
        this.setSignature(ctype.getSignature());
        this.ctype = ctype;
    }
    
    UninitializedType(final ClassType ctype, final Label label) {
        this(ctype);
        this.label = label;
    }
    
    static UninitializedType uninitializedThis(final ClassType ctype) {
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
