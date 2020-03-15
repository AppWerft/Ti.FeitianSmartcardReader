// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import gnu.kawa.xml.KComment;
import gnu.kawa.xml.KProcessingInstruction;
import gnu.kawa.xml.KAttr;
import gnu.mapping.Symbol;
import gnu.kawa.xml.KElement;
import gnu.kawa.xml.Document;
import gnu.kawa.xml.KDocument;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.kawa.xml.OutputAsXML;
import gnu.expr.ModuleBody;

public class XML extends ModuleBody
{
    public static OutputAsXML as$Mnxml;
    public static final Class comment;
    public static final Class processing$Mninstruction;
    public static final ModuleMethod parse$Mnxml$Mnfrom$Mnurl;
    public static final ModuleMethod element$Mnname;
    public static final ModuleMethod attribute$Mnname;
    public static XML $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        XML.as$Mnxml = new OutputAsXML();
    }
    
    public static KDocument parseXmlFromUrl(final Object url) {
        return Document.parse(url);
    }
    
    public static Symbol elementName(final KElement element) {
        return element.getNodeSymbol();
    }
    
    public static Symbol attributeName(final KAttr attr) {
        return attr.getNodeSymbol();
    }
    
    static {
        Lit2 = Symbol.valueOf("attribute-name");
        Lit1 = Symbol.valueOf("element-name");
        Lit0 = Symbol.valueOf("parse-xml-from-url");
        processing$Mninstruction = KProcessingInstruction.class;
        comment = KComment.class;
        XML.$instance = new XML();
        final XML $instance = XML.$instance;
        parse$Mnxml$Mnfrom$Mnurl = new ModuleMethod($instance, 1, XML.Lit0, 4097);
        element$Mnname = new ModuleMethod($instance, 2, XML.Lit1, 4097);
        attribute$Mnname = new ModuleMethod($instance, 3, XML.Lit2, 4097);
        $runBody$();
    }
    
    public XML() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 3: {
                final Object force = Promise.force(o, KAttr.class);
                if (!(force instanceof KAttr)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                final Object force2 = Promise.force(o, KElement.class);
                if (!(force2 instanceof KElement)) {
                    return -786431;
                }
                ctx.value1 = force2;
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
        //                2: 32
        //                3: 37
        //                4: 50
        //          default: 63
        //        }
        //    32: aload_2        
        //    33: invokestatic    gnu/kawa/slib/XML.parseXmlFromUrl:(Ljava/lang/Object;)Lgnu/kawa/xml/KDocument;
        //    36: areturn        
        //    37: aload_2        
        //    38: ldc             Lgnu/kawa/xml/KElement;.class
        //    40: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    43: checkcast       Lgnu/kawa/xml/KElement;
        //    46: invokestatic    gnu/kawa/slib/XML.elementName:(Lgnu/kawa/xml/KElement;)Lgnu/mapping/Symbol;
        //    49: areturn        
        //    50: aload_2        
        //    51: ldc             Lgnu/kawa/xml/KAttr;.class
        //    53: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    56: checkcast       Lgnu/kawa/xml/KAttr;
        //    59: invokestatic    gnu/kawa/slib/XML.attributeName:(Lgnu/kawa/xml/KAttr;)Lgnu/mapping/Symbol;
        //    62: areturn        
        //    63: aload_0        
        //    64: aload_1        
        //    65: aload_2        
        //    66: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //    69: areturn        
        //    70: new             Lgnu/mapping/WrongType;
        //    73: dup_x1         
        //    74: swap           
        //    75: ldc             "element-name"
        //    77: iconst_1       
        //    78: aload_2        
        //    79: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    82: athrow         
        //    83: new             Lgnu/mapping/WrongType;
        //    86: dup_x1         
        //    87: swap           
        //    88: ldc             "attribute-name"
        //    90: iconst_1       
        //    91: aload_2        
        //    92: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    95: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  43     46     70     83     Ljava/lang/ClassCastException;
        //  56     59     83     96     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0063:
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
}
