// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

public class Location
{
    protected String name;
    private Type type;
    int name_index;
    int signature_index;
    
    public final String getName() {
        return this.name;
    }
    
    public final void setName(final String name) {
        this.name = name;
    }
    
    public final void setName(final int name_index, final ConstantPool constants) {
        if (name_index <= 0) {
            this.name = null;
        }
        else {
            final CpoolUtf8 nameConstant = (CpoolUtf8)constants.getForced(name_index, 1);
            this.name = nameConstant.string;
        }
        this.name_index = name_index;
    }
    
    public Type getType() {
        return this.type;
    }
    
    public final void setType(final Type type) {
        this.type = type;
    }
    
    public final String getSignature() {
        return this.getType().getRawType().getSignature();
    }
    
    public void setSignature(final int signature_index, final ConstantPool constants) {
        final CpoolUtf8 sigConstant = (CpoolUtf8)constants.getForced(signature_index, 1);
        this.signature_index = signature_index;
        this.type = Type.signatureToType(sigConstant.string);
    }
}
