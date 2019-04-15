/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;

public class XStrings
extends ModuleBody {
    public static final ModuleMethod substring;
    public static final ModuleMethod string$Mnlength;
    static final IntNum Lit0;
    public static XStrings $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static Object substring(Object object2, Object object3) {
        return XStrings.substring(object2, object3, Lit0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object substring(Object string, Object start, Object length) {
        int index2;
        int rlen;
        Object object2;
        String s;
        block9 : {
            block10 : {
                boolean x;
                block8 : {
                    boolean x2;
                    boolean bl = x2 = string == Values.empty;
                    if (!x2) break block8;
                    if (!x2) break block9;
                    break block10;
                }
                boolean bl = x = start == Values.empty;
                if (!(x ? x : length == Values.empty)) break block9;
            }
            object2 = Values.empty;
            return object2;
        }
        Object object3 = Promise.force(string, String.class);
        try {
            s = (String)object3;
        }
        catch (ClassCastException classCastException) {
            void slen;
            throw new WrongType(classCastException, "s", -2, (Object)slen);
        }
        int slen = s.length();
        Object object4 = Promise.force(start);
        try {
            int sindex = ((Number)object4).intValue();
            index2 = sindex - 1;
        }
        catch (ClassCastException classCastException) {
            void index2;
            throw new WrongType(classCastException, "sindex", -2, (Object)index2);
        }
        Object object5 = Promise.force(length);
        try {
            int len = ((Number)object5).intValue();
            int avail = slen - index2;
            rlen = len > avail ? avail : len;
        }
        catch (ClassCastException classCastException) {
            void avail;
            throw new WrongType(classCastException, "len", -2, (Object)avail);
        }
        object2 = s.substring(index2, index2 + rlen);
        return object2;
    }

    public static Object stringLength(Object string) {
        return string == Values.empty ? Values.empty : Integer.valueOf(((String)Promise.force(string, String.class)).length());
    }

    public static {
        Lit2 = Symbol.valueOf("string-length");
        Lit1 = Symbol.valueOf("substring");
        Lit0 = IntNum.valueOf(Integer.MAX_VALUE);
        XStrings xStrings = $instance = new XStrings();
        substring = new ModuleMethod(xStrings, 1, Lit1, 12290);
        string$Mnlength = new ModuleMethod(xStrings, 3, Lit2, 4097);
        XStrings.$runBody$();
    }

    public XStrings() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        if (moduleMethod.selector == 3) {
            callContext.value1 = object2;
            callContext.proc = moduleMethod;
            callContext.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            callContext.value1 = object2;
            callContext.value2 = object3;
            callContext.proc = moduleMethod;
            callContext.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            callContext.value1 = object2;
            callContext.value2 = object3;
            callContext.value3 = object4;
            callContext.proc = moduleMethod;
            callContext.pc = 3;
            return 0;
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        if (moduleMethod.selector == 3) {
            return XStrings.stringLength(object2);
        }
        return super.apply1(moduleMethod, object2);
    }

    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        if (moduleMethod.selector == 1) {
            return XStrings.substring(object2, object3);
        }
        return super.apply2(moduleMethod, object2, object3);
    }

    public Object apply3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4) {
        if (moduleMethod.selector == 1) {
            return XStrings.substring(object2, object3, object4);
        }
        return super.apply3(moduleMethod, object2, object3, object4);
    }
}

