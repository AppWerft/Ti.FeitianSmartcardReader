// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

public interface AttrContainer
{
    Attribute getAttributes();
    
    void setAttributes(final Attribute p0);
    
    ConstantPool getConstants();
}
