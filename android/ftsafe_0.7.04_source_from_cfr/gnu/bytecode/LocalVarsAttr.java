/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.AttrContainer;
import gnu.bytecode.Attribute;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ConstantPool;
import gnu.bytecode.CpoolUtf8;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.VarEnumerator;
import gnu.bytecode.Variable;
import java.io.DataOutputStream;
import java.io.IOException;

public class LocalVarsAttr
extends Attribute {
    private Method method;
    Variable[] used;
    public Scope current_scope;
    Scope parameter_scope;

    public LocalVarsAttr(CodeAttr code) {
        super("LocalVariableTable");
        this.addToFrontOf(code);
        this.method = (Method)code.getContainer();
        code.locals = this;
    }

    public LocalVarsAttr(Method method) {
        super("LocalVariableTable");
        CodeAttr code = method.code;
        this.method = method;
        code.locals = this;
    }

    public final Method getMethod() {
        return this.method;
    }

    public VarEnumerator allVars() {
        return new VarEnumerator(this.parameter_scope);
    }

    public void enterScope(Scope scope) {
        scope.linkChild(this.current_scope);
        this.current_scope = scope;
        CodeAttr code = this.method.getCode();
        for (Variable var = scope.firstVar(); var != null; var = var.nextVar()) {
            if (!var.isSimple()) continue;
            if (!var.isAssigned()) {
                var.allocateLocal(code);
                continue;
            }
            if (this.used[var.offset] == null) {
                this.used[var.offset] = var;
                continue;
            }
            if (this.used[var.offset] == var) continue;
            throw new Error("inconsistent local variable assignments for " + var + " != " + this.used[var.offset]);
        }
    }

    public void preserveVariablesUpto(Scope scope) {
        Scope cur = this.current_scope;
        while (cur != scope) {
            cur.preserved = true;
            cur = cur.parent;
        }
    }

    public final boolean isEmpty() {
        Variable var;
        VarEnumerator vars = this.allVars();
        while ((var = vars.nextVar()) != null) {
            if (!var.isSimple() || var.name == null) continue;
            return false;
        }
        return true;
    }

    public final int getCount() {
        Variable var;
        int local_variable_count = 0;
        VarEnumerator vars = this.allVars();
        while ((var = vars.nextVar()) != null) {
            if (!var.shouldEmit()) continue;
            ++local_variable_count;
        }
        return local_variable_count;
    }

    @Override
    public final int getLength() {
        return 2 + 10 * this.getCount();
    }

    @Override
    public void assignConstants(ClassType cl) {
        Variable var;
        super.assignConstants(cl);
        VarEnumerator vars = this.allVars();
        while ((var = vars.nextVar()) != null) {
            if (!var.isSimple() || var.name == null) continue;
            if (var.name_index == 0) {
                var.name_index = cl.getConstants().addUtf8((String)var.getName()).index;
            }
            if (var.signature_index != 0) continue;
            var.signature_index = cl.getConstants().addUtf8((String)var.getType().getSignature()).index;
        }
    }

    @Override
    public void write(DataOutputStream dstr) throws IOException {
        Variable var;
        VarEnumerator vars = this.allVars();
        dstr.writeShort(this.getCount());
        vars.reset();
        while ((var = vars.nextVar()) != null) {
            if (!var.shouldEmit()) continue;
            Scope scope = var.getScope();
            int start_pc = scope.start.position;
            int end_pc = scope.end.position;
            dstr.writeShort(start_pc);
            dstr.writeShort(end_pc - start_pc);
            dstr.writeShort(var.name_index);
            dstr.writeShort(var.signature_index);
            dstr.writeShort(var.offset);
        }
    }

    @Override
    public void print(ClassTypeWriter dst) {
        Variable var;
        VarEnumerator vars = this.allVars();
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", count: ");
        dst.println(this.getCount());
        vars.reset();
        while ((var = vars.nextVar()) != null) {
            int end_pc;
            int start_pc;
            if (!var.isSimple() || var.name == null) continue;
            dst.print("  slot#");
            dst.print(var.offset);
            dst.print(": name: ");
            dst.printOptionalIndex(var.name_index);
            dst.print(var.getName());
            dst.print(", type: ");
            dst.printOptionalIndex(var.signature_index);
            dst.printSignature(var.getType());
            dst.print(" (pc: ");
            Scope scope = var.getScope();
            if (scope == null || scope.start == null || scope.end == null || (start_pc = scope.start.position) < 0 || (end_pc = scope.end.position) < 0) {
                dst.print("unknown");
            } else {
                dst.print(start_pc);
                dst.print(" length: ");
                dst.print(end_pc - start_pc);
            }
            dst.println(')');
        }
    }
}

