// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.io.IOException;
import java.io.DataOutputStream;

public class LocalVarsAttr extends Attribute
{
    private Method method;
    Variable[] used;
    public Scope current_scope;
    Scope parameter_scope;
    
    public LocalVarsAttr(final CodeAttr code) {
        super("LocalVariableTable");
        this.addToFrontOf(code);
        this.method = (Method)code.getContainer();
        code.locals = this;
    }
    
    public LocalVarsAttr(final Method method) {
        super("LocalVariableTable");
        final CodeAttr code = method.code;
        this.method = method;
        code.locals = this;
    }
    
    public final Method getMethod() {
        return this.method;
    }
    
    public VarEnumerator allVars() {
        return new VarEnumerator(this.parameter_scope);
    }
    
    public void enterScope(final Scope scope) {
        scope.linkChild(this.current_scope);
        this.current_scope = scope;
        final CodeAttr code = this.method.getCode();
        for (Variable var = scope.firstVar(); var != null; var = var.nextVar()) {
            if (var.isSimple()) {
                if (!var.isAssigned()) {
                    var.allocateLocal(code);
                }
                else if (this.used[var.offset] == null) {
                    this.used[var.offset] = var;
                }
                else if (this.used[var.offset] != var) {
                    throw new Error("inconsistent local variable assignments for " + var + " != " + this.used[var.offset]);
                }
            }
        }
    }
    
    public void preserveVariablesUpto(final Scope scope) {
        for (Scope cur = this.current_scope; cur != scope; cur = cur.parent) {
            cur.preserved = true;
        }
    }
    
    public final boolean isEmpty() {
        final VarEnumerator vars = this.allVars();
        Variable var;
        while ((var = vars.nextVar()) != null) {
            if (var.isSimple() && var.name != null) {
                return false;
            }
        }
        return true;
    }
    
    public final int getCount() {
        int local_variable_count = 0;
        final VarEnumerator vars = this.allVars();
        Variable var;
        while ((var = vars.nextVar()) != null) {
            if (var.shouldEmit()) {
                ++local_variable_count;
            }
        }
        return local_variable_count;
    }
    
    @Override
    public final int getLength() {
        return 2 + 10 * this.getCount();
    }
    
    @Override
    public void assignConstants(final ClassType cl) {
        super.assignConstants(cl);
        final VarEnumerator vars = this.allVars();
        Variable var;
        while ((var = vars.nextVar()) != null) {
            if (var.isSimple() && var.name != null) {
                if (var.name_index == 0) {
                    var.name_index = cl.getConstants().addUtf8(var.getName()).index;
                }
                if (var.signature_index != 0) {
                    continue;
                }
                var.signature_index = cl.getConstants().addUtf8(var.getType().getSignature()).index;
            }
        }
    }
    
    @Override
    public void write(final DataOutputStream dstr) throws IOException {
        final VarEnumerator vars = this.allVars();
        dstr.writeShort(this.getCount());
        vars.reset();
        Variable var;
        while ((var = vars.nextVar()) != null) {
            if (var.shouldEmit()) {
                final Scope scope = var.getScope();
                final int start_pc = scope.start.position;
                final int end_pc = scope.end.position;
                dstr.writeShort(start_pc);
                dstr.writeShort(end_pc - start_pc);
                dstr.writeShort(var.name_index);
                dstr.writeShort(var.signature_index);
                dstr.writeShort(var.offset);
            }
        }
    }
    
    @Override
    public void print(final ClassTypeWriter dst) {
        final VarEnumerator vars = this.allVars();
        dst.print("Attribute \"");
        dst.print(this.getName());
        dst.print("\", length:");
        dst.print(this.getLength());
        dst.print(", count: ");
        dst.println(this.getCount());
        vars.reset();
        Variable var;
        while ((var = vars.nextVar()) != null) {
            if (var.isSimple() && var.name != null) {
                dst.print("  slot#");
                dst.print(var.offset);
                dst.print(": name: ");
                dst.printOptionalIndex(var.name_index);
                dst.print(var.getName());
                dst.print(", type: ");
                dst.printOptionalIndex(var.signature_index);
                dst.printSignature(var.getType());
                dst.print(" (pc: ");
                final Scope scope = var.getScope();
                final int start_pc;
                final int end_pc;
                if (scope == null || scope.start == null || scope.end == null || (start_pc = scope.start.position) < 0 || (end_pc = scope.end.position) < 0) {
                    dst.print("unknown");
                }
                else {
                    dst.print(start_pc);
                    dst.print(" length: ");
                    dst.print(end_pc - start_pc);
                }
                dst.println(')');
            }
        }
    }
}
