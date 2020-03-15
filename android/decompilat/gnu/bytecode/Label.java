// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

import java.util.Iterator;
import java.util.ArrayList;

public class Label
{
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
    
    public Label(final CodeAttr code) {
        this(-1);
    }
    
    public Label(final int position) {
        this.position = position;
    }
    
    public boolean isUsed() {
        return this.stackTypes != null;
    }
    
    Type mergeTypes(final Type t1, final Type t2) {
        if (t1 instanceof PrimType != t2 instanceof PrimType) {
            return null;
        }
        return Type.lowestCommonSuperType(t1, t2);
    }
    
    void setTypes(final Type[] locals, int usedLocals, final Type[] stack, final int usedStack) {
        while (usedLocals > 0) {
            final Type last = locals[usedLocals - 1];
            if (last != null) {
                break;
            }
            --usedLocals;
        }
        if (this.stackTypes == null) {
            if (usedStack == 0) {
                this.stackTypes = Type.typeArray0;
            }
            else {
                System.arraycopy(stack, 0, this.stackTypes = new Type[usedStack], 0, usedStack);
            }
            if (usedLocals == 0) {
                this.localTypes = Type.typeArray0;
            }
            else {
                System.arraycopy(locals, 0, this.localTypes = new Type[usedLocals], 0, usedLocals);
            }
        }
        else {
            final int SP = usedStack;
            final int slen = this.stackTypes.length;
            if (SP != slen) {
                throw new InternalError("inconsistent stack length");
            }
            for (int i = 0; i < SP; ++i) {
                final Type t = this.mergeTypes(this.stackTypes[i], stack[i]);
                if (t == null) {
                    throw new InternalError("inconsistent stackType");
                }
                this.stackTypes[i] = t;
            }
            for (int i = 0; i < this.localTypes.length; ++i) {
                this.mergeLocalType(i, (i < usedLocals) ? locals[i] : null);
            }
        }
    }
    
    public void setTypes(final CodeAttr code) {
        this.addTypeChangeListeners(code);
        if (this.stackTypes != null && code.SP != this.stackTypes.length) {
            throw new InternalError();
        }
        this.setTypes(code.local_types, (code.local_types == null) ? 0 : code.local_types.length, code.stack_types, code.SP);
    }
    
    public void setTypes(final Label other) {
        this.setTypes(other.localTypes, other.localTypes.length, other.stackTypes, other.stackTypes.length);
    }
    
    private void mergeLocalType(final int varnum, final Type newType) {
        if (varnum < this.localTypes.length) {
            final Type oldLocal = this.localTypes[varnum];
            final Type newLocal = this.mergeTypes(oldLocal, newType);
            if (newLocal != oldLocal) {
                this.notifyTypeChangeListeners(varnum, this.localTypes[varnum] = newLocal);
            }
        }
    }
    
    private void notifyTypeChangeListeners(final int varnum, final Type newType) {
        final Object[] arr = this.typeChangeListeners;
        if (arr == null || arr.length <= varnum) {
            return;
        }
        final Object listeners = arr[varnum];
        if (listeners == null) {
            return;
        }
        if (listeners instanceof Label) {
            ((Label)listeners).mergeLocalType(varnum, newType);
        }
        else {
            for (final Label listener : (ArrayList)listeners) {
                listener.mergeLocalType(varnum, newType);
            }
        }
        if (newType == null) {
            arr[varnum] = null;
        }
    }
    
    void addTypeChangeListener(final int varnum, final Label listener) {
        Object[] arr = this.typeChangeListeners;
        if (arr == null) {
            arr = (this.typeChangeListeners = new Object[varnum + 10]);
        }
        else if (arr.length <= varnum) {
            arr = new Object[varnum + 10];
            System.arraycopy(this.typeChangeListeners, 0, arr, 0, this.typeChangeListeners.length);
            this.typeChangeListeners = arr;
        }
        final Object set = arr[varnum];
        if (set == null) {
            arr[varnum] = listener;
        }
        else {
            ArrayList<Label> list;
            if (set instanceof Label) {
                list = new ArrayList<Label>();
                list.add((Label)set);
                arr[varnum] = list;
            }
            else {
                list = (ArrayList<Label>)set;
            }
            list.add(listener);
        }
    }
    
    void addTypeChangeListeners(final CodeAttr code) {
        if (code.local_types != null && code.previousLabel != null) {
            for (int len = code.local_types.length, varnum = 0; varnum < len; ++varnum) {
                if (code.local_types[varnum] != null && (code.varsSetInCurrentBlock == null || code.varsSetInCurrentBlock.length <= varnum || !code.varsSetInCurrentBlock[varnum])) {
                    code.previousLabel.addTypeChangeListener(varnum, this);
                }
            }
        }
    }
    
    public void defineRaw(final CodeAttr code) {
        this.defineRaw(code, 0);
    }
    
    void defineRaw(final CodeAttr code, final int fixupKind) {
        if (this.position >= 0) {
            throw new Error("label definition more than once");
        }
        this.position = code.PC;
        this.first_fixup = code.fixup_count;
        if (this.first_fixup >= 0) {
            code.fixupAdd(fixupKind, this);
        }
    }
    
    public void define(final CodeAttr code) {
        final boolean wasReachable = code.reachableHere();
        if (wasReachable) {
            this.setTypes(code);
        }
        else if (this.localTypes != null) {
            int i = this.localTypes.length;
            while (--i >= 0) {
                if (this.localTypes[i] != null && (code.locals.used == null || code.locals.used[i] == null)) {
                    this.localTypes[i] = null;
                }
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
