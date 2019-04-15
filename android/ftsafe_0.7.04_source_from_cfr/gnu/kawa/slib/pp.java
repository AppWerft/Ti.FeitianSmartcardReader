/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.io.OutPort;
import gnu.kawa.slib.genwrite;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.LocationProc;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.math.IntNum;
import kawa.lib.ports;

public class pp
extends ModuleBody {
    public static final ModuleMethod pretty$Mnprint;
    static final IntNum Lit0;
    public static pp $instance;
    static final SimpleSymbol Lit1;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static Object prettyPrint(Object object2) {
        return pp.prettyPrint(object2, ports.current$Mnoutput$Mnport.getValue());
    }

    public static Object prettyPrint(Object obj, Object port) {
        public class Frame
        extends ModuleBody {
            Object port;
            final ModuleMethod lambda$Fn1;

            public Frame() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 1, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pp.scm:9");
                this.lambda$Fn1 = moduleMethod;
            }

            boolean lambda1(Object s) {
                ports.display(s, this.port);
                return true;
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 1) {
                    callContext.value1 = object2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, object2, callContext);
            }

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply1(ModuleMethod moduleMethod, Object object2) {
                if (moduleMethod.selector == 1) {
                    return this.lambda1(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame $heapFrame = new Frame();
        $heapFrame.port = port;
        return genwrite.genericWrite(obj, Boolean.FALSE, Lit0, $heapFrame.lambda$Fn1);
    }

    public static {
        Lit1 = Symbol.valueOf("pretty-print");
        Lit0 = IntNum.valueOf(79);
        pp pp2 = $instance = new pp();
        pretty$Mnprint = new ModuleMethod(pp2, 2, Lit1, 8193);
        pp.$runBody$();
    }

    public pp() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        if (moduleMethod.selector == 2) {
            callContext.value1 = object2;
            callContext.proc = moduleMethod;
            callContext.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        if (moduleMethod.selector == 2) {
            callContext.value1 = object2;
            callContext.value2 = object3;
            callContext.proc = moduleMethod;
            callContext.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        if (moduleMethod.selector == 2) {
            return pp.prettyPrint(object2);
        }
        return super.apply1(moduleMethod, object2);
    }

    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        if (moduleMethod.selector == 2) {
            return pp.prettyPrint(object2, object3);
        }
        return super.apply2(moduleMethod, object2, object3);
    }

}

