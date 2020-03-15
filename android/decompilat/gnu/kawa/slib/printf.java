// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.kawa.io.OutPort;
import kawa.lib.ports;
import kawa.lib.rnrs.unicode;
import gnu.lists.LList;
import kawa.standard.Scheme;
import gnu.kawa.functions.AddOp;
import gnu.mapping.Procedure;
import gnu.expr.Special;
import kawa.lib.exceptions;
import gnu.bytecode.Type;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.lists.Consumer;
import kawa.lib.strings;
import kawa.lib.numbers;
import gnu.mapping.CallContext;
import gnu.lists.FVector;
import gnu.mapping.SimpleSymbol;
import gnu.lists.PairWithPosition;
import gnu.text.Char;
import gnu.math.IntNum;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class printf extends ModuleBody
{
    static boolean stdio$Clhex$Mnupper$Mncase$Qu;
    static final ModuleMethod stdio$Cliprintf;
    public static final ModuleMethod fprintf;
    public static final ModuleMethod printf;
    public static final ModuleMethod sprintf;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final Char Lit2;
    static final Char Lit3;
    static final Char Lit4;
    static final Char Lit5;
    static final Char Lit6;
    static final Char Lit7;
    static final Char Lit8;
    static final Char Lit9;
    static final Char Lit10;
    static final Char Lit11;
    static final Char Lit12;
    static final IntNum Lit13;
    static final Char Lit14;
    static final Char Lit15;
    static final Char Lit16;
    static final Char Lit17;
    static final Char Lit18;
    static final Char Lit19;
    static final Char Lit20;
    static final Char Lit21;
    static final Char Lit22;
    static final PairWithPosition Lit23;
    static final SimpleSymbol Lit24;
    static final Char Lit25;
    static final Char Lit26;
    static final Char Lit27;
    static final Char Lit28;
    static final Char Lit29;
    static final Char Lit30;
    static final Char Lit31;
    static final Char Lit32;
    static final Char Lit33;
    static final Char Lit34;
    static final Char Lit35;
    static final Char Lit36;
    static final IntNum Lit37;
    static final Char Lit38;
    static final Char Lit39;
    static final Char Lit40;
    static final Char Lit41;
    static final IntNum Lit42;
    static final Char Lit43;
    static final Char Lit44;
    static final Char Lit45;
    static final IntNum Lit46;
    static final Char Lit47;
    static final IntNum Lit48;
    static final IntNum Lit49;
    static final IntNum Lit50;
    static final IntNum Lit51;
    static final IntNum Lit52;
    static final FVector Lit53;
    static final PairWithPosition Lit54;
    static final SimpleSymbol Lit55;
    static final Char Lit56;
    static final Char Lit57;
    static final Char Lit58;
    static final Char Lit59;
    static final Char Lit60;
    static final Char Lit61;
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final PairWithPosition Lit64;
    static final Char Lit65;
    static final PairWithPosition Lit66;
    static final IntNum Lit67;
    static final IntNum Lit68;
    public static printf $instance;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        gnu.kawa.slib.printf.stdio$Clhex$Mnupper$Mncase$Qu = strings.isString$Eq("-F", numbers.number$To$String(gnu.kawa.slib.printf.Lit0, 16), new CharSequence[0]);
    }
    
    static Object stdio$ClIprintf$V(final Object out, final Object formatString, final Object[] argsArray) {
        public class printf$frame1 extends ModuleBody
        {
            Procedure format$Mnreal;
            Object fc;
            printf$frame0 staticLink;
            final ModuleMethod lambda$Fn5;
            
            public printf$frame1() {
                this.format$Mnreal = new ModuleMethod(this, 1, gnu.kawa.slib.printf.Lit55, -4092);
                final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 2, null, -4093);
                lambda$Fn5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:402");
                this.lambda$Fn5 = lambda$Fn5;
            }
            
            public Object lambda11formatReal$V(final Object signed$Qu, final Object sgn, final Object digs, final Object exp, final Object[] argsArray) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     2: iconst_0       
                //     3: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
                //     6: dup            
                //     7: astore          7
                //     9: astore          rest
                //    11: aload           rest
                //    13: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //    16: ifeq            1026
                //    19: bipush          45
                //    21: aload_2         /* sgn */
                //    22: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //    25: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
                //    28: if_icmpne       36
                //    31: ldc             "-"
                //    33: goto            65
                //    36: aload_1         /* signed$Qu */
                //    37: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    40: ifeq            48
                //    43: ldc             "+"
                //    45: goto            65
                //    48: aload_0         /* this */
                //    49: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //    52: getfield        gnu/kawa/slib/printf$frame0.blank:Z
                //    55: ifeq            63
                //    58: ldc             " "
                //    60: goto            65
                //    63: ldc             ""
                //    65: aload_0         /* this */
                //    66: getfield        gnu/kawa/slib/printf$frame1.fc:Ljava/lang/Object;
                //    69: invokevirtual   java/lang/Object.hashCode:()I
                //    72: lookupswitch {
                //               69: 180
                //               70: 196
                //               71: 222
                //               75: 993
                //              101: 717
                //              102: 148
                //              103: 164
                //              107: 739
                //          default: 1014
                //        }
                //   148: aload_0         /* this */
                //   149: getfield        gnu/kawa/slib/printf$frame1.fc:Ljava/lang/Object;
                //   152: getstatic       gnu/kawa/slib/printf.Lit3:Lgnu/text/Char;
                //   155: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   158: ifeq            1014
                //   161: goto            209
                //   164: aload_0         /* this */
                //   165: getfield        gnu/kawa/slib/printf$frame1.fc:Ljava/lang/Object;
                //   168: getstatic       gnu/kawa/slib/printf.Lit38:Lgnu/text/Char;
                //   171: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   174: ifeq            1014
                //   177: goto            235
                //   180: aload_0         /* this */
                //   181: getfield        gnu/kawa/slib/printf$frame1.fc:Ljava/lang/Object;
                //   184: getstatic       gnu/kawa/slib/printf.Lit26:Lgnu/text/Char;
                //   187: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   190: ifeq            1014
                //   193: goto            730
                //   196: aload_0         /* this */
                //   197: getfield        gnu/kawa/slib/printf$frame1.fc:Ljava/lang/Object;
                //   200: getstatic       gnu/kawa/slib/printf.Lit5:Lgnu/text/Char;
                //   203: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   206: ifeq            1014
                //   209: aload_0         /* this */
                //   210: aload_3         /* digs */
                //   211: aload           exp
                //   213: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   216: invokevirtual   gnu/kawa/slib/printf$frame1.lambda12f:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   219: goto            1020
                //   222: aload_0         /* this */
                //   223: getfield        gnu/kawa/slib/printf$frame1.fc:Ljava/lang/Object;
                //   226: getstatic       gnu/kawa/slib/printf.Lit27:Lgnu/text/Char;
                //   229: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   232: ifeq            1014
                //   235: aload_3         /* digs */
                //   236: aload           exp
                //   238: astore          8
                //   240: astore          digs
                //   242: aload_0         /* this */
                //   243: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   246: getfield        gnu/kawa/slib/printf$frame0.alternate$Mnform:Z
                //   249: ifeq            256
                //   252: iconst_0       
                //   253: goto            257
                //   256: iconst_1       
                //   257: istore          strip$Mn0s
                //   259: aload_0         /* this */
                //   260: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   263: iconst_0       
                //   264: putfield        gnu/kawa/slib/printf$frame0.alternate$Mnform:Z
                //   267: iconst_m1      
                //   268: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //   271: aload_0         /* this */
                //   272: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   275: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //   278: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   281: aload           exp
                //   283: aload_0         /* this */
                //   284: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   287: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //   290: iconst_0       
                //   291: anewarray       Ljava/lang/Object;
                //   294: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq$V:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
                //   297: ifeq            345
                //   300: aload_0         /* this */
                //   301: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   304: iconst_m1      
                //   305: aload_0         /* this */
                //   306: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   309: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //   312: aload           exp
                //   314: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   317: putfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //   320: aload_0         /* this */
                //   321: aload           digs
                //   323: aload           exp
                //   325: iload           strip$Mn0s
                //   327: ifeq            336
                //   330: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                //   333: goto            339
                //   336: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   339: invokevirtual   gnu/kawa/slib/printf$frame1.lambda12f:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   342: goto            1020
                //   345: aload_0         /* this */
                //   346: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   349: iconst_m1      
                //   350: aload_0         /* this */
                //   351: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   354: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //   357: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //   360: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   363: putfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //   366: aload           digs
                //   368: aload           exp
                //   370: iload           strip$Mn0s
                //   372: ifeq            381
                //   375: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                //   378: goto            387
                //   381: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   384: goto            387
                //   387: astore          11
                //   389: astore          10
                //   391: astore          digs
                //   393: aload           digs
                //   395: ldc             Ljava/lang/CharSequence;.class
                //   397: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   400: dup            
                //   401: astore          13
                //   403: checkcast       Ljava/lang/CharSequence;
                //   406: iconst_1       
                //   407: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //   410: aload_0         /* this */
                //   411: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   414: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //   417: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   420: aload           strip$Mn0s
                //   422: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   425: ifeq            434
                //   428: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
                //   431: goto            437
                //   434: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   437: invokestatic    gnu/kawa/slib/printf.stdio$ClRoundString:(Ljava/lang/CharSequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   440: astore          digs
                //   442: bipush          48
                //   444: aload           digs
                //   446: ldc             Ljava/lang/CharSequence;.class
                //   448: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   451: dup            
                //   452: astore          14
                //   454: checkcast       Ljava/lang/CharSequence;
                //   457: iconst_0       
                //   458: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   461: if_icmpne       470
                //   464: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //   467: goto            473
                //   470: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
                //   473: astore          istrt
                //   475: aload           digs
                //   477: ldc             Ljava/lang/CharSequence;.class
                //   479: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   482: dup            
                //   483: astore          15
                //   485: checkcast       Ljava/lang/CharSequence;
                //   488: iconst_1       
                //   489: aload           istrt
                //   491: invokevirtual   java/lang/Number.intValue:()I
                //   494: iadd           
                //   495: aload           digs
                //   497: ldc             Ljava/lang/CharSequence;.class
                //   499: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   502: dup            
                //   503: astore          15
                //   505: checkcast       Ljava/lang/CharSequence;
                //   508: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   511: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //   514: astore          fdigs
                //   516: aload           istrt
                //   518: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
                //   521: ifeq            529
                //   524: aload           exp
                //   526: goto            538
                //   529: iconst_m1      
                //   530: aload           exp
                //   532: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //   535: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   538: astore          exp
                //   540: aload           digs
                //   542: ldc             Ljava/lang/CharSequence;.class
                //   544: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   547: dup            
                //   548: astore          16
                //   550: checkcast       Ljava/lang/CharSequence;
                //   553: aload           istrt
                //   555: dup            
                //   556: astore          16
                //   558: invokevirtual   java/lang/Number.intValue:()I
                //   561: iconst_1       
                //   562: aload           istrt
                //   564: invokevirtual   java/lang/Number.intValue:()I
                //   567: iadd           
                //   568: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //   571: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   574: dup            
                //   575: aload           fdigs
                //   577: ldc             ""
                //   579: iconst_0       
                //   580: anewarray       Ljava/lang/CharSequence;
                //   583: invokestatic    kawa/lib/strings.isString$Eq:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
                //   586: ifeq            604
                //   589: aload_0         /* this */
                //   590: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   593: getfield        gnu/kawa/slib/printf$frame0.alternate$Mnform:Z
                //   596: ifne            604
                //   599: ldc             ""
                //   601: goto            606
                //   604: ldc             "."
                //   606: aload           fdigs
                //   608: aload_0         /* this */
                //   609: getfield        gnu/kawa/slib/printf$frame1.fc:Ljava/lang/Object;
                //   612: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   615: dup            
                //   616: astore          16
                //   618: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
                //   621: invokestatic    kawa/lib/rnrs/unicode.isCharUpperCase:(I)Z
                //   624: ifeq            632
                //   627: ldc             "E"
                //   629: goto            634
                //   632: ldc             "e"
                //   634: aload           exp
                //   636: ldc             Lgnu/math/RealNum;.class
                //   638: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   641: dup            
                //   642: astore          16
                //   644: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
                //   647: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
                //   650: ifeq            658
                //   653: ldc             "-"
                //   655: goto            660
                //   658: ldc             "+"
                //   660: invokestatic    gnu/lists/LList.chain4:(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   663: getstatic       gnu/kawa/slib/printf.Lit50:Lgnu/math/IntNum;
                //   666: aload           exp
                //   668: getstatic       gnu/kawa/slib/printf.Lit51:Lgnu/math/IntNum;
                //   671: iconst_0       
                //   672: anewarray       Ljava/lang/Object;
                //   675: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$V:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
                //   678: ifeq            686
                //   681: ldc             "0"
                //   683: goto            688
                //   686: ldc             ""
                //   688: invokestatic    gnu/lists/LList.chain1:(Lgnu/lists/Pair;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   691: aload           exp
                //   693: ldc             Ljava/lang/Number;.class
                //   695: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   698: dup            
                //   699: astore          16
                //   701: checkcast       Ljava/lang/Number;
                //   704: invokestatic    kawa/lib/numbers.abs:(Ljava/lang/Number;)Ljava/lang/Number;
                //   707: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
                //   710: invokestatic    gnu/lists/LList.chain1:(Lgnu/lists/Pair;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   713: pop            
                //   714: goto            1020
                //   717: aload_0         /* this */
                //   718: getfield        gnu/kawa/slib/printf$frame1.fc:Ljava/lang/Object;
                //   721: getstatic       gnu/kawa/slib/printf.Lit40:Lgnu/text/Char;
                //   724: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   727: ifeq            1014
                //   730: aload_3         /* digs */
                //   731: aload           exp
                //   733: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   736: goto            387
                //   739: aload_0         /* this */
                //   740: getfield        gnu/kawa/slib/printf$frame1.fc:Ljava/lang/Object;
                //   743: getstatic       gnu/kawa/slib/printf.Lit47:Lgnu/text/Char;
                //   746: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   749: ifeq            1014
                //   752: aload_3         /* digs */
                //   753: aload           exp
                //   755: ldc             ""
                //   757: astore          9
                //   759: astore          8
                //   761: astore          digs
                //   763: aload           exp
                //   765: ldc             Lgnu/math/RealNum;.class
                //   767: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   770: dup            
                //   771: astore          12
                //   773: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
                //   776: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
                //   779: ifeq            803
                //   782: getstatic       gnu/kawa/functions/DivideOp.quotient:Lgnu/kawa/functions/DivideOp;
                //   785: iconst_m1      
                //   786: aload           exp
                //   788: getstatic       gnu/kawa/slib/printf.Lit52:Lgnu/math/IntNum;
                //   791: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   794: getstatic       gnu/kawa/slib/printf.Lit52:Lgnu/math/IntNum;
                //   797: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   800: goto            821
                //   803: getstatic       gnu/kawa/functions/DivideOp.quotient:Lgnu/kawa/functions/DivideOp;
                //   806: iconst_m1      
                //   807: aload           exp
                //   809: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //   812: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   815: getstatic       gnu/kawa/slib/printf.Lit52:Lgnu/math/IntNum;
                //   818: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   821: astore          i
                //   823: getstatic       gnu/kawa/slib/printf.Lit1:Lgnu/math/IntNum;
                //   826: iconst_1       
                //   827: aload           i
                //   829: getstatic       gnu/kawa/slib/printf.Lit46:Lgnu/math/IntNum;
                //   832: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   835: getstatic       gnu/kawa/slib/printf.Lit53:Lgnu/lists/FVector;
                //   838: invokestatic    kawa/lib/vectors.vectorLength:(Lgnu/lists/FVector;)I
                //   841: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //   844: iconst_0       
                //   845: anewarray       Ljava/lang/Object;
                //   848: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$V:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
                //   851: ifeq            859
                //   854: aload           i
                //   856: goto            862
                //   859: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   862: astore          uind
                //   864: aload           uind
                //   866: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   869: ifeq            986
                //   872: iconst_m1      
                //   873: aload           exp
                //   875: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
                //   878: getstatic       gnu/kawa/slib/printf.Lit52:Lgnu/math/IntNum;
                //   881: aload           uind
                //   883: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   886: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   889: astore          exp
                //   891: aload_0         /* this */
                //   892: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   895: iconst_2       
                //   896: anewarray       Ljava/lang/Object;
                //   899: dup            
                //   900: iconst_0       
                //   901: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
                //   904: aastore        
                //   905: dup            
                //   906: iconst_1       
                //   907: iconst_m1      
                //   908: aload_0         /* this */
                //   909: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   912: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //   915: aload           exp
                //   917: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   920: aastore        
                //   921: invokestatic    kawa/lib/numbers.max:([Ljava/lang/Object;)Ljava/lang/Object;
                //   924: putfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //   927: iconst_2       
                //   928: anewarray       Ljava/lang/Object;
                //   931: dup            
                //   932: iconst_0       
                //   933: aload_0         /* this */
                //   934: aload           digs
                //   936: aload           exp
                //   938: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   941: invokevirtual   gnu/kawa/slib/printf$frame1.lambda12f:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   944: aastore        
                //   945: dup            
                //   946: iconst_1       
                //   947: aload           sep
                //   949: getstatic       gnu/kawa/slib/printf.Lit53:Lgnu/lists/FVector;
                //   952: iconst_1       
                //   953: aload           uind
                //   955: getstatic       gnu/kawa/slib/printf.Lit46:Lgnu/math/IntNum;
                //   958: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   961: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   964: dup            
                //   965: astore          11
                //   967: checkcast       Ljava/lang/Number;
                //   970: invokevirtual   java/lang/Number.intValue:()I
                //   973: invokestatic    kawa/lib/vectors.vectorRef:(Lgnu/lists/FVector;I)Ljava/lang/Object;
                //   976: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   979: aastore        
                //   980: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //   983: goto            1020
                //   986: aload           digs
                //   988: aload           exp
                //   990: goto            238
                //   993: aload_0         /* this */
                //   994: getfield        gnu/kawa/slib/printf$frame1.fc:Ljava/lang/Object;
                //   997: getstatic       gnu/kawa/slib/printf.Lit33:Lgnu/text/Char;
                //  1000: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //  1003: ifeq            1014
                //  1006: aload_3         /* digs */
                //  1007: aload           exp
                //  1009: ldc             " "
                //  1011: goto            757
                //  1014: ldc_w           "<bad printf code>"
                //  1017: goto            1020
                //  1020: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //  1023: goto            1073
                //  1026: iconst_3       
                //  1027: anewarray       Ljava/lang/Object;
                //  1030: dup            
                //  1031: iconst_0       
                //  1032: aload_0         /* this */
                //  1033: aload_1         /* signed$Qu */
                //  1034: aload_2         /* sgn */
                //  1035: aload_3         /* digs */
                //  1036: aload           exp
                //  1038: iconst_0       
                //  1039: anewarray       Ljava/lang/Object;
                //  1042: invokevirtual   gnu/kawa/slib/printf$frame1.lambda11formatReal$V:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
                //  1045: aastore        
                //  1046: dup            
                //  1047: iconst_1       
                //  1048: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
                //  1051: aload_0         /* this */
                //  1052: getfield        gnu/kawa/slib/printf$frame1.format$Mnreal:Lgnu/mapping/Procedure;
                //  1055: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                //  1058: aload           rest
                //  1060: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //  1063: aastore        
                //  1064: dup            
                //  1065: iconst_2       
                //  1066: getstatic       gnu/kawa/slib/printf.Lit54:Lgnu/lists/PairWithPosition;
                //  1069: aastore        
                //  1070: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //  1073: areturn        
                //  1074: new             Lgnu/mapping/WrongType;
                //  1077: dup_x1         
                //  1078: swap           
                //  1079: ldc             "stdio:round-string"
                //  1081: iconst_0       
                //  1082: aload           13
                //  1084: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1087: athrow         
                //  1088: new             Lgnu/mapping/WrongType;
                //  1091: dup_x1         
                //  1092: swap           
                //  1093: ldc             "string-ref"
                //  1095: iconst_1       
                //  1096: aload           14
                //  1098: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1101: athrow         
                //  1102: new             Lgnu/mapping/WrongType;
                //  1105: dup_x1         
                //  1106: swap           
                //  1107: ldc             "substring"
                //  1109: iconst_1       
                //  1110: aload           15
                //  1112: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1115: athrow         
                //  1116: new             Lgnu/mapping/WrongType;
                //  1119: dup_x1         
                //  1120: swap           
                //  1121: ldc             "string-length"
                //  1123: iconst_1       
                //  1124: aload           15
                //  1126: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1129: athrow         
                //  1130: new             Lgnu/mapping/WrongType;
                //  1133: dup_x1         
                //  1134: swap           
                //  1135: ldc             "substring"
                //  1137: iconst_1       
                //  1138: aload           16
                //  1140: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1143: athrow         
                //  1144: new             Lgnu/mapping/WrongType;
                //  1147: dup_x1         
                //  1148: swap           
                //  1149: ldc             "substring"
                //  1151: iconst_2       
                //  1152: aload           16
                //  1154: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1157: athrow         
                //  1158: new             Lgnu/mapping/WrongType;
                //  1161: dup_x1         
                //  1162: swap           
                //  1163: ldc             "char-upper-case?"
                //  1165: iconst_1       
                //  1166: aload           16
                //  1168: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1171: athrow         
                //  1172: new             Lgnu/mapping/WrongType;
                //  1175: dup_x1         
                //  1176: swap           
                //  1177: ldc             "negative?"
                //  1179: iconst_1       
                //  1180: aload           16
                //  1182: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1185: athrow         
                //  1186: new             Lgnu/mapping/WrongType;
                //  1189: dup_x1         
                //  1190: swap           
                //  1191: ldc             "abs"
                //  1193: iconst_1       
                //  1194: aload           16
                //  1196: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1199: athrow         
                //  1200: new             Lgnu/mapping/WrongType;
                //  1203: dup_x1         
                //  1204: swap           
                //  1205: ldc             "negative?"
                //  1207: iconst_1       
                //  1208: aload           12
                //  1210: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1213: athrow         
                //  1214: new             Lgnu/mapping/WrongType;
                //  1217: dup_x1         
                //  1218: swap           
                //  1219: ldc_w           "vector-ref"
                //  1222: iconst_2       
                //  1223: aload           11
                //  1225: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //  1228: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  403    406    1074   1088   Ljava/lang/ClassCastException;
                //  454    457    1088   1102   Ljava/lang/ClassCastException;
                //  485    488    1102   1116   Ljava/lang/ClassCastException;
                //  505    508    1116   1130   Ljava/lang/ClassCastException;
                //  550    553    1130   1144   Ljava/lang/ClassCastException;
                //  558    561    1144   1158   Ljava/lang/ClassCastException;
                //  618    621    1158   1172   Ljava/lang/ClassCastException;
                //  644    647    1172   1186   Ljava/lang/ClassCastException;
                //  701    704    1186   1200   Ljava/lang/ClassCastException;
                //  773    776    1200   1214   Ljava/lang/ClassCastException;
                //  967    973    1214   1229   Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
            
            public Object lambda12f(final Object digs, final Object exp, final Object strip$Mn0s) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: ldc             Ljava/lang/CharSequence;.class
                //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //     6: dup            
                //     7: astore          5
                //     9: checkcast       Ljava/lang/CharSequence;
                //    12: iconst_1       
                //    13: aload_2         /* exp */
                //    14: aload_0         /* this */
                //    15: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //    18: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //    21: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    24: aload_3         /* strip$Mn0s */
                //    25: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    28: ifeq            35
                //    31: aload_2         /* exp */
                //    32: goto            38
                //    35: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //    38: invokestatic    gnu/kawa/slib/printf.stdio$ClRoundString:(Ljava/lang/CharSequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    41: astore          digs
                //    43: aload_2         /* exp */
                //    44: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
                //    47: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    50: ifeq            269
                //    53: aload_2         /* exp */
                //    54: ldc             Ljava/lang/Number;.class
                //    56: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    59: dup            
                //    60: astore          6
                //    62: checkcast       Ljava/lang/Number;
                //    65: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
                //    68: ifeq            77
                //    71: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
                //    74: goto            108
                //    77: bipush          48
                //    79: aload           digs
                //    81: ldc             Ljava/lang/CharSequence;.class
                //    83: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    86: dup            
                //    87: astore          6
                //    89: checkcast       Ljava/lang/CharSequence;
                //    92: iconst_0       
                //    93: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //    96: if_icmpne       105
                //    99: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //   102: goto            108
                //   105: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
                //   108: astore          i0
                //   110: iconst_2       
                //   111: anewarray       Ljava/lang/Object;
                //   114: dup            
                //   115: iconst_0       
                //   116: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //   119: aastore        
                //   120: dup            
                //   121: iconst_1       
                //   122: iconst_1       
                //   123: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //   126: aload_2         /* exp */
                //   127: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   130: aastore        
                //   131: invokestatic    kawa/lib/numbers.max:([Ljava/lang/Object;)Ljava/lang/Object;
                //   134: astore          i1
                //   136: aload           digs
                //   138: ldc             Ljava/lang/CharSequence;.class
                //   140: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   143: dup            
                //   144: astore          8
                //   146: checkcast       Ljava/lang/CharSequence;
                //   149: aload           i0
                //   151: dup            
                //   152: astore          8
                //   154: invokevirtual   java/lang/Number.intValue:()I
                //   157: aload           i1
                //   159: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   162: dup            
                //   163: astore          8
                //   165: checkcast       Ljava/lang/Number;
                //   168: invokevirtual   java/lang/Number.intValue:()I
                //   171: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //   174: astore          idigs
                //   176: aload           digs
                //   178: ldc             Ljava/lang/CharSequence;.class
                //   180: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   183: dup            
                //   184: astore          9
                //   186: checkcast       Ljava/lang/CharSequence;
                //   189: aload           i1
                //   191: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   194: dup            
                //   195: astore          9
                //   197: checkcast       Ljava/lang/Number;
                //   200: invokevirtual   java/lang/Number.intValue:()I
                //   203: aload           digs
                //   205: ldc             Ljava/lang/CharSequence;.class
                //   207: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   210: dup            
                //   211: astore          9
                //   213: checkcast       Ljava/lang/CharSequence;
                //   216: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   219: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //   222: astore          fdigs
                //   224: aload           idigs
                //   226: aload           fdigs
                //   228: ldc             ""
                //   230: iconst_0       
                //   231: anewarray       Ljava/lang/CharSequence;
                //   234: invokestatic    kawa/lib/strings.isString$Eq:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
                //   237: ifeq            256
                //   240: aload_0         /* this */
                //   241: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   244: getfield        gnu/kawa/slib/printf$frame0.alternate$Mnform:Z
                //   247: ifne            256
                //   250: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //   253: goto            263
                //   256: ldc             "."
                //   258: aload           fdigs
                //   260: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   263: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   266: goto            434
                //   269: aload_0         /* this */
                //   270: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   273: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //   276: ldc             Ljava/lang/Number;.class
                //   278: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   281: dup            
                //   282: astore          5
                //   284: checkcast       Ljava/lang/Number;
                //   287: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
                //   290: ifeq            317
                //   293: aload_0         /* this */
                //   294: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   297: getfield        gnu/kawa/slib/printf$frame0.alternate$Mnform:Z
                //   300: ifeq            309
                //   303: ldc_w           "0."
                //   306: goto            311
                //   309: ldc             "0"
                //   311: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   314: goto            434
                //   317: aload_3         /* strip$Mn0s */
                //   318: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   321: ifeq            363
                //   324: aload           digs
                //   326: ldc             Ljava/lang/CharSequence;.class
                //   328: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   331: dup            
                //   332: astore          6
                //   334: checkcast       Ljava/lang/CharSequence;
                //   337: ldc             ""
                //   339: iconst_0       
                //   340: anewarray       Ljava/lang/CharSequence;
                //   343: invokestatic    kawa/lib/strings.isString$Eq:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
                //   346: ifeq            357
                //   349: ldc             "0"
                //   351: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   354: goto            366
                //   357: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   360: goto            366
                //   363: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   366: astore          x
                //   368: aload           x
                //   370: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   373: ifeq            381
                //   376: aload           x
                //   378: goto            434
                //   381: ldc_w           "0."
                //   384: iconst_2       
                //   385: anewarray       Ljava/lang/Object;
                //   388: dup            
                //   389: iconst_0       
                //   390: aload_0         /* this */
                //   391: getfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
                //   394: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //   397: aastore        
                //   398: dup            
                //   399: iconst_1       
                //   400: iconst_m1      
                //   401: getstatic       gnu/kawa/slib/printf.Lit1:Lgnu/math/IntNum;
                //   404: aload_2         /* exp */
                //   405: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   408: aastore        
                //   409: invokestatic    kawa/lib/numbers.min:([Ljava/lang/Object;)Ljava/lang/Object;
                //   412: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   415: dup            
                //   416: astore          6
                //   418: checkcast       Ljava/lang/Number;
                //   421: invokevirtual   java/lang/Number.intValue:()I
                //   424: bipush          48
                //   426: invokestatic    kawa/lib/strings.makeString:(II)Lgnu/lists/FString;
                //   429: aload           digs
                //   431: invokestatic    gnu/lists/LList.list3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   434: areturn        
                //   435: new             Lgnu/mapping/WrongType;
                //   438: dup_x1         
                //   439: swap           
                //   440: ldc             "stdio:round-string"
                //   442: iconst_0       
                //   443: aload           5
                //   445: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   448: athrow         
                //   449: new             Lgnu/mapping/WrongType;
                //   452: dup_x1         
                //   453: swap           
                //   454: ldc_w           "zero?"
                //   457: iconst_1       
                //   458: aload           6
                //   460: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   463: athrow         
                //   464: new             Lgnu/mapping/WrongType;
                //   467: dup_x1         
                //   468: swap           
                //   469: ldc             "string-ref"
                //   471: iconst_1       
                //   472: aload           6
                //   474: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   477: athrow         
                //   478: new             Lgnu/mapping/WrongType;
                //   481: dup_x1         
                //   482: swap           
                //   483: ldc             "substring"
                //   485: iconst_1       
                //   486: aload           8
                //   488: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   491: athrow         
                //   492: new             Lgnu/mapping/WrongType;
                //   495: dup_x1         
                //   496: swap           
                //   497: ldc             "substring"
                //   499: iconst_2       
                //   500: aload           8
                //   502: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   505: athrow         
                //   506: new             Lgnu/mapping/WrongType;
                //   509: dup_x1         
                //   510: swap           
                //   511: ldc             "substring"
                //   513: iconst_3       
                //   514: aload           8
                //   516: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   519: athrow         
                //   520: new             Lgnu/mapping/WrongType;
                //   523: dup_x1         
                //   524: swap           
                //   525: ldc             "substring"
                //   527: iconst_1       
                //   528: aload           9
                //   530: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   533: athrow         
                //   534: new             Lgnu/mapping/WrongType;
                //   537: dup_x1         
                //   538: swap           
                //   539: ldc             "substring"
                //   541: iconst_2       
                //   542: aload           9
                //   544: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   547: athrow         
                //   548: new             Lgnu/mapping/WrongType;
                //   551: dup_x1         
                //   552: swap           
                //   553: ldc             "string-length"
                //   555: iconst_1       
                //   556: aload           9
                //   558: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   561: athrow         
                //   562: new             Lgnu/mapping/WrongType;
                //   565: dup_x1         
                //   566: swap           
                //   567: ldc_w           "zero?"
                //   570: iconst_1       
                //   571: aload           5
                //   573: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   576: athrow         
                //   577: new             Lgnu/mapping/WrongType;
                //   580: dup_x1         
                //   581: swap           
                //   582: ldc_w           "string=?"
                //   585: iconst_1       
                //   586: aload           6
                //   588: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   591: athrow         
                //   592: new             Lgnu/mapping/WrongType;
                //   595: dup_x1         
                //   596: swap           
                //   597: ldc_w           "make-string"
                //   600: iconst_1       
                //   601: aload           6
                //   603: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   606: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  9      12     435    449    Ljava/lang/ClassCastException;
                //  62     65     449    464    Ljava/lang/ClassCastException;
                //  89     92     464    478    Ljava/lang/ClassCastException;
                //  146    149    478    492    Ljava/lang/ClassCastException;
                //  154    157    492    506    Ljava/lang/ClassCastException;
                //  165    171    506    520    Ljava/lang/ClassCastException;
                //  186    189    520    534    Ljava/lang/ClassCastException;
                //  197    203    534    548    Ljava/lang/ClassCastException;
                //  213    216    548    562    Ljava/lang/ClassCastException;
                //  284    287    562    577    Ljava/lang/ClassCastException;
                //  334    337    577    592    Ljava/lang/ClassCastException;
                //  418    424    592    607    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 288 out of bounds for length 288
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
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
            
            Object lambda13$V(final Object sgn, final Object digs, final Object expon, final Object[] argsArray) {
                final LList imag = LList.makeList(argsArray, 0);
                return Scheme.apply.apply2(this.staticLink.pad, Scheme.apply.applyN(new Object[] { this.format$Mnreal, this.staticLink.signed ? Boolean.TRUE : Boolean.FALSE, sgn, digs, expon, imag }));
            }
            
            @Override
            public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
                switch (proc.selector) {
                    case 2: {
                        ctx.values = args;
                        ctx.proc = proc;
                        ctx.pc = 5;
                        return 0;
                    }
                    case 1: {
                        ctx.values = args;
                        ctx.proc = proc;
                        ctx.pc = 5;
                        return 0;
                    }
                    default: {
                        return super.matchN(proc, args, ctx);
                    }
                }
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object applyN(final ModuleMethod method, final Object[] args) {
                switch (method.selector) {
                    case 1: {
                        final Object signed$Qu = args[0];
                        final Object sgn = args[1];
                        final Object digs = args[2];
                        final Object exp = args[3];
                        int n = args.length - 4;
                        final Object[] argsArray = new Object[n];
                        while (--n >= 0) {
                            argsArray[n] = args[n + 4];
                        }
                        return this.lambda11formatReal$V(signed$Qu, sgn, digs, exp, argsArray);
                    }
                    case 2: {
                        final Object sgn2 = args[0];
                        final Object digs2 = args[1];
                        final Object expon = args[2];
                        int n2 = args.length - 3;
                        final Object[] argsArray2 = new Object[n2];
                        while (--n2 >= 0) {
                            argsArray2[n2] = args[n2 + 3];
                        }
                        return this.lambda13$V(sgn2, digs2, expon, argsArray2);
                    }
                    default: {
                        return super.applyN(method, args);
                    }
                }
            }
        }
        public class printf$frame0 extends ModuleBody
        {
            Object os;
            Object pr;
            Procedure pad;
            boolean alternate$Mnform;
            boolean blank;
            boolean signed;
            Object precision;
            boolean leading$Mn0s;
            boolean left$Mnadjust;
            Object width;
            Object args;
            printf$frame staticLink;
            final ModuleMethod lambda$Fn1;
            final ModuleMethod lambda$Fn2;
            final ModuleMethod lambda$Fn3;
            final ModuleMethod lambda$Fn4;
            
            public printf$frame0() {
                this.pad = new ModuleMethod(this, 3, gnu.kawa.slib.printf.Lit62, -4095);
                final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 4, null, 4097);
                lambda$Fn1.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:473");
                this.lambda$Fn1 = lambda$Fn1;
                final ModuleMethod lambda$Fn2 = new ModuleMethod(this, 5, null, 4097);
                lambda$Fn2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:477");
                this.lambda$Fn2 = lambda$Fn2;
                final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 6, null, 4097);
                lambda$Fn3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:485");
                this.lambda$Fn3 = lambda$Fn3;
                final ModuleMethod lambda$Fn4 = new ModuleMethod(this, 7, null, 4097);
                lambda$Fn4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:495");
                this.lambda$Fn4 = lambda$Fn4;
            }
            
            public Object lambda3pad$V(final Object pre, final Object[] argsArray) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: iconst_0       
                //     2: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
                //     5: dup            
                //     6: astore          4
                //     8: astore_3        /* strs */
                //     9: aload_1         /* pre */
                //    10: ldc             Ljava/lang/CharSequence;.class
                //    12: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    15: dup            
                //    16: astore          4
                //    18: checkcast       Ljava/lang/CharSequence;
                //    21: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //    24: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //    27: aload_3         /* strs */
                //    28: astore          5
                //    30: astore          len
                //    32: aload           len
                //    34: aload_0         /* this */
                //    35: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
                //    38: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    41: ifeq            52
                //    44: aload_1         /* pre */
                //    45: aload_3         /* strs */
                //    46: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //    49: goto            259
                //    52: aload           ss
                //    54: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //    57: ifeq            201
                //    60: aload_0         /* this */
                //    61: getfield        gnu/kawa/slib/printf$frame0.left$Mnadjust:Z
                //    64: ifeq            118
                //    67: aload_1         /* pre */
                //    68: iconst_2       
                //    69: anewarray       Ljava/lang/Object;
                //    72: dup            
                //    73: iconst_0       
                //    74: aload_3         /* strs */
                //    75: aastore        
                //    76: dup            
                //    77: iconst_1       
                //    78: iconst_m1      
                //    79: aload_0         /* this */
                //    80: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
                //    83: aload           len
                //    85: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    88: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //    91: dup            
                //    92: astore          6
                //    94: checkcast       Ljava/lang/Number;
                //    97: invokevirtual   java/lang/Number.intValue:()I
                //   100: bipush          32
                //   102: invokestatic    kawa/lib/strings.makeString:(II)Lgnu/lists/FString;
                //   105: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   108: aastore        
                //   109: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //   112: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   115: goto            259
                //   118: aload_0         /* this */
                //   119: getfield        gnu/kawa/slib/printf$frame0.leading$Mn0s:Z
                //   122: ifeq            163
                //   125: aload_1         /* pre */
                //   126: iconst_m1      
                //   127: aload_0         /* this */
                //   128: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
                //   131: aload           len
                //   133: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   136: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   139: dup            
                //   140: astore          6
                //   142: checkcast       Ljava/lang/Number;
                //   145: invokevirtual   java/lang/Number.intValue:()I
                //   148: bipush          48
                //   150: invokestatic    kawa/lib/strings.makeString:(II)Lgnu/lists/FString;
                //   153: aload_3         /* strs */
                //   154: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   157: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   160: goto            259
                //   163: iconst_m1      
                //   164: aload_0         /* this */
                //   165: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
                //   168: aload           len
                //   170: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   173: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   176: dup            
                //   177: astore          6
                //   179: checkcast       Ljava/lang/Number;
                //   182: invokevirtual   java/lang/Number.intValue:()I
                //   185: bipush          32
                //   187: invokestatic    kawa/lib/strings.makeString:(II)Lgnu/lists/FString;
                //   190: aload_1         /* pre */
                //   191: aload_3         /* strs */
                //   192: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   195: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   198: goto            259
                //   201: iconst_1       
                //   202: aload           len
                //   204: aload           ss
                //   206: ldc             Lgnu/lists/Pair;.class
                //   208: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   211: dup            
                //   212: astore          6
                //   214: checkcast       Lgnu/lists/Pair;
                //   217: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   220: ldc             Ljava/lang/CharSequence;.class
                //   222: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   225: dup            
                //   226: astore          6
                //   228: checkcast       Ljava/lang/CharSequence;
                //   231: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   234: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //   237: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   240: aload           ss
                //   242: ldc             Lgnu/lists/Pair;.class
                //   244: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   247: dup            
                //   248: astore          6
                //   250: checkcast       Lgnu/lists/Pair;
                //   253: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   256: goto            28
                //   259: areturn        
                //   260: new             Lgnu/mapping/WrongType;
                //   263: dup_x1         
                //   264: swap           
                //   265: ldc             "string-length"
                //   267: iconst_1       
                //   268: aload           4
                //   270: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   273: athrow         
                //   274: new             Lgnu/mapping/WrongType;
                //   277: dup_x1         
                //   278: swap           
                //   279: ldc             "make-string"
                //   281: iconst_1       
                //   282: aload           6
                //   284: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   287: athrow         
                //   288: new             Lgnu/mapping/WrongType;
                //   291: dup_x1         
                //   292: swap           
                //   293: ldc             "make-string"
                //   295: iconst_1       
                //   296: aload           6
                //   298: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   301: athrow         
                //   302: new             Lgnu/mapping/WrongType;
                //   305: dup_x1         
                //   306: swap           
                //   307: ldc             "make-string"
                //   309: iconst_1       
                //   310: aload           6
                //   312: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   315: athrow         
                //   316: new             Lgnu/mapping/WrongType;
                //   319: dup_x1         
                //   320: swap           
                //   321: ldc             "car"
                //   323: iconst_1       
                //   324: aload           6
                //   326: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   329: athrow         
                //   330: new             Lgnu/mapping/WrongType;
                //   333: dup_x1         
                //   334: swap           
                //   335: ldc             "string-length"
                //   337: iconst_1       
                //   338: aload           6
                //   340: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   343: athrow         
                //   344: new             Lgnu/mapping/WrongType;
                //   347: dup_x1         
                //   348: swap           
                //   349: ldc             "cdr"
                //   351: iconst_1       
                //   352: aload           6
                //   354: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   357: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  18     21     260    274    Ljava/lang/ClassCastException;
                //  94     100    274    288    Ljava/lang/ClassCastException;
                //  142    148    288    302    Ljava/lang/ClassCastException;
                //  179    185    302    316    Ljava/lang/ClassCastException;
                //  214    217    316    330    Ljava/lang/ClassCastException;
                //  228    231    330    344    Ljava/lang/ClassCastException;
                //  250    253    344    358    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
            
            public Object lambda4readFormatNumber(final Object fl) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     3: aload_0         /* this */
                //     4: getfield        gnu/kawa/slib/printf$frame0.staticLink:Lgnu/kawa/slib/printf$frame;
                //     7: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
                //    10: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    13: ifeq            67
                //    16: aload_0         /* this */
                //    17: getfield        gnu/kawa/slib/printf$frame0.staticLink:Lgnu/kawa/slib/printf$frame;
                //    20: aload_1         /* fl */
                //    21: invokevirtual   gnu/kawa/slib/printf$frame.lambda2mustAdvance:(Ljava/lang/Object;)V
                //    24: aload_0         /* this */
                //    25: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
                //    28: ldc             Lgnu/lists/Pair;.class
                //    30: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    33: dup            
                //    34: astore_3       
                //    35: checkcast       Lgnu/lists/Pair;
                //    38: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    41: astore_2        /* ans */
                //    42: aload_0         /* this */
                //    43: aload_0         /* this */
                //    44: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
                //    47: ldc             Lgnu/lists/Pair;.class
                //    49: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    52: dup            
                //    53: astore_3       
                //    54: checkcast       Lgnu/lists/Pair;
                //    57: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    60: putfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
                //    63: aload_2         /* ans */
                //    64: goto            163
                //    67: aload_0         /* this */
                //    68: getfield        gnu/kawa/slib/printf$frame0.staticLink:Lgnu/kawa/slib/printf$frame;
                //    71: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
                //    74: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
                //    77: astore_3       
                //    78: astore_2        /* c */
                //    79: aload_0         /* this */
                //    80: getfield        gnu/kawa/slib/printf$frame0.staticLink:Lgnu/kawa/slib/printf$frame;
                //    83: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
                //    86: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //    89: dup            
                //    90: astore          4
                //    92: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
                //    95: invokestatic    kawa/lib/rnrs/unicode.isCharNumeric:(I)Z
                //    98: ifeq            162
                //   101: aload_0         /* this */
                //   102: getfield        gnu/kawa/slib/printf$frame0.staticLink:Lgnu/kawa/slib/printf$frame;
                //   105: aload_1         /* fl */
                //   106: invokevirtual   gnu/kawa/slib/printf$frame.lambda2mustAdvance:(Ljava/lang/Object;)V
                //   109: aload_0         /* this */
                //   110: getfield        gnu/kawa/slib/printf$frame0.staticLink:Lgnu/kawa/slib/printf$frame;
                //   113: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
                //   116: iconst_1       
                //   117: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
                //   120: aload_3         /* accum */
                //   121: getstatic       gnu/kawa/slib/printf.Lit51:Lgnu/math/IntNum;
                //   124: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   127: aload_2         /* c */
                //   128: dup            
                //   129: instanceof      [Ljava/lang/Object;
                //   132: ifeq            141
                //   135: checkcast       [Ljava/lang/Object;
                //   138: goto            150
                //   141: iconst_1       
                //   142: anewarray       Ljava/lang/Object;
                //   145: dup_x1         
                //   146: swap           
                //   147: iconst_0       
                //   148: swap           
                //   149: aastore        
                //   150: invokestatic    kawa/lib/strings.$make$string$:([Ljava/lang/Object;)Ljava/lang/CharSequence;
                //   153: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;)Ljava/lang/Object;
                //   156: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   159: goto            77
                //   162: aload_3         /* accum */
                //   163: areturn        
                //   164: new             Lgnu/mapping/WrongType;
                //   167: dup_x1         
                //   168: swap           
                //   169: ldc             "car"
                //   171: iconst_1       
                //   172: aload_3        
                //   173: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   176: athrow         
                //   177: new             Lgnu/mapping/WrongType;
                //   180: dup_x1         
                //   181: swap           
                //   182: ldc             "cdr"
                //   184: iconst_1       
                //   185: aload_3        
                //   186: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   189: athrow         
                //   190: new             Lgnu/mapping/WrongType;
                //   193: dup_x1         
                //   194: swap           
                //   195: ldc             "char-numeric?"
                //   197: iconst_1       
                //   198: aload           4
                //   200: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   203: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  35     38     164    177    Ljava/lang/ClassCastException;
                //  54     57     177    190    Ljava/lang/ClassCastException;
                //  92     95     190    204    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
            
            public Object lambda6integerConvert(final Object s, final IntNum radix, final Object fixcase) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //     4: ldc             Lgnu/math/RealNum;.class
                //     6: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //     9: dup            
                //    10: astore          4
                //    12: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
                //    15: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
                //    18: ifne            63
                //    21: aload_0         /* this */
                //    22: iconst_0       
                //    23: putfield        gnu/kawa/slib/printf$frame0.leading$Mn0s:Z
                //    26: aload_0         /* this */
                //    27: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //    30: ldc             Ljava/lang/Number;.class
                //    32: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    35: dup            
                //    36: astore          4
                //    38: checkcast       Ljava/lang/Number;
                //    41: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
                //    44: ifeq            63
                //    47: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
                //    50: aload_1         /* s */
                //    51: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    54: ifeq            63
                //    57: ldc             ""
                //    59: astore_1        /* s */
                //    60: goto            63
                //    63: aload_1         /* s */
                //    64: invokestatic    kawa/lib/misc.isSymbol:(Ljava/lang/Object;)Z
                //    67: ifeq            88
                //    70: aload_1         /* s */
                //    71: ldc             Lgnu/mapping/Symbol;.class
                //    73: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    76: dup            
                //    77: astore          4
                //    79: checkcast       Lgnu/mapping/Symbol;
                //    82: invokestatic    kawa/lib/misc.symbol$To$String:(Lgnu/mapping/Symbol;)Ljava/lang/String;
                //    85: goto            174
                //    88: aload_1         /* s */
                //    89: invokestatic    kawa/lib/numbers.isNumber:(Ljava/lang/Object;)Z
                //    92: ifeq            120
                //    95: aload_1         /* s */
                //    96: ldc             Ljava/lang/Number;.class
                //    98: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   101: dup            
                //   102: astore          4
                //   104: checkcast       Ljava/lang/Number;
                //   107: aload_2         /* radix */
                //   108: dup            
                //   109: astore          4
                //   111: invokevirtual   java/lang/Number.intValue:()I
                //   114: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;I)Ljava/lang/CharSequence;
                //   117: goto            174
                //   120: aload_1         /* s */
                //   121: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   124: ifeq            131
                //   127: iconst_0       
                //   128: goto            132
                //   131: iconst_1       
                //   132: istore          x
                //   134: iload           x
                //   136: ifeq            147
                //   139: iload           x
                //   141: ifeq            160
                //   144: goto            154
                //   147: aload_1         /* s */
                //   148: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   151: ifeq            160
                //   154: ldc_w           "0"
                //   157: goto            174
                //   160: aload_1         /* s */
                //   161: invokestatic    kawa/lib/strings.isString:(Ljava/lang/Object;)Z
                //   164: ifeq            171
                //   167: aload_1         /* s */
                //   168: goto            174
                //   171: ldc_w           "1"
                //   174: astore_1        /* s */
                //   175: aload_3         /* fixcase */
                //   176: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   179: ifeq            191
                //   182: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   185: aload_3         /* fixcase */
                //   186: aload_1         /* s */
                //   187: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   190: astore_1        /* s */
                //   191: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
                //   194: ldc             ""
                //   196: aload_1         /* s */
                //   197: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   200: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   203: ifeq            211
                //   206: ldc             ""
                //   208: goto            379
                //   211: getstatic       gnu/kawa/slib/printf.Lit18:Lgnu/text/Char;
                //   214: aload_1         /* s */
                //   215: ldc             Ljava/lang/CharSequence;.class
                //   217: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   220: dup            
                //   221: astore          5
                //   223: checkcast       Ljava/lang/CharSequence;
                //   226: iconst_0       
                //   227: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   230: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //   233: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   236: ifeq            277
                //   239: aload_1         /* s */
                //   240: ldc             Ljava/lang/CharSequence;.class
                //   242: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   245: dup            
                //   246: astore          5
                //   248: checkcast       Ljava/lang/CharSequence;
                //   251: iconst_1       
                //   252: aload_1         /* s */
                //   253: ldc             Ljava/lang/CharSequence;.class
                //   255: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   258: dup            
                //   259: astore          5
                //   261: checkcast       Ljava/lang/CharSequence;
                //   264: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   267: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //   270: astore_1        /* s */
                //   271: ldc_w           "-"
                //   274: goto            379
                //   277: aload_0         /* this */
                //   278: getfield        gnu/kawa/slib/printf$frame0.signed:Z
                //   281: ifeq            290
                //   284: ldc_w           "+"
                //   287: goto            379
                //   290: aload_0         /* this */
                //   291: getfield        gnu/kawa/slib/printf$frame0.blank:Z
                //   294: ifeq            303
                //   297: ldc_w           " "
                //   300: goto            379
                //   303: aload_0         /* this */
                //   304: getfield        gnu/kawa/slib/printf$frame0.alternate$Mnform:Z
                //   307: ifeq            377
                //   310: aload_2         /* radix */
                //   311: invokevirtual   java/lang/Object.hashCode:()I
                //   314: lookupswitch {
                //                8: 356
                //               16: 340
                //          default: 372
                //        }
                //   340: aload_2         /* radix */
                //   341: getstatic       gnu/kawa/slib/printf.Lit37:Lgnu/math/IntNum;
                //   344: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   347: ifeq            372
                //   350: ldc_w           "0x"
                //   353: goto            379
                //   356: aload_2         /* radix */
                //   357: getstatic       gnu/kawa/slib/printf.Lit46:Lgnu/math/IntNum;
                //   360: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   363: ifeq            372
                //   366: ldc_w           "0"
                //   369: goto            379
                //   372: ldc             ""
                //   374: goto            379
                //   377: ldc             ""
                //   379: astore          pre
                //   381: aload_0         /* this */
                //   382: aload           pre
                //   384: iconst_2       
                //   385: anewarray       Ljava/lang/Object;
                //   388: dup            
                //   389: iconst_0       
                //   390: aload_1         /* s */
                //   391: ldc             Ljava/lang/CharSequence;.class
                //   393: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   396: dup            
                //   397: astore          5
                //   399: checkcast       Ljava/lang/CharSequence;
                //   402: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   405: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //   408: aload_0         /* this */
                //   409: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //   412: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   415: ifeq            464
                //   418: iconst_m1      
                //   419: aload_0         /* this */
                //   420: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
                //   423: aload_1         /* s */
                //   424: ldc             Ljava/lang/CharSequence;.class
                //   426: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   429: dup            
                //   430: astore          5
                //   432: checkcast       Ljava/lang/CharSequence;
                //   435: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   438: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //   441: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   444: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   447: dup            
                //   448: astore          5
                //   450: checkcast       Ljava/lang/Number;
                //   453: invokevirtual   java/lang/Number.intValue:()I
                //   456: bipush          48
                //   458: invokestatic    kawa/lib/strings.makeString:(II)Lgnu/lists/FString;
                //   461: goto            466
                //   464: ldc             ""
                //   466: aastore        
                //   467: dup            
                //   468: iconst_1       
                //   469: aload_1         /* s */
                //   470: aastore        
                //   471: invokevirtual   gnu/kawa/slib/printf$frame0.lambda3pad$V:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
                //   474: areturn        
                //   475: new             Lgnu/mapping/WrongType;
                //   478: dup_x1         
                //   479: swap           
                //   480: ldc             "negative?"
                //   482: iconst_1       
                //   483: aload           4
                //   485: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   488: athrow         
                //   489: new             Lgnu/mapping/WrongType;
                //   492: dup_x1         
                //   493: swap           
                //   494: ldc             "zero?"
                //   496: iconst_1       
                //   497: aload           4
                //   499: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   502: athrow         
                //   503: new             Lgnu/mapping/WrongType;
                //   506: dup_x1         
                //   507: swap           
                //   508: ldc             "symbol->string"
                //   510: iconst_1       
                //   511: aload           4
                //   513: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   516: athrow         
                //   517: new             Lgnu/mapping/WrongType;
                //   520: dup_x1         
                //   521: swap           
                //   522: ldc_w           "number->string"
                //   525: iconst_1       
                //   526: aload           4
                //   528: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   531: athrow         
                //   532: new             Lgnu/mapping/WrongType;
                //   535: dup_x1         
                //   536: swap           
                //   537: ldc_w           "number->string"
                //   540: iconst_2       
                //   541: aload           4
                //   543: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   546: athrow         
                //   547: new             Lgnu/mapping/WrongType;
                //   550: dup_x1         
                //   551: swap           
                //   552: ldc_w           "string-ref"
                //   555: iconst_1       
                //   556: aload           5
                //   558: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   561: athrow         
                //   562: new             Lgnu/mapping/WrongType;
                //   565: dup_x1         
                //   566: swap           
                //   567: ldc             "substring"
                //   569: iconst_1       
                //   570: aload           5
                //   572: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   575: athrow         
                //   576: new             Lgnu/mapping/WrongType;
                //   579: dup_x1         
                //   580: swap           
                //   581: ldc             "string-length"
                //   583: iconst_1       
                //   584: aload           5
                //   586: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   589: athrow         
                //   590: new             Lgnu/mapping/WrongType;
                //   593: dup_x1         
                //   594: swap           
                //   595: ldc             "string-length"
                //   597: iconst_1       
                //   598: aload           5
                //   600: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   603: athrow         
                //   604: new             Lgnu/mapping/WrongType;
                //   607: dup_x1         
                //   608: swap           
                //   609: ldc             "string-length"
                //   611: iconst_1       
                //   612: aload           5
                //   614: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   617: athrow         
                //   618: new             Lgnu/mapping/WrongType;
                //   621: dup_x1         
                //   622: swap           
                //   623: ldc             "make-string"
                //   625: iconst_1       
                //   626: aload           5
                //   628: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   631: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  12     15     475    489    Ljava/lang/ClassCastException;
                //  38     41     489    503    Ljava/lang/ClassCastException;
                //  79     82     503    517    Ljava/lang/ClassCastException;
                //  104    107    517    532    Ljava/lang/ClassCastException;
                //  111    114    532    547    Ljava/lang/ClassCastException;
                //  223    226    547    562    Ljava/lang/ClassCastException;
                //  248    251    562    576    Ljava/lang/ClassCastException;
                //  261    264    576    590    Ljava/lang/ClassCastException;
                //  399    402    590    604    Ljava/lang/ClassCastException;
                //  432    435    604    618    Ljava/lang/ClassCastException;
                //  450    456    618    632    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 290 out of bounds for length 290
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
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
            
            Object lambda7(final Object s) {
                final int plusOrMinus = 1;
                final Object pr = this.pr;
                final Object force = Promise.force(s, CharSequence.class);
                try {
                    this.pr = AddOp.apply2(plusOrMinus, pr, strings.stringLength((CharSequence)force));
                    return Scheme.applyToArgs.apply2(this.staticLink.out, s);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "string-length", 1, force);
                }
            }
            
            boolean lambda8(final Object s) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     2: getfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
                //     5: aload_1         /* s */
                //     6: ldc             Ljava/lang/CharSequence;.class
                //     8: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    11: dup            
                //    12: astore_3       
                //    13: checkcast       Ljava/lang/CharSequence;
                //    16: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //    19: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //    22: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    25: astore_2        /* sl */
                //    26: aload_0         /* this */
                //    27: aload_2         /* sl */
                //    28: ldc             Lgnu/math/RealNum;.class
                //    30: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    33: dup            
                //    34: astore_3       
                //    35: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
                //    38: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
                //    41: ifeq            94
                //    44: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    47: aload_0         /* this */
                //    48: getfield        gnu/kawa/slib/printf$frame0.staticLink:Lgnu/kawa/slib/printf$frame;
                //    51: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
                //    54: aload_1         /* s */
                //    55: ldc             Ljava/lang/CharSequence;.class
                //    57: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    60: dup            
                //    61: astore_3       
                //    62: checkcast       Ljava/lang/CharSequence;
                //    65: iconst_0       
                //    66: aload_0         /* this */
                //    67: getfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
                //    70: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //    73: dup            
                //    74: astore_3       
                //    75: checkcast       Ljava/lang/Number;
                //    78: invokevirtual   java/lang/Number.intValue:()I
                //    81: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //    84: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    87: pop            
                //    88: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
                //    91: goto            110
                //    94: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    97: aload_0         /* this */
                //    98: getfield        gnu/kawa/slib/printf$frame0.staticLink:Lgnu/kawa/slib/printf$frame;
                //   101: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
                //   104: aload_1         /* s */
                //   105: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   108: pop            
                //   109: aload_2         /* sl */
                //   110: putfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
                //   113: aload_2         /* sl */
                //   114: ldc             Lgnu/math/RealNum;.class
                //   116: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   119: dup            
                //   120: astore_3       
                //   121: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
                //   124: invokestatic    kawa/lib/numbers.isPositive:(Lgnu/math/RealNum;)Z
                //   127: ireturn        
                //   128: new             Lgnu/mapping/WrongType;
                //   131: dup_x1         
                //   132: swap           
                //   133: ldc             "string-length"
                //   135: iconst_1       
                //   136: aload_3        
                //   137: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   140: athrow         
                //   141: new             Lgnu/mapping/WrongType;
                //   144: dup_x1         
                //   145: swap           
                //   146: ldc             "negative?"
                //   148: iconst_1       
                //   149: aload_3        
                //   150: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   153: athrow         
                //   154: new             Lgnu/mapping/WrongType;
                //   157: dup_x1         
                //   158: swap           
                //   159: ldc             "substring"
                //   161: iconst_1       
                //   162: aload_3        
                //   163: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   166: athrow         
                //   167: new             Lgnu/mapping/WrongType;
                //   170: dup_x1         
                //   171: swap           
                //   172: ldc             "substring"
                //   174: iconst_3       
                //   175: aload_3        
                //   176: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   179: athrow         
                //   180: new             Lgnu/mapping/WrongType;
                //   183: dup_x1         
                //   184: swap           
                //   185: ldc             "positive?"
                //   187: iconst_1       
                //   188: aload_3        
                //   189: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   192: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  13     16     128    141    Ljava/lang/ClassCastException;
                //  35     38     141    154    Ljava/lang/ClassCastException;
                //  62     65     154    167    Ljava/lang/ClassCastException;
                //  75     81     167    180    Ljava/lang/ClassCastException;
                //  121    124    180    193    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 102 out of bounds for length 102
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
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
            
            boolean lambda9(final Object s) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     2: aload_0         /* this */
                //     3: getfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
                //     6: aload_1         /* s */
                //     7: ldc             Ljava/lang/CharSequence;.class
                //     9: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    12: dup            
                //    13: astore_2       
                //    14: checkcast       Ljava/lang/CharSequence;
                //    17: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //    20: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //    23: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    26: putfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
                //    29: aload_0         /* this */
                //    30: getfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
                //    33: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    36: ifne            57
                //    39: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    42: aload_0         /* this */
                //    43: getfield        gnu/kawa/slib/printf$frame0.staticLink:Lgnu/kawa/slib/printf$frame;
                //    46: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
                //    49: aload_1         /* s */
                //    50: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    53: pop            
                //    54: goto            142
                //    57: aload_0         /* this */
                //    58: getfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
                //    61: ldc             Lgnu/math/RealNum;.class
                //    63: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    66: dup            
                //    67: astore_2       
                //    68: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
                //    71: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
                //    74: ifeq            120
                //    77: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    80: aload_0         /* this */
                //    81: getfield        gnu/kawa/slib/printf$frame0.staticLink:Lgnu/kawa/slib/printf$frame;
                //    84: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
                //    87: aload_0         /* this */
                //    88: getfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
                //    91: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    94: pop            
                //    95: aload_0         /* this */
                //    96: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //    99: putfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
                //   102: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   105: aload_0         /* this */
                //   106: getfield        gnu/kawa/slib/printf$frame0.staticLink:Lgnu/kawa/slib/printf$frame;
                //   109: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
                //   112: aload_1         /* s */
                //   113: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   116: pop            
                //   117: goto            142
                //   120: aload_0         /* this */
                //   121: iconst_2       
                //   122: anewarray       Ljava/lang/Object;
                //   125: dup            
                //   126: iconst_0       
                //   127: aload_0         /* this */
                //   128: getfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
                //   131: aastore        
                //   132: dup            
                //   133: iconst_1       
                //   134: aload_1         /* s */
                //   135: aastore        
                //   136: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
                //   139: putfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
                //   142: iconst_1       
                //   143: ireturn        
                //   144: new             Lgnu/mapping/WrongType;
                //   147: dup_x1         
                //   148: swap           
                //   149: ldc             "string-length"
                //   151: iconst_1       
                //   152: aload_2        
                //   153: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   156: athrow         
                //   157: new             Lgnu/mapping/WrongType;
                //   160: dup_x1         
                //   161: swap           
                //   162: ldc             "negative?"
                //   164: iconst_1       
                //   165: aload_2        
                //   166: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   169: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  14     17     144    157    Ljava/lang/ClassCastException;
                //  68     71     157    170    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0120:
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
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
            
            boolean lambda10(final Object s) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     2: getfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
                //     5: aload_1         /* s */
                //     6: ldc             Ljava/lang/CharSequence;.class
                //     8: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    11: dup            
                //    12: astore_3       
                //    13: checkcast       Ljava/lang/CharSequence;
                //    16: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //    19: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //    22: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    25: astore_2        /* sl */
                //    26: aload_2         /* sl */
                //    27: ldc             Lgnu/math/RealNum;.class
                //    29: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    32: dup            
                //    33: astore_3       
                //    34: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
                //    37: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
                //    40: ifeq            97
                //    43: aload_0         /* this */
                //    44: iconst_2       
                //    45: anewarray       Ljava/lang/Object;
                //    48: dup            
                //    49: iconst_0       
                //    50: aload_0         /* this */
                //    51: getfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
                //    54: aastore        
                //    55: dup            
                //    56: iconst_1       
                //    57: aload_1         /* s */
                //    58: ldc             Ljava/lang/CharSequence;.class
                //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    63: dup            
                //    64: astore_3       
                //    65: checkcast       Ljava/lang/CharSequence;
                //    68: iconst_0       
                //    69: aload_0         /* this */
                //    70: getfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
                //    73: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //    76: dup            
                //    77: astore_3       
                //    78: checkcast       Ljava/lang/Number;
                //    81: invokevirtual   java/lang/Number.intValue:()I
                //    84: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //    87: aastore        
                //    88: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
                //    91: putfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
                //    94: goto            119
                //    97: aload_0         /* this */
                //    98: iconst_2       
                //    99: anewarray       Ljava/lang/Object;
                //   102: dup            
                //   103: iconst_0       
                //   104: aload_0         /* this */
                //   105: getfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
                //   108: aastore        
                //   109: dup            
                //   110: iconst_1       
                //   111: aload_1         /* s */
                //   112: aastore        
                //   113: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
                //   116: putfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
                //   119: aload_0         /* this */
                //   120: aload_2         /* sl */
                //   121: putfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
                //   124: aload_2         /* sl */
                //   125: ldc             Lgnu/math/RealNum;.class
                //   127: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   130: dup            
                //   131: astore_3       
                //   132: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
                //   135: invokestatic    kawa/lib/numbers.isPositive:(Lgnu/math/RealNum;)Z
                //   138: ireturn        
                //   139: new             Lgnu/mapping/WrongType;
                //   142: dup_x1         
                //   143: swap           
                //   144: ldc             "string-length"
                //   146: iconst_1       
                //   147: aload_3        
                //   148: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   151: athrow         
                //   152: new             Lgnu/mapping/WrongType;
                //   155: dup_x1         
                //   156: swap           
                //   157: ldc             "negative?"
                //   159: iconst_1       
                //   160: aload_3        
                //   161: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   164: athrow         
                //   165: new             Lgnu/mapping/WrongType;
                //   168: dup_x1         
                //   169: swap           
                //   170: ldc             "substring"
                //   172: iconst_1       
                //   173: aload_3        
                //   174: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   177: athrow         
                //   178: new             Lgnu/mapping/WrongType;
                //   181: dup_x1         
                //   182: swap           
                //   183: ldc             "substring"
                //   185: iconst_3       
                //   186: aload_3        
                //   187: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   190: athrow         
                //   191: new             Lgnu/mapping/WrongType;
                //   194: dup_x1         
                //   195: swap           
                //   196: ldc             "positive?"
                //   198: iconst_1       
                //   199: aload_3        
                //   200: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   203: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  13     16     139    152    Ljava/lang/ClassCastException;
                //  34     37     152    165    Ljava/lang/ClassCastException;
                //  65     68     165    178    Ljava/lang/ClassCastException;
                //  78     84     178    191    Ljava/lang/ClassCastException;
                //  132    135    191    204    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 115 out of bounds for length 115
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
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
            public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
                switch (proc.selector) {
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
                    default: {
                        return super.match1(proc, arg1, ctx);
                    }
                }
            }
            
            @Override
            public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
                if (moduleMethod.selector == 3) {
                    ctx.values = array;
                    ctx.proc = moduleMethod;
                    ctx.pc = 5;
                    return 0;
                }
                return super.matchN(moduleMethod, array, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object arg1) {
                switch (method.selector) {
                    case 4: {
                        return this.lambda7(arg1);
                    }
                    case 5: {
                        return this.lambda8(arg1) ? Boolean.TRUE : Boolean.FALSE;
                    }
                    case 6: {
                        return this.lambda9(arg1) ? Boolean.TRUE : Boolean.FALSE;
                    }
                    case 7: {
                        return this.lambda10(arg1) ? Boolean.TRUE : Boolean.FALSE;
                    }
                    default: {
                        return super.apply1(method, arg1);
                    }
                }
            }
            
            @Override
            public Object applyN(final ModuleMethod method, final Object[] args) {
                if (method.selector == 3) {
                    final Object pre = args[0];
                    int n = args.length - 1;
                    final Object[] argsArray = new Object[n];
                    while (--n >= 0) {
                        argsArray[n] = args[n + 1];
                    }
                    return this.lambda3pad$V(pre, argsArray);
                }
                return super.applyN(method, args);
            }
        }
        public class printf$frame extends ModuleBody
        {
            Object out;
            Object format$Mnstring;
            Object fc;
            IntNum pos;
            
            public boolean lambda1isEndOfFormat(final Object fl) {
                final IntNum pos = this.pos;
                final Object force = Promise.force(fl);
                try {
                    return IntNum.compare(pos, ((Number)force).longValue()) >= 0;
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "gnu.math.IntNum.compare(integer,long)", 2, force);
                }
            }
            
            public void lambda2mustAdvance(final Object fl) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: aload_0         /* this */
                //     2: getfield        gnu/kawa/slib/printf$frame.pos:Lgnu/math/IntNum;
                //     5: iconst_1       
                //     6: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
                //     9: putfield        gnu/kawa/slib/printf$frame.pos:Lgnu/math/IntNum;
                //    12: aload_0         /* this */
                //    13: getfield        gnu/kawa/slib/printf$frame.pos:Lgnu/math/IntNum;
                //    16: aload_1         /* fl */
                //    17: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //    20: dup            
                //    21: astore_2       
                //    22: checkcast       Ljava/lang/Number;
                //    25: invokevirtual   java/lang/Number.longValue:()J
                //    28: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
                //    31: iflt            42
                //    34: aload_0         /* this */
                //    35: invokevirtual   gnu/kawa/slib/printf$frame.lambda14incomplete:()Lgnu/bytecode/Type$NeverReturns;
                //    38: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
                //    41: athrow         
                //    42: aload_0         /* this */
                //    43: aload_0         /* this */
                //    44: getfield        gnu/kawa/slib/printf$frame.format$Mnstring:Ljava/lang/Object;
                //    47: ldc             Ljava/lang/CharSequence;.class
                //    49: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    52: dup            
                //    53: astore_2       
                //    54: checkcast       Ljava/lang/CharSequence;
                //    57: aload_0         /* this */
                //    58: getfield        gnu/kawa/slib/printf$frame.pos:Lgnu/math/IntNum;
                //    61: dup            
                //    62: astore_2       
                //    63: invokevirtual   java/lang/Number.intValue:()I
                //    66: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //    69: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //    72: putfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
                //    75: return         
                //    76: new             Lgnu/mapping/WrongType;
                //    79: dup_x1         
                //    80: swap           
                //    81: ldc             "gnu.math.IntNum.compare(integer,long)"
                //    83: iconst_2       
                //    84: aload_2        
                //    85: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //    88: athrow         
                //    89: new             Lgnu/mapping/WrongType;
                //    92: dup_x1         
                //    93: swap           
                //    94: ldc             "string-ref"
                //    96: iconst_1       
                //    97: aload_2        
                //    98: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   101: athrow         
                //   102: new             Lgnu/mapping/WrongType;
                //   105: dup_x1         
                //   106: swap           
                //   107: ldc             "string-ref"
                //   109: iconst_2       
                //   110: aload_2        
                //   111: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   114: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  22     28     76     89     Ljava/lang/ClassCastException;
                //  54     57     89     102    Ljava/lang/ClassCastException;
                //  63     66     102    115    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 61 out of bounds for length 61
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
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
            
            public Object lambda5out$St(final Object strs) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: invokestatic    kawa/lib/strings.isString:(Ljava/lang/Object;)Z
                //     4: ifeq            21
                //     7: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    10: aload_0         /* this */
                //    11: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
                //    14: aload_1         /* strs */
                //    15: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    18: goto            100
                //    21: aload_1         /* strs */
                //    22: astore_2        /* strs */
                //    23: aload_2         /* strs */
                //    24: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //    27: istore_3        /* x */
                //    28: iload_3         /* x */
                //    29: ifeq            48
                //    32: iload_3         /* x */
                //    33: ifeq            42
                //    36: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                //    39: goto            100
                //    42: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //    45: goto            100
                //    48: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    51: aload_0         /* this */
                //    52: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
                //    55: aload_2         /* strs */
                //    56: ldc             Lgnu/lists/Pair;.class
                //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    61: dup            
                //    62: astore          4
                //    64: checkcast       Lgnu/lists/Pair;
                //    67: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    70: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    73: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    76: ifeq            97
                //    79: aload_2         /* strs */
                //    80: ldc             Lgnu/lists/Pair;.class
                //    82: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    85: dup            
                //    86: astore          4
                //    88: checkcast       Lgnu/lists/Pair;
                //    91: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    94: goto            22
                //    97: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   100: areturn        
                //   101: new             Lgnu/mapping/WrongType;
                //   104: dup_x1         
                //   105: swap           
                //   106: ldc             "car"
                //   108: iconst_1       
                //   109: aload           4
                //   111: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   114: athrow         
                //   115: new             Lgnu/mapping/WrongType;
                //   118: dup_x1         
                //   119: swap           
                //   120: ldc             "cdr"
                //   122: iconst_1       
                //   123: aload           4
                //   125: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   128: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  64     67     101    115    Ljava/lang/ClassCastException;
                //  88     91     115    129    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0097:
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
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
            
            public Type.NeverReturns lambda14incomplete() {
                exceptions.error(gnu.kawa.slib.printf.Lit24, "conversion specification incomplete", this.format$Mnstring);
                throw Special.reachedUnexpected;
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/slib/printf$frame.<init>:()V
        //     7: astore          $heapFrame
        //     9: aload           $heapFrame
        //    11: aload_0         /* out */
        //    12: putfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //    15: aload           $heapFrame
        //    17: aload_1         /* formatString */
        //    18: putfield        gnu/kawa/slib/printf$frame.format$Mnstring:Ljava/lang/Object;
        //    21: aload_2         /* argsArray */
        //    22: iconst_0       
        //    23: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //    26: dup            
        //    27: astore          5
        //    29: astore_3        /* args */
        //    30: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    33: ldc             ""
        //    35: aload           $heapFrame
        //    37: getfield        gnu/kawa/slib/printf$frame.format$Mnstring:Ljava/lang/Object;
        //    40: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    43: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    46: ifne            3645
        //    49: getstatic       gnu/kawa/slib/printf.Lit1:Lgnu/math/IntNum;
        //    52: aload           $heapFrame
        //    54: swap           
        //    55: putfield        gnu/kawa/slib/printf$frame.pos:Lgnu/math/IntNum;
        //    58: aload           $heapFrame
        //    60: getfield        gnu/kawa/slib/printf$frame.format$Mnstring:Ljava/lang/Object;
        //    63: ldc             Ljava/lang/CharSequence;.class
        //    65: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    68: dup            
        //    69: astore          6
        //    71: checkcast       Ljava/lang/CharSequence;
        //    74: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //    77: istore          5
        //    79: aload           $heapFrame
        //    81: getfield        gnu/kawa/slib/printf$frame.format$Mnstring:Ljava/lang/Object;
        //    84: ldc             Ljava/lang/CharSequence;.class
        //    86: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    89: dup            
        //    90: astore          6
        //    92: checkcast       Ljava/lang/CharSequence;
        //    95: iconst_0       
        //    96: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //    99: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   102: aload           $heapFrame
        //   104: swap           
        //   105: putfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //   108: aload_3         /* args */
        //   109: astore          args
        //   111: new             Lgnu/kawa/slib/printf$frame0;
        //   114: dup            
        //   115: invokespecial   gnu/kawa/slib/printf$frame0.<init>:()V
        //   118: dup            
        //   119: aload           $heapFrame
        //   121: putfield        gnu/kawa/slib/printf$frame0.staticLink:Lgnu/kawa/slib/printf$frame;
        //   124: astore          $heapFrame
        //   126: aload           $heapFrame
        //   128: aload           args
        //   130: putfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //   133: aload           $heapFrame
        //   135: aload           $heapFrame
        //   137: getfield        gnu/kawa/slib/printf$frame.pos:Lgnu/math/IntNum;
        //   140: iconst_1       
        //   141: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //   144: putfield        gnu/kawa/slib/printf$frame.pos:Lgnu/math/IntNum;
        //   147: aload           $heapFrame
        //   149: getfield        gnu/kawa/slib/printf$frame.pos:Lgnu/math/IntNum;
        //   152: iload           fl
        //   154: i2l            
        //   155: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
        //   158: iflt            172
        //   161: aload           $heapFrame
        //   163: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   166: putfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //   169: goto            210
        //   172: aload           $heapFrame
        //   174: aload           $heapFrame
        //   176: getfield        gnu/kawa/slib/printf$frame.format$Mnstring:Ljava/lang/Object;
        //   179: ldc             Ljava/lang/CharSequence;.class
        //   181: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   184: dup            
        //   185: astore          8
        //   187: checkcast       Ljava/lang/CharSequence;
        //   190: aload           $heapFrame
        //   192: getfield        gnu/kawa/slib/printf$frame.pos:Lgnu/math/IntNum;
        //   195: dup            
        //   196: astore          8
        //   198: invokevirtual   java/lang/Number.intValue:()I
        //   201: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   204: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   207: putfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //   210: aload           $heapFrame
        //   212: iload           fl
        //   214: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   217: invokevirtual   gnu/kawa/slib/printf$frame.lambda1isEndOfFormat:(Ljava/lang/Object;)Z
        //   220: istore          x
        //   222: iload           x
        //   224: ifeq            244
        //   227: iload           x
        //   229: ifeq            238
        //   232: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   235: goto            3648
        //   238: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   241: goto            3648
        //   244: getstatic       gnu/kawa/slib/printf.Lit2:Lgnu/text/Char;
        //   247: aload           $heapFrame
        //   249: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //   252: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   255: ifeq            549
        //   258: aload           $heapFrame
        //   260: iload           fl
        //   262: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   265: invokevirtual   gnu/kawa/slib/printf$frame.lambda2mustAdvance:(Ljava/lang/Object;)V
        //   268: aload           $heapFrame
        //   270: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //   273: astore          tmp
        //   275: aload           tmp
        //   277: invokevirtual   java/lang/Object.hashCode:()I
        //   280: lookupswitch {
        //               10: 458
        //               70: 376
        //               78: 476
        //               84: 362
        //              102: 348
        //              110: 444
        //              116: 410
        //          default: 510
        //        }
        //   348: aload           tmp
        //   350: getstatic       gnu/kawa/slib/printf.Lit3:Lgnu/text/Char;
        //   353: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   356: ifeq            510
        //   359: goto            387
        //   362: aload           tmp
        //   364: getstatic       gnu/kawa/slib/printf.Lit4:Lgnu/text/Char;
        //   367: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   370: ifeq            510
        //   373: goto            421
        //   376: aload           tmp
        //   378: getstatic       gnu/kawa/slib/printf.Lit5:Lgnu/text/Char;
        //   381: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   384: ifeq            510
        //   387: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   390: aload           $heapFrame
        //   392: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //   395: getstatic       gnu/kawa/slib/printf.Lit6:Lgnu/text/Char;
        //   398: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   401: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   404: ifeq            543
        //   407: goto            535
        //   410: aload           tmp
        //   412: getstatic       gnu/kawa/slib/printf.Lit7:Lgnu/text/Char;
        //   415: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   418: ifeq            510
        //   421: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   424: aload           $heapFrame
        //   426: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //   429: getstatic       gnu/kawa/slib/printf.Lit8:Lgnu/text/Char;
        //   432: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   435: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   438: ifeq            543
        //   441: goto            535
        //   444: aload           tmp
        //   446: getstatic       gnu/kawa/slib/printf.Lit9:Lgnu/text/Char;
        //   449: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   452: ifeq            510
        //   455: goto            487
        //   458: aload           tmp
        //   460: getstatic       gnu/kawa/slib/printf.Lit10:Lgnu/text/Char;
        //   463: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   466: ifeq            510
        //   469: iconst_1       
        //   470: ifeq            543
        //   473: goto            535
        //   476: aload           tmp
        //   478: getstatic       gnu/kawa/slib/printf.Lit11:Lgnu/text/Char;
        //   481: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   484: ifeq            510
        //   487: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   490: aload           $heapFrame
        //   492: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //   495: getstatic       gnu/kawa/slib/printf.Lit10:Lgnu/text/Char;
        //   498: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   501: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   504: ifeq            543
        //   507: goto            535
        //   510: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   513: aload           $heapFrame
        //   515: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //   518: aload           $heapFrame
        //   520: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //   523: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   526: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   529: ifeq            543
        //   532: goto            535
        //   535: aload           $heapFrame
        //   537: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //   540: goto            109
        //   543: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   546: goto            3648
        //   549: getstatic       gnu/kawa/slib/printf.Lit12:Lgnu/text/Char;
        //   552: aload           $heapFrame
        //   554: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //   557: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   560: ifeq            3609
        //   563: aload           $heapFrame
        //   565: iload           fl
        //   567: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   570: invokevirtual   gnu/kawa/slib/printf$frame.lambda2mustAdvance:(Ljava/lang/Object;)V
        //   573: iconst_0       
        //   574: aload           $heapFrame
        //   576: swap           
        //   577: putfield        gnu/kawa/slib/printf$frame0.left$Mnadjust:Z
        //   580: iconst_0       
        //   581: aload           $heapFrame
        //   583: swap           
        //   584: putfield        gnu/kawa/slib/printf$frame0.signed:Z
        //   587: iconst_0       
        //   588: aload           $heapFrame
        //   590: swap           
        //   591: putfield        gnu/kawa/slib/printf$frame0.blank:Z
        //   594: iconst_0       
        //   595: aload           $heapFrame
        //   597: swap           
        //   598: putfield        gnu/kawa/slib/printf$frame0.alternate$Mnform:Z
        //   601: iconst_0       
        //   602: aload           $heapFrame
        //   604: swap           
        //   605: putfield        gnu/kawa/slib/printf$frame0.leading$Mn0s:Z
        //   608: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
        //   611: aload           $heapFrame
        //   613: swap           
        //   614: putfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //   617: getstatic       gnu/kawa/slib/printf.Lit1:Lgnu/math/IntNum;
        //   620: aload           $heapFrame
        //   622: swap           
        //   623: putfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
        //   626: aload           $heapFrame
        //   628: getfield        gnu/kawa/slib/printf$frame0.pad:Lgnu/mapping/Procedure;
        //   631: aload           $heapFrame
        //   633: swap           
        //   634: putfield        gnu/kawa/slib/printf$frame0.pad:Lgnu/mapping/Procedure;
        //   637: aload           $heapFrame
        //   639: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //   642: astore          tmp
        //   644: aload           tmp
        //   646: invokevirtual   java/lang/Object.hashCode:()I
        //   649: lookupswitch {
        //               32: 724
        //               35: 700
        //               43: 772
        //               45: 796
        //               48: 748
        //          default: 820
        //        }
        //   700: aload           tmp
        //   702: getstatic       gnu/kawa/slib/printf.Lit14:Lgnu/text/Char;
        //   705: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   708: ifeq            820
        //   711: aload           $heapFrame
        //   713: iconst_1       
        //   714: putfield        gnu/kawa/slib/printf$frame0.alternate$Mnform:Z
        //   717: iconst_0       
        //   718: ifne            840
        //   721: goto            827
        //   724: aload           tmp
        //   726: getstatic       gnu/kawa/slib/printf.Lit15:Lgnu/text/Char;
        //   729: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   732: ifeq            820
        //   735: aload           $heapFrame
        //   737: iconst_1       
        //   738: putfield        gnu/kawa/slib/printf$frame0.blank:Z
        //   741: iconst_0       
        //   742: ifne            840
        //   745: goto            827
        //   748: aload           tmp
        //   750: getstatic       gnu/kawa/slib/printf.Lit16:Lgnu/text/Char;
        //   753: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   756: ifeq            820
        //   759: aload           $heapFrame
        //   761: iconst_1       
        //   762: putfield        gnu/kawa/slib/printf$frame0.leading$Mn0s:Z
        //   765: iconst_0       
        //   766: ifne            840
        //   769: goto            827
        //   772: aload           tmp
        //   774: getstatic       gnu/kawa/slib/printf.Lit17:Lgnu/text/Char;
        //   777: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   780: ifeq            820
        //   783: aload           $heapFrame
        //   785: iconst_1       
        //   786: putfield        gnu/kawa/slib/printf$frame0.signed:Z
        //   789: iconst_0       
        //   790: ifne            840
        //   793: goto            827
        //   796: aload           tmp
        //   798: getstatic       gnu/kawa/slib/printf.Lit18:Lgnu/text/Char;
        //   801: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   804: ifeq            820
        //   807: aload           $heapFrame
        //   809: iconst_1       
        //   810: putfield        gnu/kawa/slib/printf$frame0.left$Mnadjust:Z
        //   813: iconst_0       
        //   814: ifne            840
        //   817: goto            827
        //   820: iconst_1       
        //   821: ifne            840
        //   824: goto            827
        //   827: aload           $heapFrame
        //   829: iload           fl
        //   831: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   834: invokevirtual   gnu/kawa/slib/printf$frame.lambda2mustAdvance:(Ljava/lang/Object;)V
        //   837: goto            637
        //   840: aload           $heapFrame
        //   842: getfield        gnu/kawa/slib/printf$frame0.left$Mnadjust:Z
        //   845: ifeq            854
        //   848: aload           $heapFrame
        //   850: iconst_0       
        //   851: putfield        gnu/kawa/slib/printf$frame0.leading$Mn0s:Z
        //   854: aload           $heapFrame
        //   856: getfield        gnu/kawa/slib/printf$frame0.signed:Z
        //   859: ifeq            868
        //   862: aload           $heapFrame
        //   864: iconst_0       
        //   865: putfield        gnu/kawa/slib/printf$frame0.blank:Z
        //   868: aload           $heapFrame
        //   870: aload           $heapFrame
        //   872: iload           fl
        //   874: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   877: invokevirtual   gnu/kawa/slib/printf$frame0.lambda4readFormatNumber:(Ljava/lang/Object;)Ljava/lang/Object;
        //   880: putfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //   883: aload           $heapFrame
        //   885: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //   888: ldc_w           Lgnu/math/RealNum;.class
        //   891: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   894: dup            
        //   895: astore          9
        //   897: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //   900: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
        //   903: ifeq            928
        //   906: aload           $heapFrame
        //   908: iconst_1       
        //   909: putfield        gnu/kawa/slib/printf$frame0.left$Mnadjust:Z
        //   912: aload           $heapFrame
        //   914: getstatic       gnu/kawa/functions/AddOp.$Mn:Lgnu/kawa/functions/AddOp;
        //   917: aload           $heapFrame
        //   919: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //   922: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   925: putfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //   928: getstatic       gnu/kawa/slib/printf.Lit19:Lgnu/text/Char;
        //   931: aload           $heapFrame
        //   933: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //   936: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   939: ifeq            967
        //   942: aload           $heapFrame
        //   944: iload           fl
        //   946: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   949: invokevirtual   gnu/kawa/slib/printf$frame.lambda2mustAdvance:(Ljava/lang/Object;)V
        //   952: aload           $heapFrame
        //   954: aload           $heapFrame
        //   956: iload           fl
        //   958: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   961: invokevirtual   gnu/kawa/slib/printf$frame0.lambda4readFormatNumber:(Ljava/lang/Object;)Ljava/lang/Object;
        //   964: putfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
        //   967: aload           $heapFrame
        //   969: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //   972: astore          tmp
        //   974: aload           tmp
        //   976: invokevirtual   java/lang/Object.hashCode:()I
        //   979: lookupswitch {
        //               76: 1012
        //              104: 1040
        //              108: 1026
        //          default: 1064
        //        }
        //  1012: aload           tmp
        //  1014: getstatic       gnu/kawa/slib/printf.Lit20:Lgnu/text/Char;
        //  1017: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1020: ifeq            1064
        //  1023: goto            1051
        //  1026: aload           tmp
        //  1028: getstatic       gnu/kawa/slib/printf.Lit21:Lgnu/text/Char;
        //  1031: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1034: ifeq            1064
        //  1037: goto            1051
        //  1040: aload           tmp
        //  1042: getstatic       gnu/kawa/slib/printf.Lit22:Lgnu/text/Char;
        //  1045: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1048: ifeq            1064
        //  1051: aload           $heapFrame
        //  1053: iload           fl
        //  1055: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  1058: invokevirtual   gnu/kawa/slib/printf$frame.lambda2mustAdvance:(Ljava/lang/Object;)V
        //  1061: goto            1064
        //  1064: aload           $heapFrame
        //  1066: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  1069: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //  1072: ifeq            1148
        //  1075: aload           $heapFrame
        //  1077: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //  1080: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1083: dup            
        //  1084: astore          9
        //  1086: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  1089: invokestatic    kawa/lib/rnrs/unicode.charDowncase:(I)I
        //  1092: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //  1095: getstatic       gnu/kawa/slib/printf.Lit23:Lgnu/lists/PairWithPosition;
        //  1098: invokestatic    kawa/lib/lists.memv:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  1101: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  1104: ifeq            1148
        //  1107: iconst_4       
        //  1108: anewarray       Ljava/lang/Object;
        //  1111: dup            
        //  1112: iconst_0       
        //  1113: getstatic       gnu/kawa/slib/printf.Lit24:Lgnu/mapping/SimpleSymbol;
        //  1116: aastore        
        //  1117: dup            
        //  1118: iconst_1       
        //  1119: ldc_w           "wrong number of arguments"
        //  1122: aastore        
        //  1123: dup            
        //  1124: iconst_2       
        //  1125: aload_3         /* args */
        //  1126: invokevirtual   gnu/lists/LList.size:()I
        //  1129: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  1132: aastore        
        //  1133: dup            
        //  1134: iconst_3       
        //  1135: aload           $heapFrame
        //  1137: getfield        gnu/kawa/slib/printf$frame.format$Mnstring:Ljava/lang/Object;
        //  1140: aastore        
        //  1141: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //  1144: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //  1147: athrow         
        //  1148: aload           $heapFrame
        //  1150: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //  1153: astore          tmp
        //  1155: aload           tmp
        //  1157: invokevirtual   java/lang/Object.hashCode:()I
        //  1160: lookupswitch {
        //               37: 2438
        //               65: 1444
        //               66: 1458
        //               67: 1472
        //               68: 1388
        //               69: 1402
        //               70: 1416
        //               71: 1430
        //               73: 1500
        //               75: 1514
        //               79: 1486
        //               83: 1542
        //               85: 1528
        //               88: 1556
        //               97: 1890
        //               98: 1706
        //               99: 1788
        //              100: 1678
        //              101: 1692
        //              102: 1650
        //              103: 1664
        //              105: 2880
        //              107: 2565
        //              111: 2483
        //              115: 2976
        //              117: 2894
        //              120: 3405
        //          default: 3499
        //        }
        //  1388: aload           tmp
        //  1390: getstatic       gnu/kawa/slib/printf.Lit25:Lgnu/text/Char;
        //  1393: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1396: ifeq            3499
        //  1399: goto            2905
        //  1402: aload           tmp
        //  1404: getstatic       gnu/kawa/slib/printf.Lit26:Lgnu/text/Char;
        //  1407: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1410: ifeq            3499
        //  1413: goto            2576
        //  1416: aload           tmp
        //  1418: getstatic       gnu/kawa/slib/printf.Lit5:Lgnu/text/Char;
        //  1421: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1424: ifeq            3499
        //  1427: goto            2576
        //  1430: aload           tmp
        //  1432: getstatic       gnu/kawa/slib/printf.Lit27:Lgnu/text/Char;
        //  1435: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1438: ifeq            3499
        //  1441: goto            2576
        //  1444: aload           tmp
        //  1446: getstatic       gnu/kawa/slib/printf.Lit28:Lgnu/text/Char;
        //  1449: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1452: ifeq            3499
        //  1455: goto            1901
        //  1458: aload           tmp
        //  1460: getstatic       gnu/kawa/slib/printf.Lit29:Lgnu/text/Char;
        //  1463: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1466: ifeq            3499
        //  1469: goto            1717
        //  1472: aload           tmp
        //  1474: getstatic       gnu/kawa/slib/printf.Lit30:Lgnu/text/Char;
        //  1477: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1480: ifeq            3499
        //  1483: goto            1799
        //  1486: aload           tmp
        //  1488: getstatic       gnu/kawa/slib/printf.Lit31:Lgnu/text/Char;
        //  1491: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1494: ifeq            3499
        //  1497: goto            2494
        //  1500: aload           tmp
        //  1502: getstatic       gnu/kawa/slib/printf.Lit32:Lgnu/text/Char;
        //  1505: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1508: ifeq            3499
        //  1511: goto            2905
        //  1514: aload           tmp
        //  1516: getstatic       gnu/kawa/slib/printf.Lit33:Lgnu/text/Char;
        //  1519: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1522: ifeq            3499
        //  1525: goto            2576
        //  1528: aload           tmp
        //  1530: getstatic       gnu/kawa/slib/printf.Lit34:Lgnu/text/Char;
        //  1533: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1536: ifeq            3499
        //  1539: goto            2905
        //  1542: aload           tmp
        //  1544: getstatic       gnu/kawa/slib/printf.Lit35:Lgnu/text/Char;
        //  1547: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1550: ifeq            3499
        //  1553: goto            2987
        //  1556: aload           tmp
        //  1558: getstatic       gnu/kawa/slib/printf.Lit36:Lgnu/text/Char;
        //  1561: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1564: ifeq            3499
        //  1567: aload           $heapFrame
        //  1569: aload           $heapFrame
        //  1571: aload           $heapFrame
        //  1573: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  1576: ldc_w           Lgnu/lists/Pair;.class
        //  1579: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1582: dup            
        //  1583: astore          10
        //  1585: checkcast       Lgnu/lists/Pair;
        //  1588: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  1591: getstatic       gnu/kawa/slib/printf.Lit37:Lgnu/math/IntNum;
        //  1594: getstatic       gnu/kawa/slib/printf.stdio$Clhex$Mnupper$Mncase$Qu:Z
        //  1597: ifeq            1606
        //  1600: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1603: goto            1609
        //  1606: getstatic       kawa/lib/rnrs/unicode.string$Mnupcase:Lgnu/expr/ModuleMethod;
        //  1609: invokevirtual   gnu/kawa/slib/printf$frame0.lambda6integerConvert:(Ljava/lang/Object;Lgnu/math/IntNum;Ljava/lang/Object;)Ljava/lang/Object;
        //  1612: invokevirtual   gnu/kawa/slib/printf$frame.lambda5out$St:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1615: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  1618: ifeq            1644
        //  1621: aload           $heapFrame
        //  1623: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  1626: ldc_w           Lgnu/lists/Pair;.class
        //  1629: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1632: dup            
        //  1633: astore          10
        //  1635: checkcast       Lgnu/lists/Pair;
        //  1638: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  1641: goto            109
        //  1644: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1647: goto            3648
        //  1650: aload           tmp
        //  1652: getstatic       gnu/kawa/slib/printf.Lit3:Lgnu/text/Char;
        //  1655: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1658: ifeq            3499
        //  1661: goto            2576
        //  1664: aload           tmp
        //  1666: getstatic       gnu/kawa/slib/printf.Lit38:Lgnu/text/Char;
        //  1669: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1672: ifeq            3499
        //  1675: goto            2576
        //  1678: aload           tmp
        //  1680: getstatic       gnu/kawa/slib/printf.Lit39:Lgnu/text/Char;
        //  1683: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1686: ifeq            3499
        //  1689: goto            2905
        //  1692: aload           tmp
        //  1694: getstatic       gnu/kawa/slib/printf.Lit40:Lgnu/text/Char;
        //  1697: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1700: ifeq            3499
        //  1703: goto            2576
        //  1706: aload           tmp
        //  1708: getstatic       gnu/kawa/slib/printf.Lit41:Lgnu/text/Char;
        //  1711: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1714: ifeq            3499
        //  1717: aload           $heapFrame
        //  1719: aload           $heapFrame
        //  1721: aload           $heapFrame
        //  1723: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  1726: ldc_w           Lgnu/lists/Pair;.class
        //  1729: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1732: dup            
        //  1733: astore          10
        //  1735: checkcast       Lgnu/lists/Pair;
        //  1738: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  1741: getstatic       gnu/kawa/slib/printf.Lit42:Lgnu/math/IntNum;
        //  1744: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1747: invokevirtual   gnu/kawa/slib/printf$frame0.lambda6integerConvert:(Ljava/lang/Object;Lgnu/math/IntNum;Ljava/lang/Object;)Ljava/lang/Object;
        //  1750: invokevirtual   gnu/kawa/slib/printf$frame.lambda5out$St:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1753: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  1756: ifeq            1782
        //  1759: aload           $heapFrame
        //  1761: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  1764: ldc_w           Lgnu/lists/Pair;.class
        //  1767: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1770: dup            
        //  1771: astore          10
        //  1773: checkcast       Lgnu/lists/Pair;
        //  1776: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  1779: goto            109
        //  1782: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1785: goto            3648
        //  1788: aload           tmp
        //  1790: getstatic       gnu/kawa/slib/printf.Lit43:Lgnu/text/Char;
        //  1793: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1796: ifeq            3499
        //  1799: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //  1802: aload           $heapFrame
        //  1804: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //  1807: aload           $heapFrame
        //  1809: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  1812: ldc_w           Lgnu/lists/Pair;.class
        //  1815: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1818: dup            
        //  1819: astore          10
        //  1821: checkcast       Lgnu/lists/Pair;
        //  1824: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  1827: dup            
        //  1828: instanceof      [Ljava/lang/Object;
        //  1831: ifeq            1840
        //  1834: checkcast       [Ljava/lang/Object;
        //  1837: goto            1849
        //  1840: iconst_1       
        //  1841: anewarray       Ljava/lang/Object;
        //  1844: dup_x1         
        //  1845: swap           
        //  1846: iconst_0       
        //  1847: swap           
        //  1848: aastore        
        //  1849: invokestatic    kawa/lib/strings.$make$string$:([Ljava/lang/Object;)Ljava/lang/CharSequence;
        //  1852: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  1855: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  1858: ifeq            1884
        //  1861: aload           $heapFrame
        //  1863: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  1866: ldc_w           Lgnu/lists/Pair;.class
        //  1869: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1872: dup            
        //  1873: astore          10
        //  1875: checkcast       Lgnu/lists/Pair;
        //  1878: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  1881: goto            109
        //  1884: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1887: goto            3648
        //  1890: aload           tmp
        //  1892: getstatic       gnu/kawa/slib/printf.Lit44:Lgnu/text/Char;
        //  1895: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1898: ifeq            3499
        //  1901: ldc             ""
        //  1903: aload           $heapFrame
        //  1905: swap           
        //  1906: putfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
        //  1909: aload           $heapFrame
        //  1911: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
        //  1914: aload           $heapFrame
        //  1916: swap           
        //  1917: putfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
        //  1920: aload           $heapFrame
        //  1922: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  1925: ldc_w           Lgnu/lists/Pair;.class
        //  1928: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1931: dup            
        //  1932: astore          10
        //  1934: checkcast       Lgnu/lists/Pair;
        //  1937: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  1940: aload           $heapFrame
        //  1942: getfield        gnu/kawa/slib/printf$frame0.alternate$Mnform:Z
        //  1945: ifeq            1954
        //  1948: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1951: goto            1957
        //  1954: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //  1957: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  1960: aload           $heapFrame
        //  1962: getfield        gnu/kawa/slib/printf$frame0.left$Mnadjust:Z
        //  1965: ifeq            2007
        //  1968: aload           $heapFrame
        //  1970: getfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
        //  1973: ldc_w           Lgnu/math/RealNum;.class
        //  1976: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1979: dup            
        //  1980: astore          10
        //  1982: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //  1985: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
        //  1988: ifeq            2007
        //  1991: aload           $heapFrame
        //  1993: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
        //  1996: putfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
        //  1999: aload           $heapFrame
        //  2001: getfield        gnu/kawa/slib/printf$frame0.lambda$Fn1:Lgnu/expr/ModuleMethod;
        //  2004: goto            2069
        //  2007: aload           $heapFrame
        //  2009: getfield        gnu/kawa/slib/printf$frame0.left$Mnadjust:Z
        //  2012: ifeq            2023
        //  2015: aload           $heapFrame
        //  2017: getfield        gnu/kawa/slib/printf$frame0.lambda$Fn2:Lgnu/expr/ModuleMethod;
        //  2020: goto            2069
        //  2023: aload           $heapFrame
        //  2025: getfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
        //  2028: ldc_w           Lgnu/math/RealNum;.class
        //  2031: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2034: dup            
        //  2035: astore          10
        //  2037: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //  2040: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
        //  2043: ifeq            2064
        //  2046: aload           $heapFrame
        //  2048: aload           $heapFrame
        //  2050: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //  2053: putfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
        //  2056: aload           $heapFrame
        //  2058: getfield        gnu/kawa/slib/printf$frame0.lambda$Fn3:Lgnu/expr/ModuleMethod;
        //  2061: goto            2069
        //  2064: aload           $heapFrame
        //  2066: getfield        gnu/kawa/slib/printf$frame0.lambda$Fn4:Lgnu/expr/ModuleMethod;
        //  2069: invokestatic    gnu/kawa/slib/genwrite.genericWrite:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2072: pop            
        //  2073: aload           $heapFrame
        //  2075: getfield        gnu/kawa/slib/printf$frame0.left$Mnadjust:Z
        //  2078: ifeq            2166
        //  2081: aload           $heapFrame
        //  2083: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
        //  2086: ldc_w           Lgnu/math/RealNum;.class
        //  2089: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2092: dup            
        //  2093: astore          10
        //  2095: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //  2098: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
        //  2101: ifeq            2166
        //  2104: aload           $heapFrame
        //  2106: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //  2109: aload           $heapFrame
        //  2111: getfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
        //  2114: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2117: ifeq            2415
        //  2120: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //  2123: aload           $heapFrame
        //  2125: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //  2128: iconst_m1      
        //  2129: aload           $heapFrame
        //  2131: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //  2134: aload           $heapFrame
        //  2136: getfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
        //  2139: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2142: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  2145: dup            
        //  2146: astore          10
        //  2148: checkcast       Ljava/lang/Number;
        //  2151: invokevirtual   java/lang/Number.intValue:()I
        //  2154: bipush          32
        //  2156: invokestatic    kawa/lib/strings.makeString:(II)Lgnu/lists/FString;
        //  2159: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2162: pop            
        //  2163: goto            2415
        //  2166: aload           $heapFrame
        //  2168: getfield        gnu/kawa/slib/printf$frame0.left$Mnadjust:Z
        //  2171: ifeq            2254
        //  2174: aload           $heapFrame
        //  2176: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //  2179: iconst_m1      
        //  2180: aload           $heapFrame
        //  2182: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
        //  2185: aload           $heapFrame
        //  2187: getfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
        //  2190: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2193: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2196: ifeq            2415
        //  2199: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //  2202: aload           $heapFrame
        //  2204: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //  2207: iconst_m1      
        //  2208: aload           $heapFrame
        //  2210: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //  2213: iconst_m1      
        //  2214: aload           $heapFrame
        //  2216: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
        //  2219: aload           $heapFrame
        //  2221: getfield        gnu/kawa/slib/printf$frame0.pr:Ljava/lang/Object;
        //  2224: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2227: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2230: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  2233: dup            
        //  2234: astore          10
        //  2236: checkcast       Ljava/lang/Number;
        //  2239: invokevirtual   java/lang/Number.intValue:()I
        //  2242: bipush          32
        //  2244: invokestatic    kawa/lib/strings.makeString:(II)Lgnu/lists/FString;
        //  2247: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2250: pop            
        //  2251: goto            2415
        //  2254: aload           $heapFrame
        //  2256: getfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
        //  2259: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  2262: ifeq            2269
        //  2265: iconst_0       
        //  2266: goto            2270
        //  2269: iconst_1       
        //  2270: istore          x
        //  2272: iload           x
        //  2274: ifeq            2280
        //  2277: goto            2415
        //  2280: aload           $heapFrame
        //  2282: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //  2285: aload           $heapFrame
        //  2287: getfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
        //  2290: ldc             Ljava/lang/CharSequence;.class
        //  2292: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2295: dup            
        //  2296: astore          11
        //  2298: checkcast       Ljava/lang/CharSequence;
        //  2301: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //  2304: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  2307: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2310: ifeq            2333
        //  2313: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //  2316: aload           $heapFrame
        //  2318: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //  2321: aload           $heapFrame
        //  2323: getfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
        //  2326: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2329: pop            
        //  2330: goto            2415
        //  2333: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //  2336: aload           $heapFrame
        //  2338: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //  2341: iconst_m1      
        //  2342: aload           $heapFrame
        //  2344: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //  2347: aload           $heapFrame
        //  2349: getfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
        //  2352: ldc             Ljava/lang/CharSequence;.class
        //  2354: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2357: dup            
        //  2358: astore          11
        //  2360: checkcast       Ljava/lang/CharSequence;
        //  2363: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //  2366: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  2369: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2372: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  2375: dup            
        //  2376: astore          11
        //  2378: checkcast       Ljava/lang/Number;
        //  2381: invokevirtual   java/lang/Number.intValue:()I
        //  2384: bipush          32
        //  2386: invokestatic    kawa/lib/strings.makeString:(II)Lgnu/lists/FString;
        //  2389: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2392: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  2395: ifeq            2415
        //  2398: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //  2401: aload           $heapFrame
        //  2403: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //  2406: aload           $heapFrame
        //  2408: getfield        gnu/kawa/slib/printf$frame0.os:Ljava/lang/Object;
        //  2411: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2414: pop            
        //  2415: aload           $heapFrame
        //  2417: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  2420: ldc_w           Lgnu/lists/Pair;.class
        //  2423: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2426: dup            
        //  2427: astore          10
        //  2429: checkcast       Lgnu/lists/Pair;
        //  2432: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  2435: goto            109
        //  2438: aload           tmp
        //  2440: getstatic       gnu/kawa/slib/printf.Lit12:Lgnu/text/Char;
        //  2443: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2446: ifeq            3499
        //  2449: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //  2452: aload           $heapFrame
        //  2454: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //  2457: getstatic       gnu/kawa/slib/printf.Lit12:Lgnu/text/Char;
        //  2460: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2463: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  2466: ifeq            2477
        //  2469: aload           $heapFrame
        //  2471: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  2474: goto            109
        //  2477: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  2480: goto            3648
        //  2483: aload           tmp
        //  2485: getstatic       gnu/kawa/slib/printf.Lit45:Lgnu/text/Char;
        //  2488: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2491: ifeq            3499
        //  2494: aload           $heapFrame
        //  2496: aload           $heapFrame
        //  2498: aload           $heapFrame
        //  2500: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  2503: ldc_w           Lgnu/lists/Pair;.class
        //  2506: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2509: dup            
        //  2510: astore          10
        //  2512: checkcast       Lgnu/lists/Pair;
        //  2515: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  2518: getstatic       gnu/kawa/slib/printf.Lit46:Lgnu/math/IntNum;
        //  2521: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  2524: invokevirtual   gnu/kawa/slib/printf$frame0.lambda6integerConvert:(Ljava/lang/Object;Lgnu/math/IntNum;Ljava/lang/Object;)Ljava/lang/Object;
        //  2527: invokevirtual   gnu/kawa/slib/printf$frame.lambda5out$St:(Ljava/lang/Object;)Ljava/lang/Object;
        //  2530: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  2533: ifeq            2559
        //  2536: aload           $heapFrame
        //  2538: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  2541: ldc_w           Lgnu/lists/Pair;.class
        //  2544: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2547: dup            
        //  2548: astore          10
        //  2550: checkcast       Lgnu/lists/Pair;
        //  2553: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  2556: goto            109
        //  2559: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  2562: goto            3648
        //  2565: aload           tmp
        //  2567: getstatic       gnu/kawa/slib/printf.Lit47:Lgnu/text/Char;
        //  2570: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2573: ifeq            3499
        //  2576: aload           $heapFrame
        //  2578: aload           $heapFrame
        //  2580: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  2583: ldc_w           Lgnu/lists/Pair;.class
        //  2586: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2589: dup            
        //  2590: astore          10
        //  2592: checkcast       Lgnu/lists/Pair;
        //  2595: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  2598: aload           $heapFrame
        //  2600: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //  2603: astore          11
        //  2605: astore          num
        //  2607: new             Lgnu/kawa/slib/printf$frame1;
        //  2610: dup            
        //  2611: invokespecial   gnu/kawa/slib/printf$frame1.<init>:()V
        //  2614: dup            
        //  2615: aload           $heapFrame
        //  2617: putfield        gnu/kawa/slib/printf$frame1.staticLink:Lgnu/kawa/slib/printf$frame0;
        //  2620: astore          $heapFrame
        //  2622: aload           $heapFrame
        //  2624: aload           fc
        //  2626: putfield        gnu/kawa/slib/printf$frame1.fc:Ljava/lang/Object;
        //  2629: aload           $heapFrame
        //  2631: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
        //  2634: ldc_w           Lgnu/math/RealNum;.class
        //  2637: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2640: dup            
        //  2641: astore          13
        //  2643: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //  2646: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
        //  2649: ifeq            2663
        //  2652: aload           $heapFrame
        //  2654: getstatic       gnu/kawa/slib/printf.Lit48:Lgnu/math/IntNum;
        //  2657: putfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
        //  2660: goto            2718
        //  2663: aload           $heapFrame
        //  2665: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
        //  2668: ldc             Ljava/lang/Number;.class
        //  2670: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2673: dup            
        //  2674: astore          13
        //  2676: checkcast       Ljava/lang/Number;
        //  2679: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //  2682: ifeq            2718
        //  2685: aload           $heapFrame
        //  2687: getfield        gnu/kawa/slib/printf$frame1.fc:Ljava/lang/Object;
        //  2690: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  2693: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //  2696: invokestatic    java/lang/Character.toUpperCase:(I)I
        //  2699: bipush          103
        //  2701: invokestatic    java/lang/Character.toUpperCase:(I)I
        //  2704: if_icmpne       2718
        //  2707: aload           $heapFrame
        //  2709: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
        //  2712: putfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
        //  2715: goto            2718
        //  2718: aload           num
        //  2720: invokestatic    kawa/lib/numbers.isNumber:(Ljava/lang/Object;)Z
        //  2723: ifeq            2748
        //  2726: aload           num
        //  2728: ldc             Ljava/lang/Number;.class
        //  2730: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2733: dup            
        //  2734: astore          14
        //  2736: checkcast       Ljava/lang/Number;
        //  2739: invokestatic    kawa/lib/numbers.exact$To$Inexact:(Ljava/lang/Number;)Ljava/lang/Number;
        //  2742: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
        //  2745: goto            2792
        //  2748: aload           num
        //  2750: invokestatic    kawa/lib/strings.isString:(Ljava/lang/Object;)Z
        //  2753: ifeq            2761
        //  2756: aload           num
        //  2758: goto            2792
        //  2761: aload           num
        //  2763: invokestatic    kawa/lib/misc.isSymbol:(Ljava/lang/Object;)Z
        //  2766: ifeq            2789
        //  2769: aload           num
        //  2771: ldc_w           Lgnu/mapping/Symbol;.class
        //  2774: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2777: dup            
        //  2778: astore          14
        //  2780: checkcast       Lgnu/mapping/Symbol;
        //  2783: invokestatic    kawa/lib/misc.symbol$To$String:(Lgnu/mapping/Symbol;)Ljava/lang/String;
        //  2786: goto            2792
        //  2789: ldc_w           "???"
        //  2792: astore          str
        //  2794: aload           $heapFrame
        //  2796: getfield        gnu/kawa/slib/printf$frame1.format$Mnreal:Lgnu/mapping/Procedure;
        //  2799: aload           $heapFrame
        //  2801: swap           
        //  2802: putfield        gnu/kawa/slib/printf$frame1.format$Mnreal:Lgnu/mapping/Procedure;
        //  2805: aload           str
        //  2807: aload           $heapFrame
        //  2809: getfield        gnu/kawa/slib/printf$frame1.lambda$Fn5:Lgnu/expr/ModuleMethod;
        //  2812: invokestatic    gnu/kawa/slib/printf.stdio$ClParseFloat:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  2815: astore          x
        //  2817: aload           x
        //  2819: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  2822: ifeq            2830
        //  2825: aload           x
        //  2827: goto            2842
        //  2830: aload           $heapFrame
        //  2832: ldc_w           "???"
        //  2835: iconst_0       
        //  2836: anewarray       Ljava/lang/Object;
        //  2839: invokevirtual   gnu/kawa/slib/printf$frame0.lambda3pad$V:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //  2842: invokevirtual   gnu/kawa/slib/printf$frame.lambda5out$St:(Ljava/lang/Object;)Ljava/lang/Object;
        //  2845: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  2848: ifeq            2874
        //  2851: aload           $heapFrame
        //  2853: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  2856: ldc_w           Lgnu/lists/Pair;.class
        //  2859: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2862: dup            
        //  2863: astore          10
        //  2865: checkcast       Lgnu/lists/Pair;
        //  2868: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  2871: goto            109
        //  2874: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  2877: goto            3648
        //  2880: aload           tmp
        //  2882: getstatic       gnu/kawa/slib/printf.Lit56:Lgnu/text/Char;
        //  2885: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2888: ifeq            3499
        //  2891: goto            2905
        //  2894: aload           tmp
        //  2896: getstatic       gnu/kawa/slib/printf.Lit57:Lgnu/text/Char;
        //  2899: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2902: ifeq            3499
        //  2905: aload           $heapFrame
        //  2907: aload           $heapFrame
        //  2909: aload           $heapFrame
        //  2911: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  2914: ldc_w           Lgnu/lists/Pair;.class
        //  2917: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2920: dup            
        //  2921: astore          10
        //  2923: checkcast       Lgnu/lists/Pair;
        //  2926: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  2929: getstatic       gnu/kawa/slib/printf.Lit51:Lgnu/math/IntNum;
        //  2932: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  2935: invokevirtual   gnu/kawa/slib/printf$frame0.lambda6integerConvert:(Ljava/lang/Object;Lgnu/math/IntNum;Ljava/lang/Object;)Ljava/lang/Object;
        //  2938: invokevirtual   gnu/kawa/slib/printf$frame.lambda5out$St:(Ljava/lang/Object;)Ljava/lang/Object;
        //  2941: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  2944: ifeq            2970
        //  2947: aload           $heapFrame
        //  2949: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  2952: ldc_w           Lgnu/lists/Pair;.class
        //  2955: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2958: dup            
        //  2959: astore          10
        //  2961: checkcast       Lgnu/lists/Pair;
        //  2964: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  2967: goto            109
        //  2970: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  2973: goto            3648
        //  2976: aload           tmp
        //  2978: getstatic       gnu/kawa/slib/printf.Lit58:Lgnu/text/Char;
        //  2981: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2984: ifeq            3499
        //  2987: aload           $heapFrame
        //  2989: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  2992: ldc_w           Lgnu/lists/Pair;.class
        //  2995: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  2998: dup            
        //  2999: astore          11
        //  3001: checkcast       Lgnu/lists/Pair;
        //  3004: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  3007: invokestatic    kawa/lib/misc.isSymbol:(Ljava/lang/Object;)Z
        //  3010: ifeq            3051
        //  3013: aload           $heapFrame
        //  3015: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  3018: ldc_w           Lgnu/lists/Pair;.class
        //  3021: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  3024: dup            
        //  3025: astore          11
        //  3027: checkcast       Lgnu/lists/Pair;
        //  3030: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  3033: ldc_w           Lgnu/mapping/Symbol;.class
        //  3036: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  3039: dup            
        //  3040: astore          11
        //  3042: checkcast       Lgnu/mapping/Symbol;
        //  3045: invokestatic    kawa/lib/misc.symbol$To$String:(Lgnu/mapping/Symbol;)Ljava/lang/String;
        //  3048: goto            3103
        //  3051: aload           $heapFrame
        //  3053: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  3056: ldc_w           Lgnu/lists/Pair;.class
        //  3059: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  3062: dup            
        //  3063: astore          11
        //  3065: checkcast       Lgnu/lists/Pair;
        //  3068: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  3071: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  3074: ifne            3083
        //  3077: ldc_w           "(NULL)"
        //  3080: goto            3103
        //  3083: aload           $heapFrame
        //  3085: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  3088: ldc_w           Lgnu/lists/Pair;.class
        //  3091: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  3094: dup            
        //  3095: astore          11
        //  3097: checkcast       Lgnu/lists/Pair;
        //  3100: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  3103: astore          s
        //  3105: aload           $heapFrame
        //  3107: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
        //  3110: ldc_w           Lgnu/math/RealNum;.class
        //  3113: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  3116: dup            
        //  3117: astore          12
        //  3119: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceRealNum:(Ljava/lang/Object;)Lgnu/math/RealNum;
        //  3122: invokestatic    kawa/lib/numbers.isNegative:(Lgnu/math/RealNum;)Z
        //  3125: istore          x
        //  3127: iload           x
        //  3129: ifeq            3140
        //  3132: iload           x
        //  3134: ifne            3206
        //  3137: goto            3170
        //  3140: aload           $heapFrame
        //  3142: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
        //  3145: aload           s
        //  3147: ldc             Ljava/lang/CharSequence;.class
        //  3149: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  3152: dup            
        //  3153: astore          12
        //  3155: checkcast       Ljava/lang/CharSequence;
        //  3158: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //  3161: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  3164: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3167: ifne            3206
        //  3170: aload           s
        //  3172: ldc             Ljava/lang/CharSequence;.class
        //  3174: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  3177: dup            
        //  3178: astore          11
        //  3180: checkcast       Ljava/lang/CharSequence;
        //  3183: iconst_0       
        //  3184: aload           $heapFrame
        //  3186: getfield        gnu/kawa/slib/printf$frame0.precision:Ljava/lang/Object;
        //  3189: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  3192: dup            
        //  3193: astore          11
        //  3195: checkcast       Ljava/lang/Number;
        //  3198: invokevirtual   java/lang/Number.intValue:()I
        //  3201: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //  3204: astore          s
        //  3206: aload           $heapFrame
        //  3208: aload           $heapFrame
        //  3210: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //  3213: aload           s
        //  3215: ldc             Ljava/lang/CharSequence;.class
        //  3217: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  3220: dup            
        //  3221: astore          11
        //  3223: checkcast       Ljava/lang/CharSequence;
        //  3226: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //  3229: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  3232: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3235: ifeq            3243
        //  3238: aload           s
        //  3240: goto            3367
        //  3243: aload           $heapFrame
        //  3245: getfield        gnu/kawa/slib/printf$frame0.left$Mnadjust:Z
        //  3248: ifeq            3304
        //  3251: aload           s
        //  3253: iconst_m1      
        //  3254: aload           $heapFrame
        //  3256: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //  3259: aload           s
        //  3261: ldc             Ljava/lang/CharSequence;.class
        //  3263: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  3266: dup            
        //  3267: astore          11
        //  3269: checkcast       Ljava/lang/CharSequence;
        //  3272: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //  3275: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  3278: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  3281: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  3284: dup            
        //  3285: astore          11
        //  3287: checkcast       Ljava/lang/Number;
        //  3290: invokevirtual   java/lang/Number.intValue:()I
        //  3293: bipush          32
        //  3295: invokestatic    kawa/lib/strings.makeString:(II)Lgnu/lists/FString;
        //  3298: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //  3301: goto            3367
        //  3304: iconst_m1      
        //  3305: aload           $heapFrame
        //  3307: getfield        gnu/kawa/slib/printf$frame0.width:Ljava/lang/Object;
        //  3310: aload           s
        //  3312: ldc             Ljava/lang/CharSequence;.class
        //  3314: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  3317: dup            
        //  3318: astore          11
        //  3320: checkcast       Ljava/lang/CharSequence;
        //  3323: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //  3326: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  3329: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  3332: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //  3335: dup            
        //  3336: astore          11
        //  3338: checkcast       Ljava/lang/Number;
        //  3341: invokevirtual   java/lang/Number.intValue:()I
        //  3344: aload           $heapFrame
        //  3346: getfield        gnu/kawa/slib/printf$frame0.leading$Mn0s:Z
        //  3349: ifeq            3357
        //  3352: bipush          48
        //  3354: goto            3359
        //  3357: bipush          32
        //  3359: invokestatic    kawa/lib/strings.makeString:(II)Lgnu/lists/FString;
        //  3362: aload           s
        //  3364: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //  3367: invokevirtual   gnu/kawa/slib/printf$frame.lambda5out$St:(Ljava/lang/Object;)Ljava/lang/Object;
        //  3370: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  3373: ifeq            3399
        //  3376: aload           $heapFrame
        //  3378: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  3381: ldc_w           Lgnu/lists/Pair;.class
        //  3384: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  3387: dup            
        //  3388: astore          11
        //  3390: checkcast       Lgnu/lists/Pair;
        //  3393: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  3396: goto            109
        //  3399: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  3402: goto            3648
        //  3405: aload           tmp
        //  3407: getstatic       gnu/kawa/slib/printf.Lit59:Lgnu/text/Char;
        //  3410: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3413: ifeq            3499
        //  3416: aload           $heapFrame
        //  3418: aload           $heapFrame
        //  3420: aload           $heapFrame
        //  3422: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  3425: ldc_w           Lgnu/lists/Pair;.class
        //  3428: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  3431: dup            
        //  3432: astore          10
        //  3434: checkcast       Lgnu/lists/Pair;
        //  3437: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  3440: getstatic       gnu/kawa/slib/printf.Lit37:Lgnu/math/IntNum;
        //  3443: getstatic       gnu/kawa/slib/printf.stdio$Clhex$Mnupper$Mncase$Qu:Z
        //  3446: ifeq            3455
        //  3449: getstatic       kawa/lib/rnrs/unicode.string$Mndowncase:Lgnu/expr/ModuleMethod;
        //  3452: goto            3458
        //  3455: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  3458: invokevirtual   gnu/kawa/slib/printf$frame0.lambda6integerConvert:(Ljava/lang/Object;Lgnu/math/IntNum;Ljava/lang/Object;)Ljava/lang/Object;
        //  3461: invokevirtual   gnu/kawa/slib/printf$frame.lambda5out$St:(Ljava/lang/Object;)Ljava/lang/Object;
        //  3464: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  3467: ifeq            3493
        //  3470: aload           $heapFrame
        //  3472: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  3475: ldc_w           Lgnu/lists/Pair;.class
        //  3478: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  3481: dup            
        //  3482: astore          10
        //  3484: checkcast       Lgnu/lists/Pair;
        //  3487: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //  3490: goto            109
        //  3493: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  3496: goto            3648
        //  3499: aload           $heapFrame
        //  3501: iload           fl
        //  3503: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  3506: invokevirtual   gnu/kawa/slib/printf$frame.lambda1isEndOfFormat:(Ljava/lang/Object;)Z
        //  3509: ifeq            3521
        //  3512: aload           $heapFrame
        //  3514: invokevirtual   gnu/kawa/slib/printf$frame.lambda14incomplete:()Lgnu/bytecode/Type$NeverReturns;
        //  3517: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //  3520: athrow         
        //  3521: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //  3524: aload           $heapFrame
        //  3526: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //  3529: getstatic       gnu/kawa/slib/printf.Lit12:Lgnu/text/Char;
        //  3532: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  3535: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  3538: ifeq            3603
        //  3541: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //  3544: aload           $heapFrame
        //  3546: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //  3549: aload           $heapFrame
        //  3551: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //  3554: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  3557: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  3560: ifeq            3597
        //  3563: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //  3566: aload           $heapFrame
        //  3568: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //  3571: getstatic       gnu/kawa/slib/printf.Lit60:Lgnu/text/Char;
        //  3574: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  3577: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  3580: ifeq            3591
        //  3583: aload           $heapFrame
        //  3585: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  3588: goto            109
        //  3591: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  3594: goto            3648
        //  3597: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  3600: goto            3648
        //  3603: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  3606: goto            3648
        //  3609: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //  3612: aload           $heapFrame
        //  3614: getfield        gnu/kawa/slib/printf$frame.out:Ljava/lang/Object;
        //  3617: aload           $heapFrame
        //  3619: getfield        gnu/kawa/slib/printf$frame.fc:Ljava/lang/Object;
        //  3622: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  3625: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //  3628: ifeq            3639
        //  3631: aload           $heapFrame
        //  3633: getfield        gnu/kawa/slib/printf$frame0.args:Ljava/lang/Object;
        //  3636: goto            109
        //  3639: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //  3642: goto            3648
        //  3645: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //  3648: areturn        
        //  3649: new             Lgnu/mapping/WrongType;
        //  3652: dup_x1         
        //  3653: swap           
        //  3654: ldc             "string-length"
        //  3656: iconst_1       
        //  3657: aload           6
        //  3659: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3662: athrow         
        //  3663: new             Lgnu/mapping/WrongType;
        //  3666: dup_x1         
        //  3667: swap           
        //  3668: ldc             "string-ref"
        //  3670: iconst_1       
        //  3671: aload           6
        //  3673: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3676: athrow         
        //  3677: new             Lgnu/mapping/WrongType;
        //  3680: dup_x1         
        //  3681: swap           
        //  3682: ldc             "string-ref"
        //  3684: iconst_1       
        //  3685: aload           8
        //  3687: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3690: athrow         
        //  3691: new             Lgnu/mapping/WrongType;
        //  3694: dup_x1         
        //  3695: swap           
        //  3696: ldc             "string-ref"
        //  3698: iconst_2       
        //  3699: aload           8
        //  3701: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3704: athrow         
        //  3705: new             Lgnu/mapping/WrongType;
        //  3708: dup_x1         
        //  3709: swap           
        //  3710: ldc_w           "negative?"
        //  3713: iconst_1       
        //  3714: aload           9
        //  3716: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3719: athrow         
        //  3720: new             Lgnu/mapping/WrongType;
        //  3723: dup_x1         
        //  3724: swap           
        //  3725: ldc_w           "char-downcase"
        //  3728: iconst_1       
        //  3729: aload           9
        //  3731: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3734: athrow         
        //  3735: new             Lgnu/mapping/WrongType;
        //  3738: dup_x1         
        //  3739: swap           
        //  3740: ldc_w           "car"
        //  3743: iconst_1       
        //  3744: aload           10
        //  3746: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3749: athrow         
        //  3750: new             Lgnu/mapping/WrongType;
        //  3753: dup_x1         
        //  3754: swap           
        //  3755: ldc_w           "cdr"
        //  3758: iconst_1       
        //  3759: aload           10
        //  3761: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3764: athrow         
        //  3765: new             Lgnu/mapping/WrongType;
        //  3768: dup_x1         
        //  3769: swap           
        //  3770: ldc_w           "car"
        //  3773: iconst_1       
        //  3774: aload           10
        //  3776: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3779: athrow         
        //  3780: new             Lgnu/mapping/WrongType;
        //  3783: dup_x1         
        //  3784: swap           
        //  3785: ldc_w           "cdr"
        //  3788: iconst_1       
        //  3789: aload           10
        //  3791: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3794: athrow         
        //  3795: new             Lgnu/mapping/WrongType;
        //  3798: dup_x1         
        //  3799: swap           
        //  3800: ldc_w           "car"
        //  3803: iconst_1       
        //  3804: aload           10
        //  3806: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3809: athrow         
        //  3810: new             Lgnu/mapping/WrongType;
        //  3813: dup_x1         
        //  3814: swap           
        //  3815: ldc_w           "cdr"
        //  3818: iconst_1       
        //  3819: aload           10
        //  3821: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3824: athrow         
        //  3825: new             Lgnu/mapping/WrongType;
        //  3828: dup_x1         
        //  3829: swap           
        //  3830: ldc_w           "car"
        //  3833: iconst_1       
        //  3834: aload           10
        //  3836: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3839: athrow         
        //  3840: new             Lgnu/mapping/WrongType;
        //  3843: dup_x1         
        //  3844: swap           
        //  3845: ldc_w           "negative?"
        //  3848: iconst_1       
        //  3849: aload           10
        //  3851: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3854: athrow         
        //  3855: new             Lgnu/mapping/WrongType;
        //  3858: dup_x1         
        //  3859: swap           
        //  3860: ldc_w           "negative?"
        //  3863: iconst_1       
        //  3864: aload           10
        //  3866: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3869: athrow         
        //  3870: new             Lgnu/mapping/WrongType;
        //  3873: dup_x1         
        //  3874: swap           
        //  3875: ldc_w           "negative?"
        //  3878: iconst_1       
        //  3879: aload           10
        //  3881: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3884: athrow         
        //  3885: new             Lgnu/mapping/WrongType;
        //  3888: dup_x1         
        //  3889: swap           
        //  3890: ldc_w           "make-string"
        //  3893: iconst_1       
        //  3894: aload           10
        //  3896: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3899: athrow         
        //  3900: new             Lgnu/mapping/WrongType;
        //  3903: dup_x1         
        //  3904: swap           
        //  3905: ldc_w           "make-string"
        //  3908: iconst_1       
        //  3909: aload           10
        //  3911: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3914: athrow         
        //  3915: new             Lgnu/mapping/WrongType;
        //  3918: dup_x1         
        //  3919: swap           
        //  3920: ldc             "string-length"
        //  3922: iconst_1       
        //  3923: aload           11
        //  3925: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3928: athrow         
        //  3929: new             Lgnu/mapping/WrongType;
        //  3932: dup_x1         
        //  3933: swap           
        //  3934: ldc             "string-length"
        //  3936: iconst_1       
        //  3937: aload           11
        //  3939: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3942: athrow         
        //  3943: new             Lgnu/mapping/WrongType;
        //  3946: dup_x1         
        //  3947: swap           
        //  3948: ldc_w           "make-string"
        //  3951: iconst_1       
        //  3952: aload           11
        //  3954: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3957: athrow         
        //  3958: new             Lgnu/mapping/WrongType;
        //  3961: dup_x1         
        //  3962: swap           
        //  3963: ldc_w           "cdr"
        //  3966: iconst_1       
        //  3967: aload           10
        //  3969: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3972: athrow         
        //  3973: new             Lgnu/mapping/WrongType;
        //  3976: dup_x1         
        //  3977: swap           
        //  3978: ldc_w           "car"
        //  3981: iconst_1       
        //  3982: aload           10
        //  3984: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  3987: athrow         
        //  3988: new             Lgnu/mapping/WrongType;
        //  3991: dup_x1         
        //  3992: swap           
        //  3993: ldc_w           "cdr"
        //  3996: iconst_1       
        //  3997: aload           10
        //  3999: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4002: athrow         
        //  4003: new             Lgnu/mapping/WrongType;
        //  4006: dup_x1         
        //  4007: swap           
        //  4008: ldc_w           "car"
        //  4011: iconst_1       
        //  4012: aload           10
        //  4014: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4017: athrow         
        //  4018: new             Lgnu/mapping/WrongType;
        //  4021: dup_x1         
        //  4022: swap           
        //  4023: ldc_w           "negative?"
        //  4026: iconst_1       
        //  4027: aload           13
        //  4029: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4032: athrow         
        //  4033: new             Lgnu/mapping/WrongType;
        //  4036: dup_x1         
        //  4037: swap           
        //  4038: ldc_w           "zero?"
        //  4041: iconst_1       
        //  4042: aload           13
        //  4044: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4047: athrow         
        //  4048: new             Lgnu/mapping/WrongType;
        //  4051: dup_x1         
        //  4052: swap           
        //  4053: ldc_w           "exact->inexact"
        //  4056: iconst_1       
        //  4057: aload           14
        //  4059: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4062: athrow         
        //  4063: new             Lgnu/mapping/WrongType;
        //  4066: dup_x1         
        //  4067: swap           
        //  4068: ldc_w           "symbol->string"
        //  4071: iconst_1       
        //  4072: aload           14
        //  4074: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4077: athrow         
        //  4078: new             Lgnu/mapping/WrongType;
        //  4081: dup_x1         
        //  4082: swap           
        //  4083: ldc_w           "cdr"
        //  4086: iconst_1       
        //  4087: aload           10
        //  4089: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4092: athrow         
        //  4093: new             Lgnu/mapping/WrongType;
        //  4096: dup_x1         
        //  4097: swap           
        //  4098: ldc_w           "car"
        //  4101: iconst_1       
        //  4102: aload           10
        //  4104: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4107: athrow         
        //  4108: new             Lgnu/mapping/WrongType;
        //  4111: dup_x1         
        //  4112: swap           
        //  4113: ldc_w           "cdr"
        //  4116: iconst_1       
        //  4117: aload           10
        //  4119: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4122: athrow         
        //  4123: new             Lgnu/mapping/WrongType;
        //  4126: dup_x1         
        //  4127: swap           
        //  4128: ldc_w           "car"
        //  4131: iconst_1       
        //  4132: aload           11
        //  4134: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4137: athrow         
        //  4138: new             Lgnu/mapping/WrongType;
        //  4141: dup_x1         
        //  4142: swap           
        //  4143: ldc_w           "car"
        //  4146: iconst_1       
        //  4147: aload           11
        //  4149: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4152: athrow         
        //  4153: new             Lgnu/mapping/WrongType;
        //  4156: dup_x1         
        //  4157: swap           
        //  4158: ldc_w           "symbol->string"
        //  4161: iconst_1       
        //  4162: aload           11
        //  4164: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4167: athrow         
        //  4168: new             Lgnu/mapping/WrongType;
        //  4171: dup_x1         
        //  4172: swap           
        //  4173: ldc_w           "car"
        //  4176: iconst_1       
        //  4177: aload           11
        //  4179: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4182: athrow         
        //  4183: new             Lgnu/mapping/WrongType;
        //  4186: dup_x1         
        //  4187: swap           
        //  4188: ldc_w           "car"
        //  4191: iconst_1       
        //  4192: aload           11
        //  4194: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4197: athrow         
        //  4198: new             Lgnu/mapping/WrongType;
        //  4201: dup_x1         
        //  4202: swap           
        //  4203: ldc_w           "negative?"
        //  4206: iconst_1       
        //  4207: aload           12
        //  4209: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4212: athrow         
        //  4213: new             Lgnu/mapping/WrongType;
        //  4216: dup_x1         
        //  4217: swap           
        //  4218: ldc             "string-length"
        //  4220: iconst_1       
        //  4221: aload           12
        //  4223: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4226: athrow         
        //  4227: new             Lgnu/mapping/WrongType;
        //  4230: dup_x1         
        //  4231: swap           
        //  4232: ldc_w           "substring"
        //  4235: iconst_1       
        //  4236: aload           11
        //  4238: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4241: athrow         
        //  4242: new             Lgnu/mapping/WrongType;
        //  4245: dup_x1         
        //  4246: swap           
        //  4247: ldc_w           "substring"
        //  4250: iconst_3       
        //  4251: aload           11
        //  4253: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4256: athrow         
        //  4257: new             Lgnu/mapping/WrongType;
        //  4260: dup_x1         
        //  4261: swap           
        //  4262: ldc             "string-length"
        //  4264: iconst_1       
        //  4265: aload           11
        //  4267: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4270: athrow         
        //  4271: new             Lgnu/mapping/WrongType;
        //  4274: dup_x1         
        //  4275: swap           
        //  4276: ldc             "string-length"
        //  4278: iconst_1       
        //  4279: aload           11
        //  4281: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4284: athrow         
        //  4285: new             Lgnu/mapping/WrongType;
        //  4288: dup_x1         
        //  4289: swap           
        //  4290: ldc_w           "make-string"
        //  4293: iconst_1       
        //  4294: aload           11
        //  4296: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4299: athrow         
        //  4300: new             Lgnu/mapping/WrongType;
        //  4303: dup_x1         
        //  4304: swap           
        //  4305: ldc             "string-length"
        //  4307: iconst_1       
        //  4308: aload           11
        //  4310: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4313: athrow         
        //  4314: new             Lgnu/mapping/WrongType;
        //  4317: dup_x1         
        //  4318: swap           
        //  4319: ldc_w           "make-string"
        //  4322: iconst_1       
        //  4323: aload           11
        //  4325: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4328: athrow         
        //  4329: new             Lgnu/mapping/WrongType;
        //  4332: dup_x1         
        //  4333: swap           
        //  4334: ldc_w           "cdr"
        //  4337: iconst_1       
        //  4338: aload           11
        //  4340: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4343: athrow         
        //  4344: new             Lgnu/mapping/WrongType;
        //  4347: dup_x1         
        //  4348: swap           
        //  4349: ldc_w           "car"
        //  4352: iconst_1       
        //  4353: aload           10
        //  4355: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4358: athrow         
        //  4359: new             Lgnu/mapping/WrongType;
        //  4362: dup_x1         
        //  4363: swap           
        //  4364: ldc_w           "cdr"
        //  4367: iconst_1       
        //  4368: aload           10
        //  4370: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4373: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  71     74     3649   3663   Ljava/lang/ClassCastException;
        //  92     95     3663   3677   Ljava/lang/ClassCastException;
        //  187    190    3677   3691   Ljava/lang/ClassCastException;
        //  198    201    3691   3705   Ljava/lang/ClassCastException;
        //  897    900    3705   3720   Ljava/lang/ClassCastException;
        //  1086   1089   3720   3735   Ljava/lang/ClassCastException;
        //  1585   1588   3735   3750   Ljava/lang/ClassCastException;
        //  1635   1638   3750   3765   Ljava/lang/ClassCastException;
        //  1735   1738   3765   3780   Ljava/lang/ClassCastException;
        //  1773   1776   3780   3795   Ljava/lang/ClassCastException;
        //  1821   1824   3795   3810   Ljava/lang/ClassCastException;
        //  1875   1878   3810   3825   Ljava/lang/ClassCastException;
        //  1934   1937   3825   3840   Ljava/lang/ClassCastException;
        //  1982   1985   3840   3855   Ljava/lang/ClassCastException;
        //  2037   2040   3855   3870   Ljava/lang/ClassCastException;
        //  2095   2098   3870   3885   Ljava/lang/ClassCastException;
        //  2148   2154   3885   3900   Ljava/lang/ClassCastException;
        //  2236   2242   3900   3915   Ljava/lang/ClassCastException;
        //  2298   2301   3915   3929   Ljava/lang/ClassCastException;
        //  2360   2363   3929   3943   Ljava/lang/ClassCastException;
        //  2378   2384   3943   3958   Ljava/lang/ClassCastException;
        //  2429   2432   3958   3973   Ljava/lang/ClassCastException;
        //  2512   2515   3973   3988   Ljava/lang/ClassCastException;
        //  2550   2553   3988   4003   Ljava/lang/ClassCastException;
        //  2592   2595   4003   4018   Ljava/lang/ClassCastException;
        //  2643   2646   4018   4033   Ljava/lang/ClassCastException;
        //  2676   2679   4033   4048   Ljava/lang/ClassCastException;
        //  2736   2739   4048   4063   Ljava/lang/ClassCastException;
        //  2780   2783   4063   4078   Ljava/lang/ClassCastException;
        //  2865   2868   4078   4093   Ljava/lang/ClassCastException;
        //  2923   2926   4093   4108   Ljava/lang/ClassCastException;
        //  2961   2964   4108   4123   Ljava/lang/ClassCastException;
        //  3001   3004   4123   4138   Ljava/lang/ClassCastException;
        //  3027   3030   4138   4153   Ljava/lang/ClassCastException;
        //  3042   3045   4153   4168   Ljava/lang/ClassCastException;
        //  3065   3068   4168   4183   Ljava/lang/ClassCastException;
        //  3097   3100   4183   4198   Ljava/lang/ClassCastException;
        //  3119   3122   4198   4213   Ljava/lang/ClassCastException;
        //  3155   3158   4213   4227   Ljava/lang/ClassCastException;
        //  3180   3183   4227   4242   Ljava/lang/ClassCastException;
        //  3195   3201   4242   4257   Ljava/lang/ClassCastException;
        //  3223   3226   4257   4271   Ljava/lang/ClassCastException;
        //  3269   3272   4271   4285   Ljava/lang/ClassCastException;
        //  3287   3293   4285   4300   Ljava/lang/ClassCastException;
        //  3320   3323   4300   4314   Ljava/lang/ClassCastException;
        //  3338   3344   4314   4329   Ljava/lang/ClassCastException;
        //  3390   3393   4329   4344   Ljava/lang/ClassCastException;
        //  3434   3437   4344   4359   Ljava/lang/ClassCastException;
        //  3484   3487   4359   4374   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object stdio$ClRoundString(final CharSequence str, final Object ndigs, final Object strip$Mn0s) {
        public class printf$frame13 extends ModuleBody
        {
            CharSequence str;
            
            public Object lambda32dig(final Object i) {
                final CharSequence str = this.str;
                final Object force = Promise.force(i);
                try {
                    final int c = strings.stringRef(str, ((Number)force).intValue());
                    return unicode.isCharNumeric(c) ? numbers.string$To$Number(strings.$make$string$(Char.make(c))) : gnu.kawa.slib.printf.Lit13;
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "string-ref", 2, force);
                }
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/slib/printf$frame13.<init>:()V
        //     7: astore_3        /* $heapFrame */
        //     8: aload_3         /* $heapFrame */
        //     9: aload_0         /* str */
        //    10: putfield        gnu/kawa/slib/printf$frame13.str:Ljava/lang/CharSequence;
        //    13: aload_3         /* $heapFrame */
        //    14: getfield        gnu/kawa/slib/printf$frame13.str:Ljava/lang/CharSequence;
        //    17: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //    20: iconst_1       
        //    21: isub           
        //    22: istore          n
        //    24: aload_1         /* ndigs */
        //    25: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
        //    28: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    31: ifeq            39
        //    34: ldc             ""
        //    36: goto            470
        //    39: iload           n
        //    41: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    44: aload_1         /* ndigs */
        //    45: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    48: ifeq            58
        //    51: aload_3         /* $heapFrame */
        //    52: getfield        gnu/kawa/slib/printf$frame13.str:Ljava/lang/CharSequence;
        //    55: goto            470
        //    58: iload           n
        //    60: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    63: aload_1         /* ndigs */
        //    64: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    67: ifeq            194
        //    70: iconst_2       
        //    71: anewarray       Ljava/lang/Object;
        //    74: dup            
        //    75: iconst_0       
        //    76: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
        //    79: aastore        
        //    80: dup            
        //    81: iconst_1       
        //    82: iconst_m1      
        //    83: aload_2         /* strip$Mn0s */
        //    84: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    87: ifeq            94
        //    90: aload_2         /* strip$Mn0s */
        //    91: goto            95
        //    94: aload_1         /* ndigs */
        //    95: iload           n
        //    97: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   100: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: aastore        
        //   104: invokestatic    kawa/lib/numbers.max:([Ljava/lang/Object;)Ljava/lang/Object;
        //   107: astore          padlen
        //   109: aload           padlen
        //   111: ldc             Ljava/lang/Number;.class
        //   113: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   116: dup            
        //   117: astore          7
        //   119: checkcast       Ljava/lang/Number;
        //   122: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //   125: ifeq            135
        //   128: aload_3         /* $heapFrame */
        //   129: getfield        gnu/kawa/slib/printf$frame13.str:Ljava/lang/CharSequence;
        //   132: goto            470
        //   135: iconst_2       
        //   136: anewarray       Ljava/lang/Object;
        //   139: dup            
        //   140: iconst_0       
        //   141: aload_3         /* $heapFrame */
        //   142: getfield        gnu/kawa/slib/printf$frame13.str:Ljava/lang/CharSequence;
        //   145: aastore        
        //   146: dup            
        //   147: iconst_1       
        //   148: aload           padlen
        //   150: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   153: dup            
        //   154: astore          7
        //   156: checkcast       Ljava/lang/Number;
        //   159: invokevirtual   java/lang/Number.intValue:()I
        //   162: aload_3         /* $heapFrame */
        //   163: getfield        gnu/kawa/slib/printf$frame13.str:Ljava/lang/CharSequence;
        //   166: iload           n
        //   168: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   171: invokestatic    kawa/lib/rnrs/unicode.isCharNumeric:(I)Z
        //   174: ifeq            182
        //   177: bipush          48
        //   179: goto            184
        //   182: bipush          35
        //   184: invokestatic    kawa/lib/strings.makeString:(II)Lgnu/lists/FString;
        //   187: aastore        
        //   188: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   191: goto            470
        //   194: aload_3         /* $heapFrame */
        //   195: getfield        gnu/kawa/slib/printf$frame13.str:Ljava/lang/CharSequence;
        //   198: iconst_0       
        //   199: iconst_1       
        //   200: aload_1         /* ndigs */
        //   201: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
        //   204: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   207: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   210: dup            
        //   211: astore          7
        //   213: checkcast       Ljava/lang/Number;
        //   216: invokevirtual   java/lang/Number.intValue:()I
        //   219: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   222: astore          res
        //   224: aload_3         /* $heapFrame */
        //   225: iconst_1       
        //   226: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
        //   229: aload_1         /* ndigs */
        //   230: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   233: invokevirtual   gnu/kawa/slib/printf$frame13.lambda32dig:(Ljava/lang/Object;)Ljava/lang/Object;
        //   236: astore          ldig
        //   238: aload           ldig
        //   240: getstatic       gnu/kawa/slib/printf.Lit67:Lgnu/math/IntNum;
        //   243: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   246: istore          x
        //   248: iload           x
        //   250: ifeq            261
        //   253: iload           x
        //   255: ifeq            468
        //   258: goto            352
        //   261: aload           ldig
        //   263: getstatic       gnu/kawa/slib/printf.Lit67:Lgnu/math/IntNum;
        //   266: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   269: ifeq            468
        //   272: iconst_1       
        //   273: getstatic       gnu/kawa/slib/printf.Lit42:Lgnu/math/IntNum;
        //   276: aload_1         /* ndigs */
        //   277: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   280: astore          i
        //   282: aload           i
        //   284: iload           n
        //   286: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   289: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   292: ifeq            317
        //   295: aload_3         /* $heapFrame */
        //   296: aload_1         /* ndigs */
        //   297: invokevirtual   gnu/kawa/slib/printf$frame13.lambda32dig:(Ljava/lang/Object;)Ljava/lang/Object;
        //   300: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   303: checkcast       Ljava/lang/Number;
        //   306: invokevirtual   java/lang/Number.intValue:()I
        //   309: iconst_1       
        //   310: iand           
        //   311: ifeq            468
        //   314: goto            352
        //   317: aload_3         /* $heapFrame */
        //   318: aload           i
        //   320: invokevirtual   gnu/kawa/slib/printf$frame13.lambda32dig:(Ljava/lang/Object;)Ljava/lang/Object;
        //   323: ldc             Ljava/lang/Number;.class
        //   325: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   328: dup            
        //   329: astore          10
        //   331: checkcast       Ljava/lang/Number;
        //   334: invokestatic    kawa/lib/numbers.isZero:(Ljava/lang/Number;)Z
        //   337: ifeq            352
        //   340: iconst_1       
        //   341: aload           i
        //   343: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
        //   346: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   349: goto            280
        //   352: aload_1         /* ndigs */
        //   353: astore          i
        //   355: aload_3         /* $heapFrame */
        //   356: aload           i
        //   358: invokevirtual   gnu/kawa/slib/printf$frame13.lambda32dig:(Ljava/lang/Object;)Ljava/lang/Object;
        //   361: astore          d
        //   363: aload           d
        //   365: getstatic       gnu/kawa/slib/printf.Lit68:Lgnu/math/IntNum;
        //   368: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   371: ifeq            429
        //   374: aload           res
        //   376: dup            
        //   377: astore          11
        //   379: checkcast       Lgnu/lists/CharSeq;
        //   382: aload           i
        //   384: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   387: dup            
        //   388: astore          11
        //   390: checkcast       Ljava/lang/Number;
        //   393: invokevirtual   java/lang/Number.intValue:()I
        //   396: iconst_1       
        //   397: aload           d
        //   399: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
        //   402: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   405: ldc             Ljava/lang/Number;.class
        //   407: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   410: dup            
        //   411: astore          11
        //   413: checkcast       Ljava/lang/Number;
        //   416: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
        //   419: iconst_0       
        //   420: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   423: invokestatic    kawa/lib/strings.stringSet$Ex:(Lgnu/lists/CharSeq;II)V
        //   426: goto            468
        //   429: aload           res
        //   431: dup            
        //   432: astore          11
        //   434: checkcast       Lgnu/lists/CharSeq;
        //   437: aload           i
        //   439: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   442: dup            
        //   443: astore          11
        //   445: checkcast       Ljava/lang/Number;
        //   448: invokevirtual   java/lang/Number.intValue:()I
        //   451: bipush          48
        //   453: invokestatic    kawa/lib/strings.stringSet$Ex:(Lgnu/lists/CharSeq;II)V
        //   456: iconst_m1      
        //   457: aload           i
        //   459: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
        //   462: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   465: goto            353
        //   468: aload           res
        //   470: astore          res
        //   472: aload_2         /* strip$Mn0s */
        //   473: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   476: ifeq            578
        //   479: aload           res
        //   481: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //   484: iconst_1       
        //   485: isub           
        //   486: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   489: astore          i
        //   491: aload           i
        //   493: aload_2         /* strip$Mn0s */
        //   494: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   497: istore          x
        //   499: iload           x
        //   501: ifeq            512
        //   504: iload           x
        //   506: ifeq            566
        //   509: goto            536
        //   512: bipush          48
        //   514: aload           res
        //   516: aload           i
        //   518: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   521: dup            
        //   522: astore          8
        //   524: checkcast       Ljava/lang/Number;
        //   527: invokevirtual   java/lang/Number.intValue:()I
        //   530: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
        //   533: if_icmpeq       566
        //   536: aload           res
        //   538: iconst_0       
        //   539: iconst_1       
        //   540: aload           i
        //   542: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
        //   545: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   548: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   551: dup            
        //   552: astore          8
        //   554: checkcast       Ljava/lang/Number;
        //   557: invokevirtual   java/lang/Number.intValue:()I
        //   560: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   563: goto            580
        //   566: iconst_m1      
        //   567: aload           i
        //   569: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
        //   572: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   575: goto            489
        //   578: aload           res
        //   580: areturn        
        //   581: new             Lgnu/mapping/WrongType;
        //   584: dup_x1         
        //   585: swap           
        //   586: ldc_w           "zero?"
        //   589: iconst_1       
        //   590: aload           7
        //   592: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   595: athrow         
        //   596: new             Lgnu/mapping/WrongType;
        //   599: dup_x1         
        //   600: swap           
        //   601: ldc_w           "make-string"
        //   604: iconst_1       
        //   605: aload           7
        //   607: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   610: athrow         
        //   611: new             Lgnu/mapping/WrongType;
        //   614: dup_x1         
        //   615: swap           
        //   616: ldc_w           "substring"
        //   619: iconst_3       
        //   620: aload           7
        //   622: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   625: athrow         
        //   626: new             Lgnu/mapping/WrongType;
        //   629: dup_x1         
        //   630: swap           
        //   631: ldc_w           "zero?"
        //   634: iconst_1       
        //   635: aload           10
        //   637: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   640: athrow         
        //   641: new             Lgnu/mapping/WrongType;
        //   644: dup_x1         
        //   645: swap           
        //   646: ldc_w           "string-set!"
        //   649: iconst_1       
        //   650: aload           11
        //   652: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   655: athrow         
        //   656: new             Lgnu/mapping/WrongType;
        //   659: dup_x1         
        //   660: swap           
        //   661: ldc_w           "string-set!"
        //   664: iconst_2       
        //   665: aload           11
        //   667: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   670: athrow         
        //   671: new             Lgnu/mapping/WrongType;
        //   674: dup_x1         
        //   675: swap           
        //   676: ldc_w           "number->string"
        //   679: iconst_1       
        //   680: aload           11
        //   682: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   685: athrow         
        //   686: new             Lgnu/mapping/WrongType;
        //   689: dup_x1         
        //   690: swap           
        //   691: ldc_w           "string-set!"
        //   694: iconst_1       
        //   695: aload           11
        //   697: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   700: athrow         
        //   701: new             Lgnu/mapping/WrongType;
        //   704: dup_x1         
        //   705: swap           
        //   706: ldc_w           "string-set!"
        //   709: iconst_2       
        //   710: aload           11
        //   712: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   715: athrow         
        //   716: new             Lgnu/mapping/WrongType;
        //   719: dup_x1         
        //   720: swap           
        //   721: ldc             "string-ref"
        //   723: iconst_2       
        //   724: aload           8
        //   726: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   729: athrow         
        //   730: new             Lgnu/mapping/WrongType;
        //   733: dup_x1         
        //   734: swap           
        //   735: ldc_w           "substring"
        //   738: iconst_3       
        //   739: aload           8
        //   741: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   744: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  119    122    581    596    Ljava/lang/ClassCastException;
        //  156    162    596    611    Ljava/lang/ClassCastException;
        //  213    219    611    626    Ljava/lang/ClassCastException;
        //  331    334    626    641    Ljava/lang/ClassCastException;
        //  379    382    641    656    Ljava/lang/ClassCastException;
        //  390    396    656    671    Ljava/lang/ClassCastException;
        //  413    416    671    686    Ljava/lang/ClassCastException;
        //  434    437    686    701    Ljava/lang/ClassCastException;
        //  445    451    701    716    Ljava/lang/ClassCastException;
        //  524    530    716    730    Ljava/lang/ClassCastException;
        //  554    560    730    745    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 350 out of bounds for length 350
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
    
    static Object stdio$ClParseFloat(final Object str, final Object proc) {
        public class printf$frame4 extends ModuleBody
        {
            Object proc;
            Object str;
            int n;
            final ModuleMethod lambda$Fn8;
            
            public printf$frame4() {
                final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 19, null, 16388);
                lambda$Fn8.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:106");
                this.lambda$Fn8 = lambda$Fn8;
            }
            
            public Object lambda17real(final Object n, final Object i, final Procedure cont) {
                public class printf$frame7 extends ModuleBody
                {
                    Procedure cont;
                    printf$frame4 staticLink;
                    final ModuleMethod lambda$Fn12;
                    final ModuleMethod lambda$Fn13;
                    
                    public printf$frame7() {
                        final ModuleMethod lambda$Fn13 = new ModuleMethod(this, 17, null, 8194);
                        lambda$Fn13.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:81");
                        this.lambda$Fn13 = lambda$Fn13;
                        final ModuleMethod lambda$Fn14 = new ModuleMethod(this, 18, null, 4097);
                        lambda$Fn14.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:78");
                        this.lambda$Fn12 = lambda$Fn14;
                    }
                    
                    Object lambda25(final Object i) {
                        return this.staticLink.lambda23sign(this.staticLink.n, i, this.lambda$Fn13);
                    }
                    
                    Object lambda26(final Object i, final Object sgn) {
                        public class printf$frame8 extends ModuleBody
                        {
                            Object sgn;
                            printf$frame7 staticLink;
                            final ModuleMethod lambda$Fn14;
                            
                            public printf$frame8() {
                                final ModuleMethod lambda$Fn14 = new ModuleMethod(this, 16, null, 8194);
                                lambda$Fn14.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:84");
                                this.lambda$Fn14 = lambda$Fn14;
                            }
                            
                            Object lambda27(final Object i, final Object idigs) {
                                public class printf$frame9 extends ModuleBody
                                {
                                    Object idigs;
                                    printf$frame8 staticLink;
                                    final ModuleMethod lambda$Fn15;
                                    
                                    public printf$frame9() {
                                        final ModuleMethod lambda$Fn15 = new ModuleMethod(this, 15, null, 8194);
                                        lambda$Fn15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:90");
                                        this.lambda$Fn15 = lambda$Fn15;
                                    }
                                    
                                    Object lambda28(final Object i, final Object fdigs) {
                                        public class printf$frame11 extends ModuleBody
                                        {
                                            printf$frame9 staticLink;
                                            final ModuleMethod lambda$Fn16;
                                            
                                            public printf$frame11() {
                                                final ModuleMethod lambda$Fn16 = new ModuleMethod(this, 14, null, 8194);
                                                lambda$Fn16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:67");
                                                this.lambda$Fn16 = lambda$Fn16;
                                            }
                                            
                                            Object lambda30(final Object i, final Object sgn) {
                                                public class printf$frame12 extends ModuleBody
                                                {
                                                    Object sgn;
                                                    printf$frame11 staticLink;
                                                    final ModuleMethod lambda$Fn17;
                                                    
                                                    public printf$frame12() {
                                                        final ModuleMethod lambda$Fn17 = new ModuleMethod(this, 13, null, 8194);
                                                        lambda$Fn17.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:69");
                                                        this.lambda$Fn17 = lambda$Fn17;
                                                    }
                                                    
                                                    Object lambda31(final Object i, final Object digs) {
                                                        // 
                                                        // This method could not be decompiled.
                                                        // 
                                                        // Original Bytecode:
                                                        // 
                                                        //     4: getfield        gnu/kawa/slib/printf$frame11.staticLink:Lgnu/kawa/slib/printf$frame9;
                                                        //     7: aload_1         /* i */
                                                        //     8: bipush          45
                                                        //    10: aload_0         /* this */
                                                        //    11: getfield        gnu/kawa/slib/printf$frame12.sgn:Ljava/lang/Object;
                                                        //    14: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                                                        //    17: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
                                                        //    20: if_icmpne       46
                                                        //    23: getstatic       gnu/kawa/functions/AddOp.$Mn:Lgnu/kawa/functions/AddOp;
                                                        //    26: aload_2         /* digs */
                                                        //    27: ldc             Ljava/lang/CharSequence;.class
                                                        //    29: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                                                        //    32: dup            
                                                        //    33: astore_3       
                                                        //    34: checkcast       Ljava/lang/CharSequence;
                                                        //    37: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;)Ljava/lang/Object;
                                                        //    40: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                                                        //    43: goto            60
                                                        //    46: aload_2         /* digs */
                                                        //    47: ldc             Ljava/lang/CharSequence;.class
                                                        //    49: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                                                        //    52: dup            
                                                        //    53: astore_3       
                                                        //    54: checkcast       Ljava/lang/CharSequence;
                                                        //    57: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;)Ljava/lang/Object;
                                                        //    60: invokevirtual   gnu/kawa/slib/printf$frame10.lambda29:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                                                        //    63: areturn        
                                                        //    64: new             Lgnu/mapping/WrongType;
                                                        //    67: dup_x1         
                                                        //    68: swap           
                                                        //    69: ldc             "string->number"
                                                        //    71: iconst_1       
                                                        //    72: aload_3        
                                                        //    73: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                                                        //    76: athrow         
                                                        //    77: new             Lgnu/mapping/WrongType;
                                                        //    80: dup_x1         
                                                        //    81: swap           
                                                        //    82: ldc             "string->number"
                                                        //    84: iconst_1       
                                                        //    85: aload_3        
                                                        //    86: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                                                        //    89: athrow         
                                                        //    Exceptions:
                                                        //  Try           Handler
                                                        //  Start  End    Start  End    Type                          
                                                        //  -----  -----  -----  -----  ------------------------------
                                                        //  34     37     64     77     Ljava/lang/ClassCastException;
                                                        //  54     57     77     90     Ljava/lang/ClassCastException;
                                                        // 
                                                        // The error that occurred was:
                                                        // 
                                                        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0060:
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
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
                                                    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                                                        if (moduleMethod.selector == 13) {
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
                                                    public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                                                        if (method.selector == 13) {
                                                            return this.lambda31(o, o2);
                                                        }
                                                        return super.apply2(method, o, o2);
                                                    }
                                                }
                                                final printf$frame12 printf$frame12 = new printf$frame12();
                                                printf$frame12.staticLink = this;
                                                final printf$frame12 $heapFrame = printf$frame12;
                                                $heapFrame.sgn = sgn;
                                                return this.staticLink.staticLink.staticLink.staticLink.lambda24digits(this.staticLink.staticLink.staticLink.staticLink.n, i, $heapFrame.lambda$Fn17);
                                            }
                                            
                                            @Override
                                            public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                                                if (moduleMethod.selector == 14) {
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
                                            public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                                                if (method.selector == 14) {
                                                    return this.lambda30(o, o2);
                                                }
                                                return super.apply2(method, o, o2);
                                            }
                                        }
                                        public class printf$frame10 extends ModuleBody
                                        {
                                            Object fdigs;
                                            printf$frame9 staticLink;
                                            
                                            Object lambda29(final Object i, final Object ex) {
                                                // 
                                                // This method could not be decompiled.
                                                // 
                                                // Original Bytecode:
                                                // 
                                                //     4: dup            
                                                //     5: iconst_0       
                                                //     6: ldc             "0"
                                                //     8: aastore        
                                                //     9: dup            
                                                //    10: iconst_1       
                                                //    11: aload_0         /* this */
                                                //    12: getfield        gnu/kawa/slib/printf$frame10.staticLink:Lgnu/kawa/slib/printf$frame9;
                                                //    15: getfield        gnu/kawa/slib/printf$frame9.idigs:Ljava/lang/Object;
                                                //    18: aastore        
                                                //    19: dup            
                                                //    20: iconst_2       
                                                //    21: aload_0         /* this */
                                                //    22: getfield        gnu/kawa/slib/printf$frame10.fdigs:Ljava/lang/Object;
                                                //    25: aastore        
                                                //    26: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
                                                //    29: astore_3        /* digs */
                                                //    30: aload_3         /* digs */
                                                //    31: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                                                //    34: istore          ndigs
                                                //    36: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                                                //    39: iconst_1       
                                                //    40: aload_2         /* ex */
                                                //    41: aload_0         /* this */
                                                //    42: getfield        gnu/kawa/slib/printf$frame10.staticLink:Lgnu/kawa/slib/printf$frame9;
                                                //    45: getfield        gnu/kawa/slib/printf$frame9.idigs:Ljava/lang/Object;
                                                //    48: ldc             Ljava/lang/CharSequence;.class
                                                //    50: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                                                //    53: dup            
                                                //    54: astore          5
                                                //    56: checkcast       Ljava/lang/CharSequence;
                                                //    59: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                                                //    62: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                                                //    65: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                                                //    68: astore          6
                                                //    70: astore          j
                                                //    72: aload           j
                                                //    74: iload           ndigs
                                                //    76: i2l            
                                                //    77: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
                                                //    80: iflt            118
                                                //    83: aload_0         /* this */
                                                //    84: getfield        gnu/kawa/slib/printf$frame10.staticLink:Lgnu/kawa/slib/printf$frame9;
                                                //    87: getfield        gnu/kawa/slib/printf$frame9.staticLink:Lgnu/kawa/slib/printf$frame8;
                                                //    90: getfield        gnu/kawa/slib/printf$frame8.staticLink:Lgnu/kawa/slib/printf$frame7;
                                                //    93: getfield        gnu/kawa/slib/printf$frame7.cont:Lgnu/mapping/Procedure;
                                                //    96: aload_1         /* i */
                                                //    97: aload_0         /* this */
                                                //    98: getfield        gnu/kawa/slib/printf$frame10.staticLink:Lgnu/kawa/slib/printf$frame9;
                                                //   101: getfield        gnu/kawa/slib/printf$frame9.staticLink:Lgnu/kawa/slib/printf$frame8;
                                                //   104: getfield        gnu/kawa/slib/printf$frame8.sgn:Ljava/lang/Object;
                                                //   107: ldc             "0"
                                                //   109: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                                                //   112: invokevirtual   gnu/mapping/Procedure.apply4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                                                //   115: goto            195
                                                //   118: bipush          48
                                                //   120: aload_3         /* digs */
                                                //   121: aload           j
                                                //   123: dup            
                                                //   124: astore          7
                                                //   126: invokevirtual   java/lang/Number.intValue:()I
                                                //   129: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                                                //   132: if_icmpne       153
                                                //   135: aload           j
                                                //   137: iconst_1       
                                                //   138: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
                                                //   141: iconst_m1      
                                                //   142: aload           ex
                                                //   144: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                                                //   147: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                                                //   150: goto            68
                                                //   153: aload_0         /* this */
                                                //   154: getfield        gnu/kawa/slib/printf$frame10.staticLink:Lgnu/kawa/slib/printf$frame9;
                                                //   157: getfield        gnu/kawa/slib/printf$frame9.staticLink:Lgnu/kawa/slib/printf$frame8;
                                                //   160: getfield        gnu/kawa/slib/printf$frame8.staticLink:Lgnu/kawa/slib/printf$frame7;
                                                //   163: getfield        gnu/kawa/slib/printf$frame7.cont:Lgnu/mapping/Procedure;
                                                //   166: aload_1         /* i */
                                                //   167: aload_0         /* this */
                                                //   168: getfield        gnu/kawa/slib/printf$frame10.staticLink:Lgnu/kawa/slib/printf$frame9;
                                                //   171: getfield        gnu/kawa/slib/printf$frame9.staticLink:Lgnu/kawa/slib/printf$frame8;
                                                //   174: getfield        gnu/kawa/slib/printf$frame8.sgn:Ljava/lang/Object;
                                                //   177: aload_3         /* digs */
                                                //   178: aload           j
                                                //   180: invokevirtual   java/lang/Number.intValue:()I
                                                //   183: iconst_1       
                                                //   184: isub           
                                                //   185: iload           ndigs
                                                //   187: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                                                //   190: aload           ex
                                                //   192: invokevirtual   gnu/mapping/Procedure.apply4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                                                //   195: areturn        
                                                //   196: new             Lgnu/mapping/WrongType;
                                                //   199: dup_x1         
                                                //   200: swap           
                                                //   201: ldc             "string-length"
                                                //   203: iconst_1       
                                                //   204: aload           5
                                                //   206: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                                                //   209: athrow         
                                                //   210: new             Lgnu/mapping/WrongType;
                                                //   213: dup_x1         
                                                //   214: swap           
                                                //   215: ldc             "string-ref"
                                                //   217: iconst_2       
                                                //   218: aload           7
                                                //   220: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                                                //   223: athrow         
                                                //    Exceptions:
                                                //  Try           Handler
                                                //  Start  End    Start  End    Type                          
                                                //  -----  -----  -----  -----  ------------------------------
                                                //  56     59     196    210    Ljava/lang/ClassCastException;
                                                //  126    129    210    224    Ljava/lang/ClassCastException;
                                                // 
                                                // The error that occurred was:
                                                // 
                                                // java.lang.NullPointerException
                                                // 
                                                throw new IllegalStateException("An error occurred while decompiling this method.");
                                            }
                                        }
                                        // 
                                        // This method could not be decompiled.
                                        // 
                                        // Original Bytecode:
                                        // 
                                        //     4: invokespecial   gnu/kawa/slib/printf$frame10.<init>:()V
                                        //     7: dup            
                                        //     8: aload_0         /* this */
                                        //     9: putfield        gnu/kawa/slib/printf$frame10.staticLink:Lgnu/kawa/slib/printf$frame9;
                                        //    12: astore_3        /* $heapFrame */
                                        //    13: aload_3         /* $heapFrame */
                                        //    14: aload_2         /* fdigs */
                                        //    15: putfield        gnu/kawa/slib/printf$frame10.fdigs:Ljava/lang/Object;
                                        //    18: aload_1         /* i */
                                        //    19: astore          i
                                        //    21: new             Lgnu/kawa/slib/printf$frame11;
                                        //    24: dup            
                                        //    25: invokespecial   gnu/kawa/slib/printf$frame11.<init>:()V
                                        //    28: dup            
                                        //    29: aload_0         /* this */
                                        //    30: putfield        gnu/kawa/slib/printf$frame11.staticLink:Lgnu/kawa/slib/printf$frame9;
                                        //    33: astore          $heapFrame
                                        //    35: aload           i
                                        //    37: aload_0         /* this */
                                        //    38: getfield        gnu/kawa/slib/printf$frame9.staticLink:Lgnu/kawa/slib/printf$frame8;
                                        //    41: getfield        gnu/kawa/slib/printf$frame8.staticLink:Lgnu/kawa/slib/printf$frame7;
                                        //    44: getfield        gnu/kawa/slib/printf$frame7.staticLink:Lgnu/kawa/slib/printf$frame4;
                                        //    47: getfield        gnu/kawa/slib/printf$frame4.n:I
                                        //    50: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                                        //    53: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                                        //    56: ifeq            71
                                        //    59: aload_3         /* $heapFrame */
                                        //    60: aload           i
                                        //    62: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
                                        //    65: invokevirtual   gnu/kawa/slib/printf$frame10.lambda29:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                                        //    68: goto            182
                                        //    71: aload_0         /* this */
                                        //    72: getfield        gnu/kawa/slib/printf$frame9.staticLink:Lgnu/kawa/slib/printf$frame8;
                                        //    75: getfield        gnu/kawa/slib/printf$frame8.staticLink:Lgnu/kawa/slib/printf$frame7;
                                        //    78: getfield        gnu/kawa/slib/printf$frame7.staticLink:Lgnu/kawa/slib/printf$frame4;
                                        //    81: getfield        gnu/kawa/slib/printf$frame4.str:Ljava/lang/Object;
                                        //    84: ldc             Ljava/lang/CharSequence;.class
                                        //    86: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                                        //    89: dup            
                                        //    90: astore          6
                                        //    92: checkcast       Ljava/lang/CharSequence;
                                        //    95: aload           i
                                        //    97: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                                        //   100: dup            
                                        //   101: astore          6
                                        //   103: checkcast       Ljava/lang/Number;
                                        //   106: invokevirtual   java/lang/Number.intValue:()I
                                        //   109: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                                        //   112: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                                        //   115: getstatic       gnu/kawa/slib/printf.Lit66:Lgnu/lists/PairWithPosition;
                                        //   118: invokestatic    kawa/lib/lists.memv:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                                        //   121: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                                        //   124: ifeq            173
                                        //   127: aload_0         /* this */
                                        //   128: getfield        gnu/kawa/slib/printf$frame9.staticLink:Lgnu/kawa/slib/printf$frame8;
                                        //   131: getfield        gnu/kawa/slib/printf$frame8.staticLink:Lgnu/kawa/slib/printf$frame7;
                                        //   134: getfield        gnu/kawa/slib/printf$frame7.staticLink:Lgnu/kawa/slib/printf$frame4;
                                        //   137: aload_0         /* this */
                                        //   138: getfield        gnu/kawa/slib/printf$frame9.staticLink:Lgnu/kawa/slib/printf$frame8;
                                        //   141: getfield        gnu/kawa/slib/printf$frame8.staticLink:Lgnu/kawa/slib/printf$frame7;
                                        //   144: getfield        gnu/kawa/slib/printf$frame7.staticLink:Lgnu/kawa/slib/printf$frame4;
                                        //   147: getfield        gnu/kawa/slib/printf$frame4.n:I
                                        //   150: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                                        //   153: iconst_1       
                                        //   154: aload           i
                                        //   156: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                                        //   159: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                                        //   162: aload           $heapFrame
                                        //   164: getfield        gnu/kawa/slib/printf$frame11.lambda$Fn16:Lgnu/expr/ModuleMethod;
                                        //   167: invokevirtual   gnu/kawa/slib/printf$frame4.lambda23sign:(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
                                        //   170: goto            182
                                        //   173: aload_3         /* $heapFrame */
                                        //   174: aload           i
                                        //   176: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
                                        //   179: invokevirtual   gnu/kawa/slib/printf$frame10.lambda29:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                                        //   182: areturn        
                                        //   183: new             Lgnu/mapping/WrongType;
                                        //   186: dup_x1         
                                        //   187: swap           
                                        //   188: ldc             "string-ref"
                                        //   190: iconst_1       
                                        //   191: aload           6
                                        //   193: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                                        //   196: athrow         
                                        //   197: new             Lgnu/mapping/WrongType;
                                        //   200: dup_x1         
                                        //   201: swap           
                                        //   202: ldc             "string-ref"
                                        //   204: iconst_2       
                                        //   205: aload           6
                                        //   207: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                                        //   210: athrow         
                                        //    Exceptions:
                                        //  Try           Handler
                                        //  Start  End    Start  End    Type                          
                                        //  -----  -----  -----  -----  ------------------------------
                                        //  92     95     183    197    Ljava/lang/ClassCastException;
                                        //  103    109    197    211    Ljava/lang/ClassCastException;
                                        // 
                                        // The error that occurred was:
                                        // 
                                        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0173:
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
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
                                    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                                        if (moduleMethod.selector == 15) {
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
                                    public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                                        if (method.selector == 15) {
                                            return this.lambda28(o, o2);
                                        }
                                        return super.apply2(method, o, o2);
                                    }
                                }
                                // 
                                // This method could not be decompiled.
                                // 
                                // Original Bytecode:
                                // 
                                //     4: invokespecial   gnu/kawa/slib/printf$frame9.<init>:()V
                                //     7: dup            
                                //     8: aload_0         /* this */
                                //     9: putfield        gnu/kawa/slib/printf$frame9.staticLink:Lgnu/kawa/slib/printf$frame8;
                                //    12: astore_3        /* $heapFrame */
                                //    13: aload_3         /* $heapFrame */
                                //    14: aload_2         /* idigs */
                                //    15: putfield        gnu/kawa/slib/printf$frame9.idigs:Ljava/lang/Object;
                                //    18: aload_1         /* i */
                                //    19: astore          i
                                //    21: aload           i
                                //    23: aload_0         /* this */
                                //    24: getfield        gnu/kawa/slib/printf$frame8.staticLink:Lgnu/kawa/slib/printf$frame7;
                                //    27: getfield        gnu/kawa/slib/printf$frame7.staticLink:Lgnu/kawa/slib/printf$frame4;
                                //    30: getfield        gnu/kawa/slib/printf$frame4.n:I
                                //    33: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                                //    36: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
                                //    39: ifeq            128
                                //    42: bipush          46
                                //    44: aload_0         /* this */
                                //    45: getfield        gnu/kawa/slib/printf$frame8.staticLink:Lgnu/kawa/slib/printf$frame7;
                                //    48: getfield        gnu/kawa/slib/printf$frame7.staticLink:Lgnu/kawa/slib/printf$frame4;
                                //    51: getfield        gnu/kawa/slib/printf$frame4.str:Ljava/lang/Object;
                                //    54: ldc             Ljava/lang/CharSequence;.class
                                //    56: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                                //    59: dup            
                                //    60: astore          5
                                //    62: checkcast       Ljava/lang/CharSequence;
                                //    65: aload           i
                                //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                                //    70: dup            
                                //    71: astore          5
                                //    73: checkcast       Ljava/lang/Number;
                                //    76: invokevirtual   java/lang/Number.intValue:()I
                                //    79: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                                //    82: if_icmpne       128
                                //    85: iconst_1       
                                //    86: aload           i
                                //    88: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                                //    91: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                                //    94: astore          i
                                //    96: aload_0         /* this */
                                //    97: getfield        gnu/kawa/slib/printf$frame8.staticLink:Lgnu/kawa/slib/printf$frame7;
                                //   100: getfield        gnu/kawa/slib/printf$frame7.staticLink:Lgnu/kawa/slib/printf$frame4;
                                //   103: aload_0         /* this */
                                //   104: getfield        gnu/kawa/slib/printf$frame8.staticLink:Lgnu/kawa/slib/printf$frame7;
                                //   107: getfield        gnu/kawa/slib/printf$frame7.staticLink:Lgnu/kawa/slib/printf$frame4;
                                //   110: getfield        gnu/kawa/slib/printf$frame4.n:I
                                //   113: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                                //   116: aload           i
                                //   118: aload_3         /* $heapFrame */
                                //   119: getfield        gnu/kawa/slib/printf$frame9.lambda$Fn15:Lgnu/expr/ModuleMethod;
                                //   122: invokevirtual   gnu/kawa/slib/printf$frame4.lambda24digits:(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
                                //   125: goto            133
                                //   128: aload           i
                                //   130: goto            94
                                //   133: areturn        
                                //   134: new             Lgnu/mapping/WrongType;
                                //   137: dup_x1         
                                //   138: swap           
                                //   139: ldc             "string-ref"
                                //   141: iconst_1       
                                //   142: aload           5
                                //   144: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                                //   147: athrow         
                                //   148: new             Lgnu/mapping/WrongType;
                                //   151: dup_x1         
                                //   152: swap           
                                //   153: ldc             "string-ref"
                                //   155: iconst_2       
                                //   156: aload           5
                                //   158: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                                //   161: athrow         
                                //    Exceptions:
                                //  Try           Handler
                                //  Start  End    Start  End    Type                          
                                //  -----  -----  -----  -----  ------------------------------
                                //  62     65     134    148    Ljava/lang/ClassCastException;
                                //  73     79     148    162    Ljava/lang/ClassCastException;
                                // 
                                // The error that occurred was:
                                // 
                                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0094:
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
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
                            public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                                if (moduleMethod.selector == 16) {
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
                            public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                                if (method.selector == 16) {
                                    return this.lambda27(o, o2);
                                }
                                return super.apply2(method, o, o2);
                            }
                        }
                        final printf$frame8 printf$frame8 = new printf$frame8();
                        printf$frame8.staticLink = this;
                        final printf$frame8 $heapFrame = printf$frame8;
                        $heapFrame.sgn = sgn;
                        return this.staticLink.lambda24digits(this.staticLink.n, i, $heapFrame.lambda$Fn14);
                    }
                    
                    @Override
                    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                        if (moduleMethod.selector == 18) {
                            ctx.value1 = o;
                            ctx.proc = moduleMethod;
                            ctx.pc = 1;
                            return 0;
                        }
                        return super.match1(moduleMethod, o, ctx);
                    }
                    
                    @Override
                    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                        if (moduleMethod.selector == 17) {
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
                    public Object apply1(final ModuleMethod method, final Object o) {
                        if (method.selector == 18) {
                            return this.lambda25(o);
                        }
                        return super.apply1(method, o);
                    }
                    
                    @Override
                    public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                        if (method.selector == 17) {
                            return this.lambda26(o, o2);
                        }
                        return super.apply2(method, o, o2);
                    }
                }
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     3: dup            
                //     4: invokespecial   gnu/kawa/slib/printf$frame7.<init>:()V
                //     7: dup            
                //     8: aload_0         /* this */
                //     9: putfield        gnu/kawa/slib/printf$frame7.staticLink:Lgnu/kawa/slib/printf$frame4;
                //    12: astore          $heapFrame
                //    14: aload           $heapFrame
                //    16: aload_3         /* cont */
                //    17: putfield        gnu/kawa/slib/printf$frame7.cont:Lgnu/mapping/Procedure;
                //    20: aload_2         /* i */
                //    21: aload           $heapFrame
                //    23: getfield        gnu/kawa/slib/printf$frame7.lambda$Fn12:Lgnu/expr/ModuleMethod;
                //    26: astore          6
                //    28: astore          i
                //    30: aload           i
                //    32: aload_1         /* n */
                //    33: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //    36: checkcast       Ljava/lang/Number;
                //    39: invokevirtual   java/lang/Number.intValue:()I
                //    42: iconst_1       
                //    43: isub           
                //    44: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //    47: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    50: ifeq            221
                //    53: bipush          35
                //    55: aload_0         /* this */
                //    56: getfield        gnu/kawa/slib/printf$frame4.str:Ljava/lang/Object;
                //    59: ldc             Ljava/lang/CharSequence;.class
                //    61: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    64: dup            
                //    65: astore          7
                //    67: checkcast       Ljava/lang/CharSequence;
                //    70: aload           i
                //    72: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //    75: dup            
                //    76: astore          7
                //    78: checkcast       Ljava/lang/Number;
                //    81: invokevirtual   java/lang/Number.intValue:()I
                //    84: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //    87: if_icmpne       221
                //    90: aload_0         /* this */
                //    91: getfield        gnu/kawa/slib/printf$frame4.str:Ljava/lang/Object;
                //    94: ldc             Ljava/lang/CharSequence;.class
                //    96: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    99: dup            
                //   100: astore          8
                //   102: checkcast       Ljava/lang/CharSequence;
                //   105: iconst_1       
                //   106: aload           i
                //   108: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //   111: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   114: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   117: dup            
                //   118: astore          8
                //   120: checkcast       Ljava/lang/Number;
                //   123: invokevirtual   java/lang/Number.intValue:()I
                //   126: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   129: istore          tmp
                //   131: iload           tmp
                //   133: lookupswitch {
                //               46: 176
                //              100: 189
                //              101: 189
                //              105: 189
                //          default: 203
                //        }
                //   176: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   179: aload           cont
                //   181: aload           i
                //   183: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   186: goto            231
                //   189: iconst_1       
                //   190: aload           i
                //   192: getstatic       gnu/kawa/slib/printf.Lit42:Lgnu/math/IntNum;
                //   195: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   198: astore          i
                //   200: goto            30
                //   203: invokestatic    gnu/kawa/slib/printf$frame4.lambda20parseError:()Z
                //   206: ifeq            215
                //   209: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                //   212: goto            231
                //   215: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   218: goto            231
                //   221: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   224: aload           cont
                //   226: aload           i
                //   228: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   231: areturn        
                //   232: new             Lgnu/mapping/WrongType;
                //   235: dup_x1         
                //   236: swap           
                //   237: ldc             "string-ref"
                //   239: iconst_1       
                //   240: aload           7
                //   242: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   245: athrow         
                //   246: new             Lgnu/mapping/WrongType;
                //   249: dup_x1         
                //   250: swap           
                //   251: ldc             "string-ref"
                //   253: iconst_2       
                //   254: aload           7
                //   256: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   259: athrow         
                //   260: new             Lgnu/mapping/WrongType;
                //   263: dup_x1         
                //   264: swap           
                //   265: ldc             "string-ref"
                //   267: iconst_1       
                //   268: aload           8
                //   270: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   273: athrow         
                //   274: new             Lgnu/mapping/WrongType;
                //   277: dup_x1         
                //   278: swap           
                //   279: ldc             "string-ref"
                //   281: iconst_2       
                //   282: aload           8
                //   284: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   287: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  67     70     232    246    Ljava/lang/ClassCastException;
                //  78     84     246    260    Ljava/lang/ClassCastException;
                //  102    105    260    274    Ljava/lang/ClassCastException;
                //  120    126    274    288    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
            
            Object lambda18(final Object i, final Object sgn, final Object digs, final Object ex) {
                public class printf$frame5 extends ModuleBody
                {
                    Object num;
                    Object ex;
                    Object digs;
                    Object sgn;
                    printf$frame4 staticLink;
                    final ModuleMethod lambda$Fn9;
                    final ModuleMethod lambda$Fn10;
                    
                    public printf$frame5() {
                        final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 11, null, 16388);
                        lambda$Fn9.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:111");
                        this.lambda$Fn9 = lambda$Fn9;
                        final ModuleMethod lambda$Fn10 = new ModuleMethod(this, 12, null, 12291);
                        lambda$Fn10.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:123");
                        this.lambda$Fn10 = lambda$Fn10;
                    }
                    
                    Object lambda19(final Object j, final Object im$Mnsgn, final Object im$Mndigs, final Object im$Mnex) {
                        // 
                        // This method could not be decompiled.
                        // 
                        // Original Bytecode:
                        // 
                        //     2: getfield        gnu/kawa/slib/printf$frame5.staticLink:Lgnu/kawa/slib/printf$frame4;
                        //     5: getfield        gnu/kawa/slib/printf$frame4.n:I
                        //     8: iconst_1       
                        //     9: isub           
                        //    10: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                        //    13: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                        //    16: ifeq            123
                        //    19: bipush          105
                        //    21: invokestatic    java/lang/Character.toUpperCase:(I)I
                        //    24: aload_0         /* this */
                        //    25: getfield        gnu/kawa/slib/printf$frame5.staticLink:Lgnu/kawa/slib/printf$frame4;
                        //    28: getfield        gnu/kawa/slib/printf$frame4.str:Ljava/lang/Object;
                        //    31: ldc             Ljava/lang/CharSequence;.class
                        //    33: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                        //    36: dup            
                        //    37: astore          5
                        //    39: checkcast       Ljava/lang/CharSequence;
                        //    42: aload_1         /* j */
                        //    43: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                        //    46: dup            
                        //    47: astore          5
                        //    49: checkcast       Ljava/lang/Number;
                        //    52: invokevirtual   java/lang/Number.intValue:()I
                        //    55: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                        //    58: invokestatic    java/lang/Character.toUpperCase:(I)I
                        //    61: if_icmpne       123
                        //    64: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                        //    67: bipush          7
                        //    69: anewarray       Ljava/lang/Object;
                        //    72: dup            
                        //    73: iconst_0       
                        //    74: aload_0         /* this */
                        //    75: getfield        gnu/kawa/slib/printf$frame5.staticLink:Lgnu/kawa/slib/printf$frame4;
                        //    78: getfield        gnu/kawa/slib/printf$frame4.proc:Ljava/lang/Object;
                        //    81: aastore        
                        //    82: dup            
                        //    83: iconst_1       
                        //    84: aload_0         /* this */
                        //    85: getfield        gnu/kawa/slib/printf$frame5.sgn:Ljava/lang/Object;
                        //    88: aastore        
                        //    89: dup            
                        //    90: iconst_2       
                        //    91: aload_0         /* this */
                        //    92: getfield        gnu/kawa/slib/printf$frame5.digs:Ljava/lang/Object;
                        //    95: aastore        
                        //    96: dup            
                        //    97: iconst_3       
                        //    98: aload_0         /* this */
                        //    99: getfield        gnu/kawa/slib/printf$frame5.ex:Ljava/lang/Object;
                        //   102: aastore        
                        //   103: dup            
                        //   104: iconst_4       
                        //   105: aload_2         /* im$Mnsgn */
                        //   106: aastore        
                        //   107: dup            
                        //   108: iconst_5       
                        //   109: aload_3         /* im$Mndigs */
                        //   110: aastore        
                        //   111: dup            
                        //   112: bipush          6
                        //   114: aload           im$Mnex
                        //   116: aastore        
                        //   117: invokevirtual   gnu/mapping/Procedure.applyN:([Ljava/lang/Object;)Ljava/lang/Object;
                        //   120: goto            138
                        //   123: invokestatic    gnu/kawa/slib/printf$frame4.lambda20parseError:()Z
                        //   126: ifeq            135
                        //   129: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                        //   132: goto            138
                        //   135: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                        //   138: areturn        
                        //   139: new             Lgnu/mapping/WrongType;
                        //   142: dup_x1         
                        //   143: swap           
                        //   144: ldc             "string-ref"
                        //   146: iconst_1       
                        //   147: aload           5
                        //   149: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                        //   152: athrow         
                        //   153: new             Lgnu/mapping/WrongType;
                        //   156: dup_x1         
                        //   157: swap           
                        //   158: ldc             "string-ref"
                        //   160: iconst_2       
                        //   161: aload           5
                        //   163: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                        //   166: athrow         
                        //    Exceptions:
                        //  Try           Handler
                        //  Start  End    Start  End    Type                          
                        //  -----  -----  -----  -----  ------------------------------
                        //  39     42     139    153    Ljava/lang/ClassCastException;
                        //  49     55     153    167    Ljava/lang/ClassCastException;
                        // 
                        // The error that occurred was:
                        // 
                        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0123:
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
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
                    
                    Object lambda21(final Object sgn, final Object digs, final Object ex) {
                        public class printf$frame6 extends ModuleBody
                        {
                            Object ex;
                            Object digs;
                            Object sgn;
                            printf$frame5 staticLink;
                            final ModuleMethod lambda$Fn11;
                            
                            public printf$frame6() {
                                final ModuleMethod lambda$Fn11 = new ModuleMethod(this, 10, null, 12291);
                                lambda$Fn11.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:126");
                                this.lambda$Fn11 = lambda$Fn11;
                            }
                            
                            Object lambda22(final Object im$Mnsgn, final Object im$Mndigs, final Object im$Mnex) {
                                return Scheme.applyToArgs.applyN(new Object[] { this.staticLink.staticLink.proc, this.sgn, this.digs, this.ex, im$Mnsgn, im$Mndigs, im$Mnex });
                            }
                            
                            @Override
                            public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
                                if (moduleMethod.selector == 10) {
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
                            public Object apply3(final ModuleMethod method, final Object o, final Object o2, final Object o3) {
                                if (method.selector == 10) {
                                    return this.lambda22(o, o2, o3);
                                }
                                return super.apply3(method, o, o2, o3);
                            }
                        }
                        final printf$frame6 printf$frame6 = new printf$frame6();
                        printf$frame6.staticLink = this;
                        final printf$frame6 $heapFrame = printf$frame6;
                        $heapFrame.sgn = sgn;
                        $heapFrame.digs = digs;
                        $heapFrame.ex = ex;
                        final Object force = Promise.force(this.num, Number.class);
                        try {
                            return gnu.kawa.slib.printf.stdio$ClParseFloat(numbers.number$To$String(numbers.imagPart((Number)force)), $heapFrame.lambda$Fn11);
                        }
                        catch (ClassCastException ex2) {
                            throw new WrongType(ex2, "imag-part", 1, force);
                        }
                    }
                    
                    @Override
                    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
                        if (moduleMethod.selector == 12) {
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
                    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
                        if (moduleMethod.selector == 11) {
                            ctx.value1 = o;
                            ctx.value2 = o2;
                            ctx.value3 = o3;
                            ctx.value4 = o4;
                            ctx.proc = moduleMethod;
                            ctx.pc = 4;
                            return 0;
                        }
                        return super.match4(moduleMethod, o, o2, o3, o4, ctx);
                    }
                    
                    @Override
                    public void apply(final CallContext callContext) {
                        final int pc = callContext.pc;
                        ModuleMethod.applyError();
                    }
                    
                    @Override
                    public Object apply3(final ModuleMethod method, final Object o, final Object o2, final Object o3) {
                        if (method.selector == 12) {
                            return this.lambda21(o, o2, o3);
                        }
                        return super.apply3(method, o, o2, o3);
                    }
                    
                    @Override
                    public Object apply4(final ModuleMethod method, final Object o, final Object o2, final Object o3, final Object o4) {
                        if (method.selector == 11) {
                            return this.lambda19(o, o2, o3, o4);
                        }
                        return super.apply4(method, o, o2, o3, o4);
                    }
                }
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     4: invokespecial   gnu/kawa/slib/printf$frame5.<init>:()V
                //     7: dup            
                //     8: aload_0         /* this */
                //     9: putfield        gnu/kawa/slib/printf$frame5.staticLink:Lgnu/kawa/slib/printf$frame4;
                //    12: astore          $heapFrame
                //    14: aload           $heapFrame
                //    16: aload_2         /* sgn */
                //    17: putfield        gnu/kawa/slib/printf$frame5.sgn:Ljava/lang/Object;
                //    20: aload           $heapFrame
                //    22: aload_3         /* digs */
                //    23: putfield        gnu/kawa/slib/printf$frame5.digs:Ljava/lang/Object;
                //    26: aload           $heapFrame
                //    28: aload           ex
                //    30: putfield        gnu/kawa/slib/printf$frame5.ex:Ljava/lang/Object;
                //    33: aload_1         /* i */
                //    34: aload_0         /* this */
                //    35: getfield        gnu/kawa/slib/printf$frame4.n:I
                //    38: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //    41: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    44: ifeq            75
                //    47: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    50: aload_0         /* this */
                //    51: getfield        gnu/kawa/slib/printf$frame4.proc:Ljava/lang/Object;
                //    54: aload           $heapFrame
                //    56: getfield        gnu/kawa/slib/printf$frame5.sgn:Ljava/lang/Object;
                //    59: aload           $heapFrame
                //    61: getfield        gnu/kawa/slib/printf$frame5.digs:Ljava/lang/Object;
                //    64: aload           $heapFrame
                //    66: getfield        gnu/kawa/slib/printf$frame5.ex:Ljava/lang/Object;
                //    69: invokevirtual   gnu/mapping/Procedure.apply4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    72: goto            273
                //    75: aload_0         /* this */
                //    76: getfield        gnu/kawa/slib/printf$frame4.str:Ljava/lang/Object;
                //    79: ldc             Ljava/lang/CharSequence;.class
                //    81: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    84: dup            
                //    85: astore          6
                //    87: checkcast       Ljava/lang/CharSequence;
                //    90: aload_1         /* i */
                //    91: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //    94: dup            
                //    95: astore          6
                //    97: checkcast       Ljava/lang/Number;
                //   100: invokevirtual   java/lang/Number.intValue:()I
                //   103: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   106: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //   109: getstatic       gnu/kawa/slib/printf.Lit64:Lgnu/lists/PairWithPosition;
                //   112: invokestatic    kawa/lib/lists.memv:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   115: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   118: ifeq            141
                //   121: aload_0         /* this */
                //   122: aload_0         /* this */
                //   123: getfield        gnu/kawa/slib/printf$frame4.n:I
                //   126: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //   129: aload_1         /* i */
                //   130: aload           $heapFrame
                //   132: getfield        gnu/kawa/slib/printf$frame5.lambda$Fn9:Lgnu/expr/ModuleMethod;
                //   135: invokevirtual   gnu/kawa/slib/printf$frame4.lambda17real:(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
                //   138: goto            273
                //   141: aload_0         /* this */
                //   142: getfield        gnu/kawa/slib/printf$frame4.str:Ljava/lang/Object;
                //   145: ldc             Ljava/lang/CharSequence;.class
                //   147: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   150: dup            
                //   151: astore          6
                //   153: checkcast       Ljava/lang/CharSequence;
                //   156: aload_1         /* i */
                //   157: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   160: dup            
                //   161: astore          6
                //   163: checkcast       Ljava/lang/Number;
                //   166: invokevirtual   java/lang/Number.intValue:()I
                //   169: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   172: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //   175: getstatic       gnu/kawa/slib/printf.Lit65:Lgnu/text/Char;
                //   178: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   181: ifeq            270
                //   184: aload_0         /* this */
                //   185: getfield        gnu/kawa/slib/printf$frame4.str:Ljava/lang/Object;
                //   188: ldc             Ljava/lang/CharSequence;.class
                //   190: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   193: dup            
                //   194: astore          6
                //   196: checkcast       Ljava/lang/CharSequence;
                //   199: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;)Ljava/lang/Object;
                //   202: aload           $heapFrame
                //   204: swap           
                //   205: putfield        gnu/kawa/slib/printf$frame5.num:Ljava/lang/Object;
                //   208: aload           $heapFrame
                //   210: getfield        gnu/kawa/slib/printf$frame5.num:Ljava/lang/Object;
                //   213: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   216: ifeq            252
                //   219: aload           $heapFrame
                //   221: getfield        gnu/kawa/slib/printf$frame5.num:Ljava/lang/Object;
                //   224: ldc             Ljava/lang/Number;.class
                //   226: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   229: dup            
                //   230: astore          6
                //   232: checkcast       Ljava/lang/Number;
                //   235: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
                //   238: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
                //   241: aload           $heapFrame
                //   243: getfield        gnu/kawa/slib/printf$frame5.lambda$Fn10:Lgnu/expr/ModuleMethod;
                //   246: invokestatic    gnu/kawa/slib/printf.stdio$ClParseFloat:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   249: goto            273
                //   252: invokestatic    gnu/kawa/slib/printf$frame4.lambda20parseError:()Z
                //   255: ifeq            264
                //   258: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                //   261: goto            273
                //   264: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   267: goto            273
                //   270: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   273: areturn        
                //   274: new             Lgnu/mapping/WrongType;
                //   277: dup_x1         
                //   278: swap           
                //   279: ldc             "string-ref"
                //   281: iconst_1       
                //   282: aload           6
                //   284: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   287: athrow         
                //   288: new             Lgnu/mapping/WrongType;
                //   291: dup_x1         
                //   292: swap           
                //   293: ldc             "string-ref"
                //   295: iconst_2       
                //   296: aload           6
                //   298: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   301: athrow         
                //   302: new             Lgnu/mapping/WrongType;
                //   305: dup_x1         
                //   306: swap           
                //   307: ldc             "string-ref"
                //   309: iconst_1       
                //   310: aload           6
                //   312: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   315: athrow         
                //   316: new             Lgnu/mapping/WrongType;
                //   319: dup_x1         
                //   320: swap           
                //   321: ldc             "string-ref"
                //   323: iconst_2       
                //   324: aload           6
                //   326: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   329: athrow         
                //   330: new             Lgnu/mapping/WrongType;
                //   333: dup_x1         
                //   334: swap           
                //   335: ldc             "string->number"
                //   337: iconst_1       
                //   338: aload           6
                //   340: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   343: athrow         
                //   344: new             Lgnu/mapping/WrongType;
                //   347: dup_x1         
                //   348: swap           
                //   349: ldc             "real-part"
                //   351: iconst_1       
                //   352: aload           6
                //   354: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   357: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  87     90     274    288    Ljava/lang/ClassCastException;
                //  97     103    288    302    Ljava/lang/ClassCastException;
                //  153    156    302    316    Ljava/lang/ClassCastException;
                //  163    169    316    330    Ljava/lang/ClassCastException;
                //  196    199    330    344    Ljava/lang/ClassCastException;
                //  232    235    344    358    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 163 out of bounds for length 163
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
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
            
            public static boolean lambda20parseError() {
                return false;
            }
            
            public Object lambda23sign(final Object n, final Object i, final Procedure cont) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: aload_1         /* n */
                //     2: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //     5: ifeq            99
                //     8: aload_0         /* this */
                //     9: getfield        gnu/kawa/slib/printf$frame4.str:Ljava/lang/Object;
                //    12: ldc             Ljava/lang/CharSequence;.class
                //    14: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    17: dup            
                //    18: astore          5
                //    20: checkcast       Ljava/lang/CharSequence;
                //    23: aload_2         /* i */
                //    24: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //    27: dup            
                //    28: astore          5
                //    30: checkcast       Ljava/lang/Number;
                //    33: invokevirtual   java/lang/Number.intValue:()I
                //    36: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //    39: istore          c
                //    41: iload           c
                //    43: tableswitch {
                //               86: 68
                //               87: 88
                //               88: 68
                //          default: 88
                //        }
                //    68: aload_3         /* cont */
                //    69: iconst_1       
                //    70: aload_2         /* i */
                //    71: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //    74: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    77: iload           c
                //    79: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
                //    82: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    85: goto            102
                //    88: aload_3         /* cont */
                //    89: aload_2         /* i */
                //    90: getstatic       gnu/kawa/slib/printf.Lit17:Lgnu/text/Char;
                //    93: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    96: goto            102
                //    99: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
                //   102: areturn        
                //   103: new             Lgnu/mapping/WrongType;
                //   106: dup_x1         
                //   107: swap           
                //   108: ldc             "string-ref"
                //   110: iconst_1       
                //   111: aload           5
                //   113: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   116: athrow         
                //   117: new             Lgnu/mapping/WrongType;
                //   120: dup_x1         
                //   121: swap           
                //   122: ldc             "string-ref"
                //   124: iconst_2       
                //   125: aload           5
                //   127: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   130: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  20     23     103    117    Ljava/lang/ClassCastException;
                //  30     36     117    131    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0068:
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
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
            
            public Object lambda24digits(final Object n, final Object i, final Procedure cont) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: astore          j
                //     3: aload           j
                //     5: aload_1         /* n */
                //     6: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //     9: istore          x
                //    11: iload           x
                //    13: ifeq            24
                //    16: iload           x
                //    18: ifne            123
                //    21: goto            111
                //    24: aload_0         /* this */
                //    25: getfield        gnu/kawa/slib/printf$frame4.str:Ljava/lang/Object;
                //    28: ldc             Ljava/lang/CharSequence;.class
                //    30: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    33: dup            
                //    34: astore          7
                //    36: checkcast       Ljava/lang/CharSequence;
                //    39: aload           j
                //    41: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //    44: dup            
                //    45: astore          7
                //    47: checkcast       Ljava/lang/Number;
                //    50: invokevirtual   java/lang/Number.intValue:()I
                //    53: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //    56: invokestatic    kawa/lib/rnrs/unicode.isCharNumeric:(I)Z
                //    59: istore          x
                //    61: iload           x
                //    63: ifeq            74
                //    66: iload           x
                //    68: ifeq            123
                //    71: goto            111
                //    74: bipush          35
                //    76: aload_0         /* this */
                //    77: getfield        gnu/kawa/slib/printf$frame4.str:Ljava/lang/Object;
                //    80: ldc             Ljava/lang/CharSequence;.class
                //    82: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    85: dup            
                //    86: astore          7
                //    88: checkcast       Ljava/lang/CharSequence;
                //    91: aload           j
                //    93: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //    96: dup            
                //    97: astore          7
                //    99: checkcast       Ljava/lang/Number;
                //   102: invokevirtual   java/lang/Number.intValue:()I
                //   105: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   108: if_icmpne       123
                //   111: iconst_1       
                //   112: aload           j
                //   114: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //   117: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   120: goto            1
                //   123: aload_3         /* cont */
                //   124: aload           j
                //   126: aload_2         /* i */
                //   127: aload           j
                //   129: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   132: ifeq            140
                //   135: ldc             "0"
                //   137: goto            185
                //   140: aload_0         /* this */
                //   141: getfield        gnu/kawa/slib/printf$frame4.str:Ljava/lang/Object;
                //   144: ldc             Ljava/lang/CharSequence;.class
                //   146: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   149: dup            
                //   150: astore          5
                //   152: checkcast       Ljava/lang/CharSequence;
                //   155: aload_2         /* i */
                //   156: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   159: dup            
                //   160: astore          5
                //   162: checkcast       Ljava/lang/Number;
                //   165: invokevirtual   java/lang/Number.intValue:()I
                //   168: aload           j
                //   170: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   173: dup            
                //   174: astore          5
                //   176: checkcast       Ljava/lang/Number;
                //   179: invokevirtual   java/lang/Number.intValue:()I
                //   182: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //   185: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   188: areturn        
                //   189: new             Lgnu/mapping/WrongType;
                //   192: dup_x1         
                //   193: swap           
                //   194: ldc             "string-ref"
                //   196: iconst_1       
                //   197: aload           7
                //   199: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   202: athrow         
                //   203: new             Lgnu/mapping/WrongType;
                //   206: dup_x1         
                //   207: swap           
                //   208: ldc             "string-ref"
                //   210: iconst_2       
                //   211: aload           7
                //   213: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   216: athrow         
                //   217: new             Lgnu/mapping/WrongType;
                //   220: dup_x1         
                //   221: swap           
                //   222: ldc             "string-ref"
                //   224: iconst_1       
                //   225: aload           7
                //   227: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   230: athrow         
                //   231: new             Lgnu/mapping/WrongType;
                //   234: dup_x1         
                //   235: swap           
                //   236: ldc             "string-ref"
                //   238: iconst_2       
                //   239: aload           7
                //   241: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   244: athrow         
                //   245: new             Lgnu/mapping/WrongType;
                //   248: dup_x1         
                //   249: swap           
                //   250: ldc             "substring"
                //   252: iconst_1       
                //   253: aload           5
                //   255: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   258: athrow         
                //   259: new             Lgnu/mapping/WrongType;
                //   262: dup_x1         
                //   263: swap           
                //   264: ldc             "substring"
                //   266: iconst_2       
                //   267: aload           5
                //   269: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   272: athrow         
                //   273: new             Lgnu/mapping/WrongType;
                //   276: dup_x1         
                //   277: swap           
                //   278: ldc             "substring"
                //   280: iconst_3       
                //   281: aload           5
                //   283: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   286: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  36     39     189    203    Ljava/lang/ClassCastException;
                //  47     53     203    217    Ljava/lang/ClassCastException;
                //  88     91     217    231    Ljava/lang/ClassCastException;
                //  99     105    231    245    Ljava/lang/ClassCastException;
                //  152    155    245    259    Ljava/lang/ClassCastException;
                //  162    168    259    273    Ljava/lang/ClassCastException;
                //  176    182    273    287    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 139 out of bounds for length 139
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
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
            public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
                if (moduleMethod.selector == 19) {
                    ctx.value1 = o;
                    ctx.value2 = o2;
                    ctx.value3 = o3;
                    ctx.value4 = o4;
                    ctx.proc = moduleMethod;
                    ctx.pc = 4;
                    return 0;
                }
                return super.match4(moduleMethod, o, o2, o3, o4, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply4(final ModuleMethod method, final Object o, final Object o2, final Object o3, final Object o4) {
                if (method.selector == 19) {
                    return this.lambda18(o, o2, o3, o4);
                }
                return super.apply4(method, o, o2, o3, o4);
            }
        }
        final printf$frame4 $heapFrame = new printf$frame4();
        $heapFrame.str = str;
        $heapFrame.proc = proc;
        final Object force = Promise.force($heapFrame.str, CharSequence.class);
        try {
            $heapFrame.n = strings.stringLength((CharSequence)force);
            return $heapFrame.lambda17real($heapFrame.n, gnu.kawa.slib.printf.Lit13, $heapFrame.lambda$Fn8);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "string-length", 1, force);
        }
    }
    
    public static IntNum fprintf$V(final Object port, final Object format, final Object[] argsArray) {
        public class printf$frame2 extends ModuleBody
        {
            Object port;
            IntNum cnt;
            final ModuleMethod lambda$Fn6;
            
            public printf$frame2() {
                final ModuleMethod lambda$Fn6 = new ModuleMethod(this, 8, null, 4097);
                lambda$Fn6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:547");
                this.lambda$Fn6 = lambda$Fn6;
            }
            
            boolean lambda15(final Object x) {
                Label_0044: {
                    if (!strings.isString(x)) {
                        break Label_0044;
                    }
                    final IntNum cnt = this.cnt;
                    final Object force = Promise.force(x, CharSequence.class);
                    try {
                        this.cnt = IntNum.add(cnt, strings.stringLength((CharSequence)force));
                        ports.display(x, this.port);
                        return true;
                        this.cnt = IntNum.add(this.cnt, 1);
                        ports.display(x, this.port);
                        b = true;
                        return b;
                    }
                    catch (ClassCastException ex) {
                        throw new WrongType(ex, "string-length", 1, force);
                    }
                }
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 8) {
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
                if (method.selector == 8) {
                    return this.lambda15(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final printf$frame2 $heapFrame = new printf$frame2();
        $heapFrame.port = port;
        final LList args = LList.makeList(argsArray, 0);
        $heapFrame.cnt = gnu.kawa.slib.printf.Lit13;
        Scheme.apply.apply4(gnu.kawa.slib.printf.stdio$Cliprintf, $heapFrame.lambda$Fn6, format, args);
        return $heapFrame.cnt;
    }
    
    public static Object printf$V(final Object format, final Object[] argsArray) {
        final LList args = LList.makeList(argsArray, 0);
        return Scheme.apply.apply4(gnu.kawa.slib.printf.fprintf, ports.current$Mnoutput$Mnport.getValue(), format, args);
    }
    
    public static Object sprintf$V(final Object str, final Object format, final Object[] argsArray) {
        public class printf$frame3 extends ModuleBody
        {
            Object s;
            Object cnt;
            Object end;
            Object str;
            final ModuleMethod lambda$Fn7;
            
            public printf$frame3() {
                final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 9, null, 4097);
                lambda$Fn7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:565");
                this.lambda$Fn7 = lambda$Fn7;
            }
            
            boolean lambda16(final Object x) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     4: ifeq            286
                //     7: aload_0         /* this */
                //     8: getfield        gnu/kawa/slib/printf$frame3.str:Ljava/lang/Object;
                //    11: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    14: ifeq            30
                //    17: aload_0         /* this */
                //    18: getfield        gnu/kawa/slib/printf$frame3.str:Ljava/lang/Object;
                //    21: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    24: ifeq            200
                //    27: goto            65
                //    30: iconst_m1      
                //    31: aload_0         /* this */
                //    32: getfield        gnu/kawa/slib/printf$frame3.end:Ljava/lang/Object;
                //    35: aload_0         /* this */
                //    36: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //    39: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    42: aload_1         /* x */
                //    43: ldc             Ljava/lang/CharSequence;.class
                //    45: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    48: dup            
                //    49: astore_2       
                //    50: checkcast       Ljava/lang/CharSequence;
                //    53: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //    56: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //    59: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    62: ifeq            200
                //    65: iconst_2       
                //    66: anewarray       Ljava/lang/Object;
                //    69: dup            
                //    70: iconst_0       
                //    71: aload_1         /* x */
                //    72: ldc             Ljava/lang/CharSequence;.class
                //    74: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    77: dup            
                //    78: astore_2       
                //    79: checkcast       Ljava/lang/CharSequence;
                //    82: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //    85: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //    88: aastore        
                //    89: dup            
                //    90: iconst_1       
                //    91: iconst_m1      
                //    92: aload_0         /* this */
                //    93: getfield        gnu/kawa/slib/printf$frame3.end:Ljava/lang/Object;
                //    96: aload_0         /* this */
                //    97: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //   100: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   103: aastore        
                //   104: invokestatic    kawa/lib/numbers.min:([Ljava/lang/Object;)Ljava/lang/Object;
                //   107: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
                //   110: astore_3       
                //   111: astore_2        /* lend */
                //   112: aload_3         /* i */
                //   113: aload_2         /* lend */
                //   114: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   117: ifne            464
                //   120: aload_0         /* this */
                //   121: getfield        gnu/kawa/slib/printf$frame3.s:Ljava/lang/Object;
                //   124: ldc             Lgnu/lists/CharSeq;.class
                //   126: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   129: dup            
                //   130: astore          4
                //   132: checkcast       Lgnu/lists/CharSeq;
                //   135: aload_0         /* this */
                //   136: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //   139: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   142: dup            
                //   143: astore          4
                //   145: checkcast       Ljava/lang/Number;
                //   148: invokevirtual   java/lang/Number.intValue:()I
                //   151: aload_1         /* x */
                //   152: ldc             Ljava/lang/CharSequence;.class
                //   154: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   157: dup            
                //   158: astore          4
                //   160: checkcast       Ljava/lang/CharSequence;
                //   163: aload_3         /* i */
                //   164: dup            
                //   165: astore          4
                //   167: invokevirtual   java/lang/Number.intValue:()I
                //   170: invokestatic    kawa/lib/strings.stringRef:(Ljava/lang/CharSequence;I)I
                //   173: invokestatic    kawa/lib/strings.stringSet$Ex:(Lgnu/lists/CharSeq;II)V
                //   176: aload_0         /* this */
                //   177: iconst_1       
                //   178: aload_0         /* this */
                //   179: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //   182: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //   185: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   188: putfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //   191: aload_3         /* i */
                //   192: iconst_1       
                //   193: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
                //   196: astore_3        /* i */
                //   197: goto            112
                //   200: aload_0         /* this */
                //   201: iconst_2       
                //   202: anewarray       Ljava/lang/Object;
                //   205: dup            
                //   206: iconst_0       
                //   207: aload_0         /* this */
                //   208: getfield        gnu/kawa/slib/printf$frame3.s:Ljava/lang/Object;
                //   211: ldc             Ljava/lang/CharSequence;.class
                //   213: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   216: dup            
                //   217: astore_2       
                //   218: checkcast       Ljava/lang/CharSequence;
                //   221: iconst_0       
                //   222: aload_0         /* this */
                //   223: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //   226: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   229: dup            
                //   230: astore_2       
                //   231: checkcast       Ljava/lang/Number;
                //   234: invokevirtual   java/lang/Number.intValue:()I
                //   237: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
                //   240: aastore        
                //   241: dup            
                //   242: iconst_1       
                //   243: aload_1         /* x */
                //   244: aastore        
                //   245: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
                //   248: putfield        gnu/kawa/slib/printf$frame3.s:Ljava/lang/Object;
                //   251: aload_0         /* this */
                //   252: aload_0         /* this */
                //   253: getfield        gnu/kawa/slib/printf$frame3.s:Ljava/lang/Object;
                //   256: ldc             Ljava/lang/CharSequence;.class
                //   258: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   261: dup            
                //   262: astore_2       
                //   263: checkcast       Ljava/lang/CharSequence;
                //   266: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   269: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //   272: putfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //   275: aload_0         /* this */
                //   276: aload_0         /* this */
                //   277: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //   280: putfield        gnu/kawa/slib/printf$frame3.end:Ljava/lang/Object;
                //   283: goto            464
                //   286: aload_0         /* this */
                //   287: getfield        gnu/kawa/slib/printf$frame3.str:Ljava/lang/Object;
                //   290: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   293: ifeq            310
                //   296: aload_0         /* this */
                //   297: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //   300: aload_0         /* this */
                //   301: getfield        gnu/kawa/slib/printf$frame3.end:Ljava/lang/Object;
                //   304: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   307: goto            311
                //   310: iconst_0       
                //   311: istore_2        /* x */
                //   312: iload_2         /* x */
                //   313: ifeq            319
                //   316: goto            464
                //   319: aload_0         /* this */
                //   320: getfield        gnu/kawa/slib/printf$frame3.str:Ljava/lang/Object;
                //   323: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   326: ifne            396
                //   329: aload_0         /* this */
                //   330: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //   333: aload_0         /* this */
                //   334: getfield        gnu/kawa/slib/printf$frame3.end:Ljava/lang/Object;
                //   337: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   340: ifeq            396
                //   343: aload_0         /* this */
                //   344: iconst_2       
                //   345: anewarray       Ljava/lang/Object;
                //   348: dup            
                //   349: iconst_0       
                //   350: aload_0         /* this */
                //   351: getfield        gnu/kawa/slib/printf$frame3.s:Ljava/lang/Object;
                //   354: aastore        
                //   355: dup            
                //   356: iconst_1       
                //   357: bipush          100
                //   359: invokestatic    kawa/lib/strings.makeString:(I)Lgnu/lists/FString;
                //   362: aastore        
                //   363: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
                //   366: putfield        gnu/kawa/slib/printf$frame3.s:Ljava/lang/Object;
                //   369: aload_0         /* this */
                //   370: aload_0         /* this */
                //   371: getfield        gnu/kawa/slib/printf$frame3.s:Ljava/lang/Object;
                //   374: ldc             Ljava/lang/CharSequence;.class
                //   376: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   379: dup            
                //   380: astore_3       
                //   381: checkcast       Ljava/lang/CharSequence;
                //   384: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
                //   387: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //   390: putfield        gnu/kawa/slib/printf$frame3.end:Ljava/lang/Object;
                //   393: goto            396
                //   396: aload_0         /* this */
                //   397: getfield        gnu/kawa/slib/printf$frame3.s:Ljava/lang/Object;
                //   400: ldc             Lgnu/lists/CharSeq;.class
                //   402: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   405: dup            
                //   406: astore_3       
                //   407: checkcast       Lgnu/lists/CharSeq;
                //   410: aload_0         /* this */
                //   411: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //   414: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   417: dup            
                //   418: astore_3       
                //   419: checkcast       Ljava/lang/Number;
                //   422: invokevirtual   java/lang/Number.intValue:()I
                //   425: aload_1         /* x */
                //   426: invokestatic    kawa/lib/characters.isChar:(Ljava/lang/Object;)Z
                //   429: ifeq            444
                //   432: aload_1         /* x */
                //   433: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
                //   436: dup            
                //   437: astore_3       
                //   438: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
                //   441: goto            446
                //   444: bipush          63
                //   446: invokestatic    kawa/lib/strings.stringSet$Ex:(Lgnu/lists/CharSeq;II)V
                //   449: aload_0         /* this */
                //   450: iconst_1       
                //   451: aload_0         /* this */
                //   452: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //   455: getstatic       gnu/kawa/slib/printf.Lit49:Lgnu/math/IntNum;
                //   458: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   461: putfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //   464: aload_0         /* this */
                //   465: getfield        gnu/kawa/slib/printf$frame3.str:Ljava/lang/Object;
                //   468: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   471: ifeq            492
                //   474: aload_0         /* this */
                //   475: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
                //   478: aload_0         /* this */
                //   479: getfield        gnu/kawa/slib/printf$frame3.end:Ljava/lang/Object;
                //   482: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   485: ifeq            492
                //   488: iconst_0       
                //   489: goto            493
                //   492: iconst_1       
                //   493: ireturn        
                //   494: new             Lgnu/mapping/WrongType;
                //   497: dup_x1         
                //   498: swap           
                //   499: ldc             "string-length"
                //   501: iconst_1       
                //   502: aload_2        
                //   503: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   506: athrow         
                //   507: new             Lgnu/mapping/WrongType;
                //   510: dup_x1         
                //   511: swap           
                //   512: ldc             "string-length"
                //   514: iconst_1       
                //   515: aload_2        
                //   516: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   519: athrow         
                //   520: new             Lgnu/mapping/WrongType;
                //   523: dup_x1         
                //   524: swap           
                //   525: ldc             "string-set!"
                //   527: iconst_1       
                //   528: aload           4
                //   530: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   533: athrow         
                //   534: new             Lgnu/mapping/WrongType;
                //   537: dup_x1         
                //   538: swap           
                //   539: ldc             "string-set!"
                //   541: iconst_2       
                //   542: aload           4
                //   544: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   547: athrow         
                //   548: new             Lgnu/mapping/WrongType;
                //   551: dup_x1         
                //   552: swap           
                //   553: ldc             "string-ref"
                //   555: iconst_1       
                //   556: aload           4
                //   558: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   561: athrow         
                //   562: new             Lgnu/mapping/WrongType;
                //   565: dup_x1         
                //   566: swap           
                //   567: ldc             "string-ref"
                //   569: iconst_2       
                //   570: aload           4
                //   572: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   575: athrow         
                //   576: new             Lgnu/mapping/WrongType;
                //   579: dup_x1         
                //   580: swap           
                //   581: ldc             "substring"
                //   583: iconst_1       
                //   584: aload_2        
                //   585: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   588: athrow         
                //   589: new             Lgnu/mapping/WrongType;
                //   592: dup_x1         
                //   593: swap           
                //   594: ldc             "substring"
                //   596: iconst_3       
                //   597: aload_2        
                //   598: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   601: athrow         
                //   602: new             Lgnu/mapping/WrongType;
                //   605: dup_x1         
                //   606: swap           
                //   607: ldc             "string-length"
                //   609: iconst_1       
                //   610: aload_2        
                //   611: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   614: athrow         
                //   615: new             Lgnu/mapping/WrongType;
                //   618: dup_x1         
                //   619: swap           
                //   620: ldc             "string-length"
                //   622: iconst_1       
                //   623: aload_3        
                //   624: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   627: athrow         
                //   628: new             Lgnu/mapping/WrongType;
                //   631: dup_x1         
                //   632: swap           
                //   633: ldc             "string-set!"
                //   635: iconst_1       
                //   636: aload_3        
                //   637: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   640: athrow         
                //   641: new             Lgnu/mapping/WrongType;
                //   644: dup_x1         
                //   645: swap           
                //   646: ldc             "string-set!"
                //   648: iconst_2       
                //   649: aload_3        
                //   650: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   653: athrow         
                //   654: new             Lgnu/mapping/WrongType;
                //   657: dup_x1         
                //   658: swap           
                //   659: ldc             "string-set!"
                //   661: iconst_3       
                //   662: aload_3        
                //   663: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   666: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  50     53     494    507    Ljava/lang/ClassCastException;
                //  79     82     507    520    Ljava/lang/ClassCastException;
                //  132    135    520    534    Ljava/lang/ClassCastException;
                //  145    151    534    548    Ljava/lang/ClassCastException;
                //  160    163    548    562    Ljava/lang/ClassCastException;
                //  167    170    562    576    Ljava/lang/ClassCastException;
                //  218    221    576    589    Ljava/lang/ClassCastException;
                //  231    237    589    602    Ljava/lang/ClassCastException;
                //  263    266    602    615    Ljava/lang/ClassCastException;
                //  381    384    615    628    Ljava/lang/ClassCastException;
                //  407    410    628    641    Ljava/lang/ClassCastException;
                //  419    425    641    654    Ljava/lang/ClassCastException;
                //  438    441    654    667    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 342 out of bounds for length 342
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
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
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
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 9) {
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
                if (method.selector == 9) {
                    return this.lambda16(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/slib/printf$frame3.<init>:()V
        //     7: astore          $heapFrame
        //     9: aload           $heapFrame
        //    11: aload_0         /* str */
        //    12: putfield        gnu/kawa/slib/printf$frame3.str:Ljava/lang/Object;
        //    15: aload_2         /* argsArray */
        //    16: iconst_0       
        //    17: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //    20: dup            
        //    21: astore          5
        //    23: astore_3        /* args */
        //    24: getstatic       gnu/kawa/slib/printf.Lit13:Lgnu/math/IntNum;
        //    27: aload           $heapFrame
        //    29: swap           
        //    30: putfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
        //    33: aload           $heapFrame
        //    35: getfield        gnu/kawa/slib/printf$frame3.str:Ljava/lang/Object;
        //    38: invokestatic    kawa/lib/strings.isString:(Ljava/lang/Object;)Z
        //    41: ifeq            52
        //    44: aload           $heapFrame
        //    46: getfield        gnu/kawa/slib/printf$frame3.str:Ljava/lang/Object;
        //    49: goto            136
        //    52: aload           $heapFrame
        //    54: getfield        gnu/kawa/slib/printf$frame3.str:Ljava/lang/Object;
        //    57: invokestatic    kawa/lib/numbers.isNumber:(Ljava/lang/Object;)Z
        //    60: ifeq            86
        //    63: aload           $heapFrame
        //    65: getfield        gnu/kawa/slib/printf$frame3.str:Ljava/lang/Object;
        //    68: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    71: dup            
        //    72: astore          5
        //    74: checkcast       Ljava/lang/Number;
        //    77: invokevirtual   java/lang/Number.intValue:()I
        //    80: invokestatic    kawa/lib/strings.makeString:(I)Lgnu/lists/FString;
        //    83: goto            136
        //    86: aload           $heapFrame
        //    88: getfield        gnu/kawa/slib/printf$frame3.str:Ljava/lang/Object;
        //    91: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    94: ifne            105
        //    97: bipush          100
        //    99: invokestatic    kawa/lib/strings.makeString:(I)Lgnu/lists/FString;
        //   102: goto            136
        //   105: iconst_3       
        //   106: anewarray       Ljava/lang/Object;
        //   109: dup            
        //   110: iconst_0       
        //   111: getstatic       gnu/kawa/slib/printf.Lit63:Lgnu/mapping/SimpleSymbol;
        //   114: aastore        
        //   115: dup            
        //   116: iconst_1       
        //   117: ldc_w           "first argument not understood"
        //   120: aastore        
        //   121: dup            
        //   122: iconst_2       
        //   123: aload           $heapFrame
        //   125: getfield        gnu/kawa/slib/printf$frame3.str:Ljava/lang/Object;
        //   128: aastore        
        //   129: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   132: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   135: athrow         
        //   136: aload           $heapFrame
        //   138: swap           
        //   139: putfield        gnu/kawa/slib/printf$frame3.s:Ljava/lang/Object;
        //   142: aload           $heapFrame
        //   144: getfield        gnu/kawa/slib/printf$frame3.s:Ljava/lang/Object;
        //   147: ldc             Ljava/lang/CharSequence;.class
        //   149: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   152: dup            
        //   153: astore          5
        //   155: checkcast       Ljava/lang/CharSequence;
        //   158: invokestatic    kawa/lib/strings.stringLength:(Ljava/lang/CharSequence;)I
        //   161: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   164: aload           $heapFrame
        //   166: swap           
        //   167: putfield        gnu/kawa/slib/printf$frame3.end:Ljava/lang/Object;
        //   170: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //   173: getstatic       gnu/kawa/slib/printf.stdio$Cliprintf:Lgnu/expr/ModuleMethod;
        //   176: aload           $heapFrame
        //   178: getfield        gnu/kawa/slib/printf$frame3.lambda$Fn7:Lgnu/expr/ModuleMethod;
        //   181: aload_1         /* format */
        //   182: aload_3         /* args */
        //   183: invokevirtual   gnu/mapping/Procedure.apply4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   186: pop            
        //   187: aload           $heapFrame
        //   189: getfield        gnu/kawa/slib/printf$frame3.str:Ljava/lang/Object;
        //   192: invokestatic    kawa/lib/strings.isString:(Ljava/lang/Object;)Z
        //   195: ifeq            206
        //   198: aload           $heapFrame
        //   200: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
        //   203: goto            267
        //   206: aload           $heapFrame
        //   208: getfield        gnu/kawa/slib/printf$frame3.end:Ljava/lang/Object;
        //   211: aload           $heapFrame
        //   213: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
        //   216: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   219: ifeq            230
        //   222: aload           $heapFrame
        //   224: getfield        gnu/kawa/slib/printf$frame3.s:Ljava/lang/Object;
        //   227: goto            267
        //   230: aload           $heapFrame
        //   232: getfield        gnu/kawa/slib/printf$frame3.s:Ljava/lang/Object;
        //   235: ldc             Ljava/lang/CharSequence;.class
        //   237: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   240: dup            
        //   241: astore          5
        //   243: checkcast       Ljava/lang/CharSequence;
        //   246: iconst_0       
        //   247: aload           $heapFrame
        //   249: getfield        gnu/kawa/slib/printf$frame3.cnt:Ljava/lang/Object;
        //   252: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   255: dup            
        //   256: astore          5
        //   258: checkcast       Ljava/lang/Number;
        //   261: invokevirtual   java/lang/Number.intValue:()I
        //   264: invokestatic    kawa/lib/strings.substring:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   267: areturn        
        //   268: new             Lgnu/mapping/WrongType;
        //   271: dup_x1         
        //   272: swap           
        //   273: ldc_w           "make-string"
        //   276: iconst_1       
        //   277: aload           5
        //   279: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   282: athrow         
        //   283: new             Lgnu/mapping/WrongType;
        //   286: dup_x1         
        //   287: swap           
        //   288: ldc             "string-length"
        //   290: iconst_1       
        //   291: aload           5
        //   293: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   296: athrow         
        //   297: new             Lgnu/mapping/WrongType;
        //   300: dup_x1         
        //   301: swap           
        //   302: ldc_w           "substring"
        //   305: iconst_1       
        //   306: aload           5
        //   308: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   311: athrow         
        //   312: new             Lgnu/mapping/WrongType;
        //   315: dup_x1         
        //   316: swap           
        //   317: ldc_w           "substring"
        //   320: iconst_3       
        //   321: aload           5
        //   323: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   326: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  74     80     268    283    Ljava/lang/ClassCastException;
        //  155    158    283    297    Ljava/lang/ClassCastException;
        //  243    246    297    312    Ljava/lang/ClassCastException;
        //  258    264    312    327    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 150 out of bounds for length 150
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
    
    static {
        Lit70 = Symbol.valueOf("fprintf");
        Lit69 = Symbol.valueOf("stdio:iprintf");
        Lit68 = IntNum.valueOf(9);
        Lit67 = IntNum.valueOf(5);
        Lit66 = PairWithPosition.make(Lit40 = Char.valueOf(101), PairWithPosition.make(Lit58 = Char.valueOf(115), PairWithPosition.make(Lit3 = Char.valueOf(102), PairWithPosition.make(Lit39 = Char.valueOf(100), PairWithPosition.make(Lit21 = Char.valueOf(108), PairWithPosition.make(Lit26 = Char.valueOf(69), PairWithPosition.make(Lit35 = Char.valueOf(83), PairWithPosition.make(Lit5 = Char.valueOf(70), PairWithPosition.make(Lit25 = Char.valueOf(68), PairWithPosition.make(Lit20 = Char.valueOf(76), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266284), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266280), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266276), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266272), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266268), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266264), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266260), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266256), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266252), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266247);
        Lit65 = Char.valueOf(64);
        Lit64 = PairWithPosition.make(Lit17 = Char.valueOf(43), PairWithPosition.make(Lit18 = Char.valueOf(45), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 446503), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 446498);
        Lit63 = Symbol.valueOf("sprintf");
        Lit62 = Symbol.valueOf("pad");
        Lit61 = Char.valueOf(42);
        Lit60 = Char.valueOf(63);
        Lit59 = Char.valueOf(120);
        Lit57 = Char.valueOf(117);
        Lit56 = Char.valueOf(105);
        Lit55 = Symbol.valueOf("format-real");
        Lit54 = PairWithPosition.make("i", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1638411);
        Lit53 = FVector.make("y", "z", "a", "f", "p", "n", "u", "m", "", "k", "M", "G", "T", "P", "E", "Z", "Y");
        Lit52 = IntNum.valueOf(3);
        Lit51 = IntNum.valueOf(10);
        Lit50 = IntNum.valueOf(-10);
        Lit49 = IntNum.valueOf(1);
        Lit48 = IntNum.valueOf(6);
        Lit47 = Char.valueOf(107);
        Lit46 = IntNum.valueOf(8);
        Lit45 = Char.valueOf(111);
        Lit44 = Char.valueOf(97);
        Lit43 = Char.valueOf(99);
        Lit42 = IntNum.valueOf(2);
        Lit41 = Char.valueOf(98);
        Lit38 = Char.valueOf(103);
        Lit37 = IntNum.valueOf(16);
        Lit36 = Char.valueOf(88);
        Lit34 = Char.valueOf(85);
        Lit33 = Char.valueOf(75);
        Lit32 = Char.valueOf(73);
        Lit31 = Char.valueOf(79);
        Lit30 = Char.valueOf(67);
        Lit29 = Char.valueOf(66);
        Lit28 = Char.valueOf(65);
        Lit27 = Char.valueOf(71);
        Lit24 = Symbol.valueOf("printf");
        Lit23 = PairWithPosition.make(gnu.kawa.slib.printf.Lit43, PairWithPosition.make(gnu.kawa.slib.printf.Lit58, PairWithPosition.make(gnu.kawa.slib.printf.Lit44, PairWithPosition.make(gnu.kawa.slib.printf.Lit39, PairWithPosition.make(gnu.kawa.slib.printf.Lit56, PairWithPosition.make(gnu.kawa.slib.printf.Lit57, PairWithPosition.make(gnu.kawa.slib.printf.Lit45, PairWithPosition.make(gnu.kawa.slib.printf.Lit59, PairWithPosition.make(gnu.kawa.slib.printf.Lit41, PairWithPosition.make(gnu.kawa.slib.printf.Lit3, PairWithPosition.make(gnu.kawa.slib.printf.Lit40, PairWithPosition.make(gnu.kawa.slib.printf.Lit38, PairWithPosition.make(gnu.kawa.slib.printf.Lit47, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1785876), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1785872), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1785868), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1785864), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781800), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781796), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781792), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781788), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781784), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781780), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781776), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781772), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781767);
        Lit22 = Char.valueOf(104);
        Lit19 = Char.valueOf(46);
        Lit16 = Char.valueOf(48);
        Lit15 = Char.valueOf(32);
        Lit14 = Char.valueOf(35);
        Lit13 = IntNum.valueOf(0);
        Lit12 = Char.valueOf(37);
        Lit11 = Char.valueOf(78);
        Lit10 = Char.valueOf(10);
        Lit9 = Char.valueOf(110);
        Lit8 = Char.valueOf(9);
        Lit7 = Char.valueOf(116);
        Lit6 = Char.valueOf(12);
        Lit4 = Char.valueOf(84);
        Lit2 = Char.valueOf(92);
        Lit1 = IntNum.valueOf(-1);
        Lit0 = IntNum.valueOf(-15);
        gnu.kawa.slib.printf.$instance = new printf();
        final printf $instance = gnu.kawa.slib.printf.$instance;
        stdio$Cliprintf = new ModuleMethod($instance, 20, gnu.kawa.slib.printf.Lit69, -4094);
        fprintf = new ModuleMethod($instance, 21, gnu.kawa.slib.printf.Lit70, -4094);
        printf = new ModuleMethod($instance, 22, gnu.kawa.slib.printf.Lit24, -4095);
        sprintf = new ModuleMethod($instance, 23, gnu.kawa.slib.printf.Lit63, -4094);
        $runBody$();
    }
    
    public printf() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        switch (proc.selector) {
            case 23: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 22: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 21: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 20: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            default: {
                return super.matchN(proc, args, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] args) {
        switch (method.selector) {
            case 20: {
                final Object out = args[0];
                final Object formatString = args[1];
                int n = args.length - 2;
                final Object[] argsArray = new Object[n];
                while (--n >= 0) {
                    argsArray[n] = args[n + 2];
                }
                return stdio$ClIprintf$V(out, formatString, argsArray);
            }
            case 21: {
                final Object port = args[0];
                final Object format = args[1];
                int n2 = args.length - 2;
                final Object[] argsArray2 = new Object[n2];
                while (--n2 >= 0) {
                    argsArray2[n2] = args[n2 + 2];
                }
                return fprintf$V(port, format, argsArray2);
            }
            case 22: {
                final Object format2 = args[0];
                int n3 = args.length - 1;
                final Object[] argsArray3 = new Object[n3];
                while (--n3 >= 0) {
                    argsArray3[n3] = args[n3 + 1];
                }
                return printf$V(format2, argsArray3);
            }
            case 23: {
                final Object str = args[0];
                final Object format3 = args[1];
                int n4 = args.length - 2;
                final Object[] argsArray4 = new Object[n4];
                while (--n4 >= 0) {
                    argsArray4[n4] = args[n4 + 2];
                }
                return sprintf$V(str, format3, argsArray4);
            }
            default: {
                return super.applyN(method, args);
            }
        }
    }
}
