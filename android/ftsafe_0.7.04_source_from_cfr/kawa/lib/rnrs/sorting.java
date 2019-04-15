/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.rnrs;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.lib.srfi95;
import kawa.standard.append;

public class sorting
extends ModuleBody {
    public static final ModuleMethod list$Mnsort;
    public static final ModuleMethod vector$Mnsort;
    public static final ModuleMethod vector$Mnsort$Ex;
    public static sorting $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static Object listSort(Object less$Qu, Object list) {
        return srfi95.$PcSortList(append.append$V(new Object[]{list, LList.Empty}), less$Qu, Boolean.FALSE);
    }

    public static FVector vectorSort(Object less$Qu, Object seq) {
        Object object2 = Promise.force(seq, Sequence.class);
        try {
            return srfi95.$PcSortVector((Sequence)object2, less$Qu, Boolean.FALSE);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%sort-vector", 1, object2);
        }
    }

    public static void vectorSort$Ex(Object proc, Object vector) {
        Object object2 = Promise.force(vector, Sequence.class);
        try {
            srfi95.$PcVectorSort$Ex((Sequence)object2, proc, Boolean.FALSE);
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%vector-sort!", 1, object2);
        }
    }

    public static {
        Lit2 = Symbol.valueOf("vector-sort!");
        Lit1 = Symbol.valueOf("vector-sort");
        Lit0 = Symbol.valueOf("list-sort");
        sorting sorting2 = $instance = new sorting();
        list$Mnsort = new ModuleMethod(sorting2, 1, Lit0, 8194);
        vector$Mnsort = new ModuleMethod(sorting2, 2, Lit1, 8194);
        vector$Mnsort$Ex = new ModuleMethod(sorting2, 3, Lit2, 8194);
        sorting.$runBody$();
    }

    public sorting() {
        ModuleInfo.register(this);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 3: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 2: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 1: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        switch (moduleMethod.selector) {
            case 1: {
                return sorting.listSort(object2, object3);
            }
            case 2: {
                return sorting.vectorSort(object2, object3);
            }
            case 3: {
                sorting.vectorSort$Ex(object2, object3);
                return Values.empty;
            }
        }
        return super.apply2(moduleMethod, object2, object3);
    }
}

