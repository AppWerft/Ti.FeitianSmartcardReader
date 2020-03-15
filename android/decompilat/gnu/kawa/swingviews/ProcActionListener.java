// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.swingviews;

import gnu.mapping.WrappedException;
import java.awt.event.ActionEvent;
import gnu.mapping.Procedure;
import java.awt.event.ActionListener;

class ProcActionListener implements ActionListener
{
    Procedure proc;
    
    public ProcActionListener(final Procedure proc) {
        this.proc = proc;
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        try {
            this.proc.apply1(e);
        }
        catch (Throwable ex) {
            WrappedException.rethrow(ex);
        }
    }
}
