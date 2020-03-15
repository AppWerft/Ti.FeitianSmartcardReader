// 
// Decompiled by Procyon v0.5.36
// 

package gnu.commonlisp.lisp;

import gnu.expr.ModuleInfo;
import gnu.kawa.format.AbstractFormat;
import gnu.mapping.WrongType;
import kawa.lib.ports;
import gnu.kawa.io.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.NumberCompare;
import kawa.lib.strings;
import gnu.commonlisp.lang.CommonLisp;
import gnu.lists.FString;
import gnu.lists.SimpleVector;
import gnu.lists.Sequence;
import gnu.mapping.Environment;
import gnu.mapping.Symbol;
import gnu.lists.LList;
import gnu.mapping.Values;
import gnu.mapping.PropertyLocation;
import gnu.commonlisp.lang.Symbols;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.math.IntNum;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class PrimOps extends ModuleBody
{
    public static final ModuleMethod boundp;
    public static final ModuleMethod symbolp;
    public static final ModuleMethod symbol$Mnname;
    public static final ModuleMethod symbol$Mnplist;
    public static final ModuleMethod setplist;
    public static final ModuleMethod plist$Mnget;
    public static final ModuleMethod plist$Mnput;
    public static final ModuleMethod plist$Mnremprop;
    public static final ModuleMethod plist$Mnmember;
    public static final ModuleMethod get;
    public static final ModuleMethod put;
    public static final ModuleMethod symbol$Mnvalue;
    public static final ModuleMethod set;
    public static final ModuleMethod symbol$Mnfunction;
    public static final ModuleMethod fset;
    public static final ModuleMethod length;
    public static final ModuleMethod arrayp;
    public static final ModuleMethod aref;
    public static final ModuleMethod aset;
    public static final ModuleMethod fillarray;
    public static final ModuleMethod stringp;
    public static final ModuleMethod make$Mnstring;
    public static final ModuleMethod substring;
    public static final ModuleMethod char$Mnto$Mnstring;
    public static final ModuleMethod functionp;
    public static final ModuleMethod princ;
    public static final ModuleMethod prin1;
    static final SimpleSymbol Lit0;
    static final IntNum Lit1;
    public static PrimOps $instance;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static boolean boundp(final Object symbol) {
        return Symbols.isBound(symbol);
    }
    
    public static boolean symbolp(final Object x) {
        return Symbols.isSymbol(x);
    }
    
    public static Object symbolName(final Object symbol) {
        return Symbols.getPrintName(symbol);
    }
    
    public static Object symbolPlist(final Object symbol) {
        return PropertyLocation.getPropertyList(symbol);
    }
    
    public static Object setplist(final Object symbol, final Object plist) {
        PropertyLocation.setPropertyList(symbol, plist);
        return plist;
    }
    
    public static Object plistGet(final Object plist, final Object prop) {
        return plistGet(plist, prop, Boolean.FALSE);
    }
    
    public static Object plistGet(final Object plist, final Object prop, final Object default) {
        return PropertyLocation.plistGet(plist, prop, default);
    }
    
    public static Object plistPut(final Object plist, final Object prop, final Object value) {
        return PropertyLocation.plistPut(plist, prop, value);
    }
    
    public static Object plistRemprop(final Object plist, final Object prop) {
        return PropertyLocation.plistRemove(plist, prop);
    }
    
    public static Object plistMember(final Object plist, final Object prop) {
        return (PropertyLocation.plistGet(plist, prop, Values.empty) == Values.empty) ? LList.Empty : PrimOps.Lit0;
    }
    
    public static Object get(final Symbol symbol, final Object property) {
        return get(symbol, property, LList.Empty);
    }
    
    public static Object get(final Symbol symbol, final Object property, final Object default) {
        return PropertyLocation.getProperty(symbol, property, default);
    }
    
    public static void put(final Object symbol, final Object property, final Object value) {
        PropertyLocation.putProperty(symbol, property, value);
    }
    
    public static Object symbolValue(final Object sym) {
        return Environment.getCurrent().get(Symbols.getSymbol(sym));
    }
    
    public static void set(final Object symbol, final Object value) {
        Environment.getCurrent().put(Symbols.getSymbol(symbol), value);
    }
    
    public static Object symbolFunction(final Object symbol) {
        return Symbols.getFunctionBinding(symbol);
    }
    
    public static void fset(final Object symbol, final Object object) {
        Symbols.setFunctionBinding(Environment.getCurrent(), symbol, object);
    }
    
    public static int length(final Sequence x) {
        return x.size();
    }
    
    public static boolean arrayp(final Object x) {
        return x instanceof SimpleVector;
    }
    
    public static Object aref(final SimpleVector array, final int k) {
        return array.get(k);
    }
    
    public static Object aset(final SimpleVector array, final int k, final Object obj) {
        array.set(k, obj);
        return obj;
    }
    
    public static Object fillarray(final SimpleVector array, final Object obj) {
        array.fill(obj);
        return obj;
    }
    
    public static boolean stringp(final Object x) {
        return x instanceof CharSequence;
    }
    
    public static FString makeString(final int count, final Object ch) {
        return new FString(count, CommonLisp.asChar(ch));
    }
    
    public static FString substring(final CharSequence str, final Object from) {
        return substring(str, from, LList.Empty);
    }
    
    public static FString substring(final CharSequence str, Object from, Object to) {
        if (to == LList.Empty) {
            to = strings.stringLength(str);
        }
        if (NumberCompare.$Ls(to, PrimOps.Lit1)) {
            to = AddOp.apply2(-1, strings.stringLength(str), to);
        }
        if (NumberCompare.$Ls(from, PrimOps.Lit1)) {
            from = AddOp.apply2(-1, strings.stringLength(str), from);
        }
        return new FString(str, ((Number)Promise.force(from)).intValue(), ((Number)Promise.force(AddOp.apply2(-1, to, from))).intValue());
    }
    
    public static FString charToString(final Object ch) {
        return new FString(1, CommonLisp.asChar(ch));
    }
    
    public static boolean functionp(final Object x) {
        return x instanceof Procedure;
    }
    
    public static void princ(final Object value) {
        princ(value, ports.current$Mnoutput$Mnport.getValue());
    }
    
    public static void princ(final Object value, final Object out) {
        final AbstractFormat displayFormat = CommonLisp.displayFormat;
        final Object force = Promise.force(out, Consumer.class);
        try {
            displayFormat.format(value, (Consumer)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "gnu.kawa.format.AbstractFormat.format(java.lang.Object,gnu.lists.Consumer)", 3, force);
        }
    }
    
    public static void prin1(final Object value) {
        prin1(value, ports.current$Mnoutput$Mnport.getValue());
    }
    
    public static void prin1(final Object value, final Object out) {
        final AbstractFormat writeFormat = CommonLisp.writeFormat;
        final Object force = Promise.force(out, Consumer.class);
        try {
            writeFormat.format(value, (Consumer)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "gnu.kawa.format.AbstractFormat.format(java.lang.Object,gnu.lists.Consumer)", 3, force);
        }
    }
    
    static {
        Lit28 = Symbol.valueOf("prin1");
        Lit27 = Symbol.valueOf("princ");
        Lit26 = Symbol.valueOf("functionp");
        Lit25 = Symbol.valueOf("char-to-string");
        Lit24 = Symbol.valueOf("substring");
        Lit23 = Symbol.valueOf("make-string");
        Lit22 = Symbol.valueOf("stringp");
        Lit21 = Symbol.valueOf("fillarray");
        Lit20 = Symbol.valueOf("aset");
        Lit19 = Symbol.valueOf("aref");
        Lit18 = Symbol.valueOf("arrayp");
        Lit17 = Symbol.valueOf("length");
        Lit16 = Symbol.valueOf("fset");
        Lit15 = Symbol.valueOf("symbol-function");
        Lit14 = Symbol.valueOf("set");
        Lit13 = Symbol.valueOf("symbol-value");
        Lit12 = Symbol.valueOf("put");
        Lit11 = Symbol.valueOf("get");
        Lit10 = Symbol.valueOf("plist-member");
        Lit9 = Symbol.valueOf("plist-remprop");
        Lit8 = Symbol.valueOf("plist-put");
        Lit7 = Symbol.valueOf("plist-get");
        Lit6 = Symbol.valueOf("setplist");
        Lit5 = Symbol.valueOf("symbol-plist");
        Lit4 = Symbol.valueOf("symbol-name");
        Lit3 = Symbol.valueOf("symbolp");
        Lit2 = Symbol.valueOf("boundp");
        Lit1 = IntNum.valueOf(0);
        Lit0 = Symbol.valueOf("t");
        PrimOps.$instance = new PrimOps();
        final PrimOps $instance = PrimOps.$instance;
        boundp = new ModuleMethod($instance, 1, PrimOps.Lit2, 4097);
        symbolp = new ModuleMethod($instance, 2, PrimOps.Lit3, 4097);
        symbol$Mnname = new ModuleMethod($instance, 3, PrimOps.Lit4, 4097);
        symbol$Mnplist = new ModuleMethod($instance, 4, PrimOps.Lit5, 4097);
        setplist = new ModuleMethod($instance, 5, PrimOps.Lit6, 8194);
        plist$Mnget = new ModuleMethod($instance, 6, PrimOps.Lit7, 12290);
        plist$Mnput = new ModuleMethod($instance, 8, PrimOps.Lit8, 12291);
        plist$Mnremprop = new ModuleMethod($instance, 9, PrimOps.Lit9, 8194);
        plist$Mnmember = new ModuleMethod($instance, 10, PrimOps.Lit10, 8194);
        get = new ModuleMethod($instance, 11, PrimOps.Lit11, 12290);
        put = new ModuleMethod($instance, 13, PrimOps.Lit12, 12291);
        symbol$Mnvalue = new ModuleMethod($instance, 14, PrimOps.Lit13, 4097);
        set = new ModuleMethod($instance, 15, PrimOps.Lit14, 8194);
        symbol$Mnfunction = new ModuleMethod($instance, 16, PrimOps.Lit15, 4097);
        fset = new ModuleMethod($instance, 17, PrimOps.Lit16, 8194);
        length = new ModuleMethod($instance, 18, PrimOps.Lit17, 4097);
        arrayp = new ModuleMethod($instance, 19, PrimOps.Lit18, 4097);
        aref = new ModuleMethod($instance, 20, PrimOps.Lit19, 8194);
        aset = new ModuleMethod($instance, 21, PrimOps.Lit20, 12291);
        fillarray = new ModuleMethod($instance, 22, PrimOps.Lit21, 8194);
        stringp = new ModuleMethod($instance, 23, PrimOps.Lit22, 4097);
        make$Mnstring = new ModuleMethod($instance, 24, PrimOps.Lit23, 8194);
        substring = new ModuleMethod($instance, 25, PrimOps.Lit24, 12290);
        char$Mnto$Mnstring = new ModuleMethod($instance, 27, PrimOps.Lit25, 4097);
        functionp = new ModuleMethod($instance, 28, PrimOps.Lit26, 4097);
        princ = new ModuleMethod($instance, 29, PrimOps.Lit27, 8193);
        prin1 = new ModuleMethod($instance, 31, PrimOps.Lit28, 8193);
        $runBody$();
    }
    
    public PrimOps() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 31: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 29: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 28: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 27: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 23: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 19: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 18: {
                final Object force = Promise.force(o, Sequence.class);
                if (!(force instanceof Sequence)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 16: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 14: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 3: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 31: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 29: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 25: {
                final Object force = Promise.force(o, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value1 = force;
                    ctx.value2 = o2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 24: {
                ctx.value1 = Promise.force(o);
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 22: {
                final Object force2 = Promise.force(o, SimpleVector.class);
                if (!(force2 instanceof SimpleVector)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 20: {
                final Object force3 = Promise.force(o, SimpleVector.class);
                if (!(force3 instanceof SimpleVector)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.value2 = Promise.force(o2);
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 17: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 15: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 11: {
                final Object force4 = Promise.force(o, Symbol.class);
                if (!(force4 instanceof Symbol)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 10: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 9: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 6: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 5: {
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
    public int match3(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        switch (proc.selector) {
            case 25: {
                final Object force = Promise.force(arg1, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value1 = force;
                    ctx.value2 = arg2;
                    ctx.value3 = arg3;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 21: {
                final Object force2 = Promise.force(arg1, SimpleVector.class);
                if (!(force2 instanceof SimpleVector)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.value2 = Promise.force(arg2);
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 13: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 11: {
                final Object force3 = Promise.force(arg1, Symbol.class);
                if (!(force3 instanceof Symbol)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 8: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 6: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            default: {
                return super.match3(proc, arg1, arg2, arg3, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object argValue) {
    Label_0246_Outer:
        while (true) {
        Label_0262_Outer:
            while (true) {
            Label_0207_Outer:
                while (true) {
                Label_0190_Outer:
                    while (true) {
                    Label_0229_Outer:
                        while (true) {
                        Label_0254_Outer:
                            while (true) {
                                while (true) {
                                    switch (method.selector) {
                                        case 1: {
                                            return boundp(argValue) ? Boolean.TRUE : Boolean.FALSE;
                                        }
                                        case 2: {
                                            return symbolp(argValue) ? Boolean.TRUE : Boolean.FALSE;
                                        }
                                        case 3: {
                                            return symbolName(argValue);
                                        }
                                        case 4: {
                                            return symbolPlist(argValue);
                                        }
                                        case 14: {
                                            return symbolValue(argValue);
                                        }
                                        case 16: {
                                            return symbolFunction(argValue);
                                        }
                                        case 18: {
                                            final Object force = Promise.force(argValue, Sequence.class);
                                            try {
                                                return length((Sequence)force);
                                                return charToString(argValue);
                                                princ(argValue);
                                                return Values.empty;
                                                return super.apply1(method, argValue);
                                                return stringp(argValue) ? Boolean.TRUE : Boolean.FALSE;
                                                return arrayp(argValue) ? Boolean.TRUE : Boolean.FALSE;
                                                return functionp(argValue) ? Boolean.TRUE : Boolean.FALSE;
                                                prin1(argValue);
                                                return Values.empty;
                                            }
                                            catch (ClassCastException ex) {
                                                throw new WrongType(ex, "length", 1, argValue);
                                            }
                                            break;
                                        }
                                        case 19: {
                                            continue Label_0229_Outer;
                                        }
                                        case 23: {
                                            continue Label_0190_Outer;
                                        }
                                        case 27: {
                                            continue Label_0246_Outer;
                                        }
                                        case 28: {
                                            continue Label_0254_Outer;
                                        }
                                        case 29: {
                                            continue Label_0262_Outer;
                                        }
                                        case 31: {
                                            continue;
                                        }
                                        default: {
                                            continue Label_0207_Outer;
                                        }
                                    }
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    break;
                }
                break;
            }
            break;
        }
    }
    
    @Override
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //               10: 128
        //               11: 134
        //               12: 269
        //               13: 269
        //               14: 140
        //               15: 146
        //               16: 152
        //               17: 269
        //               18: 269
        //               19: 269
        //               20: 167
        //               21: 269
        //               22: 176
        //               23: 269
        //               24: 269
        //               25: 185
        //               26: 269
        //               27: 208
        //               28: 269
        //               29: 222
        //               30: 237
        //               31: 269
        //               32: 269
        //               33: 269
        //               34: 251
        //               35: 269
        //               36: 260
        //          default: 269
        //        }
        //   128: aload_2        
        //   129: aload_3        
        //   130: invokestatic    gnu/commonlisp/lisp/PrimOps.setplist:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   133: areturn        
        //   134: aload_2        
        //   135: aload_3        
        //   136: invokestatic    gnu/commonlisp/lisp/PrimOps.plistGet:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   139: areturn        
        //   140: aload_2        
        //   141: aload_3        
        //   142: invokestatic    gnu/commonlisp/lisp/PrimOps.plistRemprop:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   145: areturn        
        //   146: aload_2        
        //   147: aload_3        
        //   148: invokestatic    gnu/commonlisp/lisp/PrimOps.plistMember:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   151: areturn        
        //   152: aload_2        
        //   153: ldc_w           Lgnu/mapping/Symbol;.class
        //   156: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   159: checkcast       Lgnu/mapping/Symbol;
        //   162: aload_3        
        //   163: invokestatic    gnu/commonlisp/lisp/PrimOps.get:(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;
        //   166: areturn        
        //   167: aload_2        
        //   168: aload_3        
        //   169: invokestatic    gnu/commonlisp/lisp/PrimOps.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   172: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   175: areturn        
        //   176: aload_2        
        //   177: aload_3        
        //   178: invokestatic    gnu/commonlisp/lisp/PrimOps.fset:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   181: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   184: areturn        
        //   185: aload_2        
        //   186: ldc             Lgnu/lists/SimpleVector;.class
        //   188: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   191: checkcast       Lgnu/lists/SimpleVector;
        //   194: aload_3        
        //   195: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   198: checkcast       Ljava/lang/Number;
        //   201: invokevirtual   java/lang/Number.intValue:()I
        //   204: invokestatic    gnu/commonlisp/lisp/PrimOps.aref:(Lgnu/lists/SimpleVector;I)Ljava/lang/Object;
        //   207: areturn        
        //   208: aload_2        
        //   209: ldc             Lgnu/lists/SimpleVector;.class
        //   211: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   214: checkcast       Lgnu/lists/SimpleVector;
        //   217: aload_3        
        //   218: invokestatic    gnu/commonlisp/lisp/PrimOps.fillarray:(Lgnu/lists/SimpleVector;Ljava/lang/Object;)Ljava/lang/Object;
        //   221: areturn        
        //   222: aload_2        
        //   223: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   226: checkcast       Ljava/lang/Number;
        //   229: invokevirtual   java/lang/Number.intValue:()I
        //   232: aload_3        
        //   233: invokestatic    gnu/commonlisp/lisp/PrimOps.makeString:(ILjava/lang/Object;)Lgnu/lists/FString;
        //   236: areturn        
        //   237: aload_2        
        //   238: ldc             Ljava/lang/CharSequence;.class
        //   240: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   243: checkcast       Ljava/lang/CharSequence;
        //   246: aload_3        
        //   247: invokestatic    gnu/commonlisp/lisp/PrimOps.substring:(Ljava/lang/CharSequence;Ljava/lang/Object;)Lgnu/lists/FString;
        //   250: areturn        
        //   251: aload_2        
        //   252: aload_3        
        //   253: invokestatic    gnu/commonlisp/lisp/PrimOps.princ:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   256: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   259: areturn        
        //   260: aload_2        
        //   261: aload_3        
        //   262: invokestatic    gnu/commonlisp/lisp/PrimOps.prin1:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   265: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   268: areturn        
        //   269: aload_0        
        //   270: aload_1        
        //   271: aload_2        
        //   272: aload_3        
        //   273: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   276: areturn        
        //   277: new             Lgnu/mapping/WrongType;
        //   280: dup_x1         
        //   281: swap           
        //   282: ldc_w           "get"
        //   285: iconst_1       
        //   286: aload_2        
        //   287: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   290: athrow         
        //   291: new             Lgnu/mapping/WrongType;
        //   294: dup_x1         
        //   295: swap           
        //   296: ldc_w           "aref"
        //   299: iconst_1       
        //   300: aload_2        
        //   301: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   304: athrow         
        //   305: new             Lgnu/mapping/WrongType;
        //   308: dup_x1         
        //   309: swap           
        //   310: ldc_w           "aref"
        //   313: iconst_2       
        //   314: aload_3        
        //   315: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   318: athrow         
        //   319: new             Lgnu/mapping/WrongType;
        //   322: dup_x1         
        //   323: swap           
        //   324: ldc_w           "fillarray"
        //   327: iconst_1       
        //   328: aload_2        
        //   329: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   332: athrow         
        //   333: new             Lgnu/mapping/WrongType;
        //   336: dup_x1         
        //   337: swap           
        //   338: ldc_w           "make-string"
        //   341: iconst_1       
        //   342: aload_2        
        //   343: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   346: athrow         
        //   347: new             Lgnu/mapping/WrongType;
        //   350: dup_x1         
        //   351: swap           
        //   352: ldc_w           "substring"
        //   355: iconst_1       
        //   356: aload_2        
        //   357: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   360: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  159    162    277    291    Ljava/lang/ClassCastException;
        //  191    194    291    305    Ljava/lang/ClassCastException;
        //  198    204    305    319    Ljava/lang/ClassCastException;
        //  214    217    319    333    Ljava/lang/ClassCastException;
        //  226    232    333    347    Ljava/lang/ClassCastException;
        //  243    246    347    361    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 131 out of bounds for length 131
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply3(final ModuleMethod p0, final Object p1, final Object p2, final Object p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                6: 64
        //                8: 72
        //               11: 80
        //               13: 97
        //               21: 108
        //               25: 133
        //          default: 149
        //        }
        //    64: aload_2        
        //    65: aload_3        
        //    66: aload           4
        //    68: invokestatic    gnu/commonlisp/lisp/PrimOps.plistGet:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    71: areturn        
        //    72: aload_2        
        //    73: aload_3        
        //    74: aload           4
        //    76: invokestatic    gnu/commonlisp/lisp/PrimOps.plistPut:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    79: areturn        
        //    80: aload_2        
        //    81: ldc_w           Lgnu/mapping/Symbol;.class
        //    84: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    87: checkcast       Lgnu/mapping/Symbol;
        //    90: aload_3        
        //    91: aload           4
        //    93: invokestatic    gnu/commonlisp/lisp/PrimOps.get:(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    96: areturn        
        //    97: aload_2        
        //    98: aload_3        
        //    99: aload           4
        //   101: invokestatic    gnu/commonlisp/lisp/PrimOps.put:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   104: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   107: areturn        
        //   108: aload_2        
        //   109: ldc             Lgnu/lists/SimpleVector;.class
        //   111: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   114: checkcast       Lgnu/lists/SimpleVector;
        //   117: aload_3        
        //   118: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   121: checkcast       Ljava/lang/Number;
        //   124: invokevirtual   java/lang/Number.intValue:()I
        //   127: aload           4
        //   129: invokestatic    gnu/commonlisp/lisp/PrimOps.aset:(Lgnu/lists/SimpleVector;ILjava/lang/Object;)Ljava/lang/Object;
        //   132: areturn        
        //   133: aload_2        
        //   134: ldc             Ljava/lang/CharSequence;.class
        //   136: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   139: checkcast       Ljava/lang/CharSequence;
        //   142: aload_3        
        //   143: aload           4
        //   145: invokestatic    gnu/commonlisp/lisp/PrimOps.substring:(Ljava/lang/CharSequence;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/FString;
        //   148: areturn        
        //   149: aload_0        
        //   150: aload_1        
        //   151: aload_2        
        //   152: aload_3        
        //   153: aload           4
        //   155: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   158: areturn        
        //   159: new             Lgnu/mapping/WrongType;
        //   162: dup_x1         
        //   163: swap           
        //   164: ldc_w           "get"
        //   167: iconst_1       
        //   168: aload_2        
        //   169: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   172: athrow         
        //   173: new             Lgnu/mapping/WrongType;
        //   176: dup_x1         
        //   177: swap           
        //   178: ldc_w           "aset"
        //   181: iconst_1       
        //   182: aload_2        
        //   183: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   186: athrow         
        //   187: new             Lgnu/mapping/WrongType;
        //   190: dup_x1         
        //   191: swap           
        //   192: ldc_w           "aset"
        //   195: iconst_2       
        //   196: aload_3        
        //   197: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   200: athrow         
        //   201: new             Lgnu/mapping/WrongType;
        //   204: dup_x1         
        //   205: swap           
        //   206: ldc_w           "substring"
        //   209: iconst_1       
        //   210: aload_2        
        //   211: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   214: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  87     90     159    173    Ljava/lang/ClassCastException;
        //  114    117    173    187    Ljava/lang/ClassCastException;
        //  121    127    187    201    Ljava/lang/ClassCastException;
        //  139    142    201    215    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 85 out of bounds for length 85
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
