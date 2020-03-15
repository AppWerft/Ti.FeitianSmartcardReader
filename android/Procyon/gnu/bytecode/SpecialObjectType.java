// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.util.List;

public class SpecialObjectType extends ObjectType
{
    protected ClassType implementationType;
    
    public SpecialObjectType(final String name, final ClassType implementationType) {
        super(name);
        this.implementationType = implementationType;
        this.setSignature(implementationType.getSignature());
    }
    
    @Override
    public Field getField(final String name, final int mask) {
        return this.implementationType.getField(name, mask);
    }
    
    @Override
    public Method getMethod(final String name, final Type[] arg_types) {
        return this.implementationType.getMethod(name, arg_types);
    }
    
    public Method getDeclaredMethod(final String name, final int argCount) {
        return this.implementationType.getDeclaredMethod(name, argCount);
    }
    
    @Override
    public int getMethods(final Filter filter, final int searchSupers, final List<Method> result) {
        return this.implementationType.getMethods(filter, searchSupers, result);
    }
    
    @Override
    public Class getReflectClass() {
        return this.implementationType.getReflectClass();
    }
    
    @Override
    public Type getRealType() {
        return this.implementationType;
    }
    
    @Override
    public Type getImplementationType() {
        return this.implementationType;
    }
    
    @Override
    public int compare(final Type other) {
        if (this == SpecialObjectType.toStringType) {
            return (other == this || other == Type.javalangStringType) ? 0 : ((other == Type.javalangObjectType) ? -1 : 1);
        }
        return super.compare(other);
    }
}
