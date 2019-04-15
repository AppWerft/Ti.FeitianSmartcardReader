/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.Scope;
import gnu.bytecode.Variable;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class VarEnumerator
implements Enumeration {
    Scope topScope;
    Scope currentScope;
    Variable next;

    public VarEnumerator(Scope scope) {
        this.topScope = scope;
        this.reset();
    }

    public final void reset() {
        this.currentScope = this.topScope;
        if (this.topScope != null) {
            this.next = this.currentScope.firstVar();
            if (this.next == null) {
                this.fixup();
            }
        }
    }

    private void fixup() {
        while (this.next == null) {
            if (this.currentScope.firstChild != null) {
                this.currentScope = this.currentScope.firstChild;
            } else {
                while (this.currentScope.nextSibling == null) {
                    if (this.currentScope == this.topScope) {
                        return;
                    }
                    this.currentScope = this.currentScope.parent;
                }
                this.currentScope = this.currentScope.nextSibling;
            }
            this.next = this.currentScope.firstVar();
        }
    }

    public final Variable nextVar() {
        Variable result = this.next;
        if (result != null) {
            this.next = result.nextVar();
            if (this.next == null) {
                this.fixup();
            }
        }
        return result;
    }

    @Override
    public final boolean hasMoreElements() {
        return this.next != null;
    }

    public Object nextElement() {
        Variable result = this.nextVar();
        if (result == null) {
            throw new NoSuchElementException("VarEnumerator");
        }
        return result;
    }
}

