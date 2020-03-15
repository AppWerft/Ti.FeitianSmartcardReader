// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.Type;
import gnu.bytecode.ClassType;

public class PairClassType extends ClassType
{
    Object staticLink;
    public ClassType instanceType;
    
    public PairClassType() {
    }
    
    PairClassType(final Class reflectInterface, final Class reflectInstanceClass) {
        super(reflectInterface.getName());
        this.setExisting(true);
        Type.registerTypeForClass(this.reflectClass = reflectInterface, this);
        this.instanceType = (ClassType)Type.make(reflectInstanceClass);
    }
    
    public static PairClassType make(final Class reflectInterface, final Class reflectInstanceClass) {
        return new PairClassType(reflectInterface, reflectInstanceClass);
    }
    
    public static PairClassType make(final Class reflectInterface, final Class reflectInstanceClass, final Object staticLink) {
        final PairClassType type = new PairClassType(reflectInterface, reflectInstanceClass);
        type.staticLink = staticLink;
        return type;
    }
    
    public Object getStaticLink() {
        return this.staticLink;
    }
    
    public static Object extractStaticLink(final ClassType type) {
        return ((PairClassType)type).staticLink;
    }
}
