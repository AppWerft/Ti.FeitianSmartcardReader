// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import gnu.lists.SeqPosition;
import gnu.lists.AbstractSequence;
import gnu.mapping.Values;
import gnu.mapping.Procedure2;

public class NodeCompare extends Procedure2
{
    static final int RESULT_GRT = 1;
    static final int RESULT_EQU = 0;
    static final int RESULT_LSS = -1;
    static final int TRUE_IF_GRT = 16;
    static final int TRUE_IF_EQU = 8;
    static final int TRUE_IF_LSS = 4;
    int flags;
    public static final NodeCompare $Eq;
    public static final NodeCompare $Ne;
    public static final NodeCompare $Gr;
    public static final NodeCompare $Ls;
    
    public static NodeCompare make(final String name, final int flags) {
        final NodeCompare proc = new NodeCompare();
        proc.setName(name);
        proc.flags = flags;
        return proc;
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        if (arg1 == null || arg2 == null) {
            return null;
        }
        if (arg1 == Values.empty) {
            return arg1;
        }
        if (arg2 == Values.empty) {
            return arg2;
        }
        AbstractSequence seq1;
        int ipos1;
        if (arg1 instanceof AbstractSequence) {
            seq1 = (AbstractSequence)arg1;
            ipos1 = seq1.startPos();
        }
        else {
            try {
                final SeqPosition spos = (SeqPosition)arg1;
                seq1 = spos.sequence;
                ipos1 = spos.getPos();
            }
            catch (ClassCastException ex) {
                throw WrongType.make(ex, this, 1, arg1);
            }
        }
        AbstractSequence seq2;
        int ipos2;
        if (arg2 instanceof AbstractSequence) {
            seq2 = (AbstractSequence)arg2;
            ipos2 = seq2.startPos();
        }
        else {
            try {
                final SeqPosition spos = (SeqPosition)arg2;
                seq2 = spos.sequence;
                ipos2 = spos.getPos();
            }
            catch (ClassCastException ex) {
                throw WrongType.make(ex, this, 2, arg2);
            }
        }
        int comp;
        if (seq1 == seq2) {
            comp = seq1.compare(ipos1, ipos2);
        }
        else {
            if (this == NodeCompare.$Eq) {
                return Boolean.FALSE;
            }
            if (this == NodeCompare.$Ne) {
                return Boolean.TRUE;
            }
            comp = seq1.stableCompare(seq2);
        }
        if ((1 << 3 + comp & this.flags) != 0x0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    
    static {
        $Eq = make("is", 8);
        $Ne = make("isnot", 20);
        $Gr = make(">>", 16);
        $Ls = make("<<", 4);
    }
}
