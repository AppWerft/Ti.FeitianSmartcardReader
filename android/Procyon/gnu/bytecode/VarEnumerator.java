// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.util.NoSuchElementException;
import java.util.Enumeration;

public class VarEnumerator implements Enumeration
{
    Scope topScope;
    Scope currentScope;
    Variable next;
    
    public VarEnumerator(final Scope scope) {
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
            }
            else {
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
        final Variable result = this.next;
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
    
    @Override
    public Object nextElement() {
        final Variable result = this.nextVar();
        if (result == null) {
            throw new NoSuchElementException("VarEnumerator");
        }
        return result;
    }
}
