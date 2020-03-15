// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import kawa.standard.syntax_case;
import kawa.lang.TemplateScope;
import gnu.expr.ModuleInfo;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import gnu.math.IntNum;
import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.Mangling;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.bytecode.Type;
import gnu.mapping.Procedure;
import kawa.lang.SetFieldProc;
import kawa.lang.GetFieldProc;
import kawa.lang.RecordConstructor;
import kawa.lang.Record;
import gnu.bytecode.ClassType;
import gnu.lists.LList;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.lists.PairWithPosition;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.SyntaxPattern;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import kawa.lang.Macro;
import gnu.expr.ModuleBody;

public class reflection extends ModuleBody
{
    public static final Macro primitive$Mnconstructor;
    public static final ModuleMethod make$Mnrecord$Mntype;
    public static final ModuleMethod record$Mnconstructor;
    public static final ModuleMethod record$Mnaccessor;
    public static final ModuleMethod record$Mnmodifier;
    public static final ModuleMethod record$Qu;
    public static final ModuleMethod record$Mnpredicate;
    public static final ModuleMethod record$Mntype$Mndescriptor;
    public static final ModuleMethod record$Mntype$Mnname;
    public static final ModuleMethod record$Mntype$Mnfield$Mnnames;
    public static final Macro primitive$Mnarray$Mnnew;
    public static final Macro primitive$Mnarray$Mnset;
    public static final Macro primitive$Mnarray$Mnget;
    public static final Macro primitive$Mnarray$Mnlength;
    public static final Macro primitive$Mnget$Mnfield;
    public static final Macro primitive$Mnset$Mnfield;
    public static final Macro primitive$Mnget$Mnstatic;
    public static final Macro primitive$Mnset$Mnstatic;
    public static final ModuleMethod subtype$Qu;
    public static reflection $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxPattern Lit1;
    static final SyntaxTemplate Lit2;
    static final SyntaxPattern Lit3;
    static final SyntaxTemplate Lit4;
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
    static final SyntaxRules Lit15;
    static final SimpleSymbol Lit16;
    static final SyntaxRules Lit17;
    static final SimpleSymbol Lit18;
    static final SyntaxRules Lit19;
    static final SimpleSymbol Lit20;
    static final SyntaxRules Lit21;
    static final SimpleSymbol Lit22;
    static final SyntaxRules Lit23;
    static final SimpleSymbol Lit24;
    static final SyntaxRules Lit25;
    static final SimpleSymbol Lit26;
    static final SyntaxRules Lit27;
    static final SimpleSymbol Lit28;
    static final SyntaxRules Lit29;
    static final SimpleSymbol Lit30;
    static final Object[] Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final PairWithPosition Lit34;
    static final PairWithPosition Lit35;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static ClassType makeRecordType(final String name, final LList fnames) {
        return Record.makeRecordType(name, fnames);
    }
    
    public static RecordConstructor recordConstructor(final ClassType cl) {
        return recordConstructor(cl, null);
    }
    
    public static RecordConstructor recordConstructor(final ClassType cl, final Object flds) {
        return new RecordConstructor(cl, flds);
    }
    
    public static GetFieldProc recordAccessor(final ClassType class, final String fname) {
        return new GetFieldProc(class, fname);
    }
    
    public static SetFieldProc recordModifier(final ClassType class, final String fname) {
        return new SetFieldProc(class, fname);
    }
    
    public static boolean isRecord(final Object obj) {
        return obj instanceof Record;
    }
    
    public static Procedure recordPredicate(final Object rtype) {
        public class reflection$frame extends ModuleBody
        {
            Object rtype;
            final ModuleMethod lambda$Fn1;
            
            public reflection$frame() {
                final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, 4097);
                lambda$Fn1.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/reflection.scm:30");
                this.lambda$Fn1 = lambda$Fn1;
            }
            
            boolean lambda1(final Object object) {
                final Object force = Promise.force(this.rtype, Type.class);
                try {
                    return ((Type)force).isInstance(object);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "gnu.bytecode.Type.isInstance(java.lang.Object)", 1, force);
                }
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
        final reflection$frame $heapFrame = new reflection$frame();
        $heapFrame.rtype = rtype;
        return $heapFrame.lambda$Fn1;
    }
    
    public static Type recordTypeDescriptor(final Object object) {
        return Type.make(object.getClass());
    }
    
    public static String recordTypeName(final ClassType rtd) {
        return Mangling.demangleName(rtd.getName(), true);
    }
    
