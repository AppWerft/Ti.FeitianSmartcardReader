// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.kawa.functions.MakePromise;
import kawa.standard.syntax_case;
import kawa.lang.TemplateScope;
import gnu.expr.QuoteExp;
import gnu.expr.Language;
import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import gnu.lists.Pair;
import gnu.mapping.Values;
import kawa.lang.SyntaxRule;
import gnu.lists.LList;
import gnu.expr.KawaConvert;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import kawa.lang.SyntaxForm;
import gnu.mapping.Symbol;
import kawa.lang.SyntaxForms;
import kawa.lang.Quote;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.lists.PairWithPosition;
import kawa.lang.SyntaxTemplate;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleMethod;
import kawa.lang.Macro;
import gnu.expr.ModuleBody;

public class std_syntax extends ModuleBody
{
    public static final Macro cond;
    public static final Macro and;
    public static final Macro or;
    public static final Macro let;
    public static final Macro let$St;
    public static final Macro do;
    public static final Macro delay;
    public static final Macro lazy;
    public static final Macro delay$Mnforce;
    public static final Macro else;
    public static final Macro $Dt$Dt$Dt;
    public static final Macro $Qu;
    public static final Macro $Eq$Gr;
    public static final Macro _;
    public static final Macro unquote;
    public static final Macro unquote$Mnsplicing;
    public static final ModuleMethod syntax$Mn$Grdatum;
    public static final ModuleMethod datum$Mn$Grsyntax;
    public static final Macro with$Mnsyntax;
    public static final ModuleMethod syntax$Mnobject$Mn$Grdatum;
    public static final ModuleMethod datum$Mn$Grsyntax$Mnobject;
    public static final ModuleMethod generate$Mntemporaries;
    public static final Macro define$Mnprocedure;
    public static final ModuleMethod identifier$Qu;
    public static final ModuleMethod free$Mnidentifier$Eq$Qu;
    public static final ModuleMethod bound$Mnidentifier$Eq$Qu;
    public static final ModuleMethod syntax$Mnsource;
    public static final ModuleMethod syntax$Mnline;
    public static final ModuleMethod syntax$Mncolumn;
    public static final StaticFieldLocation $Prvt$if;
    public static final StaticFieldLocation $Prvt$letrec;
    public static final StaticFieldLocation $Prvt$syntax$Mncase;
    public static final StaticFieldLocation $Prvt$$Pclet;
    public static final StaticFieldLocation $Prvt$$Pcdefine;
    public static final StaticFieldLocation $Prvt$lambda;
    public static final StaticFieldLocation $Prvt$not;
    public static final StaticFieldLocation $Prvt$begin;
    public static final StaticFieldLocation $Prvt$syntax$Mnerror;
    public static final Macro $Prvt$$Pclet$Mnlambda1;
    public static final Macro $Prvt$$Pclet$Mnlambda2;
    public static final Macro $Prvt$$Pclet$Mninit;
    public static final Macro $Prvt$$Pcdo$Mnstep;
    public static final Macro $Prvt$$Pcdo$Mninit;
    public static final Macro $Prvt$$Pcdo$Mnlambda1;
    public static final Macro $Prvt$$Pcdo$Mnlambda2;
    static final IntNum Lit0;
    static final IntNum Lit1;
    public static std_syntax $instance;
    static final SimpleSymbol Lit2;
    static final SyntaxRules Lit3;
    static final SimpleSymbol Lit4;
    static final SyntaxRules Lit5;
    static final SimpleSymbol Lit6;
    static final SyntaxRules Lit7;
    static final SimpleSymbol Lit8;
    static final SyntaxRules Lit9;
    static final SimpleSymbol Lit10;
    static final SyntaxRules Lit11;
    static final SimpleSymbol Lit12;
    static final SyntaxRules Lit13;
    static final SimpleSymbol Lit14;
    static final SyntaxRules Lit15;
    static final SimpleSymbol Lit16;
    static final SyntaxRules Lit17;
    static final SimpleSymbol Lit18;
    static final SyntaxPattern Lit19;
    static final SyntaxPattern Lit20;
    static final SyntaxTemplate Lit21;
    static final SyntaxPattern Lit22;
    static final SyntaxTemplate Lit23;
    static final SimpleSymbol Lit24;
    static final SyntaxPattern Lit25;
    static final SyntaxPattern Lit26;
    static final SyntaxTemplate Lit27;
    static final SyntaxPattern Lit28;
    static final SyntaxTemplate Lit29;
    static final SimpleSymbol Lit30;
    static final SyntaxRules Lit31;
    static final SimpleSymbol Lit32;
    static final SyntaxRules Lit33;
    static final SimpleSymbol Lit34;
    static final SyntaxRules Lit35;
    static final SimpleSymbol Lit36;
    static final SyntaxRules Lit37;
    static final SimpleSymbol Lit38;
    static final SyntaxRules Lit39;
    static final SimpleSymbol Lit40;
    static final SyntaxRules Lit41;
    static final SimpleSymbol Lit42;
    static final SyntaxRules Lit43;
    static final SimpleSymbol Lit44;
    static final SyntaxRules Lit45;
    static final SimpleSymbol Lit46;
    static final SyntaxRules Lit47;
    static final SimpleSymbol Lit48;
    static final SyntaxRules Lit49;
    static final SimpleSymbol Lit50;
    static final SyntaxPattern Lit51;
    static final SyntaxTemplate Lit52;
    static final SimpleSymbol Lit53;
    static final SyntaxPattern Lit54;
    static final SyntaxTemplate Lit55;
    static final SimpleSymbol Lit56;
    static final SyntaxPattern Lit57;
    static final SyntaxTemplate Lit58;
    static final SimpleSymbol Lit59;
    static final SyntaxRules Lit60;
    static final SimpleSymbol Lit61;
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final SimpleSymbol Lit64;
    static final SimpleSymbol Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final SyntaxRules Lit73;
    static final Object[] Lit74;
    static final SimpleSymbol Lit75;
    static final SimpleSymbol Lit76;
    static final Object[] Lit77;
    static final Object[] Lit78;
    static final SimpleSymbol Lit79;
    static final Object[] Lit80;
    static final Object[] Lit81;
    static final Object[] Lit82;
    static final SimpleSymbol Lit83;
    static final Object[] Lit84;
    static final SimpleSymbol Lit85;
    static final SimpleSymbol Lit86;
    static final Object[] Lit87;
    static final Object[] Lit88;
    static final SimpleSymbol Lit89;
    static final Object[] Lit90;
    static final Object[] Lit91;
    static final SimpleSymbol Lit92;
    static final Object[] Lit93;
    static final PairWithPosition Lit94;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Object syntax$To$Datum(final Object obj) {
        return Quote.quote(obj);
    }
    
