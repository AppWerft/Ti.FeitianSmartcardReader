// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.rnrs;

import gnu.mapping.Values;
import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.lists.Sequence;
import gnu.lists.FVector;
import kawa.lib.srfi95;
import kawa.standard.append;
import gnu.lists.LList;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class sorting extends ModuleBody
{
    public static final ModuleMethod list$Mnsort;
    public static final ModuleMethod vector$Mnsort;
    public static final ModuleMethod vector$Mnsort$Ex;
    public static sorting $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Object listSort(final Object less$Qu, final Object list) {
        return srfi95.$PcSortList(append.append$V(new Object[] { list, LList.Empty }), less$Qu, Boolean.FALSE);
    }
    
    public static FVector vectorSort(final Object less$Qu, final Object seq) {
        final Object force = Promise.force(seq, Sequence.class);
        try {
            return srfi95.$PcSortVector((Sequence)force, less$Qu, Boolean.FALSE);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "%sort-vector", 1, force);
        }
    }
    
    public static void vectorSort$Ex(final Object proc, final Object vector) {
        final Object force = Promise.force(vector, Sequence.class);
        try {
            srfi95.$PcVectorSort$Ex((Sequence)force, proc, Boolean.FALSE);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "%vector-sort!", 1, force);
        }
    }
    
    static {
        Lit2 = Symbol.valueOf("vector-sort!");
        Lit1 = Symbol.valueOf("vector-sort");
        Lit0 = Symbol.valueOf("list-sort");
        sorting.$instance = new sorting();
        final sorting $instance = sorting.$instance;
        list$Mnsort = new ModuleMethod($instance, 1, sorting.Lit0, 8194);
        vector$Mnsort = new ModuleMethod($instance, 2, sorting.Lit1, 8194);
        vector$Mnsort$Ex = new ModuleMethod($instance, 3, sorting.Lit2, 8194);
        $runBody$();
    }
    
    public sorting() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 3: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 2: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 1: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            default: {
                return super.match2(moduleMethod, o, o2, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
        switch (method.selector) {
            case 1: {
                return listSort(o, o2);
            }
            case 2: {
                return vectorSort(o, o2);
            }
            case 3: {
                vectorSort$Ex(o, o2);
                return Values.empty;
            }
            default: {
                return super.apply2(method, o, o2);
            }
        }
    }
}
