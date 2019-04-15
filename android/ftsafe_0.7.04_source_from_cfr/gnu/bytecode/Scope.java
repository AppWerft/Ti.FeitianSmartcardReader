/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Type;
import gnu.bytecode.VarEnumerator;
import gnu.bytecode.Variable;
import java.util.HashMap;

public class Scope {
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

    public Scope(Label start, Label end) {
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

    public void linkChild(Scope parent) {
        this.parent = parent;
        if (parent == null) {
            return;
        }
        if (parent.lastChild == null) {
            parent.firstChild = this;
        } else {
            parent.lastChild.nextSibling = this;
        }
        parent.lastChild = this;
    }

    public Variable addVariable(CodeAttr code, Type type, String name) {
        Variable var = new Variable(name, type);
        this.addVariable(code, var);
        return var;
    }

    public void addVariable(Variable var) {
        if (this.last_var == null) {
            this.vars = var;
        } else {
            this.last_var.next = var;
        }
        this.last_var = var;
        var.setScope(this);
    }

    public void addVariableAfter(Variable prev, Variable var) {
        if (prev == null) {
            var.next = this.vars;
            this.vars = var;
        } else {
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

    public void addVariable(CodeAttr code, Variable var) {
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

    public void fixParamNames(HashMap<String, Variable> map) {
        for (Variable var = this.firstVar(); var != null; var = var.nextVar()) {
            Variable old;
            String name = var.getName();
            if (name == null) continue;
            String xname = name;
            int i = 0;
            while ((old = map.get(xname)) != null) {
                xname = name + '$' + i;
                ++i;
            }
            if (name != xname) {
                var.setName(xname);
            }
            map.put(xname, var);
        }
    }

    static boolean equals(byte[] name1, byte[] name2) {
        if (name1.length != name2.length) {
            return false;
        }
        if (name1 == name2) {
            return true;
        }
        int i = name1.length;
        while (--i >= 0) {
            if (name1[i] == name2[i]) continue;
            return false;
        }
        return true;
    }

    public void setStartPC(CodeAttr code) {
        if (this.start == null) {
            this.start = new Label();
        }
        boolean reachable = code.reachableHere();
        this.start.define(code);
        code.setReachable(reachable);
    }

    public void noteStartFunction(CodeAttr code) {
        this.setStartPC(code);
    }

    public Variable lookup(String name) {
        Variable var = this.vars;
        while (var != null) {
            if (name.equals(var.name)) {
                return var;
            }
            var = var.next;
        }
        return null;
    }

    void freeLocals(CodeAttr code) {
        if (this.preserved) {
            return;
        }
        Variable var = this.vars;
        while (var != null) {
            if (var.isSimple() && !var.dead()) {
                var.freeLocal(code);
            }
            var = var.next;
        }
        Scope child = this.firstChild;
        while (child != null) {
            if (child.preserved) {
                child.preserved = false;
                child.freeLocals(code);
            }
            child = child.nextSibling;
        }
    }
}

