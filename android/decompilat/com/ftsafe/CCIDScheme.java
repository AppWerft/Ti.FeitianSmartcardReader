// 
// Decompiled by Procyon v0.5.36
// 

package com.ftsafe;

import kawa.standard.syntax_case;
import kawa.lang.TemplateScope;
import gnu.bytecode.ClassType;
import gnu.mapping.Symbol;
import gnu.bytecode.Type;
import gnu.kawa.functions.MultiplyOp;
import java.io.Serializable;
import gnu.kawa.functions.DivideOp;
import gnu.math.BitOps;
import java.io.Externalizable;
import gnu.lists.FString;
import kawa.lib.misc;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.slib.srfi60;
import java.util.Iterator;
import gnu.text.Char;
import kawa.lib.strings;
import kawa.lib.numbers;
import gnu.lists.Sequences;
import gnu.kawa.io.BinaryInPort;
import java.io.Closeable;
import gnu.lists.EofClass;
import kawa.lib.ports;
import gnu.kawa.functions.NumberCompare;
import kawa.standard.append;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.BitwiseOp;
import gnu.kawa.functions.Format;
import gnu.lists.U8Vector;
import gnu.lists.Consumer;
import gnu.lists.LList;
import android.util.Log;
import gnu.expr.Special;
import kawa.lib.exceptions;
import gnu.expr.KawaConvert;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Pair;
import gnu.mapping.WrongType;
import kawa.standard.Scheme;
import kawa.lib.rnrs.hashtables;
import kawa.lib.lists;
import gnu.mapping.Promise;
import kawa.lib.kawa.hashtable;
import gnu.mapping.CallContext;
import gnu.expr.ModuleBody;
import gnu.mapping.Values;
import kawa.lang.SyntaxTemplate;
import kawa.lang.SyntaxPattern;
import gnu.math.DFloNum;
import gnu.lists.PairWithPosition;
import gnu.mapping.SimpleSymbol;
import gnu.expr.Keyword;
import gnu.math.IntNum;
import gnu.bytecode.ArrayType;
import gnu.kawa.lispexpr.ClassNamespace;
import kawa.lang.Macro;
import gnu.mapping.Procedure;
import gnu.expr.ModuleMethod;
import android.os.Handler;
import com.ftsafe.readerScheme.FTReaderInf;

public class CCIDScheme
{
    public FTReaderInf mFTReaderInf;
    public Handler mHandler;
    public static final ModuleMethod list$Mn$Gru8vector;
    public static final ModuleMethod u8vector$Mn$Grlist;
    public static final ModuleMethod make$Mnu8vector;
    public static final ModuleMethod object$Mn$Grstring;
    public static final ModuleMethod slice;
    public static final ModuleMethod build$Mndword$Mnfromlst;
    public static final ModuleMethod build$Mndword$Mninlst;
    public static final ModuleMethod build$Mnword$Mnfromlst;
    public static final ModuleMethod build$Mnword$Mninlst;
    public static final ModuleMethod make$Mncounter;
    public static final ModuleMethod make$Mncontainer;
    public static final ModuleMethod to$Mnlist;
    public static final ModuleMethod read$Mnu8s;
    public static final ModuleMethod call$Mnwith$Mninput$Mnu8vector;
    public static Procedure pp;
    public static final ModuleMethod subu8list;
    public static final ModuleMethod group$Mnlist;
    public static final ModuleMethod filter;
    public static final ModuleMethod assoc$MnEX;
    public static final ModuleMethod list$Mnxor;
    public static final ModuleMethod to$MnhexStr;
    public static final ModuleMethod to$MnoctStr;
    public static final ModuleMethod to$MnbinStr;
    public static final ModuleMethod u8list$Mn$Grstring;
    public static final ModuleMethod in$Mnlist$Qu;
    public static final ModuleMethod byte$Mn$Grbit;
    public static final ModuleMethod list$Mnremove$Mnduplication;
    public static final ModuleMethod float$Mn$Grinteger;
    public static final ModuleMethod stringlst$Mn$Grstring;
    public static final ModuleMethod alist$Mn$Grlist;
    public static final ModuleMethod get$Mnconfiguration$Mndescriptor;
    public static final ModuleMethod get$Mnstring$Mndescriptor;
    public static final ModuleMethod get$Mndevice$Mndescriptor;
    public static Object descriptor$Mninfo;
    public static Procedure current_dev_interface;
    public static final ModuleMethod parse$Mndescriptor;
    public static final ModuleMethod get$MnvoltageSupport$Mnfrom$Mndescriptor;
    public static Object _ccid_bSeq_;
    public static final ModuleMethod get$MnbSeq;
    public static final ModuleMethod get$MnbStatus$MnbError$MnerrorName;
    public static final ModuleMethod PC_to_RDR_IccPowerOn;
    public static final ModuleMethod PC_to_RDR_XfrBlock;
    public static final ModuleMethod RDR_to_PC_DataBlock;
    public static final ModuleMethod PC_to_RDR_IccPowerOff;
    public static final ModuleMethod RDR_to_PC_SlotStatus;
    public static final ModuleMethod PC_to_RDR_SetParameters;
    public static final ModuleMethod RDR_to_PC_Parameters;
    public static final ModuleMethod PC_to_RDR_Escape;
    public static final ModuleMethod RDR_to_PC_Escape;
    public static final ModuleMethod PC_to_RDR_GetSlotStatus;
    public static final ModuleMethod parse$MnATR;
    public static final ModuleMethod parse$MnatrTA1;
    public static final ModuleMethod get$MnatrSupportProtocol;
    public static final ModuleMethod get$MnatrTATB$Mnfor$MnT15;
    public static final ModuleMethod get$Mnpps1;
    public static final ModuleMethod generate$MnPPS$Mnexchange;
    public static final ModuleMethod get$MnatrIFSC;
    public static final ModuleMethod get$MnatrTC$Mnfor$MnT1;
    public static final ModuleMethod get$MnatrTB$Mnfor$MnT1;
    public static final ModuleMethod generate$MnPPS$Mnparameters$MnT1;
    public static final ModuleMethod generate$MnPPS$Mnparameters$MnT0;
    public static final ModuleMethod get$MnCard$MnTimeout$MnT1;
    public static final ModuleMethod get$MnCard$MnTimeout$MnT0;
    public static final ModuleMethod get$MnCard$MnTimeout;
    public static final ModuleMethod parse$MnT1Block;
    public static final ModuleMethod generate$MnS$Mnblock$MnTPDU$MnT1;
    public static final ModuleMethod generate$MnI$Mnblock$MnTPDU$MnT1;
    public static final ModuleMethod generate$MnR$Mnblock$MnTPDU$MnT1;
    public static boolean ccid$Mndata$Mnrates$Mnsupported;
    public static Object USB_TIMEOUT;
    public static final ModuleMethod make$MnGET_DEVICE_INF$Mnfunc;
    public static final ModuleMethod do$MnPPS$Mnexchange;
    public static final ModuleMethod do$MnPPS$Mnset$Mnparameters;
    public static final ModuleMethod do$MnPPS;
    public static final ModuleMethod get$Mnccid$Mnexchange$Mnlevel;
    public static final ModuleMethod do$MnXfrBlock$MnTPDU$MnT0$MnProtocol;
    public static final ModuleMethod do$MnXfrBlock$MnAPDU$MnExtended$MnProtocol;
    public static Procedure T1$MnTPDU$MnIblock$MnN_S;
    public static Procedure T1$MnTPDU$MnRblock$MnN_R;
    public static final ModuleMethod IFS$Mnrequest$MnTPDU$MnT1;
    public static final ModuleMethod do$MnXfrBlock$MnTPDU$MnT1$MnProtocol;
    public static Procedure CCID$MnDEBUG;
    public static final ModuleMethod do$MnInitDescriptorInf;
    public static final ModuleMethod do$MnPowerOff;
    public static final ModuleMethod do$MnPowerOn;
    public static final ModuleMethod do$MnEscape;
    public static final ModuleMethod do$MnSlotStatus;
    public static final Class Thread;
    public static final Macro simple$Mnthread;
    public static final ModuleMethod thread$Mnsleep$Ex;
    public static final ModuleMethod make$Mnthread;
    public static final ModuleMethod thread$Mnstart$Ex;
    public static final ClassNamespace Log;
    public static final ClassNamespace Object;
    public static final ClassNamespace FTReaderInf;
    public static final ClassNamespace Context;
    public static final ClassNamespace Handler;
    public static final ModuleMethod GET_DEVICES_INF_default;
    public static Object GET_DEVICES_INF;
    public static Procedure USB_CONTROL_IN;
    public static Procedure USB_SEND;
    public static Procedure USB_RECV;
    public static Procedure USB_SEND_RECV;
    public static Procedure USB_INTERRUPT_RECV;
    public static Object XfrBlock$Mnhash$Mntable;
    public static final Class CCIDScheme;
    static boolean _debug_;
    static Object nr;
    static Object ns;
    static Object _current_interface_;
    static final ArrayType Lit0;
    static final IntNum Lit1;
    static final IntNum Lit2;
    static final Keyword Lit3;
    static final SimpleSymbol Lit4;
    static final IntNum Lit5;
    static final IntNum Lit6;
    static final IntNum Lit7;
    static final SimpleSymbol Lit8;
    static final IntNum Lit9;
    static final IntNum Lit10;
    static final IntNum Lit11;
    static final IntNum Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final ModuleMethod lambda$Fn3;
    static final IntNum Lit16;
    static final IntNum Lit17;
    static final IntNum Lit18;
    static final PairWithPosition Lit19;
    static final IntNum Lit20;
    static final IntNum Lit21;
    static final IntNum Lit22;
    static final IntNum Lit23;
    static final IntNum Lit24;
    static final IntNum Lit25;
    static final IntNum Lit26;
    static final SimpleSymbol Lit27;
    static final ModuleMethod lambda$Fn5;
    static final ModuleMethod lambda$Fn6;
    static final ModuleMethod lambda$Fn7;
    static final PairWithPosition Lit28;
    static final ModuleMethod lambda$Fn9;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final SimpleSymbol Lit38;
    static final SimpleSymbol Lit39;
    static final SimpleSymbol Lit40;
    static final SimpleSymbol Lit41;
    static final SimpleSymbol Lit42;
    static final PairWithPosition Lit43;
    static final ModuleMethod lambda$Fn10;
    static final SimpleSymbol Lit44;
    static final SimpleSymbol Lit45;
    static final SimpleSymbol Lit46;
    static final SimpleSymbol Lit47;
    static final SimpleSymbol Lit48;
    static final SimpleSymbol Lit49;
    static final PairWithPosition Lit50;
    static final ModuleMethod lambda$Fn11;
    static final SimpleSymbol Lit51;
    static final SimpleSymbol Lit52;
    static final SimpleSymbol Lit53;
    static final SimpleSymbol Lit54;
    static final SimpleSymbol Lit55;
    static final SimpleSymbol Lit56;
    static final SimpleSymbol Lit57;
    static final IntNum Lit58;
    static final ModuleMethod lambda$Fn12;
    static final SimpleSymbol Lit59;
    static final SimpleSymbol Lit60;
    static final SimpleSymbol Lit61;
    static final PairWithPosition Lit62;
    static final PairWithPosition Lit63;
    static final PairWithPosition Lit64;
    static final PairWithPosition Lit65;
    static final PairWithPosition Lit66;
    static final PairWithPosition Lit67;
    static final IntNum Lit68;
    static final PairWithPosition Lit69;
    static final ModuleMethod lambda$Fn13;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final SimpleSymbol Lit73;
    static final SimpleSymbol Lit74;
    static final SimpleSymbol Lit75;
    static final SimpleSymbol Lit76;
    static final SimpleSymbol Lit77;
    static final SimpleSymbol Lit78;
    static final SimpleSymbol Lit79;
    static final SimpleSymbol Lit80;
    static final SimpleSymbol Lit81;
    static final SimpleSymbol Lit82;
    static final SimpleSymbol Lit83;
    static final SimpleSymbol Lit84;
    static final SimpleSymbol Lit85;
    static final SimpleSymbol Lit86;
    static final SimpleSymbol Lit87;
    static final SimpleSymbol Lit88;
    static final SimpleSymbol Lit89;
    static final IntNum Lit90;
    static final ModuleMethod lambda$Fn14;
    static final SimpleSymbol Lit91;
    static final SimpleSymbol Lit92;
    static final SimpleSymbol Lit93;
    static final SimpleSymbol Lit94;
    static final SimpleSymbol Lit95;
    static final SimpleSymbol Lit96;
    static final PairWithPosition Lit97;
    static final SimpleSymbol Lit98;
    static final IntNum Lit99;
    static final SimpleSymbol Lit100;
    static final IntNum Lit101;
    static final IntNum Lit102;
    static final IntNum Lit103;
    static final IntNum Lit104;
    static final IntNum Lit105;
    static final IntNum Lit106;
    static final IntNum Lit107;
    static final IntNum Lit108;
    static final IntNum Lit109;
    static final IntNum Lit110;
    static final IntNum Lit111;
    static final IntNum Lit112;
    static final IntNum Lit113;
    static final IntNum Lit114;
    static final IntNum Lit115;
    static final IntNum Lit116;
    static final IntNum Lit117;
    static final IntNum Lit118;
    static final IntNum Lit119;
    static final IntNum Lit120;
    static final IntNum Lit121;
    static final IntNum Lit122;
    static final SimpleSymbol Lit123;
    static final SimpleSymbol Lit124;
    static final SimpleSymbol Lit125;
    static final SimpleSymbol Lit126;
    static final SimpleSymbol Lit127;
    static final SimpleSymbol Lit128;
    static final SimpleSymbol Lit129;
    static final IntNum Lit130;
    static final PairWithPosition Lit131;
    static final SimpleSymbol Lit132;
    static final IntNum Lit133;
    static final PairWithPosition Lit134;
    static final IntNum Lit135;
    static final SimpleSymbol Lit136;
    static final SimpleSymbol Lit137;
    static final IntNum Lit138;
    static final SimpleSymbol Lit139;
    static final IntNum Lit140;
    static final ModuleMethod lambda$Fn16;
    static final SimpleSymbol Lit141;
    static final SimpleSymbol Lit142;
    static final SimpleSymbol Lit143;
    static final SimpleSymbol Lit144;
    static final SimpleSymbol Lit145;
    static final SimpleSymbol Lit146;
    static final SimpleSymbol Lit147;
    static final SimpleSymbol Lit148;
    static final SimpleSymbol Lit149;
    static final PairWithPosition Lit150;
    static final IntNum Lit151;
    static final SimpleSymbol Lit152;
    static final PairWithPosition Lit153;
    static final SimpleSymbol Lit154;
    static final PairWithPosition Lit155;
    static final SimpleSymbol Lit156;
    static final PairWithPosition Lit157;
    static final ModuleMethod lambda$Fn17;
    static final SimpleSymbol Lit158;
    static final SimpleSymbol Lit159;
    static final SimpleSymbol Lit160;
    static final ModuleMethod lambda$Fn18;
    static final PairWithPosition Lit161;
    static final IntNum Lit162;
    static final SimpleSymbol Lit163;
    static final SimpleSymbol Lit164;
    static final SimpleSymbol Lit165;
    static final IntNum Lit166;
    static final IntNum Lit167;
    static final SimpleSymbol Lit168;
    static final IntNum Lit169;
    static final SimpleSymbol Lit170;
    static final IntNum Lit171;
    static final IntNum Lit172;
    static final ModuleMethod lambda$Fn19;
    static final IntNum Lit173;
    static final IntNum Lit174;
    static final IntNum Lit175;
    static final IntNum Lit176;
    static final IntNum Lit177;
    static final DFloNum Lit178;
    static final IntNum Lit179;
    static final IntNum Lit180;
    static final IntNum Lit181;
    static final IntNum Lit182;
    static final IntNum Lit183;
    static final IntNum Lit184;
    static final IntNum Lit185;
    static final IntNum Lit186;
    static final IntNum Lit187;
    static final IntNum Lit188;
    static final SimpleSymbol Lit189;
    static final SimpleSymbol Lit190;
    static final SimpleSymbol Lit191;
    static final SimpleSymbol Lit192;
    static final SimpleSymbol Lit193;
    static final SimpleSymbol Lit194;
    static final SimpleSymbol Lit195;
    static final SimpleSymbol Lit196;
    static final SimpleSymbol Lit197;
    static final SimpleSymbol Lit198;
    static final SimpleSymbol Lit199;
    static final SimpleSymbol Lit200;
    static final SimpleSymbol Lit201;
    static final SimpleSymbol Lit202;
    static final SimpleSymbol Lit203;
    static final SimpleSymbol Lit204;
    static final SimpleSymbol Lit205;
    static final SimpleSymbol Lit206;
    static final IntNum Lit207;
    static final IntNum Lit208;
    static final SimpleSymbol Lit209;
    static final IntNum Lit210;
    static final IntNum Lit211;
    static final SimpleSymbol Lit212;
    static final IntNum Lit213;
    static final IntNum Lit214;
    static final SimpleSymbol Lit215;
    static final SimpleSymbol Lit216;
    static final SimpleSymbol Lit217;
    static final SimpleSymbol Lit218;
    static final PairWithPosition Lit219;
    static final PairWithPosition Lit220;
    static final SimpleSymbol Lit221;
    static final SimpleSymbol Lit222;
    static final SimpleSymbol Lit223;
    static final SimpleSymbol Lit224;
    static final SimpleSymbol Lit225;
    static final SimpleSymbol Lit226;
    static final SimpleSymbol Lit227;
    static final SimpleSymbol Lit228;
    static final IntNum Lit229;
    static final IntNum Lit230;
    static final IntNum Lit231;
    static final IntNum Lit232;
    static final SimpleSymbol Lit233;
    static final IntNum Lit234;
    static final SimpleSymbol Lit235;
    static final IntNum Lit236;
    static final SimpleSymbol Lit237;
    static final SimpleSymbol Lit238;
    static final PairWithPosition Lit239;
    static final PairWithPosition Lit240;
    static final PairWithPosition Lit241;
    static final PairWithPosition Lit242;
    static final PairWithPosition Lit243;
    static final ModuleMethod lambda$Fn21;
    static final SimpleSymbol Lit244;
    static final ModuleMethod lambda$Fn22;
    static final PairWithPosition Lit245;
    static final PairWithPosition Lit246;
    static final PairWithPosition Lit247;
    static final ModuleMethod lambda$Fn23;
    static final SimpleSymbol Lit248;
    static final SimpleSymbol Lit249;
    static final PairWithPosition Lit250;
    static final SimpleSymbol Lit251;
    static final SimpleSymbol Lit252;
    static final ModuleMethod lambda$Fn29;
    static final ModuleMethod lambda$Fn30;
    static final ModuleMethod lambda$Fn31;
    static final ModuleMethod lambda$Fn32;
    static final ModuleMethod lambda$Fn33;
    static final ModuleMethod lambda$Fn37;
    static final PairWithPosition Lit253;
    static final PairWithPosition Lit254;
    static final ArrayType Lit255;
    static final SimpleSymbol Lit256;
    static final SimpleSymbol Lit257;
    static final SyntaxPattern Lit258;
    static final SyntaxTemplate Lit259;
    static final SimpleSymbol Lit260;
    static final IntNum Lit261;
    static final PairWithPosition Lit262;
    static final PairWithPosition Lit263;
    static final PairWithPosition Lit264;
    static final PairWithPosition Lit265;
    static final PairWithPosition Lit266;
    static final PairWithPosition Lit267;
    static final PairWithPosition Lit268;
    static final PairWithPosition Lit269;
    static final PairWithPosition Lit270;
    static final PairWithPosition Lit271;
    static final PairWithPosition Lit272;
    static final PairWithPosition Lit273;
    static final PairWithPosition Lit274;
    static final PairWithPosition Lit275;
    static final PairWithPosition Lit276;
    static final PairWithPosition Lit277;
    static final PairWithPosition Lit278;
    
    public CCIDScheme(final FTReaderInf ftReaderInf, final Handler handler) {
        final CCIDScheme$frame17 $heapFrame = new CCIDScheme$frame17();
        $heapFrame.$this$ = this;
        $heapFrame.$this$.mFTReaderInf = ftReaderInf;
        $heapFrame.$this$.mHandler = handler;
        com.ftsafe.CCIDScheme.USB_CONTROL_IN = $heapFrame.lambda$Fn34;
        com.ftsafe.CCIDScheme.USB_SEND = $heapFrame.lambda$Fn35;
        com.ftsafe.CCIDScheme.USB_RECV = $heapFrame.lambda$Fn36;
        com.ftsafe.CCIDScheme.USB_SEND_RECV = com.ftsafe.CCIDScheme.lambda$Fn37;
        com.ftsafe.CCIDScheme.USB_INTERRUPT_RECV = $heapFrame.lambda$Fn38;
        com.ftsafe.CCIDScheme.pp = $heapFrame.lambda$Fn39;
        $heapFrame.$this$.showLog("(*init* (ftReaderInf ::FTReaderInf) (handler ::Handler)) #!void");
    }
    
    public Object readerFind() {
        this.mFTReaderInf.ft_find();
        return Values.empty;
    }
    
    public Object readerOpen(final Object device) {
        public class CCIDScheme$frame19 extends ModuleBody
        {
            Object index;
            CCIDScheme$frame18 staticLink;
            final ModuleMethod lambda$Fn40;
            
            public CCIDScheme$frame19() {
                final ModuleMethod lambda$Fn40 = new ModuleMethod(this, 24, null, 0);
                lambda$Fn40.setProperty("source-location", "ccid_7816/CCIDScheme.scm:99");
                this.lambda$Fn40 = lambda$Fn40;
            }
            
            @Override
            public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                if (moduleMethod.selector == 24) {
                    ctx.proc = moduleMethod;
                    return ctx.pc = 0;
                }
                return super.match0(moduleMethod, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply0(final ModuleMethod method) {
                if (method.selector == 24) {
                    return com.ftsafe.CCIDScheme.lambda57(this);
                }
                return super.apply0(method);
            }
        }
        public class CCIDScheme$frame18 extends ModuleBody
        {
            CCIDScheme $this$;
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   com/ftsafe/CCIDScheme$frame18.<init>:()V
        //     7: astore_2        /* $heapFrame */
        //     8: aload_2         /* $heapFrame */
        //     9: aload_0         /* this */
        //    10: putfield        com/ftsafe/CCIDScheme$frame18.$this$:Lcom/ftsafe/CCIDScheme;
        //    13: aload_2         /* $heapFrame */
        //    14: getfield        com/ftsafe/CCIDScheme$frame18.$this$:Lcom/ftsafe/CCIDScheme;
        //    17: getfield        com/ftsafe/CCIDScheme.mFTReaderInf:Lcom/ftsafe/readerScheme/FTReaderInf;
        //    20: aload_1         /* device */
        //    21: invokeinterface com/ftsafe/readerScheme/FTReaderInf.ft_open:(Ljava/lang/Object;)V
        //    26: getstatic       com/ftsafe/CCIDScheme.USB_CONTROL_IN:Lgnu/mapping/Procedure;
        //    29: invokestatic    com/ftsafe/CCIDScheme.doInitDescriptorInf:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    32: putstatic       com/ftsafe/CCIDScheme.GET_DEVICES_INF:Ljava/lang/Object;
        //    35: invokestatic    gnu/kawa/slib/srfi69.makeHashTable:()Lkawa/lib/kawa/hashtable$HashTable;
        //    38: putstatic       com/ftsafe/CCIDScheme.XfrBlock$Mnhash$Mntable:Ljava/lang/Object;
        //    41: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    44: getstatic       com/ftsafe/CCIDScheme.GET_DEVICES_INF:Ljava/lang/Object;
        //    47: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    50: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    53: astore_3       
        //    54: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    57: astore          4
        //    59: aconst_null    
        //    60: astore          5
        //    62: new             Lcom/ftsafe/CCIDScheme$frame19;
        //    65: dup            
        //    66: invokespecial   com/ftsafe/CCIDScheme$frame19.<init>:()V
        //    69: dup            
        //    70: aload_2         /* $heapFrame */
        //    71: putfield        com/ftsafe/CCIDScheme$frame19.staticLink:Lcom/ftsafe/CCIDScheme$frame18;
        //    74: astore          $heapFrame
        //    76: aload_3        
        //    77: invokeinterface java/util/Iterator.hasNext:()Z
        //    82: ifeq            200
        //    85: aload_3        
        //    86: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    91: astore          7
        //    93: aload           7
        //    95: ldc             Lgnu/lists/Pair;.class
        //    97: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   100: dup            
        //   101: astore          10
        //   103: checkcast       Lgnu/lists/Pair;
        //   106: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   109: aload           $heapFrame
        //   111: swap           
        //   112: putfield        com/ftsafe/CCIDScheme$frame19.index:Ljava/lang/Object;
        //   115: getstatic       com/ftsafe/CCIDScheme.Lit226:Lgnu/mapping/SimpleSymbol;
        //   118: aload           7
        //   120: ldc             Lgnu/lists/Pair;.class
        //   122: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   125: dup            
        //   126: astore          10
        //   128: checkcast       Lgnu/lists/Pair;
        //   131: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   134: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   137: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   140: ifeq            160
        //   143: aload           $heapFrame
        //   145: getfield        com/ftsafe/CCIDScheme$frame19.lambda$Fn40:Lgnu/expr/ModuleMethod;
        //   148: invokestatic    com/ftsafe/CCIDScheme.makeThread:(Ljava/lang/Object;)Lcom/ftsafe/CCIDScheme$0;
        //   151: invokestatic    com/ftsafe/CCIDScheme.threadStart$Ex:(Ljava/lang/Object;)V
        //   154: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   157: goto            163
        //   160: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   163: astore          9
        //   165: new             Lgnu/lists/Pair;
        //   168: dup            
        //   169: aload           9
        //   171: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   174: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   177: aload           5
        //   179: ifnonnull       188
        //   182: dup            
        //   183: astore          4
        //   185: goto            195
        //   188: aload           5
        //   190: swap           
        //   191: dup_x1         
        //   192: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   195: astore          5
        //   197: goto            62
        //   200: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //   203: getstatic       com/ftsafe/CCIDScheme.Lit255:Lgnu/bytecode/ArrayType;
        //   206: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   209: invokestatic    com/ftsafe/CCIDScheme.lambda58loop:(Lgnu/math/IntNum;)Ljava/lang/Object;
        //   212: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   215: astore_3       
        //   216: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   219: astore          4
        //   221: aconst_null    
        //   222: astore          5
        //   224: aload_3        
        //   225: invokeinterface java/util/Iterator.hasNext:()Z
        //   230: ifeq            288
        //   233: aload_3        
        //   234: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   239: astore          6
        //   241: new             Lgnu/lists/Pair;
        //   244: dup            
        //   245: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   248: getstatic       com/ftsafe/CCIDScheme.GET_DEVICES_INF:Ljava/lang/Object;
        //   251: getstatic       com/ftsafe/CCIDScheme.Lit218:Lgnu/mapping/SimpleSymbol;
        //   254: aload           6
        //   256: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   259: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   262: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   265: aload           5
        //   267: ifnonnull       276
        //   270: dup            
        //   271: astore          4
        //   273: goto            283
        //   276: aload           5
        //   278: swap           
        //   279: dup_x1         
        //   280: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   283: astore          5
        //   285: goto            224
        //   288: aload           4
        //   290: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   293: areturn        
        //   294: new             Lgnu/mapping/WrongType;
        //   297: dup_x1         
        //   298: swap           
        //   299: ldc             "car"
        //   301: iconst_1       
        //   302: aload           10
        //   304: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   307: athrow         
        //   308: new             Lgnu/mapping/WrongType;
        //   311: dup_x1         
        //   312: swap           
        //   313: ldc             "cdr"
        //   315: iconst_1       
        //   316: aload           10
        //   318: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   321: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  103    106    294    308    Ljava/lang/ClassCastException;
        //  128    131    308    322    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0160:
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
    
    public Object readerClose() {
        this.mFTReaderInf.ft_close();
        com.ftsafe.CCIDScheme.GET_DEVICES_INF = com.ftsafe.CCIDScheme.GET_DEVICES_INF_default;
        com.ftsafe.CCIDScheme.XfrBlock$Mnhash$Mntable = Boolean.FALSE;
        return Values.empty;
    }
    
    public Object readerPowerOn(final int index) {
        public class CCIDScheme$frame20 extends ModuleBody
        {
            int index;
            final ModuleMethod lambda$Fn41;
            final ModuleMethod lambda$Fn42;
            
            public CCIDScheme$frame20() {
                final ModuleMethod lambda$Fn41 = new ModuleMethod(this, 25, null, 4097);
                lambda$Fn41.setProperty("source-location", "ccid_7816/CCIDScheme.scm:136");
                this.lambda$Fn41 = lambda$Fn41;
                final ModuleMethod lambda$Fn42 = new ModuleMethod(this, 26, null, 0);
                lambda$Fn42.setProperty("source-location", "ccid_7816/CCIDScheme.scm:138");
                this.lambda$Fn42 = lambda$Fn42;
            }
            
            @Override
            public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                if (moduleMethod.selector == 26) {
                    ctx.proc = moduleMethod;
                    return ctx.pc = 0;
                }
                return super.match0(moduleMethod, ctx);
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 25) {
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
            public Object apply0(final ModuleMethod method) {
                if (method.selector == 26) {
                    return com.ftsafe.CCIDScheme.lambda60(this);
                }
                return super.apply0(method);
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object o) {
                if (method.selector == 25) {
                    return com.ftsafe.CCIDScheme.lambda59(this, o);
                }
                return super.apply1(method, o);
            }
        }
        final CCIDScheme$frame20 $heapFrame = new CCIDScheme$frame20();
        $heapFrame.index = index;
        final Pair ret = doPowerOn($heapFrame.lambda$Fn41, $heapFrame.lambda$Fn42);
        final Object force = Promise.force(com.ftsafe.CCIDScheme.XfrBlock$Mnhash$Mntable, hashtable.HashTable.class);
        try {
            hashtables.hashtableSet$Ex((hashtable.HashTable)force, $heapFrame.index, lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit252, ret)));
            return Scheme.apply.apply2(com.ftsafe.CCIDScheme.Lit0, lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit251, ret)));
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "hashtable-set!", 1, force);
        }
    }
    
    public Object readerPowerOff(final int index) {
        public class CCIDScheme$frame21 extends ModuleBody
        {
            int index;
            final ModuleMethod lambda$Fn43;
            
            public CCIDScheme$frame21() {
                final ModuleMethod lambda$Fn43 = new ModuleMethod(this, 27, null, 4097);
                lambda$Fn43.setProperty("source-location", "ccid_7816/CCIDScheme.scm:148");
                this.lambda$Fn43 = lambda$Fn43;
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 27) {
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
                if (method.selector == 27) {
                    return com.ftsafe.CCIDScheme.lambda61(this, o);
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
        //     4: invokespecial   com/ftsafe/CCIDScheme$frame21.<init>:()V
        //     7: astore_2        /* $heapFrame */
        //     8: aload_2         /* $heapFrame */
        //     9: iload_1         /* index */
        //    10: putfield        com/ftsafe/CCIDScheme$frame21.index:I
        //    13: aload_2         /* $heapFrame */
        //    14: getfield        com/ftsafe/CCIDScheme$frame21.lambda$Fn43:Lgnu/expr/ModuleMethod;
        //    17: invokestatic    com/ftsafe/CCIDScheme.doPowerOff:(Ljava/lang/Object;)V
        //    20: getstatic       com/ftsafe/CCIDScheme.XfrBlock$Mnhash$Mntable:Ljava/lang/Object;
        //    23: ldc_w           Lkawa/lib/kawa/hashtable$HashTable;.class
        //    26: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    29: dup            
        //    30: astore_3       
        //    31: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //    34: aload_2         /* $heapFrame */
        //    35: getfield        com/ftsafe/CCIDScheme$frame21.index:I
        //    38: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    41: invokestatic    kawa/lib/rnrs/hashtables.isHashtableContains:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)Z
        //    44: ifeq            77
        //    47: getstatic       com/ftsafe/CCIDScheme.XfrBlock$Mnhash$Mntable:Ljava/lang/Object;
        //    50: ldc_w           Lkawa/lib/kawa/hashtable$HashTable;.class
        //    53: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    56: dup            
        //    57: astore_3       
        //    58: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //    61: aload_2         /* $heapFrame */
        //    62: getfield        com/ftsafe/CCIDScheme$frame21.index:I
        //    65: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    68: invokestatic    kawa/lib/rnrs/hashtables.hashtableDelete$Ex:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)V
        //    71: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    74: goto            80
        //    77: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    80: areturn        
        //    81: new             Lgnu/mapping/WrongType;
        //    84: dup_x1         
        //    85: swap           
        //    86: ldc_w           "hashtable-contains?"
        //    89: iconst_1       
        //    90: aload_3        
        //    91: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    94: athrow         
        //    95: new             Lgnu/mapping/WrongType;
        //    98: dup_x1         
        //    99: swap           
        //   100: ldc_w           "hashtable-delete!"
        //   103: iconst_1       
        //   104: aload_3        
        //   105: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   108: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  31     34     81     95     Ljava/lang/ClassCastException;
        //  58     61     95     109    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0077:
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
    
    public Object readerXfrBlock(final int index, final byte[] data) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: ldc_w           Lkawa/lib/kawa/hashtable$HashTable;.class
        //     6: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     9: dup            
        //    10: astore_3       
        //    11: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //    14: iload_1         /* index */
        //    15: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    18: invokestatic    kawa/lib/rnrs/hashtables.isHashtableContains:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)Z
        //    21: ifeq            73
        //    24: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //    27: getstatic       com/ftsafe/CCIDScheme.Lit0:Lgnu/bytecode/ArrayType;
        //    30: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    33: getstatic       com/ftsafe/CCIDScheme.XfrBlock$Mnhash$Mntable:Ljava/lang/Object;
        //    36: ldc_w           Lkawa/lib/kawa/hashtable$HashTable;.class
        //    39: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    42: dup            
        //    43: astore_3       
        //    44: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //    47: iload_1         /* index */
        //    48: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    51: invokestatic    gnu/kawa/slib/srfi69.hashTableRef:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)Ljava/lang/Object;
        //    54: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //    57: getstatic       gnu/kawa/lispexpr/LangObjType.listType:Lgnu/kawa/lispexpr/LangObjType;
        //    60: aload_2         /* data */
        //    61: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    64: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    67: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    70: goto            90
        //    73: iconst_1       
        //    74: anewarray       Ljava/lang/Object;
        //    77: dup            
        //    78: iconst_0       
        //    79: ldc_w           "readerXfr error readerPowerOn first"
        //    82: aastore        
        //    83: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //    86: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //    89: athrow         
        //    90: areturn        
        //    91: new             Lgnu/mapping/WrongType;
        //    94: dup_x1         
        //    95: swap           
        //    96: ldc_w           "hashtable-contains?"
        //    99: iconst_1       
        //   100: aload_3        
        //   101: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   104: athrow         
        //   105: new             Lgnu/mapping/WrongType;
        //   108: dup_x1         
        //   109: swap           
        //   110: ldc_w           "hash-table-ref"
        //   113: iconst_1       
        //   114: aload_3        
        //   115: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   118: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  11     14     91     105    Ljava/lang/ClassCastException;
        //  44     47     105    119    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0073:
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
    
    public Object readerEscape(final int index, final byte[] data) {
        public class CCIDScheme$frame22 extends ModuleBody
        {
            int index;
            final ModuleMethod lambda$Fn44;
            
            public CCIDScheme$frame22() {
                final ModuleMethod lambda$Fn44 = new ModuleMethod(this, 28, null, 4097);
                lambda$Fn44.setProperty("source-location", "ccid_7816/CCIDScheme.scm:169");
                this.lambda$Fn44 = lambda$Fn44;
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 28) {
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
                if (method.selector == 28) {
                    return com.ftsafe.CCIDScheme.lambda62(this, o);
                }
                return super.apply1(method, o);
            }
        }
        final CCIDScheme$frame22 $heapFrame = new CCIDScheme$frame22();
        $heapFrame.index = index;
        return Scheme.apply.apply2(com.ftsafe.CCIDScheme.Lit0, doEscape($heapFrame.lambda$Fn44, Scheme.apply.apply2(LangObjType.listType, data)));
    }
    
    public int readerSlotStatus(final int index) {
        public class CCIDScheme$frame23 extends ModuleBody
        {
            int index;
            final ModuleMethod lambda$Fn45;
            
            public CCIDScheme$frame23() {
                final ModuleMethod lambda$Fn45 = new ModuleMethod(this, 29, null, 4097);
                lambda$Fn45.setProperty("source-location", "ccid_7816/CCIDScheme.scm:179");
                this.lambda$Fn45 = lambda$Fn45;
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 29) {
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
                if (method.selector == 29) {
                    return com.ftsafe.CCIDScheme.lambda63(this, o);
                }
                return super.apply1(method, o);
            }
        }
        final CCIDScheme$frame23 $heapFrame = new CCIDScheme$frame23();
        $heapFrame.index = index;
        return ((Number)Promise.force(doSlotStatus($heapFrame.lambda$Fn45))).intValue();
    }
    
    public int readerGetPid() {
        Label_0058: {
            if (!KawaConvert.isTrue(this.mFTReaderInf.isFtExist())) {
                break Label_0058;
            }
            final SimpleSymbol lit37 = com.ftsafe.CCIDScheme.Lit37;
            final Object force = Promise.force(lists.assoc(com.ftsafe.CCIDScheme.Lit216, com.ftsafe.CCIDScheme.descriptor$Mninfo), Pair.class);
            try {
                return ((Number)Promise.force(lists.cadr(lists.assoc(lit37, lists.cdr((Pair)force))))).intValue();
                exceptions.error("USB Not Opened");
                throw Special.reachedUnexpected;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "cdr", 1, force);
            }
        }
    }
    
    public int readerGetBcdDevice() {
        Label_0058: {
            if (!KawaConvert.isTrue(this.mFTReaderInf.isFtExist())) {
                break Label_0058;
            }
            final SimpleSymbol lit38 = com.ftsafe.CCIDScheme.Lit38;
            final Object force = Promise.force(lists.assoc(com.ftsafe.CCIDScheme.Lit216, com.ftsafe.CCIDScheme.descriptor$Mninfo), Pair.class);
            try {
                return ((Number)Promise.force(lists.cadr(lists.assoc(lit38, lists.cdr((Pair)force))))).intValue();
                exceptions.error("USB Not Opened");
                throw Special.reachedUnexpected;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "cdr", 1, force);
            }
        }
    }
    
    public Object showLog(final String log) {
        if (!KawaConvert.isTrue(Scheme.isEqual.apply2(null, this.mHandler))) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(DK.CCIDSCHEME_LOG, (Object)log));
        }
        return android.util.Log.d("CCIDScheme", log);
    }
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        com.ftsafe.CCIDScheme.pp = com.ftsafe.CCIDScheme.lambda$Fn3;
        com.ftsafe.CCIDScheme.descriptor$Mninfo = LList.Empty;
        com.ftsafe.CCIDScheme._current_interface_ = com.ftsafe.CCIDScheme.Lit27;
        com.ftsafe.CCIDScheme.current_dev_interface = com.ftsafe.CCIDScheme.lambda$Fn5;
        com.ftsafe.CCIDScheme._ccid_bSeq_ = com.ftsafe.CCIDScheme.Lit1;
        com.ftsafe.CCIDScheme.ccid$Mndata$Mnrates$Mnsupported = false;
        com.ftsafe.CCIDScheme.USB_TIMEOUT = com.ftsafe.CCIDScheme.Lit181;
        com.ftsafe.CCIDScheme.ns = com.ftsafe.CCIDScheme.Lit1;
        com.ftsafe.CCIDScheme.T1$MnTPDU$MnIblock$MnN_S = com.ftsafe.CCIDScheme.lambda$Fn21;
        com.ftsafe.CCIDScheme.nr = com.ftsafe.CCIDScheme.Lit1;
        com.ftsafe.CCIDScheme.T1$MnTPDU$MnRblock$MnN_R = com.ftsafe.CCIDScheme.lambda$Fn22;
        com.ftsafe.CCIDScheme._debug_ = true;
        com.ftsafe.CCIDScheme.CCID$MnDEBUG = com.ftsafe.CCIDScheme.lambda$Fn23;
        com.ftsafe.CCIDScheme.GET_DEVICES_INF = com.ftsafe.CCIDScheme.GET_DEVICES_INF_default;
        com.ftsafe.CCIDScheme.USB_CONTROL_IN = com.ftsafe.CCIDScheme.lambda$Fn29;
        com.ftsafe.CCIDScheme.USB_SEND = com.ftsafe.CCIDScheme.lambda$Fn30;
        com.ftsafe.CCIDScheme.USB_RECV = com.ftsafe.CCIDScheme.lambda$Fn31;
        com.ftsafe.CCIDScheme.USB_SEND_RECV = com.ftsafe.CCIDScheme.lambda$Fn32;
        com.ftsafe.CCIDScheme.USB_INTERRUPT_RECV = com.ftsafe.CCIDScheme.lambda$Fn33;
        com.ftsafe.CCIDScheme.XfrBlock$Mnhash$Mntable = Boolean.FALSE;
    }
    
    public static U8Vector list$To$U8vector(final Object l) {
        final byte[] b = (byte[])Promise.force(Scheme.apply.apply2(com.ftsafe.CCIDScheme.Lit0, l));
        return new U8Vector(b);
    }
    
    public static Object u8vector$To$List(final Object data) {
        return Scheme.apply.apply2(LangObjType.listType, data);
    }
    
    public static U8Vector makeU8vector(final Object num) {
        return makeU8vector(num, com.ftsafe.CCIDScheme.Lit1);
    }
    
    public static U8Vector makeU8vector(final Object num, final Object fixed) {
        final Object force = Promise.force(num);
        try {
            return new U8Vector(((Number)force).intValue(), (byte)1);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "gnu.lists.U8Vector.<init>(int,byte)", 1, force);
        }
    }
    
    public static String object$To$String(final Object obj) {
        return Format.formatToString(0, "~A", obj);
    }
    
    public static Object slice(final Object lst, final Object offset, final Object length) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: ifeq            11
        //     7: aload_0         /* lst */
        //     8: goto            109
        //    11: aload_1         /* offset */
        //    12: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //    15: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    18: ifeq            48
        //    21: aload_0         /* lst */
        //    22: ldc             Lgnu/lists/Pair;.class
        //    24: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    27: dup            
        //    28: astore_3       
        //    29: checkcast       Lgnu/lists/Pair;
        //    32: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    35: iconst_m1      
        //    36: aload_1         /* offset */
        //    37: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //    40: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    43: astore_1        /* offset */
        //    44: astore_0        /* lst */
        //    45: goto            0
        //    48: aload_2         /* length */
        //    49: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //    52: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    55: ifeq            106
        //    58: aload_0         /* lst */
        //    59: ldc             Lgnu/lists/Pair;.class
        //    61: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    64: dup            
        //    65: astore_3       
        //    66: checkcast       Lgnu/lists/Pair;
        //    69: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    72: aload_0         /* lst */
        //    73: ldc             Lgnu/lists/Pair;.class
        //    75: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    78: dup            
        //    79: astore_3       
        //    80: checkcast       Lgnu/lists/Pair;
        //    83: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    86: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //    89: iconst_m1      
        //    90: aload_2         /* length */
        //    91: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //    94: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    97: invokestatic    com/ftsafe/CCIDScheme.slice:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   100: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   103: goto            109
        //   106: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   109: areturn        
        //   110: new             Lgnu/mapping/WrongType;
        //   113: dup_x1         
        //   114: swap           
        //   115: ldc             "cdr"
        //   117: iconst_1       
        //   118: aload_3        
        //   119: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   122: athrow         
        //   123: new             Lgnu/mapping/WrongType;
        //   126: dup_x1         
        //   127: swap           
        //   128: ldc             "car"
        //   130: iconst_1       
        //   131: aload_3        
        //   132: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   135: athrow         
        //   136: new             Lgnu/mapping/WrongType;
        //   139: dup_x1         
        //   140: swap           
        //   141: ldc             "cdr"
        //   143: iconst_1       
        //   144: aload_3        
        //   145: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   148: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  29     32     110    123    Ljava/lang/ClassCastException;
        //  66     69     123    136    Ljava/lang/ClassCastException;
        //  80     83     136    149    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 75 out of bounds for length 75
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
    
    public static Object buildDwordFromlst$V(final Object lst, final Object[] argsArray) {
        final Object endia = Keyword.searchForKeyword(argsArray, 0, com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4);
        Object o;
        if (endia == com.ftsafe.CCIDScheme.Lit4) {
            o = BitwiseOp.ior.apply2(BitwiseOp.ior.apply2(BitwiseOp.ior.apply2(BitwiseOp.ashift.apply2(lists.listRef(lst, 3), com.ftsafe.CCIDScheme.Lit5), BitwiseOp.ashift.apply2(lists.listRef(lst, 2), com.ftsafe.CCIDScheme.Lit6)), BitwiseOp.ashift.apply2(lists.listRef(lst, 1), com.ftsafe.CCIDScheme.Lit7)), lists.listRef(lst, 0));
        }
        else {
            if (endia != com.ftsafe.CCIDScheme.Lit8) {
                exceptions.error("build-dword-fromlst", "parameter error!");
                throw Special.reachedUnexpected;
            }
            o = BitwiseOp.ior.apply2(BitwiseOp.ior.apply2(BitwiseOp.ior.apply2(BitwiseOp.ashift.apply2(lists.listRef(lst, 0), com.ftsafe.CCIDScheme.Lit5), BitwiseOp.ashift.apply2(lists.listRef(lst, 1), com.ftsafe.CCIDScheme.Lit6)), BitwiseOp.ashift.apply2(lists.listRef(lst, 2), com.ftsafe.CCIDScheme.Lit7)), lists.listRef(lst, 3));
        }
        return o;
    }
    
    public static Pair buildDwordInlst$V(final Object dword, final Object[] argsArray) {
        final Object endia = Keyword.searchForKeyword(argsArray, 0, com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4);
        Pair pair;
        if (endia == com.ftsafe.CCIDScheme.Lit4) {
            pair = LList.list4(BitwiseOp.and.apply2(dword, com.ftsafe.CCIDScheme.Lit9), BitwiseOp.and.apply2(BitwiseOp.ashift.apply2(dword, com.ftsafe.CCIDScheme.Lit10), com.ftsafe.CCIDScheme.Lit9), BitwiseOp.and.apply2(BitwiseOp.ashift.apply2(dword, com.ftsafe.CCIDScheme.Lit11), com.ftsafe.CCIDScheme.Lit9), BitwiseOp.and.apply2(BitwiseOp.ashift.apply2(dword, com.ftsafe.CCIDScheme.Lit12), com.ftsafe.CCIDScheme.Lit9));
        }
        else {
            if (endia != com.ftsafe.CCIDScheme.Lit8) {
                exceptions.error("build-dword-inlst", "parameter error!");
                throw Special.reachedUnexpected;
            }
            pair = LList.list4(BitwiseOp.and.apply2(BitwiseOp.ashift.apply2(dword, com.ftsafe.CCIDScheme.Lit12), com.ftsafe.CCIDScheme.Lit9), BitwiseOp.and.apply2(BitwiseOp.ashift.apply2(dword, com.ftsafe.CCIDScheme.Lit11), com.ftsafe.CCIDScheme.Lit9), BitwiseOp.and.apply2(BitwiseOp.ashift.apply2(dword, com.ftsafe.CCIDScheme.Lit10), com.ftsafe.CCIDScheme.Lit9), BitwiseOp.and.apply2(dword, com.ftsafe.CCIDScheme.Lit9));
        }
        return pair;
    }
    
    public static Object buildWordFromlst$V(final Object lst, final Object[] argsArray) {
        final Object endia = Keyword.searchForKeyword(argsArray, 0, com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4);
        Object o;
        if (endia == com.ftsafe.CCIDScheme.Lit4) {
            o = BitwiseOp.ior.apply2(BitwiseOp.ashift.apply2(lists.listRef(lst, 1), com.ftsafe.CCIDScheme.Lit7), lists.listRef(lst, 0));
        }
        else {
            if (endia != com.ftsafe.CCIDScheme.Lit8) {
                exceptions.error("build-word-fromlst", "parameter error!");
                throw Special.reachedUnexpected;
            }
            o = BitwiseOp.ior.apply2(BitwiseOp.ashift.apply2(lists.listRef(lst, 0), com.ftsafe.CCIDScheme.Lit7), lists.listRef(lst, 1));
        }
        return o;
    }
    
    public static Pair buildWordInlst$V(final Object word, final Object[] argsArray) {
        final Object endia = Keyword.searchForKeyword(argsArray, 0, com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4);
        Pair pair;
        if (endia == com.ftsafe.CCIDScheme.Lit4) {
            pair = LList.list2(BitwiseOp.and.apply2(word, com.ftsafe.CCIDScheme.Lit9), BitwiseOp.and.apply2(BitwiseOp.ashift.apply2(word, com.ftsafe.CCIDScheme.Lit10), com.ftsafe.CCIDScheme.Lit9));
        }
        else {
            if (endia != com.ftsafe.CCIDScheme.Lit8) {
                exceptions.error("build-word-inlst", "parameter error!");
                throw Special.reachedUnexpected;
            }
            pair = LList.list2(BitwiseOp.and.apply2(BitwiseOp.ashift.apply2(word, com.ftsafe.CCIDScheme.Lit10), com.ftsafe.CCIDScheme.Lit9), BitwiseOp.and.apply2(word, com.ftsafe.CCIDScheme.Lit9));
        }
        return pair;
    }
    
    public static Procedure makeCounter() {
        return makeCounter(com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit2);
    }
    
    public static Procedure makeCounter(final Object start) {
        return makeCounter(start, com.ftsafe.CCIDScheme.Lit2);
    }
    
    public static Procedure makeCounter(final Object start, final Object step) {
        public class CCIDScheme$frame0 extends ModuleBody
        {
            Object step;
            Object counter;
            final ModuleMethod lambda$Fn1;
            
            public CCIDScheme$frame0() {
                final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, 0);
                lambda$Fn1.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:84");
                this.lambda$Fn1 = lambda$Fn1;
            }
            
            Object lambda1() {
                return this.counter = AddOp.apply2(1, this.counter, this.step);
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
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply0(final ModuleMethod method) {
                if (method.selector == 1) {
                    return this.lambda1();
                }
                return super.apply0(method);
            }
        }
        final CCIDScheme$frame0 $heapFrame = new CCIDScheme$frame0();
        $heapFrame.step = step;
        $heapFrame.counter = AddOp.apply2(-1, start, $heapFrame.step);
        return $heapFrame.lambda$Fn1;
    }
    
    public static Procedure makeContainer(final Object func) {
        public class CCIDScheme$frame1 extends ModuleBody
        {
            Object func;
            Object _container;
            final ModuleMethod lambda$Fn2;
            
            public CCIDScheme$frame1() {
                final ModuleMethod lambda$Fn2 = new ModuleMethod(this, 2, null, 8193);
                lambda$Fn2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:93");
                this.lambda$Fn2 = lambda$Fn2;
            }
            
            Object lambda2(final Object op) {
                return this.lambda2(op, Boolean.FALSE);
            }
            
            Object lambda2(final Object op, final Object arg) {
                Object o;
                if (KawaConvert.isTrue(Scheme.isEqual.apply2(op, com.ftsafe.CCIDScheme.Lit13))) {
                    this._container = arg;
                    o = Values.empty;
                }
                else if (KawaConvert.isTrue(Scheme.isEqual.apply2(op, com.ftsafe.CCIDScheme.Lit14))) {
                    this._container = Scheme.applyToArgs.apply3(this.func, this._container, arg);
                    o = Values.empty;
                }
                else {
                    o = (KawaConvert.isTrue(Scheme.isEqual.apply2(op, com.ftsafe.CCIDScheme.Lit15)) ? this._container : Values.empty);
                }
                return o;
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
                    return this.lambda2(arg1);
                }
                return super.apply1(method, arg1);
            }
            
            @Override
            public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                if (method.selector == 2) {
                    return this.lambda2(o, o2);
                }
                return super.apply2(method, o, o2);
            }
        }
        final CCIDScheme$frame1 $heapFrame = new CCIDScheme$frame1();
        $heapFrame.func = func;
        $heapFrame._container = Boolean.FALSE;
        return $heapFrame.lambda$Fn2;
    }
    
    public static Object toList$V(final Object A, final Object[] argsArray) {
        final LList B = LList.makeList(argsArray, 0);
        return append.append$V(new Object[] { LList.list1(A), B });
    }
    
    public static Object readU8s(final Object n, final Object port) {
        LList empty;
        if (NumberCompare.$Gr(n, com.ftsafe.CCIDScheme.Lit1)) {
            final Object b = ports.readU8(port);
            empty = (KawaConvert.isTrue(Scheme.isEqual.apply2(b, EofClass.eofValue)) ? LList.Empty : lists.cons(b, readU8s(AddOp.apply2(-1, n, com.ftsafe.CCIDScheme.Lit2), port)));
        }
        else {
            empty = LList.Empty;
        }
        return empty;
    }
    
    public static Object callWithInputU8vector(final Object u8, final Object proc) {
        Object o;
        final Object obj = o = Promise.force(u8, U8Vector.class);
        BinaryInPort openInputBytevector;
        Object o2;
        try {
            openInputBytevector = ports.openInputBytevector(LangObjType.coerceToU8Vector(obj));
            o2 = (o = Promise.force(proc, Procedure.class));
            final Procedure procedure = (Procedure)o2;
            return ports.callWithPort(openInputBytevector, procedure);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "open-input-bytevector", 1, o);
        }
        try {
            final Procedure procedure = (Procedure)o2;
            return ports.callWithPort(openInputBytevector, procedure);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "call-with-port", 2, o);
        }
    }
    
    static void lambda3(final Object obj) {
        object$To$String(obj);
    }
    
    public static Object subu8list(final Object lst, final Object start, final Object end) {
        return slice(lst, start, AddOp.apply2(-1, end, start));
    }
    
    public static Object groupList(final Object lst, final Object gl) {
        return NumberCompare.$Gr(gl, com.ftsafe.CCIDScheme.Lit1) ? append.append$V(new Object[] { LList.list1(slice(lst, com.ftsafe.CCIDScheme.Lit1, gl)), NumberCompare.$Gr(AddOp.apply2(-1, Sequences.getSize(lst), gl), com.ftsafe.CCIDScheme.Lit1) ? groupList(slice(lst, gl, Sequences.getSize(lst)), gl) : LList.Empty }) : Boolean.FALSE;
    }
    
    public static Object filter(final Object predicate, final Object lst) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_1         /* lst */
        //     4: if_acmpne       13
        //     7: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    10: goto            96
        //    13: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    16: aload_0         /* predicate */
        //    17: aload_1         /* lst */
        //    18: ldc             Lgnu/lists/Pair;.class
        //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    23: dup            
        //    24: astore_2       
        //    25: checkcast       Lgnu/lists/Pair;
        //    28: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    31: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    34: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    37: ifeq            78
        //    40: aload_1         /* lst */
        //    41: ldc             Lgnu/lists/Pair;.class
        //    43: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    46: dup            
        //    47: astore_2       
        //    48: checkcast       Lgnu/lists/Pair;
        //    51: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    54: aload_0         /* predicate */
        //    55: aload_1         /* lst */
        //    56: ldc             Lgnu/lists/Pair;.class
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    61: dup            
        //    62: astore_2       
        //    63: checkcast       Lgnu/lists/Pair;
        //    66: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    69: invokestatic    com/ftsafe/CCIDScheme.filter:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    72: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    75: goto            96
        //    78: aload_1         /* lst */
        //    79: ldc             Lgnu/lists/Pair;.class
        //    81: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    84: dup            
        //    85: astore_2       
        //    86: checkcast       Lgnu/lists/Pair;
        //    89: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    92: astore_1        /* lst */
        //    93: goto            0
        //    96: areturn        
        //    97: new             Lgnu/mapping/WrongType;
        //   100: dup_x1         
        //   101: swap           
        //   102: ldc             "car"
        //   104: iconst_1       
        //   105: aload_2        
        //   106: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   109: athrow         
        //   110: new             Lgnu/mapping/WrongType;
        //   113: dup_x1         
        //   114: swap           
        //   115: ldc             "car"
        //   117: iconst_1       
        //   118: aload_2        
        //   119: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   122: athrow         
        //   123: new             Lgnu/mapping/WrongType;
        //   126: dup_x1         
        //   127: swap           
        //   128: ldc             "cdr"
        //   130: iconst_1       
        //   131: aload_2        
        //   132: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   135: athrow         
        //   136: new             Lgnu/mapping/WrongType;
        //   139: dup_x1         
        //   140: swap           
        //   141: ldc             "cdr"
        //   143: iconst_1       
        //   144: aload_2        
        //   145: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   148: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  25     28     97     110    Ljava/lang/ClassCastException;
        //  48     51     110    123    Ljava/lang/ClassCastException;
        //  63     66     123    136    Ljava/lang/ClassCastException;
        //  86     89     136    149    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 77 out of bounds for length 77
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
    
    public static Object assocEX(final Object n, final Object l) {
        Label_0049: {
            if (!lists.isList(l)) {
                break Label_0049;
            }
            final Object r = lists.assoc(n, filter(lists.list$Qu, l));
            Label_0043: {
                if (!KawaConvert.isTrue(r)) {
                    break Label_0043;
                }
                final Object force = Promise.force(r, Pair.class);
                try {
                    return lists.cdr((Pair)force);
                    o = Boolean.FALSE;
                    return o;
                    o = Boolean.FALSE;
                    return o;
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "cdr", 1, force);
                }
            }
        }
    }
    
    public static Object listXor(final Object l) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: ifeq            13
        //     7: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //    10: goto            50
        //    13: getstatic       gnu/kawa/functions/BitwiseOp.xor:Lgnu/kawa/functions/BitwiseOp;
        //    16: aload_0         /* l */
        //    17: ldc             Lgnu/lists/Pair;.class
        //    19: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    22: dup            
        //    23: astore_1       
        //    24: checkcast       Lgnu/lists/Pair;
        //    27: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    30: aload_0         /* l */
        //    31: ldc             Lgnu/lists/Pair;.class
        //    33: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    36: dup            
        //    37: astore_1       
        //    38: checkcast       Lgnu/lists/Pair;
        //    41: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    44: invokestatic    com/ftsafe/CCIDScheme.listXor:(Ljava/lang/Object;)Ljava/lang/Object;
        //    47: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    50: areturn        
        //    51: new             Lgnu/mapping/WrongType;
        //    54: dup_x1         
        //    55: swap           
        //    56: ldc             "car"
        //    58: iconst_1       
        //    59: aload_1        
        //    60: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    63: athrow         
        //    64: new             Lgnu/mapping/WrongType;
        //    67: dup_x1         
        //    68: swap           
        //    69: ldc             "cdr"
        //    71: iconst_1       
        //    72: aload_1        
        //    73: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    76: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  24     27     51     64     Ljava/lang/ClassCastException;
        //  38     41     64     77     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0050:
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
    
    public static CharSequence toHexStr(final Object number) {
        return toHexStr(number, com.ftsafe.CCIDScheme.Lit16);
    }
    
    public static CharSequence toHexStr(final Object number, final Object len) {
        Iterator argValue;
        final Object o = argValue = (Iterator)Promise.force(number, Number.class);
        try {
            final CharSequence s = numbers.number$To$String((Number)o, 16);
            CharSequence stringAppend;
            if (NumberCompare.$Gr(strings.stringLength(s), len)) {
                stringAppend = s;
            }
            else {
                final Object[] args = new Object[2];
                final int n = 0;
                argValue = Sequences.getIterator(u8vector$To$List(makeU8vector(AddOp.apply2(-1, len, strings.stringLength(s)), com.ftsafe.CCIDScheme.Lit17)));
                LList empty = LList.Empty;
                Pair pair = null;
                while (argValue.hasNext()) {
                    final Pair cdr = new Pair(Char.make(((Number)Promise.force(argValue.next())).intValue()), LList.Empty);
                    if (pair == null) {
                        empty = cdr;
                    }
                    else {
                        pair.setCdr(cdr);
                    }
                    pair = cdr;
                }
                args[n] = strings.list$To$String(empty);
                args[1] = s;
                stringAppend = strings.stringAppend(args);
            }
            return stringAppend;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "number->string", 1, argValue);
        }
    }
    
    public static CharSequence toOctStr(final Object number) {
        return toOctStr(number, com.ftsafe.CCIDScheme.Lit18);
    }
    
    public static CharSequence toOctStr(final Object number, final Object len) {
        Iterator argValue;
        final Object o = argValue = (Iterator)Promise.force(number, Number.class);
        try {
            final CharSequence s = numbers.number$To$String((Number)o, 8);
            CharSequence stringAppend;
            if (NumberCompare.$Gr(strings.stringLength(s), len)) {
                stringAppend = s;
            }
            else {
                final Object[] args = new Object[2];
                final int n = 0;
                argValue = Sequences.getIterator(u8vector$To$List(makeU8vector(AddOp.apply2(-1, len, strings.stringLength(s)), com.ftsafe.CCIDScheme.Lit17)));
                LList empty = LList.Empty;
                Pair pair = null;
                while (argValue.hasNext()) {
                    final Pair cdr = new Pair(Char.make(((Number)Promise.force(argValue.next())).intValue()), LList.Empty);
                    if (pair == null) {
                        empty = cdr;
                    }
                    else {
                        pair.setCdr(cdr);
                    }
                    pair = cdr;
                }
                args[n] = strings.list$To$String(empty);
                args[1] = s;
                stringAppend = strings.stringAppend(args);
            }
            return stringAppend;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "number->string", 1, argValue);
        }
    }
    
    public static CharSequence toBinStr(final Object number) {
        return toBinStr(number, com.ftsafe.CCIDScheme.Lit7);
    }
    
    public static CharSequence toBinStr(final Object number, final Object len) {
        Iterator argValue;
        final Object o = argValue = (Iterator)Promise.force(number, Number.class);
        try {
            final CharSequence s = numbers.number$To$String((Number)o, 2);
            CharSequence stringAppend;
            if (NumberCompare.$Gr(strings.stringLength(s), len)) {
                stringAppend = s;
            }
            else {
                final Object[] args = new Object[2];
                final int n = 0;
                argValue = Sequences.getIterator(u8vector$To$List(makeU8vector(AddOp.apply2(-1, len, strings.stringLength(s)), com.ftsafe.CCIDScheme.Lit17)));
                LList empty = LList.Empty;
                Pair pair = null;
                while (argValue.hasNext()) {
                    final Pair cdr = new Pair(Char.make(((Number)Promise.force(argValue.next())).intValue()), LList.Empty);
                    if (pair == null) {
                        empty = cdr;
                    }
                    else {
                        pair.setCdr(cdr);
                    }
                    pair = cdr;
                }
                args[n] = strings.list$To$String(empty);
                args[1] = s;
                stringAppend = strings.stringAppend(args);
            }
            return stringAppend;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "number->string", 1, argValue);
        }
    }
    
    public static Object u8list$To$String(final Object l) {
        return u8list$To$String(l, "");
    }
    
    public static Object u8list$To$String(final Object _l, final Object fixed) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: ifeq            13
        //     7: ldc_w           ""
        //    10: goto            91
        //    13: iconst_3       
        //    14: anewarray       Ljava/lang/Object;
        //    17: dup            
        //    18: iconst_0       
        //    19: aload_0         /* _l */
        //    20: ldc             Lgnu/lists/Pair;.class
        //    22: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    25: dup            
        //    26: astore_2       
        //    27: checkcast       Lgnu/lists/Pair;
        //    30: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    33: invokestatic    com/ftsafe/CCIDScheme.toHexStr:(Ljava/lang/Object;)Ljava/lang/CharSequence;
        //    36: aastore        
        //    37: dup            
        //    38: iconst_1       
        //    39: aload_0         /* _l */
        //    40: ldc             Lgnu/lists/Pair;.class
        //    42: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    45: dup            
        //    46: astore_2       
        //    47: checkcast       Lgnu/lists/Pair;
        //    50: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    53: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    56: ifeq            65
        //    59: ldc_w           ""
        //    62: goto            66
        //    65: aload_1         /* fixed */
        //    66: aastore        
        //    67: dup            
        //    68: iconst_2       
        //    69: aload_0         /* _l */
        //    70: ldc             Lgnu/lists/Pair;.class
        //    72: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    75: dup            
        //    76: astore_2       
        //    77: checkcast       Lgnu/lists/Pair;
        //    80: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    83: aload_1         /* fixed */
        //    84: invokestatic    com/ftsafe/CCIDScheme.u8list$To$String:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    87: aastore        
        //    88: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //    91: areturn        
        //    92: new             Lgnu/mapping/WrongType;
        //    95: dup_x1         
        //    96: swap           
        //    97: ldc             "car"
        //    99: iconst_1       
        //   100: aload_2        
        //   101: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   104: athrow         
        //   105: new             Lgnu/mapping/WrongType;
        //   108: dup_x1         
        //   109: swap           
        //   110: ldc             "cdr"
        //   112: iconst_1       
        //   113: aload_2        
        //   114: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   117: athrow         
        //   118: new             Lgnu/mapping/WrongType;
        //   121: dup_x1         
        //   122: swap           
        //   123: ldc             "cdr"
        //   125: iconst_1       
        //   126: aload_2        
        //   127: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   130: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  27     30     92     105    Ljava/lang/ClassCastException;
        //  47     50     105    118    Ljava/lang/ClassCastException;
        //  77     80     118    131    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 71 out of bounds for length 71
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
    
    public static Object isInList(final Object n, final Object lst) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: ifeq            13
        //     7: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    10: goto            62
        //    13: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    16: aload_0         /* n */
        //    17: aload_1         /* lst */
        //    18: ldc             Lgnu/lists/Pair;.class
        //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    23: dup            
        //    24: astore_2       
        //    25: checkcast       Lgnu/lists/Pair;
        //    28: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    31: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    34: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    37: ifeq            44
        //    40: aload_0         /* n */
        //    41: goto            62
        //    44: aload_1         /* lst */
        //    45: ldc             Lgnu/lists/Pair;.class
        //    47: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    50: dup            
        //    51: astore_2       
        //    52: checkcast       Lgnu/lists/Pair;
        //    55: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    58: astore_1        /* lst */
        //    59: goto            0
        //    62: areturn        
        //    63: new             Lgnu/mapping/WrongType;
        //    66: dup_x1         
        //    67: swap           
        //    68: ldc             "car"
        //    70: iconst_1       
        //    71: aload_2        
        //    72: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    75: athrow         
        //    76: new             Lgnu/mapping/WrongType;
        //    79: dup_x1         
        //    80: swap           
        //    81: ldc             "cdr"
        //    83: iconst_1       
        //    84: aload_2        
        //    85: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    88: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  25     28     63     76     Ljava/lang/ClassCastException;
        //  52     55     76     89     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0062:
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
    
    public static LList byte$To$Bit(final Object byte) {
        Object arg = com.ftsafe.CCIDScheme.Lit19;
        LList empty = LList.Empty;
        Pair pair = null;
        while (arg != LList.Empty) {
            final Pair pair2 = (Pair)Promise.force(arg, Pair.class);
            final Pair cdr = new Pair(srfi60.bit$Mnset$Qu.apply2(pair2.getCar(), byte), LList.Empty);
            if (pair == null) {
                empty = cdr;
            }
            else {
                pair.setCdr(cdr);
            }
            pair = cdr;
            arg = pair2.getCdr();
        }
        return empty;
    }
    
    public static Object listRemoveDuplication(final Object lst) {
        public class CCIDScheme$frame2 extends ModuleBody
        {
            Object lst;
            final ModuleMethod lambda$Fn4;
            
            public CCIDScheme$frame2() {
                final ModuleMethod lambda$Fn4 = new ModuleMethod(this, 4, null, 4097);
                lambda$Fn4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:228");
                this.lambda$Fn4 = lambda$Fn4;
            }
            
            boolean lambda4(final Object x) {
                final IsEqual isEqual = Scheme.isEqual;
                final Object force = Promise.force(this.lst, Pair.class);
                try {
                    return !KawaConvert.isTrue(isEqual.apply2(x, lists.car((Pair)force)));
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "car", 1, force);
                }
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 4) {
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
                if (method.selector == 4) {
                    return this.lambda4(o) ? Boolean.TRUE : Boolean.FALSE;
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
        //     4: invokespecial   com/ftsafe/CCIDScheme$frame2.<init>:()V
        //     7: astore_1        /* $heapFrame */
        //     8: aload_1         /* $heapFrame */
        //     9: aload_0         /* lst */
        //    10: putfield        com/ftsafe/CCIDScheme$frame2.lst:Ljava/lang/Object;
        //    13: aload_1         /* $heapFrame */
        //    14: getfield        com/ftsafe/CCIDScheme$frame2.lst:Ljava/lang/Object;
        //    17: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    20: ifne            73
        //    23: aload_1         /* $heapFrame */
        //    24: getfield        com/ftsafe/CCIDScheme$frame2.lst:Ljava/lang/Object;
        //    27: ldc             Lgnu/lists/Pair;.class
        //    29: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    32: dup            
        //    33: astore_2       
        //    34: checkcast       Lgnu/lists/Pair;
        //    37: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    40: aload_1         /* $heapFrame */
        //    41: getfield        com/ftsafe/CCIDScheme$frame2.lambda$Fn4:Lgnu/expr/ModuleMethod;
        //    44: aload_1         /* $heapFrame */
        //    45: getfield        com/ftsafe/CCIDScheme$frame2.lst:Ljava/lang/Object;
        //    48: ldc             Lgnu/lists/Pair;.class
        //    50: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    53: dup            
        //    54: astore_2       
        //    55: checkcast       Lgnu/lists/Pair;
        //    58: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    61: invokestatic    com/ftsafe/CCIDScheme.filter:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    64: invokestatic    com/ftsafe/CCIDScheme.listRemoveDuplication:(Ljava/lang/Object;)Ljava/lang/Object;
        //    67: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    70: goto            76
        //    73: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    76: areturn        
        //    77: new             Lgnu/mapping/WrongType;
        //    80: dup_x1         
        //    81: swap           
        //    82: ldc             "car"
        //    84: iconst_1       
        //    85: aload_2        
        //    86: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    89: athrow         
        //    90: new             Lgnu/mapping/WrongType;
        //    93: dup_x1         
        //    94: swap           
        //    95: ldc             "cdr"
        //    97: iconst_1       
        //    98: aload_2        
        //    99: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   102: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  34     37     77     90     Ljava/lang/ClassCastException;
        //  55     58     90     103    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0073:
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
    
    public static int float$To$Integer(final Object f) {
        return ((Number)Promise.force(f)).intValue();
    }
    
    public static Object stringlst$To$String(final Object lst) {
        return stringlst$To$String(lst, "");
    }
    
    public static Object stringlst$To$String(final Object lst, final Object fixed) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: ifeq            13
        //     7: ldc_w           ""
        //    10: goto            88
        //    13: iconst_3       
        //    14: anewarray       Ljava/lang/Object;
        //    17: dup            
        //    18: iconst_0       
        //    19: aload_0         /* lst */
        //    20: ldc             Lgnu/lists/Pair;.class
        //    22: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    25: dup            
        //    26: astore_2       
        //    27: checkcast       Lgnu/lists/Pair;
        //    30: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    33: aastore        
        //    34: dup            
        //    35: iconst_1       
        //    36: aload_0         /* lst */
        //    37: ldc             Lgnu/lists/Pair;.class
        //    39: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    42: dup            
        //    43: astore_2       
        //    44: checkcast       Lgnu/lists/Pair;
        //    47: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    50: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    53: ifeq            62
        //    56: ldc_w           ""
        //    59: goto            63
        //    62: aload_1         /* fixed */
        //    63: aastore        
        //    64: dup            
        //    65: iconst_2       
        //    66: aload_0         /* lst */
        //    67: ldc             Lgnu/lists/Pair;.class
        //    69: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    72: dup            
        //    73: astore_2       
        //    74: checkcast       Lgnu/lists/Pair;
        //    77: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    80: aload_1         /* fixed */
        //    81: invokestatic    com/ftsafe/CCIDScheme.stringlst$To$String:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    84: aastore        
        //    85: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //    88: areturn        
        //    89: new             Lgnu/mapping/WrongType;
        //    92: dup_x1         
        //    93: swap           
        //    94: ldc             "car"
        //    96: iconst_1       
        //    97: aload_2        
        //    98: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   101: athrow         
        //   102: new             Lgnu/mapping/WrongType;
        //   105: dup_x1         
        //   106: swap           
        //   107: ldc             "cdr"
        //   109: iconst_1       
        //   110: aload_2        
        //   111: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   114: athrow         
        //   115: new             Lgnu/mapping/WrongType;
        //   118: dup_x1         
        //   119: swap           
        //   120: ldc             "cdr"
        //   122: iconst_1       
        //   123: aload_2        
        //   124: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   127: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  27     30     89     102    Ljava/lang/ClassCastException;
        //  44     47     102    115    Ljava/lang/ClassCastException;
        //  74     77     115    128    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 70 out of bounds for length 70
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
    
    public static Object alist$To$List(final Object alst) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     4: ifeq            13
        //     7: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    10: goto            57
        //    13: iconst_2       
        //    14: anewarray       Ljava/lang/Object;
        //    17: dup            
        //    18: iconst_0       
        //    19: aload_0         /* alst */
        //    20: ldc             Lgnu/lists/Pair;.class
        //    22: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    25: dup            
        //    26: astore_1       
        //    27: checkcast       Lgnu/lists/Pair;
        //    30: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    33: aastore        
        //    34: dup            
        //    35: iconst_1       
        //    36: aload_0         /* alst */
        //    37: ldc             Lgnu/lists/Pair;.class
        //    39: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    42: dup            
        //    43: astore_1       
        //    44: checkcast       Lgnu/lists/Pair;
        //    47: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    50: invokestatic    com/ftsafe/CCIDScheme.alist$To$List:(Ljava/lang/Object;)Ljava/lang/Object;
        //    53: aastore        
        //    54: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //    57: areturn        
        //    58: new             Lgnu/mapping/WrongType;
        //    61: dup_x1         
        //    62: swap           
        //    63: ldc             "car"
        //    65: iconst_1       
        //    66: aload_1        
        //    67: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    70: athrow         
        //    71: new             Lgnu/mapping/WrongType;
        //    74: dup_x1         
        //    75: swap           
        //    76: ldc             "cdr"
        //    78: iconst_1       
        //    79: aload_1        
        //    80: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    83: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  27     30     58     71     Ljava/lang/ClassCastException;
        //  44     47     71     84     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0057:
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
    
    public static Object getConfigurationDescriptor(final Object usb_control_in) {
        final Object configdescLen = buildWordFromlst$V(slice(Scheme.applyToArgs.applyN(new Object[] { usb_control_in, com.ftsafe.CCIDScheme.Lit20, com.ftsafe.CCIDScheme.Lit21, com.ftsafe.CCIDScheme.Lit22, com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit7 }), com.ftsafe.CCIDScheme.Lit16, com.ftsafe.CCIDScheme.Lit16), new Object[] { com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4 });
        return Scheme.applyToArgs.applyN(new Object[] { usb_control_in, com.ftsafe.CCIDScheme.Lit20, com.ftsafe.CCIDScheme.Lit21, com.ftsafe.CCIDScheme.Lit22, com.ftsafe.CCIDScheme.Lit1, configdescLen });
    }
    
    public static CharSequence getStringDescriptor(final Object usb_control_in, final Object index) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: bipush          6
        //     5: anewarray       Ljava/lang/Object;
        //     8: dup            
        //     9: iconst_0       
        //    10: aload_0         /* usb_control_in */
        //    11: aastore        
        //    12: dup            
        //    13: iconst_1       
        //    14: getstatic       com/ftsafe/CCIDScheme.Lit20:Lgnu/math/IntNum;
        //    17: aastore        
        //    18: dup            
        //    19: iconst_2       
        //    20: getstatic       com/ftsafe/CCIDScheme.Lit21:Lgnu/math/IntNum;
        //    23: aastore        
        //    24: dup            
        //    25: iconst_3       
        //    26: getstatic       gnu/kawa/functions/BitwiseOp.ior:Lgnu/kawa/functions/BitwiseOp;
        //    29: getstatic       com/ftsafe/CCIDScheme.Lit23:Lgnu/math/IntNum;
        //    32: aload_1         /* index */
        //    33: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    36: aastore        
        //    37: dup            
        //    38: iconst_4       
        //    39: getstatic       com/ftsafe/CCIDScheme.Lit24:Lgnu/math/IntNum;
        //    42: aastore        
        //    43: dup            
        //    44: iconst_5       
        //    45: getstatic       com/ftsafe/CCIDScheme.Lit18:Lgnu/math/IntNum;
        //    48: aastore        
        //    49: invokevirtual   gnu/mapping/Procedure.applyN:([Ljava/lang/Object;)Ljava/lang/Object;
        //    52: ldc             Lgnu/lists/Pair;.class
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    57: dup            
        //    58: astore_3       
        //    59: checkcast       Lgnu/lists/Pair;
        //    62: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    65: astore_2        /* stringLen */
        //    66: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    69: bipush          6
        //    71: anewarray       Ljava/lang/Object;
        //    74: dup            
        //    75: iconst_0       
        //    76: aload_0         /* usb_control_in */
        //    77: aastore        
        //    78: dup            
        //    79: iconst_1       
        //    80: getstatic       com/ftsafe/CCIDScheme.Lit20:Lgnu/math/IntNum;
        //    83: aastore        
        //    84: dup            
        //    85: iconst_2       
        //    86: getstatic       com/ftsafe/CCIDScheme.Lit21:Lgnu/math/IntNum;
        //    89: aastore        
        //    90: dup            
        //    91: iconst_3       
        //    92: getstatic       gnu/kawa/functions/BitwiseOp.ior:Lgnu/kawa/functions/BitwiseOp;
        //    95: getstatic       com/ftsafe/CCIDScheme.Lit23:Lgnu/math/IntNum;
        //    98: aload_1         /* index */
        //    99: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   102: aastore        
        //   103: dup            
        //   104: iconst_4       
        //   105: getstatic       com/ftsafe/CCIDScheme.Lit24:Lgnu/math/IntNum;
        //   108: aastore        
        //   109: dup            
        //   110: iconst_5       
        //   111: aload_2         /* stringLen */
        //   112: aastore        
        //   113: invokevirtual   gnu/mapping/Procedure.applyN:([Ljava/lang/Object;)Ljava/lang/Object;
        //   116: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   119: iconst_m1      
        //   120: aload_2         /* stringLen */
        //   121: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   124: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   127: invokestatic    com/ftsafe/CCIDScheme.slice:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   130: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   133: invokestatic    com/ftsafe/CCIDScheme.groupList:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   136: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   139: astore_3       
        //   140: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   143: astore          4
        //   145: aconst_null    
        //   146: astore          5
        //   148: aload_3        
        //   149: invokeinterface java/util/Iterator.hasNext:()Z
        //   154: ifeq            226
        //   157: aload_3        
        //   158: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   163: astore          6
        //   165: new             Lgnu/lists/Pair;
        //   168: dup            
        //   169: aload           6
        //   171: ldc             Lgnu/lists/Pair;.class
        //   173: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   176: dup            
        //   177: astore          8
        //   179: checkcast       Lgnu/lists/Pair;
        //   182: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   185: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   188: checkcast       Ljava/lang/Number;
        //   191: invokevirtual   java/lang/Number.intValue:()I
        //   194: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   197: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   200: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   203: aload           5
        //   205: ifnonnull       214
        //   208: dup            
        //   209: astore          4
        //   211: goto            221
        //   214: aload           5
        //   216: swap           
        //   217: dup_x1         
        //   218: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   221: astore          5
        //   223: goto            148
        //   226: aload           4
        //   228: invokestatic    kawa/lib/strings.list$To$String:(Lgnu/lists/LList;)Ljava/lang/CharSequence;
        //   231: areturn        
        //   232: new             Lgnu/mapping/WrongType;
        //   235: dup_x1         
        //   236: swap           
        //   237: ldc             "car"
        //   239: iconst_1       
        //   240: aload_3        
        //   241: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   244: athrow         
        //   245: new             Lgnu/mapping/WrongType;
        //   248: dup_x1         
        //   249: swap           
        //   250: ldc             "car"
        //   252: iconst_1       
        //   253: aload           8
        //   255: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   258: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  59     62     232    245    Ljava/lang/ClassCastException;
        //  179    182    245    259    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0214:
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
    
    public static Object getDeviceDescriptor(final Object usb_control_in) {
        return Scheme.applyToArgs.applyN(new Object[] { usb_control_in, com.ftsafe.CCIDScheme.Lit20, com.ftsafe.CCIDScheme.Lit21, com.ftsafe.CCIDScheme.Lit25, com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit26 });
    }
    
    static Object lambda5() {
        return lambda5(com.ftsafe.CCIDScheme.Lit15, com.ftsafe.CCIDScheme.Lit1);
    }
    
    static Object lambda5(final Object arg1) {
        return lambda5(arg1, com.ftsafe.CCIDScheme.Lit1);
    }
    
    static Object lambda5(final Object arg1, final Object arg2) {
        if (KawaConvert.isTrue(Scheme.isEqual.apply2(arg1, com.ftsafe.CCIDScheme.Lit15))) {
            return com.ftsafe.CCIDScheme._current_interface_;
        }
        Label_0080: {
            if (!KawaConvert.isTrue(Scheme.isEqual.apply2(arg1, com.ftsafe.CCIDScheme.Lit13))) {
                break Label_0080;
            }
            final Object[] args = { "interface", null };
            final int n = 1;
            final Object force = Promise.force(arg2, Number.class);
            try {
                args[n] = numbers.number$To$String((Number)force);
                com.ftsafe.CCIDScheme._current_interface_ = misc.string$To$Symbol(strings.stringAppend(args));
                return com.ftsafe.CCIDScheme._current_interface_;
                o = Values.empty;
                return o;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "number->string", 1, force);
            }
        }
    }
    
    public static Object parseDescriptor(final Object d) {
        return callWithInputU8vector(list$To$U8vector(d), com.ftsafe.CCIDScheme.lambda$Fn6);
    }
    
    static Object lambda6(final Object p) {
        public class CCIDScheme$frame3 extends ModuleBody
        {
            Object p;
            Procedure c;
            final ModuleMethod lambda$Fn8;
            
            public CCIDScheme$frame3() {
                final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 5, null, 8194);
                lambda$Fn8.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:178");
                this.lambda$Fn8 = lambda$Fn8;
            }
            
            static Object lambda7(final Object A, final Object B) {
                return append.append$V(new Object[] { A, LList.list1(B) });
            }
            
            Object lambda8(final Object A, final Object B) {
                final Object[] args = { A, null };
                final int n = 1;
                final Object[] args2 = new Object[2];
                final int n2 = 0;
                final Object[] args3 = { "IAD", null };
                final int n3 = 1;
                final Object force = Promise.force(this.c.apply0(), Number.class);
                try {
                    args3[n3] = numbers.number$To$String((Number)force);
                    args2[n2] = LList.list1(misc.string$To$Symbol(strings.stringAppend(args3)));
                    args2[1] = B;
                    args[n] = LList.list1(append.append$V(args2));
                    return append.append$V(args);
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "number->string", 1, force);
                }
            }
            
            public Object lambda9loop(final Object IAD$Mncontainer, final Object counter, final Object interface$Mncontainer) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: getfield        com/ftsafe/CCIDScheme$frame3.p:Ljava/lang/Object;
                //     4: astore          p
                //     6: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
                //     9: aload           p
                //    11: invokestatic    com/ftsafe/CCIDScheme.readU8s:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    14: astore          llen
                //    16: aload           llen
                //    18: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //    21: ifeq            30
                //    24: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //    27: goto            77
                //    30: aload           llen
                //    32: ldc             Lgnu/lists/Pair;.class
                //    34: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    37: dup            
                //    38: astore          7
                //    40: checkcast       Lgnu/lists/Pair;
                //    43: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    46: iconst_m1      
                //    47: aload           llen
                //    49: ldc             Lgnu/lists/Pair;.class
                //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    54: dup            
                //    55: astore          7
                //    57: checkcast       Lgnu/lists/Pair;
                //    60: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    63: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
                //    66: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    69: aload           p
                //    71: invokestatic    com/ftsafe/CCIDScheme.readU8s:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    74: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //    77: astore          l
                //    79: aload           l
                //    81: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //    84: ifne            571
                //    87: aload           l
                //    89: iconst_1       
                //    90: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
                //    93: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
                //    96: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    99: ifeq            136
                //   102: iconst_2       
                //   103: anewarray       Ljava/lang/Object;
                //   106: dup            
                //   107: iconst_0       
                //   108: getstatic       com/ftsafe/CCIDScheme.Lit28:Lgnu/lists/PairWithPosition;
                //   111: aastore        
                //   112: dup            
                //   113: iconst_1       
                //   114: aload           l
                //   116: astore          d
                //   118: aload           d
                //   120: invokestatic    com/ftsafe/CCIDScheme.list$To$U8vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
                //   123: getstatic       com/ftsafe/CCIDScheme.lambda$Fn9:Lgnu/expr/ModuleMethod;
                //   126: invokestatic    com/ftsafe/CCIDScheme.callWithInputU8vector:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   129: aastore        
                //   130: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //   133: goto            495
                //   136: aload           l
                //   138: iconst_1       
                //   139: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
                //   142: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
                //   145: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   148: ifeq            185
                //   151: iconst_2       
                //   152: anewarray       Ljava/lang/Object;
                //   155: dup            
                //   156: iconst_0       
                //   157: getstatic       com/ftsafe/CCIDScheme.Lit43:Lgnu/lists/PairWithPosition;
                //   160: aastore        
                //   161: dup            
                //   162: iconst_1       
                //   163: aload           l
                //   165: astore          d
                //   167: aload           d
                //   169: invokestatic    com/ftsafe/CCIDScheme.list$To$U8vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
                //   172: getstatic       com/ftsafe/CCIDScheme.lambda$Fn10:Lgnu/expr/ModuleMethod;
                //   175: invokestatic    com/ftsafe/CCIDScheme.callWithInputU8vector:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   178: aastore        
                //   179: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //   182: goto            495
                //   185: aload           l
                //   187: iconst_1       
                //   188: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
                //   191: getstatic       com/ftsafe/CCIDScheme.Lit18:Lgnu/math/IntNum;
                //   194: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   197: ifeq            332
                //   200: aload_3         /* interface$Mncontainer */
                //   201: ldc             Lgnu/mapping/Procedure;.class
                //   203: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   206: checkcast       Lgnu/mapping/Procedure;
                //   209: getstatic       com/ftsafe/CCIDScheme.Lit15:Lgnu/mapping/SimpleSymbol;
                //   212: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   215: astore          old_ret
                //   217: aload_3         /* interface$Mncontainer */
                //   218: ldc             Lgnu/mapping/Procedure;.class
                //   220: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   223: checkcast       Lgnu/mapping/Procedure;
                //   226: getstatic       com/ftsafe/CCIDScheme.Lit13:Lgnu/mapping/SimpleSymbol;
                //   229: iconst_2       
                //   230: anewarray       Ljava/lang/Object;
                //   233: dup            
                //   234: iconst_0       
                //   235: ldc             "interface"
                //   237: aastore        
                //   238: dup            
                //   239: iconst_1       
                //   240: aload_2         /* counter */
                //   241: ldc             Lgnu/mapping/Procedure;.class
                //   243: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   246: checkcast       Lgnu/mapping/Procedure;
                //   249: invokevirtual   gnu/mapping/Procedure.apply0:()Ljava/lang/Object;
                //   252: ldc             Ljava/lang/Number;.class
                //   254: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   257: dup            
                //   258: astore          7
                //   260: checkcast       Ljava/lang/Number;
                //   263: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
                //   266: aastore        
                //   267: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
                //   270: invokestatic    kawa/lib/misc.string$To$Symbol:(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
                //   273: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   276: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   279: pop            
                //   280: aload_3         /* interface$Mncontainer */
                //   281: ldc             Lgnu/mapping/Procedure;.class
                //   283: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   286: checkcast       Lgnu/mapping/Procedure;
                //   289: getstatic       com/ftsafe/CCIDScheme.Lit14:Lgnu/mapping/SimpleSymbol;
                //   292: iconst_2       
                //   293: anewarray       Ljava/lang/Object;
                //   296: dup            
                //   297: iconst_0       
                //   298: getstatic       com/ftsafe/CCIDScheme.Lit50:Lgnu/lists/PairWithPosition;
                //   301: aastore        
                //   302: dup            
                //   303: iconst_1       
                //   304: aload           l
                //   306: astore          d
                //   308: aload           d
                //   310: invokestatic    com/ftsafe/CCIDScheme.list$To$U8vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
                //   313: getstatic       com/ftsafe/CCIDScheme.lambda$Fn11:Lgnu/expr/ModuleMethod;
                //   316: invokestatic    com/ftsafe/CCIDScheme.callWithInputU8vector:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   319: aastore        
                //   320: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //   323: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   326: pop            
                //   327: aload           old_ret
                //   329: goto            495
                //   332: aload           l
                //   334: iconst_1       
                //   335: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
                //   338: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
                //   341: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   344: ifeq            380
                //   347: aload_3         /* interface$Mncontainer */
                //   348: ldc             Lgnu/mapping/Procedure;.class
                //   350: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   353: checkcast       Lgnu/mapping/Procedure;
                //   356: getstatic       com/ftsafe/CCIDScheme.Lit14:Lgnu/mapping/SimpleSymbol;
                //   359: aload           l
                //   361: astore          d
                //   363: aload           d
                //   365: invokestatic    com/ftsafe/CCIDScheme.list$To$U8vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
                //   368: getstatic       com/ftsafe/CCIDScheme.lambda$Fn12:Lgnu/expr/ModuleMethod;
                //   371: invokestatic    com/ftsafe/CCIDScheme.callWithInputU8vector:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   374: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   377: goto            495
                //   380: aload           l
                //   382: iconst_1       
                //   383: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
                //   386: getstatic       com/ftsafe/CCIDScheme.Lit68:Lgnu/math/IntNum;
                //   389: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   392: ifeq            444
                //   395: aload_3         /* interface$Mncontainer */
                //   396: ldc             Lgnu/mapping/Procedure;.class
                //   398: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   401: checkcast       Lgnu/mapping/Procedure;
                //   404: getstatic       com/ftsafe/CCIDScheme.Lit14:Lgnu/mapping/SimpleSymbol;
                //   407: iconst_2       
                //   408: anewarray       Ljava/lang/Object;
                //   411: dup            
                //   412: iconst_0       
                //   413: getstatic       com/ftsafe/CCIDScheme.Lit69:Lgnu/lists/PairWithPosition;
                //   416: aastore        
                //   417: dup            
                //   418: iconst_1       
                //   419: aload           l
                //   421: astore          d
                //   423: aload           d
                //   425: invokestatic    com/ftsafe/CCIDScheme.list$To$U8vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
                //   428: getstatic       com/ftsafe/CCIDScheme.lambda$Fn13:Lgnu/expr/ModuleMethod;
                //   431: invokestatic    com/ftsafe/CCIDScheme.callWithInputU8vector:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   434: aastore        
                //   435: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //   438: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   441: goto            495
                //   444: aload           l
                //   446: iconst_1       
                //   447: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
                //   450: getstatic       com/ftsafe/CCIDScheme.Lit90:Lgnu/math/IntNum;
                //   453: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   456: ifeq            492
                //   459: aload_1         /* IAD$Mncontainer */
                //   460: ldc             Lgnu/mapping/Procedure;.class
                //   462: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   465: checkcast       Lgnu/mapping/Procedure;
                //   468: getstatic       com/ftsafe/CCIDScheme.Lit14:Lgnu/mapping/SimpleSymbol;
                //   471: aload           l
                //   473: astore          d
                //   475: aload           d
                //   477: invokestatic    com/ftsafe/CCIDScheme.list$To$U8vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
                //   480: getstatic       com/ftsafe/CCIDScheme.lambda$Fn14:Lgnu/expr/ModuleMethod;
                //   483: invokestatic    com/ftsafe/CCIDScheme.callWithInputU8vector:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   486: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   489: goto            495
                //   492: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
                //   495: astore          ret
                //   497: iconst_2       
                //   498: anewarray       Ljava/lang/Object;
                //   501: dup            
                //   502: iconst_0       
                //   503: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
                //   506: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
                //   509: aload           ret
                //   511: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   514: astore          x
                //   516: aload           x
                //   518: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   521: ifeq            535
                //   524: aload           x
                //   526: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   529: ifeq            549
                //   532: goto            543
                //   535: aload           ret
                //   537: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   540: ifeq            549
                //   543: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //   546: goto            554
                //   549: aload           ret
                //   551: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   554: aastore        
                //   555: dup            
                //   556: iconst_1       
                //   557: aload_0         /* this */
                //   558: aload_1         /* IAD$Mncontainer */
                //   559: aload_2         /* counter */
                //   560: aload_3         /* interface$Mncontainer */
                //   561: invokevirtual   com/ftsafe/CCIDScheme$frame3.lambda9loop:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   564: aastore        
                //   565: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //   568: goto            690
                //   571: iconst_2       
                //   572: anewarray       Ljava/lang/Object;
                //   575: dup            
                //   576: iconst_0       
                //   577: aload_3         /* interface$Mncontainer */
                //   578: ldc             Lgnu/mapping/Procedure;.class
                //   580: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   583: checkcast       Lgnu/mapping/Procedure;
                //   586: getstatic       com/ftsafe/CCIDScheme.Lit15:Lgnu/mapping/SimpleSymbol;
                //   589: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   592: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   595: ifeq            604
                //   598: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //   601: goto            622
                //   604: aload_3         /* interface$Mncontainer */
                //   605: ldc             Lgnu/mapping/Procedure;.class
                //   607: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   610: checkcast       Lgnu/mapping/Procedure;
                //   613: getstatic       com/ftsafe/CCIDScheme.Lit15:Lgnu/mapping/SimpleSymbol;
                //   616: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   619: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   622: aastore        
                //   623: dup            
                //   624: iconst_1       
                //   625: aload_1         /* IAD$Mncontainer */
                //   626: ldc             Lgnu/mapping/Procedure;.class
                //   628: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   631: checkcast       Lgnu/mapping/Procedure;
                //   634: getstatic       com/ftsafe/CCIDScheme.Lit15:Lgnu/mapping/SimpleSymbol;
                //   637: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   640: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   643: ifeq            652
                //   646: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //   649: goto            686
                //   652: iconst_2       
                //   653: anewarray       Ljava/lang/Object;
                //   656: dup            
                //   657: iconst_0       
                //   658: getstatic       com/ftsafe/CCIDScheme.Lit97:Lgnu/lists/PairWithPosition;
                //   661: aastore        
                //   662: dup            
                //   663: iconst_1       
                //   664: aload_1         /* IAD$Mncontainer */
                //   665: ldc             Lgnu/mapping/Procedure;.class
                //   667: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   670: checkcast       Lgnu/mapping/Procedure;
                //   673: getstatic       com/ftsafe/CCIDScheme.Lit15:Lgnu/mapping/SimpleSymbol;
                //   676: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   679: aastore        
                //   680: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //   683: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   686: aastore        
                //   687: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //   690: areturn        
                //   691: new             Lgnu/mapping/WrongType;
                //   694: dup_x1         
                //   695: swap           
                //   696: ldc             "car"
                //   698: iconst_1       
                //   699: aload           7
                //   701: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   704: athrow         
                //   705: new             Lgnu/mapping/WrongType;
                //   708: dup_x1         
                //   709: swap           
                //   710: ldc             "car"
                //   712: iconst_1       
                //   713: aload           7
                //   715: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   718: athrow         
                //   719: new             Lgnu/mapping/WrongType;
                //   722: dup_x1         
                //   723: swap           
                //   724: ldc             "number->string"
                //   726: iconst_1       
                //   727: aload           7
                //   729: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   732: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  40     43     691    705    Ljava/lang/ClassCastException;
                //  57     60     705    719    Ljava/lang/ClassCastException;
                //  260    263    719    733    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 331 out of bounds for length 331
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
            
            static Object lambda10(final Object p) {
                public class CCIDScheme$frame4 extends ModuleBody
                {
                    Object p;
                    
                    public Object lambda11read$Mn1() {
                        final Object force = Promise.force(com.ftsafe.CCIDScheme.readU8s(com.ftsafe.CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)force);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "car", 1, force);
                        }
                    }
                    
                    public Object lambda12read$Mn2() {
                        return com.ftsafe.CCIDScheme.buildWordFromlst$V(com.ftsafe.CCIDScheme.readU8s(com.ftsafe.CCIDScheme.Lit16, this.p), new Object[] { com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4 });
                    }
                }
                final CCIDScheme$frame4 $heapFrame = new CCIDScheme$frame4();
                $heapFrame.p = p;
                return com.ftsafe.CCIDScheme.toList$V(LList.list2(com.ftsafe.CCIDScheme.Lit29, $heapFrame.lambda11read$Mn1()), new Object[] { LList.list2(com.ftsafe.CCIDScheme.Lit30, $heapFrame.lambda11read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit31, $heapFrame.lambda12read$Mn2()), LList.list2(com.ftsafe.CCIDScheme.Lit32, $heapFrame.lambda11read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit33, $heapFrame.lambda11read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit34, $heapFrame.lambda11read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit35, $heapFrame.lambda11read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit36, $heapFrame.lambda12read$Mn2()), LList.list2(com.ftsafe.CCIDScheme.Lit37, $heapFrame.lambda12read$Mn2()), LList.list2(com.ftsafe.CCIDScheme.Lit38, $heapFrame.lambda12read$Mn2()), LList.list2(com.ftsafe.CCIDScheme.Lit39, $heapFrame.lambda11read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit40, $heapFrame.lambda11read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit41, $heapFrame.lambda11read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit42, $heapFrame.lambda11read$Mn1()) });
            }
            
            static Object lambda13(final Object p) {
                public class CCIDScheme$frame5 extends ModuleBody
                {
                    Object p;
                    
                    public Object lambda14read$Mn1() {
                        final Object force = Promise.force(com.ftsafe.CCIDScheme.readU8s(com.ftsafe.CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)force);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "car", 1, force);
                        }
                    }
                }
                final CCIDScheme$frame5 $heapFrame = new CCIDScheme$frame5();
                $heapFrame.p = p;
                return com.ftsafe.CCIDScheme.toList$V(LList.list2(com.ftsafe.CCIDScheme.Lit29, $heapFrame.lambda14read$Mn1()), new Object[] { LList.list2(com.ftsafe.CCIDScheme.Lit30, $heapFrame.lambda14read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit44, com.ftsafe.CCIDScheme.buildWordFromlst$V(com.ftsafe.CCIDScheme.readU8s(com.ftsafe.CCIDScheme.Lit16, $heapFrame.p), new Object[] { com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4 })), LList.list2(com.ftsafe.CCIDScheme.Lit45, $heapFrame.lambda14read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit46, $heapFrame.lambda14read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit47, $heapFrame.lambda14read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit48, $heapFrame.lambda14read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit49, $heapFrame.lambda14read$Mn1()) });
            }
            
            static Object lambda15(final Object p) {
                public class CCIDScheme$frame6 extends ModuleBody
                {
                    Object p;
                    
                    public Object lambda16read$Mn1() {
                        final Object force = Promise.force(com.ftsafe.CCIDScheme.readU8s(com.ftsafe.CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)force);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "car", 1, force);
                        }
                    }
                }
                final CCIDScheme$frame6 $heapFrame = new CCIDScheme$frame6();
                $heapFrame.p = p;
                return com.ftsafe.CCIDScheme.toList$V(LList.list2(com.ftsafe.CCIDScheme.Lit29, $heapFrame.lambda16read$Mn1()), new Object[] { LList.list2(com.ftsafe.CCIDScheme.Lit30, $heapFrame.lambda16read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit51, $heapFrame.lambda16read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit52, $heapFrame.lambda16read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit53, $heapFrame.lambda16read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit54, $heapFrame.lambda16read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit55, $heapFrame.lambda16read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit56, $heapFrame.lambda16read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit57, $heapFrame.lambda16read$Mn1()) });
            }
            
            static Object lambda17(final Object p) {
                public class CCIDScheme$frame7 extends ModuleBody
                {
                    Object p;
                    
                    public Object lambda18read$Mn1() {
                        final Object force = Promise.force(com.ftsafe.CCIDScheme.readU8s(com.ftsafe.CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)force);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "car", 1, force);
                        }
                    }
                }
                final CCIDScheme$frame7 $heapFrame = new CCIDScheme$frame7();
                $heapFrame.p = p;
                final Object _tmp = com.ftsafe.CCIDScheme.toList$V(LList.list2(com.ftsafe.CCIDScheme.Lit29, $heapFrame.lambda18read$Mn1()), new Object[] { LList.list2(com.ftsafe.CCIDScheme.Lit30, $heapFrame.lambda18read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit59, $heapFrame.lambda18read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit48, $heapFrame.lambda18read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit60, com.ftsafe.CCIDScheme.buildWordFromlst$V(com.ftsafe.CCIDScheme.readU8s(com.ftsafe.CCIDScheme.Lit16, $heapFrame.p), new Object[] { com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4 })), LList.list2(com.ftsafe.CCIDScheme.Lit61, $heapFrame.lambda18read$Mn1()) });
                return (KawaConvert.isTrue(Scheme.isEqual.apply2(lists.assoc(com.ftsafe.CCIDScheme.Lit48, _tmp), com.ftsafe.CCIDScheme.Lit62)) && KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit59, _tmp)), com.ftsafe.CCIDScheme.Lit20), com.ftsafe.CCIDScheme.Lit20))) ? append.append$V(new Object[] { com.ftsafe.CCIDScheme.Lit63, _tmp }) : ((KawaConvert.isTrue(Scheme.isEqual.apply2(lists.assoc(com.ftsafe.CCIDScheme.Lit48, _tmp), com.ftsafe.CCIDScheme.Lit64)) && KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit59, _tmp)), com.ftsafe.CCIDScheme.Lit20), com.ftsafe.CCIDScheme.Lit20))) ? append.append$V(new Object[] { com.ftsafe.CCIDScheme.Lit65, _tmp }) : ((KawaConvert.isTrue(Scheme.isEqual.apply2(lists.assoc(com.ftsafe.CCIDScheme.Lit48, _tmp), com.ftsafe.CCIDScheme.Lit64)) && KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit59, _tmp)), com.ftsafe.CCIDScheme.Lit20), com.ftsafe.CCIDScheme.Lit1))) ? append.append$V(new Object[] { com.ftsafe.CCIDScheme.Lit66, _tmp }) : append.append$V(new Object[] { com.ftsafe.CCIDScheme.Lit67, _tmp })));
            }
            
            static Object lambda19(final Object p) {
                public class CCIDScheme$frame8 extends ModuleBody
                {
                    Object p;
                    
                    public Object lambda20read$Mn1() {
                        final Object force = Promise.force(com.ftsafe.CCIDScheme.readU8s(com.ftsafe.CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)force);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "car", 1, force);
                        }
                    }
                    
                    public Object lambda21read$Mn2() {
                        return com.ftsafe.CCIDScheme.buildWordFromlst$V(com.ftsafe.CCIDScheme.readU8s(com.ftsafe.CCIDScheme.Lit16, this.p), new Object[] { com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4 });
                    }
                    
                    public Object lambda22read$Mn4() {
                        return com.ftsafe.CCIDScheme.buildDwordFromlst$V(com.ftsafe.CCIDScheme.readU8s(com.ftsafe.CCIDScheme.Lit18, this.p), new Object[] { com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4 });
                    }
                }
                final CCIDScheme$frame8 $heapFrame = new CCIDScheme$frame8();
                $heapFrame.p = p;
                return com.ftsafe.CCIDScheme.toList$V(LList.list2(com.ftsafe.CCIDScheme.Lit29, $heapFrame.lambda20read$Mn1()), new Object[] { LList.list2(com.ftsafe.CCIDScheme.Lit30, $heapFrame.lambda20read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit70, $heapFrame.lambda21read$Mn2()), LList.list2(com.ftsafe.CCIDScheme.Lit71, $heapFrame.lambda20read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit72, $heapFrame.lambda20read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit73, $heapFrame.lambda22read$Mn4()), LList.list2(com.ftsafe.CCIDScheme.Lit74, $heapFrame.lambda22read$Mn4()), LList.list2(com.ftsafe.CCIDScheme.Lit75, $heapFrame.lambda22read$Mn4()), LList.list2(com.ftsafe.CCIDScheme.Lit76, $heapFrame.lambda20read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit77, $heapFrame.lambda22read$Mn4()), LList.list2(com.ftsafe.CCIDScheme.Lit78, $heapFrame.lambda22read$Mn4()), LList.list2(com.ftsafe.CCIDScheme.Lit79, $heapFrame.lambda20read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit80, $heapFrame.lambda22read$Mn4()), LList.list2(com.ftsafe.CCIDScheme.Lit81, $heapFrame.lambda22read$Mn4()), LList.list2(com.ftsafe.CCIDScheme.Lit82, $heapFrame.lambda22read$Mn4()), LList.list2(com.ftsafe.CCIDScheme.Lit83, $heapFrame.lambda22read$Mn4()), LList.list2(com.ftsafe.CCIDScheme.Lit84, $heapFrame.lambda22read$Mn4()), LList.list2(com.ftsafe.CCIDScheme.Lit85, $heapFrame.lambda20read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit86, $heapFrame.lambda20read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit87, $heapFrame.lambda21read$Mn2()), LList.list2(com.ftsafe.CCIDScheme.Lit88, $heapFrame.lambda20read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit89, $heapFrame.lambda20read$Mn1()) });
            }
            
            static Object lambda23(final Object p) {
                public class CCIDScheme$frame9 extends ModuleBody
                {
                    Object p;
                    
                    public Object lambda24read$Mn1() {
                        final Object force = Promise.force(com.ftsafe.CCIDScheme.readU8s(com.ftsafe.CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)force);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "car", 1, force);
                        }
                    }
                }
                final CCIDScheme$frame9 $heapFrame = new CCIDScheme$frame9();
                $heapFrame.p = p;
                return com.ftsafe.CCIDScheme.toList$V(LList.list2(com.ftsafe.CCIDScheme.Lit29, $heapFrame.lambda24read$Mn1()), new Object[] { LList.list2(com.ftsafe.CCIDScheme.Lit30, $heapFrame.lambda24read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit91, $heapFrame.lambda24read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit92, $heapFrame.lambda24read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit93, $heapFrame.lambda24read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit94, $heapFrame.lambda24read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit95, $heapFrame.lambda24read$Mn1()), LList.list2(com.ftsafe.CCIDScheme.Lit96, $heapFrame.lambda24read$Mn1()) });
            }
            
            @Override
            public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                if (moduleMethod.selector == 5) {
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
                if (method.selector == 5) {
                    return this.lambda8(o, o2);
                }
                return super.apply2(method, o, o2);
            }
        }
        final CCIDScheme$frame3 $heapFrame = new CCIDScheme$frame3();
        $heapFrame.p = p;
        final Procedure counter = makeCounter();
        final Procedure interface$Mncontainer = makeContainer(com.ftsafe.CCIDScheme.lambda$Fn7);
        $heapFrame.c = makeCounter();
        final Procedure IAD$Mncontainer = makeContainer($heapFrame.lambda$Fn8);
        interface$Mncontainer.apply2(com.ftsafe.CCIDScheme.Lit13, LList.Empty);
        IAD$Mncontainer.apply2(com.ftsafe.CCIDScheme.Lit13, LList.Empty);
        return $heapFrame.lambda9loop(IAD$Mncontainer, counter, interface$Mncontainer);
    }
    
    public static IntNum getVoltageSupportFromDescriptor(final Object desc) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       com/ftsafe/CCIDScheme.current_dev_interface:Lgnu/mapping/Procedure;
        //     6: invokevirtual   gnu/mapping/Procedure.apply0:()Ljava/lang/Object;
        //     9: aload_0         /* desc */
        //    10: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    13: ldc             Lgnu/lists/Pair;.class
        //    15: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    18: dup            
        //    19: astore_2       
        //    20: checkcast       Lgnu/lists/Pair;
        //    23: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    26: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    29: ldc             Lgnu/lists/Pair;.class
        //    31: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    34: dup            
        //    35: astore_2       
        //    36: checkcast       Lgnu/lists/Pair;
        //    39: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    42: astore_1        /* ccid_desc */
        //    43: getstatic       com/ftsafe/CCIDScheme.Lit83:Lgnu/mapping/SimpleSymbol;
        //    46: aload_1         /* ccid_desc */
        //    47: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    50: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    53: astore_2        /* dwFeatures */
        //    54: getstatic       com/ftsafe/CCIDScheme.Lit72:Lgnu/mapping/SimpleSymbol;
        //    57: aload_1         /* ccid_desc */
        //    58: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    61: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    64: astore_3        /* bVoltageSupport */
        //    65: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    68: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //    71: aload_2         /* dwFeatures */
        //    72: getstatic       com/ftsafe/CCIDScheme.Lit7:Lgnu/math/IntNum;
        //    75: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    78: getstatic       com/ftsafe/CCIDScheme.Lit7:Lgnu/math/IntNum;
        //    81: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    84: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    87: ifeq            96
        //    90: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //    93: goto            192
        //    96: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    99: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   102: aload_3         /* bVoltageSupport */
        //   103: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   106: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   109: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   112: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   115: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   118: ifeq            127
        //   121: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   124: goto            192
        //   127: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   130: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   133: aload_3         /* bVoltageSupport */
        //   134: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   137: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   140: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   143: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   146: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   149: ifeq            158
        //   152: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   155: goto            192
        //   158: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   161: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   164: aload_3         /* bVoltageSupport */
        //   165: getstatic       com/ftsafe/CCIDScheme.Lit18:Lgnu/math/IntNum;
        //   168: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   171: getstatic       com/ftsafe/CCIDScheme.Lit18:Lgnu/math/IntNum;
        //   174: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   177: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   180: ifeq            189
        //   183: getstatic       com/ftsafe/CCIDScheme.Lit99:Lgnu/math/IntNum;
        //   186: goto            192
        //   189: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   192: areturn        
        //   193: new             Lgnu/mapping/WrongType;
        //   196: dup_x1         
        //   197: swap           
        //   198: ldc             "cdr"
        //   200: iconst_1       
        //   201: aload_2        
        //   202: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   205: athrow         
        //   206: new             Lgnu/mapping/WrongType;
        //   209: dup_x1         
        //   210: swap           
        //   211: ldc             "cdr"
        //   213: iconst_1       
        //   214: aload_2        
        //   215: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   218: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  20     23     193    206    Ljava/lang/ClassCastException;
        //  36     39     206    219    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0096:
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
    
    public static Object getBSeq() {
        return getBSeq(com.ftsafe.CCIDScheme.Lit100);
    }
    
    public static Object getBSeq(final Object op) {
        Object o;
        if (KawaConvert.isTrue(Scheme.isEqual.apply2(op, com.ftsafe.CCIDScheme.Lit100))) {
            final Object nextseq = AddOp.apply2(1, com.ftsafe.CCIDScheme._ccid_bSeq_, com.ftsafe.CCIDScheme.Lit2);
            com.ftsafe.CCIDScheme._ccid_bSeq_ = (NumberCompare.$Gr$Eq(nextseq, com.ftsafe.CCIDScheme.Lit25) ? com.ftsafe.CCIDScheme.Lit1 : nextseq);
            o = com.ftsafe.CCIDScheme._ccid_bSeq_;
        }
        else {
            o = com.ftsafe.CCIDScheme._ccid_bSeq_;
        }
        return o;
    }
    
    public static FString getBStatusBErrorErrorName(final Object bStatus, final Object bError) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_0         /* bStatus */
        //     4: getstatic       com/ftsafe/CCIDScheme.Lit99:Lgnu/math/IntNum;
        //     7: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    10: astore_2       
        //    11: getstatic       gnu/kawa/functions/BitwiseOp.ashift:Lgnu/kawa/functions/BitwiseOp;
        //    14: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //    17: aload_0         /* bStatus */
        //    18: getstatic       com/ftsafe/CCIDScheme.Lit101:Lgnu/math/IntNum;
        //    21: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    24: getstatic       com/ftsafe/CCIDScheme.Lit102:Lgnu/math/IntNum;
        //    27: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    30: astore_3        /* bmCommandStatus */
        //    31: bipush          10
        //    33: anewarray       Ljava/lang/Object;
        //    36: dup            
        //    37: iconst_0       
        //    38: ldc_w           "bmICCStatus="
        //    41: aastore        
        //    42: dup            
        //    43: iconst_1       
        //    44: aload_2         /* bmICCStatus */
        //    45: ldc             Ljava/lang/Number;.class
        //    47: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    50: dup            
        //    51: astore          4
        //    53: checkcast       Ljava/lang/Number;
        //    56: bipush          10
        //    58: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;I)Ljava/lang/CharSequence;
        //    61: aastore        
        //    62: dup            
        //    63: iconst_2       
        //    64: ldc_w           " "
        //    67: aastore        
        //    68: dup            
        //    69: iconst_3       
        //    70: ldc_w           "bmCommandStatus="
        //    73: aastore        
        //    74: dup            
        //    75: iconst_4       
        //    76: aload_3         /* bmCommandStatus */
        //    77: ldc             Ljava/lang/Number;.class
        //    79: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    82: dup            
        //    83: astore          4
        //    85: checkcast       Ljava/lang/Number;
        //    88: bipush          10
        //    90: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;I)Ljava/lang/CharSequence;
        //    93: aastore        
        //    94: dup            
        //    95: iconst_5       
        //    96: ldc_w           " "
        //    99: aastore        
        //   100: dup            
        //   101: bipush          6
        //   103: ldc_w           "bError="
        //   106: aastore        
        //   107: dup            
        //   108: bipush          7
        //   110: aload_1         /* bError */
        //   111: ldc             Ljava/lang/Number;.class
        //   113: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   116: dup            
        //   117: astore          4
        //   119: checkcast       Ljava/lang/Number;
        //   122: bipush          16
        //   124: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;I)Ljava/lang/CharSequence;
        //   127: aastore        
        //   128: dup            
        //   129: bipush          8
        //   131: ldc_w           " : "
        //   134: aastore        
        //   135: dup            
        //   136: bipush          9
        //   138: aload_2         /* bmICCStatus */
        //   139: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   142: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   145: ifeq            174
        //   148: aload_3         /* bmCommandStatus */
        //   149: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   152: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   155: ifeq            174
        //   158: aload_1         /* bError */
        //   159: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //   162: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   165: ifeq            174
        //   168: ldc_w           "bSlot does not exist"
        //   171: goto            4165
        //   174: aload_2         /* bmICCStatus */
        //   175: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   178: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   181: ifeq            210
        //   184: aload_3         /* bmCommandStatus */
        //   185: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   188: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   191: ifeq            210
        //   194: aload_1         /* bError */
        //   195: getstatic       com/ftsafe/CCIDScheme.Lit103:Lgnu/math/IntNum;
        //   198: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   201: ifeq            210
        //   204: ldc_w           "No ICC present"
        //   207: goto            4165
        //   210: aload_2         /* bmICCStatus */
        //   211: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   214: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   217: ifeq            246
        //   220: aload_3         /* bmCommandStatus */
        //   221: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   224: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   227: ifeq            246
        //   230: aload_1         /* bError */
        //   231: getstatic       com/ftsafe/CCIDScheme.Lit104:Lgnu/math/IntNum;
        //   234: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   237: ifeq            246
        //   240: ldc_w           "Hardware error"
        //   243: goto            4165
        //   246: aload_2         /* bmICCStatus */
        //   247: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   250: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   253: ifeq            282
        //   256: aload_3         /* bmCommandStatus */
        //   257: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   260: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   263: ifeq            282
        //   266: aload_1         /* bError */
        //   267: getstatic       com/ftsafe/CCIDScheme.Lit105:Lgnu/math/IntNum;
        //   270: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   273: ifeq            282
        //   276: ldc_w           "bPowerselect error (not supported)"
        //   279: goto            4165
        //   282: aload_2         /* bmICCStatus */
        //   283: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   286: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   289: ifeq            318
        //   292: aload_3         /* bmCommandStatus */
        //   293: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   296: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   299: ifeq            318
        //   302: aload_1         /* bError */
        //   303: getstatic       com/ftsafe/CCIDScheme.Lit106:Lgnu/math/IntNum;
        //   306: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   309: ifeq            318
        //   312: ldc_w           "parity error on ATR"
        //   315: goto            4165
        //   318: aload_2         /* bmICCStatus */
        //   319: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   322: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   325: ifeq            354
        //   328: aload_3         /* bmCommandStatus */
        //   329: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   332: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   335: ifeq            354
        //   338: aload_1         /* bError */
        //   339: getstatic       com/ftsafe/CCIDScheme.Lit103:Lgnu/math/IntNum;
        //   342: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   345: ifeq            354
        //   348: ldc_w           "ICC mute (Time out)"
        //   351: goto            4165
        //   354: aload_2         /* bmICCStatus */
        //   355: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   358: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   361: ifeq            390
        //   364: aload_3         /* bmCommandStatus */
        //   365: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   368: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   371: ifeq            390
        //   374: aload_1         /* bError */
        //   375: getstatic       com/ftsafe/CCIDScheme.Lit107:Lgnu/math/IntNum;
        //   378: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   381: ifeq            390
        //   384: ldc_w           "Bad TS in ATR"
        //   387: goto            4165
        //   390: aload_2         /* bmICCStatus */
        //   391: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   394: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   397: ifeq            426
        //   400: aload_3         /* bmCommandStatus */
        //   401: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   404: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   407: ifeq            426
        //   410: aload_1         /* bError */
        //   411: getstatic       com/ftsafe/CCIDScheme.Lit108:Lgnu/math/IntNum;
        //   414: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   417: ifeq            426
        //   420: ldc_w           "Bad TCK in ATR"
        //   423: goto            4165
        //   426: aload_2         /* bmICCStatus */
        //   427: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   430: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   433: ifeq            462
        //   436: aload_3         /* bmCommandStatus */
        //   437: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   440: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   443: ifeq            462
        //   446: aload_1         /* bError */
        //   447: getstatic       com/ftsafe/CCIDScheme.Lit109:Lgnu/math/IntNum;
        //   450: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   453: ifeq            462
        //   456: ldc_w           "Protocol not managed"
        //   459: goto            4165
        //   462: aload_2         /* bmICCStatus */
        //   463: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   466: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   469: ifeq            498
        //   472: aload_3         /* bmCommandStatus */
        //   473: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   476: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   479: ifeq            498
        //   482: aload_1         /* bError */
        //   483: getstatic       com/ftsafe/CCIDScheme.Lit110:Lgnu/math/IntNum;
        //   486: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   489: ifeq            498
        //   492: ldc_w           "ICC class not supported"
        //   495: goto            4165
        //   498: aload_2         /* bmICCStatus */
        //   499: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   502: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   505: ifeq            534
        //   508: aload_3         /* bmCommandStatus */
        //   509: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   512: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   515: ifeq            534
        //   518: aload_1         /* bError */
        //   519: getstatic       com/ftsafe/CCIDScheme.Lit9:Lgnu/math/IntNum;
        //   522: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   525: ifeq            534
        //   528: ldc_w           "Command aborted by control pipe"
        //   531: goto            4165
        //   534: aload_2         /* bmICCStatus */
        //   535: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   538: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   541: ifeq            570
        //   544: aload_3         /* bmCommandStatus */
        //   545: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   548: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   551: ifeq            570
        //   554: aload_1         /* bError */
        //   555: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   558: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   561: ifeq            570
        //   564: ldc_w           "Command Not Supported"
        //   567: goto            4165
        //   570: aload_2         /* bmICCStatus */
        //   571: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   574: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   577: istore          x
        //   579: iload           x
        //   581: ifeq            592
        //   584: iload           x
        //   586: ifeq            650
        //   589: goto            624
        //   592: aload_2         /* bmICCStatus */
        //   593: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   596: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   599: istore          x
        //   601: iload           x
        //   603: ifeq            614
        //   606: iload           x
        //   608: ifeq            650
        //   611: goto            624
        //   614: aload_2         /* bmICCStatus */
        //   615: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   618: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   621: ifeq            650
        //   624: aload_3         /* bmCommandStatus */
        //   625: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   628: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   631: ifeq            650
        //   634: aload_1         /* bError */
        //   635: getstatic       com/ftsafe/CCIDScheme.Lit111:Lgnu/math/IntNum;
        //   638: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   641: ifeq            650
        //   644: ldc_w           "CMD_SLOT_BUSY"
        //   647: goto            4165
        //   650: aload_2         /* bmICCStatus */
        //   651: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   654: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   657: ifeq            686
        //   660: aload_3         /* bmCommandStatus */
        //   661: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   664: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   667: ifeq            686
        //   670: aload_1         /* bError */
        //   671: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //   674: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   677: ifeq            686
        //   680: ldc_w           "bSlot does not exist"
        //   683: goto            4165
        //   686: aload_2         /* bmICCStatus */
        //   687: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   690: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   693: ifeq            722
        //   696: aload_3         /* bmCommandStatus */
        //   697: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   700: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   703: ifeq            722
        //   706: aload_1         /* bError */
        //   707: getstatic       com/ftsafe/CCIDScheme.Lit112:Lgnu/math/IntNum;
        //   710: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   713: ifeq            722
        //   716: ldc_w           "Automatic sequence on-going"
        //   719: goto            4165
        //   722: aload_2         /* bmICCStatus */
        //   723: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   726: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   729: ifeq            758
        //   732: aload_3         /* bmCommandStatus */
        //   733: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   736: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   739: ifeq            758
        //   742: aload_1         /* bError */
        //   743: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   746: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   749: ifeq            758
        //   752: ldc_w           "Command Not Supported"
        //   755: goto            4165
        //   758: aload_2         /* bmICCStatus */
        //   759: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   762: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   765: istore          x
        //   767: iload           x
        //   769: ifeq            780
        //   772: iload           x
        //   774: ifeq            838
        //   777: goto            812
        //   780: aload_2         /* bmICCStatus */
        //   781: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   784: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   787: istore          x
        //   789: iload           x
        //   791: ifeq            802
        //   794: iload           x
        //   796: ifeq            838
        //   799: goto            812
        //   802: aload_2         /* bmICCStatus */
        //   803: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   806: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   809: ifeq            838
        //   812: aload_3         /* bmCommandStatus */
        //   813: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   816: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   819: ifeq            838
        //   822: aload_1         /* bError */
        //   823: getstatic       com/ftsafe/CCIDScheme.Lit111:Lgnu/math/IntNum;
        //   826: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   829: ifeq            838
        //   832: ldc_w           "CMD_SLOT_BUSY"
        //   835: goto            4165
        //   838: aload_2         /* bmICCStatus */
        //   839: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   842: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   845: ifeq            874
        //   848: aload_3         /* bmCommandStatus */
        //   849: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   852: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   855: ifeq            874
        //   858: aload_1         /* bError */
        //   859: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //   862: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   865: ifeq            874
        //   868: ldc_w           "bSlot does not exist"
        //   871: goto            4165
        //   874: aload_2         /* bmICCStatus */
        //   875: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   878: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   881: ifeq            910
        //   884: aload_3         /* bmCommandStatus */
        //   885: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   888: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   891: ifeq            910
        //   894: aload_1         /* bError */
        //   895: getstatic       com/ftsafe/CCIDScheme.Lit103:Lgnu/math/IntNum;
        //   898: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   901: ifeq            910
        //   904: ldc_w           "No ICC present"
        //   907: goto            4165
        //   910: aload_2         /* bmICCStatus */
        //   911: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   914: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   917: ifeq            946
        //   920: aload_3         /* bmCommandStatus */
        //   921: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   924: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   927: ifeq            946
        //   930: aload_1         /* bError */
        //   931: getstatic       com/ftsafe/CCIDScheme.Lit104:Lgnu/math/IntNum;
        //   934: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   937: ifeq            946
        //   940: ldc_w           "Hardware error"
        //   943: goto            4165
        //   946: aload_2         /* bmICCStatus */
        //   947: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   950: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   953: ifeq            982
        //   956: aload_3         /* bmCommandStatus */
        //   957: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   960: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   963: ifeq            982
        //   966: aload_1         /* bError */
        //   967: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   970: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   973: ifeq            982
        //   976: ldc_w           "Command Not Supported"
        //   979: goto            4165
        //   982: aload_2         /* bmICCStatus */
        //   983: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   986: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   989: istore          x
        //   991: iload           x
        //   993: ifeq            1004
        //   996: iload           x
        //   998: ifeq            1062
        //  1001: goto            1036
        //  1004: aload_2         /* bmICCStatus */
        //  1005: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1008: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1011: istore          x
        //  1013: iload           x
        //  1015: ifeq            1026
        //  1018: iload           x
        //  1020: ifeq            1062
        //  1023: goto            1036
        //  1026: aload_2         /* bmICCStatus */
        //  1027: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  1030: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1033: ifeq            1062
        //  1036: aload_3         /* bmCommandStatus */
        //  1037: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1040: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1043: ifeq            1062
        //  1046: aload_1         /* bError */
        //  1047: getstatic       com/ftsafe/CCIDScheme.Lit111:Lgnu/math/IntNum;
        //  1050: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1053: ifeq            1062
        //  1056: ldc_w           "CMD_SLOT_BUSY"
        //  1059: goto            4165
        //  1062: aload_2         /* bmICCStatus */
        //  1063: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  1066: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1069: ifeq            1098
        //  1072: aload_3         /* bmCommandStatus */
        //  1073: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1076: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1079: ifeq            1098
        //  1082: aload_1         /* bError */
        //  1083: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //  1086: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1089: ifeq            1098
        //  1092: ldc_w           "bSlot does not exist"
        //  1095: goto            4165
        //  1098: aload_2         /* bmICCStatus */
        //  1099: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  1102: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1105: ifeq            1134
        //  1108: aload_3         /* bmCommandStatus */
        //  1109: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1112: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1115: ifeq            1134
        //  1118: aload_1         /* bError */
        //  1119: getstatic       com/ftsafe/CCIDScheme.Lit103:Lgnu/math/IntNum;
        //  1122: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1125: ifeq            1134
        //  1128: ldc_w           "No ICC present"
        //  1131: goto            4165
        //  1134: aload_2         /* bmICCStatus */
        //  1135: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1138: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1141: ifeq            1170
        //  1144: aload_3         /* bmCommandStatus */
        //  1145: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1148: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1151: ifeq            1170
        //  1154: aload_1         /* bError */
        //  1155: getstatic       com/ftsafe/CCIDScheme.Lit112:Lgnu/math/IntNum;
        //  1158: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1161: ifeq            1170
        //  1164: ldc_w           "Automatic sequence on-going"
        //  1167: goto            4165
        //  1170: aload_2         /* bmICCStatus */
        //  1171: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1174: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1177: ifeq            1206
        //  1180: aload_3         /* bmCommandStatus */
        //  1181: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1184: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1187: ifeq            1206
        //  1190: aload_1         /* bError */
        //  1191: getstatic       com/ftsafe/CCIDScheme.Lit104:Lgnu/math/IntNum;
        //  1194: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1197: ifeq            1206
        //  1200: ldc_w           "Hardware error"
        //  1203: goto            4165
        //  1206: aload_2         /* bmICCStatus */
        //  1207: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1210: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1213: ifeq            1242
        //  1216: aload_3         /* bmCommandStatus */
        //  1217: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1220: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1223: ifeq            1242
        //  1226: aload_1         /* bError */
        //  1227: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1230: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1233: ifeq            1242
        //  1236: ldc_w           "Command Not Supported"
        //  1239: goto            4165
        //  1242: aload_2         /* bmICCStatus */
        //  1243: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1246: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1249: istore          x
        //  1251: iload           x
        //  1253: ifeq            1264
        //  1256: iload           x
        //  1258: ifeq            1322
        //  1261: goto            1296
        //  1264: aload_2         /* bmICCStatus */
        //  1265: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1268: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1271: istore          x
        //  1273: iload           x
        //  1275: ifeq            1286
        //  1278: iload           x
        //  1280: ifeq            1322
        //  1283: goto            1296
        //  1286: aload_2         /* bmICCStatus */
        //  1287: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  1290: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1293: ifeq            1322
        //  1296: aload_3         /* bmCommandStatus */
        //  1297: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1300: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1303: ifeq            1322
        //  1306: aload_1         /* bError */
        //  1307: getstatic       com/ftsafe/CCIDScheme.Lit111:Lgnu/math/IntNum;
        //  1310: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1313: ifeq            1322
        //  1316: ldc_w           "CMD_SLOT_BUSY"
        //  1319: goto            4165
        //  1322: aload_2         /* bmICCStatus */
        //  1323: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1326: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1329: ifeq            1358
        //  1332: aload_3         /* bmCommandStatus */
        //  1333: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1336: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1339: ifeq            1358
        //  1342: aload_1         /* bError */
        //  1343: getstatic       com/ftsafe/CCIDScheme.Lit105:Lgnu/math/IntNum;
        //  1346: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1349: ifeq            1358
        //  1352: ldc_w           "bPowerselect error (not supported)"
        //  1355: goto            4165
        //  1358: aload_2         /* bmICCStatus */
        //  1359: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1362: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1365: ifeq            1394
        //  1368: aload_3         /* bmCommandStatus */
        //  1369: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1372: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1375: ifeq            1394
        //  1378: aload_1         /* bError */
        //  1379: getstatic       com/ftsafe/CCIDScheme.Lit106:Lgnu/math/IntNum;
        //  1382: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1385: ifeq            1394
        //  1388: ldc_w           "parity error"
        //  1391: goto            4165
        //  1394: aload_2         /* bmICCStatus */
        //  1395: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1398: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1401: ifeq            1430
        //  1404: aload_3         /* bmCommandStatus */
        //  1405: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1408: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1411: ifeq            1430
        //  1414: aload_1         /* bError */
        //  1415: getstatic       com/ftsafe/CCIDScheme.Lit113:Lgnu/math/IntNum;
        //  1418: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1421: ifeq            1430
        //  1424: ldc_w           "XFR_OVERRUN"
        //  1427: goto            4165
        //  1430: aload_2         /* bmICCStatus */
        //  1431: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1434: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1437: ifeq            1466
        //  1440: aload_3         /* bmCommandStatus */
        //  1441: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1444: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1447: ifeq            1466
        //  1450: aload_1         /* bError */
        //  1451: getstatic       com/ftsafe/CCIDScheme.Lit103:Lgnu/math/IntNum;
        //  1454: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1457: ifeq            1466
        //  1460: ldc_w           "ICC mute (Time out)"
        //  1463: goto            4165
        //  1466: aload_2         /* bmICCStatus */
        //  1467: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1470: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1473: ifeq            1502
        //  1476: aload_3         /* bmCommandStatus */
        //  1477: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1480: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1483: ifeq            1502
        //  1486: aload_1         /* bError */
        //  1487: getstatic       com/ftsafe/CCIDScheme.Lit7:Lgnu/math/IntNum;
        //  1490: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1493: ifeq            1502
        //  1496: ldc_w           "Bad wLevelParameter"
        //  1499: goto            4165
        //  1502: aload_2         /* bmICCStatus */
        //  1503: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1506: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1509: ifeq            1538
        //  1512: aload_3         /* bmCommandStatus */
        //  1513: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1516: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1519: ifeq            1538
        //  1522: aload_1         /* bError */
        //  1523: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1526: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1529: ifeq            1538
        //  1532: ldc_w           "Bad dwLength"
        //  1535: goto            4165
        //  1538: aload_2         /* bmICCStatus */
        //  1539: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1542: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1545: ifeq            1574
        //  1548: aload_3         /* bmCommandStatus */
        //  1549: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1552: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1555: ifeq            1574
        //  1558: aload_1         /* bError */
        //  1559: getstatic       com/ftsafe/CCIDScheme.Lit9:Lgnu/math/IntNum;
        //  1562: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1565: ifeq            1574
        //  1568: ldc_w           "Command aborted by control pipe"
        //  1571: goto            4165
        //  1574: aload_2         /* bmICCStatus */
        //  1575: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  1578: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1581: ifeq            1610
        //  1584: aload_3         /* bmCommandStatus */
        //  1585: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1588: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1591: ifeq            1610
        //  1594: aload_1         /* bError */
        //  1595: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //  1598: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1601: ifeq            1610
        //  1604: ldc_w           "bSlot does not exist"
        //  1607: goto            4165
        //  1610: aload_2         /* bmICCStatus */
        //  1611: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  1614: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1617: ifeq            1646
        //  1620: aload_3         /* bmCommandStatus */
        //  1621: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1624: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1627: ifeq            1646
        //  1630: aload_1         /* bError */
        //  1631: getstatic       com/ftsafe/CCIDScheme.Lit103:Lgnu/math/IntNum;
        //  1634: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1637: ifeq            1646
        //  1640: ldc_w           "No ICC present"
        //  1643: goto            4165
        //  1646: aload_2         /* bmICCStatus */
        //  1647: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1650: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1653: ifeq            1682
        //  1656: aload_3         /* bmCommandStatus */
        //  1657: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1660: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1663: ifeq            1682
        //  1666: aload_1         /* bError */
        //  1667: getstatic       com/ftsafe/CCIDScheme.Lit112:Lgnu/math/IntNum;
        //  1670: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1673: ifeq            1682
        //  1676: ldc_w           "Automatic sequence on-going"
        //  1679: goto            4165
        //  1682: aload_2         /* bmICCStatus */
        //  1683: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1686: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1689: ifeq            1718
        //  1692: aload_3         /* bmCommandStatus */
        //  1693: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1696: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1699: ifeq            1718
        //  1702: aload_1         /* bError */
        //  1703: getstatic       com/ftsafe/CCIDScheme.Lit104:Lgnu/math/IntNum;
        //  1706: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1709: ifeq            1718
        //  1712: ldc_w           "Hardware error"
        //  1715: goto            4165
        //  1718: aload_2         /* bmICCStatus */
        //  1719: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1722: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1725: ifeq            1754
        //  1728: aload_3         /* bmCommandStatus */
        //  1729: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1732: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1735: ifeq            1754
        //  1738: aload_1         /* bError */
        //  1739: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1742: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1745: ifeq            1754
        //  1748: ldc_w           "Command Not Supported"
        //  1751: goto            4165
        //  1754: aload_2         /* bmICCStatus */
        //  1755: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1758: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1761: istore          x
        //  1763: iload           x
        //  1765: ifeq            1776
        //  1768: iload           x
        //  1770: ifeq            1834
        //  1773: goto            1808
        //  1776: aload_2         /* bmICCStatus */
        //  1777: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1780: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1783: istore          x
        //  1785: iload           x
        //  1787: ifeq            1798
        //  1790: iload           x
        //  1792: ifeq            1834
        //  1795: goto            1808
        //  1798: aload_2         /* bmICCStatus */
        //  1799: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  1802: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1805: ifeq            1834
        //  1808: aload_3         /* bmCommandStatus */
        //  1809: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1812: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1815: ifeq            1834
        //  1818: aload_1         /* bError */
        //  1819: getstatic       com/ftsafe/CCIDScheme.Lit111:Lgnu/math/IntNum;
        //  1822: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1825: ifeq            1834
        //  1828: ldc_w           "CMD_SLOT_BUSY"
        //  1831: goto            4165
        //  1834: aload_2         /* bmICCStatus */
        //  1835: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  1838: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1841: ifeq            1870
        //  1844: aload_3         /* bmCommandStatus */
        //  1845: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1848: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1851: ifeq            1870
        //  1854: aload_1         /* bError */
        //  1855: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //  1858: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1861: ifeq            1870
        //  1864: ldc_w           "bSlot does not exist"
        //  1867: goto            4165
        //  1870: aload_2         /* bmICCStatus */
        //  1871: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  1874: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1877: ifeq            1906
        //  1880: aload_3         /* bmCommandStatus */
        //  1881: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1884: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1887: ifeq            1906
        //  1890: aload_1         /* bError */
        //  1891: getstatic       com/ftsafe/CCIDScheme.Lit103:Lgnu/math/IntNum;
        //  1894: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1897: ifeq            1906
        //  1900: ldc_w           "No ICC present"
        //  1903: goto            4165
        //  1906: aload_2         /* bmICCStatus */
        //  1907: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1910: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1913: ifeq            1942
        //  1916: aload_3         /* bmCommandStatus */
        //  1917: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1920: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1923: ifeq            1942
        //  1926: aload_1         /* bError */
        //  1927: getstatic       com/ftsafe/CCIDScheme.Lit112:Lgnu/math/IntNum;
        //  1930: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1933: ifeq            1942
        //  1936: ldc_w           "Automatic sequence on-going"
        //  1939: goto            4165
        //  1942: aload_2         /* bmICCStatus */
        //  1943: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1946: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1949: ifeq            1978
        //  1952: aload_3         /* bmCommandStatus */
        //  1953: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1956: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1959: ifeq            1978
        //  1962: aload_1         /* bError */
        //  1963: getstatic       com/ftsafe/CCIDScheme.Lit104:Lgnu/math/IntNum;
        //  1966: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1969: ifeq            1978
        //  1972: ldc_w           "Hardware error"
        //  1975: goto            4165
        //  1978: aload_2         /* bmICCStatus */
        //  1979: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  1982: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1985: ifeq            2014
        //  1988: aload_3         /* bmCommandStatus */
        //  1989: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  1992: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  1995: ifeq            2014
        //  1998: aload_1         /* bError */
        //  1999: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2002: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2005: ifeq            2014
        //  2008: ldc_w           "Command Not Supported"
        //  2011: goto            4165
        //  2014: aload_2         /* bmICCStatus */
        //  2015: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2018: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2021: istore          x
        //  2023: iload           x
        //  2025: ifeq            2036
        //  2028: iload           x
        //  2030: ifeq            2094
        //  2033: goto            2068
        //  2036: aload_2         /* bmICCStatus */
        //  2037: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2040: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2043: istore          x
        //  2045: iload           x
        //  2047: ifeq            2058
        //  2050: iload           x
        //  2052: ifeq            2094
        //  2055: goto            2068
        //  2058: aload_2         /* bmICCStatus */
        //  2059: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  2062: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2065: ifeq            2094
        //  2068: aload_3         /* bmCommandStatus */
        //  2069: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2072: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2075: ifeq            2094
        //  2078: aload_1         /* bError */
        //  2079: getstatic       com/ftsafe/CCIDScheme.Lit111:Lgnu/math/IntNum;
        //  2082: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2085: ifeq            2094
        //  2088: ldc_w           "CMD_SLOT_BUSY"
        //  2091: goto            4165
        //  2094: aload_2         /* bmICCStatus */
        //  2095: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  2098: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2101: ifeq            2130
        //  2104: aload_3         /* bmCommandStatus */
        //  2105: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2108: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2111: ifeq            2130
        //  2114: aload_1         /* bError */
        //  2115: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //  2118: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2121: ifeq            2130
        //  2124: ldc_w           "bSlot does not exist"
        //  2127: goto            4165
        //  2130: aload_2         /* bmICCStatus */
        //  2131: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  2134: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2137: ifeq            2166
        //  2140: aload_3         /* bmCommandStatus */
        //  2141: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2144: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2147: ifeq            2166
        //  2150: aload_1         /* bError */
        //  2151: getstatic       com/ftsafe/CCIDScheme.Lit103:Lgnu/math/IntNum;
        //  2154: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2157: ifeq            2166
        //  2160: ldc_w           "No ICC present"
        //  2163: goto            4165
        //  2166: aload_2         /* bmICCStatus */
        //  2167: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2170: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2173: ifeq            2202
        //  2176: aload_3         /* bmCommandStatus */
        //  2177: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2180: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2183: ifeq            2202
        //  2186: aload_1         /* bError */
        //  2187: getstatic       com/ftsafe/CCIDScheme.Lit112:Lgnu/math/IntNum;
        //  2190: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2193: ifeq            2202
        //  2196: ldc_w           "Automatic sequence on-going"
        //  2199: goto            4165
        //  2202: aload_2         /* bmICCStatus */
        //  2203: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2206: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2209: ifeq            2238
        //  2212: aload_3         /* bmCommandStatus */
        //  2213: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2216: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2219: ifeq            2238
        //  2222: aload_1         /* bError */
        //  2223: getstatic       com/ftsafe/CCIDScheme.Lit104:Lgnu/math/IntNum;
        //  2226: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2229: ifeq            2238
        //  2232: ldc_w           "Hardware error"
        //  2235: goto            4165
        //  2238: aload_2         /* bmICCStatus */
        //  2239: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2242: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2245: ifeq            2274
        //  2248: aload_3         /* bmCommandStatus */
        //  2249: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2252: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2255: ifeq            2274
        //  2258: aload_1         /* bError */
        //  2259: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2262: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2265: ifeq            2274
        //  2268: ldc_w           "Command Not Supported"
        //  2271: goto            4165
        //  2274: aload_2         /* bmICCStatus */
        //  2275: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2278: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2281: istore          x
        //  2283: iload           x
        //  2285: ifeq            2296
        //  2288: iload           x
        //  2290: ifeq            2354
        //  2293: goto            2328
        //  2296: aload_2         /* bmICCStatus */
        //  2297: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2300: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2303: istore          x
        //  2305: iload           x
        //  2307: ifeq            2318
        //  2310: iload           x
        //  2312: ifeq            2354
        //  2315: goto            2328
        //  2318: aload_2         /* bmICCStatus */
        //  2319: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  2322: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2325: ifeq            2354
        //  2328: aload_3         /* bmCommandStatus */
        //  2329: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2332: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2335: ifeq            2354
        //  2338: aload_1         /* bError */
        //  2339: getstatic       com/ftsafe/CCIDScheme.Lit111:Lgnu/math/IntNum;
        //  2342: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2345: ifeq            2354
        //  2348: ldc_w           "CMD_SLOT_BUSY"
        //  2351: goto            4165
        //  2354: aload_2         /* bmICCStatus */
        //  2355: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2358: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2361: ifeq            2390
        //  2364: aload_3         /* bmCommandStatus */
        //  2365: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2368: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2371: ifeq            2390
        //  2374: aload_1         /* bError */
        //  2375: getstatic       com/ftsafe/CCIDScheme.Lit105:Lgnu/math/IntNum;
        //  2378: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2381: ifeq            2390
        //  2384: ldc_w           "protocol invalid or not supported"
        //  2387: goto            4165
        //  2390: aload_2         /* bmICCStatus */
        //  2391: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2394: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2397: ifeq            2426
        //  2400: aload_3         /* bmCommandStatus */
        //  2401: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2404: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2407: ifeq            2426
        //  2410: aload_1         /* bError */
        //  2411: getstatic       com/ftsafe/CCIDScheme.Lit114:Lgnu/math/IntNum;
        //  2414: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2417: ifeq            2426
        //  2420: ldc_w           "FI - DI pair invalid or not supported"
        //  2423: goto            4165
        //  2426: aload_2         /* bmICCStatus */
        //  2427: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2430: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2433: ifeq            2462
        //  2436: aload_3         /* bmCommandStatus */
        //  2437: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2440: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2443: ifeq            2462
        //  2446: aload_1         /* bError */
        //  2447: getstatic       com/ftsafe/CCIDScheme.Lit90:Lgnu/math/IntNum;
        //  2450: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2453: ifeq            2462
        //  2456: ldc_w           "Invalid TCCKTS parameter"
        //  2459: goto            4165
        //  2462: aload_2         /* bmICCStatus */
        //  2463: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2466: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2469: ifeq            2498
        //  2472: aload_3         /* bmCommandStatus */
        //  2473: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2476: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2479: ifeq            2498
        //  2482: aload_1         /* bError */
        //  2483: getstatic       com/ftsafe/CCIDScheme.Lit115:Lgnu/math/IntNum;
        //  2486: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2489: ifeq            2498
        //  2492: ldc_w           "Guard time not supported"
        //  2495: goto            4165
        //  2498: aload_2         /* bmICCStatus */
        //  2499: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2502: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2505: ifeq            2534
        //  2508: aload_3         /* bmCommandStatus */
        //  2509: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2512: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2515: ifeq            2534
        //  2518: aload_1         /* bError */
        //  2519: getstatic       com/ftsafe/CCIDScheme.Lit116:Lgnu/math/IntNum;
        //  2522: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2525: ifeq            2534
        //  2528: ldc_w           "T=0 WI invalid or not supported / T=1 BWI or CWI invalid or not supported"
        //  2531: goto            4165
        //  2534: aload_2         /* bmICCStatus */
        //  2535: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2538: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2541: ifeq            2570
        //  2544: aload_3         /* bmCommandStatus */
        //  2545: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2548: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2551: ifeq            2570
        //  2554: aload_1         /* bError */
        //  2555: getstatic       com/ftsafe/CCIDScheme.Lit117:Lgnu/math/IntNum;
        //  2558: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2561: ifeq            2570
        //  2564: ldc_w           "Clock stop support requested invalid or not supported"
        //  2567: goto            4165
        //  2570: aload_2         /* bmICCStatus */
        //  2571: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2574: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2577: ifeq            2606
        //  2580: aload_3         /* bmCommandStatus */
        //  2581: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2584: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2587: ifeq            2606
        //  2590: aload_1         /* bError */
        //  2591: getstatic       com/ftsafe/CCIDScheme.Lit118:Lgnu/math/IntNum;
        //  2594: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2597: ifeq            2606
        //  2600: ldc_w           "IFSC size invalid or not supported"
        //  2603: goto            4165
        //  2606: aload_2         /* bmICCStatus */
        //  2607: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2610: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2613: ifeq            2642
        //  2616: aload_3         /* bmCommandStatus */
        //  2617: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2620: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2623: ifeq            2642
        //  2626: aload_1         /* bError */
        //  2627: getstatic       com/ftsafe/CCIDScheme.Lit6:Lgnu/math/IntNum;
        //  2630: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2633: ifeq            2642
        //  2636: ldc_w           "NAD value invalid or not supported"
        //  2639: goto            4165
        //  2642: aload_2         /* bmICCStatus */
        //  2643: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  2646: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2649: ifeq            2678
        //  2652: aload_3         /* bmCommandStatus */
        //  2653: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2656: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2659: ifeq            2678
        //  2662: aload_1         /* bError */
        //  2663: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //  2666: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2669: ifeq            2678
        //  2672: ldc_w           "bSlot does not exist"
        //  2675: goto            4165
        //  2678: aload_2         /* bmICCStatus */
        //  2679: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2682: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2685: ifeq            2714
        //  2688: aload_3         /* bmCommandStatus */
        //  2689: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2692: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2695: ifeq            2714
        //  2698: aload_1         /* bError */
        //  2699: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2702: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2705: ifeq            2714
        //  2708: ldc_w           "Command Not Supported"
        //  2711: goto            4165
        //  2714: aload_2         /* bmICCStatus */
        //  2715: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2718: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2721: istore          x
        //  2723: iload           x
        //  2725: ifeq            2736
        //  2728: iload           x
        //  2730: ifeq            2794
        //  2733: goto            2768
        //  2736: aload_2         /* bmICCStatus */
        //  2737: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2740: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2743: istore          x
        //  2745: iload           x
        //  2747: ifeq            2758
        //  2750: iload           x
        //  2752: ifeq            2794
        //  2755: goto            2768
        //  2758: aload_2         /* bmICCStatus */
        //  2759: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  2762: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2765: ifeq            2794
        //  2768: aload_3         /* bmCommandStatus */
        //  2769: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2772: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2775: ifeq            2794
        //  2778: aload_1         /* bError */
        //  2779: getstatic       com/ftsafe/CCIDScheme.Lit111:Lgnu/math/IntNum;
        //  2782: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2785: ifeq            2794
        //  2788: ldc_w           "CMD_SLOT_BUSY"
        //  2791: goto            4165
        //  2794: aload_2         /* bmICCStatus */
        //  2795: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2798: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2801: ifeq            2830
        //  2804: aload_3         /* bmCommandStatus */
        //  2805: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2808: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2811: ifeq            2830
        //  2814: aload_1         /* bError */
        //  2815: getstatic       com/ftsafe/CCIDScheme.Lit9:Lgnu/math/IntNum;
        //  2818: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2821: ifeq            2830
        //  2824: ldc_w           "Command aborted by control pipe"
        //  2827: goto            4165
        //  2830: aload_2         /* bmICCStatus */
        //  2831: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  2834: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2837: ifeq            2866
        //  2840: aload_3         /* bmCommandStatus */
        //  2841: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2844: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2847: ifeq            2866
        //  2850: aload_1         /* bError */
        //  2851: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //  2854: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2857: ifeq            2866
        //  2860: ldc_w           "bSlot does not exist"
        //  2863: goto            4165
        //  2866: aload_2         /* bmICCStatus */
        //  2867: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  2870: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2873: ifeq            2902
        //  2876: aload_3         /* bmCommandStatus */
        //  2877: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2880: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2883: ifeq            2902
        //  2886: aload_1         /* bError */
        //  2887: getstatic       com/ftsafe/CCIDScheme.Lit103:Lgnu/math/IntNum;
        //  2890: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2893: ifeq            2902
        //  2896: ldc_w           "No ICC present"
        //  2899: goto            4165
        //  2902: aload_2         /* bmICCStatus */
        //  2903: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2906: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2909: ifeq            2938
        //  2912: aload_3         /* bmCommandStatus */
        //  2913: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2916: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2919: ifeq            2938
        //  2922: aload_1         /* bError */
        //  2923: getstatic       com/ftsafe/CCIDScheme.Lit112:Lgnu/math/IntNum;
        //  2926: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2929: ifeq            2938
        //  2932: ldc_w           "Automatic sequence on-going"
        //  2935: goto            4165
        //  2938: aload_2         /* bmICCStatus */
        //  2939: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2942: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2945: ifeq            2974
        //  2948: aload_3         /* bmCommandStatus */
        //  2949: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2952: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2955: ifeq            2974
        //  2958: aload_1         /* bError */
        //  2959: getstatic       com/ftsafe/CCIDScheme.Lit104:Lgnu/math/IntNum;
        //  2962: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2965: ifeq            2974
        //  2968: ldc_w           "Hardware error"
        //  2971: goto            4165
        //  2974: aload_2         /* bmICCStatus */
        //  2975: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2978: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2981: ifeq            3010
        //  2984: aload_3         /* bmCommandStatus */
        //  2985: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  2988: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  2991: ifeq            3010
        //  2994: aload_1         /* bError */
        //  2995: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  2998: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3001: ifeq            3010
        //  3004: ldc_w           "Command Not Supported"
        //  3007: goto            4165
        //  3010: aload_2         /* bmICCStatus */
        //  3011: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  3014: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3017: istore          x
        //  3019: iload           x
        //  3021: ifeq            3032
        //  3024: iload           x
        //  3026: ifeq            3090
        //  3029: goto            3064
        //  3032: aload_2         /* bmICCStatus */
        //  3033: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3036: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3039: istore          x
        //  3041: iload           x
        //  3043: ifeq            3054
        //  3046: iload           x
        //  3048: ifeq            3090
        //  3051: goto            3064
        //  3054: aload_2         /* bmICCStatus */
        //  3055: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  3058: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3061: ifeq            3090
        //  3064: aload_3         /* bmCommandStatus */
        //  3065: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3068: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3071: ifeq            3090
        //  3074: aload_1         /* bError */
        //  3075: getstatic       com/ftsafe/CCIDScheme.Lit111:Lgnu/math/IntNum;
        //  3078: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3081: ifeq            3090
        //  3084: ldc_w           "CMD_SLOT_BUSY"
        //  3087: goto            4165
        //  3090: aload_2         /* bmICCStatus */
        //  3091: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  3094: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3097: ifeq            3126
        //  3100: aload_3         /* bmCommandStatus */
        //  3101: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3104: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3107: ifeq            3126
        //  3110: aload_1         /* bError */
        //  3111: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //  3114: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3117: ifeq            3126
        //  3120: ldc_w           "bSlot does not exist"
        //  3123: goto            4165
        //  3126: aload_2         /* bmICCStatus */
        //  3127: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  3130: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3133: ifeq            3162
        //  3136: aload_3         /* bmCommandStatus */
        //  3137: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3140: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3143: ifeq            3162
        //  3146: aload_1         /* bError */
        //  3147: getstatic       com/ftsafe/CCIDScheme.Lit103:Lgnu/math/IntNum;
        //  3150: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3153: ifeq            3162
        //  3156: ldc_w           "No ICC present"
        //  3159: goto            4165
        //  3162: aload_2         /* bmICCStatus */
        //  3163: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3166: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3169: ifeq            3198
        //  3172: aload_3         /* bmCommandStatus */
        //  3173: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3176: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3179: ifeq            3198
        //  3182: aload_1         /* bError */
        //  3183: getstatic       com/ftsafe/CCIDScheme.Lit113:Lgnu/math/IntNum;
        //  3186: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3189: ifeq            3198
        //  3192: ldc_w           "Protocol not managed"
        //  3195: goto            4165
        //  3198: aload_2         /* bmICCStatus */
        //  3199: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3202: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3205: ifeq            3234
        //  3208: aload_3         /* bmCommandStatus */
        //  3209: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3212: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3215: ifeq            3234
        //  3218: aload_1         /* bError */
        //  3219: getstatic       com/ftsafe/CCIDScheme.Lit9:Lgnu/math/IntNum;
        //  3222: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3225: ifeq            3234
        //  3228: ldc_w           "Command aborted by control pipe"
        //  3231: goto            4165
        //  3234: aload_2         /* bmICCStatus */
        //  3235: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  3238: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3241: ifeq            3270
        //  3244: aload_3         /* bmCommandStatus */
        //  3245: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3248: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3251: ifeq            3270
        //  3254: aload_1         /* bError */
        //  3255: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  3258: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3261: ifeq            3270
        //  3264: ldc_w           "Command Not Supported"
        //  3267: goto            4165
        //  3270: aload_2         /* bmICCStatus */
        //  3271: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  3274: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3277: ifeq            3306
        //  3280: aload_3         /* bmCommandStatus */
        //  3281: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3284: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3287: ifeq            3306
        //  3290: aload_1         /* bError */
        //  3291: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //  3294: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3297: ifeq            3306
        //  3300: ldc_w           "bSlot does not exist"
        //  3303: goto            4165
        //  3306: aload_2         /* bmICCStatus */
        //  3307: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  3310: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3313: ifeq            3342
        //  3316: aload_3         /* bmCommandStatus */
        //  3317: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3320: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3323: ifeq            3342
        //  3326: aload_1         /* bError */
        //  3327: getstatic       com/ftsafe/CCIDScheme.Lit103:Lgnu/math/IntNum;
        //  3330: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3333: ifeq            3342
        //  3336: ldc_w           "No ICC present"
        //  3339: goto            4165
        //  3342: aload_2         /* bmICCStatus */
        //  3343: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3346: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3349: ifeq            3378
        //  3352: aload_3         /* bmCommandStatus */
        //  3353: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3356: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3359: ifeq            3378
        //  3362: aload_1         /* bError */
        //  3363: getstatic       com/ftsafe/CCIDScheme.Lit112:Lgnu/math/IntNum;
        //  3366: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3369: ifeq            3378
        //  3372: ldc_w           "Automatic sequence on-going"
        //  3375: goto            4165
        //  3378: aload_2         /* bmICCStatus */
        //  3379: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3382: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3385: ifeq            3414
        //  3388: aload_3         /* bmCommandStatus */
        //  3389: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3392: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3395: ifeq            3414
        //  3398: aload_1         /* bError */
        //  3399: getstatic       com/ftsafe/CCIDScheme.Lit104:Lgnu/math/IntNum;
        //  3402: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3405: ifeq            3414
        //  3408: ldc_w           "Hardware error"
        //  3411: goto            4165
        //  3414: aload_2         /* bmICCStatus */
        //  3415: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  3418: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3421: ifeq            3450
        //  3424: aload_3         /* bmCommandStatus */
        //  3425: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3428: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3431: ifeq            3450
        //  3434: aload_1         /* bError */
        //  3435: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  3438: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3441: ifeq            3450
        //  3444: ldc_w           "Command Not Supported"
        //  3447: goto            4165
        //  3450: aload_2         /* bmICCStatus */
        //  3451: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  3454: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3457: istore          x
        //  3459: iload           x
        //  3461: ifeq            3472
        //  3464: iload           x
        //  3466: ifeq            3530
        //  3469: goto            3504
        //  3472: aload_2         /* bmICCStatus */
        //  3473: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3476: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3479: istore          x
        //  3481: iload           x
        //  3483: ifeq            3494
        //  3486: iload           x
        //  3488: ifeq            3530
        //  3491: goto            3504
        //  3494: aload_2         /* bmICCStatus */
        //  3495: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  3498: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3501: ifeq            3530
        //  3504: aload_3         /* bmCommandStatus */
        //  3505: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3508: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3511: ifeq            3530
        //  3514: aload_1         /* bError */
        //  3515: getstatic       com/ftsafe/CCIDScheme.Lit111:Lgnu/math/IntNum;
        //  3518: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3521: ifeq            3530
        //  3524: ldc_w           "CMD_SLOT_BUSY"
        //  3527: goto            4165
        //  3530: aload_2         /* bmICCStatus */
        //  3531: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3534: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3537: ifeq            3566
        //  3540: aload_3         /* bmCommandStatus */
        //  3541: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3544: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3547: ifeq            3566
        //  3550: aload_1         /* bError */
        //  3551: getstatic       com/ftsafe/CCIDScheme.Lit106:Lgnu/math/IntNum;
        //  3554: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3557: ifeq            3566
        //  3560: ldc_w           "parity error on ATR"
        //  3563: goto            4165
        //  3566: aload_2         /* bmICCStatus */
        //  3567: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3570: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3573: ifeq            3602
        //  3576: aload_3         /* bmCommandStatus */
        //  3577: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3580: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3583: ifeq            3602
        //  3586: aload_1         /* bError */
        //  3587: getstatic       com/ftsafe/CCIDScheme.Lit103:Lgnu/math/IntNum;
        //  3590: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3593: ifeq            3602
        //  3596: ldc_w           "ICC mute (Time out)"
        //  3599: goto            4165
        //  3602: aload_2         /* bmICCStatus */
        //  3603: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3606: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3609: ifeq            3638
        //  3612: aload_3         /* bmCommandStatus */
        //  3613: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3616: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3619: ifeq            3638
        //  3622: aload_1         /* bError */
        //  3623: getstatic       com/ftsafe/CCIDScheme.Lit9:Lgnu/math/IntNum;
        //  3626: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3629: ifeq            3638
        //  3632: ldc_w           "Command aborted by control pipe"
        //  3635: goto            4165
        //  3638: aload_2         /* bmICCStatus */
        //  3639: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  3642: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3645: ifeq            3674
        //  3648: aload_3         /* bmCommandStatus */
        //  3649: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3652: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3655: ifeq            3674
        //  3658: aload_1         /* bError */
        //  3659: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //  3662: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3665: ifeq            3674
        //  3668: ldc_w           "bSlot does not exist"
        //  3671: goto            4165
        //  3674: aload_2         /* bmICCStatus */
        //  3675: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  3678: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3681: ifeq            3710
        //  3684: aload_3         /* bmCommandStatus */
        //  3685: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3688: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3691: ifeq            3710
        //  3694: aload_1         /* bError */
        //  3695: getstatic       com/ftsafe/CCIDScheme.Lit103:Lgnu/math/IntNum;
        //  3698: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3701: ifeq            3710
        //  3704: ldc_w           "No ICC present"
        //  3707: goto            4165
        //  3710: aload_2         /* bmICCStatus */
        //  3711: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3714: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3717: ifeq            3746
        //  3720: aload_3         /* bmCommandStatus */
        //  3721: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3724: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3727: ifeq            3746
        //  3730: aload_1         /* bError */
        //  3731: getstatic       com/ftsafe/CCIDScheme.Lit112:Lgnu/math/IntNum;
        //  3734: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3737: ifeq            3746
        //  3740: ldc_w           "Automatic sequence on-going"
        //  3743: goto            4165
        //  3746: aload_2         /* bmICCStatus */
        //  3747: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3750: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3753: ifeq            3782
        //  3756: aload_3         /* bmCommandStatus */
        //  3757: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3760: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3763: ifeq            3782
        //  3766: aload_1         /* bError */
        //  3767: getstatic       com/ftsafe/CCIDScheme.Lit104:Lgnu/math/IntNum;
        //  3770: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3773: ifeq            3782
        //  3776: ldc_w           "Hardware error"
        //  3779: goto            4165
        //  3782: aload_2         /* bmICCStatus */
        //  3783: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  3786: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3789: ifeq            3818
        //  3792: aload_3         /* bmCommandStatus */
        //  3793: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3796: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3799: ifeq            3818
        //  3802: aload_1         /* bError */
        //  3803: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  3806: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3809: ifeq            3818
        //  3812: ldc_w           "Command Not Supported"
        //  3815: goto            4165
        //  3818: aload_2         /* bmICCStatus */
        //  3819: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  3822: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3825: istore          x
        //  3827: iload           x
        //  3829: ifeq            3840
        //  3832: iload           x
        //  3834: ifeq            3898
        //  3837: goto            3872
        //  3840: aload_2         /* bmICCStatus */
        //  3841: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3844: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3847: istore          x
        //  3849: iload           x
        //  3851: ifeq            3862
        //  3854: iload           x
        //  3856: ifeq            3898
        //  3859: goto            3872
        //  3862: aload_2         /* bmICCStatus */
        //  3863: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  3866: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3869: ifeq            3898
        //  3872: aload_3         /* bmCommandStatus */
        //  3873: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3876: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3879: ifeq            3898
        //  3882: aload_1         /* bError */
        //  3883: getstatic       com/ftsafe/CCIDScheme.Lit111:Lgnu/math/IntNum;
        //  3886: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3889: ifeq            3898
        //  3892: ldc_w           "CMD_SLOT_BUSY"
        //  3895: goto            4165
        //  3898: aload_2         /* bmICCStatus */
        //  3899: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  3902: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3905: ifeq            3934
        //  3908: aload_3         /* bmCommandStatus */
        //  3909: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3912: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3915: ifeq            3934
        //  3918: aload_1         /* bError */
        //  3919: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //  3922: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3925: ifeq            3934
        //  3928: ldc_w           "bSlot does not exist"
        //  3931: goto            4165
        //  3934: aload_2         /* bmICCStatus */
        //  3935: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  3938: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3941: ifeq            3970
        //  3944: aload_3         /* bmCommandStatus */
        //  3945: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3948: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3951: ifeq            3970
        //  3954: aload_1         /* bError */
        //  3955: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  3958: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3961: ifeq            3970
        //  3964: ldc_w           "Command Not Supported"
        //  3967: goto            4165
        //  3970: aload_2         /* bmICCStatus */
        //  3971: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  3974: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3977: ifeq            4006
        //  3980: aload_3         /* bmCommandStatus */
        //  3981: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  3984: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3987: ifeq            4006
        //  3990: aload_1         /* bError */
        //  3991: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //  3994: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  3997: ifeq            4006
        //  4000: ldc_w           "bSlot does not exist"
        //  4003: goto            4165
        //  4006: aload_2         /* bmICCStatus */
        //  4007: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  4010: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  4013: ifeq            4042
        //  4016: aload_3         /* bmCommandStatus */
        //  4017: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  4020: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  4023: ifeq            4042
        //  4026: aload_1         /* bError */
        //  4027: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //  4030: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  4033: ifeq            4042
        //  4036: ldc_w           "Command Not Supported"
        //  4039: goto            4165
        //  4042: aload_3         /* bmCommandStatus */
        //  4043: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  4046: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  4049: ifeq            4078
        //  4052: aload_1         /* bError */
        //  4053: getstatic       com/ftsafe/CCIDScheme.Lit119:Lgnu/math/IntNum;
        //  4056: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  4059: ifeq            4078
        //  4062: aload_1         /* bError */
        //  4063: getstatic       com/ftsafe/CCIDScheme.Lit101:Lgnu/math/IntNum;
        //  4066: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  4069: ifeq            4078
        //  4072: ldc_w           "User Defined"
        //  4075: goto            4165
        //  4078: aload_3         /* bmCommandStatus */
        //  4079: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  4082: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  4085: ifeq            4114
        //  4088: aload_1         /* bError */
        //  4089: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  4092: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  4095: ifeq            4114
        //  4098: aload_1         /* bError */
        //  4099: getstatic       com/ftsafe/CCIDScheme.Lit120:Lgnu/math/IntNum;
        //  4102: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  4105: ifeq            4114
        //  4108: ldc_w           "Index of not supported / incorrect message parameter"
        //  4111: goto            4165
        //  4114: aload_3         /* bmCommandStatus */
        //  4115: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  4118: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  4121: ifeq            4130
        //  4124: ldc_w           "**Reserved for future use**"
        //  4127: goto            4165
        //  4130: aload_2         /* bmICCStatus */
        //  4131: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //  4134: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  4137: ifeq            4146
        //  4140: ldc_w           "An ICC is present and inactive (not activated or shut down by hardware error)"
        //  4143: goto            4165
        //  4146: aload_2         /* bmICCStatus */
        //  4147: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //  4150: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //  4153: ifeq            4162
        //  4156: ldc_w           "No ICC is present"
        //  4159: goto            4165
        //  4162: ldc_w           "OK / Other"
        //  4165: aastore        
        //  4166: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //  4169: areturn        
        //  4170: new             Lgnu/mapping/WrongType;
        //  4173: dup_x1         
        //  4174: swap           
        //  4175: ldc_w           "number->string"
        //  4178: iconst_1       
        //  4179: aload           4
        //  4181: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4184: athrow         
        //  4185: new             Lgnu/mapping/WrongType;
        //  4188: dup_x1         
        //  4189: swap           
        //  4190: ldc_w           "number->string"
        //  4193: iconst_1       
        //  4194: aload           4
        //  4196: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4199: athrow         
        //  4200: new             Lgnu/mapping/WrongType;
        //  4203: dup_x1         
        //  4204: swap           
        //  4205: ldc_w           "number->string"
        //  4208: iconst_1       
        //  4209: aload           4
        //  4211: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  4214: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  53     56     4170   4185   Ljava/lang/ClassCastException;
        //  85     88     4185   4200   Ljava/lang/ClassCastException;
        //  119    122    4200   4215   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object PC_to_RDR_IccPowerOn(final Object _bSlot, final Object _bPowerSelect) {
        final Object bSeq = getBSeq(com.ftsafe.CCIDScheme.Lit100);
        return append.append$V(new Object[] { LList.list1(com.ftsafe.CCIDScheme.Lit121), buildDwordInlst$V(com.ftsafe.CCIDScheme.Lit1, new Object[] { com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4 }), LList.list3(_bSlot, bSeq, _bPowerSelect), buildWordInlst$V(com.ftsafe.CCIDScheme.Lit1, new Object[] { com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4 }) });
    }
    
    public static Object PC_to_RDR_XfrBlock(final Object _bSlot, final Object _bBWI, final Object _wLevelParameter, final Object _abData) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //     4: istore          4
        //     6: getstatic       com/ftsafe/CCIDScheme.Lit100:Lgnu/mapping/SimpleSymbol;
        //     9: invokestatic    com/ftsafe/CCIDScheme.getBSeq:(Ljava/lang/Object;)Ljava/lang/Object;
        //    12: astore          bSeq
        //    14: iconst_5       
        //    15: anewarray       Ljava/lang/Object;
        //    18: dup            
        //    19: iconst_0       
        //    20: getstatic       com/ftsafe/CCIDScheme.Lit122:Lgnu/math/IntNum;
        //    23: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //    26: aastore        
        //    27: dup            
        //    28: iconst_1       
        //    29: iload           dwLength
        //    31: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    34: iconst_2       
        //    35: anewarray       Ljava/lang/Object;
        //    38: dup            
        //    39: iconst_0       
        //    40: getstatic       com/ftsafe/CCIDScheme.Lit3:Lgnu/expr/Keyword;
        //    43: aastore        
        //    44: dup            
        //    45: iconst_1       
        //    46: getstatic       com/ftsafe/CCIDScheme.Lit4:Lgnu/mapping/SimpleSymbol;
        //    49: aastore        
        //    50: invokestatic    com/ftsafe/CCIDScheme.buildDwordInlst$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/Pair;
        //    53: aastore        
        //    54: dup            
        //    55: iconst_2       
        //    56: aload_0         /* _bSlot */
        //    57: aload           bSeq
        //    59: aload_1         /* _bBWI */
        //    60: invokestatic    gnu/lists/LList.list3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    63: aastore        
        //    64: dup            
        //    65: iconst_3       
        //    66: aload_2         /* _wLevelParameter */
        //    67: iconst_2       
        //    68: anewarray       Ljava/lang/Object;
        //    71: dup            
        //    72: iconst_0       
        //    73: getstatic       com/ftsafe/CCIDScheme.Lit3:Lgnu/expr/Keyword;
        //    76: aastore        
        //    77: dup            
        //    78: iconst_1       
        //    79: getstatic       com/ftsafe/CCIDScheme.Lit4:Lgnu/mapping/SimpleSymbol;
        //    82: aastore        
        //    83: invokestatic    com/ftsafe/CCIDScheme.buildWordInlst$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/Pair;
        //    86: aastore        
        //    87: dup            
        //    88: iconst_4       
        //    89: aload_3         /* _abData */
        //    90: aastore        
        //    91: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //    94: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Pair RDR_to_PC_DataBlock(final Object data) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //     5: astore_1       
        //     6: aload_0         /* data */
        //     7: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //    10: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //    13: invokestatic    com/ftsafe/CCIDScheme.subu8list:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    16: iconst_0       
        //    17: anewarray       Ljava/lang/Object;
        //    20: invokestatic    com/ftsafe/CCIDScheme.buildDwordFromlst$V:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    23: astore_2       
        //    24: aload_0         /* data */
        //    25: iconst_5       
        //    26: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    29: astore_3       
        //    30: aload_0         /* data */
        //    31: bipush          6
        //    33: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    36: astore          4
        //    38: aload_0         /* data */
        //    39: bipush          7
        //    41: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    44: astore          5
        //    46: aload_0         /* data */
        //    47: bipush          8
        //    49: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    52: astore          6
        //    54: aload_0         /* data */
        //    55: bipush          9
        //    57: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    60: astore          7
        //    62: aload_0         /* data */
        //    63: getstatic       com/ftsafe/CCIDScheme.Lit114:Lgnu/math/IntNum;
        //    66: aload_0         /* data */
        //    67: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //    70: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    73: invokestatic    com/ftsafe/CCIDScheme.subu8list:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    76: astore          abData
        //    78: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    81: aload           bSeq
        //    83: getstatic       com/ftsafe/CCIDScheme.Lit123:Lgnu/mapping/SimpleSymbol;
        //    86: invokestatic    com/ftsafe/CCIDScheme.getBSeq:(Ljava/lang/Object;)Ljava/lang/Object;
        //    89: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    92: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    95: ifne            115
        //    98: iconst_1       
        //    99: anewarray       Ljava/lang/Object;
        //   102: dup            
        //   103: iconst_0       
        //   104: ldc_w           "bSeq not equal"
        //   107: aastore        
        //   108: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   111: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   114: athrow         
        //   115: aload           bStatus
        //   117: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   120: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   123: ifeq            137
        //   126: aload           bError
        //   128: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   131: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   134: ifne            151
        //   137: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   140: aload           bStatus
        //   142: aload           bError
        //   144: invokestatic    com/ftsafe/CCIDScheme.getBStatusBErrorErrorName:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/FString;
        //   147: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   150: pop            
        //   151: getstatic       com/ftsafe/CCIDScheme.Lit124:Lgnu/mapping/SimpleSymbol;
        //   154: aload_1         /* bMessageType */
        //   155: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   158: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   161: dup            
        //   162: getstatic       com/ftsafe/CCIDScheme.Lit125:Lgnu/mapping/SimpleSymbol;
        //   165: aload_2         /* dwLength */
        //   166: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   169: getstatic       com/ftsafe/CCIDScheme.Lit126:Lgnu/mapping/SimpleSymbol;
        //   172: aload_3         /* bSlot */
        //   173: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   176: getstatic       com/ftsafe/CCIDScheme.Lit127:Lgnu/mapping/SimpleSymbol;
        //   179: aload           bStatus
        //   181: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   184: getstatic       com/ftsafe/CCIDScheme.Lit128:Lgnu/mapping/SimpleSymbol;
        //   187: aload           bChainParameter
        //   189: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   192: invokestatic    gnu/lists/LList.chain4:(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   195: getstatic       com/ftsafe/CCIDScheme.Lit129:Lgnu/mapping/SimpleSymbol;
        //   198: aload           abData
        //   200: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   203: invokestatic    gnu/lists/LList.chain1:(Lgnu/lists/Pair;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   206: pop            
        //   207: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object PC_to_RDR_IccPowerOff(final Object _bSlot) {
        final Object bSeq = getBSeq(com.ftsafe.CCIDScheme.Lit100);
        return append.append$V(new Object[] { LList.list1(com.ftsafe.CCIDScheme.Lit130), buildDwordInlst$V(com.ftsafe.CCIDScheme.Lit1, new Object[] { com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4 }), LList.list2(_bSlot, bSeq), com.ftsafe.CCIDScheme.Lit131 });
    }
    
    public static Pair RDR_to_PC_SlotStatus(final Object data) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //     5: astore_1       
        //     6: aload_0         /* data */
        //     7: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //    10: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //    13: invokestatic    com/ftsafe/CCIDScheme.subu8list:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    16: iconst_0       
        //    17: anewarray       Ljava/lang/Object;
        //    20: invokestatic    com/ftsafe/CCIDScheme.buildDwordFromlst$V:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    23: pop            
        //    24: aload_0         /* data */
        //    25: iconst_5       
        //    26: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    29: astore_2       
        //    30: aload_0         /* data */
        //    31: bipush          6
        //    33: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    36: astore_3       
        //    37: aload_0         /* data */
        //    38: bipush          7
        //    40: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          4
        //    45: aload_0         /* data */
        //    46: bipush          8
        //    48: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    51: astore          5
        //    53: aload_0         /* data */
        //    54: bipush          9
        //    56: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    59: astore          bClockStatus
        //    61: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    64: aload_3         /* bSeq */
        //    65: getstatic       com/ftsafe/CCIDScheme.Lit123:Lgnu/mapping/SimpleSymbol;
        //    68: invokestatic    com/ftsafe/CCIDScheme.getBSeq:(Ljava/lang/Object;)Ljava/lang/Object;
        //    71: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    74: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    77: ifne            97
        //    80: iconst_1       
        //    81: anewarray       Ljava/lang/Object;
        //    84: dup            
        //    85: iconst_0       
        //    86: ldc_w           "bSeq not equal"
        //    89: aastore        
        //    90: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //    93: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //    96: athrow         
        //    97: aload           bStatus
        //    99: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   102: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   105: ifeq            119
        //   108: aload           bError
        //   110: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   113: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   116: ifne            133
        //   119: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   122: aload           bStatus
        //   124: aload           bError
        //   126: invokestatic    com/ftsafe/CCIDScheme.getBStatusBErrorErrorName:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/FString;
        //   129: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   132: pop            
        //   133: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   136: aload           bClockStatus
        //   138: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   141: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   144: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   147: ifeq            163
        //   150: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   153: ldc_w           "bClockStatus: Clock running"
        //   156: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   159: pop            
        //   160: goto            263
        //   163: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   166: aload           bClockStatus
        //   168: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   171: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   174: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   177: ifeq            193
        //   180: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   183: ldc_w           "bClockStatus: Clock stopped in state L"
        //   186: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   189: pop            
        //   190: goto            263
        //   193: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   196: aload           bClockStatus
        //   198: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   201: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   204: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   207: ifeq            223
        //   210: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   213: ldc_w           "bClockStatus: Clock stopped in state H"
        //   216: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   219: pop            
        //   220: goto            263
        //   223: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   226: aload           bClockStatus
        //   228: getstatic       com/ftsafe/CCIDScheme.Lit99:Lgnu/math/IntNum;
        //   231: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   234: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   237: ifeq            253
        //   240: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   243: ldc_w           "bClockStatus: Clock stopped in an unknown state"
        //   246: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   249: pop            
        //   250: goto            263
        //   253: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   256: ldc_w           "bClockStatus: All other values are RFU"
        //   259: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   262: pop            
        //   263: getstatic       com/ftsafe/CCIDScheme.Lit124:Lgnu/mapping/SimpleSymbol;
        //   266: aload_1         /* bMessageType */
        //   267: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   270: getstatic       com/ftsafe/CCIDScheme.Lit126:Lgnu/mapping/SimpleSymbol;
        //   273: aload_2         /* bSlot */
        //   274: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   277: getstatic       com/ftsafe/CCIDScheme.Lit127:Lgnu/mapping/SimpleSymbol;
        //   280: aload           bStatus
        //   282: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   285: getstatic       com/ftsafe/CCIDScheme.Lit132:Lgnu/mapping/SimpleSymbol;
        //   288: aload           bClockStatus
        //   290: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   293: invokestatic    gnu/lists/LList.list4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   296: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object PC_to_RDR_SetParameters(final Object _bSlot, final Object _bProtocolNum, final Object _pps) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //     4: istore_3       
        //     5: getstatic       com/ftsafe/CCIDScheme.Lit100:Lgnu/mapping/SimpleSymbol;
        //     8: invokestatic    com/ftsafe/CCIDScheme.getBSeq:(Ljava/lang/Object;)Ljava/lang/Object;
        //    11: astore          bSeq
        //    13: iconst_5       
        //    14: anewarray       Ljava/lang/Object;
        //    17: dup            
        //    18: iconst_0       
        //    19: getstatic       com/ftsafe/CCIDScheme.Lit133:Lgnu/math/IntNum;
        //    22: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //    25: aastore        
        //    26: dup            
        //    27: iconst_1       
        //    28: iload_3         /* dwLength */
        //    29: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    32: iconst_2       
        //    33: anewarray       Ljava/lang/Object;
        //    36: dup            
        //    37: iconst_0       
        //    38: getstatic       com/ftsafe/CCIDScheme.Lit3:Lgnu/expr/Keyword;
        //    41: aastore        
        //    42: dup            
        //    43: iconst_1       
        //    44: getstatic       com/ftsafe/CCIDScheme.Lit4:Lgnu/mapping/SimpleSymbol;
        //    47: aastore        
        //    48: invokestatic    com/ftsafe/CCIDScheme.buildDwordInlst$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/Pair;
        //    51: aastore        
        //    52: dup            
        //    53: iconst_2       
        //    54: aload_0         /* _bSlot */
        //    55: aload           bSeq
        //    57: aload_1         /* _bProtocolNum */
        //    58: invokestatic    gnu/lists/LList.list3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    61: aastore        
        //    62: dup            
        //    63: iconst_3       
        //    64: getstatic       com/ftsafe/CCIDScheme.Lit134:Lgnu/lists/PairWithPosition;
        //    67: aastore        
        //    68: dup            
        //    69: iconst_4       
        //    70: aload_2         /* _pps */
        //    71: aastore        
        //    72: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //    75: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Pair RDR_to_PC_Parameters(final Object data) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //     5: astore_1       
        //     6: aload_0         /* data */
        //     7: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //    10: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //    13: invokestatic    com/ftsafe/CCIDScheme.subu8list:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    16: iconst_0       
        //    17: anewarray       Ljava/lang/Object;
        //    20: invokestatic    com/ftsafe/CCIDScheme.buildDwordFromlst$V:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    23: pop            
        //    24: aload_0         /* data */
        //    25: iconst_5       
        //    26: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    29: astore_2       
        //    30: aload_0         /* data */
        //    31: bipush          6
        //    33: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    36: astore_3       
        //    37: aload_0         /* data */
        //    38: bipush          7
        //    40: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    43: astore          4
        //    45: aload_0         /* data */
        //    46: bipush          8
        //    48: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    51: astore          5
        //    53: aload_0         /* data */
        //    54: bipush          9
        //    56: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    59: astore          6
        //    61: aload_0         /* data */
        //    62: getstatic       com/ftsafe/CCIDScheme.Lit114:Lgnu/math/IntNum;
        //    65: aload_0         /* data */
        //    66: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //    69: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    72: invokestatic    com/ftsafe/CCIDScheme.subu8list:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    75: astore          abProtocolDataStructure
        //    77: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    80: aload_3         /* bSeq */
        //    81: getstatic       com/ftsafe/CCIDScheme.Lit123:Lgnu/mapping/SimpleSymbol;
        //    84: invokestatic    com/ftsafe/CCIDScheme.getBSeq:(Ljava/lang/Object;)Ljava/lang/Object;
        //    87: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    90: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    93: ifne            113
        //    96: iconst_1       
        //    97: anewarray       Ljava/lang/Object;
        //   100: dup            
        //   101: iconst_0       
        //   102: ldc_w           "bSeq not equal"
        //   105: aastore        
        //   106: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   109: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   112: athrow         
        //   113: aload           bStatus
        //   115: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   118: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   121: ifeq            135
        //   124: aload           bError
        //   126: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   129: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   132: ifne            149
        //   135: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   138: aload           bStatus
        //   140: aload           bError
        //   142: invokestatic    com/ftsafe/CCIDScheme.getBStatusBErrorErrorName:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/FString;
        //   145: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   148: pop            
        //   149: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   152: aload           bProtocolNum
        //   154: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   157: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   160: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   163: ifeq            179
        //   166: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   169: ldc_w           "Structure for protocol T=0"
        //   172: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   175: pop            
        //   176: goto            309
        //   179: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   182: aload           bProtocolNum
        //   184: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   187: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   190: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   193: ifeq            209
        //   196: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   199: ldc_w           "Structure for protocol T=1"
        //   202: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   205: pop            
        //   206: goto            309
        //   209: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   212: aload           bProtocolNum
        //   214: getstatic       com/ftsafe/CCIDScheme.Lit20:Lgnu/math/IntNum;
        //   217: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   220: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   223: ifeq            239
        //   226: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   229: ldc_w           "Structure for 2-wire protocol"
        //   232: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   235: pop            
        //   236: goto            309
        //   239: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   242: aload           bProtocolNum
        //   244: getstatic       com/ftsafe/CCIDScheme.Lit119:Lgnu/math/IntNum;
        //   247: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   250: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   253: ifeq            269
        //   256: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   259: ldc_w           "Structure for 3-wire protocol"
        //   262: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   265: pop            
        //   266: goto            309
        //   269: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   272: aload           bProtocolNum
        //   274: getstatic       com/ftsafe/CCIDScheme.Lit135:Lgnu/math/IntNum;
        //   277: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   280: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   283: ifeq            299
        //   286: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   289: ldc_w           "Structure for I2C protocol"
        //   292: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   295: pop            
        //   296: goto            309
        //   299: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   302: ldc_w           "bClockStatus: All other values are RFU"
        //   305: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   308: pop            
        //   309: getstatic       com/ftsafe/CCIDScheme.Lit124:Lgnu/mapping/SimpleSymbol;
        //   312: aload_1         /* bMessageType */
        //   313: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   316: getstatic       com/ftsafe/CCIDScheme.Lit126:Lgnu/mapping/SimpleSymbol;
        //   319: aload_2         /* bSlot */
        //   320: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   323: getstatic       com/ftsafe/CCIDScheme.Lit136:Lgnu/mapping/SimpleSymbol;
        //   326: aload           bProtocolNum
        //   328: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   331: getstatic       com/ftsafe/CCIDScheme.Lit137:Lgnu/mapping/SimpleSymbol;
        //   334: aload           abProtocolDataStructure
        //   336: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   339: invokestatic    gnu/lists/LList.list4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   342: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object PC_to_RDR_Escape(final Object _bSlot, final Object _abData) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //     4: istore_2       
        //     5: getstatic       com/ftsafe/CCIDScheme.Lit100:Lgnu/mapping/SimpleSymbol;
        //     8: invokestatic    com/ftsafe/CCIDScheme.getBSeq:(Ljava/lang/Object;)Ljava/lang/Object;
        //    11: astore_3        /* bSeq */
        //    12: iconst_5       
        //    13: anewarray       Ljava/lang/Object;
        //    16: dup            
        //    17: iconst_0       
        //    18: getstatic       com/ftsafe/CCIDScheme.Lit138:Lgnu/math/IntNum;
        //    21: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //    24: aastore        
        //    25: dup            
        //    26: iconst_1       
        //    27: iload_2         /* dwLength */
        //    28: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    31: iconst_2       
        //    32: anewarray       Ljava/lang/Object;
        //    35: dup            
        //    36: iconst_0       
        //    37: getstatic       com/ftsafe/CCIDScheme.Lit3:Lgnu/expr/Keyword;
        //    40: aastore        
        //    41: dup            
        //    42: iconst_1       
        //    43: getstatic       com/ftsafe/CCIDScheme.Lit4:Lgnu/mapping/SimpleSymbol;
        //    46: aastore        
        //    47: invokestatic    com/ftsafe/CCIDScheme.buildDwordInlst$V:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/Pair;
        //    50: aastore        
        //    51: dup            
        //    52: iconst_2       
        //    53: aload_0         /* _bSlot */
        //    54: aload_3         /* bSeq */
        //    55: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    58: aastore        
        //    59: dup            
        //    60: iconst_3       
        //    61: getstatic       com/ftsafe/CCIDScheme.Lit131:Lgnu/lists/PairWithPosition;
        //    64: aastore        
        //    65: dup            
        //    66: iconst_4       
        //    67: aload_1         /* _abData */
        //    68: aastore        
        //    69: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //    72: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Pair RDR_to_PC_Escape(final Object data) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //     5: astore_1       
        //     6: aload_0         /* data */
        //     7: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //    10: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //    13: invokestatic    com/ftsafe/CCIDScheme.subu8list:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    16: iconst_0       
        //    17: anewarray       Ljava/lang/Object;
        //    20: invokestatic    com/ftsafe/CCIDScheme.buildDwordFromlst$V:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    23: astore_2       
        //    24: aload_0         /* data */
        //    25: iconst_5       
        //    26: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    29: astore_3       
        //    30: aload_0         /* data */
        //    31: bipush          6
        //    33: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    36: astore          4
        //    38: aload_0         /* data */
        //    39: bipush          7
        //    41: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    44: astore          5
        //    46: aload_0         /* data */
        //    47: bipush          8
        //    49: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    52: astore          6
        //    54: aload_0         /* data */
        //    55: bipush          9
        //    57: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    60: astore          7
        //    62: aload_0         /* data */
        //    63: getstatic       com/ftsafe/CCIDScheme.Lit114:Lgnu/math/IntNum;
        //    66: aload_0         /* data */
        //    67: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //    70: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    73: invokestatic    com/ftsafe/CCIDScheme.subu8list:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    76: astore          abData
        //    78: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    81: aload           bSeq
        //    83: getstatic       com/ftsafe/CCIDScheme.Lit123:Lgnu/mapping/SimpleSymbol;
        //    86: invokestatic    com/ftsafe/CCIDScheme.getBSeq:(Ljava/lang/Object;)Ljava/lang/Object;
        //    89: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    92: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    95: ifne            115
        //    98: iconst_1       
        //    99: anewarray       Ljava/lang/Object;
        //   102: dup            
        //   103: iconst_0       
        //   104: ldc_w           "bSeq not equal"
        //   107: aastore        
        //   108: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   111: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   114: athrow         
        //   115: aload           bStatus
        //   117: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   120: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   123: ifeq            137
        //   126: aload           bError
        //   128: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   131: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   134: ifne            151
        //   137: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   140: aload           bStatus
        //   142: aload           bError
        //   144: invokestatic    com/ftsafe/CCIDScheme.getBStatusBErrorErrorName:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/FString;
        //   147: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   150: pop            
        //   151: getstatic       com/ftsafe/CCIDScheme.Lit124:Lgnu/mapping/SimpleSymbol;
        //   154: aload_1         /* bMessageType */
        //   155: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   158: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   161: dup            
        //   162: getstatic       com/ftsafe/CCIDScheme.Lit125:Lgnu/mapping/SimpleSymbol;
        //   165: aload_2         /* dwLength */
        //   166: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   169: getstatic       com/ftsafe/CCIDScheme.Lit126:Lgnu/mapping/SimpleSymbol;
        //   172: aload_3         /* bSlot */
        //   173: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   176: getstatic       com/ftsafe/CCIDScheme.Lit127:Lgnu/mapping/SimpleSymbol;
        //   179: aload           bStatus
        //   181: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   184: getstatic       com/ftsafe/CCIDScheme.Lit139:Lgnu/mapping/SimpleSymbol;
        //   187: aload           bRFU
        //   189: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   192: invokestatic    gnu/lists/LList.chain4:(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   195: getstatic       com/ftsafe/CCIDScheme.Lit129:Lgnu/mapping/SimpleSymbol;
        //   198: aload           abData
        //   200: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   203: invokestatic    gnu/lists/LList.chain1:(Lgnu/lists/Pair;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   206: pop            
        //   207: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object PC_to_RDR_GetSlotStatus(final Object _bSlot) {
        final Object bSeq = getBSeq(com.ftsafe.CCIDScheme.Lit100);
        return append.append$V(new Object[] { LList.list1(com.ftsafe.CCIDScheme.Lit140), buildDwordInlst$V(com.ftsafe.CCIDScheme.Lit1, new Object[] { com.ftsafe.CCIDScheme.Lit3, com.ftsafe.CCIDScheme.Lit4 }), LList.list2(_bSlot, bSeq), com.ftsafe.CCIDScheme.Lit131 });
    }
    
    public static Object parseATR(final Object atr) {
        public class CCIDScheme$frame10 extends ModuleBody
        {
            Object atr;
            final ModuleMethod lambda$Fn15;
            
            public CCIDScheme$frame10() {
                final ModuleMethod lambda$Fn15 = new ModuleMethod(this, 6, null, 4097);
                lambda$Fn15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:5");
                this.lambda$Fn15 = lambda$Fn15;
            }
            
            Object lambda25(final Object p) {
                public class CCIDScheme$frame11 extends ModuleBody
                {
                    Object p;
                    CCIDScheme$frame10 staticLink;
                    
                    public Object lambda26read$Mn1() {
                        final Object force = Promise.force(com.ftsafe.CCIDScheme.readU8s(com.ftsafe.CCIDScheme.Lit2, this.p), Pair.class);
                        try {
                            return lists.car((Pair)force);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "car", 1, force);
                        }
                    }
                    
                    public Object lambda27getAtrInterfaceInside(final Object D, final IntNum i) {
                        Object newD = Boolean.FALSE;
                        final Object[] args = new Object[2];
                        final int n = 0;
                        final LList Dd = com.ftsafe.CCIDScheme.byte$To$Bit(D);
                        final ModuleMethod lambda$Fn16 = com.ftsafe.CCIDScheme.lambda$Fn16;
                        final Externalizable a = KawaConvert.isTrue(lists.listRef(Dd, 3)) ? LList.list2(com.ftsafe.CCIDScheme.Lit141, this.lambda26read$Mn1()) : Values.empty;
                        final Object[] argsArray = { KawaConvert.isTrue(lists.listRef(Dd, 2)) ? LList.list2(com.ftsafe.CCIDScheme.Lit142, this.lambda26read$Mn1()) : Values.empty, KawaConvert.isTrue(lists.listRef(Dd, 1)) ? LList.list2(com.ftsafe.CCIDScheme.Lit143, this.lambda26read$Mn1()) : Values.empty, null };
                        final int n2 = 2;
                        Externalizable externalizable;
                        if (KawaConvert.isTrue(lists.listRef(Dd, 0))) {
                            newD = this.lambda26read$Mn1();
                            externalizable = LList.list2(com.ftsafe.CCIDScheme.Lit144, newD);
                        }
                        else {
                            externalizable = Values.empty;
                        }
                        argsArray[n2] = externalizable;
                        final Object _tmp = com.ftsafe.CCIDScheme.filter(lambda$Fn16, com.ftsafe.CCIDScheme.toList$V(a, argsArray));
                        args[n] = (lists.isNull(_tmp) ? LList.Empty : LList.list1(append.append$V(new Object[] { LList.list1(misc.string$To$Symbol(strings.stringAppend("interface", numbers.number$To$String(i)))), _tmp })));
                        args[1] = (KawaConvert.isTrue(Scheme.isEqual.apply2(Boolean.FALSE, newD)) ? LList.Empty : this.lambda27getAtrInterfaceInside(newD, IntNum.add(i, 1)));
                        return append.append$V(args);
                    }
                    
                    static boolean lambda28(final Object x) {
                        return !KawaConvert.isTrue(Scheme.isEqual.apply2(Values.empty, x));
                    }
                }
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     4: invokespecial   com/ftsafe/CCIDScheme$frame11.<init>:()V
                //     7: dup            
                //     8: aload_0         /* this */
                //     9: putfield        com/ftsafe/CCIDScheme$frame11.staticLink:Lcom/ftsafe/CCIDScheme$frame10;
                //    12: astore_2        /* $heapFrame */
                //    13: aload_2         /* $heapFrame */
                //    14: aload_1         /* p */
                //    15: putfield        com/ftsafe/CCIDScheme$frame11.p:Ljava/lang/Object;
                //    18: aload_2         /* $heapFrame */
                //    19: invokevirtual   com/ftsafe/CCIDScheme$frame11.lambda26read$Mn1:()Ljava/lang/Object;
                //    22: astore_3        /* TS */
                //    23: aload_2         /* $heapFrame */
                //    24: invokevirtual   com/ftsafe/CCIDScheme$frame11.lambda26read$Mn1:()Ljava/lang/Object;
                //    27: astore          T0
                //    29: aload           T0
                //    31: astore          _D
                //    33: iconst_2       
                //    34: anewarray       Ljava/lang/Object;
                //    37: dup            
                //    38: iconst_0       
                //    39: getstatic       com/ftsafe/CCIDScheme.Lit50:Lgnu/lists/PairWithPosition;
                //    42: aastore        
                //    43: dup            
                //    44: iconst_1       
                //    45: aload_2         /* $heapFrame */
                //    46: aload           _D
                //    48: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
                //    51: invokevirtual   com/ftsafe/CCIDScheme$frame11.lambda27getAtrInterfaceInside:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
                //    54: aastore        
                //    55: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //    58: astore          i
                //    60: aload           T0
                //    62: aload_2         /* $heapFrame */
                //    63: getfield        com/ftsafe/CCIDScheme$frame11.p:Ljava/lang/Object;
                //    66: astore          8
                //    68: astore          _D
                //    70: getstatic       gnu/kawa/functions/DivideOp.remainder:Lgnu/kawa/functions/DivideOp;
                //    73: aload           _D
                //    75: getstatic       com/ftsafe/CCIDScheme.Lit6:Lgnu/math/IntNum;
                //    78: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    81: astore          K
                //    83: getstatic       com/ftsafe/CCIDScheme.Lit145:Lgnu/mapping/SimpleSymbol;
                //    86: aload           K
                //    88: aload           port
                //    90: invokestatic    com/ftsafe/CCIDScheme.readU8s:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    93: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //    96: astore          h
                //    98: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
                //   101: aload_2         /* $heapFrame */
                //   102: getfield        com/ftsafe/CCIDScheme$frame11.p:Ljava/lang/Object;
                //   105: invokestatic    com/ftsafe/CCIDScheme.readU8s:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   108: astore          TCK
                //   110: aload           TCK
                //   112: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   115: ifeq            130
                //   118: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
                //   121: ldc             "no TCK"
                //   123: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   126: pop            
                //   127: goto            177
                //   130: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
                //   133: aload_0         /* this */
                //   134: getfield        com/ftsafe/CCIDScheme$frame10.atr:Ljava/lang/Object;
                //   137: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
                //   140: aload_0         /* this */
                //   141: getfield        com/ftsafe/CCIDScheme$frame10.atr:Ljava/lang/Object;
                //   144: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
                //   147: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //   150: invokestatic    com/ftsafe/CCIDScheme.subu8list:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   153: invokestatic    com/ftsafe/CCIDScheme.listXor:(Ljava/lang/Object;)Ljava/lang/Object;
                //   156: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
                //   159: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   162: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   165: ifne            177
                //   168: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
                //   171: ldc             "TCK not equal"
                //   173: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   176: pop            
                //   177: iconst_2       
                //   178: anewarray       Ljava/lang/Object;
                //   181: dup            
                //   182: iconst_0       
                //   183: getstatic       com/ftsafe/CCIDScheme.Lit146:Lgnu/mapping/SimpleSymbol;
                //   186: aload_3         /* TS */
                //   187: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   190: getstatic       com/ftsafe/CCIDScheme.Lit147:Lgnu/mapping/SimpleSymbol;
                //   193: aload           T0
                //   195: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   198: aload           i
                //   200: aload           h
                //   202: invokestatic    gnu/lists/LList.list4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   205: aastore        
                //   206: dup            
                //   207: iconst_1       
                //   208: aload           TCK
                //   210: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   213: ifeq            222
                //   216: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //   219: goto            247
                //   222: getstatic       com/ftsafe/CCIDScheme.Lit148:Lgnu/mapping/SimpleSymbol;
                //   225: aload           TCK
                //   227: ldc             Lgnu/lists/Pair;.class
                //   229: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   232: dup            
                //   233: astore          8
                //   235: checkcast       Lgnu/lists/Pair;
                //   238: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   241: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
                //   244: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   247: aastore        
                //   248: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //   251: areturn        
                //   252: new             Lgnu/mapping/WrongType;
                //   255: dup_x1         
                //   256: swap           
                //   257: ldc             "car"
                //   259: iconst_1       
                //   260: aload           8
                //   262: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   265: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  235    238    252    266    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 6) {
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
                if (method.selector == 6) {
                    return this.lambda25(o);
                }
                return super.apply1(method, o);
            }
        }
        final CCIDScheme$frame10 $heapFrame = new CCIDScheme$frame10();
        $heapFrame.atr = atr;
        return callWithInputU8vector(list$To$U8vector($heapFrame.atr), $heapFrame.lambda$Fn15);
    }
    
    public static Pair parseAtrTA1(final Object ta1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_0         /* ta1 */
        //     4: getstatic       com/ftsafe/CCIDScheme.Lit149:Lgnu/mapping/SimpleSymbol;
        //     7: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    10: astore_1        /* x */
        //    11: aload_1         /* x */
        //    12: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    15: ifeq            28
        //    18: aload_1         /* x */
        //    19: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    22: ifeq            50
        //    25: goto            44
        //    28: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    31: aload_0         /* ta1 */
        //    32: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    35: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    38: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    41: ifeq            50
        //    44: getstatic       com/ftsafe/CCIDScheme.Lit150:Lgnu/lists/PairWithPosition;
        //    47: goto            132
        //    50: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //    53: getstatic       gnu/kawa/functions/BitwiseOp.ashift:Lgnu/kawa/functions/BitwiseOp;
        //    56: aload_0         /* ta1 */
        //    57: getstatic       com/ftsafe/CCIDScheme.Lit151:Lgnu/math/IntNum;
        //    60: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    63: getstatic       com/ftsafe/CCIDScheme.Lit118:Lgnu/math/IntNum;
        //    66: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    69: astore_2       
        //    70: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //    73: aload_0         /* ta1 */
        //    74: getstatic       com/ftsafe/CCIDScheme.Lit118:Lgnu/math/IntNum;
        //    77: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    80: astore_3        /* b4_1 */
        //    81: getstatic       com/ftsafe/CCIDScheme.Lit152:Lgnu/mapping/SimpleSymbol;
        //    84: aload_2         /* b8_5 */
        //    85: getstatic       com/ftsafe/CCIDScheme.Lit153:Lgnu/lists/PairWithPosition;
        //    88: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    91: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    94: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    97: getstatic       com/ftsafe/CCIDScheme.Lit154:Lgnu/mapping/SimpleSymbol;
        //   100: aload_3         /* b4_1 */
        //   101: getstatic       com/ftsafe/CCIDScheme.Lit155:Lgnu/lists/PairWithPosition;
        //   104: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   107: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   110: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   113: getstatic       com/ftsafe/CCIDScheme.Lit156:Lgnu/mapping/SimpleSymbol;
        //   116: aload_2         /* b8_5 */
        //   117: getstatic       com/ftsafe/CCIDScheme.Lit157:Lgnu/lists/PairWithPosition;
        //   120: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   123: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   126: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   129: invokestatic    gnu/lists/LList.list3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   132: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object getAtrSupportProtocol(final Object atr) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //     6: aload_0         /* atr */
        //     7: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    10: ldc             Lgnu/lists/Pair;.class
        //    12: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    15: dup            
        //    16: astore_3       
        //    17: checkcast       Lgnu/lists/Pair;
        //    20: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    23: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    26: astore_2       
        //    27: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    30: astore_3       
        //    31: aconst_null    
        //    32: astore          4
        //    34: aload_2        
        //    35: invokeinterface java/util/Iterator.hasNext:()Z
        //    40: ifeq            135
        //    43: aload_2        
        //    44: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    49: astore          5
        //    51: new             Lgnu/lists/Pair;
        //    54: dup            
        //    55: getstatic       com/ftsafe/CCIDScheme.Lit144:Lgnu/mapping/SimpleSymbol;
        //    58: aload           5
        //    60: ldc             Lgnu/lists/Pair;.class
        //    62: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    65: dup            
        //    66: astore          8
        //    68: checkcast       Lgnu/lists/Pair;
        //    71: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    74: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    77: astore          a
        //    79: aload           a
        //    81: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    84: ifeq            104
        //    87: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //    90: aload           a
        //    92: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    95: getstatic       com/ftsafe/CCIDScheme.Lit118:Lgnu/math/IntNum;
        //    98: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   101: goto            107
        //   104: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   107: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   110: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   113: aload           4
        //   115: ifnonnull       123
        //   118: dup            
        //   119: astore_3       
        //   120: goto            130
        //   123: aload           4
        //   125: swap           
        //   126: dup_x1         
        //   127: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   130: astore          4
        //   132: goto            34
        //   135: aload_3        
        //   136: invokestatic    com/ftsafe/CCIDScheme.filter:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   139: invokestatic    com/ftsafe/CCIDScheme.listRemoveDuplication:(Ljava/lang/Object;)Ljava/lang/Object;
        //   142: astore_1        /* T */
        //   143: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   146: aload_1         /* T */
        //   147: invokestatic    com/ftsafe/CCIDScheme.isInList:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   150: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   153: ifeq            175
        //   156: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   159: aload_1         /* T */
        //   160: invokestatic    com/ftsafe/CCIDScheme.isInList:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   163: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   166: ifeq            175
        //   169: getstatic       com/ftsafe/CCIDScheme.Lit159:Lgnu/mapping/SimpleSymbol;
        //   172: goto            216
        //   175: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   178: aload_1         /* T */
        //   179: invokestatic    com/ftsafe/CCIDScheme.isInList:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   182: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   185: ifeq            194
        //   188: getstatic       com/ftsafe/CCIDScheme.Lit147:Lgnu/mapping/SimpleSymbol;
        //   191: goto            216
        //   194: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   197: aload_1         /* T */
        //   198: invokestatic    com/ftsafe/CCIDScheme.isInList:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   201: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   204: ifeq            213
        //   207: getstatic       com/ftsafe/CCIDScheme.Lit160:Lgnu/mapping/SimpleSymbol;
        //   210: goto            216
        //   213: getstatic       com/ftsafe/CCIDScheme.Lit147:Lgnu/mapping/SimpleSymbol;
        //   216: areturn        
        //   217: new             Lgnu/mapping/WrongType;
        //   220: dup_x1         
        //   221: swap           
        //   222: ldc             "cdr"
        //   224: iconst_1       
        //   225: aload_3        
        //   226: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   229: athrow         
        //   230: new             Lgnu/mapping/WrongType;
        //   233: dup_x1         
        //   234: swap           
        //   235: ldc             "cdr"
        //   237: iconst_1       
        //   238: aload           8
        //   240: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   243: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  17     20     217    230    Ljava/lang/ClassCastException;
        //  68     71     230    244    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0104:
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
    
    static Object lambda29(final Object x) {
        return x;
    }
    
    public static Pair getAtrTATBForT15(final Object atr) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //     6: aload_0         /* atr */
        //     7: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    10: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    13: astore_2       
        //    14: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    17: astore_3       
        //    18: aconst_null    
        //    19: astore          4
        //    21: aload_2        
        //    22: invokeinterface java/util/Iterator.hasNext:()Z
        //    27: ifeq            150
        //    30: aload_2        
        //    31: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    36: astore          5
        //    38: new             Lgnu/lists/Pair;
        //    41: dup            
        //    42: getstatic       com/ftsafe/CCIDScheme.Lit144:Lgnu/mapping/SimpleSymbol;
        //    45: aload           5
        //    47: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    50: astore          a
        //    52: aload           a
        //    54: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    57: ifeq            119
        //    60: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //    63: aload           a
        //    65: ldc             Lgnu/lists/Pair;.class
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    70: dup            
        //    71: astore          8
        //    73: checkcast       Lgnu/lists/Pair;
        //    76: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    79: getstatic       com/ftsafe/CCIDScheme.Lit118:Lgnu/math/IntNum;
        //    82: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    85: getstatic       com/ftsafe/CCIDScheme.Lit118:Lgnu/math/IntNum;
        //    88: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    91: ifeq            113
        //    94: aload           5
        //    96: ldc             Lgnu/lists/Pair;.class
        //    98: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   101: dup            
        //   102: astore          8
        //   104: checkcast       Lgnu/lists/Pair;
        //   107: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   110: goto            122
        //   113: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   116: goto            122
        //   119: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   122: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   125: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   128: aload           4
        //   130: ifnonnull       138
        //   133: dup            
        //   134: astore_3       
        //   135: goto            145
        //   138: aload           4
        //   140: swap           
        //   141: dup_x1         
        //   142: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   145: astore          4
        //   147: goto            21
        //   150: aload_3        
        //   151: invokestatic    com/ftsafe/CCIDScheme.filter:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   154: astore_1        /* r */
        //   155: aload_1         /* r */
        //   156: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   159: ifeq            168
        //   162: getstatic       com/ftsafe/CCIDScheme.Lit161:Lgnu/lists/PairWithPosition;
        //   165: goto            537
        //   168: aload_1         /* r */
        //   169: ldc             Lgnu/lists/Pair;.class
        //   171: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   174: dup            
        //   175: astore          4
        //   177: checkcast       Lgnu/lists/Pair;
        //   180: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   183: ldc_w           Lgnu/mapping/Symbol;.class
        //   186: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   189: dup            
        //   190: astore          4
        //   192: checkcast       Lgnu/mapping/Symbol;
        //   195: invokestatic    kawa/lib/misc.symbol$To$String:(Lgnu/mapping/Symbol;)Ljava/lang/String;
        //   198: invokestatic    kawa/lib/strings.string$To$List:(Ljava/lang/CharSequence;)Lgnu/lists/LList;
        //   201: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   204: astore_3       
        //   205: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   208: astore          4
        //   210: aconst_null    
        //   211: astore          5
        //   213: aload_3        
        //   214: invokeinterface java/util/Iterator.hasNext:()Z
        //   219: ifeq            274
        //   222: aload_3        
        //   223: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   228: astore          6
        //   230: new             Lgnu/lists/Pair;
        //   233: dup            
        //   234: aload           6
        //   236: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   239: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   242: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   245: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   248: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   251: aload           5
        //   253: ifnonnull       262
        //   256: dup            
        //   257: astore          4
        //   259: goto            269
        //   262: aload           5
        //   264: swap           
        //   265: dup_x1         
        //   266: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   269: astore          5
        //   271: goto            213
        //   274: aload           4
        //   276: astore_2        /* s */
        //   277: iconst_1       
        //   278: aload_2         /* s */
        //   279: getstatic       com/ftsafe/CCIDScheme.Lit162:Lgnu/math/IntNum;
        //   282: aload_2         /* s */
        //   283: invokevirtual   gnu/lists/LList.size:()I
        //   286: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   289: invokestatic    com/ftsafe/CCIDScheme.subu8list:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   292: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   295: astore          4
        //   297: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   300: astore          5
        //   302: aconst_null    
        //   303: astore          6
        //   305: aload           4
        //   307: invokeinterface java/util/Iterator.hasNext:()Z
        //   312: ifeq            371
        //   315: aload           4
        //   317: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   322: astore          7
        //   324: new             Lgnu/lists/Pair;
        //   327: dup            
        //   328: aload           7
        //   330: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   333: checkcast       Ljava/lang/Number;
        //   336: invokevirtual   java/lang/Number.intValue:()I
        //   339: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   342: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   345: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   348: aload           6
        //   350: ifnonnull       359
        //   353: dup            
        //   354: astore          5
        //   356: goto            366
        //   359: aload           6
        //   361: swap           
        //   362: dup_x1         
        //   363: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   366: astore          6
        //   368: goto            305
        //   371: aload           5
        //   373: invokestatic    kawa/lib/strings.list$To$String:(Lgnu/lists/LList;)Ljava/lang/CharSequence;
        //   376: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;)Ljava/lang/Object;
        //   379: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   382: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   385: astore_3        /* n */
        //   386: iconst_2       
        //   387: anewarray       Ljava/lang/Object;
        //   390: dup            
        //   391: iconst_0       
        //   392: ldc_w           "interface"
        //   395: aastore        
        //   396: dup            
        //   397: iconst_1       
        //   398: aload_3         /* n */
        //   399: ldc             Ljava/lang/Number;.class
        //   401: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   404: dup            
        //   405: astore          5
        //   407: checkcast       Ljava/lang/Number;
        //   410: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
        //   413: aastore        
        //   414: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   417: invokestatic    kawa/lib/misc.string$To$Symbol:(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
        //   420: astore          i
        //   422: getstatic       com/ftsafe/CCIDScheme.Lit141:Lgnu/mapping/SimpleSymbol;
        //   425: aload           i
        //   427: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   430: aload_0         /* atr */
        //   431: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   434: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   437: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   440: astore          5
        //   442: getstatic       com/ftsafe/CCIDScheme.Lit142:Lgnu/mapping/SimpleSymbol;
        //   445: aload           i
        //   447: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   450: aload_0         /* atr */
        //   451: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   454: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   457: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   460: astore          tb15
        //   462: getstatic       com/ftsafe/CCIDScheme.Lit163:Lgnu/mapping/SimpleSymbol;
        //   465: aload           ta15
        //   467: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   470: ifeq            492
        //   473: aload           ta15
        //   475: ldc             Lgnu/lists/Pair;.class
        //   477: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   480: dup            
        //   481: astore          7
        //   483: checkcast       Lgnu/lists/Pair;
        //   486: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   489: goto            495
        //   492: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   495: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   498: getstatic       com/ftsafe/CCIDScheme.Lit164:Lgnu/mapping/SimpleSymbol;
        //   501: aload           tb15
        //   503: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   506: ifeq            528
        //   509: aload           tb15
        //   511: ldc             Lgnu/lists/Pair;.class
        //   513: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   516: dup            
        //   517: astore          7
        //   519: checkcast       Lgnu/lists/Pair;
        //   522: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   525: goto            531
        //   528: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   531: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   534: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   537: areturn        
        //   538: new             Lgnu/mapping/WrongType;
        //   541: dup_x1         
        //   542: swap           
        //   543: ldc             "car"
        //   545: iconst_1       
        //   546: aload           8
        //   548: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   551: athrow         
        //   552: new             Lgnu/mapping/WrongType;
        //   555: dup_x1         
        //   556: swap           
        //   557: ldc             "car"
        //   559: iconst_1       
        //   560: aload           8
        //   562: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   565: athrow         
        //   566: new             Lgnu/mapping/WrongType;
        //   569: dup_x1         
        //   570: swap           
        //   571: ldc             "car"
        //   573: iconst_1       
        //   574: aload           4
        //   576: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   579: athrow         
        //   580: new             Lgnu/mapping/WrongType;
        //   583: dup_x1         
        //   584: swap           
        //   585: ldc_w           "symbol->string"
        //   588: iconst_1       
        //   589: aload           4
        //   591: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   594: athrow         
        //   595: new             Lgnu/mapping/WrongType;
        //   598: dup_x1         
        //   599: swap           
        //   600: ldc_w           "number->string"
        //   603: iconst_1       
        //   604: aload           5
        //   606: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   609: athrow         
        //   610: new             Lgnu/mapping/WrongType;
        //   613: dup_x1         
        //   614: swap           
        //   615: ldc             "car"
        //   617: iconst_1       
        //   618: aload           7
        //   620: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   623: athrow         
        //   624: new             Lgnu/mapping/WrongType;
        //   627: dup_x1         
        //   628: swap           
        //   629: ldc             "car"
        //   631: iconst_1       
        //   632: aload           7
        //   634: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   637: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  73     76     538    552    Ljava/lang/ClassCastException;
        //  104    107    552    566    Ljava/lang/ClassCastException;
        //  177    180    566    580    Ljava/lang/ClassCastException;
        //  192    195    580    595    Ljava/lang/ClassCastException;
        //  407    410    595    610    Ljava/lang/ClassCastException;
        //  483    486    610    624    Ljava/lang/ClassCastException;
        //  519    522    624    638    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object lambda30(final Object x) {
        return x;
    }
    
    public static Object getPps1(final Object atr) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       com/ftsafe/CCIDScheme.Lit98:Lgnu/mapping/SimpleSymbol;
        //     6: getstatic       com/ftsafe/CCIDScheme.current_dev_interface:Lgnu/mapping/Procedure;
        //     9: invokevirtual   gnu/mapping/Procedure.apply0:()Ljava/lang/Object;
        //    12: getstatic       com/ftsafe/CCIDScheme.descriptor$Mninfo:Ljava/lang/Object;
        //    15: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    18: ldc             Lgnu/lists/Pair;.class
        //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    23: dup            
        //    24: astore_2       
        //    25: checkcast       Lgnu/lists/Pair;
        //    28: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    31: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    34: ldc             Lgnu/lists/Pair;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore_2       
        //    41: checkcast       Lgnu/lists/Pair;
        //    44: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    47: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    50: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    53: astore_1        /* dwDefaultClock */
        //    54: getstatic       com/ftsafe/CCIDScheme.Lit78:Lgnu/mapping/SimpleSymbol;
        //    57: getstatic       com/ftsafe/CCIDScheme.Lit98:Lgnu/mapping/SimpleSymbol;
        //    60: getstatic       com/ftsafe/CCIDScheme.current_dev_interface:Lgnu/mapping/Procedure;
        //    63: invokevirtual   gnu/mapping/Procedure.apply0:()Ljava/lang/Object;
        //    66: getstatic       com/ftsafe/CCIDScheme.descriptor$Mninfo:Ljava/lang/Object;
        //    69: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    72: ldc             Lgnu/lists/Pair;.class
        //    74: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    77: dup            
        //    78: astore_3       
        //    79: checkcast       Lgnu/lists/Pair;
        //    82: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    85: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    88: ldc             Lgnu/lists/Pair;.class
        //    90: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    93: dup            
        //    94: astore_3       
        //    95: checkcast       Lgnu/lists/Pair;
        //    98: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   101: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   104: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   107: astore_2        /* dwMaxDataRate */
        //   108: getstatic       com/ftsafe/CCIDScheme.Lit141:Lgnu/mapping/SimpleSymbol;
        //   111: getstatic       com/ftsafe/CCIDScheme.Lit165:Lgnu/mapping/SimpleSymbol;
        //   114: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   117: aload_0         /* atr */
        //   118: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   121: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   124: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   127: astore          ta1
        //   129: aload           ta1
        //   131: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   134: ifeq            156
        //   137: aload           ta1
        //   139: ldc             Lgnu/lists/Pair;.class
        //   141: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   144: dup            
        //   145: astore          5
        //   147: checkcast       Lgnu/lists/Pair;
        //   150: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   153: goto            159
        //   156: getstatic       com/ftsafe/CCIDScheme.Lit149:Lgnu/mapping/SimpleSymbol;
        //   159: invokestatic    com/ftsafe/CCIDScheme.parseAtrTA1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   162: astore_3        /* Fi_Di_fmax */
        //   163: getstatic       com/ftsafe/CCIDScheme.Lit152:Lgnu/mapping/SimpleSymbol;
        //   166: aload_3         /* Fi_Di_fmax */
        //   167: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   170: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   173: astore          Fi
        //   175: getstatic       com/ftsafe/CCIDScheme.Lit154:Lgnu/mapping/SimpleSymbol;
        //   178: aload_3         /* Fi_Di_fmax */
        //   179: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   182: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   185: astore          Di
        //   187: getstatic       gnu/kawa/functions/DivideOp.quotient:Lgnu/kawa/functions/DivideOp;
        //   190: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   193: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   196: aload_1         /* dwDefaultClock */
        //   197: getstatic       com/ftsafe/CCIDScheme.Lit166:Lgnu/math/IntNum;
        //   200: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   203: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   206: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   209: getstatic       com/ftsafe/CCIDScheme.Lit167:Lgnu/math/IntNum;
        //   212: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   215: astore          default_baudrate
        //   217: getstatic       gnu/kawa/functions/DivideOp.quotient:Lgnu/kawa/functions/DivideOp;
        //   220: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   223: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   226: aload_1         /* dwDefaultClock */
        //   227: getstatic       com/ftsafe/CCIDScheme.Lit166:Lgnu/math/IntNum;
        //   230: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   233: aload           Di
        //   235: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   238: aload           Fi
        //   240: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   243: astore          card_baudrate
        //   245: getstatic       com/ftsafe/CCIDScheme.Lit141:Lgnu/mapping/SimpleSymbol;
        //   248: getstatic       com/ftsafe/CCIDScheme.Lit165:Lgnu/mapping/SimpleSymbol;
        //   251: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   254: aload_0         /* atr */
        //   255: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   258: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   261: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   264: astore          _ta
        //   266: aload           _ta
        //   268: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   271: ifeq            293
        //   274: aload           _ta
        //   276: ldc             Lgnu/lists/Pair;.class
        //   278: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   281: dup            
        //   282: astore          10
        //   284: checkcast       Lgnu/lists/Pair;
        //   287: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   290: goto            296
        //   293: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   296: astore          ta
        //   298: aload           card_baudrate
        //   300: aload           default_baudrate
        //   302: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   305: ifeq            417
        //   308: aload           card_baudrate
        //   310: aload_2         /* dwMaxDataRate */
        //   311: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   314: ifeq            417
        //   317: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   320: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   323: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   326: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   329: astore          x
        //   331: aload           x
        //   333: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   336: ifeq            350
        //   339: aload           x
        //   341: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   344: ifeq            369
        //   347: goto            364
        //   350: aload           card_baudrate
        //   352: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   355: invokestatic    com/ftsafe/CCIDScheme.isInList:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   358: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   361: ifeq            369
        //   364: aload           ta
        //   366: goto            458
        //   369: getstatic       com/ftsafe/CCIDScheme.Lit141:Lgnu/mapping/SimpleSymbol;
        //   372: getstatic       com/ftsafe/CCIDScheme.Lit168:Lgnu/mapping/SimpleSymbol;
        //   375: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   378: aload_0         /* atr */
        //   379: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   382: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   385: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   388: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   391: ifeq            411
        //   394: iconst_1       
        //   395: anewarray       Ljava/lang/Object;
        //   398: dup            
        //   399: iconst_0       
        //   400: ldc_w           "TA2 present -> specific mode: the card is supporting only the baud rate specified in TA1 but reader does not support this value. Reject the card."
        //   403: aastore        
        //   404: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   407: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   410: athrow         
        //   411: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   414: goto            458
        //   417: aload           ta
        //   419: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   422: ifeq            455
        //   425: aload           card_baudrate
        //   427: iconst_1       
        //   428: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   431: aload_2         /* dwMaxDataRate */
        //   432: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   435: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   438: ifeq            455
        //   441: aload           ta
        //   443: getstatic       com/ftsafe/CCIDScheme.Lit169:Lgnu/math/IntNum;
        //   446: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   449: ifeq            455
        //   452: goto            455
        //   455: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   458: areturn        
        //   459: new             Lgnu/mapping/WrongType;
        //   462: dup_x1         
        //   463: swap           
        //   464: ldc             "cdr"
        //   466: iconst_1       
        //   467: aload_2        
        //   468: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   471: athrow         
        //   472: new             Lgnu/mapping/WrongType;
        //   475: dup_x1         
        //   476: swap           
        //   477: ldc             "cdr"
        //   479: iconst_1       
        //   480: aload_2        
        //   481: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   484: athrow         
        //   485: new             Lgnu/mapping/WrongType;
        //   488: dup_x1         
        //   489: swap           
        //   490: ldc             "cdr"
        //   492: iconst_1       
        //   493: aload_3        
        //   494: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   497: athrow         
        //   498: new             Lgnu/mapping/WrongType;
        //   501: dup_x1         
        //   502: swap           
        //   503: ldc             "cdr"
        //   505: iconst_1       
        //   506: aload_3        
        //   507: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   510: athrow         
        //   511: new             Lgnu/mapping/WrongType;
        //   514: dup_x1         
        //   515: swap           
        //   516: ldc             "car"
        //   518: iconst_1       
        //   519: aload           5
        //   521: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   524: athrow         
        //   525: new             Lgnu/mapping/WrongType;
        //   528: dup_x1         
        //   529: swap           
        //   530: ldc             "car"
        //   532: iconst_1       
        //   533: aload           10
        //   535: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   538: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  25     28     459    472    Ljava/lang/ClassCastException;
        //  41     44     472    485    Ljava/lang/ClassCastException;
        //  79     82     485    498    Ljava/lang/ClassCastException;
        //  95     98     498    511    Ljava/lang/ClassCastException;
        //  147    150    511    525    Ljava/lang/ClassCastException;
        //  284    287    525    539    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 231 out of bounds for length 231
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
    
    public static Object generatePPSExchange(final Object atr) {
        final Object _pps1 = getPps1(atr);
        final Object pps1 = KawaConvert.isTrue(_pps1) ? (KawaConvert.isTrue(assocEX("USE-DEFAULT-PPS-EXCHANGE", assocEX(com.ftsafe.CCIDScheme.Lit170, atr))) ? com.ftsafe.CCIDScheme.Lit171 : _pps1) : _pps1;
        final Object force = Promise.force(assocEX(com.ftsafe.CCIDScheme.Lit164, getAtrTATBForT15(atr)), Pair.class);
        try {
            final Object pps2 = lists.car((Pair)force);
            final Object pps3 = BitwiseOp.ior.apply2(BitOps.ior(BitOps.ior(com.ftsafe.CCIDScheme.Lit1, KawaConvert.isTrue(pps2) ? com.ftsafe.CCIDScheme.Lit172 : com.ftsafe.CCIDScheme.Lit1), KawaConvert.isTrue(pps1) ? com.ftsafe.CCIDScheme.Lit6 : com.ftsafe.CCIDScheme.Lit1), KawaConvert.isTrue(Scheme.isEqual.apply2(getAtrSupportProtocol(atr), com.ftsafe.CCIDScheme.Lit147)) ? com.ftsafe.CCIDScheme.Lit1 : (KawaConvert.isTrue(Scheme.isEqual.apply2(getAtrSupportProtocol(atr), com.ftsafe.CCIDScheme.Lit160)) ? com.ftsafe.CCIDScheme.Lit2 : (KawaConvert.isTrue(Scheme.isEqual.apply2(getAtrSupportProtocol(atr), com.ftsafe.CCIDScheme.Lit159)) ? com.ftsafe.CCIDScheme.Lit2 : Values.empty)));
            final ModuleMethod lambda$Fn19 = com.ftsafe.CCIDScheme.lambda$Fn19;
            final Pair list1 = LList.list1(com.ftsafe.CCIDScheme.Lit9);
            LList.chain4(list1, pps3, pps1, pps2, Boolean.FALSE);
            final Object P = filter(lambda$Fn19, list1);
            final Object pck = listXor(P);
            return append.append$V(new Object[] { P, LList.list1(pck) });
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "car", 1, force);
        }
    }
    
    static Object lambda31(final Object x) {
        return x;
    }
    
    public static Object getAtrIFSC(final Object atr) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       kawa/lib/misc.symbol$Qu:Lgnu/expr/ModuleMethod;
        //     6: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //     9: aload_0         /* atr */
        //    10: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    13: ldc             Lgnu/lists/Pair;.class
        //    15: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    18: dup            
        //    19: astore          4
        //    21: checkcast       Lgnu/lists/Pair;
        //    24: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    27: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    30: astore_3       
        //    31: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    34: astore          4
        //    36: aconst_null    
        //    37: astore          5
        //    39: aload_3        
        //    40: invokeinterface java/util/Iterator.hasNext:()Z
        //    45: ifeq            471
        //    48: aload_3        
        //    49: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    54: astore          6
        //    56: aload           6
        //    58: ldc             Lgnu/lists/Pair;.class
        //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    63: dup            
        //    64: astore          9
        //    66: checkcast       Lgnu/lists/Pair;
        //    69: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    72: pop            
        //    73: getstatic       com/ftsafe/CCIDScheme.Lit144:Lgnu/mapping/SimpleSymbol;
        //    76: aload           6
        //    78: ldc             Lgnu/lists/Pair;.class
        //    80: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    83: dup            
        //    84: astore          9
        //    86: checkcast       Lgnu/lists/Pair;
        //    89: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    92: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    95: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    98: ifeq            431
        //   101: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   104: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   107: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   110: getstatic       com/ftsafe/CCIDScheme.Lit144:Lgnu/mapping/SimpleSymbol;
        //   113: aload           6
        //   115: ldc             Lgnu/lists/Pair;.class
        //   117: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   120: dup            
        //   121: astore          9
        //   123: checkcast       Lgnu/lists/Pair;
        //   126: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   129: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   132: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   135: getstatic       com/ftsafe/CCIDScheme.Lit118:Lgnu/math/IntNum;
        //   138: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   141: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   144: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   147: ifeq            431
        //   150: aload           6
        //   152: ldc             Lgnu/lists/Pair;.class
        //   154: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   157: dup            
        //   158: astore          11
        //   160: checkcast       Lgnu/lists/Pair;
        //   163: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   166: ldc_w           Lgnu/mapping/Symbol;.class
        //   169: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   172: dup            
        //   173: astore          11
        //   175: checkcast       Lgnu/mapping/Symbol;
        //   178: invokestatic    kawa/lib/misc.symbol$To$String:(Lgnu/mapping/Symbol;)Ljava/lang/String;
        //   181: invokestatic    kawa/lib/strings.string$To$List:(Ljava/lang/CharSequence;)Lgnu/lists/LList;
        //   184: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   187: astore          10
        //   189: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   192: astore          11
        //   194: aconst_null    
        //   195: astore          12
        //   197: aload           10
        //   199: invokeinterface java/util/Iterator.hasNext:()Z
        //   204: ifeq            260
        //   207: aload           10
        //   209: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   214: astore          13
        //   216: new             Lgnu/lists/Pair;
        //   219: dup            
        //   220: aload           13
        //   222: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   225: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   228: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   231: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   234: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   237: aload           12
        //   239: ifnonnull       248
        //   242: dup            
        //   243: astore          11
        //   245: goto            255
        //   248: aload           12
        //   250: swap           
        //   251: dup_x1         
        //   252: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   255: astore          12
        //   257: goto            197
        //   260: aload           11
        //   262: astore          s
        //   264: iconst_1       
        //   265: aload           s
        //   267: getstatic       com/ftsafe/CCIDScheme.Lit162:Lgnu/math/IntNum;
        //   270: aload           s
        //   272: invokevirtual   gnu/lists/LList.size:()I
        //   275: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   278: invokestatic    com/ftsafe/CCIDScheme.subu8list:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   281: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   284: astore          11
        //   286: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   289: astore          12
        //   291: aconst_null    
        //   292: astore          13
        //   294: aload           11
        //   296: invokeinterface java/util/Iterator.hasNext:()Z
        //   301: ifeq            360
        //   304: aload           11
        //   306: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   311: astore          14
        //   313: new             Lgnu/lists/Pair;
        //   316: dup            
        //   317: aload           14
        //   319: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   322: checkcast       Ljava/lang/Number;
        //   325: invokevirtual   java/lang/Number.intValue:()I
        //   328: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   331: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   334: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   337: aload           13
        //   339: ifnonnull       348
        //   342: dup            
        //   343: astore          12
        //   345: goto            355
        //   348: aload           13
        //   350: swap           
        //   351: dup_x1         
        //   352: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   355: astore          13
        //   357: goto            294
        //   360: aload           12
        //   362: invokestatic    kawa/lib/strings.list$To$String:(Lgnu/lists/LList;)Ljava/lang/CharSequence;
        //   365: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;)Ljava/lang/Object;
        //   368: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   371: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   374: astore          n
        //   376: aload           n
        //   378: getstatic       com/ftsafe/CCIDScheme.Lit99:Lgnu/math/IntNum;
        //   381: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   384: ifeq            425
        //   387: iconst_2       
        //   388: anewarray       Ljava/lang/Object;
        //   391: dup            
        //   392: iconst_0       
        //   393: ldc_w           "interface"
        //   396: aastore        
        //   397: dup            
        //   398: iconst_1       
        //   399: aload           n
        //   401: ldc             Ljava/lang/Number;.class
        //   403: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   406: dup            
        //   407: astore          11
        //   409: checkcast       Ljava/lang/Number;
        //   412: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
        //   415: aastore        
        //   416: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   419: invokestatic    kawa/lib/misc.string$To$Symbol:(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
        //   422: goto            434
        //   425: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   428: goto            434
        //   431: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   434: astore          8
        //   436: new             Lgnu/lists/Pair;
        //   439: dup            
        //   440: aload           8
        //   442: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   445: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   448: aload           5
        //   450: ifnonnull       459
        //   453: dup            
        //   454: astore          4
        //   456: goto            466
        //   459: aload           5
        //   461: swap           
        //   462: dup_x1         
        //   463: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   466: astore          5
        //   468: goto            39
        //   471: aload           4
        //   473: invokestatic    com/ftsafe/CCIDScheme.filter:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   476: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   479: astore_2       
        //   480: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   483: astore_3       
        //   484: aconst_null    
        //   485: astore          4
        //   487: aload_2        
        //   488: invokeinterface java/util/Iterator.hasNext:()Z
        //   493: ifeq            675
        //   496: aload_2        
        //   497: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   502: astore          5
        //   504: new             Lgnu/lists/Pair;
        //   507: dup            
        //   508: aload           5
        //   510: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   513: aload_0         /* atr */
        //   514: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   517: ldc             Lgnu/lists/Pair;.class
        //   519: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   522: dup            
        //   523: astore          7
        //   525: checkcast       Lgnu/lists/Pair;
        //   528: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   531: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   534: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   537: ifeq            644
        //   540: getstatic       com/ftsafe/CCIDScheme.Lit141:Lgnu/mapping/SimpleSymbol;
        //   543: aload           5
        //   545: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   548: aload_0         /* atr */
        //   549: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   552: ldc             Lgnu/lists/Pair;.class
        //   554: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   557: dup            
        //   558: astore          7
        //   560: checkcast       Lgnu/lists/Pair;
        //   563: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   566: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   569: ldc             Lgnu/lists/Pair;.class
        //   571: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   574: dup            
        //   575: astore          7
        //   577: checkcast       Lgnu/lists/Pair;
        //   580: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   583: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   586: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   589: ifeq            644
        //   592: getstatic       com/ftsafe/CCIDScheme.Lit141:Lgnu/mapping/SimpleSymbol;
        //   595: aload           5
        //   597: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   600: aload_0         /* atr */
        //   601: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   604: ldc             Lgnu/lists/Pair;.class
        //   606: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   609: dup            
        //   610: astore          7
        //   612: checkcast       Lgnu/lists/Pair;
        //   615: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   618: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   621: ldc             Lgnu/lists/Pair;.class
        //   623: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   626: dup            
        //   627: astore          7
        //   629: checkcast       Lgnu/lists/Pair;
        //   632: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   635: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   638: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   641: goto            647
        //   644: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   647: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   650: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   653: aload           4
        //   655: ifnonnull       663
        //   658: dup            
        //   659: astore_3       
        //   660: goto            670
        //   663: aload           4
        //   665: swap           
        //   666: dup_x1         
        //   667: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   670: astore          4
        //   672: goto            487
        //   675: aload_3        
        //   676: invokestatic    com/ftsafe/CCIDScheme.filter:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   679: astore_1        /* ret */
        //   680: aload_1         /* ret */
        //   681: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   684: ifeq            693
        //   687: getstatic       com/ftsafe/CCIDScheme.Lit172:Lgnu/math/IntNum;
        //   690: goto            707
        //   693: aload_1         /* ret */
        //   694: ldc             Lgnu/lists/Pair;.class
        //   696: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   699: dup            
        //   700: astore_2       
        //   701: checkcast       Lgnu/lists/Pair;
        //   704: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   707: areturn        
        //   708: new             Lgnu/mapping/WrongType;
        //   711: dup_x1         
        //   712: swap           
        //   713: ldc             "cdr"
        //   715: iconst_1       
        //   716: aload           4
        //   718: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   721: athrow         
        //   722: new             Lgnu/mapping/WrongType;
        //   725: dup_x1         
        //   726: swap           
        //   727: ldc             "car"
        //   729: iconst_1       
        //   730: aload           9
        //   732: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   735: athrow         
        //   736: new             Lgnu/mapping/WrongType;
        //   739: dup_x1         
        //   740: swap           
        //   741: ldc             "cdr"
        //   743: iconst_1       
        //   744: aload           9
        //   746: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   749: athrow         
        //   750: new             Lgnu/mapping/WrongType;
        //   753: dup_x1         
        //   754: swap           
        //   755: ldc             "cdr"
        //   757: iconst_1       
        //   758: aload           9
        //   760: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   763: athrow         
        //   764: new             Lgnu/mapping/WrongType;
        //   767: dup_x1         
        //   768: swap           
        //   769: ldc             "car"
        //   771: iconst_1       
        //   772: aload           11
        //   774: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   777: athrow         
        //   778: new             Lgnu/mapping/WrongType;
        //   781: dup_x1         
        //   782: swap           
        //   783: ldc_w           "symbol->string"
        //   786: iconst_1       
        //   787: aload           11
        //   789: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   792: athrow         
        //   793: new             Lgnu/mapping/WrongType;
        //   796: dup_x1         
        //   797: swap           
        //   798: ldc_w           "number->string"
        //   801: iconst_1       
        //   802: aload           11
        //   804: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   807: athrow         
        //   808: new             Lgnu/mapping/WrongType;
        //   811: dup_x1         
        //   812: swap           
        //   813: ldc             "cdr"
        //   815: iconst_1       
        //   816: aload           7
        //   818: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   821: athrow         
        //   822: new             Lgnu/mapping/WrongType;
        //   825: dup_x1         
        //   826: swap           
        //   827: ldc             "cdr"
        //   829: iconst_1       
        //   830: aload           7
        //   832: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   835: athrow         
        //   836: new             Lgnu/mapping/WrongType;
        //   839: dup_x1         
        //   840: swap           
        //   841: ldc             "cdr"
        //   843: iconst_1       
        //   844: aload           7
        //   846: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   849: athrow         
        //   850: new             Lgnu/mapping/WrongType;
        //   853: dup_x1         
        //   854: swap           
        //   855: ldc             "cdr"
        //   857: iconst_1       
        //   858: aload           7
        //   860: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   863: athrow         
        //   864: new             Lgnu/mapping/WrongType;
        //   867: dup_x1         
        //   868: swap           
        //   869: ldc             "cdr"
        //   871: iconst_1       
        //   872: aload           7
        //   874: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   877: athrow         
        //   878: new             Lgnu/mapping/WrongType;
        //   881: dup_x1         
        //   882: swap           
        //   883: ldc             "car"
        //   885: iconst_1       
        //   886: aload_2        
        //   887: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   890: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  21     24     708    722    Ljava/lang/ClassCastException;
        //  66     69     722    736    Ljava/lang/ClassCastException;
        //  86     89     736    750    Ljava/lang/ClassCastException;
        //  123    126    750    764    Ljava/lang/ClassCastException;
        //  160    163    764    778    Ljava/lang/ClassCastException;
        //  175    178    778    793    Ljava/lang/ClassCastException;
        //  409    412    793    808    Ljava/lang/ClassCastException;
        //  525    528    808    822    Ljava/lang/ClassCastException;
        //  560    563    822    836    Ljava/lang/ClassCastException;
        //  577    580    836    850    Ljava/lang/ClassCastException;
        //  612    615    850    864    Ljava/lang/ClassCastException;
        //  629    632    864    878    Ljava/lang/ClassCastException;
        //  701    704    878    891    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 400 out of bounds for length 400
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
    
    public static Object getAtrTCForT1(final Object atr) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       kawa/lib/misc.symbol$Qu:Lgnu/expr/ModuleMethod;
        //     6: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //     9: aload_0         /* atr */
        //    10: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    13: ldc             Lgnu/lists/Pair;.class
        //    15: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    18: dup            
        //    19: astore          4
        //    21: checkcast       Lgnu/lists/Pair;
        //    24: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    27: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    30: astore_3       
        //    31: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    34: astore          4
        //    36: aconst_null    
        //    37: astore          5
        //    39: aload_3        
        //    40: invokeinterface java/util/Iterator.hasNext:()Z
        //    45: ifeq            471
        //    48: aload_3        
        //    49: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    54: astore          6
        //    56: aload           6
        //    58: ldc             Lgnu/lists/Pair;.class
        //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    63: dup            
        //    64: astore          9
        //    66: checkcast       Lgnu/lists/Pair;
        //    69: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    72: pop            
        //    73: getstatic       com/ftsafe/CCIDScheme.Lit144:Lgnu/mapping/SimpleSymbol;
        //    76: aload           6
        //    78: ldc             Lgnu/lists/Pair;.class
        //    80: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    83: dup            
        //    84: astore          9
        //    86: checkcast       Lgnu/lists/Pair;
        //    89: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    92: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    95: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    98: ifeq            431
        //   101: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   104: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   107: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   110: getstatic       com/ftsafe/CCIDScheme.Lit144:Lgnu/mapping/SimpleSymbol;
        //   113: aload           6
        //   115: ldc             Lgnu/lists/Pair;.class
        //   117: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   120: dup            
        //   121: astore          9
        //   123: checkcast       Lgnu/lists/Pair;
        //   126: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   129: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   132: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   135: getstatic       com/ftsafe/CCIDScheme.Lit118:Lgnu/math/IntNum;
        //   138: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   141: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   144: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   147: ifeq            431
        //   150: aload           6
        //   152: ldc             Lgnu/lists/Pair;.class
        //   154: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   157: dup            
        //   158: astore          11
        //   160: checkcast       Lgnu/lists/Pair;
        //   163: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   166: ldc_w           Lgnu/mapping/Symbol;.class
        //   169: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   172: dup            
        //   173: astore          11
        //   175: checkcast       Lgnu/mapping/Symbol;
        //   178: invokestatic    kawa/lib/misc.symbol$To$String:(Lgnu/mapping/Symbol;)Ljava/lang/String;
        //   181: invokestatic    kawa/lib/strings.string$To$List:(Ljava/lang/CharSequence;)Lgnu/lists/LList;
        //   184: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   187: astore          10
        //   189: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   192: astore          11
        //   194: aconst_null    
        //   195: astore          12
        //   197: aload           10
        //   199: invokeinterface java/util/Iterator.hasNext:()Z
        //   204: ifeq            260
        //   207: aload           10
        //   209: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   214: astore          13
        //   216: new             Lgnu/lists/Pair;
        //   219: dup            
        //   220: aload           13
        //   222: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   225: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   228: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   231: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   234: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   237: aload           12
        //   239: ifnonnull       248
        //   242: dup            
        //   243: astore          11
        //   245: goto            255
        //   248: aload           12
        //   250: swap           
        //   251: dup_x1         
        //   252: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   255: astore          12
        //   257: goto            197
        //   260: aload           11
        //   262: astore          s
        //   264: iconst_1       
        //   265: aload           s
        //   267: getstatic       com/ftsafe/CCIDScheme.Lit162:Lgnu/math/IntNum;
        //   270: aload           s
        //   272: invokevirtual   gnu/lists/LList.size:()I
        //   275: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   278: invokestatic    com/ftsafe/CCIDScheme.subu8list:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   281: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   284: astore          11
        //   286: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   289: astore          12
        //   291: aconst_null    
        //   292: astore          13
        //   294: aload           11
        //   296: invokeinterface java/util/Iterator.hasNext:()Z
        //   301: ifeq            360
        //   304: aload           11
        //   306: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   311: astore          14
        //   313: new             Lgnu/lists/Pair;
        //   316: dup            
        //   317: aload           14
        //   319: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   322: checkcast       Ljava/lang/Number;
        //   325: invokevirtual   java/lang/Number.intValue:()I
        //   328: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   331: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   334: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   337: aload           13
        //   339: ifnonnull       348
        //   342: dup            
        //   343: astore          12
        //   345: goto            355
        //   348: aload           13
        //   350: swap           
        //   351: dup_x1         
        //   352: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   355: astore          13
        //   357: goto            294
        //   360: aload           12
        //   362: invokestatic    kawa/lib/strings.list$To$String:(Lgnu/lists/LList;)Ljava/lang/CharSequence;
        //   365: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;)Ljava/lang/Object;
        //   368: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   371: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   374: astore          n
        //   376: aload           n
        //   378: getstatic       com/ftsafe/CCIDScheme.Lit99:Lgnu/math/IntNum;
        //   381: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   384: ifeq            425
        //   387: iconst_2       
        //   388: anewarray       Ljava/lang/Object;
        //   391: dup            
        //   392: iconst_0       
        //   393: ldc_w           "interface"
        //   396: aastore        
        //   397: dup            
        //   398: iconst_1       
        //   399: aload           n
        //   401: ldc             Ljava/lang/Number;.class
        //   403: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   406: dup            
        //   407: astore          11
        //   409: checkcast       Ljava/lang/Number;
        //   412: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
        //   415: aastore        
        //   416: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   419: invokestatic    kawa/lib/misc.string$To$Symbol:(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
        //   422: goto            434
        //   425: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   428: goto            434
        //   431: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   434: astore          8
        //   436: new             Lgnu/lists/Pair;
        //   439: dup            
        //   440: aload           8
        //   442: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   445: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   448: aload           5
        //   450: ifnonnull       459
        //   453: dup            
        //   454: astore          4
        //   456: goto            466
        //   459: aload           5
        //   461: swap           
        //   462: dup_x1         
        //   463: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   466: astore          5
        //   468: goto            39
        //   471: aload           4
        //   473: invokestatic    com/ftsafe/CCIDScheme.filter:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   476: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   479: astore_2       
        //   480: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   483: astore_3       
        //   484: aconst_null    
        //   485: astore          4
        //   487: aload_2        
        //   488: invokeinterface java/util/Iterator.hasNext:()Z
        //   493: ifeq            675
        //   496: aload_2        
        //   497: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   502: astore          5
        //   504: new             Lgnu/lists/Pair;
        //   507: dup            
        //   508: aload           5
        //   510: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   513: aload_0         /* atr */
        //   514: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   517: ldc             Lgnu/lists/Pair;.class
        //   519: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   522: dup            
        //   523: astore          7
        //   525: checkcast       Lgnu/lists/Pair;
        //   528: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   531: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   534: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   537: ifeq            644
        //   540: getstatic       com/ftsafe/CCIDScheme.Lit143:Lgnu/mapping/SimpleSymbol;
        //   543: aload           5
        //   545: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   548: aload_0         /* atr */
        //   549: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   552: ldc             Lgnu/lists/Pair;.class
        //   554: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   557: dup            
        //   558: astore          7
        //   560: checkcast       Lgnu/lists/Pair;
        //   563: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   566: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   569: ldc             Lgnu/lists/Pair;.class
        //   571: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   574: dup            
        //   575: astore          7
        //   577: checkcast       Lgnu/lists/Pair;
        //   580: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   583: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   586: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   589: ifeq            644
        //   592: getstatic       com/ftsafe/CCIDScheme.Lit143:Lgnu/mapping/SimpleSymbol;
        //   595: aload           5
        //   597: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   600: aload_0         /* atr */
        //   601: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   604: ldc             Lgnu/lists/Pair;.class
        //   606: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   609: dup            
        //   610: astore          7
        //   612: checkcast       Lgnu/lists/Pair;
        //   615: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   618: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   621: ldc             Lgnu/lists/Pair;.class
        //   623: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   626: dup            
        //   627: astore          7
        //   629: checkcast       Lgnu/lists/Pair;
        //   632: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   635: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   638: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   641: goto            647
        //   644: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   647: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   650: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   653: aload           4
        //   655: ifnonnull       663
        //   658: dup            
        //   659: astore_3       
        //   660: goto            670
        //   663: aload           4
        //   665: swap           
        //   666: dup_x1         
        //   667: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   670: astore          4
        //   672: goto            487
        //   675: aload_3        
        //   676: invokestatic    com/ftsafe/CCIDScheme.filter:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   679: astore_1        /* ret */
        //   680: aload_1         /* ret */
        //   681: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   684: ifeq            693
        //   687: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   690: goto            707
        //   693: aload_1         /* ret */
        //   694: ldc             Lgnu/lists/Pair;.class
        //   696: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   699: dup            
        //   700: astore_2       
        //   701: checkcast       Lgnu/lists/Pair;
        //   704: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   707: areturn        
        //   708: new             Lgnu/mapping/WrongType;
        //   711: dup_x1         
        //   712: swap           
        //   713: ldc             "cdr"
        //   715: iconst_1       
        //   716: aload           4
        //   718: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   721: athrow         
        //   722: new             Lgnu/mapping/WrongType;
        //   725: dup_x1         
        //   726: swap           
        //   727: ldc             "car"
        //   729: iconst_1       
        //   730: aload           9
        //   732: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   735: athrow         
        //   736: new             Lgnu/mapping/WrongType;
        //   739: dup_x1         
        //   740: swap           
        //   741: ldc             "cdr"
        //   743: iconst_1       
        //   744: aload           9
        //   746: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   749: athrow         
        //   750: new             Lgnu/mapping/WrongType;
        //   753: dup_x1         
        //   754: swap           
        //   755: ldc             "cdr"
        //   757: iconst_1       
        //   758: aload           9
        //   760: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   763: athrow         
        //   764: new             Lgnu/mapping/WrongType;
        //   767: dup_x1         
        //   768: swap           
        //   769: ldc             "car"
        //   771: iconst_1       
        //   772: aload           11
        //   774: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   777: athrow         
        //   778: new             Lgnu/mapping/WrongType;
        //   781: dup_x1         
        //   782: swap           
        //   783: ldc_w           "symbol->string"
        //   786: iconst_1       
        //   787: aload           11
        //   789: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   792: athrow         
        //   793: new             Lgnu/mapping/WrongType;
        //   796: dup_x1         
        //   797: swap           
        //   798: ldc_w           "number->string"
        //   801: iconst_1       
        //   802: aload           11
        //   804: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   807: athrow         
        //   808: new             Lgnu/mapping/WrongType;
        //   811: dup_x1         
        //   812: swap           
        //   813: ldc             "cdr"
        //   815: iconst_1       
        //   816: aload           7
        //   818: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   821: athrow         
        //   822: new             Lgnu/mapping/WrongType;
        //   825: dup_x1         
        //   826: swap           
        //   827: ldc             "cdr"
        //   829: iconst_1       
        //   830: aload           7
        //   832: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   835: athrow         
        //   836: new             Lgnu/mapping/WrongType;
        //   839: dup_x1         
        //   840: swap           
        //   841: ldc             "cdr"
        //   843: iconst_1       
        //   844: aload           7
        //   846: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   849: athrow         
        //   850: new             Lgnu/mapping/WrongType;
        //   853: dup_x1         
        //   854: swap           
        //   855: ldc             "cdr"
        //   857: iconst_1       
        //   858: aload           7
        //   860: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   863: athrow         
        //   864: new             Lgnu/mapping/WrongType;
        //   867: dup_x1         
        //   868: swap           
        //   869: ldc             "cdr"
        //   871: iconst_1       
        //   872: aload           7
        //   874: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   877: athrow         
        //   878: new             Lgnu/mapping/WrongType;
        //   881: dup_x1         
        //   882: swap           
        //   883: ldc             "car"
        //   885: iconst_1       
        //   886: aload_2        
        //   887: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   890: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  21     24     708    722    Ljava/lang/ClassCastException;
        //  66     69     722    736    Ljava/lang/ClassCastException;
        //  86     89     736    750    Ljava/lang/ClassCastException;
        //  123    126    750    764    Ljava/lang/ClassCastException;
        //  160    163    764    778    Ljava/lang/ClassCastException;
        //  175    178    778    793    Ljava/lang/ClassCastException;
        //  409    412    793    808    Ljava/lang/ClassCastException;
        //  525    528    808    822    Ljava/lang/ClassCastException;
        //  560    563    822    836    Ljava/lang/ClassCastException;
        //  577    580    836    850    Ljava/lang/ClassCastException;
        //  612    615    850    864    Ljava/lang/ClassCastException;
        //  629    632    864    878    Ljava/lang/ClassCastException;
        //  701    704    878    891    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 400 out of bounds for length 400
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
    
    public static Object getAtrTBForT1(final Object atr) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       kawa/lib/misc.symbol$Qu:Lgnu/expr/ModuleMethod;
        //     6: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //     9: aload_0         /* atr */
        //    10: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    13: ldc             Lgnu/lists/Pair;.class
        //    15: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    18: dup            
        //    19: astore          4
        //    21: checkcast       Lgnu/lists/Pair;
        //    24: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    27: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    30: astore_3       
        //    31: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    34: astore          4
        //    36: aconst_null    
        //    37: astore          5
        //    39: aload_3        
        //    40: invokeinterface java/util/Iterator.hasNext:()Z
        //    45: ifeq            471
        //    48: aload_3        
        //    49: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    54: astore          6
        //    56: aload           6
        //    58: ldc             Lgnu/lists/Pair;.class
        //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    63: dup            
        //    64: astore          9
        //    66: checkcast       Lgnu/lists/Pair;
        //    69: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    72: pop            
        //    73: getstatic       com/ftsafe/CCIDScheme.Lit144:Lgnu/mapping/SimpleSymbol;
        //    76: aload           6
        //    78: ldc             Lgnu/lists/Pair;.class
        //    80: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    83: dup            
        //    84: astore          9
        //    86: checkcast       Lgnu/lists/Pair;
        //    89: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    92: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    95: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    98: ifeq            431
        //   101: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   104: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   107: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   110: getstatic       com/ftsafe/CCIDScheme.Lit144:Lgnu/mapping/SimpleSymbol;
        //   113: aload           6
        //   115: ldc             Lgnu/lists/Pair;.class
        //   117: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   120: dup            
        //   121: astore          9
        //   123: checkcast       Lgnu/lists/Pair;
        //   126: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   129: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   132: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   135: getstatic       com/ftsafe/CCIDScheme.Lit118:Lgnu/math/IntNum;
        //   138: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   141: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   144: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   147: ifeq            431
        //   150: aload           6
        //   152: ldc             Lgnu/lists/Pair;.class
        //   154: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   157: dup            
        //   158: astore          11
        //   160: checkcast       Lgnu/lists/Pair;
        //   163: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   166: ldc_w           Lgnu/mapping/Symbol;.class
        //   169: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   172: dup            
        //   173: astore          11
        //   175: checkcast       Lgnu/mapping/Symbol;
        //   178: invokestatic    kawa/lib/misc.symbol$To$String:(Lgnu/mapping/Symbol;)Ljava/lang/String;
        //   181: invokestatic    kawa/lib/strings.string$To$List:(Ljava/lang/CharSequence;)Lgnu/lists/LList;
        //   184: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   187: astore          10
        //   189: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   192: astore          11
        //   194: aconst_null    
        //   195: astore          12
        //   197: aload           10
        //   199: invokeinterface java/util/Iterator.hasNext:()Z
        //   204: ifeq            260
        //   207: aload           10
        //   209: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   214: astore          13
        //   216: new             Lgnu/lists/Pair;
        //   219: dup            
        //   220: aload           13
        //   222: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   225: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   228: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   231: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   234: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   237: aload           12
        //   239: ifnonnull       248
        //   242: dup            
        //   243: astore          11
        //   245: goto            255
        //   248: aload           12
        //   250: swap           
        //   251: dup_x1         
        //   252: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   255: astore          12
        //   257: goto            197
        //   260: aload           11
        //   262: astore          s
        //   264: iconst_1       
        //   265: aload           s
        //   267: getstatic       com/ftsafe/CCIDScheme.Lit162:Lgnu/math/IntNum;
        //   270: aload           s
        //   272: invokevirtual   gnu/lists/LList.size:()I
        //   275: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   278: invokestatic    com/ftsafe/CCIDScheme.subu8list:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   281: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   284: astore          11
        //   286: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   289: astore          12
        //   291: aconst_null    
        //   292: astore          13
        //   294: aload           11
        //   296: invokeinterface java/util/Iterator.hasNext:()Z
        //   301: ifeq            360
        //   304: aload           11
        //   306: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   311: astore          14
        //   313: new             Lgnu/lists/Pair;
        //   316: dup            
        //   317: aload           14
        //   319: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   322: checkcast       Ljava/lang/Number;
        //   325: invokevirtual   java/lang/Number.intValue:()I
        //   328: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   331: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   334: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   337: aload           13
        //   339: ifnonnull       348
        //   342: dup            
        //   343: astore          12
        //   345: goto            355
        //   348: aload           13
        //   350: swap           
        //   351: dup_x1         
        //   352: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   355: astore          13
        //   357: goto            294
        //   360: aload           12
        //   362: invokestatic    kawa/lib/strings.list$To$String:(Lgnu/lists/LList;)Ljava/lang/CharSequence;
        //   365: invokestatic    kawa/lib/numbers.string$To$Number:(Ljava/lang/CharSequence;)Ljava/lang/Object;
        //   368: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   371: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   374: astore          n
        //   376: aload           n
        //   378: getstatic       com/ftsafe/CCIDScheme.Lit99:Lgnu/math/IntNum;
        //   381: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   384: ifeq            425
        //   387: iconst_2       
        //   388: anewarray       Ljava/lang/Object;
        //   391: dup            
        //   392: iconst_0       
        //   393: ldc_w           "interface"
        //   396: aastore        
        //   397: dup            
        //   398: iconst_1       
        //   399: aload           n
        //   401: ldc             Ljava/lang/Number;.class
        //   403: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   406: dup            
        //   407: astore          11
        //   409: checkcast       Ljava/lang/Number;
        //   412: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
        //   415: aastore        
        //   416: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   419: invokestatic    kawa/lib/misc.string$To$Symbol:(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
        //   422: goto            434
        //   425: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   428: goto            434
        //   431: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   434: astore          8
        //   436: new             Lgnu/lists/Pair;
        //   439: dup            
        //   440: aload           8
        //   442: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   445: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   448: aload           5
        //   450: ifnonnull       459
        //   453: dup            
        //   454: astore          4
        //   456: goto            466
        //   459: aload           5
        //   461: swap           
        //   462: dup_x1         
        //   463: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   466: astore          5
        //   468: goto            39
        //   471: aload           4
        //   473: invokestatic    com/ftsafe/CCIDScheme.filter:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   476: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   479: astore_2       
        //   480: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   483: astore_3       
        //   484: aconst_null    
        //   485: astore          4
        //   487: aload_2        
        //   488: invokeinterface java/util/Iterator.hasNext:()Z
        //   493: ifeq            675
        //   496: aload_2        
        //   497: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   502: astore          5
        //   504: new             Lgnu/lists/Pair;
        //   507: dup            
        //   508: aload           5
        //   510: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   513: aload_0         /* atr */
        //   514: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   517: ldc             Lgnu/lists/Pair;.class
        //   519: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   522: dup            
        //   523: astore          7
        //   525: checkcast       Lgnu/lists/Pair;
        //   528: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   531: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   534: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   537: ifeq            644
        //   540: getstatic       com/ftsafe/CCIDScheme.Lit142:Lgnu/mapping/SimpleSymbol;
        //   543: aload           5
        //   545: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   548: aload_0         /* atr */
        //   549: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   552: ldc             Lgnu/lists/Pair;.class
        //   554: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   557: dup            
        //   558: astore          7
        //   560: checkcast       Lgnu/lists/Pair;
        //   563: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   566: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   569: ldc             Lgnu/lists/Pair;.class
        //   571: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   574: dup            
        //   575: astore          7
        //   577: checkcast       Lgnu/lists/Pair;
        //   580: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   583: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   586: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   589: ifeq            644
        //   592: getstatic       com/ftsafe/CCIDScheme.Lit142:Lgnu/mapping/SimpleSymbol;
        //   595: aload           5
        //   597: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   600: aload_0         /* atr */
        //   601: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   604: ldc             Lgnu/lists/Pair;.class
        //   606: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   609: dup            
        //   610: astore          7
        //   612: checkcast       Lgnu/lists/Pair;
        //   615: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   618: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   621: ldc             Lgnu/lists/Pair;.class
        //   623: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   626: dup            
        //   627: astore          7
        //   629: checkcast       Lgnu/lists/Pair;
        //   632: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   635: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   638: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   641: goto            647
        //   644: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   647: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   650: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   653: aload           4
        //   655: ifnonnull       663
        //   658: dup            
        //   659: astore_3       
        //   660: goto            670
        //   663: aload           4
        //   665: swap           
        //   666: dup_x1         
        //   667: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   670: astore          4
        //   672: goto            487
        //   675: aload_3        
        //   676: invokestatic    com/ftsafe/CCIDScheme.filter:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   679: astore_1        /* ret */
        //   680: aload_1         /* ret */
        //   681: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   684: ifeq            693
        //   687: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   690: goto            707
        //   693: aload_1         /* ret */
        //   694: ldc             Lgnu/lists/Pair;.class
        //   696: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   699: dup            
        //   700: astore_2       
        //   701: checkcast       Lgnu/lists/Pair;
        //   704: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   707: areturn        
        //   708: new             Lgnu/mapping/WrongType;
        //   711: dup_x1         
        //   712: swap           
        //   713: ldc             "cdr"
        //   715: iconst_1       
        //   716: aload           4
        //   718: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   721: athrow         
        //   722: new             Lgnu/mapping/WrongType;
        //   725: dup_x1         
        //   726: swap           
        //   727: ldc             "car"
        //   729: iconst_1       
        //   730: aload           9
        //   732: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   735: athrow         
        //   736: new             Lgnu/mapping/WrongType;
        //   739: dup_x1         
        //   740: swap           
        //   741: ldc             "cdr"
        //   743: iconst_1       
        //   744: aload           9
        //   746: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   749: athrow         
        //   750: new             Lgnu/mapping/WrongType;
        //   753: dup_x1         
        //   754: swap           
        //   755: ldc             "cdr"
        //   757: iconst_1       
        //   758: aload           9
        //   760: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   763: athrow         
        //   764: new             Lgnu/mapping/WrongType;
        //   767: dup_x1         
        //   768: swap           
        //   769: ldc             "car"
        //   771: iconst_1       
        //   772: aload           11
        //   774: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   777: athrow         
        //   778: new             Lgnu/mapping/WrongType;
        //   781: dup_x1         
        //   782: swap           
        //   783: ldc_w           "symbol->string"
        //   786: iconst_1       
        //   787: aload           11
        //   789: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   792: athrow         
        //   793: new             Lgnu/mapping/WrongType;
        //   796: dup_x1         
        //   797: swap           
        //   798: ldc_w           "number->string"
        //   801: iconst_1       
        //   802: aload           11
        //   804: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   807: athrow         
        //   808: new             Lgnu/mapping/WrongType;
        //   811: dup_x1         
        //   812: swap           
        //   813: ldc             "cdr"
        //   815: iconst_1       
        //   816: aload           7
        //   818: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   821: athrow         
        //   822: new             Lgnu/mapping/WrongType;
        //   825: dup_x1         
        //   826: swap           
        //   827: ldc             "cdr"
        //   829: iconst_1       
        //   830: aload           7
        //   832: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   835: athrow         
        //   836: new             Lgnu/mapping/WrongType;
        //   839: dup_x1         
        //   840: swap           
        //   841: ldc             "cdr"
        //   843: iconst_1       
        //   844: aload           7
        //   846: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   849: athrow         
        //   850: new             Lgnu/mapping/WrongType;
        //   853: dup_x1         
        //   854: swap           
        //   855: ldc             "cdr"
        //   857: iconst_1       
        //   858: aload           7
        //   860: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   863: athrow         
        //   864: new             Lgnu/mapping/WrongType;
        //   867: dup_x1         
        //   868: swap           
        //   869: ldc             "cdr"
        //   871: iconst_1       
        //   872: aload           7
        //   874: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   877: athrow         
        //   878: new             Lgnu/mapping/WrongType;
        //   881: dup_x1         
        //   882: swap           
        //   883: ldc             "car"
        //   885: iconst_1       
        //   886: aload_2        
        //   887: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   890: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  21     24     708    722    Ljava/lang/ClassCastException;
        //  66     69     722    736    Ljava/lang/ClassCastException;
        //  86     89     736    750    Ljava/lang/ClassCastException;
        //  123    126    750    764    Ljava/lang/ClassCastException;
        //  160    163    764    778    Ljava/lang/ClassCastException;
        //  175    178    778    793    Ljava/lang/ClassCastException;
        //  409    412    793    808    Ljava/lang/ClassCastException;
        //  525    528    808    822    Ljava/lang/ClassCastException;
        //  560    563    822    836    Ljava/lang/ClassCastException;
        //  577    580    836    850    Ljava/lang/ClassCastException;
        //  612    615    850    864    Ljava/lang/ClassCastException;
        //  629    632    864    878    Ljava/lang/ClassCastException;
        //  701    704    878    891    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 400 out of bounds for length 400
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
    
    public static Pair generatePPSParametersT1(final Object atr) {
        final Object pps = generatePPSExchange(atr);
        final Object bmFindexDindex = KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(lists.listRef(pps, 1), com.ftsafe.CCIDScheme.Lit6), com.ftsafe.CCIDScheme.Lit6)) ? lists.listRef(pps, 2) : com.ftsafe.CCIDScheme.Lit171;
        final IntNum lit6 = com.ftsafe.CCIDScheme.Lit6;
        final Object Tc = getAtrTCForT1(atr);
        final IntNum bmTCCKST1 = BitOps.ior(BitOps.ior(lit6, KawaConvert.isTrue(Tc) ? (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(Tc, com.ftsafe.CCIDScheme.Lit2), com.ftsafe.CCIDScheme.Lit2)) ? com.ftsafe.CCIDScheme.Lit16 : com.ftsafe.CCIDScheme.Lit1) : com.ftsafe.CCIDScheme.Lit1), KawaConvert.isTrue(Scheme.isEqual.apply2(lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit146, atr)), com.ftsafe.CCIDScheme.Lit173)) ? com.ftsafe.CCIDScheme.Lit1 : com.ftsafe.CCIDScheme.Lit2);
        Label_0206: {
            if (!KawaConvert.isTrue(assocEX(com.ftsafe.CCIDScheme.Lit143, assocEX(com.ftsafe.CCIDScheme.Lit165, assocEX(com.ftsafe.CCIDScheme.Lit158, atr))))) {
                break Label_0206;
            }
            final Object force = Promise.force(assocEX(com.ftsafe.CCIDScheme.Lit143, assocEX(com.ftsafe.CCIDScheme.Lit165, assocEX(com.ftsafe.CCIDScheme.Lit158, atr))), Pair.class);
            try {
                Object o = lists.car((Pair)force);
                while (true) {
                    final Object bGuardTimeT1 = o;
                    final Object bmWaitingIntegersT1 = KawaConvert.isTrue(getAtrTBForT1(atr)) ? getAtrTBForT1(atr) : com.ftsafe.CCIDScheme.Lit174;
                    final Object bIFSC = getAtrIFSC(atr);
                    final Pair list1 = LList.list1(bmFindexDindex);
                    LList.chain1(LList.chain1(LList.chain4(list1, bmTCCKST1, bGuardTimeT1, bmWaitingIntegersT1, com.ftsafe.CCIDScheme.Lit1), bIFSC), com.ftsafe.CCIDScheme.Lit1);
                    return list1;
                    o = com.ftsafe.CCIDScheme.Lit1;
                    continue;
                }
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "car", 1, force);
            }
        }
    }
    
    public static Pair generatePPSParametersT0(final Object atr) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    com/ftsafe/CCIDScheme.generatePPSExchange:(Ljava/lang/Object;)Ljava/lang/Object;
        //     4: astore_1        /* pps */
        //     5: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //     8: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //    11: aload_1         /* pps */
        //    12: iconst_1       
        //    13: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    16: getstatic       com/ftsafe/CCIDScheme.Lit6:Lgnu/math/IntNum;
        //    19: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    22: getstatic       com/ftsafe/CCIDScheme.Lit6:Lgnu/math/IntNum;
        //    25: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    28: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    31: ifeq            42
        //    34: aload_1         /* pps */
        //    35: iconst_2       
        //    36: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //    39: goto            45
        //    42: getstatic       com/ftsafe/CCIDScheme.Lit171:Lgnu/math/IntNum;
        //    45: astore_2        /* bmFindexDindex */
        //    46: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //    49: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    52: getstatic       com/ftsafe/CCIDScheme.Lit146:Lgnu/mapping/SimpleSymbol;
        //    55: aload_0         /* atr */
        //    56: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    59: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    62: getstatic       com/ftsafe/CCIDScheme.Lit173:Lgnu/math/IntNum;
        //    65: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    68: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    71: ifeq            80
        //    74: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //    77: goto            83
        //    80: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //    83: invokestatic    gnu/math/BitOps.ior:(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
        //    86: astore_3        /* bmTCCKST0 */
        //    87: getstatic       com/ftsafe/CCIDScheme.Lit143:Lgnu/mapping/SimpleSymbol;
        //    90: getstatic       com/ftsafe/CCIDScheme.Lit165:Lgnu/mapping/SimpleSymbol;
        //    93: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //    96: aload_0         /* atr */
        //    97: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   100: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   106: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   109: ifeq            148
        //   112: getstatic       com/ftsafe/CCIDScheme.Lit143:Lgnu/mapping/SimpleSymbol;
        //   115: getstatic       com/ftsafe/CCIDScheme.Lit165:Lgnu/mapping/SimpleSymbol;
        //   118: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   121: aload_0         /* atr */
        //   122: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   125: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   128: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   131: ldc             Lgnu/lists/Pair;.class
        //   133: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   136: dup            
        //   137: astore          5
        //   139: checkcast       Lgnu/lists/Pair;
        //   142: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   145: goto            151
        //   148: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   151: astore          bGuardTimeT0
        //   153: getstatic       com/ftsafe/CCIDScheme.Lit143:Lgnu/mapping/SimpleSymbol;
        //   156: getstatic       com/ftsafe/CCIDScheme.Lit168:Lgnu/mapping/SimpleSymbol;
        //   159: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   162: aload_0         /* atr */
        //   163: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   166: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   169: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   172: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   175: ifeq            214
        //   178: getstatic       com/ftsafe/CCIDScheme.Lit143:Lgnu/mapping/SimpleSymbol;
        //   181: getstatic       com/ftsafe/CCIDScheme.Lit168:Lgnu/mapping/SimpleSymbol;
        //   184: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   187: aload_0         /* atr */
        //   188: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   191: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   194: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   197: ldc             Lgnu/lists/Pair;.class
        //   199: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   202: dup            
        //   203: astore          6
        //   205: checkcast       Lgnu/lists/Pair;
        //   208: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   211: goto            217
        //   214: getstatic       com/ftsafe/CCIDScheme.Lit114:Lgnu/math/IntNum;
        //   217: astore          bmWaitingIntegersT0
        //   219: aload_2         /* bmFindexDindex */
        //   220: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   223: dup            
        //   224: aload_3         /* bmTCCKST0 */
        //   225: aload           bGuardTimeT0
        //   227: aload           bmWaitingIntegersT0
        //   229: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   232: invokestatic    gnu/lists/LList.chain4:(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   235: pop            
        //   236: areturn        
        //   237: new             Lgnu/mapping/WrongType;
        //   240: dup_x1         
        //   241: swap           
        //   242: ldc             "car"
        //   244: iconst_1       
        //   245: aload           5
        //   247: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   250: athrow         
        //   251: new             Lgnu/mapping/WrongType;
        //   254: dup_x1         
        //   255: swap           
        //   256: ldc             "car"
        //   258: iconst_1       
        //   259: aload           6
        //   261: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   264: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  139    142    237    251    Ljava/lang/ClassCastException;
        //  205    208    251    265    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0214:
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
    
    public static IntNum getCardTimeoutT1(final Object atr) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       com/ftsafe/CCIDScheme.Lit165:Lgnu/mapping/SimpleSymbol;
        //     6: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //     9: aload_0         /* atr */
        //    10: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    13: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    16: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    19: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    22: ifeq            60
        //    25: getstatic       com/ftsafe/CCIDScheme.Lit141:Lgnu/mapping/SimpleSymbol;
        //    28: getstatic       com/ftsafe/CCIDScheme.Lit165:Lgnu/mapping/SimpleSymbol;
        //    31: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //    34: aload_0         /* atr */
        //    35: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    38: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    41: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    44: ldc             Lgnu/lists/Pair;.class
        //    46: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    49: dup            
        //    50: astore_2       
        //    51: checkcast       Lgnu/lists/Pair;
        //    54: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    57: goto            63
        //    60: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    63: invokestatic    com/ftsafe/CCIDScheme.parseAtrTA1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //    66: astore_1        /* f_d */
        //    67: getstatic       com/ftsafe/CCIDScheme.Lit152:Lgnu/mapping/SimpleSymbol;
        //    70: aload_1         /* f_d */
        //    71: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    74: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    77: astore_2        /* f */
        //    78: getstatic       com/ftsafe/CCIDScheme.Lit154:Lgnu/mapping/SimpleSymbol;
        //    81: aload_1         /* f_d */
        //    82: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    85: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    88: astore_3        /* d */
        //    89: getstatic       com/ftsafe/CCIDScheme.Lit143:Lgnu/mapping/SimpleSymbol;
        //    92: getstatic       com/ftsafe/CCIDScheme.Lit165:Lgnu/mapping/SimpleSymbol;
        //    95: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //    98: aload_0         /* atr */
        //    99: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   102: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   105: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   108: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   111: ifeq            150
        //   114: getstatic       com/ftsafe/CCIDScheme.Lit143:Lgnu/mapping/SimpleSymbol;
        //   117: getstatic       com/ftsafe/CCIDScheme.Lit165:Lgnu/mapping/SimpleSymbol;
        //   120: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   123: aload_0         /* atr */
        //   124: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   127: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   130: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   133: ldc             Lgnu/lists/Pair;.class
        //   135: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   138: dup            
        //   139: astore          5
        //   141: checkcast       Lgnu/lists/Pair;
        //   144: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   147: goto            153
        //   150: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   153: astore          TC1
        //   155: aload_0         /* atr */
        //   156: invokestatic    com/ftsafe/CCIDScheme.getAtrTBForT1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   159: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   162: ifeq            172
        //   165: aload_0         /* atr */
        //   166: invokestatic    com/ftsafe/CCIDScheme.getAtrTBForT1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   169: goto            175
        //   172: getstatic       com/ftsafe/CCIDScheme.Lit174:Lgnu/math/IntNum;
        //   175: astore          B_C
        //   177: getstatic       gnu/kawa/functions/BitwiseOp.ashift:Lgnu/kawa/functions/BitwiseOp;
        //   180: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   183: aload           B_C
        //   185: getstatic       com/ftsafe/CCIDScheme.Lit175:Lgnu/math/IntNum;
        //   188: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   191: getstatic       com/ftsafe/CCIDScheme.Lit151:Lgnu/math/IntNum;
        //   194: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   197: getstatic       gnu/kawa/functions/BitwiseOp.ashift:Lgnu/kawa/functions/BitwiseOp;
        //   200: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   203: aload           B_C
        //   205: getstatic       com/ftsafe/CCIDScheme.Lit118:Lgnu/math/IntNum;
        //   208: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   211: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   214: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   217: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   220: astore          B_C
        //   222: aload           B_C
        //   224: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   227: astore          BWI
        //   229: aload           B_C
        //   231: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   234: astore          CWI
        //   236: getstatic       com/ftsafe/CCIDScheme.Lit74:Lgnu/mapping/SimpleSymbol;
        //   239: getstatic       com/ftsafe/CCIDScheme.Lit98:Lgnu/mapping/SimpleSymbol;
        //   242: getstatic       com/ftsafe/CCIDScheme.current_dev_interface:Lgnu/mapping/Procedure;
        //   245: invokevirtual   gnu/mapping/Procedure.apply0:()Ljava/lang/Object;
        //   248: getstatic       com/ftsafe/CCIDScheme.descriptor$Mninfo:Ljava/lang/Object;
        //   251: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   254: ldc             Lgnu/lists/Pair;.class
        //   256: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   259: dup            
        //   260: astore          9
        //   262: checkcast       Lgnu/lists/Pair;
        //   265: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   268: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   271: ldc             Lgnu/lists/Pair;.class
        //   273: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   276: dup            
        //   277: astore          9
        //   279: checkcast       Lgnu/lists/Pair;
        //   282: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   285: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   288: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   291: astore          clock_frequency
        //   293: aload_2         /* f */
        //   294: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   297: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   300: istore          x
        //   302: iload           x
        //   304: ifeq            315
        //   307: iload           x
        //   309: ifeq            354
        //   312: goto            348
        //   315: aload_3         /* d */
        //   316: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   319: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   322: istore          x
        //   324: iload           x
        //   326: ifeq            337
        //   329: iload           x
        //   331: ifeq            354
        //   334: goto            348
        //   337: aload           clock_frequency
        //   339: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   342: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   345: ifeq            354
        //   348: getstatic       com/ftsafe/CCIDScheme.Lit176:Lgnu/math/IntNum;
        //   351: goto            553
        //   354: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   357: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   360: aload_2         /* f */
        //   361: aload_3         /* d */
        //   362: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   365: aload           clock_frequency
        //   367: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   370: astore          etu
        //   372: iconst_1       
        //   373: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   376: getstatic       com/ftsafe/CCIDScheme.Lit115:Lgnu/math/IntNum;
        //   379: aload           etu
        //   381: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   384: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   387: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   390: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   393: aload_2         /* f */
        //   394: aload_3         /* d */
        //   395: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   398: aload           TC1
        //   400: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   403: aload           clock_frequency
        //   405: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   408: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   411: astore          EGT
        //   413: iconst_1       
        //   414: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   417: getstatic       com/ftsafe/CCIDScheme.Lit90:Lgnu/math/IntNum;
        //   420: aload           etu
        //   422: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   425: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   428: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   431: aload           BWI
        //   433: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   436: checkcast       Ljava/lang/Number;
        //   439: invokevirtual   java/lang/Number.intValue:()I
        //   442: invokestatic    gnu/math/IntNum.shift:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //   445: sipush          960
        //   448: invokestatic    gnu/math/IntNum.times:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //   451: sipush          372
        //   454: invokestatic    gnu/math/IntNum.times:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //   457: aload           clock_frequency
        //   459: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   462: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   465: astore          BWT
        //   467: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   470: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   473: aload           CWI
        //   475: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   478: checkcast       Ljava/lang/Number;
        //   481: invokevirtual   java/lang/Number.intValue:()I
        //   484: invokestatic    gnu/math/IntNum.shift:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //   487: bipush          11
        //   489: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //   492: aload           etu
        //   494: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   497: astore          CWT
        //   499: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   502: iconst_1       
        //   503: iconst_1       
        //   504: iconst_1       
        //   505: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   508: getstatic       com/ftsafe/CCIDScheme.Lit177:Lgnu/math/IntNum;
        //   511: aload           EGT
        //   513: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   516: aload           BWT
        //   518: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   521: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   524: getstatic       com/ftsafe/CCIDScheme.Lit177:Lgnu/math/IntNum;
        //   527: aload           CWT
        //   529: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   532: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   535: getstatic       com/ftsafe/CCIDScheme.Lit166:Lgnu/math/IntNum;
        //   538: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   541: getstatic       com/ftsafe/CCIDScheme.Lit178:Lgnu/math/DFloNum;
        //   544: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   547: invokestatic    com/ftsafe/CCIDScheme.float$To$Integer:(Ljava/lang/Object;)I
        //   550: invokestatic    gnu/math/IntNum.make:(I)Lgnu/math/IntNum;
        //   553: areturn        
        //   554: new             Lgnu/mapping/WrongType;
        //   557: dup_x1         
        //   558: swap           
        //   559: ldc             "car"
        //   561: iconst_1       
        //   562: aload_2        
        //   563: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   566: athrow         
        //   567: new             Lgnu/mapping/WrongType;
        //   570: dup_x1         
        //   571: swap           
        //   572: ldc             "car"
        //   574: iconst_1       
        //   575: aload           5
        //   577: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   580: athrow         
        //   581: new             Lgnu/mapping/WrongType;
        //   584: dup_x1         
        //   585: swap           
        //   586: ldc             "cdr"
        //   588: iconst_1       
        //   589: aload           9
        //   591: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   594: athrow         
        //   595: new             Lgnu/mapping/WrongType;
        //   598: dup_x1         
        //   599: swap           
        //   600: ldc             "cdr"
        //   602: iconst_1       
        //   603: aload           9
        //   605: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   608: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  51     54     554    567    Ljava/lang/ClassCastException;
        //  141    144    567    581    Ljava/lang/ClassCastException;
        //  262    265    581    595    Ljava/lang/ClassCastException;
        //  279    282    595    609    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 249 out of bounds for length 249
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
    
    public static IntNum getCardTimeoutT0(final Object atr) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       com/ftsafe/CCIDScheme.Lit165:Lgnu/mapping/SimpleSymbol;
        //     6: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //     9: aload_0         /* atr */
        //    10: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    13: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    16: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    19: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    22: ifeq            60
        //    25: getstatic       com/ftsafe/CCIDScheme.Lit141:Lgnu/mapping/SimpleSymbol;
        //    28: getstatic       com/ftsafe/CCIDScheme.Lit165:Lgnu/mapping/SimpleSymbol;
        //    31: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //    34: aload_0         /* atr */
        //    35: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    38: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    41: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    44: ldc             Lgnu/lists/Pair;.class
        //    46: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    49: dup            
        //    50: astore_2       
        //    51: checkcast       Lgnu/lists/Pair;
        //    54: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    57: goto            63
        //    60: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    63: invokestatic    com/ftsafe/CCIDScheme.parseAtrTA1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //    66: astore_1        /* f_d */
        //    67: getstatic       com/ftsafe/CCIDScheme.Lit152:Lgnu/mapping/SimpleSymbol;
        //    70: aload_1         /* f_d */
        //    71: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    74: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    77: astore_2        /* f */
        //    78: getstatic       com/ftsafe/CCIDScheme.Lit154:Lgnu/mapping/SimpleSymbol;
        //    81: aload_1         /* f_d */
        //    82: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    85: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    88: astore_3        /* d */
        //    89: getstatic       com/ftsafe/CCIDScheme.Lit143:Lgnu/mapping/SimpleSymbol;
        //    92: getstatic       com/ftsafe/CCIDScheme.Lit165:Lgnu/mapping/SimpleSymbol;
        //    95: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //    98: aload_0         /* atr */
        //    99: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   102: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   105: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   108: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   111: ifeq            150
        //   114: getstatic       com/ftsafe/CCIDScheme.Lit143:Lgnu/mapping/SimpleSymbol;
        //   117: getstatic       com/ftsafe/CCIDScheme.Lit165:Lgnu/mapping/SimpleSymbol;
        //   120: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   123: aload_0         /* atr */
        //   124: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   127: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   130: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   133: ldc             Lgnu/lists/Pair;.class
        //   135: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   138: dup            
        //   139: astore          5
        //   141: checkcast       Lgnu/lists/Pair;
        //   144: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   147: goto            153
        //   150: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   153: astore          TC1
        //   155: getstatic       com/ftsafe/CCIDScheme.Lit143:Lgnu/mapping/SimpleSymbol;
        //   158: getstatic       com/ftsafe/CCIDScheme.Lit168:Lgnu/mapping/SimpleSymbol;
        //   161: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   164: aload_0         /* atr */
        //   165: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   168: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   171: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   174: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   177: ifeq            216
        //   180: getstatic       com/ftsafe/CCIDScheme.Lit143:Lgnu/mapping/SimpleSymbol;
        //   183: getstatic       com/ftsafe/CCIDScheme.Lit168:Lgnu/mapping/SimpleSymbol;
        //   186: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   189: aload_0         /* atr */
        //   190: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   193: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   196: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   199: ldc             Lgnu/lists/Pair;.class
        //   201: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   204: dup            
        //   205: astore          6
        //   207: checkcast       Lgnu/lists/Pair;
        //   210: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   213: goto            219
        //   216: getstatic       com/ftsafe/CCIDScheme.Lit114:Lgnu/math/IntNum;
        //   219: astore          TC2
        //   221: getstatic       com/ftsafe/CCIDScheme.Lit74:Lgnu/mapping/SimpleSymbol;
        //   224: getstatic       com/ftsafe/CCIDScheme.Lit98:Lgnu/mapping/SimpleSymbol;
        //   227: getstatic       com/ftsafe/CCIDScheme.current_dev_interface:Lgnu/mapping/Procedure;
        //   230: invokevirtual   gnu/mapping/Procedure.apply0:()Ljava/lang/Object;
        //   233: getstatic       com/ftsafe/CCIDScheme.descriptor$Mninfo:Ljava/lang/Object;
        //   236: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   239: ldc             Lgnu/lists/Pair;.class
        //   241: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   244: dup            
        //   245: astore          7
        //   247: checkcast       Lgnu/lists/Pair;
        //   250: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   253: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   256: ldc             Lgnu/lists/Pair;.class
        //   258: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   261: dup            
        //   262: astore          7
        //   264: checkcast       Lgnu/lists/Pair;
        //   267: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   270: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   273: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   276: astore          clock_frequency
        //   278: aload_2         /* f */
        //   279: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   282: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   285: istore          x
        //   287: iload           x
        //   289: ifeq            300
        //   292: iload           x
        //   294: ifeq            339
        //   297: goto            333
        //   300: aload_3         /* d */
        //   301: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   304: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   307: istore          x
        //   309: iload           x
        //   311: ifeq            322
        //   314: iload           x
        //   316: ifeq            339
        //   319: goto            333
        //   322: aload           clock_frequency
        //   324: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   327: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   330: ifeq            339
        //   333: getstatic       com/ftsafe/CCIDScheme.Lit176:Lgnu/math/IntNum;
        //   336: goto            538
        //   339: iconst_1       
        //   340: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   343: getstatic       com/ftsafe/CCIDScheme.Lit115:Lgnu/math/IntNum;
        //   346: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   349: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   352: aload_2         /* f */
        //   353: aload_3         /* d */
        //   354: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   357: aload           clock_frequency
        //   359: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   362: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   365: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   368: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   371: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   374: aload_2         /* f */
        //   375: aload_3         /* d */
        //   376: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   379: aload           TC1
        //   381: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   384: aload           clock_frequency
        //   386: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   389: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   392: astore          EGT
        //   394: getstatic       gnu/kawa/functions/DivideOp.$Sl:Lgnu/kawa/functions/DivideOp;
        //   397: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   400: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   403: getstatic       com/ftsafe/CCIDScheme.Lit179:Lgnu/math/IntNum;
        //   406: aload           TC2
        //   408: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   411: aload_2         /* f */
        //   412: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   415: aload           clock_frequency
        //   417: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   420: astore          WWT
        //   422: iconst_1       
        //   423: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   426: getstatic       com/ftsafe/CCIDScheme.Lit180:Lgnu/math/IntNum;
        //   429: aload           EGT
        //   431: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   434: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   437: getstatic       com/ftsafe/CCIDScheme.Lit21:Lgnu/math/IntNum;
        //   440: aload           WWT
        //   442: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   445: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   448: astore          t_in
        //   450: iconst_1       
        //   451: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   454: getstatic       com/ftsafe/CCIDScheme.Lit58:Lgnu/math/IntNum;
        //   457: aload           EGT
        //   459: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   462: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   465: getstatic       com/ftsafe/CCIDScheme.Lit177:Lgnu/math/IntNum;
        //   468: aload           WWT
        //   470: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   473: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   476: astore          t_out
        //   478: getstatic       gnu/kawa/functions/MultiplyOp.$St:Lgnu/kawa/functions/MultiplyOp;
        //   481: aload           t_in
        //   483: getstatic       com/ftsafe/CCIDScheme.Lit181:Lgnu/math/IntNum;
        //   486: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   489: ifeq            509
        //   492: aload           t_out
        //   494: getstatic       com/ftsafe/CCIDScheme.Lit181:Lgnu/math/IntNum;
        //   497: invokestatic    gnu/kawa/functions/NumberCompare.$Ls:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   500: ifeq            509
        //   503: getstatic       com/ftsafe/CCIDScheme.Lit181:Lgnu/math/IntNum;
        //   506: goto            526
        //   509: aload           t_in
        //   511: aload           t_out
        //   513: invokestatic    gnu/kawa/functions/NumberCompare.$Gr:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   516: ifeq            524
        //   519: aload           t_in
        //   521: goto            526
        //   524: aload           t_out
        //   526: getstatic       com/ftsafe/CCIDScheme.Lit178:Lgnu/math/DFloNum;
        //   529: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   532: invokestatic    com/ftsafe/CCIDScheme.float$To$Integer:(Ljava/lang/Object;)I
        //   535: invokestatic    gnu/math/IntNum.make:(I)Lgnu/math/IntNum;
        //   538: areturn        
        //   539: new             Lgnu/mapping/WrongType;
        //   542: dup_x1         
        //   543: swap           
        //   544: ldc             "car"
        //   546: iconst_1       
        //   547: aload_2        
        //   548: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   551: athrow         
        //   552: new             Lgnu/mapping/WrongType;
        //   555: dup_x1         
        //   556: swap           
        //   557: ldc             "car"
        //   559: iconst_1       
        //   560: aload           5
        //   562: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   565: athrow         
        //   566: new             Lgnu/mapping/WrongType;
        //   569: dup_x1         
        //   570: swap           
        //   571: ldc             "car"
        //   573: iconst_1       
        //   574: aload           6
        //   576: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   579: athrow         
        //   580: new             Lgnu/mapping/WrongType;
        //   583: dup_x1         
        //   584: swap           
        //   585: ldc             "cdr"
        //   587: iconst_1       
        //   588: aload           7
        //   590: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   593: athrow         
        //   594: new             Lgnu/mapping/WrongType;
        //   597: dup_x1         
        //   598: swap           
        //   599: ldc             "cdr"
        //   601: iconst_1       
        //   602: aload           7
        //   604: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   607: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  51     54     539    552    Ljava/lang/ClassCastException;
        //  141    144    552    566    Ljava/lang/ClassCastException;
        //  207    210    566    580    Ljava/lang/ClassCastException;
        //  247    250    580    594    Ljava/lang/ClassCastException;
        //  264    267    594    608    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 251 out of bounds for length 251
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
    
    public static IntNum getCardTimeout(final Object atr) {
        return KawaConvert.isTrue(Scheme.isEqual.apply2(KawaConvert.isTrue(Scheme.isEqual.apply2(getAtrSupportProtocol(atr), com.ftsafe.CCIDScheme.Lit147)) ? com.ftsafe.CCIDScheme.Lit1 : (KawaConvert.isTrue(Scheme.isEqual.apply2(getAtrSupportProtocol(atr), com.ftsafe.CCIDScheme.Lit160)) ? com.ftsafe.CCIDScheme.Lit2 : (KawaConvert.isTrue(Scheme.isEqual.apply2(getAtrSupportProtocol(atr), com.ftsafe.CCIDScheme.Lit159)) ? com.ftsafe.CCIDScheme.Lit2 : Values.empty)), com.ftsafe.CCIDScheme.Lit1)) ? getCardTimeoutT0(atr) : getCardTimeoutT1(atr);
    }
    
    public static Object parseT1Block(final Object data) {
        return parseT1Block(data, Boolean.TRUE);
    }
    
    public static Object parseT1Block(final Object data, final Object _debug) {
        public class CCIDScheme$frame12 extends ModuleBody
        {
            Object info;
            
            public void lambda32setinfo$V(final Object arg1, final Object[] argsArray) {
                final LList arg2s = LList.makeList(argsArray, 0);
                this.info = com.ftsafe.CCIDScheme.stringlst$To$String(lists.cons(this.info, lists.cons(arg1, arg2s)));
            }
        }
        final CCIDScheme$frame12 $heapFrame = new CCIDScheme$frame12();
        $heapFrame.info = "";
        $heapFrame.lambda32setinfo$V("**********************************\n", new Object[0]);
        $heapFrame.lambda32setinfo$V("Data: ", new Object[] { u8list$To$String(data, "-"), "\n" });
        Object PF = slice(data, com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit99);
        $heapFrame.lambda32setinfo$V("Prologue field: ", new Object[] { u8list$To$String(PF), "\n" });
        Object argValue = Promise.force(PF, Pair.class);
        try {
            final Object NAD = lists.car((Pair)argValue);
            $heapFrame.lambda32setinfo$V("    ", new Object[] { "NAD: ", toHexStr(NAD), "H", "\n" });
            $heapFrame.lambda32setinfo$V("    ", new Object[] { "    ", "SAD: ", toBinStr(BitwiseOp.ashift.apply2(BitwiseOp.and.apply2(NAD, com.ftsafe.CCIDScheme.Lit111), com.ftsafe.CCIDScheme.Lit182), com.ftsafe.CCIDScheme.Lit99), "B", "\n" });
            $heapFrame.lambda32setinfo$V("    ", new Object[] { "    ", "DAD: ", toBinStr(BitwiseOp.ashift.apply2(BitwiseOp.and.apply2(NAD, com.ftsafe.CCIDScheme.Lit183), com.ftsafe.CCIDScheme.Lit184), com.ftsafe.CCIDScheme.Lit99), "B", "\n" });
            final Object PCB = lists.cadr(PF);
            $heapFrame.lambda32setinfo$V("    ", new Object[] { "PCB: ", toHexStr(PCB), "H", "\n" });
            if (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit101), com.ftsafe.CCIDScheme.Lit101))) {
                $heapFrame.lambda32setinfo$V("    ", new Object[] { "    ", "tpye: S-block\n" });
                $heapFrame.lambda32setinfo$V("    ", new Object[] { "    ", "b6~1: ", toBinStr(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit21), "  ", KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit1)) ? "RESYNCH request" : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit172)) ? "RESYNCH response" : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit2)) ? "IFS request" : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit68)) ? "IFS response" : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit16)) ? "ABORT requset" : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit186)) ? "ABORT response" : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit99)) ? "WTX requset" : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit187)) ? "WTX response" : "reserved for future use"))))))), "\n" });
            }
            else if (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit101), com.ftsafe.CCIDScheme.Lit20))) {
                $heapFrame.lambda32setinfo$V("    ", new Object[] { "    ", "tpye: R-block\n" });
                $heapFrame.lambda32setinfo$V("    ", new Object[] { "    ", "bit6~1: " });
                $heapFrame.lambda32setinfo$V("0-(", new Object[] { toBinStr(BitwiseOp.ashift.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit6), com.ftsafe.CCIDScheme.Lit151), com.ftsafe.CCIDScheme.Lit2), ")-" });
                $heapFrame.lambda32setinfo$V(toBinStr(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit118), com.ftsafe.CCIDScheme.Lit18), new Object[0]);
                $heapFrame.lambda32setinfo$V("  =>  ", new Object[] { KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit118), com.ftsafe.CCIDScheme.Lit1)) ? "an error-free acknowledgement" : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit118), com.ftsafe.CCIDScheme.Lit2)) ? "a redundancy code error or a character parity error" : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit118), com.ftsafe.CCIDScheme.Lit16)) ? "other errors" : Values.empty)), "\n" });
            }
            else if (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit20), com.ftsafe.CCIDScheme.Lit1))) {
                $heapFrame.lambda32setinfo$V("    ", new Object[] { "    ", "tpye: I-block\n" });
                $heapFrame.lambda32setinfo$V("    ", new Object[] { "    ", "N(S): ", toBinStr(BitwiseOp.ashift.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit188), com.ftsafe.CCIDScheme.Lit102), com.ftsafe.CCIDScheme.Lit2), "\n" });
                $heapFrame.lambda32setinfo$V("    ", new Object[] { "    ", "M-bit: ", toBinStr(BitwiseOp.ashift.apply2(BitwiseOp.and.apply2(PCB, com.ftsafe.CCIDScheme.Lit172), com.ftsafe.CCIDScheme.Lit182), com.ftsafe.CCIDScheme.Lit2), "\n" });
            }
            final Object LEN = lists.caddr(PF);
            $heapFrame.lambda32setinfo$V("    ", new Object[] { "LEN: ", toHexStr(LEN), "H", "\n" });
            final Object IF = slice(data, com.ftsafe.CCIDScheme.Lit99, Sequences.getSize(data) - 4);
            $heapFrame.lambda32setinfo$V("Information field: (", new Object[] { toHexStr(Sequences.getSize(IF)), ")\n" });
            final Iterator iterator = Sequences.getIterator(groupList(IF, com.ftsafe.CCIDScheme.Lit6));
            argValue = LList.Empty;
            Pair pair = null;
            while (iterator.hasNext()) {
                $heapFrame.lambda32setinfo$V("    ", new Object[] { u8list$To$String(iterator.next(), " "), "\n" });
                final Pair cdr = new Pair(Values.empty, LList.Empty);
                if (pair == null) {
                    argValue = cdr;
                }
                else {
                    pair.setCdr(cdr);
                }
                pair = cdr;
            }
            final Object EF = lists.listRef(data, Sequences.getSize(data) - 1);
            $heapFrame.lambda32setinfo$V("Epilogue field: ", new Object[] { toHexStr(EF), "\n" });
            $heapFrame.lambda32setinfo$V("    ", new Object[] { "LRC: ", toHexStr(listXor(slice(data, com.ftsafe.CCIDScheme.Lit1, Sequences.getSize(data) - 1))), "\n" });
            $heapFrame.lambda32setinfo$V("**********************************\n", new Object[0]);
            if (KawaConvert.isTrue(_debug)) {
                com.ftsafe.CCIDScheme.pp.apply1($heapFrame.info);
            }
            Object apply1;
            if (NumberCompare.$Eq(com.ftsafe.CCIDScheme.Lit1, listXor(data))) {
                PF = slice(data, com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit99);
                final Object IF2 = slice(data, com.ftsafe.CCIDScheme.Lit99, Sequences.getSize(data) - 4);
                lists.listRef(data, Sequences.getSize(data) - 1);
                apply1 = (NumberCompare.$Eq(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit101), com.ftsafe.CCIDScheme.Lit101) ? LList.list3(com.ftsafe.CCIDScheme.Lit189, LList.list2(com.ftsafe.CCIDScheme.Lit190, KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit1)) ? com.ftsafe.CCIDScheme.Lit191 : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit172)) ? com.ftsafe.CCIDScheme.Lit192 : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit2)) ? com.ftsafe.CCIDScheme.Lit193 : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit68)) ? com.ftsafe.CCIDScheme.Lit194 : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit16)) ? com.ftsafe.CCIDScheme.Lit195 : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit186)) ? com.ftsafe.CCIDScheme.Lit196 : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit99)) ? com.ftsafe.CCIDScheme.Lit197 : (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit185), com.ftsafe.CCIDScheme.Lit187)) ? com.ftsafe.CCIDScheme.Lit198 : com.ftsafe.CCIDScheme.Lit199)))))))), LList.list2(com.ftsafe.CCIDScheme.Lit200, IF2)) : (NumberCompare.$Eq(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit101), com.ftsafe.CCIDScheme.Lit20) ? LList.list4(com.ftsafe.CCIDScheme.Lit201, LList.list2(com.ftsafe.CCIDScheme.Lit202, BitwiseOp.ashift.apply2(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit6), com.ftsafe.CCIDScheme.Lit151)), LList.list2(com.ftsafe.CCIDScheme.Lit203, BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit118)), LList.list2(com.ftsafe.CCIDScheme.Lit200, IF2)) : (NumberCompare.$Eq(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit20), com.ftsafe.CCIDScheme.Lit1) ? LList.list4(com.ftsafe.CCIDScheme.Lit204, LList.list2(com.ftsafe.CCIDScheme.Lit205, BitwiseOp.ashift.apply2(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit188), com.ftsafe.CCIDScheme.Lit102)), LList.list2(com.ftsafe.CCIDScheme.Lit206, BitwiseOp.ashift.apply2(BitwiseOp.and.apply2(lists.cadr(PF), com.ftsafe.CCIDScheme.Lit172), com.ftsafe.CCIDScheme.Lit182)), LList.list2(com.ftsafe.CCIDScheme.Lit200, IF2)) : Values.empty)));
            }
            else {
                apply1 = com.ftsafe.CCIDScheme.pp.apply1("LRC error");
            }
            return apply1;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "car", 1, argValue);
        }
    }
    
    public static Object generateSBlockTPDUT1(final Object cmd, final Object data) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_0         /* cmd */
        //     4: getstatic       com/ftsafe/CCIDScheme.Lit191:Lgnu/mapping/SimpleSymbol;
        //     7: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    10: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    13: ifeq            22
        //    16: getstatic       com/ftsafe/CCIDScheme.Lit101:Lgnu/math/IntNum;
        //    19: goto            193
        //    22: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    25: aload_0         /* cmd */
        //    26: getstatic       com/ftsafe/CCIDScheme.Lit192:Lgnu/mapping/SimpleSymbol;
        //    29: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    32: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    35: ifeq            44
        //    38: getstatic       com/ftsafe/CCIDScheme.Lit111:Lgnu/math/IntNum;
        //    41: goto            193
        //    44: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    47: aload_0         /* cmd */
        //    48: getstatic       com/ftsafe/CCIDScheme.Lit193:Lgnu/mapping/SimpleSymbol;
        //    51: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    54: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    57: ifeq            66
        //    60: getstatic       com/ftsafe/CCIDScheme.Lit207:Lgnu/math/IntNum;
        //    63: goto            193
        //    66: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    69: aload_0         /* cmd */
        //    70: getstatic       com/ftsafe/CCIDScheme.Lit194:Lgnu/mapping/SimpleSymbol;
        //    73: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    76: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    79: ifeq            88
        //    82: getstatic       com/ftsafe/CCIDScheme.Lit208:Lgnu/math/IntNum;
        //    85: goto            193
        //    88: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    91: aload_0         /* cmd */
        //    92: getstatic       com/ftsafe/CCIDScheme.Lit209:Lgnu/mapping/SimpleSymbol;
        //    95: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    98: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   101: ifeq            110
        //   104: getstatic       com/ftsafe/CCIDScheme.Lit210:Lgnu/math/IntNum;
        //   107: goto            193
        //   110: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   113: aload_0         /* cmd */
        //   114: getstatic       com/ftsafe/CCIDScheme.Lit196:Lgnu/mapping/SimpleSymbol;
        //   117: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   120: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   123: ifeq            132
        //   126: getstatic       com/ftsafe/CCIDScheme.Lit211:Lgnu/math/IntNum;
        //   129: goto            193
        //   132: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   135: aload_0         /* cmd */
        //   136: getstatic       com/ftsafe/CCIDScheme.Lit212:Lgnu/mapping/SimpleSymbol;
        //   139: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   142: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   145: ifeq            154
        //   148: getstatic       com/ftsafe/CCIDScheme.Lit213:Lgnu/math/IntNum;
        //   151: goto            193
        //   154: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   157: aload_0         /* cmd */
        //   158: getstatic       com/ftsafe/CCIDScheme.Lit198:Lgnu/mapping/SimpleSymbol;
        //   161: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   164: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   167: ifeq            176
        //   170: getstatic       com/ftsafe/CCIDScheme.Lit214:Lgnu/math/IntNum;
        //   173: goto            193
        //   176: iconst_1       
        //   177: anewarray       Ljava/lang/Object;
        //   180: dup            
        //   181: iconst_0       
        //   182: ldc_w           "cmd not right!!!"
        //   185: aastore        
        //   186: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   189: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   192: athrow         
        //   193: astore_2       
        //   194: aload_1         /* data */
        //   195: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //   198: istore_3        /* LEN */
        //   199: iconst_2       
        //   200: anewarray       Ljava/lang/Object;
        //   203: dup            
        //   204: iconst_0       
        //   205: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   208: aload_2         /* PCB */
        //   209: iload_3         /* LEN */
        //   210: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   213: invokestatic    gnu/lists/LList.list3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   216: aastore        
        //   217: dup            
        //   218: iconst_1       
        //   219: aload_1         /* data */
        //   220: aastore        
        //   221: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   224: astore          _t
        //   226: iconst_2       
        //   227: anewarray       Ljava/lang/Object;
        //   230: dup            
        //   231: iconst_0       
        //   232: aload           _t
        //   234: aastore        
        //   235: dup            
        //   236: iconst_1       
        //   237: aload           _t
        //   239: invokestatic    com/ftsafe/CCIDScheme.listXor:(Ljava/lang/Object;)Ljava/lang/Object;
        //   242: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   245: aastore        
        //   246: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   249: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object generateIBlockTPDUT1(final Object N_S, final Object M$Mnbit, final Object data) {
        final Pair pf = LList.list3(com.ftsafe.CCIDScheme.Lit1, BitwiseOp.xor.apply2(BitwiseOp.xor.apply2(com.ftsafe.CCIDScheme.Lit1, BitwiseOp.ashift.apply2(N_S, com.ftsafe.CCIDScheme.Lit21)), BitwiseOp.ashift.apply2(M$Mnbit, com.ftsafe.CCIDScheme.Lit58)), Sequences.getSize(data));
        final Object pf_if = append.append$V(new Object[] { pf, data });
        return append.append$V(new Object[] { pf_if, LList.list1(listXor(pf_if)) });
    }
    
    public static Object generateRBlockTPDUT1(final Object N_R, final Object op) {
        final Pair pf = LList.list3(com.ftsafe.CCIDScheme.Lit1, BitwiseOp.ior.apply2(BitwiseOp.ior.apply2(com.ftsafe.CCIDScheme.Lit20, BitwiseOp.ashift.apply2(N_R, com.ftsafe.CCIDScheme.Lit18)), op), com.ftsafe.CCIDScheme.Lit1);
        return append.append$V(new Object[] { pf, LList.list1(listXor(pf)) });
    }
    
    public static Procedure makeGET_DEVICE_INFFunc(final Object usb_control_in, final Object descriptor$Mninfo) {
        public class CCIDScheme$frame13 extends ModuleBody
        {
            LList deviceInf;
            final ModuleMethod lambda$Fn20;
            
            public CCIDScheme$frame13() {
                final ModuleMethod lambda$Fn20 = new ModuleMethod(this, 7, null, 8192);
                lambda$Fn20.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:81");
                this.lambda$Fn20 = lambda$Fn20;
            }
            
            public static Object lambda33loop(final Object bNumInterfaces, final IntNum i) {
                return NumberCompare.$Ls(i, bNumInterfaces) ? lists.cons(i, lambda33loop(bNumInterfaces, IntNum.add(i, 1))) : LList.Empty;
            }
            
            public static Object lambda34loop(final Object iads, final IntNum i) {
                return NumberCompare.$Ls(i, lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit92, iads))) ? append.append$V(new Object[] { LList.list1(LList.list3(AddOp.apply2(1, i, lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit91, iads))), lists.assoc(com.ftsafe.CCIDScheme.Lit96, iads), lists.assoc(com.ftsafe.CCIDScheme.Lit92, iads))), lambda34loop(iads, IntNum.add(i, 1)) }) : LList.Empty;
            }
            
            Object lambda35() {
                return this.lambda35(com.ftsafe.CCIDScheme.Lit227, Boolean.FALSE);
            }
            
            Object lambda35(final Object opt) {
                return this.lambda35(opt, Boolean.FALSE);
            }
            
            Object lambda35(final Object opt, final Object index) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     4: ifeq            82
                //     7: aload_2         /* index */
                //     8: aload_0         /* this */
                //     9: getfield        com/ftsafe/CCIDScheme$frame13.deviceInf:Lgnu/lists/LList;
                //    12: invokevirtual   gnu/lists/LList.size:()I
                //    15: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //    18: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    21: ifeq            82
                //    24: iconst_1       
                //    25: anewarray       Ljava/lang/Object;
                //    28: dup            
                //    29: iconst_0       
                //    30: iconst_4       
                //    31: anewarray       Ljava/lang/Object;
                //    34: dup            
                //    35: iconst_0       
                //    36: ldc             "Device "
                //    38: aastore        
                //    39: dup            
                //    40: iconst_1       
                //    41: aload_2         /* index */
                //    42: ldc             Ljava/lang/Number;.class
                //    44: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    47: dup            
                //    48: astore_3       
                //    49: checkcast       Ljava/lang/Number;
                //    52: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
                //    55: aastore        
                //    56: dup            
                //    57: iconst_2       
                //    58: ldc             " not found : "
                //    60: aastore        
                //    61: dup            
                //    62: iconst_3       
                //    63: aload_0         /* this */
                //    64: getfield        com/ftsafe/CCIDScheme$frame13.deviceInf:Lgnu/lists/LList;
                //    67: invokestatic    com/ftsafe/CCIDScheme.object$To$String:(Ljava/lang/Object;)Ljava/lang/String;
                //    70: aastore        
                //    71: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
                //    74: aastore        
                //    75: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
                //    78: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
                //    81: athrow         
                //    82: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
                //    85: aload_1         /* opt */
                //    86: getstatic       com/ftsafe/CCIDScheme.Lit227:Lgnu/mapping/SimpleSymbol;
                //    89: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    92: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    95: ifeq            105
                //    98: aload_0         /* this */
                //    99: getfield        com/ftsafe/CCIDScheme$frame13.deviceInf:Lgnu/lists/LList;
                //   102: goto            199
                //   105: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
                //   108: aload_1         /* opt */
                //   109: getstatic       com/ftsafe/CCIDScheme.Lit228:Lgnu/mapping/SimpleSymbol;
                //   112: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   115: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   118: ifeq            134
                //   121: aload_0         /* this */
                //   122: getfield        com/ftsafe/CCIDScheme$frame13.deviceInf:Lgnu/lists/LList;
                //   125: invokevirtual   gnu/lists/LList.size:()I
                //   128: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //   131: goto            199
                //   134: aload_1         /* opt */
                //   135: aload_2         /* index */
                //   136: aload_0         /* this */
                //   137: getfield        com/ftsafe/CCIDScheme$frame13.deviceInf:Lgnu/lists/LList;
                //   140: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   143: ldc             Lgnu/lists/Pair;.class
                //   145: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   148: dup            
                //   149: astore_3       
                //   150: checkcast       Lgnu/lists/Pair;
                //   153: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   156: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   159: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   162: ifeq            196
                //   165: aload_1         /* opt */
                //   166: aload_2         /* index */
                //   167: aload_0         /* this */
                //   168: getfield        com/ftsafe/CCIDScheme$frame13.deviceInf:Lgnu/lists/LList;
                //   171: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   174: ldc             Lgnu/lists/Pair;.class
                //   176: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   179: dup            
                //   180: astore_3       
                //   181: checkcast       Lgnu/lists/Pair;
                //   184: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   187: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   190: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //   193: goto            199
                //   196: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   199: areturn        
                //   200: new             Lgnu/mapping/WrongType;
                //   203: dup_x1         
                //   204: swap           
                //   205: ldc             "number->string"
                //   207: iconst_1       
                //   208: aload_3        
                //   209: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   212: athrow         
                //   213: new             Lgnu/mapping/WrongType;
                //   216: dup_x1         
                //   217: swap           
                //   218: ldc             "cdr"
                //   220: iconst_1       
                //   221: aload_3        
                //   222: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   225: athrow         
                //   226: new             Lgnu/mapping/WrongType;
                //   229: dup_x1         
                //   230: swap           
                //   231: ldc             "cdr"
                //   233: iconst_1       
                //   234: aload_3        
                //   235: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   238: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  49     52     200    213    Ljava/lang/ClassCastException;
                //  150    153    213    226    Ljava/lang/ClassCastException;
                //  181    184    226    239    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 119 out of bounds for length 119
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
            public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                if (moduleMethod.selector == 7) {
                    ctx.proc = moduleMethod;
                    return ctx.pc = 0;
                }
                return super.match0(moduleMethod, ctx);
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 7) {
                    ctx.value1 = o;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, o, ctx);
            }
            
            @Override
            public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                if (moduleMethod.selector == 7) {
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
            public Object apply0(final ModuleMethod method) {
                if (method.selector == 7) {
                    return this.lambda35();
                }
                return super.apply0(method);
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object arg1) {
                if (method.selector == 7) {
                    return this.lambda35(arg1);
                }
                return super.apply1(method, arg1);
            }
            
            @Override
            public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                if (method.selector == 7) {
                    return this.lambda35(o, o2);
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
        //     4: invokespecial   com/ftsafe/CCIDScheme$frame13.<init>:()V
        //     7: astore_2        /* $heapFrame */
        //     8: getstatic       com/ftsafe/CCIDScheme.Lit45:Lgnu/mapping/SimpleSymbol;
        //    11: getstatic       com/ftsafe/CCIDScheme.Lit215:Lgnu/mapping/SimpleSymbol;
        //    14: aload_1         /* descriptor$Mninfo */
        //    15: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    18: ldc             Lgnu/lists/Pair;.class
        //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    23: dup            
        //    24: astore          4
        //    26: checkcast       Lgnu/lists/Pair;
        //    29: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    32: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    35: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    38: astore_3        /* bNumInterfaces */
        //    39: aload_3         /* bNumInterfaces */
        //    40: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //    43: invokestatic    com/ftsafe/CCIDScheme$frame13.lambda33loop:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
        //    46: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    49: astore          4
        //    51: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    54: astore          5
        //    56: aconst_null    
        //    57: astore          6
        //    59: aload           4
        //    61: invokeinterface java/util/Iterator.hasNext:()Z
        //    66: ifeq            924
        //    69: aload           4
        //    71: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    76: astore          7
        //    78: iconst_2       
        //    79: anewarray       Ljava/lang/Object;
        //    82: dup            
        //    83: iconst_0       
        //    84: ldc_w           "interface"
        //    87: aastore        
        //    88: dup            
        //    89: iconst_1       
        //    90: aload           7
        //    92: ldc             Ljava/lang/Number;.class
        //    94: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    97: dup            
        //    98: astore          11
        //   100: checkcast       Ljava/lang/Number;
        //   103: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
        //   106: aastore        
        //   107: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   110: invokestatic    kawa/lib/misc.string$To$Symbol:(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
        //   113: astore          x
        //   115: aload           x
        //   117: aload_1         /* descriptor$Mninfo */
        //   118: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   121: ldc             Lgnu/lists/Pair;.class
        //   123: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   126: dup            
        //   127: astore          12
        //   129: checkcast       Lgnu/lists/Pair;
        //   132: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   135: astore          interfaceI
        //   137: getstatic       com/ftsafe/CCIDScheme.Lit57:Lgnu/mapping/SimpleSymbol;
        //   140: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   143: aload           interfaceI
        //   145: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   148: ldc             Lgnu/lists/Pair;.class
        //   150: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   153: dup            
        //   154: astore          13
        //   156: checkcast       Lgnu/lists/Pair;
        //   159: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   162: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   165: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   168: astore          iInterface
        //   170: getstatic       com/ftsafe/CCIDScheme.Lit39:Lgnu/mapping/SimpleSymbol;
        //   173: getstatic       com/ftsafe/CCIDScheme.Lit216:Lgnu/mapping/SimpleSymbol;
        //   176: aload_1         /* descriptor$Mninfo */
        //   177: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   180: ldc             Lgnu/lists/Pair;.class
        //   182: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   185: dup            
        //   186: astore          14
        //   188: checkcast       Lgnu/lists/Pair;
        //   191: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   194: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   197: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   200: astore          iManufacture
        //   202: getstatic       com/ftsafe/CCIDScheme.Lit40:Lgnu/mapping/SimpleSymbol;
        //   205: getstatic       com/ftsafe/CCIDScheme.Lit216:Lgnu/mapping/SimpleSymbol;
        //   208: aload_1         /* descriptor$Mninfo */
        //   209: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   212: ldc             Lgnu/lists/Pair;.class
        //   214: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   217: dup            
        //   218: astore          15
        //   220: checkcast       Lgnu/lists/Pair;
        //   223: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   226: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   229: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   232: astore          iProduct
        //   234: aload_0         /* usb_control_in */
        //   235: aload           iManufacture
        //   237: invokestatic    com/ftsafe/CCIDScheme.getStringDescriptor:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
        //   240: astore          manufactureStr
        //   242: aload_0         /* usb_control_in */
        //   243: aload           iProduct
        //   245: invokestatic    com/ftsafe/CCIDScheme.getStringDescriptor:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
        //   248: astore          productStr
        //   250: getstatic       com/ftsafe/CCIDScheme.Lit217:Lgnu/mapping/SimpleSymbol;
        //   253: aload_1         /* descriptor$Mninfo */
        //   254: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   257: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   260: ifeq            387
        //   263: getstatic       com/ftsafe/CCIDScheme.Lit217:Lgnu/mapping/SimpleSymbol;
        //   266: aload_1         /* descriptor$Mninfo */
        //   267: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   270: ldc             Lgnu/lists/Pair;.class
        //   272: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   275: dup            
        //   276: astore          19
        //   278: checkcast       Lgnu/lists/Pair;
        //   281: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   284: astore          iads
        //   286: aload           iads
        //   288: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   291: astore          19
        //   293: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   296: astore          20
        //   298: aconst_null    
        //   299: astore          21
        //   301: aload           19
        //   303: invokeinterface java/util/Iterator.hasNext:()Z
        //   308: ifeq            379
        //   311: aload           19
        //   313: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   318: astore          22
        //   320: new             Lgnu/lists/Pair;
        //   323: dup            
        //   324: aload           22
        //   326: ldc             Lgnu/lists/Pair;.class
        //   328: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   331: dup            
        //   332: astore          25
        //   334: checkcast       Lgnu/lists/Pair;
        //   337: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   340: astore          iads
        //   342: aload           iads
        //   344: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   347: invokestatic    com/ftsafe/CCIDScheme$frame13.lambda34loop:(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
        //   350: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   353: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   356: aload           21
        //   358: ifnonnull       367
        //   361: dup            
        //   362: astore          20
        //   364: goto            374
        //   367: aload           21
        //   369: swap           
        //   370: dup_x1         
        //   371: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   374: astore          21
        //   376: goto            301
        //   379: aload           20
        //   381: invokestatic    com/ftsafe/CCIDScheme.alist$To$List:(Ljava/lang/Object;)Ljava/lang/Object;
        //   384: goto            390
        //   387: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   390: astore          iads_iFunction
        //   392: iconst_2       
        //   393: anewarray       Ljava/lang/Object;
        //   396: dup            
        //   397: iconst_0       
        //   398: aload           7
        //   400: getstatic       com/ftsafe/CCIDScheme.Lit218:Lgnu/mapping/SimpleSymbol;
        //   403: iconst_3       
        //   404: anewarray       Ljava/lang/Object;
        //   407: dup            
        //   408: iconst_0       
        //   409: aload           manufactureStr
        //   411: aastore        
        //   412: dup            
        //   413: iconst_1       
        //   414: ldc_w           " "
        //   417: aastore        
        //   418: dup            
        //   419: iconst_2       
        //   420: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   423: aload           iInterface
        //   425: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   428: ifne            440
        //   431: aload_0         /* usb_control_in */
        //   432: aload           iInterface
        //   434: invokestatic    com/ftsafe/CCIDScheme.getStringDescriptor:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
        //   437: goto            736
        //   440: aload           iads_iFunction
        //   442: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   445: ifeq            452
        //   448: iconst_0       
        //   449: goto            453
        //   452: iconst_1       
        //   453: istore          x
        //   455: iload           x
        //   457: ifeq            468
        //   460: iload           x
        //   462: ifeq            609
        //   465: goto            543
        //   468: aload           7
        //   470: aload           iads_iFunction
        //   472: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   475: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   478: ifeq            485
        //   481: iconst_0       
        //   482: goto            486
        //   485: iconst_1       
        //   486: istore          x
        //   488: iload           x
        //   490: ifeq            501
        //   493: iload           x
        //   495: ifeq            609
        //   498: goto            543
        //   501: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   504: getstatic       com/ftsafe/CCIDScheme.Lit219:Lgnu/lists/PairWithPosition;
        //   507: getstatic       com/ftsafe/CCIDScheme.Lit96:Lgnu/mapping/SimpleSymbol;
        //   510: aload           7
        //   512: aload           iads_iFunction
        //   514: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   517: ldc             Lgnu/lists/Pair;.class
        //   519: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   522: dup            
        //   523: astore          20
        //   525: checkcast       Lgnu/lists/Pair;
        //   528: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   531: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   534: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   537: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   540: ifeq            609
        //   543: iconst_2       
        //   544: anewarray       Ljava/lang/Object;
        //   547: dup            
        //   548: iconst_0       
        //   549: aload           productStr
        //   551: aastore        
        //   552: dup            
        //   553: iconst_1       
        //   554: aload_3         /* bNumInterfaces */
        //   555: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   558: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   561: ifeq            570
        //   564: ldc_w           ""
        //   567: goto            602
        //   570: iconst_2       
        //   571: anewarray       Ljava/lang/Object;
        //   574: dup            
        //   575: iconst_0       
        //   576: ldc_w           " "
        //   579: aastore        
        //   580: dup            
        //   581: iconst_1       
        //   582: aload           7
        //   584: ldc             Ljava/lang/Number;.class
        //   586: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   589: dup            
        //   590: astore          19
        //   592: checkcast       Ljava/lang/Number;
        //   595: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
        //   598: aastore        
        //   599: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   602: aastore        
        //   603: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   606: goto            736
        //   609: iconst_2       
        //   610: anewarray       Ljava/lang/Object;
        //   613: dup            
        //   614: iconst_0       
        //   615: aload_0         /* usb_control_in */
        //   616: getstatic       com/ftsafe/CCIDScheme.Lit96:Lgnu/mapping/SimpleSymbol;
        //   619: aload           7
        //   621: aload           iads_iFunction
        //   623: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   626: ldc             Lgnu/lists/Pair;.class
        //   628: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   631: dup            
        //   632: astore          19
        //   634: checkcast       Lgnu/lists/Pair;
        //   637: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   640: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   643: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   646: invokestatic    com/ftsafe/CCIDScheme.getStringDescriptor:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/CharSequence;
        //   649: aastore        
        //   650: dup            
        //   651: iconst_1       
        //   652: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   655: getstatic       com/ftsafe/CCIDScheme.Lit220:Lgnu/lists/PairWithPosition;
        //   658: getstatic       com/ftsafe/CCIDScheme.Lit92:Lgnu/mapping/SimpleSymbol;
        //   661: aload           7
        //   663: aload           iads_iFunction
        //   665: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   668: ldc             Lgnu/lists/Pair;.class
        //   670: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   673: dup            
        //   674: astore          19
        //   676: checkcast       Lgnu/lists/Pair;
        //   679: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   682: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   685: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   688: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   691: ifeq            700
        //   694: ldc_w           ""
        //   697: goto            732
        //   700: iconst_2       
        //   701: anewarray       Ljava/lang/Object;
        //   704: dup            
        //   705: iconst_0       
        //   706: ldc_w           " "
        //   709: aastore        
        //   710: dup            
        //   711: iconst_1       
        //   712: aload           7
        //   714: ldc             Ljava/lang/Number;.class
        //   716: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   719: dup            
        //   720: astore          19
        //   722: checkcast       Ljava/lang/Number;
        //   725: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
        //   728: aastore        
        //   729: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   732: aastore        
        //   733: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   736: aastore        
        //   737: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   740: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   743: getstatic       com/ftsafe/CCIDScheme.Lit221:Lgnu/mapping/SimpleSymbol;
        //   746: getstatic       com/ftsafe/CCIDScheme.Lit59:Lgnu/mapping/SimpleSymbol;
        //   749: getstatic       com/ftsafe/CCIDScheme.Lit222:Lgnu/mapping/SimpleSymbol;
        //   752: aload           interfaceI
        //   754: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   757: ldc             Lgnu/lists/Pair;.class
        //   759: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   762: dup            
        //   763: astore          18
        //   765: checkcast       Lgnu/lists/Pair;
        //   768: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   771: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   774: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   777: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   780: getstatic       com/ftsafe/CCIDScheme.Lit223:Lgnu/mapping/SimpleSymbol;
        //   783: getstatic       com/ftsafe/CCIDScheme.Lit59:Lgnu/mapping/SimpleSymbol;
        //   786: getstatic       com/ftsafe/CCIDScheme.Lit224:Lgnu/mapping/SimpleSymbol;
        //   789: aload           interfaceI
        //   791: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   794: ldc             Lgnu/lists/Pair;.class
        //   796: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   799: dup            
        //   800: astore          18
        //   802: checkcast       Lgnu/lists/Pair;
        //   805: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   808: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   811: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   814: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   817: invokestatic    gnu/lists/LList.list4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   820: aastore        
        //   821: dup            
        //   822: iconst_1       
        //   823: getstatic       com/ftsafe/CCIDScheme.Lit225:Lgnu/mapping/SimpleSymbol;
        //   826: aload           interfaceI
        //   828: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   831: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   834: ifeq            880
        //   837: getstatic       com/ftsafe/CCIDScheme.Lit226:Lgnu/mapping/SimpleSymbol;
        //   840: getstatic       com/ftsafe/CCIDScheme.Lit59:Lgnu/mapping/SimpleSymbol;
        //   843: getstatic       com/ftsafe/CCIDScheme.Lit225:Lgnu/mapping/SimpleSymbol;
        //   846: aload           interfaceI
        //   848: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   851: ldc             Lgnu/lists/Pair;.class
        //   853: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   856: dup            
        //   857: astore          18
        //   859: checkcast       Lgnu/lists/Pair;
        //   862: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   865: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   868: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   871: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   874: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   877: goto            883
        //   880: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   883: aastore        
        //   884: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   887: astore          9
        //   889: new             Lgnu/lists/Pair;
        //   892: dup            
        //   893: aload           9
        //   895: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   898: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   901: aload           6
        //   903: ifnonnull       912
        //   906: dup            
        //   907: astore          5
        //   909: goto            919
        //   912: aload           6
        //   914: swap           
        //   915: dup_x1         
        //   916: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   919: astore          6
        //   921: goto            59
        //   924: aload           5
        //   926: aload_2         /* $heapFrame */
        //   927: swap           
        //   928: putfield        com/ftsafe/CCIDScheme$frame13.deviceInf:Lgnu/lists/LList;
        //   931: aload_2         /* $heapFrame */
        //   932: getfield        com/ftsafe/CCIDScheme$frame13.lambda$Fn20:Lgnu/expr/ModuleMethod;
        //   935: areturn        
        //   936: new             Lgnu/mapping/WrongType;
        //   939: dup_x1         
        //   940: swap           
        //   941: ldc             "cdr"
        //   943: iconst_1       
        //   944: aload           4
        //   946: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   949: athrow         
        //   950: new             Lgnu/mapping/WrongType;
        //   953: dup_x1         
        //   954: swap           
        //   955: ldc_w           "number->string"
        //   958: iconst_1       
        //   959: aload           11
        //   961: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   964: athrow         
        //   965: new             Lgnu/mapping/WrongType;
        //   968: dup_x1         
        //   969: swap           
        //   970: ldc             "cdr"
        //   972: iconst_1       
        //   973: aload           12
        //   975: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   978: athrow         
        //   979: new             Lgnu/mapping/WrongType;
        //   982: dup_x1         
        //   983: swap           
        //   984: ldc             "cdr"
        //   986: iconst_1       
        //   987: aload           13
        //   989: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   992: athrow         
        //   993: new             Lgnu/mapping/WrongType;
        //   996: dup_x1         
        //   997: swap           
        //   998: ldc             "cdr"
        //  1000: iconst_1       
        //  1001: aload           14
        //  1003: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1006: athrow         
        //  1007: new             Lgnu/mapping/WrongType;
        //  1010: dup_x1         
        //  1011: swap           
        //  1012: ldc             "cdr"
        //  1014: iconst_1       
        //  1015: aload           15
        //  1017: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1020: athrow         
        //  1021: new             Lgnu/mapping/WrongType;
        //  1024: dup_x1         
        //  1025: swap           
        //  1026: ldc             "cdr"
        //  1028: iconst_1       
        //  1029: aload           19
        //  1031: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1034: athrow         
        //  1035: new             Lgnu/mapping/WrongType;
        //  1038: dup_x1         
        //  1039: swap           
        //  1040: ldc             "cdr"
        //  1042: iconst_1       
        //  1043: aload           25
        //  1045: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1048: athrow         
        //  1049: new             Lgnu/mapping/WrongType;
        //  1052: dup_x1         
        //  1053: swap           
        //  1054: ldc             "cdr"
        //  1056: iconst_1       
        //  1057: aload           20
        //  1059: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1062: athrow         
        //  1063: new             Lgnu/mapping/WrongType;
        //  1066: dup_x1         
        //  1067: swap           
        //  1068: ldc_w           "number->string"
        //  1071: iconst_1       
        //  1072: aload           19
        //  1074: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1077: athrow         
        //  1078: new             Lgnu/mapping/WrongType;
        //  1081: dup_x1         
        //  1082: swap           
        //  1083: ldc             "cdr"
        //  1085: iconst_1       
        //  1086: aload           19
        //  1088: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1091: athrow         
        //  1092: new             Lgnu/mapping/WrongType;
        //  1095: dup_x1         
        //  1096: swap           
        //  1097: ldc             "cdr"
        //  1099: iconst_1       
        //  1100: aload           19
        //  1102: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1105: athrow         
        //  1106: new             Lgnu/mapping/WrongType;
        //  1109: dup_x1         
        //  1110: swap           
        //  1111: ldc_w           "number->string"
        //  1114: iconst_1       
        //  1115: aload           19
        //  1117: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1120: athrow         
        //  1121: new             Lgnu/mapping/WrongType;
        //  1124: dup_x1         
        //  1125: swap           
        //  1126: ldc             "cdr"
        //  1128: iconst_1       
        //  1129: aload           18
        //  1131: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1134: athrow         
        //  1135: new             Lgnu/mapping/WrongType;
        //  1138: dup_x1         
        //  1139: swap           
        //  1140: ldc             "cdr"
        //  1142: iconst_1       
        //  1143: aload           18
        //  1145: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1148: athrow         
        //  1149: new             Lgnu/mapping/WrongType;
        //  1152: dup_x1         
        //  1153: swap           
        //  1154: ldc             "cdr"
        //  1156: iconst_1       
        //  1157: aload           18
        //  1159: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1162: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  26     29     936    950    Ljava/lang/ClassCastException;
        //  100    103    950    965    Ljava/lang/ClassCastException;
        //  129    132    965    979    Ljava/lang/ClassCastException;
        //  156    159    979    993    Ljava/lang/ClassCastException;
        //  188    191    993    1007   Ljava/lang/ClassCastException;
        //  220    223    1007   1021   Ljava/lang/ClassCastException;
        //  278    281    1021   1035   Ljava/lang/ClassCastException;
        //  334    337    1035   1049   Ljava/lang/ClassCastException;
        //  525    528    1049   1063   Ljava/lang/ClassCastException;
        //  592    595    1063   1078   Ljava/lang/ClassCastException;
        //  634    637    1078   1092   Ljava/lang/ClassCastException;
        //  676    679    1092   1106   Ljava/lang/ClassCastException;
        //  722    725    1106   1121   Ljava/lang/ClassCastException;
        //  765    768    1121   1135   Ljava/lang/ClassCastException;
        //  802    805    1135   1149   Ljava/lang/ClassCastException;
        //  859    862    1149   1163   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 538 out of bounds for length 538
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
    
    public static Object doPPSExchange(final Object usb_send_recv, final Object slot, final Object atr) {
        final Object pps = generatePPSExchange(atr);
        final Pair ret = RDR_to_PC_DataBlock(Scheme.applyToArgs.apply2(usb_send_recv, PC_to_RDR_XfrBlock(slot, com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit1, pps)));
        if (!KawaConvert.isTrue(Scheme.isEqual.apply2(lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit126, ret)), slot))) {
            com.ftsafe.CCIDScheme.pp.apply1("slot not equal");
        }
        if (!KawaConvert.isTrue(Scheme.isEqual.apply2(lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit129, ret)), pps))) {
            com.ftsafe.CCIDScheme.pp.apply1("pps not equal should try default");
            exceptions.error("USE-DEFAULT-PPS-EXCHANGE");
            throw Special.reachedUnexpected;
        }
        return lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit129, ret));
    }
    
    public static Object doPPSSetParameters(final Object usb_send_recv, final Object slot, final Object atr) {
        IntNum intNum;
        if (KawaConvert.isTrue(Scheme.isEqual.apply2(getAtrSupportProtocol(atr), com.ftsafe.CCIDScheme.Lit147))) {
            intNum = com.ftsafe.CCIDScheme.Lit1;
        }
        else if (KawaConvert.isTrue(Scheme.isEqual.apply2(getAtrSupportProtocol(atr), com.ftsafe.CCIDScheme.Lit160))) {
            intNum = com.ftsafe.CCIDScheme.Lit2;
        }
        else {
            if (!KawaConvert.isTrue(Scheme.isEqual.apply2(getAtrSupportProtocol(atr), com.ftsafe.CCIDScheme.Lit159))) {
                exceptions.error("do-PPS-set-parameters error 1 should not happend");
                throw Special.reachedUnexpected;
            }
            intNum = com.ftsafe.CCIDScheme.Lit2;
        }
        final IntNum protocol = intNum;
        Pair pair;
        if (KawaConvert.isTrue(Scheme.isEqual.apply2(protocol, com.ftsafe.CCIDScheme.Lit1))) {
            pair = generatePPSParametersT0(atr);
        }
        else {
            if (!KawaConvert.isTrue(Scheme.isEqual.apply2(protocol, com.ftsafe.CCIDScheme.Lit2))) {
                exceptions.error("do-PPS-set-parameters error 2 should not happend");
                throw Special.reachedUnexpected;
            }
            pair = generatePPSParametersT1(atr);
        }
        final Pair pps$Mnparameters = pair;
        final Pair ret = RDR_to_PC_Parameters(Scheme.applyToArgs.apply2(usb_send_recv, PC_to_RDR_SetParameters(slot, protocol, pps$Mnparameters)));
        if (!KawaConvert.isTrue(Scheme.isEqual.apply2(lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit126, ret)), slot))) {
            com.ftsafe.CCIDScheme.pp.apply1("slot not equal");
        }
        return KawaConvert.isTrue(Scheme.isEqual.apply2(lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit137, ret)), pps$Mnparameters)) ? lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit137, ret)) : com.ftsafe.CCIDScheme.pp.apply1("abProtocolDataStructure not equal");
    }
    
    public static Object doPPS(final Object usb_send_recv, final Object slot, final Object atr) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       com/ftsafe/CCIDScheme.current_dev_interface:Lgnu/mapping/Procedure;
        //     6: invokevirtual   gnu/mapping/Procedure.apply0:()Ljava/lang/Object;
        //     9: getstatic       com/ftsafe/CCIDScheme.descriptor$Mninfo:Ljava/lang/Object;
        //    12: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    15: ldc             Lgnu/lists/Pair;.class
        //    17: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    20: dup            
        //    21: astore          4
        //    23: checkcast       Lgnu/lists/Pair;
        //    26: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    29: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    32: ldc             Lgnu/lists/Pair;.class
        //    34: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    37: dup            
        //    38: astore          4
        //    40: checkcast       Lgnu/lists/Pair;
        //    43: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    46: astore_3        /* ccid_desc */
        //    47: getstatic       com/ftsafe/CCIDScheme.Lit83:Lgnu/mapping/SimpleSymbol;
        //    50: aload_3         /* ccid_desc */
        //    51: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    54: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    57: astore          dwFeatures
        //    59: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    62: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //    65: aload           dwFeatures
        //    67: getstatic       com/ftsafe/CCIDScheme.Lit9:Lgnu/math/IntNum;
        //    70: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    73: getstatic       com/ftsafe/CCIDScheme.Lit229:Lgnu/math/IntNum;
        //    76: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    79: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    82: ifeq            127
        //    85: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //    88: ldc_w           "do pps exchange"
        //    91: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    94: pop            
        //    95: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //    98: aload_0         /* usb_send_recv */
        //    99: aload_1         /* slot */
        //   100: aload_2         /* atr */
        //   101: invokestatic    com/ftsafe/CCIDScheme.doPPSExchange:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   104: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   107: pop            
        //   108: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   111: ldc_w           "do pps"
        //   114: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   117: pop            
        //   118: aload_0         /* usb_send_recv */
        //   119: aload_1         /* slot */
        //   120: aload_2         /* atr */
        //   121: invokestatic    com/ftsafe/CCIDScheme.doPPSSetParameters:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   124: goto            435
        //   127: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   130: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   133: aload           dwFeatures
        //   135: getstatic       com/ftsafe/CCIDScheme.Lit9:Lgnu/math/IntNum;
        //   138: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   141: getstatic       com/ftsafe/CCIDScheme.Lit230:Lgnu/math/IntNum;
        //   144: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   147: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   150: ifeq            182
        //   153: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   156: ldc_w           "do not do pps exchange"
        //   159: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   162: pop            
        //   163: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   166: ldc_w           "do pps"
        //   169: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   172: pop            
        //   173: aload_0         /* usb_send_recv */
        //   174: aload_1         /* slot */
        //   175: aload_2         /* atr */
        //   176: invokestatic    com/ftsafe/CCIDScheme.doPPSSetParameters:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   179: goto            435
        //   182: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   185: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   188: aload           dwFeatures
        //   190: getstatic       com/ftsafe/CCIDScheme.Lit9:Lgnu/math/IntNum;
        //   193: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   196: getstatic       com/ftsafe/CCIDScheme.Lit230:Lgnu/math/IntNum;
        //   199: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   202: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   205: ifeq            230
        //   208: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   211: ldc_w           "do not do pps exchange"
        //   214: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   217: pop            
        //   218: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   221: ldc_w           "do not pps"
        //   224: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   227: goto            435
        //   230: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   233: aload           dwFeatures
        //   235: getstatic       com/ftsafe/CCIDScheme.Lit188:Lgnu/math/IntNum;
        //   238: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   241: getstatic       com/ftsafe/CCIDScheme.Lit188:Lgnu/math/IntNum;
        //   244: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   247: ifeq            262
        //   250: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   253: ldc_w           "do not do pps"
        //   256: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   259: goto            435
        //   262: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   265: aload           dwFeatures
        //   267: getstatic       com/ftsafe/CCIDScheme.Lit20:Lgnu/math/IntNum;
        //   270: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   273: getstatic       com/ftsafe/CCIDScheme.Lit20:Lgnu/math/IntNum;
        //   276: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   279: istore          x
        //   281: iload           x
        //   283: ifeq            294
        //   286: iload           x
        //   288: ifeq            332
        //   291: goto            319
        //   294: getstatic       com/ftsafe/CCIDScheme.Lit141:Lgnu/mapping/SimpleSymbol;
        //   297: getstatic       com/ftsafe/CCIDScheme.Lit168:Lgnu/mapping/SimpleSymbol;
        //   300: getstatic       com/ftsafe/CCIDScheme.Lit158:Lgnu/mapping/SimpleSymbol;
        //   303: aload_2         /* atr */
        //   304: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   307: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   310: invokestatic    com/ftsafe/CCIDScheme.assocEX:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   313: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   316: ifeq            332
        //   319: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   322: ldc_w           "do not do pps exchange"
        //   325: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   328: pop            
        //   329: goto            387
        //   332: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   335: getstatic       com/ftsafe/CCIDScheme.Lit160:Lgnu/mapping/SimpleSymbol;
        //   338: aload_2         /* atr */
        //   339: invokestatic    com/ftsafe/CCIDScheme.getAtrSupportProtocol:(Ljava/lang/Object;)Ljava/lang/Object;
        //   342: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   345: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   348: ifeq            364
        //   351: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   354: ldc_w           "do pps exchange but not execute"
        //   357: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   360: pop            
        //   361: goto            387
        //   364: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   367: ldc_w           "do pps exchange"
        //   370: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   373: pop            
        //   374: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   377: aload_0         /* usb_send_recv */
        //   378: aload_1         /* slot */
        //   379: aload_2         /* atr */
        //   380: invokestatic    com/ftsafe/CCIDScheme.doPPSExchange:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   383: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   386: pop            
        //   387: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   390: aload           dwFeatures
        //   392: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   395: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   398: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   401: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   404: ifeq            419
        //   407: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   410: ldc_w           "do not pps"
        //   413: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   416: goto            435
        //   419: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   422: ldc_w           "do pps"
        //   425: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   428: pop            
        //   429: aload_0         /* usb_send_recv */
        //   430: aload_1         /* slot */
        //   431: aload_2         /* atr */
        //   432: invokestatic    com/ftsafe/CCIDScheme.doPPSSetParameters:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   435: areturn        
        //   436: new             Lgnu/mapping/WrongType;
        //   439: dup_x1         
        //   440: swap           
        //   441: ldc             "cdr"
        //   443: iconst_1       
        //   444: aload           4
        //   446: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   449: athrow         
        //   450: new             Lgnu/mapping/WrongType;
        //   453: dup_x1         
        //   454: swap           
        //   455: ldc             "cdr"
        //   457: iconst_1       
        //   458: aload           4
        //   460: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   463: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  23     26     436    450    Ljava/lang/ClassCastException;
        //  40     43     450    464    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0127:
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
    
    public static SimpleSymbol getCcidExchangeLevel(final Object desc) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       com/ftsafe/CCIDScheme.current_dev_interface:Lgnu/mapping/Procedure;
        //     6: invokevirtual   gnu/mapping/Procedure.apply0:()Ljava/lang/Object;
        //     9: aload_0         /* desc */
        //    10: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    13: ldc             Lgnu/lists/Pair;.class
        //    15: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    18: dup            
        //    19: astore_2       
        //    20: checkcast       Lgnu/lists/Pair;
        //    23: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    26: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    29: ldc             Lgnu/lists/Pair;.class
        //    31: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    34: dup            
        //    35: astore_2       
        //    36: checkcast       Lgnu/lists/Pair;
        //    39: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    42: astore_1        /* ccid_desc */
        //    43: getstatic       com/ftsafe/CCIDScheme.Lit83:Lgnu/mapping/SimpleSymbol;
        //    46: aload_1         /* ccid_desc */
        //    47: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    50: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    53: astore_2        /* dwFeatures */
        //    54: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    57: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //    60: aload_2         /* dwFeatures */
        //    61: getstatic       com/ftsafe/CCIDScheme.Lit231:Lgnu/math/IntNum;
        //    64: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    67: getstatic       com/ftsafe/CCIDScheme.Lit232:Lgnu/math/IntNum;
        //    70: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    73: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    76: ifeq            95
        //    79: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //    82: ldc_w           "TPDU level exchanges with CCID"
        //    85: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    88: pop            
        //    89: getstatic       com/ftsafe/CCIDScheme.Lit233:Lgnu/mapping/SimpleSymbol;
        //    92: goto            190
        //    95: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    98: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   101: aload_2         /* dwFeatures */
        //   102: getstatic       com/ftsafe/CCIDScheme.Lit231:Lgnu/math/IntNum;
        //   105: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   108: getstatic       com/ftsafe/CCIDScheme.Lit234:Lgnu/math/IntNum;
        //   111: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   114: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   117: ifeq            136
        //   120: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   123: ldc_w           "Short APDU level exchange with CCID"
        //   126: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   129: pop            
        //   130: getstatic       com/ftsafe/CCIDScheme.Lit235:Lgnu/mapping/SimpleSymbol;
        //   133: goto            190
        //   136: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   139: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   142: aload_2         /* dwFeatures */
        //   143: getstatic       com/ftsafe/CCIDScheme.Lit231:Lgnu/math/IntNum;
        //   146: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   149: getstatic       com/ftsafe/CCIDScheme.Lit236:Lgnu/math/IntNum;
        //   152: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   155: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   158: ifeq            177
        //   161: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   164: ldc_w           "Short and Extended APDU level exchange with CCID"
        //   167: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   170: pop            
        //   171: getstatic       com/ftsafe/CCIDScheme.Lit237:Lgnu/mapping/SimpleSymbol;
        //   174: goto            190
        //   177: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   180: ldc_w           "the level of exchange is character"
        //   183: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   186: pop            
        //   187: getstatic       com/ftsafe/CCIDScheme.Lit238:Lgnu/mapping/SimpleSymbol;
        //   190: areturn        
        //   191: new             Lgnu/mapping/WrongType;
        //   194: dup_x1         
        //   195: swap           
        //   196: ldc             "cdr"
        //   198: iconst_1       
        //   199: aload_2        
        //   200: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   203: athrow         
        //   204: new             Lgnu/mapping/WrongType;
        //   207: dup_x1         
        //   208: swap           
        //   209: ldc             "cdr"
        //   211: iconst_1       
        //   212: aload_2        
        //   213: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   216: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  20     23     191    204    Ljava/lang/ClassCastException;
        //  36     39     204    217    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0095:
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
    
    public static Object doXfrBlockTPDUT0Protocol(final Object usb_send, final Object usb_recv, final Object slot, final Object data) {
        Scheme.applyToArgs.apply2(usb_send, PC_to_RDR_XfrBlock(slot, com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit1, data));
        while (true) {
            final Pair ret = RDR_to_PC_DataBlock(Scheme.applyToArgs.apply1(usb_recv));
            if (!KawaConvert.isTrue(Scheme.isEqual.apply2(lists.assoc(com.ftsafe.CCIDScheme.Lit126, ret), LList.list2(com.ftsafe.CCIDScheme.Lit126, slot)))) {
                exceptions.error("bSlot not equal");
                throw Special.reachedUnexpected;
            }
            if (!KawaConvert.isTrue(Scheme.isEqual.apply2(lists.assoc(com.ftsafe.CCIDScheme.Lit125, ret), LList.list2(com.ftsafe.CCIDScheme.Lit125, Sequences.getSize(lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit129, ret))))))) {
                exceptions.error("dwLength not equal");
                throw Special.reachedUnexpected;
            }
            if (KawaConvert.isTrue(Scheme.isEqual.apply2(BitwiseOp.and.apply2(lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit127, ret)), com.ftsafe.CCIDScheme.Lit20), com.ftsafe.CCIDScheme.Lit20))) {
                continue;
            }
            return lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit129, ret));
        }
    }
    
    public static Object doXfrBlockAPDUExtendedProtocol(final Object usb_send, final Object usb_recv, final Object slot, final Object data) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       com/ftsafe/CCIDScheme.Lit98:Lgnu/mapping/SimpleSymbol;
        //     6: getstatic       com/ftsafe/CCIDScheme.current_dev_interface:Lgnu/mapping/Procedure;
        //     9: invokevirtual   gnu/mapping/Procedure.apply0:()Ljava/lang/Object;
        //    12: getstatic       com/ftsafe/CCIDScheme.descriptor$Mninfo:Ljava/lang/Object;
        //    15: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    18: ldc             Lgnu/lists/Pair;.class
        //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    23: dup            
        //    24: astore          5
        //    26: checkcast       Lgnu/lists/Pair;
        //    29: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    32: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    35: ldc             Lgnu/lists/Pair;.class
        //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    40: dup            
        //    41: astore          5
        //    43: checkcast       Lgnu/lists/Pair;
        //    46: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    49: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    52: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //    55: astore          dwMaxCCIDMessageLength
        //    57: aload_3         /* data */
        //    58: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //    61: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    64: iconst_m1      
        //    65: aload           dwMaxCCIDMessageLength
        //    67: getstatic       com/ftsafe/CCIDScheme.Lit114:Lgnu/math/IntNum;
        //    70: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    73: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    76: ifeq            111
        //    79: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    82: aload_0         /* usb_send */
        //    83: aload_2         /* slot */
        //    84: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //    87: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //    90: aload_3         /* data */
        //    91: invokestatic    com/ftsafe/CCIDScheme.PC_to_RDR_XfrBlock:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    94: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    97: pop            
        //    98: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   101: aload_1         /* usb_recv */
        //   102: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   105: invokestatic    com/ftsafe/CCIDScheme.RDR_to_PC_DataBlock:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   108: goto            471
        //   111: aload_3         /* data */
        //   112: iconst_m1      
        //   113: aload           dwMaxCCIDMessageLength
        //   115: getstatic       com/ftsafe/CCIDScheme.Lit114:Lgnu/math/IntNum;
        //   118: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   121: invokestatic    com/ftsafe/CCIDScheme.groupList:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   124: astore          abDatas
        //   126: iconst_3       
        //   127: anewarray       Ljava/lang/Object;
        //   130: dup            
        //   131: iconst_0       
        //   132: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   135: aload           abDatas
        //   137: ldc             Lgnu/lists/Pair;.class
        //   139: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   142: dup            
        //   143: astore          8
        //   145: checkcast       Lgnu/lists/Pair;
        //   148: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   151: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   154: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   157: aastore        
        //   158: dup            
        //   159: iconst_1       
        //   160: aload           abDatas
        //   162: astore          l
        //   164: aload           l
        //   166: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   169: aload           l
        //   171: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //   174: iconst_2       
        //   175: isub           
        //   176: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   179: invokestatic    com/ftsafe/CCIDScheme.slice:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   182: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //   185: astore          8
        //   187: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   190: astore          9
        //   192: aconst_null    
        //   193: astore          10
        //   195: aload           8
        //   197: invokeinterface java/util/Iterator.hasNext:()Z
        //   202: ifeq            255
        //   205: aload           8
        //   207: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   212: astore          11
        //   214: new             Lgnu/lists/Pair;
        //   217: dup            
        //   218: getstatic       com/ftsafe/CCIDScheme.Lit99:Lgnu/math/IntNum;
        //   221: aload           11
        //   223: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   226: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   229: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   232: aload           10
        //   234: ifnonnull       243
        //   237: dup            
        //   238: astore          9
        //   240: goto            250
        //   243: aload           10
        //   245: swap           
        //   246: dup_x1         
        //   247: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   250: astore          10
        //   252: goto            195
        //   255: aload           9
        //   257: aastore        
        //   258: dup            
        //   259: iconst_2       
        //   260: getstatic       com/ftsafe/CCIDScheme.Lit16:Lgnu/math/IntNum;
        //   263: aload           abDatas
        //   265: astore          l
        //   267: aload           l
        //   269: aload           l
        //   271: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //   274: iconst_1       
        //   275: isub           
        //   276: invokestatic    kawa/lib/lists.listRef:(Ljava/lang/Object;I)Ljava/lang/Object;
        //   279: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   282: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   285: aastore        
        //   286: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   289: astore          sData
        //   291: aload           sData
        //   293: astore          _sDatas
        //   295: aload           _sDatas
        //   297: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   300: ifeq            313
        //   303: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   306: ldc_w           "this should not happended!!!"
        //   309: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   312: pop            
        //   313: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   316: aload_0         /* usb_send */
        //   317: aload_2         /* slot */
        //   318: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   321: aload           _sDatas
        //   323: ldc             Lgnu/lists/Pair;.class
        //   325: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   328: dup            
        //   329: astore          9
        //   331: checkcast       Lgnu/lists/Pair;
        //   334: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   337: ldc             Lgnu/lists/Pair;.class
        //   339: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   342: dup            
        //   343: astore          9
        //   345: checkcast       Lgnu/lists/Pair;
        //   348: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   351: aload           _sDatas
        //   353: ldc             Lgnu/lists/Pair;.class
        //   355: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   358: dup            
        //   359: astore          9
        //   361: checkcast       Lgnu/lists/Pair;
        //   364: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   367: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   370: invokestatic    com/ftsafe/CCIDScheme.PC_to_RDR_XfrBlock:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   373: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   376: pop            
        //   377: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   380: aload_1         /* usb_recv */
        //   381: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   384: invokestatic    com/ftsafe/CCIDScheme.RDR_to_PC_DataBlock:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   387: astore          ret
        //   389: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   392: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   395: getstatic       com/ftsafe/CCIDScheme.Lit127:Lgnu/mapping/SimpleSymbol;
        //   398: aload           ret
        //   400: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   403: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   406: getstatic       com/ftsafe/CCIDScheme.Lit20:Lgnu/math/IntNum;
        //   409: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   412: getstatic       com/ftsafe/CCIDScheme.Lit20:Lgnu/math/IntNum;
        //   415: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   418: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   421: ifeq            427
        //   424: goto            377
        //   427: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   430: getstatic       com/ftsafe/CCIDScheme.Lit128:Lgnu/mapping/SimpleSymbol;
        //   433: aload           ret
        //   435: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   438: getstatic       com/ftsafe/CCIDScheme.Lit239:Lgnu/lists/PairWithPosition;
        //   441: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   444: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   447: ifeq            469
        //   450: aload           _sDatas
        //   452: ldc             Lgnu/lists/Pair;.class
        //   454: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   457: dup            
        //   458: astore          10
        //   460: checkcast       Lgnu/lists/Pair;
        //   463: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   466: goto            293
        //   469: aload           ret
        //   471: astore          _rData
        //   473: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   476: astore          rData
        //   478: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   481: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   484: getstatic       com/ftsafe/CCIDScheme.Lit127:Lgnu/mapping/SimpleSymbol;
        //   487: aload           _rData
        //   489: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   492: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   495: getstatic       com/ftsafe/CCIDScheme.Lit20:Lgnu/math/IntNum;
        //   498: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   501: getstatic       com/ftsafe/CCIDScheme.Lit20:Lgnu/math/IntNum;
        //   504: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   507: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   510: ifeq            528
        //   513: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   516: aload_1         /* usb_recv */
        //   517: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   520: invokestatic    com/ftsafe/CCIDScheme.RDR_to_PC_DataBlock:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   523: astore          _rData
        //   525: goto            478
        //   528: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   531: getstatic       com/ftsafe/CCIDScheme.Lit128:Lgnu/mapping/SimpleSymbol;
        //   534: aload           _rData
        //   536: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   539: getstatic       com/ftsafe/CCIDScheme.Lit240:Lgnu/lists/PairWithPosition;
        //   542: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   545: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   548: ifeq            567
        //   551: getstatic       com/ftsafe/CCIDScheme.Lit129:Lgnu/mapping/SimpleSymbol;
        //   554: aload           _rData
        //   556: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   559: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   562: astore          rData
        //   564: goto            780
        //   567: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   570: getstatic       com/ftsafe/CCIDScheme.Lit128:Lgnu/mapping/SimpleSymbol;
        //   573: aload           _rData
        //   575: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   578: getstatic       com/ftsafe/CCIDScheme.Lit241:Lgnu/lists/PairWithPosition;
        //   581: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   584: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   587: ifeq            639
        //   590: getstatic       com/ftsafe/CCIDScheme.Lit129:Lgnu/mapping/SimpleSymbol;
        //   593: aload           _rData
        //   595: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   598: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   601: astore          rData
        //   603: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   606: aload_0         /* usb_send */
        //   607: aload_2         /* slot */
        //   608: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   611: getstatic       com/ftsafe/CCIDScheme.Lit6:Lgnu/math/IntNum;
        //   614: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   617: invokestatic    com/ftsafe/CCIDScheme.PC_to_RDR_XfrBlock:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   620: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   623: pop            
        //   624: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   627: aload_1         /* usb_recv */
        //   628: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   631: invokestatic    com/ftsafe/CCIDScheme.RDR_to_PC_DataBlock:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   634: astore          _rData
        //   636: goto            478
        //   639: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   642: getstatic       com/ftsafe/CCIDScheme.Lit128:Lgnu/mapping/SimpleSymbol;
        //   645: aload           _rData
        //   647: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   650: getstatic       com/ftsafe/CCIDScheme.Lit242:Lgnu/lists/PairWithPosition;
        //   653: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   656: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   659: ifeq            693
        //   662: iconst_2       
        //   663: anewarray       Ljava/lang/Object;
        //   666: dup            
        //   667: iconst_0       
        //   668: aload           rData
        //   670: aastore        
        //   671: dup            
        //   672: iconst_1       
        //   673: getstatic       com/ftsafe/CCIDScheme.Lit129:Lgnu/mapping/SimpleSymbol;
        //   676: aload           _rData
        //   678: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   681: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   684: aastore        
        //   685: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   688: astore          rData
        //   690: goto            780
        //   693: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   696: getstatic       com/ftsafe/CCIDScheme.Lit128:Lgnu/mapping/SimpleSymbol;
        //   699: aload           _rData
        //   701: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   704: getstatic       com/ftsafe/CCIDScheme.Lit243:Lgnu/lists/PairWithPosition;
        //   707: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   710: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   713: ifeq            780
        //   716: iconst_2       
        //   717: anewarray       Ljava/lang/Object;
        //   720: dup            
        //   721: iconst_0       
        //   722: aload           rData
        //   724: aastore        
        //   725: dup            
        //   726: iconst_1       
        //   727: getstatic       com/ftsafe/CCIDScheme.Lit129:Lgnu/mapping/SimpleSymbol;
        //   730: aload           _rData
        //   732: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   735: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   738: aastore        
        //   739: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   742: astore          rData
        //   744: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   747: aload_0         /* usb_send */
        //   748: aload_2         /* slot */
        //   749: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   752: getstatic       com/ftsafe/CCIDScheme.Lit6:Lgnu/math/IntNum;
        //   755: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   758: invokestatic    com/ftsafe/CCIDScheme.PC_to_RDR_XfrBlock:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   761: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   764: pop            
        //   765: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   768: aload_1         /* usb_recv */
        //   769: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   772: invokestatic    com/ftsafe/CCIDScheme.RDR_to_PC_DataBlock:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   775: astore          _rData
        //   777: goto            478
        //   780: aload           rData
        //   782: areturn        
        //   783: new             Lgnu/mapping/WrongType;
        //   786: dup_x1         
        //   787: swap           
        //   788: ldc             "cdr"
        //   790: iconst_1       
        //   791: aload           5
        //   793: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   796: athrow         
        //   797: new             Lgnu/mapping/WrongType;
        //   800: dup_x1         
        //   801: swap           
        //   802: ldc             "cdr"
        //   804: iconst_1       
        //   805: aload           5
        //   807: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   810: athrow         
        //   811: new             Lgnu/mapping/WrongType;
        //   814: dup_x1         
        //   815: swap           
        //   816: ldc             "car"
        //   818: iconst_1       
        //   819: aload           8
        //   821: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   824: athrow         
        //   825: new             Lgnu/mapping/WrongType;
        //   828: dup_x1         
        //   829: swap           
        //   830: ldc             "car"
        //   832: iconst_1       
        //   833: aload           9
        //   835: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   838: athrow         
        //   839: new             Lgnu/mapping/WrongType;
        //   842: dup_x1         
        //   843: swap           
        //   844: ldc             "car"
        //   846: iconst_1       
        //   847: aload           9
        //   849: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   852: athrow         
        //   853: new             Lgnu/mapping/WrongType;
        //   856: dup_x1         
        //   857: swap           
        //   858: ldc             "car"
        //   860: iconst_1       
        //   861: aload           9
        //   863: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   866: athrow         
        //   867: new             Lgnu/mapping/WrongType;
        //   870: dup_x1         
        //   871: swap           
        //   872: ldc             "cdr"
        //   874: iconst_1       
        //   875: aload           10
        //   877: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   880: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  26     29     783    797    Ljava/lang/ClassCastException;
        //  43     46     797    811    Ljava/lang/ClassCastException;
        //  145    148    811    825    Ljava/lang/ClassCastException;
        //  331    334    825    839    Ljava/lang/ClassCastException;
        //  345    348    839    853    Ljava/lang/ClassCastException;
        //  361    364    853    867    Ljava/lang/ClassCastException;
        //  460    463    867    881    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 382 out of bounds for length 382
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
    
    static Object lambda36(final Object op) {
        return lambda36(op, com.ftsafe.CCIDScheme.Lit1);
    }
    
    static Object lambda36(final Object op, final Object arg1) {
        Object o;
        if (KawaConvert.isTrue(Scheme.isEqual.apply2(op, com.ftsafe.CCIDScheme.Lit244))) {
            com.ftsafe.CCIDScheme.ns = com.ftsafe.CCIDScheme.Lit1;
            o = Values.empty;
        }
        else if (KawaConvert.isTrue(Scheme.isEqual.apply2(op, com.ftsafe.CCIDScheme.Lit15))) {
            final Object ns_tmp = com.ftsafe.CCIDScheme.ns;
            com.ftsafe.CCIDScheme.ns = DivideOp.remainder.apply2(AddOp.apply2(1, com.ftsafe.CCIDScheme.ns, com.ftsafe.CCIDScheme.Lit2), com.ftsafe.CCIDScheme.Lit16);
            o = ns_tmp;
        }
        else if (KawaConvert.isTrue(Scheme.isEqual.apply2(op, com.ftsafe.CCIDScheme.Lit13))) {
            com.ftsafe.CCIDScheme.ns = arg1;
            o = Values.empty;
        }
        else {
            o = Values.empty;
        }
        return o;
    }
    
    static Object lambda37(final Object op) {
        return lambda37(op, com.ftsafe.CCIDScheme.Lit1);
    }
    
    static Object lambda37(final Object op, final Object arg1) {
        Object o;
        if (KawaConvert.isTrue(Scheme.isEqual.apply2(op, com.ftsafe.CCIDScheme.Lit244))) {
            com.ftsafe.CCIDScheme.nr = com.ftsafe.CCIDScheme.Lit1;
            o = Values.empty;
        }
        else if (KawaConvert.isTrue(Scheme.isEqual.apply2(op, com.ftsafe.CCIDScheme.Lit15))) {
            final Object nr_tmp = com.ftsafe.CCIDScheme.nr;
            com.ftsafe.CCIDScheme.nr = DivideOp.remainder.apply2(AddOp.apply2(1, com.ftsafe.CCIDScheme.nr, com.ftsafe.CCIDScheme.Lit2), com.ftsafe.CCIDScheme.Lit16);
            o = nr_tmp;
        }
        else if (KawaConvert.isTrue(Scheme.isEqual.apply2(op, com.ftsafe.CCIDScheme.Lit13))) {
            com.ftsafe.CCIDScheme.nr = arg1;
            o = Values.empty;
        }
        else {
            o = Values.empty;
        }
        return o;
    }
    
    public static Object IFSRequestTPDUT1(final Object usb_send, final Object usb_recv, final Object slot, final Object atr) {
        com.ftsafe.CCIDScheme.T1$MnTPDU$MnIblock$MnN_S.apply1(com.ftsafe.CCIDScheme.Lit244);
        com.ftsafe.CCIDScheme.T1$MnTPDU$MnRblock$MnN_R.apply1(com.ftsafe.CCIDScheme.Lit244);
        Scheme.applyToArgs.apply2(usb_send, PC_to_RDR_XfrBlock(slot, com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit1, generateSBlockTPDUT1(com.ftsafe.CCIDScheme.Lit193, LList.list1(getAtrIFSC(atr)))));
        final Pair ret = RDR_to_PC_DataBlock(Scheme.applyToArgs.apply1(usb_recv));
        final Object abData = lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit129, ret));
        Object t1Block;
        if (!lists.isNull(abData)) {
            t1Block = parseT1Block(abData, com.ftsafe.CCIDScheme.CCID$MnDEBUG.apply0());
        }
        else {
            final Object sd_ = generateRBlockTPDUT1(com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit16);
            Scheme.applyToArgs.apply2(usb_send, PC_to_RDR_XfrBlock(slot, com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit1, sd_));
            final Pair ret_ = RDR_to_PC_DataBlock(Scheme.applyToArgs.apply1(usb_recv));
            final Object abData_ = lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit129, ret_));
            t1Block = (lists.isNull(abData_) ? com.ftsafe.CCIDScheme.pp.apply1("error!!!!!! abData null!!!") : parseT1Block(abData_, com.ftsafe.CCIDScheme.CCID$MnDEBUG.apply0()));
        }
        return t1Block;
    }
    
    public static Object doXfrBlockTPDUT1Protocol(final Object usb_send, final Object usb_recv, final Object slot, final Object data, final Object atr) {
        public class CCIDScheme$frame14 extends ModuleBody
        {
            Object usb_recv;
            Object slot;
            Object usb_send;
            
            public Object lambda38loop2(final Object _rB_) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     3: getstatic       com/ftsafe/CCIDScheme.Lit204:Lgnu/mapping/SimpleSymbol;
                //     6: aload_1         /* _rB_ */
                //     7: ldc             Lgnu/lists/Pair;.class
                //     9: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    12: dup            
                //    13: astore_2       
                //    14: checkcast       Lgnu/lists/Pair;
                //    17: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    20: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    23: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    26: ifne            219
                //    29: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
                //    32: getstatic       com/ftsafe/CCIDScheme.Lit189:Lgnu/mapping/SimpleSymbol;
                //    35: aload_1         /* _rB_ */
                //    36: ldc             Lgnu/lists/Pair;.class
                //    38: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    41: dup            
                //    42: astore_2       
                //    43: checkcast       Lgnu/lists/Pair;
                //    46: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    49: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    52: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    55: ifeq            203
                //    58: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
                //    61: getstatic       com/ftsafe/CCIDScheme.Lit246:Lgnu/lists/PairWithPosition;
                //    64: aload_1         /* _rB_ */
                //    65: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //    68: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    71: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    74: ifeq            203
                //    77: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //    80: astore_2        /* _ret_ */
                //    81: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    84: aload_0         /* this */
                //    85: getfield        com/ftsafe/CCIDScheme$frame14.usb_send:Ljava/lang/Object;
                //    88: aload_0         /* this */
                //    89: getfield        com/ftsafe/CCIDScheme$frame14.slot:Ljava/lang/Object;
                //    92: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
                //    95: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
                //    98: getstatic       com/ftsafe/CCIDScheme.Lit198:Lgnu/mapping/SimpleSymbol;
                //   101: getstatic       com/ftsafe/CCIDScheme.Lit200:Lgnu/mapping/SimpleSymbol;
                //   104: aload_1         /* _rB_ */
                //   105: ldc             Lgnu/lists/Pair;.class
                //   107: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   110: dup            
                //   111: astore_3       
                //   112: checkcast       Lgnu/lists/Pair;
                //   115: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   118: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   121: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //   124: invokestatic    com/ftsafe/CCIDScheme.generateSBlockTPDUT1:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   127: invokestatic    com/ftsafe/CCIDScheme.PC_to_RDR_XfrBlock:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   130: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   133: pop            
                //   134: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   137: aload_0         /* this */
                //   138: getfield        com/ftsafe/CCIDScheme$frame14.usb_recv:Ljava/lang/Object;
                //   141: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   144: invokestatic    com/ftsafe/CCIDScheme.RDR_to_PC_DataBlock:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   147: astore_2        /* _ret_ */
                //   148: getstatic       com/ftsafe/CCIDScheme.Lit129:Lgnu/mapping/SimpleSymbol;
                //   151: aload_2         /* _ret_ */
                //   152: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   155: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //   158: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   161: ifeq            180
                //   164: iconst_1       
                //   165: anewarray       Ljava/lang/Object;
                //   168: dup            
                //   169: iconst_0       
                //   170: ldc             "this is error:2"
                //   172: aastore        
                //   173: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
                //   176: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
                //   179: athrow         
                //   180: getstatic       com/ftsafe/CCIDScheme.Lit129:Lgnu/mapping/SimpleSymbol;
                //   183: aload_2         /* _ret_ */
                //   184: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   187: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //   190: getstatic       com/ftsafe/CCIDScheme.CCID$MnDEBUG:Lgnu/mapping/Procedure;
                //   193: invokevirtual   gnu/mapping/Procedure.apply0:()Ljava/lang/Object;
                //   196: invokestatic    com/ftsafe/CCIDScheme.parseT1Block:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   199: astore_1        /* _rB_ */
                //   200: goto            0
                //   203: iconst_1       
                //   204: anewarray       Ljava/lang/Object;
                //   207: dup            
                //   208: iconst_0       
                //   209: ldc             "the result should be I-block"
                //   211: aastore        
                //   212: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
                //   215: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
                //   218: athrow         
                //   219: iconst_2       
                //   220: anewarray       Ljava/lang/Object;
                //   223: dup            
                //   224: iconst_0       
                //   225: getstatic       com/ftsafe/CCIDScheme.Lit200:Lgnu/mapping/SimpleSymbol;
                //   228: aload_1         /* _rB_ */
                //   229: ldc             Lgnu/lists/Pair;.class
                //   231: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   234: dup            
                //   235: astore_2       
                //   236: checkcast       Lgnu/lists/Pair;
                //   239: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   242: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   245: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //   248: aastore        
                //   249: dup            
                //   250: iconst_1       
                //   251: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
                //   254: getstatic       com/ftsafe/CCIDScheme.Lit247:Lgnu/lists/PairWithPosition;
                //   257: getstatic       com/ftsafe/CCIDScheme.Lit206:Lgnu/mapping/SimpleSymbol;
                //   260: aload_1         /* _rB_ */
                //   261: ldc             Lgnu/lists/Pair;.class
                //   263: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   266: dup            
                //   267: astore_2       
                //   268: checkcast       Lgnu/lists/Pair;
                //   271: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //   274: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   277: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   280: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //   283: ifeq            302
                //   286: getstatic       com/ftsafe/CCIDScheme.T1$MnTPDU$MnRblock$MnN_R:Lgnu/mapping/Procedure;
                //   289: getstatic       com/ftsafe/CCIDScheme.Lit15:Lgnu/mapping/SimpleSymbol;
                //   292: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   295: pop            
                //   296: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //   299: goto            414
                //   302: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //   305: astore_2        /* _ret_ */
                //   306: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   309: aload_0         /* this */
                //   310: getfield        com/ftsafe/CCIDScheme$frame14.usb_send:Ljava/lang/Object;
                //   313: aload_0         /* this */
                //   314: getfield        com/ftsafe/CCIDScheme$frame14.slot:Ljava/lang/Object;
                //   317: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
                //   320: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
                //   323: getstatic       com/ftsafe/CCIDScheme.T1$MnTPDU$MnRblock$MnN_R:Lgnu/mapping/Procedure;
                //   326: getstatic       com/ftsafe/CCIDScheme.Lit15:Lgnu/mapping/SimpleSymbol;
                //   329: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   332: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
                //   335: invokestatic    com/ftsafe/CCIDScheme.generateRBlockTPDUT1:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   338: invokestatic    com/ftsafe/CCIDScheme.PC_to_RDR_XfrBlock:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   341: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   344: pop            
                //   345: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //   348: aload_0         /* this */
                //   349: getfield        com/ftsafe/CCIDScheme$frame14.usb_recv:Ljava/lang/Object;
                //   352: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
                //   355: invokestatic    com/ftsafe/CCIDScheme.RDR_to_PC_DataBlock:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   358: astore_2        /* _ret_ */
                //   359: getstatic       com/ftsafe/CCIDScheme.Lit129:Lgnu/mapping/SimpleSymbol;
                //   362: aload_2         /* _ret_ */
                //   363: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   366: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //   369: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //   372: ifeq            391
                //   375: iconst_1       
                //   376: anewarray       Ljava/lang/Object;
                //   379: dup            
                //   380: iconst_0       
                //   381: ldc             "this is error:2"
                //   383: aastore        
                //   384: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
                //   387: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
                //   390: athrow         
                //   391: aload_0         /* this */
                //   392: getstatic       com/ftsafe/CCIDScheme.Lit129:Lgnu/mapping/SimpleSymbol;
                //   395: aload_2         /* _ret_ */
                //   396: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   399: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
                //   402: getstatic       com/ftsafe/CCIDScheme.CCID$MnDEBUG:Lgnu/mapping/Procedure;
                //   405: invokevirtual   gnu/mapping/Procedure.apply0:()Ljava/lang/Object;
                //   408: invokestatic    com/ftsafe/CCIDScheme.parseT1Block:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   411: invokevirtual   com/ftsafe/CCIDScheme$frame14.lambda38loop2:(Ljava/lang/Object;)Ljava/lang/Object;
                //   414: aastore        
                //   415: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //   418: areturn        
                //   419: new             Lgnu/mapping/WrongType;
                //   422: dup_x1         
                //   423: swap           
                //   424: ldc             "car"
                //   426: iconst_1       
                //   427: aload_2        
                //   428: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   431: athrow         
                //   432: new             Lgnu/mapping/WrongType;
                //   435: dup_x1         
                //   436: swap           
                //   437: ldc             "car"
                //   439: iconst_1       
                //   440: aload_2        
                //   441: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   444: athrow         
                //   445: new             Lgnu/mapping/WrongType;
                //   448: dup_x1         
                //   449: swap           
                //   450: ldc             "cdr"
                //   452: iconst_1       
                //   453: aload_3        
                //   454: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   457: athrow         
                //   458: new             Lgnu/mapping/WrongType;
                //   461: dup_x1         
                //   462: swap           
                //   463: ldc             "cdr"
                //   465: iconst_1       
                //   466: aload_2        
                //   467: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   470: athrow         
                //   471: new             Lgnu/mapping/WrongType;
                //   474: dup_x1         
                //   475: swap           
                //   476: ldc             "cdr"
                //   478: iconst_1       
                //   479: aload_2        
                //   480: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   483: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  14     17     419    432    Ljava/lang/ClassCastException;
                //  43     46     432    445    Ljava/lang/ClassCastException;
                //  112    115    445    458    Ljava/lang/ClassCastException;
                //  236    239    458    471    Ljava/lang/ClassCastException;
                //  268    271    471    484    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 221 out of bounds for length 221
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
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   com/ftsafe/CCIDScheme$frame14.<init>:()V
        //     7: astore          $heapFrame
        //     9: aload           $heapFrame
        //    11: aload_0         /* usb_send */
        //    12: putfield        com/ftsafe/CCIDScheme$frame14.usb_send:Ljava/lang/Object;
        //    15: aload           $heapFrame
        //    17: aload_1         /* usb_recv */
        //    18: putfield        com/ftsafe/CCIDScheme$frame14.usb_recv:Ljava/lang/Object;
        //    21: aload           $heapFrame
        //    23: aload_2         /* slot */
        //    24: putfield        com/ftsafe/CCIDScheme$frame14.slot:Ljava/lang/Object;
        //    27: aload_3         /* data */
        //    28: aload           atr
        //    30: invokestatic    com/ftsafe/CCIDScheme.getAtrIFSC:(Ljava/lang/Object;)Ljava/lang/Object;
        //    33: invokestatic    com/ftsafe/CCIDScheme.groupList:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    36: astore          sds
        //    38: aload           sds
        //    40: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    43: ifne            375
        //    46: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    49: astore          ret
        //    51: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    54: aload           $heapFrame
        //    56: getfield        com/ftsafe/CCIDScheme$frame14.usb_send:Ljava/lang/Object;
        //    59: aload           $heapFrame
        //    61: getfield        com/ftsafe/CCIDScheme$frame14.slot:Ljava/lang/Object;
        //    64: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //    67: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //    70: getstatic       com/ftsafe/CCIDScheme.T1$MnTPDU$MnIblock$MnN_S:Lgnu/mapping/Procedure;
        //    73: getstatic       com/ftsafe/CCIDScheme.Lit15:Lgnu/mapping/SimpleSymbol;
        //    76: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    79: aload           sds
        //    81: ldc             Lgnu/lists/Pair;.class
        //    83: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    86: dup            
        //    87: astore          8
        //    89: checkcast       Lgnu/lists/Pair;
        //    92: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    95: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    98: ifeq            107
        //   101: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   104: goto            110
        //   107: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   110: aload           sds
        //   112: ldc             Lgnu/lists/Pair;.class
        //   114: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   117: dup            
        //   118: astore          8
        //   120: checkcast       Lgnu/lists/Pair;
        //   123: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   126: invokestatic    com/ftsafe/CCIDScheme.generateIBlockTPDUT1:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   129: invokestatic    com/ftsafe/CCIDScheme.PC_to_RDR_XfrBlock:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   132: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   135: pop            
        //   136: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   139: aload           $heapFrame
        //   141: getfield        com/ftsafe/CCIDScheme$frame14.usb_recv:Ljava/lang/Object;
        //   144: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   147: invokestatic    com/ftsafe/CCIDScheme.RDR_to_PC_DataBlock:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   150: astore          ret
        //   152: getstatic       com/ftsafe/CCIDScheme.Lit129:Lgnu/mapping/SimpleSymbol;
        //   155: aload           ret
        //   157: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   160: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   163: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   166: ifeq            186
        //   169: iconst_1       
        //   170: anewarray       Ljava/lang/Object;
        //   173: dup            
        //   174: iconst_0       
        //   175: ldc_w           "this is error"
        //   178: aastore        
        //   179: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   182: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   185: athrow         
        //   186: getstatic       com/ftsafe/CCIDScheme.Lit129:Lgnu/mapping/SimpleSymbol;
        //   189: aload           ret
        //   191: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   194: invokestatic    kawa/lib/lists.cadr:(Ljava/lang/Object;)Ljava/lang/Object;
        //   197: getstatic       com/ftsafe/CCIDScheme.CCID$MnDEBUG:Lgnu/mapping/Procedure;
        //   200: invokevirtual   gnu/mapping/Procedure.apply0:()Ljava/lang/Object;
        //   203: invokestatic    com/ftsafe/CCIDScheme.parseT1Block:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   206: astore          retBlock
        //   208: aload           sds
        //   210: ldc             Lgnu/lists/Pair;.class
        //   212: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   215: dup            
        //   216: astore          9
        //   218: checkcast       Lgnu/lists/Pair;
        //   221: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   224: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   227: ifeq            240
        //   230: aload           $heapFrame
        //   232: aload           retBlock
        //   234: invokevirtual   com/ftsafe/CCIDScheme$frame14.lambda38loop2:(Ljava/lang/Object;)Ljava/lang/Object;
        //   237: goto            378
        //   240: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   243: getstatic       com/ftsafe/CCIDScheme.Lit201:Lgnu/mapping/SimpleSymbol;
        //   246: aload           retBlock
        //   248: ldc             Lgnu/lists/Pair;.class
        //   250: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   253: dup            
        //   254: astore          9
        //   256: checkcast       Lgnu/lists/Pair;
        //   259: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   262: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   265: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   268: ifne            288
        //   271: iconst_1       
        //   272: anewarray       Ljava/lang/Object;
        //   275: dup            
        //   276: iconst_0       
        //   277: ldc_w           "this should not happened because send-data not send completely"
        //   280: aastore        
        //   281: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   284: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   287: athrow         
        //   288: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   291: getstatic       com/ftsafe/CCIDScheme.Lit245:Lgnu/lists/PairWithPosition;
        //   294: getstatic       com/ftsafe/CCIDScheme.Lit203:Lgnu/mapping/SimpleSymbol;
        //   297: aload           retBlock
        //   299: ldc             Lgnu/lists/Pair;.class
        //   301: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   304: dup            
        //   305: astore          9
        //   307: checkcast       Lgnu/lists/Pair;
        //   310: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   313: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   316: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   319: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   322: ifne            356
        //   325: aload           retBlock
        //   327: dup            
        //   328: instanceof      [Ljava/lang/Object;
        //   331: ifeq            340
        //   334: checkcast       [Ljava/lang/Object;
        //   337: goto            349
        //   340: iconst_1       
        //   341: anewarray       Ljava/lang/Object;
        //   344: dup_x1         
        //   345: swap           
        //   346: iconst_0       
        //   347: swap           
        //   348: aastore        
        //   349: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   352: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   355: athrow         
        //   356: aload           sds
        //   358: ldc             Lgnu/lists/Pair;.class
        //   360: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   363: dup            
        //   364: astore          9
        //   366: checkcast       Lgnu/lists/Pair;
        //   369: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   372: goto            36
        //   375: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   378: areturn        
        //   379: new             Lgnu/mapping/WrongType;
        //   382: dup_x1         
        //   383: swap           
        //   384: ldc             "cdr"
        //   386: iconst_1       
        //   387: aload           8
        //   389: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   392: athrow         
        //   393: new             Lgnu/mapping/WrongType;
        //   396: dup_x1         
        //   397: swap           
        //   398: ldc             "car"
        //   400: iconst_1       
        //   401: aload           8
        //   403: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   406: athrow         
        //   407: new             Lgnu/mapping/WrongType;
        //   410: dup_x1         
        //   411: swap           
        //   412: ldc             "cdr"
        //   414: iconst_1       
        //   415: aload           9
        //   417: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   420: athrow         
        //   421: new             Lgnu/mapping/WrongType;
        //   424: dup_x1         
        //   425: swap           
        //   426: ldc             "car"
        //   428: iconst_1       
        //   429: aload           9
        //   431: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   434: athrow         
        //   435: new             Lgnu/mapping/WrongType;
        //   438: dup_x1         
        //   439: swap           
        //   440: ldc             "cdr"
        //   442: iconst_1       
        //   443: aload           9
        //   445: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   448: athrow         
        //   449: new             Lgnu/mapping/WrongType;
        //   452: dup_x1         
        //   453: swap           
        //   454: ldc             "cdr"
        //   456: iconst_1       
        //   457: aload           9
        //   459: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   462: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  89     92     379    393    Ljava/lang/ClassCastException;
        //  120    123    393    407    Ljava/lang/ClassCastException;
        //  218    221    407    421    Ljava/lang/ClassCastException;
        //  256    259    421    435    Ljava/lang/ClassCastException;
        //  307    310    435    449    Ljava/lang/ClassCastException;
        //  366    369    449    463    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 207 out of bounds for length 207
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
    
    static Object lambda39() {
        return lambda39(com.ftsafe.CCIDScheme.Lit15);
    }
    
    static Object lambda39(final Object arg1) {
        Serializable empty;
        if (KawaConvert.isTrue(Scheme.isEqual.apply2(arg1, com.ftsafe.CCIDScheme.Lit15))) {
            empty = (com.ftsafe.CCIDScheme._debug_ ? Boolean.TRUE : Boolean.FALSE);
        }
        else if (KawaConvert.isTrue(Scheme.isEqual.apply2(arg1, com.ftsafe.CCIDScheme.Lit248))) {
            com.ftsafe.CCIDScheme._debug_ = true;
            empty = (com.ftsafe.CCIDScheme._debug_ ? Boolean.TRUE : Boolean.FALSE);
        }
        else if (KawaConvert.isTrue(Scheme.isEqual.apply2(arg1, com.ftsafe.CCIDScheme.Lit249))) {
            com.ftsafe.CCIDScheme._debug_ = false;
            empty = (com.ftsafe.CCIDScheme._debug_ ? Boolean.TRUE : Boolean.FALSE);
        }
        else {
            empty = Values.empty;
        }
        return empty;
    }
    
    public static Procedure doInitDescriptorInf(final Object usb_control_in) {
        com.ftsafe.CCIDScheme.descriptor$Mninfo = append.append$V(new Object[] { parseDescriptor(getDeviceDescriptor(usb_control_in)), parseDescriptor(getConfigurationDescriptor(usb_control_in)) });
        return makeGET_DEVICE_INFFunc(usb_control_in, com.ftsafe.CCIDScheme.descriptor$Mninfo);
    }
    
    public static void doPowerOff(final Object usb_send_recv) {
        doPowerOff(usb_send_recv, com.ftsafe.CCIDScheme.Lit1);
    }
    
    public static void doPowerOff(final Object usb_send_recv, final Object slot) {
        final Pair ret = RDR_to_PC_SlotStatus(Scheme.applyToArgs.apply2(usb_send_recv, PC_to_RDR_IccPowerOff(slot)));
        if (!KawaConvert.isTrue(Scheme.isEqual.apply2(lists.assoc(com.ftsafe.CCIDScheme.Lit126, ret), LList.list2(com.ftsafe.CCIDScheme.Lit126, slot)))) {
            exceptions.error("bSlot not equal");
            throw Special.reachedUnexpected;
        }
    }
    
    public static Pair doPowerOn(final Object usb_send, final Object usb_recv) {
        return doPowerOn(usb_send, usb_recv, com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit1);
    }
    
    public static Pair doPowerOn(final Object usb_send, final Object usb_recv, final Object index) {
        return doPowerOn(usb_send, usb_recv, index, com.ftsafe.CCIDScheme.Lit1);
    }
    
    public static Pair doPowerOn(final Object usb_send, final Object usb_recv, final Object index, final Object slot) {
        public class CCIDScheme$frame15 extends ModuleBody
        {
            Object atr;
            boolean _isFirstTime_;
            Object index;
            Object usb_recv;
            Object usb_send;
            final ModuleMethod usb_send_recv$Fn24;
            final ModuleMethod lambda$Fn25;
            final ModuleMethod lambda$Fn26;
            final ModuleMethod lambda$Fn27;
            final ModuleMethod lambda$Fn28;
            
            public CCIDScheme$frame15() {
                final ModuleMethod usb_send_recv$Fn24 = new ModuleMethod(this, 10, "usb_send_recv", 4097);
                usb_send_recv$Fn24.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:418");
                this.usb_send_recv$Fn24 = usb_send_recv$Fn24;
                final ModuleMethod lambda$Fn25 = new ModuleMethod(this, 11, null, 8193);
                lambda$Fn25.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:452");
                this.lambda$Fn25 = lambda$Fn25;
                final ModuleMethod lambda$Fn26 = new ModuleMethod(this, 13, null, 8193);
                lambda$Fn26.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:455");
                this.lambda$Fn26 = lambda$Fn26;
                final ModuleMethod lambda$Fn27 = new ModuleMethod(this, 15, null, 8193);
                lambda$Fn27.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:458");
                this.lambda$Fn27 = lambda$Fn27;
                final ModuleMethod lambda$Fn28 = new ModuleMethod(this, 17, null, 8193);
                lambda$Fn28.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:461");
                this.lambda$Fn28 = lambda$Fn28;
            }
            
            public Object lambda40usb_send_recv(final Object data) {
                Scheme.applyToArgs.apply2(this.usb_send, data);
                return Scheme.applyToArgs.apply1(this.usb_recv);
            }
            
            public static Object lambda41doPowerOnInside(final Object usb_send_recv, final Object slot) {
                final Pair ret = com.ftsafe.CCIDScheme.RDR_to_PC_DataBlock(Scheme.applyToArgs.apply2(usb_send_recv, com.ftsafe.CCIDScheme.PC_to_RDR_IccPowerOn(slot, com.ftsafe.CCIDScheme.getVoltageSupportFromDescriptor(com.ftsafe.CCIDScheme.descriptor$Mninfo))));
                if (!KawaConvert.isTrue(Scheme.isEqual.apply2(lists.assoc(com.ftsafe.CCIDScheme.Lit126, ret), LList.list2(com.ftsafe.CCIDScheme.Lit126, slot)))) {
                    exceptions.error("bSlot not equal");
                    throw Special.reachedUnexpected;
                }
                return lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit129, ret));
            }
            
            Object lambda42(final Object data) {
                return this.lambda42(data, com.ftsafe.CCIDScheme.Lit1);
            }
            
            Object lambda42(final Object data, final Object slot) {
                com.ftsafe.CCIDScheme.current_dev_interface.apply2(com.ftsafe.CCIDScheme.Lit13, this.index);
                return com.ftsafe.CCIDScheme.doXfrBlockAPDUExtendedProtocol(this.usb_send, this.usb_recv, slot, data);
            }
            
            Object lambda43(final Object data) {
                return this.lambda43(data, com.ftsafe.CCIDScheme.Lit1);
            }
            
            Object lambda43(final Object data, final Object slot) {
                return com.ftsafe.CCIDScheme.doXfrBlockTPDUT0Protocol(this.usb_send, this.usb_recv, slot, data);
            }
            
            Object lambda44(final Object data) {
                return this.lambda44(data, com.ftsafe.CCIDScheme.Lit1);
            }
            
            Object lambda44(final Object data, final Object slot) {
                return com.ftsafe.CCIDScheme.doXfrBlockTPDUT0Protocol(this.usb_send, this.usb_recv, slot, data);
            }
            
            Object lambda45(final Object data) {
                return this.lambda45(data, com.ftsafe.CCIDScheme.Lit1);
            }
            
            Object lambda45(final Object data, final Object slot) {
                if (this._isFirstTime_) {
                    this._isFirstTime_ = false;
                    com.ftsafe.CCIDScheme.pp.apply1("is first time");
                    com.ftsafe.CCIDScheme.IFSRequestTPDUT1(this.usb_send, this.usb_recv, slot, this.atr);
                }
                return com.ftsafe.CCIDScheme.doXfrBlockTPDUT1Protocol(this.usb_send, this.usb_recv, slot, data, this.atr);
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                switch (moduleMethod.selector) {
                    case 17: {
                        ctx.value1 = o;
                        ctx.proc = moduleMethod;
                        ctx.pc = 1;
                        return 0;
                    }
                    case 15: {
                        ctx.value1 = o;
                        ctx.proc = moduleMethod;
                        ctx.pc = 1;
                        return 0;
                    }
                    case 13: {
                        ctx.value1 = o;
                        ctx.proc = moduleMethod;
                        ctx.pc = 1;
                        return 0;
                    }
                    case 11: {
                        ctx.value1 = o;
                        ctx.proc = moduleMethod;
                        ctx.pc = 1;
                        return 0;
                    }
                    case 10: {
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
            public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
                switch (proc.selector) {
                    case 17: {
                        ctx.value1 = arg1;
                        ctx.value2 = arg2;
                        ctx.proc = proc;
                        ctx.pc = 2;
                        return 0;
                    }
                    case 15: {
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
                    case 11: {
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
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object o) {
                switch (method.selector) {
                    case 10: {
                        return this.lambda40usb_send_recv(o);
                    }
                    case 11: {
                        return this.lambda42(o);
                    }
                    case 13: {
                        return this.lambda43(o);
                    }
                    case 15: {
                        return this.lambda44(o);
                    }
                    case 17: {
                        return this.lambda45(o);
                    }
                    default: {
                        return super.apply1(method, o);
                    }
                }
            }
            
            @Override
            public Object apply2(final ModuleMethod method, final Object arg1, final Object arg2) {
                switch (method.selector) {
                    case 11: {
                        return this.lambda42(arg1, arg2);
                    }
                    case 13: {
                        return this.lambda43(arg1, arg2);
                    }
                    case 15: {
                        return this.lambda44(arg1, arg2);
                    }
                    case 17: {
                        return this.lambda45(arg1, arg2);
                    }
                    default: {
                        return super.apply2(method, arg1, arg2);
                    }
                }
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   com/ftsafe/CCIDScheme$frame15.<init>:()V
        //     7: astore          $heapFrame
        //     9: aload           $heapFrame
        //    11: aload_0         /* usb_send */
        //    12: putfield        com/ftsafe/CCIDScheme$frame15.usb_send:Ljava/lang/Object;
        //    15: aload           $heapFrame
        //    17: aload_1         /* usb_recv */
        //    18: putfield        com/ftsafe/CCIDScheme$frame15.usb_recv:Ljava/lang/Object;
        //    21: aload           $heapFrame
        //    23: aload_2         /* index */
        //    24: putfield        com/ftsafe/CCIDScheme$frame15.index:Ljava/lang/Object;
        //    27: getstatic       com/ftsafe/CCIDScheme.current_dev_interface:Lgnu/mapping/Procedure;
        //    30: getstatic       com/ftsafe/CCIDScheme.Lit13:Lgnu/mapping/SimpleSymbol;
        //    33: aload           $heapFrame
        //    35: getfield        com/ftsafe/CCIDScheme$frame15.index:Ljava/lang/Object;
        //    38: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    41: pop            
        //    42: aload           $heapFrame
        //    44: getfield        com/ftsafe/CCIDScheme$frame15.usb_send_recv$Fn24:Lgnu/expr/ModuleMethod;
        //    47: astore          usb_send_recv
        //    49: aload           $heapFrame
        //    51: getfield        com/ftsafe/CCIDScheme$frame15.usb_send_recv$Fn24:Lgnu/expr/ModuleMethod;
        //    54: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //    57: invokestatic    com/ftsafe/CCIDScheme$frame15.lambda41doPowerOnInside:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    60: astore          atr_data
        //    62: aload           atr_data
        //    64: invokestatic    com/ftsafe/CCIDScheme.parseATR:(Ljava/lang/Object;)Ljava/lang/Object;
        //    67: aload           $heapFrame
        //    69: swap           
        //    70: putfield        com/ftsafe/CCIDScheme$frame15.atr:Ljava/lang/Object;
        //    73: iconst_1       
        //    74: aload           $heapFrame
        //    76: swap           
        //    77: putfield        com/ftsafe/CCIDScheme$frame15._isFirstTime_:Z
        //    80: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //    83: iconst_2       
        //    84: anewarray       Ljava/lang/Object;
        //    87: dup            
        //    88: iconst_0       
        //    89: ldc_w           "ATR: "
        //    92: aastore        
        //    93: dup            
        //    94: iconst_1       
        //    95: aload           atr_data
        //    97: ldc_w           " "
        //   100: invokestatic    com/ftsafe/CCIDScheme.u8list$To$String:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: aastore        
        //   104: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   107: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   110: pop            
        //   111: aload           $heapFrame
        //   113: getfield        com/ftsafe/CCIDScheme$frame15.atr:Ljava/lang/Object;
        //   116: invokestatic    com/ftsafe/CCIDScheme.getCardTimeout:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   119: putstatic       com/ftsafe/CCIDScheme.USB_TIMEOUT:Ljava/lang/Object;
        //   122: aload           $heapFrame
        //   124: getfield        com/ftsafe/CCIDScheme$frame15.usb_send_recv$Fn24:Lgnu/expr/ModuleMethod;
        //   127: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   130: aload           $heapFrame
        //   132: getfield        com/ftsafe/CCIDScheme$frame15.atr:Ljava/lang/Object;
        //   135: invokestatic    com/ftsafe/CCIDScheme.doPPS:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   138: pop            
        //   139: goto            292
        //   142: astore          e
        //   144: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   147: ldc_w           "try default pps"
        //   150: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   153: pop            
        //   154: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   157: ldc_w           "power off"
        //   160: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   163: pop            
        //   164: aload           $heapFrame
        //   166: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   169: invokestatic    com/ftsafe/CCIDScheme.PC_to_RDR_IccPowerOff:(Ljava/lang/Object;)Ljava/lang/Object;
        //   172: invokevirtual   com/ftsafe/CCIDScheme$frame15.lambda40usb_send_recv:(Ljava/lang/Object;)Ljava/lang/Object;
        //   175: invokestatic    com/ftsafe/CCIDScheme.RDR_to_PC_SlotStatus:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   178: astore          ret
        //   180: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   183: getstatic       com/ftsafe/CCIDScheme.Lit126:Lgnu/mapping/SimpleSymbol;
        //   186: aload           ret
        //   188: invokestatic    kawa/lib/lists.assoc:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   191: getstatic       com/ftsafe/CCIDScheme.Lit126:Lgnu/mapping/SimpleSymbol;
        //   194: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   197: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   200: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   203: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   206: ifne            226
        //   209: iconst_1       
        //   210: anewarray       Ljava/lang/Object;
        //   213: dup            
        //   214: iconst_0       
        //   215: ldc_w           "bSlot not equal"
        //   218: aastore        
        //   219: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   222: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   225: athrow         
        //   226: getstatic       com/ftsafe/CCIDScheme.pp:Lgnu/mapping/Procedure;
        //   229: ldc_w           "power on"
        //   232: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   235: pop            
        //   236: aload           $heapFrame
        //   238: getfield        com/ftsafe/CCIDScheme$frame15.usb_send_recv$Fn24:Lgnu/expr/ModuleMethod;
        //   241: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   244: invokestatic    com/ftsafe/CCIDScheme$frame15.lambda41doPowerOnInside:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   247: astore          atr_data
        //   249: aload           $heapFrame
        //   251: aload           atr_data
        //   253: invokestatic    com/ftsafe/CCIDScheme.parseATR:(Ljava/lang/Object;)Ljava/lang/Object;
        //   256: putfield        com/ftsafe/CCIDScheme$frame15.atr:Ljava/lang/Object;
        //   259: aload           $heapFrame
        //   261: getfield        com/ftsafe/CCIDScheme$frame15.usb_send_recv$Fn24:Lgnu/expr/ModuleMethod;
        //   264: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   267: iconst_2       
        //   268: anewarray       Ljava/lang/Object;
        //   271: dup            
        //   272: iconst_0       
        //   273: aload           $heapFrame
        //   275: getfield        com/ftsafe/CCIDScheme$frame15.atr:Ljava/lang/Object;
        //   278: aastore        
        //   279: dup            
        //   280: iconst_1       
        //   281: getstatic       com/ftsafe/CCIDScheme.Lit250:Lgnu/lists/PairWithPosition;
        //   284: aastore        
        //   285: invokestatic    kawa/standard/append.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //   288: invokestatic    com/ftsafe/CCIDScheme.doPPS:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   291: pop            
        //   292: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   295: aload           $heapFrame
        //   297: getfield        com/ftsafe/CCIDScheme$frame15.atr:Ljava/lang/Object;
        //   300: invokestatic    com/ftsafe/CCIDScheme.getAtrSupportProtocol:(Ljava/lang/Object;)Ljava/lang/Object;
        //   303: getstatic       com/ftsafe/CCIDScheme.Lit147:Lgnu/mapping/SimpleSymbol;
        //   306: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   309: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   312: ifeq            321
        //   315: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   318: goto            396
        //   321: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   324: aload           $heapFrame
        //   326: getfield        com/ftsafe/CCIDScheme$frame15.atr:Ljava/lang/Object;
        //   329: invokestatic    com/ftsafe/CCIDScheme.getAtrSupportProtocol:(Ljava/lang/Object;)Ljava/lang/Object;
        //   332: getstatic       com/ftsafe/CCIDScheme.Lit160:Lgnu/mapping/SimpleSymbol;
        //   335: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   338: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   341: ifeq            350
        //   344: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   347: goto            396
        //   350: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   353: aload           $heapFrame
        //   355: getfield        com/ftsafe/CCIDScheme$frame15.atr:Ljava/lang/Object;
        //   358: invokestatic    com/ftsafe/CCIDScheme.getAtrSupportProtocol:(Ljava/lang/Object;)Ljava/lang/Object;
        //   361: getstatic       com/ftsafe/CCIDScheme.Lit159:Lgnu/mapping/SimpleSymbol;
        //   364: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   367: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   370: ifeq            379
        //   373: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   376: goto            396
        //   379: iconst_1       
        //   380: anewarray       Ljava/lang/Object;
        //   383: dup            
        //   384: iconst_0       
        //   385: ldc_w           "do-PowerOn error 1 should not happend"
        //   388: aastore        
        //   389: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   392: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   395: athrow         
        //   396: astore          7
        //   398: getstatic       com/ftsafe/CCIDScheme.descriptor$Mninfo:Ljava/lang/Object;
        //   401: invokestatic    com/ftsafe/CCIDScheme.getCcidExchangeLevel:(Ljava/lang/Object;)Lgnu/mapping/SimpleSymbol;
        //   404: astore          protocol_r
        //   406: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   409: aload           protocol_r
        //   411: getstatic       com/ftsafe/CCIDScheme.Lit237:Lgnu/mapping/SimpleSymbol;
        //   414: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   417: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   420: ifeq            431
        //   423: aload           $heapFrame
        //   425: getfield        com/ftsafe/CCIDScheme$frame15.lambda$Fn25:Lgnu/expr/ModuleMethod;
        //   428: goto            557
        //   431: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   434: aload           protocol_r
        //   436: getstatic       com/ftsafe/CCIDScheme.Lit235:Lgnu/mapping/SimpleSymbol;
        //   439: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   442: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   445: ifeq            456
        //   448: aload           $heapFrame
        //   450: getfield        com/ftsafe/CCIDScheme$frame15.lambda$Fn26:Lgnu/expr/ModuleMethod;
        //   453: goto            557
        //   456: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   459: aload           protocol_r
        //   461: getstatic       com/ftsafe/CCIDScheme.Lit233:Lgnu/mapping/SimpleSymbol;
        //   464: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   467: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   470: ifeq            498
        //   473: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   476: aload           protocol_c
        //   478: getstatic       com/ftsafe/CCIDScheme.Lit1:Lgnu/math/IntNum;
        //   481: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   484: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   487: ifeq            498
        //   490: aload           $heapFrame
        //   492: getfield        com/ftsafe/CCIDScheme$frame15.lambda$Fn27:Lgnu/expr/ModuleMethod;
        //   495: goto            557
        //   498: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   501: aload           protocol_r
        //   503: getstatic       com/ftsafe/CCIDScheme.Lit233:Lgnu/mapping/SimpleSymbol;
        //   506: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   509: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   512: ifeq            540
        //   515: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //   518: aload           protocol_c
        //   520: getstatic       com/ftsafe/CCIDScheme.Lit2:Lgnu/math/IntNum;
        //   523: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   526: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   529: ifeq            540
        //   532: aload           $heapFrame
        //   534: getfield        com/ftsafe/CCIDScheme$frame15.lambda$Fn28:Lgnu/expr/ModuleMethod;
        //   537: goto            557
        //   540: iconst_1       
        //   541: anewarray       Ljava/lang/Object;
        //   544: dup            
        //   545: iconst_0       
        //   546: ldc_w           "do-PowerOn error 2 should not happend"
        //   549: aastore        
        //   550: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //   553: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //   556: athrow         
        //   557: astore          xfrBlock
        //   559: getstatic       com/ftsafe/CCIDScheme.Lit251:Lgnu/mapping/SimpleSymbol;
        //   562: aload           atr_data
        //   564: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   567: getstatic       com/ftsafe/CCIDScheme.Lit252:Lgnu/mapping/SimpleSymbol;
        //   570: aload           xfrBlock
        //   572: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   575: invokestatic    gnu/lists/LList.list2:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   578: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  122    142    142    292    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object doEscape(final Object usb_send_recv, final Object data) {
        return doEscape(usb_send_recv, data, com.ftsafe.CCIDScheme.Lit1);
    }
    
    public static Object doEscape(final Object usb_send_recv, final Object data, final Object slot) {
        final Pair ret = RDR_to_PC_Escape(Scheme.applyToArgs.apply2(usb_send_recv, PC_to_RDR_Escape(slot, data)));
        if (!KawaConvert.isTrue(Scheme.isEqual.apply2(lists.assoc(com.ftsafe.CCIDScheme.Lit126, ret), LList.list2(com.ftsafe.CCIDScheme.Lit126, slot)))) {
            exceptions.error("bSlot not equal");
            throw Special.reachedUnexpected;
        }
        return lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit129, ret));
    }
    
    public static Object doSlotStatus(final Object usb_send_recv) {
        return doSlotStatus(usb_send_recv, com.ftsafe.CCIDScheme.Lit1);
    }
    
    public static Object doSlotStatus(final Object usb_send_recv, final Object slot) {
        final Pair ret = RDR_to_PC_SlotStatus(Scheme.applyToArgs.apply2(usb_send_recv, PC_to_RDR_GetSlotStatus(slot)));
        if (!KawaConvert.isTrue(Scheme.isEqual.apply2(lists.assoc(com.ftsafe.CCIDScheme.Lit126, ret), LList.list2(com.ftsafe.CCIDScheme.Lit126, slot)))) {
            exceptions.error("bSlot not equal");
            throw Special.reachedUnexpected;
        }
        return BitwiseOp.and.apply2(lists.cadr(lists.assoc(com.ftsafe.CCIDScheme.Lit127, ret)), com.ftsafe.CCIDScheme.Lit99);
    }
    
    public static void threadSleep$Ex(final Object t) {
        final Object force = Promise.force(MultiplyOp.$St.apply2(t, com.ftsafe.CCIDScheme.Lit166));
        try {
            java.lang.Thread.sleep(((Number)force).longValue());
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "java.lang.Thread.sleep(long)", 1, force);
        }
    }
    
    public static CCIDScheme$0 makeThread(final Object func) {
        public class CCIDScheme$frame16 extends ModuleBody
        {
            Object func;
        }
        final CCIDScheme$frame16 $heapFrame = new CCIDScheme$frame16();
        $heapFrame.func = func;
        public class CCIDScheme$0 extends Thread
        {
            CCIDScheme$frame16 this$0;
            
            @Override
            public void run() {
                Scheme.applyToArgs.apply1(this.this$0.func);
            }
            
            public CCIDScheme$0(final CCIDScheme$frame16 this$0) {
                this.this$0 = this$0;
            }
        }
        return new CCIDScheme$0($heapFrame);
    }
    
    public static void threadStart$Ex(final Object thread) {
        ((Thread)Promise.force(thread, Thread.class)).start();
    }
    
    public static Type.NeverReturns GET_DEVICES_INF_default$V(final Object[] argsArray) {
        exceptions.error("GET_DEVICES_INF not define");
        throw Special.reachedUnexpected;
    }
    
    static Type.NeverReturns lambda46$V(final Object[] argsArray) {
        exceptions.error("USB_CONTROL_IN not define");
        throw Special.reachedUnexpected;
    }
    
    static Type.NeverReturns lambda47$V(final Object[] argsArray) {
        exceptions.error("USB_SEND not define");
        throw Special.reachedUnexpected;
    }
    
    static Type.NeverReturns lambda48$V(final Object[] argsArray) {
        exceptions.error("USB_RECV not define");
        throw Special.reachedUnexpected;
    }
    
    static Type.NeverReturns lambda49$V(final Object[] argsArray) {
        exceptions.error("USB_SEND_RECV not define");
        throw Special.reachedUnexpected;
    }
    
    static Type.NeverReturns lambda50$V(final Object[] argsArray) {
        exceptions.error("USB_INTERRUPT_RECV not define");
        throw Special.reachedUnexpected;
    }
    
    static LList lambda51(final CCIDScheme$frame17 $closureEnv, final Object requestType, final Object request, final Object value, final Object index, final Object length) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       gnu/kawa/lispexpr/LangObjType.listType:Lgnu/kawa/lispexpr/LangObjType;
        //     6: aload_0         /* $closureEnv */
        //     7: getfield        com/ftsafe/CCIDScheme$frame17.$this$:Lcom/ftsafe/CCIDScheme;
        //    10: getfield        com/ftsafe/CCIDScheme.mFTReaderInf:Lcom/ftsafe/readerScheme/FTReaderInf;
        //    13: aload_1         /* requestType */
        //    14: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    17: dup            
        //    18: astore          7
        //    20: checkcast       Ljava/lang/Number;
        //    23: invokevirtual   java/lang/Number.intValue:()I
        //    26: aload_2         /* request */
        //    27: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    30: dup            
        //    31: astore          7
        //    33: checkcast       Ljava/lang/Number;
        //    36: invokevirtual   java/lang/Number.intValue:()I
        //    39: aload_3         /* value */
        //    40: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    43: dup            
        //    44: astore          7
        //    46: checkcast       Ljava/lang/Number;
        //    49: invokevirtual   java/lang/Number.intValue:()I
        //    52: aload           index
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    57: dup            
        //    58: astore          7
        //    60: checkcast       Ljava/lang/Number;
        //    63: invokevirtual   java/lang/Number.intValue:()I
        //    66: aload           length
        //    68: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    71: dup            
        //    72: astore          7
        //    74: checkcast       Ljava/lang/Number;
        //    77: invokevirtual   java/lang/Number.intValue:()I
        //    80: sipush          2000
        //    83: invokeinterface com/ftsafe/readerScheme/FTReaderInf.ft_control:(IIIIII)[B
        //    88: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    91: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    94: astore          6
        //    96: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    99: astore          7
        //   101: aconst_null    
        //   102: astore          8
        //   104: aload           6
        //   106: invokeinterface java/util/Iterator.hasNext:()Z
        //   111: ifeq            167
        //   114: aload           6
        //   116: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   121: astore          9
        //   123: new             Lgnu/lists/Pair;
        //   126: dup            
        //   127: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //   130: aload           9
        //   132: getstatic       com/ftsafe/CCIDScheme.Lit9:Lgnu/math/IntNum;
        //   135: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   138: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   141: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   144: aload           8
        //   146: ifnonnull       155
        //   149: dup            
        //   150: astore          7
        //   152: goto            162
        //   155: aload           8
        //   157: swap           
        //   158: dup_x1         
        //   159: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   162: astore          8
        //   164: goto            104
        //   167: aload           7
        //   169: areturn        
        //   170: new             Lgnu/mapping/WrongType;
        //   173: dup_x1         
        //   174: swap           
        //   175: ldc_w           "com.ftsafe.readerScheme.FTReaderInf.ft_control(int,int,int,int,int,int)"
        //   178: iconst_2       
        //   179: aload           7
        //   181: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   184: athrow         
        //   185: new             Lgnu/mapping/WrongType;
        //   188: dup_x1         
        //   189: swap           
        //   190: ldc_w           "com.ftsafe.readerScheme.FTReaderInf.ft_control(int,int,int,int,int,int)"
        //   193: iconst_3       
        //   194: aload           7
        //   196: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   199: athrow         
        //   200: new             Lgnu/mapping/WrongType;
        //   203: dup_x1         
        //   204: swap           
        //   205: ldc_w           "com.ftsafe.readerScheme.FTReaderInf.ft_control(int,int,int,int,int,int)"
        //   208: iconst_4       
        //   209: aload           7
        //   211: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   214: athrow         
        //   215: new             Lgnu/mapping/WrongType;
        //   218: dup_x1         
        //   219: swap           
        //   220: ldc_w           "com.ftsafe.readerScheme.FTReaderInf.ft_control(int,int,int,int,int,int)"
        //   223: iconst_5       
        //   224: aload           7
        //   226: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   229: athrow         
        //   230: new             Lgnu/mapping/WrongType;
        //   233: dup_x1         
        //   234: swap           
        //   235: ldc_w           "com.ftsafe.readerScheme.FTReaderInf.ft_control(int,int,int,int,int,int)"
        //   238: bipush          6
        //   240: aload           7
        //   242: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   245: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  20     26     170    185    Ljava/lang/ClassCastException;
        //  33     39     185    200    Ljava/lang/ClassCastException;
        //  46     52     200    215    Ljava/lang/ClassCastException;
        //  60     66     215    230    Ljava/lang/ClassCastException;
        //  74     80     230    246    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 111 out of bounds for length 111
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
    
    static void lambda52(final CCIDScheme$frame17 $closureEnv, final Object index, final Object data) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/ftsafe/CCIDScheme$frame17.$this$:Lcom/ftsafe/CCIDScheme;
        //     4: getfield        com/ftsafe/CCIDScheme.mFTReaderInf:Lcom/ftsafe/readerScheme/FTReaderInf;
        //     7: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    10: getstatic       com/ftsafe/CCIDScheme.GET_DEVICES_INF:Ljava/lang/Object;
        //    13: getstatic       com/ftsafe/CCIDScheme.Lit221:Lgnu/mapping/SimpleSymbol;
        //    16: aload_1         /* index */
        //    17: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    23: dup            
        //    24: astore_3       
        //    25: checkcast       Ljava/lang/Number;
        //    28: invokevirtual   java/lang/Number.intValue:()I
        //    31: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //    34: getstatic       com/ftsafe/CCIDScheme.Lit0:Lgnu/bytecode/ArrayType;
        //    37: aload_2         /* data */
        //    38: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    41: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    44: dup            
        //    45: astore_3       
        //    46: checkcast       [B
        //    49: getstatic       com/ftsafe/CCIDScheme.USB_TIMEOUT:Ljava/lang/Object;
        //    52: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    55: dup            
        //    56: astore_3       
        //    57: checkcast       Ljava/lang/Number;
        //    60: invokevirtual   java/lang/Number.intValue:()I
        //    63: invokeinterface com/ftsafe/readerScheme/FTReaderInf.ft_send:(I[BI)V
        //    68: return         
        //    69: new             Lgnu/mapping/WrongType;
        //    72: dup_x1         
        //    73: swap           
        //    74: ldc_w           "com.ftsafe.readerScheme.FTReaderInf.ft_send(int,byte[],int)"
        //    77: iconst_2       
        //    78: aload_3        
        //    79: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    82: athrow         
        //    83: new             Lgnu/mapping/WrongType;
        //    86: dup_x1         
        //    87: swap           
        //    88: ldc_w           "com.ftsafe.readerScheme.FTReaderInf.ft_send(int,byte[],int)"
        //    91: iconst_3       
        //    92: aload_3        
        //    93: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    96: athrow         
        //    97: new             Lgnu/mapping/WrongType;
        //   100: dup_x1         
        //   101: swap           
        //   102: ldc_w           "com.ftsafe.readerScheme.FTReaderInf.ft_send(int,byte[],int)"
        //   105: iconst_4       
        //   106: aload_3        
        //   107: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   110: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  25     31     69     83     Ljava/lang/ClassCastException;
        //  46     49     83     97     Ljava/lang/ClassCastException;
        //  57     63     97     111    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 53 out of bounds for length 53
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
    
    static LList lambda53(final CCIDScheme$frame17 $closureEnv, final Object index) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       gnu/kawa/lispexpr/LangObjType.listType:Lgnu/kawa/lispexpr/LangObjType;
        //     6: aload_0         /* $closureEnv */
        //     7: getfield        com/ftsafe/CCIDScheme$frame17.$this$:Lcom/ftsafe/CCIDScheme;
        //    10: getfield        com/ftsafe/CCIDScheme.mFTReaderInf:Lcom/ftsafe/readerScheme/FTReaderInf;
        //    13: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    16: getstatic       com/ftsafe/CCIDScheme.GET_DEVICES_INF:Ljava/lang/Object;
        //    19: getstatic       com/ftsafe/CCIDScheme.Lit223:Lgnu/mapping/SimpleSymbol;
        //    22: aload_1         /* index */
        //    23: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    26: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    29: dup            
        //    30: astore_3       
        //    31: checkcast       Ljava/lang/Number;
        //    34: invokevirtual   java/lang/Number.intValue:()I
        //    37: getstatic       com/ftsafe/CCIDScheme.USB_TIMEOUT:Ljava/lang/Object;
        //    40: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    43: dup            
        //    44: astore_3       
        //    45: checkcast       Ljava/lang/Number;
        //    48: invokevirtual   java/lang/Number.intValue:()I
        //    51: invokeinterface com/ftsafe/readerScheme/FTReaderInf.ft_recv:(II)[B
        //    56: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    59: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    62: astore_2       
        //    63: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    66: astore_3       
        //    67: aconst_null    
        //    68: astore          4
        //    70: aload_2        
        //    71: invokeinterface java/util/Iterator.hasNext:()Z
        //    76: ifeq            130
        //    79: aload_2        
        //    80: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    85: astore          5
        //    87: new             Lgnu/lists/Pair;
        //    90: dup            
        //    91: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //    94: aload           5
        //    96: getstatic       com/ftsafe/CCIDScheme.Lit9:Lgnu/math/IntNum;
        //    99: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   102: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   105: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   108: aload           4
        //   110: ifnonnull       118
        //   113: dup            
        //   114: astore_3       
        //   115: goto            125
        //   118: aload           4
        //   120: swap           
        //   121: dup_x1         
        //   122: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   125: astore          4
        //   127: goto            70
        //   130: aload_3        
        //   131: areturn        
        //   132: new             Lgnu/mapping/WrongType;
        //   135: dup_x1         
        //   136: swap           
        //   137: ldc_w           "com.ftsafe.readerScheme.FTReaderInf.ft_recv(int,int)"
        //   140: iconst_2       
        //   141: aload_3        
        //   142: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   145: athrow         
        //   146: new             Lgnu/mapping/WrongType;
        //   149: dup_x1         
        //   150: swap           
        //   151: ldc_w           "com.ftsafe.readerScheme.FTReaderInf.ft_recv(int,int)"
        //   154: iconst_3       
        //   155: aload_3        
        //   156: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   159: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  31     37     132    146    Ljava/lang/ClassCastException;
        //  45     51     146    160    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0070:
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
    
    static Object lambda54(final Object index, final Object data) {
        com.ftsafe.CCIDScheme.USB_SEND.apply2(index, data);
        return com.ftsafe.CCIDScheme.USB_RECV.apply1(index);
    }
    
    static LList lambda55(final CCIDScheme$frame17 $closureEnv, final Object index) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: getstatic       gnu/kawa/lispexpr/LangObjType.listType:Lgnu/kawa/lispexpr/LangObjType;
        //     6: aload_0         /* $closureEnv */
        //     7: getfield        com/ftsafe/CCIDScheme$frame17.$this$:Lcom/ftsafe/CCIDScheme;
        //    10: getfield        com/ftsafe/CCIDScheme.mFTReaderInf:Lcom/ftsafe/readerScheme/FTReaderInf;
        //    13: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    16: getstatic       com/ftsafe/CCIDScheme.GET_DEVICES_INF:Ljava/lang/Object;
        //    19: getstatic       com/ftsafe/CCIDScheme.Lit226:Lgnu/mapping/SimpleSymbol;
        //    22: aload_1         /* index */
        //    23: invokevirtual   gnu/mapping/Procedure.apply3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    26: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    29: dup            
        //    30: astore_3       
        //    31: checkcast       Ljava/lang/Number;
        //    34: invokevirtual   java/lang/Number.intValue:()I
        //    37: getstatic       com/ftsafe/CCIDScheme.USB_TIMEOUT:Ljava/lang/Object;
        //    40: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    43: dup            
        //    44: astore_3       
        //    45: checkcast       Ljava/lang/Number;
        //    48: invokevirtual   java/lang/Number.intValue:()I
        //    51: invokeinterface com/ftsafe/readerScheme/FTReaderInf.ft_recv:(II)[B
        //    56: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    59: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    62: astore_2       
        //    63: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    66: astore_3       
        //    67: aconst_null    
        //    68: astore          4
        //    70: aload_2        
        //    71: invokeinterface java/util/Iterator.hasNext:()Z
        //    76: ifeq            130
        //    79: aload_2        
        //    80: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    85: astore          5
        //    87: new             Lgnu/lists/Pair;
        //    90: dup            
        //    91: getstatic       gnu/kawa/functions/BitwiseOp.and:Lgnu/kawa/functions/BitwiseOp;
        //    94: aload           5
        //    96: getstatic       com/ftsafe/CCIDScheme.Lit9:Lgnu/math/IntNum;
        //    99: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   102: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   105: invokespecial   gnu/lists/Pair.<init>:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   108: aload           4
        //   110: ifnonnull       118
        //   113: dup            
        //   114: astore_3       
        //   115: goto            125
        //   118: aload           4
        //   120: swap           
        //   121: dup_x1         
        //   122: invokevirtual   gnu/lists/Pair.setCdr:(Ljava/lang/Object;)V
        //   125: astore          4
        //   127: goto            70
        //   130: aload_3        
        //   131: areturn        
        //   132: new             Lgnu/mapping/WrongType;
        //   135: dup_x1         
        //   136: swap           
        //   137: ldc_w           "com.ftsafe.readerScheme.FTReaderInf.ft_recv(int,int)"
        //   140: iconst_2       
        //   141: aload_3        
        //   142: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   145: athrow         
        //   146: new             Lgnu/mapping/WrongType;
        //   149: dup_x1         
        //   150: swap           
        //   151: ldc_w           "com.ftsafe.readerScheme.FTReaderInf.ft_recv(int,int)"
        //   154: iconst_3       
        //   155: aload_3        
        //   156: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   159: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  31     37     132    146    Ljava/lang/ClassCastException;
        //  45     51     146    160    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0070:
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
    
    static Object lambda56(final CCIDScheme$frame17 $closureEnv, final Object obj) {
        return $closureEnv.$this$.showLog(object$To$String(obj));
    }
    
    static Object lambda57(final CCIDScheme$frame19 $closureEnv) {
        do {
            try {
                final Object apply1 = com.ftsafe.CCIDScheme.USB_INTERRUPT_RECV.apply1($closureEnv.index);
                if (KawaConvert.isTrue(Scheme.isEqual.apply2(apply1, com.ftsafe.CCIDScheme.Lit253))) {
                    final Handler mHandler = $closureEnv.staticLink.$this$.mHandler;
                    final Handler mHandler2 = $closureEnv.staticLink.$this$.mHandler;
                    final Object force = Promise.force(AddOp.apply2(1, DK.CARD_IN_MASK, $closureEnv.index));
                    int intValue;
                    try {
                        intValue = ((Number)force).intValue();
                    }
                    catch (ClassCastException ex) {
                        throw new WrongType(ex, "android.os.Handler.obtainMessage(int,java.lang.Object)", 2, force);
                    }
                    mHandler.sendMessage(mHandler2.obtainMessage(intValue, (Object)""));
                }
                else if (KawaConvert.isTrue(Scheme.isEqual.apply2(apply1, com.ftsafe.CCIDScheme.Lit254))) {
                    final Handler mHandler3 = $closureEnv.staticLink.$this$.mHandler;
                    final Handler mHandler4 = $closureEnv.staticLink.$this$.mHandler;
                    final Object force2 = Promise.force(AddOp.apply2(1, DK.CARD_OUT_MASK, $closureEnv.index));
                    int intValue2;
                    try {
                        intValue2 = ((Number)force2).intValue();
                    }
                    catch (ClassCastException ex2) {
                        throw new WrongType(ex2, "android.os.Handler.obtainMessage(int,java.lang.Object)", 2, force2);
                    }
                    mHandler3.sendMessage(mHandler4.obtainMessage(intValue2, (Object)""));
                }
                else {
                    com.ftsafe.CCIDScheme.pp.apply1(strings.stringAppend("interrupt read loop error : this should not happend", object$To$String(apply1)));
                }
            }
            catch (Exception ex4) {}
            threadSleep$Ex(com.ftsafe.CCIDScheme.Lit2);
        } while (KawaConvert.isTrue($closureEnv.staticLink.$this$.mFTReaderInf.isFtExist()));
        final Procedure pp = com.ftsafe.CCIDScheme.pp;
        final Object[] args = { "slot", null, null };
        final int n = 1;
        final Object force3 = Promise.force($closureEnv.index, Number.class);
        try {
            args[n] = numbers.number$To$String((Number)force3);
            args[2] = ":interrupt_read loop exit";
            return pp.apply1(strings.stringAppend(args));
        }
        catch (ClassCastException ex3) {
            throw new WrongType(ex3, "number->string", 1, force3);
        }
    }
    
    public static Object lambda58loop(final IntNum i) {
        return NumberCompare.$Ls(i, Scheme.applyToArgs.apply2(com.ftsafe.CCIDScheme.GET_DEVICES_INF, com.ftsafe.CCIDScheme.Lit228)) ? lists.cons(i, lambda58loop(IntNum.add(i, 1))) : LList.Empty;
    }
    
    static Object lambda59(final CCIDScheme$frame20 $closureEnv, final Object data) {
        return com.ftsafe.CCIDScheme.USB_SEND.apply2($closureEnv.index, data);
    }
    
    static Object lambda60(final CCIDScheme$frame20 $closureEnv) {
        return com.ftsafe.CCIDScheme.USB_RECV.apply1($closureEnv.index);
    }
    
    static Object lambda61(final CCIDScheme$frame21 $closureEnv, final Object data) {
        return com.ftsafe.CCIDScheme.USB_SEND_RECV.apply2($closureEnv.index, data);
    }
    
    static Object lambda62(final CCIDScheme$frame22 $closureEnv, final Object data) {
        return com.ftsafe.CCIDScheme.USB_SEND_RECV.apply2($closureEnv.index, data);
    }
    
    static Object lambda63(final CCIDScheme$frame23 $closureEnv, final Object data) {
        return com.ftsafe.CCIDScheme.USB_SEND_RECV.apply2($closureEnv.index, data);
    }
    
    static {
        Lit278 = PairWithPosition.make(Lit7 = IntNum.valueOf(8), Lit268 = PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("quote"), PairWithPosition.make(Symbol.valueOf("RFU"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274498), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274498), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274497), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278549);
        Lit277 = PairWithPosition.make(Lit105 = IntNum.valueOf(7), com.ftsafe.CCIDScheme.Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274489);
        Lit276 = PairWithPosition.make(Lit167 = IntNum.valueOf(372), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253979);
        Lit275 = PairWithPosition.make(PairWithPosition.make(Lit117 = IntNum.valueOf(14), com.ftsafe.CCIDScheme.Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282669), PairWithPosition.make(PairWithPosition.make(Lit118 = IntNum.valueOf(15), com.ftsafe.CCIDScheme.Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282683), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282683), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282669);
        Lit274 = PairWithPosition.make(Lit115 = IntNum.valueOf(12), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274461);
        Lit273 = PairWithPosition.make(Lit58 = IntNum.valueOf(5), Lit267 = PairWithPosition.make(Lit6 = IntNum.valueOf(16), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 942140), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274465);
        Lit272 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit7, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270398);
        Lit271 = PairWithPosition.make(Lit18 = IntNum.valueOf(4), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270365);
        Lit270 = PairWithPosition.make(IntNum.valueOf(20), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274485);
        Lit269 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit58, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270376);
        Lit266 = PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466963);
        Lit265 = PairWithPosition.make(Lit2 = IntNum.valueOf(1), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 999470);
        Lit264 = PairWithPosition.make(Lit16 = IntNum.valueOf(2), LList.Empty, "ccid_7816/CCIDScheme.scm", 430130);
        Lit263 = PairWithPosition.make(Lit99 = IntNum.valueOf(3), LList.Empty, "ccid_7816/CCIDScheme.scm", 421938);
        Lit262 = PairWithPosition.make(Lit1 = IntNum.valueOf(0), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1380404);
        Lit261 = IntNum.valueOf(80);
        Lit260 = Symbol.valueOf("Thread");
        Lit259 = new SyntaxTemplate("\u0001\u0003", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\u0011\u0018,\u0011\u00184\b\r\u000b", new Object[] { Symbol.valueOf("as"), com.ftsafe.CCIDScheme.Lit260, Symbol.valueOf("object"), PairWithPosition.make(com.ftsafe.CCIDScheme.Lit260, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm", 40986), PairWithPosition.make(Symbol.valueOf("run"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm", 40996), Symbol.valueOf("::"), Symbol.valueOf("void") }, 1);
        Lit258 = new SyntaxPattern("\f\u0007\r\u000f\b\b\b", new Object[0], 2, "Thread.scm:9");
        Lit257 = Symbol.valueOf("simple-thread");
        Lit256 = Symbol.valueOf("filter");
        Lit255 = ArrayType.make(Type.tostring_type);
        Lit254 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit261, com.ftsafe.CCIDScheme.Lit264, "ccid_7816/CCIDScheme.scm", 430124);
        Lit253 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit261, com.ftsafe.CCIDScheme.Lit263, "ccid_7816/CCIDScheme.scm", 421932);
        Lit252 = Symbol.valueOf("xfrBlock");
        Lit251 = Symbol.valueOf("atr");
        Lit250 = PairWithPosition.make(PairWithPosition.make(Lit170 = Symbol.valueOf("optionals"), PairWithPosition.make(PairWithPosition.make("USE-DEFAULT-PPS-EXCHANGE", PairWithPosition.make(Boolean.TRUE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802314), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802286), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802286), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802275), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1802274);
        Lit249 = Symbol.valueOf("off");
        Lit248 = Symbol.valueOf("on");
        Lit247 = PairWithPosition.make(Lit206 = Symbol.valueOf("M-bit"), com.ftsafe.CCIDScheme.Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1380397);
        Lit246 = PairWithPosition.make(Lit190 = Symbol.valueOf("type"), PairWithPosition.make(Lit197 = Symbol.valueOf("WTX_requset"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1331248), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1331242);
        Lit245 = PairWithPosition.make(Lit203 = Symbol.valueOf("ERRCode"), com.ftsafe.CCIDScheme.Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1441831);
        Lit244 = Symbol.valueOf("reset");
        Lit243 = PairWithPosition.make(Lit128 = Symbol.valueOf("bChainParameter"), com.ftsafe.CCIDScheme.Lit263, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1048605);
        Lit242 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit128, com.ftsafe.CCIDScheme.Lit264, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 1028125);
        Lit241 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit128, com.ftsafe.CCIDScheme.Lit265, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 999453);
        Lit240 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit128, com.ftsafe.CCIDScheme.Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 983069);
        Lit239 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit128, com.ftsafe.CCIDScheme.Lit267, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 942123);
        Lit238 = Symbol.valueOf("Character");
        Lit237 = Symbol.valueOf("E-APDU");
        Lit236 = IntNum.valueOf(262144);
        Lit235 = Symbol.valueOf("S-APDU");
        Lit234 = IntNum.valueOf(131072);
        Lit233 = Symbol.valueOf("TPDU");
        Lit232 = IntNum.valueOf(65536);
        Lit231 = IntNum.valueOf(458752);
        Lit230 = IntNum.valueOf(186);
        Lit229 = IntNum.valueOf(56);
        Lit228 = Symbol.valueOf("length");
        Lit227 = Symbol.valueOf("getall");
        Lit226 = Symbol.valueOf("interrupt_in");
        Lit225 = Symbol.valueOf("endpoint-interrupt-in");
        Lit224 = Symbol.valueOf("endpoint-bulk-in");
        Lit223 = Symbol.valueOf("in");
        Lit222 = Symbol.valueOf("endpoint-bulk-out");
        Lit221 = Symbol.valueOf("out");
        Lit220 = PairWithPosition.make(Lit92 = Symbol.valueOf("bInterfaceCount"), com.ftsafe.CCIDScheme.Lit265, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 266320);
        Lit219 = PairWithPosition.make(Lit96 = Symbol.valueOf("iFunction"), com.ftsafe.CCIDScheme.Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm", 213066);
        Lit218 = Symbol.valueOf("name");
        Lit217 = Symbol.valueOf("IAD");
        Lit216 = Symbol.valueOf("device");
        Lit215 = Symbol.valueOf("configure");
        Lit214 = IntNum.valueOf(227);
        Lit213 = IntNum.valueOf(195);
        Lit212 = Symbol.valueOf("WTX_request");
        Lit211 = IntNum.valueOf(226);
        Lit210 = IntNum.valueOf(194);
        Lit209 = Symbol.valueOf("ABORT_request");
        Lit208 = IntNum.valueOf(225);
        Lit207 = IntNum.valueOf(193);
        Lit205 = Symbol.valueOf("N(S)");
        Lit204 = Symbol.valueOf("I-block");
        Lit202 = Symbol.valueOf("N(R)");
        Lit201 = Symbol.valueOf("R-block");
        Lit200 = Symbol.valueOf("data");
        Lit199 = Symbol.valueOf("reserved_for_future_use");
        Lit198 = Symbol.valueOf("WTX_response");
        Lit196 = Symbol.valueOf("ABORT_response");
        Lit195 = Symbol.valueOf("ABORT_requset");
        Lit194 = Symbol.valueOf("IFS_response");
        Lit193 = Symbol.valueOf("IFS_request");
        Lit192 = Symbol.valueOf("RESYNCH_response");
        Lit191 = Symbol.valueOf("RESYNCH_request");
        Lit189 = Symbol.valueOf("S-block");
        Lit188 = IntNum.valueOf(64);
        Lit187 = IntNum.valueOf(35);
        Lit186 = IntNum.valueOf(34);
        Lit185 = IntNum.valueOf(63);
        Lit184 = IntNum.valueOf(-2);
        Lit183 = IntNum.valueOf(28);
        Lit182 = IntNum.valueOf(-5);
        Lit181 = IntNum.valueOf(2000);
        Lit180 = IntNum.valueOf(261);
        Lit179 = IntNum.valueOf(960);
        Lit178 = DFloNum.valueOf(1.0);
        Lit177 = IntNum.valueOf(260);
        Lit176 = IntNum.valueOf(60000);
        Lit175 = IntNum.valueOf(240);
        Lit174 = IntNum.valueOf(77);
        Lit173 = IntNum.valueOf(59);
        Lit172 = IntNum.valueOf(32);
        Lit171 = IntNum.valueOf(17);
        Lit169 = IntNum.valueOf(151);
        Lit168 = Symbol.valueOf("interface2");
        Lit166 = IntNum.valueOf(1000);
        Lit165 = Symbol.valueOf("interface1");
        Lit164 = Symbol.valueOf("TB15");
        Lit163 = Symbol.valueOf("TA15");
        Lit162 = IntNum.valueOf(9);
        Lit161 = PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit163, com.ftsafe.CCIDScheme.Lit266, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466957), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit164, com.ftsafe.CCIDScheme.Lit266, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466966), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466966), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 466956);
        Lit160 = Symbol.valueOf("T1");
        Lit159 = Symbol.valueOf("T0_T1");
        Lit158 = Symbol.valueOf("interface");
        Lit157 = PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit271, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270357), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit2, com.ftsafe.CCIDScheme.Lit269, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270368), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit16, PairWithPosition.make(Lit21 = IntNum.valueOf(6), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270387), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270379), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit99, com.ftsafe.CCIDScheme.Lit272, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270390), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit18, com.ftsafe.CCIDScheme.Lit274, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274453), PairWithPosition.make(com.ftsafe.CCIDScheme.Lit273, PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit21, com.ftsafe.CCIDScheme.Lit270, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274477), PairWithPosition.make(com.ftsafe.CCIDScheme.Lit277, PairWithPosition.make(com.ftsafe.CCIDScheme.Lit278, PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit162, com.ftsafe.CCIDScheme.Lit269, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278563), PairWithPosition.make(PairWithPosition.make(Lit114 = IntNum.valueOf(10), PairWithPosition.make(DFloNum.valueOf(7.5), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278582), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278574), PairWithPosition.make(PairWithPosition.make(Lit90 = IntNum.valueOf(11), PairWithPosition.make(com.ftsafe.CCIDScheme.Lit114, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278595), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278587), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit115, PairWithPosition.make(com.ftsafe.CCIDScheme.Lit118, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282653), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282645), PairWithPosition.make(PairWithPosition.make(Lit116 = IntNum.valueOf(13), com.ftsafe.CCIDScheme.Lit270, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282657), com.ftsafe.CCIDScheme.Lit275, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282657), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 282645), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278587), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278574), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278563), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 278549), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274489), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274477), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274465), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 274453), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270390), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270379), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270368), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 270356);
        Lit156 = Symbol.valueOf("fmax");
        Lit155 = PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit1, PairWithPosition.make(Symbol.valueOf("\u2018RFU"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286747), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286739), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit2, com.ftsafe.CCIDScheme.Lit265, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286753), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit16, com.ftsafe.CCIDScheme.Lit264, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286764), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit99, com.ftsafe.CCIDScheme.Lit271, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286775), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit18, com.ftsafe.CCIDScheme.Lit272, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290835), PairWithPosition.make(com.ftsafe.CCIDScheme.Lit273, PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit21, PairWithPosition.make(com.ftsafe.CCIDScheme.Lit172, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290866), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290858), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit105, PairWithPosition.make(com.ftsafe.CCIDScheme.Lit188, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290878), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290870), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit7, com.ftsafe.CCIDScheme.Lit274, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294931), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit162, com.ftsafe.CCIDScheme.Lit270, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294943), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit114, com.ftsafe.CCIDScheme.Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294955), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit90, com.ftsafe.CCIDScheme.Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294969), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit115, com.ftsafe.CCIDScheme.Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 299027), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit116, com.ftsafe.CCIDScheme.Lit268, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 299041), com.ftsafe.CCIDScheme.Lit275, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 299041), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 299027), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294969), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294955), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294943), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 294931), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290870), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290858), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290846), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 290835), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286775), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286764), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286753), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 286738);
        Lit154 = Symbol.valueOf("Di");
        Lit153 = PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit276, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253971), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit2, com.ftsafe.CCIDScheme.Lit276, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253985), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit16, PairWithPosition.make(IntNum.valueOf(558), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 254007), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253999), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit99, PairWithPosition.make(IntNum.valueOf(774), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 254021), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 254013), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit18, PairWithPosition.make(IntNum.valueOf(1116), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258075), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258067), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit58, PairWithPosition.make(IntNum.valueOf(1488), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258089), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258081), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit21, PairWithPosition.make(IntNum.valueOf(1860), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258103), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258095), PairWithPosition.make(com.ftsafe.CCIDScheme.Lit277, PairWithPosition.make(com.ftsafe.CCIDScheme.Lit278, PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit162, PairWithPosition.make(Lit22 = IntNum.valueOf(512), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262185), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262177), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit114, PairWithPosition.make(Lit23 = IntNum.valueOf(768), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262199), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262191), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit90, PairWithPosition.make(IntNum.valueOf(1024), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262213), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262205), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit115, PairWithPosition.make(IntNum.valueOf(1536), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266267), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266259), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit116, PairWithPosition.make(IntNum.valueOf(2048), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266281), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266273), com.ftsafe.CCIDScheme.Lit275, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266273), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 266259), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262205), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262191), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262177), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 262163), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258109), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258095), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258081), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 258067), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 254013), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253999), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253985), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 253970);
        Lit152 = Symbol.valueOf("Fi");
        Lit151 = IntNum.valueOf(-4);
        Lit150 = PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit152, com.ftsafe.CCIDScheme.Lit276, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311307), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit154, com.ftsafe.CCIDScheme.Lit265, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311316), PairWithPosition.make(PairWithPosition.make(com.ftsafe.CCIDScheme.Lit156, com.ftsafe.CCIDScheme.Lit269, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311323), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311323), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311316), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm", 311306);
        Lit149 = Symbol.valueOf("null");
        Lit148 = Symbol.valueOf("TCK");
        Lit147 = Symbol.valueOf("T0");
        Lit146 = Symbol.valueOf("TS");
        Lit145 = Symbol.valueOf("historical");
        Lit144 = Symbol.valueOf("TD");
        Lit143 = Symbol.valueOf("TC");
        Lit142 = Symbol.valueOf("TB");
        Lit141 = Symbol.valueOf("TA");
        Lit140 = IntNum.valueOf(101);
        Lit139 = Symbol.valueOf("bRFU");
        Lit138 = IntNum.valueOf(107);
        Lit137 = Symbol.valueOf("abProtocolDataStructure");
        Lit136 = Symbol.valueOf("bProtocolNum");
        Lit135 = IntNum.valueOf(130);
        Lit134 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm", 1908755);
        Lit133 = IntNum.valueOf(97);
        Lit132 = Symbol.valueOf("bClockStatus");
        Lit131 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit1, com.ftsafe.CCIDScheme.Lit134, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm", 1757203);
        Lit130 = IntNum.valueOf(99);
        Lit129 = Symbol.valueOf("abData");
        Lit127 = Symbol.valueOf("bStatus");
        Lit126 = Symbol.valueOf("bSlot");
        Lit125 = Symbol.valueOf("dwLength");
        Lit124 = Symbol.valueOf("bMessagetype");
        Lit123 = Symbol.valueOf("last");
        Lit122 = IntNum.valueOf(111);
        Lit121 = IntNum.valueOf(98);
        Lit120 = IntNum.valueOf(127);
        Lit119 = IntNum.valueOf(129);
        Lit113 = IntNum.valueOf(252);
        Lit112 = IntNum.valueOf(242);
        Lit111 = IntNum.valueOf(224);
        Lit110 = IntNum.valueOf(245);
        Lit109 = IntNum.valueOf(246);
        Lit108 = IntNum.valueOf(247);
        Lit107 = IntNum.valueOf(248);
        Lit106 = IntNum.valueOf(253);
        Lit104 = IntNum.valueOf(251);
        Lit103 = IntNum.valueOf(254);
        Lit102 = IntNum.valueOf(-6);
        Lit101 = IntNum.valueOf(192);
        Lit100 = Symbol.valueOf("next");
        Lit98 = Symbol.valueOf("ccid_class");
        Lit97 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit217, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 905257);
        Lit95 = Symbol.valueOf("bFunctionProtocol");
        Lit94 = Symbol.valueOf("bFunctionSubClass");
        Lit93 = Symbol.valueOf("bFunctionClass");
        Lit91 = Symbol.valueOf("bFirstInterface");
        Lit89 = Symbol.valueOf("bMaxCCIDBusySlots");
        Lit88 = Symbol.valueOf("bPINSupport");
        Lit87 = Symbol.valueOf("wLcdLayout");
        Lit86 = Symbol.valueOf("bClassEnvelope");
        Lit85 = Symbol.valueOf("bClassGetResponse");
        Lit84 = Symbol.valueOf("dwMaxCCIDMessageLength");
        Lit83 = Symbol.valueOf("dwFeatures");
        Lit82 = Symbol.valueOf("dwMechanical");
        Lit81 = Symbol.valueOf("dwSynchProtocols");
        Lit80 = Symbol.valueOf("dwMaxIFSD");
        Lit79 = Symbol.valueOf("bNumDataRatesSupported");
        Lit78 = Symbol.valueOf("dwMaxDataRate");
        Lit77 = Symbol.valueOf("dwDataRate");
        Lit76 = Symbol.valueOf("bNumClockSupported");
        Lit75 = Symbol.valueOf("dwMaximumClock");
        Lit74 = Symbol.valueOf("dwDefaultClock");
        Lit73 = Symbol.valueOf("dwProtocols");
        Lit72 = Symbol.valueOf("bVoltageSupport");
        Lit71 = Symbol.valueOf("bMaxSlotIndex");
        Lit70 = Symbol.valueOf("bcdCCID");
        Lit69 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit98, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 835672);
        Lit68 = IntNum.valueOf(33);
        Lit67 = PairWithPosition.make(Symbol.valueOf("endpoint"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 331814);
        Lit66 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit222, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 327713);
        Lit65 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit224, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 315425);
        Lit64 = PairWithPosition.make(Lit48 = Symbol.valueOf("bmAttributes"), com.ftsafe.CCIDScheme.Lit264, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 307265);
        Lit63 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit225, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 303137);
        Lit62 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit48, com.ftsafe.CCIDScheme.Lit263, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 294977);
        Lit61 = Symbol.valueOf("bInterval");
        Lit60 = Symbol.valueOf("wMaxPacketSize");
        Lit59 = Symbol.valueOf("bEndpointAddress");
        Lit57 = Symbol.valueOf("iInterface");
        Lit56 = Symbol.valueOf("bInterfaceProtocol");
        Lit55 = Symbol.valueOf("bInterfaceSubClass");
        Lit54 = Symbol.valueOf("bInterfaceClass");
        Lit53 = Symbol.valueOf("bNumEndpoints");
        Lit52 = Symbol.valueOf("bAlternateSetting");
        Lit51 = Symbol.valueOf("bInterfaceNumber");
        Lit50 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit158, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 811095);
        Lit49 = Symbol.valueOf("bMaxPower");
        Lit47 = Symbol.valueOf("iConfiguration");
        Lit46 = Symbol.valueOf("bConfigurationValue");
        Lit45 = Symbol.valueOf("bNumInterfaces");
        Lit44 = Symbol.valueOf("wTotalLength");
        Lit43 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit215, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 782400);
        Lit42 = Symbol.valueOf("bNumConfigurations");
        Lit41 = Symbol.valueOf("iSerialNumber");
        Lit40 = Symbol.valueOf("iProduct");
        Lit39 = Symbol.valueOf("iManufacture");
        Lit38 = Symbol.valueOf("bcdDevice");
        Lit37 = Symbol.valueOf("idProduct");
        Lit36 = Symbol.valueOf("idVendor");
        Lit35 = Symbol.valueOf("bMaxPacketSize0");
        Lit34 = Symbol.valueOf("bDeviceProtocol");
        Lit33 = Symbol.valueOf("bDeviceSubClass");
        Lit32 = Symbol.valueOf("bDeviceCLass");
        Lit31 = Symbol.valueOf("bcdUSB");
        Lit30 = Symbol.valueOf("bDescriptorType");
        Lit29 = Symbol.valueOf("bLength");
        Lit28 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit216, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm", 778304);
        Lit27 = Symbol.valueOf("interface0");
        Lit26 = IntNum.valueOf(18);
        Lit25 = IntNum.valueOf(256);
        Lit24 = IntNum.valueOf(1033);
        Lit20 = IntNum.valueOf(128);
        Lit19 = PairWithPosition.make(com.ftsafe.CCIDScheme.Lit105, PairWithPosition.make(com.ftsafe.CCIDScheme.Lit21, PairWithPosition.make(com.ftsafe.CCIDScheme.Lit58, PairWithPosition.make(com.ftsafe.CCIDScheme.Lit18, PairWithPosition.make(com.ftsafe.CCIDScheme.Lit99, PairWithPosition.make(com.ftsafe.CCIDScheme.Lit16, PairWithPosition.make(com.ftsafe.CCIDScheme.Lit2, com.ftsafe.CCIDScheme.Lit262, "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905240), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905238), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905236), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905234), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905232), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905230), "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm", 905227);
        Lit17 = IntNum.valueOf(48);
        Lit15 = Symbol.valueOf("get");
        Lit14 = Symbol.valueOf("add");
        Lit13 = Symbol.valueOf("set");
        Lit12 = IntNum.valueOf(-24);
        Lit11 = IntNum.valueOf(-16);
        Lit10 = IntNum.valueOf(-8);
        Lit9 = IntNum.valueOf(255);
        Lit8 = Symbol.valueOf("big");
        Lit5 = IntNum.valueOf(24);
        Lit4 = Symbol.valueOf("little");
        Lit3 = Keyword.make("endia");
        Lit0 = ArrayType.make(Type.byte_type);
        Log = (ClassNamespace)new ClassNamespace(ClassType.make("android.util.Log")).readResolve();
        Thread = Thread.class;
        CCIDScheme$frame.$instance = new CCIDScheme$frame();
        final CCIDScheme$frame $instance = CCIDScheme$frame.$instance;
        final ModuleMethod list$Mn$Gru8vector2 = new ModuleMethod($instance, 30, "list->u8vector", 4097);
        list$Mn$Gru8vector2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Type.scm:2");
        list$Mn$Gru8vector = list$Mn$Gru8vector2;
        final ModuleMethod u8vector$Mn$Grlist2 = new ModuleMethod($instance, 31, "u8vector->list", 4097);
        u8vector$Mn$Grlist2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Type.scm:9");
        u8vector$Mn$Grlist = u8vector$Mn$Grlist2;
        final ModuleMethod make$Mnu8vector2 = new ModuleMethod($instance, 32, "make-u8vector", 8193);
        make$Mnu8vector2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Type.scm:11");
        make$Mnu8vector = make$Mnu8vector2;
        final ModuleMethod object$Mn$Grstring2 = new ModuleMethod($instance, 34, "object->string", 4097);
        object$Mn$Grstring2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:4");
        object$Mn$Grstring = object$Mn$Grstring2;
        final ModuleMethod slice2 = new ModuleMethod($instance, 35, "slice", 12291);
        slice2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:8");
        slice = slice2;
        final ModuleMethod build$Mndword$Mnfromlst2 = new ModuleMethod($instance, 36, "build-dword-fromlst", -4095);
        build$Mndword$Mnfromlst2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:17");
        build$Mndword$Mnfromlst = build$Mndword$Mnfromlst2;
        final ModuleMethod build$Mndword$Mninlst2 = new ModuleMethod($instance, 37, "build-dword-inlst", -4095);
        build$Mndword$Mninlst2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:36");
        build$Mndword$Mninlst = build$Mndword$Mninlst2;
        final ModuleMethod build$Mnword$Mnfromlst2 = new ModuleMethod($instance, 38, "build-word-fromlst", -4095);
        build$Mnword$Mnfromlst2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:54");
        build$Mnword$Mnfromlst = build$Mnword$Mnfromlst2;
        final ModuleMethod build$Mnword$Mninlst2 = new ModuleMethod($instance, 39, "build-word-inlst", -4095);
        build$Mnword$Mninlst2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:68");
        build$Mnword$Mninlst = build$Mnword$Mninlst2;
        final ModuleMethod make$Mncounter2 = new ModuleMethod($instance, 40, "make-counter", 8192);
        make$Mncounter2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:82");
        make$Mncounter = make$Mncounter2;
        final ModuleMethod make$Mncontainer2 = new ModuleMethod($instance, 43, "make-container", 4097);
        make$Mncontainer2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:90");
        make$Mncontainer = make$Mncontainer2;
        final ModuleMethod to$Mnlist2 = new ModuleMethod($instance, 44, "to-list", -4095);
        to$Mnlist2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:99");
        to$Mnlist = to$Mnlist2;
        final ModuleMethod read$Mnu8s2 = new ModuleMethod($instance, 45, "read-u8s", 8194);
        read$Mnu8s2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:103");
        read$Mnu8s = read$Mnu8s2;
        final ModuleMethod call$Mnwith$Mninput$Mnu8vector2 = new ModuleMethod($instance, 46, "call-with-input-u8vector", 8194);
        call$Mnwith$Mninput$Mnu8vector2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:114");
        call$Mnwith$Mninput$Mnu8vector = call$Mnwith$Mninput$Mnu8vector2;
        final ModuleMethod lambda$Fn38 = new ModuleMethod($instance, 47, null, 4097);
        lambda$Fn38.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:122");
        lambda$Fn3 = lambda$Fn38;
        final ModuleMethod subu8list2 = new ModuleMethod($instance, 48, "subu8list", 12291);
        subu8list2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:128");
        subu8list = subu8list2;
        final ModuleMethod group$Mnlist2 = new ModuleMethod($instance, 49, "group-list", 8194);
        group$Mnlist2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:134");
        group$Mnlist = group$Mnlist2;
        filter = new ModuleMethod($instance, 50, com.ftsafe.CCIDScheme.Lit256, 8194);
        final ModuleMethod assoc$MnEX2 = new ModuleMethod($instance, 51, "assoc-EX", 8194);
        assoc$MnEX2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:150");
        assoc$MnEX = assoc$MnEX2;
        final ModuleMethod list$Mnxor2 = new ModuleMethod($instance, 52, "list-xor", 4097);
        list$Mnxor2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:159");
        list$Mnxor = list$Mnxor2;
        final ModuleMethod to$MnhexStr2 = new ModuleMethod($instance, 53, "to-hexStr", 8193);
        to$MnhexStr2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:165");
        to$MnhexStr = to$MnhexStr2;
        final ModuleMethod to$MnoctStr2 = new ModuleMethod($instance, 55, "to-octStr", 8193);
        to$MnoctStr2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:177");
        to$MnoctStr = to$MnoctStr2;
        final ModuleMethod to$MnbinStr2 = new ModuleMethod($instance, 57, "to-binStr", 8193);
        to$MnbinStr2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:189");
        to$MnbinStr = to$MnbinStr2;
        final ModuleMethod u8list$Mn$Grstring2 = new ModuleMethod($instance, 59, "u8list->string", 8193);
        u8list$Mn$Grstring2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:202");
        u8list$Mn$Grstring = u8list$Mn$Grstring2;
        final ModuleMethod in$Mnlist$Qu2 = new ModuleMethod($instance, 61, "in-list?", 8194);
        in$Mnlist$Qu2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:210");
        in$Mnlist$Qu = in$Mnlist$Qu2;
        final ModuleMethod byte$Mn$Grbit2 = new ModuleMethod($instance, 62, "byte->bit", 4097);
        byte$Mn$Grbit2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:219");
        byte$Mn$Grbit = byte$Mn$Grbit2;
        final ModuleMethod list$Mnremove$Mnduplication2 = new ModuleMethod($instance, 63, "list-remove-duplication", 4097);
        list$Mnremove$Mnduplication2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:225");
        list$Mnremove$Mnduplication = list$Mnremove$Mnduplication2;
        final ModuleMethod float$Mn$Grinteger2 = new ModuleMethod($instance, 64, "float->integer", 4097);
        float$Mn$Grinteger2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:232");
        float$Mn$Grinteger = float$Mn$Grinteger2;
        final ModuleMethod stringlst$Mn$Grstring2 = new ModuleMethod($instance, 65, "stringlst->string", 8193);
        stringlst$Mn$Grstring2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:237");
        stringlst$Mn$Grstring = stringlst$Mn$Grstring2;
        final ModuleMethod alist$Mn$Grlist2 = new ModuleMethod($instance, 67, "alist->list", 4097);
        alist$Mn$Grlist2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/util.scm:244");
        alist$Mn$Grlist = alist$Mn$Grlist2;
        final ModuleMethod get$Mnconfiguration$Mndescriptor2 = new ModuleMethod($instance, 68, "get-configuration-descriptor", 4097);
        get$Mnconfiguration$Mndescriptor2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/usb.scm:3");
        get$Mnconfiguration$Mndescriptor = get$Mnconfiguration$Mndescriptor2;
        final ModuleMethod get$Mnstring$Mndescriptor2 = new ModuleMethod($instance, 69, "get-string-descriptor", 8194);
        get$Mnstring$Mndescriptor2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/usb.scm:11");
        get$Mnstring$Mndescriptor = get$Mnstring$Mndescriptor2;
        final ModuleMethod get$Mndevice$Mndescriptor2 = new ModuleMethod($instance, 70, "get-device-descriptor", 4097);
        get$Mndevice$Mndescriptor2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/usb.scm:20");
        get$Mndevice$Mndescriptor = get$Mndevice$Mndescriptor2;
        final ModuleMethod lambda$Fn39 = new ModuleMethod($instance, 71, null, 8192);
        lambda$Fn39.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:6");
        lambda$Fn5 = lambda$Fn39;
        final ModuleMethod lambda$Fn40 = new ModuleMethod($instance, 74, null, 8194);
        lambda$Fn40.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:172");
        lambda$Fn7 = lambda$Fn40;
        final ModuleMethod lambda$Fn41 = new ModuleMethod($instance, 75, null, 4097);
        lambda$Fn41.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:124");
        lambda$Fn9 = lambda$Fn41;
        final ModuleMethod lambda$Fn42 = new ModuleMethod($instance, 76, null, 4097);
        lambda$Fn42.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:107");
        lambda$Fn10 = lambda$Fn42;
        final ModuleMethod lambda$Fn43 = new ModuleMethod($instance, 77, null, 4097);
        lambda$Fn43.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:89");
        lambda$Fn11 = lambda$Fn43;
        final ModuleMethod lambda$Fn44 = new ModuleMethod($instance, 78, null, 4097);
        lambda$Fn44.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:62");
        lambda$Fn12 = lambda$Fn44;
        final ModuleMethod lambda$Fn45 = new ModuleMethod($instance, 79, null, 4097);
        lambda$Fn45.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:31");
        lambda$Fn13 = lambda$Fn45;
        final ModuleMethod lambda$Fn46 = new ModuleMethod($instance, 80, null, 4097);
        lambda$Fn46.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:146");
        lambda$Fn14 = lambda$Fn46;
        final ModuleMethod lambda$Fn47 = new ModuleMethod($instance, 81, null, 4097);
        lambda$Fn47.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:17");
        lambda$Fn6 = lambda$Fn47;
        final ModuleMethod parse$Mndescriptor2 = new ModuleMethod($instance, 82, "parse-descriptor", 4097);
        parse$Mndescriptor2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:14");
        parse$Mndescriptor = parse$Mndescriptor2;
        final ModuleMethod get$MnvoltageSupport$Mnfrom$Mndescriptor2 = new ModuleMethod($instance, 83, "get-voltageSupport-from-descriptor", 4097);
        get$MnvoltageSupport$Mnfrom$Mndescriptor2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_descriptor.scm:226");
        get$MnvoltageSupport$Mnfrom$Mndescriptor = get$MnvoltageSupport$Mnfrom$Mndescriptor2;
        final ModuleMethod get$MnbSeq2 = new ModuleMethod($instance, 84, "get-bSeq", 4096);
        get$MnbSeq2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:3");
        get$MnbSeq = get$MnbSeq2;
        final ModuleMethod get$MnbStatus$MnbError$MnerrorName2 = new ModuleMethod($instance, 86, "get-bStatus-bError-errorName", 8194);
        get$MnbStatus$MnbError$MnerrorName2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:13");
        get$MnbStatus$MnbError$MnerrorName = get$MnbStatus$MnbError$MnerrorName2;
        final ModuleMethod pc_to_RDR_IccPowerOn = new ModuleMethod($instance, 87, "PC_to_RDR_IccPowerOn", 8194);
        pc_to_RDR_IccPowerOn.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:369");
        PC_to_RDR_IccPowerOn = pc_to_RDR_IccPowerOn;
        final ModuleMethod pc_to_RDR_XfrBlock = new ModuleMethod($instance, 88, "PC_to_RDR_XfrBlock", 16388);
        pc_to_RDR_XfrBlock.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:384");
        PC_to_RDR_XfrBlock = pc_to_RDR_XfrBlock;
        final ModuleMethod rdr_to_PC_DataBlock = new ModuleMethod($instance, 89, "RDR_to_PC_DataBlock", 4097);
        rdr_to_PC_DataBlock.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:403");
        RDR_to_PC_DataBlock = rdr_to_PC_DataBlock;
        final ModuleMethod pc_to_RDR_IccPowerOff = new ModuleMethod($instance, 90, "PC_to_RDR_IccPowerOff", 4097);
        pc_to_RDR_IccPowerOff.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:424");
        PC_to_RDR_IccPowerOff = pc_to_RDR_IccPowerOff;
        final ModuleMethod rdr_to_PC_SlotStatus = new ModuleMethod($instance, 91, "RDR_to_PC_SlotStatus", 4097);
        rdr_to_PC_SlotStatus.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:437");
        RDR_to_PC_SlotStatus = rdr_to_PC_SlotStatus;
        final ModuleMethod pc_to_RDR_SetParameters = new ModuleMethod($instance, 92, "PC_to_RDR_SetParameters", 12291);
        pc_to_RDR_SetParameters.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:460");
        PC_to_RDR_SetParameters = pc_to_RDR_SetParameters;
        final ModuleMethod rdr_to_PC_Parameters = new ModuleMethod($instance, 93, "RDR_to_PC_Parameters", 4097);
        rdr_to_PC_Parameters.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:476");
        RDR_to_PC_Parameters = rdr_to_PC_Parameters;
        final ModuleMethod pc_to_RDR_Escape = new ModuleMethod($instance, 94, "PC_to_RDR_Escape", 8194);
        pc_to_RDR_Escape.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:503");
        PC_to_RDR_Escape = pc_to_RDR_Escape;
        final ModuleMethod rdr_to_PC_Escape = new ModuleMethod($instance, 95, "RDR_to_PC_Escape", 4097);
        rdr_to_PC_Escape.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:516");
        RDR_to_PC_Escape = rdr_to_PC_Escape;
        final ModuleMethod pc_to_RDR_GetSlotStatus = new ModuleMethod($instance, 96, "PC_to_RDR_GetSlotStatus", 4097);
        pc_to_RDR_GetSlotStatus.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid_protocol.scm:538");
        PC_to_RDR_GetSlotStatus = pc_to_RDR_GetSlotStatus;
        final ModuleMethod lambda$Fn48 = new ModuleMethod($instance, 97, null, 4097);
        lambda$Fn48.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:13");
        lambda$Fn16 = lambda$Fn48;
        final ModuleMethod parse$MnATR2 = new ModuleMethod($instance, 98, "parse-ATR", 4097);
        parse$MnATR2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:2");
        parse$MnATR = parse$MnATR2;
        final ModuleMethod parse$MnatrTA2 = new ModuleMethod($instance, 99, "parse-atrTA1", 4097);
        parse$MnatrTA2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:61");
        parse$MnatrTA1 = parse$MnatrTA2;
        final ModuleMethod lambda$Fn49 = new ModuleMethod($instance, 100, null, 4097);
        lambda$Fn49.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:89");
        lambda$Fn17 = lambda$Fn49;
        final ModuleMethod get$MnatrSupportProtocol2 = new ModuleMethod($instance, 101, "get-atrSupportProtocol", 4097);
        get$MnatrSupportProtocol2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:87");
        get$MnatrSupportProtocol = get$MnatrSupportProtocol2;
        final ModuleMethod lambda$Fn50 = new ModuleMethod($instance, 102, null, 4097);
        lambda$Fn50.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:106");
        lambda$Fn18 = lambda$Fn50;
        final ModuleMethod get$MnatrTATB$Mnfor$MnT16 = new ModuleMethod($instance, 103, "get-atrTATB-for-T15", 4097);
        get$MnatrTATB$Mnfor$MnT16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:104");
        get$MnatrTATB$Mnfor$MnT15 = get$MnatrTATB$Mnfor$MnT16;
        final ModuleMethod get$Mnpps2 = new ModuleMethod($instance, 104, "get-pps1", 4097);
        get$Mnpps2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:126");
        get$Mnpps1 = get$Mnpps2;
        final ModuleMethod lambda$Fn51 = new ModuleMethod($instance, 105, null, 4097);
        lambda$Fn51.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:187");
        lambda$Fn19 = lambda$Fn51;
        final ModuleMethod generate$MnPPS$Mnexchange2 = new ModuleMethod($instance, 106, "generate-PPS-exchange", 4097);
        generate$MnPPS$Mnexchange2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:167");
        generate$MnPPS$Mnexchange = generate$MnPPS$Mnexchange2;
        final ModuleMethod get$MnatrIFSC2 = new ModuleMethod($instance, 107, "get-atrIFSC", 4097);
        get$MnatrIFSC2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:194");
        get$MnatrIFSC = get$MnatrIFSC2;
        final ModuleMethod get$MnatrTC$Mnfor$MnT2 = new ModuleMethod($instance, 108, "get-atrTC-for-T1", 4097);
        get$MnatrTC$Mnfor$MnT2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:222");
        get$MnatrTC$Mnfor$MnT1 = get$MnatrTC$Mnfor$MnT2;
        final ModuleMethod get$MnatrTB$Mnfor$MnT2 = new ModuleMethod($instance, 109, "get-atrTB-for-T1", 4097);
        get$MnatrTB$Mnfor$MnT2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:251");
        get$MnatrTB$Mnfor$MnT1 = get$MnatrTB$Mnfor$MnT2;
        final ModuleMethod generate$MnPPS$Mnparameters$MnT2 = new ModuleMethod($instance, 110, "generate-PPS-parameters-T1", 4097);
        generate$MnPPS$Mnparameters$MnT2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:279");
        generate$MnPPS$Mnparameters$MnT1 = generate$MnPPS$Mnparameters$MnT2;
        final ModuleMethod generate$MnPPS$Mnparameters$MnT3 = new ModuleMethod($instance, 111, "generate-PPS-parameters-T0", 4097);
        generate$MnPPS$Mnparameters$MnT3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:316");
        generate$MnPPS$Mnparameters$MnT0 = generate$MnPPS$Mnparameters$MnT3;
        final ModuleMethod get$MnCard$MnTimeout$MnT2 = new ModuleMethod($instance, 112, "get-Card-Timeout-T1", 4097);
        get$MnCard$MnTimeout$MnT2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:339");
        get$MnCard$MnTimeout$MnT1 = get$MnCard$MnTimeout$MnT2;
        final ModuleMethod get$MnCard$MnTimeout$MnT3 = new ModuleMethod($instance, 113, "get-Card-Timeout-T0", 4097);
        get$MnCard$MnTimeout$MnT3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:370");
        get$MnCard$MnTimeout$MnT0 = get$MnCard$MnTimeout$MnT3;
        final ModuleMethod get$MnCard$MnTimeout2 = new ModuleMethod($instance, 114, "get-Card-Timeout", 4097);
        get$MnCard$MnTimeout2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:399");
        get$MnCard$MnTimeout = get$MnCard$MnTimeout2;
        final ModuleMethod parse$MnT1Block2 = new ModuleMethod($instance, 115, "parse-T1Block", 8193);
        parse$MnT1Block2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:410");
        parse$MnT1Block = parse$MnT1Block2;
        final ModuleMethod generate$MnS$Mnblock$MnTPDU$MnT2 = new ModuleMethod($instance, 117, "generate-S-block-TPDU-T1", 8194);
        generate$MnS$Mnblock$MnTPDU$MnT2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:495");
        generate$MnS$Mnblock$MnTPDU$MnT1 = generate$MnS$Mnblock$MnTPDU$MnT2;
        final ModuleMethod generate$MnI$Mnblock$MnTPDU$MnT2 = new ModuleMethod($instance, 118, "generate-I-block-TPDU-T1", 12291);
        generate$MnI$Mnblock$MnTPDU$MnT2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:512");
        generate$MnI$Mnblock$MnTPDU$MnT1 = generate$MnI$Mnblock$MnTPDU$MnT2;
        final ModuleMethod generate$MnR$Mnblock$MnTPDU$MnT2 = new ModuleMethod($instance, 119, "generate-R-block-TPDU-T1", 8194);
        generate$MnR$Mnblock$MnTPDU$MnT2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/7816.scm:522");
        generate$MnR$Mnblock$MnTPDU$MnT1 = generate$MnR$Mnblock$MnTPDU$MnT2;
        final ModuleMethod make$MnGET_DEVICE_INF$Mnfunc2 = new ModuleMethod($instance, 120, "make-GET_DEVICE_INF-func", 8194);
        make$MnGET_DEVICE_INF$Mnfunc2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:18");
        make$MnGET_DEVICE_INF$Mnfunc = make$MnGET_DEVICE_INF$Mnfunc2;
        final ModuleMethod do$MnPPS$Mnexchange2 = new ModuleMethod($instance, 121, "do-PPS-exchange", 12291);
        do$MnPPS$Mnexchange2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:98");
        do$MnPPS$Mnexchange = do$MnPPS$Mnexchange2;
        final ModuleMethod do$MnPPS$Mnset$Mnparameters2 = new ModuleMethod($instance, 122, "do-PPS-set-parameters", 12291);
        do$MnPPS$Mnset$Mnparameters2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:110");
        do$MnPPS$Mnset$Mnparameters = do$MnPPS$Mnset$Mnparameters2;
        final ModuleMethod do$MnPPS2 = new ModuleMethod($instance, 123, "do-PPS", 12291);
        do$MnPPS2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:129");
        do$MnPPS = do$MnPPS2;
        final ModuleMethod get$Mnccid$Mnexchange$Mnlevel2 = new ModuleMethod($instance, 124, "get-ccid-exchange-level", 4097);
        get$Mnccid$Mnexchange$Mnlevel2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:169");
        get$Mnccid$Mnexchange$Mnlevel = get$Mnccid$Mnexchange$Mnlevel2;
        final ModuleMethod do$MnXfrBlock$MnTPDU$MnT0$MnProtocol2 = new ModuleMethod($instance, 125, "do-XfrBlock-TPDU-T0-Protocol", 16388);
        do$MnXfrBlock$MnTPDU$MnT0$MnProtocol2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:187");
        do$MnXfrBlock$MnTPDU$MnT0$MnProtocol = do$MnXfrBlock$MnTPDU$MnT0$MnProtocol2;
        final ModuleMethod do$MnXfrBlock$MnAPDU$MnExtended$MnProtocol2 = new ModuleMethod($instance, 126, "do-XfrBlock-APDU-Extended-Protocol", 16388);
        do$MnXfrBlock$MnAPDU$MnExtended$MnProtocol2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:204");
        do$MnXfrBlock$MnAPDU$MnExtended$MnProtocol = do$MnXfrBlock$MnAPDU$MnExtended$MnProtocol2;
        final ModuleMethod lambda$Fn52 = new ModuleMethod($instance, 127, null, 8193);
        lambda$Fn52.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:266");
        lambda$Fn21 = lambda$Fn52;
        final ModuleMethod lambda$Fn53 = new ModuleMethod($instance, 129, null, 8193);
        lambda$Fn53.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:276");
        lambda$Fn22 = lambda$Fn53;
        final ModuleMethod ifs$Mnrequest$MnTPDU$MnT1 = new ModuleMethod($instance, 131, "IFS-request-TPDU-T1", 16388);
        ifs$Mnrequest$MnTPDU$MnT1.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:284");
        IFS$Mnrequest$MnTPDU$MnT1 = ifs$Mnrequest$MnTPDU$MnT1;
        final ModuleMethod do$MnXfrBlock$MnTPDU$MnT1$MnProtocol2 = new ModuleMethod($instance, 132, "do-XfrBlock-TPDU-T1-Protocol", 20485);
        do$MnXfrBlock$MnTPDU$MnT1$MnProtocol2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:307");
        do$MnXfrBlock$MnTPDU$MnT1$MnProtocol = do$MnXfrBlock$MnTPDU$MnT1$MnProtocol2;
        final ModuleMethod lambda$Fn54 = new ModuleMethod($instance, 133, null, 4096);
        lambda$Fn54.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:377");
        lambda$Fn23 = lambda$Fn54;
        final ModuleMethod do$MnInitDescriptorInf2 = new ModuleMethod($instance, 135, "do-InitDescriptorInf", 4097);
        do$MnInitDescriptorInf2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:385");
        do$MnInitDescriptorInf = do$MnInitDescriptorInf2;
        final ModuleMethod do$MnPowerOff2 = new ModuleMethod($instance, 136, "do-PowerOff", 8193);
        do$MnPowerOff2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:394");
        do$MnPowerOff = do$MnPowerOff2;
        final ModuleMethod do$MnPowerOn2 = new ModuleMethod($instance, 138, "do-PowerOn", 16386);
        do$MnPowerOn2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:403");
        do$MnPowerOn = do$MnPowerOn2;
        final ModuleMethod do$MnEscape2 = new ModuleMethod($instance, 141, "do-Escape", 12290);
        do$MnEscape2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:485");
        do$MnEscape = do$MnEscape2;
        final ModuleMethod do$MnSlotStatus2 = new ModuleMethod($instance, 143, "do-SlotStatus", 8193);
        do$MnSlotStatus2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/ccid.scm:493");
        do$MnSlotStatus = do$MnSlotStatus2;
        final SimpleSymbol lit257 = com.ftsafe.CCIDScheme.Lit257;
        final ModuleMethod expander = new ModuleMethod(CCIDScheme$frame.$instance, 145, null, 4097);
        expander.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm:7");
        simple$Mnthread = Macro.make(lit257, expander, "com.ftsafe.CCIDScheme");
        final ModuleMethod thread$Mnsleep$Ex2 = new ModuleMethod($instance, 146, "thread-sleep!", 4097);
        thread$Mnsleep$Ex2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm:16");
        thread$Mnsleep$Ex = thread$Mnsleep$Ex2;
        final ModuleMethod make$Mnthread2 = new ModuleMethod($instance, 147, "make-thread", 4097);
        make$Mnthread2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm:20");
        make$Mnthread = make$Mnthread2;
        final ModuleMethod thread$Mnstart$Ex2 = new ModuleMethod($instance, 148, "thread-start!", 4097);
        thread$Mnstart$Ex2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/src/ccid_7816/Thread.scm:25");
        thread$Mnstart$Ex = thread$Mnstart$Ex2;
        Object = com.ftsafe.CCIDScheme.Log;
        FTReaderInf = com.ftsafe.CCIDScheme.Log;
        Context = com.ftsafe.CCIDScheme.Log;
        Handler = com.ftsafe.CCIDScheme.Log;
        final ModuleMethod get_DEVICES_INF_default = new ModuleMethod($instance, 149, "GET_DEVICES_INF_default", -4096);
        get_DEVICES_INF_default.setProperty("source-location", "ccid_7816/CCIDScheme.scm:21");
        GET_DEVICES_INF_default = get_DEVICES_INF_default;
        final ModuleMethod lambda$Fn55 = new ModuleMethod($instance, 150, null, -4096);
        lambda$Fn55.setProperty("source-location", "ccid_7816/CCIDScheme.scm:23");
        lambda$Fn29 = lambda$Fn55;
        final ModuleMethod lambda$Fn56 = new ModuleMethod($instance, 151, null, -4096);
        lambda$Fn56.setProperty("source-location", "ccid_7816/CCIDScheme.scm:24");
        lambda$Fn30 = lambda$Fn56;
        final ModuleMethod lambda$Fn57 = new ModuleMethod($instance, 152, null, -4096);
        lambda$Fn57.setProperty("source-location", "ccid_7816/CCIDScheme.scm:25");
        lambda$Fn31 = lambda$Fn57;
        final ModuleMethod lambda$Fn58 = new ModuleMethod($instance, 153, null, -4096);
        lambda$Fn58.setProperty("source-location", "ccid_7816/CCIDScheme.scm:26");
        lambda$Fn32 = lambda$Fn58;
        final ModuleMethod lambda$Fn59 = new ModuleMethod($instance, 154, null, -4096);
        lambda$Fn59.setProperty("source-location", "ccid_7816/CCIDScheme.scm:27");
        lambda$Fn33 = lambda$Fn59;
        CCIDScheme = CCIDScheme.class;
        final ModuleMethod lambda$Fn60 = new ModuleMethod($instance, 155, null, 8194);
        lambda$Fn60.setProperty("source-location", "ccid_7816/CCIDScheme.scm:68");
        lambda$Fn37 = lambda$Fn60;
        $runBody$();
    }
    
    static Object lambda64(final Object x) {
        final Object[] allocVars = SyntaxPattern.allocVars(2, null);
        return com.ftsafe.CCIDScheme.Lit258.match(x, allocVars, 0) ? com.ftsafe.CCIDScheme.Lit259.execute(allocVars, TemplateScope.make()) : syntax_case.error("syntax-case", x);
    }
}
