/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.swingviews;

import gnu.mapping.Procedure;
import gnu.mapping.WrappedException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ProcActionListener
implements ActionListener {
    Procedure proc;

    public ProcActionListener(Procedure proc) {
        this.proc = proc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.proc.apply1(e);
        }
        catch (Throwable ex) {
            WrappedException.rethrow(ex);
        }
    }
}

