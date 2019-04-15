/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.LocalVarsAttr;
import gnu.bytecode.Location;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class Variable
extends Location
implements Enumeration {
    Variable next;
    private int flags = 1;
    private static final int SIMPLE_FLAG = 1;
    private static final int PARAMETER_FLAG = 2;
    private static final int LIVE_FLAG = 4;
    static final int UNASSIGNED = -1;
    int offset = -1;
    private Scope scope;

    public final Variable nextVar() {
        return this.next;
    }

    @Override
    public final boolean hasMoreElements() {
        return this.next != null;
    }

    public Object nextElement() {
        if (this.next == null) {
            throw new NoSuchElementException("Variable enumeration");
        }
        return this.next;
    }

    public Variable() {
    }

    public Variable(String name) {
        this.setName(name);
    }

    public Variable(String name, Type type) {
        this.setName(name);
        this.setType(type);
    }

    public final boolean isAssigned() {
        return this.offset != -1;
    }

    public Scope getScope() {
        return this.scope;
    }

    void setScope(Scope scope) {
        this.scope = scope;
    }

    public final boolean dead() {
        return (this.flags & 4) == 0;
    }

    private void setFlag(boolean setting, int flag) {
        this.flags = setting ? (this.flags |= flag) : (this.flags &= ~flag);
    }

    public final boolean isSimple() {
        return (this.flags & 1) != 0;
    }

    public final void setSimple(boolean simple) {
        this.setFlag(simple, 1);
    }

    public final boolean isParameter() {
        return (this.flags & 2) != 0;
    }

    public final void setParameter(boolean parameter) {
        this.setFlag(parameter, 2);
    }

    public boolean reserveLocal(int varIndex, CodeAttr code) {
        int j;
        int size = this.getType().getSizeInWords();
        if (code.locals.used == null) {
            code.locals.used = new Variable[20 + size];
        } else if (code.getMaxLocals() + size >= code.locals.used.length) {
            Variable[] new_locals = new Variable[2 * code.locals.used.length + size];
            System.arraycopy(code.locals.used, 0, new_locals, 0, code.getMaxLocals());
            code.locals.used = new_locals;
        }
        for (j = 0; j < size; ++j) {
            if (code.locals.used[varIndex + j] == null) continue;
            return false;
        }
        for (j = 0; j < size; ++j) {
            code.locals.used[varIndex + j] = this;
        }
        if (varIndex + size > code.getMaxLocals()) {
            code.setMaxLocals(varIndex + size);
        }
        this.offset = varIndex;
        this.flags |= 4;
        if (this.offset == 0 && "<init>".equals(code.getMethod().getName())) {
            this.setType(code.local_types[0]);
        }
        return true;
    }

    public void allocateLocal(CodeAttr code) {
        if (this.offset != -1) {
            return;
        }
        int i = 0;
        while (!this.reserveLocal(i, code)) {
            ++i;
        }
        return;
    }

    public void freeLocal(CodeAttr code) {
        this.flags &= -5;
        int size = this.getType().size > 4 ? 2 : 1;
        int vnum = this.offset + size;
        while (--vnum >= this.offset) {
            code.locals.used[vnum] = null;
            Type[] local_types = code.local_types;
            if (local_types == null || vnum >= local_types.length) continue;
            local_types[vnum] = null;
        }
    }

    boolean shouldEmit() {
        Label start;
        Label end;
        int pos;
        Scope sc = this.scope;
        return this.isSimple() && this.name != null && sc != null && (start = sc.start) != null && (pos = start.position) >= 0 && (end = sc.end) != null && end.position > pos;
    }

    public String toString() {
        return "Variable[" + this.getName() + " offset:" + this.offset + ']';
    }
}

