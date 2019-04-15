/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.slib.ppfile;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.LocationProc;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.text.Char;
import kawa.lib.lists;
import kawa.lib.ports;

public class ppfile
extends ModuleBody {
    public static final ModuleMethod pprint$Mnfilter$Mnfile;
    public static final ModuleMethod pprint$Mnfile;
    static final Char Lit0;
    static final ModuleMethod lambda$Fn3;
    public static ppfile $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object pprintFilterFile$V(Object inport, Object filter, Object[] argsArray) {
        LList lList;
        Object object2;
        public class Frame
        extends ModuleBody {
            LList optarg;
            Object filter;
            final ModuleMethod fun$Fn1;

            public Frame() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 2, "fun", 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/ppfile.scm:27");
                this.fun$Fn1 = moduleMethod;
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public Object lambda1fun(Object port) {
                Object object2;
                OutPort outport;
                Object object3;
                Object object4;
                new Frame0().staticLink = this;
                public class Frame0
                extends ModuleBody {
                    Object port;
                    Frame staticLink;
                    final ModuleMethod fun$Fn2;

                    public Frame0() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 1, "fun", 4097);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/ppfile.scm:34");
                        this.fun$Fn2 = moduleMethod;
                    }

                    /*
                     * Loose catch block
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     * Lifted jumps to return sites
                     */
                    public Object lambda2fun(Object export2) {
                        Object object2 = Char.makeOrEof(ports.peekChar(this.port));
                        block4 : do {
                            java.lang.Boolean bl;
                            Object x;
                            Object c;
                            block16 : {
                                block15 : {
                                    boolean x2;
                                    boolean bl2 = x2 = Promise.force(c = object2) == gnu.lists.EofClass.eofValue;
                                    if (x2) {
                                        if (x2) {
                                            bl = java.lang.Boolean.TRUE;
                                            return bl;
                                        }
                                        bl = java.lang.Boolean.FALSE;
                                        return bl;
                                    }
                                    Object object3 = Promise.force(c);
                                    try {
                                        if (!kawa.lib.rnrs.unicode.isCharWhitespace(Char.castToCharacter(object3))) break block15;
                                    }
                                    catch (ClassCastException classCastException) {
                                        throw new WrongType(classCastException, "char-whitespace?", 1, x);
                                    }
                                    ports.display(Char.makeOrEof(ports.readChar(this.port)), export2);
                                    object2 = Char.makeOrEof(ports.peekChar(this.port));
                                    continue;
                                }
                                if (59 != Char.castToCharacter(Promise.force(c))) {
                                    x = Promise.force(this.port, gnu.kawa.io.InPort.class);
                                    Object o = ports.read((gnu.kawa.io.InPort)x);
                                    boolean bl3 = x = Promise.force(o) == gnu.lists.EofClass.eofValue;
                                    if (x) {
                                        if (x) {
                                            bl = java.lang.Boolean.TRUE;
                                            return bl;
                                        }
                                        bl = java.lang.Boolean.FALSE;
                                        return bl;
                                    }
                                    gnu.kawa.slib.pp.prettyPrint(((Procedure)kawa.standard.Scheme.applyToArgs).apply2(this.staticLink.filter, o), export2);
                                    Object c3 = Char.makeOrEof(ports.peekChar(this.port));
                                    if (gnu.kawa.functions.IsEqv.apply(ppfile.Lit0, c3)) {
                                        ports.readChar(this.port);
                                        c3 = Char.makeOrEof(ports.peekChar(this.port));
                                    }
                                    object2 = c3;
                                    continue;
                                }
                                break block16;
                                catch (ClassCastException classCastException) {
                                    throw new WrongType(classCastException, "read", 1, x);
                                }
                            }
                            Object object3 = c;
                            do {
                                Object c2;
                                if ((x = (Object)(Promise.force(c2 = object3) == gnu.lists.EofClass.eofValue)) != false) {
                                    if (x != false) {
                                        bl = java.lang.Boolean.TRUE;
                                        return bl;
                                    }
                                    bl = java.lang.Boolean.FALSE;
                                    return bl;
                                }
                                if (10 == Char.castToCharacter(Promise.force(c2))) {
                                    ports.display(Char.makeOrEof(ports.readChar(this.port)), export2);
                                    object2 = Char.makeOrEof(ports.peekChar(this.port));
                                    continue block4;
                                }
                                ports.display(Char.makeOrEof(ports.readChar(this.port)), export2);
                                object3 = Char.makeOrEof(ports.peekChar(this.port));
                            } while (true);
                            break;
                        } while (true);
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
                            return this.lambda2fun(object2);
                        }
                        return super.apply1(moduleMethod, object2);
                    }
                }
                Frame0 $heapFrame = new Frame0();
                $heapFrame.port = port;
                ModuleMethod fun = $heapFrame.fun$Fn2;
                if (lists.isNull(this.optarg)) {
                    object3 = ports.current$Mnoutput$Mnport.getValue();
                } else {
                    object2 = this.optarg;
                    object3 = outport = lists.car((Pair)object2);
                }
                if (ports.isOutputPort(outport)) {
                    object4 = $heapFrame.lambda2fun(outport);
                    return object4;
                }
                object2 = Promise.force(outport, Path.class);
                try {
                    object4 = ports.callWithOutputFile(Path.valueOf(object2), $heapFrame.fun$Fn2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "call-with-output-file", 1, object2);
                }
                return object4;
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, object2);
                }
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

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply1(ModuleMethod moduleMethod, Object object2) {
                if (moduleMethod.selector == 2) {
                    return this.lambda1fun(object2);
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame $heapFrame = new Frame();
        $heapFrame.filter = filter;
        $heapFrame.optarg = lList = LList.makeList(argsArray, 0);
        ModuleMethod fun = $heapFrame.fun$Fn1;
        if (ports.isInputPort(inport)) {
            object2 = $heapFrame.lambda1fun(inport);
            return object2;
        }
        Object object3 = Promise.force(inport, Path.class);
        try {
            object2 = ports.callWithInputFile(Path.valueOf(object3), $heapFrame.fun$Fn1);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "call-with-input-file", 1, object3);
        }
        return object2;
    }

    public static Object pprintFile(Object object2) {
        return ppfile.pprintFile(object2, ports.current$Mnoutput$Mnport.getValue());
    }

    public static Object pprintFile(Object ifile, Object oport) {
        return ppfile.pprintFilterFile$V(ifile, lambda$Fn3, new Object[]{oport});
    }

    static Object lambda3(Object x) {
        return x;
    }

    public static {
        Lit2 = Symbol.valueOf("pprint-file");
        Lit1 = Symbol.valueOf("pprint-filter-file");
        Lit0 = Char.valueOf(10);
        ppfile ppfile2 = $instance = new ppfile();
        pprint$Mnfilter$Mnfile = new ModuleMethod(ppfile2, 3, Lit1, -4094);
        ModuleMethod moduleMethod = new ModuleMethod(ppfile2, 4, null, 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/ppfile.scm:70");
        lambda$Fn3 = moduleMethod;
        pprint$Mnfile = new ModuleMethod(ppfile2, 5, Lit2, 8193);
        ppfile.$runBody$();
    }

    public ppfile() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 5: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        if (moduleMethod.selector == 5) {
            callContext.value1 = object2;
            callContext.value2 = object3;
            callContext.proc = moduleMethod;
            callContext.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        if (moduleMethod.selector == 3) {
            callContext.values = arrobject;
            callContext.proc = moduleMethod;
            callContext.pc = 5;
            return 0;
        }
        return super.matchN(moduleMethod, arrobject, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 4: {
                return ppfile.lambda3(object2);
            }
            case 5: {
                return ppfile.pprintFile(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
    }

    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        if (moduleMethod.selector == 5) {
            return ppfile.pprintFile(object2, object3);
        }
        return super.apply2(moduleMethod, object2, object3);
    }

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        if (moduleMethod.selector == 3) {
            int n = arrobject.length - 2;
            Object[] arrobject2 = new Object[n];
            while (--n >= 0) {
                arrobject2 = arrobject2;
                arrobject2[n] = arrobject[n + 2];
            }
            return ppfile.pprintFilterFile$V(arrobject[0], arrobject[1], arrobject2);
        }
        return super.applyN(moduleMethod, arrobject);
    }

}

