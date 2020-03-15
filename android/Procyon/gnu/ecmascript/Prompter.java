// 
// Decompiled by Procyon v0.5.36
// 

package gnu.ecmascript;

import gnu.kawa.io.InPort;
import gnu.mapping.Procedure1;

class Prompter extends Procedure1
{
    String prompt(final InPort port) {
        return "(EcmaScript:" + (port.getLineNumber() + 1) + ") ";
    }
    
    @Override
    public Object apply1(final Object arg) {
        return this.prompt((InPort)arg);
    }
}
