// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

public class VoidConsumer extends FilterConsumer
{
    public static VoidConsumer instance;
    
    public static VoidConsumer getInstance() {
        return VoidConsumer.instance;
    }
    
    public VoidConsumer() {
        super(null);
        this.skipping = true;
    }
    
    public VoidConsumer(final Consumer out) {
        super(out);
        this.skipping = true;
    }
    
    public static VoidConsumer make(final Consumer old) {
        return new VoidConsumer(old);
    }
    
    @Override
    public boolean ignoring() {
        return true;
    }
    
    static {
        VoidConsumer.instance = new VoidConsumer();
    }
}
