// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.io.InPort;
import gnu.mapping.Procedure1;

class SimplePrompter extends Procedure1
{
    public String prefix;
    public String suffix;
    
    SimplePrompter() {
        this.prefix = "[";
        this.suffix = "] ";
    }
    
    @Override
    public Object apply1(final Object arg) {
        if (arg instanceof InPort) {
            final InPort port = (InPort)arg;
            final int line = port.getLineNumber() + 1;
            if (line >= 0) {
                return this.prefix + line + this.suffix;
            }
        }
        return this.suffix;
    }
}
