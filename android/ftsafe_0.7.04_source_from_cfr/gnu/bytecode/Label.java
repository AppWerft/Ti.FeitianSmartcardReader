/*
 * Decompiled with CFR 0.139.
 */
package gnu.bytecode;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.LocalVarsAttr;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import java.util.ArrayList;

public class Label {
    int first_fixup;
    int position;
    boolean needsStackMapEntry;
    Type[] stackTypes;
    Type[] localTypes;
    private Object[] typeChangeListeners;

    public final boolean defined() {
        return this.position >= 0;
    }

    public Label() {
        this(-1);
    }

    public Label(CodeAttr code) {
        this(-1);
    }

    public Label(int position) {
        this.position = position;
    }

    public boolean isUsed() {
        return this.stackTypes != null;
    }

    Type mergeTypes(Type t1, Type t2) {
        if (t1 instanceof PrimType != t2 instanceof PrimType) {
            return null;
        }
        return Type.lowestCommonSuperType(t1, t2);
    }

    void setTypes(Type[] locals, int usedLocals, Type[] stack, int usedStack) {
        Type last;
        while (usedLocals > 0 && (last = locals[usedLocals - 1]) == null) {
            --usedLocals;
        }
        if (this.stackTypes == null) {
            if (usedStack == 0) {
                this.stackTypes = Type.typeArray0;
            } else {
                this.stackTypes = new Type[usedStack];
                System.arraycopy(stack, 0, this.stackTypes, 0, usedStack);
            }
            if (usedLocals == 0) {
                this.localTypes = Type.typeArray0;
            } else {
                this.localTypes = new Type[usedLocals];
                System.arraycopy(locals, 0, this.localTypes, 0, usedLocals);
            }
        } else {
            int i;
            int SP = usedStack;
            int slen = this.stackTypes.length;
            if (SP != slen) {
                throw new InternalError("inconsistent stack length");
            }
            for (i = 0; i < SP; ++i) {
                Type t = this.mergeTypes(this.stackTypes[i], stack[i]);
                if (t == null) {
                    throw new InternalError("inconsistent stackType");
                }
                this.stackTypes[i] = t;
            }
            for (i = 0; i < this.localTypes.length; ++i) {
                this.mergeLocalType(i, i < usedLocals ? locals[i] : null);
            }
        }
    }

    public void setTypes(CodeAttr code) {
        this.addTypeChangeListeners(code);
        if (this.stackTypes != null && code.SP != this.stackTypes.length) {
            throw new InternalError();
        }
        this.setTypes(code.local_types, code.local_types == null ? 0 : code.local_types.length, code.stack_types, code.SP);
    }

    public void setTypes(Label other) {
        this.setTypes(other.localTypes, other.localTypes.length, other.stackTypes, other.stackTypes.length);
    }

    private void mergeLocalType(int varnum, Type newType) {
        Type oldLocal;
        Type newLocal;
        if (varnum < this.localTypes.length && (newLocal = this.mergeTypes(oldLocal = this.localTypes[varnum], newType)) != oldLocal) {
            this.localTypes[varnum] = newLocal;
            this.notifyTypeChangeListeners(varnum, newLocal);
        }
    }

    private void notifyTypeChangeListeners(int varnum, Type newType) {
        Object[] arr = this.typeChangeListeners;
        if (arr == null || arr.length <= varnum) {
            return;
        }
        Object listeners = arr[varnum];
        if (listeners == null) {
            return;
        }
        if (listeners instanceof Label) {
            ((Label)listeners).mergeLocalType(varnum, newType);
        } else {
            for (Label listener : (ArrayList)listeners) {
                listener.mergeLocalType(varnum, newType);
            }
        }
        if (newType == null) {
            arr[varnum] = null;
        }
    }

    void addTypeChangeListener(int varnum, Label listener) {
        Object[] arr = this.typeChangeListeners;
        if (arr == null) {
            this.typeChangeListeners = arr = new Object[varnum + 10];
        } else if (arr.length <= varnum) {
            arr = new Object[varnum + 10];
            System.arraycopy(this.typeChangeListeners, 0, arr, 0, this.typeChangeListeners.length);
            this.typeChangeListeners = arr;
        }
        Object set = arr[varnum];
        if (set == null) {
            arr[varnum] = listener;
        } else {
            ArrayList<Label> list;
            if (set instanceof Label) {
                list = new ArrayList<Label>();
                list.add((Label)set);
                arr[varnum] = list;
            } else {
                list = (ArrayList<Label>)set;
            }
            list.add(listener);
        }
    }

    void addTypeChangeListeners(CodeAttr code) {
        if (code.local_types != null && code.previousLabel != null) {
            int len = code.local_types.length;
            for (int varnum = 0; varnum < len; ++varnum) {
                if (code.local_types[varnum] == null || code.varsSetInCurrentBlock != null && code.varsSetInCurrentBlock.length > varnum && code.varsSetInCurrentBlock[varnum]) continue;
                code.previousLabel.addTypeChangeListener(varnum, this);
            }
        }
    }

    public void defineRaw(CodeAttr code) {
        this.defineRaw(code, 0);
    }

    void defineRaw(CodeAttr code, int fixupKind) {
        if (this.position >= 0) {
            throw new Error("label definition more than once");
        }
        this.position = code.PC;
        this.first_fixup = code.fixup_count;
        if (this.first_fixup >= 0) {
            code.fixupAdd(fixupKind, this);
        }
    }

    public void define(CodeAttr code) {
        boolean wasReachable = code.reachableHere();
        if (wasReachable) {
            this.setTypes(code);
        } else if (this.localTypes != null) {
            int i = this.localTypes.length;
            while (--i >= 0) {
                if (this.localTypes[i] == null || code.locals.used != null && code.locals.used[i] != null) continue;
                this.localTypes[i] = null;
            }
        }
        code.setPreviousLabelHere(this);
        this.defineRaw(code, wasReachable ? 0 : 1);
        if (this.localTypes != null) {
            code.setTypes(this);
        }
        code.setReachable(true);
    }
}

