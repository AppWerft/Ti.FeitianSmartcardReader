// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.util.NoSuchElementException;
import java.util.Enumeration;

public class Variable extends Location implements Enumeration
{
    Variable next;
    private int flags;
    private static final int SIMPLE_FLAG = 1;
    private static final int PARAMETER_FLAG = 2;
    private static final int LIVE_FLAG = 4;
    static final int UNASSIGNED = -1;
    int offset;
    private Scope scope;
    
    public final Variable nextVar() {
        return this.next;
    }
    
    @Override
    public final boolean hasMoreElements() {
        return this.next != null;
    }
    
    @Override
    public Object nextElement() {
        if (this.next == null) {
            throw new NoSuchElementException("Variable enumeration");
        }
        return this.next;
    }
    
    public Variable() {
        this.flags = 1;
        this.offset = -1;
    }
    
    public Variable(final String name) {
        this.flags = 1;
        this.offset = -1;
        this.setName(name);
    }
    
    public Variable(final String name, final Type type) {
        this.flags = 1;
        this.offset = -1;
        this.setName(name);
        this.setType(type);
    }
    
    public final boolean isAssigned() {
        return this.offset != -1;
    }
    
    public Scope getScope() {
        return this.scope;
    }
    
    void setScope(final Scope scope) {
        this.scope = scope;
    }
    
    public final boolean dead() {
        return (this.flags & 0x4) == 0x0;
    }
    
    private void setFlag(final boolean setting, final int flag) {
        if (setting) {
            this.flags |= flag;
        }
        else {
            this.flags &= ~flag;
        }
    }
    
    public final boolean isSimple() {
        return (this.flags & 0x1) != 0x0;
    }
    
    public final void setSimple(final boolean simple) {
        this.setFlag(simple, 1);
    }
    
    public final boolean isParameter() {
        return (this.flags & 0x2) != 0x0;
    }
    
    public final void setParameter(final boolean parameter) {
        this.setFlag(parameter, 2);
    }
    
    public boolean reserveLocal(final int varIndex, final CodeAttr code) {
        final int size = this.getType().getSizeInWords();
        if (code.locals.used == null) {
            code.locals.used = new Variable[20 + size];
        }
        else if (code.getMaxLocals() + size >= code.locals.used.length) {
            final Variable[] new_locals = new Variable[2 * code.locals.used.length + size];
            System.arraycopy(code.locals.used, 0, new_locals, 0, code.getMaxLocals());
            code.locals.used = new_locals;
        }
        for (int j = 0; j < size; ++j) {
            if (code.locals.used[varIndex + j] != null) {
                return false;
            }
        }
        for (int j = 0; j < size; ++j) {
            code.locals.used[varIndex + j] = this;
        }
        if (varIndex + size > code.getMaxLocals()) {
            code.setMaxLocals(varIndex + size);
        }
        this.offset = varIndex;
        this.flags |= 0x4;
        if (this.offset == 0 && "<init>".equals(code.getMethod().getName())) {
            this.setType(code.local_types[0]);
        }
        return true;
    }
    
    public void allocateLocal(final CodeAttr code) {
        if (this.offset != -1) {
            return;
        }
        for (int i = 0; !this.reserveLocal(i, code); ++i) {}
    }
    
    public void freeLocal(final CodeAttr code) {
        this.flags &= 0xFFFFFFFB;
        final int size = (this.getType().size > 4) ? 2 : 1;
        int vnum = this.offset + size;
        while (--vnum >= this.offset) {
            code.locals.used[vnum] = null;
            final Type[] local_types = code.local_types;
            if (local_types != null && vnum < local_types.length) {
                local_types[vnum] = null;
            }
        }
    }
    
    boolean shouldEmit() {
        final Scope sc = this.scope;
        final Label start;
        final int pos;
        final Label end;
        return this.isSimple() && this.name != null && sc != null && (start = sc.start) != null && (pos = start.position) >= 0 && (end = sc.end) != null && end.position > pos;
    }
    
    @Override
    public String toString() {
        return "Variable[" + this.getName() + " offset:" + this.offset + ']';
    }
}
