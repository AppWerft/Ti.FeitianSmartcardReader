/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.mapping.ValueStack;
import gnu.mapping.Values;
import gnu.mapping.WrongArguments;
import gnu.math.IntNum;

public class CallContext {
    static ThreadLocal currentContext = new ThreadLocal();
    public Procedure proc;
    public int pc;
    private ValueStack vstack = new ValueStack();
    public Consumer consumer = this.vstack;
    public Object value1;
    public Object value2;
    public Object value3;
    public Object value4;
    public Object[] values;
    public int ivalue1;
    public int ivalue2;
    public int count;
    public int next;
    public int where;
    public static final int ARG_IN_VALUES_ARRAY = 0;
    public static final int ARG_IN_VALUE1 = 1;
    public static final int ARG_IN_VALUE2 = 2;
    public static final int ARG_IN_VALUE3 = 3;
    public static final int ARG_IN_VALUE4 = 4;
    public static final int ARG_IN_IVALUE1 = 5;
    public static final int ARG_IN_IVALUE2 = 6;
    public Object[][] evalFrames;

    public static void setInstance(CallContext ctx) {
        Thread thread2 = Thread.currentThread();
        currentContext.set(ctx);
    }

    public static CallContext getOnlyInstance() {
        return (CallContext)currentContext.get();
    }

    public static CallContext getInstance() {
        CallContext ctx = CallContext.getOnlyInstance();
        if (ctx == null) {
            ctx = new CallContext();
            CallContext.setInstance(ctx);
        }
        return ctx;
    }

    Object getArgAsObject(int i) {
        if (i < 8) {
            switch (this.where >> 4 * i & 15) {
                case 1: {
                    return this.value1;
                }
                case 2: {
                    return this.value2;
                }
                case 3: {
                    return this.value3;
                }
                case 4: {
                    return this.value4;
                }
                case 5: {
                    return IntNum.make(this.ivalue1);
                }
                case 6: {
                    return IntNum.make(this.ivalue2);
                }
            }
        }
        return this.values[i];
    }

    public int getArgCount() {
        return this.count;
    }

    public Object getNextArg() {
        if (this.next >= this.count) {
            throw new WrongArguments(null, this.count);
        }
        return this.getArgAsObject(this.next++);
    }

    public int getNextIntArg() {
        if (this.next >= this.count) {
            throw new WrongArguments(null, this.count);
        }
        Object arg = this.getArgAsObject(this.next++);
        return ((Number)arg).intValue();
    }

    public Object getNextArg(Object defaultValue) {
        if (this.next >= this.count) {
            return defaultValue;
        }
        return this.getArgAsObject(this.next++);
    }

    public int getNextIntArg(int defaultValue) {
        if (this.next >= this.count) {
            return defaultValue;
        }
        return ((Number)this.getArgAsObject(this.next++)).intValue();
    }

    public final Object[] getRestArgsArray(int next) {
        Object[] args = new Object[this.count - next];
        int i = 0;
        while (next < this.count) {
            args[i++] = this.getArgAsObject(next++);
        }
        return args;
    }

    public final LList getRestArgsList(int next) {
        EmptyList nil;
        LList list = nil = LList.Empty;
        Pair last = null;
        while (next < this.count) {
            Pair pair = new Pair(this.getArgAsObject(next++), nil);
            if (last == null) {
                list = pair;
            } else {
                last.setCdr(pair);
            }
            last = pair;
        }
        return list;
    }

    public void lastArg() {
        if (this.next < this.count) {
            throw new WrongArguments(null, this.count);
        }
        this.values = null;
    }

    public Object[] getArgs() {
        if (this.where == 0) {
            return this.values;
        }
        int n = this.count;
        this.next = 0;
        Object[] args = new Object[n];
        for (int i = 0; i < n; ++i) {
            args[i] = this.getNextArg();
        }
        return args;
    }

    public void runUntilDone() throws Throwable {
        Procedure proc;
        while ((proc = this.proc) != null) {
            this.proc = null;
            proc.apply(this);
        }
    }

    public final int startFromContext() {
        if (this.vstack.gapStart == this.vstack.gapStartOnPush && this.consumer == this.vstack && this.vstack.lastObject == this.vstack) {
            return -1;
        }
        this.vstack.push();
        this.vstack.consumerOnPush = this.consumer;
        this.vstack.oindexOnPush = this.vstack.oindex;
        this.vstack.gapStartOnPush = this.vstack.gapStart;
        this.consumer = this.vstack;
        return this.vstack.gapStart;
    }

    public final Object getFromContext(int saved) throws Throwable {
        this.runUntilDone();
        Object result = ((ValueStack)this.consumer).getValue();
        this.cleanupFromContext(saved);
        return result;
    }

    public final void cleanupFromContext(int saved) {
        this.vstack.gapStart = this.vstack.gapStartOnPush;
        int oindexOnPush = this.vstack.oindexOnPush;
        int i = this.vstack.oindex;
        while (--i >= oindexOnPush) {
            this.vstack.objects[i] = null;
        }
        this.vstack.oindex = oindexOnPush;
        this.vstack.lastObject = this.vstack;
        if (saved >= 0) {
            this.consumer = this.vstack.consumerOnPush;
            this.vstack.pop(saved);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final Object runUntilValue() throws Throwable {
        Consumer consumerSave = this.consumer;
        ValueStack vst = this.vstack;
        this.consumer = vst;
        Object lastSave = vst.lastObject;
        vst.lastObject = vst;
        int dindexSave = vst.gapStart;
        int gapStartOnPushSave = vst.gapStartOnPush;
        this.vstack.gapStartOnPush = vst.gapStart;
        int oindexSave = vst.oindex;
        try {
            this.runUntilDone();
            Object object2 = vst.getValue();
            return object2;
        }
        finally {
            this.consumer = consumerSave;
            vst.gapStart = dindexSave;
            vst.oindex = oindexSave;
            vst.gapStartOnPush = gapStartOnPushSave;
            vst.lastObject = lastSave;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void runUntilValue(Consumer out) throws Throwable {
        Consumer consumerSave = this.consumer;
        this.consumer = out;
        try {
            this.runUntilDone();
        }
        finally {
            this.consumer = consumerSave;
        }
    }

    public void writeValue(Object value) {
        Values.writeValues(value, this.consumer);
    }
}

