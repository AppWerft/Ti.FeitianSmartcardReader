// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.util.HashMap;

public class Scope
{
    Scope parent;
    Scope nextSibling;
    Scope firstChild;
    Scope lastChild;
    boolean preserved;
    boolean autoPop;
    Label start;
    Label end;
    Variable vars;
    Variable last_var;
    
    public Scope() {
    }
    
    public Scope(final Label start, final Label end) {
        this.start = start;
        this.end = end;
    }
    
    public final Variable firstVar() {
        return this.vars;
    }
    
    public VarEnumerator allVars() {
        return new VarEnumerator(this);
    }
    
    public Label getStartLabel() {
        return this.start;
    }
    
    public Label getEndLabel() {
        return this.end;
    }
    
    public void linkChild(final Scope parent) {
        this.parent = parent;
        if (parent == null) {
            return;
        }
        if (parent.lastChild == null) {
            parent.firstChild = this;
        }
        else {
            parent.lastChild.nextSibling = this;
        }
        parent.lastChild = this;
    }
    
    public Variable addVariable(final CodeAttr code, final Type type, final String name) {
        final Variable var = new Variable(name, type);
        this.addVariable(code, var);
        return var;
    }
    
    public void addVariable(final Variable var) {
        if (this.last_var == null) {
            this.vars = var;
        }
        else {
            this.last_var.next = var;
        }
        (this.last_var = var).setScope(this);
    }
    
    public void addVariableAfter(final Variable prev, final Variable var) {
        if (prev == null) {
            var.next = this.vars;
            this.vars = var;
        }
        else {
            var.next = prev.next;
            prev.next = var;
        }
        if (this.last_var == prev) {
            this.last_var = var;
        }
        if (var.next == var) {
            throw new Error("cycle");
        }
        var.setScope(this);
    }
    
    public void addVariable(final CodeAttr code, final Variable var) {
        this.addVariable(var);
        if (var.isSimple() && code != null) {
            var.allocateLocal(code);
        }
    }
    
    public Variable getVariable(int index) {
        Variable var = this.vars;
        while (--index >= 0) {
            var = var.next;
        }
        return var;
    }
    
    public void fixParamNames(final HashMap<String, Variable> map) {
        for (Variable var = this.firstVar(); var != null; var = var.nextVar()) {
            final String name = var.getName();
            if (name != null) {
                String xname = name;
                Variable old;
                for (int i = 0; (old = map.get(xname)) != null; xname = name + '$' + i, ++i) {}
                if (name != xname) {
                    var.setName(xname);
                }
                map.put(xname, var);
            }
        }
    }
    
    static boolean equals(final byte[] name1, final byte[] name2) {
        if (name1.length != name2.length) {
            return false;
        }
        if (name1 == name2) {
            return true;
        }
        int i = name1.length;
        while (--i >= 0) {
            if (name1[i] != name2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public void setStartPC(final CodeAttr code) {
        if (this.start == null) {
            this.start = new Label();
        }
        final boolean reachable = code.reachableHere();
        this.start.define(code);
        code.setReachable(reachable);
    }
    
    public void noteStartFunction(final CodeAttr code) {
        this.setStartPC(code);
    }
    
    public Variable lookup(final String name) {
        for (Variable var = this.vars; var != null; var = var.next) {
            if (name.equals(var.name)) {
                return var;
            }
        }
        return null;
    }
    
    void freeLocals(final CodeAttr code) {
        if (this.preserved) {
            return;
        }
        for (Variable var = this.vars; var != null; var = var.next) {
            if (var.isSimple() && !var.dead()) {
                var.freeLocal(code);
            }
        }
        for (Scope child = this.firstChild; child != null; child = child.nextSibling) {
            if (child.preserved) {
                child.preserved = false;
                child.freeLocals(code);
            }
        }
    }
}
