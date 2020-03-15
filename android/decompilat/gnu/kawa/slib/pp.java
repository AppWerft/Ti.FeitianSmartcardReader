// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import kawa.lib.ports;
import gnu.kawa.io.OutPort;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class pp extends ModuleBody
{
    public static final ModuleMethod pretty$Mnprint;
    static final IntNum Lit0;
    public static pp $instance;
    static final SimpleSymbol Lit1;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Object prettyPrint(final Object obj) {
        return prettyPrint(obj, ports.current$Mnoutput$Mnport.getValue());
    }
    
    public static Object prettyPrint(final Object obj, final Object port) {
        public class pp$frame extends ModuleBody
        {
            Object port;
            final ModuleMethod lambda$Fn1;
            
            public pp$frame() {
                final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, 4097);
                lambda$Fn1.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pp.scm:9");
                this.lambda$Fn1 = lambda$Fn1;
            }
            
            boolean lambda1(final Object s) {
                ports.display(s, this.port);
                return true;
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 1) {
                    ctx.value1 = o;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, o, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object o) {
                if (method.selector == 1) {
                    return this.lambda1(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final pp$frame $heapFrame = new pp$frame();
        $heapFrame.port = port;
        return genwrite.genericWrite(obj, Boolean.FALSE, pp.Lit0, $heapFrame.lambda$Fn1);
    }
    
    static {
        Lit1 = Symbol.valueOf("pretty-print");
        Lit0 = IntNum.valueOf(79);
        pp.$instance = new pp();
        pretty$Mnprint = new ModuleMethod(pp.$instance, 2, pp.Lit1, 8193);
        $runBody$();
    }
    
    public pp() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        if (moduleMethod.selector == 2) {
            ctx.value1 = o;
            ctx.proc = moduleMethod;
            ctx.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, o, ctx);
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        if (moduleMethod.selector == 2) {
            ctx.value1 = o;
            ctx.value2 = o2;
            ctx.proc = moduleMethod;
            ctx.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, o, o2, ctx);
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object arg1) {
        if (method.selector == 2) {
            return prettyPrint(arg1);
        }
        return super.apply1(method, arg1);
    }
    
    @Override
    public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
        if (method.selector == 2) {
            return prettyPrint(o, o2);
        }
        return super.apply2(method, o, o2);
    }
}
