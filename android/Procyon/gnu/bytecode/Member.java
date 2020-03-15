// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

public interface Member
{
    ClassType getDeclaringClass();
    
    String getName();
    
    void setName(final String p0);
    
    int getModifiers();
    
    boolean getStaticFlag();
}
