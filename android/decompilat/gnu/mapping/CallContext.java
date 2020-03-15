// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import gnu.lists.Pair;
import gnu.lists.LList;
import gnu.math.IntNum;
import gnu.lists.Consumer;

public class CallContext
{
    static ThreadLocal currentContext;
    public Procedure proc;
    public int pc;
    private ValueStack vstack;
    public Consumer consumer;
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
    
    public CallContext() {
        this.vstack = new ValueStack();
        this.consumer = this.vstack;
    }
    
    public static void setInstance(final CallContext ctx) {
        final Thread thread = Thread.currentThread();
        CallContext.currentContext.set(ctx);
    }
    
    public static CallContext getOnlyInstance() {
        return CallContext.currentContext.get();
    }
    
    public static CallContext getInstance() {
        CallContext ctx = getOnlyInstance();
        if (ctx == null) {
            ctx = new CallContext();
            setInstance(ctx);
        }
        return ctx;
    }
    
    Object getArgAsObject(final int i) {
        if (i < 8) {
            switch (this.where >> 4 * i & 0xF) {
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
        final Object arg = this.getArgAsObject(this.next++);
        return ((Number)arg).intValue();
    }
    
    public Object getNextArg(final Object defaultValue) {
        if (this.next >= this.count) {
            return defaultValue;
        }
        return this.getArgAsObject(this.next++);
    }
    
    public int getNextIntArg(final int defaultValue) {
        if (this.next >= this.count) {
            return defaultValue;
        }
        return ((Number)this.getArgAsObject(this.next++)).intValue();
    }
    
    public final Object[] getRestArgsArray(int next) {
        final Object[] args = new Object[this.count - next];
        for (int i = 0; next < this.count; args[i++] = this.getArgAsObject(next++)) {}
        return args;
    }
    
    public final LList getRestArgsList(int next) {
        LList list;
        final LList nil = list = LList.Empty;
        Pair last = null;
        while (next < this.count) {
            final Pair pair = new Pair(this.getArgAsObject(next++), nil);
            if (last == null) {
                list = pair;
            }
            else {
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
        final int n = this.count;
        this.next = 0;
        final Object[] args = new Object[n];
        for (int i = 0; i < n; ++i) {
            args[i] = this.getNextArg();
        }
        return args;
    }
    
    public void runUntilDone() throws Throwable {
        while (true) {
            final Procedure proc = this.proc;
            if (proc == null) {
                break;
            }
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
    
    public final Object getFromContext(final int saved) throws Throwable {
        this.runUntilDone();
        final Object result = ((ValueStack)this.consumer).getValue();
        this.cleanupFromContext(saved);
        return result;
    }
    
    public final void cleanupFromContext(final int saved) {
        this.vstack.gapStart = this.vstack.gapStartOnPush;
        final int oindexOnPush = this.vstack.oindexOnPush;
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
    
    public final Object runUntilValue() throws Throwable {
        final Consumer consumerSave = this.consumer;
        final ValueStack vst = this.vstack;
        this.consumer = vst;
        final Object lastSave = vst.lastObject;
        vst.lastObject = vst;
        final int dindexSave = vst.gapStart;
        final int gapStartOnPushSave = vst.gapStartOnPush;
        this.vstack.gapStartOnPush = vst.gapStart;
        final int oindexSave = vst.oindex;
        try {
            this.runUntilDone();
            return vst.getValue();
        }
        finally {
            this.consumer = consumerSave;
            vst.gapStart = dindexSave;
            vst.oindex = oindexSave;
            vst.gapStartOnPush = gapStartOnPushSave;
            vst.lastObject = lastSave;
        }
    }
    
    public final void runUntilValue(final Consumer out) throws Throwable {
        final Consumer consumerSave = this.consumer;
        this.consumer = out;
        try {
            this.runUntilDone();
        }
        finally {
            this.consumer = consumerSave;
        }
    }
    
    public void writeValue(final Object value) {
        Values.writeValues(value, this.consumer);
    }
    
    static {
        CallContext.currentContext = new ThreadLocal();
    }
}