    public static LList recordTypeFieldNames(final Object rtd) {
        final Object force = Promise.force(rtd, ClassType.class);
        try {
            return Record.typeFieldNames(LangObjType.coerceToClassType(force));
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "kawa.lang.Record.typeFieldNames(class-type)", 1, force);
        }
    }
    
    public static boolean isSubtype(final Type t1, final Type t2) {
        return t1.isSubtype(t2);
    }
    
    static {
        Lit35 = PairWithPosition.make(IntNum.valueOf(1), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/reflection.scm", 397335);
        Lit34 = PairWithPosition.make(IntNum.valueOf(9), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/reflection.scm", 450583);
        Lit33 = Symbol.valueOf("make");
        Lit32 = Symbol.valueOf("constant-fold");
        Lit31 = new Object[0];
        Lit30 = Symbol.valueOf("subtype?");
        Lit29 = new SyntaxRules(reflection.Lit31, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", reflection.Lit31, 3, "reflection.scm:107"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0003\t\u000b\t\u0013\u0018\u001c", new Object[] { reflection.Lit32, reflection.Lit33, Symbol.valueOf("<gnu.kawa.reflect.StaticSet>"), reflection.Lit34 }, 0) }, 3, Lit28 = Symbol.valueOf("primitive-set-static"));
        Lit27 = new SyntaxRules(reflection.Lit31, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", reflection.Lit31, 3, "reflection.scm:101"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0003\t\u000b\t\u0013\u0018\u001c", new Object[] { reflection.Lit32, reflection.Lit33, Symbol.valueOf("<gnu.kawa.reflect.StaticGet>"), reflection.Lit34 }, 0) }, 3, Lit26 = Symbol.valueOf("primitive-get-static"));
        Lit25 = new SyntaxRules(reflection.Lit31, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", reflection.Lit31, 3, "reflection.scm:94"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0003\t\u000b\t\u0013\u0018\u001c", new Object[] { reflection.Lit32, reflection.Lit33, Symbol.valueOf("<kawa.lang.SetFieldProc>"), reflection.Lit35 }, 0) }, 3, Lit24 = Symbol.valueOf("primitive-set-field"));
        Lit23 = new SyntaxRules(reflection.Lit31, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", reflection.Lit31, 3, "reflection.scm:88"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0003\t\u000b\t\u0013\u0018\u001c", new Object[] { reflection.Lit32, reflection.Lit33, Symbol.valueOf("<kawa.lang.GetFieldProc>"), reflection.Lit35 }, 0) }, 3, Lit22 = Symbol.valueOf("primitive-get-field"));
        Lit21 = new SyntaxRules(reflection.Lit31, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", reflection.Lit31, 1, "reflection.scm:83"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\b\u0003", new Object[] { reflection.Lit32, reflection.Lit33, Symbol.valueOf("<gnu.kawa.reflect.ArrayLength>") }, 0) }, 1, Lit20 = Symbol.valueOf("primitive-array-length"));
        Lit19 = new SyntaxRules(reflection.Lit31, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", reflection.Lit31, 1, "reflection.scm:77"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\b\u0003", new Object[] { reflection.Lit32, reflection.Lit33, Symbol.valueOf("<gnu.kawa.reflect.ArrayGet>") }, 0) }, 1, Lit18 = Symbol.valueOf("primitive-array-get"));
        Lit17 = new SyntaxRules(reflection.Lit31, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", reflection.Lit31, 1, "reflection.scm:71"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\b\u0003", new Object[] { reflection.Lit32, reflection.Lit33, Symbol.valueOf("<gnu.kawa.reflect.ArraySet>") }, 0) }, 1, Lit16 = Symbol.valueOf("primitive-array-set"));
        Lit15 = new SyntaxRules(reflection.Lit31, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", reflection.Lit31, 1, "reflection.scm:65"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\b\u0003", new Object[] { reflection.Lit32, reflection.Lit33, Symbol.valueOf("<gnu.kawa.reflect.ArrayNew>") }, 0) }, 1, Lit14 = Symbol.valueOf("primitive-array-new"));
        Lit13 = Symbol.valueOf("record-type-field-names");
        Lit12 = Symbol.valueOf("record-type-name");
        Lit11 = Symbol.valueOf("record-type-descriptor");
        Lit10 = Symbol.valueOf("record-predicate");
        Lit9 = Symbol.valueOf("record?");
        Lit8 = Symbol.valueOf("record-modifier");
        Lit7 = Symbol.valueOf("record-accessor");
        Lit6 = Symbol.valueOf("record-constructor");
        Lit5 = Symbol.valueOf("make-record-type");
        Lit4 = new SyntaxTemplate("\u0001\u0003\u0003", "\u0011\u0018\u0004\u0019\b\u0015\u0013\u0011\u0018\f\t\u0003\b\u0011\u0018\u0014\t\u0003\b\r\u0011\u0018\u001c\t\u000b\b\u0013", new Object[] { Symbol.valueOf("lambda"), Symbol.valueOf("::"), reflection.Lit33, Symbol.valueOf("as") }, 1);
        Lit3 = new SyntaxPattern("\r\u0017\u0010\b\b", reflection.Lit31, 3, "reflection.scm:8");
        Lit2 = new SyntaxTemplate("\u0001\u0003", "\b\r\u000b", reflection.Lit31, 1);
        Lit1 = new SyntaxPattern("\f\u0018\f\u0007,\r\u000f\b\b\b\b", reflection.Lit31, 2, "reflection.scm:6");
        Lit0 = Symbol.valueOf("primitive-constructor");
        reflection.$instance = new reflection();
        primitive$Mnconstructor = Macro.make(reflection.Lit0, new ModuleMethod(reflection.$instance, 2, null, 4097), "kawa.lib.reflection");
        final reflection $instance = reflection.$instance;
        make$Mnrecord$Mntype = new ModuleMethod($instance, 3, reflection.Lit5, 8194);
        record$Mnconstructor = new ModuleMethod($instance, 4, reflection.Lit6, 8193);
        record$Mnaccessor = new ModuleMethod($instance, 6, reflection.Lit7, 8194);
        record$Mnmodifier = new ModuleMethod($instance, 7, reflection.Lit8, 8194);
        record$Qu = new ModuleMethod($instance, 8, reflection.Lit9, 4097);
        record$Mnpredicate = new ModuleMethod($instance, 9, reflection.Lit10, 4097);
        record$Mntype$Mndescriptor = new ModuleMethod($instance, 10, reflection.Lit11, 4097);
        record$Mntype$Mnname = new ModuleMethod($instance, 11, reflection.Lit12, 4097);
        record$Mntype$Mnfield$Mnnames = new ModuleMethod($instance, 12, reflection.Lit13, 4097);
        primitive$Mnarray$Mnnew = Macro.make(reflection.Lit14, reflection.Lit15, "kawa.lib.reflection");
        primitive$Mnarray$Mnset = Macro.make(reflection.Lit16, reflection.Lit17, "kawa.lib.reflection");
        primitive$Mnarray$Mnget = Macro.make(reflection.Lit18, reflection.Lit19, "kawa.lib.reflection");
        primitive$Mnarray$Mnlength = Macro.make(reflection.Lit20, reflection.Lit21, "kawa.lib.reflection");
        primitive$Mnget$Mnfield = Macro.make(reflection.Lit22, reflection.Lit23, "kawa.lib.reflection");
        primitive$Mnset$Mnfield = Macro.make(reflection.Lit24, reflection.Lit25, "kawa.lib.reflection");
        primitive$Mnget$Mnstatic = Macro.make(reflection.Lit26, reflection.Lit27, "kawa.lib.reflection");
        primitive$Mnset$Mnstatic = Macro.make(reflection.Lit28, reflection.Lit29, "kawa.lib.reflection");
        subtype$Qu = new ModuleMethod($instance, 13, reflection.Lit30, 8194);
        $runBody$();
    }
    
    public reflection() {
        ModuleInfo.register(this);
    }
    
    static Object lambda2(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(2, null);
        Object error;
        if (reflection.Lit1.match(form, allocVars, 0)) {
            final Object generateTemporaries = std_syntax.generateTemporaries(reflection.Lit2.execute(allocVars, TemplateScope.make()));
            final Object[] allocVars2 = SyntaxPattern.allocVars(3, allocVars);
            error = (reflection.Lit3.match(generateTemporaries, allocVars2, 0) ? reflection.Lit4.execute(allocVars2, TemplateScope.make()) : syntax_case.error("syntax-case", generateTemporaries));
        }
        else {
            error = syntax_case.error("syntax-case", form);
        }
        return error;
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 2: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 12: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 11: {
                final Object force = Promise.force(o, ClassType.class);
                if (LangObjType.coerceToClassTypeOrNull(force) != null) {
                    ctx.value1 = force;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 10: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 9: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 8: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                final Object force2 = Promise.force(o, ClassType.class);
                if (LangObjType.coerceToClassTypeOrNull(force2) != null) {
                    ctx.value1 = force2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 13: {
                final Object force = Promise.force(o, Type.class);
                if (LangObjType.coerceToTypeOrNull(force) == null) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(o2, Type.class);
                if (LangObjType.coerceToTypeOrNull(force2) != null) {
                    ctx.value2 = force2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 7: {
                final Object force3 = Promise.force(o, ClassType.class);
                if (LangObjType.coerceToClassTypeOrNull(force3) != null) {
                    ctx.value1 = force3;
                    ctx.value2 = Promise.force(o2, String.class);
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 6: {
                final Object force4 = Promise.force(o, ClassType.class);
                if (LangObjType.coerceToClassTypeOrNull(force4) != null) {
                    ctx.value1 = force4;
                    ctx.value2 = Promise.force(o2, String.class);
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 4: {
                final Object force5 = Promise.force(o, ClassType.class);
                if (LangObjType.coerceToClassTypeOrNull(force5) != null) {
                    ctx.value1 = force5;
                    ctx.value2 = o2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 3: {
                ctx.value1 = Promise.force(o, String.class);
                final Object force6 = Promise.force(o2, LList.class);
                if (force6 instanceof LList) {
                    ctx.value2 = force6;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
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
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                4: 122
        //                5: 127
        //                6: 64
        //                7: 127
        //                8: 127
        //                9: 127
        //               10: 77
        //               11: 94
        //               12: 99
        //               13: 104
        //               14: 117
        //          default: 127
        //        }
        //    64: aload_2        
        //    65: ldc             Lgnu/bytecode/ClassType;.class
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    70: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToClassType:(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
        //    73: invokestatic    kawa/lib/reflection.recordConstructor:(Lgnu/bytecode/ClassType;)Lkawa/lang/RecordConstructor;
        //    76: areturn        
        //    77: aload_2        
        //    78: invokestatic    kawa/lib/reflection.isRecord:(Ljava/lang/Object;)Z
        //    81: ifeq            90
        //    84: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    87: goto            93
        //    90: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    93: areturn        
        //    94: aload_2        
        //    95: invokestatic    kawa/lib/reflection.recordPredicate:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    98: areturn        
        //    99: aload_2        
        //   100: invokestatic    kawa/lib/reflection.recordTypeDescriptor:(Ljava/lang/Object;)Lgnu/bytecode/Type;
        //   103: areturn        
        //   104: aload_2        
        //   105: ldc             Lgnu/bytecode/ClassType;.class
        //   107: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   110: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToClassType:(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
        //   113: invokestatic    kawa/lib/reflection.recordTypeName:(Lgnu/bytecode/ClassType;)Ljava/lang/String;
        //   116: areturn        
        //   117: aload_2        
        //   118: invokestatic    kawa/lib/reflection.recordTypeFieldNames:(Ljava/lang/Object;)Lgnu/lists/LList;
        //   121: areturn        
        //   122: aload_2        
        //   123: invokestatic    kawa/lib/reflection.lambda2:(Ljava/lang/Object;)Ljava/lang/Object;
        //   126: areturn        
        //   127: aload_0        
        //   128: aload_1        
        //   129: aload_2        
        //   130: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   133: areturn        
        //   134: new             Lgnu/mapping/WrongType;
        //   137: dup_x1         
        //   138: swap           
        //   139: ldc_w           "record-constructor"
        //   142: iconst_1       
        //   143: aload_2        
        //   144: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   147: athrow         
        //   148: new             Lgnu/mapping/WrongType;
        //   151: dup_x1         
        //   152: swap           
        //   153: ldc_w           "record-type-name"
        //   156: iconst_1       
        //   157: aload_2        
        //   158: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   161: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  70     73     134    148    Ljava/lang/ClassCastException;
        //  110    113    148    162    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0117:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                6: 64
        //                7: 97
        //                8: 209
        //                9: 111
        //               10: 143
        //               11: 209
        //               12: 209
        //               13: 209
        //               14: 209
        //               15: 209
        //               16: 175
        //          default: 209
        //        }
        //    64: aload_2        
        //    65: ldc_w           Ljava/lang/String;.class
        //    68: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    71: dup            
        //    72: ifnonnull       80
        //    75: pop            
        //    76: aconst_null    
        //    77: goto            83
        //    80: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    83: aload_3        
        //    84: ldc_w           Lgnu/lists/LList;.class
        //    87: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    90: checkcast       Lgnu/lists/LList;
        //    93: invokestatic    kawa/lib/reflection.makeRecordType:(Ljava/lang/String;Lgnu/lists/LList;)Lgnu/bytecode/ClassType;
        //    96: areturn        
        //    97: aload_2        
        //    98: ldc             Lgnu/bytecode/ClassType;.class
        //   100: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   103: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToClassType:(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
        //   106: aload_3        
        //   107: invokestatic    kawa/lib/reflection.recordConstructor:(Lgnu/bytecode/ClassType;Ljava/lang/Object;)Lkawa/lang/RecordConstructor;
        //   110: areturn        
        //   111: aload_2        
        //   112: ldc             Lgnu/bytecode/ClassType;.class
        //   114: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   117: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToClassType:(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
        //   120: aload_3        
        //   121: ldc_w           Ljava/lang/String;.class
        //   124: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   127: dup            
        //   128: ifnonnull       136
        //   131: pop            
        //   132: aconst_null    
        //   133: goto            139
        //   136: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   139: invokestatic    kawa/lib/reflection.recordAccessor:(Lgnu/bytecode/ClassType;Ljava/lang/String;)Lkawa/lang/GetFieldProc;
        //   142: areturn        
        //   143: aload_2        
        //   144: ldc             Lgnu/bytecode/ClassType;.class
        //   146: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   149: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToClassType:(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
        //   152: aload_3        
        //   153: ldc_w           Ljava/lang/String;.class
        //   156: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   159: dup            
        //   160: ifnonnull       168
        //   163: pop            
        //   164: aconst_null    
        //   165: goto            171
        //   168: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   171: invokestatic    kawa/lib/reflection.recordModifier:(Lgnu/bytecode/ClassType;Ljava/lang/String;)Lkawa/lang/SetFieldProc;
        //   174: areturn        
        //   175: aload_2        
        //   176: ldc             Lgnu/bytecode/Type;.class
        //   178: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   181: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToType:(Ljava/lang/Object;)Lgnu/bytecode/Type;
        //   184: aload_3        
        //   185: ldc             Lgnu/bytecode/Type;.class
        //   187: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   190: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToType:(Ljava/lang/Object;)Lgnu/bytecode/Type;
        //   193: invokestatic    kawa/lib/reflection.isSubtype:(Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Z
        //   196: ifeq            205
        //   199: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   202: goto            208
        //   205: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   208: areturn        
        //   209: aload_0        
        //   210: aload_1        
        //   211: aload_2        
        //   212: aload_3        
        //   213: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   216: areturn        
        //   217: new             Lgnu/mapping/WrongType;
        //   220: dup_x1         
        //   221: swap           
        //   222: ldc_w           "make-record-type"
        //   225: iconst_2       
        //   226: aload_3        
        //   227: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   230: athrow         
        //   231: new             Lgnu/mapping/WrongType;
        //   234: dup_x1         
        //   235: swap           
        //   236: ldc_w           "record-constructor"
        //   239: iconst_1       
        //   240: aload_2        
        //   241: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   244: athrow         
        //   245: new             Lgnu/mapping/WrongType;
        //   248: dup_x1         
        //   249: swap           
        //   250: ldc_w           "record-accessor"
        //   253: iconst_1       
        //   254: aload_2        
        //   255: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   258: athrow         
        //   259: new             Lgnu/mapping/WrongType;
        //   262: dup_x1         
        //   263: swap           
        //   264: ldc_w           "record-modifier"
        //   267: iconst_1       
        //   268: aload_2        
        //   269: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   272: athrow         
        //   273: new             Lgnu/mapping/WrongType;
        //   276: dup_x1         
        //   277: swap           
        //   278: ldc_w           "subtype?"
        //   281: iconst_1       
        //   282: aload_2        
        //   283: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   286: athrow         
        //   287: new             Lgnu/mapping/WrongType;
        //   290: dup_x1         
        //   291: swap           
        //   292: ldc_w           "subtype?"
        //   295: iconst_2       
        //   296: aload_3        
        //   297: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   300: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  90     93     217    231    Ljava/lang/ClassCastException;
        //  103    106    231    245    Ljava/lang/ClassCastException;
        //  117    120    245    259    Ljava/lang/ClassCastException;
        //  149    152    259    273    Ljava/lang/ClassCastException;
        //  181    184    273    287    Ljava/lang/ClassCastException;
        //  190    193    287    301    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 123 out of bounds for length 123
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