    public static Object syntaxObject$To$Datum(final Object obj) {
        return syntax$To$Datum(obj);
    }
    
    public static Object datum$To$Syntax(final Object template$Mnidentifier, final Object obj) {
        return datum$To$Syntax(template$Mnidentifier, obj, null);
    }
    
    public static Object datum$To$Syntax(final Object template$Mnidentifier, final Object obj, final Object srcloc) {
        return SyntaxForms.makeWithTemplate(template$Mnidentifier, obj, srcloc);
    }
    
    public static Object datum$To$SyntaxObject(final Object template$Mnidentifier, final Object obj) {
        return datum$To$Syntax(template$Mnidentifier, obj);
    }
    
    public static Object generateTemporaries(final Object list) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lang/Translator.listLength:(Ljava/lang/Object;)I
        //     4: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //     7: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    10: astore_2       
        //    11: astore_1        /* n */
        //    12: aload_1         /* n */
        //    13: getstatic       kawa/lib/std_syntax.Lit0:Lgnu/math/IntNum;
        //    16: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    19: ifeq            26
        //    22: aload_2         /* lst */
        //    23: goto            52
        //    26: iconst_m1      
        //    27: aload_1         /* n */
        //    28: getstatic       kawa/lib/std_syntax.Lit1:Lgnu/math/IntNum;
        //    31: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    34: new             Lgnu/lists/Pair;
        //    37: dup            
        //    38: aload_0         /* list */
        //    39: invokestatic    gnu/expr/Symbols.gentemp:()Lgnu/mapping/SimpleSymbol;
        //    42: invokestatic    kawa/lib/std_syntax.datum$To$SyntaxObject:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    45: aload_2         /* lst */
        //    46: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    49: goto            10
        //    52: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static boolean isIdentifier(final Object form) {
        final boolean x = form instanceof Symbol;
        if (x) {
            return x;
        }
        Label_0037: {
            if (!(form instanceof SyntaxForm)) {
                break Label_0037;
            }
            final Object force = Promise.force(form, SyntaxForm.class);
            try {
                return SyntaxForms.isIdentifier((SyntaxForm)force);
                identifier = false;
                return identifier;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "kawa.lang.SyntaxForms.isIdentifier(kawa.lang.SyntaxForm)", 1, force);
            }
        }
    }
    
    public static boolean isFreeIdentifier$Eq(final Object id1, final Object id2) {
        return (isIdentifier(id1) && isIdentifier(id2)) ? SyntaxForms.identifierEquals(id1, id2, false) : KawaConvert.isTrue(prim_syntax.reportSyntaxError(isIdentifier(id1) ? id2 : id1, "free-identifier-? - argument is not an identifier"));
    }
    
    public static boolean isBoundIdentifier$Eq(final Object id1, final Object id2) {
        return (isIdentifier(id1) && isIdentifier(id2)) ? SyntaxForms.identifierEquals(id1, id2, true) : KawaConvert.isTrue(prim_syntax.reportSyntaxError(isIdentifier(id1) ? id2 : id1, "bound-identifier-? - argument is not an identifier"));
    }
    
    public static Object syntaxSource(Object form) {
        while (form instanceof SyntaxForm) {
            form = ((SyntaxForm)Promise.force(form, SyntaxForm.class)).getDatum();
        }
        Object false;
        if (form instanceof PairWithPosition) {
            final Object str = ((PairWithPosition)Promise.force(form, PairWithPosition.class)).getFileName();
            false = ((str == null) ? Boolean.FALSE : str);
        }
        else {
            false = Boolean.FALSE;
        }
        return false;
    }
    
    public static Object syntaxLine(Object form) {
        while (form instanceof SyntaxForm) {
            form = ((SyntaxForm)Promise.force(form, SyntaxForm.class)).getDatum();
        }
        return (form instanceof PairWithPosition) ? Integer.valueOf(((PairWithPosition)Promise.force(form, PairWithPosition.class)).getLineNumber()) : Boolean.FALSE;
    }
    
    public static Object syntaxColumn(final Object form) {
        return (form instanceof SyntaxForm) ? syntaxLine(((SyntaxForm)Promise.force(form, SyntaxForm.class)).getDatum()) : ((form instanceof PairWithPosition) ? Integer.valueOf(((PairWithPosition)Promise.force(form, PairWithPosition.class)).getColumnNumber() - 0) : Boolean.FALSE);
    }
    
    static {
        Lit94 = PairWithPosition.make(Lit92 = Symbol.valueOf("temp"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 294935);
        (Lit93 = new Object[] { null })[0] = (Lit4 = Symbol.valueOf("=>"));
        (Lit91 = new Object[] { null })[0] = (Lit10 = Symbol.valueOf("else"));
        (Lit90 = new Object[] { null })[0] = (Lit75 = Symbol.valueOf("begin"));
        Lit89 = Symbol.valueOf("if");
        (Lit88 = new Object[] { null })[0] = (Lit32 = Symbol.valueOf("%let-lambda2"));
        final Object[] array = Lit87 = new Object[2];
        array[0] = (Lit30 = Symbol.valueOf("%let-lambda1"));
        array[1] = (Lit79 = Symbol.valueOf("::"));
        Lit86 = Symbol.valueOf("letrec");
        Lit85 = Symbol.valueOf("%let");
        (Lit84 = new Object[] { null })[0] = std_syntax.Lit85;
        Lit83 = Symbol.valueOf("syntax-error");
        (Lit82 = new Object[] { null })[0] = (Lit46 = Symbol.valueOf("%do-lambda2"));
        (Lit81 = new Object[] { null })[0] = (Lit44 = Symbol.valueOf("%do-lambda1"));
        final Object[] lit80 = new Object[2];
        (Lit80 = lit80)[0] = std_syntax.Lit44;
        lit80[1] = std_syntax.Lit79;
        (Lit78 = new Object[] { null })[0] = std_syntax.Lit79;
        (Lit77 = new Object[] { null })[0] = Symbol.valueOf("lambda");
        Lit76 = Symbol.valueOf("syntax-case");
        Lit74 = new Object[0];
        Lit73 = new SyntaxRules(std_syntax.Lit74, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\r\u000f\b\b\b", std_syntax.Lit74, 2, "std_syntax.scm:357"), "\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\r\u000b", std_syntax.Lit90, 1), new SyntaxRule(new SyntaxPattern("\f\u0018<,\f\u0007\f\u000f\b\b\f\u0017\r\u001f\u0018\b\b", std_syntax.Lit74, 4, "std_syntax.scm:359"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b\t\u0010\b\t\u0003\b\u0011\u0018\f\t\u0013\b\u001d\u001b", new Object[] { std_syntax.Lit76, std_syntax.Lit75 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018L-\f\u0007\f\u000f\b\u0000\u0010\b\f\u0017\r\u001f\u0018\b\b", std_syntax.Lit74, 4, "std_syntax.scm:361"), "\u0003\u0003\u0001\u0003", "\u0011\u0018\u00041\u0011\u0018\f\b\r\u000b\t\u0010\b\u0019\b\u0005\u0003\b\u0011\u0018\u0014\t\u0013\b\u001d\u001b", new Object[] { std_syntax.Lit76, Symbol.valueOf("list"), std_syntax.Lit75 }, 1) }, 4, Lit72 = Symbol.valueOf("with-syntax"));
        Lit71 = Symbol.valueOf("syntax-column");
        Lit70 = Symbol.valueOf("syntax-line");
        Lit69 = Symbol.valueOf("syntax-source");
        Lit68 = Symbol.valueOf("bound-identifier=?");
        Lit67 = Symbol.valueOf("free-identifier=?");
        Lit66 = Symbol.valueOf("identifier?");
        Lit65 = Symbol.valueOf("generate-temporaries");
        Lit64 = Symbol.valueOf("datum->syntax-object");
        Lit63 = Symbol.valueOf("datum->syntax");
        Lit62 = Symbol.valueOf("syntax-object->datum");
        Lit61 = Symbol.valueOf("syntax->datum");
        Lit60 = new SyntaxRules(std_syntax.Lit74, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u000b", std_syntax.Lit74, 2, "std_syntax.scm:275"), "\u0001\u0000", "\u0011\u0018\u0004\t\u0003\t\f\u0011\u0018\u0014\n", new Object[] { Symbol.valueOf("%define"), IntNum.valueOf(27), Symbol.valueOf("gnu.expr.GenericProc") }, 0) }, 2, Lit59 = Symbol.valueOf("define-procedure"));
        Lit58 = new SyntaxTemplate("\u0001\u0001", "\u0011\u0018\u0004\t\u0010\b\u000b", std_syntax.Lit77, 0);
        Lit57 = new SyntaxPattern("\f\u0007\f\u000f\b", std_syntax.Lit74, 2, "std_syntax.scm:269");
        Lit56 = Symbol.valueOf("delay");
        Lit55 = new SyntaxTemplate("\u0001", "\u0011\u0018\u0004\t\u0010\b\u0003", std_syntax.Lit77, 0);
        Lit54 = new SyntaxPattern("\f\u0018\f\u0007\b", std_syntax.Lit74, 1, "std_syntax.scm:263");
        Lit53 = Symbol.valueOf("delay-force");
        Lit52 = new SyntaxTemplate("\u0001", "\u0011\u0018\u0004\t\u0010\b\u0003", std_syntax.Lit77, 0);
        Lit51 = new SyntaxPattern("\f\u0018\f\u0007\b", std_syntax.Lit74, 1, "std_syntax.scm:257");
        Lit50 = Symbol.valueOf("lazy");
        Lit49 = new SyntaxRules(std_syntax.Lit78, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b\u001c\f\u000f\u0013\r\u001f\u0018\b\b", std_syntax.Lit74, 4, "std_syntax.scm:237"), "\u0003\u0001\u0000\u0003", "\u0011\u0018\u0004\u0189\b\u0011\u0018\f\b\u0011\u0018\u0014\u0019\b\u0005\u0003\t\u0010\b\u0011\u0018\u001c)\u0011\u0018$\b\u000b\u0081\u0011\u0018,\u0011\u001d\u001b\b\u0011\u0018\f\b\u0005\u0011\u00184\u0003\b\u0011\u0018,\u0011\u0018<\u0012\b\u0011\u0018\f\b\u0005\u0011\u0018D\b\u0003", new Object[] { std_syntax.Lit86, Symbol.valueOf("%do%loop"), std_syntax.Lit44, std_syntax.Lit89, Symbol.valueOf("not"), std_syntax.Lit75, Lit40 = Symbol.valueOf("%do-step"), Values.empty, Lit42 = Symbol.valueOf("%do-init") }, 1) }, 4, Lit48 = Symbol.valueOf("do"));
        Lit47 = new SyntaxRules(std_syntax.Lit74, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\f\u0017\f\u001f\b", std_syntax.Lit74, 4, "std_syntax.scm:230"), "\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\n\u0019\t\u0003\u0013\b\u001b", std_syntax.Lit82, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\f\u000f\b", std_syntax.Lit74, 2, "std_syntax.scm:232"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", std_syntax.Lit77, 0) }, 4, std_syntax.Lit46);
        Lit45 = new SyntaxRules(std_syntax.Lit78, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018l\\\f\u0007\f\u0002\f\u000f\f\u0017\f\u001f\b#\f/\f7\b", std_syntax.Lit78, 7, "std_syntax.scm:216"), "\u0001\u0001\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\"I9\t\u0003\u0011\u0018\f\b\u000b+\b3", std_syntax.Lit80, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\L\f\u0007\f\u0002\f\u000f\f\u0017\b\u001b\f'\f/\b", std_syntax.Lit78, 6, "std_syntax.scm:218"), "\u0001\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\u001aI9\t\u0003\u0011\u0018\f\b\u000b#\b+", std_syntax.Lit80, 0), new SyntaxRule(new SyntaxPattern("\f\u0018L<\f\u0007\f\u000f\f\u0017\b\u001b\f'\f/\b", std_syntax.Lit74, 6, "std_syntax.scm:220"), "\u0001\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\u001a\u0019\t\u0003#\b+", std_syntax.Lit81, 0), new SyntaxRule(new SyntaxPattern("\f\u0018<,\f\u0007\f\u000f\b\u0013\f\u001f\f'\b", std_syntax.Lit74, 5, "std_syntax.scm:222"), "\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\u0012\u0019\t\u0003\u001b\b#", std_syntax.Lit81, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\f\u000f\b", std_syntax.Lit74, 2, "std_syntax.scm:224"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u0010\b\u000b", std_syntax.Lit82, 0) }, 7, std_syntax.Lit44);
        Lit43 = new SyntaxRules(std_syntax.Lit78, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0007\f\u0002\f\u000f\f\u0017\f\u001f\b\b", std_syntax.Lit78, 4, "std_syntax.scm:198"), "\u0001\u0001\u0001\u0001", "\u0013", std_syntax.Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0007\f\u0002\f\u000f\f\u0017\b\b", std_syntax.Lit78, 3, "std_syntax.scm:200"), "\u0001\u0001\u0001", "\u0013", std_syntax.Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\f\u000f\f\u0017\b\b", std_syntax.Lit74, 3, "std_syntax.scm:202"), "\u0001\u0001\u0001", "\u000b", std_syntax.Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018,\f\u0007\f\u000f\b\b", std_syntax.Lit74, 2, "std_syntax.scm:204"), "\u0001\u0001", "\u000b", std_syntax.Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\f\u000f\f\u0017\b\b", std_syntax.Lit74, 3, "std_syntax.scm:206"), "\u0001\u0001\u0001", "\u0013", std_syntax.Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\b\b", std_syntax.Lit74, 1, "std_syntax.scm:208"), "\u0001", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("do binding with no value", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 856082)) }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0007\f\u000f\f\u0017\f\u001f\b\b", std_syntax.Lit74, 4, "std_syntax.scm:210"), "\u0001\u0001\u0001\u0001", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("do binding must have syntax: (var [:: type] init [step])", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 868357)) }, 0) }, 4, std_syntax.Lit42);
        Lit41 = new SyntaxRules(std_syntax.Lit78, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\f\u001f\b", std_syntax.Lit78, 4, "std_syntax.scm:191"), "\u0001\u0001\u0001\u0001", "\u001b", std_syntax.Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", std_syntax.Lit78, 3, "std_syntax.scm:192"), "\u0001\u0001\u0001", "\u0003", std_syntax.Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", std_syntax.Lit74, 3, "std_syntax.scm:193"), "\u0001\u0001\u0001", "\u0013", std_syntax.Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", std_syntax.Lit74, 2, "std_syntax.scm:194"), "\u0001\u0001", "\u0003", std_syntax.Lit74, 0) }, 4, std_syntax.Lit40);
        Lit39 = new SyntaxRules(std_syntax.Lit74, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\u0003", std_syntax.Lit74, 1, "std_syntax.scm:173"), "\u0000", "\u0011\u0018\u0004\t\u0010\u0002", std_syntax.Lit84, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\b\u000b", std_syntax.Lit74, 2, "std_syntax.scm:174"), "\u0001\u0000", "\u0011\u0018\u0004\u0011\b\u0003\n", std_syntax.Lit84, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", std_syntax.Lit74, 3, "std_syntax.scm:176"), "\u0001\u0000\u0000", "\u0011\u0018\u0004\u0011\b\u0003\b\u0011\u0018\f\t\n\u0012", new Object[] { std_syntax.Lit85, Lit38 = Symbol.valueOf("let*") }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u000b", std_syntax.Lit74, 2, "std_syntax.scm:179"), "\u0001\u0000", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("invalid bindings list in let*", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 741383)) }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", std_syntax.Lit74, 1, "std_syntax.scm:182"), "\u0000", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("missing bindings list in let*", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 753671)) }, 0) }, 3, std_syntax.Lit38);
        Lit37 = new SyntaxRules(std_syntax.Lit74, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b\u000b", std_syntax.Lit74, 2, "std_syntax.scm:157"), "\u0003\u0000", "\u0011\u0018\u0004\u0019\b\u0005\u0003\n", std_syntax.Lit84, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007,\r\u000f\b\b\b\u0013", std_syntax.Lit74, 3, "std_syntax.scm:164"), "\u0001\u0003\u0000", "©\u0011\u0018\u0004y\b\t\u0003\b\u0011\u0018\f\u0019\b\r\u000b\t\u0010\b\u0012\b\u0003\b\r\u0011\u0018\u0014\b\u000b", new Object[] { std_syntax.Lit86, std_syntax.Lit30, Lit34 = Symbol.valueOf("%let-init") }, 1) }, 3, Lit36 = Symbol.valueOf("let"));
        Lit35 = new SyntaxRules(std_syntax.Lit78, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018,\f\u0007\f\u000f\b\b", std_syntax.Lit74, 2, "std_syntax.scm:143"), "\u0001\u0001", "\u000b", std_syntax.Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0007\f\u0002\f\u000f\f\u0017\b\b", std_syntax.Lit78, 3, "std_syntax.scm:145"), "\u0001\u0001\u0001", "\u0013", std_syntax.Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\f\u000f\f\u0017\b\b", std_syntax.Lit74, 3, "std_syntax.scm:147"), "\u0001\u0001\u0001", "\u0013", std_syntax.Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\b\b", std_syntax.Lit74, 1, "std_syntax.scm:149"), "\u0001", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("let binding with no value", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 614418)) }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0007\f\u000f\f\u0017\f\u001f\b\b", std_syntax.Lit74, 4, "std_syntax.scm:151"), "\u0001\u0001\u0001\u0001", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("let binding must have syntax: (var [type] init)", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 626693)) }, 0) }, 4, std_syntax.Lit34);
        Lit33 = new SyntaxRules(std_syntax.Lit74, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\f\u0017\f\u001f\b", std_syntax.Lit74, 4, "std_syntax.scm:136"), "\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\n\u0019\t\u0003\u0013\b\u001b", std_syntax.Lit88, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\f\u000f\b", std_syntax.Lit74, 2, "std_syntax.scm:138"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\u000b", std_syntax.Lit77, 0) }, 4, std_syntax.Lit32);
        Lit31 = new SyntaxRules(std_syntax.Lit78, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018L<\f\u0007\f\u000f\f\u0017\b\u001b\f'\f/\b", std_syntax.Lit74, 6, "std_syntax.scm:124"), "\u0001\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\u001aI9\t\u0003\u0011\u0018\f\b\u000b#\b+", std_syntax.Lit87, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\L\f\u0007\f\u0002\f\u000f\f\u0017\b\u001b\f'\f/\b", std_syntax.Lit78, 6, "std_syntax.scm:126"), "\u0001\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\u001aI9\t\u0003\u0011\u0018\f\b\u000b#\b+", std_syntax.Lit87, 0), new SyntaxRule(new SyntaxPattern("\f\u0018<,\f\u0007\f\u000f\b\u0013\f\u001f\f'\b", std_syntax.Lit74, 5, "std_syntax.scm:128"), "\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\u0012\u0019\t\u0003\u001b\b#", new Object[] { std_syntax.Lit30 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\f\u000f\b", std_syntax.Lit74, 2, "std_syntax.scm:130"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u0010\b\u000b", std_syntax.Lit88, 0) }, 6, std_syntax.Lit30);
        Lit29 = new SyntaxTemplate("\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0011\u0018\f\u0011\u0018\f\b\u0011\u0018\u001c\b\r\u000b", new Object[] { std_syntax.Lit85, Symbol.valueOf("x"), std_syntax.Lit89, Lit24 = Symbol.valueOf("or") }, 1);
        Lit28 = new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", std_syntax.Lit74, 2, "std_syntax.scm:116");
        Lit27 = new SyntaxTemplate("\u0001", "\u0003", std_syntax.Lit74, 0);
        Lit26 = new SyntaxPattern("\f\u0018\f\u0007\b", std_syntax.Lit74, 1, "std_syntax.scm:115");
        Lit25 = new SyntaxPattern("\f\u0018\b", std_syntax.Lit74, 0, "std_syntax.scm:114");
        Lit23 = new SyntaxTemplate("\u0001\u0000", "\u0011\u0018\u0004\t\u0003!\u0011\u0018\f\n\u0018\u0014", new Object[] { std_syntax.Lit89, Lit18 = Symbol.valueOf("and"), PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 446499) }, 0);
        Lit22 = new SyntaxPattern("\f\u0018\f\u0007\u000b", std_syntax.Lit74, 2, "std_syntax.scm:108");
        Lit21 = new SyntaxTemplate("\u0001", "\u0003", std_syntax.Lit74, 0);
        Lit20 = new SyntaxPattern("\f\u0018\f\u0007\b", std_syntax.Lit74, 1, "std_syntax.scm:107");
        Lit19 = new SyntaxPattern("\f\u0018\b", std_syntax.Lit74, 0, "std_syntax.scm:106");
        Lit17 = new SyntaxRules(new Object[] { std_syntax.Lit10, std_syntax.Lit4 }, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0002\f\u0007\r\u000f\b\b\b\b", std_syntax.Lit91, 2, "std_syntax.scm:64"), "\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\r\u000b", std_syntax.Lit90, 1), new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0002\f\u0007\r\u000f\b\b\b\r\u0017\u0010\b\b", std_syntax.Lit91, 3, "std_syntax.scm:67"), "\u0001\u0003\u0003", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("else clause must be last clause of cond", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 278546)) }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\f\u0002\f\u000f\b\b", std_syntax.Lit93, 2, "std_syntax.scm:70"), "\u0001\u0001", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0011\u0018\f\b\t\u000b\u0018\u001c", new Object[] { std_syntax.Lit85, std_syntax.Lit92, std_syntax.Lit89, std_syntax.Lit94 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\f\u0002\f\u000f\b\f\u0017\r\u001f\u0018\b\b", std_syntax.Lit93, 4, "std_syntax.scm:74"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0011\u0018\f!\t\u000b\u0018\u001c\b\u0011\u0018$\t\u0013\b\u001d\u001b", new Object[] { std_syntax.Lit85, std_syntax.Lit92, std_syntax.Lit89, std_syntax.Lit94, Lit16 = Symbol.valueOf("cond") }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\b\b", std_syntax.Lit74, 1, "std_syntax.scm:80"), "\u0001", "\u0003", std_syntax.Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\b\f\u000f\r\u0017\u0010\b\b", std_syntax.Lit74, 3, "std_syntax.scm:83"), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\t\u000b\b\u0015\u0013", new Object[] { std_syntax.Lit24, std_syntax.Lit16 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0007\f\u000f\r\u0017\u0010\b\b\b", std_syntax.Lit74, 3, "std_syntax.scm:86"), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\t\u000b\b\u0015\u0013", new Object[] { std_syntax.Lit89, std_syntax.Lit75 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0007\f\u000f\r\u0017\u0010\b\b\f\u001f\r' \b\b", std_syntax.Lit74, 5, "std_syntax.scm:89"), "\u0001\u0001\u0003\u0001\u0003", "\u0011\u0018\u0004\t\u0003A\u0011\u0018\f\t\u000b\b\u0015\u0013\b\u0011\u0018\u0014\t\u001b\b%#", new Object[] { std_syntax.Lit89, std_syntax.Lit75, std_syntax.Lit16 }, 1) }, 5, std_syntax.Lit16);
        Lit15 = new SyntaxRules(std_syntax.Lit74, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", std_syntax.Lit74, 1, "std_syntax.scm:56"), "\u0000", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("invalid use of 'unquote-splicing", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 233492)) }, 0) }, 1, Lit14 = Symbol.valueOf("unquote-splicing"));
        Lit13 = new SyntaxRules(std_syntax.Lit74, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", std_syntax.Lit74, 1, "std_syntax.scm:51"), "\u0000", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("invalid use of 'unquote", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 213012)) }, 0) }, 1, Lit12 = Symbol.valueOf("unquote"));
        Lit11 = new SyntaxRules(std_syntax.Lit74, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", std_syntax.Lit74, 1, "std_syntax.scm:46"), "\u0000", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("invalid use of 'else", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 192532)) }, 0) }, 1, std_syntax.Lit10);
        Lit9 = new SyntaxRules(std_syntax.Lit74, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", std_syntax.Lit74, 1, "std_syntax.scm:41"), "\u0000", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("invalid use of '_", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 172052)) }, 0) }, 1, Lit8 = Symbol.valueOf("_"));
        Lit7 = new SyntaxRules(std_syntax.Lit74, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", std_syntax.Lit74, 1, "std_syntax.scm:36"), "\u0000", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("invalid use of '...", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 151572)) }, 0) }, 1, Lit6 = Symbol.valueOf("..."));
        Lit5 = new SyntaxRules(std_syntax.Lit74, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", std_syntax.Lit74, 1, "std_syntax.scm:31"), "\u0000", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("invalid use of '=>", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 131092)) }, 0) }, 1, std_syntax.Lit4);
        Lit3 = new SyntaxRules(std_syntax.Lit74, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", std_syntax.Lit74, 3, "std_syntax.scm:24"), "\u0001\u0001\u0001", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("missing init expression for '?'", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 102420)) }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", std_syntax.Lit74, 1, "std_syntax.scm:26"), "\u0000", "\u0018\u0004", new Object[] { Pair.make(std_syntax.Lit83, PairWithPosition.make("'?' is only allowed in a conditional e.g. 'if' or 'and'", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 110612)) }, 0) }, 3, Lit2 = Symbol.valueOf("?"));
        Lit1 = IntNum.valueOf(1);
        Lit0 = IntNum.valueOf(0);
        std_syntax.$instance = new std_syntax();
        $Prvt$if = StaticFieldLocation.make("kawa.lib.prim_syntax", "if");
        $Prvt$letrec = StaticFieldLocation.make("kawa.lib.prim_syntax", "letrec");
        $Prvt$syntax$Mncase = StaticFieldLocation.make("kawa.standard.syntax_case", "syntax_case");
        $Prvt$$Pclet = StaticFieldLocation.make("kawa.standard.let", "let");
        $Prvt$$Pcdefine = StaticFieldLocation.make("kawa.standard.define", "defineRaw");
        $Prvt$lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");
        $Prvt$not = StaticFieldLocation.make("kawa.standard.Scheme", "not");
        $Prvt$begin = StaticFieldLocation.make("kawa.standard.begin", "begin");
        $Prvt$syntax$Mnerror = StaticFieldLocation.make("kawa.standard.syntax_error", "syntax_error");
        $Qu = Macro.make(std_syntax.Lit2, std_syntax.Lit3, "kawa.lib.std_syntax");
        $Eq$Gr = Macro.make(std_syntax.Lit4, std_syntax.Lit5, "kawa.lib.std_syntax");
        $Dt$Dt$Dt = Macro.make(std_syntax.Lit6, std_syntax.Lit7, "kawa.lib.std_syntax");
        _ = Macro.make(std_syntax.Lit8, std_syntax.Lit9, "kawa.lib.std_syntax");
        else = Macro.make(std_syntax.Lit10, std_syntax.Lit11, "kawa.lib.std_syntax");
        unquote = Macro.make(std_syntax.Lit12, std_syntax.Lit13, "kawa.lib.std_syntax");
        unquote$Mnsplicing = Macro.make(std_syntax.Lit14, std_syntax.Lit15, "kawa.lib.std_syntax");
        cond = Macro.make(std_syntax.Lit16, std_syntax.Lit17, "kawa.lib.std_syntax");
        and = Macro.make(std_syntax.Lit18, new ModuleMethod(std_syntax.$instance, 1, null, 4097), "kawa.lib.std_syntax");
        or = Macro.make(std_syntax.Lit24, new ModuleMethod(std_syntax.$instance, 2, null, 4097), "kawa.lib.std_syntax");
        $Prvt$$Pclet$Mnlambda1 = Macro.make(std_syntax.Lit30, std_syntax.Lit31, "kawa.lib.std_syntax");
        $Prvt$$Pclet$Mnlambda2 = Macro.make(std_syntax.Lit32, std_syntax.Lit33, "kawa.lib.std_syntax");
        $Prvt$$Pclet$Mninit = Macro.make(std_syntax.Lit34, std_syntax.Lit35, "kawa.lib.std_syntax");
        let = Macro.make(std_syntax.Lit36, std_syntax.Lit37, "kawa.lib.std_syntax");
        let$St = Macro.make(std_syntax.Lit38, std_syntax.Lit39, "kawa.lib.std_syntax");
        $Prvt$$Pcdo$Mnstep = Macro.make(std_syntax.Lit40, std_syntax.Lit41, "kawa.lib.std_syntax");
        $Prvt$$Pcdo$Mninit = Macro.make(std_syntax.Lit42, std_syntax.Lit43, "kawa.lib.std_syntax");
        $Prvt$$Pcdo$Mnlambda1 = Macro.make(std_syntax.Lit44, std_syntax.Lit45, "kawa.lib.std_syntax");
        $Prvt$$Pcdo$Mnlambda2 = Macro.make(std_syntax.Lit46, std_syntax.Lit47, "kawa.lib.std_syntax");
        do = Macro.make(std_syntax.Lit48, std_syntax.Lit49, "kawa.lib.std_syntax");
        lazy = Macro.make(std_syntax.Lit50, new ModuleMethod(std_syntax.$instance, 3, null, 4097), "kawa.lib.std_syntax");
        delay$Mnforce = Macro.make(std_syntax.Lit53, new ModuleMethod(std_syntax.$instance, 4, null, 4097), "kawa.lib.std_syntax");
        delay = Macro.make(std_syntax.Lit56, new ModuleMethod(std_syntax.$instance, 5, null, 4097), "kawa.lib.std_syntax");
        define$Mnprocedure = Macro.make(std_syntax.Lit59, std_syntax.Lit60, "kawa.lib.std_syntax");
        final std_syntax $instance = std_syntax.$instance;
        syntax$Mn$Grdatum = new ModuleMethod($instance, 6, std_syntax.Lit61, 4097);
        syntax$Mnobject$Mn$Grdatum = new ModuleMethod($instance, 7, std_syntax.Lit62, 4097);
        datum$Mn$Grsyntax = new ModuleMethod($instance, 8, std_syntax.Lit63, 12290);
        datum$Mn$Grsyntax$Mnobject = new ModuleMethod($instance, 10, std_syntax.Lit64, 8194);
        generate$Mntemporaries = new ModuleMethod($instance, 11, std_syntax.Lit65, 4097);
        identifier$Qu = new ModuleMethod($instance, 12, std_syntax.Lit66, 4097);
        free$Mnidentifier$Eq$Qu = new ModuleMethod($instance, 13, std_syntax.Lit67, 8194);
        bound$Mnidentifier$Eq$Qu = new ModuleMethod($instance, 14, std_syntax.Lit68, 8194);
        syntax$Mnsource = new ModuleMethod($instance, 15, std_syntax.Lit69, 4097);
        syntax$Mnline = new ModuleMethod($instance, 16, std_syntax.Lit70, 4097);
        syntax$Mncolumn = new ModuleMethod($instance, 17, std_syntax.Lit71, 4097);
        with$Mnsyntax = Macro.make(std_syntax.Lit72, std_syntax.Lit73, "kawa.lib.std_syntax");
        $runBody$();
    }
    
    public std_syntax() {
        ModuleInfo.register(this);
    }
    
    static Object lambda1(final Object f) {
        final Object[] allocVars = SyntaxPattern.allocVars(2, null);
        return std_syntax.Lit19.match(f, allocVars, 0) ? new QuoteExp(Language.getDefaultLanguage().booleanObject(true)) : (std_syntax.Lit20.match(f, allocVars, 0) ? std_syntax.Lit21.execute(allocVars, TemplateScope.make()) : (std_syntax.Lit22.match(f, allocVars, 0) ? std_syntax.Lit23.execute(allocVars, TemplateScope.make()) : syntax_case.error("syntax-case", f)));
    }
    
    static Object lambda2(final Object f) {
        final Object[] allocVars = SyntaxPattern.allocVars(2, null);
        return std_syntax.Lit25.match(f, allocVars, 0) ? new QuoteExp(Language.getDefaultLanguage().booleanObject(false)) : (std_syntax.Lit26.match(f, allocVars, 0) ? std_syntax.Lit27.execute(allocVars, TemplateScope.make()) : (std_syntax.Lit28.match(f, allocVars, 0) ? std_syntax.Lit29.execute(allocVars, TemplateScope.make()) : syntax_case.error("syntax-case", f)));
    }
    
    static Object lambda3(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(1, null);
        return std_syntax.Lit51.match(form, allocVars, 0) ? new ApplyExp(MakePromise.makeLazy, new Expression[] { SyntaxForms.rewrite(std_syntax.Lit52.execute(allocVars, TemplateScope.make())) }) : syntax_case.error("syntax-case", form);
    }
    
    static Object lambda4(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(1, null);
        return std_syntax.Lit54.match(form, allocVars, 0) ? new ApplyExp(MakePromise.makeLazy, new Expression[] { SyntaxForms.rewrite(std_syntax.Lit55.execute(allocVars, TemplateScope.make())) }) : syntax_case.error("syntax-case", form);
    }
    
    static Object lambda5(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(2, null);
        return std_syntax.Lit57.match(form, allocVars, 0) ? new ApplyExp(MakePromise.makeDelay, new Expression[] { SyntaxForms.rewrite(std_syntax.Lit58.execute(allocVars, TemplateScope.make())) }) : syntax_case.error("syntax-case", form);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 5: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 3: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 17: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 16: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 15: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 12: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 11: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 7: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 6: {
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
            case 14: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 13: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 10: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 8: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            default: {
                return super.match2(proc, arg1, arg2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        if (moduleMethod.selector == 8) {
            ctx.value1 = o;
            ctx.value2 = o2;
            ctx.value3 = o3;
            ctx.proc = moduleMethod;
            ctx.pc = 3;
            return 0;
        }
        return super.match3(moduleMethod, o, o2, o3, ctx);
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object arg1) {
        switch (method.selector) {
            case 6: {
                return syntax$To$Datum(arg1);
            }
            case 7: {
                return syntaxObject$To$Datum(arg1);
            }
            case 11: {
                return generateTemporaries(arg1);
            }
            case 12: {
                return isIdentifier(arg1) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 15: {
                return syntaxSource(arg1);
            }
            case 16: {
                return syntaxLine(arg1);
            }
            case 17: {
                return syntaxColumn(arg1);
            }
            case 1: {
                return lambda1(arg1);
            }
            case 2: {
                return lambda2(arg1);
            }
            case 3: {
                return lambda3(arg1);
            }
            case 4: {
                return lambda4(arg1);
            }
            case 5: {
                return lambda5(arg1);
            }
            default: {
                return super.apply1(method, arg1);
            }
        }
    }
    
    @Override
    public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
        switch (method.selector) {
            case 8: {
                return datum$To$Syntax(o, o2);
            }
            case 10: {
                return datum$To$SyntaxObject(o, o2);
            }
            case 13: {
                return isFreeIdentifier$Eq(o, o2) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 14: {
                return isBoundIdentifier$Eq(o, o2) ? Boolean.TRUE : Boolean.FALSE;
            }
            default: {
                return super.apply2(method, o, o2);
            }
        }
    }
    
    @Override
    public Object apply3(final ModuleMethod method, final Object o, final Object o2, final Object o3) {
        if (method.selector == 8) {
            return datum$To$Syntax(o, o2, o3);
        }
        return super.apply3(method, o, o2, o3);
    }
}
