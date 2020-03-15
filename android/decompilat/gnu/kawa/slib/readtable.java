// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.mapping.Values;
import gnu.kawa.lispexpr.LangObjType;
import gnu.text.Char;
import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.kawa.lispexpr.ReaderDispatchMacro;
import gnu.kawa.lispexpr.ReaderDispatch;
import gnu.mapping.WrongType;
import gnu.kawa.lispexpr.ReaderMacro;
import gnu.mapping.Promise;
import gnu.mapping.Procedure;
import gnu.kawa.lispexpr.ReadTable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class readtable extends ModuleBody
{
    public static final ModuleMethod current$Mnreadtable;
    public static final ModuleMethod readtable$Qu;
    public static final ModuleMethod set$Mnmacro$Mncharacter;
    public static final ModuleMethod make$Mndispatch$Mnmacro$Mncharacter;
    public static final ModuleMethod set$Mndispatch$Mnmacro$Mncharacter;
    public static final ModuleMethod get$Mndispatch$Mnmacro$Mntable;
    public static final ModuleMethod define$Mnreader$Mnctor;
    public static readtable $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static ReadTable currentReadtable() {
        return ReadTable.getCurrent();
    }
    
    public static boolean isReadtable(final Object obj) {
        return obj instanceof ReadTable;
    }
    
    public static void setMacroCharacter(final char c, final Object o) {
        setMacroCharacter(c, o, false);
    }
    
    public static void setMacroCharacter(final char char1, final Object function, final boolean non$Mnterminating) {
        setMacroCharacter(char1, function, non$Mnterminating, currentReadtable());
    }
    
    public static void setMacroCharacter(final char char, final Object function, final boolean non$Mnterminating, final ReadTable readtable) {
        final Object force = Promise.force(function, Procedure.class);
        try {
            readtable.set(char, new ReaderMacro((Procedure)force, non$Mnterminating));
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "gnu.kawa.lispexpr.ReaderMacro.<init>(gnu.mapping.Procedure,boolean)", 1, force);
        }
    }
    
    public static void makeDispatchMacroCharacter(final char c) {
        makeDispatchMacroCharacter(c, false);
    }
    
    public static void makeDispatchMacroCharacter(final char char1, final boolean non$Mnterminating) {
        makeDispatchMacroCharacter(char1, non$Mnterminating, currentReadtable());
    }
    
    public static void makeDispatchMacroCharacter(final char char, final boolean non$Mnterminating, final ReadTable readtable) {
        readtable.set(char, new ReaderDispatch(non$Mnterminating));
    }
    
    public static void setDispatchMacroCharacter(final char disp$Mnchar, final char sub$Mnchar, final Object function) {
        setDispatchMacroCharacter(disp$Mnchar, sub$Mnchar, function, currentReadtable());
    }
    
    public static void setDispatchMacroCharacter(final char disp$Mnchar, final char sub$Mnchar, final Object function, final ReadTable readtable) {
        Object o;
        final ReadTableEntry readTableEntry = (ReadTableEntry)(o = readtable.lookup(disp$Mnchar));
        ReaderDispatch readerDispatch;
        Object o2;
        try {
            final ReaderDispatch entry = readerDispatch = (ReaderDispatch)readTableEntry;
            o2 = (o = Promise.force(function, Procedure.class));
            final Procedure procedure = (Procedure)o2;
            final ReaderDispatchMacro readerDispatchMacro = new ReaderDispatchMacro(procedure);
            readerDispatch.set(sub$Mnchar, readerDispatchMacro);
            return;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "entry", -2, o);
        }
        try {
            final Procedure procedure = (Procedure)o2;
            final ReaderDispatchMacro readerDispatchMacro = new ReaderDispatchMacro(procedure);
            readerDispatch.set(sub$Mnchar, readerDispatchMacro);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "gnu.kawa.lispexpr.ReaderDispatchMacro.<init>(gnu.mapping.Procedure)", 1, o);
        }
    }
    
    public static Object getDispatchMacroTable(final char disp$Mnchar, final char sub$Mnchar) {
        return getDispatchMacroTable(disp$Mnchar, sub$Mnchar, currentReadtable());
    }
    
    public static Object getDispatchMacroTable(final char disp$Mnchar, final char sub$Mnchar, final ReadTable readtable) {
        final ReadTableEntry lookup = readtable.lookup(disp$Mnchar);
        try {
            final ReaderDispatch disp$Mnentry = (ReaderDispatch)lookup;
            final ReadTableEntry sub$Mnentry = disp$Mnentry.lookup(sub$Mnchar);
            return (sub$Mnentry == null) ? Boolean.FALSE : sub$Mnentry;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "disp-entry", -2, lookup);
        }
    }
    
    public static void defineReaderCtor(final SimpleSymbol key, final Procedure proc) {
        defineReaderCtor(key, proc, currentReadtable());
    }
    
    public static void defineReaderCtor(final SimpleSymbol key, final Procedure proc, final ReadTable readtable) {
        readtable.putReaderCtor(key.getName(), proc);
    }
    
    static {
        Lit6 = Symbol.valueOf("define-reader-ctor");
        Lit5 = Symbol.valueOf("get-dispatch-macro-table");
        Lit4 = Symbol.valueOf("set-dispatch-macro-character");
        Lit3 = Symbol.valueOf("make-dispatch-macro-character");
        Lit2 = Symbol.valueOf("set-macro-character");
        Lit1 = Symbol.valueOf("readtable?");
        Lit0 = Symbol.valueOf("current-readtable");
        readtable.$instance = new readtable();
        final readtable $instance = readtable.$instance;
        current$Mnreadtable = new ModuleMethod($instance, 1, readtable.Lit0, 0);
        readtable$Qu = new ModuleMethod($instance, 2, readtable.Lit1, 4097);
        set$Mnmacro$Mncharacter = new ModuleMethod($instance, 3, readtable.Lit2, 16386);
        make$Mndispatch$Mnmacro$Mncharacter = new ModuleMethod($instance, 6, readtable.Lit3, 12289);
        set$Mndispatch$Mnmacro$Mncharacter = new ModuleMethod($instance, 9, readtable.Lit4, 16387);
        get$Mndispatch$Mnmacro$Mntable = new ModuleMethod($instance, 11, readtable.Lit5, 12290);
        define$Mnreader$Mnctor = new ModuleMethod($instance, 13, readtable.Lit6, 12290);
        $runBody$();
    }
    
    public readtable() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
        if (moduleMethod.selector == 1) {
            ctx.proc = moduleMethod;
            return ctx.pc = 0;
        }
        return super.match0(moduleMethod, ctx);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 6: {
                final Object force = Promise.force(arg1);
                if (Char.checkCharOrEof(force) >>> 16 == 0) {
                    ctx.value1 = force;
                    ctx.proc = proc;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 2: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(proc, arg1, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 13: {
                final Object force = Promise.force(arg1, SimpleSymbol.class);
                if (!(force instanceof SimpleSymbol)) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force2) != null) {
                    ctx.value2 = force2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 11: {
                final Object force3 = Promise.force(arg1);
                if (Char.checkCharOrEof(force3) >>> 16 != 0) {
                    return -786431;
                }
                ctx.value1 = force3;
                final Object force4 = Promise.force(arg2);
                if (Char.checkCharOrEof(force4) >>> 16 == 0) {
                    ctx.value2 = force4;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 6: {
                final Object force5 = Promise.force(arg1);
                if (Char.checkCharOrEof(force5) >>> 16 != 0) {
                    return -786431;
                }
                ctx.value1 = force5;
                final Object force6 = Promise.force(arg2);
                if (force6 instanceof Boolean) {
                    ctx.value2 = force6;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 3: {
                final Object force7 = Promise.force(arg1);
                if (Char.checkCharOrEof(force7) >>> 16 == 0) {
                    ctx.value1 = force7;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            default: {
                return super.match2(proc, arg1, arg2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 13: {
                final Object force = Promise.force(o, SimpleSymbol.class);
                if (!(force instanceof SimpleSymbol)) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(o2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force2) == null) {
                    return -786430;
                }
                ctx.value2 = force2;
                final Object force3 = Promise.force(o3, ReadTable.class);
                if (!(force3 instanceof ReadTable)) {
                    return -786429;
                }
                ctx.value3 = force3;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 11: {
                final Object force4 = Promise.force(o);
                if (Char.checkCharOrEof(force4) >>> 16 != 0) {
                    return -786431;
                }
                ctx.value1 = force4;
                final Object force5 = Promise.force(o2);
                if (Char.checkCharOrEof(force5) >>> 16 != 0) {
                    return -786430;
                }
                ctx.value2 = force5;
                final Object force6 = Promise.force(o3, ReadTable.class);
                if (!(force6 instanceof ReadTable)) {
                    return -786429;
                }
                ctx.value3 = force6;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 9: {
                final Object force7 = Promise.force(o);
                if (Char.checkCharOrEof(force7) >>> 16 != 0) {
                    return -786431;
                }
                ctx.value1 = force7;
                final Object force8 = Promise.force(o2);
                if (Char.checkCharOrEof(force8) >>> 16 == 0) {
                    ctx.value2 = force8;
                    ctx.value3 = o3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786430;
            }
            case 6: {
                final Object force9 = Promise.force(o);
                if (Char.checkCharOrEof(force9) >>> 16 != 0) {
                    return -786431;
                }
                ctx.value1 = force9;
                final Object force10 = Promise.force(o2);
                if (!(force10 instanceof Boolean)) {
                    return -786430;
                }
                ctx.value2 = force10;
                final Object force11 = Promise.force(o3, ReadTable.class);
                if (!(force11 instanceof ReadTable)) {
                    return -786429;
                }
                ctx.value3 = force11;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 3: {
                final Object force12 = Promise.force(o);
                if (Char.checkCharOrEof(force12) >>> 16 != 0) {
                    return -786431;
                }
                ctx.value1 = force12;
                ctx.value2 = o2;
                final Object force13 = Promise.force(o3);
                if (force13 instanceof Boolean) {
                    ctx.value3 = force13;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            default: {
                return super.match3(moduleMethod, o, o2, o3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final Object arg4, final CallContext ctx) {
        switch (proc.selector) {
            case 9: {
                final Object force = Promise.force(arg1);
                if (Char.checkCharOrEof(force) >>> 16 != 0) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2);
                if (Char.checkCharOrEof(force2) >>> 16 != 0) {
                    return -786430;
                }
                ctx.value2 = force2;
                ctx.value3 = arg3;
                final Object force3 = Promise.force(arg4, ReadTable.class);
                if (!(force3 instanceof ReadTable)) {
                    return -786428;
                }
                ctx.value4 = force3;
                ctx.proc = proc;
                ctx.pc = 4;
                return 0;
            }
            case 3: {
                final Object force4 = Promise.force(arg1);
                if (Char.checkCharOrEof(force4) >>> 16 != 0) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.value2 = arg2;
                final Object force5 = Promise.force(arg3);
                if (!(force5 instanceof Boolean)) {
                    return -786429;
                }
                ctx.value3 = force5;
                final Object force6 = Promise.force(arg4, ReadTable.class);
                if (!(force6 instanceof ReadTable)) {
                    return -786428;
                }
                ctx.value4 = force6;
                ctx.proc = proc;
                ctx.pc = 4;
                return 0;
            }
            default: {
                return super.match4(proc, arg1, arg2, arg3, arg4, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply0(final ModuleMethod method) {
        if (method.selector == 1) {
            return currentReadtable();
        }
        return super.apply0(method);
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object o) {
        while (true) {
            switch (method.selector) {
                case 2: {
                    return isReadtable(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                case 6: {
                    final Object force = Promise.force(o);
                    try {
                        makeDispatchMacroCharacter(Char.castToChar(force));
                        return Values.empty;
                        return super.apply1(method, o);
                    }
                    catch (ClassCastException ex) {
                        throw new WrongType(ex, "make-dispatch-macro-character", 1, o);
                    }
                    break;
                }
                default: {
                    continue;
                }
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
        //     4: lookupswitch {
        //                3: 48
        //                6: 63
        //               11: 92
        //               13: 110
        //          default: 135
        //        }
        //    48: aload_2        
        //    49: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    52: invokestatic    gnu/text/Char.castToChar:(Ljava/lang/Object;)C
        //    55: aload_3        
        //    56: invokestatic    gnu/kawa/slib/readtable.setMacroCharacter:(CLjava/lang/Object;)V
        //    59: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    62: areturn        
        //    63: aload_2        
        //    64: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    67: invokestatic    gnu/text/Char.castToChar:(Ljava/lang/Object;)C
        //    70: aload_3        
        //    71: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    74: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    77: ifeq            84
        //    80: iconst_1       
        //    81: goto            85
        //    84: iconst_0       
        //    85: invokestatic    gnu/kawa/slib/readtable.makeDispatchMacroCharacter:(CZ)V
        //    88: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    91: areturn        
        //    92: aload_2        
        //    93: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    96: invokestatic    gnu/text/Char.castToChar:(Ljava/lang/Object;)C
        //    99: aload_3        
        //   100: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   103: invokestatic    gnu/text/Char.castToChar:(Ljava/lang/Object;)C
        //   106: invokestatic    gnu/kawa/slib/readtable.getDispatchMacroTable:(CC)Ljava/lang/Object;
        //   109: areturn        
        //   110: aload_2        
        //   111: ldc             Lgnu/mapping/SimpleSymbol;.class
        //   113: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   116: checkcast       Lgnu/mapping/SimpleSymbol;
        //   119: aload_3        
        //   120: ldc             Lgnu/mapping/Procedure;.class
        //   122: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   125: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   128: invokestatic    gnu/kawa/slib/readtable.defineReaderCtor:(Lgnu/mapping/SimpleSymbol;Lgnu/mapping/Procedure;)V
        //   131: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   134: areturn        
        //   135: aload_0        
        //   136: aload_1        
        //   137: aload_2        
        //   138: aload_3        
        //   139: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   142: areturn        
        //   143: new             Lgnu/mapping/WrongType;
        //   146: dup_x1         
        //   147: swap           
        //   148: ldc_w           "set-macro-character"
        //   151: iconst_1       
        //   152: aload_2        
        //   153: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   156: athrow         
        //   157: new             Lgnu/mapping/WrongType;
        //   160: dup_x1         
        //   161: swap           
        //   162: ldc_w           "make-dispatch-macro-character"
        //   165: iconst_1       
        //   166: aload_2        
        //   167: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   170: athrow         
        //   171: new             Lgnu/mapping/WrongType;
        //   174: dup_x1         
        //   175: swap           
        //   176: ldc_w           "make-dispatch-macro-character"
        //   179: iconst_2       
        //   180: aload_3        
        //   181: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   184: athrow         
        //   185: new             Lgnu/mapping/WrongType;
        //   188: dup_x1         
        //   189: swap           
        //   190: ldc_w           "get-dispatch-macro-table"
        //   193: iconst_1       
        //   194: aload_2        
        //   195: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   198: athrow         
        //   199: new             Lgnu/mapping/WrongType;
        //   202: dup_x1         
        //   203: swap           
        //   204: ldc_w           "get-dispatch-macro-table"
        //   207: iconst_2       
        //   208: aload_3        
        //   209: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   212: athrow         
        //   213: new             Lgnu/mapping/WrongType;
        //   216: dup_x1         
        //   217: swap           
        //   218: ldc_w           "define-reader-ctor"
        //   221: iconst_1       
        //   222: aload_2        
        //   223: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   226: athrow         
        //   227: new             Lgnu/mapping/WrongType;
        //   230: dup_x1         
        //   231: swap           
        //   232: ldc_w           "define-reader-ctor"
        //   235: iconst_2       
        //   236: aload_3        
        //   237: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   240: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  52     55     143    157    Ljava/lang/ClassCastException;
        //  67     70     157    171    Ljava/lang/ClassCastException;
        //  74     85     171    185    Ljava/lang/ClassCastException;
        //  96     99     185    199    Ljava/lang/ClassCastException;
        //  103    106    199    213    Ljava/lang/ClassCastException;
        //  116    119    213    227    Ljava/lang/ClassCastException;
        //  125    128    227    241    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 104 out of bounds for length 104
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
        //     4: tableswitch {
        //                6: 64
        //                7: 220
        //                8: 220
        //                9: 95
        //               10: 220
        //               11: 220
        //               12: 134
        //               13: 220
        //               14: 157
        //               15: 220
        //               16: 185
        //          default: 220
        //        }
        //    64: aload_2        
        //    65: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    68: invokestatic    gnu/text/Char.castToChar:(Ljava/lang/Object;)C
        //    71: aload_3        
        //    72: aload           4
        //    74: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    77: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    80: ifeq            87
        //    83: iconst_1       
        //    84: goto            88
        //    87: iconst_0       
        //    88: invokestatic    gnu/kawa/slib/readtable.setMacroCharacter:(CLjava/lang/Object;Z)V
        //    91: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    94: areturn        
        //    95: aload_2        
        //    96: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    99: invokestatic    gnu/text/Char.castToChar:(Ljava/lang/Object;)C
        //   102: aload_3        
        //   103: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   106: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   109: ifeq            116
        //   112: iconst_1       
        //   113: goto            117
        //   116: iconst_0       
        //   117: aload           4
        //   119: ldc             Lgnu/kawa/lispexpr/ReadTable;.class
        //   121: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   124: checkcast       Lgnu/kawa/lispexpr/ReadTable;
        //   127: invokestatic    gnu/kawa/slib/readtable.makeDispatchMacroCharacter:(CZLgnu/kawa/lispexpr/ReadTable;)V
        //   130: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   133: areturn        
        //   134: aload_2        
        //   135: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   138: invokestatic    gnu/text/Char.castToChar:(Ljava/lang/Object;)C
        //   141: aload_3        
        //   142: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   145: invokestatic    gnu/text/Char.castToChar:(Ljava/lang/Object;)C
        //   148: aload           4
        //   150: invokestatic    gnu/kawa/slib/readtable.setDispatchMacroCharacter:(CCLjava/lang/Object;)V
        //   153: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   156: areturn        
        //   157: aload_2        
        //   158: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   161: invokestatic    gnu/text/Char.castToChar:(Ljava/lang/Object;)C
        //   164: aload_3        
        //   165: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   168: invokestatic    gnu/text/Char.castToChar:(Ljava/lang/Object;)C
        //   171: aload           4
        //   173: ldc             Lgnu/kawa/lispexpr/ReadTable;.class
        //   175: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   178: checkcast       Lgnu/kawa/lispexpr/ReadTable;
        //   181: invokestatic    gnu/kawa/slib/readtable.getDispatchMacroTable:(CCLgnu/kawa/lispexpr/ReadTable;)Ljava/lang/Object;
        //   184: areturn        
        //   185: aload_2        
        //   186: ldc             Lgnu/mapping/SimpleSymbol;.class
        //   188: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   191: checkcast       Lgnu/mapping/SimpleSymbol;
        //   194: aload_3        
        //   195: ldc             Lgnu/mapping/Procedure;.class
        //   197: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   200: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   203: aload           4
        //   205: ldc             Lgnu/kawa/lispexpr/ReadTable;.class
        //   207: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   210: checkcast       Lgnu/kawa/lispexpr/ReadTable;
        //   213: invokestatic    gnu/kawa/slib/readtable.defineReaderCtor:(Lgnu/mapping/SimpleSymbol;Lgnu/mapping/Procedure;Lgnu/kawa/lispexpr/ReadTable;)V
        //   216: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   219: areturn        
        //   220: aload_0        
        //   221: aload_1        
        //   222: aload_2        
        //   223: aload_3        
        //   224: aload           4
        //   226: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   229: areturn        
        //   230: new             Lgnu/mapping/WrongType;
        //   233: dup_x1         
        //   234: swap           
        //   235: ldc_w           "set-macro-character"
        //   238: iconst_1       
        //   239: aload_2        
        //   240: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   243: athrow         
        //   244: new             Lgnu/mapping/WrongType;
        //   247: dup_x1         
        //   248: swap           
        //   249: ldc_w           "set-macro-character"
        //   252: iconst_3       
        //   253: aload           4
        //   255: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   258: athrow         
        //   259: new             Lgnu/mapping/WrongType;
        //   262: dup_x1         
        //   263: swap           
        //   264: ldc_w           "make-dispatch-macro-character"
        //   267: iconst_1       
        //   268: aload_2        
        //   269: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   272: athrow         
        //   273: new             Lgnu/mapping/WrongType;
        //   276: dup_x1         
        //   277: swap           
        //   278: ldc_w           "make-dispatch-macro-character"
        //   281: iconst_2       
        //   282: aload_3        
        //   283: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   286: athrow         
        //   287: new             Lgnu/mapping/WrongType;
        //   290: dup_x1         
        //   291: swap           
        //   292: ldc_w           "make-dispatch-macro-character"
        //   295: iconst_3       
        //   296: aload           4
        //   298: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   301: athrow         
        //   302: new             Lgnu/mapping/WrongType;
        //   305: dup_x1         
        //   306: swap           
        //   307: ldc_w           "set-dispatch-macro-character"
        //   310: iconst_1       
        //   311: aload_2        
        //   312: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   315: athrow         
        //   316: new             Lgnu/mapping/WrongType;
        //   319: dup_x1         
        //   320: swap           
        //   321: ldc_w           "set-dispatch-macro-character"
        //   324: iconst_2       
        //   325: aload_3        
        //   326: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   329: athrow         
        //   330: new             Lgnu/mapping/WrongType;
        //   333: dup_x1         
        //   334: swap           
        //   335: ldc_w           "get-dispatch-macro-table"
        //   338: iconst_1       
        //   339: aload_2        
        //   340: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   343: athrow         
        //   344: new             Lgnu/mapping/WrongType;
        //   347: dup_x1         
        //   348: swap           
        //   349: ldc_w           "get-dispatch-macro-table"
        //   352: iconst_2       
        //   353: aload_3        
        //   354: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   357: athrow         
        //   358: new             Lgnu/mapping/WrongType;
        //   361: dup_x1         
        //   362: swap           
        //   363: ldc_w           "get-dispatch-macro-table"
        //   366: iconst_3       
        //   367: aload           4
        //   369: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   372: athrow         
        //   373: new             Lgnu/mapping/WrongType;
        //   376: dup_x1         
        //   377: swap           
        //   378: ldc_w           "define-reader-ctor"
        //   381: iconst_1       
        //   382: aload_2        
        //   383: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   386: athrow         
        //   387: new             Lgnu/mapping/WrongType;
        //   390: dup_x1         
        //   391: swap           
        //   392: ldc_w           "define-reader-ctor"
        //   395: iconst_2       
        //   396: aload_3        
        //   397: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   400: athrow         
        //   401: new             Lgnu/mapping/WrongType;
        //   404: dup_x1         
        //   405: swap           
        //   406: ldc_w           "define-reader-ctor"
        //   409: iconst_3       
        //   410: aload           4
        //   412: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   415: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  68     71     230    244    Ljava/lang/ClassCastException;
        //  77     88     244    259    Ljava/lang/ClassCastException;
        //  99     102    259    273    Ljava/lang/ClassCastException;
        //  106    117    273    287    Ljava/lang/ClassCastException;
        //  124    127    287    302    Ljava/lang/ClassCastException;
        //  138    141    302    316    Ljava/lang/ClassCastException;
        //  145    148    316    330    Ljava/lang/ClassCastException;
        //  161    164    330    344    Ljava/lang/ClassCastException;
        //  168    171    344    358    Ljava/lang/ClassCastException;
        //  178    181    358    373    Ljava/lang/ClassCastException;
        //  191    194    373    387    Ljava/lang/ClassCastException;
        //  200    203    387    401    Ljava/lang/ClassCastException;
        //  210    213    401    416    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 182 out of bounds for length 182
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
    public Object apply4(final ModuleMethod p0, final Object p1, final Object p2, final Object p3, final Object p4) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                3: 32
        //                9: 73
        //          default: 106
        //        }
        //    32: aload_2        
        //    33: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    36: invokestatic    gnu/text/Char.castToChar:(Ljava/lang/Object;)C
        //    39: aload_3        
        //    40: aload           4
        //    42: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    45: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    48: ifeq            55
        //    51: iconst_1       
        //    52: goto            56
        //    55: iconst_0       
        //    56: aload           5
        //    58: ldc             Lgnu/kawa/lispexpr/ReadTable;.class
        //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    63: checkcast       Lgnu/kawa/lispexpr/ReadTable;
        //    66: invokestatic    gnu/kawa/slib/readtable.setMacroCharacter:(CLjava/lang/Object;ZLgnu/kawa/lispexpr/ReadTable;)V
        //    69: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    72: areturn        
        //    73: aload_2        
        //    74: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    77: invokestatic    gnu/text/Char.castToChar:(Ljava/lang/Object;)C
        //    80: aload_3        
        //    81: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    84: invokestatic    gnu/text/Char.castToChar:(Ljava/lang/Object;)C
        //    87: aload           4
        //    89: aload           5
        //    91: ldc             Lgnu/kawa/lispexpr/ReadTable;.class
        //    93: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    96: checkcast       Lgnu/kawa/lispexpr/ReadTable;
        //    99: invokestatic    gnu/kawa/slib/readtable.setDispatchMacroCharacter:(CCLjava/lang/Object;Lgnu/kawa/lispexpr/ReadTable;)V
        //   102: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   105: areturn        
        //   106: aload_0        
        //   107: aload_1        
        //   108: aload_2        
        //   109: aload_3        
        //   110: aload           4
        //   112: aload           5
        //   114: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   117: areturn        
        //   118: new             Lgnu/mapping/WrongType;
        //   121: dup_x1         
        //   122: swap           
        //   123: ldc_w           "set-macro-character"
        //   126: iconst_1       
        //   127: aload_2        
        //   128: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   131: athrow         
        //   132: new             Lgnu/mapping/WrongType;
        //   135: dup_x1         
        //   136: swap           
        //   137: ldc_w           "set-macro-character"
        //   140: iconst_3       
        //   141: aload           4
        //   143: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   146: athrow         
        //   147: new             Lgnu/mapping/WrongType;
        //   150: dup_x1         
        //   151: swap           
        //   152: ldc_w           "set-macro-character"
        //   155: iconst_4       
        //   156: aload           5
        //   158: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   161: athrow         
        //   162: new             Lgnu/mapping/WrongType;
        //   165: dup_x1         
        //   166: swap           
        //   167: ldc_w           "set-dispatch-macro-character"
        //   170: iconst_1       
        //   171: aload_2        
        //   172: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   175: athrow         
        //   176: new             Lgnu/mapping/WrongType;
        //   179: dup_x1         
        //   180: swap           
        //   181: ldc_w           "set-dispatch-macro-character"
        //   184: iconst_2       
        //   185: aload_3        
        //   186: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   189: athrow         
        //   190: new             Lgnu/mapping/WrongType;
        //   193: dup_x1         
        //   194: swap           
        //   195: ldc_w           "set-dispatch-macro-character"
        //   198: iconst_4       
        //   199: aload           5
        //   201: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   204: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  36     39     118    132    Ljava/lang/ClassCastException;
        //  45     56     132    147    Ljava/lang/ClassCastException;
        //  63     66     147    162    Ljava/lang/ClassCastException;
        //  77     80     162    176    Ljava/lang/ClassCastException;
        //  84     87     176    190    Ljava/lang/ClassCastException;
        //  96     99     190    205    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 91 out of bounds for length 91
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
