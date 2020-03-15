// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

public class SwitchState
{
    int minValue;
    int maxValue;
    int numCases;
    int[] values;
    Label[] labels;
    Label defaultLabel;
    Label switch_label;
    Label cases_label;
    Label after_label;
    TryState outerTry;
    
    public int getMaxValue() {
        return this.maxValue;
    }
    
    public int getNumCases() {
        return this.numCases;
    }
    
    public SwitchState(final CodeAttr code) {
        this.switch_label = new Label(code);
        this.cases_label = new Label(code);
        this.after_label = new Label(code);
        this.defaultLabel = new Label(code);
        this.outerTry = code.try_stack;
        this.numCases = 0;
    }
    
    public void switchValuePushed(final CodeAttr code) {
        final Type top = code.popType();
        this.cases_label.setTypes(code);
        code.pushType(top);
        this.switch_label.setTypes(code);
        code.fixupAdd(9, -1, this.switch_label);
        code.setUnreachable();
        this.cases_label.define(code);
    }
    
    public boolean addCase(final int value, final CodeAttr code) {
        final Label label = new Label(code);
        label.setTypes(this.cases_label);
        label.define(code);
        return this.insertCase(value, label, code);
    }
    
    public boolean addCaseGoto(final int value, final CodeAttr code, final Label label) {
        final boolean ok = this.insertCase(value, label, code);
        label.setTypes(this.cases_label);
        code.setUnreachable();
        return ok;
    }
    
    public void addDefault(final CodeAttr code) {
        if (this.defaultLabel.defined()) {
            throw new Error();
        }
        if (this.outerTry != code.try_stack) {
            this.defaultLabel.setTypes(code);
        }
        this.defaultLabel.setTypes(this.cases_label);
        this.defaultLabel.define(code);
    }
    
    public boolean insertCase(final int value, final Label label, final CodeAttr code) {
        if (this.values == null) {
            this.values = new int[10];
            this.labels = new Label[10];
            this.numCases = 1;
            this.maxValue = value;
            this.minValue = value;
            this.values[0] = value;
            this.labels[0] = label;
            return true;
        }
        final int[] old_values = this.values;
        final Label[] old_labels = this.labels;
        int copyBefore;
        if (value < this.minValue) {
            copyBefore = 0;
            this.minValue = value;
        }
        else if (value > this.maxValue) {
            copyBefore = this.numCases;
            this.maxValue = value;
        }
        else {
            int low = 0;
            int hi = this.numCases - 1;
            copyBefore = 0;
            while (low <= hi) {
                copyBefore = low + hi >>> 1;
                if (old_values[copyBefore] >= value) {
                    hi = copyBefore - 1;
                }
                else {
                    low = ++copyBefore;
                }
            }
            if (value == old_values[copyBefore]) {
                return false;
            }
        }
        if (this.numCases >= this.values.length) {
            this.values = new int[2 * this.numCases];
            this.labels = new Label[2 * this.numCases];
        }
        final int copyAfter = this.numCases - copyBefore;
        System.arraycopy(old_values, copyBefore, this.values, copyBefore + 1, copyAfter);
        System.arraycopy(old_values, 0, this.values, 0, copyBefore);
        this.values[copyBefore] = value;
        System.arraycopy(old_labels, copyBefore, this.labels, copyBefore + 1, copyAfter);
        System.arraycopy(old_labels, 0, this.labels, 0, copyBefore);
        this.labels[copyBefore] = label;
        ++this.numCases;
        return true;
    }
    
    public void exitSwitch(final CodeAttr code) {
        if (code.reachableHere()) {
            if (this.outerTry != code.try_stack) {
                throw new Error("exitSwitch cannot exit through a try");
            }
            code.emitGoto(this.after_label);
        }
    }
    
    public void finish(final CodeAttr code) {
        if (code.reachableHere()) {
            this.exitSwitch(code);
        }
        if (!this.defaultLabel.defined()) {
            this.defaultLabel.define(code);
            final ClassType ex = ClassType.make("java.lang.RuntimeException");
            code.emitNew(ex);
            code.emitDup(ex);
            code.emitPushString("bad case value!");
            final Type[] args = { Type.string_type };
            final Method con = ex.addMethod("<init>", 1, args, Type.voidType);
            code.emitInvokeSpecial(con);
            code.emitThrow();
        }
        code.fixupAdd(9, -1, this.after_label);
        this.switch_label.define(code);
        if (this.numCases <= 1) {
            if (this.numCases == 1) {
                if (this.minValue == 0) {
                    code.emitIfIntEqZero();
                }
                else {
                    code.emitPushInt(this.minValue);
                    code.emitIfEq();
                }
                code.emitGoto(this.labels[0]);
                code.emitElse();
                code.emitGoto(this.defaultLabel);
                code.emitFi();
            }
            else {
                code.emitPop(1);
                code.emitGoto(this.defaultLabel);
            }
        }
        else {
            final long rangeDim = this.maxValue - (long)this.minValue;
            if (2 * this.numCases >= rangeDim) {
                final int size = (int)(13L + 4L * (rangeDim + 1L));
                code.reserve(size);
                code.fixupAdd(2, null);
                code.put1(170);
                code.fixupAdd(3, this.defaultLabel);
                code.PC += 4;
                code.put4(this.minValue);
                code.put4(this.maxValue);
                int index = 0;
                int i = this.minValue;
                while (true) {
                    final Label lab = (this.values[index] == i) ? this.labels[index++] : this.defaultLabel;
                    code.fixupAdd(3, lab);
                    code.PC += 4;
                    if (i == this.maxValue) {
                        break;
                    }
                    ++i;
                }
            }
            else {
                code.reserve(9 + 8 * this.numCases);
                code.fixupAdd(2, null);
                code.put1(171);
                code.fixupAdd(3, this.defaultLabel);
                code.PC += 4;
                code.put4(this.numCases);
                for (int index2 = 0; index2 < this.numCases; ++index2) {
                    code.put4(this.values[index2]);
                    code.fixupAdd(3, this.labels[index2]);
                    code.PC += 4;
                }
            }
        }
        code.fixupAdd(9, this.cases_label);
        code.setUnreachable();
        if (this.after_label.isUsed()) {
            this.after_label.define(code);
        }
        else {
            this.after_label.defineRaw(code);
        }
    }
}
